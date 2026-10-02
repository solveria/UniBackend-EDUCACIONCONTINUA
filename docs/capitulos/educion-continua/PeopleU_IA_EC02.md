**PEOPLEU IA**

**EC-02**

**EDICIONES, OFERTAS, COHORTES, MODALIDADES,  
CALENDARIOS Y PROGRAMACIÓN OPERATIVA**

Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Código** | **Versión** | **Estado** | **Vertical** | **Arquitectura** | **Stack** | **Contexto** | **Fecha base** |
|---|---|---|---|---|---|---|---|
| EC-02 | 1.0 | BASELINE  IMPLEMENTABLE | Educación Continua | DDD · Hexagonal · Spring Modulith | Java 21 · Spring Boot · PostgreSQL · Redis · React/TS · React Native | PeopleU IA | 2026-09-09 |

| **Autoridad documental**                                                                                                                                                                                                                                                               |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| EC-02 operacionaliza EC-00 V1.1 y adopta PeopleU_IA_EC01 V1.1 como plantilla formal, visual y de ingeniería. Conserva el contrato FullStack no negociable, RLS, Aggregate Revision, idempotencia durable, outbox/inbox, UNKNOWN_EFFECT, zero-downtime y QA/Gates como piso de calidad. |

# 0. Declaración de propósito, autoridad y baseline

EC-02 es el bounded context que transforma una definición académica publicada de EC-01 en una ejecución planificable, ofertable y operativamente gobernada. Administra ProgramEdition, Offering, ExecutionCohort, DeliveryPlan, SessionDemand y sus estados, sin duplicar los motores transversales de calendario, scheduling, recursos o ecosistema externo.

La semántica central es: ProgramDefinition/ProgramVersion describen qué se enseña; ProgramEdition determina qué versión se ejecutará bajo un marco operativo concreto; Offering determina cómo esa edición se expone a un público o canal; ExecutionCohort representa la agrupación operativa; DeliveryPlan expresa la intención de ejecución; SessionDemand expresa necesidades de sesión; CT-13 resuelve horarios y CT-14 recursos. EC-02 nunca convierte una intención de scheduling en disponibilidad real por simple asignación local.

## 0.1 Jerarquía documental aplicable

| **Prioridad** | **Artefacto**                         | **Autoridad sobre EC-02**               |
|---------------|---------------------------------------|-----------------------------------------|
| 1             | AM-00 vigente                         | Arquitectura global                     |
| 2             | CT-00 y CT-01…CT-18                   | Capacidades transversales               |
| 3             | EC-00 V1.1                            | Constitución vertical                   |
| 4             | EC-01 V1.1                            | Programa/versiones y contrato FullStack |
| 5             | EC-02                                 | Ejecución operativa de ediciones        |
| 6             | Git/Flyway/OpenAPI/AsyncAPI/tests/ADR | Artefactos ejecutables                  |

## 0.2 Secuencia oficial vigente de módulos EC

| **Orden** | **Módulo** | **Responsabilidad**                                                             |
|-----------|------------|---------------------------------------------------------------------------------|
| 1         | EC-01      | Portafolio, programas, versiones, módulos y microcredenciales                   |
| 2         | EC-02      | Ediciones, ofertas, cohortes, modalidades, calendarios y programación operativa |
| 3         | EC-03      | Comercialización académica, pricing, promociones, becas y condiciones de oferta |
| 4         | EC-04      | Prospectos, participantes, registro, inscripción, cupos y lista de espera       |
| 5         | EC-05      | Docentes, expertos, facilitadores, planificación y entorno de aprendizaje       |
| 6         | EC-06      | Asistencia, participación, engagement y evidencia de sesiones                   |
| 7         | EC-07      | Evaluaciones, resultados, aprobación, completion y cierre académico             |
| 8         | EC-08      | Certificados, badges, microcredenciales y credenciales verificables             |
| 9         | EC-09      | Formación corporativa / in-company                                              |
| 10        | EC-10      | Trayectoria, progresión y stackable credentials                                 |
| 11        | EC-11      | Encuestas, NPS, feedback, impacto y seguimiento                                 |
| 12        | EC-12      | Calidad, analítica de portafolio, compliance y mejora continua                  |

## 0.3 Decisiones arquitectónicas EC02-DA

| **ID**      | **Decisión**                                                                                                                                         |
|-------------|------------------------------------------------------------------------------------------------------------------------------------------------------|
| EC02-DA-001 | ProgramEdition referencia una ProgramVersion PUBLISHED/SCHEDULED válida de EC-01; no copia su contenido como tablas espejo.                          |
| EC02-DA-002 | Offering ≠ ProgramEdition. Una edición puede tener varias ofertas segmentadas por canal, audiencia o territorio sin duplicar la ejecución académica. |
| EC02-DA-003 | ExecutionCohort ≠ Offering. La cohorte es agrupación operativa; la oferta es exposición/condición de acceso.                                         |
| EC02-DA-004 | DeliveryPlan ≠ Schedule. EC-02 expresa demanda; CT-13 resuelve el horario.                                                                           |
| EC02-DA-005 | SessionDemand ≠ SessionOccurrence. La sesión planificada se materializa solo cuando CT-13 entrega un binding/receipt aceptado.                       |
| EC02-DA-006 | Room/Resource ≠ EC-02 entity. CT-14 es Source of Truth de recursos y reservas.                                                                       |
| EC02-DA-007 | Zoom/Teams/Meet/LMS ≠ EC-02 integration ad-hoc. CT-18 media ecosistema externo.                                                                      |
| EC02-DA-008 | Capacity intent ≠ enrollment count. EC-02 define capacidad máxima operativa; EC-04 gestiona participantes/cupos/waitlist.                            |
| EC02-DA-009 | Cancel/reschedule son hechos versionados y auditados; no se borran sesiones/ediciones para corregir historia.                                        |
| EC02-DA-010 | Toda mutación del aggregate Edition/DeliveryPlan bumpa root revision y exige ETag/If-Match.                                                          |
| EC02-DA-011 | RLS FORCE RLS es defensa en profundidad para todas las tablas tenant-scoped.                                                                         |
| EC02-DA-012 | Toda integración de scheduling/reserva con timeout puede terminar en UNKNOWN_EFFECT y exige reconciliation antes de retry.                           |
| EC02-DA-013 | Una oferta puede publicarse solo si su edición está operativamente publicable y las políticas obligatorias están resueltas.                          |
| EC02-DA-014 | Las fechas efectivas se guardan en timestamptz UTC y se presentan en timezone institucional/usuario.                                                 |
| EC02-DA-015 | IA solo recomienda ventanas, riesgos y alternativas mediante CT-12; nunca confirma horarios, reservas o cancelaciones por sí sola.                   |

## 0.4 Criterio de suficiencia FullStack y regla de plantilla

EC-02 replica el criterio de EC-01 V1.1: dos equipos Senior independientes deben poder construir el mismo comportamiento observable, las mismas invariantes, los mismos contratos de error y una experiencia de usuario equivalente sin inventar ownership, estados, reglas o persistencia. Si una decisión crítica queda abierta, debe cerrarse por ADR antes del Gate correspondiente.

# 1. Índice operativo del documento

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal de reglas BR-EC02

- 10\. Casos de uso UC-EC02

- 11\. DER conceptual, lógico y físico

- 12\. Modelo físico PostgreSQL tabla por tabla

- 13\. DDL PostgreSQL completo — Flyway Ready

- 14\. MongoDB y Redis

- 15\. Backend Java 21 / Spring Boot / Spring Modulith

- 16\. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

- 17\. Eventos, outbox/inbox y AsyncAPI

- 18\. Integraciones, resiliencia, reconciliación y UNKNOWN_EFFECT

- 19\. Frontend Web enterprise por workspaces

- 20\. Mobile

- 21\. Matriz Frontend / Backend / Mobile

- 22\. Seguridad: RBAC, ABAC, SoD, step-up y privacy

- 23\. Auditoría, Evidence Pack, lineage y reason codes

- 24\. Observabilidad: logs, metrics, traces, SLI/SLO y performance

- 25\. IA aplicada al módulo

- 26\. Analítica y KPI

- 27\. Migración legacy y Data Quality con CT-16

- 28\. QA y estrategia de pruebas

- 29\. Golden Scenarios

- 30\. UAT institucional

- 31\. Gates G1-G10

- 32\. Definition of Ready / Definition of Done

- 33\. Runbooks

- 34\. ADRs y decisiones abiertas

- 35\. Engineering Pack

- 36\. Guía secuencial Backend

- 37\. Guía secuencial Frontend

- 38\. Matriz de permisos

- 39\. Contratos DTO Frontend

- 40\. Checklist de release y certificación final

- 41\. Contrato FullStack no negociable de implementación

# 2. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

En Educación Continua una misma definición académica puede ejecutarse decenas de veces al año, con distintos calendarios, modalidades, canales, horarios nocturnos o de fin de semana, cohorts abiertas o corporativas y combinaciones presenciales/virtuales. EC-02 evita que cada ejecución se resuelva copiando el programa o creando calendarios manuales desconectados.

El módulo crea una capa operativa estable entre el diseño académico de EC-01 y los motores transversales. Su responsabilidad es congelar qué ProgramVersion se ejecutará, bajo qué ventana, modalidad permitida, audiencia/canal, capacidad, reglas operativas y demanda de sesiones. Scheduling, reservas, aulas y proveedores externos continúan en sus CT.

## 2.1 Incluido

- Crear y versionar ProgramEdition desde ProgramVersion válida de EC-01.

- Definir Offering(s) por edición, audiencia, canal y vigencia.

- Crear ExecutionCohort y su lifecycle operativo.

- Definir DeliveryPlan con modalidad, timezone, ventanas y reglas de sesión.

- Generar SessionDemand desde estructura/módulos de EC-01 sin materializar horarios.

- Enviar demandas a CT-13 y recibir schedule bindings/receipts.

- Solicitar recursos a CT-14 y ecosistema externo a CT-18 mediante ports.

- Publicar, suspender, reprogramar, cancelar y cerrar edición con evidencia.

- Gestionar cambios operativos sin sobrescribir historia.

- Exponer estados operativos claros a EC-03, EC-04, EC-05, EC-06 y portales.

- Reconciliar UNKNOWN_EFFECT en scheduling, reservas y canales externos.

- Operar en multi-tenant/multi-sede/multicampus/multimodalidad/multiidioma.

## 2.2 Fuera de alcance

- Definir el contenido académico del programa — EC-01.

- Precio, descuentos, promociones, becas y ledger financiero — EC-03/Core Financiero.

- Prospectos, inscripción, waitlist y enrollment — EC-04.

- Asignación contractual definitiva de docentes/expertos — EC-05/RRHH.

- Registro de asistencia real — EC-06.

- Evaluación/completion — EC-07.

- Emisión de certificados — EC-08.

- Motor de calendario institucional — CT-03.

- Solver de scheduling — CT-13.

- Inventario/reservas de aulas/equipamiento — CT-14.

- Integración directa con LMS/Zoom/Teams/Meet — CT-18.

| **Separación obligatoria**                                                                                                                                                                         |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| PROGRAM VERSION ≠ PROGRAM EDITION ≠ OFFERING ≠ COHORT ≠ DELIVERY PLAN ≠ SESSION DEMAND ≠ SCHEDULE BINDING. EC-02 mantiene estas diferencias en dominio, API, datos, Frontend, auditoría y eventos. |

# 3. Lenguaje ubicuo y semántica normativa

| **Término**          | **Definición normativa**                                                                                                                                               |
|----------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ProgramEdition       | Instancia operativa histórica que declara qué ProgramVersion se ejecutará, en qué contexto institucional y bajo qué lifecycle. No es una copia editable del currículo. |
| Offering             | Exposición controlada de una edición a una audiencia/canal/territorio/ventana. Puede ser pública, cerrada, invitación o corporativa.                                   |
| ExecutionCohort      | Agrupación operativa para ejecución. No implica inscripción ni participación; EC-04 vincula personas.                                                                  |
| DeliveryPlan         | Contrato de intención operativa de una edición: modalidad, timezone, ventanas, patrón de sesiones y demandas.                                                          |
| SessionDemand        | Necesidad de una sesión académica; expresa duración, ventana, modalidad, capacidades y recursos requeridos. No es un horario confirmado.                               |
| ScheduleBinding      | Receipt/referencia de CT-13 que materializa una demanda en una asignación temporal resuelta.                                                                           |
| ResourceBinding      | Receipt/referencia de CT-14 para un recurso reservado/confirmado.                                                                                                      |
| ChannelBinding       | Referencia/receipt de CT-18 para LMS/videoconferencia u otro canal externo.                                                                                            |
| OperationalPublish   | Transición que hace una edición/oferta consumible downstream; exige gates operativos.                                                                                  |
| Reschedule           | Cambio gobernado del plan/sesión que conserva lineage, reason code, impacto y reconciliación.                                                                          |
| Cancellation         | Cierre anticipado/invalidación operativa con efectos downstream; no borra historia.                                                                                    |
| UNKNOWN_EFFECT       | Estado de incertidumbre tras timeout donde no puede saberse si el sistema externo aplicó el efecto.                                                                    |
| ScheduleReadiness    | Conjunto de precondiciones para enviar demandas a CT-13.                                                                                                               |
| OperationalReadiness | Conjunto de precondiciones para publicar oferta/edición y permitir consumo por EC-03/EC-04.                                                                            |

# 4. Bounded Context y matriz Source of Truth

| **Información**                    | **Source of Truth**   | **EC-02 almacena** | **EC-02 referencia**        | **Regla**                                                                 |
|------------------------------------|-----------------------|--------------------|-----------------------------|---------------------------------------------------------------------------|
| ProgramDefinition / ProgramVersion | EC-01                 | NO                 | program_version_ref         | Solo versiones publicables/vigentes pueden originar edición según policy. |
| ProgramEdition                     | EC-02                 | SÍ                 | —                           | Identidad operativa histórica.                                            |
| Offering                           | EC-02                 | SÍ                 | —                           | Exposición de edición; no pricing financiero.                             |
| ExecutionCohort                    | EC-02                 | SÍ                 | —                           | Agrupación operativa sin participantes.                                   |
| Institutional calendar             | CT-03                 | NO                 | calendar_ref                | No duplicar feriados/reglas globales.                                     |
| Scheduling solution                | CT-13                 | NO                 | schedule_binding_ref        | EC-02 guarda demanda y receipt.                                           |
| Room/resource inventory & booking  | CT-14                 | NO                 | resource_binding_ref        | No FK cross-context.                                                      |
| Eligibility engine                 | CT-15                 | NO                 | eligibility_policy_ref      | Solo referencia si aplica.                                                |
| LMS/Zoom/Teams/Meet                | CT-18                 | NO                 | channel_binding_ref         | Integración por port/adapter.                                             |
| Person                             | CT-04                 | NO                 | actor/subject refs          | No copiar PII.                                                            |
| Workflow approval                  | CT-06                 | NO                 | workflow_instance_ref       | EC-02 conserva snapshot/receipt.                                          |
| Notifications                      | CT-07                 | NO                 | notification_request_ref    | No mini-notification service.                                             |
| Enrollment/participants            | EC-04                 | NO                 | edition/offering/cohort ids | Downstream consume EC-02.                                                 |
| Instructor assignment              | EC-05/RRHH            | NO                 | role_demand only            | EC-02 expresa demanda, no relación laboral.                               |
| Price/payment/invoice              | EC-03/Core Financiero | NO                 | commercial refs only        | Operational ≠ financial ledger.                                           |

# 5. Dependencias CT-01 a CT-18, cores y otros módulos

| **Contexto**   | **Capacidad**                                    | **Relación**              | **Contrato EC-02**                                                      |
|----------------|--------------------------------------------------|---------------------------|-------------------------------------------------------------------------|
| CT-01          | Tenant, universidad, sede, campus, scope         | Obligatoria               | Scope autorizado; tenant nunca viene de body.                           |
| CT-02          | Policies/catálogos/versiones                     | Obligatoria               | Estados/tipos/thresholds no hardcodeados salvo enums técnicos cerrados. |
| CT-03          | Calendarios/temporalidad                         | Crítica                   | calendar_ref y ventanas; fuente de feriados/cierres institucionales.    |
| CT-04          | Persona/identity                                 | Transversal               | Actor refs y owners; sin PII duplicada.                                 |
| CT-05          | Documentos/evidencias                            | Según flujo               | Receipts, evidencias firmadas, anexos; blobs fuera de PostgreSQL.       |
| CT-06          | Workflow/aprobaciones                            | Crítica en publish/cancel | Aprobaciones SoD y SLA.                                                 |
| CT-07          | Notificaciones                                   | Según evento              | Cambios/reprogramaciones/cancelaciones.                                 |
| CT-08          | Localización                                     | Obligatoria               | Labels/descripciones multilenguaje.                                     |
| CT-09          | Integración/eventos                              | Obligatoria               | Contratos/outbox/inbox.                                                 |
| CT-10          | Seguridad/auditoría/privacy                      | Obligatoria               | Audit trail, assurance y purpose.                                       |
| CT-11          | BI                                               | Consumidor                | KPIs operativos sin duplicar BI.                                        |
| CT-12          | IA                                               | Opcional                  | Recomendaciones únicamente.                                             |
| CT-13          | Scheduling                                       | Crítica                   | Resolver SessionDemand.                                                 |
| CT-14          | Recursos/reservas                                | Crítica                   | Aulas/equipamiento/reservas.                                            |
| CT-15          | Elegibilidad                                     | Según oferta              | Reglas de elegibilidad.                                                 |
| CT-16          | Migración/Data Quality                           | Migración                 | Promoción vía dominio.                                                  |
| CT-17          | Continuidad                                      | Obligatoria               | Fallback operativo.                                                     |
| CT-18          | Ecosistema externo/LMS                           | Crítica                   | LMS/videoconferencia/canales.                                           |
| EC-01          | Programa/versiones                               | Upstream obligatoria      | ProgramVersionRef inmutable.                                            |
| EC-03/04/05/06 | Comercialización/inscripción/docencia/asistencia | Downstream                | Consumen edición/oferta/cohorte/sesiones confirmadas.                   |

# 6. Arquitectura funcional E2E y journeys

| **Journey**              | **Flujo**                                                                                            |
|--------------------------|------------------------------------------------------------------------------------------------------|
| J1 — Crear edición       | Seleccionar ProgramVersion válida → definir scope/timezone → políticas → edición DRAFT → revision 1. |
| J2 — Diseñar delivery    | Crear DeliveryPlan → modalidad/patrón → generar SessionDemand → validar ventanas.                    |
| J3 — Resolver scheduling | Submit demands → CT-13 → bindings/UNKNOWN_EFFECT → reconcile → ACCEPTED.                             |
| J4 — Resolver recursos   | Demanda de recurso → CT-14 → receipt → confirmed/partial/unavailable.                                |
| J5 — Preparar canales    | Channel request → CT-18 → LMS/meeting bindings; no credenciales sensibles en EC-02.                  |
| J6 — Publicar edición    | Validaciones → workflow CT-06 → operational readiness → PUBLISHED.                                   |
| J7 — Publicar offering   | Segmentación/audiencia/ventana → policy → PUBLISHED → EC-03/04 consumen.                             |
| J8 — Reprogramar sesión  | Reason → impacto → nueva demanda/binding → supersede anterior → eventos/notificaciones.              |
| J9 — Cancelar edición    | Step-up/SoD → impacto → cancel record → compensaciones downstream → evidence pack.                   |
| J10 — Cerrar edición     | Fin operativo + reconciliation → CLOSED; no implica completion de participantes.                     |

| **Regla E2E crítica**                                                                                                                                                                                                                                      |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| La UI nunca debe presentar “Horario confirmado” mientras solo exista SessionDemand. Solo un ScheduleBinding/receipt validado desde CT-13 habilita el estado CONFIRMED. UNKNOWN_EFFECT se muestra como incertidumbre, nunca como éxito ni fallo definitivo. |

