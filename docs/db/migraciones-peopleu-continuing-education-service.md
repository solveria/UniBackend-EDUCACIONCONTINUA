# Migraciones PeopleU Continuing Education Service

Las migraciones Flyway se almacenan en `src/main/resources/db/migration` con formato
`VNNN__descripcion.sql`.

- **El numero de la migracion es el numero del modulo mas 100:** `V101` es EC-01, `V112` es EC-12.
  Con eso el numero dice de que modulo es la tabla, igual que en `campus-ops-service` (donde `V011`
  es OP11). Como los modulos no entran en orden, `spring.flyway.out-of-order=true`.
- **Una migracion por modulo.** Mientras el modulo no haya llegado a una base compartida, un cambio de
  esquema se edita dentro de su migracion. Una vez aplicada en una base que importa, lo que falte
  sale al lado como correctiva `V1NN_k__xxNN_<que>.sql` (editarla cambia el checksum y Flyway se
  niega a arrancar en toda base que ya la tenga).
- Cada tabla pertenece a un modulo y lleva su prefijo (`ec01_`).
- Toda tabla lleva `tenant_id UUID NOT NULL`; las FK internas son compuestas
  (`UNIQUE (id, tenant_id)` en la tabla referida) para que una fila no apunte a otro tenant.
- Sin FK entre modulos: se guarda el id ajeno como columna sin constraint.
- Tipos: `UUID` para ids, `TIMESTAMPTZ` en UTC, estados en `VARCHAR(40)` con `CHECK` (no enums de
  Postgres: agregar un valor a un enum obliga a migrar), importes `NUMERIC(18,2)`, cantidades
  `NUMERIC(18,4)`.
- Las unicidades que sostienen reglas de negocio ("un solo X abierto por Y") van como indices unicos
  parciales, no como `SELECT` previo.
- JPA usa `ddl-auto=validate`; no crea ni modifica el esquema.
- No crear tablas de persona, documentos, auditoria, calendario, consentimientos ni workflows: son
  de CT-04, CT-05, CT-10, CT-03, CT-07 y CT-06 (en el transversal).

## Inventario

| Version | Archivo | Que trae |
| --- | --- | --- |
| V001 | `V001__peopleu_continuing_education_base.sql` | Registro de intentos ya procesados (`Idempotency-Key`), compartido por todos los modulos. |

Reservadas (se crean cuando el modulo entra):

| Version | Archivo | Modulo |
| --- | --- | --- |
| V101 | `V101__ec01_<tema>.sql` | EC-01 Portafolio, programas, versiones, modulos, outcomes, competencias y rutas de microcredenciales |
| V102 | `V102__ec02_<tema>.sql` | EC-02 Ediciones, ofertas, cohortes, modalidades, calendarios, capacidad y programacion |
| V103 | `V103__ec03_<tema>.sql` | EC-03 Comercializacion academica, pricing, promociones, becas y condiciones comerciales |
| V104 | `V104__ec04_<tema>.sql` | EC-04 Prospecto, registro, inscripcion, cupos, lista de espera, transferencias y retiros |
| V105 | `V105__ec05_<tema>.sql` | EC-05 Docentes, expertos, delivery plan, contenidos y entorno de aprendizaje |
| V106 | `V106__ec06_<tema>.sql` | EC-06 Asistencia, participacion y engagement |
| V107 | `V107__ec07_<tema>.sql` | EC-07 Evaluacion, integridad, apelaciones, resultados, completion y cierre |
| V108 | `V108__ec08_<tema>.sql` | EC-08 Certificados, badges, microcredenciales y credenciales verificables |
| V109 | `V109__ec09_<tema>.sql` | EC-09 Formacion corporativa o in-company, TNA, sponsor governance y reporting |
| V110 | `V110__ec10_<tema>.sql` | EC-10 Trayectoria de aprendizaje y stacking |
| V111 | `V111__ec11_<tema>.sql` | EC-11 Feedback, NPS, evaluacion docente e impacto |
| V112 | `V112__ec12_<tema>.sql` | EC-12 Calidad, mejora continua y gobierno del portafolio |

## Una base que ya tenia una cadena vieja

Si Flyway falla el arranque con *"Detected applied migration not resolved locally"* o un checksum
distinto, la base no se arregla sola. Si es descartable (desarrollo): `docker compose down -v` y
dejar que Flyway aplique todo desde cero. Si tiene datos que importan: corregir `flyway_schema_history`
a mano (borrar las filas que ya no existen y actualizar el checksum que el propio error imprime).
