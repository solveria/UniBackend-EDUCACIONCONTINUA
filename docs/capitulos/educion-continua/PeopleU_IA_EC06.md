**PEOPLEU IA**

**EC-06**

**ASISTENCIA, PARTICIPACIÓN, ENGAGEMENT  
Y EVIDENCIA DE SESIONES**

Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Control**    | **Valor**                                                                                                      |
|----------------|----------------------------------------------------------------------------------------------------------------|
| Código         | EC-06                                                                                                          |
| Versión        | V1.0                                                                                                           |
| Estado         | VIGENTE — GUÍA FULLSTACK ENTERPRISE                                                                            |
| Baseline       | EC-00 V1.1 · EC-01 V1.1 · EC-02…EC-05 vigentes                                                                 |
| Vertical       | Educación Continua / Formación Continua                                                                        |
| Arquitectura   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| Stack objetivo | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| Contexto       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| Fecha base     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS — Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial.** |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA — EC-06 es Source of Truth de los hechos de asistencia, participación y evidencia operacional por sesión de participantes válidamente vinculados a una edición. No es dueño de calendario, enrollment, evaluación, completion ni certificados.** |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaración de propósito, autoridad y baseline

| **V1.0 — MÓDULO DE ASISTENCIA EVIDENCIABLE — EC-06 transforma señales operativas de presencia/participación en hechos académicos auditables, sin confundir telemetría con verdad ni attendance con completion.** |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

EC-06 resuelve la captura, adjudicación y reconstrucción de asistencia y participación en programas presenciales, virtuales síncronos, asíncronos e híbridos. Debe soportar toma de lista por instructor, QR dinámico, check-in/check-out móvil, cargas offline, importaciones corporativas y telemetría de LMS/videoconferencia, preservando siempre provenance, policy snapshot y capacidad de reconciliación.

El módulo no decide aprobación académica ni emite certificados. EC-07 consume hechos oficiales de asistencia/participación para evaluar completion; EC-08 consume los hechos resultantes de EC-07. La evidencia binaria pertenece a CT-05 y la telemetría externa se integra exclusivamente a través de CT-18/CT-09.

| **CRITERIO DE ÉXITO — Para cualquier participante, sesión y edición, la universidad debe poder explicar años después qué se observó, qué fuente lo produjo, qué política se aplicó, quién corrigió el hecho, qué evidencia lo sustentó y cuál fue el estado oficial consumido downstream.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquía documental aplicable

| **Prioridad** | **Documento/artefacto**                | **Rol**                                                   |
|---------------|----------------------------------------|-----------------------------------------------------------|
| 1             | AM-00 vigente                          | Constitución arquitectónica superior.                     |
| 2             | CT-00 vigente                          | Contrato maestro transversal.                             |
| 3             | CT-01…CT-18 vigentes                   | Capacidades compartidas y fronteras.                      |
| 4             | EC-00 V1.1                             | Constitución funcional/arquitectónica EC.                 |
| 5             | EC-01 V1.1                             | Plantilla oficial FullStack y diseño académico.           |
| 6             | EC-02…EC-05 vigentes                   | Contratos upstream que EC-06 consume.                     |
| 7             | EC-06 V1.0                             | Especificación implementable de asistencia/participación. |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Evidencia implementada y compatible.                      |

## 0.2 Secuencia oficial vigente de módulos EC

| **Orden** | **Código** | **Módulo oficial**                                                                            | **Responsabilidad**   |
|-----------|------------|-----------------------------------------------------------------------------------------------|-----------------------|
| 1         | EC-01      | Portafolio, programas, versiones, módulos y rutas de microcredenciales                        | Diseño académico      |
| 2         | EC-02      | Ediciones, ofertas, cohortes, modalidades, calendarios y programación operativa               | Oferta / ejecución    |
| 3         | EC-03      | Comercialización académica, pricing, promociones, becas, convenios y condiciones de oferta    | Comercial             |
| 4         | EC-04      | Prospectos, participantes, registro, preinscripción, inscripción, cupos y listas de espera    | Vinculación           |
| 5         | EC-05      | Docentes, expertos, facilitadores, planificación, contenidos y entorno de aprendizaje         | Docencia              |
| 6         | EC-06      | Asistencia, participación, engagement y evidencia de sesiones                                 | Participación         |
| 7         | EC-07      | Evaluaciones, resultados, aprobación, completion y cierre académico                           | Evaluación / cierre   |
| 8         | EC-08      | Certificados, badges, microcredenciales, credenciales verificables y acumulabilidad           | Certificación         |
| 9         | EC-09      | Formación corporativa / in-company, clientes, acuerdos, lotes y reporting empresarial         | B2B / Corporate       |
| 10        | EC-10      | Trayectoria de aprendizaje, progresión, stackable credentials y reconocimiento acumulativo EC | Trayectoria           |
| 11        | EC-11      | Encuestas, NPS, feedback, evaluación docente, impacto y seguimiento posterior                 | Experiencia / impacto |
| 12        | EC-12      | Calidad, analítica de portafolio, indicadores, compliance y mejora continua                   | Calidad / gobierno    |

## 0.3 Decisiones arquitectónicas EC06-DA

| **ID**      | **Decisión normativa**                                                                                                                                      |
|-------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| EC06-DA-001 | SESSION ≠ ATTENDANCE REGISTER ≠ ATTENDANCE FACT. EC-02/CT-03 gobiernan la sesión; EC-06 gobierna observaciones y hecho oficial.                             |
| EC06-DA-002 | ATTENDANCE EVENT ≠ OFFICIAL ATTENDANCE. Eventos son evidencia append-only; el hecho oficial se adjudica por policy y puede ser corregido sin borrar origen. |
| EC06-DA-003 | ATTENDANCE ≠ PARTICIPATION ≠ ENGAGEMENT ≠ COMPLETION. EC-06 no decide aprobación final.                                                                     |
| EC06-DA-004 | ENROLLMENT ≠ ATTENDANCE. Solo un enrollment elegible de EC-04 habilita asistencia; EC-06 no crea matrícula.                                                 |
| EC06-DA-005 | QR TOKEN ≠ IDENTITY. El token demuestra oportunidad de check-in, no identidad plena; assurance se compone según policy.                                     |
| EC06-DA-006 | TELEMETRY ≠ ACADEMIC FACT. Zoom/LMS/device data es señal externa; requiere provenance y reglas de adjudicación.                                             |
| EC06-DA-007 | RAW EVENT = APPEND-ONLY. Nunca se corrige un evento de origen; se agrega adjustment/adjudication.                                                           |
| EC06-DA-008 | OFFLINE CAPTURE ≠ TRUSTED CAPTURE. Offline es permitido con device registration, clock-drift bounds, signed batch y reconciliation.                         |
| EC06-DA-009 | LOCATION ≠ DEFAULT REQUIREMENT. Geolocalización solo se captura si existe purpose/policy explícita y minimización.                                          |
| EC06-DA-010 | BIOMETRIC ≠ DEFAULT ATTENDANCE. Biometría no se implementa en EC-06 salvo contrato transversal y base legal/policy aprobada.                                |
| EC06-DA-011 | CHECK-IN ≠ PRESENT ALL SESSION. La política puede exigir check-out, duración mínima o ventanas múltiples.                                                   |
| EC06-DA-012 | LATE/EARLY_LEAVE son facts derivados de ventanas y policy versionada; no enums de negocio hardcodeados.                                                     |
| EC06-DA-013 | MANUAL CORRECTION ≠ UPDATE FACT. Se crea AttendanceAdjustment con actor, reason, evidence y decisión.                                                       |
| EC06-DA-014 | INSTRUCTOR MARK ≠ UNCHALLENGEABLE TRUTH. Puede requerir confirmación/evidence según riesgo.                                                                 |
| EC06-DA-015 | CORPORATE ROSTER ≠ ATTENDANCE. EC-09/EC-04 nominan; EC-06 observa participación real.                                                                       |
| EC06-DA-016 | ATTENDANCE POLICY = IMMUTABLE POLICY VERSION REF. Recalcular historia con nueva política está prohibido salvo proceso explícito de restatement.             |
| EC06-DA-017 | RESTATEMENT ≠ SILENT RECOMPUTE. Cambiar la política aplicable a historia crea nuevo adjudication version y preserva anterior.                               |
| EC06-DA-018 | SESSION REGISTER SNAPSHOT pins session_ref, edition_ref, cohort_ref y policy refs al abrir el registro.                                                     |
| EC06-DA-019 | PARTICIPANT SESSION FACT usa enrollment_ref/person_ref como EXT REF; no FK cross-context.                                                                   |
| EC06-DA-020 | AGGREGATE REVISION cubre register y facts adjudicados; ETag/If-Match evita overwrites concurrentes.                                                         |
| EC06-DA-021 | RLS ENABLE+FORCE es defensa obligatoria; runtime role sin BYPASSRLS.                                                                                        |
| EC06-DA-022 | CHECK-IN TOKEN usa hash, nonce, TTL, scope y replay guard; el valor crudo no se persiste.                                                                   |
| EC06-DA-023 | EXTERNAL EFFECT UNKNOWN exige UNKNOWN_EFFECT + receipt + reconcile-before-retry.                                                                            |
| EC06-DA-024 | DUPLICATE EVENTS se deduplican por source_event_id/idempotency key sin perder provenance.                                                                   |
| EC06-DA-025 | ENGAGEMENT SCORE ≠ GRADE. Puede orientar analítica/alerta; nunca modifica nota o completion automáticamente.                                                |
| EC06-DA-026 | AI RECOMMENDATION ≠ ATTENDANCE DECISION. CT-12 puede detectar anomalías; humano/policy decide correcciones sensibles.                                       |
| EC06-DA-027 | EVIDENCE BLOB vive en CT-05. EC-06 guarda document_ref/hash/metadata mínima.                                                                                |
| EC06-DA-028 | ATTENDANCE EXPORT ≠ SOURCE OF TRUTH. Reportes/exportaciones son derivados de facts versionados.                                                             |
| EC06-DA-029 | NO_DATA ≠ ZERO ≠ UNAVAILABLE ≠ PARTIAL ≠ STALE ≠ UNKNOWN_EFFECT en toda UI dependiente de integraciones.                                                    |
| EC06-DA-030 | TIME WINDOW usa timestamptz UTC + timezone de sesión; nunca hora local ambigua.                                                                             |
| EC06-DA-031 | SOURCE PRIORITY es policy versionada: instructor, QR, access-control, LMS, videoconference, imported evidence.                                              |
| EC06-DA-032 | DISPUTE/APPEAL se gestiona por CT-06 y adjustment; no edición directa del historial.                                                                        |
| EC06-DA-033 | PUBLISH/LOCK SESSION FACTS no significa cierre académico EC-07; solo estabiliza evidencia de sesión.                                                        |
| EC06-DA-034 | OpenAPI/AsyncAPI son contratos ejecutables y compatibility gates, no documentación decorativa.                                                              |

## 0.4 Criterio de suficiencia FullStack y regla de plantilla

EC-06 se considera suficiente cuando dos equipos Senior independientes pueden implementar el mismo comportamiento observable para captura online/offline, adjudicación, corrección, reconciliación y consulta de asistencia sin definir por su cuenta seguridad, estados, idempotencia, consistencia temporal o contratos de integración.

| **REGLA DE PLANTILLA — Se heredan de EC-01 V1.1 y módulos previos: RLS defense-in-depth, Aggregate Revision Contract, ETag/If-Match, state guards, idempotencia durable, leased outbox, OperationStatus, ProblemDetail, Secure SDLC, expand/contract N/N-1, bootstrap reproducible y QA visual.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 1. Índice operativo del documento

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal de reglas BR-EC06

- 10\. Casos de uso UC-EC06

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

En Educación Continua la asistencia no puede reducirse a una casilla presente/ausente. Una misma universidad puede ejecutar talleres de dos horas, bootcamps de ocho semanas, webinars masivos, programas híbridos, formación in-company y actividades asíncronas. Cada modalidad genera señales diferentes y diferentes niveles de confianza. EC-06 normaliza estas señales bajo un ledger de evidencia y una capa de adjudicación reproducible.

El diseño protege simultáneamente flexibilidad operativa y auditabilidad. Los eventos de origen se conservan append-only; el estado oficial se deriva con policy versionada; las correcciones crean nuevos hechos y lineage; y toda integración externa conserva receipts suficientes para demostrar qué se recibió y cuándo.

## 2.1 Incluido

- Apertura/cierre de AttendanceRegister por sesión y edición.

- Roster snapshot de participantes elegibles mediante refs a EC-04.

- Check-in/check-out manual, QR, móvil, kiosk y fuentes externas.

- Tokens QR dinámicos con TTL, hash, nonce y anti-replay.

- Captura offline firmada y sincronización gobernada.

- AttendanceEvent append-only y deduplicación por source_event_id.

- Adjudicación de ParticipantSessionAttendance.

- Clasificación present/absent/late/early_leave/excused/unknown según policy.

- Cálculo de attended_minutes y attendance_ratio.

- ParticipationEvidence y EngagementObservation no calificativa.

- Correcciones, appeals, adjustment workflow y restatement.

- Integración CT-18 con LMS/Zoom/Teams/Meet y access-control aprobado.

- Reconciliation de eventos externos y UNKNOWN_EFFECT.

- Dashboards operativos y Participant/Instructor mobile journeys.

- APIs, eventos, seguridad, observabilidad, QA, UAT y migración.

## 2.2 Fuera de alcance

- Crear/editar ProgramEdition, Offering, Session o horario — EC-02/CT-03/CT-13.

- Crear personas o enrollment — CT-04/EC-04.

- Asignar docentes — EC-05.

- Definir notas, rubricas o evaluación académica — EC-07.

- Decidir completion o aprobación final — EC-07.

- Emitir certificados — EC-08.

- Facturar o cobrar ausencias — Finanzas/EC-03 cuando exista regla comercial.

- Guardar video, foto, firma o PDF binario — CT-05.

- Conectar directamente a Zoom/Moodle/Teams — CT-18.

- Usar biometría/geolocalización como requisito por defecto.

| **ANTI-SCOPE — EC-06 no es un “sistema de control biométrico”, un LMS, un calendario ni un motor de completion. Es el bounded context que convierte evidencia de participación en hechos de asistencia explicables y versionados.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Término**                  | **Definición normativa**                                                                          |
|------------------------------|---------------------------------------------------------------------------------------------------|
| AttendanceRegister           | Aggregate operativo abierto para una sesión/segmento; pinnea sesión, edición, cohort y políticas. |
| RegisterRosterEntry          | Snapshot de elegibilidad de un enrollment/person para esa sesión; no duplica la persona.          |
| AttendanceEvent              | Observación append-only originada por check-in/out, instructor, kiosk o sistema externo.          |
| SourceEventId                | Identificador externo/cliente usado para deduplicación y provenance.                              |
| CheckInToken                 | Challenge efímero scoped a register/session con TTL; se persiste solo hash/metadata.              |
| CheckInAttempt               | Intento de consumo de token; puede ser accepted/rejected/replayed.                                |
| ParticipantSessionAttendance | Hecho oficial adjudicado para un participante y sesión.                                           |
| AttendanceStatus             | Resultado categórico derivado por policy; no hardcodea thresholds.                                |
| AttendedMinutes              | Duración reconocida después de normalización de intervalos válidos.                               |
| AttendanceRatio              | attended_minutes / eligible_minutes según policy/sesión.                                          |
| ParticipationEvidence        | Referencia a evidencia adicional que soporta participación sin ser el blob.                       |
| EngagementObservation        | Señal de participación/actividad; no es calificación ni completion.                               |
| AdjustmentRequest            | Solicitud de corregir un hecho oficial con reason/evidence/workflow.                              |
| AttendanceAdjudication       | Versión de cálculo/decisión que transforma eventos en fact oficial.                               |
| Restatement                  | Nueva adjudicación histórica gobernada; preserva la anterior.                                     |
| ExternalTelemetryReceipt     | Receipt durable de lote/evento externo recibido vía CT-18.                                        |
| OfflineCaptureBatch          | Lote firmado por dispositivo para sincronización posterior.                                       |
| DeviceRegistrationRef        | EXT REF a dispositivo/credencial técnica autorizada.                                              |
| ClockDrift                   | Diferencia medida entre reloj cliente y servidor; sobre límite, evento requiere review.           |
| ReconciliationCase           | Caso para resolver discrepancias, missing events o UNKNOWN_EFFECT.                                |
| EvidenceRef                  | Referencia CT-05 a documento/artefacto; no blob local.                                            |
| PolicySnapshot               | Versiones inmutables de policies usadas para adjudicar.                                           |
| OfficialFactVersion          | Versión monotónica del hecho oficial después de correcciones/restatements.                        |
| UNKNOWN_EFFECT               | No puede saberse si un sistema remoto aplicó un efecto; se reconcilia antes de retry.             |

# 4. Bounded Context y matriz Source of Truth

EC-06 posee el hecho oficial de asistencia/participación por sesión y sus evidencias operativas. Cuando consume datos de otro bounded context, persiste solo EXT REF y snapshots mínimos permitidos. No crea FK cross-context.

| **Información**             | **Source of Truth** | **EC-06 almacena**              | **EC-06 referencia**            | **Regla**                  |
|-----------------------------|---------------------|---------------------------------|---------------------------------|----------------------------|
| Tenant/scope                | CT-01               | tenant_id + scope refs          | tenant/scope contract           | RLS + auth context.        |
| Policies/catálogos          | CT-02               | policy_snapshot/version refs    | attendance/engagement policy    | No thresholds hardcoded.   |
| Sesión/calendario           | EC-02 + CT-03       | session_ref snapshot mínimo     | session/window/timezone refs    | EC-06 no reprograma.       |
| Persona                     | CT-04               | No                              | person_ref                      | No shadow Person.          |
| Evidencia binaria           | CT-05               | document_ref/hash               | evidence refs                   | No blobs.                  |
| Workflow/appeals            | CT-06               | adjustment status/ref           | workflow_ref                    | Domain invariants local.   |
| Notificaciones              | CT-07               | No                              | request/receipt ref             | Post-commit.               |
| i18n                        | CT-08               | keys/codes                      | translations                    | No duplication.            |
| Integraciones               | CT-09               | outbox/inbox                    | contract refs                   | At-least-once + dedup.     |
| Audit/privacy               | CT-10               | business audit metadata         | evidence/audit refs             | PII mínima.                |
| BI                          | CT-11               | facts/events                    | dataset refs                    | No shadow warehouse.       |
| IA                          | CT-12               | ai_run_ref                      | anomaly recommendation          | Recommendation ≠ decision. |
| Scheduling                  | CT-13               | No                              | schedule refs                   | Read-only dependency.      |
| Recursos                    | CT-14               | No                              | room/resource refs              | No reservation local.      |
| Elegibilidad                | CT-15               | snapshot de resultado si aplica | eligibility refs                | No motor local.            |
| Migración/DQ                | CT-16               | migration receipts              | lineage refs                    | Promote por domain/API.    |
| Continuidad                 | CT-17               | No                              | runbook refs                    | Offline/degraded governed. |
| LMS/ecosistema              | CT-18               | telemetry receipts              | external source refs            | No vendor client directo.  |
| Enrollment                  | EC-04               | roster/enrollment_ref           | enrollment contract             | Attendance no matricula.   |
| Teaching assignment         | EC-05               | instructor_ref mínimo           | assignment contract             | No RRHH local.             |
| Attendance facts            | EC-06               | Sí                              | —                               | Source of Truth local.     |
| Completion/grade            | EC-07               | No                              | attendance fact refs downstream | EC-06 no aprueba.          |
| Corporate participant batch | EC-09               | No                              | batch refs                      | Empresa ≠ participante.    |

# 5. Dependencias CT-01 a CT-18, cores y otros módulos

| **Dependencia** | **Responsabilidad**    | **Contrato EC-06**                                            | **Frontera/fallo**                    |
|-----------------|------------------------|---------------------------------------------------------------|---------------------------------------|
| CT-01           | Scope institucional    | tenant/scope validation                                       | Fail closed en mutaciones críticas.   |
| CT-02           | Policies               | attendance window, tolerance, source priority, evidence rules | Cache versionado; pin policy version. |
| CT-03           | Temporalidad           | session planned timestamps/timezone                           | No crea calendario.                   |
| CT-04           | Persona                | person_ref                                                    | No PII duplicada.                     |
| CT-05           | Evidence               | document_ref/hash                                             | No blob.                              |
| CT-06           | Workflow               | adjustment/appeal                                             | Aprobaciones sensibles.               |
| CT-07           | Notifications          | absence/adjustment notifications                              | No rollback académico por fallo.      |
| CT-08           | i18n                   | labels/reasons                                                | Locale overlays.                      |
| CT-09           | Integration governance | events/contracts                                              | Outbox/inbox.                         |
| CT-10           | Audit/privacy          | critical action audit                                         | Purpose + retention.                  |
| CT-11           | Analytics              | attendance facts                                              | Event-fed.                            |
| CT-12           | AI                     | anomaly detection                                             | Human review.                         |
| CT-13           | Scheduling             | read-only schedule refs                                       | No solver local.                      |
| CT-14           | Resources              | room/access context                                           | No booking.                           |
| CT-15           | Eligibility            | optional attendance eligibility prechecks                     | No engine local.                      |
| CT-16           | Migration              | legacy attendance staging/promotion                           | No direct INSERT.                     |
| CT-17           | Continuity             | offline/BCP runbooks                                          | RTO/RPO.                              |
| CT-18           | External LMS/video     | telemetry via adapters                                        | UNKNOWN_EFFECT + receipts.            |
| EC-02           | Edition/session        | pins edition/session                                          | EC-02 owns schedule.                  |
| EC-04           | Enrollment             | enrollment/person refs                                        | Only eligible participants.           |
| EC-05           | Instructor assignment  | authorized instructor refs                                    | No assignment local.                  |
| EC-07           | Completion             | consumes official facts                                       | Never infer grade here.               |
| EC-09           | Corporate              | batch/client refs                                             | Reports respect privacy.              |

