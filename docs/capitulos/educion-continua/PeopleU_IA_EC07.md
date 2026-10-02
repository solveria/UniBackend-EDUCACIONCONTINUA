**PEOPLEU IA**

**EC-07**

**EVALUACIONES, RESULTADOS, APROBACIÓN,  
COMPLETION Y CIERRE ACADÉMICO**

**Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones**

| **Control**        | **Valor**                                                                                                      |
|--------------------|----------------------------------------------------------------------------------------------------------------|
| **Código**         | EC-07                                                                                                          |
| **Versión**        | V1.0                                                                                                           |
| **Estado**         | VIGENTE — MÓDULO FULLSTACK ENTERPRISE                                                                          |
| **Baseline**       | EC-00 V1.1 · Plantilla EC-01 V1.1 · Contratos EC-02…EC-06                                                      |
| **Vertical**       | Educación Continua / Formación Continua                                                                        |
| **Arquitectura**   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| **Stack objetivo** | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| **Contexto**       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| **Fecha base**     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS —** Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA —** EC-07 es Source of Truth de los hechos de evaluación académica, resultados, pass/fail, completion y cierre académico de Educación Continua. No es dueño de asistencia, pagos, certificados, documentos binarios, identidad de persona, agenda ni LMS. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaración de propósito, autoridad y baseline

| **V1.0 —** MÓDULO DE EVALUACIÓN Y COMPLETION ENTERPRISE — EC-07 convierte evidencia y resultados de aprendizaje en hechos académicos oficiales, reconstruibles y auditables. Diseña explícitamente reintentos, correcciones, apelaciones, reglas de aprobación, completion, cierres institucionales, concurrencia, idempotencia y reconciliación. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

EC-07 operacionaliza AM-00, CT-00, CT-01…CT-18, EC-00 V1.1 y los contratos publicados por EC-01…EC-06. Su misión es permitir que una universidad determine, con reglas versionadas y evidencia suficiente, qué evaluaciones corresponden a una edición o cohorte, qué resultado obtuvo cada participante, si aprobó académicamente, si completó el programa y cuándo puede cerrarse oficialmente la ejecución académica.

El módulo trata evaluación como un dominio de hechos oficiales, no como una planilla de notas. Un resultado publicado no se sobreescribe; se corrige mediante hechos posteriores con lineage. Una apelación no cambia una nota por sí misma; produce una decisión gobernada que, si corresponde, genera una corrección o restatement. Un cierre no es marcar terminado: exige reconciliar resultados, completion, holds, excepciones, evidencias y eventos downstream.

| **CRITERIO DE ÉXITO —** Un equipo Senior debe poder implementar evaluación, aprobación, completion y cierre sin conocimiento tribal; PostgreSQL debe impedir facts incoherentes, doble publicación, cruces de tenant, intentos imposibles y reescritura destructiva de historia aunque Backend tenga un bug. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquía documental aplicable

| **Prioridad** | **Documento/artefacto**                | **Rol**                                                          |
|---------------|----------------------------------------|------------------------------------------------------------------|
| 1             | AM-00 vigente                          | Constitución arquitectónica superior.                            |
| 2             | CT-00 vigente                          | Contrato maestro transversal.                                    |
| 3             | CT-01…CT-18 vigentes                   | Capacidades compartidas y fronteras.                             |
| 4             | EC-00 V1.1                             | Constitución funcional/arquitectónica de Educación Continua.     |
| 5             | EC-01…EC-06 vigentes                   | Contratos upstream que EC-07 consume; no se redefinen.           |
| 6             | EC-07 V1.0                             | Especificación implementable de evaluación, completion y cierre. |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación y evidencia alineadas al Word.                    |

## 0.2 Secuencia oficial vigente de módulos EC

| **Orden** | **Código** | **Módulo oficial**                                                                            | **Responsabilidad primaria** |
|-----------|------------|-----------------------------------------------------------------------------------------------|------------------------------|
| 1         | EC-01      | Portafolio, programas, versiones, módulos y rutas de microcredenciales                        | Diseño académico             |
| 2         | EC-02      | Ediciones, ofertas, cohortes, modalidades, calendarios y programación operativa               | Oferta / ejecución           |
| 3         | EC-03      | Comercialización académica, pricing, promociones, becas, convenios y condiciones de oferta    | Comercial                    |
| 4         | EC-04      | Prospectos, participantes, registro, preinscripción, inscripción, cupos y listas de espera    | Vinculación                  |
| 5         | EC-05      | Docentes, expertos, facilitadores, planificación, contenidos y entorno de aprendizaje         | Docencia                     |
| 6         | EC-06      | Asistencia, participación, engagement y evidencia de sesiones                                 | Participación                |
| 7         | EC-07      | Evaluaciones, resultados, aprobación, completion y cierre académico                           | Evaluación / cierre          |
| 8         | EC-08      | Certificados, badges, microcredenciales, credenciales verificables y acumulabilidad           | Certificación                |
| 9         | EC-09      | Formación corporativa / in-company, clientes, acuerdos, lotes y reporting empresarial         | B2B / Corporate              |
| 10        | EC-10      | Trayectoria de aprendizaje, progresión, stackable credentials y reconocimiento acumulativo EC | Trayectoria                  |
| 11        | EC-11      | Encuestas, NPS, feedback, evaluación docente, impacto y seguimiento posterior                 | Experiencia / impacto        |
| 12        | EC-12      | Calidad, analítica de portafolio, indicadores, compliance y mejora continua                   | Calidad / gobierno           |

## 0.3 Decisiones arquitectónicas EC07-DA

| **ID**          | **Decisión normativa**                                                                                                                                           |
|-----------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **EC07-DA-001** | ASSESSMENT POLICY ≠ ASSESSMENT PLAN. CT-02 gobierna política; EC-07 materializa el plan operativo versionado para una edición/cohorte.                           |
| **EC07-DA-002** | ASSESSMENT COMPONENT ≠ SESSION. Una evaluación puede tener ventana temporal, pero no crea agenda académica de EC-02/CT-03.                                       |
| **EC07-DA-003** | ATTEMPT ≠ RESULT. Un intento conserva ocurrencia/evidencia; el resultado oficial se deriva y publica con reglas explícitas.                                      |
| **EC07-DA-004** | SCORE ≠ GRADE ≠ PASS. Un puntaje numérico no equivale automáticamente a una calificación o decisión de aprobación.                                               |
| **EC07-DA-005** | PASS ≠ COMPLETION. Aprobar evaluaciones no implica completar el programa; completion compone resultados, asistencia oficial EC-06 y demás requisitos académicos. |
| **EC07-DA-006** | COMPLETION ≠ CERTIFICATE ELIGIBILITY. EC-07 publica completion; EC-08 aplica políticas de credential eligibility/issuance.                                       |
| **EC07-DA-007** | ACADEMIC COMPLETION ≠ FINANCIAL REGULARITY. EC-07 no duplica saldos/pagos; condiciones financieras no forman el completion académico.                            |
| **EC07-DA-008** | ATTENDANCE FACT ≠ EVALUATION INPUT CREATED LOCALLY. EC-06 es Source of Truth de asistencia; EC-07 solo referencia facts oficiales versionados.                   |
| **EC07-DA-009** | LMS TELEMETRY ≠ OFFICIAL RESULT. CT-18 transporta telemetría/grades externos; EC-07 valida, normaliza y adjudica hechos oficiales.                               |
| **EC07-DA-010** | EVIDENCE REF ≠ BLOB. CT-05 almacena entregables y evidencias; EC-07 guarda referencias/hash/metadata de dominio.                                                 |
| **EC07-DA-011** | GROUP SUBMISSION ≠ GROUP RESULT AUTOMATICALLY. Un intento grupal puede alimentar resultados individuales según policy.                                           |
| **EC07-DA-012** | RESULT CORRECTION ≠ UPDATE RESULT. La corrección crea un nuevo hecho/restatement y conserva lineage.                                                             |
| **EC07-DA-013** | APPEAL ≠ CORRECTION. La apelación sigue CT-06; solo una decisión aprobada habilita un nuevo hecho académico.                                                     |
| **EC07-DA-014** | PUBLISHED RESULT = APPEND-ONLY FACT. El hecho oficial no admite UPDATE/DELETE ordinario.                                                                         |
| **EC07-DA-015** | COMPLETION FACT = APPEND-ONLY OFFICIAL FACT. Correcciones crean restatement.                                                                                     |
| **EC07-DA-016** | ACADEMIC CLOSURE ≠ END DATE. Cerrar exige reconciliar pendientes, holds, resultados y completion.                                                                |
| **EC07-DA-017** | CLOSED ≠ IRREVERSIBLE SILENCE. Correcciones posteriores usan reopening/restatement gobernado.                                                                    |
| **EC07-DA-018** | RESULT STATE ≠ UI LABEL. Estados/reason codes son contratos normativos; traducciones CT-08.                                                                      |
| **EC07-DA-019** | TENANT-AWARE FK ≠ TENANT ISOLATION. PK/FK compuestas se complementan con PostgreSQL RLS ENABLE+FORCE.                                                            |
| **EC07-DA-020** | AGGREGATE REVISION ≠ ROOT ROW ONLY. Mutar hijos incrementa revisión del root.                                                                                    |
| **EC07-DA-021** | TENANT CONTEXT ≠ REQUEST BODY. tenant_id deriva de Security/TenantContext.                                                                                       |
| **EC07-DA-022** | PUBLISH PLAN ≠ PATCH STATE. Publicar plan ejecuta validación, hash, snapshot, workflow/evidence y outbox.                                                        |
| **EC07-DA-023** | IDEMPOTENCY IN_PROGRESS ≠ FOREVER. Comandos sensibles usan lease/recovery.                                                                                       |
| **EC07-DA-024** | OUTBOX PENDING ≠ CLAIMED. Workers multi-instancia usan SKIP LOCKED + lease.                                                                                      |
| **EC07-DA-025** | 202 ACCEPTED ≠ EFFECT CONFIRMED. Operaciones asíncronas retornan operationId.                                                                                    |
| **EC07-DA-026** | UNKNOWN_EFFECT ≠ RETRY BLIND. Integraciones se reconcilian antes de retry si efecto incierto.                                                                    |
| **EC07-DA-027** | AI RECOMMENDATION ≠ GRADE/PASS/COMPLETION DECISION. CT-12 puede asistir; no adjudica autoridad.                                                                  |
| **EC07-DA-028** | AI GENERATED FEEDBACK ≠ OFFICIAL RESULT. Feedback sugerido requiere revisión.                                                                                    |
| **EC07-DA-029** | RUBRIC REF = VERSIONED IMMUTABLE REF. El resultado debe reconstruirse con la rúbrica/escala aplicada.                                                            |
| **EC07-DA-030** | POLICY REF = IMMUTABLE POLICY VERSION REF. Thresholds, ponderaciones y reglas no se hardcodean.                                                                  |
| **EC07-DA-031** | NO_DATA ≠ ZERO ≠ NOT_EVALUATED ≠ UNAVAILABLE. UI/API conservan semánticas distintas.                                                                             |
| **EC07-DA-032** | OPENAPI/ASYNCAPI = EXECUTABLE CONTRACT. Frontend/consumers generan clientes/tests.                                                                               |
| **EC07-DA-033** | SCHEMA RELEASE ≠ APP RELEASE. Flyway usa expand/contract N/N-1.                                                                                                  |
| **EC07-DA-034** | HTTP RUNTIME ROLE ≠ MIGRATOR ROLE ≠ WORKER ROLE. Privilegios separados.                                                                                          |
| **EC07-DA-035** | CLOSURE RECEIPT = APPEND-ONLY EVIDENCE. Hash, counts, policy refs, actor y assurance son inmutables.                                                             |
| **EC07-DA-036** | MIGRATION ≠ DIRECT INSERT. CT-16 promueve legacy por domain/API con receipts.                                                                                    |

## 0.4 Criterio de suficiencia FullStack y regla de plantilla

EC-07 es suficiente cuando dos equipos Senior independientes pueden implementar el mismo comportamiento observable, integridad física, contratos HTTP/eventos, reconciliación y estados UI sin decidir por su cuenta qué significa aprobar, completar o cerrar. Las variaciones institucionales deben resolverse mediante CT-02/policy versionada o ADR explícito.

| **REGLA DE PLANTILLA —** El módulo conserva como mínimo Aggregate Revision Contract, PostgreSQL RLS defense-in-depth, facts append-only, state transition guards, durable idempotency, leased outbox, OperationStatus, API paginada, Threat Model, Secure SDLC, expand/contract N/N-1 y bootstrap reproducible. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.5 Invariantes heredadas de EC-01…EC-06

| **Invariante**      | **Aplicación EC-07**                                                                    |
|---------------------|-----------------------------------------------------------------------------------------|
| Tenant              | Todas las queries filtran tenant y PostgreSQL aplica RLS.                               |
| Version pinning     | ProgramVersion, Edition/Cohort, attendance facts y policies se consumen por ID/version. |
| No FK cross-context | EC/CT/IAM/Finanzas por EXT REF/ports.                                                   |
| History             | Resultados/completion/cierres oficiales usan append-only + restatement.                 |
| Concurrency         | If-Match representa revisión del aggregate completo.                                    |
| Resilience          | UNKNOWN_EFFECT exige reconciliation.                                                    |
| Financial boundary  | EC-07 no crea deuda, pago, factura, saldo ni ledger.                                    |
| Document boundary   | CT-05 conserva binarios.                                                                |
| AI boundary         | Toda IA pasa por CT-12 y no adjudica decisiones críticas.                               |

# 1. Índice operativo del documento

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal de reglas BR-EC07

- 10\. Casos de uso UC-EC07

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

EC-07 resuelve el problema de convertir múltiples fuentes de evidencia — entregas, exámenes, proyectos, rúbricas, telemetría LMS, evaluaciones presenciales, asistencia oficial y decisiones de revisión — en hechos académicos confiables. En Educación Continua los modelos de evaluación son heterogéneos: algunos programas no evalúan, otros exigen aprobación mínima, otros combinan asistencia y proyecto final, y otros permiten reintentos o recuperación. El diseño debe soportar esa variedad sin lógica hardcodeada.

El módulo separa el plan de evaluación de la ejecución individual, los intentos de los resultados, la calificación de la decisión de aprobación, y la aprobación de completion. Esta separación hace posible reconstruir una decisión años después, demostrar qué policy/rúbrica/escala se aplicó, corregir un error sin borrar historia y cerrar una edición con evidencia objetiva de que no quedaron pendientes ocultos.

## 2.1 Incluido

- AssessmentPlan versionado por edición/cohorte, derivado de ProgramVersion y policies vigentes.

- Componentes evaluativos, pesos, ventanas, rubrics/scale refs, outcomes y reglas de attempts.

- Evaluaciones individuales y grupales con memberships versionados.

- Attempt lifecycle, evidencias CT-05 y receipts LMS/proctoring vía CT-18.

- ScoreFacts y ResultFacts append-only; normalización de escalas sin pérdida de valor original.

- Pass/fail/absent/exempt/incomplete con reason codes y policy snapshot.

- Correcciones, regrade y appeals con workflow CT-06 y lineage de facts.

- CompletionEvaluation que compone resultados EC-07, asistencia/participación EC-06 y requisitos académicos aplicables.

- CompletionFact oficial append-only y restatements.

- AcademicClosure por edición/cohorte con holds, preflight, close receipt y reconciliación downstream.

- Integración con EC-08 mediante eventos de completion/closure, sin emitir certificados.

- APIs, eventos, idempotencia, RLS, observabilidad, IA asistiva, migración, QA y UAT.

## 2.2 Fuera de alcance

- Diseñar ProgramVersion/outcomes base — EC-01.

- Crear Edition/Offering/Cohort o agenda — EC-02/CT-03.

- Pricing, pagos, deuda, factura o condición financiera — EC-03/Core Financiero.

- Person, participant/enrollment, cupos o waitlist — CT-04/EC-04.

- Asignar docentes, gestionar contenido binario o LMS provisioning — EC-05/CT-05/CT-18.

- Capturar asistencia oficial y engagement — EC-06.

- Emitir certificados, badges o credenciales verificables — EC-08.

- Crear progreso stackable individual — EC-10.

- Implementar workflow, documentos, IA, notificaciones o BI como motores locales — CT correspondientes.

| **ANTI-SCOPE —** EC-07 no debe convertirse en LMS, libro contable, gestor documental, sistema de asistencia ni emisor de certificados. Su responsabilidad es producir hechos académicos de evaluación/completion/cierre con lineage y evidencia. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Término**              | **Definición normativa**                                                                                      |
|--------------------------|---------------------------------------------------------------------------------------------------------------|
| AssessmentPlan           | Snapshot operativo versionado de cómo se evaluará una edición/cohorte concreta.                               |
| AssessmentComponent      | Unidad evaluativa: examen, proyecto, tarea, presentación, práctica, quiz, capstone u otro tipo parametrizado. |
| AssessmentWindow         | Ventana temporal en la que un componente admite intentos; no sustituye sesiones/calendario EC-02.             |
| RubricBinding            | Referencia versionada a rúbrica/escala gobernada.                                                             |
| ParticipantEvaluation    | Aggregate de evaluación de un enrollment dentro de un AssessmentPlan.                                         |
| EvaluationGroup          | Grupo temporal para evaluación grupal; no reemplaza cohortes.                                                 |
| Attempt                  | Ocurrencia de participación evaluativa con evidence/source receipts.                                          |
| AttemptEvidenceRef       | Referencia a evidencia CT-05/LMS/proctoring; no blob.                                                         |
| ScoreFact                | Hecho append-only de puntaje original/normalizado.                                                            |
| ResultFact               | Hecho académico oficial de resultado y estado.                                                                |
| PassDecision             | PASS/FAIL/INCOMPLETE/ABSENT/EXEMPT; no equivale completion.                                                   |
| ResultAdjustmentRequest  | Solicitud de corrección/regrade; no altera facts.                                                             |
| ResultAdjustmentDecision | Decisión que puede originar nuevo ResultFact.                                                                 |
| AppealCase               | Caso formal de apelación coordinado con CT-06.                                                                |
| AppealDecision           | Resolución versionada con reason/evidence.                                                                    |
| CompletionEvaluation     | Ejecución determinista de reglas de completion.                                                               |
| CompletionRuleFact       | Resultado por regla: SATISFIED/NOT_SATISFIED/UNKNOWN/WAIVED.                                                  |
| CompletionFact           | Hecho oficial COMPLETED/NOT_COMPLETED.                                                                        |
| CompletionRestatement    | Nuevo fact que supersede otro sin borrarlo.                                                                   |
| AcademicClosure          | Aggregate de cierre de edición/cohorte después de preflight.                                                  |
| ClosureHold              | Bloqueo explícito que impide cerrar.                                                                          |
| ClosureReceipt           | Evidence append-only del cierre.                                                                              |
| PolicySnapshot           | Refs/versiones inmutables usadas para derivar decisiones.                                                     |
| EXT REF                  | Referencia cross-context sin FK física.                                                                       |
| UNKNOWN_EFFECT           | Efecto remoto incierto; exige reconciliation.                                                                 |
| NOT_EVALUATED            | Evaluación no ejecutada; no equivale score cero.                                                              |
| NO_DATA                  | No existen registros aplicables.                                                                              |
| UNAVAILABLE              | Dependencia no disponible.                                                                                    |
| STALE                    | Dato conocido fuera de freshness budget.                                                                      |
| PARTIAL                  | Respuesta incompleta con provenance explícito.                                                                |

# 4. Bounded Context y matriz Source of Truth

EC-07 posee semántica de evaluación, resultado, pass/fail, completion y cierre. Cuando consume facts de otro contexto persiste únicamente EXT REF, version/hash/snapshot permitido y receipts de resolución. Copiar una descripción o valor externo para trazabilidad no convierte a EC-07 en owner del dato original.

| **Información**                  | **Source of Truth** | **EC-07 almacena**           | **EC-07 referencia**          | **Regla**                    |
|----------------------------------|---------------------|------------------------------|-------------------------------|------------------------------|
| Tenant/scope                     | CT-01               | tenant_id + scope refs       | tenant/scope contract         | RLS y autorización.          |
| Policies/escalas/tipos           | CT-02               | policy/version snapshot refs | policy refs                   | No thresholds hardcodeados.  |
| Temporalidad/calendario          | CT-03               | assessment windows propias   | calendar/session refs         | Ventana ≠ agenda.            |
| Persona canónica                 | CT-04               | No PII                       | subject/person refs           | Solo refs.                   |
| Documentos/evidencia             | CT-05               | evidence_ref/hash            | document refs                 | No blobs.                    |
| Workflow/appeals                 | CT-06               | resultado semántico mínimo   | workflow/task refs            | No modifica facts.           |
| Notificaciones                   | CT-07               | No                           | request/receipt refs          | Post-commit.                 |
| Localización                     | CT-08               | codes/keys                   | translation refs              | Label ≠ state.               |
| Integración/eventos              | CT-09               | outbox/inbox local           | message refs                  | At-least-once.               |
| Auditoría/privacy                | CT-10               | metadata mínima              | audit/evidence refs           | PII mínima.                  |
| Analytics                        | CT-11               | hechos publicables           | dataset refs                  | Sin shadow BI.               |
| IA                               | CT-12               | run/eval refs                | AI refs                       | Recommendation ≠ Decision.   |
| Scheduling                       | CT-13               | No                           | none                          | No solver.                   |
| Recursos                         | CT-14               | No                           | none                          | No aulas.                    |
| Elegibilidad                     | CT-15               | No motor                     | refs opcionales               | No owner completion.         |
| Migración/DQ                     | CT-16               | promotion receipts           | lineage/batch refs            | No INSERT directo.           |
| Continuidad                      | CT-17               | No motor                     | runbook refs                  | Degraded mode.               |
| LMS/ecosistema                   | CT-18               | source receipts              | LMS/proctoring refs           | Telemetry ≠ result.          |
| ProgramVersion/outcomes          | EC-01               | No                           | program_version/outcome refs  | Pin versión.                 |
| Edition/Cohort                   | EC-02               | No                           | edition/cohort refs           | Scope ejecución.             |
| Participant/Enrollment           | EC-04               | No PII                       | participant/enrollment refs   | Enrollment ≠ result.         |
| Instructor assignment            | EC-05               | No                           | assignment refs               | Authority aparte.            |
| Attendance/participation         | EC-06               | No                           | official attendance fact refs | Input completion.            |
| Assessment/results/completion    | EC-07               | Sí                           | —                             | Source of Truth local.       |
| Certificate eligibility/issuance | EC-08               | No                           | completion downstream         | No emisión local.            |
| Precio/pago/factura/saldo        | Finanzas/EC-03      | No                           | No                            | Academic ≠ financial ledger. |

# 5. Dependencias CT-01 a CT-18, cores y otros módulos

| **Dependencia** | **Responsabilidad**    | **Contrato EC-07**               | **Frontera/fallo**         |
|-----------------|------------------------|----------------------------------|----------------------------|
| CT-01           | Scope institucional    | scope refs; tenant authorization | Fail-closed publish/close. |
| CT-02           | Policies/tipos/escalas | policy/version refs + snapshots  | Cache por version.         |
| CT-03           | Temporalidad           | assessment windows/refs          | UTC; no session ownership. |
| CT-04           | Persona                | actor refs                       | No PII local.              |
| CT-05           | Evidence/documents     | submission/rubric/evidence refs  | No blobs.                  |
| CT-06           | Workflow               | review/regrade/appeals/reopen    | No direct fact mutation.   |
| CT-07           | Notifications          | result/closure notifications     | Post-commit.               |
| CT-08           | i18n                   | labels/feedback keys             | Canonical reason codes.    |
| CT-09           | Integration            | events/contracts                 | Outbox/inbox.              |
| CT-10           | Security/audit         | audit/evidence refs              | Critical audit.            |
| CT-11           | Analytics              | facts                            | Event-fed.                 |
| CT-12           | AI                     | anomaly/feedback/review          | Human/policy authority.    |
| CT-13           | Scheduling             | No solver                        | None.                      |
| CT-14           | Resources              | No tables                        | None.                      |
| CT-15           | Eligibility            | Optional external rule           | Not owner completion.      |
| CT-16           | Migration              | dry-run/promotion                | No direct INSERT.          |
| CT-17           | Continuity             | RTO/RPO/runbooks                 | Read-only degrade.         |
| CT-18           | LMS/proctoring         | attempt/grade receipts           | Reconcile before retry.    |
| IAM             | Auth/MFA/roles         | actor + assurance                | Step-up critical.          |
| EC-01           | Program design         | ProgramVersion/outcome refs      | Pin version.               |
| EC-02           | Edition/Cohort         | scope refs                       | Lifecycle compatible.      |
| EC-04           | Enrollment             | enrollment refs                  | No person shadow.          |
| EC-05           | Instructor             | assignment refs                  | Assignment ≠ permission.   |
| EC-06           | Attendance             | official fact refs               | No recompute.              |
| EC-08           | Credential             | Consumes completion events       | No certificate effects.    |
| Finanzas        | Financial facts        | None                             | No price/payment/debt.     |

# 6. Arquitectura funcional E2E y journeys

<img src="media/image1.png" style="width:6.65in;height:3.67233in" />

Figura 1 — EC-07 dentro de la vertical y CT

| **Journey**                     | **Flujo E2E**                                                                                                      |
|---------------------------------|--------------------------------------------------------------------------------------------------------------------|
| **J-EC07-01 Diseño**            | Crear AssessmentPlan DRAFT → componentes/policies → validate → CT-06 review → APPROVED → publish receipt + outbox. |
| **J-EC07-02 Manual**            | Instructor registra attempt/score → valida plan/ventana → ScoreFact → ResultFact.                                  |
| **J-EC07-03 LMS**               | CT-18 entrega receipt → inbox dedup → mapping → preserva valor original → adjudica o quarantine.                   |
| **J-EC07-04 Reintento**         | Nuevo Attempt monotónico → policy BEST/LAST/etc decide current result; history intacta.                            |
| **J-EC07-05 Corrección**        | Adjustment → approval → nuevo ResultFact superseding anterior.                                                     |
| **J-EC07-06 Apelación**         | Appeal → workflow/evidence → decision → restatement si corresponde.                                                |
| **J-EC07-07 Completion**        | Result facts + EC-06 attendance + policy → rule facts → CompletionFact.                                            |
| **J-EC07-08 Cierre**            | Preflight → holds → READY → close step-up → ClosureReceipt + event.                                                |
| **J-EC07-09 Reapertura**        | Workflow aprobado → nuevo closure cycle → corrections/restatements → recierre.                                     |
| **J-EC07-10 Dependencia caída** | UI muestra UNAVAILABLE/STALE/PARTIAL; critical decisions fail-closed; UNKNOWN_EFFECT reconciles.                   |
| **J-EC07-11 IA**                | CT-12 sugiere anomalías/feedback; humano acepta/edita; no authority autónoma.                                      |

# 7. Modelo de dominio: Aggregates, Entities, Value Objects, Policies y Domain Services

<img src="media/image2.png" style="width:6.65in;height:3.67233in" />

Figura 2 — Modelo de dominio lógico EC-07

## 7.1 Aggregate Root — AssessmentPlan

AssessmentPlan representa la definición operativa de evaluación para una edición/cohorte. Pinnea ProgramVersion, scope EC-02, policy versions y AssessmentComponents. Su publicación congela la configuración para que un cambio posterior no reinterprete historia.

## 7.2 Aggregate — ParticipantEvaluation

ParticipantEvaluation agrega la historia operativa de attempts de un enrollment. No almacena identidad personal; referencia EC-04. Facts oficiales se agregan append-only y se reconstruyen por lineage.

## 7.3 Aggregate — CompletionEvaluation

CompletionEvaluation ejecuta una policy versionada sobre hechos oficiales: ResultFacts seleccionados, attendance EC-06 y requisitos académicos. Conserva CompletionRuleFacts y produce CompletionFact.

## 7.4 Aggregate — AcademicClosure

AcademicClosure gobierna el cierre de una edición/cohorte. Reúne ClosureHolds, counts esperados/observados, reconciliation y evidence refs. CLOSED queda inmutable; una corrección posterior usa nuevo ciclo.

## 7.5 Value Objects

| **Value Object** | **Semántica**                                           |
|------------------|---------------------------------------------------------|
| AssessmentWeight | Decimal exacto; suma validada por policy.               |
| ScoreValue       | Valor original + scale ref + normalized value opcional. |
| ResultStatus     | PASS/FAIL/INCOMPLETE/ABSENT/EXEMPT/NOT_EVALUATED.       |
| AttemptNumber    | Entero positivo monotónico por subject+component.       |
| PolicyRef        | policy_id + immutable version.                          |
| RubricRef        | Referencia inmutable a rúbrica/escala.                  |
| EvidenceRef      | Opaque ref + hash/authority.                            |
| ExternalReceipt  | source + remote id + observed_at + payload hash.        |
| ReasonCode       | Código estable auditable.                               |
| CompletionStatus | COMPLETED/NOT_COMPLETED; separado de pass.              |
| ClosureScope     | Edition/Cohort + expected population snapshot.          |
| ContentHash      | Hash canónico sobre snapshot/fact.                      |

## 7.6 Domain Policies

- AssessmentPlanPublicationPolicy — coherencia de componentes, pesos, windows, rubric refs y scope.

- AttemptEligibilityPolicy — intentos, ventanas, reintentos y source trust.

- ScoreNormalizationPolicy — transforma escalas preservando original.

- ResultAdjudicationPolicy — selección attempts, grade y pass/fail.

- ResultCorrectionPolicy — regrade/appeal/restatement.

- CompletionPolicy — compone ResultFacts y EC-06 facts.

- AcademicClosurePolicy — preflight, holds, tolerancias y evidence.

- GroupAssessmentPolicy — traduce evidencia grupal a resultados individuales.

- ExternalGradeTrustPolicy — auto-adjudicate/review/quarantine.

## 7.7 Domain Services

- AssessmentPlanValidator

- ScoreNormalizer

- ResultAdjudicator

- AttemptSelectionService

- CompletionEvaluator

- ClosurePreflightService

- ResultLineageService

- ExternalResultReconciler

- EvaluationAnomalyService

## 7.8 Aggregate Revision Contract — patrón obligatorio

AssessmentPlan.version y ParticipantEvaluation.version representan la revisión observable del aggregate completo. Cualquier mutación de hijos bloquea/revalida root, compara If-Match y actualiza revisión dentro de la misma transacción. Facts oficiales no se editan.

| **Paso** | **Contrato**                                     |
|----------|--------------------------------------------------|
| 1        | Resolver tenant desde Security/TenantContext.    |
| 2        | Abrir transacción y SET LOCAL peopleu.tenant_id. |
| 3        | Lock root y comparar expected revision.          |
| 4        | Ejecutar command de intención.                   |
| 5        | Persistir hijos/facts; bump root.                |
| 6        | Audit/outbox/idempotency misma transacción.      |
| 7        | Commit y responder ETag/receipt.                 |
| 8        | Mismatch =\> 412 sin side effects.               |

| **PRUEBA NO NEGOCIABLE —** Dos actores abren ParticipantEvaluation con ETag 7. A registra un attempt y pasa a 8. B intenta otra mutación con If-Match 7: debe recibir 412 aunque toque otra tabla hija. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 8. Máquinas de estado normativas

