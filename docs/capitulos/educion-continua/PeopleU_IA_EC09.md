**PEOPLEU IA**

**EC-09**

**FORMACIÓN CORPORATIVA / IN-COMPANY, CLIENTES,  
ACUERDOS, LOTES Y REPORTING EMPRESARIAL**

**Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones**

| **Control**        | **Valor**                                                                                                      |
|--------------------|----------------------------------------------------------------------------------------------------------------|
| **Código**         | EC-09                                                                                                          |
| **Versión**        | V1.0                                                                                                           |
| **Estado**         | VIGENTE — FULLSTACK ENTERPRISE                                                                                 |
| **Baseline**       | EC-00 V1.1 · EC-01 V1.1 · EC-02…EC-08 vigentes                                                                 |
| **Vertical**       | Educación Continua / Formación Continua                                                                        |
| **Arquitectura**   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| **Stack objetivo** | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| **Contexto**       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · B2B/B2C · Multiidioma          |
| **Fecha base**     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS — Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial.** |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA — EC-09 gobierna la relación operativa académica B2B de formación corporativa. No crea Personas, no es CRM general, no es ledger financiero, no emite certificados y no sustituye EC-01…EC-08.** |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

| **EC-09 convierte la formación corporativa en un proceso académico trazable, versionado, auditable y separable del hecho financiero. CORPORATE CLIENT ≠ PARTICIPANT; CONTRACT ≠ PROGRAM; NOMINATION ≠ ENROLLMENT; REPORT ≠ RAW PERSONAL DATA.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

EC-09 operacionaliza la oferta in-company y corporativa de PeopleU IA. Su propósito es administrar la relación académica entre una universidad y una organización contratante: diagnóstico de necesidades, alcance formativo, versionado del engagement, cupos comprometidos, nominaciones y lotes, entregables, hitos, reportes empresariales y reconciliación de efectos externos. El módulo debe servir tanto para programas cerrados de una sola empresa como para convenios marco con múltiples cohortes y ediciones.

El cliente corporativo puede contratar, pagar, definir cupos, proponer participantes, recibir reportes y acordar resultados de alto nivel, pero no se convierte en la persona participante ni en el dueño de sus datos académicos individuales. EC-09 debe aplicar purpose limitation y reporting minimizado: el sponsor obtiene únicamente la información autorizada por el contrato, la normativa, el consentimiento aplicable y las políticas institucionales.

El diseño debe soportar universidades que administran decenas o cientos de contratos corporativos simultáneos, con múltiples sedes, monedas, modalidades, ediciones y ventanas de ejecución. Cualquier efecto financiero oficial pertenece al Core Financiero; EC-09 conserva únicamente referencias, intents, receipts y estados de reconciliación necesarios para explicar el proceso académico-comercial.

## 

| **Prioridad**  | **Documento/artefacto**                | **Rol**                                       |
|----------------|----------------------------------------|-----------------------------------------------|
| **1**          | AM-00 vigente                          | Constitución arquitectónica superior.         |
| **2**          | CT-00 vigente                          | Contrato maestro transversal.                 |
| **3**          | CT-01…CT-18 vigentes                   | Capacidades compartidas y fronteras.          |
| **4**          | EC-00 V1.1                             | Constitución de Educación Continua.           |
| **5**          | EC-01…EC-08 vigentes                   | Contratos upstream consumidos por EC-09.      |
| **6**          | EC-09 V1.0                             | Especificación implementable B2B/in-company.  |
| **Ejecutable** | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación y evidencia alineadas al Word. |

## 

| **Orden** | **Código** | **Módulo oficial**                                                                            | **Responsabilidad**   |
|-----------|------------|-----------------------------------------------------------------------------------------------|-----------------------|
| **1**     | EC-01      | Portafolio, programas, versiones, módulos y rutas de microcredenciales                        | Diseño académico      |
| **2**     | EC-02      | Ediciones, ofertas, cohortes, modalidades, calendarios y programación operativa               | Oferta / ejecución    |
| **3**     | EC-03      | Comercialización académica, pricing, promociones, becas, convenios y condiciones de oferta    | Comercial             |
| **4**     | EC-04      | Prospectos, participantes, registro, preinscripción, inscripción, cupos y listas de espera    | Vinculación           |
| **5**     | EC-05      | Docentes, expertos, facilitadores, planificación, contenidos y entorno de aprendizaje         | Docencia              |
| **6**     | EC-06      | Asistencia, participación, engagement y evidencia de sesiones                                 | Participación         |
| **7**     | EC-07      | Evaluaciones, resultados, aprobación, completion y cierre académico                           | Evaluación / cierre   |
| **8**     | EC-08      | Certificados, badges, microcredenciales, credenciales verificables y acumulabilidad           | Certificación         |
| **9**     | EC-09      | Formación corporativa / in-company, clientes, acuerdos, lotes y reporting empresarial         | B2B / Corporate       |
| **10**    | EC-10      | Trayectoria de aprendizaje, progresión, stackable credentials y reconocimiento acumulativo EC | Trayectoria           |
| **11**    | EC-11      | Encuestas, NPS, feedback, evaluación docente, impacto y seguimiento posterior                 | Experiencia / impacto |
| **12**    | EC-12      | Calidad, analítica de portafolio, indicadores, compliance y mejora continua                   | Calidad / gobierno    |

## 

| **ID**          | **Decisión normativa**                                                                                                                                 |
|-----------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| **EC09-DA-001** | CORPORATE CLIENT ≠ PERSON ≠ PARTICIPANT ≠ IAM USER. La organización es una entidad B2B referenciada; las personas siguen en CT-04/EC-04.               |
| **EC09-DA-002** | COMMERCIAL AGREEMENT ≠ TRAINING ENGAGEMENT. El contrato legal/comercial puede vivir fuera de EC-09; EC-09 materializa su alcance formativo versionado. |
| **EC09-DA-003** | TRAINING NEED ASSESSMENT ≠ PROGRAM DESIGN. TNA captura necesidad del cliente; EC-01 sigue siendo Source of Truth de definición académica.              |
| **EC09-DA-004** | ENGAGEMENT VERSION = IMMUTABLE COMMITMENT SNAPSHOT. Cambios materiales crean nueva versión.                                                            |
| **EC09-DA-005** | PROGRAM BINDING PINNEA ProgramVersion/Edition/Offering; nunca “latest”.                                                                                |
| **EC09-DA-006** | CORPORATE SEAT POOL ≠ ENROLLMENT. Cupo contractual no equivale a participante matriculado.                                                             |
| **EC09-DA-007** | NOMINATION ≠ REGISTRATION ≠ ENROLLMENT. EC-09 nomina/lotea; EC-04 mantiene el hecho de inscripción.                                                    |
| **EC09-DA-008** | CORPORATE ENROLLMENT BATCH ≠ DIRECT INSERT. Se promueve por APIs/commands de EC-04 con receipt por ítem.                                               |
| **EC09-DA-009** | CLIENT CONTACT ≠ PERSON MASTER. Solo EXT REF a CT-04/IAM según corresponda.                                                                            |
| **EC09-DA-010** | PRICE/DEBT/PAYMENT/INVOICE ≠ EC-09. Finanzas es SoT; EC-09 guarda financial_intent_ref/receipt/reconciliation.                                         |
| **EC09-DA-011** | REPORTING PROFILE ≠ DATA DUMP. Define métricas, granularidad, audience y privacy policy.                                                               |
| **EC09-DA-012** | CORPORATE REPORT ≠ PARTICIPANT RECORD. El sponsor no obtiene datos individuales no autorizados.                                                        |
| **EC09-DA-013** | AGGREGATE REVISION cubre hijos; ETag representa engagement_version completo.                                                                           |
| **EC09-DA-014** | RLS ENABLE+FORCE es defensa obligatoria; runtime role sin BYPASSRLS.                                                                                   |
| **EC09-DA-015** | CROSS-CONTEXT REF ≠ FK CROSS-CONTEXT.                                                                                                                  |
| **EC09-DA-016** | OUTBOX/INBOX e idempotencia durable son obligatorios para efectos críticos.                                                                            |
| **EC09-DA-017** | UNKNOWN_EFFECT se reconcilia antes de reintentar un efecto remoto.                                                                                     |
| **EC09-DA-018** | CLIENT-SPECIFIC REQUIREMENT ≠ HARDCODE. Se resuelve vía policy/contract snapshot.                                                                      |
| **EC09-DA-019** | DELIVERABLE ≠ DOCUMENT BLOB. El artefacto vive en CT-05; EC-09 guarda document_ref/hash/metadata.                                                      |
| **EC09-DA-020** | MILESTONE ≠ PAYMENT MILESTONE. Puede correlacionarse, pero el hecho financiero es externo.                                                             |
| **EC09-DA-021** | SUBSTITUTION ≠ DELETE NOMINEE. Sustituciones conservan lineage y receipts.                                                                             |
| **EC09-DA-022** | BULK ≠ BYPASS. Operaciones masivas preservan autorización, validación e idempotencia por ítem.                                                         |
| **EC09-DA-023** | REPORT RUN = DERIVED SNAPSHOT con asOf/provenance; no altera facts académicos.                                                                         |
| **EC09-DA-024** | AI RECOMMENDATION ≠ CONTRACT DECISION. CT-12 puede sugerir TNA/métricas, nunca comprometer alcance ni aprobar.                                         |
| **EC09-DA-025** | CORPORATE PORTAL = scoped workspace; nunca acceso transversal al tenant.                                                                               |
| **EC09-DA-026** | SOFT CHANGE ≠ MATERIAL CHANGE. MaterialChangePolicy determina nueva engagement_version.                                                                |
| **EC09-DA-027** | SERVICE LEVEL COMMITMENT ≠ INFRA SLO. Es compromiso operacional/contractual distinto de SRE SLO.                                                       |
| **EC09-DA-028** | COMMERCIAL AGREEMENT REF = immutable/effective reference cuando aplica; no free text como autoridad.                                                   |
| **EC09-DA-029** | PERSONAL DATA EXPORT requiere purpose, audience, authorization y evidence.                                                                             |
| **EC09-DA-030** | TENANT CONTEXT ≠ BODY; tenant_id deriva del contexto autorizado.                                                                                       |
| **EC09-DA-031** | 202 ACCEPTED ≠ EFFECT CONFIRMED; OperationStatus es obligatorio.                                                                                       |
| **EC09-DA-032** | SCHEMA RELEASE ≠ APP RELEASE; expand/contract N/N-1.                                                                                                   |
| **EC09-DA-033** | PUBLICATION/ACTIVATION ≠ PATCH status; son comandos transaccionales.                                                                                   |
| **EC09-DA-034** | HISTORY ≠ OVERWRITE. Cancel, suspend, replace, supersede y correct son no destructivos.                                                                |

## 

EC-09 se considera implementable cuando dos equipos Senior independientes pueden construir el mismo comportamiento observable, mismas invariantes físicas, mismos contratos REST/eventos y mismos estados de UI sin inventar decisiones incompatibles. Las variaciones institucionales deben quedar en CT-02/policy o en ADR explícito; nunca escondidas en ifs locales.

| **PATRÓN OBLIGATORIO — Aggregate Revision, PostgreSQL RLS, state guards, idempotencia durable, leased outbox, OperationStatus, API paginada, Threat Model, Secure SDLC, expand/contract y bootstrap reproducible son piso de EC-09.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 

| **Invariante**                | **Aplicación EC-09**                                                                                |
|-------------------------------|-----------------------------------------------------------------------------------------------------|
| Multi-tenant defense-in-depth | PK/FK internas tenant-aware + RLS ENABLE/FORCE + tenant context transaccional.                      |
| **No FK cross-context**       | ProgramVersion, Person, Enrollment, Financial facts y documentos se referencian como EXT REF.       |
| **No last-write-wins**        | Mutaciones exigen If-Match/ETag sobre aggregate root.                                               |
| **History first**             | EngagementVersion, report snapshots, receipts y sustituciones no se sobreescriben destructivamente. |
| **Financial boundary**        | No deuda/pago/factura local.                                                                        |
| **Privacy**                   | Reporting por purpose y audience; PII mínima.                                                       |
| **AI via CT-12**              | Provenance, human review y no decision authority.                                                   |
| **Documents via CT-05**       | Solo refs/hash/metadata de negocio.                                                                 |
| **Migration via CT-16**       | Extract→Normalize→Map→Validate→Dry-run→Promote→Receipt→Reconcile.                                   |

# 

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal de reglas BR-EC09

- 10\. Casos de uso UC-EC09

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

# 

La formación corporativa exige coordinar actores y hechos que pertenecen a dominios distintos: una empresa contrata, una universidad diseña y ejecuta, personas son nominadas, EC-04 las inscribe, EC-06 registra participación, EC-07 determina completion y EC-08 emite credenciales. Sin una frontera explícita, el sistema termina mezclando contrato, participante, pago y resultado académico en una sola tabla imposible de auditar.

EC-09 resuelve esa coordinación sin apropiarse de verdades ajenas. Mantiene el expediente operativo B2B: cliente corporativo referenciado, diagnóstico de necesidades, engagement/versiones, bindings a programas/ediciones, compromisos, seat pools, batches, entregables, report profiles, report runs y receipts de integración. El objetivo es que un acuerdo corporativo pueda ser reconstruido exactamente años después.

## 

- CorporateClientAccount como identidad B2B interna referencial, sin duplicar maestro de persona/organización externo cuando exista.

- Training Need Assessment (TNA) versionado con necesidades, objetivos, población y restricciones.

- CorporateTrainingEngagement y EngagementVersion con alcance contractual-académico pinneado.

- Bindings a ProgramVersion/ProgramEdition/Offering existentes.

- Seat pools/cupos corporativos y reglas de asignación.

- NominationBatch y CorporateEnrollmentBatch con processing por ítem.

- Sustituciones/reemplazos con lineage.

- Milestones, deliverables y evidence refs.

- ReportingProfile por audience, propósito, granularidad, retención y privacy.

- Generación, publicación y entrega de reportes con asOf/provenance.

- FinancialIntent/receipt/reconciliation sin ledger local.

- Portal corporativo y workspaces internos.

- APIs, eventos, outbox/inbox, observabilidad, seguridad, QA, migración e IA asistiva.

## 

- CRM general de ventas, leads o pipeline corporativo.

- Crear o modificar ProgramDefinition/ProgramVersion — EC-01.

- Crear Edition/Offering/Calendar/Schedule — EC-02/CT-03/13/14.

- Definir pricing/discount ledger — EC-03/Finanzas.

- Mantener Person o Enrollment oficial — CT-04/EC-04.

- Asignar instructor o gestionar contenidos — EC-05.

- Registrar asistencia — EC-06.

- Calificar/completion — EC-07.

- Emitir certificados — EC-08.

- Registrar deuda, pago, factura o saldo — Core Financiero.

- Guardar PDFs/blobs — CT-05.

| **ANTI-SCOPE — EC-09 no debe convertirse en CRM + Finanzas + Registro + LMS “corporativo”. Su valor está en coordinar el proceso B2B preservando dueños de verdad separados.** |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

| **Término**                 | **Definición normativa**                                                                                  |
|-----------------------------|-----------------------------------------------------------------------------------------------------------|
| **CorporateClientAccount**  | Representación B2B de la organización contratante dentro de EC-09; no equivale a Person ni a tenant.      |
| **TrainingNeedAssessment**  | Diagnóstico de necesidad de capacitación; captura problema, población, outcomes deseados y restricciones. |
| CorporateTrainingEngagement | Identidad estable del servicio formativo acordado con un cliente corporativo.                             |
| **EngagementVersion**       | Snapshot versionado e inmutable del alcance operativo-académico comprometido.                             |
| **ProgramBinding**          | Pin a ProgramVersion/ProgramEdition/Offering que será ejecutado para el engagement.                       |
| **SeatPool**                | Cupo corporativo comprometido para una edición o binding; no es enrollment.                               |
| **NominationBatch**         | Lote de personas propuestas por el cliente para participar.                                               |
| **NominationItem**          | Propuesta individual; puede resolverse a Person/Participant por EC-04.                                    |
| CorporateEnrollmentBatch    | Comando masivo gobernado para promover nominaciones a enrollment mediante EC-04.                          |
| **ParticipantSubstitution** | Reemplazo trazable de una nominación/enrollment cuando policy lo permite.                                 |
| **DeliveryMilestone**       | Hito operativo/académico del engagement; no equivale automáticamente a hito financiero.                   |
| **Deliverable**             | Resultado documental u operativo exigible; el binario vive en CT-05.                                      |
| **ReportingProfile**        | Contrato de qué datos/metricas puede recibir una audiencia corporativa.                                   |
| **ReportRun**               | Snapshot derivado con asOf, lineage y provenance.                                                         |
| **FinancialIntent**         | Solicitud/referencia hacia Finanzas, nunca asiento/ledger.                                                |
| **ReconciliationCase**      | Expediente para resolver efecto externo incierto o inconsistente.                                         |
| **UNKNOWN_EFFECT**          | Estado cuando no se puede saber si una dependencia aplicó el efecto remoto.                               |
| **Purpose Limitation**      | Uso de datos limitado a propósito autorizado y evidenciable.                                              |
| **EXT REF**                 | Referencia cross-context sin FK física.                                                                   |

# 

EC-09 es dueño del expediente operativo B2B y de la semántica de engagement corporativo. Cuando consume datos de otros bounded contexts, conserva identificadores externos, snapshots justificados y receipts. No crea tablas espejo de Person, Enrollment, Payment, Invoice, Certificate ni ProgramDefinition.

| **Información**             | **Source of Truth** | **EC-09 almacena**         | **EC-09 referencia**      | **Regla**                  |
|-----------------------------|---------------------|----------------------------|---------------------------|----------------------------|
| **Tenant/sede/campus**      | CT-01               | tenant_id + scope refs     | organization scope refs   | tenant desde auth context. |
| **Policies/catálogos**      | CT-02               | policy snapshots mínimos   | policy/version refs       | No hardcode.               |
| **Temporalidad**            | CT-03               | milestone dates propias    | calendar/session refs     | No motor temporal.         |
| **Persona**                 | CT-04               | No Person                  | person/contact refs       | PII mínima.                |
| **Documentos**              | CT-05               | No blobs                   | document/evidence refs    | Hash + metadata.           |
| **Workflow**                | CT-06               | resultado semántico mínimo | workflow refs             | Aprobaciones externas.     |
| **Notificaciones**          | CT-07               | receipts                   | notification refs         | Post-commit.               |
| **i18n**                    | CT-08               | locale keys                | translation refs          | No duplicar contenido.     |
| **Integración**             | CT-09               | outbox/inbox               | contract refs             | At-least-once.             |
| **Security/audit**          | CT-10               | business audit metadata    | evidence refs             | Purpose/actor/scope.       |
| **Analytics**               | CT-11               | produce facts              | dataset refs              | No BI sombra.              |
| **IA**                      | CT-12               | run/eval refs              | AI refs                   | Recommendation ≠ Decision. |
| **Scheduling**              | CT-13               | No                         | schedule refs             | EC-02/CT-13.               |
| **Resources**               | CT-14               | No                         | resource refs             | No reservas locales.       |
| **Eligibility**             | CT-15               | No engine                  | eligibility refs          | No evaluación local.       |
| **Migration**               | CT-16               | receipts                   | lineage refs              | No direct INSERT.          |
| **Continuity**              | CT-17               | runbook refs               | continuity refs           | Degraded modes.            |
| **External ecosystem**      | CT-18               | No connector tables        | provider refs             | No vendor lock-in.         |
| **Programs**                | EC-01               | No                         | program_version_ref       | Pin immutable version.     |
| **Edition/Offering**        | EC-02               | No                         | edition/offering refs     | No calendario local.       |
| **Pricing**                 | EC-03               | No                         | quote/pricing refs        | No pricing engine local.   |
| **Registration/Enrollment** | EC-04               | batch refs                 | enrollment refs           | EC-04 is SoT.              |
| **Instructor/content**      | EC-05               | No                         | assignment/content refs   | No ownership local.        |
| **Attendance**              | EC-06               | No                         | attendance aggregate refs | Report-derived only.       |
| **Completion**              | EC-07               | No                         | completion refs           | Report-derived only.       |
| **Credential**              | EC-08               | No                         | credential refs           | No issue local.            |
| **Financial facts**         | Finanzas            | intent/receipt refs        | invoice/payment refs      | No ledger local.           |
| **Corporate engagement**    | EC-09               | Sí                         | —                         | Source of Truth local.     |

# 

| **Dependencia** | **Responsabilidad**      | **Contrato EC-09**                | **Frontera/fallo**               |
|-----------------|--------------------------|-----------------------------------|----------------------------------|
| **CT-01**       | scope institucional      | tenant/scope validation           | Fail-closed en activation.       |
| **CT-02**       | policies/catalogs        | policy refs/snapshots             | Versioned cache.                 |
| **CT-04**       | person/organization refs | contacts, nominees                | No local person.                 |
| **CT-05**       | documents/evidence       | agreement/deliverable/report refs | No blobs.                        |
| **CT-06**       | workflow                 | approval/change flows             | Workflow no redefine invariants. |
| **CT-07**       | notifications            | invites/report delivery           | No rollback por mail failure.    |
| **CT-09**       | integration governance   | events/contracts                  | Outbox/inbox.                    |
| **CT-10**       | security/privacy         | purpose/audit/evidence            | Critical audit.                  |
| **CT-11**       | analytics                | corporate datasets                | No shadow BI.                    |
| **CT-12**       | AI                       | TNA/report assist                 | Human review.                    |
| **CT-15**       | eligibility              | participant eligibility refs      | EC-09 does not decide.           |
| **CT-16**       | migration                | staging/promotion                 | No direct INSERT.                |
| **CT-18**       | external ecosystem       | SSO/export/provider refs          | No vendor-specific core.         |
| **EC-01**       | ProgramVersion           | pin program version               | No latest.                       |
| **EC-02**       | Edition/Offering         | edition/offering refs             | No scheduling local.             |
| **EC-03**       | pricing/quotes           | commercial refs                   | No ledger.                       |
| **EC-04**       | registration/enrollment  | promote batch / status            | Idempotent integration.          |
| **EC-06**       | attendance               | report facts                      | Read-only derived.               |
| **EC-07**       | completion               | report facts                      | Read-only derived.               |
| **EC-08**       | credentials              | report facts                      | Read-only derived.               |
| **Finanzas**    | financial truth          | intent/receipt/reconcile          | UNKNOWN_EFFECT safe.             |

# 

<img src="media/image27.png" style="width:6.5in;height:3.9in" />

Figura 1 — EC-09 dentro de la vertical y capacidades transversales

| **Journey**               | **Flujo E2E**                                                                                                                                                  |
|---------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **J-EC09-01 Diagnóstico** | Crear CorporateClientAccount/TNA → registrar necesidades → validar privacy/purpose → aprobar TNA → crear engagement draft.                                     |
| **J-EC09-02 Engagement**  | Crear EngagementVersion → pin ProgramVersion/Edition/Offering → definir scope, seat pools, reporting profile y milestones → review/approve/activate.           |
| **J-EC09-03 Nominación**  | Cliente carga NominationBatch → validar formato/person refs → resolver duplicados → generar batch de inscripción hacia EC-04 → consolidar receipts.            |
| **J-EC09-04 Sustitución** | Solicitud de sustitución → policy eval → lock seat/enrollment refs → command EC-04 → UNKNOWN_EFFECT si aplica → reconcile → receipt.                           |
| **J-EC09-05 Reporting**   | ReportingProfile define audience/purpose/granularity → recolectar facts autorizados EC-04/06/07/08 → generar ReportRun con asOf/provenance → delivery receipt. |
| **J-EC09-06 Entregables** | Crear deliverable/milestone → documento en CT-05 → aceptación/rechazo con evidencia → no alterar financial ledger.                                             |
| **J-EC09-07 Cambio**      | Cambio material → nueva EngagementVersion con lineage → approval CT-06 → activar; versión previa queda SUPERSEDED.                                             |
| **J-EC09-08 Finanzas**    | Crear FinancialIntent → Finanzas procesa → timeout =\> UNKNOWN_EFFECT → query/reconcile antes de retry.                                                        |
| **J-EC09-09 IA**          | CT-12 propone resumen TNA/KPI → usuario revisa → apply mediante command normal con attribution.                                                                |

# 

<img src="media/image28.png" style="width:6.5in;height:3.9in" />

Figura 2 — Modelo de dominio lógico EC-09

## 

Identidad operacional B2B en EC-09. Mantiene business key, external organization reference, lifecycle y scopes autorizados. No contiene las personas del cliente como objetos maestros ni información financiera oficial.

## 

Captura el diagnóstico de necesidades y requirements. Puede versionarse o cerrarse según policy. Un TNA aprobado puede originar uno o más engagements, pero no modifica ProgramVersion.

## 

Identidad estable del servicio formativo. Sus EngagementVersion contienen el compromiso concreto y versionado con program bindings, seat pools, commitments, milestones, reporting profile y referencias comerciales.

## 

Representa una carga masiva de candidatos propuestos por el sponsor. Cada item conserva source key, person resolution, validation status y eventual enrollment receipt.

## 

Orquesta comandos masivos hacia EC-04. Debe soportar partial success, retries por item e idempotencia durable sin transformar el batch en Source of Truth de Enrollment.

## 

Define qué puede ver cada audience corporativo. El perfil versiona propósito, granularidad, campos permitidos, thresholds de agregación y políticas de privacidad.

## 

Snapshot derivado y reproducible de un reporte corporativo. Conserva asOf, dataset refs, hash, provenance, status y delivery receipts.

## 

Agrupa un efecto externo incierto o inconsistente y su resolución. El cierre exige evidencia durable; nunca se oculta un UNKNOWN_EFFECT mediante retry ciego.

## 

| **Value Object**         | **Semántica**                                      |
|--------------------------|----------------------------------------------------|
| **CorporateClientCode**  | Business key tenant-aware estable.                 |
| **EngagementCode**       | Código del servicio corporativo.                   |
| **VersionNumber**        | Entero positivo y monotónico por engagement.       |
| **SeatQuantity**         | Cantidad positiva de cupos.                        |
| **PurposeRef**           | Propósito autorizado/versionado para uso de datos. |
| **ReportingGranularity** | AGGREGATE/INDIVIDUAL_LIMITED según policy.         |
| **ExternalRef**          | Opaque id + authority, sin FK cross-context.       |
| **PolicyRef**            | Referencia inmutable a PolicyVersion.              |
| **AsOf**                 | Instante UTC del snapshot reportado.               |
| **ContentHash**          | Hash canónico de snapshot/report/receipt.          |

## 

- EngagementActivationPolicy — policy versionada; no hardcodeada en Java/React.

- MaterialChangePolicy — policy versionada; no hardcodeada en Java/React.

- CorporateSeatPolicy — policy versionada; no hardcodeada en Java/React.

- NominationPolicy — policy versionada; no hardcodeada en Java/React.

- ParticipantSubstitutionPolicy — policy versionada; no hardcodeada en Java/React.

- CorporateReportingPrivacyPolicy — policy versionada; no hardcodeada en Java/React.

- ReportAggregationPolicy — policy versionada; no hardcodeada en Java/React.

- MilestoneAcceptancePolicy — policy versionada; no hardcodeada en Java/React.

- FinancialReconciliationPolicy — policy versionada; no hardcodeada en Java/React.

- RetentionPolicy — policy versionada; no hardcodeada en Java/React.

## 

- EngagementValidationService — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

- NominationResolutionService — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

- EnrollmentBatchOrchestrator — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

