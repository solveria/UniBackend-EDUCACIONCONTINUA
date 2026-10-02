package com.solveria.peopleu.continuinged.shared.outbox;

import com.solveria.peopleu.continuinged.shared.application.port.OutboxDrain;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Publica los outbox de todos los modulos sin que nadie tenga que pedirlo.
 *
 * <p>Los endpoints de drenaje pueden existir, pero si hay que llamarlos a mano los eventos se
 * acumulan PENDING para siempre: el modulo parece funcionar y en realidad no le esta contando nada
 * a nadie.
 *
 * <p>Los errores se tragan A PROPOSITO, y por modulo: si el destino esta caido, cada evento queda
 * FAILED y se reintenta en la proxima corrida; dejar que la excepcion suba mataria el scheduler de
 * Spring y el drenaje no volveria hasta reiniciar el servicio.
 *
 * <p>Se apaga con {@code peopleu.outbox.relay.enabled=false}. Los tests lo apagan.
 */
@Component
@ConditionalOnProperty(
        prefix = "peopleu.outbox.relay",
        name = "enabled",
        havingValue = "true",
        matchIfMissing = true)
public class ContinuingEducationOutboxRelayScheduler {

    private static final Logger log =
            LoggerFactory.getLogger(ContinuingEducationOutboxRelayScheduler.class);

    private final List<OutboxDrain> drains;
    private final int batchSize;

    public ContinuingEducationOutboxRelayScheduler(
            List<OutboxDrain> drains,
            @Value("${peopleu.outbox.relay.batch-size:50}") int batchSize) {
        this.drains = List.copyOf(drains);
        this.batchSize = batchSize;
    }

    /**
     * {@code fixedDelay} y no {@code fixedRate}: cuenta desde que termina la corrida anterior, asi
     * que si el destino esta lento no se encima una corrida con la siguiente sobre las mismas
     * filas.
     */
    @Scheduled(
            fixedDelayString = "${peopleu.outbox.relay.delay-ms:30000}",
            initialDelayString = "${peopleu.outbox.relay.initial-delay-ms:15000}")
    public void relay() {
        for (OutboxDrain drain : drains) {
            try {
                OutboxDrain.DrainResult result = drain.drain(batchSize);
                // Solo se loguea cuando saco algo. El silencio significa que no habia nada
                // pendiente, no que este apagado.
                if (result.taken() > 0) {
                    log.info(
                            "Outbox {}: {} tomados, {} publicados, {} fallidos, {} descartados",
                            drain.module(),
                            result.taken(),
                            result.published(),
                            result.failed(),
                            result.discarded());
                }
            } catch (RuntimeException exception) {
                log.warn(
                        "No se pudo drenar el outbox de {}: {}",
                        drain.module(),
                        exception.getMessage());
            }
        }
    }
}