# 6. Arquitectura funcional E2E y journeys

El flujo central separa captura de señal, evidencia, adjudicación y consumo downstream. La arquitectura evita que una fuente externa o un gesto de UI escriba directamente un hecho académico oficial.

<img src="media/image1.png" style="width:6.7in;height:3.88255in" />

Figura 1 — EC-06 dentro de la vertical y capacidades transversales.

| **Journey** | **Nombre**        | **Flujo E2E**                                                                                         |
|-------------|-------------------|-------------------------------------------------------------------------------------------------------|
| J-EC06-01   | Lista instructor  | Abrir register → cargar roster EC-04 → instructor marca presencia → adjudicar → publicar facts.       |
| J-EC06-02   | QR dinámico       | Crear token TTL → participante escanea → validar enrollment/device/window → append event → adjudicar. |
| J-EC06-03   | Check-in/out      | Registrar entrada y salida → normalizar intervalos → calcular minutos válidos → status por policy.    |
| J-EC06-04   | Offline           | Device autorizado captura lote firmado → sync → drift/replay validation → ingest events → reconcile.  |
| J-EC06-05   | Videoconferencia  | CT-18 entrega receipt/eventos → dedup → normalize → source quality → adjudication.                    |
| J-EC06-06   | Asíncrono         | LMS activity evidence → participación por activity window → no confundir click con completion.        |
| J-EC06-07   | Corrección        | Participante/instructor solicita adjustment → CT-06 → decision → new fact version + lineage.          |
| J-EC06-08   | Discrepancia      | Instructor=PRESENT, external=0 min → anomaly → review → explicit adjudication.                        |
| J-EC06-09   | Dependencia caída | CT-18 unavailable → UI UNAVAILABLE/STALE; register manual continúa según policy.                      |
| J-EC06-10   | Consumo EC-07     | EC-07 consulta hechos official/locked con policy snapshot y provenance; no raw events.                |

# 7. Modelo de dominio: Aggregates, Entities, Value Objects, Policies y Domain Services

## 7.1 Aggregate Root — AttendanceRegister

AttendanceRegister representa la ventana operacional de captura para una sesión/segmento. Pinnea session_ref, edition_ref, cohort_ref, timezone, planned window y attendance_policy_ref. Su lifecycle controla cuándo se aceptan eventos normales y cuándo solo ajustes gobernados.

## 7.2 Aggregate — ParticipantSessionAttendance

Es el hecho oficial por participante y sesión. No se edita como fila plana: cada adjudicación genera una versión con status, minutos, ratio, source summary, policy snapshot y lineage. El registro puede conservar un puntero a la versión vigente para lectura eficiente.

## 7.3 Aggregate — OfflineCaptureBatch

Agrupa eventos capturados sin conectividad bajo un dispositivo registrado. Conserva device_ref, signed payload hash, client/server times, drift y sync status. Un lote aceptado no se muta; los errores posteriores generan reconciliation.

## 7.4 Aggregate — AttendanceAdjustment

Modela la solicitud y resolución de correcciones. La decisión nunca reescribe eventos raw; crea una nueva adjudicación/fact version, reason_code y evidencia. CT-06 puede orquestar aprobación y SoD.

## 7.5 Value Objects

| **Value Object**   | **Semántica**                                                 |
|--------------------|---------------------------------------------------------------|
| AttendanceWindow   | planned_start/end + tolerances + timezone + policy version.   |
| CheckInChallenge   | nonce + issued_at + expires_at + register scope.              |
| AttendanceInterval | start/end/source/quality; normalizado sin overlap.            |
| AttendanceRatio    | valor 0..1 + numerator/denominator y rounding policy.         |
| SourceProvenance   | source_kind, source_system_ref, source_event_id, received_at. |
| DeviceEvidence     | device_ref, attestation_ref, app_version, signature metadata. |
| PolicyRef          | referencia inmutable a PolicyVersion CT-02.                   |
| ExternalRef        | opaque ID + authority; sin FK cross-context.                  |
| ReasonCode         | código gobernado para correction/rejection/reconciliation.    |
| FactLineage        | previous_fact_version_id + cause + actor + evidence refs.     |

## 7.6 Domain Policies

- AttendanceWindowPolicy — ventanas de check-in/out y tolerancias.

- SourceTrustPolicy — peso/precedencia de cada fuente y assurance requerido.

- AttendanceAdjudicationPolicy — traduce intervalos/evidencia a status/minutos/ratio.

- LateEarlyPolicy — clasifica retraso/salida temprana.

- OfflineCapturePolicy — TTL, drift, device assurance y límites por lote.

- AdjustmentPolicy — quién puede solicitar/aprobar y qué evidencia exige.

- EngagementPolicy — interpreta actividad sin transformarla en grade.

- PrivacyCapturePolicy — geolocation/device metadata/retention permitidos.

- RegisterClosurePolicy — reglas para lock/finalize de facts por sesión.

## 7.7 Domain Services

- AttendanceAdjudicationService — normaliza eventos e intervalos y produce fact candidate.

- IntervalNormalizationService — merge, overlap, clipping y timezone normalization.

- SourceReconciliationService — compara instructor/QR/external evidence.

- TokenService — emite/verifica challenge sin persistir token crudo.

- OfflineBatchVerificationService — firma, drift, replay, device status.

- AttendanceRestatementService — recalcula bajo policy explícita preservando lineage.

- EngagementNormalizationService — normaliza señales heterogéneas a observaciones no calificativas.

## 7.8 Aggregate Revision Contract

Toda mutación que altere register configuration o el hecho official vigente exige If-Match del aggregate root correspondiente. Raw AttendanceEvent es append-only y no usa update optimista; su control es idempotencia/dedup. Ajustes crean nuevas versiones de fact y actualizan el root bajo lock.

| **Paso** | **Contrato**                                                    |
|----------|-----------------------------------------------------------------|
| 1        | Resolver tenant desde SecurityContext y SET LOCAL tenant.       |
| 2        | Cargar root/lock y comparar ETag esperado.                      |
| 3        | Ejecutar command de intención; nunca repository update directo. |
| 4        | Persistir eventos/fact/lineage en transacción.                  |
| 5        | Bump aggregate version, audit, outbox e idempotency.            |
| 6        | Responder ETag nuevo o 412 sin efecto parcial.                  |

# 8. Máquinas de estado normativas

| **Aggregate**          | **Estados/transiciones**                                                   | **Invariante**                                                          |
|------------------------|----------------------------------------------------------------------------|-------------------------------------------------------------------------|
| AttendanceRegister     | DRAFT → OPEN → CLOSING → LOCKED; CANCELLED                                 | LOCKED no acepta captura normal; solo adjustment/restatement gobernado. |
| CheckInToken           | ISSUED → CONSUMED/EXPIRED/REVOKED                                          | Token one-time cuando policy lo define; TTL obligatorio.                |
| OfflineCaptureBatch    | CREATED → UPLOADING → RECEIVED → VALIDATED → APPLIED/REJECTED; RECONCILING | APPLIED immutable.                                                      |
| AttendanceAdjustment   | DRAFT → SUBMITTED → UNDER_REVIEW → APPROVED/REJECTED → APPLIED/CANCELLED   | APPLIED crea fact version; no update raw.                               |
| ReconciliationCase     | OPEN → INVESTIGATING → RESOLVED/ESCALATED                                  | UNKNOWN_EFFECT no se borra.                                             |
| OfficialAttendanceFact | PROVISIONAL → OFFICIAL → RESTATED/VOID                                     | Versioned append-style history.                                         |
| EngagementObservation  | RECEIVED → NORMALIZED → ACCEPTED/REJECTED                                  | No grade/completion.                                                    |

| **REGLA DE ESTADO — Nunca implementar “attendance_status = PRESENT” como PATCH genérico. La oficialización es un caso de uso con policy snapshot, provenance, evidence, idempotencia, audit y outbox.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 9. Catálogo formal de reglas BR-EC06

| **ID**      | **Nombre**                               | **Regla implementable/verificable**                                                                               |
|-------------|------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| BR-EC06-001 | Tenant obligatorio                       | Toda tabla tenant-owned usa tenant_id del contexto autorizado; RLS ENABLE+FORCE.                                  |
| BR-EC06-002 | Session pinneada                         | AttendanceRegister debe referenciar una session_ref/edition_ref coherente obtenida por contrato.                  |
| BR-EC06-003 | Roster elegible                          | Solo enrollment_ref elegible puede ingresar al roster salvo override gobernado.                                   |
| BR-EC06-004 | Evento append-only                       | AttendanceEvent no admite UPDATE/DELETE por runtime.                                                              |
| BR-EC06-005 | Evento idempotente                       | source_event_id es único por tenant/source authority cuando existe.                                               |
| BR-EC06-006 | Token no persistido                      | El QR/token crudo no se guarda; solo hash/nonce/metadata.                                                         |
| BR-EC06-007 | Token expira                             | expires_at \> issued_at y consumo fuera de TTL se rechaza.                                                        |
| BR-EC06-008 | Replay bloqueado                         | Challenge one-time no puede consumirse dos veces.                                                                 |
| BR-EC06-009 | Window policy                            | Check-in/out debe evaluarse contra policy versionada y session window.                                            |
| BR-EC06-010 | UTC                                      | Todos los instantes oficiales son timestamptz UTC; timezone se conserva para interpretación.                      |
| BR-EC06-011 | Check-out opcional                       | Si policy no exige check-out, attended_minutes puede derivarse por regla explícita; nunca asumir arbitrariamente. |
| BR-EC06-012 | Ratio acotado                            | attendance_ratio debe quedar entre 0 y 1.                                                                         |
| BR-EC06-013 | Minutos no negativos                     | attended_minutes \>= 0 y no excede eligible_minutes salvo reason explícito de normalization.                      |
| BR-EC06-014 | Status gobernado                         | Códigos de attendance status provienen de CT-02/policy.                                                           |
| BR-EC06-015 | Late no equivale absent                  | LATE puede coexistir con participación reconocida según policy.                                                   |
| BR-EC06-016 | Excused no equivale present              | EXCUSED conserva semántica distinta; EC-07 decide impacto por policy.                                             |
| BR-EC06-017 | Unknown explícito                        | Ausencia de evidencia suficiente produce UNKNOWN/PENDING_REVIEW, no ABSENT automático.                            |
| BR-EC06-018 | Telemetría no manda sola                 | External telemetry requiere normalization/adjudication antes de official fact.                                    |
| BR-EC06-019 | Source priority versionada               | Conflictos entre fuentes usan policy versionada y evidence.                                                       |
| BR-EC06-020 | Instructor mark auditable                | Marca manual conserva instructor_ref, timestamp y reason si override.                                             |
| BR-EC06-021 | Geolocation minimizada                   | Solo capturar ubicación si policy/purpose autorizan; no default.                                                  |
| BR-EC06-022 | Device metadata minimizada               | Persistir solo metadata necesaria para seguridad/reconciliation.                                                  |
| BR-EC06-023 | Biometría fuera por defecto              | No almacenar templates biométricos en EC-06.                                                                      |
| BR-EC06-024 | Offline device autorizado                | Batch offline requiere device_registration_ref vigente.                                                           |
| BR-EC06-025 | Offline batch firmado                    | Hash/firma y payload count deben verificarse antes de aplicar.                                                    |
| BR-EC06-026 | Clock drift acotado                      | Drift sobre threshold crea review/rejection según policy.                                                         |
| BR-EC06-027 | Batch immutable                          | Un batch APPLIED no se modifica ni reaplica.                                                                      |
| BR-EC06-028 | Dedup multi-source                       | La dedup no colapsa eventos distintos de fuentes distintas sin regla explícita.                                   |
| BR-EC06-029 | Intervals normalizados                   | Solapamientos se mergean/clipean determinísticamente.                                                             |
| BR-EC06-030 | Break rules versionadas                  | Pausas no computables se resuelven por policy, no hardcode.                                                       |
| BR-EC06-031 | Fact versionado                          | Toda corrección crea nueva official_fact_version.                                                                 |
| BR-EC06-032 | Lineage obligatorio                      | Fact restated apunta a previous_fact_version y reason.                                                            |
| BR-EC06-033 | Solo una fact vigente                    | Única official_current por participant/register, físicamente protegida.                                           |
| BR-EC06-034 | Adjustment no muta raw                   | Aprobación de correction crea fact; raw events quedan intactos.                                                   |
| BR-EC06-035 | SoD en ajustes sensibles                 | Solicitante no puede ser único aprobador cuando policy lo exige.                                                  |
| BR-EC06-036 | Step-up                                  | Ajustes masivos, restatement y void requieren assurance reforzado.                                                |
| BR-EC06-037 | Evidence ref CT-05                       | No blobs locales; document_ref/hash.                                                                              |
| BR-EC06-038 | Register lock                            | LOCKED bloquea captura ordinaria.                                                                                 |
| BR-EC06-039 | Lock no borra pendientes                 | Cerrar register exige resolver o declarar pendientes según policy.                                                |
| BR-EC06-040 | Restatement explícito                    | Nueva policy no reescribe historia automáticamente.                                                               |
| BR-EC06-041 | Policy snapshot                          | Official fact guarda policy version/snapshot utilizado.                                                           |
| BR-EC06-042 | Enrollment history                       | Retiro posterior de enrollment no borra asistencia histórica válida.                                              |
| BR-EC06-043 | Person privacy                           | EC-06 no almacena nombre/email del participante salvo snapshot autorizado y justificado.                          |
| BR-EC06-044 | External receipt                         | Cada lote CT-18 conserva receipt, schema version, source, received_at y payload hash.                             |
| BR-EC06-045 | UNKNOWN_EFFECT                           | Timeout con posible efecto remoto exige reconcile-before-retry.                                                   |
| BR-EC06-046 | Outbox atómica                           | Officialize/restatement/lock persiste outbox en la misma transacción.                                             |
| BR-EC06-047 | Inbox dedup                              | Mensajes externos deduplicados por message_id.                                                                    |
| BR-EC06-048 | At-least-once                            | No se promete exactly-once distribuido.                                                                           |
| BR-EC06-049 | Idempotency key                          | Comandos sensibles exigen Idempotency-Key durable.                                                                |
| BR-EC06-050 | Key payload binding                      | Same key/different payload =\> 409 IDEMPOTENCY_KEY_REUSED.                                                        |
| BR-EC06-051 | Lease recovery                           | IN_PROGRESS idempotency tiene lease y recovery.                                                                   |
| BR-EC06-052 | Aggregate ETag                           | Mutaciones root requieren If-Match; mismatch =\> 412.                                                             |
| BR-EC06-053 | No last-write-wins                       | Conflictos no se silencian.                                                                                       |
| BR-EC06-054 | RLS obligatorio                          | Runtime role no BYPASSRLS y no owner de tablas.                                                                   |
| BR-EC06-055 | Cross-context sin FK                     | person/enrollment/session refs no tienen FK físicas.                                                              |
| BR-EC06-056 | ProblemDetail                            | Errores usan RFC Problem Details + reason codes estables.                                                         |
| BR-EC06-057 | UI states                                | NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT diferenciados.                                              |
| BR-EC06-058 | Paginación bounded                       | Colecciones tienen pageSize máximo y sort estable.                                                                |
| BR-EC06-059 | 202 OperationStatus                      | Operación async responde operationId consultable.                                                                 |
| BR-EC06-060 | Engagement no grade                      | Engagement score no altera evaluación.                                                                            |
| BR-EC06-061 | AI no decide                             | AI anomaly detection no cambia fact oficial sola.                                                                 |
| BR-EC06-062 | AI provenance                            | Guardar run_ref/model/template/eval/grounding/confidence/reviewer outcome.                                        |
| BR-EC06-063 | Mass correction bounded                  | Ajustes masivos requieren dry-run, limit y approval.                                                              |
| BR-EC06-064 | Export minimizado                        | Reportes corporativos respetan scope/purpose y minimización.                                                      |
| BR-EC06-065 | Retention policy                         | Raw events/device metadata/evidence refs siguen retention class versionada.                                       |
| BR-EC06-066 | Legal hold                               | Purge no destruye registros bajo legal hold.                                                                      |
| BR-EC06-067 | Hash canonical                           | Receipts/evidence usan canonical schema version + hash algorithm.                                                 |
| BR-EC06-068 | Append-only receipt                      | Publication/reconciliation/evidence receipt no UPDATE/DELETE.                                                     |
| BR-EC06-069 | Schema compatibility                     | AsyncAPI/OpenAPI mantienen compatibility gate.                                                                    |
| BR-EC06-070 | Expand/contract                          | Flyway productivo mantiene N/N-1.                                                                                 |
| BR-EC06-071 | Secure SDLC                              | High/Critical findings bloquean release salvo excepción formal.                                                   |
| BR-EC06-072 | Capacity budgets                         | Máximo de eventos por session/batch y payload se parametriza.                                                     |
| BR-EC06-073 | Rate limit                               | Check-in endpoints expuestos aplican rate limiting y abuse controls.                                              |
| BR-EC06-074 | Anti-enumeration                         | QR/session endpoints no revelan roster o PII a actor no autorizado.                                               |
| BR-EC06-075 | Token scope                              | Challenge está ligado a tenant/register/session y opcionalmente participant/device.                               |
| BR-EC06-076 | Clock authority                          | Server time es autoridad; client time es evidencia.                                                               |
| BR-EC06-077 | DST safe                                 | Interpretación usa timezone IANA, nunca offset fijo como única semántica.                                         |
| BR-EC06-078 | Manual present reason                    | Override fuera de window exige reason/evidence según policy.                                                      |
| BR-EC06-079 | Duplicate roster                         | Un enrollment aparece una sola vez por register.                                                                  |
| BR-EC06-080 | Participant transfer                     | Transferencias EC-04 no copian asistencia automáticamente entre ediciones.                                        |
| BR-EC06-081 | Session cancellation                     | Sesión cancelada no genera ABSENT; register se cancela/void según policy.                                         |
| BR-EC06-082 | Reschedule                               | Reprogramación crea nueva referencia temporal; facts de sesión vieja preservan historia.                          |
| BR-EC06-083 | Instructor replacement                   | Cambio de instructor no altera marcas históricas ya auditadas.                                                    |
| BR-EC06-084 | Provider outage                          | CT-18 outage no se interpreta como cero asistencia.                                                               |
| BR-EC06-085 | Partial telemetry                        | Lote parcial marca PARTIAL y no finaliza automáticamente.                                                         |
| BR-EC06-086 | Reconciliation outcome                   | Resolución conserva before/after y actor/reason.                                                                  |
| BR-EC06-087 | Officialize requires no critical unknown | No se LOCKEA como final si quedan UNKNOWN críticos salvo waiver gobernado.                                        |
| BR-EC06-088 | Downstream pin                           | EC-07 consume fact_version/id o asOf explícito, no latest mutable sin contrato.                                   |
| BR-EC06-089 | Analytics provenance                     | CT-11 recibe fact official + version + policy refs.                                                               |
| BR-EC06-090 | No destructive delete                    | Official facts, adjustments y raw events no hard-delete por API ordinaria.                                        |
| BR-EC06-091 | Void explicit                            | VOID requiere reason, assurance y lineage.                                                                        |
| BR-EC06-092 | Migration governed                       | Legacy entra por CT-16 y domain APIs.                                                                             |
| BR-EC06-093 | Legacy source preserved                  | source_system/source_key/lineage obligatorios en migración.                                                       |
| BR-EC06-094 | Test tenant isolation                    | QA debe demostrar cross-tenant read/write denial a nivel DB.                                                      |
| BR-EC06-095 | Test replay                              | QA debe demostrar QR replay blocked.                                                                              |
| BR-EC06-096 | Test offline duplication                 | Retry de batch offline no duplica events.                                                                         |
| BR-EC06-097 | Test concurrent marks                    | Dos operadores marcando mismo participante no producen facts incoherentes.                                        |
| BR-EC06-098 | Test restatement                         | Restatement preserva fact anterior y cambia current pointer atómicamente.                                         |
| BR-EC06-099 | Test RTO                                 | Degraded/offline runbook probado.                                                                                 |
| BR-EC06-100 | Audit critical                           | Open/lock/adjust/void/restatement/export registran actor, scope, reason, correlation, policy, evidence refs.      |
| BR-EC06-101 | Correlation                              | Toda ingestión externa y command crítico conserva correlationId/causationId.                                      |
| BR-EC06-102 | Source quality                           | quality/confidence de fuente no se confunde con AI confidence.                                                    |
| BR-EC06-103 | Roster snapshot                          | Roster entry conserva refs y eligibility snapshot mínimo para reconstructibilidad.                                |
| BR-EC06-104 | No attendance from prospect              | Prospect sin enrollment elegible no produce official attendance.                                                  |
| BR-EC06-105 | Anonymous event                          | Eventos anónimos pueden existir como telemetry no adjudicada; nunca official fact sin subject resolution.         |
| BR-EC06-106 | Kiosk security                           | Kiosk debe usar technical principal scoped y rotated credentials.                                                 |
| BR-EC06-107 | Admin bypass forbidden                   | UI admin no puede saltar policy usando endpoint genérico.                                                         |
| BR-EC06-108 | Reason codes governed                    | reason_code no free text como único fundamento.                                                                   |
| BR-EC06-109 | Free text sanitized                      | Notas libres se sanitizan y tienen límites.                                                                       |
| BR-EC06-110 | Evidence access                          | Permisos para ver evidencia pueden ser más restrictivos que ver attendance status.                                |
| BR-EC06-111 | Corporate privacy                        | Cliente corporativo recibe agregados o detalle solo según purpose/contrato autorizado.                            |
| BR-EC06-112 | Accessibility                            | Check-in y asistencia deben tener alternativa accesible al QR.                                                    |
| BR-EC06-113 | No smartphone assumption                 | No exigir smartphone como única vía salvo política institucional con alternativa.                                 |
| BR-EC06-114 | Offline queue bounded                    | Mobile offline queue tiene límite, TTL y cifrado local.                                                           |
| BR-EC06-115 | Local data protection                    | Mobile no conserva PII/evidence más allá de lo necesario.                                                         |
| BR-EC06-116 | Background sync explicit                 | Sync fallido muestra estado pendiente; no finge confirmación.                                                     |
| BR-EC06-117 | Push not source of truth                 | Notificación de ausencia no es hecho académico.                                                                   |
| BR-EC06-118 | Notification post-commit                 | Fallo CT-07 no revierte official fact.                                                                            |
| BR-EC06-119 | Reasonable consistency                   | Read models pueden ser STALE; command path usa Source of Truth.                                                   |
| BR-EC06-120 | No Redis authority                       | Redis solo cache/lock técnico; nunca attendance fact autoritativo.                                                |
| BR-EC06-121 | Mongo derived only                       | Mongo solo read model/document derived cuando aplique.                                                            |
| BR-EC06-122 | Audit immutability                       | Evidence pack y audit refs siguen CT-10/CT-05 y no se alteran silenciosamente.                                    |
| BR-EC06-123 | Release gate                             | No producción sin G1-G10 evidence pack.                                                                           |