- SeatAllocationService — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

- CorporateReportAssembler — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

- ReportingPrivacyFilterService — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

- ReconciliationService — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

- EngagementDiffService — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

- ImpactSimulationService — servicio de dominio/aplicación sin acceso directo a tablas de otros bounded contexts.

## 

EngagementVersion, TNA, NominationBatch, EnrollmentBatch, ReportingProfile y ReportRun usan optimistic concurrency cuando son mutables. Toda mutación de un hijo incrementa la revisión del root en la misma transacción. La capa Application resuelve tenant, abre transacción, ejecuta SET LOCAL, bloquea/revalida el root, compara If-Match, ejecuta command de intención, persiste, registra audit/outbox/idempotency y devuelve ETag nuevo.

| **PRUEBA NO NEGOCIABLE — Dos usuarios parten del mismo ETag. Si uno modifica un seat pool y el otro modifica un milestone, el segundo debe recibir 412 aunque haya tocado una tabla hija diferente.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

<img src="media/image29.png" style="width:6.5in;height:3.9in" />

Figura 3 — Estados normativos EC-09

| **Aggregate**              | **Estados/transiciones**                                                     | **Invariante**                        |
|----------------------------|------------------------------------------------------------------------------|---------------------------------------|
| **CorporateClientAccount** | DRAFT → ACTIVE → SUSPENDED → RETIRED                                         | RETIRED conserva historia.            |
| **TNA**                    | DRAFT → IN_REVIEW → APPROVED/REJECTED → CLOSED                               | APPROVED/CLOSED no se reescribe.      |
| **EngagementVersion**      | DRAFT → IN_REVIEW → APPROVED → ACTIVE → SUPERSEDED; SUSPENDED/CANCELLED      | ACTIVE/SUPERSEDED snapshot inmutable. |
| **NominationBatch**        | DRAFT → VALIDATING → READY → PROCESSING → COMPLETED/PARTIAL/FAILED/CANCELLED | Items conservan receipts.             |
| **EnrollmentBatch**        | PENDING → PROCESSING → COMPLETED/PARTIAL/FAILED → RECONCILING                | No exactly-once distribuido.          |
| **Deliverable**            | PLANNED → READY → SUBMITTED → ACCEPTED/REJECTED → SUPERSEDED                 | Artefacto CT-05.                      |
| **ReportRun**              | REQUESTED → BUILDING → READY → PUBLISHED/FAILED → SUPERSEDED                 | Published immutable.                  |
| **FinancialIntent**        | CREATED → SENT → CONFIRMED/REJECTED/UNKNOWN_EFFECT → RECONCILED              | Retry solo tras reconcile.            |

| **REGLA DE ESTADO — ACTIVE, COMPLETED, ACCEPTED o PUBLISHED nunca se implementan como PATCH genérico de status. Son comandos de dominio con precondiciones, autorización, ETag, evidencia, audit y outbox.** |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

| **ID**          | **Nombre**                              | **Regla implementable/verificable**                                                                     |
|-----------------|-----------------------------------------|---------------------------------------------------------------------------------------------------------|
| **BR-EC09-001** | Tenant obligatorio                      | Toda fila tenant-owned deriva tenant_id del contexto autorizado; body no selecciona tenant.             |
| **BR-EC09-002** | RLS obligatorio                         | Todas las tablas tenant-owned usan ENABLE+FORCE RLS y runtime role sin BYPASSRLS.                       |
| **BR-EC09-003** | Código cliente único                    | corporate_client_code es único por tenant.                                                              |
| **BR-EC09-004** | Cliente no participante                 | CorporateClientAccount jamás sustituye Person/Participant.                                              |
| **BR-EC09-005** | TNA no programa                         | TNA no modifica ProgramVersion ni crea contenido académico.                                             |
| **BR-EC09-006** | Engagement versionado                   | Cambios materiales sobre alcance activo generan nueva EngagementVersion.                                |
| **BR-EC09-007** | Pin de programa                         | Program bindings usan identificadores versionados explícitos.                                           |
| **BR-EC09-008** | No latest                               | Nunca resolver ProgramVersion/Edition latest para historia.                                             |
| **BR-EC09-009** | Seat pool positivo                      | allocated_seats \> 0 y consumed_seats no excede allocation salvo overbooking policy explícita.          |
| **BR-EC09-010** | Cupo no matrícula                       | SeatPool no crea Enrollment.                                                                            |
| **BR-EC09-011** | Nominación no matrícula                 | NominationItem no equivale Enrollment.                                                                  |
| **BR-EC09-012** | Batch idempotente                       | Los comandos masivos requieren Idempotency-Key y source keys estables.                                  |
| **BR-EC09-013** | Partial success explícito               | Fallos por item no convierten automáticamente todo batch en FAILED.                                     |
| **BR-EC09-014** | Sustitución con lineage                 | Reemplazo conserva old/new refs, reason y receipt.                                                      |
| **BR-EC09-015** | Report purpose                          | Todo ReportingProfile declara purpose_ref versionado.                                                   |
| **BR-EC09-016** | Audience restringida                    | Toda entrega de reporte valida audience y scope.                                                        |
| **BR-EC09-017** | Minimización                            | Campos no necesarios se excluyen del dataset/report.                                                    |
| **BR-EC09-018** | Agregación mínima                       | Reportes agregados respetan threshold de k-anonymity/policy institucional cuando corresponda.           |
| **BR-EC09-019** | Individual limitado                     | Detalle individual requiere autorización/purpose explícitos.                                            |
| **BR-EC09-020** | AsOf obligatorio                        | ReportRun declara instante de corte y provenance.                                                       |
| **BR-EC09-021** | Reporte inmutable                       | PUBLISHED ReportRun no se modifica; corrección crea superseding run.                                    |
| **BR-EC09-022** | No blobs                                | Documentos y exports viven en CT-05.                                                                    |
| **BR-EC09-023** | Financial boundary                      | EC-09 no registra deuda/pago/factura/saldo.                                                             |
| **BR-EC09-024** | Financial intent idempotente            | Intents remotos usan idempotency y reconciliation.                                                      |
| **BR-EC09-025** | UNKNOWN_EFFECT                          | Timeout con posible efecto aplicado se reconcilia antes de retry.                                       |
| **BR-EC09-026** | Milestone no pago                       | Milestone académico/operativo no se interpreta como pago confirmado.                                    |
| **BR-EC09-027** | Deliverable evidence                    | ACCEPTED requiere evidence_ref y actor autorizado cuando policy lo exija.                               |
| **BR-EC09-028** | SoD                                     | Quien prepara un compromiso material no es necesariamente único aprobador.                              |
| **BR-EC09-029** | Step-up                                 | Activate/cancel/financial reconcile/export sensible puede requerir step-up.                             |
| **BR-EC09-030** | No hard delete                          | Historia activa/publicada no se borra por API ordinaria.                                                |
| **BR-EC09-031** | UTC                                     | Instantes oficiales usan timestamptz UTC.                                                               |
| **BR-EC09-032** | Policy versionada                       | Thresholds/ventanas/retención/campos se resuelven por CT-02/policy.                                     |
| **BR-EC09-033** | No FK cross-context                     | Refs a CT/EC/Finanzas no tienen FK física.                                                              |
| **BR-EC09-034** | ETag                                    | Mutaciones de aggregate usan If-Match; mismatch 412.                                                    |
| **BR-EC09-035** | No last-write-wins                      | Conflictos no se silencian.                                                                             |
| **BR-EC09-036** | Outbox atómica                          | Transición crítica + outbox en misma transacción.                                                       |
| **BR-EC09-037** | Inbox dedup                             | message_id deduplica consumo.                                                                           |
| **BR-EC09-038** | Outbox lease                            | Worker usa claim/lease/SKIP LOCKED.                                                                     |
| **BR-EC09-039** | Idempotency lease                       | IN_PROGRESS vencido puede recuperarse gobernadamente.                                                   |
| **BR-EC09-040** | 202 OperationStatus                     | Toda operación 202 devuelve operationId consultable.                                                    |
| **BR-EC09-041** | RFC ProblemDetail                       | Errores REST usan ProblemDetail y reasonCode estable.                                                   |
| **BR-EC09-042** | API bounded                             | Listados paginados, sort estable, filtros y pageSize máximo.                                            |
| **BR-EC09-043** | Bulk bounded                            | Batch size máximo parametrizado.                                                                        |
| **BR-EC09-044** | PII logging                             | Logs no incluyen PII sensible ni payloads completos.                                                    |
| **BR-EC09-045** | Audit critical                          | Cambios críticos registran tenant, actor, subject, action, reason, policy, correlation y evidence refs. |
| **BR-EC09-046** | Migration governed                      | Legacy entra por CT-16, nunca INSERT directo.                                                           |
| **BR-EC09-047** | AI provenance                           | Sugerencias IA registran run/model/template/eval/grounding/confidence.                                  |
| **BR-EC09-048** | AI no decide                            | IA no aprueba engagement, sustitución, reporte sensible ni effect financiero.                           |
| **BR-EC09-049** | Portal scope                            | Corporate Portal solo accede a client_account + engagement scopes autorizados.                          |
| **BR-EC09-050** | Export expira                           | URLs/artefactos de exportación usan TTL/policy y no exponen storage interno.                            |
| **BR-EC09-051** | Consent/purpose                         | Si policy exige consentimiento, ausencia bloquea detalle individual.                                    |
| **BR-EC09-052** | Data retention                          | Retención y purge siguen policy/legal hold; no “guardar para siempre”.                                  |
| **BR-EC09-053** | State guard DB                          | Transiciones imposibles se bloquean físicamente cuando expresables.                                     |
| **BR-EC09-054** | Aggregate child mutation                | Cambiar seat/milestone/report metric bump root revision.                                                |
| **BR-EC09-055** | Business key immutable                  | client_code/engagement_code no cambian tras historia activa.                                            |
| **BR-EC09-056** | Lineage monotónico                      | previous/superseded version son same engagement y version_no monotónico.                                |
| **BR-EC09-057** | One active version                      | Solo una EngagementVersion ACTIVE por engagement salvo modelado explícito por vigencias no solapadas.   |
| **BR-EC09-058** | Activation validation                   | Activate exige program/edition refs resolubles, seat policy válida y reporting profile compatible.      |
| **BR-EC09-059** | Dependency unavailable                  | Dependencia crítica UNKNOWN/UNAVAILABLE no se interpreta favorable.                                     |
| **BR-EC09-060** | Stale UI                                | STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT son estados UI distintos.                                      |
| **BR-EC09-061** | Report provenance                       | Cada métrica indica source, asOf y transformation version.                                              |
| **BR-EC09-062** | No raw telemetry                        | LMS/activity raw no se entrega al cliente sin política; facts académicos prevalecen.                    |
| **BR-EC09-063** | Credential reporting                    | Credential status se consume de EC-08, no se infiere por completion.                                    |
| **BR-EC09-064** | Completion reporting                    | Completion se consume de EC-07, no se recalcula en EC-09.                                               |
| **BR-EC09-065** | Attendance reporting                    | Attendance oficial se consume de EC-06.                                                                 |
| **BR-EC09-066** | Enrollment reporting                    | Enrollment oficial se consume de EC-04.                                                                 |
| **BR-EC09-067** | Contact privacy                         | Corporate contact ref no crea shadow person.                                                            |
| **BR-EC09-068** | Nominee resolution                      | Ambigüedad de identidad queda NEEDS_REVIEW; no auto-link inseguro.                                      |
| **BR-EC09-069** | Duplicate nominee                       | Duplicados same batch/source key se bloquean o deduplican determinísticamente.                          |
| **BR-EC09-070** | Seat race                               | Último asiento se consume transaccionalmente contra seat pool revision.                                 |
| **BR-EC09-071** | Substitution policy                     | No sustituir tras cutoff/attendance threshold sin excepción aprobada.                                   |
| **BR-EC09-072** | Cancellation history                    | Cancelar engagement no elimina batches/reportes/receipts previos.                                       |
| **BR-EC09-073** | Suspend != cancel                       | Suspensión es reversible según policy; cancelación puede ser terminal.                                  |
| **BR-EC09-074** | Report delivery receipt                 | Cada entrega externa conserva recipient/channel/document_ref/hash/status.                               |
| **BR-EC09-075** | Export watermark                        | Exports sensibles pueden requerir watermark/recipient attribution vía CT-05/policy.                     |
| **BR-EC09-076** | Rate limiting                           | Endpoints bulk/export/report se protegen con quotas/rate limits.                                        |
| **BR-EC09-077** | Secure SDLC                             | Critical/High findings bloquean release salvo excepción formal.                                         |
| **BR-EC09-078** | Expand/contract                         | Migraciones compatibles N/N-1.                                                                          |
| **BR-EC09-079** | Runtime roles                           | HTTP runtime, migrator y workers usan roles DB separados.                                               |
| **BR-EC09-080** | Secrets                                 | Credenciales externas no viven en tablas de negocio.                                                    |
| **BR-EC09-081** | Correlation                             | Toda integración crítica propaga correlation_id/causation_id.                                           |
| **BR-EC09-082** | Reconciliation evidence                 | Cerrar reconciliation exige evidencia del efecto real.                                                  |
| **BR-EC09-083** | No manual truth override                | Operador no marca “CONFIRMED” sin receipt/authority.                                                    |
| **BR-EC09-084** | SLO business/technical                  | Rechazo de negocio no se contabiliza como fallo técnico.                                                |
| **BR-EC09-085** | Report reproducibility                  | Mismo snapshot+transform version debe producir mismo resultado lógico.                                  |
| **BR-EC09-086** | Localization                            | Labels del portal/report se localizan vía CT-08 sin duplicar facts.                                     |
| **BR-EC09-087** | Accessibility                           | Portal y workspaces cumplen WCAG 2.2 AA baseline.                                                       |
| **BR-EC09-088** | Mobile limitation                       | Mobile no ejecuta aprobaciones masivas/financial overrides por defecto.                                 |
| **BR-EC09-089** | Document hash                           | Refs de entregables/reportes sensibles conservan hash cuando policy lo exige.                           |
| **BR-EC09-090** | Legal agreement ref                     | Acuerdo firmado se referencia a CT-05/contract source, no se copia como blob.                           |
| **BR-EC09-091** | Corporate agreement != academic program | Beneficios comerciales no cambian outcomes/program design.                                              |
| **BR-EC09-092** | TNA confidentiality                     | TNA puede clasificarse confidencial y limitar access ABAC.                                              |
| **BR-EC09-093** | Impact simulation                       | Cambios de engagement pueden simular impacto sin aplicar efectos.                                       |
| **BR-EC09-094** | Dry-run bulk                            | Importación/nominación masiva soporta dry-run antes de promote.                                         |
| **BR-EC09-095** | Reprocess item                          | Reprocesar item fallido no duplica items exitosos.                                                      |
| **BR-EC09-096** | Metrics allowlist                       | Reporting metric code debe pertenecer a allowlist/policy.                                               |
| **BR-EC09-097** | Audience revoke                         | Revocar audience impide nuevas entregas, no borra historia.                                             |
| **BR-EC09-098** | Report correction                       | Corrección material crea nuevo ReportRun con supersedes_ref.                                            |
| **BR-EC09-099** | Clock source                            | Tiempos críticos usan clock server-side; no confiar en timestamp cliente.                               |
| **BR-EC09-100** | Optimistic + physical guards            | Backend y DB protegen invariantes en profundidad.                                                       |
| **BR-EC09-101** | Operational continuity                  | Modo degradado puede permitir lectura de engagements sin habilitar acciones críticas.                   |
| **BR-EC09-102** | Evidence pack                           | Activation/cancellation/sensitive reporting generan evidence pack cuando policy lo exige.               |
| **BR-EC09-103** | No unauthorized inference               | El cliente no recibe inferencias sensibles generadas por IA sin base/purpose explícitos.                |
| **BR-EC09-104** | Contract tests                          | Toda integración cross-context tiene contract tests versionados.                                        |
| **BR-EC09-105** | Schema version events                   | Eventos declaran schema_version y compatibilidad.                                                       |
| **BR-EC09-106** | Replay safe                             | Consumers toleran duplicate/out-of-order según contract.                                                |
| **BR-EC09-107** | At least once                           | No prometer exactly-once distribuido.                                                                   |
| **BR-EC09-108** | Reason codes                            | Rechazos y excepciones usan reason codes estables.                                                      |
| **BR-EC09-109** | Feature flags governed                  | Funciones de alto riesgo bajo rollout/feature flag cuando aplique.                                      |
| **BR-EC09-110** | Observability no PII                    | Tracing usa IDs opacos, nunca nombres/documentos.                                                       |
| **BR-EC09-111** | Capacity budget                         | Máximos de clients/engagements/batches/items/report rows definidos por policy.                          |
| **BR-EC09-112** | Report SLA                              | SLA operacional no altera hechos académicos si incumplido.                                              |
| **BR-EC09-113** | Corporate sponsor authority             | Sponsor no puede modificar resultados académicos.                                                       |
| **BR-EC09-114** | Participant rights                      | Participante mantiene acceso a sus propios facts según políticas aunque sponsor sea pagador.            |
| **BR-EC09-115** | Billing entity                          | Entidad facturada puede diferir de CorporateClientAccount; Finanzas decide.                             |
| **BR-EC09-116** | Third-party payer                       | Tercero pagador no gana acceso académico por pagar.                                                     |
| **BR-EC09-117** | Multi-company engagement                | Si un engagement involucra varias organizaciones, relación explícita y scopes separados.                |
| **BR-EC09-118** | Cross-tenant corporation                | Una misma empresa externa puede estar referenciada por tenants distintos sin compartir datos.           |
| **BR-EC09-119** | No tenant from JWT claim alone          | Tenant context debe validarse contra autorización/scope activo.                                         |
| **BR-EC09-120** | Release evidence                        | Gates requieren evidencia automatizada y manual antes de producción.                                    |

# 

| **ID**          | **Caso de uso**                               | **Actor primario**        |
|-----------------|-----------------------------------------------|---------------------------|
| **UC-EC09-001** | Crear CorporateClientAccount                  | Corporate Manager         |
| **UC-EC09-002** | Modificar metadata editable del cliente       | Corporate Manager         |
| **UC-EC09-003** | Activar/Suspender/Retirar cliente corporativo | Corporate Manager         |
| **UC-EC09-004** | Registrar contacto corporativo por referencia | Corporate Manager         |
| **UC-EC09-005** | Crear TNA                                     | Corporate Manager         |
| **UC-EC09-006** | Agregar requirement TNA                       | Corporate Manager         |
| **UC-EC09-007** | Solicitar revisión de TNA                     | Corporate Manager         |
| **UC-EC09-008** | Aprobar/Rechazar TNA                          | Corporate Manager         |
| **UC-EC09-009** | Cerrar TNA                                    | Corporate Manager         |
| **UC-EC09-010** | Crear CorporateTrainingEngagement             | Corporate Manager         |
| **UC-EC09-011** | Crear EngagementVersion                       | Corporate Manager         |
| **UC-EC09-012** | Clonar versión activa                         | Corporate Manager         |
| **UC-EC09-013** | Editar alcance draft                          | Corporate Manager         |
| **UC-EC09-014** | Vincular ProgramVersion                       | Corporate Manager         |
| **UC-EC09-015** | Vincular ProgramEdition/Offering              | Corporate Manager         |
| **UC-EC09-016** | Definir seat pool                             | Corporate Manager         |
| **UC-EC09-017** | Definir SLA/commitment                        | Corporate Manager         |
| **UC-EC09-018** | Definir commercial agreement ref              | Corporate Manager         |
| **UC-EC09-019** | Crear milestone                               | Corporate Manager         |
| **UC-EC09-020** | Crear deliverable                             | Corporate Manager         |
| **UC-EC09-021** | Adjuntar evidence/document ref                | Corporate Manager         |
| **UC-EC09-022** | Solicitar revisión de engagement              | Corporate Manager         |
| **UC-EC09-023** | Aprobar engagement                            | Corporate Manager         |
| **UC-EC09-024** | Activar engagement                            | Corporate Manager         |
| **UC-EC09-025** | Suspender engagement                          | Corporate Manager         |
| **UC-EC09-026** | Cancelar engagement                           | Corporate Manager         |
| **UC-EC09-027** | Superseder engagement version                 | Corporate Manager         |
| **UC-EC09-028** | Comparar versiones                            | Corporate Manager         |
| **UC-EC09-029** | Simular impacto de cambio                     | Corporate Manager         |
| **UC-EC09-030** | Crear NominationBatch                         | Operator/Authorized Actor |
| **UC-EC09-031** | Importar nominaciones dry-run                 | Operator/Authorized Actor |
| **UC-EC09-032** | Validar nominaciones                          | Operator/Authorized Actor |
| **UC-EC09-033** | Resolver identidad nominee                    | Operator/Authorized Actor |
| **UC-EC09-034** | Corregir item rechazado                       | Operator/Authorized Actor |
| **UC-EC09-035** | Promover nomination batch                     | Operator/Authorized Actor |
| **UC-EC09-036** | Crear CorporateEnrollmentBatch                | Operator/Authorized Actor |
| **UC-EC09-037** | Procesar enrollment items                     | Operator/Authorized Actor |
| **UC-EC09-038** | Reprocesar item fallido                       | Operator/Authorized Actor |
| **UC-EC09-039** | Cancelar batch no iniciado                    | Operator/Authorized Actor |
| **UC-EC09-040** | Reconciliar enrollment UNKNOWN_EFFECT         | Operator/Authorized Actor |
| **UC-EC09-041** | Solicitar sustitución                         | Operator/Authorized Actor |
| **UC-EC09-042** | Aprobar sustitución                           | Operator/Authorized Actor |
| **UC-EC09-043** | Ejecutar sustitución EC-04                    | Operator/Authorized Actor |
| **UC-EC09-044** | Consultar seat utilization                    | Operator/Authorized Actor |
| **UC-EC09-045** | Liberar seat por policy                       | Operator/Authorized Actor |
| **UC-EC09-046** | Crear ReportingProfile                        | Operator/Authorized Actor |
| **UC-EC09-047** | Definir métricas permitidas                   | Operator/Authorized Actor |
| **UC-EC09-048** | Definir audiences                             | Operator/Authorized Actor |
| **UC-EC09-049** | Aprobar ReportingProfile                      | Operator/Authorized Actor |
| **UC-EC09-050** | Generar ReportRun                             | Operator/Authorized Actor |
| **UC-EC09-051** | Publicar ReportRun                            | Operator/Authorized Actor |
| **UC-EC09-052** | Entregar reporte al sponsor                   | Operator/Authorized Actor |
| **UC-EC09-053** | Revocar audience                              | Operator/Authorized Actor |
| **UC-EC09-054** | Corregir reporte publicado                    | Operator/Authorized Actor |
| **UC-EC09-055** | Consultar report history                      | Operator/Authorized Actor |
| **UC-EC09-056** | Crear FinancialIntent                         | Operator/Authorized Actor |
| **UC-EC09-057** | Consultar financial status                    | Operator/Authorized Actor |
| **UC-EC09-058** | Reconciliar financial UNKNOWN_EFFECT          | Operator/Authorized Actor |
| **UC-EC09-059** | Registrar acceptance de milestone             | Operator/Authorized Actor |
| **UC-EC09-060** | Rechazar deliverable con reason               | Operator/Authorized Actor |
| **UC-EC09-061** | Superseder deliverable                        | Operator/Authorized Actor |
| **UC-EC09-062** | Exportar evidence pack                        | Operator/Authorized Actor |
| **UC-EC09-063** | Consultar portal corporativo                  | Operator/Authorized Actor |
| **UC-EC09-064** | Descargar reporte autorizado                  | Operator/Authorized Actor |
| **UC-EC09-065** | Solicitar IA para TNA                         | Operator/Authorized Actor |
| **UC-EC09-066** | Aceptar/rechazar sugerencia IA                | Operator/Authorized Actor |
| **UC-EC09-067** | Importar legacy corporate data                | Operator/Authorized Actor |
| **UC-EC09-068** | Promover lote migrado                         | Operator/Authorized Actor |
| **UC-EC09-069** | Consultar OperationStatus                     | Operator/Authorized Actor |
| **UC-EC09-070** | Reconciliar outbox/inbox                      | Operator/Authorized Actor |
| **UC-EC09-071** | Validar RLS isolation                         | Operator/Authorized Actor |
| **UC-EC09-072** | Auditar access report                         | Operator/Authorized Actor |
| **UC-EC09-073** | Retirar corporate client con historia         | Operator/Authorized Actor |
| **UC-EC09-074** | Consultar dependencias downstream             | Operator/Authorized Actor |

## 

### 

| **Aspecto**                   | **Detalle**                                                                                              |
|-------------------------------|----------------------------------------------------------------------------------------------------------|
| **Actor**                     | Corporate Governance                                                                                     |
| **Trigger**                   | Versión APPROVED lista para ejecución                                                                    |
| Precondiciones / autorización | APPROVED; refs EC-01/02 resolubles; reporting profile válido; step-up/SoD según policy                   |
| **Happy Path**                | Lock aggregate → revalidar snapshot/policies → ACTIVE → receipt + outbox → commit                        |
| **Alternativas / errores**    | Dependencia crítica unavailable =\> 503; ETag mismatch =\> 412; duplicate key =\> replay mismo resultado |
| **Idempotencia**              | Idempotency-Key durable                                                                                  |
| **Concurrencia**              | If-Match + state guard + one-active constraint                                                           |
| Auditoría / side effects      | Audit + evidence pack + event                                                                            |
| **Postcondición**             | ACTIVE inmutable y consumible downstream.                                                                |

### 

| **Aspecto**                   | **Detalle**                                                    |
|-------------------------------|----------------------------------------------------------------|
| **Actor**                     | Corporate Coordinator                                          |
| **Trigger**                   | Cliente entrega lista de participantes                         |
| Precondiciones / autorización | Engagement ACTIVE; seat pool abierto; file/document ref válido |
| **Happy Path**                | Crea batch, source hash y items; no crea enrollment            |
| **Alternativas / errores**    | Formato inválido/duplicado =\> item FAILED/NEEDS_REVIEW        |
| **Idempotencia**              | Batch key + source hash                                        |
| **Concurrencia**              | Aggregate revision                                             |
| Auditoría / side effects      | Audit + outbox                                                 |
| **Postcondición**             | Batch listo para validate/promote.                             |

### 

| **Aspecto**                   | **Detalle**                                                                       |
|-------------------------------|-----------------------------------------------------------------------------------|
| **Actor**                     | Enrollment Operator                                                               |
| **Trigger**                   | Nomination batch READY                                                            |
| Precondiciones / autorización | Items válidos y capacity suficiente                                               |
| **Happy Path**                | Crea command batch, llama EC-04 por item con idempotency keys; consolida receipts |
| **Alternativas / errores**    | Partial success, timeout/UNKNOWN_EFFECT por item                                  |
| **Idempotencia**              | Idempotencia por batch e item                                                     |
| **Concurrencia**              | Seat consumption transaccional + ETag                                             |
| Auditoría / side effects      | Audit + outbox/inbox                                                              |
| **Postcondición**             | COMPLETED/PARTIAL/RECONCILING.                                                    |

### 

