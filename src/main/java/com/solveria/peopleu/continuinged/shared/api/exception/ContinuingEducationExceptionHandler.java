package com.solveria.peopleu.continuinged.shared.api.exception;

import com.solveria.core.api.error.ApiErrorResponse;
import com.solveria.core.api.error.ErrorDetailResponse;
import com.solveria.core.api.error.FieldErrorResponse;
import com.solveria.core.i18n.I18nMessageResolver;
import com.solveria.core.observability.context.CorrelationIdContext;
import com.solveria.core.observability.filter.CorrelationIdFilter;
import com.solveria.peopleu.continuinged.shared.application.exception.ContinuingEducationApplicationException;
import com.solveria.peopleu.continuinged.shared.application.exception.ContinuingEducationErrorCodes;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import java.time.Instant;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * El contrato de error de todo el servicio, en un solo sitio.
 *
 * <p>Es uno para todos los modulos y no uno por modulo: no tiene una sola linea especifica de
 * ninguno (el modulo dueno del error ya viaja en el codigo), asi que N copias serian N copias
 * identicas que se separan en cuanto alguien toque una.
 *
 * <p>Si un modulo necesita un contrato propio, lo acota a su paquete con {@code basePackages} y
 * {@code @Order(0)}; este queda con orden mas alto y atiende lo que el otro no declare.
 *
 * <p>Devuelve la estructura unica de {@code core-platform}: {@code code} estable en {@code
 * UPPER_SNAKE_CASE}, {@code correlationId} en el cuerpo <b>y</b> en el header {@code
 * X-Correlation-Id}, y {@code fieldErrors}/{@code details} siempre array.
 */
@RestControllerAdvice(basePackages = "com.solveria.peopleu.continuinged")
@Order(10)
public class ContinuingEducationExceptionHandler {

    private static final Logger log =
            LoggerFactory.getLogger(ContinuingEducationExceptionHandler.class);

    /**
     * El resolutor de mensajes, opcional a proposito: este advice se crea en cualquier contexto que
     * lo escanee, incluidos los {@code @WebMvcTest}, que son rebanadas sin la autoconfiguracion de
     * i18n. Lo que el cliente consume es el {@code code}, que viaja siempre; sin resolutor se
     * responde el propio codigo como mensaje.
     */
    private final ObjectProvider<I18nMessageResolver> messages;

    public ContinuingEducationExceptionHandler(ObjectProvider<I18nMessageResolver> messages) {
        this.messages = messages;
    }

    private String resolve(String code, Locale locale) {
        I18nMessageResolver resolver = messages.getIfAvailable();
        return resolver == null ? code : resolver.resolve(code, locale);
    }

    @ExceptionHandler(ContinuingEducationApplicationException.class)
    public ResponseEntity<ApiErrorResponse> handleApplication(
            ContinuingEducationApplicationException exception,
            HttpServletRequest request,
            HttpServletResponse response) {
        HttpStatus status =
                switch (exception.getStatus()) {
                    case BAD_REQUEST -> HttpStatus.BAD_REQUEST;
                    case FORBIDDEN -> HttpStatus.FORBIDDEN;
                    case NOT_FOUND -> HttpStatus.NOT_FOUND;
                    case CONFLICT -> HttpStatus.CONFLICT;
                    case UNPROCESSABLE_ENTITY -> HttpStatus.UNPROCESSABLE_ENTITY;
                    case SERVICE_UNAVAILABLE -> HttpStatus.SERVICE_UNAVAILABLE;
                };
        // El detalle que construyo el caso de uso viaja en details: distintos rechazos con el
        // mismo codigo tienen que poder distinguirse.
        return build(
                status,
                exception.getErrorCode(),
                List.of(),
                detailsOf(exception.getErrorCode(), exception.getMessage()),
                request,
                response);
    }

