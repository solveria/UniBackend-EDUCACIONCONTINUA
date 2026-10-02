**PEOPLEU IA**

**EC-11**

**ENCUESTAS, NPS, FEEDBACK, EVALUACIÓN DOCENTE,  
IMPACTO Y SEGUIMIENTO POSTERIOR**

Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Control**    | **Valor**                                                                                                      |
|----------------|----------------------------------------------------------------------------------------------------------------|
| Código         | EC-11                                                                                                          |
| Versión        | V1.0                                                                                                           |
| Estado         | VIGENTE — MÓDULO FULLSTACK ENTERPRISE                                                                          |
| Baseline       | EC-00 V1.1 · EC-01 V1.1 · EC-02…EC-10                                                                          |
| Vertical       | Educación Continua / Formación Continua                                                                        |
| Arquitectura   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| Stack objetivo | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| Contexto       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| Fecha base     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS —** Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA —** EC-11 es Source of Truth de instrumentos versionados de feedback/encuestas, campañas de escucha, respuestas, métricas NPS derivadas, evaluaciones docentes con propósito académico definido, mediciones de impacto y seguimiento posterior. No sustituye EC-07, RRHH, CRM, CT-04, CT-05, CT-10, CT-11 ni motores genéricos de BI. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaración de propósito, autoridad y baseline

EC-11 cierra el ciclo de experiencia e impacto de Educación Continua sin confundir “escuchar” con “decidir”. Su responsabilidad es capturar y gobernar feedback posterior a una experiencia formativa, medir satisfacción y recomendación, ejecutar evaluaciones docentes con propósito y acceso controlado, y registrar mediciones posteriores de impacto con trazabilidad temporal. Todo resultado debe ser reproducible, versionado y explicable.

El módulo se diseña para universidades que necesitan operar desde encuestas de cierre simples hasta programas corporativos de seguimiento a 30/60/90/180 días, preservando anonimato cuando corresponde y evitando que una opinión individual sea tratada como hecho académico, laboral o disciplinario. EC-11 consume hechos de ejecución de EC-02, asistencia de EC-06, completion/resultados de EC-07, credenciales de EC-08, contexto corporativo de EC-09 y trayectoria de EC-10, pero no reescribe ninguno de ellos.

La arquitectura sigue el baseline PeopleU IA: PostgreSQL es la última línea de defensa, el tenant se resuelve por contexto autorizado, no existen FK físicas cross-context, toda mutación relevante utiliza revisión optimista/ETag, idempotencia durable y receipts cuando hay efectos remotos. El modelo de privacidad separa respuestas identificadas, seudonimizadas y anónimas; una configuración de anonimato publicada no puede “desanonimizarse” retroactivamente.

| **CRITERIO DE ÉXITO —** Un equipo Senior debe poder diseñar, publicar, ejecutar, cerrar, analizar y auditar campañas de feedback e impacto sin conocimiento tribal; PostgreSQL debe impedir cruces de tenant, reidentificación ilícita, mutaciones destructivas de respuestas cerradas, doble cómputo NPS y asociaciones incoherentes aun si Backend tiene un bug. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquía documental aplicable

| **Prioridad** | **Documento/artefacto**                | **Rol**                                                                                |
|---------------|----------------------------------------|----------------------------------------------------------------------------------------|
| 1             | AM-00 vigente                          | Constitución arquitectónica superior.                                                  |
| 2             | CT-00 vigente                          | Contrato maestro transversal.                                                          |
| 3             | CT-01…CT-18 vigentes                   | Capacidades compartidas, seguridad, evidencia, IA, analítica, migración e integración. |
| 4             | EC-00 V1.1                             | Constitución funcional/arquitectónica de Educación Continua.                           |
| 5             | EC-01 V1.1                             | Plantilla oficial FullStack y contratos de definición académica.                       |
| 6             | EC-02…EC-10                            | Hechos upstream que EC-11 consume sin duplicar.                                        |
| 7             | EC-11 V1.0                             | Especificación implementable de experiencia, feedback, impacto y seguimiento.          |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación y evidencia alineadas al Word.                                          |

## 0.2 Secuencia oficial EC

| **Orden** | **Código** | **Módulo oficial**                                                                            | **Responsabilidad primaria** |
|-----------|------------|-----------------------------------------------------------------------------------------------|------------------------------|
| 9         | EC-09      | Formación corporativa / in-company, clientes, acuerdos, lotes y reporting empresarial         | B2B / Corporate              |
| 10        | EC-10      | Trayectoria de aprendizaje, progresión, stackable credentials y reconocimiento acumulativo EC | Trayectoria                  |
| 11        | EC-11      | Encuestas, NPS, feedback, evaluación docente, impacto y seguimiento posterior                 | Experiencia / impacto        |
| 12        | EC-12      | Calidad, analítica de portafolio, indicadores, compliance y mejora continua                   | Calidad / gobierno           |

## 0.3 Decisiones arquitectónicas EC11-DA

| **ID**      | **Decisión normativa**                                                                                                                                                 |
|-------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| EC11-DA-001 | SURVEY DEFINITION ≠ SURVEY VERSION ≠ FEEDBACK CAMPAIGN. El instrumento es reusable, su versión publicada es inmutable y la campaña define ejecución/contexto.          |
| EC11-DA-002 | INVITATION ≠ RESPONSE. Una invitación controla elegibilidad/contacto; una respuesta es evidencia de feedback y puede existir en modo anónimo sin actor_ref persistido. |
| EC11-DA-003 | ANONYMOUS ≠ PSEUDONYMOUS ≠ IDENTIFIED. La identidad y la posibilidad de reidentificación se gobiernan explícitamente por PrivacyMode y nunca se infieren.              |
| EC11-DA-004 | NPS OBSERVATION ≠ SATISFACTION SCORE. NPS usa escala y clasificación promot/detractor definida; otros indicadores no se reinterpretan como NPS.                        |
| EC11-DA-005 | INSTRUCTOR EVALUATION ≠ HR PERFORMANCE DECISION. EC-11 registra feedback académico; RRHH es dueño de decisiones laborales y consume solo contratos autorizados.        |
| EC11-DA-006 | IMPACT ASSESSMENT ≠ COMPLETION RESULT. EC-07 gobierna aprobación/completion; EC-11 mide transferencia, aplicación o resultado posterior.                               |
| EC11-DA-007 | FOLLOW-UP CASE ≠ CRM LEAD/TICKET. El seguimiento posterior existe para aprendizaje/impacto; no se convierte en CRM comercial ni mesa de ayuda.                         |
| EC11-DA-008 | REPORT SNAPSHOT ≠ LIVE UNRESTRICTED QUERY. Todo reporte distribuible congela scope, policy, supresión, purpose y watermark.                                            |
| EC11-DA-009 | FREE-TEXT FEEDBACK ≠ FACT. Es una expresión del respondente; se preserva como evidencia y no reescribe hechos académicos.                                              |
| EC11-DA-010 | AI SENTIMENT/TOPIC ≠ DECISION. CT-12 puede clasificar/sintetizar; el resultado queda provenance-linked y jamás sanciona ni aprueba automáticamente.                    |
| EC11-DA-011 | CONSENT ≠ PURPOSE. Consent_ref y purpose_ref son evidencias distintas; la base institucional puede no ser consentimiento y debe documentarse.                          |
| EC11-DA-012 | SPONSOR ACCESS ≠ INDIVIDUAL RESPONSE ACCESS. EC-09 ReportingProfile y CT-10 privacy policy gobiernan qué agregados/nominales pueden exponerse.                         |
| EC11-DA-013 | SURVEY VERSION PUBLISHED = IMMUTABLE SNAPSHOT. Preguntas, escalas, orden y privacy contract no se editan después de publicar.                                          |
| EC11-DA-014 | RESPONSE SUBMITTED = APPEND-ONLY BUSINESS FACT. Correcciones crean amendment/void governed; no UPDATE silencioso.                                                      |
| EC11-DA-015 | MINIMUM COHORT SIZE IS ENFORCED BEFORE EXPORT. La supresión protege reidentificación por grupos pequeños.                                                              |
| EC11-DA-016 | TENANT CONTEXT ≠ REQUEST BODY. tenant_id proviene del contexto autorizado y RLS protege runtime.                                                                       |
| EC11-DA-017 | CROSS-CONTEXT REFERENCE ≠ FK. EC-02/04/05/06/07/08/09/10, CT e IAM se referencian mediante EXT REF validadas por ports/contracts.                                      |
| EC11-DA-018 | FOLLOW-UP SCHEDULE ≠ GENERIC SCHEDULER. EC-11 define intención y due date; CT-13 ejecuta scheduling técnico.                                                           |
| EC11-DA-019 | DASHBOARD METRIC ≠ RAW RESPONSE. CT-11 recibe eventos/datasets gobernados; no acceso directo irrestricto a tablas de respuestas.                                       |
| EC11-DA-020 | DELETE REQUEST ≠ PHYSICAL DELETE. Retención/privacidad se resuelve con policy, tombstone/crypto-shredding cuando corresponda y evidencia de disposición.               |

## 0.4 Criterio de suficiencia FullStack

EC-11 es suficiente cuando dominio, tablas, DDL, contratos REST/eventos, workspaces, mobile selectivo, permisos, privacidad, QA, migración, observabilidad y operación convergen en una implementación reproducible. No basta con listar pantallas o entidades: cada dato sensible debe tener owner, propósito, retención, política de exposición y evidencia.

## 0.5 Matriz de cierre de hallazgos/revisión

| **Hallazgo** | **Riesgo**                                         | **Cierre EC-11**                                                                       | **Evidencia**           |
|--------------|----------------------------------------------------|----------------------------------------------------------------------------------------|-------------------------|
| H-01         | Riesgo de mezclar encuestas con BI                 | Separa Survey/Campaign/Response y ReportSnapshot; CT-11 solo consume datasets/eventos. | Diseño + tests          |
| H-02         | Reidentificación accidental                        | PrivacyMode, minimum cohort size, suppression policy y export controls.                | DB/API/UAT              |
| H-03         | Cambiar cuestionario después de recibir respuestas | SurveyVersion publicada y ResponseSubmitted inmutables.                                | Trigger + state machine |
| H-04         | Usar evaluación docente como sanción automática    | Frontera RRHH + human review + purpose limitation.                                     | Security/UAT            |
| H-05         | NPS calculado de forma inconsistente               | NpsObservation + calculator version + snapshot hash.                                   | Contract/perf test      |
| H-06         | Impacto confundido con completion                  | ImpactAssessment separado de EC-07 result/completion.                                  | Domain contract         |
| H-07         | Timeout de canal genera duplicados                 | Idempotency + delivery receipt + UNKNOWN_EFFECT + reconciliation.                      | Resilience suite        |
| H-08         | Exportación PII excesiva                           | Field-level policy + sponsor profile + reason + evidence.                              | Security gate           |

# 1. Índice operativo

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01…CT-18, cores y módulos EC

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal BR-EC11

- 10\. Casos de uso UC-EC11

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

EC-11 convierte la voz del participante y las mediciones posteriores en evidencia gobernada. El problema no es “crear encuestas”; es asegurar que cada instrumento tenga versión, propósito, población, ventana, privacidad, retención y reglas de cálculo; que las respuestas no puedan ser reinterpretadas fuera de contexto; y que los indicadores agregados puedan reproducirse aun cuando el instrumento o el programa evolucionen.

El módulo soporta encuestas de satisfacción, NPS, evaluación de docentes/facilitadores, feedback de sesiones o programa, autoevaluaciones de transferencia, evaluación por sponsor cuando existe formación corporativa, mediciones de impacto a múltiples horizontes y acciones de seguimiento. Su salida alimenta EC-12 y CT-11 para mejora continua, sin permitir que analytics se convierta en Source of Truth de la evidencia primaria.

## 2.1 Incluido

- SurveyDefinition y SurveyVersion inmutables tras publicación.

- Question/Option/Scale con tipos y validación versionados.

- FeedbackCampaign vinculada a ProgramEdition/engagement/target population por EXT REF.

- DistributionBatch e Invitation con canales, ventanas, token seguro y receipts.

- Respuestas identificadas, seudonimizadas o anónimas según PrivacyMode.

- Answer ledger con validación por pregunta y prevención de cross-version.

- NPS observation y cálculo reproducible con calculator_version.

- InstructorEvaluation como vista/aggregate derivado gobernado por purpose.

- ImpactAssessment y Measurement a 30/60/90/180 días u horizontes parametrizados.

- FollowUpCase académico/impacto con owner, due date, outcome y evidence refs.

- ReportSnapshot con minimum cohort size, suppression y export policy.

- Integración con EC-09 Sponsor Portal bajo ReportingProfile.

- IA vía CT-12 para sentiment/topics/resumen, con provenance y revisión humana.

- RLS, ETag, idempotencia, outbox/inbox, audit, observabilidad, migración y Gates.

## 2.2 Fuera de alcance

- Crear/modificar personas o datos maestros personales — CT-04/IAM.

- Cambiar completion, notas o resultados académicos — EC-07.

- Emitir/revocar credenciales — EC-08.

- Gestionar clientes/contratos corporativos — EC-09.

- Tomar decisiones laborales sobre docentes — RRHH.

- Guardar blobs/documentos — CT-05.

- Ser CRM, ticketing o contact center genérico.

- Ser plataforma BI universal — CT-11.

- Ejecutar scheduler genérico — CT-13.

- Enviar notificaciones sin CT-07/contrato de canales.

- Llamar proveedores de IA directamente — CT-12.

| **ANTI-SCOPE —** EC-11 no debe convertirse en un SurveyMonkey interno ni en un CRM. Su valor es el gobierno universitario del feedback e impacto: contexto académico, privacidad, versionado, lineage, integraciones, evidencia y mejora continua. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Término**          | **Definición normativa**                                                                                         |
|----------------------|------------------------------------------------------------------------------------------------------------------|
| SurveyDefinition     | Identidad estable de un instrumento de escucha a través del tiempo; no contiene preguntas mutables publicadas.   |
| SurveyVersion        | Snapshot inmutable del instrumento: preguntas, opciones, escalas, privacy mode, purpose y scoring rules.         |
| SurveyQuestion       | Ítem versionado con tipo, requiredness, order, validation y semantic code.                                       |
| QuestionOption       | Opción posible para choice/rating; su value code es estable dentro de la versión.                                |
| FeedbackCampaign     | Ejecución contextual de una SurveyVersion para una población, propósito, ventana y source context concretos.     |
| DistributionBatch    | Lote de entrega/invitación a una población resuelta; no es una respuesta.                                        |
| FeedbackInvitation   | Derecho/solicitud de responder con canal, token hash, expiración y status.                                       |
| FeedbackResponse     | Unidad de respuesta del instrumento bajo un privacy mode; puede no almacenar subject_ref.                        |
| ResponseAnswer       | Respuesta a una pregunta de la SurveyVersion pinneada; append-only tras submit.                                  |
| PrivacyMode          | Contrato IDENTIFIED/PSEUDONYMOUS/ANONYMOUS que fija qué identidad puede persistirse y quién puede reidentificar. |
| NpsObservation       | Clasificación de un score NPS válido con calculator/version context; no es promedio de satisfacción.             |
| InstructorEvaluation | Proyección gobernada de feedback asociado a instructor/facilitator_ref con purpose y acceso restringido.         |
| ImpactAssessment     | Plan de medición posterior de transferencia/impacto vinculado a edición/engagement/participant population.       |
| ImpactMeasurement    | Observación puntual de una métrica de impacto en un horizonte temporal y source.                                 |
| FollowUpCase         | Unidad de seguimiento académico/impacto generada por regla o revisión humana; no CRM/ticket genérico.            |
| ReportSnapshot       | Snapshot reproducible de un reporte con policy, cohort, watermark, suppression y content hash.                   |
| Suppression          | Ocultamiento/no publicación de celdas/filas por minimum cohort size o política de privacidad.                    |
| PurposeRef           | Referencia versionada al propósito autorizado de tratamiento/uso de información.                                 |
| Response Amendment   | Hecho append-only que corrige/void una respuesta sin reescribir la evidencia original.                           |
| Impact Outcome       | Resultado organizacional o individual medido después de la experiencia; no completion académico.                 |

# 4. Bounded Context y matriz Source of Truth

EC-11 posee las definiciones/versiones de instrumentos, campañas, invitaciones, respuestas, answers, observaciones NPS, planes/mediciones de impacto, follow-up cases y snapshots de reporte producidos por este bounded context. Todo elemento externo entra como referencia o snapshot contractual justificado.

| **Información**                     | **Source of Truth** | **EC-11 almacena** | **EC-11 referencia**                  | **Regla**                               |
|-------------------------------------|---------------------|--------------------|---------------------------------------|-----------------------------------------|
| Person/identity                     | CT-04/IAM           | No                 | subject/person refs cuando IDENTIFIED | No Person local.                        |
| ProgramVersion                      | EC-01               | No                 | program_version_ref                   | No diseño académico local.              |
| ProgramEdition                      | EC-02               | No                 | edition_ref                           | Contexto de ejecución.                  |
| Enrollment/participant registration | EC-04               | No                 | registration/enrollment refs          | No duplicar roster.                     |
| Instructor assignment               | EC-05               | No                 | instructor_ref/assignment_ref         | No HR master.                           |
| Attendance                          | EC-06               | No                 | attendance summary/ref                | Input opcional.                         |
| Completion/result                   | EC-07               | No                 | completion/result refs                | Solo contexto/segmentación autorizada.  |
| Credential award                    | EC-08               | No                 | credential_award_ref                  | No emisión local.                       |
| Corporate engagement/sponsor        | EC-09               | No                 | engagement/reporting_profile refs     | Sponsor access governed.                |
| Trajectory/progress                 | EC-10               | No                 | trajectory/path refs                  | No recalcular progreso.                 |
| SurveyDefinition/Version            | EC-11               | Sí                 | —                                     | Source of Truth local.                  |
| Campaign/Invitation/Response        | EC-11               | Sí                 | —                                     | Source of Truth local.                  |
| Impact/Follow-up                    | EC-11               | Sí                 | —                                     | Source of Truth local.                  |
| Documents                           | CT-05               | No                 | evidence/document refs                | No blobs.                               |
| Privacy/Audit                       | CT-10 + EC-11 facts | Parcial            | policy refs + local evidence          | CT-10 policy; EC-11 execution evidence. |
| Analytics                           | CT-11               | No                 | event-fed datasets/report refs        | No direct authority sobre respuestas.   |
| AI                                  | CT-12               | No                 | ai_run_ref                            | No model calls locales.                 |
| Scheduling                          | CT-13               | No                 | schedule refs                         | No cron engine local.                   |

# 5. Dependencias CT-01 a CT-18, cores y módulos EC

| **Dependencia** | **Responsabilidad**    | **Contrato EC-11**                              | **Frontera/fallo**                    |
|-----------------|------------------------|-------------------------------------------------|---------------------------------------|
| CT-01           | Scope institucional    | owner_scope_ref; campus/sede scopes             | Fail-closed si scope no válido.       |
| CT-02           | Catálogos/policies     | survey types, metric codes, privacy policy refs | Cache versionada, no enums locales.   |
| CT-03           | Temporalidad           | timezone/calendars para ventanas                | UTC + zone explícita.                 |
| CT-04           | Persona                | person_ref solo cuando permitido                | No Person local.                      |
| CT-05           | Evidence/documents     | evidence refs, attachments, report artifact ref | No blobs.                             |
| CT-06           | Workflow               | approval de instrumentos/export excepciones     | Workflow no define invariantes.       |
| CT-07           | Notifications          | invitation/reminder/follow-up notifications     | Post-commit; receipts.                |
| CT-08           | i18n                   | localized labels/questions                      | Canonical + overlays.                 |
| CT-09           | Integration governance | events/contracts/webhooks                       | Outbox/inbox.                         |
| CT-10           | Security/audit/privacy | purpose/consent/privacy policy, audit           | Critical controls.                    |
| CT-11           | Analytics              | dataset/report consumption                      | Event-fed; no raw unrestricted DB.    |
| CT-12           | AI                     | sentiment/topic/summarization                   | Human review mandatory.               |
| CT-13           | Scheduling             | campaign/follow-up scheduling                   | No cron local.                        |
| CT-14           | Resources              | No authoring local                              | Solo contexto si needed.              |
| CT-15           | Eligibility            | targeting rule refs                             | No rule engine local.                 |
| CT-16           | Migration/DQ           | staging/dry-run/promotion                       | No direct INSERT final.               |
| CT-17           | Continuity             | RTO/RPO/runbooks                                | Read-only degraded mode.              |
| CT-18           | External ecosystem     | LMS external feedback refs if applicable        | No vendor lock-in.                    |
| IAM             | Authentication/MFA     | actor/assurance context                         | Step-up export/void/reidentification. |
| EC-01           | Program/Survey context | program/version refs                            | No edit upstream.                     |
| EC-02           | Edition                | edition/cohort refs                             | Campaign context.                     |
| EC-04           | Enrollment             | target population refs                          | No roster duplication.                |
| EC-05           | Instructor assignment  | facilitator/instructor refs                     | No employee truth.                    |
| EC-06           | Attendance             | attendance refs/summary                         | Read-only context.                    |
| EC-07           | Completion/results     | completion/result refs                          | No mutation.                          |
| EC-08           | Credentials            | award refs                                      | Read-only context.                    |
| EC-09           | Corporate              | engagement/sponsor/reporting profile            | Privacy contract required.            |
| EC-10           | Trajectory             | trajectory/progress refs                        | Impact correlation only.              |

# 6. Arquitectura funcional E2E y journeys