# 7. Modelo de dominio: Aggregates, Entities, Value Objects, Policies y Domain Services

## 7.1 Aggregate Root — ProgramEdition

ProgramEdition es la identidad operativa de una ejecución. Mantiene program_version_ref, scope, timezone, lifecycle, operational policy refs, revision y lineage. Sus hijos Offering, ExecutionCohort y DeliveryPlan se gobiernan bajo comandos que bumpan la revisión del aggregate cuando modifican comportamiento observable.

## 7.2 Aggregate — DeliveryPlan

DeliveryPlan expresa intención operativa. Es versionable dentro de la edición antes de confirmaciones externas; cualquier cambio que afecte ScheduleBinding o ResourceBinding exige workflow de reschedule y no puede sobrescribir silenciosamente receipts previos.

## 7.3 Entity — SessionDemand

SessionDemand es una necesidad académica derivada de la estructura de EC-01: sesión o bloque con duración, ventana temporal, modalidad, role demand, resource demand y restricciones. No contiene aula real, docente real ni meeting URL real como autoridad.

## 7.4 Entity — Offering

Offering controla exposición operativa: open/public, invite-only, corporate, partner o internal. No contiene ledger financiero; puede guardar pricing_context_ref que EC-03 resuelve. Publicar offering no inscribe a nadie.

## 7.5 Entity — ExecutionCohort

ExecutionCohort permite dividir una edición en grupos operativos. El cohort_code es business key por edición; EC-04 puede asociar enrollments posteriormente. EC-02 no guarda listas de personas.

## 7.6 Value Objects

- EditionWindow(start_at,end_at,timezone)

- DeliveryModality(type, synchronous_ratio, asynchronous_ratio)

- SessionWindow(earliest_start,latest_end,preferred_slots)

- CapacityIntent(min,target,max)

- ChannelIntent(channel_type,requirements)

- ResourceDemand(type,capacity,features)

- InstructorRoleDemand(role_type,quantity,skills_ref)

- ScheduleReceiptRef(operation_id,binding_ref,status)

- OperationalReasonCode(code,category,policy_version)

## 7.7 Domain Policies

- EditionCreationPolicy

- OperationalPublishPolicy

- OfferingPublishPolicy

- ScheduleReadinessPolicy

- ReschedulePolicy

- CancellationPolicy

- CapacityIntentPolicy

- ModalityConsistencyPolicy

- SessionGenerationPolicy

- ResourceDemandPolicy

- ExternalChannelPolicy

- ClosurePolicy

## 7.8 Domain Services

- EditionSnapshotService

- SessionDemandGenerationService

- OperationalReadinessService

- ScheduleReconciliationService

- RescheduleImpactService

- CancellationImpactService

- DeliveryPlanDiffService

- ChannelProvisioningCoordinator

## 7.9 Aggregate Revision Contract — obligatorio

Toda mutación de Offering, ExecutionCohort, DeliveryPlan, SessionDemand, resource/channel demand o cambio de binding que altere comportamiento observable debe verificar expectedRootVersion, bloquear/revalidar ProgramEdition, aplicar la mutación, incrementar version y emitir nuevo ETag en la misma transacción. No se permite optimistic locking solo a nivel de fila hija.

# 8. Máquinas de estado normativas

| **Aggregate/Entity** | **Happy-path**                                               | **Estados alternos**                              | **Regla**                                                      |
|----------------------|--------------------------------------------------------------|---------------------------------------------------|----------------------------------------------------------------|
| ProgramEdition       | DRAFT → PLANNING → READY → PUBLISHED → IN_EXECUTION → CLOSED | SUSPENDED / CANCELLED                             | PUBLISHED requiere readiness; CLOSED no equivale a completion. |
| Offering             | DRAFT → REVIEW → PUBLISHED → CLOSED                          | SUSPENDED / CANCELLED                             | Solo PUBLISHED visible downstream.                             |
| DeliveryPlan         | DRAFT → VALIDATED → SUBMITTED → PARTIAL/CONFIRMED            | SUPERSEDED / CANCELLED                            | CONFIRMED requiere bindings coherentes.                        |
| SessionDemand        | DRAFT → READY → SUBMITTED → BOUND                            | PARTIAL / UNKNOWN_EFFECT / CANCELLED / SUPERSEDED | BOUND solo con CT-13 receipt.                                  |
| External binding     | REQUESTED → CONFIRMED                                        | PARTIAL / FAILED / UNKNOWN_EFFECT / RELEASED      | Retry tras reconcile si UNKNOWN_EFFECT.                        |

## 8.1 Transiciones prohibidas

- DRAFT → PUBLISHED sin readiness/workflow.

- CANCELLED → IN_EXECUTION.

- BOUND → DRAFT destruyendo receipt.

- UNKNOWN_EFFECT → FAILED sin reconciliation.

- CLOSED → DRAFT; corrección exige nueva edición o supersede gobernado.

- PUBLISHED Offering con Edition no publicable.

# 9. Catálogo formal de reglas BR-EC02

| **ID**      | **Regla**                                                                                                     |
|-------------|---------------------------------------------------------------------------------------------------------------|
| BR-EC02-001 | Una ProgramEdition debe referenciar exactamente una ProgramVersion de EC-01 resoluble y permitida por policy. |
| BR-EC02-002 | tenant_id se deriva del contexto autorizado y nunca del body libre.                                           |
| BR-EC02-003 | edition_code es único por tenant y no se reutiliza tras cancelación.                                          |
| BR-EC02-004 | La timezone de edición debe ser IANA válida.                                                                  |
| BR-EC02-005 | start_at debe ser anterior a end_at.                                                                          |
| BR-EC02-006 | Una edición publicada no puede cambiar program_version_ref.                                                   |
| BR-EC02-007 | Cambios materiales a una edición publicada se modelan como reschedule/supersede, no UPDATE destructivo.       |
| BR-EC02-008 | Offering debe pertenecer a la misma edición/tenant.                                                           |
| BR-EC02-009 | Offering PUBLISHED exige edition READY/PUBLISHED según policy.                                                |
| BR-EC02-010 | Una Offering no contiene precio oficial ni saldo.                                                             |
| BR-EC02-011 | ExecutionCohort no contiene personas; EC-04 es dueño de participantes.                                        |
| BR-EC02-012 | capacity_max debe ser \>0 cuando se declara.                                                                  |
| BR-EC02-013 | capacity_target no puede exceder capacity_max.                                                                |
| BR-EC02-014 | capacity_min no puede exceder capacity_target cuando ambos existen.                                           |
| BR-EC02-015 | DeliveryPlan debe declarar al menos una modalidad.                                                            |
| BR-EC02-016 | Porcentajes síncrono/asíncrono, si se usan, deben sumar 100 dentro de tolerancia policy.                      |
| BR-EC02-017 | SessionDemand debe tener duración positiva.                                                                   |
| BR-EC02-018 | Ventana earliest_start debe ser anterior a latest_end.                                                        |
| BR-EC02-019 | SessionDemand no puede materializar aula o meeting URL como autoridad local.                                  |
| BR-EC02-020 | Toda demanda enviada a CT-13 usa idempotency key durable.                                                     |
| BR-EC02-021 | Timeout de CT-13 produce UNKNOWN_EFFECT hasta reconciliation.                                                 |
| BR-EC02-022 | Retry ciego está prohibido cuando puede existir efecto remoto.                                                |
| BR-EC02-023 | ScheduleBinding se acepta solo si corresponde al operation/correlation esperado.                              |
| BR-EC02-024 | ResourceBinding se valida contra tenant/scope lógico por contrato.                                            |
| BR-EC02-025 | ChannelBinding no almacena secretos del proveedor.                                                            |
| BR-EC02-026 | Toda reprogramación conserva referencia al binding anterior superseded.                                       |
| BR-EC02-027 | Cancelar una sesión confirmada debe intentar liberar recursos/canales mediante operación idempotente.         |
| BR-EC02-028 | Fallo al liberar recurso puede quedar PARTIAL/UNKNOWN_EFFECT con runbook.                                     |
| BR-EC02-029 | La publicación operativa exige workflow/SoD cuando policy lo requiera.                                        |
| BR-EC02-030 | El actor que solicita cancelación no puede autoaprobar cuando SoD esté activado.                              |
| BR-EC02-031 | Step-up es obligatorio para cancelación masiva o cambio crítico según policy.                                 |
| BR-EC02-032 | Toda mutación del aggregate bumpa root version.                                                               |
| BR-EC02-033 | If-Match incorrecto devuelve 412.                                                                             |
| BR-EC02-034 | PATCH genérico no puede ejecutar transición de dominio crítica.                                               |
| BR-EC02-035 | Los comandos sensibles requieren Idempotency-Key.                                                             |
| BR-EC02-036 | Outbox se escribe en la misma transacción que el cambio de dominio.                                           |
| BR-EC02-037 | Inbox deduplica integration events consumidos.                                                                |
| BR-EC02-038 | RLS FORCE RLS se aplica a tablas tenant-scoped.                                                               |
| BR-EC02-039 | Runtime DB role no tiene BYPASSRLS.                                                                           |
| BR-EC02-040 | Migration role es separado del runtime role.                                                                  |
| BR-EC02-041 | No existen FKs físicas hacia CT/EC externos.                                                                  |
| BR-EC02-042 | Toda referencia cross-context se valida por port/contract.                                                    |
| BR-EC02-043 | NO_DATA ≠ ZERO ≠ STALE ≠ PARTIAL ≠ UNAVAILABLE ≠ UNKNOWN_EFFECT en Frontend.                                  |
| BR-EC02-044 | La UI no muestra CONFIRMED sin receipt válido.                                                                |
| BR-EC02-045 | Fechas se persisten como timestamptz UTC.                                                                     |
| BR-EC02-046 | Presentation timezone proviene de edición/institución/usuario.                                                |
| BR-EC02-047 | Policy refs deben apuntar a versiones inmutables o snapshot equivalente.                                      |
| BR-EC02-048 | Reason code es obligatorio para reschedule/cancel/suspend.                                                    |
| BR-EC02-049 | No se borra historia operativa institucional.                                                                 |
| BR-EC02-050 | CLOSED no implica que todos los participantes aprobaron/completaron.                                          |
| BR-EC02-051 | EC-02 no publica certificados.                                                                                |
| BR-EC02-052 | EC-02 no factura.                                                                                             |
| BR-EC02-053 | EC-02 no asigna docentes como relación laboral.                                                               |
| BR-EC02-054 | IA recomendadora no cambia estados críticos.                                                                  |
| BR-EC02-055 | Toda sugerencia IA conserva run_ref/model_ref/eval/grounding/outcome.                                         |
| BR-EC02-056 | Capacity budgets protegen grafos/listados/payloads de abuso o degradación.                                    |
| BR-EC02-057 | List endpoints deben tener paginación, filtros y sort estable.                                                |
| BR-EC02-058 | 202 debe devolver operationId y endpoint de status.                                                           |
| BR-EC02-059 | ProblemDetail utiliza reason codes estables.                                                                  |
| BR-EC02-060 | 503 representa dependencia crítica unavailable, no regla de negocio.                                          |
| BR-EC02-061 | 422 representa violación de regla de negocio implementable.                                                   |
| BR-EC02-062 | 409 se usa para conflicto de estado, 412 para versión/ETag.                                                   |
| BR-EC02-063 | Migración legacy promueve datos mediante dominio/API, nunca INSERT directo final.                             |
| BR-EC02-064 | Publication receipt/evidence es append-only.                                                                  |
| BR-EC02-065 | Reconciliation produce receipt durable.                                                                       |
| BR-EC02-066 | Schedule change event incluye correlation_id y causation_id.                                                  |
| BR-EC02-067 | Un duplicado de mensaje no duplica effects.                                                                   |
| BR-EC02-068 | Un comando repetido con misma Idempotency-Key devuelve resultado consistente.                                 |
| BR-EC02-069 | Zero-downtime migrations deben ser expand/contract N/N-1.                                                     |
| BR-EC02-070 | Feature flags no deben crear dos fuentes de verdad.                                                           |
| BR-EC02-071 | Audit trail registra tenant/actor/action/resource/reason/policy/correlation/evidence.                         |
| BR-EC02-072 | Logs nunca exponen secretos de proveedores ni PII innecesaria.                                                |

# 10. Casos de uso UC-EC02

| **ID**      | **Caso de uso**                          |
|-------------|------------------------------------------|
| UC-EC02-001 | Crear edición desde ProgramVersion       |
| UC-EC02-002 | Editar metadata de edición               |
| UC-EC02-003 | Clonar edición                           |
| UC-EC02-004 | Definir ventana operativa                |
| UC-EC02-005 | Crear offering                           |
| UC-EC02-006 | Publicar offering                        |
| UC-EC02-007 | Suspender offering                       |
| UC-EC02-008 | Cerrar offering                          |
| UC-EC02-009 | Crear cohorte                            |
| UC-EC02-010 | Editar capacidad de cohorte              |
| UC-EC02-011 | Crear DeliveryPlan                       |
| UC-EC02-012 | Definir modalidad                        |
| UC-EC02-013 | Generar SessionDemand desde EC-01        |
| UC-EC02-014 | Agregar demanda manual gobernada         |
| UC-EC02-015 | Validar delivery plan                    |
| UC-EC02-016 | Enviar demandas a CT-13                  |
| UC-EC02-017 | Consultar operación asíncrona            |
| UC-EC02-018 | Reconciliar UNKNOWN_EFFECT de scheduling |
| UC-EC02-019 | Aceptar schedule bindings                |
| UC-EC02-020 | Solicitar recursos CT-14                 |
| UC-EC02-021 | Reconciliar resource binding             |
| UC-EC02-022 | Provisionar canal CT-18                  |
| UC-EC02-023 | Reconciliar channel provisioning         |
| UC-EC02-024 | Marcar readiness                         |
| UC-EC02-025 | Solicitar publicación de edición         |
| UC-EC02-026 | Aprobar publicación                      |
| UC-EC02-027 | Publicar edición                         |
| UC-EC02-028 | Iniciar ejecución                        |
| UC-EC02-029 | Reprogramar sesión                       |
| UC-EC02-030 | Reprogramar edición                      |
| UC-EC02-031 | Suspender edición                        |
| UC-EC02-032 | Reactivar edición                        |
| UC-EC02-033 | Cancelar sesión                          |
| UC-EC02-034 | Cancelar edición                         |
| UC-EC02-035 | Cerrar edición                           |
| UC-EC02-036 | Comparar delivery plans                  |
| UC-EC02-037 | Simular impacto de reprogramación        |
| UC-EC02-038 | Importar edición legacy dry-run          |
| UC-EC02-039 | Promover edición migrada                 |
| UC-EC02-040 | Consultar dashboard operativo            |
| UC-EC02-041 | Exportar evidence pack                   |
| UC-EC02-042 | Resolver conflicto ETag                  |
| UC-EC02-043 | Reintentar comando idempotente           |
| UC-EC02-044 | Reprocesar outbox                        |
| UC-EC02-045 | Reprocesar inbox fallido                 |
| UC-EC02-046 | Solicitar recomendación IA               |
| UC-EC02-047 | Aceptar recomendación IA como borrador   |
| UC-EC02-048 | Rechazar recomendación IA                |

## 10.1 Casos críticos desarrollados

### UC-EC02-001 — Crear edición desde ProgramVersion

| **Elemento**           | **Detalle**                                                    |
|------------------------|----------------------------------------------------------------|
| Actor                  | Program Manager                                                |
| Trigger                | Selecciona una ProgramVersion publicada                        |
| Precondiciones         | ProgramVersion resoluble; scope autorizado                     |
| Autorización / comando | POST /editions con Idempotency-Key                             |
| Happy Path             | Se valida EC-01 por port, se crea DRAFT, outbox EditionCreated |
| Alternativas / errores | 422 versión no elegible; 503 EC-01 unavailable                 |
| Idempotencia           | Durable                                                        |
| Concurrencia           | root version=0                                                 |
| Auditoría              | actor+policy snapshot                                          |
| Eventos                | EditionCreated                                                 |
| Postcondición          | Edition DRAFT creada.                                          |

### UC-EC02-016 — Enviar demandas a CT-13

| **Elemento**           | **Detalle**                                              |
|------------------------|----------------------------------------------------------|
| Actor                  | Scheduler Operator                                       |
| Trigger                | DeliveryPlan VALIDATED                                   |
| Precondiciones         | SessionDemand READY                                      |
| Autorización / comando | Command submitSchedule                                   |
| Happy Path             | Persist operation + outbox/request; adapter invoca CT-13 |
| Alternativas / errores | timeout→UNKNOWN_EFFECT; 422 demanda inválida             |
| Idempotencia           | Sí                                                       |
| Concurrencia           | ETag root                                                |
| Auditoría              | correlation+receipt                                      |
| Eventos                | ScheduleRequested                                        |
| Postcondición          | Operación trazable.                                      |

### UC-EC02-018 — Reconciliar UNKNOWN_EFFECT

| **Elemento**           | **Detalle**                                  |
|------------------------|----------------------------------------------|
| Actor                  | Ops                                          |
| Trigger                | Operation UNKNOWN_EFFECT                     |
| Precondiciones         | receipt no conclusivo                        |
| Autorización / comando | GET/command reconcile                        |
| Happy Path             | Consulta status remoto antes de retry        |
| Alternativas / errores | 503 remoto unavailable; sigue UNKNOWN_EFFECT |
| Idempotencia           | Sí                                           |
| Concurrencia           | operation version                            |
| Auditoría              | Evidence de reconcile                        |
| Eventos                | ScheduleReconciled                           |
| Postcondición          | CONFIRMED/FAILED/UNKNOWN_EFFECT.             |

### UC-EC02-027 — Publicar edición

| **Elemento**           | **Detalle**                                               |
|------------------------|-----------------------------------------------------------|
| Actor                  | Academic/Ops Approver                                     |
| Trigger                | Workflow aprobado                                         |
| Precondiciones         | Readiness PASS                                            |
| Autorización / comando | POST /editions/{id}:publish                               |
| Happy Path             | Revalida gates, bump version, receipt append-only, outbox |
| Alternativas / errores | 409 estado; 412 ETag; 422 gate                            |
| Idempotencia           | Sí                                                        |
| Concurrencia           | If-Match obligatorio                                      |
| Auditoría              | SoD+step-up según policy                                  |
| Eventos                | EditionPublished                                          |
| Postcondición          | PUBLISHED.                                                |

### UC-EC02-029 — Reprogramar sesión

| **Elemento**           | **Detalle**                                                            |
|------------------------|------------------------------------------------------------------------|
| Actor                  | Scheduler Operator                                                     |
| Trigger                | Cambio requerido                                                       |
| Precondiciones         | binding actual existente                                               |
| Autorización / comando | POST /sessions/{id}:reschedule                                         |
| Happy Path             | Crea change request, nueva demanda, reconcile, supersede binding viejo |
| Alternativas / errores | UNKNOWN_EFFECT/partial resources                                       |
| Idempotencia           | Sí                                                                     |
| Concurrencia           | root version                                                           |
| Auditoría              | reason+before/after                                                    |
| Eventos                | SessionRescheduled                                                     |
| Postcondición          | Historia preservada.                                                   |

### UC-EC02-034 — Cancelar edición

| **Elemento**           | **Detalle**                                                |
|------------------------|------------------------------------------------------------|
| Actor                  | Authorized Approver                                        |
| Trigger                | Decisión institucional                                     |
| Precondiciones         | Impacto calculado                                          |
| Autorización / comando | POST /editions/{id}:cancel                                 |
| Happy Path             | Step-up, workflow, cancel record, compensations downstream |
| Alternativas / errores | effects partial/unknown                                    |
| Idempotencia           | Sí                                                         |
| Concurrencia           | root version                                               |
| Auditoría              | Evidence Pack completo                                     |
| Eventos                | EditionCancelled                                           |
| Postcondición          | CANCELLED sin borrar historia.                             |

