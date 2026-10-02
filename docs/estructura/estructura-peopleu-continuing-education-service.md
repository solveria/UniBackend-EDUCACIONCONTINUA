# Estructura PeopleU Continuing Education Service

```text
peopleu-continuing-education-service/
|-- pom.xml
|-- README.md
|-- Dockerfile
|-- docker-compose.yml
|-- mvnw / mvnw.cmd
|-- docs/
|-- scripts/
`-- src/
    |-- main/java/com/solveria/peopleu/continuinged/
    |   |-- ContinuingEducationServiceApplication.java
    |   |-- shared/
    |   |   |-- api/              ContinuingEducationRequestContext, exception/ContinuingEducationExceptionHandler
    |   |   |-- application/      dto/PagedDto, exception/*, port/IdempotencyPort, port/OutboxDrain
    |   |   |-- infrastructure/   config (JWT, canje, cuenta de servicio, CORS, OpenAPI, reloj),
    |   |   |                     persistence/jdbc/IdempotencyJdbcAdapter, security/PlatformActor
    |   |   `-- outbox/           ContinuingEducationOutboxRelayScheduler
    |   |-- ec01_portafolio_microcredenciales/
    |   |-- ec02_ediciones_oferta_cohortes/
    |   |-- ec03_comercializacion_precios_becas/
    |   |-- ec04_inscripcion_participantes/
    |   |-- ec05_docentes_facilitadores/
    |   |-- ec06_asistencia_participacion/
    |   |-- ec07_evaluacion_completion/
    |   |-- ec08_certificados_credenciales/
    |   |-- ec09_formacion_corporativa/
    |   |-- ec10_trayectoria_stacking/
    |   |-- ec11_feedback_impacto/
    |   |-- ec12_calidad_portafolio/
    |-- main/resources/
    |   |-- application.yml, application-dev.yml, application-test.yml
    |   |-- db/migration/         V001 base; V1NN por modulo
    |   `-- i18n/                 messages_es, messages_en
    `-- test/java/com/solveria/peopleu/continuinged/
        |-- ContinuingEducationServiceApplicationTest   el contexto arranca con el perfil test
        |-- architecture/         CleanArchitectureTest, EndpointsEstanCerradosTest, Modules
        `-- shared/               tests de JWT, canje, contexto y contrato de error
```

Cada modulo tiene las capas `api`, `application`, `domain` e `infrastructure`. Los directorios vacios
se conservan con `.gitkeep` hasta que exista implementacion.

## Forma de un modulo

Igual que los capitulos de PeopleCole. Tomando `ec01_portafolio_microcredenciales` como ejemplo:

```text
ec01_portafolio_microcredenciales/
|-- api/            rest (controladores), request, response, security (EC01Authorization),
|                    exception (solo si el modulo necesita un contrato propio)
|-- application/    command, dto, port (lo que el modulo necesita de afuera), usecase
|-- domain/         model (agregados como records inmutables), statemachine, valueobject,
|                    exception, EC01ErrorCodes
`-- infrastructure/ persistence/jdbc (un adaptador por agregado), integration (adaptadores REST a
                     otros servicios y adaptadores en proceso a otros modulos), config
```

Reglas que el esqueleto ya hace cumplir:

- `domain` no importa Spring ni JPA; `application` no importa `api` ni `infrastructure`; ningun
  modulo importa clases de otro (`CleanArchitectureTest`).
- Todo `@RestController` lleva `@PreAuthorize` en cada endpoint (`EndpointsEstanCerradosTest`).
- Los adaptadores reales hacia otros servicios llevan `@Profile({"integration","prod"})` y sus dobles
  locales `@Profile({"dev","test"})`, para que la suite no encuentre dos beans para el mismo puerto.
- Los nombres de bean de los adaptadores llevan el prefijo del modulo (`EC01StatusHistoryJdbcAdapter`):
  Spring deriva el nombre del bean de la clase y dos modulos con un `StatusHistoryJdbcAdapter`
  no arrancan juntos.

## Alta de un modulo nuevo

1. Agregar el paquete a `architecture/Modules.java` (si no esta) y crear sus cuatro capas.
2. Migracion `V1NN__xxNN_<tema>.sql` con todas sus tablas (prefijo `xxNN_`, `tenant_id` en todo).
3. `api/security/XxNNAuthorization` con las capabilities del modulo, y las mismas en el catalogo de IAM
   (`iam-service/db/migration/products/peopleu/`).
4. Si emite eventos: tabla `xxNN_outbox_event` y un caso de uso que implemente `OutboxDrain`.
5. `docs/capitulos/xxNN/` con la arquitectura del modulo, sus contratos y su Definition of Done.