| **Aspecto**                   | **Detalle**                                                                      |
|-------------------------------|----------------------------------------------------------------------------------|
| **Actor**                     | Corporate Operator                                                               |
| **Trigger**                   | Sponsor solicita reemplazo                                                       |
| Precondiciones / autorización | Policy/cutoff permite; old enrollment resoluble; new nominee válido              |
| **Happy Path**                | Lock substitution → command EC-04 → receipt → consume/libera seat coherentemente |
| **Alternativas / errores**    | Si efecto remoto incierto, UNKNOWN_EFFECT y reconcile                            |
| **Idempotencia**              | Idempotency-Key                                                                  |
| **Concurrencia**              | If-Match + lock seat pool                                                        |
| Auditoría / side effects      | Audit reason/evidence                                                            |
| **Postcondición**             | Substitution APPLIED o RECONCILING.                                              |

### 

| **Aspecto**                   | **Detalle**                                                                                |
|-------------------------------|--------------------------------------------------------------------------------------------|
| **Actor**                     | Reporting Service                                                                          |
| **Trigger**                   | Sponsor/operador solicita reporte                                                          |
| Precondiciones / autorización | ReportingProfile ACTIVE; audience autorizada; purpose válido                               |
| **Happy Path**                | Resolve facts EC-04/06/07/08 → apply privacy filters → aggregate → hash/provenance → READY |
| **Alternativas / errores**    | Dependencia stale =\> PARTIAL/STALE; no inventar cero                                      |
| **Idempotencia**              | Request idempotent by profile+asOf+parameters hash                                         |
| **Concurrencia**              | Snapshot-aware                                                                             |
| Auditoría / side effects      | Audit report access/generation                                                             |
| **Postcondición**             | ReportRun reproducible.                                                                    |

### 

| **Aspecto**                   | **Detalle**                                                           |
|-------------------------------|-----------------------------------------------------------------------|
| **Actor**                     | Corporate Report Publisher                                            |
| **Trigger**                   | ReportRun READY/PUBLISHED                                             |
| Precondiciones / autorización | Audience autorizada; document/export ref CT-05 disponible             |
| **Happy Path**                | Generate secure delivery → receipt channel/recipient/hash/status      |
| **Alternativas / errores**    | Delivery timeout =\> status UNKNOWN/RETRYABLE sin duplicar exposición |
| **Idempotencia**              | Delivery idempotency key                                              |
| **Concurrencia**              | No academic mutation                                                  |
| Auditoría / side effects      | Access audit + receipt                                                |
| **Postcondición**             | Entrega trazable.                                                     |

### 

| **Aspecto**                   | **Detalle**                                                                |
|-------------------------------|----------------------------------------------------------------------------|
| **Actor**                     | Authorized Operator                                                        |
| **Trigger**                   | Necesidad de facturación/cargo/referencia comercial                        |
| Precondiciones / autorización | Engagement válido; permiso/SoD                                             |
| **Happy Path**                | Persist intent + outbox/connector command; Finanzas crea verdad financiera |
| **Alternativas / errores**    | Timeout =\> UNKNOWN_EFFECT; reconcile before retry                         |
| **Idempotencia**              | Idempotency-Key mandatory                                                  |
| **Concurrencia**              | Intent versioning                                                          |
| Auditoría / side effects      | Audit financial boundary                                                   |
| **Postcondición**             | Intent CONFIRMED/REJECTED/UNKNOWN_EFFECT.                                  |

### 

| **Aspecto**                   | **Detalle**                                                                                           |
|-------------------------------|-------------------------------------------------------------------------------------------------------|
| **Actor**                     | Ops/Reconciliation                                                                                    |
| **Trigger**                   | Timeout o inconsistencia                                                                              |
| Precondiciones / autorización | FinancialIntent UNKNOWN_EFFECT                                                                        |
| **Happy Path**                | Consultar por external request/idempotency key → confirmar aplicado/no aplicado → solo entonces retry |
| **Alternativas / errores**    | Dependencia sigue unavailable =\> mantener UNKNOWN_EFFECT                                             |
| **Idempotencia**              | Reconcile idempotent                                                                                  |
| **Concurrencia**              | Case lock                                                                                             |
| Auditoría / side effects      | Evidence + reason                                                                                     |
| **Postcondición**             | RECONCILED con autoridad.                                                                             |

### 

| **Aspecto**                   | **Detalle**                                                          |
|-------------------------------|----------------------------------------------------------------------|
| **Actor**                     | Corporate Learning Designer                                          |
| **Trigger**                   | Necesidad de resumir/analizar TNA                                    |
| Precondiciones / autorización | Purpose autorizado; datos minimizados                                |
| **Happy Path**                | CT-12 genera recommendation con grounding/confidence; usuario revisa |
| **Alternativas / errores**    | CT-12 unavailable =\> trabajo manual continúa                        |
| **Idempotencia**              | Request key                                                          |
| **Concurrencia**              | No mutation hasta apply                                              |
| Auditoría / side effects      | AI provenance                                                        |
| **Postcondición**             | Suggestion pending human action.                                     |

# 

## 

El modelo se articula alrededor de CorporateClientAccount, TrainingNeedAssessment, CorporateTrainingEngagement/EngagementVersion, lotes de nominación/inscripción y ReportingProfile/ReportRun. Los hechos académicos de participante permanecen fuera del bounded context.

## 

Las relaciones físicas internas incluyen tenant_id en FKs críticas. EngagementVersion agrega program bindings, scope items, seat pools, commitments, milestones y reporting references. NominationBatch agrega items; EnrollmentBatch procesa los items hacia EC-04. ReportRun se construye a partir de un ReportingProfile y conserva provenance/receipts.

## 

<img src="media/image30.png" style="width:6.5in;height:3.9in" />

Figura 4 — DER físico resumido EC-09

| **REGLA DE FK — Todas las FKs físicas del esquema ec09 son internas y tenant-aware. CT-01…CT-18, EC-01…EC-08, IAM, RRHH y Finanzas se consumen mediante EXT REF y contratos; nunca mediante FK cross-context.** |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

El esquema propuesto es ec09. Toda tabla de negocio tenant-owned incorpora tenant_id y queda bajo RLS. FKs físicas solo existen dentro de EC-09 y son tenant-aware. Las referencias a CT, IAM, Finanzas y otros EC son EXT REF. PostgreSQL debe impedir estados imposibles aunque Backend tenga un bug.

| **PREGUNTA OBLIGATORIA — Para cada tabla: ¿qué error debe impedir PostgreSQL aunque Backend tenga un bug? La respuesta se materializa en PK/FK/UQ/CHECK/RLS/triggers e índices.** |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 

QUÉ REPRESENTA — ec09_corporate_client_account representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                          | **Ejemplo**     |
|---------------------------|---------------------|----------|-------------------|-----------|------------------------------------------|-----------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*      | Tenant autorizado.                       | 8a6…            |
| **corporate_client_id**   | uuid                | NO       | gen_random_uuid() | PK        | ID técnico.                              | corp…           |
| **corporate_client_code** | varchar(64)         | NO       | —                 | UQ        | Código B2B estable.                      | ACME-BO         |
| **external_org_ref**      | uuid                | YES      | NULL              | EXT REF   | Organización canónica externa si existe. | org…            |
| **legal_name_snapshot**   | varchar(240)        | NO       | —                 | —         | Nombre legal snapshot para expediente.   | ACME Bolivia SA |
| **lifecycle_state**       | varchar(24)         | NO       | 'DRAFT'           | CHECK     | DRAFT/ACTIVE/SUSPENDED/RETIRED.          | ACTIVE          |
| **created_by_subject**    | uuid                | NO       | —                 | EXT REF   | Actor creador.                           | usr…            |
| **created_at**            | timestamptz         | NO       | now()             | —         | Creación UTC.                            | …               |
| **updated_at**            | timestamptz         | NO       | now()             | —         | Última actualización.                    | …               |
| **version**               | bigint              | NO       | 0                 | —         | Optimistic lock.                         | 3               |

### 

**tenant_id —** Tenant autorizado. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a6….

**corporate_client_id —** ID técnico. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: corp….

**corporate_client_code —** Código B2B estable. Nulabilidad: NO; default físico: —. Ejemplo: ACME-BO.

**external_org_ref —** Organización canónica externa si existe. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: org….

**legal_name_snapshot —** Nombre legal snapshot para expediente. Nulabilidad: NO; default físico: —. Ejemplo: ACME Bolivia SA.

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/RETIRED. Nulabilidad: NO; default físico: 'DRAFT'. Ejemplo: ACTIVE.

**created_by_subject —** Actor creador. Nulabilidad: NO; default físico: —. Ejemplo: usr….

**created_at —** Creación UTC. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Última actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Optimistic lock. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 3.

| **Nombre físico**                                | **Tipo** | **Definición/expresión**                                  | **Error que impide**                                    |
|--------------------------------------------------|----------|-----------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_corporate_client_account                 | PK       | Clave primaria tenant-aware/identidad de fila.            | Duplicidad o identidad ambigua.                         |
| uq_ec09_corporate_client_account_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.           | Duplicados funcionales.                                 |
| ck_ec09_corporate_client_account_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables. | Estados o valores físicamente imposibles.               |
| ix_ec09_corporate_client_account_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.            | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_corporate_client_account                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.     | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_corporate_contact_ref representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                      | **Ejemplo** |
|-------------------------|---------------------|----------|-------------------|---------------|--------------------------------------|-------------|
| **tenant_id**           | uuid                | NO       | —                 | PK\*          | Tenant.                              | 8a…         |
| **contact_ref_id**      | uuid                | NO       | gen_random_uuid() | PK            | ID vínculo.                          | ccr…        |
| **corporate_client_id** | uuid                | NO       | —                 | FK            | Cliente padre.                       | corp…       |
| **person_ref**          | uuid                | NO       | —                 | EXT REF CT-04 | Persona contacto.                    | prs…        |
| **contact_role_code**   | varchar(64)         | NO       | —                 | EXT REF CT-02 | Rol sponsor/coordinator/billing/etc. | SPONSOR     |
| **valid_from**          | date                | NO       | CURRENT_DATE      | —             | Inicio vigencia.                     | 2026-09-01  |
| **valid_to**            | date                | YES      | NULL              | CHECK         | Fin vigencia.                        | NULL        |
| **created_at**          | timestamptz         | NO       | now()             | —             | Creación.                            | …           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**contact_ref_id —** ID vínculo. Nulabilidad: NO; default físico: gen_random_uuid(). Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ccr….

**corporate_client_id —** Cliente padre. Nulabilidad: NO; default físico: —. Ejemplo: corp….

**person_ref —** Persona contacto. Nulabilidad: NO; default físico: —. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: prs….

**contact_role_code —** Rol sponsor/coordinator/billing/etc. Nulabilidad: NO; default físico: —. Ejemplo: SPONSOR.

**valid_from —** Inicio vigencia. Nulabilidad: NO; default físico: CURRENT_DATE. Ejemplo: 2026-09-01.

**valid_to —** Fin vigencia. Nulabilidad: YES; default físico: NULL. Ejemplo: NULL.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                             | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|-----------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_corporate_contact_ref                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_corporate_contact_ref_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_corporate_contact_ref_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_corporate_contact_ref_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_corporate_contact_ref                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_training_need_assessment representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**         | **Ejemplo**     |
|--------------------------|---------------------|----------|-------------------|---------------|-------------------------|-----------------|
| **tenant_id**            | uuid                | NO       | —                 | PK\*          | Tenant.                 | 8a…             |
| **tna_id**               | uuid                | NO       | gen_random_uuid() | PK            | ID TNA.                 | tna…            |
| **corporate_client_id**  | uuid                | NO       | —                 | FK            | Cliente.                | corp…           |
| **tna_code**             | varchar(64)         | NO       | —                 | UQ            | Código diagnóstico.     | TNA-2026-04     |
| **title**                | varchar(240)        | NO       | —                 | —             | Título del diagnóstico. | IA para líderes |
| **state**                | varchar(24)         | NO       | 'DRAFT'           | CHECK         | Lifecycle TNA.          | APPROVED        |
| **purpose_ref**          | uuid                | YES      | NULL              | EXT REF       | Purpose/privacy.        | pur…            |
| **confidentiality_code** | varchar(40)         | NO       | 'INTERNAL'        | EXT REF       | Clasificación.          | CONFIDENTIAL    |
| **workflow_ref**         | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow.               | wf…             |
| **approved_at**          | timestamptz         | YES      | NULL              | —             | Aprobación.             | …               |
| **approved_by_subject**  | uuid                | YES      | NULL              | EXT REF       | Aprobador.              | usr…            |
| **created_at**           | timestamptz         | NO       | now()             | —             | Creación.               | …               |
| **updated_at**           | timestamptz         | NO       | now()             | —             | Actualización.          | …               |
| **version**              | bigint              | NO       | 0                 | —             | Optimistic lock.        | 2               |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**tna_id —** ID TNA. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: tna….

**corporate_client_id —** Cliente. Nulabilidad: NO; default físico: —. Ejemplo: corp….

**tna_code —** Código diagnóstico. Nulabilidad: NO; default físico: —. Ejemplo: TNA-2026-04.

**title —** Título del diagnóstico. Nulabilidad: NO; default físico: —. Ejemplo: IA para líderes.

**state —** Lifecycle TNA. Nulabilidad: NO; default físico: 'DRAFT'. Ejemplo: APPROVED.

**purpose_ref —** Purpose/privacy. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pur….

**confidentiality_code —** Clasificación. Nulabilidad: NO; default físico: 'INTERNAL'. Ejemplo: CONFIDENTIAL.

**workflow_ref —** Workflow. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: wf….

**approved_at —** Aprobación. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**approved_by_subject —** Aprobador. Nulabilidad: YES; default físico: NULL. Ejemplo: usr….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Optimistic lock. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 2.

| **Nombre físico**                                | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|--------------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_training_need_assessment                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_training_need_assessment_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_training_need_assessment_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_training_need_assessment_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_training_need_assessment_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_training_need_assessment                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_tna_requirement representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**        | **Ejemplo**      |
|---------------------------|---------------------|----------|-------------------|-----------|------------------------|------------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*      | Tenant.                | 8a…              |
| **tna_requirement_id**    | uuid                | NO       | gen_random_uuid() | PK        | ID.                    | tr…              |
| **tna_id**                | uuid                | NO       | —                 | FK        | TNA padre.             | tna…             |
| **requirement_code**      | varchar(64)         | NO       | —                 | UQ        | Código interno.        | REQ-01           |
| **requirement_type_code** | varchar(64)         | NO       | —                 | EXT REF   | Tipo parametrizado.    | LEARNING_OUTCOME |
| **statement**             | text                | NO       | —                 | —         | Necesidad/restricción. | Mejorar…         |
| **priority_code**         | varchar(32)         | NO       | 'MEDIUM'          | EXT REF   | Prioridad.             | HIGH             |
| **sequence_no**           | integer             | NO       | 1                 | CHECK     | Orden.                 | 1                |
| **created_at**            | timestamptz         | NO       | now()             | —         | Creación.              | …                |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**tna_requirement_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: tr….

**tna_id —** TNA padre. Nulabilidad: NO; default físico: —. Ejemplo: tna….

**requirement_code —** Código interno. Nulabilidad: NO; default físico: —. Ejemplo: REQ-01.

**requirement_type_code —** Tipo parametrizado. Nulabilidad: NO; default físico: —. Ejemplo: LEARNING_OUTCOME.

**statement —** Necesidad/restricción. Nulabilidad: NO; default físico: —. Ejemplo: Mejorar….

**priority_code —** Prioridad. Nulabilidad: NO; default físico: 'MEDIUM'. Ejemplo: HIGH.

**sequence_no —** Orden. Nulabilidad: NO; default físico: 1. Ejemplo: 1.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|-----------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| **pk_ec09_tna_requirement**             | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_tna_requirement_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_tna_requirement_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_tna_requirement_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_tna_requirement_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_tna_requirement                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_engagement representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                          | **Ejemplo**         |
|-------------------------|---------------------|----------|-------------------|-----------|------------------------------------------|---------------------|
| **tenant_id**           | uuid                | NO       | —                 | PK\*      | Tenant.                                  | 8a…                 |
| **engagement_id**       | uuid                | NO       | gen_random_uuid() | PK        | ID estable.                              | eng…                |
| **corporate_client_id** | uuid                | NO       | —                 | FK        | Cliente.                                 | corp…               |
| **engagement_code**     | varchar(64)         | NO       | —                 | UQ        | Código servicio.                         | ENG-2026-015        |
| **title**               | varchar(240)        | NO       | —                 | —         | Nombre operativo.                        | Programa líderes IA |
| **lifecycle_state**     | varchar(24)         | NO       | 'DRAFT'           | CHECK     | DRAFT/ACTIVE/SUSPENDED/CANCELLED/CLOSED. | ACTIVE              |
| **created_at**          | timestamptz         | NO       | now()             | —         | Creación.                                | …                   |
| **updated_at**          | timestamptz         | NO       | now()             | —         | Actualización.                           | …                   |
| **version**             | bigint              | NO       | 0                 | —         | Optimistic lock.                         | 4                   |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**engagement_id —** ID estable. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: eng….

**corporate_client_id —** Cliente. Nulabilidad: NO; default físico: —. Ejemplo: corp….

**engagement_code —** Código servicio. Nulabilidad: NO; default físico: —. Ejemplo: ENG-2026-015.

**title —** Nombre operativo. Nulabilidad: NO; default físico: —. Ejemplo: Programa líderes IA.

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/CANCELLED/CLOSED. Nulabilidad: NO; default físico: 'DRAFT'. Ejemplo: ACTIVE.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Optimistic lock. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 4.

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| **pk_ec09_engagement**             | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_engagement_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_engagement_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_engagement_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_engagement_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| **rls_ec09_engagement**            | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_engagement_version representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                 | **Ejemplo**    |
|---------------------------|---------------------|----------|-------------------|-----------|-----------------------------------------------------------------|----------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*      | Tenant.                                                         | 8a…            |
| **engagement_version_id** | uuid                | NO       | gen_random_uuid() | PK        | Snapshot ID.                                                    | ev…            |
| **engagement_id**         | uuid                | NO       | —                 | FK        | Engagement padre.                                               | eng…           |
| **version_no**            | integer             | NO       | —                 | UQ        | Versión positiva.                                               | 2              |
| **previous_version_id**   | uuid                | YES      | NULL              | FK        | Lineage same engagement.                                        | ev1…           |
| **state**                 | varchar(24)         | NO       | 'DRAFT'           | CHECK     | DRAFT/IN_REVIEW/APPROVED/ACTIVE/SUPERSEDED/SUSPENDED/CANCELLED. | ACTIVE         |
| **tna_ref**               | uuid                | YES      | NULL              | EXT REF   | TNA fuente.                                                     | tna…           |
| commercial_agreement_ref  | uuid                | YES      | NULL              | EXT REF   | Acuerdo/contrato.                                               | agr…           |
| **scope_summary**         | text                | NO       | —                 | —         | Resumen contractual-académico.                                  | Capacitar 120… |
| **valid_from**            | date                | YES      | NULL              | CHECK     | Inicio vigencia.                                                | 2026-10-01     |
| **valid_to**              | date                | YES      | NULL              | CHECK     | Fin vigencia.                                                   | 2027-03-31     |
| **reporting_profile_id**  | uuid                | YES      | NULL              | FK        | Perfil reporte default.                                         | rp…            |
| **content_hash**          | varchar(128)        | YES      | NULL              | —         | Hash snapshot.                                                  | sha256:…       |
| **activated_at**          | timestamptz         | YES      | NULL              | —         | Activación.                                                     | …              |
| **activated_by_subject**  | uuid                | YES      | NULL              | EXT REF   | Actor.                                                          | usr…           |
| superseded_by_version_id  | uuid                | YES      | NULL              | FK        | Versión posterior.                                              | ev3…           |
| **created_at**            | timestamptz         | NO       | now()             | —         | Creación.                                                       | …              |
| **updated_at**            | timestamptz         | NO       | now()             | —         | Actualización.                                                  | …              |
| **version**               | bigint              | NO       | 0                 | —         | Aggregate revision.                                             | 7              |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**engagement_version_id —** Snapshot ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: ev….

**engagement_id —** Engagement padre. Nulabilidad: NO; default físico: —. Ejemplo: eng….

**version_no —** Versión positiva. Nulabilidad: NO; default físico: —. Ejemplo: 2.

**previous_version_id —** Lineage same engagement. Nulabilidad: YES; default físico: NULL. Ejemplo: ev1….

**state —** DRAFT/IN_REVIEW/APPROVED/ACTIVE/SUPERSEDED/SUSPENDED/CANCELLED. Nulabilidad: NO; default físico: 'DRAFT'. Ejemplo: ACTIVE.

**tna_ref —** TNA fuente. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: tna….

**commercial_agreement_ref —** Acuerdo/contrato. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: agr….

**scope_summary —** Resumen contractual-académico. Nulabilidad: NO; default físico: —. Ejemplo: Capacitar 120….

**valid_from —** Inicio vigencia. Nulabilidad: YES; default físico: NULL. Ejemplo: 2026-10-01.

**valid_to —** Fin vigencia. Nulabilidad: YES; default físico: NULL. Ejemplo: 2027-03-31.

**reporting_profile_id —** Perfil reporte default. Nulabilidad: YES; default físico: NULL. Ejemplo: rp….

**content_hash —** Hash snapshot. Nulabilidad: YES; default físico: NULL. Se calcula con algoritmo/canonicalization definidos por contrato; no debe depender de serialización accidental. Ejemplo: sha256:….

**activated_at —** Activación. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**activated_by_subject —** Actor. Nulabilidad: YES; default físico: NULL. Ejemplo: usr….

**superseded_by_version_id —** Versión posterior. Nulabilidad: YES; default físico: NULL. Ejemplo: ev3….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Aggregate revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 7.

| **Nombre físico**                          | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|--------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_engagement_version                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_engagement_version_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_engagement_version_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_engagement_version_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_engagement_version_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_engagement_version                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_engagement_program_binding representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**       | **Ejemplo** |
|---------------------------|---------------------|----------|-------------------|---------------|-----------------------|-------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant.               | 8a…         |
| **binding_id**            | uuid                | NO       | gen_random_uuid() | PK            | ID.                   | epb…        |
| **engagement_version_id** | uuid                | NO       | —                 | FK            | Versión padre.        | ev…         |
| **program_version_ref**   | uuid                | NO       | —                 | EXT REF EC-01 | ProgramVersion pin.   | pv…         |
| **program_edition_ref**   | uuid                | YES      | NULL              | EXT REF EC-02 | Edition pin.          | ed…         |
| **offering_ref**          | uuid                | YES      | NULL              | EXT REF EC-02 | Offering pin.         | off…        |
| **binding_role_code**     | varchar(40)         | NO       | 'PRIMARY'         | EXT REF       | PRIMARY/OPTIONAL/etc. | PRIMARY     |
| **sequence_no**           | integer             | NO       | 1                 | CHECK         | Orden.                | 1           |
| **created_at**            | timestamptz         | NO       | now()             | —             | Creación.             | …           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**binding_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: epb….

**engagement_version_id —** Versión padre. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**program_version_ref —** ProgramVersion pin. Nulabilidad: NO; default físico: —. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pv….

**program_edition_ref —** Edition pin. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ed….

**offering_ref —** Offering pin. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: off….

**binding_role_code —** PRIMARY/OPTIONAL/etc. Nulabilidad: NO; default físico: 'PRIMARY'. Ejemplo: PRIMARY.

**sequence_no —** Orden. Nulabilidad: NO; default físico: 1. Ejemplo: 1.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                                  | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|----------------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_engagement_program_binding                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_engagement_program_binding_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_engagement_program_binding_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_engagement_program_binding_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_engagement_program_binding                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_engagement_scope_item representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**     | **Ejemplo**        |
|---------------------------|---------------------|----------|-------------------|-----------|---------------------|--------------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*      | Tenant.             | 8a…                |
| **scope_item_id**         | uuid                | NO       | gen_random_uuid() | PK        | ID.                 | esi…               |
| **engagement_version_id** | uuid                | NO       | —                 | FK        | Versión.            | ev…                |
| **scope_code**            | varchar(64)         | NO       | —                 | UQ        | Código alcance.     | COHORT_A           |
| **description**           | text                | NO       | —                 | —         | Descripción.        | Cohorte ejecutiva… |
| **quantity**              | numeric(12,2)       | YES      | NULL              | CHECK     | Cantidad si aplica. | 120                |
| **unit_code**             | varchar(40)         | YES      | NULL              | EXT REF   | Unidad.             | PARTICIPANT        |
| **created_at**            | timestamptz         | NO       | now()             | —         | Creación.           | …                  |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**scope_item_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: esi….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**scope_code —** Código alcance. Nulabilidad: NO; default físico: —. Ejemplo: COHORT_A.

**description —** Descripción. Nulabilidad: NO; default físico: —. Ejemplo: Cohorte ejecutiva….

**quantity —** Cantidad si aplica. Nulabilidad: YES; default físico: NULL. Ejemplo: 120.

**unit_code —** Unidad. Nulabilidad: YES; default físico: NULL. Ejemplo: PARTICIPANT.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                             | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|-----------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_engagement_scope_item                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_engagement_scope_item_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_engagement_scope_item_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_engagement_scope_item_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_engagement_scope_item_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_engagement_scope_item                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_service_level_commitment representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**      | **Ejemplo**     |
|---------------------------|---------------------|----------|-------------------|-----------|----------------------|-----------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*      | Tenant.              | 8a…             |
| **commitment_id**         | uuid                | NO       | gen_random_uuid() | PK        | ID.                  | slc…            |
| **engagement_version_id** | uuid                | NO       | —                 | FK        | Versión.             | ev…             |
| **commitment_code**       | varchar(64)         | NO       | —                 | UQ        | Código.              | REPORT_TPLUS3   |
| **metric_code**           | varchar(80)         | NO       | —                 | EXT REF   | Métrica contractual. | REPORT_DELIVERY |
| **target_value**          | numeric(14,4)       | YES      | NULL              | —         | Objetivo numérico.   | 3               |
| **target_unit_code**      | varchar(40)         | YES      | NULL              | EXT REF   | Unidad.              | BUSINESS_DAY    |
| **policy_ref**            | uuid                | YES      | NULL              | EXT REF   | Policy.              | pol…            |
| **created_at**            | timestamptz         | NO       | now()             | —         | Creación.            | …               |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**commitment_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: slc….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**commitment_code —** Código. Nulabilidad: NO; default físico: —. Ejemplo: REPORT_TPLUS3.

**metric_code —** Métrica contractual. Nulabilidad: NO; default físico: —. Ejemplo: REPORT_DELIVERY.

**target_value —** Objetivo numérico. Nulabilidad: YES; default físico: NULL. Ejemplo: 3.

**target_unit_code —** Unidad. Nulabilidad: YES; default físico: NULL. Ejemplo: BUSINESS_DAY.

**policy_ref —** Policy. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                                | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|--------------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_service_level_commitment                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_service_level_commitment_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_service_level_commitment_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_service_level_commitment_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_service_level_commitment_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_service_level_commitment                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_commercial_agreement_binding representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**             | **Ejemplo** |
|---------------------------|---------------------|----------|-------------------|---------------|-----------------------------|-------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant.                     | 8a…         |
| **agreement_binding_id**  | uuid                | NO       | gen_random_uuid() | PK            | ID.                         | cab…        |
| **engagement_version_id** | uuid                | NO       | —                 | FK            | Versión.                    | ev…         |
| **agreement_ref**         | uuid                | NO       | —                 | EXT REF       | Contrato/acuerdo autoridad. | agr…        |
| **agreement_version_ref** | uuid                | YES      | NULL              | EXT REF       | Versión inmutable.          | agrv…       |
| **document_ref**          | uuid                | YES      | NULL              | EXT REF CT-05 | Documento firmado.          | doc…        |
| **effective_from**        | date                | YES      | NULL              | CHECK         | Vigencia.                   | 2026-09-15  |
| **effective_to**          | date                | YES      | NULL              | CHECK         | Fin.                        | 2027-03-31  |
| **created_at**            | timestamptz         | NO       | now()             | —             | Creación.                   | …           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**agreement_binding_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: cab….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**agreement_ref —** Contrato/acuerdo autoridad. Nulabilidad: NO; default físico: —. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: agr….