# 10. Casos de uso UC-EC06

| **ID**      | **Caso de uso**                                   | **Actor primario**  |
|-------------|---------------------------------------------------|---------------------|
| UC-EC06-001 | Crear AttendanceRegister                          | Attendance Operator |
| UC-EC06-002 | Abrir AttendanceRegister                          | Instructor          |
| UC-EC06-003 | Cargar/actualizar roster desde EC-04              | Participant Mobile  |
| UC-EC06-004 | Cancelar register por sesión cancelada            | Coordinator         |
| UC-EC06-005 | Emitir challenge QR                               | System Worker       |
| UC-EC06-006 | Revocar challenge QR                              | Data Steward        |
| UC-EC06-007 | Registrar check-in QR                             | Auditor             |
| UC-EC06-008 | Registrar check-out QR                            | Security/QA         |
| UC-EC06-009 | Registrar presencia manual                        | Ops                 |
| UC-EC06-010 | Registrar ausencia manual                         | Attendance Operator |
| UC-EC06-011 | Registrar late/early leave manual                 | Instructor          |
| UC-EC06-012 | Registrar evento kiosk                            | Participant Mobile  |
| UC-EC06-013 | Registrar evento access-control                   | Coordinator         |
| UC-EC06-014 | Recibir evento LMS                                | System Worker       |
| UC-EC06-015 | Recibir evento videoconferencia                   | Data Steward        |
| UC-EC06-016 | Recibir engagement async                          | Auditor             |
| UC-EC06-017 | Crear offline capture batch                       | Security/QA         |
| UC-EC06-018 | Sincronizar offline batch                         | Ops                 |
| UC-EC06-019 | Validar firma/drift/replay                        | Attendance Operator |
| UC-EC06-020 | Aplicar offline batch                             | Instructor          |
| UC-EC06-021 | Consultar register operativo                      | Participant Mobile  |
| UC-EC06-022 | Consultar participant attendance                  | Coordinator         |
| UC-EC06-023 | Adjudicar attendance fact                         | System Worker       |
| UC-EC06-024 | Re-adjudicar por nuevos eventos                   | Data Steward        |
| UC-EC06-025 | Lock de register                                  | Auditor             |
| UC-EC06-026 | Solicitar ajuste                                  | Security/QA         |
| UC-EC06-027 | Aprobar/rechazar ajuste                           | Ops                 |
| UC-EC06-028 | Aplicar ajuste                                    | Attendance Operator |
| UC-EC06-029 | Void fact                                         | Instructor          |
| UC-EC06-030 | Restatement por policy                            | Participant Mobile  |
| UC-EC06-031 | Crear reconciliation case                         | Coordinator         |
| UC-EC06-032 | Resolver discrepancia de fuentes                  | System Worker       |
| UC-EC06-033 | Reconciliar UNKNOWN_EFFECT                        | Data Steward        |
| UC-EC06-034 | Importar legacy dry-run                           | Auditor             |
| UC-EC06-035 | Promover legacy batch                             | Security/QA         |
| UC-EC06-036 | Consultar evidence pack                           | Ops                 |
| UC-EC06-037 | Exportar attendance report                        | Attendance Operator |
| UC-EC06-038 | Exportar corporate attendance                     | Instructor          |
| UC-EC06-039 | Consultar audit lineage                           | Participant Mobile  |
| UC-EC06-040 | Consultar source provenance                       | Coordinator         |
| UC-EC06-041 | Consultar OperationStatus                         | System Worker       |
| UC-EC06-042 | Reintentar operación demostrablemente no aplicada | Data Steward        |
| UC-EC06-043 | Consultar dashboard instructor                    | Auditor             |
| UC-EC06-044 | Consultar dashboard coordinación                  | Security/QA         |
| UC-EC06-045 | Consultar dashboard participante                  | Ops                 |
| UC-EC06-046 | Registrar evidence ref CT-05                      | Attendance Operator |
| UC-EC06-047 | Agregar reason note                               | Instructor          |
| UC-EC06-048 | Bulk mark con dry-run                             | Participant Mobile  |
| UC-EC06-049 | Bulk adjustment con approval                      | Coordinator         |
| UC-EC06-050 | Detectar anomaly via CT-12                        | System Worker       |
| UC-EC06-051 | Aceptar/rechazar recomendación IA                 | Data Steward        |
| UC-EC06-052 | Consultar pending sync mobile                     | Auditor             |
| UC-EC06-053 | Reintentar sync mobile                            | Security/QA         |
| UC-EC06-054 | Registrar alternate accessible attendance         | Ops                 |
| UC-EC06-055 | Cerrar session con pending cases                  | Attendance Operator |
| UC-EC06-056 | Reabrir register excepcional                      | Instructor          |
| UC-EC06-057 | Consultar attendance ratio                        | Participant Mobile  |
| UC-EC06-058 | Consultar minutes timeline                        | Coordinator         |
| UC-EC06-059 | Consultar rejected attempts                       | System Worker       |
| UC-EC06-060 | Consultar expired/replayed tokens                 | Data Steward        |
| UC-EC06-061 | Reconciliar external partial batch                | Auditor             |
| UC-EC06-062 | Consultar retention class                         | Security/QA         |
| UC-EC06-063 | Ejecutar purge gobernado                          | Ops                 |
| UC-EC06-064 | Aplicar legal hold ref                            | Attendance Operator |
| UC-EC06-065 | Verificar tenant RLS                              | Instructor          |
| UC-EC06-066 | Rebuild read model                                | Participant Mobile  |
| UC-EC06-067 | Replay outbox                                     | Coordinator         |
| UC-EC06-068 | Claim/reclaim outbox lease                        | System Worker       |
| UC-EC06-069 | Recover idempotency lease                         | Data Steward        |
| UC-EC06-070 | Health/readiness dependency check                 | Auditor             |

## 10.1 Casos críticos desarrollados

### UC-EC06-007 — Registrar check-in QR

| **Aspecto**                   | **Detalle**                                                                                                                                    |
|-------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Participant                                                                                                                                    |
| Trigger                       | Escanea challenge vigente                                                                                                                      |
| Precondiciones / autorización | Enrollment válido; register OPEN; token válido; actor/device autorizado                                                                        |
| Happy Path                    | Validar tenant/register/session/token TTL/replay → append CheckInAttempt + AttendanceEvent → trigger/adjudication opcional → response receipt. |
| Alternativas / errores        | Expired/replay/wrong tenant =\> 422/409; dependency unavailable =\> 503; no side-effect parcial.                                               |
| Idempotencia                  | Idempotency-Key + token nonce.                                                                                                                 |
| Concurrencia                  | No lock global; unique replay guard + aggregate revision cuando actualiza fact.                                                                |
| Auditoría / side effects      | Audit security + metrics; event AttendanceSignalRecorded.                                                                                      |
| Postcondición                 | Receipt con accepted/rejected y correlationId.                                                                                                 |

### UC-EC06-018 — Sincronizar offline batch

| **Aspecto**                   | **Detalle**                                                                                                      |
|-------------------------------|------------------------------------------------------------------------------------------------------------------|
| Actor                         | Instructor Mobile                                                                                                |
| Trigger                       | Recupera conectividad                                                                                            |
| Precondiciones / autorización | Device registrado; batch firmado localmente                                                                      |
| Happy Path                    | Upload metadata+events → validate hash/signature/drift → dedup → ingest append-only → adjudicate → mark APPLIED. |
| Alternativas / errores        | Firma inválida=\>422; drift excesivo=\>UNDER_REVIEW; replay=\>same receipt.                                      |
| Idempotencia                  | batch_id/client key durable.                                                                                     |
| Concurrencia                  | Claim de batch + unique source events.                                                                           |
| Auditoría / side effects      | Audit device, payload hash, counts, rejected reasons.                                                            |
| Postcondición                 | APPLIED/REJECTED/RECONCILING con OperationStatus.                                                                |

### UC-EC06-023 — Adjudicar attendance fact

| **Aspecto**                   | **Detalle**                                                                                                                                                     |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | System/Operator                                                                                                                                                 |
| Trigger                       | Nuevos eventos o cierre                                                                                                                                         |
| Precondiciones / autorización | Register OPEN/CLOSING; roster entry válido; policy refs resolubles                                                                                              |
| Happy Path                    | Load events → normalize intervals → apply source priority/window policy → calculate minutes/ratio/status → persist new fact version + current pointer + outbox. |
| Alternativas / errores        | Critical source unavailable=\>PROVISIONAL/PENDING according policy; contradiction=\>review.                                                                     |
| Idempotencia                  | Derived command keyed by register+participant+input hash.                                                                                                       |
| Concurrencia                  | Lock current fact/root; optimistic revision.                                                                                                                    |
| Auditoría / side effects      | Policy snapshot, provenance summary, calculation trace hash.                                                                                                    |
| Postcondición                 | Fact version reproducible.                                                                                                                                      |

### UC-EC06-027 — Aplicar ajuste

| **Aspecto**                   | **Detalle**                                                                                                               |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Attendance Approver                                                                                                       |
| Trigger                       | Adjustment APPROVED                                                                                                       |
| Precondiciones / autorización | SoD/step-up/evidence satisfied                                                                                            |
| Happy Path                    | Lock current fact → create new fact version with adjustment_ref → update current pointer → outbox AttendanceFactRestated. |
| Alternativas / errores        | ETag conflict=\>412; stale workflow=\>409; evidence unavailable=\>503 if mandatory.                                       |
| Idempotencia                  | Idempotency-Key.                                                                                                          |
| Concurrencia                  | If-Match + DB unique current.                                                                                             |
| Auditoría / side effects      | Before/after, reason, actor, assurance, evidence refs.                                                                    |
| Postcondición                 | Historia anterior intacta.                                                                                                |

### UC-EC06-033 — Reconciliar UNKNOWN_EFFECT

| **Aspecto**                   | **Detalle**                                                                                                               |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Ops/System                                                                                                                |
| Trigger                       | Timeout o estado ambiguo                                                                                                  |
| Precondiciones / autorización | Remote receipt/correlation disponible                                                                                     |
| Happy Path                    | Query remote status via CT-18/CT-09 → compare local receipts → mark APPLIED/NOT_APPLIED/UNKNOWN → retry only NOT_APPLIED. |
| Alternativas / errores        | No status endpoint=\>keep UNKNOWN and escalate.                                                                           |
| Idempotencia                  | Reconciliation key idempotent.                                                                                            |
| Concurrencia                  | Lease case owner.                                                                                                         |
| Auditoría / side effects      | Ops audit + metrics.                                                                                                      |
| Postcondición                 | No duplicate remote effect.                                                                                               |

### UC-EC06-050 — Detectar anomaly via CT-12

| **Aspecto**                   | **Detalle**                                                                                              |
|-------------------------------|----------------------------------------------------------------------------------------------------------|
| Actor                         | Coordinator                                                                                              |
| Trigger                       | Signals contradictorias                                                                                  |
| Precondiciones / autorización | Purpose autorizado; no PII extra                                                                         |
| Happy Path                    | Build grounded feature refs → CT-12 run → recommendation with evidence links/confidence → human reviews. |
| Alternativas / errores        | CT-12 unavailable=\>manual continues; no automatic fact mutation.                                        |
| Idempotencia                  | AI run request key.                                                                                      |
| Concurrencia                  | Read-only until accept command.                                                                          |
| Auditoría / side effects      | Store ai_run_ref/template/eval/grounding/outcome.                                                        |
| Postcondición                 | Recommendation only.                                                                                     |

# 11. DER conceptual, lógico y físico

El modelo conceptual se organiza alrededor de AttendanceRegister, raw AttendanceEvent, OfficialAttendanceFact versionado, OfflineCaptureBatch, AttendanceAdjustment y ReconciliationCase. La regla central es conservar las observaciones originales y separar la adjudicación oficial.

<img src="media/image2.png" style="width:6.6in;height:4.01035in" />

Figura 2 — DER físico resumido EC-06.

| **REGLA DE FK — Todas las FKs físicas del esquema ec06 son internas y tenant-aware. EC-02, EC-04, EC-05, CT-01…CT-18, IAM y cores se referencian como EXT REF.** |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 12. Modelo físico PostgreSQL tabla por tabla

El esquema propuesto es ec06. Toda tabla tenant-owned usa tenant_id y RLS. Las FKs físicas son únicamente internas a EC-06. Los IDs de sesión, edición, enrollment, persona, instructor, documento y proveedores externos son EXT REF.

| **PREGUNTA OBLIGATORIA — Para cada tabla: ¿qué error debe impedir PostgreSQL aunque Backend tenga un bug? PK/FK tenant-aware, UNIQUE, CHECK, RLS y triggers defensivos deben cubrir toda invariante físicamente expresable.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.1 ec06_attendance_register

QUÉ REPRESENTA — Registro operativo por sesión/edición que pinnea ventanas, timezone y policy refs.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                      | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|--------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*          | Tenant autorizado.                   | 8a6…              |
| attendance_register_id | uuid                | NO       | gen_random_uuid() | PK            | ID técnico.                          | 8a6…              |
| session_ref            | uuid                | NO       | —                 | EXT REF EC-02 | Sesión/occurrence externa.           | 8a6…              |
| edition_ref            | uuid                | NO       | —                 | EXT REF EC-02 | Edición dueña.                       | 8a6…              |
| cohort_ref             | uuid                | YES      | NULL              | EXT REF EC-02 | Cohorte opcional.                    | 8a6…              |
| attendance_policy_ref  | uuid                | NO       | —                 | EXT REF CT-02 | PolicyVersion inmutable.             | 8a6…              |
| engagement_policy_ref  | uuid                | YES      | NULL              | EXT REF CT-02 | Policy opcional.                     | 8a6…              |
| planned_start_at       | timestamptz         | NO       | —                 | —             | Inicio UTC snapshot.                 | 2026-09-10T18:00Z |
| planned_end_at         | timestamptz         | NO       | —                 | CHECK         | Fin UTC snapshot.                    | 2026-09-10T18:00Z |
| timezone_id            | varchar(64)         | NO       | —                 | CHECK         | Timezone IANA.                       | …                 |
| state                  | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/OPEN/CLOSING/LOCKED/CANCELLED. | …                 |
| opened_at              | timestamptz         | YES      | NULL              | —             | Apertura.                            | 2026-09-10T18:00Z |
| locked_at              | timestamptz         | YES      | NULL              | —             | Cierre/lock.                         | 2026-09-10T18:00Z |
| policy_snapshot_hash   | varchar(128)        | YES      | NULL              | —             | Hash snapshot policy.                | …                 |
| created_by_subject     | uuid                | NO       | —                 | EXT REF IAM   | Actor creador.                       | 8a6…              |
| created_at             | timestamptz         | NO       | now()             | —             | Creación.                            | 2026-09-10T18:00Z |
| updated_at             | timestamptz         | NO       | now()             | —             | Actualización.                       | 2026-09-10T18:00Z |
| version                | bigint              | NO       | 0                 | —             | Optimistic lock.                     | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant autorizado. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**attendance_register_id —** ID técnico. Es obligatorio; default físico gen_random_uuid().

**session_ref —** Sesión/occurrence externa. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**edition_ref —** Edición dueña. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**cohort_ref —** Cohorte opcional. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**attendance_policy_ref —** PolicyVersion inmutable. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**engagement_policy_ref —** Policy opcional. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**planned_start_at —** Inicio UTC snapshot. Es obligatorio; default físico —. Se persiste en UTC; timezone solo para interpretación/presentación.

**planned_end_at —** Fin UTC snapshot. Es obligatorio; default físico —. Se persiste en UTC; timezone solo para interpretación/presentación.

**timezone_id —** Timezone IANA. Es obligatorio; default físico —.

**state —** DRAFT/OPEN/CLOSING/LOCKED/CANCELLED. Es obligatorio; default físico 'DRAFT'.

**opened_at —** Apertura. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**locked_at —** Cierre/lock. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**policy_snapshot_hash —** Hash snapshot policy. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**created_by_subject —** Actor creador. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**updated_at —** Actualización. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**version —** Optimistic lock. Es obligatorio; default físico 0. Se mapea con @Version/ETag; versión obsoleta produce 412 PRECONDITION_FAILED.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|--------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_attendance_register          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_attendance_register_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_attendance_register_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_attendance_register_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_attendance_register         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec06_register_roster_entry

QUÉ REPRESENTA — Snapshot mínimo del enrollment elegible para attendance en un register.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                            | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant.                                    | 8a6…              |
| roster_entry_id          | uuid                | NO       | gen_random_uuid() | PK            | ID.                                        | 8a6…              |
| attendance_register_id   | uuid                | NO       | —                 | FK            | Register padre.                            | 8a6…              |
| enrollment_ref           | uuid                | NO       | —                 | EXT REF EC-04 | Enrollment pinneado.                       | 8a6…              |
| person_ref               | uuid                | NO       | —                 | EXT REF CT-04 | Persona canónica.                          | 8a6…              |
| participant_ref          | uuid                | YES      | NULL              | EXT REF EC-04 | Rol participante si existe.                | 8a6…              |
| eligibility_snapshot_ref | uuid                | YES      | NULL              | EXT REF       | Resultado/snapshot de elegibilidad.        | 8a6…              |
| roster_state             | varchar(24)         | NO       | 'ELIGIBLE'        | CHECK         | ELIGIBLE/INELIGIBLE/WITHDRAWN/TRANSFERRED. | …                 |
| source_batch_ref         | uuid                | YES      | NULL              | EXT REF       | Batch corporate/import.                    | 8a6…              |
| created_at               | timestamptz         | NO       | now()             | —             | Creación.                                  | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**roster_entry_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register padre. Es obligatorio; default físico —.

**enrollment_ref —** Enrollment pinneado. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**person_ref —** Persona canónica. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**participant_ref —** Rol participante si existe. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**eligibility_snapshot_ref —** Resultado/snapshot de elegibilidad. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**roster_state —** ELIGIBLE/INELIGIBLE/WITHDRAWN/TRANSFERRED. Es obligatorio; default físico 'ELIGIBLE'.

**source_batch_ref —** Batch corporate/import. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**                      | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|----------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_register_roster_entry          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_register_roster_entry_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_register_roster_entry_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_register_roster_entry_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_register_roster_entry         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec06_checkin_token

QUÉ REPRESENTA — Challenge seguro para check-in QR/kiosk.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                  | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|-------------|----------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*        | Tenant.                          | 8a6…              |
| checkin_token_id       | uuid                | NO       | gen_random_uuid() | PK          | ID.                              | 8a6…              |
| attendance_register_id | uuid                | NO       | —                 | FK          | Register scope.                  | 8a6…              |
| token_hash             | varchar(128)        | NO       | —                 | UQ          | Hash token; nunca valor crudo.   | …                 |
| nonce                  | uuid                | NO       | gen_random_uuid() | UQ          | Anti-replay.                     | 8a6…              |
| issued_at              | timestamptz         | NO       | now()             | —           | Emisión.                         | 2026-09-10T18:00Z |
| expires_at             | timestamptz         | NO       | —                 | CHECK       | Expiración \> issue.             | 2026-09-10T18:00Z |
| single_use             | boolean             | NO       | true              | —           | One-time policy.                 | true              |
| state                  | varchar(20)         | NO       | 'ISSUED'          | CHECK       | ISSUED/CONSUMED/EXPIRED/REVOKED. | …                 |
| consumed_at            | timestamptz         | YES      | NULL              | —           | Consumo.                         | 2026-09-10T18:00Z |
| issuer_subject         | uuid                | NO       | —                 | EXT REF IAM | Actor/technical principal.       | 8a6…              |
| version                | bigint              | NO       | 0                 | —           | Optimistic lock.                 | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**checkin_token_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register scope. Es obligatorio; default físico —.

