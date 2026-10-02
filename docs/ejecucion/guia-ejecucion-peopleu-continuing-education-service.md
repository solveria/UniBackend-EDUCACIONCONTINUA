# Guia de ejecucion PeopleU Continuing Education Service

## Requisitos

- Java 21 y `JAVA_HOME` apuntando a el.
- Maven Wrapper incluido (`mvnw` / `mvnw.cmd`).
- Docker Desktop para PostgreSQL local.
- `core-platform` instalado en el repositorio Maven local, una vez por maquina:

```powershell
git clone https://github.com/solveria/core-plataform.git
cd core-plataform
.\mvnw.cmd -q -ntp -DskipTests install
```

  Para construir la imagen Docker, ese clon tiene que estar **al lado** de este servicio (el
  `docker-compose.yml` usa la carpeta padre como contexto y el `Dockerfile` copia `core-plataform`).

## Ejecucion local

```powershell
docker compose up -d peopleu-continuing-education-postgres
.\mvnw.cmd test
.\mvnw.cmd spring-boot:run
```

Todo en Docker, con solo compose:

```powershell
docker compose up --build
```

El servicio arranca aunque IAM no este levantado: el JWKS se pide en la primera verificacion. Sin IAM
ningun token pasa; con `JWT_ENABLED=false` (solo desarrollo) el actor y el tenant salen de las
cabeceras `X-Tenant-Id`, `X-Actor-Id` y `X-Actor-Name`.

## URLs

- Servicio: `http://localhost:8104`
- Swagger UI: `http://localhost:8104/swagger-ui/index.html` (`SPRINGDOC_ENABLED=true`)
- OpenAPI: `http://localhost:8104/v3/api-docs`
- Health: `http://localhost:8104/actuator/health`

## Variables

| Variable | Default |
| --- | --- |
| `PU_CONTINUING_EDUCATION_SERVICE_PORT` | `8104` |
| `PU_CONTINUING_EDUCATION_DB_HOST` / `PU_CONTINUING_EDUCATION_DB_PORT` | `127.0.0.1` / `5454` |
| `PU_CONTINUING_EDUCATION_DB_NAME` | `peopleu_continuing_education_service` |
| `PU_CONTINUING_EDUCATION_DB_USER` / `PU_CONTINUING_EDUCATION_DB_PASSWORD` | `postgres` / `postgres` |
| `JWT_ENABLED` | `true` |
| `IAM_JWT_ISSUER` | `iam-service` |
| `IAM_JWKS_URI` | `${IAM_SERVICE_URL}/.well-known/jwks.json` (claves publicas RS256 de IAM) |
| `IAM_JWT_AUDIENCE` | `peopleu-continuing-education-service` (el nombre de este servicio; el token tiene que nombrarlo) |
| `IAM_SERVICE_URL` | `http://localhost:8080` |
| `IAM_REDIS_HOST` / `IAM_REDIS_PORT` | `localhost` / `6379` (lista negra de tokens de IAM) |
| `IAM_TOKEN_EXCHANGE_ENABLED` | `true`: el token de la persona se canjea por uno para el destino antes de reenviarlo |
| `IAM_PLATFORM_ADMIN_ROLE` | `ADMIN_GLOBAL` (rol que puede operar sin `person_id`) |
| `PU_CONTINUING_EDUCATION_SERVICE_ACCOUNT_CLIENT_SECRET` | vacio (la cuenta `peopleu-continuing-education-service` en IAM; sin ella el relay avisa y reintenta) |
| `PU_CONTINUING_EDUCATION_SERVICE_ACCOUNT_TENANT_ID` | `11111111-1111-1111-1111-111111111111` |
| `PU_CONTINUING_EDUCATION_OUTBOX_RELAY_ENABLED` | `true` |
| `PU_CONTINUING_EDUCATION_CORS_ALLOWED_ORIGINS` | `http://localhost:3000,...,http://127.0.0.1:3001` |
| `PU_TRANSVERSAL_SERVICE_URL` | `http://localhost:8101` (destino `peopleu-transversal-service`) |
| `AI_SERVICE_URL` | `http://localhost:8091` (destino `ai-service`) |
| `SPRINGDOC_ENABLED` | `false` (`true` en compose) |

## Lo que IAM tiene que conocer de este servicio

1. La audiencia `peopleu-continuing-education-service` en `IAM_RESOURCE_AUDIENCES`.
2. La cuenta de servicio `peopleu-continuing-education-service` (`iam_service_account`), activa y con secreto, para el
   relay del outbox y las llamadas sin persona.
3. El catalogo del producto `peopleu` (`IAM_PRODUCTS=peopleu`): modulos, recursos, acciones, roles y
   permisos de cada modulo de este servicio, en `iam-service/db/migration/products/peopleu/`.

## Perfiles

- `prod` (default): JWT obligatorio, sin fallback de cabeceras, Swagger apagado.
- `dev`: fallback de cabeceras disponible si `JWT_ENABLED=false`; es el perfil del compose.
- `test`: H2 en memoria, sin Flyway, sin JWT, relay apagado. Lo usa la suite.