**agreement_version_ref —** Versión inmutable. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: agrv….

**document_ref —** Documento firmado. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: doc….

**effective_from —** Vigencia. Nulabilidad: YES; default físico: NULL. Ejemplo: 2026-09-15.

**effective_to —** Fin. Nulabilidad: YES; default físico: NULL. Ejemplo: 2027-03-31.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                                    | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|------------------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_commercial_agreement_binding                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_commercial_agreement_binding_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_commercial_agreement_binding_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_commercial_agreement_binding_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_commercial_agreement_binding                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_corporate_seat_pool representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                     | **Ejemplo** |
|---------------------------|---------------------|----------|-------------------|-----------|-------------------------------------|-------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*      | Tenant.                             | 8a…         |
| **seat_pool_id**          | uuid                | NO       | gen_random_uuid() | PK        | ID.                                 | sp…         |
| **engagement_version_id** | uuid                | NO       | —                 | FK        | Versión.                            | ev…         |
| **program_binding_id**    | uuid                | NO       | —                 | FK        | Binding.                            | epb…        |
| **pool_code**             | varchar(64)         | NO       | —                 | UQ        | Código pool.                        | EXEC-01     |
| **allocated_seats**       | integer             | NO       | —                 | CHECK     | Cupos contratados.                  | 120         |
| **reserved_seats**        | integer             | NO       | 0                 | CHECK     | Reservados.                         | 15          |
| **consumed_seats**        | integer             | NO       | 0                 | CHECK     | Consumidos.                         | 87          |
| **waitlist_allowed**      | boolean             | NO       | false             | —         | Permite lista externa según policy. | true        |
| **policy_ref**            | uuid                | YES      | NULL              | EXT REF   | Reglas.                             | pol…        |
| **version**               | bigint              | NO       | 0                 | —         | Lock.                               | 9           |
| **created_at**            | timestamptz         | NO       | now()             | —         | Creación.                           | …           |
| **updated_at**            | timestamptz         | NO       | now()             | —         | Actualización.                      | …           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**seat_pool_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: sp….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**program_binding_id —** Binding. Nulabilidad: NO; default físico: —. Ejemplo: epb….

**pool_code —** Código pool. Nulabilidad: NO; default físico: —. Ejemplo: EXEC-01.

**allocated_seats —** Cupos contratados. Nulabilidad: NO; default físico: —. Ejemplo: 120.

**reserved_seats —** Reservados. Nulabilidad: NO; default físico: 0. Ejemplo: 15.

**consumed_seats —** Consumidos. Nulabilidad: NO; default físico: 0. Ejemplo: 87.

**waitlist_allowed —** Permite lista externa según policy. Nulabilidad: NO; default físico: false. Ejemplo: true.

**policy_ref —** Reglas. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol….

**version —** Lock. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 9.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                           | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|---------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_corporate_seat_pool                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_corporate_seat_pool_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_corporate_seat_pool_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_corporate_seat_pool_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_corporate_seat_pool_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_corporate_seat_pool                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_nomination_batch representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**     | **Ejemplo** |
|---------------------------|---------------------|----------|-------------------|---------------|---------------------|-------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant.             | 8a…         |
| **nomination_batch_id**   | uuid                | NO       | gen_random_uuid() | PK            | ID.                 | nb…         |
| **engagement_version_id** | uuid                | NO       | —                 | FK            | Versión.            | ev…         |
| **seat_pool_id**          | uuid                | NO       | —                 | FK            | Pool.               | sp…         |
| **batch_code**            | varchar(64)         | NO       | —                 | UQ            | Código.             | NOM-003     |
| **source_document_ref**   | uuid                | YES      | NULL              | EXT REF CT-05 | Archivo fuente.     | doc…        |
| **source_hash**           | varchar(128)        | NO       | —                 | UQ            | Hash dedup.         | sha256:…    |
| **state**                 | varchar(24)         | NO       | 'DRAFT'           | CHECK         | Lifecycle.          | READY       |
| **total_items**           | integer             | NO       | 0                 | CHECK         | Total.              | 120         |
| **valid_items**           | integer             | NO       | 0                 | CHECK         | Válidos.            | 116         |
| **failed_items**          | integer             | NO       | 0                 | CHECK         | Fallidos.           | 4           |
| **created_by_subject**    | uuid                | NO       | —                 | EXT REF       | Actor.              | usr…        |
| **created_at**            | timestamptz         | NO       | now()             | —             | Creación.           | …           |
| **updated_at**            | timestamptz         | NO       | now()             | —             | Actualización.      | …           |
| **version**               | bigint              | NO       | 0                 | —             | Aggregate revision. | 5           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**nomination_batch_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: nb….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**seat_pool_id —** Pool. Nulabilidad: NO; default físico: —. Ejemplo: sp….

**batch_code —** Código. Nulabilidad: NO; default físico: —. Ejemplo: NOM-003.

**source_document_ref —** Archivo fuente. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: doc….

**source_hash —** Hash dedup. Nulabilidad: NO; default físico: —. Se calcula con algoritmo/canonicalization definidos por contrato; no debe depender de serialización accidental. Ejemplo: sha256:….

**state —** Lifecycle. Nulabilidad: NO; default físico: 'DRAFT'. Ejemplo: READY.

**total_items —** Total. Nulabilidad: NO; default físico: 0. Ejemplo: 120.

**valid_items —** Válidos. Nulabilidad: NO; default físico: 0. Ejemplo: 116.

**failed_items —** Fallidos. Nulabilidad: NO; default físico: 0. Ejemplo: 4.

**created_by_subject —** Actor. Nulabilidad: NO; default físico: —. Ejemplo: usr….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Aggregate revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 5.

| **Nombre físico**                        | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_nomination_batch                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_nomination_batch_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_nomination_batch_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_nomination_batch_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_nomination_batch_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_nomination_batch                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_nomination_item representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                             | **Ejemplo**      |
|-------------------------|---------------------|----------|-------------------|---------------|---------------------------------------------|------------------|
| **tenant_id**           | uuid                | NO       | —                 | PK\*          | Tenant.                                     | 8a…              |
| **nomination_item_id**  | uuid                | NO       | gen_random_uuid() | PK            | ID.                                         | ni…              |
| **nomination_batch_id** | uuid                | NO       | —                 | FK            | Batch.                                      | nb…              |
| **source_key**          | varchar(128)        | NO       | —                 | UQ            | Clave del origen.                           | EMP-0231         |
| **person_ref**          | uuid                | YES      | NULL              | EXT REF CT-04 | Persona resuelta.                           | prs…             |
| **identity_hint_hash**  | varchar(128)        | YES      | NULL              | —             | Hash de pista; no PII cruda.                | sha256:…         |
| **status**              | varchar(24)         | NO       | 'PENDING'         | CHECK         | PENDING/VALID/NEEDS_REVIEW/FAILED/PROMOTED. | VALID            |
| **reason_code**         | varchar(80)         | YES      | NULL              | —             | Motivo estable.                             | DUPLICATE_PERSON |
| **enrollment_ref**      | uuid                | YES      | NULL              | EXT REF EC-04 | Enrollment resultante.                      | enr…             |
| **created_at**          | timestamptz         | NO       | now()             | —             | Creación.                                   | …                |
| **updated_at**          | timestamptz         | NO       | now()             | —             | Actualización.                              | …                |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**nomination_item_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: ni….

**nomination_batch_id —** Batch. Nulabilidad: NO; default físico: —. Ejemplo: nb….

**source_key —** Clave del origen. Nulabilidad: NO; default físico: —. Ejemplo: EMP-0231.

**person_ref —** Persona resuelta. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: prs….

**identity_hint_hash —** Hash de pista; no PII cruda. Nulabilidad: YES; default físico: NULL. Se calcula con algoritmo/canonicalization definidos por contrato; no debe depender de serialización accidental. Ejemplo: sha256:….

**status —** PENDING/VALID/NEEDS_REVIEW/FAILED/PROMOTED. Nulabilidad: NO; default físico: 'PENDING'. Ejemplo: VALID.

**reason_code —** Motivo estable. Nulabilidad: YES; default físico: NULL. Ejemplo: DUPLICATE_PERSON.

**enrollment_ref —** Enrollment resultante. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: enr….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|-----------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| **pk_ec09_nomination_item**             | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_nomination_item_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_nomination_item_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_nomination_item_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_nomination_item_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_nomination_item                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_enrollment_batch representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**   | **Ejemplo** |
|-------------------------|---------------------|----------|-------------------|-----------|-------------------|-------------|
| **tenant_id**           | uuid                | NO       | —                 | PK\*      | Tenant.           | 8a…         |
| **enrollment_batch_id** | uuid                | NO       | gen_random_uuid() | PK        | ID.               | eb…         |
| **nomination_batch_id** | uuid                | NO       | —                 | FK        | Batch origen.     | nb…         |
| **state**               | varchar(24)         | NO       | 'PENDING'         | CHECK     | Lifecycle.        | PROCESSING  |
| **operation_id**        | uuid                | YES      | NULL              | FK        | Operation status. | op…         |
| **total_items**         | integer             | NO       | 0                 | CHECK     | Total.            | 116         |
| **success_items**       | integer             | NO       | 0                 | CHECK     | Éxitos.           | 110         |
| **failed_items**        | integer             | NO       | 0                 | CHECK     | Fallos.           | 6           |
| **unknown_items**       | integer             | NO       | 0                 | CHECK     | UNKNOWN_EFFECT.   | 0           |
| **started_at**          | timestamptz         | YES      | NULL              | —         | Inicio.           | …           |
| **completed_at**        | timestamptz         | YES      | NULL              | —         | Fin.              | …           |
| **version**             | bigint              | NO       | 0                 | —         | Revision.         | 4           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**enrollment_batch_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: eb….

**nomination_batch_id —** Batch origen. Nulabilidad: NO; default físico: —. Ejemplo: nb….

**state —** Lifecycle. Nulabilidad: NO; default físico: 'PENDING'. Ejemplo: PROCESSING.

**operation_id —** Operation status. Nulabilidad: YES; default físico: NULL. Ejemplo: op….

**total_items —** Total. Nulabilidad: NO; default físico: 0. Ejemplo: 116.

**success_items —** Éxitos. Nulabilidad: NO; default físico: 0. Ejemplo: 110.

**failed_items —** Fallos. Nulabilidad: NO; default físico: 0. Ejemplo: 6.

**unknown_items —** UNKNOWN_EFFECT. Nulabilidad: NO; default físico: 0. Ejemplo: 0.

**started_at —** Inicio. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**completed_at —** Fin. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 4.

| **Nombre físico**                        | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_enrollment_batch                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_enrollment_batch_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_enrollment_batch_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_enrollment_batch_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_enrollment_batch                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_enrollment_batch_item representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                               | **Ejemplo**        |
|--------------------------|---------------------|----------|-------------------|---------------|-----------------------------------------------|--------------------|
| **tenant_id**            | uuid                | NO       | —                 | PK\*          | Tenant.                                       | 8a…                |
| enrollment_batch_item_id | uuid                | NO       | gen_random_uuid() | PK            | ID.                                           | ebi…               |
| **enrollment_batch_id**  | uuid                | NO       | —                 | FK            | Batch.                                        | eb…                |
| **nomination_item_id**   | uuid                | NO       | —                 | FK            | Item origen.                                  | ni…                |
| **idempotency_key**      | varchar(128)        | NO       | —                 | UQ            | Key hacia EC-04.                              | ec04:…             |
| **status**               | varchar(24)         | NO       | 'PENDING'         | CHECK         | PENDING/SENT/SUCCEEDED/FAILED/UNKNOWN_EFFECT. | SUCCEEDED          |
| **enrollment_ref**       | uuid                | YES      | NULL              | EXT REF EC-04 | Enrollment oficial.                           | enr…               |
| **receipt_ref**          | uuid                | YES      | NULL              | EXT REF       | Receipt.                                      | rcpt…              |
| **reason_code**          | varchar(80)         | YES      | NULL              | —             | Error/rechazo.                                | ELIGIBILITY_FAILED |
| **attempt_count**        | integer             | NO       | 0                 | CHECK         | Intentos.                                     | 1                  |
| **updated_at**           | timestamptz         | NO       | now()             | —             | Actualización.                                | …                  |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**enrollment_batch_item_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: ebi….

**enrollment_batch_id —** Batch. Nulabilidad: NO; default físico: —. Ejemplo: eb….

**nomination_item_id —** Item origen. Nulabilidad: NO; default físico: —. Ejemplo: ni….

**idempotency_key —** Key hacia EC-04. Nulabilidad: NO; default físico: —. Ejemplo: ec04:….

**status —** PENDING/SENT/SUCCEEDED/FAILED/UNKNOWN_EFFECT. Nulabilidad: NO; default físico: 'PENDING'. Ejemplo: SUCCEEDED.

**enrollment_ref —** Enrollment oficial. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: enr….

**receipt_ref —** Receipt. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: rcpt….

**reason_code —** Error/rechazo. Nulabilidad: YES; default físico: NULL. Ejemplo: ELIGIBILITY_FAILED.

**attempt_count —** Intentos. Nulabilidad: NO; default físico: 0. Ejemplo: 1.

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                             | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|-----------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_enrollment_batch_item                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_enrollment_batch_item_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_enrollment_batch_item_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_enrollment_batch_item_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_enrollment_batch_item_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_enrollment_batch_item                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_participant_substitution representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                              | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------|-------------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant.                                                      | 8a…               |
| **substitution_id**       | uuid                | NO       | gen_random_uuid() | PK            | ID.                                                          | sub…              |
| **engagement_version_id** | uuid                | NO       | —                 | FK            | Versión.                                                     | ev…               |
| **seat_pool_id**          | uuid                | NO       | —                 | FK            | Pool.                                                        | sp…               |
| **old_enrollment_ref**    | uuid                | NO       | —                 | EXT REF EC-04 | Enrollment saliente.                                         | enr1…             |
| **new_person_ref**        | uuid                | NO       | —                 | EXT REF CT-04 | Persona entrante.                                            | prs2…             |
| **state**                 | varchar(24)         | NO       | 'REQUESTED'       | CHECK         | REQUESTED/APPROVED/APPLYING/APPLIED/REJECTED/UNKNOWN_EFFECT. | APPLIED           |
| **reason_code**           | varchar(80)         | NO       | —                 | —             | Motivo.                                                      | EMPLOYEE_REPLACED |
| **workflow_ref**          | uuid                | YES      | NULL              | EXT REF CT-06 | Aprobación.                                                  | wf…               |
| **new_enrollment_ref**    | uuid                | YES      | NULL              | EXT REF EC-04 | Enrollment nuevo.                                            | enr2…             |
| **receipt_ref**           | uuid                | YES      | NULL              | EXT REF       | Receipt.                                                     | rcpt…             |
| **created_at**            | timestamptz         | NO       | now()             | —             | Creación.                                                    | …                 |
| **updated_at**            | timestamptz         | NO       | now()             | —             | Actualización.                                               | …                 |
| **version**               | bigint              | NO       | 0                 | —             | Revision.                                                    | 3                 |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**substitution_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: sub….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**seat_pool_id —** Pool. Nulabilidad: NO; default físico: —. Ejemplo: sp….

**old_enrollment_ref —** Enrollment saliente. Nulabilidad: NO; default físico: —. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: enr1….

**new_person_ref —** Persona entrante. Nulabilidad: NO; default físico: —. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: prs2….

**state —** REQUESTED/APPROVED/APPLYING/APPLIED/REJECTED/UNKNOWN_EFFECT. Nulabilidad: NO; default físico: 'REQUESTED'. Ejemplo: APPLIED.

**reason_code —** Motivo. Nulabilidad: NO; default físico: —. Ejemplo: EMPLOYEE_REPLACED.

**workflow_ref —** Aprobación. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: wf….

**new_enrollment_ref —** Enrollment nuevo. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: enr2….

**receipt_ref —** Receipt. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: rcpt….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 3.

| **Nombre físico**                                | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|--------------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_participant_substitution                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_participant_substitution_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_participant_substitution_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_participant_substitution_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_participant_substitution                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_delivery_milestone representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                            | **Ejemplo**      |
|---------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------|------------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant.                                    | 8a…              |
| **milestone_id**          | uuid                | NO       | gen_random_uuid() | PK            | ID.                                        | ms…              |
| **engagement_version_id** | uuid                | NO       | —                 | FK            | Versión.                                   | ev…              |
| **milestone_code**        | varchar(64)         | NO       | —                 | UQ            | Código.                                    | MS-01            |
| **title**                 | varchar(180)        | NO       | —                 | —             | Nombre.                                    | Cierre cohorte 1 |
| **due_at**                | timestamptz         | YES      | NULL              | —             | Fecha límite.                              | …                |
| **state**                 | varchar(24)         | NO       | 'PLANNED'         | CHECK         | PLANNED/IN_PROGRESS/DONE/WAIVED/CANCELLED. | DONE             |
| **evidence_ref**          | uuid                | YES      | NULL              | EXT REF CT-05 | Evidencia.                                 | doc…             |
| **completed_at**          | timestamptz         | YES      | NULL              | —             | Cierre.                                    | …                |
| **created_at**            | timestamptz         | NO       | now()             | —             | Creación.                                  | …                |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**milestone_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: ms….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**milestone_code —** Código. Nulabilidad: NO; default físico: —. Ejemplo: MS-01.

**title —** Nombre. Nulabilidad: NO; default físico: —. Ejemplo: Cierre cohorte 1.

**due_at —** Fecha límite. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**state —** PLANNED/IN_PROGRESS/DONE/WAIVED/CANCELLED. Nulabilidad: NO; default físico: 'PLANNED'. Ejemplo: DONE.

**evidence_ref —** Evidencia. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: doc….

**completed_at —** Cierre. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                          | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|--------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_delivery_milestone                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_delivery_milestone_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_delivery_milestone_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_delivery_milestone_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_delivery_milestone_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_delivery_milestone                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_deliverable representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                       | **Ejemplo**        |
|---------------------------|---------------------|----------|-------------------|---------------|-------------------------------------------------------|--------------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant.                                               | 8a…                |
| **deliverable_id**        | uuid                | NO       | gen_random_uuid() | PK            | ID.                                                   | del…               |
| **engagement_version_id** | uuid                | NO       | —                 | FK            | Versión.                                              | ev…                |
| **milestone_id**          | uuid                | YES      | NULL              | FK            | Hito asociado.                                        | ms…                |
| **deliverable_code**      | varchar(64)         | NO       | —                 | UQ            | Código.                                               | DEL-REPORT-01      |
| **title**                 | varchar(180)        | NO       | —                 | —             | Nombre.                                               | Reporte asistencia |
| **state**                 | varchar(24)         | NO       | 'PLANNED'         | CHECK         | PLANNED/READY/SUBMITTED/ACCEPTED/REJECTED/SUPERSEDED. | ACCEPTED           |
| **document_ref**          | uuid                | YES      | NULL              | EXT REF CT-05 | Artefacto.                                            | doc…               |
| **content_hash**          | varchar(128)        | YES      | NULL              | —             | Hash.                                                 | sha256:…           |
| **submitted_at**          | timestamptz         | YES      | NULL              | —             | Entrega.                                              | …                  |
| **accepted_at**           | timestamptz         | YES      | NULL              | —             | Aceptación.                                           | …                  |
| **accepted_by_subject**   | uuid                | YES      | NULL              | EXT REF       | Actor.                                                | usr…               |
| **version**               | bigint              | NO       | 0                 | —             | Revision.                                             | 2                  |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**deliverable_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: del….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**milestone_id —** Hito asociado. Nulabilidad: YES; default físico: NULL. Ejemplo: ms….

**deliverable_code —** Código. Nulabilidad: NO; default físico: —. Ejemplo: DEL-REPORT-01.

**title —** Nombre. Nulabilidad: NO; default físico: —. Ejemplo: Reporte asistencia.

**state —** PLANNED/READY/SUBMITTED/ACCEPTED/REJECTED/SUPERSEDED. Nulabilidad: NO; default físico: 'PLANNED'. Ejemplo: ACCEPTED.

**document_ref —** Artefacto. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: doc….

**content_hash —** Hash. Nulabilidad: YES; default físico: NULL. Se calcula con algoritmo/canonicalization definidos por contrato; no debe depender de serialización accidental. Ejemplo: sha256:….

**submitted_at —** Entrega. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**accepted_at —** Aceptación. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**accepted_by_subject —** Actor. Nulabilidad: YES; default físico: NULL. Ejemplo: usr….

**version —** Revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 2.

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|-------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| **pk_ec09_deliverable**             | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_deliverable_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_deliverable_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_deliverable_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_deliverable_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| **rls_ec09_deliverable**            | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_deliverable_receipt representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**              | **Ejemplo** |
|----------------------------|---------------------|----------|-------------------|---------------|------------------------------|-------------|
| **tenant_id**              | uuid                | NO       | —                 | PK\*          | Tenant.                      | 8a…         |
| **deliverable_receipt_id** | uuid                | NO       | gen_random_uuid() | PK            | ID.                          | dr…         |
| **deliverable_id**         | uuid                | NO       | —                 | FK            | Deliverable.                 | del…        |
| **receipt_type_code**      | varchar(40)         | NO       | —                 | EXT REF       | SUBMITTED/ACCEPTED/REJECTED. | ACCEPTED    |
| **actor_subject**          | uuid                | NO       | —                 | EXT REF       | Actor.                       | usr…        |
| **reason_code**            | varchar(80)         | YES      | NULL              | —             | Motivo.                      | OK          |
| **evidence_ref**           | uuid                | YES      | NULL              | EXT REF CT-05 | Evidencia.                   | doc…        |
| **occurred_at**            | timestamptz         | NO       | now()             | —             | Instante.                    | …           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**deliverable_receipt_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: dr….

**deliverable_id —** Deliverable. Nulabilidad: NO; default físico: —. Ejemplo: del….

**receipt_type_code —** SUBMITTED/ACCEPTED/REJECTED. Nulabilidad: NO; default físico: —. Ejemplo: ACCEPTED.

**actor_subject —** Actor. Nulabilidad: NO; default físico: —. Ejemplo: usr….

**reason_code —** Motivo. Nulabilidad: YES; default físico: NULL. Ejemplo: OK.

**evidence_ref —** Evidencia. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: doc….

**occurred_at —** Instante. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                           | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|---------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_deliverable_receipt                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_deliverable_receipt_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_deliverable_receipt_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_deliverable_receipt_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_deliverable_receipt                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_reporting_profile representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                 | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|---------------|---------------------------------|-------------------|
| **tenant_id**            | uuid                | NO       | —                 | PK\*          | Tenant.                         | 8a…               |
| **reporting_profile_id** | uuid                | NO       | gen_random_uuid() | PK            | ID.                             | rp…               |
| **corporate_client_id**  | uuid                | NO       | —                 | FK            | Cliente.                        | corp…             |
| **profile_code**         | varchar(64)         | NO       | —                 | UQ            | Código.                         | RP-EXEC           |
| **name**                 | varchar(180)        | NO       | —                 | —             | Nombre.                         | Reporte ejecutivo |
| **purpose_ref**          | uuid                | NO       | —                 | EXT REF       | Propósito.                      | pur…              |
| **granularity_code**     | varchar(40)         | NO       | —                 | EXT REF       | AGGREGATE/INDIVIDUAL_LIMITED.   | AGGREGATE         |
| **min_group_size**       | integer             | YES      | NULL              | CHECK         | Threshold privacidad.           | 5                 |
| **retention_policy_ref** | uuid                | YES      | NULL              | EXT REF       | Retención.                      | pol…              |
| **state**                | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/IN_REVIEW/ACTIVE/RETIRED. | ACTIVE            |
| **workflow_ref**         | uuid                | YES      | NULL              | EXT REF CT-06 | Aprobación.                     | wf…               |
| **created_at**           | timestamptz         | NO       | now()             | —             | Creación.                       | …                 |
| **updated_at**           | timestamptz         | NO       | now()             | —             | Actualización.                  | …                 |
| **version**              | bigint              | NO       | 0                 | —             | Revision.                       | 4                 |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**reporting_profile_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: rp….

**corporate_client_id —** Cliente. Nulabilidad: NO; default físico: —. Ejemplo: corp….

**profile_code —** Código. Nulabilidad: NO; default físico: —. Ejemplo: RP-EXEC.

**name —** Nombre. Nulabilidad: NO; default físico: —. Ejemplo: Reporte ejecutivo.

**purpose_ref —** Propósito. Nulabilidad: NO; default físico: —. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pur….

**granularity_code —** AGGREGATE/INDIVIDUAL_LIMITED. Nulabilidad: NO; default físico: —. Ejemplo: AGGREGATE.

**min_group_size —** Threshold privacidad. Nulabilidad: YES; default físico: NULL. Ejemplo: 5.

**retention_policy_ref —** Retención. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol….

**state —** DRAFT/IN_REVIEW/ACTIVE/RETIRED. Nulabilidad: NO; default físico: 'DRAFT'. Ejemplo: ACTIVE.

**workflow_ref —** Aprobación. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: wf….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 4.

| **Nombre físico**                         | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|-------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_reporting_profile                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_reporting_profile_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_reporting_profile_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_reporting_profile_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_reporting_profile_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_reporting_profile                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_reporting_metric_binding representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**           | **Ejemplo**     |
|--------------------------|---------------------|----------|-------------------|-----------|---------------------------|-----------------|
| **tenant_id**            | uuid                | NO       | —                 | PK\*      | Tenant.                   | 8a…             |
| **metric_binding_id**    | uuid                | NO       | gen_random_uuid() | PK        | ID.                       | rmb…            |
| **reporting_profile_id** | uuid                | NO       | —                 | FK        | Perfil.                   | rp…             |
| **metric_code**          | varchar(80)         | NO       | —                 | EXT REF   | Métrica permitida.        | COMPLETION_RATE |
| **source_context_code**  | varchar(24)         | NO       | —                 | CHECK     | EC04/EC06/EC07/EC08/CT11. | EC07            |
| **aggregation_code**     | varchar(40)         | NO       | —                 | EXT REF   | AVG/SUM/RATE/COUNT.       | RATE            |
| **field_level_code**     | varchar(40)         | NO       | 'AGGREGATE'       | EXT REF   | Nivel detalle.            | AGGREGATE       |
| **sequence_no**          | integer             | NO       | 1                 | CHECK     | Orden.                    | 1               |
| **created_at**           | timestamptz         | NO       | now()             | —         | Creación.                 | …               |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**metric_binding_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: rmb….

**reporting_profile_id —** Perfil. Nulabilidad: NO; default físico: —. Ejemplo: rp….

**metric_code —** Métrica permitida. Nulabilidad: NO; default físico: —. Ejemplo: COMPLETION_RATE.

**source_context_code —** EC04/EC06/EC07/EC08/CT11. Nulabilidad: NO; default físico: —. Ejemplo: EC07.

**aggregation_code —** AVG/SUM/RATE/COUNT. Nulabilidad: NO; default físico: —. Ejemplo: RATE.