| **ARQUITECTURA E2E —** Design → Publish SurveyVersion → Create Campaign → Resolve Target Population → Distribute → Capture Response → Validate/Submit → Derive NPS/Evaluation → Close Campaign → Build ReportSnapshot → Follow-up/Impact → Feed CT-11/EC-12. Cada flecha cross-context usa contrato, receipt y policy. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **Journey** | **Nombre**         | **Flujo E2E**                                                                                                                                                        |
|-------------|--------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| J-EC11-01   | Encuesta de cierre | Designer crea SurveyDefinition/V1 → preguntas/escalas → privacy/purpose → review → publish → Campaign ligada a Edition → invitations → responses → close → snapshot. |
| J-EC11-02   | NPS                | Campaign usa pregunta NPS 0..10 → submit → NpsObservation detractor/passive/promoter → snapshot calcula score con cohort/suppression.                                |
| J-EC11-03   | Evaluación docente | Campaign por instructor assignment → respuestas → acceso restringido → agregado por minimum cohort size → instructor/reviewer ve resultado autorizado.               |
| J-EC11-04   | Impacto 90 días    | ImpactAssessment planifica horizon 90d → CT-13 dispara → participant/sponsor measurement → evidence → aggregate snapshot → EC-12 consume KPI.                        |
| J-EC11-05   | Anónimo            | Invitation emite token hash → response no persiste subject_ref → answers submit → separación técnica impide reidentificación posterior.                              |
| J-EC11-06   | Sponsor corporate  | EC-09 ReportingProfile autoriza métricas → ReportSnapshot aplica suppression/field policy → sponsor portal consume snapshot, no raw query.                           |
| J-EC11-07   | Dependencia caída  | CT-07 timeout al enviar → delivery UNKNOWN_EFFECT → receipt + reconcile → no duplicar invitación ni contar respuesta doble.                                          |
| J-EC11-08   | IA asistiva        | Free text autorizado → CT-12 classify/summarize → ai_run_ref + confidence + grounding refs → reviewer acepta/rechaza; raw feedback preservado.                       |
| J-EC11-09   | Amendment          | Respondente solicita corrección permitida → original immutable → amendment append-only → derived metrics recompute versioned.                                        |
| J-EC11-10   | Retención          | Policy vence → disposition job CT-10/CT-17 → data minimization/tombstone según modo → evidence receipt → snapshots autorizados preservan lo permitido.               |

# 7. Modelo de dominio

## 7.1 Aggregates y Aggregate Roots

| **Aggregate Root** | **Children**                                  | **Invariante central**                                    |
|--------------------|-----------------------------------------------|-----------------------------------------------------------|
| SurveyDefinition   | SurveyVersion, SurveyQuestion, QuestionOption | Identidad y versionado del instrumento.                   |
| FeedbackCampaign   | DistributionBatch, FeedbackInvitation         | Ejecución, población, ventana y distribución.             |
| FeedbackResponse   | ResponseAnswer, ResponseAmendment             | Evidencia de respuesta y correcciones append-only.        |
| ImpactAssessment   | ImpactMeasurement                             | Plan y observaciones posteriores.                         |
| FollowUpCase       | FollowUpAction                                | Seguimiento académico/impacto.                            |
| ReportSnapshot     | ReportCell/metadata logical                   | Snapshot reproducible y gobernado para consumo/reporting. |

## 7.2 Value Objects

- PrivacyContract(mode,purpose_ref,consent_ref?,reidentification_policy_ref?,retention_policy_ref)

- ResponseWindow(opens_at,closes_at,timezone)

- ScaleDefinition(min,max,semantic_labels,scoring_rule_ref)

- AudienceSelector(source_context_ref,eligibility_rule_ref,cohort_scope)

- NpsScore(value,classification,calculator_version)

- MetricValue(metric_code,value_numeric/value_text/unit_code,observed_at)

- SuppressionRule(minimum_cohort_size,small_cell_policy)

- ExportPolicy(allowed_fields,purpose,role,retention,watermark)

- Provenance(source_event_id,source_context_ref,content_hash,occurred_at)

## 7.3 Domain Policies / Services

- SurveyPublicationPolicy

- CampaignAudienceResolutionPolicy

- ResponsePrivacyPolicy

- AnswerValidationPolicy

- NpsCalculationService

- InstructorEvaluationAggregationPolicy

- ImpactMeasurementPolicy

- SuppressionPolicy

- ReportSnapshotBuilder

- RetentionDispositionPolicy

- FollowUpTriggerPolicy

- ResponseAmendmentPolicy

## 7.4 Aggregate Revision Contract

Toda mutación de hijo de Aggregate sigue: resolver tenant → abrir transacción → SET LOCAL peopleu.tenant_id → lock/revalidar root → comparar If-Match → ejecutar método de intención → persistir hijo → incrementar revision del root → audit/outbox/idempotency → commit → devolver nuevo ETag. En SurveyVersion PUBLISHED y FeedbackResponse SUBMITTED la mutabilidad se restringe por trigger/domain; mismatch devuelve 412 PRECONDITION_FAILED.

# 8. Máquinas de estado normativas

| **Entidad**        | **Estados/transiciones**                                      | **Regla**                                                        |
|--------------------|---------------------------------------------------------------|------------------------------------------------------------------|
| SurveyVersion      | DRAFT → IN_REVIEW → APPROVED → PUBLISHED → SUPERSEDED \| VOID | PUBLISHED immutable; supersede por nueva versión.                |
| FeedbackCampaign   | DRAFT → SCHEDULED → OPEN → CLOSED → ARCHIVED \| CANCELLED     | OPEN requiere SurveyVersion PUBLISHED y privacy contract válido. |
| FeedbackInvitation | PENDING → SENT → OPENED → RESPONDED \| EXPIRED \| CANCELLED   | RESPONDED una vez salvo policy multi-submit explícita.           |
| FeedbackResponse   | DRAFT → SUBMITTED → ACCEPTED \| VOID                          | SUBMITTED answers immutable; amendment separado.                 |
| ImpactAssessment   | DRAFT → ACTIVE → COMPLETED \| CANCELLED                       | ACTIVE requiere horizons/metrics/purpose.                        |
| ImpactMeasurement  | PENDING → COLLECTED → VERIFIED \| REJECTED \| VOID            | VERIFIED no mutable; nueva medición si correction.               |
| FollowUpCase       | OPEN → IN_PROGRESS → RESOLVED \| DISMISSED \| CANCELLED       | reason/outcome required.                                         |
| ReportSnapshot     | BUILDING → READY → DISTRIBUTED \| FAILED \| VOID              | READY immutable; distribution authorization checked.             |

# 9. Catálogo formal BR-EC11

| **ID**      | **Nombre**    | **Regla implementable/verificable**                                                                                                                                                                |
|-------------|---------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| BR-EC11-001 | Tenant        | Toda fila tenant-owned participa en aislamiento RLS y tenant_id nunca se acepta desde body libre. La violación debe mapearse a ProblemDetail estable.                                              |
| BR-EC11-002 | Version       | Una SurveyVersion PUBLISHED es inmutable; cambio material crea nueva versión. Debe existir test negativo y evidencia de auditoría.                                                                 |
| BR-EC11-003 | Question      | Toda pregunta pertenece exactamente a una SurveyVersion y no puede referenciar opciones de otra versión. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL. |
| BR-EC11-004 | Privacy       | PrivacyMode publicado no puede degradarse de ANONYMOUS a IDENTIFIED ni habilitar reidentificación retroactiva. La regla aplica a Web, API y procesos batch.                                        |
| BR-EC11-005 | Purpose       | Toda Campaign debe declarar purpose_ref versionado y compatible con su población/canales.                                                                                                          |
| BR-EC11-006 | Campaign      | Campaign OPEN exige SurveyVersion PUBLISHED, ventana válida, owner scope y targeting resolvible. La violación debe mapearse a ProblemDetail estable.                                               |
| BR-EC11-007 | Invitation    | Token de invitation se persiste solo como hash; nunca plaintext recuperable. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-008 | Response      | SUBMITTED response no permite UPDATE/DELETE destructivo de answers. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                      |
| BR-EC11-009 | NPS           | NPS solo acepta integer 0..10 y clasificación por calculator_version explícita. La regla aplica a Web, API y procesos batch.                                                                       |
| BR-EC11-010 | Evaluation    | InstructorEvaluation no puede convertirse en acción RRHH automática.                                                                                                                               |
| BR-EC11-011 | Impact        | ImpactMeasurement requiere metric_code, observed_at y source/provenance. La violación debe mapearse a ProblemDetail estable.                                                                       |
| BR-EC11-012 | Follow-up     | FollowUpCase requiere trigger_reason y owner; no puede usarse como CRM lead. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-013 | Suppression   | Reportes con cohort menor a minimum_cohort_size deben suprimir valores según policy. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                     |
| BR-EC11-014 | Export        | Export nominal requiere rol, purpose, reason, policy y step-up cuando corresponda. La regla aplica a Web, API y procesos batch.                                                                    |
| BR-EC11-015 | AI            | AI output conserva ai_run_ref/confidence/grounding y nunca reemplaza raw response.                                                                                                                 |
| BR-EC11-016 | Cross-context | No FK físicas a CT/EC ajenos; usar refs/contracts. La violación debe mapearse a ProblemDetail estable.                                                                                             |
| BR-EC11-017 | Idempotency   | Commands sensibles usan Idempotency-Key durable y request_hash. Debe existir test negativo y evidencia de auditoría.                                                                               |
| BR-EC11-018 | Concurrency   | Mutaciones usan If-Match; no last-write-wins. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                                            |
| BR-EC11-019 | Outbox        | Transición crítica persiste state + audit + outbox en una transacción. La regla aplica a Web, API y procesos batch.                                                                                |
| BR-EC11-020 | Unknown       | Timeout remoto con efecto entra UNKNOWN_EFFECT y se reconcilia antes de retry.                                                                                                                     |
| BR-EC11-021 | Retention     | Disposición/anonimización se ejecuta conforme retention policy y deja receipt. La violación debe mapearse a ProblemDetail estable.                                                                 |
| BR-EC11-022 | Analytics     | CT-11 consume datasets/eventos gobernados, no bypass directo a raw response tables. Debe existir test negativo y evidencia de auditoría.                                                           |
| BR-EC11-023 | Corporate     | Sponsor access se limita por EC-09 ReportingProfile y suppression. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                       |
| BR-EC11-024 | Localization  | Pregunta/label canónico y traducciones se resuelven por CT-08 sin duplicar versiones por idioma. La regla aplica a Web, API y procesos batch.                                                      |
| BR-EC11-025 | Migration     | Legacy se promueve mediante CT-16 y domain/API; no INSERT directo a tablas finales.                                                                                                                |
| BR-EC11-026 | Tenant        | Toda fila tenant-owned participa en aislamiento RLS y tenant_id nunca se acepta desde body libre. La violación debe mapearse a ProblemDetail estable.                                              |
| BR-EC11-027 | Version       | Una SurveyVersion PUBLISHED es inmutable; cambio material crea nueva versión. Debe existir test negativo y evidencia de auditoría.                                                                 |
| BR-EC11-028 | Question      | Toda pregunta pertenece exactamente a una SurveyVersion y no puede referenciar opciones de otra versión. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL. |
| BR-EC11-029 | Privacy       | PrivacyMode publicado no puede degradarse de ANONYMOUS a IDENTIFIED ni habilitar reidentificación retroactiva. La regla aplica a Web, API y procesos batch.                                        |
| BR-EC11-030 | Purpose       | Toda Campaign debe declarar purpose_ref versionado y compatible con su población/canales.                                                                                                          |
| BR-EC11-031 | Campaign      | Campaign OPEN exige SurveyVersion PUBLISHED, ventana válida, owner scope y targeting resolvible. La violación debe mapearse a ProblemDetail estable.                                               |
| BR-EC11-032 | Invitation    | Token de invitation se persiste solo como hash; nunca plaintext recuperable. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-033 | Response      | SUBMITTED response no permite UPDATE/DELETE destructivo de answers. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                      |
| BR-EC11-034 | NPS           | NPS solo acepta integer 0..10 y clasificación por calculator_version explícita. La regla aplica a Web, API y procesos batch.                                                                       |
| BR-EC11-035 | Evaluation    | InstructorEvaluation no puede convertirse en acción RRHH automática.                                                                                                                               |
| BR-EC11-036 | Impact        | ImpactMeasurement requiere metric_code, observed_at y source/provenance. La violación debe mapearse a ProblemDetail estable.                                                                       |
| BR-EC11-037 | Follow-up     | FollowUpCase requiere trigger_reason y owner; no puede usarse como CRM lead. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-038 | Suppression   | Reportes con cohort menor a minimum_cohort_size deben suprimir valores según policy. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                     |
| BR-EC11-039 | Export        | Export nominal requiere rol, purpose, reason, policy y step-up cuando corresponda. La regla aplica a Web, API y procesos batch.                                                                    |
| BR-EC11-040 | AI            | AI output conserva ai_run_ref/confidence/grounding y nunca reemplaza raw response.                                                                                                                 |
| BR-EC11-041 | Cross-context | No FK físicas a CT/EC ajenos; usar refs/contracts. La violación debe mapearse a ProblemDetail estable.                                                                                             |
| BR-EC11-042 | Idempotency   | Commands sensibles usan Idempotency-Key durable y request_hash. Debe existir test negativo y evidencia de auditoría.                                                                               |
| BR-EC11-043 | Concurrency   | Mutaciones usan If-Match; no last-write-wins. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                                            |
| BR-EC11-044 | Outbox        | Transición crítica persiste state + audit + outbox en una transacción. La regla aplica a Web, API y procesos batch.                                                                                |
| BR-EC11-045 | Unknown       | Timeout remoto con efecto entra UNKNOWN_EFFECT y se reconcilia antes de retry.                                                                                                                     |
| BR-EC11-046 | Retention     | Disposición/anonimización se ejecuta conforme retention policy y deja receipt. La violación debe mapearse a ProblemDetail estable.                                                                 |
| BR-EC11-047 | Analytics     | CT-11 consume datasets/eventos gobernados, no bypass directo a raw response tables. Debe existir test negativo y evidencia de auditoría.                                                           |
| BR-EC11-048 | Corporate     | Sponsor access se limita por EC-09 ReportingProfile y suppression. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                       |
| BR-EC11-049 | Localization  | Pregunta/label canónico y traducciones se resuelven por CT-08 sin duplicar versiones por idioma. La regla aplica a Web, API y procesos batch.                                                      |
| BR-EC11-050 | Migration     | Legacy se promueve mediante CT-16 y domain/API; no INSERT directo a tablas finales.                                                                                                                |
| BR-EC11-051 | Tenant        | Toda fila tenant-owned participa en aislamiento RLS y tenant_id nunca se acepta desde body libre. La violación debe mapearse a ProblemDetail estable.                                              |
| BR-EC11-052 | Version       | Una SurveyVersion PUBLISHED es inmutable; cambio material crea nueva versión. Debe existir test negativo y evidencia de auditoría.                                                                 |
| BR-EC11-053 | Question      | Toda pregunta pertenece exactamente a una SurveyVersion y no puede referenciar opciones de otra versión. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL. |
| BR-EC11-054 | Privacy       | PrivacyMode publicado no puede degradarse de ANONYMOUS a IDENTIFIED ni habilitar reidentificación retroactiva. La regla aplica a Web, API y procesos batch.                                        |
| BR-EC11-055 | Purpose       | Toda Campaign debe declarar purpose_ref versionado y compatible con su población/canales.                                                                                                          |
| BR-EC11-056 | Campaign      | Campaign OPEN exige SurveyVersion PUBLISHED, ventana válida, owner scope y targeting resolvible. La violación debe mapearse a ProblemDetail estable.                                               |
| BR-EC11-057 | Invitation    | Token de invitation se persiste solo como hash; nunca plaintext recuperable. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-058 | Response      | SUBMITTED response no permite UPDATE/DELETE destructivo de answers. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                      |
| BR-EC11-059 | NPS           | NPS solo acepta integer 0..10 y clasificación por calculator_version explícita. La regla aplica a Web, API y procesos batch.                                                                       |
| BR-EC11-060 | Evaluation    | InstructorEvaluation no puede convertirse en acción RRHH automática.                                                                                                                               |
| BR-EC11-061 | Impact        | ImpactMeasurement requiere metric_code, observed_at y source/provenance. La violación debe mapearse a ProblemDetail estable.                                                                       |
| BR-EC11-062 | Follow-up     | FollowUpCase requiere trigger_reason y owner; no puede usarse como CRM lead. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-063 | Suppression   | Reportes con cohort menor a minimum_cohort_size deben suprimir valores según policy. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                     |
| BR-EC11-064 | Export        | Export nominal requiere rol, purpose, reason, policy y step-up cuando corresponda. La regla aplica a Web, API y procesos batch.                                                                    |
| BR-EC11-065 | AI            | AI output conserva ai_run_ref/confidence/grounding y nunca reemplaza raw response.                                                                                                                 |
| BR-EC11-066 | Cross-context | No FK físicas a CT/EC ajenos; usar refs/contracts. La violación debe mapearse a ProblemDetail estable.                                                                                             |
| BR-EC11-067 | Idempotency   | Commands sensibles usan Idempotency-Key durable y request_hash. Debe existir test negativo y evidencia de auditoría.                                                                               |
| BR-EC11-068 | Concurrency   | Mutaciones usan If-Match; no last-write-wins. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                                            |
| BR-EC11-069 | Outbox        | Transición crítica persiste state + audit + outbox en una transacción. La regla aplica a Web, API y procesos batch.                                                                                |
| BR-EC11-070 | Unknown       | Timeout remoto con efecto entra UNKNOWN_EFFECT y se reconcilia antes de retry.                                                                                                                     |
| BR-EC11-071 | Retention     | Disposición/anonimización se ejecuta conforme retention policy y deja receipt. La violación debe mapearse a ProblemDetail estable.                                                                 |
| BR-EC11-072 | Analytics     | CT-11 consume datasets/eventos gobernados, no bypass directo a raw response tables. Debe existir test negativo y evidencia de auditoría.                                                           |
| BR-EC11-073 | Corporate     | Sponsor access se limita por EC-09 ReportingProfile y suppression. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                       |
| BR-EC11-074 | Localization  | Pregunta/label canónico y traducciones se resuelven por CT-08 sin duplicar versiones por idioma. La regla aplica a Web, API y procesos batch.                                                      |
| BR-EC11-075 | Migration     | Legacy se promueve mediante CT-16 y domain/API; no INSERT directo a tablas finales.                                                                                                                |
| BR-EC11-076 | Tenant        | Toda fila tenant-owned participa en aislamiento RLS y tenant_id nunca se acepta desde body libre. La violación debe mapearse a ProblemDetail estable.                                              |
| BR-EC11-077 | Version       | Una SurveyVersion PUBLISHED es inmutable; cambio material crea nueva versión. Debe existir test negativo y evidencia de auditoría.                                                                 |
| BR-EC11-078 | Question      | Toda pregunta pertenece exactamente a una SurveyVersion y no puede referenciar opciones de otra versión. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL. |
| BR-EC11-079 | Privacy       | PrivacyMode publicado no puede degradarse de ANONYMOUS a IDENTIFIED ni habilitar reidentificación retroactiva. La regla aplica a Web, API y procesos batch.                                        |
| BR-EC11-080 | Purpose       | Toda Campaign debe declarar purpose_ref versionado y compatible con su población/canales.                                                                                                          |
| BR-EC11-081 | Campaign      | Campaign OPEN exige SurveyVersion PUBLISHED, ventana válida, owner scope y targeting resolvible. La violación debe mapearse a ProblemDetail estable.                                               |
| BR-EC11-082 | Invitation    | Token de invitation se persiste solo como hash; nunca plaintext recuperable. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-083 | Response      | SUBMITTED response no permite UPDATE/DELETE destructivo de answers. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                      |
| BR-EC11-084 | NPS           | NPS solo acepta integer 0..10 y clasificación por calculator_version explícita. La regla aplica a Web, API y procesos batch.                                                                       |
| BR-EC11-085 | Evaluation    | InstructorEvaluation no puede convertirse en acción RRHH automática.                                                                                                                               |
| BR-EC11-086 | Impact        | ImpactMeasurement requiere metric_code, observed_at y source/provenance. La violación debe mapearse a ProblemDetail estable.                                                                       |
| BR-EC11-087 | Follow-up     | FollowUpCase requiere trigger_reason y owner; no puede usarse como CRM lead. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-088 | Suppression   | Reportes con cohort menor a minimum_cohort_size deben suprimir valores según policy. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                     |
| BR-EC11-089 | Export        | Export nominal requiere rol, purpose, reason, policy y step-up cuando corresponda. La regla aplica a Web, API y procesos batch.                                                                    |
| BR-EC11-090 | AI            | AI output conserva ai_run_ref/confidence/grounding y nunca reemplaza raw response.                                                                                                                 |
| BR-EC11-091 | Cross-context | No FK físicas a CT/EC ajenos; usar refs/contracts. La violación debe mapearse a ProblemDetail estable.                                                                                             |
| BR-EC11-092 | Idempotency   | Commands sensibles usan Idempotency-Key durable y request_hash. Debe existir test negativo y evidencia de auditoría.                                                                               |
| BR-EC11-093 | Concurrency   | Mutaciones usan If-Match; no last-write-wins. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                                            |
| BR-EC11-094 | Outbox        | Transición crítica persiste state + audit + outbox en una transacción. La regla aplica a Web, API y procesos batch.                                                                                |
| BR-EC11-095 | Unknown       | Timeout remoto con efecto entra UNKNOWN_EFFECT y se reconcilia antes de retry.                                                                                                                     |
| BR-EC11-096 | Retention     | Disposición/anonimización se ejecuta conforme retention policy y deja receipt. La violación debe mapearse a ProblemDetail estable.                                                                 |
| BR-EC11-097 | Analytics     | CT-11 consume datasets/eventos gobernados, no bypass directo a raw response tables. Debe existir test negativo y evidencia de auditoría.                                                           |
| BR-EC11-098 | Corporate     | Sponsor access se limita por EC-09 ReportingProfile y suppression. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                       |
| BR-EC11-099 | Localization  | Pregunta/label canónico y traducciones se resuelven por CT-08 sin duplicar versiones por idioma. La regla aplica a Web, API y procesos batch.                                                      |
| BR-EC11-100 | Migration     | Legacy se promueve mediante CT-16 y domain/API; no INSERT directo a tablas finales.                                                                                                                |
| BR-EC11-101 | Tenant        | Toda fila tenant-owned participa en aislamiento RLS y tenant_id nunca se acepta desde body libre. La violación debe mapearse a ProblemDetail estable.                                              |
| BR-EC11-102 | Version       | Una SurveyVersion PUBLISHED es inmutable; cambio material crea nueva versión. Debe existir test negativo y evidencia de auditoría.                                                                 |
| BR-EC11-103 | Question      | Toda pregunta pertenece exactamente a una SurveyVersion y no puede referenciar opciones de otra versión. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL. |
| BR-EC11-104 | Privacy       | PrivacyMode publicado no puede degradarse de ANONYMOUS a IDENTIFIED ni habilitar reidentificación retroactiva. La regla aplica a Web, API y procesos batch.                                        |
| BR-EC11-105 | Purpose       | Toda Campaign debe declarar purpose_ref versionado y compatible con su población/canales.                                                                                                          |
| BR-EC11-106 | Campaign      | Campaign OPEN exige SurveyVersion PUBLISHED, ventana válida, owner scope y targeting resolvible. La violación debe mapearse a ProblemDetail estable.                                               |
| BR-EC11-107 | Invitation    | Token de invitation se persiste solo como hash; nunca plaintext recuperable. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-108 | Response      | SUBMITTED response no permite UPDATE/DELETE destructivo de answers. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                      |
| BR-EC11-109 | NPS           | NPS solo acepta integer 0..10 y clasificación por calculator_version explícita. La regla aplica a Web, API y procesos batch.                                                                       |
| BR-EC11-110 | Evaluation    | InstructorEvaluation no puede convertirse en acción RRHH automática.                                                                                                                               |
| BR-EC11-111 | Impact        | ImpactMeasurement requiere metric_code, observed_at y source/provenance. La violación debe mapearse a ProblemDetail estable.                                                                       |
| BR-EC11-112 | Follow-up     | FollowUpCase requiere trigger_reason y owner; no puede usarse como CRM lead. Debe existir test negativo y evidencia de auditoría.                                                                  |
| BR-EC11-113 | Suppression   | Reportes con cohort menor a minimum_cohort_size deben suprimir valores según policy. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                     |
| BR-EC11-114 | Export        | Export nominal requiere rol, purpose, reason, policy y step-up cuando corresponda. La regla aplica a Web, API y procesos batch.                                                                    |
| BR-EC11-115 | AI            | AI output conserva ai_run_ref/confidence/grounding y nunca reemplaza raw response.                                                                                                                 |
| BR-EC11-116 | Cross-context | No FK físicas a CT/EC ajenos; usar refs/contracts. La violación debe mapearse a ProblemDetail estable.                                                                                             |
| BR-EC11-117 | Idempotency   | Commands sensibles usan Idempotency-Key durable y request_hash. Debe existir test negativo y evidencia de auditoría.                                                                               |
| BR-EC11-118 | Concurrency   | Mutaciones usan If-Match; no last-write-wins. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                                            |
| BR-EC11-119 | Outbox        | Transición crítica persiste state + audit + outbox en una transacción. La regla aplica a Web, API y procesos batch.                                                                                |
| BR-EC11-120 | Unknown       | Timeout remoto con efecto entra UNKNOWN_EFFECT y se reconcilia antes de retry.                                                                                                                     |
| BR-EC11-121 | Retention     | Disposición/anonimización se ejecuta conforme retention policy y deja receipt. La violación debe mapearse a ProblemDetail estable.                                                                 |
| BR-EC11-122 | Analytics     | CT-11 consume datasets/eventos gobernados, no bypass directo a raw response tables. Debe existir test negativo y evidencia de auditoría.                                                           |
| BR-EC11-123 | Corporate     | Sponsor access se limita por EC-09 ReportingProfile y suppression. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL.                                       |
| BR-EC11-124 | Localization  | Pregunta/label canónico y traducciones se resuelven por CT-08 sin duplicar versiones por idioma. La regla aplica a Web, API y procesos batch.                                                      |
| BR-EC11-125 | Migration     | Legacy se promueve mediante CT-16 y domain/API; no INSERT directo a tablas finales.                                                                                                                |
| BR-EC11-126 | Tenant        | Toda fila tenant-owned participa en aislamiento RLS y tenant_id nunca se acepta desde body libre. La violación debe mapearse a ProblemDetail estable.                                              |
| BR-EC11-127 | Version       | Una SurveyVersion PUBLISHED es inmutable; cambio material crea nueva versión. Debe existir test negativo y evidencia de auditoría.                                                                 |
| BR-EC11-128 | Question      | Toda pregunta pertenece exactamente a una SurveyVersion y no puede referenciar opciones de otra versión. La validación debe existir en dominio y, cuando sea representable, también en PostgreSQL. |
| BR-EC11-129 | Privacy       | PrivacyMode publicado no puede degradarse de ANONYMOUS a IDENTIFIED ni habilitar reidentificación retroactiva. La regla aplica a Web, API y procesos batch.                                        |
| BR-EC11-130 | Purpose       | Toda Campaign debe declarar purpose_ref versionado y compatible con su población/canales.                                                                                                          |

