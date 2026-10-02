package com.solveria.peopleu.continuinged.shared.infrastructure.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/** Le dice a {@link PlatformActor} que rol es el de administrador de la plataforma. */
@Component
class PlatformActorConfig {

    PlatformActorConfig(@Value("${security.platform-admin-role:ADMIN_GLOBAL}") String adminRole) {
        PlatformActor.configure(adminRole);
    }
}