**token_hash —** Hash token; nunca valor crudo. Es obligatorio; default físico —.

**nonce —** Anti-replay. Es obligatorio; default físico gen_random_uuid().

**issued_at —** Emisión. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**expires_at —** Expiración \> issue. Es obligatorio; default físico —. Se persiste en UTC; timezone solo para interpretación/presentación.

**single_use —** One-time policy. Es obligatorio; default físico true.

**state —** ISSUED/CONSUMED/EXPIRED/REVOKED. Es obligatorio; default físico 'ISSUED'.

**consumed_at —** Consumo. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**issuer_subject —** Actor/technical principal. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**version —** Optimistic lock. Es obligatorio; default físico 0. Se mapea con @Version/ETag; versión obsoleta produce 412 PRECONDITION_FAILED.

### Constraints físicos implementables

| **Nombre físico**              | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|--------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_checkin_token          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_checkin_token_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_checkin_token_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_checkin_token_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_checkin_token         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.4 ec06_checkin_attempt

QUÉ REPRESENTA — Cada intento de consumir challenge; permite security analytics sin alterar fact.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                          | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*          | Tenant.                                                  | 8a6…              |
| checkin_attempt_id     | uuid                | NO       | gen_random_uuid() | PK            | ID.                                                      | 8a6…              |
| checkin_token_id       | uuid                | NO       | —                 | FK            | Token.                                                   | 8a6…              |
| attendance_register_id | uuid                | NO       | —                 | FK            | Register.                                                | 8a6…              |
| person_ref             | uuid                | YES      | NULL              | EXT REF       | Sujeto si resoluble.                                     | 8a6…              |
| enrollment_ref         | uuid                | YES      | NULL              | EXT REF       | Enrollment.                                              | 8a6…              |
| device_ref             | uuid                | YES      | NULL              | EXT REF       | Device registration.                                     | 8a6…              |
| client_occurred_at     | timestamptz         | YES      | NULL              | —             | Hora cliente evidencia.                                  | 2026-09-10T18:00Z |
| received_at            | timestamptz         | NO       | now()             | —             | Hora servidor.                                           | 2026-09-10T18:00Z |
| result                 | varchar(24)         | NO       | —                 | CHECK         | ACCEPTED/EXPIRED/REPLAY/WRONG_SCOPE/INELIGIBLE/REJECTED. | …                 |
| reason_code            | varchar(80)         | YES      | NULL              | EXT REF CT-02 | Razón estable.                                           | …                 |
| correlation_id         | uuid                | NO       | gen_random_uuid() | —             | Correlación.                                             | 8a6…              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**checkin_attempt_id —** ID. Es obligatorio; default físico gen_random_uuid().

**checkin_token_id —** Token. Es obligatorio; default físico —.

**attendance_register_id —** Register. Es obligatorio; default físico —.

**person_ref —** Sujeto si resoluble. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**enrollment_ref —** Enrollment. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**device_ref —** Device registration. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**client_occurred_at —** Hora cliente evidencia. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**received_at —** Hora servidor. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**result —** ACCEPTED/EXPIRED/REPLAY/WRONG_SCOPE/INELIGIBLE/REJECTED. Es obligatorio; default físico —.

**reason_code —** Razón estable. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**correlation_id —** Correlación. Es obligatorio; default físico gen_random_uuid().

### Constraints físicos implementables

| **Nombre físico**                | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|----------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_checkin_attempt          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_checkin_attempt_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_checkin_attempt_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_checkin_attempt_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_checkin_attempt         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.5 ec06_attendance_event

QUÉ REPRESENTA — Ledger append-only de señales de asistencia.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                       | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|-------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*          | Tenant.                                               | 8a6…              |
| attendance_event_id    | uuid                | NO       | gen_random_uuid() | PK            | ID.                                                   | 8a6…              |
| attendance_register_id | uuid                | NO       | —                 | FK            | Register.                                             | 8a6…              |
| roster_entry_id        | uuid                | YES      | NULL              | FK            | Roster resuelto.                                      | 8a6…              |
| event_kind             | varchar(40)         | NO       | —                 | CHECK         | CHECK_IN/CHECK_OUT/MANUAL_MARK/EXTERNAL_PRESENCE/etc. | …                 |
| source_kind            | varchar(40)         | NO       | —                 | CHECK         | INSTRUCTOR/QR/MOBILE/KIOSK/CT18/IMPORT.               | …                 |
| source_authority_ref   | uuid                | YES      | NULL              | EXT REF       | Sistema/actor origen.                                 | 8a6…              |
| source_event_id        | varchar(160)        | YES      | NULL              | UQ\*          | ID externo para dedup.                                | …                 |
| occurred_at            | timestamptz         | NO       | —                 | —             | Momento observado.                                    | 2026-09-10T18:00Z |
| received_at            | timestamptz         | NO       | now()             | —             | Ingesta servidor.                                     | 2026-09-10T18:00Z |
| event_value            | jsonb               | YES      | NULL              | CHECK         | Payload normalizado limitado.                         | {…}               |
| quality_code           | varchar(40)         | YES      | NULL              | EXT REF CT-02 | Calidad/provenance.                                   | …                 |
| evidence_ref           | uuid                | YES      | NULL              | EXT REF CT-05 | Evidencia.                                            | 8a6…              |
| correlation_id         | uuid                | NO       | gen_random_uuid() | —             | Correlación.                                          | 8a6…              |
| causation_id           | uuid                | YES      | NULL              | —             | Causalidad.                                           | 8a6…              |
| created_at             | timestamptz         | NO       | now()             | —             | Append time.                                          | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**attendance_event_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register. Es obligatorio; default físico —.

**roster_entry_id —** Roster resuelto. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**event_kind —** CHECK_IN/CHECK_OUT/MANUAL_MARK/EXTERNAL_PRESENCE/etc. Es obligatorio; default físico —.

**source_kind —** INSTRUCTOR/QR/MOBILE/KIOSK/CT18/IMPORT. Es obligatorio; default físico —.

**source_authority_ref —** Sistema/actor origen. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**source_event_id —** ID externo para dedup. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**occurred_at —** Momento observado. Es obligatorio; default físico —. Se persiste en UTC; timezone solo para interpretación/presentación.

**received_at —** Ingesta servidor. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**event_value —** Payload normalizado limitado. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. El JSON se valida por schema/size; no se usa como escape para evitar modelado relacional.

**quality_code —** Calidad/provenance. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**evidence_ref —** Evidencia. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**correlation_id —** Correlación. Es obligatorio; default físico gen_random_uuid().

**causation_id —** Causalidad. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**created_at —** Append time. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**                     | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|---------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_attendance_event              | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_attendance_event_internal     | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_attendance_event_domain       | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_attendance_event_lookup       | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_attendance_event             | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |
| trg_ec06_attendance_event_append_only | TRIGGER         | prohíbe UPDATE/DELETE runtime                  | Preserva evidencia raw/receipt.                              |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec06_attendance_interval

QUÉ REPRESENTA — Intervalo normalizado derivado de eventos; reproducible por adjudication.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**    | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|-----------|--------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*      | Tenant.            | 8a6…              |
| attendance_interval_id | uuid                | NO       | gen_random_uuid() | PK        | ID.                | 8a6…              |
| adjudication_id        | uuid                | NO       | —                 | FK        | Adjudication.      | 8a6…              |
| roster_entry_id        | uuid                | NO       | —                 | FK        | Participante.      | 8a6…              |
| start_at               | timestamptz         | NO       | —                 | —         | Inicio reconocido. | 2026-09-10T18:00Z |
| end_at                 | timestamptz         | NO       | —                 | CHECK     | Fin \> inicio.     | 2026-09-10T18:00Z |
| recognized_minutes     | integer             | NO       | —                 | CHECK     | Minutos \>=0.      | 15                |
| source_summary         | jsonb               | NO       | '{}'::jsonb       | CHECK     | Fuentes usadas.    | {…}               |
| created_at             | timestamptz         | NO       | now()             | —         | Creación derivada. | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**attendance_interval_id —** ID. Es obligatorio; default físico gen_random_uuid().

**adjudication_id —** Adjudication. Es obligatorio; default físico —.

**roster_entry_id —** Participante. Es obligatorio; default físico —.

**start_at —** Inicio reconocido. Es obligatorio; default físico —. Se persiste en UTC; timezone solo para interpretación/presentación.

**end_at —** Fin \> inicio. Es obligatorio; default físico —. Se persiste en UTC; timezone solo para interpretación/presentación.

**recognized_minutes —** Minutos \>=0. Es obligatorio; default físico —.

**source_summary —** Fuentes usadas. Es obligatorio; default físico '{}'::jsonb. El JSON se valida por schema/size; no se usa como escape para evitar modelado relacional.

**created_at —** Creación derivada. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|--------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_attendance_interval          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_attendance_interval_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_attendance_interval_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_attendance_interval_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_attendance_interval         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.7 ec06_attendance_adjudication

QUÉ REPRESENTA — Ejecución versionada del cálculo de attendance.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                     | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|---------------|-------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant.                             | 8a6…              |
| adjudication_id          | uuid                | NO       | gen_random_uuid() | PK            | ID.                                 | 8a6…              |
| attendance_register_id   | uuid                | NO       | —                 | FK            | Register.                           | 8a6…              |
| roster_entry_id          | uuid                | NO       | —                 | FK            | Participante.                       | 8a6…              |
| adjudication_no          | integer             | NO       | —                 | UQ            | Versión monotónica.                 | 15                |
| previous_adjudication_id | uuid                | YES      | NULL              | FK            | Lineage.                            | 8a6…              |
| policy_ref               | uuid                | NO       | —                 | EXT REF CT-02 | PolicyVersion.                      | 8a6…              |
| policy_snapshot_hash     | varchar(128)        | NO       | —                 | —             | Hash policy.                        | …                 |
| input_hash               | varchar(128)        | NO       | —                 | —             | Hash canonical de eventos.          | …                 |
| result_status            | varchar(32)         | NO       | —                 | CHECK         | PROVISIONAL/OFFICIAL/RESTATED/VOID. | …                 |
| calculation_trace_hash   | varchar(128)        | NO       | —                 | —             | Trace hash.                         | …                 |
| trigger_reason_code      | varchar(80)         | NO       | —                 | EXT REF CT-02 | Cause.                              | …                 |
| created_by_subject       | uuid                | NO       | —                 | EXT REF IAM   | Actor/system.                       | 8a6…              |
| created_at               | timestamptz         | NO       | now()             | —             | Creación.                           | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**adjudication_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register. Es obligatorio; default físico —.

**roster_entry_id —** Participante. Es obligatorio; default físico —.

**adjudication_no —** Versión monotónica. Es obligatorio; default físico —.

**previous_adjudication_id —** Lineage. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**policy_ref —** PolicyVersion. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**policy_snapshot_hash —** Hash policy. Es obligatorio; default físico —.

**input_hash —** Hash canonical de eventos. Es obligatorio; default físico —.

**result_status —** PROVISIONAL/OFFICIAL/RESTATED/VOID. Es obligatorio; default físico —.

**calculation_trace_hash —** Trace hash. Es obligatorio; default físico —.

**trigger_reason_code —** Cause. Es obligatorio; default físico —.

**created_by_subject —** Actor/system. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**                        | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|------------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_attendance_adjudication          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_attendance_adjudication_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_attendance_adjudication_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_attendance_adjudication_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_attendance_adjudication         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.8 ec06_official_attendance_fact

QUÉ REPRESENTA — Hecho oficial versionado consumible downstream.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**           | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|---------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*          | Tenant.                   | 8a6…              |
| attendance_fact_id     | uuid                | NO       | gen_random_uuid() | PK            | ID.                       | 8a6…              |
| attendance_register_id | uuid                | NO       | —                 | FK            | Register.                 | 8a6…              |
| roster_entry_id        | uuid                | NO       | —                 | FK            | Participante.             | 8a6…              |
| adjudication_id        | uuid                | NO       | —                 | FK            | Adjudication source.      | 8a6…              |
| fact_version_no        | integer             | NO       | —                 | UQ            | Versión.                  | 15                |
| previous_fact_id       | uuid                | YES      | NULL              | FK            | Lineage.                  | 8a6…              |
| attendance_status_code | varchar(48)         | NO       | —                 | EXT REF CT-02 | Status gobernado.         | …                 |
| eligible_minutes       | integer             | NO       | —                 | CHECK         | Denominador \>=0.         | 15                |
| attended_minutes       | integer             | NO       | —                 | CHECK         | Minutos reconocidos \>=0. | 15                |
| attendance_ratio       | numeric(7,6)        | YES      | NULL              | CHECK         | 0..1.                     | 0.833333          |
| late_minutes           | integer             | NO       | 0                 | CHECK         | Retraso \>=0.             | 15                |
| early_leave_minutes    | integer             | NO       | 0                 | CHECK         | Salida temprana \>=0.     | 15                |
| excused                | boolean             | NO       | false             | —             | Excused semántico.        | true              |
| current_flag           | boolean             | NO       | true              | UQ partial    | Una fact vigente.         | true              |
| official_at            | timestamptz         | YES      | NULL              | —             | Officialization.          | 2026-09-10T18:00Z |
| reason_code            | varchar(80)         | YES      | NULL              | EXT REF CT-02 | Razón correction/void.    | …                 |
| evidence_summary_hash  | varchar(128)        | YES      | NULL              | —             | Hash evidence summary.    | …                 |
| created_at             | timestamptz         | NO       | now()             | —             | Creación.                 | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**attendance_fact_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register. Es obligatorio; default físico —.

**roster_entry_id —** Participante. Es obligatorio; default físico —.

**adjudication_id —** Adjudication source. Es obligatorio; default físico —.

**fact_version_no —** Versión. Es obligatorio; default físico —.

**previous_fact_id —** Lineage. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**attendance_status_code —** Status gobernado. Es obligatorio; default físico —.

**eligible_minutes —** Denominador \>=0. Es obligatorio; default físico —.

**attended_minutes —** Minutos reconocidos \>=0. Es obligatorio; default físico —.

**attendance_ratio —** 0..1. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**late_minutes —** Retraso \>=0. Es obligatorio; default físico 0.

**early_leave_minutes —** Salida temprana \>=0. Es obligatorio; default físico 0.

**excused —** Excused semántico. Es obligatorio; default físico false.

**current_flag —** Una fact vigente. Es obligatorio; default físico true.

**official_at —** Officialization. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**reason_code —** Razón correction/void. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**evidence_summary_hash —** Hash evidence summary. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**                         | **Tipo**        | **Definición/expresión**                                                | **Error que impide**                                         |
|-------------------------------------------|-----------------|-------------------------------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_official_attendance_fact          | PK              | (tenant_id, id lógico correspondiente)                                  | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_official_attendance_fact_internal | FK tenant-aware | Solo cuando referencia tabla EC-06                                      | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_official_attendance_fact_domain   | CHECK           | Estados, rangos, fechas y pares coherentes                              | Evita valores físicamente imposibles.                        |
| ix_ec06_official_attendance_fact_lookup   | INDEX           | tenant_id + claves de consulta                                          | Evita scans y soporta SLO.                                   |
| rls_ec06_official_attendance_fact         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...)                          | Impide lectura/escritura cross-tenant por bug de repository. |
| uq_ec06_fact_current                      | UNIQUE partial  | (tenant_id, attendance_register_id, roster_entry_id) WHERE current_flag | Impide dos facts vigentes.                                   |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.9 ec06_participation_evidence

QUÉ REPRESENTA — Referencia a evidencia de participación adicional.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**  | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------|------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*          | Tenant.          | 8a6…              |
| participation_evidence_id | uuid                | NO       | gen_random_uuid() | PK            | ID.              | 8a6…              |
| attendance_register_id    | uuid                | NO       | —                 | FK            | Register.        | 8a6…              |
| roster_entry_id           | uuid                | NO       | —                 | FK            | Participante.    | 8a6…              |
| evidence_kind_code        | varchar(64)         | NO       | —                 | EXT REF CT-02 | Tipo.            | …                 |
| document_ref              | uuid                | YES      | NULL              | EXT REF CT-05 | Artefacto.       | 8a6…              |
| external_receipt_ref      | uuid                | YES      | NULL              | FK            | Receipt externo. | 8a6…              |
| captured_at               | timestamptz         | NO       | now()             | —             | Captura.         | 2026-09-10T18:00Z |
| source_kind               | varchar(40)         | NO       | —                 | CHECK         | Fuente.          | …                 |
| hash                      | varchar(128)        | YES      | NULL              | —             | Hash opcional.   | …                 |
| created_by_subject        | uuid                | NO       | —                 | EXT REF IAM   | Actor.           | 8a6…              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**participation_evidence_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register. Es obligatorio; default físico —.

**roster_entry_id —** Participante. Es obligatorio; default físico —.

**evidence_kind_code —** Tipo. Es obligatorio; default físico —.

**document_ref —** Artefacto. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**external_receipt_ref —** Receipt externo. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**captured_at —** Captura. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**source_kind —** Fuente. Es obligatorio; default físico —.

**hash —** Hash opcional. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**created_by_subject —** Actor. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

### Constraints físicos implementables

| **Nombre físico**                       | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|-----------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_participation_evidence          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_participation_evidence_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_participation_evidence_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_participation_evidence_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_participation_evidence         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec06_engagement_observation

QUÉ REPRESENTA — Señal de engagement no calificativa.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**          | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------|--------------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*          | Tenant.                  | 8a6…              |
| engagement_observation_id | uuid                | NO       | gen_random_uuid() | PK            | ID.                      | 8a6…              |
| attendance_register_id    | uuid                | NO       | —                 | FK            | Register.                | 8a6…              |
| roster_entry_id           | uuid                | NO       | —                 | FK            | Participante.            | 8a6…              |
| engagement_kind_code      | varchar(64)         | NO       | —                 | EXT REF CT-02 | Tipo.                    | …                 |
| normalized_value          | numeric(12,4)       | YES      | NULL              | —             | Valor normalizado.       | …                 |
| unit_code                 | varchar(32)         | YES      | NULL              | EXT REF CT-02 | Unidad.                  | …                 |
| source_event_id           | varchar(160)        | YES      | NULL              | —             | Provenance.              | …                 |
| observed_at               | timestamptz         | NO       | —                 | —             | Observación.             | 2026-09-10T18:00Z |
| accepted                  | boolean             | NO       | true              | —             | Aceptada para analytics. | true              |
| rejection_reason_code     | varchar(80)         | YES      | NULL              | EXT REF CT-02 | Motivo.                  | …                 |
| created_at                | timestamptz         | NO       | now()             | —             | Creación.                | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**engagement_observation_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register. Es obligatorio; default físico —.

**roster_entry_id —** Participante. Es obligatorio; default físico —.

**engagement_kind_code —** Tipo. Es obligatorio; default físico —.

**normalized_value —** Valor normalizado. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**unit_code —** Unidad. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**source_event_id —** Provenance. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**observed_at —** Observación. Es obligatorio; default físico —. Se persiste en UTC; timezone solo para interpretación/presentación.

**accepted —** Aceptada para analytics. Es obligatorio; default físico true.

**rejection_reason_code —** Motivo. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**                       | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|-----------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_engagement_observation          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_engagement_observation_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_engagement_observation_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_engagement_observation_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_engagement_observation         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.11 ec06_attendance_adjustment

QUÉ REPRESENTA — Solicitud gobernada de corrección.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**       | **Ejemplo**       |
|----------------------------|---------------------|----------|-------------------|---------------|-----------------------|-------------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*          | Tenant.               | 8a6…              |
| attendance_adjustment_id   | uuid                | NO       | gen_random_uuid() | PK            | ID.                   | 8a6…              |
| attendance_fact_id         | uuid                | NO       | —                 | FK            | Fact objetivo.        | 8a6…              |
| requested_status_code      | varchar(48)         | YES      | NULL              | EXT REF CT-02 | Status propuesto.     | …                 |
| requested_attended_minutes | integer             | YES      | NULL              | CHECK         | Minutos propuestos.   | 15                |
| reason_code                | varchar(80)         | NO       | —                 | EXT REF CT-02 | Razón.                | …                 |
| reason_text                | varchar(800)        | YES      | NULL              | —             | Explicación limitada. | …                 |
| evidence_ref               | uuid                | YES      | NULL              | EXT REF CT-05 | Evidencia.            | 8a6…              |
| workflow_ref               | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow.             | 8a6…              |
| state                      | varchar(24)         | NO       | 'DRAFT'           | CHECK         | Lifecycle.            | …                 |
| requested_by_subject       | uuid                | NO       | —                 | EXT REF IAM   | Solicitante.          | 8a6…              |
| decided_by_subject         | uuid                | YES      | NULL              | EXT REF IAM   | Decisor.              | 8a6…              |
| decided_at                 | timestamptz         | YES      | NULL              | —             | Decisión.             | 2026-09-10T18:00Z |
| applied_fact_id            | uuid                | YES      | NULL              | FK            | Nueva fact.           | 8a6…              |
| created_at                 | timestamptz         | NO       | now()             | —             | Creación.             | 2026-09-10T18:00Z |
| version                    | bigint              | NO       | 0                 | —             | ETag.                 | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**attendance_adjustment_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_fact_id —** Fact objetivo. Es obligatorio; default físico —.

