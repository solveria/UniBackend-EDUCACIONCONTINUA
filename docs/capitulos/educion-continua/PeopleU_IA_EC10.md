**PEOPLEU IA**

**EC-10**

**TRAYECTORIA DE APRENDIZAJE, PROGRESIÓN,  
STACKABLE CREDENTIALS Y RECONOCIMIENTO  
ACUMULATIVO EC**

**Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones**

| **Control**    | **Valor**                                                                                                      |
|----------------|----------------------------------------------------------------------------------------------------------------|
| Código         | EC-10                                                                                                          |
| Versión        | V1.0                                                                                                           |
| Estado         | VIGENTE — ESPECIFICACIÓN FULLSTACK ENTERPRISE                                                                  |
| Baseline       | EC-00 V1.1 · EC-01 V1.1 · contratos EC-02…EC-09                                                                |
| Vertical       | Educación Continua / Formación Continua                                                                        |
| Arquitectura   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| Stack objetivo | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| Contexto       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| Fecha base     | Septiembre 2026 — Ingeniería implementable y QA visual                                                         |

| **GOBIERNO DE ARTEFACTOS —** Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA —** EC-10 es Source of Truth del progreso individual contra una PathwayVersion EC-01 pinneada, del ledger de hechos de trayectoria, de snapshots reproducibles, de reconocimiento acumulativo y de migraciones de trayectoria. No redefine programas, no registra inscripciones, no altera resultados académicos y no emite credenciales. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

| **V1.0 — FULLSTACK ENTERPRISE —** EC-10 operacionaliza la trayectoria individual de Educación Continua con pinning de ruta, ledger append-only de hechos, snapshots reproducibles, reconocimiento acumulativo, migración gobernada entre versiones, RLS, concurrencia optimista, idempotencia durable, outbox/inbox, UNKNOWN_EFFECT y contratos ejecutables. Su objetivo es que dos equipos Senior implementen el mismo comportamiento observable sin conocimiento tribal. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

EC-10 existe porque la acumulabilidad no puede resolverse consultando en vivo “qué cursos terminó la persona” y sumando resultados sin versión, política ni lineage. Una ruta EC evoluciona; las credenciales pueden vencer o revocarse; una evidencia externa puede ser reconocida parcialmente; y una migración de ruta debe preservar por qué cada requisito se consideró satisfecho. El módulo convierte esos hechos distribuidos en una trayectoria auditable, explicable y reproducible.

La frontera es deliberada: EC-10 no corrige resultados de EC-07, no emite ni revoca credenciales de EC-08, no reescribe PathwayVersion de EC-01, no crea personas de CT-04 y no almacena blobs documentales de CT-05. Consume esas verdades por contrato, conserva referencias, hashes, snapshots y receipts suficientes para explicar una decisión histórica.

| **CRITERIO DE ÉXITO —** Un equipo Senior debe poder reconstruir cualquier estado de progreso “as of”, explicar cada nodo satisfecho o bloqueado, demostrar tenant isolation, detectar revocaciones/expiry, migrar entre versiones sin reescribir historia y reconciliar efectos remotos sin retry ciego. PostgreSQL debe impedir corrupción estructural incluso si Backend tiene un bug. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 

| **Prioridad** | **Documento/artefacto**                | **Rol**                                                                   |
|---------------|----------------------------------------|---------------------------------------------------------------------------|
| 1             | AM-00 vigente                          | Constitución arquitectónica superior.                                     |
| 2             | CT-00 vigente                          | Contrato maestro transversal.                                             |
| 3             | CT-01…CT-18 vigentes                   | Capacidades compartidas y fronteras.                                      |
| 4             | EC-00 V1.1                             | Constitución funcional/arquitectónica de Educación Continua.              |
| 5             | EC-01 V1.1                             | Plantilla oficial FullStack; define PathwayVersion y stacking blueprint.  |
| 6             | EC-02…EC-09 vigentes                   | Hechos/contratos operativos que alimentan o consumen trayectoria.         |
| 7             | EC-10 V1.0                             | Especificación implementable de trayectoria y reconocimiento acumulativo. |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación y evidencia alineadas al Word.                             |

## 

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

## 

| **ID**      | **Decisión normativa**                                                                                                                |
|-------------|---------------------------------------------------------------------------------------------------------------------------------------|
| EC10-DA-001 | PATHWAY DEFINITION ≠ PATHWAY PROGRESS. EC-01 publica la ruta; EC-10 mantiene el progreso individual.                                  |
| EC10-DA-002 | LATEST PATHWAY ≠ HISTORICAL TRUTH. Toda trayectoria pinnea pathway_version_ref + content_hash; nunca resuelve “latest” para historia. |
| EC10-DA-003 | COMPLETION FACT ≠ PROGRESS DECISION. EC-07 emite hechos; EC-10 los proyecta bajo una política versionada.                             |
| EC10-DA-004 | CREDENTIAL AWARD ≠ PATHWAY SATISFACTION. EC-08 posee la adjudicación/emisión; EC-10 solo conserva referencias y efectos de progreso.  |
| EC10-DA-005 | STACKABLE CREDENTIAL ≠ DEGREE EQUIVALENCE. La acumulabilidad EC no crea equivalencia automática con Pregrado/Postgrado.               |
| EC10-DA-006 | PARTICIPANT ≠ TRAJECTORY. CT-04/EC-04 son autoridad de persona/vinculación; EC-10 guarda person_ref opaco.                            |
| EC10-DA-007 | FACT ≠ SNAPSHOT. TrajectoryFact es append-only; ProgressSnapshot es una proyección reproducible y versionada.                         |
| EC10-DA-008 | PROGRESS % ≠ ACADEMIC DECISION. Un porcentaje informa; no reemplaza una decisión de elegibilidad/credencial.                          |
| EC10-DA-009 | NODE SATISFIED ≠ CREDENTIAL ISSUED. La satisfacción habilita evaluación; no crea CredentialAward.                                     |
| EC10-DA-010 | RECOGNITION CLAIM ≠ EVIDENCE BLOB. El caso vive en EC-10; el artefacto documental vive en CT-05.                                      |
| EC10-DA-011 | EXTERNAL CREDENTIAL ≠ TRUSTED CREDENTIAL. Toda evidencia externa exige perfil de confianza, verificación y policy snapshot.           |
| EC10-DA-012 | AUTO-MATCH ≠ FINAL DECISION. Matching determinístico o IA puede proponer; aceptación requiere política/actor autorizado.              |
| EC10-DA-013 | AI RECOMMENDATION ≠ RECOGNITION DECISION. Toda IA pasa por CT-12 y queda separada de la decisión humana.                              |
| EC10-DA-014 | PATHWAY MIGRATION ≠ IN-PLACE REBIND. Migrar crea caso, simulación, mapping, receipts y nuevo progreso; no muta el pin histórico.      |
| EC10-DA-015 | CARRY-FORWARD ≠ COPY WITHOUT PROOF. Cada contribución migrada conserva lineage y CarryForwardReceipt.                                 |
| EC10-DA-016 | MANUAL OVERRIDE ≠ FREE EDIT. Override exige reason, evidencia, autorización y receipt; no altera facts originales.                    |
| EC10-DA-017 | TENANT CONTEXT ≠ REQUEST BODY. tenant_id se resuelve del contexto autorizado y PostgreSQL fuerza RLS.                                 |
| EC10-DA-018 | CROSS-CONTEXT REF ≠ CROSS-CONTEXT FK. person_ref, pathway_ref, completion_ref, award_ref y evidence_ref no tienen FK física externa.  |
| EC10-DA-019 | AGGREGATE REVISION CUBRE HIJOS. Toda mutación de un hijo bump revision del root y renueva ETag.                                       |
| EC10-DA-020 | IDEMPOTENCY IN_PROGRESS ≠ FOREVER. Lease, owner, heartbeat y recovery son obligatorios.                                               |
| EC10-DA-021 | 202 ACCEPTED ≠ EFFECT CONFIRMED. Toda operación asíncrona devuelve operationId y estado reconciliable.                                |
| EC10-DA-022 | UNKNOWN_EFFECT ≠ FAILED. Un timeout remoto no habilita retry ciego.                                                                   |
| EC10-DA-023 | CACHE ≠ SOURCE OF TRUTH. Redis acelera lecturas; PostgreSQL conserva facts, decisiones y snapshots.                                   |
| EC10-DA-024 | PROJECTION ≠ FACT LEDGER. Una reconstrucción puede reemplazar proyección, nunca borrar el ledger.                                     |
| EC10-DA-025 | EXPIRY ≠ DELETE. Vencimiento invalida contribución temporalmente; conserva historia y evidencia.                                      |
| EC10-DA-026 | REVOKED CREDENTIAL ≠ NEVER EXISTED. Revocación agrega un hecho y recalcula; no elimina el award histórico.                            |
| EC10-DA-027 | STALE ≠ ZERO. UI muestra frescura y dependencia; jamás transforma indisponibilidad en cero.                                           |
| EC10-DA-028 | OPENAPI/ASYNCAPI ≠ DOCUMENTATION ONLY. Generan clientes, contract tests y compatibility gates.                                        |
| EC10-DA-029 | RUNTIME ROLE ≠ MIGRATOR ROLE. Runtime no posee tablas ni BYPASSRLS; worker técnico tiene privilegios mínimos separados.               |
| EC10-DA-030 | ZERO-DOWNTIME = EXPAND/CONTRACT. Schema y app mantienen compatibilidad N/N-1.                                                         |
| EC10-DA-031 | AS-OF QUERY ≠ CURRENT QUERY. Reconstrucción histórica usa snapshots/facts hasta watermark explícito.                                  |
| EC10-DA-032 | CORPORATE AGGREGATE ≠ INDIVIDUAL DISCLOSURE. EC-09 privacy/reporting profile gobierna cualquier agregación corporativa.               |

## 

EC-10 es suficiente cuando el dominio, el diseño físico, las APIs, los eventos, los estados de UI, el modelo de concurrencia, los fallos de integración y las evidencias de auditoría están definidos con precisión tal que dos equipos Senior independientes convergen en la misma semántica. Toda variabilidad institucional debe estar parametrizada o documentada en un ADR; nunca escondida en if/else locales.

## 

| **Severidad** | **Riesgo típico**                                    | **Cierre normativo EC-10**                                                               |
|---------------|------------------------------------------------------|------------------------------------------------------------------------------------------|
| P0            | Resolver latest PathwayVersion en progreso histórico | Pin de pathway_version_ref + content_hash; trigger de inmutabilidad.                     |
| P0            | Cruce de tenant por olvido de filtro                 | PK/FK tenant-aware + ENABLE/FORCE RLS + runtime sin BYPASSRLS.                           |
| P0            | Modificar facts para “corregir” historia             | TrajectoryFact append-only; corrección = nuevo fact compensatorio.                       |
| P0            | Mutación de hijo sin cambiar ETag                    | Aggregate revision contract; trigger/service bump del root.                              |
| P0            | Reintentar emisión de credencial tras timeout        | UNKNOWN_EFFECT + reconciliation por correlation/decision id.                             |
| P1            | Snapshot no reproducible                             | engine_version + policy_set_hash + pathway_content_hash + input_watermark + result_hash. |
| P1            | Migración de ruta in-place                           | MigrationCase + simulation + mapping + carry-forward receipts + nuevo PathwayProgress.   |
| P1            | Sponsor corporativo ve PII individual                | Solo proyección agregada conforme ReportingProfile EC-09.                                |
| P1            | IA decide reconocimiento                             | CT-12 recommendation separada; decisión humana/policy autorizada.                        |
| P2            | UI confunde indisponibilidad con cero                | NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT explícitos.                        |

# 

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01…CT-18, cores y módulos EC

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal BR-EC10

- 10\. Casos de uso UC-EC10

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

# 

EC-10 resuelve la continuidad longitudinal del aprendizaje en Educación Continua. Una universidad puede ofrecer rutas de microcredenciales compuestas por cursos, módulos y credenciales que se completan en meses o años, en distintas sedes, ediciones y modalidades. Si el progreso se deriva solamente desde consultas actuales a sistemas externos, cualquier cambio de versión, revocación, timeout o migración vuelve imposible demostrar qué sabía el sistema cuando tomó una decisión.

El módulo introduce una separación fuerte entre hechos y proyecciones. TrajectoryFact registra de manera append-only los hechos relevantes recibidos por contrato; NodeProgress y PathwayProgress representan proyecciones recalculables; ProgressSnapshot congela un resultado reproducible con hashes y watermark; RecognitionClaim gobierna el reconocimiento de evidencia no nativa; PathwayMigrationCase mueve una trayectoria entre versiones mediante simulación y receipts; CumulativeEligibilityDecision expresa si una trayectoria cumple un blueprint antes de solicitar emisión a EC-08.

## 

- Creación de LearningTrajectory por person_ref y scope institucional, sin duplicar la persona.

- Inicio de PathwayProgress pinneado a PathwayVersion de EC-01 con content hash verificable.

- Ingesta idempotente de completion/results EC-07, credential awards/revocations EC-08 y reconocimientos aceptados.

- Ledger append-only de TrajectoryFact con provenance hash, source event id y ventanas de validez.

- Cálculo determinístico de NodeProgress, bloqueos, expiry, revocación y prerequisites.

- Snapshots reproducibles con engine version, policy hash, input watermark y result hash.

- RecognitionClaim para evidencia externa o institucional fuera del flujo nativo, con workflow, evidence refs y SoD.

- ManualOverride gobernado, auditable y reversible sin editar hechos originales.

- PathwayMigrationCase entre versiones con diff, simulación, mapping y CarryForwardReceipt.

- Evaluación de cumulative eligibility y request a EC-08 sin emitir localmente credenciales.

- As-of/history, explanation graph, missing requirements, next actions y lineage completo.

- Portal/self-service de trayectoria, mobile selectivo, workspaces operativos y reconciliación.

- RLS, ETag, idempotencia durable, outbox/inbox, ProblemDetail, OperationStatus y zero-downtime.

## 

- Definir o versionar PathwayDefinition/PathwayVersion — EC-01.

- Crear ediciones, offerings, calendarios o sesiones — EC-02/CT-03.

- Pricing, promociones, cobro o facturación — EC-03/Finanzas.

- Crear persona, prospecto, registro o enrollment — CT-04/EC-04.

- Capturar asistencia fuente — EC-06.

- Calcular notas, aprobar assessment o cerrar completion fuente — EC-07.

- Emitir, firmar, revocar o verificar criptográficamente CredentialAward — EC-08/CT-05.

- Guardar PDFs/blobs de evidencia — CT-05.

- Crear workflows generales — CT-06.

- Implementar IA directa o SDK de proveedor — CT-12.

- Insertar legacy directamente a tablas finales — CT-16.

- Otorgar equivalencias de grado o homologaciones PG/PO automáticamente.

| **ANTI-SCOPE —** EC-10 no es un “historial académico universal”. Solo persiste los hechos y decisiones necesarios para explicar trayectoria EC y sus proyecciones. Las fuentes oficiales permanecen en sus bounded contexts. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

| **Término**                   | **Definición normativa**                                                                                        |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------|
| LearningTrajectory            | Contenedor longitudinal de trayectoria EC para un person_ref y scope; no es la persona ni una inscripción.      |
| PathwayProgress               | Progreso individual contra una PathwayVersion EC-01 exacta y pinneada.                                          |
| TrajectoryFact                | Hecho append-only recibido/creado de manera gobernada que puede contribuir a uno o más nodos.                   |
| FactContribution              | Vínculo explicable entre un fact y un nodo bajo una policy/version concretas.                                   |
| NodeProgress                  | Estado proyectado de un nodo de la ruta: satisfacción, peso, bloqueo, reason y as-of.                           |
| ProgressSnapshot              | Proyección inmutable y reproducible de un PathwayProgress para un watermark de inputs.                          |
| RecognitionClaim              | Caso gobernado para pedir reconocimiento de evidencia externa o institucional no consumida como fact confiable. |
| RecognitionEvidence           | Referencia CT-05 y metadata de verificación; no contiene el blob.                                               |
| ManualOverride                | Decisión excepcional autorizada que afecta proyección sin editar facts originales.                              |
| PathwayMigrationCase          | Caso que simula y aplica transición de una PathwayVersion a otra creando lineage.                               |
| MigrationMapping              | Mapeo explícito source-node → target-node con tipo, policy y decision reason.                                   |
| CarryForwardReceipt           | Evidencia append-only que prueba por qué una contribución fue transportada a la nueva ruta.                     |
| CumulativeEligibilityDecision | Decisión versionada de elegibilidad para un CredentialBlueprint; no es CredentialAward.                         |
| DependencyState               | AVAILABLE/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT aplicado a datos dependientes.                               |
| InputWatermark                | Frontera temporal/eventual hasta la cual un snapshot declara haber considerado facts.                           |
| AsOf                          | Instante solicitado para reconstruir historia sin usar valores futuros.                                         |
| PathwayVersionRef             | Referencia externa a EC-01 + version no + content hash; sin FK física.                                          |
| SourceFactKey                 | Business key idempotente del hecho dentro del tenant.                                                           |
| RecognitionReceipt            | Evidencia append-only de decisiones críticas de EC-10.                                                          |
| OperationStatus               | Contrato consultable para operaciones 202/UNKNOWN_EFFECT/rebuild/migration/issuance.                            |

# 

El bounded context se denomina Trajectory & Accumulative Recognition. Posee la semántica de progreso, sus proyecciones y las decisiones de reconocimiento; no posee las definiciones académicas ni los hechos académicos originales. Toda referencia externa es opaque ID + snapshot/hashes estrictamente necesarios para reproducibilidad.

| **Concepto**              | **Source of Truth** | **EC-10 conserva**                            | **EC-10 no hace**              |
|---------------------------|---------------------|-----------------------------------------------|--------------------------------|
| Persona/identidad         | CT-04 / IAM         | person_ref, display snapshot opcional         | Editar identidad/PII maestra   |
| PathwayDefinition/Version | EC-01               | pathway_version_ref, version_no, content_hash | Editar ruta publicada          |
| Program/Edition           | EC-01/EC-02         | refs explicativos cuando se requiera          | Crear oferta                   |
| Registration/Enrollment   | EC-04               | refs si un fact las necesita                  | Matricular                     |
| Attendance                | EC-06               | fact ref/summary solo si policy lo usa        | Capturar asistencia fuente     |
| Assessment/Completion     | EC-07               | completion fact + provenance                  | Cambiar nota/completion        |
| CredentialAward           | EC-08               | award/revocation fact + ref                   | Emitir/revocar credencial      |
| Evidence blob             | CT-05               | evidence_ref/hash/status                      | Guardar archivo                |
| Workflow                  | CT-06               | workflow_ref/state snapshot                   | Crear motor workflow           |
| AI                        | CT-12               | run_ref/grounding/confidence/outcome          | Invocar proveedor directamente |
| Migration                 | CT-16               | lineage/receipt/promote result                | ETL directo final              |
| Corporate reporting       | EC-09               | agregados permitidos por profile              | Exportar PII sin purpose       |

# 

| **Dependencia** | **Responsabilidad**           | **Contrato EC-10**                    | **Frontera/fallo**                                   |
|-----------------|-------------------------------|---------------------------------------|------------------------------------------------------|
| CT-01           | Tenant/scope institucional    | TenantContext + scope refs            | Fail closed; nunca body tenant.                      |
| CT-02           | Catálogos/policies académicas | Códigos/refs versionados              | STALE visible; publish/decision crítica fail closed. |
| CT-03           | Tiempo/calendario             | Timestamps/timezone refs              | No calendar owner.                                   |
| CT-04           | Persona                       | person_ref                            | No FK física / no PII shadow.                        |
| CT-05           | Documentos/evidence           | evidence_ref + hash/status            | Blob fuera de EC-10.                                 |
| CT-06           | Workflow/aprobaciones         | workflow_ref + decision snapshot      | SoD/step-up en decisiones críticas.                  |
| CT-07           | Notificaciones                | communication request ref             | Fallo no altera hecho; retry controlado.             |
| CT-08           | i18n                          | labels/locale                         | Idioma no crea nueva trayectoria.                    |
| CT-09           | Recursos                      | No ownership                          | No aplica salvo deep link contextual.                |
| CT-10           | Auditoría/evidence pack       | audit/evidence refs                   | Además receipts locales append-only.                 |
| CT-11           | Observabilidad                | correlation/trace conventions         | PII minimizada.                                      |
| CT-12           | IA                            | AI recommendation contract            | No provider SDK local.                               |
| CT-13           | Integración/API gateway       | contract/auth/rate limits             | No bypass de scope.                                  |
| CT-14           | Seguridad                     | RBAC/ABAC/step-up                     | Defense-in-depth con RLS.                            |
| CT-15           | Eligibility/policy engine     | eligibility result/ref cuando aplique | EC-10 no duplica motor general.                      |
| CT-16           | Migración/Data Quality        | extract/map/promote/reconcile         | No INSERT directo.                                   |
| CT-17           | Analytics/BI                  | curated events/facts                  | No PII export irrestricto.                           |
| CT-18           | LMS/externos                  | external credential/course refs       | Trust profile obligatorio.                           |
| EC-01           | PathwayVersion/Blueprint      | Pin + hash + node refs                | Nunca latest histórico.                              |
| EC-04           | Participant linkage           | Enrollment refs opcionales            | No enrollment owner.                                 |
| EC-07           | Completion/results            | Inbox → TrajectoryFact                | Source facts inmutables.                             |
| EC-08           | Credential awards/revocations | Inbox + issuance command              | UNKNOWN_EFFECT para command remoto.                  |
| EC-09           | Corporate privacy/reporting   | Aggregate view contract               | Minimum cohort/suppression outside EC-10 core.       |

# 

<img src="media/image1.png" style="width:6.7in;height:3.63714in" />

Figura 1 — EC-10 dentro de la vertical EC y capacidades transversales

| **Journey**                      | **Flujo E2E**                                                                                                                                                     |
|----------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| J-EC10-01 Inicio ruta            | Advisor/participante selecciona PathwayVersion publicada → resolver EC-01 → pin version/hash → crear PathwayProgress DRAFT → activar con ETag → snapshot inicial. |
| J-EC10-02 Completion nativo      | EC-07 publica completion → inbox dedup → TrajectoryFact append-only → matching determinístico → contribuciones → recalcular NodeProgress → snapshot → outbox.     |
| J-EC10-03 Stack credential       | EC-08 award event → fact confiable → node satisfied → cumulative eligibility → request nueva credencial si policy/actor autoriza.                                 |
| J-EC10-04 Reconocimiento externo | Claim DRAFT → evidencia CT-05 → verify → review/SoD → ACCEPTED/PARTIAL → fact reconocido append-only → proyección.                                                |
| J-EC10-05 Expiry/revocation      | Evento de vencimiento/revocación → nuevo fact → invalidar contribución aplicable → recalcular → snapshot histórico conserva estado previo.                        |
| J-EC10-06 Migración de ruta      | Crear MigrationCase → pin target hash → diff → simulate mappings → review/approve → aplicar → nuevo target progress + carry-forward receipts → source MIGRATED.   |
| J-EC10-07 Emisión remota         | Eligibility ELIGIBLE → command EC-08 con idempotency/correlation → timeout → UNKNOWN_EFFECT → reconciliar → confirmar award ref o retry solo si no aplicado.      |
| J-EC10-08 As-of                  | Usuario pide fecha pasada → seleccionar snapshot/watermark ≤ asOf → aplicar hechos vigentes a ese instante → devolver provenance + dependencia.                   |
| J-EC10-09 Corporate aggregate    | EC-09 solicita agregado autorizado → validar ReportingProfile/minimum cohort → devolver métricas suprimidas cuando corresponda; nunca PII automática.             |
| J-EC10-10 IA asistiva            | Operador solicita explicación/sugerencia → CT-12 con grounding refs → recommendation visible → Apply/Reject humano → decisión final separada.                     |

# 

## 

| **Aggregate**                 | **Root**                      | **Responsabilidad**                                            | **Invariantes principales**                                                               |
|-------------------------------|-------------------------------|----------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| LearningTrajectory            | LearningTrajectory            | Agrupa la trayectoria longitudinal de una persona en un scope. | person_ref único por scope cuando policy lo exige; tenant immutable; revision monotónica. |
| PathwayProgress               | PathwayProgress               | Gobierna progreso contra una PathwayVersion exacta.            | pin immutable tras DRAFT; nodes/snapshots coherentes; completion temporal consistente.    |
| RecognitionClaim              | RecognitionClaim              | Gobierna solicitud, evidencia y decisión de reconocimiento.    | evidence refs íntegros; decisión terminal exige reason/policy/workflow.                   |
| PathwayMigrationCase          | PathwayMigrationCase          | Gobierna transición entre versiones de ruta.                   | source/target distintos; target hash fijo; apply produce target progress y receipts.      |
| CumulativeEligibilityDecision | CumulativeEligibilityDecision | Expresa elegibilidad de credencial derivada de snapshot.       | decision vinculada a snapshot/policy exactos; issuance es efecto externo EC-08.           |

## 

| **Tipo**       | **Elemento**              | **Rol**                                                     |
|----------------|---------------------------|-------------------------------------------------------------|
| Entity         | TrajectoryFact            | Ledger append-only de hechos fuente/compensatorios.         |
| Entity         | FactContribution          | Explica qué fact satisface qué nodo bajo qué policy.        |
| Entity         | NodeProgress              | Proyección por nodo.                                        |
| Entity         | ProgressSnapshot          | Snapshot inmutable/reproducible.                            |
| Entity         | RecognitionClaimEvidence  | Binding a CT-05 y estado de verificación.                   |
| Entity         | ManualOverride            | Excepción aprobada, versionable y reversible.               |
| Entity         | MigrationMapping          | Mapeo source/target de nodos.                               |
| Entity         | CarryForwardReceipt       | Lineage inmutable de contribuciones migradas.               |
| VO             | PathwayVersionRef         | id + versionNo + contentHash + resolutionStatus.            |
| VO             | SourceFactKey             | Business key idempotente tenant-scoped.                     |
| VO             | ProgressVector            | required/satisfied/blocked/percent con semántica explícita. |
| VO             | PolicySnapshot            | policy_ref + hash + evaluated_at.                           |
| VO             | DependencyState           | AVAILABLE/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.         |
| Domain Service | ProgressEvaluationService | Evalúa nodes/progress con inputs pinneados.                 |
| Domain Service | FactMatchingService       | Determina contribuciones sin mutar hechos.                  |
| Domain Service | PathwayMigrationService   | Diff/simulation/mapping/carry-forward.                      |
| Policy         | RecognitionPolicy         | Reglas de confianza, equivalencia y evidencia.              |
| Policy         | OverridePolicy            | Autorización, SoD, step-up, duración y reversión.           |
| Policy         | ExpiryPolicy              | Vigencia temporal de hechos/contribuciones.                 |

## 

1.  Resolver tenant/scope desde credencial autorizada.

2.  Abrir transacción y ejecutar SET LOCAL peopleu.tenant_id.

3.  Lock/revalidar Aggregate Root.

4.  Comparar If-Match con revision/ETag actual.

5.  Ejecutar método de intención; nunca generic setter para transición crítica.

6.  Persistir hijos y side effects locales.

7.  Incrementar revision del root una sola vez por intención lógica.

8.  Registrar audit/receipt/idempotency/outbox en la misma transacción cuando aplique.

9.  Commit.

10. Responder nuevo ETag; mismatch devuelve 412 PRECONDITION_FAILED sin auto-retry.

# 

| **Aggregate/Entity** | **Estados/transiciones**                                                                               | **Guardas**                                                                     |
|----------------------|--------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------|
| PathwayProgress      | DRAFT → ACTIVE → COMPLETED \| SUSPENDED \| MIGRATED \| CLOSED                                          | MIGRATED exige target progress y receipt; COMPLETED no equivale emisión.        |
| NodeProgress         | NOT_STARTED \| IN_PROGRESS \| SATISFIED \| BLOCKED \| MANUAL_REVIEW \| EXPIRED \| REVOKED \| WAIVED    | SATISFIED puede volver EXPIRED/REVOKED por hecho nuevo; historia vía snapshots. |
| RecognitionClaim     | DRAFT → SUBMITTED → VERIFYING → IN_REVIEW → ACCEPTED \| PARTIAL \| REJECTED \| WITHDRAWN               | Terminal exige policy/reason; ACCEPTED/PARTIAL puede crear fact reconocido.     |
| MigrationCase        | DRAFT → SIMULATED → IN_REVIEW → APPROVED → APPLYING → APPLIED \| FAILED \| CANCELLED \| UNKNOWN_EFFECT | No saltar simulation/review; UNKNOWN_EFFECT exige reconcile.                    |
| EligibilityDecision  | PENDING → ELIGIBLE \| NOT_ELIGIBLE → SUPERSEDED \| REVOKED                                             | Decision pinnea snapshot+policy.                                                |
| AsyncOperation       | PENDING → RUNNING → SUCCEEDED \| FAILED \| UNKNOWN_EFFECT \| CANCELLED                                 | 202 devuelve operationId; UNKNOWN_EFFECT no se trata como FAILED.               |

# 