    private List<ErrorDetailResponse> detailsOf(String code, String message) {
        return message == null || message.isBlank() || message.equals(code)
                ? List.of()
                : List.of(new ErrorDetailResponse(code, message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleBodyValidation(
            MethodArgumentNotValidException exception,
            HttpServletRequest request,
            HttpServletResponse response) {
        List<FieldErrorResponse> fields =
                exception.getBindingResult().getFieldErrors().stream()
                        .map(
                                error ->
                                        new FieldErrorResponse(
                                                error.getField(),
                                                error.getCode(),
                                                error.getDefaultMessage()))
                        .toList();
        return build(
                HttpStatus.BAD_REQUEST,
                ContinuingEducationErrorCodes.VALIDATION_ERROR,
                fields,
                request,
                response);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintValidation(
            ConstraintViolationException exception,
            HttpServletRequest request,
            HttpServletResponse response) {
        List<FieldErrorResponse> fields =
                exception.getConstraintViolations().stream()
                        .map(
                                error ->
                                        new FieldErrorResponse(
                                                error.getPropertyPath().toString(),
                                                error.getConstraintDescriptor()
                                                        .getAnnotation()
                                                        .annotationType()
                                                        .getSimpleName(),
                                                error.getMessage()))
                        .toList();
        return build(
                HttpStatus.BAD_REQUEST,
                ContinuingEducationErrorCodes.VALIDATION_ERROR,
                fields,
                request,
                response);
    }

    @ExceptionHandler({
        MissingRequestHeaderException.class,
        MissingServletRequestParameterException.class,
        MethodArgumentTypeMismatchException.class,
        HttpMessageNotReadableException.class
    })
    public ResponseEntity<ApiErrorResponse> handleMalformed(
            Exception exception, HttpServletRequest request, HttpServletResponse response) {
        return build(
                HttpStatus.BAD_REQUEST,
                ContinuingEducationErrorCodes.VALIDATION_ERROR,
                List.of(),
                request,
                response);
    }

    @ExceptionHandler(OptimisticLockingFailureException.class)
    public ResponseEntity<ApiErrorResponse> handleOptimisticLock(
            RuntimeException exception, HttpServletRequest request, HttpServletResponse response) {
        return build(
                HttpStatus.CONFLICT,
                ContinuingEducationErrorCodes.OPTIMISTIC_LOCK_CONFLICT,
                List.of(),
                request,
                response);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleIntegrity(
            DataIntegrityViolationException exception,
            HttpServletRequest request,
            HttpServletResponse response) {
        return build(
                HttpStatus.CONFLICT,
                ContinuingEducationErrorCodes.DATA_INTEGRITY_CONFLICT,
                List.of(),
                request,
                response);
    }

    @ExceptionHandler(DeadlockLoserDataAccessException.class)
    public ResponseEntity<ApiErrorResponse> handleDeadlock(
            DeadlockLoserDataAccessException exception,
            HttpServletRequest request,
            HttpServletResponse response) {
        return build(
                HttpStatus.SERVICE_UNAVAILABLE,
                ContinuingEducationErrorCodes.DEADLOCK_RETRY,
                List.of(),
                request,
                response);
    }

    @ExceptionHandler(DataAccessResourceFailureException.class)
    public ResponseEntity<ApiErrorResponse> handleUnavailable(
            DataAccessResourceFailureException exception,
            HttpServletRequest request,
            HttpServletResponse response) {
        return build(
                HttpStatus.SERVICE_UNAVAILABLE,
                ContinuingEducationErrorCodes.SERVICE_UNAVAILABLE,
                List.of(),
                request,
                response);
    }

    /**
     * El {@code @PreAuthorize} dijo que no.
     *
     * <p>Existe por culpa del atrapatodo de abajo: el interceptor de {@code @EnableMethodSecurity}
     * lanza {@link AccessDeniedException} dentro del {@code DispatcherServlet}, asi que la resuelve
     * este advice y nunca llega al {@code ExceptionTranslationFilter} de Spring Security. Sin esta
     * linea cada denegacion de permiso se responderia 500.
     */
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiErrorResponse> handleAccessDenied(
            AccessDeniedException exception,
            HttpServletRequest request,
            HttpServletResponse response) {
        log.warn(
                "peopleu-continuing-education-service: permiso denegado en {} {}: {}",
                request.getMethod(),
                request.getRequestURI(),
                exception.getMessage());
        return build(
                HttpStatus.FORBIDDEN,
                ContinuingEducationErrorCodes.PERMISSION_DENIED,
                List.of(),
                request,
                response);
    }

    /**
     * Lo que nadie previo. El stack se registra antes de responder; el cliente recibe el contrato
     * de siempre, sin detalles internos.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleUnexpected(
            Exception exception, HttpServletRequest request, HttpServletResponse response) {
        log.error(
                "peopleu-continuing-education-service: error inesperado en {} {}: se responde 500",
                request.getMethod(),
                request.getRequestURI(),
                exception);
        return build(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ContinuingEducationErrorCodes.UNEXPECTED_ERROR,
                List.of(),
                request,
                response);
    }

    private ResponseEntity<ApiErrorResponse> build(
            HttpStatus status,
            String code,
            List<FieldErrorResponse> fields,
            HttpServletRequest request,
            HttpServletResponse response) {
        return build(status, code, fields, List.of(), request, response);
    }

    private ResponseEntity<ApiErrorResponse> build(
            HttpStatus status,
            String code,
            List<FieldErrorResponse> fields,
            List<ErrorDetailResponse> details,
            HttpServletRequest request,
            HttpServletResponse response) {
        String correlationId = CorrelationIdContext.getOrCreate();
        response.setHeader(CorrelationIdFilter.CORRELATION_ID_HEADER, correlationId);
        ApiErrorResponse body =
                new ApiErrorResponse(
                        Instant.now(),
                        status.value(),
                        status.getReasonPhrase(),
                        code,
                        resolve(code, request.getLocale()),
                        correlationId,
                        request.getRequestURI(),
                        request.getMethod(),
                        fields,
                        details);
        return ResponseEntity.status(status).body(body);
    }
}
