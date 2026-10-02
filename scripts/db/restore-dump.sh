#!/usr/bin/env bash
# Restaura la base de este servicio desde un dump .sql.gz (el de scripts/db/ o el que te pasen).
#
#   bash scripts/db/restore-dump.sh                                   # el dump mas nuevo de scripts/db/
#   bash scripts/db/restore-dump.sh scripts/db/peopleu_continuing_education_service-2026-10-02.sql.gz
#
# Requiere Docker con el Postgres de este repo (docker compose up -d peopleu-continuing-education-postgres) y el SERVICIO
# PARADO. Despues de restaurar, arrancar el servicio: Flyway aplica encima lo que falte.
#
# Es DESTRUCTIVO: borra la base local y la reemplaza.
set -euo pipefail

CONTAINER="${CONTAINER:-peopleu-continuing-education-postgres}"
DB="${DB:-peopleu_continuing_education_service}"
PGUSER_="${PGUSER_:-postgres}"

HERE="$(cd "$(dirname "$0")" && pwd)"
DUMP="${1:-}"
if [ -z "$DUMP" ]; then
  DUMP="$(ls -1 "$HERE"/${DB}-*.sql.gz 2>/dev/null | sort | tail -n 1 || true)"
fi
if [ -z "$DUMP" ] || [ ! -f "$DUMP" ]; then
  echo "No encuentro ningun dump ${DB}-<fecha>.sql.gz en $HERE. Generalo con scripts/db/dump-db.sh." >&2
  exit 1
fi
if ! docker ps --format '{{.Names}}' | grep -qx "$CONTAINER"; then
  echo "El contenedor $CONTAINER no esta corriendo. Levantalo con: docker compose up -d $CONTAINER" >&2
  exit 1
fi

echo "Restaurando $DB en $CONTAINER desde $(basename "$DUMP") ..."
docker exec "$CONTAINER" psql -U "$PGUSER_" -d postgres -v ON_ERROR_STOP=1 \
  -c "DROP DATABASE IF EXISTS \"$DB\" WITH (FORCE);" \
  -c "CREATE DATABASE \"$DB\";"
gunzip -c "$DUMP" | docker exec -i "$CONTAINER" psql -U "$PGUSER_" -d "$DB" -q -v ON_ERROR_STOP=1
echo "Listo. Migraciones aplicadas en el dump:"
docker exec "$CONTAINER" psql -U "$PGUSER_" -d "$DB" -At -c \
  "select count(*) || ' migraciones, ultima V' || max(version) from flyway_schema_history where success;"
echo "Ahora arranca el servicio: Flyway aplica lo que falte."