<img src="media/image3.png" style="width:6.65in;height:2.79131in" />

Figura 3 — Estado versionado normativo de AssessmentPlan

| **Aggregate**           | **Estados/transiciones**                                                        | **Invariante**                   |
|-------------------------|---------------------------------------------------------------------------------|----------------------------------|
| AssessmentPlan          | DRAFT → IN_REVIEW → APPROVED → PUBLISHED → CLOSED; VOID                         | Solo DRAFT edita configuración.  |
| ParticipantEvaluation   | PENDING → ACTIVE → READY_FOR_ADJUDICATION → ADJUDICATED → FINAL; SUSPENDED/VOID | FINAL no borra facts.            |
| Attempt                 | CREATED → SUBMITTED → ACCEPTED/REJECTED; INVALIDATED                            | Accepted no se reescribe.        |
| ResultAdjustmentRequest | DRAFT → SUBMITTED → UNDER_REVIEW → APPROVED/REJECTED → APPLIED/CANCELLED        | APPLIED crea new fact.           |
| AppealCase              | SUBMITTED → ADMISSIBLE/INADMISSIBLE → UNDER_REVIEW → DECIDED → CLOSED           | No modifica result directamente. |
| CompletionEvaluation    | PENDING → READY → EVALUATING → EVALUATED; BLOCKED/STALE/VOID                    | Inputs pinneados.                |
| AcademicClosure         | DRAFT → VALIDATING → BLOCKED/READY → CLOSED; VOID                               | CLOSED append-only evidence.     |

| **REGLA DE ESTADO —** Nunca implementar “status = PASS”, “completion = true” o “state = CLOSED” como PATCH libre. Son casos de uso transaccionales con policy snapshot, ETag, evidencia, audit y eventos. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 9. Catálogo formal de reglas BR-EC07

| **ID**          | **Nombre**                           | **Regla implementable/verificable**                                                        |
|-----------------|--------------------------------------|--------------------------------------------------------------------------------------------|
| **BR-EC07-001** | Tenant obligatorio                   | Todo aggregate/tabla tenant-owned usa tenant_id del contexto autorizado; RLS ENABLE+FORCE. |
| **BR-EC07-002** | Scope pinneado                       | AssessmentPlan referencia edition/cohort y ProgramVersion explícitos.                      |
| **BR-EC07-003** | Plan único por revisión              | plan_no positivo y único dentro del scope.                                                 |
| **BR-EC07-004** | Plan publicado inmutable             | PUBLISHED/CLOSED no permite mutar componentes/pesos/rúbricas/windows.                      |
| **BR-EC07-005** | Suma de pesos                        | Policy define suma/tolerancia; BigDecimal.                                                 |
| **BR-EC07-006** | Componente identificable             | component_code único dentro del plan.                                                      |
| **BR-EC07-007** | Tipo parametrizado                   | assessment_type_code viene CT-02.                                                          |
| **BR-EC07-008** | Outcome externo                      | outcome_ref pinnea EC-01; no FK.                                                           |
| **BR-EC07-009** | Window coherente                     | close_at \>= open_at; UTC.                                                                 |
| **BR-EC07-010** | Rubric versionada                    | rubric_ref/scale_ref inmutable.                                                            |
| **BR-EC07-011** | Intento positivo                     | attempt_no \>=1 y único por subject+component.                                             |
| **BR-EC07-012** | Max attempts                         | No exceder policy salvo override gobernado.                                                |
| **BR-EC07-013** | Attempt evidence                     | Evidencia requerida según policy; blob CT-05.                                              |
| **BR-EC07-014** | Submission late                      | late_flag explícito y policy decide.                                                       |
| **BR-EC07-015** | Score precision                      | numeric/BigDecimal; no double.                                                             |
| **BR-EC07-016** | Score bounds                         | Normalizado respeta escala.                                                                |
| **BR-EC07-017** | Original preserved                   | ScoreFact conserva original_value/original_scale_ref.                                      |
| **BR-EC07-018** | Result append-only                   | ResultFact no UPDATE/DELETE.                                                               |
| **BR-EC07-019** | Result lineage                       | Corrección referencia superseded_result_fact_id.                                           |
| **BR-EC07-020** | Pass rule versionada                 | PASS/FAIL por policy snapshot.                                                             |
| **BR-EC07-021** | Zero ≠ missing                       | 0 válido; NULL/NOT_EVALUATED distintos.                                                    |
| **BR-EC07-022** | Absent explícito                     | ABSENT no score cero.                                                                      |
| **BR-EC07-023** | Exempt explícito                     | EXEMPT exige authority/reason.                                                             |
| **BR-EC07-024** | Incomplete explícito                 | INCOMPLETE no equivale FAIL automáticamente.                                               |
| **BR-EC07-025** | Regrade no sobrescribe               | Regrade crea new facts.                                                                    |
| **BR-EC07-026** | Appeal no altera                     | AppealCase no cambia result.                                                               |
| **BR-EC07-027** | Appeal SoD                           | Decision maker cumple SoD.                                                                 |
| **BR-EC07-028** | Group membership snapshot            | Membership se congela por attempt.                                                         |
| **BR-EC07-029** | Group ≠ individual result            | Policy adjudica individual.                                                                |
| **BR-EC07-030** | External receipt dedup               | message/receipt dedup.                                                                     |
| **BR-EC07-031** | Unknown external effect              | UNKNOWN_EFFECT + reconcile.                                                                |
| **BR-EC07-032** | Attendance external                  | Completion consume EC-06 facts.                                                            |
| **BR-EC07-033** | Pass ≠ completion                    | PASS no marca completion.                                                                  |
| **BR-EC07-034** | Completion inputs pinned             | RuleFact guarda refs/version/hash.                                                         |
| **BR-EC07-035** | Completion append-only               | CompletionFact no UPDATE/DELETE.                                                           |
| **BR-EC07-036** | Completion restatement               | Cambio crea new fact.                                                                      |
| **BR-EC07-037** | Completion academic only             | No deuda/pago local.                                                                       |
| **BR-EC07-038** | Certificate boundary                 | Completion no crea certificado.                                                            |
| **BR-EC07-039** | Closure preflight                    | CLOSE exige preflight PASS.                                                                |
| **BR-EC07-040** | Pending results hold                 | Pendientes crean ClosureHold.                                                              |
| **BR-EC07-041** | Dependency unavailable hold          | Critical unavailable bloquea close.                                                        |
| **BR-EC07-042** | Closure receipt append-only          | Receipt no UPDATE/DELETE.                                                                  |
| **BR-EC07-043** | Closure counts                       | Expected/observed se reconcilian.                                                          |
| **BR-EC07-044** | Reopen governed                      | Reabrir exige workflow/reason/step-up.                                                     |
| **BR-EC07-045** | No hard delete                       | Facts/receipts oficiales no hard-delete.                                                   |
| **BR-EC07-046** | Idempotency critical                 | Publish/result/completion/close/restatement/import usan key durable.                       |
| **BR-EC07-047** | Idempotency conflict                 | Same key different payload =\> 409.                                                        |
| **BR-EC07-048** | Idempotency lease                    | IN_PROGRESS owner/lease/recovery.                                                          |
| **BR-EC07-049** | Outbox atomic                        | Fact + outbox misma transacción.                                                           |
| **BR-EC07-050** | Outbox claim                         | SKIP LOCKED + lease.                                                                       |
| **BR-EC07-051** | Inbox dedup                          | message_id por consumer.                                                                   |
| **BR-EC07-052** | At-least-once                        | No exactly-once distribuido.                                                               |
| **BR-EC07-053** | ETag mandatory                       | Mutaciones editables If-Match.                                                             |
| **BR-EC07-054** | No last-write-wins                   | Conflicto explícito.                                                                       |
| **BR-EC07-055** | ProblemDetail                        | RFC Problem Details + reason codes.                                                        |
| **BR-EC07-056** | UI states                            | NO_DATA/ZERO/NOT_EVALUATED/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT distintos.             |
| **BR-EC07-057** | Audit critical                       | actor/scope/reason/correlation/policy/evidence.                                            |
| **BR-EC07-058** | Step-up critical                     | Restatement/close/reopen según policy.                                                     |
| **BR-EC07-059** | PII minimization                     | No nombres/documentos participant.                                                         |
| **BR-EC07-060** | No blobs                             | Evidence CT-05.                                                                            |
| **BR-EC07-061** | AI provenance                        | run/model/template/eval/grounding/confidence/reviewer.                                     |
| **BR-EC07-062** | AI no grade                          | IA no grade/pass/completion autónoma.                                                      |
| **BR-EC07-063** | Migration governed                   | CT-16 pipeline.                                                                            |
| **BR-EC07-064** | Time UTC                             | timestamptz UTC.                                                                           |
| **BR-EC07-065** | Policy reconstruction                | Fact reconstructible.                                                                      |
| **BR-EC07-066** | RLS runtime                          | Runtime no BYPASSRLS.                                                                      |
| **BR-EC07-067** | Business codes stable                | component/reason codes no reciclan.                                                        |
| **BR-EC07-068** | Pagination bounded                   | pageSize máximo/sort estable.                                                              |
| **BR-EC07-069** | 202 OperationStatus                  | 202 incluye operationId.                                                                   |
| **BR-EC07-070** | PATCH limited                        | PATCH no transitions.                                                                      |
| **BR-EC07-071** | OpenAPI client                       | Frontend generado.                                                                         |
| **BR-EC07-072** | Expand/contract                      | N/N-1.                                                                                     |
| **BR-EC07-073** | Secure SDLC                          | High/Critical block release.                                                               |
| **BR-EC07-074** | Capacity budgets                     | Roster/components/attempts/batch/payload limits.                                           |
| **BR-EC07-075** | Read-only degrade                    | Historical reads con freshness.                                                            |
| **BR-EC07-076** | Hash canonical                       | Schema version + hash algorithm.                                                           |
| **BR-EC07-077** | Reason mandatory                     | Void/invalidate/restate/reopen reason.                                                     |
| **BR-EC07-078** | Evaluator authority                  | Assignment no basta; ABAC.                                                                 |
| **BR-EC07-079** | Self-evaluation policy               | No self-grade salvo policy.                                                                |
| **BR-EC07-080** | Score source trust                   | TRUSTED/REVIEW_REQUIRED/REJECTED.                                                          |
| **BR-EC07-081** | Late source event                    | Después de close crea reconciliation/reopen candidate.                                     |
| **BR-EC07-082** | Component cancellation               | Replacement/waiver policy.                                                                 |
| **BR-EC07-083** | Weight changes                       | Después publish requiere nueva revisión.                                                   |
| **BR-EC07-084** | Rubric changes                       | No altera results previos.                                                                 |
| **BR-EC07-085** | Attempt invalidation                 | Reason/evidence, no delete.                                                                |
| **BR-EC07-086** | Duplicate attempt                    | Same source receipt no duplica.                                                            |
| **BR-EC07-087** | Manual score idempotent              | Same key same fact.                                                                        |
| **BR-EC07-088** | Finalization preflight               | FINAL sin bloqueantes.                                                                     |
| **BR-EC07-089** | Completion reevaluation              | Input change =\> reevaluation candidate.                                                   |
| **BR-EC07-090** | Closure scope immutable              | CLOSED preserva population snapshot.                                                       |
| **BR-EC07-091** | Downstream delivery                  | Fallo EC-08 no revierte local fact.                                                        |
| **BR-EC07-092** | Cross-tenant external ref            | Adapters verifican scope.                                                                  |
| **BR-EC07-093** | Data retention                       | CT-10/EC-00.                                                                               |
| **BR-EC07-094** | Legal hold                           | Impide purge aplicable.                                                                    |
| **BR-EC07-095** | Export evidence pack                 | Hashes/refs/actor/policy/lineage.                                                          |
| **BR-EC07-096** | Accessibility                        | Accommodations sin leakage.                                                                |
| **BR-EC07-097** | Accommodations                       | Cambian condiciones autorizadas, no outcome sin policy.                                    |
| **BR-EC07-098** | Proctoring boundary                  | Signal ≠ misconduct decision.                                                              |
| **BR-EC07-099** | Academic integrity                   | No auto-accusation por AI.                                                                 |
| **BR-EC07-100** | Bulk grade safe                      | Dry-run/per-row/idempotency.                                                               |
| **BR-EC07-101** | Bulk partial explicit                | Per-row receipt/status.                                                                    |
| **BR-EC07-102** | Export privacy                       | Least privilege.                                                                           |
| **BR-EC07-103** | Audit actor type                     | Humano/sistema/import/adapter distinto.                                                    |
| **BR-EC07-104** | Correlation required                 | Commands y receipts con correlation/causation.                                             |
| **BR-EC07-105** | No silent default                    | Missing policy =\> 422/503.                                                                |
| **BR-EC07-106** | Deterministic recompute              | Same inputs =\> same result.                                                               |
| **BR-EC07-107** | Rule evidence                        | RuleFact explica operator/expected/observed/outcome.                                       |
| **BR-EC07-108** | Version monotonic                    | Plan/closure cycle monotónicos.                                                            |
| **BR-EC07-109** | Facts immutable DB                   | Triggers/revoke.                                                                           |
| **BR-EC07-110** | Source timestamp                     | occurred_at != received_at.                                                                |
| **BR-EC07-111** | Clock skew                           | Timestamps sospechosos se marcan.                                                          |
| **BR-EC07-112** | Duplicate closure                    | No dos CLOSED current mismo scope.                                                         |
| **BR-EC07-113** | Closure hash                         | Cubre counts/completion set/policies.                                                      |
| **BR-EC07-114** | Reconciliation visible               | Ops ve backlog/unknown.                                                                    |
| **BR-EC07-115** | No direct child repo                 | Commands mutan aggregate.                                                                  |
| **BR-EC07-116** | Contract tests                       | Ports versionados.                                                                         |
| **BR-EC07-117** | Performance gates                    | SLO/load tests.                                                                            |
| **BR-EC07-118** | No orphan fact                       | Fact resuelve scope interno.                                                               |
| **BR-EC07-119** | Void terminal                        | No reactiva fact.                                                                          |
| **BR-EC07-120** | Supersede single chain               | Lineage no ciclo/branch ambiguo.                                                           |
| **BR-EC07-121** | Result current view derived          | Current por lineage.                                                                       |
| **BR-EC07-122** | Completion current view derived      | Current por lineage.                                                                       |
| **BR-EC07-123** | Close current view derived           | Latest valid cycle derivado.                                                               |
| **BR-EC07-124** | Operational rejection ≠ system error | 422 vs 503 vs 500.                                                                         |
| **BR-EC07-125** | Rate limit                           | Bulk/import/reconcile 429/policy.                                                          |
| **BR-EC07-126** | Evidence unavailable                 | Unavailable ≠ missing.                                                                     |
| **BR-EC07-127** | Stale inputs                         | No finalize critical con stale si policy.                                                  |
| **BR-EC07-128** | Snapshot at publish                  | Plan conserva policy/rubric refs/hash.                                                     |
| **BR-EC07-129** | No retroactive policy                | Nueva policy no recalcula history sin restatement.                                         |
| **BR-EC07-130** | No retroactive scale                 | Nueva escala no reinterpreta history.                                                      |
| **BR-EC07-131** | Outcome mapping versioned            | Binding pinneado al plan.                                                                  |
| **BR-EC07-132** | Component optionality                | Optional/exempt por policy.                                                                |
| **BR-EC07-133** | Threshold boundary                   | Inclusivity/exclusivity explícita.                                                         |
| **BR-EC07-134** | Rounding deterministic               | Rounding mode/version policy.                                                              |
| **BR-EC07-135** | Locale neutral storage               | Números/fechas nativos.                                                                    |
| **BR-EC07-136** | Audit no secrets                     | No tokens/submissions privadas.                                                            |
| **BR-EC07-137** | Observability labels bounded         | No enrollment_id metric label.                                                             |
| **BR-EC07-138** | Evidence pack complete               | Plan hash, results lineage, completion, closure receipt.                                   |
| **BR-EC07-139** | UAT evidence                         | Critical scenarios con evidencia.                                                          |

# 10. Casos de uso UC-EC07

| **ID**          | **Caso de uso**                | **Actor primario**     |
|-----------------|--------------------------------|------------------------|
| **UC-EC07-001** | Crear AssessmentPlan           | Academic Coordinator   |
| **UC-EC07-002** | Modificar AssessmentPlan DRAFT | Academic Coordinator   |
| **UC-EC07-003** | Importar blueprint evaluativo  | Academic Designer      |
| **UC-EC07-004** | Agregar AssessmentComponent    | Academic Designer      |
| **UC-EC07-005** | Configurar pesos               | Academic Designer      |
| **UC-EC07-006** | Configurar AssessmentWindow    | Academic Coordinator   |
| **UC-EC07-007** | Vincular outcome               | Academic Designer      |
| **UC-EC07-008** | Vincular rúbrica/escala        | Academic Designer      |
| **UC-EC07-009** | Configurar attempts            | Academic Governance    |
| **UC-EC07-010** | Validar plan                   | Academic Designer      |
| **UC-EC07-011** | Solicitar revisión             | Academic Designer      |
| **UC-EC07-012** | Aprobar/Rechazar plan          | Academic Approver      |
| **UC-EC07-013** | Publicar AssessmentPlan        | Academic Publisher     |
| **UC-EC07-014** | Cerrar AssessmentPlan          | Academic Governance    |
| **UC-EC07-015** | Crear EvaluationGroup          | Instructor/Coordinator |
| **UC-EC07-016** | Gestionar membership           | Instructor/Coordinator |
| **UC-EC07-017** | Crear ParticipantEvaluation    | System/Coordinator     |
| **UC-EC07-018** | Registrar Attempt manual       | Instructor             |
| **UC-EC07-019** | Registrar Attempt participante | Participant            |
| **UC-EC07-020** | Recibir Attempt LMS            | CT-18 Adapter          |
| **UC-EC07-021** | Adjuntar evidence ref          | Instructor/Participant |
| **UC-EC07-022** | Aceptar/Rechazar Attempt       | Instructor             |
| **UC-EC07-023** | Invalidar Attempt              | Academic Governance    |
| **UC-EC07-024** | Registrar ScoreFact manual     | Instructor             |
| **UC-EC07-025** | Importar scores batch          | Academic Operator      |
| **UC-EC07-026** | Recibir grade externo          | CT-18 Adapter          |
| **UC-EC07-027** | Normalizar score               | System                 |
| **UC-EC07-028** | Adjudicar ResultFact           | System/Instructor      |
| **UC-EC07-029** | Publicar resultado             | Academic Evaluator     |
| **UC-EC07-030** | Consultar current result       | Participant/Staff      |
| **UC-EC07-031** | Consultar result lineage       | Auditor/Staff          |
| **UC-EC07-032** | Solicitar regrade              | Participant/Instructor |
| **UC-EC07-033** | Crear AdjustmentRequest        | Authorized Staff       |
| **UC-EC07-034** | Decidir ajuste                 | Academic Approver      |
| **UC-EC07-035** | Aplicar AdjustmentDecision     | Academic Evaluator     |
| **UC-EC07-036** | Crear AppealCase               | Participant/Staff      |
| **UC-EC07-037** | Evaluar admisibilidad          | Academic Governance    |
| **UC-EC07-038** | Resolver appeal                | Appeal Committee       |
| **UC-EC07-039** | Aplicar AppealDecision         | Academic Evaluator     |
| **UC-EC07-040** | Reconciliar result externo     | Ops                    |
| **UC-EC07-041** | Calcular CompletionEvaluation  | System/Coordinator     |
| **UC-EC07-042** | Recalcular completion          | System                 |
| **UC-EC07-043** | Consultar RuleFacts            | Staff/Participant      |
| **UC-EC07-044** | Publicar CompletionFact        | Academic Governance    |
| **UC-EC07-045** | Restate CompletionFact         | Academic Governance    |
| **UC-EC07-046** | Consultar current completion   | EC-08/Staff            |
| **UC-EC07-047** | Crear AcademicClosure          | Academic Coordinator   |
| **UC-EC07-048** | Ejecutar closure preflight     | Academic Coordinator   |
| **UC-EC07-049** | Crear ClosureHold              | System/Staff           |
| **UC-EC07-050** | Resolver ClosureHold           | Authorized Staff       |
| **UC-EC07-051** | Cerrar edición/cohorte         | Academic Governance    |
| **UC-EC07-052** | Consultar ClosureReceipt       | Auditor/Staff          |
| **UC-EC07-053** | Reabrir scope                  | Academic Governance    |
| **UC-EC07-054** | Recerrar luego corrección      | Academic Governance    |
| **UC-EC07-055** | Reconciliar downstream         | Ops                    |
| **UC-EC07-056** | Consultar OperationStatus      | Frontend/Ops           |
| **UC-EC07-057** | Reconciliar UNKNOWN_EFFECT     | Ops/System             |
| **UC-EC07-058** | Solicitar asistencia IA        | Instructor/Reviewer    |
| **UC-EC07-059** | Aceptar/Rechazar sugerencia IA | Instructor/Reviewer    |
| **UC-EC07-060** | Detectar anomalías             | QA/Reviewer            |
| **UC-EC07-061** | Exportar Evidence Pack         | Auditor                |
| **UC-EC07-062** | Dry-run migración              | Data Steward           |
| **UC-EC07-063** | Promover batch migrado         | Data Steward           |
| **UC-EC07-064** | Validar RLS                    | Security/QA            |
| **UC-EC07-065** | Gestionar accommodation ref    | Coordinator            |
| **UC-EC07-066** | Reprocesar LMS duplicado       | Ops                    |
| **UC-EC07-067** | Procesar LMS tardío            | Ops/Governance         |
| **UC-EC07-068** | Bulk grade dry-run             | Academic Operator      |
| **UC-EC07-069** | Bulk grade promote             | Academic Operator      |
| **UC-EC07-070** | Dashboard pendientes           | Coordinator            |
| **UC-EC07-071** | Readiness cierre               | Coordinator            |
| **UC-EC07-072** | Void excepcional               | Academic Governance    |

## 10.1 Casos críticos desarrollados

### UC-EC07-013 — Publicar AssessmentPlan

| **Aspecto**                   | **Detalle**                                                             |
|-------------------------------|-------------------------------------------------------------------------|
| Actor                         | Academic Publisher                                                      |
| Trigger                       | Plan aprobado                                                           |
| Precondiciones / autorización | APPROVED; step-up; validation PASS; refs resolubles                     |
| Happy Path                    | Lock → revalidar → freeze snapshot → PUBLISHED → audit+outbox → commit. |
| Alternativas / errores        | Dependency unavailable 503; concurrent publish 409/412.                 |
| Idempotencia                  | Idempotency-Key.                                                        |
| Concurrencia                  | If-Match + lock.                                                        |
| Auditoría / side effects      | Audit/hash/policy/assurance.                                            |
| Postcondición                 | Plan inmutable.                                                         |

### UC-EC07-020 — Recibir Attempt LMS

| **Aspecto**                   | **Detalle**                                                    |
|-------------------------------|----------------------------------------------------------------|
| Actor                         | CT-18 Adapter                                                  |
| Trigger                       | Evento LMS                                                     |
| Precondiciones / autorización | Contract version; messageId/tenant/source                      |
| Happy Path                    | Inbox dedup → mapping → receipt/hash → Attempt → source trust. |
| Alternativas / errores        | Ambiguo =\> quarantine; timeout =\> UNKNOWN_EFFECT.            |
| Idempotencia                  | messageId dedup.                                               |
| Concurrencia                  | No duplicate attempt.                                          |
| Auditoría / side effects      | Audit/correlation.                                             |
| Postcondición                 | Attempt o quarantine.                                          |

### UC-EC07-028 — Adjudicar ResultFact

| **Aspecto**                   | **Detalle**                                                                              |
|-------------------------------|------------------------------------------------------------------------------------------|
| Actor                         | System/Evaluator                                                                         |
| Trigger                       | Attempts listos                                                                          |
| Precondiciones / autorización | PUBLISHED plan + policy/scale                                                            |
| Happy Path                    | Seleccionar attempts → normalize BigDecimal → apply policy → append ResultFact → outbox. |
| Alternativas / errores        | Policy missing 422/503; conflict 412.                                                    |
| Idempotencia                  | Idempotency-Key.                                                                         |
| Concurrencia                  | Lock PE/current lineage.                                                                 |
| Auditoría / side effects      | Audit inputs/policy.                                                                     |
| Postcondición                 | Current derivable.                                                                       |

### UC-EC07-035 — Aplicar AdjustmentDecision

| **Aspecto**                   | **Detalle**                                     |
|-------------------------------|-------------------------------------------------|
| Actor                         | Academic Evaluator                              |
| Trigger                       | Ajuste aprobado                                 |
| Precondiciones / autorización | APPROVED; SoD; step-up                          |
| Happy Path                    | Append new facts superseding previous → outbox. |
| Alternativas / errores        | Already applied 409.                            |
| Idempotencia                  | Decision+key.                                   |
| Concurrencia                  | Lineage lock.                                   |
| Auditoría / side effects      | Audit before/after refs.                        |
| Postcondición                 | History intacta.                                |

### UC-EC07-038 — Resolver appeal

| **Aspecto**                   | **Detalle**                                   |
|-------------------------------|-----------------------------------------------|
| Actor                         | Appeal Committee                              |
| Trigger                       | Appeal under review                           |
| Precondiciones / autorización | Admisible; CT-06; SoD                         |
| Happy Path                    | Emitir decision; effect por command separado. |
| Alternativas / errores        | Insufficient evidence =\> blocked.            |
| Idempotencia                  | Idempotent.                                   |
| Concurrencia                  | ETag case.                                    |
| Auditoría / side effects      | Audit committee/evidence.                     |
| Postcondición                 | Decision durable.                             |

### UC-EC07-041 — Calcular CompletionEvaluation

| **Aspecto**                   | **Detalle**                                    |
|-------------------------------|------------------------------------------------|
| Actor                         | System/Coordinator                             |
| Trigger                       | Inputs maduros                                 |
| Precondiciones / autorización | Enrollment + pinned policy + EC-06 facts       |
| Happy Path                    | Snapshot inputs → rule facts → candidate/hash. |
| Alternativas / errores        | UNKNOWN/STALE =\> BLOCKED/STALE.               |
| Idempotencia                  | Input-hash idempotent.                         |
| Concurrencia                  | Snapshot-aware.                                |
| Auditoría / side effects      | Audit refs.                                    |
| Postcondición                 | Evaluation explicable.                         |

### UC-EC07-044 — Publicar CompletionFact

| **Aspecto**                   | **Detalle**                                              |
|-------------------------------|----------------------------------------------------------|
| Actor                         | Academic Governance                                      |
| Trigger                       | Evaluation EVALUATED                                     |
| Precondiciones / autorización | Terminal rules; inputs current                           |
| Happy Path                    | Lock → revalidate hash → append CompletionFact → outbox. |
| Alternativas / errores        | INPUT_CHANGED 409.                                       |
| Idempotencia                  | Idempotency-Key.                                         |
| Concurrencia                  | Lineage + If-Match.                                      |
| Auditoría / side effects      | High assurance audit.                                    |
| Postcondición                 | Fact oficial.                                            |

### UC-EC07-051 — Cerrar edición/cohorte

| **Aspecto**                   | **Detalle**                                         |
|-------------------------------|-----------------------------------------------------|
| Actor                         | Academic Governance                                 |
| Trigger                       | Closure READY                                       |
| Precondiciones / autorización | Preflight PASS; no blocking holds                   |
| Happy Path                    | Lock → revalidate counts → CLOSED → receipt+outbox. |
| Alternativas / errores        | Pending/unavailable =\> hold/503.                   |
| Idempotencia                  | Idempotency-Key.                                    |
| Concurrencia                  | Unique current+ETag.                                |
| Auditoría / side effects      | Audit/evidence pack.                                |
| Postcondición                 | Cierre oficial.                                     |

### UC-EC07-053 — Reabrir scope

| **Aspecto**                   | **Detalle**                               |
|-------------------------------|-------------------------------------------|
| Actor                         | Academic Governance                       |
| Trigger                       | Error tardío                              |
| Precondiciones / autorización | CLOSED; workflow; reason; step-up         |
| Happy Path                    | Nuevo closure cycle; old receipt intacto. |
| Alternativas / errores        | Unauthorized 403.                         |
| Idempotencia                  | Idempotent.                               |
| Concurrencia                  | Lineage lock.                             |
| Auditoría / side effects      | Exceptional audit.                        |
| Postcondición                 | Nuevo cycle activo.                       |

### UC-EC07-057 — Reconciliar UNKNOWN_EFFECT

| **Aspecto**                   | **Detalle**                                                          |
|-------------------------------|----------------------------------------------------------------------|
| Actor                         | Ops/System                                                           |
| Trigger                       | Timeout externo                                                      |
| Precondiciones / autorización | Receipt/correlation                                                  |
| Happy Path                    | Query status → APPLIED/NOT_APPLIED/UNKNOWN → retry solo NOT_APPLIED. |
| Alternativas / errores        | Provider down =\> keep UNKNOWN.                                      |
| Idempotencia                  | Idempotent.                                                          |
| Concurrencia                  | Lease.                                                               |
| Auditoría / side effects      | Ops audit.                                                           |
| Postcondición                 | No double effect.                                                    |

# 11. DER conceptual, lógico y físico

## 11.1 DER conceptual

AssessmentPlan agrega componentes, windows y rubric bindings. ParticipantEvaluation conserva attempts y hechos de score/result. Adjustments y appeals generan decisiones separadas. CompletionEvaluation produce rule facts y CompletionFact. AcademicClosure agrega preflight, holds y receipt.

## 11.2 DER lógico

Las relaciones internas EC-07 son tenant-aware. Referencias a EC-01…EC-06/CT/IAM son EXT REF sin FK física. Facts de lineage solo pueden superseder facts del mismo participant/component/scope.

## 11.3 DER físico resumido

<img src="media/image4.png" style="width:6.65in;height:3.67233in" />

Figura 4 — DER físico resumido EC-07

| **REGLA DE FK —** Todas las FKs físicas del esquema ec07 son internas y tenant-aware. EC-01…EC-06, CT-01…CT-18, IAM, Finanzas y EC-08 se consumen mediante EXT REF y contratos. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 12. Modelo físico PostgreSQL tabla por tabla

El esquema propuesto es ec07. PostgreSQL es Source of Truth transaccional. Todas las tablas tenant-owned aplican RLS ENABLE+FORCE. Los facts oficiales se protegen con triggers/revokes append-only.

| **PREGUNTA OBLIGATORIA —** Para cada tabla: “¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug?”. PK, FK, UNIQUE, CHECK, índices parciales, RLS y triggers forman parte del dominio ejecutable. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.1 ec07_assessment_plan

