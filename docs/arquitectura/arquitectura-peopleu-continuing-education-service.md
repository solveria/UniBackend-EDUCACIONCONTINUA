# Arquitectura PeopleU Continuing Education Service

## Decision base

`peopleu-continuing-education-service` es una aplicacion Spring Boot unica organizada por modulos EC, sin modulos Maven ni
microservicios por modulo. Es la misma forma que los servicios de PeopleCole (`campus-ops-service`,
`academic-service`): un bounded context por modulo, cuatro capas, puertos y adaptadores, y un
`shared/` con solo configuracion tecnica.

Los documentos maestros de PeopleU piden "un monolito modular multimodelo hexagonal" con un modulo
Spring por capitulo. Este servicio es eso para su familia; la plataforma lo parte en cuatro servicios
(transversal, pregrado, postgrado, educacion continua) porque esa es la division que ya existe en los
documentos y porque cada vertical tiene ritmo y equipo propio.

```text
api -> application -> domain
infrastructure -> application/domain
```

- `domain`: modelos, maquinas de estado, value objects, reglas y eventos, sin dependencias de
  framework (lo comprueba `CleanArchitectureTest`).
- `application`: comandos, queries, casos de uso y puertos.
- `infrastructure`: persistencia JDBC/JPA, clientes REST a otros servicios, outbox, configuracion.
- `api`: REST, requests, responses, OpenAPI y la clase `XxNNAuthorization` del modulo.
- `shared`: identidad de la peticion, contrato de error, JWT de IAM, canje de tokens, idempotencia,
  relay del outbox. Nada de negocio.

## Modulos propietarios

Un paquete por capitulo del documento maestro de la familia (`PeopleU_IA_EC00_Documento_Maestro_de_Formacion_Continua.md`). La ola es el orden
de construccion que piden los documentos (el maestro de la vertical); dentro de una ola el orden es libre.

| Modulo | Paquete | Responsabilidad | Ola |
| --- | --- | --- | --- |
| `EC-01` | `ec01_portafolio_microcredenciales` | Portafolio, programas, versiones, modulos, outcomes, competencias y rutas de microcredenciales | 1 |
| `EC-02` | `ec02_ediciones_oferta_cohortes` | Ediciones, ofertas, cohortes, modalidades, calendarios, capacidad y programacion | 1 |
| `EC-03` | `ec03_comercializacion_precios_becas` | Comercializacion academica, pricing, promociones, becas y condiciones comerciales | 2 |
| `EC-04` | `ec04_inscripcion_participantes` | Prospecto, registro, inscripcion, cupos, lista de espera, transferencias y retiros | 2 |
| `EC-05` | `ec05_docentes_facilitadores` | Docentes, expertos, delivery plan, contenidos y entorno de aprendizaje | 3 |
| `EC-06` | `ec06_asistencia_participacion` | Asistencia, participacion y engagement | 3 |
| `EC-07` | `ec07_evaluacion_completion` | Evaluacion, integridad, apelaciones, resultados, completion y cierre | 3 |
| `EC-08` | `ec08_certificados_credenciales` | Certificados, badges, microcredenciales y credenciales verificables | 4 |
| `EC-09` | `ec09_formacion_corporativa` | Formacion corporativa o in-company, TNA, sponsor governance y reporting | 5 |
| `EC-10` | `ec10_trayectoria_stacking` | Trayectoria de aprendizaje y stacking | 4 |
| `EC-11` | `ec11_feedback_impacto` | Feedback, NPS, evaluacion docente e impacto | 5 |
| `EC-12` | `ec12_calidad_portafolio` | Calidad, mejora continua y gobierno del portafolio | 5 |

Olas:

1. EC-01, EC-02
2. EC-03, EC-04
3. EC-05, EC-06, EC-07
4. EC-08, EC-10
5. EC-09, EC-11, EC-12

Las olas suponen que el transversal tiene al menos en D2 (modelo y API estables) los CT que la ola consume: CT-01, 02, 03, 04, 08 y 10 antes de la ola 1; CT-05, 06, 07 y 09 antes de la 2; CT-15 antes de la matricula; CT-13/14 antes de la oferta con horario. Mientras no esten, el modulo se desarrolla contra el contrato (OpenAPI) y dobles locales con `@Profile({"dev","test"})`.

## Fronteras

- **Consume al transversal (`peopleu-transversal-service`) y no lo redefine.** Estructura (CT-01),
  politicas (CT-02), calendario y cohortes (CT-03), persona (CT-04), documentos (CT-05), workflow
  (CT-06), notificaciones (CT-07), elegibilidad (CT-15), horarios y recursos (CT-13/14) se piden por
  HTTP con el token canjeado para esa audiencia. Este servicio guarda identificadores de esas cosas,
  nunca copias.
- **La persona es CT-04.** Aca viven `person_id` y los vinculos propios del vertical (postulante,
  estudiante, participante, docente asignado), nunca nombre, documento ni contacto.
