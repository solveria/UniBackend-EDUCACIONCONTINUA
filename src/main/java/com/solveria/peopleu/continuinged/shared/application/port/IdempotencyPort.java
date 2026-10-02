package com.solveria.peopleu.continuinged.shared.application.port;

import java.util.UUID;

/**
 * El registro de intentos ya procesados, compartido por todos los modulos.
 *
 * <p><b>Que protege y que no.</b> Impide que un mismo intento (misma clave, misma operacion, mismo
 * tenant) se ejecute dos veces. Es la mitad backend de un contrato: solo sirve si el cliente
 * reutiliza la clave al reintentar ({@code Idempotency-Key}).
 *
 * <p><b>Una operacion que falla no quema la clave.</b> El registro ocurre dentro de la transaccion
 * del caso de uso, asi que si la regla de negocio rechaza despues, el {@code INSERT} se deshace con
 * todo lo demas. Lo que queda reservado es lo que se llego a confirmar.
 */
public interface IdempotencyPort {

    /**
     * Reserva la clave para esa operacion.
     *
     * @return {@code true} si es la primera vez; {@code false} si el intento ya se habia procesado.
     */
    boolean register(UUID tenantId, String key, String operation, UUID resultId);
}