# 11. DER conceptual, lógico y físico

## 11.1 DER conceptual

ProgramVersionRef (EC-01)  
\|  
v  
ProgramEdition 1----\* Offering  
\| 1----\* ExecutionCohort  
\| 1----\* DeliveryPlan  
\| 1----\* SessionDemand  
\| \| 0..\* ScheduleBindingReceipt (EXT CT-13)  
\| \| 0..\* ResourceBindingReceipt (EXT CT-14)  
\| \| 0..\* ChannelBindingReceipt (EXT CT-18)  
\|  
\*---- OperationalChangeRequest  
ProgramEdition 1----\* PublicationReceipt  
ProgramEdition 1----\* CancellationRecord

## 11.2 DER lógico

Las relaciones internas utilizan claves compuestas (tenant_id, id). Referencias a EC-01/CT se almacenan como EXT REF sin FK física. Todos los hijos que alteran el aggregate Edition se coordinan mediante aggregate revision. Receipts externos son append-only y contienen operation_id/correlation_id para reconciliation.

## 11.3 DER físico resumido

| **Tabla**                       | **Aggregate/rol** | **Relaciones internas**           | **Referencias externas**                 |
|---------------------------------|-------------------|-----------------------------------|------------------------------------------|
| ec02_program_edition            | Root              | 1:N offering/cohort/delivery_plan | program_version_ref, scope_ref, policies |
| ec02_offering                   | Entity            | N:1 edition                       | audience/catalog refs                    |
| ec02_execution_cohort           | Entity            | N:1 edition                       | calendar_ref optional                    |
| ec02_delivery_plan              | Aggregate child   | N:1 edition; 1:N session_demand   | calendar_ref/policies                    |
| ec02_session_demand             | Entity            | N:1 delivery_plan                 | CT-13/14/18 demands                      |
| ec02_schedule_binding_receipt   | Receipt           | N:1 session_demand                | CT-13 binding                            |
| ec02_resource_binding_receipt   | Receipt           | N:1 session_demand                | CT-14 binding                            |
| ec02_channel_binding_receipt    | Receipt           | N:1 session_demand                | CT-18 binding                            |
| ec02_operational_change_request | Workflow fact     | N:1 edition/session               | CT-06 workflow                           |
| ec02_publication_receipt        | Evidence          | N:1 edition/offering              | CT-05 evidence_ref                       |
| ec02_cancellation_record        | History           | N:1 edition/session               | downstream effects                       |
| ec02_operation_status           | Async ops         | by tenant/operation               | external operation refs                  |
| ec02_idempotency_record         | Technical durable | command-scoped                    | —                                        |
| ec02_outbox_event               | Integration       | aggregate-scoped                  | CT-09                                    |
| ec02_inbox_receipt              | Integration       | message-scoped                    | CT-09                                    |

# 12. Modelo físico PostgreSQL tabla por tabla

El esquema propuesto es ec02. Todas las tablas tenant-scoped usan claves compuestas o aislamiento lógico equivalente, RLS FORCE RLS y runtime role sin BYPASSRLS. Las FKs físicas solo existen dentro de EC-02. Toda mutación de hijos que altere el aggregate incrementa ec02_program_edition.version.

## 12.1 ec02_program_edition

QUÉ REPRESENTA — la identidad operativa histórica de una ejecución de ProgramVersion Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea un Program Manager desde EC-01; pasa por planning/readiness/publication/execution/closure y emite eventos de lifecycle. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — integridad tenant, referencia de versión, ventanas, lifecycle y revisión. No representa inscripción ni horario resuelto. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                   | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|-----------|-----------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK        | Tenant autorizado.                | 8f…               |
| edition_id             | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico de edición. | e1…               |
| edition_code           | varchar(64)         | NO       | —                 |           | Business key institucional.       | EC-2026-045       |
| program_version_ref    | uuid                | NO       | —                 | EXT REF   | Versión EC-01 ejecutada.          | pv-…              |
| institution_scope_ref  | uuid                | NO       | —                 | EXT REF   | Sede/campus/scope CT-01.          | scope-…           |
| timezone_id            | varchar(64)         | NO       | —                 |           | Timezone IANA.                    | America/La_Paz    |
| planned_start_at       | timestamptz         | NO       | —                 |           | Inicio planificado UTC.           | 2026-10-01T22:00Z |
| planned_end_at         | timestamptz         | NO       | —                 |           | Fin planificado UTC.              | 2026-11-15T02:00Z |
| lifecycle_state        | varchar(24)         | NO       | DRAFT             |           | Estado normativo.                 | PLANNING          |
| publication_policy_ref | uuid                | SÍ       | NULL              | EXT REF   | Policy version CT-02.             | policy-…          |
| workflow_instance_ref  | uuid                | SÍ       | NULL              | EXT REF   | Workflow CT-06.                   | wf-…              |
| version                | bigint              | NO       | 0                 |           | Aggregate revision.               | 7                 |
| created_by_subject     | uuid                | NO       | —                 | EXT REF   | Actor creador.                    | sub-…             |
| created_at             | timestamptz         | NO       | now()             |           | Creación UTC.                     | …                 |
| updated_at             | timestamptz         | NO       | now()             |           | Última modificación.              | …                 |

### Explicación individual de atributos

tenant_id — Tenant autorizado. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

edition_id — Identificador técnico de edición. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

edition_code — Business key institucional. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: EC-2026-045.

program_version_ref — Versión EC-01 ejecutada. Es obligatorio. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: pv-….

institution_scope_ref — Sede/campus/scope CT-01. Es obligatorio. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: scope-….

timezone_id — Timezone IANA. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: America/La_Paz.

planned_start_at — Inicio planificado UTC. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 2026-10-01T22:00Z.

planned_end_at — Fin planificado UTC. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 2026-11-15T02:00Z.

lifecycle_state — Estado normativo. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: PLANNING.

publication_policy_ref — Policy version CT-02. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: policy-….

workflow_instance_ref — Workflow CT-06. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: wf-….

version — Aggregate revision. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 7.

created_by_subject — Actor creador. Es obligatorio. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sub-….

created_at — Creación UTC. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

updated_at — Última modificación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_program_edition nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**            | **Tipo** | **Definición / expresión**                                                                                  | **Error que impide**    |
|------------------------------|----------|-------------------------------------------------------------------------------------------------------------|-------------------------|
| pk_ec02_program_edition      | PK       | PRIMARY KEY (tenant_id, edition_id)                                                                         | duplicidad técnica      |
| uq_ec02_program_edition_code | UNIQUE   | UNIQUE (tenant_id, edition_code)                                                                            | reuso de business key   |
| ck_ec02_edition_window       | CHECK    | planned_start_at \< planned_end_at                                                                          | ventana inválida        |
| ck_ec02_edition_state        | CHECK    | lifecycle_state IN ('DRAFT','PLANNING','READY','PUBLISHED','IN_EXECUTION','SUSPENDED','CANCELLED','CLOSED') | estado imposible        |
| ix_ec02_edition_program      | INDEX    | (tenant_id, program_version_ref, lifecycle_state)                                                           | scans operativos lentos |

| **Última línea de defensa PostgreSQL**                                                                                                                       |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir cruces tenant, business keys duplicados, ventanas negativas y estados no permitidos. |

## 12.2 ec02_offering

QUÉ REPRESENTA — la exposición operativa de una edición a una audiencia/canal Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea bajo ProgramEdition y se publica/cierra independientemente dentro de reglas de readiness. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — segmentación, ventana de visibilidad y lifecycle; no representa precio, pago ni enrollment. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                         | **Ejemplo** |
|------------------------|---------------------|----------|-------------------|-----------|-----------------------------------------|-------------|
| tenant_id              | uuid                | NO       | —                 | PK/FK     | Tenant.                                 | 8f…         |
| offering_id            | uuid                | NO       | gen_random_uuid() | PK        | ID offering.                            | of-…        |
| edition_id             | uuid                | NO       | —                 | FK        | Edición padre.                          | e1…         |
| offering_code          | varchar(64)         | NO       | —                 |           | Código visible/operativo.               | OPEN-OCT-01 |
| offering_type          | varchar(24)         | NO       | —                 |           | OPEN/INVITE/CORPORATE/PARTNER/INTERNAL. | OPEN        |
| audience_ref           | uuid                | SÍ       | NULL              | EXT REF   | Segmento CT-02/externo.                 | aud-…       |
| channel_code           | varchar(32)         | NO       | WEB               |           | Canal de exposición.                    | WEB         |
| visible_from           | timestamptz         | SÍ       | NULL              |           | Inicio visibilidad.                     | …           |
| visible_until          | timestamptz         | SÍ       | NULL              |           | Fin visibilidad.                        | …           |
| eligibility_policy_ref | uuid                | SÍ       | NULL              | EXT REF   | CT-15.                                  | pol-…       |
| pricing_context_ref    | uuid                | SÍ       | NULL              | EXT REF   | EC-03, no ledger.                       | pricectx-…  |
| state                  | varchar(20)         | NO       | DRAFT             |           | Lifecycle offering.                     | PUBLISHED   |
| version                | bigint              | NO       | 0                 |           | Revision local coordinada con root.     | 3           |
| created_at             | timestamptz         | NO       | now()             |           | Creación.                               | …           |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

offering_id — ID offering. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: of-….

edition_id — Edición padre. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

offering_code — Código visible/operativo. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: OPEN-OCT-01.

offering_type — OPEN/INVITE/CORPORATE/PARTNER/INTERNAL. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: OPEN.

audience_ref — Segmento CT-02/externo. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: aud-….

channel_code — Canal de exposición. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: WEB.

visible_from — Inicio visibilidad. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

visible_until — Fin visibilidad. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

eligibility_policy_ref — CT-15. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: pol-….

pricing_context_ref — EC-03, no ledger. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: pricectx-….

state — Lifecycle offering. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: PUBLISHED.

version — Revision local coordinada con root. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 3.

created_at — Creación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_offering nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**        | **Tipo** | **Definición / expresión**                                                               | **Error que impide**           |
|--------------------------|----------|------------------------------------------------------------------------------------------|--------------------------------|
| pk_ec02_offering         | PK       | PRIMARY KEY (tenant_id, offering_id)                                                     | duplicado                      |
| fk_ec02_offering_edition | FK       | FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02_program_edition(tenant_id,edition_id) | offering huérfano/cross-tenant |
| uq_ec02_offering_code    | UNIQUE   | UNIQUE (tenant_id, edition_id, offering_code)                                            | código duplicado               |
| ck_ec02_offering_window  | CHECK    | visible_from IS NULL OR visible_until IS NULL OR visible_from \< visible_until           | ventana inválida               |
| ck_ec02_offering_state   | CHECK    | state IN ('DRAFT','REVIEW','PUBLISHED','SUSPENDED','CANCELLED','CLOSED')                 | estado imposible               |

| **Última línea de defensa PostgreSQL**                                                                                                            |
|---------------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir offering huérfano/cross-tenant, ventanas invertidas y códigos duplicados. |

## 12.3 ec02_execution_cohort

QUÉ REPRESENTA — un grupo operativo de ejecución sin participantes Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea Operaciones para segmentar delivery; EC-04 puede referenciarla al inscribir personas. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — identidad, capacidad intencional y estado; no contiene roster ni asistencia. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**           | **Ejemplo**   |
|-----------------|---------------------|----------|-------------------|-----------|---------------------------|---------------|
| tenant_id       | uuid                | NO       | —                 | PK/FK     | Tenant.                   | 8f…           |
| cohort_id       | uuid                | NO       | gen_random_uuid() | PK        | ID cohorte.               | co-…          |
| edition_id      | uuid                | NO       | —                 | FK        | Edición padre.            | e1…           |
| cohort_code     | varchar(64)         | NO       | —                 |           | Business key por edición. | GRUPO-A       |
| display_name    | varchar(160)        | NO       | —                 |           | Nombre operacional.       | Grupo A noche |
| capacity_min    | integer             | SÍ       | NULL              |           | Mínimo intentado.         | 15            |
| capacity_target | integer             | SÍ       | NULL              |           | Objetivo.                 | 25            |
| capacity_max    | integer             | SÍ       | NULL              |           | Máximo.                   | 30            |
| state           | varchar(20)         | NO       | DRAFT             |           | Estado.                   | ACTIVE        |
| version         | bigint              | NO       | 0                 |           | Revision.                 | 2             |
| created_at      | timestamptz         | NO       | now()             |           | Creación.                 | …             |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

cohort_id — ID cohorte. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: co-….

edition_id — Edición padre. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

cohort_code — Business key por edición. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: GRUPO-A.

display_name — Nombre operacional. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: Grupo A noche.

capacity_min — Mínimo intentado. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 15.

capacity_target — Objetivo. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 25.

capacity_max — Máximo. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 30.

state — Estado. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ACTIVE.

version — Revision. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 2.

created_at — Creación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_execution_cohort nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**      | **Tipo** | **Definición / expresión**                                                                                                                                                                                                                                                                                                  | **Error que impide**     |
|------------------------|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------|
| pk_ec02_cohort         | PK       | PRIMARY KEY (tenant_id, cohort_id)                                                                                                                                                                                                                                                                                          | duplicado                |
| fk_ec02_cohort_edition | FK       | FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02_program_edition(tenant_id,edition_id)                                                                                                                                                                                                                                    | cohorte huérfana         |
| uq_ec02_cohort_code    | UNIQUE   | UNIQUE (tenant_id,edition_id,cohort_code)                                                                                                                                                                                                                                                                                   | código duplicado         |
| ck_ec02_cohort_caps    | CHECK    | (capacity_min IS NULL OR capacity_min\>0) AND (capacity_target IS NULL OR capacity_target\>0) AND (capacity_max IS NULL OR capacity_max\>0) AND (capacity_min IS NULL OR capacity_target IS NULL OR capacity_min\<=capacity_target) AND (capacity_target IS NULL OR capacity_max IS NULL OR capacity_target\<=capacity_max) | capacidades incoherentes |

| **Última línea de defensa PostgreSQL**                                                                                                       |
|----------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir capacidades negativas/invertidas, cohortes huérfanas y cross-tenant. |

## 12.4 ec02_delivery_plan

QUÉ REPRESENTA — la intención operativa versionable de entrega de una edición/cohorte Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se construye en Planning; se valida, envía a scheduling y puede supersederse mediante change workflow. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — modalidad, patrón y estado; no representa horario confirmado. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                         | **Ejemplo** |
|--------------------|---------------------|----------|-------------------|-----------|-----------------------------------------|-------------|
| tenant_id          | uuid                | NO       | —                 | PK/FK     | Tenant.                                 | 8f…         |
| delivery_plan_id   | uuid                | NO       | gen_random_uuid() | PK        | ID plan.                                | dp-…        |
| edition_id         | uuid                | NO       | —                 | FK        | Edición.                                | e1…         |
| cohort_id          | uuid                | SÍ       | NULL              | FK        | Cohorte específica o NULL para edición. | co-…        |
| plan_no            | integer             | NO       | 1                 |           | Número versionado.                      | 2           |
| calendar_ref       | uuid                | SÍ       | NULL              | EXT REF   | Calendario CT-03.                       | cal-…       |
| modality_code      | varchar(24)         | NO       | —                 |           | PRESENTIAL/SYNC/ASYNC/HYBRID.           | HYBRID      |
| sync_ratio         | numeric(5,2)        | SÍ       | NULL              |           | Porcentaje síncrono.                    | 70.00       |
| async_ratio        | numeric(5,2)        | SÍ       | NULL              |           | Porcentaje asíncrono.                   | 30.00       |
| state              | varchar(24)         | NO       | DRAFT             |           | Estado plan.                            | VALIDATED   |
| supersedes_plan_id | uuid                | SÍ       | NULL              | FK        | Lineage interno.                        | dp-prev     |
| version            | bigint              | NO       | 0                 |           | Revision.                               | 4           |
| created_at         | timestamptz         | NO       | now()             |           | Creación.                               | …           |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

delivery_plan_id — ID plan. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: dp-….

edition_id — Edición. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

cohort_id — Cohorte específica o NULL para edición. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: co-….

plan_no — Número versionado. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 2.

calendar_ref — Calendario CT-03. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: cal-….

modality_code — PRESENTIAL/SYNC/ASYNC/HYBRID. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: HYBRID.

sync_ratio — Porcentaje síncrono. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 70.00.

async_ratio — Porcentaje asíncrono. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 30.00.

state — Estado plan. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: VALIDATED.

supersedes_plan_id — Lineage interno. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: dp-prev.

version — Revision. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 4.

created_at — Creación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_delivery_plan nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**     | **Tipo** | **Definición / expresión**                                                                 | **Error que impide** |
|-----------------------|----------|--------------------------------------------------------------------------------------------|----------------------|
| pk_ec02_delivery_plan | PK       | PRIMARY KEY (tenant_id,delivery_plan_id)                                                   | duplicado            |
| fk_ec02_dp_edition    | FK       | FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02_program_edition(tenant_id,edition_id)   | plan huérfano        |
| fk_ec02_dp_cohort     | FK       | FOREIGN KEY (tenant_id,cohort_id) REFERENCES ec02_execution_cohort(tenant_id,cohort_id)    | cohort cross-tenant  |
| ck_ec02_dp_ratios     | CHECK    | sync_ratio IS NULL OR async_ratio IS NULL OR abs((sync_ratio+async_ratio)-100.00) \<= 0.01 | mezcla inválida      |
| ck_ec02_dp_state      | CHECK    | state IN ('DRAFT','VALIDATED','SUBMITTED','PARTIAL','CONFIRMED','SUPERSEDED','CANCELLED')  | estado inválido      |

| **Última línea de defensa PostgreSQL**                                                                                                 |
|----------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir ratios incoherentes, plan huérfano y referencias cross-tenant. |

## 12.5 ec02_session_demand

QUÉ REPRESENTA — una necesidad de sesión que debe resolver CT-13 Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La genera SessionDemandGenerationService o un comando gobernado; se envía a CT-13, recibe receipts y puede supersederse. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — duración, ventanas, modalidad y demanda; no representa hora/aula/meeting confirmados. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**             | **Ejemplo** |
|----------------------|---------------------|----------|-------------------|-----------|-----------------------------|-------------|
| tenant_id            | uuid                | NO       | —                 | PK/FK     | Tenant.                     | 8f…         |
| session_demand_id    | uuid                | NO       | gen_random_uuid() | PK        | ID demanda.                 | sd-…        |
| delivery_plan_id     | uuid                | NO       | —                 | FK        | Plan padre.                 | dp-…        |
| source_module_ref    | uuid                | SÍ       | NULL              | EXT REF   | Módulo EC-01 si aplica.     | mv-…        |
| sequence_no          | integer             | NO       | —                 |           | Orden lógico.               | 4           |
| title_snapshot       | varchar(240)        | NO       | —                 |           | Título operativo congelado. | Sesión 4    |
| duration_minutes     | integer             | NO       | —                 |           | Duración.                   | 120         |
| earliest_start_at    | timestamptz         | NO       | —                 |           | Inicio más temprano.        | …           |
| latest_end_at        | timestamptz         | NO       | —                 |           | Fin más tardío.             | …           |
| preferred_slot_code  | varchar(40)         | SÍ       | NULL              |           | Preferencia policy.         | WEEKEND_AM  |
| modality_code        | varchar(24)         | NO       | —                 |           | Modalidad requerida.        | PRESENTIAL  |
| state                | varchar(24)         | NO       | DRAFT             |           | Lifecycle demanda.          | BOUND       |
| supersedes_demand_id | uuid                | SÍ       | NULL              | FK        | Lineage.                    | sd-old      |
| version              | bigint              | NO       | 0                 |           | Revision local.             | 5           |
| created_at           | timestamptz         | NO       | now()             |           | Creación.                   | …           |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

session_demand_id — ID demanda. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sd-….

delivery_plan_id — Plan padre. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: dp-….