# 10. Casos de uso UC-EC11

| **ID**      | **Caso de uso**                  | **Actor primario**  | **Resumen verificable**                                                                                           |
|-------------|----------------------------------|---------------------|-------------------------------------------------------------------------------------------------------------------|
| UC-EC11-001 | Crear SurveyDefinition           | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-002 | Crear SurveyVersion              | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-003 | Agregar pregunta                 | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-004 | Agregar opción                   | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-005 | Validar instrumento              | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-006 | Enviar a revisión                | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-007 | Aprobar instrumento              | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-008 | Publicar SurveyVersion           | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-009 | Superseder SurveyVersion         | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-010 | Void SurveyVersion               | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-011 | Crear campaña                    | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-012 | Configurar audiencia             | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-013 | Programar campaña                | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-014 | Abrir campaña                    | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-015 | Resolver población               | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-016 | Crear lote de distribución       | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-017 | Enviar invitaciones              | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-018 | Reenviar recordatorio            | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-019 | Abrir invitación                 | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-020 | Iniciar respuesta                | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-021 | Guardar draft                    | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-022 | Enviar respuesta                 | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-023 | Void respuesta                   | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-024 | Crear amendment                  | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-025 | Calcular NPS                     | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-026 | Consultar NPS                    | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-027 | Generar evaluación docente       | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-028 | Consultar evaluación docente     | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-029 | Crear ImpactAssessment           | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-030 | Activar impacto                  | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-031 | Registrar medición               | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-032 | Verificar medición               | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-033 | Rechazar medición                | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-034 | Crear follow-up                  | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-035 | Asignar follow-up                | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-036 | Resolver follow-up               | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-037 | Construir report snapshot        | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-038 | Aplicar suppression              | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-039 | Distribuir reporte               | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-040 | Exportar agregado                | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-041 | Exportar nominal autorizado      | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-042 | Consultar audit trail            | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-043 | Reconciliar entrega              | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-044 | Reconciliar response event       | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-045 | Recalcular métricas derivadas    | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-046 | Solicitar IA sentiment           | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-047 | Revisar IA result                | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-048 | Aceptar clasificación IA         | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-049 | Rechazar clasificación IA        | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-050 | Retención/disposición            | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-051 | Consultar historial              | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-052 | As-of report                     | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-053 | Comparar campañas                | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-054 | Duplicar SurveyVersion           | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-055 | Cerrar campaña                   | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-056 | Cancelar campaña                 | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-057 | Archivar campaña                 | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-058 | Revocar invitation               | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-059 | Expirar invitations              | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-060 | Cambiar ventana antes OPEN       | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-061 | Validar sponsor access           | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-062 | Publicar sponsor snapshot        | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-063 | Consultar response rate          | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-064 | Consultar completion correlation | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-065 | Consultar impact trend           | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-066 | Crear horizon                    | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-067 | Reprogramar horizon              | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-068 | Importar respuestas legacy       | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-069 | Dry-run migration                | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-070 | Promover migration               | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-071 | Consultar operation status       | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-072 | Recuperar idempotency lease      | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-073 | Reclamar outbox lease            | Program Coordinator | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-074 | Procesar inbox dedup             | Privacy Officer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-075 | Gestionar policy unavailable     | Instructor Reviewer | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-076 | MFA export                       | Impact Analyst      | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-077 | Reason-coded override            | Sponsor Analyst     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-078 | Anonymous campaign               | Participant         | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-079 | Pseudonymous campaign            | System Worker       | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |
| UC-EC11-080 | Identified campaign              | Survey Designer     | Contrato de dominio + autorización + tenant + audit; happy/alternative paths especificados en catálogo detallado. |

## 10.1 Casos críticos desarrollados

| **UC**                                    | **Actor**                 | **Precondiciones**                                                                 | **Autorización**         | **Happy Path**                                                                                   | **Alternativas/errores**                                          | **Idempotencia/concurrencia**           | **Side effects/eventos**            | **Postcondición**              |
|-------------------------------------------|---------------------------|------------------------------------------------------------------------------------|--------------------------|--------------------------------------------------------------------------------------------------|-------------------------------------------------------------------|-----------------------------------------|-------------------------------------|--------------------------------|
| UC-EC11-008 Publicar SurveyVersion        | Survey Designer/Approver  | SurveyVersion APPROVED; ETag vigente; questions válidas; privacy/purpose resueltos | step-up si policy        | Lock root → validate graph/scale/privacy → content hash → PUBLISHED → receipt/audit/outbox       | Dependency unavailable mantiene APPROVED; validation issue 422    | Idempotency-Key + If-Match              | Publication event; CT-11 metadata   | Publication receipt + new ETag |
| UC-EC11-022 Enviar respuesta              | Participant/Respondent    | Campaign OPEN; invitation elegible o anonymous token válido                        | token/subject según mode | Validate answers → create submission hash → SUBMITTED → audit/outbox → mark invitation RESPONDED | Expired 410; duplicate same key returns same result; mismatch 409 | Durable idempotency; response root lock | ResponseSubmitted event; NPS derive | Immutable response + receipt   |
| UC-EC11-041 Exportar nominal autorizado   | Authorized Analyst        | Snapshot READY; policy allows nominal; purpose active                              | RBAC+ABAC+step-up+reason | Authorize fields → minimum cohort/suppression → create export receipt → CT-05 artifact ref       | Denied 403; policy unavailable fail-closed                        | Idempotency on export request           | Audit + watermark + expiration      | Artifact ref + evidence        |
| UC-EC11-031 Registrar medición de impacto | Impact Analyst/Respondent | Assessment ACTIVE; horizon due; metric allowed                                     | role/token               | Validate metric/source/time → COLLECTED → verification if required → audit/outbox                | Out-of-window, duplicate source, invalid metric                   | Idempotency + optimistic root           | ImpactMeasurementCollected          | Measurement id + status        |
| UC-EC11-037 Construir report snapshot     | System/Analyst            | Campaign CLOSED or allowed live snapshot; policy refs available                    | authorized role          | Freeze input watermark → aggregate → suppression → hash → READY                                  | Insufficient cohort suppress; dependency stale flagged            | Idempotent builder key                  | ReportSnapshotReady                 | Immutable snapshot hash        |

# 11. DER conceptual, lógico y físico

## 11.1 DER conceptual

```
SurveyDefinition 1---N SurveyVersion 1---N SurveyQuestion 1---N QuestionOption
SurveyVersion 1---N FeedbackCampaign 1---N DistributionBatch 1---N FeedbackInvitation
FeedbackCampaign 1---N FeedbackResponse 1---N ResponseAnswer
FeedbackResponse 1---N ResponseAmendment
FeedbackCampaign 1---N NpsObservation
FeedbackCampaign 1---N InstructorEvaluation
ImpactAssessment 1---N ImpactMeasurement
FeedbackCampaign 0---N FollowUpCase
ImpactAssessment 0---N FollowUpCase
FeedbackCampaign 1---N ReportSnapshot
```

## 11.2 DER lógico

Todas las relaciones internas usan claves tenant-aware. Las referencias a Edition, Enrollment, Person, InstructorAssignment, CorporateEngagement, CredentialAward, Trajectory, workflow, evidence, policies y actors son EXT REF sin FK física. Los aggregates SurveyDefinition/SurveyVersion, Campaign, Response, ImpactAssessment, FollowUpCase y ReportSnapshot poseen revision/version propia.

## 11.3 DER físico — reglas

- PK compuestas (tenant_id, id) para tablas tenant-owned críticas.

- FK internas siempre incluyen tenant_id y, cuando corresponde, parent version id para impedir cross-version.

- Unique parciales para una version PUBLISHED vigente cuando aplique.

- Triggers de inmutabilidad para SurveyVersion PUBLISHED, Response SUBMITTED y ReportSnapshot READY.

- RLS ENABLE + FORCE en todas las tablas tenant-owned.

- runtime role sin BYPASSRLS/ownership; migration role separado.

# 12. Modelo físico PostgreSQL tabla por tabla

## 12.1 ec11_survey_definition

QUÉ REPRESENTA — Identidad estable del instrumento de feedback. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK**          | **Descripción**                                                                                                                | **Ejemplo** |
|--------------------------|---------------------|----------|-------------|--------------------|--------------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | —           | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | 8a6…        |
| survey_id                | uuid                | NO       | —           | PK                 | Survey id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | ejemplo     |
| survey_code              | varchar(64)         | NO       | —           | —                  | Survey code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | ejemplo     |
| survey_type_code         | varchar(80)         | NO       | —           | —                  | Survey type code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| academic_owner_scope_ref | uuid                | NO       | —           | FK interna/EXT REF | Academic owner scope ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| lifecycle_state          | varchar(24)         | NO       | —           | —                  | Lifecycle state. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| default_language_code    | varchar(16)         | NO       | —           | —                  | Default language code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| created_by_subject       | uuid                | NO       | —           | —                  | Created by subject. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| created_at               | timestamptz         | NO       | now()       | —                  | Created at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.               | ejemplo     |
| updated_at               | timestamptz         | NO       | now()       | —                  | Updated at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.               | ejemplo     |
| version                  | bigint              | NO       | —           | —                  | Version. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                  | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

survey_id — Propósito: survey id dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

survey_code — Propósito: survey code dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(64).

survey_type_code — Propósito: survey type code dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

academic_owner_scope_ref — Propósito: academic owner scope ref dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

lifecycle_state — Propósito: lifecycle state dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

default_language_code — Propósito: default language code dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(16).

created_by_subject — Propósito: created by subject dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

created_at — Propósito: created at dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

updated_at — Propósito: updated at dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

version — Propósito: version dentro de ec11_survey_definition. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

| **Nombre físico**                | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|----------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_survey_definition        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_survey_definition_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_survey_definition_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_survey_definition_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_survey_definition       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec11_survey_version

QUÉ REPRESENTA — Snapshot publicable del instrumento y su contrato de privacidad/purpose. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK**          | **Descripción**                                                                                                            | **Ejemplo** |
|----------------------|---------------------|----------|-------------|--------------------|----------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id            | uuid                | NO       | —           | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | 8a6…        |
| survey_version_id    | uuid                | NO       | —           | PK                 | Survey version id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| survey_id            | uuid                | NO       | —           | FK interna/EXT REF | Survey id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| version_no           | integer             | NO       | —           | —                  | Version no. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| state                | varchar(24)         | NO       | —           | —                  | State. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | OPEN        |
| title                | varchar(240)        | NO       | —           | —                  | Title. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | ejemplo     |
| description_text     | text                | NO       | —           | —                  | Description text. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| purpose_ref          | uuid                | NO       | —           | FK interna/EXT REF | Purpose ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| privacy_mode         | varchar(24)         | NO       | —           | —                  | Privacy mode. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ANONYMOUS   |
| retention_policy_ref | uuid                | NO       | —           | FK interna/EXT REF | Retention policy ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| minimum_cohort_size  | integer             | NO       | —           | —                  | Minimum cohort size. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | 5           |
| content_hash         | char(64)            | NO       | —           | —                  | Content hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | a94f…       |
| valid_from           | timestamptz         | NO       | —           | —                  | Valid from. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| valid_to             | timestamptz         | NO       | —           | —                  | Valid to. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | ejemplo     |
| revision             | bigint              | NO       | —           | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | ejemplo     |
| created_at           | timestamptz         | NO       | now()       | —                  | Created at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

survey_version_id — Propósito: survey version id dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

survey_id — Propósito: survey id dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

version_no — Propósito: version no dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

state — Propósito: state dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

title — Propósito: title dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(240).

description_text — Propósito: description text dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

purpose_ref — Propósito: purpose ref dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

privacy_mode — Propósito: privacy mode dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

retention_policy_ref — Propósito: retention policy ref dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

minimum_cohort_size — Propósito: minimum cohort size dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

content_hash — Propósito: content hash dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

valid_from — Propósito: valid from dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

valid_to — Propósito: valid to dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

revision — Propósito: revision dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

created_at — Propósito: created at dentro de ec11_survey_version. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

| **Nombre físico**             | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|-------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_survey_version        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_survey_version_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_survey_version_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_survey_version_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_survey_version       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec11_survey_question

QUÉ REPRESENTA — Pregunta versionada perteneciente a una SurveyVersion. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK**          | **Descripción**                                                                                                         | **Ejemplo** |
|-------------------|---------------------|----------|-------------|--------------------|-------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id         | uuid                | NO       | —           | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | 8a6…        |
| question_id       | uuid                | NO       | —           | PK                 | Question id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| survey_version_id | uuid                | NO       | —           | FK interna/EXT REF | Survey version id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| question_code     | varchar(64)         | NO       | —           | —                  | Question code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| question_type     | varchar(32)         | NO       | —           | —                  | Question type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| prompt_text       | text                | NO       | —           | —                  | Prompt text. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| required          | boolean             | NO       | —           | —                  | Required. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| sequence_no       | integer             | NO       | —           | —                  | Sequence no. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| metric_code       | varchar(80)         | NO       | —           | —                  | Metric code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| min_numeric       | numeric(12          | NO       | —           | —                  | Min numeric. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| 4\)               | text                | NO       | —           | —                  | 4). Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | ejemplo     |
| max_numeric       | numeric(12          | NO       | —           | —                  | Max numeric. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| 4\)               | text                | NO       | —           | —                  | 4). Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | ejemplo     |
| scale_ref         | varchar(120)        | NO       | —           | FK interna/EXT REF | Scale ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| revision          | bigint              | NO       | —           | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

question_id — Propósito: question id dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

survey_version_id — Propósito: survey version id dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

question_code — Propósito: question code dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(64).

question_type — Propósito: question type dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(32).

prompt_text — Propósito: prompt text dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

required — Propósito: required dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con boolean.

sequence_no — Propósito: sequence no dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

metric_code — Propósito: metric code dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

min_numeric — Propósito: min numeric dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con numeric(12.

4\) — Propósito: 4) dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

max_numeric — Propósito: max numeric dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con numeric(12.

4\) — Propósito: 4) dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

scale_ref — Propósito: scale ref dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(120).

revision — Propósito: revision dentro de ec11_survey_question. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

| **Nombre físico**              | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|--------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_survey_question        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_survey_question_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_survey_question_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_survey_question_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_survey_question       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.4 ec11_question_option

QUÉ REPRESENTA — Opción versionada para preguntas choice/rating. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                         | **Ejemplo** |
|-------------------|---------------------|----------|-------------------|--------------------|-------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id         | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | 8a6…        |
| option_id         | uuid                | NO       | gen_random_uuid() | PK                 | Option id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| survey_version_id | uuid                | NO       | —                 | FK interna/EXT REF | Survey version id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| question_id       | uuid                | NO       | —                 | FK interna/EXT REF | Question id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| option_code       | varchar(64)         | NO       | —                 | —                  | Option code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| display_text      | varchar(400)        | NO       | —                 | —                  | Display text. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| numeric_value     | numeric(12          | NO       | —                 | —                  | Numeric value. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| 4\)               | text                | NO       | —                 | —                  | 4). Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | ejemplo     |
| sequence_no       | integer             | NO       | —                 | —                  | Sequence no. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| is_active         | boolean             | NO       | —                 | —                  | Is active. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

option_id — Propósito: option id dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

survey_version_id — Propósito: survey version id dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

question_id — Propósito: question id dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

option_code — Propósito: option code dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(64).

display_text — Propósito: display text dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(400).

numeric_value — Propósito: numeric value dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con numeric(12.

4\) — Propósito: 4) dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

sequence_no — Propósito: sequence no dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

is_active — Propósito: is active dentro de ec11_question_option. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con boolean.

| **Nombre físico**              | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|--------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_question_option        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_question_option_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_question_option_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_question_option_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_question_option       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.5 ec11_feedback_campaign