**field_level_code —** Nivel detalle. Nulabilidad: NO; default físico: 'AGGREGATE'. Ejemplo: AGGREGATE.

**sequence_no —** Orden. Nulabilidad: NO; default físico: 1. Ejemplo: 1.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                                | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|--------------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_reporting_metric_binding                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_reporting_metric_binding_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_reporting_metric_binding_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_reporting_metric_binding_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_reporting_metric_binding                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_reporting_audience representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**          | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|---------------|--------------------------|-------------|
| **tenant_id**            | uuid                | NO       | —                 | PK\*          | Tenant.                  | 8a…         |
| **audience_id**          | uuid                | NO       | gen_random_uuid() | PK            | ID.                      | aud…        |
| **reporting_profile_id** | uuid                | NO       | —                 | FK            | Perfil.                  | rp…         |
| **person_ref**           | uuid                | YES      | NULL              | EXT REF CT-04 | Destinatario individual. | prs…        |
| **role_code**            | varchar(64)         | YES      | NULL              | EXT REF       | Rol permitido.           | SPONSOR     |
| **channel_code**         | varchar(40)         | NO       | 'PORTAL'          | EXT REF       | Portal/email/etc.        | PORTAL      |
| **valid_from**           | timestamptz         | NO       | now()             | —             | Inicio.                  | …           |
| **valid_to**             | timestamptz         | YES      | NULL              | CHECK         | Fin.                     | …           |
| **created_at**           | timestamptz         | NO       | now()             | —             | Creación.                | …           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**audience_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: aud….

**reporting_profile_id —** Perfil. Nulabilidad: NO; default físico: —. Ejemplo: rp….

**person_ref —** Destinatario individual. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: prs….

**role_code —** Rol permitido. Nulabilidad: YES; default físico: NULL. Ejemplo: SPONSOR.

**channel_code —** Portal/email/etc. Nulabilidad: NO; default físico: 'PORTAL'. Ejemplo: PORTAL.

**valid_from —** Inicio. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**valid_to —** Fin. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                          | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|--------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_reporting_audience                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_reporting_audience_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_reporting_audience_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_reporting_audience_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_reporting_audience                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_report_run representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                       | **Ejemplo** |
|---------------------------|---------------------|----------|-------------------|---------------|-------------------------------------------------------|-------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant.                                               | 8a…         |
| **report_run_id**         | uuid                | NO       | gen_random_uuid() | PK            | ID.                                                   | rr…         |
| **engagement_version_id** | uuid                | NO       | —                 | FK            | Versión.                                              | ev…         |
| **reporting_profile_id**  | uuid                | NO       | —                 | FK            | Perfil.                                               | rp…         |
| **as_of**                 | timestamptz         | NO       | —                 | —             | Corte UTC.                                            | …           |
| **state**                 | varchar(24)         | NO       | 'REQUESTED'       | CHECK         | REQUESTED/BUILDING/READY/PUBLISHED/FAILED/SUPERSEDED. | PUBLISHED   |
| **parameters_hash**       | varchar(128)        | NO       | —                 | —             | Hash parámetros.                                      | sha256:…    |
| **dataset_ref**           | uuid                | YES      | NULL              | EXT REF CT-11 | Dataset/provenance.                                   | ds…         |
| **document_ref**          | uuid                | YES      | NULL              | EXT REF CT-05 | Reporte renderizado.                                  | doc…        |
| **content_hash**          | varchar(128)        | YES      | NULL              | —             | Hash final.                                           | sha256:…    |
| supersedes_report_run_id  | uuid                | YES      | NULL              | FK            | Corrección.                                           | rr0…        |
| **published_at**          | timestamptz         | YES      | NULL              | —             | Publicación.                                          | …           |
| **created_at**            | timestamptz         | NO       | now()             | —             | Creación.                                             | …           |
| **version**               | bigint              | NO       | 0                 | —             | Revision.                                             | 2           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**report_run_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: rr….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**reporting_profile_id —** Perfil. Nulabilidad: NO; default físico: —. Ejemplo: rp….

**as_of —** Corte UTC. Nulabilidad: NO; default físico: —. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**state —** REQUESTED/BUILDING/READY/PUBLISHED/FAILED/SUPERSEDED. Nulabilidad: NO; default físico: 'REQUESTED'. Ejemplo: PUBLISHED.

**parameters_hash —** Hash parámetros. Nulabilidad: NO; default físico: —. Se calcula con algoritmo/canonicalization definidos por contrato; no debe depender de serialización accidental. Ejemplo: sha256:….

**dataset_ref —** Dataset/provenance. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ds….

**document_ref —** Reporte renderizado. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: doc….

**content_hash —** Hash final. Nulabilidad: YES; default físico: NULL. Se calcula con algoritmo/canonicalization definidos por contrato; no debe depender de serialización accidental. Ejemplo: sha256:….

**supersedes_report_run_id —** Corrección. Nulabilidad: YES; default físico: NULL. Ejemplo: rr0….

**published_at —** Publicación. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 2.

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| **pk_ec09_report_run**             | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_report_run_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_report_run_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_report_run_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| **rls_ec09_report_run**            | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_report_delivery_receipt representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                               | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|-----------|-----------------------------------------------|-------------|
| **tenant_id**            | uuid                | NO       | —                 | PK\*      | Tenant.                                       | 8a…         |
| **delivery_receipt_id**  | uuid                | NO       | gen_random_uuid() | PK        | ID.                                           | rdr…        |
| **report_run_id**        | uuid                | NO       | —                 | FK        | Reporte.                                      | rr…         |
| **audience_id**          | uuid                | NO       | —                 | FK        | Audience.                                     | aud…        |
| **channel_code**         | varchar(40)         | NO       | —                 | EXT REF   | Canal.                                        | PORTAL      |
| **recipient_ref**        | uuid                | YES      | NULL              | EXT REF   | Destinatario.                                 | prs…        |
| **status**               | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/SENT/DELIVERED/FAILED/UNKNOWN_EFFECT. | DELIVERED   |
| **external_receipt_ref** | varchar(160)        | YES      | NULL              | —         | Receipt proveedor.                            | msg-…       |
| **delivered_at**         | timestamptz         | YES      | NULL              | —         | Entrega.                                      | …           |
| **created_at**           | timestamptz         | NO       | now()             | —         | Creación.                                     | …           |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**delivery_receipt_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: rdr….

**report_run_id —** Reporte. Nulabilidad: NO; default físico: —. Ejemplo: rr….

**audience_id —** Audience. Nulabilidad: NO; default físico: —. Ejemplo: aud….

**channel_code —** Canal. Nulabilidad: NO; default físico: —. Ejemplo: PORTAL.

**recipient_ref —** Destinatario. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: prs….

**status —** PENDING/SENT/DELIVERED/FAILED/UNKNOWN_EFFECT. Nulabilidad: NO; default físico: 'PENDING'. Ejemplo: DELIVERED.

**external_receipt_ref —** Receipt proveedor. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: msg-….

**delivered_at —** Entrega. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                               | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|-------------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_report_delivery_receipt                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| fk_ec09_report_delivery_receipt_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_report_delivery_receipt_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_report_delivery_receipt_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_report_delivery_receipt                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_financial_intent representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                            | **Ejemplo**     |
|---------------------------|---------------------|----------|-------------------|------------------|------------------------------------------------------------|-----------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*             | Tenant.                                                    | 8a…             |
| **financial_intent_id**   | uuid                | NO       | gen_random_uuid() | PK               | ID.                                                        | fi…             |
| **engagement_version_id** | uuid                | NO       | —                 | FK               | Versión.                                                   | ev…             |
| **intent_type_code**      | varchar(64)         | NO       | —                 | EXT REF          | Tipo intent.                                               | INVOICE_REQUEST |
| **idempotency_key**       | varchar(128)        | NO       | —                 | UQ               | Key remota.                                                | fin:…           |
| **state**                 | varchar(24)         | NO       | 'CREATED'         | CHECK            | CREATED/SENT/CONFIRMED/REJECTED/UNKNOWN_EFFECT/RECONCILED. | CONFIRMED       |
| **financial_ref**         | uuid                | YES      | NULL              | EXT REF Finanzas | Hecho externo.                                             | inv…            |
| **external_receipt_ref**  | varchar(160)        | YES      | NULL              | —                | Receipt.                                                   | rcpt…           |
| **reason_code**           | varchar(80)         | YES      | NULL              | —                | Motivo.                                                    | OK              |
| **created_at**            | timestamptz         | NO       | now()             | —                | Creación.                                                  | …               |
| **updated_at**            | timestamptz         | NO       | now()             | —                | Actualización.                                             | …               |
| **version**               | bigint              | NO       | 0                 | —                | Revision.                                                  | 3               |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**financial_intent_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: fi….

**engagement_version_id —** Versión. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**intent_type_code —** Tipo intent. Nulabilidad: NO; default físico: —. Ejemplo: INVOICE_REQUEST.

**idempotency_key —** Key remota. Nulabilidad: NO; default físico: —. Ejemplo: fin:….

**state —** CREATED/SENT/CONFIRMED/REJECTED/UNKNOWN_EFFECT/RECONCILED. Nulabilidad: NO; default físico: 'CREATED'. Ejemplo: CONFIRMED.

**financial_ref —** Hecho externo. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: inv….

**external_receipt_ref —** Receipt. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: rcpt….

**reason_code —** Motivo. Nulabilidad: YES; default físico: NULL. Ejemplo: OK.

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 3.

| **Nombre físico**                        | **Tipo** | **Definición/expresión**                                      | **Error que impide**                                    |
|------------------------------------------|----------|---------------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_financial_intent                 | PK       | Clave primaria tenant-aware/identidad de fila.                | Duplicidad o identidad ambigua.                         |
| uq_ec09_financial_intent_business        | UQ/INDEX | Business keys únicas dentro del scope indicado.               | Duplicados funcionales.                                 |
| fk_ec09_financial_intent_internal        | FK       | FKs internas incluyen tenant_id y scope/parent key requerido. | Cruces lógicos entre aggregates/tenants.                |
| ck_ec09_financial_intent_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables.     | Estados o valores físicamente imposibles.               |
| ix_ec09_financial_intent_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.                | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_financial_intent                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.         | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_reconciliation_case representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                        | **Ejemplo**    |
|----------------------------|---------------------|----------|-------------------|---------------|----------------------------------------|----------------|
| **tenant_id**              | uuid                | NO       | —                 | PK\*          | Tenant.                                | 8a…            |
| **reconciliation_case_id** | uuid                | NO       | gen_random_uuid() | PK            | ID.                                    | rec…           |
| **case_type_code**         | varchar(64)         | NO       | —                 | EXT REF       | FINANCIAL/ENROLLMENT/DELIVERY.         | FINANCIAL      |
| **aggregate_ref**          | uuid                | NO       | —                 | —             | Aggregate local afectado.              | fi…            |
| **state**                  | varchar(24)         | NO       | 'OPEN'            | CHECK         | OPEN/INVESTIGATING/RESOLVED/ESCALATED. | RESOLVED       |
| **resolution_code**        | varchar(80)         | YES      | NULL              | —             | Resultado.                             | REMOTE_APPLIED |
| **evidence_ref**           | uuid                | YES      | NULL              | EXT REF CT-05 | Evidencia.                             | doc…           |
| **opened_at**              | timestamptz         | NO       | now()             | —             | Inicio.                                | …              |
| **resolved_at**            | timestamptz         | YES      | NULL              | —             | Fin.                                   | …              |
| **version**                | bigint              | NO       | 0                 | —             | Revision.                              | 2              |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**reconciliation_case_id —** ID. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: rec….

**case_type_code —** FINANCIAL/ENROLLMENT/DELIVERY. Nulabilidad: NO; default físico: —. Ejemplo: FINANCIAL.

**aggregate_ref —** Aggregate local afectado. Nulabilidad: NO; default físico: —. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: fi….

**state —** OPEN/INVESTIGATING/RESOLVED/ESCALATED. Nulabilidad: NO; default físico: 'OPEN'. Ejemplo: RESOLVED.

**resolution_code —** Resultado. Nulabilidad: YES; default físico: NULL. Ejemplo: REMOTE_APPLIED.

**evidence_ref —** Evidencia. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: doc….

**opened_at —** Inicio. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**resolved_at —** Fin. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 2.

| **Nombre físico**                           | **Tipo** | **Definición/expresión**                                  | **Error que impide**                                    |
|---------------------------------------------|----------|-----------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_reconciliation_case                 | PK       | Clave primaria tenant-aware/identidad de fila.            | Duplicidad o identidad ambigua.                         |
| ck_ec09_reconciliation_case_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables. | Estados o valores físicamente imposibles.               |
| ix_ec09_reconciliation_case_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.            | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_reconciliation_case                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.     | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_idempotency_record representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**   | **PK/FK** | **Descripción**               | **Ejemplo**         |
|---------------------|---------------------|----------|---------------|-----------|-------------------------------|---------------------|
| **tenant_id**       | uuid                | NO       | —             | PK\*      | Tenant.                       | 8a…                 |
| **idempotency_key** | varchar(160)        | NO       | —             | PK\*      | Clave.                        | …                   |
| **operation_code**  | varchar(80)         | NO       | —             | —         | Operación.                    | ACTIVATE_ENGAGEMENT |
| **request_hash**    | varchar(128)        | NO       | —             | —         | Hash payload.                 | sha256:…            |
| **state**           | varchar(24)         | NO       | 'IN_PROGRESS' | CHECK     | IN_PROGRESS/SUCCEEDED/FAILED. | SUCCEEDED           |
| **owner_id**        | varchar(120)        | YES      | NULL          | —         | Owner lease.                  | pod-1               |
| **lease_until**     | timestamptz         | YES      | NULL          | —         | Lease.                        | …                   |
| **response_code**   | integer             | YES      | NULL          | —         | HTTP code.                    | 200                 |
| **response_ref**    | uuid                | YES      | NULL          | —         | Resultado.                    | …                   |
| **created_at**      | timestamptz         | NO       | now()         | —         | Creación.                     | …                   |
| **updated_at**      | timestamptz         | NO       | now()         | —         | Actualización.                | …                   |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**idempotency_key —** Clave. Nulabilidad: NO; default físico: —. Ejemplo: ….

**operation_code —** Operación. Nulabilidad: NO; default físico: —. Ejemplo: ACTIVATE_ENGAGEMENT.

**request_hash —** Hash payload. Nulabilidad: NO; default físico: —. Se calcula con algoritmo/canonicalization definidos por contrato; no debe depender de serialización accidental. Ejemplo: sha256:….

**state —** IN_PROGRESS/SUCCEEDED/FAILED. Nulabilidad: NO; default físico: 'IN_PROGRESS'. Ejemplo: SUCCEEDED.

**owner_id —** Owner lease. Nulabilidad: YES; default físico: NULL. Ejemplo: pod-1.

**lease_until —** Lease. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**response_code —** HTTP code. Nulabilidad: YES; default físico: NULL. Ejemplo: 200.

**response_ref —** Resultado. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                          | **Tipo** | **Definición/expresión**                                  | **Error que impide**                                    |
|--------------------------------------------|----------|-----------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_idempotency_record                 | PK       | Clave primaria tenant-aware/identidad de fila.            | Duplicidad o identidad ambigua.                         |
| ck_ec09_idempotency_record_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables. | Estados o valores físicamente imposibles.               |
| ix_ec09_idempotency_record_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.            | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_idempotency_record                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.     | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_outbox_event representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                     | **Ejemplo**         |
|--------------------|---------------------|----------|-------------------|-----------|-------------------------------------|---------------------|
| **tenant_id**      | uuid                | NO       | —                 | PK\*      | Tenant.                             | 8a…                 |
| **event_id**       | uuid                | NO       | gen_random_uuid() | PK        | ID evento.                          | evt…                |
| **aggregate_type** | varchar(80)         | NO       | —                 | —         | Tipo.                               | EngagementVersion   |
| **aggregate_id**   | uuid                | NO       | —                 | —         | Aggregate.                          | ev…                 |
| **event_type**     | varchar(120)        | NO       | —                 | —         | Tipo evento.                        | EngagementActivated |
| **schema_version** | integer             | NO       | 1                 | CHECK     | Versión contrato.                   | 1                   |
| **correlation_id** | uuid                | NO       | —                 | —         | Correlación.                        | corr…               |
| **causation_id**   | uuid                | YES      | NULL              | —         | Causación.                          | cmd…                |
| **payload**        | jsonb               | NO       | '{}'::jsonb       | —         | Payload.                            | {}                  |
| **status**         | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/PUBLISHED/FAILED. | PENDING             |
| **owner_id**       | varchar(120)        | YES      | NULL              | —         | Owner.                              | worker-1            |
| **lease_until**    | timestamptz         | YES      | NULL              | —         | Lease.                              | …                   |
| **occurred_at**    | timestamptz         | NO       | now()             | —         | Hecho.                              | …                   |
| **published_at**   | timestamptz         | YES      | NULL              | —         | Publicado.                          | …                   |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**event_id —** ID evento. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: evt….

**aggregate_type —** Tipo. Nulabilidad: NO; default físico: —. Ejemplo: EngagementVersion.

**aggregate_id —** Aggregate. Nulabilidad: NO; default físico: —. Ejemplo: ev….

**event_type —** Tipo evento. Nulabilidad: NO; default físico: —. Ejemplo: EngagementActivated.

**schema_version —** Versión contrato. Nulabilidad: NO; default físico: 1. Ejemplo: 1.

**correlation_id —** Correlación. Nulabilidad: NO; default físico: —. Ejemplo: corr….

**causation_id —** Causación. Nulabilidad: YES; default físico: NULL. Ejemplo: cmd….

**payload —** Payload. Nulabilidad: NO; default físico: '{}'::jsonb. Ejemplo: {}.

**status —** PENDING/IN_FLIGHT/PUBLISHED/FAILED. Nulabilidad: NO; default físico: 'PENDING'. Ejemplo: PENDING.

**owner_id —** Owner. Nulabilidad: YES; default físico: NULL. Ejemplo: worker-1.

**lease_until —** Lease. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**occurred_at —** Hecho. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**published_at —** Publicado. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                  | **Error que impide**                                    |
|--------------------------------------|----------|-----------------------------------------------------------|---------------------------------------------------------|
| **pk_ec09_outbox_event**             | PK       | Clave primaria tenant-aware/identidad de fila.            | Duplicidad o identidad ambigua.                         |
| ck_ec09_outbox_event_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables. | Estados o valores físicamente imposibles.               |
| ix_ec09_outbox_event_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.            | Full scans evitables y consultas sin soporte de acceso. |
| **rls_ec09_outbox_event**            | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.     | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_inbox_message representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**            | **Ejemplo**         |
|--------------------|---------------------|----------|-------------|-----------|----------------------------|---------------------|
| **tenant_id**      | uuid                | NO       | —           | PK\*      | Tenant.                    | 8a…                 |
| **message_id**     | uuid                | NO       | —           | PK\*      | Message id.                | msg…                |
| **consumer_code**  | varchar(80)         | NO       | —           | PK\*      | Consumidor.                | EC09                |
| **message_type**   | varchar(120)        | NO       | —           | —         | Tipo.                      | EnrollmentConfirmed |
| **schema_version** | integer             | NO       | 1           | CHECK     | Versión.                   | 1                   |
| **correlation_id** | uuid                | YES      | NULL        | —         | Correlación.               | corr…               |
| **payload_hash**   | varchar(128)        | NO       | —           | —         | Hash.                      | sha256:…            |
| **processed_at**   | timestamptz         | YES      | NULL        | —         | Procesado.                 | …                   |
| **status**         | varchar(24)         | NO       | 'RECEIVED'  | CHECK     | RECEIVED/PROCESSED/FAILED. | PROCESSED           |
| **created_at**     | timestamptz         | NO       | now()       | —         | Ingreso.                   | …                   |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**message_id —** Message id. Nulabilidad: NO; default físico: —. Ejemplo: msg….

**consumer_code —** Consumidor. Nulabilidad: NO; default físico: —. Ejemplo: EC09.

**message_type —** Tipo. Nulabilidad: NO; default físico: —. Ejemplo: EnrollmentConfirmed.

**schema_version —** Versión. Nulabilidad: NO; default físico: 1. Ejemplo: 1.

**correlation_id —** Correlación. Nulabilidad: YES; default físico: NULL. Ejemplo: corr….

**payload_hash —** Hash. Nulabilidad: NO; default físico: —. Se calcula con algoritmo/canonicalization definidos por contrato; no debe depender de serialización accidental. Ejemplo: sha256:….

**processed_at —** Procesado. Nulabilidad: YES; default físico: NULL. Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**status —** RECEIVED/PROCESSED/FAILED. Nulabilidad: NO; default físico: 'RECEIVED'. Ejemplo: PROCESSED.

**created_at —** Ingreso. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

| **Nombre físico**                     | **Tipo** | **Definición/expresión**                                  | **Error que impide**                                    |
|---------------------------------------|----------|-----------------------------------------------------------|---------------------------------------------------------|
| **pk_ec09_inbox_message**             | PK       | Clave primaria tenant-aware/identidad de fila.            | Duplicidad o identidad ambigua.                         |
| ck_ec09_inbox_message_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables. | Estados o valores físicamente imposibles.               |
| ix_ec09_inbox_message_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.            | Full scans evitables y consultas sin soporte de acceso. |
| **rls_ec09_inbox_message**            | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.     | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

## 

QUÉ REPRESENTA — ec09_operation_status representa una pieza específica del bounded context corporativo. Su existencia está justificada por la necesidad de mantener identidad, lifecycle, evidencia y reconstrucción histórica sin apropiarse de hechos que pertenecen a otros contextos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La capa Application la crea o modifica únicamente mediante casos de uso autorizados. Las referencias internas usan FKs tenant-aware; las referencias externas son EXT REF validadas por ports/contracts. Cuando forma parte de un aggregate, cualquier cambio relevante incrementa la revisión observable del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege invariantes locales, aislamiento por tenant, trazabilidad y semántica del expediente corporativo. No debe interpretarse como copia de persona, matrícula, pago, certificado, documento binario o programación académica cuando esas verdades pertenecen a otros bounded contexts.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                           | **Ejemplo**     |
|--------------------|---------------------|----------|-------------------|-----------|-----------------------------------------------------------|-----------------|
| **tenant_id**      | uuid                | NO       | —                 | PK\*      | Tenant.                                                   | 8a…             |
| **operation_id**   | uuid                | NO       | gen_random_uuid() | PK        | ID operación.                                             | op…             |
| **operation_type** | varchar(80)         | NO       | —                 | —         | Tipo.                                                     | BULK_ENROLLMENT |
| **aggregate_ref**  | uuid                | YES      | NULL              | —         | Aggregate relacionado.                                    | eb…             |
| **state**          | varchar(24)         | NO       | 'ACCEPTED'        | CHECK     | ACCEPTED/RUNNING/SUCCEEDED/FAILED/PARTIAL/UNKNOWN_EFFECT. | RUNNING         |
| **progress_pct**   | numeric(5,2)        | YES      | NULL              | CHECK     | 0..100.                                                   | 72.50           |
| **reason_code**    | varchar(80)         | YES      | NULL              | —         | Motivo.                                                   | —               |
| **result_ref**     | uuid                | YES      | NULL              | —         | Resultado.                                                | …               |
| **created_at**     | timestamptz         | NO       | now()             | —         | Creación.                                                 | …               |
| **updated_at**     | timestamptz         | NO       | now()             | —         | Actualización.                                            | …               |
| **version**        | bigint              | NO       | 0                 | —         | Revision.                                                 | 2               |

### 

**tenant_id —** Tenant. Nulabilidad: NO; default físico: —. Proviene del Security/TenantContext autorizado; nunca de un body libre y participa en RLS. Ejemplo: 8a….

**operation_id —** ID operación. Nulabilidad: NO; default físico: gen_random_uuid(). Ejemplo: op….

**operation_type —** Tipo. Nulabilidad: NO; default físico: —. Ejemplo: BULK_ENROLLMENT.

**aggregate_ref —** Aggregate relacionado. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: eb….

**state —** ACCEPTED/RUNNING/SUCCEEDED/FAILED/PARTIAL/UNKNOWN_EFFECT. Nulabilidad: NO; default físico: 'ACCEPTED'. Ejemplo: RUNNING.

**progress_pct —** 0..100. Nulabilidad: YES; default físico: NULL. Ejemplo: 72.50.

**reason_code —** Motivo. Nulabilidad: YES; default físico: NULL. Ejemplo: —.

**result_ref —** Resultado. Nulabilidad: YES; default físico: NULL. Es referencia cross-context o externa; se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ….

**created_at —** Creación. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**updated_at —** Actualización. Nulabilidad: NO; default físico: now(). Se persiste en UTC y se presenta en timezone institucional/usuario. Ejemplo: ….

**version —** Revision. Nulabilidad: NO; default físico: 0. Se mapea con @Version; conflicto produce 412 PRECONDITION_FAILED mediante ETag/If-Match. Ejemplo: 2.

| **Nombre físico**                        | **Tipo** | **Definición/expresión**                                  | **Error que impide**                                    |
|------------------------------------------|----------|-----------------------------------------------------------|---------------------------------------------------------|
| pk_ec09_operation_status                 | PK       | Clave primaria tenant-aware/identidad de fila.            | Duplicidad o identidad ambigua.                         |
| ck_ec09_operation_status_state_or_domain | CHECK    | Dominio/positividad/coherencia según columnas aplicables. | Estados o valores físicamente imposibles.               |
| ix_ec09_operation_status_tenant          | INDEX    | tenant_id + claves de consulta más frecuentes.            | Full scans evitables y consultas sin soporte de acceso. |
| rls_ec09_operation_status                | RLS      | ENABLE ROW LEVEL SECURITY + FORCE ROW LEVEL SECURITY.     | Lectura/escritura cross-tenant ante bug de repository.  |

¿QUÉ DEBE IMPEDIR POSTGRESQL? — Duplicados de identidad/business key, cruces de tenant, valores fuera de dominio, referencias internas inválidas y mutaciones incompatibles con la inmutabilidad/lifecycle del aggregate, incluso si Backend omite una validación.

# 

Baseline recomendado: V090\_\_ec09_schema.sql para creación inicial y migraciones posteriores expand/contract. En producción se separan roles de migración, runtime HTTP y workers. El siguiente DDL es implementable y debe acompañarse de tests de constraints/RLS.

```
CREATE SCHEMA IF NOT EXISTS ec09;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Runtime role must NOT own objects and must NOT have BYPASSRLS.
-- SET LOCAL peopleu.tenant_id = '<tenant-uuid>' must be executed inside each transaction.
```

```
CREATE TABLE ec09.ec09_corporate_client_account (
tenant_id uuid NOT NULL,
corporate_client_id uuid DEFAULT gen_random_uuid() NOT NULL,
corporate_client_code varchar(64) NOT NULL,
external_org_ref uuid DEFAULT NULL,
legal_name_snapshot varchar(240) NOT NULL,
lifecycle_state varchar(24) DEFAULT 'DRAFT' NOT NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_corporate_client_account PRIMARY KEY (tenant_id, corporate_client_id)
);
ALTER TABLE ec09.ec09_corporate_client_account ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_corporate_client_account FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_corporate_client_account_tenant ON ec09.ec09_corporate_client_account USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_corporate_client_account_corporate_client_code ON ec09.ec09_corporate_client_account(tenant_id, corporate_client_code);
```