QUÉ REPRESENTA — Representa la definición operativa versionada de evaluación para una edición/cohorte. Pinnea el diseño académico y políticas que determinan cómo se calcularán resultados.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Lo crea Academic Coordination a partir de ProgramVersion/Edition. Es Aggregate Root; AssessmentComponent, windows y bindings dependen de él. ParticipantEvaluation consume un plan PUBLISHED.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege scope, revisión, estado, hash y snapshot de policies. No representa una evaluación individual ni un resultado.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                              | **Ejemplo**          |
|---------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------|----------------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant autorizado y clave de aislamiento.                    | 8a6…                 |
| **assessment_plan_id**    | uuid                | NO       | gen_random_uuid() | PK            | ID técnico estable del plan.                                 | ap…                  |
| **edition_ref**           | uuid                | NO       | —                 | EXT REF EC-02 | Edición académica a la que aplica.                           | ed…                  |
| **cohort_ref**            | uuid                | YES      | NULL              | EXT REF EC-02 | Cohorte concreta cuando el plan no aplica a toda la edición. | coh…                 |
| **program_version_ref**   | uuid                | NO       | —                 | EXT REF EC-01 | ProgramVersion pinneada.                                     | pv…                  |
| **plan_no**               | integer             | NO       | 1                 | UQ/CHECK      | Número/revisión monotónica por scope.                        | 1                    |
| **official_name**         | varchar(200)        | NO       | —                 | —             | Nombre operativo oficial del plan.                           | Evaluación Cohorte A |
| **state**                 | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/IN_REVIEW/APPROVED/PUBLISHED/CLOSED/VOID.              | PUBLISHED            |
| **grading_policy_ref**    | uuid                | NO       | —                 | EXT REF CT-02 | PolicyVersion de adjudicación/ponderación.                   | pol…                 |
| **completion_policy_ref** | uuid                | NO       | —                 | EXT REF CT-02 | PolicyVersion de completion académico.                       | pol…                 |
| **policy_snapshot**       | jsonb               | NO       | '{}'::jsonb       | CHECK         | Snapshot de refs/versiones para reconstrucción.              | {…}                  |
| **workflow_ref**          | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow de review/approval.                                 | wf…                  |
| **content_hash**          | varchar(128)        | YES      | NULL              | —             | Hash canónico al publicar.                                   | sha256:…             |
| **published_at**          | timestamptz         | YES      | NULL              | —             | Instante UTC de publicación.                                 | 2026-10-01T12:00Z    |
| **published_by_subject**  | uuid                | YES      | NULL              | EXT REF IAM   | Actor publisher.                                             | usr…                 |
| **created_by_subject**    | uuid                | NO       | —                 | EXT REF IAM   | Actor creador.                                               | usr…                 |
| **created_at**            | timestamptz         | NO       | now()             | —             | Creación UTC.                                                | …                    |
| **updated_at**            | timestamptz         | NO       | now()             | —             | Última mutación editable.                                    | …                    |
| **version**               | bigint              | NO       | 0                 | —             | Aggregate revision / JPA @Version.                           | 7                    |

### Explicación individual de atributos

**tenant_id —** Tenant autorizado y clave de aislamiento. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a6….

**assessment_plan_id —** ID técnico estable del plan. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ap….

**edition_ref —** Edición académica a la que aplica. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: ed….

**cohort_ref —** Cohorte concreta cuando el plan no aplica a toda la edición. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: coh….

**program_version_ref —** ProgramVersion pinneada. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pv….

**plan_no —** Número/revisión monotónica por scope. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 1.

**official_name —** Nombre operativo oficial del plan. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: Evaluación Cohorte A.

**state —** DRAFT/IN_REVIEW/APPROVED/PUBLISHED/CLOSED/VOID. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: PUBLISHED.

**grading_policy_ref —** PolicyVersion de adjudicación/ponderación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pol….

**completion_policy_ref —** PolicyVersion de completion académico. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pol….

**policy_snapshot —** Snapshot de refs/versiones para reconstrucción. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: {…}.

**workflow_ref —** Workflow de review/approval. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: wf….

**content_hash —** Hash canónico al publicar. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**published_at —** Instante UTC de publicación. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-10-01T12:00Z.

**published_by_subject —** Actor publisher. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**created_by_subject —** Actor creador. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**created_at —** Creación UTC. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**updated_at —** Última mutación editable. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**version —** Aggregate revision / JPA @Version. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se mapea @Version y un ETag obsoleto produce 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                      | **Tipo** | **Definición/expresión**        | **Error que impide**                                                                                       |
|----------------------------------------|----------|---------------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_assessment_plan                | PK       | (tenant_id, assessment_plan_id) | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_assessment_plan_scope_no       | UNIQUE   | scope + plan_no                 | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_assessment_plan_state          | CHECK    | state lifecycle                 | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_assessment_plan_publish_fields | CHECK    | published fields coherent       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_assessment_plan_transition    | TRIGGER  | state transition guard          | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_assessment_plan_immutability  | TRIGGER  | PUBLISHED/CLOSED immutable      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir revisiones duplicadas, estados inválidos y mutación de un plan publicado/cerrado. |
|------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec07_assessment_component

QUÉ REPRESENTA — Representa una unidad evaluativa dentro de AssessmentPlan: examen, proyecto, quiz, presentación, práctica u otra tipología parametrizada.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo del AssessmentPlan. Define peso, obligatoriedad, selección de attempts y referencias a políticas/rúbricas. Sus cambios incrementan la revisión del root.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege unicidad, orden, peso y compatibilidad con el plan. No representa un attempt ni un resultado.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                           | **Ejemplo**    |
|-----------------------------|---------------------|----------|-------------------|---------------------|-------------------------------------------|----------------|
| **tenant_id**               | uuid                | NO       | —                 | PK\*                | Tenant.                                   | 8a…            |
| **assessment_component_id** | uuid                | NO       | gen_random_uuid() | PK                  | ID del componente.                        | ac…            |
| **assessment_plan_id**      | uuid                | NO       | —                 | FK                  | Plan padre tenant-aware.                  | ap…            |
| **component_code**          | varchar(64)         | NO       | —                 | UQ                  | Código estable dentro del plan.           | FINAL_PROJECT  |
| **assessment_type_code**    | varchar(80)         | NO       | —                 | EXT REF CT-02       | Tipo parametrizado.                       | PROJECT        |
| **title**                   | varchar(200)        | NO       | —                 | —                   | Título canónico.                          | Proyecto final |
| **weight_value**            | numeric(9,4)        | YES      | NULL              | CHECK               | Peso exacto; NULL si modelo no ponderado. | 40.0000        |
| **mandatory**               | boolean             | NO       | true              | —                   | Componente obligatorio.                   | true           |
| **attempt_policy_ref**      | uuid                | NO       | —                 | EXT REF CT-02       | PolicyVersion de intentos/reintentos.     | pol…           |
| **selection_policy_ref**    | uuid                | NO       | —                 | EXT REF CT-02       | BEST/LAST/etc versionado.                 | pol…           |
| **grading_scale_ref**       | uuid                | NO       | —                 | EXT REF CT-02       | Escala versionada.                        | scale…         |
| **rubric_ref**              | uuid                | YES      | NULL              | EXT REF CT-05/CT-02 | Rúbrica/version ref.                      | rub…           |
| **sequence_no**             | integer             | NO       | —                 | CHECK/UQ            | Orden positivo.                           | 1              |
| **created_at**              | timestamptz         | NO       | now()             | —                   | Creación.                                 | …              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**assessment_component_id —** ID del componente. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ac….

**assessment_plan_id —** Plan padre tenant-aware. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ap….

**component_code —** Código estable dentro del plan. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: FINAL_PROJECT.

**assessment_type_code —** Tipo parametrizado. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: PROJECT.

**title —** Título canónico. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: Proyecto final.

**weight_value —** Peso exacto; NULL si modelo no ponderado. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Backend usa BigDecimal con rounding explícito; no double. Ejemplo: 40.0000.

**mandatory —** Componente obligatorio. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: true.

**attempt_policy_ref —** PolicyVersion de intentos/reintentos. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pol….

**selection_policy_ref —** BEST/LAST/etc versionado. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pol….

**grading_scale_ref —** Escala versionada. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: scale….

**rubric_ref —** Rúbrica/version ref. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: rub….

**sequence_no —** Orden positivo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 1.

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|--------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_assessment_component   | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_component_plan         | FK       | tenant-aware plan        | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_component_code         | UNIQUE   | plan + component_code    | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_component_order        | UNIQUE   | plan + sequence_no       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_component_weight       | CHECK    | weight \>= 0             | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_plan_child_mutability | TRIGGER  | plan DRAFT + bump root   | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir duplicar códigos/orden, pesos negativos y modificar componentes de un plan publicado. |
|----------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec07_component_outcome_binding

QUÉ REPRESENTA — Vincula un AssessmentComponent con un outcome publicado de EC-01 para trazabilidad de aprendizaje.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo del componente y se usa en reporting/evidence pack. outcome_ref es EXT REF validado por contrato.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege duplicados del mismo outcome. No crea ni modifica outcomes.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**        | **Ejemplo** |
|-----------------------------|---------------------|----------|-------------------|---------------|------------------------|-------------|
| **tenant_id**               | uuid                | NO       | —                 | PK\*          | Tenant.                | 8a…         |
| **binding_id**              | uuid                | NO       | gen_random_uuid() | PK            | ID binding.            | bnd…        |
| **assessment_component_id** | uuid                | NO       | —                 | FK            | Componente.            | ac…         |
| **outcome_ref**             | uuid                | NO       | —                 | EXT REF EC-01 | Outcome pinneado.      | out…        |
| **contribution_code**       | varchar(40)         | YES      | NULL              | EXT REF CT-02 | Nivel de contribución. | MAJOR       |
| **created_at**              | timestamptz         | NO       | now()             | —             | Creación.              | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**binding_id —** ID binding. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: bnd….

**assessment_component_id —** Componente. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ac….

**outcome_ref —** Outcome pinneado. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: out….

**contribution_code —** Nivel de contribución. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: MAJOR.

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|-----------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_component_outcome_binding | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_binding_component         | FK       | component same tenant    | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_binding_outcome           | UNIQUE   | component + outcome      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_plan_child_mutability    | TRIGGER  | parent plan editable     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir binding duplicado y referencia interna a componente de otro tenant. |
|----------------------------------------------------------------------------------------------------------------------|

## 12.4 ec07_assessment_window

QUÉ REPRESENTA — Define la ventana operativa en la que un AssessmentComponent acepta attempts.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo de AssessmentPlan/Component. Puede referenciar calendar externo, pero conserva open/close UTC para enforcement.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege coherencia temporal y edición solo antes de publicación. No crea sesiones EC-02.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**               | **Ejemplo**       |
|-----------------------------|---------------------|----------|-------------------|---------------|-------------------------------|-------------------|
| **tenant_id**               | uuid                | NO       | —                 | PK\*          | Tenant.                       | 8a…               |
| **assessment_window_id**    | uuid                | NO       | gen_random_uuid() | PK            | ID ventana.                   | aw…               |
| **assessment_component_id** | uuid                | NO       | —                 | FK            | Componente.                   | ac…               |
| **open_at**                 | timestamptz         | YES      | NULL              | CHECK         | Inicio UTC.                   | 2026-10-10T12:00Z |
| **close_at**                | timestamptz         | YES      | NULL              | CHECK         | Fin UTC.                      | 2026-10-12T23:59Z |
| **grace_policy_ref**        | uuid                | YES      | NULL              | EXT REF CT-02 | Policy de tolerancia/late.    | pol…              |
| **calendar_ref**            | uuid                | YES      | NULL              | EXT REF CT-03 | Referencia temporal opcional. | cal…              |
| **created_at**              | timestamptz         | NO       | now()             | —             | Creación.                     | …                 |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**assessment_window_id —** ID ventana. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: aw….

**assessment_component_id —** Componente. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ac….

**open_at —** Inicio UTC. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-10-10T12:00Z.

**close_at —** Fin UTC. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-10-12T23:59Z.

**grace_policy_ref —** Policy de tolerancia/late. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pol….

**calendar_ref —** Referencia temporal opcional. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: cal….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|--------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_assessment_window      | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_window_component       | FK       | component tenant-aware   | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_window_range           | CHECK    | close\>=open             | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_plan_child_mutability | TRIGGER  | parent plan editable     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir ventanas invertidas y cambios posteriores a la publicación del plan. |
|-----------------------------------------------------------------------------------------------------------------------|

## 12.5 ec07_rubric_binding

QUÉ REPRESENTA — Materializa la referencia versionada de rúbrica/escala aplicada por componente.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Permite pinning para reconstrucción. El artefacto o plantilla puede residir en CT-05/CT-02.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege que una evaluación histórica no salte a la última rúbrica. No almacena documento completo.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**               | **Ejemplo** |
|-----------------------------|---------------------|----------|-------------------|---------------|-------------------------------|-------------|
| **tenant_id**               | uuid                | NO       | —                 | PK\*          | Tenant.                       | 8a…         |
| **rubric_binding_id**       | uuid                | NO       | gen_random_uuid() | PK            | ID binding.                   | rb…         |
| **assessment_component_id** | uuid                | NO       | —                 | FK            | Componente.                   | ac…         |
| **rubric_ref**              | uuid                | NO       | —                 | EXT REF       | Versión inmutable de rúbrica. | rub…        |
| **scale_ref**               | uuid                | NO       | —                 | EXT REF CT-02 | Escala versionada.            | scale…      |
| **binding_hash**            | varchar(128)        | YES      | NULL              | —             | Hash snapshot/contract.       | sha256:…    |
| **created_at**              | timestamptz         | NO       | now()             | —             | Creación.                     | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**rubric_binding_id —** ID binding. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: rb….

**assessment_component_id —** Componente. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ac….

**rubric_ref —** Versión inmutable de rúbrica. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: rub….

**scale_ref —** Escala versionada. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: scale….

**binding_hash —** Hash snapshot/contract. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión**   | **Error que impide**                                                                                       |
|--------------------------------|----------|----------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_rubric_binding         | PK       | tenant_id + id             | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_rubric_component       | FK       | component tenant-aware     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_rubric_per_component   | UNIQUE   | component + rubric + scale | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_plan_child_mutability | TRIGGER  | plan editable              | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir bindings equivalentes duplicados y cambiar rúbrica de un plan publicado. |
|---------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec07_evaluation_group

QUÉ REPRESENTA — Representa un grupo temporal usado para una evaluación grupal concreta.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Lo crea instructor/coordinator para un componente. Membership se congela al submit del attempt grupal y sirve de provenance.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad del grupo dentro del scope. No reemplaza cohortes ni grupos académicos transversales.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**     | **Ejemplo** |
|-----------------------------|---------------------|----------|-------------------|-------------|---------------------|-------------|
| **tenant_id**               | uuid                | NO       | —                 | PK\*        | Tenant.             | 8a…         |
| **evaluation_group_id**     | uuid                | NO       | gen_random_uuid() | PK          | ID grupo.           | grp…        |
| **assessment_plan_id**      | uuid                | NO       | —                 | FK          | Plan scope.         | ap…         |
| **assessment_component_id** | uuid                | NO       | —                 | FK          | Componente grupal.  | ac…         |
| **group_code**              | varchar(64)         | NO       | —                 | UQ          | Código legible.     | G01         |
| **state**                   | varchar(20)         | NO       | 'ACTIVE'          | CHECK       | ACTIVE/FROZEN/VOID. | FROZEN      |
| **created_by_subject**      | uuid                | NO       | —                 | EXT REF IAM | Actor creador.      | usr…        |
| **created_at**              | timestamptz         | NO       | now()             | —           | Creación.           | …           |
| **version**                 | bigint              | NO       | 0                 | —           | Optimistic lock.    | 2           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**evaluation_group_id —** ID grupo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: grp….

**assessment_plan_id —** Plan scope. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ap….

**assessment_component_id —** Componente grupal. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ac….

**group_code —** Código legible. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: G01.

**state —** ACTIVE/FROZEN/VOID. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: FROZEN.

**created_by_subject —** Actor creador. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**version —** Optimistic lock. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se mapea @Version y un ETag obsoleto produce 412 PRECONDITION_FAILED. Ejemplo: 2.

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**   | **Error que impide**                                                                                       |
|------------------------------|----------|----------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_evaluation_group     | PK       | tenant_id + id             | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_group_code           | UNIQUE   | component + group_code     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_group_state          | CHECK    | state lifecycle            | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_group_plan_component | FK       | same plan/component tenant | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir grupos duplicados, scope inconsistente y mutación cuando está FROZEN. |
|------------------------------------------------------------------------------------------------------------------------|

## 12.7 ec07_evaluation_group_member

QUÉ REPRESENTA — Snapshot de membership de un EvaluationGroup.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Relaciona enrollment_ref EC-04 con group. Antes de FROZEN se modifica; después queda inmutable salvo rebuild gobernado.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege que un enrollment no aparezca duplicado. No almacena PII.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**      | **Ejemplo** |
|-------------------------|---------------------|----------|-------------------|---------------|----------------------|-------------|
| **tenant_id**           | uuid                | NO       | —                 | PK\*          | Tenant.              | 8a…         |
| **group_member_id**     | uuid                | NO       | gen_random_uuid() | PK            | ID miembro.          | gm…         |
| **evaluation_group_id** | uuid                | NO       | —                 | FK            | Grupo.               | grp…        |
| **enrollment_ref**      | uuid                | NO       | —                 | EXT REF EC-04 | Enrollment.          | enr…        |
| **member_role_code**    | varchar(40)         | YES      | NULL              | EXT REF CT-02 | Rol grupal opcional. | LEAD        |
| **joined_at**           | timestamptz         | NO       | now()             | —             | Incorporación.       | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**group_member_id —** ID miembro. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: gm….

**evaluation_group_id —** Grupo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: grp….

**enrollment_ref —** Enrollment. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: enr….

**member_role_code —** Rol grupal opcional. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: LEAD.

**joined_at —** Incorporación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**               | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|---------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_evaluation_group_member | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_group_member_group      | FK       | group tenant-aware       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_group_member            | UNIQUE   | group + enrollment       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_group_membership_guard | TRIGGER  | parent ACTIVE only       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir membership duplicada/cross-tenant y cambios cuando grupo está congelado. |
|---------------------------------------------------------------------------------------------------------------------------|

## 12.8 ec07_participant_evaluation

QUÉ REPRESENTA — Representa el estado operativo de evaluación de un enrollment bajo un AssessmentPlan.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es Aggregate Root para attempts y readiness individual. Se crea idempotentemente al iniciar evaluación o preprovisionar roster.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege relación única enrollment+plan y concurrencia. No es ResultFact ni CompletionFact.

| **Campo**                     | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                         | **Ejemplo** |
|-------------------------------|---------------------|----------|-------------------|--------------------|-------------------------------------------------------------------------|-------------|
| **tenant_id**                 | uuid                | NO       | —                 | PK\*               | Tenant.                                                                 | 8a…         |
| **participant_evaluation_id** | uuid                | NO       | gen_random_uuid() | PK                 | ID aggregate.                                                           | pe…         |
| **assessment_plan_id**        | uuid                | NO       | —                 | FK                 | Plan PUBLISHED.                                                         | ap…         |
| **enrollment_ref**            | uuid                | NO       | —                 | EXT REF EC-04      | Enrollment individual.                                                  | enr…        |
| **state**                     | varchar(32)         | NO       | 'PENDING'         | CHECK              | PENDING/ACTIVE/READY_FOR_ADJUDICATION/ADJUDICATED/FINAL/SUSPENDED/VOID. | ACTIVE      |
| **accommodation_ref**         | uuid                | YES      | NULL              | EXT REF governance | Accommodation autorizada.                                               | acc…        |
| **started_at**                | timestamptz         | YES      | NULL              | —                  | Inicio operativo.                                                       | …           |
| **finalized_at**              | timestamptz         | YES      | NULL              | —                  | Finalización aggregate.                                                 | …           |
| **created_at**                | timestamptz         | NO       | now()             | —                  | Creación.                                                               | …           |
| **updated_at**                | timestamptz         | NO       | now()             | —                  | Actualización.                                                          | …           |
| **version**                   | bigint              | NO       | 0                 | —                  | Aggregate revision.                                                     | 5           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**participant_evaluation_id —** ID aggregate. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: pe….

**assessment_plan_id —** Plan PUBLISHED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ap….

**enrollment_ref —** Enrollment individual. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: enr….

**state —** PENDING/ACTIVE/READY_FOR_ADJUDICATION/ADJUDICATED/FINAL/SUSPENDED/VOID. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ACTIVE.

**accommodation_ref —** Accommodation autorizada. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: acc….

**started_at —** Inicio operativo. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**finalized_at —** Finalización aggregate. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**updated_at —** Actualización. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**version —** Aggregate revision. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se mapea @Version y un ETag obsoleto produce 412 PRECONDITION_FAILED. Ejemplo: 5.

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|--------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_participant_evaluation | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_pe_plan                | FK       | plan tenant-aware        | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_pe_plan_enrollment     | UNIQUE   | plan + enrollment        | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_pe_state               | CHECK    | state lifecycle          | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_pe_transition         | TRIGGER  | allowed transitions      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir dos aggregates para el mismo enrollment+plan, states inválidos y escrituras cross-tenant. |
|--------------------------------------------------------------------------------------------------------------------------------------------|

## 12.9 ec07_attempt

QUÉ REPRESENTA — Representa una ocurrencia evaluativa de un participant evaluation o group attempt.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea por UI, import o adapter CT-18. Preserva attempt_no, source, timestamps y status. Accepted/invalidated quedan históricos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege secuencia de intentos y deduplicación de source receipt. No representa resultado final.

| **Campo**                     | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                  | **Ejemplo**    |
|-------------------------------|---------------------|----------|-------------------|-----------|--------------------------------------------------|----------------|
| **tenant_id**                 | uuid                | NO       | —                 | PK\*      | Tenant.                                          | 8a…            |
| **attempt_id**                | uuid                | NO       | gen_random_uuid() | PK        | ID intento.                                      | att…           |
| **participant_evaluation_id** | uuid                | YES      | NULL              | FK        | Evaluación individual si no group.               | pe…            |
| **evaluation_group_id**       | uuid                | YES      | NULL              | FK        | Grupo si attempt grupal.                         | grp…           |
| **assessment_component_id**   | uuid                | NO       | —                 | FK        | Componente.                                      | ac…            |
| **attempt_no**                | integer             | NO       | —                 | CHECK/UQ  | Número positivo.                                 | 2              |
| **source_type**               | varchar(32)         | NO       | 'MANUAL'          | CHECK     | MANUAL/PARTICIPANT/LMS/IMPORT/API.               | LMS            |
| **source_receipt_ref**        | varchar(160)        | YES      | NULL              | UQ        | ID remoto/idempotent source.                     | moodle:987     |
| **occurred_at**               | timestamptz         | YES      | NULL              | —         | Instante origen.                                 | …              |
| **received_at**               | timestamptz         | NO       | now()             | —         | Recepción local.                                 | …              |
| **submitted_at**              | timestamptz         | YES      | NULL              | —         | Submit efectivo.                                 | …              |
| **state**                     | varchar(24)         | NO       | 'CREATED'         | CHECK     | CREATED/SUBMITTED/ACCEPTED/REJECTED/INVALIDATED. | ACCEPTED       |
| **late_flag**                 | boolean             | NO       | false             | —         | Late según policy.                               | false          |
| **reason_code**               | varchar(80)         | YES      | NULL              | —         | Reason reject/invalidate.                        | OUTSIDE_WINDOW |
| **payload_hash**              | varchar(128)        | YES      | NULL              | —         | Hash payload/receipt.                            | sha256:…       |
| **created_at**                | timestamptz         | NO       | now()             | —         | Creación.                                        | …              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**attempt_id —** ID intento. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: att….

**participant_evaluation_id —** Evaluación individual si no group. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: pe….

**evaluation_group_id —** Grupo si attempt grupal. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: grp….

**assessment_component_id —** Componente. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ac….

**attempt_no —** Número positivo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 2.

**source_type —** MANUAL/PARTICIPANT/LMS/IMPORT/API. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: LMS.

**source_receipt_ref —** ID remoto/idempotent source. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: moodle:987.

**occurred_at —** Instante origen. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**received_at —** Recepción local. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**submitted_at —** Submit efectivo. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**state —** CREATED/SUBMITTED/ACCEPTED/REJECTED/INVALIDATED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ACCEPTED.

**late_flag —** Late según policy. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: false.

**reason_code —** Reason reject/invalidate. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: OUTSIDE_WINDOW.

**payload_hash —** Hash payload/receipt. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**          | **Tipo**     | **Definición/expresión**   | **Error que impide**                                                                                       |
|----------------------------|--------------|----------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_attempt            | PK           | tenant_id + id             | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_attempt_subject    | CHECK        | exactly one subject        | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_attempt_no         | CHECK        | attempt_no\>0              | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_attempt_individual | UNIQUE/INDEX | PE+component+attempt_no    | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_attempt_group      | UNIQUE/INDEX | group+component+attempt_no | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_attempt_receipt    | UNIQUE/INDEX | source receipt             | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_attempt_state      | CHECK        | state lifecycle            | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir doble subject, attempt_no inválido, receipt externo duplicado y states imposibles. |
|-------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec07_attempt_evidence_ref

QUÉ REPRESENTA — Registra referencias a evidencias de un Attempt.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo appendable del Attempt. CT-05 sigue siendo owner del binario. Guarda hash/role/provenance.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege deduplicación/clasificación. No contiene contenido binario.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**             | **Ejemplo** |
|-------------------------|---------------------|----------|-------------------|---------------|-----------------------------|-------------|
| **tenant_id**           | uuid                | NO       | —                 | PK\*          | Tenant.                     | 8a…         |
| **attempt_evidence_id** | uuid                | NO       | gen_random_uuid() | PK            | ID evidence link.           | ae…         |
| **attempt_id**          | uuid                | NO       | —                 | FK            | Attempt.                    | att…        |
| **evidence_ref**        | uuid                | NO       | —                 | EXT REF CT-05 | Documento/evidence externo. | doc…        |
| **evidence_type_code**  | varchar(64)         | NO       | —                 | EXT REF CT-02 | Tipo evidencia.             | SUBMISSION  |
| **content_hash**        | varchar(128)        | YES      | NULL              | —             | Hash artefacto.             | sha256:…    |
| **captured_at**         | timestamptz         | YES      | NULL              | —             | Captura/submit.             | …           |
| **created_at**          | timestamptz         | NO       | now()             | —             | Creación.                   | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**attempt_evidence_id —** ID evidence link. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ae….

**attempt_id —** Attempt. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: att….

**evidence_ref —** Documento/evidence externo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: doc….

**evidence_type_code —** Tipo evidencia. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: SUBMISSION.

**content_hash —** Hash artefacto. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**captured_at —** Captura/submit. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**  | **Error que impide**                                                                                       |
|------------------------------|----------|---------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_attempt_evidence_ref | PK       | tenant_id + id            | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_evidence_attempt     | FK       | attempt tenant-aware      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_attempt_evidence     | UNIQUE   | attempt + evidence + type | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir duplicar el mismo evidence binding y cruzar attempts de otro tenant. |
|-----------------------------------------------------------------------------------------------------------------------|

## 12.11 ec07_score_fact

QUÉ REPRESENTA — Hecho append-only de puntuación capturada/adjudicada para un Attempt. Preserva valor original y normalizado.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Lo crea evaluator autorizado o adapter confiable; ResultAdjudicator lo consume. Una corrección crea otro ScoreFact con supersedes.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege precisión, lineage y provenance. No es PASS/FAIL final.

| **Campo**                    | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**           | **Ejemplo**      |
|------------------------------|---------------------|----------|-------------------|---------------|---------------------------|------------------|
| **tenant_id**                | uuid                | NO       | —                 | PK\*          | Tenant.                   | 8a…              |
| **score_fact_id**            | uuid                | NO       | gen_random_uuid() | PK            | ID fact.                  | sf…              |
| **attempt_id**               | uuid                | NO       | —                 | FK            | Attempt.                  | att…             |
| **original_value**           | numeric(18,6)       | YES      | NULL              | —             | Valor numérico original.  | 82.500000        |
| **original_text_value**      | varchar(120)        | YES      | NULL              | —             | Valor textual original.   | A-               |
| **original_scale_ref**       | uuid                | NO       | —                 | EXT REF CT-02 | Escala origen.            | scale…           |
| **normalized_value**         | numeric(18,6)       | YES      | NULL              | CHECK         | Valor normalizado.        | 82.500000        |
| **normalized_scale_ref**     | uuid                | YES      | NULL              | EXT REF CT-02 | Escala destino.           | scale…           |
| **grading_policy_ref**       | uuid                | NO       | —                 | EXT REF CT-02 | PolicyVersion usada.      | pol…             |
| **supersedes_score_fact_id** | uuid                | YES      | NULL              | FK            | Fact anterior.            | sf-old…          |
| **source_actor_ref**         | uuid                | YES      | NULL              | EXT REF IAM   | Actor humano.             | usr…             |
| **source_type**              | varchar(32)         | NO       | —                 | CHECK         | MANUAL/LMS/IMPORT/SYSTEM. | MANUAL           |
| **reason_code**              | varchar(80)         | YES      | NULL              | —             | Reason corrección.        | REGRADE_APPROVED |
| **content_hash**             | varchar(128)        | NO       | —                 | —             | Hash canónico.            | sha256:…         |
| **recorded_at**              | timestamptz         | NO       | now()             | —             | Instante fact.            | …                |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**score_fact_id —** ID fact. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: sf….

**attempt_id —** Attempt. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: att….

**original_value —** Valor numérico original. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Backend usa BigDecimal con rounding explícito; no double. Ejemplo: 82.500000.

**original_text_value —** Valor textual original. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: A-.

**original_scale_ref —** Escala origen. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: scale….

**normalized_value —** Valor normalizado. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Backend usa BigDecimal con rounding explícito; no double. Ejemplo: 82.500000.

**normalized_scale_ref —** Escala destino. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: scale….

**grading_policy_ref —** PolicyVersion usada. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pol….

**supersedes_score_fact_id —** Fact anterior. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: sf-old….

**source_actor_ref —** Actor humano. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**source_type —** MANUAL/LMS/IMPORT/SYSTEM. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: MANUAL.

**reason_code —** Reason corrección. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: REGRADE_APPROVED.

**content_hash —** Hash canónico. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**recorded_at —** Instante fact. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**               | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|---------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_score_fact              | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_score_attempt           | FK       | attempt tenant-aware     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_score_supersedes        | FK       | score tenant-aware       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_score_value_present     | CHECK    | numeric or text value    | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_score_no_self_supersede | CHECK    | no self                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_score_append_only      | TRIGGER  | UPDATE/DELETE forbidden  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_score_lineage          | TRIGGER  | same attempt + acyclic   | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir facts sin valor, lineage cross-attempt/cíclico y UPDATE/DELETE de score oficial. |
|-----------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec07_result_fact

QUÉ REPRESENTA — Hecho académico oficial append-only de resultado de un componente para un participant evaluation.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — ResultAdjudicator lo crea a partir de ScoreFacts/Attempts y policy snapshot. Current result se deriva de lineage.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege pass/fail/status, lineage y reconstrucción. No es CompletionFact.

