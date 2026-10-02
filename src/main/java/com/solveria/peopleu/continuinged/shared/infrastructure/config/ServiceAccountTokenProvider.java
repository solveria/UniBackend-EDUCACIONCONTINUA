package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * Token propio del servicio, para las llamadas que NO nacen de una request de un usuario.
 *
 * <p>{@link BearerTokenForwardingInterceptor} reenvia el token de la request entrante, y eso
 * alcanza mientras alguien este del otro lado. El relay del outbox no: lo dispara un scheduler, sin
 * usuario y sin request. Sin token, el destino responde 401 y ningun evento sale nunca de aca.
 *
 * <p>El token se pide a IAM con las credenciales de la cuenta de servicio ({@code
 * peopleu-continuing-education-service}) y se guarda hasta poco antes de que expire. Si IAM no
 * contesta se devuelve vacio y el relay reintenta en la vuelta siguiente: el outbox ya reintenta
 * por diseno.
 */
@Component
public class ServiceAccountTokenProvider {

    private static final Logger log = LoggerFactory.getLogger(ServiceAccountTokenProvider.class);
    private static final Duration MARGEN = Duration.ofSeconds(60);

    private final RestClient iamClient;
    private final String clientId;
    private final String clientSecret;
    private final String tenantId;
    private final boolean enabled;

    private final Map<String, Cached> cache = new ConcurrentHashMap<>();

    public ServiceAccountTokenProvider(
            RestClient.Builder builder,
            @Value("${peopleu.service-account.iam-url:${IAM_SERVICE_URL:http://localhost:8080}}")
                    String iamUrl,
            @Value("${peopleu.service-account.client-id:peopleu-continuing-education-service}")
                    String clientId,
            @Value("${peopleu.service-account.client-secret}") String clientSecret,
            @Value("${peopleu.service-account.tenant-id}") String tenantId,
            @Value("${security.jwt.enabled:true}") boolean enabled) {
        this.iamClient = builder.baseUrl(iamUrl).build();
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tenantId = tenantId;
        this.enabled = enabled;
    }

    /**
     * El token para la audiencia por defecto de IAM. {@code null} si no hace falta o IAM no
     * contesta.
     */
    public String token() {
        return token(null);
    }

    /**
     * El token propio del servicio para hablarle a {@code audience} (el nombre del servicio
     * destino, o {@code null} para la audiencia por defecto de IAM). Cada audiencia tiene su token
     * y su vencimiento; se pide a IAM con {@code audience} en el cuerpo de {@code
     * /auth/service-token}, y se guarda hasta un minuto antes de que expire. {@code null} si no
     * hace falta (JWT apagado) o si IAM no contesta.
     */
    public String token(String audience) {
        if (!enabled) {
            return null;
        }
        String key = audience == null ? "" : audience;
        Cached vigente = cache.get(key);
        if (vigente != null && Instant.now().isBefore(vigente.expiraEn)) {
            return vigente.token;
        }
        return renovar(key, audience);
    }

    private synchronized String renovar(String key, String audience) {
        Cached vigente = cache.get(key);
        if (vigente != null && Instant.now().isBefore(vigente.expiraEn)) {
            return vigente.token;
        }
        try {
            Map<String, Object> cuerpo = new HashMap<>();
            cuerpo.put("clientId", clientId);
            cuerpo.put("clientSecret", clientSecret);
            if (audience != null && !audience.isBlank()) {
                cuerpo.put("audience", audience);
            }
            @SuppressWarnings("unchecked")
            Map<String, Object> respuesta =
                    iamClient
                            .post()
                            .uri("/auth/service-token")
                            .header("X-Tenant-Id", tenantId)
                            .body(cuerpo)
                            .retrieve()
                            .body(Map.class);
            if (respuesta == null || respuesta.get("accessToken") == null) {
                log.warn("IAM no devolvio token para la cuenta de servicio {}", clientId);
                return null;
            }
            String token = respuesta.get("accessToken").toString();
            long duracion =
                    respuesta.get("expiresIn") instanceof Number segundos
                            ? segundos.longValue()
                            : 300L;
            cache.put(key, new Cached(token, Instant.now().plusSeconds(duracion).minus(MARGEN)));
            return token;
        } catch (RuntimeException exception) {
            // Sin token no se hace esta vuelta; el scheduler reintenta en la siguiente.
            log.warn(
                    "No se pudo obtener el token de servicio {}: {}",
                    clientId,
                    exception.getMessage());
            return null;
        }
    }

    private record Cached(String token, Instant expiraEn) {}
}