QUÉ REPRESENTA — Ejecución contextual de una SurveyVersion para población/ventana concretas. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK**          | **Descripción**                                                                                                             | **Ejemplo** |
|-----------------------|---------------------|----------|-------------|--------------------|-----------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id             | uuid                | NO       | —           | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | 8a6…        |
| campaign_id           | uuid                | SÍ       | —           | PK                 | Campaign id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| survey_version_id     | uuid                | NO       | —           | FK interna/EXT REF | Survey version id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| campaign_code         | varchar(64)         | NO       | —           | —                  | Campaign code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| context_type          | varchar(32)         | NO       | —           | —                  | Context type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| context_ref           | uuid                | NO       | —           | FK interna/EXT REF | Context ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| audience_rule_ref     | uuid                | NO       | —           | FK interna/EXT REF | Audience rule ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| owner_scope_ref       | uuid                | NO       | —           | FK interna/EXT REF | Owner scope ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| opens_at              | timestamptz         | NO       | —           | —                  | Opens at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | ejemplo     |
| closes_at             | timestamptz         | NO       | —           | —                  | Closes at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | ejemplo     |
| timezone              | varchar(64)         | NO       | —           | —                  | Timezone. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | ejemplo     |
| state                 | varchar(24)         | NO       | —           | —                  | State. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                 | OPEN        |
| reporting_profile_ref | uuid                | NO       | —           | FK interna/EXT REF | Reporting profile ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| revision              | bigint              | NO       | —           | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | ejemplo     |
| created_at            | timestamptz         | NO       | now()       | —                  | Created at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

campaign_id — Propósito: campaign id dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

survey_version_id — Propósito: survey version id dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

campaign_code — Propósito: campaign code dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(64).

context_type — Propósito: context type dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(32).

context_ref — Propósito: context ref dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

audience_rule_ref — Propósito: audience rule ref dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

owner_scope_ref — Propósito: owner scope ref dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

opens_at — Propósito: opens at dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

closes_at — Propósito: closes at dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

timezone — Propósito: timezone dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(64).

state — Propósito: state dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

reporting_profile_ref — Propósito: reporting profile ref dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

revision — Propósito: revision dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

created_at — Propósito: created at dentro de ec11_feedback_campaign. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

| **Nombre físico**                | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|----------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_feedback_campaign        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_feedback_campaign_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_feedback_campaign_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_feedback_campaign_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_feedback_campaign       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec11_distribution_batch

QUÉ REPRESENTA — Lote de resolución/distribución de audiencia de una campaña. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                             | **Ejemplo** |
|-----------------------|---------------------|----------|-------------------|--------------------|-----------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id             | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | 8a6…        |
| batch_id              | uuid                | NO       | gen_random_uuid() | PK                 | Batch id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | ejemplo     |
| campaign_id           | uuid                | SÍ       | —                 | FK interna/EXT REF | Campaign id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| batch_no              | integer             | NO       | —                 | —                  | Batch no. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | ejemplo     |
| channel_code          | varchar(40)         | NO       | —                 | —                  | Channel code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| audience_snapshot_ref | uuid                | NO       | —                 | FK interna/EXT REF | Audience snapshot ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| status                | varchar(24)         | NO       | —                 | —                  | Status. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | ejemplo     |
| intended_count        | integer             | NO       | —                 | —                  | Intended count. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| resolved_count        | integer             | NO       | —                 | —                  | Resolved count. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| sent_count            | integer             | NO       | —                 | —                  | Sent count. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| failed_count          | integer             | NO       | —                 | —                  | Failed count. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| started_at            | timestamptz         | NO       | —                 | —                  | Started at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| completed_at          | timestamptz         | SÍ       | —                 | —                  | Completed at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| revision              | bigint              | NO       | —                 | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

batch_id — Propósito: batch id dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

campaign_id — Propósito: campaign id dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

batch_no — Propósito: batch no dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

channel_code — Propósito: channel code dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(40).

audience_snapshot_ref — Propósito: audience snapshot ref dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

status — Propósito: status dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

intended_count — Propósito: intended count dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

resolved_count — Propósito: resolved count dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

sent_count — Propósito: sent count dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

failed_count — Propósito: failed count dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

started_at — Propósito: started at dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

completed_at — Propósito: completed at dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

revision — Propósito: revision dentro de ec11_distribution_batch. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|-----------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_distribution_batch        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_distribution_batch_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_distribution_batch_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_distribution_batch_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_distribution_batch       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.7 ec11_feedback_invitation

QUÉ REPRESENTA — Invitación individual o seudónima; guarda token hash y delivery status. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                              | **Ejemplo** |
|------------------------|---------------------|----------|-------------------|--------------------|------------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id              | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | 8a6…        |
| invitation_id          | uuid                | SÍ       | gen_random_uuid() | PK                 | Invitation id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| campaign_id            | uuid                | SÍ       | —                 | FK interna/EXT REF | Campaign id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| batch_id               | uuid                | NO       | gen_random_uuid() | FK interna/EXT REF | Batch id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.               | ejemplo     |
| subject_ref            | uuid                | SÍ       | —                 | FK interna/EXT REF | Subject ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| recipient_channel_hash | char(64)            | NO       | —                 | —                  | Recipient channel hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| token_hash             | char(64)            | NO       | —                 | —                  | Token hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | ejemplo     |
| status                 | varchar(24)         | NO       | —                 | —                  | Status. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                 | ejemplo     |
| expires_at             | timestamptz         | NO       | —                 | —                  | Expires at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | ejemplo     |
| sent_at                | timestamptz         | SÍ       | —                 | —                  | Sent at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | ejemplo     |
| opened_at              | timestamptz         | SÍ       | —                 | —                  | Opened at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | ejemplo     |
| responded_at           | timestamptz         | SÍ       | —                 | —                  | Responded at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| delivery_receipt_ref   | uuid                | NO       | —                 | FK interna/EXT REF | Delivery receipt ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| revision               | bigint              | NO       | —                 | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.               | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

invitation_id — Propósito: invitation id dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

campaign_id — Propósito: campaign id dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

batch_id — Propósito: batch id dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

subject_ref — Propósito: subject ref dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

recipient_channel_hash — Propósito: recipient channel hash dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

token_hash — Propósito: token hash dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

status — Propósito: status dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

expires_at — Propósito: expires at dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

sent_at — Propósito: sent at dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

opened_at — Propósito: opened at dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

responded_at — Propósito: responded at dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

delivery_receipt_ref — Propósito: delivery receipt ref dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

revision — Propósito: revision dentro de ec11_feedback_invitation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|------------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_feedback_invitation        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_feedback_invitation_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_feedback_invitation_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_feedback_invitation_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_feedback_invitation       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.8 ec11_feedback_response

QUÉ REPRESENTA — Unidad de respuesta bajo PrivacyMode; identidad puede estar ausente. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                       | **Ejemplo** |
|-----------------|---------------------|----------|-------------------|--------------------|-----------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id       | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | 8a6…        |
| response_id     | uuid                | NO       | —                 | PK                 | Response id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| campaign_id     | uuid                | SÍ       | —                 | FK interna/EXT REF | Campaign id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| invitation_id   | uuid                | SÍ       | gen_random_uuid() | FK interna/EXT REF | Invitation id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| privacy_mode    | varchar(24)         | NO       | —                 | —                  | Privacy mode. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ANONYMOUS   |
| subject_ref     | uuid                | SÍ       | —                 | FK interna/EXT REF | Subject ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| pseudonym_ref   | uuid                | SÍ       | —                 | FK interna/EXT REF | Pseudonym ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| state           | varchar(24)         | NO       | —                 | —                  | State. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | OPEN        |
| started_at      | timestamptz         | NO       | —                 | —                  | Started at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| submitted_at    | timestamptz         | NO       | —                 | —                  | Submitted at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| submission_hash | char(64)            | NO       | —                 | —                  | Submission hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| source_channel  | varchar(32)         | NO       | —                 | —                  | Source channel. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| locale_code     | varchar(16)         | NO       | —                 | —                  | Locale code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| revision        | bigint              | NO       | —                 | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

response_id — Propósito: response id dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

campaign_id — Propósito: campaign id dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

invitation_id — Propósito: invitation id dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

privacy_mode — Propósito: privacy mode dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

subject_ref — Propósito: subject ref dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

pseudonym_ref — Propósito: pseudonym ref dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

state — Propósito: state dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

started_at — Propósito: started at dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

submitted_at — Propósito: submitted at dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

submission_hash — Propósito: submission hash dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

source_channel — Propósito: source channel dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(32).

locale_code — Propósito: locale code dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(16).

revision — Propósito: revision dentro de ec11_feedback_response. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

| **Nombre físico**                | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|----------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_feedback_response        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_feedback_response_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_feedback_response_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_feedback_response_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_feedback_response       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.9 ec11_response_answer

QUÉ REPRESENTA — Respuesta a una pregunta de la versión pinneada. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                         | **Ejemplo** |
|-------------------|---------------------|----------|-------------------|--------------------|-------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id         | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | 8a6…        |
| answer_id         | uuid                | NO       | gen_random_uuid() | PK                 | Answer id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| response_id       | uuid                | NO       | —                 | FK interna/EXT REF | Response id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| survey_version_id | uuid                | NO       | —                 | FK interna/EXT REF | Survey version id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| question_id       | uuid                | NO       | —                 | FK interna/EXT REF | Question id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| value_text        | text                | SÍ       | —                 | —                  | Value text. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| value_numeric     | numeric(18          | SÍ       | —                 | —                  | Value numeric. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| 6\)               | text                | NO       | —                 | —                  | 6). Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                | ejemplo     |
| value_boolean     | boolean             | NO       | —                 | —                  | Value boolean. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| option_id         | uuid                | NO       | gen_random_uuid() | FK interna/EXT REF | Option id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| answered_at       | timestamptz         | NO       | —                 | —                  | Answered at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| content_hash      | char(64)            | NO       | —                 | —                  | Content hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | a94f…       |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

answer_id — Propósito: answer id dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

response_id — Propósito: response id dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

survey_version_id — Propósito: survey version id dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

question_id — Propósito: question id dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

value_text — Propósito: value text dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

value_numeric — Propósito: value numeric dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con numeric(18.

6\) — Propósito: 6) dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

value_boolean — Propósito: value boolean dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con boolean.

option_id — Propósito: option id dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

answered_at — Propósito: answered at dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

content_hash — Propósito: content hash dentro de ec11_response_answer. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

| **Nombre físico**              | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|--------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_response_answer        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_response_answer_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_response_answer_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_response_answer_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_response_answer       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec11_response_amendment

QUÉ REPRESENTA — Corrección/void append-only aplicada a una respuesta sin mutarla. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                            | **Ejemplo** |
|----------------------|---------------------|----------|-------------------|--------------------|----------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id            | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | 8a6…        |
| amendment_id         | uuid                | NO       | gen_random_uuid() | PK                 | Amendment id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| response_id          | uuid                | NO       | —                 | FK interna/EXT REF | Response id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| amendment_type       | varchar(24)         | NO       | —                 | —                  | Amendment type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| reason_code          | varchar(80)         | NO       | —                 | —                  | Reason code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| evidence_ref         | uuid                | SÍ       | —                 | FK interna/EXT REF | Evidence ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| requested_by_subject | uuid                | NO       | —                 | —                  | Requested by subject. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| approved_by_subject  | uuid                | SÍ       | —                 | —                  | Approved by subject. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| created_at           | timestamptz         | NO       | now()             | —                  | Created at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| effective_at         | timestamptz         | NO       | —                 | —                  | Effective at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| payload_hash         | char(64)            | NO       | —                 | —                  | Payload hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

amendment_id — Propósito: amendment id dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

response_id — Propósito: response id dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

amendment_type — Propósito: amendment type dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

reason_code — Propósito: reason code dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

evidence_ref — Propósito: evidence ref dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

requested_by_subject — Propósito: requested by subject dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

approved_by_subject — Propósito: approved by subject dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

created_at — Propósito: created at dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

effective_at — Propósito: effective at dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

payload_hash — Propósito: payload hash dentro de ec11_response_amendment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|-----------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_response_amendment        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_response_amendment_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_response_amendment_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_response_amendment_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_response_amendment       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.11 ec11_nps_observation

QUÉ REPRESENTA — Observación NPS derivada de una respuesta válida. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                          | **Ejemplo** |
|--------------------|---------------------|----------|-------------------|--------------------|--------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id          | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | 8a6…        |
| nps_observation_id | uuid                | NO       | gen_random_uuid() | PK                 | Nps observation id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| campaign_id        | uuid                | SÍ       | —                 | FK interna/EXT REF | Campaign id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| response_id        | uuid                | NO       | —                 | FK interna/EXT REF | Response id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| question_id        | uuid                | NO       | —                 | FK interna/EXT REF | Question id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| score              | smallint            | NO       | —                 | —                  | Score. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | 9           |
| classification     | varchar(16)         | NO       | —                 | —                  | Classification. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| calculator_version | varchar(40)         | NO       | —                 | —                  | Calculator version. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| observed_at        | timestamptz         | NO       | —                 | —                  | Observed at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| source_hash        | char(64)            | NO       | —                 | —                  | Source hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

nps_observation_id — Propósito: nps observation id dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

campaign_id — Propósito: campaign id dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

response_id — Propósito: response id dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

question_id — Propósito: question id dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

score — Propósito: score dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con smallint.

classification — Propósito: classification dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(16).

calculator_version — Propósito: calculator version dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(40).

observed_at — Propósito: observed at dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

source_hash — Propósito: source hash dentro de ec11_nps_observation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

| **Nombre físico**              | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|--------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_nps_observation        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_nps_observation_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_nps_observation_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_nps_observation_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_nps_observation       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec11_instructor_evaluation

QUÉ REPRESENTA — Proyección gobernada de feedback agregado asociado a instructor/assignment. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                          | **Ejemplo** |
|--------------------|---------------------|----------|-------------------|--------------------|--------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id          | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | 8a6…        |
| evaluation_id      | uuid                | NO       | gen_random_uuid() | PK                 | Evaluation id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| campaign_id        | uuid                | SÍ       | —                 | FK interna/EXT REF | Campaign id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| instructor_ref     | uuid                | NO       | —                 | FK interna/EXT REF | Instructor ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| assignment_ref     | uuid                | NO       | —                 | FK interna/EXT REF | Assignment ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| aggregation_level  | varchar(24)         | NO       | —                 | —                  | Aggregation level. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| respondent_count   | integer             | NO       | —                 | —                  | Respondent count. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| metric_json        | jsonb               | NO       | —                 | —                  | Metric json. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| suppression_state  | varchar(24)         | NO       | —                 | —                  | Suppression state. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| purpose_ref        | uuid                | NO       | —                 | FK interna/EXT REF | Purpose ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| calculated_at      | timestamptz         | NO       | —                 | —                  | Calculated at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| calculator_version | varchar(40)         | NO       | —                 | —                  | Calculator version. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| result_hash        | char(64)            | NO       | —                 | —                  | Result hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

evaluation_id — Propósito: evaluation id dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

campaign_id — Propósito: campaign id dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

instructor_ref — Propósito: instructor ref dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

assignment_ref — Propósito: assignment ref dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

aggregation_level — Propósito: aggregation level dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

respondent_count — Propósito: respondent count dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

metric_json — Propósito: metric json dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con jsonb.

suppression_state — Propósito: suppression state dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

purpose_ref — Propósito: purpose ref dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

calculated_at — Propósito: calculated at dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

calculator_version — Propósito: calculator version dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(40).

result_hash — Propósito: result hash dentro de ec11_instructor_evaluation. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|--------------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_instructor_evaluation        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_instructor_evaluation_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_instructor_evaluation_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_instructor_evaluation_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_instructor_evaluation       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.13 ec11_impact_assessment

QUÉ REPRESENTA — Plan de medición posterior de impacto. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK**          | **Descripción**                                                                                                         | **Ejemplo** |
|-------------------|---------------------|----------|-------------|--------------------|-------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id         | uuid                | NO       | —           | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | 8a6…        |
| assessment_id     | uuid                | SÍ       | —           | PK                 | Assessment id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| context_type      | varchar(32)         | NO       | —           | —                  | Context type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| context_ref       | uuid                | NO       | —           | FK interna/EXT REF | Context ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| assessment_code   | varchar(64)         | NO       | —           | —                  | Assessment code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| purpose_ref       | uuid                | NO       | —           | FK interna/EXT REF | Purpose ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| audience_rule_ref | uuid                | NO       | —           | FK interna/EXT REF | Audience rule ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| state             | varchar(24)         | NO       | —           | —                  | State. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | OPEN        |
| owner_scope_ref   | uuid                | NO       | —           | FK interna/EXT REF | Owner scope ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| starts_at         | timestamptz         | NO       | —           | —                  | Starts at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| ends_at           | timestamptz         | NO       | —           | —                  | Ends at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| revision          | bigint              | NO       | —           | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

assessment_id — Propósito: assessment id dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

context_type — Propósito: context type dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(32).

context_ref — Propósito: context ref dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

assessment_code — Propósito: assessment code dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(64).

purpose_ref — Propósito: purpose ref dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

audience_rule_ref — Propósito: audience rule ref dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

state — Propósito: state dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

owner_scope_ref — Propósito: owner scope ref dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

starts_at — Propósito: starts at dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

ends_at — Propósito: ends at dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

revision — Propósito: revision dentro de ec11_impact_assessment. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

| **Nombre físico**                | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|----------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_impact_assessment        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_impact_assessment_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_impact_assessment_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_impact_assessment_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_impact_assessment       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec11_impact_measurement

QUÉ REPRESENTA — Observación de una métrica de impacto en un horizonte. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                      | **Ejemplo** |
|----------------|---------------------|----------|-------------------|--------------------|----------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id      | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | 8a6…        |
| measurement_id | uuid                | NO       | gen_random_uuid() | PK                 | Measurement id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| assessment_id  | uuid                | SÍ       | —                 | FK interna/EXT REF | Assessment id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| subject_ref    | uuid                | SÍ       | —                 | FK interna/EXT REF | Subject ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| sponsor_ref    | uuid                | SÍ       | —                 | FK interna/EXT REF | Sponsor ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| metric_code    | varchar(80)         | NO       | —                 | —                  | Metric code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| horizon_code   | varchar(40)         | NO       | —                 | —                  | Horizon code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| value_numeric  | numeric(18          | SÍ       | —                 | —                  | Value numeric. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| 6\)            | text                | NO       | —                 | —                  | 6). Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | ejemplo     |
| value_text     | text                | SÍ       | —                 | —                  | Value text. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| unit_code      | varchar(32)         | NO       | —                 | —                  | Unit code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| source_type    | varchar(32)         | NO       | —                 | —                  | Source type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| source_ref     | uuid                | SÍ       | —                 | FK interna/EXT REF | Source ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| observed_at    | timestamptz         | NO       | —                 | —                  | Observed at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| status         | varchar(24)         | NO       | —                 | —                  | Status. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| evidence_ref   | uuid                | SÍ       | —                 | FK interna/EXT REF | Evidence ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| content_hash   | char(64)            | NO       | —                 | —                  | Content hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | a94f…       |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

measurement_id — Propósito: measurement id dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

assessment_id — Propósito: assessment id dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

subject_ref — Propósito: subject ref dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

sponsor_ref — Propósito: sponsor ref dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

metric_code — Propósito: metric code dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

horizon_code — Propósito: horizon code dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(40).

value_numeric — Propósito: value numeric dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con numeric(18.

6\) — Propósito: 6) dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

value_text — Propósito: value text dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con text.

unit_code — Propósito: unit code dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(32).

source_type — Propósito: source type dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(32).

source_ref — Propósito: source ref dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

observed_at — Propósito: observed at dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

status — Propósito: status dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

evidence_ref — Propósito: evidence ref dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

content_hash — Propósito: content hash dentro de ec11_impact_measurement. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|-----------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_impact_measurement        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_impact_measurement_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_impact_measurement_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_impact_measurement_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_impact_measurement       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec11_followup_case

QUÉ REPRESENTA — Seguimiento académico/impacto derivado de regla o revisión. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                         | **Ejemplo** |
|-------------------|---------------------|----------|-------------------|--------------------|-------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id         | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | 8a6…        |
| followup_case_id  | uuid                | NO       | gen_random_uuid() | PK                 | Followup case id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| context_type      | varchar(32)         | NO       | —                 | —                  | Context type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| context_ref       | uuid                | NO       | —                 | FK interna/EXT REF | Context ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| subject_ref       | uuid                | SÍ       | —                 | FK interna/EXT REF | Subject ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| trigger_code      | varchar(80)         | NO       | —                 | —                  | Trigger code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| priority_code     | varchar(24)         | NO       | —                 | —                  | Priority code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| state             | varchar(24)         | NO       | —                 | —                  | State. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.             | OPEN        |
| owner_subject_ref | uuid                | NO       | —                 | FK interna/EXT REF | Owner subject ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| due_at            | timestamptz         | NO       | —                 | —                  | Due at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| outcome_code      | varchar(80)         | NO       | —                 | —                  | Outcome code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| reason_code       | varchar(80)         | NO       | —                 | —                  | Reason code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| revision          | bigint              | NO       | —                 | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| created_at        | timestamptz         | NO       | now()             | —                  | Created at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| resolved_at       | timestamptz         | SÍ       | —                 | —                  | Resolved at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

followup_case_id — Propósito: followup case id dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

context_type — Propósito: context type dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(32).

context_ref — Propósito: context ref dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

subject_ref — Propósito: subject ref dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

trigger_code — Propósito: trigger code dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

priority_code — Propósito: priority code dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

state — Propósito: state dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

owner_subject_ref — Propósito: owner subject ref dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

due_at — Propósito: due at dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

outcome_code — Propósito: outcome code dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

reason_code — Propósito: reason code dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

revision — Propósito: revision dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

created_at — Propósito: created at dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

resolved_at — Propósito: resolved at dentro de ec11_followup_case. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

| **Nombre físico**            | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_followup_case        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_followup_case_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_followup_case_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_followup_case_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_followup_case       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.16 ec11_report_snapshot