| **Campo**                     | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                   | **Ejemplo** |
|-------------------------------|---------------------|----------|-------------------|---------------|---------------------------------------------------|-------------|
| **tenant_id**                 | uuid                | NO       | —                 | PK\*          | Tenant.                                           | 8a…         |
| **result_fact_id**            | uuid                | NO       | gen_random_uuid() | PK            | ID fact.                                          | rf…         |
| **participant_evaluation_id** | uuid                | NO       | —                 | FK            | Evaluación individual.                            | pe…         |
| **assessment_component_id**   | uuid                | NO       | —                 | FK            | Componente.                                       | ac…         |
| **selected_attempt_ref**      | uuid                | YES      | NULL              | FK            | Attempt seleccionado.                             | att…        |
| **selected_score_fact_ref**   | uuid                | YES      | NULL              | FK            | ScoreFact seleccionado.                           | sf…         |
| **result_status**             | varchar(32)         | NO       | —                 | CHECK         | PASS/FAIL/INCOMPLETE/ABSENT/EXEMPT/NOT_EVALUATED. | PASS        |
| **final_score**               | numeric(18,6)       | YES      | NULL              | —             | Score final.                                      | 82.5        |
| **grade_code**                | varchar(64)         | YES      | NULL              | EXT REF CT-02 | Grade/letter code.                                | A           |
| **policy_snapshot**           | jsonb               | NO       | '{}'::jsonb       | —             | Policies/inputs.                                  | {…}         |
| **supersedes_result_fact_id** | uuid                | YES      | NULL              | FK            | Fact anterior.                                    | rf-old…     |
| **reason_code**               | varchar(80)         | YES      | NULL              | —             | Reason especial.                                  | REGRADE     |
| **content_hash**              | varchar(128)        | NO       | —                 | —             | Hash.                                             | sha256:…    |
| **adjudicated_by_subject**    | uuid                | YES      | NULL              | EXT REF IAM   | Actor.                                            | usr…        |
| **adjudicated_at**            | timestamptz         | NO       | now()             | —             | Instante.                                         | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**result_fact_id —** ID fact. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: rf….

**participant_evaluation_id —** Evaluación individual. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: pe….

**assessment_component_id —** Componente. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ac….

**selected_attempt_ref —** Attempt seleccionado. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: att….

**selected_score_fact_ref —** ScoreFact seleccionado. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: sf….

**result_status —** PASS/FAIL/INCOMPLETE/ABSENT/EXEMPT/NOT_EVALUATED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: PASS.

**final_score —** Score final. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Backend usa BigDecimal con rounding explícito; no double. Ejemplo: 82.5.

**grade_code —** Grade/letter code. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: A.

**policy_snapshot —** Policies/inputs. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: {…}.

**supersedes_result_fact_id —** Fact anterior. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: rf-old….

**reason_code —** Reason especial. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: REGRADE.

**content_hash —** Hash. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**adjudicated_by_subject —** Actor. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**adjudicated_at —** Instante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**           | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|-----------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_result_fact         | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_result_pe           | FK       | PE tenant-aware          | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_result_component    | FK       | component tenant-aware   | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_result_supersedes   | FK       | same scope               | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_result_status       | CHECK    | allowed statuses         | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_result_no_self      | CHECK    | no self                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_result_append_only | TRIGGER  | immutable                | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_result_lineage     | TRIGGER  | acyclic same scope       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir status inválido, lineage cross-component/cíclico y modificación destructiva del resultado oficial. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.13 ec07_result_adjustment_request

QUÉ REPRESENTA — Solicitud gobernada de corrección/regrade sobre un ResultFact.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La inicia participante/staff según permisos y se integra con CT-06. No cambia el resultado; una decisión APPLIED puede generar nuevo fact.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege separación entre solicitud y efecto académico.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**       | **Ejemplo**        |
|---------------------------|---------------------|----------|-------------------|---------------|-----------------------|--------------------|
| **tenant_id**             | uuid                | NO       | —                 | PK\*          | Tenant.               | 8a…                |
| **adjustment_request_id** | uuid                | NO       | gen_random_uuid() | PK            | ID solicitud.         | rar…               |
| **result_fact_ref**       | uuid                | NO       | —                 | FK            | ResultFact objetivo.  | rf…                |
| **request_type_code**     | varchar(64)         | NO       | —                 | EXT REF CT-02 | Tipo.                 | REGRADE            |
| **reason_code**           | varchar(80)         | NO       | —                 | —             | Motivo.               | RUBRIC_APPLICATION |
| **description**           | text                | YES      | NULL              | —             | Contexto no sensible. | …                  |
| **workflow_ref**          | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow.             | wf…                |
| **state**                 | varchar(28)         | NO       | 'DRAFT'           | CHECK         | Lifecycle solicitud.  | UNDER_REVIEW       |
| **requested_by_subject**  | uuid                | NO       | —                 | EXT REF IAM   | Solicitante.          | usr…               |
| **created_at**            | timestamptz         | NO       | now()             | —             | Creación.             | …                  |
| **version**               | bigint              | NO       | 0                 | —             | Optimistic lock.      | 1                  |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**adjustment_request_id —** ID solicitud. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: rar….

**result_fact_ref —** ResultFact objetivo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: rf….

**request_type_code —** Tipo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: REGRADE.

**reason_code —** Motivo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: RUBRIC_APPLICATION.

**description —** Contexto no sensible. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ….

**workflow_ref —** Workflow. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: wf….

**state —** Lifecycle solicitud. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: UNDER_REVIEW.

**requested_by_subject —** Solicitante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**version —** Optimistic lock. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se mapea @Version y un ETag obsoleto produce 412 PRECONDITION_FAILED. Ejemplo: 1.

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|--------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_adjustment_request     | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_adjustment_result      | FK       | result tenant-aware      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_adjustment_state       | CHECK    | lifecycle                | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_adjustment_transition | TRIGGER  | allowed transitions      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir requests huérfanos, estados inválidos y transitions fuera de workflow. |
|-------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec07_result_adjustment_decision

QUÉ REPRESENTA — Decisión formal sobre una solicitud de ajuste.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La emite actor/comité autorizado. APPROVED no cambia automáticamente result; aplicación es command idempotente separado.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege SoD, reason/evidence y unicidad de decisión terminal.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**             | **Ejemplo**        |
|-----------------------------|---------------------|----------|-------------------|---------------|-----------------------------|--------------------|
| **tenant_id**               | uuid                | NO       | —                 | PK\*          | Tenant.                     | 8a…                |
| **adjustment_decision_id**  | uuid                | NO       | gen_random_uuid() | PK            | ID decisión.                | rad…               |
| **adjustment_request_id**   | uuid                | NO       | —                 | FK            | Request.                    | rar…               |
| **decision_code**           | varchar(32)         | NO       | —                 | CHECK         | APPROVED/REJECTED/RETURNED. | APPROVED           |
| **reason_code**             | varchar(80)         | NO       | —                 | —             | Motivo.                     | EVIDENCE_CONFIRMED |
| **evidence_ref**            | uuid                | YES      | NULL              | EXT REF CT-05 | Evidence.                   | doc…               |
| **decided_by_subject**      | uuid                | NO       | —                 | EXT REF IAM   | Decisor.                    | usr…               |
| **assurance_level**         | varchar(40)         | YES      | NULL              | —             | Assurance.                  | AAL2               |
| **decided_at**              | timestamptz         | NO       | now()             | —             | Instante.                   | …                  |
| **applied_result_fact_ref** | uuid                | YES      | NULL              | FK            | Nuevo fact si aplicado.     | rf-new…            |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**adjustment_decision_id —** ID decisión. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: rad….

**adjustment_request_id —** Request. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: rar….

**decision_code —** APPROVED/REJECTED/RETURNED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: APPROVED.

**reason_code —** Motivo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: EVIDENCE_CONFIRMED.

**evidence_ref —** Evidence. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: doc….

**decided_by_subject —** Decisor. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**assurance_level —** Assurance. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: AAL2.

**decided_at —** Instante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**applied_result_fact_ref —** Nuevo fact si aplicado. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: rf-new….

### Constraints físicos implementables

| **Nombre físico**             | **Tipo** | **Definición/expresión**      | **Error que impide**                                                                                       |
|-------------------------------|----------|-------------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_adjustment_decision   | PK       | tenant_id + id                | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_decision_request      | FK       | request tenant-aware          | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_decision_request      | UNIQUE   | terminal decision per request | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_decision_code         | CHECK    | allowed                       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_decision_append_only | TRIGGER  | immutable                     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir decisiones terminales ambiguas y modificación de una resolución emitida. |
|---------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec07_appeal_case

QUÉ REPRESENTA — Caso formal de apelación contra un resultado académico.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Coordina admisibilidad y workflow CT-06. Conserva refs de result/evidence; no modifica facts.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege lifecycle, deadlines y trazabilidad de apelación.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                          | **Ejemplo**  |
|--------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------------|--------------|
| **tenant_id**            | uuid                | NO       | —                 | PK\*          | Tenant.                                                                  | 8a…          |
| **appeal_case_id**       | uuid                | NO       | gen_random_uuid() | PK            | ID case.                                                                 | apl…         |
| **result_fact_ref**      | uuid                | NO       | —                 | FK            | Result apelado.                                                          | rf…          |
| **appeal_type_code**     | varchar(64)         | NO       | —                 | EXT REF CT-02 | Tipo apelación.                                                          | GRADE_APPEAL |
| **state**                | varchar(28)         | NO       | 'SUBMITTED'       | CHECK         | SUBMITTED/ADMISSIBLE/INADMISSIBLE/UNDER_REVIEW/DECIDED/CLOSED/CANCELLED. | UNDER_REVIEW |
| **workflow_ref**         | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow.                                                                | wf…          |
| **submitted_by_subject** | uuid                | NO       | —                 | EXT REF IAM   | Solicitante.                                                             | usr…         |
| **submitted_at**         | timestamptz         | NO       | now()             | —             | Submit UTC.                                                              | …            |
| **deadline_at**          | timestamptz         | YES      | NULL              | —             | Deadline si aplica.                                                      | …            |
| **version**              | bigint              | NO       | 0                 | —             | Optimistic lock.                                                         | 1            |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**appeal_case_id —** ID case. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: apl….

**result_fact_ref —** Result apelado. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: rf….

**appeal_type_code —** Tipo apelación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: GRADE_APPEAL.

**state —** SUBMITTED/ADMISSIBLE/INADMISSIBLE/UNDER_REVIEW/DECIDED/CLOSED/CANCELLED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: UNDER_REVIEW.

**workflow_ref —** Workflow. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: wf….

**submitted_by_subject —** Solicitante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**submitted_at —** Submit UTC. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**deadline_at —** Deadline si aplica. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**version —** Optimistic lock. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se mapea @Version y un ETag obsoleto produce 412 PRECONDITION_FAILED. Ejemplo: 1.

### Constraints físicos implementables

| **Nombre físico**          | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|----------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_appeal_case        | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_appeal_result      | FK       | result tenant-aware      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_appeal_state       | CHECK    | lifecycle                | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_appeal_transition | TRIGGER  | allowed transitions      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir cases sin result, estados imposibles y mutaciones concurrentes no detectadas. |
|--------------------------------------------------------------------------------------------------------------------------------|

## 12.16 ec07_appeal_decision

QUÉ REPRESENTA — Resolución append-only de una AppealCase.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se emite al finalizar revisión. Puede indicar MAINTAIN/REASSESS/RESTATE/OTHER y referenciar evidence; cualquier efecto sobre result ocurre por command separado.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege separación decisión/efecto y evidencia de autoridad.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                  | **Ejemplo**      |
|-----------------------------|---------------------|----------|-------------------|---------------|----------------------------------|------------------|
| **tenant_id**               | uuid                | NO       | —                 | PK\*          | Tenant.                          | 8a…              |
| **appeal_decision_id**      | uuid                | NO       | gen_random_uuid() | PK            | ID decisión.                     | apd…             |
| **appeal_case_id**          | uuid                | NO       | —                 | FK            | Case.                            | apl…             |
| **decision_code**           | varchar(32)         | NO       | —                 | CHECK         | MAINTAIN/REASSESS/RESTATE/OTHER. | RESTATE          |
| **reason_code**             | varchar(80)         | NO       | —                 | —             | Reason.                          | PROCEDURAL_ERROR |
| **evidence_ref**            | uuid                | YES      | NULL              | EXT REF CT-05 | Evidence.                        | doc…             |
| **decided_by_subject**      | uuid                | NO       | —                 | EXT REF IAM   | Decisor.                         | usr…             |
| **decided_at**              | timestamptz         | NO       | now()             | —             | Instante.                        | …                |
| **applied_result_fact_ref** | uuid                | YES      | NULL              | FK            | Fact posterior si aplica.        | rf-new…          |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**appeal_decision_id —** ID decisión. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: apd….

**appeal_case_id —** Case. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: apl….

**decision_code —** MAINTAIN/REASSESS/RESTATE/OTHER. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: RESTATE.

**reason_code —** Reason. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: PROCEDURAL_ERROR.

**evidence_ref —** Evidence. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: doc….

**decided_by_subject —** Decisor. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**decided_at —** Instante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**applied_result_fact_ref —** Fact posterior si aplica. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: rf-new….

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**   | **Error que impide**                                                                                       |
|--------------------------------------|----------|----------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_appeal_decision              | PK       | tenant_id + id             | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_appeal_decision_case         | FK       | case tenant-aware          | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_appeal_decision_case         | UNIQUE   | terminal decision per case | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_appeal_decision_code         | CHECK    | allowed                    | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_appeal_decision_append_only | TRIGGER  | immutable                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir decisiones duplicadas/alteradas y efectos sin lineage explícito. |
|-------------------------------------------------------------------------------------------------------------------|

## 12.17 ec07_completion_evaluation

QUÉ REPRESENTA — Representa una ejecución determinista de la política de completion para un enrollment.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Consume current official ResultFacts y EC-06 facts pinneados. Puede quedar BLOCKED/STALE si inputs no son confiables.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege input snapshot/hash y estado. No es CompletionFact oficial hasta publish.

| **Campo**                    | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                        | **Ejemplo** |
|------------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------|-------------|
| **tenant_id**                | uuid                | NO       | —                 | PK\*          | Tenant.                                                | 8a…         |
| **completion_evaluation_id** | uuid                | NO       | gen_random_uuid() | PK            | ID evaluación.                                         | ce…         |
| **assessment_plan_id**       | uuid                | NO       | —                 | FK            | Plan.                                                  | ap…         |
| **enrollment_ref**           | uuid                | NO       | —                 | EXT REF EC-04 | Enrollment.                                            | enr…        |
| **completion_policy_ref**    | uuid                | NO       | —                 | EXT REF CT-02 | PolicyVersion.                                         | pol…        |
| **input_snapshot_hash**      | varchar(128)        | NO       | —                 | —             | Hash refs/versiones inputs.                            | sha256:…    |
| **state**                    | varchar(24)         | NO       | 'PENDING'         | CHECK         | PENDING/READY/EVALUATING/EVALUATED/BLOCKED/STALE/VOID. | EVALUATED   |
| **candidate_status**         | varchar(24)         | YES      | NULL              | CHECK         | COMPLETED/NOT_COMPLETED.                               | COMPLETED   |
| **evaluated_at**             | timestamptz         | YES      | NULL              | —             | Instante.                                              | …           |
| **created_at**               | timestamptz         | NO       | now()             | —             | Creación.                                              | …           |
| **version**                  | bigint              | NO       | 0                 | —             | Optimistic lock.                                       | 2           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**completion_evaluation_id —** ID evaluación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ce….

**assessment_plan_id —** Plan. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ap….

**enrollment_ref —** Enrollment. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: enr….

**completion_policy_ref —** PolicyVersion. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pol….

**input_snapshot_hash —** Hash refs/versiones inputs. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**state —** PENDING/READY/EVALUATING/EVALUATED/BLOCKED/STALE/VOID. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: EVALUATED.

**candidate_status —** COMPLETED/NOT_COMPLETED. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: COMPLETED.

**evaluated_at —** Instante. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**version —** Optimistic lock. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se mapea @Version y un ETag obsoleto produce 412 PRECONDITION_FAILED. Ejemplo: 2.

### Constraints físicos implementables

| **Nombre físico**             | **Tipo** | **Definición/expresión**       | **Error que impide**                                                                                       |
|-------------------------------|----------|--------------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_completion_evaluation | PK       | tenant_id + id                 | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_completion_plan       | FK       | plan tenant-aware              | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_completion_eval_input | UNIQUE   | plan + enrollment + input hash | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_completion_eval_state | CHECK    | lifecycle                      | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir evaluaciones duplicadas para el mismo snapshot, states inválidos y cross-tenant. |
|-----------------------------------------------------------------------------------------------------------------------------------|

## 12.18 ec07_completion_rule_fact

QUÉ REPRESENTA — Hecho explicable del resultado de una regla individual de completion.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea durante CompletionEvaluation y conserva operator, expected, observed, input refs y outcome.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege explainability y diferencia UNKNOWN de NOT_SATISFIED.

| **Campo**                    | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                         | **Ejemplo**    |
|------------------------------|---------------------|----------|-------------------|-----------|-----------------------------------------|----------------|
| **tenant_id**                | uuid                | NO       | —                 | PK\*      | Tenant.                                 | 8a…            |
| **completion_rule_fact_id**  | uuid                | NO       | gen_random_uuid() | PK        | ID rule fact.                           | crf…           |
| **completion_evaluation_id** | uuid                | NO       | —                 | FK        | Evaluación.                             | ce…            |
| **rule_code**                | varchar(80)         | NO       | —                 | UQ        | Código regla.                           | MIN_ATTENDANCE |
| **source_type**              | varchar(40)         | NO       | —                 | CHECK     | RESULT/ATTENDANCE/REQUIREMENT/OTHER.    | ATTENDANCE     |
| **input_refs**               | jsonb               | NO       | '\[\]'::jsonb     | —         | Refs/versiones/hash inputs.             | \[…\]          |
| **operator_code**            | varchar(32)         | NO       | —                 | —         | GE/EQ/ALL/ANY/etc.                      | GE             |
| **expected_value**           | varchar(160)        | YES      | NULL              | —         | Esperado canónico.                      | 80.00          |
| **observed_value**           | varchar(160)        | YES      | NULL              | —         | Observado.                              | 82.50          |
| **outcome**                  | varchar(24)         | NO       | —                 | CHECK     | SATISFIED/NOT_SATISFIED/UNKNOWN/WAIVED. | SATISFIED      |
| **reason_code**              | varchar(80)         | YES      | NULL              | —         | Motivo.                                 | …              |
| **recorded_at**              | timestamptz         | NO       | now()             | —         | Instante.                               | …              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**completion_rule_fact_id —** ID rule fact. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: crf….

**completion_evaluation_id —** Evaluación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ce….

**rule_code —** Código regla. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: MIN_ATTENDANCE.

**source_type —** RESULT/ATTENDANCE/REQUIREMENT/OTHER. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ATTENDANCE.

**input_refs —** Refs/versiones/hash inputs. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: \[…\].

**operator_code —** GE/EQ/ALL/ANY/etc. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: GE.

**expected_value —** Esperado canónico. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 80.00.

**observed_value —** Observado. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 82.50.

**outcome —** SATISFIED/NOT_SATISFIED/UNKNOWN/WAIVED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: SATISFIED.

**reason_code —** Motivo. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ….

**recorded_at —** Instante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|--------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_completion_rule_fact   | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_rule_eval              | FK       | evaluation tenant-aware  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_rule_code              | UNIQUE   | evaluation + rule_code   | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_rule_outcome           | CHECK    | allowed                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_rule_fact_append_only | TRIGGER  | immutable after terminal | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir reglas duplicadas, UNKNOWN colapsado en false y modificación retrospectiva de evidencia. |
|-------------------------------------------------------------------------------------------------------------------------------------------|

## 12.19 ec07_completion_fact

QUÉ REPRESENTA — Hecho oficial append-only de completion académico.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se publica cuando CompletionEvaluation es EVALUATED y inputs siguen vigentes. EC-08 lo consume por event/contract.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege completion history y lineage. No representa certificate eligibility ni pago.

| **Campo**                         | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**          | **Ejemplo**    |
|-----------------------------------|---------------------|----------|-------------------|---------------|--------------------------|----------------|
| **tenant_id**                     | uuid                | NO       | —                 | PK\*          | Tenant.                  | 8a…            |
| **completion_fact_id**            | uuid                | NO       | gen_random_uuid() | PK            | ID fact.                 | cf…            |
| **completion_evaluation_id**      | uuid                | NO       | —                 | FK            | Evaluation origen.       | ce…            |
| **enrollment_ref**                | uuid                | NO       | —                 | EXT REF EC-04 | Enrollment.              | enr…           |
| **completion_status**             | varchar(24)         | NO       | —                 | CHECK         | COMPLETED/NOT_COMPLETED. | COMPLETED      |
| **completion_date**               | date                | YES      | NULL              | —             | Fecha académica.         | 2026-10-31     |
| **policy_snapshot**               | jsonb               | NO       | '{}'::jsonb       | —             | Policy/input provenance. | {…}            |
| **supersedes_completion_fact_id** | uuid                | YES      | NULL              | FK            | Fact anterior.           | cf-old…        |
| **reason_code**                   | varchar(80)         | YES      | NULL              | —             | Reason restatement.      | APPEAL_GRANTED |
| **content_hash**                  | varchar(128)        | NO       | —                 | —             | Hash canónico.           | sha256:…       |
| **published_by_subject**          | uuid                | YES      | NULL              | EXT REF IAM   | Actor.                   | usr…           |
| **published_at**                  | timestamptz         | NO       | now()             | —             | Instante.                | …              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**completion_fact_id —** ID fact. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: cf….

**completion_evaluation_id —** Evaluation origen. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: ce….

**enrollment_ref —** Enrollment. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: enr….

**completion_status —** COMPLETED/NOT_COMPLETED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: COMPLETED.

**completion_date —** Fecha académica. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 2026-10-31.

**policy_snapshot —** Policy/input provenance. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: {…}.

**supersedes_completion_fact_id —** Fact anterior. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: cf-old….

**reason_code —** Reason restatement. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: APPEAL_GRANTED.

**content_hash —** Hash canónico. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**published_by_subject —** Actor. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**published_at —** Instante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**               | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|---------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_completion_fact         | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_completion_eval_fact    | FK       | evaluation tenant-aware  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_completion_supersedes   | FK       | same enrollment/scope    | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_completion_status       | CHECK    | COMPLETED/NOT_COMPLETED  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_completion_no_self      | CHECK    | no self                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_completion_append_only | TRIGGER  | immutable                | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_completion_lineage     | TRIGGER  | acyclic same scope       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir completion inválido, lineage cíclico/cross-scope y rewrite destructivo. |
|--------------------------------------------------------------------------------------------------------------------------|

## 12.20 ec07_completion_restatement

QUÉ REPRESENTA — Metadata de negocio que explica por qué se generó un nuevo CompletionFact.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Vincula old/new facts, workflow/evidence y actor. Sirve para auditoría/lineage.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la causa formal del restatement.

| **Campo**                       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**    | **Ejemplo**    |
|---------------------------------|---------------------|----------|-------------------|---------------|--------------------|----------------|
| **tenant_id**                   | uuid                | NO       | —                 | PK\*          | Tenant.            | 8a…            |
| **completion_restatement_id**   | uuid                | NO       | gen_random_uuid() | PK            | ID restatement.    | cr…            |
| **previous_completion_fact_id** | uuid                | NO       | —                 | FK            | Fact anterior.     | cf-old…        |
| **new_completion_fact_id**      | uuid                | NO       | —                 | FK            | Fact nuevo.        | cf-new…        |
| **reason_code**                 | varchar(80)         | NO       | —                 | —             | Causa.             | APPEAL_GRANTED |
| **workflow_ref**                | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow.          | wf…            |
| **evidence_ref**                | uuid                | YES      | NULL              | EXT REF CT-05 | Evidence.          | doc…           |
| **authorized_by_subject**       | uuid                | NO       | —                 | EXT REF IAM   | Actor autorizador. | usr…           |
| **created_at**                  | timestamptz         | NO       | now()             | —             | Instante.          | …              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**completion_restatement_id —** ID restatement. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: cr….

**previous_completion_fact_id —** Fact anterior. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: cf-old….

**new_completion_fact_id —** Fact nuevo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: cf-new….

**reason_code —** Causa. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: APPEAL_GRANTED.

**workflow_ref —** Workflow. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: wf….

**evidence_ref —** Evidence. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: doc….

**authorized_by_subject —** Actor autorizador. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**created_at —** Instante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**                           | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|---------------------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_completion_restatement              | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_completion_restatement_pair         | UNIQUE   | previous + new           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_restatement_previous                | FK       | completion tenant-aware  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_restatement_new                     | FK       | completion tenant-aware  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_completion_restatement_append_only | TRIGGER  | immutable                | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir restatements duplicados y desacoplados del lineage real. |
|-----------------------------------------------------------------------------------------------------------|

## 12.21 ec07_academic_closure

QUÉ REPRESENTA — Aggregate de cierre académico de una edición/cohorte.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Lo crea Academic Coordination y ejecuta ClosurePreflight. Puede acumular holds. CLOSED congela scope/counts y genera receipt.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege que cierre sea proceso verificable. No representa fin de calendario ni cierre financiero.

| **Campo**                     | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                             | **Ejemplo** |
|-------------------------------|---------------------|----------|-------------------|---------------|---------------------------------------------|-------------|
| **tenant_id**                 | uuid                | NO       | —                 | PK\*          | Tenant.                                     | 8a…         |
| **academic_closure_id**       | uuid                | NO       | gen_random_uuid() | PK            | ID cierre.                                  | cl…         |
| **edition_ref**               | uuid                | NO       | —                 | EXT REF EC-02 | Edición.                                    | ed…         |
| **cohort_ref**                | uuid                | YES      | NULL              | EXT REF EC-02 | Cohorte opcional.                           | coh…        |
| **closure_cycle_no**          | integer             | NO       | 1                 | UQ/CHECK      | Ciclo monotónico.                           | 1           |
| **previous_closure_ref**      | uuid                | YES      | NULL              | FK            | Cierre previo.                              | cl-old…     |
| **state**                     | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/VALIDATING/BLOCKED/READY/CLOSED/VOID. | READY       |
| **expected_enrollment_count** | integer             | NO       | 0                 | CHECK         | Población esperada.                         | 35          |
| **current_completion_count**  | integer             | NO       | 0                 | CHECK         | Completions current.                        | 32          |
| **pending_count**             | integer             | NO       | 0                 | CHECK         | Pendientes.                                 | 3           |
| **policy_ref**                | uuid                | NO       | —                 | EXT REF CT-02 | Closure policy.                             | pol…        |
| **scope_snapshot_hash**       | varchar(128)        | NO       | —                 | —             | Hash scope.                                 | sha256:…    |
| **workflow_ref**              | uuid                | YES      | NULL              | EXT REF CT-06 | Approval/reopen.                            | wf…         |
| **created_by_subject**        | uuid                | NO       | —                 | EXT REF IAM   | Actor.                                      | usr…        |
| **created_at**                | timestamptz         | NO       | now()             | —             | Creación.                                   | …           |
| **updated_at**                | timestamptz         | NO       | now()             | —             | Update.                                     | …           |
| **version**                   | bigint              | NO       | 0                 | —             | Aggregate revision.                         | 4           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**academic_closure_id —** ID cierre. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: cl….

**edition_ref —** Edición. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: ed….

**cohort_ref —** Cohorte opcional. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: coh….

**closure_cycle_no —** Ciclo monotónico. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 1.

**previous_closure_ref —** Cierre previo. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: cl-old….

**state —** DRAFT/VALIDATING/BLOCKED/READY/CLOSED/VOID. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: READY.

**expected_enrollment_count —** Población esperada. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 35.

**current_completion_count —** Completions current. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 32.

**pending_count —** Pendientes. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 3.

**policy_ref —** Closure policy. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: pol….

**scope_snapshot_hash —** Hash scope. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**workflow_ref —** Approval/reopen. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: wf….

**created_by_subject —** Actor. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**updated_at —** Update. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**version —** Aggregate revision. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se mapea @Version y un ETag obsoleto produce 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**           | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|-----------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_academic_closure    | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_closure_scope_cycle | UNIQUE   | scope + cycle            | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_closure_previous    | FK       | same scope               | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_closure_counts      | CHECK    | counts\>=0               | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_closure_state       | CHECK    | lifecycle                | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_closure_transition | TRIGGER  | guard                    | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_closure_lineage    | TRIGGER  | cycle/acyclic same scope | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir dos cierres con mismo ciclo/scope, counts negativos, lineage inválido y state transition imposible. |
|------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.22 ec07_closure_scope_item

QUÉ REPRESENTA — Snapshot mínimo de cada enrollment incluido en preflight/cierre.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Permite reconciliar expected population con CompletionFacts sin copiar PII.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege completeness y evita que un enrollment desaparezca silenciosamente del cierre.

| **Campo**                       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                           | **Ejemplo** |
|---------------------------------|---------------------|----------|-------------------|---------------|-------------------------------------------|-------------|
| **tenant_id**                   | uuid                | NO       | —                 | PK\*          | Tenant.                                   | 8a…         |
| **closure_scope_item_id**       | uuid                | NO       | gen_random_uuid() | PK            | ID item.                                  | csi…        |
| **academic_closure_id**         | uuid                | NO       | —                 | FK            | Closure.                                  | cl…         |
| **enrollment_ref**              | uuid                | NO       | —                 | EXT REF EC-04 | Enrollment.                               | enr…        |
| **current_completion_fact_ref** | uuid                | YES      | NULL              | FK            | Current fact al snapshot.                 | cf…         |
| **item_status**                 | varchar(24)         | NO       | —                 | CHECK         | COMPLETED/NOT_COMPLETED/PENDING/EXCLUDED. | COMPLETED   |
| **reason_code**                 | varchar(80)         | YES      | NULL              | —             | Razón exclusión/pendiente.                | OPEN_APPEAL |
| **snapshot_at**                 | timestamptz         | NO       | now()             | —             | Instante snapshot.                        | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**closure_scope_item_id —** ID item. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: csi….

**academic_closure_id —** Closure. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: cl….

**enrollment_ref —** Enrollment. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: enr….

**current_completion_fact_ref —** Current fact al snapshot. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: cf….

**item_status —** COMPLETED/NOT_COMPLETED/PENDING/EXCLUDED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: COMPLETED.

**reason_code —** Razón exclusión/pendiente. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: OPEN_APPEAL.

**snapshot_at —** Instante snapshot. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**          | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|----------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_closure_scope_item | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_scope_closure      | FK       | closure tenant-aware     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_scope_enrollment   | UNIQUE   | closure + enrollment     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_scope_item_status  | CHECK    | allowed                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir enrollments duplicados en closure scope y status no reconocidos. |
|-------------------------------------------------------------------------------------------------------------------|

## 12.23 ec07_closure_hold