source_module_ref — Módulo EC-01 si aplica. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: mv-….

sequence_no — Orden lógico. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 4.

title_snapshot — Título operativo congelado. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: Sesión 4.

duration_minutes — Duración. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 120.

earliest_start_at — Inicio más temprano. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

latest_end_at — Fin más tardío. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

preferred_slot_code — Preferencia policy. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: WEEKEND_AM.

modality_code — Modalidad requerida. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: PRESENTIAL.

state — Lifecycle demanda. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: BOUND.

supersedes_demand_id — Lineage. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sd-old.

version — Revision local. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 5.

created_at — Creación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_session_demand nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**      | **Tipo** | **Definición / expresión**                                                                         | **Error que impide** |
|------------------------|----------|----------------------------------------------------------------------------------------------------|----------------------|
| pk_ec02_session_demand | PK       | PRIMARY KEY (tenant_id,session_demand_id)                                                          | duplicado            |
| fk_ec02_sd_plan        | FK       | FOREIGN KEY (tenant_id,delivery_plan_id) REFERENCES ec02_delivery_plan(tenant_id,delivery_plan_id) | demanda huérfana     |
| uq_ec02_sd_seq         | UNIQUE   | UNIQUE (tenant_id,delivery_plan_id,sequence_no)                                                    | orden duplicado      |
| ck_ec02_sd_duration    | CHECK    | duration_minutes \> 0                                                                              | duración no positiva |
| ck_ec02_sd_window      | CHECK    | earliest_start_at \< latest_end_at                                                                 | ventana inválida     |
| ck_ec02_sd_state       | CHECK    | state IN ('DRAFT','READY','SUBMITTED','BOUND','PARTIAL','UNKNOWN_EFFECT','CANCELLED','SUPERSEDED') | estado inválido      |

| **Última línea de defensa PostgreSQL**                                                                                                          |
|-------------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir duración/ventana inválidas, secuencias duplicadas y demandas huérfanas. |

## 12.6 ec02_schedule_binding_receipt

QUÉ REPRESENTA — un receipt durable de efecto externo confirmado o incierto proveniente de CT-13 Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Lo crea el adapter/coordinator al enviar o reconciliar una operación con CT-13; es append-only respecto del resultado observado. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — evidencia de operación, correlation y binding externo; no convierte la copia local en Source of Truth. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                   | **Ejemplo** |
|-----------------------------|---------------------|----------|-------------------|-----------|---------------------------------------------------|-------------|
| tenant_id                   | uuid                | NO       | —                 | PK/FK     | Tenant.                                           | 8f…         |
| schedule_binding_receipt_id | uuid                | NO       | gen_random_uuid() | PK        | ID receipt.                                       | rc-…        |
| session_demand_id           | uuid                | NO       | —                 | FK        | Demanda asociada.                                 | sd-…        |
| operation_id                | uuid                | NO       | —                 |           | Operación local durable.                          | op-…        |
| correlation_id              | uuid                | NO       | —                 |           | Correlación distribuida.                          | corr-…      |
| schedule_binding_ref        | uuid                | SÍ       | NULL              | EXT REF   | Referencia de CT-13 si confirmada.                | ext-…       |
| status                      | varchar(24)         | NO       | —                 |           | CONFIRMED/PARTIAL/FAILED/UNKNOWN_EFFECT/RELEASED. | CONFIRMED   |
| remote_etag                 | varchar(128)        | SÍ       | NULL              |           | Versión remota si disponible.                     | W/"7"       |
| observed_at                 | timestamptz         | NO       | now()             |           | Momento de observación.                           | …           |
| payload_hash                | varchar(128)        | SÍ       | NULL              |           | Hash evidencia canonical.                         | sha256:…    |
| evidence_ref                | uuid                | SÍ       | NULL              | EXT REF   | CT-05 evidence.                                   | doc-…       |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

schedule_binding_receipt_id — ID receipt. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: rc-….

session_demand_id — Demanda asociada. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sd-….

operation_id — Operación local durable. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: op-….

correlation_id — Correlación distribuida. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: corr-….

schedule_binding_ref — Referencia de CT-13 si confirmada. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ext-….

status — CONFIRMED/PARTIAL/FAILED/UNKNOWN_EFFECT/RELEASED. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: CONFIRMED.

remote_etag — Versión remota si disponible. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: W/"7".

observed_at — Momento de observación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

payload_hash — Hash evidencia canonical. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sha256:….

evidence_ref — CT-05 evidence. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_schedule_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: doc-….

### Constraints recomendados e implementables

| **Nombre físico**                       | **Tipo** | **Definición / expresión**                                                                            | **Error que impide**        |
|-----------------------------------------|----------|-------------------------------------------------------------------------------------------------------|-----------------------------|
| pk_ec02_schedule_binding_receipt        | PK       | PRIMARY KEY (tenant_id,schedule_binding_receipt_id)                                                   | duplicado                   |
| fk_ec02_schedule_binding_receipt_sd     | FK       | FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02_session_demand(tenant_id,session_demand_id) | receipt huérfano            |
| uq_ec02_schedule_binding_receipt_op     | UNIQUE   | UNIQUE (tenant_id,operation_id)                                                                       | doble receipt por operación |
| ck_ec02_schedule_binding_receipt_status | CHECK    | status IN ('CONFIRMED','PARTIAL','FAILED','UNKNOWN_EFFECT','RELEASED')                                | status imposible            |

| **Última línea de defensa PostgreSQL**                                                                                                                        |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir receipt huérfano/cross-tenant, operación duplicada y status fuera del contrato CT-13. |

## 12.7 ec02_resource_binding_receipt

QUÉ REPRESENTA — un receipt durable de efecto externo confirmado o incierto proveniente de CT-14 Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Lo crea el adapter/coordinator al enviar o reconciliar una operación con CT-14; es append-only respecto del resultado observado. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — evidencia de operación, correlation y binding externo; no convierte la copia local en Source of Truth. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                   | **Ejemplo** |
|-----------------------------|---------------------|----------|-------------------|-----------|---------------------------------------------------|-------------|
| tenant_id                   | uuid                | NO       | —                 | PK/FK     | Tenant.                                           | 8f…         |
| resource_binding_receipt_id | uuid                | NO       | gen_random_uuid() | PK        | ID receipt.                                       | rc-…        |
| session_demand_id           | uuid                | NO       | —                 | FK        | Demanda asociada.                                 | sd-…        |
| operation_id                | uuid                | NO       | —                 |           | Operación local durable.                          | op-…        |
| correlation_id              | uuid                | NO       | —                 |           | Correlación distribuida.                          | corr-…      |
| resource_binding_ref        | uuid                | SÍ       | NULL              | EXT REF   | Referencia de CT-14 si confirmada.                | ext-…       |
| status                      | varchar(24)         | NO       | —                 |           | CONFIRMED/PARTIAL/FAILED/UNKNOWN_EFFECT/RELEASED. | CONFIRMED   |
| remote_etag                 | varchar(128)        | SÍ       | NULL              |           | Versión remota si disponible.                     | W/"7"       |
| observed_at                 | timestamptz         | NO       | now()             |           | Momento de observación.                           | …           |
| payload_hash                | varchar(128)        | SÍ       | NULL              |           | Hash evidencia canonical.                         | sha256:…    |
| evidence_ref                | uuid                | SÍ       | NULL              | EXT REF   | CT-05 evidence.                                   | doc-…       |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

resource_binding_receipt_id — ID receipt. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: rc-….

session_demand_id — Demanda asociada. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sd-….

operation_id — Operación local durable. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: op-….

correlation_id — Correlación distribuida. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: corr-….

resource_binding_ref — Referencia de CT-14 si confirmada. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ext-….

status — CONFIRMED/PARTIAL/FAILED/UNKNOWN_EFFECT/RELEASED. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: CONFIRMED.

remote_etag — Versión remota si disponible. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: W/"7".

observed_at — Momento de observación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

payload_hash — Hash evidencia canonical. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sha256:….

evidence_ref — CT-05 evidence. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_resource_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: doc-….

### Constraints recomendados e implementables

| **Nombre físico**                       | **Tipo** | **Definición / expresión**                                                                            | **Error que impide**        |
|-----------------------------------------|----------|-------------------------------------------------------------------------------------------------------|-----------------------------|
| pk_ec02_resource_binding_receipt        | PK       | PRIMARY KEY (tenant_id,resource_binding_receipt_id)                                                   | duplicado                   |
| fk_ec02_resource_binding_receipt_sd     | FK       | FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02_session_demand(tenant_id,session_demand_id) | receipt huérfano            |
| uq_ec02_resource_binding_receipt_op     | UNIQUE   | UNIQUE (tenant_id,operation_id)                                                                       | doble receipt por operación |
| ck_ec02_resource_binding_receipt_status | CHECK    | status IN ('CONFIRMED','PARTIAL','FAILED','UNKNOWN_EFFECT','RELEASED')                                | status imposible            |

| **Última línea de defensa PostgreSQL**                                                                                                                        |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir receipt huérfano/cross-tenant, operación duplicada y status fuera del contrato CT-14. |

## 12.8 ec02_channel_binding_receipt

QUÉ REPRESENTA — un receipt durable de efecto externo confirmado o incierto proveniente de CT-18 Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Lo crea el adapter/coordinator al enviar o reconciliar una operación con CT-18; es append-only respecto del resultado observado. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — evidencia de operación, correlation y binding externo; no convierte la copia local en Source of Truth. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                   | **Ejemplo** |
|----------------------------|---------------------|----------|-------------------|-----------|---------------------------------------------------|-------------|
| tenant_id                  | uuid                | NO       | —                 | PK/FK     | Tenant.                                           | 8f…         |
| channel_binding_receipt_id | uuid                | NO       | gen_random_uuid() | PK        | ID receipt.                                       | rc-…        |
| session_demand_id          | uuid                | NO       | —                 | FK        | Demanda asociada.                                 | sd-…        |
| operation_id               | uuid                | NO       | —                 |           | Operación local durable.                          | op-…        |
| correlation_id             | uuid                | NO       | —                 |           | Correlación distribuida.                          | corr-…      |
| channel_binding_ref        | uuid                | SÍ       | NULL              | EXT REF   | Referencia de CT-18 si confirmada.                | ext-…       |
| status                     | varchar(24)         | NO       | —                 |           | CONFIRMED/PARTIAL/FAILED/UNKNOWN_EFFECT/RELEASED. | CONFIRMED   |
| remote_etag                | varchar(128)        | SÍ       | NULL              |           | Versión remota si disponible.                     | W/"7"       |
| observed_at                | timestamptz         | NO       | now()             |           | Momento de observación.                           | …           |
| payload_hash               | varchar(128)        | SÍ       | NULL              |           | Hash evidencia canonical.                         | sha256:…    |
| evidence_ref               | uuid                | SÍ       | NULL              | EXT REF   | CT-05 evidence.                                   | doc-…       |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

channel_binding_receipt_id — ID receipt. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: rc-….

session_demand_id — Demanda asociada. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sd-….

operation_id — Operación local durable. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: op-….

correlation_id — Correlación distribuida. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: corr-….

channel_binding_ref — Referencia de CT-18 si confirmada. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ext-….

status — CONFIRMED/PARTIAL/FAILED/UNKNOWN_EFFECT/RELEASED. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: CONFIRMED.

remote_etag — Versión remota si disponible. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: W/"7".

observed_at — Momento de observación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

payload_hash — Hash evidencia canonical. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sha256:….

evidence_ref — CT-05 evidence. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_channel_binding_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: doc-….

### Constraints recomendados e implementables

| **Nombre físico**                      | **Tipo** | **Definición / expresión**                                                                            | **Error que impide**        |
|----------------------------------------|----------|-------------------------------------------------------------------------------------------------------|-----------------------------|
| pk_ec02_channel_binding_receipt        | PK       | PRIMARY KEY (tenant_id,channel_binding_receipt_id)                                                    | duplicado                   |
| fk_ec02_channel_binding_receipt_sd     | FK       | FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02_session_demand(tenant_id,session_demand_id) | receipt huérfano            |
| uq_ec02_channel_binding_receipt_op     | UNIQUE   | UNIQUE (tenant_id,operation_id)                                                                       | doble receipt por operación |
| ck_ec02_channel_binding_receipt_status | CHECK    | status IN ('CONFIRMED','PARTIAL','FAILED','UNKNOWN_EFFECT','RELEASED')                                | status imposible            |

| **Última línea de defensa PostgreSQL**                                                                                                                        |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir receipt huérfano/cross-tenant, operación duplicada y status fuera del contrato CT-18. |

## 12.9 ec02_operational_change_request

QUÉ REPRESENTA — una solicitud gobernada de cambio operativo material Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea al reprogramar, suspender o cambiar un plan que ya tiene efectos externos; se resuelve con CT-06 y genera compensaciones/receipts. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — lineage, reason, before/after refs y workflow; no ejecuta por sí misma el cambio. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                             | **Ejemplo**         |
|-----------------------|---------------------|----------|-------------------|-----------|---------------------------------------------|---------------------|
| tenant_id             | uuid                | NO       | —                 | PK/FK     | Tenant.                                     | 8f…                 |
| change_request_id     | uuid                | NO       | gen_random_uuid() | PK        | ID.                                         | cr-…                |
| edition_id            | uuid                | NO       | —                 | FK        | Edición.                                    | e1…                 |
| session_demand_id     | uuid                | SÍ       | NULL              | FK        | Sesión afectada.                            | sd-…                |
| change_type           | varchar(24)         | NO       | —                 |           | RESCHEDULE/SUSPEND/CANCEL/OTHER.            | RESCHEDULE          |
| reason_code           | varchar(64)         | NO       | —                 |           | Reason stable.                              | OPS_RESOURCE_CHANGE |
| reason_detail         | text                | SÍ       | NULL              |           | Detalle.                                    | Cambio de sala      |
| workflow_instance_ref | uuid                | SÍ       | NULL              | EXT REF   | CT-06.                                      | wf-…                |
| state                 | varchar(20)         | NO       | REQUESTED         |           | REQUESTED/APPROVED/REJECTED/APPLIED/FAILED. | APPROVED            |
| requested_by          | uuid                | NO       | —                 | EXT REF   | Actor.                                      | sub-…               |
| requested_at          | timestamptz         | NO       | now()             |           | Fecha.                                      | …                   |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

change_request_id — ID. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: cr-….

edition_id — Edición. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

session_demand_id — Sesión afectada. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sd-….

change_type — RESCHEDULE/SUSPEND/CANCEL/OTHER. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: RESCHEDULE.

reason_code — Reason stable. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: OPS_RESOURCE_CHANGE.

reason_detail — Detalle. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: Cambio de sala.

workflow_instance_ref — CT-06. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: wf-….

state — REQUESTED/APPROVED/REJECTED/APPLIED/FAILED. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: APPROVED.

requested_by — Actor. Es obligatorio. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sub-….

requested_at — Fecha. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operational_change_request nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**      | **Tipo** | **Definición / expresión**                                                                            | **Error que impide** |
|------------------------|----------|-------------------------------------------------------------------------------------------------------|----------------------|
| pk_ec02_change_request | PK       | PRIMARY KEY (tenant_id,change_request_id)                                                             | duplicado            |
| fk_ec02_change_edition | FK       | FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02_program_edition(tenant_id,edition_id)              | request huérfana     |
| fk_ec02_change_sd      | FK       | FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02_session_demand(tenant_id,session_demand_id) | sesión cross-tenant  |
| ck_ec02_change_type    | CHECK    | change_type IN ('RESCHEDULE','SUSPEND','CANCEL','OTHER')                                              | tipo inválido        |
| ck_ec02_change_state   | CHECK    | state IN ('REQUESTED','APPROVED','REJECTED','APPLIED','FAILED')                                       | estado inválido      |

| **Última línea de defensa PostgreSQL**                                                                                             |
|------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir request huérfana/cross-tenant y tipos/estados arbitrarios. |

## 12.10 ec02_publication_receipt

QUÉ REPRESENTA — la evidencia append-only de publicación operativa Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea en la misma transacción lógica de publish, después de gates y workflow; downstream puede usarlo para lineage/evidence. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — evidencia de versión, hash y policy; no es el documento binario final. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**           | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|-----------|---------------------------|-------------|
| tenant_id                | uuid                | NO       | —                 | PK/FK     | Tenant.                   | 8f…         |
| publication_receipt_id   | uuid                | NO       | gen_random_uuid() | PK        | ID receipt.               | pr-…        |
| edition_id               | uuid                | NO       | —                 | FK        | Edición.                  | e1…         |
| offering_id              | uuid                | SÍ       | NULL              | FK        | Offering si aplica.       | of-…        |
| aggregate_version        | bigint              | NO       | —                 |           | Version publicada.        | 8           |
| content_hash             | varchar(128)        | NO       | —                 |           | Hash canonical.           | sha256:…    |
| canonical_schema_version | varchar(32)         | NO       | 1                 |           | Versión canonicalización. | 1           |
| policy_snapshot_ref      | uuid                | SÍ       | NULL              | EXT REF   | Policy/evidence.          | pol-…       |
| published_by             | uuid                | NO       | —                 | EXT REF   | Actor.                    | sub-…       |
| published_at             | timestamptz         | NO       | now()             |           | Fecha.                    | …           |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

publication_receipt_id — ID receipt. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: pr-….

edition_id — Edición. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

offering_id — Offering si aplica. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: of-….

aggregate_version — Version publicada. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8.

content_hash — Hash canonical. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sha256:….

canonical_schema_version — Versión canonicalización. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 1.

policy_snapshot_ref — Policy/evidence. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: pol-….

published_by — Actor. Es obligatorio. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sub-….

published_at — Fecha. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_publication_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**    | **Tipo** | **Definición / expresión**                                                               | **Error que impide**    |
|----------------------|----------|------------------------------------------------------------------------------------------|-------------------------|
| pk_ec02_pub_receipt  | PK       | PRIMARY KEY (tenant_id,publication_receipt_id)                                           | duplicado               |
| fk_ec02_pub_edition  | FK       | FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02_program_edition(tenant_id,edition_id) | receipt huérfano        |
| fk_ec02_pub_offering | FK       | FOREIGN KEY (tenant_id,offering_id) REFERENCES ec02_offering(tenant_id,offering_id)      | offering cross-tenant   |
| uq_ec02_pub_version  | UNIQUE   | UNIQUE (tenant_id,edition_id,aggregate_version,offering_id)                              | duplicidad de evidencia |

| **Última línea de defensa PostgreSQL**                                                                                                                                                  |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir alteración lógica de evidencia, duplicados y referencias cross-tenant; además runtime debe negar UPDATE/DELETE. |

## 12.11 ec02_cancellation_record

QUÉ REPRESENTA — el hecho histórico de cancelación de edición o sesión Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea al aprobar cancelación; dispara compensaciones idempotentes y conserva resultados parciales/unknown. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — reason, alcance, actor y efectos; no borra la entidad cancelada. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                           | **Ejemplo**            |
|--------------------------|---------------------|----------|-------------------|-----------|-------------------------------------------|------------------------|
| tenant_id                | uuid                | NO       | —                 | PK/FK     | Tenant.                                   | 8f…                    |
| cancellation_id          | uuid                | NO       | gen_random_uuid() | PK        | ID.                                       | can-…                  |
| edition_id               | uuid                | NO       | —                 | FK        | Edición.                                  | e1…                    |
| session_demand_id        | uuid                | SÍ       | NULL              | FK        | Sesión si cancelación parcial.            | sd-…                   |
| reason_code              | varchar(64)         | NO       | —                 |           | Reason stable.                            | MIN_ENROLLMENT_NOT_MET |
| reason_detail            | text                | SÍ       | NULL              |           | Detalle.                                  | …                      |
| effective_at             | timestamptz         | NO       | —                 |           | Efectividad.                              | …                      |
| downstream_effect_status | varchar(24)         | NO       | PENDING           |           | PENDING/PARTIAL/CONFIRMED/UNKNOWN_EFFECT. | PARTIAL                |
| workflow_instance_ref    | uuid                | SÍ       | NULL              | EXT REF   | CT-06.                                    | wf-…                   |
| cancelled_by             | uuid                | NO       | —                 | EXT REF   | Actor.                                    | sub-…                  |
| cancelled_at             | timestamptz         | NO       | now()             |           | Fecha.                                    | …                      |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK/FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

