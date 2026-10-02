package com.solveria.peopleu.continuinged.shared.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.solveria.peopleu.continuinged.shared.api.exception.ContinuingEducationExceptionHandler;
import java.lang.reflect.Method;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;

/**
 * Que manejador atiende cada excepcion.
 *
 * <p>Cubre un defecto que la plataforma ya tuvo: el advice declara
 * {@code @ExceptionHandler(Exception.class)}, asi que sin un manejador especifico se tragaba la
 * denegacion de {@code @PreAuthorize} y respondia 500 en lugar de 403. Si alguien borra {@code
 * handleAccessDenied}, esta prueba falla en vez de que el defecto reaparezca callado.
 */
class ContinuingEducationExceptionHandlerTest {

    private final ExceptionHandlerMethodResolver resolver =
            new ExceptionHandlerMethodResolver(ContinuingEducationExceptionHandler.class);

    @Test
    @DisplayName("la denegacion de @PreAuthorize la atiende handleAccessDenied, no el atrapatodo")
    void authorizationDeniedIsHandledAsForbidden() {
        AuthorizationDeniedException denied =
                new AuthorizationDeniedException(
                        "acceso denegado", (AuthorizationResult) () -> false);

        Method handler = resolver.resolveMethod(denied);

        assertThat(handler).isNotNull();
        assertThat(handler.getName()).isEqualTo("handleAccessDenied");
    }

    @Test
    @DisplayName("un AccessDeniedException pelado tambien")
    void plainAccessDeniedIsHandledAsForbidden() {
        Method handler = resolver.resolveMethod(new AccessDeniedException("sin permiso"));

        assertThat(handler).isNotNull();
        assertThat(handler.getName()).isEqualTo("handleAccessDenied");
    }

    @Test
    @DisplayName("lo que nadie previo sigue cayendo en el atrapatodo")
    void unexpectedStillFallsThrough() {
        Method handler = resolver.resolveMethod(new IllegalStateException("algo se rompio"));

        assertThat(handler).isNotNull();
        assertThat(handler.getName()).isEqualTo("handleUnexpected");
    }
}