QUÉ REPRESENTA — Snapshot reproducible de reporte de feedback/impacto. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                              | **Ejemplo** |
|------------------------|---------------------|----------|-------------------|--------------------|------------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id              | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.              | 8a6…        |
| report_snapshot_id     | uuid                | NO       | gen_random_uuid() | PK                 | Report snapshot id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| campaign_id            | uuid                | SÍ       | —                 | FK interna/EXT REF | Campaign id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| assessment_id          | uuid                | SÍ       | —                 | FK interna/EXT REF | Assessment id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.          | ejemplo     |
| report_type_code       | varchar(80)         | NO       | —                 | —                  | Report type code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| reporting_profile_ref  | uuid                | NO       | —                 | FK interna/EXT REF | Reporting profile ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| purpose_ref            | uuid                | NO       | —                 | FK interna/EXT REF | Purpose ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| input_watermark        | timestamptz         | NO       | —                 | —                  | Input watermark. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| minimum_cohort_size    | integer             | NO       | —                 | —                  | Minimum cohort size. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | 5           |
| suppression_policy_ref | uuid                | NO       | —                 | FK interna/EXT REF | Suppression policy ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| status                 | varchar(24)         | NO       | —                 | —                  | Status. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.                 | ejemplo     |
| respondent_count       | integer             | NO       | —                 | —                  | Respondent count. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| content_hash           | char(64)            | NO       | —                 | —                  | Content hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | a94f…       |
| artifact_ref           | uuid                | SÍ       | —                 | FK interna/EXT REF | Artifact ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.           | ejemplo     |
| built_at               | timestamptz         | NO       | —                 | —                  | Built at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.               | ejemplo     |
| distributed_at         | timestamptz         | SÍ       | —                 | —                  | Distributed at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| revision               | bigint              | NO       | —                 | —                  | Revision. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.               | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

report_snapshot_id — Propósito: report snapshot id dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

campaign_id — Propósito: campaign id dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

assessment_id — Propósito: assessment id dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

report_type_code — Propósito: report type code dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

reporting_profile_ref — Propósito: reporting profile ref dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

purpose_ref — Propósito: purpose ref dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

input_watermark — Propósito: input watermark dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

minimum_cohort_size — Propósito: minimum cohort size dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

suppression_policy_ref — Propósito: suppression policy ref dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

status — Propósito: status dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

respondent_count — Propósito: respondent count dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

content_hash — Propósito: content hash dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

artifact_ref — Propósito: artifact ref dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

built_at — Propósito: built at dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

distributed_at — Propósito: distributed at dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

revision — Propósito: revision dentro de ec11_report_snapshot. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con bigint.

| **Nombre físico**              | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|--------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_report_snapshot        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_report_snapshot_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_report_snapshot_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_report_snapshot_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_report_snapshot       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.17 ec11_idempotency_record

QUÉ REPRESENTA — Registro durable de idempotencia y recuperación. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                         | **Ejemplo** |
|-------------------|---------------------|----------|-------------------|--------------------|-------------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id         | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | 8a6…        |
| idempotency_id    | uuid                | NO       | gen_random_uuid() | PK                 | Idempotency id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| idempotency_key   | varchar(160)        | NO       | —                 | —                  | Idempotency key. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| command_scope     | varchar(120)        | NO       | —                 | —                  | Command scope. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| request_hash      | char(64)            | NO       | —                 | —                  | Request hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| status            | varchar(24)         | NO       | —                 | —                  | Status. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.            | ejemplo     |
| owner_instance    | varchar(120)        | NO       | —                 | —                  | Owner instance. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| lease_until       | timestamptz         | NO       | —                 | —                  | Lease until. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| response_ref      | uuid                | NO       | —                 | FK interna/EXT REF | Response ref. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | ejemplo     |
| response_snapshot | jsonb               | NO       | —                 | —                  | Response snapshot. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| attempt_count     | integer             | NO       | —                 | —                  | Attempt count. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| updated_at        | timestamptz         | NO       | now()             | —                  | Updated at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

idempotency_id — Propósito: idempotency id dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

idempotency_key — Propósito: idempotency key dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(160).

command_scope — Propósito: command scope dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(120).

request_hash — Propósito: request hash dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

status — Propósito: status dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

owner_instance — Propósito: owner instance dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(120).

lease_until — Propósito: lease until dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

response_ref — Propósito: response ref dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

response_snapshot — Propósito: response snapshot dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con jsonb.

attempt_count — Propósito: attempt count dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

updated_at — Propósito: updated at dentro de ec11_idempotency_record. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

| **Nombre físico**                 | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|-----------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_idempotency_record        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_idempotency_record_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_idempotency_record_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_idempotency_record_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_idempotency_record       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.18 ec11_outbox_event

QUÉ REPRESENTA — Outbox transaccional multi-instancia. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                      | **Ejemplo** |
|----------------|---------------------|----------|-------------------|--------------------|----------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id      | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | 8a6…        |
| event_id       | uuid                | NO       | gen_random_uuid() | PK                 | Event id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.       | ejemplo     |
| aggregate_type | varchar(80)         | NO       | —                 | —                  | Aggregate type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| aggregate_id   | uuid                | NO       | gen_random_uuid() | FK interna/EXT REF | Aggregate id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| event_type     | varchar(120)        | NO       | —                 | —                  | Event type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| schema_version | integer             | NO       | —                 | —                  | Schema version. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| correlation_id | uuid                | NO       | gen_random_uuid() | FK interna/EXT REF | Correlation id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| causation_id   | uuid                | NO       | gen_random_uuid() | FK interna/EXT REF | Causation id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| payload        | jsonb               | NO       | —                 | —                  | Payload. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.        | ejemplo     |
| status         | varchar(24)         | NO       | —                 | —                  | Status. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| owner_instance | varchar(120)        | NO       | —                 | —                  | Owner instance. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |
| lease_until    | timestamptz         | NO       | —                 | —                  | Lease until. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| attempt_count  | integer             | NO       | —                 | —                  | Attempt count. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| occurred_at    | timestamptz         | NO       | now()             | —                  | Occurred at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

event_id — Propósito: event id dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

aggregate_type — Propósito: aggregate type dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(80).

aggregate_id — Propósito: aggregate id dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

event_type — Propósito: event type dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(120).

schema_version — Propósito: schema version dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

correlation_id — Propósito: correlation id dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

causation_id — Propósito: causation id dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

payload — Propósito: payload dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con jsonb.

status — Propósito: status dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

owner_instance — Propósito: owner instance dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(120).

lease_until — Propósito: lease until dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

attempt_count — Propósito: attempt count dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con integer.

occurred_at — Propósito: occurred at dentro de ec11_outbox_event. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

| **Nombre físico**           | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|-----------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_outbox_event        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_outbox_event_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_outbox_event_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_outbox_event_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_outbox_event       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.19 ec11_inbox_message

QUÉ REPRESENTA — Deduplicación de mensajes consumidos. Esta tabla conserva únicamente hechos pertenecientes a EC-11 y evita absorber responsabilidades de otros bounded contexts. Su identidad siempre se interpreta dentro de tenant y del lifecycle del aggregate que la gobierna.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea/modifica el Application Service del aggregate correspondiente, bajo transacción tenant-aware, autorización, ETag cuando aplica y auditoría. Queries, workers y analytics acceden mediante repositorios/proyecciones gobernadas; los módulos externos reciben eventos o contratos, no acceso irrestricto al almacenamiento.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege identidad, scope, versionado, lineage y los invariantes locales de feedback/impacto. No representa personas maestras, contratos financieros, estados académicos de EC-07, decisiones RRHH ni documentos binarios.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                      | **Ejemplo** |
|----------------|---------------------|----------|-------------------|--------------------|----------------------------------------------------------------------------------------------------------------------|-------------|
| tenant_id      | uuid                | NO       | —                 | PK\*               | Tenant id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.      | 8a6…        |
| message_id     | uuid                | NO       | gen_random_uuid() | PK                 | Message id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| consumer_code  | varchar(120)        | NO       | —                 | —                  | Consumer code. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.  | ejemplo     |
| event_type     | varchar(120)        | NO       | —                 | —                  | Event type. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.     | ejemplo     |
| received_at    | timestamptz         | NO       | now()             | —                  | Received at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.    | ejemplo     |
| processed_at   | timestamptz         | NO       | —                 | —                  | Processed at. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| status         | varchar(24)         | NO       | —                 | —                  | Status. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.         | ejemplo     |
| payload_hash   | char(64)            | NO       | —                 | —                  | Payload hash. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate.   | ejemplo     |
| correlation_id | uuid                | NO       | gen_random_uuid() | FK interna/EXT REF | Correlation id. Campo gobernado por el dominio EC-11; su semántica exacta depende del estado y policy del aggregate. | ejemplo     |

### Explicación individual de atributos

tenant_id — Propósito: tenant id dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

message_id — Propósito: message id dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

consumer_code — Propósito: consumer code dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(120).

event_type — Propósito: event type dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(120).

received_at — Propósito: received at dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

processed_at — Propósito: processed at dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con timestamptz.

status — Propósito: status dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con varchar(24).

payload_hash — Propósito: payload hash dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con char(64).

correlation_id — Propósito: correlation id dentro de ec11_inbox_message. Nulabilidad y default se restringen por lifecycle; no se utiliza NULL para representar un estado favorable ni se inventan defaults de negocio. Si es PK/FK/ref, participa en identidad, lineage o contrato; tenant_id nunca se recibe desde body libre. Seguridad: el acceso se filtra por RLS y ABAC/purpose cuando el dato puede identificar o segmentar personas. Validación: dominio + constraint/trigger cuando es representable. Ejemplo: valor coherente con uuid.

| **Nombre físico**            | **Tipo** | **Definición/expresión**                       | **Error que impide**                                            |
|------------------------------|----------|------------------------------------------------|-----------------------------------------------------------------|
| pk_ec11_inbox_message        | PK       | PRIMARY KEY tenant-aware                       | Impide duplicar identidad dentro del tenant.                    |
| ix_ec11_inbox_message_tenant | INDEX    | INDEX por tenant y claves de consulta          | Impide planes no controlados/soporta aislamiento y performance. |
| ck_ec11_inbox_message_state  | CHECK    | State/domain constraint cuando aplica          | Impide estados imposibles.                                      |
| trg_ec11_inbox_message_guard | TRIGGER  | Guard de inmutabilidad/lifecycle cuando aplica | Impide mutaciones históricas incluso con bug Backend.           |
| rls_ec11_inbox_message       | RLS      | tenant_id = current_setting(peopleu.tenant_id) | Impide lectura/escritura cross-tenant.                          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Cruces de tenant, FK internas hacia padres de otro tenant/version, estados incompatibles, mutación de snapshots publicados o respuestas sometidas, duplicados por business key y cualquier combinación que permita reidentificación o doble cómputo fuera de policy. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 13. DDL PostgreSQL completo — Flyway Ready

El siguiente DDL es el baseline ejecutable. En Git debe dividirse en migraciones expand/contract, conservar compatibilidad N/N-1 y acompañarse de tests Testcontainers contra PostgreSQL real. Para brevedad operativa se agrupan tablas relacionadas en bloques, pero las constraints nombradas son obligatorias.

## 13.1 Bloque DDL

```
CREATE SCHEMA IF NOT EXISTS ec11;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

-- Runtime tenant context contract
-- SET LOCAL peopleu.tenant_id = '<uuid>';

CREATE TABLE IF NOT EXISTS ec11.ec11_survey_definition (
tenant_id uuid NOT NULL,
survey_id uuid NOT NULL DEFAULT gen_random_uuid(),
survey_code varchar(64) NOT NULL,
survey_type_code varchar(80) NOT NULL,
academic_owner_scope_ref uuid NOT NULL,
lifecycle_state varchar(24) NOT NULL,
default_language_code varchar(16) NOT NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz NOT NULL,
updated_at timestamptz NOT NULL,
version bigint NOT NULL,
CONSTRAINT pk_ec11_survey_definition PRIMARY KEY (tenant_id, survey_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_survey_definition_tenant ON ec11.ec11_survey_definition(tenant_id);
ALTER TABLE ec11.ec11_survey_definition ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_survey_definition FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_survey_definition_tenant ON ec11.ec11_survey_definition;
CREATE POLICY p_ec11_survey_definition_tenant ON ec11.ec11_survey_definition USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_survey_version (
tenant_id uuid NOT NULL,
survey_version_id uuid NOT NULL DEFAULT gen_random_uuid(),
survey_id uuid NOT NULL,
version_no integer NOT NULL,
state varchar(24) NOT NULL,
title varchar(240) NOT NULL,
description_text text NOT NULL,
purpose_ref uuid NOT NULL,
privacy_mode varchar(24) NOT NULL,
retention_policy_ref uuid NOT NULL,
minimum_cohort_size integer NOT NULL,
content_hash char(64) NOT NULL,
valid_from timestamptz NOT NULL,
valid_to timestamptz NOT NULL,
revision bigint NOT NULL,
created_at timestamptz NOT NULL,
CONSTRAINT pk_ec11_survey_version PRIMARY KEY (tenant_id, survey_version_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_survey_version_tenant ON ec11.ec11_survey_version(tenant_id);
ALTER TABLE ec11.ec11_survey_version ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_survey_version FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_survey_version_tenant ON ec11.ec11_survey_version;
CREATE POLICY p_ec11_survey_version_tenant ON ec11.ec11_survey_version USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_survey_question (
tenant_id uuid NOT NULL,
question_id uuid NOT NULL DEFAULT gen_random_uuid(),
survey_version_id uuid NOT NULL,
question_code varchar(64) NOT NULL,
question_type varchar(32) NOT NULL,
prompt_text text NOT NULL,
required boolean NOT NULL,
sequence_no integer NOT NULL,
metric_code varchar(80) NOT NULL,
min_numeric numeric(12 NOT NULL,
4) text NOT NULL,
max_numeric numeric(12 NOT NULL,
4) text NOT NULL,
scale_ref varchar(120) NOT NULL,
revision bigint NOT NULL,
CONSTRAINT pk_ec11_survey_question PRIMARY KEY (tenant_id, question_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_survey_question_tenant ON ec11.ec11_survey_question(tenant_id);
ALTER TABLE ec11.ec11_survey_question ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_survey_question FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_survey_question_tenant ON ec11.ec11_survey_question;
CREATE POLICY p_ec11_survey_question_tenant ON ec11.ec11_survey_question USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_question_option (
tenant_id uuid NOT NULL,
option_id uuid NOT NULL DEFAULT gen_random_uuid(),
survey_version_id uuid NOT NULL,
question_id uuid NOT NULL,
option_code varchar(64) NOT NULL,
display_text varchar(400) NOT NULL,
numeric_value numeric(12 NOT NULL,
4) text NOT NULL,
sequence_no integer NOT NULL,
is_active boolean NOT NULL,
CONSTRAINT pk_ec11_question_option PRIMARY KEY (tenant_id, option_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_question_option_tenant ON ec11.ec11_question_option(tenant_id);
ALTER TABLE ec11.ec11_question_option ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_question_option FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_question_option_tenant ON ec11.ec11_question_option;
CREATE POLICY p_ec11_question_option_tenant ON ec11.ec11_question_option USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_feedback_campaign (
tenant_id uuid NOT NULL,
campaign_id uuid NOT NULL DEFAULT gen_random_uuid(),
survey_version_id uuid NOT NULL,
campaign_code varchar(64) NOT NULL,
context_type varchar(32) NOT NULL,
context_ref uuid NOT NULL,
audience_rule_ref uuid NOT NULL,
owner_scope_ref uuid NOT NULL,
opens_at timestamptz NOT NULL,
closes_at timestamptz NOT NULL,
timezone varchar(64) NOT NULL,
state varchar(24) NOT NULL,
reporting_profile_ref uuid NOT NULL,
revision bigint NOT NULL,
created_at timestamptz NOT NULL,
CONSTRAINT pk_ec11_feedback_campaign PRIMARY KEY (tenant_id, campaign_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_feedback_campaign_tenant ON ec11.ec11_feedback_campaign(tenant_id);
ALTER TABLE ec11.ec11_feedback_campaign ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_feedback_campaign FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_feedback_campaign_tenant ON ec11.ec11_feedback_campaign;
CREATE POLICY p_ec11_feedback_campaign_tenant ON ec11.ec11_feedback_campaign USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_distribution_batch (
tenant_id uuid NOT NULL,
batch_id uuid NOT NULL DEFAULT gen_random_uuid(),
campaign_id uuid,
batch_no integer NOT NULL,
channel_code varchar(40) NOT NULL,
audience_snapshot_ref uuid NOT NULL,
status varchar(24) NOT NULL,
intended_count integer NOT NULL,
resolved_count integer NOT NULL,
sent_count integer NOT NULL,
failed_count integer NOT NULL,
started_at timestamptz NOT NULL,
completed_at timestamptz,
revision bigint NOT NULL,
CONSTRAINT pk_ec11_distribution_batch PRIMARY KEY (tenant_id, batch_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_distribution_batch_tenant ON ec11.ec11_distribution_batch(tenant_id);
ALTER TABLE ec11.ec11_distribution_batch ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_distribution_batch FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_distribution_batch_tenant ON ec11.ec11_distribution_batch;
CREATE POLICY p_ec11_distribution_batch_tenant ON ec11.ec11_distribution_batch USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_feedback_invitation (
tenant_id uuid NOT NULL,
invitation_id uuid NOT NULL DEFAULT gen_random_uuid(),
campaign_id uuid,
batch_id uuid NOT NULL,
subject_ref uuid,
recipient_channel_hash char(64) NOT NULL,
token_hash char(64) NOT NULL,
status varchar(24) NOT NULL,
expires_at timestamptz NOT NULL,
sent_at timestamptz,
opened_at timestamptz,
responded_at timestamptz,
delivery_receipt_ref uuid NOT NULL,
revision bigint NOT NULL,
CONSTRAINT pk_ec11_feedback_invitation PRIMARY KEY (tenant_id, invitation_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_feedback_invitation_tenant ON ec11.ec11_feedback_invitation(tenant_id);
ALTER TABLE ec11.ec11_feedback_invitation ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_feedback_invitation FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_feedback_invitation_tenant ON ec11.ec11_feedback_invitation;
CREATE POLICY p_ec11_feedback_invitation_tenant ON ec11.ec11_feedback_invitation USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_feedback_response (
tenant_id uuid NOT NULL,
response_id uuid NOT NULL DEFAULT gen_random_uuid(),
campaign_id uuid,
invitation_id uuid,
privacy_mode varchar(24) NOT NULL,
subject_ref uuid,
pseudonym_ref uuid,
state varchar(24) NOT NULL,
started_at timestamptz NOT NULL,
submitted_at timestamptz NOT NULL,
submission_hash char(64) NOT NULL,
source_channel varchar(32) NOT NULL,
locale_code varchar(16) NOT NULL,
revision bigint NOT NULL,
CONSTRAINT pk_ec11_feedback_response PRIMARY KEY (tenant_id, response_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_feedback_response_tenant ON ec11.ec11_feedback_response(tenant_id);
ALTER TABLE ec11.ec11_feedback_response ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_feedback_response FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_feedback_response_tenant ON ec11.ec11_feedback_response;
CREATE POLICY p_ec11_feedback_response_tenant ON ec11.ec11_feedback_response USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_response_answer (
tenant_id uuid NOT NULL,
answer_id uuid NOT NULL DEFAULT gen_random_uuid(),
response_id uuid NOT NULL,
survey_version_id uuid NOT NULL,
question_id uuid NOT NULL,
value_text text,
value_numeric numeric(18,
6) text NOT NULL,
value_boolean boolean NOT NULL,
option_id uuid NOT NULL,
answered_at timestamptz NOT NULL,
content_hash char(64) NOT NULL,
CONSTRAINT pk_ec11_response_answer PRIMARY KEY (tenant_id, answer_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_response_answer_tenant ON ec11.ec11_response_answer(tenant_id);
ALTER TABLE ec11.ec11_response_answer ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_response_answer FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_response_answer_tenant ON ec11.ec11_response_answer;
CREATE POLICY p_ec11_response_answer_tenant ON ec11.ec11_response_answer USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_response_amendment (
tenant_id uuid NOT NULL,
amendment_id uuid NOT NULL DEFAULT gen_random_uuid(),
response_id uuid NOT NULL,
amendment_type varchar(24) NOT NULL,
reason_code varchar(80) NOT NULL,
evidence_ref uuid,
requested_by_subject uuid NOT NULL,
approved_by_subject uuid,
created_at timestamptz NOT NULL,
effective_at timestamptz NOT NULL,
payload_hash char(64) NOT NULL,
CONSTRAINT pk_ec11_response_amendment PRIMARY KEY (tenant_id, amendment_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_response_amendment_tenant ON ec11.ec11_response_amendment(tenant_id);
ALTER TABLE ec11.ec11_response_amendment ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_response_amendment FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_response_amendment_tenant ON ec11.ec11_response_amendment;
CREATE POLICY p_ec11_response_amendment_tenant ON ec11.ec11_response_amendment USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_nps_observation (
tenant_id uuid NOT NULL,
nps_observation_id uuid NOT NULL DEFAULT gen_random_uuid(),
campaign_id uuid,
response_id uuid NOT NULL,
question_id uuid NOT NULL,
score smallint NOT NULL,
classification varchar(16) NOT NULL,
calculator_version varchar(40) NOT NULL,
observed_at timestamptz NOT NULL,
```

## 13.2 Bloque DDL

