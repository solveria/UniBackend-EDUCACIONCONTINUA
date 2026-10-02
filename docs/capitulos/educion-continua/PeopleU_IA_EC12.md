**PEOPLEU IA**

**EC-12**

**CALIDAD, ANALÍTICA DE PORTAFOLIO, INDICADORES,  
COMPLIANCE Y MEJORA CONTINUA**

Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Control**    | **Valor**                                                                                                      |
|----------------|----------------------------------------------------------------------------------------------------------------|
| Código         | EC-12                                                                                                          |
| Versión        | V1.0                                                                                                           |
| Estado         | VIGENTE — MÓDULO DE CIERRE Y GOBIERNO EC · FULLSTACK ENTERPRISE                                                |
| Baseline       | EC-00 V1.1 · EC-01 V1.1 · EC-02…EC-11                                                                          |
| Vertical       | Educación Continua / Formación Continua                                                                        |
| Arquitectura   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| Stack objetivo | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| Contexto       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| Fecha base     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS —** Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA —** EC-12 gobierna la calidad específica de Educación Continua: framework versionado, controles, revisiones, evidencias, no conformidades, CAPA, indicadores de calidad, snapshots de salud, compliance aplicable y mejora continua. No sustituye CT-11 BI/analytics, CT-10 seguridad/auditoría/privacy, un sistema legal-regulatorio, gestión de proyectos, RRHH, finanzas ni los hechos operativos de EC-01…EC-11. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaración de propósito, autoridad y baseline

EC-12 es el bounded context de cierre y gobierno de la vertical de Educación Continua. Su misión es convertir los hechos producidos por EC-01…EC-11 en un sistema verificable de aseguramiento de calidad: define marcos y controles versionados, decide qué evidencia demuestra cumplimiento, organiza ciclos de revisión, formaliza no conformidades y acciones correctivas/preventivas, consolida indicadores reproducibles y gobierna la mejora continua sin reescribir el hecho operativo que originó cada señal.

El problema que resuelve no es “hacer dashboards”. Una universidad necesita poder responder, con evidencia: qué estándar estaba vigente; qué controles aplicaban a un programa, edición, cohorte o portafolio; qué datos y documentos se evaluaron; quién emitió la valoración; qué excepciones existían; qué riesgo residual quedó; qué acción correctiva se aprobó; si la mejora funcionó; y cómo se reconstruye la misma conclusión meses o años después. EC-12 convierte esa trazabilidad en contrato técnico y operativo.

El módulo opera sobre un principio de autoridad distribuida. EC-01…EC-11 siguen siendo Source of Truth de sus hechos. CT-11 sigue siendo dueño de datasets/BI y procesamiento analítico transversal. CT-10 sigue gobernando seguridad, privacidad, auditoría y controles transversales. Un registro legal/institucional externo sigue siendo autoridad de normas y obligaciones. EC-12 conserva bindings, snapshots, assessments, evidence receipts y decisiones de calidad EC; nunca copia la realidad ajena para volverse una sombra autoritativa.

Como módulo final de la vertical, EC-12 debe observar la cadena completa: diseño académico, ejecución, oferta, registro, docencia, participación, evaluación, credenciales, formación corporativa, trayectoria e impacto. Su resultado es un circuito cerrado de calidad: OBSERVAR → EVALUAR → DECIDIR → ACTUAR → VERIFICAR → INSTITUCIONALIZAR o RECHAZAR. Ninguna mejora se considera eficaz solo porque se “implementó”; debe demostrar efecto contra una línea base y un criterio de aceptación.

| **CRITERIO DE ÉXITO —** Un equipo Senior y un auditor independiente deben poder reconstruir una decisión de calidad EC desde framework/control vigente hasta evidencia, cálculo, assessment, hallazgo, CAPA, verificación y snapshot final. PostgreSQL debe impedir cruces de tenant, alteración retroactiva de controles publicados, doble assessment incompatible, cierre sin evidencia mínima, waivers sin vencimiento, snapshots no reproducibles y manipulación destructiva de hechos históricos aunque Backend tenga un bug. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquía documental aplicable

| **Prioridad** | **Documento/artefacto**                            | **Rol**                                                                                                 |
|---------------|----------------------------------------------------|---------------------------------------------------------------------------------------------------------|
| 1             | AM-00 vigente                                      | Constitución arquitectónica superior.                                                                   |
| 2             | CT-00 vigente                                      | Contrato maestro transversal.                                                                           |
| 3             | CT-01…CT-18 vigentes                               | Capacidades compartidas y fronteras.                                                                    |
| 4             | EC-00 V1.1                                         | Constitución funcional/arquitectónica de Educación Continua.                                            |
| 5             | EC-01 V1.1                                         | Plantilla oficial FullStack Enterprise y contratos de diseño académico.                                 |
| 6             | EC-02…EC-11                                        | Hechos operativos y de experiencia que EC-12 consume sin duplicar.                                      |
| 7             | EC-12 V1.0                                         | Especificación implementable de calidad, gobierno, compliance y mejora continua EC.                     |
| Externo       | Catálogo legal/regulatorio e institucional vigente | Autoridad normativa; EC-12 conserva refs/snapshots de aplicabilidad, no sustituye interpretación legal. |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs             | Implementación y evidencia alineadas al Word.                                                           |

## 0.2 Secuencia oficial EC

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

## 0.3 Decisiones arquitectónicas EC12-DA

| **ID**      | **Decisión normativa**                                                                                                                                                                   |
|-------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| EC12-DA-001 | QUALITY FRAMEWORK ≠ QUALITY FRAMEWORK VERSION. La identidad del marco es estable; una versión publicada congela dimensiones, controles, pesos, criterios y reglas de evaluación.         |
| EC12-DA-002 | QUALITY CONTROL ≠ CONTROL ASSESSMENT. El control define qué debe cumplirse; el assessment registra el resultado as-of para un scope y una revisión concreta.                             |
| EC12-DA-003 | KPI DEFINITION ≠ KPI SNAPSHOT ≠ LIVE BI QUERY. EC-12 gobierna semántica/thresholds y snapshots aprobados; CT-11 ejecuta datasets/analytics transversales.                                |
| EC12-DA-004 | PORTFOLIO HEALTH SCORE ≠ SIMPLE AVERAGE. Toda agregación requiere dimensión, peso, normalización, treatment de NO_DATA/NA y calculator_version explícitos.                               |
| EC12-DA-005 | COMPLIANCE BINDING ≠ LEGAL SOURCE OF TRUTH. EC-12 registra aplicabilidad y evidencia EC; la norma/obligación proviene de autoridad institucional/legal versionada.                       |
| EC12-DA-006 | COMPLIANCE ATTESTATION ≠ PERPETUAL COMPLIANCE. La atestación es as-of, expira y se invalida si cambia obligación, control, evidencia crítica o scope.                                    |
| EC12-DA-007 | NONCONFORMITY ≠ INCIDENT ≠ SUPPORT TICKET. EC-12 gobierna desviaciones de calidad; incident management y soporte permanecen en sus bounded contexts.                                     |
| EC12-DA-008 | CAPA ≠ GENERIC PROJECT MANAGEMENT. CAPA existe para corregir/prevenir una causa de no conformidad y debe verificar eficacia; no reemplaza un gestor de proyectos.                        |
| EC12-DA-009 | IMPROVEMENT INITIATIVE ≠ DIRECT MUTATION OF UPSTREAM MODULE. EC-12 recomienda/autoriza mejora; el cambio se ejecuta mediante el owner EC/CT correspondiente y se referencia por receipt. |
| EC12-DA-010 | WAIVER ≠ POLICY CHANGE. Una excepción tiene scope, razón, riesgo, controles compensatorios y vencimiento; no modifica el estándar vigente ni se renueva silenciosamente.                 |
| EC12-DA-011 | EVIDENCE REF ≠ DOCUMENT BLOB. CT-05 conserva artefactos; EC-12 guarda requirement, hash, lineage, classification y receipt verificable.                                                  |
| EC12-DA-012 | CONTROL EVIDENCE ≠ ASSURANCE DECISION. Evidencia puede ser válida pero insuficiente; assessment/attestation requieren actor autorizado, criterios y timestamp.                           |
| EC12-DA-013 | PASS ≠ FOREVER. Un assessment PASS representa un momento y watermark; cambios materiales pueden volverlo STALE y exigir reevaluación.                                                    |
| EC12-DA-014 | NO_DATA ≠ ZERO ≠ NOT_APPLICABLE ≠ NOT_ASSESSED ≠ SUPPRESSED ≠ STALE. Estados analíticos distintos nunca se colapsan en una cifra conveniente.                                            |
| EC12-DA-015 | QUALITY GATE DECISION ≠ CROSS-CONTEXT STATE MUTATION. EC-12 emite un receipt/decision token; el módulo dueño consume el contrato y decide su transición según policy.                    |
| EC12-DA-016 | AI INSIGHT ≠ QUALITY DECISION. CT-12 puede detectar anomalías, resumir evidencia o proponer causas/CAPA; no aprueba controles, waivers, compliance ni cierre de hallazgos.               |
| EC12-DA-017 | CROSS-CONTEXT REFERENCE ≠ FK. EC-01…EC-11, CT, IAM y cores se consumen por EXT REF, ports, snapshots y receipts; nunca FK física.                                                        |
| EC12-DA-018 | TENANT CONTEXT ≠ REQUEST BODY. tenant_id proviene del contexto autorizado; RLS ENABLE+FORCE protege toda tabla tenant-owned.                                                             |
| EC12-DA-019 | AGGREGATE REVISION REPRESENTS THE WHOLE AGGREGATE. Mutar hijos bump revision del root y obliga If-Match/ETag; no last-write-wins.                                                        |
| EC12-DA-020 | PUBLISHED/APPROVED SNAPSHOT = IMMUTABLE. FrameworkVersion, ControlVersion, KPI snapshot, scorecard aprobado, attestation y gate decision se preservan históricamente.                    |
| EC12-DA-021 | OUTBOX/INBOX ≠ EXACTLY-ONCE. Se garantiza deduplicación/idempotencia, leasing y reconciliación; no se promete exactly-once distribuido.                                                  |
| EC12-DA-022 | UNKNOWN_EFFECT ≠ FAILURE. Si una acción remota puede haberse aplicado, EC-12 conserva estado UNKNOWN_EFFECT y reconcilia antes de retry.                                                 |
| EC12-DA-023 | PORTFOLIO ANALYTICS ≠ PEOPLE RANKING. Métricas de calidad no habilitan rankings individuales de docentes/participantes sin purpose, policy y bounded context autorizado.                 |
| EC12-DA-024 | CONTROL COVERAGE ≠ CONTROL EFFECTIVENESS. Tener un control mapeado no demuestra que opere ni que reduzca riesgo; effectiveness requiere evidencia/assessment.                            |
| EC12-DA-025 | QUALITY REVIEW ≠ AUDIT GENERAL. EC-12 organiza revisiones de calidad EC; CT-10 conserva auditoría transversal y evidencia de acceso/cambio.                                              |
| EC12-DA-026 | REGULATORY CHANGE ≠ SILENT UPDATE. Una nueva versión de obligación crea drift y re-evaluación; nunca reescribe attestations históricas.                                                  |
| EC12-DA-027 | METRIC FORMULA ≠ RAW SQL. Indicadores se expresan mediante DSL/contract versionado y CT-11 dataset refs; SQL arbitrario no entra desde UI/API.                                           |
| EC12-DA-028 | QUALITY SCORECARD ≠ RAW DATA EXPORT. El scorecard publica métricas autorizadas, lineage y freshness; datos sensibles permanecen sujetos a policy/suppression.                            |
| EC12-DA-029 | CORRECTIVE ACTION VERIFIED ≠ NONCONFORMITY CLOSED. El cierre exige verificar eficacia y ausencia de evidencia contradictoria; terminar tareas no basta.                                  |
| EC12-DA-030 | CONTINUOUS IMPROVEMENT REQUIRES COUNTERFACTUAL DISCIPLINE. Toda iniciativa define baseline, target, ventana y criterio de éxito; no se declara mejora solo por correlación temporal.     |
| EC12-DA-031 | RELEASE SCHEMA ≠ APP RELEASE. Flyway sigue expand → deploy compatible → backfill → switch → contract con compatibilidad N/N-1.                                                           |
| EC12-DA-032 | OPENAPI/ASYNCAPI ARE EXECUTABLE CONTRACTS. Generan clientes/tests y participan en compatibility gates; no son documentación ornamental.                                                  |

## 0.4 Criterio de suficiencia FullStack

EC-12 es suficiente cuando dos equipos Senior independientes pueden implementar el mismo comportamiento observable: framework versionado, controles, assessments, compliance bindings, evidencia, CAPA, indicadores, scorecards, alerts, waivers, quality gates, APIs/eventos, estados de UI, seguridad, RLS, idempotencia, outbox/inbox, observabilidad y operación; sin inventar decisiones centrales. Las variaciones institucionales deben quedar parametrizadas o en ADR, nunca implícitas.

## 0.5 Matriz de cierre de hallazgos/revisión

| **Severidad** | **Hallazgo**                                | **Cierre normativo EC-12**                                                          | **Evidencia**           |
|---------------|---------------------------------------------|-------------------------------------------------------------------------------------|-------------------------|
| P0            | “Calidad” reducida a dashboards             | Framework, control, assessment, evidence y CAPA como dominio first-class.           | Domain tests + UAT      |
| P0            | Analítica invade Source of Truth            | CT-11 computa datasets; EC-12 fija semántica, thresholds y snapshots gobernados.    | Contract tests          |
| P0            | Cumplimiento tratado como checkbox eterno   | Binding versionado, attestation as-of/expiry, drift y reevaluation.                 | State/expiry tests      |
| P0            | Excepciones sin límite                      | Waiver con scope, compensating controls, approver, expiry y revoke.                 | DB + UAT                |
| P0            | No conformidad se cierra al terminar tareas | Cierre exige effectiveness verification separada.                                   | Golden Scenario         |
| P0            | Score de salud opaco                        | Weights, normalization, NO_DATA/NA treatment, calculator_version y input watermark. | Reproducibility test    |
| P0            | Evidence link mutable                       | Receipt append-only + hash + CT-05 ref + classification.                            | DB trigger              |
| P1            | Cambios regulatorios invisibles             | Obligation version ref + drift alert + stale attestations.                          | Integration test        |
| P1            | IA toma decisiones de calidad               | CT-12 assist only + provenance + reviewer + no auto close/approve.                  | AI eval gate            |
| P1            | Cross-tenant leakage en reportes            | RLS + ABAC + scope + suppression + export policy.                                   | Negative security tests |
| P1            | Timeout de integración genera doble acción  | Idempotency + UNKNOWN_EFFECT + reconciliation.                                      | Chaos/resilience suite  |
| P1            | Mejora sin verificación de impacto          | Baseline/target/horizon/experiment/verification receipt.                            | UAT + KPI evidence      |

# 1. Índice operativo

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01…CT-18, cores y módulos EC

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal BR-EC12

- 10\. Casos de uso UC-EC12

- 11\. DER conceptual, lógico y físico

- 12\. Modelo físico PostgreSQL tabla por tabla

- 13\. DDL PostgreSQL completo — Flyway Ready

- 14\. MongoDB y Redis

- 15\. Backend Java 21 / Spring Boot / Spring Modulith

- 16\. APIs REST

- 17\. Eventos, Outbox, Inbox y AsyncAPI

- 18\. Integraciones, resiliencia y UNKNOWN_EFFECT

- 19\. Frontend Web enterprise por Workspaces

- 20\. Mobile

- 21\. Matriz Frontend / Backend / Mobile

- 22\. Seguridad

- 23\. Auditoría y Evidence Pack

- 24\. Observabilidad, SLI/SLO y performance

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

- 40\. Checklist de release y certificación

- 41\. Contrato FullStack no negociable de implementación

# 2. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

EC-12 convierte “calidad” en un sistema operativo de gobierno. Un programa puede venderse bien y aun así tener debilidades de diseño; una edición puede terminar sin incidentes y aun así incumplir evidencias; un NPS alto puede coexistir con baja transferencia; una credencial puede emitirse correctamente pero con un proceso de assessment insuficiente. Por eso EC-12 no confía en una sola métrica: organiza controles, evidencia, assessments y señales longitudinales por dimensión y contexto.

La arquitectura separa tres capas: (1) definición de calidad — framework, dimensions, control versions, indicator semantics y compliance bindings; (2) assurance — review cycles, scopes, evidence receipts, control assessments, attestations, waivers, quality gates y snapshots; (3) mejora — nonconformities, CAPA, initiatives, experiments, alerts y verification. Esta separación evita que una tendencia analítica se convierta directamente en decisión normativa o que una opinión de auditor modifique retroactivamente la regla evaluada.

EC-12 es también el punto de convergencia de toda la vertical. Consume contratos de EC-01…EC-11 y produce decisiones/snapshots que pueden bloquear o condicionar procesos solo mediante contratos explícitos. El módulo dueño del proceso conserva autoridad sobre su estado. Esta regla es crucial para mantener bounded contexts limpios y evitar un “supermódulo de calidad” acoplado a todas las tablas.

## 2.1 Incluido

- QualityFramework y QualityFrameworkVersion con dimensiones, pesos y criterios versionados.

- QualityControl y ControlVersion con objetivo, método de test, frecuencia, severidad, owner y evidence requirements.

- ComplianceBinding hacia obligación externa/institucional versionada, con aplicabilidad EC y vigencia.

- QualityReviewCycle multi-scope: portfolio, program version, edition, corporate engagement, pathway, campaign o tenant.

- ControlAssessment con resultado PASS/PARTIAL/FAIL/NOT_APPLICABLE, assurance level, rationale y watermark.

- EvidenceRequirement y ControlEvidenceReceipt append-only, referenciando CT-05 y hashes verificables.

- Nonconformity con severidad, causa, impacto, source, SLA y lifecycle.

- CAPA Plan y CorrectiveAction con responsable, due date, verification y effectiveness criteria.

- ImprovementInitiative/Experiment con hypothesis, baseline, target, horizon, owner y decision ADOPT/REJECT.

- IndicatorDefinition y IndicatorThreshold con semántica, grain, unit, formula DSL/contract y fuente CT-11.

- IndicatorSnapshot, PortfolioHealthSnapshot y QualityScorecardSnapshot reproducibles y aprobables.

- ComplianceAttestation con expiry, evidence set, reviewer/approver y drift handling.

- ExceptionWaiver con risk acceptance, compensating controls, expiry y revocation.

- QualityAlert para threshold breach, stale evidence, regulatory drift, overdue CAPA y control regression.

- Domain Quality Gate Assessment para readiness/closure de procesos EC mediante receipt, no mutación directa.

- Workspaces web, mobile selectivo, APIs, eventos, seguridad, auditoría, observabilidad, QA, UAT y runbooks.

- IA vía CT-12 para anomaly detection, evidence summarization, root-cause hypotheses y improvement suggestions, siempre con revisión humana.

## 2.2 Fuera de alcance

- No es un BI general ni reemplaza CT-11.

- No es GRC corporativo universal ni catálogo legal maestro.

- No interpreta jurídicamente normas; consume autoridad/versiones externas.

- No sustituye CT-10 seguridad, auditoría, privacy ni incident management.

- No modifica directamente ProgramVersion, Edition, Enrollment, Result, Credential, Agreement, Trajectory o Feedback facts.

- No almacena documentos/binarios; CT-05 es Source of Truth de artefactos.

- No es gestor de proyectos general; CAPA/initiatives se limitan a calidad EC.

- No es help desk ni issue tracker de software.

- No evalúa desempeño laboral individual de docentes o personal; RRHH conserva autoridad.

- No crea movimientos financieros, facturas ni pagos.

- No llama proveedores de IA directamente; toda IA pasa por CT-12.

- No permite SQL arbitrario ni fórmulas ejecutables libres definidas por usuarios.

| **ANTI-SCOPE —** EC-12 debe ser poderoso sin volverse un “God Module”. Su autoridad se limita a gobernar calidad EC, decisiones de assurance y mejora; los hechos de negocio y las capacidades transversales permanecen en sus bounded contexts. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Término**                | **Definición normativa**                                                                                                             |
|----------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| QualityFramework           | Identidad estable del modelo de calidad EC. Puede evolucionar por versiones sin reescribir historia.                                 |
| QualityFrameworkVersion    | Snapshot publicado de dimensiones, pesos, controles aplicables y reglas de scoring.                                                  |
| QualityDimension           | Eje de calidad como diseño académico, delivery, learner experience, assessment integrity, credential integrity, compliance o impact. |
| QualityControl             | Identidad estable de un control EC a través del tiempo.                                                                              |
| ControlVersion             | Versión inmutable publicada del objetivo de control, test method, evidence requirements, frecuencia, applicability y severity.       |
| ComplianceBinding          | Vinculación versionada entre una obligación externa/institucional y controles EC que demuestran aplicabilidad/cumplimiento.          |
| QualityReviewCycle         | Instancia gobernada de revisión con framework version, scope, periodo, roles, freeze point y estado.                                 |
| ReviewScope                | Contexto evaluado: PORTFOLIO, PROGRAM_VERSION, EDITION, ENGAGEMENT, PATHWAY, CAMPAIGN u otro scope permitido.                        |
| ControlAssessment          | Decisión as-of sobre un ControlVersion en un ReviewScope con evidencia y assurance level.                                            |
| EvidenceRequirement        | Especificación de qué evidencia mínima exige un ControlVersion.                                                                      |
| ControlEvidenceReceipt     | Registro append-only de evidencia presentada/observada, con hash, CT-05 ref, classification y collector.                             |
| Nonconformity              | Desviación comprobada respecto de un control, estándar, obligación o threshold aplicable.                                            |
| CAPA                       | Plan de Corrective and Preventive Action orientado a causa, remediación y prevención, con verificación de eficacia.                  |
| CorrectiveAction           | Acción concreta de un CAPA con owner, due date, completion evidence y verification.                                                  |
| ImprovementInitiative      | Hipótesis de mejora priorizada, distinta de una no conformidad obligatoria.                                                          |
| ImprovementExperiment      | Intervención medible con baseline, target, cohort/scope, horizon y criterio ADOPT/REJECT.                                            |
| IndicatorDefinition        | Semántica versionada de una métrica de calidad: grain, unit, formula contract, fuente, ventana y tratamiento de estados.             |
| IndicatorThreshold         | Banda/version de límites que transforma una observación en NORMAL/WATCH/BREACH según contexto.                                       |
| IndicatorSnapshot          | Valor reproducible as-of con dataset watermark, formula version, quality state y hash.                                               |
| PortfolioHealthSnapshot    | Composición gobernada de múltiples dimensiones/indicadores; no promedio improvisado.                                                 |
| QualityScorecardSnapshot   | Vista aprobada para un scope/audiencia con lineage, freshness y estados explícitos.                                                  |
| ComplianceAttestation      | Afirmación aprobada as-of de cumplimiento/no cumplimiento/no aplicabilidad con evidencia, expiración y reviewer.                     |
| ExceptionWaiver            | Excepción temporal aprobada respecto de un control, con riesgo, compensating controls y expiry.                                      |
| QualityAlert               | Señal operativa por breach, stale evidence, drift, regression, overdue action o anomalía gobernada.                                  |
| QualityGateDecision        | Receipt/decisión PASS\|CONDITIONAL\|FAIL emitido para un proceso EC; el owner del proceso decide transición según contract.          |
| AssuranceLevel             | Nivel de confianza del assessment: SELF, REVIEWED, INDEPENDENT u otro catálogo gobernado.                                            |
| Evidence Watermark         | Instante/version hasta el cual se congelaron inputs para reproducir una decisión.                                                    |
| Regulatory Drift           | Diferencia detectada entre binding/attestation vigente y una nueva versión de obligación aplicable.                                  |
| Effectiveness Verification | Evaluación posterior que demuestra si una CAPA o mejora logró el efecto esperado.                                                    |
| Quality Debt               | Acumulación explícita y priorizada de gaps de calidad aceptados temporalmente; no excusa incumplimientos no autorizados.             |

# 4. Bounded Context y matriz Source of Truth

EC-12 posee la semántica y evidencia de quality assurance específica de Educación Continua. Los hechos académicos, comerciales, operativos, de persona, analíticos o regulatorios permanecen fuera. La siguiente matriz es normativa y debe reflejarse en context map, package boundaries, contratos y tests.

| **Información**                    | **Source of Truth**           | **EC-12 almacena** | **EC-12 referencia**                               | **Regla**                                       |
|------------------------------------|-------------------------------|--------------------|----------------------------------------------------|-------------------------------------------------|
| ProgramDefinition/Version          | EC-01                         | No                 | program/program_version refs + snapshots puntuales | No diseño académico local.                      |
| Edition/Offering/Cohort            | EC-02                         | No                 | edition/cohort refs                                | No scheduling/operación local.                  |
| Pricing/Promotion                  | EC-03                         | No                 | commercial refs                                    | Solo señales de calidad/compliance autorizadas. |
| Registration/Enrollment            | EC-04                         | No                 | enrollment/roster refs                             | No roster shadow.                               |
| Instructor/Delivery Plan           | EC-05                         | No                 | assignment/content readiness refs                  | No RRHH local.                                  |
| Attendance/Engagement              | EC-06                         | No                 | attendance/engagement snapshots refs               | Input de indicadores.                           |
| Assessment/Completion              | EC-07                         | No                 | result/completion refs                             | No recalcular nota/completion.                  |
| Credential Award                   | EC-08                         | No                 | credential refs                                    | Input de integrity controls.                    |
| Corporate Engagement/SLA           | EC-09                         | No                 | engagement/reporting profile refs                  | Quality/SLA evidence, no CRM.                   |
| Trajectory/Progress                | EC-10                         | No                 | path/progress refs                                 | Quality of progression, no recompute.           |
| Feedback/NPS/Impact                | EC-11                         | No                 | campaign/report/impact refs                        | Input de experience/impact.                     |
| Quality Framework/Controls         | EC-12                         | Sí                 | —                                                  | Source of Truth local.                          |
| Review/Assessment/Evidence Receipt | EC-12                         | Sí                 | —                                                  | Source of Truth local.                          |
| Nonconformity/CAPA/Improvement     | EC-12                         | Sí                 | —                                                  | Source of Truth local.                          |
| Indicator semantics/thresholds     | EC-12                         | Sí                 | CT-11 dataset/computation refs                     | Definición de calidad EC.                       |
| Analytics datasets/live BI         | CT-11                         | No                 | dataset_id/version/watermark                       | No duplicar pipelines.                          |
| Documents/artifacts                | CT-05                         | No                 | artifact/evidence refs + hash                      | No blobs.                                       |
| Security/privacy/audit policy      | CT-10                         | No                 | policy refs                                        | EC-12 conserva execution evidence.              |
| AI runs/models/evals               | CT-12                         | No                 | ai_run_ref                                         | No SDK/proveedor local.                         |
| Scheduling                         | CT-13                         | No                 | schedule refs                                      | No scheduler local.                             |
| Migration lineage                  | CT-16 + EC-12 receipts        | Parcial            | migration refs                                     | CT-16 proceso; EC-12 facts promovidos.          |
| Norma/obligación legal             | Autoridad legal/institucional | No                 | obligation_ref + version + effective dates         | EC-12 no interpreta ni reescribe norma.         |

# 5. Dependencias CT-01 a CT-18, cores y módulos EC

| **Dependencia** | **Responsabilidad**              | **Contrato consumido**                              | **Frontera**                                   |
|-----------------|----------------------------------|-----------------------------------------------------|------------------------------------------------|
| CT-01           | Scope institucional              | sede/campus/owner scope refs                        | Fail-closed si scope no resolvible.            |
| CT-02           | Catálogos/policies               | dimension/control types, severity, assurance levels | Códigos versionados, no enums rígidos.         |
| CT-03           | Temporalidad                     | periods/timezone/effective windows                  | UTC + timezone explícita.                      |
| CT-04           | Persona                          | reviewer/approver/owner subject refs                | No Person local.                               |
| CT-05           | Documentos/evidence              | artifact/evidence refs + hashes                     | No blobs; receipts append-only.                |
| CT-06           | Workflow                         | review/waiver/attestation approvals                 | Workflow orquesta; dominio valida invariantes. |
| CT-07           | Notifications                    | alerts, overdue CAPA, review reminders              | Post-commit + receipts.                        |
| CT-08           | i18n                             | labels/descriptions/localized scorecards            | Canonical + overlays.                          |
| CT-09           | Integration governance           | events/webhooks/contracts                           | Outbox/inbox + schema registry.                |
| CT-10           | Security/audit/privacy           | RBAC/ABAC/SoD/purpose/audit                         | Policy SoT; EC-12 execution evidence.          |
| CT-11           | Analytics                        | datasets, computation jobs, BI projections          | No raw shadow; refs + watermarks.              |
| CT-12           | IA                               | anomaly/root-cause/summarization assists            | Human review + provenance.                     |
| CT-13           | Scheduling                       | review cadence, attestation expiry, alerts          | No local cron authority.                       |
| CT-14           | Configuration/feature governance | tenant parameters, rollout flags                    | Versioned config.                              |
| CT-15           | Rules/eligibility                | applicability rules when shared                     | EC-12 consumes rule refs.                      |
| CT-16           | Migration/Data Quality           | extract/map/dry-run/promote/reconcile               | No direct final INSERT.                        |
| CT-17           | Operations/retention             | retention/disposition/operational policies          | Evidence and runbooks.                         |
| CT-18           | LMS/Zoom/external learning       | external delivery evidence refs                     | No duplicate provider state.                   |
| EC-01           | Design quality                   | ProgramVersion published facts/outcomes/pathways    | Assessment only; no direct mutation.           |
| EC-02           | Operational readiness            | Edition/cohort/calendar facts                       | Quality gate receipt via contract.             |
| EC-03           | Commercial compliance            | Offer/pricing policy refs                           | No finance truth.                              |
| EC-04           | Access/roster quality            | enrollment/capacity facts                           | No participant master.                         |
| EC-05           | Teaching readiness               | assignment/content/delivery evidence                | No HR decision.                                |
| EC-06           | Participation quality            | attendance/engagement signals                       | No attendance override.                        |
| EC-07           | Assessment integrity             | result/completion/closure evidence                  | No grade/completion update.                    |
| EC-08           | Credential integrity             | award/revocation/verification refs                  | No credential mutation.                        |
| EC-09           | Corporate quality                | SLA/milestone/reporting refs                        | No contract ledger.                            |
| EC-10           | Pathway quality                  | progress/recognition refs                           | No trajectory recompute.                       |
| EC-11           | Experience/impact                | NPS/feedback/impact snapshots                       | No raw response bypass.                        |

# 6. Arquitectura funcional E2E y journeys

| **ARQUITECTURA E2E —** Publish QualityFrameworkVersion → Bind controls/obligations → Plan ReviewCycle → Freeze Scope/Watermark → Collect Evidence → Assess Controls → Detect Gaps/Drift → Attest / Gate Decision → Open Nonconformity/CAPA → Execute Change in owner context → Verify Effectiveness → Build KPI/Health Snapshots → Institutionalize Improvement → Feed next review. Cada cruce de bounded context usa contrato, receipt y policy. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **Journey** | **Nombre**               | **Flujo E2E**                                                                                                                                                              |
|-------------|--------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| J-EC12-01   | Publicar framework       | Quality Manager crea versión → dimensions/weights → controls/version pins → validation → independent review → publish immutable snapshot.                                  |
| J-EC12-02   | Review de portafolio     | Crear ReviewCycle trimestral → resolver scope de ProgramVersions/editions → freeze watermark → recolectar evidencia → assessments → scorecard → close.                     |
| J-EC12-03   | Gate de edición          | EC-02 solicita readiness gate → EC-12 evalúa controles de contenido/docentes/calendario/evidencia → emite PASS/CONDITIONAL/FAIL receipt → EC-02 aplica policy propia.      |
| J-EC12-04   | Regulatory drift         | Nueva obligation version → binding previo queda STALE → alerts → re-evaluation → nueva attestation; historia anterior permanece.                                           |
| J-EC12-05   | No conformidad crítica   | Control FAIL → Nonconformity CRITICAL → CAPA → actions → owner module change receipt → effectiveness verification → close solo si criterio cumplido.                       |
| J-EC12-06   | Mejora voluntaria        | NPS/impact trend genera signal → analyst propone initiative → baseline/target → experiment → measurement → ADOPT o REJECT → learning captured.                             |
| J-EC12-07   | Portfolio health         | IndicatorSnapshots desde CT-11 watermarks → normalization/weights → health per dimension → quality state + confidence/freshness → approved snapshot.                       |
| J-EC12-08   | Waiver temporal          | Control no cumplible antes de deadline → request waiver → risk + compensating controls + expiry → SoD approval → alerts before expiry → revoke/expire/replace.             |
| J-EC12-09   | Evidence unavailable     | CT-05 timeout → operation UNKNOWN_EFFECT/UNAVAILABLE → review no se marca PASS → reconcile artifact → continue with provenance.                                            |
| J-EC12-10   | AI anomaly assist        | Indicator series autorizada → CT-12 anomaly/root-cause hypotheses → analyst review → optional alert/initiative; no auto FAIL/CAPA.                                         |
| J-EC12-11   | Cross-tenant assurance   | Auditor scoped a Tenant A consulta review → RLS + ABAC bloquean Tenant B aun con ID conocido.                                                                              |
| J-EC12-12   | Evidence pack            | Auditor reconstruye framework version, control version, obligation refs, evidence receipts, assessments, signatures, waivers, CAPA y hashes sin acceder a tablas upstream. |
| J-EC12-13   | Quality debt             | Gap no crítico autorizado → explicit quality debt record/nonconformity with waiver → deadline + owner → visible en board → no desaparece de scorecard.                     |
| J-EC12-14   | Metric definition change | Nueva fórmula/unidad/threshold → new IndicatorDefinition version → old snapshots keep calculator_version → comparability flag prevents false trend.                        |
| J-EC12-15   | Annual governance close  | Cierra ciclo anual → approved portfolio scorecard → improvement backlog → evidence pack → next framework review recommendations.                                           |

# 7. Modelo de dominio

## 7.1 Aggregates y Aggregate Roots

| **Aggregate Root**    | **Children**                                                         | **Invariante central**                                                |
|-----------------------|----------------------------------------------------------------------|-----------------------------------------------------------------------|
| QualityFramework      | QualityFrameworkVersion, QualityDimension                            | Gobierna modelo de calidad publicado y sus dimensiones.               |
| QualityControl        | ControlVersion, EvidenceRequirement                                  | Gobierna objetivo/test/evidencia del control a través de versiones.   |
| ComplianceBinding     | —                                                                    | Vincula obligation version externa con controles/scopes EC.           |
| QualityReviewCycle    | ReviewScope, ControlAssessment, ControlEvidenceReceipt               | Gobierna una revisión as-of y su evidence freeze.                     |
| Nonconformity         | CAPAPlan, CorrectiveAction                                           | Gobierna desviación, remediación, verificación y cierre.              |
| ImprovementInitiative | ImprovementExperiment                                                | Gobierna hipótesis, baseline, target, intervención y decisión.        |
| IndicatorDefinition   | IndicatorThreshold                                                   | Gobierna semántica/versionado de indicadores de calidad.              |
| QualitySnapshot       | IndicatorSnapshot, PortfolioHealthSnapshot, QualityScorecardSnapshot | Gobierna snapshots reproducibles/approval/distribution.               |
| ComplianceAttestation | —                                                                    | Gobierna atestación as-of con evidence set, expiry y sign-off.        |
| ExceptionWaiver       | —                                                                    | Gobierna excepción temporal, risk acceptance y compensating controls. |
| QualityAlert          | —                                                                    | Gobierna señal/triage/resolution sin volverse incident manager.       |
| QualityGateAssessment | —                                                                    | Gobierna decision receipt para readiness/closure cross-context.       |

## 7.2 Value Objects

- QualityScope(scopeType, scopeRef, ownerScopeRef, periodRef?, asOf)

- ControlApplicability(ruleRef, effectiveFrom, effectiveTo, exclusions)

- EvidenceContract(evidenceType, mandatory, freshnessMaxAge, classification, hashRequired)

- AssessmentResult(result, assuranceLevel, rationale, evidenceWatermark, assessedAt)

- MetricSemantics(grain, unit, direction, window, aggregation, missingDataPolicy)

- FormulaContract(formulaDslVersion, expressionRef, datasetContractRef, calculatorVersion)

- ThresholdBand(code, lower, upper, severity, inclusiveRules)

- HealthWeight(dimensionCode, normalizedWeight, minCoverage)

- ComplianceReference(obligationRef, obligationVersionRef, authorityRef, effectiveDates)

- WaiverRisk(severity, residualRisk, compensatingControls, expiry)

- EffectivenessCriterion(metricRef, baseline, target, horizon, confidenceRule)

- EvidenceProvenance(sourceContextRef, artifactRef, hash, occurredAt, collectedAt)

- QualityState(NO_DATA\|ZERO\|VALUE\|STALE\|PARTIAL\|UNAVAILABLE\|SUPPRESSED\|NOT_APPLICABLE)

- DecisionSignature(subjectRef, roleRef, stepUpRef, signedAt, reasonCode)

## 7.3 Domain Policies / Services

- FrameworkPublicationPolicy

- ControlVersionPublicationPolicy

- ControlApplicabilityPolicy

- EvidenceSufficiencyPolicy

- QualityReviewFreezePolicy

- ControlAssessmentPolicy

- HealthScoreCalculationService

- IndicatorComparabilityPolicy

- ComplianceDriftPolicy

- AttestationValidityPolicy

- WaiverApprovalPolicy

- NonconformitySeverityPolicy

- CAPAClosurePolicy

- EffectivenessVerificationPolicy

- ImprovementPrioritizationPolicy

- QualityGatePolicy

- SnapshotApprovalPolicy

- QualityDebtVisibilityPolicy

- AlertDeduplicationPolicy

- RetentionAndDispositionPolicy

## 7.4 Aggregate Revision Contract

Toda mutación de un hijo sigue el contrato EC oficial: resolver tenant → abrir transacción → SET LOCAL peopleu.tenant_id → cargar/lock root → comparar If-Match → ejecutar método de intención → persistir hijos → bump revision del root → audit/outbox/idempotency cuando aplique → commit → devolver nuevo ETag. Mutar EvidenceRequirement, ReviewScope, CorrectiveAction, Threshold o Experiment nunca puede dejar revision del root sin incrementar. Mismatch responde 412 PRECONDITION_FAILED.

Los snapshots/decisiones finales tienen reglas más estrictas: QualityFrameworkVersion PUBLISHED, ControlVersion PUBLISHED, ControlAssessment LOCKED, QualityScorecard APPROVED, ComplianceAttestation APPROVED y QualityGateDecision ISSUED son inmutables salvo transiciones explícitas que creen nuevas versiones, supersession, revoke o void receipts. No se permite PATCH genérico sobre hechos históricos.

# 8. Máquinas de estado normativas

| **Entidad**             | **Estados/transiciones**                                                                       | **Regla**                                                                        |
|-------------------------|------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------|
| QualityFrameworkVersion | DRAFT → IN_REVIEW → APPROVED → PUBLISHED → SUPERSEDED \| VOID                                  | PUBLISHED immutable; nueva versión para cambio material.                         |
| ControlVersion          | DRAFT → IN_REVIEW → APPROVED → PUBLISHED → RETIRED \| VOID                                     | PUBLISHED pinneable; retirement no borra historia.                               |
| QualityReviewCycle      | DRAFT → PLANNED → IN_PROGRESS → EVIDENCE_FROZEN → REVIEWED → CLOSED \| CANCELLED               | Freeze bloquea cambios de scope/watermark salvo reopen gobernado.                |
| ControlAssessment       | NOT_ASSESSED → IN_PROGRESS → READY_FOR_REVIEW → LOCKED \| VOID                                 | LOCKED fija result/evidence watermark; amendment crea nueva assessment revision. |
| Nonconformity           | OPEN → TRIAGED → ACTION_PLANNED → IN_REMEDIATION → VERIFYING → CLOSED \| ACCEPTED_RISK \| VOID | CLOSED exige effectiveness verification.                                         |
| CAPAPlan                | DRAFT → APPROVED → ACTIVE → VERIFYING → EFFECTIVE \| INEFFECTIVE \| CANCELLED                  | EFFECTIVE solo tras criterio verificado.                                         |
| CorrectiveAction        | TODO → IN_PROGRESS → READY_FOR_VERIFY → VERIFIED \| REJECTED \| CANCELLED                      | VERIFIED requiere completion evidence.                                           |
| ImprovementInitiative   | PROPOSED → PRIORITIZED → ACTIVE → MEASURING → ADOPTED \| REJECTED \| CANCELLED                 | ADOPTED exige outcome evidence.                                                  |
| ImprovementExperiment   | DESIGNED → RUNNING → OBSERVATION → CONCLUDED → ADOPTED \| REJECTED \| ABORTED                  | No editar baseline después de RUNNING.                                           |
| IndicatorDefinition     | DRAFT → IN_REVIEW → APPROVED → ACTIVE → RETIRED \| VOID                                        | ACTIVE versioned semantics immutable.                                            |
| QualitySnapshot         | BUILDING → READY → IN_REVIEW → APPROVED → PUBLISHED \| FAILED \| VOID                          | APPROVED/PUBLISHED immutable; rebuild crea nuevo snapshot.                       |
| ComplianceAttestation   | DRAFT → SUBMITTED → APPROVED \| REJECTED → EXPIRED \| SUPERSEDED \| REVOKED                    | APPROVED as-of, con expiry y obligation version pin.                             |
| ExceptionWaiver         | REQUESTED → IN_REVIEW → APPROVED → ACTIVE → EXPIRED \| REVOKED \| REJECTED                     | ACTIVE exige expiry y compensating controls.                                     |
| QualityAlert            | OPEN → ACKNOWLEDGED → INVESTIGATING → RESOLVED \| DISMISSED                                    | Resolution reason + link a action/assessment.                                    |
| QualityGateAssessment   | DRAFT → EVALUATING → PASS \| CONDITIONAL \| FAIL → SUPERSEDED \| VOID                          | Terminal result emite immutable decision receipt.                                |

# 9. Catálogo formal BR-EC12

| **ID**      | **Nombre**             | **Regla implementable/verificable**                                                                                                                               |
|-------------|------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| BR-EC12-001 | Tenancy/Authority      | Toda fila tenant-owned debe incluir tenant_id y quedar protegida por RLS ENABLE+FORCE; runtime role no puede tener BYPASSRLS.                                     |
| BR-EC12-002 | Tenancy/Authority      | tenant_id se resuelve desde TenantContext autenticado y nunca se acepta desde body/query/header controlado por cliente.                                           |
| BR-EC12-003 | Tenancy/Authority      | Una referencia a EC-01…EC-11, CT, IAM o core externo se almacena como EXT REF y nunca como FK física cross-context.                                               |
| BR-EC12-004 | Tenancy/Authority      | EC-12 no puede corregir directamente hechos de módulos upstream; toda remediación se ejecuta por contract/command del owner y conserva receipt.                   |
| BR-EC12-005 | Tenancy/Authority      | El Source of Truth de una obligación legal/regulatoria no puede ser una tabla EC-12; solo se conserva obligation_ref, version_ref y snapshot metadata autorizado. |
| BR-EC12-006 | Tenancy/Authority      | CT-11 es autoridad de datasets analíticos; EC-12 no puede crear un pipeline paralelo que se convierta en shadow BI.                                               |
| BR-EC12-007 | Tenancy/Authority      | CT-05 es autoridad de documentos; evidence receipt local debe apuntar a artifact_ref/hash y nunca almacenar blob oficial.                                         |
| BR-EC12-008 | Tenancy/Authority      | CT-10 es autoridad de políticas de seguridad/privacy/audit; EC-12 almacena policy refs y evidencias de ejecución, no copia políticas como verdad independiente.   |
| BR-EC12-009 | Tenancy/Authority      | Toda query cross-scope debe verificar tenant, institutional scope, ABAC y purpose antes de resolver referencias externas.                                         |
| BR-EC12-010 | Tenancy/Authority      | Un dato derivado de upstream debe llevar source_context_ref/source_event_ref o dataset watermark suficiente para reconstruir lineage.                             |
| BR-EC12-011 | Framework/Versioning   | QualityFrameworkVersion PUBLISHED es inmutable; todo cambio material crea nueva versión con previous_version_ref y reason.                                        |
| BR-EC12-012 | Framework/Versioning   | No puede existir más de una versión PUBLISHED efectiva del mismo framework para el mismo effective window y scope salvo policy explícita de coexistencia.         |
| BR-EC12-013 | Framework/Versioning   | Los pesos de dimensiones de un framework publicado deben sumar 1.000000 dentro de tolerancia definida y no pueden ser negativos.                                  |
| BR-EC12-014 | Framework/Versioning   | Toda QualityDimension publicada debe tener código estable, definición, owner y método de agregación o declarar explícitamente que no es scoreable.                |
| BR-EC12-015 | Framework/Versioning   | Un ControlVersion PUBLISHED debe pinnear framework/control identity, severity, test method, evidence requirements, applicability y frequency.                     |
| BR-EC12-016 | Framework/Versioning   | Un control retirado no puede desaparecer de revisiones históricas ni de attestations previamente emitidas.                                                        |
| BR-EC12-017 | Framework/Versioning   | Cambiar el método de test o evidencia mínima de un control requiere nueva ControlVersion, no PATCH sobre versión publicada.                                       |
| BR-EC12-018 | Framework/Versioning   | Una versión DRAFT puede editarse solo con If-Match válido y permisos de design author; no se permite last-write-wins.                                             |
| BR-EC12-019 | Framework/Versioning   | La publicación de framework/control exige validation report sin issues P0 y approval receipt bajo SoD.                                                            |
| BR-EC12-020 | Framework/Versioning   | Los códigos de framework, dimension y control se vuelven inmutables cuando existe historia publicada asociada.                                                    |
| BR-EC12-021 | Review/Assessment      | QualityReviewCycle debe pinnear exactamente una QualityFrameworkVersion publicada y un periodo/watermark explícito.                                               |
| BR-EC12-022 | Review/Assessment      | Un ReviewScope debe declarar scope_type y scope_ref compatibles; no se permite scope ambiguo o multi-tenant.                                                      |
| BR-EC12-023 | Review/Assessment      | EVIDENCE_FROZEN prohíbe agregar/quitar scope o cambiar watermark sin re-open gobernado y reason code.                                                             |
| BR-EC12-024 | Review/Assessment      | ControlAssessment solo puede usar ControlVersion aplicable al scope y vigente según el framework pinneado.                                                        |
| BR-EC12-025 | Review/Assessment      | Assessment result debe ser PASS, PARTIAL, FAIL o NOT_APPLICABLE; NOT_ASSESSED no es resultado terminal.                                                           |
| BR-EC12-026 | Review/Assessment      | NOT_APPLICABLE requiere rule/policy, rationale y evidence suficiente; no puede usarse para evitar un FAIL sin justificación.                                      |
| BR-EC12-027 | Review/Assessment      | PASS requiere EvidenceSufficiencyPolicy satisfecha para todos los evidence requirements mandatory del control.                                                    |
| BR-EC12-028 | Review/Assessment      | Assessment LOCKED es inmutable; corrección posterior crea amendment/superseding assessment con lineage.                                                           |
| BR-EC12-029 | Review/Assessment      | Un reviewer no puede aprobar su propia evidence submission cuando el control exige independent assurance.                                                         |
| BR-EC12-030 | Review/Assessment      | Cerrar ReviewCycle exige todos los controles mandatory en estado terminal o waiver/accepted-risk válido y explícito.                                              |
| BR-EC12-031 | Evidence/Assurance     | ControlEvidenceReceipt es append-only; UPDATE/DELETE físico debe ser bloqueado por trigger salvo mantenimiento excepcional auditado fuera de runtime.             |
| BR-EC12-032 | Evidence/Assurance     | Evidence receipt debe incluir artifact_ref o source_event_ref/dataset_ref, content_hash cuando corresponda, classification y collected_at.                        |
| BR-EC12-033 | Evidence/Assurance     | Evidence más antigua que max_age del EvidenceRequirement se considera STALE y no puede satisfacer automáticamente un control.                                     |
| BR-EC12-034 | Evidence/Assurance     | Un artifact_ref inexistente o no verificable deja la evidencia en UNAVAILABLE/PARTIAL, nunca en PASS silencioso.                                                  |
| BR-EC12-035 | Evidence/Assurance     | La evidencia clasificada RESTRICTED no puede mostrarse en scorecards; solo metadata autorizada y access receipt.                                                  |
| BR-EC12-036 | Evidence/Assurance     | AssuranceLevel SELF, REVIEWED e INDEPENDENT deben mapearse a requisitos de SoD y roles distintos.                                                                 |
| BR-EC12-037 | Evidence/Assurance     | Un evidence set usado para attestation o gate debe congelarse mediante watermark/hash set para reproducibilidad.                                                  |
| BR-EC12-038 | Evidence/Assurance     | La sustitución de un artefacto exige nuevo receipt; no se edita hash/content metadata del receipt histórico.                                                      |
| BR-EC12-039 | Evidence/Assurance     | La evidencia generada por IA no reemplaza evidence primaria; debe identificarse como derived y conservar ai_run_ref.                                              |
| BR-EC12-040 | Evidence/Assurance     | El Evidence Pack debe poder reconstruirse sin acceso directo a tablas internas de módulos upstream, usando refs/contracts autorizados.                            |
| BR-EC12-041 | Compliance/Waiver      | ComplianceBinding debe pinnear obligation_ref + obligation_version_ref + effective dates y su aplicabilidad a scopes EC.                                          |
| BR-EC12-042 | Compliance/Waiver      | Cambiar obligation_version_ref marca bindings/attestations previos como potencialmente STALE mediante drift detection; no los reescribe.                          |
| BR-EC12-043 | Compliance/Waiver      | ComplianceAttestation APPROVED requiere reviewer, approver si policy exige SoD, evidence set, result, as_of y expires_at cuando aplique.                          |
| BR-EC12-044 | Compliance/Waiver      | Una attestation expirada no puede presentarse como vigente; UI/API debe distinguir EXPIRED de NON_COMPLIANT.                                                      |
| BR-EC12-045 | Compliance/Waiver      | Waiver APPROVED requiere scope preciso, control/obligation afectado, razón, risk statement, residual risk, compensating controls y expires_at.                    |
| BR-EC12-046 | Compliance/Waiver      | Un waiver no puede extenderse modificando expires_at en place; extensión crea nueva decisión/version con nueva aprobación.                                        |
| BR-EC12-047 | Compliance/Waiver      | Waiver vencido o revocado deja de satisfacer un control de inmediato a partir de effective timestamp.                                                             |
| BR-EC12-048 | Compliance/Waiver      | Un control regulatorio marcado non-waivable por policy no puede tener ExceptionWaiver activo.                                                                     |
| BR-EC12-049 | Compliance/Waiver      | Accepted risk no equivale a PASS y debe permanecer visible en scorecards/evidence packs según audience policy.                                                    |
| BR-EC12-050 | Compliance/Waiver      | Exportar compliance evidence fuera de tenant/institution scope exige policy, purpose, reason, step-up y audit receipt.                                            |
| BR-EC12-051 | Nonconformity/CAPA     | Nonconformity debe referenciar source assessment/alert/gate o reason de creación manual y conservar detection timestamp.                                          |
| BR-EC12-052 | Nonconformity/CAPA     | Severity se calcula o valida por policy; downgrade manual exige reason, approver y audit evidence.                                                                |
| BR-EC12-053 | Nonconformity/CAPA     | CRITICAL nonconformity no puede cerrarse sin CAPA y effectiveness verification salvo VOID probado.                                                                |
| BR-EC12-054 | Nonconformity/CAPA     | CAPAPlan debe declarar root-cause hypothesis/analysis ref, corrective strategy, preventive strategy cuando aplique, owner y target date.                          |
| BR-EC12-055 | Nonconformity/CAPA     | CorrectiveAction VERIFIED requiere completion evidence y verifier distinto del assignee si SoD lo exige.                                                          |
| BR-EC12-056 | Nonconformity/CAPA     | Completar todas las acciones no cierra automáticamente el CAPA; debe existir effectiveness result EFFECTIVE/INEFFECTIVE.                                          |
| BR-EC12-057 | Nonconformity/CAPA     | Un CAPA INEFFECTIVE debe reabrir/escalar la no conformidad o crear remediation iteration según policy.                                                            |
| BR-EC12-058 | Nonconformity/CAPA     | Cambios ejecutados en módulos upstream deben registrarse mediante external change receipt/ref; EC-12 no modifica sus tablas.                                      |
| BR-EC12-059 | Nonconformity/CAPA     | No conformidades duplicadas para el mismo root cause/scope pueden vincularse, pero nunca fusionarse destructivamente perdiendo lineage.                           |
| BR-EC12-060 | Nonconformity/CAPA     | Overdue CAPA/action debe generar alert idempotente y permanecer visible hasta resolution/waiver válido.                                                           |
| BR-EC12-061 | Improvement            | ImprovementInitiative debe declarar problema/oportunidad, hipótesis, owner, expected benefit y source signals.                                                    |
| BR-EC12-062 | Improvement            | Una iniciativa no conformidad-mandatory no puede usarse para esconder un FAIL; debe coexistir con la nonconformity correspondiente.                               |
| BR-EC12-063 | Improvement            | ImprovementExperiment RUNNING congela baseline, target, scope, metric definitions y measurement horizon.                                                          |
| BR-EC12-064 | Improvement            | ADOPT exige resultado medido contra baseline/target y rationale; “se implementó” no es criterio de éxito.                                                         |
| BR-EC12-065 | Improvement            | REJECT conserva findings y learnings; no se borra el experimento fallido.                                                                                         |
| BR-EC12-066 | Improvement            | Cambiar el indicador primario durante el experimento requiere nueva experiment version o ABORT + redesign.                                                        |
| BR-EC12-067 | Improvement            | Una iniciativa puede depender de cambios cross-context, pero su estado no puede suponer success antes de recibir completion receipt del owner.                    |
| BR-EC12-068 | Improvement            | Prioritization debe considerar severity/risk, reach, cost/effort ref y strategic alignment; la fórmula debe estar versionada si se automatiza.                    |
| BR-EC12-069 | Improvement            | Beneficios no monetarios y monetarios no se mezclan en un único score sin unidad/normalización explícita.                                                         |
| BR-EC12-070 | Improvement            | La institucionalización de una mejora debe producir control/framework/config change refs cuando corresponda, cerrando el learning loop.                           |
| BR-EC12-071 | Indicators/Snapshots   | IndicatorDefinition ACTIVE debe declarar grain, unit, direction, window, source dataset contract, formula DSL version y missing-data policy.                      |
| BR-EC12-072 | Indicators/Snapshots   | Formula contract no acepta SQL arbitrario ni scripts enviados desde UI; solo DSL/refs validadas y versionadas.                                                    |
| BR-EC12-073 | Indicators/Snapshots   | IndicatorSnapshot debe pinnear indicator_version, dataset_ref/version, input_watermark, calculator_version, as_of y content_hash.                                 |
| BR-EC12-074 | Indicators/Snapshots   | NO_DATA, ZERO, VALUE, STALE, PARTIAL, UNAVAILABLE, SUPPRESSED y NOT_APPLICABLE son estados distintos y deben persistirse/transportarse explícitamente.            |
| BR-EC12-075 | Indicators/Snapshots   | Comparar snapshots con indicator versions no comparables debe marcar comparability_state y evitar trend engañoso.                                                 |
| BR-EC12-076 | Indicators/Snapshots   | IndicatorThreshold debe tener bands no solapadas o reglas de precedencia explícitas; DB valida rangos básicos.                                                    |
| BR-EC12-077 | Indicators/Snapshots   | PortfolioHealthSnapshot solo agrega dimensiones con weight coverage suficiente y política explícita para missing/NA.                                              |
| BR-EC12-078 | Indicators/Snapshots   | Los pesos usados para health score deben pinnearse al framework version; no se toman del “valor actual” al reconstruir historia.                                  |
| BR-EC12-079 | Indicators/Snapshots   | QualityScorecardSnapshot APPROVED es inmutable; una corrección crea nueva snapshot con supersedes_ref.                                                            |
| BR-EC12-080 | Indicators/Snapshots   | Un snapshot no puede reportar freshness superior a la de su input más antiguo relevante; freshness se deriva conservadoramente.                                   |
| BR-EC12-081 | Privacy/Security       | PII no debe copiarse a EC-12 salvo necesidad explícita; reviewer/owner se representan por subject_ref y datos de display se resuelven on demand.                  |
| BR-EC12-082 | Privacy/Security       | No se permite ranking individual de docentes/participantes como quality KPI sin purpose/policy y Source of Truth autorizado.                                      |
| BR-EC12-083 | Privacy/Security       | Field-level access debe ocultar rationale/evidence sensible según classification y role/purpose.                                                                  |
| BR-EC12-084 | Privacy/Security       | Exports de scorecard/evidence pack deben registrar requester, purpose, reason, policy version, artifact_ref y content_hash.                                       |
| BR-EC12-085 | Privacy/Security       | Acciones de publish, approve attestation, approve waiver, close CRITICAL nonconformity y issue gate decision pueden exigir MFA/step-up.                           |
| BR-EC12-086 | Privacy/Security       | SoD debe impedir que el mismo actor cree y apruebe una excepción cuando policy lo exige.                                                                          |
| BR-EC12-087 | Privacy/Security       | El API debe prevenir IDOR incluso cuando IDs UUID son válidos; autorización se evalúa sobre resource scope y tenant.                                              |
| BR-EC12-088 | Privacy/Security       | Logs/traces/metrics no pueden incluir evidence contents, legal texts completos ni subject identifiers como labels de alta cardinalidad.                           |
| BR-EC12-089 | Privacy/Security       | Webhook/event consumers deben validar signature/schema/version y deduplicar message_id antes de efecto de negocio.                                                |
| BR-EC12-090 | Privacy/Security       | Bulk export debe aplicar purpose, row/field limits, watermark y secure artifact handling; no stream irrestricto de tablas.                                        |
| BR-EC12-091 | Integration/Resilience | Comando con Idempotency-Key repetido y mismo request_hash devuelve mismo resultado lógico; payload distinto devuelve 409 IDEMPOTENCY_KEY_REUSED.                  |
| BR-EC12-092 | Integration/Resilience | Idempotency IN_PROGRESS debe tener owner, lease_until, updated_at y recovery; no puede bloquear eternamente tras crash.                                           |
| BR-EC12-093 | Integration/Resilience | Outbox dispatcher multi-instancia usa claim/lease y FOR UPDATE SKIP LOCKED o patrón equivalente.                                                                  |
| BR-EC12-094 | Integration/Resilience | Inbox deduplica por message_id + consumer_code; consumidores deben ser idempotentes ante replay.                                                                  |
| BR-EC12-095 | Integration/Resilience | No se promete exactly-once distribuido; side effects remotos deben soportar reconciliation y dedup keys.                                                          |
| BR-EC12-096 | Integration/Resilience | Timeout después de request remoto con posible efecto entra UNKNOWN_EFFECT; no se hace blind retry.                                                                |
| BR-EC12-097 | Integration/Resilience | Circuit breaker abierto debe producir UNAVAILABLE/STALE/PARTIAL según capability, no datos fabricados.                                                            |
| BR-EC12-098 | Integration/Resilience | Una dependencia de analytics caída no autoriza recalcular indicadores con una fórmula alternativa no versionada.                                                  |
| BR-EC12-099 | Integration/Resilience | Reconciliation debe generar receipt con observed remote state, decision y correlation/causation lineage.                                                          |
| BR-EC12-100 | Integration/Resilience | OperationStatus 202 debe permanecer consultable hasta estado terminal/reconciled según retention policy.                                                          |
| BR-EC12-101 | AI/Governance          | Toda IA se invoca mediante CT-12; ningún adapter EC-12 contiene SDK directo de proveedor externo.                                                                 |
| BR-EC12-102 | AI/Governance          | AI output debe guardar ai_run_ref, model_ref, template_ref, eval_ref, grounding_refs, confidence, reviewer y outcome.                                             |
| BR-EC12-103 | AI/Governance          | IA puede proponer root-cause hypotheses, nunca declarar causa como hecho sin validación humana/evidence.                                                          |
| BR-EC12-104 | AI/Governance          | IA puede resumir evidence autorizada, pero no sustituye el evidence set ni el assessment signed.                                                                  |
| BR-EC12-105 | AI/Governance          | IA no puede aprobar framework/control, compliance attestation, waiver, quality gate ni cierre de nonconformity.                                                   |
| BR-EC12-106 | AI/Governance          | Anomaly detection debe distinguir señal estadística de policy breach; una anomalía no crea FAIL automáticamente.                                                  |
| BR-EC12-107 | AI/Governance          | Prompts/grounding no pueden incluir datos fuera de purpose/classification autorizados; adapter debe minimizar antes de CT-12.                                     |
| BR-EC12-108 | AI/Governance          | AI eval suite debe medir leakage, hallucination, unsupported attribution, bias y false-positive alerting antes de enablement.                                     |
| BR-EC12-109 | AI/Governance          | Un cambio de modelo/template relevante invalida comparabilidad de outputs analíticos IA salvo eval/compatibility approval.                                        |
| BR-EC12-110 | AI/Governance          | Cuando CT-12 está unavailable, procesos normativos críticos siguen por camino manual; AI absence nunca bloquea compliance essential.                              |
| BR-EC12-111 | Migration/Release      | Migración legacy sigue Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → Receipt → Reconcile → Certify.                               |
| BR-EC12-112 | Migration/Release      | No se permiten INSERT directos a tablas finales EC-12 como estrategia normal de migración.                                                                        |
| BR-EC12-113 | Migration/Release      | Legacy assessments sin evidence verificable se importan con quality_state explícito y no se convierten en PASS por default.                                       |
| BR-EC12-114 | Migration/Release      | Legacy KPI snapshots deben pinnear método/fórmula histórica si es demostrable; de lo contrario se marcan NON_COMPARABLE.                                          |
| BR-EC12-115 | Migration/Release      | Legacy waivers sin expiry o approver suficiente requieren remediation/manual review antes de promover como ACTIVE.                                                |
| BR-EC12-116 | Migration/Release      | Flyway sigue expand → deploy compatible → backfill → switch → contract con N/N-1 durante rollout.                                                                 |
| BR-EC12-117 | Migration/Release      | Un cambio destructivo no puede desplegarse en el mismo release que elimina compatibilidad con pods N-1.                                                           |
| BR-EC12-118 | Migration/Release      | OpenAPI/AsyncAPI breaking changes requieren compatibility gate y versioning explícito.                                                                            |
| BR-EC12-119 | Migration/Release      | Rollback destructivo de DB no es estrategia normal; se prefiere roll-forward y feature flags cuando aplique.                                                      |
| BR-EC12-120 | Migration/Release      | Release certification exige RLS/tenant tests, threat model, performance, observability, runbooks, UAT y evidence G1-G10.                                          |
| BR-EC12-121 | Operations/QualityDebt | QualityAlert se deduplica por tenant, signal type, scope y active window para evitar alert storms.                                                                |
| BR-EC12-122 | Operations/QualityDebt | Alerts no resueltas después de SLA se escalan por policy; escalation no cambia assessment result por sí sola.                                                     |
| BR-EC12-123 | Operations/QualityDebt | Quality debt aceptada debe tener owner, scope, severity, due date/expiry y vínculo a waiver/nonconformity; no puede existir como nota libre invisible.            |
| BR-EC12-124 | Operations/QualityDebt | Quality debt vencida sin remediación debe regresar a estado de riesgo/no conformidad visible y generar alert.                                                     |
| BR-EC12-125 | Operations/QualityDebt | Runbook execution debe registrar operator, correlation id, start/end, decision y receipts cuando modifique estado.                                                |
| BR-EC12-126 | Operations/QualityDebt | Reconciliation backlog, outbox age, stale assessments y overdue CAPA deben formar parte de operational SLI/KPI.                                                   |
| BR-EC12-127 | Operations/QualityDebt | Backups y restore tests deben validar que snapshots, lineage, hashes y RLS policies se recuperan consistentemente.                                                |
| BR-EC12-128 | Operations/QualityDebt | Data retention/disposition no puede destruir evidencia aún sujeta a legal hold, active attestation o investigation policy.                                        |
| BR-EC12-129 | Operations/QualityDebt | Cuando un input upstream cambia después de review freeze, EC-12 debe detectar drift y marcar impacted decisions STALE según policy.                               |
| BR-EC12-130 | Operations/QualityDebt | Producción no se certifica mientras exista P0/P1 de calidad técnica del módulo sin accepted risk formal y evidence.                                               |

Catálogo total: 130 reglas. Cada BR debe mapearse al menos a un test, constraint/policy o evidencia de UAT; no se consideran requisitos narrativos decorativos.

# 10. Casos de uso UC-EC12

| **ID**      | **Caso de uso**                                 | **Actor principal** | **Autorización base**                                                                                                       |
|-------------|-------------------------------------------------|---------------------|-----------------------------------------------------------------------------------------------------------------------------|
| UC-EC12-001 | Crear QualityFramework                          | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-002 | Crear FrameworkVersion                          | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-003 | Agregar dimensión                               | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-004 | Configurar pesos                                | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-005 | Validar FrameworkVersion                        | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-006 | Enviar framework a revisión                     | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-007 | Aprobar framework                               | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-008 | Publicar framework                              | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-009 | Superseder framework                            | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-010 | Void framework version                          | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-011 | Crear QualityControl                            | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-012 | Crear ControlVersion                            | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-013 | Configurar EvidenceRequirement                  | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-014 | Validar ControlVersion                          | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-015 | Aprobar control                                 | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-016 | Publicar control                                | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-017 | Retirar control                                 | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-018 | Crear ComplianceBinding                         | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-019 | Actualizar binding por nueva obligation version | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-020 | Detectar regulatory drift                       | Quality Manager     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-021 | Crear ReviewCycle                               | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-022 | Agregar ReviewScope                             | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-023 | Planificar revisión                             | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-024 | Iniciar revisión                                | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-025 | Recolectar evidence receipt                     | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-026 | Reemplazar evidencia por nuevo receipt          | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-027 | Evaluar control                                 | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-028 | Marcar NOT_APPLICABLE                           | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-029 | Solicitar revisión independiente                | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-030 | Lock assessment                                 | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-031 | Freeze evidence                                 | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-032 | Reabrir review gobernado                        | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-033 | Cerrar review cycle                             | Quality Reviewer    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-034 | Crear Nonconformity                             | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-035 | Triage nonconformity                            | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-036 | Cambiar severity gobernado                      | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-037 | Crear CAPA Plan                                 | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-038 | Aprobar CAPA                                    | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-039 | Crear CorrectiveAction                          | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-040 | Asignar action                                  | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-041 | Registrar completion evidence                   | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-042 | Verificar action                                | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-043 | Registrar effectiveness verification            | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-044 | Cerrar nonconformity                            | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-045 | Aceptar riesgo autorizado                       | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-046 | Reabrir nonconformity                           | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-047 | Crear ImprovementInitiative                     | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-048 | Priorizar initiative                            | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-049 | Crear experiment                                | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-050 | Congelar baseline                               | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-051 | Iniciar experiment                              | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-052 | Registrar observation                           | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-053 | Concluir experiment                             | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-054 | Adoptar mejora                                  | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-055 | Rechazar mejora                                 | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-056 | Institucionalizar mejora                        | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-057 | Cancelar initiative                             | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-058 | Crear IndicatorDefinition                       | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-059 | Crear IndicatorThreshold                        | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-060 | Aprobar indicator                               | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-061 | Activar indicator                               | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-062 | Retirar indicator                               | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-063 | Solicitar IndicatorSnapshot                     | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-064 | Reconciliar snapshot                            | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-065 | Comparar snapshots                              | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-066 | Construir PortfolioHealthSnapshot               | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-067 | Construir QualityScorecard                      | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-068 | Aprobar scorecard                               | Quality Analyst     | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-069 | Publicar scorecard                              | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-070 | Superseder scorecard                            | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-071 | Crear ComplianceAttestation                     | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-072 | Enviar attestation                              | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-073 | Aprobar attestation                             | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-074 | Rechazar attestation                            | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-075 | Expirar attestation                             | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-076 | Revocar attestation                             | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-077 | Crear waiver request                            | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-078 | Aprobar waiver                                  | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-079 | Rechazar waiver                                 | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-080 | Revocar waiver                                  | Compliance Officer  | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-081 | Expirar waiver                                  | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-082 | Consultar waiver coverage                       | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-083 | Crear QualityAlert                              | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-084 | Acknowledge alert                               | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-085 | Investigar alert                                | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-086 | Resolver alert                                  | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-087 | Dismiss alert                                   | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-088 | Solicitar QualityGateAssessment                 | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-089 | Evaluar gate                                    | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-090 | Emitir PASS                                     | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-091 | Emitir CONDITIONAL                              | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-092 | Emitir FAIL                                     | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-093 | Superseder gate decision                        | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-094 | Exportar Evidence Pack                          | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-095 | Exportar Quality Scorecard                      | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-096 | Solicitar IA anomaly analysis                   | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-097 | Solicitar IA root-cause assist                  | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-098 | Revisar IA insight                              | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-099 | Migrar legacy quality records                   | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-100 | Reconciliar evento duplicado                    | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-101 | Recuperar idempotency lease                     | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-102 | Consultar OperationStatus                       | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |
| UC-EC12-103 | Ejecutar retention/disposition                  | Quality Operator    | RBAC + ABAC + tenant scope; step-up/SoD cuando la acción sea approval, waiver, attestation, CRITICAL close o gate terminal. |

## 10.1 Casos críticos desarrollados

### UC-EC12-008 — Publicar framework

| **Elemento**                   | **Detalle**                                                                                            |
|--------------------------------|--------------------------------------------------------------------------------------------------------|
| Actor                          | Quality Manager + Approver                                                                             |
| Trigger                        | Command/intención explícita                                                                            |
| Precondiciones                 | FrameworkVersion IN_REVIEW/APPROVED, validation green, no overlapping effective version                |
| Autorización                   | If-Match + step-up + SoD                                                                               |
| Happy Path                     | Lock root → validate weights/control pins → create publication receipt/hash → state PUBLISHED → outbox |
| Alternativas/errores           | Validation fail; stale ETag; approver same actor denied; dependency unavailable                        |
| Idempotencia                   | Idempotency-Key durable                                                                                |
| Concurrencia                   | 412 on revision mismatch                                                                               |
| Side Effects/Auditoría/Eventos | FrameworkVersionPublished event, audit/evidence pack                                                   |
| Postcondición                  | Framework immutable and new ETag                                                                       |

### UC-EC12-023 — Planificar revisión

| **Elemento**                   | **Detalle**                                                                    |
|--------------------------------|--------------------------------------------------------------------------------|
| Actor                          | Quality Manager                                                                |
| Trigger                        | Command/intención explícita                                                    |
| Precondiciones                 | Framework PUBLISHED; scopes resolvable                                         |
| Autorización                   | RBAC/ABAC                                                                      |
| Happy Path                     | Create review → pin framework → add scopes → assign roles → schedule via CT-13 |
| Alternativas/errores           | Scope invalid; cross-tenant ref; schedule UNKNOWN_EFFECT                       |
| Idempotencia                   | Durable key                                                                    |
| Concurrencia                   | Root revision                                                                  |
| Side Effects/Auditoría/Eventos | ReviewPlanned + scheduling receipt                                             |
| Postcondición                  | PLANNED                                                                        |

### UC-EC12-025 — Recolectar evidence receipt

| **Elemento**                   | **Detalle**                                                                                 |
|--------------------------------|---------------------------------------------------------------------------------------------|
| Actor                          | Evidence Collector                                                                          |
| Trigger                        | Command/intención explícita                                                                 |
| Precondiciones                 | Review IN_PROGRESS; requirement applicable                                                  |
| Autorización                   | Purpose + classification                                                                    |
| Happy Path                     | Resolve CT-05 artifact → verify hash/classification → append receipt → bump review revision |
| Alternativas/errores           | Artifact unavailable; stale; hash mismatch                                                  |
| Idempotencia                   | Durable key per requirement/artifact                                                        |
| Concurrencia                   | If-Match on review                                                                          |
| Side Effects/Auditoría/Eventos | EvidenceReceiptRecorded                                                                     |
| Postcondición                  | Receipt append-only                                                                         |

### UC-EC12-027 — Evaluar control

| **Elemento**                   | **Detalle**                                                                             |
|--------------------------------|-----------------------------------------------------------------------------------------|
| Actor                          | Quality Reviewer                                                                        |
| Trigger                        | Command/intención explícita                                                             |
| Precondiciones                 | Applicable ControlVersion; evidence set resolved                                        |
| Autorización                   | Assurance role + SoD                                                                    |
| Happy Path                     | Evaluate sufficiency → set result/rationale → calculator/policy refs → READY_FOR_REVIEW |
| Alternativas/errores           | Evidence insufficient; stale; waiver active; NA unsupported                             |
| Idempotencia                   | Command idempotent                                                                      |
| Concurrencia                   | If-Match                                                                                |
| Side Effects/Auditoría/Eventos | ControlAssessmentEvaluated                                                              |
| Postcondición                  | Result explicit                                                                         |

### UC-EC12-033 — Cerrar review cycle

| **Elemento**                   | **Detalle**                                                                      |
|--------------------------------|----------------------------------------------------------------------------------|
| Actor                          | Lead Reviewer                                                                    |
| Trigger                        | Command/intención explícita                                                      |
| Precondiciones                 | EVIDENCE_FROZEN/REVIEWED; terminal assessments                                   |
| Autorización                   | step-up                                                                          |
| Happy Path                     | Validate all mandatory controls/waivers → build summary → close receipt → outbox |
| Alternativas/errores           | Unassessed control; expired waiver; stale critical evidence                      |
| Idempotencia                   | Durable close key                                                                |
| Concurrencia                   | ETag                                                                             |
| Side Effects/Auditoría/Eventos | ReviewCycleClosed                                                                |
| Postcondición                  | CLOSED immutable summary                                                         |

### UC-EC12-037 — Crear CAPA Plan

| **Elemento**                   | **Detalle**                                                                           |
|--------------------------------|---------------------------------------------------------------------------------------|
| Actor                          | Quality Manager                                                                       |
| Trigger                        | Command/intención explícita                                                           |
| Precondiciones                 | Nonconformity TRIAGED                                                                 |
| Autorización                   | RBAC + scope                                                                          |
| Happy Path                     | Define root cause, actions, owners, target, effectiveness criteria → approve workflow |
| Alternativas/errores           | No root cause for critical; target invalid                                            |
| Idempotencia                   | Durable key                                                                           |
| Concurrencia                   | ETag NC root                                                                          |
| Side Effects/Auditoría/Eventos | CAPAPlanCreated                                                                       |
| Postcondición                  | ACTION_PLANNED                                                                        |

### UC-EC12-043 — Registrar effectiveness verification

| **Elemento**                   | **Detalle**                                                                   |
|--------------------------------|-------------------------------------------------------------------------------|
| Actor                          | Independent Reviewer                                                          |
| Trigger                        | Command/intención explícita                                                   |
| Precondiciones                 | CAPA VERIFYING; actions terminal                                              |
| Autorización                   | SoD + step-up for critical                                                    |
| Happy Path                     | Resolve metric/evidence → compare criterion → EFFECTIVE/INEFFECTIVE → receipt |
| Alternativas/errores           | Data unavailable; horizon not reached; conflict                               |
| Idempotencia                   | Durable key                                                                   |
| Concurrencia                   | ETag                                                                          |
| Side Effects/Auditoría/Eventos | CAPAEffectivenessVerified                                                     |
| Postcondición                  | Explicit result                                                               |

### UC-EC12-053 — Adoptar mejora

| **Elemento**                   | **Detalle**                                                                           |
|--------------------------------|---------------------------------------------------------------------------------------|
| Actor                          | Quality Board                                                                         |
| Trigger                        | Command/intención explícita                                                           |
| Precondiciones                 | Experiment CONCLUDED; measurement complete                                            |
| Autorización                   | SoD where configured                                                                  |
| Happy Path                     | Review baseline/target/outcome → ADOPT → create upstream change/config refs if needed |
| Alternativas/errores           | Non-comparable metric; weak evidence → reject/extend                                  |
| Idempotencia                   | Durable key                                                                           |
| Concurrencia                   | ETag                                                                                  |
| Side Effects/Auditoría/Eventos | ImprovementAdopted                                                                    |
| Postcondición                  | Learning captured                                                                     |

### UC-EC12-061 — Solicitar IndicatorSnapshot

| **Elemento**                   | **Detalle**                                                                          |
|--------------------------------|--------------------------------------------------------------------------------------|
| Actor                          | Quality Analyst                                                                      |
| Trigger                        | Command/intención explícita                                                          |
| Precondiciones                 | Indicator ACTIVE; dataset contract available                                         |
| Autorización                   | Purpose/scope                                                                        |
| Happy Path                     | Submit async job → OperationStatus → CT-11 data watermark → calculate → hash → READY |
| Alternativas/errores           | CT-11 unavailable; partial data; formula version mismatch                            |
| Idempotencia                   | Durable key                                                                          |
| Concurrencia                   | Immutable definition version                                                         |
| Side Effects/Auditoría/Eventos | IndicatorSnapshotReady                                                               |
| Postcondición                  | Snapshot reproducible                                                                |

### UC-EC12-064 — Construir PortfolioHealthSnapshot

| **Elemento**                   | **Detalle**                                                                                        |
|--------------------------------|----------------------------------------------------------------------------------------------------|
| Actor                          | Quality Analyst                                                                                    |
| Trigger                        | Command/intención explícita                                                                        |
| Precondiciones                 | Indicator snapshots available/comparable                                                           |
| Autorización                   | Purpose/scope                                                                                      |
| Happy Path                     | Resolve framework weights → missing-data policy → normalize → calculate dimensions → health → hash |
| Alternativas/errores           | Coverage below minimum; stale inputs; non-comparable versions                                      |
| Idempotencia                   | Durable key                                                                                        |
| Concurrencia                   | Version pinned                                                                                     |
| Side Effects/Auditoría/Eventos | PortfolioHealthReady                                                                               |
| Postcondición                  | State/freshness explicit                                                                           |

### UC-EC12-070 — Aprobar attestation

| **Elemento**                   | **Detalle**                                                                |
|--------------------------------|----------------------------------------------------------------------------|
| Actor                          | Compliance Officer + Approver                                              |
| Trigger                        | Command/intención explícita                                                |
| Precondiciones                 | SUBMITTED; obligation version valid; evidence sufficient                   |
| Autorización                   | step-up + SoD                                                              |
| Happy Path                     | Validate binding → evidence freeze → sign → expires_at → APPROVED → outbox |
| Alternativas/errores           | Drift; expired evidence; non-waivable FAIL                                 |
| Idempotencia                   | Durable key                                                                |
| Concurrencia                   | ETag                                                                       |
| Side Effects/Auditoría/Eventos | ComplianceAttestationApproved                                              |
| Postcondición                  | Immutable attestation                                                      |

### UC-EC12-076 — Aprobar waiver

| **Elemento**                   | **Detalle**                                                                      |
|--------------------------------|----------------------------------------------------------------------------------|
| Actor                          | Authorized Risk/Quality Approver                                                 |
| Trigger                        | Command/intención explícita                                                      |
| Precondiciones                 | REQUESTED/IN_REVIEW; waivable control                                            |
| Autorización                   | step-up + SoD                                                                    |
| Happy Path                     | Validate scope/risk/compensating controls/expiry → sign → ACTIVE schedule expiry |
| Alternativas/errores           | Non-waivable; expiry too long; missing compensating control                      |
| Idempotencia                   | Durable key                                                                      |
| Concurrencia                   | ETag                                                                             |
| Side Effects/Auditoría/Eventos | ExceptionWaiverApproved                                                          |
| Postcondición                  | Active until expiry/revoke                                                       |

### UC-EC12-086 — Solicitar QualityGateAssessment

| **Elemento**                   | **Detalle**                                                                    |
|--------------------------------|--------------------------------------------------------------------------------|
| Actor                          | Upstream module/Quality operator                                               |
| Trigger                        | Command/intención explícita                                                    |
| Precondiciones                 | Gate policy active; scope resolvable                                           |
| Autorización                   | Service auth + tenant scope                                                    |
| Happy Path                     | Create assessment → pin controls/watermark → evaluate → issue terminal receipt |
| Alternativas/errores           | Missing mandatory evidence → CONDITIONAL/FAIL                                  |
| Idempotencia                   | Idempotency by gate request id                                                 |
| Concurrencia                   | Revision                                                                       |
| Side Effects/Auditoría/Eventos | QualityGateDecisionIssued                                                      |
| Postcondición                  | Owner module receives receipt                                                  |

### UC-EC12-094 — Solicitar IA root-cause assist

| **Elemento**                   | **Detalle**                                                     |
|--------------------------------|-----------------------------------------------------------------|
| Actor                          | Quality Analyst                                                 |
| Trigger                        | Command/intención explícita                                     |
| Precondiciones                 | Authorized evidence/metrics; CT-12 enabled                      |
| Autorización                   | Purpose + AI policy                                             |
| Happy Path                     | Minimize inputs → CT-12 run → store provenance → analyst review |
| Alternativas/errores           | AI unavailable; confidence low; unsupported claim               |
| Idempotencia                   | Idempotent run request                                          |
| Concurrencia                   | N/A business state                                              |
| Side Effects/Auditoría/Eventos | AIInsightReviewed                                               |
| Postcondición                  | No automatic decision                                           |

### UC-EC12-095 — Migrar legacy quality records

| **Elemento**                   | **Detalle**                                                                     |
|--------------------------------|---------------------------------------------------------------------------------|
| Actor                          | Migration Operator                                                              |
| Trigger                        | Command/intención explícita                                                     |
| Precondiciones                 | CT-16 mapping approved                                                          |
| Autorización                   | Migration role + tenant                                                         |
| Happy Path                     | Extract → normalize → dry-run → domain promote → receipts → reconcile → certify |
| Alternativas/errores           | Ambiguous source; no evidence; duplicate business key                           |
| Idempotencia                   | Migration idempotency                                                           |
| Concurrencia                   | Version aware                                                                   |
| Side Effects/Auditoría/Eventos | MigrationCertified                                                              |
| Postcondición                  | No direct final INSERT                                                          |

# 11. DER conceptual, lógico y físico

## 11.1 DER conceptual

```
QualityFramework --< QualityFrameworkVersion --< QualityDimension
QualityControl --< ControlVersion --< EvidenceRequirement
ComplianceBinding >-- ControlVersion
QualityReviewCycle --< ReviewScope
QualityReviewCycle --< ControlAssessment --< ControlEvidenceReceipt
Nonconformity --1 CAPAPlan --< CorrectiveAction
ImprovementInitiative --< ImprovementExperiment
IndicatorDefinition --< IndicatorThreshold
QualitySnapshot --< IndicatorSnapshot
QualitySnapshot --1 PortfolioHealthSnapshot
QualitySnapshot --1 QualityScorecardSnapshot
ComplianceAttestation >-- ComplianceBinding
ExceptionWaiver >-- ControlVersion
QualityAlert --> scope/control/indicator refs
QualityGateAssessment --> framework/control pins
```

## 11.2 DER lógico

Todas las relaciones internas usan claves compuestas (tenant_id, id). Las referencias a módulos externos, CT, IAM, autoridad normativa y datasets son EXT REF sin FK física. FrameworkVersion pinnea ControlVersion mediante bindings/refs lógicos versionados; ReviewCycle pinnea FrameworkVersion y cada ControlAssessment pinnea ControlVersion para evitar que una publicación futura cambie la interpretación histórica.

```
TENANT 1---N QUALITY_FRAMEWORK 1---N FRAMEWORK_VERSION 1---N DIMENSION
TENANT 1---N QUALITY_CONTROL 1---N CONTROL_VERSION 1---N EVIDENCE_REQUIREMENT
TENANT 1---N REVIEW_CYCLE 1---N REVIEW_SCOPE
REVIEW_CYCLE 1---N CONTROL_ASSESSMENT 1---N EVIDENCE_RECEIPT
NONCONFORMITY 1---0..1 CAPA_PLAN 1---N CORRECTIVE_ACTION
IMPROVEMENT_INITIATIVE 1---N IMPROVEMENT_EXPERIMENT
INDICATOR_DEFINITION 1---N INDICATOR_THRESHOLD
QUALITY_SNAPSHOT 1---N INDICATOR_SNAPSHOT
COMPLIANCE_BINDING 1---N COMPLIANCE_ATTESTATION
```

## 11.3 DER físico — reglas

- PK internas = (tenant_id, id).

- FK internas = (tenant_id, parent_id) → parent(tenant_id,id).

- No FK cross-context.

- RLS ENABLE + FORCE en toda tabla tenant-owned.

- Business keys tenant-aware y version-aware.

- Published/approved facts protegidos por triggers de inmutabilidad.

- Evidence receipts append-only.

- Partial unique indexes para “una attestation activa por binding/scope” y similares cuando corresponda.

- Checks para ranges, weights, windows, states, severities, expiry y result domains.

- Triggers/constraints defienden aggregate consistency incluso si Backend tiene un bug.

# 12. Modelo físico PostgreSQL tabla por tabla

## 12.1 ec12_quality_framework

QUÉ REPRESENTA — Identidad estable del marco de calidad EC. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                                            | **Ejemplo** |
|-----------------------|---------------------|----------|-------------------|-----------|------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id             | uuid                | NO       | —                 | PK\*      | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | 8a6…        |
| framework_id          | uuid                | NO       | gen_random_uuid() | PK        | Identificador del QualityFramework dentro del tenant; forma parte de la identidad del aggregate.           | ejemplo     |
| framework_code        | varchar(64)         | NO       | —                 | —         | Framework code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | EC-QF       |
| display_name          | varchar(240)        | NO       | —                 | —         | Display name. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| lifecycle_state       | varchar(24)         | NO       | —                 | —         | Lifecycle state. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| owner_scope_ref       | uuid                | NO       | —                 | EXT REF   | Owner scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| default_language_code | varchar(16)         | NO       | —                 | —         | Default language code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| created_by_subject    | uuid                | NO       | —                 | —         | Created by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| created_at            | timestamptz         | NO       | now()             | —         | Created at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| updated_at            | timestamptz         | NO       | now()             | —         | Updated at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| revision              | bigint              | NO       | 0                 | —         | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.         | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

framework_id — Propósito: Identificador del QualityFramework dentro del tenant; forma parte de la identidad del aggregate.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

framework_code — Propósito: framework code dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

display_name — Propósito: display name dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(240).

lifecycle_state — Propósito: lifecycle state dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

owner_scope_ref — Propósito: owner scope ref dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

default_language_code — Propósito: default language code dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(16).

created_by_subject — Propósito: created by subject dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

created_at — Propósito: created at dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

updated_at — Propósito: updated at dentro de ec12_quality_framework. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|----------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_quality_framework        | PK       | PRIMARY KEY (tenant_id,framework_id)                            | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_quality_framework_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_quality_framework_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_quality_framework_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_quality_framework       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec12_framework_version

QUÉ REPRESENTA — Snapshot publicable del marco de calidad. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                               | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|------------|---------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | 8a6…        |
| framework_version_id     | uuid                | NO       | gen_random_uuid() | PK         | Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.           | ejemplo     |
| framework_id             | uuid                | NO       | —                 | FK interna | Identificador del QualityFramework dentro del tenant; forma parte de la identidad del aggregate.              | ejemplo     |
| version_no               | integer             | NO       | —                 | —          | Version no. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| state                    | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ACTIVE      |
| title                    | varchar(240)        | NO       | —                 | —          | Title. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ejemplo     |
| effective_from           | timestamptz         | NO       | —                 | —          | Effective from. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| effective_to             | timestamptz         | SÍ       | —                 | —          | Effective to. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| scoring_method_code      | varchar(64)         | NO       | —                 | —          | Scoring method code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| missing_data_policy_code | varchar(64)         | NO       | —                 | —          | Missing data policy code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| minimum_coverage         | numeric(8           | NO       | —                 | —          | Minimum coverage. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| 6\)                      | text                | NO       | —                 | —          | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                       | ejemplo     |
| content_hash             | char(64)            | NO       | —                 | —          | SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.                   | a94f…       |
| previous_version_id      | uuid                | SÍ       | —                 | FK interna | Previous version id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| published_at             | timestamptz         | SÍ       | —                 | —          | Published at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| revision                 | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.            | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

framework_version_id — Propósito: Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

framework_id — Propósito: Identificador del QualityFramework dentro del tenant; forma parte de la identidad del aggregate.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

version_no — Propósito: version no dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

state — Propósito: state dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

title — Propósito: title dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(240).

effective_from — Propósito: effective from dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

effective_to — Propósito: effective to dentro de ec12_framework_version. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

scoring_method_code — Propósito: scoring method code dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

missing_data_policy_code — Propósito: missing data policy code dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

minimum_coverage — Propósito: minimum coverage dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(8.

6\) — Propósito: 6) dentro de ec12_framework_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

content_hash — Propósito: SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

previous_version_id — Propósito: previous version id dentro de ec12_framework_version. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

published_at — Propósito: published at dentro de ec12_framework_version. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|----------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_framework_version        | PK       | PRIMARY KEY (tenant_id,framework_version_id)                    | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_framework_version_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_framework_version_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_framework_version_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_framework_version       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec12_quality_dimension

QUÉ REPRESENTA — Dimensión versionada del framework y su peso. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                       | **Ejemplo** |
|----------------------|---------------------|----------|-------------------|------------|-------------------------------------------------------------------------------------------------------|-------------|
| tenant_id            | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | 8a6…        |
| dimension_id         | uuid                | NO       | gen_random_uuid() | PK         | Dimension id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| framework_version_id | uuid                | NO       | —                 | FK interna | Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.   | ejemplo     |
| dimension_code       | varchar(64)         | NO       | —                 | —          | Dimension code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | ejemplo     |
| display_name         | varchar(240)        | NO       | —                 | —          | Display name. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| description_text     | text                | NO       | —                 | —          | Description text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| weight               | numeric(10          | NO       | —                 | —          | Weight. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | 0.12500000  |
| 8\)                  | text                | NO       | —                 | —          | 8). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| scoreable            | boolean             | NO       | false             | —          | Scoreable. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| owner_scope_ref      | uuid                | NO       | —                 | EXT REF    | Owner scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| sequence_no          | integer             | NO       | —                 | —          | Sequence no. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| revision             | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.    | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

dimension_id — Propósito: dimension id dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

framework_version_id — Propósito: Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

dimension_code — Propósito: dimension code dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

display_name — Propósito: display name dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(240).

description_text — Propósito: description text dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

weight — Propósito: weight dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(10.

8\) — Propósito: 8) dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

scoreable — Propósito: scoreable dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: boolean.

owner_scope_ref — Propósito: owner scope ref dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

sequence_no — Propósito: sequence no dentro de ec12_quality_dimension. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|----------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_quality_dimension        | PK       | PRIMARY KEY (tenant_id,dimension_id)                            | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_quality_dimension_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_quality_dimension_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_quality_dimension_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_quality_dimension       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.4 ec12_quality_control

QUÉ REPRESENTA — Identidad estable de un control de calidad EC. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                                          | **Ejemplo** |
|---------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------------------------------|-------------|
| tenant_id           | uuid                | NO       | —                 | PK\*      | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | 8a6…        |
| control_id          | uuid                | NO       | gen_random_uuid() | PK        | Control id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| control_code        | varchar(64)         | NO       | —                 | —         | Control code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| control_family_code | varchar(64)         | NO       | —                 | —         | Control family code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| display_name        | varchar(240)        | NO       | —                 | —         | Display name. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| lifecycle_state     | varchar(24)         | NO       | —                 | —         | Lifecycle state. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| owner_scope_ref     | uuid                | NO       | —                 | EXT REF   | Owner scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| created_at          | timestamptz         | NO       | now()             | —         | Created at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| updated_at          | timestamptz         | NO       | now()             | —         | Updated at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| revision            | bigint              | NO       | 0                 | —         | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.       | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

control_id — Propósito: control id dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

control_code — Propósito: control code dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

control_family_code — Propósito: control family code dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

display_name — Propósito: display name dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(240).

lifecycle_state — Propósito: lifecycle state dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

owner_scope_ref — Propósito: owner scope ref dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

created_at — Propósito: created at dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

updated_at — Propósito: updated at dentro de ec12_quality_control. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**              | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|--------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_quality_control        | PK       | PRIMARY KEY (tenant_id,control_id)                              | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_quality_control_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_quality_control_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_quality_control_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_quality_control       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.5 ec12_control_version

QUÉ REPRESENTA — Versión publicada del objetivo, test, severidad y aplicabilidad de un control. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                             | **Ejemplo** |
|------------------------|---------------------|----------|-------------------|------------|-------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id              | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | 8a6…        |
| control_version_id     | uuid                | SÍ       | gen_random_uuid() | PK         | Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.        | ejemplo     |
| control_id             | uuid                | NO       | —                 | FK interna | Control id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| version_no             | integer             | NO       | —                 | —          | Version no. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| state                  | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                  | ACTIVE      |
| objective_text         | text                | NO       | —                 | —          | Objective text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| test_method_code       | varchar(80)         | NO       | —                 | —          | Test method code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| severity_code          | varchar(24)         | NO       | —                 | —          | Severity code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | HIGH        |
| frequency_code         | varchar(40)         | NO       | —                 | —          | Frequency code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| applicability_rule_ref | uuid                | NO       | —                 | EXT REF    | Applicability rule ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| dimension_code         | varchar(64)         | NO       | —                 | —          | Dimension code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| waivable               | boolean             | NO       | false             | —          | Waivable. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| effective_from         | timestamptz         | NO       | —                 | —          | Effective from. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| effective_to           | timestamptz         | SÍ       | —                 | —          | Effective to. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| content_hash           | char(64)            | NO       | —                 | —          | SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.                 | a94f…       |
| previous_version_id    | uuid                | SÍ       | —                 | FK interna | Previous version id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| revision               | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.          | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

control_version_id — Propósito: Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

control_id — Propósito: control id dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

version_no — Propósito: version no dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

state — Propósito: state dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

objective_text — Propósito: objective text dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

test_method_code — Propósito: test method code dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(80).

severity_code — Propósito: severity code dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

frequency_code — Propósito: frequency code dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

applicability_rule_ref — Propósito: applicability rule ref dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

dimension_code — Propósito: dimension code dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

waivable — Propósito: waivable dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: boolean.

effective_from — Propósito: effective from dentro de ec12_control_version. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

effective_to — Propósito: effective to dentro de ec12_control_version. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

content_hash — Propósito: SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

previous_version_id — Propósito: previous version id dentro de ec12_control_version. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**              | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|--------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_control_version        | PK       | PRIMARY KEY (tenant_id,control_version_id)                      | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_control_version_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_control_version_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_control_version_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_control_version       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec12_evidence_requirement

QUÉ REPRESENTA — Requisito versionado de evidencia para un ControlVersion. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                              | **Ejemplo** |
|-------------------------|---------------------|----------|-------------------|------------|--------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id               | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | 8a6…        |
| evidence_requirement_id | uuid                | NO       | gen_random_uuid() | PK         | Evidence requirement id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| control_version_id      | uuid                | SÍ       | —                 | FK interna | Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.         | ejemplo     |
| requirement_code        | varchar(64)         | NO       | —                 | —          | Requirement code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| evidence_type_code      | varchar(80)         | NO       | —                 | —          | Evidence type code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| mandatory               | boolean             | NO       | false             | —          | Mandatory. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| freshness_max_age_days  | integer             | NO       | —                 | —          | Freshness max age days. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| classification_code     | varchar(32)         | NO       | —                 | —          | Classification code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| hash_required           | boolean             | NO       | false             | —          | Hash required. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| minimum_count           | integer             | NO       | —                 | —          | Minimum count. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| sequence_no             | integer             | NO       | —                 | —          | Sequence no. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| revision                | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.           | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

evidence_requirement_id — Propósito: evidence requirement id dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

control_version_id — Propósito: Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

requirement_code — Propósito: requirement code dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

evidence_type_code — Propósito: evidence type code dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(80).

mandatory — Propósito: mandatory dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: boolean.

freshness_max_age_days — Propósito: freshness max age days dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

classification_code — Propósito: classification code dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

hash_required — Propósito: hash required dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: boolean.

minimum_count — Propósito: minimum count dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

sequence_no — Propósito: sequence no dentro de ec12_evidence_requirement. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_evidence_requirement        | PK       | PRIMARY KEY (tenant_id,evidence_requirement_id)                 | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_evidence_requirement_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_evidence_requirement_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_evidence_requirement_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_evidence_requirement       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.7 ec12_compliance_binding

QUÉ REPRESENTA — Binding entre obligación externa versionada y controles/scopes EC. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                             | **Ejemplo** |
|------------------------|---------------------|----------|-------------------|------------|-------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id              | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | 8a6…        |
| binding_id             | uuid                | SÍ       | gen_random_uuid() | PK         | Binding id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| binding_code           | varchar(64)         | NO       | —                 | —          | Binding code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| obligation_ref         | uuid                | NO       | —                 | EXT REF    | Obligation ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| obligation_version_ref | uuid                | NO       | —                 | EXT REF    | EXT REF a la versión autoritativa de una obligación externa/institucional; no tiene FK física local.        | ejemplo     |
| authority_ref          | uuid                | NO       | —                 | EXT REF    | Authority ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| control_version_id     | uuid                | SÍ       | —                 | FK interna | Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.        | ejemplo     |
| applicability_rule_ref | uuid                | NO       | —                 | EXT REF    | Applicability rule ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| scope_type             | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| effective_from         | timestamptz         | NO       | —                 | —          | Effective from. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| effective_to           | timestamptz         | SÍ       | —                 | —          | Effective to. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| non_waivable           | boolean             | NO       | false             | —          | Non waivable. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| state                  | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                  | ACTIVE      |
| revision               | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.          | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

binding_id — Propósito: binding id dentro de ec12_compliance_binding. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

binding_code — Propósito: binding code dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

obligation_ref — Propósito: obligation ref dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

obligation_version_ref — Propósito: EXT REF a la versión autoritativa de una obligación externa/institucional; no tiene FK física local.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

authority_ref — Propósito: authority ref dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

control_version_id — Propósito: Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

applicability_rule_ref — Propósito: applicability rule ref dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_type — Propósito: scope type dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

effective_from — Propósito: effective from dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

effective_to — Propósito: effective to dentro de ec12_compliance_binding. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

non_waivable — Propósito: non waivable dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: boolean.

state — Propósito: state dentro de ec12_compliance_binding. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-----------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_compliance_binding        | PK       | PRIMARY KEY (tenant_id,binding_id)                              | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_compliance_binding_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_compliance_binding_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_compliance_binding_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_compliance_binding       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.8 ec12_review_cycle

QUÉ REPRESENTA — Ciclo gobernado de revisión de calidad. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                           | **Ejemplo** |
|----------------------|---------------------|----------|-------------------|------------|-----------------------------------------------------------------------------------------------------------|-------------|
| tenant_id            | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | 8a6…        |
| review_cycle_id      | uuid                | SÍ       | gen_random_uuid() | PK         | Review cycle id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| review_code          | varchar(64)         | NO       | —                 | —          | Review code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| framework_version_id | uuid                | NO       | —                 | FK interna | Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.       | ejemplo     |
| review_type_code     | varchar(64)         | NO       | —                 | —          | Review type code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| period_start         | date                | NO       | —                 | —          | Period start. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| period_end           | date                | NO       | —                 | —          | Period end. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| evidence_watermark   | timestamptz         | NO       | —                 | —          | Instante hasta el cual se congelan los inputs considerados; garantiza reproducibilidad as-of.             | ejemplo     |
| state                | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ACTIVE      |
| owner_scope_ref      | uuid                | NO       | —                 | EXT REF    | Owner scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| lead_reviewer_ref    | uuid                | NO       | —                 | EXT REF    | Lead reviewer ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| assurance_level_code | varchar(32)         | NO       | —                 | —          | Assurance level code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| planned_at           | timestamptz         | NO       | —                 | —          | Planned at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| started_at           | timestamptz         | SÍ       | —                 | —          | Started at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| closed_at            | timestamptz         | SÍ       | —                 | —          | Closed at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| revision             | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.        | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_cycle_id — Propósito: review cycle id dentro de ec12_review_cycle. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_code — Propósito: review code dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

framework_version_id — Propósito: Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_type_code — Propósito: review type code dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

period_start — Propósito: period start dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

period_end — Propósito: period end dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

evidence_watermark — Propósito: Instante hasta el cual se congelan los inputs considerados; garantiza reproducibilidad as-of.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

state — Propósito: state dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

owner_scope_ref — Propósito: owner scope ref dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

lead_reviewer_ref — Propósito: lead reviewer ref dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

assurance_level_code — Propósito: assurance level code dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

planned_at — Propósito: planned at dentro de ec12_review_cycle. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

started_at — Propósito: started at dentro de ec12_review_cycle. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

closed_at — Propósito: closed at dentro de ec12_review_cycle. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**           | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-----------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_review_cycle        | PK       | PRIMARY KEY (tenant_id,review_cycle_id)                         | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_review_cycle_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_review_cycle_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_review_cycle_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_review_cycle       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.9 ec12_review_scope

QUÉ REPRESENTA — Scope concreto incluido en un ReviewCycle. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                                  | **Ejemplo** |
|-----------------------------|---------------------|----------|-------------------|------------|------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                   | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                   | 8a6…        |
| review_scope_id             | uuid                | SÍ       | gen_random_uuid() | PK         | Review scope id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| review_cycle_id             | uuid                | SÍ       | —                 | FK interna | Review cycle id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| scope_type                  | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                  | ejemplo     |
| scope_ref                   | uuid                | SÍ       | —                 | EXT REF    | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                   | ejemplo     |
| scope_label_snapshot        | varchar(240)        | NO       | —                 | —          | Scope label snapshot. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| source_version_ref          | uuid                | SÍ       | —                 | EXT REF    | Source version ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| applicability_snapshot_hash | char(64)            | NO       | —                 | —          | Applicability snapshot hash. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| included                    | boolean             | NO       | false             | —          | Included. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ejemplo     |
| exclusion_reason_code       | varchar(80)         | SÍ       | —                 | —          | Exclusion reason code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| revision                    | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.               | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_review_scope. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_scope_id — Propósito: review scope id dentro de ec12_review_scope. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_cycle_id — Propósito: review cycle id dentro de ec12_review_scope. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_type — Propósito: scope type dentro de ec12_review_scope. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_review_scope. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_label_snapshot — Propósito: scope label snapshot dentro de ec12_review_scope. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(240).

source_version_ref — Propósito: source version ref dentro de ec12_review_scope. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

applicability_snapshot_hash — Propósito: applicability snapshot hash dentro de ec12_review_scope. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

included — Propósito: included dentro de ec12_review_scope. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: boolean.

exclusion_reason_code — Propósito: exclusion reason code dentro de ec12_review_scope. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(80).

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**           | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-----------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_review_scope        | PK       | PRIMARY KEY (tenant_id,review_scope_id)                         | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_review_scope_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_review_scope_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_review_scope_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_review_scope       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec12_control_assessment

QUÉ REPRESENTA — Evaluación as-of de un ControlVersion dentro de ReviewCycle/Scope. Separa el estado del workflow del resultado normativo para impedir que IN_PROGRESS/READY_FOR_REVIEW se confundan con PASS/PARTIAL/FAIL. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                               | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|------------|---------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | 8a6…        |
| assessment_id            | uuid                | NO       | gen_random_uuid() | PK         | Assessment id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| review_cycle_id          | uuid                | SÍ       | —                 | FK interna | Review cycle id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| review_scope_id          | uuid                | SÍ       | —                 | FK interna | Review scope id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| control_version_id       | uuid                | SÍ       | —                 | FK interna | Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.          | ejemplo     |
| state                    | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ACTIVE      |
| result                   | varchar(24)         | NO       | —                 | —          | Result. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                   | PASS        |
| assurance_level_code     | varchar(32)         | NO       | —                 | —          | Assurance level code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| rationale_text           | text                | NO       | —                 | —          | Rationale text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| assessed_by_subject      | uuid                | NO       | —                 | —          | Assessed by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| reviewed_by_subject      | uuid                | SÍ       | —                 | —          | Reviewed by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| evidence_watermark       | timestamptz         | NO       | —                 | —          | Instante hasta el cual se congelan los inputs considerados; garantiza reproducibilidad as-of.                 | ejemplo     |
| policy_version_ref       | uuid                | NO       | —                 | EXT REF    | Policy version ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| assessed_at              | timestamptz         | NO       | —                 | —          | Assessed at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| locked_at                | timestamptz         | SÍ       | —                 | —          | Locked at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| supersedes_assessment_id | uuid                | SÍ       | —                 | FK interna | Supersedes assessment id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| content_hash             | char(64)            | NO       | —                 | —          | SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.                   | a94f…       |
| revision                 | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.            | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

assessment_id — Propósito: assessment id dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_cycle_id — Propósito: review cycle id dentro de ec12_control_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_scope_id — Propósito: review scope id dentro de ec12_control_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

control_version_id — Propósito: Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

state — Propósito: state dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

result — Propósito: result dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

assurance_level_code — Propósito: assurance level code dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

rationale_text — Propósito: rationale text dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

assessed_by_subject — Propósito: assessed by subject dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

reviewed_by_subject — Propósito: reviewed by subject dentro de ec12_control_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

evidence_watermark — Propósito: Instante hasta el cual se congelan los inputs considerados; garantiza reproducibilidad as-of.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

policy_version_ref — Propósito: policy version ref dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

assessed_at — Propósito: assessed at dentro de ec12_control_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

locked_at — Propósito: locked at dentro de ec12_control_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

supersedes_assessment_id — Propósito: supersedes assessment id dentro de ec12_control_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

content_hash — Propósito: SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-----------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_control_assessment        | PK       | PRIMARY KEY (tenant_id,assessment_id)                           | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_control_assessment_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_control_assessment_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_control_assessment_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_control_assessment       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.11 ec12_control_evidence_receipt

QUÉ REPRESENTA — Receipt append-only de evidencia usada por un assessment. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                              | **Ejemplo** |
|-------------------------|---------------------|----------|-------------------|------------|--------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id               | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | 8a6…        |
| evidence_receipt_id     | uuid                | NO       | gen_random_uuid() | PK         | Evidence receipt id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| assessment_id           | uuid                | NO       | —                 | FK interna | Assessment id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| evidence_requirement_id | uuid                | NO       | —                 | FK interna | Evidence requirement id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| artifact_ref            | uuid                | SÍ       | —                 | EXT REF    | Artifact ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| source_event_ref        | uuid                | SÍ       | —                 | EXT REF    | Source event ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| dataset_ref             | uuid                | SÍ       | —                 | EXT REF    | EXT REF a dataset CT-11 autorizado; EC-12 no copia su verdad completa.                                       | ejemplo     |
| content_hash            | char(64)            | NO       | —                 | —          | SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.                  | a94f…       |
| classification_code     | varchar(32)         | NO       | —                 | —          | Classification code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| collected_by_subject    | uuid                | NO       | —                 | —          | Collected by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| occurred_at             | timestamptz         | NO       | now()             | —          | Occurred at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| collected_at            | timestamptz         | NO       | —                 | —          | Collected at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| freshness_state         | varchar(24)         | NO       | —                 | —          | Freshness state. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| verification_state      | varchar(24)         | NO       | —                 | —          | Verification state. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

evidence_receipt_id — Propósito: evidence receipt id dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

assessment_id — Propósito: assessment id dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

evidence_requirement_id — Propósito: evidence requirement id dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

artifact_ref — Propósito: artifact ref dentro de ec12_control_evidence_receipt. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

source_event_ref — Propósito: source event ref dentro de ec12_control_evidence_receipt. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

dataset_ref — Propósito: EXT REF a dataset CT-11 autorizado; EC-12 no copia su verdad completa.. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

content_hash — Propósito: SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

classification_code — Propósito: classification code dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

collected_by_subject — Propósito: collected by subject dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

occurred_at — Propósito: occurred at dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

collected_at — Propósito: collected at dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

freshness_state — Propósito: freshness state dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

verification_state — Propósito: verification state dentro de ec12_control_evidence_receipt. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-----------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_control_evidence_receipt        | PK       | PRIMARY KEY (tenant_id,evidence_receipt_id)                     | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_control_evidence_receipt_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_control_evidence_receipt_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_control_evidence_receipt_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_control_evidence_receipt       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec12_nonconformity

QUÉ REPRESENTA — Desviación formal respecto de control, estándar, obligación o threshold. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                           | **Ejemplo** |
|----------------------|---------------------|----------|-------------------|------------|-----------------------------------------------------------------------------------------------------------|-------------|
| tenant_id            | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | 8a6…        |
| nonconformity_id     | uuid                | NO       | gen_random_uuid() | PK         | Nonconformity id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| nc_code              | varchar(64)         | NO       | —                 | —          | Nc code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| source_type          | varchar(40)         | NO       | —                 | —          | Source type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| source_ref           | uuid                | SÍ       | —                 | EXT REF    | Source ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| review_cycle_id      | uuid                | SÍ       | —                 | FK interna | Review cycle id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| review_scope_id      | uuid                | SÍ       | —                 | FK interna | Review scope id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| control_version_id   | uuid                | SÍ       | —                 | FK interna | Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.      | ejemplo     |
| severity_code        | varchar(24)         | NO       | —                 | —          | Severity code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | HIGH        |
| state                | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ACTIVE      |
| title                | varchar(240)        | NO       | —                 | —          | Title. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| description_text     | text                | NO       | —                 | —          | Description text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| detected_at          | timestamptz         | NO       | now()             | —          | Detected at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| detected_by_subject  | uuid                | NO       | —                 | —          | Detected by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| owner_subject_ref    | uuid                | SÍ       | —                 | EXT REF    | Owner subject ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| root_cause_ref       | uuid                | SÍ       | —                 | EXT REF    | Root cause ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| target_resolution_at | timestamptz         | SÍ       | —                 | —          | Target resolution at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| accepted_risk_ref    | uuid                | SÍ       | —                 | EXT REF    | Accepted risk ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| resolved_at          | timestamptz         | SÍ       | —                 | —          | Resolved at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| revision             | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.        | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

nonconformity_id — Propósito: nonconformity id dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

nc_code — Propósito: nc code dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

source_type — Propósito: source type dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

source_ref — Propósito: source ref dentro de ec12_nonconformity. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_cycle_id — Propósito: review cycle id dentro de ec12_nonconformity. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

review_scope_id — Propósito: review scope id dentro de ec12_nonconformity. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

control_version_id — Propósito: Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

severity_code — Propósito: severity code dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

state — Propósito: state dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

title — Propósito: title dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(240).

description_text — Propósito: description text dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

detected_at — Propósito: detected at dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

detected_by_subject — Propósito: detected by subject dentro de ec12_nonconformity. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

owner_subject_ref — Propósito: owner subject ref dentro de ec12_nonconformity. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

root_cause_ref — Propósito: root cause ref dentro de ec12_nonconformity. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

target_resolution_at — Propósito: target resolution at dentro de ec12_nonconformity. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

accepted_risk_ref — Propósito: accepted risk ref dentro de ec12_nonconformity. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

resolved_at — Propósito: resolved at dentro de ec12_nonconformity. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_nonconformity        | PK       | PRIMARY KEY (tenant_id,nonconformity_id)                        | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_nonconformity_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_nonconformity_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_nonconformity_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_nonconformity       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.13 ec12_capa_plan

QUÉ REPRESENTA — Plan correctivo/preventivo asociado a una no conformidad. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                               | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|------------|---------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | 8a6…        |
| capa_plan_id             | uuid                | NO       | gen_random_uuid() | PK         | Capa plan id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| nonconformity_id         | uuid                | NO       | —                 | FK interna | Nonconformity id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| plan_code                | varchar(64)         | NO       | —                 | —          | Plan code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| root_cause_summary       | text                | NO       | —                 | —          | Root cause summary. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| corrective_strategy      | text                | NO       | —                 | —          | Corrective strategy. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| preventive_strategy      | text                | SÍ       | —                 | —          | Preventive strategy. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| effectiveness_metric_ref | uuid                | SÍ       | —                 | EXT REF    | Effectiveness metric ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| baseline_snapshot_ref    | uuid                | SÍ       | —                 | EXT REF    | Baseline snapshot ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| target_value             | numeric(18          | SÍ       | —                 | —          | Target value. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| 6\)                      | text                | NO       | —                 | —          | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                       | ejemplo     |
| target_unit_code         | varchar(32)         | SÍ       | —                 | —          | Target unit code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| target_date              | date                | NO       | —                 | —          | Target date. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| state                    | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ACTIVE      |
| approved_by_subject      | uuid                | SÍ       | —                 | —          | Approved by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| approved_at              | timestamptz         | SÍ       | —                 | —          | Approved at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| effectiveness_result     | varchar(24)         | NO       | —                 | —          | Effectiveness result. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| verified_by_subject      | uuid                | SÍ       | —                 | —          | Verified by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| verified_at              | timestamptz         | SÍ       | —                 | —          | Verified at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| revision                 | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.            | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

capa_plan_id — Propósito: capa plan id dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

nonconformity_id — Propósito: nonconformity id dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

plan_code — Propósito: plan code dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

root_cause_summary — Propósito: root cause summary dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

corrective_strategy — Propósito: corrective strategy dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

preventive_strategy — Propósito: preventive strategy dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

effectiveness_metric_ref — Propósito: effectiveness metric ref dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

baseline_snapshot_ref — Propósito: baseline snapshot ref dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

target_value — Propósito: target value dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(18.

6\) — Propósito: 6) dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

target_unit_code — Propósito: target unit code dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

target_date — Propósito: target date dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

state — Propósito: state dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

approved_by_subject — Propósito: approved by subject dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

approved_at — Propósito: approved at dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

effectiveness_result — Propósito: effectiveness result dentro de ec12_capa_plan. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

verified_by_subject — Propósito: verified by subject dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

verified_at — Propósito: verified at dentro de ec12_capa_plan. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**        | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|--------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_capa_plan        | PK       | PRIMARY KEY (tenant_id,capa_plan_id)                            | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_capa_plan_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_capa_plan_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_capa_plan_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_capa_plan       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec12_corrective_action

QUÉ REPRESENTA — Acción concreta dentro de un CAPA. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                              | **Ejemplo** |
|-------------------------|---------------------|----------|-------------------|------------|--------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id               | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | 8a6…        |
| corrective_action_id    | uuid                | NO       | gen_random_uuid() | PK         | Corrective action id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| capa_plan_id            | uuid                | NO       | —                 | FK interna | Capa plan id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| action_code             | varchar(64)         | NO       | —                 | —          | Action code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| action_type_code        | varchar(40)         | NO       | —                 | —          | Action type code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| description_text        | text                | NO       | —                 | —          | Description text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| owner_subject_ref       | uuid                | SÍ       | —                 | EXT REF    | Owner subject ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| owner_context_ref       | uuid                | SÍ       | —                 | EXT REF    | Owner context ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| due_at                  | timestamptz         | SÍ       | —                 | —          | Due at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                  | ejemplo     |
| state                   | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                   | ACTIVE      |
| completion_receipt_ref  | uuid                | SÍ       | —                 | EXT REF    | Completion receipt ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| completion_evidence_ref | uuid                | SÍ       | —                 | EXT REF    | Completion evidence ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| completed_at            | timestamptz         | SÍ       | —                 | —          | Completed at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| verified_by_subject     | uuid                | SÍ       | —                 | —          | Verified by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| verified_at             | timestamptz         | SÍ       | —                 | —          | Verified at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| sequence_no             | integer             | NO       | —                 | —          | Sequence no. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| revision                | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.           | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_corrective_action. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

corrective_action_id — Propósito: corrective action id dentro de ec12_corrective_action. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

capa_plan_id — Propósito: capa plan id dentro de ec12_corrective_action. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

action_code — Propósito: action code dentro de ec12_corrective_action. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

action_type_code — Propósito: action type code dentro de ec12_corrective_action. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

description_text — Propósito: description text dentro de ec12_corrective_action. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

owner_subject_ref — Propósito: owner subject ref dentro de ec12_corrective_action. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

owner_context_ref — Propósito: owner context ref dentro de ec12_corrective_action. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

due_at — Propósito: due at dentro de ec12_corrective_action. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

state — Propósito: state dentro de ec12_corrective_action. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

completion_receipt_ref — Propósito: completion receipt ref dentro de ec12_corrective_action. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

completion_evidence_ref — Propósito: completion evidence ref dentro de ec12_corrective_action. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

completed_at — Propósito: completed at dentro de ec12_corrective_action. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

verified_by_subject — Propósito: verified by subject dentro de ec12_corrective_action. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

verified_at — Propósito: verified at dentro de ec12_corrective_action. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

sequence_no — Propósito: sequence no dentro de ec12_corrective_action. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|----------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_corrective_action        | PK       | PRIMARY KEY (tenant_id,corrective_action_id)                    | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_corrective_action_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_corrective_action_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_corrective_action_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_corrective_action       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec12_improvement_initiative

QUÉ REPRESENTA — Iniciativa priorizada de mejora continua. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                                         | **Ejemplo** |
|--------------------|---------------------|----------|-------------------|-----------|---------------------------------------------------------------------------------------------------------|-------------|
| tenant_id          | uuid                | NO       | —                 | PK\*      | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | 8a6…        |
| initiative_id      | uuid                | NO       | gen_random_uuid() | PK        | Initiative id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| initiative_code    | varchar(64)         | NO       | —                 | —         | Initiative code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| title              | varchar(240)        | NO       | —                 | —         | Title. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| problem_statement  | text                | NO       | —                 | —         | Problem statement. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| hypothesis_text    | text                | NO       | —                 | —         | Hypothesis text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| source_signal_type | varchar(40)         | NO       | —                 | —         | Source signal type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| source_signal_ref  | uuid                | SÍ       | —                 | EXT REF   | Source signal ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| priority_score     | numeric(12          | NO       | —                 | —         | Priority score. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| 6\)                | text                | NO       | —                 | —         | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ejemplo     |
| owner_scope_ref    | uuid                | NO       | —                 | EXT REF   | Owner scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| owner_subject_ref  | uuid                | SÍ       | —                 | EXT REF   | Owner subject ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| state              | varchar(24)         | NO       | —                 | —         | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ACTIVE      |
| proposed_at        | timestamptz         | NO       | —                 | —         | Proposed at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| target_horizon_at  | timestamptz         | SÍ       | —                 | —         | Target horizon at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| adopted_at         | timestamptz         | SÍ       | —                 | —         | Adopted at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| revision           | bigint              | NO       | 0                 | —         | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.      | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

initiative_id — Propósito: initiative id dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

initiative_code — Propósito: initiative code dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

title — Propósito: title dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(240).

problem_statement — Propósito: problem statement dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

hypothesis_text — Propósito: hypothesis text dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

source_signal_type — Propósito: source signal type dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

source_signal_ref — Propósito: source signal ref dentro de ec12_improvement_initiative. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

priority_score — Propósito: priority score dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(12.

6\) — Propósito: 6) dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

owner_scope_ref — Propósito: owner scope ref dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

owner_subject_ref — Propósito: owner subject ref dentro de ec12_improvement_initiative. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

state — Propósito: state dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

proposed_at — Propósito: proposed at dentro de ec12_improvement_initiative. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

target_horizon_at — Propósito: target horizon at dentro de ec12_improvement_initiative. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

adopted_at — Propósito: adopted at dentro de ec12_improvement_initiative. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                     | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|---------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_improvement_initiative        | PK       | PRIMARY KEY (tenant_id,initiative_id)                           | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_improvement_initiative_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_improvement_initiative_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_improvement_initiative_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_improvement_initiative       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.16 ec12_improvement_experiment

QUÉ REPRESENTA — Experimento medible asociado a una iniciativa. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                            | **Ejemplo** |
|-----------------------|---------------------|----------|-------------------|------------|------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id             | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | 8a6…        |
| experiment_id         | uuid                | NO       | gen_random_uuid() | PK         | Experiment id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| initiative_id         | uuid                | NO       | —                 | FK interna | Initiative id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| experiment_code       | varchar(64)         | NO       | —                 | —          | Experiment code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| scope_type            | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| scope_ref             | uuid                | SÍ       | —                 | EXT REF    | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| primary_indicator_ref | uuid                | NO       | —                 | EXT REF    | Primary indicator ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| indicator_version_ref | uuid                | NO       | —                 | EXT REF    | Indicator version ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| baseline_snapshot_ref | uuid                | SÍ       | —                 | EXT REF    | Baseline snapshot ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| baseline_value        | numeric(18          | SÍ       | —                 | —          | Baseline value. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| 6\)                   | text                | NO       | —                 | —          | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ejemplo     |
| target_value          | numeric(18          | SÍ       | —                 | —          | Target value. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| 6\)                   | text                | NO       | —                 | —          | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ejemplo     |
| unit_code             | varchar(32)         | NO       | —                 | —          | Unit code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| starts_at             | timestamptz         | NO       | —                 | —          | Starts at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| ends_at               | timestamptz         | SÍ       | —                 | —          | Ends at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| state                 | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ACTIVE      |
| decision              | varchar(24)         | SÍ       | —                 | —          | Decision. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| outcome_snapshot_ref  | uuid                | SÍ       | —                 | EXT REF    | Outcome snapshot ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| conclusion_text       | text                | SÍ       | —                 | —          | Conclusion text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| revision              | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.         | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

experiment_id — Propósito: experiment id dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

initiative_id — Propósito: initiative id dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

experiment_code — Propósito: experiment code dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

scope_type — Propósito: scope type dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_improvement_experiment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

primary_indicator_ref — Propósito: primary indicator ref dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

indicator_version_ref — Propósito: indicator version ref dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

baseline_snapshot_ref — Propósito: baseline snapshot ref dentro de ec12_improvement_experiment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

baseline_value — Propósito: baseline value dentro de ec12_improvement_experiment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(18.

6\) — Propósito: 6) dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

target_value — Propósito: target value dentro de ec12_improvement_experiment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(18.

6\) — Propósito: 6) dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

unit_code — Propósito: unit code dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

starts_at — Propósito: starts at dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

ends_at — Propósito: ends at dentro de ec12_improvement_experiment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

state — Propósito: state dentro de ec12_improvement_experiment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

decision — Propósito: decision dentro de ec12_improvement_experiment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

outcome_snapshot_ref — Propósito: outcome snapshot ref dentro de ec12_improvement_experiment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

conclusion_text — Propósito: conclusion text dentro de ec12_improvement_experiment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                     | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|---------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_improvement_experiment        | PK       | PRIMARY KEY (tenant_id,experiment_id)                           | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_improvement_experiment_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_improvement_experiment_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_improvement_experiment_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_improvement_experiment       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.17 ec12_indicator_definition

QUÉ REPRESENTA — Definición versionada de indicador de calidad. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                                               | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|-----------|---------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | —                 | PK\*      | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | 8a6…        |
| indicator_id             | uuid                | NO       | gen_random_uuid() | PK        | Indicator id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| indicator_code           | varchar(64)         | NO       | —                 | —         | Indicator code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| version_no               | integer             | NO       | —                 | —         | Version no. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| state                    | varchar(24)         | NO       | —                 | —         | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ACTIVE      |
| display_name             | varchar(240)        | NO       | —                 | —         | Display name. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| dimension_code           | varchar(64)         | NO       | —                 | —         | Dimension code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| grain_code               | varchar(64)         | NO       | —                 | —         | Grain code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| unit_code                | varchar(32)         | NO       | —                 | —         | Unit code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| direction_code           | varchar(16)         | NO       | —                 | —         | Direction code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| window_code              | varchar(40)         | NO       | —                 | —         | Window code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| dataset_contract_ref     | uuid                | NO       | —                 | EXT REF   | Dataset contract ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| formula_dsl_version      | varchar(32)         | NO       | —                 | —         | Formula dsl version. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| formula_expression       | text                | NO       | —                 | —         | Expresión en DSL segura/versionada; nunca SQL arbitrario ni código ejecutable enviado por UI.                 | ejemplo     |
| calculator_version       | varchar(40)         | NO       | —                 | —         | Calculator version. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| missing_data_policy_code | varchar(64)         | NO       | —                 | —         | Missing data policy code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| comparability_group      | varchar(64)         | NO       | —                 | —         | Comparability group. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| effective_from           | timestamptz         | NO       | —                 | —         | Effective from. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| effective_to             | timestamptz         | SÍ       | —                 | —         | Effective to. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| content_hash             | char(64)            | NO       | —                 | —         | SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.                   | a94f…       |
| revision                 | bigint              | NO       | 0                 | —         | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.            | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

indicator_id — Propósito: indicator id dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

indicator_code — Propósito: indicator code dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

version_no — Propósito: version no dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

state — Propósito: state dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

display_name — Propósito: display name dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(240).

dimension_code — Propósito: dimension code dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

grain_code — Propósito: grain code dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

unit_code — Propósito: unit code dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

direction_code — Propósito: direction code dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(16).

window_code — Propósito: window code dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

dataset_contract_ref — Propósito: dataset contract ref dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

formula_dsl_version — Propósito: formula dsl version dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

formula_expression — Propósito: Expresión en DSL segura/versionada; nunca SQL arbitrario ni código ejecutable enviado por UI.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

calculator_version — Propósito: calculator version dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

missing_data_policy_code — Propósito: missing data policy code dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

comparability_group — Propósito: comparability group dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

effective_from — Propósito: effective from dentro de ec12_indicator_definition. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

effective_to — Propósito: effective to dentro de ec12_indicator_definition. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

content_hash — Propósito: SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_indicator_definition        | PK       | PRIMARY KEY (tenant_id,indicator_id)                            | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_indicator_definition_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_indicator_definition_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_indicator_definition_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_indicator_definition       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.18 ec12_indicator_threshold

QUÉ REPRESENTA — Banda/umbral aplicable a un IndicatorDefinition versionado. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                      | **Ejemplo** |
|-----------------|---------------------|----------|-------------------|------------|------------------------------------------------------------------------------------------------------|-------------|
| tenant_id       | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | 8a6…        |
| threshold_id    | uuid                | NO       | gen_random_uuid() | PK         | Threshold id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| indicator_id    | uuid                | NO       | —                 | FK interna | Indicator id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| threshold_code  | varchar(64)         | NO       | —                 | —          | Threshold code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| scope_rule_ref  | uuid                | NO       | —                 | EXT REF    | Scope rule ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| lower_bound     | numeric(18          | NO       | —                 | —          | Lower bound. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| 6\)             | text                | NO       | —                 | —          | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| upper_bound     | numeric(18          | NO       | —                 | —          | Upper bound. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| 6\)             | text                | NO       | —                 | —          | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| lower_inclusive | boolean             | NO       | false             | —          | Lower inclusive. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| upper_inclusive | boolean             | NO       | false             | —          | Upper inclusive. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| quality_band    | varchar(24)         | SÍ       | —                 | —          | Quality band. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| severity_code   | varchar(24)         | NO       | —                 | —          | Severity code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | HIGH        |
| sequence_no     | integer             | NO       | —                 | —          | Sequence no. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| effective_from  | timestamptz         | NO       | —                 | —          | Effective from. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| effective_to    | timestamptz         | SÍ       | —                 | —          | Effective to. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| revision        | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.   | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

threshold_id — Propósito: threshold id dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

indicator_id — Propósito: indicator id dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

threshold_code — Propósito: threshold code dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

scope_rule_ref — Propósito: scope rule ref dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

lower_bound — Propósito: lower bound dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(18.

6\) — Propósito: 6) dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

upper_bound — Propósito: upper bound dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(18.

6\) — Propósito: 6) dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

lower_inclusive — Propósito: lower inclusive dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: boolean.

upper_inclusive — Propósito: upper inclusive dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: boolean.

quality_band — Propósito: quality band dentro de ec12_indicator_threshold. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

severity_code — Propósito: severity code dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

sequence_no — Propósito: sequence no dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

effective_from — Propósito: effective from dentro de ec12_indicator_threshold. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

effective_to — Propósito: effective to dentro de ec12_indicator_threshold. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_indicator_threshold        | PK       | PRIMARY KEY (tenant_id,threshold_id)                            | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_indicator_threshold_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_indicator_threshold_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_indicator_threshold_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_indicator_threshold       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.19 ec12_indicator_snapshot

QUÉ REPRESENTA — Observación reproducible de un indicador en un scope/as-of. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                                                        | **Ejemplo** |
|-----------------------|---------------------|----------|-------------------|------------|----------------------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id             | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                         | 8a6…        |
| indicator_snapshot_id | uuid                | NO       | gen_random_uuid() | PK         | Indicator snapshot id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                             | ejemplo     |
| indicator_id          | uuid                | NO       | —                 | FK interna | Indicator id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                      | ejemplo     |
| scope_type            | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                        | ejemplo     |
| scope_ref             | uuid                | SÍ       | —                 | EXT REF    | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                         | ejemplo     |
| period_start          | date                | NO       | —                 | —          | Period start. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                      | ejemplo     |
| period_end            | date                | NO       | —                 | —          | Period end. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                        | ejemplo     |
| as_of                 | timestamptz         | NO       | —                 | —          | As of. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                             | ejemplo     |
| dataset_ref           | uuid                | SÍ       | —                 | EXT REF    | EXT REF a dataset CT-11 autorizado; EC-12 no copia su verdad completa.                                                                 | ejemplo     |
| dataset_version_ref   | uuid                | NO       | —                 | EXT REF    | Dataset version ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                               | ejemplo     |
| input_watermark       | timestamptz         | NO       | —                 | —          | Input watermark. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                   | ejemplo     |
| value_numeric         | numeric(18          | SÍ       | —                 | —          | Value numeric. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                     | ejemplo     |
| 6\)                   | text                | NO       | —                 | —          | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                                | ejemplo     |
| value_text            | varchar(400)        | SÍ       | —                 | —          | Value text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                        | ejemplo     |
| unit_code             | varchar(32)         | NO       | —                 | —          | Unit code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                         | ejemplo     |
| quality_state         | varchar(24)         | NO       | —                 | —          | Estado semántico de disponibilidad/interpretación del valor; distingue NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, SUPPRESSED y otros. | VALUE       |
| quality_band          | varchar(24)         | SÍ       | —                 | —          | Quality band. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                      | ejemplo     |
| freshness_state       | varchar(24)         | NO       | —                 | —          | Freshness state. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                   | ejemplo     |
| calculator_version    | varchar(40)         | NO       | —                 | —          | Calculator version. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                | ejemplo     |
| content_hash          | char(64)            | NO       | —                 | —          | SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.                                            | a94f…       |
| built_at              | timestamptz         | NO       | now()             | —          | Built at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                                          | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

indicator_snapshot_id — Propósito: indicator snapshot id dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

indicator_id — Propósito: indicator id dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_type — Propósito: scope type dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_indicator_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

period_start — Propósito: period start dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

period_end — Propósito: period end dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

as_of — Propósito: as of dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

dataset_ref — Propósito: EXT REF a dataset CT-11 autorizado; EC-12 no copia su verdad completa.. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

dataset_version_ref — Propósito: dataset version ref dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

input_watermark — Propósito: input watermark dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

value_numeric — Propósito: value numeric dentro de ec12_indicator_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(18.

6\) — Propósito: 6) dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

value_text — Propósito: value text dentro de ec12_indicator_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(400).

unit_code — Propósito: unit code dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(32).

quality_state — Propósito: Estado semántico de disponibilidad/interpretación del valor; distingue NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, SUPPRESSED y otros.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

quality_band — Propósito: quality band dentro de ec12_indicator_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

freshness_state — Propósito: freshness state dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

calculator_version — Propósito: calculator version dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

content_hash — Propósito: SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

built_at — Propósito: built at dentro de ec12_indicator_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-----------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_indicator_snapshot        | PK       | PRIMARY KEY (tenant_id,indicator_snapshot_id)                   | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_indicator_snapshot_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_indicator_snapshot_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_indicator_snapshot_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_indicator_snapshot       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.20 ec12_portfolio_health_snapshot

QUÉ REPRESENTA — Snapshot agregado de salud por dimensiones del framework. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                               | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|------------|---------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | 8a6…        |
| health_snapshot_id       | uuid                | NO       | gen_random_uuid() | PK         | Health snapshot id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| framework_version_id     | uuid                | NO       | —                 | FK interna | Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.           | ejemplo     |
| scope_type               | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| scope_ref                | uuid                | SÍ       | —                 | EXT REF    | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| period_start             | date                | NO       | —                 | —          | Period start. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| period_end               | date                | NO       | —                 | —          | Period end. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| input_watermark          | timestamptz         | NO       | —                 | —          | Input watermark. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| coverage_ratio           | numeric(10          | NO       | —                 | —          | Coverage ratio. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | 0.92000000  |
| 8\)                      | text                | NO       | —                 | —          | 8). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                       | ejemplo     |
| health_score             | numeric(10          | NO       | —                 | —          | Health score. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | 82.500000   |
| 6\)                      | text                | NO       | —                 | —          | 6). Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                       | ejemplo     |
| health_band              | varchar(24)         | NO       | —                 | —          | Health band. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| dimension_scores_json    | jsonb               | NO       | —                 | —          | Snapshot de scores por dimensión con metadata de coverage/state; no reemplaza los IndicatorSnapshots fuente.  | ejemplo     |
| missing_data_policy_code | varchar(64)         | NO       | —                 | —          | Missing data policy code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| calculator_version       | varchar(40)         | NO       | —                 | —          | Calculator version. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| content_hash             | char(64)            | NO       | —                 | —          | SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.                   | a94f…       |
| status                   | varchar(24)         | NO       | —                 | —          | Status. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                   | ejemplo     |
| built_at                 | timestamptz         | NO       | now()             | —          | Built at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ejemplo     |
| approved_by_subject      | uuid                | SÍ       | —                 | —          | Approved by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| approved_at              | timestamptz         | SÍ       | —                 | —          | Approved at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| supersedes_snapshot_id   | uuid                | SÍ       | —                 | FK interna | Supersedes snapshot id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | ejemplo     |
| revision                 | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.            | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

health_snapshot_id — Propósito: health snapshot id dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

framework_version_id — Propósito: Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_type — Propósito: scope type dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_portfolio_health_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

period_start — Propósito: period start dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

period_end — Propósito: period end dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

input_watermark — Propósito: input watermark dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

coverage_ratio — Propósito: coverage ratio dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(10.

8\) — Propósito: 8) dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

health_score — Propósito: health score dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: numeric(10.

6\) — Propósito: 6) dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

health_band — Propósito: health band dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

dimension_scores_json — Propósito: Snapshot de scores por dimensión con metadata de coverage/state; no reemplaza los IndicatorSnapshots fuente.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: jsonb.

missing_data_policy_code — Propósito: missing data policy code dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

calculator_version — Propósito: calculator version dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

content_hash — Propósito: SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

status — Propósito: status dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

built_at — Propósito: built at dentro de ec12_portfolio_health_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

approved_by_subject — Propósito: approved by subject dentro de ec12_portfolio_health_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

approved_at — Propósito: approved at dentro de ec12_portfolio_health_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

supersedes_snapshot_id — Propósito: supersedes snapshot id dentro de ec12_portfolio_health_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                        | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|------------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_portfolio_health_snapshot        | PK       | PRIMARY KEY (tenant_id,health_snapshot_id)                      | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_portfolio_health_snapshot_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_portfolio_health_snapshot_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_portfolio_health_snapshot_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_portfolio_health_snapshot       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.21 ec12_quality_scorecard_snapshot

QUÉ REPRESENTA — Scorecard aprobado/distribuible de calidad. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                             | **Ejemplo** |
|------------------------|---------------------|----------|-------------------|------------|-------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id              | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | 8a6…        |
| scorecard_snapshot_id  | uuid                | NO       | gen_random_uuid() | PK         | Scorecard snapshot id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| framework_version_id   | uuid                | NO       | —                 | FK interna | Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.         | ejemplo     |
| scope_type             | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| scope_ref              | uuid                | SÍ       | —                 | EXT REF    | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| report_profile_ref     | uuid                | SÍ       | —                 | EXT REF    | Report profile ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| purpose_ref            | uuid                | SÍ       | —                 | EXT REF    | Purpose ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| period_start           | date                | NO       | —                 | —          | Period start. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| period_end             | date                | NO       | —                 | —          | Period end. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| input_watermark        | timestamptz         | NO       | —                 | —          | Input watermark. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| status                 | varchar(24)         | NO       | —                 | —          | Status. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ejemplo     |
| summary_json           | jsonb               | NO       | —                 | —          | Contenido estructurado del scorecard ya gobernado para consumo; no es un volcado de tablas ni PII libre.    | ejemplo     |
| artifact_ref           | uuid                | SÍ       | —                 | EXT REF    | Artifact ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| content_hash           | char(64)            | NO       | —                 | —          | SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.                 | a94f…       |
| built_at               | timestamptz         | NO       | now()             | —          | Built at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| approved_by_subject    | uuid                | SÍ       | —                 | —          | Approved by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| approved_at            | timestamptz         | SÍ       | —                 | —          | Approved at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| published_at           | timestamptz         | SÍ       | —                 | —          | Published at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | ejemplo     |
| supersedes_snapshot_id | uuid                | SÍ       | —                 | FK interna | Supersedes snapshot id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| revision               | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.          | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_quality_scorecard_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scorecard_snapshot_id — Propósito: scorecard snapshot id dentro de ec12_quality_scorecard_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

framework_version_id — Propósito: Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_type — Propósito: scope type dentro de ec12_quality_scorecard_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_quality_scorecard_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

report_profile_ref — Propósito: report profile ref dentro de ec12_quality_scorecard_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

purpose_ref — Propósito: purpose ref dentro de ec12_quality_scorecard_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

period_start — Propósito: period start dentro de ec12_quality_scorecard_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

period_end — Propósito: period end dentro de ec12_quality_scorecard_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: date.

input_watermark — Propósito: input watermark dentro de ec12_quality_scorecard_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

status — Propósito: status dentro de ec12_quality_scorecard_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

summary_json — Propósito: Contenido estructurado del scorecard ya gobernado para consumo; no es un volcado de tablas ni PII libre.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: jsonb.

artifact_ref — Propósito: artifact ref dentro de ec12_quality_scorecard_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

content_hash — Propósito: SHA-256/canonical hash del snapshot o decisión; detecta alteración y soporta evidence pack.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

built_at — Propósito: built at dentro de ec12_quality_scorecard_snapshot. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

approved_by_subject — Propósito: approved by subject dentro de ec12_quality_scorecard_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

approved_at — Propósito: approved at dentro de ec12_quality_scorecard_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

published_at — Propósito: published at dentro de ec12_quality_scorecard_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

supersedes_snapshot_id — Propósito: supersedes snapshot id dentro de ec12_quality_scorecard_snapshot. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                         | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-------------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_quality_scorecard_snapshot        | PK       | PRIMARY KEY (tenant_id,scorecard_snapshot_id)                   | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_quality_scorecard_snapshot_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_quality_scorecard_snapshot_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_quality_scorecard_snapshot_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_quality_scorecard_snapshot       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.22 ec12_compliance_attestation

QUÉ REPRESENTA — Atestación as-of para un binding/scope con expiración. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                                | **Ejemplo** |
|---------------------------|---------------------|----------|-------------------|------------|----------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | 8a6…        |
| attestation_id            | uuid                | NO       | gen_random_uuid() | PK         | Attestation id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| binding_id                | uuid                | SÍ       | —                 | FK interna | Binding id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| scope_type                | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| scope_ref                 | uuid                | SÍ       | —                 | EXT REF    | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ejemplo     |
| result                    | varchar(24)         | NO       | —                 | —          | Result. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | PASS        |
| state                     | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                     | ACTIVE      |
| evidence_watermark        | timestamptz         | NO       | —                 | —          | Instante hasta el cual se congelan los inputs considerados; garantiza reproducibilidad as-of.                  | ejemplo     |
| evidence_set_hash         | char(64)            | NO       | —                 | —          | Evidence set hash. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| rationale_text            | text                | NO       | —                 | —          | Rationale text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| reviewer_subject_ref      | uuid                | NO       | —                 | EXT REF    | Reviewer subject ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| approver_subject_ref      | uuid                | SÍ       | —                 | EXT REF    | Approver subject ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| as_of                     | timestamptz         | NO       | —                 | —          | As of. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                     | ejemplo     |
| expires_at                | timestamptz         | SÍ       | —                 | —          | Expires at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| approved_at               | timestamptz         | SÍ       | —                 | —          | Approved at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| supersedes_attestation_id | uuid                | SÍ       | —                 | FK interna | Supersedes attestation id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| revision                  | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.             | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

attestation_id — Propósito: attestation id dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

binding_id — Propósito: binding id dentro de ec12_compliance_attestation. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_type — Propósito: scope type dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_compliance_attestation. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

result — Propósito: result dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

state — Propósito: state dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

evidence_watermark — Propósito: Instante hasta el cual se congelan los inputs considerados; garantiza reproducibilidad as-of.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

evidence_set_hash — Propósito: evidence set hash dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

rationale_text — Propósito: rationale text dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

reviewer_subject_ref — Propósito: reviewer subject ref dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

approver_subject_ref — Propósito: approver subject ref dentro de ec12_compliance_attestation. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

as_of — Propósito: as of dentro de ec12_compliance_attestation. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

expires_at — Propósito: expires at dentro de ec12_compliance_attestation. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

approved_at — Propósito: approved at dentro de ec12_compliance_attestation. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

supersedes_attestation_id — Propósito: supersedes attestation id dentro de ec12_compliance_attestation. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                     | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|---------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_compliance_attestation        | PK       | PRIMARY KEY (tenant_id,attestation_id)                          | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_compliance_attestation_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_compliance_attestation_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_compliance_attestation_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_compliance_attestation       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.23 ec12_exception_waiver

QUÉ REPRESENTA — Excepción temporal respecto de control/binding con riesgo y compensating controls. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                                | **Ejemplo** |
|----------------------------|---------------------|----------|-------------------|------------|----------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | 8a6…        |
| waiver_id                  | uuid                | NO       | gen_random_uuid() | PK         | Waiver id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ejemplo     |
| waiver_code                | varchar(64)         | NO       | —                 | —          | Waiver code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| control_version_id         | uuid                | SÍ       | —                 | FK interna | Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.           | ejemplo     |
| binding_id                 | uuid                | SÍ       | —                 | FK interna | Binding id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| scope_type                 | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| scope_ref                  | uuid                | SÍ       | —                 | EXT REF    | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ejemplo     |
| reason_code                | varchar(80)         | NO       | —                 | —          | Reason code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| rationale_text             | text                | NO       | —                 | —          | Rationale text. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| risk_severity_code         | varchar(24)         | NO       | —                 | —          | Risk severity code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| residual_risk_code         | varchar(24)         | NO       | —                 | —          | Residual risk code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| compensating_controls_json | jsonb               | NO       | —                 | —          | Snapshot estructurado de controles compensatorios aprobados; validado contra schema y congelado con la waiver. | ejemplo     |
| state                      | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                     | ACTIVE      |
| requested_by_subject       | uuid                | NO       | —                 | —          | Requested by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| approved_by_subject        | uuid                | SÍ       | —                 | —          | Approved by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| starts_at                  | timestamptz         | NO       | —                 | —          | Starts at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ejemplo     |
| expires_at                 | timestamptz         | SÍ       | —                 | —          | Expires at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| revoked_at                 | timestamptz         | SÍ       | —                 | —          | Revoked at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| revision                   | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.             | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

waiver_id — Propósito: waiver id dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

waiver_code — Propósito: waiver code dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

control_version_id — Propósito: Referencia interna a la versión exacta del control evaluado; nunca se resuelve por “versión actual”.. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

binding_id — Propósito: binding id dentro de ec12_exception_waiver. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_type — Propósito: scope type dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_exception_waiver. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

reason_code — Propósito: reason code dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(80).

rationale_text — Propósito: rationale text dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: text.

risk_severity_code — Propósito: risk severity code dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

residual_risk_code — Propósito: residual risk code dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

compensating_controls_json — Propósito: Snapshot estructurado de controles compensatorios aprobados; validado contra schema y congelado con la waiver.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: jsonb.

state — Propósito: state dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

requested_by_subject — Propósito: requested by subject dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

approved_by_subject — Propósito: approved by subject dentro de ec12_exception_waiver. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

starts_at — Propósito: starts at dentro de ec12_exception_waiver. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

expires_at — Propósito: expires at dentro de ec12_exception_waiver. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revoked_at — Propósito: revoked at dentro de ec12_exception_waiver. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**               | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|---------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_exception_waiver        | PK       | PRIMARY KEY (tenant_id,waiver_id)                               | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_exception_waiver_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_exception_waiver_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_exception_waiver_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_exception_waiver       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.24 ec12_quality_alert

QUÉ REPRESENTA — Señal operativa de calidad, drift, overdue o breach. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                                              | **Ejemplo** |
|-------------------------|---------------------|----------|-------------------|-----------|--------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id               | uuid                | NO       | —                 | PK\*      | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | 8a6…        |
| alert_id                | uuid                | NO       | gen_random_uuid() | PK        | Alert id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                | ejemplo     |
| alert_code              | varchar(64)         | NO       | —                 | —         | Alert code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| alert_type              | varchar(40)         | NO       | —                 | —         | Alert type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| scope_type              | varchar(40)         | NO       | —                 | —         | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| scope_ref               | uuid                | SÍ       | —                 | EXT REF   | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| source_ref              | uuid                | SÍ       | —                 | EXT REF   | Source ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| severity_code           | varchar(24)         | NO       | —                 | —         | Severity code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.           | HIGH        |
| state                   | varchar(24)         | NO       | —                 | —         | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                   | ACTIVE      |
| dedup_key               | varchar(160)        | NO       | —                 | —         | Dedup key. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.               | ejemplo     |
| detected_at             | timestamptz         | NO       | now()             | —         | Detected at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| acknowledged_by_subject | uuid                | SÍ       | —                 | —         | Acknowledged by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| acknowledged_at         | timestamptz         | SÍ       | —                 | —         | Acknowledged at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| owner_subject_ref       | uuid                | SÍ       | —                 | EXT REF   | Owner subject ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| due_at                  | timestamptz         | SÍ       | —                 | —         | Due at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                  | ejemplo     |
| resolution_code         | varchar(80)         | SÍ       | —                 | —         | Resolution code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| resolved_at             | timestamptz         | SÍ       | —                 | —         | Resolved at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| revision                | bigint              | NO       | 0                 | —         | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.           | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

alert_id — Propósito: alert id dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

alert_code — Propósito: alert code dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

alert_type — Propósito: alert type dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_type — Propósito: scope type dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_quality_alert. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

source_ref — Propósito: source ref dentro de ec12_quality_alert. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

severity_code — Propósito: severity code dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

state — Propósito: state dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

dedup_key — Propósito: dedup key dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(160).

detected_at — Propósito: detected at dentro de ec12_quality_alert. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

acknowledged_by_subject — Propósito: acknowledged by subject dentro de ec12_quality_alert. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

acknowledged_at — Propósito: acknowledged at dentro de ec12_quality_alert. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

owner_subject_ref — Propósito: owner subject ref dentro de ec12_quality_alert. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

due_at — Propósito: due at dentro de ec12_quality_alert. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

resolution_code — Propósito: resolution code dentro de ec12_quality_alert. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(80).

resolved_at — Propósito: resolved at dentro de ec12_quality_alert. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_quality_alert        | PK       | PRIMARY KEY (tenant_id,alert_id)                                | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_quality_alert_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_quality_alert_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_quality_alert_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_quality_alert       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.25 ec12_quality_gate_assessment

QUÉ REPRESENTA — Decisión de readiness/closure consumible por módulos EC mediante receipt. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**                     | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                                    | **Ejemplo** |
|-------------------------------|---------------------|----------|-------------------|------------|--------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                     | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                     | 8a6…        |
| gate_assessment_id            | uuid                | NO       | gen_random_uuid() | PK         | Gate assessment id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| gate_request_key              | varchar(160)        | NO       | —                 | —          | Gate request key. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.              | ejemplo     |
| gate_code                     | varchar(64)         | NO       | —                 | —          | Gate code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                     | ejemplo     |
| framework_version_id          | uuid                | NO       | —                 | FK interna | Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.                | ejemplo     |
| scope_type                    | varchar(40)         | NO       | —                 | —          | Scope type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ejemplo     |
| scope_ref                     | uuid                | SÍ       | —                 | EXT REF    | Scope ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                     | ejemplo     |
| state                         | varchar(24)         | NO       | —                 | —          | State. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                         | ACTIVE      |
| result                        | varchar(24)         | NO       | —                 | —          | Result. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                        | PASS        |
| evidence_watermark            | timestamptz         | NO       | —                 | —          | Instante hasta el cual se congelan los inputs considerados; garantiza reproducibilidad as-of.                      | ejemplo     |
| mandatory_fail_count          | integer             | NO       | —                 | —          | Mandatory fail count. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| conditional_count             | integer             | NO       | —                 | —          | Conditional count. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.             | ejemplo     |
| decision_reason_code          | varchar(80)         | NO       | —                 | —          | Decision reason code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.          | ejemplo     |
| decided_by_subject            | uuid                | SÍ       | —                 | —          | Decided by subject. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| decided_at                    | timestamptz         | SÍ       | —                 | —          | Decided at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                    | ejemplo     |
| decision_hash                 | char(64)            | NO       | —                 | —          | Decision hash. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.                 | ejemplo     |
| supersedes_gate_assessment_id | uuid                | SÍ       | —                 | FK interna | Supersedes gate assessment id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| revision                      | bigint              | NO       | 0                 | —          | Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.                 | 7           |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

gate_assessment_id — Propósito: gate assessment id dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

gate_request_key — Propósito: gate request key dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(160).

gate_code — Propósito: gate code dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(64).

framework_version_id — Propósito: Referencia interna tenant-aware a la versión exacta del framework; preserva la semántica histórica.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

scope_type — Propósito: scope type dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(40).

scope_ref — Propósito: scope ref dentro de ec12_quality_gate_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

state — Propósito: state dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

result — Propósito: result dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

evidence_watermark — Propósito: Instante hasta el cual se congelan los inputs considerados; garantiza reproducibilidad as-of.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

mandatory_fail_count — Propósito: mandatory fail count dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

conditional_count — Propósito: conditional count dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

decision_reason_code — Propósito: decision reason code dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(80).

decided_by_subject — Propósito: decided by subject dentro de ec12_quality_gate_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

decided_at — Propósito: decided at dentro de ec12_quality_gate_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

decision_hash — Propósito: decision hash dentro de ec12_quality_gate_assessment. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

supersedes_gate_assessment_id — Propósito: supersedes gate assessment id dentro de ec12_quality_gate_assessment. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

revision — Propósito: Versión optimista del aggregate; se incrementa ante toda mutación relevante y se expone como ETag.. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: bigint.

| **Nombre físico**                      | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|----------------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_quality_gate_assessment        | PK       | PRIMARY KEY (tenant_id,gate_assessment_id)                      | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_quality_gate_assessment_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_quality_gate_assessment_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_quality_gate_assessment_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_quality_gate_assessment       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.26 ec12_idempotency_record

QUÉ REPRESENTA — Registro durable de idempotencia con lease/recovery. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                                        | **Ejemplo** |
|-------------------|---------------------|----------|-------------------|-----------|--------------------------------------------------------------------------------------------------------|-------------|
| tenant_id         | uuid                | NO       | —                 | PK\*      | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | 8a6…        |
| idempotency_id    | uuid                | NO       | gen_random_uuid() | PK        | Idempotency id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| idempotency_key   | varchar(160)        | NO       | —                 | —         | Idempotency key. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | ejemplo     |
| command_scope     | varchar(120)        | NO       | —                 | —         | Command scope. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| request_hash      | char(64)            | NO       | —                 | —         | Request hash. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| status            | varchar(24)         | NO       | —                 | —         | Status. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.            | ejemplo     |
| owner_instance    | varchar(120)        | NO       | —                 | —         | Owner instance. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| lease_until       | timestamptz         | SÍ       | —                 | —         | Lease until. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| response_ref      | uuid                | SÍ       | —                 | EXT REF   | Response ref. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | ejemplo     |
| response_snapshot | jsonb               | SÍ       | —                 | —         | Response snapshot. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| attempt_count     | integer             | NO       | —                 | —         | Attempt count. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| updated_at        | timestamptz         | NO       | now()             | —         | Updated at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

idempotency_id — Propósito: idempotency id dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

idempotency_key — Propósito: idempotency key dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(160).

command_scope — Propósito: command scope dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(120).

request_hash — Propósito: request hash dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

status — Propósito: status dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

owner_instance — Propósito: owner instance dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(120).

lease_until — Propósito: lease until dentro de ec12_idempotency_record. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

response_ref — Propósito: response ref dentro de ec12_idempotency_record. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: es referencia cross-context sin FK física. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

response_snapshot — Propósito: response snapshot dentro de ec12_idempotency_record. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: jsonb.

attempt_count — Propósito: attempt count dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

updated_at — Propósito: updated at dentro de ec12_idempotency_record. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-----------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_idempotency_record        | PK       | PRIMARY KEY (tenant_id,idempotency_id)                          | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_idempotency_record_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_idempotency_record_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_idempotency_record_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_idempotency_record       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.27 ec12_outbox_event

QUÉ REPRESENTA — Outbox transaccional multi-instancia. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                     | **Ejemplo** |
|----------------|---------------------|----------|-------------------|------------|-----------------------------------------------------------------------------------------------------|-------------|
| tenant_id      | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | 8a6…        |
| event_id       | uuid                | NO       | gen_random_uuid() | PK         | Event id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.       | ejemplo     |
| aggregate_type | varchar(80)         | NO       | —                 | —          | Aggregate type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| aggregate_id   | uuid                | NO       | —                 | FK interna | Aggregate id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | ejemplo     |
| event_type     | varchar(120)        | NO       | —                 | —          | Event type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| schema_version | integer             | NO       | —                 | —          | Schema version. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| correlation_id | uuid                | NO       | —                 | FK interna | Correlation id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| causation_id   | uuid                | NO       | —                 | FK interna | Causation id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | ejemplo     |
| payload        | jsonb               | NO       | —                 | —          | Payload. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.        | ejemplo     |
| status         | varchar(24)         | NO       | —                 | —          | Status. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| owner_instance | varchar(120)        | NO       | —                 | —          | Owner instance. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |
| lease_until    | timestamptz         | SÍ       | —                 | —          | Lease until. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| attempt_count  | integer             | NO       | —                 | —          | Attempt count. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| occurred_at    | timestamptz         | NO       | now()             | —          | Occurred at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| published_at   | timestamptz         | SÍ       | —                 | —          | Published at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

event_id — Propósito: event id dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

aggregate_type — Propósito: aggregate type dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(80).

aggregate_id — Propósito: aggregate id dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

event_type — Propósito: event type dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(120).

schema_version — Propósito: schema version dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

correlation_id — Propósito: correlation id dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

causation_id — Propósito: causation id dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

payload — Propósito: payload dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: jsonb.

status — Propósito: status dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

owner_instance — Propósito: owner instance dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(120).

lease_until — Propósito: lease until dentro de ec12_outbox_event. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

attempt_count — Propósito: attempt count dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: integer.

occurred_at — Propósito: occurred at dentro de ec12_outbox_event. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

published_at — Propósito: published at dentro de ec12_outbox_event. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

| **Nombre físico**           | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|-----------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_outbox_event        | PK       | PRIMARY KEY (tenant_id,event_id)                                | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_outbox_event_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_outbox_event_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_outbox_event_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_outbox_event       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.28 ec12_inbox_message

QUÉ REPRESENTA — Deduplicación durable de mensajes consumidos. Esta tabla conserva únicamente hechos cuya autoridad pertenece a EC-12. Su semántica se interpreta dentro del tenant, framework/control/version y lifecycle correspondiente; no es una tabla genérica de “calidad”.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea o modifica el Application Service del aggregate, bajo transacción tenant-aware, autorización, If-Match cuando aplica, reason codes, audit y outbox. Workers de analytics/reconciliation operan mediante puertos; los módulos EC/CT externos consumen contratos, receipts o eventos y nunca acceden directamente al storage como API de integración.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad tenant-aware, versionado, as-of, lineage, evidence sufficiency, state, inmutabilidad y decisiones de quality assurance. No representa personas maestras, hechos académicos upstream, documentos binarios, datasets BI completos, texto legal autoritativo, contabilidad ni decisiones de RRHH.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**  | **Descripción**                                                                                     | **Ejemplo** |
|----------------|---------------------|----------|-------------------|------------|-----------------------------------------------------------------------------------------------------|-------------|
| tenant_id      | uuid                | NO       | —                 | PK\*       | Tenant id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.      | 8a6…        |
| message_id     | uuid                | NO       | gen_random_uuid() | PK         | Message id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| consumer_code  | varchar(120)        | NO       | —                 | —          | Consumer code. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.  | ejemplo     |
| event_type     | varchar(120)        | NO       | —                 | —          | Event type. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.     | ejemplo     |
| received_at    | timestamptz         | NO       | now()             | —          | Received at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.    | ejemplo     |
| processed_at   | timestamptz         | SÍ       | —                 | —          | Processed at. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | ejemplo     |
| status         | varchar(24)         | NO       | —                 | —          | Status. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.         | ejemplo     |
| payload_hash   | char(64)            | NO       | —                 | —          | Payload hash. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate.   | ejemplo     |
| correlation_id | uuid                | NO       | —                 | FK interna | Correlation id. Atributo del dominio EC-12 sujeto a lifecycle, tenant scope y policy del aggregate. | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec12_inbox_message. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

message_id — Propósito: message id dentro de ec12_inbox_message. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

consumer_code — Propósito: consumer code dentro de ec12_inbox_message. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(120).

event_type — Propósito: event type dentro de ec12_inbox_message. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(120).

received_at — Propósito: received at dentro de ec12_inbox_message. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

processed_at — Propósito: processed at dentro de ec12_inbox_message. Nulabilidad: permitida únicamente cuando el lifecycle o la semántica admiten ausencia legítima. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: timestamptz.

status — Propósito: status dentro de ec12_inbox_message. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: varchar(24).

payload_hash — Propósito: payload hash dentro de ec12_inbox_message. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: atributo de dominio. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: char(64).

correlation_id — Propósito: correlation id dentro de ec12_inbox_message. Nulabilidad: obligatoria para evitar estados ambiguos. Default: no se inventa un valor de negocio; solo IDs técnicos, timestamps de creación, booleanos seguros o revision pueden tener default explícito. Identidad/relación: participa en aislamiento tenant y PK/FK interna. Seguridad: RLS siempre; ABAC/purpose/field-level controls cuando contiene rationale, evidence o decision metadata. Validación: dominio y PostgreSQL cuando la invariante es físicamente representable. Ejemplo compatible con tipo: uuid.

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                        | **Error que impide**                                            |
|------------------------------|----------|-----------------------------------------------------------------|-----------------------------------------------------------------|
| pk_ec12_inbox_message        | PK       | PRIMARY KEY (tenant_id,message_id)                              | Impide identidad duplicada dentro del tenant.                   |
| ix_ec12_inbox_message_tenant | INDEX    | INDEX por tenant y principales claves de consulta               | Mantiene performance predecible y soporta filtros tenant-aware. |
| ck_ec12_inbox_message_domain | CHECK    | Checks de state/range/window/weight/result según tabla          | Impide estados o magnitudes imposibles.                         |
| trg_ec12_inbox_message_guard | TRIGGER  | Guard de inmutabilidad/append-only/lifecycle cuando corresponde | Impide reescritura histórica aun con bug Backend.               |
| rls_ec12_inbox_message       | RLS      | tenant_id = current_setting('peopleu.tenant_id',true)::uuid     | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant; child→parent de otro tenant; business keys duplicadas; weights/ranges/ventanas inválidas; states imposibles; alteración de framework/control/snapshot/attestation/gate ya publicados; evidence receipts modificados; waivers sin expiración; doble dedup/idempotency; y cualquier combinación que permita declarar PASS/APPROVED sin la estructura mínima físicamente verificable. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 13. DDL PostgreSQL completo — Flyway Ready

El DDL siguiente es baseline ejecutable y debe dividirse en migraciones Flyway por estrategia expand/contract. Las constraints de negocio complejas se complementan con funciones/trigger y tests Testcontainers sobre PostgreSQL real. No se utiliza un H2 “parecido” como sustituto de validación de RLS, locking, jsonb o partial indexes.

## 13.1 Bloque DDL

```
CREATE SCHEMA IF NOT EXISTS ec12;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Runtime contract: SET LOCAL peopleu.tenant_id = '<uuid>';
-- Runtime role: no ownership, no BYPASSRLS. Migration role separado.

CREATE TABLE IF NOT EXISTS ec12.ec12_quality_framework (
tenant_id uuid NOT NULL,
framework_id uuid NOT NULL DEFAULT gen_random_uuid(),
framework_code varchar(64) NOT NULL,
display_name varchar(240) NOT NULL,
lifecycle_state varchar(24) NOT NULL,
owner_scope_ref uuid NOT NULL,
default_language_code varchar(16) NOT NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_quality_framework PRIMARY KEY (tenant_id,framework_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_quality_framework_tenant ON ec12.ec12_quality_framework(tenant_id);
ALTER TABLE ec12.ec12_quality_framework ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_quality_framework FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_quality_framework_tenant ON ec12.ec12_quality_framework;
CREATE POLICY p_ec12_quality_framework_tenant ON ec12.ec12_quality_framework USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_framework_version (
tenant_id uuid NOT NULL,
framework_version_id uuid NOT NULL DEFAULT gen_random_uuid(),
framework_id uuid NOT NULL,
version_no integer NOT NULL,
state varchar(24) NOT NULL,
title varchar(240) NOT NULL,
effective_from timestamptz NOT NULL,
effective_to timestamptz,
scoring_method_code varchar(64) NOT NULL,
missing_data_policy_code varchar(64) NOT NULL,
minimum_coverage numeric(8 NOT NULL,
6) text NOT NULL,
content_hash char(64) NOT NULL,
previous_version_id uuid,
published_at timestamptz,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_framework_version PRIMARY KEY (tenant_id,framework_version_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_framework_version_tenant ON ec12.ec12_framework_version(tenant_id);
ALTER TABLE ec12.ec12_framework_version ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_framework_version FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_framework_version_tenant ON ec12.ec12_framework_version;
CREATE POLICY p_ec12_framework_version_tenant ON ec12.ec12_framework_version USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_quality_dimension (
tenant_id uuid NOT NULL,
dimension_id uuid NOT NULL DEFAULT gen_random_uuid(),
framework_version_id uuid NOT NULL,
dimension_code varchar(64) NOT NULL,
display_name varchar(240) NOT NULL,
description_text text NOT NULL,
weight numeric(10 NOT NULL,
8) text NOT NULL,
scoreable boolean NOT NULL DEFAULT false,
owner_scope_ref uuid NOT NULL,
sequence_no integer NOT NULL,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_quality_dimension PRIMARY KEY (tenant_id,dimension_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_quality_dimension_tenant ON ec12.ec12_quality_dimension(tenant_id);
ALTER TABLE ec12.ec12_quality_dimension ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_quality_dimension FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_quality_dimension_tenant ON ec12.ec12_quality_dimension;
CREATE POLICY p_ec12_quality_dimension_tenant ON ec12.ec12_quality_dimension USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_quality_control (
tenant_id uuid NOT NULL,
control_id uuid NOT NULL DEFAULT gen_random_uuid(),
control_code varchar(64) NOT NULL,
control_family_code varchar(64) NOT NULL,
display_name varchar(240) NOT NULL,
lifecycle_state varchar(24) NOT NULL,
owner_scope_ref uuid NOT NULL,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_quality_control PRIMARY KEY (tenant_id,control_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_quality_control_tenant ON ec12.ec12_quality_control(tenant_id);
ALTER TABLE ec12.ec12_quality_control ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_quality_control FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_quality_control_tenant ON ec12.ec12_quality_control;
CREATE POLICY p_ec12_quality_control_tenant ON ec12.ec12_quality_control USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_control_version (
tenant_id uuid NOT NULL,
control_version_id uuid NOT NULL DEFAULT gen_random_uuid(),
control_id uuid NOT NULL,
version_no integer NOT NULL,
state varchar(24) NOT NULL,
objective_text text NOT NULL,
test_method_code varchar(80) NOT NULL,
severity_code varchar(24) NOT NULL,
frequency_code varchar(40) NOT NULL,
applicability_rule_ref uuid NOT NULL,
dimension_code varchar(64) NOT NULL,
waivable boolean NOT NULL DEFAULT false,
effective_from timestamptz NOT NULL,
effective_to timestamptz,
content_hash char(64) NOT NULL,
previous_version_id uuid,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_control_version PRIMARY KEY (tenant_id,control_version_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_control_version_tenant ON ec12.ec12_control_version(tenant_id);
ALTER TABLE ec12.ec12_control_version ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_control_version FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_control_version_tenant ON ec12.ec12_control_version;
CREATE POLICY p_ec12_control_version_tenant ON ec12.ec12_control_version USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_evidence_requirement (
tenant_id uuid NOT NULL,
evidence_requirement_id uuid NOT NULL DEFAULT gen_random_uuid(),
control_version_id uuid,
requirement_code varchar(64) NOT NULL,
evidence_type_code varchar(80) NOT NULL,
mandatory boolean NOT NULL DEFAULT false,
freshness_max_age_days integer NOT NULL,
classification_code varchar(32) NOT NULL,
hash_required boolean NOT NULL DEFAULT false,
minimum_count integer NOT NULL,
sequence_no integer NOT NULL,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_evidence_requirement PRIMARY KEY (tenant_id,evidence_requirement_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_evidence_requirement_tenant ON ec12.ec12_evidence_requirement(tenant_id);
ALTER TABLE ec12.ec12_evidence_requirement ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_evidence_requirement FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_evidence_requirement_tenant ON ec12.ec12_evidence_requirement;
CREATE POLICY p_ec12_evidence_requirement_tenant ON ec12.ec12_evidence_requirement USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_compliance_binding (
tenant_id uuid NOT NULL,
binding_id uuid NOT NULL DEFAULT gen_random_uuid(),
binding_code varchar(64) NOT NULL,
obligation_ref uuid NOT NULL,
obligation_version_ref uuid NOT NULL,
authority_ref uuid NOT NULL,
control_version_id uuid,
applicability_rule_ref uuid NOT NULL,
scope_type varchar(40) NOT NULL,
effective_from timestamptz NOT NULL,
effective_to timestamptz,
non_waivable boolean NOT NULL DEFAULT false,
state varchar(24) NOT NULL,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_compliance_binding PRIMARY KEY (tenant_id,binding_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_compliance_binding_tenant ON ec12.ec12_compliance_binding(tenant_id);
ALTER TABLE ec12.ec12_compliance_binding ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_compliance_binding FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_compliance_binding_tenant ON ec12.ec12_compliance_binding;
CREATE POLICY p_ec12_compliance_binding_tenant ON ec12.ec12_compliance_binding USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_review_cycle (
tenant_id uuid NOT NULL,
review_cycle_id uuid NOT NULL DEFAULT gen_random_uuid(),
review_code varchar(64) NOT NULL,
framework_version_id uuid NOT NULL,
review_type_code varchar(64) NOT NULL,
period_start date NOT NULL,
period_end date NOT NULL,
evidence_watermark timestamptz NOT NULL,
state varchar(24) NOT NULL,
owner_scope_ref uuid NOT NULL,
lead_reviewer_ref uuid NOT NULL,
assurance_level_code varchar(32) NOT NULL,
planned_at timestamptz NOT NULL,
started_at timestamptz,
closed_at timestamptz,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_review_cycle PRIMARY KEY (tenant_id,review_cycle_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_review_cycle_tenant ON ec12.ec12_review_cycle(tenant_id);
ALTER TABLE ec12.ec12_review_cycle ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_review_cycle FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_review_cycle_tenant ON ec12.ec12_review_cycle;
CREATE POLICY p_ec12_review_cycle_tenant ON ec12.ec12_review_cycle USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_review_scope (
tenant_id uuid NOT NULL,
review_scope_id uuid NOT NULL DEFAULT gen_random_uuid(),
review_cycle_id uuid,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
scope_label_snapshot varchar(240) NOT NULL,
source_version_ref uuid,
applicability_snapshot_hash char(64) NOT NULL,
included boolean NOT NULL DEFAULT false,
exclusion_reason_code varchar(80),
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_review_scope PRIMARY KEY (tenant_id,review_scope_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_review_scope_tenant ON ec12.ec12_review_scope(tenant_id);
ALTER TABLE ec12.ec12_review_scope ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_review_scope FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_review_scope_tenant ON ec12.ec12_review_scope;
CREATE POLICY p_ec12_review_scope_tenant ON ec12.ec12_review_scope USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_control_assessment (
tenant_id uuid NOT NULL,
assessment_id uuid NOT NULL DEFAULT gen_random_uuid(),
review_cycle_id uuid,
review_scope_id uuid,
control_version_id uuid,
state varchar(24) NOT NULL,
result varchar(24) NOT NULL,
assurance_level_code varchar(32) NOT NULL,
rationale_text text NOT NULL,
assessed_by_subject uuid NOT NULL,
reviewed_by_subject uuid,
evidence_watermark timestamptz NOT NULL,
policy_version_ref uuid NOT NULL,
assessed_at timestamptz NOT NULL,
```

## 13.2 Bloque DDL

```
locked_at timestamptz,
supersedes_assessment_id uuid,
content_hash char(64) NOT NULL,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_control_assessment PRIMARY KEY (tenant_id,assessment_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_control_assessment_tenant ON ec12.ec12_control_assessment(tenant_id);
ALTER TABLE ec12.ec12_control_assessment ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_control_assessment FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_control_assessment_tenant ON ec12.ec12_control_assessment;
CREATE POLICY p_ec12_control_assessment_tenant ON ec12.ec12_control_assessment USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_control_evidence_receipt (
tenant_id uuid NOT NULL,
evidence_receipt_id uuid NOT NULL DEFAULT gen_random_uuid(),
assessment_id uuid NOT NULL,
evidence_requirement_id uuid NOT NULL,
artifact_ref uuid,
source_event_ref uuid,
dataset_ref uuid,
content_hash char(64) NOT NULL,
classification_code varchar(32) NOT NULL,
collected_by_subject uuid NOT NULL,
occurred_at timestamptz NOT NULL DEFAULT now(),
collected_at timestamptz NOT NULL,
freshness_state varchar(24) NOT NULL,
verification_state varchar(24) NOT NULL,
CONSTRAINT pk_ec12_control_evidence_receipt PRIMARY KEY (tenant_id,evidence_receipt_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_control_evidence_receipt_tenant ON ec12.ec12_control_evidence_receipt(tenant_id);
ALTER TABLE ec12.ec12_control_evidence_receipt ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_control_evidence_receipt FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_control_evidence_receipt_tenant ON ec12.ec12_control_evidence_receipt;
CREATE POLICY p_ec12_control_evidence_receipt_tenant ON ec12.ec12_control_evidence_receipt USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_nonconformity (
tenant_id uuid NOT NULL,
nonconformity_id uuid NOT NULL DEFAULT gen_random_uuid(),
nc_code varchar(64) NOT NULL,
source_type varchar(40) NOT NULL,
source_ref uuid,
review_cycle_id uuid,
review_scope_id uuid,
control_version_id uuid,
severity_code varchar(24) NOT NULL,
state varchar(24) NOT NULL,
title varchar(240) NOT NULL,
description_text text NOT NULL,
detected_at timestamptz NOT NULL DEFAULT now(),
detected_by_subject uuid NOT NULL,
owner_subject_ref uuid,
root_cause_ref uuid,
target_resolution_at timestamptz,
accepted_risk_ref uuid,
resolved_at timestamptz,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_nonconformity PRIMARY KEY (tenant_id,nonconformity_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_nonconformity_tenant ON ec12.ec12_nonconformity(tenant_id);
ALTER TABLE ec12.ec12_nonconformity ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_nonconformity FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_nonconformity_tenant ON ec12.ec12_nonconformity;
CREATE POLICY p_ec12_nonconformity_tenant ON ec12.ec12_nonconformity USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_capa_plan (
tenant_id uuid NOT NULL,
capa_plan_id uuid NOT NULL DEFAULT gen_random_uuid(),
nonconformity_id uuid NOT NULL,
plan_code varchar(64) NOT NULL,
root_cause_summary text NOT NULL,
corrective_strategy text NOT NULL,
preventive_strategy text,
effectiveness_metric_ref uuid,
baseline_snapshot_ref uuid,
target_value numeric(18,
6) text NOT NULL,
target_unit_code varchar(32),
target_date date NOT NULL,
state varchar(24) NOT NULL,
approved_by_subject uuid,
approved_at timestamptz,
effectiveness_result varchar(24) NOT NULL,
verified_by_subject uuid,
verified_at timestamptz,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_capa_plan PRIMARY KEY (tenant_id,capa_plan_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_capa_plan_tenant ON ec12.ec12_capa_plan(tenant_id);
ALTER TABLE ec12.ec12_capa_plan ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_capa_plan FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_capa_plan_tenant ON ec12.ec12_capa_plan;
CREATE POLICY p_ec12_capa_plan_tenant ON ec12.ec12_capa_plan USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_corrective_action (
tenant_id uuid NOT NULL,
corrective_action_id uuid NOT NULL DEFAULT gen_random_uuid(),
capa_plan_id uuid NOT NULL,
action_code varchar(64) NOT NULL,
action_type_code varchar(40) NOT NULL,
description_text text NOT NULL,
owner_subject_ref uuid,
owner_context_ref uuid,
due_at timestamptz,
state varchar(24) NOT NULL,
completion_receipt_ref uuid,
completion_evidence_ref uuid,
completed_at timestamptz,
verified_by_subject uuid,
verified_at timestamptz,
sequence_no integer NOT NULL,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_corrective_action PRIMARY KEY (tenant_id,corrective_action_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_corrective_action_tenant ON ec12.ec12_corrective_action(tenant_id);
ALTER TABLE ec12.ec12_corrective_action ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_corrective_action FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_corrective_action_tenant ON ec12.ec12_corrective_action;
CREATE POLICY p_ec12_corrective_action_tenant ON ec12.ec12_corrective_action USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_improvement_initiative (
tenant_id uuid NOT NULL,
initiative_id uuid NOT NULL DEFAULT gen_random_uuid(),
initiative_code varchar(64) NOT NULL,
title varchar(240) NOT NULL,
problem_statement text NOT NULL,
hypothesis_text text NOT NULL,
source_signal_type varchar(40) NOT NULL,
source_signal_ref uuid,
priority_score numeric(12 NOT NULL,
6) text NOT NULL,
owner_scope_ref uuid NOT NULL,
owner_subject_ref uuid,
state varchar(24) NOT NULL,
proposed_at timestamptz NOT NULL,
target_horizon_at timestamptz,
adopted_at timestamptz,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_improvement_initiative PRIMARY KEY (tenant_id,initiative_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_improvement_initiative_tenant ON ec12.ec12_improvement_initiative(tenant_id);
ALTER TABLE ec12.ec12_improvement_initiative ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_improvement_initiative FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_improvement_initiative_tenant ON ec12.ec12_improvement_initiative;
CREATE POLICY p_ec12_improvement_initiative_tenant ON ec12.ec12_improvement_initiative USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_improvement_experiment (
tenant_id uuid NOT NULL,
experiment_id uuid NOT NULL DEFAULT gen_random_uuid(),
initiative_id uuid NOT NULL,
experiment_code varchar(64) NOT NULL,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
primary_indicator_ref uuid NOT NULL,
indicator_version_ref uuid NOT NULL,
baseline_snapshot_ref uuid,
baseline_value numeric(18,
6) text NOT NULL,
target_value numeric(18,
6) text NOT NULL,
unit_code varchar(32) NOT NULL,
starts_at timestamptz NOT NULL,
ends_at timestamptz,
state varchar(24) NOT NULL,
decision varchar(24),
outcome_snapshot_ref uuid,
conclusion_text text,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_improvement_experiment PRIMARY KEY (tenant_id,experiment_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_improvement_experiment_tenant ON ec12.ec12_improvement_experiment(tenant_id);
ALTER TABLE ec12.ec12_improvement_experiment ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_improvement_experiment FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_improvement_experiment_tenant ON ec12.ec12_improvement_experiment;
CREATE POLICY p_ec12_improvement_experiment_tenant ON ec12.ec12_improvement_experiment USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_indicator_definition (
tenant_id uuid NOT NULL,
indicator_id uuid NOT NULL DEFAULT gen_random_uuid(),
indicator_code varchar(64) NOT NULL,
version_no integer NOT NULL,
state varchar(24) NOT NULL,
display_name varchar(240) NOT NULL,
dimension_code varchar(64) NOT NULL,
grain_code varchar(64) NOT NULL,
unit_code varchar(32) NOT NULL,
direction_code varchar(16) NOT NULL,
window_code varchar(40) NOT NULL,
dataset_contract_ref uuid NOT NULL,
formula_dsl_version varchar(32) NOT NULL,
formula_expression text NOT NULL,
calculator_version varchar(40) NOT NULL,
missing_data_policy_code varchar(64) NOT NULL,
comparability_group varchar(64) NOT NULL,
effective_from timestamptz NOT NULL,
effective_to timestamptz,
content_hash char(64) NOT NULL,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_indicator_definition PRIMARY KEY (tenant_id,indicator_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_indicator_definition_tenant ON ec12.ec12_indicator_definition(tenant_id);
ALTER TABLE ec12.ec12_indicator_definition ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_indicator_definition FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_indicator_definition_tenant ON ec12.ec12_indicator_definition;
CREATE POLICY p_ec12_indicator_definition_tenant ON ec12.ec12_indicator_definition USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_indicator_threshold (
tenant_id uuid NOT NULL,
threshold_id uuid NOT NULL DEFAULT gen_random_uuid(),
indicator_id uuid NOT NULL,
threshold_code varchar(64) NOT NULL,
scope_rule_ref uuid NOT NULL,
lower_bound numeric(18 NOT NULL,
6) text NOT NULL,
upper_bound numeric(18 NOT NULL,
6) text NOT NULL,
lower_inclusive boolean NOT NULL DEFAULT false,
upper_inclusive boolean NOT NULL DEFAULT false,
quality_band varchar(24),
severity_code varchar(24) NOT NULL,
sequence_no integer NOT NULL,
effective_from timestamptz NOT NULL,
effective_to timestamptz,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_indicator_threshold PRIMARY KEY (tenant_id,threshold_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_indicator_threshold_tenant ON ec12.ec12_indicator_threshold(tenant_id);
ALTER TABLE ec12.ec12_indicator_threshold ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_indicator_threshold FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_indicator_threshold_tenant ON ec12.ec12_indicator_threshold;
```

## 13.3 Bloque DDL

```
CREATE POLICY p_ec12_indicator_threshold_tenant ON ec12.ec12_indicator_threshold USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_indicator_snapshot (
tenant_id uuid NOT NULL,
indicator_snapshot_id uuid NOT NULL DEFAULT gen_random_uuid(),
indicator_id uuid NOT NULL,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
period_start date NOT NULL,
period_end date NOT NULL,
as_of timestamptz NOT NULL,
dataset_ref uuid,
dataset_version_ref uuid NOT NULL,
input_watermark timestamptz NOT NULL,
value_numeric numeric(18,
6) text NOT NULL,
value_text varchar(400),
unit_code varchar(32) NOT NULL,
quality_state varchar(24) NOT NULL,
quality_band varchar(24),
freshness_state varchar(24) NOT NULL,
calculator_version varchar(40) NOT NULL,
content_hash char(64) NOT NULL,
built_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec12_indicator_snapshot PRIMARY KEY (tenant_id,indicator_snapshot_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_indicator_snapshot_tenant ON ec12.ec12_indicator_snapshot(tenant_id);
ALTER TABLE ec12.ec12_indicator_snapshot ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_indicator_snapshot FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_indicator_snapshot_tenant ON ec12.ec12_indicator_snapshot;
CREATE POLICY p_ec12_indicator_snapshot_tenant ON ec12.ec12_indicator_snapshot USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_portfolio_health_snapshot (
tenant_id uuid NOT NULL,
health_snapshot_id uuid NOT NULL DEFAULT gen_random_uuid(),
framework_version_id uuid NOT NULL,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
period_start date NOT NULL,
period_end date NOT NULL,
input_watermark timestamptz NOT NULL,
coverage_ratio numeric(10 NOT NULL,
8) text NOT NULL,
health_score numeric(10 NOT NULL,
6) text NOT NULL,
health_band varchar(24) NOT NULL,
dimension_scores_json jsonb NOT NULL,
missing_data_policy_code varchar(64) NOT NULL,
calculator_version varchar(40) NOT NULL,
content_hash char(64) NOT NULL,
status varchar(24) NOT NULL,
built_at timestamptz NOT NULL DEFAULT now(),
approved_by_subject uuid,
approved_at timestamptz,
supersedes_snapshot_id uuid,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_portfolio_health_snapshot PRIMARY KEY (tenant_id,health_snapshot_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_portfolio_health_snapshot_tenant ON ec12.ec12_portfolio_health_snapshot(tenant_id);
ALTER TABLE ec12.ec12_portfolio_health_snapshot ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_portfolio_health_snapshot FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_portfolio_health_snapshot_tenant ON ec12.ec12_portfolio_health_snapshot;
CREATE POLICY p_ec12_portfolio_health_snapshot_tenant ON ec12.ec12_portfolio_health_snapshot USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_quality_scorecard_snapshot (
tenant_id uuid NOT NULL,
scorecard_snapshot_id uuid NOT NULL DEFAULT gen_random_uuid(),
framework_version_id uuid NOT NULL,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
report_profile_ref uuid,
purpose_ref uuid,
period_start date NOT NULL,
period_end date NOT NULL,
input_watermark timestamptz NOT NULL,
status varchar(24) NOT NULL,
summary_json jsonb NOT NULL,
artifact_ref uuid,
content_hash char(64) NOT NULL,
built_at timestamptz NOT NULL DEFAULT now(),
approved_by_subject uuid,
approved_at timestamptz,
published_at timestamptz,
supersedes_snapshot_id uuid,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_quality_scorecard_snapshot PRIMARY KEY (tenant_id,scorecard_snapshot_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_quality_scorecard_snapshot_tenant ON ec12.ec12_quality_scorecard_snapshot(tenant_id);
ALTER TABLE ec12.ec12_quality_scorecard_snapshot ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_quality_scorecard_snapshot FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_quality_scorecard_snapshot_tenant ON ec12.ec12_quality_scorecard_snapshot;
CREATE POLICY p_ec12_quality_scorecard_snapshot_tenant ON ec12.ec12_quality_scorecard_snapshot USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_compliance_attestation (
tenant_id uuid NOT NULL,
attestation_id uuid NOT NULL DEFAULT gen_random_uuid(),
binding_id uuid,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
result varchar(24) NOT NULL,
state varchar(24) NOT NULL,
evidence_watermark timestamptz NOT NULL,
evidence_set_hash char(64) NOT NULL,
rationale_text text NOT NULL,
reviewer_subject_ref uuid NOT NULL,
approver_subject_ref uuid,
as_of timestamptz NOT NULL,
expires_at timestamptz,
approved_at timestamptz,
supersedes_attestation_id uuid,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_compliance_attestation PRIMARY KEY (tenant_id,attestation_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_compliance_attestation_tenant ON ec12.ec12_compliance_attestation(tenant_id);
ALTER TABLE ec12.ec12_compliance_attestation ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_compliance_attestation FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_compliance_attestation_tenant ON ec12.ec12_compliance_attestation;
CREATE POLICY p_ec12_compliance_attestation_tenant ON ec12.ec12_compliance_attestation USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_exception_waiver (
tenant_id uuid NOT NULL,
waiver_id uuid NOT NULL DEFAULT gen_random_uuid(),
waiver_code varchar(64) NOT NULL,
control_version_id uuid,
binding_id uuid,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
reason_code varchar(80) NOT NULL,
rationale_text text NOT NULL,
risk_severity_code varchar(24) NOT NULL,
residual_risk_code varchar(24) NOT NULL,
compensating_controls_json jsonb NOT NULL,
state varchar(24) NOT NULL,
requested_by_subject uuid NOT NULL,
approved_by_subject uuid,
starts_at timestamptz NOT NULL,
expires_at timestamptz,
revoked_at timestamptz,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_exception_waiver PRIMARY KEY (tenant_id,waiver_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_exception_waiver_tenant ON ec12.ec12_exception_waiver(tenant_id);
ALTER TABLE ec12.ec12_exception_waiver ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_exception_waiver FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_exception_waiver_tenant ON ec12.ec12_exception_waiver;
CREATE POLICY p_ec12_exception_waiver_tenant ON ec12.ec12_exception_waiver USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_quality_alert (
tenant_id uuid NOT NULL,
alert_id uuid NOT NULL DEFAULT gen_random_uuid(),
alert_code varchar(64) NOT NULL,
alert_type varchar(40) NOT NULL,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
source_ref uuid,
severity_code varchar(24) NOT NULL,
state varchar(24) NOT NULL,
dedup_key varchar(160) NOT NULL,
detected_at timestamptz NOT NULL DEFAULT now(),
acknowledged_by_subject uuid,
acknowledged_at timestamptz,
owner_subject_ref uuid,
due_at timestamptz,
resolution_code varchar(80),
resolved_at timestamptz,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_quality_alert PRIMARY KEY (tenant_id,alert_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_quality_alert_tenant ON ec12.ec12_quality_alert(tenant_id);
ALTER TABLE ec12.ec12_quality_alert ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_quality_alert FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_quality_alert_tenant ON ec12.ec12_quality_alert;
CREATE POLICY p_ec12_quality_alert_tenant ON ec12.ec12_quality_alert USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_quality_gate_assessment (
tenant_id uuid NOT NULL,
gate_assessment_id uuid NOT NULL DEFAULT gen_random_uuid(),
gate_request_key varchar(160) NOT NULL,
gate_code varchar(64) NOT NULL,
framework_version_id uuid NOT NULL,
scope_type varchar(40) NOT NULL,
scope_ref uuid,
state varchar(24) NOT NULL,
result varchar(24) NOT NULL,
evidence_watermark timestamptz NOT NULL,
mandatory_fail_count integer NOT NULL,
conditional_count integer NOT NULL,
decision_reason_code varchar(80) NOT NULL,
decided_by_subject uuid,
decided_at timestamptz,
decision_hash char(64) NOT NULL,
supersedes_gate_assessment_id uuid,
revision bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec12_quality_gate_assessment PRIMARY KEY (tenant_id,gate_assessment_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_quality_gate_assessment_tenant ON ec12.ec12_quality_gate_assessment(tenant_id);
ALTER TABLE ec12.ec12_quality_gate_assessment ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_quality_gate_assessment FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_quality_gate_assessment_tenant ON ec12.ec12_quality_gate_assessment;
CREATE POLICY p_ec12_quality_gate_assessment_tenant ON ec12.ec12_quality_gate_assessment USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_idempotency_record (
tenant_id uuid NOT NULL,
idempotency_id uuid NOT NULL DEFAULT gen_random_uuid(),
idempotency_key varchar(160) NOT NULL,
command_scope varchar(120) NOT NULL,
request_hash char(64) NOT NULL,
status varchar(24) NOT NULL,
owner_instance varchar(120) NOT NULL,
lease_until timestamptz,
response_ref uuid,
response_snapshot jsonb,
attempt_count integer NOT NULL,
updated_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec12_idempotency_record PRIMARY KEY (tenant_id,idempotency_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_idempotency_record_tenant ON ec12.ec12_idempotency_record(tenant_id);
ALTER TABLE ec12.ec12_idempotency_record ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_idempotency_record FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_idempotency_record_tenant ON ec12.ec12_idempotency_record;
CREATE POLICY p_ec12_idempotency_record_tenant ON ec12.ec12_idempotency_record USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_outbox_event (
tenant_id uuid NOT NULL,
event_id uuid NOT NULL DEFAULT gen_random_uuid(),
aggregate_type varchar(80) NOT NULL,
aggregate_id uuid NOT NULL,
event_type varchar(120) NOT NULL,
```

## 13.4 Bloque DDL

```
schema_version integer NOT NULL,
correlation_id uuid NOT NULL,
causation_id uuid NOT NULL,
payload jsonb NOT NULL,
status varchar(24) NOT NULL,
owner_instance varchar(120) NOT NULL,
lease_until timestamptz,
attempt_count integer NOT NULL,
occurred_at timestamptz NOT NULL DEFAULT now(),
published_at timestamptz,
CONSTRAINT pk_ec12_outbox_event PRIMARY KEY (tenant_id,event_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_outbox_event_tenant ON ec12.ec12_outbox_event(tenant_id);
ALTER TABLE ec12.ec12_outbox_event ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_outbox_event FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_outbox_event_tenant ON ec12.ec12_outbox_event;
CREATE POLICY p_ec12_outbox_event_tenant ON ec12.ec12_outbox_event USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

CREATE TABLE IF NOT EXISTS ec12.ec12_inbox_message (
tenant_id uuid NOT NULL,
message_id uuid NOT NULL DEFAULT gen_random_uuid(),
consumer_code varchar(120) NOT NULL,
event_type varchar(120) NOT NULL,
received_at timestamptz NOT NULL DEFAULT now(),
processed_at timestamptz,
status varchar(24) NOT NULL,
payload_hash char(64) NOT NULL,
correlation_id uuid NOT NULL,
CONSTRAINT pk_ec12_inbox_message PRIMARY KEY (tenant_id,message_id)
);
CREATE INDEX IF NOT EXISTS ix_ec12_inbox_message_tenant ON ec12.ec12_inbox_message(tenant_id);
ALTER TABLE ec12.ec12_inbox_message ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec12.ec12_inbox_message FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec12_inbox_message_tenant ON ec12.ec12_inbox_message;
CREATE POLICY p_ec12_inbox_message_tenant ON ec12.ec12_inbox_message USING (tenant_id = current_setting('peopleu.tenant_id',true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id',true)::uuid);

-- Internal tenant-aware FKs
ALTER TABLE ec12.ec12_framework_version ADD CONSTRAINT fk_ec12_framework_version_framework FOREIGN KEY (tenant_id,framework_id) REFERENCES ec12.ec12_quality_framework(tenant_id,framework_id);
ALTER TABLE ec12.ec12_quality_dimension ADD CONSTRAINT fk_ec12_dimension_framework_version FOREIGN KEY (tenant_id,framework_version_id) REFERENCES ec12.ec12_framework_version(tenant_id,framework_version_id);
ALTER TABLE ec12.ec12_control_version ADD CONSTRAINT fk_ec12_control_version_control FOREIGN KEY (tenant_id,control_id) REFERENCES ec12.ec12_quality_control(tenant_id,control_id);
ALTER TABLE ec12.ec12_evidence_requirement ADD CONSTRAINT fk_ec12_evidence_req_control_version FOREIGN KEY (tenant_id,control_version_id) REFERENCES ec12.ec12_control_version(tenant_id,control_version_id);
ALTER TABLE ec12.ec12_compliance_binding ADD CONSTRAINT fk_ec12_binding_control_version FOREIGN KEY (tenant_id,control_version_id) REFERENCES ec12.ec12_control_version(tenant_id,control_version_id);
ALTER TABLE ec12.ec12_review_cycle ADD CONSTRAINT fk_ec12_review_framework_version FOREIGN KEY (tenant_id,framework_version_id) REFERENCES ec12.ec12_framework_version(tenant_id,framework_version_id);
ALTER TABLE ec12.ec12_review_scope ADD CONSTRAINT fk_ec12_scope_review FOREIGN KEY (tenant_id,review_cycle_id) REFERENCES ec12.ec12_review_cycle(tenant_id,review_cycle_id);
ALTER TABLE ec12.ec12_control_assessment ADD CONSTRAINT fk_ec12_assessment_review FOREIGN KEY (tenant_id,review_cycle_id) REFERENCES ec12.ec12_review_cycle(tenant_id,review_cycle_id);
ALTER TABLE ec12.ec12_control_assessment ADD CONSTRAINT fk_ec12_assessment_scope FOREIGN KEY (tenant_id,review_scope_id) REFERENCES ec12.ec12_review_scope(tenant_id,review_scope_id);
ALTER TABLE ec12.ec12_control_assessment ADD CONSTRAINT fk_ec12_assessment_control_version FOREIGN KEY (tenant_id,control_version_id) REFERENCES ec12.ec12_control_version(tenant_id,control_version_id);
ALTER TABLE ec12.ec12_control_evidence_receipt ADD CONSTRAINT fk_ec12_evidence_assessment FOREIGN KEY (tenant_id,assessment_id) REFERENCES ec12.ec12_control_assessment(tenant_id,assessment_id);
ALTER TABLE ec12.ec12_nonconformity ADD CONSTRAINT fk_ec12_nc_review FOREIGN KEY (tenant_id,review_cycle_id) REFERENCES ec12.ec12_review_cycle(tenant_id,review_cycle_id);
ALTER TABLE ec12.ec12_capa_plan ADD CONSTRAINT fk_ec12_capa_nc FOREIGN KEY (tenant_id,nonconformity_id) REFERENCES ec12.ec12_nonconformity(tenant_id,nonconformity_id);
ALTER TABLE ec12.ec12_corrective_action ADD CONSTRAINT fk_ec12_action_capa FOREIGN KEY (tenant_id,capa_plan_id) REFERENCES ec12.ec12_capa_plan(tenant_id,capa_plan_id);
ALTER TABLE ec12.ec12_improvement_experiment ADD CONSTRAINT fk_ec12_experiment_initiative FOREIGN KEY (tenant_id,initiative_id) REFERENCES ec12.ec12_improvement_initiative(tenant_id,initiative_id);
ALTER TABLE ec12.ec12_indicator_threshold ADD CONSTRAINT fk_ec12_threshold_indicator FOREIGN KEY (tenant_id,indicator_id) REFERENCES ec12.ec12_indicator_definition(tenant_id,indicator_id);
ALTER TABLE ec12.ec12_indicator_snapshot ADD CONSTRAINT fk_ec12_snapshot_indicator FOREIGN KEY (tenant_id,indicator_id) REFERENCES ec12.ec12_indicator_definition(tenant_id,indicator_id);
ALTER TABLE ec12.ec12_compliance_attestation ADD CONSTRAINT fk_ec12_attestation_binding FOREIGN KEY (tenant_id,binding_id) REFERENCES ec12.ec12_compliance_binding(tenant_id,binding_id);

-- Core semantic checks
ALTER TABLE ec12.ec12_framework_version ADD CONSTRAINT ck_ec12_framework_version_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','PUBLISHED','SUPERSEDED','VOID'));
ALTER TABLE ec12.ec12_framework_version ADD CONSTRAINT ck_ec12_framework_min_coverage CHECK (minimum_coverage BETWEEN 0 AND 1);
ALTER TABLE ec12.ec12_quality_dimension ADD CONSTRAINT ck_ec12_dimension_weight CHECK (weight >= 0 AND weight <= 1);
ALTER TABLE ec12.ec12_control_version ADD CONSTRAINT ck_ec12_control_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','PUBLISHED','RETIRED','VOID'));
ALTER TABLE ec12.ec12_evidence_requirement ADD CONSTRAINT ck_ec12_evidence_age CHECK (freshness_max_age_days IS NULL OR freshness_max_age_days >= 0);
ALTER TABLE ec12.ec12_evidence_requirement ADD CONSTRAINT ck_ec12_evidence_count CHECK (minimum_count >= 0);
ALTER TABLE ec12.ec12_review_cycle ADD CONSTRAINT ck_ec12_review_period CHECK (period_end >= period_start);
ALTER TABLE ec12.ec12_review_cycle ADD CONSTRAINT ck_ec12_review_state CHECK (state IN ('DRAFT','PLANNED','IN_PROGRESS','EVIDENCE_FROZEN','REVIEWED','CLOSED','CANCELLED'));
ALTER TABLE ec12.ec12_control_assessment ADD CONSTRAINT ck_ec12_assessment_state CHECK (state IN ('NOT_ASSESSED','IN_PROGRESS','READY_FOR_REVIEW','LOCKED','VOID'));
ALTER TABLE ec12.ec12_control_assessment ADD CONSTRAINT ck_ec12_assessment_result CHECK (result IN ('NOT_ASSESSED','PASS','PARTIAL','FAIL','NOT_APPLICABLE','VOID'));
ALTER TABLE ec12.ec12_control_assessment ADD CONSTRAINT ck_ec12_assessment_locked_result CHECK (state <> 'LOCKED' OR result IN ('PASS','PARTIAL','FAIL','NOT_APPLICABLE'));
ALTER TABLE ec12.ec12_nonconformity ADD CONSTRAINT ck_ec12_nc_state CHECK (state IN ('OPEN','TRIAGED','ACTION_PLANNED','IN_REMEDIATION','VERIFYING','CLOSED','ACCEPTED_RISK','VOID'));
ALTER TABLE ec12.ec12_capa_plan ADD CONSTRAINT ck_ec12_capa_state CHECK (state IN ('DRAFT','APPROVED','ACTIVE','VERIFYING','EFFECTIVE','INEFFECTIVE','CANCELLED'));
ALTER TABLE ec12.ec12_corrective_action ADD CONSTRAINT ck_ec12_action_state CHECK (state IN ('TODO','IN_PROGRESS','READY_FOR_VERIFY','VERIFIED','REJECTED','CANCELLED'));
ALTER TABLE ec12.ec12_improvement_experiment ADD CONSTRAINT ck_ec12_experiment_window CHECK (ends_at IS NULL OR ends_at > starts_at);
ALTER TABLE ec12.ec12_indicator_definition ADD CONSTRAINT ck_ec12_indicator_direction CHECK (direction_code IN ('HIGHER_BETTER','LOWER_BETTER','TARGET_RANGE','INFORMATIONAL'));
ALTER TABLE ec12.ec12_indicator_threshold ADD CONSTRAINT ck_ec12_threshold_range CHECK (lower_bound IS NULL OR upper_bound IS NULL OR lower_bound <= upper_bound);
ALTER TABLE ec12.ec12_portfolio_health_snapshot ADD CONSTRAINT ck_ec12_health_coverage CHECK (coverage_ratio BETWEEN 0 AND 1);
ALTER TABLE ec12.ec12_exception_waiver ADD CONSTRAINT ck_ec12_waiver_window CHECK (expires_at > starts_at);
ALTER TABLE ec12.ec12_quality_gate_assessment ADD CONSTRAINT ck_ec12_gate_result CHECK (result IN ('PENDING','PASS','CONDITIONAL','FAIL','VOID'));
ALTER TABLE ec12.ec12_quality_gate_assessment ADD CONSTRAINT ck_ec12_gate_counts CHECK (mandatory_fail_count >= 0 AND conditional_count >= 0);

-- Business uniqueness
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_framework_code ON ec12.ec12_quality_framework(tenant_id,framework_code);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_framework_version_no ON ec12.ec12_framework_version(tenant_id,framework_id,version_no);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_dimension_code ON ec12.ec12_quality_dimension(tenant_id,framework_version_id,dimension_code);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_control_code ON ec12.ec12_quality_control(tenant_id,control_code);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_control_version_no ON ec12.ec12_control_version(tenant_id,control_id,version_no);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_evidence_req_code ON ec12.ec12_evidence_requirement(tenant_id,control_version_id,requirement_code);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_review_code ON ec12.ec12_review_cycle(tenant_id,review_code);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_assessment_one_control_scope ON ec12.ec12_control_assessment(tenant_id,review_cycle_id,review_scope_id,control_version_id) WHERE state <> 'VOID';
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_nc_code ON ec12.ec12_nonconformity(tenant_id,nc_code);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_indicator_code_version ON ec12.ec12_indicator_definition(tenant_id,indicator_code,version_no);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_gate_request ON ec12.ec12_quality_gate_assessment(tenant_id,gate_request_key);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_idempotency_key ON ec12.ec12_idempotency_record(tenant_id,command_scope,idempotency_key);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_inbox_dedup ON ec12.ec12_inbox_message(tenant_id,consumer_code,message_id);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec12_alert_dedup_active ON ec12.ec12_quality_alert(tenant_id,dedup_key) WHERE state IN ('OPEN','ACKNOWLEDGED','INVESTIGATING');

-- Published snapshot immutability
CREATE OR REPLACE FUNCTION ec12.guard_immutable_terminal() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
IF TG_OP='DELETE' THEN RAISE EXCEPTION 'EC12_TERMINAL_FACT_DELETE_FORBIDDEN'; END IF;
IF OLD.state IN ('PUBLISHED','SUPERSEDED','APPROVED','CLOSED','EFFECTIVE') AND ROW(NEW.*) IS DISTINCT FROM ROW(OLD.*) THEN
RAISE EXCEPTION 'EC12_TERMINAL_FACT_IMMUTABLE';
END IF;
RETURN NEW;
END$$;

DROP TRIGGER IF EXISTS trg_ec12_framework_version_immutable ON ec12.ec12_framework_version;
CREATE TRIGGER trg_ec12_framework_version_immutable BEFORE UPDATE OR DELETE ON ec12.ec12_framework_version FOR EACH ROW EXECUTE FUNCTION ec12.guard_immutable_terminal();
DROP TRIGGER IF EXISTS trg_ec12_control_version_immutable ON ec12.ec12_control_version;
CREATE TRIGGER trg_ec12_control_version_immutable BEFORE UPDATE OR DELETE ON ec12.ec12_control_version FOR EACH ROW EXECUTE FUNCTION ec12.guard_immutable_terminal();

-- Evidence receipts append-only
CREATE OR REPLACE FUNCTION ec12.guard_append_only() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN RAISE EXCEPTION 'EC12_APPEND_ONLY_FACT'; END$$;
```

## 13.5 Bloque DDL

```
DROP TRIGGER IF EXISTS trg_ec12_evidence_receipt_append_only ON ec12.ec12_control_evidence_receipt;
CREATE TRIGGER trg_ec12_evidence_receipt_append_only BEFORE UPDATE OR DELETE ON ec12.ec12_control_evidence_receipt FOR EACH ROW EXECUTE FUNCTION ec12.guard_append_only();

-- Waiver cannot be active without future expiry
CREATE OR REPLACE FUNCTION ec12.guard_waiver_active() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
IF NEW.state='ACTIVE' AND (NEW.expires_at IS NULL OR NEW.expires_at <= NEW.starts_at) THEN
RAISE EXCEPTION 'EC12_WAIVER_REQUIRES_VALID_EXPIRY';
END IF;
RETURN NEW;
END$$;
DROP TRIGGER IF EXISTS trg_ec12_waiver_active_guard ON ec12.ec12_exception_waiver;
CREATE TRIGGER trg_ec12_waiver_active_guard BEFORE INSERT OR UPDATE ON ec12.ec12_exception_waiver FOR EACH ROW EXECUTE FUNCTION ec12.guard_waiver_active();

-- Outbox claim: SELECT ... FOR UPDATE SKIP LOCKED LIMIT :batch; set owner_instance, lease_until, status='IN_FLIGHT'.
-- Inbox consumer inserts dedup record before applying business effect inside its transaction.
```

# 14. MongoDB y Redis

PostgreSQL es authoritative para framework, controls, reviews, evidence receipts, assessments, CAPA, improvements, indicator semantics y decisiones. MongoDB solo puede alojar proyecciones reconstruibles orientadas a exploración/narrativa; Redis se limita a cache efímera, throttling y coordinación best-effort. Ninguno sustituye idempotency durable, RLS, evidence truth ni snapshots aprobados.

| **Store** | **Key/colección**                               | **Uso**                                                                  | **Restricción**                                           |
|-----------|-------------------------------------------------|--------------------------------------------------------------------------|-----------------------------------------------------------|
| MongoDB   | quality-review-exploration                      | Proyección documental de review/assessment/NC para búsqueda y navegación | Rebuildable desde eventos/receipts; no autoridad.         |
| MongoDB   | quality-insight-projection                      | Narrativas/insights IA revisados, sin raw evidence sensible innecesaria  | Debe conservar ai_run_ref y source refs.                  |
| Redis     | quality-scorecard:{tenant}:{scope}:{period}     | Cache de scorecard publicado                                             | TTL corto; incluye freshness/etag; nunca Source of Truth. |
| Redis     | indicator-snapshot:{tenant}:{indicator}:{scope} | Cache de snapshot READY/APPROVED                                         | Solo derivado y rebuildable.                              |
| Redis     | quality-alert-rate:{tenant}:{type}:{scope}      | Rate limiting/dedup auxiliar                                             | La deduplicación durable vive en PostgreSQL.              |
| Redis     | review-build-lock:{tenant}:{review}             | Coordinación best-effort de workers                                      | DB idempotency/leases siguen siendo autoridad.            |

| **REGLA MULTIMODELO —** MongoDB/Redis se eliminan sin perder la verdad. Si una feature no puede reconstruirse desde PostgreSQL + eventos/CT contracts, está usando el store equivocado. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 15. Backend Java 21 / Spring Boot / Spring Modulith

Módulo lógico recomendado: educationcontinuing.qualitygovernance. El paquete exportado expone contratos de Quality Gate, Scorecard y eventos; internamente aplica arquitectura hexagonal. Las entidades JPA permanecen en adapters.persistence; el dominio no depende de Spring, JPA, HTTP ni SDKs externos.

| **Paquete/capa**              | **Responsabilidad**                                            | **Regla**                                |
|-------------------------------|----------------------------------------------------------------|------------------------------------------|
| domain.framework              | QualityFramework, Control, versions, policies                  | Pure Java; no JPA.                       |
| domain.assurance              | ReviewCycle, Assessment, Evidence, Attestation, Waiver, Gate   | State machines e invariantes.            |
| domain.improvement            | Nonconformity, CAPA, ImprovementInitiative/Experiment          | Eficacia y learning loop.                |
| domain.metrics                | IndicatorDefinition, thresholds, snapshots, health calculation | Determinista y versionado.               |
| application.command           | Intent-based commands + transaction boundaries                 | TenantContext + auth + If-Match.         |
| application.query             | Read models y views gobernadas                                 | No bypass de policy/suppression.         |
| ports.out                     | CT-05/06/07/09/10/11/12/13/16 + EC-01…EC-11                    | Contracts; sin repository cross-context. |
| adapters.persistence.postgres | Repositories JDBC/JPA, RLS session context, leases             | PostgreSQL real/Testcontainers.          |
| adapters.web                  | REST, ProblemDetail, ETag, pagination                          | OpenAPI-first.                           |
| adapters.messaging            | Outbox/inbox, consumers, AsyncAPI                              | Dedup + correlation/causation.           |
| adapters.analytics            | CT-11 dataset/snapshot jobs                                    | UNKNOWN_EFFECT/reconciliation.           |
| adapters.ai                   | CT-12 only                                                     | No provider SDK.                         |
| security                      | RBAC/ABAC/SoD/purpose/step-up                                  | Fail-closed.                             |
| observability                 | OTel + business metrics                                        | PII/evidence-safe telemetry.             |

## 15.1 Estructura de paquetes recomendada

```
com.peopleu.ec12.qualitygovernance
├── api
│ ├── QualityGateApi.java
│ ├── QualityScorecardApi.java
│ └── QualityEvents.java
├── domain
│ ├── framework
│ ├── assurance
│ ├── improvement
│ └── metrics
├── application
│ ├── command
│ ├── query
│ └── service
├── ports
│ ├── in
│ └── out
├── adapters
│ ├── web
│ ├── persistence.postgres
│ ├── messaging
│ ├── analytics
│ ├── documents
│ ├── workflow
│ └── ai
└── config
```

## 15.2 Transaction boundary y TenantDbContext

Cada command application service abre la transacción, aplica SET LOCAL peopleu.tenant_id, resuelve el aggregate, valida autorización/purpose, ejecuta la intención y persiste state + audit/outbox/idempotency de forma atómica. Un query también aplica tenant context antes de cualquier repository call. Worker técnico usa rol separado pero conserva tenant context por job; nunca existe un “superuser worker” con BYPASSRLS como atajo.

```
@Transactional
public QualityGateDecision issueDecision(IssueGateCommand cmd) {
tenantDbContext.applyCurrentTenant();
authorization.require("EC12_GATE_DECIDE", cmd.scope());
var gate = repository.lockById(cmd.gateId());
etag.requireMatch(gate.revision(), cmd.ifMatch());
var decision = gate.issue(cmd.result(), cmd.reason(), clock.instant());
outbox.append(events.from(decision));
audit.record(decision.auditFact());
return decision;
}
```

# 16. APIs REST

| **Método** | **Ruta**                                     | **Uso**                 | **Control**                          | **Resultado** |
|------------|----------------------------------------------|-------------------------|--------------------------------------|---------------|
| POST       | /ec/quality/frameworks                       | Crear framework         | Idempotency-Key                      | 201           |
| POST       | /ec/quality/frameworks/{id}/versions         | Crear versión           | Idempotency-Key                      | 201           |
| PATCH      | /ec/quality/framework-versions/{id}          | Editar DRAFT            | If-Match                             | 200/412       |
| POST       | /ec/quality/framework-versions/{id}:validate | Validar                 | If-Match                             | 200           |
| POST       | /ec/quality/framework-versions/{id}:publish  | Publicar                | If-Match + Idempotency-Key + step-up | 200           |
| POST       | /ec/quality/controls                         | Crear control           | Idempotency-Key                      | 201           |
| POST       | /ec/quality/controls/{id}/versions           | Crear ControlVersion    | Idempotency-Key                      | 201           |
| PATCH      | /ec/quality/control-versions/{id}            | Editar DRAFT            | If-Match                             | 200/412       |
| POST       | /ec/quality/control-versions/{id}:publish    | Publicar control        | If-Match + step-up                   | 200           |
| POST       | /ec/quality/compliance-bindings              | Crear binding           | Idempotency-Key                      | 201           |
| GET        | /ec/quality/compliance-bindings              | Listar bindings         | page,size,sort,filters               | 200           |
| POST       | /ec/quality/reviews                          | Crear review cycle      | Idempotency-Key                      | 201           |
| POST       | /ec/quality/reviews/{id}/scopes              | Agregar scope           | If-Match + Idempotency-Key           | 201           |
| POST       | /ec/quality/reviews/{id}:start               | Iniciar                 | If-Match                             | 200           |
| POST       | /ec/quality/reviews/{id}:freeze-evidence     | Freeze                  | If-Match + step-up                   | 200           |
| POST       | /ec/quality/reviews/{id}/assessments         | Crear/evaluar control   | If-Match + Idempotency-Key           | 201           |
| POST       | /ec/quality/assessments/{id}/evidence        | Agregar receipt         | Idempotency-Key                      | 201           |
| POST       | /ec/quality/assessments/{id}:lock            | Lock assessment         | If-Match + step-up                   | 200           |
| POST       | /ec/quality/reviews/{id}:close               | Cerrar review           | If-Match + Idempotency-Key + step-up | 200           |
| POST       | /ec/quality/nonconformities                  | Crear NC                | Idempotency-Key                      | 201           |
| PATCH      | /ec/quality/nonconformities/{id}             | Intent-safe metadata    | If-Match                             | 200/412       |
| POST       | /ec/quality/nonconformities/{id}/capa        | Crear CAPA              | Idempotency-Key                      | 201           |
| POST       | /ec/quality/capa/{id}/actions                | Agregar action          | If-Match + Idempotency-Key           | 201           |
| POST       | /ec/quality/capa/{id}:verify-effectiveness   | Verificar eficacia      | If-Match + step-up                   | 200           |
| POST       | /ec/quality/nonconformities/{id}:close       | Cerrar NC               | If-Match + step-up                   | 200           |
| POST       | /ec/quality/improvements                     | Crear initiative        | Idempotency-Key                      | 201           |
| POST       | /ec/quality/improvements/{id}/experiments    | Crear experiment        | If-Match + Idempotency-Key           | 201           |
| POST       | /ec/quality/experiments/{id}:start           | Iniciar                 | If-Match                             | 200           |
| POST       | /ec/quality/experiments/{id}:conclude        | Concluir                | If-Match                             | 200           |
| POST       | /ec/quality/experiments/{id}:adopt           | Adoptar                 | If-Match + step-up                   | 200           |
| POST       | /ec/quality/indicators                       | Crear indicator version | Idempotency-Key                      | 201           |
| POST       | /ec/quality/indicators/{id}:activate         | Activar                 | If-Match                             | 200           |
| POST       | /ec/quality/indicator-snapshots              | Build snapshot          | Idempotency-Key                      | 202           |
| POST       | /ec/quality/health-snapshots                 | Build health            | Idempotency-Key                      | 202           |
| POST       | /ec/quality/scorecards                       | Build scorecard         | Idempotency-Key                      | 202           |
| POST       | /ec/quality/scorecards/{id}:approve          | Aprobar                 | If-Match + step-up                   | 200           |
| GET        | /ec/quality/scorecards/{id}                  | Consultar               | ETag                                 | 200           |
| POST       | /ec/quality/attestations                     | Crear attestation       | Idempotency-Key                      | 201           |
| POST       | /ec/quality/attestations/{id}:approve        | Aprobar                 | If-Match + step-up + SoD             | 200           |
| POST       | /ec/quality/waivers                          | Solicitar waiver        | Idempotency-Key                      | 201           |
| POST       | /ec/quality/waivers/{id}:approve             | Aprobar waiver          | If-Match + step-up + SoD             | 200           |
| POST       | /ec/quality/waivers/{id}:revoke              | Revocar                 | If-Match + reason                    | 200           |
| GET        | /ec/quality/alerts                           | Listar alerts           | page,size,sort,filters               | 200           |
| POST       | /ec/quality/alerts/{id}:resolve              | Resolver alert          | If-Match + reason                    | 200           |
| POST       | /ec/quality/gates                            | Solicitar/evaluar gate  | Idempotency-Key                      | 202           |
| GET        | /ec/quality/gates/by-request/{key}           | Consultar gate          | —                                    | 200           |
| POST       | /ec/quality/evidence-packs                   | Construir evidence pack | Idempotency-Key + purpose + step-up  | 202           |
| POST       | /ec/quality/ai-assists                       | Solicitar CT-12 assist  | Idempotency-Key                      | 202           |
| GET        | /ec/quality/reviews                          | Buscar reviews          | page,size,sort,filters,asOf          | 200           |
| GET        | /ec/quality/nonconformities                  | Buscar NC/CAPA          | page,size,sort,filters               | 200           |
| GET        | /operations/{operationId}                    | OperationStatus         | —                                    | 200           |

## 16.1 Contratos de paginación, filtros y sorting

GET collection endpoints usan page/size limitados, sort whitelist y filtros tipados; nunca exponen “orderBy=raw SQL”. Toda respuesta paginada incluye items, page, size, totalElements/nextCursor según contrato, asOf, freshnessState y links. Para datasets grandes se prefiere cursor estable sobre offset cuando el orden lo requiera.

## 16.2 DTOs principales

```
CreateReviewRequest { frameworkVersionId, reviewTypeCode, period{start,end}, ownerScopeRef, assuranceLevelCode, scopes:[{type,ref}] }
AssessControlRequest { reviewScopeId, controlVersionId, result, rationale, assuranceLevelCode, evidenceReceiptIds[], policyVersionRef }
CreateNonconformityRequest { sourceType, sourceRef, controlVersionId?, severityCode, title, description, ownerSubjectRef, targetResolutionAt? }
CreateCapaRequest { rootCauseSummary, correctiveStrategy, preventiveStrategy?, effectivenessMetricRef?, baselineSnapshotRef?, targetValue?, targetUnitCode?, targetDate }
CreateIndicatorSnapshotRequest { indicatorId, scopeType, scopeRef, periodStart, periodEnd, asOf? }
BuildScorecardRequest { frameworkVersionId, scopeType, scopeRef, periodStart, periodEnd, reportProfileRef?, purposeRef? }
CreateAttestationRequest { bindingId, scopeType, scopeRef, asOf, evidenceReceiptIds[], rationale }
CreateWaiverRequest { controlVersionId?, bindingId?, scopeType, scopeRef, reasonCode, rationale, riskSeverityCode, residualRiskCode, compensatingControls[], startsAt, expiresAt }
QualityGateRequest { requestKey, gateCode, frameworkVersionId?, scopeType, scopeRef, asOf?, contextRefs{} }
OperationStatusResponse { operationId,status,resourceRef?,reasonCode?,retryAfter?,correlationId,updatedAt }
```

## 16.3 ProblemDetail y códigos estables

| **HTTP** | **code**                    | **Semántica**                                                |
|----------|-----------------------------|--------------------------------------------------------------|
| 400      | VALIDATION_ERROR            | Payload/formato inválido; fieldErrors cuando aplica.         |
| 403      | QUALITY_SCOPE_DENIED        | Tenant/scope/purpose/role no autorizado.                     |
| 403      | SOD_VIOLATION               | Actor no puede aprobar su propia decisión bajo policy.       |
| 409      | IDEMPOTENCY_KEY_REUSED      | Same key con payload distinto.                               |
| 409      | INVALID_STATE_TRANSITION    | Transición de state machine no permitida.                    |
| 409      | REGULATORY_DRIFT_DETECTED   | Binding/attestation usa obligation version obsoleta.         |
| 409      | EVIDENCE_NOT_FROZEN         | Decisión terminal requiere freeze/watermark.                 |
| 412      | PRECONDITION_FAILED         | ETag/revision mismatch.                                      |
| 422      | EVIDENCE_INSUFFICIENT       | No satisface requirements mandatory/freshness.               |
| 422      | FRAMEWORK_VALIDATION_FAILED | Weights/control pins/scoring incompletos.                    |
| 422      | WAIVER_NOT_ALLOWED          | Control/binding no-waivable o condiciones inválidas.         |
| 422      | NON_COMPARABLE_INDICATORS   | Snapshot/trend no comparable entre versiones.                |
| 503      | DEPENDENCY_UNAVAILABLE      | CT/EC externo indispensable no disponible.                   |
| 202      | UNKNOWN_EFFECT              | Efecto remoto no confirmado; OperationStatus/reconciliation. |

# 17. Eventos: Domain Events, Integration Events, Outbox, Inbox y AsyncAPI

| **ID**       | **Evento**                           | **Producer** | **Consumers**                 |
|--------------|--------------------------------------|--------------|-------------------------------|
| EVT-EC12-001 | QualityFrameworkVersionPublished     | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-002 | QualityFrameworkVersionSuperseded    | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-003 | ControlVersionPublished              | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-004 | ControlVersionRetired                | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-005 | ComplianceBindingActivated           | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-006 | ComplianceDriftDetected              | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-007 | QualityReviewPlanned                 | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-008 | QualityReviewStarted                 | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-009 | ReviewEvidenceFrozen                 | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-010 | ControlAssessmentLocked              | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-011 | QualityReviewClosed                  | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-012 | EvidenceReceiptRecorded              | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-013 | NonconformityOpened                  | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-014 | NonconformitySeverityChanged         | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-015 | CAPAApproved                         | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-016 | CorrectiveActionVerified             | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-017 | CAPAEffectivenessVerified            | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-018 | NonconformityClosed                  | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-019 | ImprovementInitiativePrioritized     | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-020 | ImprovementExperimentStarted         | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-021 | ImprovementExperimentConcluded       | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-022 | ImprovementAdopted                   | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-023 | IndicatorDefinitionActivated         | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-024 | IndicatorSnapshotReady               | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-025 | PortfolioHealthSnapshotReady         | EC-12        | CT-11 / EC executive portals  |
| EVT-EC12-026 | QualityScorecardApproved             | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-027 | QualityScorecardPublished            | EC-12        | CT-11 / EC executive portals  |
| EVT-EC12-028 | ComplianceAttestationApproved        | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-029 | ComplianceAttestationExpired         | EC-12        | CT-07 / CT-11 / operators     |
| EVT-EC12-030 | ExceptionWaiverApproved              | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-031 | ExceptionWaiverExpired               | EC-12        | CT-07 / CT-11 / operators     |
| EVT-EC12-032 | ExceptionWaiverRevoked               | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-033 | QualityAlertOpened                   | EC-12        | CT-07 / CT-11 / operators     |
| EVT-EC12-034 | QualityAlertResolved                 | EC-12        | CT-07 / CT-11 / operators     |
| EVT-EC12-035 | QualityGateDecisionIssued            | EC-12        | EC-01…EC-11 requester / CT-09 |
| EVT-EC12-036 | QualityGateDecisionSuperseded        | EC-12        | EC-01…EC-11 requester / CT-09 |
| EVT-EC12-037 | EvidencePackReady                    | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-038 | QualityAIInsightReviewed             | EC-12        | CT-11 / EC-12                 |
| EVT-EC12-039 | QualityMigrationCertified            | EC-12        | CT-11 / Quality consumers     |
| EVT-EC12-040 | QualityRetentionDispositionCompleted | EC-12        | CT-11 / Quality consumers     |

## 17.1 Envelope mínimo

```
{
"messageId":"uuid",
"tenantId":"uuid",
"eventType":"QualityGateDecisionIssued",
"schemaVersion":1,
"occurredAt":"2026-09-12T18:00:00Z",
"correlationId":"uuid",
"causationId":"uuid",
"aggregateType":"QualityGateAssessment",
"aggregateId":"uuid",
"dataClassification":"INTERNAL",
"payload":{
"gateRequestKey":"EDITION-READY:uuid:v3",
"gateCode":"EC_EDITION_READY",
"scopeType":"EDITION",
"scopeRef":"uuid",
"result":"CONDITIONAL",
"decisionHash":"sha256",
"evidenceWatermark":"2026-09-12T17:55:00Z"
}
}
```

Outbox se inserta en la misma transacción del cambio de negocio y usa leasing multi-instancia. Inbox registra dedup antes del efecto de negocio del consumer. Event payload minimiza PII/evidence content; se transmiten refs/hashes/summary autorizados. SchemaVersion y compatibility CI son obligatorios.

# 18. Integraciones: timeouts, retries, circuit breaker, fallback, degradación, reconciliation y UNKNOWN_EFFECT

| **Integración**              | **Efecto**                               | **Timeout**  | **Retry**                        | **Unknown/reconcile**                                 | **Fallback/degradación**                         |
|------------------------------|------------------------------------------|--------------|----------------------------------|-------------------------------------------------------|--------------------------------------------------|
| CT-05 Documents              | Resolver/crear artifact de evidence pack | 5-15s        | Provider idempotency/request key | UNKNOWN_EFFECT + artifact lookup                      | No marcar evidence verified hasta confirmar.     |
| CT-06 Workflow               | Approvals framework/waiver/attestation   | 5s/async     | Retry idempotente                | UNKNOWN_EFFECT + workflow query                       | Decision local queda pending.                    |
| CT-07 Notifications          | Alerts/reminders/expiry                  | 2-5s         | Outbox retry                     | UNKNOWN_EFFECT + delivery receipt                     | No duplica business alert.                       |
| CT-10 Security/Policy        | ABAC/SoD/purpose/policy lookup           | 2-3s         | Short retry                      | Fail-closed para command crítico                      | Read-only puede usar STALE si policy lo permite. |
| CT-11 Analytics              | Dataset/snapshot computation             | async        | Job key idempotente              | UNKNOWN_EFFECT + job status                           | No inventar VALUE; mostrar UNAVAILABLE/PARTIAL.  |
| CT-12 AI                     | Anomaly/root-cause/summarize             | 10-30s async | Idempotent run key               | UNAVAILABLE/PARTIAL                                   | Nunca bloquea compliance esencial.               |
| CT-13 Scheduling             | Review cadence/expiry timers             | 5s           | Idempotent schedule key          | UNKNOWN_EFFECT + reconcile schedule                   | No blind retry.                                  |
| External obligation registry | Obligation version/authority lookup      | 3-10s        | GET retries only                 | STALE/UNAVAILABLE + cached signed snapshot if allowed | No legal interpretation local.                   |
| EC-01…EC-11                  | Quality gate context / change receipts   | 3-10s        | Command-specific idempotency     | UNKNOWN_EFFECT + query owner state                    | EC-12 no modifica state ajeno.                   |
| CT-09/Event bus              | Publish/consume integration events       | async        | Outbox/inbox                     | Lease/retry/DLQ governed                              | At-least-once semantics.                         |

## 18.1 Matriz UNKNOWN_EFFECT

| **Operación**           | **Riesgo**                              | **Estado local**                               | **Reconciliación**                                | **Regla retry**                               |
|-------------------------|-----------------------------------------|------------------------------------------------|---------------------------------------------------|-----------------------------------------------|
| Crear evidence pack     | CT-05 puede haber creado artifact       | operation=UNKNOWN_EFFECT                       | Consultar artifact by idempotency/correlation key | Retry solo si se demuestra ausencia.          |
| Programar review/expiry | CT-13 puede haber creado schedule       | UNKNOWN_EFFECT                                 | Lookup schedule key                               | No crear schedule duplicado.                  |
| Enviar alert            | CT-07 puede haber entregado mensaje     | UNKNOWN_EFFECT                                 | Delivery receipt/provider lookup                  | No duplicar notificación sin evidencia.       |
| Quality Gate response   | Requester puede haber aplicado decisión | LOCAL decision ISSUED; delivery UNKNOWN_EFFECT | Reconcile ack/owner state                         | No emitir segunda decisión con distinto hash. |
| CT-11 compute job       | Job puede estar ejecutándose            | UNKNOWN_EFFECT                                 | Query job by request key                          | No lanzar compute paralelo ciego.             |

# 19. Frontend Web enterprise por Workspaces

| **Workspace**                    | **Actores**              | **Route**                    | **Layout/KPI**                                                                      | **Commands**                                         | **Estados críticos**                                  |
|----------------------------------|--------------------------|------------------------------|-------------------------------------------------------------------------------------|------------------------------------------------------|-------------------------------------------------------|
| Quality Governance Cockpit       | Quality Director / Board | /ec/quality                  | Health score, critical NC, CAPA overdue, attestation drift, alerts, review coverage | Open review, navigate evidence, approve scorecard    | NO_DATA/STALE/PARTIAL/UNAVAILABLE/SUPPRESSED explicit |
| Framework & Control Studio       | Quality Architect        | /ec/quality/frameworks       | Framework versions, dimensions, weights, control library, validation                | Create version, edit DRAFT, compare, submit, publish | ETag conflict; PUBLISHED read-only                    |
| Compliance Matrix                | Compliance Officer       | /ec/quality/compliance       | Obligations refs, bindings, applicability, attestations, drift, waivers             | Bind, attest, approve/reject, request waiver         | EXPIRED ≠ NON_COMPLIANT; drift banners                |
| Quality Review Workspace         | Lead Reviewer            | /ec/quality/reviews          | Scope tree, control checklist, evidence completeness, assurance level, progress     | Start, collect, assess, freeze, close                | EVIDENCE_FROZEN lock + reopen flow                    |
| Evidence & Assurance Desk        | Reviewer / Auditor       | /ec/quality/evidence         | Requirement→receipt lineage, hashes, classification, artifact availability          | Add receipt, verify, inspect access                  | No raw blob local; secure preview via CT-05           |
| Nonconformity & CAPA Center      | Quality Manager          | /ec/quality/nonconformities  | NC queue, severity, aging, root cause, CAPA, effectiveness                          | Triage, plan, verify, close/reopen                   | Critical filters; overdue alerts                      |
| Continuous Improvement Portfolio | Quality Board / Analysts | /ec/quality/improvements     | Initiative funnel, experiments, baseline/target/outcome, adopted/rejected           | Prioritize, start, conclude, adopt                   | Non-comparable metric warnings                        |
| Indicator & Threshold Studio     | Quality Analyst          | /ec/quality/indicators       | Metric dictionary, grain/unit/formula DSL, thresholds, version compare              | Create version, validate, activate/retire            | No raw SQL editor                                     |
| Portfolio Health Observatory     | Quality Analyst          | /ec/quality/portfolio-health | Dimension scorecards, trends, coverage, freshness, comparability                    | Build snapshot, compare periods, drill lineage       | ZERO vs NO_DATA; STALE; PARTIAL                       |
| Quality Scorecard Center         | Quality Manager          | /ec/quality/scorecards       | Scope/period, approved snapshots, report profile, artifact lineage                  | Build, review, approve, publish/export               | Purpose/step-up for export                            |
| Waiver & Quality Debt Desk       | Risk/Quality Approver    | /ec/quality/waivers          | Active/expiring waivers, residual risk, debt aging, compensating controls           | Approve/reject/revoke, extend via new request        | Expiry countdown; non-waivable guard                  |
| Domain Quality Gate Console      | Quality Operator         | /ec/quality/gates            | Gate requests, controls evaluated, decision receipts, requester ack                 | Evaluate, issue, supersede/void                      | UNKNOWN_EFFECT delivery and reconcile                 |
| Quality Alerts Center            | Quality Operator         | /ec/quality/alerts           | Breach/drift/stale/overdue alerts, dedup, SLA                                       | Acknowledge, assign, resolve/dismiss                 | Alert != incident; linked action                      |
| Audit & Evidence Pack Desk       | Auditor                  | /ec/quality/audit            | Timeline, framework/control pins, hashes, signatures, exports                       | Build evidence pack, verify hash                     | Read-only; sensitive access reason/step-up            |

## 19.1 Contrato de estados Frontend

| **ESTADOS OBLIGATORIOS —** NO_DATA ≠ ZERO ≠ VALUE ≠ NOT_APPLICABLE ≠ NOT_ASSESSED ≠ STALE ≠ PARTIAL ≠ UNAVAILABLE ≠ UNKNOWN_EFFECT ≠ SUPPRESSED. La UI nunca transforma “no pude consultar” en “cumple”, ni “sin dato” en cero, ni “no aplica” en pass. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 19.2 Diseño detallado de Workspace

Cada Workspace implementa: route guards; breadcrumb/context header; scope/timeframe selector cuando aplica; KPI cards con asOf/freshness; grids con columnas whitelist; drawer de detalle; diff/timeline; command bar con permission hints; Conflict Drawer para 412; OperationStatus panel para 202/UNKNOWN_EFFECT; lineage/evidence tabs; explicit empty/loading/error/suppressed states; accessibility WCAG AA; responsive behavior; tests de component, contract y e2e.

Query keys incluyen resource version/asOf/freshness y jamás dependen de un tenant enviado por UI. El client se genera desde OpenAPI; DTOs manuales duplicados quedan prohibidos. Mutations generan Idempotency-Key por intención y conservan correlationId para seguimiento.

# 20. Mobile

Mobile es deliberadamente selectivo. EC-12 es predominantemente administrativo/assurance; no se replica el Framework Studio, fórmula de indicadores, compliance matrix completa ni evidence pack builder. Mobile debe concentrarse en decisiones ejecutivas, alertas y captura puntual de evidencia cuando exista un journey real de campo.

| **Journey**              | **Capacidades**                                                                                      | **Restricciones**                                                           |
|--------------------------|------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| Executive Quality Mobile | Health snapshot, critical NC, overdue CAPA, active waivers, approved scorecards                      | Read mostly; datos agregados; secure storage mínimo.                        |
| Reviewer Mobile          | Checklist de control asignado, evidencia metadata, comment/rationale draft, approve simple si policy | No edición de framework; biometric step-up para terminal decisions.         |
| Evidence Capture         | Foto/documento mediante CT-05, scan QR/ref, timestamp/location solo si purpose autoriza              | EC-12 guarda receipt; no blob. Offline queue cifrada con expiry.            |
| Alert Triage             | Acknowledge/assign/resolve simple alert                                                              | No incident response genérico; deep links a Web para operaciones complejas. |
| Quality Board Approval   | Aprobar scorecard/waiver/attestation cuando policy lo permita                                        | MFA/biometric step-up + reason; SoD enforced server-side.                   |

# 21. Matriz Frontend / Backend / Mobile

| **Capability**         | **Frontend Web** | **Backend**              | **Mobile**                  |
|------------------------|------------------|--------------------------|-----------------------------|
| Framework authoring    | Completo         | API/domain authoritative | No                          |
| Control versioning     | Completo         | API/domain authoritative | No                          |
| Compliance binding     | Completo         | API/domain authoritative | No                          |
| Review cycle           | Completo         | API/domain authoritative | Limitado                    |
| Evidence receipt       | Completo         | API/domain authoritative | Sí, captura puntual         |
| Control assessment     | Completo         | API/domain authoritative | Limitado                    |
| Nonconformity          | Completo         | API/domain authoritative | Consulta/triage             |
| CAPA                   | Completo         | API/domain authoritative | Acción asignada/consulta    |
| Improvement experiment | Completo         | API/domain authoritative | Consulta                    |
| Indicator definition   | Completo         | API/domain authoritative | No                          |
| Indicator snapshot     | Completo         | API/domain authoritative | Consulta                    |
| Portfolio health       | Completo         | API/domain authoritative | Sí, ejecutivo               |
| Scorecard              | Completo         | API/domain authoritative | Sí, aprobado                |
| Attestation            | Completo         | API/domain authoritative | Aprobación selectiva        |
| Waiver                 | Completo         | API/domain authoritative | Aprobación selectiva        |
| Quality Alert          | Completo         | API/domain authoritative | Sí                          |
| Quality Gate           | Completo         | API/domain authoritative | Consulta/approval selectiva |
| Evidence Pack          | Completo         | API/domain authoritative | No                          |
| AI assist              | Completo         | API/domain authoritative | Solo insight revisado       |

# 22. Seguridad: RBAC, ABAC, SoD, step-up, Tenant Scope, purpose limitation y Threat Model

EC-12 contiene decisiones de assurance, evidencia sensible, hallazgos y compliance; por tanto aplica deny-by-default. RBAC otorga capacidad base, ABAC restringe tenant/institution/scope/classification/purpose y SoD evita autoaprobación. Step-up se exige por policy para publish/approve/revoke/critical close/gate terminal/export sensible.

## 22.1 Roles lógicos mínimos

| **Role**             | **Permisos base**                             | **Restricción**                              |
|----------------------|-----------------------------------------------|----------------------------------------------|
| QUALITY_ARCHITECT    | Diseñar framework, controls, indicators DRAFT | No auto-publish si SoD activo.               |
| QUALITY_MANAGER      | Planificar reviews, NC/CAPA, scorecards       | Scope institucional.                         |
| QUALITY_REVIEWER     | Assess controls/evidence                      | No modificar control publicado.              |
| INDEPENDENT_REVIEWER | Assurance independiente                       | No evidence submitter para el mismo control. |
| COMPLIANCE_OFFICER   | Bindings/attestations                         | No autoridad legal fuente.                   |
| QUALITY_APPROVER     | Publish/approve terminal decisions            | Step-up + SoD.                               |
| QUALITY_ANALYST      | Snapshots/health/improvements                 | No PII/raw evidence por default.             |
| QUALITY_OPERATOR     | Alerts/reconciliation/runbooks                | Technical scope; no bypass RLS.              |
| QUALITY_AUDITOR      | Read evidence/timeline/packs                  | Read-only + reason/purpose.                  |
| EXECUTIVE_VIEWER     | Approved scorecards/health                    | No raw assessment rationale sensible.        |

## 22.2 Threat Model

| **Amenaza**          | **Ataque**                                                  | **Control**                                                  | **Evidencia**             |
|----------------------|-------------------------------------------------------------|--------------------------------------------------------------|---------------------------|
| IDOR / cross-tenant  | Usuario intenta assessment/evidence por UUID de otro tenant | RLS FORCE + tenant-aware repositories + authz resource scope | Negative DB/API tests     |
| Privilege escalation | Reviewer llama approve endpoint                             | RBAC+ABAC+SoD+step-up                                        | 403 + audit               |
| Evidence tampering   | Modificar receipt/hash después de close                     | Append-only trigger + hash verification                      | DB test                   |
| Framework tampering  | PATCH PUBLISHED version                                     | State/trigger immutability + 409/422                         | Contract + DB test        |
| Waiver abuse         | Crear waiver sin expiry/compensating control                | Domain + CHECK + workflow/SoD                                | Negative UAT              |
| Metric manipulation  | Cambiar fórmula o dataset después del snapshot              | Pinned definition/dataset/watermark/hash                     | Reproducibility test      |
| Mass assignment      | Cliente envía approvedBy/state/tenant                       | DTO whitelist + server fields                                | API fuzzing               |
| Replay               | Repetir approve/gate request                                | Idempotency key/request hash + event dedup                   | Replay suite              |
| Race condition       | Dos reviewers lock assessment                               | SELECT FOR UPDATE/ETag + unique indexes                      | Concurrency harness       |
| Export leakage       | Evidence pack contiene campos no autorizados                | purpose/classification/field policy + secure artifact        | Abuse test                |
| Webhook spoofing     | Evento fake de obligation update                            | Signature/schema/source auth + inbox dedup                   | Security integration test |
| Resource exhaustion  | Build scorecard para scope gigante repetidamente            | quotas, async jobs, rate limits, job dedup                   | Load/abuse test           |
| AI prompt leakage    | Evidence sensible enviada a CT-12 sin policy                | minimization adapter + CT-12 policy + evals                  | AI leakage test           |
| Formula injection    | DSL maliciosa/SQL expression                                | Parser allowlist; no SQL eval                                | Fuzz/unit tests           |
| Stale compliance     | Attestation antigua mostrada vigente                        | expiry/drift jobs + UI state + query guards                  | Time-travel tests         |

## 22.3 Secure SDLC

- SAST en cada merge request.

- SCA/dependency policy con severidad y SLA.

- Secret scan pre-commit/CI.

- Container image scan + signed images cuando plataforma lo soporte.

- SBOM generado y archivado por release.

- IaC/config scan para roles DB/RLS/secrets.

- DAST/API abuse tests en staging.

- Threat model actualizado ante nuevas integraciones o scopes.

- OpenAPI fuzz/contract testing.

- No production deploy con findings P0/P1 sin accepted risk formal y expiry.

# 23. Auditoría: Audit Trail, Evidence Pack, lineage, reason codes y assurance

Toda decisión terminal debe ser reconstruible: actor/subject_ref, role/purpose, tenant/scope, before/after cuando existe mutación, reason code, correlation/causation, evidence watermark, framework/control/indicator versions, policy refs, approval/step-up refs y event/outbox ids. El audit trail técnico se integra con CT-10; EC-12 mantiene hechos de negocio y evidence receipts necesarios para assurance.

| **Acción**          | **Lineage mínimo**                                           | **Artefacto de assurance**  |
|---------------------|--------------------------------------------------------------|-----------------------------|
| Framework publish   | version/hash/approver/validation report                      | FrameworkPublicationReceipt |
| Control publish     | version/hash/evidence requirements                           | ControlPublicationReceipt   |
| Assessment lock     | control version/result/rationale/evidence set hash/watermark | AssessmentDecisionReceipt   |
| Attestation approve | binding/obligation version/result/expiry/signatures          | ComplianceAttestation       |
| Waiver approve      | scope/risk/compensating controls/expiry/signatures           | WaiverDecisionReceipt       |
| NC close            | cause/CAPA/actions/effectiveness evidence/verifier           | NonconformityClosureReceipt |
| Improvement adopt   | baseline/target/outcome/decision/learning                    | ImprovementDecisionReceipt  |
| Snapshot approve    | input watermark/calculator/content hash/approver             | SnapshotApprovalReceipt     |
| Gate issue          | request key/result/evidence watermark/decision hash          | QualityGateDecision         |
| Export              | purpose/reason/policy/artifact hash/recipient scope          | ExportReceipt               |

## 23.1 Evidence Pack mínimo

- Documento maestro EC-12 version/hash.

- FrameworkVersion y ControlVersions pinneados.

- Applicability snapshot y ReviewScopes.

- EvidenceRequirements y EvidenceReceipts con hashes/CT-05 refs.

- ControlAssessments y signatures/SoD evidence.

- ComplianceBindings/Attestations/Waivers/expiry state.

- Nonconformities/CAPA/actions/effectiveness verification.

- IndicatorDefinitions/snapshots/dataset watermarks/calculator versions.

- PortfolioHealth/Scorecard snapshots aprobados.

- Outbox/inbox/reconciliation receipts para efectos remotos relevantes.

- Audit trail CT-10 refs, correlation/causation ids.

- Release/Gates G1-G10 evidence para el software EC-12 cuando se certifique producción.

# 24. Observabilidad: logs, metrics, traces, SLI/SLO, performance y resiliencia

| **Métrica/SLI**      | **Definición**                                  | **Objetivo**       |
|----------------------|-------------------------------------------------|--------------------|
| SLI API availability | successful server responses / eligible requests | 99.9% mensual      |
| SLI command latency  | p95 sync command excluding async jobs           | \< 700 ms          |
| SLI query latency    | p95 common lists/details                        | \< 500 ms          |
| SLI snapshot build   | READY within size-based target                  | 99% según SLO tier |
| SLI gate decision    | terminal decision within configured deadline    | 99.5%              |
| SLI outbox age       | oldest pending event age                        | \< 60 s normal     |
| SLI reconciliation   | UNKNOWN_EFFECT resolved within target           | 99% \< 15 min      |
| SLI review freshness | reviews with non-stale mandatory evidence       | Business KPI       |
| Control coverage     | mandatory applicable controls assessed / total  | Quality KPI        |
| CAPA overdue rate    | overdue open actions / active actions           | Quality KPI        |
| Attestation drift    | stale/expired attestations / active bindings    | Compliance KPI     |
| Tenant leakage       | confirmed cross-tenant access                   | 0                  |
| Evidence tamper      | hash/append-only integrity violation            | 0                  |

Tracing OTel propaga correlation/causation por HTTP, workers, outbox y adapters. Logs estructurados incluyen tenant pseudonymous key, operation/resource type, state transition, outcome/error code y latency; no incluyen evidence content, legal text completo ni PII. Metrics evitan labels de alta cardinalidad como assessment_id o subject_ref.

## 24.1 Performance budgets

| **Operación**                         | **Budget**                        | **Diseño**                                    |
|---------------------------------------|-----------------------------------|-----------------------------------------------|
| Framework/Control CRUD                | \< 300 ms p95                     | N+1 forbidden; indexed business keys.         |
| Review workspace 1k assessments       | \< 1.5 s server + paginated UI    | Projection/read model; no mega-join live.     |
| Indicator snapshot                    | Async for heavy dataset           | CT-11 job + OperationStatus.                  |
| Portfolio health up to 500 indicators | \< 30 s async target              | Batch fetch + deterministic calculator.       |
| Evidence pack up to 10k receipts      | Async \< 2 min target             | Streaming metadata + CT-05 artifact creation. |
| Alert query 1M history                | \< 700 ms p95                     | Partial indexes by active state/date.         |
| Outbox dispatch                       | \>1000 events/min per node target | SKIP LOCKED + batch/lease.                    |

# 25. IA aplicada al módulo

Toda IA de EC-12 pasa por CT-12 y se considera capacidad asistiva. El dominio conserva siempre una ruta manual. La IA puede aumentar velocidad de análisis, pero nunca reemplazar la responsabilidad institucional de aprobar un framework, interpretar jurídicamente una obligación, declarar compliance, aceptar un riesgo, cerrar una no conformidad o emitir un quality gate terminal.

| **Use case**             | **Input**                                | **Output**                            | **Guardrail**                                      |
|--------------------------|------------------------------------------|---------------------------------------|----------------------------------------------------|
| Anomaly detection        | Series de IndicatorSnapshots autorizadas | Anomalías y segmentos candidatos      | No equivale a breach; analyst review.              |
| Evidence summarization   | Evidence metadata/text autorizado        | Resumen con citations/grounding refs  | No sustituye evidencia primaria.                   |
| Root-cause hypotheses    | NC + evidence + metric trends            | Hipótesis priorizadas                 | No declara causa como hecho.                       |
| CAPA drafting            | NC/cause validated                       | Borrador de acciones/criterios        | Owner/reviewer aprueba.                            |
| Portfolio insight        | Health snapshots y scorecards            | Patrones/tendencias                   | No ranking personal ni causalidad automática.      |
| Regulatory change assist | Diff de obligation snapshots autorizados | Lista de posibles bindings impactados | Compliance Officer valida; no legal opinion final. |
| Control gap detection    | Framework/control coverage               | Controles potencialmente faltantes    | Quality Architect review.                          |
| Narrative generation     | Approved scorecard                       | Borrador ejecutivo                    | No inventar cifras; grounding obligatorio.         |
| Evidence quality check   | Receipts/hashes/metadata                 | Señales de stale/missing/duplicate    | No auto FAIL sin rule.                             |
| Improvement suggestion   | Signals + experiments history            | Sugerencias de hipótesis              | No auto prioritize/adopt.                          |

## 25.1 Provenance obligatorio

```
{
"aiRunRef":"ct12-run-uuid",
"modelRef":"model-policy-ref",
"templateRef":"ec12-root-cause-v3",
"evalRef":"eval-suite-uuid",
"groundingRefs":["assessment:uuid","evidence:uuid","indicator-snapshot:uuid"],
"confidence":0.74,
"reviewerSubjectRef":"uuid",
"outcome":"ACCEPTED_WITH_EDITS",
"reviewedAt":"2026-09-12T20:00:00Z"
}
```

| **LÍMITE IA —** AI RECOMMENDATION ≠ QUALITY DECISION. Confidence no se convierte en PASS/FAIL, compliance, waiver, risk acceptance, closure ni gate. Un output IA sin reviewer/provenance es no autoritativo. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 25.2 Evals mínimos antes de habilitar

| **Eval**                | **Objetivo**                                                            | **Criterio**                 |
|-------------------------|-------------------------------------------------------------------------|------------------------------|
| Leakage                 | No debe revelar evidence/PII fuera de scope                             | 0 critical leaks             |
| Grounding               | Claims deben enlazar evidence refs válidos                              | ≥ target definido por tenant |
| Unsupported attribution | No atribuir causa/autor sin evidencia                                   | Muy bajo/0 crítico           |
| Bias                    | No degradar por sede, idioma, modalidad o grupo sensible sin fundamento | Fairness review              |
| False breach            | No convertir anomalía en incumplimiento                                 | 0 auto decisions             |
| Hallucinated regulation | No inventar obligación/legal text                                       | 0                            |
| Prompt injection        | Evidence maliciosa no altera system policy                              | Security pass                |

# 26. Analítica y KPI

EC-12 define indicadores de calidad y sus reglas de interpretación; CT-11 provee datasets/compute. Todo KPI debe declarar grain, window, unit, direction, denominator rules, missing-data policy, source contract, calculator version y comparability group. Un “número” sin estas propiedades no es un indicador gobernado.

| **KPI**                    | **Fórmula conceptual**                                                 | **Grain**         | **Guardrail**                                 |
|----------------------------|------------------------------------------------------------------------|-------------------|-----------------------------------------------|
| Quality Control Coverage   | applicable mandatory controls assessed / applicable mandatory controls | ReviewCycle/Scope | Coverage; no dice effectiveness.              |
| Control Pass Rate          | PASS / terminal applicable assessments                                 | Scope/period      | Reportar PARTIAL/FAIL por separado.           |
| Evidence Freshness Rate    | non-stale mandatory evidence / mandatory evidence                      | Review/control    | Stale ≠ missing.                              |
| Critical NC Density        | critical NC / active programs or editions                              | Portfolio/period  | Denominator versionado.                       |
| CAPA On-Time Rate          | actions verified by due date / due actions                             | Portfolio/period  | Exclude cancelled by rule.                    |
| CAPA Effectiveness Rate    | EFFECTIVE CAPA / verified CAPA                                         | Period            | Completion ≠ effectiveness.                   |
| Median NC Closure Time     | median resolved_at-detected_at                                         | Severity band     | No mezclar severities sin segmentación.       |
| Attestation Freshness      | active non-stale attestations / applicable bindings                    | Scope             | Expired/drift separate.                       |
| Waiver Exposure            | weighted active waiver residual risk                                   | Portfolio         | No ocultar critical/non-waivable.             |
| Quality Debt Aging         | open accepted gaps by age bucket                                       | Portfolio         | Transparent debt.                             |
| Improvement Adoption Rate  | ADOPTED experiments / concluded experiments                            | Portfolio/period  | Rejected learnings retained.                  |
| Improvement Effect Size    | normalized outcome-baseline vs target                                  | Experiment        | Comparability required.                       |
| Portfolio Health Score     | weighted dimension score with coverage/missing policy                  | Portfolio/asOf    | Not simple average.                           |
| Design Quality Index       | framework controls over EC-01 facts                                    | ProgramVersion    | Framework-version specific.                   |
| Delivery Readiness Index   | readiness controls over EC-02/05 facts                                 | Edition           | As-of before launch.                          |
| Assessment Integrity Index | controls over EC-07 process/evidence                                   | Edition/Program   | No regrade.                                   |
| Credential Integrity Index | controls over EC-08 awards/verification                                | Portfolio         | No credential mutation.                       |
| Learner Experience Index   | approved EC-11 metrics under privacy/suppression                       | Program/Edition   | NPS not conflated with satisfaction.          |
| Impact Evidence Coverage   | impact measurements/evidence complete                                  | Program/Corporate | Purpose aware.                                |
| Corporate SLA Quality      | EC-09 SLA/milestone quality controls                                   | Engagement        | Finance separate.                             |
| Regulatory Drift Backlog   | unresolved drift alerts                                                | Tenant/portfolio  | Count + age.                                  |
| Quality Gate Failure Rate  | FAIL gates / terminal gates                                            | GateCode/period   | CONDITIONAL separate.                         |
| Snapshot Freshness         | approved snapshots within max age                                      | Portfolio         | Freshness derived from oldest critical input. |
| Reconciliation Backlog     | UNKNOWN_EFFECT pending beyond target                                   | Technical         | Operational SLI/KPI.                          |

## 26.1 Ejemplo de semántica formal de indicador

```
Indicator: EC12_CAPA_ON_TIME_RATE v2
Grain: TENANT x MONTH x SEVERITY
Unit: PERCENT
Direction: HIGHER_BETTER
Numerator: corrective actions VERIFIED on/before due_at
Denominator: corrective actions whose due_at falls in period, excluding CANCELLED under policy v3
Missing policy: NO_DATA when denominator=0; never return numeric 0
Dataset contract: ct11://quality/capa-actions/v2
Calculator: ec12-metrics-4.1
Comparability group: CAPA_OTR_2026
Thresholds: GREEN>=0.95; WATCH[0.85,0.95); BREACH<0.85
```

# 27. Migración legacy y Data Quality con CT-16

Migrar “calidad” es particularmente riesgoso porque los legados suelen mezclar checklist, auditoría, documentos, indicadores, riesgos y tareas en hojas de cálculo. El objetivo no es copiar celdas: es reconstruir semánticas y separar hechos. Todo legacy record debe conservar source_system/source_key, raw hash, mapping decision, reviewer y promotion receipt.

| **Fase**         | **Actividad**                                                                                                                                   |
|------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| 1\. Extract      | Frameworks, checklists, auditorías, hallazgos, evidencias, KPIs, waivers y acciones; preservar raw/source keys.                                 |
| 2\. Profile      | Duplicados, missing owners, expired waivers, orphan evidence, contradictory statuses, formula ambiguity, tenant contamination.                  |
| 3\. Normalize    | Codes, dates/timezones, severity, states, units, percentages, scope identifiers; no inventar datos críticos.                                    |
| 4\. Map          | Legacy checklist → Framework/ControlVersion; audit row → Review/Assessment; finding → NC; action → CAPA; metric → IndicatorDefinition/Snapshot. |
| 5\. Validate     | BR-EC12 + cross-ref resolution + obligation/version evidence + tenant/scope + hash checks.                                                      |
| 6\. Dry-run      | Crear candidates/conflicts/coverage report sin persistir verdad final.                                                                          |
| 7\. Human review | Resolver PASS sin evidence, waivers sin expiry, KPI formula no reproducible, scope ambiguo, merged tenants.                                     |
| 8\. Promote      | Invocar domain/application APIs con migration context; no INSERT directo a tablas finales.                                                      |
| 9\. Reconcile    | Counts/hashes/state distributions/spot evidence vs source; conservar discrepancies.                                                             |
| 10\. Certify     | Data Steward + Quality Owner firman evidence pack y cutover readiness.                                                                          |

## 27.1 Reglas de Data Quality

- Legacy PASS sin evidence verificable se importa como UNVERIFIED/needs review, nunca como PASS definitivo.

- Un KPI histórico sin fórmula/denominator demostrable queda NON_COMPARABLE y no se mezcla en trend moderno.

- Waiver sin expiry no puede promoverse como ACTIVE; requiere remediation decision.

- Hallazgo cerrado sin effectiveness evidence puede mapearse CLOSED_LEGACY con limitation note, no “EFFECTIVE”.

- Evidence path/URL rota se conserva como lineage pero verification_state=UNAVAILABLE.

- Tenant/scope ambiguo bloquea promoción.

- IDs/codes duplicados se resuelven con merge/split decision explícita y mapping table CT-16.

- Cada promoted aggregate lleva migration batch/source lineage y audit reason.

# 28. QA y estrategia de pruebas

| **Nivel**              | **Cobertura**                                                                          | **Gate**                                     |
|------------------------|----------------------------------------------------------------------------------------|----------------------------------------------|
| Unit                   | State machines, scoring, missing-data, thresholds, applicability, waiver, CAPA closure | Domain coverage + mutation testing selectivo |
| DB/Testcontainers      | RLS, composite FK, checks, partial indexes, triggers, append-only, concurrency         | PostgreSQL real                              |
| Contract               | OpenAPI/AsyncAPI + EC/CT ports                                                         | Backward compatibility + schema tests        |
| Integration            | CT-05/06/07/09/10/11/12/13 + obligation registry                                       | Stubs + failure injection                    |
| Security               | IDOR, cross-tenant, privilege, SoD, step-up, formula injection, export abuse           | Negative-first suite                         |
| Concurrency            | double publish, double assessment lock, double waiver approve, double gate             | Race harness                                 |
| Idempotency            | same key/same payload, same key/different payload, crash/lease recovery                | Durable storage                              |
| Resilience             | timeouts, circuit open, UNKNOWN_EFFECT, reconciliation, duplicate events               | Chaos scenarios                              |
| Analytics correctness  | golden vectors for formula/normalization/weights/NO_DATA                               | Deterministic calculator                     |
| Reproducibility        | rebuild snapshot from pinned inputs yields same hash                                   | Hash equality                                |
| Compliance time travel | expiry/drift/effective dates/waiver windows                                            | Clock-controlled tests                       |
| AI evals               | leakage, grounding, hallucination, bias, prompt injection                              | CT-12 eval gate                              |
| Accessibility          | WCAG AA workspaces + keyboard/screen reader                                            | Automated + manual                           |
| Performance            | 1k assessments, 500 indicators, 10k receipts, large alert history                      | p95/p99 + query plans                        |
| Migration              | dry-run, mapping, promotion, reconcile, rollback-forward                               | CT-16 evidence                               |
| N/N-1                  | Expand/contract with mixed app versions                                                | Zero-downtime rehearsal                      |

## 28.1 Test vectors obligatorios de Health Score

| **Vector** | **Input**                        | **Expected**                                              |
|------------|----------------------------------|-----------------------------------------------------------|
| TV-H-01    | Todos VALUE, weights sum 1       | Score reproducible exacto.                                |
| TV-H-02    | Una dimensión NO_DATA            | Aplicar missing policy; no convertir a 0.                 |
| TV-H-03    | Una dimensión NOT_APPLICABLE     | Renormalizar solo si framework policy lo ordena.          |
| TV-H-04    | Coverage debajo minimum          | Snapshot PARTIAL/INSUFFICIENT, no score “verde”.          |
| TV-H-05    | Input STALE crítico              | Health freshness STALE aunque otros inputs estén frescos. |
| TV-H-06    | Indicator version non-comparable | Trend bloqueado/flagged.                                  |
| TV-H-07    | Weight \>1 o negative            | Reject publish/DB check.                                  |
| TV-H-08    | Same inputs/calculator           | Mismo content_hash.                                       |

# 29. Golden Scenarios

| **GS**      | **Escenario**                        | **Precondición**                                       | **Acción**                            | **Resultado esperado**                                         | **Evidencia**                 |
|-------------|--------------------------------------|--------------------------------------------------------|---------------------------------------|----------------------------------------------------------------|-------------------------------|
| GS-EC12-001 | Publish framework happy              | DRAFT framework valid                                  | Publish with step-up/SoD              | PUBLISHED immutable + receipt/outbox                           | audit/event/receipt           |
| GS-EC12-002 | Framework ETag conflict              | Two editors same revision                              | Second publish/update                 | 412, no lost update                                            | trace + screenshot            |
| GS-EC12-003 | Invalid weights                      | Weights sum !=1                                        | Validate/publish                      | Rejected with validation issues                                | hash/reproducibility evidence |
| GS-EC12-004 | Published framework tamper           | PUBLISHED exists                                       | PATCH/DB update                       | Blocked domain/DB                                              | contract test + DB assertion  |
| GS-EC12-005 | Publish control                      | Valid control/evidence reqs                            | Publish                               | Immutable ControlVersion                                       | audit/event/receipt           |
| GS-EC12-006 | Control stale binding                | New obligation version                                 | Re-evaluate bindings                  | Drift alert, no history rewrite                                | trace + screenshot            |
| GS-EC12-007 | Evidence receipt happy               | Valid CT-05 artifact/hash                              | Record receipt                        | Append-only receipt                                            | hash/reproducibility evidence |
| GS-EC12-008 | Evidence hash mismatch               | Artifact changed/mismatch                              | Verify                                | FAIL/UNVERIFIED, no PASS                                       | contract test + DB assertion  |
| GS-EC12-009 | Review plan                          | Framework+scope valid                                  | Plan review                           | PLANNED with pinned version                                    | audit/event/receipt           |
| GS-EC12-010 | Cross-tenant review scope            | Tenant A request ref Tenant B                          | Add scope                             | Denied API+RLS                                                 | trace + screenshot            |
| GS-EC12-011 | Freeze evidence                      | Review IN_PROGRESS                                     | Freeze                                | Scope/watermark locked                                         | hash/reproducibility evidence |
| GS-EC12-012 | Add evidence after freeze            | Frozen review                                          | Attempt add mutable evidence          | Rejected or governed reopen                                    | contract test + DB assertion  |
| GS-EC12-013 | Assessment PASS                      | All mandatory evidence fresh                           | Assess+lock                           | PASS locked                                                    | audit/event/receipt           |
| GS-EC12-014 | Assessment missing evidence          | Required evidence absent                               | Assess PASS                           | 422 insufficient                                               | trace + screenshot            |
| GS-EC12-015 | Assessment NOT_APPLICABLE valid      | Applicability rule proves NA                           | Assess                                | NA with rationale                                              | hash/reproducibility evidence |
| GS-EC12-016 | Assessment NA abuse                  | No rule/rationale                                      | Assess NA                             | Rejected                                                       | contract test + DB assertion  |
| GS-EC12-017 | Independent SoD                      | Submitter tries independent approve                    | Lock assessment                       | 403 SOD_VIOLATION                                              | audit/event/receipt           |
| GS-EC12-018 | Double assessment race               | Two reviewers terminal same control/scope              | Concurrent lock                       | One wins; unique/ETag prevents duplicate                       | trace + screenshot            |
| GS-EC12-019 | Close review happy                   | All controls terminal                                  | Close                                 | CLOSED + summary receipt                                       | hash/reproducibility evidence |
| GS-EC12-020 | Close review incomplete              | Mandatory unassessed                                   | Close                                 | Rejected                                                       | contract test + DB assertion  |
| GS-EC12-021 | Open critical NC                     | FAIL critical control                                  | Create/auto open NC                   | CRITICAL OPEN with lineage                                     | audit/event/receipt           |
| GS-EC12-022 | Severity downgrade abuse             | Manager lowers critical without approval               | Change severity                       | Denied/audited                                                 | trace + screenshot            |
| GS-EC12-023 | CAPA happy                           | Critical NC triaged                                    | Create/approve CAPA                   | ACTIVE plan                                                    | hash/reproducibility evidence |
| GS-EC12-024 | Verify action                        | Action completion evidence exists                      | Verify                                | VERIFIED                                                       | contract test + DB assertion  |
| GS-EC12-025 | CAPA ineffective                     | Outcome below target                                   | Verify effectiveness                  | INEFFECTIVE; NC not closed                                     | audit/event/receipt           |
| GS-EC12-026 | NC close before effectiveness        | Actions done only                                      | Close NC                              | Rejected                                                       | trace + screenshot            |
| GS-EC12-027 | NC close happy                       | CAPA effective                                         | Close                                 | CLOSED immutable receipt                                       | hash/reproducibility evidence |
| GS-EC12-028 | Accepted risk                        | Policy allows                                          | Accept risk with waiver               | Visible ACCEPTED_RISK, not PASS                                | contract test + DB assertion  |
| GS-EC12-029 | Improvement experiment happy         | Baseline frozen                                        | Run/conclude                          | Outcome snapshot + decision                                    | audit/event/receipt           |
| GS-EC12-030 | Change metric mid experiment         | RUNNING                                                | PATCH primary indicator               | Rejected/abort+redesign                                        | trace + screenshot            |
| GS-EC12-031 | Adopt without result                 | No outcome evidence                                    | Adopt                                 | Rejected                                                       | hash/reproducibility evidence |
| GS-EC12-032 | Rejected experiment                  | Outcome below target                                   | Reject                                | Learning preserved                                             | contract test + DB assertion  |
| GS-EC12-033 | Indicator activate                   | Definition valid                                       | Activate                              | ACTIVE immutable semantics                                     | audit/event/receipt           |
| GS-EC12-034 | Raw SQL formula injection            | Formula contains SQL/script                            | Validate                              | Rejected                                                       | trace + screenshot            |
| GS-EC12-035 | Indicator snapshot happy             | CT-11 dataset available                                | Build                                 | READY with watermark/hash                                      | hash/reproducibility evidence |
| GS-EC12-036 | Dataset unavailable                  | CT-11 down                                             | Build                                 | UNAVAILABLE/UNKNOWN_EFFECT, not zero                           | contract test + DB assertion  |
| GS-EC12-037 | Zero denominator                     | No eligible denominator                                | Compute rate                          | NO_DATA per policy, not 0                                      | audit/event/receipt           |
| GS-EC12-038 | True zero                            | Eligible denominator \>0 numerator=0                   | Compute                               | VALUE=0                                                        | trace + screenshot            |
| GS-EC12-039 | Stale input                          | Dataset watermark old                                  | Build                                 | STALE                                                          | hash/reproducibility evidence |
| GS-EC12-040 | Partial input                        | One segment unavailable                                | Build                                 | PARTIAL                                                        | contract test + DB assertion  |
| GS-EC12-041 | Threshold band                       | Value crosses WATCH                                    | Classify                              | WATCH deterministic                                            | audit/event/receipt           |
| GS-EC12-042 | Overlapping thresholds               | Invalid config                                         | Publish threshold                     | Rejected                                                       | trace + screenshot            |
| GS-EC12-043 | Health happy                         | Coverage sufficient                                    | Build health                          | Deterministic score/hash                                       | hash/reproducibility evidence |
| GS-EC12-044 | Health missing critical              | Coverage low                                           | Build                                 | PARTIAL/INSUFFICIENT                                           | contract test + DB assertion  |
| GS-EC12-045 | Non-comparable trend                 | Indicator versions different groups                    | Compare                               | Blocked/flagged                                                | audit/event/receipt           |
| GS-EC12-046 | Snapshot rebuild                     | Same pinned inputs                                     | Rebuild                               | Same hash                                                      | trace + screenshot            |
| GS-EC12-047 | Scorecard approve                    | READY snapshot set                                     | Approve                               | Immutable approved scorecard                                   | hash/reproducibility evidence |
| GS-EC12-048 | Scorecard tamper                     | APPROVED                                               | Update summary                        | Blocked                                                        | contract test + DB assertion  |
| GS-EC12-049 | Attestation happy                    | Binding/evidence valid                                 | Approve                               | APPROVED with expiry                                           | audit/event/receipt           |
| GS-EC12-050 | Attestation expired                  | Clock passes expiry                                    | Query                                 | EXPIRED, not COMPLIANT                                         | trace + screenshot            |
| GS-EC12-051 | Regulatory drift                     | Obligation version changes                             | Ingest event                          | STALE attestation + alert                                      | hash/reproducibility evidence |
| GS-EC12-052 | Attestation auto rewrite             | Old attestation exists                                 | Change obligation version             | No history rewrite                                             | contract test + DB assertion  |
| GS-EC12-053 | Waiver happy                         | Waivable control                                       | Approve with expiry/compensation      | ACTIVE                                                         | audit/event/receipt           |
| GS-EC12-054 | Non-waivable control                 | Policy non-waivable                                    | Approve                               | Rejected                                                       | trace + screenshot            |
| GS-EC12-055 | Waiver no expiry                     | Request missing expiry                                 | Approve                               | Rejected DB/domain                                             | hash/reproducibility evidence |
| GS-EC12-056 | Waiver expired                       | Clock passes expiresAt                                 | Evaluate control                      | No longer satisfies gap                                        | contract test + DB assertion  |
| GS-EC12-057 | Waiver extension                     | Active near expiry                                     | Edit expires_at                       | Rejected; create new waiver                                    | audit/event/receipt           |
| GS-EC12-058 | Waiver revoke                        | Risk changed                                           | Revoke                                | REVOKED + event                                                | trace + screenshot            |
| GS-EC12-059 | Alert dedup                          | Same breach repeated                                   | Create alert twice                    | One active alert/dedup                                         | hash/reproducibility evidence |
| GS-EC12-060 | Alert resolve                        | Cause addressed                                        | Resolve                               | RESOLVED with reason                                           | contract test + DB assertion  |
| GS-EC12-061 | Gate PASS                            | All mandatory controls pass                            | Issue gate                            | PASS receipt                                                   | audit/event/receipt           |
| GS-EC12-062 | Gate CONDITIONAL                     | Minor gaps + valid waivers                             | Issue                                 | CONDITIONAL with conditions                                    | trace + screenshot            |
| GS-EC12-063 | Gate FAIL                            | Mandatory critical fail                                | Issue                                 | FAIL                                                           | hash/reproducibility evidence |
| GS-EC12-064 | Gate idempotent request              | Same requestKey replay                                 | Submit                                | Same logical decision/status                                   | contract test + DB assertion  |
| GS-EC12-065 | Gate delivery timeout                | Owner ack unknown                                      | Send event                            | Delivery UNKNOWN_EFFECT, reconcile                             | audit/event/receipt           |
| GS-EC12-066 | Owner applied gate                   | Reconcile after timeout                                | Query owner state                     | Confirm without duplicate                                      | trace + screenshot            |
| GS-EC12-067 | Evidence pack happy                  | Authorized auditor                                     | Build pack                            | Artifact+hash+receipt                                          | hash/reproducibility evidence |
| GS-EC12-068 | Evidence pack denied                 | No purpose/role                                        | Build                                 | 403 + audit                                                    | contract test + DB assertion  |
| GS-EC12-069 | AI root cause assist                 | Authorized evidence                                    | Run CT-12                             | Suggestion + provenance                                        | audit/event/receipt           |
| GS-EC12-070 | AI hallucinated regulation           | Model output unsupported                               | Review                                | Rejected; no decision                                          | trace + screenshot            |
| GS-EC12-071 | AI unavailable                       | CT-12 down                                             | Assess control manually               | Critical flow continues                                        | hash/reproducibility evidence |
| GS-EC12-072 | AI prompt injection                  | Malicious evidence text                                | Run                                   | Policy resists; no tool abuse                                  | contract test + DB assertion  |
| GS-EC12-073 | Idempotency same payload             | Repeat command/key                                     | Replay                                | Same result                                                    | audit/event/receipt           |
| GS-EC12-074 | Idempotency payload mismatch         | Same key different payload                             | Replay                                | 409                                                            | trace + screenshot            |
| GS-EC12-075 | Idempotency crash lease              | Worker crashes IN_PROGRESS                             | Recovery                              | Lease expires/recover safely                                   | hash/reproducibility evidence |
| GS-EC12-076 | Outbox duplicate publish             | At-least-once delivery                                 | Consumer receives duplicate           | Inbox dedup                                                    | contract test + DB assertion  |
| GS-EC12-077 | Outbox multi instance                | Two dispatchers                                        | Claim same batch                      | SKIP LOCKED/lease no double ownership                          | audit/event/receipt           |
| GS-EC12-078 | Inbox replay                         | Same event messageId                                   | Process twice                         | One effect                                                     | trace + screenshot            |
| GS-EC12-079 | Policy unavailable critical          | CT-10 down                                             | Approve waiver                        | Fail-closed                                                    | hash/reproducibility evidence |
| GS-EC12-080 | Policy stale read                    | Allowed read policy cache                              | Open published scorecard              | Explicit STALE if permitted                                    | contract test + DB assertion  |
| GS-EC12-081 | Migration valid                      | Legacy review/evidence mapped                          | Dry-run/promote                       | Domain APIs + receipts                                         | audit/event/receipt           |
| GS-EC12-082 | Migration PASS no evidence           | Legacy says PASS only                                  | Promote                               | UNVERIFIED/manual review                                       | trace + screenshot            |
| GS-EC12-083 | Migration KPI formula unknown        | Legacy score only                                      | Promote                               | NON_COMPARABLE                                                 | hash/reproducibility evidence |
| GS-EC12-084 | Migration waiver no expiry           | Legacy waiver active                                   | Promote                               | Blocked/remediation                                            | contract test + DB assertion  |
| GS-EC12-085 | RLS read leakage                     | Tenant A SQL by app to B id                            | Query                                 | 0 rows/denied                                                  | audit/event/receipt           |
| GS-EC12-086 | RLS write leakage                    | Tenant A inserts child B parent                        | Write                                 | FK/RLS prevents                                                | trace + screenshot            |
| GS-EC12-087 | IDOR UUID known                      | User knows B gate id                                   | GET                                   | 403/404 policy                                                 | hash/reproducibility evidence |
| GS-EC12-088 | Mass assignment tenant               | Body includes tenantId                                 | POST                                  | Ignored/rejected                                               | contract test + DB assertion  |
| GS-EC12-089 | Step-up missing                      | Approve critical decision                              | Command                               | 403 step-up required                                           | audit/event/receipt           |
| GS-EC12-090 | SoD create+approve                   | Same actor waiver create/approve                       | Approve                               | Denied                                                         | trace + screenshot            |
| GS-EC12-091 | Export leakage                       | Scorecard profile excludes rationale                   | Export                                | Fields suppressed                                              | hash/reproducibility evidence |
| GS-EC12-092 | PII in logs                          | Sensitive rationale                                    | Process error                         | Logs redacted                                                  | contract test + DB assertion  |
| GS-EC12-093 | Performance large review             | 1000 assessments                                       | Open workspace                        | Within budget/paginated                                        | audit/event/receipt           |
| GS-EC12-094 | Performance 500 indicators           | Build health                                           | Async                                 | Within target                                                  | trace + screenshot            |
| GS-EC12-095 | Alert storm                          | 1000 same drift events                                 | Ingest                                | Dedup/rate controlled                                          | hash/reproducibility evidence |
| GS-EC12-096 | Resource exhaustion                  | Repeated evidence pack                                 | Abuse                                 | Quota/rate-limit                                               | contract test + DB assertion  |
| GS-EC12-097 | N/N-1 expand                         | Mixed pods during new nullable columns                 | Operate                               | Compatible                                                     | audit/event/receipt           |
| GS-EC12-098 | N/N-1 contract too early             | Old pods still live                                    | Drop column attempt                   | Gate blocks                                                    | trace + screenshot            |
| GS-EC12-099 | Backup restore                       | Restore snapshot                                       | Integrity verify                      | Hashes/RLS/lineage intact                                      | hash/reproducibility evidence |
| GS-EC12-100 | Retention legal hold                 | Evidence due disposition but hold active               | Dispose                               | Blocked with reason                                            | contract test + DB assertion  |
| GS-EC12-101 | Drift after review freeze            | Upstream fact changes                                  | Detect                                | Impacted review/snapshot STALE per policy                      | audit/event/receipt           |
| GS-EC12-102 | Quality debt visible                 | Accepted gap active                                    | Executive dashboard                   | Visible with due/risk                                          | trace + screenshot            |
| GS-EC12-103 | Quality debt overdue                 | Due date passes                                        | Scheduler event                       | Alert/escalation                                               | hash/reproducibility evidence |
| GS-EC12-104 | Quality debt hidden attempt          | Filter excludes accepted risk                          | Build scorecard                       | Policy forces disclosure                                       | contract test + DB assertion  |
| GS-EC12-105 | Mobile approval step-up              | Board member mobile                                    | Approve waiver                        | Biometric/MFA + reason                                         | audit/event/receipt           |
| GS-EC12-106 | Mobile offline evidence              | Temporary offline                                      | Capture metadata/blob via CT-05 queue | Encrypted queue + eventual receipt                             | trace + screenshot            |
| GS-EC12-107 | Accessibility keyboard               | Reviewer no mouse                                      | Complete assessment                   | All controls accessible                                        | hash/reproducibility evidence |
| GS-EC12-108 | Screen reader state                  | UNKNOWN_EFFECT operation                               | Announce status                       | Live region/semantic label                                     | contract test + DB assertion  |
| GS-EC12-109 | Localization                         | Spanish/German labels                                  | Render framework                      | Same canonical codes/versions                                  | audit/event/receipt           |
| GS-EC12-110 | Timezone expiry                      | Waiver near midnight zones                             | Evaluate expiry                       | UTC instant consistent                                         | trace + screenshot            |
| GS-EC12-111 | Clock skew                           | Worker time differs                                    | Expiry/review                         | DB/clock contract prevents inconsistent terminal state         | hash/reproducibility evidence |
| GS-EC12-112 | Duplicate obligation event           | Registry replays update                                | Consume                               | Inbox dedup no duplicate drift                                 | contract test + DB assertion  |
| GS-EC12-113 | External registry unavailable        | Need obligation detail                                 | Open compliance matrix                | STALE signed snapshot or UNAVAILABLE; no fabricated legal text | audit/event/receipt           |
| GS-EC12-114 | Obligation signature invalid         | Registry event spoofed                                 | Consume                               | Rejected/security alert                                        | trace + screenshot            |
| GS-EC12-115 | CT-05 artifact deleted per policy    | Old receipt remains                                    | Open evidence                         | UNAVAILABLE metadata, history preserved                        | hash/reproducibility evidence |
| GS-EC12-116 | CT-11 correction                     | Dataset superseded                                     | Rebuild snapshot                      | New snapshot supersedes; old hash retained                     | contract test + DB assertion  |
| GS-EC12-117 | Threshold change                     | New threshold version                                  | Historical scorecard                  | Uses pinned old thresholds                                     | audit/event/receipt           |
| GS-EC12-118 | Framework superseded                 | New framework published                                | Historical review                     | Keeps old framework version                                    | trace + screenshot            |
| GS-EC12-119 | Control retired                      | Control retired today                                  | Old assessment                        | Still resolvable                                               | hash/reproducibility evidence |
| GS-EC12-120 | Attestation superseded               | New obligation + new attestation                       | Query history                         | Both preserved with lineage                                    | contract test + DB assertion  |
| GS-EC12-121 | Concurrent CAPA edit                 | Two managers same CAPA revision                        | Concurrent update                     | One 200, one 412; no lost update                               | audit/event/DB assertion      |
| GS-EC12-122 | Concurrent scorecard approve         | Two approvers                                          | Approve same READY snapshot           | Single terminal receipt/idempotent outcome                     | audit/event/DB assertion      |
| GS-EC12-123 | Concurrent waiver revoke/expire      | Scheduler and approver same instant                    | Expire/revoke                         | Deterministic terminal state + audit                           | audit/event/DB assertion      |
| GS-EC12-124 | Review reopen governed               | Frozen review needs new evidence                       | Request reopen with reason            | New revision/receipt; old freeze history preserved             | audit/event/DB assertion      |
| GS-EC12-125 | Evidence stale during review         | Artifact age crosses max                               | Lock assessment                       | PASS blocked or state stale                                    | audit/event/DB assertion      |
| GS-EC12-126 | Evidence classification downgrade    | Attempt to lower RESTRICTED                            | Edit receipt                          | Blocked append-only; new classification decision elsewhere     | audit/event/DB assertion      |
| GS-EC12-127 | Metric unit mismatch                 | Snapshot unit differs from definition                  | Build                                 | Rejected                                                       | audit/event/DB assertion      |
| GS-EC12-128 | Health weight missing dimension      | Published framework corrupt fixture                    | Build                                 | Fail-safe validation                                           | audit/event/DB assertion      |
| GS-EC12-129 | Scorecard suppressed field           | Profile forbids sensitive rationale                    | Build                                 | Suppressed, not blank/zero                                     | audit/event/DB assertion      |
| GS-EC12-130 | Attestation evidence drift           | Artifact replaced upstream                             | Verify hash                           | Attestation stale/alert according policy                       | audit/event/DB assertion      |
| GS-EC12-131 | CAPA external change unknown         | Owner module timeout                                   | Record action completion              | UNKNOWN_EFFECT until reconcile                                 | audit/event/DB assertion      |
| GS-EC12-132 | Improvement upstream rollout partial | Feature flag 50%                                       | Measure                               | PARTIAL/segmented outcome, no premature adopt                  | audit/event/DB assertion      |
| GS-EC12-133 | Gate requester retries after timeout | Same request key                                       | Retry                                 | Same operation/decision                                        | audit/event/DB assertion      |
| GS-EC12-134 | Gate scope mismatch                  | Edition gate with program ref                          | Submit                                | 422                                                            | audit/event/DB assertion      |
| GS-EC12-135 | Compliance binding overlap           | Duplicate active binding same obligation/control/scope | Create                                | Unique/policy reject                                           | audit/event/DB assertion      |
| GS-EC12-136 | Waiver compensating controls missing | Risk high, list empty                                  | Approve                               | Rejected                                                       | audit/event/DB assertion      |
| GS-EC12-137 | Alert SLA escalation                 | Critical alert overdue                                 | Scheduler tick                        | Escalation event, state retained                               | audit/event/DB assertion      |
| GS-EC12-138 | Alert dismiss without reason         | Analyst dismisses                                      | Command                               | Rejected                                                       | audit/event/DB assertion      |
| GS-EC12-139 | Retention snapshot approval active   | Disposition input evidence                             | Run retention                         | Preserve required assurance refs                               | audit/event/DB assertion      |
| GS-EC12-140 | Crypto-shred PII where allowed       | Retention due                                          | Dispose sensitive payload             | Receipt, business lineage intact                               | audit/event/DB assertion      |

Catálogo total: 140 Golden Scenarios. Deben ejecutarse/automatizarse según su naturaleza y dejar evidencia trazable por gate.

# 30. UAT institucional

| **UAT** | **Escenario**            | **Criterio de aceptación**                                                                 |
|---------|--------------------------|--------------------------------------------------------------------------------------------|
| UAT-01  | Publicación de framework | Quality Architect/Approver publican versión; queda inmutable y trazable.                   |
| UAT-02  | Review de programa       | Se evalúa ProgramVersion contra controles pinneados sin modificar EC-01.                   |
| UAT-03  | Gate de edición          | EC-02 solicita readiness y consume PASS/CONDITIONAL/FAIL receipt.                          |
| UAT-04  | Evidencia                | Artifact CT-05 se vincula por receipt/hash; stale/missing se distingue.                    |
| UAT-05  | SoD                      | Submitter no puede aprobar assessment independiente/waiver si policy lo prohíbe.           |
| UAT-06  | Nonconformity/CAPA       | FAIL crítico abre NC; acciones verificadas no bastan hasta effectiveness.                  |
| UAT-07  | Mejora continua          | Experiment con baseline/target concluye ADOPT/REJECT con learning.                         |
| UAT-08  | Indicator NO_DATA        | Denominator inexistente produce NO_DATA, no numeric zero.                                  |
| UAT-09  | Portfolio Health         | Score reproduce exactamente con versions/watermarks/weights pinneados.                     |
| UAT-10  | Compliance drift         | Nueva obligation version vuelve stale la attestation y genera alert.                       |
| UAT-11  | Waiver                   | Excepción exige risk, compensating controls, SoD y expiry; luego expira automáticamente.   |
| UAT-12  | Quality debt             | Gap aceptado sigue visible y overdue genera escalation.                                    |
| UAT-13  | Scorecard                | Aprobado queda immutable; export aplica profile/purpose.                                   |
| UAT-14  | UNKNOWN_EFFECT           | Timeout CT-11/CT-05/CT-13 se reconcilia sin duplicar side effects.                         |
| UAT-15  | Tenant isolation         | Cross-tenant read/write falla en API y PostgreSQL.                                         |
| UAT-16  | IA                       | Root-cause suggestion muestra provenance y no cierra/decide automáticamente.               |
| UAT-17  | Migration                | Legacy review/KPI/waiver se dry-run, promueve por domain y reconcilia.                     |
| UAT-18  | Mobile                   | Executive view y approvals selectivas respetan step-up/SoD.                                |
| UAT-19  | Accessibility            | Reviewer completa review crítica usando teclado/screen reader.                             |
| UAT-20  | N/N-1                    | Expand/contract opera con versiones de app N/N-1.                                          |
| UAT-21  | Evidence Pack            | Auditor reconstruye decisión sin acceso SQL a upstream.                                    |
| UAT-22  | Cierre EC                | Board visualiza calidad integrada de EC-01…EC-11 con lineage y sin shadow Source of Truth. |

# 31. Gates G1-G10

| **Gate** | **Dominio**                    | **Evidencia mínima**                                                                                     |
|----------|--------------------------------|----------------------------------------------------------------------------------------------------------|
| G1       | Arquitectura y bounded context | Context map, Source of Truth, anti-scope, ADRs, dependency rules y no cross-context FK aprobados.        |
| G2       | Datos/constraints              | DDL, composite FK, RLS FORCE, immutability/append-only triggers, indexes y DB tests green.               |
| G3       | Backend                        | Aggregates, state machines, commands/queries, revision/ETag, idempotency, outbox/inbox y reconciliation. |
| G4       | API/Event contracts            | OpenAPI/AsyncAPI versionados, generated client, contract/compatibility tests.                            |
| G5       | Frontend/Mobile                | Workspaces, explicit states, a11y, responsive, mobile boundaries y e2e.                                  |
| G6       | Seguridad/auditoría            | Threat model, RBAC/ABAC/SoD/step-up, evidence protection, Secure SDLC, pentest findings.                 |
| G7       | Integraciones/resiliencia      | CT/EC adapters, timeout/retry/circuit/UNKNOWN_EFFECT/reconciliation/chaos tests.                         |
| G8       | QA/UAT                         | BR mapping, Golden Scenarios, calculator vectors, UAT institutional signed.                              |
| G9       | Migración/operaciones          | CT-16, dashboards/alerts/SLO, runbooks, backup/restore, retention, on-call readiness.                    |
| G10      | Release/certificación          | DoR/DoD, SBOM, N/N-1 expand-contract, evidence pack y release sign-off.                                  |

## 31.1 Evidencia de aprobación

**G1 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G2 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G3 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G4 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G5 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G6 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G7 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G8 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G9 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

**G10 —** PASS requiere evidence refs verificables y responsable; “aprobado por reunión” sin artefacto/receipt no satisface el Gate.

# 32. Definition of Ready / Definition of Done

## 32.1 Definition of Ready

- [ ] Source of Truth y anti-scope de capability definidos.

- [ ] Aggregate/owner/state machine identificados.

- [ ] BR/UC afectados identificados.

- [ ] Data classification/purpose/retention definidos.

- [ ] Cross-context contracts y failure modes documentados.

- [ ] DB invariants/constraints previstos.

- [ ] OpenAPI/AsyncAPI change impact analizado.

- [ ] Threat model delta definido.

- [ ] Observability/SLI y test strategy definidos.

- [ ] Migration/backfill/feature flag plan si cambia schema.

- [ ] UX states NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT/SUPPRESSED resueltos.

- [ ] Acceptance evidence y gate owner definidos.

## 32.2 Definition of Done

- [ ] Domain/API/DB implementation completa y revisada.

- [ ] RLS/tenant negative tests green.

- [ ] ETag/idempotency/outbox/inbox/reconciliation tests green.

- [ ] OpenAPI/AsyncAPI regenerated and compatible.

- [ ] Frontend/Mobile/e2e/a11y green.

- [ ] Threat model controls implemented; SAST/SCA/secret/container/SBOM gates green.

- [ ] Performance budgets accepted.

- [ ] Observability dashboards/alerts/runbooks deployed.

- [ ] Migration dry-run/reconcile/certify complete when applicable.

- [ ] Golden Scenarios relevant automated/executed.

- [ ] UAT evidence accepted.

- [ ] G1-G10 PASS with evidence.

- [ ] Documentation/ADRs/Engineering Pack synchronized.

- [ ] No P0/P1 unresolved without approved accepted-risk + expiry.

# 33. Runbooks

| **Runbook** | **Trigger**                       | **Procedimiento resumido**                                                                                                                    |
|-------------|-----------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| RB-EC12-001 | Outbox backlog                    | Check DB/lease/consumer health → pause only if needed → recover expired leases → verify no duplicate effect → capture incident evidence.      |
| RB-EC12-002 | UNKNOWN_EFFECT analytics job      | Lookup CT-11 job by request key → confirm result → attach snapshot or prove absence → retry only if safe.                                     |
| RB-EC12-003 | Regulatory drift spike            | Validate source authenticity/version → group bindings → mark impacted attestations STALE → notify owners → launch reviews.                    |
| RB-EC12-004 | Evidence unavailable              | Check CT-05 artifact state/access → verify retention/hold → mark UNAVAILABLE/PARTIAL → do not fabricate PASS.                                 |
| RB-EC12-005 | Critical NC overdue               | Confirm owner/waiver/status → escalate per policy → prevent silent close → board notification.                                                |
| RB-EC12-006 | Waiver expiring                   | Notify T-30/T-7/T-1 → require new request if extension → expire automatically → reevaluate affected controls.                                 |
| RB-EC12-007 | Snapshot reproducibility mismatch | Freeze writes to affected calculator version → compare dataset watermark/formula/code → invalidate new snapshot → open NC if integrity issue. |
| RB-EC12-008 | Cross-tenant suspicion            | Stop affected path → preserve audit/traces → revoke session/credentials as CT-10 instructs → verify RLS/role → incident escalation.           |
| RB-EC12-009 | Quality gate delivery timeout     | Keep issued decision immutable → reconcile requester ack/state → resend same event/idempotency key if proven safe.                            |
| RB-EC12-010 | AI unsafe output                  | Quarantine insight → preserve ai_run/eval refs → disable feature flag → manual path → CT-12 incident/eval review.                             |
| RB-EC12-011 | Failed Flyway rollout             | Stop rollout → keep N/N-1 compatible schema → roll forward fix → never destructive rollback blindly.                                          |
| RB-EC12-012 | Restore verification              | Restore backup → verify RLS, hashes, FK, snapshots, evidence lineage, outbox/inbox states → sign recovery evidence.                           |

# 34. ADRs y decisiones abiertas

| **ADR**      | **Tema**                                                            | **Estado** | **Decisión/pendiente**                                                                |
|--------------|---------------------------------------------------------------------|------------|---------------------------------------------------------------------------------------|
| ADR-EC12-001 | EC-12 as Quality/Governance bounded context                         | Adopted    | No general BI/GRC god-module.                                                         |
| ADR-EC12-002 | CT-11 owns datasets; EC-12 owns governed metric semantics/snapshots | Adopted    | Prevents shadow analytics truth.                                                      |
| ADR-EC12-003 | External obligation registry authority                              | Adopted    | EC-12 stores versioned refs/bindings, not legal master.                               |
| ADR-EC12-004 | Framework/Control published immutability                            | Adopted    | Version instead of destructive update.                                                |
| ADR-EC12-005 | Evidence receipt append-only                                        | Adopted    | Artifact in CT-05; local hash/lineage.                                                |
| ADR-EC12-006 | Quality gate via decision receipt                                   | Adopted    | Owner module consumes; no direct state mutation.                                      |
| ADR-EC12-007 | Health score weighted/versioned, not simple average                 | Adopted    | Coverage/missing policy required.                                                     |
| ADR-EC12-008 | Indicator formula safe DSL                                          | Adopted    | No raw SQL/scripts.                                                                   |
| ADR-EC12-009 | Waiver requires expiry/compensating controls                        | Adopted    | No silent permanent exception.                                                        |
| ADR-EC12-010 | CAPA closure requires effectiveness                                 | Adopted    | Task completion insufficient.                                                         |
| ADR-EC12-011 | AI via CT-12 only                                                   | Adopted    | No provider SDK local.                                                                |
| ADR-EC12-012 | PostgreSQL RLS defense-in-depth                                     | Adopted    | ENABLE+FORCE; runtime no BYPASSRLS.                                                   |
| ADR-EC12-013 | Aggregate revision on child mutation                                | Adopted    | ETag represents whole aggregate.                                                      |
| ADR-EC12-014 | Idempotency/outbox leases                                           | Adopted    | Multi-instance safe recovery.                                                         |
| ADR-EC12-015 | OpenAPI generated client                                            | Adopted    | No manual DTO drift.                                                                  |
| ADR-EC12-016 | Zero-downtime expand/contract                                       | Adopted    | N/N-1 compatibility.                                                                  |
| ADR-EC12-017 | Evidence pack artifact format/signature                             | Open       | Define institutional signature/long-term validation policy.                           |
| ADR-EC12-018 | Health score publication to executive external portal               | Open       | Privacy/profile governance per tenant.                                                |
| ADR-EC12-019 | Accreditation-specific mappings                                     | Open       | Add adapter/profile; do not hard-code one accreditor.                                 |
| ADR-EC12-020 | Cross-tenant benchmarking/anonymized consortium analytics           | Open       | Requires separate governance/consent/anonymization architecture; disabled by default. |

# 35. Engineering Pack

| **Ruta Git mínima** | **Contenido**                                                                        |
|---------------------|--------------------------------------------------------------------------------------|
| /docs/ec12          | EC-12.docx + published PDF internal if policy requires + hash manifest               |
| /architecture/ec12  | context.puml, domain.puml, physical-erd.puml, state-machines.puml, data-lineage.puml |
| /adr/ec12           | ADR-EC12-001...                                                                      |
| /db/migration       | V\*\_ec12_expand.sql, backfill jobs, switch, contract migrations                     |
| /openapi            | ec12-quality-v1.yaml                                                                 |
| /asyncapi           | ec12-events-v1.yaml                                                                  |
| /backend            | module source, architecture tests, domain/application/adapters                       |
| /frontend           | quality workspaces, generated client, component/e2e/a11y tests                       |
| /mobile             | executive/reviewer/evidence capture selective features                               |
| /tests/domain       | BR mapping, state machines, calculators                                              |
| /tests/db           | Testcontainers RLS/constraints/triggers/concurrency                                  |
| /tests/contracts    | OpenAPI/AsyncAPI/provider/consumer contracts                                         |
| /tests/security     | IDOR, tenant, SoD, export, formula injection, abuse cases                            |
| /tests/resilience   | timeouts, UNKNOWN_EFFECT, duplicate events, lease recovery                           |
| /tests/performance  | k6/Gatling/JMeter scripts + baselines/query plans                                    |
| /ai/evals           | leakage/grounding/hallucination/bias/prompt-injection suites                         |
| /observability      | dashboards, alerts, SLI/SLO definitions, redaction rules                             |
| /runbooks/ec12      | RB-EC12-001...                                                                       |
| /migration/ec12     | legacy mappings, dry-runs, conflict reports, reconciliation                          |
| /evidence/ec12      | G1-G10, UAT, release certification, SBOM/security reports                            |

# 36. Guía secuencial Backend

**Paso 1 —** Crear Spring Modulith module educationcontinuing.qualitygovernance y declarar boundaries/imports permitidos.

**Paso 2 —** Crear package structure hexagonal y architecture tests para impedir dependencias ilegales.

**Paso 3 —** Implementar QualityFramework aggregate con versioning y publication policy.

**Paso 4 —** Implementar QualityControl aggregate con ControlVersion y EvidenceRequirement.

**Paso 5 —** Implementar ComplianceBinding como aggregate/ref versionado sin copiar legal master.

**Paso 6 —** Implementar QualityReviewCycle con ReviewScope, ControlAssessment y EvidenceReceipt.

**Paso 7 —** Implementar Nonconformity + CAPAPlan + CorrectiveAction con effectiveness verification.

**Paso 8 —** Implementar ImprovementInitiative + ImprovementExperiment y outcome decision.

**Paso 9 —** Implementar IndicatorDefinition/Threshold y safe Formula DSL parser/validator.

**Paso 10 —** Implementar IndicatorSnapshot, PortfolioHealthSnapshot y QualityScorecardSnapshot calculators.

**Paso 11 —** Implementar ComplianceAttestation, ExceptionWaiver, QualityAlert y QualityGateAssessment.

**Paso 12 —** Definir Value Objects para QualityScope, EvidenceContract, AssessmentResult, FormulaContract, ThresholdBand, DecisionSignature.

**Paso 13 —** Definir state machines como código de dominio explícito; prohibir setters genéricos de state.

**Paso 14 —** Definir Domain Policies/Services y calculator versions reproducibles.

**Paso 15 —** Definir ports cross-context para CT-01…CT-18, EC-01…EC-11 y obligation registry.

**Paso 16 —** Crear Flyway expand schema, composite PK/FK internas, unique/check/partial indexes y triggers.

**Paso 17 —** Implementar RLS ENABLE+FORCE y roles DB separados runtime/migrator/worker.

**Paso 18 —** Implementar TenantDbContext con SET LOCAL dentro de toda transacción/query/worker.

**Paso 19 —** Implementar repositories tenant-aware; evitar generic repository que omita tenant/scope.

**Paso 20 —** Implementar command handlers con authorization, purpose, SoD, step-up, If-Match e idempotency.

**Paso 21 —** Implementar query handlers/projections con freshness, asOf, suppression/field policy y pagination.

**Paso 22 —** Implementar ProblemDetail estable y error catalog.

**Paso 23 —** Implementar ETag basado en aggregate revision; bump root en mutación de hijos.

**Paso 24 —** Implementar idempotency durable con request_hash, owner, lease_until y recovery.

**Paso 25 —** Implementar transactional outbox, multi-instance claim SKIP LOCKED y inbox dedup.

**Paso 26 —** Implementar OperationStatus para async/UNKNOWN_EFFECT/reconciliation.

**Paso 27 —** Implementar adapters CT-05/06/07/09/10/11/12/13/16 y external obligation registry.

**Paso 28 —** Implementar QualityGate contract para consumidores EC sin mutación directa de sus states.

**Paso 29 —** Implementar OpenAPI y AsyncAPI como source contracts ejecutables.

**Paso 30 —** Generar provider/consumer contract tests y schema compatibility checks.

**Paso 31 —** Implementar audit/evidence hooks y correlation/causation propagation.

**Paso 32 —** Implementar OTel logs/metrics/traces con redaction/cardinality controls.

**Paso 33 —** Crear Testcontainers tests para RLS, triggers, locking, jsonb, partial indexes y state guards.

**Paso 34 —** Crear calculator golden vectors para health score/thresholds/missing-data/comparability.

**Paso 35 —** Crear concurrency/idempotency/duplicate-event/UNKNOWN_EFFECT suites.

**Paso 36 —** Crear threat model tests: IDOR, cross-tenant, SoD, formula injection, export abuse, replay.

**Paso 37 —** Crear performance tests con 1k assessments, 500 indicators y 10k evidence receipts.

**Paso 38 —** Implementar migration CT-16 promotion services y reconciliation reports.

**Paso 39 —** Implementar expand/backfill/switch/contract y rehearsal N/N-1.

**Paso 40 —** Cerrar G1-G10, UAT y release certification con evidence refs.

# 37. Guía secuencial Frontend

**Paso 1 —** Definir route tree /ec/quality y permission guards por workspace.

**Paso 2 —** Generar OpenAPI client/DTOs; prohibir interfaces duplicadas manualmente salvo view models adaptadores.

**Paso 3 —** Definir query keys con resource id/version/asOf/freshness; tenant no forma parte de input UI libre.

**Paso 4 —** Crear Quality Governance Cockpit shell con context selector y state model explícito.

**Paso 5 —** Construir Framework & Control Studio con version timeline/diff/validation issues.

**Paso 6 —** Construir dimension/weight editor con suma/coverage visualization y validación server authoritative.

**Paso 7 —** Construir control/evidence requirement editor sin raw SQL/scripts.

**Paso 8 —** Construir Compliance Matrix con obligation versions, drift, attestations y waivers.

**Paso 9 —** Construir Quality Review Workspace con scopes, control checklist, evidence completeness y freeze banner.

**Paso 10 —** Construir Evidence & Assurance Desk con secure preview refs, hashes y classification.

**Paso 11 —** Construir assessment forms con PASS/PARTIAL/FAIL/NA y rationale/assurance requirements.

**Paso 12 —** Construir Nonconformity & CAPA Center con lifecycle, aging, owners, actions y effectiveness panel.

**Paso 13 —** Construir Continuous Improvement Portfolio con baseline/target/horizon/outcome y ADOPT/REJECT.

**Paso 14 —** Construir Indicator & Threshold Studio con DSL editor guiado/validated, unit/grain/window fields.

**Paso 15 —** Construir Portfolio Health Observatory con dimension score, coverage, freshness y comparability.

**Paso 16 —** Construir Quality Scorecard Center con build/review/approve/publish/export flow.

**Paso 17 —** Construir Waiver & Quality Debt Desk con expiry/risk/compensating controls y debt aging.

**Paso 18 —** Construir Domain Quality Gate Console con request/result/receipt/reconciliation status.

**Paso 19 —** Construir Quality Alerts Center con dedup/SLA/linked action.

**Paso 20 —** Construir Audit & Evidence Pack Desk read-only con hashes/signatures/lineage.

**Paso 21 —** Implementar If-Match/ETag en mutations y Conflict Drawer con current vs attempted state.

**Paso 22 —** Generar Idempotency-Key por intención de command y mantenerlo durante retry UI.

**Paso 23 —** Implementar OperationStatus polling/backoff/SSE si contrato lo permite.

**Paso 24 —** Implementar NO_DATA/ZERO/VALUE/NOT_APPLICABLE/NOT_ASSESSED/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT/SUPPRESSED.

**Paso 25 —** Implementar field-level redaction y purpose/reason/step-up UX en exports/approvals.

**Paso 26 —** Implementar accessibility: labels, keyboard, focus management, live regions, table alternatives para charts.

**Paso 27 —** Implementar responsive layouts; no ocultar estados críticos por breakpoint.

**Paso 28 —** Evitar PII/evidence text en URL, localStorage, analytics frontend y console logs.

**Paso 29 —** Crear component/contract/e2e/a11y tests y visual regression de workspaces críticos.

**Paso 30 —** Cerrar G5/UAT con evidence pack de UI y generated-client hash.

# 38. Matriz de permisos

| **Acción**                  | **Architect** | **Manager** | **Reviewer** | **Indep.Rev** | **Compliance** | **Approver** | **Analyst** | **Operator** | **Auditor** | **Executive** |
|-----------------------------|---------------|-------------|--------------|---------------|----------------|--------------|-------------|--------------|-------------|---------------|
| Edit Framework DRAFT        | ALLOW\*       | —           | —            | —             | —              | —            | —           | —            | —           | —             |
| Publish Framework           | —             | —           | —            | —             | —              | ALLOW\*      | —           | —            | —           | —             |
| Edit Control DRAFT          | ALLOW\*       | —           | —            | —             | —              | —            | —           | —            | —           | —             |
| Publish Control             | —             | —           | —            | —             | —              | ALLOW\*      | —           | —            | —           | —             |
| Plan Review                 | —             | ALLOW\*     | —            | —             | —              | —            | —           | —            | —           | —             |
| Submit Evidence             | —             | ALLOW\*     | ALLOW\*      | —             | —              | —            | —           | —            | —           | —             |
| Assess Control              | —             | —           | ALLOW\*      | ALLOW\*       | —              | —            | —           | —            | —           | —             |
| Lock Independent Assessment | —             | —           | —            | ALLOW\*       | —              | —            | —           | —            | —           | —             |
| View Restricted Evidence    | —             | —           | ALLOW\*      | ALLOW\*       | ALLOW\*        | —            | —           | —            | ALLOW\*     | —             |
| Open Nonconformity          | —             | ALLOW\*     | ALLOW\*      | —             | —              | —            | —           | —            | —           | —             |
| Approve CAPA                | —             | ALLOW\*     | —            | —             | —              | ALLOW\*      | —           | —            | —           | —             |
| Verify Effectiveness        | —             | —           | —            | ALLOW\*       | —              | ALLOW\*      | —           | —            | —           | —             |
| Adopt Improvement           | —             | —           | —            | —             | —              | ALLOW\*      | —           | —            | —           | —             |
| Edit Indicator              | —             | —           | —            | —             | —              | —            | ALLOW\*     | —            | —           | —             |
| Build Snapshot              | —             | —           | —            | —             | —              | —            | ALLOW\*     | —            | —           | —             |
| Approve Scorecard           | —             | —           | —            | —             | —              | ALLOW\*      | —           | —            | —           | —             |
| Approve Attestation         | —             | —           | —            | —             | ALLOW\*        | ALLOW\*      | —           | —            | —           | —             |
| Approve Waiver              | —             | —           | —            | —             | —              | ALLOW\*      | —           | —            | —           | —             |
| Revoke Waiver               | —             | —           | —            | —             | ALLOW\*        | ALLOW\*      | —           | —            | —           | —             |
| Issue Gate Decision         | —             | —           | —            | —             | —              | ALLOW\*      | —           | —            | —           | —             |
| Resolve Alert               | —             | ALLOW\*     | —            | —             | —              | —            | —           | ALLOW\*      | —           | —             |
| Export Evidence Pack        | —             | —           | —            | —             | ALLOW\*        | —            | —           | —            | ALLOW\*     | —             |
| View Audit                  | —             | —           | —            | —             | —              | —            | —           | —            | ALLOW\*     | —             |
| View Executive Scorecard    | —             | ALLOW\*     | —            | —             | —              | ALLOW\*      | —           | —            | ALLOW\*     | ALLOW\*       |

\* ALLOW siempre sujeto a tenant/institution scope, ABAC, purpose, classification, SoD, step-up y lifecycle. “Architect/Manager” no implica global admin. La autorización final es server-side; la UI solo refleja hints.

# 39. Contratos DTO Frontend

| **DTO**                   | **Campos mínimos**                                                                                                                                    |
|---------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| FrameworkVersionDetailDto | id,frameworkId,versionNo,state,title,effectiveWindow,scoringMethod,missingDataPolicy,minimumCoverage,dimensions\[\],validation,contentHash,etag,links |
| ControlVersionDetailDto   | id,controlId,versionNo,state,objective,testMethod,severity,frequency,dimensionCode,waivable,evidenceRequirements\[\],contentHash,etag                 |
| QualityReviewSummaryDto   | id,code,state,frameworkVersionId,period,assuranceLevel,scopeCount,assessmentCounts,evidenceCompleteness,criticalFindings,freshness,etag               |
| ControlAssessmentDto      | id,reviewScope,controlVersion,result,assuranceLevel,rationale,evidenceSummary,evidenceWatermark,assessedBy,reviewedBy,lockedAt,etag                   |
| EvidenceReceiptDto        | id,requirementCode,artifactRef?,sourceEventRef?,datasetRef?,hash,classification,freshnessState,verificationState,collectedAt                          |
| NonconformityDto          | id,code,severity,state,title,source,owner,dueAt,capaSummary?,ageDays,acceptedRisk?,etag                                                               |
| CapaDto                   | id,state,rootCauseSummary,targetDate,actions\[\],effectivenessCriterion,effectivenessResult,verifiedAt?,etag                                          |
| ImprovementDto            | id,code,title,state,priorityScore,hypothesis,sourceSignals,experiments\[\],targetHorizon,etag                                                         |
| IndicatorDefinitionDto    | id,code,versionNo,state,name,dimension,grain,unit,direction,window,datasetContract,formulaDslVersion,formula,missingPolicy,comparabilityGroup,etag    |
| IndicatorSnapshotDto      | id,indicatorId,scope,period,asOf,value,unit,qualityState,qualityBand,freshness,inputWatermark,calculatorVersion,hash                                  |
| PortfolioHealthDto        | id,frameworkVersionId,scope,period,coverage,healthScore?,healthBand?,dimensionScores,missingPolicy,freshness,status,hash                              |
| QualityScorecardDto       | id,frameworkVersionId,scope,period,status,summary,artifactRef?,inputWatermark,hash,approvedAt?,publishedAt?,etag                                      |
| ComplianceBindingDto      | id,code,obligationRef,obligationVersionRef,authorityRef,controlVersionId,scope,effectiveWindow,state,driftState,nonWaivable,etag                      |
| ComplianceAttestationDto  | id,bindingId,scope,result,state,asOf,expiresAt,evidenceSetHash,reviewer,approver?,driftState,etag                                                     |
| ExceptionWaiverDto        | id,code,controlVersionId?,bindingId?,scope,risk,residualRisk,compensatingControls,state,startsAt,expiresAt,etag                                       |
| QualityGateStatusDto      | requestKey,gateCode,scope,state,result?,mandatoryFailCount,conditionalCount,evidenceWatermark,decisionHash?,decidedAt?,operationStatus                |
| QualityAlertDto           | id,code,type,scope,severity,state,detectedAt,owner?,dueAt?,resolutionCode?,etag                                                                       |
| OperationStatusDto        | operationId,status,resourceRef?,reasonCode?,retryAfter?,correlationId,updatedAt                                                                       |
| ProblemDetailDto          | type,title,status,detail,code,correlationId,fieldErrors?,conflict?,retryAfter?                                                                        |

## 39.1 Reglas DTO

- DTOs se generan desde OpenAPI; no duplicar contratos manualmente.

- ETag via header y opcionalmente field view model; If-Match obligatorio para command mutables.

- No exponer tenant_id como input de negocio.

- Enums/codes se documentan pero se validan contra catálogos/policies versionadas cuando aplique.

- Campos sensibles pueden omitirse/redactarse según policy; ausencia por policy se distingue con fieldAccess metadata cuando UX lo requiera.

- Timestamps ISO-8601 offset-aware; instantes persistidos en UTC.

- Money/percentages/decimals nunca float binario si la semántica exige precisión.

- QualityState/Freshness/Comparability son first-class fields, no strings de presentación derivadas solo en UI.

# 40. Checklist de release y certificación

- [ ] Word/Git/OpenAPI/AsyncAPI/Flyway/ADR hashes/versiones alineados.

- [ ] Estructura 0–41 completa y sin placeholders/RC.

- [ ] Source of Truth y anti-scope de EC-12 aprobados.

- [ ] No FK físicas cross-context.

- [ ] RLS ENABLE+FORCE en toda tabla tenant-owned; runtime sin BYPASSRLS/ownership.

- [ ] Composite PK/FK internas tenant-aware verificadas.

- [ ] FrameworkVersion/ControlVersion published immutability tests green.

- [ ] EvidenceReceipt append-only test green.

- [ ] Waiver expiry/non-waivable/SoD guards green.

- [ ] Assessment close/evidence sufficiency/effectiveness guards green.

- [ ] Indicator formula DSL rejects SQL/script injection.

- [ ] Health score golden vectors y snapshot reproducibility green.

- [ ] ETag/If-Match no last-write-wins green.

- [ ] Idempotency durable lease/recovery green.

- [ ] Outbox multi-instance/inbox dedup green.

- [ ] UNKNOWN_EFFECT reconciliation green para CT-05/11/13 y gate delivery.

- [ ] OpenAPI generated client regenerado sin drift manual.

- [ ] AsyncAPI compatibility/provider-consumer tests green.

- [ ] Threat Model actualizado; IDOR/cross-tenant/SoD/export/formula abuse tests green.

- [ ] SAST/SCA/secret/container/IaC scans green.

- [ ] SBOM generado y archivado.

- [ ] AI eval suite green para capabilities habilitadas.

- [ ] Performance budgets y DB query plans aceptados.

- [ ] Observability dashboards/alerts/SLI/SLO activos.

- [ ] Migration CT-16 dry-run/reconcile/certify completado si aplica.

- [ ] Backup/restore y retention/legal hold procedures verificados.

- [ ] Runbooks ejercitados al menos en tabletop/automation correspondiente.

- [ ] Golden Scenarios relevantes ejecutados con evidencia.

- [ ] UAT institucional firmado.

- [ ] G1-G10 PASS con evidence refs.

- [ ] Expand/contract N/N-1 rehearsal completo.

- [ ] No P0/P1 abiertos sin accepted risk aprobado + expiry.

- [ ] Release certificate final firmado por roles definidos.

# 41. Contrato FullStack no negociable de implementación

**EC12-FS-01 —** Source of Truth respetado: EC-12 gobierna quality assurance EC y no reescribe hechos EC-01…EC-11/CT/cores.

**EC12-FS-02 —** No FK físicas cross-context; refs externas se validan por ports/contracts/snapshots/receipts.

**EC12-FS-03 —** tenant_id nunca proviene de body libre ni de filtros de frontend.

**EC12-FS-04 —** RLS ENABLE + FORCE obligatorio; runtime role sin ownership/BYPASSRLS.

**EC12-FS-05 —** Aggregate Revision Contract en toda mutación de hijos; ETag representa aggregate completo.

**EC12-FS-06 —** If-Match obligatorio en commands mutables; mismatch = 412 PRECONDITION_FAILED.

**EC12-FS-07 —** No last-write-wins.

**EC12-FS-08 —** QualityFrameworkVersion PUBLISHED immutable; cambio material = nueva versión.

**EC12-FS-09 —** ControlVersion PUBLISHED immutable y pinneable históricamente.

**EC12-FS-10 —** EvidenceReceipt append-only con hash/classification/lineage.

**EC12-FS-11 —** ReviewCycle congela framework, scope y evidence watermark antes de decisiones terminales.

**EC12-FS-12 —** Assessment PASS requiere evidence sufficiency; NOT_APPLICABLE requiere rule+rationale.

**EC12-FS-13 —** Compliance Binding referencia obligation version externa; EC-12 no se vuelve legal master.

**EC12-FS-14 —** Attestation es as-of/expirable y regulatory drift la vuelve STALE cuando corresponda.

**EC12-FS-15 —** Waiver requiere scope, risk, compensating controls, approver y expiry; no silent extension.

**EC12-FS-16 —** Non-waivable control no admite waiver.

**EC12-FS-17 —** Nonconformity CLOSED exige effectiveness verification; tareas terminadas no bastan.

**EC12-FS-18 —** CAPA INEFFECTIVE no se presenta como éxito; obliga replan/escalation según policy.

**EC12-FS-19 —** Improvement Experiment congela baseline/target/indicator/horizon al iniciar.

**EC12-FS-20 —** ADOPT de mejora requiere outcome evidence, no simple implementación.

**EC12-FS-21 —** IndicatorDefinition declara grain/unit/window/source/formula/missing policy/calculator/comparability.

**EC12-FS-22 —** Formula contract no acepta raw SQL/scripts desde UI/API.

**EC12-FS-23 —** NO_DATA ≠ ZERO ≠ VALUE ≠ NOT_APPLICABLE ≠ NOT_ASSESSED ≠ STALE ≠ PARTIAL ≠ UNAVAILABLE ≠ UNKNOWN_EFFECT ≠ SUPPRESSED.

**EC12-FS-24 —** IndicatorSnapshot pinnea dataset version/watermark/calculator y tiene content hash reproducible.

**EC12-FS-25 —** PortfolioHealth no es promedio simple; pesos/coverage/missing policy se pinnean al framework.

**EC12-FS-26 —** QualityScorecard APPROVED/PUBLISHED es immutable; correction crea superseding snapshot.

**EC12-FS-27 —** Quality Gate emite decision receipt; nunca muta directamente estados de otro bounded context.

**EC12-FS-28 —** Idempotency durable con request_hash, owner, lease_until, updated_at y recovery.

**EC12-FS-29 —** Outbox leased multi-instancia + SKIP LOCKED; Inbox dedup; no exactly-once claim.

**EC12-FS-30 —** UNKNOWN_EFFECT + reconciliation; no blind retry en operaciones remotas con posible efecto.

**EC12-FS-31 —** OperationStatus estable para 202/async y reconciliación.

**EC12-FS-32 —** OpenAPI/AsyncAPI son contratos ejecutables; client/DTO generado y compatibility gates.

**EC12-FS-33 —** RBAC + ABAC + institutional/tenant scope + purpose limitation + field privacy + SoD + step-up.

**EC12-FS-34 —** Threat Model y Secure SDLC obligatorios.

**EC12-FS-35 —** No PII/raw evidence en logs/metrics/traces; cardinalidad controlada.

**EC12-FS-36 —** AI solo vía CT-12; AI recommendation ≠ decision; provenance/evals/reviewer obligatorios.

**EC12-FS-37 —** Migración usa CT-16; no INSERT directo a tablas finales como estrategia normal.

**EC12-FS-38 —** Zero-downtime expand → deploy compatible → backfill → switch → contract con N/N-1.

**EC12-FS-39 —** Observabilidad incluye SLI/SLO técnicos, reconciliation backlog, quality debt, CAPA/attestation drift y alert health.

**EC12-FS-40 —** Golden Scenarios, calculator vectors, security abuse tests y UAT forman parte del release evidence.

**EC12-FS-41 —** Gates G1-G10 no se aprueban sin evidencia verificable.

**EC12-FS-42 —** Evidence Pack reconstruye framework/control/assessment/evidence/compliance/CAPA/metrics/snapshots/gates/exports.

**EC12-FS-43 —** Runbooks y backup/restore/retention se verifican antes de producción.

**EC12-FS-44 —** Quality debt aceptada permanece visible con owner, risk y expiry/due date; no se esconde de scorecards.

**EC12-FS-45 —** EC-12 no se considera listo si un auditor no puede reproducir una decisión desde inputs/versiones/watermark hasta hash/receipt.

**EC12-FS-46 —** El cierre de la vertical EC exige que las fronteras EC-01…EC-12 permanezcan independientes, contract-first y tenant-safe.

| **CIERRE DE LA VERTICAL EDUCACIÓN CONTINUA —** EC-12 completa la secuencia EC-01…EC-12 como capa de calidad y gobierno: observa sin apropiarse de la verdad ajena, evalúa contra estándares versionados, conserva evidencia, formaliza desviaciones y compliance, impulsa mejoras verificables y produce snapshots reproducibles. La plataforma PeopleU IA puede evolucionar funcionalmente, pero estas fronteras, invariantes y contratos no deben simplificarse sin ADR y aprobación arquitectónica. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 41.1 Acta técnica de cierre EC-01…EC-12

El cierre de EC-12 no fusiona los bounded contexts: certifica que la vertical completa puede ser gobernada mediante contratos, evidencia y decisiones reproducibles. Cada módulo conserva su Source of Truth y expone señales de calidad consumibles por EC-12 sin ceder autoridad sobre sus hechos. La siguiente matriz funciona como checklist de arquitectura para la certificación integral de Educación Continua.

| **Módulo** | **Responsabilidad**   | **Señales/contratos observados**                     | **Prueba de cierre esperada**                           |
|------------|-----------------------|------------------------------------------------------|---------------------------------------------------------|
| EC-01      | Diseño académico      | Versiones publicadas, outcomes, controles de diseño  | Version pin + publication receipt + quality gate        |
| EC-02      | Oferta / ejecución    | Ediciones, cohortes, calendario y readiness          | Readiness snapshot + gate antes de launch               |
| EC-03      | Comercial             | Pricing/promoción/condiciones de oferta              | Compliance comercial + drift/exception evidence         |
| EC-04      | Vinculación           | Registro, inscripción, cupos y waitlist              | Enrollment quality signals sin duplicar persona         |
| EC-05      | Docencia              | Docentes, planificación, contenidos y LMS readiness  | Delivery readiness + evidence sufficiency               |
| EC-06      | Participación         | Asistencia, engagement y evidencia de sesión         | Completeness/freshness metrics + anomaly signals        |
| EC-07      | Evaluación / cierre   | Resultados, aprobación, completion                   | Assessment integrity + closure gate                     |
| EC-08      | Certificación         | Credenciales, badges y verificabilidad               | Issuance/verification quality + revocation drift        |
| EC-09      | B2B / Corporate       | Engagements, lotes, SLA y reporting                  | SLA/reporting quality sin apropiarse de finanzas        |
| EC-10      | Trayectoria           | Progresión, stackability y reconocimiento            | Path/progression quality + lineage/comparability        |
| EC-11      | Experiencia / impacto | Encuestas, NPS, feedback e impacto                   | Experience/impact signals con privacy/suppression       |
| EC-12      | Calidad / gobierno    | Frameworks, controls, reviews, compliance, CAPA, KPI | Assurance, evidence pack y mejora continua reproducible |

## 41.2 Criterio de certificación final de la vertical

| **Dominio de certificación** | **Condición no negociable**                                                                                      | **Evidencia mínima**                            |
|------------------------------|------------------------------------------------------------------------------------------------------------------|-------------------------------------------------|
| Arquitectura                 | EC-01…EC-12 mantienen fronteras, no existen FK cross-context y los contratos están versionados.                  | G1 + ADR + contract tests                       |
| Datos                        | RLS ENABLE+FORCE, PK/FK tenant-aware internas, invariantes críticas en PostgreSQL y facts históricos inmutables. | G2 + Testcontainers + negative tenant tests     |
| Backend/API/Eventos          | Commands con ETag/idempotencia; OpenAPI/AsyncAPI compatibles; Outbox/Inbox leased/dedup.                         | G3/G4 + generated client + compatibility report |
| Frontend/Mobile              | Estados semánticos explícitos; workspaces sin decisiones autoritativas locales; Mobile selectivo.                | G5 + UAT + a11y evidence                        |
| Seguridad/Auditoría          | RBAC/ABAC/SoD/step-up/purpose/privacy; evidence pack reconstruible y Secure SDLC green.                          | G6 + Threat Model + scans + audit replay        |
| Integraciones/Resiliencia    | Timeout/retry/circuit breaker/reconciliation; UNKNOWN_EFFECT sin blind retry.                                    | G7 + chaos/reconciliation scenarios             |
| QA/UAT                       | Golden Scenarios, vectors deterministas, concurrency, RLS, migration y UAT institucional ejecutados.             | G8 + test evidence                              |
| Operación/Migración          | CT-16, expand/contract N/N-1, SLI/SLO, runbooks, backup/restore y rollback/roll-forward ensayados.               | G9 + rehearsal evidence                         |
| Release                      | Sin P0/P1 abiertos salvo accepted risk con owner+expiry; G1-G10 PASS y hashes de artefactos alineados.           | G10 + release certificate                       |
