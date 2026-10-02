# scripts/ (peopleu-continuing-education-service)

- `db/dump-db.sh`: genera `db/peopleu_continuing_education_service-<fecha>.sql.gz` desde tu base local (solo datos de prueba).
- `db/restore-dump.sh`: deja tu base igual al dump mas nuevo de `db/`. Requiere el servicio parado y
  `docker compose up -d peopleu-continuing-education-postgres`.
- `dev/`: seeds por modulo cuando existan (`dev/<modulo>-*.sql` o `.sh`). Idempotentes: correrlos dos
  veces no duplica nada.

Las migraciones (`src/main/resources/db/migration/`) las aplica el servicio al arrancar; los scripts de
aca son datos, nunca esquema.