**requested_status_code —** Status propuesto. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**requested_attended_minutes —** Minutos propuestos. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**reason_code —** Razón. Es obligatorio; default físico —.

**reason_text —** Explicación limitada. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**evidence_ref —** Evidencia. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**workflow_ref —** Workflow. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**state —** Lifecycle. Es obligatorio; default físico 'DRAFT'.

**requested_by_subject —** Solicitante. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**decided_by_subject —** Decisor. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**decided_at —** Decisión. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**applied_fact_id —** Nueva fact. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**version —** ETag. Es obligatorio; default físico 0. Se mapea con @Version/ETag; versión obsoleta produce 412 PRECONDITION_FAILED.

### Constraints físicos implementables

| **Nombre físico**                      | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|----------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_attendance_adjustment          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_attendance_adjustment_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_attendance_adjustment_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_attendance_adjustment_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_attendance_adjustment         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec06_external_telemetry_receipt

QUÉ REPRESENTA — Receipt durable de telemetría recibida.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                   | **Ejemplo**       |
|---------------------|---------------------|----------|-------------------|---------------|---------------------------------------------------|-------------------|
| tenant_id           | uuid                | NO       | —                 | PK\*          | Tenant.                                           | 8a6…              |
| external_receipt_id | uuid                | NO       | gen_random_uuid() | PK            | ID.                                               | 8a6…              |
| source_system_ref   | uuid                | NO       | —                 | EXT REF CT-18 | Sistema.                                          | 8a6…              |
| source_batch_id     | varchar(160)        | NO       | —                 | UQ            | ID remoto.                                        | …                 |
| schema_version      | varchar(40)         | NO       | —                 | —             | Versión contrato.                                 | …                 |
| payload_hash        | varchar(128)        | NO       | —                 | —             | Hash canonical.                                   | …                 |
| event_count         | integer             | NO       | 0                 | CHECK         | Cantidad \>=0.                                    | 15                |
| received_at         | timestamptz         | NO       | now()             | —             | Recepción.                                        | 2026-09-10T18:00Z |
| status              | varchar(24)         | NO       | 'RECEIVED'        | CHECK         | RECEIVED/APPLIED/PARTIAL/REJECTED/UNKNOWN_EFFECT. | …                 |
| correlation_id      | uuid                | NO       | gen_random_uuid() | —             | Correlación.                                      | 8a6…              |
| created_at          | timestamptz         | NO       | now()             | —             | Append-only.                                      | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**external_receipt_id —** ID. Es obligatorio; default físico gen_random_uuid().

**source_system_ref —** Sistema. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**source_batch_id —** ID remoto. Es obligatorio; default físico —.

**schema_version —** Versión contrato. Es obligatorio; default físico —.

**payload_hash —** Hash canonical. Es obligatorio; default físico —.

**event_count —** Cantidad \>=0. Es obligatorio; default físico 0.

**received_at —** Recepción. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**status —** RECEIVED/APPLIED/PARTIAL/REJECTED/UNKNOWN_EFFECT. Es obligatorio; default físico 'RECEIVED'.

**correlation_id —** Correlación. Es obligatorio; default físico gen_random_uuid().

**created_at —** Append-only. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**                               | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|-------------------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_external_telemetry_receipt              | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_external_telemetry_receipt_internal     | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_external_telemetry_receipt_domain       | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_external_telemetry_receipt_lookup       | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_external_telemetry_receipt             | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |
| trg_ec06_external_telemetry_receipt_append_only | TRIGGER         | prohíbe UPDATE/DELETE runtime                  | Preserva evidencia raw/receipt.                              |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.13 ec06_offline_capture_batch

QUÉ REPRESENTA — Lote móvil offline firmado.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**        | **Ejemplo**       |
|-------------------------|---------------------|----------|-------------------|-----------|------------------------|-------------------|
| tenant_id               | uuid                | NO       | —                 | PK\*      | Tenant.                | 8a6…              |
| offline_batch_id        | uuid                | NO       | gen_random_uuid() | PK        | ID.                    | 8a6…              |
| attendance_register_id  | uuid                | NO       | —                 | FK        | Register.              | 8a6…              |
| device_registration_ref | uuid                | NO       | —                 | EXT REF   | Device.                | 8a6…              |
| client_batch_id         | uuid                | NO       | —                 | UQ        | ID cliente.            | 8a6…              |
| payload_hash            | varchar(128)        | NO       | —                 | —         | Hash.                  | …                 |
| signature_ref           | varchar(256)        | NO       | —                 | —         | Firma/attestation ref. | …                 |
| client_created_at       | timestamptz         | NO       | —                 | —         | Hora cliente.          | 2026-09-10T18:00Z |
| received_at             | timestamptz         | YES      | NULL              | —         | Hora servidor.         | 2026-09-10T18:00Z |
| clock_drift_seconds     | integer             | YES      | NULL              | —         | Drift medido.          | 15                |
| event_count             | integer             | NO       | 0                 | CHECK     | Cantidad.              | 15                |
| state                   | varchar(24)         | NO       | 'CREATED'         | CHECK     | Lifecycle.             | …                 |
| apply_receipt_hash      | varchar(128)        | YES      | NULL              | —         | Receipt.               | …                 |
| created_at              | timestamptz         | NO       | now()             | —         | Creación.              | 2026-09-10T18:00Z |
| version                 | bigint              | NO       | 0                 | —         | Lock.                  | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**offline_batch_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register. Es obligatorio; default físico —.

**device_registration_ref —** Device. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**client_batch_id —** ID cliente. Es obligatorio; default físico —.

**payload_hash —** Hash. Es obligatorio; default físico —.

**signature_ref —** Firma/attestation ref. Es obligatorio; default físico —. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**client_created_at —** Hora cliente. Es obligatorio; default físico —. Se persiste en UTC; timezone solo para interpretación/presentación.

**received_at —** Hora servidor. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**clock_drift_seconds —** Drift medido. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**event_count —** Cantidad. Es obligatorio; default físico 0.

**state —** Lifecycle. Es obligatorio; default físico 'CREATED'.

**apply_receipt_hash —** Receipt. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**version —** Lock. Es obligatorio; default físico 0. Se mapea con @Version/ETag; versión obsoleta produce 412 PRECONDITION_FAILED.

### Constraints físicos implementables

| **Nombre físico**                      | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|----------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_offline_capture_batch          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_offline_capture_batch_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_offline_capture_batch_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_offline_capture_batch_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_offline_capture_batch         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec06_reconciliation_case

QUÉ REPRESENTA — Caso durable para discrepancia/UNKNOWN_EFFECT.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                        | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|----------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*          | Tenant.                                | 8a6…              |
| reconciliation_case_id | uuid                | NO       | gen_random_uuid() | PK            | ID.                                    | 8a6…              |
| attendance_register_id | uuid                | YES      | NULL              | FK            | Register.                              | 8a6…              |
| roster_entry_id        | uuid                | YES      | NULL              | FK            | Participante.                          | 8a6…              |
| case_type_code         | varchar(64)         | NO       | —                 | EXT REF CT-02 | Tipo.                                  | …                 |
| state                  | varchar(24)         | NO       | 'OPEN'            | CHECK         | OPEN/INVESTIGATING/RESOLVED/ESCALATED. | …                 |
| source_receipt_ref     | uuid                | YES      | NULL              | FK            | Receipt.                               | 8a6…              |
| reason_code            | varchar(80)         | NO       | —                 | EXT REF CT-02 | Razón.                                 | …                 |
| resolution_code        | varchar(80)         | YES      | NULL              | EXT REF CT-02 | Resolución.                            | …                 |
| owner_subject          | uuid                | YES      | NULL              | EXT REF IAM   | Owner.                                 | 8a6…              |
| lease_until            | timestamptz         | YES      | NULL              | —             | Lease.                                 | 2026-09-10T18:00Z |
| created_at             | timestamptz         | NO       | now()             | —             | Creación.                              | 2026-09-10T18:00Z |
| resolved_at            | timestamptz         | YES      | NULL              | —             | Cierre.                                | 2026-09-10T18:00Z |
| version                | bigint              | NO       | 0                 | —             | Optimistic lock.                       | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**reconciliation_case_id —** ID. Es obligatorio; default físico gen_random_uuid().

**attendance_register_id —** Register. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**roster_entry_id —** Participante. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**case_type_code —** Tipo. Es obligatorio; default físico —.

**state —** OPEN/INVESTIGATING/RESOLVED/ESCALATED. Es obligatorio; default físico 'OPEN'.

**source_receipt_ref —** Receipt. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**reason_code —** Razón. Es obligatorio; default físico —.

**resolution_code —** Resolución. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**owner_subject —** Owner. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**lease_until —** Lease. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**resolved_at —** Cierre. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**version —** Optimistic lock. Es obligatorio; default físico 0. Se mapea con @Version/ETag; versión obsoleta produce 412 PRECONDITION_FAILED.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|--------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_reconciliation_case          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_reconciliation_case_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_reconciliation_case_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_reconciliation_case_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_reconciliation_case         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec06_idempotency_record

QUÉ REPRESENTA — Registro durable de idempotencia con lease.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**   | **PK/FK** | **Descripción**               | **Ejemplo**       |
|-----------------|---------------------|----------|---------------|-----------|-------------------------------|-------------------|
| tenant_id       | uuid                | NO       | —             | PK\*      | Tenant.                       | 8a6…              |
| idempotency_key | varchar(160)        | NO       | —             | PK        | Key.                          | …                 |
| command_scope   | varchar(120)        | NO       | —             | PK        | Scope.                        | …                 |
| request_hash    | varchar(128)        | NO       | —             | —         | Hash payload.                 | …                 |
| state           | varchar(24)         | NO       | 'IN_PROGRESS' | CHECK     | IN_PROGRESS/SUCCEEDED/FAILED. | …                 |
| owner_id        | varchar(120)        | YES      | NULL          | —         | Worker owner.                 | …                 |
| lease_until     | timestamptz         | YES      | NULL          | —         | Lease.                        | 2026-09-10T18:00Z |
| response_code   | integer             | YES      | NULL          | —         | HTTP code.                    | 15                |
| response_body   | jsonb               | YES      | NULL          | CHECK     | Response bounded.             | {…}               |
| created_at      | timestamptz         | NO       | now()         | —         | Creación.                     | 2026-09-10T18:00Z |
| updated_at      | timestamptz         | NO       | now()         | —         | Heartbeat.                    | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**idempotency_key —** Key. Es obligatorio; default físico —.

**command_scope —** Scope. Es obligatorio; default físico —.

**request_hash —** Hash payload. Es obligatorio; default físico —.

**state —** IN_PROGRESS/SUCCEEDED/FAILED. Es obligatorio; default físico 'IN_PROGRESS'.

**owner_id —** Worker owner. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**lease_until —** Lease. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**response_code —** HTTP code. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**response_body —** Response bounded. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. El JSON se valida por schema/size; no se usa como escape para evitar modelado relacional.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**updated_at —** Heartbeat. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|-------------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_idempotency_record          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_idempotency_record_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_idempotency_record_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_idempotency_record_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_idempotency_record         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.16 ec06_outbox_event

QUÉ REPRESENTA — Outbox atómica multi-instancia.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                | **Ejemplo**       |
|-----------------|---------------------|----------|-------------------|-----------|--------------------------------|-------------------|
| tenant_id       | uuid                | NO       | —                 | PK\*      | Tenant.                        | 8a6…              |
| event_id        | uuid                | NO       | gen_random_uuid() | PK        | ID.                            | 8a6…              |
| aggregate_type  | varchar(80)         | NO       | —                 | —         | Tipo.                          | …                 |
| aggregate_id    | uuid                | NO       | —                 | —         | Aggregate.                     | 8a6…              |
| event_type      | varchar(120)        | NO       | —                 | —         | Evento.                        | …                 |
| schema_version  | varchar(32)         | NO       | '1.0'             | —         | Schema.                        | …                 |
| payload         | jsonb               | NO       | —                 | CHECK     | Payload.                       | {…}               |
| correlation_id  | uuid                | NO       | —                 | —         | Correlation.                   | 8a6…              |
| causation_id    | uuid                | YES      | NULL              | —         | Causation.                     | 8a6…              |
| occurred_at     | timestamptz         | NO       | now()             | —         | Occurred.                      | 2026-09-10T18:00Z |
| status          | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/SENT/FAILED. | …                 |
| owner_id        | varchar(120)        | YES      | NULL              | —         | Claim owner.                   | …                 |
| lease_until     | timestamptz         | YES      | NULL              | —         | Lease.                         | 2026-09-10T18:00Z |
| attempts        | integer             | NO       | 0                 | CHECK     | Retries.                       | 15                |
| next_attempt_at | timestamptz         | YES      | NULL              | —         | Backoff.                       | 2026-09-10T18:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**event_id —** ID. Es obligatorio; default físico gen_random_uuid().

**aggregate_type —** Tipo. Es obligatorio; default físico —.

**aggregate_id —** Aggregate. Es obligatorio; default físico —.

**event_type —** Evento. Es obligatorio; default físico —.

**schema_version —** Schema. Es obligatorio; default físico '1.0'.

**payload —** Payload. Es obligatorio; default físico —. El JSON se valida por schema/size; no se usa como escape para evitar modelado relacional.

**correlation_id —** Correlation. Es obligatorio; default físico —.

**causation_id —** Causation. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**occurred_at —** Occurred. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**status —** PENDING/IN_FLIGHT/SENT/FAILED. Es obligatorio; default físico 'PENDING'.

**owner_id —** Claim owner. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**lease_until —** Lease. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**attempts —** Retries. Es obligatorio; default físico 0.

**next_attempt_at —** Backoff. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

### Constraints físicos implementables

| **Nombre físico**             | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|-------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_outbox_event          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_outbox_event_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_outbox_event_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_outbox_event_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_outbox_event         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.17 ec06_inbox_message

QUÉ REPRESENTA — Inbox dedup de mensajes externos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**    | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**            | **Ejemplo**       |
|--------------|---------------------|----------|-------------|-----------|----------------------------|-------------------|
| tenant_id    | uuid                | NO       | —           | PK\*      | Tenant.                    | 8a6…              |
| message_id   | uuid                | NO       | —           | PK        | Message ID.                | 8a6…              |
| source       | varchar(120)        | NO       | —           | —         | Origen.                    | …                 |
| message_type | varchar(120)        | NO       | —           | —         | Tipo.                      | …                 |
| payload_hash | varchar(128)        | NO       | —           | —         | Hash.                      | …                 |
| received_at  | timestamptz         | NO       | now()       | —         | Recepción.                 | 2026-09-10T18:00Z |
| processed_at | timestamptz         | YES      | NULL        | —         | Procesado.                 | 2026-09-10T18:00Z |
| status       | varchar(24)         | NO       | 'RECEIVED'  | CHECK     | RECEIVED/PROCESSED/FAILED. | …                 |
| error_code   | varchar(120)        | YES      | NULL        | —         | Error estable.             | …                 |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**message_id —** Message ID. Es obligatorio; default físico —.

**source —** Origen. Es obligatorio; default físico —.

**message_type —** Tipo. Es obligatorio; default físico —.

**payload_hash —** Hash. Es obligatorio; default físico —.

**received_at —** Recepción. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**processed_at —** Procesado. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Se persiste en UTC; timezone solo para interpretación/presentación.

**status —** RECEIVED/PROCESSED/FAILED. Es obligatorio; default físico 'RECEIVED'.

**error_code —** Error estable. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

### Constraints físicos implementables

| **Nombre físico**              | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|--------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_inbox_message          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_inbox_message_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_inbox_message_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_inbox_message_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_inbox_message         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.18 ec06_operation_status

QUÉ REPRESENTA — Estado consultable de operación asíncrona.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La fila participa dentro del bounded context EC-06 y se crea/modifica solo mediante casos de uso de intención. Las referencias externas se validan por ports/adapters y receipts; las relaciones internas usan tenant_id en sus claves para impedir cruces lógicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la semántica local, la reconstructibilidad y la frontera de ownership. No convierte referencias externas en propiedad local ni autoriza shortcuts que dupliquen CT/EC ajenos.

| **Campo**        | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                  | **Ejemplo**       |
|------------------|---------------------|----------|-------------------|-----------|--------------------------------------------------|-------------------|
| tenant_id        | uuid                | NO       | —                 | PK\*      | Tenant.                                          | 8a6…              |
| operation_id     | uuid                | NO       | gen_random_uuid() | PK        | ID.                                              | 8a6…              |
| operation_type   | varchar(80)         | NO       | —                 | —         | Tipo.                                            | …                 |
| resource_ref     | uuid                | YES      | NULL              | —         | Recurso.                                         | 8a6…              |
| state            | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT. | …                 |
| progress_percent | numeric(5,2)        | YES      | NULL              | CHECK     | 0..100.                                          | 75.00             |
| result_ref       | uuid                | YES      | NULL              | —         | Resultado.                                       | 8a6…              |
| problem_code     | varchar(120)        | YES      | NULL              | —         | Reason.                                          | …                 |
| created_at       | timestamptz         | NO       | now()             | —         | Creación.                                        | 2026-09-10T18:00Z |
| updated_at       | timestamptz         | NO       | now()             | —         | Actualización.                                   | 2026-09-10T18:00Z |
| version          | bigint              | NO       | 0                 | —         | Lock.                                            | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; default físico —. Nunca se acepta desde body libre; proviene del TenantContext autorizado y participa en RLS.

**operation_id —** ID. Es obligatorio; default físico gen_random_uuid().

**operation_type —** Tipo. Es obligatorio; default físico —.

**resource_ref —** Recurso. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**state —** PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT. Es obligatorio; default físico 'PENDING'.

**progress_percent —** 0..100. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**result_ref —** Resultado. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL. Cuando la autoridad es otro bounded context se trata como EXT REF y no se crea FK cross-context.

**problem_code —** Reason. Puede ser NULL cuando la ausencia tiene semántica documentada; default físico NULL.

**created_at —** Creación. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**updated_at —** Actualización. Es obligatorio; default físico now(). Se persiste en UTC; timezone solo para interpretación/presentación.

**version —** Lock. Es obligatorio; default físico 0. Se mapea con @Version/ETag; versión obsoleta produce 412 PRECONDITION_FAILED.

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo**        | **Definición/expresión**                       | **Error que impide**                                         |
|-----------------------------------|-----------------|------------------------------------------------|--------------------------------------------------------------|
| pk_ec06_operation_status          | PK              | (tenant_id, id lógico correspondiente)         | Evita identidad duplicada y cruces de tenant.                |
| fk_ec06_operation_status_internal | FK tenant-aware | Solo cuando referencia tabla EC-06             | Evita relaciones internas cross-tenant/scope.                |
| ck_ec06_operation_status_domain   | CHECK           | Estados, rangos, fechas y pares coherentes     | Evita valores físicamente imposibles.                        |
| ix_ec06_operation_status_lookup   | INDEX           | tenant_id + claves de consulta                 | Evita scans y soporta SLO.                                   |
| rls_ec06_operation_status         | RLS             | ENABLE + FORCE; tenant_id=current_setting(...) | Impide lectura/escritura cross-tenant por bug de repository. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? — Estados imposibles, referencias internas cross-tenant, duplicados lógicos, rangos inválidos y cualquier mutación destructiva de hechos/receipts que deban ser históricos.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 13. DDL PostgreSQL completo — Flyway Ready

El siguiente baseline es implementable y debe separarse en migraciones expand/contract. Los nombres pueden distribuirse en V1\_\_schema.sql, V2\_\_core.sql, V3\_\_constraints.sql, V4\_\_rls.sql y V5\_\_triggers.sql manteniendo el contrato.

