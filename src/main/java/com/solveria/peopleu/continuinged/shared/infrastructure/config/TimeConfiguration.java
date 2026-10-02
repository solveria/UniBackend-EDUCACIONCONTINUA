package com.solveria.peopleu.continuinged.shared.infrastructure.config;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * El reloj del servicio, inyectado y no consultado con {@code Instant.now()}.
 *
 * <p>La mitad de las reglas de los modulos dependen del tiempo (si una ventana esta abierta, si un
 * plazo vencio, si una cohorte esta activa) y con {@code Instant.now()} dentro del dominio esas
 * reglas solo se pueden probar esperando. Con un {@link Clock} inyectado, un test fija la fecha.
 * Los casos de uso lo reciben por constructor; un {@code @SpringBootTest} lo reemplaza con
 * {@code @MockitoBean} o una {@code @TestConfiguration} con {@code @Primary}.
 *
 * <p>Siempre UTC: todo instante se guarda en UTC y la zona horaria es de presentacion (CT-03).
 */
@Configuration
public class TimeConfiguration {

    @Bean
    Clock clock() {
        return Clock.systemUTC();
    }
}
