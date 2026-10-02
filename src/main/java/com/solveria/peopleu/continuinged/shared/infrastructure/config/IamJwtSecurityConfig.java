package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import java.time.Instant;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.core.DelegatingOAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimValidator;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtValidators;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

/**
 * Como se verifica un token de IAM en este servicio.
 *
 * <p>La firma se comprueba con las claves publicas que IAM expone en {@code /.well-known/jwks.json}
 * (RS256). Este servicio no tiene, ni necesita, ningun secreto de firma: hasta el 1 de octubre de
 * 2026 compartia con IAM una clave HS256 que estaba escrita en los {@code docker-compose.yml}, y
 * con ella cualquiera fabricaba un token de administrador. El JWKS se lee una vez y se cachea; ante
 * un {@code kid} desconocido se vuelve a pedir, asi IAM rota su clave sin que haya que reiniciar
 * nada aca.
 *
 * <p>La audiencia es el nombre de ESTE servicio ({@code peopleu-continuing-education-service}): un
 * token que no lo nombre no entra, aunque sea de IAM y valido en otro servicio. IAM nombra a todos
 * los servicios en el token del login mientras este en modo {@code all}; en modo {@code
 * session-only} el frontend y los demas servicios canjean el token por uno para este destino
 * ({@code /auth/token/exchange}).
 *
 * <p>Revocacion en Redis, por token y por persona. Un token canjeado lleva en {@code session_jti}
 * el {@code jti} del token de sesion que lo origino, y se consulta tambien: cerrar sesion revoca la
 * sesion y todos sus canjes.
 */
@Configuration
public class IamJwtSecurityConfig {

    private static final String REVOCATION_KEY_PREFIX = "iam:blacklist:access:";
    private static final String USER_REVOCATION_KEY_PREFIX = "iam:user-revoked:";

    @Bean(name = "accessTokenJwtDecoder")
    JwtDecoder accessTokenJwtDecoder(
            @Value("${security.jwt.issuer:iam-service}") String issuer,
            @Value("${security.jwt.jwk-set-uri:http://localhost:8080/.well-known/jwks.json}")
                    String jwkSetUri,
            @Value("${security.jwt.audience:peopleu-continuing-education-service}") String audience,
            @Qualifier("iamRevocationRedisTemplate") StringRedisTemplate redisTemplate) {
        NimbusJwtDecoder decoder =
                NimbusJwtDecoder.withJwkSetUri(jwkSetUri)
                        .jwsAlgorithm(SignatureAlgorithm.RS256)
                        .build();
        return withIamValidators(decoder, issuer, audience, redisTemplate);
    }

    /**
     * Las reglas que todo token de IAM tiene que cumplir ademas de la firma. Separado del origen de
     * las claves para que el test las pruebe con un par RSA propio, sin un IAM levantado.
     */
    static NimbusJwtDecoder withIamValidators(
            NimbusJwtDecoder decoder,
            String issuer,
            String audience,
            StringRedisTemplate redisTemplate) {
        OAuth2TokenValidator<Jwt> audienceValidator =
                new JwtClaimValidator<List<String>>(
                        "aud", claim -> claim != null && claim.contains(audience));
        OAuth2TokenValidator<Jwt> accessTypeValidator =
                new JwtClaimValidator<String>("token_type", "access"::equals);
        OAuth2TokenValidator<Jwt> idValidator =
                new JwtClaimValidator<String>("jti", value -> value != null && !value.isBlank());

        decoder.setJwtValidator(
                new DelegatingOAuth2TokenValidator<>(
                        JwtValidators.createDefaultWithIssuer(issuer),
                        audienceValidator,
                        accessTypeValidator,
                        idValidator,
                        new RevokedAccessTokenValidator(redisTemplate)));
        return decoder;
    }

    @Bean(name = "iamRevocationRedisConnectionFactory")
    LettuceConnectionFactory iamRevocationRedisConnectionFactory(
            @Value("${security.jwt.revocation.redis.host:localhost}") String host,
            @Value("${security.jwt.revocation.redis.port:6379}") int port,
            @Value("${security.jwt.revocation.redis.database:0}") int database,
            @Value("${security.jwt.revocation.redis.password:}") String password) {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
        configuration.setDatabase(database);
        if (!password.isBlank()) {
            configuration.setPassword(RedisPassword.of(password));
        }
        return new LettuceConnectionFactory(configuration);
    }