```
CREATE TABLE ec09.ec09_corporate_contact_ref (
tenant_id uuid NOT NULL,
contact_ref_id uuid DEFAULT gen_random_uuid() NOT NULL,
corporate_client_id uuid NOT NULL,
person_ref uuid NOT NULL,
contact_role_code varchar(64) NOT NULL,
valid_from date DEFAULT CURRENT_DATE NOT NULL,
valid_to date DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_corporate_contact_ref PRIMARY KEY (tenant_id, contact_ref_id)
);
ALTER TABLE ec09.ec09_corporate_contact_ref ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_corporate_contact_ref FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_corporate_contact_ref_tenant ON ec09.ec09_corporate_contact_ref USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_training_need_assessment (
tenant_id uuid NOT NULL,
tna_id uuid DEFAULT gen_random_uuid() NOT NULL,
corporate_client_id uuid NOT NULL,
tna_code varchar(64) NOT NULL,
title varchar(240) NOT NULL,
state varchar(24) DEFAULT 'DRAFT' NOT NULL,
purpose_ref uuid DEFAULT NULL,
confidentiality_code varchar(40) DEFAULT 'INTERNAL' NOT NULL,
workflow_ref uuid DEFAULT NULL,
approved_at timestamptz DEFAULT NULL,
approved_by_subject uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_training_need_assessment PRIMARY KEY (tenant_id, tna_id)
);
ALTER TABLE ec09.ec09_training_need_assessment ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_training_need_assessment FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_training_need_assessment_tenant ON ec09.ec09_training_need_assessment USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_training_need_assessment_tna_code ON ec09.ec09_training_need_assessment(tenant_id, tna_code);
```

```
CREATE TABLE ec09.ec09_tna_requirement (
tenant_id uuid NOT NULL,
tna_requirement_id uuid DEFAULT gen_random_uuid() NOT NULL,
tna_id uuid NOT NULL,
requirement_code varchar(64) NOT NULL,
requirement_type_code varchar(64) NOT NULL,
statement text NOT NULL,
priority_code varchar(32) DEFAULT 'MEDIUM' NOT NULL,
sequence_no integer DEFAULT 1 NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_tna_requirement PRIMARY KEY (tenant_id, tna_requirement_id)
);
ALTER TABLE ec09.ec09_tna_requirement ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_tna_requirement FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_tna_requirement_tenant ON ec09.ec09_tna_requirement USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_tna_requirement_requirement_code ON ec09.ec09_tna_requirement(tenant_id, requirement_code);
```

```
CREATE TABLE ec09.ec09_engagement (
tenant_id uuid NOT NULL,
engagement_id uuid DEFAULT gen_random_uuid() NOT NULL,
corporate_client_id uuid NOT NULL,
engagement_code varchar(64) NOT NULL,
title varchar(240) NOT NULL,
lifecycle_state varchar(24) DEFAULT 'DRAFT' NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_engagement PRIMARY KEY (tenant_id, engagement_id)
);
ALTER TABLE ec09.ec09_engagement ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_engagement FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_engagement_tenant ON ec09.ec09_engagement USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_engagement_engagement_code ON ec09.ec09_engagement(tenant_id, engagement_code);
```

```
CREATE TABLE ec09.ec09_engagement_version (
tenant_id uuid NOT NULL,
engagement_version_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_id uuid NOT NULL,
version_no integer NOT NULL,
previous_version_id uuid DEFAULT NULL,
state varchar(24) DEFAULT 'DRAFT' NOT NULL,
tna_ref uuid DEFAULT NULL,
commercial_agreement_ref uuid DEFAULT NULL,
scope_summary text NOT NULL,
valid_from date DEFAULT NULL,
valid_to date DEFAULT NULL,
reporting_profile_id uuid DEFAULT NULL,
content_hash varchar(128) DEFAULT NULL,
activated_at timestamptz DEFAULT NULL,
activated_by_subject uuid DEFAULT NULL,
superseded_by_version_id uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_engagement_version PRIMARY KEY (tenant_id, engagement_version_id)
);
ALTER TABLE ec09.ec09_engagement_version ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_engagement_version FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_engagement_version_tenant ON ec09.ec09_engagement_version USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_engagement_version_version_no ON ec09.ec09_engagement_version(tenant_id, version_no);
```

```
CREATE TABLE ec09.ec09_engagement_program_binding (
tenant_id uuid NOT NULL,
binding_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
program_version_ref uuid NOT NULL,
program_edition_ref uuid DEFAULT NULL,
offering_ref uuid DEFAULT NULL,
binding_role_code varchar(40) DEFAULT 'PRIMARY' NOT NULL,
sequence_no integer DEFAULT 1 NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_engagement_program_binding PRIMARY KEY (tenant_id, binding_id)
);
ALTER TABLE ec09.ec09_engagement_program_binding ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_engagement_program_binding FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_engagement_program_binding_tenant ON ec09.ec09_engagement_program_binding USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_engagement_scope_item (
tenant_id uuid NOT NULL,
scope_item_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
scope_code varchar(64) NOT NULL,
description text NOT NULL,
quantity numeric(12,2) DEFAULT NULL,
unit_code varchar(40) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_engagement_scope_item PRIMARY KEY (tenant_id, scope_item_id)
);
ALTER TABLE ec09.ec09_engagement_scope_item ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_engagement_scope_item FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_engagement_scope_item_tenant ON ec09.ec09_engagement_scope_item USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_engagement_scope_item_scope_code ON ec09.ec09_engagement_scope_item(tenant_id, scope_code);
```

```
CREATE TABLE ec09.ec09_service_level_commitment (
tenant_id uuid NOT NULL,
commitment_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
commitment_code varchar(64) NOT NULL,
metric_code varchar(80) NOT NULL,
target_value numeric(14,4) DEFAULT NULL,
target_unit_code varchar(40) DEFAULT NULL,
policy_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_service_level_commitment PRIMARY KEY (tenant_id, commitment_id)
);
ALTER TABLE ec09.ec09_service_level_commitment ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_service_level_commitment FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_service_level_commitment_tenant ON ec09.ec09_service_level_commitment USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_service_level_commitment_commitment_code ON ec09.ec09_service_level_commitment(tenant_id, commitment_code);
```

```
CREATE TABLE ec09.ec09_commercial_agreement_binding (
tenant_id uuid NOT NULL,
agreement_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
agreement_ref uuid NOT NULL,
agreement_version_ref uuid DEFAULT NULL,
document_ref uuid DEFAULT NULL,
effective_from date DEFAULT NULL,
effective_to date DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_commercial_agreement_binding PRIMARY KEY (tenant_id, agreement_binding_id)
);
ALTER TABLE ec09.ec09_commercial_agreement_binding ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_commercial_agreement_binding FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_commercial_agreement_binding_tenant ON ec09.ec09_commercial_agreement_binding USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_corporate_seat_pool (
tenant_id uuid NOT NULL,
seat_pool_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
program_binding_id uuid NOT NULL,
pool_code varchar(64) NOT NULL,
allocated_seats integer NOT NULL,
reserved_seats integer DEFAULT 0 NOT NULL,
consumed_seats integer DEFAULT 0 NOT NULL,
waitlist_allowed boolean DEFAULT false NOT NULL,
policy_ref uuid DEFAULT NULL,
version bigint DEFAULT 0 NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_corporate_seat_pool PRIMARY KEY (tenant_id, seat_pool_id)
);
ALTER TABLE ec09.ec09_corporate_seat_pool ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_corporate_seat_pool FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_corporate_seat_pool_tenant ON ec09.ec09_corporate_seat_pool USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_corporate_seat_pool_pool_code ON ec09.ec09_corporate_seat_pool(tenant_id, pool_code);
```

```
CREATE TABLE ec09.ec09_nomination_batch (
tenant_id uuid NOT NULL,
nomination_batch_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
seat_pool_id uuid NOT NULL,
batch_code varchar(64) NOT NULL,
source_document_ref uuid DEFAULT NULL,
source_hash varchar(128) NOT NULL,
state varchar(24) DEFAULT 'DRAFT' NOT NULL,
total_items integer DEFAULT 0 NOT NULL,
valid_items integer DEFAULT 0 NOT NULL,
failed_items integer DEFAULT 0 NOT NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_nomination_batch PRIMARY KEY (tenant_id, nomination_batch_id)
);
ALTER TABLE ec09.ec09_nomination_batch ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_nomination_batch FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_nomination_batch_tenant ON ec09.ec09_nomination_batch USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_nomination_batch_batch_code ON ec09.ec09_nomination_batch(tenant_id, batch_code);
CREATE UNIQUE INDEX uq_ec09_nomination_batch_source_hash ON ec09.ec09_nomination_batch(tenant_id, source_hash);
```

```
CREATE TABLE ec09.ec09_nomination_item (
tenant_id uuid NOT NULL,
nomination_item_id uuid DEFAULT gen_random_uuid() NOT NULL,
nomination_batch_id uuid NOT NULL,
source_key varchar(128) NOT NULL,
person_ref uuid DEFAULT NULL,
identity_hint_hash varchar(128) DEFAULT NULL,
status varchar(24) DEFAULT 'PENDING' NOT NULL,
reason_code varchar(80) DEFAULT NULL,
enrollment_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_nomination_item PRIMARY KEY (tenant_id, nomination_item_id)
);
ALTER TABLE ec09.ec09_nomination_item ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_nomination_item FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_nomination_item_tenant ON ec09.ec09_nomination_item USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_nomination_item_source_key ON ec09.ec09_nomination_item(tenant_id, source_key);
```

```
CREATE TABLE ec09.ec09_enrollment_batch (
tenant_id uuid NOT NULL,
enrollment_batch_id uuid DEFAULT gen_random_uuid() NOT NULL,
nomination_batch_id uuid NOT NULL,
state varchar(24) DEFAULT 'PENDING' NOT NULL,
operation_id uuid DEFAULT NULL,
total_items integer DEFAULT 0 NOT NULL,
success_items integer DEFAULT 0 NOT NULL,
failed_items integer DEFAULT 0 NOT NULL,
unknown_items integer DEFAULT 0 NOT NULL,
started_at timestamptz DEFAULT NULL,
completed_at timestamptz DEFAULT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_enrollment_batch PRIMARY KEY (tenant_id, enrollment_batch_id)
);
ALTER TABLE ec09.ec09_enrollment_batch ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_enrollment_batch FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_enrollment_batch_tenant ON ec09.ec09_enrollment_batch USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_enrollment_batch_item (
tenant_id uuid NOT NULL,
enrollment_batch_item_id uuid DEFAULT gen_random_uuid() NOT NULL,
enrollment_batch_id uuid NOT NULL,
nomination_item_id uuid NOT NULL,
idempotency_key varchar(128) NOT NULL,
status varchar(24) DEFAULT 'PENDING' NOT NULL,
enrollment_ref uuid DEFAULT NULL,
receipt_ref uuid DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
attempt_count integer DEFAULT 0 NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_enrollment_batch_item PRIMARY KEY (tenant_id, enrollment_batch_item_id)
);
ALTER TABLE ec09.ec09_enrollment_batch_item ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_enrollment_batch_item FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_enrollment_batch_item_tenant ON ec09.ec09_enrollment_batch_item USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_enrollment_batch_item_idempotency_key ON ec09.ec09_enrollment_batch_item(tenant_id, idempotency_key);
```

```
CREATE TABLE ec09.ec09_participant_substitution (
tenant_id uuid NOT NULL,
substitution_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
seat_pool_id uuid NOT NULL,
old_enrollment_ref uuid NOT NULL,
new_person_ref uuid NOT NULL,
state varchar(24) DEFAULT 'REQUESTED' NOT NULL,
reason_code varchar(80) NOT NULL,
workflow_ref uuid DEFAULT NULL,
new_enrollment_ref uuid DEFAULT NULL,
receipt_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_participant_substitution PRIMARY KEY (tenant_id, substitution_id)
);
ALTER TABLE ec09.ec09_participant_substitution ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_participant_substitution FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_participant_substitution_tenant ON ec09.ec09_participant_substitution USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_delivery_milestone (
tenant_id uuid NOT NULL,
milestone_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
milestone_code varchar(64) NOT NULL,
title varchar(180) NOT NULL,
due_at timestamptz DEFAULT NULL,
state varchar(24) DEFAULT 'PLANNED' NOT NULL,
evidence_ref uuid DEFAULT NULL,
completed_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_delivery_milestone PRIMARY KEY (tenant_id, milestone_id)
);
ALTER TABLE ec09.ec09_delivery_milestone ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_delivery_milestone FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_delivery_milestone_tenant ON ec09.ec09_delivery_milestone USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_delivery_milestone_milestone_code ON ec09.ec09_delivery_milestone(tenant_id, milestone_code);
```

```
CREATE TABLE ec09.ec09_deliverable (
tenant_id uuid NOT NULL,
deliverable_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
milestone_id uuid DEFAULT NULL,
deliverable_code varchar(64) NOT NULL,
title varchar(180) NOT NULL,
state varchar(24) DEFAULT 'PLANNED' NOT NULL,
document_ref uuid DEFAULT NULL,
content_hash varchar(128) DEFAULT NULL,
submitted_at timestamptz DEFAULT NULL,
accepted_at timestamptz DEFAULT NULL,
accepted_by_subject uuid DEFAULT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_deliverable PRIMARY KEY (tenant_id, deliverable_id)
);
ALTER TABLE ec09.ec09_deliverable ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_deliverable FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_deliverable_tenant ON ec09.ec09_deliverable USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_deliverable_deliverable_code ON ec09.ec09_deliverable(tenant_id, deliverable_code);
```

```
CREATE TABLE ec09.ec09_deliverable_receipt (
tenant_id uuid NOT NULL,
deliverable_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,
deliverable_id uuid NOT NULL,
receipt_type_code varchar(40) NOT NULL,
actor_subject uuid NOT NULL,
reason_code varchar(80) DEFAULT NULL,
evidence_ref uuid DEFAULT NULL,
occurred_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_deliverable_receipt PRIMARY KEY (tenant_id, deliverable_receipt_id)
);
ALTER TABLE ec09.ec09_deliverable_receipt ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_deliverable_receipt FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_deliverable_receipt_tenant ON ec09.ec09_deliverable_receipt USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_reporting_profile (
tenant_id uuid NOT NULL,
reporting_profile_id uuid DEFAULT gen_random_uuid() NOT NULL,
corporate_client_id uuid NOT NULL,
profile_code varchar(64) NOT NULL,
name varchar(180) NOT NULL,
purpose_ref uuid NOT NULL,
granularity_code varchar(40) NOT NULL,
min_group_size integer DEFAULT NULL,
retention_policy_ref uuid DEFAULT NULL,
state varchar(24) DEFAULT 'DRAFT' NOT NULL,
workflow_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_reporting_profile PRIMARY KEY (tenant_id, reporting_profile_id)
);
ALTER TABLE ec09.ec09_reporting_profile ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_reporting_profile FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_reporting_profile_tenant ON ec09.ec09_reporting_profile USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_reporting_profile_profile_code ON ec09.ec09_reporting_profile(tenant_id, profile_code);
```

```
CREATE TABLE ec09.ec09_reporting_metric_binding (
tenant_id uuid NOT NULL,
metric_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,
reporting_profile_id uuid NOT NULL,
metric_code varchar(80) NOT NULL,
source_context_code varchar(24) NOT NULL,
aggregation_code varchar(40) NOT NULL,
field_level_code varchar(40) DEFAULT 'AGGREGATE' NOT NULL,
sequence_no integer DEFAULT 1 NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_reporting_metric_binding PRIMARY KEY (tenant_id, metric_binding_id)
);
ALTER TABLE ec09.ec09_reporting_metric_binding ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_reporting_metric_binding FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_reporting_metric_binding_tenant ON ec09.ec09_reporting_metric_binding USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_reporting_audience (
tenant_id uuid NOT NULL,
audience_id uuid DEFAULT gen_random_uuid() NOT NULL,
reporting_profile_id uuid NOT NULL,
person_ref uuid DEFAULT NULL,
role_code varchar(64) DEFAULT NULL,
channel_code varchar(40) DEFAULT 'PORTAL' NOT NULL,
valid_from timestamptz DEFAULT now() NOT NULL,
valid_to timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_reporting_audience PRIMARY KEY (tenant_id, audience_id)
);
ALTER TABLE ec09.ec09_reporting_audience ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_reporting_audience FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_reporting_audience_tenant ON ec09.ec09_reporting_audience USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_report_run (
tenant_id uuid NOT NULL,
report_run_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
reporting_profile_id uuid NOT NULL,
as_of timestamptz NOT NULL,
state varchar(24) DEFAULT 'REQUESTED' NOT NULL,
parameters_hash varchar(128) NOT NULL,
dataset_ref uuid DEFAULT NULL,
document_ref uuid DEFAULT NULL,
content_hash varchar(128) DEFAULT NULL,
supersedes_report_run_id uuid DEFAULT NULL,
published_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_report_run PRIMARY KEY (tenant_id, report_run_id)
);
ALTER TABLE ec09.ec09_report_run ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_report_run FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_report_run_tenant ON ec09.ec09_report_run USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_report_delivery_receipt (
tenant_id uuid NOT NULL,
delivery_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,
report_run_id uuid NOT NULL,
audience_id uuid NOT NULL,
channel_code varchar(40) NOT NULL,
recipient_ref uuid DEFAULT NULL,
status varchar(24) DEFAULT 'PENDING' NOT NULL,
external_receipt_ref varchar(160) DEFAULT NULL,
delivered_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_report_delivery_receipt PRIMARY KEY (tenant_id, delivery_receipt_id)
);
ALTER TABLE ec09.ec09_report_delivery_receipt ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_report_delivery_receipt FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_report_delivery_receipt_tenant ON ec09.ec09_report_delivery_receipt USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_financial_intent (
tenant_id uuid NOT NULL,
financial_intent_id uuid DEFAULT gen_random_uuid() NOT NULL,
engagement_version_id uuid NOT NULL,
intent_type_code varchar(64) NOT NULL,
idempotency_key varchar(128) NOT NULL,
state varchar(24) DEFAULT 'CREATED' NOT NULL,
financial_ref uuid DEFAULT NULL,
external_receipt_ref varchar(160) DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_financial_intent PRIMARY KEY (tenant_id, financial_intent_id)
);
ALTER TABLE ec09.ec09_financial_intent ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_financial_intent FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_financial_intent_tenant ON ec09.ec09_financial_intent USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
CREATE UNIQUE INDEX uq_ec09_financial_intent_idempotency_key ON ec09.ec09_financial_intent(tenant_id, idempotency_key);
```

```
CREATE TABLE ec09.ec09_reconciliation_case (
tenant_id uuid NOT NULL,
reconciliation_case_id uuid DEFAULT gen_random_uuid() NOT NULL,
case_type_code varchar(64) NOT NULL,
aggregate_ref uuid NOT NULL,
state varchar(24) DEFAULT 'OPEN' NOT NULL,
resolution_code varchar(80) DEFAULT NULL,
evidence_ref uuid DEFAULT NULL,
opened_at timestamptz DEFAULT now() NOT NULL,
resolved_at timestamptz DEFAULT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_reconciliation_case PRIMARY KEY (tenant_id, reconciliation_case_id)
);
ALTER TABLE ec09.ec09_reconciliation_case ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_reconciliation_case FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_reconciliation_case_tenant ON ec09.ec09_reconciliation_case USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_idempotency_record (
tenant_id uuid NOT NULL,
idempotency_key varchar(160) NOT NULL,
operation_code varchar(80) NOT NULL,
request_hash varchar(128) NOT NULL,
state varchar(24) DEFAULT 'IN_PROGRESS' NOT NULL,
owner_id varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
response_code integer DEFAULT NULL,
response_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_idempotency_record PRIMARY KEY (tenant_id, idempotency_key)
);
ALTER TABLE ec09.ec09_idempotency_record ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_idempotency_record FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_idempotency_record_tenant ON ec09.ec09_idempotency_record USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_outbox_event (
tenant_id uuid NOT NULL,
event_id uuid DEFAULT gen_random_uuid() NOT NULL,
aggregate_type varchar(80) NOT NULL,
aggregate_id uuid NOT NULL,
event_type varchar(120) NOT NULL,
schema_version integer DEFAULT 1 NOT NULL,
correlation_id uuid NOT NULL,
causation_id uuid DEFAULT NULL,
payload jsonb DEFAULT '{}'::jsonb NOT NULL,
status varchar(24) DEFAULT 'PENDING' NOT NULL,
owner_id varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
occurred_at timestamptz DEFAULT now() NOT NULL,
published_at timestamptz DEFAULT NULL,
CONSTRAINT pk_ec09_outbox_event PRIMARY KEY (tenant_id, event_id)
);
ALTER TABLE ec09.ec09_outbox_event ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_outbox_event FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_outbox_event_tenant ON ec09.ec09_outbox_event USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_inbox_message (
tenant_id uuid NOT NULL,
message_id uuid NOT NULL,
consumer_code varchar(80) NOT NULL,
message_type varchar(120) NOT NULL,
schema_version integer DEFAULT 1 NOT NULL,
correlation_id uuid DEFAULT NULL,
payload_hash varchar(128) NOT NULL,
processed_at timestamptz DEFAULT NULL,
status varchar(24) DEFAULT 'RECEIVED' NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec09_inbox_message PRIMARY KEY (tenant_id, message_id, consumer_code)
);
ALTER TABLE ec09.ec09_inbox_message ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_inbox_message FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_inbox_message_tenant ON ec09.ec09_inbox_message USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
CREATE TABLE ec09.ec09_operation_status (
tenant_id uuid NOT NULL,
operation_id uuid DEFAULT gen_random_uuid() NOT NULL,
operation_type varchar(80) NOT NULL,
aggregate_ref uuid DEFAULT NULL,
state varchar(24) DEFAULT 'ACCEPTED' NOT NULL,
progress_pct numeric(5,2) DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
result_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec09_operation_status PRIMARY KEY (tenant_id, operation_id)
);
ALTER TABLE ec09.ec09_operation_status ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec09.ec09_operation_status FORCE ROW LEVEL SECURITY;
CREATE POLICY rls_ec09_operation_status_tenant ON ec09.ec09_operation_status USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
```

```
-- Internal tenant-aware foreign keys (representative complete pattern; repeat for every internal parent relation)
ALTER TABLE ec09.ec09_engagement_version
ADD CONSTRAINT fk_ec09_engagement_version_engagement
FOREIGN KEY (tenant_id, engagement_id)
REFERENCES ec09.ec09_engagement (tenant_id, engagement_id);

ALTER TABLE ec09.ec09_corporate_seat_pool
ADD CONSTRAINT fk_ec09_seat_pool_engagement_version
FOREIGN KEY (tenant_id, engagement_version_id)
REFERENCES ec09.ec09_engagement_version (tenant_id, engagement_version_id);

ALTER TABLE ec09.ec09_nomination_item
ADD CONSTRAINT fk_ec09_nomination_item_batch
FOREIGN KEY (tenant_id, nomination_batch_id)
REFERENCES ec09.ec09_nomination_batch (tenant_id, nomination_batch_id);

ALTER TABLE ec09.ec09_enrollment_batch_item
ADD CONSTRAINT fk_ec09_enrollment_item_batch
FOREIGN KEY (tenant_id, enrollment_batch_id)
REFERENCES ec09.ec09_enrollment_batch (tenant_id, enrollment_batch_id);

ALTER TABLE ec09.ec09_report_delivery_receipt
ADD CONSTRAINT fk_ec09_report_delivery_run
FOREIGN KEY (tenant_id, report_run_id)
REFERENCES ec09.ec09_report_run (tenant_id, report_run_id);

CREATE UNIQUE INDEX uq_ec09_one_active_engagement_version
ON ec09.ec09_engagement_version(tenant_id, engagement_id)
WHERE state = 'ACTIVE';

ALTER TABLE ec09.ec09_corporate_seat_pool
ADD CONSTRAINT ck_ec09_seat_pool_counts
CHECK (allocated_seats > 0 AND reserved_seats >= 0 AND consumed_seats >= 0
AND reserved_seats + consumed_seats <= allocated_seats);

ALTER TABLE ec09.ec09_operation_status
ADD CONSTRAINT ck_ec09_operation_progress
CHECK (progress_pct IS NULL OR (progress_pct >= 0 AND progress_pct <= 100));
```

```
-- Outbox claim pattern
WITH cte AS (
SELECT tenant_id, event_id
FROM ec09.ec09_outbox_event
WHERE status='PENDING' OR (status='IN_FLIGHT' AND lease_until < now())
ORDER BY occurred_at
FOR UPDATE SKIP LOCKED
LIMIT :batchSize
)
UPDATE ec09.ec09_outbox_event o
SET status='IN_FLIGHT', owner_id=:workerId, lease_until=now()+interval '60 seconds'
FROM cte
WHERE o.tenant_id=cte.tenant_id AND o.event_id=cte.event_id
RETURNING o.*;
```

# 

PostgreSQL es Source of Truth transaccional. MongoDB solo se permite para read models/report documents derivados cuando su forma documental aporte valor; nunca para sustituir EngagementVersion, batches, seats, report metadata o receipts oficiales. Todo read model debe ser regenerable desde hechos autorizados.

| **Tecnología** | **Uso permitido**                                                                     | **No permitido**                                          |
|----------------|---------------------------------------------------------------------------------------|-----------------------------------------------------------|
| **MongoDB**    | Corporate portal read models, report assembly cache documental, diff views derivados. | No engagements/seat pools/enrollments oficiales.          |
| **Redis**      | Cache versionado, rate limit, short-lived coordination, query acceleration.           | No idempotency durable, no seat truth, no approval state. |
| **PostgreSQL** | Todos los aggregates/receipts/operations oficiales EC-09.                             | —                                                         |

# 

EC-09 se implementa como módulo Spring Modulith aislado con arquitectura Hexagonal. El dominio no conoce HTTP, JPA, CT connectors ni proveedores. Application Services orquestan transacciones, authorization context, optimistic lock, idempotencia y ports. Adapters implementan persistencia, CT connectors, Finanzas y mensajería.

| **Capa**                    | **Paquetes sugeridos**                                           | **Responsabilidad**                                  |
|-----------------------------|------------------------------------------------------------------|------------------------------------------------------|
| **domain**                  | ec09.domain.engagement / nomination / reporting / reconciliation | Aggregates, VOs, policies y domain services.         |
| **application**             | ec09.application.command / query / port                          | Use cases, transactions, idempotency, authorization. |
| **adapter.in.web**          | ec09.adapter.in.web                                              | REST, ProblemDetail, ETag/If-Match.                  |
| **adapter.in.event**        | ec09.adapter.in.event                                            | Consumers + inbox dedup.                             |
| **adapter.out.persistence** | ec09.adapter.out.persistence                                     | JPA/JDBC repositories tenant-aware.                  |
| **adapter.out.integration** | ec09.adapter.out.integration                                     | EC-04, CT, Finanzas adapters.                        |
| **bootstrap**               | ec09.bootstrap                                                   | Module config, clocks, feature flags.                |

| **PROHIBIDO — Repository de EC-09 no puede leer tablas ec04/ec06/ec07/ec08 ni esquemas de Finanzas. Toda dependencia se resuelve mediante port/adapter/contract.** |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