cancellation_id — ID. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: can-….

edition_id — Edición. Es obligatorio. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

session_demand_id — Sesión si cancelación parcial. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como FK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sd-….

reason_code — Reason stable. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: MIN_ENROLLMENT_NOT_MET.

reason_detail — Detalle. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

effective_at — Efectividad. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

downstream_effect_status — PENDING/PARTIAL/CONFIRMED/UNKNOWN_EFFECT. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: PARTIAL.

workflow_instance_ref — CT-06. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: wf-….

cancelled_by — Actor. Es obligatorio. Participa como EXT REF. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sub-….

cancelled_at — Fecha. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_cancellation_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**      | **Tipo** | **Definición / expresión**                                                                            | **Error que impide** |
|------------------------|----------|-------------------------------------------------------------------------------------------------------|----------------------|
| pk_ec02_cancel         | PK       | PRIMARY KEY (tenant_id,cancellation_id)                                                               | duplicado            |
| fk_ec02_cancel_edition | FK       | FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02_program_edition(tenant_id,edition_id)              | cancel huérfana      |
| fk_ec02_cancel_sd      | FK       | FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02_session_demand(tenant_id,session_demand_id) | sesión cross-tenant  |
| ck_ec02_cancel_effect  | CHECK    | downstream_effect_status IN ('PENDING','PARTIAL','CONFIRMED','UNKNOWN_EFFECT')                        | status imposible     |

| **Última línea de defensa PostgreSQL**                                                                                                 |
|----------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir cancelaciones huérfanas y pérdida de incertidumbre downstream. |

## 12.12 ec02_operation_status

QUÉ REPRESENTA — el estado durable de comandos asíncronos y efectos externos Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Lo crea Application Service antes de invocar adapters; el Frontend consulta hasta alcanzar terminal o UNKNOWN_EFFECT persistente. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — operationId, status, attempts y result/problem; no reemplaza el receipt del sistema externo. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**  | **Ejemplo**     |
|----------------|---------------------|----------|-------------------|-----------|------------------|-----------------|
| tenant_id      | uuid                | NO       | —                 | PK        | Tenant.          | 8f…             |
| operation_id   | uuid                | NO       | gen_random_uuid() | PK        | ID operación.    | op-…            |
| operation_type | varchar(64)         | NO       | —                 |           | Tipo.            | SCHEDULE_SUBMIT |
| aggregate_id   | uuid                | NO       | —                 |           | Aggregate local. | e1…             |
| status         | varchar(24)         | NO       | PENDING           |           | Estado.          | UNKNOWN_EFFECT  |
| attempt_count  | integer             | NO       | 0                 |           | Intentos.        | 2               |
| lease_owner    | varchar(128)        | SÍ       | NULL              |           | Worker owner.    | pod-3           |
| lease_until    | timestamptz         | SÍ       | NULL              |           | Lease.           | …               |
| result_ref     | uuid                | SÍ       | NULL              |           | Receipt/result.  | rc-…            |
| problem_code   | varchar(96)         | SÍ       | NULL              |           | Reason/Problem.  | CT13_TIMEOUT    |
| created_at     | timestamptz         | NO       | now()             |           | Creación.        | …               |
| updated_at     | timestamptz         | NO       | now()             |           | Update.          | …               |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

operation_id — ID operación. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: op-….

operation_type — Tipo. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: SCHEDULE_SUBMIT.

aggregate_id — Aggregate local. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

status — Estado. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: UNKNOWN_EFFECT.

attempt_count — Intentos. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 2.

lease_owner — Worker owner. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: pod-3.

lease_until — Lease. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

result_ref — Receipt/result. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: rc-….

problem_code — Reason/Problem. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: CT13_TIMEOUT.

created_at — Creación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

updated_at — Update. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_operation_status nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**         | **Tipo** | **Definición / expresión**                                                            | **Error que impide** |
|---------------------------|----------|---------------------------------------------------------------------------------------|----------------------|
| pk_ec02_operation         | PK       | PRIMARY KEY (tenant_id,operation_id)                                                  | duplicado            |
| ck_ec02_operation_status  | CHECK    | status IN ('PENDING','IN_PROGRESS','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED') | status inválido      |
| ck_ec02_operation_attempt | CHECK    | attempt_count \>= 0                                                                   | contador negativo    |

| **Última línea de defensa PostgreSQL**                                                                                                        |
|-----------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir estados/contadores imposibles y ambigüedad de ownership de operación. |

## 12.13 ec02_idempotency_record

QUÉ REPRESENTA — la llave durable para deduplicar comandos sensibles Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se adquiere en la frontera application/controller y conserva request hash, response y recovery lease. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — replays del mismo comando; no es cache temporal. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**         | **Ejemplo**    |
|-----------------|---------------------|----------|-------------|-----------|-------------------------|----------------|
| tenant_id       | uuid                | NO       | —           | PK        | Tenant.                 | 8f…            |
| idempotency_key | varchar(160)        | NO       | —           | PK        | Key cliente.            | a31…           |
| command_name    | varchar(96)         | NO       | —           |           | Comando.                | PublishEdition |
| request_hash    | varchar(128)        | NO       | —           |           | Hash canonical request. | sha256:…       |
| status          | varchar(20)         | NO       | IN_PROGRESS |           | Estado.                 | COMPLETED      |
| response_code   | integer             | SÍ       | NULL        |           | HTTP response.          | 200            |
| response_body   | jsonb               | SÍ       | NULL        |           | Response replay safe.   | {...}          |
| lease_owner     | varchar(128)        | SÍ       | NULL        |           | Worker.                 | pod-1          |
| lease_until     | timestamptz         | SÍ       | NULL        |           | Recuperación.           | …              |
| created_at      | timestamptz         | NO       | now()       |           | Fecha.                  | …              |
| completed_at    | timestamptz         | SÍ       | NULL        |           | Fin.                    | …              |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

idempotency_key — Key cliente. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: a31….

command_name — Comando. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: PublishEdition.

request_hash — Hash canonical request. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: sha256:….

status — Estado. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: COMPLETED.

response_code — HTTP response. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 200.

response_body — Response replay safe. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: {...}.

lease_owner — Worker. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: pod-1.

lease_until — Recuperación. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

created_at — Fecha. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

completed_at — Fin. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_idempotency_record nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**     | **Tipo** | **Definición / expresión**                                 | **Error que impide** |
|-----------------------|----------|------------------------------------------------------------|----------------------|
| pk_ec02_idem          | PK       | PRIMARY KEY (tenant_id,idempotency_key)                    | duplicado            |
| ck_ec02_idem_state    | CHECK    | status IN ('IN_PROGRESS','COMPLETED','FAILED_RECOVERABLE') | estado inválido      |
| ck_ec02_idem_response | CHECK    | response_code IS NULL OR response_code BETWEEN 100 AND 599 | HTTP inválido        |

| **Última línea de defensa PostgreSQL**                                                                                                       |
|----------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir ejecutar dos veces un comando con la misma key y payload divergente. |

## 12.14 ec02_outbox_event

QUÉ REPRESENTA — el evento de integración pendiente/entregado de EC-02 Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se inserta en la misma transacción de dominio; dispatcher reclama con SKIP LOCKED/lease y publica por CT-09. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — atomicidad save+publish y replay; no es log de auditoría. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                 | **Ejemplo**      |
|----------------|---------------------|----------|-------------------|-----------|---------------------------------|------------------|
| tenant_id      | uuid                | NO       | —                 | PK        | Tenant.                         | 8f…              |
| event_id       | uuid                | NO       | gen_random_uuid() | PK        | ID evento.                      | ev-…             |
| aggregate_type | varchar(64)         | NO       | —                 |           | Tipo.                           | ProgramEdition   |
| aggregate_id   | uuid                | NO       | —                 |           | ID root.                        | e1…              |
| event_type     | varchar(96)         | NO       | —                 |           | Tipo evento.                    | EditionPublished |
| schema_version | integer             | NO       | 1                 |           | Versión contrato.               | 1                |
| correlation_id | uuid                | NO       | —                 |           | Correlación.                    | corr-…           |
| causation_id   | uuid                | SÍ       | NULL              |           | Causa.                          | cmd-…            |
| payload        | jsonb               | NO       | —                 |           | Payload.                        | {...}            |
| status         | varchar(20)         | NO       | PENDING           |           | PENDING/CLAIMED/DELIVERED/DEAD. | PENDING          |
| available_at   | timestamptz         | NO       | now()             |           | Backoff.                        | …                |
| claim_owner    | varchar(128)        | SÍ       | NULL              |           | Worker.                         | pod-2            |
| claim_until    | timestamptz         | SÍ       | NULL              |           | Lease.                          | …                |
| occurred_at    | timestamptz         | NO       | now()             |           | Hecho.                          | …                |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

event_id — ID evento. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ev-….

aggregate_type — Tipo. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ProgramEdition.

aggregate_id — ID root. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: e1….

event_type — Tipo evento. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: EditionPublished.

schema_version — Versión contrato. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 1.

correlation_id — Correlación. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: corr-….

causation_id — Causa. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: cmd-….

payload — Payload. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: {...}.

status — PENDING/CLAIMED/DELIVERED/DEAD. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: PENDING.

available_at — Backoff. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

claim_owner — Worker. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: pod-2.

claim_until — Lease. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

occurred_at — Hecho. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_outbox_event nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

### Constraints recomendados e implementables

| **Nombre físico**       | **Tipo** | **Definición / expresión**                         | **Error que impide**   |
|-------------------------|----------|----------------------------------------------------|------------------------|
| pk_ec02_outbox          | PK       | PRIMARY KEY (tenant_id,event_id)                   | duplicado              |
| ck_ec02_outbox_status   | CHECK    | status IN ('PENDING','CLAIMED','DELIVERED','DEAD') | estado inválido        |
| ix_ec02_outbox_dispatch | INDEX    | (status,available_at)                              | dispatcher ineficiente |

| **Última línea de defensa PostgreSQL**                                                                                                         |
|------------------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir pérdida de atomicidad, doble identidad de evento y estados imposibles. |

## 12.15 ec02_inbox_receipt

QUÉ REPRESENTA — la deduplicación durable de mensajes consumidos Esta tabla existe porque EC-02 necesita preservar el hecho operativo sin apropiarse de los motores transversales. Su identidad y estado son auditables, tenant-aware y reconstruibles históricamente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — El consumer registra message_id antes/atómicamente con side effects locales; replays no duplican mutaciones. La aplicación modifica este registro únicamente mediante comandos de dominio del aggregate correspondiente. Los adapters hacia CT-03, CT-13, CT-14, CT-18 y otros contextos consumen referencias externas; nunca se accede directamente a sus tablas.

QUÉ PROTEGE / QUÉ NO REPRESENTA — exactly-once effect local sobre at-least-once transport. No representa participantes, pagos, asignaciones docentes definitivas ni disponibilidad real de recursos externos salvo que se conserve un receipt contractual.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**                 | **Ejemplo**       |
|-----------------|---------------------|----------|-------------|-----------|---------------------------------|-------------------|
| tenant_id       | uuid                | NO       | —           | PK        | Tenant.                         | 8f…               |
| message_id      | uuid                | NO       | —           | PK        | ID mensaje.                     | msg-…             |
| consumer_name   | varchar(96)         | NO       | —           | PK        | Consumer lógico.                | ec02-ct13-status  |
| event_type      | varchar(96)         | NO       | —           |           | Tipo.                           | ScheduleConfirmed |
| schema_version  | integer             | NO       | 1           |           | Versión.                        | 1                 |
| received_at     | timestamptz         | NO       | now()       |           | Recepción.                      | …                 |
| processed_at    | timestamptz         | SÍ       | NULL        |           | Procesado.                      | …                 |
| status          | varchar(20)         | NO       | RECEIVED    |           | RECEIVED/PROCESSED/FAILED/DEAD. | PROCESSED         |
| last_error_code | varchar(96)         | SÍ       | NULL        |           | Error.                          | SCHEMA_INVALID    |

### Explicación individual de atributos

tenant_id — Tenant. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 8f….

message_id — ID mensaje. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: msg-….

consumer_name — Consumer lógico. Es obligatorio. Participa como PK. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ec02-ct13-status.

event_type — Tipo. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ScheduleConfirmed.

schema_version — Versión. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: 1.

received_at — Recepción. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

processed_at — Procesado. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: ….

status — RECEIVED/PROCESSED/FAILED/DEAD. Es obligatorio. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: PROCESSED.

last_error_code — Error. Es opcional y semánticamente nulo cuando no existe un hecho que registrar. Su valor debe validarse en dominio y, cuando la invariantes sea local, también mediante constraint PostgreSQL. En ec02_inbox_receipt nunca debe utilizarse un valor vacío para simular ausencia; NULL, cero, cadena vacía y estado desconocido tienen semánticas diferentes. Ejemplo: SCHEMA_INVALID.

### Constraints recomendados e implementables

| **Nombre físico**    | **Tipo** | **Definición / expresión**                         | **Error que impide** |
|----------------------|----------|----------------------------------------------------|----------------------|
| pk_ec02_inbox        | PK       | PRIMARY KEY (tenant_id,message_id,consumer_name)   | duplicado effect     |
| ck_ec02_inbox_status | CHECK    | status IN ('RECEIVED','PROCESSED','FAILED','DEAD') | estado inválido      |

| **Última línea de defensa PostgreSQL**                                                                                                |
|---------------------------------------------------------------------------------------------------------------------------------------|
| ¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug? impedir procesar dos veces el mismo mensaje para el mismo consumidor. |

# 13. DDL PostgreSQL completo — Flyway Ready

El DDL siguiente es baseline implementable. En Git debe separarse en migraciones expand/contract pequeñas, con comentarios y rollback operativo por roll-forward. La función app.current_tenant_id() y roles deben alinearse con baseline AM/CT; se muestra el patrón EC-02.

CREATE SCHEMA IF NOT EXISTS ec02;  
  
CREATE TABLE ec02.ec02_program_edition (  
tenant_id uuid NOT NULL,  
edition_id uuid NOT NULL DEFAULT gen_random_uuid(),  
edition_code varchar(64) NOT NULL,  
program_version_ref uuid NOT NULL,  
institution_scope_ref uuid NOT NULL,  
timezone_id varchar(64) NOT NULL,  
planned_start_at timestamptz NOT NULL,  
planned_end_at timestamptz NOT NULL,  
lifecycle_state varchar(24) NOT NULL DEFAULT 'DRAFT',  
publication_policy_ref uuid NULL,  
workflow_instance_ref uuid NULL,  
version bigint NOT NULL DEFAULT 0,  
created_by_subject uuid NOT NULL,  
created_at timestamptz NOT NULL DEFAULT now(),  
updated_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_program_edition PRIMARY KEY (tenant_id, edition_id),  
CONSTRAINT uq_ec02_program_edition_code UNIQUE (tenant_id, edition_code),  
CONSTRAINT ck_ec02_edition_window CHECK (planned_start_at \< planned_end_at),  
CONSTRAINT ck_ec02_edition_state CHECK (lifecycle_state IN ('DRAFT','PLANNING','READY','PUBLISHED','IN_EXECUTION','SUSPENDED','CANCELLED','CLOSED'))  
);  
CREATE INDEX ix_ec02_edition_program ON ec02.ec02_program_edition(tenant_id, program_version_ref, lifecycle_state);  
  
CREATE TABLE ec02.ec02_offering (  
tenant_id uuid NOT NULL, offering_id uuid NOT NULL DEFAULT gen_random_uuid(), edition_id uuid NOT NULL,  
offering_code varchar(64) NOT NULL, offering_type varchar(24) NOT NULL, audience_ref uuid NULL,  
channel_code varchar(32) NOT NULL DEFAULT 'WEB', visible_from timestamptz NULL, visible_until timestamptz NULL,  
eligibility_policy_ref uuid NULL, pricing_context_ref uuid NULL, state varchar(20) NOT NULL DEFAULT 'DRAFT',  
version bigint NOT NULL DEFAULT 0, created_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_offering PRIMARY KEY (tenant_id,offering_id),  
CONSTRAINT fk_ec02_offering_edition FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02.ec02_program_edition(tenant_id,edition_id),  
CONSTRAINT uq_ec02_offering_code UNIQUE (tenant_id,edition_id,offering_code),  
CONSTRAINT ck_ec02_offering_window CHECK (visible_from IS NULL OR visible_until IS NULL OR visible_from \< visible_until),  
CONSTRAINT ck_ec02_offering_state CHECK (state IN ('DRAFT','REVIEW','PUBLISHED','SUSPENDED','CANCELLED','CLOSED'))  
);  
  
CREATE TABLE ec02.ec02_execution_cohort (  
tenant_id uuid NOT NULL, cohort_id uuid NOT NULL DEFAULT gen_random_uuid(), edition_id uuid NOT NULL,  
cohort_code varchar(64) NOT NULL, display_name varchar(160) NOT NULL,  
capacity_min integer NULL, capacity_target integer NULL, capacity_max integer NULL,  
state varchar(20) NOT NULL DEFAULT 'DRAFT', version bigint NOT NULL DEFAULT 0, created_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_cohort PRIMARY KEY (tenant_id,cohort_id),  
CONSTRAINT fk_ec02_cohort_edition FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02.ec02_program_edition(tenant_id,edition_id),  
CONSTRAINT uq_ec02_cohort_code UNIQUE (tenant_id,edition_id,cohort_code),  
CONSTRAINT ck_ec02_cohort_caps CHECK ((capacity_min IS NULL OR capacity_min\>0) AND (capacity_target IS NULL OR capacity_target\>0) AND (capacity_max IS NULL OR capacity_max\>0) AND (capacity_min IS NULL OR capacity_target IS NULL OR capacity_min\<=capacity_target) AND (capacity_target IS NULL OR capacity_max IS NULL OR capacity_target\<=capacity_max))  
);  
  
CREATE TABLE ec02.ec02_delivery_plan (  
tenant_id uuid NOT NULL, delivery_plan_id uuid NOT NULL DEFAULT gen_random_uuid(), edition_id uuid NOT NULL,  
cohort_id uuid NULL, plan_no integer NOT NULL DEFAULT 1, calendar_ref uuid NULL,  
modality_code varchar(24) NOT NULL, sync_ratio numeric(5,2) NULL, async_ratio numeric(5,2) NULL,  
state varchar(24) NOT NULL DEFAULT 'DRAFT', supersedes_plan_id uuid NULL, version bigint NOT NULL DEFAULT 0,  
created_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_delivery_plan PRIMARY KEY (tenant_id,delivery_plan_id),  
CONSTRAINT fk_ec02_dp_edition FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02.ec02_program_edition(tenant_id,edition_id),  
CONSTRAINT fk_ec02_dp_cohort FOREIGN KEY (tenant_id,cohort_id) REFERENCES ec02.ec02_execution_cohort(tenant_id,cohort_id),  
CONSTRAINT fk_ec02_dp_supersedes FOREIGN KEY (tenant_id,supersedes_plan_id) REFERENCES ec02.ec02_delivery_plan(tenant_id,delivery_plan_id),  
CONSTRAINT ck_ec02_dp_ratios CHECK (sync_ratio IS NULL OR async_ratio IS NULL OR abs((sync_ratio+async_ratio)-100.00)\<=0.01),  
CONSTRAINT ck_ec02_dp_state CHECK (state IN ('DRAFT','VALIDATED','SUBMITTED','PARTIAL','CONFIRMED','SUPERSEDED','CANCELLED'))  
);  
  