QUÉ REPRESENTA — Bloqueo explícito que impide AcademicClosure.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea por preflight/system/staff y se resuelve con evidence/reason. BLOCKING OPEN impide READY/CLOSED.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege que una inconsistencia no se pierda en logs o mensajes informales.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**       | **Ejemplo**    |
|-------------------------|---------------------|----------|-------------------|---------------|-----------------------|----------------|
| **tenant_id**           | uuid                | NO       | —                 | PK\*          | Tenant.               | 8a…            |
| **closure_hold_id**     | uuid                | NO       | gen_random_uuid() | PK            | ID hold.              | hold…          |
| **academic_closure_id** | uuid                | NO       | —                 | FK            | Closure.              | cl…            |
| **hold_type_code**      | varchar(80)         | NO       | —                 | EXT REF CT-02 | Tipo.                 | OPEN_APPEAL    |
| **severity**            | varchar(16)         | NO       | 'BLOCKING'        | CHECK         | BLOCKING/WARNING.     | BLOCKING       |
| **subject_ref**         | uuid                | YES      | NULL              | —             | Opaque subject ref.   | enr…           |
| **state**               | varchar(20)         | NO       | 'OPEN'            | CHECK         | OPEN/RESOLVED/WAIVED. | OPEN           |
| **reason_code**         | varchar(80)         | NO       | —                 | —             | Motivo.               | PENDING_RESULT |
| **evidence_ref**        | uuid                | YES      | NULL              | EXT REF CT-05 | Evidence.             | doc…           |
| **resolved_by_subject** | uuid                | YES      | NULL              | EXT REF IAM   | Actor resolución.     | usr…           |
| **resolved_at**         | timestamptz         | YES      | NULL              | —             | Instante.             | …              |
| **created_at**          | timestamptz         | NO       | now()             | —             | Creación.             | …              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**closure_hold_id —** ID hold. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: hold….

**academic_closure_id —** Closure. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: cl….

**hold_type_code —** Tipo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: OPEN_APPEAL.

**severity —** BLOCKING/WARNING. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: BLOCKING.

**subject_ref —** Opaque subject ref. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: enr….

**state —** OPEN/RESOLVED/WAIVED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: OPEN.

**reason_code —** Motivo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: PENDING_RESULT.

**evidence_ref —** Evidence. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: doc….

**resolved_by_subject —** Actor resolución. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**resolved_at —** Instante. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**       | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|-------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_closure_hold    | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_hold_closure    | FK       | closure tenant-aware     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_hold_severity   | CHECK    | BLOCKING/WARNING         | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_hold_state      | CHECK    | OPEN/RESOLVED/WAIVED     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_hold_resolution | CHECK    | resolved fields coherent | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir holds resueltos sin actor/timestamp y cerrar con BLOCKING OPEN mediante guard de closure. |
|--------------------------------------------------------------------------------------------------------------------------------------------|

## 12.24 ec07_closure_receipt

QUÉ REPRESENTA — Evidencia append-only del cierre oficial.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea en la misma transacción que CLOSED y outbox. Incluye hashes/counts/policy/evidence/assurance para reconstrucción.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege auditabilidad del cierre. No es certificado ni documento binario.

| **Campo**                    | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**            | **Ejemplo** |
|------------------------------|---------------------|----------|-------------------|-------------|----------------------------|-------------|
| **tenant_id**                | uuid                | NO       | —                 | PK\*        | Tenant.                    | 8a…         |
| **closure_receipt_id**       | uuid                | NO       | gen_random_uuid() | PK          | ID receipt.                | clr…        |
| **academic_closure_id**      | uuid                | NO       | —                 | FK/UQ       | Closure cerrado.           | cl…         |
| **scope_hash**               | varchar(128)        | NO       | —                 | —           | Hash scope snapshot.       | sha256:…    |
| **completion_set_hash**      | varchar(128)        | NO       | —                 | —           | Hash set completion facts. | sha256:…    |
| **policy_snapshot**          | jsonb               | NO       | '{}'::jsonb       | —           | Policies.                  | {…}         |
| **expected_count**           | integer             | NO       | —                 | CHECK       | Expected.                  | 35          |
| **completed_count**          | integer             | NO       | —                 | CHECK       | Completed.                 | 32          |
| **not_completed_count**      | integer             | NO       | —                 | CHECK       | Not completed.             | 2           |
| **excluded_count**           | integer             | NO       | 0                 | CHECK       | Excluded.                  | 1           |
| **canonical_schema_version** | varchar(32)         | NO       | 'v1'              | —           | Canonicalización.          | v1          |
| **hash_algorithm**           | varchar(32)         | NO       | 'SHA-256'         | —           | Algoritmo.                 | SHA-256     |
| **closed_by_subject**        | uuid                | NO       | —                 | EXT REF IAM | Actor.                     | usr…        |
| **assurance_level**          | varchar(40)         | YES      | NULL              | —           | Assurance.                 | AAL2        |
| **closed_at**                | timestamptz         | NO       | now()             | —           | Instante.                  | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**closure_receipt_id —** ID receipt. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: clr….

**academic_closure_id —** Closure cerrado. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. La FK interna es tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo: cl….

**scope_hash —** Hash scope snapshot. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**completion_set_hash —** Hash set completion facts. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**policy_snapshot —** Policies. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: {…}.

**expected_count —** Expected. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 35.

**completed_count —** Completed. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 32.

**not_completed_count —** Not completed. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 2.

**excluded_count —** Excluded. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 1.

**canonical_schema_version —** Canonicalización. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: v1.

**hash_algorithm —** Algoritmo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: SHA-256.

**closed_by_subject —** Actor. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Es referencia cross-context validada por port/contract y sin FK física externa. Ejemplo: usr….

**assurance_level —** Assurance. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: AAL2.

**closed_at —** Instante. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|------------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_closure_receipt      | PK       | tenant_id + id           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| uq_ec07_receipt_closure      | UNIQUE   | closure                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| fk_ec07_receipt_closure      | FK       | closure tenant-aware     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_receipt_counts       | CHECK    | counts\>=0               | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| trg_ec07_receipt_append_only | TRIGGER  | immutable                | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir más de un receipt por cierre, counts inválidos y cualquier alteración posterior. |
|-----------------------------------------------------------------------------------------------------------------------------------|

## 12.25 ec07_idempotency_key

QUÉ REPRESENTA — Registro durable de idempotencia para comandos sensibles.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Application services adquieren key+request_hash antes de side effects. IN_PROGRESS usa owner/lease para recovery.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege replay y evita doble grade/completion/closure.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**   | **PK/FK** | **Descripción**               | **Ejemplo**        |
|---------------------|---------------------|----------|---------------|-----------|-------------------------------|--------------------|
| **tenant_id**       | uuid                | NO       | —             | PK\*      | Tenant.                       | 8a…                |
| **idempotency_key** | varchar(160)        | NO       | —             | PK        | Key cliente/sistema.          | idem-…             |
| **operation_code**  | varchar(80)         | NO       | —             | PK\*      | Tipo operación.               | PUBLISH_COMPLETION |
| **request_hash**    | varchar(128)        | NO       | —             | —         | Hash payload.                 | sha256:…           |
| **state**           | varchar(20)         | NO       | 'IN_PROGRESS' | CHECK     | IN_PROGRESS/SUCCEEDED/FAILED. | SUCCEEDED          |
| **owner_id**        | varchar(120)        | YES      | NULL          | —         | Worker owner.                 | pod-7              |
| **lease_until**     | timestamptz         | YES      | NULL          | CHECK     | Lease recovery.               | …                  |
| **response_code**   | integer             | YES      | NULL          | —         | HTTP replay.                  | 201                |
| **response_body**   | jsonb               | YES      | NULL          | —         | Response segura.              | {…}                |
| **resource_ref**    | uuid                | YES      | NULL          | —         | Fact/receipt.                 | cf…                |
| **created_at**      | timestamptz         | NO       | now()         | —         | Creación.                     | …                  |
| **updated_at**      | timestamptz         | NO       | now()         | —         | Heartbeat/update.             | …                  |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**idempotency_key —** Key cliente/sistema. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: idem-….

**operation_code —** Tipo operación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: PUBLISH_COMPLETION.

**request_hash —** Hash payload. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**state —** IN_PROGRESS/SUCCEEDED/FAILED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: SUCCEEDED.

**owner_id —** Worker owner. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: pod-7.

**lease_until —** Lease recovery. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**response_code —** HTTP replay. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 201.

**response_body —** Response segura. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: {…}.

**resource_ref —** Fact/receipt. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: cf….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**updated_at —** Heartbeat/update. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**     | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|-----------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_idempotency   | PK       | tenant + key + op        | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_idem_state    | CHECK    | allowed                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_idem_lease    | CHECK    | lease coherent           | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ix_ec07_idem_recovery | INDEX    | state + lease            | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir reutilización ambigua y permitir recovery sin duplicar side effects. |
|-----------------------------------------------------------------------------------------------------------------------|

## 12.26 ec07_outbox_event

QUÉ REPRESENTA — Outbox transaccional de integration events.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se inserta en la misma transacción que facts oficiales. Dispatcher multi-instancia usa SKIP LOCKED/lease y publica at-least-once.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege atomicidad DB→event bus y recuperación.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                     | **Ejemplo**                |
|---------------------|---------------------|----------|-------------------|-----------|-------------------------------------|----------------------------|
| **tenant_id**       | uuid                | NO       | —                 | PK\*      | Tenant.                             | 8a…                        |
| **event_id**        | uuid                | NO       | gen_random_uuid() | PK        | ID event.                           | evt…                       |
| **aggregate_type**  | varchar(80)         | NO       | —                 | —         | Tipo aggregate.                     | CompletionFact             |
| **aggregate_id**    | uuid                | NO       | —                 | —         | ID aggregate/fact.                  | cf…                        |
| **event_type**      | varchar(120)        | NO       | —                 | —         | Evento versionado.                  | CompletionFactPublished.v1 |
| **schema_version**  | integer             | NO       | 1                 | CHECK     | Versión schema.                     | 1                          |
| **correlation_id**  | uuid                | NO       | —                 | —         | Correlation.                        | corr…                      |
| **causation_id**    | uuid                | YES      | NULL              | —         | Causation.                          | cmd…                       |
| **payload**         | jsonb               | NO       | —                 | —         | Payload.                            | {…}                        |
| **state**           | varchar(20)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/PUBLISHED/FAILED. | PENDING                    |
| **owner_id**        | varchar(120)        | YES      | NULL              | —         | Dispatcher owner.                   | pod-1                      |
| **lease_until**     | timestamptz         | YES      | NULL              | —         | Lease.                              | …                          |
| **attempt_count**   | integer             | NO       | 0                 | CHECK     | Intentos.                           | 0                          |
| **next_attempt_at** | timestamptz         | YES      | NULL              | —         | Backoff.                            | …                          |
| **occurred_at**     | timestamptz         | NO       | now()             | —         | Domain event time.                  | …                          |
| **published_at**    | timestamptz         | YES      | NULL              | —         | Publish time.                       | …                          |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**event_id —** ID event. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: evt….

**aggregate_type —** Tipo aggregate. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: CompletionFact.

**aggregate_id —** ID aggregate/fact. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: cf….

**event_type —** Evento versionado. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: CompletionFactPublished.v1.

**schema_version —** Versión schema. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 1.

**correlation_id —** Correlation. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: corr….

**causation_id —** Causation. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: cmd….

**payload —** Payload. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: {…}.

**state —** PENDING/IN_FLIGHT/PUBLISHED/FAILED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: PENDING.

**owner_id —** Dispatcher owner. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: pod-1.

**lease_until —** Lease. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**attempt_count —** Intentos. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: 0.

**next_attempt_at —** Backoff. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**occurred_at —** Domain event time. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**published_at —** Publish time. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**      | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_outbox         | PK       | tenant_id + event_id     | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_outbox_state   | CHECK    | allowed                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_outbox_attempt | CHECK    | attempt_count\>=0        | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ix_ec07_outbox_claim   | INDEX    | state/next/lease         | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir states/contadores inválidos y soportar claiming/recovery multi-instancia. |
|----------------------------------------------------------------------------------------------------------------------------|

## 12.27 ec07_inbox_message

QUÉ REPRESENTA — Registro de mensajes externos ya procesados o en proceso.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Consumers adquieren message_id por tenant/consumer antes de side effects. Permite dedup, lease y replay controlado.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege at-least-once contra doble efecto.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default**   | **PK/FK** | **Descripción**               | **Ejemplo**    |
|-------------------|---------------------|----------|---------------|-----------|-------------------------------|----------------|
| **tenant_id**     | uuid                | NO       | —             | PK\*      | Tenant.                       | 8a…            |
| **consumer_code** | varchar(100)        | NO       | —             | PK\*      | Consumer lógico.              | ec07-lms-grade |
| **message_id**    | varchar(180)        | NO       | —             | PK        | ID mensaje.                   | msg…           |
| **payload_hash**  | varchar(128)        | NO       | —             | —         | Hash.                         | sha256:…       |
| **state**         | varchar(20)         | NO       | 'IN_PROGRESS' | CHECK     | IN_PROGRESS/PROCESSED/FAILED. | PROCESSED      |
| **owner_id**      | varchar(120)        | YES      | NULL          | —         | Owner.                        | pod-2          |
| **lease_until**   | timestamptz         | YES      | NULL          | —         | Lease.                        | …              |
| **processed_at**  | timestamptz         | YES      | NULL          | —         | Finalización.                 | …              |
| **created_at**    | timestamptz         | NO       | now()         | —         | Creación.                     | …              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**consumer_code —** Consumer lógico. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: ec07-lms-grade.

**message_id —** ID mensaje. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: msg….

**payload_hash —** Hash. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Algoritmo y canonical schema version deben ser reproducibles. Ejemplo: sha256:….

**state —** IN_PROGRESS/PROCESSED/FAILED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: PROCESSED.

**owner_id —** Owner. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: pod-2.

**lease_until —** Lease. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**processed_at —** Finalización. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**      | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_inbox          | PK       | tenant+consumer+message  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_inbox_state    | CHECK    | allowed                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ix_ec07_inbox_recovery | INDEX    | state+lease              | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir procesar dos veces el mismo messageId para consumer/tenant. |
|--------------------------------------------------------------------------------------------------------------|

## 12.28 ec07_operation_status

QUÉ REPRESENTA — Estado durable de operaciones asíncronas y reconciliaciones.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea cuando API devuelve 202 o una integración entra UNKNOWN_EFFECT. Frontend/Ops consulta hasta terminal.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege transparencia de side effects inciertos y evita retry ciego.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                            | **Ejemplo**        |
|------------------------|---------------------|----------|-------------------|-----------|------------------------------------------------------------|--------------------|
| **tenant_id**          | uuid                | NO       | —                 | PK\*      | Tenant.                                                    | 8a…                |
| **operation_id**       | uuid                | NO       | gen_random_uuid() | PK        | ID operación.                                              | op…                |
| **operation_type**     | varchar(80)         | NO       | —                 | —         | Tipo.                                                      | LMS_RECONCILIATION |
| **resource_ref**       | uuid                | YES      | NULL              | —         | Recurso relacionado.                                       | att…               |
| **state**              | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. | UNKNOWN_EFFECT     |
| **remote_receipt_ref** | varchar(180)        | YES      | NULL              | —         | Receipt remoto.                                            | lms:…              |
| **last_reason_code**   | varchar(80)         | YES      | NULL              | —         | Reason/error.                                              | TIMEOUT_AFTER_SEND |
| **result_payload**     | jsonb               | YES      | NULL              | —         | Resultado seguro.                                          | {…}                |
| **owner_id**           | varchar(120)        | YES      | NULL              | —         | Worker owner.                                              | pod-4              |
| **lease_until**        | timestamptz         | YES      | NULL              | —         | Lease.                                                     | …                  |
| **created_at**         | timestamptz         | NO       | now()             | —         | Creación.                                                  | …                  |
| **updated_at**         | timestamptz         | NO       | now()             | —         | Update.                                                    | …                  |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se deriva de Security/TenantContext y RLS lo aplica como defensa adicional. Ejemplo: 8a….

**operation_id —** ID operación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: op….

**operation_type —** Tipo. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: LMS_RECONCILIATION.

**resource_ref —** Recurso relacionado. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: att….

**state —** PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: UNKNOWN_EFFECT.

**remote_receipt_ref —** Receipt remoto. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: lms:….

**last_reason_code —** Reason/error. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: TIMEOUT_AFTER_SEND.

**result_payload —** Resultado seguro. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: {…}.

**owner_id —** Worker owner. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Ejemplo: pod-4.

**lease_until —** Lease. Puede ser NULL solo cuando la ausencia tiene semántica de negocio documentada; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**created_at —** Creación. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

**updated_at —** Update. Es obligatorio; NULL nunca se confunde con cero, cadena vacía o un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**           | **Tipo** | **Definición/expresión** | **Error que impide**                                                                                       |
|-----------------------------|----------|--------------------------|------------------------------------------------------------------------------------------------------------|
| pk_ec07_operation           | PK       | tenant_id + operation_id | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ck_ec07_operation_state     | CHECK    | allowed                  | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |
| ix_ec07_operation_reconcile | INDEX    | state/lease/update       | Impide violación de identidad, scope, estado, lineage, concurrencia o inmutabilidad asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir states inválidos y proporcionar ownership/recovery durable para operaciones inciertas. |
|-----------------------------------------------------------------------------------------------------------------------------------------|

# 13. DDL PostgreSQL completo — Flyway Ready

El siguiente baseline debe separarse en migraciones expand/contract. Se recomienda V1\_\_schema.sql, V2\_\_core.sql, V3\_\_constraints.sql, V4\_\_rls.sql, V5\_\_triggers.sql y V6\_\_indexes.sql. No incluye FK cross-context.

```
CREATE SCHEMA IF NOT EXISTS ec07;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE ec07.assessment_plan (
tenant_id uuid NOT NULL,
assessment_plan_id uuid DEFAULT gen_random_uuid() NOT NULL,
edition_ref uuid NOT NULL,
cohort_ref uuid DEFAULT NULL,
program_version_ref uuid NOT NULL,
plan_no integer DEFAULT 1 NOT NULL,
official_name varchar(200) NOT NULL,
state varchar(24) DEFAULT 'DRAFT' NOT NULL,
grading_policy_ref uuid NOT NULL,
completion_policy_ref uuid NOT NULL,
policy_snapshot jsonb DEFAULT '{}'::jsonb NOT NULL,
workflow_ref uuid DEFAULT NULL,
content_hash varchar(128) DEFAULT NULL,
published_at timestamptz DEFAULT NULL,
published_by_subject uuid DEFAULT NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
PRIMARY KEY (tenant_id, assessment_plan_id)
);

CREATE TABLE ec07.assessment_component (
tenant_id uuid NOT NULL,
assessment_component_id uuid DEFAULT gen_random_uuid() NOT NULL,
assessment_plan_id uuid NOT NULL,
component_code varchar(64) NOT NULL,
assessment_type_code varchar(80) NOT NULL,
title varchar(200) NOT NULL,
weight_value numeric(9,4) DEFAULT NULL,
mandatory boolean DEFAULT true NOT NULL,
attempt_policy_ref uuid NOT NULL,
selection_policy_ref uuid NOT NULL,
grading_scale_ref uuid NOT NULL,
rubric_ref uuid DEFAULT NULL,
sequence_no integer NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, assessment_component_id)
);

CREATE TABLE ec07.component_outcome_binding (
tenant_id uuid NOT NULL,
binding_id uuid DEFAULT gen_random_uuid() NOT NULL,
assessment_component_id uuid NOT NULL,
outcome_ref uuid NOT NULL,
contribution_code varchar(40) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, binding_id)
);

CREATE TABLE ec07.assessment_window (
tenant_id uuid NOT NULL,
assessment_window_id uuid DEFAULT gen_random_uuid() NOT NULL,
assessment_component_id uuid NOT NULL,
open_at timestamptz DEFAULT NULL,
close_at timestamptz DEFAULT NULL,
grace_policy_ref uuid DEFAULT NULL,
calendar_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, assessment_window_id)
);

CREATE TABLE ec07.rubric_binding (
tenant_id uuid NOT NULL,
rubric_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,
assessment_component_id uuid NOT NULL,
rubric_ref uuid NOT NULL,
scale_ref uuid NOT NULL,
binding_hash varchar(128) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, rubric_binding_id)
);

CREATE TABLE ec07.evaluation_group (
tenant_id uuid NOT NULL,
evaluation_group_id uuid DEFAULT gen_random_uuid() NOT NULL,
assessment_plan_id uuid NOT NULL,
assessment_component_id uuid NOT NULL,
group_code varchar(64) NOT NULL,
state varchar(20) DEFAULT 'ACTIVE' NOT NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
PRIMARY KEY (tenant_id, evaluation_group_id)
);

CREATE TABLE ec07.evaluation_group_member (
tenant_id uuid NOT NULL,
group_member_id uuid DEFAULT gen_random_uuid() NOT NULL,
evaluation_group_id uuid NOT NULL,
enrollment_ref uuid NOT NULL,
member_role_code varchar(40) DEFAULT NULL,
joined_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, group_member_id)
);

CREATE TABLE ec07.participant_evaluation (
tenant_id uuid NOT NULL,
participant_evaluation_id uuid DEFAULT gen_random_uuid() NOT NULL,
assessment_plan_id uuid NOT NULL,
enrollment_ref uuid NOT NULL,
state varchar(32) DEFAULT 'PENDING' NOT NULL,
accommodation_ref uuid DEFAULT NULL,
started_at timestamptz DEFAULT NULL,
finalized_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
PRIMARY KEY (tenant_id, participant_evaluation_id)
);

CREATE TABLE ec07.attempt (
tenant_id uuid NOT NULL,
attempt_id uuid DEFAULT gen_random_uuid() NOT NULL,
participant_evaluation_id uuid DEFAULT NULL,
evaluation_group_id uuid DEFAULT NULL,
assessment_component_id uuid NOT NULL,
attempt_no integer NOT NULL,
source_type varchar(32) DEFAULT 'MANUAL' NOT NULL,
source_receipt_ref varchar(160) DEFAULT NULL,
occurred_at timestamptz DEFAULT NULL,
received_at timestamptz DEFAULT now() NOT NULL,
submitted_at timestamptz DEFAULT NULL,
state varchar(24) DEFAULT 'CREATED' NOT NULL,
late_flag boolean DEFAULT false NOT NULL,
reason_code varchar(80) DEFAULT NULL,
payload_hash varchar(128) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, attempt_id)
);

CREATE TABLE ec07.attempt_evidence_ref (
tenant_id uuid NOT NULL,
attempt_evidence_id uuid DEFAULT gen_random_uuid() NOT NULL,
attempt_id uuid NOT NULL,
evidence_ref uuid NOT NULL,
evidence_type_code varchar(64) NOT NULL,
content_hash varchar(128) DEFAULT NULL,
captured_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, attempt_evidence_id)
);

CREATE TABLE ec07.score_fact (
tenant_id uuid NOT NULL,
score_fact_id uuid DEFAULT gen_random_uuid() NOT NULL,
attempt_id uuid NOT NULL,
original_value numeric(18,6) DEFAULT NULL,
original_text_value varchar(120) DEFAULT NULL,
original_scale_ref uuid NOT NULL,
normalized_value numeric(18,6) DEFAULT NULL,
normalized_scale_ref uuid DEFAULT NULL,
grading_policy_ref uuid NOT NULL,
supersedes_score_fact_id uuid DEFAULT NULL,
source_actor_ref uuid DEFAULT NULL,
source_type varchar(32) NOT NULL,
reason_code varchar(80) DEFAULT NULL,
content_hash varchar(128) NOT NULL,
recorded_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, score_fact_id)
);

CREATE TABLE ec07.result_fact (
tenant_id uuid NOT NULL,
result_fact_id uuid DEFAULT gen_random_uuid() NOT NULL,
participant_evaluation_id uuid NOT NULL,
assessment_component_id uuid NOT NULL,
selected_attempt_ref uuid DEFAULT NULL,
selected_score_fact_ref uuid DEFAULT NULL,
result_status varchar(32) NOT NULL,
final_score numeric(18,6) DEFAULT NULL,
grade_code varchar(64) DEFAULT NULL,
policy_snapshot jsonb DEFAULT '{}'::jsonb NOT NULL,
supersedes_result_fact_id uuid DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
content_hash varchar(128) NOT NULL,
adjudicated_by_subject uuid DEFAULT NULL,
adjudicated_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, result_fact_id)
);

CREATE TABLE ec07.result_adjustment_request (
tenant
```

```
_id uuid NOT NULL,
adjustment_request_id uuid DEFAULT gen_random_uuid() NOT NULL,
result_fact_ref uuid NOT NULL,
request_type_code varchar(64) NOT NULL,
reason_code varchar(80) NOT NULL,
description text DEFAULT NULL,
workflow_ref uuid DEFAULT NULL,
state varchar(28) DEFAULT 'DRAFT' NOT NULL,
requested_by_subject uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
PRIMARY KEY (tenant_id, adjustment_request_id)
);

CREATE TABLE ec07.result_adjustment_decision (
tenant_id uuid NOT NULL,
adjustment_decision_id uuid DEFAULT gen_random_uuid() NOT NULL,
adjustment_request_id uuid NOT NULL,
decision_code varchar(32) NOT NULL,
reason_code varchar(80) NOT NULL,
evidence_ref uuid DEFAULT NULL,
decided_by_subject uuid NOT NULL,
assurance_level varchar(40) DEFAULT NULL,
decided_at timestamptz DEFAULT now() NOT NULL,
applied_result_fact_ref uuid DEFAULT NULL,
PRIMARY KEY (tenant_id, adjustment_decision_id)
);

CREATE TABLE ec07.appeal_case (
tenant_id uuid NOT NULL,
appeal_case_id uuid DEFAULT gen_random_uuid() NOT NULL,
result_fact_ref uuid NOT NULL,
appeal_type_code varchar(64) NOT NULL,
state varchar(28) DEFAULT 'SUBMITTED' NOT NULL,
workflow_ref uuid DEFAULT NULL,
submitted_by_subject uuid NOT NULL,
submitted_at timestamptz DEFAULT now() NOT NULL,
deadline_at timestamptz DEFAULT NULL,
version bigint DEFAULT 0 NOT NULL,
PRIMARY KEY (tenant_id, appeal_case_id)
);

CREATE TABLE ec07.appeal_decision (
tenant_id uuid NOT NULL,
appeal_decision_id uuid DEFAULT gen_random_uuid() NOT NULL,
appeal_case_id uuid NOT NULL,
decision_code varchar(32) NOT NULL,
reason_code varchar(80) NOT NULL,
evidence_ref uuid DEFAULT NULL,
decided_by_subject uuid NOT NULL,
decided_at timestamptz DEFAULT now() NOT NULL,
applied_result_fact_ref uuid DEFAULT NULL,
PRIMARY KEY (tenant_id, appeal_decision_id)
);

CREATE TABLE ec07.completion_evaluation (
tenant_id uuid NOT NULL,
completion_evaluation_id uuid DEFAULT gen_random_uuid() NOT NULL,
assessment_plan_id uuid NOT NULL,
enrollment_ref uuid NOT NULL,
completion_policy_ref uuid NOT NULL,
input_snapshot_hash varchar(128) NOT NULL,
state varchar(24) DEFAULT 'PENDING' NOT NULL,
candidate_status varchar(24) DEFAULT NULL,
evaluated_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
PRIMARY KEY (tenant_id, completion_evaluation_id)
);

CREATE TABLE ec07.completion_rule_fact (
tenant_id uuid NOT NULL,
completion_rule_fact_id uuid DEFAULT gen_random_uuid() NOT NULL,
completion_evaluation_id uuid NOT NULL,
rule_code varchar(80) NOT NULL,
source_type varchar(40) NOT NULL,
input_refs jsonb DEFAULT '[]'::jsonb NOT NULL,
operator_code varchar(32) NOT NULL,
expected_value varchar(160) DEFAULT NULL,
observed_value varchar(160) DEFAULT NULL,
outcome varchar(24) NOT NULL,
reason_code varchar(80) DEFAULT NULL,
recorded_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, completion_rule_fact_id)
);

CREATE TABLE ec07.completion_fact (
tenant_id uuid NOT NULL,
completion_fact_id uuid DEFAULT gen_random_uuid() NOT NULL,
completion_evaluation_id uuid NOT NULL,
enrollment_ref uuid NOT NULL,
completion_status varchar(24) NOT NULL,
completion_date date DEFAULT NULL,
policy_snapshot jsonb DEFAULT '{}'::jsonb NOT NULL,
supersedes_completion_fact_id uuid DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
content_hash varchar(128) NOT NULL,
published_by_subject uuid DEFAULT NULL,
published_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, completion_fact_id)
);

CREATE TABLE ec07.completion_restatement (
tenant_id uuid NOT NULL,
completion_restatement_id uuid DEFAULT gen_random_uuid() NOT NULL,
previous_completion_fact_id uuid NOT NULL,
new_completion_fact_id uuid NOT NULL,
reason_code varchar(80) NOT NULL,
workflow_ref uuid DEFAULT NULL,
evidence_ref uuid DEFAULT NULL,
authorized_by_subject uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, completion_restatement_id)
);

CREATE TABLE ec07.academic_closure (
tenant_id uuid NOT NULL,
academic_closure_id uuid DEFAULT gen_random_uuid() NOT NULL,
edition_ref uuid NOT NULL,
cohort_ref uuid DEFAULT NULL,
closure_cycle_no integer DEFAULT 1 NOT NULL,
previous_closure_ref uuid DEFAULT NULL,
state varchar(24) DEFAULT 'DRAFT' NOT NULL,
expected_enrollment_count integer DEFAULT 0 NOT NULL,
current_completion_count integer DEFAULT 0 NOT NULL,
pending_count integer DEFAULT 0 NOT NULL,
policy_ref uuid NOT NULL,
scope_snapshot_hash varchar(128) NOT NULL,
workflow_ref uuid DEFAULT NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
PRIMARY KEY (tenant_id, academic_closure_id)
);

CREATE TABLE ec07.closure_scope_item (
tenant_id uuid NOT NULL,
closure_scope_item_id uuid DEFAULT gen_random_uuid() NOT NULL,
academic_closure_id uuid NOT NULL,
enrollment_ref uuid NOT NULL,
current_completion_fact_ref uuid DEFAULT NULL,
item_status varchar(24) NOT NULL,
reason_code varchar(80) DEFAULT NULL,
snapshot_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, closure_scope_item_id)
);

CREATE TABLE ec07.closure_hold (
tenant_id uuid NOT NULL,
closure_hold_id uuid DEFAULT gen_random_uuid() NOT NULL,
academic_closure_id uuid NOT NULL,
hold_type_code varchar(80) NOT NULL,
severity varchar(16) DEFAULT 'BLOCKING' NOT NULL,
subject_ref uuid DEFAULT NULL,
state varchar(20) DEFAULT 'OPEN' NOT NULL,
reason_code varchar(80) NOT NULL,
evidence_ref uuid DEFAULT NULL,
resolved_by_subject uuid DEFAULT NULL,
resolved_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, closure_hold_id)
);

CREATE TABLE ec07.closure_receipt (
tenant_id uuid NOT NULL,
closure_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,
academic_closure_id uuid NOT NULL,
scope_hash varchar(128) NOT NULL,
completion_set_hash varchar(128) NOT NULL,
policy_snapshot jsonb DEFAULT '{}'::jsonb NOT NULL,
expected_count integer NOT NULL,
completed_count integer NOT NULL,
not_completed_count integer NOT NULL,
excluded_count integer DEFAULT 0 NOT NULL,
canonical_schema_version varchar(32) DEFAULT 'v1' NOT NULL,
hash_algorithm varchar(32) DEFAULT 'SHA-256' NOT NULL,
closed_by_subject uuid NOT NULL,
assurance_level varchar(40) DEFAULT NULL,
closed_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, c
```

