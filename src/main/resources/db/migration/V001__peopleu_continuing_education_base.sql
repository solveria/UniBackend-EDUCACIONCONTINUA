-- V001: lo que todo modulo de peopleu-continuing-education-service comparte. Las tablas de cada modulo van en su
-- propia migracion, numerada con el modulo (V101 = EC-01, V102 = EC-02...); ver docs/db.

-- Registro de intentos ya procesados (Idempotency-Key), compartido por todos los modulos.
--
-- La operacion forma parte de la clave: un cliente que reutilice una misma Idempotency-Key en dos
-- mutaciones distintas del mismo tenant no es el mismo intento aunque comparta cabecera.
CREATE TABLE IF NOT EXISTS peopleu_continuing_education_idempotency_key (
    tenant_id UUID NOT NULL,
    operation VARCHAR(80) NOT NULL,
    idempotency_key VARCHAR(200) NOT NULL,
    result_id UUID,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    CONSTRAINT pk_peopleu_continuing_education_idempotency PRIMARY KEY (tenant_id, operation, idempotency_key)
);

-- Para el barrido de claves viejas: sin esto, limpiar por fecha recorre la tabla entera.
CREATE INDEX IF NOT EXISTS ix_peopleu_continuing_education_idempotency_created
    ON peopleu_continuing_education_idempotency_key (created_at);