```
CREATE SCHEMA IF NOT EXISTS ec06;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE ec06.attendance_register (
tenant_id uuid NOT NULL,
attendance_register_id uuid NOT NULL DEFAULT gen_random_uuid(),
session_ref uuid NOT NULL,
edition_ref uuid NOT NULL,
cohort_ref uuid NULL,
attendance_policy_ref uuid NOT NULL,
engagement_policy_ref uuid NULL,
planned_start_at timestamptz NOT NULL,
planned_end_at timestamptz NOT NULL,
timezone_id varchar(64) NOT NULL,
state varchar(24) NOT NULL DEFAULT 'DRAFT',
opened_at timestamptz NULL,
locked_at timestamptz NULL,
policy_snapshot_hash varchar(128) NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
version bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec06_attendance_register PRIMARY KEY (tenant_id, attendance_register_id),
CONSTRAINT uq_ec06_register_session UNIQUE (tenant_id, session_ref),
CONSTRAINT ck_ec06_register_time CHECK (planned_end_at > planned_start_at),
CONSTRAINT ck_ec06_register_state CHECK (state IN ('DRAFT','OPEN','CLOSING','LOCKED','CANCELLED'))
);

CREATE TABLE ec06.register_roster_entry (
tenant_id uuid NOT NULL,
roster_entry_id uuid NOT NULL DEFAULT gen_random_uuid(),
attendance_register_id uuid NOT NULL,
enrollment_ref uuid NOT NULL,
person_ref uuid NOT NULL,
participant_ref uuid NULL,
eligibility_snapshot_ref uuid NULL,
roster_state varchar(24) NOT NULL DEFAULT 'ELIGIBLE',
source_batch_ref uuid NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec06_roster PRIMARY KEY (tenant_id, roster_entry_id),
CONSTRAINT fk_ec06_roster_register FOREIGN KEY (tenant_id, attendance_register_id)
REFERENCES ec06.attendance_register(tenant_id, attendance_register_id),
CONSTRAINT uq_ec06_roster_enrollment UNIQUE (tenant_id, attendance_register_id, enrollment_ref),
CONSTRAINT ck_ec06_roster_state CHECK (roster_state IN ('ELIGIBLE','INELIGIBLE','WITHDRAWN','TRANSFERRED'))
);

CREATE TABLE ec06.checkin_token (
tenant_id uuid NOT NULL,
checkin_token_id uuid NOT NULL DEFAULT gen_random_uuid(),
attendance_register_id uuid NOT NULL,
token_hash varchar(128) NOT NULL,
nonce uuid NOT NULL DEFAULT gen_random_uuid(),
issued_at timestamptz NOT NULL DEFAULT now(),
expires_at timestamptz NOT NULL,
single_use boolean NOT NULL DEFAULT true,
state varchar(20) NOT NULL DEFAULT 'ISSUED',
consumed_at timestamptz NULL,
issuer_subject uuid NOT NULL,
version bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec06_checkin_token PRIMARY KEY (tenant_id, checkin_token_id),
CONSTRAINT fk_ec06_checkin_token_register FOREIGN KEY (tenant_id, attendance_register_id)
REFERENCES ec06.attendance_register(tenant_id, attendance_register_id),
CONSTRAINT uq_ec06_checkin_token_hash UNIQUE (tenant_id, token_hash),
CONSTRAINT uq_ec06_checkin_nonce UNIQUE (tenant_id, nonce),
CONSTRAINT ck_ec06_checkin_ttl CHECK (expires_at > issued_at),
CONSTRAINT ck_ec06_checkin_state CHECK (state IN ('ISSUED','CONSUMED','EXPIRED','REVOKED'))
);

CREATE TABLE ec06.attendance_event (
tenant_id uuid NOT NULL,
attendance_event_id uuid NOT NULL DEFAULT gen_random_uuid(),
attendance_register_id uuid NOT NULL,
roster_entry_id uuid NULL,
event_kind varchar(40) NOT NULL,
source_kind varchar(40) NOT NULL,
source_authority_ref uuid NULL,
source_event_id varchar(160) NULL,
occurred_at timestamptz NOT NULL,
received_at timestamptz NOT NULL DEFAULT now(),
event_value jsonb NULL,
quality_code varchar(40) NULL,
evidence_ref uuid NULL,
correlation_id uuid NOT NULL DEFAULT gen_random_uuid(),
causation_id uuid NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec06_attendance_event PRIMARY KEY (tenant_id, attendance_event_id),
CONSTRAINT fk_ec06_event_register FOREIGN KEY (tenant_id, attendance_register_id)
REFERENCES ec06.attendance_register(tenant_id, attendance_register_id),
CONSTRAINT fk_ec06_event_roster FOREIGN KEY (tenant_id, roster_entry_id)
REFERENCES ec06.register_roster_entry(tenant_id, roster_entry_id),
CONSTRAINT ck_ec06_event_kind CHECK (event_kind IN ('CHECK_IN','CHECK_OUT','MANUAL_MARK','EXTERNAL_PRESENCE','ENGAGEMENT_SIGNAL','CORRECTION_SIGNAL')),
CONSTRAINT ck_ec06_source_kind CHECK (source_kind IN ('INSTRUCTOR','QR','MOBILE','KIOSK','CT18','IMPORT','SYSTEM')),
CONSTRAINT ck_ec06_event_value_object CHECK (event_value IS NULL OR jsonb_typeof(event_value)='object')
);
CREATE UNIQUE INDEX uq_ec06_event_source_id ON ec06.attendance_event(tenant_id, source_kind, source_event_id) WHERE source_event_id IS NOT NULL;
CREATE INDEX ix_ec06_event_register_roster_time ON ec06.attendance_event(tenant_id, attendance_register_id, roster_entry_id, occurred_at);

CREATE TABLE ec06.attendance_adjudication (
tenant_id uuid NOT NULL,
adjudication_id uuid NOT NULL DEFAULT gen_random_uuid(),
attendance_register_id uuid NOT NULL,
roster_entry_id uuid NOT NULL,
adjudication_no integer NOT NULL,
previous_adjudication_id uuid NULL,
policy_ref uuid NOT NULL,
policy_snapshot_hash varchar(128) NOT NULL,
input_hash varchar(128) NOT NULL,
result_status varchar(32) NOT NULL,
calculation_trace_hash varchar(128) NOT NULL,
trigger_reason_code varchar(80) NOT NULL,
created_by_subject uuid NOT NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec06_adjudication PRIMARY KEY (tenant_id, adjudication_id),
CONSTRAINT fk_ec06_adj_register FOREIGN KEY (tenant_id, attendance_register_id) REFERENCES ec06.attendance_register(tenant_id, attendance_register_id),
CONSTRAINT fk_ec06_adj_roster FOREIGN KEY (tenant_id, roster_entry_id) REFERENCES ec06.register_roster_entry(tenant_id, roster_entry_id),
CONSTRAINT fk_ec06_adj_prev FOREIGN KEY (tenant_id, previous_adjudication_id) REFERENCES ec06.attendance_adjudication(tenant_id, adjudication_id),
CONSTRAINT uq_ec06_adj_no UNIQUE (tenant_id, attendance_register_id, roster_entry_id, adjudication_no),
CONSTRAINT ck_ec06_adj_no CHECK (adjudication_no > 0),
CONSTRAINT ck_ec06_adj_status CHECK (result_status IN ('PROVISIONAL','OFFICIAL','RESTATED','VOID'))
);

CREATE TABLE ec06.official_attendance_fact (
tenant_id uuid NOT NULL,
attendance_fact_id uuid NOT NULL DEFAULT gen_random_uuid(),
attendance_register_id uuid NOT NULL,
roster_entry_id uuid NOT NULL,
adjudication_id uuid NOT NULL,
fact_version_no integer NOT NULL,
previous_fact_id uuid NULL,
attendance_status_code varchar(48) NOT NULL,
eligible_minutes integer NOT NULL,
attended_minutes integer NOT NULL,
attendance_ratio numeric(7,6) NULL,
late_minutes integer NOT NULL DEFAULT 0,
early_leave_minutes integer NOT NULL DEFAULT 0,
excused boolean NOT NULL DEFAULT false,
current_flag boolean NOT NULL DEFAULT true,
official_at timestamptz NULL,
reason_code varchar(80) NULL,
evidence_summary_hash varchar(128) NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec06_fact PRIMARY KEY (tenant_id, attendance_fact_id),
CONSTRAINT fk_ec06_fact_register FOREIGN KEY (tenant_id, attendance_register_id) REFERENCES ec06.attendance_register(tenant_id, attendance_register_id),
CONSTRAINT fk_ec06_fact_roster FOREIGN KEY (tenant_id, roster_entry_id) REFERENCES ec06.register_roster_entry(tenant_id, roster_entry_id),
CONSTRAINT fk_ec06_fact_adj FOREIGN KEY (tenant_id, adjudication_id) REFERENCES ec06.attendance_adjudication(tenant_id, adjudication_id),
CONSTRAINT fk_ec06_fact_prev FOREIGN KEY (tenant_id, previous_fact_id) REFERENCES ec06.official_attendance_fact(tenant_id, attendance_fact_id),
CONSTRAINT uq_ec06_fact_version UNIQUE (tenant_id, attendance_register_id, roster_entry_id, fact_version_no),
CONSTRAINT ck_ec06_fact_minutes CHECK (eligible_minutes >= 0 AND attended_minutes >= 0 AND attended_minutes <= eligible_minutes),
CONSTRAINT ck_ec06_fact_ratio CHECK (attendance_ratio IS NULL OR (attendance_ratio >= 0 AND attendance_ratio <= 1)),
CONSTRAINT ck_ec06_fact_late CHECK (late_minutes >= 0 AND early_leave_minutes >= 0)
);
CREATE UNIQUE INDEX uq_ec06_fact_current ON ec06.official_attendance_fact(tenant_id, attendance_register_id, roster_entry_id) WHERE current_flag;

CREATE TABLE ec06.attendance_adjustment (
tenant_id uuid NOT NULL,
attendance_adjustment_id uuid NOT NULL DEFAULT gen_random_uuid(),
attendance_fact_id uuid NOT NULL,
requested_status_code varchar(48) NULL,
requested_attended_minutes integer NULL,
reason_code varchar(80) NOT NULL,
reason_text varchar(800) NULL,
evidence_ref uuid NULL,
workflow_ref uuid NULL,
state varchar(24) NOT NULL DEFAULT 'DRAFT',
requested_by_subject uuid NOT NULL,
decided_by_subject uuid NULL,
decided_at timestamptz NULL,
applied_fact_id uuid NULL,
created_at timestamptz NOT NULL DEFAULT now(),
version bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec06_adjustment PRIMARY KEY (tenant_id, attendance_adjustment_id),
CONSTRAINT fk_ec06_adjustment_fact FOREIGN KEY (tenant_id, attendance_fact_id) REFERENCES ec06.official_attendance_fact(tenant_id, attendance_fact_id),
CONSTRAINT fk_ec06_adjustment_applied FOREIGN KEY (tenant_id, applied_fact_id) REFERENCES ec06.official_attendance_fact(tenant_id, attendance_fact_id),
CONSTRAINT ck_ec06_adjustment_minutes CHECK (requested_attended_minutes IS NULL OR requested_attended_minutes >= 0),
CONSTRAINT ck_ec06_adjustment_state CHECK (state IN ('DRAFT','SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','CANCELLED'))
);

CREATE TABLE ec06.external_telemetry_receipt (
tenant_id uuid NOT NULL,
external_receipt_id uuid NOT NULL DEFAULT gen_random_uuid(),
source_system_ref uuid NOT NULL,
source_batch_id varchar(160) NOT NULL,
schema_version varchar(40) NOT NULL,
payload_hash varchar(128) NOT NULL,
event_count integer NOT NULL DEFAULT 0,
received_at timestamptz NOT NULL DEFAULT now(),
status varchar(24) NOT NULL DEFAULT 'RECEIVED',
correlation_id uuid NOT NULL DEFAULT gen_random_uuid(),
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec06_external_receipt PRIMARY KEY (tenant_id, external_receipt_id),
CONSTRAINT uq_ec06_external_batch UNIQUE (tenant_id, source_system_ref, source_batch_id),
CONSTRAINT ck_ec06_external_count CHECK (event_count >= 0),
CONSTRAINT ck_ec06_external_status CHECK (status IN ('RECEIVED','APPLIED','PARTIAL','REJECTED','UNKNOWN_EFFECT'))
);

CREATE TABLE ec06.offline_capture_batch (
tenant_id uuid NOT NULL,
offline_batch_id uuid NOT NULL DEFAULT gen_random_uuid(),
attendance_register_id uuid NOT NULL,
device_registration_ref uuid NOT NULL,
client_batch_id uuid NOT NULL,
payload_hash varchar(128) NOT NULL,
signature_ref varchar(256) NOT NULL,
client_created_at timestamptz NOT NULL,
received_at timestamptz NULL,
clock_drift_seconds integer NULL,
event_count integer NOT NULL DEFAULT 0,
state varchar(24) NOT NULL DEFAULT 'CREATED',
apply_receipt_hash varchar(128) NULL,
created_at timestamptz NOT NULL DEFAULT now(),
version bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec06_offline_batch PRIMARY KEY (tenant_id, offline_batch_id),
CONSTRAINT fk_ec06_offline_register FOREIGN KEY (tenant_id, attendance_register_id) REFERENCES ec06.attendance_register(tenant_id, attendance_register_id),
CONSTRAINT uq_ec06_offline_client_batch UNIQUE (tenant_id, device_registration_ref, client_batch_id),
CONSTRAINT ck_ec06_offline_count CHECK (event_count >= 0),
CONSTRAINT ck_ec06_offline_state CHECK (state IN ('CREATED','UPLOADING','RECEIVED','VALIDATED','APPLIED','REJECTED','RECONCILING'))
);

CREATE TABLE ec06.idempotency_record (
tenant_id uuid NOT NULL,
idempotency_key varchar(160) NOT NULL,
command_scope varchar(120) NOT NULL,
request_hash varchar(128) NOT NULL,
state varchar(24) NOT NULL DEFAULT 'IN_PROGRESS',
owner_id varchar(120) NULL,
lease_until timestamptz NULL,
response_code integer NULL,
response_body jsonb NULL,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec06_idempotency PRIMARY KEY (tenant_id, idempotency_key, command_scope),
CONSTRAINT ck_ec06_idempotency_state CHECK (state IN ('IN_PROGRESS','SUCCEEDED','FAILED')),
CONSTRAINT ck_ec06_idempotency_body CHECK (response_body IS NULL OR jsonb_typeof(response_body) IN ('object','array'))
);

CREATE TABLE ec06.outbox_event (
tenant_id uuid NOT NULL,
event_id uuid NOT NULL DEFAULT gen_random_uuid(),
aggregate_type varchar(80) NOT NULL,
aggregate_id uuid NOT NULL,
event_type varchar(120) NOT NULL,
schema_version varchar(32) NOT NULL DEFAULT '1.0',
payload jsonb NOT NULL,
correlation_id uuid NOT NULL,
causation_id uuid NULL,
occurred_at timestamptz NOT NULL DEFAULT now(),
status varchar(24) NOT NULL DEFAULT 'PENDING',
owner_id varchar(120) NULL,
lease_until timestamptz NULL,
attempts integer NOT NULL DEFAULT 0,
next_attempt_at timestamptz NULL,
CONSTRAINT pk_ec06_outbox PRIMARY KEY (tenant_id, event_id),
CONSTRAINT ck_ec06_outbox_status CHECK (status IN ('PENDING','IN_FLIGHT','SENT','FAILED')),
CONSTRAINT ck_ec06_outbox_attempts CHECK (attempts >= 0),
CONSTRAINT ck_ec06_outbox_payload CHECK (jsonb_typeof(payload)='object')
);
CREATE INDEX ix_ec06_outbox_claim ON ec06.outbox_event(status, next_attempt_at, occurred_at) WHERE status IN ('PENDING','FAILED');

CREATE TABLE ec06.inbox_message (
tenant_id uuid NOT NULL,
message_id uuid NOT NULL,
source varchar(120) NOT NULL,
message_type varchar(120) NOT NULL,
payload_hash varchar(128) NOT NULL,
received_at timestamptz NOT NULL DEFAULT now(),
processed_at timestamptz NULL,
status varchar(24) NOT NULL DEFAULT 'RECEIVED',
error_code varchar(120) NULL,
CONSTRAINT pk_ec06_inbox PRIMARY KEY (tenant_id, message_id),
CONSTRAINT ck_ec06_inbox_status CHECK (status IN ('RECEIVED','PROCESSED','FAILED'))
);

CREATE TABLE ec06.operation_status (
tenant_id uuid NOT NULL,
operation_id uuid NOT NULL DEFAULT gen_random_uuid(),
operation_type varchar(80) NOT NULL,
resource_ref uuid NULL,
state varchar(24) NOT NULL DEFAULT 'PENDING',
progress_percent numeric(5,2) NULL,
result_ref uuid NULL,
problem_code varchar(120) NULL,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
version bigint NOT NULL DEFAULT 0,
CONSTRAINT pk_ec06_operation PRIMARY KEY (tenant_id, operation_id),
CONSTRAINT ck_ec06_operation_state CHECK (state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT')),
CONSTRAINT ck_ec06_operation_progress CHECK (progress_percent IS NULL OR (progress_percent >= 0 AND progress_percent <= 100))
);
```

## 13.1 RLS defense-in-depth

```
ALTER TABLE ec06.attendance_register ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec06.attendance_register FORCE ROW LEVEL SECURITY;
CREATE POLICY p_ec06_register_tenant ON ec06.attendance_register
USING (tenant_id = current_setting('peopleu.tenant_id', true)::uuid)
WITH CHECK (tenant_id = current_setting('peopleu.tenant_id', true)::uuid);
-- Aplicar patrón equivalente a toda tabla tenant-owned.
-- HTTP runtime role: NO table owner, NO BYPASSRLS. Migrator role separado.
```

## 13.2 Triggers defensivos

```
CREATE OR REPLACE FUNCTION ec06.fn_append_only() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
RAISE EXCEPTION 'APPEND_ONLY_RESOURCE' USING ERRCODE='check_violation';
END $$;
CREATE TRIGGER trg_ec06_event_append_only BEFORE UPDATE OR DELETE ON ec06.attendance_event
FOR EACH ROW EXECUTE FUNCTION ec06.fn_append_only();
CREATE TRIGGER trg_ec06_receipt_append_only BEFORE UPDATE OR DELETE ON ec06.external_telemetry_receipt
FOR EACH ROW EXECUTE FUNCTION ec06.fn_append_only();

-- El service transaccional de adjudicación debe:
-- 1) bloquear current fact; 2) set current_flag=false; 3) insertar nueva versión;
-- 4) guardar audit/outbox en la misma transacción.
```

## 13.3 Outbox claim multi-instancia

```
WITH picked AS (
SELECT tenant_id, event_id FROM ec06.outbox_event
WHERE status IN ('PENDING','FAILED') AND (next_attempt_at IS NULL OR next_attempt_at <= now())
ORDER BY occurred_at
FOR UPDATE SKIP LOCKED LIMIT :batchSize
)
UPDATE ec06.outbox_event o
SET status='IN_FLIGHT', owner_id=:workerId, lease_until=now()+interval '60 seconds', attempts=attempts+1
FROM picked p
WHERE o.tenant_id=p.tenant_id AND o.event_id=p.event_id
RETURNING o.*;
```

# 14. MongoDB y Redis

PostgreSQL es Source of Truth. MongoDB solo puede hospedar read models derivados — por ejemplo timelines compactas para dashboards — si existe justificación operativa y reconstrucción desde eventos/facts. Redis solo acelera, nunca decide attendance.

| **Tecnología** | **Uso permitido**                                                                     | **Uso prohibido**                         | **TTL/consistencia**                          |
|----------------|---------------------------------------------------------------------------------------|-------------------------------------------|-----------------------------------------------|
| MongoDB        | Read model de timeline, analytics operational snapshot                                | Raw authoritative events/facts            | Rebuildable; eventual consistency explícita.  |
| Redis          | Cache de policy, ephemeral token metadata, rate-limit counters, short technical locks | Fact oficial, roster o evidence authority | TTL corto; cache-miss recupera PostgreSQL/CT. |
| Redis Streams  | Solo si baseline de CT-09 lo aprueba para transporte interno no autoritativo          | Reemplazar outbox DB                      | Outbox sigue source durable.                  |

# 15. Backend Java 21 / Spring Boot / Spring Modulith

El módulo se implementa como módulo Spring Modulith con hexagonal architecture. El dominio no depende de JPA, CT-18 ni UI. Los adapters encapsulan persistencia, IAM/TenantContext, policies CT-02 y telemetría externa.

```
com.peopleu.ec06
domain/
attendance/ register/ adjudication/ adjustment/ offline/ reconciliation/
application/
command/ query/ port/in/ port/out/ service/
adapter/
in/web/ in/messaging/ out/persistence/ out/ct02/ out/ct18/ out/ct05/
config/
```

## 15.1 Servicios de aplicación obligatorios

- OpenAttendanceRegisterService

- RecordAttendanceSignalService

- AdjudicateAttendanceService

- SyncOfflineBatchService

- ApplyAttendanceAdjustmentService

- LockAttendanceRegisterService

- ReconcileExternalTelemetryService

- RestateAttendanceService

- ExportAttendanceEvidenceService

- OutboxDispatcher

- IdempotencyCoordinator

## 15.2 Repositorios

Los repositories exponen aggregates y consultas tenant-scoped. Ningún repository recibe tenant_id desde controller payload. La transacción establece TenantContext DB y usa runtime role sujeto a RLS. Raw event repository expone append exclusivamente.

## 15.3 Aggregate revision e idempotencia

Comandos que cambian register/fact/adjustment usan If-Match. Check-in ingest se controla por Idempotency-Key/source_event_id y puede disparar adjudicación separada. Se debe evitar lock de register completo para eventos de participantes distintos; la contención se mantiene por participant/current fact.

# 16. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