| **Método** | **Ruta**                                            | **Uso**                      | **Headers/controles**                | **Respuesta** |
|------------|-----------------------------------------------------|------------------------------|--------------------------------------|---------------|
| **POST**   | /api/ec09/corporate-clients                         | Crear CorporateClientAccount | Idempotency-Key                      | 201           |
| **GET**    | /api/ec09/corporate-clients                         | Listar clientes              | Filtros/paginación                   | 200           |
| **GET**    | /api/ec09/corporate-clients/{id}                    | Detalle + ETag               | —                                    | 200           |
| **PATCH**  | /api/ec09/corporate-clients/{id}                    | Metadata escalar permitida   | If-Match                             | 200           |
| **POST**   | /api/ec09/tnas                                      | Crear TNA                    | Idempotency-Key                      | 201           |
| **POST**   | /api/ec09/tnas/{id}/requirements                    | Agregar requirement          | If-Match                             | 200           |
| **POST**   | /api/ec09/tnas/{id}/submit-review                   | Solicitar revisión           | If-Match + Idempotency-Key           | 202           |
| **POST**   | /api/ec09/engagements                               | Crear engagement             | Idempotency-Key                      | 201           |
| **POST**   | /api/ec09/engagements/{id}/versions                 | Crear/clonar versión         | Idempotency-Key                      | 201           |
| **POST**   | /api/ec09/engagement-versions/{id}/program-bindings | Vincular programa/edición    | If-Match                             | 200           |
| **POST**   | /api/ec09/engagement-versions/{id}/seat-pools       | Crear pool                   | If-Match                             | 200           |
| **POST**   | /api/ec09/engagement-versions/{id}/activate         | Activar                      | If-Match + Idempotency-Key + step-up | 200           |
| **POST**   | /api/ec09/engagement-versions/{id}/cancel           | Cancelar                     | If-Match + Idempotency-Key + reason  | 200           |
| **POST**   | /api/ec09/nomination-batches                        | Crear batch                  | Idempotency-Key                      | 201           |
| **POST**   | /api/ec09/nomination-batches/{id}/validate          | Validar                      | If-Match                             | 202           |
| **POST**   | /api/ec09/nomination-batches/{id}/promote           | Promover a enrollment batch  | If-Match + Idempotency-Key           | 202           |
| **GET**    | /api/ec09/enrollment-batches/{id}                   | Consultar progreso           | —                                    | 200           |
| **POST**   | /api/ec09/substitutions                             | Solicitar sustitución        | Idempotency-Key                      | 201           |
| **POST**   | /api/ec09/substitutions/{id}/apply                  | Aplicar                      | If-Match + Idempotency-Key           | 202           |
| **POST**   | /api/ec09/reporting-profiles                        | Crear perfil                 | Idempotency-Key                      | 201           |
| **POST**   | /api/ec09/reporting-profiles/{id}/metrics           | Agregar métrica              | If-Match                             | 200           |
| **POST**   | /api/ec09/report-runs                               | Generar reporte              | Idempotency-Key                      | 202           |
| **POST**   | /api/ec09/report-runs/{id}/publish                  | Publicar                     | If-Match + step-up                   | 200           |
| **POST**   | /api/ec09/report-runs/{id}/deliveries               | Entregar                     | Idempotency-Key                      | 202           |
| **POST**   | /api/ec09/financial-intents                         | Crear intent                 | Idempotency-Key                      | 202           |
| **POST**   | /api/ec09/reconciliation-cases/{id}/reconcile       | Reconciliar                  | Idempotency-Key                      | 202           |
| **GET**    | /api/ec09/operations/{operationId}                  | OperationStatus              | —                                    | 200           |

## 

| **HTTP** | **Semántica**                     | **Ejemplos reasonCode**                    |
|----------|-----------------------------------|--------------------------------------------|
| **400**  | Request/schema inválido           | INVALID_REQUEST                            |
| **401**  | No autenticado                    | AUTH_REQUIRED                              |
| **403**  | No autorizado/scope               | SCOPE_DENIED / PURPOSE_DENIED              |
| **404**  | No encontrado                     | ENGAGEMENT_NOT_FOUND                       |
| **409**  | Conflicto de estado/idempotency   | INVALID_STATE / IDEMPOTENCY_KEY_REUSED     |
| **412**  | ETag obsoleto                     | PRECONDITION_FAILED                        |
| **422**  | Regla de negocio                  | SEAT_POOL_EXHAUSTED / REPORT_PRIVACY_BLOCK |
| **429**  | Rate/capacity limit               | BATCH_LIMIT_EXCEEDED                       |
| **503**  | Dependencia crítica no disponible | EC04_UNAVAILABLE / FINANCE_UNAVAILABLE     |

## 

```
record ActivateEngagementRequest(String reasonCode, UUID workflowRef) {}
record NominationItemRequest(String sourceKey, UUID personRef, String externalEmployeeCode) {}
record CreateNominationBatchRequest(UUID engagementVersionId, UUID seatPoolId, UUID sourceDocumentRef,
List<NominationItemRequest> items) {}
record ReportRunRequest(UUID engagementVersionId, UUID reportingProfileId, Instant asOf,
Map<String,String> parameters) {}
record OperationStatusDto(UUID operationId, String state, BigDecimal progressPct,
String reasonCode, UUID resultRef, Instant updatedAt) {}
```

# 

| **Evento**                 | **Aggregate ID**      | **Producer** | **Consumers**        |
|----------------------------|-----------------------|--------------|----------------------|
| CorporateClientActivated   | corporate_client_id   | EC-09        | CT-11/others         |
| **TnaApproved**            | tna_id                | EC-09        | Portfolio/analytics  |
| **EngagementActivated**    | engagement_version_id | EC-09        | EC-04/11/analytics   |
| **EngagementCancelled**    | engagement_version_id | EC-09        | downstream consumers |
| **NominationBatchReady**   | nomination_batch_id   | EC-09        | operators            |
| EnrollmentBatchCompleted   | enrollment_batch_id   | EC-09        | portal/reporting     |
| **ParticipantSubstituted** | substitution_id       | EC-09        | reporting/audit      |
| **ReportPublished**        | report_run_id         | EC-09        | portal/delivery      |
| **ReportDelivered**        | delivery_receipt_id   | EC-09        | audit/analytics      |
| FinancialIntentReconciled  | financial_intent_id   | EC-09        | ops                  |

Todos los eventos incluyen event_id, tenant_id, aggregate_id, correlation_id, causation_id, schema_version, occurred_at y payload. El outbox se persiste en la misma transacción del hecho. Consumers usan inbox dedup y toleran delivery at-least-once. AsyncAPI en Git es contrato ejecutable y debe tener compatibility tests.

# 

| **Integración**      | **Timeout/Retry**              | **Circuit breaker** | **UNKNOWN_EFFECT / reconciliation**                             |
|----------------------|--------------------------------|---------------------|-----------------------------------------------------------------|
| **EC-04 Enrollment** | Timeout corto; retry solo safe | Sí                  | Consultar estado por idempotency key/receipt antes de reenviar. |
| **Finanzas**         | Según contrato                 | Sí                  | Obligatorio reconcile-before-retry.                             |
| **CT-05 documentos** | Retry idempotente              | Sí                  | Verificar document_ref/hash.                                    |
| **CT-07 entrega**    | Retry post-commit              | Sí                  | Delivery receipt; no re-publicar report.                        |
| **CT-11 datasets**   | Read retries                   | Sí                  | STALE/PARTIAL visible.                                          |
| **CT-12 IA**         | No critical path               | Sí                  | UNAVAILABLE permite trabajo humano.                             |
| **CT-18 externos**   | Según provider                 | Sí                  | Receipt/provider status.                                        |

| **UNKNOWN_EFFECT — Si EC-09 envía un comando remoto, el sistema externo lo aplica y la respuesta se pierde, EC-09 conserva UNKNOWN_EFFECT. No reintenta ciegamente. Primero consulta/reconcilia por request/idempotency/receipt; solo reintenta cuando demuestra que el efecto no ocurrió.** |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

| **Workspace**              | **Usuario**                 | **Layout/capacidades**                                                               | **Estados críticos**                          |
|----------------------------|-----------------------------|--------------------------------------------------------------------------------------|-----------------------------------------------|
| Corporate Client Workspace | Portfolio/Corporate Manager | Resumen cliente, engagements, contactos autorizados, KPIs, alerts.                   | NO_DATA/STALE/UNAVAILABLE explícitos.         |
| **TNA Studio**             | Learning Consultant         | Editor requirements, personas objetivo, constraints, review panel, AI assist drawer. | Draft autosave no salta ETag.                 |
| **Engagement Studio**      | Corporate Program Manager   | Tabs Scope / Programs / Seats / Milestones / Reporting / Evidence / History.         | Commands de intención, diff y impact preview. |
| **Nomination Desk**        | Corporate Coordinator       | Upload/dry-run, grid por item, duplicate/identity issues, promote batch.             | Partial success y retry por item.             |
| Enrollment Batch Console   | Operator                    | Progress, successes/failures/unknown, receipts y reconcile actions.                  | UNKNOWN_EFFECT distinto de FAILED.            |
| **Substitution Desk**      | Operator/Governance         | Solicitud, policy/cutoff, old/new participant refs, approval evidence.               | Step-up cuando aplique.                       |
| **Reporting Studio**       | Reporting Manager           | Profile builder, metric allowlist, audience, privacy preview, report history.        | Preview redaction/aggregation.                |
| **Corporate Portal**       | Sponsor                     | Engagement status, seat utilization, reports, deliverables permitidos.               | Sin acceso a facts no autorizados.            |
| **Reconciliation Center**  | Ops                         | Casos UNKNOWN_EFFECT, receipts, external lookup, controlled retry.                   | No botón “marcar confirmado” sin evidencia.   |

## 

Cada query dependiente de servicios externos distingue NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT. “0 participantes completaron” solo se muestra cuando el dato está disponible y el valor es realmente cero. Si EC-07 no responde, la UI muestra UNAVAILABLE/PARTIAL con asOf y provenance.

## 

- OpenAPI-generated client único

- TanStack Query o baseline PeopleU equivalente con query keys versionadas

- React Hook Form + schema validation según baseline

- Route-level error boundaries

- ETag preservado en cache y enviado en mutaciones

- ProblemDetail mapper centralizado

- Feature modules por workspace

- WCAG 2.2 AA

- Tests unit/component/integration/E2E

# 

EC-09 tiene Mobile limitado. El valor principal está en consulta ejecutiva y notificaciones para sponsors/coordinators, no en replicar el backoffice corporativo. Operaciones de alto riesgo — aprobar engagement, alterar reporting privacy, ejecutar reconciliación financiera o procesar lotes masivos — permanecen en Web salvo ADR y controles adicionales.

| **Journey móvil**              | **Permitido**  | **Restricciones**                  |
|--------------------------------|----------------|------------------------------------|
| **Sponsor dashboard**          | Sí             | Solo scope y métricas autorizadas. |
| Report notifications/deep link | Sí             | Auth + signed/deep link seguro.    |
| **Seat utilization**           | Sí             | No PII individual por defecto.     |
| **Approve deliverable**        | Opcional       | Step-up y evidence.                |
| **Upload nominations**         | No por defecto | Backoffice Web.                    |
| Financial reconciliation       | No             | Web/Ops only.                      |
| **Bulk enrollment**            | No             | Web/Ops only.                      |

# 

| **Capacidad**              | **Web**  | **Backend**            | **Mobile**          |
|----------------------------|----------|------------------------|---------------------|
| Corporate Client Workspace | Completo | Commands/queries/ports | Consulta o limitado |
| **TNA Studio**             | Completo | Commands/queries/ports | Consulta o limitado |
| **Engagement Studio**      | Completo | Commands/queries/ports | Consulta o limitado |
| **Nomination Desk**        | Completo | Commands/queries/ports | Consulta o limitado |
| Enrollment Batch Console   | Completo | Commands/queries/ports | Consulta o limitado |
| **Substitution Desk**      | Completo | Commands/queries/ports | Consulta o limitado |
| **Reporting Studio**       | Completo | Commands/queries/ports | Consulta o limitado |
| **Corporate Portal**       | Completo | Commands/queries/ports | Consulta o limitado |

# 

| **Rol**                     | **RBAC**                             | **ABAC**                    | **SoD/limitación**                         |
|-----------------------------|--------------------------------------|-----------------------------|--------------------------------------------|
| Corporate Portfolio Manager | client.read/write, engagement.create | tenant + assigned scopes    | No aprueba solo si SoD policy.             |
| **Learning Consultant**     | tna.write                            | client/engagement scope     | No activa engagement.                      |
| **Corporate Coordinator**   | nomination.write                     | engagement scope            | No accede a reports fuera purpose.         |
| Academic/Corporate Approver | engagement.approve                   | scope + workflow assignment | No mismo actor material cuando SoD aplica. |
| **Report Manager**          | reporting.manage                     | client + purpose            | No bypass de privacy policy.               |
| **Sponsor User**            | portal.read                          | corporate_client + audience | Read-only, mínimo dato.                    |
| **Ops Reconciliation**      | reconcile.execute                    | case assignment + step-up   | No cambia facts académicos.                |
| **Auditor**                 | audit.read                           | evidence scope              | Read-only.                                 |

## 

| **Amenaza**              | **Vector**                                | **Mitigación**                                           |
|--------------------------|-------------------------------------------|----------------------------------------------------------|
| IDOR cross-tenant/client | Manipular IDs para leer otro sponsor      | RLS + ABAC + opaque IDs + negative tests.                |
| **Mass assignment**      | Body intenta tenant/state/financial ref   | DTO allowlist + server-derived fields.                   |
| **Bulk abuse**           | Batch enorme/zip bomb                     | Size limits, scanning CT-05, quotas.                     |
| **PII exfiltration**     | Reporte con campos no autorizados         | ReportingProfile allowlist + privacy filter + evidence.  |
| **Replay**               | Repetir promote/delivery/financial intent | Durable idempotency + receipts.                          |
| **Privilege escalation** | Sponsor intenta approve/reconcile         | RBAC/ABAC/step-up/SoD.                                   |
| **Injection**            | Filtros/report parameters maliciosos      | Parameterized queries + schema validation.               |
| **UNKNOWN_EFFECT abuse** | Retry duplica efecto remoto               | Reconcile-before-retry.                                  |
| **Stale policy**         | Usar profile revocado                     | Policy/version/effective checks.                         |
| **Report link leakage**  | URL export compartida                     | Short TTL, audience-bound access, no public object URLs. |

## 

- SAST

- SCA/dependency policy

- secret scanning

- SBOM

- container image scan

- IaC scan

- API fuzzing

- tenant isolation suite

- authorization matrix tests

- OWASP ASVS-aligned review

- High/Critical release gate

# 

Toda operación crítica registra tenant, actor, subject, scope, timestamp UTC, action, resource, before/after o diff cuando aplique, reason_code, correlation_id, policy version, assurance/step-up y evidence refs. El Evidence Pack de activation/cancellation/report delivery/reconciliation debe permitir reconstruir quién hizo qué, bajo qué autoridad y con qué resultado.

| **Operación**           | **Audit mínimo**                            | **Evidencia**             |
|-------------------------|---------------------------------------------|---------------------------|
| **Activate engagement** | snapshot hash, workflow, actor, policy refs | approval + content hash   |
| **Cancel/Suspend**      | reason, actor, downstream impact            | workflow/evidence         |
| **Promote batch**       | batch hash, counts, item receipts           | EC-04 receipts            |
| **Substitution**        | old/new refs, policy, cutoff                | approval + EC-04 receipt  |
| **Publish report**      | profile version, asOf, provenance           | dataset/document hash     |
| **Deliver report**      | audience, purpose, channel                  | delivery receipt          |
| **Reconcile financial** | lookup result, authority                    | external receipt/evidence |

# 

| **SLI**                    | **Objetivo**                                   | **SLO**             |
|----------------------------|------------------------------------------------|---------------------|
| Engagement command latency | p95 \< 500 ms local, excluyendo external async | 99.5% mensual       |
| **Nomination validation**  | p95 \< 5 s para 1,000 items async              | 99% dentro objetivo |
| Batch promotion acceptance | 202 \< 800 ms                                  | 99.5%               |
| Report request acceptance  | 202 \< 800 ms                                  | 99.5%               |
| **Report generation**      | según size; p95 \< 60 s baseline               | 98%                 |
| **Outbox lag**             | p95 \< 30 s                                    | 99%                 |
| **RLS violations**         | 0 exitosas                                     | 100% bloqueadas     |
| **UNKNOWN_EFFECT aging**   | \< policy threshold                            | alerta al exceder   |

Métricas técnicas: latency/error/saturation, connection pool, DB locks, RLS deny, outbox lag, inbox duplicates, idempotency recoveries, batch throughput, report generation time, external dependency availability. Métricas de negocio: active engagements, seat utilization, nomination conversion, partial batch rate, report delivery SLA, sponsor usage y reconciliation backlog.

# 

Toda IA entra exclusivamente por CT-12. Casos permitidos: resumir TNA, sugerir taxonomía de necesidades, proponer borradores de reporting narratives, detectar inconsistencias entre alcance y ProgramVersion, resumir feedback corporativo y señalar riesgos de ejecución. Los resultados son recomendaciones no autoritativas.

| **Caso IA**           | **Permitido**                      | **Prohibido**                          |
|-----------------------|------------------------------------|----------------------------------------|
| **TNA summarization** | Borrador con grounding/provenance  | Modificar TNA aprobado sin usuario.    |
| **Program fit**       | Ranking/sugerencia                 | Seleccionar/contratar automáticamente. |
| **Report narrative**  | Borrador sobre facts suministrados | Inventar métricas/facts.               |
| **Risk detection**    | Alertas explicables                | Cancelar engagement.                   |
| **PII processing**    | Solo mínimo/purpose autorizado     | Inferencias sensibles no autorizadas.  |

| **AI RECOMMENDATION ≠ DECISION — Guardar run_ref, model_ref, template_ref, eval_ref, grounding refs, confidence, reviewer y outcome.** |
|----------------------------------------------------------------------------------------------------------------------------------------|

# 

| **KPI**                    | **Definición**                            | **Source**             |
|----------------------------|-------------------------------------------|------------------------|
| **Seat Utilization**       | consumed_seats / allocated_seats          | EC-09 seat facts       |
| Nomination Acceptance Rate | valid/promoted nominations                | EC-09 + EC-04 receipts |
| **Enrollment Conversion**  | successful enrollments / promoted items   | EC-04                  |
| **Attendance Rate**        | official attendance / expected            | EC-06                  |
| **Completion Rate**        | completed / enrolled                      | EC-07                  |
| **Credential Rate**        | issued / eligible or completed per policy | EC-08                  |
| **Report SLA**             | delivered on time / due                   | EC-09                  |
| **Corporate Retention**    | renewed clients/engagements               | EC-09/analytics        |
| **Reconciliation Aging**   | age of open UNKNOWN_EFFECT cases          | EC-09                  |

# 

La migración no inserta directamente en tablas finales. CT-16 ejecuta Extract → Normalize → Map → Validate → Dry-run → Promote through EC-09 commands/API → Receipt → Reconcile → Certify. Cada record conserva source lineage, source key, transformed payload hash, validation result, promotion result y receipt.

| **Objeto legacy**         | **DQ crítico**                    | **Estrategia**                                         |
|---------------------------|-----------------------------------|--------------------------------------------------------|
| **Clientes corporativos** | duplicados/identidad organización | match asistido + review                                |
| **Acuerdos**              | versiones/vigencia/documentos     | preservar refs/hash                                    |
| **Cupos**                 | conteos inconsistentes            | reconcile contra enrollments                           |
| **Nominaciones**          | PII/duplicados                    | resolver con CT-04/EC-04                               |
| **Reportes históricos**   | provenance inexistente            | clasificar legacy snapshot, no fingir reproducibilidad |

# 

- Unit Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Domain Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Repository Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- RLS/Tenant Isolation Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Integration Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Contract Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- API Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Event Contract Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Security Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Authorization/SoD Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Concurrency/ETag Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Seat Race Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Idempotency Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Lease Recovery Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Resilience Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- UNKNOWN_EFFECT/Reconciliation Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Performance Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Bulk Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Migration Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Report Privacy Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Report Reproducibility Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- E2E — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- UAT — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- Mobile Tests — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

- AI Evals — evidencia automatizada en Git/CI; failures críticos bloquean Gate correspondiente.

# 