| **ID**      | **Nombre**                        | **Regla implementable/verificable**                                                                                            |
|-------------|-----------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| BR-EC10-001 | Tenant obligatorio                | Toda fila tenant-owned usa tenant_id derivado del contexto, nunca de body libre.                                               |
| BR-EC10-002 | PK tenant-aware                   | Roots/entities críticas usan PK compuesta (tenant_id,id) o equivalente físicamente aislado.                                    |
| BR-EC10-003 | FK tenant-aware                   | Toda FK interna incluye tenant_id para impedir cross-tenant incluso con bug Backend.                                           |
| BR-EC10-004 | RLS obligatorio                   | Todas las tablas tenant-owned tienen ENABLE + FORCE RLS.                                                                       |
| BR-EC10-005 | Runtime sin bypass                | Rol runtime no es owner y no posee BYPASSRLS.                                                                                  |
| BR-EC10-006 | Persona externa                   | person_ref es EXT REF; no FK a CT-04 ni shadow editable de identidad.                                                          |
| BR-EC10-007 | Una trayectoria por scope         | La combinación person_ref + trajectory_scope_code activa es única cuando la policy institucional lo define.                    |
| BR-EC10-008 | Business key inmutable            | trajectory_scope_code no cambia tras existir progreso activo.                                                                  |
| BR-EC10-009 | Pin explícito                     | Crear PathwayProgress exige pathway_version_ref, version_no y content_hash resueltos.                                          |
| BR-EC10-010 | No latest histórico               | Ningún read/rebuild histórico sustituye pathway_version_ref por latest.                                                        |
| BR-EC10-011 | Hash verificado                   | Si EC-01 devuelve contenido con hash distinto al pin, el progreso entra en dependency conflict y no recalcula silenciosamente. |
| BR-EC10-012 | Pin inmutable                     | pathway_version_ref/version_no/content_hash no cambian después de DRAFT.                                                       |
| BR-EC10-013 | No self migration                 | migrated_from_progress_id nunca apunta al mismo progress.                                                                      |
| BR-EC10-014 | Root revision                     | Toda mutación semántica incrementa revision del aggregate root.                                                                |
| BR-EC10-015 | If-Match                          | Commands de aggregate mutable exigen If-Match salvo creación idempotente.                                                      |
| BR-EC10-016 | Fact append-only                  | TrajectoryFact no admite UPDATE/DELETE; corrección se modela como nuevo fact.                                                  |
| BR-EC10-017 | Source key idempotente            | source_fact_key es único por tenant y representa el mismo hecho lógico.                                                        |
| BR-EC10-018 | Payload mismatch                  | Misma source_fact_key con payload/provenance distinto se rechaza como conflicto.                                               |
| BR-EC10-019 | Event dedup                       | source_event_id duplicado no duplica el hecho ni sus contribuciones.                                                           |
| BR-EC10-020 | Occurred vs received              | received_at no sustituye occurred_at; ambos se preservan.                                                                      |
| BR-EC10-021 | Ventana válida                    | valid_until debe ser posterior a valid_from cuando exista.                                                                     |
| BR-EC10-022 | Provenance hash                   | Todo fact conserva hash de procedencia/canonical payload.                                                                      |
| BR-EC10-023 | Schema version                    | fact_payload declara payload_schema_version para replay determinista.                                                          |
| BR-EC10-024 | Fact type allowlist               | fact_type pertenece al catálogo gobernado; no free text operacional.                                                           |
| BR-EC10-025 | Source system gobernado           | source_system_code está allowlisted/configurado por tenant.                                                                    |
| BR-EC10-026 | Quarantine                        | Fact no verificable se QUARANTINEA; no se transforma en contribución favorable.                                                |
| BR-EC10-027 | Compensación explícita            | Revocación/corrección referencia el hecho previo; no lo borra.                                                                 |
| BR-EC10-028 | Fact no decide                    | La existencia de un fact no implica por sí sola NodeProgress SATISFIED.                                                        |
| BR-EC10-029 | Fact reusable gobernado           | Un fact puede contribuir a múltiples nodos solo si policy y pathway lo permiten.                                               |
| BR-EC10-030 | No futuro en as-of                | Consulta asOf ignora facts con occurred/effective time posterior al instante solicitado.                                       |
| BR-EC10-031 | Contribución explicable           | FactContribution siempre vincula fact, progress, node, contribution_kind y policy.                                             |
| BR-EC10-032 | Contribución acotada              | contribution_weight está en rango permitido por la regla del nodo.                                                             |
| BR-EC10-033 | Node same progress                | node_ref evaluado pertenece a la PathwayVersion pinneada del progress.                                                         |
| BR-EC10-034 | Node único                        | Solo existe un NodeProgress vigente por progress_id + node_ref.                                                                |
| BR-EC10-035 | Required weight positivo          | required_weight es positivo cuando el nodo es cuantitativo.                                                                    |
| BR-EC10-036 | Satisfied no excede policy        | satisfied_weight no supera el máximo permitido salvo overachievement explícito.                                                |
| BR-EC10-037 | Blocked explainable               | BLOCKED exige blocking_node_ref o reason_code.                                                                                 |
| BR-EC10-038 | Manual review explainable         | MANUAL_REVIEW exige reason_code y evidencia/dependency.                                                                        |
| BR-EC10-039 | Expired reversible por nuevo fact | EXPIRED puede volver SATISFIED únicamente por nuevo fact válido/policy; no por editar expiry.                                  |
| BR-EC10-040 | Revoked preserva historia         | REVOKED no elimina contribuciones previas; snapshot histórico sigue reproducible.                                              |
| BR-EC10-041 | Waiver gobernado                  | WAIVED solo proviene de ManualOverride aprobado con policy que lo permita.                                                     |
| BR-EC10-042 | Prerequisites respetados          | Un node no se marca SATISFIED si prerequisites hard siguen insatisfechos, salvo waiver autorizado.                             |
| BR-EC10-043 | Policy pinneada                   | Toda evaluación registra policy_ref/hash usados.                                                                               |
| BR-EC10-044 | EvaluatedAt UTC                   | evaluated_at y as_of se guardan en timestamptz UTC.                                                                            |
| BR-EC10-045 | Dependency status                 | Si una dependencia crítica está UNAVAILABLE, el node no adopta un estado favorable por defecto.                                |
| BR-EC10-046 | Snapshot append-only              | ProgressSnapshot no admite UPDATE/DELETE.                                                                                      |
| BR-EC10-047 | Snapshot monotónico               | snapshot_no es único y monotónico por progress.                                                                                |
| BR-EC10-048 | Snapshot engine version           | Cada snapshot registra engine_version.                                                                                         |
| BR-EC10-049 | Snapshot policy hash              | Cada snapshot registra policy_set_hash.                                                                                        |
| BR-EC10-050 | Snapshot pathway hash             | Cada snapshot registra pathway_content_hash idéntico al pin.                                                                   |
| BR-EC10-051 | Input watermark                   | Cada snapshot declara input_watermark verificable.                                                                             |
| BR-EC10-052 | Result hash                       | Snapshot conserva result_hash de canonical output.                                                                             |
| BR-EC10-053 | Progress range                    | progress_percent está entre 0 y 100 cuando es calculable; NULL significa no calculable, no cero.                               |
| BR-EC10-054 | Required nodes                    | required_nodes ≥ satisfied_nodes; valores no negativos.                                                                        |
| BR-EC10-055 | Completion guard                  | PathwayProgress COMPLETED exige todos los requisitos terminales de la policy o una excepción aprobada.                         |
| BR-EC10-056 | Completion timestamp              | completed_at solo existe en estado COMPLETED/MIGRATED/CLOSED según policy.                                                     |
| BR-EC10-057 | Current snapshot ref              | current_snapshot_id apunta al snapshot del mismo progress y tenant.                                                            |
| BR-EC10-058 | Rebuild determinista              | Mismos pathway hash + facts + policies + engine version producen mismo result_hash.                                            |
| BR-EC10-059 | Rebuild no destruye               | Rebuild crea nuevo snapshot; no reescribe snapshot anterior.                                                                   |
| BR-EC10-060 | Stale visible                     | Si watermark queda detrás del event stream, dependency_state=STALE/PARTIAL; no se presenta como current.                       |
| BR-EC10-061 | Claim target                      | RecognitionClaim identifica target pathway version y, si aplica, target_node_ref.                                              |
| BR-EC10-062 | Evidence externa                  | Evidence se almacena en CT-05; EC-10 conserva ref/hash/status.                                                                 |
| BR-EC10-063 | Evidence hash                     | Verificación conserva hash para detectar sustitución posterior.                                                                |
| BR-EC10-064 | Submit completo                   | SUBMITTED exige mínimo de evidence refs y declaration según claim_type.                                                        |
| BR-EC10-065 | Verifier separation               | Si policy lo exige, submitter no puede ser verifier/approver del mismo claim.                                                  |
| BR-EC10-066 | Decision terminal                 | ACCEPTED/PARTIAL/REJECTED exige decision_reason_code y policy snapshot.                                                        |
| BR-EC10-067 | Partial explícito                 | PARTIAL declara qué porción/nodos se reconocen; no equivale ACCEPTED total.                                                    |
| BR-EC10-068 | Accepted creates fact             | ACCEPTED/PARTIAL crea TrajectoryFact reconocido mediante idempotency key estable.                                              |
| BR-EC10-069 | No free overwrite                 | Claim terminal no vuelve a DRAFT; revisión posterior usa appeal/superseding claim.                                             |
| BR-EC10-070 | Withdraw policy                   | WITHDRAWN solo es posible antes de decisión terminal.                                                                          |
| BR-EC10-071 | External trust                    | Issuer externo debe cumplir TrustProfile vigente o claim queda MANUAL_REVIEW.                                                  |
| BR-EC10-072 | AI assist only                    | AI puede sugerir mapping/clasificación; nunca cambia state terminal.                                                           |
| BR-EC10-073 | Override reason                   | ManualOverride exige override_kind y reason_code gobernados.                                                                   |
| BR-EC10-074 | Override evidence                 | Override crítico exige evidence_ref/workflow_ref según policy.                                                                 |
| BR-EC10-075 | Override approval                 | approved_by_ref y approved_at son obligatorios antes de efecto.                                                                |
| BR-EC10-076 | Override immutable                | Override aplicado es inmutable; reversión crea superseding override.                                                           |
| BR-EC10-077 | Step-up override                  | Waiver/override de requisito terminal exige step-up cuando policy lo marque.                                                   |
| BR-EC10-078 | Migration target pin              | MigrationCase pinnea target PathwayVersion + content_hash antes de simulate.                                                   |
| BR-EC10-079 | Source target different           | Source y target versions deben ser distintas.                                                                                  |
| BR-EC10-080 | Simulation required               | APPROVED exige simulation_hash vigente respecto a source snapshot y target hash.                                               |
| BR-EC10-081 | Diff required                     | MigrationCase conserva diff_hash de definiciones source/target.                                                                |
| BR-EC10-082 | Mapping typed                     | MigrationMapping declara EXACT/EQUIVALENT/PARTIAL/DROPPED/NEW_REQUIRED u otro catálogo gobernado.                              |
| BR-EC10-083 | No self mapping                   | source_node_ref y target_node_ref no se usan como autojustificación sin policy.                                                |
| BR-EC10-084 | Mapping confidence                | confidence solo informa; no reemplaza aprobación.                                                                              |
| BR-EC10-085 | Apply idempotent                  | Apply migration usa Idempotency-Key durable y no crea dos target progresses.                                                   |
| BR-EC10-086 | Carry forward receipt             | Cada contribución transportada produce receipt append-only.                                                                    |
| BR-EC10-087 | Source migrated                   | Source progress se marca MIGRATED solo después de target creado y receipts confirmados.                                        |
| BR-EC10-088 | Unknown migration effect          | Si efecto remoto crítico queda ambiguo, case entra UNKNOWN_EFFECT; no se repite ciegamente.                                    |
| BR-EC10-089 | Eligibility snapshot              | CumulativeEligibilityDecision pinnea snapshot_id exacto.                                                                       |
| BR-EC10-090 | Eligibility policy                | Decision guarda policy_ref/hash.                                                                                               |
| BR-EC10-091 | Eligible explainable              | ELIGIBLE exige reason/evidence trace hasta nodes/facts.                                                                        |
| BR-EC10-092 | Not eligible explainable          | NOT_ELIGIBLE expone faltantes sin inferir información no disponible.                                                           |
| BR-EC10-093 | Decision immutable                | Decision terminal se supersede/revoca; no se edita.                                                                            |
| BR-EC10-094 | Blueprint external ref            | target_credential_blueprint_ref es EXT REF a EC-01/EC-08, sin FK externa.                                                      |
| BR-EC10-095 | Issuance separate                 | ELIGIBLE no crea award; solo habilita comando a EC-08.                                                                         |
| BR-EC10-096 | Issuance idempotency              | Solicitud a EC-08 usa idempotency/correlation estable por decisión lógica.                                                     |
| BR-EC10-097 | Issuance unknown                  | Timeout de EC-08 se registra UNKNOWN_EFFECT con operation/receipt.                                                             |
| BR-EC10-098 | Reconcile before retry            | Retry de emisión solo ocurre si consulta demuestra que no fue aplicada.                                                        |
| BR-EC10-099 | Award confirmation                | issued_award_ref se registra solo tras confirmación confiable.                                                                 |
| BR-EC10-100 | Revocation downstream             | Revocación del award fuente dispara reevaluación; no borra decisión previa.                                                    |
| BR-EC10-101 | Same key same payload             | Idempotency-Key repetida con mismo request_hash devuelve mismo resultado lógico.                                               |
| BR-EC10-102 | Same key different payload        | Misma key con payload distinto devuelve 409 IDEMPOTENCY_KEY_REUSED.                                                            |
| BR-EC10-103 | Lease recovery                    | IN_PROGRESS exige lease_owner/lease_until y admite recovery gobernado al expirar.                                              |
| BR-EC10-104 | Outbox atomic                     | State + receipt + audit + outbox se persisten en la misma transacción para transición crítica.                                 |
| BR-EC10-105 | Outbox leased                     | Dispatch multi-instancia usa ownership durable y SKIP LOCKED.                                                                  |
| BR-EC10-106 | Inbox dedup                       | Consumer + event_id es único y evita reprocesamiento duplicado.                                                                |
| BR-EC10-107 | At-least-once explícito           | No se promete exactly-once distribuido; consumers son idempotentes.                                                            |
| BR-EC10-108 | ProblemDetail                     | Errores API usan ProblemDetail con reasonCode/correlationId/fieldErrors.                                                       |
| BR-EC10-109 | Pagination bounded                | Listas usan page/cursor con límites máximos y sort allowlist.                                                                  |
| BR-EC10-110 | No mass assignment                | Commands aceptan DTOs de intención; no bind directo a entities.                                                                |
| BR-EC10-111 | Purpose limitation                | Export/consulta sensible exige purpose y scope autorizados.                                                                    |
| BR-EC10-112 | Field privacy                     | PII derivada se minimiza y se enmascara por permiso/purpose.                                                                   |
| BR-EC10-113 | Corporate suppression             | Agregado corporativo respeta minimum cohort size y suppression de EC-09.                                                       |
| BR-EC10-114 | Audit before-after                | Mutación relevante registra before/after semántico o hashes cuando PII lo desaconseje.                                         |
| BR-EC10-115 | No blind retry                    | Toda operación remota con efecto evita retry ciego ante timeout.                                                               |
| BR-EC10-116 | Zero downtime                     | Migraciones usan expand/deploy/backfill/switch/contract N/N-1.                                                                 |
| BR-EC10-117 | Migration API only                | CT-16 promueve datos mediante dominio/API; no INSERT final directo.                                                            |
| BR-EC10-118 | AI CT-12 only                     | No existe SDK directo de OpenAI/proveedor en EC-10.                                                                            |
| BR-EC10-119 | AI provenance                     | Toda recommendation conserva run_ref/model_ref/template/eval/grounding/confidence/reviewer/outcome.                            |
| BR-EC10-120 | Mobile least privilege            | Mobile no expone migration/override admin crítico sin justificación y step-up.                                                 |
| BR-EC10-121 | Offline stale                     | Mobile offline muestra asOf/STALE; no afirma estado actual.                                                                    |
| BR-EC10-122 | Redis non-authoritative           | Pérdida de Redis no pierde facts/decisions; cache se reconstruye.                                                              |
| BR-EC10-123 | Observability no PII              | Logs/traces no incluyen evidence payload ni PII sensible por defecto.                                                          |
| BR-EC10-124 | Security gates                    | SAST/SCA/secrets/container/SBOM y tests RLS son gate de release.                                                               |
| BR-EC10-125 | Performance bounded               | Rebuild masivo se ejecuta async con quotas; no bloquea request síncrono.                                                       |
| BR-EC10-126 | Export audited                    | Toda exportación sensible produce audit + purpose + subject/scope.                                                             |
| BR-EC10-127 | As-of immutable                   | Una respuesta histórica incluye asOf, snapshot/watermark y provenance.                                                         |
| BR-EC10-128 | ETag conflict visible             | 412 no auto-retry; UI muestra conflict/reload/diff/reapply.                                                                    |
| BR-EC10-129 | Dependency states                 | NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT no se colapsan.                                                          |
| BR-EC10-130 | Release evidence                  | Ningún Gate G1-G10 se aprueba sin evidencia versionada en Engineering Pack.                                                    |

# 

| **ID**      | **Caso de uso**                       | **Actor principal**                                 | **Contrato mínimo**                                                       |
|-------------|---------------------------------------|-----------------------------------------------------|---------------------------------------------------------------------------|
| UC-EC10-001 | Crear LearningTrajectory              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-002 | Consultar trayectoria                 | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-003 | Buscar trayectorias                   | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-004 | Iniciar PathwayProgress               | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-005 | Activar PathwayProgress               | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-006 | Consultar resumen de progreso         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-007 | Consultar nodos                       | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-008 | Consultar faltantes                   | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-009 | Consultar next actions                | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-010 | Consultar historia as-of              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-011 | Ingerir Completion EC-07              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-012 | Ingerir CredentialAward EC-08         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-013 | Ingerir Revocation EC-08              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-014 | Ingerir expiry fact                   | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-015 | Reprocesar fact en quarantine         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-016 | Recalcular progreso                   | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-017 | Rebuild determinista                  | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-018 | Crear snapshot                        | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-019 | Comparar snapshots                    | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-020 | Explicar nodo                         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-021 | Crear RecognitionClaim                | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-022 | Adjuntar evidence ref                 | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-023 | Enviar claim                          | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-024 | Verificar evidencia                   | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-025 | Solicitar información adicional       | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-026 | Aceptar claim                         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-027 | Aceptar parcialmente claim            | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-028 | Rechazar claim                        | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-029 | Retirar claim                         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-030 | Crear ManualOverride                  | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-031 | Revertir ManualOverride               | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-032 | Crear MigrationCase                   | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-033 | Simular migración                     | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-034 | Editar mappings                       | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-035 | Enviar migración a review             | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-036 | Aprobar migración                     | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-037 | Aplicar migración                     | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-038 | Reconciliar migración UNKNOWN_EFFECT  | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-039 | Consultar carry-forward receipts      | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-040 | Comparar ruta source/target           | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-041 | Evaluar cumulative eligibility        | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-042 | Consultar decisiones                  | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-043 | Solicitar emisión EC-08               | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-044 | Reconciliar emisión UNKNOWN_EFFECT    | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-045 | Confirmar award emitido               | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-046 | Procesar revocación downstream        | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-047 | Suspender progreso                    | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-048 | Reactivar progreso                    | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-049 | Cerrar trayectoria                    | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-050 | Crear/editar goals                    | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-051 | Consultar lineage fact→snapshot       | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-052 | Consultar audit/evidence pack         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-053 | Exportar trayectoria autorizada       | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-054 | Solicitar agregado corporate          | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-055 | Rebuild batch                         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-056 | Invalidar cache                       | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-057 | Consultar OperationStatus             | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-058 | Cancelar operación cancelable         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-059 | Reconciliar operation                 | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-060 | Replay técnico de evento              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-061 | Consultar health dependencies         | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-062 | Consultar KPI operativos              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-063 | Solicitar explicación IA              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-064 | Solicitar sugerencia mapping IA       | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-065 | Aplicar/rechazar recomendación IA     | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-066 | Dry-run migración legacy CT-16        | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-067 | Promover legacy CT-16                 | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-068 | Reconciliar legacy                    | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-069 | Certificar data quality               | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-070 | Rotar policy snapshot                 | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-071 | Detectar pathway hash mismatch        | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-072 | Resolver dependency STALE             | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-073 | Refrescar pathway metadata            | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-074 | Consultar self-service                | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-075 | Crear draft claim mobile              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-076 | Sincronizar draft mobile              | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-077 | Deep link a achievement wallet        | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-078 | Reviewer mobile quick action          | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-079 | Anonimizar projection no autoritativa | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |
| UC-EC10-080 | Consultar retention candidates        | Participante/Advisor/Ops/Reviewer/SRE según permiso | Comando/query gobernado con tenant, auth, contract y audit cuando aplique |

## 

### 

| **Aspecto**       | **Especificación**                                                           |
|-------------------|------------------------------------------------------------------------------|
| Actor             | Advisor o participante autorizado                                            |
| Trigger           | Pathway seleccionado                                                         |
| Precondiciones    | Trayectoria activa; EC-01 AVAILABLE                                          |
| Autorización      | CREATE_PROGRESS + scope                                                      |
| Happy Path        | Resolver pin/hash → validar no duplicado → crear DRAFT → audit/outbox → ETag |
| Alternativas      | EC-01 STALE/PARTIAL; ya existe; hash conflict                                |
| Errores           | 503/409/422                                                                  |
| Idempotencia      | Idempotency-Key                                                              |
| Concurrencia      | If-Match no aplica en create; uniqueness DB                                  |
| Auditoría/Eventos | Audit + ProgressStarted                                                      |
| Postcondición     | DRAFT con pin inmutable                                                      |

### 

| **Aspecto**       | **Especificación**                                                                                       |
|-------------------|----------------------------------------------------------------------------------------------------------|
| Actor             | Integration worker                                                                                       |
| Trigger           | CompletionEvent EC-07                                                                                    |
| Precondiciones    | Inbox no procesado                                                                                       |
| Autorización      | SERVICE_SCOPE                                                                                            |
| Happy Path        | Dedup → canonical hash → TrajectoryFact append-only → match → contributions → recalc → snapshot → outbox |
| Alternativas      | Duplicado same payload = replay OK; diff payload = quarantine                                            |
| Errores           | 409/202                                                                                                  |
| Idempotencia      | event_id/source_fact_key                                                                                 |
| Concurrencia      | Lock progress; one revision bump                                                                         |
| Auditoría/Eventos | FactAccepted + ProgressChanged                                                                           |
| Postcondición     | Proyección actualizada o PARTIAL visible                                                                 |

### 

| **Aspecto**       | **Especificación**                       |
|-------------------|------------------------------------------|
| Actor             | Participante/Advisor                     |
| Trigger           | Evidencia a reconocer                    |
| Precondiciones    | Target válido                            |
| Autorización      | CREATE_CLAIM                             |
| Happy Path        | Crear DRAFT → target/policy refs → ETag  |
| Alternativas      | Target unavailable; duplicate open claim |
| Errores           | 422/409/503                              |
| Idempotencia      | Idempotency-Key                          |
| Concurrencia      | Root revision                            |
| Auditoría/Eventos | Audit                                    |
| Postcondición     | Claim DRAFT                              |

### 

| **Aspecto**       | **Especificación**                                                                |
|-------------------|-----------------------------------------------------------------------------------|
| Actor             | Reviewer/Approver                                                                 |
| Trigger           | Claim IN_REVIEW                                                                   |
| Precondiciones    | Evidence verificada; SoD; policy                                                  |
| Autorización      | DECIDE_CLAIM + step-up si aplica                                                  |
| Happy Path        | Lock → If-Match → decisión ACCEPTED → receipt → fact reconocido → recalc → outbox |
| Alternativas      | Policy changed; evidence stale; SoD                                               |
| Errores           | 412/403/422                                                                       |
| Idempotencia      | Idempotency-Key                                                                   |
| Concurrencia      | Optimistic + row lock                                                             |
| Auditoría/Eventos | Decision receipt + FactAccepted                                                   |
| Postcondición     | Claim terminal + progreso derivado                                                |

### 

| **Aspecto**       | **Especificación**                         |
|-------------------|--------------------------------------------|
| Actor             | Advisor/Ops                                |
| Trigger           | Nueva PathwayVersion                       |
| Precondiciones    | Source progress ACTIVE; target resolvible  |
| Autorización      | MIGRATE_PATHWAY                            |
| Happy Path        | Pin target/hash → diff hash → DRAFT → ETag |
| Alternativas      | Target same version; hash conflict         |
| Errores           | 409/422                                    |
| Idempotencia      | Idempotency-Key                            |
| Concurrencia      | Unique open target migration               |
| Auditoría/Eventos | Audit                                      |
| Postcondición     | Case DRAFT                                 |

### 

| **Aspecto**       | **Especificación**                                                                                                  |
|-------------------|---------------------------------------------------------------------------------------------------------------------|
| Actor             | Approver/Ops                                                                                                        |
| Trigger           | MigrationCase APPROVED                                                                                              |
| Precondiciones    | Simulation current; mappings completos                                                                              |
| Autorización      | APPLY_MIGRATION + step-up                                                                                           |
| Happy Path        | Lock case/source → create target progress → carry-forward contribs + receipts → snapshot → source MIGRATED → outbox |
| Alternativas      | Remote dependency timeout → UNKNOWN_EFFECT where applicable                                                         |
| Errores           | 412/202/422                                                                                                         |
| Idempotencia      | Durable key                                                                                                         |
| Concurrencia      | Locks + uniqueness                                                                                                  |
| Auditoría/Eventos | MigrationApplied + receipts                                                                                         |
| Postcondición     | Target active/consistent                                                                                            |

### 

| **Aspecto**       | **Especificación**                                       |
|-------------------|----------------------------------------------------------|
| Actor             | Credential Ops                                           |
| Trigger           | Snapshot actual                                          |
| Precondiciones    | Pathway/policy AVAILABLE                                 |
| Autorización      | EVALUATE_ELIGIBILITY                                     |
| Happy Path        | Pin snapshot/policy → compute → append decision → outbox |
| Alternativas      | Missing dependency → PENDING/PARTIAL not favorable       |
| Errores           | 422/503                                                  |
| Idempotencia      | Idempotent by snapshot+blueprint+policy                  |
| Concurrencia      | Unique terminal per semantic key                         |
| Auditoría/Eventos | Decision receipt                                         |
| Postcondición     | ELIGIBLE o NOT_ELIGIBLE explainable                      |

### 

| **Aspecto**       | **Especificación**                                                       |
|-------------------|--------------------------------------------------------------------------|
| Actor             | Credential Ops                                                           |
| Trigger           | ELIGIBLE decision                                                        |
| Precondiciones    | EC-08 contract reachable or async                                        |
| Autorización      | REQUEST_ISSUANCE                                                         |
| Happy Path        | Command with stable key/correlation → 2xx confirm award OR 202 operation |
| Alternativas      | Timeout → UNKNOWN_EFFECT → reconcile, no blind retry                     |
| Errores           | 202/503                                                                  |
| Idempotencia      | Stable logical key                                                       |
| Concurrencia      | Decision state guarded                                                   |
| Auditoría/Eventos | IssuanceRequested                                                        |
| Postcondición     | Confirmed award ref o UNKNOWN_EFFECT                                     |

### 

| **Aspecto**       | **Especificación**                                                                  |
|-------------------|-------------------------------------------------------------------------------------|
| Actor             | Participant/Auditor                                                                 |
| Trigger           | asOf timestamp                                                                      |
| Precondiciones    | Read scope                                                                          |
| Autorización      | VIEW_HISTORY                                                                        |
| Happy Path        | Select snapshot/watermark \<= asOf → reconstruct with facts valid then → provenance |
| Alternativas      | Data archived dependency PARTIAL                                                    |
| Errores           | 200/206 semantics in DTO                                                            |
| Idempotencia      | N/A                                                                                 |
| Concurrencia      | Read-only                                                                           |
| Auditoría/Eventos | Read audit if sensitive                                                             |
| Postcondición     | Historical result never polluted by future fact                                     |

### 

| **Aspecto**       | **Especificación**                                       |
|-------------------|----------------------------------------------------------|
| Actor             | Advisor/Ops                                              |
| Trigger           | Reason                                                   |
| Precondiciones    | Progress ACTIVE                                          |
| Autorización      | SUSPEND_PROGRESS                                         |
| Happy Path        | If-Match → reason → SUSPENDED → audit/outbox             |
| Alternativas      | Already terminal                                         |
| Errores           | 412/409                                                  |
| Idempotencia      | Idempotency-Key                                          |
| Concurrencia      | ETag                                                     |
| Auditoría/Eventos | ProgressSuspended                                        |
| Postcondición     | No new automatic favorable transitions until reactivated |

### 

| **Aspecto**       | **Especificación**                                                            |
|-------------------|-------------------------------------------------------------------------------|
| Actor             | Migration Operator                                                            |
| Trigger           | CT-16 mapped dataset                                                          |
| Precondiciones    | Rules/version fixed                                                           |
| Autorización      | MIGRATION_DRY_RUN                                                             |
| Happy Path        | Extract/normalize/map → validate → simulate official commands → report errors |
| Alternativas      | DQ failures do not promote                                                    |
| Errores           | 422 report                                                                    |
| Idempotencia      | Batch key                                                                     |
| Concurrencia      | No final mutation                                                             |
| Auditoría/Eventos | Migration evidence                                                            |
| Postcondición     | Dry-run certified/not certified                                               |

### 

| **Aspecto**       | **Especificación**                                     |
|-------------------|--------------------------------------------------------|
| Actor             | Caller/Ops                                             |
| Trigger           | operationId                                            |
| Precondiciones    | Scope authorized                                       |
| Autorización      | VIEW_OPERATION                                         |
| Happy Path        | Read state/progress/reason/result/reconciliation hints |
| Alternativas      | UNKNOWN_EFFECT preserved                               |
| Errores           | 200/404                                                |
| Idempotencia      | N/A                                                    |
| Concurrencia      | ETag optional for cancelable op                        |
| Auditoría/Eventos | Read telemetry                                         |
| Postcondición     | Caller can safely decide next step                     |

# 

<img src="media/image2.png" style="width:6.8in;height:4.76in" />

Figura 2 — DER lógico simplificado de EC-10

## 

LearningTrajectory contiene uno o más PathwayProgress y TrajectoryFact. Cada PathwayProgress materializa NodeProgress y una secuencia append-only de ProgressSnapshot. RecognitionClaim puede producir un TrajectoryFact reconocido; PathwayMigrationCase crea un nuevo PathwayProgress y CarryForwardReceipts; CumulativeEligibilityDecision consume un snapshot exacto y puede iniciar un efecto remoto en EC-08.

## 

- Todas las relaciones internas son tenant-aware.

- Refs a CT/EC externos son UUID/text opacos sin FK física cross-context.

- Facts/snapshots/receipts son append-only.

- La proyección puede reconstruirse desde PathwayVersion pinneada + facts + policies + engine version.

- Current snapshot es un puntero optimizador, no la única historia.

- Indexes parciales protegen unicidad de casos/progresos abiertos.

# 

El esquema físico propuesto es ec10. Las tablas tenant-owned utilizan claves y FKs internas tenant-aware. Las referencias a otros bounded contexts son EXT REF sin FK física. En cada tabla se explicita qué debe impedir PostgreSQL aun si Backend tiene un bug.

## 

Raíz longitudinal que agrupa la experiencia EC de una persona dentro de un scope institucional. No duplica persona ni enrollment.

Participación arquitectónica — Aggregate/área gobernante: LearningTrajectory. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Cruce de tenant, duplicidad de scope y revisiones incoherentes. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                                       | **Ejemplo**       |
|-----------------------|---------------------|----------|-------------------|-------------|-------------------------------------------------------|-------------------|
| tenant_id             | uuid                | NO       | \-                | PK/FK scope | Tenant propietario; proviene de TenantContext.        | b4b0…             |
| id                    | uuid                | NO       | gen_random_uuid() | PK          | Identidad opaca local.                                | 5f2a…             |
| person_ref            | uuid                | NO       | \-                | EXT REF     | Referencia a persona CT-04; no FK física.             | 0d19…             |
| trajectory_scope_code | varchar(80)         | NO       | \-                | BK          | Scope institucional/vertical gobernado.               | EC_GLOBAL         |
| state                 | varchar(24)         | NO       | 'ACTIVE'          | CHECK       | Lifecycle de trayectoria.                             | ACTIVE            |
| primary_locale        | varchar(16)         | NO       | 'es-BO'           | \-          | Locale preferido para UI; no altera verdad académica. | es-BO             |
| revision              | bigint              | NO       | 0                 | ETag        | Versión optimista del aggregate.                      | 12                |
| created_at            | timestamptz         | NO       | now()             | audit       | Creación UTC.                                         | 2026-09-12T16:00Z |
| created_by_ref        | uuid                | NO       | \-                | actor       | Actor creador opaco.                                  | 78aa…             |
| updated_at            | timestamptz         | NO       | now()             | audit       | Última mutación semántica.                            | 2026-09-12T16:04Z |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 5f2a….

**person_ref —** Referencia a persona CT-04; no FK física. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 0d19….

**trajectory_scope_code —** Scope institucional/vertical gobernado. Tipo físico varchar(80); nulabilidad NO; default -; rol de clave BK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: EC_GLOBAL.

**state —** Lifecycle de trayectoria. Tipo físico varchar(24); nulabilidad NO; default 'ACTIVE'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ACTIVE.

**primary_locale —** Locale preferido para UI; no altera verdad académica. Tipo físico varchar(16); nulabilidad NO; default 'es-BO'; rol de clave -. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: es-BO.

**revision —** Contador de concurrencia optimista. Toda mutación semántica del aggregate lo incrementa y se materializa como ETag; no es timestamp. Tipo físico bigint; nulabilidad NO; default 0; rol de clave ETag. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 12.

**created_at —** Creación UTC. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 2026-09-12T16:00Z.

**created_by_ref —** Actor creador opaco. Tipo físico uuid; nulabilidad NO; default -; rol de clave actor. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 78aa….

**updated_at —** Última mutación semántica. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 2026-09-12T16:04Z.

### 

| **Nombre físico**                      | **Tipo**       | **Definición/expresión**                                             | **Error que impide**                      |
|----------------------------------------|----------------|----------------------------------------------------------------------|-------------------------------------------|
| pk_ec10_learning_trajectory            | PK             | (tenant_id,id)                                                       | Duplicar identidad                        |
| uq_ec10_trajectory_person_scope_active | PARTIAL UNIQUE | (tenant_id,person_ref,trajectory_scope_code) WHERE state\<\>'CLOSED' | Dos trayectorias activas para mismo scope |
| ck_ec10_trajectory_state               | CHECK          | state IN ('ACTIVE','SUSPENDED','CLOSED')                             | Estado inválido                           |
| rls_ec10_learning_trajectory           | RLS            | tenant_id = current_tenant_id()                                      | Acceso cross-tenant                       |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Cruce de tenant, duplicidad de scope y revisiones incoherentes. |
|---------------------------------------------------------------------------------------------------------------------------------|