```
losure_receipt_id)
);

CREATE TABLE ec07.idempotency_key (
tenant_id uuid NOT NULL,
idempotency_key varchar(160) NOT NULL,
operation_code varchar(80) NOT NULL,
request_hash varchar(128) NOT NULL,
state varchar(20) DEFAULT 'IN_PROGRESS' NOT NULL,
owner_id varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
response_code integer DEFAULT NULL,
response_body jsonb DEFAULT NULL,
resource_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, idempotency_key, operation_code)
);

CREATE TABLE ec07.outbox_event (
tenant_id uuid NOT NULL,
event_id uuid DEFAULT gen_random_uuid() NOT NULL,
aggregate_type varchar(80) NOT NULL,
aggregate_id uuid NOT NULL,
event_type varchar(120) NOT NULL,
schema_version integer DEFAULT 1 NOT NULL,
correlation_id uuid NOT NULL,
causation_id uuid DEFAULT NULL,
payload jsonb NOT NULL,
state varchar(20) DEFAULT 'PENDING' NOT NULL,
owner_id varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
attempt_count integer DEFAULT 0 NOT NULL,
next_attempt_at timestamptz DEFAULT NULL,
occurred_at timestamptz DEFAULT now() NOT NULL,
published_at timestamptz DEFAULT NULL,
PRIMARY KEY (tenant_id, event_id)
);

CREATE TABLE ec07.inbox_message (
tenant_id uuid NOT NULL,
consumer_code varchar(100) NOT NULL,
message_id varchar(180) NOT NULL,
payload_hash varchar(128) NOT NULL,
state varchar(20) DEFAULT 'IN_PROGRESS' NOT NULL,
owner_id varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
processed_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, consumer_code, message_id)
);

CREATE TABLE ec07.operation_status (
tenant_id uuid NOT NULL,
operation_id uuid DEFAULT gen_random_uuid() NOT NULL,
operation_type varchar(80) NOT NULL,
resource_ref uuid DEFAULT NULL,
state varchar(24) DEFAULT 'PENDING' NOT NULL,
remote_receipt_ref varchar(180) DEFAULT NULL,
last_reason_code varchar(80) DEFAULT NULL,
result_payload jsonb DEFAULT NULL,
owner_id varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
PRIMARY KEY (tenant_id, operation_id)
);


CREATE UNIQUE INDEX uq_ec07_component_code ON ec07.assessment_component(tenant_id, assessment_plan_id, component_code);
CREATE UNIQUE INDEX uq_ec07_component_order ON ec07.assessment_component(tenant_id, assessment_plan_id, sequence_no);
ALTER TABLE ec07.assessment_component ADD CONSTRAINT ck_ec07_component_weight CHECK (weight_value IS NULL OR weight_value >= 0);
ALTER TABLE ec07.assessment_window ADD CONSTRAINT ck_ec07_window_range CHECK (close_at IS NULL OR open_at IS NULL OR close_at >= open_at);
ALTER TABLE ec07.attempt ADD CONSTRAINT ck_ec07_attempt_no CHECK (attempt_no > 0);
ALTER TABLE ec07.attempt ADD CONSTRAINT ck_ec07_attempt_subject CHECK ((participant_evaluation_id IS NOT NULL)::int + (evaluation_group_id IS NOT NULL)::int = 1);
CREATE UNIQUE INDEX uq_ec07_attempt_receipt ON ec07.attempt(tenant_id, source_type, source_receipt_ref) WHERE source_receipt_ref IS NOT NULL;
ALTER TABLE ec07.score_fact ADD CONSTRAINT ck_ec07_score_value_present CHECK (original_value IS NOT NULL OR original_text_value IS NOT NULL);
ALTER TABLE ec07.result_fact ADD CONSTRAINT ck_ec07_result_status CHECK (result_status IN ('PASS','FAIL','INCOMPLETE','ABSENT','EXEMPT','NOT_EVALUATED'));
ALTER TABLE ec07.completion_fact ADD CONSTRAINT ck_ec07_completion_status CHECK (completion_status IN ('COMPLETED','NOT_COMPLETED'));
ALTER TABLE ec07.completion_rule_fact ADD CONSTRAINT ck_ec07_completion_rule_outcome CHECK (outcome IN ('SATISFIED','NOT_SATISFIED','UNKNOWN','WAIVED'));
ALTER TABLE ec07.academic_closure ADD CONSTRAINT ck_ec07_closure_counts CHECK (expected_enrollment_count >= 0 AND current_completion_count >= 0 AND pending_count >= 0);
ALTER TABLE ec07.closure_receipt ADD CONSTRAINT ck_ec07_receipt_counts CHECK (expected_count >= 0 AND completed_count >= 0 AND not_completed_count >= 0 AND excluded_count >= 0);
```

## 13.1 RLS defense-in-depth

```
-- Runtime transaction: SET LOCAL peopleu.tenant_id = '<uuid>';
CREATE OR REPLACE FUNCTION ec07.current_tenant() RETURNS uuid LANGUAGE sql STABLE AS $$ SELECT current_setting('peopleu.tenant_id', true)::uuid $$;

ALTER TABLE ec07.assessment_plan ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.assessment_plan FORCE ROW LEVEL SECURITY;
CREATE POLICY p_assessment_plan_tenant ON ec07.assessment_plan USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.assessment_component ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.assessment_component FORCE ROW LEVEL SECURITY;
CREATE POLICY p_assessment_component_tenant ON ec07.assessment_component USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.component_outcome_binding ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.component_outcome_binding FORCE ROW LEVEL SECURITY;
CREATE POLICY p_component_outcome_binding_tenant ON ec07.component_outcome_binding USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.assessment_window ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.assessment_window FORCE ROW LEVEL SECURITY;
CREATE POLICY p_assessment_window_tenant ON ec07.assessment_window USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.rubric_binding ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.rubric_binding FORCE ROW LEVEL SECURITY;
CREATE POLICY p_rubric_binding_tenant ON ec07.rubric_binding USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.evaluation_group ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.evaluation_group FORCE ROW LEVEL SECURITY;
CREATE POLICY p_evaluation_group_tenant ON ec07.evaluation_group USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.evaluation_group_member ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.evaluation_group_member FORCE ROW LEVEL SECURITY;
CREATE POLICY p_evaluation_group_member_tenant ON ec07.evaluation_group_member USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.participant_evaluation ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.participant_evaluation FORCE ROW LEVEL SECURITY;
CREATE POLICY p_participant_evaluation_tenant ON ec07.participant_evaluation USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.attempt ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.attempt FORCE ROW LEVEL SECURITY;
CREATE POLICY p_attempt_tenant ON ec07.attempt USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.attempt_evidence_ref ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.attempt_evidence_ref FORCE ROW LEVEL SECURITY;
CREATE POLICY p_attempt_evidence_ref_tenant ON ec07.attempt_evidence_ref USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.score_fact ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.score_fact FORCE ROW LEVEL SECURITY;
CREATE POLICY p_score_fact_tenant ON ec07.score_fact USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.result_fact ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.result_fact FORCE ROW LEVEL SECURITY;
CREATE POLICY p_result_fact_tenant ON ec07.result_fact USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.result_adjustment_request ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.result_adjustment_request FORCE ROW LEVEL SECURITY;
CREATE POLICY p_result_adjustment_request_tenant ON ec07.result_adjustment_request USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.result_adjustment_decision ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.result_adjustment_decision FORCE ROW LEVEL SECURITY;
CREATE POLICY p_result_adjustment_decision_tenant ON ec07.result_adjustment_decision USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.appeal_case ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.appeal_case FORCE ROW LEVEL SECURITY;
CREATE POLICY p_appeal_case_tenant ON ec07.appeal_case USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.appeal_decision ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.appeal_decision FORCE ROW LEVEL SECURITY;
CREATE POLICY p_appeal_decision_tenant ON ec07.appeal_decision USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.completion_evaluation ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.completion_evaluation FORCE ROW LEVEL SECURITY;
CREATE POLICY p_completion_evaluation_tenant ON ec07.completion_evaluation USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.completion_rule_fact ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.completion_rule_fact FORCE ROW LEVEL SECURITY;
CREATE POLICY p_completion_rule_fact_tenant ON ec07.completion_rule_fact USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.completion_fact ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.completion_fact FORCE ROW LEVEL SECURITY;
CREATE POLICY p_completion_fact_tenant ON ec07.completion_fact USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.completion_restatement ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.completion_restatement FORCE ROW LEVEL SECURITY;
CREATE POLICY p_completion_restatement_tenant ON ec07.completion_restatement USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.academic_closure ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.academic_closure FORCE ROW LEVEL SECURITY;
CREATE POLICY p_academic_closure_tenant ON ec07.academic_closure USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.closure_scope_item ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.closure_scope_item FORCE ROW LEVEL SECURITY;
CREATE POLICY p_closure_scope_item_tenant ON ec07.closure_scope_item USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.closure_hold ENABLE ROW LEVE
```

```
L SECURITY;
ALTER TABLE ec07.closure_hold FORCE ROW LEVEL SECURITY;
CREATE POLICY p_closure_hold_tenant ON ec07.closure_hold USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.closure_receipt ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.closure_receipt FORCE ROW LEVEL SECURITY;
CREATE POLICY p_closure_receipt_tenant ON ec07.closure_receipt USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.idempotency_key ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.idempotency_key FORCE ROW LEVEL SECURITY;
CREATE POLICY p_idempotency_key_tenant ON ec07.idempotency_key USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.outbox_event ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.outbox_event FORCE ROW LEVEL SECURITY;
CREATE POLICY p_outbox_event_tenant ON ec07.outbox_event USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.inbox_message ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.inbox_message FORCE ROW LEVEL SECURITY;
CREATE POLICY p_inbox_message_tenant ON ec07.inbox_message USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());

ALTER TABLE ec07.operation_status ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec07.operation_status FORCE ROW LEVEL SECURITY;
CREATE POLICY p_operation_status_tenant ON ec07.operation_status USING (tenant_id = ec07.current_tenant()) WITH CHECK (tenant_id = ec07.current_tenant());
```

## 13.2 Triggers defensivos — append-only, lifecycle y aggregate revision

```
CREATE OR REPLACE FUNCTION ec07.forbid_update_delete() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
RAISE EXCEPTION 'EC07_APPEND_ONLY_FACT' USING ERRCODE='23514';
END $$;

CREATE TRIGGER trg_score_fact_append_only BEFORE UPDATE OR DELETE ON ec07.score_fact FOR EACH ROW EXECUTE FUNCTION ec07.forbid_update_delete();
CREATE TRIGGER trg_result_fact_append_only BEFORE UPDATE OR DELETE ON ec07.result_fact FOR EACH ROW EXECUTE FUNCTION ec07.forbid_update_delete();
CREATE TRIGGER trg_completion_fact_append_only BEFORE UPDATE OR DELETE ON ec07.completion_fact FOR EACH ROW EXECUTE FUNCTION ec07.forbid_update_delete();
CREATE TRIGGER trg_closure_receipt_append_only BEFORE UPDATE OR DELETE ON ec07.closure_receipt FOR EACH ROW EXECUTE FUNCTION ec07.forbid_update_delete();

CREATE OR REPLACE FUNCTION ec07.touch_assessment_plan() RETURNS trigger LANGUAGE plpgsql AS $$
DECLARE v_plan uuid;
BEGIN
v_plan := COALESCE(NEW.assessment_plan_id, OLD.assessment_plan_id);
UPDATE ec07.assessment_plan
SET version = version + 1, updated_at = now()
WHERE tenant_id = COALESCE(NEW.tenant_id, OLD.tenant_id)
AND assessment_plan_id = v_plan AND state='DRAFT';
IF NOT FOUND THEN RAISE EXCEPTION 'EC07_PLAN_NOT_EDITABLE' USING ERRCODE='23514'; END IF;
RETURN COALESCE(NEW, OLD);
END $$;

-- Aplicar child triggers equivalentes a component/window/rubric/outcome binding.
-- State transition guards deben permitir solo transiciones documentadas.
-- Lineage guards deben exigir same-scope, no self-reference y grafo acíclico.
```

## 13.3 Outbox claim multi-instancia

```
WITH claimed AS (
SELECT tenant_id, event_id
FROM ec07.outbox_event
WHERE state IN ('PENDING','FAILED')
AND (next_attempt_at IS NULL OR next_attempt_at <= now())
AND (lease_until IS NULL OR lease_until < now())
ORDER BY occurred_at
FOR UPDATE SKIP LOCKED
LIMIT :batch_size
)
UPDATE ec07.outbox_event o
SET state='IN_FLIGHT', owner_id=:worker_id,
lease_until=now() + (:lease_seconds || ' seconds')::interval,
attempt_count=attempt_count+1
FROM claimed c
WHERE o.tenant_id=c.tenant_id AND o.event_id=c.event_id
RETURNING o.*;
```

## 13.4 Roles de base de datos

```
-- peopleu_migrator: owner/DDL, nunca HTTP runtime.
-- peopleu_ec07_runtime: DML mínimo, NO BYPASSRLS, NO table ownership.
-- peopleu_ec07_worker: outbox/inbox/reconcile mínimo, NO BYPASSRLS.
REVOKE ALL ON SCHEMA ec07 FROM PUBLIC;
-- Grants explícitos por ambiente y política de rotación de secretos.
```

# 14. MongoDB y Redis

PostgreSQL es Source of Truth. MongoDB solo puede alojar read models derivados, reconstruibles y no autoritativos, por ejemplo timelines compactas de evaluación, dashboards de cierre o projections de lineage. Un read model Mongo nunca decide PASS/COMPLETION si PostgreSQL o los inputs oficiales no están disponibles.

Redis se usa únicamente como acelerador: cache de policies inmutables por version, rate limiting, query cache breve y coordinación efímera. No almacena la única copia de attempts, grades, results, completion facts, holds ni closure receipts.

| **Key pattern**                            | **TTL**   | **Uso permitido**                       |
|--------------------------------------------|-----------|-----------------------------------------|
| ec07:policy:{tenant}:{policyVersion}       | Gobernado | Cache inmutable de policy version.      |
| ec07:plan:{tenant}:{planId}:summary        | 1–5 min   | Read summary; invalidar por event.      |
| ec07:closure:{tenant}:{closureId}:progress | 30–60 s   | Progress UI; DB sigue SoT.              |
| ec07:ratelimit:{tenant}:{subject}:{route}  | Window    | Rate limit.                             |
| ec07:op:{tenant}:{operationId}             | Corto     | Hint de polling; durable en PostgreSQL. |

# 15. Backend Java 21 / Spring Boot / Spring Modulith

EC-07 se implementa como módulo Spring Modulith con arquitectura hexagonal. El dominio no depende de JPA, LMS, UI ni providers. Application Services orquestan transacciones, autorización, idempotencia, aggregate revision y ports. Adapters encapsulan PostgreSQL, IAM/TenantContext, CT-02/05/06/18, EC-01/02/04/05/06 y transporte de eventos.

| **Paquete**             | **Responsabilidad**                                                                                        |
|-------------------------|------------------------------------------------------------------------------------------------------------|
| domain/model            | AssessmentPlan, ParticipantEvaluation, Attempt, Score/Result facts, CompletionEvaluation, AcademicClosure. |
| domain/policy           | Publication, AttemptEligibility, ResultAdjudication, Completion, Closure, Correction.                      |
| domain/service          | Normalizer, Adjudicator, CompletionEvaluator, ClosurePreflight, Lineage/Reconciliation.                    |
| application/command     | Commands de intención; no setters.                                                                         |
| application/query       | Queries paginadas/read models con provenance/freshness.                                                    |
| application/port/in     | Use cases.                                                                                                 |
| application/port/out    | Policy, evidence, workflow, LMS, attendance, audit/event ports.                                            |
| adapter/in/rest         | Controllers + ProblemDetail.                                                                               |
| adapter/in/event        | Inbox consumers.                                                                                           |
| adapter/out/persistence | Repositories tenant-aware.                                                                                 |
| adapter/out/integration | Clients timeout/retry/reconcile.                                                                           |
| adapter/out/event       | Outbox dispatcher.                                                                                         |
| config                  | Security, RLS tenant context, observability.                                                               |

## 15.1 Patrones obligatorios

- @Transactional en application use case, no controller.

- TenantContext se propaga con SET LOCAL dentro de la misma conexión/transacción.

- @Version solo en roots editables; facts append-only usan identity/hash/lineage.

- Repository methods no exponen findAll() sin scope/tenant.

- BigDecimal con MathContext/rounding de policy para score/weights.

- Controllers no hacen cálculo de notas.

- Ports externos retornan estados semánticos, no null ambiguo.

- Publicación/facts/cierre escriben outbox en la misma transacción.

- Consumers usan inbox dedup antes de side effects.

- Reason codes estables y contract-tested.

## 15.2 Pseudocódigo — adjudicación de resultado

```
@Transactional
ResultFactDto adjudicate(AdjudicateResultCommand cmd, TenantContext ctx) {
tenantSql.setLocal(ctx.tenantId());
var pe = participantEvaluationRepo.lock(ctx.tenantId(), cmd.participantEvaluationId());
etag.requireMatch(pe.version(), cmd.ifMatch());
var plan = planRepo.requirePublished(ctx.tenantId(), pe.assessmentPlanId());
var inputs = attemptSelection.select(pe, cmd.componentId(), plan.policySnapshot());
var result = adjudicator.adjudicate(inputs, policyPort.resolveImmutable(plan.gradingPolicyRef()));
var fact = resultFactRepo.append(result.toFact(ctx.actor(), clock.now()));
outbox.append(ResultFactPublished.from(fact, ctx.correlationId()));
audit.record(...);
return mapper.toDto(fact);
}
```

# 16. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

Base path sugerido: /api/ec/v1/evaluation. OpenAPI es contrato ejecutable. Colecciones usan paginación bounded, filtros allow-listed y sorting estable. Mutaciones editables exigen If-Match; comandos críticos Idempotency-Key. tenant_id nunca aparece como campo libre de negocio.

| **Método** | **Endpoint**                                                      | **Propósito**           | **Control**              | **HTTP** |
|------------|-------------------------------------------------------------------|-------------------------|--------------------------|----------|
| POST       | /assessment-plans                                                 | Crear plan              | Idempotency-Key          | 201      |
| GET        | /assessment-plans                                                 | Listar planes           | —                        | 200      |
| GET        | /assessment-plans/{id}                                            | Detalle + ETag          | —                        | 200      |
| PATCH      | /assessment-plans/{id}                                            | Metadata DRAFT          | If-Match                 | 200      |
| POST       | /assessment-plans/{id}/validate                                   | Preflight               | If-Match opt.            | 200      |
| POST       | /assessment-plans/{id}/submit-review                              | Review                  | Idempotency-Key+If-Match | 202/200  |
| POST       | /assessment-plans/{id}/publish                                    | Publish                 | Idempotency-Key+If-Match | 201      |
| POST       | /assessment-plans/{id}/components                                 | Agregar componente      | If-Match                 | 201      |
| PUT        | /assessment-plans/{id}/components/{componentId}                   | Editar DRAFT            | If-Match                 | 200      |
| POST       | /assessment-plans/{id}/components/{componentId}/windows           | Ventana                 | If-Match                 | 201      |
| POST       | /assessment-plans/{id}/groups                                     | Crear grupo             | Idempotency-Key          | 201      |
| POST       | /groups/{id}/members                                              | Agregar member          | If-Match                 | 201      |
| POST       | /groups/{id}/freeze                                               | Freeze grupo            | Idempotency-Key+If-Match | 200      |
| POST       | /participant-evaluations                                          | Crear/obtener           | Idempotency-Key          | 200/201  |
| GET        | /participant-evaluations/{id}                                     | Detalle + ETag          | —                        | 200      |
| POST       | /participant-evaluations/{id}/attempts                            | Registrar attempt       | Idempotency-Key+If-Match | 201      |
| POST       | /attempts/{id}/evidence                                           | Adjuntar evidence       | Idempotency-Key          | 201      |
| POST       | /attempts/{id}/accept                                             | Aceptar attempt         | Idempotency-Key          | 200      |
| POST       | /attempts/{id}/invalidate                                         | Invalidar attempt       | Idempotency-Key          | 200      |
| POST       | /participant-evaluations/{id}/components/{componentId}/adjudicate | Adjudicar result        | Idempotency-Key+If-Match | 201      |
| GET        | /participant-evaluations/{id}/results                             | Results/lineage         | —                        | 200      |
| GET        | /results/{id}                                                     | Fact                    | —                        | 200      |
| POST       | /results/{id}/adjustments                                         | Solicitar ajuste        | Idempotency-Key          | 201      |
| POST       | /adjustments/{id}/decision                                        | Decidir ajuste          | Idempotency-Key+If-Match | 201      |
| POST       | /adjustments/{id}/apply                                           | Aplicar ajuste          | Idempotency-Key          | 201      |
| POST       | /results/{id}/appeals                                             | Crear appeal            | Idempotency-Key          | 201      |
| POST       | /appeals/{id}/decision                                            | Resolver appeal         | Idempotency-Key+If-Match | 201      |
| POST       | /completion-evaluations                                           | Calcular completion     | Idempotency-Key          | 200/201  |
| GET        | /completion-evaluations/{id}                                      | Rule facts              | —                        | 200      |
| POST       | /completion-evaluations/{id}/publish                              | Publicar CompletionFact | Idempotency-Key+If-Match | 201      |
| GET        | /enrollments/{enrollmentRef}/completion                           | Current completion      | —                        | 200/404  |
| POST       | /completion-facts/{id}/restatements                               | Restate completion      | Idempotency-Key          | 201      |
| POST       | /academic-closures                                                | Crear cierre            | Idempotency-Key          | 201      |
| POST       | /academic-closures/{id}/preflight                                 | Preflight               | Idempotency-Key+If-Match | 200      |
| GET        | /academic-closures/{id}/holds                                     | Holds                   | —                        | 200      |
| POST       | /academic-closures/{id}/holds/{holdId}/resolve                    | Resolver hold           | Idempotency-Key+If-Match | 200      |
| POST       | /academic-closures/{id}/close                                     | Close                   | Idempotency-Key+If-Match | 201      |
| POST       | /academic-closures/{id}/reopen                                    | Reopen                  | Idempotency-Key+If-Match | 202/200  |
| GET        | /academic-closures/{id}/receipt                                   | Receipt                 | —                        | 200      |
| POST       | /bulk-scores/dry-run                                              | Dry-run batch           | Idempotency-Key          | 200      |
| POST       | /bulk-scores/promote                                              | Promote batch           | Idempotency-Key          | 202      |
| GET        | /operations/{id}                                                  | OperationStatus         | —                        | 200      |
| POST       | /operations/{id}/reconcile                                        | Reconcile               | Idempotency-Key          | 202/200  |
| GET        | /dashboards/pending                                               | Pendientes              | —                        | 200      |

## 16.1 Paginación, filtros y orden

Baseline: pageSize default 50, máximo 200 salvo bulk contract; sort estable con tie-breaker id; filtros allow-listed. Para timelines/facts se prefiere cursor opaco basado en occurred_at/id. Nunca colección ilimitada.

## 16.2 ProblemDetail y reason codes

| **HTTP** | **Reason code**                                                | **Uso**                     |
|----------|----------------------------------------------------------------|-----------------------------|
| 400      | REQUEST_INVALID                                                | Schema/formato inválido.    |
| 401      | AUTHENTICATION_REQUIRED                                        | No autenticado.             |
| 403      | SCOPE_FORBIDDEN / SOD_VIOLATION                                | No autorizado.              |
| 404      | RESOURCE_NOT_FOUND                                             | No visible en tenant/scope. |
| 409      | STATE_CONFLICT / IDEMPOTENCY_KEY_REUSED / LINEAGE_CONFLICT     | Conflicto.                  |
| 412      | PRECONDITION_FAILED                                            | ETag obsoleto.              |
| 422      | BUSINESS_RULE_VIOLATION / POLICY_MISSING / ATTEMPT_NOT_ALLOWED | Regla negocio.              |
| 429      | RATE_LIMITED                                                   | Límite técnico.             |
| 503      | DEPENDENCY_UNAVAILABLE                                         | Dependencia crítica.        |

## 16.3 DTOs nucleares

| **DTO**                 | **Contrato mínimo**                                                                                                  |
|-------------------------|----------------------------------------------------------------------------------------------------------------------|
| AssessmentPlanDto       | id, editionRef, cohortRef, programVersionRef, planNo, state, policyRefs, contentHash, version, links.                |
| AssessmentComponentDto  | id, code, typeCode, title, weight, mandatory, attemptPolicyRef, selectionPolicyRef, scaleRef, rubricRef, sequenceNo. |
| AttemptDto              | id, subjectType, subjectRef, componentId, attemptNo, sourceType, timestamps, state, lateFlag, evidenceRefs.          |
| ScoreFactDto            | id, attemptId, original value/scale, normalized value/scale, policyRef, supersedesId, hash.                          |
| ResultFactDto           | id, componentId, resultStatus, finalScore, gradeCode, selected refs, policySnapshot, supersedesId, hash.             |
| CompletionEvaluationDto | id, enrollmentRef, policyRef, inputHash, state, candidateStatus, rules\[\].                                          |
| CompletionFactDto       | id, enrollmentRef, status, completionDate, supersedesId, policySnapshot, hash.                                       |
| AcademicClosureDto      | id, editionRef, cohortRef, cycleNo, state, counts, holdsSummary, scopeHash, version.                                 |
| OperationStatusDto      | operationId, type, state, resourceRef, reasonCode, timestamps, retryAfterMs?, links.                                 |

# 17. Eventos, outbox/inbox y AsyncAPI

| **Evento**                     | **Publisher** | **Consumer principal** | **Semántica**           |
|--------------------------------|---------------|------------------------|-------------------------|
| AssessmentPlanPublished.v1     | EC-07         | Ops/analytics          | Plan publicado.         |
| AttemptAccepted.v1             | EC-07         | Analytics              | Attempt oficial.        |
| AttemptInvalidated.v1          | EC-07         | Audit/analytics        | Attempt invalidado.     |
| ResultFactPublished.v1         | EC-07         | EC-08/10/11            | Result oficial.         |
| ResultFactRestated.v1          | EC-07         | Consumers result       | Result superseded.      |
| AppealDecisionRecorded.v1      | EC-07         | Workflow/audit         | Decision appeal.        |
| CompletionEvaluationBlocked.v1 | EC-07         | Ops/notif              | Completion bloqueado.   |
| CompletionFactPublished.v1     | EC-07         | EC-08/10/11            | Completion oficial.     |
| CompletionFactRestated.v1      | EC-07         | EC-08/10               | Completion restated.    |
| AcademicClosureReady.v1        | EC-07         | Ops                    | Ready close.            |
| AcademicClosureClosed.v1       | EC-07         | EC-08/11/Ops           | Cierre oficial.         |
| AcademicClosureReopened.v1     | EC-07         | Downstream             | Scope reabierto.        |
| LmsGradeObserved.v1            | CT-18         | EC-07 inbox            | Grade externo.          |
| AttendanceFactPublished.v1     | EC-06         | EC-07 inbox            | Input completion.       |
| EnrollmentStatusChanged.v1     | EC-04         | EC-07 inbox            | Scope/completion.       |
| WorkflowDecisionRecorded.v1    | CT-06         | EC-07 inbox            | Review/appeal decision. |

## 17.1 Envelope obligatorio

```
{
"eventId": "uuid",
"eventType": "CompletionFactPublished.v1",
"schemaVersion": 1,
"tenantId": "uuid",
"aggregateId": "uuid",
"occurredAt": "2026-10-31T18:00:00Z",
"correlationId": "uuid",
"causationId": "uuid|null",
"payload": {"completionFactId":"uuid","enrollmentRef":"uuid","status":"COMPLETED","contentHash":"sha256:..."}
}
```

## 17.2 Compatibilidad

AsyncAPI declara schemas versionados y compatibility policy. Cambios breaking crean nueva versión/eventType. Payload minimiza PII y conserva solo business facts estrictamente necesarios.

# 18. Integraciones, resiliencia, reconciliación y UNKNOWN_EFFECT

| **Dependencia** | **Operación**     | **Timeout**      | **Retry**             | **Degradación/reconcile**                     |
|-----------------|-------------------|------------------|-----------------------|-----------------------------------------------|
| CT-02           | Policy/scale refs | 500–1500 ms      | Reads safe            | Cache versioned; critical fail-closed.        |
| CT-05           | Evidence metadata | 1–3 s            | Read safe             | UNAVAILABLE ≠ missing.                        |
| CT-06           | Workflow          | 2–5 s            | Idempotent + receipt  | Post-send timeout =\> UNKNOWN_EFFECT.         |
| CT-18 LMS       | Attempts/grades   | 2–10 s           | Webhook/inbox + query | Dedup; ambiguous =\> quarantine.              |
| EC-06           | Attendance facts  | 1–3 s            | Read/event            | STALE/UNAVAILABLE blocks critical completion. |
| EC-08           | Completion events | Async            | Outbox                | Failure no rollback local.                    |
| IAM/CT-10       | Auth/audit        | Sub-second/async | No blind auth retry   | Fail-closed critical.                         |

## 18.1 Patrón UNKNOWN_EFFECT

Cuando EC-07 envía un comando remoto y el timeout ocurre después de que el proveedor pudo aplicar el efecto, OperationStatus pasa a UNKNOWN_EFFECT. El reconciler consulta status/lookup idempotente y solo reintenta si demuestra NOT_APPLIED.

| **PROHIBIDO —** Timeout =\> retry para operaciones con side effect remoto. Patrón: TIMEOUT → UNKNOWN_EFFECT → RECONCILE → {APPLIED \| NOT_APPLIED \| STILL_UNKNOWN} → retry solo NOT_APPLIED. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 19. Frontend Web enterprise por workspaces

Frontend usa React + TypeScript y client generado desde OpenAPI. Cada workspace distingue loading, no-data, zero, not-evaluated, stale, partial, unavailable y unknown-effect. Mutations usan ETag/If-Match y 412 con rebase/reload explícito.

| **Workspace**                 | **Usuario**          | **Ruta**                             | **Layout/componentes**                                                                                  | **Acciones**                       |
|-------------------------------|----------------------|--------------------------------------|---------------------------------------------------------------------------------------------------------|------------------------------------|
| Evaluation Plan Studio        | Designer/Coordinator | /ec/evaluation/plans/:id             | Header state/ETag; tabs Components, Weights, Windows, Outcomes, Rubrics, Policies, Validation, History. | Editar/validar/review/publish.     |
| Instructor Grading Console    | Instructor           | /ec/evaluation/plans/:planId/grading | Roster virtualizado; filters; participant drawer; attempt timeline; rubric panel.                       | Attempt/score/evidence/adjudicate. |
| Participant Assessment Portal | Participant          | /my/ec/:enrollment/evaluations       | Cards component/window/attempts/result/appeal.                                                          | Submit/read/appeal.                |
| Results & Exceptions Desk     | Governance           | /ec/evaluation/results               | Queue incomplete/absent/adjustments/appeals; lineage viewer.                                            | Decide/apply.                      |
| Completion Workspace          | Coordinator          | /ec/evaluation/completion            | Matrix participant×rule; provenance drawer; stale indicators.                                           | Compute/publish.                   |
| Academic Closure Center       | Governance/Ops       | /ec/evaluation/closures/:id          | Readiness KPIs, counts, holds, dependency health, evidence pack.                                        | Preflight/resolve/close/reopen.    |
| Reconciliation Center         | Ops                  | /ec/evaluation/reconciliation        | UNKNOWN_EFFECT, outbox/inbox, correlation IDs.                                                          | Reconcile/reclaim safe retry.      |
| Audit & Lineage Explorer      | Auditor              | /ec/evaluation/audit                 | Timeline facts/hashes/policies/evidence.                                                                | Read/export.                       |