| **Método** | **Ruta**                                                    | **Propósito**            | **Idempotencia** | **Concurrency** | **HTTP** |
|------------|-------------------------------------------------------------|--------------------------|------------------|-----------------|----------|
| POST       | /api/ec06/registers                                         | Crear register           | Idempotency-Key  | —               | 201      |
| POST       | /api/ec06/registers/{id}/open                               | Abrir                    | Idempotency-Key  | If-Match        | 200      |
| GET        | /api/ec06/registers                                         | Listar/paginar           | —                | —               | 200      |
| GET        | /api/ec06/registers/{id}                                    | Detalle                  | —                | —               | 200      |
| POST       | /api/ec06/registers/{id}/roster:sync                        | Sincronizar roster EC-04 | Idempotency-Key  | If-Match        | 202      |
| POST       | /api/ec06/registers/{id}/tokens                             | Emitir challenge         | Idempotency-Key  | If-Match        | 201      |
| POST       | /api/ec06/check-ins                                         | Check-in                 | Idempotency-Key  | —               | 200      |
| POST       | /api/ec06/check-outs                                        | Check-out                | Idempotency-Key  | —               | 200      |
| POST       | /api/ec06/registers/{id}/manual-marks                       | Marca manual             | Idempotency-Key  | If-Match        | 201      |
| POST       | /api/ec06/registers/{id}/events:ingest                      | Ingest técnico           | Idempotency-Key  | —               | 202      |
| GET        | /api/ec06/registers/{id}/participants                       | Roster + facts           | —                | —               | 200      |
| GET        | /api/ec06/registers/{id}/participants/{rosterId}/timeline   | Timeline                 | —                | —               | 200      |
| POST       | /api/ec06/registers/{id}/participants/{rosterId}:adjudicate | Adjudicar                | Idempotency-Key  | If-Match        | 200      |
| POST       | /api/ec06/registers/{id}:lock                               | Lock register            | Idempotency-Key  | If-Match        | 200      |
| POST       | /api/ec06/facts/{id}/adjustments                            | Solicitar ajuste         | Idempotency-Key  | If-Match        | 201      |
| POST       | /api/ec06/adjustments/{id}:submit                           | Submit                   | Idempotency-Key  | If-Match        | 200      |
| POST       | /api/ec06/adjustments/{id}:apply                            | Aplicar aprobado         | Idempotency-Key  | If-Match        | 200      |
| POST       | /api/ec06/offline-batches                                   | Crear/upload batch       | Idempotency-Key  | —               | 202      |
| GET        | /api/ec06/operations/{id}                                   | OperationStatus          | —                | —               | 200      |
| POST       | /api/ec06/reconciliations/{id}:run                          | Reconciliar              | Idempotency-Key  | If-Match        | 202      |
| GET        | /api/ec06/reports/attendance                                | Reporte paginado         | —                | —               | 200      |

## 16.1 ProblemDetail y reason codes

| **HTTP** | **Reason code**             | **Semántica**                                                       |
|----------|-----------------------------|---------------------------------------------------------------------|
| 400      | INVALID_REQUEST             | Formato/semántica básica inválida.                                  |
| 401      | UNAUTHENTICATED             | No principal.                                                       |
| 403      | ATTENDANCE_SCOPE_DENIED     | Sin scope/ABAC.                                                     |
| 404      | REGISTER_NOT_FOUND          | No visible en tenant.                                               |
| 409      | IDEMPOTENCY_KEY_REUSED      | Misma key/payload distinto.                                         |
| 409      | TOKEN_REPLAYED              | Challenge ya consumido.                                             |
| 409      | REGISTER_LOCKED             | Captura ordinaria prohibida.                                        |
| 412      | AGGREGATE_VERSION_MISMATCH  | ETag obsoleto.                                                      |
| 422      | ATTENDANCE_WINDOW_VIOLATION | Fuera de ventana sin override.                                      |
| 422      | OFFLINE_SIGNATURE_INVALID   | Batch no confiable.                                                 |
| 422      | CLOCK_DRIFT_EXCEEDED        | Drift fuera de policy.                                              |
| 429      | CHECKIN_RATE_LIMITED        | Protección anti-abuso.                                              |
| 503      | DEPENDENCY_UNAVAILABLE      | CT crítico caído.                                                   |
| 503      | REMOTE_EFFECT_UNKNOWN       | Solo cuando contrato HTTP use 503 + OperationStatus UNKNOWN_EFFECT. |

# 17. Eventos, outbox/inbox y AsyncAPI

| **Evento**                        | **Publisher** | **Consumers**        | **Semántica**                 |
|-----------------------------------|---------------|----------------------|-------------------------------|
| AttendanceRegisterOpened          | EC-06         | EC-05/11/Ops         | Register listo.               |
| AttendanceSignalRecorded          | EC-06         | Internal/read models | Evento raw aceptado.          |
| AttendanceFactOfficialized        | EC-06         | EC-07/11             | Fact oficial consumible.      |
| AttendanceFactRestated            | EC-06         | EC-07/11/Audit       | Nueva versión por corrección. |
| AttendanceRegisterLocked          | EC-06         | EC-07/Ops            | Captura normal cerrada.       |
| AttendanceAdjustmentSubmitted     | EC-06         | CT-06                | Workflow.                     |
| OfflineBatchApplied               | EC-06         | Ops/analytics        | Sync completado.              |
| AttendanceReconciliationEscalated | EC-06         | Ops                  | Discrepancia no resuelta.     |

Todo evento incluye event_id, tenant_id, aggregate_id, schema_version, correlation_id, causation_id, occurred_at y payload. Los consumers usan inbox dedup. Breaking changes requieren nueva schema version y compatibility test.

# 18. Integraciones, resiliencia, reconciliación y UNKNOWN_EFFECT

| **Dependencia**  | **Timeout** | **Retry**                             | **CB**          | **Degradación**                       | **Reconciliation**                 |
|------------------|-------------|---------------------------------------|-----------------|---------------------------------------|------------------------------------|
| CT-18 LMS/video  | 3–5 s       | 2 retry con jitter solo GET/status    | Circuit breaker | PARTIAL/UNAVAILABLE                   | Receipt + source batch status.     |
| CT-05 evidence   | 3 s         | Solo operaciones idempotentes         | Circuit breaker | Guardar pending ref si policy permite | Reconciliar document_ref.          |
| CT-06 workflow   | 5 s         | No retry ciego si create pudo aplicar | Circuit breaker | UNKNOWN_EFFECT                        | Consultar workflow by correlation. |
| EC-04 enrollment | 2 s         | Read retry bounded                    | Circuit breaker | Fail closed para official participant | Cache versionado solo lectura.     |
| CT-02 policy     | 2 s         | Read retry bounded                    | Circuit breaker | Fail closed en officialize            | PolicyVersion cache pinneada.      |

| **UNKNOWN_EFFECT — Si PeopleU envía una operación remota, el proveedor la aplica y la respuesta se pierde, EC-06 no repite a ciegas. Persiste receipt/correlation, consulta estado remoto y solo reintenta cuando se demuestra NOT_APPLIED.** |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 19. Frontend Web enterprise por workspaces

| **Workspace**            | **Usuario**                      | **Layout/KPIs**                                                     | **Ruta**                     | **Componentes/acciones**                                 | **Estados**                                            |
|--------------------------|----------------------------------|---------------------------------------------------------------------|------------------------------|----------------------------------------------------------|--------------------------------------------------------|
| Attendance Console       | Instructor/Operator              | Roster central, status chips, timer, coverage KPI, source indicator | /ec/attendance/registers/:id | Bulk mark, QR, filter, timeline drawer, adjustment modal | NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT. |
| Attendance Operations    | Coordinator                      | Registers del día, pending cases, locks, external source health     | /ec/attendance/ops           | Open/close, reconcile, export, reassignment              | Dependency health visible.                             |
| Attendance Review Center | Approver/Auditor                 | Adjustments, contradictions, evidence, before/after                 | /ec/attendance/review        | Approve/reject, evidence drawer, audit tab               | Step-up/SoD banners.                                   |
| Evidence & Timeline      | Auditor                          | Chronological raw signals + adjudication versions                   | /ec/attendance/facts/:id     | Compare versions, provenance, receipt drilldown          | Read-only history.                                     |
| Offline Sync Center      | Instructor/Ops                   | Pending local batches, sync status, rejected events                 | /ec/attendance/offline       | Retry safe, inspect reason, escalate                     | Never show “synced” before receipt.                    |
| Corporate Attendance     | Authorized corporate coordinator | Scoped participant/aggregate report                                 | /ec/attendance/corporate     | Export governed                                          | Purpose/privacy restrictions.                          |

## 19.1 Reglas de UX obligatorias

- Nunca representar provider outage como 0 asistentes.

- Mostrar provenance/source badges en facts con discrepancia.

- Conflicto ETag abre rebase/reload; no overwrite.

- Bulk mark requiere preview, count, scope y confirmation.

- Ajuste muestra before/after, reason, evidence y workflow state.

- QR tiene alternativa accesible/manual.

- Operaciones async muestran OperationStatus y correlationId.

- Los filtros se codifican en URL para reproducibilidad de soporte.

- Client API se genera desde OpenAPI; prohibido DTO manual divergente.

# 20. Mobile

Mobile sí aplica y tiene alto valor en EC-06. Debe priorizar check-in, lista rápida del instructor, captura offline, evidencia ligera y consulta personal. No debe permitir restatement masivo, exportes sensibles ni administración global.

| **Actor**    | **Journeys**                                  | **Offline/Sync**                          | **Restricciones**                     |
|--------------|-----------------------------------------------|-------------------------------------------|---------------------------------------|
| Participante | Escanear QR / check-in alternativo            | Online; offline solo si policy específica | Receipt + status; no acceso a roster. |
| Instructor   | Abrir lista, marcar, justificar, sync offline | Offline-first bounded queue               | No aprobar su propio ajuste si SoD.   |
| Coordinator  | Consultar estado y alerts                     | Online                                    | No bulk destructive admin.            |
| Auditor      | No requerido                                  | —                                         | Web only por sensibilidad.            |

## 20.1 Offline contract

- Cifrar queue local y minimizar PII.

- Cada event tiene client_event_id, device_ref, client_occurred_at y signature metadata.

- Batch upload idempotente con client_batch_id.

- UI diferencia PENDING_LOCAL, SYNCING, CONFIRMED, REJECTED y NEEDS_REVIEW.

- Un logout/remote wipe aplica política de borrado local sin destruir hechos ya confirmados servidor.

# 21. Matriz Frontend / Backend / Mobile

| **Capacidad**         | **Frontend Web** | **Backend**                 | **Mobile**                 | **Regla**                 |
|-----------------------|------------------|-----------------------------|----------------------------|---------------------------|
| Abrir/cerrar register | Web              | Command service + ETag      | Instructor mobile limitado | Audit/outbox.             |
| Marcar asistencia     | Web              | Append event + adjudication | Sí                         | Idempotency/source dedup. |
| QR check-in           | Web genera       | Token + consume API         | Participant                | Anti-replay.              |
| Offline capture       | Status/ops       | Batch verify/apply          | Instructor                 | Signed batch.             |
| Adjustments           | Review center    | Workflow + fact restatement | Request only               | SoD/step-up.              |
| Evidence timeline     | Auditor          | Queries                     | Participant own only       | Privacy ABAC.             |
| Reconciliation        | Ops              | Case worker                 | No                         | UNKNOWN_EFFECT.           |
| Corporate report      | Web              | Scoped query/export         | No                         | Purpose limitation.       |

# 22. Seguridad: RBAC, ABAC, SoD, step-up y privacy

| **Rol**               | **Permisos**                   | **ABAC**                            | **SoD/Restricción**                  |
|-----------------------|--------------------------------|-------------------------------------|--------------------------------------|
| ATTENDANCE_INSTRUCTOR | Mark on assigned sessions      | Assigned instructor + edition scope | No approve own sensitive adjustment. |
| ATTENDANCE_OPERATOR   | Open/register/mark/reconcile   | Campus/sede scope                   | No policy admin.                     |
| ATTENDANCE_APPROVER   | Approve adjustment/restatement | Institutional scope + reason        | SoD from requester.                  |
| ATTENDANCE_AUDITOR    | Read facts/evidence lineage    | Purpose + case scope                | Read-only.                           |
| PARTICIPANT           | Own check-in/status            | subject==person_ref                 | No roster.                           |
| CORPORATE_VIEWER      | Authorized company report      | agreement/client scope + purpose    | No unrelated participants.           |
| OPS_WORKER            | Outbox/reconcile               | Technical principal                 | No interactive user privileges.      |

## 22.1 Threat Model EC-06

| **Amenaza**         | **Ataque**                      | **Mitigación**                                                                |
|---------------------|---------------------------------|-------------------------------------------------------------------------------|
| QR replay/share     | Token reuse/shared screenshot   | Nonce, TTL, one-time, optional participant/device binding, anomaly detection. |
| Cross-tenant IDOR   | Guess register/fact UUID        | RLS FORCE + scope authorization + opaque IDs.                                 |
| Fake offline events | Tampered local batch            | Device registration, signature/hash, drift, replay guard.                     |
| Instructor abuse    | Mass present without evidence   | Audit, bulk preview, thresholds, anomaly/review, SoD where required.          |
| Provider spoof      | Forged CT-18 payload            | Signed/authenticated adapter, schema validation, source authority.            |
| Event flood         | DoS on check-in                 | Rate limit, bounded payload, queue/backpressure.                              |
| Evidence disclosure | Sensitive image/document access | CT-05 access policy + field-level ABAC.                                       |
| Clock manipulation  | Client time backdating          | Server time authority + drift bounds.                                         |
| Mass assignment     | Body inject tenant/state        | DTO allowlist; tenant/state derived server-side.                              |
| Silent recompute    | Policy change rewrites history  | Policy pinning + restatement only.                                            |

## 22.2 Secure SDLC

CI/CD ejecuta SAST, SCA, secret scanning, SBOM, container image scan, dependency policy, API fuzzing básico, tenant isolation tests y threat-model verification. Findings High/Critical bloquean release salvo excepción formal con owner/expiry.

# 23. Auditoría, Evidence Pack, lineage y reason codes

Audit Trail crítico: open/lock/cancel register, manual mark fuera de window, bulk mark, adjustment submit/approve/apply, restatement, void, external receipt apply, offline batch apply, export y privacy-sensitive evidence access.

| **Campo mínimo**  | **Ejemplo**              | **Uso**         |
|-------------------|--------------------------|-----------------|
| tenant_id         | …                        | Scope.          |
| actor_subject     | usr…                     | Quién.          |
| action            | ATTENDANCE_FACT_RESTATED | Qué.            |
| resource          | fact…                    | Sobre qué.      |
| before/after refs | fact v2 → v3             | Lineage.        |
| reason_code       | DOCUMENTED_EXCEPTION     | Por qué.        |
| correlation_id    | …                        | Trazabilidad.   |
| policy_ref        | pol v7                   | Regla aplicada. |
| assurance         | MFA2                     | Step-up.        |
| evidence_refs     | doc…                     | Prueba.         |
| source_provenance | CT18 batch…              | Origen.         |

# 24. Observabilidad: logs, metrics, traces, SLI/SLO y performance

| **SLI**                   | **Medición**                         | **SLO**         | **Alerta**                            |
|---------------------------|--------------------------------------|-----------------|---------------------------------------|
| Check-in API availability | successful eligible requests / total | 99.95% mensual  | \<99.9% alert.                        |
| Check-in p95 latency      | server receive → receipt             | \<400 ms normal | \>800 ms 5m.                          |
| Manual mark p95           | command latency                      | \<500 ms        | \>1 s 5m.                             |
| External ingest lag       | received provider → local receipt    | p95 \<2 min     | \>5 min.                              |
| Adjudication lag          | signal accepted → fact current       | p95 \<30 s      | \>2 min.                              |
| Offline sync apply        | batch received → applied             | p95 \<60 s      | \>5 min.                              |
| Outbox delivery           | occurred → sent                      | p95 \<30 s      | \>2 min.                              |
| RLS denial                | cross-tenant denied attempts         | 100%            | Any successful cross-tenant is Sev-0. |

Logs estructurados incluyen tenant surrogate, correlationId, register_id, operation_id y reason_code; nunca token QR crudo, PII innecesaria ni evidencia binaria. Traces cruzan REST→domain→DB→CT adapter usando W3C trace context.

# 25. IA aplicada al módulo

Toda IA pasa por CT-12. Casos válidos: detectar patrones improbables, contradictorios o masivos; priorizar reconciliation; resumir evidence pack; sugerir reason classification. IA no marca asistencia, no corrige facts, no decide fraude, no sanciona ni cambia completion.

| **Caso IA**                   | **Input permitido**                    | **Salida**                   | **Control humano**            |
|-------------------------------|----------------------------------------|------------------------------|-------------------------------|
| Anomaly detection             | Facts/signals minimizados + provenance | Risk flag + explanation refs | Revisor decide.               |
| Evidence summarization        | Refs autorizadas CT-05                 | Resumen grounded             | No sustituye evidencia.       |
| Reconciliation prioritization | Operational metadata                   | Priority suggestion          | Ops puede ignorar.            |
| Bulk anomaly clustering       | Aggregated patterns                    | Clusters                     | No adverse action automática. |

# 26. Analítica y KPI

| **KPI**                   | **Fórmula**                                          | **Dimensión**             | **Nota**                      |
|---------------------------|------------------------------------------------------|---------------------------|-------------------------------|
| Attendance rate           | participants meeting attendance threshold / eligible | Edición/cohorte/modalidad | EC-06 facts + policy.         |
| No-show rate              | official absent / eligible                           | Offering/edition          | No provider outage as absent. |
| Late arrival rate         | late facts / attended                                | Session/timeband          | Policy version visible.       |
| Evidence conflict rate    | facts with contradictory sources / facts             | Source/provider           | Ops quality KPI.              |
| Manual override rate      | facts restated by manual adjustment / facts          | Instructor/operator       | Security/quality signal.      |
| Offline sync failure rate | rejected batches / uploaded batches                  | App version/device        | SRE.                          |
| Telemetry completeness    | expected external sessions with receipt / expected   | Provider                  | CT-18 quality.                |
| Reconciliation backlog    | open cases age/count                                 | Ops                       | SLO.                          |
| Engagement coverage       | participants with accepted observation / eligible    | Mode                      | No grade inference.           |

# 27. Migración legacy y Data Quality con CT-16

Legacy attendance nunca entra por INSERT directo a tablas finales. CT-16 ejecuta Extract → Normalize → Map → Validate → Dry-run → Promote through EC-06 command/domain API → receipt → reconcile → certify.

- Conservar source_system, source_key, source_timestamp, original status y transformed payload hash.

- Mapear estados legacy a códigos gobernados; unknown no se convierte a absent.

- Detectar duplicados por participant/session/source.

- Preservar ausencia de evidencia como calidad UNKNOWN.

- Dry-run reporta cross-tenant, missing enrollment/session, impossible timestamps y policy gaps.

- Promotion genera migration receipt y fact lineage con reason MIGRATED_LEGACY.

# 28. QA y estrategia de pruebas

| **Tipo**         | **Cobertura mínima**                                              |
|------------------|-------------------------------------------------------------------|
| Unit             | Policies, interval merge, ratio, state transitions.               |
| Domain           | Adjudication, restatement, token semantics, offline verification. |
| Repository       | Tenant PK/FK, unique current, append-only.                        |
| Integration      | PostgreSQL RLS + Testcontainers + CT stubs.                       |
| Contract         | OpenAPI clients, CT-18/EC-04 adapters.                            |
| Event contract   | AsyncAPI compatibility and inbox dedup.                           |
| Security         | IDOR, replay, mass assignment, rate limit, privilege escalation.  |
| Tenant isolation | Read/write denied across tenant at DB and API.                    |
| Concurrency      | Concurrent marks, fact restatement, register lock.                |
| Idempotency      | Same-key replay, different payload conflict, lease recovery.      |
| Resilience       | CT-18 timeout, partial, UNKNOWN_EFFECT, circuit breaker.          |
| Performance      | Mass webinar check-in burst, roster 10k, event ingest.            |
| Offline          | Duplicate batch, drift, bad signature, partial sync.              |
| Migration        | Legacy dry-run/promote/reconcile.                                 |
| E2E              | Instructor+participant+ops full journeys.                         |
| Mobile           | Offline queue, deep link/QR, accessibility.                       |
| AI Eval          | False-positive anomaly quality and grounded explanations.         |

# 29. Golden Scenarios