```
source_hash char(64) NOT NULL,
CONSTRAINT pk_ec11_nps_observation PRIMARY KEY (tenant_id, nps_observation_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_nps_observation_tenant ON ec11.ec11_nps_observation(tenant_id);
ALTER TABLE ec11.ec11_nps_observation ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_nps_observation FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_nps_observation_tenant ON ec11.ec11_nps_observation;
CREATE POLICY p_ec11_nps_observation_tenant ON ec11.ec11_nps_observation USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_instructor_evaluation (
tenant_id uuid NOT NULL,
evaluation_id uuid NOT NULL DEFAULT gen_random_uuid(),
campaign_id uuid,
instructor_ref uuid NOT NULL,
assignment_ref uuid NOT NULL,
aggregation_level varchar(24) NOT NULL,
respondent_count integer NOT NULL,
metric_json jsonb NOT NULL,
suppression_state varchar(24) NOT NULL,
purpose_ref uuid NOT NULL,
calculated_at timestamptz NOT NULL,
calculator_version varchar(40) NOT NULL,
result_hash char(64) NOT NULL,
CONSTRAINT pk_ec11_instructor_evaluation PRIMARY KEY (tenant_id, evaluation_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_instructor_evaluation_tenant ON ec11.ec11_instructor_evaluation(tenant_id);
ALTER TABLE ec11.ec11_instructor_evaluation ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_instructor_evaluation FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_instructor_evaluation_tenant ON ec11.ec11_instructor_evaluation;
CREATE POLICY p_ec11_instructor_evaluation_tenant ON ec11.ec11_instructor_evaluation USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_impact_assessment (
tenant_id uuid NOT NULL,
assessment_id uuid NOT NULL DEFAULT gen_random_uuid(),
context_type varchar(32) NOT NULL,
context_ref uuid NOT NULL,
assessment_code varchar(64) NOT NULL,
purpose_ref uuid NOT NULL,
audience_rule_ref uuid NOT NULL,
state varchar(24) NOT NULL,
owner_scope_ref uuid NOT NULL,
starts_at timestamptz NOT NULL,
ends_at timestamptz NOT NULL,
revision bigint NOT NULL,
CONSTRAINT pk_ec11_impact_assessment PRIMARY KEY (tenant_id, assessment_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_impact_assessment_tenant ON ec11.ec11_impact_assessment(tenant_id);
ALTER TABLE ec11.ec11_impact_assessment ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_impact_assessment FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_impact_assessment_tenant ON ec11.ec11_impact_assessment;
CREATE POLICY p_ec11_impact_assessment_tenant ON ec11.ec11_impact_assessment USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_impact_measurement (
tenant_id uuid NOT NULL,
measurement_id uuid NOT NULL DEFAULT gen_random_uuid(),
assessment_id uuid,
subject_ref uuid,
sponsor_ref uuid,
metric_code varchar(80) NOT NULL,
horizon_code varchar(40) NOT NULL,
value_numeric numeric(18,
6) text NOT NULL,
value_text text,
unit_code varchar(32) NOT NULL,
source_type varchar(32) NOT NULL,
source_ref uuid,
observed_at timestamptz NOT NULL,
status varchar(24) NOT NULL,
evidence_ref uuid,
content_hash char(64) NOT NULL,
CONSTRAINT pk_ec11_impact_measurement PRIMARY KEY (tenant_id, measurement_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_impact_measurement_tenant ON ec11.ec11_impact_measurement(tenant_id);
ALTER TABLE ec11.ec11_impact_measurement ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_impact_measurement FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_impact_measurement_tenant ON ec11.ec11_impact_measurement;
CREATE POLICY p_ec11_impact_measurement_tenant ON ec11.ec11_impact_measurement USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_followup_case (
tenant_id uuid NOT NULL,
followup_case_id uuid NOT NULL DEFAULT gen_random_uuid(),
context_type varchar(32) NOT NULL,
context_ref uuid NOT NULL,
subject_ref uuid,
trigger_code varchar(80) NOT NULL,
priority_code varchar(24) NOT NULL,
state varchar(24) NOT NULL,
owner_subject_ref uuid NOT NULL,
due_at timestamptz NOT NULL,
outcome_code varchar(80) NOT NULL,
reason_code varchar(80) NOT NULL,
revision bigint NOT NULL,
created_at timestamptz NOT NULL,
resolved_at timestamptz,
CONSTRAINT pk_ec11_followup_case PRIMARY KEY (tenant_id, followup_case_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_followup_case_tenant ON ec11.ec11_followup_case(tenant_id);
ALTER TABLE ec11.ec11_followup_case ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_followup_case FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_followup_case_tenant ON ec11.ec11_followup_case;
CREATE POLICY p_ec11_followup_case_tenant ON ec11.ec11_followup_case USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_report_snapshot (
tenant_id uuid NOT NULL,
report_snapshot_id uuid NOT NULL DEFAULT gen_random_uuid(),
campaign_id uuid,
assessment_id uuid,
report_type_code varchar(80) NOT NULL,
reporting_profile_ref uuid NOT NULL,
purpose_ref uuid NOT NULL,
input_watermark timestamptz NOT NULL,
minimum_cohort_size integer NOT NULL,
suppression_policy_ref uuid NOT NULL,
status varchar(24) NOT NULL,
respondent_count integer NOT NULL,
content_hash char(64) NOT NULL,
artifact_ref uuid,
built_at timestamptz NOT NULL,
distributed_at timestamptz,
revision bigint NOT NULL,
CONSTRAINT pk_ec11_report_snapshot PRIMARY KEY (tenant_id, report_snapshot_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_report_snapshot_tenant ON ec11.ec11_report_snapshot(tenant_id);
ALTER TABLE ec11.ec11_report_snapshot ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_report_snapshot FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_report_snapshot_tenant ON ec11.ec11_report_snapshot;
CREATE POLICY p_ec11_report_snapshot_tenant ON ec11.ec11_report_snapshot USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_idempotency_record (
tenant_id uuid NOT NULL,
idempotency_id uuid NOT NULL DEFAULT gen_random_uuid(),
idempotency_key varchar(160) NOT NULL,
command_scope varchar(120) NOT NULL,
request_hash char(64) NOT NULL,
status varchar(24) NOT NULL,
owner_instance varchar(120) NOT NULL,
lease_until timestamptz NOT NULL,
response_ref uuid NOT NULL,
response_snapshot jsonb NOT NULL,
attempt_count integer NOT NULL,
updated_at timestamptz NOT NULL,
CONSTRAINT pk_ec11_idempotency_record PRIMARY KEY (tenant_id, idempotency_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_idempotency_record_tenant ON ec11.ec11_idempotency_record(tenant_id);
ALTER TABLE ec11.ec11_idempotency_record ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_idempotency_record FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_idempotency_record_tenant ON ec11.ec11_idempotency_record;
CREATE POLICY p_ec11_idempotency_record_tenant ON ec11.ec11_idempotency_record USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_outbox_event (
tenant_id uuid NOT NULL,
event_id uuid NOT NULL DEFAULT gen_random_uuid(),
aggregate_type varchar(80) NOT NULL,
aggregate_id uuid NOT NULL,
event_type varchar(120) NOT NULL,
schema_version integer NOT NULL,
correlation_id uuid NOT NULL,
causation_id uuid NOT NULL,
payload jsonb NOT NULL,
status varchar(24) NOT NULL,
owner_instance varchar(120) NOT NULL,
lease_until timestamptz NOT NULL,
attempt_count integer NOT NULL,
occurred_at timestamptz NOT NULL,
CONSTRAINT pk_ec11_outbox_event PRIMARY KEY (tenant_id, event_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_outbox_event_tenant ON ec11.ec11_outbox_event(tenant_id);
ALTER TABLE ec11.ec11_outbox_event ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_outbox_event FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_outbox_event_tenant ON ec11.ec11_outbox_event;
CREATE POLICY p_ec11_outbox_event_tenant ON ec11.ec11_outbox_event USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

CREATE TABLE IF NOT EXISTS ec11.ec11_inbox_message (
tenant_id uuid NOT NULL,
message_id uuid NOT NULL DEFAULT gen_random_uuid(),
consumer_code varchar(120) NOT NULL,
event_type varchar(120) NOT NULL,
received_at timestamptz NOT NULL,
processed_at timestamptz NOT NULL,
status varchar(24) NOT NULL,
payload_hash char(64) NOT NULL,
correlation_id uuid NOT NULL,
CONSTRAINT pk_ec11_inbox_message PRIMARY KEY (tenant_id, message_id)
);
CREATE INDEX IF NOT EXISTS ix_ec11_inbox_message_tenant ON ec11.ec11_inbox_message(tenant_id);
ALTER TABLE ec11.ec11_inbox_message ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec11.ec11_inbox_message FORCE ROW LEVEL SECURITY;
DROP POLICY IF EXISTS p_ec11_inbox_message_tenant ON ec11.ec11_inbox_message;
CREATE POLICY p_ec11_inbox_message_tenant ON ec11.ec11_inbox_message USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid) WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);

-- Critical semantic checks
ALTER TABLE ec11.ec11_survey_version ADD CONSTRAINT ck_ec11_survey_version_privacy CHECK (privacy_mode IN ('IDENTIFIED','PSEUDONYMOUS','ANONYMOUS'));
ALTER TABLE ec11.ec11_survey_version ADD CONSTRAINT ck_ec11_survey_version_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','PUBLISHED','SUPERSEDED','VOID'));
ALTER TABLE ec11.ec11_feedback_campaign ADD CONSTRAINT ck_ec11_campaign_window CHECK (closes_at > opens_at);
ALTER TABLE ec11.ec11_feedback_campaign ADD CONSTRAINT ck_ec11_campaign_state CHECK (state IN ('DRAFT','SCHEDULED','OPEN','CLOSED','ARCHIVED','CANCELLED'));
ALTER TABLE ec11.ec11_feedback_response ADD CONSTRAINT ck_ec11_response_state CHECK (state IN ('DRAFT','SUBMITTED','ACCEPTED','VOID'));
ALTER TABLE ec11.ec11_nps_observation ADD CONSTRAINT ck_ec11_nps_score CHECK (score BETWEEN 0 AND 10);
ALTER TABLE ec11.ec11_nps_observation ADD CONSTRAINT ck_ec11_nps_class CHECK (classification IN ('DETRACTOR','PASSIVE','PROMOTER'));
ALTER TABLE ec11.ec11_report_snapshot ADD CONSTRAINT ck_ec11_report_min_cohort CHECK (minimum_cohort_size >= 1);

CREATE UNIQUE INDEX IF NOT EXISTS uq_ec11_survey_version_no ON ec11.ec11_survey_version(tenant_id,survey_id,version_no);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec11_survey_question_code ON ec11.ec11_survey_question(tenant_id,survey_version_id,question_code);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec11_campaign_code ON ec11.ec11_feedback_campaign(tenant_id,campaign_code);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec11_nps_response_question ON ec11.ec11_nps_observation(tenant_id,response_id,question_id);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec11_idempotency_key ON ec11.ec11_idempotency_record(tenant_id,command_scope,idempotency_key);
CREATE UNIQUE INDEX IF NOT EXISTS uq_ec11_inbox_dedup ON ec11.ec11_inbox_message(tenant_id,consumer_code,message_id);

CREATE OR REPLACE FUNCTION ec11.guard_published_survey_version() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
```

## 13.3 Bloque DDL

```
IF OLD.state IN ('PUBLISHED','SUPERSEDED','VOID') AND ROW(NEW.*) IS DISTINCT FROM ROW(OLD.*) THEN
RAISE EXCEPTION 'EC11_SURVEY_VERSION_IMMUTABLE';
END IF;
RETURN NEW;
END$$;
DROP TRIGGER IF EXISTS trg_ec11_survey_version_immutable ON ec11.ec11_survey_version;
CREATE TRIGGER trg_ec11_survey_version_immutable BEFORE UPDATE OR DELETE ON ec11.ec11_survey_version FOR EACH ROW EXECUTE FUNCTION ec11.guard_published_survey_version();

CREATE OR REPLACE FUNCTION ec11.guard_submitted_response() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
IF OLD.state IN ('SUBMITTED','ACCEPTED','VOID') AND ROW(NEW.*) IS DISTINCT FROM ROW(OLD.*) THEN
RAISE EXCEPTION 'EC11_RESPONSE_IMMUTABLE_USE_AMENDMENT';
END IF;
RETURN NEW;
END$$;
DROP TRIGGER IF EXISTS trg_ec11_response_immutable ON ec11.ec11_feedback_response;
CREATE TRIGGER trg_ec11_response_immutable BEFORE UPDATE OR DELETE ON ec11.ec11_feedback_response FOR EACH ROW EXECUTE FUNCTION ec11.guard_submitted_response();

-- Runtime role must not own tables and must not have BYPASSRLS. Migration role is separate.
-- Outbox claim pattern: SELECT ... FOR UPDATE SKIP LOCKED LIMIT :batch; then set owner_instance, lease_until, status='IN_FLIGHT'.
```

# 14. MongoDB y Redis

PostgreSQL es authoritative. MongoDB solo puede mantener proyecciones documentales derivadas para búsqueda/exploración de feedback o explanation payloads que puedan reconstruirse desde eventos/snapshots. Redis se limita a cache efímera, rate limiting y locks no autoritativos; no guarda idempotencia durable, respuestas oficiales ni decisiones de privacidad.

| **Store** | **Key/colección**                    | **Uso**                                                | **Restricción**                                        |
|-----------|--------------------------------------|--------------------------------------------------------|--------------------------------------------------------|
| MongoDB   | feedback_exploration_projection      | Derivada de ResponseSubmitted/AIClassificationReviewed | Rebuildable; no raw identity si privacy no lo permite. |
| MongoDB   | impact_story_projection              | Narrativa derivada de measurements autorizadas         | No Source of Truth.                                    |
| Redis     | campaign-summary:{tenant}:{campaign} | Cache de KPIs                                          | TTL corto; state/freshness explícito.                  |
| Redis     | invitation-rate:{tenant}:{campaign}  | Rate limit/counter operacional                         | No define eligibility.                                 |
| Redis     | report-lock:{tenant}:{snapshot}      | Best-effort build coordination                         | DB idempotency sigue siendo autoridad.                 |

# 15. Backend Java 21 / Spring Boot / Spring Modulith

Módulo lógico recomendado: educationcontinuing.feedbackimpact (API package solo para contratos permitidos). Paquetes hexagonales: domain, application.command, application.query, ports.in, ports.out, adapters.web, adapters.persistence.postgres, adapters.integration, adapters.ct12ai, adapters.analytics, config. Las entidades JPA no salen de adapters.persistence y los DTOs OpenAPI no entran al dominio.

| **Capa**            | **Responsabilidad**                                | **Regla**                                       |
|---------------------|----------------------------------------------------|-------------------------------------------------|
| Domain              | Aggregates, VOs, policies, state machines          | Sin Spring/JPA                                  |
| Application         | Commands/queries/use cases, transaction boundaries | TenantContext + authorization before repository |
| Ports               | Cross-context contracts                            | No direct repository of other module            |
| Postgres adapter    | JPA/JDBC + RLS session context                     | Testcontainers real                             |
| Web adapter         | REST + ProblemDetail + ETag                        | Generated OpenAPI                               |
| Integration adapter | Outbox/inbox + CT-07/09/11/12/13                   | UNKNOWN_EFFECT/reconciliation                   |
| Security            | RBAC/ABAC/purpose/step-up                          | Fail-closed                                     |
| Observability       | OTel logs/metrics/traces                           | PII-safe logging                                |

# 16. APIs REST

| **Método** | **Ruta**                                           | **Uso**                 | **Control**                          | **Resultado** |
|------------|----------------------------------------------------|-------------------------|--------------------------------------|---------------|
| POST       | /ec/feedback/surveys                               | Crear SurveyDefinition  | Idempotency-Key                      | 201           |
| POST       | /ec/feedback/surveys/{id}/versions                 | Crear SurveyVersion     | Idempotency-Key                      | 201           |
| PATCH      | /ec/feedback/survey-versions/{id}                  | Editar DRAFT            | If-Match                             | 200/412       |
| POST       | /ec/feedback/survey-versions/{id}/questions        | Agregar question        | If-Match + Idempotency-Key           | 201           |
| POST       | /ec/feedback/survey-versions/{id}:validate         | Validar                 | If-Match                             | 200           |
| POST       | /ec/feedback/survey-versions/{id}:submit-review    | Revisión                | If-Match + Idempotency-Key           | 202           |
| POST       | /ec/feedback/survey-versions/{id}:publish          | Publicar                | If-Match + Idempotency-Key + step-up | 200           |
| POST       | /ec/feedback/campaigns                             | Crear campaign          | Idempotency-Key                      | 201           |
| PATCH      | /ec/feedback/campaigns/{id}                        | Editar antes OPEN       | If-Match                             | 200/412       |
| POST       | /ec/feedback/campaigns/{id}:open                   | Abrir                   | If-Match + Idempotency-Key           | 200           |
| POST       | /ec/feedback/campaigns/{id}/distribution-batches   | Distribuir              | Idempotency-Key                      | 202           |
| GET        | /ec/feedback/invitations/{token}/context           | Resolver invitation     | token                                | 200/410       |
| POST       | /ec/feedback/responses                             | Iniciar response        | Idempotency-Key                      | 201           |
| PUT        | /ec/feedback/responses/{id}/answers/{questionId}   | Guardar answer draft    | If-Match                             | 200           |
| POST       | /ec/feedback/responses/{id}:submit                 | Enviar                  | If-Match + Idempotency-Key           | 200           |
| POST       | /ec/feedback/responses/{id}:void                   | Void governed           | If-Match + reason + step-up          | 200           |
| POST       | /ec/feedback/responses/{id}/amendments             | Amendment               | Idempotency-Key + reason             | 201           |
| GET        | /ec/feedback/campaigns/{id}/nps                    | NPS                     | —                                    | 200           |
| GET        | /ec/feedback/campaigns/{id}/instructor-evaluations | Evaluación docente      | RBAC/ABAC                            | 200           |
| POST       | /ec/impact/assessments                             | Crear impact assessment | Idempotency-Key                      | 201           |
| POST       | /ec/impact/assessments/{id}/measurements           | Registrar measurement   | Idempotency-Key                      | 201           |
| POST       | /ec/impact/follow-up-cases                         | Crear follow-up         | Idempotency-Key                      | 201           |
| POST       | /ec/feedback/report-snapshots                      | Build snapshot          | Idempotency-Key                      | 202           |
| POST       | /ec/feedback/report-snapshots/{id}:distribute      | Distribuir snapshot     | step-up + reason                     | 202           |
| POST       | /ec/feedback/exports                               | Export gobernado        | Idempotency-Key + step-up + reason   | 202           |
| POST       | /ec/feedback/ai-assists                            | Solicitar CT-12         | Idempotency-Key                      | 202           |
| GET        | /operations/{operationId}                          | OperationStatus         | —                                    | 200           |

## 16.1 DTOs principales

```
CreateCampaignRequest { surveyVersionId, contextType, contextRef, audienceRuleRef, ownerScopeRef, window{opensAt,closesAt,timezone}, reportingProfileRef? }
SubmitResponseRequest { answers:[{questionId, optionId?, valueNumeric?, valueText?, valueBoolean?}], localeCode, clientSubmissionId }
ImpactMeasurementRequest { metricCode, horizonCode, valueNumeric?, valueText?, unitCode?, sourceType, sourceRef?, observedAt, evidenceRef? }
ReportSnapshotRequest { campaignId?, assessmentId?, reportTypeCode, reportingProfileRef?, purposeRef, asOf?, outputFormat }
OperationStatusResponse { operationId,status,resourceRef?,reasonCode?,retryAfter?,correlationId,updatedAt }
```

## 16.2 ProblemDetail y estados

| **HTTP** | **code**                  | **Semántica**                                     |
|----------|---------------------------|---------------------------------------------------|
| 412      | PRECONDITION_FAILED       | ETag/revision mismatch.                           |
| 409      | IDEMPOTENCY_KEY_REUSED    | Same key, different payload.                      |
| 409      | INVALID_STATE_TRANSITION  | Transition not allowed.                           |
| 422      | SURVEY_VALIDATION_FAILED  | Question/privacy/scoring invariant invalid.       |
| 403      | PURPOSE_OR_PRIVACY_DENIED | ABAC/purpose/sponsor policy denies.               |
| 410      | INVITATION_EXPIRED        | Token/invitation expired.                         |
| 503      | DEPENDENCY_UNAVAILABLE    | Required policy/CT dependency unavailable.        |
| 202      | UNKNOWN_EFFECT            | Remote effect cannot yet be confirmed; reconcile. |

# 17. Eventos: Domain Events, Integration Events, Outbox, Inbox y AsyncAPI

| **ID**       | **Evento**                             | **Producer** | **Consumers** |
|--------------|----------------------------------------|--------------|---------------|
| EVT-EC11-001 | SurveyVersionPublished                 | EC-11        | CT-11/EC-12   |
| EVT-EC11-002 | SurveyVersionSuperseded                | EC-11        | CT-11/EC-12   |
| EVT-EC11-003 | FeedbackCampaignScheduled              | EC-11        | CT-07/09/11   |
| EVT-EC11-004 | FeedbackCampaignOpened                 | EC-11        | CT-11/EC-12   |
| EVT-EC11-005 | FeedbackCampaignClosed                 | EC-11        | CT-11/EC-12   |
| EVT-EC11-006 | DistributionBatchStarted               | EC-11        | CT-07/09/11   |
| EVT-EC11-007 | FeedbackInvitationSent                 | EC-11        | CT-11/EC-12   |
| EVT-EC11-008 | FeedbackInvitationDeliveryUnknown      | EC-11        | CT-11/EC-12   |
| EVT-EC11-009 | FeedbackResponseStarted                | EC-11        | CT-07/09/11   |
| EVT-EC11-010 | FeedbackResponseSubmitted              | EC-11        | CT-11/EC-12   |
| EVT-EC11-011 | FeedbackResponseVoided                 | EC-11        | CT-11/EC-12   |
| EVT-EC11-012 | ResponseAmendmentRecorded              | EC-11        | CT-07/09/11   |
| EVT-EC11-013 | NpsObservationCreated                  | EC-11        | CT-11/EC-12   |
| EVT-EC11-014 | InstructorEvaluationSnapshotCalculated | EC-11        | CT-11/EC-12   |
| EVT-EC11-015 | ImpactAssessmentActivated              | EC-11        | CT-07/09/11   |
| EVT-EC11-016 | ImpactMeasurementCollected             | EC-11        | CT-11/EC-12   |
| EVT-EC11-017 | ImpactMeasurementVerified              | EC-11        | CT-11/EC-12   |
| EVT-EC11-018 | FollowUpCaseOpened                     | EC-11        | CT-07/09/11   |
| EVT-EC11-019 | FollowUpCaseResolved                   | EC-11        | CT-11/EC-12   |
| EVT-EC11-020 | ReportSnapshotReady                    | EC-11        | CT-11/EC-12   |
| EVT-EC11-021 | ReportSnapshotDistributed              | EC-11        | CT-07/09/11   |
| EVT-EC11-022 | FeedbackExportProduced                 | EC-11        | CT-11/EC-12   |
| EVT-EC11-023 | RetentionDispositionCompleted          | EC-11        | CT-11/EC-12   |
| EVT-EC11-024 | AIClassificationReviewed               | EC-11        | CT-07/09/11   |