| **GS**          | **Escenario**                            | **Precondición**                                       | **Acción**                               | **Resultado esperado**                                                                                                       | **Evidencia**                                          |
|-----------------|------------------------------------------|--------------------------------------------------------|------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------|
| **GS-EC09-001** | Crear cliente corporativo válido         | Tenant y actor autorizados; datos baseline preparados. | Crear cliente corporativo válido         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-002** | Bloquear duplicate client code           | Tenant y actor autorizados; datos baseline preparados. | Bloquear duplicate client code           | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-003** | RLS impide leer otro tenant              | Tenant y actor autorizados; datos baseline preparados. | RLS impide leer otro tenant              | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-004** | Crear TNA draft                          | Tenant y actor autorizados; datos baseline preparados. | Crear TNA draft                          | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-005** | Aprobar TNA                              | Tenant y actor autorizados; datos baseline preparados. | Aprobar TNA                              | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-006** | TNA confidential ABAC                    | Tenant y actor autorizados; datos baseline preparados. | TNA confidential ABAC                    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-007** | Crear engagement                         | Tenant y actor autorizados; datos baseline preparados. | Crear engagement                         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-008** | Crear nueva engagement version           | Tenant y actor autorizados; datos baseline preparados. | Crear nueva engagement version           | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-009** | Activar versión válida                   | Tenant y actor autorizados; datos baseline preparados. | Activar versión válida                   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-010** | Bloquear segunda ACTIVE                  | Tenant y actor autorizados; datos baseline preparados. | Bloquear segunda ACTIVE                  | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-011** | ETag conflict en seat pool               | Tenant y actor autorizados; datos baseline preparados. | ETag conflict en seat pool               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-012** | Lineage same engagement                  | Tenant y actor autorizados; datos baseline preparados. | Lineage same engagement                  | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-013** | Pin ProgramVersion publicada             | Tenant y actor autorizados; datos baseline preparados. | Pin ProgramVersion publicada             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-014** | Rechazar ProgramVersion inexistente      | Tenant y actor autorizados; datos baseline preparados. | Rechazar ProgramVersion inexistente      | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-015** | Seat pool válido                         | Tenant y actor autorizados; datos baseline preparados. | Seat pool válido                         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-016** | Bloquear seats negativos                 | Tenant y actor autorizados; datos baseline preparados. | Bloquear seats negativos                 | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-017** | Carrera último asiento                   | Tenant y actor autorizados; datos baseline preparados. | Carrera último asiento                   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-018** | Crear nomination batch                   | Tenant y actor autorizados; datos baseline preparados. | Crear nomination batch                   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-019** | Dry-run nominaciones                     | Tenant y actor autorizados; datos baseline preparados. | Dry-run nominaciones                     | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-020** | Duplicate source key                     | Tenant y actor autorizados; datos baseline preparados. | Duplicate source key                     | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-021** | Identity ambiguity NEEDS_REVIEW          | Tenant y actor autorizados; datos baseline preparados. | Identity ambiguity NEEDS_REVIEW          | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-022** | Promote batch idempotente                | Tenant y actor autorizados; datos baseline preparados. | Promote batch idempotente                | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-023** | Partial enrollment success               | Tenant y actor autorizados; datos baseline preparados. | Partial enrollment success               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-024** | EC-04 timeout UNKNOWN_EFFECT             | Tenant y actor autorizados; datos baseline preparados. | EC-04 timeout UNKNOWN_EFFECT             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-025** | Reconcile enrollment aplicado            | Tenant y actor autorizados; datos baseline preparados. | Reconcile enrollment aplicado            | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-026** | Retry enrollment no aplicado             | Tenant y actor autorizados; datos baseline preparados. | Retry enrollment no aplicado             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-027** | Sustitución permitida                    | Tenant y actor autorizados; datos baseline preparados. | Sustitución permitida                    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-028** | Sustitución fuera de cutoff rechazada    | Tenant y actor autorizados; datos baseline preparados. | Sustitución fuera de cutoff rechazada    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-029** | Sustitución con step-up                  | Tenant y actor autorizados; datos baseline preparados. | Sustitución con step-up                  | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-030** | Cancelar engagement conserva historia    | Tenant y actor autorizados; datos baseline preparados. | Cancelar engagement conserva historia    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-031** | Suspend/reanudar según policy            | Tenant y actor autorizados; datos baseline preparados. | Suspend/reanudar según policy            | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-032** | Crear reporting profile                  | Tenant y actor autorizados; datos baseline preparados. | Crear reporting profile                  | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-033** | Audience revocada                        | Tenant y actor autorizados; datos baseline preparados. | Audience revocada                        | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-034** | Purpose missing bloquea                  | Tenant y actor autorizados; datos baseline preparados. | Purpose missing bloquea                  | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-035** | Métrica no permitida rechazada           | Tenant y actor autorizados; datos baseline preparados. | Métrica no permitida rechazada           | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-036** | Detalle individual sin permiso bloqueado | Tenant y actor autorizados; datos baseline preparados. | Detalle individual sin permiso bloqueado | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-037** | Aggregate report k-threshold             | Tenant y actor autorizados; datos baseline preparados. | Aggregate report k-threshold             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-038** | Generar report asOf                      | Tenant y actor autorizados; datos baseline preparados. | Generar report asOf                      | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-039** | Report PARTIAL por EC-07 down            | Tenant y actor autorizados; datos baseline preparados. | Report PARTIAL por EC-07 down            | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-040** | Report ZERO real                         | Tenant y actor autorizados; datos baseline preparados. | Report ZERO real                         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-041** | Report STALE visible                     | Tenant y actor autorizados; datos baseline preparados. | Report STALE visible                     | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-042** | Publicar report immutable                | Tenant y actor autorizados; datos baseline preparados. | Publicar report immutable                | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-043** | Corregir report superseding              | Tenant y actor autorizados; datos baseline preparados. | Corregir report superseding              | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-044** | Deliver report portal                    | Tenant y actor autorizados; datos baseline preparados. | Deliver report portal                    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-045** | Delivery timeout receipt unknown         | Tenant y actor autorizados; datos baseline preparados. | Delivery timeout receipt unknown         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-046** | Reconcile delivery                       | Tenant y actor autorizados; datos baseline preparados. | Reconcile delivery                       | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-047** | Export link TTL                          | Tenant y actor autorizados; datos baseline preparados. | Export link TTL                          | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-048** | Watermark requerido                      | Tenant y actor autorizados; datos baseline preparados. | Watermark requerido                      | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-049** | Financial intent                         | Tenant y actor autorizados; datos baseline preparados. | Financial intent                         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-050** | Financial timeout UNKNOWN_EFFECT         | Tenant y actor autorizados; datos baseline preparados. | Financial timeout UNKNOWN_EFFECT         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-051** | Finance reconcile applied                | Tenant y actor autorizados; datos baseline preparados. | Finance reconcile applied                | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-052** | Finance retry safe                       | Tenant y actor autorizados; datos baseline preparados. | Finance retry safe                       | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-053** | No ledger local                          | Tenant y actor autorizados; datos baseline preparados. | No ledger local                          | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-054** | Deliverable submitted                    | Tenant y actor autorizados; datos baseline preparados. | Deliverable submitted                    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-055** | Deliverable accepted evidence            | Tenant y actor autorizados; datos baseline preparados. | Deliverable accepted evidence            | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-056** | Milestone complete                       | Tenant y actor autorizados; datos baseline preparados. | Milestone complete                       | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-057** | Milestone no implica payment             | Tenant y actor autorizados; datos baseline preparados. | Milestone no implica payment             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-058** | Outbox atomic                            | Tenant y actor autorizados; datos baseline preparados. | Outbox atomic                            | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-059** | Inbox duplicate ignored                  | Tenant y actor autorizados; datos baseline preparados. | Inbox duplicate ignored                  | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-060** | Outbox lease recovery                    | Tenant y actor autorizados; datos baseline preparados. | Outbox lease recovery                    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-061** | Idempotency lease recovery               | Tenant y actor autorizados; datos baseline preparados. | Idempotency lease recovery               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-062** | OperationStatus 202                      | Tenant y actor autorizados; datos baseline preparados. | OperationStatus 202                      | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-063** | OperationStatus partial                  | Tenant y actor autorizados; datos baseline preparados. | OperationStatus partial                  | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-064** | Rate limit batch                         | Tenant y actor autorizados; datos baseline preparados. | Rate limit batch                         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-065** | Payload max                              | Tenant y actor autorizados; datos baseline preparados. | Payload max                              | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-066** | Runtime role no BYPASSRLS                | Tenant y actor autorizados; datos baseline preparados. | Runtime role no BYPASSRLS                | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-067** | Migrator role separado                   | Tenant y actor autorizados; datos baseline preparados. | Migrator role separado                   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-068** | SAST High blocks release                 | Tenant y actor autorizados; datos baseline preparados. | SAST High blocks release                 | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-069** | Schema expand/contract                   | Tenant y actor autorizados; datos baseline preparados. | Schema expand/contract                   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-070** | N/N-1 compatibility                      | Tenant y actor autorizados; datos baseline preparados. | N/N-1 compatibility                      | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-071** | CT-05 unavailable                        | Tenant y actor autorizados; datos baseline preparados. | CT-05 unavailable                        | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-072** | CT-12 unavailable manual continues       | Tenant y actor autorizados; datos baseline preparados. | CT-12 unavailable manual continues       | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-073** | AI suggestion provenance                 | Tenant y actor autorizados; datos baseline preparados. | AI suggestion provenance                 | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-074** | AI cannot approve                        | Tenant y actor autorizados; datos baseline preparados. | AI cannot approve                        | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-075** | No PII in logs                           | Tenant y actor autorizados; datos baseline preparados. | No PII in logs                           | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-076** | Trace correlation propagated             | Tenant y actor autorizados; datos baseline preparados. | Trace correlation propagated             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-077** | Audit reason required                    | Tenant y actor autorizados; datos baseline preparados. | Audit reason required                    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-078** | Business rejection not 500               | Tenant y actor autorizados; datos baseline preparados. | Business rejection not 500               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-079** | ProblemDetail reason stable              | Tenant y actor autorizados; datos baseline preparados. | ProblemDetail reason stable              | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-080** | Pagination stable sort                   | Tenant y actor autorizados; datos baseline preparados. | Pagination stable sort                   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-081** | No latest program resolution             | Tenant y actor autorizados; datos baseline preparados. | No latest program resolution             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-082** | Cross-context no FK                      | Tenant y actor autorizados; datos baseline preparados. | Cross-context no FK                      | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-083** | Legacy dry-run                           | Tenant y actor autorizados; datos baseline preparados. | Legacy dry-run                           | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-084** | Legacy duplicate client review           | Tenant y actor autorizados; datos baseline preparados. | Legacy duplicate client review           | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-085** | Report reproducibility                   | Tenant y actor autorizados; datos baseline preparados. | Report reproducibility                   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-086** | Dataset provenance                       | Tenant y actor autorizados; datos baseline preparados. | Dataset provenance                       | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-087** | Attendance from EC-06 only               | Tenant y actor autorizados; datos baseline preparados. | Attendance from EC-06 only               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-088** | Completion from EC-07 only               | Tenant y actor autorizados; datos baseline preparados. | Completion from EC-07 only               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-089** | Credential from EC-08 only               | Tenant y actor autorizados; datos baseline preparados. | Credential from EC-08 only               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-090** | Enrollment from EC-04 only               | Tenant y actor autorizados; datos baseline preparados. | Enrollment from EC-04 only               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-091** | Sponsor cannot change grades             | Tenant y actor autorizados; datos baseline preparados. | Sponsor cannot change grades             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-092** | Sponsor cannot issue certificate         | Tenant y actor autorizados; datos baseline preparados. | Sponsor cannot issue certificate         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-093** | Third-party payer no data access         | Tenant y actor autorizados; datos baseline preparados. | Third-party payer no data access         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-094** | Cross-tenant same corporation isolated   | Tenant y actor autorizados; datos baseline preparados. | Cross-tenant same corporation isolated   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-095** | Mobile sponsor read-only                 | Tenant y actor autorizados; datos baseline preparados. | Mobile sponsor read-only                 | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-096** | Mobile no reconcile                      | Tenant y actor autorizados; datos baseline preparados. | Mobile no reconcile                      | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-097** | WCAG keyboard navigation                 | Tenant y actor autorizados; datos baseline preparados. | WCAG keyboard navigation                 | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-098** | Localization fallback                    | Tenant y actor autorizados; datos baseline preparados. | Localization fallback                    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-099** | Stale policy blocks sensitive report     | Tenant y actor autorizados; datos baseline preparados. | Stale policy blocks sensitive report     | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-100** | Audience valid_to honored                | Tenant y actor autorizados; datos baseline preparados. | Audience valid_to honored                | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-101** | Retention purge governed                 | Tenant y actor autorizados; datos baseline preparados. | Retention purge governed                 | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-102** | Legal hold prevents purge                | Tenant y actor autorizados; datos baseline preparados. | Legal hold prevents purge                | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-103** | Document hash mismatch                   | Tenant y actor autorizados; datos baseline preparados. | Document hash mismatch                   | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-104** | Report access audit                      | Tenant y actor autorizados; datos baseline preparados. | Report access audit                      | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-105** | Bulk retry failed items only             | Tenant y actor autorizados; datos baseline preparados. | Bulk retry failed items only             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-106** | Out-of-order event tolerated             | Tenant y actor autorizados; datos baseline preparados. | Out-of-order event tolerated             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-107** | Duplicate event tolerated                | Tenant y actor autorizados; datos baseline preparados. | Duplicate event tolerated                | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-108** | Event schema compatibility               | Tenant y actor autorizados; datos baseline preparados. | Event schema compatibility               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-109** | Unknown event version quarantined        | Tenant y actor autorizados; datos baseline preparados. | Unknown event version quarantined        | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-110** | Circuit breaker opens                    | Tenant y actor autorizados; datos baseline preparados. | Circuit breaker opens                    | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-111** | Dependency recovery closes breaker       | Tenant y actor autorizados; datos baseline preparados. | Dependency recovery closes breaker       | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-112** | Report SLA alert                         | Tenant y actor autorizados; datos baseline preparados. | Report SLA alert                         | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-113** | Reconciliation aging alert               | Tenant y actor autorizados; datos baseline preparados. | Reconciliation aging alert               | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-114** | Seat utilization metric                  | Tenant y actor autorizados; datos baseline preparados. | Seat utilization metric                  | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-115** | Nomination conversion metric             | Tenant y actor autorizados; datos baseline preparados. | Nomination conversion metric             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-116** | Corporate portal empty state             | Tenant y actor autorizados; datos baseline preparados. | Corporate portal empty state             | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-117** | Corporate portal unavailable state       | Tenant y actor autorizados; datos baseline preparados. | Corporate portal unavailable state       | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-118** | Corporate portal partial state           | Tenant y actor autorizados; datos baseline preparados. | Corporate portal partial state           | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-119** | Corporate portal zero state              | Tenant y actor autorizados; datos baseline preparados. | Corporate portal zero state              | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-120** | Cancel with downstream unknown           | Tenant y actor autorizados; datos baseline preparados. | Cancel with downstream unknown           | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-121** | Impact simulation partial                | Tenant y actor autorizados; datos baseline preparados. | Impact simulation partial                | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-122** | Evidence pack export                     | Tenant y actor autorizados; datos baseline preparados. | Evidence pack export                     | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |
| **GS-EC09-123** | Audit reconstructs activation            | Tenant y actor autorizados; datos baseline preparados. | Audit reconstructs activation            | El sistema aplica la regla de dominio correspondiente, preserva isolation/history y devuelve estado/ProblemDetail explícito. | Test automatizado + audit/event/receipt según aplique. |

# 

| **ID**     | **Escenario**                            | **Participantes**                          | **Criterio**               |
|------------|------------------------------------------|--------------------------------------------|----------------------------|
| **UAT-01** | Alta y activación de cliente corporativo | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-02** | TNA end-to-end                           | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-03** | Engagement versionado y activación       | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-04** | Cambio material y supersede              | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-05** | Seat pool y carrera de cupo              | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-06** | Nomination batch 1,000 items             | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-07** | Partial enrollment batch                 | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-08** | Reconciliación EC-04                     | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-09** | Sustitución participante                 | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-10** | Cancelación con historia                 | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-11** | Reporting profile aggregate              | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-12** | Reporting profile individual limitado    | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-13** | Privacy threshold                        | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-14** | Report generation asOf                   | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-15** | Report correction                        | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-16** | Portal sponsor scope                     | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-17** | Report delivery receipt                  | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-18** | Financial intent happy path              | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-19** | Financial UNKNOWN_EFFECT                 | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-20** | Milestone/deliverable                    | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-21** | RLS cross-tenant                         | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-22** | SoD/step-up                              | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-23** | Audit evidence pack                      | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-24** | Migration dry-run                        | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-25** | Migration promote                        | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-26** | Outbox/inbox recovery                    | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-27** | Performance bulk                         | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-28** | Accessibility                            | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-29** | AI assist with provenance                | Representantes funcionales + QA + Security | PASS con evidencia firmada |
| **UAT-30** | Disaster/degraded mode                   | Representantes funcionales + QA + Security | PASS con evidencia firmada |

# 

| **Gate** | **Área**                       | **Evidencia mínima**                                    |
|----------|--------------------------------|---------------------------------------------------------|
| **G1**   | Arquitectura y bounded context | ADRs, SoT, dependency map, module verification          |
| **G2**   | Datos/constraints              | DDL, RLS, tenant tests, constraints green               |
| **G3**   | Backend                        | domain/application tests, Modulith verification         |
| **G4**   | API/Event contracts            | OpenAPI/AsyncAPI + contract compatibility               |
| **G5**   | Frontend/Mobile                | workspaces, states, accessibility, E2E                  |
| **G6**   | Seguridad/auditoría            | Threat model, SoD, step-up, security tests              |
| **G7**   | Integraciones/resiliencia      | timeouts, retry, circuit breaker, UNKNOWN_EFFECT drills |
| **G8**   | QA/UAT                         | test pyramid + UAT evidence                             |
| **G9**   | Migración/operaciones          | CT-16 dry-run, runbooks, observability                  |
| **G10**  | Release/certificación          | DoD, SBOM, release checklist, evidence pack             |

# 

| **DoR**                                                                                                                    | **DoD**                                                                                                                                                  |
|----------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| SoT/frontera aprobada; BR/UC identificadas; policy refs definidas; contratos upstream disponibles; datos/PII clasificados. | DDL/Flyway + tests; OpenAPI/AsyncAPI; backend/frontend/mobile aplicable; security/performance; observability; runbooks; UAT; evidence pack; G1-G10 PASS. |

# 

| **ID**          | **Runbook**                        | **Acción clave**                                                                                             |
|-----------------|------------------------------------|--------------------------------------------------------------------------------------------------------------|
| **RB-EC09-001** | EC-04 unavailable durante promote  | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-002** | Financial UNKNOWN_EFFECT           | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-003** | Report generation stuck            | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-004** | Outbox backlog                     | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-005** | Inbox poison message               | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-006** | RLS policy misconfiguration        | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-007** | Seat pool drift                    | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-008** | Nomination duplicates spike        | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-009** | Identity resolution backlog        | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-010** | Report privacy incident            | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-011** | Unauthorized portal access attempt | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-012** | Document CT-05 unavailable         | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-013** | Delivery provider outage           | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-014** | Stale policy detected              | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-015** | Audience revocation emergency      | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-016** | Engagement cancellation downstream | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-017** | Substitution UNKNOWN_EFFECT        | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-018** | Idempotency lease stuck            | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-019** | OperationStatus stuck RUNNING      | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-020** | Database lock contention           | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-021** | Bulk overload/rate limit           | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-022** | Migration reconciliation mismatch  | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-023** | Disaster recovery/read-only mode   | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-024** | Security secret rotation           | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |
| **RB-EC09-025** | Report hash mismatch               | Detectar → contener → verificar Source of Truth → reconciliar/recuperar → evidenciar → postmortem si aplica. |

# 

| **ADR**          | **Tema**                         | **Decisión**                                                        |
|------------------|----------------------------------|---------------------------------------------------------------------|
| **ADR-EC09-001** | Corporate client master strategy | EXT REF a organization master cuando exista; fallback local mínimo. |
| **ADR-EC09-002** | Engagement versioning            | Material changes create new immutable version.                      |
| **ADR-EC09-003** | Seat pool concurrency            | Transactional counters + optimistic/pessimistic lock where needed.  |
| **ADR-EC09-004** | Bulk enrollment orchestration    | Async batch + per-item idempotency + reconciliation.                |
| **ADR-EC09-005** | Reporting privacy model          | Allowlist metrics + purpose/audience + aggregation threshold.       |
| **ADR-EC09-006** | Financial boundary               | Intent/receipt only; no ledger.                                     |
| **ADR-EC09-007** | Report storage                   | CT-05 document_ref; metadata in EC-09.                              |
| **ADR-EC09-008** | RLS                              | ENABLE/FORCE + SET LOCAL tenant context.                            |
| **ADR-EC09-009** | Outbox claiming                  | SKIP LOCKED + lease/recovery.                                       |
| **ADR-EC09-010** | Mobile scope                     | Read/notification focused; critical admin Web only.                 |

# 

| **Ruta**           | **Artefactos mínimos**                                              |
|--------------------|---------------------------------------------------------------------|
| **/docs**          | EC09-master-summary.md, business-rules.md, use-cases.md             |
| **/openapi**       | ec09-openapi.yaml, examples/, generated-client compatibility report |
| **/asyncapi**      | ec09-asyncapi.yaml, schemas/                                        |
| **/db/migration**  | V090\_\_ec09_schema.sql + subsequent expand/contract migrations     |
| **/architecture**  | context.puml, domain.puml, physical.puml, state-machines.puml       |
| **/adr**           | ADR-EC09-001…                                                       |
| **/backend**       | module source + Modulith verification                               |
| **/frontend**      | feature modules/workspaces/tests                                    |
| **/mobile**        | sponsor/mobile subset when enabled                                  |
| **/tests**         | unit/domain/repository/integration/contract/e2e                     |
| **/performance**   | k6/gatling plans + results                                          |
| **/security**      | threat-model.md, SAST/SCA/SBOM evidence                             |
| **/runbooks**      | RB-EC09-\*                                                          |
| **/observability** | dashboards/alerts/SLOs                                              |
| **/migration**     | CT-16 mappings/dry-run/reconciliation                               |
| **/evidence**      | G1-G10 + UAT + release certification                                |

# 

| **Paso** | **Implementación**                                                                        |
|----------|-------------------------------------------------------------------------------------------|
| **1**    | Crear módulo Spring Modulith ec09 y verificar dependencias permitidas.                    |
| **2**    | Definir aggregates/VOs/policies sin JPA annotations en dominio según baseline.            |
| **3**    | Definir ports hacia CT-01/02/04/05/06/07/10/11/12/16/18, EC-01/02/04/06/07/08 y Finanzas. |
| **4**    | Crear Flyway schema ec09, PK/FK tenant-aware, RLS y roles.                                |
| **5**    | Implementar TenantContext transaccional con SET LOCAL.                                    |
| **6**    | Implementar repositories y mapping persistence.                                           |
| **7**    | Implementar Aggregate Revision Contract y ETag.                                           |
| **8**    | Implementar CorporateClient/TNA use cases.                                                |
| **9**    | Implementar EngagementVersion, lineage/state guards y activation.                         |
| **10**   | Implementar seat pool concurrency.                                                        |
| **11**   | Implementar NominationBatch y validation/dry-run.                                         |
| **12**   | Implementar EnrollmentBatch orchestration con per-item idempotency.                       |
| **13**   | Implementar substitution workflow y reconciliation.                                       |
| **14**   | Implementar ReportingProfile/privacy filter.                                              |
| **15**   | Implementar ReportRun/provenance/document refs.                                           |
| **16**   | Implementar FinancialIntent + UNKNOWN_EFFECT reconcile.                                   |
| **17**   | Implementar durable idempotency lease/recovery.                                           |
| **18**   | Implementar outbox/inbox + SKIP LOCKED.                                                   |
| **19**   | Publicar REST + ProblemDetail + OperationStatus.                                          |
| **20**   | Publicar AsyncAPI/events.                                                                 |
| **21**   | Implementar audit/evidence hooks.                                                         |
| **22**   | Añadir observability/SLO metrics.                                                         |
| **23**   | Ejecutar module/tenant/security/contract/performance tests.                               |
| **24**   | Validar expand/contract N/N-1.                                                            |
| **25**   | Completar G1-G10 y evidence pack.                                                         |

# 

| **Paso** | **Implementación**                                                      |
|----------|-------------------------------------------------------------------------|
| **1**    | Crear feature/ec09 y route structure.                                   |
| **2**    | Generar API client desde OpenAPI; prohibido DTO manual duplicado.       |
| **3**    | Definir query keys tenant/scope-aware.                                  |
| **4**    | Implementar Corporate Workspace shell.                                  |
| **5**    | Implementar TNA Studio.                                                 |
| **6**    | Implementar Engagement Studio tabs y state guards.                      |
| **7**    | Implementar ETag cache/If-Match y conflict UI.                          |
| **8**    | Implementar seat pool editor con live revision.                         |
| **9**    | Implementar Nomination Desk con dry-run grid/virtualization.            |
| **10**   | Implementar Enrollment Batch Console + OperationStatus polling/backoff. |
| **11**   | Implementar Substitution Desk.                                          |
| **12**   | Implementar Reporting Studio + privacy preview.                         |
| **13**   | Implementar Corporate Portal con ABAC scope.                            |
| **14**   | Implementar NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.      |
| **15**   | Implementar ProblemDetail mapper + reason codes.                        |
| **16**   | Implementar evidence/document links CT-05.                              |
| **17**   | Implementar accessibility WCAG 2.2 AA.                                  |
| **18**   | Implementar responsive behavior y mobile deep links.                    |
| **19**   | Implementar tests component/integration/E2E.                            |
| **20**   | Instrumentar analytics/telemetry sin PII.                               |

# 

| **Permiso**              | **PortfolioMgr** | **Consultant** | **Coordinator** | **Approver** | **ReportMgr** | **Sponsor** | **Ops** | **Auditor** |
|--------------------------|------------------|----------------|-----------------|--------------|---------------|-------------|---------|-------------|
| **client.read**          | ✓                | —              | —               | —            | —             | —           | —       | —           |
| **client.write**         | ✓                | —              | —               | —            | —             | —           | —       | —           |
| **tna.write**            | —                | ✓              | —               | —            | —             | —           | —       | —           |
| **tna.approve**          | —                | ✓              | —               | ✓            | —             | —           | —       | —           |
| **engagement.write**     | ✓                | —              | —               | —            | —             | —           | —       | —           |
| **engagement.approve**   | ✓                | —              | —               | ✓            | —             | —           | —       | —           |
| **engagement.activate**  | ✓                | —              | —               | ✓            | —             | —           | —       | —           |
| **engagement.cancel**    | ✓                | —              | —               | ✓            | —             | —           | —       | —           |
| **seat.manage**          | ✓                | —              | ✓               | —            | —             | —           | —       | —           |
| **nomination.manage**    | —                | —              | ✓               | —            | —             | —           | —       | —           |
| **enrollment.promote**   | —                | —              | ✓               | —            | —             | —           | —       | —           |
| **substitution.approve** | —                | —              | —               | ✓            | —             | —           | —       | —           |
| **reporting.manage**     | —                | —              | —               | —            | ✓             | —           | —       | —           |
| **report.generate**      | —                | —              | —               | —            | ✓             | —           | —       | —           |
| **report.publish**       | —                | —              | —               | —            | ✓             | —           | —       | —           |
| **report.deliver**       | —                | —              | —               | —            | ✓             | —           | —       | —           |
| **financial.intent**     | —                | —              | —               | —            | —             | —           | ✓       | —           |
| **reconcile.execute**    | —                | —              | —               | —            | —             | —           | ✓       | —           |
| **audit.read**           | ✓                | —              | —               | —            | —             | —           | ✓       | ✓           |
| **portal.read**          | —                | —              | —               | —            | —             | ✓           | —       | —           |

# 

```
type UiDataState = 'READY' | 'NO_DATA' | 'ZERO' | 'STALE' | 'PARTIAL' | 'UNAVAILABLE' | 'UNKNOWN_EFFECT';

type EngagementVersionDto = {
id: string; engagementId: string; versionNo: number; state: string;
scopeSummary: string; programBindings: ProgramBindingDto[]; seatPools: SeatPoolDto[];
reportingProfileId?: string; etag: string;
};

type BatchItemDto = {
id: string; sourceKey: string; status: string; reasonCode?: string;
personRef?: string; enrollmentRef?: string; receiptRef?: string;
};

type CorporateReportSummaryDto = {
reportRunId: string; state: string; asOf: string; dataState: UiDataState;
provenance: Array<{source:string; asOf:string; status:string}>;
documentRef?: string;
};
```

Los DTOs anteriores ilustran el contrato mínimo. La versión autoritativa vive en OpenAPI y genera el client TypeScript. Toda mutación conserva ETag; toda respuesta de error se normaliza a ProblemDetail con reasonCode/correlationId.

# 

| **\#** | **Control**                                          | **Estado esperado** |
|--------|------------------------------------------------------|---------------------|
| **1**  | Word maestro EC-09 aprobado y versionado.            | PASS                |
| **2**  | OpenAPI/AsyncAPI alineados.                          | PASS                |
| **3**  | 30 tablas EC-09 creadas con Flyway.                  | PASS                |
| **4**  | RLS ENABLE+FORCE probado en toda tabla tenant-owned. | PASS                |
| **5**  | Roles DB separados sin BYPASSRLS runtime.            | PASS                |
| **6**  | Constraints/FKs internas tenant-aware probadas.      | PASS                |
| **7**  | No FK cross-context.                                 | PASS                |
| **8**  | State guards y history immutability probados.        | PASS                |
| **9**  | Aggregate Revision/ETag probado en child mutations.  | PASS                |
| **10** | Idempotency lease/recovery probado.                  | PASS                |
| **11** | Outbox SKIP LOCKED/lease probado.                    | PASS                |
| **12** | OperationStatus/UNKNOWN_EFFECT probado.              | PASS                |
| **13** | Bulk nomination/enrollment partial success probado.  | PASS                |
| **14** | Seat race/concurrency probado.                       | PASS                |
| **15** | Reporting privacy/aggregation probado.               | PASS                |
| **16** | Financial boundary/reconciliation probado.           | PASS                |
| **17** | RBAC/ABAC/SoD/step-up probado.                       | PASS                |
| **18** | Threat Model mitigado.                               | PASS                |
| **19** | SAST/SCA/secrets/SBOM/container scans PASS.          | PASS                |
| **20** | Observability/SLO dashboards activos.                | PASS                |
| **21** | Migration CT-16 dry-run/reconcile PASS.              | PASS                |
| **22** | Golden Scenarios PASS.                               | PASS                |
| **23** | UAT institucional PASS.                              | PASS                |
| **24** | G1-G10 con evidencia.                                | PASS                |
| **25** | Runbooks ensayados.                                  | PASS                |
| **26** | Frontend WCAG 2.2 AA baseline.                       | PASS                |
| **27** | Mobile scope restringido validado.                   | PASS                |
| **28** | AI eval/provenance validado.                         | PASS                |
| **29** | Expand/contract N/N-1 validado.                      | PASS                |
| **30** | Evidence Pack y release certification firmados.      | PASS                |

# 

| **\#** | **Garantía no negociable**                                                                             |
|--------|--------------------------------------------------------------------------------------------------------|
| **1**  | TenantContext se deriva de autorización; nunca del body.                                               |
| **2**  | PostgreSQL RLS ENABLE+FORCE en toda tabla tenant-owned.                                                |
| **3**  | Runtime role no posee tablas ni BYPASSRLS.                                                             |
| **4**  | FKs internas críticas incluyen tenant_id.                                                              |
| **5**  | No existen FKs cross-context.                                                                          |
| **6**  | EngagementVersion activa/publicada es inmutable.                                                       |
| **7**  | Cambios materiales crean nueva versión con lineage.                                                    |
| **8**  | Program/Edition/Offering se pinnean explícitamente; nunca latest.                                      |
| **9**  | Corporate Client no se confunde con Person/Participant.                                                |
| **10** | SeatPool no se confunde con Enrollment.                                                                |
| **11** | Nomination no se confunde con Registration/Enrollment.                                                 |
| **12** | Bulk processing conserva idempotencia por item y partial success.                                      |
| **13** | Sustituciones son no destructivas y auditables.                                                        |
| **14** | ETag representa revisión del aggregate completo.                                                       |
| **15** | Mutación de hijo incrementa root revision.                                                             |
| **16** | Idempotency-Key sensible es durable con lease/recovery.                                                |
| **17** | Outbox/inbox son obligatorios para eventos críticos.                                                   |
| **18** | Outbox multi-instancia usa SKIP LOCKED/lease.                                                          |
| **19** | 202 siempre expone OperationStatus.                                                                    |
| **20** | UNKNOWN_EFFECT se reconcilia antes de retry.                                                           |
| **21** | Finanzas es SoT de deuda/pago/factura/saldo.                                                           |
| **22** | CT-05 es SoT de documentos/blobs.                                                                      |
| **23** | EC-04 es SoT de Enrollment.                                                                            |
| **24** | EC-06/07/08 son SoT de attendance/completion/credential.                                               |
| **25** | ReportingProfile limita purpose/audience/fields/granularity.                                           |
| **26** | Corporate Report no es raw personal data dump.                                                         |
| **27** | Published ReportRun es snapshot inmutable con asOf/provenance.                                         |
| **28** | Frontend distingue NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.                              |
| **29** | ProblemDetail usa reason codes estables.                                                               |
| **30** | OpenAPI/AsyncAPI son contratos ejecutables.                                                            |
| **31** | Frontend consume client generado, no DTO manual paralelo.                                              |
| **32** | RBAC + ABAC + SoD + step-up aplican a operaciones críticas.                                            |
| **33** | Logs/traces no contienen PII innecesaria.                                                              |
| **34** | AI pasa por CT-12 y no posee autoridad decisoria.                                                      |
| **35** | Migration pasa por CT-16; no direct INSERT.                                                            |
| **36** | Secure SDLC bloquea Critical/High no exceptuados.                                                      |
| **37** | Migraciones productivas siguen expand/contract N/N-1.                                                  |
| **38** | Runbooks y SLOs forman parte del release.                                                              |
| **39** | Mobile no replica operaciones administrativas de alto riesgo.                                          |
| **40** | Toda corrección relevante preserva historia.                                                           |
| **41** | Cada Gate G1-G10 requiere evidencia.                                                                   |
| **42** | Un módulo no está terminado hasta renderizar el DOCX completo y revisar visualmente todas sus páginas. |

| **CERTIFICACIÓN — EC-09 solo puede declararse listo para producción cuando implementación, contratos, datos, seguridad, QA, operaciones y evidencia satisfacen este documento y G1-G10.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
