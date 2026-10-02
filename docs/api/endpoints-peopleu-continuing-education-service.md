# Endpoints PeopleU Continuing Education Service

El servicio todavia no expone endpoints: es el esqueleto sobre el que entran los modulos EC. Esta
pagina crece con cada modulo; mientras tanto fija el contrato comun.

- Puerto local: `8104`. Swagger: `http://localhost:8104/swagger-ui/index.html`.
- Autenticacion: `Authorization: Bearer <token de IAM>` con audiencia `peopleu-continuing-education-service`.
- Cabeceras: `X-Tenant-Id` (opcional; si viene tiene que coincidir con el token), `Idempotency-Key`
  en toda mutacion sensible, `If-Match` con la `version` del agregado en las actualizaciones.
- El actor sale del JWT: `person_id` (la persona de CT-04) para el identificador y `username` para
  el nombre que se guarda en el historial. **No** se lee `sub`: ahi viaja el id numerico de la cuenta.
- Errores con el sobre de `core-platform`: `code` estable, `message` desde i18n (es/en),
  `correlationId` en el cuerpo y en `X-Correlation-Id`, `fieldErrors` y `details` siempre array.
- Listados con `PagedDto`: `{ data, page, sort, filters }`.

## Convenciones por modulo

| Tema | Forma |
| --- | --- |
| Ruta base | `/api/v1/ec01/...` (el codigo del modulo, en minusculas y sin guion) |
| Acciones | sufijo `:verbo` (`POST /api/v1/ec01/<recurso>/{id}:submit`) |
| Permiso | `ec01.<recurso>.<accion>`, comprobado con `@PreAuthorize("@ec01Authorization.allowed(authentication, '...')")` |
| Codigos HTTP | 400 forma, 403 permiso o alcance, 404, 409 estado o version vieja, 422 regla de negocio, 412 `If-Match` vencido, 503 dependencia caida |

## Codigos de error comunes

| Codigo | HTTP | Cuando |
| --- | --- | --- |
| `VALIDATION_ERROR` | 400 | La forma del request esta mal (`fieldErrors` dice que campo). |
| `CONTINUING_EDUCATION_AUTHENTICATION_REQUIRED` | 400 | Sin JWT y sin fallback de desarrollo. |
| `CONTINUING_EDUCATION_JWT_CONTEXT_INVALID` | 400 | El token no trae `tenant_id`, o no trae persona y no es el administrador de plataforma. |
| `CONTINUING_EDUCATION_PERMISSION_DENIED` | 403 | Falta la capability del endpoint. |
| `CONTINUING_EDUCATION_OPTIMISTIC_LOCK_CONFLICT` | 409 | La fila cambio desde que se leyo. |
| `CONTINUING_EDUCATION_DATA_INTEGRITY_CONFLICT` | 409 | Choca con una unicidad o FK. |
| `CONTINUING_EDUCATION_DEADLOCK_RETRY` | 503 | La base pidio reintentar. |
| `CONTINUING_EDUCATION_SERVICE_UNAVAILABLE` | 503 | La base no responde. |
| `CONTINUING_EDUCATION_UNEXPECTED_ERROR` | 500 | Lo que nadie previo; queda en el log con stack. |

## Modulos

Cada modulo agrega aqui su seccion: permisos, rutas con su permiso, y los codigos `EC01_*`
que devuelve. El detalle vive en `docs/capitulos/<modulo>/contratos-api-<modulo>.md`.