## 

Aggregate root de progreso contra una PathwayVersion exacta. Preserva el pin académico y el lifecycle de ejecución longitudinal.

Participación arquitectónica — Aggregate/área gobernante: PathwayProgress. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Rebinding silencioso de versión, self-migration, duplicados activos y completion incoherente. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**            | **Descripción**                                | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|----------------------|------------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | \-                | PK/FK scope          | Tenant propietario; proviene de TenantContext. | b4b0…             |
| id                        | uuid                | NO       | gen_random_uuid() | PK                   | Identidad opaca local.                         | 5f2a…             |
| trajectory_id             | uuid                | NO       | \-                | FK internal          | LearningTrajectory propietaria.                | 5f2a…             |
| pathway_definition_ref    | uuid                | NO       | \-                | EXT REF              | Identidad estable de ruta EC-01.               | 9c11…             |
| pathway_version_ref       | uuid                | NO       | \-                | EXT REF              | Versión exacta EC-01.                          | 9d22…             |
| pathway_version_no        | integer             | NO       | \-                | snapshot             | Número de versión pinneado.                    | 3                 |
| pathway_content_hash      | varchar(128)        | NO       | \-                | snapshot             | Hash canonical de PathwayVersion.              | sha256:…          |
| state                     | varchar(24)         | NO       | 'DRAFT'           | CHECK                | Lifecycle normativo.                           | ACTIVE            |
| started_at                | timestamptz         | YES      | NULL              | \-                   | Inicio efectivo.                               | 2026-09-12T16:05Z |
| completed_at              | timestamptz         | YES      | NULL              | \-                   | Completion de trayectoria, no award.           | NULL              |
| migrated_from_progress_id | uuid                | YES      | NULL              | FK internal          | Lineage desde progreso previo.                 | 1a2b…             |
| current_snapshot_id       | uuid                | YES      | NULL              | FK internal deferred | Puntero optimizador a snapshot actual.         | 8e4f…             |
| dependency_state          | varchar(24)         | NO       | 'AVAILABLE'       | CHECK                | Frescura de dependencias.                      | AVAILABLE         |
| revision                  | bigint              | NO       | 0                 | ETag                 | Versión optimista aggregate.                   | 17                |
| created_at                | timestamptz         | NO       | now()             | audit                | Creación.                                      | …                 |
| updated_at                | timestamptz         | NO       | now()             | audit                | Última mutación.                               | …                 |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 5f2a….

**trajectory_id —** LearningTrajectory propietaria. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 5f2a….

**pathway_definition_ref —** Identidad estable de ruta EC-01. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 9c11….

**pathway_version_ref —** Versión exacta EC-01. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 9d22….

**pathway_version_no —** Número de versión pinneado. Tipo físico integer; nulabilidad NO; default -; rol de clave snapshot. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 3.

**pathway_content_hash —** Hash canonical de PathwayVersion. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave snapshot. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: sha256:….

**state —** Lifecycle normativo. Tipo físico varchar(24); nulabilidad NO; default 'DRAFT'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ACTIVE.

**started_at —** Inicio efectivo. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave -. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 2026-09-12T16:05Z.

**completed_at —** Completion de trayectoria, no award. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave -. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: NULL.

**migrated_from_progress_id —** Lineage desde progreso previo. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 1a2b….

**current_snapshot_id —** Puntero optimizador a snapshot actual. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave FK internal deferred. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 8e4f….

**dependency_state —** Frescura de dependencias. Tipo físico varchar(24); nulabilidad NO; default 'AVAILABLE'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: AVAILABLE.

**revision —** Contador de concurrencia optimista. Toda mutación semántica del aggregate lo incrementa y se materializa como ETag; no es timestamp. Tipo físico bigint; nulabilidad NO; default 0; rol de clave ETag. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 17.

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**updated_at —** Última mutación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

### 

| **Nombre físico**                  | **Tipo**       | **Definición/expresión**                                              | **Error que impide** |
|------------------------------------|----------------|-----------------------------------------------------------------------|----------------------|
| pk_ec10_pathway_progress           | PK             | (tenant_id,id)                                                        | Duplicar progreso    |
| fk_ec10_progress_trajectory        | FK             | (tenant_id,trajectory_id) → learning_trajectory                       | Cruzar tenant/root   |
| uq_ec10_progress_path_active       | PARTIAL UNIQUE | (tenant_id,trajectory_id,pathway_version_ref) WHERE state\<\>'CLOSED' | Duplicado lógico     |
| ck_ec10_progress_state             | CHECK          | state allowlist                                                       | Estado inválido      |
| ck_ec10_progress_not_self_migrated | CHECK          | migrated_from_progress_id IS NULL OR migrated_from_progress_id\<\>id  | Auto-lineage         |
| trg_ec10_progress_pin_immutable    | TRIGGER        | pin fields immutable after DRAFT                                      | Rebinding histórico  |
| rls_ec10_pathway_progress          | RLS            | tenant policy                                                         | Cross-tenant         |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Rebinding silencioso de versión, self-migration, duplicados activos y completion incoherente. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 

Ledger append-only de hechos que alimentan la trayectoria: completion, award, revocation, recognition, expiry o compensación.

Participación arquitectónica — Aggregate/área gobernante: LearningTrajectory. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Mutación/borrado de historia, duplicados y payload conflictivo. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                | **Ejemplo**           |
|------------------------|---------------------|----------|-------------------|---------------|------------------------------------------------|-----------------------|
| tenant_id              | uuid                | NO       | \-                | PK/FK scope   | Tenant propietario; proviene de TenantContext. | b4b0…                 |
| id                     | uuid                | NO       | gen_random_uuid() | PK            | Identidad opaca local.                         | 5f2a…                 |
| trajectory_id          | uuid                | NO       | \-                | FK internal   | Trayectoria receptora.                         | 5f2a…                 |
| source_fact_key        | varchar(200)        | NO       | \-                | UQ BK         | Clave idempotente del hecho.                   | ec07:completion:123   |
| fact_type              | varchar(50)         | NO       | \-                | CHECK/catalog | Tipo semántico.                                | COMPLETION_CONFIRMED  |
| source_system_code     | varchar(60)         | NO       | \-                | catalog       | Sistema fuente.                                | EC07                  |
| source_ref             | varchar(200)        | NO       | \-                | EXT REF       | ID opaco fuente.                               | completion:123        |
| source_event_id        | uuid                | YES      | NULL              | dedup         | ID de evento recibido.                         | …                     |
| occurred_at            | timestamptz         | NO       | \-                | time          | Cuándo ocurrió el hecho.                       | …                     |
| received_at            | timestamptz         | NO       | now()             | time          | Cuándo EC-10 lo recibió.                       | …                     |
| valid_from             | timestamptz         | YES      | NULL              | time          | Inicio de vigencia.                            | …                     |
| valid_until            | timestamptz         | YES      | NULL              | time          | Fin de vigencia.                               | …                     |
| status                 | varchar(24)         | NO       | 'ACCEPTED'        | CHECK         | ACCEPTED/QUARANTINED/SUPERSEDED.               | ACCEPTED              |
| provenance_hash        | varchar(128)        | NO       | \-                | integrity     | Hash de procedencia/canonical input.           | sha256:…              |
| payload_schema_version | integer             | NO       | 1                 | schema        | Versión del payload.                           | 1                     |
| fact_payload           | jsonb               | NO       | '{}'::jsonb       | payload       | Payload mínimo derivado, no PII excesiva.      | {"completion":"PASS"} |
| created_at             | timestamptz         | NO       | now()             | audit         | Insert UTC.                                    | …                     |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 5f2a….

**trajectory_id —** Trayectoria receptora. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 5f2a….

**source_fact_key —** Clave idempotente del hecho. Tipo físico varchar(200); nulabilidad NO; default -; rol de clave UQ BK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ec07:completion:123.

**fact_type —** Tipo semántico. Tipo físico varchar(50); nulabilidad NO; default -; rol de clave CHECK/catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: COMPLETION_CONFIRMED.

**source_system_code —** Sistema fuente. Tipo físico varchar(60); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: EC07.

**source_ref —** ID opaco fuente. Tipo físico varchar(200); nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: completion:123.

**source_event_id —** ID de evento recibido. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave dedup. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ….

**occurred_at —** Cuándo ocurrió el hecho. Tipo físico timestamptz; nulabilidad NO; default -; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ….

**received_at —** Cuándo EC-10 lo recibió. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ….

**valid_from —** Inicio de vigencia. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ….

**valid_until —** Fin de vigencia. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ….

**status —** ACCEPTED/QUARANTINED/SUPERSEDED. Tipo físico varchar(24); nulabilidad NO; default 'ACCEPTED'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ACCEPTED.

**provenance_hash —** Hash de procedencia/canonical input. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: sha256:….

**payload_schema_version —** Versión del payload. Tipo físico integer; nulabilidad NO; default 1; rol de clave schema. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: 1.

**fact_payload —** Payload mínimo derivado, no PII excesiva. Tipo físico jsonb; nulabilidad NO; default '{}'::jsonb; rol de clave payload. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: {"completion":"PASS"}.

**created_at —** Insert UTC. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en LearningTrajectory. Ejemplo: ….

### 

| **Nombre físico**         | **Tipo**       | **Definición/expresión**                                             | **Error que impide** |
|---------------------------|----------------|----------------------------------------------------------------------|----------------------|
| uq_ec10_fact_source_key   | UNIQUE         | (tenant_id,source_fact_key)                                          | Duplicado lógico     |
| uq_ec10_fact_event        | PARTIAL UNIQUE | (tenant_id,source_event_id) WHERE source_event_id IS NOT NULL        | Evento duplicado     |
| ck_ec10_fact_validity     | CHECK          | valid_until IS NULL OR valid_from IS NULL OR valid_until\>valid_from | Ventana imposible    |
| trg_ec10_fact_append_only | TRIGGER        | forbid UPDATE/DELETE                                                 | Reescribir historia  |
| rls_ec10_trajectory_fact  | RLS            | tenant policy                                                        | Cross-tenant         |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Mutación/borrado de historia, duplicados y payload conflictivo. |
|---------------------------------------------------------------------------------------------------------------------------------|

## 

Relación explicable entre un TrajectoryFact y un nodo de PathwayProgress bajo una policy exacta.

Participación arquitectónica — Aggregate/área gobernante: PathwayProgress. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Contribuciones cross-progress, pesos inválidos o sin policy. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                | **Ejemplo**          |
|---------------------|---------------------|----------|-------------------|---------------|------------------------------------------------|----------------------|
| tenant_id           | uuid                | NO       | \-                | PK/FK scope   | Tenant propietario; proviene de TenantContext. | b4b0…                |
| id                  | uuid                | NO       | gen_random_uuid() | PK            | Identidad opaca local.                         | 5f2a…                |
| fact_id             | uuid                | NO       | \-                | FK internal   | Fact origen.                                   | …                    |
| progress_id         | uuid                | NO       | \-                | FK internal   | PathwayProgress destino.                       | …                    |
| node_ref            | uuid                | NO       | \-                | EXT REF EC-01 | Nodo pinneado.                                 | …                    |
| contribution_kind   | varchar(40)         | NO       | \-                | CHECK         | SATISFY/PARTIAL/WAIVE/REVOKE/etc.              | SATISFY              |
| contribution_weight | numeric(12,4)       | NO       | 1                 | CHECK         | Peso aplicado.                                 | 1.0000               |
| policy_ref          | varchar(200)        | NO       | \-                | EXT REF       | Policy aplicada.                               | policy://stacking/v3 |
| policy_hash         | varchar(128)        | NO       | \-                | integrity     | Hash de policy.                                | sha256:…             |
| decision_ref        | uuid                | YES      | NULL              | internal/EXT  | Claim/override/decision que justificó.         | …                    |
| effective_from      | timestamptz         | NO       | now()             | time          | Inicio de efecto.                              | …                    |
| effective_until     | timestamptz         | YES      | NULL              | time          | Fin de efecto.                                 | NULL                 |
| created_at          | timestamptz         | NO       | now()             | audit         | Creación.                                      | …                    |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 5f2a….

**fact_id —** Fact origen. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**progress_id —** PathwayProgress destino. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**node_ref —** Nodo pinneado. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF EC-01. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**contribution_kind —** SATISFY/PARTIAL/WAIVE/REVOKE/etc. Tipo físico varchar(40); nulabilidad NO; default -; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: SATISFY.

**contribution_weight —** Peso aplicado. Tipo físico numeric(12,4); nulabilidad NO; default 1; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 1.0000.

**policy_ref —** Policy aplicada. Tipo físico varchar(200); nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: policy://stacking/v3.

**policy_hash —** Hash de policy. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: sha256:….

**decision_ref —** Claim/override/decision que justificó. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave internal/EXT. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**effective_from —** Inicio de efecto. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**effective_until —** Fin de efecto. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: NULL.

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

### 

| **Nombre físico**        | **Tipo** | **Definición/expresión**                                   | **Error que impide** |
|--------------------------|----------|------------------------------------------------------------|----------------------|
| fk_ec10_contrib_fact     | FK       | (tenant_id,fact_id) → trajectory_fact                      | Fact otro tenant     |
| fk_ec10_contrib_progress | FK       | (tenant_id,progress_id) → pathway_progress                 | Progress otro tenant |
| ck_ec10_contrib_weight   | CHECK    | contribution_weight\>=0                                    | Peso negativo        |
| ck_ec10_contrib_window   | CHECK    | effective_until IS NULL OR effective_until\>effective_from | Ventana imposible    |
| ix_ec10_contrib_node     | INDEX    | (tenant_id,progress_id,node_ref,effective_from)            | Recalc ineficiente   |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Contribuciones cross-progress, pesos inválidos o sin policy. |
|------------------------------------------------------------------------------------------------------------------------------|

## 

Proyección materializada del estado de cada nodo de una PathwayVersion para un PathwayProgress. Es reconstruible.

Participación arquitectónica — Aggregate/área gobernante: PathwayProgress. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Duplicados de nodo, pesos imposibles, estados sin explicación. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                                | **Ejemplo**   |
|-------------------------|---------------------|----------|-------------------|-------------|------------------------------------------------|---------------|
| tenant_id               | uuid                | NO       | \-                | PK/FK scope | Tenant propietario; proviene de TenantContext. | b4b0…         |
| id                      | uuid                | NO       | gen_random_uuid() | PK          | Identidad opaca local.                         | 5f2a…         |
| progress_id             | uuid                | NO       | \-                | FK internal | Parent progress.                               | …             |
| node_ref                | uuid                | NO       | \-                | EXT REF     | Nodo EC-01.                                    | …             |
| state                   | varchar(24)         | NO       | 'NOT_STARTED'     | CHECK       | Estado proyectado.                             | SATISFIED     |
| satisfied_weight        | numeric(12,4)       | NO       | 0                 | CHECK       | Peso acumulado válido.                         | 1.0000        |
| required_weight         | numeric(12,4)       | NO       | 1                 | CHECK       | Umbral requerido.                              | 1.0000        |
| reason_code             | varchar(80)         | YES      | NULL              | catalog     | Explicación machine-readable.                  | FACTS_SATISFY |
| blocking_node_ref       | uuid                | YES      | NULL              | EXT REF     | Nodo que bloquea, si aplica.                   | …             |
| satisfaction_basis_hash | varchar(128)        | YES      | NULL              | integrity   | Hash de facts/policy usados.                   | sha256:…      |
| evaluated_at            | timestamptz         | NO       | now()             | time        | Evaluación UTC.                                | …             |
| as_of                   | timestamptz         | NO       | now()             | time        | Frontera temporal de la proyección.            | …             |
| dependency_state        | varchar(24)         | NO       | 'AVAILABLE'       | CHECK       | Frescura/availability.                         | AVAILABLE     |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 5f2a….

**progress_id —** Parent progress. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**node_ref —** Nodo EC-01. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**state —** Estado proyectado. Tipo físico varchar(24); nulabilidad NO; default 'NOT_STARTED'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: SATISFIED.

**satisfied_weight —** Peso acumulado válido. Tipo físico numeric(12,4); nulabilidad NO; default 0; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 1.0000.

**required_weight —** Umbral requerido. Tipo físico numeric(12,4); nulabilidad NO; default 1; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 1.0000.

**reason_code —** Explicación machine-readable. Tipo físico varchar(80); nulabilidad YES; default NULL; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: FACTS_SATISFY.

**blocking_node_ref —** Nodo que bloquea, si aplica. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**satisfaction_basis_hash —** Hash de facts/policy usados. Tipo físico varchar(128); nulabilidad YES; default NULL; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: sha256:….

**evaluated_at —** Evaluación UTC. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**as_of —** Frontera temporal de la proyección. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**dependency_state —** Frescura/availability. Tipo físico varchar(24); nulabilidad NO; default 'AVAILABLE'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: AVAILABLE.

### 

| **Nombre físico**            | **Tipo** | **Definición/expresión**                    | **Error que impide**          |
|------------------------------|----------|---------------------------------------------|-------------------------------|
| uq_ec10_node_progress        | UNIQUE   | (tenant_id,progress_id,node_ref)            | Dos estados actuales por nodo |
| fk_ec10_node_progress_parent | FK       | (tenant_id,progress_id) → pathway_progress  | Cross-tenant parent           |
| ck_ec10_node_weights         | CHECK    | required_weight\>0 AND satisfied_weight\>=0 | Pesos inválidos               |
| ck_ec10_node_state           | CHECK    | state allowlist                             | Estado inválido               |
| ix_ec10_node_state           | INDEX    | (tenant_id,progress_id,state)               | Consulta de faltantes lenta   |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Duplicados de nodo, pesos imposibles, estados sin explicación. |
|--------------------------------------------------------------------------------------------------------------------------------|

## 

Snapshot inmutable de una evaluación completa de progreso. Permite reproducibilidad, comparación e historia as-of.

Participación arquitectónica — Aggregate/área gobernante: PathwayProgress. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Reescritura histórica, porcentajes inválidos y snapshot sin hashes. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                                | **Ejemplo**             |
|--------------------------|---------------------|----------|-------------------|-------------|------------------------------------------------|-------------------------|
| tenant_id                | uuid                | NO       | \-                | PK/FK scope | Tenant propietario; proviene de TenantContext. | b4b0…                   |
| id                       | uuid                | NO       | gen_random_uuid() | PK          | Identidad opaca local.                         | 5f2a…                   |
| progress_id              | uuid                | NO       | \-                | FK internal | Parent progress.                               | …                       |
| snapshot_no              | bigint              | NO       | \-                | UQ seq      | Secuencia monotónica.                          | 42                      |
| engine_version           | varchar(60)         | NO       | \-                | version     | Motor de evaluación.                           | ec10-engine-1.0.0       |
| canonical_schema_version | integer             | NO       | 1                 | version     | Canonicalización previa a hash.                | 1                       |
| pathway_content_hash     | varchar(128)        | NO       | \-                | integrity   | Hash de ruta pinneada.                         | sha256:…                |
| input_watermark          | varchar(200)        | NO       | \-                | watermark   | Frontera de inputs/eventos.                    | kafka:ec-progress:99281 |
| policy_set_hash          | varchar(128)        | NO       | \-                | integrity   | Hash combinado de policies.                    | sha256:…                |
| progress_percent         | numeric(7,4)        | YES      | NULL              | CHECK       | Porcentaje si calculable.                      | 75.0000                 |
| satisfied_nodes          | integer             | NO       | 0                 | CHECK       | Nodos satisfechos.                             | 6                       |
| required_nodes           | integer             | NO       | 0                 | CHECK       | Nodos requeridos.                              | 8                       |
| blocking_count           | integer             | NO       | 0                 | CHECK       | Bloqueos vigentes.                             | 1                       |
| dependency_state         | varchar(24)         | NO       | 'AVAILABLE'       | CHECK       | Calidad/frescura.                              | AVAILABLE               |
| result_hash              | varchar(128)        | NO       | \-                | integrity   | Hash canonical del resultado.                  | sha256:…                |
| snapshot_payload         | jsonb               | NO       | '{}'::jsonb       | payload     | Resumen/proyección para evidencia.             | {"nodes":8}             |
| supersedes_snapshot_id   | uuid                | YES      | NULL              | FK internal | Snapshot anterior lógico.                      | …                       |
| created_at               | timestamptz         | NO       | now()             | audit       | Creación.                                      | …                       |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 5f2a….

**progress_id —** Parent progress. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**snapshot_no —** Secuencia monotónica. Tipo físico bigint; nulabilidad NO; default -; rol de clave UQ seq. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 42.

**engine_version —** Motor de evaluación. Tipo físico varchar(60); nulabilidad NO; default -; rol de clave version. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ec10-engine-1.0.0.

**canonical_schema_version —** Canonicalización previa a hash. Tipo físico integer; nulabilidad NO; default 1; rol de clave version. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 1.

**pathway_content_hash —** Hash de ruta pinneada. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: sha256:….

**input_watermark —** Frontera de inputs/eventos. Tipo físico varchar(200); nulabilidad NO; default -; rol de clave watermark. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: kafka:ec-progress:99281.

**policy_set_hash —** Hash combinado de policies. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: sha256:….

**progress_percent —** Porcentaje si calculable. Tipo físico numeric(7,4); nulabilidad YES; default NULL; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 75.0000.

**satisfied_nodes —** Nodos satisfechos. Tipo físico integer; nulabilidad NO; default 0; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 6.

**required_nodes —** Nodos requeridos. Tipo físico integer; nulabilidad NO; default 0; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 8.

**blocking_count —** Bloqueos vigentes. Tipo físico integer; nulabilidad NO; default 0; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 1.

**dependency_state —** Calidad/frescura. Tipo físico varchar(24); nulabilidad NO; default 'AVAILABLE'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: AVAILABLE.

**result_hash —** Hash canonical del resultado. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: sha256:….

**snapshot_payload —** Resumen/proyección para evidencia. Tipo físico jsonb; nulabilidad NO; default '{}'::jsonb; rol de clave payload. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: {"nodes":8}.

**supersedes_snapshot_id —** Snapshot anterior lógico. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

### 

| **Nombre físico**             | **Tipo** | **Definición/expresión**                                                        | **Error que impide** |
|-------------------------------|----------|---------------------------------------------------------------------------------|----------------------|
| uq_ec10_snapshot_seq          | UNIQUE   | (tenant_id,progress_id,snapshot_no)                                             | Secuencia duplicada  |
| ck_ec10_snapshot_percent      | CHECK    | progress_percent IS NULL OR (progress_percent\>=0 AND progress_percent\<=100)   | Porcentaje inválido  |
| ck_ec10_snapshot_counts       | CHECK    | satisfied_nodes\>=0 AND required_nodes\>=0 AND satisfied_nodes\<=required_nodes | Conteos imposibles   |
| trg_ec10_snapshot_append_only | TRIGGER  | forbid UPDATE/DELETE                                                            | Alterar evidencia    |
| ix_ec10_snapshot_asof         | INDEX    | (tenant_id,progress_id,created_at DESC)                                         | Historia as-of lenta |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Reescritura histórica, porcentajes inválidos y snapshot sin hashes. |
|-------------------------------------------------------------------------------------------------------------------------------------|

## 

Aggregate root para solicitar reconocimiento de aprendizaje/evidencia que no llega como fact confiable nativo.

Participación arquitectónica — Aggregate/área gobernante: RecognitionClaim. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Decisiones sin evidencia/policy, cambios terminales destructivos y target ambiguo. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                | **Ejemplo**             |
|----------------------------|---------------------|----------|-------------------|---------------|------------------------------------------------|-------------------------|
| tenant_id                  | uuid                | NO       | \-                | PK/FK scope   | Tenant propietario; proviene de TenantContext. | b4b0…                   |
| id                         | uuid                | NO       | gen_random_uuid() | PK            | Identidad opaca local.                         | 5f2a…                   |
| trajectory_id              | uuid                | NO       | \-                | FK internal   | Trayectoria propietaria.                       | …                       |
| claim_type                 | varchar(40)         | NO       | \-                | CHECK/catalog | Tipo de reconocimiento.                        | EXTERNAL_CREDENTIAL     |
| target_pathway_version_ref | uuid                | NO       | \-                | EXT REF       | Ruta objetivo pinneada.                        | …                       |
| target_node_ref            | uuid                | YES      | NULL              | EXT REF       | Nodo objetivo si aplica.                       | …                       |
| state                      | varchar(24)         | NO       | 'DRAFT'           | CHECK         | Lifecycle del claim.                           | IN_REVIEW               |
| submitted_at               | timestamptz         | YES      | NULL              | time          | Envío formal.                                  | …                       |
| workflow_ref               | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow de revisión.                          | …                       |
| decision                   | varchar(24)         | YES      | NULL              | CHECK         | ACCEPTED/PARTIAL/REJECTED.                     | PARTIAL                 |
| decision_reason_code       | varchar(80)         | YES      | NULL              | catalog       | Razón verificable.                             | PARTIAL_EQUIVALENCE     |
| policy_ref                 | varchar(200)        | YES      | NULL              | EXT REF       | Policy usada.                                  | policy://recognition/v2 |
| policy_hash                | varchar(128)        | YES      | NULL              | integrity     | Hash policy.                                   | sha256:…                |
| recognized_fact_id         | uuid                | YES      | NULL              | FK internal   | Fact creado al aceptar.                        | …                       |
| revision                   | bigint              | NO       | 0                 | ETag          | Concurrencia optimista.                        | 5                       |
| created_at                 | timestamptz         | NO       | now()             | audit         | Creación.                                      | …                       |
| updated_at                 | timestamptz         | NO       | now()             | audit         | Actualización.                                 | …                       |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: 5f2a….

**trajectory_id —** Trayectoria propietaria. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**claim_type —** Tipo de reconocimiento. Tipo físico varchar(40); nulabilidad NO; default -; rol de clave CHECK/catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: EXTERNAL_CREDENTIAL.

**target_pathway_version_ref —** Ruta objetivo pinneada. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**target_node_ref —** Nodo objetivo si aplica. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**state —** Lifecycle del claim. Tipo físico varchar(24); nulabilidad NO; default 'DRAFT'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: IN_REVIEW.

**submitted_at —** Envío formal. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**workflow_ref —** Workflow de revisión. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF CT-06. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**decision —** ACCEPTED/PARTIAL/REJECTED. Tipo físico varchar(24); nulabilidad YES; default NULL; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: PARTIAL.

**decision_reason_code —** Razón verificable. Tipo físico varchar(80); nulabilidad YES; default NULL; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: PARTIAL_EQUIVALENCE.

**policy_ref —** Policy usada. Tipo físico varchar(200); nulabilidad YES; default NULL; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: policy://recognition/v2.

**policy_hash —** Hash policy. Tipo físico varchar(128); nulabilidad YES; default NULL; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: sha256:….

**recognized_fact_id —** Fact creado al aceptar. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**revision —** Contador de concurrencia optimista. Toda mutación semántica del aggregate lo incrementa y se materializa como ETag; no es timestamp. Tipo físico bigint; nulabilidad NO; default 0; rol de clave ETag. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: 5.

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**updated_at —** Actualización. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

### 

| **Nombre físico**          | **Tipo**       | **Definición/expresión**                        | **Error que impide**       |
|----------------------------|----------------|-------------------------------------------------|----------------------------|
| fk_ec10_claim_trajectory   | FK             | (tenant_id,trajectory_id) → learning_trajectory | Claim cross-tenant         |
| ck_ec10_claim_state        | CHECK          | state allowlist                                 | Estado inválido            |
| ck_ec10_claim_terminal     | CHECK          | terminal decision exige reason/policy           | Decisión opaca             |
| uq_ec10_claim_open_target  | PARTIAL UNIQUE | target open semantic key                        | Claims abiertos duplicados |
| rls_ec10_recognition_claim | RLS            | tenant policy                                   | Cross-tenant               |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Decisiones sin evidencia/policy, cambios terminales destructivos y target ambiguo. |
|----------------------------------------------------------------------------------------------------------------------------------------------------|

## 

Binding entre RecognitionClaim y una evidencia gobernada por CT-05, con estado de verificación y hash.

Participación arquitectónica — Aggregate/área gobernante: RecognitionClaim. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Evidencia cross-claim, sustitución silenciosa o verificación sin actor. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                | **Ejemplo** |
|--------------------|---------------------|----------|-------------------|---------------|------------------------------------------------|-------------|
| tenant_id          | uuid                | NO       | \-                | PK/FK scope   | Tenant propietario; proviene de TenantContext. | b4b0…       |
| id                 | uuid                | NO       | gen_random_uuid() | PK            | Identidad opaca local.                         | 5f2a…       |
| claim_id           | uuid                | NO       | \-                | FK internal   | Claim padre.                                   | …           |
| evidence_ref       | uuid                | NO       | \-                | EXT REF CT-05 | Documento/evidencia externa.                   | …           |
| evidence_type_code | varchar(60)         | NO       | \-                | catalog       | Tipo documental.                               | CERTIFICATE |
| evidence_hash      | varchar(128)        | NO       | \-                | integrity     | Hash del artefacto/version verificada.         | sha256:…    |
| verification_state | varchar(24)         | NO       | 'PENDING'         | CHECK         | PENDING/VERIFIED/REJECTED/STALE.               | VERIFIED    |
| verified_at        | timestamptz         | YES      | NULL              | time          | Momento de verificación.                       | …           |
| verified_by_ref    | uuid                | YES      | NULL              | actor         | Verificador.                                   | …           |
| created_at         | timestamptz         | NO       | now()             | audit         | Creación.                                      | …           |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: 5f2a….

**claim_id —** Claim padre. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**evidence_ref —** Documento/evidencia externa. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF CT-05. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**evidence_type_code —** Tipo documental. Tipo físico varchar(60); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: CERTIFICATE.

**evidence_hash —** Hash del artefacto/version verificada. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: sha256:….

**verification_state —** PENDING/VERIFIED/REJECTED/STALE. Tipo físico varchar(24); nulabilidad NO; default 'PENDING'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: VERIFIED.

**verified_at —** Momento de verificación. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**verified_by_ref —** Verificador. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave actor. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en RecognitionClaim. Ejemplo: ….

### 

| **Nombre físico**            | **Tipo** | **Definición/expresión**                        | **Error que impide**                |
|------------------------------|----------|-------------------------------------------------|-------------------------------------|
| fk_ec10_claim_evidence_claim | FK       | (tenant_id,claim_id) → recognition_claim        | Evidence en claim ajeno             |
| uq_ec10_claim_evidence       | UNIQUE   | (tenant_id,claim_id,evidence_ref,evidence_hash) | Duplicado                           |
| ck_ec10_evidence_verify      | CHECK    | VERIFIED implica verified_at/by                 | Verificación sin evidencia de actor |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Evidencia cross-claim, sustitución silenciosa o verificación sin actor. |
|-----------------------------------------------------------------------------------------------------------------------------------------|

## 

Decisión excepcional aprobada para alterar una proyección sin mutar facts ni snapshots previos.

Participación arquitectónica — Aggregate/área gobernante: PathwayProgress. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Override libre, sin evidencia/actor, o reversión destructiva. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                | **Ejemplo**        |
|------------------------|---------------------|----------|-------------------|---------------|------------------------------------------------|--------------------|
| tenant_id              | uuid                | NO       | \-                | PK/FK scope   | Tenant propietario; proviene de TenantContext. | b4b0…              |
| id                     | uuid                | NO       | gen_random_uuid() | PK            | Identidad opaca local.                         | 5f2a…              |
| progress_id            | uuid                | NO       | \-                | FK internal   | Progress afectado.                             | …                  |
| node_ref               | uuid                | YES      | NULL              | EXT REF       | Nodo afectado si aplica.                       | …                  |
| override_kind          | varchar(40)         | NO       | \-                | CHECK/catalog | WAIVE/ADJUST/EXPIRE_EXCEPTION/etc.             | WAIVE              |
| reason_code            | varchar(80)         | NO       | \-                | catalog       | Razón gobernada.                               | ACADEMIC_EXCEPTION |
| evidence_ref           | uuid                | YES      | NULL              | EXT REF CT-05 | Evidencia justificativa.                       | …                  |
| workflow_ref           | uuid                | YES      | NULL              | EXT REF CT-06 | Aprobación externa.                            | …                  |
| approved_by_ref        | uuid                | NO       | \-                | actor         | Actor aprobador.                               | …                  |
| approved_at            | timestamptz         | NO       | \-                | time          | Aprobación UTC.                                | …                  |
| supersedes_override_id | uuid                | YES      | NULL              | FK internal   | Reversión/supersede.                           | …                  |
| receipt_hash           | varchar(128)        | NO       | \-                | integrity     | Hash canonical de decisión.                    | sha256:…           |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: 5f2a….