CREATE TABLE ec02.ec02_session_demand (  
tenant_id uuid NOT NULL, session_demand_id uuid NOT NULL DEFAULT gen_random_uuid(), delivery_plan_id uuid NOT NULL,  
source_module_ref uuid NULL, sequence_no integer NOT NULL, title_snapshot varchar(240) NOT NULL,  
duration_minutes integer NOT NULL, earliest_start_at timestamptz NOT NULL, latest_end_at timestamptz NOT NULL,  
preferred_slot_code varchar(40) NULL, modality_code varchar(24) NOT NULL, state varchar(24) NOT NULL DEFAULT 'DRAFT',  
supersedes_demand_id uuid NULL, version bigint NOT NULL DEFAULT 0, created_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_session_demand PRIMARY KEY (tenant_id,session_demand_id),  
CONSTRAINT fk_ec02_sd_plan FOREIGN KEY (tenant_id,delivery_plan_id) REFERENCES ec02.ec02_delivery_plan(tenant_id,delivery_plan_id),  
CONSTRAINT fk_ec02_sd_supersedes FOREIGN KEY (tenant_id,supersedes_demand_id) REFERENCES ec02.ec02_session_demand(tenant_id,session_demand_id),  
CONSTRAINT uq_ec02_sd_seq UNIQUE

(tenant_id,delivery_plan_id,sequence_no),  
CONSTRAINT ck_ec02_sd_duration CHECK (duration_minutes\>0),  
CONSTRAINT ck_ec02_sd_window CHECK (earliest_start_at\<latest_end_at),  
CONSTRAINT ck_ec02_sd_state CHECK (state IN ('DRAFT','READY','SUBMITTED','BOUND','PARTIAL','UNKNOWN_EFFECT','CANCELLED','SUPERSEDED'))  
);  
  
CREATE TABLE ec02.ec02_schedule_binding_receipt (  
tenant_id uuid NOT NULL, schedule_binding_receipt_id uuid NOT NULL DEFAULT gen_random_uuid(), session_demand_id uuid NOT NULL,  
operation_id uuid NOT NULL, correlation_id uuid NOT NULL, schedule_binding_ref uuid NULL,  
status varchar(24) NOT NULL, remote_etag varchar(128) NULL, observed_at timestamptz NOT NULL DEFAULT now(),  
payload_hash varchar(128) NULL, evidence_ref uuid NULL,  
CONSTRAINT pk_ec02_schedule_binding_receipt PRIMARY KEY (tenant_id,schedule_binding_receipt_id),  
CONSTRAINT fk_ec02_schedule_binding_receipt_sd FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02.ec02_session_demand(tenant_id,session_demand_id),  
CONSTRAINT uq_ec02_schedule_binding_receipt_op UNIQUE (tenant_id,operation_id),  
CONSTRAINT ck_ec02_schedule_binding_receipt_status CHECK (status IN ('CONFIRMED','PARTIAL','FAILED','UNKNOWN_EFFECT','RELEASED'))  
);  
  
CREATE TABLE ec02.ec02_resource_binding_receipt (  
tenant_id uuid NOT NULL, resource_binding_receipt_id uuid NOT NULL DEFAULT gen_random_uuid(), session_demand_id uuid NOT NULL,  
operation_id uuid NOT NULL, correlation_id uuid NOT NULL, resource_binding_ref uuid NULL,  
status varchar(24) NOT NULL, remote_etag varchar(128) NULL, observed_at timestamptz NOT NULL DEFAULT now(),  
payload_hash varchar(128) NULL, evidence_ref uuid NULL,  
CONSTRAINT pk_ec02_resource_binding_receipt PRIMARY KEY (tenant_id,resource_binding_receipt_id),  
CONSTRAINT fk_ec02_resource_binding_receipt_sd FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02.ec02_session_demand(tenant_id,session_demand_id),  
CONSTRAINT uq_ec02_resource_binding_receipt_op UNIQUE (tenant_id,operation_id),  
CONSTRAINT ck_ec02_resource_binding_receipt_status CHECK (status IN ('CONFIRMED','PARTIAL','FAILED','UNKNOWN_EFFECT','RELEASED'))  
);  
  
CREATE TABLE ec02.ec02_channel_binding_receipt (  
tenant_id uuid NOT NULL, channel_binding_receipt_id uuid NOT NULL DEFAULT gen_random_uuid(), session_demand_id uuid NOT NULL,  
operation_id uuid NOT NULL, correlation_id uuid NOT NULL, channel_binding_ref uuid NULL,  
status varchar(24) NOT NULL, remote_etag varchar(128) NULL, observed_at timestamptz NOT NULL DEFAULT now(),  
payload_hash varchar(128) NULL, evidence_ref uuid NULL,  
CONSTRAINT pk_ec02_channel_binding_receipt PRIMARY KEY (tenant_id,channel_binding_receipt_id),  
CONSTRAINT fk_ec02_channel_binding_receipt_sd FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02.ec02_session_demand(tenant_id,session_demand_id),  
CONSTRAINT uq_ec02_channel_binding_receipt_op UNIQUE (tenant_id,operation_id),  
CONSTRAINT ck_ec02_channel_binding_receipt_status CHECK (status IN ('CONFIRMED','PARTIAL','FAILED','UNKNOWN_EFFECT','RELEASED'))  
);  
  
CREATE TABLE ec02.ec02_operational_change_request (  
tenant_id uuid NOT NULL, change_request_id uuid NOT NULL DEFAULT gen_random_uuid(), edition_id uuid NOT NULL,  
session_demand_id uuid NULL, change_type varchar(24) NOT NULL, reason_code varchar(64) NOT NULL,  
reason_detail text NULL, workflow_instance_ref uuid NULL, state varchar(20) NOT NULL DEFAULT 'REQUESTED',  
requested_by uuid NOT NULL, requested_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_change_request PRIMARY KEY (tenant_id,change_request_id),  
CONSTRAINT fk_ec02_change_edition FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02.ec02_program_edition(tenant_id,edition_id),  
CONSTRAINT fk_ec02_change_sd FOREIGN KEY (tenant_id,session_demand_id) REFERENCES ec02.ec02_session_demand(tenant_id,session_demand_id),  
CONSTRAINT ck_ec02_change_type CHECK (change_type IN ('RESCHEDULE','SUSPEND','CANCEL','OTHER')),  
CONSTRAINT ck_ec02_change_state CHECK (state IN ('REQUESTED','APPROVED','REJECTED','APPLIED','FAILED'))  
);  
  
CREATE TABLE ec02.ec02_publication_receipt (  
tenant_id uuid NOT NULL, publication_receipt_id uuid NOT NULL DEFAULT gen_random_uuid(), edition_id uuid NOT NULL,  
offering_id uuid NULL, aggregate_version bigint NOT NULL, content_hash varchar(128) NOT NULL,  
canonical_schema_version varchar(32) NOT NULL DEFAULT '1', policy_snapshot_ref uuid NULL,  
published_by uuid NOT NULL, published_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_pub_receipt PRIMARY KEY (tenant_id,publication_receipt_id),  
CONSTRAINT fk_ec02_pub_edition FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02.ec02_program_edition(tenant_id,edition_id),  
CONSTRAINT fk_ec02_pub_offering FOREIGN KEY (tenant_id,offering_id) REFERENCES ec02.ec02_offering(tenant_id,offering_id)  
);  
  
CREATE TABLE ec02.ec02_cancellation_record (  
tenant_id uuid NOT NULL, cancellation_id uuid NOT NULL DEFAULT gen_random_uuid(), edition_id uuid NOT NULL,  
session_demand_id uuid NULL, reason_code varchar(64) NOT NULL, reason_detail text NULL, effective_at timestamptz NOT NULL,  
downstream_effect_status varchar(24) NOT NULL DEFAULT 'PENDING', workflow_instance_ref uuid NULL,  
cancelled_by uuid NOT NULL, cancelled_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_cancel PRIMARY KEY (tenant_id,cancellation_id),  
CONSTRAINT fk_ec02_cancel_edition FOREIGN KEY (tenant_id,edition_id) REFERENCES ec02.ec02_program_edition(tenant_id,edition_id),  
CONSTRAINT fk_ec02_cancel_sd FOREIGN KEY

(tenant_id,session_demand_id) REFERENCES ec02.ec02_session_demand(tenant_id,session_demand_id),  
CONSTRAINT ck_ec02_cancel_effect CHECK (downstream_effect_status IN ('PENDING','PARTIAL','CONFIRMED','UNKNOWN_EFFECT'))  
);  
  
CREATE TABLE ec02.ec02_operation_status (  
tenant_id uuid NOT NULL, operation_id uuid NOT NULL DEFAULT gen_random_uuid(), operation_type varchar(64) NOT NULL,  
aggregate_id uuid NOT NULL, status varchar(24) NOT NULL DEFAULT 'PENDING', attempt_count integer NOT NULL DEFAULT 0,  
lease_owner varchar(128) NULL, lease_until timestamptz NULL, result_ref uuid NULL, problem_code varchar(96) NULL,  
created_at timestamptz NOT NULL DEFAULT now(), updated_at timestamptz NOT NULL DEFAULT now(),  
CONSTRAINT pk_ec02_operation PRIMARY KEY (tenant_id,operation_id),  
CONSTRAINT ck_ec02_operation_status CHECK (status IN ('PENDING','IN_PROGRESS','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED')),  
CONSTRAINT ck_ec02_operation_attempt CHECK (attempt_count\>=0)  
);  
  
CREATE TABLE ec02.ec02_idempotency_record (  
tenant_id uuid NOT NULL, idempotency_key varchar(160) NOT NULL, command_name varchar(96) NOT NULL,  
request_hash varchar(128) NOT NULL, status varchar(20) NOT NULL DEFAULT 'IN_PROGRESS', response_code integer NULL,  
response_body jsonb NULL, lease_owner varchar(128) NULL, lease_until timestamptz NULL,  
created_at timestamptz NOT NULL DEFAULT now(), completed_at timestamptz NULL,  
CONSTRAINT pk_ec02_idem PRIMARY KEY (tenant_id,idempotency_key),  
CONSTRAINT ck_ec02_idem_state CHECK (status IN ('IN_PROGRESS','COMPLETED','FAILED_RECOVERABLE')),  
CONSTRAINT ck_ec02_idem_response CHECK (response_code IS NULL OR response_code BETWEEN 100 AND 599)  
);  
  
CREATE TABLE ec02.ec02_outbox_event (  
tenant_id uuid NOT NULL, event_id uuid NOT NULL DEFAULT gen_random_uuid(), aggregate_type varchar(64) NOT NULL,  
aggregate_id uuid NOT NULL, event_type varchar(96) NOT NULL, schema_version integer NOT NULL DEFAULT 1,  
correlation_id uuid NOT NULL, causation_id uuid NULL, payload jsonb NOT NULL, status varchar(20) NOT NULL DEFAULT 'PENDING',  
available_at timestamptz NOT NULL DEFAULT now(), claim_owner varchar(128) NULL, claim_until timestamptz NULL,  
occurred_at timestamptz NOT NULL DEFAULT now(), CONSTRAINT pk_ec02_outbox PRIMARY KEY (tenant_id,event_id),  
CONSTRAINT ck_ec02_outbox_status CHECK (status IN ('PENDING','CLAIMED','DELIVERED','DEAD'))  
);  
CREATE INDEX ix_ec02_outbox_dispatch ON ec02.ec02_outbox_event(status,available_at);  
  
CREATE TABLE ec02.ec02_inbox_receipt (  
tenant_id uuid NOT NULL, message_id uuid NOT NULL, consumer_name varchar(96) NOT NULL, event_type varchar(96) NOT NULL,  
schema_version integer NOT NULL DEFAULT 1, received_at timestamptz NOT NULL DEFAULT now(), processed_at timestamptz NULL,  
status varchar(20) NOT NULL DEFAULT 'RECEIVED', last_error_code varchar(96) NULL,  
CONSTRAINT pk_ec02_inbox PRIMARY KEY (tenant_id,message_id,consumer_name),  
CONSTRAINT ck_ec02_inbox_status CHECK (status IN ('RECEIVED','PROCESSED','FAILED','DEAD'))  
);  
  
-- Row Level Security: repeat for every tenant-scoped table.  
ALTER TABLE ec02.ec02_program_edition ENABLE ROW LEVEL SECURITY;  
ALTER TABLE ec02.ec02_program_edition FORCE ROW LEVEL SECURITY;  
CREATE POLICY p_ec02_program_edition_tenant ON ec02.ec02_program_edition  
USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid)  
WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);  
  
-- Runtime role MUST NOT have BYPASSRLS. Migration role is separate.  
-- Apply the same ENABLE/FORCE/POLICY pattern to all ec02 tenant tables.

## 13.1 Triggers/procedures defensivos obligatorios

-- Pseudocode PL/pgSQL normative pattern  
-- 1) child mutation must bump root revision atomically  
-- UPDATE ec02_program_edition SET version=version+1, updated_at=now()  
-- WHERE tenant_id=:tenant AND edition_id=:edition AND version=:expectedVersion;  
-- IF row_count=0 THEN raise serialization/conflict mapped to HTTP 412.  
  
-- 2) publication_receipt append-only  
REVOKE UPDATE, DELETE ON ec02.ec02_publication_receipt FROM peopleu_runtime;  
  
-- 3) cancellation_record append-only except technical evidence enrichment through governed procedure.  
-- 4) lineage guards prevent self-reference in supersedes fields.  
-- 5) tenant context must be SET LOCAL at transaction start and verified non-null.

# 14. MongoDB y Redis

PostgreSQL es Source of Truth. MongoDB solo se justifica para read models derivados de alta lectura, por ejemplo EditionOperationalView o ScheduleBoardProjection, regenerables desde PostgreSQL/eventos. Nunca se usa MongoDB para el estado autoritativo de edición, offering, demanda o receipt.

Redis se usa únicamente como acelerador: cache de catálogos/policies, locks técnicos de corta vida cuando el algoritmo lo requiera, rate limits y query-cache. Idempotency, operation status y outbox NO pueden depender exclusivamente de Redis.

| **Uso**                 | **Tecnología** | **TTL/estrategia**            | **Autoritativo** |
|-------------------------|----------------|-------------------------------|------------------|
| EditionOperationalView  | MongoDB        | rebuildable projection        | NO               |
| Schedule board cache    | Redis          | 30–120 s + invalidation event | NO               |
| Policy resolution cache | Redis          | por policy effective_until    | NO               |
| Rate limit              | Redis          | sliding window                | NO               |
| Idempotency             | PostgreSQL     | durable retention policy      | SÍ para dedupe   |

# 15. Backend Java 21 / Spring Boot / Spring Modulith

EC-02 se implementa como módulo Spring Modulith con paquetes de dominio, application, ports y adapters. Los adapters a CT-03/13/14/18 son contratos explícitos; ningún repository accede a schemas de otro bounded context.

com.peopleu.ec02  
├─ domain  
│ ├─ edition  
│ ├─ delivery  
│ ├─ offering  
│ ├─ scheduling  
│ └─ shared  
├─ application  
│ ├─ command  
│ ├─ query  
│ ├─ service  
│ └─ mapper  
├─ ports  
│ ├─ in  
│ └─ out  
└─ adapters  
├─ web  
├─ persistence  
├─ ct03  
├─ ct13  
├─ ct14  
├─ ct18  
├─ events  
└─ observability

## 15.1 Transacción y tenant context

Cada command inicia una transacción, deriva tenant/scope del security context, ejecuta SET LOCAL peopleu.tenant_id y solo entonces accede a repositories. El runtime role no puede bypassar RLS. Jobs batch procesan tenant por tenant con contexto explícito; nunca ejecutan queries globales con el mismo role de aplicación.

## 15.2 Aggregate revision

EditionApplicationService recibe expectedVersion desde If-Match, ejecuta una actualización compare-and-swap del root y persiste hijos dentro de la misma transacción. Si el row_count del root es cero se devuelve 412 PRECONDITION_FAILED con reasonCode EC02_VERSION_CONFLICT.

## 15.3 Ports críticos

| **Port**            | **Responsabilidad**            | **Timeout baseline** | **Fallback**                              |
|---------------------|--------------------------------|----------------------|-------------------------------------------|
| ProgramCatalogPort  | Resolver ProgramVersion EC-01  | 1.5 s                | fail closed en create/publish             |
| CalendarPort        | Resolver CT-03                 | 1.5 s                | STALE solo lectura; publish fail closed   |
| SchedulingPort      | CT-13 submit/status/reconcile  | 3 s                  | UNKNOWN_EFFECT + operation status         |
| ResourcePort        | CT-14 request/status/release   | 3 s                  | PARTIAL/UNKNOWN_EFFECT                    |
| ExternalChannelPort | CT-18 provision/status/release | 5 s                  | PARTIAL/UNKNOWN_EFFECT                    |
| WorkflowPort        | CT-06 approvals                | 2 s                  | 503 / pending                             |
| AiAssistPort        | CT-12                          | 8 s                  | UNAVAILABLE sin bloquear operación manual |

# 16. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

| **Método** | **Ruta**                                       | **Propósito**              | **Control**            | **Respuesta** |
|------------|------------------------------------------------|----------------------------|------------------------|---------------|
| POST       | /api/ec02/editions                             | Crear edición              | Idempotency-Key        | 201           |
| GET        | /api/ec02/editions                             | Listar paginado            | —                      | 200           |
| GET        | /api/ec02/editions/{id}                        | Detalle                    | —                      | 200 + ETag    |
| PATCH      | /api/ec02/editions/{id}                        | Metadata escalar permitida | If-Match               | 200           |
| POST       | /api/ec02/editions/{id}:validate               | Validar readiness          | If-Match               | 200/422       |
| POST       | /api/ec02/editions/{id}:request-publish        | Workflow                   | If-Match + Idempotency | 202           |
| POST       | /api/ec02/editions/{id}:publish                | Publicar                   | If-Match + Idempotency | 200           |
| POST       | /api/ec02/editions/{id}:suspend                | Suspender                  | If-Match + Idempotency | 200           |
| POST       | /api/ec02/editions/{id}:cancel                 | Cancelar                   | If-Match + Idempotency | 202           |
| POST       | /api/ec02/editions/{id}:close                  | Cerrar                     | If-Match + Idempotency | 200           |
| POST       | /api/ec02/editions/{id}/offerings              | Crear offering             | If-Match               | 201           |
| PATCH      | /api/ec02/offerings/{id}                       | Editar offering            | If-Match root          | 200           |
| POST       | /api/ec02/offerings/{id}:publish               | Publicar offering          | Idempotency + If-Match | 200           |
| POST       | /api/ec02/editions/{id}/cohorts                | Crear cohorte              | If-Match               | 201           |
| PATCH      | /api/ec02/cohorts/{id}                         | Editar capacidad/nombre    | If-Match root          | 200           |
| POST       | /api/ec02/editions/{id}/delivery-plans         | Crear plan                 | If-Match               | 201           |
| POST       | /api/ec02/delivery-plans/{id}:generate-demands | Generar demandas           | Idempotency + If-Match | 200           |
| POST       | /api/ec02/delivery-plans/{id}:submit-schedule  | Enviar CT-13               | Idempotency + If-Match | 202           |
| GET        | /api/ec02/operations/{operationId}             | Status async               | —                      | 200           |
| POST       | /api/ec02/operations/{operationId}:reconcile   | Reconciliar                | Idempotency            | 202/200       |
| POST       | /api/ec02/session-demands/{id}:reschedule      | Reprogramar                | Idempotency + If-Match | 202           |
| POST       | /api/ec02/session-demands/{id}:cancel          | Cancelar sesión            | Idempotency + If-Match | 202           |
| GET        | /api/ec02/editions/{id}/operational-view       | Read model E2E             | —                      | 200           |
| POST       | /api/ec02/editions/{id}:ai-assist              | Sugerencia CT-12           | Idempotency            | 202           |

## 16.1 Paginación y filtros