    @Bean(name = "iamRevocationRedisTemplate")
    StringRedisTemplate iamRevocationRedisTemplate(
            @Qualifier("iamRevocationRedisConnectionFactory")
                    RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    private static final class RevokedAccessTokenValidator implements OAuth2TokenValidator<Jwt> {

        private static final Logger log =
                LoggerFactory.getLogger(RevokedAccessTokenValidator.class);
        private final StringRedisTemplate redisTemplate;

        private RevokedAccessTokenValidator(StringRedisTemplate redisTemplate) {
            this.redisTemplate = redisTemplate;
        }

        @Override
        public OAuth2TokenValidatorResult validate(Jwt token) {
            String tokenId = token.getId();
            try {
                if (Boolean.TRUE.equals(redisTemplate.hasKey(REVOCATION_KEY_PREFIX + tokenId))) {
                    return OAuth2TokenValidatorResult.failure(
                            new OAuth2Error(
                                    "invalid_token", "Access token has been revoked", null));
                }
                String sessionTokenId = token.getClaimAsString("session_jti");
                if (sessionTokenId != null
                        && !sessionTokenId.isBlank()
                        && Boolean.TRUE.equals(
                                redisTemplate.hasKey(REVOCATION_KEY_PREFIX + sessionTokenId))) {
                    return OAuth2TokenValidatorResult.failure(
                            new OAuth2Error(
                                    "invalid_token", "Access token has been revoked", null));
                }
                if (usuarioRevocado(token)) {
                    return OAuth2TokenValidatorResult.failure(
                            new OAuth2Error(
                                    "invalid_token", "Access token has been revoked", null));
                }
                return OAuth2TokenValidatorResult.success();
            } catch (RuntimeException exception) {
                log.error("event=IAM_REVOCATION_LOOKUP_FAILED tokenId={}", tokenId, exception);
                return OAuth2TokenValidatorResult.failure(
                        new OAuth2Error(
                                "invalid_token", "Token revocation service unavailable", null));
            }
        }

        /**
         * Si a esta persona le cerraron todas las sesiones despues de que se emitiera este token.
         *
         * <p>La lista negra de arriba solo conoce tokens sueltos, uno por logout. Cuando alguien
         * cambia su contrasena o aprieta "cerrar todas mis sesiones", IAM no puede enumerar los
         * access token que ya estan circulando: no los guarda. Deja en su lugar una marca con el
         * instante del corte, y cada servicio compara contra ella.
         *
         * <p>Se compara con el {@code iat} y no se rechaza a ciegas para que el token que la
         * persona reciba al volver a entrar, que es posterior al corte, siga valiendo. Un token
         * canjeado conserva el {@code iat} del original, asi que la marca lo alcanza igual.
         */
        private boolean usuarioRevocado(Jwt token) {
            if (!"USER".equalsIgnoreCase(token.getClaimAsString("subjectType"))) {
                return false;
            }
            String tenantId = token.getClaimAsString("tenant_id");
            if (tenantId == null || tenantId.isBlank()) {
                tenantId = token.getClaimAsString("tenantId");
            }
            String userId = token.getSubject();
            Instant issuedAt = token.getIssuedAt();
            if (tenantId == null || tenantId.isBlank() || userId == null || issuedAt == null) {
                return false;
            }

            String marca =
                    redisTemplate
                            .opsForValue()
                            .get(USER_REVOCATION_KEY_PREFIX + tenantId + ":" + userId);
            if (marca == null || marca.isBlank()) {
                return false;
            }
            try {
                return issuedAt.getEpochSecond() < Long.parseLong(marca.trim());
            } catch (NumberFormatException ex) {
                // Una marca ilegible es un error nuestro, no un ataque: no se echa a nadie por
                // ella. Queda en el log para que se vea.
                log.warn("event=IAM_USER_REVOCATION_MARK_INVALID value={}", marca);
                return false;
            }
        }
    }
}