## 19.1 Estados UI obligatorios

| **Estado**     | **Semántica**                         | **Tratamiento UI**                          |
|----------------|---------------------------------------|---------------------------------------------|
| NO_DATA        | Consulta exitosa sin entidades.       | No existen evaluaciones.                    |
| ZERO           | Valor realmente 0.                    | Mostrar 0.                                  |
| NOT_EVALUATED  | Obligación existente aún no evaluada. | Badge + próxima acción.                     |
| STALE          | Dato fuera de freshness.              | Timestamp/provenance; bloquear si critical. |
| PARTIAL        | Respuesta incompleta.                 | Banner fuentes faltantes.                   |
| UNAVAILABLE    | Dependencia no respondió.             | Error + correlationId.                      |
| UNKNOWN_EFFECT | Comando remoto incierto.              | Reconciliando; no retry ciego.              |

## 19.2 Baseline frontend no negociable

- API client/DTOs generados desde OpenAPI.

- Query keys estables por tenant/scope/resource/version.

- React Hook Form + schema validation para forms complejos.

- ProblemDetail mapper central + Error Boundary.

- ETag junto al query data; mutation envía If-Match.

- Lists grandes virtualizadas/paginadas.

- Accessibility WCAG 2.2 AA baseline.

- No persistir resultados sensibles en localStorage sin contrato.

# 20. Mobile

EC-07 sí tiene casos móviles reales para participantes e instructores. Mobile no replica Governance ni permite close/reopen/restatement crítico por comodidad. React Native consume los mismos contratos.

| **Journey**  | **Capacidades**                                 | **Offline/sync**                                                     | **Seguridad/push**                        |
|--------------|-------------------------------------------------|----------------------------------------------------------------------|-------------------------------------------|
| Participante | Ver windows, submit, evidence, results, appeal. | Offline draft/queue si policy; no success hasta receipt.             | Push CT-07; deep links.                   |
| Instructor   | Roster limitado, score/rubric/evidence.         | Offline capture queued + conflict detection; final online si policy. | Biometría local; server step-up critical. |
| Governance   | Readiness consulta.                             | No critical mutations por defecto.                                   | Deep link a Web segura.                   |

# 21. Matriz Frontend / Backend / Mobile

| **Capability** | **Web**                    | **Backend**                   | **Mobile**     |
|----------------|----------------------------|-------------------------------|----------------|
| Diseñar plan   | Completo                   | Commands/validation/publish   | No             |
| Grade manual   | Completo                   | Attempt/Score/Result          | Instructor sí  |
| LMS grade      | Monitor                    | Inbox/adapter/adjudication    | No directo     |
| Appeals        | Staff + participant portal | Workflow/decision/restatement | Participant sí |
| Completion     | Completo                   | Evaluator/facts               | Read only      |
| Closure        | Completo                   | Preflight/holds/receipt       | Read only      |
| Reconciliation | Ops                        | OperationStatus/outbox/inbox  | No             |
| Audit lineage  | Completo                   | Query/export                  | Limitado       |

# 22. Seguridad: RBAC, ABAC, SoD, step-up y privacy

Seguridad combina RBAC para capacidades, ABAC para tenant/scope/edition/component/relationship y SoD para decisiones de alto impacto. InstructorAssignment no concede automáticamente permiso; IAM/CT-10 evalúan rol, scope y policy. Resultados y accommodations son información sensible académica y se minimiza exposición.

| **Role**                | **Permisos**                  | **ABAC**                            | **Restricción**                 |
|-------------------------|-------------------------------|-------------------------------------|---------------------------------|
| EC_EVALUATION_DESIGNER  | Plan DRAFT/components         | tenant+academic scope               | No publish propio si SoD.       |
| EC_INSTRUCTOR_EVALUATOR | Attempts/scores autorizados   | edition/cohort/component+assignment | No restatement/close.           |
| EC_ACADEMIC_APPROVER    | Review/approve                | scope+SoD                           | No auto-aprobar trabajo propio. |
| EC_RESULT_GOVERNANCE    | Restatement/appeal/completion | scope+assurance                     | Step-up.                        |
| EC_CLOSURE_GOVERNANCE   | Close/reopen                  | scope+readiness+assurance           | Step-up+SoD.                    |
| EC_DATA_OPERATOR        | Bulk dry-run/promote          | scope+import permission             | No grade authority implícita.   |
| EC_OPS                  | Reconcile/outbox              | technical scope                     | No semantic result mutation.    |
| EC_AUDITOR              | Read lineage/evidence         | purpose+scope                       | Read only.                      |
| EC_PARTICIPANT          | Own results/submit/appeal     | subject relationship                | No otros participants.          |

## 22.1 Threat Model EC-07

| **Amenaza**          | **Vector**                   | **Mitigación**                              |
|----------------------|------------------------------|---------------------------------------------|
| IDOR cross-tenant    | Manipular IDs result/closure | RLS FORCE + authz + negative tests.         |
| Mass assignment      | Enviar state/tenant          | DTO allow-list; server-derived.             |
| Grade tampering      | Modificar fact               | Append-only trigger/revoke/hash/lineage.    |
| Replay               | Reenviar grade/close         | Durable idempotency.                        |
| ETag bypass          | Concurrent graders           | If-Match + root lock.                       |
| LMS spoof            | Webhook falso/repetido       | Provider auth + inbox dedup + trust policy. |
| Privilege escalation | Instructor→governance        | RBAC+ABAC+SoD+step-up.                      |
| Data exfiltration    | Bulk export                  | Least privilege + audit + field filtering.  |
| Prompt injection     | Submission ataca IA          | CT-12 isolation; no authority.              |
| DoS batch            | Payload masivo               | Capacity budgets/rate limit/async.          |

## 22.2 Secure SDLC

- SAST, SCA, secret scanning, container scanning y SBOM en CI.

- High/Critical findings bloquean release salvo excepción formal.

- Authz/RLS contract tests incluyen cross-tenant negative cases.

- Separate DB roles migrator/runtime/worker.

- Secrets por vault/secret manager.

- Dependency pinning/updates gobernados.

- Security regression para IDOR, mass assignment, replay, races y export privacy.

# 23. Auditoría, Evidence Pack, lineage y reason codes

Toda operación crítica registra tenant, actor/actor_type, subject, scope, timestamp, action, resource, before/after refs cuando aplica, reason code, correlationId, causationId, policy/rubric refs, evidence refs y assurance/step-up. El audit técnico no sustituye facts/receipts de dominio.

| **Acción**                    | **Recurso**     | **Evidencia mínima**                                        |
|-------------------------------|-----------------|-------------------------------------------------------------|
| PLAN_PUBLISHED                | AssessmentPlan  | Actor, hash, policy snapshot, workflow/evidence, assurance. |
| ATTEMPT_ACCEPTED/INVALIDATED  | Attempt         | Source, timestamps, evidence refs, reason.                  |
| SCORE_RECORDED                | ScoreFact       | Original/normalized refs, evaluator/source, policy.         |
| RESULT_PUBLISHED/RESTATED     | ResultFact      | Inputs, policy, lineage, reason, actor.                     |
| APPEAL_DECIDED                | AppealDecision  | Committee/actor, evidence, reason, effect link.             |
| COMPLETION_PUBLISHED/RESTATED | CompletionFact  | Rule facts, input hash, policy, lineage.                    |
| CLOSURE_CLOSED/REOPENED       | AcademicClosure | Counts, holds, receipt hash, actor, assurance.              |
| RECONCILIATION                | OperationStatus | Remote receipt, prior/after state, reason.                  |

## 23.1 Evidence Pack de cierre

- AssessmentPlan content_hash y policy/rubric refs.

- Scope snapshot y expected enrollment set/hash.

- Current ResultFact lineage por enrollment/componente.

- CompletionEvaluation + CompletionRuleFacts + current CompletionFact refs.

- Open/resolved/waived ClosureHolds con evidence refs.

- ClosureReceipt, actor, assurance, timestamp y event correlation.

- Reconciliation report downstream.

# 24. Observabilidad: logs, metrics, traces, SLI/SLO y performance

Logs estructurados incluyen correlationId, tenant internal id, operation/resource type y reason code, evitando submissions, feedback sensible o PII. Traces propagan W3C trace context. Métricas evitan labels de alta cardinalidad como enrollment_id.

| **SLI**                 | **SLO objetivo** | **Nota**                         |
|-------------------------|------------------|----------------------------------|
| API read p95            | \< 350 ms        | Dependencias externas separadas. |
| Command simple p95      | \< 700 ms        | Attempt/score local.             |
| Result adjudication p95 | \< 1.5 s         | Policies cacheadas/versionadas.  |
| Completion single p95   | \< 2 s           | Inputs disponibles.              |
| Closure preflight 1k    | \< 60 s async    | OperationStatus progress.        |
| Availability core       | 99.9% mensual    | Excluye mantenimientos.          |
| Outbox lag p95          | \< 60 s          | Alert \>5 min.                   |
| UNKNOWN_EFFECT age      | p95 \<15 min     | Escalar por policy.              |
| RLS leakage             | 0                | SLO absoluto.                    |

| **Métrica**                             | **Tipo**  | **Labels permitidos**        |
|-----------------------------------------|-----------|------------------------------|
| ec07_result_adjudications_total         | counter   | status/reason/source bounded |
| ec07_completion_evaluations_total       | counter   | candidate/status             |
| ec07_closure_holds_open                 | gauge     | type/severity                |
| ec07_closure_preflight_duration_seconds | histogram | scope size bucket            |
| ec07_outbox_lag_seconds                 | histogram | event type                   |
| ec07_operation_unknown_effect_total     | counter   | operation type               |
| ec07_etag_conflicts_total               | counter   | command type                 |
| ec07_idempotency_replays_total          | counter   | operation code               |
| ec07_lms_quarantine_total               | counter   | reason                       |

# 25. IA aplicada al módulo

Toda IA pasa por CT-12. EC-07 solo solicita capacidades asistivas con purpose explícito y recibe run_ref/model_ref/template_ref/eval_ref/grounding/confidence. La salida nunca se persiste como ScoreFact, ResultFact, CompletionFact o decisión de cierre sin command humano/policy determinista autorizado.

| **Caso IA**            | **Valor**                                              | **Guardrail**                                     |
|------------------------|--------------------------------------------------------|---------------------------------------------------|
| Detección de anomalías | Señalar scores outlier, inconsistencias rubric/result. | No cambia nota; reviewer decide.                  |
| Borrador de feedback   | Generar feedback sobre rúbrica/evidencia permitida.    | Revisión humana obligatoria.                      |
| Resumen de evidence    | Resumir entregables largos.                            | Grounding refs; no sustituir lectura high-stakes. |
| Comparación regrade    | Mostrar diferencias original/propuesta.                | Authority humana.                                 |
| Closure risk           | Priorizar pendientes/holds.                            | No cerrar/waive automáticamente.                  |
| Policy explanation     | Explicar por qué una regla produjo outcome.            | No reemplaza motor determinista.                  |

# 26. Analítica y KPI

| **KPI**                  | **Definición**                                | **Regla**                                       |
|--------------------------|-----------------------------------------------|-------------------------------------------------|
| Completion rate          | COMPLETED current / eligible enrollment scope | Separar excluded.                               |
| Pass rate por componente | PASS current / evaluated applicable           | No contar NOT_EVALUATED como fail salvo policy. |
| First-attempt pass rate  | PASS con attempt_no=1 / evaluados             | Dificultad/calidad.                             |
| Retry rate               | participants con attempt_no\>1 / evaluados    | Por component/type.                             |
| Appeal rate              | appeals / published results                   | Con outcome.                                    |
| Restatement rate         | restatements / facts                          | Control de calidad.                             |
| Time-to-grade            | result published_at - attempt submitted_at    | Percentiles.                                    |
| Time-to-completion       | completion published_at - last required input | Operación.                                      |
| Closure readiness age    | tiempo BLOCKED/READY                          | Operaciones.                                    |
| LMS quarantine rate      | quarantined / received                        | Integración.                                    |
| Unknown effect aging     | UNKNOWN_EFFECT por bucket                     | Resiliencia.                                    |
| Assessment coverage      | outcomes con bindings / target outcomes       | Diseño/quality.                                 |

CT-11 es Source of Truth de analítica/BI. EC-07 publica facts/events y puede mantener read models operativos, pero no crea data warehouse paralelo. Toda métrica declara grain, denominator, exclusions, current-vs-historical lineage y asOf.

# 27. Migración legacy y Data Quality con CT-16

No se permite INSERT directo a tablas finales. La migración de notas/resultados/completions legacy usa CT-16: Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → receipt → reconcile → certify. Si la semántica legacy no puede mapearse con certeza, el registro queda en exception queue.

| **Origen**            | **Destino**                     | **Regla DQ**                                                   |
|-----------------------|---------------------------------|----------------------------------------------------------------|
| Legacy course/edition | edition_ref/program_version_ref | Mapping aprobado EC-01/02; no inferir por nombre ambiguo.      |
| Legacy student id     | enrollment_ref                  | Resolver vía EC-04/CT-04; no Person shadow.                    |
| Legacy grade          | ScoreFact + scale ref           | Preservar original value/text y scale.                         |
| Legacy pass flag      | ResultFact                      | Solo si regla histórica conocida.                              |
| Legacy completion     | CompletionFact                  | Requiere evidencia/policy histórica o migration profile.       |
| Legacy close status   | AcademicClosure                 | No convertir “finalizado” en cierre oficial sin certification. |

## 27.1 Receipts de migración

- source_system/source_key

- source_lineage/document_ref

- normalized_payload_hash

- mapping_version

- validation_result + issues\[\]

- promotion_command/idempotency key

- created_fact_refs

- reconciliation_status

- certified_by/at

# 28. QA y estrategia de pruebas

| **Tipo**               | **Cobertura mínima**                                                         |
|------------------------|------------------------------------------------------------------------------|
| Unit Tests             | Value Objects, policies, rounding, state transitions.                        |
| Domain Tests           | Result adjudication, retries, group policy, completion rules, closure holds. |
| Repository Tests       | Composite keys, checks, append-only triggers, lineage.                       |
| Integration Tests      | Spring + PostgreSQL/Testcontainers + RLS.                                    |
| Contract Tests         | CT-02/05/06/18, EC-01/02/04/05/06/08.                                        |
| API Tests              | OpenAPI, ProblemDetail, ETag, idempotency, pagination.                       |
| Event Contract Tests   | AsyncAPI, compatibility, inbox dedup.                                        |
| Security Tests         | RBAC/ABAC/SoD/step-up, IDOR, mass assignment.                                |
| Tenant Isolation Tests | RLS positive/negative.                                                       |
| Concurrency Tests      | Double grade/completion/close, stale ETag.                                   |
| Idempotency Tests      | Replay/conflict/crash recovery.                                              |
| Resilience Tests       | Timeouts, circuit breaker, UNKNOWN_EFFECT.                                   |
| Performance Tests      | Roster 5k, bulk grade, closure 10k.                                          |
| Migration Tests        | Scale ambiguity, duplicates, lineage.                                        |
| E2E                    | Plan→attempt→result→completion→close + appeal.                               |
| UAT                    | Institutional scenarios.                                                     |
| Mobile Tests           | Offline queue, sync conflicts, deep links.                                   |
| AI Evals               | Grounding, hallucination, prompt injection; no autonomous decision.          |

## 28.1 Matriz mínima de pruebas físicas

| **Prueba**                 | **Acción**                       | **Resultado esperado**         |
|----------------------------|----------------------------------|--------------------------------|
| Cross-tenant SELECT/UPDATE | Runtime tenant A usa id tenant B | 0 rows/policy violation.       |
| Append-only UPDATE         | UPDATE result_fact               | DB exception.                  |
| Duplicate source receipt   | Mismo LMS receipt dos veces      | Un solo attempt.               |
| Lineage cycle              | A supersedes B y B supersedes A  | DB reject.                     |
| Stale ETag                 | If-Match 7 cuando root=8         | 412 sin side effects.          |
| Double close               | Dos requests concurrentes        | Uno gana; otro 409/412/replay. |
| UNKNOWN_EFFECT             | Timeout post remote apply        | No retry hasta reconcile.      |
| Zero vs missing            | score=0 vs no score              | Semántica distinta.            |

# 29. Golden Scenarios

| **GS**          | **Escenario**                 | **Precondición**                        | **Acción**                            | **Resultado esperado**                                                            | **Evidencia**         |
|-----------------|-------------------------------|-----------------------------------------|---------------------------------------|-----------------------------------------------------------------------------------|-----------------------|
| **GS-EC07-001** | Happy path individual         | Plan publicado; enrollment válido       | Registrar attempt + score + adjudicar | Result según policy.                                                              | Audit/log/DB/event/UI |
| **GS-EC07-002** | Retry best score              | 2 attempts                              | Segundo mejor                         | BEST usa mejor; history intacta.                                                  | Audit/log/DB/event/UI |
| **GS-EC07-003** | Retry last score              | Policy LAST                             | Segundo menor                         | LAST aplica determinista.                                                         | Audit/log/DB/event/UI |
| **GS-EC07-004** | Zero score                    | Attempt válido                          | Score 0                               | ZERO, no NO_DATA.                                                                 | Audit/log/DB/event/UI |
| **GS-EC07-005** | Absent                        | No evaluación                           | Adjudicar ABSENT                      | No score inventado.                                                               | Audit/log/DB/event/UI |
| **GS-EC07-006** | Exempt                        | Waiver aprobado                         | Adjudicar EXEMPT                      | Reason/evidence.                                                                  | Audit/log/DB/event/UI |
| **GS-EC07-007** | Late submission               | Fuera window                            | Submit                                | late_flag y policy.                                                               | Audit/log/DB/event/UI |
| **GS-EC07-008** | LMS duplicate                 | Mismo receipt                           | Retry consumer                        | Un solo attempt.                                                                  | Audit/log/DB/event/UI |
| **GS-EC07-009** | LMS unknown mapping           | Mapping ambiguo                         | Recibir grade                         | Quarantine/PARTIAL.                                                               | Audit/log/DB/event/UI |
| **GS-EC07-010** | LMS timeout unknown effect    | Efecto incierto                         | Timeout                               | UNKNOWN_EFFECT + reconcile.                                                       | Audit/log/DB/event/UI |
| **GS-EC07-011** | Group project                 | Group frozen                            | Submit grupal                         | Membership snapshot.                                                              | Audit/log/DB/event/UI |
| **GS-EC07-012** | Group changed after submit    | FROZEN                                  | Remove member                         | Reject.                                                                           | Audit/log/DB/event/UI |
| **GS-EC07-013** | Manual correction             | Error probado                           | Adjustment approved                   | New fact supersedes.                                                              | Audit/log/DB/event/UI |
| **GS-EC07-014** | Appeal denied                 | Appeal review                           | MAINTAIN                              | Result intacto.                                                                   | Audit/log/DB/event/UI |
| **GS-EC07-015** | Appeal granted                | Evidence válida                         | RESTATE                               | New result lineage.                                                               | Audit/log/DB/event/UI |
| **GS-EC07-016** | Completion happy              | All satisfied                           | Evaluate/publish                      | COMPLETED.                                                                        | Audit/log/DB/event/UI |
| **GS-EC07-017** | Completion fail               | Mandatory unsatisfied                   | Evaluate                              | NOT_COMPLETED.                                                                    | Audit/log/DB/event/UI |
| **GS-EC07-018** | Completion unknown attendance | EC-06 down                              | Evaluate                              | BLOCKED/UNKNOWN.                                                                  | Audit/log/DB/event/UI |
| **GS-EC07-019** | Completion stale result       | Input changed                           | Publish                               | 409 INPUT_CHANGED.                                                                | Audit/log/DB/event/UI |
| **GS-EC07-020** | Closure happy                 | All final                               | Preflight + close                     | Receipt/outbox.                                                                   | Audit/log/DB/event/UI |
| **GS-EC07-021** | Closure pending appeal        | Appeal open                             | Preflight                             | BLOCKED hold.                                                                     | Audit/log/DB/event/UI |
| **GS-EC07-022** | Closure dependency down       | Critical down                           | Preflight                             | BLOCKED/503.                                                                      | Audit/log/DB/event/UI |
| **GS-EC07-023** | Reopen                        | Late valid appeal                       | Approve reopen                        | New cycle.                                                                        | Audit/log/DB/event/UI |
| **GS-EC07-024** | Cross-tenant attack           | Tenant A uses B id                      | GET result                            | No leak.                                                                          | Audit/log/DB/event/UI |
| **GS-EC07-025** | Mass assignment               | Body tenant/state                       | POST                                  | Rejected/ignored protected.                                                       | Audit/log/DB/event/UI |
| **GS-EC07-026** | Stale ETag                    | Two graders                             | Second mutation                       | 412\.                                                                             | Audit/log/DB/event/UI |
| **GS-EC07-027** | Idempotency replay            | Same key/payload                        | Retry                                 | Same resource.                                                                    | Audit/log/DB/event/UI |
| **GS-EC07-028** | Idempotency conflict          | Same key/different                      | Retry                                 | 409\.                                                                             | Audit/log/DB/event/UI |
| **GS-EC07-029** | Lease crash                   | Worker dies                             | Lease expires                         | Governed recovery.                                                                | Audit/log/DB/event/UI |
| **GS-EC07-030** | Outbox duplicate              | Broker retry                            | Duplicate event                       | Inbox dedup.                                                                      | Audit/log/DB/event/UI |
| **GS-EC07-031** | Policy missing                | Policy unresolved                       | Adjudicate                            | 422/503.                                                                          | Audit/log/DB/event/UI |
| **GS-EC07-032** | Rubric upgraded               | New rubric exists                       | Read old result                       | Old ref preserved.                                                                | Audit/log/DB/event/UI |
| **GS-EC07-033** | Rounding edge                 | 69.995 vs 70                            | Adjudicate                            | Policy rounding.                                                                  | Audit/log/DB/event/UI |
| **GS-EC07-034** | Threshold inclusive           | Exactly minimum                         | Adjudicate                            | Boundary policy.                                                                  | Audit/log/DB/event/UI |
| **GS-EC07-035** | Bulk dry-run                  | 1000 rows, 10 invalid                   | Dry-run                               | No persistence.                                                                   | Audit/log/DB/event/UI |
| **GS-EC07-036** | Bulk promote partial          | Approved batch                          | Promote                               | Per-row receipts.                                                                 | Audit/log/DB/event/UI |
| **GS-EC07-037** | Mobile offline draft          | Instructor offline                      | Capture draft                         | No fake success.                                                                  | Audit/log/DB/event/UI |
| **GS-EC07-038** | Mobile conflict               | Sync after web change                   | Sync                                  | Rebase.                                                                           | Audit/log/DB/event/UI |
| **GS-EC07-039** | AI feedback                   | Grounded                                | Generate                              | Human review.                                                                     | Audit/log/DB/event/UI |
| **GS-EC07-040** | AI prompt injection           | Malicious submission                    | Analyze                               | No authority change.                                                              | Audit/log/DB/event/UI |
| **GS-EC07-041** | Proctoring alert              | Provider flags                          | Ingest                                | Signal only.                                                                      | Audit/log/DB/event/UI |
| **GS-EC07-042** | Audit export                  | Authorized                              | Export pack                           | Hashes/lineage.                                                                   | Audit/log/DB/event/UI |
| **GS-EC07-043** | Performance roster            | 5000 participants                       | Open console                          | Within SLO.                                                                       | Audit/log/DB/event/UI |
| **GS-EC07-044** | Closure 10k                   | Large cohort                            | Preflight async                       | Operation progress.                                                               | Audit/log/DB/event/UI |
| **GS-EC07-045** | Late LMS event after close    | Closed                                  | Receive grade                         | Reopen candidate.                                                                 | Audit/log/DB/event/UI |
| **GS-EC07-046** | Withdrawn enrollment          | Status changed                          | Completion scope                      | Policy/exclusion.                                                                 | Audit/log/DB/event/UI |
| **GS-EC07-047** | No assessment program         | Participation-only                      | Completion                            | No fake components.                                                               | Audit/log/DB/event/UI |
| **GS-EC07-048** | Optional component            | Not attempted                           | Completion                            | No fail unless policy.                                                            | Audit/log/DB/event/UI |
| **GS-EC07-049** | Evidence unavailable          | CT-05 down                              | Review                                | UNAVAILABLE.                                                                      | Audit/log/DB/event/UI |
| **GS-EC07-050** | Security step-up fail         | Close action                            | Step-up denied                        | 403 no side effect.                                                               | Audit/log/DB/event/UI |
| **GS-EC07-051** | Integración variante 051      | Fixture controlado integración \#51     | Ejecutar flujo GS-051                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-052** | Migración variante 052        | Fixture controlado migración \#52       | Ejecutar flujo GS-052                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-053** | Seguridad variante 053        | Fixture controlado seguridad \#53       | Ejecutar flujo GS-053                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-054** | Policy variante 054           | Fixture controlado policy \#54          | Ejecutar flujo GS-054                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-055** | Mobile variante 055           | Fixture controlado mobile \#55          | Ejecutar flujo GS-055                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-056** | Observabilidad variante 056   | Fixture controlado observabilidad \#56  | Ejecutar flujo GS-056                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-057** | Lineage variante 057          | Fixture controlado lineage \#57         | Ejecutar flujo GS-057                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-058** | Bulk variante 058             | Fixture controlado bulk \#58            | Ejecutar flujo GS-058                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-059** | Cierre variante 059           | Fixture controlado cierre \#59          | Ejecutar flujo GS-059                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-060** | Concurrencia variante 060     | Fixture controlado concurrencia \#60    | Ejecutar flujo GS-060                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-061** | Integración variante 061      | Fixture controlado integración \#61     | Ejecutar flujo GS-061                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-062** | Migración variante 062        | Fixture controlado migración \#62       | Ejecutar flujo GS-062                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-063** | Seguridad variante 063        | Fixture controlado seguridad \#63       | Ejecutar flujo GS-063                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-064** | Policy variante 064           | Fixture controlado policy \#64          | Ejecutar flujo GS-064                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-065** | Mobile variante 065           | Fixture controlado mobile \#65          | Ejecutar flujo GS-065                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-066** | Observabilidad variante 066   | Fixture controlado observabilidad \#66  | Ejecutar flujo GS-066                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-067** | Lineage variante 067          | Fixture controlado lineage \#67         | Ejecutar flujo GS-067                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-068** | Bulk variante 068             | Fixture controlado bulk \#68            | Ejecutar flujo GS-068                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-069** | Cierre variante 069           | Fixture controlado cierre \#69          | Ejecutar flujo GS-069                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-070** | Concurrencia variante 070     | Fixture controlado concurrencia \#70    | Ejecutar flujo GS-070                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-071** | Integración variante 071      | Fixture controlado integración \#71     | Ejecutar flujo GS-071                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-072** | Migración variante 072        | Fixture controlado migración \#72       | Ejecutar flujo GS-072                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-073** | Seguridad variante 073        | Fixture controlado seguridad \#73       | Ejecutar flujo GS-073                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-074** | Policy variante 074           | Fixture controlado policy \#74          | Ejecutar flujo GS-074                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-075** | Mobile variante 075           | Fixture controlado mobile \#75          | Ejecutar flujo GS-075                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-076** | Observabilidad variante 076   | Fixture controlado observabilidad \#76  | Ejecutar flujo GS-076                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-077** | Lineage variante 077          | Fixture controlado lineage \#77         | Ejecutar flujo GS-077                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-078** | Bulk variante 078             | Fixture controlado bulk \#78            | Ejecutar flujo GS-078                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-079** | Cierre variante 079           | Fixture controlado cierre \#79          | Ejecutar flujo GS-079                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-080** | Concurrencia variante 080     | Fixture controlado concurrencia \#80    | Ejecutar flujo GS-080                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-081** | Integración variante 081      | Fixture controlado integración \#81     | Ejecutar flujo GS-081                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-082** | Migración variante 082        | Fixture controlado migración \#82       | Ejecutar flujo GS-082                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-083** | Seguridad variante 083        | Fixture controlado seguridad \#83       | Ejecutar flujo GS-083                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-084** | Policy variante 084           | Fixture controlado policy \#84          | Ejecutar flujo GS-084                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-085** | Mobile variante 085           | Fixture controlado mobile \#85          | Ejecutar flujo GS-085                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-086** | Observabilidad variante 086   | Fixture controlado observabilidad \#86  | Ejecutar flujo GS-086                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-087** | Lineage variante 087          | Fixture controlado lineage \#87         | Ejecutar flujo GS-087                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-088** | Bulk variante 088             | Fixture controlado bulk \#88            | Ejecutar flujo GS-088                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-089** | Cierre variante 089           | Fixture controlado cierre \#89          | Ejecutar flujo GS-089                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-090** | Concurrencia variante 090     | Fixture controlado concurrencia \#90    | Ejecutar flujo GS-090                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-091** | Integración variante 091      | Fixture controlado integración \#91     | Ejecutar flujo GS-091                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-092** | Migración variante 092        | Fixture controlado migración \#92       | Ejecutar flujo GS-092                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-093** | Seguridad variante 093        | Fixture controlado seguridad \#93       | Ejecutar flujo GS-093                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-094** | Policy variante 094           | Fixture controlado policy \#94          | Ejecutar flujo GS-094                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-095** | Mobile variante 095           | Fixture controlado mobile \#95          | Ejecutar flujo GS-095                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-096** | Observabilidad variante 096   | Fixture controlado observabilidad \#96  | Ejecutar flujo GS-096                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-097** | Lineage variante 097          | Fixture controlado lineage \#97         | Ejecutar flujo GS-097                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-098** | Bulk variante 098             | Fixture controlado bulk \#98            | Ejecutar flujo GS-098                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-099** | Cierre variante 099           | Fixture controlado cierre \#99          | Ejecutar flujo GS-099                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-100** | Concurrencia variante 100     | Fixture controlado concurrencia \#100   | Ejecutar flujo GS-100                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-101** | Integración variante 101      | Fixture controlado integración \#101    | Ejecutar flujo GS-101                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-102** | Migración variante 102        | Fixture controlado migración \#102      | Ejecutar flujo GS-102                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-103** | Seguridad variante 103        | Fixture controlado seguridad \#103      | Ejecutar flujo GS-103                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-104** | Policy variante 104           | Fixture controlado policy \#104         | Ejecutar flujo GS-104                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-105** | Mobile variante 105           | Fixture controlado mobile \#105         | Ejecutar flujo GS-105                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-106** | Observabilidad variante 106   | Fixture controlado observabilidad \#106 | Ejecutar flujo GS-106                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-107** | Lineage variante 107          | Fixture controlado lineage \#107        | Ejecutar flujo GS-107                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-108** | Bulk variante 108             | Fixture controlado bulk \#108           | Ejecutar flujo GS-108                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-109** | Cierre variante 109           | Fixture controlado cierre \#109         | Ejecutar flujo GS-109                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |
| **GS-EC07-110** | Concurrencia variante 110     | Fixture controlado concurrencia \#110   | Ejecutar flujo GS-110                 | Resultado determinista; tenant aislado; reason/correlation/evidence verificables. | Audit/log/DB/event/UI |