List endpoints soportan cursor o page/size según baseline, size default 25, máximo 200, sort estable por created_at,id y filtros tenant-scoped por state, programVersionRef, date range, scope, offeringType y modality. La API devuelve metadata de paginación y jamás hace un SELECT sin tenant.

## 16.2 ProblemDetail

| **HTTP** | **Uso**                 | **Reason code ejemplo** |
|----------|-------------------------|-------------------------|
| 400      | Request/schema inválido | EC02_REQUEST_INVALID    |
| 401      | No autenticado          | AUTH_REQUIRED           |
| 403      | No autorizado/scope     | EC02_SCOPE_DENIED       |
| 404      | No encontrado en tenant | EC02_EDITION_NOT_FOUND  |
| 409      | Conflicto de estado     | EC02_STATE_CONFLICT     |
| 412      | ETag/root version       | EC02_VERSION_CONFLICT   |
| 422      | Regla de negocio        | EC02_READINESS_FAILED   |
| 429      | Rate limit              | RATE_LIMITED            |
| 503      | Dependencia crítica     | CT13_UNAVAILABLE        |

# 17. Eventos, outbox/inbox y AsyncAPI

| **Evento**                 | **Aggregate**               | **Consumidores esperados**                 | **Payload mínimo**                                                                                        |
|----------------------------|-----------------------------|--------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| EditionCreated             | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| EditionPlanningStarted     | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| EditionReady               | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| EditionPublished           | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| EditionSuspended           | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| EditionCancelled           | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| EditionClosed              | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| OfferingPublished          | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| OfferingSuspended          | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| CohortCreated              | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| DeliveryPlanValidated      | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| ScheduleRequested          | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| ScheduleConfirmed          | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| SchedulePartiallyConfirmed | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| ScheduleUnknownEffect      | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| SessionRescheduleRequested | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| SessionRescheduled         | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| SessionCancelled           | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| ResourceBindingConfirmed   | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| ChannelBindingConfirmed    | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |
| OperationalReadinessFailed | ProgramEdition/DeliveryPlan | EC-03/04/05/06, CT-07/11/17 según contrato | event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at, refs/estado |

## 17.1 Outbox claiming

Dispatcher reclama lotes con SELECT … FOR UPDATE SKIP LOCKED, establece claim_owner/claim_until, publica, marca DELIVERED o reprograma available_at con backoff. Poison events pasan a DEAD tras umbral policy y generan alerta/runbook. Replay manual requiere reason code y auditoría.

# 18. Integraciones, resiliencia, reconciliación y UNKNOWN_EFFECT

| **Integración** | **Comando**                       | **Timeout** | **Retry**                  | **UNKNOWN_EFFECT** | **Reconciliation**                               |
|-----------------|-----------------------------------|-------------|----------------------------|--------------------|--------------------------------------------------|
| CT-13           | submit/reschedule/cancel schedule | 3 s         | solo tras status/reconcile | Sí                 | GET operation/binding by idempotency/correlation |
| CT-14           | reserve/release resources         | 3 s         | solo si no aplicado        | Sí                 | status receipt                                   |
| CT-18           | provision/release channel         | 5 s         | solo si no aplicado        | Sí                 | provider binding status                          |
| CT-06           | workflow action                   | 2 s         | safe idempotent            | Posible            | workflow instance status                         |
| EC-01           | resolve ProgramVersion            | 1.5 s       | read retry bounded         | No effect          | re-query                                         |

## 18.1 Algoritmo obligatorio UNKNOWN_EFFECT

1.  Persistir operation antes del call remoto.

2.  Enviar Idempotency-Key/correlation contract si el proveedor lo soporta.

3.  Si hay timeout tras posible aceptación, marcar UNKNOWN_EFFECT.

4.  No cambiar la UI a FAILED ni retry automático ciego.

5.  Ejecutar status/reconcile por operation/correlation/idempotency.

6.  Si remoto confirma, persistir receipt y completar operación.

7.  Si remoto demuestra ausencia de efecto, retry con la misma key o nueva según contrato.

8.  Si no puede resolverse, mantener UNKNOWN_EFFECT, alertar y habilitar runbook/manual reconciliation.

# 19. Frontend Web enterprise por workspaces

| **Workspace**         | **Usuario**         | **Ruta**                      | **Layout/componentes**                                                                                      | **Acciones**                                    | **Estados críticos**                               |
|-----------------------|---------------------|-------------------------------|-------------------------------------------------------------------------------------------------------------|-------------------------------------------------|----------------------------------------------------|
| Edition Studio        | Program Manager     | /ec/editions/:id              | Header con state/ETag/readiness; tabs Overview, Offerings, Cohorts, Delivery, Sessions, Integrations, Audit | Create/edit metadata, validate, request publish | DRAFT/STALE/PARTIAL/UNKNOWN_EFFECT visibles        |
| Offering Desk         | Commercial Ops      | /ec/editions/:id/offerings    | Grid ofertas + drawer                                                                                       | Create/edit/publish/suspend                     | No mostrar precio oficial si EC-03 unavailable     |
| Delivery Planner      | Scheduler Operator  | /ec/editions/:id/delivery     | Timeline demand-centric + constraints                                                                       | Generate demand, validate, submit schedule      | Demand vs confirmed visualmente distinto           |
| Schedule Board        | Operations          | /ec/editions/:id/schedule     | Calendar/read model con source badges                                                                       | Reconcile, reschedule, cancel                   | UNKNOWN_EFFECT con callout y no optimistic success |
| Cohort Console        | Operations          | /ec/editions/:id/cohorts      | Cards/tabla capacidades                                                                                     | Create/edit capacity                            | No roster de personas                              |
| Reconciliation Center | Ops/SRE             | /ec/operations                | Queue por status/age/dependency                                                                             | Reconcile/retry governed                        | PARTIAL/UNKNOWN_EFFECT prioritizados               |
| Cancellation Center   | Authorized Approver | /ec/editions/:id/cancellation | Impact summary + downstream effects                                                                         | Request/approve/cancel                          | Step-up y SoD obligatorios cuando policy           |

## 19.1 Estados UI obligatorios

| **Estado**     | **Significado**                     | **Tratamiento UI**                      |
|----------------|-------------------------------------|-----------------------------------------|
| NO_DATA        | Consulta exitosa sin registros      | Empty state contextual                  |
| ZERO           | Hecho numérico = 0                  | Mostrar 0 explícito                     |
| STALE          | Datos anteriores aún utilizables    | Badge + timestamp + refresh             |
| PARTIAL        | Parte de integraciones confirmada   | Lista de confirmados/faltantes          |
| UNAVAILABLE    | Servicio no respondió               | Error contextual + retry seguro         |
| UNKNOWN_EFFECT | No se sabe si efecto remoto ocurrió | Bloquear retry ciego; ofrecer reconcile |

## 19.2 Baseline tecnológico Frontend

TypeScript strict, client generado desde OpenAPI, query/cache library institucional, schemas de validación compartidos desde contrato generado, forms por feature, query keys estables por tenant/scope/id/version, error boundary por workspace, ETag almacenado junto al resource, tests unit/component/E2E y accessibility WCAG 2.2 AA. No se permite fetch ad-hoc disperso.

# 20. Mobile

EC-02 sí tiene Mobile selectivo para operaciones de campo, no para administración completa. React Native puede mostrar agenda operativa, cambios/reprogramaciones, estado de sesiones y acciones de reconcile de bajo riesgo para roles autorizados. Publicar/cancelar edición completa o alterar estructura de delivery se mantiene Web salvo política explícita.

| **Journey Mobile**            | **Permitido**              | **Offline**                             | **Seguridad**                     |
|-------------------------------|----------------------------|-----------------------------------------|-----------------------------------|
| Agenda operativa              | Sí                         | cache read-only con timestamp           | scope + biometric unlock opcional |
| Ver cambio/reprogramación     | Sí                         | último estado STALE visible             | push/deep link                    |
| Confirmar recepción de alerta | Sí                         | queue local sin cambiar hecho académico | idempotent                        |
| Reconcile UNKNOWN_EFFECT      | Solo rol Ops; preferir Web | No                                      | step-up según riesgo              |
| Publicar edición              | NO baseline                | —                                       | Web + SoD                         |
| Cancelar edición              | NO baseline                | —                                       | Web + step-up/SoD                 |

# 21. Matriz Frontend / Backend / Mobile

| **Capacidad**        | **Backend**               | **Web**               | **Mobile**             |
|----------------------|---------------------------|-----------------------|------------------------|
| Crear/editar edición | Commands + ETag           | Completo              | No                     |
| Offerings            | Commands + policy         | Completo              | Lectura                |
| Cohorts              | Commands                  | Completo              | Lectura                |
| DeliveryPlan         | DDD + validators          | Completo              | Lectura                |
| SessionDemand        | Generate/submit/reconcile | Completo              | Agenda                 |
| UNKNOWN_EFFECT       | OperationStatus           | Reconciliation Center | Read/limited reconcile |
| Cancelación          | Workflow/compensation     | Completo + step-up    | No                     |
| Audit/Evidence       | Audit ports               | Timeline              | Resumen                |

# 22. Seguridad: RBAC, ABAC, SoD, step-up y privacy

| **Rol**                  | **Permisos principales**                | **Controles**               |
|--------------------------|-----------------------------------------|-----------------------------|
| EC_PORTFOLIO_MANAGER     | Crear edición, offering/cohort draft    | tenant/scope                |
| EC_SCHEDULER             | DeliveryPlan/session demands/scheduling | campus/scope                |
| EC_OPERATIONS            | Readiness/reconcile/reschedule          | scope + state               |
| EC_PUBLISH_APPROVER      | Aprobar publicación                     | SoD                         |
| EC_CANCELLATION_APPROVER | Cancelar edición                        | SoD + step-up               |
| EC_AUDITOR               | Read audit/evidence                     | purpose-limited             |
| EC_SUPPORT               | Read operational diagnostics            | no PII / no critical writes |

## 22.1 Threat Model mínimo EC-02

| **Amenaza**          | **Ejemplo**                            | **Mitigación**                          |
|----------------------|----------------------------------------|-----------------------------------------|
| IDOR cross-tenant    | Cambiar editionId de otro tenant       | RLS FORCE + ABAC + 404 scoped           |
| Mass assignment      | Enviar lifecycle_state por PATCH       | DTO allowlist + domain commands         |
| Replay               | Repetir cancel/publish                 | Idempotency durable                     |
| ETag bypass          | Mutar hijo sin bump root               | Aggregate Revision Contract             |
| Integration replay   | Duplicar ScheduleConfirmed             | Inbox dedupe                            |
| Schedule tampering   | Receipt no corresponde a operation     | correlation/idempotency/hash validation |
| Graph/payload DoS    | Miles de SessionDemand                 | policy capacity budgets                 |
| Privilege escalation | Solicitante se autoaprueba cancelación | SoD + CT-06                             |
| Secret leakage       | Meeting token en logs                  | secret redaction + CT-18 ownership      |

## 22.2 Secure SDLC

Gate de seguridad exige SAST, SCA, secret scanning, SBOM, container image scan, dependency policy, IaC scan, contract security tests, RLS tenant-isolation tests, API authorization matrix tests y revisión de migraciones con separación runtime/migration roles.

# 23. Auditoría, Evidence Pack, lineage y reason codes

Toda operación crítica registra tenant, actor, subject, scope, action, resource, timestamp, before/after, reason code, correlationId, policy version, assurance/step-up y evidence refs. Reschedule/cancel conserva lineage de demandas/bindings superseded. Publication receipts son append-only.

| **Acción**               | **Evidence mínima**                                                     |
|--------------------------|-------------------------------------------------------------------------|
| Publish edition          | validation report + workflow + hash + policy snapshot + actor + version |
| Reschedule session       | before/after demand/binding + reason + impact + remote receipts         |
| Cancel edition           | workflow + step-up + impact + downstream compensation receipts          |
| Reconcile unknown effect | operation history + remote status + resolver + timestamp                |
| Manual override          | reason + approver + policy + evidence                                   |

# 24. Observabilidad: logs, metrics, traces, SLI/SLO y performance

| **Métrica**                 | **Tipo**  | **Labels controlados** |
|-----------------------------|-----------|------------------------|
| ec02_command_latency        | histogram | command/state          |
| ec02_schedule_submit_total  | counter   | result                 |
| ec02_unknown_effect_total   | counter   | dependency/type        |
| ec02_reconcile_age_seconds  | gauge     | dependency             |
| ec02_outbox_lag_seconds     | gauge     | event_type             |
| ec02_inbox_failures_total   | counter   | consumer               |
| ec02_publish_failures_total | counter   | reason_code            |
| ec02_rls_denied_total       | counter   | operation              |
| ec02_etag_conflict_total    | counter   | resource               |

## 24.1 SLI/SLO baseline

| **SLI**                       | **SLO baseline** | **Exclusiones/nota**           |
|-------------------------------|------------------|--------------------------------|
| GET edition p95               | \< 300 ms        | sin dependencia externa        |
| Command local p95             | \< 500 ms        | sin remote wait                |
| Availability EC-02 API        | 99.9% mensual    | excluye ventanas acordadas     |
| Outbox delivery p95           | \< 30 s          | cuando broker disponible       |
| UNKNOWN_EFFECT unresolved p95 | \< 10 min        | dependiente de remoto; alertar |
| Tenant isolation              | 100%             | cero tolerancia                |

# 25. IA aplicada al módulo

IA entra exclusivamente por CT-12. Puede recomendar patrones de horario, identificar conflictos de ventanas, estimar riesgo de baja ocupación usando datos autorizados, sugerir alternativas ante indisponibilidad y resumir impacto de reprogramación. Nunca confirma reservas, publica ofertas, cancela ediciones ni cambia la agenda real.

| **Caso IA**                | **Input permitido**                | **Output**           | **Humano decide** |
|----------------------------|------------------------------------|----------------------|-------------------|
| Sugerir patrón de sesiones | constraints + histórico agregado   | draft delivery plan  | Sí                |
| Detectar riesgos           | plan + indicadores no sensibles    | risk list/confidence | Sí                |
| Proponer reprogramación    | constraints + unavailable receipts | alternativas         | Sí                |
| Resumen de impacto         | change set + refs                  | resumen trazable     | Sí                |

Guardar run_ref, model_ref, prompt/template_ref, eval_ref, grounding_refs, confidence, reviewer y outcome. La aceptación crea un comando normal de dominio; AI response jamás persiste directamente en tablas de negocio.

# 26. Analítica y KPI

| **KPI**                         | **Definición**                             | **Source**                |
|---------------------------------|--------------------------------------------|---------------------------|
| Lead time edición→publicación   | published_at-created_at                    | EC-02                     |
| Schedule confirmation lead time | confirmed_at-submit_at                     | EC-02 receipts            |
| % sesiones reprogramadas        | rescheduled / total bound                  | EC-02                     |
| UNKNOWN_EFFECT rate             | unknown operations / remote ops            | EC-02                     |
| Resource confirmation rate      | confirmed resource receipts / requests     | EC-02                     |
| Offering activation rate        | published offerings / planned              | EC-02                     |
| Capacity utilization            | NO autoritativo aquí; requiere enrollments | EC-04 + EC-02 denominator |
| Cancellation rate               | cancelled editions / published             | EC-02                     |

# 27. Migración legacy y Data Quality con CT-16

Migración: Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → receipt → reconcile → certify. Nunca INSERT directo a tablas finales. Se preservan source lineage, legacy key, transformed payload, validation result, promotion result y receipt.

| **DQ Rule**                         | **Severidad**              | **Tratamiento**                     |
|-------------------------------------|----------------------------|-------------------------------------|
| Edition sin ProgramVersion mapeable | BLOCKER                    | no promover                         |
| Ventana invertida                   | BLOCKER                    | corregir source/mapping             |
| Timezone no IANA                    | BLOCKER                    | mapear catálogo                     |
| Session sin duración                | BLOCKER                    | completar/descartar con evidencia   |
| Aula legacy sin CT-14 mapping       | WARN/BLOCKER según publish | crear external mapping              |
| Meeting URL sin CT-18 binding       | WARN                       | migrar como evidence, reprovisionar |
| Estado legacy ambiguo               | WARN                       | mapear con policy y reason          |

# 28. QA y estrategia de pruebas

| **Suite**            | **Cobertura**                                          |
|----------------------|--------------------------------------------------------|
| Unit Tests           | Value objects, policies, transitions                   |
| Domain Tests         | aggregate invariants, root revision                    |
| Repository Tests     | constraints, FK tenant-aware, append-only              |
| RLS Tenant Isolation | SELECT/INSERT/UPDATE/DELETE cross-tenant negativos     |
| Integration Tests    | PostgreSQL + Testcontainers                            |
| Contract Tests       | EC-01/CT-03/13/14/18                                   |
| API Tests            | ProblemDetail, ETag, idempotency, pagination           |
| Event Contract Tests | AsyncAPI/schema evolution                              |
| Concurrency Tests    | dos writers sobre hijos/root                           |
| Idempotency Tests    | replay/crash/recovery lease                            |
| Resilience Tests     | timeouts, partial, unknown effect                      |
| Performance Tests    | 1k concurrent reads/commands baseline acorde capacidad |
| Migration Tests      | dry-run/promote/reconcile                              |
| E2E                  | crear→planificar→schedule→publicar→reprogramar         |
| Security Tests       | RBAC/ABAC/SoD/step-up/IDOR                             |
| Mobile Tests         | offline stale/push/deep-link                           |
| AI Evals             | grounding, unsafe autonomous action blocked            |

# 29. Golden Scenarios

| **GS**      | **Escenario**                                       | **Precondición**    | **Acción**      | **Resultado esperado**         | **Evidencia**               |
|-------------|-----------------------------------------------------|---------------------|-----------------|--------------------------------|-----------------------------|
| GS-EC02-001 | Crear edición válida                                | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-002 | Rechazar ProgramVersion no publicable               | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-003 | Cross-tenant create bloqueado                       | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-004 | Código de edición duplicado                         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-005 | Ventana inválida                                    | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-006 | Crear offering OPEN                                 | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-007 | Publicar offering sin readiness                     | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-008 | Crear cohorte con capacity válida                   | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-009 | Rechazar capacity target\>max                       | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-010 | Generar sesiones desde estructura                   | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-011 | Rechazar duración cero                              | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-012 | Enviar schedule con idempotency                     | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-013 | Duplicar submit sin doble efecto                    | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-014 | Timeout CT-13→UNKNOWN_EFFECT                        | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-015 | Reconcile confirma schedule                         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-016 | Reconcile demuestra no aplicado y retry             | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-017 | Binding con correlation incorrecta rechazado        | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-018 | Resource reservation parcial                        | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-019 | Channel provisioning unavailable                    | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-020 | Publicar edición con todos los gates                | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-021 | Publicar con ETag stale→412                         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-022 | Dos writers editan children→uno 412                 | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-023 | RLS bloquea SELECT cross-tenant                     | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-024 | RLS bloquea INSERT tenant spoof                     | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-025 | Reprogramar sesión confirmada                       | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-026 | Reschedule conserva binding anterior                | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-027 | Cancel session libera recursos                      | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-028 | Release timeout→UNKNOWN_EFFECT                      | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-029 | Cancelar edición con SoD                            | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-030 | Actor intenta autoaprobar cancelación               | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-031 | Step-up ausente bloquea cancelación                 | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-032 | Cierre edición no completa participantes            | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-033 | Offering pricing ref unavailable se marca stale     | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-034 | CT-03 stale no permite publish según policy         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-035 | CT-13 unavailable muestra UNAVAILABLE no NO_DATA    | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-036 | Schedule board sin sesiones muestra NO_DATA         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-037 | Cero sesiones esperado muestra ZERO                 | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-038 | Read model parcial muestra PARTIAL                  | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-039 | Outbox duplicate publish no duplica consumer effect | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-040 | Inbox duplicate ScheduleConfirmed deduplica         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-041 | Poison event pasa DEAD + alerta                     | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-042 | Idempotency record IN_PROGRESS recuperado por lease | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-043 | Operation 202 consultable por status                | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-044 | Operation desconocida 404 tenant scoped             | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-045 | AI sugiere horario pero no persiste                 | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-046 | AI unavailable no bloquea flujo manual              | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-047 | Migración dry-run detecta timezone inválida         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-048 | Migración promote genera receipts                   | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-049 | Legacy room sin mapping no crea FK externa          | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-050 | Cancel record append-only                           | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-051 | Publication receipt no UPDATE/DELETE                | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-052 | Paginación estable con inserts concurrentes         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-053 | Payload sobre capacity budget 422/413               | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-054 | Rate limit 429                                      | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-055 | SLO alert por unknown effect age                    | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-056 | Trace correlation E2E                               | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-057 | Reason code presente en reschedule                  | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-058 | Audit before/after consistente                      | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-059 | Mobile offline muestra STALE timestamp              | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-060 | Deep link no salta autorización                     | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-061 | Zero-downtime N/N-1 migration                       | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-062 | Rollback operativo por roll-forward                 | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-063 | Policy version histórica reconstruible              | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-064 | Timezone display correcto Bolivia                   | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-065 | DST timezone internacional correcto                 | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-066 | Session demand no expone meeting secret             | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-067 | LMS binding provisto vía CT-18                      | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-068 | Resource ref proviene CT-14                         | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-069 | Instructor demand no crea Employee                  | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-070 | EC-04 consume EditionPublished                      | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-071 | Cancellation emite downstream effects               | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |
| GS-EC02-072 | Reopen CLOSED prohibido                             | Contexto controlado | Ejecutar acción | Resultado conforme BR/contract | HTTP/event/audit/DB receipt |

