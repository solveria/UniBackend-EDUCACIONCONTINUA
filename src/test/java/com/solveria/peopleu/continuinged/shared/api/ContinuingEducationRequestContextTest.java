package com.solveria.peopleu.continuinged.shared.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.solveria.peopleu.continuinged.shared.application.exception.ContinuingEducationApplicationException;
import com.solveria.peopleu.continuinged.shared.application.exception.ContinuingEducationErrorCodes;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

/** De donde sale el actor: la persona de CT-04, el administrador de plataforma, o nadie. */
class ContinuingEducationRequestContextTest {

    private static final UUID TENANT = UUID.fromString("22222222-2222-2222-2222-222222222222");
    private static final UUID PERSON = UUID.fromString("33333333-3333-3333-3333-333333333333");

    private final ContinuingEducationRequestContext context =
            new ContinuingEducationRequestContext(true, false);

    @Test
    @DisplayName("con person_id el actor es la persona y los scopes viajan tal cual")
    void personIsTheActor() {
        Authentication auth =
                jwt(
                        Map.of(
                                "tenant_id", TENANT.toString(),
                                "person_id", PERSON.toString(),
                                "username", "ana.perez",
                                "roles", List.of("SECRETARIA_ACADEMICA"),
                                "scopes", List.of("TENANT")));

        ContinuingEducationRequestContext.Context resolved =
                context.resolve(auth, null, null, null);

        assertThat(resolved.tenantId()).isEqualTo(TENANT);
        assertThat(resolved.actorId()).isEqualTo(PERSON);
        assertThat(resolved.actorName()).isEqualTo("ana.perez");
        assertThat(resolved.institutionalScopes()).containsExactly("TENANT");
    }

    @Test
    @DisplayName(
            "sin person_id, el administrador de la plataforma opera con un id derivado y estable")
    void platformAdminWithoutPersonGetsAStableActor() {
        Authentication auth =
                jwt(Map.of("tenant_id", TENANT.toString(), "roles", List.of("ADMIN_GLOBAL")));

        UUID first = context.resolve(auth, null, null, null).actorId();
        UUID second = context.resolve(auth, null, null, null).actorId();

        assertThat(first).isEqualTo(second).isNotEqualTo(PERSON);
    }

    @Test
    @DisplayName("sin person_id y sin rol de plataforma, el token no sirve para actuar")
    void anyoneElseWithoutPersonIsRejected() {
        Authentication auth =
                jwt(Map.of("tenant_id", TENANT.toString(), "roles", List.of("DOCENTE")));

        assertThatThrownBy(() -> context.resolve(auth, null, null, null))
                .isInstanceOf(ContinuingEducationApplicationException.class)
                .extracting("errorCode")
                .isEqualTo(ContinuingEducationErrorCodes.JWT_CONTEXT_INVALID);
    }

    @Test
    @DisplayName("sin JWT y sin el fallback de desarrollo, hace falta autenticarse")
    void withoutJwtAuthenticationIsRequired() {
        assertThatThrownBy(() -> context.resolve(null, TENANT.toString(), PERSON.toString(), "x"))
                .isInstanceOf(ContinuingEducationApplicationException.class)
                .extracting("errorCode")
                .isEqualTo(ContinuingEducationErrorCodes.AUTHENTICATION_REQUIRED);
    }

    @Test
    @DisplayName("en desarrollo sin JWT, las cabeceras valen")
    void devFallbackReadsHeaders() {
        ContinuingEducationRequestContext dev = new ContinuingEducationRequestContext(false, true);

        ContinuingEducationRequestContext.Context resolved =
                dev.resolve(null, TENANT.toString(), PERSON.toString(), "dev");

        assertThat(resolved.tenantId()).isEqualTo(TENANT);
        assertThat(resolved.actorId()).isEqualTo(PERSON);
        assertThat(resolved.actorName()).isEqualTo("dev");
    }

    private static Authentication jwt(Map<String, Object> claims) {
        Jwt token =
                Jwt.withTokenValue("t")
                        .header("alg", "RS256")
                        .subject("7")
                        .issuedAt(Instant.now())
                        .expiresAt(Instant.now().plusSeconds(60))
                        .claims(all -> all.putAll(claims))
                        .build();
        return new JwtAuthenticationToken(token);
    }
}
