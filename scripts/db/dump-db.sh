#!/usr/bin/env bash
# Genera un dump comprimido de la base de este servicio en scripts/db/<db>-<fecha>.sql.gz, para
# compartirlo con el equipo y que todos lo restauren con scripts/db/restore-dump.sh.
#
#   bash scripts/db/dump-db.sh              # scripts/db/peopleu_continuing_education_service-AAAA-MM-DD.sql.gz
#   bash scripts/db/dump-db.sh mi-copia     # scripts/db/mi-copia.sql.gz
#
# Solo datos de prueba: NUNCA subir un dump con datos reales de una universidad.
set -euo pipefail

CONTAINER="${CONTAINER:-peopleu-continuing-education-postgres}"
DB="${DB:-peopleu_continuing_education_service}"
PGUSER_="${PGUSER_:-postgres}"

HERE="$(cd "$(dirname "$0")" && pwd)"
NAME="${1:-${DB}-$(date +%F)}"
OUT="$HERE/$NAME.sql.gz"

docker exec "$CONTAINER" pg_dump -U "$PGUSER_" -d "$DB" --no-owner --no-privileges | gzip -9 > "$OUT"
ls -la "$OUT"
