package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * Canjea en IAM el token que llego por uno que nombre al servicio al que vamos a llamar.
 *
 * <p>Cada servicio valida que el token lo nombre a el ({@code aud}). Mientras IAM este en modo
 * {@code all}, el token de una persona ya nombra a todos y el canje no cambia nada; en modo {@code
 * session-only} es lo unico que hace que reenviar el token de la persona a otro servicio funcione.
 * Se hace siempre, para que el camino este probado antes de necesitarlo.
 *
 * <p>El token canjeado se guarda hasta un minuto antes de vencer, por (token de origen, destino).
 * Si IAM no contesta, se devuelve {@code null} y quien llama manda el token original: en modo
 * {@code all} sigue andando; en {@code session-only} el destino responde 401, que es visible.
 */
@Component
@EnableConfigurationProperties(IamTokenExchangeClient.OutboundProperties.class)
public class IamTokenExchangeClient {

    private static final Logger log = LoggerFactory.getLogger(IamTokenExchangeClient.class);
    private static final Duration MARGIN = Duration.ofSeconds(60);

    private final RestClient iamClient;
    private final OutboundProperties properties;
    private final Map<String, Cached> cache = new ConcurrentHashMap<>();

    public IamTokenExchangeClient(RestClient.Builder builder, OutboundProperties properties) {
        this.iamClient = builder.baseUrl(properties.iamUrl()).build();
        this.properties = properties;
    }

    public boolean enabled() {
        return properties.exchangeEnabled();
    }

    /** La audiencia del servicio al que va esa URL, o {@code null} si no es un destino conocido. */
    public String audienceFor(String url) {
        if (url == null) {
            return null;
        }
        for (OutboundProperties.Destination destination : properties.audiences()) {
            if (destination.baseUrl() != null
                    && !destination.baseUrl().isBlank()
                    && url.startsWith(destination.baseUrl())) {
                return destination.audience();
            }
        }
        return null;
    }

    /**
     * El token para {@code audience} que representa a {@code subjectToken}. {@code actorToken} es
     * el token propio de este servicio, si lo tiene: queda en el claim {@code act} del canje.
     * {@code null} si IAM no pudo.
     */
    public String exchange(String subjectToken, String audience, String actorToken) {
        if (!properties.exchangeEnabled() || subjectToken == null || audience == null) {
            return null;
        }
        String key = fingerprint(subjectToken) + "|" + audience;
        Cached cached = cache.get(key);
        if (cached != null && Instant.now().isBefore(cached.expiresAt)) {
            return cached.token;
        }
        try {
            Map<String, Object> body =
                    actorToken == null
                            ? Map.of("subjectToken", subjectToken, "audience", audience)
                            : Map.of(
                                    "subjectToken", subjectToken,
                                    "audience", audience,
                                    "actorToken", actorToken);
            @SuppressWarnings("unchecked")
            Map<String, Object> response =
                    iamClient
                            .post()
                            .uri("/auth/token/exchange")
                            .body(body)
                            .retrieve()
                            .body(Map.class);
            if (response == null || response.get("accessToken") == null) {
                log.warn("event=IAM_TOKEN_EXCHANGE_EMPTY audience={}", audience);
                return null;
            }
            String token = response.get("accessToken").toString();
            long seconds = response.get("expiresIn") instanceof Number n ? n.longValue() : 60L;
            Instant expiresAt = Instant.now().plusSeconds(seconds).minus(MARGIN);
            if (expiresAt.isAfter(Instant.now())) {
                cache.put(key, new Cached(token, expiresAt));
            }
            if (cache.size() > 5000) {
                cache.entrySet().removeIf(e -> Instant.now().isAfter(e.getValue().expiresAt));
            }
            return token;
        } catch (RuntimeException exception) {
            log.warn(
                    "event=IAM_TOKEN_EXCHANGE_FAILED audience={} error={}",
                    audience,
                    exception.getMessage());
            return null;
        }
    }

    private static String fingerprint(String token) {
        try {
            byte[] digest =
                    MessageDigest.getInstance("SHA-256")
                            .digest(token.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(digest);
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("SHA-256 is not available", ex);
        }
    }

    private record Cached(String token, Instant expiresAt) {}

    /**
     * {@code security.jwt.outbound.*}: si se canjea, donde esta IAM, y que audiencia corresponde a
     * cada URL base a la que este servicio llama.
     */
    @ConfigurationProperties(prefix = "security.jwt.outbound")
    public record OutboundProperties(
            boolean exchangeEnabled, String iamUrl, List<Destination> audiences) {

        public OutboundProperties {
            iamUrl = iamUrl == null || iamUrl.isBlank() ? "http://localhost:8080" : iamUrl.trim();
            audiences = audiences == null ? List.of() : List.copyOf(audiences);
        }

        public record Destination(String baseUrl, String audience) {}
    }
}
