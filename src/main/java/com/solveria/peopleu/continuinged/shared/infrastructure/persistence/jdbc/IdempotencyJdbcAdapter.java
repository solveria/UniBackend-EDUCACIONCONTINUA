package com.solveria.peopleu.continuinged.shared.infrastructure.persistence.jdbc;

import com.solveria.peopleu.continuinged.shared.application.port.IdempotencyPort;
import java.util.UUID;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * La reserva de clave, resuelta por la primary key y no por un SELECT previo.
 *
 * <p>Preguntar antes de insertar tiene una ventana entre la pregunta y la respuesta por la que
 * caben dos peticiones simultaneas: las dos leen "no existe" y las dos escriben. Insertar y dejar
 * que la clave primaria falle no tiene esa ventana, porque quien decide es la base y decide una
 * sola vez.
 */
@Repository
public class IdempotencyJdbcAdapter implements IdempotencyPort {

    private final JdbcTemplate jdbc;

    public IdempotencyJdbcAdapter(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public boolean register(UUID tenantId, String key, String operation, UUID resultId) {
        if (key == null || key.isBlank()) {
            // Sin clave no hay proteccion posible, pero tampoco hay motivo para rechazar: los
            // clientes internos y los scripts de carga escriben sin ella.
            return true;
        }
        try {
            jdbc.update(
                    "INSERT INTO peopleu_continuing_education_idempotency_key"
                            + " (tenant_id, operation, idempotency_key, result_id)"
                            + " VALUES (?, ?, ?, ?)",
                    tenantId,
                    operation,
                    key,
                    resultId);
            return true;
        } catch (DuplicateKeyException exception) {
            return false;
        }
    }
}