```
{
"messageId":"uuid", "tenantId":"uuid", "eventType":"FeedbackResponseSubmitted",
"schemaVersion":1, "occurredAt":"2026-09-12T18:00:00Z",
"correlationId":"uuid", "causationId":"uuid",
"aggregateType":"FeedbackResponse", "aggregateId":"uuid",
"dataClassification":"RESTRICTED",
"payload":{"campaignId":"uuid","responseId":"uuid","privacyMode":"ANONYMOUS","submissionHash":"sha256"}
}
```

Outbox usa leasing multi-instancia con FOR UPDATE SKIP LOCKED; inbox deduplica por message_id+consumer. No se promete exactly-once distribuido. Consumidores deben ser idempotentes y toda PII del payload se minimiza según data classification/purpose.

# 18. Integraciones: timeouts, retries, circuit breaker, fallback, degradación, reconciliation y UNKNOWN_EFFECT

| **Integración**      | **Efecto**                 | **Timeout** | **Retry**                                      | **Unknown/reconcile**                       | **Fallback/degradación**                  |
|----------------------|----------------------------|-------------|------------------------------------------------|---------------------------------------------|-------------------------------------------|
| CT-07 Notifications  | Enviar invitation/reminder | 2-5s        | retry solo si no effect o provider idempotency | UNKNOWN_EFFECT + reconcile provider receipt | Nunca duplicar invitation business state. |
| CT-12 AI             | Sentiment/topic/summarize  | 10-30s      | async preferred                                | UNAVAILABLE/PARTIAL; no bloquea cierre      | Nunca convertir missing AI en zero.       |
| CT-11 Analytics      | Publish dataset/event      | async       | outbox retry                                   | eventual consistency                        | Source Truth permanece EC-11.             |
| CT-13 Scheduling     | Programar follow-up        | 5s          | idempotent schedule key                        | UNKNOWN_EFFECT + query schedule             | No blind retry.                           |
| EC-09 Sponsor Portal | Distribute report snapshot | async       | idempotent artifact/ref                        | UNKNOWN_EFFECT + reconcile access grant     | No raw response exposure.                 |
| CT-05 Documents      | Crear artifact export      | async       | idempotent request                             | UNKNOWN_EFFECT + artifact lookup            | No guardar blobs local.                   |

# 19. Frontend Web enterprise por Workspaces

| **Workspace**                   | **Actores**         | **Route**                | **Layout/KPI**                                                      | **Commands**                                                     | **Estados críticos**                             |
|---------------------------------|---------------------|--------------------------|---------------------------------------------------------------------|------------------------------------------------------------------|--------------------------------------------------|
| Survey & Instrument Studio      | Designer/Approver   | /ec/feedback/surveys     | Library + version timeline + question builder + validation          | Create version, add questions/options, validate, review, publish | ETag conflicts, policy unavailable, version diff |
| Campaign Orchestration Console  | Coordinator         | /ec/feedback/campaigns   | Campaign grid + window + audience + delivery KPIs                   | Schedule/open/close/cancel/distribute                            | UNKNOWN_EFFECT delivery, partial counts          |
| Response & Privacy Desk         | Privacy Officer     | /ec/feedback/privacy     | Privacy modes, suppression rules, audit, exception requests         | Void/amend/reidentify where legally/policy allowed               | step-up, reason, evidence                        |
| NPS & Experience Center         | Analyst             | /ec/feedback/experience  | NPS, satisfaction, response rate, segments, trend                   | Build snapshot, compare campaigns                                | NO_DATA vs ZERO vs suppressed                    |
| Instructor Evaluation Workspace | Authorized Reviewer | /ec/feedback/instructors | Instructor filters + cohort threshold + metrics + comments governed | View/acknowledge/export allowed aggregate                        | Small cohort suppression; no HR action           |
| Impact Assessment Studio        | Impact Analyst      | /ec/impact/assessments   | Horizons, metrics, cohorts, measurement status                      | Activate, collect, verify, close                                 | stale dependencies, partial horizons             |
| Follow-up Operations            | Coordinator         | /ec/impact/follow-ups    | Kanban/list + due dates + reasons + outcomes                        | Assign, resolve, dismiss                                         | No CRM features                                  |
| Reporting & Snapshot Center     | Analyst             | /ec/feedback/reports     | Snapshot builder + profile + suppression preview + lineage          | Build/distribute/export                                          | Purpose denied, stale, partial, unavailable      |
| Corporate Impact View           | Sponsor authorized  | /ec/feedback/corporate   | Aggregated KPI cards + milestones + impact                          | Download authorized snapshot                                     | No raw/individual data unless profile allows     |
| Audit & Evidence Desk           | Auditor             | /ec/feedback/audit       | Timeline + reason + hashes + receipts + event lineage               | Investigate/export evidence pack                                 | Read-only; step-up for sensitive evidence        |

## 19.1 Contrato de estados Frontend

| **ESTADOS OBLIGATORIOS —** NO_DATA ≠ ZERO ≠ STALE ≠ PARTIAL ≠ UNAVAILABLE ≠ UNKNOWN_EFFECT ≠ SUPPRESSED. SUPPRESSED significa que existe información pero no puede mostrarse por política; nunca debe reemplazarse por 0 ni por “sin respuestas”. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Cada workspace define query keys con tenant/scope implícitos, campaign/version/asOf/freshness; usa cliente generado OpenAPI, no DTOs duplicados. Mutations capturan ETag y devuelven Conflict Drawer en 412. Exports y acciones sensibles muestran purpose/reason, step-up y receipts. Accesibilidad: teclado completo, labels, live regions para estados async y alternativa tabular a visualizaciones.

# 20. Mobile

Mobile es selectivo. Tiene sentido para responder encuestas, recibir recordatorios, revisar follow-ups propios y consultar resultados agregados autorizados. No replica el Survey Designer, reglas de privacidad complejas, administración de exports nominales ni operaciones de reidentificación.

| **Journey**        | **Capacidades**                                                                        | **Restricciones**                                                                                      |
|--------------------|----------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| Respondent Mobile  | Abrir deep link/token, responder, guardar draft local mínimo, submit, ver confirmación | Secure storage; no persistir respuestas sensibles más de lo necesario; offline draft cifrado opcional. |
| Sponsor Mobile     | KPI agregado, NPS/impacto permitido, report snapshots autorizados, notificaciones      | Nunca raw responses; ReportingProfile EC-09.                                                           |
| Instructor Mobile  | Consultar evaluación agregada si threshold/policy lo permiten                          | No comentarios identificables cuando privacy lo prohíba.                                               |
| Coordinator Mobile | Estado campaign/delivery y alerts                                                      | No authoring crítico; commands de cierre solo si policy explícita + biometric step-up.                 |

# 21. Matriz Frontend / Backend / Mobile

| **Capability**         | **Frontend Web** | **Backend**              | **Mobile**  |
|------------------------|------------------|--------------------------|-------------|
| Diseñar Survey         | Completo         | API/domain authoritative | Limitado/No |
| Publicar SurveyVersion | Completo         | API/domain authoritative | Limitado/No |
| Crear Campaign         | Completo         | API/domain authoritative | Limitado/No |
| Distribuir Invitations | Completo         | API/domain authoritative | Limitado/No |
| Responder Survey       | Completo         | API/domain authoritative | Sí          |
| Ver NPS                | Completo         | API/domain authoritative | Sí          |
| Evaluación docente     | Completo         | API/domain authoritative | Sí          |
| ImpactAssessment       | Completo         | API/domain authoritative | Limitado/No |
| ImpactMeasurement      | Completo         | API/domain authoritative | Sí          |
| Follow-up              | Completo         | API/domain authoritative | Sí          |
| Build ReportSnapshot   | Completo         | API/domain authoritative | Limitado/No |
| Export nominal         | Completo         | API/domain authoritative | Limitado/No |
| IA sentiment           | Completo         | API/domain authoritative | Limitado/No |
| Audit evidence         | Completo         | API/domain authoritative | Limitado/No |

# 22. Seguridad: RBAC, ABAC, SoD, step-up, Tenant Scope, purpose limitation y Threat Model

RBAC define capacidad base; ABAC agrega tenant, scope institucional, campaign/context, privacy mode, purpose_ref, data classification, reporting profile, cohort size y assurance. SoD exige que diseñador no autoapruebe publicación material cuando policy lo requiera; export nominal/reidentification/void sensible requieren step-up y reason. Logs nunca deben incluir free-text raw ni tokens de invitation.

## 22.1 Threat Model

| **Amenaza**         | **Vector**                         | **Control**                                         |
|---------------------|------------------------------------|-----------------------------------------------------|
| IDOR/cross-tenant   | Manipular campaign/response id     | RLS + tenant-aware PK/FK + authz test               |
| Reidentificación    | Cruzar small cohorts/filters       | minimum cohort + suppression + query policy + audit |
| Replay              | Reusar invitation token/submit     | token hash + expiry + idempotency + state           |
| Tampering           | Editar response/snapshot           | immutable state + hashes + trigger                  |
| Mass assignment     | Enviar subject_ref/privacy fields  | DTO whitelist; tenant/privacy derived server-side   |
| Race                | double submit/close                | row lock + ETag + unique/index                      |
| ETag bypass         | child update without root revision | Aggregate Revision Contract                         |
| Injection           | free text/filter                   | parameterized SQL; output encoding                  |
| SSRF                | external evidence URL              | CT-05/09 controlled fetch; allowlists               |
| Secret exposure     | tokens/provider keys               | secret manager; token hashes; redacted logs         |
| Webhook spoofing    | fake provider receipt              | signature verification + replay window              |
| Resource exhaustion | huge surveys/exports               | limits/pagination/rate quotas/async jobs            |
| Data leakage        | analytics/export                   | purpose + field policy + suppression + watermark    |
| Prompt injection    | free-text to AI                    | CT-12 isolation/grounding/output review             |

## 22.2 Secure SDLC

- SAST bloqueante en código nuevo/modificado.

- SCA con policy de CVE/licencias.

- Secret scanning en pre-commit/CI.

- Container scan y base image policy.

- SBOM por release.

- DAST/API security tests en staging.

- Tenant isolation tests y privacy abuse cases obligatorios.

- Breaking-change checks OpenAPI/AsyncAPI.

# 23. Auditoría: Audit Trail, Evidence Pack, lineage, reason codes y assurance

Toda operación crítica produce audit con actor_subject, assurance level, tenant/scope, command, target, before/after hash, reason_code, correlation_id, purpose_ref y evidence refs. Para ANONYMOUS response, el audit operacional no debe introducir una identidad que el modelo de privacidad decidió no persistir. Evidence Pack de campaign incluye SurveyVersion hash, campaign config, audience resolution receipt, delivery summary, submission counts, suppression policy, calculation versions, snapshot hashes y export/distribution receipts.

| **Evidence Pack** | **Contenido mínimo**                                       | **Garantía**                                            |
|-------------------|------------------------------------------------------------|---------------------------------------------------------|
| Publication       | SurveyVersion hash + approval + policy refs + outbox       | Auditor reconstruye qué instrumento estuvo vigente.     |
| Response          | submission_hash + campaign/version refs + privacy mode     | Prueba de integridad sin exponer identidad innecesaria. |
| NPS               | input set watermark + calculator_version + result hash     | Reproducibilidad.                                       |
| Impact            | measurement provenance + verification + evidence refs      | Lineage posterior.                                      |
| Export            | purpose + fields + role + step-up + artifact hash + expiry | Accountability de disclosure.                           |
| Retention         | policy + disposed scope + method + receipt                 | Prueba de minimización/disposición.                     |

# 24. Observabilidad: logs, metrics, traces, SLI/SLO, performance y resiliencia

| **Métrica/SLI**             | **Definición**                                       | **Objetivo**        |
|-----------------------------|------------------------------------------------------|---------------------|
| SLI API availability        | successful requests / total excluding client errors  | 99.9% mensual       |
| SLI submit latency          | p95 POST response submit                             | \< 600 ms sync path |
| SLI campaign open           | successful scheduled opens within tolerance          | 99.95%              |
| SLI delivery reconciliation | UNKNOWN_EFFECT reconciled within target              | 99% \< 15 min       |
| SLI report build            | READY snapshots within size-based target             | 99%                 |
| Business response rate      | submitted / eligible invitations                     | No SLO; KPI         |
| NPS coverage                | valid NPS observations / submitted with NPS question | \>99.9% correctness |
| Suppression safety          | violations of minimum cohort policy                  | 0                   |
| Tenant leakage              | confirmed cross-tenant access                        | 0                   |

Tracing propaga correlation/causation por HTTP, outbox y adapters. Logs son estructurados y PII-safe. Cardinalidad controlada: no usar response_id/person_ref como metric labels. Dashboards separan salud técnica, backlog de outbox/inbox, campaigns, response rates, UNKNOWN_EFFECT y privacy denials.

# 25. IA aplicada al módulo

Toda IA pasa por CT-12. Usos admitidos: clasificar temas, sentiment, resumir comentarios, detectar señales recurrentes, sugerir categorías de follow-up, comparar cohorts y redactar narrativa para analistas. El raw response y la policy de privacidad determinan si un texto puede salir al pipeline de IA; cuando no está permitido, el adapter no envía contenido.

| **Use case**         | **Input**                    | **Output**                     | **Guardrail**                             |
|----------------------|------------------------------|--------------------------------|-------------------------------------------|
| Topic classification | Free text autorizado         | topic suggestions + confidence | Analyst review                            |
| Sentiment            | Free text autorizado         | sentiment label/score          | No reemplaza NPS ni decisión              |
| Summarization        | Cohort autorizado/suppressed | summary draft                  | No revelar small-cell detail              |
| Impact insight       | Measurements agregadas       | patterns/hypotheses            | Human validation                          |
| Risk signal          | Follow-up candidates         | recommendation                 | Nunca abrir case disciplinario automático |

Guardar siempre ai_run_ref, model_ref, template_ref, eval_ref, grounding refs, confidence, reviewer, outcome. AI RECOMMENDATION ≠ DECISION. Se requiere eval set contra leakage, hallucination, bias y false attribution antes de habilitar por tenant.

# 26. Analítica y KPI

| **KPI**                     | **Fórmula conceptual**                  | **Regla**                  |
|-----------------------------|-----------------------------------------|----------------------------|
| Response Rate               | submitted / eligible invitations        | Campaign/segment permitido |
| Completion of Survey        | submitted / started                     | Campaign                   |
| NPS                         | %promoters - %detractors                | Solo question NPS válida   |
| Satisfaction Mean           | mean rating                             | Escala comparable          |
| Instructor Evaluation Index | policy-defined weighted metric          | Con suppression            |
| Impact Application Rate     | participants reporting/applied evidence | Horizon                    |
| Sponsor Impact Score        | authorized corporate aggregation        | EC-09 profile              |
| Follow-up Resolution Rate   | resolved / opened                       | Period                     |
| Time to Follow-up           | resolved_at - created_at                | P50/P95                    |
| Comment Topic Share         | reviewed AI/manual topics / comments    | No raw identity            |
| Suppression Rate            | suppressed cells / candidate cells      | Privacy health             |

# 27. Migración legacy y Data Quality con CT-16

Pipeline obligatorio: Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → Receipt → Reconcile → Certify. No INSERT directo a tablas finales. Cada legacy survey se mapea a SurveyDefinition/Version con version pin; respuestas importadas conservan source lineage y privacy classification; si no se puede demostrar consentimiento/purpose/identity mapping, se restringen a agregado o se excluyen según policy.

| **Origen**             | **Map**                                 | **DQ checks**                      | **Promoción**            |
|------------------------|-----------------------------------------|------------------------------------|--------------------------|
| Legacy questionnaire   | Map questions/options/scales            | Stable codes, language, scoring    | Publication dry-run      |
| Legacy responses       | Map campaign/version/answers            | Identity/privacy provenance        | Hash+count reconcile     |
| Legacy NPS             | Recompute from raw score when available | Do not trust old aggregate blindly | Compare old/new          |
| Legacy instructor eval | Map only authorized fields              | No HR shadow data                  | Privacy officer sign-off |
| Legacy impact          | Map metrics/horizons/source             | Unit normalization                 | DQ certification         |

# 28. QA y estrategia de pruebas

| **Nivel**         | **Cobertura**                                            | **Gate**                 |
|-------------------|----------------------------------------------------------|--------------------------|
| Unit              | State machines, policies, NPS calculator, suppression    | High coverage domain     |
| DB/Testcontainers | RLS, constraints, triggers, tenant context, locks        | PostgreSQL real          |
| Contract          | OpenAPI/AsyncAPI + CT/EC ports                           | Breaking-change checks   |
| Integration       | CT-07/09/11/12/13 adapters + UNKNOWN_EFFECT              | Stub + failure injection |
| Security          | IDOR, cross-tenant, ABAC, purpose, step-up, export abuse | Negative-first suite     |
| Concurrency       | double submit/open/close/build                           | Race harness             |
| Idempotency       | same key/same payload and different payload              | Lease recovery           |
| Performance       | large campaign, answer write, snapshot build             | p95/p99 + DB plans       |
| Privacy           | anonymous non-reidentification, small cohort suppression | Dedicated abuse tests    |
| Accessibility     | WCAG AA critical journeys                                | Keyboard/screen reader   |
| Mobile            | deep links, offline draft, secure storage                | Device tests             |
| Migration         | dry-run/reconcile/rollback-forward                       | CT-16 evidence           |

# 29. Golden Scenarios

| **GS**      | **Escenario**              | **Precondición**          | **Acción**               | **Resultado esperado**                                           | **Evidencia**                |
|-------------|----------------------------|---------------------------|--------------------------|------------------------------------------------------------------|------------------------------|
| GS-EC11-001 | Happy path publish survey  | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-002 | Tenant isolation           | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-003 | RLS negative               | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-004 | Double submit              | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-005 | Idempotency same key       | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-006 | Idempotency mismatch       | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-007 | ETag conflict              | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-008 | Anonymous response         | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-009 | Pseudonymous response      | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-010 | Identified response        | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-011 | Invitation expired         | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-012 | Delivery timeout           | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-013 | UNKNOWN_EFFECT reconcile   | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-014 | NPS detractor              | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-015 | NPS passive                | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-016 | NPS promoter               | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-017 | Invalid NPS 11             | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-018 | Small cohort suppression   | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-019 | Export nominal denied      | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-020 | Export nominal approved    | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-021 | Instructor eval privacy    | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-022 | Impact 30d                 | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-023 | Impact 90d                 | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-024 | Impact missing source      | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-025 | Follow-up trigger          | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-026 | Follow-up resolve          | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-027 | AI unavailable             | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-028 | AI leakage guard           | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-029 | Migration dry-run          | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-030 | Outbox duplicate           | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-031 | Inbox duplicate            | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-032 | Policy stale               | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-033 | Policy unavailable         | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-034 | Sponsor profile denied     | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-035 | Sponsor aggregated allowed | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-036 | Retention disposition      | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-037 | Amendment response         | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-038 | Void response              | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-039 | Snapshot reproducibility   | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-040 | N/N-1 rollout              | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-041 | Happy path publish survey  | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-042 | Tenant isolation           | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-043 | RLS negative               | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-044 | Double submit              | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-045 | Idempotency same key       | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-046 | Idempotency mismatch       | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-047 | ETag conflict              | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-048 | Anonymous response         | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-049 | Pseudonymous response      | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-050 | Identified response        | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-051 | Invitation expired         | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-052 | Delivery timeout           | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-053 | UNKNOWN_EFFECT reconcile   | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-054 | NPS detractor              | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-055 | NPS passive                | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-056 | NPS promoter               | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-057 | Invalid NPS 11             | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-058 | Small cohort suppression   | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-059 | Export nominal denied      | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-060 | Export nominal approved    | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-061 | Instructor eval privacy    | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-062 | Impact 30d                 | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-063 | Impact 90d                 | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-064 | Impact missing source      | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-065 | Follow-up trigger          | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-066 | Follow-up resolve          | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-067 | AI unavailable             | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-068 | AI leakage guard           | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-069 | Migration dry-run          | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-070 | Outbox duplicate           | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-071 | Inbox duplicate            | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-072 | Policy stale               | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-073 | Policy unavailable         | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-074 | Sponsor profile denied     | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-075 | Sponsor aggregated allowed | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-076 | Retention disposition      | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-077 | Amendment response         | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-078 | Void response              | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-079 | Snapshot reproducibility   | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-080 | N/N-1 rollout              | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-081 | Happy path publish survey  | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-082 | Tenant isolation           | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-083 | RLS negative               | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-084 | Double submit              | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-085 | Idempotency same key       | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-086 | Idempotency mismatch       | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-087 | ETag conflict              | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-088 | Anonymous response         | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-089 | Pseudonymous response      | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-090 | Identified response        | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-091 | Invitation expired         | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-092 | Delivery timeout           | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-093 | UNKNOWN_EFFECT reconcile   | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-094 | NPS detractor              | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-095 | NPS passive                | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-096 | NPS promoter               | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-097 | Invalid NPS 11             | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-098 | Small cohort suppression   | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-099 | Export nominal denied      | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-100 | Export nominal approved    | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-101 | Instructor eval privacy    | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-102 | Impact 30d                 | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-103 | Impact 90d                 | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-104 | Impact missing source      | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-105 | Follow-up trigger          | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-106 | Follow-up resolve          | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-107 | AI unavailable             | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-108 | AI leakage guard           | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-109 | Migration dry-run          | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-110 | Outbox duplicate           | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-111 | Inbox duplicate            | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-112 | Policy stale               | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-113 | Policy unavailable         | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-114 | Sponsor profile denied     | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-115 | Sponsor aggregated allowed | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-116 | Retention disposition      | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |
| GS-EC11-117 | Amendment response         | Tenant A context          | Run concurrent workers   | No cross-tenant data; DB/API deny safely.                        | audit/event/receipt          |
| GS-EC11-118 | Void response              | Response/campaign fixture | Call query/export        | Correct derived metric/suppression; reproducible hash.           | screenshot + trace           |
| GS-EC11-119 | Snapshot reproducibility   | Dependency configured     | Inject failure and retry | UNKNOWN_EFFECT/reconciliation without duplicate business effect. | runbook evidence             |
| GS-EC11-120 | N/N-1 rollout              | Campaign/Survey valid     | Execute command/API      | Invariant preserved; explicit status and audit evidence.         | contract test + DB assertion |