**progress_id —** Progress afectado. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**node_ref —** Nodo afectado si aplica. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**override_kind —** WAIVE/ADJUST/EXPIRE_EXCEPTION/etc. Tipo físico varchar(40); nulabilidad NO; default -; rol de clave CHECK/catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: WAIVE.

**reason_code —** Razón gobernada. Tipo físico varchar(80); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ACADEMIC_EXCEPTION.

**evidence_ref —** Evidencia justificativa. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF CT-05. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**workflow_ref —** Aprobación externa. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF CT-06. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**approved_by_ref —** Actor aprobador. Tipo físico uuid; nulabilidad NO; default -; rol de clave actor. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**approved_at —** Aprobación UTC. Tipo físico timestamptz; nulabilidad NO; default -; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**supersedes_override_id —** Reversión/supersede. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: ….

**receipt_hash —** Hash canonical de decisión. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayProgress. Ejemplo: sha256:….

### 

| **Nombre físico**         | **Tipo** | **Definición/expresión**                                       | **Error que impide**  |
|---------------------------|----------|----------------------------------------------------------------|-----------------------|
| fk_ec10_override_progress | FK       | (tenant_id,progress_id) → pathway_progress                     | Override cross-tenant |
| ck_ec10_override_reason   | CHECK    | length(reason_code)\>0                                         | Override sin razón    |
| ck_ec10_override_self     | CHECK    | supersedes_override_id IS NULL OR supersedes_override_id\<\>id | Self supersede        |
| ix_ec10_override_node     | INDEX    | (tenant_id,progress_id,node_ref,approved_at DESC)              | Evaluación lenta      |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Override libre, sin evidencia/actor, o reversión destructiva. |
|-------------------------------------------------------------------------------------------------------------------------------|

## 

Aggregate root que gobierna migración entre versiones de ruta mediante diff, simulation y aprobación.

Participación arquitectónica — Aggregate/área gobernante: PathwayMigrationCase. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Migración in-place, target cambiante, doble apply o source/target iguales. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                | **Ejemplo** |
|-----------------------------|---------------------|----------|-------------------|---------------|------------------------------------------------|-------------|
| tenant_id                   | uuid                | NO       | \-                | PK/FK scope   | Tenant propietario; proviene de TenantContext. | b4b0…       |
| id                          | uuid                | NO       | gen_random_uuid() | PK            | Identidad opaca local.                         | 5f2a…       |
| source_progress_id          | uuid                | NO       | \-                | FK internal   | Progress origen.                               | …           |
| target_pathway_version_ref  | uuid                | NO       | \-                | EXT REF       | Ruta destino exacta.                           | …           |
| target_pathway_content_hash | varchar(128)        | NO       | \-                | integrity     | Hash destino pinneado.                         | sha256:…    |
| state                       | varchar(24)         | NO       | 'DRAFT'           | CHECK         | Lifecycle migración.                           | SIMULATED   |
| diff_hash                   | varchar(128)        | YES      | NULL              | integrity     | Hash del diff source/target.                   | sha256:…    |
| simulation_hash             | varchar(128)        | YES      | NULL              | integrity     | Hash de simulación.                            | sha256:…    |
| workflow_ref                | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow aprobación.                           | …           |
| target_progress_id          | uuid                | YES      | NULL              | FK internal   | Progress creado al aplicar.                    | …           |
| revision                    | bigint              | NO       | 0                 | ETag          | Concurrencia.                                  | 4           |
| created_at                  | timestamptz         | NO       | now()             | audit         | Creación.                                      | …           |
| updated_at                  | timestamptz         | NO       | now()             | audit         | Actualización.                                 | …           |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: 5f2a….

**source_progress_id —** Progress origen. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**target_pathway_version_ref —** Ruta destino exacta. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**target_pathway_content_hash —** Hash destino pinneado. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: sha256:….

**state —** Lifecycle migración. Tipo físico varchar(24); nulabilidad NO; default 'DRAFT'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: SIMULATED.

**diff_hash —** Hash del diff source/target. Tipo físico varchar(128); nulabilidad YES; default NULL; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: sha256:….

**simulation_hash —** Hash de simulación. Tipo físico varchar(128); nulabilidad YES; default NULL; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: sha256:….

**workflow_ref —** Workflow aprobación. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF CT-06. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**target_progress_id —** Progress creado al aplicar. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**revision —** Contador de concurrencia optimista. Toda mutación semántica del aggregate lo incrementa y se materializa como ETag; no es timestamp. Tipo físico bigint; nulabilidad NO; default 0; rol de clave ETag. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: 4.

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**updated_at —** Actualización. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

### 

| **Nombre físico**             | **Tipo**       | **Definición/expresión**                                                              | **Error que impide**       |
|-------------------------------|----------------|---------------------------------------------------------------------------------------|----------------------------|
| fk_ec10_migration_source      | FK             | (tenant_id,source_progress_id) → pathway_progress                                     | Source cross-tenant        |
| uq_ec10_migration_open        | PARTIAL UNIQUE | (tenant_id,source_progress_id,target_pathway_version_ref) WHERE state NOT IN terminal | Doble caso abierto         |
| ck_ec10_migration_state       | CHECK          | state allowlist                                                                       | Estado inválido            |
| trg_ec10_migration_target_pin | TRIGGER        | target ref/hash immutable after SIMULATED                                             | Cambiar target tras review |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Migración in-place, target cambiante, doble apply o source/target iguales. |
|--------------------------------------------------------------------------------------------------------------------------------------------|

## 

Mapeo explícito entre nodos source/target para una migración.

Participación arquitectónica — Aggregate/área gobernante: PathwayMigrationCase. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Mappings ambiguos, duplicados o sin tipo/policy. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                                | **Ejemplo**           |
|----------------------|---------------------|----------|-------------------|-------------|------------------------------------------------|-----------------------|
| tenant_id            | uuid                | NO       | \-                | PK/FK scope | Tenant propietario; proviene de TenantContext. | b4b0…                 |
| id                   | uuid                | NO       | gen_random_uuid() | PK          | Identidad opaca local.                         | 5f2a…                 |
| migration_case_id    | uuid                | NO       | \-                | FK internal | Caso padre.                                    | …                     |
| source_node_ref      | uuid                | YES      | NULL              | EXT REF     | Nodo origen; NULL para NEW_REQUIRED.           | …                     |
| target_node_ref      | uuid                | YES      | NULL              | EXT REF     | Nodo destino; NULL para DROPPED.               | …                     |
| mapping_kind         | varchar(32)         | NO       | \-                | CHECK       | EXACT/EQUIVALENT/PARTIAL/DROPPED/NEW_REQUIRED. | EQUIVALENT            |
| confidence           | numeric(5,4)        | YES      | NULL              | CHECK       | Confianza de sugerencia, no decisión.          | 0.9200                |
| policy_ref           | varchar(200)        | NO       | \-                | EXT REF     | Policy mapping.                                | policy://migration/v1 |
| decision_reason_code | varchar(80)         | NO       | \-                | catalog     | Justificación.                                 | OUTCOME_EQUIVALENT    |
| created_at           | timestamptz         | NO       | now()             | audit       | Creación.                                      | …                     |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: 5f2a….

**migration_case_id —** Caso padre. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**source_node_ref —** Nodo origen; NULL para NEW_REQUIRED. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**target_node_ref —** Nodo destino; NULL para DROPPED. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**mapping_kind —** EXACT/EQUIVALENT/PARTIAL/DROPPED/NEW_REQUIRED. Tipo físico varchar(32); nulabilidad NO; default -; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: EQUIVALENT.

**confidence —** Confianza de sugerencia, no decisión. Tipo físico numeric(5,4); nulabilidad YES; default NULL; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: 0.9200.

**policy_ref —** Policy mapping. Tipo físico varchar(200); nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: policy://migration/v1.

**decision_reason_code —** Justificación. Tipo físico varchar(80); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: OUTCOME_EQUIVALENT.

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

### 

| **Nombre físico**          | **Tipo**       | **Definición/expresión**                                  | **Error que impide**      |
|----------------------------|----------------|-----------------------------------------------------------|---------------------------|
| fk_ec10_mapping_case       | FK             | (tenant_id,migration_case_id) → pathway_migration_case    | Mapping cross-case        |
| ck_ec10_mapping_shape      | CHECK          | shape compatible con mapping_kind                         | Mapping imposible         |
| ck_ec10_mapping_confidence | CHECK          | confidence IS NULL OR confidence BETWEEN 0 AND 1          | Confianza inválida        |
| uq_ec10_mapping_target     | PARTIAL UNIQUE | case+target where target not null and policy requires one | Doble mapping conflictivo |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Mappings ambiguos, duplicados o sin tipo/policy. |
|------------------------------------------------------------------------------------------------------------------|

## 

Evidencia append-only que enlaza una contribución source con su contribución target durante migración.

Participación arquitectónica — Aggregate/área gobernante: PathwayMigrationCase. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Carry-forward sin lineage, duplicado o mutable. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                                | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|-------------|------------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | \-                | PK/FK scope | Tenant propietario; proviene de TenantContext. | b4b0…       |
| id                       | uuid                | NO       | gen_random_uuid() | PK          | Identidad opaca local.                         | 5f2a…       |
| migration_case_id        | uuid                | NO       | \-                | FK internal | Caso de migración.                             | …           |
| source_contribution_id   | uuid                | NO       | \-                | FK internal | Contribución origen.                           | …           |
| target_contribution_id   | uuid                | NO       | \-                | FK internal | Contribución destino.                          | …           |
| mapping_id               | uuid                | NO       | \-                | FK internal | Mapping justificativo.                         | …           |
| receipt_schema_version   | integer             | NO       | 1                 | version     | Versión semántica receipt.                     | 1           |
| canonical_schema_version | integer             | NO       | 1                 | version     | Versión canonicalización.                      | 1           |
| receipt_hash             | varchar(128)        | NO       | \-                | integrity   | Hash canonical receipt.                        | sha256:…    |
| created_at               | timestamptz         | NO       | now()             | audit       | Creación.                                      | …           |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: 5f2a….

**migration_case_id —** Caso de migración. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**source_contribution_id —** Contribución origen. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**target_contribution_id —** Contribución destino. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**mapping_id —** Mapping justificativo. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

**receipt_schema_version —** Versión semántica receipt. Tipo físico integer; nulabilidad NO; default 1; rol de clave version. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: 1.

**canonical_schema_version —** Versión canonicalización. Tipo físico integer; nulabilidad NO; default 1; rol de clave version. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: 1.

**receipt_hash —** Hash canonical receipt. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: sha256:….

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en PathwayMigrationCase. Ejemplo: ….

### 

| **Nombre físico**           | **Tipo** | **Definición/expresión**                                                    | **Error que impide** |
|-----------------------------|----------|-----------------------------------------------------------------------------|----------------------|
| uq_ec10_carry_source_target | UNIQUE   | (tenant_id,migration_case_id,source_contribution_id,target_contribution_id) | Duplicado            |
| trg_ec10_carry_append_only  | TRIGGER  | forbid UPDATE/DELETE                                                        | Alterar lineage      |
| fk_ec10_carry_mapping       | FK       | (tenant_id,mapping_id) → migration_mapping                                  | Mapping ajeno        |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Carry-forward sin lineage, duplicado o mutable. |
|-----------------------------------------------------------------------------------------------------------------|

## 

Decisión inmutable/supersedible de si un snapshot cumple un CredentialBlueprint acumulativo.

Participación arquitectónica — Aggregate/área gobernante: CumulativeEligibilityDecision. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Elegibilidad sin snapshot/policy, doble decisión vigente o confundir con award. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**                       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                          | **Ejemplo**            |
|---------------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------|------------------------|
| tenant_id                       | uuid                | NO       | \-                | PK/FK scope   | Tenant propietario; proviene de TenantContext.           | b4b0…                  |
| id                              | uuid                | NO       | gen_random_uuid() | PK            | Identidad opaca local.                                   | 5f2a…                  |
| progress_id                     | uuid                | NO       | \-                | FK internal   | Progress evaluado.                                       | …                      |
| snapshot_id                     | uuid                | NO       | \-                | FK internal   | Snapshot exacto.                                         | …                      |
| target_credential_blueprint_ref | uuid                | NO       | \-                | EXT REF       | Blueprint EC-01/EC-08.                                   | …                      |
| decision                        | varchar(24)         | NO       | \-                | CHECK         | ELIGIBLE/NOT_ELIGIBLE/PENDING/REVOKED/SUPERSEDED.        | ELIGIBLE               |
| reason_code                     | varchar(80)         | NO       | \-                | catalog       | Explicación.                                             | ALL_REQUIRED_NODES_MET |
| policy_ref                      | varchar(200)        | NO       | \-                | EXT REF       | Policy elegibilidad.                                     | policy://credential/v4 |
| policy_hash                     | varchar(128)        | NO       | \-                | integrity     | Hash de policy.                                          | sha256:…               |
| decision_hash                   | varchar(128)        | NO       | \-                | integrity     | Hash de inputs/output.                                   | sha256:…               |
| issued_award_ref                | uuid                | YES      | NULL              | EXT REF EC-08 | Award confirmado, si existe.                             | …                      |
| issuance_state                  | varchar(24)         | NO       | 'NOT_REQUESTED'   | CHECK         | NOT_REQUESTED/REQUESTED/CONFIRMED/UNKNOWN_EFFECT/FAILED. | CONFIRMED              |
| created_at                      | timestamptz         | NO       | now()             | audit         | Creación.                                                | …                      |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: 5f2a….

**progress_id —** Progress evaluado. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: ….

**snapshot_id —** Snapshot exacto. Tipo físico uuid; nulabilidad NO; default -; rol de clave FK internal. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: ….

**target_credential_blueprint_ref —** Blueprint EC-01/EC-08. Tipo físico uuid; nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: ….

**decision —** ELIGIBLE/NOT_ELIGIBLE/PENDING/REVOKED/SUPERSEDED. Tipo físico varchar(24); nulabilidad NO; default -; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: ELIGIBLE.

**reason_code —** Explicación. Tipo físico varchar(80); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: ALL_REQUIRED_NODES_MET.

**policy_ref —** Policy elegibilidad. Tipo físico varchar(200); nulabilidad NO; default -; rol de clave EXT REF. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: policy://credential/v4.

**policy_hash —** Hash de policy. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: sha256:….

**decision_hash —** Hash de inputs/output. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: sha256:….

**issued_award_ref —** Award confirmado, si existe. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave EXT REF EC-08. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: ….

**issuance_state —** NOT_REQUESTED/REQUESTED/CONFIRMED/UNKNOWN_EFFECT/FAILED. Tipo físico varchar(24); nulabilidad NO; default 'NOT_REQUESTED'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: CONFIRMED.

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en CumulativeEligibilityDecision. Ejemplo: ….

### 

| **Nombre físico**      | **Tipo** | **Definición/expresión**                                                | **Error que impide**  |
|------------------------|----------|-------------------------------------------------------------------------|-----------------------|
| fk_ec10_elig_progress  | FK       | (tenant_id,progress_id) → pathway_progress                              | Cross-tenant          |
| fk_ec10_elig_snapshot  | FK       | (tenant_id,snapshot_id) → progress_snapshot                             | Snapshot cross-tenant |
| ck_ec10_elig_decision  | CHECK    | decision allowlist                                                      | Decision inválida     |
| ck_ec10_issuance_award | CHECK    | CONFIRMED implica issued_award_ref                                      | Confirmación fantasma |
| ix_ec10_elig_blueprint | INDEX    | (tenant_id,progress_id,target_credential_blueprint_ref,created_at DESC) | Consulta lenta        |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Elegibilidad sin snapshot/policy, doble decisión vigente o confundir con award. |
|-------------------------------------------------------------------------------------------------------------------------------------------------|

## 

Receipt append-only para decisiones críticas: claim, override, eligibility, migration y reconciliation.

Participación arquitectónica — Aggregate/área gobernante: Múltiples aggregates. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Alteración de evidencia, receipt sin sujeto/actor/hash. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                | **Ejemplo**      |
|--------------------------|---------------------|----------|-------------------|------------------|------------------------------------------------|------------------|
| tenant_id                | uuid                | NO       | \-                | PK/FK scope      | Tenant propietario; proviene de TenantContext. | b4b0…            |
| id                       | uuid                | NO       | gen_random_uuid() | PK               | Identidad opaca local.                         | 5f2a…            |
| receipt_type             | varchar(60)         | NO       | \-                | catalog          | Tipo de receipt.                               | CLAIM_ACCEPTED   |
| subject_type             | varchar(60)         | NO       | \-                | catalog          | Tipo de aggregate/sujeto.                      | RecognitionClaim |
| subject_id               | uuid                | NO       | \-                | internal logical | ID sujeto.                                     | …                |
| actor_ref                | uuid                | NO       | \-                | actor            | Actor humano/técnico.                          | …                |
| reason_code              | varchar(80)         | NO       | \-                | catalog          | Razón.                                         | POLICY_APPROVED  |
| content_hash             | varchar(128)        | NO       | \-                | integrity        | Hash canonical del contenido.                  | sha256:…         |
| canonical_schema_version | integer             | NO       | 1                 | version          | Canonicalización.                              | 1                |
| receipt_schema_version   | integer             | NO       | 1                 | version          | Schema receipt.                                | 1                |
| occurred_at              | timestamptz         | NO       | now()             | time             | Momento UTC.                                   | …                |
| payload                  | jsonb               | NO       | '{}'::jsonb       | payload          | Metadata mínima/evidence refs.                 | {"policy":"v2"}  |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: 5f2a….

**receipt_type —** Tipo de receipt. Tipo físico varchar(60); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: CLAIM_ACCEPTED.

**subject_type —** Tipo de aggregate/sujeto. Tipo físico varchar(60); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: RecognitionClaim.

**subject_id —** ID sujeto. Tipo físico uuid; nulabilidad NO; default -; rol de clave internal logical. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: ….

**actor_ref —** Actor humano/técnico. Tipo físico uuid; nulabilidad NO; default -; rol de clave actor. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: ….

**reason_code —** Razón. Tipo físico varchar(80); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: POLICY_APPROVED.

**content_hash —** Hash canonical del contenido. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: sha256:….

**canonical_schema_version —** Canonicalización. Tipo físico integer; nulabilidad NO; default 1; rol de clave version. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: 1.

**receipt_schema_version —** Schema receipt. Tipo físico integer; nulabilidad NO; default 1; rol de clave version. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: 1.

**occurred_at —** Momento UTC. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: ….

**payload —** Metadata mínima/evidence refs. Tipo físico jsonb; nulabilidad NO; default '{}'::jsonb; rol de clave payload. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Múltiples aggregates. Ejemplo: {"policy":"v2"}.

### 

| **Nombre físico**            | **Tipo** | **Definición/expresión**                        | **Error que impide** |
|------------------------------|----------|-------------------------------------------------|----------------------|
| trg_ec10_receipt_append_only | TRIGGER  | forbid UPDATE/DELETE                            | Alterar evidencia    |
| ix_ec10_receipt_subject      | INDEX    | (tenant_id,subject_type,subject_id,occurred_at) | Evidence pack lento  |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Alteración de evidencia, receipt sin sujeto/actor/hash. |
|-------------------------------------------------------------------------------------------------------------------------|

## 

Registro durable de Idempotency-Key para commands sensibles y recovery multi-instancia.

Participación arquitectónica — Aggregate/área gobernante: Infra EC-10. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Replay con payload distinto, IN_PROGRESS huérfano o doble owner. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default**   | **PK/FK**   | **Descripción**               | **Ejemplo**     |
|-------------------|---------------------|----------|---------------|-------------|-------------------------------|-----------------|
| tenant_id         | uuid                | NO       | \-            | PK scope    | Tenant.                       | …               |
| idempotency_key   | varchar(160)        | NO       | \-            | PK          | Clave cliente/lógica.         | 01J…            |
| command_scope     | varchar(120)        | NO       | \-            | PK semantic | Tipo de command.              | APPLY_MIGRATION |
| request_hash      | varchar(128)        | NO       | \-            | integrity   | Hash canonical request.       | sha256:…        |
| status            | varchar(24)         | NO       | 'IN_PROGRESS' | CHECK       | IN_PROGRESS/COMPLETED/FAILED. | COMPLETED       |
| response_status   | integer             | YES      | NULL          | snapshot    | HTTP/result status.           | 201             |
| response_ref      | varchar(300)        | YES      | NULL          | snapshot    | Ref/summary de respuesta.     | progress:…      |
| lease_owner       | varchar(160)        | YES      | NULL          | lease       | Owner temporal.               | pod-7           |
| lease_until       | timestamptz         | YES      | NULL          | lease       | Fin de lease.                 | …               |
| attempt_count     | integer             | NO       | 1             | CHECK       | Adquisiciones.                | 2               |
| last_heartbeat_at | timestamptz         | YES      | NULL          | lease       | Heartbeat owner.              | …               |
| updated_at        | timestamptz         | NO       | now()         | audit       | Actualización.                | …               |
| created_at        | timestamptz         | NO       | now()         | audit       | Creación.                     | …               |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**idempotency_key —** Clave cliente/lógica. Tipo físico varchar(160); nulabilidad NO; default -; rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 01J….

**command_scope —** Tipo de command. Tipo físico varchar(120); nulabilidad NO; default -; rol de clave PK semantic. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: APPLY_MIGRATION.

**request_hash —** Hash canonical request. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: sha256:….

**status —** IN_PROGRESS/COMPLETED/FAILED. Tipo físico varchar(24); nulabilidad NO; default 'IN_PROGRESS'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: COMPLETED.

**response_status —** HTTP/result status. Tipo físico integer; nulabilidad YES; default NULL; rol de clave snapshot. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 201.

**response_ref —** Ref/summary de respuesta. Tipo físico varchar(300); nulabilidad YES; default NULL; rol de clave snapshot. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: progress:….

**lease_owner —** Owner temporal. Tipo físico varchar(160); nulabilidad YES; default NULL; rol de clave lease. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: pod-7.

**lease_until —** Fin de lease. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave lease. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**attempt_count —** Adquisiciones. Tipo físico integer; nulabilidad NO; default 1; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 2.

**last_heartbeat_at —** Heartbeat owner. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave lease. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**updated_at —** Actualización. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

### 

| **Nombre físico**     | **Tipo** | **Definición/expresión**                      | **Error que impide**          |
|-----------------------|----------|-----------------------------------------------|-------------------------------|
| pk_ec10_idempotency   | PK       | (tenant_id,command_scope,idempotency_key)     | Duplicar key                  |
| ck_ec10_idem_lease    | CHECK    | IN_PROGRESS implica owner+until               | Trabajo huérfano sin metadata |
| ck_ec10_idem_attempt  | CHECK    | attempt_count\>0                              | Contador inválido             |
| ix_ec10_idem_recovery | INDEX    | (status,lease_until) WHERE status=IN_PROGRESS | Recovery ineficiente          |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Replay con payload distinto, IN_PROGRESS huérfano o doble owner. |
|----------------------------------------------------------------------------------------------------------------------------------|

## 

Outbox transaccional para integration events EC-10 con claim/lease multi-instancia.

Participación arquitectónica — Aggregate/área gobernante: Infra EC-10. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Pérdida/duplicidad operativa sin ownership y eventos huérfanos. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**              | **Ejemplo**            |
|-----------------|---------------------|----------|-------------------|-----------|------------------------------|------------------------|
| tenant_id       | uuid                | NO       | \-                | PK scope  | Tenant.                      | …                      |
| event_id        | uuid                | NO       | gen_random_uuid() | PK        | Identidad evento.            | …                      |
| aggregate_type  | varchar(80)         | NO       | \-                | \-        | Tipo root.                   | PathwayProgress        |
| aggregate_id    | uuid                | NO       | \-                | \-        | ID aggregate.                | …                      |
| event_type      | varchar(120)        | NO       | \-                | catalog   | Tipo evento.                 | PathwayProgressChanged |
| schema_version  | integer             | NO       | 1                 | version   | Schema payload.              | 1                      |
| correlation_id  | uuid                | NO       | \-                | trace     | Correlación.                 | …                      |
| causation_id    | uuid                | YES      | NULL              | trace     | Causa previa.                | …                      |
| occurred_at     | timestamptz         | NO       | now()             | time      | Ocurrencia.                  | …                      |
| payload         | jsonb               | NO       | \-                | payload   | Evento versionado.           | {…}                    |
| status          | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/SENT/DEAD. | PENDING                |
| lease_owner     | varchar(160)        | YES      | NULL              | lease     | Owner dispatcher.            | pod-2                  |
| lease_until     | timestamptz         | YES      | NULL              | lease     | Vencimiento.                 | …                      |
| attempt_count   | integer             | NO       | 0                 | CHECK     | Intentos.                    | 1                      |
| last_error_code | varchar(120)        | YES      | NULL              | diag      | Último error estable.        | BROKER_TIMEOUT         |
| created_at      | timestamptz         | NO       | now()             | audit     | Creación.                    | …                      |
| updated_at      | timestamptz         | NO       | now()             | audit     | Actualización.               | …                      |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**event_id —** Identidad evento. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**aggregate_type —** Tipo root. Tipo físico varchar(80); nulabilidad NO; default -; rol de clave -. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: PathwayProgress.

**aggregate_id —** ID aggregate. Tipo físico uuid; nulabilidad NO; default -; rol de clave -. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**event_type —** Tipo evento. Tipo físico varchar(120); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: PathwayProgressChanged.

**schema_version —** Schema payload. Tipo físico integer; nulabilidad NO; default 1; rol de clave version. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 1.

**correlation_id —** Correlación. Tipo físico uuid; nulabilidad NO; default -; rol de clave trace. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**causation_id —** Causa previa. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave trace. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**occurred_at —** Ocurrencia. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**payload —** Evento versionado. Tipo físico jsonb; nulabilidad NO; default -; rol de clave payload. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: {…}.

**status —** PENDING/IN_FLIGHT/SENT/DEAD. Tipo físico varchar(24); nulabilidad NO; default 'PENDING'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: PENDING.

**lease_owner —** Owner dispatcher. Tipo físico varchar(160); nulabilidad YES; default NULL; rol de clave lease. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: pod-2.

**lease_until —** Vencimiento. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave lease. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**attempt_count —** Intentos. Tipo físico integer; nulabilidad NO; default 0; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 1.

**last_error_code —** Último error estable. Tipo físico varchar(120); nulabilidad YES; default NULL; rol de clave diag. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: BROKER_TIMEOUT.

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**updated_at —** Actualización. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

### 

| **Nombre físico**    | **Tipo** | **Definición/expresión**                | **Error que impide** |
|----------------------|----------|-----------------------------------------|----------------------|
| pk_ec10_outbox       | PK       | (tenant_id,event_id)                    | Duplicar evento      |
| ck_ec10_outbox_lease | CHECK    | IN_FLIGHT implica owner+until           | Owner ambiguo        |
| ix_ec10_outbox_claim | INDEX    | (status,lease_until,occurred_at)        | Claim ineficiente    |
| rls_ec10_outbox      | RLS      | tenant policy para runtime/worker scope | Cross-tenant         |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Pérdida/duplicidad operativa sin ownership y eventos huérfanos. |
|---------------------------------------------------------------------------------------------------------------------------------|

## 

Registro de deduplicación por consumidor para eventos externos at-least-once.

Participación arquitectónica — Aggregate/área gobernante: Infra EC-10. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: Procesar dos veces el mismo event o aceptar payload cambiado. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**                 | **Ejemplo**         |
|----------------|---------------------|----------|-------------|-----------|---------------------------------|---------------------|
| tenant_id      | uuid                | NO       | \-          | PK scope  | Tenant.                         | …                   |
| consumer_code  | varchar(120)        | NO       | \-          | PK        | Consumidor lógico.              | ec10-award-consumer |
| event_id       | uuid                | NO       | \-          | PK        | ID evento externo.              | …                   |
| schema_version | integer             | NO       | 1           | version   | Schema recibido.                | 1                   |
| payload_hash   | varchar(128)        | NO       | \-          | integrity | Hash canonical payload.         | sha256:…            |
| status         | varchar(24)         | NO       | 'RECEIVED'  | CHECK     | RECEIVED/PROCESSED/QUARANTINED. | PROCESSED           |
| processed_at   | timestamptz         | YES      | NULL        | time      | Fin procesamiento.              | …                   |
| correlation_id | uuid                | YES      | NULL        | trace     | Correlación.                    | …                   |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**consumer_code —** Consumidor lógico. Tipo físico varchar(120); nulabilidad NO; default -; rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ec10-award-consumer.

**event_id —** ID evento externo. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**schema_version —** Schema recibido. Tipo físico integer; nulabilidad NO; default 1; rol de clave version. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 1.

**payload_hash —** Hash canonical payload. Tipo físico varchar(128); nulabilidad NO; default -; rol de clave integrity. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: sha256:….

**status —** RECEIVED/PROCESSED/QUARANTINED. Tipo físico varchar(24); nulabilidad NO; default 'RECEIVED'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: PROCESSED.

**processed_at —** Fin procesamiento. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**correlation_id —** Correlación. Tipo físico uuid; nulabilidad YES; default NULL; rol de clave trace. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

### 

| **Nombre físico**    | **Tipo** | **Definición/expresión**           | **Error que impide** |
|----------------------|----------|------------------------------------|----------------------|
| pk_ec10_inbox        | PK       | (tenant_id,consumer_code,event_id) | Doble procesamiento  |
| ck_ec10_inbox_status | CHECK    | status allowlist                   | Estado inválido      |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** Procesar dos veces el mismo event o aceptar payload cambiado. |
|-------------------------------------------------------------------------------------------------------------------------------|

## 

Estado consultable de operaciones largas/reconciliables: rebuild, migration apply, issuance, export.

Participación arquitectónica — Aggregate/área gobernante: Infra EC-10. La tabla es creada y modificada únicamente mediante application services del módulo o workers técnicos autorizados; las queries respetan tenant scope. Su lifecycle sigue los commands y state machines de EC-10. Las integraciones externas se representan mediante referencias opacas, hashes y receipts, nunca mediante FKs cross-context.

Qué protege / qué no representa — Protege: 202 sin trazabilidad, progreso inválido o terminal inconsistente. No representa la verdad maestra de identidades, definiciones académicas, resultados, documentos ni credenciales externas salvo que la tabla sea explícitamente la autoridad local de ese hecho/proyección.

| **Campo**        | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                                            | **Ejemplo**             |
|------------------|---------------------|----------|-------------------|-------------|------------------------------------------------------------|-------------------------|
| tenant_id        | uuid                | NO       | \-                | PK/FK scope | Tenant propietario; proviene de TenantContext.             | b4b0…                   |
| id               | uuid                | NO       | gen_random_uuid() | PK          | Identidad opaca local.                                     | 5f2a…                   |
| operation_type   | varchar(80)         | NO       | \-                | catalog     | Tipo operación.                                            | PATHWAY_MIGRATION_APPLY |
| subject_ref      | varchar(240)        | NO       | \-                | logical ref | Sujeto.                                                    | migration:…             |
| state            | varchar(24)         | NO       | 'PENDING'         | CHECK       | PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. | UNKNOWN_EFFECT          |
| progress_percent | numeric(7,4)        | YES      | NULL              | CHECK       | Progreso técnico, no académico.                            | 55.0000                 |
| reason_code      | varchar(120)        | YES      | NULL              | diag        | Razón terminal/intermedia.                                 | REMOTE_TIMEOUT          |
| correlation_id   | uuid                | NO       | \-                | trace       | Correlación.                                               | …                       |
| started_at       | timestamptz         | YES      | NULL              | time        | Inicio.                                                    | …                       |
| finished_at      | timestamptz         | YES      | NULL              | time        | Fin si terminal.                                           | NULL                    |
| result_ref       | varchar(300)        | YES      | NULL              | result      | Ref al resultado.                                          | award:…                 |
| revision         | bigint              | NO       | 0                 | ETag        | Concurrencia de cancel/reconcile.                          | 2                       |
| updated_at       | timestamptz         | NO       | now()             | audit       | Actualización.                                             | …                       |
| created_at       | timestamptz         | NO       | now()             | audit       | Creación.                                                  | …                       |

