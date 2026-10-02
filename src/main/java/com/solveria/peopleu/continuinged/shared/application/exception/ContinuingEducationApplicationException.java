package com.solveria.peopleu.continuinged.shared.application.exception;

/**
 * Error de negocio de cualquier modulo de este servicio.
 *
 * <p>Es una sola clase para todos los modulos y no una por modulo, porque no hay nada que distinga
 * a una de otra: el modulo dueno del error ya viaja en el <b>codigo</b> ({@code EC01_*}, {@code
 * EC02_*}...), que es la senal por la que el frontend reacciona.
 *
 * <p>El {@link Status} se traduce a HTTP con esta separacion:
 *
 * <ul>
 *   <li><b>400</b>: la <i>forma</i> del request esta mal. Va con {@code fieldErrors}.
 *   <li><b>409</b>: la operacion choca con el <i>estado actual</i> (ya decidido, version vieja).
 *   <li><b>422</b>: el request esta bien formado pero una <i>regla</i> lo impide.
 * </ul>
 *
 * <p>{@code VALIDATION_ERROR} queda reservado para la forma. Una regla de negocio devuelta como
 * {@code VALIDATION_ERROR} deja al cliente sin forma de distinguir "corregi el campo" de "esto no
 * se puede hacer".
 */
public class ContinuingEducationApplicationException extends RuntimeException {

    public enum Status {
        BAD_REQUEST,
        FORBIDDEN,
        NOT_FOUND,
        CONFLICT,
        UNPROCESSABLE_ENTITY,
        SERVICE_UNAVAILABLE
    }

    private final String errorCode;
    private final Status status;

    public ContinuingEducationApplicationException(String errorCode, Status status) {
        this(errorCode, status, errorCode);
    }

    public ContinuingEducationApplicationException(
            String errorCode, Status status, String message) {
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }

    public static ContinuingEducationApplicationException badRequest(String code) {
        return new ContinuingEducationApplicationException(code, Status.BAD_REQUEST);
    }

    public static ContinuingEducationApplicationException badRequest(String code, String message) {
        return new ContinuingEducationApplicationException(code, Status.BAD_REQUEST, message);
    }

    public static ContinuingEducationApplicationException forbidden(String code) {
        return new ContinuingEducationApplicationException(code, Status.FORBIDDEN);
    }

    public static ContinuingEducationApplicationException forbidden(String code, String message) {
        return new ContinuingEducationApplicationException(code, Status.FORBIDDEN, message);
    }

    public static ContinuingEducationApplicationException notFound(String code) {
        return new ContinuingEducationApplicationException(code, Status.NOT_FOUND);
    }

    public static ContinuingEducationApplicationException conflict(String code) {
        return new ContinuingEducationApplicationException(code, Status.CONFLICT);
    }

    public static ContinuingEducationApplicationException conflict(String code, String message) {
        return new ContinuingEducationApplicationException(code, Status.CONFLICT, message);
    }

    public static ContinuingEducationApplicationException unprocessable(String code) {
        return new ContinuingEducationApplicationException(code, Status.UNPROCESSABLE_ENTITY);
    }

    public static ContinuingEducationApplicationException unprocessable(
            String code, String message) {
        return new ContinuingEducationApplicationException(
                code, Status.UNPROCESSABLE_ENTITY, message);
    }

    public static ContinuingEducationApplicationException serviceUnavailable(String code) {
        return new ContinuingEducationApplicationException(code, Status.SERVICE_UNAVAILABLE);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Status getStatus() {
        return status;
    }
}
