package com.solveria.peopleu.continuinged.shared.infrastructure.security;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.UUID;
import java.util.function.Supplier;
import org.springframework.security.oauth2.jwt.Jwt;

/**
 * Quien actua, cuando el token no trae persona.
 *
 * <p>Los modulos toman al actor del claim {@code person_id} y, si falta, cortan con "JWT context
 * invalid". Eso era correcto para todos menos para el administrador de la plataforma: {@code
 * admin.global} nace en una migracion de IAM y no sale del registro de personas (CT-04); su {@code
 * person_id} lo ponia una migracion de desarrollo que apuntaba a una persona de demo. Un IAM que se
 * reutiliza en otro negocio no puede exigir que exista una persona en otro servicio para que su
 * administrador pueda operar.
 *
 * <p>Regla: con {@code person_id}, se usa. Sin el, si el token lleva el rol de administrador de la
 * plataforma ({@code security.platform-admin-role}, por defecto {@code ADMIN_GLOBAL}), el actor es
 * un UUID estable derivado de la cuenta ({@code iam-user:<sub>}): el mismo en cada llamada, asi que
 * el rastro de auditoria queda consistente, aunque no resuelva a un nombre en CT-04 (la pantalla
 * muestra "Sin identificar" para esas filas). Para cualquier otro rol se cae a {@code fallback},
 * que es la excepcion de siempre.
 */
public final class PlatformActor {

    private static volatile String adminRole = "ADMIN_GLOBAL";

    private PlatformActor() {}

    static void configure(String role) {
        if (role != null && !role.isBlank()) {
            adminRole = role.trim();
        }
    }

    public static UUID actorIdOr(Jwt jwt, Supplier<UUID> fallback) {
        String personId = claim(jwt, "person_id", "personId");
        if (personId != null) {
            try {
                return UUID.fromString(personId);
            } catch (IllegalArgumentException ex) {
                return fallback.get();
            }
        }
        if (isPlatformAdmin(jwt) && jwt.getSubject() != null && !jwt.getSubject().isBlank()) {
            return UUID.nameUUIDFromBytes(
                    ("iam-user:" + jwt.getSubject()).getBytes(StandardCharsets.UTF_8));
        }
        return fallback.get();
    }

    public static boolean isPlatformAdmin(Jwt jwt) {
        Object roles = jwt.getClaims().get("roles");
        if (!(roles instanceof Collection<?> values)) {
            return false;
        }
        for (Object role : values) {
            if (role == null) {
                continue;
            }
            String name = role.toString().trim();
            if (name.regionMatches(true, 0, "ROLE_", 0, 5)) {
                name = name.substring(5);
            }
            if (name.equalsIgnoreCase(adminRole)) {
                return true;
            }
        }
        return false;
    }

    private static String claim(Jwt jwt, String... names) {
        for (String name : names) {
            Object value = jwt.getClaims().get(name);
            if (value != null && !value.toString().isBlank()) {
                return value.toString();
            }
        }
        return null;
    }
}