- **La IA es `ai-service`.** Ningun modulo integra un proveedor de LLM: pide a `ai-service` con la
  audiencia `ai-service` y aplica la regla de todos los documentos maestros: la IA recomienda y
  explica, nunca decide ni publica.
- **Finanzas y RRHH son externos.** La condicion financiera se consulta, no se copia como deuda local;
  los efectos financieros salen como intenciones por evento. Los docentes externos se modelan
  academicamente sin nomina local.
- **IAM (`iam-service`) posee identidad, credenciales y roles.** Este servicio solo verifica tokens
  (RS256 + JWKS), valida que lo nombren (`aud`) y lee permisos y alcances del token.
- **`core-platform` es una libreria**, no un servicio: filtros de seguridad, contrato de error,
  i18n, observabilidad. Se instala una vez por maquina en el repositorio Maven local.

## Fuentes de verdad y reglas que no se negocian

Las que repiten todos los documentos maestros y que este servicio hace cumplir en codigo:

- **PostgreSQL es la unica fuente de verdad.** Redis solo guarda la lista negra de tokens de IAM;
  MongoDB no se usa (si un modulo necesita una proyeccion, la justifica en su ADR).
- **Lo publicado es inmutable.** Una version (plan, politica, calendario, plantilla) publicada no se
  edita: se crea otra y se reemplaza (`supersede`). Nunca `DELETE` ni `UPDATE` destructivo sobre
  hechos oficiales.
- **Desconocido nunca es favorable.** Un timeout, un `NO_DATA` o una integracion caida no equivalen a
  elegible, pagado, disponible ni aprobado. Las escrituras externas que no contestan quedan en
  `UNKNOWN_EFFECT` y se reconcilian antes de reintentar.
- **Sin llaves foraneas entre modulos.** Un modulo guarda el id de otro y lo consulta por puerto. Lo
  comprueba `CleanArchitectureTest.modulesDoNotReachIntoEachOther`.
- **Toda tabla lleva `tenant_id`** en su clave y en sus FK internas (`UNIQUE (id, tenant_id)` + FK
  compuestas), para que una fila no pueda referenciar a otra de otro tenant ni por error.
- **Todo endpoint lleva `@PreAuthorize`** (`EndpointsEstanCerradosTest`). Las capabilities salen
  del claim `permissions` del token, con la forma `ec01.<recurso>.<accion>`.
- **Comandos sensibles con `Idempotency-Key`** (tabla compartida `peopleu_continuing_education_idempotency_key`) y
  bloqueo optimista por `version`.
- **Eventos por outbox.** Cada modulo escribe `xxNN_outbox_event` en la misma transaccion que el
  hecho y expone un `OutboxDrain`; el relay compartido los publica solo. Nombre del evento:
  `ec01.<entidad>.<accion>.v1`, con `eventId`, `tenantId`, `correlationId`, `causationId`,
  `actor` y `data` (sobre de CT-09).
- **La IA recomienda; una persona decide.** Toda decision sensible (admision, nota, equivalencia,
  tesis, titulo, riesgo) lleva control humano y deja quien, cuando y por que.

## Convenciones que los documentos dejaron abiertas y aqui se fijan

Los documentos maestros mezclan estilos entre capitulos. Para que un modulo nuevo no tenga que
elegir:

| Tema | Convencion en este servicio |
| --- | --- |
| Rutas | `/api/v1/ec01/<recurso>`; acciones como sufijo `:verbo` (`/applications/{id}:submit`). |
| Permisos | `ec01.<recurso>.<accion>` en minusculas; se declaran en `api/security/XxNNAuthorization`. |
| Eventos | `ec01.<entidad>.<accion>.v1`, minusculas y punto. |
| Tablas | Prefijo `ec01_`, esquema `public`, `UUID` y `TIMESTAMPTZ` (UTC), estados `VARCHAR(40)` con `CHECK`, importes `NUMERIC(18,2)`. |
| Migraciones | `V1NN__xxNN_<tema>.sql` donde NN es el numero del modulo; correctivas `V1NN_k`. |
| Codigos de error | `EC01_<MOTIVO>` en `UPPER_SNAKE_CASE`; `VALIDATION_ERROR` solo para la forma. |
| Outbox e idempotencia | Compartidos en `shared` (relay y tabla de claves); no se duplican por modulo. |
| Estados de dato en la UI | `NO_DATA`, `ZERO`, `STALE`, `PARTIAL`, `UNAVAILABLE`, `UNKNOWN_EFFECT`: la API los distingue, nunca devuelve 0 por "no se". |

## Comunicacion

- Entrante: REST con JWT de IAM, audiencia `peopleu-continuing-education-service`.
- Saliente a otro servicio con una persona delante: el token de la persona se canjea en IAM por uno
  para el destino (`BearerTokenForwardingInterceptor`). Sin persona (scheduler, relay): el token de la
  cuenta de servicio `peopleu-continuing-education-service`.
- Entre modulos del mismo servicio: en proceso, por puerto (`application/port`) y adaptador
  (`infrastructure/integration`), nunca por HTTP a si mismo ni leyendo tablas ajenas.