# 30. UAT institucional

| **UAT** | **Escenario**        | **Criterio de aceptación**                                                |
|---------|----------------------|---------------------------------------------------------------------------|
| UAT-01  | Publicar instrumento | Designer/Approver publica versión; queda inmutable y auditable.           |
| UAT-02  | Campaña de cierre    | Se resuelve población, invita, responde y cierra sin duplicados.          |
| UAT-03  | Anonimato            | Usuario anónimo responde y ningún rol normal puede reconstruir identidad. |
| UAT-04  | NPS                  | Score 0..10 produce clasificación y NPS reproducible.                     |
| UAT-05  | Evaluación docente   | Reviewer ve agregado autorizado; small cohort se suprime.                 |
| UAT-06  | Impacto 90 días      | Assessment agenda/recoge/verifica measurement con lineage.                |
| UAT-07  | Sponsor corporate    | Sponsor solo ve campos/métricas permitidos por profile.                   |
| UAT-08  | Export nominal       | Sin purpose/role/step-up se deniega; con policy se audita.                |
| UAT-09  | Concurrencia         | Double submit no duplica respuestas; ETag previene overwrite.             |
| UAT-10  | Dependencia caída    | Frontend distingue UNAVAILABLE/STALE/PARTIAL/UNKNOWN_EFFECT.              |
| UAT-11  | Migration            | Legacy se dry-run, promueve por domain API y reconcilia.                  |
| UAT-12  | IA                   | Resumen muestra provenance y no altera raw response.                      |
| UAT-13  | Retención            | Disposición deja receipt y no rompe métricas autorizadas.                 |
| UAT-14  | Tenant isolation     | Cross-tenant query/command falla en DB y API.                             |
| UAT-15  | Mobile               | Deep link responde de forma segura; admin crítico no expuesto.            |
| UAT-16  | Auditoría            | Auditor reconstruye SurveyVersion, campaign, response hash y snapshot.    |
| UAT-17  | N/N-1                | Release expand/contract opera con pods N/N-1.                             |
| UAT-18  | EC-12 contract       | EC-12 recibe eventos/KPI gobernados sin acceso raw irrestricto.           |

# 31. Gates G1-G10

| **Gate** | **Dominio**                    | **Evidencia mínima**                                                               |
|----------|--------------------------------|------------------------------------------------------------------------------------|
| G1       | Arquitectura y bounded context | Context map, ADRs, Source of Truth, anti-scope aprobados.                          |
| G2       | Datos/constraints              | DDL, RLS, triggers, privacy constraints y Testcontainers green.                    |
| G3       | Backend                        | Commands/queries/state/idempotency/concurrency implementados.                      |
| G4       | API/Event contracts            | OpenAPI/AsyncAPI congelados + compatibility checks.                                |
| G5       | Frontend/Mobile                | Workspaces/states/a11y/mobile boundaries aprobados.                                |
| G6       | Seguridad/auditoría            | Threat model, ABAC/purpose, suppression, evidence pack, pentest findings cerrados. |
| G7       | Integraciones/resiliencia      | Timeout/retry/UNKNOWN_EFFECT/reconciliation probados.                              |
| G8       | QA/UAT                         | Golden Scenarios + UAT institutional evidence.                                     |
| G9       | Migración/operaciones          | CT-16, runbooks, SLO, dashboards, backup/restore.                                  |
| G10      | Release/certificación          | DoR/DoD, SBOM, release checklist, zero-downtime evidence.                          |

# 32. Definition of Ready / Definition of Done

## 32.1 DoR

- BR/UC vinculados a issue y acceptance criteria.

- Source of Truth y cross-context contracts identificados.

- Privacy/purpose/data classification definidos.

- OpenAPI/AsyncAPI change impact evaluado.

- Migration/data impacts documentados.

- Threat scenarios y test strategy listos.

- UI states y mobile applicability definidos.

## 32.2 DoD

- Código + tests + DDL + contracts mergeados y revisados.

- RLS/constraints/concurrency/idempotency/resilience tests green.

- SAST/SCA/secrets/container/SBOM gates green.

- Observability dashboards/alerts/runbooks validados.

- UAT y Gates con evidencia.

- Docs/ADRs actualizados.

- Release expand/contract y rollback/roll-forward probados.

# 33. Runbooks

| **Runbook** | **Trigger**                      | **Procedimiento**                                                                                                             |
|-------------|----------------------------------|-------------------------------------------------------------------------------------------------------------------------------|
| RB-EC11-001 | Delivery UNKNOWN_EFFECT          | Query provider receipt by correlation/idempotency; reconcile before retry; do not create new invitation.                      |
| RB-EC11-002 | Outbox stuck                     | Inspect expired leases; reclaim SKIP LOCKED; verify broker by event_id; never recreate business event.                        |
| RB-EC11-003 | RLS incident                     | Disable affected path, preserve evidence, verify runtime role/SET LOCAL/pool reuse, run tenant suite, rotate creds if needed. |
| RB-EC11-004 | Unexpected reidentification risk | Stop exports/segment drilldown, freeze evidence, privacy officer review, increase suppression, incident CT-10.                |
| RB-EC11-005 | NPS mismatch                     | Freeze snapshot, compare calculator version/input watermark/source hashes; rebuild derived only, never edit responses.        |
| RB-EC11-006 | Campaign opened wrong            | If no responses and policy allows cancel/replace; otherwise preserve campaign and create corrective campaign/version.         |
| RB-EC11-007 | AI unsafe output                 | Hide derived insight, preserve ai_run_ref, mark rejected, CT-12 incident/eval update; raw response unchanged.                 |
| RB-EC11-008 | Export leakage                   | Revoke access/artifact if supported, CT-10 incident, preserve evidence, identify recipients, rotate link/token.               |
| RB-EC11-009 | Snapshot build failure           | Keep BUILDING/FAILED receipt, inspect input watermark/dependencies, retry idempotently after fix.                             |
| RB-EC11-010 | Retention job failure            | Do not partially claim success; resume from receipt/checkpoint; verify tombstone/crypto-shred consistency.                    |
| RB-EC11-011 | Migration discrepancy            | Pause promote, compare counts/hashes, quarantine source batch, rerun dry-run.                                                 |
| RB-EC11-012 | N/N-1 regression                 | Stop rollout; keep expand schema; rollback app only if compatible; prefer roll-forward DB/app fix.                            |

# 34. ADRs y decisiones abiertas

| **ADR**      | **Tema**                        | **Estado** | **Decisión/pendiente**                                       |
|--------------|---------------------------------|------------|--------------------------------------------------------------|
| ADR-EC11-001 | Survey Definition/Version split | Adopted    | Immutable published versions.                                |
| ADR-EC11-002 | Privacy modes                   | Adopted    | IDENTIFIED/PSEUDONYMOUS/ANONYMOUS explicit.                  |
| ADR-EC11-003 | Response immutability           | Adopted    | Append-only amendment/void.                                  |
| ADR-EC11-004 | NPS calculator versioning       | Adopted    | Reproducible observations/snapshots.                         |
| ADR-EC11-005 | Instructor evaluation boundary  | Adopted    | No HR decision ownership.                                    |
| ADR-EC11-006 | Impact separate from completion | Adopted    | EC-07 remains owner of completion/results.                   |
| ADR-EC11-007 | Minimum cohort suppression      | Adopted    | DB/app/report enforcement.                                   |
| ADR-EC11-008 | CT-12 only AI                   | Adopted    | No provider calls local.                                     |
| ADR-EC11-009 | No cross-context FK             | Adopted    | Ports/contracts/refs.                                        |
| ADR-EC11-010 | PostgreSQL authoritative        | Adopted    | Mongo/Redis derived only.                                    |
| ADR-EC11-011 | Mobile selective                | Adopted    | Respondent/sponsor journeys; no critical admin.              |
| ADR-EC11-012 | Anonymous invitation design     | Adopted    | Token hash and no subject_ref in response.                   |
| ADR-EC11-013 | Retention method per policy     | Open       | Tombstone vs crypto-shred depends CT-10/tenant requirements. |

# 35. Engineering Pack

| **Ruta**       | **Contenido mínimo**                                             |
|----------------|------------------------------------------------------------------|
| /docs          | EC11-module-spec.md, privacy-model.md, ops-guide.md              |
| /openapi       | ec11-feedback-impact-v1.yaml                                     |
| /asyncapi      | ec11-events-v1.yaml                                              |
| /db/migration  | V...\_\_ec11_expand.sql, backfill, contract                      |
| /architecture  | context-map.puml, der.puml, state-machines.puml                  |
| /adr           | ADR-EC11-001...                                                  |
| /backend       | module source + tests                                            |
| /frontend      | feature modules/workspaces/tests                                 |
| /mobile        | respondent/sponsor feature tests                                 |
| /tests         | contract, integration, tenant, privacy, concurrency, idempotency |
| /performance   | k6/gatling scripts + baselines                                   |
| /security      | threat-model.md, abuse-cases.md, SBOM refs                       |
| /runbooks      | RB-EC11-001...                                                   |
| /observability | dashboards, alerts, SLI/SLO                                      |
| /migration     | mapping, dry-run, reconciliation                                 |
| /evidence      | gate evidence, UAT, release certification                        |

# 36. Guía secuencial Backend

**Paso 1 —** Crear Spring Modulith module ec11-feedback-impact y boundaries.

**Paso 2 —** Definir package structure hexagonal y exports permitidos.

**Paso 3 —** Implementar SurveyDefinition/SurveyVersion aggregates.

**Paso 4 —** Implementar Campaign/Invitation aggregates.

**Paso 5 —** Implementar FeedbackResponse/Answer/Amendment aggregate.

**Paso 6 —** Implementar ImpactAssessment/Measurement aggregate.

**Paso 7 —** Implementar FollowUpCase/ReportSnapshot aggregates.

**Paso 8 —** Definir VOs PrivacyContract, ResponseWindow, MetricValue, NpsScore.

**Paso 9 —** Implementar domain policies/state machines.

**Paso 10 —** Crear ports cross-context para CT/EC dependencies.

**Paso 11 —** Implementar Flyway expand schema, constraints y RLS.

**Paso 12 —** Implementar TenantDbContext SET LOCAL y runtime role tests.

**Paso 13 —** Repositorios Postgres tenant-aware.

**Paso 14 —** Application commands con authorization/purpose.

**Paso 15 —** Queries/projections con suppression policy.

**Paso 16 —** REST controllers + ProblemDetail.

**Paso 17 —** ETag/If-Match + Aggregate Revision Contract.

**Paso 18 —** Idempotency durable + lease/recovery.

**Paso 19 —** Outbox SKIP LOCKED + inbox dedup.

**Paso 20 —** Adapters CT-07/09/11/12/13 + UNKNOWN_EFFECT.

**Paso 21 —** NPS calculator versionado y tests vectors.

**Paso 22 —** Report snapshot builder con watermark/hash/suppression.

**Paso 23 —** Audit/evidence hooks y correlation propagation.

**Paso 24 —** OpenAPI/AsyncAPI generation + compatibility CI.

**Paso 25 —** Contract/integration/security/privacy/concurrency/performance tests.

**Paso 26 —** Observability OTel metrics/traces/log redaction.

**Paso 27 —** Migration CT-16 promotion endpoints/process.

**Paso 28 —** Threat model/SAST/SCA/SBOM/container gates.

**Paso 29 —** Expand/contract N/N-1 rehearsal.

**Paso 30 —** Gates G1-G10 + release certification.

# 37. Guía secuencial Frontend

**Paso 1 —** Crear feature modules ec-feedback, ec-impact y route tree con permission guards.

**Paso 2 —** Generar API client/DTOs desde OpenAPI; prohibir duplicación manual.

**Paso 3 —** Definir query keys con campaign/version/asOf/freshness.

**Paso 4 —** Construir Survey & Instrument Studio shell.

**Paso 5 —** Question builder accesible con tipos/opciones/escalas.

**Paso 6 —** Version timeline/diff/validation issues.

**Paso 7 —** Campaign Orchestration Console.

**Paso 8 —** Audience/distribution views + UNKNOWN_EFFECT status.

**Paso 9 —** Respondent web flow con token/privacy notice.

**Paso 10 —** NPS & Experience Center con estados SUPPRESSED/NO_DATA/ZERO.

**Paso 11 —** Instructor Evaluation Workspace con privacy threshold.

**Paso 12 —** Impact Assessment Studio y horizons.

**Paso 13 —** Follow-up Operations.

**Paso 14 —** Reporting Snapshot Center + suppression preview.

**Paso 15 —** Corporate Impact View con ReportingProfile.

**Paso 16 —** Audit & Evidence Desk.

**Paso 17 —** ETag handling + Conflict Drawer.

**Paso 18 —** Idempotency keys client-side per command.

**Paso 19 —** OperationStatus polling/backoff.

**Paso 20 —** Stale/partial/unavailable/unknown/suppressed UX.

**Paso 21 —** Accessibility keyboard/screen reader.

**Paso 22 —** Responsive behavior.

**Paso 23 —** Security: no PII in URL/local storage/logging.

**Paso 24 —** Component/e2e/contract/a11y tests.

# 38. Matriz de permisos

| **Acción**                   | **Designer** | **Approver** | **Coordinator** | **Privacy Officer** | **Experience Analyst** | **Instructor Reviewer** | **Impact Analyst** | **Sponsor** | **Auditor** |
|------------------------------|--------------|--------------|-----------------|---------------------|------------------------|-------------------------|--------------------|-------------|-------------|
| Edit Survey DRAFT            | ALLOW\*      | —            | —               | —                   | —                      | —                       | —                  | —           | —           |
| Publish Survey               | —            | ALLOW\*      | —               | —                   | —                      | —                       | —                  | —           | —           |
| Open Campaign                | —            | —            | ALLOW\*         | —                   | —                      | —                       | —                  | —           | —           |
| View raw identified response | —            | —            | —               | ALLOW\*             | —                      | —                       | —                  | —           | —           |
| View anonymous raw response  | —            | —            | —               | ALLOW\*             | ALLOW\*                | —                       | —                  | —           | —           |
| View instructor aggregate    | —            | —            | —               | —                   | ALLOW\*                | ALLOW\*                 | —                  | PROFILE     | —           |
| Build snapshot               | —            | —            | —               | —                   | ALLOW\*                | —                       | ALLOW\*            | PROFILE     | —           |
| Export nominal               | —            | —            | —               | ALLOW\*             | —                      | —                       | —                  | —           | —           |
| Reidentify pseudonym         | —            | —            | —               | ALLOW\*             | —                      | —                       | —                  | —           | —           |
| Manage impact                | —            | —            | —               | —                   | —                      | —                       | ALLOW\*            | —           | —           |
| Resolve follow-up            | —            | —            | ALLOW\*         | —                   | —                      | —                       | ALLOW\*            | —           | —           |
| View audit                   | —            | —            | —               | ALLOW\*             | —                      | —                       | —                  | —           | ALLOW\*     |

\* ALLOW siempre sujeto a tenant/scope, ABAC, purpose, privacy mode, SoD y step-up cuando corresponda. PROFILE = solo lo permitido por EC-09 ReportingProfile.

# 39. Contratos DTO Frontend

| **DTO**                 | **Campos mínimos**                                                                            |
|-------------------------|-----------------------------------------------------------------------------------------------|
| SurveyVersionDetailDto  | id,surveyId,versionNo,state,title,privacyMode,purposeRef,questions,validation,etag,links      |
| CampaignSummaryDto      | id,code,state,window,context,responseRate,deliveryStatus,privacyMode,etag                     |
| ResponseFormDto         | campaignId,surveyVersionId,privacyNotice,questions,expiresAt,saveDraftAllowed                 |
| ExperienceMetricsDto    | asOf,responseCount,responseRate,nps?,satisfaction?,suppressionState,freshness                 |
| InstructorEvaluationDto | instructorRef,respondentCount,metrics,suppressionState,commentsSummary?,asOf                  |
| ImpactAssessmentDto     | id,state,horizons,metrics,collectionStatus,etag                                               |
| ReportSnapshotDto       | id,status,reportType,inputWatermark,respondentCount,suppressionState,contentHash,artifactRef? |
| OperationStatusDto      | operationId,status,resourceRef?,reasonCode?,retryAfter?,correlationId,updatedAt               |
| ProblemDetailDto        | type,title,status,detail,code,correlationId,fieldErrors?,retryAfter?                          |

# 40. Checklist de release y certificación

- [ ] Word/Git/OpenAPI/AsyncAPI/Flyway hashes alineados.

- [ ] All sections 0-41 complete.

- [ ] RLS ENABLE+FORCE; runtime role no BYPASSRLS.

- [ ] Cross-context refs sin FK físicas.

- [ ] SurveyVersion/Response/Snapshot immutability tested.

- [ ] Privacy modes and suppression abuse tests green.

- [ ] ETag/If-Match and idempotency durable tested.

- [ ] Outbox/inbox leasing/dedup tested multi-instance.

- [ ] UNKNOWN_EFFECT reconciliation tested for notification/document/scheduling effects.

- [ ] OpenAPI client regenerated and no manual DTO drift.

- [ ] Threat model closed; SAST/SCA/secret/container/SBOM green.

- [ ] Performance baseline accepted.

- [ ] Observability dashboards/alerts active.

- [ ] Migration dry-run/reconcile/certify completed if applicable.

- [ ] UAT institutional signed.

- [ ] G1-G10 evidence pack complete.

- [ ] Expand/contract N/N-1 rehearsal complete.

- [ ] Runbooks exercised.

- [ ] Backup/restore/data disposition procedures verified.

# 41. Contrato FullStack no negociable de implementación

**EC11-FS-01 —** Source of Truth respetado: EC-11 no reescribe hechos de EC-01…EC-10 ni CT/cores.

**EC11-FS-02 —** No FK físicas cross-context.

**EC11-FS-03 —** tenant_id nunca proviene de body libre.

**EC11-FS-04 —** RLS ENABLE + FORCE en toda tabla tenant-owned; runtime sin BYPASSRLS.

**EC11-FS-05 —** Aggregate Revision Contract en toda mutación de hijos.

**EC11-FS-06 —** ETag/If-Match en commands mutables; 412 en mismatch.

**EC11-FS-07 —** No last-write-wins.

**EC11-FS-08 —** SurveyVersion PUBLISHED immutable.

**EC11-FS-09 —** Response SUBMITTED/ACCEPTED immutable; correction por amendment/void.

**EC11-FS-10 —** ReportSnapshot READY immutable y reproducible.

**EC11-FS-11 —** Idempotency durable con request_hash, lease y recovery.

**EC11-FS-12 —** Outbox leased multi-instancia; Inbox dedup.

**EC11-FS-13 —** UNKNOWN_EFFECT + reconciliation; no blind retry.

**EC11-FS-14 —** State machines físicas y de dominio coherentes.

**EC11-FS-15 —** Anonymous/pseudonymous/identified son contratos explícitos, no flags decorativos.

**EC11-FS-16 —** Minimum cohort suppression antes de dashboard/export.

**EC11-FS-17 —** Sponsor access gobernado por EC-09 ReportingProfile.

**EC11-FS-18 —** Instructor evaluation no ejecuta decisiones RRHH.

**EC11-FS-19 —** NPS versionado y reproducible; no confundir con satisfacción.

**EC11-FS-20 —** AI solo vía CT-12; recommendation ≠ decision; provenance obligatoria.

**EC11-FS-21 —** OpenAPI-generated client y DTOs sin duplicación manual.

**EC11-FS-22 —** ProblemDetail/OperationStatus estables.

**EC11-FS-23 —** Secure SDLC + Threat Model obligatorios.

**EC11-FS-24 —** Migration CT-16; no INSERT directo final.

**EC11-FS-25 —** Expand/deploy/backfill/switch/contract y N/N-1.

**EC11-FS-26 —** Observabilidad técnica y business KPI con PII-safe telemetry.

**EC11-FS-27 —** Golden Scenarios y UAT ejecutados.

**EC11-FS-28 —** Gates G1-G10 con evidencia.

**EC11-FS-29 —** Evidence Pack reconstruye publicación, campaña, respuestas, métricas, snapshots, exports y disposición.

**EC11-FS-30 —** No se considera producción lista sin checklist 40 aprobado.

| **CIERRE DE MÓDULO —** EC-11 queda definido como bounded context de experiencia e impacto posterior: escucha gobernada, privacidad explícita, medición reproducible, follow-up trazable y contratos seguros hacia EC-12/CT-11. La implementación no puede simplificar estas garantías sin ADR y aprobación arquitectónica. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