### 

**tenant_id —** Tenant propietario. Se obtiene del contexto autenticado y nunca del payload libre; participa en PK/FK/RLS y no cambia durante el lifecycle. Tipo físico uuid; nulabilidad NO; default -; rol de clave PK/FK scope. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: b4b0….

**id —** UUID opaco generado server-side. No codifica tenant, persona ni semántica de negocio; se expone como string en APIs. Tipo físico uuid; nulabilidad NO; default gen_random_uuid(); rol de clave PK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 5f2a….

**operation_type —** Tipo operación. Tipo físico varchar(80); nulabilidad NO; default -; rol de clave catalog. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: PATHWAY_MIGRATION_APPLY.

**subject_ref —** Sujeto. Tipo físico varchar(240); nulabilidad NO; default -; rol de clave logical ref. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: migration:….

**state —** PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. Tipo físico varchar(24); nulabilidad NO; default 'PENDING'; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: UNKNOWN_EFFECT.

**progress_percent —** Progreso técnico, no académico. Tipo físico numeric(7,4); nulabilidad YES; default NULL; rol de clave CHECK. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 55.0000.

**reason_code —** Razón terminal/intermedia. Tipo físico varchar(120); nulabilidad YES; default NULL; rol de clave diag. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: REMOTE_TIMEOUT.

**correlation_id —** Correlación. Tipo físico uuid; nulabilidad NO; default -; rol de clave trace. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**started_at —** Inicio. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**finished_at —** Fin si terminal. Tipo físico timestamptz; nulabilidad YES; default NULL; rol de clave time. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: NULL.

**result_ref —** Ref al resultado. Tipo físico varchar(300); nulabilidad YES; default NULL; rol de clave result. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: award:….

**revision —** Contador de concurrencia optimista. Toda mutación semántica del aggregate lo incrementa y se materializa como ETag; no es timestamp. Tipo físico bigint; nulabilidad NO; default 0; rol de clave ETag. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: 2.

**updated_at —** Actualización. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

**created_at —** Creación. Tipo físico timestamptz; nulabilidad NO; default now(); rol de clave audit. Validación: debe respetar constraints, tenant scope y lifecycle de la tabla; seguridad: no debe permitir elevación de privilegio ni inferencia de otro tenant. Relación de dominio: participa en Infra EC-10. Ejemplo: ….

### 

| **Nombre físico**          | **Tipo** | **Definición/expresión**                                                 | **Error que impide** |
|----------------------------|----------|--------------------------------------------------------------------------|----------------------|
| ck_ec10_operation_percent  | CHECK    | progress_percent IS NULL OR progress_percent BETWEEN 0 AND 100           | Progreso inválido    |
| ck_ec10_operation_terminal | CHECK    | finished_at requerido para terminal excepto UNKNOWN_EFFECT según runbook | Terminal incoherente |
| ix_ec10_operation_state    | INDEX    | (tenant_id,state,updated_at)                                             | Ops query lenta      |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL AUNQUE BACKEND TENGA UN BUG? —** 202 sin trazabilidad, progreso inválido o terminal inconsistente. |
|-----------------------------------------------------------------------------------------------------------------------------------|

# 

El siguiente baseline se divide conceptualmente en migrations expand-only. En producción debe versionarse como archivos Flyway pequeños y compatibles N/N-1; se muestra unido para que el equipo pueda copiar, revisar y ejecutar en un entorno limpio. Las referencias cross-context permanecen sin FK física.

```
CREATE SCHEMA IF NOT EXISTS ec10;
CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE OR REPLACE FUNCTION ec10.current_tenant_id() RETURNS uuid
LANGUAGE sql STABLE AS $$
SELECT nullif(current_setting('peopleu.tenant_id', true),'')::uuid
$$;

CREATE TABLE ec10.learning_trajectory (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
person_ref uuid NOT NULL,
trajectory_scope_code varchar(80) NOT NULL,
state varchar(24) NOT NULL DEFAULT 'ACTIVE',
primary_locale varchar(16) NOT NULL DEFAULT 'es-BO',
revision bigint NOT NULL DEFAULT 0,
created_at timestamptz NOT NULL DEFAULT now(),
created_by_ref uuid NOT NULL,
updated_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_learning_trajectory PRIMARY KEY (tenant_id,id),
CONSTRAINT ck_ec10_trajectory_state CHECK (state IN ('ACTIVE','SUSPENDED','CLOSED')),
CONSTRAINT ck_ec10_trajectory_revision CHECK (revision >= 0)
);
CREATE UNIQUE INDEX uq_ec10_trajectory_person_scope_active
ON ec10.learning_trajectory(tenant_id,person_ref,trajectory_scope_code)
WHERE state <> 'CLOSED';

CREATE TABLE ec10.pathway_progress (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
trajectory_id uuid NOT NULL,
pathway_definition_ref uuid NOT NULL,
pathway_version_ref uuid NOT NULL,
pathway_version_no integer NOT NULL,
pathway_content_hash varchar(128) NOT NULL,
state varchar(24) NOT NULL DEFAULT 'DRAFT',
started_at timestamptz NULL,
completed_at timestamptz NULL,
migrated_from_progress_id uuid NULL,
current_snapshot_id uuid NULL,
dependency_state varchar(24) NOT NULL DEFAULT 'AVAILABLE',
revision bigint NOT NULL DEFAULT 0,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_pathway_progress PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_progress_trajectory FOREIGN KEY (tenant_id,trajectory_id)
REFERENCES ec10.learning_trajectory(tenant_id,id),
CONSTRAINT fk_ec10_progress_migrated_from FOREIGN KEY (tenant_id,migrated_from_progress_id)
REFERENCES ec10.pathway_progress(tenant_id,id),
CONSTRAINT ck_ec10_progress_version_no CHECK (pathway_version_no > 0),
CONSTRAINT ck_ec10_progress_not_self_migrated CHECK (migrated_from_progress_id IS NULL OR migrated_from_progress_id <> id),
CONSTRAINT ck_ec10_progress_state CHECK (state IN ('DRAFT','ACTIVE','COMPLETED','SUSPENDED','MIGRATED','CLOSED')),
CONSTRAINT ck_ec10_progress_dependency CHECK (dependency_state IN ('AVAILABLE','STALE','PARTIAL','UNAVAILABLE','UNKNOWN_EFFECT')),
CONSTRAINT ck_ec10_progress_completion_time CHECK ((state='COMPLETED' AND completed_at IS NOT NULL) OR state<>'COMPLETED')
);
CREATE UNIQUE INDEX uq_ec10_progress_path_active
ON ec10.pathway_progress(tenant_id,trajectory_id,pathway_version_ref)
WHERE state <> 'CLOSED';
CREATE INDEX ix_ec10_progress_trajectory_state ON ec10.pathway_progress(tenant_id,trajectory_id,state);

CREATE TABLE ec10.trajectory_fact (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
trajectory_id uuid NOT NULL,
source_fact_key varchar(200) NOT NULL,
fact_type varchar(50) NOT NULL,
source_system_code varchar(60) NOT NULL,
source_ref varchar(200) NOT NULL,
source_event_id uuid NULL,
occurred_at timestamptz NOT NULL,
received_at timestamptz NOT NULL DEFAULT now(),
valid_from timestamptz NULL,
valid_until timestamptz NULL,
status varchar(24) NOT NULL DEFAULT 'ACCEPTED',
provenance_hash varchar(128) NOT NULL,
payload_schema_version integer NOT NULL DEFAULT 1,
fact_payload jsonb NOT NULL DEFAULT '{}'::jsonb,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_trajectory_fact PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_fact_trajectory FOREIGN KEY (tenant_id,trajectory_id)
REFERENCES ec10.learning_trajectory(tenant_id,id),
CONSTRAINT uq_ec10_fact_source_key UNIQUE (tenant_id,source_fact_key),
CONSTRAINT ck_ec10_fact_status CHECK (status IN ('ACCEPTED','QUARANTINED','SUPERSEDED')),
CONSTRAINT ck_ec10_fact_schema CHECK (payload_schema_version > 0),
CONSTRAINT ck_ec10_fact_validity CHECK (valid_until IS NULL OR valid_from IS NULL OR valid_until > valid_from)
);
CREATE UNIQUE INDEX uq_ec10_fact_event ON ec10.trajectory_fact(tenant_id,source_event_id)
WHERE source_event_id IS NOT NULL;
CREATE INDEX ix_ec10_fact_trajectory_time ON ec10.trajectory_fact(tenant_id,trajectory_id,occurred_at,id);
CREATE INDEX ix_ec10_fact_payload_gin ON ec10.trajectory_fact USING gin(fact_payload);

CREATE TABLE ec10.fact_contribution (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
fact_id uuid NOT NULL,
progress_id uuid NOT NULL,
node_ref uuid NOT NULL,
contribution_kind varchar(40) NOT NULL,
contribution_weight numeric(12,4) NOT NULL DEFAULT 1,
policy_ref varchar(200) NOT NULL,
policy_hash varchar(128) NOT NULL,
decision_ref uuid NULL,
effective_from timestamptz NOT NULL DEFAULT now(),
effective_until timestamptz NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_fact_contribution PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_contrib_fact FOREIGN KEY (tenant_id,fact_id) REFERENCES ec10.trajectory_fact(tenant_id,id),
CONSTRAINT fk_ec10_contrib_progress FOREIGN KEY (tenant_id,progress_id) REFERENCES ec10.pathway_progress(tenant_id,id),
CONSTRAINT ck_ec10_contrib_kind CHECK (contribution_kind IN ('SATISFY','PARTIAL','WAIVE','REVOKE','EXPIRE','CARRY_FORWARD')),
CONSTRAINT ck_ec10_contrib_weight CHECK (contribution_weight >= 0),
CONSTRAINT ck_ec10_contrib_window CHECK (effective_until IS NULL OR effective_until > effective_from)
);
CREATE INDEX ix_ec10_contrib_node ON ec10.fact_contribution(tenant_id,progress_id,node_ref,effective_from);

CREATE TABLE ec10.node_progress (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
progress_id uuid NOT NULL,
node_ref uuid NOT NULL,
state varchar(24) NOT NULL DEFAULT 'NOT_STARTED',
satisfied_weight numeric(12,4) NOT NULL DEFAULT 0,
required_weight numeric(12,4) NOT NULL DEFAULT 1,
reason_code varchar(80) NULL,
blocking_node_ref uuid NULL,
satisfaction_basis_hash varchar(128) NULL,
evaluated_at timestamptz NOT NULL DEFAULT now(),
as_of timestamptz NOT NULL DEFAULT now(),
dependency_state varchar(24) NOT NULL DEFAULT 'AVAILABLE',
CONSTRAINT pk_ec10_node_progress PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_node_progress_parent FOREIGN KEY (tenant_id,progress_id) REFERENCES ec10.pathway_progress(tenant_id,id),
CONSTRAINT uq_ec10_node_progress UNIQUE (tenant_id,progress_id,node_ref),
CONSTRAINT ck_ec10_node_state CHECK (state IN ('NOT_STARTED','IN_PROGRESS','SATISFIED','BLOCKED','MANUAL_REVIEW','EXPIRED','REVOKED','WAIVED')),
CONSTRAINT ck_ec10_node_weights CHECK (required_weight > 0 AND satisfied_weight >= 0),
CONSTRAINT ck_ec10_node_dependency CHECK (dependency_state IN ('AVAILABLE','STALE','PARTIAL','UNAVAILABLE','UNKNOWN_EFFECT'))
);
CREATE INDEX ix_ec10_node_state ON ec10.node_progress(tenant_id,progress_id,state);

CREATE TABLE ec10.progress_snapshot (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
progress_id uuid NOT NULL,
snapshot_no bigint NOT NULL,
engine_version varchar(60) NOT NULL,
canonical_schema_version integer NOT NULL DEFAULT 1,
pathway_content_hash varchar(128) NOT NULL,
input_watermark varchar(200) NOT NULL,
policy_set_hash varchar(128) NOT NULL,
progress_percent numeric(7,4) NULL,
satisfied_nodes integer NOT NULL DEFAULT 0,
required_nodes integer NOT NULL DEFAULT 0,
blocking_count integer NOT NULL DEFAULT 0,
dependency_state varchar(24) NOT NULL DEFAULT 'AVAILABLE',
result_hash varchar(128) NOT NULL,
snapshot_payload jsonb NOT NULL DEFAULT '{}'::jsonb,
supersedes_snapshot_id uuid NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_progress_snapshot PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_snapshot_progress FOREIGN KEY (tenant_id,progress_id) REFERENCES ec10.pathway_progress(tenant_id,id),
CONSTRAINT fk_ec10_snapshot_supersedes FOREIGN KEY (tenant_id,supersedes_snapshot_id) REFERENCES ec10.progress_snapshot(tenant_id,id),
CONSTRAINT uq_ec10_snapshot_seq UNIQUE (tenant_id,progress_id,snapshot_no),
CONSTRAINT ck_ec10_snapshot_percent CHECK (progress_percent IS NULL OR progress_percent BETWEEN 0 AND 100),
CONSTRAINT ck_ec10_snapshot_counts CHECK (satisfied_nodes>=0 AND required_nodes>=0 AND blocking_count>=0 AND satisfied_nodes<=required_nodes),
CONSTRAINT ck_ec10_snapshot_dependency CHECK (dependency_state IN ('AVAILABLE','STALE','PARTIAL','UNAVAILABLE','UNKNOWN_EFFECT'))
);
CREATE INDEX ix_ec10_snapshot_asof ON ec10.progress_snapshot(tenant_id,progress_id,created_at DESC);
ALTER TABLE ec10.pathway_progress ADD CONSTRAINT fk_ec10_progress_current_snapshot
FOREIGN KEY (tenant_id,current_snapshot_id) REFERENCES ec10.progress_snapshot(tenant_id,id)
DEFERRABLE INITIALLY DEFERRED;

CREATE TABLE ec10.recognition_claim (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
trajectory_id uuid NOT NULL,
claim_type varchar(40) NOT NULL,
target_pathway_version_ref uuid NOT NULL,
target_node_ref uuid NULL,
state varchar(24) NOT NULL DEFAULT 'DRAFT',
submitted_at timestamptz NULL,
workflow_ref uuid NULL,
decision varchar(24) NULL,
decision_reason_code varchar(80) NULL,
policy_ref varchar(200) NULL,
policy_hash varchar(128) NULL,
recognized_fact_id uuid NULL,
revision bigint NOT NULL DEFAULT 0,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_recognition_claim PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_claim_trajectory FOREIGN KEY (tenant_id,trajectory_id) REFERENCES ec10.learning_trajectory(tenant_id,id),
CONSTRAINT fk_ec10_claim_recognized_fact FOREIGN KEY (tenant_id,recognized_fact_id) REFERENCES ec10.trajectory_fact(tenant_id,id),
CONSTRAINT ck_ec10_claim_state CHECK (state IN ('DRAFT','SUBMITTED','VERIFYING','IN_REVIEW','ACCEPTED','PARTIAL','REJECTED','WITHDRAWN')),
CONSTRAINT ck_ec10_claim_decision CHECK (decision IS NULL OR decision IN ('ACCEPTED','PARTIAL','REJECTED')),
CONSTRAINT ck_ec10_claim_terminal CHECK (
state NOT IN ('ACCEPTED','PARTIAL','REJECTED') OR
(decision IS NOT NULL AND decision_reason_code IS NOT NULL AND policy_ref IS NOT NULL AND policy_hash IS NOT NULL)
)
);
CREATE INDEX ix_ec10_claim_trajectory_state ON ec10.recognition_claim(tenant_id,trajectory_id,state);

CREATE TABLE ec10.recognition_claim_evidence (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
claim_id uuid NOT NULL,
evidence_ref uuid NOT NULL,
evidence_type_code varchar(60) NOT NULL,
evidence_hash varchar(128) NOT NULL,
verification_state varchar(24) NOT NULL DEFAULT 'PENDING',
verified_at timestamptz NULL,
verified_by_ref uuid NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_claim_evidence PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_claim_evidence_claim FOREIGN KEY (tenant_id,claim_id) REFERENCES ec10.recognition_claim(tenant_id,id),
CONSTRAINT uq_ec10_claim_evidence UNIQUE (tenant_id,claim_id,evidence_ref,evidence_hash),
CONSTRAINT ck_ec10_evidence_state CHECK (verification_state IN ('PENDING','VERIFIED','REJECTED','STALE')),
CONSTRAINT ck_ec10_evidence_verify CHECK (verification_state <> 'VERIFIED' OR (verified_at IS NOT NULL AND verified_by_ref IS NOT NULL))
);

CREATE TABLE ec10.manual_override (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
progress_id uuid NOT NULL,
node_ref uuid NULL,
override_kind varchar(40) NOT NULL,
reason_code varchar(80) NOT NULL,
evidence_ref uuid NULL,
workflow_ref uuid NULL,
approved_by_ref uuid NOT NULL,
approved_at timestamptz NOT NULL,
supersedes_override_id uuid NULL,
receipt_hash varchar(128) NOT NULL,
CONSTRAINT pk_ec10_manual_override PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_override_progress FOREIGN KEY (tenant_id,progress_id) REFERENCES ec10.pathway_progress(tenant_id,id),
CONSTRAINT fk_ec10_override_supersedes FOREIGN KEY (tenant_id,supersedes_override_id) REFERENCES ec10.manual_override(tenant_id,id),
CONSTRAINT ck_ec10_override_kind CHECK (override_kind IN ('WAIVE','ADJUST','EXPIRY_EXCEPTION','REVERSE')),
CONSTRAINT ck_ec10_override_self CHECK (supersedes_override_id IS NULL OR supersedes_override_id<>id)
);
CREATE INDEX ix_ec10_override_node ON ec10.manual_override(tenant_id,progress_id,node_ref,approved_at DESC);

CREATE TABLE ec10.pathway_migration_case (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
source_progress_id uuid NOT NULL,
target_pathway_version_ref uuid NOT NULL,
target_pathway_content_hash varchar(128) NOT NULL,
state varchar(24) NOT NULL DEFAULT 'DRAFT',
diff_hash varchar(128) NULL,
simulation_hash varchar(128) NULL,
workflow_ref uuid NULL,
target_progress_id uuid NULL,
revision bigint NOT NULL DEFAULT 0,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_pathway_migration_case PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_migration_source FOREIGN KEY (tenant_id,source_progress_id) REFERENCES ec10.pathway_progress(tenant_id,id),
CONSTRAINT fk_ec10_migration_target_progress FOREIGN KEY (tenant_id,target_progress_id) REFERENCES ec10.pathway_progress(tenant_id,id),
CONSTRAINT ck_ec10_migration_state CHECK (state IN ('DRAFT','SIMULATED','IN_REVIEW','APPROVED','APPLYING','APPLIED','FAILED','CANCELLED','UNKNOWN_EFFECT'))
);
CREATE UNIQUE INDEX uq_ec10_migration_open ON ec10.pathway_migration_case(tenant_id,source_progress_id,target_pathway_version_ref)
WHERE state NOT IN ('APPLIED','FAILED','CANCELLED');

CREATE TABLE ec10.migration_mapping (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
migration_case_id uuid NOT NULL,
source_node_ref uuid NULL,
target_node_ref uuid NULL,
mapping_kind varchar(32) NOT NULL,
confidence numeric(5,4) NULL,
policy_ref varchar(200) NOT NULL,
decision_reason_code varchar(80) NOT NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_migration_mapping PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_mapping_case FOREIGN KEY (tenant_id,migration_case_id) REFERENCES ec10.pathway_migration_case(tenant_id,id),
CONSTRAINT ck_ec10_mapping_kind CHECK (mapping_kind IN ('EXACT','EQUIVALENT','PARTIAL','DROPPED','NEW_REQUIRED')),
CONSTRAINT ck_ec10_mapping_confidence CHECK (confidence IS NULL OR confidence BETWEEN 0 AND 1),
CONSTRAINT ck_ec10_mapping_shape CHECK (
(mapping_kind='DROPPED' AND source_node_ref IS NOT NULL AND target_node_ref IS NULL) OR
(mapping_kind='NEW_REQUIRED' AND source_node_ref IS NULL AND target_node_ref IS NOT NULL) OR
(mapping_kind IN ('EXACT','EQUIVALENT','PARTIAL') AND source_node_ref IS NOT NULL AND target_node_ref IS NOT NULL)
)
);

CREATE TABLE ec10.carry_forward_receipt (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
migration_case_id uuid NOT NULL,
source_contribution_id uuid NOT NULL,
target_contribution_id uuid NOT NULL,
mapping_id uuid NOT NULL,
receipt_schema_version integer NOT NULL DEFAULT 1,
canonical_schema_version integer NOT NULL DEFAULT 1,
receipt_hash varchar(128) NOT NULL,
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_carry_forward_receipt PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_carry_case FOREIGN KEY (tenant_id,migration_case_id) REFERENCES ec10.pathway_migration_case(tenant_id,id),
CONSTRAINT fk_ec10_carry_source FOREIGN KEY (tenant_id,source_contribution_id) REFERENCES ec10.fact_contribution(tenant_id,id),
CONSTRAINT fk_ec10_carry_target FOREIGN KEY (tenant_id,target_contribution_id) REFERENCES ec10.fact_contribution(tenant_id,id),
CONSTRAINT fk_ec10_carry_mapping FOREIGN KEY (tenant_id,mapping_id) REFERENCES ec10.migration_mapping(tenant_id,id),
CONSTRAINT uq_ec10_carry_source_target UNIQUE (tenant_id,migration_case_id,source_contribution_id,target_contribution_id)
);

CREATE TABLE ec10.cumulative_eligibility_decision (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
progress_id uuid NOT NULL,
snapshot_id uuid NOT NULL,
target_credential_blueprint_ref uuid NOT NULL,
decision varchar(24) NOT NULL,
reason_code varchar(80) NOT NULL,
policy_ref varchar(200) NOT NULL,
policy_hash varchar(128) NOT NULL,
decision_hash varchar(128) NOT NULL,
issued_award_ref uuid NULL,
issuance_state varchar(24) NOT NULL DEFAULT 'NOT_REQUESTED',
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_eligibility PRIMARY KEY (tenant_id,id),
CONSTRAINT fk_ec10_elig_progress FOREIGN KEY (tenant_id,progress_id) REFERENCES ec10.pathway_progress(tenant_id,id),
CONSTRAINT fk_ec10_elig_snapshot FOREIGN KEY (tenant_id,snapshot_id) REFERENCES ec10.progress_snapshot(tenant_id,id),
CONSTRAINT ck_ec10_elig_decision CHECK (decision IN ('PENDING','ELIGIBLE','NOT_ELIGIBLE','SUPERSEDED','REVOKED')),
CONSTRAINT ck_ec10_issuance_state CHECK (issuance_state IN ('NOT_REQUESTED','REQUESTED','CONFIRMED','UNKNOWN_EFFECT','FAILED')),
CONSTRAINT ck_ec10_issuance_award CHECK (issuance_state <> 'CONFIRMED' OR issued_award_ref IS NOT NULL)
);
CREATE INDEX ix_ec10_elig_blueprint ON ec10.cumulative_eligibility_decision(tenant_id,progress_id,target_credential_blueprint_ref,created_at DESC);

CREATE TABLE ec10.recognition_receipt (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
receipt_type varchar(60) NOT NULL,
subject_type varchar(60) NOT NULL,
subject_id uuid NOT NULL,
actor_ref uuid NOT NULL,
reason_code varchar(80) NOT NULL,
content_hash varchar(128) NOT NULL,
canonical_schema_version integer NOT NULL DEFAULT 1,
receipt_schema_version integer NOT NULL DEFAULT 1,
occurred_at timestamptz NOT NULL DEFAULT now(),
payload jsonb NOT NULL DEFAULT '{}'::jsonb,
CONSTRAINT pk_ec10_recognition_receipt PRIMARY KEY (tenant_id,id)
);
CREATE INDEX ix_ec10_receipt_subject ON ec10.recognition_receipt(tenant_id,subject_type,subject_id,occurred_at);

CREATE TABLE ec10.command_idempotency (
tenant_id uuid NOT NULL,
idempotency_key varchar(160) NOT NULL,
command_scope varchar(120) NOT NULL,
request_hash varchar(128) NOT NULL,
status varchar(24) NOT NULL DEFAULT 'IN_PROGRESS',
response_status integer NULL,
response_ref varchar(300) NULL,
lease_owner varchar(160) NULL,
lease_until timestamptz NULL,
attempt_count integer NOT NULL DEFAULT 1,
last_heartbeat_at timestamptz NULL,
updated_at timestamptz NOT NULL DEFAULT now(),
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_idempotency PRIMARY KEY (tenant_id,command_scope,idempotency_key),
CONSTRAINT ck_ec10_idempotency_status CHECK (status IN ('IN_PROGRESS','COMPLETED','FAILED')),
CONSTRAINT ck_ec10_idempotency_lease CHECK (status <> 'IN_PROGRESS' OR (lease_owner IS NOT NULL AND lease_until IS NOT NULL)),
CONSTRAINT ck_ec10_idempotency_attempt CHECK (attempt_count > 0)
);
CREATE INDEX ix_ec10_idem_recovery ON ec10.command_idempotency(status,lease_until) WHERE status='IN_PROGRESS';

CREATE TABLE ec10.outbox_event (
tenant_id uuid NOT NULL,
event_id uuid NOT NULL DEFAULT gen_random_uuid(),
aggregate_type varchar(80) NOT NULL,
aggregate_id uuid NOT NULL,
event_type varchar(120) NOT NULL,
schema_version integer NOT NULL DEFAULT 1,
correlation_id uuid NOT NULL,
causation_id uuid NULL,
occurred_at timestamptz NOT NULL DEFAULT now(),
payload jsonb NOT NULL,
status varchar(24) NOT NULL DEFAULT 'PENDING',
lease_owner varchar(160) NULL,
lease_until timestamptz NULL,
attempt_count integer NOT NULL DEFAULT 0,
last_error_code varchar(120) NULL,
created_at timestamptz NOT NULL DEFAULT now(),
updated_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_outbox PRIMARY KEY (tenant_id,event_id),
CONSTRAINT ck_ec10_outbox_status CHECK (status IN ('PENDING','IN_FLIGHT','SENT','DEAD')),
CONSTRAINT ck_ec10_outbox_lease CHECK (status <> 'IN_FLIGHT' OR (lease_owner IS NOT NULL AND lease_until IS NOT NULL)),
CONSTRAINT ck_ec10_outbox_attempt CHECK (attempt_count >= 0)
);
CREATE INDEX ix_ec10_outbox_claim ON ec10.outbox_event(status,lease_until,occurred_at);

CREATE TABLE ec10.inbox_message (
tenant_id uuid NOT NULL,
consumer_code varchar(120) NOT NULL,
event_id uuid NOT NULL,
schema_version integer NOT NULL,
payload_hash varchar(128) NOT NULL,
status varchar(24) NOT NULL DEFAULT 'RECEIVED',
processed_at timestamptz NULL,
correlation_id uuid NULL,
CONSTRAINT pk_ec10_inbox PRIMARY KEY (tenant_id,consumer_code,event_id),
CONSTRAINT ck_ec10_inbox_status CHECK (status IN ('RECEIVED','PROCESSED','QUARANTINED'))
);

CREATE TABLE ec10.async_operation (
tenant_id uuid NOT NULL,
id uuid NOT NULL DEFAULT gen_random_uuid(),
operation_type varchar(80) NOT NULL,
subject_ref varchar(240) NOT NULL,
state varchar(24) NOT NULL DEFAULT 'PENDING',
progress_percent numeric(7,4) NULL,
reason_code varchar(120) NULL,
correlation_id uuid NOT NULL,
started_at timestamptz NULL,
finished_at timestamptz NULL,
result_ref varchar(300) NULL,
revision bigint NOT NULL DEFAULT 0,
updated_at timestamptz NOT NULL DEFAULT now(),
created_at timestamptz NOT NULL DEFAULT now(),
CONSTRAINT pk_ec10_async_operation PRIMARY KEY (tenant_id,id),
CONSTRAINT ck_ec10_operation_state CHECK (state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED')),
CONSTRAINT ck_ec10_operation_percent CHECK (progress_percent IS NULL OR progress_percent BETWEEN 0 AND 100)
);
CREATE INDEX ix_ec10_operation_state ON ec10.async_operation(tenant_id,state,updated_at);

CREATE OR REPLACE FUNCTION ec10.forbid_mutation() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
RAISE EXCEPTION 'EC10_APPEND_ONLY_TABLE' USING ERRCODE='55000';
END $$;

CREATE TRIGGER trg_ec10_fact_append_only BEFORE UPDATE OR DELETE ON ec10.trajectory_fact
FOR EACH ROW EXECUTE FUNCTION ec10.forbid_mutation();
CREATE TRIGGER trg_ec10_snapshot_append_only BEFORE UPDATE OR DELETE ON ec10.progress_snapshot
FOR EACH ROW EXECUTE FUNCTION ec10.forbid_mutation();
CREATE TRIGGER trg_ec10_receipt_append_only BEFORE UPDATE OR DELETE ON ec10.recognition_receipt
FOR EACH ROW EXECUTE FUNCTION ec10.forbid_mutation();
CREATE TRIGGER trg_ec10_carry_append_only BEFORE UPDATE OR DELETE ON ec10.carry_forward_receipt
FOR EACH ROW EXECUTE FUNCTION ec10.forbid_mutation();

CREATE OR REPLACE FUNCTION ec10.guard_pathway_pin() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
IF OLD.state <> 'DRAFT' AND (
NEW.pathway_definition_ref IS DISTINCT FROM OLD.pathway_definition_ref OR
NEW.pathway_version_ref IS DISTINCT FROM OLD.pathway_version_ref OR
NEW.pathway_version_no IS DISTINCT FROM OLD.pathway_version_no OR
NEW.pathway_content_hash IS DISTINCT FROM OLD.pathway_content_hash) THEN
RAISE EXCEPTION 'EC10_PATHWAY_PIN_IMMUTABLE' USING ERRCODE='23514';
END IF;
RETURN NEW;
END $$;
CREATE TRIGGER trg_ec10_progress_pin_immutable BEFORE UPDATE ON ec10.pathway_progress
FOR EACH ROW EXECUTE FUNCTION ec10.guard_pathway_pin();

-- RLS defense-in-depth
ALTER TABLE ec10.learning_trajectory ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.learning_trajectory FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.pathway_progress ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.pathway_progress FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.trajectory_fact ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.trajectory_fact FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.fact_contribution ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.fact_contribution FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.node_progress ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.node_progress FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.progress_snapshot ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.progress_snapshot FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.recognition_claim ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.recognition_claim FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.recognition_claim_evidence ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.recognition_claim_evidence FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.manual_override ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.manual_override FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.pathway_migration_case ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.pathway_migration_case FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.migration_mapping ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.migration_mapping FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.carry_forward_receipt ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.carry_forward_receipt FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.cumulative_eligibility_decision ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.cumulative_eligibility_decision FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.recognition_receipt ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.recognition_receipt FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.command_idempotency ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.command_idempotency FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.outbox_event ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.outbox_event FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.inbox_message ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.inbox_message FORCE ROW LEVEL SECURITY;
ALTER TABLE ec10.async_operation ENABLE ROW LEVEL SECURITY; ALTER TABLE ec10.async_operation FORCE ROW LEVEL SECURITY;

DO $$
DECLARE t text;
BEGIN
FOREACH t IN ARRAY ARRAY['learning_trajectory','pathway_progress','trajectory_fact','fact_contribution','node_progress','progress_snapshot','recognition_claim','recognition_claim_evidence','manual_override','pathway_migration_case','migration_mapping','carry_forward_receipt','cumulative_eligibility_decision','recognition_receipt','command_idempotency','outbox_event','inbox_message','async_operation']
LOOP
EXECUTE format('CREATE POLICY p_%I_tenant ON ec10.%I USING (tenant_id = ec10.current_tenant_id()) WITH CHECK (tenant_id = ec10.current_tenant_id())', t, t);
END LOOP;
END $$;
```