# 30. UAT institucional

| **UAT**     | **Aceptación**                                                                 |
|-------------|--------------------------------------------------------------------------------|
| UAT-EC02-01 | Crear una edición real desde un programa publicado                             |
| UAT-EC02-02 | Configurar horario nocturno y fin de semana sin programar manualmente recursos |
| UAT-EC02-03 | Publicar una oferta abierta                                                    |
| UAT-EC02-04 | Crear cohorte corporativa sin registrar personas                               |
| UAT-EC02-05 | Resolver scheduling con CT-13                                                  |
| UAT-EC02-06 | Simular indisponibilidad de aula y reprogramar                                 |
| UAT-EC02-07 | Simular timeout remoto y reconciliar UNKNOWN_EFFECT                            |
| UAT-EC02-08 | Publicar edición con aprobación SoD                                            |
| UAT-EC02-09 | Cancelar edición y verificar efectos downstream                                |
| UAT-EC02-10 | Verificar audit/evidence pack                                                  |
| UAT-EC02-11 | Validar operación multi-sede                                                   |
| UAT-EC02-12 | Validar timezone internacional                                                 |
| UAT-EC02-13 | Validar Mobile agenda/read-only                                                |
| UAT-EC02-14 | Validar accesibilidad WCAG AA                                                  |
| UAT-EC02-15 | Validar que Finanzas/EC-04 siguen siendo SoT de sus hechos                     |
| UAT-EC02-16 | Validar migración legacy dry-run                                               |
| UAT-EC02-17 | Validar performance agreed                                                     |
| UAT-EC02-18 | Validar RLS tenant isolation                                                   |
| UAT-EC02-19 | Validar rollback/expand-contract                                               |
| UAT-EC02-20 | Validar dashboards operativos                                                  |

# 31. Gates G1-G10

| **Gate** | **Alcance**                    | **Evidencia mínima**                    |
|----------|--------------------------------|-----------------------------------------|
| G1       | Arquitectura y bounded context | ADR/SoT/contratos revisados             |
| G2       | Datos/constraints              | DDL/Flyway/RLS/tenant tests verdes      |
| G3       | Backend                        | DDD/application/adapters/tests          |
| G4       | API/Event contracts            | OpenAPI/AsyncAPI/contract tests         |
| G5       | Frontend/Mobile                | workspaces/states/a11y/E2E              |
| G6       | Seguridad/auditoría            | Threat model/SoD/step-up/SAST/SBOM      |
| G7       | Integraciones/resiliencia      | timeouts/retry/reconcile/UNKNOWN_EFFECT |
| G8       | QA/UAT                         | Golden scenarios + UAT evidence         |
| G9       | Migración/operaciones          | CT-16/runbooks/observability            |
| G10      | Release/certificación          | SLO/capacity/rollback/evidence pack     |

# 32. Definition of Ready / Definition of Done

## 32.1 Definition of Ready

- EC-00/EC-01 contracts identificados.

- ADR críticos cerrados.

- API/event schemas diseñados.

- Modelo físico y constraints revisados DBA.

- Threat model aprobado.

- UX workspaces y error states definidos.

- Dependencias CT con ambientes/mocks disponibles.

- Golden scenarios trazados a BR/UC.

## 32.2 Definition of Done

- Flyway aplicado en entorno limpio y upgrade N-1.

- RLS tenant isolation verde.

- Unit/domain/repository/integration/contract/E2E verdes.

- OpenAPI/AsyncAPI publicados y versionados.

- SLO dashboards/alerts activos.

- Runbooks ejercitados.

- UAT firmado.

- Evidence pack G1-G10 completo.

- No P0/P1 abiertos.

# 33. Runbooks

| **Runbook** | **Incidente**                | **Respuesta**                                                            |
|-------------|------------------------------|--------------------------------------------------------------------------|
| RB-EC02-001 | CT-13 unavailable            | Degradar submit, conservar demandas, alertar, retry bounded solo seguro. |
| RB-EC02-002 | UNKNOWN_EFFECT schedule      | Status/reconcile por operation; no retry ciego.                          |
| RB-EC02-003 | Resource partial             | Identificar faltantes, mantener PARTIAL, escalar CT-14.                  |
| RB-EC02-004 | Channel provisioning failure | No exponer URL inventada; reconcile CT-18.                               |
| RB-EC02-005 | Outbox lag                   | Examinar broker/claim leases; replay gobernado.                          |
| RB-EC02-006 | Inbox poison message         | Quarantine/DEAD, contract owner, no skip silencioso.                     |
| RB-EC02-007 | RLS misconfiguration         | Stop traffic, validate runtime role/policies, forensic audit.            |
| RB-EC02-008 | High ETag conflict           | Revisar UI refresh/workflow y hot aggregate.                             |
| RB-EC02-009 | Cancel partial effects       | Reconcile cada downstream effect y evidence.                             |
| RB-EC02-010 | Timezone/calendar mismatch   | Freeze publish, resolve CT-03/policy.                                    |
| RB-EC02-011 | Migration anomaly            | Rollback promotion by compensation/void, preserve lineage.               |
| RB-EC02-012 | Performance degradation      | Query plans/indexes/read model/cache; no bypass tenant.                  |

# 34. ADRs y decisiones abiertas

| **ADR**      | **Decisión**                                      | **Estado** |
|--------------|---------------------------------------------------|------------|
| ADR-EC02-001 | Edition aggregate y root revision                 | ACCEPTED   |
| ADR-EC02-002 | Offering separado de Edition                      | ACCEPTED   |
| ADR-EC02-003 | SessionDemand vs CT-13 Schedule                   | ACCEPTED   |
| ADR-EC02-004 | Receipts locales sin FK cross-context             | ACCEPTED   |
| ADR-EC02-005 | RLS FORCE RLS                                     | ACCEPTED   |
| ADR-EC02-006 | UNKNOWN_EFFECT obligatorio                        | ACCEPTED   |
| ADR-EC02-007 | Mobile selectivo                                  | ACCEPTED   |
| ADR-EC02-008 | Mongo solo read model derivado                    | ACCEPTED   |
| ADR-EC02-009 | Publication receipt append-only                   | ACCEPTED   |
| ADR-EC02-010 | Capacity intent ownership EC-02 / occupancy EC-04 | ACCEPTED   |
| ADR-EC02-011 | Cohort definition vs EC-04 enrollment             | ACCEPTED   |
| ADR-EC02-012 | Plan versioning/supersede                         | ACCEPTED   |

# 35. Engineering Pack

| **Ruta Git**                    | **Contenido mínimo**                     |
|---------------------------------|------------------------------------------|
| /docs/ec02/EC02.md              | Especificación operativa espejo del Word |
| /openapi/ec02.yaml              | REST contract                            |
| /asyncapi/ec02.yaml             | Event contract                           |
| /db/migration/ec02/V\*.sql      | Flyway expand/contract                   |
| /architecture/ec02/context.puml | Context/DER/sequence                     |
| /adr/ec02/                      | ADRs                                     |
| /backend/ec02/                  | Spring Modulith                          |
| /frontend/src/features/ec02/    | Feature modules                          |
| /mobile/src/features/ec02/      | Mobile subset                            |
| /tests/ec02/                    | unit/integration/contract/E2E            |
| /performance/ec02/              | k6/JMeter plans                          |
| /security/ec02/                 | threat model, authz matrix, SBOM refs    |
| /runbooks/ec02/                 | RB-EC02-\*                               |
| /observability/ec02/            | dashboards/alerts                        |
| /migration/ec02/                | mappings/DQ/dry-run                      |
| /evidence/ec02/                 | Gate evidence index                      |

# 36. Guía secuencial Backend

| **Paso** | **Implementación Backend**                                                                    |
|----------|-----------------------------------------------------------------------------------------------|
| 1        | Crear módulo Spring Modulith ec02 y reglas de module boundaries.                              |
| 2        | Crear Value Objects: EditionWindow, TimezoneId, CapacityIntent, ModalityMix, OperationStatus. |
| 3        | Crear Aggregate ProgramEdition con root version y métodos de intención.                       |
| 4        | Crear Offering, ExecutionCohort, DeliveryPlan y SessionDemand como hijos gobernados.          |
| 5        | Implementar Domain Policies y state machines.                                                 |
| 6        | Definir ports EC-01, CT-03, CT-06, CT-13, CT-14, CT-18, CT-12.                                |
| 7        | Crear Flyway schema/tables/constraints/indexes.                                               |
| 8        | Habilitar RLS FORCE y roles runtime/migration separados.                                      |
| 9        | Implementar repositories JPA/JDBC respetando tenant composite keys.                           |
| 10       | Implementar Aggregate Revision compare-and-swap y mapear a 412.                               |
| 11       | Implementar idempotency durable con recovery lease.                                           |
| 12       | Implementar OperationStatus 202/UNKNOWN_EFFECT.                                               |
| 13       | Implementar outbox transactionally y dispatcher SKIP LOCKED.                                  |
| 14       | Implementar inbox dedupe.                                                                     |
| 15       | Implementar adapters con timeout/retry/circuit breaker/reconcile.                             |
| 16       | Implementar controllers y ProblemDetail reason codes.                                         |
| 17       | Generar OpenAPI y contract tests.                                                             |
| 18       | Publicar AsyncAPI/event schemas.                                                              |
| 19       | Implementar unit/domain/repository/integration tests con Testcontainers.                      |
| 20       | Implementar tenant isolation/security tests.                                                  |
| 21       | Instrumentar logs/metrics/traces y correlation.                                               |
| 22       | Implementar performance budgets/capacity limits.                                              |
| 23       | Implementar expand/contract N/N-1 deployment tests.                                           |
| 24       | Completar Golden Scenarios y evidence Gates.                                                  |

# 37. Guía secuencial Frontend

| **Paso** | **Implementación Frontend**                                           |
|----------|-----------------------------------------------------------------------|
| 1        | Crear route structure /ec/editions con lazy feature boundaries.       |
| 2        | Generar API client y DTOs desde OpenAPI.                              |
| 3        | Definir query keys tenant/scope/resource/version.                     |
| 4        | Crear EditionWorkspaceShell con state, ETag, readiness y breadcrumbs. |
| 5        | Implementar Edition list con filtros/paginación/sort.                 |
| 6        | Implementar Edition details Overview.                                 |
| 7        | Implementar Offering Desk.                                            |
| 8        | Implementar Cohort Console.                                           |
| 9        | Implementar Delivery Planner demand-centric.                          |
| 10       | Implementar Schedule Board mostrando demand vs confirmed.             |
| 11       | Implementar Reconciliation Center.                                    |
| 12       | Implementar Cancellation Center con impact/step-up.                   |
| 13       | Implementar mutations con If-Match e Idempotency-Key.                 |
| 14       | Manejar 412 con diff/refresh explícito, nunca overwrite silencioso.   |
| 15       | Manejar NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.        |
| 16       | Implementar polling/backoff de operationId 202.                       |
| 17       | Implementar accessibility WCAG 2.2 AA.                                |
| 18       | Implementar responsive behavior y Mobile handoff/deep links.          |
| 19       | Implementar unit/component/MSW contract tests.                        |
| 20       | Implementar Playwright E2E Golden flows.                              |
| 21       | Instrumentar web-vitals/UX errors/correlation.                        |

# 38. Matriz de permisos

| **Acción**          | **Rol**                  | **ABAC/SoD**         | **Step-up**   |
|---------------------|--------------------------|----------------------|---------------|
| Crear edición       | EC_PORTFOLIO_MANAGER     | scope autorizado     | No            |
| Editar draft        | EC_PORTFOLIO_MANAGER     | state DRAFT/PLANNING | No            |
| Crear offering      | EC_PORTFOLIO_MANAGER/OPS | edition scope        | No            |
| Editar DeliveryPlan | EC_SCHEDULER             | scope + state        | No            |
| Submit schedule     | EC_SCHEDULER             | plan VALIDATED       | No            |
| Reconcile           | EC_OPERATIONS            | operation scope      | Según riesgo  |
| Request publish     | EC_PORTFOLIO_MANAGER     | READY                | No            |
| Approve publish     | EC_PUBLISH_APPROVER      | SoD                  | Según policy  |
| Reschedule          | EC_SCHEDULER/OPS         | reason + policy      | Según impacto |
| Cancel edition      | EC_CANCELLATION_APPROVER | SoD + reason         | Sí            |
| View audit          | EC_AUDITOR               | purpose limitation   | No            |
| AI assist           | Authorized designer/ops  | CT-12 scope          | No            |

# 39. Contratos DTO Frontend

export type EditionState = 'DRAFT'\|'PLANNING'\|'READY'\|'PUBLISHED'\|'IN_EXECUTION'\|'SUSPENDED'\|'CANCELLED'\|'CLOSED';  
export interface ProgramEditionDto {  
editionId: string; editionCode: string; programVersionRef: string;  
institutionScopeRef: string; timezoneId: string;  
plannedStartAt: string; plannedEndAt: string; lifecycleState: EditionState;  
readiness: ReadinessDto; version: number; etag: string;  
}  
export interface SessionDemandDto {  
sessionDemandId: string; sequenceNo: number; title: string; durationMinutes: number;  
earliestStartAt: string; latestEndAt: string; modalityCode: string;  
state: 'DRAFT'\|'READY'\|'SUBMITTED'\|'BOUND'\|'PARTIAL'\|'UNKNOWN_EFFECT'\|'CANCELLED'\|'SUPERSEDED';  
schedule?: BindingStatusDto; resources?: BindingStatusDto\[\]; channels?: BindingStatusDto\[\];  
}  
export interface OperationStatusDto {  
operationId: string; operationType: string;  
status: 'PENDING'\|'IN_PROGRESS'\|'SUCCEEDED'\|'FAILED'\|'UNKNOWN_EFFECT'\|'CANCELLED';  
attemptCount: number; problem?: ProblemDetailDto; updatedAt: string;  
}

## 39.1 Mutation contract

Todas las mutaciones críticas envían If-Match con el ETag del aggregate y Idempotency-Key cuando el comando puede producir side effects o retry. El frontend actualiza cache únicamente con la respuesta autoritativa del Backend; no sintetiza estados CONFIRMED/PUBLISHED localmente.

# 40. Checklist de release y certificación final

| **\#** | **Control**                                 | **Estado** |
|--------|---------------------------------------------|------------|
| 1      | AM/CT/EC-00/EC-01 alineados                 | ☐          |
| 2      | ADRs ACCEPTED                               | ☐          |
| 3      | DDL/Flyway versionado                       | ☐          |
| 4      | RLS FORCE aplicado a todas las tablas       | ☐          |
| 5      | runtime role sin BYPASSRLS                  | ☐          |
| 6      | constraints y tenant-aware FK verdes        | ☐          |
| 7      | OpenAPI sin drift                           | ☐          |
| 8      | AsyncAPI sin drift                          | ☐          |
| 9      | ETag/root revision testado                  | ☐          |
| 10     | Idempotency crash recovery testado          | ☐          |
| 11     | Outbox/inbox replay testado                 | ☐          |
| 12     | UNKNOWN_EFFECT/reconcile testado            | ☐          |
| 13     | Frontend states completos                   | ☐          |
| 14     | Mobile scope respetado                      | ☐          |
| 15     | RBAC/ABAC/SoD/step-up testado               | ☐          |
| 16     | Threat model mitigaciones cerradas          | ☐          |
| 17     | SAST/SCA/secrets/SBOM/container scan verdes | ☐          |
| 18     | SLI/SLO dashboards activos                  | ☐          |
| 19     | Runbooks ejercitados                        | ☐          |
| 20     | Migration dry-run certificado               | ☐          |
| 21     | Golden Scenarios verdes                     | ☐          |
| 22     | UAT firmado                                 | ☐          |
| 23     | Performance/capacity gates verdes           | ☐          |
| 24     | Expand/contract N/N-1 probado               | ☐          |
| 25     | Evidence Pack G1-G10 completo               | ☐          |
| 26     | No P0/P1 abiertos                           | ☐          |

# 41. Contrato FullStack no negociable de implementación

| **ID** | **Contrato**                                                                                   |
|--------|------------------------------------------------------------------------------------------------|
| CF-01  | No duplicar Source of Truth de CT/EC externos; usar ports/adapters.                            |
| CF-02  | Toda tabla tenant-scoped debe aplicar tenant-aware keys y RLS FORCE RLS.                       |
| CF-03  | Runtime DB role sin BYPASSRLS; migration role separado.                                        |
| CF-04  | Toda mutación de hijos bumpa ProgramEdition root version y exige ETag/If-Match.                |
| CF-05  | No last-write-wins silencioso.                                                                 |
| CF-06  | Comandos sensibles usan Idempotency-Key durable con recovery.                                  |
| CF-07  | Save + event usa transactional outbox; consumers inbox dedupe.                                 |
| CF-08  | UNKNOWN_EFFECT es estado de primera clase; no retry ciego.                                     |
| CF-09  | Frontend distingue NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.                      |
| CF-10  | SessionDemand jamás se presenta como horario confirmado.                                       |
| CF-11  | No FK cross-context ni joins directos a schemas externos.                                      |
| CF-12  | Policies/versiones no se hardcodean en Java/React.                                             |
| CF-13  | Historia se corrige con supersede/void/compensation, no borrado destructivo.                   |
| CF-14  | IA pasa por CT-12 y no ejecuta decisiones críticas.                                            |
| CF-15  | OpenAPI/AsyncAPI son contratos versionados y testeados.                                        |
| CF-16  | ProblemDetail/reason codes son estables.                                                       |
| CF-17  | Migrations son expand/contract y compatibles N/N-1.                                            |
| CF-18  | Secure SDLC y evidence Gates son requisito de release.                                         |
| CF-19  | Mobile implementa solo journeys aprobados, no espejo administrativo.                           |
| CF-20  | EC-02 no se considera terminado sin Golden Scenarios/UAT/Runbooks/observabilidad certificados. |

| **Baseline para EC-03…EC-12**                                                                                                                                                                                                                                                                             |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| El formato, profundidad, encuadres, matrices, modelo físico, DDL, contratos FullStack y criterio de suficiencia de EC-01 V1.1 se preservan en EC-02. Este documento, una vez aprobado, añade al baseline la semántica de ejecución operativa que ningún módulo posterior podrá redefinir silenciosamente. |