# 30. UAT institucional

| **ID**     | **Escenario**           | **Actor**          | **Criterio de aceptación** |
|------------|-------------------------|--------------------|----------------------------|
| **UAT-01** | Publicar plan ponderado | Designer/Publisher | PUBLISHED + hash/policies. |
| **UAT-02** | Programa sin evaluación | Coordinator        | Sin componentes ficticios. |
| **UAT-03** | Score manual            | Instructor         | Result reproducible.       |
| **UAT-04** | Grade LMS               | Ops                | Dedup + provenance.        |
| **UAT-05** | Retry BEST              | Instructor         | Selección correcta.        |
| **UAT-06** | Retry LAST              | Instructor         | Selección correcta.        |
| **UAT-07** | Score cero              | Instructor         | ZERO distinguido.          |
| **UAT-08** | ABSENT                  | Instructor         | Sin score inventado.       |
| **UAT-09** | EXEMPT                  | Governance         | Reason/evidence.           |
| **UAT-10** | Group assessment        | Instructor         | Membership frozen.         |
| **UAT-11** | Ajuste nota             | Approver           | Restatement.               |
| **UAT-12** | Appeal rechazado        | Committee          | Result intacto.            |
| **UAT-13** | Appeal aprobado         | Committee          | New lineage.               |
| **UAT-14** | Completion happy        | Coordinator        | COMPLETED.                 |
| **UAT-15** | Completion fail         | Coordinator        | NOT_COMPLETED.             |
| **UAT-16** | Attendance unavailable  | Coordinator        | BLOCKED.                   |
| **UAT-17** | Close happy             | Governance         | Receipt.                   |
| **UAT-18** | Close pending appeal    | Governance         | Hold.                      |
| **UAT-19** | Reopen                  | Governance         | New cycle.                 |
| **UAT-20** | Cross-tenant            | Security           | 0 leakage.                 |
| **UAT-21** | Stale ETag              | Two users          | 412\.                      |
| **UAT-22** | Idempotency replay      | Client             | Same resource.             |
| **UAT-23** | UNKNOWN_EFFECT          | Ops                | Reconcile-before-retry.    |
| **UAT-24** | Bulk grade              | Operator           | Dry-run + receipts.        |
| **UAT-25** | Mobile offline          | Instructor         | No fake success.           |
| **UAT-26** | Accessibility           | Participant        | Keyboard/screen reader.    |
| **UAT-27** | AI suggestion           | Reviewer           | Human-controlled.          |
| **UAT-28** | Migration legacy        | Data Steward       | Lineage/receipts.          |
| **UAT-29** | Performance large       | Ops                | SLO.                       |
| **UAT-30** | Evidence pack           | Auditor            | Reconstructible.           |

# 31. Gates G1-G10

| **Gate** | **Dominio**                  | **Debe demostrar**                                  | **Evidencia**          |
|----------|------------------------------|-----------------------------------------------------|------------------------|
| **G1**   | Arquitectura/bounded context | Source of Truth, DA/ADR, domain model.              | Architecture review.   |
| **G2**   | Datos/constraints            | DER, DDL, RLS, append-only, lineage.                | Flyway/Testcontainers. |
| **G3**   | Backend                      | Aggregates, policies, services, idempotency/outbox. | Tests.                 |
| **G4**   | API/Event contracts          | OpenAPI/AsyncAPI, pagination, ETag, compatibility.  | Contract tests.        |
| **G5**   | Frontend/Mobile              | Workspaces, states, accessibility, offline.         | E2E/visual/a11y.       |
| **G6**   | Seguridad/auditoría          | RBAC/ABAC/SoD/step-up, Threat Model.                | Security review.       |
| **G7**   | Integraciones/resiliencia    | Timeout/retry/UNKNOWN_EFFECT/reconcile.             | Chaos evidence.        |
| **G8**   | QA/UAT                       | Test matrix, Golden Scenarios, UAT.                 | Sign-off.              |
| **G9**   | Migración/operaciones        | CT-16, runbooks, SLO dashboards.                    | Dry-run/readiness.     |
| **G10**  | Release/certificación        | DoD, evidence pack, SBOM, rollout.                  | Release certification. |

# 32. Definition of Ready / Definition of Done

## 32.1 Definition of Ready

- Scope/Source of Truth aprobados.

- Upstream contracts EC-01/02/04/05/06 disponibles.

- Policy/rubric/scale strategy definida.

- Roles/SoD/tenant scopes definidos.

- DDL/constraints principales revisados.

- OpenAPI/AsyncAPI skeleton aprobado.

- Golden Scenarios prioritarios vinculados.

- SLO/capacity budgets conocidos.

- Migration risks identificados.

## 32.2 Definition of Done

- Código/Flyway/OpenAPI/AsyncAPI/tests/ADR en Git.

- RLS/tenant isolation green.

- Append-only/lineage/concurrency/idempotency green.

- Result/completion/closure E2E green.

- Security scans/SBOM aprobados.

- Dashboards/alerts/runbooks disponibles.

- UAT firmado.

- Evidence Pack G1-G10 completo.

- Expand/contract N/N-1 validado.

- Word y contratos ejecutables sin divergencia.

# 33. Runbooks

| **ID**          | **Situación**            | **Procedimiento**                                                                       |
|-----------------|--------------------------|-----------------------------------------------------------------------------------------|
| **RB-EC07-001** | Outbox backlog           | Medir lag → reclaim seguro → revisar broker → replay idempotente → confirmar consumers. |
| **RB-EC07-002** | Inbox duplicate storm    | Confirmar IDs → rate limit → dedup → coordinar provider.                                |
| **RB-EC07-003** | LMS UNKNOWN_EFFECT       | Operation/receipt → consultar provider → retry solo NOT_APPLIED.                        |
| **RB-EC07-004** | Result incorrecto        | No UPDATE → adjustment/appeal → append restatement → reconcile.                         |
| **RB-EC07-005** | Completion incorrecto    | Input changed → reevaluate → restate → notify downstream.                               |
| **RB-EC07-006** | Closure blocked          | List holds → resolver/reconcile → rerun preflight.                                      |
| **RB-EC07-007** | Late event after closure | Quarantine → materiality → reopen → restate → recerrar.                                 |
| **RB-EC07-008** | RLS incident             | Block route → preserve evidence → verify role/tenant setting → incident response.       |
| **RB-EC07-009** | Idempotency lease stuck  | Owner dead + lease expired → reclaim → compare hash.                                    |
| **RB-EC07-010** | ETag conflict spike      | Inspect client cache/root bump → no disable If-Match.                                   |
| **RB-EC07-011** | Policy service down      | Use valid immutable cache or fail-closed critical.                                      |
| **RB-EC07-012** | Evidence service down    | UNAVAILABLE; prevent high-stakes if required.                                           |
| **RB-EC07-013** | Bulk grade failure       | Inspect receipts → isolate rows → retry failed only.                                    |
| **RB-EC07-014** | Anomaly alert            | Review inputs → optional AI → human disposition.                                        |
| **RB-EC07-015** | Closure count mismatch   | Compare EC-04 scope/current completion → hold.                                          |
| **RB-EC07-016** | Appeal workflow timeout  | UNKNOWN_EFFECT → query CT-06 correlation.                                               |
| **RB-EC07-017** | Performance degradation  | DB plans/RLS/cache/queue → scale preserving correctness.                                |
| **RB-EC07-018** | Database failover        | CT-17 → validate tenant context → reconcile outbox.                                     |
| **RB-EC07-019** | Migration anomaly        | Stop promote → inspect mapping → new dry-run.                                           |
| **RB-EC07-020** | Hash mismatch            | Recalculate canonical → compare lineage → incident.                                     |
| **RB-EC07-021** | Unauthorized export      | Deny → audit → alert if threshold.                                                      |
| **RB-EC07-022** | Mobile offline conflict  | Fetch ETag → diff → user rebase.                                                        |
| **RB-EC07-023** | Duplicate webhook        | Inbox dedup → safe 2xx.                                                                 |
| **RB-EC07-024** | Release rollback need    | Prefer roll-forward; N-1 compatible.                                                    |
| **RB-EC07-025** | Disaster evidence pack   | Restore → verify hashes/CT-05 refs → certify.                                           |

# 34. ADRs y decisiones abiertas

| **ADR**          | **Decisión**                  | **Estado**    | **Justificación**                          |
|------------------|-------------------------------|---------------|--------------------------------------------|
| **ADR-EC07-001** | PostgreSQL Source of Truth    | Accepted      | Transacción/integridad.                    |
| **ADR-EC07-002** | RLS ENABLE+FORCE              | Accepted      | Defense-in-depth.                          |
| **ADR-EC07-003** | Facts append-only             | Accepted      | Historia auditable.                        |
| **ADR-EC07-004** | BigDecimal scoring            | Accepted      | Determinismo.                              |
| **ADR-EC07-005** | AssessmentPlan versionado     | Accepted      | Congela reglas.                            |
| **ADR-EC07-006** | Completion separado finanzas  | Accepted      | Academic ≠ ledger.                         |
| **ADR-EC07-007** | Certificate eligibility fuera | Accepted      | EC-08 owner.                               |
| **ADR-EC07-008** | LMS vía CT-18                 | Accepted      | No vendor ad-hoc.                          |
| **ADR-EC07-009** | Idempotency lease             | Accepted      | Recovery.                                  |
| **ADR-EC07-010** | Outbox SKIP LOCKED            | Accepted      | Multi-instancia.                           |
| **ADR-EC07-011** | OperationStatus               | Accepted      | 202/UNKNOWN_EFFECT.                        |
| **ADR-EC07-012** | Group snapshot                | Accepted      | Reconstructibilidad.                       |
| **ADR-EC07-013** | Appeal decision separado      | Accepted      | SoD/audit.                                 |
| **ADR-EC07-014** | Closure cycle/receipt         | Accepted      | Reopen sin borrar.                         |
| **ADR-EC07-015** | No FK cross-context           | Accepted      | Autonomía.                                 |
| **ADR-EC07-016** | Mongo derived only            | Accepted      | No doble SoT.                              |
| **ADR-EC07-017** | Redis non-authoritative       | Accepted      | Correctness.                               |
| **ADR-EC07-018** | OpenAPI client                | Accepted      | Contrato único.                            |
| **ADR-EC07-019** | Cursor timelines              | Accepted      | Escala.                                    |
| **ADR-EC07-020** | Expand/contract               | Accepted      | Zero-downtime.                             |
| **ADR-EC07-021** | Rounding policy               | Accepted      | No locale.                                 |
| **ADR-EC07-022** | Proctoring signal only        | Accepted      | Responsible automation.                    |
| **ADR-EC07-023** | AI no grade authority         | Accepted      | Human/policy control.                      |
| **ADR-EC07-024** | Bulk per-row receipts         | Accepted      | No éxito ambiguo.                          |
| **ADR-EC07-025** | Source trust classes          | Accepted      | Sources no equivalentes.                   |
| **ADR-EC07-026** | Current result derived        | Accepted      | No overwrite.                              |
| **ADR-EC07-027** | Current completion derived    | Accepted      | No overwrite.                              |
| **ADR-EC07-028** | Closure scope snapshot        | Accepted      | Completeness.                              |
| **ADR-EC07-029** | Result publication timing     | Open/Policy   | Immediate/reviewed release por tenant.     |
| **ADR-EC07-030** | Rubric authoring ownership    | Open/Boundary | Referenciar si existe context transversal. |

# 35. Engineering Pack

| **Ruta Git**   | **Archivos mínimos**                                                    |
|----------------|-------------------------------------------------------------------------|
| /docs          | EC07.md, ubiquitous-language.md, source-of-truth.md, state-machines.md. |
| /openapi       | ec07-evaluation-v1.yaml + generated-client checks.                      |
| /asyncapi      | ec07-events-v1.yaml + schemas.                                          |
| /db/migration  | V\*\_\_ec07\_\*.sql expand/contract.                                    |
| /architecture  | context/domain/ER diagrams.                                             |
| /adr           | ADR-EC07-001…030.                                                       |
| /backend       | module ec07.                                                            |
| /frontend      | evaluation workspaces.                                                  |
| /mobile        | participant/instructor journeys.                                        |
| /tests         | unit/domain/repository/integration/contract/e2e.                        |
| /performance   | load plans/baselines.                                                   |
| /security      | threat-model, authz matrix, scans, SBOM.                                |
| /runbooks      | RB-EC07-001…025.                                                        |
| /observability | dashboards, alerts, SLI/SLO.                                            |
| /migration     | mapping specs, dry-run, DQ.                                             |
| /evidence      | gate manifests/hashes, UAT sign-off.                                    |

# 36. Guía secuencial Backend

| **Paso** | **Acción Backend**                                  | **Criterio de salida**               |
|----------|-----------------------------------------------------|--------------------------------------|
| 1        | Crear módulo Spring Modulith ec07 y boundary tests. | Código + test/evidencia verificable. |
| 2        | Definir domain sin Spring/JPA.                      | Código + test/evidencia verificable. |
| 3        | Implementar Value Objects.                          | Código + test/evidencia verificable. |
| 4        | Implementar AssessmentPlan/state machine.           | Código + test/evidencia verificable. |
| 5        | Implementar ParticipantEvaluation/attempt rules.    | Código + test/evidencia verificable. |
| 6        | Implementar CompletionEvaluation/AcademicClosure.   | Código + test/evidencia verificable. |
| 7        | Definir policies/services BigDecimal.               | Código + test/evidencia verificable. |
| 8        | Definir inbound ports.                              | Código + test/evidencia verificable. |
| 9        | Definir outbound ports CT/EC/IAM.                   | Código + test/evidencia verificable. |
| 10       | Crear Flyway schema/core.                           | Código + test/evidencia verificable. |
| 11       | Crear constraints/indexes.                          | Código + test/evidencia verificable. |
| 12       | Implementar RLS + DB roles.                         | Código + test/evidencia verificable. |
| 13       | Implementar append-only/lineage guards.             | Código + test/evidencia verificable. |
| 14       | Implementar aggregate revision guards.              | Código + test/evidencia verificable. |
| 15       | Repositories + Testcontainers.                      | Código + test/evidencia verificable. |
| 16       | TenantContext + SET LOCAL.                          | Código + test/evidencia verificable. |
| 17       | Durable idempotency lease.                          | Código + test/evidencia verificable. |
| 18       | Outbox/inbox lease.                                 | Código + test/evidencia verificable. |
| 19       | Plan authoring/publish services.                    | Código + test/evidencia verificable. |
| 20       | Attempt/evidence commands.                          | Código + test/evidencia verificable. |
| 21       | Score normalize/adjudicate.                         | Código + test/evidencia verificable. |
| 22       | Adjustment/appeal flows.                            | Código + test/evidencia verificable. |
| 23       | Completion evaluator/rule facts.                    | Código + test/evidencia verificable. |
| 24       | Closure preflight/holds/receipt.                    | Código + test/evidencia verificable. |
| 25       | OperationStatus/reconciliation.                     | Código + test/evidencia verificable. |
| 26       | REST + ProblemDetail.                               | Código + test/evidencia verificable. |
| 27       | OpenAPI contract tests.                             | Código + test/evidencia verificable. |
| 28       | AsyncAPI/outbox dispatcher.                         | Código + test/evidencia verificable. |
| 29       | Observability.                                      | Código + test/evidencia verificable. |
| 30       | Security/SoD/step-up tests.                         | Código + test/evidencia verificable. |
| 31       | Migration CT-16 adapter.                            | Código + test/evidencia verificable. |
| 32       | Performance tests.                                  | Código + test/evidencia verificable. |
| 33       | Golden Scenarios + UAT.                             | Código + test/evidencia verificable. |
| 34       | Expand/contract N/N-1.                              | Código + test/evidencia verificable. |
| 35       | G1-G10 certification.                               | Código + test/evidencia verificable. |

# 37. Guía secuencial Frontend

| **Paso** | **Acción Frontend**                                                          | **Criterio de salida**                            |
|----------|------------------------------------------------------------------------------|---------------------------------------------------|
| 1        | Crear feature module/rutas.                                                  | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 2        | Generar API client/types.                                                    | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 3        | Query keys tenant/scope/resource/version.                                    | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 4        | ProblemDetail mapper.                                                        | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 5        | ETag/If-Match wrapper.                                                       | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 6        | WorkspaceShell permission/state.                                             | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 7        | Assessment Plan Studio.                                                      | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 8        | Component editor/reordering.                                                 | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 9        | Validation/publish workflow.                                                 | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 10       | Grading Console virtualized.                                                 | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 11       | AttemptTimeline/EvidenceDrawer.                                              | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 12       | Rubric/Score entry sin float autoritativo.                                   | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 13       | ResultLineageViewer.                                                         | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 14       | Adjustment/Appeal queue.                                                     | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 15       | Completion Matrix.                                                           | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 16       | Closure Center.                                                              | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 17       | Reconciliation Center.                                                       | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 18       | Audit Explorer.                                                              | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 19       | Estados NO_DATA/ZERO/NOT_EVALUATED/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT. | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 20       | Conflict dialog 412.                                                         | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 21       | Idempotency UX.                                                              | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 22       | 202 polling/backoff.                                                         | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 23       | Accessibility.                                                               | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 24       | Responsive rules.                                                            | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 25       | Field-level authz.                                                           | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 26       | Unit/component tests.                                                        | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 27       | Contract mocks.                                                              | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 28       | E2E conflict/dependency down.                                                | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 29       | Visual regression.                                                           | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 30       | Performance roster/matrix.                                                   | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 31       | Telemetry sin PII.                                                           | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 32       | UAT roles reales.                                                            | Comportamiento y tests alineados a OpenAPI/BR/GS. |
| 33       | Cerrar G5/G8/G10.                                                            | Comportamiento y tests alineados a OpenAPI/BR/GS. |

# 38. Matriz de permisos

| **Rol**                | **Plan editar** | **Plan publicar** | **Attempt** | **Score** | **Result** | **Ajuste** | **Appeal** | **Completion** | **Close** | **Reopen** | **Reconcile** | **Audit** |
|------------------------|-----------------|-------------------|-------------|-----------|------------|------------|------------|----------------|-----------|------------|---------------|-----------|
| **Designer**           | ✓               | —                 | —           | —         | —          | —          | —          | —              | —         | —          | —             | R         |
| **Instructor**         | R               | —                 | ✓           | ✓         | ✓\*        | Req        | —          | —              | —         | —          | —             | R         |
| **Approver**           | R               | ✓                 | —           | —         | R          | ✓          | R          | —              | —         | —          | —             | R         |
| **Result Governance**  | R               | R                 | R           | R         | ✓          | ✓          | ✓          | ✓              | R         | —          | R             | ✓         |
| **Closure Governance** | R               | R                 | R           | R         | R          | R          | R          | R              | ✓         | ✓          | R             | ✓         |
| **Ops**                | R               | —                 | R           | —         | —          | —          | —          | —              | R         | —          | ✓             | R         |
| **Auditor**            | R               | —                 | R           | R         | R          | R          | R          | R              | R         | R          | R             | ✓         |
| **Participant**        | R\*             | —                 | ✓\*         | —         | R\*        | Req\*      | ✓\*        | R\*            | —         | —          | —             | —         |

Leyenda: ✓ permitido sujeto a ABAC/SoD/policy; R lectura; Req inicia solicitud pero no decide; \* limitado a relación propia/assignment. IAM/CT-10 sigue siendo Source of Truth de autorización.

# 39. Contratos DTO Frontend

| **Contrato**                      | **Campos permitidos**                                                                                | **Campos protegidos/derivados**             |
|-----------------------------------|------------------------------------------------------------------------------------------------------|---------------------------------------------|
| CreateAssessmentPlanRequest       | editionRef, cohortRef?, programVersionRef, officialName, gradingPolicyRef, completionPolicyRef       | tenantId/state/version/publishedAt.         |
| UpdateAssessmentPlanRequest       | officialName y metadata escalar allow-listed                                                         | state, protected policy refs, tenant.       |
| CreateComponentRequest            | code,type,title,weight?,mandatory,attemptPolicyRef,selectionPolicyRef,scaleRef,rubricRef?,sequenceNo | assessmentPlanId desde path.                |
| RecordAttemptRequest              | componentId, occurredAt?, submittedAt?, evidenceRefs\[\], groupId?                                   | attemptNo server-managed; tenant protected. |
| RecordScoreRequest                | attemptId, originalValue/text, originalScaleRef, reasonCode?                                         | normalized/final result server-derived.     |
| AdjudicateResultRequest           | componentId, expectedParticipantEvaluationVersion                                                    | No resultStatus/finalScore libre.           |
| AdjustmentRequestDto              | typeCode,reasonCode,description?,evidenceRefs\[\]                                                    | No decision fields.                         |
| AppealRequestDto                  | appealTypeCode,statement,evidenceRefs\[\]                                                            | No decision/effect.                         |
| CreateCompletionEvaluationRequest | assessmentPlanId,enrollmentRef                                                                       | No candidateStatus.                         |
| PublishCompletionRequest          | completionEvaluationId,expectedVersion                                                               | No completionStatus libre.                  |
| CreateClosureRequest              | editionRef,cohortRef?,policyRef                                                                      | Counts/state server-derived.                |
| ResolveHoldRequest                | reasonCode,evidenceRef?                                                                              | No delete.                                  |
| CloseClosureRequest               | expectedVersion,confirmationReason?                                                                  | No counts/hash client.                      |
| ReopenClosureRequest              | reasonCode,workflow/evidence refs allowed                                                            | Step-up server-side.                        |
| OperationStatusDto                | operationId,state,reasonCode,result?,links,retryAfterMs                                              | Read-only.                                  |

## 39.1 Ejemplo ProblemDetail

```
{
"type": "https://peopleu/errors/precondition-failed",
"title": "La evaluación cambió desde que fue abierta",
"status": 412,
"code": "PRECONDITION_FAILED",
"detail": "Actualice la información antes de volver a aplicar el cambio.",
"correlationId": "...",
"resourceVersion": 8
}
```

# 40. Checklist de release y certificación final

| **\#** | **Chequeo**                                        | **Estado/Evidencia**               |
|--------|----------------------------------------------------|------------------------------------|
| 1      | Word EC-07 vigente y ADR registrados.              | □ Pendiente / ✓ Adjuntar evidencia |
| 2      | OpenAPI/AsyncAPI validados y client actualizado.   | □ Pendiente / ✓ Adjuntar evidencia |
| 3      | Flyway desde cero y upgrade N-1.                   | □ Pendiente / ✓ Adjuntar evidencia |
| 4      | RLS ENABLE+FORCE; runtime sin BYPASSRLS.           | □ Pendiente / ✓ Adjuntar evidencia |
| 5      | Tenant isolation suite green.                      | □ Pendiente / ✓ Adjuntar evidencia |
| 6      | Append-only triggers/revokes tested.               | □ Pendiente / ✓ Adjuntar evidencia |
| 7      | Lineage no self/cycle/cross-scope tested.          | □ Pendiente / ✓ Adjuntar evidencia |
| 8      | ETag/aggregate revision tested.                    | □ Pendiente / ✓ Adjuntar evidencia |
| 9      | Idempotency replay/conflict/crash recovery tested. | □ Pendiente / ✓ Adjuntar evidencia |
| 10     | Outbox/inbox claim/dedup/recovery tested.          | □ Pendiente / ✓ Adjuntar evidencia |
| 11     | UNKNOWN_EFFECT/reconcile green.                    | □ Pendiente / ✓ Adjuntar evidencia |
| 12     | BigDecimal/rounding/threshold tests green.         | □ Pendiente / ✓ Adjuntar evidencia |
| 13     | LMS duplicate/late/ambiguous mapping tested.       | □ Pendiente / ✓ Adjuntar evidencia |
| 14     | Adjustment/appeal/restatement E2E green.           | □ Pendiente / ✓ Adjuntar evidencia |
| 15     | Completion UNKNOWN/STALE tested.                   | □ Pendiente / ✓ Adjuntar evidencia |
| 16     | Closure holds/reopen/receipt tested.               | □ Pendiente / ✓ Adjuntar evidencia |
| 17     | Security negative tests green.                     | □ Pendiente / ✓ Adjuntar evidencia |
| 18     | SAST/SCA/secrets/container scans + SBOM.           | □ Pendiente / ✓ Adjuntar evidencia |
| 19     | Accessibility critical workspaces/mobile.          | □ Pendiente / ✓ Adjuntar evidencia |
| 20     | Performance/load meet SLO.                         | □ Pendiente / ✓ Adjuntar evidencia |
| 21     | Dashboards/alerts/runbooks deployed.               | □ Pendiente / ✓ Adjuntar evidencia |
| 22     | Migration evidence if applicable.                  | □ Pendiente / ✓ Adjuntar evidencia |
| 23     | Golden Scenarios critical + UAT signed.            | □ Pendiente / ✓ Adjuntar evidencia |
| 24     | Evidence Pack G1-G10 complete.                     | □ Pendiente / ✓ Adjuntar evidencia |
| 25     | Roll-forward plan approved.                        | □ Pendiente / ✓ Adjuntar evidencia |

| **CERTIFICACIÓN —** EC-07 solo puede declararse listo para producción cuando G1–G10 tienen evidencia y los escenarios de tenant isolation, append-only history, idempotencia, concurrency, UNKNOWN_EFFECT, appeals, completion y closure están demostrados. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 41. Contrato FullStack no negociable de implementación

| **\#** | **Garantía no negociable**                                          | **Cómo validar**                                |
|--------|---------------------------------------------------------------------|-------------------------------------------------|
| 1      | Tenant del contexto, nunca body.                                    | Test/constraint/contract/evidence en Git/Gates. |
| 2      | RLS ENABLE+FORCE.                                                   | Test/constraint/contract/evidence en Git/Gates. |
| 3      | Runtime no owner/BYPASSRLS.                                         | Test/constraint/contract/evidence en Git/Gates. |
| 4      | No FK cross-context.                                                | Test/constraint/contract/evidence en Git/Gates. |
| 5      | Refs upstream pinneadas.                                            | Test/constraint/contract/evidence en Git/Gates. |
| 6      | AssessmentPlan PUBLISHED/CLOSED inmutable.                          | Test/constraint/contract/evidence en Git/Gates. |
| 7      | Score/Result/Completion/ClosureReceipt append-only.                 | Test/constraint/contract/evidence en Git/Gates. |
| 8      | Correcciones por supersede/restatement.                             | Test/constraint/contract/evidence en Git/Gates. |
| 9      | Lineage acíclico same-scope.                                        | Test/constraint/contract/evidence en Git/Gates. |
| 10     | BigDecimal + rounding policy.                                       | Test/constraint/contract/evidence en Git/Gates. |
| 11     | 0 ≠ NULL ≠ NOT_EVALUATED.                                           | Test/constraint/contract/evidence en Git/Gates. |
| 12     | ABSENT/EXEMPT/INCOMPLETE explícitos.                                | Test/constraint/contract/evidence en Git/Gates. |
| 13     | PASS ≠ COMPLETION.                                                  | Test/constraint/contract/evidence en Git/Gates. |
| 14     | COMPLETION ≠ CERTIFICATE ELIGIBILITY.                               | Test/constraint/contract/evidence en Git/Gates. |
| 15     | Completion académico ≠ ledger financiero.                           | Test/constraint/contract/evidence en Git/Gates. |
| 16     | Attendance de EC-06.                                                | Test/constraint/contract/evidence en Git/Gates. |
| 17     | LMS/proctoring vía CT-18/09.                                        | Test/constraint/contract/evidence en Git/Gates. |
| 18     | Evidence binaria CT-05.                                             | Test/constraint/contract/evidence en Git/Gates. |
| 19     | Child mutation bump root revision.                                  | Test/constraint/contract/evidence en Git/Gates. |
| 20     | ETag/If-Match.                                                      | Test/constraint/contract/evidence en Git/Gates. |
| 21     | No last-write-wins.                                                 | Test/constraint/contract/evidence en Git/Gates. |
| 22     | Idempotency durable.                                                | Test/constraint/contract/evidence en Git/Gates. |
| 23     | Idempotency lease/recovery.                                         | Test/constraint/contract/evidence en Git/Gates. |
| 24     | Outbox atómica.                                                     | Test/constraint/contract/evidence en Git/Gates. |
| 25     | SKIP LOCKED + lease.                                                | Test/constraint/contract/evidence en Git/Gates. |
| 26     | Inbox dedup.                                                        | Test/constraint/contract/evidence en Git/Gates. |
| 27     | 202 OperationStatus.                                                | Test/constraint/contract/evidence en Git/Gates. |
| 28     | UNKNOWN_EFFECT reconcile-before-retry.                              | Test/constraint/contract/evidence en Git/Gates. |
| 29     | ProblemDetail + reason codes.                                       | Test/constraint/contract/evidence en Git/Gates. |
| 30     | UI states explícitos.                                               | Test/constraint/contract/evidence en Git/Gates. |
| 31     | OpenAPI client generado.                                            | Test/constraint/contract/evidence en Git/Gates. |
| 32     | AsyncAPI versionado.                                                | Test/constraint/contract/evidence en Git/Gates. |
| 33     | AI CT-12 sin grade authority.                                       | Test/constraint/contract/evidence en Git/Gates. |
| 34     | RBAC+ABAC+SoD+step-up.                                              | Test/constraint/contract/evidence en Git/Gates. |
| 35     | Audit actor/scope/reason/correlation/policy/evidence.               | Test/constraint/contract/evidence en Git/Gates. |
| 36     | No PII/blobs innecesarios.                                          | Test/constraint/contract/evidence en Git/Gates. |
| 37     | Expand/contract N/N-1.                                              | Test/constraint/contract/evidence en Git/Gates. |
| 38     | Secure SDLC + SBOM.                                                 | Test/constraint/contract/evidence en Git/Gates. |
| 39     | Migration CT-16.                                                    | Test/constraint/contract/evidence en Git/Gates. |
| 40     | Golden Scenarios/UAT con evidencia.                                 | Test/constraint/contract/evidence en Git/Gates. |
| 41     | CLOSED conserva receipt/hash/counts; correction por new cycle.      | Test/constraint/contract/evidence en Git/Gates. |
| 42     | EC-08 consume CompletionFact/Closure, no infiere desde última nota. | Test/constraint/contract/evidence en Git/Gates. |

| **BASELINE PARA EL SIGUIENTE MÓDULO —** EC-08 debe consumir CompletionFact y AcademicClosure por contratos versionados, preservar las fronteras anteriores y no inferir elegibilidad de certificado desde estados simplificados. EC-07 queda como Source of Truth de evaluación, pass/fail, completion y cierre académico. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
