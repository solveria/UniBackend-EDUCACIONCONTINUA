**PEOPLEU IA**

**EC-04**

**PROSPECTOS, PARTICIPANTES, REGISTRO,  
PREINSCRIPCIÓN, INSCRIPCIÓN, CUPOS Y  
LISTAS DE ESPERA**

Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Control**        | **Valor**                                                                                                      |
|--------------------|----------------------------------------------------------------------------------------------------------------|
| **Código**         | EC-04                                                                                                          |
| **Versión**        | V1.0                                                                                                           |
| **Estado**         | VIGENTE — ESPECIFICACIÓN IMPLEMENTABLE FULLSTACK ENTERPRISE                                                    |
| **Baseline**       | EC-00 V1.1 · EC-01 V1.1 — Plantilla Oficial FullStack Enterprise · EC-02 V1.0 · EC-03 V1.0                     |
| **Vertical**       | Educación Continua / Formación Continua                                                                        |
| **Arquitectura**   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| **Stack objetivo** | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| **Contexto**       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| **Fecha base**     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS —** Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA —** EC-04 es Source of Truth del vínculo operativo de participantes con una oferta EC: prospect case, participant role, registration, capacidad, waitlist, pre-enrollment y enrollment. PERSON pertenece a CT-04; OFFERING a EC-02; QUOTE a EC-03; PAYMENT/DEBT a Finanzas; ATTENDANCE a EC-06; COMPLETION a EC-07. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaración de propósito, autoridad y baseline

| **V1.0 — FULLSTACK ENTERPRISE —** EC-04 adopta íntegramente el contrato de plantilla EC-01 V1.1: RLS ENABLE+FORCE, Aggregate Revision Contract, state transition guards, idempotencia durable, outbox/inbox con lease, OperationStatus para 202/UNKNOWN_EFFECT, API paginada, Threat Model, Secure SDLC, expand/contract N/N-1 y bootstrap reproducible. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Este documento operacionaliza AM-00, CT-00, CT-01…CT-18 y EC-00 V1.1 para construir el bounded context de vinculación de Educación Continua. Su responsabilidad es convertir interés en participación institucional trazable sin duplicar Person, sin mezclar admisión con pago y sin permitir que la falta de cupo, una integración caída o un retry genere matrículas inconsistentes.

EC-04 debe soportar inscripción individual, autoservicio, atención por ventanilla, importación masiva, nominación corporativa, cupos segmentados, listas de espera, ventanas de aceptación, preinscripciones con condiciones, matrícula oficial, transferencias y retiros. La solución debe operar con alta frecuencia durante todo el año, no asumir calendario semestral y preservar historia institucional de cada decisión.

| **CRITERIO DE ÉXITO —** Dos equipos Senior independientes deben poder implementar el mismo comportamiento observable: una persona no se duplica, una registration no consume cupo por sí sola, un seat no se sobreasigna, una waitlist no inventa prioridad, un enrollment no nace sin policy/evidence suficiente y ningún timeout remoto se resuelve con retry ciego. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquía documental aplicable

| **Prioridad**  | **Documento/artefacto**                | **Rol**                                                                    |
|----------------|----------------------------------------|----------------------------------------------------------------------------|
| **1**          | AM-00 vigente                          | Constitución arquitectónica superior.                                      |
| **2**          | CT-00 vigente                          | Contrato maestro transversal.                                              |
| **3**          | CT-01…CT-18 vigentes                   | Capacidades compartidas, seguridad, policy, identity y fronteras.          |
| **4**          | EC-00 V1.1                             | Constitución funcional/arquitectónica de Educación Continua.               |
| **5**          | EC-01 V1.1                             | Plantilla oficial FullStack Enterprise.                                    |
| **6**          | EC-02 / EC-03 vigentes                 | Contratos upstream de Offering/Edition y Commercial Quote.                 |
| **7**          | EC-04 V1.0 (este documento)            | Especificación implementable de vinculación, cupos, waitlist y enrollment. |
| **Ejecutable** | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación y evidencia alineadas al Word.                              |

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

## 0.3 Decisiones arquitectónicas EC04-DA

| **ID**          | **Decisión normativa**                                                                                                                         |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| **EC04-DA-001** | PERSON ≠ PARTICIPANT ≠ IAM USER. CT-04 posee Person; EC-04 posee ParticipantProfile como rol EC; IAM posee autenticación.                      |
| **EC04-DA-002** | PROSPECT CASE ≠ PERSON. Un prospecto puede existir con contact_point_ref hasta que CT-04 resuelva identidad; EC-04 no crea un Person paralelo. |
| **EC04-DA-003** | REGISTRATION REQUEST ≠ ENROLLMENT. Registration expresa intención/admisión; Enrollment es el hecho oficial de matrícula.                       |
| **EC04-DA-004** | REGISTRATION ≠ PAYMENT. EC-04 puede exigir financial_clearance_ref, pero deuda/pago/factura/saldo pertenecen a Finanzas.                       |
| **EC04-DA-005** | OFFERING ≠ CAPACITY POOL. EC-02 posee Offering; EC-04 posee capacidad admisible enforceable y su ocupación.                                    |
| **EC04-DA-006** | SEAT RESERVATION ≠ ENROLLMENT. Un hold consume temporalmente capacidad pero no concede condición académica definitiva.                         |
| **EC04-DA-007** | WAITLIST ENTRY ≠ RESERVED SEAT. Entrar a waitlist no consume cupo ni garantiza matrícula.                                                      |
| **EC04-DA-008** | WAITLIST PRIORITY ≠ AI SCORE. La prioridad oficial proviene de policy determinista/auditable; IA solo puede recomendar acciones.               |
| **EC04-DA-009** | PRE_ENROLLMENT ≠ ENROLLMENT. PreEnrollment conserva condiciones y seat hold; solo READY puede convertirse por comando transaccional.           |
| **EC04-DA-010** | CORPORATE CLIENT ≠ PARTICIPANT. EC-09 gobierna cliente/acuerdo/lote corporativo; EC-04 crea registrations/enrollments individuales.            |
| **EC04-DA-011** | ELIGIBILITY RULE ≠ ELIGIBILITY DECISION ≠ ADMISSION DECISION. CT-15 posee regla/decisión; EC-04 combina evidencia y capacity para admission.   |
| **EC04-DA-012** | IDENTITY VERIFICATION ≠ LOCAL PII. CT-04/IAM verifica; EC-04 conserva receipt/ref y assurance level, no biometría ni documentos crudos.        |
| **EC04-DA-013** | DOCUMENT ≠ DOCUMENT BINDING. CT-05 posee artefacto; EC-04 conserva purpose/document_ref/verification state.                                    |
| **EC04-DA-014** | CONSENT ≠ BOOLEAN. Consentimiento se referencia como receipt versionado CT-10/CT-05; no un checkbox sin lineage.                               |
| **EC04-DA-015** | CAPACITY COUNTERS = DEFENSIVE DB INVARIANT. SeatReservation/Enrollment actualizan counters bajo row lock; PostgreSQL bloquea oversubscription. |
| **EC04-DA-016** | OVERBOOK ≠ SILENT EXTRA SEAT. overbook_limit es explícito, policy-driven, auditado y nunca inferido por Backend.                               |
| **EC04-DA-017** | WAITLIST ORDER = POLICY + STABLE TIE-BREAK. priority bucket/score + enqueued_at + id forman orden reproducible.                                |
| **EC04-DA-018** | TRANSFER ≠ UPDATE edition_ref. Transferencia cierra historia origen y crea nuevo Enrollment con lineage; no reescribe hechos previos.          |
| **EC04-DA-019** | WITHDRAWAL ≠ REFUND. Retiro académico publica hechos; Finanzas decide/reconcilia efecto económico.                                             |
| **EC04-DA-020** | HISTORY ≠ CURRENT ROW ONLY. EnrollmentStatusHistory es append-only y la historia no se borra.                                                  |
| **EC04-DA-021** | TENANT-AWARE FK ≠ TENANT ISOLATION. RLS ENABLE+FORCE y roles DB separados son obligatorios.                                                    |
| **EC04-DA-022** | AGGREGATE REVISION ≠ ROOT ROW ONLY. Cambios de requirements/receipts relevantes bump de RegistrationRequest version.                           |
| **EC04-DA-023** | IDEMPOTENCY IN_PROGRESS ≠ FOREVER. Comandos sensibles usan owner/lease/recovery durable.                                                       |
| **EC04-DA-024** | OUTBOX PENDING ≠ CLAIMED. Workers multi-instancia usan SKIP LOCKED + lease + recovery.                                                         |
| **EC04-DA-025** | 202 ACCEPTED ≠ EFFECT CONFIRMED. Bulk/import/reconciliation devuelven operationId consultable.                                                 |
| **EC04-DA-026** | REMOTE TIMEOUT ≠ FAILURE. Si el efecto pudo ocurrir, se registra UNKNOWN_EFFECT y se reconcilia antes de retry.                                |
| **EC04-DA-027** | NO_DATA ≠ ZERO ≠ STALE ≠ PARTIAL ≠ UNAVAILABLE ≠ UNKNOWN_EFFECT. Frontend muestra estados distintos.                                           |
| **EC04-DA-028** | PATCH ≠ GENERIC DOMAIN SETTER. Transiciones, waitlist, enrollment, transfer y withdrawal son commands explícitos.                              |
| **EC04-DA-029** | BULK REGISTRATION ≠ DIRECT INSERT. RegistrationBatch promueve item por item mediante dominio/idempotencia/receipts.                            |
| **EC04-DA-030** | PERSON MATCH ≠ AI AUTO-MERGE. CT-04 resuelve identidad; IA puede sugerir candidatos, nunca fusiona personas automáticamente.                   |
| **EC04-DA-031** | OPENAPI/ASYNCAPI ≠ DOCUMENTATION ONLY. Generan client/tests y compatibility gates.                                                             |
| **EC04-DA-032** | SCHEMA RELEASE ≠ APP RELEASE. Flyway productivo usa expand/contract N/N-1; no migrations destructivas one-shot.                                |
| **EC04-DA-033** | MOBILE ≠ ADMIN CONSOLE. Mobile habilita self-registration/seat offer/estado; cambios críticos de capacidad y void quedan Web/step-up.          |
| **EC04-DA-034** | ENROLLMENT CREATED ≠ COMPLETION. EC-07 determina completion; EC-04 no cierra académicamente por status de matrícula.                           |

## 0.4 Criterio de suficiencia FullStack y regla de plantilla

EC-04 es suficiente cuando un Senior Backend puede implementar locks/counters/state machines sin conocimiento tribal, un Senior Frontend puede construir workspaces completos desde OpenAPI y estados de servicio, QA puede convertir BR/GS en suites ejecutables, y Seguridad puede demostrar aislamiento multi-tenant, SoD y step-up con evidencia reproducible.

| **REGLA DE CONTINUIDAD —** EC-05…EC-12 no pueden redefinir Person, Participant, Registration, Enrollment, capacity o waitlist. Si necesitan extender semántica, deben consumir los IDs/contratos EC-04 o elevar un ADR de compatibilidad. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 1. Índice operativo del documento

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal de reglas BR-EC04

- 10\. Casos de uso UC-EC04

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

EC-04 resuelve la transición desde interés hasta matrícula oficial en Educación Continua. En esta vertical, una universidad puede abrir múltiples ediciones durante el año, recibir registros individuales o corporativos, vender cupos limitados, manejar listas de espera y exigir condiciones distintas por programa. Sin un bounded context explícito, aparecen duplicados de persona, oversubscription, matrículas creadas por pago, waitlists manuales sin criterio, transferencias destructivas y estados imposibles de auditar.

El diseño separa prospecto, rol de participante, solicitud, elegibilidad, capacidad, reserva temporal, lista de espera, preinscripción y matrícula. Cada paso tiene ownership, state machine y evidencia. La regla fundamental es que el sistema nunca debe “inferir” Enrollment por la existencia de un pago, una quote aceptada o un status de UI: la matrícula nace por un caso de uso de dominio con policy, identity, capacity y audit completos.

## 2.1 Incluido

- ProspectCase con purpose/provenance y conversión gobernada.

- ParticipantProfile como rol EC sobre Person CT-04.

- RegistrationInvitation con token hash, expiración y corporate nomination.

- RegistrationRequest individual por Offering/Edition/Cohort.

- RegistrationBatch e items para group/corporate/import.

- IdentityAssuranceReceipt y EligibilityDecisionReceipt como evidencias externas pinneadas.

- RegistrationRequirements y resultados append-only.

- CapacityPool con segmentos, FIXED/UNLIMITED, overbook explícito y counters defensivos.

- SeatReservation durable con expiry/consume/release.

- WaitlistEntry y WaitlistOffer con ordering reproducible y promotion segura.

- PreEnrollment con condiciones y ventana de conversión.

- Enrollment oficial con version pinning, lineage y status history.

- Transferencias y retiros no destructivos.

- Bindings a documentos/consentimientos sin almacenar blobs/PII.

- APIs, eventos, RLS, idempotencia, outbox/inbox, observabilidad, seguridad, QA, UAT, migración y Mobile.

## 2.2 Fuera de alcance

- Crear/editar Person o datos personales canónicos — CT-04.

- Autenticación, MFA, password, session — IAM.

- Diseñar programa/versión académica — EC-01.

- Crear ProgramEdition/Offering/calendario/scheduling — EC-02 + CT-03/13.

- Calcular precio/promoción/beca/quote — EC-03.

- Registrar deuda/pago/factura/saldo/reembolso — Core Financiero.

- Asignar instructor/material/LMS — EC-05/CT-18.

- Registrar asistencia/engagement — EC-06.

- Evaluar/completion/cierre académico — EC-07.

- Emitir certificado/credential award — EC-08.

- Ser Source of Truth de contrato/cliente corporativo — EC-09.

- Calcular trayectoria acumulativa — EC-10.

- Guardar documentos/binarios — CT-05.

- Implementar motor de workflow, notificaciones, eligibility o migración local — CT-06/07/15/16.

| **ANTI-SCOPE —** EC-04 no debe convertirse en CRM + checkout + ledger + LMS. Solo gobierna el vínculo operativo y académico de ingreso a una ejecución EC; todo hecho ajeno se referencia mediante contrato y receipt. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Término**                     | **Definición normativa**                                                                 |
|---------------------------------|------------------------------------------------------------------------------------------|
| **ProspectCase**                | Caso de interés previo a Registration; puede estar unresolved respecto de Person.        |
| **Person**                      | Identidad canónica CT-04; no se duplica en EC-04.                                        |
| **ParticipantProfile**          | Rol EC estable asociado a person_ref; no es IAM User ni matrícula.                       |
| **RegistrationInvitation**      | Invitación segura a iniciar registration; no garantiza cupo.                             |
| **RegistrationRequest**         | Solicitud de ingreso a Offering; no consume seat por sí sola.                            |
| **RegistrationBatch**           | Lote de intake; cada persona sigue siendo participante individual.                       |
| **EligibilityDecisionReceipt**  | Snapshot/receipt de decisión CT-15; no es policy local.                                  |
| **IdentityAssuranceReceipt**    | Receipt de nivel/verificación de identidad CT-04/IAM; no contiene biometría.             |
| **RegistrationRequirement**     | Condición que bloquea/permite avance; deriva de policy.                                  |
| **CapacityPool**                | Cupo enforceable EC-04 para Offering/Cohort/segment.                                     |
| **SeatReservation**             | Hold temporal durable de capacidad.                                                      |
| **WaitlistEntry**               | Lugar lógico en lista de espera; no seat.                                                |
| **WaitlistOffer**               | Oferta temporal sobre seat disponible, con expiración.                                   |
| **PreEnrollment**               | Vínculo condicional con seat reservado; todavía no matrícula.                            |
| **Enrollment**                  | Hecho oficial de matrícula EC.                                                           |
| **EnrollmentStatusHistory**     | Historia append-only del lifecycle de Enrollment.                                        |
| **TransferRequest**             | Cambio gobernado que crea nuevo enrollment; no reescribe el original.                    |
| **WithdrawalRequest**           | Solicitud de retiro/cancelación académica; no es refund.                                 |
| **FinancialClearanceRef**       | Referencia al hecho financiero requerido por policy; Finanzas es SoT.                    |
| **CommercialQuoteRef**          | Quote EC-03 pinneada; no convierte automáticamente a Enrollment.                         |
| **CorporateEnrollmentBatchRef** | Contexto EC-09 que nomina/patrocina participantes; la empresa no es Participant.         |
| **DocumentBinding**             | Referencia a documento CT-05 aplicada a registration/enrollment.                         |
| **ConsentReceiptBinding**       | Referencia versionada a consentimiento CT-10/05; no boolean simple.                      |
| **AggregateRevision**           | Revisión ETag del aggregate completo, incluidos hijos relevantes.                        |
| **EXT REF**                     | Referencia cross-context sin FK física; se valida por port/contract.                     |
| **UNKNOWN_EFFECT**              | Efecto remoto no confirmable después de timeout; requiere reconciliation antes de retry. |
| **NO_DATA**                     | La consulta fue válida y no hay registros.                                               |
| **ZERO**                        | Existe medición/counter y su valor es 0.                                                 |
| **STALE**                       | Hay dato previo conocido pero no suficientemente fresco.                                 |
| **PARTIAL**                     | Solo una parte de la información pudo resolverse.                                        |
| **UNAVAILABLE**                 | Dependencia no pudo responder; no equivale a ausencia.                                   |
| **PolicyVersionRef**            | Referencia inmutable a policy aplicable para reconstrucción histórica.                   |

# 4. Bounded Context y matriz Source of Truth

EC-04 conserva solo verdades necesarias para ingreso y matrícula. Cuando otro contexto es Source of Truth, persiste IDs externos, hashes/snapshots autorizados y receipts; no replica tablas para simplificar joins. Toda dependencia crítica declara freshness y comportamiento ante STALE/UNAVAILABLE/UNKNOWN_EFFECT.

| **Información**                                                  | **Source of Truth** | **EC-04 almacena/referencia**  | **Regla**                                           |
|------------------------------------------------------------------|---------------------|--------------------------------|-----------------------------------------------------|
| **Tenant/sede/campus/scope**                                     | CT-01               | tenant_id + scope refs         | Sí, contexto autorizado; sin FK cross-context.      |
| **Policies/catálogos**                                           | CT-02               | PolicyVersion refs/snapshots   | No thresholds hardcodeados.                         |
| **Temporalidad**                                                 | CT-03               | timestamps/refs necesarios     | No calendario local.                                |
| **Persona canónica**                                             | CT-04               | person_ref                     | No nombre/email/teléfono duplicado.                 |
| **Documentos**                                                   | CT-05               | document_ref/evidence_ref      | No blobs.                                           |
| **Workflow**                                                     | CT-06               | workflow_ref/decision refs     | EC-04 conserva decisión semántica propia.           |
| **Notificaciones**                                               | CT-07               | request/receipt refs           | Mensaje fallido no revierte Enrollment.             |
| **i18n**                                                         | CT-08               | keys/preferred language        | Presentación, no identidad.                         |
| **Integración**                                                  | CT-09               | outbox/inbox/contracts         | At-least-once + dedup.                              |
| **Audit/privacy**                                                | CT-10               | audit/evidence/consent refs    | Purpose limitation/PII minimization.                |
| **Analytics**                                                    | CT-11               | hechos publicados              | Sin shadow BI.                                      |
| **IA**                                                           | CT-12               | run/eval refs                  | Recommendation ≠ admission.                         |
| **Scheduling**                                                   | CT-13               | No ownership                   | EC-02/CT-13.                                        |
| **Resources**                                                    | CT-14               | No ownership                   | Capacity seat ≠ room capacity.                      |
| **Elegibilidad**                                                 | CT-15               | decision receipts              | CT-15 decide rule; EC-04 usa resultado.             |
| **Migración/DQ**                                                 | CT-16               | lineage/receipts               | No INSERT directo.                                  |
| **Continuidad**                                                  | CT-17               | runbook refs                   | Degraded mode gobernado.                            |
| **LMS/ecosistema**                                               | CT-18               | refs downstream                | No provisioning aquí.                               |
| **ProgramVersion**                                               | EC-01               | program_version_ref            | Pin histórico.                                      |
| **Edition/Offering/Cohort**                                      | EC-02               | EXT refs                       | EC-04 no edita oferta.                              |
| **Quote/commercial decision**                                    | EC-03               | commercial_quote_ref           | No recalcula dinero.                                |
| **Debt/payment/invoice**                                         | Finanzas            | financial_clearance_ref        | Academic system ≠ financial ledger.                 |
| **Corporate client/agreement/batch**                             | EC-09               | corporate_enrollment_batch_ref | Empresa ≠ participant.                              |
| **ParticipantProfile/Registration/Capacity/Waitlist/Enrollment** | EC-04               | Sí                             | Source of Truth local.                              |
| **Attendance**                                                   | EC-06               | No                             | Consume enrollment_id.                              |
| **Completion**                                                   | EC-07               | No                             | Consume enrollment_id; no status local equivalente. |
| **Credential issuance**                                          | EC-08               | No                             | Consume completion/participant refs.                |

# 5. Dependencias CT-01 a CT-18, cores y otros módulos

| **Dependencia** | **Responsabilidad**       | **Contrato EC-04**                                | **Frontera/fallo**                             |
|-----------------|---------------------------|---------------------------------------------------|------------------------------------------------|
| **CT-01**       | Scope institucional       | scope refs + authorization                        | Fail-closed para mutaciones críticas.          |
| **CT-02**       | Policies/catálogos        | admission/capacity/waitlist refs                  | Versionadas, cacheables.                       |
| **CT-03**       | Temporalidad              | timestamps/expiry semantics                       | UTC; no calendar engine local.                 |
| **CT-04**       | Person/identity           | person_ref + resolution/verification receipts     | No duplicate PII.                              |
| **CT-05**       | Docs/evidence             | document/evidence refs                            | No blobs.                                      |
| **CT-06**       | Workflow                  | waiver/transfer/withdrawal approvals              | Workflow no cambia invariantes DB.             |
| **CT-07**       | Notifications             | invite/waitlist/enrollment notifications          | Post-commit; no rollback de negocio.           |
| **CT-08**       | i18n                      | labels/preferred locale                           | No duplicate states.                           |
| **CT-09**       | Integration governance    | schemas/contracts                                 | Outbox/inbox.                                  |
| **CT-10**       | Security/audit/privacy    | consent, purpose, evidence                        | Critical audit.                                |
| **CT-11**       | Analytics                 | funnel/capacity facts                             | Event-fed datasets.                            |
| **CT-12**       | AI                        | triage/suggestion                                 | No auto-enrollment/priority manipulation.      |
| **CT-13**       | Scheduling                | No owner                                          | Solo consume EC-02 refs.                       |
| **CT-14**       | Resources                 | No owner                                          | Seat capacity ≠ room resource.                 |
| **CT-15**       | Eligibility               | evaluate rules/decision refs                      | Fail-closed where mandatory.                   |
| **CT-16**       | Migration/DQ              | dry-run/promotion                                 | No direct INSERT.                              |
| **CT-17**       | Continuity                | RTO/RPO/runbooks                                  | Read-only/degraded intake según policy.        |
| **CT-18**       | Ecosystem                 | identity/document external adapters when governed | No vendor-specific core.                       |
| **IAM**         | Auth/MFA/roles            | actor/subject/assurance                           | Step-up para void/overbook/admin.              |
| **EC-01**       | Academic definition       | ProgramVersion pin                                | Read-only contract.                            |
| **EC-02**       | Edition/Offering/Cohort   | Offering snapshot/status                          | Registration only against admissible offering. |
| **EC-03**       | Commercial quote          | Quote/clearance refs                              | No local pricing.                              |
| **EC-09**       | Corporate training        | corporate batch/agreement refs                    | No local contract copy.                        |
| **Finance**     | Financial facts           | clearance/query status                            | UNKNOWN_EFFECT + reconciliation.               |
| **EC-06/07/08** | Downstream academic facts | EnrollmentCreated/Withdrawn events                | No cross-context writes.                       |

# 6. Arquitectura funcional E2E y journeys

<img src="media/image1.png" style="width:7.2in;height:4.3649in" />

Figura 1 — EC-04 dentro de la vertical y capacidades transversales

| **Journey**   | **Nombre**                  | **Flujo E2E**                                                                                                                                                |
|---------------|-----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **J-EC04-01** | Self-registration           | Participant resuelve/crea ParticipantProfile → Registration DRAFT → submit → identity/eligibility → capacity → pre-enrollment/enrollment → outbox.           |
| **J-EC04-02** | Sin cupo                    | Registration ELIGIBLE → Capacity FULL → WaitlistEntry ACTIVE → liberación seat → WaitlistOffer + SeatReservation → aceptación → PreEnrollment/Enrollment.    |
| **J-EC04-03** | Corporate nomination        | EC-09 batch/invitations → RegistrationBatch items → CT-04 person resolution → registrations individuales → capacity segment → enrollment individual.         |
| **J-EC04-04** | Registro masivo             | CT-16 normalized batch → dry-run → 202 OperationStatus → item-by-item promotion idempotente → PARTIAL/SUCCEEDED + receipts.                                  |
| **J-EC04-05** | Pre-enrollment condicionado | Eligibility CONDITIONAL → requirements → seat HELD → evidence/document/clearance → READY → create Enrollment atomic.                                         |
| **J-EC04-06** | Pago/clearance caído        | Finance timeout tras request → effect receipt UNKNOWN_EFFECT → seat hold se conserva según policy → reconcile before retry.                                  |
| **J-EC04-07** | Transferencia               | Enrollment ACTIVE → TransferRequest → reserve destination seat → approve → create new Enrollment + source TRANSFERRED + release/consume counters atomically. |
| **J-EC04-08** | Retiro                      | WithdrawalRequest → approval if required → Enrollment WITHDRAWN → capacity release → downstream event → financial follow-up reference.                       |
| **J-EC04-09** | Invitación expirada         | Invite token valid but expired → 410/422 reason → no registration, no seat, audit/rate-limit.                                                                |
| **J-EC04-10** | Concurrencia último cupo    | N registrations intentan último seat → row lock CapacityPool → exactamente una reservation HELD; resto waitlist/409 according policy.                        |
| **J-EC04-11** | Duplicate click/retry       | Same Idempotency-Key + payload replays enrollment result; different payload returns 409; no duplicate enrollment.                                            |
| **J-EC04-12** | Dependencia STALE           | Offering read model STALE → UI marca STALE; mutation revalida EC-02 live contract antes de submit/enroll.                                                    |

# 7. Modelo de dominio: Aggregates, Entities, Value Objects, Policies y Domain Services

<img src="media/image2.png" style="width:7.2in;height:5.39588in" />

Figura 2 — Modelo de dominio lógico EC-04

## 7.1 Aggregate Root — ParticipantProfile

ParticipantProfile representa el rol EC de una persona canónica. Su identidad estable permite múltiples registrations y enrollments a lo largo del tiempo sin convertir cada matrícula en una nueva persona. El business key participant_code queda estable y las restricciones se gobiernan sin copiar PII.

## 7.2 Aggregate Root — ProspectCase

ProspectCase gobierna interés previo a registration. Puede operar con contact_point_ref hasta que CT-04 resuelva person_ref; la conversión es un comando idempotente que conserva lineage, no un UPDATE que borra el estado previo.

## 7.3 Aggregate Root — RegistrationRequest

RegistrationRequest es el aggregate central de admisión. Contiene requirements y consume receipts de identity/eligibility. Toda mutación de hijos relevante bumpa la revisión del root; If-Match protege el aggregate completo.

## 7.4 Aggregate Root — CapacityPool

CapacityPool gobierna cupos y counters bajo locks transaccionales. SeatReservation, waitlist y enrollment operan sobre él; la base debe impedir oversubscription incluso ante bugs de aplicación.

## 7.5 Aggregate — WaitlistEntry / WaitlistOffer

WaitlistEntry conserva ordering inputs estables. Promotion crea WaitlistOffer con ventana y SeatReservation asociada; la notificación es secundaria y no constituye el hecho de offer.

## 7.6 Aggregate Root — PreEnrollment

PreEnrollment expresa que existe una vía concreta a matrícula con seat y evidencias pinneadas. Las condiciones pueden satisfacerse asincrónicamente, pero CONVERTED solo ocurre junto a la creación de Enrollment.

## 7.7 Aggregate Root — Enrollment

Enrollment es el hecho académico oficial de vinculación a una ejecución. Pinnea ProgramVersion/Edition/Offering/Cohort y nunca se reescribe para simular transferencia. Estados terminales preservan historia y liberan capacity según reglas físicas.

## 7.8 Workflow Aggregates — Transfer / Withdrawal

TransferRequest y WithdrawalRequest encapsulan excepciones de lifecycle con SoD, reason/evidence y efectos downstream. No son simples cambios de estado desde UI.

## 7.9 Value Objects

| **Value Object**          | **Semántica**                                                  |
|---------------------------|----------------------------------------------------------------|
| **ParticipantCode**       | Business key tenant-aware estable.                             |
| **RegistrationNumber**    | Número legible único; no sustituye UUID.                       |
| **OfferingRef**           | ExternalRef EC-02 + contract authority.                        |
| **PolicyVersionRef**      | Policy inmutable reconstruible.                                |
| **AggregateRevision**     | ETag/If-Match del aggregate completo.                          |
| **SeatLease**             | held_at + expires_at + state; durable.                         |
| **WaitlistPriority**      | bucket + score + enqueued_at + deterministic tie-break.        |
| **AssuranceLevel**        | Nivel de identidad requerido/alcanzado, no credencial secreta. |
| **RequirementCode**       | Código estable de condición.                                   |
| **FinancialClearanceRef** | Receipt/ID externo, no saldo local.                            |
| **ReasonCode**            | Código estable audit/ProblemDetail.                            |
| **ExternalRef**           | ID opaco + owner contract; sin FK cross-context.               |

## 7.10 Domain Policies

- RegistrationAdmissionPolicy — qué condiciones bloquean avance y cuándo revalidar.

- CapacityAllocationPolicy — segmentación, fixed/unlimited, overbook, hold duration.

- WaitlistPriorityPolicy — bucket/score determinista y reglas de promoción.

- PreEnrollmentPolicy — ventana, requisitos y condiciones de READY.

- EnrollmentCreationPolicy — invariantes para crear matrícula oficial.

- TransferPolicy — elegibilidad/capacidad destino y tratamiento de historia.

- WithdrawalPolicy — estados permitidos, effective time y approvals.

- IdentityAssurancePolicy — assurance por tipo de programa/credencial.

- BulkIntakePolicy — límites, batch chunking y partial failure.

- PrivacyPurposePolicy — purpose/retention/profiling permitido.

## 7.11 Domain Services

- ParticipantResolverService — coordina CT-04 sin crear identity local paralela.

- RegistrationValidationService — compone requirements, receipts y policy.

- CapacityAllocatorService — lock pool, hold/release/consume seat de forma determinista.

- WaitlistPromotionService — selecciona candidato reproducible y crea offer+seat atómicos.

- EnrollmentCreationService — revalida preconditions y genera enrollment + history + outbox.

- TransferExecutionService — lock ordenado de pools, create destination enrollment, close source.

- RegistrationBatchProcessor — item-by-item idempotent promotion + OperationStatus.

- ReconciliationService — resuelve UNKNOWN_EFFECT de dependencias externas.

## 7.12 Aggregate Revision Contract — patrón obligatorio

RegistrationRequest.version representa la revisión del aggregate completo. Un cambio en RegistrationRequirement o un nuevo receipt que cambia el estado admisible debe bloquear el root, verificar If-Match cuando la mutación viene de usuario y bump de version en la misma transacción. CapacityPool, SeatReservation, WaitlistEntry, PreEnrollment y Enrollment exponen su propia revisión observable.

| **Paso** | **Contrato**                                               |
|----------|------------------------------------------------------------|
| **1**    | Resolver tenant desde SecurityContext; nunca desde body.   |
| **2**    | Abrir transacción y SET LOCAL peopleu.tenant_id.           |
| **3**    | Cargar/lock root y comparar expected aggregate revision.   |
| **4**    | Ejecutar método de intención; no repository child directo. |
| **5**    | Persistir hijos/receipts y bump root atómico.              |
| **6**    | Audit/outbox/idempotency según comando.                    |
| **7**    | Responder ETag nuevo; mismatch =\> 412 sin efectos.        |

| **PRUEBA NO NEGOCIABLE —** Dos operadores abren Registration ETag 9. A satisface un requirement y el root pasa a 10. B intenta cancelar con If-Match 9: debe recibir 412 aunque B no haya tocado la misma fila hija. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 8. Máquinas de estado normativas

<img src="media/image3.png" style="width:7.35in;height:4.08292in" />

Figura 3 — Lifecycle normativo de Registration y Enrollment

| **Aggregate**              | **Estados/transiciones**                                                                                                            | **Invariante**                                      |
|----------------------------|-------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------|
| **ProspectCase**           | OPEN → QUALIFIED → CONVERTED / LOST / EXPIRED                                                                                       | CONVERTED conserva lineage; no borra caso.          |
| **RegistrationInvitation** | ISSUED → OPENED → ACCEPTED / EXPIRED / REVOKED                                                                                      | ACCEPTED solo una vez; token hash.                  |
| **RegistrationRequest**    | DRAFT → SUBMITTED → VALIDATING → ELIGIBLE → WAITLISTED/PRE_ENROLLED/ENROLLED; terminal REJECTED/CANCELLED/EXPIRED                   | ENROLLED no vuelve a estado previo.                 |
| **CapacityPool**           | OPEN ↔ FROZEN → CLOSED → RETIRED                                                                                                    | Counters nunca negativos; retired no borra history. |
| **SeatReservation**        | HELD → CONSUMED / RELEASED / EXPIRED                                                                                                | Solo HELD consume reserved counter.                 |
| **WaitlistEntry**          | ACTIVE → OFFERED → ACCEPTED / EXPIRED / REMOVED                                                                                     | No rank mutable; una entrada activa.                |
| **WaitlistOffer**          | ISSUED → ACCEPTED / EXPIRED / CANCELLED                                                                                             | ISSUED requiere seat hold.                          |
| **PreEnrollment**          | PENDING_CONDITIONS → READY → CONVERTED; terminal EXPIRED/CANCELLED                                                                  | READY no equivale Enrollment.                       |
| **Enrollment**             | ACTIVE ↔ SUSPENDED; ACTIVE/SUSPENDED → TRANSFER_PENDING → TRANSFERRED; ACTIVE/SUSPENDED/TRANSFER_PENDING → WITHDRAWN/CANCELLED/VOID | No update edition/of offering para transfer.        |
| **TransferRequest**        | DRAFT → SUBMITTED → APPROVED → APPLYING → APPLIED / REJECTED / CANCELLED                                                            | APPLIED crea nuevo Enrollment.                      |
| **WithdrawalRequest**      | SUBMITTED → APPROVED → APPLIED / REJECTED / CANCELLED                                                                               | APPLIED no crea refund local.                       |

| **REGLA DE ESTADO —** Nunca implementar “status = ENROLLED” o “status = TRANSFERRED” como PATCH genérico. Son casos de uso con autorización, If-Match, validation pack, locks de capacidad, receipts, audit y outbox. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 8.1 RegistrationRequest — state machine física

| **Desde**                      | **Hacia permitidos**                                       | **Semántica**                                               |
|--------------------------------|------------------------------------------------------------|-------------------------------------------------------------|
| **DRAFT**                      | SUBMITTED · CANCELLED · EXPIRED                            | Editable; no capacity consume.                              |
| **SUBMITTED**                  | VALIDATING · CANCELLED · EXPIRED                           | Snapshot de submit; iniciar resoluciones.                   |
| **VALIDATING**                 | ELIGIBLE · WAITLISTED · REJECTED · CANCELLED               | CT-15/identity/requirements.                                |
| **ELIGIBLE**                   | WAITLISTED · PRE_ENROLLED · ENROLLED · CANCELLED · EXPIRED | Admisible; capacidad/comercial pueden decidir ruta.         |
| **WAITLISTED**                 | PRE_ENROLLED · ENROLLED · CANCELLED · EXPIRED              | Promotion gobernada.                                        |
| **PRE_ENROLLED**               | ENROLLED · CANCELLED · EXPIRED                             | Conversión desde PreEnrollment.                             |
| **ENROLLED**                   | —                                                          | Terminal en Registration; lifecycle continúa en Enrollment. |
| **REJECTED/CANCELLED/EXPIRED** | —                                                          | Terminal; nueva intención crea nueva Registration/lineage.  |

## 8.2 Enrollment — state machine física

| **Desde**            | **Hacia permitidos**                                        | **Semántica**                                  |
|----------------------|-------------------------------------------------------------|------------------------------------------------|
| **ACTIVE**           | SUSPENDED · TRANSFER_PENDING · WITHDRAWN · CANCELLED · VOID | Matrícula vigente.                             |
| **SUSPENDED**        | ACTIVE · TRANSFER_PENDING · WITHDRAWN · CANCELLED · VOID    | Suspensión operativa/académica gobernada.      |
| **TRANSFER_PENDING** | ACTIVE · TRANSFERRED · WITHDRAWN · CANCELLED                | Reserva destino/approval pendiente.            |
| **TRANSFERRED**      | —                                                           | Terminal histórica; nuevo enrollment continúa. |
| **WITHDRAWN**        | —                                                           | Terminal; capacity liberada.                   |
| **CANCELLED**        | —                                                           | Terminal; no hard delete.                      |
| **VOID**             | —                                                           | Terminal excepcional con step-up/evidence.     |

# 9. Catálogo formal de reglas BR-EC04

| **ID**          | **Nombre**                         | **Regla implementable/verificable**                                                                                                                                  |
|-----------------|------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **BR-EC04-001** | Tenant obligatorio                 | Toda fila tenant-owned usa tenant_id del contexto autorizado; body/query no puede elegir otro tenant.                                                                |
| **BR-EC04-002** | RLS obligatorio                    | Todas las tablas EC-04 usan ENABLE+FORCE RLS; runtime no posee tablas ni BYPASSRLS.                                                                                  |
| **BR-EC04-003** | Person canónica                    | person_ref se resuelve en CT-04; EC-04 no persiste copia de nombre/email/teléfono como verdad canónica.                                                              |
| **BR-EC04-004** | Participant único por persona      | Solo un ParticipantProfile por person_ref y tenant.                                                                                                                  |
| **BR-EC04-005** | Participant code estable           | participant_code no se reutiliza ni cambia después de existir historia de enrollment.                                                                                |
| **BR-EC04-006** | IAM separado                       | Ausencia de IAM user no invalida ParticipantProfile; self-service puede exigir IAM según policy.                                                                     |
| **BR-EC04-007** | Prospect purpose                   | ProspectCase exige purpose_code y contacto/persona resoluble.                                                                                                        |
| **BR-EC04-008** | Prospect conversion idempotente    | Convertir el mismo prospecto dos veces retorna los mismos refs o conflicto gobernado, nunca duplica persona/participant.                                             |
| **BR-EC04-009** | Prospect no seat                   | ProspectCase nunca reserva capacidad.                                                                                                                                |
| **BR-EC04-010** | Invitation token secreto           | Solo se persiste token_hash + last4; plaintext no se loguea ni persiste.                                                                                             |
| **BR-EC04-011** | Invitation expiry                  | Una invitation expirada/revocada no crea Registration.                                                                                                               |
| **BR-EC04-012** | Invitation one-shot                | ACCEPTED no puede volver a ISSUED; replay devuelve Registration existente.                                                                                           |
| **BR-EC04-013** | Registration única activa          | Un participante no mantiene dos registrations activas para el mismo offering.                                                                                        |
| **BR-EC04-014** | Offering pinneada                  | registration guarda offering_ref/edition_ref/program_version_ref del contrato EC-02/01 validado.                                                                     |
| **BR-EC04-015** | Offering admisible                 | Submit/enroll fail-closed si Offering está CLOSED/CANCELLED/UNAVAILABLE según contrato EC-02.                                                                        |
| **BR-EC04-016** | Registration no enrollment         | SUBMITTED/ELIGIBLE/PRE_ENROLLED no implican matrícula oficial.                                                                                                       |
| **BR-EC04-017** | Registration channel parametrizado | registration_channel_code proviene CT-02; no enum de negocio hardcodeado en UI.                                                                                      |
| **BR-EC04-018** | Quote referenciada                 | commercial_quote_ref es opcional/obligatoria según policy; EC-04 no recalcula ni edita quote.                                                                        |
| **BR-EC04-019** | Corporate ref externa              | corporate_enrollment_batch_ref no convierte a empresa en Participant.                                                                                                |
| **BR-EC04-020** | Policy snapshot                    | Toda decision de admission conserva policy versions/snapshot suficiente para reconstrucción.                                                                         |
| **BR-EC04-021** | Optimistic lock                    | Mutaciones de Registration requieren If-Match; mismatch =\> 412.                                                                                                     |
| **BR-EC04-022** | Aggregate revision completa        | Cambios de requirement/receipt que alteren admisión bump de Registration.version.                                                                                    |
| **BR-EC04-023** | No last write wins                 | Conflicto de versión no se resuelve silenciosamente.                                                                                                                 |
| **BR-EC04-024** | Submit idempotente                 | Submit exige Idempotency-Key durable.                                                                                                                                |
| **BR-EC04-025** | Create enrollment idempotente      | Enrollment creation exige Idempotency-Key y unique registration/seat.                                                                                                |
| **BR-EC04-026** | Eligibility owner                  | CT-15 es SoT de rule/decision; EC-04 solo guarda receipt.                                                                                                            |
| **BR-EC04-027** | Eligibility unknown no favorable   | UNKNOWN no se interpreta como ELIGIBLE.                                                                                                                              |
| **BR-EC04-028** | Eligibility revalidation           | Policy define freshness; receipt stale exige reevaluación antes de Enrollment.                                                                                       |
| **BR-EC04-029** | Identity assurance                 | Nivel requerido es policy-driven y resultado proviene CT-04/IAM.                                                                                                     |
| **BR-EC04-030** | Identity unknown no verified       | UNKNOWN/REVIEW_REQUIRED no equivale VERIFIED.                                                                                                                        |
| **BR-EC04-031** | Requirement code único             | requirement_code es único dentro de Registration.                                                                                                                    |
| **BR-EC04-032** | Mandatory blocks                   | Requirement mandatory PENDING/FAILED/EXPIRED bloquea READY/Enrollment salvo waiver válido.                                                                           |
| **BR-EC04-033** | Waiver gobernado                   | WAIVED requiere workflow/reason/evidence cuando policy exige.                                                                                                        |
| **BR-EC04-034** | Requirement history                | Resultados son append-only; reevaluación crea nuevo result.                                                                                                          |
| **BR-EC04-035** | Document ref only                  | Documentos viven CT-05; no blob en PostgreSQL EC-04.                                                                                                                 |
| **BR-EC04-036** | Consent versionado                 | Consentimiento se registra como receipt + policy version, nunca boolean sin lineage.                                                                                 |
| **BR-EC04-037** | Capacity SoT                       | EC-04 CapacityPool gobierna capacidad admisible; EC-02 no se consulta como contador transaccional.                                                                   |
| **BR-EC04-038** | Fixed capacity valid               | FIXED requiere hard_capacity \>=0; UNLIMITED exige hard_capacity NULL y overbook_limit=0.                                                                            |
| **BR-EC04-039** | Counters nonnegative               | reserved/enrolled/waitlisted nunca negativos.                                                                                                                        |
| **BR-EC04-040** | No oversubscription                | FIXED impide reserved+enrolled \> hard_capacity+overbook_limit.                                                                                                      |
| **BR-EC04-041** | Overbook explicit                  | overbook_limit \>0 requiere policy/reason/approval según threshold.                                                                                                  |
| **BR-EC04-042** | Pool state                         | FROZEN/CLOSED/RETIRED no acepta nuevos holds.                                                                                                                        |
| **BR-EC04-043** | Seat hold atomic                   | Crear HELD lockea CapacityPool y actualiza current_reserved en la misma transacción.                                                                                 |
| **BR-EC04-044** | Seat one active                    | Una Registration tiene como máximo un HELD por CapacityPool.                                                                                                         |
| **BR-EC04-045** | Seat expiry                        | HELD temporal debe tener expires_at según policy; job de expiry es idempotente.                                                                                      |
| **BR-EC04-046** | Seat consume atomic                | HELD→CONSUMED decrementa reserved e incrementa enrolled atómicamente.                                                                                                |
| **BR-EC04-047** | Seat release atomic                | HELD→RELEASED/EXPIRED decrementa reserved exactamente una vez.                                                                                                       |
| **BR-EC04-048** | Redis no capacity truth            | Redis no decide último cupo; PostgreSQL lock/constraint es autoridad.                                                                                                |
| **BR-EC04-049** | Capacity adjustment history        | Cambiar hard capacity/overbook produce CapacityAdjustment append-only.                                                                                               |
| **BR-EC04-050** | Cannot shrink below occupancy      | No se reduce hard_capacity+overbook por debajo de reserved+enrolled.                                                                                                 |
| **BR-EC04-051** | Waitlist enabled                   | Si waitlist_enabled=false, full capacity rechaza/alternativa; no crea entry silenciosa.                                                                              |
| **BR-EC04-052** | One active waitlist                | Máximo una WaitlistEntry ACTIVE/OFFERED por registration/pool.                                                                                                       |
| **BR-EC04-053** | Priority policy pinned             | priority_policy_ref identifica PolicyVersion inmutable.                                                                                                              |
| **BR-EC04-054** | Priority deterministic             | Ordering usa bucket, score, enqueued_at e id; misma data produce mismo orden.                                                                                        |
| **BR-EC04-055** | AI no priority                     | IA no puede modificar priority_bucket/score oficial.                                                                                                                 |
| **BR-EC04-056** | Offer requires seat                | WaitlistOffer ISSUED requiere SeatReservation HELD en la misma unidad transaccional.                                                                                 |
| **BR-EC04-057** | One active offer                   | Solo una WaitlistOffer ISSUED por entry.                                                                                                                             |
| **BR-EC04-058** | Offer expiry releases              | Expirar offer libera seat y actualiza entry/counters idempotentemente.                                                                                               |
| **BR-EC04-059** | Notification not truth             | Fallo CT-07 no deshace offer; UI/portal puede consultarla.                                                                                                           |
| **BR-EC04-060** | Waitlist accept idempotent         | Aceptar offer repetidamente no crea varios pre-enrollments/enrollments.                                                                                              |
| **BR-EC04-061** | Waitlist fairness evidence         | Promotion batch conserva policy/version/correlation y candidate decision evidence.                                                                                   |
| **BR-EC04-062** | PreEnrollment requires seat        | PreEnrollment activo exige SeatReservation HELD/CONSUMABLE.                                                                                                          |
| **BR-EC04-063** | PreEnrollment requires eligibility | Debe pinnear EligibilityDecisionReceipt admisible según policy.                                                                                                      |
| **BR-EC04-064** | READY conditions                   | READY solo si todos los mandatory requirements están SATISFIED/WAIVED y receipts frescos.                                                                            |
| **BR-EC04-065** | PreEnrollment expiry               | EXPIRED no puede convertirse a Enrollment; nueva ruta exige revalidation/hold.                                                                                       |
| **BR-EC04-066** | Enrollment official command        | Enrollment se crea solo mediante command autorizado; no por webhook/payment event directo.                                                                           |
| **BR-EC04-067** | Enrollment unique per registration | Una Registration produce a lo sumo un Enrollment.                                                                                                                    |
| **BR-EC04-068** | Enrollment unique seat             | Un SeatReservation CONSUMED pertenece a un único Enrollment.                                                                                                         |
| **BR-EC04-069** | Enrollment pins academic version   | program_version_ref/edition/offering/cohort quedan históricos; no latest.                                                                                            |
| **BR-EC04-070** | Enrollment status guarded          | State transitions fuera del mapa físico son rechazadas.                                                                                                              |
| **BR-EC04-071** | Enrollment history append-only     | Cada transición genera EnrollmentStatusHistory y no se edita.                                                                                                        |
| **BR-EC04-072** | Completion external                | Enrollment ACTIVE no implica completion; EC-07 decide completion.                                                                                                    |
| **BR-EC04-073** | Attendance external                | Enrollment no almacena attendance; EC-06 consume enrollment_id.                                                                                                      |
| **BR-EC04-074** | Certification external             | Enrollment no emite certificado; EC-08 consume hechos posteriores.                                                                                                   |
| **BR-EC04-075** | Effective dates coherent           | effective_to \>= effective_from; terminal status fija effective_to según policy.                                                                                     |
| **BR-EC04-076** | Void high assurance                | VOID requiere step-up, reason/evidence y autorización governance.                                                                                                    |
| **BR-EC04-077** | Transfer no rewrite                | Transferencia nunca cambia offering/edition del enrollment origen.                                                                                                   |
| **BR-EC04-078** | Transfer destination seat          | Transfer approved requiere seat destino antes de aplicar.                                                                                                            |
| **BR-EC04-079** | Transfer lock order                | Si intervienen dos pools, locks se adquieren por capacity_pool_id ordenado para evitar deadlock.                                                                     |
| **BR-EC04-080** | Transfer atomic local facts        | Crear destination Enrollment y marcar source TRANSFERRED ocurren en una transacción local.                                                                           |
| **BR-EC04-081** | Transfer downstream                | Attendance/completion previos no se mueven automáticamente; contexts downstream aplican sus políticas.                                                               |
| **BR-EC04-082** | Withdrawal no refund               | APPLIED publica hecho académico; no crea refund/debt mutation local.                                                                                                 |
| **BR-EC04-083** | Withdrawal releases capacity       | Status terminal libera current_enrolled exactamente una vez.                                                                                                         |
| **BR-EC04-084** | One active withdrawal              | Máximo un WithdrawalRequest SUBMITTED/APPROVED por enrollment.                                                                                                       |
| **BR-EC04-085** | Batch no bulk insert               | Batch processor usa domain commands item-by-item; no INSERT directo final.                                                                                           |
| **BR-EC04-086** | Batch item key unique              | external_item_key único dentro del batch.                                                                                                                            |
| **BR-EC04-087** | Batch partial explicit             | PARTIAL ≠ FAILED ≠ SUCCEEDED; counts deben cuadrar.                                                                                                                  |
| **BR-EC04-088** | Bulk 202 operation                 | Procesos grandes retornan operationId; 202 no significa registrations completas.                                                                                     |
| **BR-EC04-089** | CT-16 migration                    | Legacy sigue Extract→Normalize→Map→Validate→Dry-run→Promote→Receipt→Reconcile.                                                                                       |
| **BR-EC04-090** | Migration rerun safe               | Reejecutar batch usa source keys/idempotency y no duplica Participant/Registration.                                                                                  |
| **BR-EC04-091** | Durable idempotency                | Idempotencia sensible vive PostgreSQL, no Redis.                                                                                                                     |
| **BR-EC04-092** | Idempotency conflict               | Same key + different request_hash =\> 409 IDEMPOTENCY_KEY_REUSED.                                                                                                    |
| **BR-EC04-093** | Idempotency lease recovery         | IN_PROGRESS con lease vencido se recupera gobernadamente sin duplicar efecto.                                                                                        |
| **BR-EC04-094** | Outbox atomic                      | Enrollment/withdraw/transfer/waitlist offer critical facts + outbox commit juntos.                                                                                   |
| **BR-EC04-095** | Outbox claim safe                  | Workers usan FOR UPDATE SKIP LOCKED + owner/lease.                                                                                                                   |
| **BR-EC04-096** | Inbox dedup                        | message_id deduplica; same-id/different-hash es contract incident.                                                                                                   |
| **BR-EC04-097** | At-least-once                      | No se promete exactly-once distribuido; se combina idempotencia + dedup + reconciliation.                                                                            |
| **BR-EC04-098** | UNKNOWN_EFFECT                     | Remote effect incierto se reconcilia antes de retry.                                                                                                                 |
| **BR-EC04-099** | 202 operation status               | Toda operación 202 expone OperationStatus hasta terminal/unknown resolution.                                                                                         |
| **BR-EC04-100** | Problem Details                    | Errores usan RFC Problem Details + reasonCode estable + correlationId.                                                                                               |
| **BR-EC04-101** | HTTP semantics                     | 400 request, 401 auth, 403 authorization, 404 not found, 409 state/idempotency/capacity conflict, 412 ETag, 422 business rule, 429 rate, 503 dependency unavailable. |
| **BR-EC04-102** | PII minimization                   | EC-04 guarda refs canónicas; solo atributos estrictamente necesarios del vínculo EC.                                                                                 |
| **BR-EC04-103** | Purpose limitation                 | Prospect/registration processing usa purpose_code y accesos compatibles.                                                                                             |
| **BR-EC04-104** | Field-level privacy                | Vistas operativas no exponen datos de CT-04 que el rol no necesita.                                                                                                  |
| **BR-EC04-105** | SoD configurable                   | Overbook/void/waiver/manual priority exception/transfer high risk pueden requerir actor distinto.                                                                    |
| **BR-EC04-106** | Step-up critical                   | VOID, capacity override sensible, bulk high-risk y data export exigen assurance según policy.                                                                        |
| **BR-EC04-107** | Time UTC                           | Instantes usan timestamptz UTC; timezone solo presentación.                                                                                                          |
| **BR-EC04-108** | No hard delete history             | Enrollment, status history, receipts, applied transfer/withdrawal no se eliminan por API ordinaria.                                                                  |
| **BR-EC04-109** | AI provenance                      | Sugerencias IA conservan run/model/template/eval/grounding/reviewer outcome vía CT-12.                                                                               |
| **BR-EC04-110** | AI no enrollment                   | IA nunca crea enrollment, cambia prioridad oficial, aprueba waiver ni decide identidad/elegibilidad.                                                                 |
| **BR-EC04-111** | Frontend service states            | NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT se muestran diferenciados.                                                                                     |
| **BR-EC04-112** | OpenAPI generated client           | Frontend usa client/DTO generado desde OpenAPI; no contratos manuales paralelos.                                                                                     |
| **BR-EC04-113** | Pagination bounded                 | List APIs definen pageSize máximo, sorting estable, filtros y cursor/offset contractual.                                                                             |
| **BR-EC04-114** | Capacity budgets                   | Payload/batch/page/waitlist promotion sizes son parametrizados y excederlos produce 413/422/429 según causa.                                                         |
| **BR-EC04-115** | Expand contract                    | Schema productivo mantiene compatibilidad N/N-1; no one-shot destructive change.                                                                                     |
| **BR-EC04-116** | Secure SDLC gate                   | High/Critical SAST/SCA/secret/container findings bloquean release salvo waiver formal.                                                                               |
| **BR-EC04-117** | Reconstructibilidad                | Toda matrícula debe reconstruirse con refs/versiones/receipts/reasons aunque dependencias hayan evolucionado.                                                        |

# 10. Casos de uso UC-EC04

| **ID**          | **Caso de uso**                                | **Actor primario**                  |
|-----------------|------------------------------------------------|-------------------------------------|
| **UC-EC04-001** | Crear ProspectCase                             | Prospect Agent                      |
| **UC-EC04-002** | Calificar prospecto                            | Prospect Agent                      |
| **UC-EC04-003** | Resolver prospecto con Person CT-04            | Prospect Agent/System               |
| **UC-EC04-004** | Convertir prospecto a Participant/Registration | Registration Agent                  |
| **UC-EC04-005** | Crear/obtener ParticipantProfile               | Registration Agent/System           |
| **UC-EC04-006** | Suspender/restringir ParticipantProfile        | Academic Governance                 |
| **UC-EC04-007** | Emitir RegistrationInvitation                  | Registration Agent/Corporate Intake |
| **UC-EC04-008** | Abrir invitación                               | Participant                         |
| **UC-EC04-009** | Aceptar invitación                             | Participant                         |
| **UC-EC04-010** | Revocar invitación                             | Registration Agent                  |
| **UC-EC04-011** | Crear RegistrationRequest                      | Participant/Registration Agent      |
| **UC-EC04-012** | Modificar draft de Registration                | Participant/Agent                   |
| **UC-EC04-013** | Submit Registration                            | Participant/Agent                   |
| **UC-EC04-014** | Cancelar Registration                          | Participant/Agent                   |
| **UC-EC04-015** | Validar Offering/ProgramVersion                | Application Service                 |
| **UC-EC04-016** | Evaluar eligibility CT-15                      | Application Service                 |
| **UC-EC04-017** | Registrar IdentityAssuranceReceipt             | Application Service                 |
| **UC-EC04-018** | Generar requirements de admission              | Application Service                 |
| **UC-EC04-019** | Adjuntar document_ref a Registration           | Participant/Agent                   |
| **UC-EC04-020** | Registrar consent receipt                      | Participant/System                  |
| **UC-EC04-021** | Aplicar result de requirement                  | Application Service/Reviewer        |
| **UC-EC04-022** | Solicitar waiver                               | Registration Agent                  |
| **UC-EC04-023** | Aprobar/rechazar waiver                        | Approver                            |
| **UC-EC04-024** | Declarar Registration ELIGIBLE                 | Admission Service                   |
| **UC-EC04-025** | Crear CapacityPool                             | Capacity Manager                    |
| **UC-EC04-026** | Modificar capacidad vía adjustment             | Capacity Manager                    |
| **UC-EC04-027** | Freeze/Reopen CapacityPool                     | Capacity Manager                    |
| **UC-EC04-028** | Reservar seat                                  | Registration/Waitlist Service       |
| **UC-EC04-029** | Liberar seat                                   | System/Agent                        |
| **UC-EC04-030** | Expirar holds vencidos                         | Scheduler/Worker                    |
| **UC-EC04-031** | Agregar a waitlist                             | Registration Service                |
| **UC-EC04-032** | Consultar posición/proyección de waitlist      | Participant/Agent                   |
| **UC-EC04-033** | Promover siguiente waitlist candidate          | Waitlist Worker                     |
| **UC-EC04-034** | Emitir WaitlistOffer                           | Waitlist Worker                     |
| **UC-EC04-035** | Aceptar WaitlistOffer                          | Participant                         |
| **UC-EC04-036** | Expirar/cancelar WaitlistOffer                 | Scheduler/Agent                     |
| **UC-EC04-037** | Crear PreEnrollment                            | Admission Service                   |
| **UC-EC04-038** | Reevaluar condiciones PreEnrollment            | Application Service                 |
| **UC-EC04-039** | Marcar PreEnrollment READY                     | Admission Service                   |
| **UC-EC04-040** | Expirar/cancelar PreEnrollment                 | Scheduler/Agent                     |
| **UC-EC04-041** | Crear Enrollment oficial                       | Enrollment Manager/System           |
| **UC-EC04-042** | Consultar Enrollment                           | Participant/Staff                   |
| **UC-EC04-043** | Suspender/reactivar Enrollment                 | Enrollment Manager                  |
| **UC-EC04-044** | Void Enrollment                                | Academic Governance                 |
| **UC-EC04-045** | Crear TransferRequest                          | Participant/Agent                   |
| **UC-EC04-046** | Aprobar/rechazar transferencia                 | Approver                            |
| **UC-EC04-047** | Aplicar transferencia                          | Enrollment Manager/System           |
| **UC-EC04-048** | Crear WithdrawalRequest                        | Participant/Agent                   |
| **UC-EC04-049** | Aprobar/rechazar retiro                        | Approver                            |
| **UC-EC04-050** | Aplicar retiro/cancelación                     | Enrollment Manager/System           |
| **UC-EC04-051** | Crear RegistrationBatch                        | Corporate Intake/Data Steward       |
| **UC-EC04-052** | Cargar batch items                             | Corporate Intake/Data Steward       |
| **UC-EC04-053** | Validar batch dry-run                          | Data Steward                        |
| **UC-EC04-054** | Procesar batch async                           | Worker                              |
| **UC-EC04-055** | Consultar OperationStatus                      | Frontend/Operator                   |
| **UC-EC04-056** | Reintentar item fallido idempotente            | Operator/System                     |
| **UC-EC04-057** | Reconciliar UNKNOWN_EFFECT                     | Operator/System                     |
| **UC-EC04-058** | Reconciliar counters capacity                  | Ops                                 |
| **UC-EC04-059** | Reprocesar outbox/inbox                        | Ops                                 |
| **UC-EC04-060** | Consultar enrollment history/evidence          | Auditor                             |
| **UC-EC04-061** | Exportar evidence pack                         | Auditor                             |
| **UC-EC04-062** | Solicitar asistencia IA                        | Registration Agent                  |
| **UC-EC04-063** | Aceptar/rechazar sugerencia IA                 | Registration Agent                  |
| **UC-EC04-064** | Importar legacy vía CT-16                      | Data Steward                        |
| **UC-EC04-065** | Validar RLS tenant isolation                   | Security/QA                         |
| **UC-EC04-066** | Consultar roster por Offering                  | Authorized Staff                    |
| **UC-EC04-067** | Consultar participante 360 EC                  | Authorized Staff                    |
| **UC-EC04-068** | Consultar registrations STALE/PARTIAL aware    | Authorized Staff                    |

## 10.1 Casos críticos desarrollados

### UC-EC04-013 — Submit Registration

| **Aspecto**                       | **Detalle**                                                                                        |
|-----------------------------------|----------------------------------------------------------------------------------------------------|
| **Actor**                         | Participant/Registration Agent                                                                     |
| **Precondiciones / autorización** | Draft completo; offering admissible; identity context disponible.                                  |
| **Happy Path**                    | Lock registration + If-Match; snapshot policy/offering refs; state SUBMITTED; idempotency; outbox. |
| **Alternativas / errores**        | Offering/CT deps unavailable =\> 503/PARTIAL preflight; stale ETag =\> 412.                        |
| **Idempotencia**                  | Idempotency-Key obligatorio.                                                                       |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                            |
| **Auditoría / side effects**      | Audit submit + correlation; postcondición SUBMITTED.                                               |
| **Postcondición**                 | Audit submit + correlation; postcondición SUBMITTED.                                               |

### UC-EC04-016 — Evaluar eligibility CT-15

| **Aspecto**                       | **Detalle**                                                                                         |
|-----------------------------------|-----------------------------------------------------------------------------------------------------|
| **Actor**                         | Application Service                                                                                 |
| **Precondiciones / autorización** | Registration SUBMITTED/VALIDATING y rule refs resolubles.                                           |
| **Happy Path**                    | Call CT-15 con input hash; persist append-only receipt; actualizar requirement; root revision bump. |
| **Alternativas / errores**        | Timeout con posible remote decision =\> UNKNOWN_EFFECT receipt; UNKNOWN no es ELIGIBLE.             |
| **Idempotencia**                  | Request key/correlation idempotente según contract.                                                 |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                             |
| **Auditoría / side effects**      | Evidence ref + result; postcondición receipt reconstruible.                                         |
| **Postcondición**                 | Evidence ref + result; postcondición receipt reconstruible.                                         |

### UC-EC04-028 — Reservar seat

| **Aspecto**                       | **Detalle**                                                                                                           |
|-----------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Registration/Waitlist Service                                                                                         |
| **Precondiciones / autorización** | Registration admisible; CapacityPool OPEN; policy permite hold.                                                       |
| **Happy Path**                    | SELECT CapacityPool FOR UPDATE; revalidar counters; INSERT SeatReservation HELD; trigger incrementa reserved; commit. |
| **Alternativas / errores**        | FULL =\> waitlist/409 business result; deadlock retry técnico acotado.                                                |
| **Idempotencia**                  | Idempotency-Key; one active hold unique.                                                                              |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                               |
| **Auditoría / side effects**      | Audit + SeatReserved event opcional; capacity consistente.                                                            |
| **Postcondición**                 | Audit + SeatReserved event opcional; capacity consistente.                                                            |

### UC-EC04-033 — Promover siguiente waitlist candidate

| **Aspecto**                       | **Detalle**                                                                                                                             |
|-----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Waitlist Worker                                                                                                                         |
| **Precondiciones / autorización** | Capacity disponible; entries ACTIVE.                                                                                                    |
| **Happy Path**                    | Lock pool; seleccionar por priority policy + tie-break; create SeatReservation HELD + WaitlistOffer ISSUED; mark entry OFFERED; outbox. |
| **Alternativas / errores**        | Candidate became ineligible/stale =\> skip con reason y siguiente según policy; no priority mutation IA.                                |
| **Idempotencia**                  | Worker operation id + item idempotency.                                                                                                 |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                                                 |
| **Auditoría / side effects**      | Evidence de ordering/policy; exactly one offer por seat.                                                                                |
| **Postcondición**                 | Evidence de ordering/policy; exactly one offer por seat.                                                                                |

### UC-EC04-035 — Aceptar WaitlistOffer

| **Aspecto**                       | **Detalle**                                                                                                 |
|-----------------------------------|-------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Participant                                                                                                 |
| **Precondiciones / autorización** | Offer ISSUED, no expirada, subject autorizado.                                                              |
| **Happy Path**                    | If-Match offer; revalidar seat HELD; mark ACCEPTED; create/update PreEnrollment/Registration; no duplicate. |
| **Alternativas / errores**        | Expired =\> 409/422; seat lost =\> incident/reconcile, nunca aceptar sin capacity.                          |
| **Idempotencia**                  | Idempotency-Key.                                                                                            |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                     |
| **Auditoría / side effects**      | Audit + notification/event; ruta a matrícula preservada.                                                    |
| **Postcondición**                 | Audit + notification/event; ruta a matrícula preservada.                                                    |

### UC-EC04-041 — Crear Enrollment oficial

| **Aspecto**                       | **Detalle**                                                                                                                                    |
|-----------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Enrollment Manager/System                                                                                                                      |
| **Precondiciones / autorización** | Registration ELIGIBLE/PRE_ENROLLED; requirements satisfied/waived; seat HELD; refs frescos.                                                    |
| **Happy Path**                    | Lock registration/pre-enrollment/seat/pool; revalidate; create Enrollment; seat HELD→CONSUMED; history; registration ENROLLED; outbox; commit. |
| **Alternativas / errores**        | Stale ETag/expired seat/unavailable critical dependency =\> no partial enrollment.                                                             |
| **Idempotencia**                  | Idempotency-Key durable; unique registration/seat.                                                                                             |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                                                        |
| **Auditoría / side effects**      | Enrollment ACTIVE + capacity enrolled + evidence pack.                                                                                         |
| **Postcondición**                 | Enrollment ACTIVE + capacity enrolled + evidence pack.                                                                                         |

### UC-EC04-047 — Aplicar transferencia

| **Aspecto**                       | **Detalle**                                                                                                                                        |
|-----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Enrollment Manager/System                                                                                                                          |
| **Precondiciones / autorización** | Transfer APPROVED; source active/pending; destination seat HELD.                                                                                   |
| **Happy Path**                    | Lock pools deterministic order; create destination Enrollment; destination seat CONSUMED; source TRANSFERRED; source capacity decremented; outbox. |
| **Alternativas / errores**        | Any invariant fails =\> rollback local transaction; remote effects reconcile separately.                                                           |
| **Idempotencia**                  | Idempotency-Key.                                                                                                                                   |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                                                            |
| **Auditoría / side effects**      | Lineage + two histories + consistent counters.                                                                                                     |
| **Postcondición**                 | Lineage + two histories + consistent counters.                                                                                                     |

### UC-EC04-050 — Aplicar retiro/cancelación

| **Aspecto**                       | **Detalle**                                                                                                                                      |
|-----------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Enrollment Manager/System                                                                                                                        |
| **Precondiciones / autorización** | Withdrawal APPROVED; enrollment mutable state.                                                                                                   |
| **Happy Path**                    | Lock enrollment/pool; transition WITHDRAWN/CANCELLED; trigger history + capacity decrement; event; create financial followup ref asynchronously. |
| **Alternativas / errores**        | Finance unavailable does not rollback academic withdrawal; UI shows follow-up UNAVAILABLE/PENDING.                                               |
| **Idempotencia**                  | Idempotency-Key.                                                                                                                                 |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                                                          |
| **Auditoría / side effects**      | Academic truth committed; financial effect external.                                                                                             |
| **Postcondición**                 | Academic truth committed; financial effect external.                                                                                             |

### UC-EC04-054 — Procesar batch async

| **Aspecto**                       | **Detalle**                                                                                                                                  |
|-----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Worker                                                                                                                                       |
| **Precondiciones / autorización** | Batch READY; OperationStatus PENDING.                                                                                                        |
| **Happy Path**                    | Claim chunks; each item resolves person/participant + registration via idempotent domain command; update item/result and operation progress. |
| **Alternativas / errores**        | Partial failures remain per item; batch PARTIAL not all-or-nothing unless policy explicitly demands.                                         |
| **Idempotencia**                  | source key + item idempotency.                                                                                                               |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                                                      |
| **Auditoría / side effects**      | Counts reconcile; no duplicates on restart.                                                                                                  |
| **Postcondición**                 | Counts reconcile; no duplicates on restart.                                                                                                  |

### UC-EC04-057 — Reconciliar UNKNOWN_EFFECT

| **Aspecto**                       | **Detalle**                                                                                                                            |
|-----------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Operator/System                                                                                                                        |
| **Precondiciones / autorización** | EffectReceipt UNKNOWN_EFFECT con remote_operation_ref/idempotency.                                                                     |
| **Happy Path**                    | Query remote status; if CONFIRMED apply local follow-up idempotently; if NOT_APPLIED retry once policy allows; persist reconciliation. |
| **Alternativas / errores**        | Remote still unknown =\> preserve state/escalate; no blind retry.                                                                      |
| **Idempotencia**                  | Reconciliation idempotent.                                                                                                             |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                                                |
| **Auditoría / side effects**      | Receipt terminal or escalated with evidence.                                                                                           |
| **Postcondición**                 | Receipt terminal or escalated with evidence.                                                                                           |

### UC-EC04-059 — Reconciliar counters capacity

| **Aspecto**                       | **Detalle**                                                                                                                                                       |
|-----------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Ops                                                                                                                                                               |
| **Precondiciones / autorización** | Alert/counter mismatch suspected.                                                                                                                                 |
| **Happy Path**                    | Compute expected reserved/enrolled/waitlisted from authoritative rows under safe snapshot; compare; generate report; correction only via governed repair command. |
| **Alternativas / errores**        | No direct UPDATE counters without evidence/lock.                                                                                                                  |
| **Idempotencia**                  | Operation id.                                                                                                                                                     |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                                                                           |
| **Auditoría / side effects**      | Counters certified or repair incident opened.                                                                                                                     |
| **Postcondición**                 | Counters certified or repair incident opened.                                                                                                                     |

### UC-EC04-064 — Importar legacy vía CT-16

| **Aspecto**                       | **Detalle**                                                                                                         |
|-----------------------------------|---------------------------------------------------------------------------------------------------------------------|
| **Actor**                         | Data Steward                                                                                                        |
| **Precondiciones / autorización** | Normalized batch + mapping version.                                                                                 |
| **Happy Path**                    | Dry-run validate identity/duplicates/offering/policies; promote domain commands item by item; receipts + reconcile. |
| **Alternativas / errores**        | Ambiguous person =\> FAIL item, no guessed merge.                                                                   |
| **Idempotencia**                  | Batch/source keys durable.                                                                                          |
| **Concurrencia**                  | If-Match/row locks según aggregate; no last-write-wins.                                                             |
| **Auditoría / side effects**      | Certified lineage and repeatable rerun.                                                                             |
| **Postcondición**                 | Certified lineage and repeatable rerun.                                                                             |

# 11. DER conceptual, lógico y físico

## 11.1 DER conceptual

El modelo conceptual parte de ParticipantProfile como rol de Person, RegistrationRequest como intención/admisión, CapacityPool como autoridad de cupos y Enrollment como hecho oficial. ProspectCase e Invitation preceden registration; receipts/requirements sostienen admission; SeatReservation y Waitlist controlan concurrencia; PreEnrollment separa condición de matrícula; Transfer/Withdrawal preservan lifecycle.

## 11.2 DER lógico

Las relaciones internas EC-04 son tenant-aware. Registration pertenece a ParticipantProfile; requirements/receipts pertenecen a Registration. CapacityPool es referenciado por SeatReservation/Waitlist/Enrollment. WaitlistOffer enlaza a un SeatReservation; PreEnrollment pinnea Registration+Seat+Eligibility; Enrollment pinnea Participant+Registration+Seat+refs EC-01/02. Los IDs CT/IAM/otros EC/Core son EXT REF sin FK física.

## 11.3 DER físico resumido

<img src="media/image4.png" style="width:7.15in;height:5.74291in" />

Figura 4 — DER físico resumido EC-04

| **REGLA DE FK —** Todas las FKs físicas del esquema ec04 son internas y tenant-aware. CT-01…CT-18, IAM, EC-01/02/03/09, Finanzas y otros bounded contexts se consumen mediante EXT REF y contratos; no se introducen FKs cross-context por conveniencia. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 12. Modelo físico PostgreSQL tabla por tabla

El esquema propuesto es ec04. PostgreSQL es Source of Truth transaccional de ParticipantProfile, ProspectCase, RegistrationRequest, CapacityPool, SeatReservation, Waitlist, PreEnrollment y Enrollment. Toda tabla tenant-owned usa tenant_id, RLS ENABLE + FORCE y PK/FK internas tenant-aware. Las referencias a CT, IAM, EC-01/02/03/09 y Finanzas son EXT REF sin FK física. La capacidad se protege con counters, row locks y triggers defensivos; Redis nunca decide el último cupo.

| **PREGUNTA OBLIGATORIA —** Para cada tabla se documenta qué error debe impedir PostgreSQL aunque Backend tenga un bug. La base debe bloquear cruces tenant, oversubscription, duplicación de enrollment/seat, estados inválidos, receipts mutados y targets ambiguos. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.1 ec04_participant_profile

**QUÉ REPRESENTA —** Rol estable de una persona canónica dentro de Educación Continua. No duplica Person de CT-04 ni IAM User: vincula person_ref con un participant_code y lifecycle EC.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root creado cuando una persona se vincula formalmente con la vertical EC. RegistrationRequest y Enrollment lo referencian internamente; CT-04 sigue siendo Source of Truth de identidad y datos personales.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege unicidad persona↔rol EC, business key y lifecycle. No representa una inscripción, una matrícula, un usuario IAM ni un expediente académico completo.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|-------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id               | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| participant_id          | uuid                | NO       | gen_random_uuid() | PK            | ID técnico del rol EC.                                                           | pt…               |
| participant_code        | varchar(64)         | NO       | —                 | UQ            | Código institucional estable por tenant.                                         | EC-P-000123       |
| person_ref              | uuid                | NO       | —                 | EXT REF CT-04 | Persona canónica vinculada; no copiar PII.                                       | person…           |
| home_scope_ref          | uuid                | YES      | NULL              | EXT REF CT-01 | Scope EC primario opcional para atención/operación.                              | scope…            |
| preferred_language_code | varchar(16)         | YES      | NULL              | EXT REF CT-08 | Preferencia de presentación; no crea identidad duplicada.                        | es-BO             |
| lifecycle_state         | varchar(24)         | NO       | 'ACTIVE'          | CHECK         | ACTIVE/SUSPENDED/RESTRICTED/ARCHIVED.                                            | ACTIVE            |
| restriction_reason_code | varchar(80)         | YES      | NULL              | —             | Reason code cuando existe restricción gobernada.                                 | COMPLIANCE_REVIEW |
| created_by_subject      | uuid                | NO       | —                 | EXT REF IAM   | Actor que creó el vínculo EC.                                                    | usr…              |
| created_at              | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |
| updated_at              | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z |
| version                 | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**participant_id —** ID técnico del rol EC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pt….

**participant_code —** Código institucional estable por tenant. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EC-P-000123.

**person_ref —** Persona canónica vinculada; no copiar PII. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**home_scope_ref —** Scope EC primario opcional para atención/operación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: scope….

**preferred_language_code —** Preferencia de presentación; no crea identidad duplicada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: es-BO.

**lifecycle_state —** ACTIVE/SUSPENDED/RESTRICTED/ARCHIVED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'ACTIVE'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**restriction_reason_code —** Reason code cuando existe restricción gobernada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: COMPLIANCE_REVIEW.

**created_by_subject —** Actor que creó el vínculo EC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**               | **Tipo** | **Definición/expresión**                                          | **Error que impide**                |
|---------------------------------|----------|-------------------------------------------------------------------|-------------------------------------|
| **pk_ec04_participant_profile** | PK       | (tenant_id, participant_id)                                       | Identidad/cruce tenant.             |
| **uq_ec04_participant_code**    | UQ       | (tenant_id, participant_code)                                     | Código duplicado.                   |
| **uq_ec04_participant_person**  | UQ       | (tenant_id, person_ref)                                           | Dos roles EC para la misma persona. |
| **ck_ec04_participant_state**   | CHECK    | lifecycle_state IN ('ACTIVE','SUSPENDED','RESTRICTED','ARCHIVED') | Estado inválido.                    |
| **ix_ec04_participant_scope**   | INDEX    | (tenant_id, home_scope_ref, lifecycle_state)                      | Búsqueda operativa lenta.           |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Código duplicado.; Dos roles EC para la misma persona.; Estado inválido.; Búsqueda operativa lenta. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec04_prospect_case

**QUÉ REPRESENTA —** Caso de interés previo a la inscripción. Puede existir antes de que CT-04 haya resuelto una persona canónica; conserva únicamente referencias de contacto/identidad y contexto comercial mínimo.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root operado por Prospect Intake. Puede enlazarse a offering_ref EC-02 y, cuando CT-04 resuelve identidad, a person_ref. La conversión crea/encuentra ParticipantProfile y RegistrationRequest mediante comando idempotente.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege propósito de tratamiento, source/provenance y conversión trazable. No es Person, CRM universal, Registration ni Enrollment; no guarda email/teléfono libre si existe un reference owner.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**            |
|---------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|------------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                   |
| prospect_case_id          | uuid                | NO       | gen_random_uuid() | PK               | ID del caso prospecto.                                                           | pros…                  |
| prospect_number           | varchar(64)         | NO       | —                 | UQ               | Número legible por tenant.                                                       | PRO-2026-0012          |
| person_ref                | uuid                | YES      | NULL              | EXT REF CT-04    | Persona resuelta cuando existe.                                                  | person…                |
| contact_point_ref         | uuid                | YES      | NULL              | EXT REF CT-04/07 | Referencia a canal/contacto gobernado, no PII duplicada.                         | cp…                    |
| target_offering_ref       | uuid                | YES      | NULL              | EXT REF EC-02    | Offering de interés cuando se conoce.                                            | off…                   |
| source_code               | varchar(80)         | NO       | —                 | EXT REF CT-02    | Canal/origen parametrizado.                                                      | WEB_LANDING            |
| purpose_code              | varchar(80)         | NO       | —                 | EXT REF CT-10    | Finalidad de tratamiento/uso permitida.                                          | EC_INFORMATION_REQUEST |
| owner_scope_ref           | uuid                | NO       | —                 | EXT REF CT-01    | Scope responsable del caso.                                                      | scope…                 |
| state                     | varchar(24)         | NO       | 'OPEN'            | CHECK            | OPEN/QUALIFIED/CONVERTED/LOST/EXPIRED.                                           | QUALIFIED              |
| converted_participant_id  | uuid                | YES      | NULL              | FK               | ParticipantProfile resultante al convertir.                                      | pt…                    |
| converted_registration_id | uuid                | YES      | NULL              | FK               | RegistrationRequest originada cuando aplica.                                     | reg…                   |
| last_interaction_at       | timestamptz         | YES      | NULL              | —                | Último contacto de negocio, sin almacenar contenido sensible aquí.               | …                      |
| created_at                | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                        | 2026-09-09T18:00Z      |
| updated_at                | timestamptz         | NO       | now()             | —                | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z      |
| version                   | bigint              | NO       | 0                 | —                | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                      |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**prospect_case_id —** ID del caso prospecto. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pros….

**prospect_number —** Número legible por tenant. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PRO-2026-0012.

**person_ref —** Persona resuelta cuando existe. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**contact_point_ref —** Referencia a canal/contacto gobernado, no PII duplicada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: cp….

**target_offering_ref —** Offering de interés cuando se conoce. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**source_code —** Canal/origen parametrizado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: WEB_LANDING.

**purpose_code —** Finalidad de tratamiento/uso permitida. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: EC_INFORMATION_REQUEST.

**owner_scope_ref —** Scope responsable del caso. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: scope….

**state —** OPEN/QUALIFIED/CONVERTED/LOST/EXPIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'OPEN'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: QUALIFIED.

**converted_participant_id —** ParticipantProfile resultante al convertir. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pt….

**converted_registration_id —** RegistrationRequest originada cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**last_interaction_at —** Último contacto de negocio, sin almacenar contenido sensible aquí. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**             | **Tipo** | **Definición/expresión**                                   | **Error que impide**                        |
|-------------------------------|----------|------------------------------------------------------------|---------------------------------------------|
| **pk_ec04_prospect_case**     | PK       | (tenant_id, prospect_case_id)                              | Identidad/cruce tenant.                     |
| **uq_ec04_prospect_number**   | UQ       | (tenant_id, prospect_number)                               | Número duplicado.                           |
| **ck_ec04_prospect_identity** | CHECK    | person_ref IS NOT NULL OR contact_point_ref IS NOT NULL    | Prospecto sin identidad/contacto resoluble. |
| **ck_ec04_prospect_state**    | CHECK    | state IN ('OPEN','QUALIFIED','CONVERTED','LOST','EXPIRED') | Estado inválido.                            |
| **ix_ec04_prospect_target**   | INDEX    | (tenant_id, target_offering_ref, state, created_at DESC)   | Intake por offering lento.                  |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Número duplicado.; Prospecto sin identidad/contacto resoluble.; Estado inválido.; Intake por offering lento. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec04_registration_invitation

**QUÉ REPRESENTA —** Invitación segura para que una persona o contacto complete registro individual o nominado por empresa/grupo. El token secreto nunca se persiste en claro.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate operativo creado por Registration Desk o desde EC-09. Al aceptar, valida expiración/estado, resuelve person/participant y crea RegistrationRequest de forma idempotente.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege anti-replay, expiración y provenance del sponsor. No representa matrícula ni garantiza cupo.

| **Campo**                      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**       |
|--------------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                      | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| invitation_id                  | uuid                | NO       | gen_random_uuid() | PK               | ID invitación.                                                                   | inv…              |
| invitation_number              | varchar(64)         | NO       | —                 | UQ               | Número legible.                                                                  | INV-2026-0044     |
| token_hash                     | varchar(128)        | NO       | —                 | UQ               | Hash del token; nunca plaintext.                                                 | sha256:…          |
| token_last4                    | char(4)             | NO       | —                 | —                | Últimos cuatro para soporte.                                                     | A9K2              |
| person_ref                     | uuid                | YES      | NULL              | EXT REF CT-04    | Persona pre-resuelta opcional.                                                   | person…           |
| contact_point_ref              | uuid                | YES      | NULL              | EXT REF CT-04/07 | Canal de entrega.                                                                | cp…               |
| offering_ref                   | uuid                | NO       | —                 | EXT REF EC-02    | Offering invitada.                                                               | off…              |
| corporate_enrollment_batch_ref | uuid                | YES      | NULL              | EXT REF EC-09    | Lote corporativo origen cuando aplica.                                           | ceb…              |
| state                          | varchar(24)         | NO       | 'ISSUED'          | CHECK            | ISSUED/OPENED/ACCEPTED/EXPIRED/REVOKED.                                          | ISSUED            |
| issued_at                      | timestamptz         | NO       | now()             | —                | Emisión UTC.                                                                     | …                 |
| expires_at                     | timestamptz         | NO       | —                 | CHECK            | Expiración estricta.                                                             | …                 |
| accepted_at                    | timestamptz         | YES      | NULL              | —                | Aceptación.                                                                      | …                 |
| registration_id                | uuid                | YES      | NULL              | FK               | RegistrationRequest creada al aceptar.                                           | reg…              |
| created_by_subject             | uuid                | NO       | —                 | EXT REF IAM      | Actor/sistema emisor.                                                            | usr…              |
| created_at                     | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |
| updated_at                     | timestamptz         | NO       | now()             | —                | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z |
| version                        | bigint              | NO       | 0                 | —                | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**invitation_id —** ID invitación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: inv….

**invitation_number —** Número legible. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: INV-2026-0044.

**token_hash —** Hash del token; nunca plaintext. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**token_last4 —** Últimos cuatro para soporte. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: A9K2.

**person_ref —** Persona pre-resuelta opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**contact_point_ref —** Canal de entrega. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: cp….

**offering_ref —** Offering invitada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**corporate_enrollment_batch_ref —** Lote corporativo origen cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ceb….

**state —** ISSUED/OPENED/ACCEPTED/EXPIRED/REVOKED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'ISSUED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ISSUED.

**issued_at —** Emisión UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**expires_at —** Expiración estricta. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**accepted_at —** Aceptación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**registration_id —** RegistrationRequest creada al aceptar. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**created_by_subject —** Actor/sistema emisor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                    | **Error que impide**                   |
|-------------------------------------|----------|-------------------------------------------------------------|----------------------------------------|
| **pk_ec04_registration_invitation** | PK       | (tenant_id, invitation_id)                                  | Identidad/cruce tenant.                |
| **uq_ec04_invitation_number**       | UQ       | (tenant_id, invitation_number)                              | Número duplicado.                      |
| **uq_ec04_invitation_token**        | UQ       | (tenant_id, token_hash)                                     | Token duplicado.                       |
| **ck_ec04_invitation_identity**     | CHECK    | person_ref IS NOT NULL OR contact_point_ref IS NOT NULL     | Invitación sin destinatario resoluble. |
| **ck_ec04_invitation_state**        | CHECK    | state IN ('ISSUED','OPENED','ACCEPTED','EXPIRED','REVOKED') | Estado inválido.                       |
| **ck_ec04_invitation_expiry**       | CHECK    | expires_at \> issued_at                                     | Expiración inválida.                   |
| **ix_ec04_invitation_expiry**       | INDEX    | (tenant_id, expires_at) WHERE state IN ('ISSUED','OPENED')  | Expiraciones lentas.                   |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Número duplicado.; Token duplicado.; Invitación sin destinatario resoluble.; Estado inválido.; Expiración inválida.; Expiraciones lentas. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.4 ec04_registration_request

**QUÉ REPRESENTA —** Solicitud formal de vinculación de un ParticipantProfile con un Offering/Edition/Cohort de EC-02. Captura intención, canal, provenance y estado de admisión, no el hecho final de enrollment.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root central de Registration Desk. Orquesta validación CT-15, assurance CT-04/IAM, condiciones, quote EC-03, capacidad, waitlist y creación de PreEnrollment/Enrollment.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege una solicitud activa por participante/offering, version pinning y transición auditable. No representa pago, cupo consumido ni matrícula oficial.

| **Campo**                      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                                  | **Ejemplo**        |
|--------------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------------------------------------|--------------------|
| tenant_id                      | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS.                 | 8a6…               |
| registration_id                | uuid                | NO       | gen_random_uuid() | PK            | ID solicitud.                                                                                    | reg…               |
| registration_number            | varchar(64)         | NO       | —                 | UQ            | Número legible tenant-aware.                                                                     | REG-2026-001337    |
| participant_id                 | uuid                | NO       | —                 | FK            | ParticipantProfile solicitante.                                                                  | pt…                |
| offering_ref                   | uuid                | NO       | —                 | EXT REF EC-02 | Offering objetivo.                                                                               | off…               |
| edition_ref                    | uuid                | NO       | —                 | EXT REF EC-02 | ProgramEdition pinneada.                                                                         | ed…                |
| cohort_ref                     | uuid                | YES      | NULL              | EXT REF EC-02 | Cohorte objetivo cuando aplica.                                                                  | coh…               |
| program_version_ref            | uuid                | NO       | —                 | EXT REF EC-01 | ProgramVersion ejecutada por la edición.                                                         | pv…                |
| registration_channel_code      | varchar(80)         | NO       | —                 | EXT REF CT-02 | SELF_SERVICE/STAFF/CORPORATE/IMPORT/etc.                                                         | SELF_SERVICE       |
| source_invitation_id           | uuid                | YES      | NULL              | FK            | Invitación origen.                                                                               | inv…               |
| source_batch_item_id           | uuid                | YES      | NULL              | FK            | Item de lote origen.                                                                             | bi…                |
| commercial_quote_ref           | uuid                | YES      | NULL              | EXT REF EC-03 | Quote pinneada cuando política comercial lo exige.                                               | q…                 |
| corporate_enrollment_batch_ref | uuid                | YES      | NULL              | EXT REF EC-09 | Contexto corporativo sin copiar contrato.                                                        | ceb…               |
| state                          | varchar(28)         | NO       | 'DRAFT'           | CHECK         | DRAFT/SUBMITTED/VALIDATING/ELIGIBLE/WAITLISTED/PRE_ENROLLED/ENROLLED/REJECTED/CANCELLED/EXPIRED. | ELIGIBLE           |
| submitted_at                   | timestamptz         | YES      | NULL              | —             | Submit UTC.                                                                                      | …                  |
| decision_at                    | timestamptz         | YES      | NULL              | —             | Última decisión admission.                                                                       | …                  |
| reason_code                    | varchar(100)        | YES      | NULL              | —             | Reason code estable para rechazo/cancelación.                                                    | ELIGIBILITY_FAILED |
| policy_snapshot_json           | jsonb               | NO       | '{}'::jsonb       | CHECK         | PolicyVersion refs usadas para reconstrucción.                                                   | {"admission":"…"}  |
| created_by_subject             | uuid                | NO       | —                 | EXT REF IAM   | Actor creador o self subject.                                                                    | usr…               |
| created_at                     | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                                        | 2026-09-09T18:00Z  |
| updated_at                     | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                                         | 2026-09-09T18:30Z  |
| version                        | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.                       | 7                  |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**registration_id —** ID solicitud. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: reg….

**registration_number —** Número legible tenant-aware. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: REG-2026-001337.

**participant_id —** ParticipantProfile solicitante. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pt….

**offering_ref —** Offering objetivo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**edition_ref —** ProgramEdition pinneada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ed….

**cohort_ref —** Cohorte objetivo cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: coh….

**program_version_ref —** ProgramVersion ejecutada por la edición. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pv….

**registration_channel_code —** SELF_SERVICE/STAFF/CORPORATE/IMPORT/etc. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: SELF_SERVICE.

**source_invitation_id —** Invitación origen. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: inv….

**source_batch_item_id —** Item de lote origen. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: bi….

**commercial_quote_ref —** Quote pinneada cuando política comercial lo exige. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: q….

**corporate_enrollment_batch_ref —** Contexto corporativo sin copiar contrato. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ceb….

**state —** DRAFT/SUBMITTED/VALIDATING/ELIGIBLE/WAITLISTED/PRE_ENROLLED/ENROLLED/REJECTED/CANCELLED/EXPIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ELIGIBLE.

**submitted_at —** Submit UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**decision_at —** Última decisión admission. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**reason_code —** Reason code estable para rechazo/cancelación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ELIGIBILITY_FAILED.

**policy_snapshot_json —** PolicyVersion refs usadas para reconstrucción. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"admission":"…"}.

**created_by_subject —** Actor creador o self subject. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                                                                                                      | **Error que impide**                         |
|--------------------------------------|----------|-----------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------|
| **pk_ec04_registration_request**     | PK       | (tenant_id, registration_id)                                                                                                                  | Identidad/cruce tenant.                      |
| **uq_ec04_registration_number**      | UQ       | (tenant_id, registration_number)                                                                                                              | Número duplicado.                            |
| **fk_ec04_registration_participant** | FK       | (tenant_id, participant_id) REFERENCES ec04.ec04_participant_profile(tenant_id, participant_id)                                               | Participant cross-tenant/inexistente.        |
| **ck_ec04_registration_state**       | CHECK    | state IN ('DRAFT','SUBMITTED','VALIDATING','ELIGIBLE','WAITLISTED','PRE_ENROLLED','ENROLLED','REJECTED','CANCELLED','EXPIRED')                | Estado inválido.                             |
| **ck_ec04_registration_policy**      | CHECK    | jsonb_typeof(policy_snapshot_json)='object'                                                                                                   | Policy snapshot inválido.                    |
| **uq_ec04_registration_active**      | UQ_INDEX | (tenant_id, participant_id, offering_ref) WHERE state IN ('DRAFT','SUBMITTED','VALIDATING','ELIGIBLE','WAITLISTED','PRE_ENROLLED','ENROLLED') | Solicitudes activas duplicadas por offering. |
| **ix_ec04_registration_offering**    | INDEX    | (tenant_id, offering_ref, state, created_at)                                                                                                  | Desk por offering lento.                     |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Número duplicado.; Participant cross-tenant/inexistente.; Estado inválido.; Policy snapshot inválido.; Solicitudes activas duplicadas por offering.; Desk por offering lento. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.5 ec04_registration_batch

**QUÉ REPRESENTA —** Lote de intake para registro masivo, grupal, corporativo o migrado. Agrupa items pero no convierte a la empresa/sponsor en participante.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root creado por Corporate Intake, Staff o CT-16. Cada item se procesa idempotentemente hacia participant/registration; el batch mantiene resumen y OperationStatus para procesos grandes.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege batch key, source/provenance y conteos. No es Corporate Agreement EC-09 ni enrollment group.

| **Campo**                      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**              | **Descripción**                                                                  | **Ejemplo**       |
|--------------------------------|---------------------|----------|-------------------|------------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                      | uuid                | NO       | —                 | PK\*                   | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| registration_batch_id          | uuid                | NO       | gen_random_uuid() | PK                     | ID lote.                                                                         | rb…               |
| batch_number                   | varchar(64)         | NO       | —                 | UQ                     | Número legible.                                                                  | RB-2026-0009      |
| batch_type                     | varchar(24)         | NO       | —                 | CHECK                  | CORPORATE/GROUP/IMPORT/STAFF_BULK.                                               | CORPORATE         |
| offering_ref                   | uuid                | NO       | —                 | EXT REF EC-02          | Offering común.                                                                  | off…              |
| corporate_enrollment_batch_ref | uuid                | YES      | NULL              | EXT REF EC-09          | Lote corporativo contractual cuando aplica.                                      | ceb…              |
| source_batch_ref               | varchar(160)        | YES      | NULL              | EXT REF CT-16/EXTERNAL | Referencia source para idempotencia/lineage.                                     | legacy:batch-77   |
| state                          | varchar(24)         | NO       | 'DRAFT'           | CHECK                  | DRAFT/VALIDATING/READY/PROCESSING/PARTIAL/SUCCEEDED/FAILED/CANCELLED.            | PROCESSING        |
| item_count                     | integer             | NO       | 0                 | CHECK                  | Total items declarados.                                                          | 100               |
| succeeded_count                | integer             | NO       | 0                 | CHECK                  | Items promovidos.                                                                | 95                |
| failed_count                   | integer             | NO       | 0                 | CHECK                  | Items fallidos.                                                                  | 5                 |
| operation_id                   | uuid                | YES      | NULL              | FK                     | OperationStatus para procesamiento async.                                        | op…               |
| created_by_subject             | uuid                | NO       | —                 | EXT REF IAM            | Actor solicitante.                                                               | usr…              |
| created_at                     | timestamptz         | NO       | now()             | —                      | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |
| updated_at                     | timestamptz         | NO       | now()             | —                      | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z |
| version                        | bigint              | NO       | 0                 | —                      | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**registration_batch_id —** ID lote. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: rb….

**batch_number —** Número legible. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: RB-2026-0009.

**batch_type —** CORPORATE/GROUP/IMPORT/STAFF_BULK. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CORPORATE.

**offering_ref —** Offering común. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**corporate_enrollment_batch_ref —** Lote corporativo contractual cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ceb….

**source_batch_ref —** Referencia source para idempotencia/lineage. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: legacy:batch-77.

**state —** DRAFT/VALIDATING/READY/PROCESSING/PARTIAL/SUCCEEDED/FAILED/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PROCESSING.

**item_count —** Total items declarados. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 100.

**succeeded_count —** Items promovidos. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 95.

**failed_count —** Items fallidos. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 5.

**operation_id —** OperationStatus para procesamiento async. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: op….

**created_by_subject —** Actor solicitante. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                                                                  | **Error que impide**         |
|-----------------------------------------|----------|-----------------------------------------------------------------------------------------------------------|------------------------------|
| **pk_ec04_registration_batch**          | PK       | (tenant_id, registration_batch_id)                                                                        | Identidad/cruce tenant.      |
| **uq_ec04_registration_batch_number**   | UQ       | (tenant_id, batch_number)                                                                                 | Número duplicado.            |
| **ck_ec04_registration_batch_type**     | CHECK    | batch_type IN ('CORPORATE','GROUP','IMPORT','STAFF_BULK')                                                 | Tipo inválido.               |
| **ck_ec04_registration_batch_state**    | CHECK    | state IN ('DRAFT','VALIDATING','READY','PROCESSING','PARTIAL','SUCCEEDED','FAILED','CANCELLED')           | Estado inválido.             |
| **ck_ec04_registration_batch_counts**   | CHECK    | item_count\>=0 AND succeeded_count\>=0 AND failed_count\>=0 AND succeeded_count+failed_count\<=item_count | Conteos incoherentes.        |
| **ix_ec04_registration_batch_offering** | INDEX    | (tenant_id, offering_ref, state, created_at DESC)                                                         | Batches por offering lentos. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Número duplicado.; Tipo inválido.; Estado inválido.; Conteos incoherentes.; Batches por offering lentos. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec04_registration_batch_item

**QUÉ REPRESENTA —** Unidad individual de un RegistrationBatch. Conserva referencias canónicas/resolución y resultado de promoción, sin copiar PII innecesaria.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija del batch. Cada item puede resolver person_ref existente o resolution_ref CT-04; al promover crea participant_id/registration_id y conserva lineage.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege external_item_key idempotente y resultado por item. No es RegistrationRequest hasta promoción exitosa.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**            |
|-------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|------------------------|
| tenant_id               | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                   |
| batch_item_id           | uuid                | NO       | gen_random_uuid() | PK            | ID item.                                                                         | bi…                    |
| registration_batch_id   | uuid                | NO       | —                 | FK            | Batch padre.                                                                     | rb…                    |
| external_item_key       | varchar(160)        | NO       | —                 | UQ            | Clave estable del origen dentro del batch.                                       | EMP-0017               |
| person_ref              | uuid                | YES      | NULL              | EXT REF CT-04 | Persona ya resuelta.                                                             | person…                |
| identity_resolution_ref | uuid                | YES      | NULL              | EXT REF CT-04 | Receipt/proceso de resolución de identidad.                                      | idr…                   |
| source_payload_hash     | varchar(128)        | NO       | —                 | —             | Hash del payload normalizado, no PII raw.                                        | sha256:…               |
| state                   | varchar(24)         | NO       | 'PENDING'         | CHECK         | PENDING/VALID/INVALID/PROCESSING/SUCCEEDED/FAILED/SKIPPED.                       | SUCCEEDED              |
| participant_id          | uuid                | YES      | NULL              | FK            | Participant creado/encontrado.                                                   | pt…                    |
| registration_id         | uuid                | YES      | NULL              | FK            | Registration creada.                                                             | reg…                   |
| error_code              | varchar(100)        | YES      | NULL              | —             | Reason code si falla.                                                            | PERSON_AMBIGUOUS       |
| result_json             | jsonb               | YES      | NULL              | CHECK         | Resultado no sensible acotado.                                                   | {"registrationId":"…"} |
| created_at              | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T18:00Z      |
| updated_at              | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z      |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**batch_item_id —** ID item. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: bi….

**registration_batch_id —** Batch padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: rb….

**external_item_key —** Clave estable del origen dentro del batch. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EMP-0017.

**person_ref —** Persona ya resuelta. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**identity_resolution_ref —** Receipt/proceso de resolución de identidad. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: idr….

**source_payload_hash —** Hash del payload normalizado, no PII raw. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**state —** PENDING/VALID/INVALID/PROCESSING/SUCCEEDED/FAILED/SKIPPED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: SUCCEEDED.

**participant_id —** Participant creado/encontrado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pt….

**registration_id —** Registration creada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**error_code —** Reason code si falla. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PERSON_AMBIGUOUS.

**result_json —** Resultado no sensible acotado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"registrationId":"…"}.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                                                                     | **Error que impide**    |
|-------------------------------------|----------|--------------------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec04_registration_batch_item** | PK       | (tenant_id, batch_item_id)                                                                                   | Identidad/cruce tenant. |
| **fk_ec04_batch_item_batch**        | FK       | (tenant_id, registration_batch_id) REFERENCES ec04.ec04_registration_batch(tenant_id, registration_batch_id) | Item huérfano.          |
| **uq_ec04_batch_item_key**          | UQ       | (tenant_id, registration_batch_id, external_item_key)                                                        | Item duplicado.         |
| **ck_ec04_batch_item_state**        | CHECK    | state IN ('PENDING','VALID','INVALID','PROCESSING','SUCCEEDED','FAILED','SKIPPED')                           | Estado inválido.        |
| **ck_ec04_batch_item_result**       | CHECK    | result_json IS NULL OR jsonb_typeof(result_json)='object'                                                    | Resultado inválido.     |
| **ix_ec04_batch_item_state**        | INDEX    | (tenant_id, registration_batch_id, state)                                                                    | Procesamiento lento.    |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Item huérfano.; Item duplicado.; Estado inválido.; Resultado inválido.; Procesamiento lento. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.7 ec04_eligibility_decision_receipt

**QUÉ REPRESENTA —** Receipt inmutable de una decisión de elegibilidad evaluada por CT-15 para una RegistrationRequest y una PolicyVersion concreta.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se crea al consultar CT-15 y forma parte del Evidence Pack de admission. Si la regla cambia, una reevaluación crea otro receipt; no sobrescribe el anterior.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege reconstructibilidad y evita implementar un motor local. No es la regla CT-15 ni la decisión final de matrícula por sí sola.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| eligibility_receipt_id | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                      | er…               |
| registration_id        | uuid                | NO       | —                 | FK               | Registration evaluada.                                                           | reg…              |
| eligibility_rule_ref   | uuid                | NO       | —                 | EXT REF CT-15    | Regla/version evaluada.                                                          | rule…             |
| decision_ref           | uuid                | NO       | —                 | EXT REF CT-15    | ID decisión externa.                                                             | dec…              |
| decision               | varchar(24)         | NO       | —                 | CHECK            | ELIGIBLE/INELIGIBLE/CONDITIONAL/UNKNOWN.                                         | ELIGIBLE          |
| reason_codes_json      | jsonb               | NO       | '\[\]'::jsonb     | CHECK            | Reason codes retornados.                                                         | \["OK"\]          |
| input_snapshot_hash    | varchar(128)        | NO       | —                 | —                | Hash del input evaluado.                                                         | sha256:…          |
| policy_version_ref     | uuid                | NO       | —                 | EXT REF CT-15/02 | Versión de política pinneada.                                                    | polv…             |
| decided_at             | timestamptz         | NO       | —                 | —                | Instante de decisión.                                                            | …                 |
| evidence_ref           | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidence pack externo cuando aplica.                                             | ev…               |
| created_at             | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**eligibility_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: er….

**registration_id —** Registration evaluada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**eligibility_rule_ref —** Regla/version evaluada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: rule….

**decision_ref —** ID decisión externa. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: dec….

**decision —** ELIGIBLE/INELIGIBLE/CONDITIONAL/UNKNOWN. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: ELIGIBLE.

**reason_codes_json —** Reason codes retornados. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '\[\]'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: \["OK"\].

**input_snapshot_hash —** Hash del input evaluado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**policy_version_ref —** Versión de política pinneada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: polv….

**decided_at —** Instante de decisión. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**evidence_ref —** Evidence pack externo cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                                                           | **Error que impide**    |
|--------------------------------------|----------|----------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec04_eligibility_receipt**      | PK       | (tenant_id, eligibility_receipt_id)                                                                | Identidad/cruce tenant. |
| **fk_ec04_eligibility_registration** | FK       | (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id) | Receipt huérfano.       |
| **ck_ec04_eligibility_decision**     | CHECK    | decision IN ('ELIGIBLE','INELIGIBLE','CONDITIONAL','UNKNOWN')                                      | Decisión inválida.      |
| **ck_ec04_eligibility_reasons**      | CHECK    | jsonb_typeof(reason_codes_json)='array'                                                            | Reasons mal formados.   |
| **ix_ec04_eligibility_registration** | INDEX    | (tenant_id, registration_id, decided_at DESC)                                                      | History lenta.          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Receipt huérfano.; Decisión inválida.; Reasons mal formados.; History lenta. |
|-------------------------------------------------------------------------------------------------------------------------------------------|

## 12.8 ec04_identity_assurance_receipt

**QUÉ REPRESENTA —** Receipt inmutable del nivel de assurance/verification de identidad requerido para la RegistrationRequest, referenciando la autoridad CT-04/IAM.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se crea cuando la política exige verificación. Registration no interpreta documentos crudos; consume resultado y assurance_level_code. Nuevas verificaciones generan nuevos receipts.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege provenance de identidad sin almacenar biometría/documentos. No reemplaza CT-04/IAM ni sus evidencias.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**         | **Descripción**                                                                  | **Ejemplo**       |
|----------------------|---------------------|----------|-------------------|-------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id            | uuid                | NO       | —                 | PK\*              | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| identity_receipt_id  | uuid                | NO       | gen_random_uuid() | PK                | ID receipt.                                                                      | iar…              |
| registration_id      | uuid                | NO       | —                 | FK                | Registration.                                                                    | reg…              |
| person_ref           | uuid                | NO       | —                 | EXT REF CT-04     | Persona verificada.                                                              | person…           |
| verification_ref     | uuid                | NO       | —                 | EXT REF CT-04/IAM | Verificación externa.                                                            | ver…              |
| assurance_level_code | varchar(40)         | NO       | —                 | EXT REF CT-02/IAM | Nivel de assurance alcanzado.                                                    | AAL2              |
| result               | varchar(24)         | NO       | —                 | CHECK             | VERIFIED/NOT_VERIFIED/REVIEW_REQUIRED/UNKNOWN.                                   | VERIFIED          |
| verified_at          | timestamptz         | NO       | —                 | —                 | Instante UTC.                                                                    | …                 |
| evidence_ref         | uuid                | YES      | NULL              | EXT REF CT-05/10  | Evidence ref, no blob.                                                           | ev…               |
| created_at           | timestamptz         | NO       | now()             | —                 | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**identity_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: iar….

**registration_id —** Registration. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**person_ref —** Persona verificada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**verification_ref —** Verificación externa. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ver….

**assurance_level_code —** Nivel de assurance alcanzado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: AAL2.

**result —** VERIFIED/NOT_VERIFIED/REVIEW_REQUIRED/UNKNOWN. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: VERIFIED.

**verified_at —** Instante UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**evidence_ref —** Evidence ref, no blob. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                                                           | **Error que impide**    |
|-----------------------------------|----------|----------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec04_identity_receipt**      | PK       | (tenant_id, identity_receipt_id)                                                                   | Identidad/cruce tenant. |
| **fk_ec04_identity_registration** | FK       | (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id) | Receipt huérfano.       |
| **ck_ec04_identity_result**       | CHECK    | result IN ('VERIFIED','NOT_VERIFIED','REVIEW_REQUIRED','UNKNOWN')                                  | Resultado inválido.     |
| **ix_ec04_identity_registration** | INDEX    | (tenant_id, registration_id, verified_at DESC)                                                     | Consulta lenta.         |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Receipt huérfano.; Resultado inválido.; Consulta lenta. |
|----------------------------------------------------------------------------------------------------------------------|

## 12.9 ec04_registration_requirement

**QUÉ REPRESENTA —** Condición concreta que debe satisfacerse para que una RegistrationRequest avance: identidad, documento, elegibilidad, consentimiento, condición comercial u otra policy-driven.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija del aggregate RegistrationRequest. Se deriva de ProgramVersion/Offering/Policies y se resuelve por ports externos o acciones humanas gobernadas. Cambios mutables bump de aggregate revision.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege obligatoriedad, due date y estado de fulfillment. No guarda el documento ni ejecuta CT-15/Finanzas.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**        |
|-----------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|--------------------|
| tenant_id                   | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…               |
| registration_requirement_id | uuid                | NO       | gen_random_uuid() | PK               | ID requisito.                                                                    | rr…                |
| registration_id             | uuid                | NO       | —                 | FK               | Registration padre.                                                              | reg…               |
| requirement_code            | varchar(80)         | NO       | —                 | UQ               | Código estable dentro de registration.                                           | IDENTITY_AAL2      |
| requirement_kind            | varchar(24)         | NO       | —                 | CHECK            | IDENTITY/DOCUMENT/ELIGIBILITY/COMMERCIAL/CONSENT/OTHER.                          | IDENTITY           |
| source_policy_ref           | uuid                | NO       | —                 | EXT REF CT-02/15 | PolicyVersion que origina el requisito.                                          | polv…              |
| mandatory                   | boolean             | NO       | true              | —                | Si bloquea advancement.                                                          | true               |
| due_at                      | timestamptz         | YES      | NULL              | —                | Fecha/hora límite cuando aplica.                                                 | …                  |
| state                       | varchar(24)         | NO       | 'PENDING'         | CHECK            | PENDING/SATISFIED/WAIVED/FAILED/EXPIRED.                                         | SATISFIED          |
| waiver_workflow_ref         | uuid                | YES      | NULL              | EXT REF CT-06    | Workflow de excepción si existe.                                                 | wf…                |
| reason_code                 | varchar(100)        | YES      | NULL              | —                | Reason de waive/fail.                                                            | APPROVED_EXCEPTION |
| created_at                  | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                        | 2026-09-09T18:00Z  |
| updated_at                  | timestamptz         | NO       | now()             | —                | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z  |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**registration_requirement_id —** ID requisito. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: rr….

**registration_id —** Registration padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**requirement_code —** Código estable dentro de registration. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: IDENTITY_AAL2.

**requirement_kind —** IDENTITY/DOCUMENT/ELIGIBILITY/COMMERCIAL/CONSENT/OTHER. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: IDENTITY.

**source_policy_ref —** PolicyVersion que origina el requisito. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: polv….

**mandatory —** Si bloquea advancement. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es true; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**due_at —** Fecha/hora límite cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**state —** PENDING/SATISFIED/WAIVED/FAILED/EXPIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: SATISFIED.

**waiver_workflow_ref —** Workflow de excepción si existe. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**reason_code —** Reason de waive/fail. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: APPROVED_EXCEPTION.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                                                           | **Error que impide**                |
|--------------------------------------|----------|----------------------------------------------------------------------------------------------------|-------------------------------------|
| **pk_ec04_registration_requirement** | PK       | (tenant_id, registration_requirement_id)                                                           | Identidad/cruce tenant.             |
| **fk_ec04_requirement_registration** | FK       | (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id) | Requisito huérfano.                 |
| **uq_ec04_requirement_code**         | UQ       | (tenant_id, registration_id, requirement_code)                                                     | Requisito duplicado.                |
| **ck_ec04_requirement_kind**         | CHECK    | requirement_kind IN ('IDENTITY','DOCUMENT','ELIGIBILITY','COMMERCIAL','CONSENT','OTHER')           | Kind inválido.                      |
| **ck_ec04_requirement_state**        | CHECK    | state IN ('PENDING','SATISFIED','WAIVED','FAILED','EXPIRED')                                       | Estado inválido.                    |
| **ix_ec04_requirement_pending**      | INDEX    | (tenant_id, due_at) WHERE state='PENDING'                                                          | Pendientes vencidos no detectables. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Requisito huérfano.; Requisito duplicado.; Kind inválido.; Estado inválido.; Pendientes vencidos no detectables. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec04_registration_requirement_result

**QUÉ REPRESENTA —** Evidencia append-only de una evaluación/fulfillment de RegistrationRequirement. Permite múltiples intentos o reevaluaciones sin borrar historia.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity histórica creada por adapters CT-04/05/15/Finance/CT-10 o staff autorizado. El estado current del requisito se deriva de la última decisión válida aplicada por dominio.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lineage y evidence refs. No almacena datos sensibles del documento/identidad ni modifica directamente el requisito pasado.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo** |
|-----------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|-------------|
| tenant_id                   | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…        |
| requirement_result_id       | uuid                | NO       | gen_random_uuid() | PK               | ID resultado.                                                                    | rrr…        |
| registration_requirement_id | uuid                | NO       | —                 | FK               | Requisito evaluado.                                                              | rr…         |
| result                      | varchar(24)         | NO       | —                 | CHECK            | SATISFIED/FAILED/WAIVED/UNKNOWN.                                                 | SATISFIED   |
| source_context              | varchar(40)         | NO       | —                 | —                | CT04/CT05/CT15/FINANCE/CT10/STAFF.                                               | CT15        |
| source_receipt_ref          | uuid                | YES      | NULL              | EXT REF          | Receipt externo.                                                                 | dec…        |
| evidence_ref                | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidence ref.                                                                    | ev…         |
| reason_code                 | varchar(100)        | YES      | NULL              | —                | Reason estable.                                                                  | OK          |
| evaluated_by_subject        | uuid                | YES      | NULL              | EXT REF IAM      | Actor cuando evaluación humana.                                                  | usr…        |
| evaluated_at                | timestamptz         | NO       | now()             | —                | Instante UTC.                                                                    | …           |
| payload_hash                | varchar(128)        | NO       | —                 | —                | Hash del resultado normalizado.                                                  | sha256:…    |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**requirement_result_id —** ID resultado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: rrr….

**registration_requirement_id —** Requisito evaluado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: rr….

**result —** SATISFIED/FAILED/WAIVED/UNKNOWN. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: SATISFIED.

**source_context —** CT04/CT05/CT15/FINANCE/CT10/STAFF. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CT15.

**source_receipt_ref —** Receipt externo. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: dec….

**evidence_ref —** Evidence ref. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**reason_code —** Reason estable. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: OK.

**evaluated_by_subject —** Actor cuando evaluación humana. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**evaluated_at —** Instante UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**payload_hash —** Hash del resultado normalizado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

### Constraints físicos implementables

| **Nombre físico**                      | **Tipo** | **Definición/expresión**                                                                                                       | **Error que impide**    |
|----------------------------------------|----------|--------------------------------------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec04_requirement_result**         | PK       | (tenant_id, requirement_result_id)                                                                                             | Identidad/cruce tenant. |
| **fk_ec04_result_requirement**         | FK       | (tenant_id, registration_requirement_id) REFERENCES ec04.ec04_registration_requirement(tenant_id, registration_requirement_id) | Resultado huérfano.     |
| **ck_ec04_requirement_result**         | CHECK    | result IN ('SATISFIED','FAILED','WAIVED','UNKNOWN')                                                                            | Resultado inválido.     |
| **ix_ec04_requirement_result_history** | INDEX    | (tenant_id, registration_requirement_id, evaluated_at DESC)                                                                    | History lenta.          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Resultado huérfano.; Resultado inválido.; History lenta. |
|-----------------------------------------------------------------------------------------------------------------------|

## 12.11 ec04_capacity_pool

**QUÉ REPRESENTA —** Pool de capacidad admisible para un Offering/Cohort y, opcionalmente, un segmento de cupo. Es el Source of Truth de cupos enforceables de EC-04.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root operado por Capacity Manager. SeatReservation y Enrollment consumen capacidad bajo lock transaccional. EC-02 aporta scope operacional; EC-04 controla disponibilidad real y waitlist.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege hard capacity, overbook explícito, contadores no negativos y scope. No es aula/recurso CT-14 ni número de asistentes observados EC-06.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|---------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id           | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| capacity_pool_id    | uuid                | NO       | gen_random_uuid() | PK            | ID pool.                                                                         | cpool…            |
| offering_ref        | uuid                | NO       | —                 | EXT REF EC-02 | Offering propietario.                                                            | off…              |
| cohort_ref          | uuid                | YES      | NULL              | EXT REF EC-02 | Cohorte específica si aplica.                                                    | coh…              |
| segment_code        | varchar(80)         | NO       | 'GENERAL'         | EXT REF CT-02 | GENERAL/CORPORATE/SCHOLARSHIP/etc parametrizado.                                 | GENERAL           |
| capacity_mode       | varchar(16)         | NO       | 'FIXED'           | CHECK         | FIXED/UNLIMITED.                                                                 | FIXED             |
| hard_capacity       | integer             | YES      | NULL              | CHECK         | Capacidad base si FIXED.                                                         | 40                |
| overbook_limit      | integer             | NO       | 0                 | CHECK         | Sobreventa explícita permitida por policy.                                       | 0                 |
| current_reserved    | integer             | NO       | 0                 | CHECK         | Seats HELD.                                                                      | 3                 |
| current_enrolled    | integer             | NO       | 0                 | CHECK         | Enrollments activos que consumen seat.                                           | 35                |
| current_waitlisted  | integer             | NO       | 0                 | CHECK         | Waitlist entries activas/ofertadas.                                              | 12                |
| waitlist_enabled    | boolean             | NO       | true              | —             | Habilita lista de espera.                                                        | true              |
| capacity_policy_ref | uuid                | NO       | —                 | EXT REF CT-02 | PolicyVersion de capacidad/promoción.                                            | polv…             |
| state               | varchar(20)         | NO       | 'OPEN'            | CHECK         | OPEN/FROZEN/CLOSED/RETIRED.                                                      | OPEN              |
| created_by_subject  | uuid                | NO       | —                 | EXT REF IAM   | Actor creador.                                                                   | usr…              |
| created_at          | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |
| updated_at          | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z |
| version             | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**capacity_pool_id —** ID pool. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cpool….

**offering_ref —** Offering propietario. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**cohort_ref —** Cohorte específica si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: coh….

**segment_code —** GENERAL/CORPORATE/SCHOLARSHIP/etc parametrizado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'GENERAL'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: GENERAL.

**capacity_mode —** FIXED/UNLIMITED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'FIXED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: FIXED.

**hard_capacity —** Capacidad base si FIXED. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 40.

**overbook_limit —** Sobreventa explícita permitida por policy. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 0.

**current_reserved —** Seats HELD. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 3.

**current_enrolled —** Enrollments activos que consumen seat. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 35.

**current_waitlisted —** Waitlist entries activas/ofertadas. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 12.

**waitlist_enabled —** Habilita lista de espera. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es true; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**capacity_policy_ref —** PolicyVersion de capacidad/promoción. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: polv….

**state —** OPEN/FROZEN/CLOSED/RETIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'OPEN'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: OPEN.

**created_by_subject —** Actor creador. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**             | **Tipo** | **Definición/expresión**                                                                                                                                  | **Error que impide**     |
|-------------------------------|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------|
| **pk_ec04_capacity_pool**     | PK       | (tenant_id, capacity_pool_id)                                                                                                                             | Identidad/cruce tenant.  |
| **uq_ec04_capacity_scope**    | UQ_INDEX | (tenant_id, offering_ref, COALESCE(cohort_ref,'00000000-0000-0000-0000-000000000000'::uuid), segment_code)                                                | Pool duplicado.          |
| **ck_ec04_capacity_mode**     | CHECK    | capacity_mode IN ('FIXED','UNLIMITED')                                                                                                                    | Modo inválido.           |
| **ck_ec04_capacity_shape**    | CHECK    | (capacity_mode='FIXED' AND hard_capacity IS NOT NULL AND hard_capacity\>=0) OR (capacity_mode='UNLIMITED' AND hard_capacity IS NULL AND overbook_limit=0) | Shape incoherente.       |
| **ck_ec04_capacity_counters** | CHECK    | current_reserved\>=0 AND current_enrolled\>=0 AND current_waitlisted\>=0 AND overbook_limit\>=0                                                           | Contador negativo.       |
| **ck_ec04_capacity_limit**    | CHECK    | capacity_mode='UNLIMITED' OR current_reserved+current_enrolled \<= hard_capacity+overbook_limit                                                           | Oversubscription física. |
| **ck_ec04_capacity_state**    | CHECK    | state IN ('OPEN','FROZEN','CLOSED','RETIRED')                                                                                                             | Estado inválido.         |
| **ix_ec04_capacity_offering** | INDEX    | (tenant_id, offering_ref, state)                                                                                                                          | Consulta lenta.          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Pool duplicado.; Modo inválido.; Shape incoherente.; Contador negativo.; Oversubscription física.; Estado inválido.; Consulta lenta. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec04_capacity_adjustment

**QUÉ REPRESENTA —** Ajuste histórico de hard capacity/overbook/segmento autorizado. Evita editar capacidad sin reason/evidence y permite reconstruir por qué cambió un cupo.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Append-only command result asociado a CapacityPool. Un ajuste aprobado aplica delta/valor dentro de una transacción que revalida ocupación y policy; CT-06 puede gobernar overrides.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege reason, actor y before/after. No representa reserva de seat.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**   |
|------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|---------------|
| tenant_id              | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…          |
| capacity_adjustment_id | uuid                | NO       | gen_random_uuid() | PK               | ID ajuste.                                                                       | cadj…         |
| capacity_pool_id       | uuid                | NO       | —                 | FK               | Pool afectado.                                                                   | cpool…        |
| adjustment_type        | varchar(24)         | NO       | —                 | CHECK            | HARD_CAPACITY/OVERBOOK_LIMIT/FREEZE/REOPEN.                                      | HARD_CAPACITY |
| before_value           | integer             | YES      | NULL              | —                | Valor anterior cuando numérico.                                                  | 40            |
| after_value            | integer             | YES      | NULL              | —                | Valor posterior.                                                                 | 45            |
| reason_code            | varchar(100)        | NO       | —                 | —                | Reason estable.                                                                  | ROOM_CHANGED  |
| workflow_ref           | uuid                | YES      | NULL              | EXT REF CT-06    | Aprobación si política exige.                                                    | wf…           |
| evidence_ref           | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidencia.                                                                       | ev…           |
| applied_by_subject     | uuid                | NO       | —                 | EXT REF IAM      | Actor.                                                                           | usr…          |
| applied_at             | timestamptz         | NO       | now()             | —                | Aplicación UTC.                                                                  | …             |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**capacity_adjustment_id —** ID ajuste. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cadj….

**capacity_pool_id —** Pool afectado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpool….

**adjustment_type —** HARD_CAPACITY/OVERBOOK_LIMIT/FREEZE/REOPEN. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: HARD_CAPACITY.

**before_value —** Valor anterior cuando numérico. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 40.

**after_value —** Valor posterior. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 45.

**reason_code —** Reason estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: ROOM_CHANGED.

**workflow_ref —** Aprobación si política exige. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**evidence_ref —** Evidencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**applied_by_subject —** Actor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**applied_at —** Aplicación UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                                                                 | **Error que impide**      |
|-----------------------------------------|----------|----------------------------------------------------------------------------------------------------------|---------------------------|
| **pk_ec04_capacity_adjustment**         | PK       | (tenant_id, capacity_adjustment_id)                                                                      | Identidad/cruce tenant.   |
| **fk_ec04_capacity_adjustment_pool**    | FK       | (tenant_id, capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id)            | Ajuste huérfano.          |
| **ck_ec04_capacity_adjustment_type**    | CHECK    | adjustment_type IN ('HARD_CAPACITY','OVERBOOK_LIMIT','FREEZE','REOPEN')                                  | Tipo inválido.            |
| **ck_ec04_capacity_adjustment_values**  | CHECK    | (before_value IS NULL AND after_value IS NULL) OR (before_value IS NOT NULL AND after_value IS NOT NULL) | Before/after incompletos. |
| **ix_ec04_capacity_adjustment_history** | INDEX    | (tenant_id, capacity_pool_id, applied_at DESC)                                                           | History lenta.            |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Ajuste huérfano.; Tipo inválido.; Before/after incompletos.; History lenta. |
|------------------------------------------------------------------------------------------------------------------------------------------|

## 12.13 ec04_seat_reservation

**QUÉ REPRESENTA —** Hold durable y temporal de un cupo para una RegistrationRequest, WaitlistOffer o PreEnrollment. Es la unidad de concurrencia que evita vender/matricular el mismo seat más veces de lo permitido.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate operativo creado bajo lock de CapacityPool. HELD incrementa current_reserved; CONSUMED transfiere contador a current_enrolled; RELEASED/EXPIRED libera. Se usa en transacciones de promotion/enrollment.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lease/expiración, un hold activo por registration/pool y capacity limit. No es Enrollment ni pago.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                                                                  | **Ejemplo**            |
|---------------------|---------------------|----------|-------------------|-------------|----------------------------------------------------------------------------------|------------------------|
| tenant_id           | uuid                | NO       | —                 | PK\*        | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                   |
| seat_reservation_id | uuid                | NO       | gen_random_uuid() | PK          | ID hold.                                                                         | seat…                  |
| capacity_pool_id    | uuid                | NO       | —                 | FK          | Pool consumido.                                                                  | cpool…                 |
| registration_id     | uuid                | NO       | —                 | FK          | Registration propietaria.                                                        | reg…                   |
| waitlist_offer_id   | uuid                | YES      | NULL              | FK          | Oferta de waitlist origen cuando aplica.                                         | wo…                    |
| state               | varchar(20)         | NO       | 'HELD'            | CHECK       | HELD/CONSUMED/RELEASED/EXPIRED.                                                  | HELD                   |
| held_at             | timestamptz         | NO       | now()             | —           | Inicio hold.                                                                     | …                      |
| expires_at          | timestamptz         | YES      | NULL              | CHECK       | Expiración requerida para HELD temporal.                                         | …                      |
| consumed_at         | timestamptz         | YES      | NULL              | —           | Conversión a seat enrolled.                                                      | …                      |
| released_at         | timestamptz         | YES      | NULL              | —           | Liberación.                                                                      | …                      |
| reason_code         | varchar(100)        | YES      | NULL              | —           | Reason release/expiry.                                                           | PAYMENT_WINDOW_EXPIRED |
| created_by_subject  | uuid                | NO       | —                 | EXT REF IAM | Actor/sistema.                                                                   | usr…                   |
| created_at          | timestamptz         | NO       | now()             | —           | Instante UTC de creación.                                                        | 2026-09-09T18:00Z      |
| updated_at          | timestamptz         | NO       | now()             | —           | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z      |
| version             | bigint              | NO       | 0                 | —           | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                      |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**seat_reservation_id —** ID hold. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: seat….

**capacity_pool_id —** Pool consumido. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpool….

**registration_id —** Registration propietaria. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**waitlist_offer_id —** Oferta de waitlist origen cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: wo….

**state —** HELD/CONSUMED/RELEASED/EXPIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'HELD'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: HELD.

**held_at —** Inicio hold. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**expires_at —** Expiración requerida para HELD temporal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**consumed_at —** Conversión a seat enrolled. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**released_at —** Liberación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**reason_code —** Reason release/expiry. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PAYMENT_WINDOW_EXPIRED.

**created_by_subject —** Actor/sistema. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                                                           | **Error que impide**                               |
|--------------------------------------|----------|----------------------------------------------------------------------------------------------------|----------------------------------------------------|
| **pk_ec04_seat_reservation**         | PK       | (tenant_id, seat_reservation_id)                                                                   | Identidad/cruce tenant.                            |
| **fk_ec04_seat_pool**                | FK       | (tenant_id, capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id)      | Pool cross-tenant.                                 |
| **fk_ec04_seat_registration**        | FK       | (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id) | Registration inválida.                             |
| **ck_ec04_seat_state**               | CHECK    | state IN ('HELD','CONSUMED','RELEASED','EXPIRED')                                                  | Estado inválido.                                   |
| **ck_ec04_seat_expiry**              | CHECK    | expires_at IS NULL OR expires_at \> held_at                                                        | Expiración inválida.                               |
| **uq_ec04_seat_active_registration** | UQ_INDEX | (tenant_id, registration_id, capacity_pool_id) WHERE state='HELD'                                  | Dos holds activos para la misma registration/pool. |
| **ix_ec04_seat_expiry**              | INDEX    | (tenant_id, expires_at) WHERE state='HELD'                                                         | Holds vencidos no reclamables.                     |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Pool cross-tenant.; Registration inválida.; Estado inválido.; Expiración inválida.; Dos holds activos para la misma registration/pool.; Holds vencidos no reclamables. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec04_waitlist_entry

**QUÉ REPRESENTA —** Entrada durable de una RegistrationRequest en la lista de espera de un CapacityPool. El orden se deriva de policy/priority + timestamp, no de un rank mutable arbitrario.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate operativo. Promotion worker selecciona candidatos bajo policy y crea WaitlistOffer + SeatReservation de manera transaccional. AI puede estimar probabilidad, nunca alterar prioridad oficial.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege una entrada activa por registration/pool, ordering inputs y status. No garantiza seat ni Enrollment.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|---------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id           | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| waitlist_entry_id   | uuid                | NO       | gen_random_uuid() | PK            | ID entry.                                                                        | wl…               |
| capacity_pool_id    | uuid                | NO       | —                 | FK            | Pool.                                                                            | cpool…            |
| registration_id     | uuid                | NO       | —                 | FK            | Registration.                                                                    | reg…              |
| priority_bucket     | integer             | NO       | 0                 | CHECK         | Bucket gobernado por policy; mayor prioridad según contrato.                     | 10                |
| priority_score      | numeric(12,4)       | NO       | 0                 | CHECK         | Score determinista no-IA o policy-approved.                                      | 100.0000          |
| priority_policy_ref | uuid                | NO       | —                 | EXT REF CT-02 | PolicyVersion que produjo prioridad.                                             | polv…             |
| enqueued_at         | timestamptz         | NO       | now()             | —             | Entrada UTC; desempate estable.                                                  | …                 |
| state               | varchar(20)         | NO       | 'ACTIVE'          | CHECK         | ACTIVE/OFFERED/ACCEPTED/EXPIRED/REMOVED.                                         | ACTIVE            |
| last_offer_id       | uuid                | YES      | NULL              | FK            | Última WaitlistOffer.                                                            | wo…               |
| reason_code         | varchar(100)        | YES      | NULL              | —             | Reason terminal.                                                                 | USER_CANCELLED    |
| created_at          | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |
| updated_at          | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z |
| version             | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**waitlist_entry_id —** ID entry. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: wl….

**capacity_pool_id —** Pool. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpool….

**registration_id —** Registration. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**priority_bucket —** Bucket gobernado por policy; mayor prioridad según contrato. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 10.

**priority_score —** Score determinista no-IA o policy-approved. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 100.0000.

**priority_policy_ref —** PolicyVersion que produjo prioridad. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: polv….

**enqueued_at —** Entrada UTC; desempate estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**state —** ACTIVE/OFFERED/ACCEPTED/EXPIRED/REMOVED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'ACTIVE'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**last_offer_id —** Última WaitlistOffer. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: wo….

**reason_code —** Reason terminal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: USER_CANCELLED.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                                                                                      | **Error que impide**      |
|-----------------------------------|----------|-------------------------------------------------------------------------------------------------------------------------------|---------------------------|
| **pk_ec04_waitlist_entry**        | PK       | (tenant_id, waitlist_entry_id)                                                                                                | Identidad/cruce tenant.   |
| **fk_ec04_waitlist_pool**         | FK       | (tenant_id, capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id)                                 | Pool inválido.            |
| **fk_ec04_waitlist_registration** | FK       | (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id)                            | Registration inválida.    |
| **ck_ec04_waitlist_bucket**       | CHECK    | priority_bucket\>=0 AND priority_score\>=0                                                                                    | Prioridad inválida.       |
| **ck_ec04_waitlist_state**        | CHECK    | state IN ('ACTIVE','OFFERED','ACCEPTED','EXPIRED','REMOVED')                                                                  | Estado inválido.          |
| **uq_ec04_waitlist_active**       | UQ_INDEX | (tenant_id, capacity_pool_id, registration_id) WHERE state IN ('ACTIVE','OFFERED')                                            | Entrada activa duplicada. |
| **ix_ec04_waitlist_promote**      | INDEX    | (tenant_id, capacity_pool_id, priority_bucket DESC, priority_score DESC, enqueued_at, waitlist_entry_id) WHERE state='ACTIVE' | Promotion ordering lento. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Pool inválido.; Registration inválida.; Prioridad inválida.; Estado inválido.; Entrada activa duplicada.; Promotion ordering lento. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec04_waitlist_offer

**QUÉ REPRESENTA —** Oferta temporal de un seat liberado a una WaitlistEntry. Define ventana de aceptación y vincula el SeatReservation creado para el candidato.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate operativo emitido por promotion worker. ISSUED debe venir acompañado de SeatReservation HELD en la misma transacción; aceptación convierte la ruta a PreEnrollment/Enrollment según policy.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege expiración, anti-replay y un offer activo por entry. No es garantía perpetua ni mensaje de CT-07.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| waitlist_offer_id        | uuid                | NO       | gen_random_uuid() | PK            | ID offer.                                                                        | wo…               |
| waitlist_entry_id        | uuid                | NO       | —                 | FK            | Entry destinataria.                                                              | wl…               |
| seat_reservation_id      | uuid                | YES      | NULL              | FK            | Hold asociado; requerido en ISSUED.                                              | seat…             |
| state                    | varchar(20)         | NO       | 'ISSUED'          | CHECK         | ISSUED/ACCEPTED/EXPIRED/CANCELLED.                                               | ISSUED            |
| issued_at                | timestamptz         | NO       | now()             | —             | Emisión UTC.                                                                     | …                 |
| expires_at               | timestamptz         | NO       | —                 | CHECK         | Fin ventana.                                                                     | …                 |
| accepted_at              | timestamptz         | YES      | NULL              | —             | Aceptación.                                                                      | …                 |
| notification_request_ref | uuid                | YES      | NULL              | EXT REF CT-07 | Notificación, no Source of Truth.                                                | notif…            |
| reason_code              | varchar(100)        | YES      | NULL              | —             | Reason terminal.                                                                 | OFFER_EXPIRED     |
| created_at               | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |
| updated_at               | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z |
| version                  | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**waitlist_offer_id —** ID offer. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: wo….

**waitlist_entry_id —** Entry destinataria. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: wl….

**seat_reservation_id —** Hold asociado; requerido en ISSUED. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: seat….

**state —** ISSUED/ACCEPTED/EXPIRED/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'ISSUED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ISSUED.

**issued_at —** Emisión UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**expires_at —** Fin ventana. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**accepted_at —** Aceptación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**notification_request_ref —** Notificación, no Source of Truth. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: notif….

**reason_code —** Reason terminal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: OFFER_EXPIRED.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                                                         | **Error que impide**    |
|-----------------------------------|----------|--------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec04_waitlist_offer**        | PK       | (tenant_id, waitlist_offer_id)                                                                   | Identidad/cruce tenant. |
| **fk_ec04_waitlist_offer_entry**  | FK       | (tenant_id, waitlist_entry_id) REFERENCES ec04.ec04_waitlist_entry(tenant_id, waitlist_entry_id) | Entry inválida.         |
| **ck_ec04_waitlist_offer_state**  | CHECK    | state IN ('ISSUED','ACCEPTED','EXPIRED','CANCELLED')                                             | Estado inválido.        |
| **ck_ec04_waitlist_offer_expiry** | CHECK    | expires_at \> issued_at                                                                          | Ventana inválida.       |
| **uq_ec04_waitlist_offer_active** | UQ_INDEX | (tenant_id, waitlist_entry_id) WHERE state='ISSUED'                                              | Dos offers activas.     |
| **ix_ec04_waitlist_offer_expiry** | INDEX    | (tenant_id, expires_at) WHERE state='ISSUED'                                                     | Expiraciones lentas.    |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Entry inválida.; Estado inválido.; Ventana inválida.; Dos offers activas.; Expiraciones lentas. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.16 ec04_pre_enrollment

**QUÉ REPRESENTA —** Estado intermedio durable que indica que la RegistrationRequest tiene una vía concreta a matrícula, pero aún mantiene condiciones pendientes o ventana de conversión.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root creado después de eligibility/capacity. Pinnea SeatReservation y policy snapshot. READY puede convertirse atómicamente a Enrollment cuando condiciones requeridas estén satisfechas.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege que PRE_ENROLLED ≠ ENROLLED y que una reserva/condición no se confunda con matrícula oficial. No es pago ni completion.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**          | **PK/FK**             | **Descripción**                                                                  | **Ejemplo**       |
|--------------------------|---------------------|----------|----------------------|-----------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                    | PK\*                  | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| pre_enrollment_id        | uuid                | NO       | gen_random_uuid()    | PK                    | ID pre-enrollment.                                                               | pre…              |
| pre_enrollment_number    | varchar(64)         | NO       | —                    | UQ                    | Número legible.                                                                  | PRE-2026-0033     |
| registration_id          | uuid                | NO       | —                    | FK                    | Registration origen.                                                             | reg…              |
| seat_reservation_id      | uuid                | NO       | —                    | FK                    | Seat hold pinneado.                                                              | seat…             |
| eligibility_receipt_id   | uuid                | NO       | —                    | FK                    | Última elegibilidad que sustenta.                                                | er…               |
| state                    | varchar(28)         | NO       | 'PENDING_CONDITIONS' | CHECK                 | PENDING_CONDITIONS/READY/CONVERTED/EXPIRED/CANCELLED.                            | READY             |
| commercial_clearance_ref | uuid                | YES      | NULL                 | EXT REF EC-03/Finance | Clearance/quote/financial ref cuando policy exige.                               | clr…              |
| identity_receipt_id      | uuid                | YES      | NULL                 | FK                    | Assurance receipt pinneado.                                                      | iar…              |
| expires_at               | timestamptz         | YES      | NULL                 | —                     | Ventana de pre-enrollment.                                                       | …                 |
| converted_enrollment_id  | uuid                | YES      | NULL                 | FK                    | Enrollment resultante.                                                           | enr…              |
| policy_snapshot_json     | jsonb               | NO       | '{}'::jsonb          | CHECK                 | Policies pinneadas.                                                              | {"admission":"…"} |
| created_by_subject       | uuid                | NO       | —                    | EXT REF IAM           | Actor/sistema.                                                                   | usr…              |
| created_at               | timestamptz         | NO       | now()                | —                     | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |
| updated_at               | timestamptz         | NO       | now()                | —                     | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z |
| version                  | bigint              | NO       | 0                    | —                     | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**pre_enrollment_id —** ID pre-enrollment. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pre….

**pre_enrollment_number —** Número legible. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PRE-2026-0033.

**registration_id —** Registration origen. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**seat_reservation_id —** Seat hold pinneado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: seat….

**eligibility_receipt_id —** Última elegibilidad que sustenta. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: er….

**state —** PENDING_CONDITIONS/READY/CONVERTED/EXPIRED/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING_CONDITIONS'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: READY.

**commercial_clearance_ref —** Clearance/quote/financial ref cuando policy exige. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: clr….

**identity_receipt_id —** Assurance receipt pinneado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: iar….

**expires_at —** Ventana de pre-enrollment. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**converted_enrollment_id —** Enrollment resultante. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: enr….

**policy_snapshot_json —** Policies pinneadas. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"admission":"…"}.

**created_by_subject —** Actor/sistema. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                                                                                 | **Error que impide**         |
|-----------------------------------|----------|--------------------------------------------------------------------------------------------------------------------------|------------------------------|
| **pk_ec04_pre_enrollment**        | PK       | (tenant_id, pre_enrollment_id)                                                                                           | Identidad/cruce tenant.      |
| **uq_ec04_pre_enrollment_number** | UQ       | (tenant_id, pre_enrollment_number)                                                                                       | Número duplicado.            |
| **fk_ec04_pre_registration**      | FK       | (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id)                       | Registration inválida.       |
| **fk_ec04_pre_seat**              | FK       | (tenant_id, seat_reservation_id) REFERENCES ec04.ec04_seat_reservation(tenant_id, seat_reservation_id)                   | Seat inválido.               |
| **fk_ec04_pre_eligibility**       | FK       | (tenant_id, eligibility_receipt_id) REFERENCES ec04.ec04_eligibility_decision_receipt(tenant_id, eligibility_receipt_id) | Elegibilidad inválida.       |
| **ck_ec04_pre_state**             | CHECK    | state IN ('PENDING_CONDITIONS','READY','CONVERTED','EXPIRED','CANCELLED')                                                | Estado inválido.             |
| **ck_ec04_pre_policy**            | CHECK    | jsonb_typeof(policy_snapshot_json)='object'                                                                              | Snapshot inválido.           |
| **uq_ec04_pre_active**            | UQ_INDEX | (tenant_id, registration_id) WHERE state IN ('PENDING_CONDITIONS','READY')                                               | Dos pre-enrollments activos. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Número duplicado.; Registration inválida.; Seat inválido.; Elegibilidad inválida.; Estado inválido.; Snapshot inválido.; Dos pre-enrollments activos. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.17 ec04_enrollment

**QUÉ REPRESENTA —** Hecho oficial de que un ParticipantProfile ha sido admitido/matriculado en un Offering/Edition/Cohort de Educación Continua. Pinnea las referencias académicas y operativas necesarias para historia.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root creado desde PreEnrollment o camino directo gobernado. Consume un SeatReservation y pasa el pool de reserved→enrolled. EC-06/07/08 consumen enrollment_id; cualquier retiro/transferencia conserva historia.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege participant/offering pinning, status oficial y provenance. No es payment, attendance, completion ni certificate.

| **Campo**                      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**       | **Descripción**                                                                  | **Ejemplo**              |
|--------------------------------|---------------------|----------|-------------------|-----------------|----------------------------------------------------------------------------------|--------------------------|
| tenant_id                      | uuid                | NO       | —                 | PK\*            | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                     |
| enrollment_id                  | uuid                | NO       | gen_random_uuid() | PK              | ID matrícula EC.                                                                 | enr…                     |
| enrollment_number              | varchar(64)         | NO       | —                 | UQ              | Número institucional.                                                            | ENR-2026-00551           |
| participant_id                 | uuid                | NO       | —                 | FK              | Participant.                                                                     | pt…                      |
| registration_id                | uuid                | NO       | —                 | FK              | Registration origen.                                                             | reg…                     |
| pre_enrollment_id              | uuid                | YES      | NULL              | FK              | PreEnrollment origen si existió.                                                 | pre…                     |
| capacity_pool_id               | uuid                | NO       | —                 | FK              | Pool de seat.                                                                    | cpool…                   |
| seat_reservation_id            | uuid                | NO       | —                 | FK              | Seat consumido.                                                                  | seat…                    |
| program_version_ref            | uuid                | NO       | —                 | EXT REF EC-01   | ProgramVersion histórica.                                                        | pv…                      |
| edition_ref                    | uuid                | NO       | —                 | EXT REF EC-02   | Edition.                                                                         | ed…                      |
| offering_ref                   | uuid                | NO       | —                 | EXT REF EC-02   | Offering.                                                                        | off…                     |
| cohort_ref                     | uuid                | YES      | NULL              | EXT REF EC-02   | Cohorte.                                                                         | coh…                     |
| corporate_enrollment_batch_ref | uuid                | YES      | NULL              | EXT REF EC-09   | Contexto corporativo.                                                            | ceb…                     |
| commercial_quote_ref           | uuid                | YES      | NULL              | EXT REF EC-03   | Quote/condición comercial pinneada.                                              | q…                       |
| financial_clearance_ref        | uuid                | YES      | NULL              | EXT REF Finance | Clearance financiero oficial cuando exigido.                                     | fin…                     |
| status                         | varchar(24)         | NO       | 'ACTIVE'          | CHECK           | ACTIVE/SUSPENDED/TRANSFER_PENDING/TRANSFERRED/WITHDRAWN/CANCELLED/VOID.          | ACTIVE                   |
| enrolled_at                    | timestamptz         | NO       | now()             | —               | Momento oficial de enrollment.                                                   | …                        |
| effective_from                 | timestamptz         | NO       | now()             | —               | Inicio de efecto académico.                                                      | …                        |
| effective_to                   | timestamptz         | YES      | NULL              | CHECK           | Fin por transferencia/retiro/cancelación.                                        | …                        |
| reason_code                    | varchar(100)        | YES      | NULL              | —               | Reason de status terminal.                                                       | WITHDRAWN_BY_PARTICIPANT |
| policy_snapshot_json           | jsonb               | NO       | '{}'::jsonb       | CHECK           | Policy versions que sustentan admisión.                                          | {"admission":"…"}        |
| created_by_subject             | uuid                | NO       | —                 | EXT REF IAM     | Actor creador.                                                                   | usr…                     |
| created_at                     | timestamptz         | NO       | now()             | —               | Instante UTC de creación.                                                        | 2026-09-09T18:00Z        |
| updated_at                     | timestamptz         | NO       | now()             | —               | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z        |
| version                        | bigint              | NO       | 0                 | —               | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                        |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**enrollment_id —** ID matrícula EC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: enr….

**enrollment_number —** Número institucional. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: ENR-2026-00551.

**participant_id —** Participant. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pt….

**registration_id —** Registration origen. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**pre_enrollment_id —** PreEnrollment origen si existió. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pre….

**capacity_pool_id —** Pool de seat. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpool….

**seat_reservation_id —** Seat consumido. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: seat….

**program_version_ref —** ProgramVersion histórica. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pv….

**edition_ref —** Edition. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ed….

**offering_ref —** Offering. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**cohort_ref —** Cohorte. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: coh….

**corporate_enrollment_batch_ref —** Contexto corporativo. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ceb….

**commercial_quote_ref —** Quote/condición comercial pinneada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: q….

**financial_clearance_ref —** Clearance financiero oficial cuando exigido. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: fin….

**status —** ACTIVE/SUSPENDED/TRANSFER_PENDING/TRANSFERRED/WITHDRAWN/CANCELLED/VOID. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'ACTIVE'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**enrolled_at —** Momento oficial de enrollment. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**effective_from —** Inicio de efecto académico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**effective_to —** Fin por transferencia/retiro/cancelación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**reason_code —** Reason de status terminal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: WITHDRAWN_BY_PARTICIPANT.

**policy_snapshot_json —** Policy versions que sustentan admisión. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"admission":"…"}.

**created_by_subject —** Actor creador. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                                                               | **Error que impide**         |
|-------------------------------------|----------|--------------------------------------------------------------------------------------------------------|------------------------------|
| **pk_ec04_enrollment**              | PK       | (tenant_id, enrollment_id)                                                                             | Identidad/cruce tenant.      |
| **uq_ec04_enrollment_number**       | UQ       | (tenant_id, enrollment_number)                                                                         | Número duplicado.            |
| **fk_ec04_enrollment_participant**  | FK       | (tenant_id, participant_id) REFERENCES ec04.ec04_participant_profile(tenant_id, participant_id)        | Participant inválido.        |
| **fk_ec04_enrollment_registration** | FK       | (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id)     | Registration inválida.       |
| **fk_ec04_enrollment_pool**         | FK       | (tenant_id, capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id)          | Pool inválido.               |
| **fk_ec04_enrollment_seat**         | FK       | (tenant_id, seat_reservation_id) REFERENCES ec04.ec04_seat_reservation(tenant_id, seat_reservation_id) | Seat inválido.               |
| **ck_ec04_enrollment_status**       | CHECK    | status IN ('ACTIVE','SUSPENDED','TRANSFER_PENDING','TRANSFERRED','WITHDRAWN','CANCELLED','VOID')       | Status inválido.             |
| **ck_ec04_enrollment_dates**        | CHECK    | effective_to IS NULL OR effective_to \>= effective_from                                                | Vigencia inválida.           |
| **ck_ec04_enrollment_policy**       | CHECK    | jsonb_typeof(policy_snapshot_json)='object'                                                            | Policy snapshot inválido.    |
| **uq_ec04_enrollment_active**       | UQ_INDEX | (tenant_id, participant_id, offering_ref) WHERE status IN ('ACTIVE','SUSPENDED','TRANSFER_PENDING')    | Enrollment activo duplicado. |
| **ix_ec04_enrollment_offering**     | INDEX    | (tenant_id, offering_ref, status, enrolled_at)                                                         | Roster lento.                |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Número duplicado.; Participant inválido.; Registration inválida.; Pool inválido.; Seat inválido.; Status inválido.; Vigencia inválida.; Policy snapshot inválido.; Enrollment activo duplicado.; Roster lento. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.18 ec04_enrollment_status_history

**QUÉ REPRESENTA —** Historia append-only de estados oficiales de Enrollment. Registra before/after, actor, reason, assurance y correlation para reconstrucción y auditoría.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se genera automáticamente por trigger al crear/cambiar status. Es consumible por auditoría/BI y nunca se edita o borra por API ordinaria.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege no repudio de lifecycle. No es event bus ni reemplaza CT-10.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**         | **Descripción**                                                                  | **Ejemplo**              |
|-----------------------|---------------------|----------|-------------------|-------------------|----------------------------------------------------------------------------------|--------------------------|
| tenant_id             | uuid                | NO       | —                 | PK\*              | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                     |
| enrollment_history_id | uuid                | NO       | gen_random_uuid() | PK                | ID history.                                                                      | eh…                      |
| enrollment_id         | uuid                | NO       | —                 | FK                | Enrollment.                                                                      | enr…                     |
| from_status           | varchar(24)         | YES      | NULL              | —                 | Estado previo; NULL en creación.                                                 | ACTIVE                   |
| to_status             | varchar(24)         | NO       | —                 | —                 | Nuevo estado.                                                                    | WITHDRAWN                |
| reason_code           | varchar(100)        | YES      | NULL              | —                 | Reason code.                                                                     | WITHDRAWN_BY_PARTICIPANT |
| actor_subject_ref     | uuid                | YES      | NULL              | EXT REF IAM       | Actor/sistema.                                                                   | usr…                     |
| assurance_level_code  | varchar(40)         | YES      | NULL              | EXT REF IAM/CT-02 | Assurance aplicado.                                                              | AAL2                     |
| correlation_id        | uuid                | NO       | —                 | —                 | Correlation.                                                                     | corr…                    |
| evidence_ref          | uuid                | YES      | NULL              | EXT REF CT-05/10  | Evidencia.                                                                       | ev…                      |
| occurred_at           | timestamptz         | NO       | now()             | —                 | Momento UTC.                                                                     | …                        |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**enrollment_history_id —** ID history. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: eh….

**enrollment_id —** Enrollment. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: enr….

**from_status —** Estado previo; NULL en creación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**to_status —** Nuevo estado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: WITHDRAWN.

**reason_code —** Reason code. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: WITHDRAWN_BY_PARTICIPANT.

**actor_subject_ref —** Actor/sistema. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**assurance_level_code —** Assurance aplicado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: AAL2.

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**evidence_ref —** Evidencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**occurred_at —** Momento UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**                         | **Tipo** | **Definición/expresión**                                                             | **Error que impide**    |
|-------------------------------------------|----------|--------------------------------------------------------------------------------------|-------------------------|
| **pk_ec04_enrollment_history**            | PK       | (tenant_id, enrollment_history_id)                                                   | Identidad/cruce tenant. |
| **fk_ec04_enrollment_history_enrollment** | FK       | (tenant_id, enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id) | History huérfana.       |
| **ix_ec04_enrollment_history**            | INDEX    | (tenant_id, enrollment_id, occurred_at)                                              | History lenta.          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; History huérfana.; History lenta. |
|------------------------------------------------------------------------------------------------|

## 12.19 ec04_enrollment_transfer_request

**QUÉ REPRESENTA —** Solicitud gobernada para mover un Enrollment a otra Offering/Edition/Cohort sin reescribir el enrollment original.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate workflow. Valida elegibilidad/capacidad destino, reserva seat destino y aplica transferencia con locks en orden determinista; el enrollment origen queda TRANSFERRED y se crea uno nuevo con lineage.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege no pérdida de cupo, SoD y lineage. No modifica attendance/completion previos ni hace UPDATE de edition_ref del enrollment original.

| **Campo**                       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|---------------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                       | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| transfer_request_id             | uuid                | NO       | gen_random_uuid() | PK            | ID request.                                                                      | tr…               |
| source_enrollment_id            | uuid                | NO       | —                 | FK            | Enrollment origen.                                                               | enr…              |
| destination_offering_ref        | uuid                | NO       | —                 | EXT REF EC-02 | Offering destino.                                                                | off2…             |
| destination_edition_ref         | uuid                | NO       | —                 | EXT REF EC-02 | Edition destino.                                                                 | ed2…              |
| destination_cohort_ref          | uuid                | YES      | NULL              | EXT REF EC-02 | Cohorte destino.                                                                 | coh2…             |
| destination_capacity_pool_id    | uuid                | NO       | —                 | FK            | Pool destino.                                                                    | cpool2…           |
| destination_seat_reservation_id | uuid                | YES      | NULL              | FK            | Hold destino.                                                                    | seat2…            |
| workflow_ref                    | uuid                | YES      | NULL              | EXT REF CT-06 | Aprobación si aplica.                                                            | wf…               |
| state                           | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/SUBMITTED/APPROVED/APPLYING/APPLIED/REJECTED/CANCELLED.                    | APPROVED          |
| reason_code                     | varchar(100)        | NO       | —                 | —             | Reason.                                                                          | SCHEDULE_CHANGE   |
| new_enrollment_id               | uuid                | YES      | NULL              | FK            | Enrollment destino creado.                                                       | enr2…             |
| requested_by_subject            | uuid                | NO       | —                 | EXT REF IAM   | Actor.                                                                           | usr…              |
| requested_at                    | timestamptz         | NO       | now()             | —             | Request UTC.                                                                     | …                 |
| applied_at                      | timestamptz         | YES      | NULL              | —             | Aplicación.                                                                      | …                 |
| created_at                      | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |
| updated_at                      | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z |
| version                         | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**transfer_request_id —** ID request. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: tr….

**source_enrollment_id —** Enrollment origen. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: enr….

**destination_offering_ref —** Offering destino. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off2….

**destination_edition_ref —** Edition destino. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ed2….

**destination_cohort_ref —** Cohorte destino. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: coh2….

**destination_capacity_pool_id —** Pool destino. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: cpool2….

**destination_seat_reservation_id —** Hold destino. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: seat2….

**workflow_ref —** Aprobación si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**state —** DRAFT/SUBMITTED/APPROVED/APPLYING/APPLIED/REJECTED/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: APPROVED.

**reason_code —** Reason. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: SCHEDULE_CHANGE.

**new_enrollment_id —** Enrollment destino creado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: enr2….

**requested_by_subject —** Actor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**requested_at —** Request UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**applied_at —** Aplicación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                                                                  | **Error que impide**        |
|------------------------------|----------|-----------------------------------------------------------------------------------------------------------|-----------------------------|
| **pk_ec04_transfer_request** | PK       | (tenant_id, transfer_request_id)                                                                          | Identidad/cruce tenant.     |
| **fk_ec04_transfer_source**  | FK       | (tenant_id, source_enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id)               | Origen inválido.            |
| **fk_ec04_transfer_pool**    | FK       | (tenant_id, destination_capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id) | Pool destino inválido.      |
| **ck_ec04_transfer_state**   | CHECK    | state IN ('DRAFT','SUBMITTED','APPROVED','APPLYING','APPLIED','REJECTED','CANCELLED')                     | Estado inválido.            |
| **uq_ec04_transfer_active**  | UQ_INDEX | (tenant_id, source_enrollment_id) WHERE state IN ('SUBMITTED','APPROVED','APPLYING')                      | Dos transferencias activas. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Origen inválido.; Pool destino inválido.; Estado inválido.; Dos transferencias activas. |
|------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.20 ec04_enrollment_withdrawal_request

**QUÉ REPRESENTA —** Solicitud gobernada de retiro/cancelación de un Enrollment, diferenciando iniciativa, causal, fecha efectiva y efecto downstream.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate workflow. Al aplicar cambia status del Enrollment, libera capacidad cuando corresponde y publica evento; Finance/EC-03 resuelven consecuencias económicas por sus propios contratos.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege historia y separa retiro académico de reversa financiera. No borra Enrollment ni crea reembolso.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**             | **Descripción**                                                                  | **Ejemplo**         |
|------------------------|---------------------|----------|-------------------|-----------------------|----------------------------------------------------------------------------------|---------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*                  | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                |
| withdrawal_request_id  | uuid                | NO       | gen_random_uuid() | PK                    | ID request.                                                                      | wr…                 |
| enrollment_id          | uuid                | NO       | —                 | FK                    | Enrollment.                                                                      | enr…                |
| withdrawal_kind        | varchar(24)         | NO       | —                 | CHECK                 | WITHDRAWAL/CANCELLATION/VOID_REQUEST.                                            | WITHDRAWAL          |
| requested_effective_at | timestamptz         | NO       | —                 | —                     | Fecha/hora solicitada.                                                           | …                   |
| reason_code            | varchar(100)        | NO       | —                 | —                     | Reason estable.                                                                  | PARTICIPANT_REQUEST |
| workflow_ref           | uuid                | YES      | NULL              | EXT REF CT-06         | Aprobación.                                                                      | wf…                 |
| state                  | varchar(24)         | NO       | 'SUBMITTED'       | CHECK                 | SUBMITTED/APPROVED/APPLIED/REJECTED/CANCELLED.                                   | APPROVED            |
| financial_followup_ref | uuid                | YES      | NULL              | EXT REF Finance/EC-03 | Referencia a follow-up financiero, no resultado local.                           | finop…              |
| requested_by_subject   | uuid                | NO       | —                 | EXT REF IAM           | Actor.                                                                           | usr…                |
| applied_by_subject     | uuid                | YES      | NULL              | EXT REF IAM           | Actor aplicación.                                                                | usr2…               |
| applied_at             | timestamptz         | YES      | NULL              | —                     | Aplicación UTC.                                                                  | …                   |
| created_at             | timestamptz         | NO       | now()             | —                     | Instante UTC de creación.                                                        | 2026-09-09T18:00Z   |
| updated_at             | timestamptz         | NO       | now()             | —                     | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z   |
| version                | bigint              | NO       | 0                 | —                     | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                   |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**withdrawal_request_id —** ID request. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: wr….

**enrollment_id —** Enrollment. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: enr….

**withdrawal_kind —** WITHDRAWAL/CANCELLATION/VOID_REQUEST. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: WITHDRAWAL.

**requested_effective_at —** Fecha/hora solicitada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**reason_code —** Reason estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PARTICIPANT_REQUEST.

**workflow_ref —** Aprobación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**state —** SUBMITTED/APPROVED/APPLIED/REJECTED/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'SUBMITTED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: APPROVED.

**financial_followup_ref —** Referencia a follow-up financiero, no resultado local. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: finop….

**requested_by_subject —** Actor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**applied_by_subject —** Actor aplicación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr2….

**applied_at —** Aplicación UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                                             | **Error que impide**    |
|-----------------------------------|----------|--------------------------------------------------------------------------------------|-------------------------|
| **pk_ec04_withdrawal_request**    | PK       | (tenant_id, withdrawal_request_id)                                                   | Identidad/cruce tenant. |
| **fk_ec04_withdrawal_enrollment** | FK       | (tenant_id, enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id) | Enrollment inválido.    |
| **ck_ec04_withdrawal_kind**       | CHECK    | withdrawal_kind IN ('WITHDRAWAL','CANCELLATION','VOID_REQUEST')                      | Kind inválido.          |
| **ck_ec04_withdrawal_state**      | CHECK    | state IN ('SUBMITTED','APPROVED','APPLIED','REJECTED','CANCELLED')                   | Estado inválido.        |
| **uq_ec04_withdrawal_active**     | UQ_INDEX | (tenant_id, enrollment_id) WHERE state IN ('SUBMITTED','APPROVED')                   | Dos retiros activos.    |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Enrollment inválido.; Kind inválido.; Estado inválido.; Dos retiros activos. |
|-------------------------------------------------------------------------------------------------------------------------------------------|

## 12.21 ec04_enrollment_document_binding

**QUÉ REPRESENTA —** Binding de negocio entre Registration/Enrollment y un document_ref de CT-05 para una finalidad concreta. No almacena el archivo.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity ligera usada por Registration Desk para mostrar documentos exigidos/proporcionados y verificación. El documento, hash binario, firma y retención viven en CT-05.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege target tipado, purpose y document_ref. No es repositorio documental.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**       |
|---------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id           | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| document_binding_id | uuid                | NO       | gen_random_uuid() | PK               | ID binding.                                                                      | db…               |
| registration_id     | uuid                | YES      | NULL              | FK               | Registration target.                                                             | reg…              |
| enrollment_id       | uuid                | YES      | NULL              | FK               | Enrollment target.                                                               | enr…              |
| document_ref        | uuid                | NO       | —                 | EXT REF CT-05    | Documento/evidencia.                                                             | doc…              |
| purpose_code        | varchar(80)         | NO       | —                 | EXT REF CT-02/10 | Finalidad.                                                                       | IDENTITY_SUPPORT  |
| verification_state  | varchar(24)         | NO       | 'PENDING'         | CHECK            | PENDING/VERIFIED/REJECTED/EXPIRED.                                               | VERIFIED          |
| verification_ref    | uuid                | YES      | NULL              | EXT REF CT-05/10 | Resultado de verificación.                                                       | ver…              |
| created_by_subject  | uuid                | NO       | —                 | EXT REF IAM      | Actor.                                                                           | usr…              |
| created_at          | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                        | 2026-09-09T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**document_binding_id —** ID binding. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: db….

**registration_id —** Registration target. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**enrollment_id —** Enrollment target. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: enr….

**document_ref —** Documento/evidencia. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: doc….

**purpose_code —** Finalidad. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: IDENTITY_SUPPORT.

**verification_state —** PENDING/VERIFIED/REJECTED/EXPIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: VERIFIED.

**verification_ref —** Resultado de verificación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ver….

**created_by_subject —** Actor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                                  | **Error que impide**    |
|------------------------------|----------|---------------------------------------------------------------------------|-------------------------|
| **pk_ec04_document_binding** | PK       | (tenant_id, document_binding_id)                                          | Identidad/cruce tenant. |
| **ck_ec04_document_target**  | CHECK    | (registration_id IS NOT NULL)::int + (enrollment_id IS NOT NULL)::int = 1 | Target ambiguo.         |
| **ck_ec04_document_state**   | CHECK    | verification_state IN ('PENDING','VERIFIED','REJECTED','EXPIRED')         | Estado inválido.        |
| **uq_ec04_document_binding** | UQ       | (tenant_id, document_ref, purpose_code)                                   | Binding duplicado.      |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Target ambiguo.; Estado inválido.; Binding duplicado. |
|--------------------------------------------------------------------------------------------------------------------|

## 12.22 ec04_consent_receipt_binding

**QUÉ REPRESENTA —** Referencia a consentimientos/acknowledgements gobernados por CT-10/CT-05 que sustentan una RegistrationRequest o Enrollment.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Append-only business binding. EC-04 registra consent_ref, purpose y policy version; la captura legal/evidencia pertenece al owner transversal.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege trazabilidad de consentimiento sin copiar texto legal mutable. No es el consentimiento maestro ni un boolean genérico.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**         | **Descripción**                                                                  | **Ejemplo**           |
|--------------------|---------------------|----------|-------------------|-------------------|----------------------------------------------------------------------------------|-----------------------|
| tenant_id          | uuid                | NO       | —                 | PK\*              | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                  |
| consent_binding_id | uuid                | NO       | gen_random_uuid() | PK                | ID binding.                                                                      | cb…                   |
| registration_id    | uuid                | YES      | NULL              | FK                | Registration target.                                                             | reg…                  |
| enrollment_id      | uuid                | YES      | NULL              | FK                | Enrollment target.                                                               | enr…                  |
| consent_ref        | uuid                | NO       | —                 | EXT REF CT-10/05  | Receipt oficial.                                                                 | cons…                 |
| purpose_code       | varchar(80)         | NO       | —                 | EXT REF CT-10     | Purpose.                                                                         | EC_REGISTRATION_TERMS |
| policy_version_ref | uuid                | NO       | —                 | EXT REF CT-02/10  | Texto/policy version aceptada.                                                   | polv…                 |
| accepted_at        | timestamptz         | NO       | —                 | —                 | Momento UTC.                                                                     | …                     |
| subject_ref        | uuid                | NO       | —                 | EXT REF CT-04/IAM | Subject que aceptó.                                                              | person…               |
| created_at         | timestamptz         | NO       | now()             | —                 | Instante UTC de creación.                                                        | 2026-09-09T18:00Z     |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**consent_binding_id —** ID binding. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cb….

**registration_id —** Registration target. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: reg….

**enrollment_id —** Enrollment target. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: enr….

**consent_ref —** Receipt oficial. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: cons….

**purpose_code —** Purpose. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: EC_REGISTRATION_TERMS.

**policy_version_ref —** Texto/policy version aceptada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: polv….

**accepted_at —** Momento UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**subject_ref —** Subject que aceptó. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

### Constraints físicos implementables

| **Nombre físico**           | **Tipo** | **Definición/expresión**                                                  | **Error que impide**    |
|-----------------------------|----------|---------------------------------------------------------------------------|-------------------------|
| **pk_ec04_consent_binding** | PK       | (tenant_id, consent_binding_id)                                           | Identidad/cruce tenant. |
| **ck_ec04_consent_target**  | CHECK    | (registration_id IS NOT NULL)::int + (enrollment_id IS NOT NULL)::int = 1 | Target ambiguo.         |
| **uq_ec04_consent_once**    | UQ       | (tenant_id, consent_ref)                                                  | Receipt duplicado.      |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Target ambiguo.; Receipt duplicado. |
|--------------------------------------------------------------------------------------------------|

## 12.23 ec04_integration_effect_receipt

**QUÉ REPRESENTA —** Receipt durable de un efecto/consulta cross-context crítica cuyo resultado debe poder reconciliarse: CT-15, CT-06, EC-03, EC-09, Finance o CT-04.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Infrastructure/business evidence creada alrededor de llamadas remotas con idempotency/correlation. UNKNOWN_EFFECT se conserva hasta query/reconciliation; retry ciego está prohibido.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege remote_operation_ref, request/response hashes y estado observado. No duplica el ledger o estado remoto.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**       |
|----------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id            | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| effect_receipt_id    | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                      | fxr…              |
| context_code         | varchar(40)         | NO       | —                 | —                | CT15/CT06/EC03/EC09/FINANCE/CT04.                                                | FINANCE           |
| operation_name       | varchar(120)        | NO       | —                 | —                | Operación contractual.                                                           | verifyClearance   |
| local_resource_ref   | varchar(180)        | NO       | —                 | —                | Recurso local relacionado.                                                       | registration:reg… |
| remote_operation_ref | varchar(180)        | YES      | NULL              | —                | ID idempotente remoto.                                                           | fin-op-77         |
| idempotency_key      | varchar(160)        | YES      | NULL              | —                | Key enviada.                                                                     | idem…             |
| request_hash         | varchar(128)        | NO       | —                 | —                | Hash request.                                                                    | sha256:…          |
| effect_state         | varchar(24)         | NO       | —                 | CHECK            | CONFIRMED/REJECTED/UNKNOWN_EFFECT/NOT_APPLIED.                                   | CONFIRMED         |
| response_hash        | varchar(128)        | YES      | NULL              | —                | Hash response.                                                                   | sha256:…          |
| correlation_id       | uuid                | NO       | —                 | —                | Correlation.                                                                     | corr…             |
| observed_at          | timestamptz         | NO       | now()             | —                | Instante UTC.                                                                    | …                 |
| reconciled_at        | timestamptz         | YES      | NULL              | —                | Resolución posterior.                                                            | …                 |
| evidence_ref         | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidencia.                                                                       | ev…               |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**effect_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: fxr….

**context_code —** CT15/CT06/EC03/EC09/FINANCE/CT04. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: FINANCE.

**operation_name —** Operación contractual. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: verifyClearance.

**local_resource_ref —** Recurso local relacionado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: registration:reg….

**remote_operation_ref —** ID idempotente remoto. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: fin-op-77.

**idempotency_key —** Key enviada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: idem….

**request_hash —** Hash request. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**effect_state —** CONFIRMED/REJECTED/UNKNOWN_EFFECT/NOT_APPLIED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CONFIRMED.

**response_hash —** Hash response. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**observed_at —** Instante UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**reconciled_at —** Resolución posterior. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**evidence_ref —** Evidencia. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

### Constraints físicos implementables

| **Nombre físico**          | **Tipo** | **Definición/expresión**                                                   | **Error que impide**                            |
|----------------------------|----------|----------------------------------------------------------------------------|-------------------------------------------------|
| **pk_ec04_effect_receipt** | PK       | (tenant_id, effect_receipt_id)                                             | Identidad/cruce tenant.                         |
| **ck_ec04_effect_state**   | CHECK    | effect_state IN ('CONFIRMED','REJECTED','UNKNOWN_EFFECT','NOT_APPLIED')    | Estado inválido.                                |
| **ix_ec04_effect_unknown** | INDEX    | (tenant_id, context_code, observed_at) WHERE effect_state='UNKNOWN_EFFECT' | Unknown effect no reconciliable eficientemente. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Estado inválido.; Unknown effect no reconciliable eficientemente. |
|--------------------------------------------------------------------------------------------------------------------------------|

## 12.24 ec04_command_idempotency

**QUÉ REPRESENTA —** Registro durable para comandos sensibles de registro, reserva, waitlist, enrollment, transferencia, retiro e importación.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se adquiere antes del side effect. Same-key/same-payload retorna el mismo resultado; payload distinto retorna 409. IN_PROGRESS usa lease/owner y recovery gobernado.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege contra duplicación por retry/crash. No es cache Redis y no depende de TTL volátil.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**          |
|-----------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|----------------------|
| tenant_id       | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                 |
| idempotency_id  | uuid                | NO       | gen_random_uuid() | PK        | ID registro.                                                                     | idemrec…             |
| idempotency_key | varchar(160)        | NO       | —                 | UQ        | Clave comando.                                                                   | idem…                |
| command_name    | varchar(120)        | NO       | —                 | —         | Comando estable.                                                                 | CreateEnrollment     |
| request_hash    | varchar(128)        | NO       | —                 | —         | Hash canonical.                                                                  | sha256:…             |
| state           | varchar(24)         | NO       | 'IN_PROGRESS'     | CHECK     | IN_PROGRESS/SUCCEEDED/FAILED_RECOVERABLE/FAILED_FINAL.                           | SUCCEEDED            |
| owner_id        | varchar(120)        | YES      | NULL              | —         | Owner actual.                                                                    | pod-7                |
| lease_until     | timestamptz         | YES      | NULL              | CHECK     | Lease.                                                                           | …                    |
| response_status | integer             | YES      | NULL              | CHECK     | HTTP/status cacheado.                                                            | 201                  |
| response_json   | jsonb               | YES      | NULL              | CHECK     | Respuesta durable acotada.                                                       | {"enrollmentId":"…"} |
| resource_ref    | varchar(200)        | YES      | NULL              | —         | Recurso creado.                                                                  | enrollment:enr…      |
| last_error_code | varchar(100)        | YES      | NULL              | —         | Último error.                                                                    | CAPACITY_FULL        |
| created_at      | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T18:00Z    |
| updated_at      | timestamptz         | NO       | now()             | —         | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z    |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**idempotency_id —** ID registro. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: idemrec….

**idempotency_key —** Clave comando. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: idem….

**command_name —** Comando estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CreateEnrollment.

**request_hash —** Hash canonical. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**state —** IN_PROGRESS/SUCCEEDED/FAILED_RECOVERABLE/FAILED_FINAL. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'IN_PROGRESS'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: SUCCEEDED.

**owner_id —** Owner actual. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pod-7.

**lease_until —** Lease. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**response_status —** HTTP/status cacheado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 201.

**response_json —** Respuesta durable acotada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"enrollmentId":"…"}.

**resource_ref —** Recurso creado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: enrollment:enr….

**last_error_code —** Último error. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: CAPACITY_FULL.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

### Constraints físicos implementables

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                                   | **Error que impide**             |
|----------------------------------|----------|----------------------------------------------------------------------------|----------------------------------|
| **pk_ec04_command_idempotency**  | PK       | (tenant_id, idempotency_id)                                                | Identidad/cruce tenant.          |
| **uq_ec04_idempotency_key**      | UQ       | (tenant_id, idempotency_key)                                               | Key duplicada.                   |
| **ck_ec04_idempotency_state**    | CHECK    | state IN ('IN_PROGRESS','SUCCEEDED','FAILED_RECOVERABLE','FAILED_FINAL')   | Estado inválido.                 |
| **ck_ec04_idempotency_response** | CHECK    | response_status IS NULL OR (response_status BETWEEN 100 AND 599)           | Status inválido.                 |
| **ck_ec04_idempotency_payload**  | CHECK    | response_json IS NULL OR jsonb_typeof(response_json) IN ('object','array') | Response mal formada.            |
| **ix_ec04_idempotency_recovery** | INDEX    | (tenant_id, lease_until) WHERE state='IN_PROGRESS'                         | Leases vencidos no recuperables. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Key duplicada.; Estado inválido.; Status inválido.; Response mal formada.; Leases vencidos no recuperables. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.25 ec04_outbox_event

**QUÉ REPRESENTA —** Evento de integración persistido en la misma transacción que el hecho EC-04. Implementa at-least-once con claim/lease y delivery observable.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Dispatcher multi-instancia usa FOR UPDATE SKIP LOCKED, owner/lease, backoff y replay gobernado. Publica RegistrationSubmitted, Waitlisted, EnrollmentCreated, EnrollmentWithdrawn, etc.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege atomicidad negocio→evento. No promete exactly-once distribuido.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**          |
|-----------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|----------------------|
| tenant_id       | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                 |
| event_id        | uuid                | NO       | gen_random_uuid() | PK        | ID evento/message.                                                               | evt…                 |
| aggregate_type  | varchar(100)        | NO       | —                 | —         | Aggregate.                                                                       | Enrollment           |
| aggregate_id    | uuid                | NO       | —                 | —         | ID aggregate.                                                                    | enr…                 |
| event_type      | varchar(160)        | NO       | —                 | —         | Nombre versionado.                                                               | EnrollmentCreated.v1 |
| schema_version  | integer             | NO       | 1                 | CHECK     | Versión payload.                                                                 | 1                    |
| payload_json    | jsonb               | NO       | —                 | CHECK     | Payload contractual minimizado.                                                  | {"enrollmentId":"…"} |
| correlation_id  | uuid                | NO       | —                 | —         | Correlation.                                                                     | corr…                |
| causation_id    | uuid                | YES      | NULL              | —         | Causation.                                                                       | cause…               |
| occurred_at     | timestamptz         | NO       | now()             | —         | Momento hecho.                                                                   | …                    |
| state           | varchar(20)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/DELIVERED/FAILED.                                              | PENDING              |
| owner_id        | varchar(120)        | YES      | NULL              | —         | Dispatcher owner.                                                                | pod-1                |
| lease_until     | timestamptz         | YES      | NULL              | —         | Lease claim.                                                                     | …                    |
| attempt_count   | integer             | NO       | 0                 | CHECK     | Intentos.                                                                        | 2                    |
| next_attempt_at | timestamptz         | NO       | now()             | —         | Backoff.                                                                         | …                    |
| delivered_at    | timestamptz         | YES      | NULL              | —         | Delivery.                                                                        | …                    |
| last_error_code | varchar(100)        | YES      | NULL              | —         | Error.                                                                           | BROKER_TIMEOUT       |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**event_id —** ID evento/message. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: evt….

**aggregate_type —** Aggregate. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Enrollment.

**aggregate_id —** ID aggregate. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: enr….

**event_type —** Nombre versionado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EnrollmentCreated.v1.

**schema_version —** Versión payload. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1.

**payload_json —** Payload contractual minimizado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: {"enrollmentId":"…"}.

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**causation_id —** Causation. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cause….

**occurred_at —** Momento hecho. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**state —** PENDING/IN_FLIGHT/DELIVERED/FAILED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PENDING.

**owner_id —** Dispatcher owner. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pod-1.

**lease_until —** Lease claim. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**attempt_count —** Intentos. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 2.

**next_attempt_at —** Backoff. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**delivered_at —** Delivery. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**last_error_code —** Error. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: BROKER_TIMEOUT.

### Constraints físicos implementables

| **Nombre físico**           | **Tipo** | **Definición/expresión**                                                      | **Error que impide**          |
|-----------------------------|----------|-------------------------------------------------------------------------------|-------------------------------|
| **pk_ec04_outbox_event**    | PK       | (tenant_id, event_id)                                                         | Identidad/cruce tenant.       |
| **ck_ec04_outbox_schema**   | CHECK    | schema_version \> 0                                                           | Schema version inválida.      |
| **ck_ec04_outbox_payload**  | CHECK    | jsonb_typeof(payload_json)='object'                                           | Payload inválido.             |
| **ck_ec04_outbox_state**    | CHECK    | state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED')                         | Estado inválido.              |
| **ck_ec04_outbox_attempts** | CHECK    | attempt_count \>= 0                                                           | Intentos negativos.           |
| **ix_ec04_outbox_claim**    | INDEX    | (tenant_id, next_attempt_at, occurred_at) WHERE state IN ('PENDING','FAILED') | Claim ineficiente.            |
| **ix_ec04_outbox_reclaim**  | INDEX    | (tenant_id, lease_until) WHERE state='IN_FLIGHT'                              | Lease perdido no recuperable. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Schema version inválida.; Payload inválido.; Estado inválido.; Intentos negativos.; Claim ineficiente.; Lease perdido no recuperable. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.26 ec04_inbox_message

**QUÉ REPRESENTA —** Registro durable de deduplicación de mensajes/comandos entrantes de EC-02, EC-03, EC-09, CT-15 y otros contratos.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se inserta por message_id antes de handler. Duplicates same-id/same-hash retornan resultado existente; same-id/different-payload es incidente contractual.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege side effects duplicados. No reemplaza el event store de otro contexto.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**                                                                  | **Ejemplo**                |
|-----------------|---------------------|----------|-------------|-----------|----------------------------------------------------------------------------------|----------------------------|
| tenant_id       | uuid                | NO       | —           | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                       |
| message_id      | uuid                | NO       | —           | PK        | ID global mensaje.                                                               | msg…                       |
| source_context  | varchar(80)         | NO       | —           | —         | Context emisor.                                                                  | EC02                       |
| message_type    | varchar(160)        | NO       | —           | —         | Tipo/version.                                                                    | OfferingCapacityChanged.v1 |
| payload_hash    | varchar(128)        | NO       | —           | —         | Hash.                                                                            | sha256:…                   |
| state           | varchar(20)         | NO       | 'RECEIVED'  | CHECK     | RECEIVED/PROCESSING/PROCESSED/FAILED.                                            | PROCESSED                  |
| received_at     | timestamptz         | NO       | now()       | —         | Recepción.                                                                       | …                          |
| processed_at    | timestamptz         | YES      | NULL        | —         | Fin.                                                                             | …                          |
| last_error_code | varchar(100)        | YES      | NULL        | —         | Error.                                                                           | CONTRACT_INVALID           |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**message_id —** ID global mensaje. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: msg….

**source_context —** Context emisor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EC02.

**message_type —** Tipo/version. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: OfferingCapacityChanged.v1.

**payload_hash —** Hash. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**state —** RECEIVED/PROCESSING/PROCESSED/FAILED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'RECEIVED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PROCESSED.

**received_at —** Recepción. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**processed_at —** Fin. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**last_error_code —** Error. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: CONTRACT_INVALID.

### Constraints físicos implementables

| **Nombre físico**         | **Tipo** | **Definición/expresión**                                | **Error que impide**   |
|---------------------------|----------|---------------------------------------------------------|------------------------|
| **pk_ec04_inbox_message** | PK       | (tenant_id, message_id)                                 | Dedup tenant-aware.    |
| **ck_ec04_inbox_state**   | CHECK    | state IN ('RECEIVED','PROCESSING','PROCESSED','FAILED') | Estado inválido.       |
| **ix_ec04_inbox_state**   | INDEX    | (tenant_id, state, received_at)                         | Reprocesamiento lento. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Dedup tenant-aware.; Estado inválido.; Reprocesamiento lento. |
|---------------------------------------------------------------------------------------------------|

## 12.27 ec04_operation_status

**QUÉ REPRESENTA —** Estado consultable de operaciones asíncronas 202: imports/batches, promociones masivas de waitlist, reconciliaciones y expiraciones en lote.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate técnico expuesto por GET /operations/{id}. Frontend nunca interpreta 202 como efecto confirmado; polling/backoff o push muestra estado terminal.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lifecycle async y UNKNOWN_EFFECT. No reemplaza idempotency/outbox.

| **Campo**        | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**                |
|------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|----------------------------|
| tenant_id        | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                       |
| operation_id     | uuid                | NO       | gen_random_uuid() | PK        | ID operación.                                                                    | op…                        |
| operation_type   | varchar(100)        | NO       | —                 | —         | Tipo.                                                                            | PROCESS_REGISTRATION_BATCH |
| resource_ref     | varchar(200)        | YES      | NULL              | —         | Recurso.                                                                         | batch:rb…                  |
| state            | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED.                       | RUNNING                    |
| progress_current | bigint              | YES      | NULL              | CHECK     | Avance.                                                                          | 500                        |
| progress_total   | bigint              | YES      | NULL              | CHECK     | Total.                                                                           | 1000                       |
| result_json      | jsonb               | YES      | NULL              | CHECK     | Resultado acotado.                                                               | {"enrolled":930}           |
| error_code       | varchar(100)        | YES      | NULL              | —         | Reason terminal.                                                                 | …                          |
| correlation_id   | uuid                | NO       | —                 | —         | Correlation.                                                                     | corr…                      |
| started_at       | timestamptz         | YES      | NULL              | —         | Inicio.                                                                          | …                          |
| completed_at     | timestamptz         | YES      | NULL              | —         | Fin.                                                                             | …                          |
| created_at       | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T18:00Z          |
| updated_at       | timestamptz         | NO       | now()             | —         | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T18:30Z          |
| version          | bigint              | NO       | 0                 | —         | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                          |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**operation_id —** ID operación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: op….

**operation_type —** Tipo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PROCESS_REGISTRATION_BATCH.

**resource_ref —** Recurso. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: batch:rb….

**state —** PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: RUNNING.

**progress_current —** Avance. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 500.

**progress_total —** Total. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1000.

**result_json —** Resultado acotado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"enrolled":930}.

**error_code —** Reason terminal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ….

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**started_at —** Inicio. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**completed_at —** Fin. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T18:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión**                                                                                                                     | **Error que impide**                |
|--------------------------------|----------|----------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------|
| **pk_ec04_operation_status**   | PK       | (tenant_id, operation_id)                                                                                                                    | Identidad/cruce tenant.             |
| **ck_ec04_operation_state**    | CHECK    | state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED')                                                             | Estado inválido.                    |
| **ck_ec04_operation_progress** | CHECK    | (progress_current IS NULL AND progress_total IS NULL) OR (progress_current\>=0 AND progress_total\>=0 AND progress_current\<=progress_total) | Progreso incoherente.               |
| **ck_ec04_operation_result**   | CHECK    | result_json IS NULL OR jsonb_typeof(result_json) IN ('object','array')                                                                       | Resultado inválido.                 |
| **ix_ec04_operation_active**   | INDEX    | (tenant_id, updated_at) WHERE state IN ('PENDING','RUNNING','UNKNOWN_EFFECT')                                                                | Operaciones activas no observables. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Estado inválido.; Progreso incoherente.; Resultado inválido.; Operaciones activas no observables. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 13. DDL PostgreSQL completo — Flyway Ready

El siguiente baseline es ejecutable como migración inicial del bounded context EC-04. Incluye schema, tablas, constraints, FKs internas tenant-aware, unique indexes parciales, triggers de state machine, counters de capacidad, history append-only, RLS y operational indexes. Los grants concretos dependen del ambiente, pero la separación migrator/runtime/worker y NO BYPASSRLS es obligatoria.

| **CRITERIO FLYWAY —** Las migraciones productivas siguen expand/contract y compatibilidad N/N-1. Una migration aplicada nunca se edita para “corregir”; toda evolución crea V2\_\_, V3\_\_ o repeatable controlado. Antes de release debe ejecutarse desde cero y como upgrade sobre N-1. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

-- V1\_\_ec04_registration_enrollment_foundation.sql

-- PeopleU IA \| EC-04 \| PostgreSQL 16+ \| Flyway Ready

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE SCHEMA IF NOT EXISTS ec04;

CREATE OR REPLACE FUNCTION ec04.current_tenant_uuid() RETURNS uuid LANGUAGE sql STABLE AS \$\$ SELECT NULLIF(current_setting('peopleu.tenant_id', true), '')::uuid \$\$;

CREATE TABLE ec04.ec04_participant_profile (

tenant_id uuid NOT NULL,

participant_id uuid DEFAULT gen_random_uuid() NOT NULL,

participant_code varchar(64) NOT NULL,

person_ref uuid NOT NULL,

home_scope_ref uuid DEFAULT NULL,

preferred_language_code varchar(16) DEFAULT NULL,

lifecycle_state varchar(24) DEFAULT 'ACTIVE' NOT NULL,

restriction_reason_code varchar(80) DEFAULT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_prospect_case (

tenant_id uuid NOT NULL,

prospect_case_id uuid DEFAULT gen_random_uuid() NOT NULL,

prospect_number varchar(64) NOT NULL,

person_ref uuid DEFAULT NULL,

contact_point_ref uuid DEFAULT NULL,

target_offering_ref uuid DEFAULT NULL,

source_code varchar(80) NOT NULL,

purpose_code varchar(80) NOT NULL,

owner_scope_ref uuid NOT NULL,

state varchar(24) DEFAULT 'OPEN' NOT NULL,

converted_participant_id uuid DEFAULT NULL,

converted_registration_id uuid DEFAULT NULL,

last_interaction_at timestamptz DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_registration_invitation (

tenant_id uuid NOT NULL,

invitation_id uuid DEFAULT gen_random_uuid() NOT NULL,

invitation_number varchar(64) NOT NULL,

token_hash varchar(128) NOT NULL,

token_last4 char(4) NOT NULL,

person_ref uuid DEFAULT NULL,

contact_point_ref uuid DEFAULT NULL,

offering_ref uuid NOT NULL,

corporate_enrollment_batch_ref uuid DEFAULT NULL,

state varchar(24) DEFAULT 'ISSUED' NOT NULL,

issued_at timestamptz DEFAULT now() NOT NULL,

expires_at timestamptz NOT NULL,

accepted_at timestamptz DEFAULT NULL,

registration_id uuid DEFAULT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_registration_request (

tenant_id uuid NOT NULL,

registration_id uuid DEFAULT gen_random_uuid() NOT NULL,

registration_number varchar(64) NOT NULL,

participant_id uuid NOT NULL,

offering_ref uuid NOT NULL,

edition_ref uuid NOT NULL,

cohort_ref uuid DEFAULT NULL,

program_version_ref uuid NOT NULL,

registration_channel_code varchar(80) NOT NULL,

source_invitation_id uuid DEFAULT NULL,

source_batch_item_id uuid DEFAULT NULL,

commercial_quote_ref uuid DEFAULT NULL,

corporate_enrollment_batch_ref uuid DEFAULT NULL,

state varchar(28) DEFAULT 'DRAFT' NOT NULL,

submitted_at timestamptz DEFAULT NULL,

decision_at timestamptz DEFAULT NULL,

reason_code varchar(100) DEFAULT NULL,

policy_snapshot_json jsonb DEFAULT '{}'::jsonb NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_registration_batch (

tenant_id uuid NOT NULL,

registration_batch_id uuid DEFAULT gen_random_uuid() NOT NULL,

batch_number varchar(64) NOT NULL,

batch_type varchar(24) NOT NULL,

offering_ref uuid NOT NULL,

corporate_enrollment_batch_ref uuid DEFAULT NULL,

source_batch_ref varchar(160) DEFAULT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

item_count integer DEFAULT 0 NOT NULL,

succeeded_count integer DEFAULT 0 NOT NULL,

failed_count integer DEFAULT 0 NOT NULL,

operation_id uuid DEFAULT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_registration_batch_item (

tenant_id uuid NOT NULL,

batch_item_id uuid DEFAULT gen_random_uuid() NOT NULL,

registration_batch_id uuid NOT NULL,

external_item_key varchar(160) NOT NULL,

person_ref uuid DEFAULT NULL,

identity_resolution_ref uuid DEFAULT NULL,

source_payload_hash varchar(128) NOT NULL,

state varchar(24) DEFAULT 'PENDING' NOT NULL,

participant_id uuid DEFAULT NULL,

registration_id uuid DEFAULT NULL,

error_code varchar(100) DEFAULT NULL,

result_json jsonb DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec04.ec04_eligibility_decision_receipt (

tenant_id uuid NOT NULL,

eligibility_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,

registration_id uuid NOT NULL,

eligibility_rule_ref uuid NOT NULL,

decision_ref uuid NOT NULL,

decision varchar(24) NOT NULL,

reason_codes_json jsonb DEFAULT '\[\]'::jsonb NOT NULL,

input_snapshot_hash varchar(128) NOT NULL,

policy_version_ref uuid NOT NULL,

decided_at timestamptz NOT NULL,

evidence_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec04.ec04_identity_assurance_receipt (

tenant_id uuid NOT NULL,

identity_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,

registration_id uuid NOT NULL,

person_ref uuid NOT NULL,

verification_ref uuid NOT NULL,

assurance_level_code varchar(40) NOT NULL,

result varchar(24) NOT NULL,

verified_at timestamptz NOT NULL,

evidence_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec04.ec04_registration_requirement (

tenant_id uuid NOT NULL,

registration_requirement_id uuid DEFAULT gen_random_uuid() NOT NULL,

registration_id uuid NOT NULL,

requirement_code varchar(80) NOT NULL,

requirement_kind varchar(24) NOT NULL,

source_policy_ref uuid NOT NULL,

mandatory boolean DEFAULT true NOT NULL,

due_at timestamptz DEFAULT NULL,

state varchar(24) DEFAULT 'PENDING' NOT NULL,

waiver_workflow_ref uuid DEFAULT NULL,

reason_code varchar(100) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec04.ec04_registration_requirement_result (

tenant_id uuid NOT NULL,

requirement_result_id uuid DEFAULT gen_random_uuid() NOT NULL,

registration_requirement_id uuid NOT NULL,

result varchar(24) NOT NULL,

source_context varchar(40) NOT NULL,

source_receipt_ref uuid DEFAULT NULL,

evidence_ref uuid DEFAULT NULL,

reason_code varchar(100) DEFAULT NULL,

evaluated_by_subject uuid DEFAULT NULL,

evaluated_at timestamptz DEFAULT now() NOT NULL,

payload_hash varchar(128) NOT NULL

);

CREATE TABLE ec04.ec04_capacity_pool (

tenant_id uuid NOT NULL,

capacity_pool_id uuid DEFAULT gen_random_uuid() NOT NULL,

offering_ref uuid NOT NULL,

cohort_ref uuid DEFAULT NULL,

segment_code varchar(80) DEFAULT 'GENERAL' NOT NULL,

capacity_mode varchar(16) DEFAULT 'FIXED' NOT NULL,

hard_capacity integer DEFAULT NULL,

overbook_limit integer DEFAULT 0 NOT NULL,

current_reserved integer DEFAULT 0 NOT NULL,

current_enrolled integer DEFAULT 0 NOT NULL,

current_waitlisted integer DEFAULT 0 NOT NULL,

waitlist_enabled boolean DEFAULT true NOT NULL,

capacity_policy_ref uuid NOT NULL,

state varchar(20) DEFAULT 'OPEN' NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_capacity_adjustment (

tenant_id uuid NOT NULL,

capacity_adjustment_id uuid DEFAULT gen_random_uuid() NOT NULL,

capacity_pool_id uuid NOT NULL,

adjustment_type varchar(24) NOT NULL,

before_value integer DEFAULT NULL,

after_value integer DEFAULT NULL,

reason_code varchar(100) NOT NULL,

workflow_ref uuid DEFAULT NULL,

evidence_ref uuid DEFAULT NULL,

applied_by_subject uuid NOT NULL,

applied_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec04.ec04_seat_reservation (

tenant_id uuid NOT NULL,

seat_reservation_id uuid DEFAULT gen_random_uuid() NOT NULL,

capacity_pool_id uuid NOT NULL,

registration_id uuid NOT NULL,

waitlist_offer_id uuid DEFAULT NULL,

state varchar(20) DEFAULT 'HELD' NOT NULL,

held_at timestamptz DEFAULT now() NOT NULL,

expires_at timestamptz DEFAULT NULL,

consumed_at timestamptz DEFAULT NULL,

released_at timestamptz DEFAULT NULL,

reason_code varchar(100) DEFAULT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_waitlist_entry (

tenant_id uuid NOT NULL,

waitlist_entry_id uuid DEFAULT gen_random_uuid() NOT NULL,

capacity_pool_id uuid NOT NULL,

registration_id uuid NOT NULL,

priority_bucket integer DEFAULT 0 NOT NULL,

priority_score numeric(12,4) DEFAULT 0 NOT NULL,

priority_policy_ref uuid NOT NULL,

enqueued_at timestamptz DEFAULT now() NOT NULL,

state varchar(20) DEFAULT 'ACTIVE' NOT NULL,

last_offer_id uuid DEFAULT NULL,

reason_code varchar(100) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_waitlist_offer (

tenant_id uuid NOT NULL,

waitlist_offer_id uuid DEFAULT gen_random_uuid() NOT NULL,

waitlist_entry_id uuid NOT NULL,

seat_reservation_id uuid DEFAULT NULL,

state varchar(20) DEFAULT 'ISSUED' NOT NULL,

issued_at timestamptz DEFAULT now() NOT NULL,

expires_at timestamptz NOT NULL,

accepted_at timestamptz DEFAULT NULL,

notification_request_ref uuid DEFAULT NULL,

reason_code varchar(100) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_pre_enrollment (

tenant_id uuid NOT NULL,

pre_enrollment_id uuid DEFAULT gen_random_uuid() NOT NULL,

pre_enrollment_number varchar(64) NOT NULL,

registration_id uuid NOT NULL,

seat_reservation_id uuid NOT NULL,

eligibility_receipt_id uuid NOT NULL,

state varchar(28) DEFAULT 'PENDING_CONDITIONS' NOT NULL,

commercial_clearance_ref uuid DEFAULT NULL,

identity_receipt_id uuid DEFAULT NULL,

expires_at timestamptz DEFAULT NULL,

converted_enrollment_id uuid DEFAULT NULL,

policy_snapshot_json jsonb DEFAULT '{}'::jsonb NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_enrollment (

tenant_id uuid NOT NULL,

enrollment_id uuid DEFAULT gen_random_uuid() NOT NULL,

enrollment_number varchar(64) NOT NULL,

participant_id uuid NOT NULL,

registration_id uuid NOT NULL,

pre_enrollment_id uuid DEFAULT NULL,

capacity_pool_id uuid NOT NULL,

seat_reservation_id uuid NOT NULL,

program_version_ref uuid NOT NULL,

edition_ref uuid NOT NULL,

offering_ref uuid NOT NULL,

cohort_ref uuid DEFAULT NULL,

corporate_enrollment_batch_ref uuid DEFAULT NULL,

commercial_quote_ref uuid DEFAULT NULL,

financial_clearance_ref uuid DEFAULT NULL,

status varchar(24) DEFAULT 'ACTIVE' NOT NULL,

enrolled_at timestamptz DEFAULT now() NOT NULL,

effective_from timestamptz DEFAULT now() NOT NULL,

effective_to timestamptz DEFAULT NULL,

reason_code varchar(100) DEFAULT NULL,

policy_snapshot_json jsonb DEFAULT '{}'::jsonb NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_enrollment_status_history (

tenant_id uuid NOT NULL,

enrollment_history_id uuid DEFAULT gen_random_uuid() NOT NULL,

enrollment_id uuid NOT NULL,

from_status varchar(24) DEFAULT NULL,

to_status varchar(24) NOT NULL,

reason_code varchar(100) DEFAULT NULL,

actor_subject_ref uuid DEFAULT NULL,

assurance_level_code varchar(40) DEFAULT NULL,

correlation_id uuid NOT NULL,

evidence_ref uuid DEFAULT NULL,

occurred_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec04.ec04_enrollment_transfer_request (

tenant_id uuid NOT NULL,

transfer_request_id uuid DEFAULT gen_random_uuid() NOT NULL,

source_enrollment_id uuid NOT NULL,

destination_offering_ref uuid NOT NULL,

destination_edition_ref uuid NOT NULL,

destination_cohort_ref uuid DEFAULT NULL,

destination_capacity_pool_id uuid NOT NULL,

destination_seat_reservation_id uuid DEFAULT NULL,

workflow_ref uuid DEFAULT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

reason_code varchar(100) NOT NULL,

new_enrollment_id uuid DEFAULT NULL,

requested_by_subject uuid NOT NULL,

requested_at timestamptz DEFAULT now() NOT NULL,

applied_at timestamptz DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_enrollment_withdrawal_request (

tenant_id uuid NOT NULL,

withdrawal_request_id uuid DEFAULT gen_random_uuid() NOT NULL,

enrollment_id uuid NOT NULL,

withdrawal_kind varchar(24) NOT NULL,

requested_effective_at timestamptz NOT NULL,

reason_code varchar(100) NOT NULL,

workflow_ref uuid DEFAULT NULL,

state varchar(24) DEFAULT 'SUBMITTED' NOT NULL,

financial_followup_ref uuid DEFAULT NULL,

requested_by_subject uuid NOT NULL,

applied_by_subject uuid DEFAULT NULL,

applied_at timestamptz DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec04.ec04_enrollment_document_binding (

tenant_id uuid NOT NULL,

document_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,

registration_id uuid DEFAULT NULL,

enrollment_id uuid DEFAULT NULL,

document_ref uuid NOT NULL,

purpose_code varchar(80) NOT NULL,

verification_state varchar(24) DEFAULT 'PENDING' NOT NULL,

verification_ref uuid DEFAULT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec04.ec04_consent_receipt_binding (

tenant_id uuid NOT NULL,

consent_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,

registration_id uuid DEFAULT NULL,

enrollment_id uuid DEFAULT NULL,

consent_ref uuid NOT NULL,

purpose_code varchar(80) NOT NULL,

policy_version_ref uuid NOT NULL,

accepted_at timestamptz NOT NULL,

subject_ref uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec04.ec04_integration_effect_receipt (

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

CREATE TABLE ec04.ec04_command_idempotency (

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

CREATE TABLE ec04.ec04_outbox_event (

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

CREATE TABLE ec04.ec04_inbox_message (

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

CREATE TABLE ec04.ec04_operation_status (

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

ALTER TABLE ec04.ec04_participant_profile ADD CONSTRAINT pk_ec04_participant_profile PRIMARY KEY (tenant_id, participant_id);

ALTER TABLE ec04.ec04_participant_profile ADD CONSTRAINT uq_ec04_participant_code UNIQUE (tenant_id, participant_code);

ALTER TABLE ec04.ec04_participant_profile ADD CONSTRAINT uq_ec04_participant_person UNIQUE (tenant_id, person_ref);

ALTER TABLE ec04.ec04_participant_profile ADD CONSTRAINT ck_ec04_participant_state CHECK (lifecycle_state IN ('ACTIVE','SUSPENDED','RESTRICTED','ARCHIVED'));

CREATE INDEX ix_ec04_participant_scope ON ec04.ec04_participant_profile (tenant_id, home_scope_ref, lifecycle_state);

ALTER TABLE ec04.ec04_prospect_case ADD CONSTRAINT pk_ec04_prospect_case PRIMARY KEY (tenant_id, prospect_case_id);

ALTER TABLE ec04.ec04_prospect_case ADD CONSTRAINT uq_ec04_prospect_number UNIQUE (tenant_id, prospect_number);

ALTER TABLE ec04.ec04_prospect_case ADD CONSTRAINT ck_ec04_prospect_identity CHECK (person_ref IS NOT NULL OR contact_point_ref IS NOT NULL);

ALTER TABLE ec04.ec04_prospect_case ADD CONSTRAINT ck_ec04_prospect_state CHECK (state IN ('OPEN','QUALIFIED','CONVERTED','LOST','EXPIRED'));

CREATE INDEX ix_ec04_prospect_target ON ec04.ec04_prospect_case (tenant_id, target_offering_ref, state, created_at DESC);

ALTER TABLE ec04.ec04_registration_invitation ADD CONSTRAINT pk_ec04_registration_invitation PRIMARY KEY (tenant_id, invitation_id);

ALTER TABLE ec04.ec04_registration_invitation ADD CONSTRAINT uq_ec04_invitation_number UNIQUE (tenant_id, invitation_number);

ALTER TABLE ec04.ec04_registration_invitation ADD CONSTRAINT uq_ec04_invitation_token UNIQUE (tenant_id, token_hash);

ALTER TABLE ec04.ec04_registration_invitation ADD CONSTRAINT ck_ec04_invitation_identity CHECK (person_ref IS NOT NULL OR contact_point_ref IS NOT NULL);

ALTER TABLE ec04.ec04_registration_invitation ADD CONSTRAINT ck_ec04_invitation_state CHECK (state IN ('ISSUED','OPENED','ACCEPTED','EXPIRED','REVOKED'));

ALTER TABLE ec04.ec04_registration_invitation ADD CONSTRAINT ck_ec04_invitation_expiry CHECK (expires_at \> issued_at);

CREATE INDEX ix_ec04_invitation_expiry ON ec04.ec04_registration_invitation (tenant_id, expires_at) WHERE state IN ('ISSUED','OPENED');

ALTER TABLE ec04.ec04_registration_request ADD CONSTRAINT pk_ec04_registration_request PRIMARY KEY (tenant_id, registration_id);

ALTER TABLE ec04.ec04_registration_request ADD CONSTRAINT uq_ec04_registration_number UNIQUE (tenant_id, registration_number);

ALTER TABLE ec04.ec04_registration_request ADD CONSTRAINT fk_ec04_registration_participant FOREIGN KEY (tenant_id, participant_id) REFERENCES ec04.ec04_participant_profile(tenant_id, participant_id);

ALTER TABLE ec04.ec04_registration_request ADD CONSTRAINT ck_ec04_registration_state CHECK (state IN ('DRAFT','SUBMITTED','VALIDATING','ELIGIBLE','WAITLISTED','PRE_ENROLLED','ENROLLED','REJECTED','CANCELLED','EXPIRED'));

ALTER TABLE ec04.ec04_registration_request ADD CONSTRAINT ck_ec04_registration_policy CHECK (jsonb_typeof(policy_snapshot_json)='object');

CREATE UNIQUE INDEX uq_ec04_registration_active ON ec04.ec04_registration_request (tenant_id, participant_id, offering_ref) WHERE state IN ('DRAFT','SUBMITTED','VALIDATING','ELIGIBLE','WAITLISTED','PRE_ENROLLED','ENROLLED');

CREATE INDEX ix_ec04_registration_offering ON ec04.ec04_registration_request (tenant_id, offering_ref, state, created_at);

ALTER TABLE ec04.ec04_registration_batch ADD CONSTRAINT pk_ec04_registration_batch PRIMARY KEY (tenant_id, registration_batch_id);

ALTER TABLE ec04.ec04_registration_batch ADD CONSTRAINT uq_ec04_registration_batch_number UNIQUE (tenant_id, batch_number);

ALTER TABLE ec04.ec04_registration_batch ADD CONSTRAINT ck_ec04_registration_batch_type CHECK (batch_type IN ('CORPORATE','GROUP','IMPORT','STAFF_BULK'));

ALTER TABLE ec04.ec04_registration_batch ADD CONSTRAINT ck_ec04_registration_batch_state CHECK (state IN ('DRAFT','VALIDATING','READY','PROCESSING','PARTIAL','SUCCEEDED','FAILED','CANCELLED'));

ALTER TABLE ec04.ec04_registration_batch ADD CONSTRAINT ck_ec04_registration_batch_counts CHECK (item_count\>=0 AND succeeded_count\>=0 AND failed_count\>=0 AND succeeded_count+failed_count\<=item_count);

CREATE INDEX ix_ec04_registration_batch_offering ON ec04.ec04_registration_batch (tenant_id, offering_ref, state, created_at DESC);

ALTER TABLE ec04.ec04_registration_batch_item ADD CONSTRAINT pk_ec04_registration_batch_item PRIMARY KEY (tenant_id, batch_item_id);

ALTER TABLE ec04.ec04_registration_batch_item ADD CONSTRAINT fk_ec04_batch_item_batch FOREIGN KEY (tenant_id, registration_batch_id) REFERENCES ec04.ec04_registration_batch(tenant_id, registration_batch_id);

ALTER TABLE ec04.ec04_registration_batch_item ADD CONSTRAINT uq_ec04_batch_item_key UNIQUE (tenant_id, registration_batch_id, external_item_key);

ALTER TABLE ec04.ec04_registration_batch_item ADD CONSTRAINT ck_ec04_batch_item_state CHECK (state IN ('PENDING','VALID','INVALID','PROCESSING','SUCCEEDED','FAILED','SKIPPED'));

ALTER TABLE ec04.ec04_registration_batch_item ADD CONSTRAINT ck_ec04_batch_item_result CHECK (result_json IS NULL OR jsonb_typeof(result_json)='object');

CREATE INDEX ix_ec04_batch_item_state ON ec04.ec04_registration_batch_item (tenant_id, registration_batch_id, state);

ALTER TABLE ec04.ec04_eligibility_decision_receipt ADD CONSTRAINT pk_ec04_eligibility_receipt PRIMARY KEY (tenant_id, eligibility_receipt_id);

ALTER TABLE ec04.ec04_eligibility_decision_receipt ADD CONSTRAINT fk_ec04_eligibility_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_eligibility_decision_receipt ADD CONSTRAINT ck_ec04_eligibility_decision CHECK (decision IN ('ELIGIBLE','INELIGIBLE','CONDITIONAL','UNKNOWN'));

ALTER TABLE ec04.ec04_eligibility_decision_receipt ADD CONSTRAINT ck_ec04_eligibility_reasons CHECK (jsonb_typeof(reason_codes_json)='array');

CREATE INDEX ix_ec04_eligibility_registration ON ec04.ec04_eligibility_decision_receipt (tenant_id, registration_id, decided_at DESC);

ALTER TABLE ec04.ec04_identity_assurance_receipt ADD CONSTRAINT pk_ec04_identity_receipt PRIMARY KEY (tenant_id, identity_receipt_id);

ALTER TABLE ec04.ec04_identity_assurance_receipt ADD CONSTRAINT fk_ec04_identity_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_identity_assurance_receipt ADD CONSTRAINT ck_ec04_identity_result CHECK (result IN ('VERIFIED','NOT_VERIFIED','REVIEW_REQUIRED','UNKNOWN'));

CREATE INDEX ix_ec04_identity_registration ON ec04.ec04_identity_assurance_receipt (tenant_id, registration_id, verified_at DESC);

ALTER TABLE ec04.ec04_registration_requirement ADD CONSTRAINT pk_ec04_registration_requirement PRIMARY KEY (tenant_id, registration_requirement_id);

ALTER TABLE ec04.ec04_registration_requirement ADD CONSTRAINT fk_ec04_requirement_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_registration_requirement ADD CONSTRAINT uq_ec04_requirement_code UNIQUE (tenant_id, registration_id, requirement_code);

ALTER TABLE ec04.ec04_registration_requirement ADD CONSTRAINT ck_ec04_requirement_kind CHECK (requirement_kind IN ('IDENTITY','DOCUMENT','ELIGIBILITY','COMMERCIAL','CONSENT','OTHER'));

ALTER TABLE ec04.ec04_registration_requirement ADD CONSTRAINT ck_ec04_requirement_state CHECK (state IN ('PENDING','SATISFIED','WAIVED','FAILED','EXPIRED'));

CREATE INDEX ix_ec04_requirement_pending ON ec04.ec04_registration_requirement (tenant_id, due_at) WHERE state='PENDING';

ALTER TABLE ec04.ec04_registration_requirement_result ADD CONSTRAINT pk_ec04_requirement_result PRIMARY KEY (tenant_id, requirement_result_id);

ALTER TABLE ec04.ec04_registration_requirement_result ADD CONSTRAINT fk_ec04_result_requirement FOREIGN KEY (tenant_id, registration_requirement_id) REFERENCES ec04.ec04_registration_requirement(tenant_id, registration_requirement_id);

ALTER TABLE ec04.ec04_registration_requirement_result ADD CONSTRAINT ck_ec04_requirement_result CHECK (result IN ('SATISFIED','FAILED','WAIVED','UNKNOWN'));

CREATE INDEX ix_ec04_requirement_result_history ON ec04.ec04_registration_requirement_result (tenant_id, registration_requirement_id, evaluated_at DESC);

ALTER TABLE ec04.ec04_capacity_pool ADD CONSTRAINT pk_ec04_capacity_pool PRIMARY KEY (tenant_id, capacity_pool_id);

CREATE UNIQUE INDEX uq_ec04_capacity_scope ON ec04.ec04_capacity_pool (tenant_id, offering_ref, COALESCE(cohort_ref,'00000000-0000-0000-0000-000000000000'::uuid), segment_code);

ALTER TABLE ec04.ec04_capacity_pool ADD CONSTRAINT ck_ec04_capacity_mode CHECK (capacity_mode IN ('FIXED','UNLIMITED'));

ALTER TABLE ec04.ec04_capacity_pool ADD CONSTRAINT ck_ec04_capacity_shape CHECK ((capacity_mode='FIXED' AND hard_capacity IS NOT NULL AND hard_capacity\>=0) OR (capacity_mode='UNLIMITED' AND hard_capacity IS NULL AND overbook_limit=0));

ALTER TABLE ec04.ec04_capacity_pool ADD CONSTRAINT ck_ec04_capacity_counters CHECK (current_reserved\>=0 AND current_enrolled\>=0 AND current_waitlisted\>=0 AND overbook_limit\>=0);

ALTER TABLE ec04.ec04_capacity_pool ADD CONSTRAINT ck_ec04_capacity_limit CHECK (capacity_mode='UNLIMITED' OR current_reserved+current_enrolled \<= hard_capacity+overbook_limit);

ALTER TABLE ec04.ec04_capacity_pool ADD CONSTRAINT ck_ec04_capacity_state CHECK (state IN ('OPEN','FROZEN','CLOSED','RETIRED'));

CREATE INDEX ix_ec04_capacity_offering ON ec04.ec04_capacity_pool (tenant_id, offering_ref, state);

ALTER TABLE ec04.ec04_capacity_adjustment ADD CONSTRAINT pk_ec04_capacity_adjustment PRIMARY KEY (tenant_id, capacity_adjustment_id);

ALTER TABLE ec04.ec04_capacity_adjustment ADD CONSTRAINT fk_ec04_capacity_adjustment_pool FOREIGN KEY (tenant_id, capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id);

ALTER TABLE ec04.ec04_capacity_adjustment ADD CONSTRAINT ck_ec04_capacity_adjustment_type CHECK (adjustment_type IN ('HARD_CAPACITY','OVERBOOK_LIMIT','FREEZE','REOPEN'));

ALTER TABLE ec04.ec04_capacity_adjustment ADD CONSTRAINT ck_ec04_capacity_adjustment_values CHECK ((before_value IS NULL AND after_value IS NULL) OR (before_value IS NOT NULL AND after_value IS NOT NULL));

CREATE INDEX ix_ec04_capacity_adjustment_history ON ec04.ec04_capacity_adjustment (tenant_id, capacity_pool_id, applied_at DESC);

ALTER TABLE ec04.ec04_seat_reservation ADD CONSTRAINT pk_ec04_seat_reservation PRIMARY KEY (tenant_id, seat_reservation_id);

ALTER TABLE ec04.ec04_seat_reservation ADD CONSTRAINT fk_ec04_seat_pool FOREIGN KEY (tenant_id, capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id);

ALTER TABLE ec04.ec04_seat_reservation ADD CONSTRAINT fk_ec04_seat_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_seat_reservation ADD CONSTRAINT ck_ec04_seat_state CHECK (state IN ('HELD','CONSUMED','RELEASED','EXPIRED'));

ALTER TABLE ec04.ec04_seat_reservation ADD CONSTRAINT ck_ec04_seat_expiry CHECK (expires_at IS NULL OR expires_at \> held_at);

CREATE UNIQUE INDEX uq_ec04_seat_active_registration ON ec04.ec04_seat_reservation (tenant_id, registration_id, capacity_pool_id) WHERE state='HELD';

CREATE INDEX ix_ec04_seat_expiry ON ec04.ec04_seat_reservation (tenant_id, expires_at) WHERE state='HELD';

ALTER TABLE ec04.ec04_waitlist_entry ADD CONSTRAINT pk_ec04_waitlist_entry PRIMARY KEY (tenant_id, waitlist_entry_id);

ALTER TABLE ec04.ec04_waitlist_entry ADD CONSTRAINT fk_ec04_waitlist_pool FOREIGN KEY (tenant_id, capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id);

ALTER TABLE ec04.ec04_waitlist_entry ADD CONSTRAINT fk_ec04_waitlist_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_waitlist_entry ADD CONSTRAINT ck_ec04_waitlist_bucket CHECK (priority_bucket\>=0 AND priority_score\>=0);

ALTER TABLE ec04.ec04_waitlist_entry ADD CONSTRAINT ck_ec04_waitlist_state CHECK (state IN ('ACTIVE','OFFERED','ACCEPTED','EXPIRED','REMOVED'));

CREATE UNIQUE INDEX uq_ec04_waitlist_active ON ec04.ec04_waitlist_entry (tenant_id, capacity_pool_id, registration_id) WHERE state IN ('ACTIVE','OFFERED');

CREATE INDEX ix_ec04_waitlist_promote ON ec04.ec04_waitlist_entry (tenant_id, capacity_pool_id, priority_bucket DESC, priority_score DESC, enqueued_at, waitlist_entry_id) WHERE state='ACTIVE';

ALTER TABLE ec04.ec04_waitlist_offer ADD CONSTRAINT pk_ec04_waitlist_offer PRIMARY KEY (tenant_id, waitlist_offer_id);

ALTER TABLE ec04.ec04_waitlist_offer ADD CONSTRAINT fk_ec04_waitlist_offer_entry FOREIGN KEY (tenant_id, waitlist_entry_id) REFERENCES ec04.ec04_waitlist_entry(tenant_id, waitlist_entry_id);

ALTER TABLE ec04.ec04_waitlist_offer ADD CONSTRAINT ck_ec04_waitlist_offer_state CHECK (state IN ('ISSUED','ACCEPTED','EXPIRED','CANCELLED'));

ALTER TABLE ec04.ec04_waitlist_offer ADD CONSTRAINT ck_ec04_waitlist_offer_expiry CHECK (expires_at \> issued_at);

CREATE UNIQUE INDEX uq_ec04_waitlist_offer_active ON ec04.ec04_waitlist_offer (tenant_id, waitlist_entry_id) WHERE state='ISSUED';

CREATE INDEX ix_ec04_waitlist_offer_expiry ON ec04.ec04_waitlist_offer (tenant_id, expires_at) WHERE state='ISSUED';

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT pk_ec04_pre_enrollment PRIMARY KEY (tenant_id, pre_enrollment_id);

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT uq_ec04_pre_enrollment_number UNIQUE (tenant_id, pre_enrollment_number);

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT fk_ec04_pre_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT fk_ec04_pre_seat FOREIGN KEY (tenant_id, seat_reservation_id) REFERENCES ec04.ec04_seat_reservation(tenant_id, seat_reservation_id);

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT fk_ec04_pre_eligibility FOREIGN KEY (tenant_id, eligibility_receipt_id) REFERENCES ec04.ec04_eligibility_decision_receipt(tenant_id, eligibility_receipt_id);

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT ck_ec04_pre_state CHECK (state IN ('PENDING_CONDITIONS','READY','CONVERTED','EXPIRED','CANCELLED'));

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT ck_ec04_pre_policy CHECK (jsonb_typeof(policy_snapshot_json)='object');

CREATE UNIQUE INDEX uq_ec04_pre_active ON ec04.ec04_pre_enrollment (tenant_id, registration_id) WHERE state IN ('PENDING_CONDITIONS','READY');

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT pk_ec04_enrollment PRIMARY KEY (tenant_id, enrollment_id);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT uq_ec04_enrollment_number UNIQUE (tenant_id, enrollment_number);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT fk_ec04_enrollment_participant FOREIGN KEY (tenant_id, participant_id) REFERENCES ec04.ec04_participant_profile(tenant_id, participant_id);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT fk_ec04_enrollment_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT fk_ec04_enrollment_pool FOREIGN KEY (tenant_id, capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT fk_ec04_enrollment_seat FOREIGN KEY (tenant_id, seat_reservation_id) REFERENCES ec04.ec04_seat_reservation(tenant_id, seat_reservation_id);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT ck_ec04_enrollment_status CHECK (status IN ('ACTIVE','SUSPENDED','TRANSFER_PENDING','TRANSFERRED','WITHDRAWN','CANCELLED','VOID'));

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT ck_ec04_enrollment_dates CHECK (effective_to IS NULL OR effective_to \>= effective_from);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT ck_ec04_enrollment_policy CHECK (jsonb_typeof(policy_snapshot_json)='object');

CREATE UNIQUE INDEX uq_ec04_enrollment_active ON ec04.ec04_enrollment (tenant_id, participant_id, offering_ref) WHERE status IN ('ACTIVE','SUSPENDED','TRANSFER_PENDING');

CREATE INDEX ix_ec04_enrollment_offering ON ec04.ec04_enrollment (tenant_id, offering_ref, status, enrolled_at);

ALTER TABLE ec04.ec04_enrollment_status_history ADD CONSTRAINT pk_ec04_enrollment_history PRIMARY KEY (tenant_id, enrollment_history_id);

ALTER TABLE ec04.ec04_enrollment_status_history ADD CONSTRAINT fk_ec04_enrollment_history_enrollment FOREIGN KEY (tenant_id, enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id);

CREATE INDEX ix_ec04_enrollment_history ON ec04.ec04_enrollment_status_history (tenant_id, enrollment_id, occurred_at);

ALTER TABLE ec04.ec04_enrollment_transfer_request ADD CONSTRAINT pk_ec04_transfer_request PRIMARY KEY (tenant_id, transfer_request_id);

ALTER TABLE ec04.ec04_enrollment_transfer_request ADD CONSTRAINT fk_ec04_transfer_source FOREIGN KEY (tenant_id, source_enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id);

ALTER TABLE ec04.ec04_enrollment_transfer_request ADD CONSTRAINT fk_ec04_transfer_pool FOREIGN KEY (tenant_id, destination_capacity_pool_id) REFERENCES ec04.ec04_capacity_pool(tenant_id, capacity_pool_id);

ALTER TABLE ec04.ec04_enrollment_transfer_request ADD CONSTRAINT ck_ec04_transfer_state CHECK (state IN ('DRAFT','SUBMITTED','APPROVED','APPLYING','APPLIED','REJECTED','CANCELLED'));

CREATE UNIQUE INDEX uq_ec04_transfer_active ON ec04.ec04_enrollment_transfer_request (tenant_id, source_enrollment_id) WHERE state IN ('SUBMITTED','APPROVED','APPLYING');

ALTER TABLE ec04.ec04_enrollment_withdrawal_request ADD CONSTRAINT pk_ec04_withdrawal_request PRIMARY KEY (tenant_id, withdrawal_request_id);

ALTER TABLE ec04.ec04_enrollment_withdrawal_request ADD CONSTRAINT fk_ec04_withdrawal_enrollment FOREIGN KEY (tenant_id, enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id);

ALTER TABLE ec04.ec04_enrollment_withdrawal_request ADD CONSTRAINT ck_ec04_withdrawal_kind CHECK (withdrawal_kind IN ('WITHDRAWAL','CANCELLATION','VOID_REQUEST'));

ALTER TABLE ec04.ec04_enrollment_withdrawal_request ADD CONSTRAINT ck_ec04_withdrawal_state CHECK (state IN ('SUBMITTED','APPROVED','APPLIED','REJECTED','CANCELLED'));

CREATE UNIQUE INDEX uq_ec04_withdrawal_active ON ec04.ec04_enrollment_withdrawal_request (tenant_id, enrollment_id) WHERE state IN ('SUBMITTED','APPROVED');

ALTER TABLE ec04.ec04_enrollment_document_binding ADD CONSTRAINT pk_ec04_document_binding PRIMARY KEY (tenant_id, document_binding_id);

ALTER TABLE ec04.ec04_enrollment_document_binding ADD CONSTRAINT ck_ec04_document_target CHECK ((registration_id IS NOT NULL)::int + (enrollment_id IS NOT NULL)::int = 1);

ALTER TABLE ec04.ec04_enrollment_document_binding ADD CONSTRAINT ck_ec04_document_state CHECK (verification_state IN ('PENDING','VERIFIED','REJECTED','EXPIRED'));

ALTER TABLE ec04.ec04_enrollment_document_binding ADD CONSTRAINT uq_ec04_document_binding UNIQUE (tenant_id, document_ref, purpose_code);

ALTER TABLE ec04.ec04_consent_receipt_binding ADD CONSTRAINT pk_ec04_consent_binding PRIMARY KEY (tenant_id, consent_binding_id);

ALTER TABLE ec04.ec04_consent_receipt_binding ADD CONSTRAINT ck_ec04_consent_target CHECK ((registration_id IS NOT NULL)::int + (enrollment_id IS NOT NULL)::int = 1);

ALTER TABLE ec04.ec04_consent_receipt_binding ADD CONSTRAINT uq_ec04_consent_once UNIQUE (tenant_id, consent_ref);

ALTER TABLE ec04.ec04_integration_effect_receipt ADD CONSTRAINT pk_ec04_effect_receipt PRIMARY KEY (tenant_id, effect_receipt_id);

ALTER TABLE ec04.ec04_integration_effect_receipt ADD CONSTRAINT ck_ec04_effect_state CHECK (effect_state IN ('CONFIRMED','REJECTED','UNKNOWN_EFFECT','NOT_APPLIED'));

CREATE INDEX ix_ec04_effect_unknown ON ec04.ec04_integration_effect_receipt (tenant_id, context_code, observed_at) WHERE effect_state='UNKNOWN_EFFECT';

ALTER TABLE ec04.ec04_command_idempotency ADD CONSTRAINT pk_ec04_command_idempotency PRIMARY KEY (tenant_id, idempotency_id);

ALTER TABLE ec04.ec04_command_idempotency ADD CONSTRAINT uq_ec04_idempotency_key UNIQUE (tenant_id, idempotency_key);

ALTER TABLE ec04.ec04_command_idempotency ADD CONSTRAINT ck_ec04_idempotency_state CHECK (state IN ('IN_PROGRESS','SUCCEEDED','FAILED_RECOVERABLE','FAILED_FINAL'));

ALTER TABLE ec04.ec04_command_idempotency ADD CONSTRAINT ck_ec04_idempotency_response CHECK (response_status IS NULL OR (response_status BETWEEN 100 AND 599));

ALTER TABLE ec04.ec04_command_idempotency ADD CONSTRAINT ck_ec04_idempotency_payload CHECK (response_json IS NULL OR jsonb_typeof(response_json) IN ('object','array'));

CREATE INDEX ix_ec04_idempotency_recovery ON ec04.ec04_command_idempotency (tenant_id, lease_until) WHERE state='IN_PROGRESS';

ALTER TABLE ec04.ec04_outbox_event ADD CONSTRAINT pk_ec04_outbox_event PRIMARY KEY (tenant_id, event_id);

ALTER TABLE ec04.ec04_outbox_event ADD CONSTRAINT ck_ec04_outbox_schema CHECK (schema_version \> 0);

ALTER TABLE ec04.ec04_outbox_event ADD CONSTRAINT ck_ec04_outbox_payload CHECK (jsonb_typeof(payload_json)='object');

ALTER TABLE ec04.ec04_outbox_event ADD CONSTRAINT ck_ec04_outbox_state CHECK (state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED'));

ALTER TABLE ec04.ec04_outbox_event ADD CONSTRAINT ck_ec04_outbox_attempts CHECK (attempt_count \>= 0);

CREATE INDEX ix_ec04_outbox_claim ON ec04.ec04_outbox_event (tenant_id, next_attempt_at, occurred_at) WHERE state IN ('PENDING','FAILED');

CREATE INDEX ix_ec04_outbox_reclaim ON ec04.ec04_outbox_event (tenant_id, lease_until) WHERE state='IN_FLIGHT';

ALTER TABLE ec04.ec04_inbox_message ADD CONSTRAINT pk_ec04_inbox_message PRIMARY KEY (tenant_id, message_id);

ALTER TABLE ec04.ec04_inbox_message ADD CONSTRAINT ck_ec04_inbox_state CHECK (state IN ('RECEIVED','PROCESSING','PROCESSED','FAILED'));

CREATE INDEX ix_ec04_inbox_state ON ec04.ec04_inbox_message (tenant_id, state, received_at);

ALTER TABLE ec04.ec04_operation_status ADD CONSTRAINT pk_ec04_operation_status PRIMARY KEY (tenant_id, operation_id);

ALTER TABLE ec04.ec04_operation_status ADD CONSTRAINT ck_ec04_operation_state CHECK (state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED'));

ALTER TABLE ec04.ec04_operation_status ADD CONSTRAINT ck_ec04_operation_progress CHECK ((progress_current IS NULL AND progress_total IS NULL) OR (progress_current\>=0 AND progress_total\>=0 AND progress_current\<=progress_total));

ALTER TABLE ec04.ec04_operation_status ADD CONSTRAINT ck_ec04_operation_result CHECK (result_json IS NULL OR jsonb_typeof(result_json) IN ('object','array'));

CREATE INDEX ix_ec04_operation_active ON ec04.ec04_operation_status (tenant_id, updated_at) WHERE state IN ('PENDING','RUNNING','UNKNOWN_EFFECT');

-- Supplemental internal tenant-aware references not expressible compactly in the field matrix

ALTER TABLE ec04.ec04_prospect_case ADD CONSTRAINT fk_ec04_prospect_participant FOREIGN KEY (tenant_id, converted_participant_id) REFERENCES ec04.ec04_participant_profile(tenant_id, participant_id);

ALTER TABLE ec04.ec04_prospect_case ADD CONSTRAINT fk_ec04_prospect_registration FOREIGN KEY (tenant_id, converted_registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_registration_invitation ADD CONSTRAINT fk_ec04_invitation_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_registration_request ADD CONSTRAINT fk_ec04_registration_invitation FOREIGN KEY (tenant_id, source_invitation_id) REFERENCES ec04.ec04_registration_invitation(tenant_id, invitation_id);

ALTER TABLE ec04.ec04_registration_request ADD CONSTRAINT fk_ec04_registration_batch_item FOREIGN KEY (tenant_id, source_batch_item_id) REFERENCES ec04.ec04_registration_batch_item(tenant_id, batch_item_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_registration_batch ADD CONSTRAINT fk_ec04_batch_operation FOREIGN KEY (tenant_id, operation_id) REFERENCES ec04.ec04_operation_status(tenant_id, operation_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_registration_batch_item ADD CONSTRAINT fk_ec04_batch_item_participant FOREIGN KEY (tenant_id, participant_id) REFERENCES ec04.ec04_participant_profile(tenant_id, participant_id);

ALTER TABLE ec04.ec04_registration_batch_item ADD CONSTRAINT fk_ec04_batch_item_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_seat_reservation ADD CONSTRAINT fk_ec04_seat_waitlist_offer FOREIGN KEY (tenant_id, waitlist_offer_id) REFERENCES ec04.ec04_waitlist_offer(tenant_id, waitlist_offer_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_waitlist_entry ADD CONSTRAINT fk_ec04_waitlist_last_offer FOREIGN KEY (tenant_id, last_offer_id) REFERENCES ec04.ec04_waitlist_offer(tenant_id, waitlist_offer_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_waitlist_offer ADD CONSTRAINT fk_ec04_waitlist_offer_seat FOREIGN KEY (tenant_id, seat_reservation_id) REFERENCES ec04.ec04_seat_reservation(tenant_id, seat_reservation_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT fk_ec04_pre_identity FOREIGN KEY (tenant_id, identity_receipt_id) REFERENCES ec04.ec04_identity_assurance_receipt(tenant_id, identity_receipt_id);

ALTER TABLE ec04.ec04_pre_enrollment ADD CONSTRAINT fk_ec04_pre_converted_enrollment FOREIGN KEY (tenant_id, converted_enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT fk_ec04_enrollment_pre FOREIGN KEY (tenant_id, pre_enrollment_id) REFERENCES ec04.ec04_pre_enrollment(tenant_id, pre_enrollment_id);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT uq_ec04_enrollment_registration UNIQUE (tenant_id, registration_id);

ALTER TABLE ec04.ec04_enrollment ADD CONSTRAINT uq_ec04_enrollment_seat UNIQUE (tenant_id, seat_reservation_id);

ALTER TABLE ec04.ec04_enrollment_transfer_request ADD CONSTRAINT fk_ec04_transfer_seat FOREIGN KEY (tenant_id, destination_seat_reservation_id) REFERENCES ec04.ec04_seat_reservation(tenant_id, seat_reservation_id);

ALTER TABLE ec04.ec04_enrollment_transfer_request ADD CONSTRAINT fk_ec04_transfer_new_enrollment FOREIGN KEY (tenant_id, new_enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id) DEFERRABLE INITIALLY DEFERRED;

ALTER TABLE ec04.ec04_enrollment_document_binding ADD CONSTRAINT fk_ec04_document_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_enrollment_document_binding ADD CONSTRAINT fk_ec04_document_enrollment FOREIGN KEY (tenant_id, enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id);

ALTER TABLE ec04.ec04_consent_receipt_binding ADD CONSTRAINT fk_ec04_consent_registration FOREIGN KEY (tenant_id, registration_id) REFERENCES ec04.ec04_registration_request(tenant_id, registration_id);

ALTER TABLE ec04.ec04_consent_receipt_binding ADD CONSTRAINT fk_ec04_consent_enrollment FOREIGN KEY (tenant_id, enrollment_id) REFERENCES ec04.ec04_enrollment(tenant_id, enrollment_id);

CREATE OR REPLACE FUNCTION ec04.forbid_append_only_mutation() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

RAISE EXCEPTION 'EC04_APPEND_ONLY: % cannot be updated or deleted', TG_TABLE_NAME USING ERRCODE='23514';

END \$\$;

CREATE TRIGGER trg_ec04_eligibility_decision_receipt_append_only BEFORE UPDATE OR DELETE ON ec04.ec04_eligibility_decision_receipt FOR EACH ROW EXECUTE FUNCTION ec04.forbid_append_only_mutation();

CREATE TRIGGER trg_ec04_identity_assurance_receipt_append_only BEFORE UPDATE OR DELETE ON ec04.ec04_identity_assurance_receipt FOR EACH ROW EXECUTE FUNCTION ec04.forbid_append_only_mutation();

CREATE TRIGGER trg_ec04_registration_requirement_result_append_only BEFORE UPDATE OR DELETE ON ec04.ec04_registration_requirement_result FOR EACH ROW EXECUTE FUNCTION ec04.forbid_append_only_mutation();

CREATE TRIGGER trg_ec04_capacity_adjustment_append_only BEFORE UPDATE OR DELETE ON ec04.ec04_capacity_adjustment FOR EACH ROW EXECUTE FUNCTION ec04.forbid_append_only_mutation();

CREATE TRIGGER trg_ec04_enrollment_status_history_append_only BEFORE UPDATE OR DELETE ON ec04.ec04_enrollment_status_history FOR EACH ROW EXECUTE FUNCTION ec04.forbid_append_only_mutation();

CREATE TRIGGER trg_ec04_consent_receipt_binding_append_only BEFORE UPDATE OR DELETE ON ec04.ec04_consent_receipt_binding FOR EACH ROW EXECUTE FUNCTION ec04.forbid_append_only_mutation();

CREATE TRIGGER trg_ec04_integration_effect_receipt_append_only BEFORE UPDATE OR DELETE ON ec04.ec04_integration_effect_receipt FOR EACH ROW EXECUTE FUNCTION ec04.forbid_append_only_mutation();

CREATE OR REPLACE FUNCTION ec04.guard_registration_transition() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF NEW.state = OLD.state THEN RETURN NEW; END IF;

IF NOT (

(OLD.state='DRAFT' AND NEW.state IN ('SUBMITTED','CANCELLED','EXPIRED')) OR

(OLD.state='SUBMITTED' AND NEW.state IN ('VALIDATING','CANCELLED','EXPIRED')) OR

(OLD.state='VALIDATING' AND NEW.state IN ('ELIGIBLE','REJECTED','WAITLISTED','CANCELLED')) OR

(OLD.state='ELIGIBLE' AND NEW.state IN ('WAITLISTED','PRE_ENROLLED','ENROLLED','CANCELLED','EXPIRED')) OR

(OLD.state='WAITLISTED' AND NEW.state IN ('PRE_ENROLLED','ENROLLED','CANCELLED','EXPIRED')) OR

(OLD.state='PRE_ENROLLED' AND NEW.state IN ('ENROLLED','CANCELLED','EXPIRED'))

) THEN RAISE EXCEPTION 'EC04_REGISTRATION_INVALID_TRANSITION: % -\> %',OLD.state,NEW.state USING ERRCODE='23514'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec04_registration_transition BEFORE UPDATE OF state ON ec04.ec04_registration_request FOR EACH ROW EXECUTE FUNCTION ec04.guard_registration_transition();

CREATE OR REPLACE FUNCTION ec04.bump_registration_revision() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE rid uuid; tid uuid;

BEGIN

tid:=COALESCE(NEW.tenant_id,OLD.tenant_id); rid:=COALESCE(NEW.registration_id,OLD.registration_id);

UPDATE ec04.ec04_registration_request SET version=version+1, updated_at=now() WHERE tenant_id=tid AND registration_id=rid;

RETURN COALESCE(NEW,OLD);

END \$\$;

CREATE TRIGGER trg_ec04_registration_requirement_bump AFTER INSERT OR UPDATE OR DELETE ON ec04.ec04_registration_requirement FOR EACH ROW EXECUTE FUNCTION ec04.bump_registration_revision();

CREATE TRIGGER trg_ec04_eligibility_decision_receipt_bump AFTER INSERT OR UPDATE OR DELETE ON ec04.ec04_eligibility_decision_receipt FOR EACH ROW EXECUTE FUNCTION ec04.bump_registration_revision();

CREATE TRIGGER trg_ec04_identity_assurance_receipt_bump AFTER INSERT OR UPDATE OR DELETE ON ec04.ec04_identity_assurance_receipt FOR EACH ROW EXECUTE FUNCTION ec04.bump_registration_revision();

CREATE OR REPLACE FUNCTION ec04.apply_seat_reservation_capacity() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE tid uuid; pid uuid; mode varchar; cap int; overb int; reserved int; enrolled int; oldstate varchar; newstate varchar;

BEGIN

tid:=COALESCE(NEW.tenant_id,OLD.tenant_id); pid:=COALESCE(NEW.capacity_pool_id,OLD.capacity_pool_id);

SELECT capacity_mode,hard_capacity,overbook_limit,current_reserved,current_enrolled INTO mode,cap,overb,reserved,enrolled

FROM ec04.ec04_capacity_pool WHERE tenant_id=tid AND capacity_pool_id=pid FOR UPDATE;

IF TG_OP='INSERT' THEN oldstate:=NULL; newstate:=NEW.state; ELSE oldstate:=OLD.state; newstate:=NEW.state; END IF;

IF TG_OP='INSERT' AND newstate='HELD' THEN

IF mode='FIXED' AND reserved+enrolled \>= cap+overb THEN RAISE EXCEPTION 'EC04_CAPACITY_FULL' USING ERRCODE='23514'; END IF;

UPDATE ec04.ec04_capacity_pool SET current_reserved=current_reserved+1, version=version+1, updated_at=now() WHERE tenant_id=tid AND capacity_pool_id=pid;

ELSIF TG_OP='UPDATE' AND oldstate='HELD' AND newstate='CONSUMED' THEN

UPDATE ec04.ec04_capacity_pool SET current_reserved=current_reserved-1,current_enrolled=current_enrolled+1,version=version+1,updated_at=now() WHERE tenant_id=tid AND capacity_pool_id=pid;

ELSIF TG_OP='UPDATE' AND oldstate='HELD' AND newstate IN ('RELEASED','EXPIRED') THEN

UPDATE ec04.ec04_capacity_pool SET current_reserved=current_reserved-1,version=version+1,updated_at=now() WHERE tenant_id=tid AND capacity_pool_id=pid;

ELSIF TG_OP='UPDATE' AND oldstate\<\>newstate THEN

RAISE EXCEPTION 'EC04_SEAT_INVALID_TRANSITION: % -\> %',oldstate,newstate USING ERRCODE='23514';

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec04_seat_capacity AFTER INSERT OR UPDATE OF state ON ec04.ec04_seat_reservation FOR EACH ROW EXECUTE FUNCTION ec04.apply_seat_reservation_capacity();

CREATE OR REPLACE FUNCTION ec04.apply_waitlist_counter() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE tid uuid; pid uuid; old_active boolean; new_active boolean;

BEGIN

tid:=COALESCE(NEW.tenant_id,OLD.tenant_id); pid:=COALESCE(NEW.capacity_pool_id,OLD.capacity_pool_id);

old_active := TG_OP\<\>'INSERT' AND OLD.state IN ('ACTIVE','OFFERED');

new_active := TG_OP\<\>'DELETE' AND NEW.state IN ('ACTIVE','OFFERED');

IF NOT old_active AND new_active THEN UPDATE ec04.ec04_capacity_pool SET current_waitlisted=current_waitlisted+1,version=version+1,updated_at=now() WHERE tenant_id=tid AND capacity_pool_id=pid;

ELSIF old_active AND NOT new_active THEN UPDATE ec04.ec04_capacity_pool SET current_waitlisted=current_waitlisted-1,version=version+1,updated_at=now() WHERE tenant_id=tid AND capacity_pool_id=pid;

END IF;

RETURN COALESCE(NEW,OLD);

END \$\$;

CREATE TRIGGER trg_ec04_waitlist_counter AFTER INSERT OR UPDATE OF state OR DELETE ON ec04.ec04_waitlist_entry FOR EACH ROW EXECUTE FUNCTION ec04.apply_waitlist_counter();

CREATE OR REPLACE FUNCTION ec04.guard_enrollment_transition() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF NEW.status=OLD.status THEN RETURN NEW; END IF;

IF NOT (

(OLD.status='ACTIVE' AND NEW.status IN ('SUSPENDED','TRANSFER_PENDING','WITHDRAWN','CANCELLED','VOID')) OR

(OLD.status='SUSPENDED' AND NEW.status IN ('ACTIVE','TRANSFER_PENDING','WITHDRAWN','CANCELLED','VOID')) OR

(OLD.status='TRANSFER_PENDING' AND NEW.status IN ('ACTIVE','TRANSFERRED','WITHDRAWN','CANCELLED'))

) THEN RAISE EXCEPTION 'EC04_ENROLLMENT_INVALID_TRANSITION: % -\> %',OLD.status,NEW.status USING ERRCODE='23514'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec04_enrollment_transition BEFORE UPDATE OF status ON ec04.ec04_enrollment FOR EACH ROW EXECUTE FUNCTION ec04.guard_enrollment_transition();

CREATE OR REPLACE FUNCTION ec04.enrollment_history_and_capacity() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE corr uuid;

BEGIN

corr:=gen_random_uuid();

IF TG_OP='INSERT' THEN

INSERT INTO ec04.ec04_enrollment_status_history(tenant_id,enrollment_id,from_status,to_status,reason_code,actor_subject_ref,correlation_id,occurred_at)

VALUES(NEW.tenant_id,NEW.enrollment_id,NULL,NEW.status,NEW.reason_code,NEW.created_by_subject,corr,now());

ELSIF NEW.status IS DISTINCT FROM OLD.status THEN

INSERT INTO ec04.ec04_enrollment_status_history(tenant_id,enrollment_id,from_status,to_status,reason_code,actor_subject_ref,correlation_id,occurred_at)

VALUES(NEW.tenant_id,NEW.enrollment_id,OLD.status,NEW.status,NEW.reason_code,NULL,corr,now());

IF OLD.status IN ('ACTIVE','SUSPENDED','TRANSFER_PENDING') AND NEW.status IN ('TRANSFERRED','WITHDRAWN','CANCELLED','VOID') THEN

UPDATE ec04.ec04_capacity_pool SET current_enrolled=current_enrolled-1,version=version+1,updated_at=now()

WHERE tenant_id=NEW.tenant_id AND capacity_pool_id=NEW.capacity_pool_id;

END IF;

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec04_enrollment_history AFTER INSERT OR UPDATE OF status ON ec04.ec04_enrollment FOR EACH ROW EXECUTE FUNCTION ec04.enrollment_history_and_capacity();

CREATE OR REPLACE FUNCTION ec04.guard_waitlist_offer_shape() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF NEW.state='ISSUED' AND NEW.seat_reservation_id IS NULL THEN RAISE EXCEPTION 'EC04_WAITLIST_OFFER_REQUIRES_SEAT' USING ERRCODE='23514'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec04_waitlist_offer_shape BEFORE INSERT OR UPDATE ON ec04.ec04_waitlist_offer FOR EACH ROW EXECUTE FUNCTION ec04.guard_waitlist_offer_shape();

-- Defense-in-depth tenant isolation: runtime roles must not own tables and must not have BYPASSRLS.

ALTER TABLE ec04.ec04_participant_profile ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_participant_profile FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_participant_profile_tenant ON ec04.ec04_participant_profile USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_prospect_case ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_prospect_case FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_prospect_case_tenant ON ec04.ec04_prospect_case USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_registration_invitation ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_registration_invitation FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_registration_invitation_tenant ON ec04.ec04_registration_invitation USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_registration_request ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_registration_request FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_registration_request_tenant ON ec04.ec04_registration_request USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_registration_batch ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_registration_batch FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_registration_batch_tenant ON ec04.ec04_registration_batch USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_registration_batch_item ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_registration_batch_item FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_registration_batch_item_tenant ON ec04.ec04_registration_batch_item USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_eligibility_decision_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_eligibility_decision_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_eligibility_decision_receipt_tenant ON ec04.ec04_eligibility_decision_receipt USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_identity_assurance_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_identity_assurance_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_identity_assurance_receipt_tenant ON ec04.ec04_identity_assurance_receipt USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_registration_requirement ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_registration_requirement FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_registration_requirement_tenant ON ec04.ec04_registration_requirement USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_registration_requirement_result ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_registration_requirement_result FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_registration_requirement_result_tenant ON ec04.ec04_registration_requirement_result USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_capacity_pool ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_capacity_pool FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_capacity_pool_tenant ON ec04.ec04_capacity_pool USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_capacity_adjustment ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_capacity_adjustment FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_capacity_adjustment_tenant ON ec04.ec04_capacity_adjustment USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_seat_reservation ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_seat_reservation FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_seat_reservation_tenant ON ec04.ec04_seat_reservation USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_waitlist_entry ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_waitlist_entry FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_waitlist_entry_tenant ON ec04.ec04_waitlist_entry USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_waitlist_offer ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_waitlist_offer FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_waitlist_offer_tenant ON ec04.ec04_waitlist_offer USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_pre_enrollment ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_pre_enrollment FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_pre_enrollment_tenant ON ec04.ec04_pre_enrollment USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_enrollment ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_enrollment FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_enrollment_tenant ON ec04.ec04_enrollment USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_enrollment_status_history ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_enrollment_status_history FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_enrollment_status_history_tenant ON ec04.ec04_enrollment_status_history USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_enrollment_transfer_request ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_enrollment_transfer_request FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_enrollment_transfer_request_tenant ON ec04.ec04_enrollment_transfer_request USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_enrollment_withdrawal_request ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_enrollment_withdrawal_request FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_enrollment_withdrawal_request_tenant ON ec04.ec04_enrollment_withdrawal_request USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_enrollment_document_binding ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_enrollment_document_binding FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_enrollment_document_binding_tenant ON ec04.ec04_enrollment_document_binding USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_consent_receipt_binding ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_consent_receipt_binding FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_consent_receipt_binding_tenant ON ec04.ec04_consent_receipt_binding USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_integration_effect_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_integration_effect_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_integration_effect_receipt_tenant ON ec04.ec04_integration_effect_receipt USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_command_idempotency ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_command_idempotency FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_command_idempotency_tenant ON ec04.ec04_command_idempotency USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_outbox_event ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_outbox_event FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_outbox_event_tenant ON ec04.ec04_outbox_event USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_inbox_message ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_inbox_message FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_inbox_message_tenant ON ec04.ec04_inbox_message USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

ALTER TABLE ec04.ec04_operation_status ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec04.ec04_operation_status FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec04_operation_status_tenant ON ec04.ec04_operation_status USING (tenant_id = ec04.current_tenant_uuid()) WITH CHECK (tenant_id = ec04.current_tenant_uuid());

CREATE INDEX IF NOT EXISTS ix_ec04_registration_person_offering ON ec04.ec04_registration_request(tenant_id,participant_id,offering_ref,state);

CREATE INDEX IF NOT EXISTS ix_ec04_enrollment_participant ON ec04.ec04_enrollment(tenant_id,participant_id,enrolled_at DESC);

CREATE INDEX IF NOT EXISTS ix_ec04_capacity_available ON ec04.ec04_capacity_pool(tenant_id,offering_ref,state,current_enrolled,current_reserved);

CREATE INDEX IF NOT EXISTS ix_ec04_waitlist_expire_offers ON ec04.ec04_waitlist_offer(tenant_id,expires_at) WHERE state='ISSUED';

-- Grants are environment-specific. Required invariant: migrator owns DDL; HTTP runtime has least privilege and NO BYPASSRLS; worker role is separate.

# 14. MongoDB y Redis

PostgreSQL es Source of Truth transaccional de EC-04. MongoDB y Redis son derivados/aceleradores. La pérdida de ambos no puede crear o destruir ParticipantProfile, Registration, SeatReservation, WaitlistEntry, PreEnrollment, Enrollment, receipts, idempotency u outbox. La reconstrucción debe partir de PostgreSQL + eventos/contratos autorizados.

## 14.1 MongoDB — read models derivados

| **Read model**                  | **Uso**                                                              | **Fuente**                        | **Regla de consistencia**                            |
|---------------------------------|----------------------------------------------------------------------|-----------------------------------|------------------------------------------------------|
| **ec04_registration_desk_rm**   | Búsqueda operativa por offering/state/requirements.                  | Registration + CT refs            | Eventual; mutation revalida PostgreSQL.              |
| **ec04_participant_360_rm**     | Resumen EC de registrations/enrollments con CT-04 fields permitidos. | EC-04 + authorized CT projections | Field-level privacy; no new SoT.                     |
| **ec04_capacity_dashboard_rm**  | Occupancy/reserved/waitlisted por offering/segment.                  | CapacityPool/events               | Counters oficiales se leen PostgreSQL para commands. |
| **ec04_waitlist_projection_rm** | Lista priorizada con countdown y offer status.                       | Waitlist/SeatReservation          | Muestra asOf; promotion revalida live.               |
| **ec04_batch_ops_rm**           | Batch/items/OperationStatus agregados.                               | RegistrationBatch + operations    | PARTIAL explícito.                                   |
| **ec04_reconciliation_rm**      | UNKNOWN_EFFECT y dependency health.                                  | EffectReceipt + OperationStatus   | No reemplaza receipt durable.                        |

| **REGLA MONGODB —** Si una proyección está STALE/PARTIAL/UNAVAILABLE, la UI lo declara. Ninguna mutation usa MongoDB para decidir cupo, elegibilidad o enrollment. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 14.2 Redis — aceleración y coordinación técnica

| **Key/patrón**                                 | **Propósito**                       | **TTL/estrategia**               | **Nunca debe hacer**                                         |
|------------------------------------------------|-------------------------------------|----------------------------------|--------------------------------------------------------------|
| **ec04:offering:{tenant}:{id}**                | Cache snapshot EC-02 para lectura.  | TTL corto + version/freshness.   | Autorizar enrollment sin revalidar cuando policy exige live. |
| **ec04:participant:{tenant}:{person}**         | Lookup participant id.              | TTL minutos; invalidación event. | Ser registro único de participant.                           |
| **ec04:registration-list:{tenant}:{offering}** | Lista/read acceleration.            | TTL corto.                       | Ocultar STALE.                                               |
| **ec04:rate:invite:{tenant}:{subject}**        | Rate limit de tokens/invite accept. | Sliding window.                  | Sustituir anti-replay durable.                               |
| **ec04:lock:batch:{tenant}:{batch}**           | Lock técnico job.                   | Lease + fencing si aplica.       | Decidir counters de capacidad.                               |

Seat hold, counters, waitlist ordering inputs, idempotency, outbox lease y OperationStatus permanecen durables en PostgreSQL. Redis puede reducir latencia, nunca aportar correctness final.

# 15. Backend Java 21 / Spring Boot / Spring Modulith

EC-04 se implementa como módulo Spring Modulith dentro del monolito modular PeopleU IA. Domain/Application no conocen JPA, HTTP ni SDKs externos. Adapters implementan CT-04/05/06/07/09/10/15/16, EC-01/02/03/09 y FinancePort. ArchitectureTests bloquean imports/repositories cross-context no autorizados.

## 15.1 Estructura de paquetes normativa

com.peopleu.ec.registration

├── domain

│ ├── participant

│ ├── prospect

│ ├── registration

│ ├── capacity

│ ├── waitlist

│ ├── enrollment

│ └── shared

├── application

│ ├── command

│ ├── query

│ ├── port/in

│ └── port/out

├── adapter

│ ├── in/rest

│ ├── out/persistence

│ ├── out/ct

│ ├── out/ec01

│ ├── out/ec02

│ ├── out/ec03

│ ├── out/ec09

│ ├── out/finance

│ └── out/events

└── config

## 15.2 Aggregates y métodos de intención

| **Aggregate**              | **Métodos de intención mínimos**                                                                             | **Invariante**                            |
|----------------------------|--------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| **ParticipantProfile**     | createForPerson(), restrict(), suspend(), archive()                                                          | Una persona→un rol EC.                    |
| **ProspectCase**           | qualify(), attachPerson(), convert(), markLost(), expire()                                                   | Conversion no duplica person/participant. |
| **RegistrationInvitation** | open(), accept(), revoke(), expire()                                                                         | Token one-shot, hash only.                |
| **RegistrationRequest**    | submit(), startValidation(), markEligible(), waitlist(), preEnroll(), enroll(), reject(), cancel(), expire() | State guard + aggregate revision.         |
| **CapacityPool**           | reserveSeat(), adjustCapacity(), freeze(), reopen(), close()                                                 | Counters y limit físicos.                 |
| **SeatReservation**        | consume(), release(), expire()                                                                               | HELD única transición útil.               |
| **WaitlistEntry**          | offer(), accept(), expire(), remove()                                                                        | Priority no setter libre.                 |
| **WaitlistOffer**          | accept(), expire(), cancel()                                                                                 | ISSUED requiere seat.                     |
| **PreEnrollment**          | satisfyConditions(), markReady(), convert(), expire(), cancel()                                              | CONVERTED solo con enrollment.            |
| **Enrollment**             | suspend(), reactivate(), requestTransfer(), markTransferred(), withdraw(), cancel(), voidEnrollment()        | No update offering/edition.               |
| **TransferRequest**        | submit(), approve(), reject(), apply(), cancel()                                                             | APPLY crea nuevo enrollment.              |
| **WithdrawalRequest**      | approve(), reject(), apply(), cancel()                                                                       | No refund local.                          |

## 15.3 Ports de salida obligatorios

| **Port**                    | **Owner**       | **Contrato**                                          |
|-----------------------------|-----------------|-------------------------------------------------------|
| **InstitutionScopePort**    | CT-01           | authorize scope/tenant.                               |
| **PolicyCatalogPort**       | CT-02           | PolicyVersion immutable + catalogs.                   |
| **PersonIdentityPort**      | CT-04           | resolve person/contact/assurance; no PII shadow.      |
| **DocumentEvidencePort**    | CT-05           | document/evidence refs.                               |
| **WorkflowPort**            | CT-06           | waiver/transfer/withdrawal approvals.                 |
| **NotificationPort**        | CT-07           | invite/waitlist/enrollment notifications post-commit. |
| **IntegrationContractPort** | CT-09           | schema/version governance.                            |
| **AuditPrivacyPort**        | CT-10           | purpose, consent, audit/evidence.                     |
| **AiAssistPort**            | CT-12           | recommendations only.                                 |
| **EligibilityPort**         | CT-15           | evaluate/revalidate decision.                         |
| **MigrationPort**           | CT-16           | dry-run/promotion receipts.                           |
| **ProgramPort**             | EC-01           | ProgramVersion snapshot.                              |
| **OfferingPort**            | EC-02           | Offering/Edition/Cohort status and refs.              |
| **CommercialPort**          | EC-03           | quote validity/commercial clearance.                  |
| **CorporatePort**           | EC-09           | corporate batch/nomination context.                   |
| **FinancePort**             | Core Financiero | financial clearance/query status/reconcile.           |

## 15.4 TenantContext + RLS

Cada use case abre transacción, obtiene tenant del contexto autenticado y ejecuta SET LOCAL peopleu.tenant_id antes de repository access. El rol HTTP no es owner ni BYPASSRLS. Workers configuran tenant por job/message y también quedan sujetos a RLS. Tests negativos prueban SELECT/INSERT/UPDATE sin tenant predicate.

@Transactional

public Enrollment createEnrollment(CreateEnrollmentCommand cmd,

AggregateRevision expectedRegistration) {

tenantSql.setLocal(authenticatedTenant());

var reg = registrationRepository.lockById(cmd.registrationId())

.orElseThrow(NotFound::new);

aggregateRevision.requireMatch(reg.version(), expectedRegistration); // 412

var seat = seatRepository.lockById(cmd.seatReservationId())

.orElseThrow(NotFound::new);

admissionPolicy.requireFreshEvidence(reg, seat, externalFacts.resolve(...));

var enrollment = enrollmentService.enroll(reg, seat, clock.instant());

outbox.append(EnrollmentCreated.from(enrollment));

return enrollment;

}

## 15.5 CapacityAllocator — protocolo de concurrencia

1.  1\. Resolver CapacityPool y orden de locks; para transfer multi-pool ordenar por capacity_pool_id.

2.  2\. Lock SELECT ... FOR UPDATE del pool antes de crear/mutar SeatReservation.

3.  3\. Revalidar state OPEN, mode, hard_capacity, overbook_limit y counters.

4.  4\. Crear HELD; trigger actualiza current_reserved y CHECK valida limit.

5.  5\. Para Enrollment: lock Registration + Seat + Pool; seat HELD→CONSUMED transfiere reserved→enrolled.

6.  6\. Para release/expiry: transición única e idempotente; counter decrementa una sola vez.

7.  7\. Nunca mantener lock mientras se llama dependencia remota; resolver hechos remotos antes o usar fase separada/revalidation.

8.  8\. En deadlock/serialization failure, retry técnico acotado con jitter; no esconder business conflict.

| **ÚLTIMO CUPO —** La prueba de concurrencia debe lanzar múltiples requests contra un CapacityPool con exactamente un seat disponible y demostrar que solo uno obtiene HELD/Enrollment; los demás reciben waitlist/conflict según policy. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 15.6 Idempotencia, outbox e inbox

Create Registration, submit, reserve seat, accept waitlist offer, create Enrollment, apply transfer/withdrawal y batch promotion usan CommandIdempotency. Same key/same hash reproduce la respuesta; same key/different hash retorna 409. IN_PROGRESS posee owner/lease. Outbox usa SKIP LOCKED + lease; Inbox detecta duplicate messageId y hash inconsistente.

# 16. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

Base path recomendado: /api/ec/v1/registration. Los paths separan resources de commands de intención. PATCH se limita a metadata editable; submit/qualify/reserve/waitlist/enroll/transfer/withdraw son actions explícitas. Todas las colecciones son bounded y sorting estable.

## 16.1 Catálogo de endpoints

| **Método** | **Path**                                       | **Propósito**                           | **Headers**                | **Resultado** |
|------------|------------------------------------------------|-----------------------------------------|----------------------------|---------------|
| GET        | /participants                                  | Buscar roles EC paginados               | —                          | 200           |
| POST       | /participants:resolve                          | Resolver/create role desde personRef    | Idempotency-Key            | 200/201       |
| GET        | /participants/{id}                             | ParticipantProfile + ETag               | —                          | 200           |
| POST       | /participants/{id}:restrict                    | Restringir                              | If-Match + Idempotency-Key | 200           |
| GET        | /prospects                                     | Listar prospectos                       | —                          | 200           |
| POST       | /prospects                                     | Crear prospect case                     | Idempotency-Key            | 201           |
| PATCH      | /prospects/{id}                                | Metadata editable                       | If-Match                   | 200/412       |
| POST       | /prospects/{id}:qualify                        | Calificar                               | If-Match                   | 200           |
| POST       | /prospects/{id}:convert                        | Convertir                               | If-Match + Idempotency-Key | 200/201       |
| POST       | /invitations                                   | Emitir invitation                       | Idempotency-Key            | 201           |
| GET        | /invitations/by-token/{token}                  | Resolver token seguro                   | —                          | 200/404/410   |
| POST       | /invitations/{id}:accept                       | Aceptar                                 | Idempotency-Key            | 200/201       |
| POST       | /invitations/{id}:revoke                       | Revocar                                 | If-Match                   | 200           |
| GET        | /registrations                                 | Listar/filtrar                          | —                          | 200           |
| POST       | /registrations                                 | Crear DRAFT                             | Idempotency-Key            | 201           |
| GET        | /registrations/{id}                            | Detalle + ETag                          | —                          | 200           |
| PATCH      | /registrations/{id}                            | Metadata draft                          | If-Match                   | 200/412       |
| POST       | /registrations/{id}:submit                     | Submit                                  | If-Match + Idempotency-Key | 200           |
| POST       | /registrations/{id}:validate                   | Preflight                               | If-Match                   | 200           |
| POST       | /registrations/{id}:cancel                     | Cancelar                                | If-Match + Idempotency-Key | 200           |
| GET        | /registrations/{id}/requirements               | Requirements                            | —                          | 200           |
| POST       | /registrations/{id}/requirements/{reqId}:waive | Solicitar/aplicar waiver según workflow | If-Match + Idempotency-Key | 200/202       |
| POST       | /registrations/{id}:evaluate-eligibility       | Evaluar CT-15                           | If-Match + Idempotency-Key | 200/202       |
| POST       | /registrations/{id}:verify-identity            | Verificar identity assurance            | If-Match + Idempotency-Key | 200/202       |
| GET        | /capacity-pools                                | Listar pools                            | —                          | 200           |
| POST       | /capacity-pools                                | Crear pool                              | Idempotency-Key            | 201           |
| GET        | /capacity-pools/{id}                           | Detalle counters + ETag                 | —                          | 200           |
| POST       | /capacity-pools/{id}:adjust                    | Ajustar capacity                        | If-Match + Idempotency-Key | 200/202       |
| POST       | /capacity-pools/{id}:freeze                    | Freeze                                  | If-Match                   | 200           |
| POST       | /capacity-pools/{id}:reopen                    | Reopen                                  | If-Match                   | 200           |
| POST       | /registrations/{id}:reserve-seat               | Crear hold                              | If-Match + Idempotency-Key | 201/409       |
| POST       | /seat-reservations/{id}:release                | Liberar                                 | If-Match + Idempotency-Key | 200           |
| POST       | /registrations/{id}:join-waitlist              | Agregar waitlist                        | If-Match + Idempotency-Key | 201           |
| GET        | /waitlists/{poolId}                            | Lista autorizada paginada               | —                          | 200           |
| POST       | /capacity-pools/{id}:promote-waitlist          | Promover siguiente(s)                   | Idempotency-Key            | 200/202       |
| POST       | /waitlist-offers/{id}:accept                   | Aceptar offer                           | If-Match + Idempotency-Key | 200           |
| POST       | /registrations/{id}:pre-enroll                 | Crear PreEnrollment                     | If-Match + Idempotency-Key | 201           |
| GET        | /pre-enrollments/{id}                          | Detalle + ETag                          | —                          | 200           |
| POST       | /pre-enrollments/{id}:revalidate               | Revalidar condiciones                   | If-Match                   | 200/202       |
| POST       | /pre-enrollments/{id}:enroll                   | Crear Enrollment                        | If-Match + Idempotency-Key | 201           |
| POST       | /registrations/{id}:enroll                     | Enrollment directo gobernado            | If-Match + Idempotency-Key | 201           |
| GET        | /enrollments                                   | Roster/list                             | —                          | 200           |
| GET        | /enrollments/{id}                              | Detalle + ETag                          | —                          | 200           |
| POST       | /enrollments/{id}:suspend                      | Suspender                               | If-Match + Idempotency-Key | 200           |
| POST       | /enrollments/{id}:reactivate                   | Reactivar                               | If-Match + Idempotency-Key | 200           |
| POST       | /enrollments/{id}:void                         | Void high-assurance                     | If-Match + Idempotency-Key | 200           |
| POST       | /enrollments/{id}/transfers                    | Crear transfer request                  | Idempotency-Key            | 201           |
| POST       | /transfers/{id}:approve                        | Aprobar                                 | If-Match + Idempotency-Key | 200           |
| POST       | /transfers/{id}:apply                          | Aplicar                                 | If-Match + Idempotency-Key | 200/201       |
| POST       | /enrollments/{id}/withdrawals                  | Solicitar retiro                        | Idempotency-Key            | 201           |
| POST       | /withdrawals/{id}:approve                      | Aprobar                                 | If-Match                   | 200           |
| POST       | /withdrawals/{id}:apply                        | Aplicar                                 | If-Match + Idempotency-Key | 200           |
| POST       | /registration-batches                          | Crear batch                             | Idempotency-Key            | 201           |
| POST       | /registration-batches/{id}/items               | Agregar/chunk items                     | Idempotency-Key            | 201           |
| POST       | /registration-batches/{id}:validate            | Dry-run                                 | If-Match                   | 200/202       |
| POST       | /registration-batches/{id}:process             | Procesar async                          | If-Match + Idempotency-Key | 202           |
| GET        | /operations/{id}                               | OperationStatus                         | —                          | 200           |
| POST       | /operations/{id}:reconcile                     | Reconcile UNKNOWN_EFFECT                | Idempotency-Key            | 200/202       |
| GET        | /enrollments/{id}/history                      | Historia                                | —                          | 200           |

## 16.2 Paginación, filtros y sorting

List endpoints aceptan pageSize con máximo policy-defined, cursor preferido para feeds de alta cardinalidad y sort estable con id como desempate. Filtros mínimos: offeringRef, editionRef, cohortRef, state/status, participantRef cuando autorizado, dateFrom/dateTo, scopeRef y batchRef. El response incluye nextCursor, asOf y dataFreshness cuando provenga de read model.

## 16.3 DTOs normativos — ejemplo

public record RegistrationSummaryDto(

UUID registrationId,

String registrationNumber,

UUID participantId,

UUID offeringRef,

String state,

List\<RequirementSummaryDto\> requirements,

CapacityStatusDto capacity,

DataFreshness freshness,

long version

) {}

public record CreateEnrollmentRequest(

UUID registrationId,

UUID preEnrollmentId,

UUID seatReservationId,

UUID commercialQuoteRef,

UUID financialClearanceRef,

String reasonCode

) {}

## 16.4 Error contract

| **HTTP** | **Uso EC-04**                                     | **Ejemplos reasonCode**                                                  |
|----------|---------------------------------------------------|--------------------------------------------------------------------------|
| **400**  | Request/schema inválido                           | EC04_REQUEST_INVALID                                                     |
| **401**  | No autenticado                                    | AUTH_REQUIRED                                                            |
| **403**  | RBAC/ABAC/SoD/step-up                             | EC04_SCOPE_FORBIDDEN · STEP_UP_REQUIRED                                  |
| **404**  | Resource no visible/existe                        | EC04_REGISTRATION_NOT_FOUND                                              |
| **409**  | Conflicto de estado/capacity/idempotency          | EC04_CAPACITY_FULL · ACTIVE_REGISTRATION_EXISTS · IDEMPOTENCY_KEY_REUSED |
| **410**  | Invitation/token expirado si contrato adopta Gone | EC04_INVITATION_EXPIRED                                                  |
| **412**  | ETag stale                                        | EC04_PRECONDITION_FAILED                                                 |
| **422**  | Regla de negocio                                  | EC04_REQUIREMENTS_UNSATISFIED · ELIGIBILITY_FAILED                       |
| **429**  | Rate limit                                        | EC04_RATE_LIMITED                                                        |
| **503**  | Dependency crítica unavailable                    | EC04_DEPENDENCY_UNAVAILABLE                                              |

ProblemDetail incluye type, title, status, detail sanitizado, instance, reasonCode, correlationId, retryable y optional fieldErrors/unresolvedDependencies. No expone PII, SQL ni stack traces.

# 17. Eventos, outbox/inbox y AsyncAPI

Los eventos de integración son hechos post-commit. Event envelope mínimo: eventId/messageId, tenantId, aggregateType, aggregateId, eventType, schemaVersion, occurredAt, correlationId, causationId, subject/scope refs mínimos y payload. La payload evita PII; consumidores resuelven Person por sus contratos autorizados.

| **Evento**                        | **Aggregate**      | **Payload mínimo**                                          | **Consumidores**              |
|-----------------------------------|--------------------|-------------------------------------------------------------|-------------------------------|
| **ProspectConverted.v1**          | ProspectCase       | participantId, registrationId?                              | Analytics/Registration        |
| **ParticipantProfileCreated.v1**  | ParticipantProfile | participantId, personRef                                    | EC downstream autorizado      |
| **RegistrationSubmitted.v1**      | Registration       | registrationId, offeringRef, participantId                  | CT-15/analytics               |
| **RegistrationEligible.v1**       | Registration       | registrationId, decisionReceiptId                           | Capacity/analytics            |
| **RegistrationWaitlisted.v1**     | Registration       | registrationId, poolId, waitlistEntryId                     | CT-07/analytics               |
| **WaitlistOfferIssued.v1**        | WaitlistOffer      | offerId, entryId, expiresAt                                 | CT-07/portal                  |
| **WaitlistOfferAccepted.v1**      | WaitlistOffer      | offerId, registrationId                                     | Admission                     |
| **PreEnrollmentCreated.v1**       | PreEnrollment      | preEnrollmentId, registrationId, expiresAt                  | Portal/ops                    |
| **EnrollmentCreated.v1**          | Enrollment         | enrollmentId, participantId, offeringRef, programVersionRef | EC-05/06/07/analytics         |
| **EnrollmentSuspended.v1**        | Enrollment         | enrollmentId, reasonCode                                    | EC-05/06/07                   |
| **EnrollmentTransferred.v1**      | Enrollment         | sourceEnrollmentId, newEnrollmentId                         | EC-05/06/07                   |
| **EnrollmentWithdrawn.v1**        | Enrollment         | enrollmentId, effectiveAt, reasonCode                       | EC-05/06/07/Finance follow-up |
| **EnrollmentVoided.v1**           | Enrollment         | enrollmentId, reasonCode                                    | Downstream governance         |
| **CapacityChanged.v1**            | CapacityPool       | poolId, counters, reason                                    | Ops/analytics                 |
| **RegistrationBatchCompleted.v1** | RegistrationBatch  | batchId, counts, state                                      | EC-09/ops                     |

## 17.1 Outbox claiming

SELECT event_id

FROM ec04.ec04_outbox_event

WHERE tenant_id = :tenant

AND state IN ('PENDING','FAILED')

AND next_attempt_at \<= now()

ORDER BY occurred_at

FOR UPDATE SKIP LOCKED

LIMIT :batchSize;

-- mark IN_FLIGHT, owner_id, lease_until in the same transaction

DELIVERED es terminal. IN_FLIGHT con lease vencido se reclama. Poison events se aíslan con reason code y replay gobernado; nunca se borra silenciosamente un evento que representa un hecho académico.

## 17.2 Inbox dedup

Antes del handler se intenta insertar (tenant_id,message_id,payload_hash). Si existe mismo hash, se retorna resultado anterior/no-op; si difiere, se emite EC04_MESSAGE_ID_REUSED_DIFFERENT_PAYLOAD y se bloquea el handler. PROCESSING/FAILED pueden recuperarse según policy.

# 18. Integraciones, resiliencia, reconciliación y UNKNOWN_EFFECT

| **Dependencia**       | **Timeout inicial**   | **Retry**                                                                | **Circuit breaker** | **Degradación/reconciliation**                                                         |
|-----------------------|-----------------------|--------------------------------------------------------------------------|---------------------|----------------------------------------------------------------------------------------|
| CT-04 Person/Identity | 1–3 s según operación | Reads idempotentes con backoff; writes/verify según idempotency contract | Sí                  | Si identity crítica unavailable, submit/enroll fail-closed; no local Person inventado. |
| CT-15 Eligibility     | 2–5 s                 | Solo si effect conocido no aplicado o query idempotente                  | Sí                  | UNKNOWN receipt; no ELIGIBLE por defecto.                                              |
| EC-02 Offering        | 1–2 s                 | Read retry corto                                                         | Sí                  | Read UI STALE permitido; mutation crítica revalida live/fail-closed.                   |
| EC-03 Commercial      | 2–4 s                 | Quote reads idempotentes; accept/clearance según contract                | Sí                  | No crear price local; mantener state previo.                                           |
| Finance               | 2–5 s                 | Reconcile-before-retry para efectos                                      | Sí                  | UNKNOWN_EFFECT explícito; seat/pre-enrollment window policy-driven.                    |
| CT-06 Workflow        | 2–5 s                 | Query status por workflow/idempotency                                    | Sí                  | Waiver/transfer queda pendiente; no auto-approve.                                      |
| CT-07 Notification    | 2–5 s                 | Async retry via CT-07                                                    | Sí                  | Business fact permanece; portal consultable.                                           |
| EC-09 Corporate       | 2–4 s                 | Read retry corto                                                         | Sí                  | Batch item puede quedar PARTIAL/PENDING; no copiar acuerdo.                            |

## 18.1 Patrón UNKNOWN_EFFECT

- 1\. EC-04 envía operación con Idempotency-Key/remote_operation_ref.

- 2\. El sistema remoto puede aplicar el efecto.

- 3\. La respuesta se pierde/timeout.

- 4\. EC-04 persiste IntegrationEffectReceipt UNKNOWN_EFFECT y OperationStatus si aplica.

- 5\. No reintenta el side effect.

- 6\. Ejecuta queryStatus/reconcile con el mismo remote_operation_ref.

- 7\. Si CONFIRMED, aplica follow-up local idempotente.

- 8\. Si NOT_APPLIED, retry solo bajo policy.

- 9\. Si sigue UNKNOWN, escala sin inventar éxito/fallo.

| **FRONTERA —** Un timeout de Finance o CT-15 no puede convertir Registration a ENROLLED ni marcar requisito como satisfecho. UNKNOWN_EFFECT existe precisamente para no confundir ausencia de respuesta con ausencia de efecto. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 19. Frontend Web enterprise por workspaces

Frontend se organiza por tareas reales, no por tablas. Baseline: React + TypeScript, client generado OpenAPI, query/cache layer estándar PeopleU, forms con schema validation, ErrorBoundary, route guards, ETag support y state model común NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.

| **Workspace**                   | **Usuario**          | **Ruta**                          | **Construcción**                                                                                                       |
|---------------------------------|----------------------|-----------------------------------|------------------------------------------------------------------------------------------------------------------------|
| **Prospect Intake**             | Admisiones/marketing | /ec/registration/prospects        | Inbox/cards por offering/source; qualify/convert drawers; identity resolution status; no PII libre.                    |
| **Participant 360 EC**          | Staff autorizado     | /ec/registration/participants/:id | Header participant code + CT-04 minimal profile; tabs registrations/enrollments/doc refs/history; field-level privacy. |
| **Registration Desk**           | Registration Agent   | /ec/registration/registrations    | Filters by offering/state/requirements; SLA/KPI; bulk actions gobernadas; detail side panel.                           |
| **Admission Review**            | Reviewer/Approver    | /ec/registration/review           | Queue requirements/eligibility/waivers; evidence refs; reason codes; SoD warnings.                                     |
| **Capacity & Waitlist Console** | Capacity Manager     | /ec/registration/capacity         | Cards capacity/reserved/enrolled/waitlisted; segment tabs; waitlist ordered table; adjust/freeze dialogs with step-up. |
| **Enrollment Control Center**   | Enrollment Manager   | /ec/registration/enrollments      | Roster, status, ETag actions, transfer/withdraw drawers, history timeline.                                             |
| **Corporate / Batch Intake**    | Corporate Intake     | /ec/registration/batches          | Upload/preflight, item validation grid, 202 progress, partial errors/export evidence.                                  |
| **Reconciliation Center**       | Ops                  | /ec/registration/reconciliation   | UNKNOWN_EFFECT, stale deps, counter audits, outbox/inbox replay links.                                                 |
| **Audit & Evidence**            | Auditor              | /ec/registration/audit            | Read-only lineage, receipts, status history, policy snapshots, export CT-05.                                           |

## 19.1 Registration Desk — layout implementable

- Top bar: scope selector autorizado, offering filter, date range, state chips y saved views.

- KPI strip: Submitted, Needs Review, Eligible, Waitlisted, Pre-enrolled, Enrolled; cada tile muestra freshness.

- Main table: Registration \#, participant ref/display autorizado, offering, state, blocking requirements, capacity status, age/SLA, last update.

- Right drawer: summary, requirements timeline, receipts/evidence refs, commercial/financial status, audit, permitted actions.

- Mutations: submit/cancel/waitlist/pre-enroll/enroll con If-Match y confirmation; 412 abre conflict compare/reload.

- Service banners: STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT visibles y no colapsados en empty state.

- Accessibility: keyboard-first table/drawer, focus return, ARIA live for async operation/status changes, WCAG 2.2 AA baseline.

- Responsive: desktop master-detail; tablet stacked; critical admin actions no se trasladan automáticamente a mobile.

## 19.2 Capacity & Waitlist Console — UX de concurrencia

- Capacity card distingue hard capacity, overbook, reserved, enrolled, available y waitlisted.

- ZERO disponible debe mostrarse diferente de UNAVAILABLE capacity service.

- Waitlist ordering muestra policy version y tie-break explanation; no editable drag-and-drop.

- Promotion preview lista candidate y reasons; apply revalida server-side bajo lock.

- Adjust capacity modal exige reason, before/after, impact preview y step-up/approval when threshold.

- Countdown de offer se basa en server expiresAt y clock-skew tolerant UI; server es autoridad.

## 19.3 Estado visual estándar

| **Estado**         | **Presentación**                                                  | **Acción permitida**                             |
|--------------------|-------------------------------------------------------------------|--------------------------------------------------|
| **NO_DATA**        | Empty state contextual “No hay registrations para estos filtros”. | Crear/limpiar filtros.                           |
| **ZERO**           | KPI 0 validado, p.ej. seatsAvailable=0.                           | Waitlist/alternative según policy.               |
| **STALE**          | Badge con asOf + warning.                                         | Reads permitidos; mutation revalida.             |
| **PARTIAL**        | Banner + secciones no resueltas.                                  | Mutations solo si dependencies críticas frescas. |
| **UNAVAILABLE**    | Error dependency + correlationId.                                 | Retry read/continuar tareas no dependientes.     |
| **UNKNOWN_EFFECT** | Estado bloqueado con reconcile/status link.                       | No repetir side effect.                          |

# 20. Mobile

EC-04 sí requiere Mobile para participante, pero no replica la consola administrativa. React Native comparte contratos DTO/client y design tokens; cualquier operación sensible usa auth/step-up según IAM. Offline se limita a lectura cacheada y drafts locales no oficiales.

| **Journey mobile**     | **Pantallas**                                                  | **Offline/sync**                       | **Restricciones**                                                                              |
|------------------------|----------------------------------------------------------------|----------------------------------------|------------------------------------------------------------------------------------------------|
| **Self-registration**  | Offering deep link → registration form → requirements → submit | Draft local cifrado; submit online.    | tenant/person derivados; no seat offline.                                                      |
| **Waitlist status**    | Position/priority explanation → offer countdown                | Cache STALE clearly marked.            | Accept requiere online + server time.                                                          |
| **Accept seat offer**  | Offer detail → accept → conditions                             | No offline mutation.                   | Idempotency-Key + biometría/device auth opcional como convenience, no sustituto IAM assurance. |
| **Pre-enrollment**     | Checklist requirements + docs links + clearance state          | Read cache; document upload via CT-05. | READY server-authoritative.                                                                    |
| **Enrollment status**  | Enrollment card + edition/cohort refs + history summary        | Cache read.                            | No void/transfer approval admin.                                                               |
| **Withdrawal request** | Reason form + confirmation                                     | Draft offline; submit online.          | Apply no; solo request.                                                                        |
| **Push/deep links**    | Invitation, waitlist offer, requirement due, enrollment update | Push no SoT.                           | Deep link revalidates auth/tenant/resource.                                                    |

## 20.1 Seguridad y offline

- No persistir invitation plaintext tokens más allá de secure transient storage; deep link token se canjea por session-bound flow.

- Cache local no contiene PII innecesaria; usar secure storage para auth credentials según IAM, no AsyncStorage simple.

- Offline states muestran “última sincronización”; nunca aceptan seat, crean enrollment o confirman clearance sin red.

- Push payload minimizada; no incluir documentos, datos sensibles ni decisión financiera.

- Device compromised/rooted policy puede exigir step-up o bloquear operaciones de alto riesgo según IAM.

# 21. Matriz Frontend / Backend / Mobile

| **Capacidad**                | **Web**             | **Backend**               | **Mobile**              |
|------------------------------|---------------------|---------------------------|-------------------------|
| **Prospect intake**          | Completo            | Commands/queries          | No                      |
| **Participant 360**          | Completo según role | Projection/authorization  | Solo self summary       |
| **Registration create/edit** | Completo            | Aggregate + validation    | Self-service            |
| **Eligibility/requirements** | Review/admin        | Ports/receipts/policies   | Status/action permitido |
| **Capacity management**      | Completo            | Locks/counters/adjustment | No admin                |
| **Waitlist**                 | Console             | Promotion/offer/seat      | Self status/accept      |
| **PreEnrollment**            | Desk                | Aggregate/conditions      | Checklist               |
| **Enrollment create/admin**  | Completo            | Transactional command     | Read self               |
| **Transfer approval/apply**  | Completo            | Workflow/transaction      | Request only            |
| **Withdrawal**               | Completo            | Workflow/apply            | Request only            |
| **Batch import**             | Completo            | 202 workers               | No                      |
| **Reconciliation**           | Completo Ops        | Status/reconcile          | No                      |
| **Audit/evidence**           | Completo read-only  | Receipts/history          | Self limited            |

# 22. Seguridad: RBAC, ABAC, SoD, step-up y privacy

## 22.1 Roles baseline

| **Rol**                    | **Responsabilidades**                                | **No puede**                       |
|----------------------------|------------------------------------------------------|------------------------------------|
| **EC_PROSPECT_AGENT**      | Prospect intake/qualify/convert según scope          | Void enrollment, adjust capacity.  |
| **EC_REGISTRATION_AGENT**  | Create/edit/submit registration, manage requirements | Approve own high-risk waiver.      |
| **EC_ADMISSION_REVIEWER**  | Review requirements/eligibility/waivers              | Change finance/payment truth.      |
| **EC_CAPACITY_MANAGER**    | Pools, adjustments, waitlist ops                     | Alter Person/eligibility decision. |
| **EC_ENROLLMENT_MANAGER**  | Create/suspend/transfer/withdraw enrollment          | Void sin governance/step-up.       |
| **EC_CORPORATE_INTAKE**    | Batch/invitations against EC-09 refs                 | See unrelated participants.        |
| **EC_DATA_STEWARD**        | CT-16 migration/dry-run                              | Bypass domain with SQL.            |
| **EC_AUDITOR**             | Read audit/evidence/history                          | Mutate business data.              |
| **EC_PARTICIPANT**         | Own registration/waitlist/enrollment                 | View others/admin capacity.        |
| **EC_ACADEMIC_GOVERNANCE** | Void/restrictions/high-risk approvals                | Bypass evidence/audit.             |

## 22.2 ABAC baseline

- tenantId del SecurityContext debe coincidir con resource tenant por RLS y authorization.

- scope membership CT-01 determina offerings/participants operables por staff.

- self participant access exige subject/person linkage verificado; no confiar participantId del path únicamente.

- corporate intake se restringe a corporate_enrollment_batch_ref autorizado por EC-09 y campos permitidos.

- purpose_code y field classification condicionan acceso a refs de persona/documentos.

- resource state + assurance level condicionan actions de void/overbook/transfer.

## 22.3 Separation of Duties y step-up

| **Operación**                    | **Inicia**                    | **Aprueba/aplica**                  | **Step-up/evidencia** |
|----------------------------------|-------------------------------|-------------------------------------|-----------------------|
| **Capacity overbook sensible**   | Capacity Manager              | Approver/Governance según threshold | Sí + reason/evidence. |
| **Waiver mandatory requirement** | Registration Agent/Reviewer   | Actor distinto si policy            | Según riesgo.         |
| **Enrollment VOID**              | Enrollment Manager/Governance | Academic Governance                 | Obligatorio.          |
| **Transfer cross-scope**         | Participant/Agent             | Destination/source authority        | Policy + evidence.    |
| **Bulk import high volume**      | Data Steward                  | Data owner/ops approval             | Según threshold.      |
| **Participant restriction**      | Authorized staff              | Governance if severe                | Reason + evidence.    |

## 22.4 Threat Model

| **Amenaza**                    | **Escenario**                                                | **Mitigación verificable**                                           |
|--------------------------------|--------------------------------------------------------------|----------------------------------------------------------------------|
| **IDOR/cross-tenant**          | Cambiar registrationId/participantId para leer otro tenant.  | RLS FORCE + ABAC + opaque IDs + negative tests.                      |
| **Mass assignment**            | Enviar status/tenant/counters/participant refs no editables. | Generated DTO allowlist; domain commands; no entity binding.         |
| **Seat race/oversubscription** | Requests concurrentes último cupo.                           | Pool row lock + counters CHECK + integration load tests.             |
| **Waitlist manipulation**      | Cambiar score/rank/clock.                                    | Server policy, fields no client-set, audit/evidence.                 |
| **Invitation theft/replay**    | Token filtrado o reutilizado.                                | Hash-only, expiry, one-shot, rate-limit, bind to auth when possible. |
| **Duplicate enrollment**       | Retry/browser double click/webhook.                          | Idempotency + unique registration/seat + transaction.                |
| **Identity spoof**             | personRef arbitrario.                                        | CT-04 resolution/assurance + subject binding.                        |
| **PII leakage**                | Logs/read models/export contienen datos excesivos.           | Minimization, redaction, field-level auth, audit export.             |
| **Privilege escalation**       | Agent llama void/adjust endpoints.                           | RBAC/ABAC/SoD + step-up + server-side reason validation.             |
| **UNKNOWN_EFFECT replay**      | Timeout remoto y retry duplica effect.                       | Durable receipt + reconcile-before-retry.                            |
| **Batch poisoning**            | CSV/file con payloads extremos/ambiguous identities.         | CT-16 staging, limits, schema validation, per-item quarantine.       |
| **GraphQL/REST enumeration**   | High-cardinality search of participants.                     | Rate limit, scope filters, minimum search criteria, audit.           |

## 22.5 Secure SDLC

- SAST y secret scanning en cada PR; High/Critical bloquea merge salvo waiver formal.

- SCA/license/dependency policy; SBOM por release.

- Container image scan y base image policy.

- DAST/API authorization tests para IDOR, mass assignment y rate limit.

- Flyway static review + destructive-change detector.

- RLS negative suite con runtime role real.

- Threat model revisado si cambia identity, capacity, corporate o finance contracts.

- No secrets/tokens/PII en logs/traces/fixtures.

# 23. Auditoría, Evidence Pack, lineage y reason codes

Toda operación crítica registra tenant, actor/subject, scope, timestamp UTC, action, resource, before/after cuando aplique, reasonCode, correlationId, policy version refs, assurance/step-up, evidence refs e idempotency key hash/ref. CT-10 puede conservar audit master; EC-04 conserva metadata de negocio necesaria y refs.

| **Hecho**                        | **Evidencia mínima**                                                                         |
|----------------------------------|----------------------------------------------------------------------------------------------|
| **Prospect conversion**          | prospect id, person/participant refs, actor, purpose, correlation.                           |
| **Registration submit**          | snapshot hash, offering/program refs, policy refs, ETag.                                     |
| **Eligibility/identity**         | receipt ids, decision/assurance, input hash, decidedAt.                                      |
| **Capacity adjustment**          | before/after, reason, workflow/evidence, actor.                                              |
| **Seat reserve/consume/release** | pool counters before/after, registration, lease, correlation.                                |
| **Waitlist promotion**           | policy version, candidate ordering inputs, seat/offer refs.                                  |
| **Enrollment create**            | registration/pre/seat refs, program/offering pins, evidence/clearance refs, policy snapshot. |
| **Transfer**                     | source/destination enrollments, pools/seats, approvals, reasons.                             |
| **Withdrawal/void**              | before/after status, reason, assurance, financial followup ref.                              |
| **Batch promotion**              | source batch/item key, normalized hash, created refs, per-item result.                       |
| **Reconciliation**               | remote op ref, prior UNKNOWN, observed terminal, evidence.                                   |

## 23.1 Reason codes baseline

| **Área**         | **Reason codes ejemplo**                                            |
|------------------|---------------------------------------------------------------------|
| **Identity**     | IDENTITY_NOT_VERIFIED · IDENTITY_REVIEW_REQUIRED · PERSON_AMBIGUOUS |
| **Eligibility**  | ELIGIBILITY_FAILED · ELIGIBILITY_CONDITIONAL · ELIGIBILITY_UNKNOWN  |
| **Capacity**     | CAPACITY_FULL · CAPACITY_FROZEN · OVERBOOK_APPROVED                 |
| **Waitlist**     | WAITLIST_DISABLED · OFFER_EXPIRED · WAITLIST_REMOVED                |
| **Requirements** | DOCUMENT_MISSING · CONSENT_REQUIRED · WAIVER_APPROVED               |
| **Enrollment**   | ENROLLMENT_ALREADY_EXISTS · PRE_ENROLLMENT_EXPIRED · SEAT_NOT_HELD  |
| **Transfer**     | DESTINATION_FULL · TRANSFER_NOT_ALLOWED · TRANSFER_APPLIED          |
| **Withdrawal**   | PARTICIPANT_REQUEST · INSTITUTION_CANCELLED · COMPLIANCE_VOID       |
| **Integration**  | DEPENDENCY_UNAVAILABLE · REMOTE_UNKNOWN_EFFECT · CONTRACT_INVALID   |

# 24. Observabilidad: logs, metrics, traces, SLI/SLO y performance

Logs son estructurados y correlacionables; traces propagan W3C trace context/correlation; business metrics no incluyen PII. Business rejection se diferencia de operational failure: CAPACITY_FULL o ELIGIBILITY_FAILED no cuentan como 5xx availability failure.

## 24.1 Métricas mínimas

| **Métrica**                            | **Tipo**        | **Semántica**                                     |
|----------------------------------------|-----------------|---------------------------------------------------|
| **ec04_registration_created_total**    | Counter         | Registrations por channel/offering/state inicial. |
| **ec04_registration_transition_total** | Counter         | Transitions + reason.                             |
| **ec04_capacity_reserved**             | Gauge           | reserved por pool.                                |
| **ec04_capacity_enrolled**             | Gauge           | enrolled por pool.                                |
| **ec04_capacity_available**            | Gauge           | computed capacity available; UNLIMITED separate.  |
| **ec04_waitlist_active**               | Gauge           | active/offered entries.                           |
| **ec04_waitlist_offer_accept_total**   | Counter         | accepted/expired/cancelled.                       |
| **ec04_enrollment_created_total**      | Counter         | Enrollments creados.                              |
| **ec04_enrollment_transfer_total**     | Counter         | transfer outcomes.                                |
| **ec04_enrollment_withdrawal_total**   | Counter         | withdraw/cancel/void.                             |
| **ec04_idempotency_replay_total**      | Counter         | same-key replays.                                 |
| **ec04_outbox_oldest_age_seconds**     | Gauge           | Oldest undelivered.                               |
| **ec04_unknown_effect_age_seconds**    | Histogram/Gauge | Edad de receipts UNKNOWN.                         |
| **ec04_rls_denial_total**              | Counter         | Tenant isolation denials.                         |
| **ec04_dependency_availability**       | Gauge           | CT/EC/Finance logical health.                     |

## 24.2 SLI/SLO baseline

| **SLI**                              | **SLO inicial**                   | **Medición/exclusiones**                                        |
|--------------------------------------|-----------------------------------|-----------------------------------------------------------------|
| **Registration submit availability** | 99.9% mensual                     | Business 4xx excluidos; dependency critical failures incluidos. |
| **Registration submit p95**          | \< 800 ms sin remote long-running | 202 permitido para remote validation cuando contract lo define. |
| **Seat reservation p95**             | \< 350 ms                         | Bajo contención normal; capacity full es business result.       |
| **Enrollment creation p95**          | \< 700 ms sin remote calls inline | Remote prerequisites pre-resolved/revalidated.                  |
| **Waitlist promotion p95**           | \< 500 ms/candidate               | Excluye notification async.                                     |
| **Outbox delivery**                  | 99.9% \< 2 min                    | occurredAt→delivered.                                           |
| **UNKNOWN_EFFECT resolution**        | 95% \< 15 min / 99% \< 4h         | Dependiente query-status externo.                               |
| **Tenant isolation**                 | 100%                              | Leak = Sev-1.                                                   |
| **Capacity correctness**             | 100%                              | No oversubscription/counter-negative in stress suite.           |

## 24.3 Capacity/performance budgets

| **Recurso**                   | **Baseline parametrizable** | **Respuesta al exceso**              |
|-------------------------------|-----------------------------|--------------------------------------|
| **pageSize**                  | 100 máximo                  | 400/422 si supera contrato.          |
| **Batch items síncronos**     | \<= 1000                    | Mayor =\> 202/chunking.              |
| **Batch total**               | 100.000 baseline            | Policy puede reducir; 202 mandatory. |
| **Requirements/registration** | 200                         | 422\.                                |
| **Waitlist promotion chunk**  | 100 candidates              | 202 para bulk; fairness por pool.    |
| **Invitation issuance bulk**  | 10.000/operation            | 202 + rate policy.                   |
| **Payload JSON**              | 1 MiB baseline              | 413\.                                |
| **Search participant**        | Minimum criteria/pagination | 429/400 para enumeration patterns.   |

# 25. IA aplicada al módulo

Toda IA pasa por CT-12. AI_RECOMMENDATION ≠ ADMISSION DECISION. La IA nunca crea Enrollment, marca requirement satisfecho, cambia waitlist priority oficial, fusiona Person, aprueba waiver, ajusta capacity ni interpreta payment como clearance.

| **Caso permitido**                                    | **Grounding**                            | **Output**                         | **Control humano/policy**                    |
|-------------------------------------------------------|------------------------------------------|------------------------------------|----------------------------------------------|
| **Triage de prospectos**                              | Prospect metadata minimizada + offerings | Sugerencia de offering/next action | Agent confirma; no crea person/enrollment.   |
| **Detectar posible duplicado**                        | CT-04 candidate refs autorizados         | Lista de candidatos/confidence     | CT-04/humano resuelve; no merge automático.  |
| **Explicar requirements**                             | Policy/requirements oficiales            | Resumen en lenguaje simple         | No cambia state.                             |
| **Predecir probabilidad no-show/waitlist acceptance** | Datos agregados autorizados CT-11        | Risk/probability signal            | No altera priority ni reserva seat.          |
| **Sugerir respuesta a participante**                  | Status/ProblemDetail/FAQ autorizada      | Draft comunicación                 | Humano/CT-07 revisa según canal.             |
| **Detectar anomalías de capacity**                    | Counters/events agregados                | Señal de mismatch/fraude           | Ops verifica y usa repair command gobernado. |

## 25.1 Provenance obligatorio

Toda sugerencia aceptada conserva ai_run_ref, model_ref, prompt/template_ref, eval_ref, grounding_refs, confidence cuando aplique, reviewer_subject_ref, reviewer_outcome y target command. Los datos enviados a CT-12 siguen purpose limitation/minimization.

| **LÍMITE —** Un modelo puede recomendar “contactar a esta persona” o “revisar este caso”; no puede decidir “matricular”, “rechazar por sí solo”, “subir prioridad” o “fusionar identidad”. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 26. Analítica y KPI

CT-11 es Source of Truth de datasets/BI. EC-04 publica hechos semánticos y medidas; dashboards no hacen joins OLTP cross-context. Los KPI de funnel distinguen NO_DATA, cohort size y denominadores explícitos.

| **KPI**                              | **Definición**                                                             |
|--------------------------------------|----------------------------------------------------------------------------|
| **Prospect→Registration conversion** | Registrations originadas / prospects qualified por source/offering.        |
| **Registration submit rate**         | SUBMITTED / DRAFT created.                                                 |
| **Eligibility pass rate**            | ELIGIBLE decisions / evaluated.                                            |
| **Requirement completion time**      | Tiempo submit→all mandatory satisfied.                                     |
| **Capacity fill rate**               | current_enrolled / hard_capacity para FIXED.                               |
| **Seat hold expiry rate**            | EXPIRED reservations / HELD created.                                       |
| **Waitlist size**                    | ACTIVE+OFFERED por pool.                                                   |
| **Waitlist conversion**              | accepted/enrolled from waitlist / entries.                                 |
| **Waitlist offer acceptance time**   | issued→accepted p50/p95.                                                   |
| **Enrollment conversion**            | Enrollments / eligible registrations.                                      |
| **Time to enroll**                   | registration created→enrolled p50/p95.                                     |
| **Transfer rate**                    | APPLIED transfers / active enrollments.                                    |
| **Withdrawal rate**                  | WITHDRAWN/CANCELLED / enrollments; cohort/program segment.                 |
| **Corporate batch success**          | Succeeded items / total by EC-09 batch.                                    |
| **Identity ambiguity rate**          | Items/person resolution requiring manual review.                           |
| **UNKNOWN_EFFECT backlog**           | Count/age by dependency.                                                   |
| **Counter reconciliation variance**  | Expected vs stored capacity counters; target 0.                            |
| **Self-service completion**          | Enrollments completed without staff mutation / self-started registrations. |

# 27. Migración legacy y Data Quality con CT-16

Legacy entra por CT-16: Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → receipt → Reconcile → Certify. Se prohíbe INSERT directo a tablas EC-04 porque saltaría identity resolution, capacity counters, history, RLS, idempotency y eventos.

| **Objeto legacy**              | **Transformación**                                      | **Validaciones críticas**                                   |
|--------------------------------|---------------------------------------------------------|-------------------------------------------------------------|
| **Personas/alumnos de cursos** | Resolver Person CT-04; luego ParticipantProfile.        | Dedup/ambiguity; nunca crear person por fuzzy guess.        |
| **Inscripciones históricas**   | Map registration/enrollment según evidencia disponible. | Offering/program version pin o legacy provenance explícito. |
| **Cupos**                      | Crear CapacityPool y counters reconciliados.            | enrolled\<=capacity+approved overbook; evidence.            |
| **Waitlists activas**          | Map entry con enqueuedAt/priority provenance.           | No inventar orden si no existe; policy/legacy reason.       |
| **Pagos vinculados**           | Solo financial refs/receipts.                           | Finance continúa SoT; no import ledger en EC-04.            |
| **Documentos**                 | Crear CT-05 refs/bindings.                              | Hash/evidence/retention governance.                         |
| **Corporate rosters**          | Resolver EC-09 batch + participants individuales.       | Empresa no se convierte en Participant.                     |

## 27.1 Data quality rules

- Person ambiguous → FAIL/REVIEW; no auto-merge.

- Duplicate active registration same participant/offering → reconcile, no second active row.

- Enrollment without resolvable offering/program version → quarantine or legacy-certified exception with reason/evidence.

- Capacity counters rebuilt from authoritative reservations/enrollments before certify.

- Terminal enrollment status requires history/effective date or migration exception record.

- Missing source timestamps remain NULL/legacy-unknown; no inventar now().

- Every promoted item stores sourceSystem/sourceBatch/sourceKey, raw/transformed hash, mapping version, validation result, command idempotency and created refs.

# 28. QA y estrategia de pruebas

EC-04 exige pruebas de dominio, PostgreSQL real y concurrencia. No basta con tests REST. La combinación identity + capacity + retries + state machine es de alto riesgo y debe probarse con suites negativas y fault injection.

| **Nivel**                | **Cobertura obligatoria**                                            | **Evidencia**                               |
|--------------------------|----------------------------------------------------------------------|---------------------------------------------|
| **Unit/Domain**          | States, policies, priority ordering, transfer/withdraw semantics.    | JUnit 5/property-based where useful.        |
| **Repository**           | Constraints, FKs, partial indexes, append-only, history triggers.    | Testcontainers PostgreSQL.                  |
| **RLS**                  | SELECT/INSERT/UPDATE cross-tenant with runtime role.                 | Negative integration suite.                 |
| **Aggregate Revision**   | Requirement/receipt mutation bump; stale If-Match 412.               | Concurrent integration tests.               |
| **Capacity concurrency** | Last seat, hold expiry, consume/release, overbook.                   | Parallel stress tests + counter assertions. |
| **Waitlist fairness**    | Stable ordering, concurrent promotion, offer expiry/retry.           | Deterministic fixtures.                     |
| **Idempotency**          | Replay, key conflict, crash/lease recovery.                          | Integration + process restart simulation.   |
| **Outbox/Inbox**         | Atomicity, SKIP LOCKED, duplicate delivery, lease reclaim.           | Worker tests.                               |
| **API Contract**         | OpenAPI, ProblemDetail, pagination, ETag, 202.                       | Generated client/contract suite.            |
| **Event Contract**       | Payload minimal, schema compatibility.                               | AsyncAPI/schema tests.                      |
| **Security**             | IDOR, ABAC, SoD, step-up, token replay, mass assignment.             | Security suite/DAST.                        |
| **Resilience**           | CT/EC/Finance timeouts, stale reads, UNKNOWN_EFFECT.                 | Fault injection/WireMock.                   |
| **Performance**          | Registration list, seat reserve, enrollment, batch workers.          | k6/Gatling baseline.                        |
| **Migration**            | Ambiguous person, duplicate enrollment, capacity rebuild.            | CT-16 fixtures.                             |
| **E2E Web**              | Self/staff registration → waitlist → enrollment → transfer/withdraw. | Playwright.                                 |
| **Mobile**               | Self registration, waitlist accept, offline states.                  | RN tests/E2E.                               |
| **AI Evals**             | No autonomous admission/priority/identity merge.                     | CT-12 eval suite.                           |

## 28.1 Pruebas físicas no negociables

- Runtime role hace SELECT sin tenant predicate: RLS impide filas de otro tenant.

- INSERT con tenant distinto al SET LOCAL: WITH CHECK bloquea.

- Dos requests último cupo: solo una SeatReservation HELD; counters consistentes.

- HELD→CONSUMED: reserved-- y enrolled++ exactamente una vez.

- Replay expire/release seat: no counter negativo.

- Capacity FIXED shrink por debajo de occupancy: command/constraint rechaza.

- Dos active registrations mismo participant/offering: unique partial bloquea.

- Dos enrollments misma registration o mismo seat: unique bloquea.

- Modificar EnrollmentStatusHistory/EligibilityReceipt: append-only trigger bloquea.

- WaitlistOffer ISSUED sin seatReservation: trigger bloquea.

- Stale Registration ETag después de requirement result: 412.

- Invitation token plaintext no aparece en DB/log/traces.

- Same Idempotency-Key different payload: 409.

- Dos outbox workers claim mismo event: SKIP LOCKED evita ownership doble.

- Finance timeout después de aplicar: receipt UNKNOWN_EFFECT; no second remote call hasta reconcile.

- Transfer lock order concurrente no deadlock persistente; retries acotados.

- Withdrawal libera enrolled counter una sola vez y conserva history.

| **GATE QA —** Flyway debe ejecutar desde cero y como upgrade N-1. Las pruebas de RLS, último cupo, duplicate enrollment, append-only e UNKNOWN_EFFECT son release blockers; no se aceptan como “pendientes de hardening”. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 29. Golden Scenarios

Los Golden Scenarios constituyen criterios ejecutables de aceptación end-to-end de EC-04. Cada escenario debe poder vincularse a pruebas automáticas, evidencia observacional y un Gate. La cobertura combina negocio, integridad física, concurrencia, multi-tenant, idempotencia, resiliencia, seguridad, Mobile, migración, IA y reconciliación.

| **GS**      | **Escenario**                                  | **Precondición**                                                           | **Acción**                                               | **Resultado esperado**                                                                   | **Evidencia**                            |
|-------------|------------------------------------------------|----------------------------------------------------------------------------|----------------------------------------------------------|------------------------------------------------------------------------------------------|------------------------------------------|
| GS-EC04-001 | Crear ParticipantProfile desde Person canónica | Person ref resoluble CT-04; tenant/scope autorizado.                       | Crear rol participante EC.                               | ParticipantProfile único; sin copiar PII; audit registrado.                              | DB row + audit + contract trace.         |
| GS-EC04-002 | Reintentar creación de ParticipantProfile      | Misma person_ref y mismo tenant.                                           | Repetir comando con misma Idempotency-Key.               | Mismo resultado; no segundo perfil.                                                      | Idempotency replay + unique evidence.    |
| GS-EC04-003 | Bloquear perfil duplicado por persona          | Perfil ya existe.                                                          | Crear con key nueva.                                     | 409 PARTICIPANT_PROFILE_ALREADY_EXISTS.                                                  | ProblemDetail + UQ violation translated. |
| GS-EC04-004 | Prospect sin Person todavía                    | Prospecto captado con datos mínimos tokenizados/referenciados.             | Crear ProspectCase.                                      | ProspectCase existe sin inventar Person; lifecycle separado.                             | DB + audit.                              |
| GS-EC04-005 | Resolver Prospect hacia Person existente       | Prospect en QUALIFIED; CT-04 devuelve match confiable.                     | Vincular person_ref y convertir.                         | No se crea persona duplicada; lineage conserva prospect.                                 | CT-04 receipt + audit.                   |
| GS-EC04-006 | Identity resolution ambigua                    | CT-04 devuelve múltiples candidatos.                                       | Intentar conversión automática.                          | Queda NEEDS_REVIEW; no merge automático.                                                 | Reason code + evidence.                  |
| GS-EC04-007 | Invitation válida                              | Offering abierta y token vigente.                                          | Canjear invitation.                                      | Registration draft creada una vez; token marcado redeemed.                               | Invitation receipt + registration id.    |
| GS-EC04-008 | Invitation expirada                            | expires_at pasado.                                                         | Canjear token.                                           | 422 INVITATION_EXPIRED; no Registration.                                                 | Audit + no side effects.                 |
| GS-EC04-009 | Invitation token replay                        | Token ya redeemido.                                                        | Segundo canje.                                           | Replay idempotente o 409 según contract, nunca segunda registration.                     | Token hash lookup + audit.               |
| GS-EC04-010 | Registration individual happy path             | Participant + Offering válidos.                                            | Crear draft, completar requirements y submit.            | SUBMITTED con snapshot/receipts; sin enrollment todavía.                                 | Registration + requirements + audit.     |
| GS-EC04-011 | Registro duplicado activo                      | Misma person/participant + offering con registration activa.               | Crear otra registration.                                 | 409 DUPLICATE_ACTIVE_REGISTRATION.                                                       | Partial unique index evidence.           |
| GS-EC04-012 | Registration cancelable                        | DRAFT/SUBMITTED según policy.                                              | Cancelar con reason.                                     | CANCELLED; libera seat si existía; historia intacta.                                     | State history/audit + capacity counters. |
| GS-EC04-013 | Cancelación tardía no permitida                | Enrollment ya ACTIVE.                                                      | Cancelar Registration directamente.                      | 422 INVALID_STATE; usar Withdrawal.                                                      | ProblemDetail.                           |
| GS-EC04-014 | Requirement obligatorio faltante               | Registration SUBMITTED; requirement mandatory PENDING.                     | Intentar PRE_ENROLL.                                     | 422 REQUIREMENT_NOT_SATISFIED.                                                           | Requirement result + ProblemDetail.      |
| GS-EC04-015 | Documento requerido validado                   | CT-05 document_ref válido y policy aplica.                                 | Marcar requirement satisfied vía decisión autorizada.    | Result append-only + root revision bump.                                                 | Receipt + ETag new.                      |
| GS-EC04-016 | Documento unavailable                          | CT-05 no responde.                                                         | Preflight/submit dependiente.                            | PARTIAL/UNAVAILABLE; no se interpreta como satisfied.                                    | Trace + UI state.                        |
| GS-EC04-017 | Eligibility eligible                           | CT-15 devuelve ELIGIBLE pinneado a policy version.                         | Aplicar decisión.                                        | Receipt append-only; registration puede progresar.                                       | Eligibility receipt + policy version.    |
| GS-EC04-018 | Eligibility ineligible                         | CT-15 devuelve INELIGIBLE.                                                 | Intentar aprobar registration.                           | Business rejection 422/decision REJECTED según workflow; no enrollment.                  | Receipt + reason.                        |
| GS-EC04-019 | Eligibility UNKNOWN                            | CT-15 no puede determinar.                                                 | Intentar auto-approve.                                   | No aprobación silenciosa; NEEDS_REVIEW.                                                  | Reason code + audit.                     |
| GS-EC04-020 | Identity assurance suficiente                  | Identity assurance receipt cumple policy.                                  | Finalizar clearance.                                     | Requirement satisfecho; receipt inmutable.                                               | Assurance receipt.                       |
| GS-EC04-021 | Identity assurance insuficiente                | Nivel actual menor a requerido.                                            | Intentar enrollment.                                     | 422 STEP_UP_OR_IDENTITY_ASSURANCE_REQUIRED.                                              | ProblemDetail + auth context.            |
| GS-EC04-022 | Último cupo, un ganador                        | capacity available=1; dos registrations elegibles.                         | Dos threads reservan simultáneamente.                    | Solo una SeatReservation HELD; contador exacto.                                          | Concurrency test + DB counters.          |
| GS-EC04-023 | Capacity full                                  | current_reserved+current_enrolled alcanza hard capacity.                   | Reserve seat.                                            | 409/422 CAPACITY_FULL; waitlist posible.                                                 | Counter query + ProblemDetail.           |
| GS-EC04-024 | Overbook permitido por policy                  | Pool permite overbook n y actor autorizado.                                | Reservar dentro del margen.                              | HELD permitida hasta límite; audit reason/policy.                                        | Capacity pool + audit.                   |
| GS-EC04-025 | Overbook excedido                              | Overbook margin consumido.                                                 | Nueva reserva.                                           | Rechazo; no contador negativo/overflow.                                                  | Constraint/lock evidence.                |
| GS-EC04-026 | Expirar SeatReservation                        | HELD vencida.                                                              | Worker expira.                                           | EXPIRED; current_reserved decrementa una vez.                                            | Reservation + counter audit.             |
| GS-EC04-027 | Replay expiración seat                         | Reservation ya EXPIRED.                                                    | Worker repite evento/comando.                            | No segundo decremento.                                                                   | Idempotency/inbox evidence.              |
| GS-EC04-028 | Consumir SeatReservation                       | HELD y enrollment precondiciones listas.                                   | Transición a CONSUMED dentro de enrollment command.      | reserved--, enrolled++; atomicidad.                                                      | Transaction trace + counters.            |
| GS-EC04-029 | Liberar seat manualmente                       | HELD, registration cancelada.                                              | Release.                                                 | RELEASED; capacity vuelve disponible.                                                    | Counter reconciliation.                  |
| GS-EC04-030 | Ajustar capacidad hacia arriba                 | Actor Capacity Manager, reason válido.                                     | Increase hard_capacity.                                  | Adjustment append-only + pool revision/counters coherentes.                              | Adjustment + audit.                      |
| GS-EC04-031 | Reducir capacidad debajo ocupación             | Enrolled+reserved supera nuevo valor.                                      | Reduce capacity.                                         | 422 CAPACITY_BELOW_COMMITTED; sin cambio.                                                | Domain/DB guard.                         |
| GS-EC04-032 | Lectura de cupos STALE                         | Read model retrasado.                                                      | Abrir console.                                           | STALE con asOf; mutation revalida DB autoritativa.                                       | UI + server trace.                       |
| GS-EC04-033 | Capacity service UNAVAILABLE                   | Dependency/read path falla.                                                | Frontend consulta.                                       | UNAVAILABLE, nunca ZERO.                                                                 | UI screenshot + telemetry.               |
| GS-EC04-034 | Entrar a waitlist                              | Capacity full y policy waitlist activa.                                    | Join waitlist.                                           | Entry ACTIVE con priority snapshot; no seat.                                             | Waitlist row + audit.                    |
| GS-EC04-035 | No duplicar waitlist activa                    | Entry ya ACTIVE same participant/offering/pool.                            | Join nuevamente.                                         | Idempotent/409 según contract; una sola entry.                                           | Unique partial index.                    |
| GS-EC04-036 | Prioridad determinista                         | Varias entries same score.                                                 | Order waitlist.                                          | Tie-break estable por policy/time/id; reproducible.                                      | Query output + policy version.           |
| GS-EC04-037 | IA no cambia prioridad                         | CT-12 sugiere riesgo/interés.                                              | Intentar usar score IA como prioridad oficial.           | Bloqueado por policy/architecture; prioridad rule-based.                                 | Code/contract test.                      |
| GS-EC04-038 | Promover waitlist al liberarse cupo            | Entry ACTIVE y seat disponible.                                            | Promote bajo lock.                                       | Seat HELD + WaitlistOffer ISSUED + entry OFFERED atomicamente.                           | DB transaction evidence.                 |
| GS-EC04-039 | Dos workers promueven mismo cupo               | Una vacancy, múltiples entries.                                            | Workers concurrentes.                                    | Un solo offer/seat; ordering preservado.                                                 | SKIP LOCKED/row lock test.               |
| GS-EC04-040 | Aceptar WaitlistOffer                          | Offer ISSUED vigente + seat HELD.                                          | Participante acepta con Idempotency-Key.                 | ACCEPTED; registration avanza; no doble seat.                                            | Offer + seat + audit.                    |
| GS-EC04-041 | Offer expirada                                 | Server expires_at pasado.                                                  | Accept desde mobile con reloj local atrasado.            | 422 WAITLIST_OFFER_EXPIRED; server time prevalece.                                       | Server trace.                            |
| GS-EC04-042 | Declinar offer                                 | ISSUED.                                                                    | Decline.                                                 | Offer DECLINED, seat RELEASED, entry terminal/next según policy.                         | State/counter evidence.                  |
| GS-EC04-043 | Push de offer no recibido                      | Offer válida pero CT-07 falla.                                             | Delivery notification falla.                             | Offer permanece vigente; fallo comunicación no revierte negocio.                         | Notification receipt + audit.            |
| GS-EC04-044 | PreEnrollment READY                            | Registration eligible + requirements satisfied + seat strategy valid.      | Create/mark pre-enrollment.                              | READY sin crear financial truth.                                                         | PreEnrollment + receipts.                |
| GS-EC04-045 | Financial condition pending                    | PreEnrollment requiere clearance financiero externo.                       | Finance status PENDING/UNAVAILABLE.                      | No ACTIVE enrollment; UI muestra estado real.                                            | Finance ref + UI evidence.               |
| GS-EC04-046 | Enrollment happy path                          | PreEnrollment READY, seat HELD, commercial/financial conditions cumplidas. | Confirm enrollment.                                      | Enrollment ACTIVE + seat CONSUMED + history + outbox en una transacción.                 | DB + outbox + audit.                     |
| GS-EC04-047 | Enrollment idempotent replay                   | Comando anterior committed pero response perdida.                          | Repetir misma key/payload.                               | Mismo enrollment/result; no doble counter.                                               | Idempotency response snapshot.           |
| GS-EC04-048 | Enrollment same registration duplicate         | Enrollment ya existe.                                                      | Crear de nuevo con nueva key.                            | 409 ENROLLMENT_ALREADY_EXISTS.                                                           | Unique constraint translated.            |
| GS-EC04-049 | Enrollment same seat duplicate                 | Seat ya asociada a enrollment.                                             | Usar en segundo enrollment.                              | DB/Domain rejection.                                                                     | Unique evidence.                         |
| GS-EC04-050 | Suspender enrollment                           | ACTIVE y policy/reason válido.                                             | Suspend.                                                 | SUSPENDED + history; cupo según policy no se libera automáticamente.                     | History + policy snapshot.               |
| GS-EC04-051 | Reactivar enrollment                           | SUSPENDED y condiciones resueltas.                                         | Reactivate.                                              | ACTIVE con nueva history record.                                                         | History/audit.                           |
| GS-EC04-052 | Withdrawal solicitado por participante         | Enrollment ACTIVE.                                                         | Mobile submit withdrawal request.                        | Request SUBMITTED; enrollment aún ACTIVE.                                                | Request + audit.                         |
| GS-EC04-053 | Withdrawal aprobado/aplicado                   | Request APPROVED, policy y financial refs reconciliados.                   | Apply withdrawal.                                        | Enrollment WITHDRAWN; current_enrolled-- una vez; history intacta.                       | Counters + history + outbox.             |
| GS-EC04-054 | Replay withdrawal apply                        | Enrollment ya WITHDRAWN.                                                   | Repetir apply.                                           | Mismo resultado/idempotent; no segundo decremento.                                       | Idempotency + counter.                   |
| GS-EC04-055 | Transfer dentro del tenant                     | Enrollment ACTIVE, destination offering compatible/capacity.               | Approve/apply transfer.                                  | Source TRANSFERRED + destination enrollment/seat bajo transacción/compensación definida. | Transfer receipt + both histories.       |
| GS-EC04-056 | Transfer sin cupo destino                      | Destination full.                                                          | Apply transfer.                                          | No se cierra source; request remains pending/rejected.                                   | Atomicity evidence.                      |
| GS-EC04-057 | Transfer cross-tenant                          | Destination pertenece a otro tenant.                                       | Intentar transfer.                                       | 403/404 + RLS; ningún efecto.                                                            | Security/RLS test.                       |
| GS-EC04-058 | VOID enrollment crítico                        | Governance + step-up + reason/evidence.                                    | Void.                                                    | VOID terminal; history append-only; downstream event.                                    | Assurance + audit.                       |
| GS-EC04-059 | Batch corporate válido                         | EC-09 batch ref autorizado con 100 participants.                           | Preflight + submit batch.                                | Operation 202; items procesados idempotentemente; summary consistente.                   | OperationStatus + batch items.           |
| GS-EC04-060 | Batch con filas inválidas                      | 10/100 no resuelven Person/requirements.                                   | Process.                                                 | PARTIAL_SUCCESS; 90 válidos, 10 errores por item, no rollback global ciego.              | Item results + export evidence.          |
| GS-EC04-061 | Batch replay                                   | Mismo batch external ref/idempotency.                                      | Reenviar.                                                | No duplicados; se recupera OperationStatus/resultado.                                    | Idempotency + UQ.                        |
| GS-EC04-062 | Empresa propone participant inexistente        | Corporate client != participant.                                           | Procesar nominated ref.                                  | Item NEEDS_IDENTITY_RESOLUTION; no Person inventada.                                     | Batch item reason.                       |
| GS-EC04-063 | Empresa intenta ver participante ajeno         | Corporate user sin vínculo autorizado.                                     | Query participant/enrollment.                            | 403/404; field privacy preservada.                                                       | ABAC test.                               |
| GS-EC04-064 | Stale Registration ETag por child mutation     | A y B leen ETag 7; A modifica requirement.                                 | B modifica registration con If-Match 7.                  | 412; root ya ETag 8.                                                                     | Aggregate revision test.                 |
| GS-EC04-065 | No last-write-wins                             | Dos agentes editan same registration.                                      | Mutaciones concurrentes stale.                           | Una commits, otra 412 con conflict UI.                                                   | HTTP trace.                              |
| GS-EC04-066 | Stale CapacityPool ETag                        | Capacity adjusted by another actor.                                        | Submit old adjustment.                                   | 412/reload; counters no pisan cambios.                                                   | ETag test.                               |
| GS-EC04-067 | Ordered locks en transfer                      | Dos transfers cruzados concurrentes.                                       | Execute.                                                 | No deadlock persistente; lock ordering/backoff.                                          | Concurrency telemetry.                   |
| GS-EC04-068 | RLS select sin filtro tenant                   | Runtime tenant A.                                                          | Repository ejecuta SELECT sin WHERE tenant.              | Solo filas A.                                                                            | Integration test with real PostgreSQL.   |
| GS-EC04-069 | RLS insert tenant B desde contexto A           | Runtime SET LOCAL A.                                                       | INSERT tenant B.                                         | RLS WITH CHECK reject.                                                                   | SQLSTATE evidence.                       |
| GS-EC04-070 | Runtime role intenta disable RLS               | HTTP runtime role.                                                         | ALTER/DISABLE/BYPASS attempt.                            | Permiso denegado; role no owner/BYPASSRLS.                                               | Role audit.                              |
| GS-EC04-071 | IDOR participant                               | Participant user A conoce participant_id B.                                | GET resource B.                                          | 403/404; no data leak.                                                                   | Security test.                           |
| GS-EC04-072 | Mass assignment tenant/person                  | Body incluye tenant_id/person_id ajeno.                                    | POST registration.                                       | Campos ignorados/rechazados; contexto server-authoritative.                              | API contract test.                       |
| GS-EC04-073 | Step-up enrollment VOID                        | Actor sin assurance requerido.                                             | Void.                                                    | 403 STEP_UP_REQUIRED; no mutation.                                                       | IAM assurance + audit.                   |
| GS-EC04-074 | SoD waiver                                     | Actor que solicitó waiver intenta autoaprobar.                             | Approve.                                                 | 403 SOD_VIOLATION cuando policy exige separación.                                        | Authorization evidence.                  |
| GS-EC04-075 | Logs sin PII/token                             | Registration con invitation token y doc refs.                              | Ejecutar E2E.                                            | Logs/traces redacted; no token/plain PII.                                                | Security log scan.                       |
| GS-EC04-076 | Consent revoked downstream                     | CT-10 informa revocación para purpose no crítico.                          | Read participant projection.                             | Campo/uso restringido según purpose; hechos legales conservados.                         | Privacy test + audit.                    |
| GS-EC04-077 | Idempotency same key same payload              | Command sensitive.                                                         | Replay.                                                  | Same status/body/resource; no side effects nuevos.                                       | Idempotency row.                         |
| GS-EC04-078 | Idempotency same key different payload         | Key ya usada.                                                              | Enviar payload distinto.                                 | 409 IDEMPOTENCY_KEY_REUSED.                                                              | ProblemDetail.                           |
| GS-EC04-079 | Idempotency lease crash recovery               | IN_PROGRESS worker muere tras acquire sin commit effect.                   | Lease vence y recovery toma ownership.                   | Una sola ejecución efectiva; audit recovery.                                             | Lease timestamps + result.               |
| GS-EC04-080 | Outbox crash después de commit                 | Enrollment committed; broker no recibió.                                   | Worker retoma PENDING.                                   | Event delivered at-least-once; negocio no se repite.                                     | Outbox + broker trace.                   |
| GS-EC04-081 | Dos outbox workers                             | Mismo backlog.                                                             | Claim simultáneo.                                        | SKIP LOCKED/lease garantiza owner único por lote.                                        | Worker ownership test.                   |
| GS-EC04-082 | Duplicate inbound event                        | Mismo message_id dos veces.                                                | Consume.                                                 | Segundo dedup; no duplicate transition.                                                  | Inbox row + metrics.                     |
| GS-EC04-083 | Same message_id different hash                 | Broker/source defect.                                                      | Consume segundo payload distinto.                        | Quarantine/conflict; no aplicar.                                                         | Inbox hash + alert.                      |
| GS-EC04-084 | Finance UNKNOWN_EFFECT                         | Remote confirmó internamente, response timeout.                            | Enrollment commercial clearance command observa timeout. | Receipt UNKNOWN_EFFECT; no retry hasta query/reconcile.                                  | Integration effect receipt.              |
| GS-EC04-085 | Reconcile Finance confirmado                   | UNKNOWN_EFFECT previo; query remote dice APPLIED.                          | Reconcile.                                               | Receipt CONFIRMED; flujo continúa sin repetir remote effect.                             | Reconciliation audit.                    |
| GS-EC04-086 | Reconcile Finance no aplicado                  | UNKNOWN_EFFECT; remote query NOT_FOUND con certeza contractual.            | Retry con misma idempotency/external ref.                | Aplicación única, receipt confirmado.                                                    | Remote idempotency evidence.             |
| GS-EC04-087 | CT-15 timeout sin efecto remoto                | Eligibility read/query timeout.                                            | Preflight.                                               | UNAVAILABLE/RETRY bounded; no asumir eligible.                                           | Circuit/trace.                           |
| GS-EC04-088 | CT-06 workflow UNKNOWN_EFFECT                  | Create review case response lost.                                          | Reconcile by idempotency/external ref.                   | No duplicate workflow.                                                                   | Workflow receipt.                        |
| GS-EC04-089 | Mobile offline registration draft              | Sin red.                                                                   | Editar draft local.                                      | Solo draft local cifrado; no official registration submit.                               | Mobile storage test.                     |
| GS-EC04-090 | Mobile reconnect submit                        | Draft offline + auth válido.                                               | Sync/submit.                                             | Server revalida eligibility/capacity; official ID from backend.                          | E2E mobile/API.                          |
| GS-EC04-091 | Mobile stale waitlist position                 | Cached data antigua.                                                       | Open screen offline.                                     | STALE visible con asOf; no falsa posición actual.                                        | UI screenshot.                           |
| GS-EC04-092 | Deep link waitlist offer                       | Push abre link.                                                            | Authenticate and open.                                   | Resource/tenant revalidado; token no concede acceso por sí solo.                         | Deep-link security test.                 |
| GS-EC04-093 | 202 batch status                               | Bulk operation aceptada.                                                   | Poll GET operation.                                      | PENDING/RUNNING/PARTIAL_SUCCESS/SUCCEEDED/FAILED terminal coherente.                     | OperationStatus trace.                   |
| GS-EC04-094 | OperationStatus UNKNOWN_EFFECT                 | Async integration effect ambiguo.                                          | Query status.                                            | UNKNOWN_EFFECT + reconcile action; no generic FAILED.                                    | API/UI evidence.                         |
| GS-EC04-095 | Legacy dry-run                                 | CT-16 normalized batch.                                                    | Dry-run promotion.                                       | No final rows; detailed mapping/conflict report.                                         | DryRunReport.                            |
| GS-EC04-096 | Legacy duplicate enrollment                    | Source contiene duplicado.                                                 | Promote.                                                 | Item rejected/reconciled; no duplicate active enrollment.                                | Migration receipt.                       |
| GS-EC04-097 | Legacy ambiguous person                        | No unique person match.                                                    | Promote.                                                 | Quarantine NEEDS_REVIEW; no auto-link.                                                   | Lineage + reason.                        |
| GS-EC04-098 | AI recommendation accepted                     | CT-12 suggests outreach/requirements explanation.                          | User accepts as draft communication/advice.              | Human action recorded with ai_run_ref; no state decision automated.                      | AI provenance.                           |
| GS-EC04-099 | AI attempts eligibility decision               | Model output says eligible.                                                | Try apply as official decision.                          | Rejected by architecture; CT-15/human governed decision required.                        | Domain test.                             |
| GS-EC04-100 | SLO alert capacity conflict spike              | Conflict rate above threshold.                                             | Alert fires.                                             | Ops receives correlation/dashboard; business rejections separated from failures.         | Alert evidence.                          |

| **COBERTURA GOLDEN —** Los 100 escenarios son baseline. Cada release puede agregar casos, pero no eliminar cobertura normativa sin ADR y evidencia de equivalencia. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 30. UAT institucional

UAT valida que EC-04 es operable por la institución, no solo técnicamente correcto. Los casos deben ejecutarse con usuarios representativos, datos de prueba multi-sede/multi-modalidad y evidencia trazable a los Gates.

| **UAT**          | **Rol**                      | **Prueba institucional**                                                     | **Aceptación**                                |
|------------------|------------------------------|------------------------------------------------------------------------------|-----------------------------------------------|
| **UAT-EC04-001** | Admisiones                   | Registrar prospect y convertirlo a participant sin duplicar Person.          | Prospect/Participant lineage correcto.        |
| **UAT-EC04-002** | Participante                 | Autoregistro individual a offering abierta.                                  | Registration SUBMITTED y checklist visible.   |
| **UAT-EC04-003** | Registration Agent           | Completar requirements faltantes.                                            | Estados/reasons/ETag coherentes.              |
| **UAT-EC04-004** | Admission Reviewer           | Resolver eligibility y waiver gobernado.                                     | Decisión auditada; SoD aplicado.              |
| **UAT-EC04-005** | Capacity Manager             | Configurar/ajustar capacity pool.                                            | Counters y límites correctos.                 |
| **UAT-EC04-006** | Participante                 | Entrar a lista de espera.                                                    | Posición/policy explicable.                   |
| **UAT-EC04-007** | Capacity Manager             | Promover waitlist al liberar cupo.                                           | Offer+seat atómicos.                          |
| **UAT-EC04-008** | Participante Mobile          | Aceptar oferta de waitlist.                                                  | Server expiry y auth revalidados.             |
| **UAT-EC04-009** | Enrollment Manager           | Generar PreEnrollment READY.                                                 | No confunde clearance con enrollment.         |
| **UAT-EC04-010** | Enrollment Manager           | Confirmar enrollment.                                                        | ACTIVE + seat consumed + history.             |
| **UAT-EC04-011** | Participante                 | Solicitar withdrawal.                                                        | Request separado del efecto académico.        |
| **UAT-EC04-012** | Governance                   | Aprobar y aplicar withdrawal.                                                | Enrollment terminal + cupo reconciliado.      |
| **UAT-EC04-013** | Enrollment Manager           | Transferir participant a otra offering compatible.                           | Source/destination consistentes.              |
| **UAT-EC04-014** | Corporate Intake             | Importar batch de 100 participantes.                                         | Partial success por item + OperationStatus.   |
| **UAT-EC04-015** | Corporate Client autorizado  | Consultar reporting/roster permitido.                                        | No exposición de participantes ajenos.        |
| **UAT-EC04-016** | Auditor                      | Reconstruir enrollment desde receipts/history/policies.                      | Historia completa sin conocimiento tribal.    |
| **UAT-EC04-017** | Ops                          | Reconciliar UNKNOWN_EFFECT financiero.                                       | No retry ciego; estado final explicable.      |
| **UAT-EC04-018** | Ops                          | Reprocesar outbox con worker caído.                                          | At-least-once sin doble efecto.               |
| **UAT-EC04-019** | Security                     | Intentar cross-tenant read/write.                                            | RLS bloquea aunque repository falle.          |
| **UAT-EC04-020** | Security                     | Probar IDOR y mass assignment.                                               | Sin leak ni cambio de tenant/person.          |
| **UAT-EC04-021** | Participante Mobile          | Trabajar draft offline y sincronizar.                                        | Draft no oficial; server revalida.            |
| **UAT-EC04-022** | Usuario Web                  | Ver NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.                   | Estados visualmente distintos.                |
| **UAT-EC04-023** | Data Steward                 | Dry-run legacy y promover lote válido.                                       | Lineage/receipts completos.                   |
| **UAT-EC04-024** | Data Steward                 | Importar person ambiguous.                                                   | Quarantine, no auto-merge.                    |
| **UAT-EC04-025** | Academic Governance          | VOID de enrollment con step-up.                                              | SoD/assurance/evidence exigidos.              |
| **UAT-EC04-026** | Registration Agent           | Resolver conflicto ETag.                                                     | 412 y rebase/reload comprensible.             |
| **UAT-EC04-027** | Capacity Manager             | Simular último cupo concurrente.                                             | Solo un ganador.                              |
| **UAT-EC04-028** | Product Owner                | Validar journeys accesibles WCAG 2.2 AA.                                     | Keyboard/focus/error announcements correctos. |
| **UAT-EC04-029** | SRE                          | Provocar caída CT-15/CT-05/Finance controlada.                               | Degradación fail-safe y alertas.              |
| **UAT-EC04-030** | Product Owner + Arquitectura | Recorrer E2E prospect-\>registration-\>waitlist/pre-enrollment-\>enrollment. | Toda frontera Source of Truth preservada.     |

# 31. Gates G1-G10

| **Gate** | **Foco**                       | **Criterio mínimo**                                                                                                    | **Evidencia obligatoria**                                       |
|----------|--------------------------------|------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------|
| **G1**   | Arquitectura y bounded context | Context map aprobado; DA/ADR; ownership EC-04 vs CT/EC-02/03/09/Finance; aggregates y state machines.                  | Architecture review + dependency rules + no cross-context FK.   |
| **G2**   | Datos y constraints            | DER físico, 27 tablas, RLS, PK/FK tenant-aware, checks, unique partial, triggers counters/history/append-only.         | Flyway apply clean + DB invariant tests + schema review.        |
| **G3**   | Backend                        | Spring Modulith boundaries, commands, Aggregate Revision, capacity locks, idempotency, repositories y domain services. | Unit/domain/integration tests + architecture tests.             |
| **G4**   | API y eventos                  | OpenAPI/AsyncAPI, DTOs, ETag, ProblemDetail, pagination, OperationStatus, event envelope versionado.                   | Contract tests + compatibility + generated client build.        |
| **G5**   | Frontend/Mobile                | Workspaces completos, estados UI, accessibility, mobile self-service con offline limitado.                             | E2E + accessibility + visual/UAT evidence.                      |
| **G6**   | Seguridad/auditoría            | RBAC/ABAC/SoD/step-up, Threat Model, privacy/purpose, RLS, audit/evidence.                                             | Security tests + SAST/SCA/secret/SBOM + audit reconstruction.   |
| **G7**   | Integraciones/resiliencia      | Timeout/retry/circuit, inbox/outbox lease, UNKNOWN_EFFECT, reconcile-before-retry, CT contracts.                       | Fault injection + duplicate messages + reconciliation evidence. |
| **G8**   | QA/UAT                         | Golden Scenarios, test pyramid, concurrency/performance, UAT sign-off.                                                 | CI evidence + defect status + institutional acceptance.         |
| **G9**   | Migración/operaciones          | CT-16 dry-run/promotion, runbooks, SLI/SLO, dashboards, expand/contract N/N-1.                                         | Migration rehearsal + incident/game-day evidence.               |
| **G10**  | Release/certificación          | DoD completo, rollback/roll-forward, evidence pack, approvals, known risks.                                            | Release checklist signed + production readiness review.         |

| **REGLA DE GATE —** Ningún Gate se aprueba por declaración. Debe existir evidencia versionada y localizable en el Engineering Pack. Un waiver es excepcional, temporal, con owner, expiración y riesgo explícito. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 32. Definition of Ready / Definition of Done

## 32.1 Definition of Ready

- Baseline EC-00/EC-01 y contratos EC-02/EC-03/CT aplicables identificados y versionados.

- Bounded Context, Source of Truth y anti-scope EC-04 acordados.

- BR y UC del slice trazables; policies/version refs conocidas.

- Datos/PII clasificados; purpose y retention definidos con CT-10.

- OpenAPI/AsyncAPI draft y consumers/producers identificados.

- Flyway/constraints/RLS diseñados antes de implementar repositories.

- Dependencias críticas declaran timeout, retry, circuit, freshness y UNKNOWN_EFFECT.

- Roles/ABAC/SoD/step-up y Threat Model del slice definidos.

- UX incluye NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.

- Acceptance/Golden Scenarios y performance budgets definidos.

- Migración legacy, si aplica, entra por CT-16 con mapping/dry-run plan.

- Feature flag/rollout strategy definida cuando el cambio introduce riesgo operacional.

## 32.2 Definition of Done

- Código compila con Java 21 y respeta boundaries Spring Modulith/Hexagonal.

- Flyway ejecuta desde cero y desde N-1; rollback de app N-1 es viable con schema expandido.

- RLS ENABLE+FORCE y roles DB probados con casos negativos cross-tenant.

- Invariantes físicas, Aggregate Revision, state transitions, counters y append-only cubiertos en PostgreSQL real.

- OpenAPI/AsyncAPI sincronizados con implementación y generated client; compatibility gates verdes.

- Idempotency durable, outbox/inbox y recovery/lease ensayados.

- UNKNOWN_EFFECT/reconciliation probado para writes remotos críticos.

- Frontend/Mobile cumplen journeys, estados de servicio, responsive y WCAG 2.2 AA aplicable.

- RBAC/ABAC/SoD/step-up, privacy, audit y evidence pack verificados.

- Unit/domain/repository/integration/contract/security/concurrency/resilience/performance/E2E/UAT verdes.

- SAST/SCA/secret/container scans y SBOM sin High/Critical no aceptados.

- SLI/SLO, dashboards, alerts y runbooks probados en game-day.

- Migración CT-16 certificada o marcada N/A con justificación.

- ADRs actualizados; decisiones abiertas no bloqueantes con owner/date.

- G1-G10 con evidencia; release checklist firmado y sin Sev-1/Sev-2 abiertos salvo waiver formal.

# 33. Runbooks

| **Runbook**     | **Incidente**                                         | **Secuencia operacional**                                                                                                                                        |
|-----------------|-------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **RB-EC04-001** | Capacity counter drift                                | Congelar promociones automáticas -\> calcular reserved/enrolled desde hechos -\> comparar pool -\> generar adjustment/reconciliation receipt -\> reactivar.      |
| **RB-EC04-002** | Oversubscription detectada                            | Detener nuevas reservations -\> preservar locks/evidence -\> identificar winners por commit/order -\> compensar casos inválidos según policy -\> comunicar.      |
| **RB-EC04-003** | Waitlist promotion atascada                           | Revisar pool/entry/offer leases -\> liberar offers expiradas -\> reintentar candidate selection bajo lock -\> verificar counters.                                |
| **RB-EC04-004** | Offer masiva duplicada                                | Pausar worker -\> detectar same entry/seat -\> usar unique/idempotency evidence -\> void/release duplicados no committed -\> notificar afectados si aplica.      |
| **RB-EC04-005** | Invitation token leakage                              | Revocar/expirar token hashes afectados -\> rotar delivery links -\> security/privacy incident -\> emitir nuevas invitations gobernadas.                          |
| **RB-EC04-006** | Identity resolution ambigua masiva                    | Detener auto-conversion -\> pasar items a NEEDS_REVIEW -\> revisar CT-04 matching quality -\> no merge destructivo.                                              |
| **RB-EC04-007** | Eligibility service unavailable                       | Abrir circuit -\> mantener decisions no resueltas -\> UI UNAVAILABLE/PARTIAL -\> recuperar y revalidar antes de avanzar.                                         |
| **RB-EC04-008** | CT-05 documents unavailable                           | Bloquear decisiones que dependen de evidencia -\> no marcar satisfied -\> conservar refs -\> retry read/circuit -\> reanudar.                                    |
| **RB-EC04-009** | Finance UNKNOWN_EFFECT                                | No retry ciego -\> consultar por idempotency/external ref -\> actualizar effect receipt -\> confirmar/reintentar solo con certeza.                               |
| **RB-EC04-010** | Finance outage prolongado                             | Open circuit -\> mantener clearance PENDING/UNAVAILABLE -\> evitar ACTIVE enrollment si policy lo exige -\> backlog/reconcile al recuperar.                      |
| **RB-EC04-011** | Workflow CT-06 UNKNOWN_EFFECT                         | Consultar status por workflow/idempotency -\> no crear segundo case -\> reconciliar receipt -\> escalar si no resoluble.                                         |
| **RB-EC04-012** | Outbox backlog                                        | Medir oldest age -\> revisar broker/workers -\> reclaim leases -\> aislar poison messages -\> replay gobernado -\> validar consumer lag.                         |
| **RB-EC04-013** | Inbox poison message                                  | Quarantine message -\> comparar schema/hash -\> corregir adapter/contract -\> replay una vez -\> no alterar history manualmente.                                 |
| **RB-EC04-014** | Idempotency stuck IN_PROGRESS                         | Verificar lease/owner -\> confirmar ausencia/presencia de efecto local -\> reclaim seguro -\> completar/replay response.                                         |
| **RB-EC04-015** | RLS/tenant isolation incident                         | Revocar runtime credential si corresponde -\> preservar evidence -\> ejecutar tenant impact analysis -\> corregir policy/role -\> security sign-off.             |
| **RB-EC04-016** | Enrollment created but downstream notification failed | Mantener enrollment truth -\> reintentar notification post-commit vía CT-07 -\> no rollback negocio por comunicación.                                            |
| **RB-EC04-017** | Transfer parcial/compensation                         | Inspeccionar source/destination facts -\> determinar committed boundary -\> aplicar compensating command, nunca DELETE/SQL manual -\> reconcile counters/events. |
| **RB-EC04-018** | Withdrawal counter mismatch                           | Reconstruir occupancy desde Enrollment/SeatReservation -\> verificar history -\> adjustment/reconciliation receipt -\> no editar history.                        |
| **RB-EC04-019** | Batch import stalled                                  | OperationStatus + worker lease -\> reclaim chunk -\> preservar per-item idempotency -\> reanudar sin duplicar registrations/enrollments.                         |
| **RB-EC04-020** | Mobile stale/deep-link incident                       | Invalidar cache/token cuando corresponda -\> exigir reauth -\> server revalidation -\> revisar push payload/privacy.                                             |
| **RB-EC04-021** | Mongo projection stale                                | Marcar STALE/PARTIAL -\> rebuild desde PostgreSQL/events -\> mutaciones continúan contra SoT.                                                                    |
| **RB-EC04-022** | Redis unavailable                                     | Bypass/disable cache/locks no autoritativos -\> usar PostgreSQL correctness path -\> monitor latency -\> warm after recovery.                                    |
| **RB-EC04-023** | Migration bad batch                                   | Detener promotion -\> identificar rows por receipts/lineage -\> compensar/void mediante domain -\> corregir mapping -\> nuevo dry-run.                           |
| **RB-EC04-024** | Schema rollout failure                                | Detener rollout -\> mantener expand schema -\> rollback app N-1 -\> forward-fix migration; no down migration destructiva de historia.                            |
| **RB-EC04-025** | AI feature incident                                   | Desactivar CT-12 feature flag -\> preservar run/eval refs -\> operar manualmente -\> evaluar outputs antes de reactivar.                                         |

# 34. ADRs y decisiones abiertas

| **ADR**          | **Tema**                   | **Decisión**                                                                                                      | **Estado**             |
|------------------|----------------------------|-------------------------------------------------------------------------------------------------------------------|------------------------|
| **ADR-EC04-001** | Participant identity       | ParticipantProfile es rol EC que referencia Person CT-04; no tabla Person local.                                  | CERRADO                |
| **ADR-EC04-002** | Prospect                   | ProspectCase puede existir antes de resolución Person; prospect no equivale participante.                         | CERRADO                |
| **ADR-EC04-003** | Registration vs Enrollment | Registration procesa intención/elegibilidad; Enrollment es hecho académico separado.                              | CERRADO                |
| **ADR-EC04-004** | Capacity ownership         | EC-04 es SoT de CapacityPool/SeatReservation; EC-02 aporta Offering ref.                                          | CERRADO                |
| **ADR-EC04-005** | Waitlist ordering          | Determinista por policy versionada; IA no decide prioridad oficial.                                               | CERRADO                |
| **ADR-EC04-006** | Eligibility                | CT-15 evalúa reglas; EC-04 conserva receipt/aplica decisión de registro.                                          | CERRADO                |
| **ADR-EC04-007** | Identity assurance         | CT-04/IAM verifican identidad/assurance; EC-04 conserva receipt/ref mínima.                                       | CERRADO                |
| **ADR-EC04-008** | Documents                  | CT-05 conserva archivos; EC-04 solo bindings/refs/hash/metadata de negocio.                                       | CERRADO                |
| **ADR-EC04-009** | Financial boundary         | Payment/debt/invoice/saldo permanecen Finance; EC-04 consume clearance/effect receipts.                           | CERRADO                |
| **ADR-EC04-010** | Corporate boundary         | EC-09 posee client/agreement/batch contract; EC-04 procesa participant registration batch.                        | CERRADO                |
| **ADR-EC04-011** | Tenant isolation           | RLS ENABLE+FORCE + runtime/migrator/worker roles separados.                                                       | CERRADO                |
| **ADR-EC04-012** | Aggregate revision         | Child mutations incrementan ETag del root Registration/Capacity/Enrollment correspondiente.                       | CERRADO                |
| **ADR-EC04-013** | Capacity concurrency       | PostgreSQL row locks/counters son autoridad; Redis no decide disponibilidad.                                      | CERRADO                |
| **ADR-EC04-014** | Idempotency                | Durable PostgreSQL lease/recovery; same key/different payload conflict.                                           | CERRADO                |
| **ADR-EC04-015** | Outbox                     | Transactional outbox + SKIP LOCKED lease; at-least-once.                                                          | CERRADO                |
| **ADR-EC04-016** | Remote writes              | UNKNOWN_EFFECT + reconciliation-before-retry.                                                                     | CERRADO                |
| **ADR-EC04-017** | History                    | EnrollmentStatusHistory/receipts/adjustments append-only; no destructive update.                                  | CERRADO                |
| **ADR-EC04-018** | Mobile                     | Self-service/select journeys; operaciones administrativas críticas permanecen Web.                                | CERRADO                |
| **ADR-EC04-019** | Frontend contract          | OpenAPI-generated TypeScript client obligatorio y UI service states explícitos.                                   | CERRADO                |
| **ADR-EC04-020** | Read models                | MongoDB/Redis son derivados/no autoritativos y reconstruibles.                                                    | CERRADO                |
| **ADR-EC04-021** | Zero downtime              | Expand/contract N/N-1 para Flyway/release.                                                                        | CERRADO                |
| **ADR-EC04-022** | Waitlist fairness advanced | Lotteries/priority classes complejas requieren policy formal CT-02 y ADR adicional por institución.               | ABIERTO PARAMETRIZABLE |
| **ADR-EC04-023** | Cross-offering transfer    | Permitido solo mediante command gobernado y capacidad/eligibilidad del destino; nunca update offering_id directo. | CERRADO                |
| **ADR-EC04-024** | Seat hold duration         | No hardcode; CT-02 policy version + server time.                                                                  | CERRADO                |

# 35. Engineering Pack

El Word es la Especificación Maestra Oficial. Git materializa los contratos y evidencias ejecutables. Para certificar EC-04 deben existir, como mínimo, los siguientes artefactos:

| **Ruta**                                                 | **Contenido mínimo**                                          |
|----------------------------------------------------------|---------------------------------------------------------------|
| **/docs/ec04/README.md**                                 | Scope, bounded context, ownership, links al Word/baseline.    |
| **/docs/ec04/business-rules.md**                         | BR-EC04 trazables a tests y endpoints.                        |
| **/docs/ec04/state-machines.md**                         | Registration/Seat/Waitlist/PreEnrollment/Enrollment/requests. |
| **/openapi/ec04-registration-v1.yaml**                   | REST completo, DTOs, ProblemDetail, ETag, OperationStatus.    |
| **/asyncapi/ec04-events-v1.yaml**                        | Domain/integration events y envelopes.                        |
| **/db/migration/ec04/V1\_\_registration_enrollment.sql** | DDL inicial Flyway Ready.                                     |
| **/db/migration/ec04/V2\_\_\*.sql**                      | Evoluciones expand/contract.                                  |
| **/architecture/ec04/context.mmd**                       | Context diagram source.                                       |
| **/architecture/ec04/domain.mmd**                        | Domain model source.                                          |
| **/architecture/ec04/physical.mmd**                      | DER físico source.                                            |
| **/adr/ec04/ADR-EC04-\*.md**                             | Decisiones y status.                                          |
| **/backend/ec04/...**                                    | Spring Modulith module + adapters.                            |
| **/frontend/src/features/ec04/...**                      | Registration/Capacity/Enrollment workspaces.                  |
| **/mobile/src/features/ec04/...**                        | Self-registration/waitlist/enrollment journeys.               |
| **/tests/ec04/domain**                                   | Unit/domain policy/state tests.                               |
| **/tests/ec04/repository**                               | Constraints/queries with PostgreSQL real.                     |
| **/tests/ec04/integration**                              | RLS, capacity concurrency, idempotency, outbox/inbox.         |
| **/tests/ec04/contract**                                 | OpenAPI/AsyncAPI/CT/Finance/EC-02/03/09 contracts.            |
| **/tests/ec04/security**                                 | Tenant isolation, IDOR, mass assignment, SoD/step-up/privacy. |
| **/tests/ec04/e2e**                                      | Web + Mobile end-to-end.                                      |
| **/performance/ec04/k6**                                 | Capacity/waitlist/registration/load scripts.                  |
| **/security/ec04/threat-model.md**                       | Threat Model STRIDE/abuse cases y mitigaciones.               |
| **/security/ec04/evidence**                              | SAST/SCA/SBOM/secrets/container/DAST/RLS reports.             |
| **/runbooks/ec04/RB-EC04-\*.md**                         | Runbooks operativos.                                          |
| **/observability/ec04**                                  | Dashboards, alerts, SLI/SLO definitions.                      |
| **/migration/ec04**                                      | CT-16 mappings, fixtures, dry-run/promotion receipts.         |
| **/evidence/ec04/gates**                                 | Evidence Pack G1-G10.                                         |
| **/evidence/ec04/uat**                                   | UAT sign-offs y capturas/exports.                             |

# 36. Guía secuencial Backend

9.  Paso 1 - Crear módulo Spring Modulith ec.registration con package boundaries y ArchitectureTests que impidan imports cross-context no autorizados.

10. Paso 2 - Definir Value Objects TenantId, ParticipantId, RegistrationNumber, AggregateRevision, PolicyVersionRef, ExternalRef, IdempotencyKey, SeatHoldWindow y OperationId.

11. Paso 3 - Implementar ParticipantProfile como rol EC referenciando person_ref CT-04; nunca duplicar PII canónica.

12. Paso 4 - Implementar ProspectCase e identity-resolution port hacia CT-04 con estados ambigue/needs-review explícitos.

13. Paso 5 - Implementar RegistrationInvitation con token hash, expiry, redeemed semantics y no plaintext persistence.

14. Paso 6 - Implementar Registration aggregate/state machine y comandos de intención create/edit/submit/cancel/approve/reject/waitlist/pre-enroll.

15. Paso 7 - Implementar RegistrationRequirement/Result como hijos append/history-safe con Aggregate Revision bump.

16. Paso 8 - Implementar EligibilityDecisionReceipt e IdentityAssuranceReceipt append-only.

17. Paso 9 - Implementar CapacityPool + CapacityAdjustment y reglas FIXED/OVERBOOK gobernadas por policy.

18. Paso 10 - Implementar SeatReservation state machine y locks de pool para hold/consume/release/expire.

19. Paso 11 - Implementar WaitlistEntry/WaitlistOffer con ordering determinista, server time, candidate selection y locks.

20. Paso 12 - Implementar PreEnrollment aggregate/clearance checks sin duplicar Finance/eligibility truth.

21. Paso 13 - Implementar Enrollment aggregate + immutable status history y uniqueness contra Registration/Seat.

22. Paso 14 - Implementar TransferRequest y WithdrawalRequest separados del efecto aplicado sobre Enrollment.

23. Paso 15 - Implementar DocumentBinding/ConsentBinding sin blobs/PII duplicada; ports CT-05/CT-10.

24. Paso 16 - Implementar IntegrationEffectReceipt con PENDING/CONFIRMED/FAILED/UNKNOWN_EFFECT y reconciliation metadata.

25. Paso 17 - Aplicar Flyway V1 de sección 13 en PostgreSQL limpio mediante Testcontainers.

26. Paso 18 - Configurar migrator/runtime/worker DB roles; runtime sin ownership/BYPASSRLS; ENABLE+FORCE RLS en todas las tablas tenant-owned.

27. Paso 19 - Implementar TenantTransactionInterceptor que establece SET LOCAL peopleu.tenant_id antes de cualquier repository access.

28. Paso 20 - Mapear JPA @Version en aggregate roots y aplicar Aggregate Revision Contract a mutaciones de hijos.

29. Paso 21 - Implementar repositories hexagonales; para capacidad/waitlist usar SELECT FOR UPDATE/SKIP LOCKED donde el contrato lo exige.

30. Paso 22 - Implementar CapacityService transaccional: reservar/consumir/liberar/expirar con counters físicos y reconciliación.

31. Paso 23 - Implementar WaitlistPromotionService con selección estable, lock del pool/entry y creación atómica de Offer+Seat.

32. Paso 24 - Implementar EligibilityPort CT-15, IdentityPort CT-04/IAM, DocumentPort CT-05, WorkflowPort CT-06 y PolicyPort CT-02.

33. Paso 25 - Implementar OfferingPort EC-02, CommercialPort EC-03, CorporatePort EC-09 y FinancePort sin acceder tablas ajenas.

34. Paso 26 - Definir timeout/retry/circuit/freshness por port; writes remotos con idempotency/external ref/queryStatus/reconcile.

35. Paso 27 - Implementar CommandIdempotency durable con request hash, owner/lease, response snapshot y recovery.

36. Paso 28 - Implementar transactional outbox e inbox dedup; dispatcher multi-instancia con FOR UPDATE SKIP LOCKED, lease/backoff y poison handling.

37. Paso 29 - Implementar OperationStatus para batch import, reconciliación y trabajos asíncronos; 202 siempre devuelve operationId.

38. Paso 30 - Implementar REST controllers/application services sin lógica de dominio en controllers; ProblemDetail con reason codes estables.

39. Paso 31 - Implementar ETag/If-Match para roots y child commands; mismatch 412 sin side effect.

40. Paso 32 - Publicar OpenAPI/AsyncAPI y generar contract/compatibility tests; frontend client nace de OpenAPI.

41. Paso 33 - Instrumentar structured logs, correlation/causation, traces, business metrics y redaction de tokens/PII.

42. Paso 34 - Completar unit/domain/repository/integration/RLS/concurrency/idempotency/resilience/security tests.

43. Paso 35 - Completar capacity/waitlist load tests, EXPLAIN evidence e índices; verificar budgets definidos en sección 24.

44. Paso 36 - Ensayar UNKNOWN_EFFECT, transfer compensation, outbox recovery, RLS incident y N/N-1 schema rollout.

45. Paso 37 - Preparar Evidence Pack G1-G10, Runbooks y release readiness antes de producción.

# 37. Guía secuencial Frontend

46. Paso 1 - Crear feature root src/features/ec04 y route namespace /ec/registration con lazy boundaries por workspace.

47. Paso 2 - Generar TypeScript client desde openapi/ec04-registration-v1.yaml; prohibido duplicar DTOs manualmente.

48. Paso 3 - Definir query keys incluyendo tenant/scope/resource/filtros y estrategia de invalidación por mutation/event.

49. Paso 4 - Definir zod/schema adapters solo para UI forms cuando sea necesario, sin divergir del OpenAPI contract.

50. Paso 5 - Implementar shell común con scope institucional, breadcrumbs, permissions y service-health banners.

51. Paso 6 - Construir Prospect Intake con inbox, qualification, identity-resolution state y drawers auditables.

52. Paso 7 - Construir Participant 360 usando proyección mínima autorizada, tabs de registrations/enrollments/docs/history y field privacy.

53. Paso 8 - Construir Registration Desk con filtros, saved views, KPIs freshness-aware, table y right drawer.

54. Paso 9 - Construir forms de Registration con autosave de draft, validation local no autoritativa y server errors por field/reason.

55. Paso 10 - Implementar Requirement Checklist con evidence refs, dependency states y action permissions.

56. Paso 11 - Construir Admission Review queue con decision receipts, policy version, waiver flow y SoD warnings.

57. Paso 12 - Construir Capacity & Waitlist Console con counters server-authoritative, no optimistic fake seats.

58. Paso 13 - Distinguir ZERO de UNAVAILABLE/STALE en capacity cards; mostrar asOf/provenance.

59. Paso 14 - Implementar waitlist table ordenada por server/policy; no drag-and-drop que altere prioridad.

60. Paso 15 - Implementar waitlist offer countdown usando expiresAt del servidor y tolerancia de clock skew; accept siempre revalida online.

61. Paso 16 - Construir Enrollment Control Center con roster, state/history, transfer/withdraw/void actions según permisos.

62. Paso 17 - Implementar drawers/modal de transfer y withdrawal con impact preview, reason codes y ETag.

63. Paso 18 - Construir Corporate/Batch Intake con upload/preflight, item grid, OperationStatus y export de errores.

64. Paso 19 - Construir Reconciliation Center con UNKNOWN_EFFECT, stale dependencies, counter audits, outbox/inbox status.

65. Paso 20 - Construir Audit & Evidence workspace read-only con lineage, receipts, policy refs y export CT-05.

66. Paso 21 - Implementar service-state component estándar: NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT.

67. Paso 22 - Implementar 412 conflict UX: toast/banner + compare current vs user intent + reload/reapply manual; nunca retry silencioso.

68. Paso 23 - Implementar 409/422 ProblemDetail mapper por reason code con copy accesible/accionable.

69. Paso 24 - Implementar OperationStatus UI para 202 con polling/backoff cancelable y estado terminal/UNKNOWN_EFFECT.

70. Paso 25 - Implementar RBAC/ABAC UI guards solo como UX; Backend sigue siendo autoridad.

71. Paso 26 - Implementar step-up handoff con IAM para VOID/overbook/otras acciones sensibles.

72. Paso 27 - Aplicar WCAG 2.2 AA: keyboard, focus management, ARIA live, error summary, contrast, zoom/responsive.

73. Paso 28 - Implementar React Native self-service reutilizando generated contracts: self-registration, waitlist, pre-enrollment checklist, enrollment status, withdrawal request.

74. Paso 29 - Limitar offline móvil a drafts/reads cacheados; submit/seat/enrollment requieren online server-authoritative.

75. Paso 30 - Minimizar local storage/PII; tokens en secure storage y push payloads sin datos sensibles.

76. Paso 31 - Implementar unit/component tests, MSW/contract fixtures, Playwright Web y mobile integration/E2E.

77. Paso 32 - Crear telemetry frontend: route/action latency, ProblemDetail reason, service state, correlationId sin PII.

78. Paso 33 - Validar responsive desktop/tablet/mobile, localization CT-08 y date/time institutional timezone.

79. Paso 34 - Ensayar degraded modes de CT-04/05/15/Finance y asegurar que empty states no oculten fallos.

80. Paso 35 - Cerrar UAT y visual regression evidence antes de G5/G8/G10.

# 38. Matriz de permisos

| **Capacidad**                      | **Registration Agent** | **Admission Reviewer** | **Capacity Manager** | **Enrollment Manager** | **Corporate Intake** | **Data Steward** | **Governance/Auditor** | **Participant**     |
|------------------------------------|------------------------|------------------------|----------------------|------------------------|----------------------|------------------|------------------------|---------------------|
| Ver prospectos                     | R/W                    | R                      | \-                   | \-                     | R scoped             | R                | \-                     | R own only N/A      |
| Crear/calificar prospect           | R/W                    | \-                     | \-                   | \-                     | R scoped             | \-               | \-                     | \-                  |
| Resolver identidad/vincular Person | R/W                    | R/W review             | \-                   | \-                     | R batch              | R migration      | R                      | Self limited        |
| Crear/editar Registration          | R/W                    | R                      | \-                   | R admin                | R batch              | R migration      | R                      | R/W own             |
| Submit Registration                | R/W                    | R                      | \-                   | \-                     | R batch              | \-               | R                      | R/W own             |
| Resolver requirements              | R/W                    | R/W                    | \-                   | R                      | R limited            | R migration      | R                      | Own upload/action   |
| Decidir eligibility/waiver         | \-                     | R/W                    | \-                   | \-                     | \-                   | \-               | R high-risk            | \-                  |
| Configurar CapacityPool            | R                      | R                      | R/W                  | R                      | \-                   | R migration      | R governance           | \-                  |
| Adjust/overbook capacity           | \-                     | \-                     | R/W                  | \-                     | \-                   | \-               | Approve per policy     | \-                  |
| Gestionar waitlist/promotions      | R                      | R                      | R/W                  | R                      | \-                   | \-               | R                      | R own status/accept |
| Crear PreEnrollment                | R/W                    | R                      | R capacity           | R/W                    | R batch              | R migration      | R                      | R own               |
| Confirmar Enrollment               | \-                     | R                      | R capacity           | R/W                    | R batch              | R migration      | R                      | \-                  |
| Suspender/reactivar Enrollment     | \-                     | R                      | \-                   | R/W                    | \-                   | \-               | Approve per policy     | R own               |
| Solicitar transfer/withdrawal      | R staff                | R                      | \-                   | R/W                    | \-                   | \-               | R                      | R/W own request     |
| Aprobar/aplicar transfer           | \-                     | R review               | R capacity           | R/W                    | \-                   | \-               | Approve high-risk      | \-                  |
| Aprobar/aplicar withdrawal         | \-                     | R review               | \-                   | R/W                    | \-                   | \-               | Approve high-risk      | \-                  |
| VOID Enrollment                    | \-                     | \-                     | \-                   | Initiate               | \-                   | \-               | R/W + step-up          | \-                  |
| Import batch                       | \-                     | \-                     | R capacity           | R                      | R/W                  | R/W              | R approve threshold    | \-                  |
| Reconciliar UNKNOWN_EFFECT         | \-                     | R                      | R                    | R                      | \-                   | \-               | R                      | \-                  |
| Ver audit/evidence                 | R scoped               | R scoped               | R scoped             | R scoped               | R scoped             | R                | R                      | R own limited       |

R = lectura; W = escritura. La matriz es baseline funcional. La autorización real combina RBAC + ABAC + scope CT-01 + state + purpose + assurance + SoD; ningún check de Frontend sustituye autorización Backend.

# 39. Contratos DTO Frontend

Los DTO son contratos OpenAPI; los ejemplos describen forma y semántica, no reemplazan el YAML ejecutable. tenantId y actor no aparecen como inputs libres cuando derivan del contexto autenticado.

| **DTO**                        | **Campos esenciales**                                                                                                                                                         | **Regla Frontend/Backend**                                          |
|--------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| **ParticipantProfileSummary**  | participantId, personRef, participantCode, lifecycleState, displayName? autorizado, version                                                                                   | Read projection; PII mínima y field-level authorization.            |
| **ProspectCaseResponse**       | prospectCaseId, offeringRef?, sourceCode, state, personRef?, identityResolutionStatus, createdAt, version                                                                     | No almacenar perfil completo local.                                 |
| **RegistrationResponse**       | registrationId, registrationNumber, participantId, offeringRef, state, eligibilityStatus, capacityDisposition, requirementSummary, preEnrollmentRef?, enrollmentRef?, version | ETag representa aggregate revision.                                 |
| **CreateRegistrationRequest**  | participantRef/selfContext, offeringRef, invitationToken?, sourceContext?, answers/metadata permitida                                                                         | tenant/person authority derivados y revalidados.                    |
| **RegistrationRequirementDto** | requirementId, code, kind, mandatory, status, evidenceRefs, policyVersionRef, lastDecisionAt                                                                                  | No blobs.                                                           |
| **EligibilityReceiptDto**      | receiptId, decision, reasonCodes, policyVersionRef, decidedAt, sourceRef                                                                                                      | Append-only read.                                                   |
| **CapacityPoolDto**            | capacityPoolId, offeringRef, segmentCode?, hardCapacity, overbookLimit, reserved, enrolled, available, waitlisted, state, asOf, version                                       | available se calcula server-side; ZERO != UNAVAILABLE.              |
| **SeatReservationDto**         | seatReservationId, registrationId, state, heldAt, expiresAt, consumedAt?, releasedAt?, version                                                                                | Server time authority.                                              |
| **WaitlistEntryDto**           | waitlistEntryId, registrationId, state, priorityClass, sequence/score explainable, joinedAt, currentOffer?, version                                                           | No AI priority score official.                                      |
| **WaitlistOfferDto**           | waitlistOfferId, entryId, seatReservationId, state, offeredAt, expiresAt, acceptedAt?, version                                                                                | ISSUED requiere seat.                                               |
| **PreEnrollmentDto**           | preEnrollmentId, registrationId, state, blockingConditions\[\], commercialStatus, financialStatus, requirementStatus, version                                                 | No payment facts locales.                                           |
| **EnrollmentDto**              | enrollmentId, enrollmentNumber, registrationId, offeringRef, cohortRef?, programVersionRef, status, effectiveAt, seatReservationId?, historySummary, version                  | Immutable identity; state changes via commands.                     |
| **TransferRequestDto**         | requestId, enrollmentId, targetOfferingRef, targetCohortRef?, reasonCode, state, impactPreview?, workflowRef?, version                                                        | Apply separado de request.                                          |
| **WithdrawalRequestDto**       | requestId, enrollmentId, reasonCode, requestedEffectiveDate?, state, financialEffectStatus?, workflowRef?, version                                                            | Request no cambia Enrollment hasta apply.                           |
| **RegistrationBatchResponse**  | batchId, corporateBatchRef?, state, totalItems, successCount, failureCount, operationId, createdAt                                                                            | Per-item results consultables.                                      |
| **OperationStatusDto**         | operationId, operationType, state, progress?, resultRef?, errorProblem?, unknownEffect?, startedAt, updatedAt, completedAt?                                                   | PENDING/RUNNING/SUCCEEDED/PARTIAL_SUCCESS/FAILED/UNKNOWN_EFFECT.    |
| **ProblemDetail**              | type, title, status, detail, instance, reasonCode, correlationId, violations\[\], dependency?, retryable?                                                                     | Reason codes estables, sin stack traces.                            |
| **ServiceStateMeta**           | freshnessState, asOf, provenance, partialSections\[\], dependencyStatuses\[\]                                                                                                 | UI distingue NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT. |

## 39.1 Convenciones HTTP/ETag

- GET de aggregate mutable devuelve ETag basado en aggregate revision; mutaciones requieren If-Match salvo create/idempotent commands donde no exista root previo.

- POST sensible usa Idempotency-Key; same key/same payload retorna misma respuesta observable, same key/different payload retorna 409.

- 202 Accepted siempre retorna OperationStatus location/operationId; Frontend no infiere éxito final desde 202.

- 409 representa conflicto de estado/uniqueness/idempotency key; 412 representa revisión ETag obsoleta; 422 representa regla de negocio incumplida.

- 503 se utiliza cuando dependencia crítica unavailable impide resolver el comando; reads pueden retornar 200 con PARTIAL/STALE metadata si el contrato lo permite.

- Pagination de colecciones define pageSize máximo, sorting estable y filtros permitidos; nunca retornar listas ilimitadas.

# 40. Checklist de release y certificación final

| **Área**           | **Debe estar certificado**                                                                          |
|--------------------|-----------------------------------------------------------------------------------------------------|
| **Arquitectura**   | G1 aprobado; Source of Truth/anti-scope sin contradicción; no FK/access table cross-context.        |
| **Datos**          | Flyway clean/N-1; 27 tablas/constraints/triggers/RLS revisados; no counter drift conocido.          |
| **Tenant**         | ENABLE+FORCE RLS; runtime no owner/BYPASSRLS; cross-tenant negative tests verdes.                   |
| **Concurrencia**   | Last-seat/waitlist/transfer/ETag/load tests verdes; no last-write-wins.                             |
| **Idempotencia**   | Sensitive commands tienen key durable, hash, replay, lease/recovery probados.                       |
| **Eventos**        | Outbox/inbox, schema version, correlation/causation, duplicate/poison/replay probados.              |
| **Integraciones**  | Timeout/retry/circuit/freshness/UNKNOWN_EFFECT/reconcile probados para CT/Finance.                  |
| **API**            | OpenAPI actualizado; generated client; ProblemDetail/reason codes; pagination/ETag/OperationStatus. |
| **Frontend**       | Workspaces completos; service states explícitos; 412 conflict UX; accessibility/responsive.         |
| **Mobile**         | Solo journeys permitidos; offline limitado; secure storage/push privacy/deep links validados.       |
| **Seguridad**      | RBAC/ABAC/SoD/step-up/Threat Model; SAST/SCA/secrets/container/SBOM gates verdes.                   |
| **Privacy**        | PII minimizada; no token plaintext; purpose/consent/document refs correctos; logs redacted.         |
| **Auditoría**      | Critical commands registran actor/subject/scope/reason/policy/evidence/correlation/assurance.       |
| **Observabilidad** | SLI/SLO/dashboards/alerts y business-vs-technical failure separation en producción.                 |
| **QA**             | Golden Scenarios, integration, security, resilience, performance, E2E y UAT con evidencia.          |
| **Migración**      | CT-16 dry-run/promotion/reconciliation/certification o N/A formal.                                  |
| **Operaciones**    | Runbooks game-day, on-call ownership, backup/restore dependencies, continuity refs.                 |
| **Deployment**     | Expand/contract N/N-1, readiness/liveness, rollout/canary, roll-forward y feature flags.            |
| **ADRs**           | Cerrados o abiertos no bloqueantes con owner/fecha; cambios de baseline explicitados.               |
| **Gates**          | G1-G10 aprobados con links a Evidence Pack; release sign-off institucional/técnico.                 |

| **CERTIFICACIÓN FINAL —** EC-04 no está listo para producción si alguna respuesta crítica a “qué pasa con último cupo, cross-tenant, retry, timeout, stale ETag, UNKNOWN_EFFECT o historia oficial” depende de conocimiento tribal o de una corrección manual en base de datos. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 41. Contrato FullStack no negociable de implementación

Esta sección es parte de la plantilla oficial derivada de EC-01 V1.1. EC-04 se considera implementado solo si Backend, Frontend, Mobile, Datos, QA, Seguridad y Operaciones observan simultáneamente las siguientes garantías. No son recomendaciones opcionales.

| **ID**          | **Garantía**                     | **Contrato verificable**                                                                                                    |
|-----------------|----------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| **FS-EC04-001** | Tenant server-authoritative      | tenant_id proviene de Security/TenantContext; nunca body/query libre. PostgreSQL RLS ENABLE+FORCE protege reads/writes.     |
| **FS-EC04-002** | No Person local                  | EC-04 referencia CT-04 person_ref y almacena solo rol/refs necesarios; no shadow PII catalog.                               |
| **FS-EC04-003** | Registration != Enrollment       | Ningún status de Registration crea implícitamente Enrollment sin command transaccional/precondiciones.                      |
| **FS-EC04-004** | Capacity DB-authoritative        | Disponibilidad/counters se resuelven con PostgreSQL locks/constraints; Redis/UI nunca adjudican cupo.                       |
| **FS-EC04-005** | Waitlist deterministic           | Orden/prioridad se deriva de policy versionada y facts; IA no toma la decisión oficial.                                     |
| **FS-EC04-006** | Seat lifecycle exact             | HELD/CONSUMED/RELEASED/EXPIRED actualizan counters exactamente una vez.                                                     |
| **FS-EC04-007** | Aggregate revision               | Mutación de hijo incrementa revisión del root; If-Match obsoleto devuelve 412.                                              |
| **FS-EC04-008** | Intent commands                  | PATCH no ejecuta transiciones críticas; enroll/withdraw/transfer/void/reserve/promote usan comandos explícitos.             |
| **FS-EC04-009** | Durable idempotency              | Commands sensibles persisten key+request hash+response/effect state y recovery lease.                                       |
| **FS-EC04-010** | Atomic outbox                    | Facts críticos y outbox se committean en la misma transacción; dispatcher leased SKIP LOCKED.                               |
| **FS-EC04-011** | Inbox dedup                      | message_id + payload hash evita duplicate effects y detecta same-id/different-payload.                                      |
| **FS-EC04-012** | UNKNOWN_EFFECT first-class       | Timeout de write remoto ambiguo produce receipt UNKNOWN_EFFECT y reconcile-before-retry.                                    |
| **FS-EC04-013** | Cross-context by contract        | CT/EC/Finance refs se validan por ports/contracts; no FK ni join OLTP cross-context.                                        |
| **FS-EC04-014** | History append-only              | Receipts, status history, adjustments y hechos oficiales no se corrigen con UPDATE/DELETE destructivo.                      |
| **FS-EC04-015** | Policy version pinning           | Thresholds, hold windows, eligibility/waiver/capacity rules se resuelven CT-02 y conservan version/snapshot cuando importa. |
| **FS-EC04-016** | UI service states                | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT se presentan y comportan distinto.                              |
| **FS-EC04-017** | Generated API client             | React/React Native consumen cliente/DTO generado desde OpenAPI; no contratos duplicados a mano.                             |
| **FS-EC04-018** | Mobile least privilege           | Mobile no hereda todas las capacidades administrativas Web; offline no confirma seat/enrollment.                            |
| **FS-EC04-019** | Security by enforcement          | RBAC+ABAC+SoD+step-up+purpose+RLS se validan Backend/DB; UI guards no son seguridad.                                        |
| **FS-EC04-020** | PII/token minimization           | No invitation/promo/identity token plaintext en DB/logs/traces; PII solo la mínima requerida.                               |
| **FS-EC04-021** | ProblemDetail semantics          | 400/401/403/404/409/412/422/429/503 y reason codes se usan de forma estable y testeada.                                     |
| **FS-EC04-022** | Bounded collections              | Lists paginadas, sorting estable, pageSize máximo y capacity budgets; no endpoints ilimitados.                              |
| **FS-EC04-023** | 202 observable                   | Toda operación 202 expone operationId/OperationStatus hasta terminal o UNKNOWN_EFFECT.                                      |
| **FS-EC04-024** | Secure SDLC                      | SAST/SCA/secret/container/SBOM y Threat Model forman parte del Gate, no del backlog post-release.                           |
| **FS-EC04-025** | Zero-downtime schema             | Flyway sigue expand/contract N/N-1; rollback app no depende de down migration destructiva.                                  |
| **FS-EC04-026** | Reproducible developer bootstrap | Local/Testcontainers/fixtures permiten ejecutar RLS/concurrency/idempotency/integration tests sin entorno tribal.           |
| **FS-EC04-027** | Observability by correlation     | Logs/metrics/traces/events comparten correlation/causation; negocio rechazado no se contabiliza igual que fallo técnico.    |
| **FS-EC04-028** | Migration through domain         | CT-16 promueve por API/domain commands con receipts; nunca INSERT directo a tablas finales.                                 |
| **FS-EC04-029** | AI assistive only                | CT-12 puede sugerir/clasificar/resumir; no crea eligibility/enrollment/priority oficial autónomamente.                      |
| **FS-EC04-030** | Production evidence              | G1-G10, Golden Scenarios, UAT, runbooks y evidence pack son parte del entregable de ingeniería.                             |

| **PLANTILLA DE CONTINUIDAD —** EC-05 y módulos posteriores deben preservar como piso los patrones FullStack de EC-01 V1.1 y EC-04 que sean transversales: RLS defense-in-depth, aggregate revision, idempotencia durable, leased outbox, UNKNOWN_EFFECT, contratos OpenAPI/AsyncAPI, estados UI explícitos, Secure SDLC, zero-downtime y evidence-driven Gates. Si una capacidad no aplica, el documento debe explicarlo expresamente. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