## 

```
WITH cte AS (
SELECT tenant_id,event_id
FROM ec10.outbox_event
WHERE status='PENDING' OR (status='IN_FLIGHT' AND lease_until < now())
ORDER BY occurred_at
FOR UPDATE SKIP LOCKED
LIMIT :batch_size
)
UPDATE ec10.outbox_event o
SET status='IN_FLIGHT', lease_owner=:worker, lease_until=now()+interval '60 seconds',
attempt_count=attempt_count+1, updated_at=now()
FROM cte
WHERE o.tenant_id=cte.tenant_id AND o.event_id=cte.event_id
RETURNING o.*;
```

## 

- peopleu_migrator: owner de objetos y ejecuta Flyway; no se usa en HTTP runtime.

- peopleu_ec10_runtime: SELECT/INSERT/UPDATE/DELETE solo donde corresponde, sin BYPASSRLS y sin ownership.

- peopleu_ec10_worker: privilegios mínimos sobre inbox/outbox/operations y tablas de dominio necesarias, también con RLS.

- Cada transacción runtime ejecuta SET LOCAL peopleu.tenant_id = :authorizedTenant antes de cualquier query.

- Connection pooling debe limpiar contexto al terminar transacción; nunca SET global persistente.

## 

| **Fase**          | **Acción**                                                                                        | **Gate**                       |
|-------------------|---------------------------------------------------------------------------------------------------|--------------------------------|
| Expand            | Agregar columnas nullable/default seguro, nuevas tablas, índices CONCURRENTLY cuando corresponda. | Schema compatible N/N-1.       |
| Deploy compatible | App nueva escribe old+new o lee fallback compatible.                                              | Contract tests old/new.        |
| Backfill          | Worker idempotente por tenant/range; métricas y reconciliation.                                   | DQ + lag aceptable.            |
| Switch            | Feature flag cambia lectura/escritura a contrato nuevo.                                           | Observabilidad + rollback app. |
| Contract          | Eliminar legacy solo después de N/N-1 y evidencia de cero uso.                                    | ADR + backup/restore probado.  |

# 

## 

EC-10 no requiere MongoDB como Source of Truth. Puede usarse solamente para proyecciones derivadas de explicación compleja, materializaciones de graph/explanation o payloads analíticos que sean reconstruibles desde PostgreSQL/eventos. Nunca almacenar allí facts, decisiones, snapshots autoritativos ni evidencia documental original.

| **Uso**                      | **Colección sugerida**       | **TTL/retención**         | **Regla**                                             |
|------------------------------|------------------------------|---------------------------|-------------------------------------------------------|
| Explanation projection       | ec10_progress_explanation    | Rebuildable; TTL opcional | Incluye source snapshot id/hash; invalidar por event. |
| AI grounding bundle derivado | ec10_ai_grounding_projection | Corta según CT-12         | Sin PII innecesaria; no reemplaza evidence.           |
| Bulk rebuild diagnostic      | ec10_rebuild_diagnostics     | Operacional               | No autoridad; exportable a evidence pack.             |

## 

| **Key pattern**                       | **Uso**                            | **TTL**              | **Invalidación**                  |
|---------------------------------------|------------------------------------|----------------------|-----------------------------------|
| ec10:{tenant}:progress:{id}:summary   | Resumen de lectura                 | 30–120 s             | ProgressChanged / SnapshotCreated |
| ec10:{tenant}:pathway:{version}:meta  | Metadata EC-01 resuelta            | 5–15 min             | PathwayVersionSuperseded / TTL    |
| ec10:{tenant}:op:{operationId}        | OperationStatus hot read           | 15 min tras terminal | Update operation                  |
| ec10:{tenant}:lock:rebuild:{progress} | Coordinación corta no autoritativa | Lease corto          | Owner token + expiry              |

| **REGLA REDIS —** Cache miss nunca significa NO_DATA; se consulta Source of Truth. Un lock Redis no reemplaza transacción/constraint PostgreSQL para invariantes. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

## 

```
com.solveritic.peopleu.ec10
trajectory/
domain/ application/ adapter/in/web/ adapter/out/persistence/
progress/
domain/ application/ adapter/in/web/ adapter/out/persistence/
recognition/
domain/ application/ adapter/in/web/ adapter/out/persistence/
migration/
domain/ application/ adapter/in/web/ adapter/out/persistence/
eligibility/
domain/ application/ adapter/in/web/ adapter/out/persistence/
integration/
ec01/ ec07/ ec08/ ct05/ ct06/ ct12/ ct16/
infrastructure/
tenant/ idempotency/ outbox/ inbox/ operation/ observability/ security/
```

| **Capa**       | **Responsabilidad**                                   | **Prohibición**                      |
|----------------|-------------------------------------------------------|--------------------------------------|
| Domain         | Aggregates, VOs, policies, pure evaluation            | Sin JPA/WebClient/HTTP DTO.          |
| Application    | Commands/queries, transaction boundary, orchestration | No reglas duplicadas en controllers. |
| Ports          | Contratos hacia EC/CT                                 | No SDK proveedor directo.            |
| Adapters in    | REST/event consumers                                  | No mass assignment.                  |
| Adapters out   | JPA/JDBC, EC clients, outbox                          | No FK cross-context.                 |
| Infrastructure | Tenant, idempotency, tracing, workers                 | No bypass de invariantes de dominio. |

## 

```
@Transactional
public ProgressResult acceptCompletion(AcceptCompletionCommand cmd) {
tenantContext.apply();
var idem = idempotency.acquire(cmd.key(), cmd.requestHash());
if (idem.isReplay()) return idem.replay();

var progress = progressRepository.lock(cmd.progressId())
.orElseThrow(NotFound::new);
etag.requireMatch(progress.revision(), cmd.ifMatch());

var fact = progress.acceptFact(cmd.fact(), policyResolver.resolve(cmd));
evaluator.recalculate(progress, fact);
var snapshot = snapshotService.create(progress);
progress.bumpRevision();
receiptStore.append(...);
outbox.append(...);
idempotency.complete(idem, ...);
return mapper.result(progress, snapshot);
}
```

## 

- Preferir JDBC/jOOQ o repositorios explícitos para operations de locks, SKIP LOCKED y bulk; JPA solo si no oculta constraints/locking.

- No cascade ciego para aggregates grandes. Persistir intención y children de manera explícita.

- Usar SELECT ... FOR UPDATE para transitions críticas y revision/If-Match para concurrencia externa.

- Fact/snapshot/receipt append-only deben tener protección tanto en dominio como trigger DB.

- JSONB se limita a payloads versionados; business invariants críticas permanecen en columnas/constraints.

# 

| **Método** | **Ruta**                                                  | **Propósito**          | **Contrato crítico**       |
|------------|-----------------------------------------------------------|------------------------|----------------------------|
| POST       | /api/v1/ec10/trajectories                                 | Crear trajectory       | Idempotency-Key            |
| GET        | /api/v1/ec10/trajectories/{id}                            | Detalle                | ETag                       |
| GET        | /api/v1/ec10/trajectories                                 | Buscar                 | page/filter/sort           |
| POST       | /api/v1/ec10/trajectories/{id}/pathways                   | Iniciar progress       | Idempotency-Key            |
| GET        | /api/v1/ec10/pathway-progress/{id}                        | Resumen                | ETag + asOf                |
| GET        | /api/v1/ec10/pathway-progress/{id}/nodes                  | Nodos                  | filter state               |
| GET        | /api/v1/ec10/pathway-progress/{id}/missing-requirements   | Faltantes              | DependencyState            |
| GET        | /api/v1/ec10/pathway-progress/{id}/next-actions           | Próximas acciones      | policy explain             |
| GET        | /api/v1/ec10/pathway-progress/{id}/snapshots              | Snapshots              | cursor                     |
| GET        | /api/v1/ec10/pathway-progress/{id}/snapshots/{snapshotId} | Snapshot               | immutable                  |
| POST       | /api/v1/ec10/pathway-progress/{id}:recalculate            | Recalcular             | If-Match + key             |
| POST       | /api/v1/ec10/pathway-progress/{id}:rebuild                | Rebuild async          | 202 OperationStatus        |
| POST       | /api/v1/ec10/pathway-progress/{id}:suspend                | Suspender              | If-Match + reason          |
| POST       | /api/v1/ec10/pathway-progress/{id}:reactivate             | Reactivar              | If-Match                   |
| GET        | /api/v1/ec10/pathway-progress/{id}/history                | Historia as-of         | asOf required/optional     |
| GET        | /api/v1/ec10/pathway-progress/{id}/lineage                | Lineage                | purpose-aware              |
| POST       | /api/v1/ec10/recognition-claims                           | Crear claim            | Idempotency-Key            |
| GET        | /api/v1/ec10/recognition-claims/{id}                      | Detalle claim          | ETag                       |
| POST       | /api/v1/ec10/recognition-claims/{id}/evidence             | Añadir evidence ref    | If-Match                   |
| POST       | /api/v1/ec10/recognition-claims/{id}:submit               | Submit                 | If-Match + key             |
| POST       | /api/v1/ec10/recognition-claims/{id}:verify               | Verify evidence        | If-Match                   |
| POST       | /api/v1/ec10/recognition-claims/{id}:accept               | Accept                 | If-Match + step-up         |
| POST       | /api/v1/ec10/recognition-claims/{id}:partial-accept       | Partial                | If-Match + mapping         |
| POST       | /api/v1/ec10/recognition-claims/{id}:reject               | Reject                 | If-Match + reason          |
| POST       | /api/v1/ec10/pathway-progress/{id}/overrides              | Override               | If-Match + step-up         |
| POST       | /api/v1/ec10/migrations                                   | Create migration case  | Idempotency-Key            |
| GET        | /api/v1/ec10/migrations/{id}                              | Detail                 | ETag                       |
| POST       | /api/v1/ec10/migrations/{id}:simulate                     | Simulate               | If-Match                   |
| PUT        | /api/v1/ec10/migrations/{id}/mappings                     | Replace draft mappings | If-Match                   |
| POST       | /api/v1/ec10/migrations/{id}:submit-review                | Review                 | If-Match                   |
| POST       | /api/v1/ec10/migrations/{id}:approve                      | Approve                | step-up + SoD              |
| POST       | /api/v1/ec10/migrations/{id}:apply                        | Apply async            | 202 + key                  |
| GET        | /api/v1/ec10/eligibility-decisions                        | Search decisions       | filters                    |
| POST       | /api/v1/ec10/pathway-progress/{id}:evaluate-eligibility   | Evaluate               | key                        |
| POST       | /api/v1/ec10/eligibility-decisions/{id}:request-issuance  | EC-08 command          | 202/UNKNOWN_EFFECT         |
| GET        | /api/v1/ec10/operations/{id}                              | OperationStatus        | poll/backoff               |
| POST       | /api/v1/ec10/operations/{id}:reconcile                    | Reconcile              | Ops permission             |
| GET        | /api/v1/ec10/self/trajectory                              | Self-service           | person resolved from token |
| GET        | /api/v1/ec10/corporate/aggregates                         | Suppressed aggregate   | EC-09 ReportingProfile     |
| POST       | /api/v1/ec10/exports                                      | Async export           | purpose + 202              |
| GET        | /api/v1/ec10/audit/{subjectType}/{subjectId}              | Audit/evidence         | auditor scope              |
| GET        | /api/v1/ec10/health/dependencies                          | Dependency health      | Ops only                   |

## 

- Responses de aggregates mutables devuelven ETag; commands de mutación usan If-Match y mismatch = 412.

- Create/side-effect commands requieren Idempotency-Key durable; same-key/different-payload = 409.

- Listas: pageSize default 25, máximo 100; sort allowlist; filters bounded; cursor para snapshots/facts voluminosos.

- 202 siempre devuelve OperationStatusDto con operationId, state, pollAfter, correlationId y reconciliationHint cuando corresponda.

- 404 puede usarse para scope denied cuando política anti-IDOR lo requiera; reasonCode interno no filtra existencia cross-scope.

| **reasonCode**                    | **HTTP**       | **Semántica**                                    |
|-----------------------------------|----------------|--------------------------------------------------|
| EC10_ETAG_MISMATCH                | 412            | ETag no coincide; recargar/diff/reaplicar.       |
| EC10_IDEMPOTENCY_KEY_REUSED       | 409            | Misma key con payload distinto.                  |
| EC10_PATHWAY_VERSION_UNAVAILABLE  | 503            | No puede resolver versión pinneada.              |
| EC10_PATHWAY_HASH_MISMATCH        | 409            | Contenido EC-01 no coincide con pin.             |
| EC10_FACT_DUPLICATE               | 200/201 replay | Replay exitoso sin duplicar.                     |
| EC10_FACT_QUARANTINED             | 202            | Hecho no confiable; requiere revisión/reproceso. |
| EC10_CLAIM_EVIDENCE_REQUIRED      | 422            | Falta evidencia mínima.                          |
| EC10_SOD_VIOLATION                | 403            | Actor no puede decidir su propio caso.           |
| EC10_MIGRATION_MAPPING_INCOMPLETE | 422            | Mapping no cubre reglas obligatorias.            |
| EC10_DEPENDENCY_UNAVAILABLE       | 503            | Dependencia crítica no disponible.               |
| EC10_UNKNOWN_EFFECT               | 202            | Efecto remoto ambiguo; reconciliar.              |
| EC10_TENANT_SCOPE_DENIED          | 404/403 policy | Scope no autorizado.                             |

# 

| **Evento**                   | **Aggregate**       | **Consumidor**          | **Payload mínimo**                          |
|------------------------------|---------------------|-------------------------|---------------------------------------------|
| PathwayProgressStarted       | PathwayProgress     | EC-09/17/analytics      | progress id, pathway ref/hash, occurredAt   |
| TrajectoryFactAccepted       | LearningTrajectory  | Projection/analytics    | fact id/type/source key, no raw PII         |
| TrajectoryFactQuarantined    | LearningTrajectory  | Ops                     | fact ref + reason                           |
| NodeProgressChanged          | PathwayProgress     | UI projection/analytics | node ref, old/new state, snapshot ref       |
| PathwayProgressChanged       | PathwayProgress     | Consumers               | percent/state/dependency + snapshot         |
| PathwayCompleted             | PathwayProgress     | EC-08/analytics         | progress/snapshot/pathway                   |
| RecognitionClaimSubmitted    | RecognitionClaim    | CT-06                   | claim ref, target, workflow correlation     |
| RecognitionClaimAccepted     | RecognitionClaim    | Projection/analytics    | decision hash, resulting fact ref           |
| RecognitionClaimRejected     | RecognitionClaim    | Notification/analytics  | reason code, no sensitive evidence          |
| ManualOverrideApplied        | PathwayProgress     | Audit/analytics         | override ref/kind/reason                    |
| MigrationSimulated           | MigrationCase       | Review UI               | diff/simulation hashes                      |
| MigrationApproved            | MigrationCase       | Ops                     | case ref, approval receipt                  |
| MigrationApplied             | MigrationCase       | Analytics               | source/target progress refs + receipt count |
| CumulativeEligibilityGranted | EligibilityDecision | EC-08                   | decision/snapshot/blueprint refs            |
| CumulativeEligibilityRevoked | EligibilityDecision | EC-08                   | decision ref + reason                       |
| CredentialIssuanceRequested  | EligibilityDecision | EC-08                   | stable command/correlation                  |
| CredentialIssuanceUnknown    | EligibilityDecision | Ops                     | operation ref/correlation                   |
| ProgressRebuildCompleted     | PathwayProgress     | Ops                     | old/new hash, diff flag                     |
| TrajectorySuspended          | LearningTrajectory  | Consumers               | trajectory ref + reason                     |
| SnapshotSuperseded           | PathwayProgress     | Analytics               | old/new snapshot refs                       |

## 

```
eventId: UUID
schemaVersion: integer
occurredAt: RFC3339 UTC
tenantId: resolved scope
aggregateType / aggregateId
correlationId / causationId
traceParent: optional W3C
payload: versioned contract
PII classification: explicit metadata, payload minimized
```

Toda publicación se origina en outbox transaccional. Consumidores mantienen inbox dedup por consumer_code + event_id y verifican payload_hash en replays. La semántica es at-least-once; ninguna sección promete exactly-once distribuido.

# 

| **Dependencia**   | **Contrato**                 | **Timeout objetivo** | **Retry**                                | **Fallback/degradación**                              | **Reconciliation**                            |
|-------------------|------------------------------|----------------------|------------------------------------------|-------------------------------------------------------|-----------------------------------------------|
| EC-01 Pathway     | Resolve exact version/hash   | 2 s                  | Solo retry de GET idempotente con jitter | Circuit breaker; no latest fallback                   | STALE/UNAVAILABLE; fail closed en mutation    |
| EC-07 Completion  | Event subscription           | async                | Broker retry + DLQ/inbox                 | Quarantine payload inválido                           | Reconcile by source event/fact key            |
| EC-08 Awards      | Events + issuance command    | 3–5 s command        | GET retry safe; command no blind retry   | UNKNOWN_EFFECT                                        | Query by correlation/decision id before retry |
| CT-05 Evidence    | Metadata/verification        | 2 s                  | GET retry bounded                        | PARTIAL, no accept if required                        | Re-resolve evidence hash/status               |
| CT-06 Workflow    | Create/read approval         | 3 s                  | Create idempotent                        | PENDING/UNKNOWN_EFFECT                                | Reconcile workflow ref                        |
| CT-12 AI          | Recommendation               | 10–30 s async        | Async op                                 | Feature unavailable; deterministic workflow continues | No business rollback                          |
| CT-15 Eligibility | Policy decision if delegated | 2 s                  | GET/evaluate idempotent                  | UNAVAILABLE not favorable                             | Re-evaluate when dependency recovers          |
| CT-16 Migration   | Promote contract             | batch async          | Checkpointed                             | Dry-run/pause                                         | Receipts and reconciliation                   |

## 

```
send(command, stableIdempotencyKey, correlationId)
-> remote timeout / connection reset after send
-> persist AsyncOperation(state=UNKNOWN_EFFECT)
-> persist recognition_receipt + audit + outbox
-> DO NOT blind retry
-> reconcile by remote query(correlationId | decisionId | idempotencyKey)
-> applied: confirm local reference/status
-> provably not applied: safe retry same key
-> still unknown: keep UNKNOWN_EFFECT + alert/escalate
```

# 

Frontend es herramienta de explicación y decisión, no CRUD. React/TypeScript usa client y DTOs generados desde OpenAPI, TanStack Query o baseline BOM equivalente, query keys tenant/scope-aware y mutations con ETag. Cada workspace diferencia NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT y nunca “maquilla” una dependencia fallida como cero progreso.

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Portfolio operacional de trayectorias activas y riesgos                                                        |
| Actores             | Advisor / Academic Ops                                                                                         |
| Route               | /ec/trajectory                                                                                                 |
| Layout/componentes  | Shell lateral; KPI strip; filtros; grid; drawer                                                                |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | active/completed/stale/blocked/unknown                                                                         |
| Filtros             | scope, pathway, state, asOf, dependency                                                                        |
| Grid/columns        | person display permitted, pathway, %, blockers, freshness                                                      |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Open trajectory, rebuild batch, suspend governed                                                               |
| Permisos            | VIEW/OPS + ABAC scope/purpose; step-up/SoD donde aplique.                                                      |
| Query keys          | \[ec10,trajectories,tenant,scope,filters\]                                                                     |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Vista longitudinal de una persona                                                                              |
| Actores             | Participant / Advisor                                                                                          |
| Route               | /ec/trajectory/:trajectoryId                                                                                   |
| Layout/componentes  | Header identity snapshot; tabs Paths · Facts · Claims · History; side explanation                              |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | paths, credentials refs, pending claims                                                                        |
| Filtros             | pathway/state/asOf                                                                                             |
| Grid/columns        | pathway name, version pin, progress, next action                                                               |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Start path, create claim, export own record                                                                    |
| Permisos            | SELF/VIEW + ABAC scope/purpose; step-up/SoD donde aplique.                                                     |
| Query keys          | \[ec10,trajectory,id,asOf\]                                                                                    |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Explicar avance nodo por nodo                                                                                  |
| Actores             | Participant / Advisor / Reviewer                                                                               |
| Route               | /ec/progress/:id                                                                                               |
| Layout/componentes  | Header ETag/freshness; graph + accessible table; detail drawer                                                 |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | progress %, satisfied/blocked/expired                                                                          |
| Filtros             | state, module, requirement type                                                                                |
| Grid/columns        | node, status, evidence basis, expiry, blockers                                                                 |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Recalculate, explain, create claim                                                                             |
| Permisos            | VIEW/RECALC + ABAC scope/purpose; step-up/SoD donde aplique.                                                   |
| Query keys          | \[ec10,progress,id,snapshot\]                                                                                  |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Crear y gestionar claims                                                                                       |
| Actores             | Participant / Advisor                                                                                          |
| Route               | /ec/recognition/claims                                                                                         |
| Layout/componentes  | Queue + detail drawer + evidence panel                                                                         |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | draft/submitted/needs-info                                                                                     |
| Filtros             | state,type,target,age                                                                                          |
| Grid/columns        | claim, target, evidence status, workflow                                                                       |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Create, attach ref, submit, withdraw                                                                           |
| Permisos            | CLAIM_CREATE + ABAC scope/purpose; step-up/SoD donde aplique.                                                  |
| Query keys          | \[ec10,claims,filters\]                                                                                        |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Decidir reconocimiento con evidencia/policy                                                                    |
| Actores             | Reviewer / Approver                                                                                            |
| Route               | /ec/recognition/review                                                                                         |
| Layout/componentes  | Work queue; comparison panel; policy snapshot; evidence drawer                                                 |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | SLA, pending, partial                                                                                          |
| Filtros             | state, trust profile, target                                                                                   |
| Grid/columns        | claim, applicant alias, evidence, mapping, reason                                                              |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Verify, accept, partial, reject                                                                                |
| Permisos            | CLAIM_DECIDE + SoD + ABAC scope/purpose; step-up/SoD donde aplique.                                            |
| Query keys          | \[ec10,review,queue,filters\]                                                                                  |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Simular/migrar entre versiones sin perder historia                                                             |
| Actores             | Advisor / Approver                                                                                             |
| Route               | /ec/migrations/:id                                                                                             |
| Layout/componentes  | Source/target diff; mapping canvas + table; simulation panel                                                   |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | mapped/new/dropped/risk                                                                                        |
| Filtros             | mapping kind, confidence                                                                                       |
| Grid/columns        | source node, target node, basis, carry-forward                                                                 |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Simulate, edit mapping, submit, approve, apply                                                                 |
| Permisos            | MIGRATE + step-up + ABAC scope/purpose; step-up/SoD donde aplique.                                             |
| Query keys          | \[ec10,migration,id,revision\]                                                                                 |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Evaluar stacking y coordinar emisión EC-08                                                                     |
| Actores             | Credential Ops                                                                                                 |
| Route               | /ec/eligibility                                                                                                |
| Layout/componentes  | Decision queue; snapshot inspector; issuance status                                                            |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | eligible/not eligible/unknown issuance                                                                         |
| Filtros             | blueprint,state,pathway                                                                                        |
| Grid/columns        | decision, snapshot, policy, award ref, operation                                                               |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Evaluate, request issuance, reconcile                                                                          |
| Permisos            | CREDENTIAL_OPS + ABAC scope/purpose; step-up/SoD donde aplique.                                                |
| Query keys          | \[ec10,eligibility,filters\]                                                                                   |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Resolver UNKNOWN_EFFECT, inbox/outbox y rebuild drift                                                          |
| Actores             | SRE / Ops                                                                                                      |
| Route               | /ec/reconciliation                                                                                             |
| Layout/componentes  | Operational queue; correlation timeline; receipts                                                              |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | unknown, dead outbox, quarantine, hash drift                                                                   |
| Filtros             | type, age, dependency, tenant                                                                                  |
| Grid/columns        | operation, subject, correlation, attempts                                                                      |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Reconcile, safe retry, escalate                                                                                |
| Permisos            | OPS_RECONCILE + ABAC scope/purpose; step-up/SoD donde aplique.                                                 |
| Query keys          | \[ec10,reconcile,filters\]                                                                                     |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Mostrar agregados autorizados sin PII                                                                          |
| Actores             | Corporate Sponsor via EC-09                                                                                    |
| Route               | /ec/corporate/progress                                                                                         |
| Layout/componentes  | KPI cards; cohort trend; suppression notices                                                                   |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | cohort count, aggregate progress/completion                                                                    |
| Filtros             | engagement, cohort, period                                                                                     |
| Grid/columns        | only permitted aggregate fields                                                                                |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Export authorized aggregate                                                                                    |
| Permisos            | CORP_REPORT + ABAC scope/purpose; step-up/SoD donde aplique.                                                   |
| Query keys          | \[ec10,corporate,profile,cohort\]                                                                              |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Reconstruir decisiones y lineage                                                                               |
| Actores             | Auditor                                                                                                        |
| Route               | /ec/audit/trajectory                                                                                           |
| Layout/componentes  | Timeline; hash/receipt explorer; event correlation                                                             |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | receipts, policy versions, as-of reconstruction                                                                |
| Filtros             | subject,event type,period                                                                                      |
| Grid/columns        | actor ref, reason, hashes, refs                                                                                |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Export evidence pack                                                                                           |
| Permisos            | AUDIT_READ + ABAC scope/purpose; step-up/SoD donde aplique.                                                    |
| Query keys          | \[ec10,audit,subject,period\]                                                                                  |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Aspecto**         | **Especificación**                                                                                             |
|---------------------|----------------------------------------------------------------------------------------------------------------|
| Objetivo            | Diagnosticar refs, hashes, versions y dependency state                                                         |
| Actores             | Ops / Architect                                                                                                |
| Route               | /ec/diagnostics                                                                                                |
| Layout/componentes  | Dependency cards; contract versions; drift results                                                             |
| Navegación          | Breadcrumb + tenant/scope chip + freshness + back-to-workspace; deep links conservan filters/asOf.             |
| KPIs                | availability, stale refs, contract errors                                                                      |
| Filtros             | dependency, tenant, schema                                                                                     |
| Grid/columns        | ref, expected hash, observed status                                                                            |
| Drawers/modals/tabs | Detail/evidence/explanation/conflict drawers; confirm modal solo para acción irreversible; tabs con URL state. |
| Commands            | Refresh metadata, run contract check                                                                           |
| Permisos            | OPS_DIAG + ABAC scope/purpose; step-up/SoD donde aplique.                                                      |
| Query keys          | \[ec10,diag,tenant\]                                                                                           |
| OpenAPI client      | Cliente/DTO generado; prohibido fetch/axios ad-hoc dentro del feature.                                         |
| Mutations           | If-Match para aggregate, Idempotency-Key para intento lógico, correlationId visible en error.                  |
| ETag / conflicto    | 412 abre Conflict Drawer con current/server etag, diff y opciones Reload/Reapply; sin auto-retry.              |
| Estados de datos    | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE, UNKNOWN_EFFECT son representaciones distintas con asOf/provenance. |
| Loading / error     | Skeleton contextual; ProblemDetail muestra reasonCode + correlationId + remediation segura.                    |
| Accesibilidad       | WCAG 2.2 AA baseline; keyboard/focus; graph siempre tiene alternativa tabular; no color-only.                  |
| Responsive          | Desktop multi-panel; tablet drawers; mobile web lectura/review ligera; authoring complejo redirige a desktop.  |
| Tests               | Component + contract fixtures OpenAPI + MSW + E2E del journey crítico + a11y keyboard/focus.                   |

## 

| **Capa**     | **Baseline**                        | **Regla**                                    |
|--------------|-------------------------------------|----------------------------------------------|
| Type system  | TypeScript strict                   | DTO generated; no duplicated interfaces.     |
| HTTP client  | Generated OpenAPI client            | Correlation/ProblemDetail/ETag centralized.  |
| Server state | TanStack Query baseline BOM         | Keys include tenant/scope/filter/asOf.       |
| Forms        | React Hook Form + schema validation | UX only; backend/DB remain authoritative.    |
| State model  | Explicit dependency/data states     | No boolean loading/error oversimplification. |
| Telemetry    | Web-vitals + business UX telemetry  | No PII in analytics payloads.                |
| Security     | Route + command capability checks   | UI hiding is not authorization.              |

# 

Mobile prioriza autoservicio y acciones breves. No replica Migration Studio ni administración de overrides complejos. React Native consume el mismo OpenAPI client generado cuando técnicamente sea viable o un package derivado del mismo schema; secure storage conserva tokens y drafts mínimos, nunca evidence blobs sensibles sin política explícita.

| **Journey**             | **Actor**            | **Contenido**                                       | **Acciones**                           | **Restricción**                                                 |
|-------------------------|----------------------|-----------------------------------------------------|----------------------------------------|-----------------------------------------------------------------|
| My Learning Journey     | Participante         | Resumen de rutas, progreso, next actions, freshness | Read; deep link                        | Offline muestra STALE/asOf, nunca current falso.                |
| Pathway Detail          | Participante         | Nodos, requisitos, bloqueos, explicación            | Read/explain                           | Graph se representa como lista accesible.                       |
| Recognition Claim       | Participante         | Draft, evidence metadata, status                    | Create draft/submit                    | Draft local cifrado; upload/document handling delegado a CT-05. |
| Achievement Wallet Link | Participante         | Award refs de EC-08                                 | Open EC-08 wallet                      | EC-10 no renderiza credencial como autoridad.                   |
| Notifications           | Participante/Advisor | Changes/needs action                                | Deep links                             | CT-07 controls channels/consent.                                |
| Reviewer Quick Action   | Reviewer             | Claim summary + verified evidence refs              | Approve/reject solo si policy habilita | Biometric/MFA step-up; SoD; no complex partial mapping.         |
| Operation Status        | Ops autorizado       | UNKNOWN_EFFECT/rebuild status                       | Acknowledge/escalate                   | No blind retry button.                                          |

# 

| **Capacidad**        | **Backend**             | **Web**                  | **Mobile**               | **Regla**                  |
|----------------------|-------------------------|--------------------------|--------------------------|----------------------------|
| Start pathway        | Command + pin/hash      | Advisor/participant flow | Opcional                 | Idempotent create.         |
| Progress read        | Query + snapshots       | Full explorer            | Summary/list             | Same semantic DTO.         |
| Recognition claim    | Aggregate/commands      | Full create/review       | Create/self-service      | Review complex mostly Web. |
| Migration            | Case/simulation/apply   | Full studio              | No                       | Critical admin desktop.    |
| Eligibility/issuance | Decision + EC-08 effect | Credential Ops           | Read status only         | UNKNOWN_EFFECT explicit.   |
| Audit                | Receipts/lineage        | Full evidence desk       | Limited own history      | Purpose/field privacy.     |
| Corporate aggregate  | Suppressed query        | Sponsor/ops              | Optional executive cards | EC-09 profile controls.    |
| Reconciliation       | Ops commands            | Full center              | Status/escalate only     | No blind retry.            |

# 

## 

- RBAC define capacidades base; ABAC restringe tenant, campus/scope, relationship, purpose, claim ownership y sensitivity.

- SoD separa submitter/verifier/approver cuando policy lo exija; el mismo actor no aprueba su excepción crítica.

- Step-up obligatorio para override terminal, approve/apply migration, export sensible y decisiones de alto impacto según CT-14.

- Tenant scope se resuelve del token/contexto; tenant_id no es parámetro de negocio editable.

- Purpose limitation y field-level privacy filtran PII, evidence metadata y corporate aggregation.

- Service-to-service usa audience/scope restringido, mTLS o baseline institucional, rotation y short-lived credentials.

## 

