package com.solveria.peopleu.continuinged.shared.application.port;

/**
 * Lo que un modulo le entrega al relay compartido para que publique su outbox.
 *
 * <p>Cada modulo que emita eventos tiene su tabla {@code xxNN_outbox_event}, escrita en la misma
 * transaccion que el hecho que anuncia, y un caso de uso que la drena hacia CT-09 (contratos e
 * integraciones). Para que ese drenaje corra solo, el caso de uso implementa esta interfaz y se
 * registra como bean: el scheduler de {@code shared/outbox} lo encuentra sin que haya que tocar una
 * lista a mano cada vez que entra un modulo nuevo.
 */
public interface OutboxDrain {

    /** El codigo del modulo dueno, para el log ({@code EC01}, {@code EC02}...). */
    String module();

    /** Toma hasta {@code batchSize} eventos pendientes, los publica y marca cada uno. */
    DrainResult drain(int batchSize);

    record DrainResult(int taken, int published, int failed, int discarded) {

        public static DrainResult empty() {
            return new DrainResult(0, 0, 0, 0);
        }
    }
}
