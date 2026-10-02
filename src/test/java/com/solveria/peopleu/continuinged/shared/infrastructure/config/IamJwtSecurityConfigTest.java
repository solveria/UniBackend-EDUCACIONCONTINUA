package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.ImmutableSecret;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import javax.crypto.spec.SecretKeySpec;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

/**
 * Las reglas de validacion con un par RSA generado aca: la clave de IAM (la que firma) y una ajena
 * (la que no). El origen real de las claves, el JWKS de IAM, no entra en este test.
 */
class IamJwtSecurityConfigTest {
    private static final String AUDIENCE = "peopleschool-api";
    private static final KeyPair IAM_KEY = rsaKeyPair();
    private static final KeyPair OTHER_KEY = rsaKeyPair();

    private StringRedisTemplate redisTemplate;
    private JwtDecoder decoder;

    @BeforeEach
    void setUp() {
        redisTemplate = mock(StringRedisTemplate.class);
        when(redisTemplate.hasKey(anyString())).thenReturn(false);
        NimbusJwtDecoder rs256 =
                NimbusJwtDecoder.withPublicKey((RSAPublicKey) IAM_KEY.getPublic())
                        .signatureAlgorithm(SignatureAlgorithm.RS256)
                        .build();
        decoder =
                IamJwtSecurityConfig.withIamValidators(
                        rs256, "iam-service", AUDIENCE, redisTemplate);
    }

    @Test
    void acceptsValidAccessTokenAndChecksRevocation() {
        Jwt jwt = decoder.decode(token("iam-service", List.of(AUDIENCE), "access", "jti-1"));

        assertThat(jwt.getSubject()).isEqualTo("123");
        verify(redisTemplate).hasKey("iam:blacklist:access:jti-1");
    }

    @Test
    void rejectsRefreshToken() {
        assertRejected(token("iam-service", List.of(AUDIENCE), "refresh", "jti-refresh"));
    }

    @Test
    void rejectsWrongIssuer() {
        assertRejected(token("other-issuer", List.of(AUDIENCE), "access", "jti-issuer"));
    }

    @Test
    void rejectsWrongAudience() {
        assertRejected(token("iam-service", List.of("other-audience"), "access", "jti-audience"));
    }

    @Test
    void rejectsMissingTokenId() {
        assertRejected(token("iam-service", List.of(AUDIENCE), "access", null));
    }

    @Test
    void rejectsExpiredToken() {
        assertRejected(
                token(
                        "iam-service",
                        List.of(AUDIENCE),
                        "access",
                        "jti-expired",
                        IAM_KEY,
                        Instant.now().minusSeconds(120)));
    }

    @Test
    void rejectsTokenSignedWithAnotherKey() {
        assertRejected(
                token(
                        "iam-service",
                        List.of(AUDIENCE),
                        "access",
                        "jti-signature",
                        OTHER_KEY,
                        Instant.now().plus(Duration.ofMinutes(5))));
    }

    /**
     * Un token HS256 firmado con cualquier secreto tiene que rebotar aunque lleve claims perfectos:
     * el algoritmo lo fija el servicio, no la cabecera del token.
     */
    @Test
    void rejectsHmacSignedToken() {
        assertRejected(hmacToken("jti-hmac"));
    }

    @Test
    void rejectsRevokedToken() {
        when(redisTemplate.hasKey("iam:blacklist:access:jti-revoked")).thenReturn(true);

        assertThatThrownBy(
                        () ->
                                decoder.decode(
                                        token(
                                                "iam-service",
                                                List.of(AUDIENCE),
                                                "access",
                                                "jti-revoked")))
                .isInstanceOf(JwtException.class)
                .hasMessageContaining("Access token has been revoked");
    }

    @Test
    void rejectsTokenWhenRevocationServiceIsUnavailable() {
        when(redisTemplate.hasKey("iam:blacklist:access:jti-redis-down"))
                .thenThrow(new IllegalStateException("redis down"));

        assertThatThrownBy(
                        () ->
                                decoder.decode(
                                        token(
                                                "iam-service",
                                                List.of(AUDIENCE),
                                                "access",
                                                "jti-redis-down")))
                .isInstanceOf(JwtException.class)
                .hasMessageContaining("Token revocation service unavailable");
    }