| **GS**      | **Escenario**                            | **Precondición**       | **Acción**      | **Resultado esperado**        | **Evidencia**          |
|-------------|------------------------------------------|------------------------|-----------------|-------------------------------|------------------------|
| GS-EC06-001 | Instructor abre register y roster válido | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-002 | Participante QR dentro de ventana        | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-003 | QR expirado                              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-004 | QR replay                                | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-005 | QR de otro tenant                        | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-006 | QR de otro register                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-007 | Check-in sin enrollment                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-008 | Check-in de enrollment withdrawn         | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-009 | Check-in exacto límite temprano          | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-010 | Check-in exacto límite tarde             | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-011 | Check-out normal                         | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-012 | Check-out faltante según policy          | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-013 | Dos check-in duplicados                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-014 | Manual present normal                    | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-015 | Manual override fuera de ventana         | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-016 | Bulk mark dry-run                        | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-017 | Bulk mark concurrente                    | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-018 | Provider Zoom complete                   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-019 | Provider Zoom partial                    | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-020 | Provider Zoom unavailable                | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-021 | Provider timeout UNKNOWN_EFFECT          | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-022 | LMS async activity accepted              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-023 | LMS click insuficiente                   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-024 | Source instructor vs provider conflict   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-025 | Adjudication present                     | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-026 | Adjudication absent                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-027 | Adjudication late                        | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-028 | Adjudication excused                     | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-029 | Unknown evidence                         | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-030 | Interval overlap merge                   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-031 | Interval clipped to session              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-032 | Break excluded                           | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-033 | Attendance ratio boundary 0              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-034 | Attendance ratio boundary 1              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-035 | Fact current uniqueness                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-036 | Concurrent fact restatement              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-037 | Adjustment submitted                     | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-038 | Requester cannot self-approve            | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-039 | Adjustment approved                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-040 | Adjustment rejected                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-041 | Adjustment applied after ETag conflict   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-042 | Void fact with reason                    | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-043 | Restatement under new policy             | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-044 | Old fact remains queryable               | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-045 | EC-07 consumes pinned fact               | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-046 | Session cancelled                        | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-047 | Session rescheduled                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-048 | Participant transferred                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-049 | Instructor replaced                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-050 | Offline batch valid                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-051 | Offline batch duplicate                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-052 | Offline bad signature                    | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-053 | Offline drift exceeded                   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-054 | Offline queue encrypted                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-055 | Mobile sync interrupted                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-056 | Mobile retry returns same receipt        | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-057 | Kiosk technical principal                | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-058 | Kiosk credential expired                 | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-059 | Access control event                     | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-060 | Anonymous telemetry unresolved           | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-061 | Evidence CT-05 unavailable               | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-062 | Evidence restricted by ABAC              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-063 | Corporate aggregate report               | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-064 | Corporate unauthorized detail denied     | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-065 | Cross-tenant API read denied             | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-066 | Cross-tenant DB read denied RLS          | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-067 | Cross-tenant write denied                | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-068 | Idempotency same key/same payload        | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-069 | Idempotency same key/different payload   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-070 | Idempotency lease recovery               | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-071 | Outbox claim concurrent workers          | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-072 | Outbox lease expiry recovery             | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-073 | Inbox duplicate message                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-074 | 202 OperationStatus running              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-075 | OperationStatus UNKNOWN_EFFECT           | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-076 | Reconciliation resolves applied          | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-077 | Reconciliation resolves not applied      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-078 | Reconciliation remains unknown           | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-079 | Rate limit QR abuse                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-080 | Payload over capacity budget             | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-081 | 10k roster pagination                    | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-082 | Mass webinar burst performance           | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-083 | NO_DATA UI                               | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-084 | ZERO UI                                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-085 | STALE UI                                 | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-086 | PARTIAL UI                               | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-087 | UNAVAILABLE UI                           | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-088 | UNKNOWN_EFFECT UI                        | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-089 | AI anomaly suggestion                    | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-090 | AI suggestion rejected                   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-091 | AI unavailable manual continues          | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-092 | Migration duplicate legacy               | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-093 | Migration missing session                | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-094 | Migration unknown status                 | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-095 | Migration dry-run no side effect         | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-096 | Migration promotion receipt              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-097 | Retention purge allowed                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-098 | Legal hold blocks purge                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-099 | Audit before/after complete              | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-100 | Reason code required                     | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-101 | Free text sanitized                      | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-102 | Accessibility alternate to QR            | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-103 | No smartphone alternate                  | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-104 | Notification failure post-commit         | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-105 | Read model stale while command correct   | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-106 | Redis outage no fact loss                | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-107 | Mongo read model rebuild                 | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-108 | Expand/contract N/N-1                    | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-109 | Security scan blocks release             | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |
| GS-EC06-110 | G1-G10 evidence complete                 | Estado/refs preparados | Ejecutar acción | Invariante y HTTP/UI esperado | DB/audit/event/receipt |

# 30. UAT institucional

| **UAT** | **Actor**       | **Prueba**                               | **Aceptación**                         |
|---------|-----------------|------------------------------------------|----------------------------------------|
| UAT-01  | Instructor      | Abrir sesión y registrar lista completa. | Roster correcto y facts reproducibles. |
| UAT-02  | Participante    | Check-in QR y ver receipt.               | Confirmación sin revelar roster.       |
| UAT-03  | Instructor      | Trabajar offline y sincronizar.          | Sin duplicados; estado de sync claro.  |
| UAT-04  | Coordinador     | Resolver discrepancia de fuentes.        | Decision auditada.                     |
| UAT-05  | Aprobador       | Procesar correction con SoD.             | Nueva fact version, historia intacta.  |
| UAT-06  | Auditor         | Reconstruir fact desde eventos/policy.   | Mismo resultado/hash.                  |
| UAT-07  | Ops             | Simular CT-18 timeout.                   | UNKNOWN_EFFECT + reconcile.            |
| UAT-08  | Seguridad       | Intentar cross-tenant.                   | Denegado por API y RLS.                |
| UAT-09  | Mobile          | QR accesible sin smartphone.             | Alternative journey funcional.         |
| UAT-10  | Corporate       | Ver reporte autorizado.                  | Privacy/purpose correctos.             |
| UAT-11  | Data Steward    | Migrar legacy dry-run.                   | Issues por item; no persist final.     |
| UAT-12  | EC-07           | Consumir hechos locked.                  | Contract compatible y pinned.          |
| UAT-13  | SRE             | Outbox multi-worker.                     | Sin pérdida/duplicado observable.      |
| UAT-14  | QA              | Replay token.                            | Rechazado.                             |
| UAT-15  | Governance      | Restatement policy.                      | Lineage completo.                      |
| UAT-16  | Instructor      | Bulk mark 500 participantes.             | Performance + preview.                 |
| UAT-17  | Participant     | Consultar own attendance.                | ABAC subject-only.                     |
| UAT-18  | Auditor         | Consultar evidence restricted.           | Field-level access.                    |
| UAT-19  | Ops             | Provider partial telemetry.              | PARTIAL no cero.                       |
| UAT-20  | Release Manager | Ejecutar G1-G10.                         | Evidence pack completo.                |

# 31. Gates G1-G10

| **Gate** | **Área**                  | **Criterio**                                 | **Evidencia**              |
|----------|---------------------------|----------------------------------------------|----------------------------|
| G1       | Arquitectura/BC           | Source of Truth, boundaries, DA/ADR cerrados | Architecture review.       |
| G2       | Datos/constraints         | DDL, RLS, append-only, current uniqueness    | Migration + DB tests.      |
| G3       | Backend                   | Domain/app/adapters/idempotency              | Unit/integration coverage. |
| G4       | API/Event contracts       | OpenAPI/AsyncAPI + compatibility             | Contract tests.            |
| G5       | Frontend/Mobile           | Workspaces, offline, states, accessibility   | E2E/mobile evidence.       |
| G6       | Security/audit            | Threat model, RBAC/ABAC/SoD/step-up          | Security tests/SBOM.       |
| G7       | Integraciones/resiliencia | CT-18/UNKNOWN/reconciliation                 | Chaos/resilience tests.    |
| G8       | QA/UAT                    | Golden + UAT passed                          | Signed evidence.           |
| G9       | Migración/operaciones     | CT-16, runbooks, observability               | Dry-run/restore drill.     |
| G10      | Release/certificación     | SLO, rollback/roll-forward, evidence pack    | Release approval.          |

# 32. Definition of Ready / Definition of Done

## 32.1 DoR

- EC-00/EC-01…EC-05 contracts identificados.

- Attendance/engagement policies CT-02 versionadas.

- Session/enrollment/instructor contracts disponibles.

- Threat model y privacy purpose definidos.

- OpenAPI/AsyncAPI draft revisado.

- Capacity budgets y SLO acordados.

- UX online/offline/accessibility aprobado.

## 32.2 DoD

- DDL Flyway aplicado limpio y upgrade N/N-1 probado.

- RLS FORCE probado con runtime role.

- Golden/UAT/contract/security/performance tests verdes.

- Offline sync, token replay y UNKNOWN_EFFECT probados.

- Dashboards/alerts/runbooks operativos.

- OpenAPI/AsyncAPI versionados y client generado.

- Evidence Pack G1-G10 firmado.

# 33. Runbooks

| **ID**      | **Runbook**                       | **Acción mínima**                                                                 |
|-------------|-----------------------------------|-----------------------------------------------------------------------------------|
| RB-EC06-001 | CT-18 provider outage             | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-002 | QR replay spike                   | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-003 | Check-in endpoint saturation      | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-004 | Offline sync backlog              | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-005 | Bad signature batch               | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-006 | Clock drift anomaly               | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-007 | External telemetry partial        | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-008 | Unknown effect external operation | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-009 | Outbox stuck                      | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-010 | Inbox poison message              | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-011 | Idempotency lease stuck           | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-012 | RLS misconfiguration alert        | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-013 | Cross-tenant incident             | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-014 | Register incorrectly locked       | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-015 | Emergency reopen register         | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-016 | Mass incorrect attendance         | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-017 | Adjustment backlog                | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-018 | Evidence CT-05 outage             | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-019 | Redis outage                      | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-020 | Mongo read model stale            | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-021 | DB failover                       | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-022 | Migration rollback/roll-forward   | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-023 | Mobile version incompatible       | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-024 | Rate limit false positive         | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |
| RB-EC06-025 | Legal hold/purge conflict         | Detectar → contener → preservar evidencia → reconciliar → comunicar → postmortem. |

# 34. ADRs y decisiones abiertas

| **ADR**      | **Decisión**                                      | **Estado** | **Rationale**                              |
|--------------|---------------------------------------------------|------------|--------------------------------------------|
| ADR-EC06-001 | Raw events append-only + official fact versionado | ACCEPTED   | Auditabilidad y corrección no destructiva. |
| ADR-EC06-002 | RLS ENABLE+FORCE                                  | ACCEPTED   | Defense in depth tenant.                   |
| ADR-EC06-003 | QR one-time/TTL configurable                      | ACCEPTED   | Anti-replay sin hardcode.                  |
| ADR-EC06-004 | No biometric default                              | ACCEPTED   | Privacy/risk minimization.                 |
| ADR-EC06-005 | Offline signed batch                              | ACCEPTED   | Operación real en campus/eventos.          |
| ADR-EC06-006 | Server clock authority                            | ACCEPTED   | Evitar manipulación.                       |
| ADR-EC06-007 | Fact current partial unique index                 | ACCEPTED   | Una verdad vigente.                        |
| ADR-EC06-008 | Engagement no grade                               | ACCEPTED   | Boundary EC-07.                            |
| ADR-EC06-009 | External telemetry only via CT-18                 | ACCEPTED   | No vendor coupling.                        |
| ADR-EC06-010 | Location optional by policy                       | ACCEPTED   | Purpose limitation.                        |
| ADR-EC06-011 | Real-time adjudication vs batch threshold         | OPEN       | Definir por scale/tenant policy.           |
| ADR-EC06-012 | Kiosk device attestation provider                 | OPEN       | Depende baseline IAM/device platform.      |

# 35. Engineering Pack

| **Ruta**       | **Artefactos mínimos**                            |
|----------------|---------------------------------------------------|
| /docs          | EC06.md, glossary, boundary-map.md                |
| /openapi       | ec06-openapi.yaml + examples                      |
| /asyncapi      | ec06-asyncapi.yaml + schemas                      |
| /db/migration  | Vxxx\_\_ec06\_\*.sql                              |
| /architecture  | context/domain/sequence diagrams                  |
| /adr           | ADR-EC06-\*.md                                    |
| /backend       | module ec06 + tests                               |
| /frontend      | feature attendance + generated client integration |
| /mobile        | participant/instructor attendance features        |
| /tests         | unit/domain/integration/contract/e2e              |
| /performance   | k6/Gatling check-in + webinar burst               |
| /security      | threat-model, SBOM, scan reports                  |
| /runbooks      | RB-EC06-\*.md                                     |
| /observability | dashboards, alerts, SLO                           |
| /migration     | CT-16 mappings/dry-run evidence                   |
| /evidence      | G1-G10 release evidence                           |

# 36. Guía secuencial Backend

| **Paso** | **Implementación**                                                  |
|----------|---------------------------------------------------------------------|
| 1        | Crear módulo Spring Modulith ec06 y module-info tests.              |
| 2        | Definir ubiquitous language, aggregates y Value Objects.            |
| 3        | Implementar AttendanceRegister state machine.                       |
| 4        | Implementar raw AttendanceEvent append-only.                        |
| 5        | Implementar TokenService con hash/nonce/TTL/replay.                 |
| 6        | Implementar OfflineCaptureBatch y signature/drift validation ports. |
| 7        | Implementar IntervalNormalizationService.                           |
| 8        | Implementar AttendanceAdjudicationPolicy port CT-02.                |
| 9        | Implementar OfficialAttendanceFact versionado/current pointer.      |
| 10       | Implementar AttendanceAdjustment + CT-06 port.                      |
| 11       | Implementar ReconciliationCase/UNKNOWN_EFFECT.                      |
| 12       | Crear persistence adapters JPA/JDBC y Flyway.                       |
| 13       | Configurar runtime/migrator roles y RLS SET LOCAL.                  |
| 14       | Implementar idempotency lease coordinator.                          |
| 15       | Implementar outbox/inbox lease/dedup.                               |
| 16       | Implementar REST controllers con ProblemDetail.                     |
| 17       | Generar OpenAPI examples/clients y contract tests.                  |
| 18       | Implementar AsyncAPI/events.                                        |
| 19       | Implementar CT-18 telemetry adapter; nunca vendor SDK en domain.    |
| 20       | Implementar CT-05 evidence refs y CT-07 notifications post-commit.  |
| 21       | Implementar structured logging/tracing/metrics.                     |
| 22       | Implementar unit/domain/repository/integration tests.               |
| 23       | Implementar tenant/concurrency/replay/security tests.               |
| 24       | Implementar performance burst tests.                                |
| 25       | Implementar migration CT-16 endpoints/commands.                     |
| 26       | Cerrar Gates G1-G10 y evidence pack.                                |

# 37. Guía secuencial Frontend

| **Paso** | **Implementación**                                                            |
|----------|-------------------------------------------------------------------------------|
| 1        | Crear feature module attendance y route tree.                                 |
| 2        | Consumir cliente generado OpenAPI; prohibir DTO duplicado.                    |
| 3        | Definir query keys tenant/scope-safe.                                         |
| 4        | Crear Attendance Console shell.                                               |
| 5        | Crear roster virtualizado con filtros y keyboard navigation.                  |
| 6        | Implementar status/source chips y evidence indicators.                        |
| 7        | Implementar manual mark mutations con optimistic ETag.                        |
| 8        | Implementar QR token panel con TTL countdown y revoke.                        |
| 9        | Implementar Participant Timeline drawer.                                      |
| 10       | Implementar Adjustment modal con before/after/evidence.                       |
| 11       | Implementar Operations dashboard + dependency health.                         |
| 12       | Implementar Review Center + SoD/step-up UX.                                   |
| 13       | Implementar OperationStatus polling/backoff.                                  |
| 14       | Implementar NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT components. |
| 15       | Implementar bulk preview/confirm and capacity feedback.                       |
| 16       | Implementar accessible alternative to QR.                                     |
| 17       | Implementar error boundary + ProblemDetail mapping.                           |
| 18       | Implementar telemetry provenance views.                                       |
| 19       | Implementar responsive behavior.                                              |
| 20       | Implementar unit/component/e2e/a11y tests.                                    |
| 21       | Validar con UAT institutional.                                                |

# 38. Matriz de permisos

| **Acción**         | **Instructor** | **Operator** | **Participant** | **Approver** | **Auditor/Ops** | **Corporate**    |
|--------------------|----------------|--------------|-----------------|--------------|-----------------|------------------|
| Open register      | ✓              | ✓            | —               | —            | —               | —                |
| Manual mark        | ✓              | ✓            | —               | —            | —               | —                |
| Generate QR        | ✓              | ✓            | —               | —            | —               | —                |
| Own check-in       | —              | —            | ✓               | —            | —               | —                |
| Request adjustment | ✓              | ✓            | ✓ own           | —            | —               | —                |
| Approve adjustment | —              | —            | —               | ✓            | —               | —                |
| Restatement        | —              | —            | —               | ✓            | ✓               | —                |
| View evidence      | assigned       | scope        | own limited     | scope        | ✓               | contract limited |
| Corporate report   | —              | scope        | —               | —            | ✓               | ✓                |
| Reconcile          | —              | ✓            | —               | —            | ✓               | —                |
| Export             | —              | scope        | own             | scope        | ✓               | contract limited |

# 39. Contratos DTO Frontend

| **DTO**                   | **Campos mínimos**                                                                        | **Uso**                             |
|---------------------------|-------------------------------------------------------------------------------------------|-------------------------------------|
| AttendanceRegisterSummary | id, sessionRef, editionRef, plannedStartAt, state, counts, sourceHealth, version          | List/dashboard.                     |
| RosterAttendanceItem      | rosterEntryId, enrollmentRef, displayRef, currentFact, pendingSignals, adjustmentState    | Console row.                        |
| AttendanceFactDto         | factId, versionNo, statusCode, minutes, ratio, sourceSummary, officialAt, policyRef, etag | Detail.                             |
| AttendanceTimelineDto     | rawSignals\[\], adjudications\[\], facts\[\], adjustments\[\], receipts\[\]               | Audit drawer.                       |
| CheckInChallengeDto       | challenge, expiresAt, registerRef, instructions, alternatives                             | QR display; token handled securely. |
| CheckInReceiptDto         | result, eventRef, factState, receivedAt, correlationId                                    | Participant confirmation.           |
| OfflineBatchStatusDto     | batchId, state, acceptedCount, rejectedCount, issues\[\], operationId                     | Mobile sync.                        |
| AdjustmentDto             | id, targetFact, requestedChange, reason, evidenceRefs, workflowState, version             | Review center.                      |
| OperationStatusDto        | operationId, state, progress, resultRef, problem                                          | Async UI.                           |
| ProblemDetails            | type,title,status,detail,instance,reasonCode,correlationId,fieldErrors                    | Uniform errors.                     |

# 40. Checklist de release y certificación final

- [ ] Word EC-06 V1.0 aprobado y versionado.

- [ ] OpenAPI/AsyncAPI coinciden con implementación.

- [ ] DDL Flyway limpio + upgrade N/N-1 probado.

- [ ] RLS FORCE + runtime role no BYPASSRLS.

- [ ] Append-only raw events/receipts verificado.

- [ ] Current fact uniqueness verificada.

- [ ] QR TTL/replay/rate limit probado.

- [ ] Offline signed batch + drift/retry probado.

- [ ] Idempotency lease recovery probado.

- [ ] Outbox SKIP LOCKED/lease/replay probado.

- [ ] UNKNOWN_EFFECT + reconciliation probado.

- [ ] ProblemDetail/reason codes estables.

- [ ] Frontend all six data states probado.

- [ ] Mobile offline/accessibility aprobado.

- [ ] Threat model mitigations verificadas.

- [ ] SAST/SCA/secrets/SBOM/container scans verdes.

- [ ] SLO dashboards/alerts activos.

- [ ] Migration CT-16 dry-run/promotion certificado.

- [ ] Golden Scenarios passed.

- [ ] UAT institucional firmado.

- [ ] Runbooks ensayados.

- [ ] G1-G10 evidence pack completo.

# 41. Contrato FullStack no negociable de implementación

| **ID**      | **Garantía no negociable**                                                    |
|-------------|-------------------------------------------------------------------------------|
| FS-EC06-001 | PostgreSQL es Source of Truth de facts; Redis/Mongo nunca autoridad.          |
| FS-EC06-002 | Raw AttendanceEvent y external receipts son append-only.                      |
| FS-EC06-003 | Official fact es versionado; una sola current por participant/register.       |
| FS-EC06-004 | No FK cross-context.                                                          |
| FS-EC06-005 | Toda tabla tenant-owned usa RLS ENABLE+FORCE.                                 |
| FS-EC06-006 | tenant_id proviene de contexto autorizado, no request body.                   |
| FS-EC06-007 | Runtime DB role no owner y no BYPASSRLS.                                      |
| FS-EC06-008 | Mutaciones root usan ETag/If-Match; 412 en conflicto.                         |
| FS-EC06-009 | Comandos sensibles usan idempotencia durable con lease/recovery.              |
| FS-EC06-010 | Outbox atómica + inbox dedup; multi-worker claim seguro.                      |
| FS-EC06-011 | UNKNOWN_EFFECT siempre reconcilia antes de retry.                             |
| FS-EC06-012 | QR token crudo nunca se persiste; hash+nonce+TTL+scope.                       |
| FS-EC06-013 | Offline batch exige device ref, hash/signature y drift validation.            |
| FS-EC06-014 | Telemetría externa es signal, no academic fact.                               |
| FS-EC06-015 | Attendance ≠ Participation ≠ Engagement ≠ Completion.                         |
| FS-EC06-016 | Corrección nunca reescribe raw events; crea adjustment/fact version.          |
| FS-EC06-017 | Policies/thresholds siempre versionados en CT-02.                             |
| FS-EC06-018 | Evidence blobs viven en CT-05.                                                |
| FS-EC06-019 | Integración vendor únicamente vía CT-18/CT-09.                                |
| FS-EC06-020 | AI exclusivamente vía CT-12 y no decide attendance.                           |
| FS-EC06-021 | Frontend usa cliente generado OpenAPI.                                        |
| FS-EC06-022 | UI distingue NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.           |
| FS-EC06-023 | Mobile muestra pending local vs confirmed server explícitamente.              |
| FS-EC06-024 | No smartphone/QR como única vía sin alternativa accesible.                    |
| FS-EC06-025 | Geolocation/biometric no default; purpose limitation obligatorio.             |
| FS-EC06-026 | Logs no contienen token crudo ni PII/evidence innecesaria.                    |
| FS-EC06-027 | Migraciones expand/contract N/N-1.                                            |
| FS-EC06-028 | Secure SDLC findings High/Critical bloquean release.                          |
| FS-EC06-029 | Capacity budgets y rate limits son obligatorios.                              |
| FS-EC06-030 | Tenant isolation, replay, offline dedup y concurrency son pruebas de release. |
| FS-EC06-031 | EC-07 consume facts versionados, no raw signals.                              |
| FS-EC06-032 | No hard-delete de hechos oficiales/adjustments/receipts por API ordinaria.    |
| FS-EC06-033 | Todo restatement conserva lineage, reason, actor, policy y evidence refs.     |
| FS-EC06-034 | G1-G10 con evidencia son condición de producción.                             |
