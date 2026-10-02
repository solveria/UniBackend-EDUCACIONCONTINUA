package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.mock.http.client.MockClientHttpRequest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClient;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * El canje saliente: el token de la persona que llego se cambia en IAM por uno para el destino, se
 * cachea, y si IAM no contesta va el original.
 */
class IamTokenExchangeClientTest {

    private static final String IAM = "http://iam.test";
    private static final String TRANSVERSAL = "http://transversal.test";

    private MockRestServiceServer iam;
    private IamTokenExchangeClient client;

    @BeforeEach
    void setUp() {
        RestClient.Builder builder = RestClient.builder();
        iam = MockRestServiceServer.bindTo(builder).build();
        client =
                new IamTokenExchangeClient(
                        builder,
                        new IamTokenExchangeClient.OutboundProperties(
                                true,
                                IAM,
                                List.of(
                                        new IamTokenExchangeClient.OutboundProperties.Destination(
                                                TRANSVERSAL, "transversal-service"))));
    }

    @AfterEach
    void tearDown() {
        RequestContextHolder.resetRequestAttributes();
    }

    @Test
    void resolvesTheAudienceByDestinationBaseUrl() {
        assertThat(client.audienceFor(TRANSVERSAL + "/api/v1/mt03/schools"))
                .isEqualTo("transversal-service");
        assertThat(client.audienceFor("http://otro.test/api")).isNull();
    }

    @Test
    void exchangesOnceAndCachesUntilExpiry() {
        iam.expect(ExpectedCount.once(), requestTo(IAM + "/auth/token/exchange"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(
                        content()
                                .string(
                                        org.hamcrest.Matchers.containsString(
                                                "\"audience\":\"transversal-service\"")))
                .andRespond(
                        withSuccess(
                                "{\"accessToken\":\"para-transversal\",\"expiresIn\":600}",
                                MediaType.APPLICATION_JSON));

        assertThat(client.exchange("sesion", "transversal-service", null))
                .isEqualTo("para-transversal");
        assertThat(client.exchange("sesion", "transversal-service", null))
                .isEqualTo("para-transversal");
        iam.verify();
    }

    @Test
    void returnsNullWhenIamFails() {
        iam.expect(requestTo(IAM + "/auth/token/exchange")).andRespond(withServerError());

        assertThat(client.exchange("sesion", "transversal-service", null)).isNull();
    }

    @Test
    void interceptorForwardsTheExchangedTokenToAKnownDestination() throws IOException {
        iam.expect(requestTo(IAM + "/auth/token/exchange"))
                .andRespond(
                        withSuccess(
                                "{\"accessToken\":\"canjeado\",\"expiresIn\":600}",
                                MediaType.APPLICATION_JSON));
        MockHttpServletRequest incoming = new MockHttpServletRequest();
        incoming.addHeader(HttpHeaders.AUTHORIZATION, "Bearer sesion");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(incoming));
        ServiceAccountTokenProvider provider = mock(ServiceAccountTokenProvider.class);
        when(provider.token(any())).thenReturn(null);
        BearerTokenForwardingInterceptor interceptor =
                new BearerTokenForwardingInterceptor(client, provider);

        MockClientHttpRequest outgoing =
                new MockClientHttpRequest(
                        HttpMethod.GET, URI.create(TRANSVERSAL + "/api/v1/mt03/schools"));
        ClientHttpRequestExecution execution =
                (request, body) -> {
                    assertThat(request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
                            .isEqualTo("Bearer canjeado");
                    return mock(ClientHttpResponse.class);
                };
        interceptor.intercept(outgoing, new byte[0], execution);
    }

    @Test
    void interceptorKeepsTheOriginalTokenWhenTheDestinationIsUnknownOrIamFails()
            throws IOException {
        iam.expect(ExpectedCount.manyTimes(), requestTo(IAM + "/auth/token/exchange"))
                .andRespond(withServerError());
        MockHttpServletRequest incoming = new MockHttpServletRequest();
        incoming.addHeader(HttpHeaders.AUTHORIZATION, "Bearer sesion");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(incoming));
        ServiceAccountTokenProvider provider = mock(ServiceAccountTokenProvider.class);
        BearerTokenForwardingInterceptor interceptor =
                new BearerTokenForwardingInterceptor(client, provider);

        for (String url : List.of(TRANSVERSAL + "/api/v1/x", "http://otro.test/api")) {
            MockClientHttpRequest outgoing =
                    new MockClientHttpRequest(HttpMethod.GET, URI.create(url));
            ClientHttpRequestExecution execution =
                    (request, body) -> {
                        assertThat(request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION))
                                .isEqualTo("Bearer sesion");
                        return mock(ClientHttpResponse.class);
                    };
            interceptor.intercept(outgoing, new byte[0], execution);
        }
    }
}
