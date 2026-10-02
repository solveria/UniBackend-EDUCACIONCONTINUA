package com.solveria.peopleu.continuinged.shared.application.exception;

/**
 * Codigos tecnicos comunes a todo el servicio: identidad y forma del request.
 *
 * <p>Van con el prefijo del servicio y no de un modulo porque no pertenecen a ninguno. Los codigos
 * de negocio llevan el prefijo de su modulo dueno ({@code EC01_*}, {@code EC02_*}...).
 */
public final class ContinuingEducationErrorCodes {

    private ContinuingEducationErrorCodes() {}

    /** Reservado a errores de FORMA del request; nunca para reglas de negocio. */
    public static final String VALIDATION_ERROR = "VALIDATION_ERROR";

    public static final String AUTHENTICATION_REQUIRED =
            "CONTINUING_EDUCATION_AUTHENTICATION_REQUIRED";
    public static final String JWT_CONTEXT_INVALID = "CONTINUING_EDUCATION_JWT_CONTEXT_INVALID";

    /**
     * Le falta la capability que exige el {@code @PreAuthorize} del endpoint. Es anterior a
     * cualquier fila: no se llego a mirar ninguna.
     */
    public static final String PERMISSION_DENIED = "CONTINUING_EDUCATION_PERMISSION_DENIED";

    public static final String OPTIMISTIC_LOCK_CONFLICT =
            "CONTINUING_EDUCATION_OPTIMISTIC_LOCK_CONFLICT";
    public static final String DATA_INTEGRITY_CONFLICT =
            "CONTINUING_EDUCATION_DATA_INTEGRITY_CONFLICT";
    public static final String DEADLOCK_RETRY = "CONTINUING_EDUCATION_DEADLOCK_RETRY";
    public static final String SERVICE_UNAVAILABLE = "CONTINUING_EDUCATION_SERVICE_UNAVAILABLE";
    public static final String UNEXPECTED_ERROR = "CONTINUING_EDUCATION_UNEXPECTED_ERROR";
}
