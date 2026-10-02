package com.solveria.peopleu.continuinged;

import static org.assertj.core.api.Assertions.assertThat;

import com.solveria.peopleu.continuinged.shared.api.ContinuingEducationRequestContext;
import com.solveria.peopleu.continuinged.shared.outbox.ContinuingEducationOutboxRelayScheduler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

/**
 * El esqueleto levanta completo con el perfil {@code test} (H2, sin Flyway, sin JWT, sin relay).
 *
 * <p>Es la prueba de que las piezas compartidas se cablean entre si; cuando entre el primer modulo,
 * sus propios tests cubren lo suyo y esta sigue vigilando que nada de {@code shared} se rompa.
 */
@SpringBootTest
@ActiveProfiles("test")
class ContinuingEducationServiceApplicationTest {

    @Autowired private ApplicationContext context;

    @Test
    @DisplayName("el contexto arranca con las piezas compartidas")
    void contextLoads() {
        assertThat(context.getBean(ContinuingEducationRequestContext.class)).isNotNull();
    }

    @Test
    @DisplayName("el relay del outbox queda apagado en test")
    void outboxRelayIsOffInTests() {
        assertThat(context.getBeanNamesForType(ContinuingEducationOutboxRelayScheduler.class))
                .isEmpty();
    }
}