| **Amenaza**          | **Escenario**                                 | **Mitigación**                                                         |
|----------------------|-----------------------------------------------|------------------------------------------------------------------------|
| IDOR/cross-tenant    | Cambiar UUID para leer/progresar otra persona | RLS FORCE + object authorization + opaque 404 policy + tests negativos |
| Privilege escalation | Advisor intenta override/apply migration      | RBAC+ABAC+SoD+step-up server-side                                      |
| Replay               | Repetir command/event                         | Idempotency + inbox dedup + request/payload hash                       |
| Tampering            | Alterar evidence/hash/snapshot                | Append-only + canonical hashes + CT-05 refs                            |
| Mass assignment      | Enviar state/revision/tenant en JSON          | Intent DTO allowlist; server-owned fields ignored/rejected             |
| Race conditions      | Dos approvals/rebuilds simultáneos            | If-Match + row locks + unique constraints                              |
| ETag bypass          | Client omite If-Match                         | 428/412 policy en commands mutables                                    |
| Injection            | Filters/sort/JSON queries                     | Parameterized SQL + sort allowlist + schema validation                 |
| SSRF                 | Evidence URL arbitraria                       | No fetch de URL libre; CT-05/allowlisted adapters                      |
| Secret exposure      | Tokens en logs/errors                         | Redaction + vault + secret scan                                        |
| Webhook spoofing     | Evento externo falso                          | Gateway auth/signature + inbox + source allowlist                      |
| Resource exhaustion  | Rebuild/graph payload gigante                 | Limits + async jobs + quotas + circuit breaker                         |
| Data leakage         | Sponsor recibe notas individuales             | EC-09 ReportingProfile + minimum cohort + suppression                  |
| Insecure export      | Bulk export fuera de purpose                  | Permission + purpose + step-up + audit + short-lived download          |
| AI leakage           | PII/evidence enviado al modelo                | CT-12 policy, minimization, approved model/data handling               |

## 

| **Control**            | **Evidencia de gate**                                         |
|------------------------|---------------------------------------------------------------|
| SAST                   | 0 blocker/critical sin waiver firmado.                        |
| SCA                    | Dependencias vulnerables según policy; SBOM generado.         |
| Secret scan            | Repo/history sin secretos activos.                            |
| Container scan         | Imagen base/aplicación dentro de policy.                      |
| IaC/K8s scan           | No privileged/broad service account; network policy validada. |
| DAST/API security      | Authz/IDOR/rate/validation tests.                             |
| RLS regression         | Cross-tenant SELECT/INSERT/UPDATE/DELETE negativos.           |
| Contract compatibility | OpenAPI/AsyncAPI N/N-1 compatible.                            |
| Threat review          | Modelo actualizado con findings cerrados/aceptados.           |

# 

La auditoría debe permitir contestar quién, qué, cuándo, bajo qué tenant/scope, con qué policy, sobre qué facts/snapshot y con qué resultado. Para PII sensible se prefieren hashes y refs a duplicar contenido. Receipts locales de decisiones críticas son append-only.

| **Acción**       | **Evidencia mínima**                                    | **Lineage**                       |
|------------------|---------------------------------------------------------|-----------------------------------|
| Start pathway    | actor, path ref/version/hash, request hash, receipt     | trajectory → progress             |
| Fact ingestion   | source key/event, provenance hash, outcome              | source event → fact               |
| Claim decision   | evidence refs/hashes, verifier/approver, policy, reason | claim → fact → contribution       |
| Override         | workflow/evidence/actor/reason/receipt hash             | override → node/progress          |
| Migration apply  | source snapshot, target hash, mappings, carry receipts  | source progress → target progress |
| Eligibility      | snapshot/policy/decision hash                           | facts → snapshot → decision       |
| Issuance request | decision, key, correlation, remote status               | decision → EC-08 award/ref        |
| Export           | purpose, filter, subject/scope, actor, artifact ref     | query → export evidence           |

| **LINEAGE CANÓNICO —** source event → TrajectoryFact → FactContribution → NodeProgress → ProgressSnapshot → CumulativeEligibilityDecision → EC-08 issuance/award. Cada salto debe ser consultable por ID/ref y soportado por hash/receipt. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

| **Métrica**                       | **Tipo**  | **Labels permitidos**            | **Uso**                |
|-----------------------------------|-----------|----------------------------------|------------------------|
| ec10_progress_query_latency_ms    | Histogram | tenant class/route, no person id | UX/performance         |
| ec10_recalc_duration_ms           | Histogram | engine version                   | Capacity               |
| ec10_fact_ingest_total            | Counter   | source/type/result               | Integration health     |
| ec10_unknown_effect_current       | Gauge     | dependency/operation type        | Operational risk       |
| ec10_outbox_lag_seconds           | Gauge     | event type                       | Event delivery         |
| ec10_idempotency_recovery_total   | Counter   | command scope                    | Crash recovery         |
| ec10_rls_denied_total             | Counter   | db role/action                   | Security               |
| ec10_progress_dependency_state    | Gauge     | state                            | Freshness              |
| ec10_claim_cycle_time_seconds     | Histogram | claim type                       | Process KPI            |
| ec10_migration_case_age_seconds   | Histogram | state                            | Process KPI            |
| ec10_rebuild_hash_diff_total      | Counter   | engine version                   | Determinism regression |
| ec10_eligibility_transition_total | Counter   | from/to/reason                   | Business flow          |

## 

| **SLI**                     | **SLO inicial**                            | **Medición / acción**                           |
|-----------------------------|--------------------------------------------|-------------------------------------------------|
| Progress query availability | 99.9% mensual                              | 5xx/timeout excluding planned; alert burn rate. |
| Progress summary p95        | \< 500 ms cache warm / bounded dataset     | Route histogram; investigate \> budget.         |
| Fact propagation            | 99% facts válidos reflejados \< 60 s       | event occurred/received → snapshot time.        |
| Outbox lag                  | 99% \< 120 s                               | oldest PENDING/IN_FLIGHT age.                   |
| UNKNOWN_EFFECT resolution   | 95% \< 15 min en dependencias conciliables | operation unknown → terminal.                   |
| Tenant isolation            | 0 confirmed violations                     | security event; immediate incident.             |
| Rebuild determinism         | 100% same-input same-result hash           | nightly sample / release test.                  |

## 

- Structured logs: correlationId, tenant opaque id, aggregate type/id, command/event type, reasonCode; sin payloads de evidencia/PII.

- W3C trace context cruza REST, event consumers, outbox dispatcher y remote adapters.

- Span attributes no incluyen person name/email; refs opacas cuando son imprescindibles.

- Alertas por UNKNOWN_EFFECT aging, outbox dead, inbox quarantine, hash drift, RLS denials y rebuild backlog.

# 

Toda IA pasa por CT-12. EC-10 no contiene API keys ni SDK directo a proveedor. La IA puede mejorar explicabilidad y productividad, pero su salida es Recommendation con provenance; no cambia facts, state terminal ni elegibilidad por sí sola.

| **Use case**                 | **Puede hacer**                                | **Grounding mínimo**                   | **Guardrail**                       |
|------------------------------|------------------------------------------------|----------------------------------------|-------------------------------------|
| Explain progress             | Resumir por qué un nodo está SATISFIED/BLOCKED | Facts/snapshot/pathway refs            | Usuario valida; no cambia estado.   |
| Migration mapping suggestion | Proponer source→target mappings                | Diff/outcomes/competency refs          | Reviewer acepta/edita/rechaza.      |
| Claim classification         | Clasificar tipo y faltantes de evidence        | Metadata/evidence extracts autorizados | No verifica autenticidad ni decide. |
| Anomaly detection            | Detectar contradicciones/revocations faltantes | Derived features                       | Ops investiga.                      |
| Next action suggestion       | Priorizar próximos nodos                       | Current progress + rules               | Informativo; nunca enrollment.      |
| Audit summary                | Sintetizar evidence pack                       | Receipts/refs                          | Auditor conserva acceso a fuente.   |

## 

- run_ref

- model_ref/provider policy ref

- prompt_template_ref + version

- eval_ref

- grounding_refs + hashes

- confidence/calibration cuando aplique

- reviewer_ref

- human_outcome = APPLIED/EDITED/REJECTED

- purpose/retention/data classification

# 

| **KPI**                           | **Definición**                                | **Dimensiones**          | **Cautela**                                |
|-----------------------------------|-----------------------------------------------|--------------------------|--------------------------------------------|
| Trajectory activation rate        | activated pathways / eligible starts          | Tenant/scope/pathway     | No identifica persona en BI estándar.      |
| Median time to first progress     | start → first satisfied node                  | Pathway/cohort           | Detecta fricción.                          |
| Completion velocity               | nodes satisfied / active month                | Pathway                  | Comparación version-aware.                 |
| Blocked path rate                 | paths with blocking_count\>0 / active         | Reason group             | No imputar zero si dependency unavailable. |
| Recognition claim cycle time      | submitted → terminal                          | Claim type/trust profile | Proceso, no performance individual.        |
| Recognition acceptance rate       | accepted/partial/rejected                     | Claim type               | Interpretar con policy/version.            |
| Migration carry-forward ratio     | carried valid contributions / eligible source | Source→target versions   | Detecta impacto de rediseño.               |
| Credential eligibility conversion | eligible → confirmed award                    | Blueprint                | EC-08 confirmation only.                   |
| Stale progress ratio              | STALE/PARTIAL paths / active                  | Dependency               | Operability.                               |
| Unknown effect age                | time in UNKNOWN_EFFECT                        | Dependency/type          | Resilience.                                |
| Rebuild drift rate                | hash diffs / sampled rebuilds                 | Engine version           | Determinism quality.                       |
| Corporate aggregate progress      | authorized cohort aggregate                   | EC-09 profile            | Minimum cohort/suppression mandatory.      |

# 

Toda migración usa CT-16: Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → Receipt → Reconcile → Certify. Está prohibido insertar datos legacy directamente en tablas finales EC-10 porque se saltarían invariantes, audit, idempotency, outbox y state machines.

| **DQ rule**                                 | **Severidad**                 | **Tratamiento**                              |
|---------------------------------------------|-------------------------------|----------------------------------------------|
| Person ref no resoluble                     | BLOCKER                       | No promote; queue mapping CT-04.             |
| Duplicate source_fact_key same payload      | INFO                          | Idempotent replay; no duplicate.             |
| Duplicate source_fact_key different payload | BLOCKER                       | Conflict/quarantine.                         |
| occurred_at imposible/futuro injustificado  | ERROR                         | Normalize with evidence or reject.           |
| Curso legacy sin mapping a pathway node     | WARN/ERROR policy             | Recognition/mapping review; no auto-satisfy. |
| Issuer externo no confiable                 | BLOCKER                       | Claim requires trust verification.           |
| Award duplicado                             | ERROR                         | Dedup by registry/source key.                |
| PathwayVersion desconocida                  | BLOCKER                       | Resolve exact historical version; no latest. |
| Pathway content hash mismatch               | BLOCKER                       | Stop; governance investigation.              |
| Missing policy version                      | BLOCKER for terminal decision | Cannot certify reproducible decision.        |

## 

- legacy_source_system

- legacy_record_key

- extract_batch_id

- normalized_record_hash

- mapping_rule_version

- dry_run_result_ref

- promote_command_id/idempotency_key

- created domain refs

- reconciliation_receipt_ref

- certification evidence ref

# 

| **Nivel**         | **Cobertura**                                                       | **Evidencia**                                              |
|-------------------|---------------------------------------------------------------------|------------------------------------------------------------|
| Unit Domain       | State machines, policies, match/evaluate, expiry, migration mapping | Junit 5/property tests; deterministic clock.               |
| DB/Testcontainers | DDL, constraints, triggers, RLS                                     | PostgreSQL real; positive/negative tenant cases.           |
| Contract          | OpenAPI/AsyncAPI                                                    | Provider/consumer compatibility N/N-1.                     |
| Integration       | EC-01/07/08/CT-05/06/12/16 adapters                                 | WireMock/stubs + timeout/reset/duplicate events.           |
| Concurrency       | ETag, row locks, idempotency lease                                  | Parallel tests; exactly one semantic effect.               |
| Web E2E           | Critical workspaces                                                 | Playwright; conflict, stale, unknown, a11y.                |
| Mobile            | Offline/sync/deep-link/secure storage                               | Device tests; stale semantics.                             |
| Security          | IDOR/RLS/SoD/step-up/mass assignment/export                         | Automated + manual threat-based tests.                     |
| Performance       | Query, ingest, rebuild batch                                        | Representative tenant sizes; budgets from SLO.             |
| Migration         | Dry-run/promote/reconcile                                           | Golden legacy fixtures + lineage verification.             |
| Determinism       | Rebuild same-input                                                  | Hash equality across repeated executions/builds.           |
| Resilience        | Outbox/inbox/UNKNOWN_EFFECT                                         | Kill pods, broker unavailable, remote applied-but-timeout. |

## 

- Tenant A no SELECT de IDs Tenant B aun con UUID conocido.

- Tenant A no UPDATE/DELETE/INSERT child referenciando parent Tenant B.

- RLS también aplica a workers con contexto tenant explícito; jobs cross-tenant iteran tenant por tenant con role controlado.

- Runtime role no puede SET role a migrator ni desactivar RLS.

- Connection pool no filtra previous tenant context entre transacciones.

# 

Los Golden Scenarios son criterios ejecutables de aceptación. Cada uno exige evidencia objetiva: test automatizado, query DB, receipt, trace, screenshot E2E o artifact del Engineering Pack. Se enumeran escenarios diferentes; no son variaciones cosméticas de un mismo caso.

| **GS**      | **Escenario**                           | **Precondición**                                 | **Acción**                                          | **Resultado esperado**                                  | **Evidencia**                        |
|-------------|-----------------------------------------|--------------------------------------------------|-----------------------------------------------------|---------------------------------------------------------|--------------------------------------|
| GS-EC10-001 | Crear trayectoria válida                | Tenant y person_ref autorizados                  | POST trajectory con key nueva                       | 201; tenant/context server-side; revision 0             | API contract + DB row + audit        |
| GS-EC10-002 | Replay de creación                      | Mismo request/key ya completado                  | Repetir POST                                        | Mismo resultado lógico; no segunda fila                 | Idempotency row + count=1            |
| GS-EC10-003 | Iniciar ruta pinneada                   | PathwayVersion EC-01 AVAILABLE                   | POST pathway start                                  | DRAFT con ref/version/hash exactos                      | Progress row + EC-01 receipt         |
| GS-EC10-004 | Activar progreso                        | Progress DRAFT y ETag actual                     | Command activate                                    | ACTIVE; started_at; new ETag                            | Audit + outbox event                 |
| GS-EC10-005 | Completion satisface nodo               | Completion EC-07 válido                          | Procesar evento                                     | Fact + contribution + node SATISFIED + snapshot         | Inbox/fact/snapshot hashes           |
| GS-EC10-006 | Completion parcial                      | Policy permite peso parcial                      | Procesar fact parcial                               | Node IN_PROGRESS con peso exacto                        | Contribution + snapshot              |
| GS-EC10-007 | Prerequisito bloquea                    | Node target requiere otro no satisfecho          | Recalcular                                          | BLOCKED con blocking_node_ref                           | Node projection + reason             |
| GS-EC10-008 | Satisfacer prerequisito desbloquea      | Blocking node luego satisfecho                   | Procesar nuevo fact                                 | Target reevalúa a estado permitido                      | Two snapshots diff                   |
| GS-EC10-009 | Ruta completada                         | Todos requisitos terminales válidos              | Recalcular                                          | PathwayProgress COMPLETED sin emitir award              | Progress + snapshot + no local award |
| GS-EC10-010 | Next actions explicables                | Progress ACTIVE con faltantes                    | GET next-actions                                    | Orden/prioridad con reason/provenance                   | Response fixture                     |
| GS-EC10-011 | SELECT cross-tenant bloqueado           | Row Tenant B, session Tenant A                   | SELECT por UUID conocido                            | 0 rows / access policy; no leakage                      | RLS negative test                    |
| GS-EC10-012 | UPDATE cross-tenant bloqueado           | Row Tenant B, session Tenant A                   | UPDATE por UUID                                     | 0 affected / denied                                     | RLS negative test                    |
| GS-EC10-013 | INSERT child cross-tenant bloqueado     | Parent B, session A                              | Insert contribution con parent B                    | FK/RLS impide                                           | DB integration test                  |
| GS-EC10-014 | Tenant body ignorado/rechazado          | Token A y JSON con tenant B                      | POST command                                        | No opera B; validation/security error                   | API security test                    |
| GS-EC10-015 | IDOR claim detail                       | Claim de otra persona/scope                      | GET claim UUID                                      | 404/403 según policy sin revelar existencia             | DAST/E2E                             |
| GS-EC10-016 | SoD claim                               | Submitter intenta aprobar su claim               | POST accept                                         | 403 EC10_SOD_VIOLATION                                  | Audit denied action                  |
| GS-EC10-017 | Step-up override                        | Override crítico sin step-up                     | POST override                                       | 403/step-up required; no row                            | Security test                        |
| GS-EC10-018 | Mass assignment state                   | Client envía state=ACCEPTED en create claim      | POST create                                         | Field rejected/ignored; state DRAFT                     | Contract test                        |
| GS-EC10-019 | Export sin purpose                      | Usuario con view pero sin export purpose         | POST export                                         | 403/422; no artifact                                    | Audit + auth test                    |
| GS-EC10-020 | Runtime intenta BYPASSRLS               | Runtime DB user                                  | SET row_security off / inspect privilege            | No BYPASSRLS/ownership                                  | DB role audit                        |
| GS-EC10-021 | ETag correcto                           | Revision 4                                       | Mutación If-Match 4                                 | Commit y ETag 5                                         | Concurrency test                     |
| GS-EC10-022 | ETag stale                              | Server revision 5                                | Mutación If-Match 4                                 | 412; cero cambios                                       | DB diff + ProblemDetail              |
| GS-EC10-023 | Dos approvals simultáneos               | Claim IN_REVIEW rev 8                            | Dos accept concurrentes                             | Uno gana; otro 412/409; un solo fact                    | Parallel test + count                |
| GS-EC10-024 | Same key same payload                   | Command completado                               | Replay                                              | Response replay; no side effect                         | Idempotency snapshot                 |
| GS-EC10-025 | Same key different payload              | Key existente hash A                             | Request hash B                                      | 409 IDEMPOTENCY_KEY_REUSED                              | ProblemDetail                        |
| GS-EC10-026 | Crash durante idempotency               | IN_PROGRESS lease owner muerto                   | Esperar expiry y worker recover                     | Nuevo owner recupera; attempt++                         | Lease row + logs                     |
| GS-EC10-027 | Outbox doble pod                        | Dos dispatchers                                  | Claim batch simultáneo                              | Cada event primary-claimed una vez                      | SKIP LOCKED test                     |
| GS-EC10-028 | Outbox pod muere                        | IN_FLIGHT lease vence                            | Recovery loop                                       | Event reclaim seguro                                    | Lease history metrics                |
| GS-EC10-029 | Duplicate inbox event                   | Event ya PROCESSED                               | Recibir de nuevo mismo hash                         | No segundo fact                                         | Inbox PK + count                     |
| GS-EC10-030 | Duplicate inbox payload mismatch        | Mismo event_id distinto hash                     | Recibir replay alterado                             | Quarantine/security alert                               | Inbox diagnostics                    |
| GS-EC10-031 | Fact key duplicate same payload         | Fact existente                                   | Ingest same key/hash                                | Idempotent replay                                       | Fact count                           |
| GS-EC10-032 | Fact key duplicate diff payload         | Fact key existente                               | Ingest different provenance                         | 409/quarantine; no overwrite                            | Audit + fact immutable               |
| GS-EC10-033 | Occurred/received preserved             | Delayed event                                    | Ingest                                              | Both timestamps preserved                               | DB assertion                         |
| GS-EC10-034 | Future occurred invalid                 | Event unreasonable future timestamp              | Ingest                                              | Reject/quarantine per tolerance policy                  | Reason code                          |
| GS-EC10-035 | Fact validity window                    | valid_from \< valid_until                        | Ingest/recalc                                       | Contribution applies only inside window                 | As-of tests                          |
| GS-EC10-036 | Fact expired                            | Clock past valid_until                           | Recalc                                              | Node EXPIRED if no alternate contribution               | Snapshot diff                        |
| GS-EC10-037 | Compensating fact                       | Source correction arrives                        | Ingest compensation                                 | Old fact remains; new effect supersedes                 | Ledger lineage                       |
| GS-EC10-038 | Event schema N-1                        | Old compatible event version                     | Consume                                             | Accepted through adapter                                | Contract compatibility               |
| GS-EC10-039 | Unknown event schema                    | Future incompatible version                      | Consume                                             | Quarantine; no semantic effect                          | Inbox status + alert                 |
| GS-EC10-040 | Out-of-order events                     | Revocation arrives before award then award later | Consume both                                        | Deterministic final state per occurred/provenance rules | Rebuild hash stable                  |
| GS-EC10-041 | Award fact satisfies node               | Verified EC-08 award event                       | Process                                             | Node SATISFIED                                          | Fact→contribution lineage            |
| GS-EC10-042 | Award revoked                           | Revocation event for used award                  | Process                                             | Node REVOKED/reevaluated; prior snapshots unchanged     | New snapshot + old unchanged         |
| GS-EC10-043 | Alternative fact preserves satisfaction | Two facts satisfy same node                      | Revoke one                                          | Node remains SATISFIED if policy allows other           | Contribution evaluation              |
| GS-EC10-044 | All valid facts revoked                 | Only satisfying facts revoked                    | Recalc                                              | Node REVOKED/NOT satisfied                              | Snapshot                             |
| GS-EC10-045 | Credential expires                      | Expiry reaches valid_until                       | Scheduled recalculation                             | Contribution expires; node state updates                | Job + snapshot                       |
| GS-EC10-046 | Expiry exception override               | Approved expiry exception                        | Apply override                                      | Node remains per override with explicit lineage         | Override + receipt                   |
| GS-EC10-047 | Reverse expiry exception                | Superseding override                             | Apply reverse                                       | Original fact not edited; projection recalculates       | Override lineage                     |
| GS-EC10-048 | As-of before revocation                 | Historical query date before revocation          | GET history asOf                                    | Shows SATISFIED then                                    | Snapshot/watermark proof             |
| GS-EC10-049 | As-of after revocation                  | Historical query after revocation                | GET history asOf                                    | Shows revoked/recomputed state                          | Snapshot proof                       |
| GS-EC10-050 | Revocation event duplicate              | Same revocation event repeated                   | Consume                                             | No duplicate contribution/change                        | Inbox dedup                          |
| GS-EC10-051 | Claim draft with evidence ref           | Participant authorized                           | Create + attach CT-05 ref                           | DRAFT; evidence metadata only                           | No blob in EC-10 DB                  |
| GS-EC10-052 | Submit without required evidence        | Claim missing requirement                        | Submit                                              | 422 EC10_CLAIM_EVIDENCE_REQUIRED                        | Validation issues                    |
| GS-EC10-053 | Evidence verified                       | Verifier authorized, hash current                | Verify                                              | verification_state VERIFIED + actor/time                | Audit/evidence row                   |
| GS-EC10-054 | Evidence replaced after verify          | CT-05 hash changes                               | Refresh verification                                | STALE; decision blocked                                 | Hash comparison                      |
| GS-EC10-055 | Accept claim                            | Claim IN_REVIEW + policy pass                    | Accept                                              | Terminal ACCEPTED + recognized fact                     | Receipt + fact                       |
| GS-EC10-056 | Partial accept                          | Only subset equivalent                           | Partial accept mapping                              | PARTIAL + scoped contributions                          | Decision + mapping evidence          |
| GS-EC10-057 | Reject claim                            | Insufficient evidence                            | Reject with reason                                  | REJECTED; no favorable fact                             | Receipt + no fact                    |
| GS-EC10-058 | Withdraw pre-decision                   | SUBMITTED not terminal                           | Withdraw                                            | WITHDRAWN                                               | Audit                                |
| GS-EC10-059 | Withdraw post-decision blocked          | ACCEPTED claim                                   | Withdraw                                            | 409 invalid transition                                  | State machine test                   |
| GS-EC10-060 | AI suggests but reviewer rejects        | CT-12 recommendation exists                      | Reviewer rejects suggestion and claim independently | Human outcome recorded; no AI decision                  | AI provenance + claim receipt        |
| GS-EC10-061 | Create migration exact target           | Target version resolvable                        | Create case                                         | DRAFT target hash pinned                                | Case row                             |
| GS-EC10-062 | Target equals source                    | Same version chosen                              | Create/simulate                                     | 422/409 blocked                                         | Validation test                      |
| GS-EC10-063 | Simulation complete                     | Source snapshot current, target available        | Simulate                                            | diff_hash + simulation_hash + mappings                  | Simulation artifact                  |
| GS-EC10-064 | Target hash changes after simulate      | EC-01 returns mismatched target hash             | Submit review/apply                                 | Blocked; require new case/simulation                    | Hash conflict reason                 |
| GS-EC10-065 | Exact mapping carry-forward             | Equivalent node exact                            | Apply migration                                     | Target contribution + receipt                           | CarryForwardReceipt                  |
| GS-EC10-066 | Dropped node                            | Source node absent target                        | Apply mapping DROPPED                               | No target contribution; receipt/decision retained       | Mapping evidence                     |
| GS-EC10-067 | New required node                       | Target new node                                  | Apply                                               | Target NodeProgress NOT_STARTED/BLOCKED as rules        | Target snapshot                      |
| GS-EC10-068 | Partial mapping                         | Source partially satisfies target                | Apply                                               | Partial contribution exact weight                       | Contribution + policy hash           |
| GS-EC10-069 | Migration double apply                  | Case already APPLIED                             | Replay same key                                     | Same target progress; no duplicate receipts             | Idempotency/count                    |
| GS-EC10-070 | Source marked migrated atomically       | Apply succeeds                                   | Commit                                              | Source MIGRATED only with target + receipts             | Transaction test                     |
| GS-EC10-071 | EC-08 applied but timeout               | Remote creates award then connection resets      | Request issuance                                    | Local UNKNOWN_EFFECT; no blind retry                    | Operation + receipt                  |
| GS-EC10-072 | Reconcile confirms applied              | UNKNOWN_EFFECT with remote award                 | Reconcile                                           | CONFIRMED + issued_award_ref                            | Remote query trace                   |
| GS-EC10-073 | Reconcile proves not applied            | UNKNOWN_EFFECT remote says absent                | Reconcile then retry same key                       | Safe retry; one award                                   | Correlation/idempotency              |
| GS-EC10-074 | Reconcile still unknown                 | Remote unavailable                               | Reconcile                                           | Remain UNKNOWN_EFFECT; alert/escalate                   | Aging metric                         |
| GS-EC10-075 | EC-01 unavailable on start              | Circuit open                                     | Start pathway                                       | 503; no guessed latest                                  | No progress row                      |
| GS-EC10-076 | EC-01 unavailable on read               | Cached pin exists but metadata stale             | GET progress                                        | Return STALE/PARTIAL with asOf, not zero                | UI contract                          |
| GS-EC10-077 | CT-05 unavailable during claim review   | Evidence required                                | Open/review                                         | PARTIAL/UNAVAILABLE; decision disabled                  | Dependency state                     |
| GS-EC10-078 | Broker down after commit                | Outbox persists                                  | Commit domain change                                | HTTP success if local command; event pending for retry  | Outbox row                           |
| GS-EC10-079 | Redis unavailable                       | Cache down                                       | GET progress                                        | PostgreSQL fallback; degraded latency only              | Cache metrics                        |
| GS-EC10-080 | Rebuild worker killed                   | Async rebuild RUNNING                            | Kill pod                                            | Lease/checkpoint allows safe recovery                   | Operation recovery evidence          |
| GS-EC10-081 | NO_DATA state                           | No trajectories exist                            | Open self journey                                   | First-use empty, not 0% fake                            | E2E screenshot                       |
| GS-EC10-082 | ZERO state                              | Active route with calculated 0%                  | Open progress                                       | Shows 0% with valid snapshot                            | E2E fixture                          |
| GS-EC10-083 | STALE state                             | Snapshot old vs event watermark                  | Open progress                                       | STALE badge + asOf + refresh path                       | E2E                                  |
| GS-EC10-084 | PARTIAL state                           | One dependency missing                           | Open explorer                                       | Available sections shown; missing identified            | E2E                                  |
| GS-EC10-085 | UNAVAILABLE state                       | Critical dependency down                         | Open operation                                      | Unavailable message; no synthetic value                 | E2E                                  |
| GS-EC10-086 | UNKNOWN_EFFECT state                    | Issuance ambiguous                               | Open eligibility                                    | Dedicated status; no blind retry CTA                    | E2E                                  |
| GS-EC10-087 | 412 Conflict Drawer                     | Two browser tabs                                 | Save stale tab                                      | Conflict drawer with reload/diff/reapply                | Playwright                           |
| GS-EC10-088 | Accessible graph alternative            | Keyboard/screen reader                           | Navigate pathway graph                              | Equivalent tabular view + focus order                   | A11y test                            |
| GS-EC10-089 | Mobile offline journey                  | Cached summary then offline                      | Open app                                            | STALE/asOf visible; no current assertion                | Device test                          |
| GS-EC10-090 | Mobile draft sync conflict              | Draft claim offline, server changed              | Reconnect                                           | Conflict-safe merge/review; no overwrite terminal state | Sync test                            |
| GS-EC10-091 | AI explanation grounded                 | Snapshot/facts available                         | Request explanation                                 | CT-12 result contains grounding refs/hashes             | AI provenance                        |
| GS-EC10-092 | AI unavailable                          | CT-12 down                                       | Open progress                                       | Deterministic UI continues without AI                   | Resilience test                      |
| GS-EC10-093 | AI mapping low confidence               | Recommendation below threshold                   | Open migration                                      | Displayed as suggestion; manual review required         | UI + provenance                      |
| GS-EC10-094 | AI prompt injection in evidence         | Evidence contains adversarial text               | Ask summary                                         | CT-12 isolation/grounding policy; no tool escalation    | AI security test                     |
| GS-EC10-095 | Corporate minimum cohort unmet          | Cohort below threshold                           | GET corporate aggregate                             | Suppressed metrics                                      | API contract                         |
| GS-EC10-096 | Corporate allowed aggregate             | Profile permits completion aggregate             | GET aggregate                                       | Only approved fields returned                           | Field allowlist test                 |
| GS-EC10-097 | Corporate nominal data denied           | Sponsor asks individual notes                    | Query/export                                        | 403/field omitted                                       | Privacy test                         |
| GS-EC10-098 | Purpose expired                         | Sponsor token/profile purpose invalid            | GET aggregate                                       | Denied                                                  | Audit                                |
| GS-EC10-099 | PII absent from logs                    | Sensitive claim processed                        | Inspect logs/traces                                 | No names/email/evidence body                            | Log scan                             |
| GS-EC10-100 | Export watermark/audit                  | Authorized audit export                          | Generate export                                     | Artifact ref + purpose + actor + expiry/audit           | Evidence pack                        |
| GS-EC10-101 | Legacy person unresolved                | Import row missing mapping                       | Dry-run                                             | BLOCKER, not promoted                                   | DQ report                            |
| GS-EC10-102 | Legacy duplicate same record            | Duplicate same canonical hash                    | Dry-run/promote                                     | Dedup idempotently                                      | Lineage                              |
| GS-EC10-103 | Legacy duplicate conflict               | Same key different canonical hash                | Dry-run                                             | BLOCKER                                                 | DQ issue                             |
| GS-EC10-104 | Legacy unknown pathway                  | Historical path id missing                       | Dry-run                                             | BLOCKER; no latest substitution                         | DQ report                            |
| GS-EC10-105 | Legacy hash mismatch                    | Mapped version content differs                   | Validate                                            | BLOCKER                                                 | Hash evidence                        |
| GS-EC10-106 | Legacy external certificate trusted     | Issuer/profile valid                             | Promote claim/fact per mapping                      | Governed recognition path                               | Migration receipt                    |
| GS-EC10-107 | Legacy external certificate untrusted   | Issuer unknown                                   | Promote                                             | Recognition claim/manual review, not auto-satisfied     | Claim ref                            |
| GS-EC10-108 | Dry-run no mutation                     | Dataset contains valid rows                      | Dry-run                                             | No final EC-10 domain rows created                      | DB count evidence                    |
| GS-EC10-109 | Promote through API                     | Certified batch                                  | Promote                                             | Commands create facts/progress with audit/outbox        | Command receipts                     |
| GS-EC10-110 | Reconciliation finds missed record      | Post-promote diff detects missing effect         | Reconcile                                           | Repair via official idempotent command                  | Reconciliation receipt               |
| GS-EC10-111 | Expand migration N/N-1                  | Old app + new schema                             | Deploy expand                                       | Old app still works                                     | Compatibility test                   |
| GS-EC10-112 | Backfill resume                         | Backfill interrupted                             | Restart worker                                      | Continues from checkpoint, no duplicates                | Backfill metrics                     |
| GS-EC10-113 | Switch via feature flag                 | New read model verified                          | Enable switch                                       | Reads new path; rollback app possible                   | Release evidence                     |
| GS-EC10-114 | Contract delayed                        | Old column still used by N-1                     | Attempt contract                                    | Gate blocks removal                                     | Schema usage evidence                |
| GS-EC10-115 | Performance p95 summary                 | Representative load                              | Run benchmark                                       | p95 within 500 ms target/budget                         | Performance report                   |
| GS-EC10-116 | Fact propagation SLO                    | Burst valid events                               | Observe snapshots                                   | 99% \<60 s target                                       | Latency report                       |
| GS-EC10-117 | Outbox lag SLO                          | Broker temporary slowdown                        | Observe recovery                                    | 99% \<120 s after recovery objective                    | Metric export                        |
| GS-EC10-118 | Rebuild determinism release             | Sample dataset                                   | Run rebuild twice                                   | 100% same result hash                                   | Determinism report                   |
| GS-EC10-119 | Backup/restore evidence                 | Staging backup                                   | Restore and replay                                  | Facts/receipts/snapshots intact                         | Restore test                         |
| GS-EC10-120 | Gate evidence complete                  | Release candidate                                | Evaluate G1-G10                                     | No gate approved without artifact links                 | Certification pack                   |

