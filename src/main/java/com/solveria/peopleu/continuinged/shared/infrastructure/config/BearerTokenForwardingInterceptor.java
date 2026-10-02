package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import java.io.IOException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Pone el {@code Authorization} en las llamadas salientes a otros servicios.
 *
 * <p>Con una request entrante, va el token de la persona que esta del otro lado, <b>canjeado</b> en
 * IAM por uno que nombre al servicio destino ({@link IamTokenExchangeClient}): cada servicio valida
 * su propia audiencia, y el token de la persona solo lo nombra a el. El destino sigue viendo a la
 * persona como sujeto y a este servicio como actor ({@code act}). Si el canje falla, va el token
 * original, que mientras IAM este en modo {@code all} tambien sirve.
 *
 * <p>Sin request entrante (un scheduler) o sin token en ella, va el token propio del servicio,
 * pedido para la audiencia del destino. Es el caso de los barridos y relays que ya existian.
 */
@Component
public class BearerTokenForwardingInterceptor implements ClientHttpRequestInterceptor {

    private final IamTokenExchangeClient exchange;
    private final ServiceAccountTokenProvider serviceAccountToken;

    public BearerTokenForwardingInterceptor(
            IamTokenExchangeClient exchange, ServiceAccountTokenProvider serviceAccountToken) {
        this.exchange = exchange;
        this.serviceAccountToken = serviceAccountToken;
    }

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
            throws IOException {
        String audience = exchange.audienceFor(request.getURI().toString());
        if (RequestContextHolder.getRequestAttributes()
                instanceof ServletRequestAttributes servletAttributes) {
            String authorization =
                    servletAttributes.getRequest().getHeader(HttpHeaders.AUTHORIZATION);
            if (authorization != null && authorization.regionMatches(true, 0, "Bearer ", 0, 7)) {
                String incoming = authorization.substring(7).trim();
                String exchanged =
                        audience == null
                                ? null
                                : exchange.exchange(
                                        incoming, audience, serviceAccountToken.token(audience));
                request.getHeaders().setBearerAuth(exchanged != null ? exchanged : incoming);
                return execution.execute(request, body);
            }
        }
        // Sin request entrante (scheduler) o sin token en ella: va el del servicio.
        String propio = serviceAccountToken.token(audience);
        if (propio != null && !propio.isBlank()) {
            request.getHeaders().setBearerAuth(propio);
        }
        return execution.execute(request, body);
    }
}