    /**
     * Un token canjeado lleva en session_jti el jti del token de sesion del que salio. Si esa
     * sesion cerro, el canje cae con ella aunque su propio jti no este en la lista negra.
     */
    @Test
    void rejectsTokenWhoseSessionWasRevoked() {
        when(redisTemplate.hasKey("iam:blacklist:access:jti-sesion")).thenReturn(true);

        assertThatThrownBy(() -> decoder.decode(tokenWithSession("jti-canje", "jti-sesion")))
                .isInstanceOf(JwtException.class)
                .hasMessageContaining("Access token has been revoked");
    }

    @Test
    void acceptsExchangedTokenWhoseSessionIsAlive() {
        Jwt jwt = decoder.decode(tokenWithSession("jti-canje-2", "jti-sesion-viva"));

        assertThat(jwt.getClaimAsString("session_jti")).isEqualTo("jti-sesion-viva");
        verify(redisTemplate).hasKey("iam:blacklist:access:jti-sesion-viva");
    }

    private void assertRejected(String token) {
        assertThatThrownBy(() -> decoder.decode(token)).isInstanceOf(JwtException.class);
    }

    private static String token(
            String issuer, List<String> audience, String tokenType, String tokenId) {
        return token(
                issuer,
                audience,
                tokenType,
                tokenId,
                IAM_KEY,
                Instant.now().plus(Duration.ofMinutes(5)));
    }

    private static String token(
            String issuer,
            List<String> audience,
            String tokenType,
            String tokenId,
            KeyPair signingKey,
            Instant expiresAt) {
        RSAKey jwk =
                new RSAKey.Builder((RSAPublicKey) signingKey.getPublic())
                        .privateKey((RSAPrivateKey) signingKey.getPrivate())
                        .keyID("test-kid")
                        .build();
        NimbusJwtEncoder encoder = new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(jwk)));
        return encoder.encode(
                        JwtEncoderParameters.from(
                                JwsHeader.with(SignatureAlgorithm.RS256).keyId("test-kid").build(),
                                claims(issuer, audience, tokenType, tokenId, expiresAt)))
                .getTokenValue();
    }

    private static String tokenWithSession(String tokenId, String sessionTokenId) {
        RSAKey jwk =
                new RSAKey.Builder((RSAPublicKey) IAM_KEY.getPublic())
                        .privateKey((RSAPrivateKey) IAM_KEY.getPrivate())
                        .keyID("test-kid")
                        .build();
        NimbusJwtEncoder encoder = new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(jwk)));
        JwtClaimsSet base =
                claims(
                        "iam-service",
                        List.of(AUDIENCE),
                        "access",
                        tokenId,
                        Instant.now().plus(Duration.ofMinutes(5)));
        JwtClaimsSet withSession =
                JwtClaimsSet.from(base).claim("session_jti", sessionTokenId).build();
        return encoder.encode(
                        JwtEncoderParameters.from(
                                JwsHeader.with(SignatureAlgorithm.RS256).keyId("test-kid").build(),
                                withSession))
                .getTokenValue();
    }

    private static String hmacToken(String tokenId) {
        SecretKeySpec secret =
                new SecretKeySpec(
                        "test-secret-key-with-at-least-32-bytes".getBytes(StandardCharsets.UTF_8),
                        "HmacSHA256");
        NimbusJwtEncoder encoder = new NimbusJwtEncoder(new ImmutableSecret<>(secret));
        return encoder.encode(
                        JwtEncoderParameters.from(
                                JwsHeader.with(MacAlgorithm.HS256).build(),
                                claims(
                                        "iam-service",
                                        List.of(AUDIENCE),
                                        "access",
                                        tokenId,
                                        Instant.now().plus(Duration.ofMinutes(5)))))
                .getTokenValue();
    }

    private static JwtClaimsSet claims(
            String issuer,
            List<String> audience,
            String tokenType,
            String tokenId,
            Instant expiresAt) {
        Instant now = Instant.now();
        Instant issuedAt = expiresAt.isAfter(now) ? now.minusSeconds(1) : expiresAt.minusSeconds(1);
        JwtClaimsSet.Builder claims =
                JwtClaimsSet.builder()
                        .subject("123")
                        .issuer(issuer)
                        .audience(audience)
                        .issuedAt(issuedAt)
                        .expiresAt(expiresAt)
                        .claim("token_type", tokenType);
        if (tokenId != null) {
            claims.id(tokenId);
        }
        return claims.build();
    }

    private static KeyPair rsaKeyPair() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            return generator.generateKeyPair();
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException(ex);
        }
    }
}