# 

| **ID** | **Escenario**                                  | **Precondición**                           | **Ejecución**             | **Criterio de aceptación**                        | **Firmantes**              |
|--------|------------------------------------------------|--------------------------------------------|---------------------------|---------------------------------------------------|----------------------------|
| UAT-01 | Participante inicia ruta y ve progreso         | Persona/scope autorizados; route published | Start + ingest completion | Progress explicable y next action correcto        | Participant + Academic Ops |
| UAT-02 | Reconocimiento de credencial externa           | Evidence CT-05 + reviewer                  | Submit/verify/accept      | Claim terminal, fact y progreso con lineage       | Participant + Reviewer     |
| UAT-03 | Revocación cambia progreso sin borrar historia | Award usado luego revocado                 | Ingest revocation         | Current cambia; as-of previo permanece            | Academic Ops + Auditor     |
| UAT-04 | Migración entre PathwayVersion                 | Source active, target published            | Simulate/review/apply     | Target progress y carry receipts; source MIGRATED | Advisor + Approver         |
| UAT-05 | Elegibilidad acumulativa y emisión             | Snapshot cumple blueprint                  | Evaluate + request EC-08  | Decision explicable + award confirmado/operation  | Credential Ops             |
| UAT-06 | Timeout de emisión                             | EC-08 aplica pero timeout                  | Request issuance          | UNKNOWN_EFFECT; reconcile confirma sin duplicar   | Ops + Credential Ops       |
| UAT-07 | Tenant isolation                               | Datos equivalentes en dos tenants          | Cross-tenant probes       | Cero acceso/corrupción                            | Security + DBA             |
| UAT-08 | Corporate aggregate privacy                    | ReportingProfile restrictivo               | Sponsor consulta          | Suppression/fields correctos                      | EC-09 owner + Privacy      |
| UAT-09 | Legacy migration                               | Dataset histórico certificado              | Dry-run/promote/reconcile | Lineage completo y cero direct inserts            | Migration Team             |
| UAT-10 | Auditor reconstruye decisión histórica         | Facts/snapshots/policies versioned         | As-of + evidence pack     | Mismo result hash/justificación                   | Auditor                    |

# 

| **Gate** | **Ámbito**                     | **Evidencia mínima**                                                       | **Owner**             |
|----------|--------------------------------|----------------------------------------------------------------------------|-----------------------|
| G1       | Arquitectura y bounded context | Context/domain diagrams; Source of Truth matrix; ADRs; no cross-context FK | Arquitecto            |
| G2       | Datos/constraints              | DDL clean-run; RLS negative tests; append-only/constraints; ERD            | DBA + Security        |
| G3       | Backend                        | Domain/unit/integration/concurrency; aggregate revision; idempotency       | Backend Lead          |
| G4       | API/Event contracts            | OpenAPI/AsyncAPI lint + contract compatibility + generated client          | API Lead              |
| G5       | Frontend/Mobile                | Critical E2E; data states; a11y; responsive/offline                        | Frontend/Mobile Leads |
| G6       | Seguridad/auditoría            | Threat model; SoD/step-up; SAST/SCA/secrets/SBOM; evidence pack            | Security              |
| G7       | Integraciones/resiliencia      | Timeout/retry/CB; UNKNOWN_EFFECT; outbox/inbox; reconciliation tests       | Integration/SRE       |
| G8       | QA/UAT                         | Golden Scenarios critical pass; UAT signatures; defect threshold           | QA + Product          |
| G9       | Migración/operaciones          | CT-16 dry-run/promote; runbooks; backup/restore; observability             | Ops + Migration       |
| G10      | Release/certificación          | N/N-1; zero-downtime plan; all gate evidence linked; rollback/roll-forward | Release Board         |

| **REGLA DE GATE —** “Parece listo” no es evidencia. Cada Gate debe enlazar artifacts versionados del Engineering Pack y tener responsable/aprobación verificable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 

## 

- Source of Truth y fronteras confirmadas.

- User story/command/query enlazada a BR/UC y acceptance test.

- OpenAPI/AsyncAPI contract draft disponible.

- Modelo de datos/constraints e impacto RLS definidos.

- Dependency failure semantics y UNKNOWN_EFFECT definidos.

- Security classification/purpose/permissions definidos.

- Observability y migration considerations identificadas.

- ADR cerrado cuando existe decisión arquitectónica no trivial.

## 

- Código + tests unit/integration/contract/E2E según cambio.

- DDL Flyway compatible y probado clean/upgrades; RLS tests pasan.

- OpenAPI/AsyncAPI actualizado y generated client compila.

- Audit/outbox/idempotency/ETag cubiertos donde aplica.

- Logs/metrics/traces y dashboards/alerts actualizados.

- Threat/Secure SDLC checks pasan; SBOM publicado.

- Runbook y rollback/roll-forward actualizados.

- Golden Scenario/UAT relevante pasa con evidencia.

- Gates aplicables aprobados.

- Word y Git contracts permanecen alineados.

# 

| **Runbook** | **Trigger**                  | **Procedimiento resumido**                                                                                                         |
|-------------|------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| RB-EC10-01  | Outbox lag / broker down     | Detectar oldest pending; validar broker; no tocar domain; recover leases; monitor drain; escalar si DEAD.                          |
| RB-EC10-02  | UNKNOWN_EFFECT emisión EC-08 | Buscar operation/correlation; consultar EC-08; confirmar si applied; retry misma key solo si no applied; document receipt.         |
| RB-EC10-03  | Inbox quarantine             | Inspeccionar schema/hash/source auth; no editar message; corregir adapter/contract; replay gobernado.                              |
| RB-EC10-04  | Pathway hash mismatch        | Bloquear recalc/migration; comparar pin con EC-01; confirmar version artifact; abrir incident/ADR si publication drift.            |
| RB-EC10-05  | Rebuild drift                | Comparar engine/policy/watermark; ejecutar deterministic replay; no overwrite old snapshot; raise release blocker if unexplained.  |
| RB-EC10-06  | RLS anomaly                  | Freeze sensitive operations; rotate credentials if needed; collect DB audit; prove tenant isolation; incident security process.    |
| RB-EC10-07  | Idempotency stuck            | Check lease owner heartbeat; wait/expire; reclaim; never delete row to “unlock” without evidence.                                  |
| RB-EC10-08  | Migration APPLYING stuck     | Read AsyncOperation + target progress/receipts; determine applied/partial; reconcile before any retry.                             |
| RB-EC10-09  | Redis outage                 | Switch/fallback PostgreSQL; protect DB with rate/circuit; mark degraded; rebuild cache after recovery.                             |
| RB-EC10-10  | CT-05 unavailable            | Claims requiring evidence cannot terminally approve; show UNAVAILABLE; preserve work; resume after recovery.                       |
| RB-EC10-11  | Bulk rebuild overload        | Throttle per tenant; queue; scale worker; protect interactive SLO; monitor DB locks/CPU.                                           |
| RB-EC10-12  | Rollback release             | Rollback app compatible N/N-1; do not destructively rollback schema; roll-forward migration when data transform already committed. |
| RB-EC10-13  | Legacy migration failure     | Pause batch; inspect DQ/receipts; reconcile promoted commands; resume from checkpoint only after certification.                    |
| RB-EC10-14  | Potential data leak export   | Revoke artifact/token, preserve audit, incident response, impact analysis, fix purpose/field policy before resume.                 |

# 

| **ADR**      | **Tema**                                   | **Estado** | **Decisión/pendiente**                                                       |
|--------------|--------------------------------------------|------------|------------------------------------------------------------------------------|
| ADR-EC10-001 | Trajectory bounded context ownership       | Adopted    | EC-10 owns progression/recognition projections, not source facts masters.    |
| ADR-EC10-002 | Pathway pin by id+hash                     | Adopted    | Never latest for history.                                                    |
| ADR-EC10-003 | Fact ledger append-only                    | Adopted    | Corrections are compensating facts.                                          |
| ADR-EC10-004 | Progress snapshots append-only             | Adopted    | Rebuild creates new snapshot.                                                |
| ADR-EC10-005 | Recognition claim workflow                 | Adopted    | CT-06 ref; local semantic state remains EC-10.                               |
| ADR-EC10-006 | Migration creates new progress             | Adopted    | No in-place rebind.                                                          |
| ADR-EC10-007 | Carry-forward receipt                      | Adopted    | Every migrated contribution traceable.                                       |
| ADR-EC10-008 | Cumulative eligibility separate from award | Adopted    | EC-08 remains issuer.                                                        |
| ADR-EC10-009 | RLS defense-in-depth                       | Adopted    | ENABLE+FORCE; runtime no BYPASSRLS.                                          |
| ADR-EC10-010 | Aggregate revision child mutation          | Adopted    | Root ETag covers aggregate.                                                  |
| ADR-EC10-011 | Durable idempotency leases                 | Adopted    | Lease/owner/recovery.                                                        |
| ADR-EC10-012 | Outbox leased SKIP LOCKED                  | Adopted    | Multi-instance dispatch.                                                     |
| ADR-EC10-013 | UNKNOWN_EFFECT protocol                    | Adopted    | No blind retry.                                                              |
| ADR-EC10-014 | OpenAPI generated client                   | Adopted    | No duplicate DTO manual.                                                     |
| ADR-EC10-015 | AI via CT-12 only                          | Adopted    | Recommendation only.                                                         |
| ADR-EC10-016 | Corporate aggregate privacy                | Adopted    | EC-09 ReportingProfile governs fields/suppression.                           |
| ADR-EC10-017 | MongoDB derived only                       | Adopted    | No SoT facts/decisions.                                                      |
| ADR-EC10-018 | Zero-downtime schema                       | Adopted    | Expand/contract N/N-1.                                                       |
| ADR-EC10-019 | Progress engine versioning                 | Adopted    | Snapshot records engine_version for reproducibility.                         |
| ADR-EC10-020 | As-of semantics                            | Adopted    | Snapshot/watermark + temporal validity.                                      |
| ADR-EC10-021 | External trust registry authority          | Open       | Close with CT-18/EC-08 before broad external credential auto-recognition.    |
| ADR-EC10-022 | Cross-vertical PG/PO bridge                | Open       | Explicitly excluded until policy/legal/academic governance defines contract. |

# 

| **Ruta Git mínima**                  | **Contenido**                                           |
|--------------------------------------|---------------------------------------------------------|
| /docs/ec10/EC-10.docx                | Especificación maestra publicada.                       |
| /architecture/ec10/context.puml      | Context diagram.                                        |
| /architecture/ec10/domain.puml       | Aggregates/entities/VOs.                                |
| /architecture/ec10/physical-erd.puml | DER físico.                                             |
| /architecture/ec10/sequences/\*.puml | Fact ingest, claim, migration, issuance unknown-effect. |
| /adr/ec10/ADR-EC10-\*.md             | ADRs aceptados/abiertos.                                |
| /db/migration/V\*\_ec10\_\*.sql      | Flyway expand/backfill/contract scripts.                |
| /openapi/ec10-trajectory-v1.yaml     | REST contract.                                          |
| /asyncapi/ec10-events-v1.yaml        | Event contracts.                                        |
| /backend/ec10/\*\*                   | Módulo Spring Modulith.                                 |
| /frontend/features/ec10/\*\*         | Feature modules Web.                                    |
| /mobile/features/ec10/\*\*           | Journeys móviles aplicables.                            |
| /tests/ec10/unit/\*\*                | Unit/property tests.                                    |
| /tests/ec10/integration/\*\*         | DB/adapters/RLS tests.                                  |
| /tests/ec10/contract/\*\*            | OpenAPI/AsyncAPI compatibility.                         |
| /tests/ec10/e2e/\*\*                 | Web/Mobile critical journeys.                           |
| /tests/ec10/security/\*\*            | IDOR/RLS/SoD/export tests.                              |
| /performance/ec10/\*\*               | Load/rebuild reports and datasets.                      |
| /security/ec10/\*\*                  | Threat model, scans, SBOM, waivers.                     |
| /runbooks/ec10/\*\*                  | Operational runbooks.                                   |
| /observability/ec10/\*\*             | Dashboards, alerts, SLI/SLO queries.                    |
| /migration/ec10/\*\*                 | CT-16 mapping/DQ/lineage configs.                       |
| /evidence/ec10/gates/\*\*            | G1-G10 evidence index.                                  |
| /fixtures/ec10/\*\*                  | Golden deterministic fixtures.                          |

# 

**Paso 1 —** Crear module ec10 en Spring Modulith y declarar dependencias permitidas; agregar architecture tests.

**Paso 2 —** Crear package structure por trajectory/progress/recognition/migration/eligibility/infrastructure.

**Paso 3 —** Implementar VOs PathwayVersionRef, SourceFactKey, PolicySnapshot, DependencyState y clocks inyectables.

**Paso 4 —** Implementar Aggregate LearningTrajectory y state guards.

**Paso 5 —** Implementar PathwayProgress y Aggregate Revision Contract.

**Paso 6 —** Implementar RecognitionClaim, PathwayMigrationCase y CumulativeEligibilityDecision.

**Paso 7 —** Implementar entities append-only TrajectoryFact/ProgressSnapshot/Receipts y policies de dominio.

**Paso 8 —** Definir ports EC-01, EC-07, EC-08, CT-05, CT-06, CT-12, CT-16 y CT-15 si aplica.

**Paso 9 —** Crear Flyway expand inicial con schema, tables, composite PK/FK, checks, indexes.

**Paso 10 —** Agregar triggers append-only y pin immutable.

**Paso 11 —** Agregar ENABLE/FORCE RLS y roles runtime/migrator/worker separados.

**Paso 12 —** Implementar TenantContext transaccional con SET LOCAL y pruebas de pool leakage.

**Paso 13 —** Implementar repositories explícitos incluyendo lock FOR UPDATE y queries as-of.

**Paso 14 —** Implementar idempotency service con request hash, lease, heartbeat y recovery.

**Paso 15 —** Implementar outbox dispatcher con SKIP LOCKED, lease/reclaim y metrics.

**Paso 16 —** Implementar inbox consumers con dedup/payload hash/quarantine.

**Paso 17 —** Implementar ProgressEvaluationService determinista y hash canonical.

**Paso 18 —** Implementar matching de facts a nodes y FactContribution.

**Paso 19 —** Implementar snapshot service con engine/policy/pathway/watermark/result hashes.

**Paso 20 —** Implementar RecognitionClaim commands + evidence adapter CT-05 + workflow CT-06.

**Paso 21 —** Implementar migration diff/simulation/mapping/apply/carry-forward receipts.

**Paso 22 —** Implementar eligibility decision y adapter EC-08 con UNKNOWN_EFFECT/reconciliation.

**Paso 23 —** Implementar AsyncOperation para rebuild/migration/issuance/export.

**Paso 24 —** Implementar REST controllers desde OpenAPI generated interfaces o contract-first baseline.

**Paso 25 —** Implementar ProblemDetail/reason codes, pagination/sort allowlist, ETag/If-Match.

**Paso 26 —** Implementar domain/integration events + AsyncAPI + schema compatibility tests.

**Paso 27 —** Agregar observability logs/metrics/traces sin PII y dashboards/alerts.

**Paso 28 —** Agregar security authorization, ABAC, SoD, step-up handoff y rate/size limits.

**Paso 29 —** Implementar unit/property + Testcontainers PostgreSQL + concurrency/RLS/resilience tests.

**Paso 30 —** Implementar CT-16 migration commands/dry-run promotion endpoints internos.

**Paso 31 —** Completar performance tests y capacity budgets por tenant.

**Paso 32 —** Ejecutar G1-G10, build Evidence Pack y cerrar ADRs P0/P1.

**Paso 33 —** Planificar release expand/deploy/backfill/switch/contract con feature flags y roll-forward.

# 

**Paso 1 —** Definir routes y capability guards por workspace.

**Paso 2 —** Crear feature modules ec10/trajectory, progress, recognition, migration, eligibility, reconciliation y audit.

**Paso 3 —** Generar client/DTO desde OpenAPI en CI; prohibir interfaces duplicadas manualmente.

**Paso 4 —** Definir query key factory con tenant/scope/asOf/filters/version.

**Paso 5 —** Crear adapters DTO→view model solo para presentación; no reinterpretar estados de dominio.

**Paso 6 —** Implementar WorkspaceShell con tenant/scope chip, freshness, breadcrumb y correlation support.

**Paso 7 —** Implementar Trajectory Command Center con filtros bounded y KPI semantics.

**Paso 8 —** Implementar Participant Trajectory Workspace y self-service safe.

**Paso 9 —** Implementar Pathway Progress Explorer con graph + accessible table.

**Paso 10 —** Implementar Node Explanation Drawer con facts/contributions/policy provenance.

**Paso 11 —** Implementar Recognition Claim Desk y form validation contract-aligned.

**Paso 12 —** Implementar Recognition Review Center con evidence/policy/SoD warnings.

**Paso 13 —** Implementar Pathway Migration Studio source/target diff y mapping accessible.

**Paso 14 —** Implementar Cumulative Eligibility Center y issuance OperationStatus.

**Paso 15 —** Implementar Reconciliation Center con no-blind-retry UX.

**Paso 16 —** Persistir ETag por aggregate y enviarlo en toda mutation.

**Paso 17 —** Implementar Conflict Drawer 412 con Reload/Diff/Reapply; sin auto-retry.

**Paso 18 —** Generar Idempotency-Key estable por intento lógico; no regenerarla durante replay automático seguro.

**Paso 19 —** Implementar OperationStatus polling con backoff y stop terminal/UNKNOWN_EFFECT guidance.

**Paso 20 —** Modelar NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT en componentes compartidos.

**Paso 21 —** Implementar ProblemDetail mapper reasonCode→i18n/remediation sin ocultar correlationId.

**Paso 22 —** Integrar CT-08 i18n y formatos locale/timezone sin duplicar verdad académica.

**Paso 23 —** Implementar accessibility WCAG 2.2 AA: keyboard/focus/error summary/graph alternative.

**Paso 24 —** Implementar responsive: desktop multi-panel, tablet drawers, mobile web limited authoring.

**Paso 25 —** Agregar component/unit tests, MSW fixtures generadas y Playwright critical journeys.

**Paso 26 —** Instrumentar web-vitals/business telemetry sin PII y cerrar G5/G6/G8.

# 

| **Operación**          | **Permission**       | **Participant** | **Advisor** | **Reviewer** | **Academic Ops** | **Credential Ops** | **Auditor** | **SRE** |
|------------------------|----------------------|-----------------|-------------|--------------|------------------|--------------------|-------------|---------|
| View own trajectory    | TRAJECTORY_SELF_VIEW | ✓               | ✓           | —            | —                | —                  | —           | —       |
| View scoped trajectory | TRAJECTORY_VIEW      | —               | ✓           | ✓            | ✓                | ✓                  | ✓           | —       |
| Start pathway          | PATHWAY_START        | ✓\*             | ✓           | —            | ✓                | —                  | —           | —       |
| Recalculate progress   | PROGRESS_RECALC      | —               | ✓           | —            | ✓                | —                  | —           | ✓       |
| Create claim           | CLAIM_CREATE         | ✓               | ✓           | —            | ✓                | —                  | —           | —       |
| Verify claim evidence  | CLAIM_VERIFY         | —               | —           | ✓            | —                | —                  | —           | —       |
| Decide claim           | CLAIM_DECIDE         | —               | —           | ✓\*          | —                | —                  | —           | —       |
| Manual override        | PROGRESS_OVERRIDE    | —               | —           | —            | ✓\*              | —                  | —           | —       |
| Create migration       | MIGRATION_CREATE     | —               | ✓           | —            | ✓                | —                  | —           | —       |
| Approve migration      | MIGRATION_APPROVE    | —               | —           | ✓\*          | ✓\*              | —                  | —           | —       |
| Apply migration        | MIGRATION_APPLY      | —               | —           | —            | ✓\*              | —                  | —           | ✓       |
| Evaluate eligibility   | ELIGIBILITY_EVALUATE | —               | —           | —            | ✓                | ✓                  | —           | —       |
| Request issuance       | ISSUANCE_REQUEST     | —               | —           | —            | —                | ✓\*                | —           | —       |
| Read audit/receipts    | AUDIT_READ           | —               | —           | ✓            | ✓                | ✓                  | ✓           | ✓       |
| Export sensitive       | EXPORT_SENSITIVE     | —               | —           | —            | ✓\*              | ✓\*                | ✓\*         | —       |
| Reconcile integration  | OPS_RECONCILE        | —               | —           | —            | —                | —                  | —           | ✓       |
| Corporate aggregate    | CORP_REPORT_VIEW     | —               | —           | —            | ✓                | —                  | ✓           | —       |

\* Acción sujeta además a ABAC scope/purpose, SoD y/o step-up según policy. La UI nunca es autoridad de autorización; Backend y DB aplican controles.

# 

## 

- IDs son strings opacos; Frontend no infiere tenant/ownership por formato.

- Toda response mutable expone ETag/etag.

- Refs externas incluyen id/ref + resolutionStatus + asOf/displaySnapshot opcional; nunca master editable.

- DependencyState = AVAILABLE/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.

- Progress percent nullable: null = no calculable/indisponible; 0 = cero calculado válido.

- ProblemDetail incluye type/title/status/detail/reasonCode/correlationId/fieldErrors/remediationHint opcional.

## 

```
export type DependencyState =
| 'AVAILABLE' | 'STALE' | 'PARTIAL' | 'UNAVAILABLE' | 'UNKNOWN_EFFECT';

export type NodeProgressState =
| 'NOT_STARTED' | 'IN_PROGRESS' | 'SATISFIED' | 'BLOCKED'
| 'MANUAL_REVIEW' | 'EXPIRED' | 'REVOKED' | 'WAIVED';

export interface ExternalRefDto {
ref: string;
resolutionStatus: DependencyState;
asOf?: string;
displaySnapshot?: string;
contentHash?: string;
}

export interface PathwayProgressSummaryDto {
id: string;
trajectoryId: string;
pathwayVersion: ExternalRefDto;
state: 'DRAFT'|'ACTIVE'|'COMPLETED'|'SUSPENDED'|'MIGRATED'|'CLOSED';
progressPercent: number | null;
satisfiedNodes: number;
requiredNodes: number;
blockingCount: number;
currentSnapshotId?: string;
dependencyState: DependencyState;
asOf: string;
etag: string;
}

export interface NodeProgressDto {
nodeRef: string;
state: NodeProgressState;
satisfiedWeight: number;
requiredWeight: number;
reasonCode?: string;
blockingNodeRef?: string;
basisHash?: string;
dependencyState: DependencyState;
evaluatedAt: string;
}

export interface RecognitionClaimDto {
id: string;
claimType: string;
targetPathwayVersionRef: string;
targetNodeRef?: string;
state: 'DRAFT'|'SUBMITTED'|'VERIFYING'|'IN_REVIEW'|'ACCEPTED'|'PARTIAL'|'REJECTED'|'WITHDRAWN';
decision?: 'ACCEPTED'|'PARTIAL'|'REJECTED';
decisionReasonCode?: string;
evidence: Array<{ref:string; hash:string; verificationState:string}>;
etag: string;
}

export interface OperationStatusDto {
operationId: string;
state: 'PENDING'|'RUNNING'|'SUCCEEDED'|'FAILED'|'UNKNOWN_EFFECT'|'CANCELLED';
progressPercent?: number;
reasonCode?: string;
resultRef?: string;
correlationId: string;
pollAfterMs?: number;
reconciliationHint?: string;
etag?: string;
}

export interface ProblemDetailsDto {
type: string;
title: string;
status: number;
detail?: string;
reasonCode: string;
correlationId: string;
fieldErrors?: Array<{path:string; reasonCode:string; messageKey:string}>;
remediationHint?: string;
}
```

# 

**☐ 01.** Source of Truth matrix aprobada y sin solapamientos EC-01/04/07/08/09/CT.

**☐ 02.** ADRs P0/P1 cerrados o waiver formal.

**☐ 03.** DDL clean install y upgrade desde N-1 ejecutados.

**☐ 04.** Todas PK/FK internas críticas tenant-aware.

**☐ 05.** ENABLE + FORCE RLS verificado en todas tenant-owned.

**☐ 06.** Runtime DB role sin ownership/BYPASSRLS.

**☐ 07.** Append-only triggers probados para facts/snapshots/receipts.

**☐ 08.** Pathway pin immutable trigger probado.

**☐ 09.** Aggregate revision cubre child mutations.

**☐ 10.** ETag/If-Match cubre commands mutables.

**☐ 11.** Idempotency durable same/different payload y lease recovery probado.

**☐ 12.** Outbox leased + SKIP LOCKED + reclaim probado.

**☐ 13.** Inbox dedup/payload mismatch quarantine probado.

**☐ 14.** OpenAPI lint + generated client compila.

**☐ 15.** AsyncAPI schemas y compatibility tests pasan.

**☐ 16.** ProblemDetail/reasonCode/correlation definidos.

**☐ 17.** OperationStatus para todo 202/UNKNOWN_EFFECT.

**☐ 18.** No blind retry en EC-08/CT-06/effectful integrations.

**☐ 19.** Recognition SoD/step-up probado.

**☐ 20.** Migration simulation/apply/carry receipts probado.

**☐ 21.** As-of histórico reproducible.

**☐ 22.** Rebuild determinism 100% en fixtures.

**☐ 23.** NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT E2E.

**☐ 24.** WCAG 2.2 AA critical flows verificados.

**☐ 25.** Mobile offline/stale semantics verificados.

**☐ 26.** Corporate aggregate suppression/privacy probado.

**☐ 27.** Threat Model actualizado y security findings cerrados.

**☐ 28.** SAST/SCA/secret/container/IaC scans dentro de policy.

**☐ 29.** SBOM generado y archivado.

**☐ 30.** SLI/SLO dashboards y alerts activos.

**☐ 31.** Runbooks ejercitados al menos para outbox/unknown/rls/rebuild.

**☐ 32.** CT-16 dry-run/promote/reconcile certificado si hay migration.

**☐ 33.** Backup/restore y roll-forward strategy verificados.

**☐ 34.** Expand/contract N/N-1 confirmado.

**☐ 35.** Golden Scenarios críticos aprobados.

**☐ 36.** UAT institucional firmado.

**☐ 37.** G1-G10 con evidence links.

**☐ 38.** DOCX y Git contracts versionados y alineados.

# 

| **ID** | **Garantía no negociable**                                                                                      |
|--------|-----------------------------------------------------------------------------------------------------------------|
| C-01   | Source of Truth respetado; EC-10 no redefine personas, pathways, completion ni awards.                          |
| C-02   | No existe FK física cross-context.                                                                              |
| C-03   | tenant_id no proviene de body libre.                                                                            |
| C-04   | Toda tabla tenant-owned tiene RLS ENABLE + FORCE.                                                               |
| C-05   | Runtime role no posee tablas ni BYPASSRLS.                                                                      |
| C-06   | PK/FK internas críticas son tenant-aware.                                                                       |
| C-07   | PathwayProgress pinnea version ref/no/hash y el pin es inmutable.                                               |
| C-08   | No se usa latest para historia/rebuild.                                                                         |
| C-09   | TrajectoryFact es append-only.                                                                                  |
| C-10   | ProgressSnapshot y receipts críticos son append-only.                                                           |
| C-11   | Aggregate revision representa root + hijos y toda mutation crítica renueva ETag.                                |
| C-12   | Commands mutables usan If-Match; no last-write-wins.                                                            |
| C-13   | Idempotency-Key es durable con request hash, response y lease/recovery.                                         |
| C-14   | Same-key/different-payload = 409; same-key/same-payload = replay lógico.                                        |
| C-15   | Outbox se escribe en misma transacción y dispatch usa lease/SKIP LOCKED.                                        |
| C-16   | Inbox dedup protege at-least-once; no se promete exactly-once distribuido.                                      |
| C-17   | UNKNOWN_EFFECT es estado explícito y no equivale FAILED.                                                        |
| C-18   | No existe retry ciego de operación remota con efecto.                                                           |
| C-19   | Reconciliation consulta remote truth/correlation antes de retry.                                                |
| C-20   | RecognitionClaim terminal exige evidence/policy/reason y SoD según policy.                                      |
| C-21   | ManualOverride no edita facts y requiere reason/evidence/approval.                                              |
| C-22   | Pathway migration crea caso, simulation, mapping, target progress y carry-forward receipts; no rebind in-place. |
| C-23   | CumulativeEligibilityDecision no crea CredentialAward; EC-08 sigue siendo issuer.                               |
| C-24   | OpenAPI/AsyncAPI son contratos ejecutables; client/DTO Frontend se generan.                                     |
| C-25   | ProblemDetail y reasonCode son estables/documentados.                                                           |
| C-26   | Todo 202 devuelve OperationStatus consultable.                                                                  |
| C-27   | Frontend distingue NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.                                       |
| C-28   | Mobile no replica administración crítica sin justificación, scope y step-up.                                    |
| C-29   | IA pasa exclusivamente por CT-12 y Recommendation ≠ Decision.                                                   |
| C-30   | AI provenance mínima se conserva para toda recommendation aplicada/considerada.                                 |
| C-31   | Threat Model y Secure SDLC son parte del release, no anexos opcionales.                                         |
| C-32   | Migración usa CT-16 y promoción por dominio/API; no INSERT directo final.                                       |
| C-33   | Flyway y app siguen expand/contract N/N-1; rollback destructivo no es estrategia normal.                        |
| C-34   | Logs/metrics/traces no exponen PII/evidence sensible y soportan SLI/SLO.                                        |
| C-35   | As-of e historia son reproducibles por snapshot/watermark/hashes.                                               |
| C-36   | Corporate reporting se limita al ReportingProfile EC-09 y aplica suppression.                                   |
| C-37   | Golden Scenarios, UAT, G1-G10 y Evidence Pack son criterios obligatorios de producción.                         |

| **CRITERIO FINAL DE PRODUCCIÓN —** EC-10 solo está listo cuando puede demostrar con evidencia que un progreso actual e histórico es reproducible, tenant-isolated, explicable, resiliente y reconciliable; que una migración preserva lineage; que un reconocimiento no puede aprobarse sin gobierno; y que ningún timeout remoto puede producir duplicidad por retry ciego. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
