**PEOPLEU IA**

**EC-05**

**DOCENTES, EXPERTOS, FACILITADORES,  
PLANIFICACIÓN, CONTENIDOS Y  
ENTORNO DE APRENDIZAJE**

Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Control**        | **Valor**                                                                                                      |
|--------------------|----------------------------------------------------------------------------------------------------------------|
| **Código**         | EC-05                                                                                                          |
| **Versión**        | V1.0                                                                                                           |
| **Estado**         | VIGENTE — ESPECIFICACIÓN IMPLEMENTABLE FULLSTACK ENTERPRISE                                                    |
| **Baseline**       | EC-00 V1.1 · EC-01 V1.1 — Plantilla Oficial FullStack Enterprise · EC-02/03/04 vigentes                        |
| **Vertical**       | Educación Continua / Formación Continua                                                                        |
| **Arquitectura**   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| **Stack objetivo** | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| **Contexto**       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| **Fecha base**     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS —** Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA —** EC-05 es Source of Truth del plan de impartición docente versionado, assignments académicos, unidades instruccionales, paquetes de contenido y bindings con entornos externos. PERSON pertenece a CT-04; EMPLOYMENT/CONTRACT a RRHH/Procurement; SESSION/SCHEDULE a EC-02 + CT-03/13; documentos a CT-05; LMS/Zoom/Teams/Meet a CT-18; asistencia a EC-06; evaluación/resultados a EC-07; feedback docente a EC-11. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaración de propósito, autoridad y baseline

| **V1.0 — FULLSTACK ENTERPRISE —** EC-05 adopta íntegramente el contrato de plantilla EC-01 V1.1 y del módulo anterior: PostgreSQL RLS ENABLE+FORCE, Aggregate Revision, ETag/If-Match, state transition guards, lineage, snapshots inmutables, idempotencia durable, outbox/inbox con lease, OperationStatus para 202/UNKNOWN_EFFECT, API paginada, Threat Model, Secure SDLC, expand/contract N/N-1 y bootstrap reproducible. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

EC-05 resuelve la preparación y gobierno de la entrega académica real. Educación Continua trabaja con docentes internos, expertos externos, speakers, facilitadores y equipos mixtos; con programas intensivos, nocturnos, fin de semana, virtuales, híbridos e in-company. El sistema debe poder responder quién impartirá qué, bajo qué rol y requisitos, con qué contenido versionado, con qué derechos de uso y en qué entorno externo, sin convertir esta vertical en RRHH, calendario, repositorio documental o LMS.

El módulo separa deliberadamente la definición académica EC-01 de la ejecución EC-02. TeachingPlan y TeachingPlanRevision expresan cómo se impartirá una edición; TeachingTeam e InstructorAssignment expresan asignaciones académicas; LearningContentPackage y sus versiones expresan contenido reusable. Los hechos temporales, contractuales, financieros y de desempeño conservan sus owners propios.

| **CRITERIO DE ÉXITO —** Un equipo Senior debe poder publicar un plan docente reproducible, asignar y reemplazar instructores sin reescribir historia, demostrar requisitos/aceptación, pinnear contenidos y derechos, provisionar LMS con reconciliación y operar ante timeouts sin duplicar cursos remotos. La pérdida de Redis/MongoDB no debe alterar ninguna verdad institucional. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquía documental aplicable

| **Prioridad**  | **Documento/artefacto**                | **Rol**                                                                        |
|----------------|----------------------------------------|--------------------------------------------------------------------------------|
| **1**          | AM-00 vigente                          | Constitución arquitectónica superior.                                          |
| **2**          | CT-00 vigente                          | Contrato maestro transversal.                                                  |
| **3**          | CT-01…CT-18 vigentes                   | Capacidades compartidas y fronteras.                                           |
| **4**          | EC-00 V1.1                             | Constitución de Educación Continua.                                            |
| **5**          | EC-01 V1.1                             | Plantilla FullStack Enterprise y contratos de diseño académico.                |
| **6**          | EC-02/03/04 vigentes                   | Edición/Offering, comercialización y vinculación.                              |
| **7**          | EC-05 V1.0 (este documento)            | Especificación implementable de docencia, contenidos y entorno de aprendizaje. |
| **Ejecutable** | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación/evidencia alineada al Word.                                     |

## 0.2 Secuencia oficial vigente de módulos EC

| **Orden** | **Código** | **Módulo oficial**                                                                            | **Responsabilidad primaria** |
|-----------|------------|-----------------------------------------------------------------------------------------------|------------------------------|
| **1**     | EC-01      | Portafolio, programas, versiones, módulos y rutas de microcredenciales                        | Diseño académico             |
| **2**     | EC-02      | Ediciones, ofertas, cohortes, modalidades, calendarios y programación operativa               | Oferta / ejecución           |
| **3**     | EC-03      | Comercialización académica, pricing, promociones, becas, convenios y condiciones de oferta    | Comercial                    |
| **4**     | EC-04      | Prospectos, participantes, registro, preinscripción, inscripción, cupos y listas de espera    | Vinculación                  |
| **5**     | EC-05      | Docentes, expertos, facilitadores, planificación, contenidos y entorno de aprendizaje         | Docencia                     |
| **6**     | EC-06      | Asistencia, participación, engagement y evidencia de sesiones                                 | Participación                |
| **7**     | EC-07      | Evaluaciones, resultados, aprobación, completion y cierre académico                           | Evaluación / cierre          |
| **8**     | EC-08      | Certificados, badges, microcredenciales, credenciales verificables y acumulabilidad           | Certificación                |
| **9**     | EC-09      | Formación corporativa / in-company, clientes, acuerdos, lotes y reporting empresarial         | B2B / Corporate              |
| **10**    | EC-10      | Trayectoria de aprendizaje, progresión, stackable credentials y reconocimiento acumulativo EC | Trayectoria                  |
| **11**    | EC-11      | Encuestas, NPS, feedback, evaluación docente, impacto y seguimiento posterior                 | Experiencia / impacto        |
| **12**    | EC-12      | Calidad, analítica de portafolio, indicadores, compliance y mejora continua                   | Calidad / gobierno           |

## 0.3 Decisiones arquitectónicas EC05-DA

| **ID**          | **Decisión normativa**                                                                                                                                                 |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **EC05-DA-001** | PERSON ≠ INSTRUCTOR ASSIGNMENT ≠ EMPLOYEE ≠ IAM USER. CT-04 posee Person; EC-05 assignment académico; RRHH/Procurement relación contractual; IAM autenticación.        |
| **EC05-DA-002** | TEACHING PLAN ≠ PROGRAM DEFINITION ≠ PROGRAM EDITION ≠ SCHEDULE. EC-05 planifica impartición; EC-01 define currículo; EC-02 posee edición; CT-03/13 tiempo/scheduling. |
| **EC05-DA-003** | TEACHING ROLE ≠ HR POSITION. Instructor, Facilitator, Speaker o Mentor son roles académicos parametrizados, no cargos laborales.                                       |
| **EC05-DA-004** | ASSIGNMENT ACCEPTANCE ≠ EMPLOYMENT/COMMERCIAL CONTRACT. Aceptar impartición no crea vínculo laboral ni compromiso financiero.                                          |
| **EC05-DA-005** | AVAILABILITY ≠ SCHEDULE. EC-05 puede consultar disponibilidad; CT-13/EC-02 resuelven y poseen agenda oficial.                                                          |
| **EC05-DA-006** | TEACHING PLAN REVISION = PUBLISHABLE SNAPSHOT. DRAFT es editable; SCHEDULED/PUBLISHED/SUPERSEDED no reescriben diseño.                                                 |
| **EC05-DA-007** | INSTRUCTOR ASSIGNMENT ES OPERACIONAL E HISTÓRICO. Su lifecycle puede progresar después de publish; persona/rol/scope aceptados no se sobreescriben.                    |
| **EC05-DA-008** | REPLACEMENT ≠ UPDATE PERSON_REF. Un reemplazo crea nuevo Assignment + lineage/reason/change request; el assignment anterior termina REPLACED.                          |
| **EC05-DA-009** | ASSIGNMENT REQUIREMENT RESULT = APPEND-ONLY. Revalidar crea un nuevo receipt; jamás se modifica una decisión previa.                                                   |
| **EC05-DA-010** | LEARNING CONTENT PACKAGE ≠ DOCUMENT BLOB. EC-05 versiona composición/semántica; CT-05 posee archivos y evidencias.                                                     |
| **EC05-DA-011** | CONTENT PACKAGE VERSION ≠ LMS COURSE. El contenido reusable existe independientemente del espacio técnico de entrega.                                                  |
| **EC05-DA-012** | CONTENT ITEM TARGET = EXACTLY ONE. Documento CT-05, recurso CT-18 o recurso LMS; no tres representaciones simultáneas.                                                 |
| **EC05-DA-013** | CONTENT RIGHTS ≠ CONTENT AVAILABILITY. Que un recurso exista no prueba que la universidad tenga derecho a reutilizarlo/publicarlo/grabarlo.                            |
| **EC05-DA-014** | CONTENT PUBLICATION ≠ LMS PROVISIONING. Publicar snapshot local y crear efecto remoto son transacciones distintas enlazadas por intent/receipt/outbox.                 |
| **EC05-DA-015** | SESSION INSTRUCTION PLAN ≠ SESSION SCHEDULE. EC-05 guarda objetivos/métodos; EC-02/CT-03 conserva fecha/hora/sesión.                                                   |
| **EC05-DA-016** | EXTERNAL LEARNING SPACE ≠ LOCAL TRUTH. Moodle/Zoom/Teams/Meet se referencian vía CT-18; EC-05 no usa SDKs ad-hoc.                                                      |
| **EC05-DA-017** | 202 ACCEPTED ≠ PROVISIONED. Toda operación async devuelve operationId y se consulta hasta terminal/reconciliación.                                                     |
| **EC05-DA-018** | UNKNOWN_EFFECT REQUIERE RECONCILIATION. Un timeout tras CREATE COURSE/MEETING no autoriza retry ciego.                                                                 |
| **EC05-DA-019** | RECORDING ≠ CONTENT OWNERSHIP. Grabación requiere policy, consentimiento/retención y derechos; el archivo final pertenece CT-05.                                       |
| **EC05-DA-020** | ASSIGNMENT ≠ ATTENDANCE. Que un docente esté asignado no demuestra que impartió la sesión; EC-06 registra evidencia de participación/asistencia.                       |
| **EC05-DA-021** | ASSIGNMENT ≠ INSTRUCTOR PERFORMANCE. EC-11 gobierna feedback/evaluación docente; EC-05 solo publica facts de asignación/ejecución previstos.                           |
| **EC05-DA-022** | AI RECOMMENDATION ≠ ASSIGNMENT/APPROVAL. CT-12 puede sugerir instructor, contenido o secuencia; humano/policy decide.                                                  |
| **EC05-DA-023** | CROSS-CONTEXT REFERENCE ≠ FK. CT/IAM/RRHH/EC-01/02/06/07/11/18 se consumen por port/contract, sin FK cross-context.                                                    |
| **EC05-DA-024** | TENANT-AWARE FK ≠ TENANT ISOLATION. PK/FK compuestas protegen integridad y PostgreSQL RLS protege lecturas/escrituras ante bugs.                                       |
| **EC05-DA-025** | POLICY REF = IMMUTABLE POLICY VERSION REF. Thresholds, requisitos, roles, rights, recording y releases nunca se hardcodean.                                            |
| **EC05-DA-026** | AGGREGATE REVISION ≠ ROOT ROW ONLY. Mutar hijo de TeachingPlanRevision/ContentPackageVersion incrementa revisión del root cuando forma parte del snapshot.             |
| **EC05-DA-027** | BUSINESS KEY ≠ EDITABLE LABEL. plan_code/package_code no cambian después de historia publicada.                                                                        |
| **EC05-DA-028** | PUBLICATION RECEIPT = APPEND-ONLY EVIDENCE. Hash/canonical schema/policy snapshot/actor/assurance son inmutables.                                                      |
| **EC05-DA-029** | IDEMPOTENCY IN_PROGRESS ≠ FOREVER. Leases, owner y recovery tras crash son obligatorios.                                                                               |
| **EC05-DA-030** | OUTBOX PENDING ≠ CLAIMED. Worker multi-instancia usa SKIP LOCKED + lease + retry/backoff.                                                                              |
| **EC05-DA-031** | MOBILE ≠ ADMIN WORKSPACE. Móvil sirve al instructor para agenda, aceptación, materiales y deep links; governance crítica permanece Web.                                |
| **EC05-DA-032** | SCHEMA RELEASE ≠ APP RELEASE. Flyway productivo usa expand/contract y compatibilidad N/N-1.                                                                            |
| **EC05-DA-033** | OPENAPI/ASYNCAPI = CONTRATOS EJECUTABLES. Generan clientes, contract tests y compatibility gates.                                                                      |
| **EC05-DA-034** | NO_DATA ≠ ZERO ≠ STALE ≠ PARTIAL ≠ UNAVAILABLE ≠ UNKNOWN_EFFECT. UI docente y Ops deben distinguirlos siempre.                                                         |

## 0.4 Criterio de suficiencia FullStack y regla de plantilla

EC-05 se considera suficiente cuando dos equipos Senior pueden implementar el mismo comportamiento observable, invariantes físicas, contratos HTTP/eventos, workspaces y degradación sin decidir por cuenta propia ownership, state machines, locks, idempotencia o semántica LMS. Toda variación institucional debe ser PolicyVersion o ADR explícito.

| **REGLA DE CONTINUIDAD —** EC-06…EC-12 no pueden redefinir Person, Assignment, ContentPackage, LMS provisioning o derechos de contenido que este módulo deja como Source of Truth/contrato. Una contradicción futura exige ADR y cambio versionado. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.5 Contrato FullStack heredado de EC-01 V1.1

| **Garantía**             | **Aplicación EC-05**                                                                       |
|--------------------------|--------------------------------------------------------------------------------------------|
| **RLS defense-in-depth** | Todas las tablas tenant-owned ENABLE + FORCE; runtime NO BYPASSRLS.                        |
| **Aggregate Revision**   | Snapshot design/content child mutation bump root + If-Match 412.                           |
| **State guards**         | TeachingPlanRevision, ContentVersion, Assignment e Invitation tienen transiciones físicas. |
| **History**              | Published snapshots/receipts/results/acceptance no hard-delete ni destructive update.      |
| **Idempotency**          | Publish, assign, invite, accept, provision, replace y bulk.                                |
| **Leased outbox**        | SKIP LOCKED, owner, lease, backoff, poison policy.                                         |
| **OperationStatus**      | 202 y provisioning/reconciliation se observan hasta terminal.                              |
| **UNKNOWN_EFFECT**       | Reconcile-before-retry para CT-18 y cualquier efecto remoto.                               |
| **Generated client**     | Frontend consume OpenAPI; DTOs manuales paralelos prohibidos.                              |
| **Secure SDLC**          | SAST/SCA/secret/SBOM/container scan + threat model + release gates.                        |
| **Expand/contract**      | Flyway N/N-1 y rollback por roll-forward compatible.                                       |
| **Developer bootstrap**  | Testcontainers, fixtures, seed, mocks contractuales y commands reproducibles.              |

# 1. Índice operativo del documento

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal de reglas BR-EC05

- 10\. Casos de uso UC-EC05

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

EC-05 transforma una edición académicamente definida en una entrega docente gobernada. Resuelve la frecuente fragmentación entre planillas de instructores, correos de confirmación, carpetas de materiales, links de Zoom, cursos LMS creados manualmente y políticas de grabación no trazables. La meta es que cada edición tenga un plan de impartición reconstruible, con responsabilidades claras y evidence chain.

## 2.1 Incluido

- TeachingPlan por edición y TeachingPlanRevision versionada/publicable.

- TeachingPlanModule para contextualizar módulos EC-01 sin redefinir currículo.

- TeachingTeam para equipos de coordinación, cofacilitación y speakers.

- InstructorAssignment para docentes internos, expertos externos, facilitadores, speakers y mentores.

- AssignmentRequirement y receipts append-only de cumplimiento/revalidación.

- Invitación/aceptación de assignment con token hash, assurance y terms PolicyVersion.

- Reemplazo docente por nuevo assignment + lineage/reason; no overwrite de person_ref.

- InstructionalUnitPlan para metodología/objetivos sin apropiarse de Session/Schedule.

- LearningContentPackage/Version reusable, content items, rights y release rules.

- TeachingContentBinding para pinning de contenido en plan/módulo/session/unit.

- RecordingPolicyBinding con privacy/consent/retention refs.

- ExternalLearningSpaceBinding y LmsProvisioningIntent/Receipt vía CT-18.

- Publicación, receipts, outbox/inbox, idempotency, OperationStatus y reconciliation.

- Web workspaces, Instructor Portal/Mobile, seguridad, QA, observabilidad y migración.

## 2.2 Fuera de alcance

- Crear/modificar ProgramDefinition, LearningModuleVersion u outcomes — EC-01.

- Crear ProgramEdition/Offering/cohort/sesiones/horarios — EC-02 + CT-03/13.

- Pricing, becas, promociones, cobros u honorarios — EC-03/Finanzas/RRHH.

- Registrar/matricular participantes — EC-04.

- Crear Person, usuario IAM, legajo laboral o contrato de consultoría — CT-04/IAM/RRHH/Procurement.

- Guardar PDFs, videos, SCORM binaries o recordings — CT-05.

- Registrar asistencia/engagement real — EC-06.

- Registrar evaluaciones/resultados/completion — EC-07.

- Emitir certificados — EC-08.

- Gobernar cliente corporativo/acuerdo — EC-09.

- Calcular desempeño docente/NPS — EC-11.

- Implementar LMS/Zoom/Teams/Meet directamente — CT-18.

| **ANTI-SCOPE —** EC-05 no es “RRHH académico”, no es agenda, no es Google Drive, no es Moodle y no es Zoom. Su responsabilidad es la semántica académica de impartición, assignments, contenido versionado y contratos de integración. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Término**                       | **Definición normativa**                                                |
|-----------------------------------|-------------------------------------------------------------------------|
| **TeachingPlan**                  | Identidad estable del plan de impartición para una ProgramEdition.      |
| **TeachingPlanRevision**          | Snapshot versionado/publicable del diseño de impartición.               |
| **TeachingPlanModule**            | Contexto docente local de un ProgramStructureItem/ModuleVersion EC-01.  |
| **TeachingTeam**                  | Equipo lógico de roles académicos para plan/módulo/sesión.              |
| **InstructorAssignment**          | Asignación de una Person a un rol académico scoped; no empleo.          |
| **AssignmentRequirement**         | Condición que un assignment debe satisfacer según policy.               |
| **AssignmentRequirementResult**   | Receipt append-only PASS/FAIL/WAIVED/etc. en un instante.               |
| **AssignmentInvitation**          | Invitación one-shot con token hash para aceptar/rechazar assignment.    |
| **AssignmentAcceptanceReceipt**   | Evidencia durable de aceptación de rol/terms; no contrato laboral.      |
| **TeachingChangeRequest**         | Solicitud gobernada para cambio material/reemplazo.                     |
| **InstructionalUnitPlan**         | Diseño de objetivos/metodología/duración prevista; no Session schedule. |
| **LearningContentPackage**        | Identidad reusable de un conjunto de recursos didácticos.               |
| **LearningContentPackageVersion** | Snapshot publicable de composición/metadata de contenido.               |
| **LearningContentItem**           | Elemento pinneado a documento CT-05 o recurso CT-18.                    |
| **ContentRightsBinding**          | Derechos/licencia/uso permitido del item.                               |
| **ContentReleaseRule**            | Intención versionada de liberación/visibilidad del item.                |
| **TeachingContentBinding**        | Uso de ContentItem en plan/módulo/sesión/unidad.                        |
| **ExternalLearningSpaceBinding**  | Referencia a course/meeting/team externo materializado por CT-18.       |
| **LmsProvisioningIntent**         | Comando durable para side effect remoto.                                |
| **ProvisioningReceipt**           | Observación append-only del efecto remoto.                              |
| **RecordingPolicyBinding**        | Policy refs de recording, consent, retention y publication scope.       |
| **PublicationReceipt**            | Evidencia append-only del snapshot publicado.                           |
| **EXT REF**                       | Referencia cross-context sin FK física; validada por contract/port.     |
| **UNKNOWN_EFFECT**                | No se sabe si el efecto remoto ocurrió; obliga reconcile-before-retry.  |
| **AggregateRevision**             | ETag que representa revisión del aggregate completo cuando aplica.      |

# 4. Bounded Context y matriz Source of Truth

EC-05 posee hechos de planificación docente y contenido, no las verdades transversales que consume. Las referencias externas se validan por ports; snapshots autorizados solo se conservan cuando son necesarios para reconstrucción. Publish es fail-closed ante dependencias críticas UNAVAILABLE: desconocido nunca se interpreta favorable.

| **Información**        | **Source of Truth** | **EC-05 almacena**           | **EC-05 referencia**               | **Regla**                  |
|------------------------|---------------------|------------------------------|------------------------------------|----------------------------|
| Tenant/scope           | CT-01               | tenant_id + owner refs       | organization/scope refs            | RLS + auth context.        |
| Catálogos/policies     | CT-02               | policy refs/snapshot mínimo  | role/method/rights/release codes   | No hardcode.               |
| Calendarios/sesiones   | CT-03 / EC-02       | No schedule                  | session_ref                        | EC-05 no crea horario.     |
| Persona canónica       | CT-04               | No PII shadow                | person_ref                         | Person ≠ Assignment.       |
| Documentos/evidencias  | CT-05               | refs/hash business metadata  | document/evidence refs             | No blobs.                  |
| Workflow               | CT-06               | resultado/ref mínimo         | workflow_ref                       | No motor local.            |
| Notificaciones         | CT-07               | request/receipt refs         | template/channel                   | Post-commit.               |
| i18n                   | CT-08               | canonical keys/locale        | translation refs                   | Translation ≠ version.     |
| Eventos/integración    | CT-09               | outbox/inbox local           | contract refs                      | At-least-once+dedup.       |
| Audit/privacy          | CT-10               | audit refs/business metadata | purpose/consent refs               | PII minimizada.            |
| BI                     | CT-11               | produce hechos               | dataset refs                       | No shadow BI.              |
| IA                     | CT-12               | run/eval refs                | AI run refs                        | Recommendation ≠ Decision. |
| Scheduling             | CT-13               | No                           | schedule refs downstream           | No solver local.           |
| Recursos               | CT-14               | No                           | resource/reservation refs          | No aulas locales.          |
| Elegibilidad           | CT-15               | requirement decision refs    | rule/decision refs                 | No motor local.            |
| Migración              | CT-16               | promotion receipts           | lineage refs                       | No direct INSERT.          |
| Continuidad            | CT-17               | No motor                     | runbook/continuity refs            | Degraded modes.            |
| LMS/ecosistema         | CT-18               | intent/binding/receipt local | provider/resource refs             | No SDK ad-hoc.             |
| Employment/engagement  | RRHH/Procurement    | engagement_ref               | contract/employment facts          | No nómina/contrato local.  |
| TeachingPlan/Revision  | EC-05               | Sí                           | —                                  | SoT local.                 |
| InstructorAssignment   | EC-05               | Sí                           | person/engagement refs             | Academic assignment only.  |
| ContentPackage/Version | EC-05               | Sí                           | document/resource refs             | No blobs.                  |
| Attendance             | EC-06               | No                           | assignment/session refs downstream | Assignment ≠ attendance.   |
| Assessment             | EC-07               | No                           | plan/content refs downstream       | No results local.          |
| Instructor feedback    | EC-11               | No                           | assignment refs downstream         | No performance local.      |

# 5. Dependencias CT-01 a CT-18, cores y otros módulos

| **Dependencia**      | **Responsabilidad**      | **Contrato EC-05**                          | **Frontera/fallo**     |
|----------------------|--------------------------|---------------------------------------------|------------------------|
| **CT-01**            | Scope institucional      | owner/scope validation                      | Fail-closed publish.   |
| **CT-02**            | Catálogos/PolicyVersion  | roles, methods, rights, workload, recording | Cacheable versionado.  |
| **CT-03**            | Temporalidad             | session refs/time semantics                 | No local schedule.     |
| **CT-04**            | Person                   | person_ref/assurance                        | No PII shadow.         |
| **CT-05**            | Documents/evidence       | document/content/evidence refs              | No blobs.              |
| **CT-06**            | Workflow                 | publish/change/waiver approvals             | SoD/evidence.          |
| **CT-07**            | Notifications            | invitations/changes                         | Post-commit.           |
| **CT-08**            | i18n                     | translation keys/locales                    | Overlays only.         |
| **CT-09**            | Integration governance   | events/contracts                            | Outbox/inbox.          |
| **CT-10**            | Security/audit/privacy   | purpose, consent, recording                 | Critical audit.        |
| **CT-11**            | Analytics                | teaching/content facts                      | Event-fed.             |
| **CT-12**            | AI                       | suggest instructor/content/plan             | Human approval.        |
| **CT-13**            | Scheduling               | availability/solution refs                  | No solver.             |
| **CT-14**            | Resources                | room/resource refs                          | No reservations local. |
| **CT-15**            | Eligibility/requirements | requirement decisions                       | No engine.             |
| **CT-16**            | Migration/DQ             | staging/promotion                           | No direct INSERT.      |
| **CT-17**            | Continuity               | runbooks/RTO/RPO                            | Read-only/degraded.    |
| **CT-18**            | LMS/external ecosystem   | provision/query/status/reconcile            | UNKNOWN_EFFECT aware.  |
| **IAM**              | Authentication/step-up   | actor/assurance                             | Step-up critical.      |
| **RRHH/Procurement** | Employment/engagement    | engagement_ref                              | No local contract/pay. |
| **EC-01**            | Program design           | ProgramVersion/ModuleVersion/outcomes       | Pin version.           |
| **EC-02**            | Edition/Session          | edition/offering/session refs               | Owner execution/time.  |
| **EC-06**            | Attendance               | Consumes assignments/session bindings       | No attendance local.   |
| **EC-07**            | Assessment               | Consumes content/outcome refs               | No score local.        |
| **EC-11**            | Feedback                 | Consumes assignment refs                    | No performance local.  |

# 6. Arquitectura funcional E2E y journeys

<img src="media/image1.png" style="width:7.35in;height:4.56935in" />

Figura 1 — EC-05 dentro de la vertical y capacidades CT

| **Journey**                          | **Flujo E2E**                                                                                                                                                               |
|--------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **J-EC05-01 Plan inicial**           | EC-02 Edition → create TeachingPlan → DRAFT revision → módulos/unidades/policies → teams/assignments → content bindings → validate → review CT-06 → publish receipt/outbox. |
| **J-EC05-02 Asignar experto**        | Resolver Person CT-04 → crear Assignment PLANNED → requirements → invite CT-07 → acceptance receipt → ACCEPTED → ACTIVE cuando inicia impartición.                          |
| **J-EC05-03 Reemplazo**              | Detectar indisponibilidad → TeachingChangeRequest → nuevo Assignment replacement_for old → requirements/acceptance → old REPLACED → eventos/audit; nunca update person_ref. |
| **J-EC05-04 Contenido reusable**     | Crear ContentPackage/V1 → items CT-05/18 → rights/release rules → publish receipt → TeachingPlan pinnea items/version → futuras versiones no alteran historia.              |
| **J-EC05-05 LMS**                    | Plan publicado → LmsProvisioningIntent + idempotency → CT-18 CREATE → timeout =\> UNKNOWN_EFFECT → query/reconcile → receipt → ExternalLearningSpaceBinding.                |
| **J-EC05-06 Sesión virtual**         | EC-02 crea session → EC-05 asocia team/unit/content + recording policy → CT-18 materializa meeting → EC-06 registra hechos reales.                                          |
| **J-EC05-07 Derechos caídos**        | Antes de publish/reuse, rights expirados → validation FAIL → no publicar ni exponer contenido; governance resuelve nueva licencia/evidence.                                 |
| **J-EC05-08 IA asistiva**            | Designer pide sugerencias CT-12 → recommendation con grounding/confidence → humano acepta/edita → command normal con ETag; IA no asigna ni publica.                         |
| **J-EC05-09 Dependencia caída**      | CT-18 unavailable durante query de estado → UI UNAVAILABLE/STALE según operación; si side effect pudo ocurrir =\> UNKNOWN_EFFECT, no “failed” simple.                       |
| **J-EC05-10 Bulk content/provision** | Import/mass provisioning devuelve 202+operationId → worker chunked → partial item results → reconcile → terminal SUCCEEDED/PARTIAL business report.                         |

# 7. Modelo de dominio: Aggregates, Entities, Value Objects, Policies y Domain Services

<img src="media/image2.png" style="width:7.15in;height:5.35841in" />

Figura 2 — Modelo de dominio lógico EC-05

## 7.1 Aggregate Root — TeachingPlan

## 7.2 Aggregate — TeachingPlanRevision

## 7.3 Aggregate — InstructorAssignment

## 7.4 Aggregate Root — LearningContentPackage

## 7.5 Aggregate — LmsProvisioningIntent

## 7.6 Value Objects

| **Value Object**      | **Semántica**                                                    |
|-----------------------|------------------------------------------------------------------|
| **TeachingRole**      | Código CT-02 + responsibility; no HR job title.                  |
| **AssignmentScope**   | PLAN/MODULE/SESSION XOR target.                                  |
| **PlannedWorkload**   | Horas decimales no negativas + policy version.                   |
| **PolicyRef**         | Referencia a PolicyVersion inmutable.                            |
| **ExternalRef**       | ID opaco + contract authority; sin FK cross-context.             |
| **ContentTarget**     | Exactly-one document_ref/external_resource_ref/lms_resource_ref. |
| **RightsWindow**      | valid_from/valid_to + license/use codes.                         |
| **ReleaseRule**       | Trigger + offset + prerequisite + visibility window.             |
| **ContentHash**       | Hash de snapshot canónico con schema version.                    |
| **OperationEffect**   | CONFIRMED/REJECTED/UNKNOWN_EFFECT/NOT_APPLIED.                   |
| **AggregateRevision** | bigint expuesto como ETag del aggregate.                         |

## 7.7 Domain Policies

- TeachingPlanPublicationPolicy — precondiciones de publish y readiness mínima.

- InstructorAssignmentPolicy — roles permitidos, SoD, requirements y aceptación.

- InstructorReplacementPolicy — cuándo requiere workflow/nueva revision/step-up.

- WorkloadPolicy — límites/alertas de carga sin duplicar nómina.

- ContentPublicationPolicy — completeness, rights, accessibility y provenance.

- ContentRightsPolicy — licencia/vigencia/uso permitido por purpose.

- ContentReleasePolicy — triggers/ventanas válidas.

- RecordingPolicy — consentimiento, retention y publication scope.

- LmsProvisioningPolicy — actions, provider compatibility y fail-safe.

- MaterialChangePolicy — qué modifica snapshot y qué es lifecycle operativo.

## 7.8 Domain Services

- TeachingPlanValidationService — valida módulos, units, teams readiness, contents, rights y policy refs.

- AssignmentReadinessService — evalúa requirements/acceptance freshness.

- InstructorReplacementService — crea replacement lineage y side effects sin overwrite.

- ContentSnapshotService — canonicaliza items/rights/release rules y calcula content hash.

- ContentRightsValidationService — detecta licencia expirada/incompatible.

- LmsProvisioningService — intent + CT-18 + receipt/reconciliation.

- ImpactSimulationService — identifica sessions/participants/spaces downstream afectados por cambios.

- ReconciliationService — resuelve UNKNOWN_EFFECT contra query/status externo.

## 7.9 Aggregate Revision Contract

TeachingPlanRevision y ContentPackageVersion usan aggregate revision para su snapshot de diseño. Todo child mutation de diseño adquiere lock del root, compara If-Match y bump de version en la misma transacción. Los estados operativos de InstructorAssignment, invitation, provisioning y external spaces tienen sus propias revisiones; no deben falsear el content_hash del snapshot publicado.

| **Paso** | **Contrato**                                                 |
|----------|--------------------------------------------------------------|
| **1**    | Resolver tenant desde SecurityContext; nunca body.           |
| **2**    | Abrir transacción y SET LOCAL peopleu.tenant_id.             |
| **3**    | Lock root y comparar If-Match.                               |
| **4**    | Ejecutar método de intención; no child repository directo.   |
| **5**    | Persistir child y bump root atómico cuando integra snapshot. |
| **6**    | Audit/outbox/idempotency según comando.                      |
| **7**    | Responder ETag nuevo; stale =\> 412 sin efectos.             |

| **PRUEBA NO NEGOCIABLE —** Dos diseñadores abren TeachingPlanRevision ETag 12. A agrega una InstructionalUnit y la revisión pasa a 13. B intenta cambiar un content binding con If-Match 12: debe recibir 412 aunque sean tablas distintas. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 7.10 Contrato snapshot vs operación

| **Elemento**                              | **¿Integra hash del TeachingPlanRevision?** | **¿Puede evolucionar después de publish?**   | **Regla**                                                  |
|-------------------------------------------|---------------------------------------------|----------------------------------------------|------------------------------------------------------------|
| **TeachingPlanModule**                    | Sí                                          | No                                           | Nueva revision para cambio material.                       |
| **InstructionalUnitPlan**                 | Sí                                          | No                                           | Nueva revision.                                            |
| **TeachingContentBinding**                | Sí                                          | No                                           | Nueva revision.                                            |
| **RecordingPolicyBinding**                | Sí                                          | No                                           | Nueva revision salvo emergency override gobernado externo. |
| **TeachingTeam structure**                | Sí conceptualmente                          | Solo state operativo                         | Scope/team code no cambia tras publish.                    |
| **InstructorAssignment identity/role**    | Readiness snapshot/ref                      | Sí por lifecycle; replacement crea nuevo row | Nunca overwrite person/role aceptado.                      |
| **Requirement results**                   | No; receipts operativos                     | Sí append-only                               | Freshness reevaluable.                                     |
| **LMS provisioning/external space state** | No                                          | Sí                                           | Remote effect separado del publish local.                  |

# 8. Máquinas de estado normativas

<img src="media/image3.png" style="width:7.35in;height:4.21696in" />

Figura 3 — Lifecycles normativos de snapshots y assignments

| **Aggregate**             | **Estados/transiciones**                                                      | **Invariante**                                |
|---------------------------|-------------------------------------------------------------------------------|-----------------------------------------------|
| **TeachingPlan**          | DRAFT→ACTIVE↔SUSPENDED→RETIRED                                                | No borra revisions.                           |
| **TeachingPlanRevision**  | DRAFT→IN_REVIEW→APPROVED→SCHEDULED/PUBLISHED→SUPERSEDED; VOID excepcional     | Diseño immutable desde SCHEDULED.             |
| **InstructorAssignment**  | PLANNED→INVITED/ACCEPTED→ACTIVE→COMPLETED; REPLACED/CANCELLED/VOID terminales | Person/role accepted no overwrite.            |
| **AssignmentInvitation**  | ISSUED→OPENED→ACCEPTED/DECLINED/EXPIRED/REVOKED                               | One-shot + expiry.                            |
| **ContentPackage**        | DRAFT→ACTIVE↔SUSPENDED→RETIRED                                                | No borra versions.                            |
| **ContentPackageVersion** | DRAFT→IN_REVIEW→APPROVED→SCHEDULED/PUBLISHED→SUPERSEDED; VOID                 | Items/rights/releases frozen desde SCHEDULED. |
| **ExternalLearningSpace** | PROVISIONED→ACTIVE↔SUSPENDED→ARCHIVED; UNKNOWN_EFFECT observable              | Remote truth reconciled.                      |
| **LmsProvisioningIntent** | PENDING→SENT→CONFIRMED/FAILED/UNKNOWN_EFFECT/CANCELLED                        | UNKNOWN_EFFECT no retry ciego.                |

| **REGLA DE ESTADO —** Nunca implementar publish, replace instructor, accept assignment o provision LMS como PATCH genérico. Son commands transaccionales con autorización, revision/idempotency, evidence y side effects explícitos. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 8.1 TeachingPlanRevision — state machine física

| **Desde**      | **Hacia permitidos**                 | **Semántica**                                   |
|----------------|--------------------------------------|-------------------------------------------------|
| **DRAFT**      | IN_REVIEW · VOID                     | Único estado donde se modifica snapshot design. |
| **IN_REVIEW**  | DRAFT · APPROVED · VOID              | Editar obliga volver a DRAFT.                   |
| **APPROVED**   | DRAFT · SCHEDULED · PUBLISHED · VOID | Puede comprometer vigencia futura.              |
| **SCHEDULED**  | PUBLISHED · VOID                     | Snapshot futuro inmutable.                      |
| **PUBLISHED**  | SUPERSEDED · VOID                    | Vigente; diseño inmutable.                      |
| **SUPERSEDED** | —                                    | Terminal histórico.                             |
| **VOID**       | —                                    | Terminal excepcional; no hard delete.           |

## 8.2 InstructorAssignment — state machine física

| **Desde**                   | **Hacia permitidos**                    | **Semántica**                              |
|-----------------------------|-----------------------------------------|--------------------------------------------|
| **PLANNED**                 | INVITED · ACCEPTED · CANCELLED · VOID   | Se pueden completar requisitos/acceptance. |
| **INVITED**                 | ACCEPTED · CANCELLED · VOID             | Invitation activa.                         |
| **ACCEPTED**                | ACTIVE · REPLACED · CANCELLED · VOID    | Identidad/rol quedan frozen.               |
| **ACTIVE**                  | COMPLETED · REPLACED · CANCELLED · VOID | Asignación en ejecución.                   |
| **COMPLETED**               | —                                       | Terminal histórica.                        |
| **REPLACED/CANCELLED/VOID** | —                                       | Terminal; nuevo assignment si corresponde. |

# 9. Catálogo formal de reglas BR-EC05

| **ID**          | **Nombre**                           | **Regla implementable/verificable**                                                                                     |
|-----------------|--------------------------------------|-------------------------------------------------------------------------------------------------------------------------|
| **BR-EC05-001** | Tenant obligatorio                   | Toda fila EC-05 usa tenant_id del contexto autorizado; body no puede elegir tenant.                                     |
| **BR-EC05-002** | RLS obligatorio                      | Todas las tablas tenant-owned usan ENABLE+FORCE RLS; runtime no es owner ni BYPASSRLS.                                  |
| **BR-EC05-003** | Person externa                       | InstructorAssignment usa person_ref CT-04; no copia PII como Source of Truth.                                           |
| **BR-EC05-004** | Employment externo                   | engagement_ref es referencia RRHH/Procurement; EC-05 no crea contrato ni nómina.                                        |
| **BR-EC05-005** | Schedule externo                     | session_ref es EXT REF EC-02/CT-03; EC-05 no crea fecha/hora oficial.                                                   |
| **BR-EC05-006** | Program pin                          | TeachingPlan pinnea ProgramVersion EC-01 compatible con edition_ref EC-02.                                              |
| **BR-EC05-007** | Edition única                        | Solo un TeachingPlan identidad por edition/tenant salvo ADR de branching explícito.                                     |
| **BR-EC05-008** | Plan code estable                    | plan_code no se reutiliza ni cambia después de historia publicada.                                                      |
| **BR-EC05-009** | Policy versionada                    | Todo \*\_policy_ref resuelve PolicyVersion inmutable, no policy mutable latest.                                         |
| **BR-EC05-010** | No cross-context FK                  | Refs CT/IAM/RRHH/EC externos no generan FK física.                                                                      |
| **BR-EC05-011** | Revision positiva                    | revision_no \> 0 y única por TeachingPlan.                                                                              |
| **BR-EC05-012** | Lineage same plan                    | previous/superseded revision pertenece al mismo TeachingPlan.                                                           |
| **BR-EC05-013** | Lineage monotónico                   | previous.revision_no \< current \< superseding; self-reference prohibida.                                               |
| **BR-EC05-014** | Una PUBLISHED                        | Solo una TeachingPlanRevision PUBLISHED por TeachingPlan.                                                               |
| **BR-EC05-015** | SCHEDULED inmutable                  | SCHEDULED compromete snapshot futuro; no permite editar diseño.                                                         |
| **BR-EC05-016** | Published inmutable                  | PUBLISHED/SUPERSEDED no mutan módulos/unidades/content bindings/policies.                                               |
| **BR-EC05-017** | Publish no PATCH                     | Publish es use case con validation, approval, hash, receipt, outbox y step-up.                                          |
| **BR-EC05-018** | Publish readiness                    | Policy define mínimo de equipos/assignments/content/rights requeridos; no hardcode.                                     |
| **BR-EC05-019** | Fail closed publish                  | Dependencia crítica UNKNOWN/UNAVAILABLE bloquea publish; no se interpreta favorable.                                    |
| **BR-EC05-020** | Content hash canónico                | Snapshot publicado conserva content_hash + canonical schema version.                                                    |
| **BR-EC05-021** | Aggregate revision                   | Mutación child de diseño incrementa TeachingPlanRevision.version atómicamente.                                          |
| **BR-EC05-022** | Stale ETag                           | If-Match obsoleto produce 412 sin aplicar efectos.                                                                      |
| **BR-EC05-023** | No last-write-wins                   | Conflictos nunca se resuelven silenciosamente.                                                                          |
| **BR-EC05-024** | Module pin                           | TeachingPlanModule referencia ModuleVersion/structure item concretos, nunca latest.                                     |
| **BR-EC05-025** | Module scope unique                  | No duplica el mismo ProgramStructureItem dentro de una revision.                                                        |
| **BR-EC05-026** | Horas válidas                        | planned_contact_hours/planned_async_hours son \>=0 y suma \>0.                                                          |
| **BR-EC05-027** | Unit scope XOR                       | InstructionalUnitPlan es MODULE o SESSION, exactamente uno.                                                             |
| **BR-EC05-028** | Unit duration                        | planned_minutes \> 0.                                                                                                   |
| **BR-EC05-029** | Team scope XOR                       | TeachingTeam es PLAN/MODULE/SESSION con target exactamente compatible.                                                  |
| **BR-EC05-030** | Team code unique                     | team_code único dentro de TeachingPlanRevision.                                                                         |
| **BR-EC05-031** | Team structure frozen                | Después de publish no cambia scope/team code/coordinator role; state sí puede progresar.                                |
| **BR-EC05-032** | Assignment scope XOR                 | InstructorAssignment PLAN/MODULE/SESSION tiene exactamente target compatible.                                           |
| **BR-EC05-033** | Role parametrizado                   | role_code/responsibility_code vienen CT-02; no enum hardcodeado en Java/React.                                          |
| **BR-EC05-034** | Role no employment                   | role_code no infiere employment type, pago u honorarios.                                                                |
| **BR-EC05-035** | Assignment hours                     | planned_hours \>= 0 y thresholds vienen workload policy.                                                                |
| **BR-EC05-036** | Assignment unique active             | No existe duplicado activo persona+rol+scope dentro de revision.                                                        |
| **BR-EC05-037** | Assignment acceptance                | Si acceptance_required, ACCEPTED/ACTIVE exige AcceptanceReceipt.                                                        |
| **BR-EC05-038** | Identity frozen                      | Desde ACCEPTED no se cambia person_ref/role/scope; replacement crea nuevo row.                                          |
| **BR-EC05-039** | Replacement lineage                  | replacement_for no apunta a sí mismo y debe ser de la misma revision.                                                   |
| **BR-EC05-040** | Replacement no overwrite             | Reemplazar docente marca anterior REPLACED y crea nuevo assignment.                                                     |
| **BR-EC05-041** | Replacement reason                   | REPLACED/CANCELLED/VOID requiere reason_code según policy.                                                              |
| **BR-EC05-042** | Requirements mandatory               | Assignment no activa si mandatory requirement no tiene PASS/WAIVED vigente.                                             |
| **BR-EC05-043** | Requirement result append-only       | Cada reevaluación crea nuevo AssignmentRequirementResult.                                                               |
| **BR-EC05-044** | UNKNOWN requirement not pass         | UNKNOWN/REVIEW_REQUIRED no equivale PASS.                                                                               |
| **BR-EC05-045** | Waiver gobernado                     | WAIVED requiere reason/workflow/evidence cuando policy lo exige.                                                        |
| **BR-EC05-046** | Requirement expiry                   | Resultado expirado no satisface activation/publish readiness.                                                           |
| **BR-EC05-047** | Invitation secret                    | Solo token_hash+last4; plaintext no DB/log/trace.                                                                       |
| **BR-EC05-048** | Invitation expiry                    | Expired/revoked invitation no puede aceptarse.                                                                          |
| **BR-EC05-049** | Invitation one active                | Máximo una invitación ISSUED/OPENED por assignment.                                                                     |
| **BR-EC05-050** | Acceptance append-only               | AcceptanceReceipt no admite UPDATE/DELETE.                                                                              |
| **BR-EC05-051** | Acceptance terms pin                 | Receipt conserva terms_policy_ref + terms_hash + assurance.                                                             |
| **BR-EC05-052** | Acceptance no contract               | Receipt de assignment no crea relación laboral/comercial.                                                               |
| **BR-EC05-053** | Content package code                 | package_code unique tenant-aware y estable tras historia publicada.                                                     |
| **BR-EC05-054** | Content version positive             | version_no \>0 y única por package.                                                                                     |
| **BR-EC05-055** | Content lineage                      | previous/superseded same package y monotónico.                                                                          |
| **BR-EC05-056** | Una content PUBLISHED                | Solo una ContentPackageVersion PUBLISHED por package.                                                                   |
| **BR-EC05-057** | Content frozen                       | SCHEDULED/PUBLISHED/SUPERSEDED bloquean items/rights/release mutations.                                                 |
| **BR-EC05-058** | Content aggregate revision           | Item/rights/release change en DRAFT bump ContentPackageVersion.version.                                                 |
| **BR-EC05-059** | Content target XOR                   | Cada item tiene exactamente uno: document_ref/external_resource_ref/lms_resource_ref.                                   |
| **BR-EC05-060** | No blobs                             | CT-05 conserva archivo; EC-05 solo refs/hash/business metadata.                                                         |
| **BR-EC05-061** | Content item code                    | item_code unique dentro de ContentPackageVersion.                                                                       |
| **BR-EC05-062** | Content order                        | sequence_no \>0 y unique dentro version.                                                                                |
| **BR-EC05-063** | Content pin                          | TeachingContentBinding apunta item concreto, no latest package.                                                         |
| **BR-EC05-064** | Rights required                      | Publish valida rights vigentes para todos los items según content policy.                                               |
| **BR-EC05-065** | Rights != availability               | Existencia técnica del recurso no satisface licencia/uso permitido.                                                     |
| **BR-EC05-066** | Rights window                        | valid_to \>= valid_from cuando ambos existen.                                                                           |
| **BR-EC05-067** | Release rule versionada              | release trigger/offset/prerequisite/visibility pertenecen al snapshot.                                                  |
| **BR-EC05-068** | Release not scheduler                | ContentReleaseRule no agenda jobs oficiales; CT-18/CT-13 materializan según contrato.                                   |
| **BR-EC05-069** | Teaching content scope XOR           | Binding PLAN/MODULE/SESSION/UNIT tiene exactamente un target de scope.                                                  |
| **BR-EC05-070** | Binding order                        | sequence_no \>0; orden reproducible por scope.                                                                          |
| **BR-EC05-071** | Accessibility profile                | Content publish valida accessibility profile cuando policy lo exige.                                                    |
| **BR-EC05-072** | Localization no new academic version | Traducciones/overlays CT-08 no duplican package version salvo cambio material de contenido.                             |
| **BR-EC05-073** | Recording policy pin                 | RecordingPolicyBinding conserva policy/consent/retention refs versionadas.                                              |
| **BR-EC05-074** | Recording no implicit consent        | recording_required no implica consentimiento individual favorable.                                                      |
| **BR-EC05-075** | Recording blob CT-05                 | Archivo final de grabación no se guarda en PostgreSQL EC-05.                                                            |
| **BR-EC05-076** | External space ref opaque            | external_space_ref no contiene credencial/secreto ni URL sensible.                                                      |
| **BR-EC05-077** | No direct SDK                        | Toda integración LMS/meeting pasa por CT-18 adapter contract.                                                           |
| **BR-EC05-078** | Provision intent idempotent          | CREATE/UPDATE/SYNC/SUSPEND/ARCHIVE usa Idempotency-Key durable.                                                         |
| **BR-EC05-079** | 202 requires operation               | Toda respuesta 202 incluye operationId consultable.                                                                     |
| **BR-EC05-080** | Timeout != failure                   | Timeout después de side effect potencial produce UNKNOWN_EFFECT.                                                        |
| **BR-EC05-081** | Reconcile before retry               | UNKNOWN_EFFECT consulta remote_operation_ref/status antes de resend.                                                    |
| **BR-EC05-082** | Provision receipt append-only        | Cada observación remota crea receipt inmutable.                                                                         |
| **BR-EC05-083** | External space state explicit        | PROVISIONED/ACTIVE/SUSPENDED/ARCHIVED/UNKNOWN_EFFECT no se colapsan.                                                    |
| **BR-EC05-084** | Outbox atomic                        | Publish/assignment critical commands persisten business fact + outbox en una transacción.                               |
| **BR-EC05-085** | Inbox dedup                          | Consumidores deduplican message_id y validan same-id/same-hash.                                                         |
| **BR-EC05-086** | At least once                        | No se promete exactly-once distribuido; idempotency+reconciliation hacen correctness.                                   |
| **BR-EC05-087** | Outbox lease                         | IN_FLIGHT posee owner/lease y reclaim después de expiry.                                                                |
| **BR-EC05-088** | SKIP LOCKED                          | Claim multi-instancia usa FOR UPDATE SKIP LOCKED o patrón equivalente probado.                                          |
| **BR-EC05-089** | Idempotency lease                    | IN_PROGRESS posee owner/lease/recovery; no queda bloqueado para siempre.                                                |
| **BR-EC05-090** | Same key conflict                    | Same Idempotency-Key con payload distinto retorna 409 IDEMPOTENCY_KEY_REUSED.                                           |
| **BR-EC05-091** | UI states                            | NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT son estados distintos.                                            |
| **BR-EC05-092** | Audit crítico                        | Create/review/publish/assign/accept/replace/provision/archive registran actor/scope/reason/correlation/policy/evidence. |
| **BR-EC05-093** | Step-up                              | Publish, VOID, high-risk replacement/rights override/provision destructive action exigen assurance según policy.        |
| **BR-EC05-094** | SoD                                  | Actor de diseño no puede ser único aprobador cuando policy exige separación.                                            |
| **BR-EC05-095** | PII minimization                     | Workspace docente no expone PII de participantes salvo purpose y scope autorizados.                                     |
| **BR-EC05-096** | Purpose limitation                   | Export/lookup de Person/assignment requiere purpose_code y audit cuando aplique.                                        |
| **BR-EC05-097** | Migration governed                   | Legacy entra CT-16 Extract→Normalize→Map→Validate→Dry-run→Promote→Receipt→Reconcile.                                    |
| **BR-EC05-098** | Time UTC                             | Instantes oficiales timestamptz UTC; timezone solo presentación.                                                        |
| **BR-EC05-099** | No hard delete                       | Published snapshots/receipts/results/accepted assignments no se borran por API ordinaria.                               |
| **BR-EC05-100** | AI provenance                        | AI suggestion guarda run/model/template/eval/grounding/confidence/reviewer outcome.                                     |
| **BR-EC05-101** | AI no assign                         | IA no crea/acepta/reemplaza assignment ni publica contenido/plan.                                                       |
| **BR-EC05-102** | OpenAPI client                       | Frontend usa cliente/DTO generado; contratos manuales paralelos prohibidos.                                             |
| **BR-EC05-103** | Pagination bounded                   | Collections definen pageSize máximo, sorting estable, filtros y cursor/offset contractual.                              |
| **BR-EC05-104** | PATCH limitado                       | PATCH solo metadata escalar autorizada; state/domain commands son endpoints de intención.                               |
| **BR-EC05-105** | Secure SDLC gate                     | High/Critical findings bloquean release salvo excepción formal con expiry.                                              |
| **BR-EC05-106** | Expand contract                      | Migraciones productivas son N/N-1 compatibles y no destructivas en un único release.                                    |
| **BR-EC05-107** | Capacity budgets                     | Payloads, pageSize, bulk assignments/content y graph sizes tienen límites parametrizados.                               |
| **BR-EC05-108** | Reconstructibility                   | Años después se reconstruye quién estaba asignado, qué contenido/policies se publicaron y qué remote effect ocurrió.    |

# 10. Casos de uso UC-EC05

| **ID**          | **Caso de uso**                               | **Actor primario**          |
|-----------------|-----------------------------------------------|-----------------------------|
| **UC-EC05-001** | Crear TeachingPlan                            | Academic Coordinator        |
| **UC-EC05-002** | Modificar metadata de TeachingPlan editable   | Academic Coordinator        |
| **UC-EC05-003** | Activar/Suspender/Retirar TeachingPlan        | Academic Governance         |
| **UC-EC05-004** | Crear TeachingPlanRevision inicial            | Instructional Designer      |
| **UC-EC05-005** | Clonar revision publicada                     | Instructional Designer      |
| **UC-EC05-006** | Gestionar TeachingPlanModules                 | Instructional Designer      |
| **UC-EC05-007** | Gestionar InstructionalUnitPlans              | Instructional Designer      |
| **UC-EC05-008** | Validar TeachingPlanRevision                  | Designer/Reviewer           |
| **UC-EC05-009** | Solicitar revisión                            | Instructional Designer      |
| **UC-EC05-010** | Aprobar/Rechazar revisión                     | Academic Approver           |
| **UC-EC05-011** | Programar revision futura SCHEDULED           | Academic Publisher          |
| **UC-EC05-012** | Publicar TeachingPlanRevision                 | Academic Publisher          |
| **UC-EC05-013** | Superseder/Void revision                      | Academic Governance         |
| **UC-EC05-014** | Crear TeachingTeam                            | Academic Coordinator        |
| **UC-EC05-015** | Modificar estructura de TeachingTeam          | Academic Coordinator        |
| **UC-EC05-016** | Crear InstructorAssignment                    | Academic Coordinator        |
| **UC-EC05-017** | Consultar Person/engagement refs              | Academic Coordinator        |
| **UC-EC05-018** | Agregar requirements a assignment             | Academic Coordinator        |
| **UC-EC05-019** | Evaluar/revalidar requirement                 | Authorized Evaluator/System |
| **UC-EC05-020** | Emitir invitación de assignment               | Academic Coordinator        |
| **UC-EC05-021** | Abrir invitación                              | Instructor                  |
| **UC-EC05-022** | Aceptar assignment                            | Instructor                  |
| **UC-EC05-023** | Rechazar assignment                           | Instructor                  |
| **UC-EC05-024** | Activar assignment                            | Academic Coordinator        |
| **UC-EC05-025** | Completar assignment                          | Academic Coordinator        |
| **UC-EC05-026** | Crear TeachingChangeRequest                   | Academic Coordinator        |
| **UC-EC05-027** | Aprobar cambio/reemplazo                      | Academic Approver           |
| **UC-EC05-028** | Reemplazar instructor                         | Academic Coordinator        |
| **UC-EC05-029** | Cancelar/Void assignment                      | Academic Governance         |
| **UC-EC05-030** | Crear LearningContentPackage                  | Content Designer            |
| **UC-EC05-031** | Crear ContentPackageVersion                   | Content Designer            |
| **UC-EC05-032** | Gestionar ContentItems                        | Content Designer            |
| **UC-EC05-033** | Gestionar rights bindings                     | Content Governance          |
| **UC-EC05-034** | Gestionar release rules                       | Content Designer            |
| **UC-EC05-035** | Validar ContentPackageVersion                 | Content Reviewer            |
| **UC-EC05-036** | Solicitar revisión de contenido               | Content Designer            |
| **UC-EC05-037** | Publicar ContentPackageVersion                | Content Publisher           |
| **UC-EC05-038** | Superseder/Void content version               | Content Governance          |
| **UC-EC05-039** | Vincular contenido al TeachingPlan            | Instructional Designer      |
| **UC-EC05-040** | Gestionar RecordingPolicyBinding              | Academic/Privacy Governance |
| **UC-EC05-041** | Solicitar provisioning de LMS                 | Academic Operations         |
| **UC-EC05-042** | Consultar OperationStatus                     | Frontend/Ops                |
| **UC-EC05-043** | Reconciliar provisioning UNKNOWN_EFFECT       | Ops/System                  |
| **UC-EC05-044** | Crear/actualizar ExternalLearningSpaceBinding | Ops/System                  |
| **UC-EC05-045** | Suspender/archivar espacio externo            | Ops                         |
| **UC-EC05-046** | Sincronizar contenido con LMS                 | Ops/System                  |
| **UC-EC05-047** | Simular impacto de cambio docente/contenido   | Reviewer                    |
| **UC-EC05-048** | Comparar TeachingPlan revisions               | Reviewer                    |
| **UC-EC05-049** | Comparar ContentPackage versions              | Content Reviewer            |
| **UC-EC05-050** | Solicitar asistencia IA para plan             | Instructional Designer      |
| **UC-EC05-051** | Aceptar/Rechazar sugerencia IA                | Instructional Designer      |
| **UC-EC05-052** | Sugerir instructor con IA                     | Academic Coordinator        |
| **UC-EC05-053** | Importar docentes/assignments legacy dry-run  | Data Steward                |
| **UC-EC05-054** | Importar contenidos legacy dry-run            | Data Steward                |
| **UC-EC05-055** | Promover lote migrado                         | Data Steward                |
| **UC-EC05-056** | Reconciliar outbox/inbox                      | Ops                         |
| **UC-EC05-057** | Reprocesar idempotency lease vencido          | Application Service         |
| **UC-EC05-058** | Claim/reclaim outbox lease                    | Outbox Worker               |
| **UC-EC05-059** | Consultar Evidence Pack                       | Auditor                     |
| **UC-EC05-060** | Exportar Teaching Delivery Pack               | Auditor/Staff               |
| **UC-EC05-061** | Consultar lineage de assignment               | Auditor                     |
| **UC-EC05-062** | Consultar rights vigentes                     | Content Governance          |
| **UC-EC05-063** | Validar aislamiento RLS                       | Security/QA                 |
| **UC-EC05-064** | Provisionar sesiones masivas                  | Ops                         |
| **UC-EC05-065** | Gestionar instructor mobile deep-link         | Instructor                  |
| **UC-EC05-066** | Consultar agenda docente                      | Instructor                  |
| **UC-EC05-067** | Consultar materiales asignados                | Instructor                  |
| **UC-EC05-068** | Reportar incidencia de acceso LMS             | Instructor/Ops              |
| **UC-EC05-069** | Cerrar operación asíncrona reconciliada       | Ops                         |

## 10.1 Casos críticos desarrollados

### UC-EC05-012 — Publicar TeachingPlanRevision

| **Aspecto**                       | **Detalle**                                                                                                                                   |
|-----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Academic Publisher                                                                                                                            |
| **Trigger**                       | Plan aprobado listo para uso                                                                                                                  |
| **Precondiciones / autorización** | APPROVED; If-Match; step-up; CT refs resolubles; validation PASS; readiness policy satisfecha                                                 |
| **Happy Path**                    | Lock root → revalidar hash/policies → supersede PUBLISHED anterior si aplica → set PUBLISHED → publication receipt + audit + outbox → commit. |
| **Alternativas / errores**        | CT critical unavailable =\> 503; rights/assignment readiness fail =\> 422; concurrent publish =\> 409/412.                                    |
| **Idempotencia**                  | Idempotency-Key durable; replay retorna mismo receipt.                                                                                        |
| **Concurrencia**                  | If-Match + unique one-published + root lock.                                                                                                  |
| **Auditoría / side effects**      | Policy snapshot, assurance, evidence pack, TeachingPlanPublished.v1.                                                                          |
| **Postcondición**                 | Snapshot inmutable y consumible downstream.                                                                                                   |

### UC-EC05-016 — Crear InstructorAssignment

| **Aspecto**                       | **Detalle**                                                                                                |
|-----------------------------------|------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Academic Coordinator                                                                                       |
| **Trigger**                       | Se requiere rol docente                                                                                    |
| **Precondiciones / autorización** | TeachingPlanRevision accesible; Person resoluble CT-04; role/policy válidos.                               |
| **Happy Path**                    | Crear PLANNED con person_ref/role/scope/hours → generar requirements desde policy → audit/outbox opcional. |
| **Alternativas / errores**        | Duplicate active role/scope =\>409; person unavailable=\>503/STALE según policy; scope mismatch=\>422.     |
| **Idempotencia**                  | Key requerida para bulk/integration; recomendable siempre.                                                 |
| **Concurrencia**                  | Unique active assignment + @Version.                                                                       |
| **Auditoría / side effects**      | Actor/scope/person_ref minimizado; no PII copy.                                                            |
| **Postcondición**                 | Assignment PLANNED, no empleo ni schedule.                                                                 |

### UC-EC05-022 — Aceptar assignment

| **Aspecto**                       | **Detalle**                                                                                                                                     |
|-----------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Instructor                                                                                                                                      |
| **Trigger**                       | Deep link/portal de invitation                                                                                                                  |
| **Precondiciones / autorización** | Invitation ISSUED/OPENED no expirada; identity assurance suficiente; requirements/policy según etapa.                                           |
| **Happy Path**                    | Verificar token hash + actor/person → crear AcceptanceReceipt append-only → invitation ACCEPTED → assignment ACCEPTED en transacción gobernada. |
| **Alternativas / errores**        | Expired/revoked token=\>410/422; replay same token=\>retorna receipt; different actor=\>403.                                                    |
| **Idempotencia**                  | Token/use + Idempotency-Key; one receipt/assignment.                                                                                            |
| **Concurrencia**                  | Lock invitation+assignment; second accept no duplica.                                                                                           |
| **Auditoría / side effects**      | terms hash/policy ref/assurance/evidence.                                                                                                       |
| **Postcondición**                 | Assignment ACCEPTED; no contrato laboral creado.                                                                                                |

### UC-EC05-028 — Reemplazar instructor

| **Aspecto**                       | **Detalle**                                                                                                                                            |
|-----------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Academic Coordinator + Approver según policy                                                                                                           |
| **Trigger**                       | Indisponibilidad/cambio autorizado                                                                                                                     |
| **Precondiciones / autorización** | Old ACCEPTED/ACTIVE; change request/workflow cuando aplica; new Person elegible.                                                                       |
| **Happy Path**                    | Crear new Assignment con replacement_for old → requirements/acceptance → transacción marca old REPLACED cuando new ready → outbox/audit/notifications. |
| **Alternativas / errores**        | New requirements fail=\>old permanece; session impact PARTIAL si CT-03/13 unavailable; no overwrite.                                                   |
| **Idempotencia**                  | Replace command key durable.                                                                                                                           |
| **Concurrencia**                  | Lock old + unique active scope/person/role.                                                                                                            |
| **Auditoría / side effects**      | Reason/evidence/approval + lineage.                                                                                                                    |
| **Postcondición**                 | Historia conserva ambos assignments.                                                                                                                   |

### UC-EC05-037 — Publicar ContentPackageVersion

| **Aspecto**                       | **Detalle**                                                                                                            |
|-----------------------------------|------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Content Publisher                                                                                                      |
| **Trigger**                       | Contenido aprobado                                                                                                     |
| **Precondiciones / autorización** | APPROVED; all items targets resolubles; rights/accessibility/policies PASS; step-up según risk.                        |
| **Happy Path**                    | Lock root → canonicalize items+rights+release rules → content_hash → supersede prior → set PUBLISHED → receipt+outbox. |
| **Alternativas / errores**        | Right expired/missing=\>422; CT-05/18 unavailable critical=\>503; concurrent publish=\>409/412.                        |
| **Idempotencia**                  | Idempotency-Key.                                                                                                       |
| **Concurrencia**                  | If-Match + single PUBLISHED.                                                                                           |
| **Auditoría / side effects**      | ContentPublished event, policy snapshot.                                                                               |
| **Postcondición**                 | Version pinneable por plans.                                                                                           |

### UC-EC05-041 — Solicitar provisioning de LMS

| **Aspecto**                       | **Detalle**                                                                                                                      |
|-----------------------------------|----------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Academic Operations                                                                                                              |
| **Trigger**                       | Plan/scope necesita espacio externo                                                                                              |
| **Precondiciones / autorización** | TeachingPlanRevision published/scheduled según policy; CT-18 provider supported; access/privacy refs válidas.                    |
| **Happy Path**                    | Crear LmsProvisioningIntent + OperationStatus/idempotency → enviar vía CT-18 → CONFIRMED receipt → ExternalLearningSpaceBinding. |
| **Alternativas / errores**        | Timeout después de send=\>UNKNOWN_EFFECT; antes de send demostrable=\>FAILED_RECOVERABLE; provider reject=\>422/receipt.         |
| **Idempotencia**                  | Key local/remota durable.                                                                                                        |
| **Concurrencia**                  | Unique idempotency + one active create per scope/provider según policy.                                                          |
| **Auditoría / side effects**      | Request/response hashes, remote_operation_ref, correlation.                                                                      |
| **Postcondición**                 | CONFIRMED o UNKNOWN_EFFECT reconciliable; nunca course duplicado por retry ciego.                                                |

### UC-EC05-043 — Reconciliar provisioning UNKNOWN_EFFECT

| **Aspecto**                       | **Detalle**                                                                                                                                                                |
|-----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Ops/System                                                                                                                                                                 |
| **Trigger**                       | Intent/receipt UNKNOWN_EFFECT                                                                                                                                              |
| **Precondiciones / autorización** | remote_operation_ref/idempotency/correlation disponibles.                                                                                                                  |
| **Happy Path**                    | Query status CT-18 → si aplicado, crear CONFIRMED receipt/binding; si no aplicado, marcar NOT_APPLIED y recién habilitar retry; si indeterminado, mantener UNKNOWN_EFFECT. |
| **Alternativas / errores**        | Query unavailable=\>permanece UNKNOWN_EFFECT y alert; no resend.                                                                                                           |
| **Idempotencia**                  | Reconciliation idempotente.                                                                                                                                                |
| **Concurrencia**                  | Lease/ownership de operation.                                                                                                                                              |
| **Auditoría / side effects**      | Ops audit + metrics age unknown.                                                                                                                                           |
| **Postcondición**                 | Conocimiento coherente o escalado.                                                                                                                                         |

### UC-EC05-050 — Solicitar asistencia IA para plan

| **Aspecto**                       | **Detalle**                                                                                                    |
|-----------------------------------|----------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Instructional Designer                                                                                         |
| **Trigger**                       | Necesita sugerencia de estructura/metodología/contenido                                                        |
| **Precondiciones / autorización** | DRAFT; purpose permitido; grounding minimizado.                                                                |
| **Happy Path**                    | CT-12 recibe refs/snapshot permitido → retorna recommendation con provenance → UI muestra como draft separado. |
| **Alternativas / errores**        | CT-12 unavailable=\>edición manual continúa; confidence bajo=\>warning.                                        |
| **Idempotencia**                  | Run request key opcional/durable según CT-12.                                                                  |
| **Concurrencia**                  | No lock hasta apply.                                                                                           |
| **Auditoría / side effects**      | ai_run/model/template/eval/grounding refs.                                                                     |
| **Postcondición**                 | Suggestion pending human action; no state change.                                                              |

# 11. DER conceptual, lógico y físico

## 11.1 DER conceptual

El modelo conceptual se organiza alrededor de tres líneas: TeachingPlan/Revision para diseño de impartición; TeachingTeam/InstructorAssignment para operación docente e historia; LearningContentPackage/Version para contenido reusable. CT-18 side effects se modelan como intents/receipts y spaces; outbox/idempotency soportan consistencia distribuida.

## 11.2 DER lógico

Las relaciones internas EC-05 son tenant-aware. TeachingPlanRevision pertenece a TeachingPlan; TeachingPlanModule, InstructionalUnitPlan y bindings pertenecen a una revision. TeachingTeam/InstructorAssignment están anchored a revision y scopes locales. ContentPackageVersion pertenece a ContentPackage e items/rights/release rules quedan pinneados. FKs cross-context están prohibidas.

## 11.3 DER físico resumido

<img src="media/image4.png" style="width:7.25in;height:5.7859in" />

Figura 4 — DER físico resumido EC-05

| **REGLA DE FK —** Todas las FKs físicas del esquema ec05 son internas, tenant-aware y scope-aware cuando existe parent revision/version. CT-01…18, IAM, RRHH/Procurement y otros EC se consumen mediante EXT REF y contracts. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 12. Modelo físico PostgreSQL tabla por tabla

El esquema propuesto es ec05. PostgreSQL es Source of Truth transaccional de TeachingPlan/Revision, TeachingTeam/InstructorAssignment, LearningContentPackage/Version y de los receipts/intents operativos EC-05. Toda tabla tenant-owned usa tenant_id, RLS ENABLE + FORCE y PK/FK internas tenant-aware. CT, IAM, RRHH/Procurement y otros EC se referencian como EXT REF sin FK física. El diseño distingue snapshots inmutables de estados operativos que necesariamente evolucionan después de publicar.

| **PREGUNTA OBLIGATORIA —** Para cada tabla se documenta qué error debe impedir PostgreSQL aunque Backend tenga un bug. La base debe bloquear cruces de tenant/scope, lineage inválido, estados imposibles, mutación de snapshots, targets ambiguos, receipts reescritos y duplicación de efectos remotos. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.1 ec05_teaching_plan

**QUÉ REPRESENTA —** Identidad estable del plan de impartición de una ProgramEdition. Une la versión académica EC-01 con la ejecución EC-02 sin duplicar calendario, recursos, personas ni contratos laborales.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root creado cuando una edición requiere preparación docente. Sus TeachingPlanRevision publicadas son consumidas por operación docente, EC-06/07 y adaptadores CT-18. La edición y program version quedan pinneadas mediante EXT REF.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege identidad, business key, ownership y lifecycle del plan. No representa ProgramDefinition, ProgramEdition, contrato laboral, horario ni LMS course.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                      | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| teaching_plan_id         | uuid                | NO       | gen_random_uuid() | PK            | ID técnico estable del plan.                                                         | tp…               |
| plan_code                | varchar(64)         | NO       | —                 | UQ            | Código institucional estable por tenant.                                             | TP-IA-2026-04     |
| edition_ref              | uuid                | NO       | —                 | EXT REF EC-02 | ProgramEdition dueña de la ejecución.                                                | ed…               |
| offering_ref             | uuid                | YES      | NULL              | EXT REF EC-02 | Offering asociado cuando la ejecución lo requiera.                                   | off…              |
| program_version_ref      | uuid                | NO       | —                 | EXT REF EC-01 | ProgramVersion académica pinneada.                                                   | pv…               |
| academic_owner_scope_ref | uuid                | NO       | —                 | EXT REF CT-01 | Unidad académica responsable.                                                        | scope…            |
| lifecycle_state          | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/ACTIVE/SUSPENDED/RETIRED.                                                      | ACTIVE            |
| created_by_subject       | uuid                | NO       | —                 | EXT REF IAM   | Actor que crea el plan.                                                              | usr…              |
| created_at               | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |
| updated_at               | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z |
| version                  | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**teaching_plan_id —** ID técnico estable del plan. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: tp….

**plan_code —** Código institucional estable por tenant. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: TP-IA-2026-04.

**edition_ref —** ProgramEdition dueña de la ejecución. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ed….

**offering_ref —** Offering asociado cuando la ejecución lo requiera. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**program_version_ref —** ProgramVersion académica pinneada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pv….

**academic_owner_scope_ref —** Unidad académica responsable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: scope….

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**created_by_subject —** Actor que crea el plan. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                    | **Error que impide**                                            |
|-----------------------------------|----------|-------------------------------------------------------------|-----------------------------------------------------------------|
| **pk_ec05_teaching_plan**         | PK       | (tenant_id, teaching_plan_id)                               | Identidad/cruce tenant.                                         |
| **uq_ec05_teaching_plan_code**    | UQ       | (tenant_id, plan_code)                                      | Business key duplicada.                                         |
| **uq_ec05_teaching_plan_edition** | UQ       | (tenant_id, edition_ref)                                    | Dos planes activos paralelos para la misma edición sin lineage. |
| **ck_ec05_teaching_plan_state**   | CHECK    | lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED') | Lifecycle inválido.                                             |
| **ix_ec05_teaching_plan_owner**   | INDEX    | (tenant_id, academic_owner_scope_ref, lifecycle_state)      | Búsqueda operativa ineficiente.                                 |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Business key duplicada.; Dos planes activos paralelos para la misma edición sin lineage.; Lifecycle inválido.; Búsqueda operativa ineficiente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec05_teaching_plan_revision

**QUÉ REPRESENTA —** Snapshot versionado y publicable del plan docente: estrategia de impartición, policies, configuración de equipos, unidades y bindings de contenido para una edición.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate publicable hijo de TeachingPlan. Antes de publish valida assignments, requirements, contenidos, derechos y dependencias CT. SCHEDULED/PUBLISHED/SUPERSEDED quedan inmutables y son contratos downstream.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lineage, vigencia, content hash y una única revisión PUBLISHED vigente. No representa schedule real ni hechos de asistencia/evaluación.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                      | **Ejemplo**         |
|---------------------------|---------------------|----------|-------------------|--------------------|--------------------------------------------------------------------------------------|---------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*               | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…                |
| teaching_plan_revision_id | uuid                | NO       | gen_random_uuid() | PK                 | ID snapshot.                                                                         | tpr…                |
| teaching_plan_id          | uuid                | NO       | —                 | FK                 | TeachingPlan padre.                                                                  | tp…                 |
| revision_no               | integer             | NO       | —                 | UQ                 | Número positivo monotónico.                                                          | 2                   |
| previous_revision_id      | uuid                | YES      | NULL              | FK                 | Revisión anterior del mismo plan.                                                    | tpr1…               |
| delivery_strategy_code    | varchar(80)         | NO       | —                 | EXT REF CT-02      | Estrategia docente parametrizada.                                                    | BLENDED_FACILITATED |
| instructional_model_code  | varchar(80)         | NO       | —                 | EXT REF CT-02      | Modelo instruccional versionado.                                                     | PROJECT_BASED       |
| default_language_code     | varchar(16)         | NO       | 'es-BO'           | EXT REF CT-08      | Idioma canónico/fallback.                                                            | es-BO               |
| workload_policy_ref       | uuid                | YES      | NULL              | EXT REF CT-02      | PolicyVersion de carga/horas docentes.                                               | pol…                |
| assignment_policy_ref     | uuid                | YES      | NULL              | EXT REF CT-02      | PolicyVersion de asignación/roles/requisitos.                                        | pol…                |
| content_policy_ref        | uuid                | YES      | NULL              | EXT REF CT-02/05   | PolicyVersion de contenido/publicación.                                              | pol…                |
| compliance_profile_ref    | uuid                | YES      | NULL              | EXT REF Governance | Perfil regulatorio/compliance aplicable.                                             | cmp…                |
| valid_from                | date                | YES      | NULL              | CHECK              | Vigencia desde la que puede usarse.                                                  | 2026-10-01          |
| valid_to                  | date                | YES      | NULL              | CHECK              | Fin opcional de vigencia.                                                            | 2027-01-31          |
| state                     | varchar(24)         | NO       | 'DRAFT'           | CHECK              | DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID.                        | PUBLISHED           |
| workflow_ref              | uuid                | YES      | NULL              | EXT REF CT-06      | Workflow/case de revisión.                                                           | wf…                 |
| review_snapshot_hash      | varchar(128)        | YES      | NULL              | —                  | Hash enviado a revisión.                                                             | sha256:…            |
| content_hash              | varchar(128)        | YES      | NULL              | —                  | Hash canónico de snapshot publicado.                                                 | sha256:…            |
| published_at              | timestamptz         | YES      | NULL              | —                  | Instante de publicación.                                                             | …                   |
| published_by_subject      | uuid                | YES      | NULL              | EXT REF IAM        | Publisher con assurance suficiente.                                                  | usr…                |
| superseded_by_revision_id | uuid                | YES      | NULL              | FK                 | Revisión posterior que reemplaza esta.                                               | tpr3…               |
| created_at                | timestamptz         | NO       | now()             | —                  | Instante UTC de creación.                                                            | 2026-09-09T20:00Z   |
| updated_at                | timestamptz         | NO       | now()             | —                  | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z   |
| version                   | bigint              | NO       | 0                 | —                  | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                   |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**teaching_plan_revision_id —** ID snapshot. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: tpr….

**teaching_plan_id —** TeachingPlan padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tp….

**revision_no —** Número positivo monotónico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 2.

**previous_revision_id —** Revisión anterior del mismo plan. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr1….

**delivery_strategy_code —** Estrategia docente parametrizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: BLENDED_FACILITATED.

**instructional_model_code —** Modelo instruccional versionado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: PROJECT_BASED.

**default_language_code —** Idioma canónico/fallback. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'es-BO'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: es-BO.

**workload_policy_ref —** PolicyVersion de carga/horas docentes. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**assignment_policy_ref —** PolicyVersion de asignación/roles/requisitos. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**content_policy_ref —** PolicyVersion de contenido/publicación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**compliance_profile_ref —** Perfil regulatorio/compliance aplicable. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: cmp….

**valid_from —** Vigencia desde la que puede usarse. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 2026-10-01.

**valid_to —** Fin opcional de vigencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 2027-01-31.

**state —** DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PUBLISHED.

**workflow_ref —** Workflow/case de revisión. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**review_snapshot_hash —** Hash enviado a revisión. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**content_hash —** Hash canónico de snapshot publicado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**published_at —** Instante de publicación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**published_by_subject —** Publisher con assurance suficiente. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**superseded_by_revision_id —** Revisión posterior que reemplaza esta. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr3….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                  | **Tipo**   | **Definición/expresión**                                                                                                                            | **Error que impide**                              |
|------------------------------------|------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------|
| **pk_ec05_teaching_plan_revision** | PK         | (tenant_id, teaching_plan_revision_id)                                                                                                              | Identidad/cruce tenant.                           |
| **uq_ec05_tpr_no**                 | UQ         | (tenant_id, teaching_plan_id, revision_no)                                                                                                          | Revision duplicada.                               |
| **uq_ec05_tpr_scope**              | UQ         | (tenant_id, teaching_plan_id, teaching_plan_revision_id)                                                                                            | Lineage cross-plan.                               |
| **uq_ec05_tpr_single_published**   | UQ PARTIAL | (tenant_id, teaching_plan_id) WHERE state='PUBLISHED'                                                                                               | Dos revisiones vigentes.                          |
| **fk_ec05_tpr_plan**               | FK         | (tenant_id, teaching_plan_id)→teaching_plan                                                                                                         | Cross tenant/plan.                                |
| **fk_ec05_tpr_previous**           | FK         | (tenant_id, teaching_plan_id, previous_revision_id)→revision scope                                                                                  | Lineage arbitrario.                               |
| **fk_ec05_tpr_superseded**         | FK         | (tenant_id, teaching_plan_id, superseded_by_revision_id)→revision scope                                                                             | Supersede arbitrario.                             |
| **ck_ec05_tpr_no**                 | CHECK      | revision_no \> 0                                                                                                                                    | Revision no positiva.                             |
| **ck_ec05_tpr_dates**              | CHECK      | valid_to IS NULL OR valid_from IS NULL OR valid_to\>=valid_from                                                                                     | Vigencia incoherente.                             |
| **ck_ec05_tpr_state**              | CHECK      | state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID')                                                               | Estado inválido.                                  |
| **ck_ec05_tpr_publish**            | CHECK      | state NOT IN ('SCHEDULED','PUBLISHED','SUPERSEDED') OR (content_hash IS NOT NULL AND published_at IS NOT NULL AND published_by_subject IS NOT NULL) | Snapshot comprometido sin evidencia.              |
| **trg_ec05_tpr_state_lineage**     | TRIGGER    | Guarda transiciones, inmutabilidad y lineage monotónico.                                                                                            | Saltos de estado/self lineage/mutación publicada. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Revision duplicada.; Lineage cross-plan.; Dos revisiones vigentes.; Cross tenant/plan.; Lineage arbitrario.; Supersede arbitrario.; Revision no positiva.; Vigencia incoherente.; Estado inválido.; Snapshot comprometido sin evidencia.; Saltos de estado/self lineage/mutación publicada. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec05_teaching_plan_module

**QUÉ REPRESENTA —** Contextualiza dentro del TeachingPlanRevision cada módulo/structure item del programa que requiere planificación de impartición.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo del TeachingPlanRevision. Pinnea module_version_ref/program_structure_item_ref EC-01 y conserva decisiones docentes locales como modalidad prevista, horas de contacto y orden.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege scope de módulo y orden. No redefine LearningModuleVersion ni agenda sesiones.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                      | **Ejemplo**       |
|----------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*          | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| teaching_plan_module_id    | uuid                | NO       | gen_random_uuid() | PK            | ID técnico.                                                                          | tpm…              |
| teaching_plan_revision_id  | uuid                | NO       | —                 | FK            | Revision padre.                                                                      | tpr…              |
| program_structure_item_ref | uuid                | NO       | —                 | EXT REF EC-01 | Item estructural pinneado.                                                           | psi…              |
| module_version_ref         | uuid                | NO       | —                 | EXT REF EC-01 | LearningModuleVersion pinneada.                                                      | mv…               |
| delivery_mode_code         | varchar(80)         | NO       | —                 | EXT REF CT-02 | Modalidad prevista compatible con EC-01/02.                                          | HYBRID            |
| instruction_mode_code      | varchar(80)         | YES      | NULL              | EXT REF CT-02 | Semántica de impartición.                                                            | WORKSHOP          |
| planned_contact_hours      | numeric(10,2)       | NO       | 0                 | CHECK         | Horas síncronas/presenciales planificadas.                                           | 12.00             |
| planned_async_hours        | numeric(10,2)       | NO       | 0                 | CHECK         | Horas asíncronas planificadas.                                                       | 8.00              |
| sequence_no                | integer             | NO       | —                 | UQ/CHECK      | Orden dentro del plan.                                                               | 1                 |
| mandatory                  | boolean             | NO       | true              | —             | Módulo obligatorio según snapshot.                                                   | true              |
| notes_text                 | text                | YES      | NULL              | —             | Observaciones docentes no sensibles.                                                 | …                 |
| created_at                 | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**teaching_plan_module_id —** ID técnico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: tpm….

**teaching_plan_revision_id —** Revision padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**program_structure_item_ref —** Item estructural pinneado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: psi….

**module_version_ref —** LearningModuleVersion pinneada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: mv….

**delivery_mode_code —** Modalidad prevista compatible con EC-01/02. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: HYBRID.

**instruction_mode_code —** Semántica de impartición. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: WORKSHOP.

**planned_contact_hours —** Horas síncronas/presenciales planificadas. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 12.00.

**planned_async_hours —** Horas asíncronas planificadas. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 8.00.

**sequence_no —** Orden dentro del plan. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**mandatory —** Módulo obligatorio según snapshot. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es true; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**notes_text —** Observaciones docentes no sensibles. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                                                                               | **Error que impide**                        |
|------------------------------------|----------|--------------------------------------------------------------------------------------------------------|---------------------------------------------|
| **pk_ec05_teaching_plan_module**   | PK       | (tenant_id, teaching_plan_module_id)                                                                   | Identidad/cruce tenant.                     |
| **fk_ec05_tpm_revision**           | FK       | (tenant_id, teaching_plan_revision_id)→revision                                                        | Cross tenant/revision.                      |
| **uq_ec05_tpm_scope**              | UQ       | (tenant_id, teaching_plan_revision_id, teaching_plan_module_id)                                        | Scope composite para children.              |
| **uq_ec05_tpm_program_item**       | UQ       | (tenant_id, teaching_plan_revision_id, program_structure_item_ref)                                     | Duplicar item de programa.                  |
| **uq_ec05_tpm_sequence**           | UQ       | (tenant_id, teaching_plan_revision_id, sequence_no)                                                    | Orden duplicado.                            |
| **ck_ec05_tpm_hours**              | CHECK    | planned_contact_hours\>=0 AND planned_async_hours\>=0 AND planned_contact_hours+planned_async_hours\>0 | Carga inválida.                             |
| **ck_ec05_tpm_sequence**           | CHECK    | sequence_no\>0                                                                                         | Orden no positivo.                          |
| **trg_ec05_plan_child_mutability** | TRIGGER  | Bloquea mutation si parent SCHEDULED/PUBLISHED/SUPERSEDED/VOID y bump root en DRAFT.                   | Mutar snapshot congelado o ETag incompleto. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross tenant/revision.; Scope composite para children.; Duplicar item de programa.; Orden duplicado.; Carga inválida.; Orden no positivo.; Mutar snapshot congelado o ETag incompleto. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.4 ec05_teaching_team

**QUÉ REPRESENTA —** Equipo docente lógico asignado a un plan, módulo o sesión externa. Permite coordinación, cofacilitación y speakers sin confundir rol docente con relación laboral.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo de TeachingPlanRevision. InstructorAssignment pertenece a un TeachingTeam. Para scope MODULE usa FK scope-aware a TeachingPlanModule; para SESSION conserva session_ref EXT REF EC-02/CT-03.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege scope XOR y business key del equipo. No representa unidad RRHH ni calendario.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                                                      | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*                | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| teaching_team_id          | uuid                | NO       | gen_random_uuid() | PK                  | ID equipo.                                                                           | team…             |
| teaching_plan_revision_id | uuid                | NO       | —                 | FK                  | Revision padre.                                                                      | tpr…              |
| scope_type                | varchar(16)         | NO       | —                 | CHECK               | PLAN/MODULE/SESSION.                                                                 | MODULE            |
| teaching_plan_module_id   | uuid                | YES      | NULL              | FK                  | Módulo local cuando scope MODULE.                                                    | tpm…              |
| session_ref               | uuid                | YES      | NULL              | EXT REF EC-02/CT-03 | Sesión externa cuando scope SESSION.                                                 | ses…              |
| team_code                 | varchar(64)         | NO       | —                 | UQ                  | Código estable dentro de revision.                                                   | TEAM-M01          |
| coordination_role_code    | varchar(80)         | YES      | NULL              | EXT REF CT-02       | Rol coordinador esperado.                                                            | LEAD_INSTRUCTOR   |
| state                     | varchar(24)         | NO       | 'PLANNED'         | CHECK               | PLANNED/ACTIVE/COMPLETED/CANCELLED.                                                  | ACTIVE            |
| created_at                | timestamptz         | NO       | now()             | —                   | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |
| updated_at                | timestamptz         | NO       | now()             | —                   | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z |
| version                   | bigint              | NO       | 0                 | —                   | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**teaching_team_id —** ID equipo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: team….

**teaching_plan_revision_id —** Revision padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**scope_type —** PLAN/MODULE/SESSION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: MODULE.

**teaching_plan_module_id —** Módulo local cuando scope MODULE. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpm….

**session_ref —** Sesión externa cuando scope SESSION. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ses….

**team_code —** Código estable dentro de revision. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: TEAM-M01.

**coordination_role_code —** Rol coordinador esperado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: LEAD_INSTRUCTOR.

**state —** PLANNED/ACTIVE/COMPLETED/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PLANNED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                                                                                                                                                                                                                                           | **Error que impide**     |
|------------------------------------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------|
| **pk_ec05_teaching_team**          | PK       | (tenant_id, teaching_team_id)                                                                                                                                                                                                                                      | Identidad/cruce tenant.  |
| **fk_ec05_team_revision**          | FK       | (tenant_id, teaching_plan_revision_id)→revision                                                                                                                                                                                                                    | Cross revision.          |
| **fk_ec05_team_module_scope**      | FK       | (tenant_id, teaching_plan_revision_id, teaching_plan_module_id)→teaching_plan_module scope                                                                                                                                                                         | Módulo de otra revision. |
| **uq_ec05_team_code**              | UQ       | (tenant_id, teaching_plan_revision_id, team_code)                                                                                                                                                                                                                  | Team code duplicado.     |
| **ck_ec05_team_scope**             | CHECK    | (scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL) | Scope ambiguo.           |
| **ck_ec05_team_state**             | CHECK    | state IN ('PLANNED','ACTIVE','COMPLETED','CANCELLED')                                                                                                                                                                                                              | Estado inválido.         |
| **trg_ec05_team_child_mutability** | TRIGGER  | Parent revision editable + aggregate bump.                                                                                                                                                                                                                         | Mutación publicada.      |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross revision.; Módulo de otra revision.; Team code duplicado.; Scope ambiguo.; Estado inválido.; Mutación publicada. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.5 ec05_instructor_assignment

**QUÉ REPRESENTA —** Asignación académica de una persona a un TeachingTeam con rol, responsabilidad y carga prevista. El mismo Person puede tener múltiples assignments legítimos en diferentes scopes.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate operativo hijo del TeachingPlanRevision/TeachingTeam. person_ref viene CT-04; engagement_ref puede apuntar RRHH/Procurement sin duplicar contrato. Requisitos e invitación/aceptación cuelgan de assignment.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege una asignación scoped, lifecycle, horas y aceptación. No prueba empleo, pago, disponibilidad ni asistencia.

| **Campo**                     | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**                | **Descripción**                                                                      | **Ejemplo**       |
|-------------------------------|---------------------|----------|-------------------|--------------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                     | uuid                | NO       | —                 | PK\*                     | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| instructor_assignment_id      | uuid                | NO       | gen_random_uuid() | PK                       | ID asignación.                                                                       | ia…               |
| teaching_plan_revision_id     | uuid                | NO       | —                 | FK                       | Revision padre.                                                                      | tpr…              |
| teaching_team_id              | uuid                | NO       | —                 | FK                       | Equipo padre.                                                                        | team…             |
| teaching_plan_module_id       | uuid                | YES      | NULL              | FK                       | Módulo cuando assignment MODULE.                                                     | tpm…              |
| session_ref                   | uuid                | YES      | NULL              | EXT REF EC-02/CT-03      | Sesión cuando assignment SESSION.                                                    | ses…              |
| assignment_scope              | varchar(16)         | NO       | —                 | CHECK                    | PLAN/MODULE/SESSION.                                                                 | MODULE            |
| person_ref                    | uuid                | NO       | —                 | EXT REF CT-04            | Persona canónica.                                                                    | person…           |
| engagement_ref                | uuid                | YES      | NULL              | EXT REF RRHH/Procurement | Relación contractual/laboral si existe.                                              | eng…              |
| role_code                     | varchar(80)         | NO       | —                 | EXT REF CT-02            | Instructor/Facilitator/Speaker/etc.                                                  | FACILITATOR       |
| responsibility_code           | varchar(80)         | YES      | NULL              | EXT REF CT-02            | Responsabilidad académica.                                                           | LEAD              |
| planned_hours                 | numeric(10,2)       | NO       | 0                 | CHECK                    | Carga prevista del assignment.                                                       | 16.00             |
| acceptance_required           | boolean             | NO       | true              | —                        | Si requiere aceptación explícita.                                                    | true              |
| state                         | varchar(24)         | NO       | 'PLANNED'         | CHECK                    | PLANNED/INVITED/ACCEPTED/ACTIVE/COMPLETED/REPLACED/CANCELLED/VOID.                   | ACCEPTED          |
| effective_from                | timestamptz         | YES      | NULL              | CHECK                    | Inicio efectivo si aplica.                                                           | …                 |
| effective_to                  | timestamptz         | YES      | NULL              | CHECK                    | Fin efectivo.                                                                        | …                 |
| replacement_for_assignment_id | uuid                | YES      | NULL              | FK                       | Assignment reemplazado del mismo revision.                                           | ia-old…           |
| reason_code                   | varchar(80)         | YES      | NULL              | EXT REF CT-02            | Motivo de replace/cancel/void.                                                       | SCHEDULE_CONFLICT |
| created_at                    | timestamptz         | NO       | now()             | —                        | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |
| updated_at                    | timestamptz         | NO       | now()             | —                        | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z |
| version                       | bigint              | NO       | 0                 | —                        | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**instructor_assignment_id —** ID asignación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ia….

**teaching_plan_revision_id —** Revision padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**teaching_team_id —** Equipo padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: team….

**teaching_plan_module_id —** Módulo cuando assignment MODULE. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpm….

**session_ref —** Sesión cuando assignment SESSION. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ses….

**assignment_scope —** PLAN/MODULE/SESSION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: MODULE.

**person_ref —** Persona canónica. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**engagement_ref —** Relación contractual/laboral si existe. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: eng….

**role_code —** Instructor/Facilitator/Speaker/etc. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: FACILITATOR.

**responsibility_code —** Responsabilidad académica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: LEAD.

**planned_hours —** Carga prevista del assignment. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 16.00.

**acceptance_required —** Si requiere aceptación explícita. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es true; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**state —** PLANNED/INVITED/ACCEPTED/ACTIVE/COMPLETED/REPLACED/CANCELLED/VOID. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PLANNED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACCEPTED.

**effective_from —** Inicio efectivo si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**effective_to —** Fin efectivo. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**replacement_for_assignment_id —** Assignment reemplazado del mismo revision. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ia-old….

**reason_code —** Motivo de replace/cancel/void. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: SCHEDULE_CONFLICT.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo**   | **Definición/expresión**                                                                                                                                                                                                                                                               | **Error que impide**          |
|-----------------------------------|------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------|
| **pk_ec05_instructor_assignment** | PK         | (tenant_id, instructor_assignment_id)                                                                                                                                                                                                                                                  | Identidad/cruce tenant.       |
| **fk_ec05_ia_revision**           | FK         | (tenant_id, teaching_plan_revision_id)→revision                                                                                                                                                                                                                                        | Cross revision.               |
| **fk_ec05_ia_team**               | FK         | (tenant_id, teaching_team_id)→team                                                                                                                                                                                                                                                     | Team de otro tenant.          |
| **fk_ec05_ia_module_scope**       | FK         | (tenant_id, teaching_plan_revision_id, teaching_plan_module_id)→module scope                                                                                                                                                                                                           | Módulo de otra revision.      |
| **fk_ec05_ia_replacement**        | FK         | (tenant_id, replacement_for_assignment_id)→assignment                                                                                                                                                                                                                                  | Replacement cross tenant.     |
| **uq_ec05_ia_active_role**        | UQ PARTIAL | (tenant_id, teaching_plan_revision_id, assignment_scope, COALESCE(teaching_plan_module_id,'00000000-0000-0000-0000-000000000000'::uuid), COALESCE(session_ref,'00000000-0000-0000-0000-000000000000'::uuid), person_ref, role_code) WHERE state NOT IN ('REPLACED','CANCELLED','VOID') | Assignment activo duplicado.  |
| **ck_ec05_ia_scope**              | CHECK      | (assignment_scope='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (assignment_scope='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (assignment_scope='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL)   | Scope ambiguo.                |
| **ck_ec05_ia_hours**              | CHECK      | planned_hours\>=0                                                                                                                                                                                                                                                                      | Horas negativas.              |
| **ck_ec05_ia_dates**              | CHECK      | effective_to IS NULL OR effective_from IS NULL OR effective_to\>=effective_from                                                                                                                                                                                                        | Fechas incoherentes.          |
| **ck_ec05_ia_state**              | CHECK      | state IN ('PLANNED','INVITED','ACCEPTED','ACTIVE','COMPLETED','REPLACED','CANCELLED','VOID')                                                                                                                                                                                           | Estado inválido.              |
| **ck_ec05_ia_no_self_replace**    | CHECK      | replacement_for_assignment_id IS NULL OR replacement_for_assignment_id\<\>instructor_assignment_id                                                                                                                                                                                     | Self replacement.             |
| **trg_ec05_ia_state**             | TRIGGER    | Guarda transiciones y requisitos/aceptación.                                                                                                                                                                                                                                           | Activación/complete inválido. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross revision.; Team de otro tenant.; Módulo de otra revision.; Replacement cross tenant.; Assignment activo duplicado.; Scope ambiguo.; Horas negativas.; Fechas incoherentes.; Estado inválido.; Self replacement.; Activación/complete inválido. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec05_assignment_requirement

**QUÉ REPRESENTA —** Requisito verificable que un InstructorAssignment debe satisfacer: credencial, experiencia, inducción, conflicto de interés, seguridad, idioma u otro requisito institucional.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo de InstructorAssignment. requirement_rule_ref se resuelve por CT-02/15/HR según tipo. Resultados son append-only y pueden expirar; assignment activation revalida mandatory requirements.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege requirement code, obligatoriedad y policy pinning. No almacena certificado/documento ni decide empleo.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**             | **Descripción**                                                                      | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|-----------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*                  | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| assignment_requirement_id | uuid                | NO       | gen_random_uuid() | PK                    | ID requisito.                                                                        | arq…              |
| instructor_assignment_id  | uuid                | NO       | —                 | FK                    | Assignment padre.                                                                    | ia…               |
| requirement_code          | varchar(80)         | NO       | —                 | UQ                    | Código único por assignment.                                                         | SAFEGUARDING      |
| requirement_type_code     | varchar(80)         | NO       | —                 | EXT REF CT-02         | Tipo parametrizado.                                                                  | CERTIFICATION     |
| requirement_rule_ref      | uuid                | YES      | NULL              | EXT REF CT-02/15/RRHH | Policy/regla versionada.                                                             | rule…             |
| mandatory                 | boolean             | NO       | true              | —                     | Bloquea activation si no PASS/WAIVED vigente.                                        | true              |
| revalidation_policy_ref   | uuid                | YES      | NULL              | EXT REF CT-02         | Freshness/expiry.                                                                    | pol…              |
| created_at                | timestamptz         | NO       | now()             | —                     | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**assignment_requirement_id —** ID requisito. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: arq….

**instructor_assignment_id —** Assignment padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ia….

**requirement_code —** Código único por assignment. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: SAFEGUARDING.

**requirement_type_code —** Tipo parametrizado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: CERTIFICATION.

**requirement_rule_ref —** Policy/regla versionada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: rule….

**mandatory —** Bloquea activation si no PASS/WAIVED vigente. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es true; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**revalidation_policy_ref —** Freshness/expiry. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                                | **Error que impide**                     |
|------------------------------------|----------|---------------------------------------------------------|------------------------------------------|
| **pk_ec05_assignment_requirement** | PK       | (tenant_id, assignment_requirement_id)                  | Identidad/cruce tenant.                  |
| **fk_ec05_arq_assignment**         | FK       | (tenant_id, instructor_assignment_id)→assignment        | Requirement huérfano/cross tenant.       |
| **uq_ec05_arq_code**               | UQ       | (tenant_id, instructor_assignment_id, requirement_code) | Requirement duplicado.                   |
| **trg_ec05_nested_plan_guard**     | TRIGGER  | Resuelve assignment→revision editable y bump root.      | Mutar requirement de snapshot congelado. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Requirement huérfano/cross tenant.; Requirement duplicado.; Mutar requirement de snapshot congelado. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.7 ec05_assignment_requirement_result

**QUÉ REPRESENTA —** Receipt append-only de la evaluación de un AssignmentRequirement en un instante: PASS, FAIL, REVIEW_REQUIRED, WAIVED, EXPIRED o UNKNOWN.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se crea por evaluadores/ports autorizados y nunca se actualiza. Activation usa el último resultado vigente conforme a revalidation policy; evidence vive CT-05/10.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege historial de decisiones y provenance. No reemplaza la evidencia externa ni un catálogo de credenciales.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                      | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*             | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| requirement_result_id     | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                          | arr…              |
| assignment_requirement_id | uuid                | NO       | —                 | FK               | Requirement evaluado.                                                                | arq…              |
| status                    | varchar(24)         | NO       | —                 | CHECK            | PASS/FAIL/REVIEW_REQUIRED/WAIVED/EXPIRED/UNKNOWN.                                    | PASS              |
| source_context            | varchar(80)         | NO       | —                 | —                | Contexto que emitió resultado.                                                       | CT15              |
| source_decision_ref       | uuid                | YES      | NULL              | EXT REF          | Receipt remoto.                                                                      | dec…              |
| evaluated_by_subject      | uuid                | YES      | NULL              | EXT REF IAM      | Evaluador humano si aplica.                                                          | usr…              |
| evaluated_at              | timestamptz         | NO       | now()             | —                | Instante evaluación.                                                                 | …                 |
| expires_at                | timestamptz         | YES      | NULL              | CHECK            | Caducidad del resultado.                                                             | …                 |
| reason_code               | varchar(80)         | YES      | NULL              | EXT REF CT-02    | Motivo de FAIL/WAIVED/etc.                                                           | VALID_CERTIFICATE |
| evidence_ref              | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidencia.                                                                           | ev…               |
| decision_hash             | varchar(128)        | NO       | —                 | —                | Hash canónico del receipt.                                                           | sha256:…          |
| created_at                | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**requirement_result_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: arr….

**assignment_requirement_id —** Requirement evaluado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: arq….

**status —** PASS/FAIL/REVIEW_REQUIRED/WAIVED/EXPIRED/UNKNOWN. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PASS.

**source_context —** Contexto que emitió resultado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CT15.

**source_decision_ref —** Receipt remoto. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: dec….

**evaluated_by_subject —** Evaluador humano si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**evaluated_at —** Instante evaluación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**expires_at —** Caducidad del resultado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**reason_code —** Motivo de FAIL/WAIVED/etc. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: VALID_CERTIFICATE.

**evidence_ref —** Evidencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**decision_hash —** Hash canónico del receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**                         | **Tipo** | **Definición/expresión**                                                 | **Error que impide**               |
|-------------------------------------------|----------|--------------------------------------------------------------------------|------------------------------------|
| **pk_ec05_assignment_requirement_result** | PK       | (tenant_id, requirement_result_id)                                       | Identidad/cruce tenant.            |
| **fk_ec05_arr_requirement**               | FK       | (tenant_id, assignment_requirement_id)→requirement                       | Result huérfano/cross tenant.      |
| **ck_ec05_arr_status**                    | CHECK    | status IN ('PASS','FAIL','REVIEW_REQUIRED','WAIVED','EXPIRED','UNKNOWN') | Status inválido.                   |
| **ck_ec05_arr_dates**                     | CHECK    | expires_at IS NULL OR expires_at\>=evaluated_at                          | Expiry inválida.                   |
| **trg_ec05_arr_append_only**              | TRIGGER  | UPDATE/DELETE forbidden.                                                 | Reescritura de decisión histórica. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Result huérfano/cross tenant.; Status inválido.; Expiry inválida.; Reescritura de decisión histórica. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.8 ec05_assignment_invitation

**QUÉ REPRESENTA —** Invitación one-shot para que la persona asignada revise y acepte/rechace su rol académico. Guarda hash del token, nunca secreto en claro.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo de InstructorAssignment. CT-07 entrega el enlace; IAM/CT-04 autentican cuando policy lo exige. Acceptance crea receipt durable.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege anti-replay, expiry y lifecycle. No es contrato laboral ni prueba de identidad por sí misma.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                      | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|-----------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*      | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| assignment_invitation_id | uuid                | NO       | gen_random_uuid() | PK        | ID invitación.                                                                       | ai…               |
| instructor_assignment_id | uuid                | NO       | —                 | FK        | Assignment target.                                                                   | ia…               |
| token_hash               | varchar(128)        | NO       | —                 | UQ        | Hash secreto.                                                                        | sha256:…          |
| token_last4              | varchar(4)          | NO       | —                 | —         | Últimos 4 para soporte.                                                              | 4K9Q              |
| state                    | varchar(20)         | NO       | 'ISSUED'          | CHECK     | ISSUED/OPENED/ACCEPTED/DECLINED/EXPIRED/REVOKED.                                     | OPENED            |
| issued_at                | timestamptz         | NO       | now()             | —         | Emisión.                                                                             | …                 |
| expires_at               | timestamptz         | NO       | —                 | CHECK     | Expiración.                                                                          | …                 |
| opened_at                | timestamptz         | YES      | NULL              | —         | Primer open.                                                                         | …                 |
| responded_at             | timestamptz         | YES      | NULL              | —         | Respuesta.                                                                           | …                 |
| created_at               | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |
| updated_at               | timestamptz         | NO       | now()             | —         | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z |
| version                  | bigint              | NO       | 0                 | —         | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**assignment_invitation_id —** ID invitación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ai….

**instructor_assignment_id —** Assignment target. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ia….

**token_hash —** Hash secreto. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**token_last4 —** Últimos 4 para soporte. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 4K9Q.

**state —** ISSUED/OPENED/ACCEPTED/DECLINED/EXPIRED/REVOKED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'ISSUED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: OPENED.

**issued_at —** Emisión. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**expires_at —** Expiración. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**opened_at —** Primer open. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**responded_at —** Respuesta. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo**   | **Definición/expresión**                                                 | **Error que impide**           |
|-----------------------------------|------------|--------------------------------------------------------------------------|--------------------------------|
| **pk_ec05_assignment_invitation** | PK         | (tenant_id, assignment_invitation_id)                                    | Identidad/cruce tenant.        |
| **fk_ec05_inv_assignment**        | FK         | (tenant_id, instructor_assignment_id)→assignment                         | Target cross tenant.           |
| **uq_ec05_inv_token**             | UQ         | (tenant_id, token_hash)                                                  | Token duplicado.               |
| **uq_ec05_inv_active**            | UQ PARTIAL | (tenant_id, instructor_assignment_id) WHERE state IN ('ISSUED','OPENED') | Dos invitaciones activas.      |
| **ck_ec05_inv_state**             | CHECK      | state IN ('ISSUED','OPENED','ACCEPTED','DECLINED','EXPIRED','REVOKED')   | Estado inválido.               |
| **ck_ec05_inv_expiry**            | CHECK      | expires_at\>issued_at                                                    | Expiry inválida.               |
| **trg_ec05_inv_state**            | TRIGGER    | Guarda one-shot/expiry y no resurrection.                                | Replay o transición imposible. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Target cross tenant.; Token duplicado.; Dos invitaciones activas.; Estado inválido.; Expiry inválida.; Replay o transición imposible. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.9 ec05_assignment_acceptance_receipt

**QUÉ REPRESENTA —** Evidencia append-only de que la persona aceptó los términos/rol de un InstructorAssignment bajo políticas versionadas.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se crea al aceptar invitation o flujo equivalente autenticado. Puede referenciar evidencia/firma CT-05/10. Assignment usa receipt para pasar a ACCEPTED cuando acceptance_required.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege no repudio técnico/auditable y policy version. No reemplaza contrato RRHH/Procurement.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                      | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*             | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| acceptance_receipt_id    | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                          | aar…              |
| instructor_assignment_id | uuid                | NO       | —                 | FK               | Assignment aceptado.                                                                 | ia…               |
| assignment_invitation_id | uuid                | YES      | NULL              | FK               | Invitation origen si aplica.                                                         | ai…               |
| accepted_by_person_ref   | uuid                | NO       | —                 | EXT REF CT-04    | Persona que acepta.                                                                  | person…           |
| terms_policy_ref         | uuid                | NO       | —                 | EXT REF CT-02/10 | PolicyVersion aceptada.                                                              | pol…              |
| terms_hash               | varchar(128)        | NO       | —                 | —                | Hash del texto/terms canónico.                                                       | sha256:…          |
| assurance_level_code     | varchar(40)         | NO       | —                 | EXT REF IAM      | Assurance autenticación.                                                             | AAL2              |
| accepted_at              | timestamptz         | NO       | now()             | —                | Instante UTC.                                                                        | …                 |
| evidence_ref             | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidencia/firma.                                                                     | ev…               |
| created_at               | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**acceptance_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: aar….

**instructor_assignment_id —** Assignment aceptado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ia….

**assignment_invitation_id —** Invitation origen si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ai….

**accepted_by_person_ref —** Persona que acepta. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**terms_policy_ref —** PolicyVersion aceptada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**terms_hash —** Hash del texto/terms canónico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**assurance_level_code —** Assurance autenticación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: AAL2.

**accepted_at —** Instante UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**evidence_ref —** Evidencia/firma. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión**                         | **Error que impide**     |
|--------------------------------|----------|--------------------------------------------------|--------------------------|
| **pk_ec05_acceptance_receipt** | PK       | (tenant_id, acceptance_receipt_id)               | Identidad/cruce tenant.  |
| **fk_ec05_aar_assignment**     | FK       | (tenant_id, instructor_assignment_id)→assignment | Assignment inválido.     |
| **fk_ec05_aar_invitation**     | FK       | (tenant_id, assignment_invitation_id)→invitation | Invitation cross tenant. |
| **uq_ec05_aar_assignment**     | UQ       | (tenant_id, instructor_assignment_id)            | Acceptance duplicada.    |
| **trg_ec05_aar_append_only**   | TRIGGER  | UPDATE/DELETE forbidden.                         | Reescribir aceptación.   |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Assignment inválido.; Invitation cross tenant.; Acceptance duplicada.; Reescribir aceptación. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec05_teaching_change_request

**QUÉ REPRESENTA —** Solicitud gobernada de cambio sobre un plan aprobado/publicado: reemplazo docente, cambio de estrategia o corrección material que exige nueva revisión/snapshot.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Integra CT-06. Un request aprobado no edita snapshots publicados; crea/aplica nueva TeachingPlanRevision o comandos operativos permitidos según materiality policy.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege reason/evidence/workflow y separación request→apply. No es un generic audit log.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                      | **Ejemplo**            |
|----------------------------|---------------------|----------|-------------------|------------------|--------------------------------------------------------------------------------------|------------------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*             | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…                   |
| teaching_change_request_id | uuid                | NO       | gen_random_uuid() | PK               | ID solicitud.                                                                        | tcr…                   |
| teaching_plan_revision_id  | uuid                | NO       | —                 | FK               | Revision origen.                                                                     | tpr…                   |
| change_type_code           | varchar(80)         | NO       | —                 | EXT REF CT-02    | Tipo de cambio.                                                                      | INSTRUCTOR_REPLACEMENT |
| reason_code                | varchar(80)         | NO       | —                 | EXT REF CT-02    | Motivo.                                                                              | UNAVAILABILITY         |
| description_text           | text                | NO       | —                 | —                | Descripción controlada.                                                              | …                      |
| state                      | varchar(24)         | NO       | 'DRAFT'           | CHECK            | DRAFT/SUBMITTED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/CANCELLED.                    | APPROVED               |
| workflow_ref               | uuid                | YES      | NULL              | EXT REF CT-06    | Workflow approval.                                                                   | wf…                    |
| requested_by_subject       | uuid                | NO       | —                 | EXT REF IAM      | Solicitante.                                                                         | usr…                   |
| requested_at               | timestamptz         | NO       | now()             | —                | Solicitud.                                                                           | …                      |
| approved_by_subject        | uuid                | YES      | NULL              | EXT REF IAM      | Aprobador.                                                                           | usr2…                  |
| approved_at                | timestamptz         | YES      | NULL              | —                | Aprobación.                                                                          | …                      |
| applied_revision_id        | uuid                | YES      | NULL              | FK               | Nueva revision resultante si aplica.                                                 | tpr3…                  |
| evidence_ref               | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidencia.                                                                           | ev…                    |
| updated_at                 | timestamptz         | NO       | now()             | —                | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z      |
| version                    | bigint              | NO       | 0                 | —                | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                      |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**teaching_change_request_id —** ID solicitud. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: tcr….

**teaching_plan_revision_id —** Revision origen. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**change_type_code —** Tipo de cambio. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: INSTRUCTOR_REPLACEMENT.

**reason_code —** Motivo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: UNAVAILABILITY.

**description_text —** Descripción controlada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: ….

**state —** DRAFT/SUBMITTED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: APPROVED.

**workflow_ref —** Workflow approval. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**requested_by_subject —** Solicitante. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**requested_at —** Solicitud. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**approved_by_subject —** Aprobador. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr2….

**approved_at —** Aprobación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**applied_revision_id —** Nueva revision resultante si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr3….

**evidence_ref —** Evidencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                                                             | **Error que impide**        |
|----------------------------------|----------|------------------------------------------------------------------------------------------------------|-----------------------------|
| **pk_ec05_change_request**       | PK       | (tenant_id, teaching_change_request_id)                                                              | Identidad/cruce tenant.     |
| **fk_ec05_tcr_revision**         | FK       | (tenant_id, teaching_plan_revision_id)→revision                                                      | Origen inválido.            |
| **fk_ec05_tcr_applied_revision** | FK       | (tenant_id, applied_revision_id)→revision                                                            | Revision aplicada inválida. |
| **ck_ec05_tcr_state**            | CHECK    | state IN ('DRAFT','SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','CANCELLED')            | Estado inválido.            |
| **ck_ec05_tcr_approval**         | CHECK    | state NOT IN ('APPROVED','APPLIED') OR (approved_by_subject IS NOT NULL AND approved_at IS NOT NULL) | Approval sin actor/fecha.   |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Origen inválido.; Revision aplicada inválida.; Estado inválido.; Approval sin actor/fecha. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.11 ec05_instructional_unit_plan

**QUÉ REPRESENTA —** Unidad instruccional planificada dentro de un módulo o asociada a una sesión externa: objetivos, metodología, secuencia y duración prevista.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo de TeachingPlanRevision y opcionalmente TeachingPlanModule/session_ref. Puede vincular content items. CT-03/13 conserva horario real; EC-05 solo guarda diseño instruccional.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege scope XOR, secuencia y duración. No crea Session ni Attendance.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                                                      | **Ejemplo**       |
|----------------------------|---------------------|----------|-------------------|---------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*                | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| instructional_unit_plan_id | uuid                | NO       | gen_random_uuid() | PK                  | ID unidad.                                                                           | iup…              |
| teaching_plan_revision_id  | uuid                | NO       | —                 | FK                  | Revision padre.                                                                      | tpr…              |
| scope_type                 | varchar(16)         | NO       | —                 | CHECK               | MODULE/SESSION.                                                                      | MODULE            |
| teaching_plan_module_id    | uuid                | YES      | NULL              | FK                  | Módulo si scope MODULE.                                                              | tpm…              |
| session_ref                | uuid                | YES      | NULL              | EXT REF EC-02/CT-03 | Sesión si scope SESSION.                                                             | ses…              |
| unit_code                  | varchar(64)         | NO       | —                 | UQ                  | Código dentro revision.                                                              | U-M1-01           |
| title                      | varchar(240)        | NO       | —                 | —                   | Título.                                                                              | Caso guiado       |
| objective_text             | text                | YES      | NULL              | —                   | Objetivo de la unidad.                                                               | …                 |
| method_code                | varchar(80)         | NO       | —                 | EXT REF CT-02       | Método instruccional.                                                                | CASE_BASED        |
| planned_minutes            | integer             | NO       | —                 | CHECK               | Duración prevista \>0.                                                               | 90                |
| sequence_no                | integer             | NO       | —                 | CHECK               | Orden positivo.                                                                      | 1                 |
| outcome_ref                | uuid                | YES      | NULL              | EXT REF EC-01       | Outcome pinneado si aplica.                                                          | out…              |
| created_at                 | timestamptz         | NO       | now()             | —                   | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**instructional_unit_plan_id —** ID unidad. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: iup….

**teaching_plan_revision_id —** Revision padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**scope_type —** MODULE/SESSION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: MODULE.

**teaching_plan_module_id —** Módulo si scope MODULE. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpm….

**session_ref —** Sesión si scope SESSION. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ses….

**unit_code —** Código dentro revision. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: U-M1-01.

**title —** Título. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Caso guiado.

**objective_text —** Objetivo de la unidad. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ….

**method_code —** Método instruccional. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: CASE_BASED.

**planned_minutes —** Duración prevista \>0. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 90.

**sequence_no —** Orden positivo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**outcome_ref —** Outcome pinneado si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: out….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                                                                                                                                        | **Error que impide**      |
|------------------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------|
| **pk_ec05_unit_plan**        | PK       | (tenant_id, instructional_unit_plan_id)                                                                                                                                         | Identidad/cruce tenant.   |
| **fk_ec05_iup_revision**     | FK       | (tenant_id, teaching_plan_revision_id)→revision                                                                                                                                 | Cross revision.           |
| **fk_ec05_iup_module_scope** | FK       | (tenant_id, teaching_plan_revision_id, teaching_plan_module_id)→module scope                                                                                                    | Módulo de otra revision.  |
| **uq_ec05_iup_code**         | UQ       | (tenant_id, teaching_plan_revision_id, unit_code)                                                                                                                               | Unit code duplicado.      |
| **ck_ec05_iup_scope**        | CHECK    | (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL) | Scope ambiguo.            |
| **ck_ec05_iup_minutes**      | CHECK    | planned_minutes\>0                                                                                                                                                              | Duración inválida.        |
| **ck_ec05_iup_sequence**     | CHECK    | sequence_no\>0                                                                                                                                                                  | Orden inválido.           |
| **trg_ec05_iup_mutability**  | TRIGGER  | Parent editable + bump revision.                                                                                                                                                | Mutar snapshot congelado. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross revision.; Módulo de otra revision.; Unit code duplicado.; Scope ambiguo.; Duración inválida.; Orden inválido.; Mutar snapshot congelado. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec05_learning_content_package

**QUÉ REPRESENTA —** Identidad estable de un paquete de contenido reusable: guía, módulo digital, set de materiales, manual, laboratorio, recurso H5P/SCORM o colección.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root independiente del plan. Evoluciona mediante LearningContentPackageVersion y puede reutilizarse en múltiples planes sin duplicar blobs.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege business key, owner y lifecycle. No almacena binarios ni representa un LMS course.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                      | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| content_package_id       | uuid                | NO       | gen_random_uuid() | PK            | ID estable.                                                                          | cp…               |
| package_code             | varchar(64)         | NO       | —                 | UQ            | Business key tenant-aware.                                                           | CP-AI-LAB         |
| content_family_code      | varchar(80)         | NO       | —                 | EXT REF CT-02 | Familia/tipo.                                                                        | LAB_PACKAGE       |
| academic_owner_scope_ref | uuid                | NO       | —                 | EXT REF CT-01 | Owner académico.                                                                     | scope…            |
| default_language_code    | varchar(16)         | NO       | 'es-BO'           | EXT REF CT-08 | Idioma canónico.                                                                     | es-BO             |
| lifecycle_state          | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/ACTIVE/SUSPENDED/RETIRED.                                                      | ACTIVE            |
| created_by_subject       | uuid                | NO       | —                 | EXT REF IAM   | Creador.                                                                             | usr…              |
| created_at               | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |
| updated_at               | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z |
| version                  | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**content_package_id —** ID estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cp….

**package_code —** Business key tenant-aware. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CP-AI-LAB.

**content_family_code —** Familia/tipo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: LAB_PACKAGE.

**academic_owner_scope_ref —** Owner académico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: scope….

**default_language_code —** Idioma canónico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'es-BO'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: es-BO.

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**created_by_subject —** Creador. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                    | **Error que impide**    |
|-----------------------------------|----------|-------------------------------------------------------------|-------------------------|
| **pk_ec05_content_package**       | PK       | (tenant_id, content_package_id)                             | Identidad/cruce tenant. |
| **uq_ec05_content_package_code**  | UQ       | (tenant_id, package_code)                                   | Code duplicado.         |
| **ck_ec05_content_package_state** | CHECK    | lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED') | Lifecycle inválido.     |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Code duplicado.; Lifecycle inválido. |
|---------------------------------------------------------------------------------------------------|

## 12.13 ec05_learning_content_package_version

**QUÉ REPRESENTA —** Snapshot versionado/publicable del paquete de contenido: título, descripción, formato, idioma, accesibilidad, policies y hash de composición.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate publicable hijo de LearningContentPackage. Agrega ContentItems, rights y release rules. SCHEDULED/PUBLISHED/SUPERSEDED quedan inmutables y son pinneados por TeachingContentBinding.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lineage y contenido histórico reproducible. No contiene blob; cada item referencia CT-05 o CT-18.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                      | **Ejemplo**       |
|----------------------------|---------------------|----------|-------------------|------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*             | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| content_package_version_id | uuid                | NO       | gen_random_uuid() | PK               | ID snapshot.                                                                         | cpv…              |
| content_package_id         | uuid                | NO       | —                 | FK               | Package padre.                                                                       | cp…               |
| version_no                 | integer             | NO       | —                 | UQ               | Versión positiva.                                                                    | 3                 |
| previous_version_id        | uuid                | YES      | NULL              | FK               | Versión anterior del mismo package.                                                  | cpv2…             |
| title                      | varchar(240)        | NO       | —                 | —                | Título canónico.                                                                     | Laboratorio IA v3 |
| description_text           | text                | YES      | NULL              | —                | Descripción.                                                                         | …                 |
| content_format_code        | varchar(80)         | NO       | —                 | EXT REF CT-02    | Formato predominante.                                                                | MIXED             |
| language_code              | varchar(16)         | NO       | 'es-BO'           | EXT REF CT-08    | Idioma.                                                                              | es-BO             |
| accessibility_profile_ref  | uuid                | YES      | NULL              | EXT REF CT-02/05 | Perfil de accesibilidad.                                                             | acc…              |
| content_policy_ref         | uuid                | YES      | NULL              | EXT REF CT-02/05 | PolicyVersion de publicación/retención.                                              | pol…              |
| state                      | varchar(24)         | NO       | 'DRAFT'           | CHECK            | DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID.                        | PUBLISHED         |
| workflow_ref               | uuid                | YES      | NULL              | EXT REF CT-06    | Workflow.                                                                            | wf…               |
| review_snapshot_hash       | varchar(128)        | YES      | NULL              | —                | Hash en review.                                                                      | sha256:…          |
| content_hash               | varchar(128)        | YES      | NULL              | —                | Hash composición publicada.                                                          | sha256:…          |
| published_at               | timestamptz         | YES      | NULL              | —                | Publicación.                                                                         | …                 |
| published_by_subject       | uuid                | YES      | NULL              | EXT REF IAM      | Publisher.                                                                           | usr…              |
| superseded_by_version_id   | uuid                | YES      | NULL              | FK               | Siguiente versión.                                                                   | cpv4…             |
| created_at                 | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |
| updated_at                 | timestamptz         | NO       | now()             | —                | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z |
| version                    | bigint              | NO       | 0                 | —                | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**content_package_version_id —** ID snapshot. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cpv….

**content_package_id —** Package padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cp….

**version_no —** Versión positiva. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 3.

**previous_version_id —** Versión anterior del mismo package. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpv2….

**title —** Título canónico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Laboratorio IA v3.

**description_text —** Descripción. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ….

**content_format_code —** Formato predominante. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: MIXED.

**language_code —** Idioma. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'es-BO'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: es-BO.

**accessibility_profile_ref —** Perfil de accesibilidad. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: acc….

**content_policy_ref —** PolicyVersion de publicación/retención. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**state —** DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PUBLISHED.

**workflow_ref —** Workflow. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**review_snapshot_hash —** Hash en review. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**content_hash —** Hash composición publicada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**published_at —** Publicación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**published_by_subject —** Publisher. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**superseded_by_version_id —** Siguiente versión. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpv4….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo**   | **Definición/expresión**                                                                                                                            | **Error que impide**              |
|--------------------------------------|------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------|
| **pk_ec05_content_version**          | PK         | (tenant_id, content_package_version_id)                                                                                                             | Identidad/cruce tenant.           |
| **uq_ec05_content_version_no**       | UQ         | (tenant_id, content_package_id, version_no)                                                                                                         | Version duplicada.                |
| **uq_ec05_content_version_scope**    | UQ         | (tenant_id, content_package_id, content_package_version_id)                                                                                         | Lineage scope.                    |
| **uq_ec05_content_single_published** | UQ PARTIAL | (tenant_id, content_package_id) WHERE state='PUBLISHED'                                                                                             | Dos versiones vigentes.           |
| **fk_ec05_cpv_package**              | FK         | (tenant_id, content_package_id)→package                                                                                                             | Cross tenant.                     |
| **fk_ec05_cpv_previous**             | FK         | (tenant_id, content_package_id, previous_version_id)→version scope                                                                                  | Lineage arbitrario.               |
| **fk_ec05_cpv_superseded**           | FK         | (tenant_id, content_package_id, superseded_by_version_id)→version scope                                                                             | Supersede arbitrario.             |
| **ck_ec05_cpv_no**                   | CHECK      | version_no\>0                                                                                                                                       | Version inválida.                 |
| **ck_ec05_cpv_state**                | CHECK      | state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID')                                                               | Estado inválido.                  |
| **ck_ec05_cpv_publish**              | CHECK      | state NOT IN ('SCHEDULED','PUBLISHED','SUPERSEDED') OR (content_hash IS NOT NULL AND published_at IS NOT NULL AND published_by_subject IS NOT NULL) | Snapshot publicado sin evidencia. |
| **trg_ec05_cpv_state_lineage**       | TRIGGER    | State guard/inmutability/lineage monotónico.                                                                                                        | Saltos/mutación/self lineage.     |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Version duplicada.; Lineage scope.; Dos versiones vigentes.; Cross tenant.; Lineage arbitrario.; Supersede arbitrario.; Version inválida.; Estado inválido.; Snapshot publicado sin evidencia.; Saltos/mutación/self lineage. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec05_learning_content_item

**QUÉ REPRESENTA —** Elemento concreto dentro de una ContentPackageVersion. Puede ser documento CT-05, recurso externo CT-18 o referencia LMS; exige exactamente un target conforme al tipo.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo de ContentPackageVersion. TeachingContentBinding puede pinnear el item. CT-05 conserva blobs/hashes documentales y CT-18 conserva integración externa.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege target XOR, orden y required flag. No copia archivo ni URL secreta.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                      | **Ejemplo**         |
|----------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------------------------|---------------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*          | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…                |
| content_item_id            | uuid                | NO       | gen_random_uuid() | PK            | ID item.                                                                             | ci…                 |
| content_package_version_id | uuid                | NO       | —                 | FK            | Version padre.                                                                       | cpv…                |
| item_code                  | varchar(64)         | NO       | —                 | UQ            | Código dentro version.                                                               | LAB-01              |
| item_type_code             | varchar(80)         | NO       | —                 | EXT REF CT-02 | Tipo: DOCUMENT/SCORM/H5P/VIDEO/LINK/etc.                                             | DOCUMENT            |
| title                      | varchar(240)        | NO       | —                 | —             | Título.                                                                              | Guía de laboratorio |
| document_ref               | uuid                | YES      | NULL              | EXT REF CT-05 | Documento/archivo si aplica.                                                         | doc…                |
| external_resource_ref      | uuid                | YES      | NULL              | EXT REF CT-18 | Recurso externo si aplica.                                                           | res…                |
| lms_resource_ref           | varchar(180)        | YES      | NULL              | EXT REF CT-18 | Recurso LMS provisionado si aplica.                                                  | moodle:file:17      |
| estimated_minutes          | integer             | YES      | NULL              | CHECK         | Tiempo estimado.                                                                     | 45                  |
| sequence_no                | integer             | NO       | —                 | UQ/CHECK      | Orden.                                                                               | 1                   |
| required                   | boolean             | NO       | true              | —             | Recurso requerido.                                                                   | true                |
| content_checksum           | varchar(128)        | YES      | NULL              | —             | Checksum de referencia cuando aplica.                                                | sha256:…            |
| created_at                 | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                            | 2026-09-09T20:00Z   |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**content_item_id —** ID item. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ci….

**content_package_version_id —** Version padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpv….

**item_code —** Código dentro version. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: LAB-01.

**item_type_code —** Tipo: DOCUMENT/SCORM/H5P/VIDEO/LINK/etc. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: DOCUMENT.

**title —** Título. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Guía de laboratorio.

**document_ref —** Documento/archivo si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: doc….

**external_resource_ref —** Recurso externo si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: res….

**lms_resource_ref —** Recurso LMS provisionado si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: moodle:file:17.

**estimated_minutes —** Tiempo estimado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 45.

**sequence_no —** Orden. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**required —** Recurso requerido. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es true; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**content_checksum —** Checksum de referencia cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**                     | **Tipo** | **Definición/expresión**                                                                                             | **Error que impide**       |
|---------------------------------------|----------|----------------------------------------------------------------------------------------------------------------------|----------------------------|
| **pk_ec05_content_item**              | PK       | (tenant_id, content_item_id)                                                                                         | Identidad/cruce tenant.    |
| **fk_ec05_ci_version**                | FK       | (tenant_id, content_package_version_id)→content version                                                              | Cross version.             |
| **uq_ec05_ci_scope**                  | UQ       | (tenant_id, content_package_version_id, content_item_id)                                                             | Scope para child FK.       |
| **uq_ec05_ci_code**                   | UQ       | (tenant_id, content_package_version_id, item_code)                                                                   | Code duplicado.            |
| **uq_ec05_ci_sequence**               | UQ       | (tenant_id, content_package_version_id, sequence_no)                                                                 | Orden duplicado.           |
| **ck_ec05_ci_target**                 | CHECK    | (document_ref IS NOT NULL)::int + (external_resource_ref IS NOT NULL)::int + (lms_resource_ref IS NOT NULL)::int = 1 | Target ambiguo/ausente.    |
| **ck_ec05_ci_minutes**                | CHECK    | estimated_minutes IS NULL OR estimated_minutes\>0                                                                    | Duración inválida.         |
| **ck_ec05_ci_sequence**               | CHECK    | sequence_no\>0                                                                                                       | Orden inválido.            |
| **trg_ec05_content_child_mutability** | TRIGGER  | Parent content version editable + aggregate bump.                                                                    | Mutar contenido publicado. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross version.; Scope para child FK.; Code duplicado.; Orden duplicado.; Target ambiguo/ausente.; Duración inválida.; Orden inválido.; Mutar contenido publicado. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec05_content_rights_binding

**QUÉ REPRESENTA —** Declaración versionada de derechos/licencia/uso permitido sobre un LearningContentItem. Separa disponibilidad técnica del derecho institucional a usar/grabar/publicar.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo del item. rights_holder_ref puede ser Person/Organization external ref; evidence_ref vive CT-05/10. Publish del content version exige rights vigentes según policy.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege vigencia y licencia. No representa contrato de autor ni blob.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**         | **Descripción**                                                                      | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|-------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*              | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| content_rights_binding_id | uuid                | NO       | gen_random_uuid() | PK                | ID binding.                                                                          | crb…              |
| content_item_id           | uuid                | NO       | —                 | FK                | Item target.                                                                         | ci…               |
| rights_type_code          | varchar(80)         | NO       | —                 | EXT REF CT-02     | COPYRIGHT/LICENSE/INSTITUTIONAL/etc.                                                 | LICENSE           |
| rights_holder_ref         | uuid                | YES      | NULL              | EXT REF CT-04/Org | Titular si aplica.                                                                   | org…              |
| license_code              | varchar(80)         | YES      | NULL              | EXT REF CT-02     | Licencia gobernada.                                                                  | CC-BY-4.0         |
| permitted_use_code        | varchar(80)         | NO       | —                 | EXT REF CT-02     | Uso permitido.                                                                       | TEACHING_REUSE    |
| valid_from                | date                | YES      | NULL              | CHECK             | Inicio vigencia.                                                                     | 2026-01-01        |
| valid_to                  | date                | YES      | NULL              | CHECK             | Fin vigencia.                                                                        | 2028-12-31        |
| policy_ref                | uuid                | YES      | NULL              | EXT REF CT-02/10  | PolicyVersion.                                                                       | pol…              |
| evidence_ref              | uuid                | YES      | NULL              | EXT REF CT-05/10  | Contrato/licencia/evidencia.                                                         | ev…               |
| created_at                | timestamptz         | NO       | now()             | —                 | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**content_rights_binding_id —** ID binding. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: crb….

**content_item_id —** Item target. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ci….

**rights_type_code —** COPYRIGHT/LICENSE/INSTITUTIONAL/etc. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: LICENSE.

**rights_holder_ref —** Titular si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: org….

**license_code —** Licencia gobernada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: CC-BY-4.0.

**permitted_use_code —** Uso permitido. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: TEACHING_REUSE.

**valid_from —** Inicio vigencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 2026-01-01.

**valid_to —** Fin vigencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 2028-12-31.

**policy_ref —** PolicyVersion. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**evidence_ref —** Contrato/licencia/evidencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                        | **Error que impide**                      |
|-----------------------------------|----------|-----------------------------------------------------------------|-------------------------------------------|
| **pk_ec05_rights_binding**        | PK       | (tenant_id, content_rights_binding_id)                          | Identidad/cruce tenant.                   |
| **fk_ec05_crb_item**              | FK       | (tenant_id, content_item_id)→content item                       | Item inválido.                            |
| **ck_ec05_crb_dates**             | CHECK    | valid_to IS NULL OR valid_from IS NULL OR valid_to\>=valid_from | Vigencia incoherente.                     |
| **trg_ec05_nested_content_guard** | TRIGGER  | Resuelve item→version editable y bump root.                     | Modificar derechos de snapshot congelado. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Item inválido.; Vigencia incoherente.; Modificar derechos de snapshot congelado. |
|-----------------------------------------------------------------------------------------------------------------------------------------------|

## 12.16 ec05_content_release_rule

**QUÉ REPRESENTA —** Regla de liberación/visibilidad de un content item durante ejecución: immediate, relative-to-session, manual, prerequisite-driven u otra policy.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo del item/version. Puede referenciar trigger/policy externa; CT-18 materializa la visibilidad en LMS, pero EC-05 conserva intención académica versionada.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege ventana/trigger coherentes. No es scheduler CT-13 ni historial de acceso participante.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                                                      | **Ejemplo**       |
|-----------------------------|---------------------|----------|-------------------|---------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                   | uuid                | NO       | —                 | PK\*                | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| content_release_rule_id     | uuid                | NO       | gen_random_uuid() | PK                  | ID regla.                                                                            | rr…               |
| content_package_version_id  | uuid                | NO       | —                 | FK                  | Content version scope.                                                               | cpv…              |
| content_item_id             | uuid                | NO       | —                 | FK                  | Item del mismo version.                                                              | ci…               |
| release_trigger_code        | varchar(80)         | NO       | —                 | EXT REF CT-02       | IMMEDIATE/SESSION_START/MANUAL/PREREQUISITE/etc.                                     | SESSION_START     |
| relative_offset_minutes     | integer             | YES      | NULL              | CHECK               | Offset relativo; puede ser negativo si policy lo permite.                            | -30               |
| prerequisite_ref            | uuid                | YES      | NULL              | EXT REF EC-07/CT-15 | Condición externa si aplica.                                                         | req…              |
| visibility_duration_minutes | integer             | YES      | NULL              | CHECK               | Ventana de visibilidad.                                                              | 10080             |
| policy_ref                  | uuid                | YES      | NULL              | EXT REF CT-02       | PolicyVersion.                                                                       | pol…              |
| created_at                  | timestamptz         | NO       | now()             | —                   | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**content_release_rule_id —** ID regla. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: rr….

**content_package_version_id —** Content version scope. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpv….

**content_item_id —** Item del mismo version. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ci….

**release_trigger_code —** IMMEDIATE/SESSION_START/MANUAL/PREREQUISITE/etc. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: SESSION_START.

**relative_offset_minutes —** Offset relativo; puede ser negativo si policy lo permite. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: -30.

**prerequisite_ref —** Condición externa si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: req….

**visibility_duration_minutes —** Ventana de visibilidad. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 10080.

**policy_ref —** PolicyVersion. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**               | **Tipo** | **Definición/expresión**                                                    | **Error que impide**                             |
|---------------------------------|----------|-----------------------------------------------------------------------------|--------------------------------------------------|
| **pk_ec05_release_rule**        | PK       | (tenant_id, content_release_rule_id)                                        | Identidad/cruce tenant.                          |
| **fk_ec05_rr_version**          | FK       | (tenant_id, content_package_version_id)→content version                     | Version inválida.                                |
| **fk_ec05_rr_item_scope**       | FK       | (tenant_id, content_package_version_id, content_item_id)→content item scope | Item de otra version.                            |
| **uq_ec05_rr_item**             | UQ       | (tenant_id, content_item_id)                                                | Regla duplicada cuando modelo admite una activa. |
| **ck_ec05_rr_duration**         | CHECK    | visibility_duration_minutes IS NULL OR visibility_duration_minutes\>0       | Ventana inválida.                                |
| **trg_ec05_release_mutability** | TRIGGER  | Parent content version editable + bump.                                     | Editar release de snapshot publicado.            |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Version inválida.; Item de otra version.; Regla duplicada cuando modelo admite una activa.; Ventana inválida.; Editar release de snapshot publicado. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.17 ec05_teaching_content_binding

**QUÉ REPRESENTA —** Vínculo entre un TeachingPlanRevision/scope instruccional y un ContentItem pinneado. Explica para qué se usa el contenido y su orden dentro de la experiencia.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo de TeachingPlanRevision. Puede apuntar a módulo, sesión o InstructionalUnitPlan; el content_item_id pertenece a un ContentPackageVersion publicado al momento de publish del plan.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege scope XOR y pinning. No duplica contenido ni controla acceso técnico del LMS.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                                                      | **Ejemplo**       |
|-----------------------------|---------------------|----------|-------------------|---------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                   | uuid                | NO       | —                 | PK\*                | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| teaching_content_binding_id | uuid                | NO       | gen_random_uuid() | PK                  | ID binding.                                                                          | tcb…              |
| teaching_plan_revision_id   | uuid                | NO       | —                 | FK                  | Revision padre.                                                                      | tpr…              |
| scope_type                  | varchar(16)         | NO       | —                 | CHECK               | PLAN/MODULE/SESSION/UNIT.                                                            | UNIT              |
| teaching_plan_module_id     | uuid                | YES      | NULL              | FK                  | Módulo si scope MODULE.                                                              | tpm…              |
| session_ref                 | uuid                | YES      | NULL              | EXT REF EC-02/CT-03 | Session si scope SESSION.                                                            | ses…              |
| instructional_unit_plan_id  | uuid                | YES      | NULL              | FK                  | Unidad si scope UNIT.                                                                | iup…              |
| content_item_id             | uuid                | NO       | —                 | FK                  | Content item pinneado.                                                               | ci…               |
| purpose_code                | varchar(80)         | NO       | —                 | EXT REF CT-02       | READING/PRACTICE/ASSESSMENT_PREP/etc.                                                | PRACTICE          |
| sequence_no                 | integer             | NO       | —                 | CHECK               | Orden dentro scope.                                                                  | 1                 |
| required                    | boolean             | NO       | true              | —                   | Obligatoriedad instruccional.                                                        | true              |
| created_at                  | timestamptz         | NO       | now()             | —                   | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**teaching_content_binding_id —** ID binding. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: tcb….

**teaching_plan_revision_id —** Revision padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**scope_type —** PLAN/MODULE/SESSION/UNIT. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: UNIT.

**teaching_plan_module_id —** Módulo si scope MODULE. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpm….

**session_ref —** Session si scope SESSION. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ses….

**instructional_unit_plan_id —** Unidad si scope UNIT. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: iup….

**content_item_id —** Content item pinneado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ci….

**purpose_code —** READING/PRACTICE/ASSESSMENT_PREP/etc. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: PRACTICE.

**sequence_no —** Orden dentro scope. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**required —** Obligatoriedad instruccional. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es true; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | **Error que impide**      |
|--------------------------------------|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------|
| **pk_ec05_teaching_content_binding** | PK       | (tenant_id, teaching_content_binding_id)                                                                                                                                                                                                                                                                                                                                                                                                                                                                              | Identidad/cruce tenant.   |
| **fk_ec05_tcb_revision**             | FK       | (tenant_id, teaching_plan_revision_id)→revision                                                                                                                                                                                                                                                                                                                                                                                                                                                                       | Cross revision.           |
| **fk_ec05_tcb_module_scope**         | FK       | (tenant_id, teaching_plan_revision_id, teaching_plan_module_id)→module scope                                                                                                                                                                                                                                                                                                                                                                                                                                          | Módulo otra revision.     |
| **fk_ec05_tcb_unit**                 | FK       | (tenant_id, instructional_unit_plan_id)→unit plan                                                                                                                                                                                                                                                                                                                                                                                                                                                                     | Unit inválida.            |
| **fk_ec05_tcb_content**              | FK       | (tenant_id, content_item_id)→content item                                                                                                                                                                                                                                                                                                                                                                                                                                                                             | Content cross tenant.     |
| **ck_ec05_tcb_scope**                | CHECK    | (scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL AND instructional_unit_plan_id IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL AND instructional_unit_plan_id IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL AND instructional_unit_plan_id IS NULL) OR (scope_type='UNIT' AND teaching_plan_module_id IS NULL AND session_ref IS NULL AND instructional_unit_plan_id IS NOT NULL) | Scope ambiguo.            |
| **ck_ec05_tcb_sequence**             | CHECK    | sequence_no\>0                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        | Orden inválido.           |
| **uq_ec05_tcb_order**                | UQ       | (tenant_id, teaching_plan_revision_id, scope_type, COALESCE(teaching_plan_module_id,'00000000-0000-0000-0000-000000000000'::uuid), COALESCE(session_ref,'00000000-0000-0000-0000-000000000000'::uuid), COALESCE(instructional_unit_plan_id,'00000000-0000-0000-0000-000000000000'::uuid), sequence_no)                                                                                                                                                                                                                | Orden duplicado.          |
| **trg_ec05_tcb_mutability**          | TRIGGER  | Parent plan editable + bump.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          | Editar binding publicado. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross revision.; Módulo otra revision.; Unit inválida.; Content cross tenant.; Scope ambiguo.; Orden inválido.; Orden duplicado.; Editar binding publicado. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.18 ec05_external_learning_space_binding

**QUÉ REPRESENTA —** Referencia local a un espacio externo de aprendizaje ya provisionado o reconocido: LMS course/shell, clase virtual o workspace de proveedor.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo de TeachingPlanRevision y scope PLAN/MODULE/SESSION. CT-18 es gateway/proveedor; EC-05 conserva external_space_ref, estado y policies necesarias para reconciliar.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege scope, provider y estado observado. No almacena credenciales, URL secreta ni es Source of Truth del proveedor.

| **Campo**                          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                                                      | **Ejemplo**       |
|------------------------------------|---------------------|----------|-------------------|---------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                          | uuid                | NO       | —                 | PK\*                | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| external_learning_space_binding_id | uuid                | NO       | gen_random_uuid() | PK                  | ID binding.                                                                          | els…              |
| teaching_plan_revision_id          | uuid                | NO       | —                 | FK                  | Revision padre.                                                                      | tpr…              |
| scope_type                         | varchar(16)         | NO       | —                 | CHECK               | PLAN/MODULE/SESSION.                                                                 | MODULE            |
| teaching_plan_module_id            | uuid                | YES      | NULL              | FK                  | Módulo.                                                                              | tpm…              |
| session_ref                        | uuid                | YES      | NULL              | EXT REF EC-02/CT-03 | Sesión.                                                                              | ses…              |
| provider_code                      | varchar(80)         | NO       | —                 | EXT REF CT-18       | Proveedor lógico, no SDK hardcodeado.                                                | MOODLE            |
| space_type_code                    | varchar(80)         | NO       | —                 | EXT REF CT-18       | COURSE/MEETING/TEAM/etc.                                                             | COURSE            |
| external_space_ref                 | varchar(220)        | NO       | —                 | EXT REF CT-18       | ID opaco remoto.                                                                     | moodle:course:778 |
| state                              | varchar(24)         | NO       | —                 | CHECK               | PROVISIONED/ACTIVE/SUSPENDED/ARCHIVED/UNKNOWN_EFFECT.                                | ACTIVE            |
| access_policy_ref                  | uuid                | YES      | NULL              | EXT REF CT-02/10    | Policy de acceso/privacy.                                                            | pol…              |
| last_verified_at                   | timestamptz         | YES      | NULL              | —                   | Última confirmación remota.                                                          | …                 |
| created_at                         | timestamptz         | NO       | now()             | —                   | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |
| updated_at                         | timestamptz         | NO       | now()             | —                   | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z |
| version                            | bigint              | NO       | 0                 | —                   | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**external_learning_space_binding_id —** ID binding. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: els….

**teaching_plan_revision_id —** Revision padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**scope_type —** PLAN/MODULE/SESSION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: MODULE.

**teaching_plan_module_id —** Módulo. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpm….

**session_ref —** Sesión. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ses….

**provider_code —** Proveedor lógico, no SDK hardcodeado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: MOODLE.

**space_type_code —** COURSE/MEETING/TEAM/etc. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: COURSE.

**external_space_ref —** ID opaco remoto. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: moodle:course:778.

**state —** PROVISIONED/ACTIVE/SUSPENDED/ARCHIVED/UNKNOWN_EFFECT. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: ACTIVE.

**access_policy_ref —** Policy de acceso/privacy. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**last_verified_at —** Última confirmación remota. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                                                                                                                                                                                                                           | **Error que impide**    |
|------------------------------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec05_external_space**   | PK       | (tenant_id, external_learning_space_binding_id)                                                                                                                                                                                                                    | Identidad/cruce tenant. |
| **fk_ec05_els_revision**     | FK       | (tenant_id, teaching_plan_revision_id)→revision                                                                                                                                                                                                                    | Cross revision.         |
| **fk_ec05_els_module_scope** | FK       | (tenant_id, teaching_plan_revision_id, teaching_plan_module_id)→module scope                                                                                                                                                                                       | Módulo otra revision.   |
| **uq_ec05_els_remote**       | UQ       | (tenant_id, provider_code, external_space_ref)                                                                                                                                                                                                                     | Space duplicado.        |
| **ck_ec05_els_scope**        | CHECK    | (scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL) | Scope ambiguo.          |
| **ck_ec05_els_state**        | CHECK    | state IN ('PROVISIONED','ACTIVE','SUSPENDED','ARCHIVED','UNKNOWN_EFFECT')                                                                                                                                                                                          | Estado inválido.        |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross revision.; Módulo otra revision.; Space duplicado.; Scope ambiguo.; Estado inválido. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.19 ec05_lms_provisioning_intent

**QUÉ REPRESENTA —** Comando durable de efecto remoto enviado vía CT-18 para crear, actualizar, sincronizar, suspender o archivar un espacio/recurso externo.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate técnico/business boundary alrededor de side effects remotos. Usa idempotency key y OperationStatus; timeout después de envío produce UNKNOWN_EFFECT y exige reconcile antes de retry.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege request hash, ownership y lifecycle. No es el espacio remoto ni una llamada SDK directa.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                                                      | **Ejemplo**       |
|----------------------------|---------------------|----------|-------------------|---------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*                | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| lms_provisioning_intent_id | uuid                | NO       | gen_random_uuid() | PK                  | ID intent.                                                                           | lpi…              |
| teaching_plan_revision_id  | uuid                | NO       | —                 | FK                  | Revision relacionada.                                                                | tpr…              |
| scope_type                 | varchar(16)         | NO       | —                 | CHECK               | PLAN/MODULE/SESSION.                                                                 | PLAN              |
| teaching_plan_module_id    | uuid                | YES      | NULL              | FK                  | Módulo si aplica.                                                                    | tpm…              |
| session_ref                | uuid                | YES      | NULL              | EXT REF EC-02/CT-03 | Session si aplica.                                                                   | ses…              |
| provider_code              | varchar(80)         | NO       | —                 | EXT REF CT-18       | Proveedor.                                                                           | MOODLE            |
| action_code                | varchar(40)         | NO       | —                 | CHECK               | CREATE/UPDATE/SYNC/SUSPEND/ARCHIVE.                                                  | CREATE            |
| idempotency_key            | varchar(160)        | NO       | —                 | UQ                  | Key remota/local.                                                                    | idem…             |
| request_hash               | varchar(128)        | NO       | —                 | —                   | Hash request canónico.                                                               | sha256:…          |
| state                      | varchar(24)         | NO       | 'PENDING'         | CHECK               | PENDING/SENT/CONFIRMED/FAILED/UNKNOWN_EFFECT/CANCELLED.                              | SENT              |
| remote_operation_ref       | varchar(180)        | YES      | NULL              | —                   | ID remoto/query-status.                                                              | op-778            |
| operation_id               | uuid                | YES      | NULL              | FK                  | OperationStatus local 202.                                                           | op…               |
| correlation_id             | uuid                | NO       | —                 | —                   | Correlation.                                                                         | corr…             |
| sent_at                    | timestamptz         | YES      | NULL              | —                   | Envío.                                                                               | …                 |
| completed_at               | timestamptz         | YES      | NULL              | —                   | Terminal.                                                                            | …                 |
| last_error_code            | varchar(100)        | YES      | NULL              | —                   | Error.                                                                               | CT18_TIMEOUT      |
| created_at                 | timestamptz         | NO       | now()             | —                   | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |
| updated_at                 | timestamptz         | NO       | now()             | —                   | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z |
| version                    | bigint              | NO       | 0                 | —                   | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**lms_provisioning_intent_id —** ID intent. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: lpi….

**teaching_plan_revision_id —** Revision relacionada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**scope_type —** PLAN/MODULE/SESSION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PLAN.

**teaching_plan_module_id —** Módulo si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpm….

**session_ref —** Session si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ses….

**provider_code —** Proveedor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: MOODLE.

**action_code —** CREATE/UPDATE/SYNC/SUSPEND/ARCHIVE. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CREATE.

**idempotency_key —** Key remota/local. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: idem….

**request_hash —** Hash request canónico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**state —** PENDING/SENT/CONFIRMED/FAILED/UNKNOWN_EFFECT/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: SENT.

**remote_operation_ref —** ID remoto/query-status. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: op-778.

**operation_id —** OperationStatus local 202. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: op….

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**sent_at —** Envío. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**completed_at —** Terminal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**last_error_code —** Error. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: CT18_TIMEOUT.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                                                                                                                                                                                                                           | **Error que impide**             |
|------------------------------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------|
| **pk_ec05_lms_intent**       | PK       | (tenant_id, lms_provisioning_intent_id)                                                                                                                                                                                                                            | Identidad/cruce tenant.          |
| **fk_ec05_lpi_revision**     | FK       | (tenant_id, teaching_plan_revision_id)→revision                                                                                                                                                                                                                    | Cross revision.                  |
| **fk_ec05_lpi_module_scope** | FK       | (tenant_id, teaching_plan_revision_id, teaching_plan_module_id)→module scope                                                                                                                                                                                       | Módulo otra revision.            |
| **fk_ec05_lpi_operation**    | FK       | (tenant_id, operation_id)→operation_status                                                                                                                                                                                                                         | Operation cross tenant.          |
| **uq_ec05_lpi_idempotency**  | UQ       | (tenant_id, idempotency_key)                                                                                                                                                                                                                                       | Duplicate remote intent.         |
| **ck_ec05_lpi_scope**        | CHECK    | (scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL) | Scope ambiguo.                   |
| **ck_ec05_lpi_action**       | CHECK    | action_code IN ('CREATE','UPDATE','SYNC','SUSPEND','ARCHIVE')                                                                                                                                                                                                      | Acción inválida.                 |
| **ck_ec05_lpi_state**        | CHECK    | state IN ('PENDING','SENT','CONFIRMED','FAILED','UNKNOWN_EFFECT','CANCELLED')                                                                                                                                                                                      | Estado inválido.                 |
| **ix_ec05_lpi_unknown**      | INDEX    | (tenant_id, updated_at) WHERE state='UNKNOWN_EFFECT'                                                                                                                                                                                                               | Unknown effect no reconciliable. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross revision.; Módulo otra revision.; Operation cross tenant.; Duplicate remote intent.; Scope ambiguo.; Acción inválida.; Estado inválido.; Unknown effect no reconciliable. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.20 ec05_lms_provisioning_receipt

**QUÉ REPRESENTA —** Receipt append-only que registra el resultado observado de un LmsProvisioningIntent y el external_space_ref retornado o reconciliado.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se crea por adapter CT-18/reconciliation. Un nuevo observation genera nuevo receipt, no update del anterior.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege provenance de side effects remotos. No reemplaza ExternalLearningSpaceBinding ni truth del proveedor.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                      | **Ejemplo**       |
|-----------------------------|---------------------|----------|-------------------|------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                   | uuid                | NO       | —                 | PK\*             | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| lms_provisioning_receipt_id | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                          | lpr…              |
| lms_provisioning_intent_id  | uuid                | NO       | —                 | FK               | Intent origen.                                                                       | lpi…              |
| effect_state                | varchar(24)         | NO       | —                 | CHECK            | CONFIRMED/REJECTED/UNKNOWN_EFFECT/NOT_APPLIED.                                       | CONFIRMED         |
| provider_code               | varchar(80)         | NO       | —                 | EXT REF CT-18    | Proveedor.                                                                           | MOODLE            |
| external_space_ref          | varchar(220)        | YES      | NULL              | —                | Space remoto si existe.                                                              | moodle:course:778 |
| remote_operation_ref        | varchar(180)        | YES      | NULL              | —                | Operación remota.                                                                    | op-778            |
| request_hash                | varchar(128)        | NO       | —                 | —                | Hash request.                                                                        | sha256:…          |
| response_hash               | varchar(128)        | YES      | NULL              | —                | Hash response.                                                                       | sha256:…          |
| observed_at                 | timestamptz         | NO       | now()             | —                | Momento observado.                                                                   | …                 |
| evidence_ref                | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidencia.                                                                           | ev…               |
| created_at                  | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**lms_provisioning_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: lpr….

**lms_provisioning_intent_id —** Intent origen. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: lpi….

**effect_state —** CONFIRMED/REJECTED/UNKNOWN_EFFECT/NOT_APPLIED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CONFIRMED.

**provider_code —** Proveedor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: MOODLE.

**external_space_ref —** Space remoto si existe. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: moodle:course:778.

**remote_operation_ref —** Operación remota. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: op-778.

**request_hash —** Hash request. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**response_hash —** Hash response. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**observed_at —** Momento observado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**evidence_ref —** Evidencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                                | **Error que impide**                |
|------------------------------|----------|-------------------------------------------------------------------------|-------------------------------------|
| **pk_ec05_lms_receipt**      | PK       | (tenant_id, lms_provisioning_receipt_id)                                | Identidad/cruce tenant.             |
| **fk_ec05_lpr_intent**       | FK       | (tenant_id, lms_provisioning_intent_id)→intent                          | Intent inválido.                    |
| **ck_ec05_lpr_state**        | CHECK    | effect_state IN ('CONFIRMED','REJECTED','UNKNOWN_EFFECT','NOT_APPLIED') | Estado inválido.                    |
| **trg_ec05_lpr_append_only** | TRIGGER  | UPDATE/DELETE forbidden.                                                | Reescribir efecto remoto histórico. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Intent inválido.; Estado inválido.; Reescribir efecto remoto histórico. |
|--------------------------------------------------------------------------------------------------------------------------------------|

## 12.21 ec05_recording_policy_binding

**QUÉ REPRESENTA —** Binding de política para grabación de sesiones/clases: obligatoriedad, consentimiento, retención y ámbito de publicación.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Hijo de TeachingPlanRevision con scope PLAN/MODULE/SESSION. CT-18 materializa recording cuando corresponda; CT-10/05 gobiernan privacy/consent/retention/evidence.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege policy pinning y scope. No almacena recording binary ni consentimiento individual.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                                                      | **Ejemplo**       |
|-----------------------------|---------------------|----------|-------------------|---------------------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id                   | uuid                | NO       | —                 | PK\*                | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| recording_policy_binding_id | uuid                | NO       | gen_random_uuid() | PK                  | ID binding.                                                                          | rpb…              |
| teaching_plan_revision_id   | uuid                | NO       | —                 | FK                  | Revision.                                                                            | tpr…              |
| scope_type                  | varchar(16)         | NO       | —                 | CHECK               | PLAN/MODULE/SESSION.                                                                 | SESSION           |
| teaching_plan_module_id     | uuid                | YES      | NULL              | FK                  | Módulo.                                                                              | tpm…              |
| session_ref                 | uuid                | YES      | NULL              | EXT REF EC-02/CT-03 | Sesión.                                                                              | ses…              |
| recording_required          | boolean             | NO       | false             | —                   | Si recording es requerido.                                                           | true              |
| recording_policy_ref        | uuid                | NO       | —                 | EXT REF CT-02/10    | PolicyVersion de grabación.                                                          | pol…              |
| consent_policy_ref          | uuid                | YES      | NULL              | EXT REF CT-10       | Consent policy.                                                                      | pol…              |
| retention_policy_ref        | uuid                | YES      | NULL              | EXT REF CT-05/10    | Retention.                                                                           | pol…              |
| publication_scope_code      | varchar(80)         | YES      | NULL              | EXT REF CT-02/10    | PRIVATE_COHORT/INTERNAL/PUBLIC/etc.                                                  | PRIVATE_COHORT    |
| created_at                  | timestamptz         | NO       | now()             | —                   | Instante UTC de creación.                                                            | 2026-09-09T20:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**recording_policy_binding_id —** ID binding. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: rpb….

**teaching_plan_revision_id —** Revision. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpr….

**scope_type —** PLAN/MODULE/SESSION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: SESSION.

**teaching_plan_module_id —** Módulo. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: tpm….

**session_ref —** Sesión. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ses….

**recording_required —** Si recording es requerido. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es false; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**recording_policy_ref —** PolicyVersion de grabación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**consent_policy_ref —** Consent policy. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**retention_policy_ref —** Retention. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**publication_scope_code —** PRIVATE_COHORT/INTERNAL/PUBLIC/etc. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: PRIVATE_COHORT.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

### Constraints físicos implementables

| **Nombre físico**             | **Tipo** | **Definición/expresión**                                                                                                                                                                                                                                           | **Error que impide**             |
|-------------------------------|----------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------|
| **pk_ec05_recording_binding** | PK       | (tenant_id, recording_policy_binding_id)                                                                                                                                                                                                                           | Identidad/cruce tenant.          |
| **fk_ec05_rpb_revision**      | FK       | (tenant_id, teaching_plan_revision_id)→revision                                                                                                                                                                                                                    | Cross revision.                  |
| **fk_ec05_rpb_module_scope**  | FK       | (tenant_id, teaching_plan_revision_id, teaching_plan_module_id)→module scope                                                                                                                                                                                       | Módulo otra revision.            |
| **ck_ec05_rpb_scope**         | CHECK    | (scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL) | Scope ambiguo.                   |
| **trg_ec05_rpb_mutability**   | TRIGGER  | Parent plan editable + bump.                                                                                                                                                                                                                                       | Editar policy binding publicado. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Cross revision.; Módulo otra revision.; Scope ambiguo.; Editar policy binding publicado. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.22 ec05_publication_receipt

**QUÉ REPRESENTA —** Evidencia append-only de la publicación de TeachingPlanRevision o ContentPackageVersion con hash, schema canónico, policy snapshot, actor y workflow.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se inserta dentro de la misma transacción local que publish/supersede y outbox. target_type tipa el target local y un trigger valida que exista en el tenant.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege reconstructibilidad/auditoría. No es certificado de participante ni documento binario.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                      | **Ejemplo**             |
|--------------------------|---------------------|----------|-------------------|------------------|--------------------------------------------------------------------------------------|-------------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*             | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…                    |
| publication_receipt_id   | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                          | pub…                    |
| target_type              | varchar(40)         | NO       | —                 | CHECK            | TEACHING_PLAN_REVISION/CONTENT_PACKAGE_VERSION.                                      | TEACHING_PLAN_REVISION  |
| target_ref               | uuid                | NO       | —                 | —                | ID local tipado.                                                                     | tpr…                    |
| content_hash             | varchar(128)        | NO       | —                 | —                | Hash snapshot.                                                                       | sha256:…                |
| hash_algorithm           | varchar(32)         | NO       | 'SHA-256'         | —                | Algoritmo.                                                                           | SHA-256                 |
| canonical_schema_version | integer             | NO       | 1                 | CHECK            | Versión canonicalization.                                                            | 1                       |
| policy_snapshot_json     | jsonb               | NO       | '{}'::jsonb       | CHECK            | Refs/versiones de policies.                                                          | {"assignment":"pol:v3"} |
| workflow_ref             | uuid                | YES      | NULL              | EXT REF CT-06    | Workflow.                                                                            | wf…                     |
| published_by_subject     | uuid                | NO       | —                 | EXT REF IAM      | Publisher.                                                                           | usr…                    |
| assurance_level_code     | varchar(40)         | NO       | —                 | EXT REF IAM      | Assurance.                                                                           | AAL2                    |
| evidence_ref             | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidence pack.                                                                       | ev…                     |
| published_at             | timestamptz         | NO       | now()             | —                | Publicación.                                                                         | …                       |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**publication_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pub….

**target_type —** TEACHING_PLAN_REVISION/CONTENT_PACKAGE_VERSION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: TEACHING_PLAN_REVISION.

**target_ref —** ID local tipado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: tpr….

**content_hash —** Hash snapshot. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**hash_algorithm —** Algoritmo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'SHA-256'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: SHA-256.

**canonical_schema_version —** Versión canonicalization. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1.

**policy_snapshot_json —** Refs/versiones de policies. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"assignment":"pol:v3"}.

**workflow_ref —** Workflow. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**published_by_subject —** Publisher. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**assurance_level_code —** Assurance. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: AAL2.

**evidence_ref —** Evidence pack. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**published_at —** Publicación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**               | **Tipo** | **Definición/expresión**                                            | **Error que impide**                    |
|---------------------------------|----------|---------------------------------------------------------------------|-----------------------------------------|
| **pk_ec05_publication_receipt** | PK       | (tenant_id, publication_receipt_id)                                 | Identidad/cruce tenant.                 |
| **uq_ec05_pub_target_hash**     | UQ       | (tenant_id, target_type, target_ref, content_hash)                  | Receipt duplicado.                      |
| **ck_ec05_pub_target**          | CHECK    | target_type IN ('TEACHING_PLAN_REVISION','CONTENT_PACKAGE_VERSION') | Target type inválido.                   |
| **ck_ec05_pub_schema**          | CHECK    | canonical_schema_version\>0                                         | Schema inválido.                        |
| **ck_ec05_pub_policy_json**     | CHECK    | jsonb_typeof(policy_snapshot_json)='object'                         | Snapshot inválido.                      |
| **trg_ec05_pub_target_exists**  | TRIGGER  | Valida target tipado local en mismo tenant.                         | Receipt apuntando a target inexistente. |
| **trg_ec05_pub_append_only**    | TRIGGER  | UPDATE/DELETE forbidden.                                            | Reescritura de evidencia.               |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Receipt duplicado.; Target type inválido.; Schema inválido.; Snapshot inválido.; Receipt apuntando a target inexistente.; Reescritura de evidencia. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.23 ec05_external_effect_receipt

**QUÉ REPRESENTA —** Receipt durable de efecto/consulta cross-context crítica: CT-18, CT-04, RRHH/Procurement, CT-06, CT-05 u otras dependencias.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se crea alrededor de llamadas remotas. UNKNOWN_EFFECT se conserva hasta query/reconciliation; retry ciego está prohibido.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege remote_operation_ref, request/response hashes, correlation y conocimiento observado. No duplica estado externo.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                      | **Ejemplo**    |
|----------------------|---------------------|----------|-------------------|------------------|--------------------------------------------------------------------------------------|----------------|
| tenant_id            | uuid                | NO       | —                 | PK\*             | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…           |
| effect_receipt_id    | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                          | fxr…           |
| context_code         | varchar(40)         | NO       | —                 | —                | CT18/CT04/RRHH/CT06/CT05/etc.                                                        | CT18           |
| operation_name       | varchar(120)        | NO       | —                 | —                | Operación contractual.                                                               | createCourse   |
| local_resource_ref   | varchar(180)        | NO       | —                 | —                | Recurso local.                                                                       | plan:tpr…      |
| remote_operation_ref | varchar(180)        | YES      | NULL              | —                | ID remoto.                                                                           | remote-op…     |
| idempotency_key      | varchar(160)        | YES      | NULL              | —                | Key enviada.                                                                         | idem…          |
| request_hash         | varchar(128)        | NO       | —                 | —                | Hash request.                                                                        | sha256:…       |
| effect_state         | varchar(24)         | NO       | —                 | CHECK            | CONFIRMED/REJECTED/UNKNOWN_EFFECT/NOT_APPLIED.                                       | UNKNOWN_EFFECT |
| response_hash        | varchar(128)        | YES      | NULL              | —                | Hash response.                                                                       | sha256:…       |
| correlation_id       | uuid                | NO       | —                 | —                | Correlation.                                                                         | corr…          |
| observed_at          | timestamptz         | NO       | now()             | —                | Momento observado.                                                                   | …              |
| reconciled_at        | timestamptz         | YES      | NULL              | —                | Resolución posterior.                                                                | …              |
| evidence_ref         | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidencia.                                                                           | ev…            |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**effect_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: fxr….

**context_code —** CT18/CT04/RRHH/CT06/CT05/etc. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CT18.

**operation_name —** Operación contractual. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: createCourse.

**local_resource_ref —** Recurso local. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: plan:tpr….

**remote_operation_ref —** ID remoto. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: remote-op….

**idempotency_key —** Key enviada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: idem….

**request_hash —** Hash request. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**effect_state —** CONFIRMED/REJECTED/UNKNOWN_EFFECT/NOT_APPLIED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: UNKNOWN_EFFECT.

**response_hash —** Hash response. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**observed_at —** Momento observado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**reconciled_at —** Resolución posterior. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**evidence_ref —** Evidencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

### Constraints físicos implementables

| **Nombre físico**          | **Tipo** | **Definición/expresión**                                                   | **Error que impide**                              |
|----------------------------|----------|----------------------------------------------------------------------------|---------------------------------------------------|
| **pk_ec05_effect_receipt** | PK       | (tenant_id, effect_receipt_id)                                             | Identidad/cruce tenant.                           |
| **ck_ec05_effect_state**   | CHECK    | effect_state IN ('CONFIRMED','REJECTED','UNKNOWN_EFFECT','NOT_APPLIED')    | Estado inválido.                                  |
| **ix_ec05_effect_unknown** | INDEX    | (tenant_id, context_code, observed_at) WHERE effect_state='UNKNOWN_EFFECT' | Unknown effects no reconciliables eficientemente. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Estado inválido.; Unknown effects no reconciliables eficientemente. |
|----------------------------------------------------------------------------------------------------------------------------------|

## 12.24 ec05_command_idempotency

**QUÉ REPRESENTA —** Registro durable de idempotencia para publish, assignment, invitation, acceptance, provisioning, replacement, bulk operations e integraciones.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se adquiere antes del side effect. Same-key/same-payload retorna mismo resultado; payload distinto 409. IN_PROGRESS usa owner/lease/recovery.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege duplicación por retries/crash. No es Redis cache.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                      | **Ejemplo**                 |
|-----------------|---------------------|----------|-------------------|-----------|--------------------------------------------------------------------------------------|-----------------------------|
| tenant_id       | uuid                | NO       | —                 | PK\*      | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…                        |
| idempotency_id  | uuid                | NO       | gen_random_uuid() | PK        | ID registro.                                                                         | idemrec…                    |
| idempotency_key | varchar(160)        | NO       | —                 | UQ        | Clave comando.                                                                       | idem…                       |
| command_name    | varchar(120)        | NO       | —                 | —         | Comando estable.                                                                     | PublishTeachingPlanRevision |
| request_hash    | varchar(128)        | NO       | —                 | —         | Hash request.                                                                        | sha256:…                    |
| state           | varchar(24)         | NO       | 'IN_PROGRESS'     | CHECK     | IN_PROGRESS/SUCCEEDED/FAILED_RECOVERABLE/FAILED_FINAL.                               | SUCCEEDED                   |
| owner_id        | varchar(120)        | YES      | NULL              | —         | Owner actual.                                                                        | pod-7                       |
| lease_until     | timestamptz         | YES      | NULL              | CHECK     | Lease.                                                                               | …                           |
| response_status | integer             | YES      | NULL              | CHECK     | HTTP/status cacheado.                                                                | 201                         |
| response_json   | jsonb               | YES      | NULL              | CHECK     | Respuesta durable acotada.                                                           | {"id":"…"}                  |
| resource_ref    | varchar(200)        | YES      | NULL              | —         | Recurso creado.                                                                      | plan:tpr…                   |
| last_error_code | varchar(100)        | YES      | NULL              | —         | Último error.                                                                        | CT18_TIMEOUT                |
| created_at      | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                            | 2026-09-09T20:00Z           |
| updated_at      | timestamptz         | NO       | now()             | —         | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z           |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**idempotency_id —** ID registro. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: idemrec….

**idempotency_key —** Clave comando. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: idem….

**command_name —** Comando estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PublishTeachingPlanRevision.

**request_hash —** Hash request. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**state —** IN_PROGRESS/SUCCEEDED/FAILED_RECOVERABLE/FAILED_FINAL. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'IN_PROGRESS'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: SUCCEEDED.

**owner_id —** Owner actual. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pod-7.

**lease_until —** Lease. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**response_status —** HTTP/status cacheado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 201.

**response_json —** Respuesta durable acotada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"id":"…"}.

**resource_ref —** Recurso creado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: plan:tpr….

**last_error_code —** Último error. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: CT18_TIMEOUT.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

### Constraints físicos implementables

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                                   | **Error que impide**          |
|----------------------------------|----------|----------------------------------------------------------------------------|-------------------------------|
| **pk_ec05_command_idempotency**  | PK       | (tenant_id, idempotency_id)                                                | Identidad/cruce tenant.       |
| **uq_ec05_idempotency_key**      | UQ       | (tenant_id, idempotency_key)                                               | Key duplicada.                |
| **ck_ec05_idempotency_state**    | CHECK    | state IN ('IN_PROGRESS','SUCCEEDED','FAILED_RECOVERABLE','FAILED_FINAL')   | Estado inválido.              |
| **ck_ec05_idempotency_response** | CHECK    | response_status IS NULL OR response_status BETWEEN 100 AND 599             | Status inválido.              |
| **ck_ec05_idempotency_payload**  | CHECK    | response_json IS NULL OR jsonb_typeof(response_json) IN ('object','array') | Response mal formada.         |
| **ix_ec05_idempotency_recovery** | INDEX    | (tenant_id, lease_until) WHERE state='IN_PROGRESS'                         | Lease vencido no recuperable. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Key duplicada.; Estado inválido.; Status inválido.; Response mal formada.; Lease vencido no recuperable. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.25 ec05_outbox_event

**QUÉ REPRESENTA —** Evento de integración persistido atómicamente con el hecho EC-05. Implementa at-least-once con claim/lease, backoff y delivery observable.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Dispatcher multi-instancia usa FOR UPDATE SKIP LOCKED. Publica TeachingPlanPublished, InstructorAssigned, AssignmentAccepted, ContentPublished, LearningSpaceProvisioned, etc.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege atomicidad negocio→evento. No promete exactly-once distribuido.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                      | **Ejemplo**                    |
|-----------------|---------------------|----------|-------------------|-----------|--------------------------------------------------------------------------------------|--------------------------------|
| tenant_id       | uuid                | NO       | —                 | PK\*      | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…                           |
| event_id        | uuid                | NO       | gen_random_uuid() | PK        | ID evento.                                                                           | evt…                           |
| aggregate_type  | varchar(100)        | NO       | —                 | —         | Aggregate.                                                                           | TeachingPlanRevision           |
| aggregate_id    | uuid                | NO       | —                 | —         | ID aggregate.                                                                        | tpr…                           |
| event_type      | varchar(160)        | NO       | —                 | —         | Nombre versionado.                                                                   | TeachingPlanPublished.v1       |
| schema_version  | integer             | NO       | 1                 | CHECK     | Versión payload.                                                                     | 1                              |
| payload_json    | jsonb               | NO       | —                 | CHECK     | Payload minimizado.                                                                  | {"teachingPlanRevisionId":"…"} |
| correlation_id  | uuid                | NO       | —                 | —         | Correlation.                                                                         | corr…                          |
| causation_id    | uuid                | YES      | NULL              | —         | Causation.                                                                           | cause…                         |
| occurred_at     | timestamptz         | NO       | now()             | —         | Momento hecho.                                                                       | …                              |
| state           | varchar(20)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/DELIVERED/FAILED.                                                  | PENDING                        |
| owner_id        | varchar(120)        | YES      | NULL              | —         | Dispatcher owner.                                                                    | pod-1                          |
| lease_until     | timestamptz         | YES      | NULL              | —         | Lease.                                                                               | …                              |
| attempt_count   | integer             | NO       | 0                 | CHECK     | Intentos.                                                                            | 1                              |
| next_attempt_at | timestamptz         | NO       | now()             | —         | Backoff.                                                                             | …                              |
| delivered_at    | timestamptz         | YES      | NULL              | —         | Delivery.                                                                            | …                              |
| last_error_code | varchar(100)        | YES      | NULL              | —         | Error.                                                                               | BROKER_TIMEOUT                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**event_id —** ID evento. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: evt….

**aggregate_type —** Aggregate. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: TeachingPlanRevision.

**aggregate_id —** ID aggregate. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: tpr….

**event_type —** Nombre versionado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: TeachingPlanPublished.v1.

**schema_version —** Versión payload. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1.

**payload_json —** Payload minimizado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: {"teachingPlanRevisionId":"…"}.

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**causation_id —** Causation. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cause….

**occurred_at —** Momento hecho. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**state —** PENDING/IN_FLIGHT/DELIVERED/FAILED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PENDING.

**owner_id —** Dispatcher owner. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pod-1.

**lease_until —** Lease. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**attempt_count —** Intentos. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1.

**next_attempt_at —** Backoff. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**delivered_at —** Delivery. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**last_error_code —** Error. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: BROKER_TIMEOUT.

### Constraints físicos implementables

| **Nombre físico**           | **Tipo** | **Definición/expresión**                                                      | **Error que impide**          |
|-----------------------------|----------|-------------------------------------------------------------------------------|-------------------------------|
| **pk_ec05_outbox_event**    | PK       | (tenant_id, event_id)                                                         | Identidad/cruce tenant.       |
| **ck_ec05_outbox_schema**   | CHECK    | schema_version\>0                                                             | Schema inválido.              |
| **ck_ec05_outbox_payload**  | CHECK    | jsonb_typeof(payload_json)='object'                                           | Payload inválido.             |
| **ck_ec05_outbox_state**    | CHECK    | state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED')                         | Estado inválido.              |
| **ck_ec05_outbox_attempts** | CHECK    | attempt_count\>=0                                                             | Intentos negativos.           |
| **ix_ec05_outbox_claim**    | INDEX    | (tenant_id, next_attempt_at, occurred_at) WHERE state IN ('PENDING','FAILED') | Claim ineficiente.            |
| **ix_ec05_outbox_reclaim**  | INDEX    | (tenant_id, lease_until) WHERE state='IN_FLIGHT'                              | Lease perdido no recuperable. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Schema inválido.; Payload inválido.; Estado inválido.; Intentos negativos.; Claim ineficiente.; Lease perdido no recuperable. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.26 ec05_inbox_message

**QUÉ REPRESENTA —** Registro durable de deduplicación de mensajes entrantes desde EC-01/02, CT-18, RRHH, CT-06 y demás contratos.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se inserta por message_id antes de handler. Duplicate same-id/same-hash retorna resultado existente; same-id/different-payload es incidente contractual.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege side effects duplicados. No reemplaza event store de otro contexto.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**                                                                      | **Ejemplo**       |
|-----------------|---------------------|----------|-------------|-----------|--------------------------------------------------------------------------------------|-------------------|
| tenant_id       | uuid                | NO       | —           | PK\*      | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…              |
| message_id      | uuid                | NO       | —           | PK        | ID global mensaje.                                                                   | msg…              |
| source_context  | varchar(80)         | NO       | —           | —         | Context emisor.                                                                      | EC02              |
| message_type    | varchar(160)        | NO       | —           | —         | Tipo/version.                                                                        | SessionChanged.v1 |
| payload_hash    | varchar(128)        | NO       | —           | —         | Hash.                                                                                | sha256:…          |
| state           | varchar(20)         | NO       | 'RECEIVED'  | CHECK     | RECEIVED/PROCESSING/PROCESSED/FAILED.                                                | PROCESSED         |
| received_at     | timestamptz         | NO       | now()       | —         | Recepción.                                                                           | …                 |
| processed_at    | timestamptz         | YES      | NULL        | —         | Fin.                                                                                 | …                 |
| last_error_code | varchar(100)        | YES      | NULL        | —         | Error.                                                                               | CONTRACT_INVALID  |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**message_id —** ID global mensaje. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: msg….

**source_context —** Context emisor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EC02.

**message_type —** Tipo/version. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: SessionChanged.v1.

**payload_hash —** Hash. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**state —** RECEIVED/PROCESSING/PROCESSED/FAILED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'RECEIVED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PROCESSED.

**received_at —** Recepción. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**processed_at —** Fin. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**last_error_code —** Error. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: CONTRACT_INVALID.

### Constraints físicos implementables

| **Nombre físico**         | **Tipo** | **Definición/expresión**                                | **Error que impide**   |
|---------------------------|----------|---------------------------------------------------------|------------------------|
| **pk_ec05_inbox_message** | PK       | (tenant_id, message_id)                                 | Dedup tenant-aware.    |
| **ck_ec05_inbox_state**   | CHECK    | state IN ('RECEIVED','PROCESSING','PROCESSED','FAILED') | Estado inválido.       |
| **ix_ec05_inbox_state**   | INDEX    | (tenant_id, state, received_at)                         | Reprocesamiento lento. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Dedup tenant-aware.; Estado inválido.; Reprocesamiento lento. |
|---------------------------------------------------------------------------------------------------|

## 12.27 ec05_operation_status

**QUÉ REPRESENTA —** Estado consultable de operaciones asíncronas 202: provisioning/sync masivo, publication pack, importación, reconciliación y content processing.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate técnico expuesto por GET /operations/{id}. Frontend nunca interpreta 202 como efecto confirmado; polling/backoff/push hasta terminal.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lifecycle async y UNKNOWN_EFFECT. No reemplaza idempotency/outbox.

| **Campo**        | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                      | **Ejemplo**         |
|------------------|---------------------|----------|-------------------|-----------|--------------------------------------------------------------------------------------|---------------------|
| tenant_id        | uuid                | NO       | —                 | PK\*      | Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. | 8a6…                |
| operation_id     | uuid                | NO       | gen_random_uuid() | PK        | ID operación.                                                                        | op…                 |
| operation_type   | varchar(100)        | NO       | —                 | —         | Tipo.                                                                                | PROVISION_LMS_SPACE |
| resource_ref     | varchar(200)        | YES      | NULL              | —         | Recurso.                                                                             | plan:tpr…           |
| state            | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED.                           | RUNNING             |
| progress_current | bigint              | YES      | NULL              | CHECK     | Avance.                                                                              | 3                   |
| progress_total   | bigint              | YES      | NULL              | CHECK     | Total.                                                                               | 10                  |
| result_json      | jsonb               | YES      | NULL              | CHECK     | Resultado acotado.                                                                   | {"provisioned":9}   |
| error_code       | varchar(100)        | YES      | NULL              | —         | Reason terminal.                                                                     | …                   |
| correlation_id   | uuid                | NO       | —                 | —         | Correlation.                                                                         | corr…               |
| started_at       | timestamptz         | YES      | NULL              | —         | Inicio.                                                                              | …                   |
| completed_at     | timestamptz         | YES      | NULL              | —         | Fin.                                                                                 | …                   |
| created_at       | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                            | 2026-09-09T20:00Z   |
| updated_at       | timestamptz         | NO       | now()             | —         | Última modificación autorizada del aggregate o metadata.                             | 2026-09-09T20:30Z   |
| version          | bigint              | NO       | 0                 | —         | Revisión optimista observable del aggregate completo; se expone como ETag.           | 4                   |

### Explicación individual de atributos

**tenant_id —** Tenant derivado de Security/TenantContext; participa en identidad física, FKs y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**operation_id —** ID operación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: op….

**operation_type —** Tipo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PROVISION_LMS_SPACE.

**resource_ref —** Recurso. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: plan:tpr….

**state —** PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: RUNNING.

**progress_current —** Avance. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 3.

**progress_total —** Total. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 10.

**result_json —** Resultado acotado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"provisioned":9}.

**error_code —** Reason terminal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ….

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**started_at —** Inicio. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**completed_at —** Fin. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T20:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión**                                                                                                                     | **Error que impide**                |
|--------------------------------|----------|----------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------|
| **pk_ec05_operation_status**   | PK       | (tenant_id, operation_id)                                                                                                                    | Identidad/cruce tenant.             |
| **ck_ec05_operation_state**    | CHECK    | state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED')                                                             | Estado inválido.                    |
| **ck_ec05_operation_progress** | CHECK    | (progress_current IS NULL AND progress_total IS NULL) OR (progress_current\>=0 AND progress_total\>=0 AND progress_current\<=progress_total) | Progreso incoherente.               |
| **ck_ec05_operation_result**   | CHECK    | result_json IS NULL OR jsonb_typeof(result_json) IN ('object','array')                                                                       | Resultado inválido.                 |
| **ix_ec05_operation_active**   | INDEX    | (tenant_id, updated_at) WHERE state IN ('PENDING','RUNNING','UNKNOWN_EFFECT')                                                                | Operaciones activas no observables. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Estado inválido.; Progreso incoherente.; Resultado inválido.; Operaciones activas no observables. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 13. DDL PostgreSQL completo — Flyway Ready

El siguiente baseline es ejecutable como migración inicial del bounded context EC-05. Incluye schema, 27 tablas, constraints, FKs internas tenant-aware/scope-aware, unique indexes parciales, state/lineage guards, inmutabilidad de snapshots, receipts append-only, aggregate revision, RLS y operational indexes. Los grants concretos dependen del ambiente, pero migrator/runtime/worker usan credenciales separadas y el runtime no puede BYPASSRLS.

| **CRITERIO FLYWAY —** Las migraciones productivas siguen expand/contract y compatibilidad N/N-1. Una migration aplicada no se modifica. Debe probarse desde cero y como upgrade desde N-1, incluyendo triggers/RLS/constraints y rollback operativo por roll-forward compatible. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

-- V1\_\_ec05_teaching_delivery_foundation.sql

-- PeopleU IA \| EC-05 \| PostgreSQL 16+ \| Flyway Ready

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE SCHEMA IF NOT EXISTS ec05;

CREATE OR REPLACE FUNCTION ec05.current_tenant_uuid() RETURNS uuid LANGUAGE sql STABLE AS \$\$ SELECT NULLIF(current_setting('peopleu.tenant_id', true), '')::uuid \$\$;

CREATE TABLE ec05.ec05_teaching_plan (

tenant_id uuid NOT NULL,

teaching_plan_id uuid DEFAULT gen_random_uuid() NOT NULL,

plan_code varchar(64) NOT NULL,

edition_ref uuid NOT NULL,

offering_ref uuid DEFAULT NULL,

program_version_ref uuid NOT NULL,

academic_owner_scope_ref uuid NOT NULL,

lifecycle_state varchar(24) DEFAULT 'DRAFT' NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_teaching_plan_revision (

tenant_id uuid NOT NULL,

teaching_plan_revision_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_id uuid NOT NULL,

revision_no integer NOT NULL,

previous_revision_id uuid DEFAULT NULL,

delivery_strategy_code varchar(80) NOT NULL,

instructional_model_code varchar(80) NOT NULL,

default_language_code varchar(16) DEFAULT 'es-BO' NOT NULL,

workload_policy_ref uuid DEFAULT NULL,

assignment_policy_ref uuid DEFAULT NULL,

content_policy_ref uuid DEFAULT NULL,

compliance_profile_ref uuid DEFAULT NULL,

valid_from date DEFAULT NULL,

valid_to date DEFAULT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

workflow_ref uuid DEFAULT NULL,

review_snapshot_hash varchar(128) DEFAULT NULL,

content_hash varchar(128) DEFAULT NULL,

published_at timestamptz DEFAULT NULL,

published_by_subject uuid DEFAULT NULL,

superseded_by_revision_id uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_teaching_plan_module (

tenant_id uuid NOT NULL,

teaching_plan_module_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

program_structure_item_ref uuid NOT NULL,

module_version_ref uuid NOT NULL,

delivery_mode_code varchar(80) NOT NULL,

instruction_mode_code varchar(80) DEFAULT NULL,

planned_contact_hours numeric(10,2) DEFAULT 0 NOT NULL,

planned_async_hours numeric(10,2) DEFAULT 0 NOT NULL,

sequence_no integer NOT NULL,

mandatory boolean DEFAULT true NOT NULL,

notes_text text DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_teaching_team (

tenant_id uuid NOT NULL,

teaching_team_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

scope_type varchar(16) NOT NULL,

teaching_plan_module_id uuid DEFAULT NULL,

session_ref uuid DEFAULT NULL,

team_code varchar(64) NOT NULL,

coordination_role_code varchar(80) DEFAULT NULL,

state varchar(24) DEFAULT 'PLANNED' NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_instructor_assignment (

tenant_id uuid NOT NULL,

instructor_assignment_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

teaching_team_id uuid NOT NULL,

teaching_plan_module_id uuid DEFAULT NULL,

session_ref uuid DEFAULT NULL,

assignment_scope varchar(16) NOT NULL,

person_ref uuid NOT NULL,

engagement_ref uuid DEFAULT NULL,

role_code varchar(80) NOT NULL,

responsibility_code varchar(80) DEFAULT NULL,

planned_hours numeric(10,2) DEFAULT 0 NOT NULL,

acceptance_required boolean DEFAULT true NOT NULL,

state varchar(24) DEFAULT 'PLANNED' NOT NULL,

effective_from timestamptz DEFAULT NULL,

effective_to timestamptz DEFAULT NULL,

replacement_for_assignment_id uuid DEFAULT NULL,

reason_code varchar(80) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_assignment_requirement (

tenant_id uuid NOT NULL,

assignment_requirement_id uuid DEFAULT gen_random_uuid() NOT NULL,

instructor_assignment_id uuid NOT NULL,

requirement_code varchar(80) NOT NULL,

requirement_type_code varchar(80) NOT NULL,

requirement_rule_ref uuid DEFAULT NULL,

mandatory boolean DEFAULT true NOT NULL,

revalidation_policy_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_assignment_requirement_result (

tenant_id uuid NOT NULL,

requirement_result_id uuid DEFAULT gen_random_uuid() NOT NULL,

assignment_requirement_id uuid NOT NULL,

status varchar(24) NOT NULL,

source_context varchar(80) NOT NULL,

source_decision_ref uuid DEFAULT NULL,

evaluated_by_subject uuid DEFAULT NULL,

evaluated_at timestamptz DEFAULT now() NOT NULL,

expires_at timestamptz DEFAULT NULL,

reason_code varchar(80) DEFAULT NULL,

evidence_ref uuid DEFAULT NULL,

decision_hash varchar(128) NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_assignment_invitation (

tenant_id uuid NOT NULL,

assignment_invitation_id uuid DEFAULT gen_random_uuid() NOT NULL,

instructor_assignment_id uuid NOT NULL,

token_hash varchar(128) NOT NULL,

token_last4 varchar(4) NOT NULL,

state varchar(20) DEFAULT 'ISSUED' NOT NULL,

issued_at timestamptz DEFAULT now() NOT NULL,

expires_at timestamptz NOT NULL,

opened_at timestamptz DEFAULT NULL,

responded_at timestamptz DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_assignment_acceptance_receipt (

tenant_id uuid NOT NULL,

acceptance_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,

instructor_assignment_id uuid NOT NULL,

assignment_invitation_id uuid DEFAULT NULL,

accepted_by_person_ref uuid NOT NULL,

terms_policy_ref uuid NOT NULL,

terms_hash varchar(128) NOT NULL,

assurance_level_code varchar(40) NOT NULL,

accepted_at timestamptz DEFAULT now() NOT NULL,

evidence_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_teaching_change_request (

tenant_id uuid NOT NULL,

teaching_change_request_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

change_type_code varchar(80) NOT NULL,

reason_code varchar(80) NOT NULL,

description_text text NOT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

workflow_ref uuid DEFAULT NULL,

requested_by_subject uuid NOT NULL,

requested_at timestamptz DEFAULT now() NOT NULL,

approved_by_subject uuid DEFAULT NULL,

approved_at timestamptz DEFAULT NULL,

applied_revision_id uuid DEFAULT NULL,

evidence_ref uuid DEFAULT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_instructional_unit_plan (

tenant_id uuid NOT NULL,

instructional_unit_plan_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

scope_type varchar(16) NOT NULL,

teaching_plan_module_id uuid DEFAULT NULL,

session_ref uuid DEFAULT NULL,

unit_code varchar(64) NOT NULL,

title varchar(240) NOT NULL,

objective_text text DEFAULT NULL,

method_code varchar(80) NOT NULL,

planned_minutes integer NOT NULL,

sequence_no integer NOT NULL,

outcome_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_learning_content_package (

tenant_id uuid NOT NULL,

content_package_id uuid DEFAULT gen_random_uuid() NOT NULL,

package_code varchar(64) NOT NULL,

content_family_code varchar(80) NOT NULL,

academic_owner_scope_ref uuid NOT NULL,

default_language_code varchar(16) DEFAULT 'es-BO' NOT NULL,

lifecycle_state varchar(24) DEFAULT 'DRAFT' NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_learning_content_package_version (

tenant_id uuid NOT NULL,

content_package_version_id uuid DEFAULT gen_random_uuid() NOT NULL,

content_package_id uuid NOT NULL,

version_no integer NOT NULL,

previous_version_id uuid DEFAULT NULL,

title varchar(240) NOT NULL,

description_text text DEFAULT NULL,

content_format_code varchar(80) NOT NULL,

language_code varchar(16) DEFAULT 'es-BO' NOT NULL,

accessibility_profile_ref uuid DEFAULT NULL,

content_policy_ref uuid DEFAULT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

workflow_ref uuid DEFAULT NULL,

review_snapshot_hash varchar(128) DEFAULT NULL,

content_hash varchar(128) DEFAULT NULL,

published_at timestamptz DEFAULT NULL,

published_by_subject uuid DEFAULT NULL,

superseded_by_version_id uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_learning_content_item (

tenant_id uuid NOT NULL,

content_item_id uuid DEFAULT gen_random_uuid() NOT NULL,

content_package_version_id uuid NOT NULL,

item_code varchar(64) NOT NULL,

item_type_code varchar(80) NOT NULL,

title varchar(240) NOT NULL,

document_ref uuid DEFAULT NULL,

external_resource_ref uuid DEFAULT NULL,

lms_resource_ref varchar(180) DEFAULT NULL,

estimated_minutes integer DEFAULT NULL,

sequence_no integer NOT NULL,

required boolean DEFAULT true NOT NULL,

content_checksum varchar(128) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_content_rights_binding (

tenant_id uuid NOT NULL,

content_rights_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,

content_item_id uuid NOT NULL,

rights_type_code varchar(80) NOT NULL,

rights_holder_ref uuid DEFAULT NULL,

license_code varchar(80) DEFAULT NULL,

permitted_use_code varchar(80) NOT NULL,

valid_from date DEFAULT NULL,

valid_to date DEFAULT NULL,

policy_ref uuid DEFAULT NULL,

evidence_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_content_release_rule (

tenant_id uuid NOT NULL,

content_release_rule_id uuid DEFAULT gen_random_uuid() NOT NULL,

content_package_version_id uuid NOT NULL,

content_item_id uuid NOT NULL,

release_trigger_code varchar(80) NOT NULL,

relative_offset_minutes integer DEFAULT NULL,

prerequisite_ref uuid DEFAULT NULL,

visibility_duration_minutes integer DEFAULT NULL,

policy_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_teaching_content_binding (

tenant_id uuid NOT NULL,

teaching_content_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

scope_type varchar(16) NOT NULL,

teaching_plan_module_id uuid DEFAULT NULL,

session_ref uuid DEFAULT NULL,

instructional_unit_plan_id uuid DEFAULT NULL,

content_item_id uuid NOT NULL,

purpose_code varchar(80) NOT NULL,

sequence_no integer NOT NULL,

required boolean DEFAULT true NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_external_learning_space_binding (

tenant_id uuid NOT NULL,

external_learning_space_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

scope_type varchar(16) NOT NULL,

teaching_plan_module_id uuid DEFAULT NULL,

session_ref uuid DEFAULT NULL,

provider_code varchar(80) NOT NULL,

space_type_code varchar(80) NOT NULL,

external_space_ref varchar(220) NOT NULL,

state varchar(24) NOT NULL,

access_policy_ref uuid DEFAULT NULL,

last_verified_at timestamptz DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_lms_provisioning_intent (

tenant_id uuid NOT NULL,

lms_provisioning_intent_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

scope_type varchar(16) NOT NULL,

teaching_plan_module_id uuid DEFAULT NULL,

session_ref uuid DEFAULT NULL,

provider_code varchar(80) NOT NULL,

action_code varchar(40) NOT NULL,

idempotency_key varchar(160) NOT NULL,

request_hash varchar(128) NOT NULL,

state varchar(24) DEFAULT 'PENDING' NOT NULL,

remote_operation_ref varchar(180) DEFAULT NULL,

operation_id uuid DEFAULT NULL,

correlation_id uuid NOT NULL,

sent_at timestamptz DEFAULT NULL,

completed_at timestamptz DEFAULT NULL,

last_error_code varchar(100) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec05.ec05_lms_provisioning_receipt (

tenant_id uuid NOT NULL,

lms_provisioning_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,

lms_provisioning_intent_id uuid NOT NULL,

effect_state varchar(24) NOT NULL,

provider_code varchar(80) NOT NULL,

external_space_ref varchar(220) DEFAULT NULL,

remote_operation_ref varchar(180) DEFAULT NULL,

request_hash varchar(128) NOT NULL,

response_hash varchar(128) DEFAULT NULL,

observed_at timestamptz DEFAULT now() NOT NULL,

evidence_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_recording_policy_binding (

tenant_id uuid NOT NULL,

recording_policy_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,

teaching_plan_revision_id uuid NOT NULL,

scope_type varchar(16) NOT NULL,

teaching_plan_module_id uuid DEFAULT NULL,

session_ref uuid DEFAULT NULL,

recording_required boolean DEFAULT false NOT NULL,

recording_policy_ref uuid NOT NULL,

consent_policy_ref uuid DEFAULT NULL,

retention_policy_ref uuid DEFAULT NULL,

publication_scope_code varchar(80) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_publication_receipt (

tenant_id uuid NOT NULL,

publication_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,

target_type varchar(40) NOT NULL,

target_ref uuid NOT NULL,

content_hash varchar(128) NOT NULL,

hash_algorithm varchar(32) DEFAULT 'SHA-256' NOT NULL,

canonical_schema_version integer DEFAULT 1 NOT NULL,

policy_snapshot_json jsonb DEFAULT '{}'::jsonb NOT NULL,

workflow_ref uuid DEFAULT NULL,

published_by_subject uuid NOT NULL,

assurance_level_code varchar(40) NOT NULL,

evidence_ref uuid DEFAULT NULL,

published_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_external_effect_receipt (

tenant_id uuid NOT NULL,

effect_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,

context_code varchar(40) NOT NULL,

operation_name varchar(120) NOT NULL,

local_resource_ref varchar(180) NOT NULL,

remote_operation_ref varchar(180) DEFAULT NULL,

idempotency_key varchar(160) DEFAULT NULL,

request_hash varchar(128) NOT NULL,

effect_state varchar(24) NOT NULL,

response_hash varchar(128) DEFAULT NULL,

correlation_id uuid NOT NULL,

observed_at timestamptz DEFAULT now() NOT NULL,

reconciled_at timestamptz DEFAULT NULL,

evidence_ref uuid DEFAULT NULL

);

CREATE TABLE ec05.ec05_command_idempotency (

tenant_id uuid NOT NULL,

idempotency_id uuid DEFAULT gen_random_uuid() NOT NULL,

idempotency_key varchar(160) NOT NULL,

command_name varchar(120) NOT NULL,

request_hash varchar(128) NOT NULL,

state varchar(24) DEFAULT 'IN_PROGRESS' NOT NULL,

owner_id varchar(120) DEFAULT NULL,

lease_until timestamptz DEFAULT NULL,

response_status integer DEFAULT NULL,

response_json jsonb DEFAULT NULL,

resource_ref varchar(200) DEFAULT NULL,

last_error_code varchar(100) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec05.ec05_outbox_event (

tenant_id uuid NOT NULL,

event_id uuid DEFAULT gen_random_uuid() NOT NULL,

aggregate_type varchar(100) NOT NULL,

aggregate_id uuid NOT NULL,

event_type varchar(160) NOT NULL,

schema_version integer DEFAULT 1 NOT NULL,

payload_json jsonb NOT NULL,

correlation_id uuid NOT NULL,

causation_id uuid DEFAULT NULL,

occurred_at timestamptz DEFAULT now() NOT NULL,

state varchar(20) DEFAULT 'PENDING' NOT NULL,

owner_id varchar(120) DEFAULT NULL,

lease_until timestamptz DEFAULT NULL,

attempt_count integer DEFAULT 0 NOT NULL,

next_attempt_at timestamptz DEFAULT now() NOT NULL,

delivered_at timestamptz DEFAULT NULL,

last_error_code varchar(100) DEFAULT NULL

);

CREATE TABLE ec05.ec05_inbox_message (

tenant_id uuid NOT NULL,

message_id uuid NOT NULL,

source_context varchar(80) NOT NULL,

message_type varchar(160) NOT NULL,

payload_hash varchar(128) NOT NULL,

state varchar(20) DEFAULT 'RECEIVED' NOT NULL,

received_at timestamptz DEFAULT now() NOT NULL,

processed_at timestamptz DEFAULT NULL,

last_error_code varchar(100) DEFAULT NULL

);

CREATE TABLE ec05.ec05_operation_status (

tenant_id uuid NOT NULL,

operation_id uuid DEFAULT gen_random_uuid() NOT NULL,

operation_type varchar(100) NOT NULL,

resource_ref varchar(200) DEFAULT NULL,

state varchar(24) DEFAULT 'PENDING' NOT NULL,

progress_current bigint DEFAULT NULL,

progress_total bigint DEFAULT NULL,

result_json jsonb DEFAULT NULL,

error_code varchar(100) DEFAULT NULL,

correlation_id uuid NOT NULL,

started_at timestamptz DEFAULT NULL,

completed_at timestamptz DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

ALTER TABLE ec05.ec05_teaching_plan ADD CONSTRAINT pk_ec05_teaching_plan PRIMARY KEY (tenant_id, teaching_plan_id);

ALTER TABLE ec05.ec05_teaching_plan ADD CONSTRAINT uq_ec05_teaching_plan_code UNIQUE (tenant_id, plan_code);

ALTER TABLE ec05.ec05_teaching_plan ADD CONSTRAINT uq_ec05_teaching_plan_edition UNIQUE (tenant_id, edition_ref);

ALTER TABLE ec05.ec05_teaching_plan ADD CONSTRAINT ck_ec05_teaching_plan_state CHECK (lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED'));

CREATE INDEX ix_ec05_teaching_plan_owner ON ec05.ec05_teaching_plan (tenant_id, academic_owner_scope_ref, lifecycle_state);

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT pk_ec05_teaching_plan_revision PRIMARY KEY (tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT uq_ec05_tpr_no UNIQUE (tenant_id, teaching_plan_id, revision_no);

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT uq_ec05_tpr_scope UNIQUE (tenant_id, teaching_plan_id, teaching_plan_revision_id);

CREATE UNIQUE INDEX uq_ec05_tpr_single_published ON ec05.ec05_teaching_plan_revision (tenant_id, teaching_plan_id) WHERE state='PUBLISHED';

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT ck_ec05_tpr_no CHECK (revision_no \> 0);

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT ck_ec05_tpr_dates CHECK (valid_to IS NULL OR valid_from IS NULL OR valid_to\>=valid_from);

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT ck_ec05_tpr_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID'));

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT ck_ec05_tpr_publish CHECK (state NOT IN ('SCHEDULED','PUBLISHED','SUPERSEDED') OR (content_hash IS NOT NULL AND published_at IS NOT NULL AND published_by_subject IS NOT NULL));

ALTER TABLE ec05.ec05_teaching_plan_module ADD CONSTRAINT pk_ec05_teaching_plan_module PRIMARY KEY (tenant_id, teaching_plan_module_id);

ALTER TABLE ec05.ec05_teaching_plan_module ADD CONSTRAINT uq_ec05_tpm_scope UNIQUE (tenant_id, teaching_plan_revision_id, teaching_plan_module_id);

ALTER TABLE ec05.ec05_teaching_plan_module ADD CONSTRAINT uq_ec05_tpm_program_item UNIQUE (tenant_id, teaching_plan_revision_id, program_structure_item_ref);

ALTER TABLE ec05.ec05_teaching_plan_module ADD CONSTRAINT uq_ec05_tpm_sequence UNIQUE (tenant_id, teaching_plan_revision_id, sequence_no);

ALTER TABLE ec05.ec05_teaching_plan_module ADD CONSTRAINT ck_ec05_tpm_hours CHECK (planned_contact_hours\>=0 AND planned_async_hours\>=0 AND planned_contact_hours+planned_async_hours\>0);

ALTER TABLE ec05.ec05_teaching_plan_module ADD CONSTRAINT ck_ec05_tpm_sequence CHECK (sequence_no\>0);

ALTER TABLE ec05.ec05_teaching_team ADD CONSTRAINT pk_ec05_teaching_team PRIMARY KEY (tenant_id, teaching_team_id);

ALTER TABLE ec05.ec05_teaching_team ADD CONSTRAINT uq_ec05_team_code UNIQUE (tenant_id, teaching_plan_revision_id, team_code);

ALTER TABLE ec05.ec05_teaching_team ADD CONSTRAINT ck_ec05_team_scope CHECK ((scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL));

ALTER TABLE ec05.ec05_teaching_team ADD CONSTRAINT ck_ec05_team_state CHECK (state IN ('PLANNED','ACTIVE','COMPLETED','CANCELLED'));

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT pk_ec05_instructor_assignment PRIMARY KEY (tenant_id, instructor_assignment_id);

CREATE UNIQUE INDEX uq_ec05_ia_active_role ON ec05.ec05_instructor_assignment (tenant_id, teaching_plan_revision_id, assignment_scope, COALESCE(teaching_plan_module_id,'00000000-0000-0000-0000-000000000000'::uuid), COALESCE(session_ref,'00000000-0000-0000-0000-000000000000'::uuid), person_ref, role_code) WHERE state NOT IN ('REPLACED','CANCELLED','VOID');

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT ck_ec05_ia_scope CHECK ((assignment_scope='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (assignment_scope='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (assignment_scope='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL));

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT ck_ec05_ia_hours CHECK (planned_hours\>=0);

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT ck_ec05_ia_dates CHECK (effective_to IS NULL OR effective_from IS NULL OR effective_to\>=effective_from);

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT ck_ec05_ia_state CHECK (state IN ('PLANNED','INVITED','ACCEPTED','ACTIVE','COMPLETED','REPLACED','CANCELLED','VOID'));

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT ck_ec05_ia_no_self_replace CHECK (replacement_for_assignment_id IS NULL OR replacement_for_assignment_id\<\>instructor_assignment_id);

ALTER TABLE ec05.ec05_assignment_requirement ADD CONSTRAINT pk_ec05_assignment_requirement PRIMARY KEY (tenant_id, assignment_requirement_id);

ALTER TABLE ec05.ec05_assignment_requirement ADD CONSTRAINT uq_ec05_arq_code UNIQUE (tenant_id, instructor_assignment_id, requirement_code);

ALTER TABLE ec05.ec05_assignment_requirement_result ADD CONSTRAINT pk_ec05_assignment_requirement_result PRIMARY KEY (tenant_id, requirement_result_id);

ALTER TABLE ec05.ec05_assignment_requirement_result ADD CONSTRAINT ck_ec05_arr_status CHECK (status IN ('PASS','FAIL','REVIEW_REQUIRED','WAIVED','EXPIRED','UNKNOWN'));

ALTER TABLE ec05.ec05_assignment_requirement_result ADD CONSTRAINT ck_ec05_arr_dates CHECK (expires_at IS NULL OR expires_at\>=evaluated_at);

ALTER TABLE ec05.ec05_assignment_invitation ADD CONSTRAINT pk_ec05_assignment_invitation PRIMARY KEY (tenant_id, assignment_invitation_id);

ALTER TABLE ec05.ec05_assignment_invitation ADD CONSTRAINT uq_ec05_inv_token UNIQUE (tenant_id, token_hash);

CREATE UNIQUE INDEX uq_ec05_inv_active ON ec05.ec05_assignment_invitation (tenant_id, instructor_assignment_id) WHERE state IN ('ISSUED','OPENED');

ALTER TABLE ec05.ec05_assignment_invitation ADD CONSTRAINT ck_ec05_inv_state CHECK (state IN ('ISSUED','OPENED','ACCEPTED','DECLINED','EXPIRED','REVOKED'));

ALTER TABLE ec05.ec05_assignment_invitation ADD CONSTRAINT ck_ec05_inv_expiry CHECK (expires_at\>issued_at);

ALTER TABLE ec05.ec05_assignment_acceptance_receipt ADD CONSTRAINT pk_ec05_acceptance_receipt PRIMARY KEY (tenant_id, acceptance_receipt_id);

ALTER TABLE ec05.ec05_assignment_acceptance_receipt ADD CONSTRAINT uq_ec05_aar_assignment UNIQUE (tenant_id, instructor_assignment_id);

ALTER TABLE ec05.ec05_teaching_change_request ADD CONSTRAINT pk_ec05_change_request PRIMARY KEY (tenant_id, teaching_change_request_id);

ALTER TABLE ec05.ec05_teaching_change_request ADD CONSTRAINT ck_ec05_tcr_state CHECK (state IN ('DRAFT','SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','CANCELLED'));

ALTER TABLE ec05.ec05_teaching_change_request ADD CONSTRAINT ck_ec05_tcr_approval CHECK (state NOT IN ('APPROVED','APPLIED') OR (approved_by_subject IS NOT NULL AND approved_at IS NOT NULL));

ALTER TABLE ec05.ec05_instructional_unit_plan ADD CONSTRAINT pk_ec05_unit_plan PRIMARY KEY (tenant_id, instructional_unit_plan_id);

ALTER TABLE ec05.ec05_instructional_unit_plan ADD CONSTRAINT uq_ec05_iup_code UNIQUE (tenant_id, teaching_plan_revision_id, unit_code);

ALTER TABLE ec05.ec05_instructional_unit_plan ADD CONSTRAINT ck_ec05_iup_scope CHECK ((scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL));

ALTER TABLE ec05.ec05_instructional_unit_plan ADD CONSTRAINT ck_ec05_iup_minutes CHECK (planned_minutes\>0);

ALTER TABLE ec05.ec05_instructional_unit_plan ADD CONSTRAINT ck_ec05_iup_sequence CHECK (sequence_no\>0);

ALTER TABLE ec05.ec05_learning_content_package ADD CONSTRAINT pk_ec05_content_package PRIMARY KEY (tenant_id, content_package_id);

ALTER TABLE ec05.ec05_learning_content_package ADD CONSTRAINT uq_ec05_content_package_code UNIQUE (tenant_id, package_code);

ALTER TABLE ec05.ec05_learning_content_package ADD CONSTRAINT ck_ec05_content_package_state CHECK (lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED'));

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT pk_ec05_content_version PRIMARY KEY (tenant_id, content_package_version_id);

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT uq_ec05_content_version_no UNIQUE (tenant_id, content_package_id, version_no);

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT uq_ec05_content_version_scope UNIQUE (tenant_id, content_package_id, content_package_version_id);

CREATE UNIQUE INDEX uq_ec05_content_single_published ON ec05.ec05_learning_content_package_version (tenant_id, content_package_id) WHERE state='PUBLISHED';

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT ck_ec05_cpv_no CHECK (version_no\>0);

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT ck_ec05_cpv_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID'));

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT ck_ec05_cpv_publish CHECK (state NOT IN ('SCHEDULED','PUBLISHED','SUPERSEDED') OR (content_hash IS NOT NULL AND published_at IS NOT NULL AND published_by_subject IS NOT NULL));

ALTER TABLE ec05.ec05_learning_content_item ADD CONSTRAINT pk_ec05_content_item PRIMARY KEY (tenant_id, content_item_id);

ALTER TABLE ec05.ec05_learning_content_item ADD CONSTRAINT uq_ec05_ci_scope UNIQUE (tenant_id, content_package_version_id, content_item_id);

ALTER TABLE ec05.ec05_learning_content_item ADD CONSTRAINT uq_ec05_ci_code UNIQUE (tenant_id, content_package_version_id, item_code);

ALTER TABLE ec05.ec05_learning_content_item ADD CONSTRAINT uq_ec05_ci_sequence UNIQUE (tenant_id, content_package_version_id, sequence_no);

ALTER TABLE ec05.ec05_learning_content_item ADD CONSTRAINT ck_ec05_ci_target CHECK ((document_ref IS NOT NULL)::int + (external_resource_ref IS NOT NULL)::int + (lms_resource_ref IS NOT NULL)::int = 1);

ALTER TABLE ec05.ec05_learning_content_item ADD CONSTRAINT ck_ec05_ci_minutes CHECK (estimated_minutes IS NULL OR estimated_minutes\>0);

ALTER TABLE ec05.ec05_learning_content_item ADD CONSTRAINT ck_ec05_ci_sequence CHECK (sequence_no\>0);

ALTER TABLE ec05.ec05_content_rights_binding ADD CONSTRAINT pk_ec05_rights_binding PRIMARY KEY (tenant_id, content_rights_binding_id);

ALTER TABLE ec05.ec05_content_rights_binding ADD CONSTRAINT ck_ec05_crb_dates CHECK (valid_to IS NULL OR valid_from IS NULL OR valid_to\>=valid_from);

ALTER TABLE ec05.ec05_content_release_rule ADD CONSTRAINT pk_ec05_release_rule PRIMARY KEY (tenant_id, content_release_rule_id);

ALTER TABLE ec05.ec05_content_release_rule ADD CONSTRAINT uq_ec05_rr_item UNIQUE (tenant_id, content_item_id);

ALTER TABLE ec05.ec05_content_release_rule ADD CONSTRAINT ck_ec05_rr_duration CHECK (visibility_duration_minutes IS NULL OR visibility_duration_minutes\>0);

ALTER TABLE ec05.ec05_teaching_content_binding ADD CONSTRAINT pk_ec05_teaching_content_binding PRIMARY KEY (tenant_id, teaching_content_binding_id);

ALTER TABLE ec05.ec05_teaching_content_binding ADD CONSTRAINT ck_ec05_tcb_scope CHECK ((scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL AND instructional_unit_plan_id IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL AND instructional_unit_plan_id IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL AND instructional_unit_plan_id IS NULL) OR (scope_type='UNIT' AND teaching_plan_module_id IS NULL AND session_ref IS NULL AND instructional_unit_plan_id IS NOT NULL));

ALTER TABLE ec05.ec05_teaching_content_binding ADD CONSTRAINT ck_ec05_tcb_sequence CHECK (sequence_no\>0);

CREATE UNIQUE INDEX uq_ec05_tcb_order ON ec05.ec05_teaching_content_binding (tenant_id, teaching_plan_revision_id, scope_type, COALESCE(teaching_plan_module_id,'00000000-0000-0000-0000-000000000000'::uuid), COALESCE(session_ref,'00000000-0000-0000-0000-000000000000'::uuid), COALESCE(instructional_unit_plan_id,'00000000-0000-0000-0000-000000000000'::uuid), sequence_no);

ALTER TABLE ec05.ec05_external_learning_space_binding ADD CONSTRAINT pk_ec05_external_space PRIMARY KEY (tenant_id, external_learning_space_binding_id);

ALTER TABLE ec05.ec05_external_learning_space_binding ADD CONSTRAINT uq_ec05_els_remote UNIQUE (tenant_id, provider_code, external_space_ref);

ALTER TABLE ec05.ec05_external_learning_space_binding ADD CONSTRAINT ck_ec05_els_scope CHECK ((scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL));

ALTER TABLE ec05.ec05_external_learning_space_binding ADD CONSTRAINT ck_ec05_els_state CHECK (state IN ('PROVISIONED','ACTIVE','SUSPENDED','ARCHIVED','UNKNOWN_EFFECT'));

ALTER TABLE ec05.ec05_lms_provisioning_intent ADD CONSTRAINT pk_ec05_lms_intent PRIMARY KEY (tenant_id, lms_provisioning_intent_id);

ALTER TABLE ec05.ec05_lms_provisioning_intent ADD CONSTRAINT uq_ec05_lpi_idempotency UNIQUE (tenant_id, idempotency_key);

ALTER TABLE ec05.ec05_lms_provisioning_intent ADD CONSTRAINT ck_ec05_lpi_scope CHECK ((scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL));

ALTER TABLE ec05.ec05_lms_provisioning_intent ADD CONSTRAINT ck_ec05_lpi_action CHECK (action_code IN ('CREATE','UPDATE','SYNC','SUSPEND','ARCHIVE'));

ALTER TABLE ec05.ec05_lms_provisioning_intent ADD CONSTRAINT ck_ec05_lpi_state CHECK (state IN ('PENDING','SENT','CONFIRMED','FAILED','UNKNOWN_EFFECT','CANCELLED'));

CREATE INDEX ix_ec05_lpi_unknown ON ec05.ec05_lms_provisioning_intent (tenant_id, updated_at) WHERE state='UNKNOWN_EFFECT';

ALTER TABLE ec05.ec05_lms_provisioning_receipt ADD CONSTRAINT pk_ec05_lms_receipt PRIMARY KEY (tenant_id, lms_provisioning_receipt_id);

ALTER TABLE ec05.ec05_lms_provisioning_receipt ADD CONSTRAINT ck_ec05_lpr_state CHECK (effect_state IN ('CONFIRMED','REJECTED','UNKNOWN_EFFECT','NOT_APPLIED'));

ALTER TABLE ec05.ec05_recording_policy_binding ADD CONSTRAINT pk_ec05_recording_binding PRIMARY KEY (tenant_id, recording_policy_binding_id);

ALTER TABLE ec05.ec05_recording_policy_binding ADD CONSTRAINT ck_ec05_rpb_scope CHECK ((scope_type='PLAN' AND teaching_plan_module_id IS NULL AND session_ref IS NULL) OR (scope_type='MODULE' AND teaching_plan_module_id IS NOT NULL AND session_ref IS NULL) OR (scope_type='SESSION' AND teaching_plan_module_id IS NULL AND session_ref IS NOT NULL));

ALTER TABLE ec05.ec05_publication_receipt ADD CONSTRAINT pk_ec05_publication_receipt PRIMARY KEY (tenant_id, publication_receipt_id);

ALTER TABLE ec05.ec05_publication_receipt ADD CONSTRAINT uq_ec05_pub_target_hash UNIQUE (tenant_id, target_type, target_ref, content_hash);

ALTER TABLE ec05.ec05_publication_receipt ADD CONSTRAINT ck_ec05_pub_target CHECK (target_type IN ('TEACHING_PLAN_REVISION','CONTENT_PACKAGE_VERSION'));

ALTER TABLE ec05.ec05_publication_receipt ADD CONSTRAINT ck_ec05_pub_schema CHECK (canonical_schema_version\>0);

ALTER TABLE ec05.ec05_publication_receipt ADD CONSTRAINT ck_ec05_pub_policy_json CHECK (jsonb_typeof(policy_snapshot_json)='object');

ALTER TABLE ec05.ec05_external_effect_receipt ADD CONSTRAINT pk_ec05_effect_receipt PRIMARY KEY (tenant_id, effect_receipt_id);

ALTER TABLE ec05.ec05_external_effect_receipt ADD CONSTRAINT ck_ec05_effect_state CHECK (effect_state IN ('CONFIRMED','REJECTED','UNKNOWN_EFFECT','NOT_APPLIED'));

CREATE INDEX ix_ec05_effect_unknown ON ec05.ec05_external_effect_receipt (tenant_id, context_code, observed_at) WHERE effect_state='UNKNOWN_EFFECT';

ALTER TABLE ec05.ec05_command_idempotency ADD CONSTRAINT pk_ec05_command_idempotency PRIMARY KEY (tenant_id, idempotency_id);

ALTER TABLE ec05.ec05_command_idempotency ADD CONSTRAINT uq_ec05_idempotency_key UNIQUE (tenant_id, idempotency_key);

ALTER TABLE ec05.ec05_command_idempotency ADD CONSTRAINT ck_ec05_idempotency_state CHECK (state IN ('IN_PROGRESS','SUCCEEDED','FAILED_RECOVERABLE','FAILED_FINAL'));

ALTER TABLE ec05.ec05_command_idempotency ADD CONSTRAINT ck_ec05_idempotency_response CHECK (response_status IS NULL OR response_status BETWEEN 100 AND 599);

ALTER TABLE ec05.ec05_command_idempotency ADD CONSTRAINT ck_ec05_idempotency_payload CHECK (response_json IS NULL OR jsonb_typeof(response_json) IN ('object','array'));

CREATE INDEX ix_ec05_idempotency_recovery ON ec05.ec05_command_idempotency (tenant_id, lease_until) WHERE state='IN_PROGRESS';

ALTER TABLE ec05.ec05_outbox_event ADD CONSTRAINT pk_ec05_outbox_event PRIMARY KEY (tenant_id, event_id);

ALTER TABLE ec05.ec05_outbox_event ADD CONSTRAINT ck_ec05_outbox_schema CHECK (schema_version\>0);

ALTER TABLE ec05.ec05_outbox_event ADD CONSTRAINT ck_ec05_outbox_payload CHECK (jsonb_typeof(payload_json)='object');

ALTER TABLE ec05.ec05_outbox_event ADD CONSTRAINT ck_ec05_outbox_state CHECK (state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED'));

ALTER TABLE ec05.ec05_outbox_event ADD CONSTRAINT ck_ec05_outbox_attempts CHECK (attempt_count\>=0);

CREATE INDEX ix_ec05_outbox_claim ON ec05.ec05_outbox_event (tenant_id, next_attempt_at, occurred_at) WHERE state IN ('PENDING','FAILED');

CREATE INDEX ix_ec05_outbox_reclaim ON ec05.ec05_outbox_event (tenant_id, lease_until) WHERE state='IN_FLIGHT';

ALTER TABLE ec05.ec05_inbox_message ADD CONSTRAINT pk_ec05_inbox_message PRIMARY KEY (tenant_id, message_id);

ALTER TABLE ec05.ec05_inbox_message ADD CONSTRAINT ck_ec05_inbox_state CHECK (state IN ('RECEIVED','PROCESSING','PROCESSED','FAILED'));

CREATE INDEX ix_ec05_inbox_state ON ec05.ec05_inbox_message (tenant_id, state, received_at);

ALTER TABLE ec05.ec05_operation_status ADD CONSTRAINT pk_ec05_operation_status PRIMARY KEY (tenant_id, operation_id);

ALTER TABLE ec05.ec05_operation_status ADD CONSTRAINT ck_ec05_operation_state CHECK (state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED'));

ALTER TABLE ec05.ec05_operation_status ADD CONSTRAINT ck_ec05_operation_progress CHECK ((progress_current IS NULL AND progress_total IS NULL) OR (progress_current\>=0 AND progress_total\>=0 AND progress_current\<=progress_total));

ALTER TABLE ec05.ec05_operation_status ADD CONSTRAINT ck_ec05_operation_result CHECK (result_json IS NULL OR jsonb_typeof(result_json) IN ('object','array'));

CREATE INDEX ix_ec05_operation_active ON ec05.ec05_operation_status (tenant_id, updated_at) WHERE state IN ('PENDING','RUNNING','UNKNOWN_EFFECT');

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT uq_ec05_ia_scope UNIQUE (tenant_id, teaching_plan_revision_id, instructor_assignment_id);

ALTER TABLE ec05.ec05_assignment_invitation ADD CONSTRAINT uq_ec05_inv_scope UNIQUE (tenant_id, instructor_assignment_id, assignment_invitation_id);

ALTER TABLE ec05.ec05_instructional_unit_plan ADD CONSTRAINT uq_ec05_iup_scope UNIQUE (tenant_id, teaching_plan_revision_id, instructional_unit_plan_id);

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT fk_ec05_tpr_plan FOREIGN KEY (tenant_id, teaching_plan_id) REFERENCES ec05.ec05_teaching_plan(tenant_id, teaching_plan_id);

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT fk_ec05_tpr_previous FOREIGN KEY (tenant_id, teaching_plan_id, previous_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_teaching_plan_revision ADD CONSTRAINT fk_ec05_tpr_superseded FOREIGN KEY (tenant_id, teaching_plan_id, superseded_by_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_teaching_plan_module ADD CONSTRAINT fk_ec05_tpm_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_teaching_team ADD CONSTRAINT fk_ec05_team_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_teaching_team ADD CONSTRAINT fk_ec05_team_module_scope FOREIGN KEY (tenant_id, teaching_plan_revision_id, teaching_plan_module_id) REFERENCES ec05.ec05_teaching_plan_module(tenant_id, teaching_plan_revision_id, teaching_plan_module_id);

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT fk_ec05_ia_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT fk_ec05_ia_team FOREIGN KEY (tenant_id, teaching_team_id) REFERENCES ec05.ec05_teaching_team(tenant_id, teaching_team_id);

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT fk_ec05_ia_module_scope FOREIGN KEY (tenant_id, teaching_plan_revision_id, teaching_plan_module_id) REFERENCES ec05.ec05_teaching_plan_module(tenant_id, teaching_plan_revision_id, teaching_plan_module_id);

ALTER TABLE ec05.ec05_instructor_assignment ADD CONSTRAINT fk_ec05_ia_replacement FOREIGN KEY (tenant_id, teaching_plan_revision_id, replacement_for_assignment_id) REFERENCES ec05.ec05_instructor_assignment(tenant_id, teaching_plan_revision_id, instructor_assignment_id);

ALTER TABLE ec05.ec05_assignment_requirement ADD CONSTRAINT fk_ec05_arq_assignment FOREIGN KEY (tenant_id, instructor_assignment_id) REFERENCES ec05.ec05_instructor_assignment(tenant_id, instructor_assignment_id);

ALTER TABLE ec05.ec05_assignment_requirement_result ADD CONSTRAINT fk_ec05_arr_requirement FOREIGN KEY (tenant_id, assignment_requirement_id) REFERENCES ec05.ec05_assignment_requirement(tenant_id, assignment_requirement_id);

ALTER TABLE ec05.ec05_assignment_invitation ADD CONSTRAINT fk_ec05_inv_assignment FOREIGN KEY (tenant_id, instructor_assignment_id) REFERENCES ec05.ec05_instructor_assignment(tenant_id, instructor_assignment_id);

ALTER TABLE ec05.ec05_assignment_acceptance_receipt ADD CONSTRAINT fk_ec05_aar_assignment FOREIGN KEY (tenant_id, instructor_assignment_id) REFERENCES ec05.ec05_instructor_assignment(tenant_id, instructor_assignment_id);

ALTER TABLE ec05.ec05_assignment_acceptance_receipt ADD CONSTRAINT fk_ec05_aar_invitation_scope FOREIGN KEY (tenant_id, instructor_assignment_id, assignment_invitation_id) REFERENCES ec05.ec05_assignment_invitation(tenant_id, instructor_assignment_id, assignment_invitation_id);

ALTER TABLE ec05.ec05_teaching_change_request ADD CONSTRAINT fk_ec05_tcr_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_teaching_change_request ADD CONSTRAINT fk_ec05_tcr_applied_revision FOREIGN KEY (tenant_id, applied_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_instructional_unit_plan ADD CONSTRAINT fk_ec05_iup_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_instructional_unit_plan ADD CONSTRAINT fk_ec05_iup_module_scope FOREIGN KEY (tenant_id, teaching_plan_revision_id, teaching_plan_module_id) REFERENCES ec05.ec05_teaching_plan_module(tenant_id, teaching_plan_revision_id, teaching_plan_module_id);

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT fk_ec05_cpv_package FOREIGN KEY (tenant_id, content_package_id) REFERENCES ec05.ec05_learning_content_package(tenant_id, content_package_id);

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT fk_ec05_cpv_previous FOREIGN KEY (tenant_id, content_package_id, previous_version_id) REFERENCES ec05.ec05_learning_content_package_version(tenant_id, content_package_id, content_package_version_id);

ALTER TABLE ec05.ec05_learning_content_package_version ADD CONSTRAINT fk_ec05_cpv_superseded FOREIGN KEY (tenant_id, content_package_id, superseded_by_version_id) REFERENCES ec05.ec05_learning_content_package_version(tenant_id, content_package_id, content_package_version_id);

ALTER TABLE ec05.ec05_learning_content_item ADD CONSTRAINT fk_ec05_ci_version FOREIGN KEY (tenant_id, content_package_version_id) REFERENCES ec05.ec05_learning_content_package_version(tenant_id, content_package_version_id);

ALTER TABLE ec05.ec05_content_rights_binding ADD CONSTRAINT fk_ec05_crb_item FOREIGN KEY (tenant_id, content_item_id) REFERENCES ec05.ec05_learning_content_item(tenant_id, content_item_id);

ALTER TABLE ec05.ec05_content_release_rule ADD CONSTRAINT fk_ec05_rr_version FOREIGN KEY (tenant_id, content_package_version_id) REFERENCES ec05.ec05_learning_content_package_version(tenant_id, content_package_version_id);

ALTER TABLE ec05.ec05_content_release_rule ADD CONSTRAINT fk_ec05_rr_item_scope FOREIGN KEY (tenant_id, content_package_version_id, content_item_id) REFERENCES ec05.ec05_learning_content_item(tenant_id, content_package_version_id, content_item_id);

ALTER TABLE ec05.ec05_teaching_content_binding ADD CONSTRAINT fk_ec05_tcb_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_teaching_content_binding ADD CONSTRAINT fk_ec05_tcb_module_scope FOREIGN KEY (tenant_id, teaching_plan_revision_id, teaching_plan_module_id) REFERENCES ec05.ec05_teaching_plan_module(tenant_id, teaching_plan_revision_id, teaching_plan_module_id);

ALTER TABLE ec05.ec05_teaching_content_binding ADD CONSTRAINT fk_ec05_tcb_unit_scope FOREIGN KEY (tenant_id, teaching_plan_revision_id, instructional_unit_plan_id) REFERENCES ec05.ec05_instructional_unit_plan(tenant_id, teaching_plan_revision_id, instructional_unit_plan_id);

ALTER TABLE ec05.ec05_teaching_content_binding ADD CONSTRAINT fk_ec05_tcb_content FOREIGN KEY (tenant_id, content_item_id) REFERENCES ec05.ec05_learning_content_item(tenant_id, content_item_id);

ALTER TABLE ec05.ec05_external_learning_space_binding ADD CONSTRAINT fk_ec05_els_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_external_learning_space_binding ADD CONSTRAINT fk_ec05_els_module_scope FOREIGN KEY (tenant_id, teaching_plan_revision_id, teaching_plan_module_id) REFERENCES ec05.ec05_teaching_plan_module(tenant_id, teaching_plan_revision_id, teaching_plan_module_id);

ALTER TABLE ec05.ec05_lms_provisioning_intent ADD CONSTRAINT fk_ec05_lpi_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_lms_provisioning_intent ADD CONSTRAINT fk_ec05_lpi_module_scope FOREIGN KEY (tenant_id, teaching_plan_revision_id, teaching_plan_module_id) REFERENCES ec05.ec05_teaching_plan_module(tenant_id, teaching_plan_revision_id, teaching_plan_module_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec05.ec05_lms_provisioning_intent ADD CONSTRAINT fk_ec05_lpi_operation FOREIGN KEY (tenant_id, operation_id) REFERENCES ec05.ec05_operation_status(tenant_id, operation_id);

ALTER TABLE ec05.ec05_lms_provisioning_receipt ADD CONSTRAINT fk_ec05_lpr_intent FOREIGN KEY (tenant_id, lms_provisioning_intent_id) REFERENCES ec05.ec05_lms_provisioning_intent(tenant_id, lms_provisioning_intent_id);

ALTER TABLE ec05.ec05_recording_policy_binding ADD CONSTRAINT fk_ec05_rpb_revision FOREIGN KEY (tenant_id, teaching_plan_revision_id) REFERENCES ec05.ec05_teaching_plan_revision(tenant_id, teaching_plan_revision_id);

ALTER TABLE ec05.ec05_recording_policy_binding ADD CONSTRAINT fk_ec05_rpb_module_scope FOREIGN KEY (tenant_id, teaching_plan_revision_id, teaching_plan_module_id) REFERENCES ec05.ec05_teaching_plan_module(tenant_id, teaching_plan_revision_id, teaching_plan_module_id);

CREATE OR REPLACE FUNCTION ec05.forbid_append_only_mutation() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

RAISE EXCEPTION 'EC05_APPEND_ONLY: % cannot be updated or deleted', TG_TABLE_NAME USING ERRCODE='23514';

END \$\$;

CREATE TRIGGER trg_ec05_assignment_requirement_result_append_only BEFORE UPDATE OR DELETE ON ec05.ec05_assignment_requirement_result FOR EACH ROW EXECUTE FUNCTION ec05.forbid_append_only_mutation();

CREATE TRIGGER trg_ec05_assignment_acceptance_receipt_append_only BEFORE UPDATE OR DELETE ON ec05.ec05_assignment_acceptance_receipt FOR EACH ROW EXECUTE FUNCTION ec05.forbid_append_only_mutation();

CREATE TRIGGER trg_ec05_lms_provisioning_receipt_append_only BEFORE UPDATE OR DELETE ON ec05.ec05_lms_provisioning_receipt FOR EACH ROW EXECUTE FUNCTION ec05.forbid_append_only_mutation();

CREATE TRIGGER trg_ec05_publication_receipt_append_only BEFORE UPDATE OR DELETE ON ec05.ec05_publication_receipt FOR EACH ROW EXECUTE FUNCTION ec05.forbid_append_only_mutation();

CREATE OR REPLACE FUNCTION ec05.guard_teaching_plan_revision() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE prev_no integer; next_no integer;

BEGIN

IF NEW.previous_revision_id = NEW.teaching_plan_revision_id OR NEW.superseded_by_revision_id = NEW.teaching_plan_revision_id THEN

RAISE EXCEPTION 'EC05_TPR_SELF_LINEAGE' USING ERRCODE='23514';

END IF;

IF NEW.previous_revision_id IS NOT NULL THEN

SELECT revision_no INTO prev_no FROM ec05.ec05_teaching_plan_revision WHERE tenant_id=NEW.tenant_id AND teaching_plan_id=NEW.teaching_plan_id AND teaching_plan_revision_id=NEW.previous_revision_id;

IF prev_no IS NULL OR prev_no \>= NEW.revision_no THEN RAISE EXCEPTION 'EC05_TPR_PREVIOUS_ORDER' USING ERRCODE='23514'; END IF;

END IF;

IF NEW.superseded_by_revision_id IS NOT NULL THEN

SELECT revision_no INTO next_no FROM ec05.ec05_teaching_plan_revision WHERE tenant_id=NEW.tenant_id AND teaching_plan_id=NEW.teaching_plan_id AND teaching_plan_revision_id=NEW.superseded_by_revision_id;

IF next_no IS NULL OR next_no \<= NEW.revision_no THEN RAISE EXCEPTION 'EC05_TPR_SUPERSEDE_ORDER' USING ERRCODE='23514'; END IF;

END IF;

IF TG_OP='UPDATE' AND NEW.state IS DISTINCT FROM OLD.state THEN

IF NOT (

(OLD.state='DRAFT' AND NEW.state IN ('IN_REVIEW','VOID')) OR

(OLD.state='IN_REVIEW' AND NEW.state IN ('DRAFT','APPROVED','VOID')) OR

(OLD.state='APPROVED' AND NEW.state IN ('DRAFT','SCHEDULED','PUBLISHED','VOID')) OR

(OLD.state='SCHEDULED' AND NEW.state IN ('PUBLISHED','VOID')) OR

(OLD.state='PUBLISHED' AND NEW.state IN ('SUPERSEDED','VOID'))

) THEN RAISE EXCEPTION 'EC05_TPR_INVALID_TRANSITION: % -\> %',OLD.state,NEW.state USING ERRCODE='23514'; END IF;

END IF;

IF TG_OP='UPDATE' AND OLD.state IN ('SCHEDULED','PUBLISHED','SUPERSEDED','VOID') AND NEW.state=OLD.state AND ROW(NEW.delivery_strategy_code,NEW.instructional_model_code,NEW.default_language_code,NEW.workload_policy_ref,NEW.assignment_policy_ref,NEW.content_policy_ref,NEW.compliance_profile_ref,NEW.valid_from,NEW.valid_to,NEW.content_hash) IS DISTINCT FROM ROW(OLD.delivery_strategy_code,OLD.instructional_model_code,OLD.default_language_code,OLD.workload_policy_ref,OLD.assignment_policy_ref,OLD.content_policy_ref,OLD.compliance_profile_ref,OLD.valid_from,OLD.valid_to,OLD.content_hash) THEN

RAISE EXCEPTION 'EC05_TPR_IMMUTABLE' USING ERRCODE='23514';

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec05_tpr_guard BEFORE INSERT OR UPDATE ON ec05.ec05_teaching_plan_revision FOR EACH ROW EXECUTE FUNCTION ec05.guard_teaching_plan_revision();

CREATE OR REPLACE FUNCTION ec05.guard_content_package_version() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE prev_no integer; next_no integer;

BEGIN

IF NEW.previous_version_id = NEW.content_package_version_id OR NEW.superseded_by_version_id = NEW.content_package_version_id THEN RAISE EXCEPTION 'EC05_CPV_SELF_LINEAGE' USING ERRCODE='23514'; END IF;

IF NEW.previous_version_id IS NOT NULL THEN

SELECT version_no INTO prev_no FROM ec05.ec05_learning_content_package_version WHERE tenant_id=NEW.tenant_id AND content_package_id=NEW.content_package_id AND content_package_version_id=NEW.previous_version_id;

IF prev_no IS NULL OR prev_no \>= NEW.version_no THEN RAISE EXCEPTION 'EC05_CPV_PREVIOUS_ORDER' USING ERRCODE='23514'; END IF;

END IF;

IF NEW.superseded_by_version_id IS NOT NULL THEN

SELECT version_no INTO next_no FROM ec05.ec05_learning_content_package_version WHERE tenant_id=NEW.tenant_id AND content_package_id=NEW.content_package_id AND content_package_version_id=NEW.superseded_by_version_id;

IF next_no IS NULL OR next_no \<= NEW.version_no THEN RAISE EXCEPTION 'EC05_CPV_SUPERSEDE_ORDER' USING ERRCODE='23514'; END IF;

END IF;

IF TG_OP='UPDATE' AND NEW.state IS DISTINCT FROM OLD.state THEN

IF NOT ((OLD.state='DRAFT' AND NEW.state IN ('IN_REVIEW','VOID')) OR (OLD.state='IN_REVIEW' AND NEW.state IN ('DRAFT','APPROVED','VOID')) OR (OLD.state='APPROVED' AND NEW.state IN ('DRAFT','SCHEDULED','PUBLISHED','VOID')) OR (OLD.state='SCHEDULED' AND NEW.state IN ('PUBLISHED','VOID')) OR (OLD.state='PUBLISHED' AND NEW.state IN ('SUPERSEDED','VOID'))) THEN

RAISE EXCEPTION 'EC05_CPV_INVALID_TRANSITION: % -\> %',OLD.state,NEW.state USING ERRCODE='23514';

END IF;

END IF;

IF TG_OP='UPDATE' AND OLD.state IN ('SCHEDULED','PUBLISHED','SUPERSEDED','VOID') AND NEW.state=OLD.state AND ROW(NEW.title,NEW.description_text,NEW.content_format_code,NEW.language_code,NEW.accessibility_profile_ref,NEW.content_policy_ref,NEW.content_hash) IS DISTINCT FROM ROW(OLD.title,OLD.description_text,OLD.content_format_code,OLD.language_code,OLD.accessibility_profile_ref,OLD.content_policy_ref,OLD.content_hash) THEN RAISE EXCEPTION 'EC05_CPV_IMMUTABLE' USING ERRCODE='23514'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec05_cpv_guard BEFORE INSERT OR UPDATE ON ec05.ec05_learning_content_package_version FOR EACH ROW EXECUTE FUNCTION ec05.guard_content_package_version();

CREATE OR REPLACE FUNCTION ec05.guard_plan_design_child() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE tid uuid; rid uuid; st varchar;

BEGIN

tid:=COALESCE(NEW.tenant_id,OLD.tenant_id); rid:=COALESCE(NEW.teaching_plan_revision_id,OLD.teaching_plan_revision_id);

SELECT state INTO st FROM ec05.ec05_teaching_plan_revision WHERE tenant_id=tid AND teaching_plan_revision_id=rid FOR UPDATE;

IF st IS NULL THEN RAISE EXCEPTION 'EC05_TPR_NOT_FOUND' USING ERRCODE='23503'; END IF;

IF st\<\>'DRAFT' THEN RAISE EXCEPTION 'EC05_PLAN_DESIGN_FROZEN: %',st USING ERRCODE='23514'; END IF;

UPDATE ec05.ec05_teaching_plan_revision SET version=version+1,updated_at=now() WHERE tenant_id=tid AND teaching_plan_revision_id=rid;

RETURN COALESCE(NEW,OLD);

END \$\$;

CREATE TRIGGER trg_ec05_teaching_plan_module_design_guard BEFORE INSERT OR UPDATE OR DELETE ON ec05.ec05_teaching_plan_module FOR EACH ROW EXECUTE FUNCTION ec05.guard_plan_design_child();

CREATE TRIGGER trg_ec05_instructional_unit_plan_design_guard BEFORE INSERT OR UPDATE OR DELETE ON ec05.ec05_instructional_unit_plan FOR EACH ROW EXECUTE FUNCTION ec05.guard_plan_design_child();

CREATE TRIGGER trg_ec05_teaching_content_binding_design_guard BEFORE INSERT OR UPDATE OR DELETE ON ec05.ec05_teaching_content_binding FOR EACH ROW EXECUTE FUNCTION ec05.guard_plan_design_child();

CREATE TRIGGER trg_ec05_recording_policy_binding_design_guard BEFORE INSERT OR UPDATE OR DELETE ON ec05.ec05_recording_policy_binding FOR EACH ROW EXECUTE FUNCTION ec05.guard_plan_design_child();

CREATE OR REPLACE FUNCTION ec05.guard_team_structure() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE st varchar;

BEGIN

SELECT state INTO st FROM ec05.ec05_teaching_plan_revision WHERE tenant_id=NEW.tenant_id AND teaching_plan_revision_id=NEW.teaching_plan_revision_id;

IF TG_OP='UPDATE' AND st\<\>'DRAFT' AND ROW(NEW.scope_type,NEW.teaching_plan_module_id,NEW.session_ref,NEW.team_code,NEW.coordination_role_code) IS DISTINCT FROM ROW(OLD.scope_type,OLD.teaching_plan_module_id,OLD.session_ref,OLD.team_code,OLD.coordination_role_code) THEN RAISE EXCEPTION 'EC05_TEAM_STRUCTURE_FROZEN' USING ERRCODE='23514'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec05_team_structure BEFORE UPDATE ON ec05.ec05_teaching_team FOR EACH ROW EXECUTE FUNCTION ec05.guard_team_structure();

CREATE OR REPLACE FUNCTION ec05.guard_instructor_assignment() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE pst varchar; ok boolean;

BEGIN

SELECT state INTO pst FROM ec05.ec05_teaching_plan_revision WHERE tenant_id=NEW.tenant_id AND teaching_plan_revision_id=NEW.teaching_plan_revision_id;

IF TG_OP='UPDATE' AND OLD.state IN ('ACCEPTED','ACTIVE','COMPLETED','REPLACED','CANCELLED','VOID') AND ROW(NEW.person_ref,NEW.engagement_ref,NEW.role_code,NEW.responsibility_code,NEW.assignment_scope,NEW.teaching_plan_module_id,NEW.session_ref) IS DISTINCT FROM ROW(OLD.person_ref,OLD.engagement_ref,OLD.role_code,OLD.responsibility_code,OLD.assignment_scope,OLD.teaching_plan_module_id,OLD.session_ref) THEN RAISE EXCEPTION 'EC05_ASSIGNMENT_IDENTITY_FROZEN' USING ERRCODE='23514'; END IF;

IF TG_OP='UPDATE' AND NEW.state IS DISTINCT FROM OLD.state THEN

ok := (OLD.state='PLANNED' AND NEW.state IN ('INVITED','ACCEPTED','CANCELLED','VOID')) OR (OLD.state='INVITED' AND NEW.state IN ('ACCEPTED','CANCELLED','VOID')) OR (OLD.state='ACCEPTED' AND NEW.state IN ('ACTIVE','REPLACED','CANCELLED','VOID')) OR (OLD.state='ACTIVE' AND NEW.state IN ('COMPLETED','REPLACED','CANCELLED','VOID'));

IF NOT ok THEN RAISE EXCEPTION 'EC05_ASSIGNMENT_INVALID_TRANSITION: % -\> %',OLD.state,NEW.state USING ERRCODE='23514'; END IF;

END IF;

IF NEW.state IN ('ACCEPTED','ACTIVE') AND NEW.acceptance_required THEN

IF NOT EXISTS (SELECT 1 FROM ec05.ec05_assignment_acceptance_receipt r WHERE r.tenant_id=NEW.tenant_id AND r.instructor_assignment_id=NEW.instructor_assignment_id) THEN RAISE EXCEPTION 'EC05_ASSIGNMENT_ACCEPTANCE_REQUIRED' USING ERRCODE='23514'; END IF;

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec05_assignment_guard BEFORE UPDATE ON ec05.ec05_instructor_assignment FOR EACH ROW EXECUTE FUNCTION ec05.guard_instructor_assignment();

CREATE OR REPLACE FUNCTION ec05.guard_assignment_invitation() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF TG_OP='UPDATE' AND NEW.state IS DISTINCT FROM OLD.state THEN

IF NOT ((OLD.state='ISSUED' AND NEW.state IN ('OPENED','ACCEPTED','DECLINED','EXPIRED','REVOKED')) OR (OLD.state='OPENED' AND NEW.state IN ('ACCEPTED','DECLINED','EXPIRED','REVOKED'))) THEN RAISE EXCEPTION 'EC05_INVITATION_INVALID_TRANSITION' USING ERRCODE='23514'; END IF;

END IF;

IF NEW.state IN ('ACCEPTED','DECLINED') AND now()\>NEW.expires_at THEN RAISE EXCEPTION 'EC05_INVITATION_EXPIRED' USING ERRCODE='23514'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec05_invitation_guard BEFORE UPDATE ON ec05.ec05_assignment_invitation FOR EACH ROW EXECUTE FUNCTION ec05.guard_assignment_invitation();

CREATE OR REPLACE FUNCTION ec05.guard_content_direct_child() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE tid uuid; vid uuid; st varchar;

BEGIN

tid:=COALESCE(NEW.tenant_id,OLD.tenant_id); vid:=COALESCE(NEW.content_package_version_id,OLD.content_package_version_id);

SELECT state INTO st FROM ec05.ec05_learning_content_package_version WHERE tenant_id=tid AND content_package_version_id=vid FOR UPDATE;

IF st\<\>'DRAFT' THEN RAISE EXCEPTION 'EC05_CONTENT_VERSION_FROZEN: %',st USING ERRCODE='23514'; END IF;

UPDATE ec05.ec05_learning_content_package_version SET version=version+1,updated_at=now() WHERE tenant_id=tid AND content_package_version_id=vid;

RETURN COALESCE(NEW,OLD);

END \$\$;

CREATE TRIGGER trg_ec05_learning_content_item_mutability BEFORE INSERT OR UPDATE OR DELETE ON ec05.ec05_learning_content_item FOR EACH ROW EXECUTE FUNCTION ec05.guard_content_direct_child();

CREATE TRIGGER trg_ec05_content_release_rule_mutability BEFORE INSERT OR UPDATE OR DELETE ON ec05.ec05_content_release_rule FOR EACH ROW EXECUTE FUNCTION ec05.guard_content_direct_child();

CREATE OR REPLACE FUNCTION ec05.guard_content_rights_child() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE tid uuid; iid uuid; vid uuid; st varchar;

BEGIN

tid:=COALESCE(NEW.tenant_id,OLD.tenant_id); iid:=COALESCE(NEW.content_item_id,OLD.content_item_id);

SELECT i.content_package_version_id,v.state INTO vid,st FROM ec05.ec05_learning_content_item i JOIN ec05.ec05_learning_content_package_version v ON v.tenant_id=i.tenant_id AND v.content_package_version_id=i.content_package_version_id WHERE i.tenant_id=tid AND i.content_item_id=iid FOR UPDATE OF v;

IF st\<\>'DRAFT' THEN RAISE EXCEPTION 'EC05_CONTENT_VERSION_FROZEN: %',st USING ERRCODE='23514'; END IF;

UPDATE ec05.ec05_learning_content_package_version SET version=version+1,updated_at=now() WHERE tenant_id=tid AND content_package_version_id=vid;

RETURN COALESCE(NEW,OLD);

END \$\$;

CREATE TRIGGER trg_ec05_rights_mutability BEFORE INSERT OR UPDATE OR DELETE ON ec05.ec05_content_rights_binding FOR EACH ROW EXECUTE FUNCTION ec05.guard_content_rights_child();

CREATE OR REPLACE FUNCTION ec05.validate_publication_receipt_target() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE h varchar;

BEGIN

IF NEW.target_type='TEACHING_PLAN_REVISION' THEN SELECT content_hash INTO h FROM ec05.ec05_teaching_plan_revision WHERE tenant_id=NEW.tenant_id AND teaching_plan_revision_id=NEW.target_ref;

ELSIF NEW.target_type='CONTENT_PACKAGE_VERSION' THEN SELECT content_hash INTO h FROM ec05.ec05_learning_content_package_version WHERE tenant_id=NEW.tenant_id AND content_package_version_id=NEW.target_ref;

END IF;

IF h IS NULL THEN RAISE EXCEPTION 'EC05_PUBLICATION_TARGET_NOT_FOUND_OR_UNPUBLISHED' USING ERRCODE='23503'; END IF;

IF h\<\>NEW.content_hash THEN RAISE EXCEPTION 'EC05_PUBLICATION_HASH_MISMATCH' USING ERRCODE='23514'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec05_publication_target BEFORE INSERT ON ec05.ec05_publication_receipt FOR EACH ROW EXECUTE FUNCTION ec05.validate_publication_receipt_target();

-- Defense-in-depth tenant isolation. Runtime roles must not own tables and must not have BYPASSRLS.

ALTER TABLE ec05.ec05_teaching_plan ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_teaching_plan FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_teaching_plan_tenant ON ec05.ec05_teaching_plan USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_teaching_plan_revision ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_teaching_plan_revision FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_teaching_plan_revision_tenant ON ec05.ec05_teaching_plan_revision USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_teaching_plan_module ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_teaching_plan_module FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_teaching_plan_module_tenant ON ec05.ec05_teaching_plan_module USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_teaching_team ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_teaching_team FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_teaching_team_tenant ON ec05.ec05_teaching_team USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_instructor_assignment ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_instructor_assignment FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_instructor_assignment_tenant ON ec05.ec05_instructor_assignment USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_assignment_requirement ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_assignment_requirement FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_assignment_requirement_tenant ON ec05.ec05_assignment_requirement USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_assignment_requirement_result ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_assignment_requirement_result FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_assignment_requirement_result_tenant ON ec05.ec05_assignment_requirement_result USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_assignment_invitation ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_assignment_invitation FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_assignment_invitation_tenant ON ec05.ec05_assignment_invitation USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_assignment_acceptance_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_assignment_acceptance_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_assignment_acceptance_receipt_tenant ON ec05.ec05_assignment_acceptance_receipt USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_teaching_change_request ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_teaching_change_request FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_teaching_change_request_tenant ON ec05.ec05_teaching_change_request USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_instructional_unit_plan ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_instructional_unit_plan FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_instructional_unit_plan_tenant ON ec05.ec05_instructional_unit_plan USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_learning_content_package ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_learning_content_package FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_learning_content_package_tenant ON ec05.ec05_learning_content_package USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_learning_content_package_version ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_learning_content_package_version FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_learning_content_package_version_tenant ON ec05.ec05_learning_content_package_version USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_learning_content_item ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_learning_content_item FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_learning_content_item_tenant ON ec05.ec05_learning_content_item USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_content_rights_binding ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_content_rights_binding FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_content_rights_binding_tenant ON ec05.ec05_content_rights_binding USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_content_release_rule ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_content_release_rule FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_content_release_rule_tenant ON ec05.ec05_content_release_rule USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_teaching_content_binding ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_teaching_content_binding FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_teaching_content_binding_tenant ON ec05.ec05_teaching_content_binding USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_external_learning_space_binding ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_external_learning_space_binding FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_external_learning_space_binding_tenant ON ec05.ec05_external_learning_space_binding USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_lms_provisioning_intent ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_lms_provisioning_intent FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_lms_provisioning_intent_tenant ON ec05.ec05_lms_provisioning_intent USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_lms_provisioning_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_lms_provisioning_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_lms_provisioning_receipt_tenant ON ec05.ec05_lms_provisioning_receipt USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_recording_policy_binding ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_recording_policy_binding FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_recording_policy_binding_tenant ON ec05.ec05_recording_policy_binding USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_publication_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_publication_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_publication_receipt_tenant ON ec05.ec05_publication_receipt USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_external_effect_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_external_effect_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_external_effect_receipt_tenant ON ec05.ec05_external_effect_receipt USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_command_idempotency ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_command_idempotency FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_command_idempotency_tenant ON ec05.ec05_command_idempotency USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_outbox_event ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_outbox_event FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_outbox_event_tenant ON ec05.ec05_outbox_event USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_inbox_message ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_inbox_message FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_inbox_message_tenant ON ec05.ec05_inbox_message USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

ALTER TABLE ec05.ec05_operation_status ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec05.ec05_operation_status FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec05_operation_status_tenant ON ec05.ec05_operation_status USING (tenant_id = ec05.current_tenant_uuid()) WITH CHECK (tenant_id = ec05.current_tenant_uuid());

-- Outbox multi-instance claim example:

-- SELECT event_id FROM ec05.ec05_outbox_event

-- WHERE tenant_id=ec05.current_tenant_uuid() AND state IN ('PENDING','FAILED') AND next_attempt_at\<=now()

-- ORDER BY occurred_at FOR UPDATE SKIP LOCKED LIMIT 100;

CREATE INDEX IF NOT EXISTS ix_ec05_assignment_person ON ec05.ec05_instructor_assignment(tenant_id,person_ref,state);

CREATE INDEX IF NOT EXISTS ix_ec05_plan_edition ON ec05.ec05_teaching_plan(tenant_id,edition_ref,lifecycle_state);

CREATE INDEX IF NOT EXISTS ix_ec05_content_item_type ON ec05.ec05_learning_content_item(tenant_id,item_type_code);

CREATE INDEX IF NOT EXISTS ix_ec05_external_space_state ON ec05.ec05_external_learning_space_binding(tenant_id,provider_code,state);

-- Required role invariant: migrator owns DDL; HTTP runtime has least privilege and NO BYPASSRLS; worker role is separate.

# 14. MongoDB y Redis

PostgreSQL es Source of Truth transaccional de EC-05. MongoDB y Redis son derivados/aceleradores. La pérdida de ambos no puede modificar TeachingPlanRevision, InstructorAssignment, ContentPackageVersion, rights, acceptance, provisioning receipts, idempotency ni outbox. La reconstrucción parte de PostgreSQL + eventos/contratos autorizados.

## 14.1 MongoDB — read models derivados

| **Read model**                   | **Uso**                                                            | **Fuente**                                    | **Regla de consistencia**                                |
|----------------------------------|--------------------------------------------------------------------|-----------------------------------------------|----------------------------------------------------------|
| **ec05_teaching_operations_rm**  | Vista por edición de plan, team readiness, assignments y espacios. | EC-05 + EC-02 refs                            | Eventual; commands revalidan PostgreSQL.                 |
| **ec05_instructor_workspace_rm** | Agenda/materiales/roles del instructor.                            | Assignments + EC-02 sessions + content refs   | PII minimizada; asOf visible.                            |
| **ec05_content_catalog_rm**      | Búsqueda por package/item/type/rights/accessibility.               | ContentPackage/Version + CT-05/18 projections | No reemplaza rights truth local ni document truth CT-05. |
| **ec05_lms_reconciliation_rm**   | Provision intents, spaces, UNKNOWN_EFFECT, last verify.            | Intents/receipts/bindings                     | No reemplaza receipts durables.                          |
| **ec05_readiness_rm**            | Readiness de teams, requirements, content y rights.                | EC-05 + dependency status                     | PARTIAL/STALE explícito.                                 |
| **ec05_audit_projection_rm**     | Lineage/replacements/publication evidence resumida.                | Events + audit refs                           | Audit oficial CT-10/evidence refs.                       |

| **REGLA MONGODB —** Una proyección STALE/PARTIAL/UNAVAILABLE nunca se interpreta como “sin problemas”. Publish, replace y provision revalidan las fuentes autoritativas requeridas. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 14.2 Redis — aceleración y coordinación técnica

| **Key/patrón**                          | **Propósito**                         | **TTL/estrategia**                | **Nunca debe hacer**                         |
|-----------------------------------------|---------------------------------------|-----------------------------------|----------------------------------------------|
| **ec05:plan:{tenant}:{revision}**       | Snapshot/read cache.                  | TTL corto + revision/contentHash. | Autorizar publish desde cache stale.         |
| **ec05:person:{tenant}:{person}**       | Lookup de display mínimo autorizado.  | TTL minutos; invalidate event.    | Convertirse en Person shadow.                |
| **ec05:content:{tenant}:{version}**     | Read acceleration de content catalog. | TTL/version-aware.                | Ser Source of Truth del contenido.           |
| **ec05:lms-status:{tenant}:{intent}**   | Cache de query-status remoto.         | TTL segundos; provenance.         | Resolver UNKNOWN_EFFECT sin receipt durable. |
| **ec05:rate:invite:{tenant}:{subject}** | Rate limit invitation/accept.         | Sliding window.                   | Sustituir token one-shot durable.            |
| **ec05:lock:bulk:{tenant}:{operation}** | Lock técnico de worker.               | Lease/fencing cuando aplica.      | Reemplazar idempotency/outbox lease DB.      |

# 15. Backend Java 21 / Spring Boot / Spring Modulith

EC-05 se implementa como módulo Spring Modulith dentro del monolito multimodelo PeopleU IA. Domain/Application desconocen JPA, HTTP y SDKs externos. Los adapters implementan ports hacia CT-01…18, IAM, RRHH/Procurement, EC-01/02/06/07/11 y cualquier proveedor externo exclusivamente mediante CT-18. ArchitectureTests bloquean imports/repositorios cross-context no autorizados.

## 15.1 Estructura de paquetes normativa

com.peopleu.ec.teachingdelivery

├── domain

│ ├── plan

│ ├── assignment

│ ├── content

│ ├── externalspace

│ └── shared

├── application

│ ├── command

│ ├── query

│ ├── policy

│ ├── port/in

│ └── port/out

├── adapter

│ ├── in/rest

│ ├── in/events

│ ├── out/persistence

│ ├── out/ct

│ ├── out/ec01

│ ├── out/ec02

│ ├── out/hr

│ ├── out/ct18

│ └── out/events

└── config

## 15.2 Aggregates y métodos de intención

| **Aggregate**                    | **Métodos de intención mínimos**                                                                                                  | **Invariante**                                 |
|----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------|
| **TeachingPlan**                 | createForEdition(), activate(), suspend(), retire()                                                                               | Una identidad por edition; no schedule local.  |
| **TeachingPlanRevision**         | addModule(), addUnit(), bindContent(), validate(), requestReview(), approve(), schedule(), publish(), supersede(), voidRevision() | Diseño mutable solo DRAFT; aggregate revision. |
| **TeachingTeam**                 | createScope(), activate(), complete(), cancel()                                                                                   | Scope estructural no cambia tras publish.      |
| **InstructorAssignment**         | plan(), invite(), accept(), activate(), complete(), replaceWith(), cancel(), voidAssignment()                                     | No overwrite person/role desde ACCEPTED.       |
| **AssignmentRequirement**        | define(), recordResult()                                                                                                          | Resultados append-only.                        |
| **ContentPackage**               | create(), activate(), suspend(), retire()                                                                                         | Business key estable.                          |
| **ContentPackageVersion**        | addItem(), bindRights(), setReleaseRule(), validate(), approve(), publish(), supersede(), voidVersion()                           | Snapshot inmutable desde SCHEDULED.            |
| **LmsProvisioningIntent**        | send(), confirm(), reject(), markUnknownEffect(), reconcile(), cancel()                                                           | No retry ciego.                                |
| **ExternalLearningSpaceBinding** | activate(), suspend(), archive(), markUnknown()                                                                                   | Remote truth observado, no asumido.            |

## 15.3 Ports de salida obligatorios

| **Port**                          | **Owner**        | **Contrato**                                         |
|-----------------------------------|------------------|------------------------------------------------------|
| **InstitutionScopePort**          | CT-01            | authorize tenant/scope.                              |
| **PolicyCatalogPort**             | CT-02            | PolicyVersion + roles/methods/rights/release codes.  |
| **TemporalSessionPort**           | CT-03/EC-02      | resolve session/time semantics.                      |
| **PersonPort**                    | CT-04            | resolve person/display/assurance without PII shadow. |
| **DocumentContentPort**           | CT-05            | document/evidence refs, hashes, retention.           |
| **WorkflowPort**                  | CT-06            | review/change/waiver approvals.                      |
| **NotificationPort**              | CT-07            | invitations/change notifications post-commit.        |
| **LocalizationPort**              | CT-08            | translation resources.                               |
| **IntegrationGovernancePort**     | CT-09            | contracts/schema versioning.                         |
| **AuditPrivacyPort**              | CT-10            | purpose/consent/audit/evidence.                      |
| **AnalyticsPort**                 | CT-11            | dataset/event facts.                                 |
| **AiAssistPort**                  | CT-12            | recommendations only.                                |
| **SchedulingPort**                | CT-13            | availability/solution refs; no local scheduling.     |
| **ResourcePort**                  | CT-14            | resource/reservation refs.                           |
| **EligibilityPort**               | CT-15            | assignment requirement decisions where applicable.   |
| **MigrationPort**                 | CT-16            | dry-run/promotion receipts.                          |
| **ExternalLearningEcosystemPort** | CT-18            | LMS/meeting/provision/query/reconcile.               |
| **ProgramDesignPort**             | EC-01            | ProgramVersion/ModuleVersion/outcomes.               |
| **EditionPort**                   | EC-02            | Edition/Offering/Session refs.                       |
| **EmploymentEngagementPort**      | RRHH/Procurement | engagement/status facts only.                        |

## 15.4 TenantContext + PostgreSQL RLS

Cada use case abre transacción, obtiene tenant del contexto autenticado y ejecuta SET LOCAL peopleu.tenant_id antes del repository access. HTTP runtime no es owner ni tiene BYPASSRLS. Workers configuran tenant por job/message y también quedan sujetos a RLS. QA ejecuta queries deliberadamente defectuosas para comprobar aislamiento.

@Transactional

public TeachingPlanRevision publish(PublishTeachingPlan cmd,

AggregateRevision expected) {

tenantSql.setLocal(authenticatedTenant());

var revision = planRevisionRepository.lockById(cmd.revisionId())

.orElseThrow(NotFound::new);

aggregateRevision.requireMatch(revision.version(), expected); // 412

var validation = validationService.validateForPublish(revision);

validation.requirePass();

revision.publish(clock.instant(), actor.subjectId());

publicationReceiptRepository.append(PublicationReceipt.from(revision));

outbox.append(TeachingPlanPublished.from(revision));

return revision;

}

## 15.5 Aggregate mutation protocol

- SET LOCAL tenant antes de cualquier query.

- SELECT … FOR UPDATE del root cuando se muta un child de snapshot.

- Comparar If-Match/expected revision antes de tocar child.

- Ejecutar método de intención; repositorios child no son APIs públicas de Application.

- Trigger bump del root en la misma transacción.

- Outbox/audit/idempotency participan en la misma unidad local de consistencia.

## 15.6 Assignment replacement protocol

| **Paso** | **Acción**                                                                                            | **Error que evita**                  |
|----------|-------------------------------------------------------------------------------------------------------|--------------------------------------|
| **1**    | Lock assignment anterior y validar estado ACCEPTED/ACTIVE.                                            | Replacement sobre terminal/unknown.  |
| **2**    | Resolver policy/workflow/change request si aplica.                                                    | Bypass de aprobación.                |
| **3**    | Crear nuevo assignment con replacement_for + Person/role/scope explícitos.                            | Overwrite destructivo.               |
| **4**    | Generar/revalidar requirements e invitation/acceptance.                                               | Activar docente no elegible.         |
| **5**    | Cuando nuevo assignment está listo, marcar anterior REPLACED y activar nuevo según calendario/policy. | Hueco o doble asignación silenciosa. |
| **6**    | Outbox + CT-07 + downstream reconciliation.                                                           | Consumers divergentes.               |

## 15.7 Provisioning remote-effect protocol

| **Etapa**              | **Contrato**                                                                            |
|------------------------|-----------------------------------------------------------------------------------------|
| **PREPARE**            | Crear LmsProvisioningIntent + Idempotency-Key + request_hash + OperationStatus.         |
| **SEND**               | CT-18 recibe command contractual; guardar remote_operation_ref cuando exista.           |
| **CONFIRMED**          | Crear append-only ProvisioningReceipt y ExternalLearningSpaceBinding.                   |
| **TIMEOUT after send** | Marcar UNKNOWN_EFFECT; no crear segundo intent ciegamente.                              |
| **RECONCILE**          | Query/status por idempotency/remote_operation_ref; resolver CONFIRMED o NOT_APPLIED.    |
| **RETRY**              | Solo después de demostrar NOT_APPLIED; reutilizar semántica idempotente según contrato. |

## 15.8 Persistencia/JPA

- @Version solo en roots/operational aggregates que exponen revisión; child snapshot bumps via DB/application contract.

- No usar cascade REMOVE sobre historia institucional.

- UUID + tenant_id en repositorios; prohibido findById(id) sin tenant scope salvo RLS verified abstraction.

- Mappings de jsonb solo para payload/evidence acotado; facts de dominio importantes tienen columnas tipadas.

- Instant/OffsetDateTime para timestamptz; LocalDate solo para vigencia semántica de fecha.

- BigDecimal para horas; nunca float/double.

## 15.9 Architecture tests

- domain no depende de org.springframework.\*, JPA, HTTP o CT adapters.

- EC-05 persistence no importa entidades/repositorios EC-01/02/CT/RRHH.

- Solo adapter/out/ct18 puede invocar contrato de ecosistema externo.

- Controllers dependen de application ports, no repositories.

- Cross-module reads/writes directos fallan build mediante ArchUnit/Modulith verification.

# 16. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

Baseline /api/v1/ec/teaching-delivery. OpenAPI es contrato ejecutable. tenant_id no aparece como campo confiable del body. Mutaciones de aggregate editable usan If-Match; commands sensibles además Idempotency-Key. PATCH solo admite metadata escalar expresamente permitida.

## 16.1 Teaching Plan API

| **Método** | **Endpoint**                              | **Uso**                       | **Headers/resultado**                |
|------------|-------------------------------------------|-------------------------------|--------------------------------------|
| **POST**   | /teaching-plans                           | Crear plan por edition        | Idempotency-Key →201 + ETag          |
| **GET**    | /teaching-plans                           | Listar con filtros/paginación | 200 Page                             |
| **GET**    | /teaching-plans/{id}                      | Detalle                       | 200 + ETag                           |
| **POST**   | /teaching-plans/{id}/revisions            | Crear/clone revision          | Idempotency-Key →201                 |
| **GET**    | /teaching-plans/{id}/revisions            | Listar revisions              | 200 Page                             |
| **GET**    | /plan-revisions/{id}                      | Snapshot detalle              | 200 + ETag                           |
| **POST**   | /plan-revisions/{id}/validate             | Preflight                     | If-Match →200 ValidationReport       |
| **POST**   | /plan-revisions/{id}/review-requests      | Solicitar review              | If-Match + Idempotency-Key →202/200  |
| **POST**   | /plan-revisions/{id}/schedule-publication | SCHEDULED                     | If-Match + Idempotency-Key           |
| **POST**   | /plan-revisions/{id}/publish              | Publicar                      | If-Match + Idempotency-Key + step-up |
| **POST**   | /plan-revisions/{id}/void                 | Void gobernado                | If-Match + Idempotency-Key + reason  |
| **GET**    | /plan-revisions/{id}/diff?against=        | Diff                          | 200                                  |

## 16.2 Modules, units, teams y assignments

| **Método** | **Endpoint**                                      | **Uso**                               |
|------------|---------------------------------------------------|---------------------------------------|
| **POST**   | /plan-revisions/{id}/modules                      | Agregar módulo contextual.            |
| **PUT**    | /plan-revisions/{id}/modules/{moduleId}           | Editar en DRAFT con If-Match root.    |
| **DELETE** | /plan-revisions/{id}/modules/{moduleId}           | Eliminar solo DRAFT.                  |
| **POST**   | /plan-revisions/{id}/instructional-units          | Crear unit.                           |
| **PUT**    | /plan-revisions/{id}/instructional-units/{unitId} | Editar unit DRAFT.                    |
| **POST**   | /plan-revisions/{id}/teams                        | Crear team.                           |
| **GET**    | /plan-revisions/{id}/teams                        | Listar teams/readiness.               |
| **POST**   | /plan-revisions/{id}/assignments                  | Crear assignment.                     |
| **GET**    | /assignments                                      | Buscar por person/edition/state/role. |
| **GET**    | /assignments/{id}                                 | Detalle + requirements/receipts.      |
| **POST**   | /assignments/{id}/requirements                    | Agregar requirement.                  |
| **POST**   | /assignments/{id}/requirement-results             | Registrar result append-only.         |
| **POST**   | /assignments/{id}/invitations                     | Emitir invitation.                    |
| **POST**   | /assignment-invitations/{token}/accept            | Aceptar con secret token; rate-limit. |
| **POST**   | /assignment-invitations/{token}/decline           | Declinar.                             |
| **POST**   | /assignments/{id}/activate                        | Activar.                              |
| **POST**   | /assignments/{id}/complete                        | Completar.                            |
| **POST**   | /assignments/{id}/replacement                     | Crear replacement lineage.            |
| **POST**   | /assignments/{id}/cancel                          | Cancelar.                             |

## 16.3 Content API

| **Método** | **Endpoint**                                      | **Uso**                        |
|------------|---------------------------------------------------|--------------------------------|
| **POST**   | /content-packages                                 | Crear package.                 |
| **GET**    | /content-packages                                 | Buscar/paginar.                |
| **POST**   | /content-packages/{id}/versions                   | Crear/clone version.           |
| **GET**    | /content-versions/{id}                            | Detalle + ETag.                |
| **POST**   | /content-versions/{id}/items                      | Agregar item.                  |
| **PUT**    | /content-versions/{id}/items/{itemId}             | Editar item con If-Match root. |
| **POST**   | /content-items/{id}/rights                        | Agregar rights binding.        |
| **POST**   | /content-items/{id}/release-rule                  | Definir release.               |
| **POST**   | /content-versions/{id}/validate                   | ValidationReport.              |
| **POST**   | /content-versions/{id}/publish                    | Publish + receipt.             |
| **POST**   | /plan-revisions/{id}/content-bindings             | Pinear content item.           |
| **DELETE** | /plan-revisions/{id}/content-bindings/{bindingId} | Solo DRAFT.                    |

## 16.4 External spaces / operations

| **Método** | **Endpoint**                              | **Uso**                             |
|------------|-------------------------------------------|-------------------------------------|
| **POST**   | /plan-revisions/{id}/provisioning-intents | Crear provisioning intent →202/201. |
| **GET**    | /provisioning-intents/{id}                | Estado local + last receipt.        |
| **POST**   | /provisioning-intents/{id}/reconcile      | Reconcile UNKNOWN_EFFECT.           |
| **POST**   | /external-spaces/{id}/sync                | Sync command.                       |
| **POST**   | /external-spaces/{id}/suspend             | Suspender remoto vía CT-18.         |
| **POST**   | /external-spaces/{id}/archive             | Archivar remoto vía CT-18.          |
| **GET**    | /operations/{operationId}                 | OperationStatus.                    |
| **GET**    | /reconciliation?state=UNKNOWN_EFFECT      | Ops queue.                          |

## 16.5 Paginación y filtros

Collections aceptan pageSize con máximo policy-driven (baseline 100), cursor preferido para listas de alta mutabilidad y sort estable con tie-breaker id. Filtros mínimos: editionRef, planState, personRef, roleCode, assignmentState, packageCode, contentType, providerCode, externalSpaceState y updatedSince. Toda response lista incluye asOf/provenance cuando combina read models externos.

## 16.6 ProblemDetail / reason codes

| **HTTP** | **Reason code ejemplo**                                          | **Semántica**                      |
|----------|------------------------------------------------------------------|------------------------------------|
| **400**  | INVALID_REQUEST                                                  | Schema/query inválido.             |
| **401**  | AUTH_REQUIRED                                                    | No autenticado.                    |
| **403**  | SCOPE_FORBIDDEN / STEP_UP_REQUIRED                               | ABAC/assurance insuficiente.       |
| **404**  | RESOURCE_NOT_FOUND                                               | No encontrado dentro tenant/scope. |
| **409**  | ASSIGNMENT_DUPLICATE / IDEMPOTENCY_KEY_REUSED / PUBLISH_CONFLICT | Conflicto de estado/identidad.     |
| **410**  | INVITATION_EXPIRED                                               | Token ya no utilizable.            |
| **412**  | PRECONDITION_FAILED                                              | ETag/aggregate revision obsoleta.  |
| **413**  | PAYLOAD_TOO_LARGE                                                | Budget excedido.                   |
| **422**  | PLAN_NOT_READY / REQUIREMENT_UNSATISFIED / RIGHTS_INVALID        | Regla de negocio.                  |
| **429**  | RATE_LIMITED                                                     | Abuso/enumeration/bulk.            |
| **503**  | DEPENDENCY_UNAVAILABLE                                           | Dependencia crítica indisponible.  |

## 16.7 DTOs y concurrency contract

public record CreateInstructorAssignmentRequest(

UUID teachingPlanRevisionId,

String assignmentScope,

UUID teachingPlanModuleId,

UUID sessionRef,

UUID personRef,

UUID engagementRef,

String roleCode,

String responsibilityCode,

BigDecimal plannedHours,

boolean acceptanceRequired

) {}

public record InstructorAssignmentResponse(

UUID assignmentId,

UUID personRef,

String roleCode,

String state,

long version,

List\<RequirementSummary\> requirements,

DataFreshness freshness

) {}

| **ETAG —** GET de roots retorna ETag basado en version. Mutaciones root/child exigen If-Match salvo create. Un child command usa el ETag del aggregate root documentado en OpenAPI, no un row version secreto. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 17. Eventos, outbox/inbox y AsyncAPI

Eventos de integración describen hechos después de commit y son minimizados. event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at y payload forman el envelope. Consumers usan inbox dedup. AsyncAPI vive en Git y compatibility tests bloquean breaking changes no versionados.

| **Evento**                            | **Aggregate**         | **Payload mínimo**                                                     | **Consumidores**                                      |
|---------------------------------------|-----------------------|------------------------------------------------------------------------|-------------------------------------------------------|
| **TeachingPlanRevisionPublished.v1**  | TeachingPlanRevision  | revisionId, teachingPlanId, editionRef, programVersionRef, contentHash | EC-02/06/07/11/CT-18                                  |
| **TeachingPlanRevisionSuperseded.v1** | TeachingPlanRevision  | old/new revision refs                                                  | Consumers pin history; future operations re-evaluate. |
| **InstructorAssignmentCreated.v1**    | InstructorAssignment  | assignmentId, planRevisionId, personRef, roleCode, scope refs          | CT-07/EC-06/11                                        |
| **InstructorAssignmentAccepted.v1**   | InstructorAssignment  | assignmentId, acceptedAt, terms policy ref                             | Ops/EC-06                                             |
| **InstructorAssignmentActivated.v1**  | InstructorAssignment  | assignmentId, effectiveFrom                                            | EC-06/11                                              |
| **InstructorAssignmentReplaced.v1**   | InstructorAssignment  | old/new assignment refs, reasonCode                                    | EC-02/06/11/CT-07                                     |
| **ContentPackageVersionPublished.v1** | ContentPackageVersion | package/version/hash                                                   | CT-18/EC-07                                           |
| **TeachingContentBound.v1**           | TeachingPlanRevision  | scope/contentItemRef                                                   | CT-18/read models                                     |
| **LearningSpaceProvisioned.v1**       | ExternalLearningSpace | provider/space ref/scope                                               | EC-02/06/Portal                                       |
| **LearningSpaceStateChanged.v1**      | ExternalLearningSpace | old/new state                                                          | Portal/Ops                                            |
| **ProvisioningUnknownEffect.v1**      | LmsProvisioningIntent | intentId/provider/remoteOperationRef                                   | Ops/alerts                                            |

## 17.1 Outbox claim protocol

SELECT event_id

FROM ec05.ec05_outbox_event

WHERE tenant_id = ec05.current_tenant_uuid()

AND state IN ('PENDING','FAILED')

AND next_attempt_at \<= now()

ORDER BY occurred_at

FOR UPDATE SKIP LOCKED

LIMIT 100;

-- claim -\> IN_FLIGHT + owner_id + lease_until in same transaction

Un worker vencido se recupera por lease. Poison events alcanzan attempt threshold y escalan sin bloquear toda la cola. Replay es gobernado y no modifica occurred_at/event_id original cuando se reentrega el mismo hecho.

## 17.2 Inbox contract

Antes del handler se inserta message_id + payload_hash. Same message/same hash es replay inocuo; same id/different hash es CONTRACT_INTEGRITY_INCIDENT. El handler y marking PROCESSED comparten transacción local cuando sea posible.

# 18. Integraciones, resiliencia, reconciliación y UNKNOWN_EFFECT

| **Dependencia**    | **Timeout baseline** | **Retry**                      | **Circuit breaker** | **Degradación/reconcile**                                 |
|--------------------|----------------------|--------------------------------|---------------------|-----------------------------------------------------------|
| CT-04 Person       | 1–2 s                | GET safe con jitter            | Sí                  | Read puede STALE; critical person resolution fail-closed. |
| RRHH/Procurement   | 2 s                  | GET safe                       | Sí                  | Engagement UNKNOWN no se interpreta vigente.              |
| CT-05 Documents    | 2–5 s                | Safe GET/upload según contract | Sí                  | Content publish puede fail-closed si evidence requerido.  |
| CT-06 Workflow     | 2 s                  | Idempotent command             | Sí                  | UNKNOWN_EFFECT conserva workflow operation ref.           |
| CT-13 availability | 2 s                  | GET safe                       | Sí                  | Plan view PARTIAL; schedule no local.                     |
| CT-18 LMS/meeting  | 3–10 s               | Solo idempotent/query-status   | Sí por provider     | Timeout after send =\> UNKNOWN_EFFECT + reconcile.        |
| EC-01/02           | 1–2 s                | GET safe                       | Sí                  | Publish fail-closed para refs críticas; read STALE.       |

## 18.1 Regla UNKNOWN_EFFECT

| **UNKNOWN_EFFECT —** Si EC-05 envía CREATE COURSE y CT-18/proveedor crea el curso pero la respuesta se pierde, no se sabe si el efecto ocurrió. El intent queda UNKNOWN_EFFECT, se consulta por idempotency/remoteOperationRef y solo si se demuestra NOT_APPLIED se reintenta. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 18.2 Reconciliation Center

| **Vista**                        | **Datos**                                    | **Acciones**                                                    |
|----------------------------------|----------------------------------------------|-----------------------------------------------------------------|
| **Unknown provisioning**         | intent, provider, age, remoteRef, last query | Reconcile, inspect evidence, retry after NOT_APPLIED, escalate. |
| **Stale external spaces**        | lastVerifiedAt, provider state               | Refresh/query-status, mark suspended/archived.                  |
| **Assignment requirement stale** | requirement, latest result, expiry           | Re-evaluate/request evidence.                                   |
| **Content rights expiring**      | item/license/validTo/plan usages             | Renew/rebind/new content version.                               |
| **Outbox backlog**               | state/attempt/lease/error                    | Reclaim/replay/escalate.                                        |

## 18.3 Compensation vs rollback

Side effects distribuidos no se “rollbackean” como una transacción XA. Si un LMS course confirmado debe retirarse, se emite un nuevo command ARCHIVE/SUSPEND con su propia idempotencia, receipt y audit. El hecho de que existió el course permanece en historia.

# 19. Frontend Web enterprise por workspaces

Frontend no es una lista de pantallas. Se diseña por workspaces orientados a tareas con routing modular, permisos, filtros, KPIs, actions y estados operacionales explícitos. Baseline: React + TypeScript + client generado OpenAPI, query/cache version-aware, schema validation, error boundaries y accessibility WCAG 2.2 AA.

| **Workspace**              | **Usuario**            | **Ruta**                              | **Layout/componentes**                                                                  | **Acciones**                                                         |
|----------------------------|------------------------|---------------------------------------|-----------------------------------------------------------------------------------------|----------------------------------------------------------------------|
| Teaching Plan Studio       | Instructional Designer | /ec/teaching/plans/:id/revisions/:rev | Revision banner+ETag, readiness, modules, units, content, diff, validate/review/publish | Save DRAFT, validate, compare, request review; publish solo permiso. |
| Teaching Operations Board  | Coordinator            | /ec/teaching/operations               | Ediciones próximas, teams, assignment readiness, gaps, LMS status                       | Assign, invite, replace, reconcile.                                  |
| Instructor Assignment Desk | Coordinator            | /ec/teaching/assignments              | Search by person/role/state, requirements, acceptance, workload warnings                | Create/invite/revalidate/replace/cancel.                             |
| Content Library            | Content Designer       | /ec/teaching/content                  | Packages/versions/items, rights badges, accessibility, usages                           | Create version, validate, review, publish.                           |
| Content Rights Desk        | Content Governance     | /ec/teaching/content/rights           | Expiring/invalid rights, evidence, usage impact                                         | Add rights/new version/escalate.                                     |
| Learning Space Console     | Ops                    | /ec/teaching/spaces                   | Provider, intent state, external ref, last verify, UNKNOWN_EFFECT                       | Provision/sync/suspend/archive/reconcile.                            |
| Instructor Portal Web      | Instructor             | /my/teaching                          | Assignments, agenda refs, materials, invitations, notices                               | Accept/decline, open content, report issue.                          |
| Reconciliation Center      | Ops/SRE                | /ec/teaching/reconciliation           | Unknown effects, outbox, stale spaces, dependency health                                | Reconcile/reclaim/escalate.                                          |

## 19.1 Teaching Plan Studio — detalle implementable

- Header: edition/program version refs, revision number/state, ETag, owner, readiness score derivado y dependency health.

- Tabs: Overview · Modules · Instructional Units · Teams · Content · Recording · Validation · Diff · Audit.

- Right rail: validation issues agrupados por severity/source; stale external facts muestran asOf y Refresh.

- Mutations DRAFT actualizan cache con ETag nuevo; 412 abre conflict drawer con server snapshot/diff/reload, nunca overwrite automático.

- Publish modal exige validation PASS, unresolved warnings acknowledgement/reason, step-up y muestra exactamente qué snapshot hash se publica.

- SCHEDULED/PUBLISHED cambia UI a read-only; CTA principal es Clone/New Revision, no Edit.

## 19.2 Assignment Desk — detalle implementable

- Table virtualizada/paginada con person display mínimo, role, scope, requirements readiness, acceptance, state, planned hours y last updated.

- Drawer assignment: identity refs, role/scope, requirement timeline append-only, invitation timeline, acceptance receipt, replacement lineage y audit refs.

- Create wizard valida Person/role/scope y preview de requirements antes de commit.

- Replace wizard nunca edita person_ref: muestra old vs proposed, policy/workflow, impact in sessions/spaces y steps de readiness.

- UNAVAILABLE de CT-04/RRHH se distingue de “sin engagement”.

- Bulk invite devuelve OperationStatus; UI muestra item failures sin declarar success global.

## 19.3 Content Library — detalle implementable

- Grid/list con package code, published version, rights/accessibility health, usages y stale badges.

- Version editor tabs: Metadata · Items · Rights · Release · Accessibility · Validation · Diff.

- Item target selector es discriminated union; seleccionar Document limpia External/LMS target en form schema.

- Rights expiry usa warnings con policy thresholds; publish bloquea missing/invalid rights.

- Content usage drawer muestra TeachingPlans que pinnean el item/version para impacto antes de supersede.

- No se muestran signed URLs persistentes; CT-05 entrega acceso temporal bajo purpose.

## 19.4 Estados de UI obligatorios

| **Estado**         | **Representación**                           | **Ejemplo EC-05**                               |
|--------------------|----------------------------------------------|-------------------------------------------------|
| **NO_DATA**        | Empty state con acción pertinente.           | Edición aún no tiene TeachingPlan.              |
| **ZERO**           | Valor válido cero.                           | 0 assignments pendientes.                       |
| **STALE**          | Dato conocido con asOf + refresh.            | Engagement leído hace 30 min.                   |
| **PARTIAL**        | Algunas dependencias resolvieron y otras no. | Impact simulation sin CT-13.                    |
| **UNAVAILABLE**    | No fue posible consultar dependency.         | CT-18 caído; no mostrar “sin LMS”.              |
| **UNKNOWN_EFFECT** | Side effect remoto puede haber ocurrido.     | CREATE COURSE timeout; CTA Reconcile, no Retry. |

## 19.5 Accessibility y responsive

- Keyboard completo en tables/drawers/modals; focus visible y restoration.

- Errores no dependen solo de color; reason code + texto + field association.

- Status badges tienen label accesible.

- Tables complejas ofrecen mobile/compact cards y column preferences.

- Confirmaciones críticas describen efecto, scope y permanencia histórica.

- Contrast y heading order conservan la plantilla PeopleU y WCAG 2.2 AA.

# 20. Mobile

EC-05 sí necesita Mobile, principalmente para el instructor/facilitador, no para administración enterprise. React Native consume el mismo OpenAPI/authorization. Operaciones de governance — publish, void, high-risk replacement, rights override y provider administration — permanecen Web.

## 20.1 Journeys Mobile permitidos

| **Journey**                     | **Pantallas**                       | **Offline**                                  | **Restricción**                     |
|---------------------------------|-------------------------------------|----------------------------------------------|-------------------------------------|
| **Mis asignaciones**            | Lista/detail role/scope/readiness   | Cache read-only con asOf                     | No editar person/role/scope.        |
| **Aceptar/declinar invitación** | Terms summary → assurance → confirm | No offline accept                            | Token/identity online.              |
| **Agenda docente**              | Sessions derivadas EC-02            | Cache próxima agenda                         | Schedule read-only.                 |
| **Materiales**                  | Content items permitidos            | Offline solo si CT-05/license policy permite | No export irrestricto.              |
| **Deep link a LMS/meeting**     | Open external space                 | No                                           | URL/token se resuelve just-in-time. |
| **Reportar acceso/incidencia**  | Issue form + evidence ref           | Queue local si safe                          | No muta remote state.               |
| **Push notifications**          | Assignment/session/content changes  | N/A                                          | Push no es Source of Truth.         |

## 20.2 Sync/offline

Offline cache cifra datos sensibles y conserva expiresAt/asOf. Acciones mutantes críticas requieren conectividad. Un usuario que ve una agenda stale recibe banner explícito; el móvil no infiere que una sesión cancelada sigue vigente.

## 20.3 Biometría y deep links

Biometría puede desbloquear storage local/step-up delegado por IAM según plataforma, pero nunca sustituye assurance server-side. Deep links usan rutas verificadas y tokens de vida corta; no deben exponer external_space_ref sensible en logs o analytics.

# 21. Matriz Frontend / Backend / Mobile

| **Capacidad**                    | **Web**               | **Backend**              | **Mobile**       |
|----------------------------------|-----------------------|--------------------------|------------------|
| **Crear/publicar TeachingPlan**  | Completo              | Commands + validation    | No               |
| **Gestionar teams/assignments**  | Completo              | Sí                       | Read/accept only |
| **Replacement**                  | Wizard governance     | Sí                       | No               |
| **Requirements**                 | Desk/timeline         | Sí + external ports      | Read own only    |
| **Content authoring/versioning** | Completo              | Sí                       | No               |
| **Content consumption**          | Preview/admin         | Signed access refs       | Sí               |
| **Rights/recording policies**    | Governance            | Sí                       | No               |
| **LMS provisioning**             | Ops console           | CT-18 intents/reconcile  | Deep link only   |
| **UNKNOWN_EFFECT**               | Reconciliation center | OperationStatus/receipts | Message only     |
| **Audit/evidence**               | Full                  | Refs/events              | Own limited      |
| **AI assist**                    | Designer/Coordinator  | CT-12 port               | No/limited       |

# 22. Seguridad: RBAC, ABAC, SoD, step-up y privacy

| **Rol**                     | **Permisos base**                                             |
|-----------------------------|---------------------------------------------------------------|
| **TEACHING_PLAN_DESIGNER**  | Crear/editar DRAFT plan revisions y units/content bindings.   |
| **TEACHING_COORDINATOR**    | Crear teams/assignments/invitations; no auto-aprobar publish. |
| **ACADEMIC_APPROVER**       | Aprobar/rechazar review; SoD configurable.                    |
| **ACADEMIC_PUBLISHER**      | Publicar/SCHEDULED/supersede con step-up.                     |
| **CONTENT_DESIGNER**        | Crear content packages/versions/items.                        |
| **CONTENT_GOVERNANCE**      | Rights/accessibility/void content.                            |
| **CONTENT_PUBLISHER**       | Publicar content versions con step-up según policy.           |
| **EXTERNAL_SPACE_OPERATOR** | Provision/sync/suspend/archive vía CT-18.                     |
| **INSTRUCTOR**              | Ver/aceptar sus assignments y acceder a recursos permitidos.  |
| **AUDITOR**                 | Read evidence/lineage; no mutation.                           |
| **OPS_SRE**                 | Reconcile/outbox/operations bajo ABAC técnico.                |

## 22.1 ABAC y scope

- tenant_id + academic_owner_scope_ref + edition scope + role + resource state.

- Instructor solo accede a assignments donde person_ref corresponde a su subject/person mapping autorizado.

- Content preview/export evalúa purpose, rights, scope y document policy.

- Provider Ops puede actuar solo en proveedores/scopes autorizados.

- Audit de alto riesgo exige reason_code y purpose cuando policy lo define.

## 22.2 Segregation of Duties

| **Operación**                        | **Puede iniciar**  | **Puede aprobar/publicar**    | **Prohibición**                                     |
|--------------------------------------|--------------------|-------------------------------|-----------------------------------------------------|
| **Teaching plan publish**            | Designer           | Approver/Publisher            | Designer material no único aprobador cuando SoD on. |
| **Content publish**                  | Content Designer   | Content Publisher             | No self-approval bajo policy.                       |
| **Instructor replacement high-risk** | Coordinator        | Approver/Governance           | No reemplazo silencioso.                            |
| **Rights waiver/override**           | Content Governance | Segundo approver si policy    | No autor del contenido como único aprobador.        |
| **VOID snapshot**                    | Governance         | Step-up + evidence            | No operador técnico solo.                           |
| **Archive external space**           | Ops                | Policy/approval según impacto | No si UNKNOWN_EFFECT sin reconcile.                 |

## 22.3 Step-up

Baseline: publish/supersede/void, derechos excepcionales, replacement de asignación activa con alto impacto, provisioning destructivo y exportaciones sensibles pueden exigir step-up. Se conserva assurance_level, actor, timestamp y correlation en audit/evidence.

## 22.4 Field-level privacy

EC-05 minimiza PII. person_ref es el vínculo; display name/email se consultan con purpose desde CT-04 y no se convierten en campos persistentes locales. Datos de requirements sensibles se representan por status/evidence_ref, no por diagnóstico/documento completo. Instructor Portal solo ve información de participantes si otro módulo/propósito explícito lo autoriza; EC-05 por sí mismo no necesita roster PII.

## 22.5 Threat Model

| **Amenaza**              | **Vector**                                           | **Mitigación**                                            |
|--------------------------|------------------------------------------------------|-----------------------------------------------------------|
| **IDOR cross-tenant**    | IDs UUID adivinados/copied                           | RLS FORCE + ABAC + tenant context tests.                  |
| **Mass assignment**      | Body intenta tenant/state/person/role no autorizados | DTO allowlist + commands de intención.                    |
| **Invitation takeover**  | Token leak/replay                                    | Hash only, TTL, rate limit, assurance, one-shot.          |
| **Role escalation**      | Coordinator se auto-publica plan                     | RBAC/ABAC/SoD/step-up.                                    |
| **Content exfiltration** | Signed URLs/logs/cache                               | CT-05 short-lived access + no secrets logs + purpose.     |
| **Rights bypass**        | Publicar item sin licencia                           | Publish validation + policy + evidence + tests.           |
| **Remote duplication**   | Retry tras timeout CREATE                            | Idempotency + UNKNOWN_EFFECT reconcile.                   |
| **Webhook spoof**        | Fake LMS status                                      | CT-18 trust/auth + signature verification.                |
| **Graph/payload DoS**    | Huge content/bulk ops                                | Capacity budgets, 413/422/429, async chunking.            |
| **Stored injection**     | Titles/metadata rendered unsafe                      | Output encoding/CSP/sanitization where rich text allowed. |
| **Supply-chain**         | Dependency/plugin vulnerability                      | SCA/SBOM/container scan/signing.                          |
| **Audit tamper**         | Modify receipts/results                              | Append-only triggers + CT-10 evidence/hash.               |

## 22.6 Secure SDLC

- SAST en PR; High/Critical bloquea merge según policy.

- SCA/dependency policy y SBOM por release.

- Secret scanning en Git/CI; tokens proveedor solo secret manager.

- Container/IaC scan; image signing y provenance.

- DAST/API security sobre staging.

- RLS negative suite con runtime role real.

- Dependency/version compatibility tests OpenAPI/AsyncAPI.

- Threat model actualizado por ADR para nuevos providers/capabilities.

# 23. Auditoría, Evidence Pack, lineage y reason codes

CT-10 es Source of Truth de auditoría transversal; EC-05 produce eventos/refs de negocio. Toda operación crítica registra tenant, actor, subject, scope, timestamp, action, resource, before/after cuando aplica, reason_code, correlationId, policy versions, assurance/step-up y evidence refs.

## 23.1 Evidence Pack por publicación

- TeachingPlan/Content target id + revision/version + content_hash + hash algorithm/canonical schema version.

- ValidationReport final y unresolved warnings aceptados con reason.

- Policy snapshot: assignment/workload/content/rights/recording/compliance.

- Workflow_ref, reviewers/approver refs y assurance.

- Rights/evidence refs requeridos.

- Program/Edition/Module external refs pinneados con contract provenance.

- PublicationReceipt + outbox event ids/correlation.

## 23.2 Lineage obligatorio

| **Objeto**                | **Lineage**                                      | **Regla**                                  |
|---------------------------|--------------------------------------------------|--------------------------------------------|
| **TeachingPlanRevision**  | previous_revision_id / superseded_by_revision_id | Monotónico; self/cross-plan blocked.       |
| **ContentPackageVersion** | previous_version_id / superseded_by_version_id   | Monotónico; immutable published.           |
| **InstructorAssignment**  | replacement_for_assignment_id                    | No overwrite; terminal old + new row.      |
| **RequirementResult**     | sequence temporal por requirement                | Append-only; latest applicable por policy. |
| **Provisioning**          | intent → one/many receipts → external space      | UNKNOWN_EFFECT preserved.                  |

## 23.3 Reason codes mínimos

| **Categoría**  | **Codes ejemplo**                                                                                    |
|----------------|------------------------------------------------------------------------------------------------------|
| **Assignment** | UNAVAILABLE · DECLINED · REQUIREMENT_FAILED · SCHEDULE_CONFLICT · REPLACED_BY_EXPERT · POLICY_CHANGE |
| **Plan**       | MATERIAL_CHANGE · COMPLIANCE_CHANGE · DELIVERY_STRATEGY_CHANGE · VOID_ERROR                          |
| **Content**    | RIGHTS_EXPIRED · ACCESSIBILITY_REMEDIATION · CONTENT_CORRECTION · SECURITY_WITHDRAWAL                |
| **External**   | PROVIDER_REJECTED · REMOTE_TIMEOUT · UNKNOWN_EFFECT · RECONCILED_NOT_APPLIED · ARCHIVED_BY_POLICY    |

# 24. Observabilidad: logs, metrics, traces, SLI/SLO y performance

## 24.1 Logs/traces

Logs estructurados incluyen correlationId, tenantId pseudonimizado/según logging policy, operation, resourceRef, outcome, reasonCode, latency, dependency, retryAttempt y operationId. No registrar invitation token, signed URLs, raw PII, document bodies ni proveedor secrets. OpenTelemetry propaga correlation/trace a CT-18 y demás adapters cuando contrato lo permite.

## 24.2 SLI/SLO

| **SLI**                              | **SLO objetivo inicial**            | **Notas**                                                |
|--------------------------------------|-------------------------------------|----------------------------------------------------------|
| **TeachingPlan read availability**   | 99.9% mensual                       | Read models degradables con stale mark.                  |
| **Publish command success**          | 99.5% excluyendo business rejection | Dependency unavailable separado.                         |
| **Assignment create p95**            | \< 500 ms sin remote blocking       | Person/policy prefetch/cache versionada cuando safe.     |
| **Invitation accept p95**            | \< 700 ms                           | Incluye token/identity checks, no notification delivery. |
| **Content list p95**                 | \< 500 ms                           | Paginado/indexado.                                       |
| **LMS provisioning acknowledgement** | \< 1 s para 202                     | Remote completion async.                                 |
| **Provisioning terminal**            | 95% \< 5 min                        | Provider-dependent; unknown tracked separately.          |
| **UNKNOWN_EFFECT resolution**        | 95% \< 15 min / 99% \< 4 h          | Escalation after threshold.                              |
| **Outbox delivery**                  | 99.9% \< 2 min                      | occurred→delivered.                                      |
| **Tenant isolation**                 | 100%                                | Leak = Sev-1.                                            |
| **Publication reconstructibility**   | 100%                                | Receipt/hash/policy refs available.                      |

## 24.3 Metrics

- ec05_plan_publish_total{outcome,reason}

- ec05_assignment_total{state,role}

- ec05_assignment_requirement_total{status}

- ec05_invitation_total{state}

- ec05_content_publish_total{outcome}

- ec05_rights_expiry_days histogram

- ec05_lms_intent_total{provider,state,action}

- ec05_unknown_effect_age_seconds

- ec05_outbox_backlog{state}

- ec05_idempotency_recovery_total

- ec05_http_latency{route,outcome}

- ec05_rls_violation_total if safely instrumentable

## 24.4 Capacity/performance budgets

| **Recurso**                           | **Baseline parametrizable** | **Respuesta**                         |
|---------------------------------------|-----------------------------|---------------------------------------|
| **pageSize**                          | 100                         | 400/422 si excede.                    |
| **Assignments por plan revision**     | 5.000                       | Bulk async/partition + policy review. |
| **Requirements por assignment**       | 200                         | 422\.                                 |
| **Content items por package version** | 5.000                       | Chunked authoring/import.             |
| **Content bindings por plan**         | 10.000                      | Async import/read pagination.         |
| **Bulk invitations**                  | 10.000/op                   | 202 + OperationStatus.                |
| **Bulk provisioning**                 | 1.000 scopes/op             | 202 chunked; provider quotas.         |
| **Payload JSON**                      | 1 MiB baseline              | 413\.                                 |
| **Export pack**                       | 100k rows baseline          | Async artifact CT-05.                 |

# 25. IA aplicada al módulo

Toda IA pasa por CT-12. AI_RECOMMENDATION ≠ ACADEMIC/HR DECISION. IA puede asistir planificación, detectar gaps, recomendar recursos o riesgos, pero nunca asigna/acepta/reemplaza un docente por sí sola, nunca declara requisito cumplido, nunca publica contenido y nunca ejecuta provisioning remoto autónomo.

| **Caso permitido**               | **Grounding**                                             | **Output**                             | **Control**                                  |
|----------------------------------|-----------------------------------------------------------|----------------------------------------|----------------------------------------------|
| **Sugerir instructor candidato** | Role requirements + authorized profile/skills refs        | Rank/suggestion + rationale/confidence | Coordinator decide; no employment inference. |
| **Detectar team gaps**           | Plan/modules/roles/assignments                            | Missing role/workload warnings         | Policy/Coordinator valida.                   |
| **Sugerir metodología**          | Program outcomes + modality + audience profile aggregated | Draft InstructionalUnitPlan            | Designer accepts/edits.                      |
| **Sugerir contenido**            | Outcomes + authorized content catalog                     | Candidate content refs                 | Rights/accessibility revalidated.            |
| **Detectar inconsistencia**      | Plan vs content/hours/roles                               | Risk findings                          | No automatic mutation.                       |
| **Resumir rights/policies**      | Policy/evidence text permitted                            | Human-readable summary                 | Not authoritative legal decision.            |
| **Analizar incidentes LMS**      | Operational logs sanitized                                | Probable cause/next steps              | Ops verifies; no remote action automatic.    |

## 25.1 Provenance obligatorio

Cada suggestion aplicada conserva ai_run_ref, model_ref, prompt/template_ref, eval_ref, grounding_refs, confidence, reviewer_subject_ref, reviewer_outcome y command generado. El sistema debe poder demostrar que la IA recomendó y una persona autorizada decidió.

| **LÍMITE —** No usar IA para inferir atributos sensibles del instructor, decidir contratación, discriminar candidatos, crear calificaciones ni reemplazar controles de derechos/identidad. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 26. Analítica y KPI

CT-11 gobierna datasets/BI. EC-05 publica hechos semánticos. Los KPI ayudan a mejorar preparación y delivery, pero no deben convertirse automáticamente en decisiones laborales o disciplinarias.

| **KPI**                           | **Definición**                                                            |
|-----------------------------------|---------------------------------------------------------------------------|
| **Plan readiness lead time**      | Tiempo creación TeachingPlan→PUBLISHED antes del inicio de edición.       |
| **Assignment fill rate**          | Roles requeridos cubiertos / roles requeridos.                            |
| **Assignment acceptance rate**    | Accepted / invitations issued.                                            |
| **Requirement readiness**         | Assignments con mandatory requirements vigentes / assignments requeridos. |
| **Instructor replacement rate**   | Replaced assignments / active+completed assignments.                      |
| **Last-minute replacement**       | Replacements dentro de ventana X antes de session/start.                  |
| **Planned workload distribution** | Horas planificadas por persona/role/scope; no payroll.                    |
| **Content readiness**             | Required content items published+rights valid / required items.           |
| **Rights expiry exposure**        | Usages afectados por rights que vencen antes del delivery end.            |
| **Accessibility readiness**       | Content versions compliant / required content versions.                   |
| **LMS provisioning success**      | Confirmed intents / terminal intents.                                     |
| **Provisioning lead time**        | Intent created→confirmed p50/p95.                                         |
| **UNKNOWN_EFFECT backlog**        | Count/age by provider/action.                                             |
| **Space stale verification**      | External spaces beyond freshness threshold.                               |
| **Content reuse ratio**           | Bindings to existing published content / total bindings.                  |
| **Plan revision churn**           | Revisions per edition; material changes after initial publish.            |
| **Outbox delivery health**        | Backlog/age/failed rate.                                                  |
| **Instructor portal adoption**    | Accepted/viewed materials through portal / eligible assignments.          |

# 27. Migración legacy y Data Quality con CT-16

Legacy entra por CT-16: Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → receipt → Reconcile → Certify. Se prohíbe INSERT directo porque saltaría identity resolution, lineage, rights, state guards, RLS, publication evidence y integration effects.

| **Objeto legacy**           | **Transformación**                                      | **Validaciones críticas**                           |
|-----------------------------|---------------------------------------------------------|-----------------------------------------------------|
| **Docentes/instructores**   | Resolver Person CT-04; crear InstructorAssignment refs. | No fuzzy auto-merge; role/scope/policy.             |
| **Contratos/HR**            | Solo engagement_ref a owner externo.                    | No importar payroll/contract body a EC-05.          |
| **Planes docentes**         | Map TeachingPlan/Revision con edition/program refs.     | Hash/lineage/state evidence.                        |
| **Materiales**              | Crear CT-05 documents + ContentPackages/Versions/Items. | Dedup hash, ownership, rights, accessibility.       |
| **Links LMS/Zoom**          | Resolver provider/external_space_ref vía CT-18.         | Verificar ownership/status; no guardar credentials. |
| **Asignaciones históricas** | Crear assignments terminales con migration lineage.     | Fechas/roles/person refs; no inventar acceptance.   |
| **Derechos/licencias**      | RightsBinding con evidence_ref.                         | Unknown ≠ valid; quarantine si falta evidencia.     |

## 27.1 Data Quality rules

- Ambiguous Person → REVIEW/FAIL; no auto-merge.

- Assignment sin Person resoluble → quarantine o migration exception gobernada.

- Plan sin Edition/ProgramVersion resoluble → no promote a official truth.

- Published revision legacy sin evidence suficiente → LEGACY_CERTIFIED profile con provenance, nunca inventar workflow/hash histórico.

- Content blob se ingesta a CT-05 primero; EC-05 recibe document_ref/hash.

- Rights desconocidos permanecen UNKNOWN/blocked, no se convierten en “institutional”.

- Session links se verifican mediante CT-18; URLs muertas no se marcan ACTIVE.

- Missing source timestamp permanece NULL/legacy unknown; no reemplazar con now().

- Cada item promoted conserva sourceSystem/sourceBatch/sourceKey, raw/transformed hash, mapping version, validation result e idempotency receipt.

# 28. QA y estrategia de pruebas

EC-05 requiere pruebas de dominio, PostgreSQL real, contratos cross-context, seguridad y fault injection. No basta con controller tests porque los riesgos críticos son snapshot integrity, replacements históricos, rights, invitation anti-replay y remote side effects.

| **Nivel**               | **Cobertura obligatoria**                                                 | **Evidencia**                      |
|-------------------------|---------------------------------------------------------------------------|------------------------------------|
| **Unit/Domain**         | State machines, policies, scope unions, replacement, rights/release.      | JUnit 5/property-based.            |
| **Repository**          | PK/FK/unique/check/index/append-only/state triggers.                      | Testcontainers PostgreSQL.         |
| **RLS**                 | SELECT/INSERT/UPDATE cross-tenant con runtime role.                       | Negative integration suite.        |
| **Aggregate Revision**  | Child mutation bump + stale If-Match.                                     | Concurrent tests.                  |
| **Assignment**          | Duplicate active, acceptance, requirement freshness, replacement lineage. | Integration tests.                 |
| **Invitation security** | Token hash, expiry, replay, rate limit.                                   | Security/integration.              |
| **Content**             | Target XOR, rights expiry, immutable published, content hash.             | Repository/domain.                 |
| **CT-18 resilience**    | Timeout-before/after-send, query-status, duplicate callback.              | Fault injection/WireMock contract. |
| **Idempotency**         | Replay/key conflict/crash+lease recovery.                                 | Restart simulation.                |
| **Outbox/Inbox**        | Atomicity, SKIP LOCKED, duplicate delivery, reclaim.                      | Worker tests.                      |
| **API Contract**        | OpenAPI, ProblemDetail, paging, ETag, 202.                                | Generated client/contract.         |
| **Event Contract**      | Schema compatibility/minimal payload.                                     | AsyncAPI tests.                    |
| **Security**            | IDOR, ABAC, SoD, step-up, mass assignment, content access.                | DAST/security suite.               |
| **Performance**         | Plan list, assignment desk, content search, bulk ops.                     | k6/Gatling.                        |
| **Migration**           | Ambiguous person, legacy plan/content/rights.                             | CT-16 fixtures.                    |
| **E2E Web**             | Plan→assign→publish→provision→replace/reconcile.                          | Playwright.                        |
| **Mobile**              | Invite accept, agenda, content access, stale/offline.                     | RN unit/E2E.                       |
| **AI Evals**            | No autonomous assignment/publish/rights decision.                         | CT-12 eval suite.                  |

## 28.1 Pruebas físicas no negociables

- Runtime role SELECT sin tenant predicate no devuelve otro tenant.

- INSERT con tenant distinto al SET LOCAL falla RLS WITH CHECK.

- Dos publishes concurrentes de TeachingPlanRevision: solo una PUBLISHED vigente.

- Mutar InstructionalUnit de SCHEDULED/PUBLISHED: trigger rechaza.

- Child mutation DRAFT incrementa root version; stale ETag posterior =\> 412.

- previous_revision self/cross-plan/no monotónico: DB rechaza.

- Duplicate active assignment person+role+scope: unique partial rechaza.

- ACCEPTED con acceptance_required y sin receipt: state guard rechaza.

- Cambiar person_ref/role de ACCEPTED assignment: trigger rechaza.

- UPDATE/DELETE AssignmentRequirementResult o AcceptanceReceipt: append-only rechaza.

- Aceptar invitation expirada/revocada: rechaza y no crea receipt duplicado.

- ContentItem con 0 o \>1 target: CHECK rechaza.

- Mutar rights/release de PUBLISHED content version: trigger rechaza.

- ReleaseRule item de otra content version: composite FK rechaza.

- PublicationReceipt hash distinto del target: trigger rechaza.

- CT-18 timeout después de aplicar: UNKNOWN_EFFECT y no segundo CREATE hasta reconcile.

- Duplicate webhook/message: inbox dedup evita side effect doble.

- Dos outbox workers claim mismo event: SKIP LOCKED + lease evita doble ownership.

- Same Idempotency-Key different payload: 409.

- Archive external space confirmado no borra binding/history.

- AI suggestion no puede invocar publish/assignment command sin human actor/authorization.

| **GATE QA —** RLS, snapshot immutability, assignment replacement/acceptance, content rights, append-only receipts, idempotency/outbox y UNKNOWN_EFFECT son release blockers. No se aceptan como hardening posterior. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 29. Golden Scenarios

Los Golden Scenarios son criterios ejecutables de aceptación end-to-end. Deben vincularse a tests/evidence y cubren negocio, integridad física, multitenancy, concurrencia, idempotencia, seguridad, Mobile, IA, migración y resiliencia.

| **GS**      | **Escenario**                           | **Precondición**                                                | **Acción**                      | **Resultado esperado**                                                    | **Evidencia**          |
|-------------|-----------------------------------------|-----------------------------------------------------------------|---------------------------------|---------------------------------------------------------------------------|------------------------|
| GS-EC05-001 | Crear TeachingPlan por edición          | Edition/ProgramVersion resolubles.                              | Crear plan.                     | Plan único por tenant+edition; refs pinneadas.                            | DB+contract+audit.     |
| GS-EC05-002 | Bloquear segundo TeachingPlan           | Plan ya existe para edition.                                    | Crear otro con key nueva.       | 409; no duplicado.                                                        | UQ+ProblemDetail.      |
| GS-EC05-003 | Idempotent create plan                  | Misma request/key.                                              | Repetir.                        | Mismo plan/response.                                                      | Idempotency row.       |
| GS-EC05-004 | Crear revision inicial                  | Plan válido.                                                    | Create revision 1.              | DRAFT revision_no=1.                                                      | DB+ETag.               |
| GS-EC05-005 | Clonar PUBLISHED                        | Revision publicada.                                             | Clone.                          | Nueva DRAFT con previous lineage; sin copiar receipts como hechos nuevos. | Lineage+audit.         |
| GS-EC05-006 | Lineage self rechazado                  | Draft revision.                                                 | Set previous=self.              | DB reject.                                                                | Trigger.               |
| GS-EC05-007 | Lineage no monotónico                   | V3 intenta previous V4.                                         | Persistir.                      | DB reject.                                                                | Trigger.               |
| GS-EC05-008 | Editar child y bump ETag                | DRAFT ETag 5.                                                   | Agregar module.                 | Root ETag 6.                                                              | DB+response ETag.      |
| GS-EC05-009 | Stale child edit                        | ETag 5; otro cambio ya dejó 6.                                  | Editar unit con If-Match 5.     | 412 sin side effect.                                                      | API+DB.                |
| GS-EC05-010 | Validar plan listo                      | Modules/units/content/policies completos.                       | Validate.                       | PASS con dependency provenance.                                           | ValidationReport.      |
| GS-EC05-011 | Validar plan incompleto                 | Role/content requerido faltante.                                | Validate.                       | FAIL reason codes; state no cambia.                                       | Report.                |
| GS-EC05-012 | Solicitar review                        | DRAFT PASS.                                                     | Submit review.                  | IN_REVIEW + workflow ref/hash.                                            | DB+CT06.               |
| GS-EC05-013 | Snapshot cambia durante review          | Review hash A; contenido cambia ilícitamente/flow vuelve DRAFT. | Aprobar hash A.                 | 409 REVIEW_SNAPSHOT_CHANGED.                                              | Audit.                 |
| GS-EC05-014 | Aprobar plan                            | IN_REVIEW y SoD ok.                                             | Approve.                        | APPROVED.                                                                 | Workflow receipt.      |
| GS-EC05-015 | Programar versión futura                | APPROVED + valid_from futuro.                                   | Schedule.                       | SCHEDULED inmutable.                                                      | Receipt/state.         |
| GS-EC05-016 | Editar SCHEDULED                        | Revision SCHEDULED.                                             | Cambiar unit.                   | DB reject.                                                                | Trigger.               |
| GS-EC05-017 | Publicar plan                           | APPROVED, dependencies PASS.                                    | Publish.                        | PUBLISHED + receipt+outbox.                                               | DB+event.              |
| GS-EC05-018 | Publish concurrente                     | Dos publishers misma revision.                                  | Publish simultáneo.             | Uno gana; otro 409/412/replay.                                            | Concurrency test.      |
| GS-EC05-019 | Superseder plan                         | V1 PUBLISHED, V2 publish.                                       | Publish V2.                     | V1 SUPERSEDED, V2 PUBLISHED atómico.                                      | Transaction+receipts.  |
| GS-EC05-020 | Void plan                               | Error grave, step-up.                                           | Void.                           | VOID durable; downstream event; no delete.                                | Audit+outbox.          |
| GS-EC05-021 | Crear instructor interno                | Person+engagement refs válidos.                                 | Create assignment.              | PLANNED; no datos RRHH copiados.                                          | DB+ports.              |
| GS-EC05-022 | Crear experto externo sin employee      | Person válido, engagement opcional según policy.                | Create assignment.              | PLANNED permitido; role académico separado.                               | DB+policy.             |
| GS-EC05-023 | Duplicate active assignment             | Misma person/role/scope ya activo.                              | Create.                         | 409\.                                                                     | Unique partial.        |
| GS-EC05-024 | Scope module correcto                   | Module pertenece misma revision.                                | Create MODULE assignment.       | Persistido.                                                               | Composite FK.          |
| GS-EC05-025 | Scope module cross revision             | Module de otra revision.                                        | Create assignment.              | DB reject.                                                                | Composite FK.          |
| GS-EC05-026 | Scope session sin module                | Session ref válida.                                             | Create SESSION.                 | Persistido con module null.                                               | CHECK.                 |
| GS-EC05-027 | Scope ambiguo                           | MODULE + session_ref.                                           | Create.                         | 422/DB reject.                                                            | CHECK.                 |
| GS-EC05-028 | Requirement PASS                        | Mandatory req + valid evidence.                                 | Record PASS.                    | Append-only result.                                                       | DB+audit.              |
| GS-EC05-029 | Requirement UNKNOWN                     | Dependency no determina.                                        | Record UNKNOWN.                 | No activation.                                                            | Receipt+policy.        |
| GS-EC05-030 | Requirement expirado                    | PASS con expires_at pasado.                                     | Activate assignment.            | 422 REQUIREMENT_STALE.                                                    | Domain test.           |
| GS-EC05-031 | Waiver gobernado                        | Approval/evidence válido.                                       | Record WAIVED.                  | Satisface según policy; receipt append-only.                              | Workflow/evidence.     |
| GS-EC05-032 | Mutar requirement result                | Result existente.                                               | UPDATE/DELETE SQL.              | DB reject.                                                                | Append-only trigger.   |
| GS-EC05-033 | Emitir invitation                       | Assignment PLANNED.                                             | Issue.                          | ISSUED token hash only.                                                   | DB+CT07.               |
| GS-EC05-034 | No guardar plaintext token              | Invitation emitida.                                             | Inspect DB/logs.                | No secret plaintext.                                                      | Security test.         |
| GS-EC05-035 | Abrir invitation                        | Token vigente.                                                  | Open.                           | OPENED once.                                                              | State audit.           |
| GS-EC05-036 | Aceptar invitation                      | Identity assurance ok.                                          | Accept.                         | AcceptanceReceipt + assignment ACCEPTED.                                  | Receipt+audit.         |
| GS-EC05-037 | Acceptance replay                       | Ya ACCEPTED.                                                    | Repeat same token/key.          | Mismo result; no duplicate receipt.                                       | UQ/idempotency.        |
| GS-EC05-038 | Aceptar token expirado                  | expires_at pasado.                                              | Accept.                         | 410/422; no receipt.                                                      | ProblemDetail.         |
| GS-EC05-039 | Actor incorrecto acepta                 | Token de otra person.                                           | Accept.                         | 403\.                                                                     | Auth/audit.            |
| GS-EC05-040 | Activar sin acceptance requerida false  | acceptance_required=false + requirements pass.                  | Activate.                       | ACTIVE según policy.                                                      | State.                 |
| GS-EC05-041 | Activar con acceptance faltante         | acceptance_required=true.                                       | Activate.                       | DB/domain reject.                                                         | Trigger.               |
| GS-EC05-042 | Freeze identidad aceptada               | Assignment ACCEPTED.                                            | UPDATE person_ref/role.         | DB reject.                                                                | Trigger.               |
| GS-EC05-043 | Reemplazo correcto                      | Old ACTIVE; new eligible.                                       | Replace.                        | Old REPLACED + new row lineage.                                           | DB+audit.              |
| GS-EC05-044 | Reemplazo no overwrite                  | Old ACTIVE.                                                     | Intentar cambiar person_ref.    | Reject; use replacement command.                                          | Trigger/ProblemDetail. |
| GS-EC05-045 | Completar assignment                    | ACTIVE y finalización válida.                                   | Complete.                       | COMPLETED terminal.                                                       | State history/audit.   |
| GS-EC05-046 | Crear ContentPackage                    | Owner/scope valid.                                              | Create.                         | Package unique.                                                           | DB+audit.              |
| GS-EC05-047 | Crear content version                   | Package active.                                                 | Create V1.                      | DRAFT.                                                                    | DB.                    |
| GS-EC05-048 | Agregar document item                   | document_ref CT-05 válido.                                      | Add item.                       | Exactly document target.                                                  | DB+contract.           |
| GS-EC05-049 | Agregar external resource item          | CT-18 resource válido.                                          | Add.                            | Exactly external target.                                                  | DB.                    |
| GS-EC05-050 | Rechazar multiple targets               | document_ref + lms_resource_ref.                                | Add.                            | DB reject.                                                                | CHECK.                 |
| GS-EC05-051 | Orden content duplicado                 | Item sequence ya usado.                                         | Add.                            | DB reject.                                                                | UQ.                    |
| GS-EC05-052 | Rights válido                           | License/evidence vigente.                                       | Bind rights.                    | Binding válido.                                                           | DB+evidence.           |
| GS-EC05-053 | Rights expirado                         | valid_to pasado.                                                | Publish content.                | 422 RIGHTS_EXPIRED.                                                       | ValidationReport.      |
| GS-EC05-054 | Rights unknown                          | Sin evidence/policy requiere proof.                             | Publish.                        | FAIL closed.                                                              | Report.                |
| GS-EC05-055 | Release immediate                       | Item DRAFT.                                                     | Set IMMEDIATE rule.             | Persistido.                                                               | DB.                    |
| GS-EC05-056 | Release relative session                | SESSION_START offset.                                           | Set rule.                       | Persistido; no schedule local.                                            | DB+contract.           |
| GS-EC05-057 | Release item cross-version              | Rule version A + item B.                                        | Persistir.                      | DB reject.                                                                | Composite FK.          |
| GS-EC05-058 | Publicar content version                | Rights/accessibility PASS.                                      | Publish.                        | PUBLISHED + content hash + receipt.                                       | DB+event.              |
| GS-EC05-059 | Mutar item publicado                    | Content PUBLISHED.                                              | Update title/target.            | DB reject.                                                                | Trigger.               |
| GS-EC05-060 | Mutar rights publicado                  | Content PUBLISHED.                                              | Update rights row.              | DB reject.                                                                | Trigger.               |
| GS-EC05-061 | Clonar content PUBLISHED                | V1 published.                                                   | Clone V2.                       | DRAFT lineage.                                                            | DB+audit.              |
| GS-EC05-062 | Superseder content                      | V2 publish.                                                     | Publish V2.                     | V1 SUPERSEDED/V2 PUBLISHED.                                               | Transaction.           |
| GS-EC05-063 | Pinear content en plan                  | Plan DRAFT, item published.                                     | Create binding.                 | Pinned item id; plan ETag bump.                                           | DB+ETag.               |
| GS-EC05-064 | Binding scope UNIT correcto             | Unit same revision.                                             | Bind content.                   | Persistido.                                                               | Composite FK.          |
| GS-EC05-065 | Binding scope ambiguo                   | UNIT + module.                                                  | Bind.                           | DB reject.                                                                | CHECK.                 |
| GS-EC05-066 | Content CT-05 unavailable               | Preview query falla.                                            | Abrir Content Library.          | UNAVAILABLE, no “missing”.                                                | UI+trace.              |
| GS-EC05-067 | Signed URL no persistente               | Content view.                                                   | Inspect local DB/log.           | No signed URL persistida/logged.                                          | Security test.         |
| GS-EC05-068 | Accessibility missing                   | Policy requiere profile.                                        | Publish.                        | 422 ACCESSIBILITY_REQUIRED.                                               | Validation.            |
| GS-EC05-069 | Business key immutable                  | Package tiene history published.                                | Rename package_code.            | Reject policy/domain.                                                     | Test.                  |
| GS-EC05-070 | Reconstruct content snapshot            | Años después.                                                   | Load receipt/hash/items/rights. | Mismo snapshot verificable.                                               | Evidence pack.         |
| GS-EC05-071 | Provision LMS confirmed                 | Plan PUBLISHED; CT-18 healthy.                                  | CREATE intent.                  | 202/CONFIRMED, receipt+space binding.                                     | Operation+receipt.     |
| GS-EC05-072 | Timeout before send                     | CT-18 unreachable pre-send.                                     | Provision.                      | FAILED_RECOVERABLE/NOT_APPLIED known.                                     | Trace.                 |
| GS-EC05-073 | Timeout after apply                     | Remote created but response lost.                               | Provision.                      | UNKNOWN_EFFECT; no retry.                                                 | Intent+receipt.        |
| GS-EC05-074 | Reconcile applied                       | UNKNOWN_EFFECT + remote query finds course.                     | Reconcile.                      | CONFIRMED + one binding, no duplicate course.                             | Receipt.               |
| GS-EC05-075 | Reconcile not applied                   | UNKNOWN_EFFECT + remote says absent.                            | Reconcile.                      | NOT_APPLIED; retry allowed.                                               | Receipt/audit.         |
| GS-EC05-076 | Reconcile still unknown                 | Provider query unavailable.                                     | Reconcile.                      | Remain UNKNOWN_EFFECT + alert.                                            | Operation status.      |
| GS-EC05-077 | Duplicate provisioning request          | Same key/payload.                                               | Replay.                         | Same intent/operation.                                                    | Idempotency.           |
| GS-EC05-078 | Same key different payload              | Key reused action/scope changed.                                | Submit.                         | 409\.                                                                     | ProblemDetail.         |
| GS-EC05-079 | Two outbox workers                      | Same events ready.                                              | Claim concurrent.               | Each event one owner lease.                                               | SKIP LOCKED test.      |
| GS-EC05-080 | Worker crash IN_FLIGHT                  | Lease expires.                                                  | New worker reclaim.             | Event retried safely.                                                     | Lease metrics.         |
| GS-EC05-081 | External space STALE                    | lastVerified beyond threshold.                                  | Open Ops.                       | STALE badge; refresh action.                                              | UI.                    |
| GS-EC05-082 | External space UNAVAILABLE              | CT-18 down.                                                     | Query.                          | UNAVAILABLE, not ARCHIVED.                                                | UI/trace.              |
| GS-EC05-083 | Archive space                           | Provider confirms.                                              | Archive.                        | Remote receipt + local ARCHIVED; history remains.                         | Audit.                 |
| GS-EC05-084 | Archive timeout                         | Remote may have archived.                                       | Archive.                        | UNKNOWN_EFFECT; reconcile.                                                | Operation.             |
| GS-EC05-085 | Recording policy session                | Session scope valid.                                            | Bind recording policy.          | Pinned refs; no binary.                                                   | DB.                    |
| GS-EC05-086 | Recording without consent policy        | Policy requires consent.                                        | Validate plan.                  | FAIL.                                                                     | Validation.            |
| GS-EC05-087 | Recording file appears                  | Provider returns recording.                                     | Ingest.                         | CT-05 document_ref only; no blob EC-05.                                   | Contract.              |
| GS-EC05-088 | Recording rights conflict               | Speaker material rights forbid recording.                       | Validate/publish.               | Block/warning per policy, no silent record.                               | Evidence.              |
| GS-EC05-089 | Provider webhook duplicate              | Same message id twice.                                          | Consume.                        | Inbox dedup, one state effect.                                            | Inbox.                 |
| GS-EC05-090 | Provider webhook forged                 | Invalid signature/trust.                                        | Receive.                        | Reject; no state change.                                                  | Security audit.        |
| GS-EC05-091 | Cross-tenant plan read                  | Tenant A token + B id.                                          | GET.                            | 404/403; no B data.                                                       | RLS test.              |
| GS-EC05-092 | Cross-tenant SQL without predicate      | Runtime role.                                                   | SELECT table.                   | RLS only own rows.                                                        | DB test.               |
| GS-EC05-093 | Body tenant injection                   | Request includes tenant B.                                      | POST.                           | Ignored/rejected; context A used.                                         | API test.              |
| GS-EC05-094 | Step-up publish                         | Publisher low assurance.                                        | Publish.                        | 403 STEP_UP_REQUIRED.                                                     | IAM flow.              |
| GS-EC05-095 | SoD violation                           | Designer tries sole approval where prohibited.                  | Approve.                        | 403/422.                                                                  | Workflow audit.        |
| GS-EC05-096 | Mobile invitation happy path            | Instructor authenticated + valid deep link.                     | Accept.                         | Receipt + updated mobile state.                                           | RN E2E.                |
| GS-EC05-097 | Mobile offline accept                   | No network.                                                     | Tap accept.                     | No local success; pending/online required.                                | RN test.               |
| GS-EC05-098 | Mobile stale agenda                     | Cached session then changed.                                    | Open offline.                   | STALE/asOf banner.                                                        | UI screenshot.         |
| GS-EC05-099 | Mobile material offline prohibited      | Rights policy denies offline.                                   | Download.                       | Blocked; streaming/access online only.                                    | Policy test.           |
| GS-EC05-100 | Migration person ambiguous              | Legacy instructor fuzzy match multiple.                         | Dry-run.                        | REVIEW/FAIL; no Person created.                                           | CT16 report.           |
| GS-EC05-101 | Migration historical assignment         | Person/edition resolvable.                                      | Promote terminal assignment.    | History imported with lineage/provenance, no invented acceptance.         | Migration receipt.     |
| GS-EC05-102 | Migration content rights unknown        | Legacy file has no license evidence.                            | Dry-run.                        | Quarantine/blocked.                                                       | DQ report.             |
| GS-EC05-103 | Migration direct INSERT attempt         | Engineer bypasses domain.                                       | Run prohibited path.            | Process fails review/gate; RLS/constraints protect invariants.            | Gate evidence.         |
| GS-EC05-104 | AI suggests instructor                  | Authorized profile facts.                                       | Request CT-12.                  | Recommendation only, no assignment row.                                   | AI run refs.           |
| GS-EC05-105 | AI attempts sensitive inference         | Prompt requests health/ethnicity inference.                     | Run.                            | Blocked by CT-12/policy.                                                  | AI safety eval.        |
| GS-EC05-106 | AI suggests content with expired rights | Catalog stale.                                                  | Apply suggestion.               | Server revalidation rejects rights.                                       | API+AI eval.           |
| GS-EC05-107 | AI plan apply stale ETag                | Suggestion based on ETag 4, plan now 5.                         | Apply.                          | 412 and human rebase.                                                     | API test.              |
| GS-EC05-108 | Bulk invitation partial                 | 1000 assignments, 20 invalid.                                   | Run async.                      | Operation terminal with per-item results; no false all-success.           | Operation report.      |
| GS-EC05-109 | Bulk provisioning provider quota        | Provider rate limits.                                           | Run async.                      | 429/backoff/partial; idempotent resume.                                   | Metrics+operation.     |
| GS-EC05-110 | Disaster recovery restore               | Restore PostgreSQL from backup.                                 | Rebuild read models/cache.      | Assignments/content/receipts intact; Mongo/Redis reconstruct.             | DR evidence.           |

# 30. UAT institucional

| **ID**     | **Área**      | **Escenario UAT**                           | **Criterio de aceptación**                                                      |
|------------|---------------|---------------------------------------------|---------------------------------------------------------------------------------|
| **UAT-01** | Plan          | Crear y publicar plan para curso presencial | Usuario negocio reconoce modules/units/roles y receipt; no necesita workaround. |
| **UAT-02** | Plan          | Clonar plan para nueva estrategia           | Historia anterior intacta y diff comprensible.                                  |
| **UAT-03** | Plan          | Plan future SCHEDULED                       | No editable; activación futura entendible.                                      |
| **UAT-04** | Assignments   | Asignar docente interno                     | Person y engagement refs correctos; no PII/HR shadow.                           |
| **UAT-05** | Assignments   | Asignar experto externo                     | Role académico funciona sin exigir employee cuando policy lo permite.           |
| **UAT-06** | Assignments   | Invitar y aceptar                           | Instructor entiende terms/role/hours y aceptación queda evidenciada.            |
| **UAT-07** | Assignments   | Requirement caducado                        | Coordinator ve bloqueador y acción clara.                                       |
| **UAT-08** | Assignments   | Reemplazo de última hora                    | Old/new lineage visible; sessions impacted identificadas.                       |
| **UAT-09** | Assignments   | Speaker de una sola sesión                  | Scope SESSION funciona sin crear assignment global.                             |
| **UAT-10** | Content       | Crear package reusable                      | Puede reutilizarse en dos planes sin duplicar archivo.                          |
| **UAT-11** | Content       | Publicar version con rights                 | Governance ve license/evidence/expiry.                                          |
| **UAT-12** | Content       | Rights expirados                            | Publish bloqueado con razón accionable.                                         |
| **UAT-13** | Content       | Release por session start                   | Regla entendible y no confundida con schedule.                                  |
| **UAT-14** | Content       | Accesibilidad                               | Perfil/revisión visible y bloqueos por policy correctos.                        |
| **UAT-15** | LMS           | Provisionar Moodle                          | Usuario ve 202/status/space confirmado.                                         |
| **UAT-16** | LMS           | Provisioning timeout                        | Usuario ve UNKNOWN_EFFECT y Reconcile, no Retry directo.                        |
| **UAT-17** | LMS           | Archivar espacio                            | Efecto remoto reconciliado e historia conservada.                               |
| **UAT-18** | Recording     | Definir recording privado cohort            | Consent/retention/policy refs visibles.                                         |
| **UAT-19** | Mobile        | Instructor acepta assignment                | Journey simple y seguro.                                                        |
| **UAT-20** | Mobile        | Instructor consulta agenda/material         | Stale/offline states claros.                                                    |
| **UAT-21** | Security      | Actor sin scope intenta assignment          | Acceso negado sin data leak.                                                    |
| **UAT-22** | Security      | Step-up publish                             | Handoff IAM correcto.                                                           |
| **UAT-23** | SoD           | Designer intenta auto-aprobar               | Bloqueado conforme policy.                                                      |
| **UAT-24** | Audit         | Auditor reconstruye publicación             | Hash/policy/workflow/actor/evidence accesibles.                                 |
| **UAT-25** | Audit         | Auditor reconstruye replacement             | Old/new assignments y reason trazables.                                         |
| **UAT-26** | Migration     | Importar roster de docentes                 | Ambiguos quedan review; no duplicados.                                          |
| **UAT-27** | Migration     | Importar materiales                         | Document refs/rights preserved; unknown not auto-valid.                         |
| **UAT-28** | Ops           | Reconcile unknown effects                   | Queue, age, action/evidence útiles.                                             |
| **UAT-29** | Performance   | Assignment desk con volumen real            | Filtros/paging p95 dentro SLO.                                                  |
| **UAT-30** | Accessibility | Navegar workspaces solo teclado             | WCAG 2.2 AA acceptance.                                                         |

# 31. Gates G1-G10

| **Gate** | **Tema**                       | **Evidencia mínima**                                                                | **Aprobador**        |
|----------|--------------------------------|-------------------------------------------------------------------------------------|----------------------|
| **G1**   | Arquitectura y bounded context | Context map, DA/ADR, SoT matrix, module boundaries, cross-context contract map.     | Architect + Product  |
| **G2**   | Datos/constraints              | DER físico, Flyway from-scratch/N-1, RLS tests, state/lineage/append-only evidence. | DBA + Backend        |
| **G3**   | Backend                        | Aggregates/policies/ports, idempotency/outbox, assignment/content state tests.      | Backend Lead         |
| **G4**   | API/Event contracts            | OpenAPI/AsyncAPI, ProblemDetails, ETag, pagination, compatibility tests.            | API/Integration Lead |
| **G5**   | Frontend/Mobile                | Workspaces, service states, 412 UX, accessibility, RN journeys.                     | Frontend/Mobile Lead |
| **G6**   | Seguridad/auditoría            | Threat model, RBAC/ABAC/SoD/step-up, RLS, token/privacy, evidence.                  | Security             |
| **G7**   | Integraciones/resiliencia      | CT-18 fault injection, UNKNOWN_EFFECT/reconcile, circuit/backoff, leased outbox.    | Integration/SRE      |
| **G8**   | QA/UAT                         | Golden Scenarios, E2E, UAT sign-off, regression evidence.                           | QA + Business        |
| **G9**   | Migración/operaciones          | CT-16 dry-run, runbooks, DR/RTO/RPO, observability dashboards.                      | Data + SRE           |
| **G10**  | Release/certificación          | DoD, performance/SLO, secure SDLC clean, evidence pack complete.                    | Release Board        |

| **NO EVIDENCE, NO GATE —** Un Gate no se aprueba por reunión verbal. Cada conclusión debe tener artifact/trace/test/report/sign-off reproducible enlazado desde /evidence/ec05/gates. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 32. Definition of Ready / Definition of Done

## 32.1 Definition of Ready

- EC-00/01/02/04/CT contracts relevantes identificados y vigentes.

- Bounded context, Source of Truth y anti-scope aceptados.

- Person/Employment/Session/Content/LMS owners confirmados.

- State machines y policies variables identificadas.

- OpenAPI/AsyncAPI draft con examples/error semantics.

- DER/physical model con tenant/RLS strategy revisada.

- Threat model inicial y data classification definidos.

- UX journeys/workspaces y Mobile scope aprobados.

- Golden Scenarios críticos marcados como automation targets.

- Dependencies tienen sandbox/mock/contract fixture disponible.

## 32.2 Definition of Done

- Flyway limpio y upgrade N-1 pasan en CI.

- Todas las tablas tenant-owned RLS FORCE y negative tests verdes.

- OpenAPI/AsyncAPI publicados y generated client consumido por Frontend.

- Unit/domain/repository/integration/security/concurrency/idempotency/resilience tests verdes.

- Golden Scenarios críticos automatizados; resto evidence/test plan trazable.

- Web/Mobile accessibility y visual regression aprobados.

- CT-18 UNKNOWN_EFFECT drills ejecutados.

- SLO/performance budgets validados.

- SAST/SCA/secrets/container/SBOM gates sin High/Critical no exceptuados.

- UAT firmado y Gates G1-G10 con evidence.

- Runbooks y dashboards/alerts productivos verificados.

- No TODO arquitectónico P0/P1 abierto sin ADR explícito/owner/date.

# 33. Runbooks

| **ID**          | **Runbook**                         | **Trigger**                            | **Secuencia resumida**                                                                              |
|-----------------|-------------------------------------|----------------------------------------|-----------------------------------------------------------------------------------------------------|
| **RB-EC05-001** | CT-18 indisponible                  | Circuit open/503                       | Declarar UNAVAILABLE; detener remote commands; no asumir no-effect; revisar intents enviados.       |
| **RB-EC05-002** | Provisioning UNKNOWN_EFFECT         | Intent age threshold                   | Query-status por remoteRef/key; confirmar/no-applied; solo luego retry.                             |
| **RB-EC05-003** | Curso LMS duplicado                 | Dos remote spaces detectados           | Freeze automation; identificar canonical por receipts; archive duplicate con new command; evidence. |
| **RB-EC05-004** | Outbox backlog                      | Backlog/age SLO                        | Revisar broker, leases, poison events; reclaim/replay gobernado.                                    |
| **RB-EC05-005** | Outbox lease orphan                 | IN_FLIGHT lease expired                | Reclaim SKIP LOCKED; preserve event id; increment attempts.                                         |
| **RB-EC05-006** | Idempotency stuck                   | IN_PROGRESS lease expired              | Verificar side effects/DB truth; recover owner; replay same response or reconcile.                  |
| **RB-EC05-007** | RLS incident                        | Cross-tenant indicator                 | Sev-1; revoke traffic/credentials; preserve logs; forensic scope; notify governance.                |
| **RB-EC05-008** | Invitation token exposure           | Secret suspected leaked                | Revoke invitation; issue new token; audit access/log sinks; rotate if systemic.                     |
| **RB-EC05-009** | Assignment acceptance dispute       | Instructor disputes terms              | Freeze evidence refs; retrieve terms hash/policy/assurance; no mutate receipt; governance review.   |
| **RB-EC05-010** | Instructor no disponible            | Active/accepted instructor unavailable | Create change request/replacement; assess session impact; notify; preserve old assignment.          |
| **RB-EC05-011** | Requirement expires before delivery | Expiry alert                           | Re-evaluate/request evidence; block activation if mandatory; document waiver if authorized.         |
| **RB-EC05-012** | Person service unavailable          | CT-04 outage                           | Use cached display only with STALE; no new identity-critical assignment if policy fail-closed.      |
| **RB-EC05-013** | RRHH engagement mismatch            | Engagement invalid/ended               | Do not rewrite assignment; assess policy; suspend/replace via governed command.                     |
| **RB-EC05-014** | Rights expiring                     | valid_to threshold                     | Identify usages; obtain new evidence/version; block future publish if unresolved.                   |
| **RB-EC05-015** | Rights incident/takedown            | Legal/privacy notice                   | Suspend access via CT-05/18; create content change/version; retain evidence; no destructive delete. |
| **RB-EC05-016** | Content artifact unavailable        | CT-05 503/missing doc                  | Mark UNAVAILABLE; verify document ref; fail-closed for required content publish.                    |
| **RB-EC05-017** | LMS content sync drift              | Remote checksum/status differs         | Compare pinned content; sync idempotently; receipt; no overwrite local truth.                       |
| **RB-EC05-018** | Recording privacy incident          | Recording exposed incorrectly          | Suspend remote access; revoke links; CT-05/10 incident; preserve evidence and policy refs.          |
| **RB-EC05-019** | Recording missing                   | Expected recording absent              | Query provider status; distinguish NOT_CREATED/UNAVAILABLE/UNKNOWN_EFFECT; no fake document.        |
| **RB-EC05-020** | External space stale                | lastVerified exceeds SLO               | Refresh via CT-18; update observed state; escalate unknown.                                         |
| **RB-EC05-021** | Provider quota/rate limit           | 429                                    | Backoff+jitter; respect Retry-After; OperationStatus PARTIAL/RUNNING; no bulk storm.                |
| **RB-EC05-022** | Bulk provisioning partial           | Some items failed                      | Export per-item reasons; retry only safe/not-applied; preserve successful refs.                     |
| **RB-EC05-023** | Migration duplicate instructor      | Ambiguous/multiple person match        | Quarantine; manual CT-04 resolution; do not fuzzy merge.                                            |
| **RB-EC05-024** | Disaster recovery                   | Region/DB recovery                     | Restore Postgres; validate RLS/receipts; rebuild Mongo/Redis; reconcile CT-18 before writes.        |
| **RB-EC05-025** | Emergency plan correction           | Critical published error               | Create new revision/change request; step-up publish; supersede old; notify downstream.              |

# 34. ADRs y decisiones abiertas

| **ADR**          | **Decisión**                             | **Estado**         | **Resolución/acción**                                                                        |
|------------------|------------------------------------------|--------------------|----------------------------------------------------------------------------------------------|
| **ADR-EC05-001** | TeachingPlan por Edition                 | Adoptado           | Una identidad plan por edition; branch requiere ADR futuro.                                  |
| **ADR-EC05-002** | Assignment separado de RRHH              | Adoptado           | Academic role con engagement_ref externo.                                                    |
| **ADR-EC05-003** | Snapshot vs assignment lifecycle         | Adoptado           | Plan design frozen; assignment operational state puede progresar.                            |
| **ADR-EC05-004** | Replacement by lineage                   | Adoptado           | Nuevo assignment; no update person_ref.                                                      |
| **ADR-EC05-005** | ContentPackage reusable                  | Adoptado           | Content version independiente del plan.                                                      |
| **ADR-EC05-006** | Documents via CT-05                      | Adoptado           | No blobs en EC-05.                                                                           |
| **ADR-EC05-007** | External ecosystem via CT-18             | Adoptado           | No SDK directos vendor.                                                                      |
| **ADR-EC05-008** | UNKNOWN_EFFECT                           | Adoptado           | Reconcile-before-retry obligatorio.                                                          |
| **ADR-EC05-009** | RLS FORCE                                | Adoptado           | Defense-in-depth tenant isolation.                                                           |
| **ADR-EC05-010** | Aggregate Revision                       | Adoptado           | Child design mutations bump root.                                                            |
| **ADR-EC05-011** | SCHEDULED state                          | Adoptado           | Future committed immutable snapshot.                                                         |
| **ADR-EC05-012** | Rights as first-class binding            | Adoptado           | Availability no implica right to use.                                                        |
| **ADR-EC05-013** | Recording policy binding                 | Adoptado           | Consent/retention/document separate.                                                         |
| **ADR-EC05-014** | Assignment invitation token              | Adoptado           | Hash-only one-shot.                                                                          |
| **ADR-EC05-015** | OpenAPI generated client                 | Adoptado           | Single DTO contract.                                                                         |
| **ADR-EC05-016** | Outbox leased claiming                   | Adoptado           | SKIP LOCKED + lease.                                                                         |
| **ADR-EC05-017** | Mongo/Redis derived only                 | Adoptado           | Postgres truth; rebuildable projections.                                                     |
| **ADR-EC05-018** | Mobile administrative limits             | Adoptado           | Instructor journeys only; critical governance Web.                                           |
| **ADR-EC05-019** | Provider abstraction granularity         | Abierto controlado | Definir capabilities matrix por CT-18 antes de cada adapter.                                 |
| **ADR-EC05-020** | Content standards SCORM/xAPI/LTI profile | Abierto controlado | CT-18/interoperability baseline a cerrar por provider/use case; no cambiar domain ownership. |

# 35. Engineering Pack

| **Ruta**                                                           | **Contenido mínimo**                                        |
|--------------------------------------------------------------------|-------------------------------------------------------------|
| **/docs/ec05/EC-05.docx**                                          | Especificación maestra oficial aprobada.                    |
| **/openapi/ec05-teaching-delivery-v1.yaml**                        | REST contract + ProblemDetail + examples + pagination/ETag. |
| **/asyncapi/ec05-teaching-events-v1.yaml**                         | Event envelope/schemas/compatibility.                       |
| **/db/migration/ec05/V1\_\_ec05_teaching_delivery_foundation.sql** | DDL inicial Flyway.                                         |
| **/architecture/ec05/context.md**                                  | Context map + SoT + anti-scope + dependency map.            |
| **/architecture/ec05/domain.md**                                   | Aggregates/state machines/policies.                         |
| **/adr/ec05/ADR-EC05-\*.md**                                       | ADRs con status/evidence.                                   |
| **/backend/ec05**                                                  | Module/package conventions y ArchitectureTests.             |
| **/frontend/ec05**                                                 | Workspaces/routes/generated client/query conventions.       |
| **/mobile/ec05**                                                   | Instructor journeys/offline/deep-link contract.             |
| **/tests/ec05/domain**                                             | Unit/domain/property tests.                                 |
| **/tests/ec05/integration**                                        | Postgres/RLS/ETag/CT adapters.                              |
| **/tests/ec05/contracts**                                          | OpenAPI/AsyncAPI/CT-18 compatibility.                       |
| **/tests/ec05/e2e**                                                | Playwright/RN E2E Golden Scenarios.                         |
| **/performance/ec05**                                              | k6/Gatling scripts/results/EXPLAIN.                         |
| **/security/ec05/threat-model.md**                                 | Threat model/abuse cases.                                   |
| **/security/ec05/evidence**                                        | SAST/SCA/SBOM/secrets/container/DAST reports.               |
| **/runbooks/ec05/RB-EC05-\*.md**                                   | Runbooks.                                                   |
| **/observability/ec05**                                            | Dashboards/alerts/SLI/SLO.                                  |
| **/migration/ec05**                                                | CT-16 mappings/fixtures/receipts.                           |
| **/evidence/ec05/gates**                                           | Evidence G1-G10.                                            |
| **/evidence/ec05/uat**                                             | UAT sign-offs/captures.                                     |

# 36. Guía secuencial Backend

1.  Paso 1 — Crear módulo Spring Modulith ec.teachingdelivery y ArchitectureTests de boundaries.

2.  Paso 2 — Definir Value Objects TenantId, ExternalRef, PolicyVersionRef, TeachingRole, AssignmentScope, ContentTarget, ContentHash, AggregateRevision, IdempotencyKey y OperationId.

3.  Paso 3 — Implementar TeachingPlan aggregate root y business key por edition.

4.  Paso 4 — Implementar TeachingPlanRevision state machine/lineage/SCHEDULED/PUBLISHED inmutable.

5.  Paso 5 — Implementar TeachingPlanModule e InstructionalUnitPlan como children de diseño con root revision bump.

6.  Paso 6 — Implementar TeachingTeam con scope XOR y freeze estructural post-publish.

7.  Paso 7 — Implementar InstructorAssignment como aggregate operacional con state guard y freeze de person/role/scope tras ACCEPTED.

8.  Paso 8 — Implementar replacement lineage: new assignment + old REPLACED, nunca setter personRef.

9.  Paso 9 — Implementar AssignmentRequirement y append-only Result con freshness policy.

10. Paso 10 — Implementar Invitation hash-only/expiry/rate-limited y AcceptanceReceipt append-only.

11. Paso 11 — Implementar TeachingChangeRequest + WorkflowPort CT-06.

12. Paso 12 — Implementar LearningContentPackage/Version, state/lineage y content aggregate revision.

13. Paso 13 — Implementar ContentItem discriminated target XOR y pinning.

14. Paso 14 — Implementar rights/accessibility/release policies y validators.

15. Paso 15 — Implementar TeachingContentBinding scope XOR y composite FKs.

16. Paso 16 — Implementar RecordingPolicyBinding sin blobs/consents locales.

17. Paso 17 — Implementar ExternalLearningSpaceBinding como remote observation local.

18. Paso 18 — Implementar LmsProvisioningIntent/Receipt + CT-18 port + UNKNOWN_EFFECT state.

19. Paso 19 — Aplicar Flyway V1 con Testcontainers PostgreSQL real.

20. Paso 20 — Configurar migrator/runtime/worker DB roles; runtime no owner/BYPASSRLS.

21. Paso 21 — Implementar TenantTransactionInterceptor con SET LOCAL peopleu.tenant_id.

22. Paso 22 — Implementar ETag/If-Match root/operational aggregates y 412 translation.

23. Paso 23 — Implementar publication transaction: validation + state + receipt + outbox.

24. Paso 24 — Implementar CommandIdempotency durable con request hash/owner/lease/recovery.

25. Paso 25 — Implementar outbox/inbox y dispatcher SKIP LOCKED + lease/backoff/poison handling.

26. Paso 26 — Implementar OperationStatus para bulk/provision/reconcile; 202 siempre operationId.

27. Paso 27 — Implementar ports CT-01/02/03/04/05/06/07/08/09/10/11/12/13/14/15/16/18, EC-01/02 y RRHH sin table access.

28. Paso 28 — Configurar timeout/retry/circuit/freshness por port; writes remotos solo idempotent/query-status/reconcile.

29. Paso 29 — Implementar REST controllers/application services y RFC ProblemDetail reason codes.

30. Paso 30 — Publicar OpenAPI/AsyncAPI y generated TS client contract tests.

31. Paso 31 — Instrumentar logs/traces/metrics con redaction de PII/tokens/signed URLs.

32. Paso 32 — Completar domain/repository/RLS/concurrency/idempotency/resilience/security tests.

33. Paso 33 — Ejecutar performance/load de assignment desk/content/bulk/CT-18 workflows.

34. Paso 34 — Ensayar provider timeout after apply, duplicate webhook, outbox crash, DB restore y N/N-1 rollout.

35. Paso 35 — Cerrar Evidence Pack G1-G10 antes de release.

# 37. Guía secuencial Frontend

36. Paso 1 — Crear feature root src/features/ec05-teaching y rutas por workspace.

37. Paso 2 — Generar TypeScript client desde OpenAPI; prohibir DTOs manuales duplicados.

38. Paso 3 — Definir query keys por tenant/scope/resource/filter/revision y invalidación version-aware.

39. Paso 4 — Crear WorkspaceShell con scope, breadcrumbs, dependency health y permissions.

40. Paso 5 — Construir Teaching Plan Studio con revision banner, ETag, readiness y tabs.

41. Paso 6 — Implementar modules/units editors con DRAFT-only controls y server validation.

42. Paso 7 — Implementar Validation/Review/Publish flow con step-up y exact snapshot hash.

43. Paso 8 — Implementar 412 conflict drawer: server diff/reload/manual reapply; no silent retry.

44. Paso 9 — Construir Teaching Operations Board con gaps/readiness/LMS health.

45. Paso 10 — Construir Assignment Desk con filtros, drawer timeline y requirement freshness.

46. Paso 11 — Implementar create assignment wizard con Person lookup y policy preview.

47. Paso 12 — Implementar invitation/acceptance/readiness UI sin exponer token secreto.

48. Paso 13 — Implementar replacement wizard con old/new lineage, impact y approvals.

49. Paso 14 — Construir Content Library con packages/versions/items/rights/accessibility/usages.

50. Paso 15 — Implementar discriminated union form para ContentTarget y limpieza de campos incompatibles.

51. Paso 16 — Implementar rights expiry/accessibility warnings y publish blockers.

52. Paso 17 — Construir Content usage/diff views antes de supersede.

53. Paso 18 — Construir Learning Space Console con provisioning intent/state/remoteRef freshness.

54. Paso 19 — Implementar UNKNOWN_EFFECT UI con Reconcile como acción primaria y Retry bloqueado.

55. Paso 20 — Implementar OperationStatus polling/backoff/push para 202 y bulk.

56. Paso 21 — Construir Reconciliation Center para unknown effects/outbox/stale external spaces.

57. Paso 22 — Construir Instructor Portal Web: assignments, agenda, materials, notifications.

58. Paso 23 — Implementar service-state component NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.

59. Paso 24 — Aplicar RBAC/ABAC UI guards como UX; Backend sigue autoridad.

60. Paso 25 — Implementar IAM step-up handoff para publish/void/high-risk actions.

61. Paso 26 — Aplicar WCAG 2.2 AA, keyboard/focus/error summary/contrast/responsive.

62. Paso 27 — Crear React Native Instructor journeys reutilizando generated contracts.

63. Paso 28 — Offline mobile solo cache/read cuando policy permite; accept/remote mutations requieren online.

64. Paso 29 — Minimizar local storage y resolver signed links just-in-time.

65. Paso 30 — Instrumentar frontend telemetry con correlationId sin PII/secrets.

66. Paso 31 — Crear unit/component/MSW contract fixtures y Playwright/RN E2E.

67. Paso 32 — Validar localization CT-08 y timezone institucional/usuario.

68. Paso 33 — Ensayar degraded modes CT-04/05/18 y evitar empty-state false positives.

69. Paso 34 — Cerrar visual regression/UAT evidence antes de G5/G8/G10.

# 38. Matriz de permisos

| **Capacidad**                 | **Plan Designer** | **Coordinator** | **Approver**   | **Content Designer** | **Content Gov/Publisher** | **Ops** | **Auditor/Governance** | **Instructor** |
|-------------------------------|-------------------|-----------------|----------------|----------------------|---------------------------|---------|------------------------|----------------|
| Ver TeachingPlans             | R/W               | R               | R              | R                    | R                         | R       | R                      | Own/assigned   |
| Crear/editar DRAFT plan       | R/W               | R/W limited     | R              | \-                   | \-                        | \-      | R                      | \-             |
| Solicitar review              | R/W               | R               | R              | \-                   | \-                        | \-      | R                      | \-             |
| Aprobar plan                  | \-                | \-              | R/W            | \-                   | \-                        | \-      | R high-risk            | \-             |
| Publicar/SCHEDULED            | \-                | \-              | R approve      | \-                   | R/W publish role          | \-      | R governance           | \-             |
| Crear TeachingTeam            | R                 | R/W             | R              | \-                   | \-                        | \-      | R                      | \-             |
| Crear assignment              | R                 | R/W             | R              | \-                   | \-                        | \-      | R                      | \-             |
| Gestionar requirements        | R                 | R/W             | R/W waiver     | \-                   | \-                        | \-      | R                      | Own read       |
| Emitir invitation             | \-                | R/W             | \-             | \-                   | \-                        | \-      | R                      | \-             |
| Aceptar/declinar assignment   | \-                | \-              | \-             | \-                   | \-                        | \-      | R audit                | R/W own        |
| Reemplazar instructor         | R                 | R/W initiate    | R/W approve    | \-                   | \-                        | \-      | R                      | \-             |
| Crear content package/version | R/W limited       | \-              | \-             | R/W                  | R                         | \-      | R                      | \-             |
| Gestionar rights              | R                 | \-              | \-             | R/W                  | R/W governance            | \-      | R                      | \-             |
| Publicar content              | \-                | \-              | R              | R initiate           | R/W publisher             | \-      | R                      | \-             |
| Provisionar LMS               | R                 | R               | \-             | \-                   | \-                        | R/W     | R                      | Deep link only |
| Reconcile UNKNOWN_EFFECT      | R                 | R               | \-             | \-                   | \-                        | R/W     | R                      | \-             |
| Void snapshot                 | \-                | \-              | R/W governance | \-                   | R/W governance            | \-      | R                      | \-             |
| Export evidence               | R scoped          | R scoped        | R              | R                    | R                         | R       | R/W audit              | Own limited    |

# 39. Contratos DTO Frontend

Los DTO siguientes son modelos de contrato; la fuente ejecutable es OpenAPI y el cliente TypeScript se genera. Frontend no debe inventar variantes locales de estados o fields.

type ServiceDataState = 'FRESH' \| 'STALE' \| 'PARTIAL' \| 'UNAVAILABLE' \| 'UNKNOWN_EFFECT';

type TeachingPlanRevisionDto = {

id: string;

teachingPlanId: string;

revisionNo: number;

state: 'DRAFT'\|'IN_REVIEW'\|'APPROVED'\|'SCHEDULED'\|'PUBLISHED'\|'SUPERSEDED'\|'VOID';

editionRef: string;

programVersionRef: string;

contentHash?: string;

version: number;

readiness: ValidationSummary;

};

type InstructorAssignmentDto = {

id: string;

teachingPlanRevisionId: string;

personRef: string;

roleCode: string;

assignmentScope: 'PLAN'\|'MODULE'\|'SESSION';

teachingPlanModuleId?: string;

sessionRef?: string;

plannedHours: string;

acceptanceRequired: boolean;

state: 'PLANNED'\|'INVITED'\|'ACCEPTED'\|'ACTIVE'\|'COMPLETED'\|'REPLACED'\|'CANCELLED'\|'VOID';

version: number;

requirements: RequirementSummary\[\];

freshness: DataFreshness;

};

type ContentItemDto = {

id: string;

code: string;

itemTypeCode: string;

title: string;

target: {kind:'DOCUMENT', documentRef:string}

\| {kind:'EXTERNAL_RESOURCE', externalResourceRef:string}

\| {kind:'LMS_RESOURCE', lmsResourceRef:string};

rightsStatus: 'VALID'\|'EXPIRING'\|'INVALID'\|'UNKNOWN';

required: boolean;

};

type OperationStatusDto = {

operationId: string;

state: 'PENDING'\|'RUNNING'\|'SUCCEEDED'\|'FAILED'\|'UNKNOWN_EFFECT'\|'CANCELLED';

progress?: {current:number,total:number};

result?: unknown;

errorCode?: string;

correlationId: string;

};

## 39.1 Headers y metadata

| **Contrato**         | **Regla**                                                                              |
|----------------------|----------------------------------------------------------------------------------------|
| **ETag**             | Presente en GET root mutable; se envía en If-Match.                                    |
| **Idempotency-Key**  | Obligatorio en commands sensibles definidos por OpenAPI.                               |
| **X-Correlation-Id** | Aceptado/generado; retorna para soporte/audit.                                         |
| **ProblemDetail**    | type/title/status/detail/instance + reasonCode + correlationId + fieldErrors opcional. |
| **Pagination**       | cursor/pageSize/sort contractual; max pageSize server.                                 |
| **Freshness**        | asOf/source/status para cualquier dato external/read model.                            |

# 40. Checklist de release y certificación final

| **Área**               | **Criterio de certificación**                                      |
|------------------------|--------------------------------------------------------------------|
| **Arquitectura**       | Context map/SoT/anti-scope/ADRs alineados.                         |
| **Datos**              | 27 tablas + FKs scope-aware + checks/indexes/triggers revisados.   |
| **RLS**                | ENABLE+FORCE y runtime NO BYPASSRLS; negative suite verde.         |
| **State machines**     | Plan/content/assignment/invitation transitions probadas.           |
| **Lineage**            | Plan/content/replacement lineage íntegro.                          |
| **Aggregate Revision** | Child snapshot mutation bump + ETag/412.                           |
| **Append-only**        | Publication/acceptance/requirement/provision receipts no mutables. |
| **Idempotency**        | Replay/key conflict/lease recovery probados.                       |
| **Outbox/inbox**       | Atomicity, dedup, SKIP LOCKED, lease reclaim.                      |
| **CT-18**              | Timeout after apply/UNKNOWN_EFFECT/reconcile probado.              |
| **Content rights**     | Expiry/unknown/accessibility publish gates.                        |
| **Security**           | Threat model + RBAC/ABAC/SoD/step-up/token/privacy tests.          |
| **OpenAPI**            | Generated TS client + contract tests.                              |
| **AsyncAPI**           | Events versionados/compatibility.                                  |
| **Frontend**           | Workspaces + service states + 412 UX + responsive.                 |
| **Mobile**             | Instructor journeys + secure storage/offline constraints.          |
| **Observability**      | Dashboards/alerts/SLI/SLO/correlation/redaction.                   |
| **Performance**        | Budgets/load/EXPLAIN evidence.                                     |
| **Migration**          | CT-16 dry-run + DQ + lineage receipts.                             |
| **Secure SDLC**        | SAST/SCA/secrets/SBOM/container/DAST gates.                        |
| **Deployment**         | Expand/contract N/N-1 + rollout/roll-forward drill.                |
| **Runbooks**           | RB-EC05-001…025 disponibles y ensayados críticos.                  |
| **UAT**                | 30 escenarios firmados.                                            |
| **Gates**              | G1-G10 evidence complete.                                          |
| **Documentación**      | Word y Git artifacts versionados/coherentes.                       |

| **CERTIFICACIÓN —** EC-05 solo se marca PRODUCCIÓN cuando todos los criterios obligatorios tienen evidencia y no existe P0/P1 abierto sin excepción formal, owner, expiry y compensating controls. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 41. Contrato FullStack no negociable de implementación

Estas garantías constituyen el piso para EC-05 y plantilla para módulos EC posteriores. Un equipo puede cambiar detalles internos únicamente si mantiene comportamiento observable, invariantes, seguridad, evidence y compatibilidad; cualquier desviación arquitectónica requiere ADR.

70. Garantía 1 — Tenant proviene del contexto autenticado; nunca body libre.

71. Garantía 2 — PostgreSQL RLS ENABLE+FORCE en toda tabla tenant-owned; runtime no BYPASSRLS.

72. Garantía 3 — Solo FKs internas al bounded context; cross-context = EXT REF + port/contract.

73. Garantía 4 — TeachingPlanRevision y ContentPackageVersion son snapshots versionados; published history no se reescribe.

74. Garantía 5 — Aggregate Revision cubre child mutations del snapshot y se expone ETag/If-Match.

75. Garantía 6 — No last-write-wins; stale mutation = 412.

76. Garantía 7 — State transitions críticas están protegidas en dominio y PostgreSQL cuando expresables.

77. Garantía 8 — Lineage de plan/content es same-parent, no self y monotónico.

78. Garantía 9 — InstructorAssignment no es Person/Employee/User; person_ref no se duplica como PII.

79. Garantía 10 — Person/role/scope aceptados no se sobreescriben; replacement crea nuevo assignment con lineage.

80. Garantía 11 — AcceptanceReceipt y RequirementResult son append-only evidence.

81. Garantía 12 — Assignment requirement UNKNOWN/expired no se interpreta PASS.

82. Garantía 13 — Content target es discriminated union exactly-one; blobs viven CT-05.

83. Garantía 14 — Derechos/licencia/accesibilidad se validan como condiciones de publish, no como comentarios.

84. Garantía 15 — ContentPackage/Version puede reutilizarse y se pinnea; nunca “latest” para historia.

85. Garantía 16 — Recording policy, consent, retention y artifact tienen owners separados y referencias versionadas.

86. Garantía 17 — LMS/Zoom/Teams/Meet solo vía CT-18; prohibidos SDK calls ad-hoc desde Domain/Application.

87. Garantía 18 — Todo remote write sensible usa durable idempotency/request hash/remote ref.

88. Garantía 19 — Timeout después de side effect potencial = UNKNOWN_EFFECT, no FAILED automático.

89. Garantía 20 — UNKNOWN_EFFECT se reconcilia antes de retry.

90. Garantía 21 — Toda respuesta 202 incluye OperationStatus consultable hasta terminal.

91. Garantía 22 — Outbox es transaccional; consumers usan inbox dedup; at-least-once explícito.

92. Garantía 23 — Outbox multi-instancia usa SKIP LOCKED + owner/lease/backoff/reclaim.

93. Garantía 24 — Idempotency IN_PROGRESS usa lease/recovery y same-key/different-payload = 409.

94. Garantía 25 — Frontend consume OpenAPI-generated client y no duplica DTOs/states manualmente.

95. Garantía 26 — PATCH no ejecuta transitions/structural domain changes; se usan commands de intención.

96. Garantía 27 — UI distingue NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT.

97. Garantía 28 — Mobile no replica governance crítica; instructor journeys se restringen por purpose/online requirements.

98. Garantía 29 — RBAC + ABAC + SoD + step-up + purpose limitation + field privacy son obligatorios.

99. Garantía 30 — Audit crítico conserva actor, scope, reason, correlation, policy version, assurance y evidence refs.

100. Garantía 31 — IA solo vía CT-12; Recommendation ≠ Decision; provenance y human outcome obligatorios.

101. Garantía 32 — MongoDB/Redis son derivados; pérdida no altera truth y deben poder reconstruirse.

102. Garantía 33 — Migración usa CT-16 y promotion through domain/API; no direct INSERT final.

103. Garantía 34 — Flyway sigue expand/contract N/N-1; migrations aplicadas no se editan.

104. Garantía 35 — Secure SDLC, performance, observability, runbooks, Golden Scenarios, UAT y Gates son parte del producto, no documentación opcional.

105. Garantía 36 — No hard-delete de historia institucional: correction/supersede/void/compensation producen nuevos hechos.

| **BASELINE EC-05 V1.0 —** Este documento queda preparado como especificación implementable de referencia. EC-06 debe consumir Assignment/TeachingPlan/Session/Content refs sin redefinirlos y mantener como mínimo este piso de formato, profundidad, datos, Backend, Frontend, Mobile, QA, seguridad y operaciones. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
