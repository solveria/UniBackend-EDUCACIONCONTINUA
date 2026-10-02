package com.solveria.peopleu.continuinged.shared.api;

import com.solveria.core.observability.context.CorrelationIdContext;
import com.solveria.peopleu.continuinged.shared.application.exception.ContinuingEducationApplicationException;
import com.solveria.peopleu.continuinged.shared.application.exception.ContinuingEducationErrorCodes;
import com.solveria.peopleu.continuinged.shared.infrastructure.security.PlatformActor;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

/**
 * Quien hace la peticion y en nombre de que tenant: del JWT cuando hay, de cabeceras cuando estamos
 * en desarrollo sin JWT.
 *
 * <p>Es compartido por todos los modulos porque la identidad no es de ninguno. Lo que SI es de un
 * modulo es el alcance institucional (sede, campus, unidad academica): el token trae {@code scopes}
 * tal como IAM los emite y CT-01 es quien dice que significan; aca solo se exponen.
 *
 * <p>El actor es la <b>persona</b> ({@code person_id}, el registro unico de CT-04), no el id
 * tecnico de la cuenta: el {@code sub} que emite IAM es el numero de usuario. Sin {@code
 * person_id}, el administrador de la plataforma opera con un id derivado de su cuenta ({@link
 * PlatformActor}) y cualquier otro rol se rechaza: una persona que no existe en CT-04 no puede
 * dejar rastro en ningun expediente.
 *
 * <p>Trae tambien el nombre del actor, para que lo que se guarde con el hecho se guarde con nombre
 * y la pantalla de auditoria no quede mostrando identificadores.
 */
@Component
public class ContinuingEducationRequestContext {

    private final boolean jwtEnabled;
    private final boolean devFallbackEnabled;

    @Autowired
    public ContinuingEducationRequestContext(
            @Value("${security.jwt.enabled:true}") boolean jwtEnabled,
            @Value("${peopleu.dev-fallback.enabled:true}") boolean devFallbackEnabled,
            Environment environment) {
        this(
                jwtEnabled,
                devFallbackEnabled && environment.acceptsProfiles(Profiles.of("dev", "test")));
    }

    public ContinuingEducationRequestContext(boolean jwtEnabled, boolean devFallbackEnabled) {
        this.jwtEnabled = jwtEnabled;
        this.devFallbackEnabled = devFallbackEnabled;
    }

    /**
     * El contexto de la peticion. Las tres cabeceras {@code dev*} solo valen sin JWT y en los
     * perfiles {@code dev} y {@code test}; con JWT se ignoran.
     */
    public Context resolve(
            Authentication authentication, String devTenant, String devActor, String devActorName) {
        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            return new Context(
                    uuid(firstClaim(jwt, "tenant_id", "tenantId")),
                    actorId(jwt),
                    claimOrNull(jwt, "name", "preferred_username", "username"),
                    correlationId(),
                    scopesOf(jwt));
        }
        if (jwtEnabled || !devFallbackEnabled) {
            throw ContinuingEducationApplicationException.badRequest(
                    ContinuingEducationErrorCodes.AUTHENTICATION_REQUIRED);
        }
        return new Context(
                uuid(devTenant), uuid(devActor), devActorName, correlationId(), List.of());
    }

    private UUID actorId(Jwt jwt) {
        return PlatformActor.actorIdOr(
                jwt,
                () -> {
                    // Tokens de servicio y otros emisores traen un UUID en sub; IAM trae un numero.
                    String subject = jwt.getSubject();
                    try {
                        return UUID.fromString(subject);
                    } catch (RuntimeException exception) {
                        throw ContinuingEducationApplicationException.badRequest(
                                ContinuingEducationErrorCodes.JWT_CONTEXT_INVALID);
                    }
                });
    }

    /** El ambito institucional que trae el token, tal como lo emite IAM. Vacio sin JWT. */
    public List<String> institutionalScopes(Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof Jwt jwt) {
            return scopesOf(jwt);
        }
        return List.of();
    }

    private static List<String> scopesOf(Jwt jwt) {
        Object scopes = jwt.getClaims().get("scopes");
        if (scopes instanceof Collection<?> values) {
            return values.stream().map(Object::toString).toList();
        }
        return List.of();
    }

    private String firstClaim(Jwt jwt, String... names) {
        String value = claimOrNull(jwt, names);
        if (value == null) {
            throw ContinuingEducationApplicationException.badRequest(
                    ContinuingEducationErrorCodes.JWT_CONTEXT_INVALID);
        }
        return value;
    }

    private String claimOrNull(Jwt jwt, String... names) {
        for (String name : names) {
            Object value = jwt.getClaims().get(name);
            if (value != null && !value.toString().isBlank()) {
                return value.toString();
            }
        }
        return null;
    }

    private UUID correlationId() {
        return uuid(CorrelationIdContext.getOrCreate());
    }

    private UUID uuid(String value) {
        try {
            return UUID.fromString(value);
        } catch (RuntimeException exception) {
            throw ContinuingEducationApplicationException.badRequest(
                    ContinuingEducationErrorCodes.VALIDATION_ERROR);
        }
    }

    /**
     * Tenant, actor (persona de CT-04), su nombre si el token o la cabecera lo traen, la
     * correlacion y los alcances institucionales del token.
     */
    public record Context(
            UUID tenantId,
            UUID actorId,
            String actorName,
            UUID correlationId,
            List<String> institutionalScopes) {}
}
