**PEOPLEU IA**

**EC-01**

**PORTAFOLIO, PROGRAMAS, VERSIONES, MÓDULOS,  
OUTCOMES, COMPETENCIAS Y RUTAS DE MICROCREDENCIALES**

Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Control**        | **Valor**                                                                                                      |
|--------------------|----------------------------------------------------------------------------------------------------------------|
| **Código**         | EC-01                                                                                                          |
| **Versión**        | V1.1                                                                                                           |
| **Estado**         | VIGENTE — PLANTILLA OFICIAL FULLSTACK ENTERPRISE                                                               |
| **Baseline**       | EC-00 V1.1 — Revisión Quirúrgica Enterprise                                                                    |
| **Vertical**       | Educación Continua / Formación Continua                                                                        |
| **Arquitectura**   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| **Stack objetivo** | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| **Contexto**       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| **Fecha base**     | Septiembre 2026 — Revisión quirúrgica FullStack                                                                |

| **GOBIERNO DE ARTEFACTOS —** Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA —** EC-01 es Source of Truth de la definición académica reusable del portafolio EC y de sus versiones publicadas. No es dueño de ediciones/ofertas, calendarios, inscripciones, pagos, sesiones, asistencia, completion ni emisión de certificados. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaración de propósito, autoridad y baseline

| **V1.1 — REVISIÓN QUIRÚRGICA FULLSTACK ENTERPRISE —** Esta versión cierra los hallazgos de implementación detectados al revisar EC-01 desde la perspectiva de un equipo Senior FullStack. Endurece aislamiento multi-tenant con PostgreSQL RLS, revisión de aggregate completa, state machines físicas, lineage, grafos, receipts append-only, idempotencia/outbox con lease, contratos REST completos, Threat Model, Secure SDLC, zero-downtime y Developer Experience. V1.1 sustituye integralmente a V1.0 como plantilla de EC-02…EC-12. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

Este documento operacionaliza AM-00, CT-00, CT-01…CT-18 y EC-00 V1.1 para construir EC-01 como el bounded context de diseño académico de Educación Continua. Su responsabilidad es definir qué productos formativos existen, cómo evolucionan por versiones, qué outcomes persiguen, qué módulos componen su estructura y qué credenciales o rutas pueden derivarse de esa definición; sin confundir diseño con ejecución.

EC-01 debe soportar cursos cortos, talleres, seminarios, webinars, bootcamps, programas ejecutivos, formación especializada, certificaciones, microcredenciales, programas modulares y experiencias stackable. La solución debe ser suficientemente flexible para universidades que operan decenas o cientos de ediciones por año, pero suficientemente rígida para impedir que una edición futura reescriba la definición histórica ejecutada en el pasado.

La regla de ingeniería es inequívoca: cada hecho que salga de la frontera EC-01 se consume por contrato. EC-01 no crea tablas espejo de CT-01…CT-18, Finanzas, RRHH o IAM. Las referencias cross-context se validan por ports/adapters, contract tests, snapshots justificables y receipts; nunca mediante FK físicas hacia esquemas ajenos.

| **CRITERIO DE ÉXITO —** Un equipo Senior debe poder crear, revisar, aprobar, publicar, superseder y auditar una definición académica EC sin conocimiento tribal; PostgreSQL debe impedir cruces de tenant, versiones incoherentes, grafos inválidos y mutaciones destructivas de versiones publicadas incluso si el Backend tiene un bug. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquía documental aplicable

| **Prioridad** | **Documento/artefacto**                | **Rol**                                                      |
|---------------|----------------------------------------|--------------------------------------------------------------|
| 1             | AM-00 vigente                          | Constitución arquitectónica superior.                        |
| 2             | CT-00 vigente                          | Contrato maestro transversal.                                |
| 3             | CT-01…CT-18 vigentes                   | Capacidades compartidas y fronteras.                         |
| 4             | EC-00 V1.1                             | Constitución funcional/arquitectónica de Educación Continua. |
| 5             | EC-01 V1.0 (este documento)            | Especificación implementable del diseño académico EC.        |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación y evidencia alineadas al Word.                |

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
| 8         | EC-08      | Certificados, badges, microcredenciales, credenciales verificables y acumulabilidad primaria  | Certificación         |
| 9         | EC-09      | Formación corporativa / in-company, clientes, acuerdos, lotes y reporting empresarial         | B2B / Corporate       |
| 10        | EC-10      | Trayectoria de aprendizaje, progresión, stackable credentials y reconocimiento acumulativo EC | Trayectoria           |
| 11        | EC-11      | Encuestas, NPS, feedback, evaluación docente, impacto y seguimiento posterior                 | Experiencia / impacto |
| 12        | EC-12      | Calidad, analítica de portafolio, indicadores, compliance y mejora continua                   | Calidad / gobierno    |

## 0.3 Decisiones arquitectónicas EC01-DA

| **ID**          | **Decisión normativa**                                                                                                                                                                 |
|-----------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **EC01-DA-001** | PROGRAM DEFINITION ≠ PROGRAM VERSION ≠ PROGRAM EDITION ≠ OFFERING. EC-01 posee las dos primeras; EC-02 posee las dos últimas.                                                          |
| **EC01-DA-002** | PUBLISHED VERSION = IMMUTABLE SNAPSHOT. Todo cambio material crea nueva versión; no se reescribe historia.                                                                             |
| **EC01-DA-003** | LEARNING MODULE ≠ SESSION. El módulo define una unidad académica reusable; la sesión temporal pertenece a CT-03/EC-02.                                                                 |
| **EC01-DA-004** | MODULE DEFINITION ≠ MODULE VERSION. Reutilizar un módulo no autoriza editar retrospectivamente ejecuciones pasadas.                                                                    |
| **EC01-DA-005** | PROGRAM OUTCOME ≠ ASSESSMENT RESULT. EC-01 define el outcome; EC-07 registra resultados por participante.                                                                              |
| **EC01-DA-006** | COMPETENCY REFERENCE ≠ LOCAL SHADOW CATALOG. Competencias institucionales se referencian a CT-02 o catálogo gobernado; EC-01 conserva binding contextual.                              |
| **EC01-DA-007** | PROGRAM REQUIREMENT ≠ ELIGIBILITY DECISION. EC-01 declara requerimientos; CT-15 evalúa elegibilidad; EC-04 aplica el resultado al registro.                                            |
| **EC01-DA-008** | CREDENTIAL BLUEPRINT ≠ CREDENTIAL AWARD ≠ DOCUMENT. EC-01 define el blueprint; EC-08 adjudica/emite; CT-05 conserva artefacto/documento.                                               |
| **EC01-DA-009** | PATHWAY DEFINITION ≠ PARTICIPANT PATH PROGRESS. EC-01 define la ruta; EC-10 calcula progreso individual.                                                                               |
| **EC01-DA-010** | ACADEMIC HOURS ≠ FINANCIAL PRICE. EC-01 define carga académica; EC-03/Finanzas gobiernan dimensión comercial/contable.                                                                 |
| **EC01-DA-011** | AI RECOMMENDATION ≠ ACADEMIC APPROVAL. CT-12 puede asistir diseño; solo actores autorizados aprueban/publican.                                                                         |
| **EC01-DA-012** | CROSS-CONTEXT REFERENCE ≠ CROSS-CONTEXT FK. IDs de CT/IAM/cores son EXT REF sin FK física.                                                                                             |
| **EC01-DA-013** | TENANT CONTEXT ≠ REQUEST BODY. tenant_id proviene del contexto autorizado y todas las PK/FK internas críticas son tenant-aware.                                                        |
| **EC01-DA-014** | PUBLISH ≠ UPDATE STATE ONLY. Publicar exige validación integral, content hash, policy snapshot, evidence/approval, outbox y publication receipt en una transacción.                    |
| **EC01-DA-015** | STACKABLE CREDENTIAL ≠ DEGREE EQUIVALENCE. Las rutas EC no producen equivalencia automática con Pregrado/Postgrado; cualquier bridge exige contrato/ADR específico.                    |
| **EC01-DA-016** | LOCALIZED CONTENT ≠ DUPLICATED PROGRAM VERSION. Traducciones/labels se resuelven mediante CT-08 sin multiplicar versiones académicas por idioma.                                       |
| **EC01-DA-017** | DESIGN CHANGE REQUEST ≠ DIRECT EDIT. Cambios relevantes sobre una versión aprobada/publicada se canalizan por cambio versionado y workflow CT-06.                                      |
| **EC01-DA-018** | PUBLICATION RECEIPT ≠ CERTIFICATE. Es evidencia técnica/académica de qué definición se publicó, no una credencial de participante.                                                     |
| **EC01-DA-019** | AGGREGATE REVISION ≠ ROOT ROW ONLY. Toda mutación de un hijo de ProgramVersion/ModuleVersion/PathwayVersion incrementa la revisión del root; ETag representa el aggregate completo.    |
| **EC01-DA-020** | TENANT-AWARE FK ≠ TENANT ISOLATION. PK/FK compuestas protegen integridad; PostgreSQL RLS es defensa obligatoria para lecturas/escrituras ante bugs de repository.                      |
| **EC01-DA-021** | CURRENT PUBLISHED ≠ FUTURE COMMITTED. ProgramVersion admite SCHEDULED como snapshot inmutable para ejecución futura sin superseder prematuramente la versión PUBLISHED vigente.        |
| **EC01-DA-022** | POLICY REF = IMMUTABLE POLICY VERSION REF. Todo \*\_policy_ref debe resolver una versión inmutable de CT-02 reconstruible históricamente.                                              |
| **EC01-DA-023** | CREDENTIAL BLUEPRINT PUBLICATION ≠ INDEPENDENT PUBLICATION. El blueprint forma parte del snapshot de ProgramVersion; EC-08 consume el blueprint pinneado del ProgramVersion publicado. |
| **EC01-DA-024** | PUBLICATION RECEIPT = APPEND-ONLY EVIDENCE. UPDATE/DELETE están prohibidos físicamente; hash algorithm y canonical schema version forman parte del receipt.                            |
| **EC01-DA-025** | 202 ACCEPTED ≠ EFFECT CONFIRMED. Toda operación asíncrona devuelve operationId y expone OperationStatus hasta terminal/reconciliación.                                                 |
| **EC01-DA-026** | PATCH ≠ GENERIC SETTER. PATCH solo modifica metadata escalar autorizada; cambios de dominio usan comandos de intención explícitos.                                                     |
| **EC01-DA-027** | OUTBOX PENDING ≠ CLAIMED. Dispatch multi-instancia usa SKIP LOCKED + lease + recovery; nunca selección sin ownership durable.                                                          |
| **EC01-DA-028** | IDEMPOTENCY IN_PROGRESS ≠ FOREVER. La adquisición tiene lease, owner, heartbeat/updated_at y recovery gobernado tras crash.                                                            |
| **EC01-DA-029** | HTTP RUNTIME ROLE ≠ MIGRATOR ROLE ≠ TECHNICAL WORKER ROLE. Credenciales y privilegios separados; runtime no posee tablas ni BYPASSRLS.                                                 |
| **EC01-DA-030** | BUSINESS KEY ≠ EDITABLE LABEL. program_code/module_code/pathway_code se vuelven inmutables cuando existe historia publicada.                                                           |
| **EC01-DA-031** | SCHEMA RELEASE ≠ APP RELEASE. Migraciones productivas siguen expand/contract y compatibilidad N/N-1; rollback destructivo no es estrategia.                                            |
| **EC01-DA-032** | OPENAPI/ASYNCAPI ≠ DOCUMENTATION ONLY. Son contratos ejecutables que generan clientes, contract tests y compatibility gates.                                                           |

## 0.4 Criterio de suficiencia FullStack y regla de plantilla

EC-01 V1.1 se considera suficiente cuando dos equipos Senior independientes pueden implementar el mismo comportamiento observable, invariantes físicos, contratos HTTP/eventos y estados de UI sin tomar decisiones arquitectónicas incompatibles. Cuando una decisión siga siendo institucionalmente variable debe estar parametrizada o documentada como ADR cerrado/abierto; nunca quedar implícita en el código.

| **REGLA DE PLANTILLA —** EC-02…EC-12 deben reproducir como mínimo: Aggregate Revision Contract, RLS defense-in-depth, state transition guards, business-key/lineage rules, durable idempotency, leased outbox, OperationStatus para 202/UNKNOWN_EFFECT, API paginada, Threat Model, Secure SDLC, expand/contract y bootstrap reproducible. Si un módulo no aplica alguna capacidad, debe documentar explícitamente la frontera. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.5 Matriz de cierre de hallazgos V1.1

| **Severidad** | **Hallazgo V1.0**                                          | **Cierre normativo V1.1**                                                                 |
|---------------|------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| P0            | Multi-tenancy dependía de filtros Backend.                 | RLS ENABLE+FORCE, TenantContext transaccional y roles DB separados.                       |
| P0            | ETag del root no cubría mutaciones de hijos.               | Lock/check del root + bump automático de aggregate revision ante cada child mutation.     |
| P0            | API insuficiente para todos los workspaces.                | Catálogo completo de comandos/queries/DTOs, paginación y OperationStatus.                 |
| P0            | Orden de grupos era global y el árbol podía ciclar.        | Orden sibling-scoped + trigger acíclico.                                                  |
| P0            | Triggers de ciclos podían fallar en UPDATE.                | El edge anterior se excluye explícitamente del recorrido.                                 |
| P0            | Lineage admitía self/orden incoherente.                    | Triggers exigen previous\<current\<superseding version.                                   |
| P0            | Future version vs current PUBLISHED ambiguo.               | Estado SCHEDULED inmutable; PUBLISHED sigue representando la versión actualmente vigente. |
| P0            | CredentialBlueprint parecía publicable independiente.      | Se integra al snapshot de ProgramVersion; se elimina receipt independiente.               |
| P0            | Publication receipt no era append-only.                    | Trigger UPDATE/DELETE forbidden + hash/canonical schema versions.                         |
| P1            | Idempotency/Outbox sin lease/recovery.                     | Owner, lease_until, recovery indexes y SKIP LOCKED.                                       |
| P1            | Threat Model/Secure SDLC incompletos.                      | Secciones implementables, gates y evidencias obligatorias.                                |
| P1            | Frontend/Deployment dejaban demasiadas decisiones locales. | Baseline FullStack, OpenAPI-generated client, state model y expand/contract N/N-1.        |
| P2            | Bootstrap y límites de capacidad no estaban cerrados.      | Developer bootstrap reproducible + budgets parametrizados y performance acceptance.       |

# 1. Índice operativo del documento

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal de reglas BR-EC01

- 10\. Casos de uso UC-EC01

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

\- 41. Contrato FullStack no negociable de implementación

# 2. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

EC-01 resuelve el problema de diseño repetible y auditable del catálogo de Educación Continua. Una universidad no puede tratar cada nueva ejecución como un curso improvisado independiente, porque eso duplica definiciones, rompe comparabilidad histórica, dificulta certificación, impide stacking y hace imposible conocer exactamente qué contenido normativo recibió una cohorte anterior.

El módulo separa identidad estable de producto, versión académica inmutable, módulos reutilizables, estructura, outcomes, competencias, requisitos y blueprints de credenciales. Esta semántica permite que EC-02 abra muchas ediciones sobre la misma versión sin duplicar el diseño y que una evolución curricular futura cree una nueva ProgramVersion sin alterar hechos históricos.

## 2.1 Incluido

- CRUD gobernado de ProgramDefinition en estado editable y lifecycle del portafolio.

- Versionado de ProgramVersion con validación, revisión, aprobación, publicación, supersede y void gobernado.

- Definición reusable de LearningModuleDefinition y LearningModuleVersion.

- Estructuras modulares obligatorias, optativas, por elección mínima/máxima y secuencia ordenada.

- Grafo de prerrequisitos/co-requisitos internos con detección de ciclos.

- Program outcomes, module outcomes y bindings a competencias institucionales.

- Carga académica por horas y créditos opcionales cuando el tenant los utilice.

- Modalidades admitidas a nivel de versión como intención; la ejecución concreta pertenece a EC-02.

- ProgramRequirements que enlazan con CT-15 sin duplicar el motor de elegibilidad.

- CredentialBlueprint para certificate/badge/microcredential/cumulative credential sin emisión.

- CredentialPathwayDefinition versionada y grafo de stacking.

- DesignChangeRequest y receipts de publicación.

- Comparación/diff de versiones y simulación de impacto downstream.

- IA asistiva vía CT-12 para borradores, detección de inconsistencias y comparación; nunca aprobación automática.

- APIs, eventos, outbox/inbox, observabilidad, seguridad, QA, UAT y migración.

## 2.2 Fuera de alcance

- Crear ProgramEdition, Offering, cohorte operativa o calendario — EC-02 + CT-03.

- Definir pricing, promociones, becas o condiciones comerciales — EC-03/Finanzas.

- Registrar participantes, cupos, waitlist o enrollment — EC-04.

- Asignar instructores, materiales finales o aula — EC-05/CT-18.

- Registrar asistencia o engagement — EC-06.

- Evaluar participantes, aprobar o cerrar completion — EC-07.

- Emitir/void certificados o credenciales — EC-08 + CT-05.

- Mantener progreso individual de stackable credentials — EC-10.

- Crear personas, usuarios, permisos base o relaciones laborales — CT-04/IAM/RRHH.

- Guardar PDFs, blobs o documentos firmados — CT-05.

- Implementar workflow, notificación, scheduling, recursos, BI, IA o migración como mini-sistemas locales — CT correspondientes.

| **ANTI-SCOPE —** EC-01 no debe convertirse en un “constructor universal de cursos” que almacena precio, docentes, aulas, fechas, participantes y certificados dentro de ProgramVersion. Cada una de esas verdades tiene owner distinto. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Término**              | **Definición normativa**                                                                                                                |
|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| ProgramDefinition        | Identidad académica estable de un producto EC a través del tiempo; conserva código, familia y ownership, no fechas de ejecución.        |
| ProgramVersion           | Snapshot académico versionado publicable: nombre oficial, propósito, outcomes, estructura, carga, requisitos y políticas referenciadas. |
| ProgramEdition           | Ejecución concreta de una ProgramVersion; pertenece a EC-02.                                                                            |
| Offering                 | Presentación comercial/operativa de una edición a un segmento/canal; pertenece a EC-02/03 según contrato.                               |
| LearningModuleDefinition | Identidad reusable de una unidad académica diseñada para incorporarse a uno o más programas.                                            |
| LearningModuleVersion    | Snapshot versionado del módulo con título, horas, outcomes y reglas académicas propias.                                                 |
| ProgramStructureGroup    | Grupo estructural dentro de una ProgramVersion: troncal, optativo, etapa, bloque o colección con cardinalidad.                          |
| ProgramStructureItem     | Inserción concreta de una LearningModuleVersion en la estructura de una ProgramVersion.                                                 |
| StructureDependency      | Arista de prerequisito/co-requisito entre structure items de la misma ProgramVersion.                                                   |
| ProgramOutcome           | Resultado de aprendizaje esperado a nivel de programa; no es resultado obtenido por un participante.                                    |
| ModuleOutcome            | Resultado de aprendizaje esperado a nivel de módulo.                                                                                    |
| CompetencyBinding        | Vínculo contextual entre un outcome/programa y una competencia gobernada externamente.                                                  |
| ProgramRequirement       | Requisito declarado por EC-01 cuya evaluación operativa se delega a CT-15.                                                              |
| EligibilityRuleRef       | Referencia estable/versionada al contrato/regla de CT-15.                                                                               |
| CredentialBlueprint      | Definición académica de una credencial potencial asociada a una ProgramVersion; no representa emisión.                                  |
| CredentialRequirement    | Condición que debe satisfacer el award de la credencial; se compone sobre hechos del diseño.                                            |
| CredentialAward          | Hecho individual de adjudicación; pertenece a EC-08.                                                                                    |
| PathwayDefinition        | Identidad de una ruta acumulable/stackable.                                                                                             |
| PathwayVersion           | Snapshot versionado del grafo de credenciales/programas y reglas de stacking.                                                           |
| PathwayNode              | Nodo de una ruta, pudiendo apuntar a blueprint EC local, ProgramVersion o credencial externa gobernada.                                 |
| PathwayEdge              | Relación de secuencia, prerequisito o alternativa entre nodos de la misma PathwayVersion.                                               |
| DesignChangeRequest      | Solicitud gobernada de modificación sobre diseño aprobado/publicado; se integra con CT-06.                                              |
| PublicationReceipt       | Prueba durable del contenido publicado: hash, actor, instante, policy snapshot y evidencia.                                             |
| PolicySnapshot           | Identificador/versiones de políticas que fundamentaron una publicación; permite reconstrucción histórica.                               |
| EXT REF                  | Referencia cross-context sin FK física; se valida mediante contrato/port y evidencia de resolución.                                     |
| UNKNOWN_EFFECT           | Estado de una integración remota cuando no puede saberse si el efecto ocurrió; exige reconciliation antes de retry.                     |

# 4. Bounded Context y matriz Source of Truth

EC-01 posee semántica de diseño académico, no las verdades transversales que consume. Cuando otro contexto es Source of Truth, EC-01 persiste únicamente identificadores externos, snapshots explícitamente autorizados y receipts necesarios para reconstrucción. Un snapshot histórico no convierte a EC-01 en dueño del dato externo.

Toda dependencia crítica debe declarar comportamiento cuando está UNAVAILABLE o STALE. Durante publish, un requisito externo indispensable debe resolverse fail-closed: una dependencia desconocida no se interpreta como válida. Para consultas, el Frontend puede mostrar STALE/PARTIAL con marca temporal y provenance.

| **Información**                            | **Source of Truth** | **EC-01 almacena**             | **EC-01 referencia**                  | **Regla**                                        |
|--------------------------------------------|---------------------|--------------------------------|---------------------------------------|--------------------------------------------------|
| Tenant, sede, campus, academic owner scope | CT-01               | No                             | tenant_id + scope refs                | tenant desde auth context; no FK cross-context.  |
| Catálogos y políticas versionadas          | CT-02               | Policy refs/snapshots mínimos  | policy/version refs                   | No hardcode de thresholds/tipos institucionales. |
| Calendarios/sesiones                       | CT-03               | No                             | calendar/session refs solo downstream | EC-01 no crea tiempo de ejecución.               |
| Persona canónica                           | CT-04               | No                             | subject refs                          | Solo actores/auditoría; no Person local.         |
| Documentos/evidencias                      | CT-05               | No blobs                       | evidence/document refs                | Hashes/refs, no binario.                         |
| Workflow/aprobación                        | CT-06               | resultado semántico mínimo     | workflow/task refs                    | EC-01 valida dominio; CT-06 orquesta.            |
| Notificaciones                             | CT-07               | No                             | request/receipt refs                  | Fallo de comunicación no revierte publish.       |
| Localización                               | CT-08               | default locale + keys          | translation refs                      | Traducción ≠ versión académica.                  |
| Integración/event contracts                | CT-09               | outbox/inbox local             | contract/message refs                 | At-least-once + dedup.                           |
| Auditoría/privacy                          | CT-10               | refs y business audit metadata | audit/evidence refs                   | PII mínima.                                      |
| Analítica/BI                               | CT-11               | produce hechos                 | dataset refs                          | Sin shadow BI.                                   |
| IA                                         | CT-12               | run/eval refs                  | AI run refs                           | Recommendation ≠ Decision.                       |
| Scheduling                                 | CT-13               | No                             | No en EC-01                           | Pertenece a EC-02/CT-13.                         |
| Recursos                                   | CT-14               | No                             | No en EC-01                           | Sin aulas/rooms.                                 |
| Elegibilidad                               | CT-15               | requirement binding            | eligibility_rule_ref                  | EC-01 declara, CT-15 evalúa.                     |
| Migración/DQ                               | CT-16               | receipts externos              | lineage/promotion refs                | Promoción por API/domain.                        |
| Continuidad                                | CT-17               | No                             | runbook/continuity refs               | No motor local.                                  |
| LMS/ecosistema externo                     | CT-18               | No                             | interoperability refs                 | EC-01 declara compatibility, no provisiona.      |
| ProgramDefinition/ProgramVersion           | EC-01               | Sí                             | —                                     | Source of Truth local.                           |
| LearningModuleDefinition/Version           | EC-01               | Sí                             | —                                     | Source of Truth local.                           |
| Program structure/outcomes                 | EC-01               | Sí                             | —                                     | Inmutables tras publish.                         |
| CredentialBlueprint                        | EC-01               | Sí                             | —                                     | Definición, no award/issuance.                   |
| CredentialAward/issuance                   | EC-08               | No                             | blueprint consumed downstream         | No emisión local.                                |
| Pathway definition                         | EC-01               | Sí                             | —                                     | Diseño del grafo.                                |
| Participant pathway progress               | EC-10               | No                             | pathway_version_ref                   | No progreso individual local.                    |
| Precio/deuda/pago/factura                  | Finanzas/EC-03      | No                             | pricing/financial refs downstream     | Academic system ≠ financial ledger.              |

# 5. Dependencias CT-01 a CT-18, cores y otros módulos

| **Dependencia** | **Responsabilidad**                | **Contrato EC-01**                                                     | **Frontera/fallo**                                            |
|-----------------|------------------------------------|------------------------------------------------------------------------|---------------------------------------------------------------|
| CT-01           | Scope institucional/ownership      | academic_owner_scope_ref; validación de tenant/scope                   | Fail-closed en publish.                                       |
| CT-02           | Catálogos/policies                 | tipos, niveles, policy refs, policy snapshot                           | Cacheable con versioning.                                     |
| CT-03           | Temporalidad                       | Solo semantics de vigencia; no sesiones                                | No dependency runtime crítica salvo calendar refs opcionales. |
| CT-04           | Persona                            | actor refs provienen de IAM/CT-04 cuando corresponda                   | No Person local.                                              |
| CT-05           | Evidence/documents                 | approval evidence, attachments, publication pack                       | No blobs.                                                     |
| CT-06           | Workflow                           | review/approval/change request                                         | Workflow no define invariantes académicas.                    |
| CT-07           | Notifications                      | publish/review notifications                                           | Post-commit; no rollback.                                     |
| CT-08           | i18n                               | translation keys/localized resources                                   | Canonical language + overlays.                                |
| CT-09           | Integration governance             | events/contracts                                                       | Outbox/inbox.                                                 |
| CT-10           | Security/audit/privacy             | evidence refs, reason codes                                            | Critical audit.                                               |
| CT-11           | Analytics                          | program/version facts                                                  | Event-fed datasets.                                           |
| CT-12           | AI                                 | draft/summarize/diff/mapping                                           | Human approval mandatory.                                     |
| CT-13           | Scheduling                         | No authoring local                                                     | Consumed by EC-02 only.                                       |
| CT-14           | Resources                          | No resource tables                                                     | Consumed by EC-02.                                            |
| CT-15           | Eligibility                        | requirement binding and simulation                                     | Rule ownership CT-15.                                         |
| CT-16           | Migration                          | staging/dry-run/promotion                                              | No direct INSERT.                                             |
| CT-17           | Continuity                         | RTO/RPO/runbooks                                                       | Read-only degraded mode possible.                             |
| CT-18           | External ecosystem                 | credential/LMS interoperability refs                                   | No vendor lock-in.                                            |
| IAM             | Authentication/MFA/technical roles | actor + assurance context                                              | Step-up for publish/supersede.                                |
| RRHH            | Employment facts                   | No persistence except instructor design refs if ever needed downstream | EC-01 does not assign instructors.                            |
| Finanzas        | Financial facts                    | None                                                                   | No price/payment.                                             |
| EC-02           | Edition/Offering                   | Consumes PUBLISHED ProgramVersion                                      | Must pin version id.                                          |
| EC-08           | Credential issuance                | Consumes PUBLISHED CredentialBlueprint                                 | Never infer from status only.                                 |
| EC-10           | Stacking/progress                  | Consumes PUBLISHED PathwayVersion                                      | Progress pins version.                                        |

# 6. Arquitectura funcional E2E y journeys

<img src="media/image1.png" style="width:7.05in;height:3.70511in" />

Figura 1 — EC-01 dentro de la vertical y CT

| **Journey**                 | **Flujo E2E**                                                                                                                                                                              |
|-----------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| J-EC01-01 Diseño inicial    | Portfolio Manager crea ProgramDefinition → diseñador crea ProgramVersion DRAFT → outcomes/módulos/estructura/requisitos → validate → review CT-06 → APPROVED → publish → receipt + outbox. |
| J-EC01-02 Nueva versión     | Clonar PUBLISHED V1 → DRAFT V2 con lineage → aplicar cambios → diff V1/V2 → impact simulation → review → publish V2 → V1 SUPERSEDED en la misma transacción.                               |
| J-EC01-03 Reuso de módulo   | Crear LearningModuleDefinition/Version → publicar → insertar misma ModuleVersion en múltiples ProgramVersion sin duplicar contenido; evolución del módulo crea nueva version.              |
| J-EC01-04 Microcredencial   | ProgramVersion define CredentialBlueprint y requirements → publish → EC-08 consume blueprint → award/issuance ocurre fuera de EC-01.                                                       |
| J-EC01-05 Ruta stackable    | Crear PathwayDefinition/V1 → agregar nodos y edges → cycle validation → publish → EC-10 usa version pinneada para progreso.                                                                |
| J-EC01-06 Cambio urgente    | Se detecta error en PUBLISHED → DesignChangeRequest + CT-06 → si material, clone nueva version; si requiere void, comando con step-up y reason → no UPDATE destructivo.                    |
| J-EC01-07 Dependencia caída | CT-02/15 no responde en publish → no asumir policy favorable → estado permanece APPROVED/IN_REVIEW; frontend muestra UNAVAILABLE y correlationId.                                          |
| J-EC01-08 IA asistiva       | Diseñador solicita sugerencias → CT-12 produce recommendation con run_ref/grounding/confidence → usuario acepta/edita explícitamente → publish sigue requiriendo aprobación humana.        |

# 7. Modelo de dominio: Aggregates, Entities, Value Objects, Policies y Domain Services

<img src="media/image2.png" style="width:6.95in;height:4.84666in" />

Figura 2 — Modelo de dominio lógico EC-01

## 7.1 Aggregate Root — ProgramDefinition

ProgramDefinition es la identidad estable del producto formativo. Controla code uniqueness por tenant, ownership académico y lifecycle del producto. No contiene toda la versión curricular porque su misión es sobrevivir a múltiples evoluciones. Las operaciones de cambio material crean ProgramVersion; la eliminación destructiva se prohíbe una vez existe historia publicada.

## 7.2 Aggregate — ProgramVersion

ProgramVersion encapsula el snapshot académico publicable y gobierna composición de outcomes, modalidades admitidas, competency bindings, grupos/items de estructura, dependencias, requisitos y CredentialBlueprint asociados. Antes de publish se ejecuta una validación de consistencia global; después de PUBLISHED el root y todos sus hijos quedan inmutables en dominio y PostgreSQL.

## 7.3 Aggregate — LearningModuleDefinition

LearningModuleDefinition permite reuso explícito. Cada LearningModuleVersion tiene su propia carga académica y outcomes. El programa inserta una versión concreta; por tanto una actualización futura del módulo no modifica programas ya publicados. Esta separación evita el anti-pattern de referencias “latest” no deterministas.

## 7.4 Aggregate — PathwayDefinition

PathwayDefinition modela rutas acumulables de credenciales o programas. La PathwayVersion contiene nodos y aristas; PUBLISHED se congela. EC-10 debe persistir el pathway_version_id utilizado para calcular progreso, evitando que un cambio de ruta altere retrospectivamente el status individual.

## 7.5 Value Objects

| **Value Object**  | **Semántica**                                                                                  |
|-------------------|------------------------------------------------------------------------------------------------|
| AcademicHours     | Cantidad positiva + unidad institucional; normalizada a horas decimales y redondeo por policy. |
| CreditValue       | Valor decimal opcional + credit_scheme_code; ambos presentes o ambos ausentes.                 |
| VersionNumber     | Entero positivo monotónico dentro de una Definition.                                           |
| ProgramCode       | Business key tenant-aware, normalizado, estable y no reutilizable sobre historia publicada.    |
| ContentHash       | SHA-256 u algoritmo institucional sobre snapshot canónico para demostrar integridad.           |
| PolicyRef         | policy_id + version/effective context; no porcentaje hardcodeado.                              |
| ExternalRef       | UUID/opaque ID + contract authority; jamás FK cross-context.                                   |
| LocalizedTextRef  | Clave/namespace CT-08 + canonical fallback.                                                    |
| RequirementTarget | Union tipada que obliga a un único target compatible con requirement_kind.                     |

## 7.6 Domain Policies

- ProgramPublicationPolicy — determina precondiciones obligatorias para publicar.

- VersionSupersedePolicy — decide si Vn puede reemplazar Vn-1 y exige lineage.

- StructureIntegrityPolicy — cardinalidades, horas, duplicados y grafo acíclico.

- CredentialBlueprintPolicy — consistencia entre requirements, credential_type y ProgramVersion.

- PathwayIntegrityPolicy — grafo acíclico cuando el tipo de ruta lo exige, targets resolubles y reglas de stacking.

- MaterialChangePolicy — clasifica cambios que obligan a nueva versión vs corrección no material permitida en draft.

- CompliancePublicationPolicy — incorpora compliance_profile_ref y policy snapshot aplicable.

## 7.7 Domain Services

- VersionDiffService — diff semántico determinista entre snapshots.

- PublicationValidationService — orquesta validadores locales + resoluciones CT requeridas.

- StructureGraphService — detecta ciclos, nodos huérfanos y caminos inválidos.

- PathwayGraphService — valida route graph y targets.

- ImpactSimulationService — identifica ediciones/blueprints/pathways downstream potencialmente afectados, sin ejecutar cambios.

## 7.8 Aggregate Revision Contract — patrón obligatorio V1.1

El campo version de ProgramVersion, LearningModuleVersion y PathwayVersion representa la revisión observable del aggregate completo, no únicamente la fila root. Para mutar cualquier hijo, la capa Application bloquea el root (SELECT … FOR UPDATE o mecanismo equivalente), compara If-Match contra la revisión actual y solo entonces ejecuta el comando. Los triggers de hijos incrementan version y updated_at del root dentro de la misma transacción. Si dos comandos parten del mismo ETag, el segundo debe resolver 412 PRECONDITION_FAILED.

| **Paso**                                                                                                                                                                                                                  | **Contrato**                                                            |     |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------|-----|
| 1                                                                                                                                                                                                                         | Resolver tenant desde Security/TenantContext; nunca desde body.         |     |
| 2                                                                                                                                                                                                                         | Abrir transacción y establecer SET LOCAL peopleu.tenant_id.             |     |
| 3                                                                                                                                                                                                                         | Cargar/lock root y comparar expected aggregate revision (If-Match).     |     |
| 4                                                                                                                                                                                                                         | Ejecutar método de intención; no setters ni repository child directo.   |     |
| 5                                                                                                                                                                                                                         | Persistir hijo(s); trigger bump del root en la misma transacción.       |     |
| 6                                                                                                                                                                                                                         | Registrar audit/outbox/idempotency cuando aplique y commit.             |     |
| 7                                                                                                                                                                                                                         | Responder ETag nuevo. Si revisión no coincide: 412 sin aplicar efectos. |     |
| **PRUEBA NO NEGOCIABLE —** Dos usuarios abren ETag 7. A modifica un outcome y el aggregate queda en ETag 8. B intenta modificar estructura con If-Match 7: debe recibir 412 aunque B haya tocado una tabla hija distinta. |                                                                         |     |

# 8. Máquinas de estado normativas

<img src="media/image3.png" style="width:7.05in;height:3.48382in" />

Figura 3 — Estado versionado normativo

| **Aggregate**            | **Estados/transiciones**                                                 | **Invariante**                                                                                               |
|--------------------------|--------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| ProgramDefinition        | DRAFT → ACTIVE → SUSPENDED → RETIRED                                     | RETIRED no elimina versiones ni history; reactivación exige policy/reason.                                   |
| ProgramVersion           | DRAFT → IN_REVIEW → APPROVED → PUBLISHED → SUPERSEDED; VOID excepcional  | PUBLISHED immutable; nueva publish supersede la anterior en atomic transaction.                              |
| LearningModuleDefinition | DRAFT → ACTIVE → SUSPENDED → RETIRED                                     | No impide uso histórico de versiones ya pinneadas.                                                           |
| LearningModuleVersion    | DRAFT → IN_REVIEW → APPROVED → PUBLISHED → SUPERSEDED; VOID              | Misma regla de inmutabilidad.                                                                                |
| CredentialBlueprint      | DRAFT → ACTIVE → RETIRED                                                 | Si su parent ProgramVersion está PUBLISHED, el contenido queda congelado; retirement futuro no borra awards. |
| PathwayDefinition        | DRAFT → ACTIVE → SUSPENDED → RETIRED                                     | Identidad estable.                                                                                           |
| PathwayVersion           | DRAFT → IN_REVIEW → APPROVED → PUBLISHED → SUPERSEDED; VOID              | Progreso individual pinnea la versión.                                                                       |
| DesignChangeRequest      | DRAFT → SUBMITTED → UNDER_REVIEW → APPROVED/REJECTED → APPLIED/CANCELLED | Workflow CT-06; APPLY genera command/version, no edit directo.                                               |

| **REGLA DE ESTADO —** Nunca implementar “status = PUBLISHED” como simple PATCH. Publish es un caso de uso transaccional con autorización, ETag, validation pack, policy snapshot, content hash, publication receipt y outbox. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 8.1 State machine física V1.1 — ProgramVersion

| **Desde**  | **Hacia permitidos**                 | **Semántica**                                                                                |
|------------|--------------------------------------|----------------------------------------------------------------------------------------------|
| DRAFT      | IN_REVIEW · VOID                     | Único estado donde puede mutar contenido académico.                                          |
| IN_REVIEW  | DRAFT · APPROVED · VOID              | Snapshot bajo revisión; editar exige volver a DRAFT.                                         |
| APPROVED   | DRAFT · SCHEDULED · PUBLISHED · VOID | Aprobado no se edita; puede programarse o publicarse.                                        |
| SCHEDULED  | PUBLISHED · VOID                     | Snapshot inmutable para vigencia futura; EC-02 puede pinnear futuras ediciones según policy. |
| PUBLISHED  | SUPERSEDED · VOID                    | Versión vigente; contenido inmutable.                                                        |
| SUPERSEDED | —                                    | Terminal, histórica y referenciable.                                                         |
| VOID       | —                                    | Terminal; nunca hard-delete.                                                                 |

## 8.2 Publication vs effectivity

SCHEDULED resuelve la necesidad de comprometer una versión futura sin retirar prematuramente la versión vigente. SCHEDULED exige content_hash, published_at/published_by_subject y valid_from. La activación SCHEDULED→PUBLISHED y el supersede de la versión vigente se realizan en una única transacción local, con receipt/outbox/audit. valid_to de la versión previa solo puede cerrarse como parte de PUBLISHED→SUPERSEDED; no es un campo editable libre.

# 9. Catálogo formal de reglas BR-EC01

| **ID**          | **Nombre**                      | **Regla implementable/verificable**                                                                                                    |
|-----------------|---------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| **BR-EC01-001** | Tenant obligatorio              | Todo aggregate y tabla transaccional EC-01 posee tenant_id del contexto autorizado; el body no puede elegir tenant.                    |
| **BR-EC01-002** | Código de programa único        | program_code es único por tenant y no se reutiliza para otra identidad después de publicación.                                         |
| **BR-EC01-003** | Identidad estable               | ProgramDefinition no incorpora fechas, cupos, precios, docentes ni participantes de una ejecución.                                     |
| **BR-EC01-004** | Versión positiva                | version_no inicia en 1 y es único por ProgramDefinition.                                                                               |
| **BR-EC01-005** | Lineage de versión              | Una versión \>1 debe declarar previous_version_id del mismo ProgramDefinition salvo importación certificada con reason code.           |
| **BR-EC01-006** | Una publicada vigente           | Solo puede existir una ProgramVersion PUBLISHED por ProgramDefinition; la nueva publicación supersede la anterior atómicamente.        |
| **BR-EC01-007** | Inmutabilidad publicada         | PUBLISHED/SUPERSEDED no admite mutaciones de contenido ni de hijos; correcciones materiales crean nueva versión.                       |
| **BR-EC01-008** | Hash de contenido               | Publish calcula y persiste content_hash canónico; el receipt usa el mismo hash.                                                        |
| **BR-EC01-009** | Aprobación previa               | Solo APPROVED puede pasar a PUBLISHED salvo flujo excepcional definido por policy con evidencia equivalente.                           |
| **BR-EC01-010** | Step-up en publish              | Publicar, superseder o void requiere assurance/step-up configurado.                                                                    |
| **BR-EC01-011** | SoD configurable                | El actor que diseñó materialmente una versión no puede ser su único aprobador cuando policy institucional exige separación.            |
| **BR-EC01-012** | Horas positivas                 | academic_hours \> 0 en ProgramVersion publicable.                                                                                      |
| **BR-EC01-013** | Créditos coherentes             | credits y credit_scheme_code son ambos NULL o ambos presentes; credits \> 0.                                                           |
| **BR-EC01-014** | Vigencia coherente              | valid_to, cuando exista, no puede ser anterior a valid_from.                                                                           |
| **BR-EC01-015** | Tipo parametrizable             | program_family_code/program_type_code se resuelven por CT-02; no se hardcodean en Java.                                                |
| **BR-EC01-016** | Owner scope válido              | academic_owner_scope_ref debe existir y ser accesible en CT-01 al publicar.                                                            |
| **BR-EC01-017** | Idioma canónico                 | default_language_code debe ser soportado por tenant; overlays CT-08 no crean otra ProgramVersion.                                      |
| **BR-EC01-018** | Outcome identificable           | Cada ProgramOutcome tiene outcome_code único dentro de la ProgramVersion.                                                              |
| **BR-EC01-019** | Outcome no vacío                | statement no puede ser blank y debe cumplir longitud/policy editorial.                                                                 |
| **BR-EC01-020** | Outcome versionado              | Modificar un outcome de PUBLISHED requiere nueva ProgramVersion.                                                                       |
| **BR-EC01-021** | Competencia externa             | competency_ref se valida por contrato; EC-01 no crea catálogo sombra.                                                                  |
| **BR-EC01-022** | Binding único                   | No se repite la misma competency_ref/level para el mismo outcome cuando la policy lo considera equivalente.                            |
| **BR-EC01-023** | Módulo identificable            | module_code es único por tenant dentro de LearningModuleDefinition.                                                                    |
| **BR-EC01-024** | Versión de módulo única         | module_version_no es único por LearningModuleDefinition.                                                                               |
| **BR-EC01-025** | Module lineage                  | previous_module_version_id debe pertenecer a la misma LearningModuleDefinition.                                                        |
| **BR-EC01-026** | Módulo publicado inmutable      | LearningModuleVersion PUBLISHED/SUPERSEDED y sus outcomes son inmutables.                                                              |
| **BR-EC01-027** | Horas del módulo                | module_hours \> 0 para versión publicable.                                                                                             |
| **BR-EC01-028** | Créditos módulo                 | module_credits sigue la misma coherencia de scheme que ProgramVersion.                                                                 |
| **BR-EC01-029** | Reuso pinneado                  | ProgramStructureItem referencia una LearningModuleVersion concreta, nunca “latest”.                                                    |
| **BR-EC01-030** | Item único                      | La misma ModuleVersion no se duplica en un ProgramVersion salvo policy explícita y slot semánticamente distinto.                       |
| **BR-EC01-031** | Grupo pertenece a versión       | Todos los structure groups/items/dependencies deben pertenecer a una única ProgramVersion tenant-aware.                                |
| **BR-EC01-032** | Cardinalidad de grupo           | min_items \>= 0, max_items \>= min_items cuando max exista.                                                                            |
| **BR-EC01-033** | Secuencia válida                | sequence_no es positivo y único dentro del grupo cuando aplique.                                                                       |
| **BR-EC01-034** | No self prerequisite            | Un structure item no puede ser prerequisito de sí mismo.                                                                               |
| **BR-EC01-035** | Grafo acíclico                  | PRECONDITION/SEQUENCE no puede introducir ciclos en structure dependency.                                                              |
| **BR-EC01-036** | Corequisito explícito           | CO_REQUISITE es distinto de PRE_REQUISITE y se procesa según policy.                                                                   |
| **BR-EC01-037** | Suma de horas verificable       | Publish calcula summary de horas y compara con academic_hours según tolerance policy.                                                  |
| **BR-EC01-038** | Modalidad admitida              | Delivery mode binding expresa modalidades permitidas por diseño; no agenda sesiones.                                                   |
| **BR-EC01-039** | Modalidad parametrizada         | delivery_mode_code proviene de CT-02; no enum cerrado en código.                                                                       |
| **BR-EC01-040** | Requisito declara, CT-15 decide | ProgramRequirement conserva eligibility_rule_ref; EC-01 no implementa el motor de elegibilidad.                                        |
| **BR-EC01-041** | Requisito versionado            | Cambiar requirements en PUBLISHED exige nueva ProgramVersion.                                                                          |
| **BR-EC01-042** | Target de requisito consistente | Cada requisito de credencial tiene exactamente un target compatible con requirement_kind.                                              |
| **BR-EC01-043** | Blueprint pertenece a versión   | CredentialBlueprint está ligado a una única ProgramVersion y no migra silenciosamente entre versiones.                                 |
| **BR-EC01-044** | Blueprint no emite              | Ningún estado de CredentialBlueprint crea CredentialAward o PDF.                                                                       |
| **BR-EC01-045** | Blueprint único                 | credential_code es único dentro de la ProgramVersion.                                                                                  |
| **BR-EC01-046** | Policy de credencial            | validity/evidence/verification se referencian a políticas/perfiles; no se hardcodean.                                                  |
| **BR-EC01-047** | Blueprint inmutable con parent  | Si ProgramVersion está PUBLISHED/SUPERSEDED, blueprint y requirements asociados son inmutables.                                        |
| **BR-EC01-048** | Pathway identificable           | pathway_code es único por tenant.                                                                                                      |
| **BR-EC01-049** | Pathway versionado              | pathway_version_no es único y monotónico dentro de PathwayDefinition.                                                                  |
| **BR-EC01-050** | Pathway lineage                 | previous_pathway_version_id pertenece a la misma PathwayDefinition.                                                                    |
| **BR-EC01-051** | Pathway pinneado                | EC-10 debe consumir pathway_version_id explícito; nunca resolver latest para historia.                                                 |
| **BR-EC01-052** | Nodo tipado                     | PathwayNode tiene exactamente un target compatible con node_type.                                                                      |
| **BR-EC01-053** | Edge same version               | source_node y target_node pertenecen a la misma PathwayVersion.                                                                        |
| **BR-EC01-054** | No self edge                    | Un PathwayEdge no puede apuntar el nodo a sí mismo.                                                                                    |
| **BR-EC01-055** | Grafo de ruta válido            | Edges de prerequisito/secuencia no pueden producir ciclo cuando el pathway_type lo prohíbe.                                            |
| **BR-EC01-056** | External credential gobernada   | external_credential_ref se resuelve vía contrato CT-18/registro aprobado; no free text.                                                |
| **BR-EC01-057** | Stacking no equivale grado      | Satisfacer una ruta EC no crea crédito/degree PG/PO automáticamente.                                                                   |
| **BR-EC01-058** | Idempotencia publish            | Publish exige Idempotency-Key durable y same-key/same-payload replay devuelve mismo resultado.                                         |
| **BR-EC01-059** | Idempotency conflict            | Same key con payload distinto produce 409 IDEMPOTENCY_KEY_REUSED.                                                                      |
| **BR-EC01-060** | Optimistic lock                 | Mutaciones de aggregates editables requieren If-Match/ETag; mismatch produce 412.                                                      |
| **BR-EC01-061** | No last write wins              | Conflictos de versión no se resuelven silenciosamente.                                                                                 |
| **BR-EC01-062** | Outbox atómica                  | Publish/supersede/void persiste hechos + receipt + outbox en la misma transacción.                                                     |
| **BR-EC01-063** | Inbox dedup                     | Consumidores EC-01 usan inbox/message_id para comandos/eventos externos idempotentes.                                                  |
| **BR-EC01-064** | At-least-once                   | No se promete exactly-once distribuido; se usa idempotency + reconciliation.                                                           |
| **BR-EC01-065** | UNKNOWN_EFFECT                  | Si una integración remota crítica puede haber aplicado efecto y se pierde respuesta, se reconcilia antes de retry.                     |
| **BR-EC01-066** | Fail closed publish             | Policy/eligibility/compliance crítica UNAVAILABLE impide publish; no se interpreta como válida.                                        |
| **BR-EC01-067** | UI state explícito              | NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT no son intercambiables.                                                    |
| **BR-EC01-068** | Audit crítico                   | Create review approve publish supersede void y cambio estructural registran actor, scope, reason, correlation, policy y evidence refs. |
| **BR-EC01-069** | PII minimization                | EC-01 no almacena datos personales de participantes porque no son necesarios para diseño.                                              |
| **BR-EC01-070** | No blobs                        | Archivos y evidencias viven en CT-05; PostgreSQL solo guarda refs/hash/metadata de negocio.                                            |
| **BR-EC01-071** | Migración gobernada             | Legacy entra por CT-16 Extract→Normalize→Map→Validate→Dry-run→Promote→Receipt→Reconcile.                                               |
| **BR-EC01-072** | IA con provenance               | Toda sugerencia IA conserva run_ref, model/template/eval refs, grounding, confidence y reviewer outcome.                               |
| **BR-EC01-073** | IA no publica                   | IA nunca aprueba ni publica ProgramVersion/ModuleVersion/PathwayVersion.                                                               |
| **BR-EC01-074** | Tiempo UTC                      | Instantes oficiales usan timestamptz UTC; fechas académicas sin hora usan date solo cuando la semántica realmente es de fecha.         |
| **BR-EC01-075** | No hard delete histórico        | Published/Superseded/PublicationReceipt nunca se borran por API ordinaria.                                                             |
| **BR-EC01-076** | Void con reason                 | VOID requiere reason_code, actor autorizado, step-up y evidencia cuando policy lo exija.                                               |
| **BR-EC01-077** | Reconstructibilidad             | Toda publicación debe poder reconstruirse años después con snapshot, hashes, policy versions y lineage.                                |
| **BR-EC01-078** | Tenant RLS obligatorio          | Toda tabla tenant-owned de EC-01 debe usar ENABLE+FORCE RLS; el runtime HTTP no posee tablas ni BYPASSRLS.                             |
| **BR-EC01-079** | Aggregate revision completa     | Toda mutación de hijo incrementa version del root dentro de la misma transacción.                                                      |
| **BR-EC01-080** | Child command requiere If-Match | Las mutaciones de hijos exigen expected root revision; mismatch produce 412.                                                           |
| **BR-EC01-081** | Orden de grupos por hermanos    | sequence_no de StructureGroup es único entre raíces o entre hijos del mismo parent; no global a la versión.                            |
| **BR-EC01-082** | Árbol de grupos acíclico        | No puede existir ciclo directo o indirecto en parent_group_id.                                                                         |
| **BR-EC01-083** | Edge update cycle-safe          | La validación de ciclos excluye el edge antiguo durante UPDATE.                                                                        |
| **BR-EC01-084** | Lineage monotónico              | previous version debe tener número menor y superseding version número mayor; self-reference prohibida.                                 |
| **BR-EC01-085** | SCHEDULED inmutable             | ProgramVersion SCHEDULED es snapshot comprometido y no admite edición de contenido.                                                    |
| **BR-EC01-086** | Blueprint no publica solo       | CredentialBlueprint se publica únicamente como parte del snapshot de ProgramVersion.                                                   |
| **BR-EC01-087** | Receipt append-only             | PublicationReceipt no admite UPDATE/DELETE y declara algoritmo/hash/canonical schema version.                                          |
| **BR-EC01-088** | Policy ref versionada           | Todo \*\_policy_ref debe apuntar a PolicyVersion inmutable o contrato equivalente de CT-02.                                            |
| **BR-EC01-089** | Idempotency lease recovery      | IN_PROGRESS debe poseer lease; lease vencido se recupera gobernadamente sin duplicar efecto.                                           |
| **BR-EC01-090** | Outbox lease                    | Un evento IN_FLIGHT debe tener owner/lease y ser reclamable tras vencimiento.                                                          |
| **BR-EC01-091** | Outbox claiming seguro          | Dispatch multi-instancia usa FOR UPDATE SKIP LOCKED o patrón equivalente probado.                                                      |
| **BR-EC01-092** | Business key estable            | program_code/module_code/pathway_code no cambian después de historia publicada.                                                        |
| **BR-EC01-093** | API list bounded                | Toda colección REST define pageSize máximo, sorting estable, filtros y límites.                                                        |
| **BR-EC01-094** | 202 requiere OperationStatus    | Toda respuesta 202 incluye operationId consultable hasta estado terminal.                                                              |
| **BR-EC01-095** | PATCH limitado                  | PATCH no puede ejecutar transiciones ni mutaciones estructurales; usa comandos de intención.                                           |
| **BR-EC01-096** | OpenAPI client único            | Frontend consume DTOs/client generado desde OpenAPI; prohibido duplicar contratos manuales.                                            |
| **BR-EC01-097** | Expand/contract                 | Toda migración productiva mantiene compatibilidad N/N-1 y evita cambios destructivos en un solo release.                               |
| **BR-EC01-098** | Secure SDLC gate                | High/Critical SAST/SCA/secret/container findings bloquean release salvo excepción formal aprobada.                                     |
| **BR-EC01-099** | Capacity budgets                | Tamaños máximos de grafos, payloads y pageSize se parametrizan; superar límite devuelve rechazo de negocio/429 según contrato.         |

# 10. Casos de uso UC-EC01

| **ID**          | **Caso de uso**                                 | **Actor primario**          |
|-----------------|-------------------------------------------------|-----------------------------|
| **UC-EC01-001** | Crear ProgramDefinition                         | Portfolio Manager           |
| **UC-EC01-002** | Modificar ProgramDefinition editable            | Portfolio Manager           |
| **UC-EC01-003** | Activar/Suspender/Retirar ProgramDefinition     | Academic Governance         |
| **UC-EC01-004** | Crear ProgramVersion inicial                    | Academic Designer           |
| **UC-EC01-005** | Clonar ProgramVersion publicada                 | Academic Designer           |
| **UC-EC01-006** | Editar metadata académica de ProgramVersion     | Academic Designer           |
| **UC-EC01-007** | Gestionar modalidades admitidas                 | Academic Designer           |
| **UC-EC01-008** | Gestionar ProgramOutcomes                       | Academic Designer           |
| **UC-EC01-009** | Vincular competencias                           | Academic Designer           |
| **UC-EC01-010** | Crear LearningModuleDefinition                  | Academic Designer           |
| **UC-EC01-011** | Crear LearningModuleVersion                     | Academic Designer           |
| **UC-EC01-012** | Gestionar ModuleOutcomes                        | Academic Designer           |
| **UC-EC01-013** | Crear grupos de estructura                      | Curriculum Designer         |
| **UC-EC01-014** | Agregar módulos a estructura                    | Curriculum Designer         |
| **UC-EC01-015** | Reordenar estructura                            | Curriculum Designer         |
| **UC-EC01-016** | Definir prerrequisitos/corequisitos             | Curriculum Designer         |
| **UC-EC01-017** | Gestionar requisitos del programa               | Academic Designer           |
| **UC-EC01-018** | Crear CredentialBlueprint                       | Credential Designer         |
| **UC-EC01-019** | Definir requirements de credencial              | Credential Designer         |
| **UC-EC01-020** | Crear PathwayDefinition                         | Pathway Designer            |
| **UC-EC01-021** | Crear PathwayVersion                            | Pathway Designer            |
| **UC-EC01-022** | Gestionar nodos/edges de ruta                   | Pathway Designer            |
| **UC-EC01-023** | Validar ProgramVersion                          | Academic Designer           |
| **UC-EC01-024** | Solicitar revisión                              | Academic Designer           |
| **UC-EC01-025** | Aprobar/Rechazar revisión                       | Academic Approver           |
| **UC-EC01-026** | Publicar ProgramVersion                         | Academic Publisher          |
| **UC-EC01-027** | Publicar LearningModuleVersion                  | Academic Publisher          |
| **UC-EC01-028** | Publicar PathwayVersion                         | Academic Publisher          |
| **UC-EC01-029** | Comparar versiones                              | Reviewer/Designer           |
| **UC-EC01-030** | Simular impacto de cambio                       | Reviewer/Designer           |
| **UC-EC01-031** | Crear DesignChangeRequest                       | Authorized Staff            |
| **UC-EC01-032** | Aplicar change request aprobado                 | Academic Designer           |
| **UC-EC01-033** | Superseder versión                              | Academic Publisher          |
| **UC-EC01-034** | Void versión                                    | Academic Governance         |
| **UC-EC01-035** | Consultar catálogo publicado                    | EC-02/Staff                 |
| **UC-EC01-036** | Exportar design pack                            | Auditor/Staff               |
| **UC-EC01-037** | Solicitar asistencia IA                         | Academic Designer           |
| **UC-EC01-038** | Aceptar/Rechazar sugerencia IA                  | Academic Designer           |
| **UC-EC01-039** | Importar portfolio legacy dry-run               | Data Steward                |
| **UC-EC01-040** | Promover lote migrado                           | Data Steward                |
| **UC-EC01-041** | Reconciliar publicación/eventos                 | Ops                         |
| **UC-EC01-042** | Consultar lineage y receipts                    | Auditor                     |
| **UC-EC01-043** | Resolver conflicto ETag                         | Academic Designer           |
| **UC-EC01-044** | Retirar blueprint futuro                        | Credential Governance       |
| **UC-EC01-045** | Consultar dependencias downstream               | Portfolio Manager           |
| **UC-EC01-046** | Mutar outcome con If-Match de aggregate         | Curriculum Designer         |
| **UC-EC01-047** | Reordenar structure group sibling-scoped        | Curriculum Designer         |
| **UC-EC01-048** | Programar versión futura (SCHEDULED)            | Academic Approver/Publisher |
| **UC-EC01-049** | Activar versión programada y superseder vigente | Publisher/System Scheduler  |
| **UC-EC01-050** | Recuperar comando idempotente con lease vencido | Application Service         |
| **UC-EC01-051** | Claim/reclaim de outbox con lease               | Outbox Worker               |
| **UC-EC01-052** | Consultar OperationStatus                       | Frontend/Operator           |
| **UC-EC01-053** | Reconciliar operación asíncrona UNKNOWN_EFFECT  | Operator/System             |
| **UC-EC01-054** | Validar aislamiento RLS                         | Security/QA                 |

## 10.1 Casos críticos desarrollados

### UC-EC01-005 — Clonar ProgramVersion publicada

| **Aspecto**                   | **Detalle**                                                                                                                                                 |
|-------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Academic Designer                                                                                                                                           |
| Trigger                       | Necesidad de evolución de programa                                                                                                                          |
| Precondiciones / autorización | Versión origen PUBLISHED/SUPERSEDED; permiso en scope                                                                                                       |
| Happy Path                    | Crea nueva DRAFT con nuevo id/version_no, previous_version_id, copia estructural profunda y nuevo version=0; no copia receipts ni audit como hechos nuevos. |
| Alternativas / errores        | Si ya existe draft equivalente, policy puede rechazar 409 o devolver existente por idempotency.                                                             |
| Idempotencia                  | Idempotency-Key durable; clone nunca duplica bajo replay.                                                                                                   |
| Concurrencia                  | ETag de origen solo lectura; nuevo aggregate inicia 0.                                                                                                      |
| Auditoría / side effects      | Audit create + lineage; evento DraftVersionCreated opcional.                                                                                                |
| Postcondición                 | DRAFT independiente y origen intacto.                                                                                                                       |

### UC-EC01-023 — Validar ProgramVersion

| **Aspecto**                   | **Detalle**                                                                                                                                             |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Academic Designer/Reviewer                                                                                                                              |
| Trigger                       | Usuario solicita preflight                                                                                                                              |
| Precondiciones / autorización | DRAFT/IN_REVIEW y scope válido                                                                                                                          |
| Happy Path                    | Ejecuta validadores de schema, estructura, horas, outcomes, requirements, blueprint, cross-refs y policies; devuelve ValidationReport sin mutar estado. |
| Alternativas / errores        | CT-02/15 unavailable marca dependency issue; publish luego fail-closed.                                                                                 |
| Idempotencia                  | GET-like compute puede aceptar correlation; cache por content hash.                                                                                     |
| Concurrencia                  | Usa snapshot de versión; si cambia durante cálculo, response indica STALE.                                                                              |
| Auditoría / side effects      | Audit solo si se conserva validation pack; métricas de errores.                                                                                         |
| Postcondición                 | Reporte PASS/WARN/FAIL con reason codes.                                                                                                                |

### UC-EC01-024 — Solicitar revisión

| **Aspecto**                   | **Detalle**                                                                                            |
|-------------------------------|--------------------------------------------------------------------------------------------------------|
| Actor                         | Academic Designer                                                                                      |
| Trigger                       | Diseño listo                                                                                           |
| Precondiciones / autorización | DRAFT; validation sin FAIL; workflow template resoluble                                                |
| Happy Path                    | Transición a IN_REVIEW, crea case CT-06, congela review snapshot/hash, notifica vía CT-07 post-commit. |
| Alternativas / errores        | Si CT-06 falla sin efecto confirmado, queda DRAFT; si UNKNOWN_EFFECT, guarda receipt y reconcilia.     |
| Idempotencia                  | Idempotency-Key requerido.                                                                             |
| Concurrencia                  | If-Match obligatorio.                                                                                  |
| Auditoría / side effects      | Audit + outbox.                                                                                        |
| Postcondición                 | IN_REVIEW con workflow_ref.                                                                            |

### UC-EC01-025 — Aprobar/Rechazar revisión

| **Aspecto**                   | **Detalle**                                                                                                            |
|-------------------------------|------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Academic Approver                                                                                                      |
| Trigger                       | Task CT-06 resuelta                                                                                                    |
| Precondiciones / autorización | IN_REVIEW; actor autorizado; SoD satisfecha                                                                            |
| Happy Path                    | Consume resultado de workflow; valida hash no cambió; APPROVED o vuelve DRAFT/REJECTED lógico según policy con reason. |
| Alternativas / errores        | Hash cambiado =\> 409 REVIEW_SNAPSHOT_CHANGED.                                                                         |
| Idempotencia                  | Inbox dedup por messageId.                                                                                             |
| Concurrencia                  | Version check transaccional.                                                                                           |
| Auditoría / side effects      | Audit decision + evidence refs.                                                                                        |
| Postcondición                 | APPROVED listo para publish o DRAFT con observaciones.                                                                 |

### UC-EC01-026 — Publicar ProgramVersion

| **Aspecto**                   | **Detalle**                                                                                                                                               |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Academic Publisher                                                                                                                                        |
| Trigger                       | Versión aprobada para uso                                                                                                                                 |
| Precondiciones / autorización | APPROVED; step-up; validation PASS; CT refs resolubles                                                                                                    |
| Happy Path                    | Lock aggregate → revalidar → content hash → supersede PUBLISHED anterior → set PUBLISHED → publication receipt → outbox ProgramVersionPublished → commit. |
| Alternativas / errores        | Dependency critical unavailable =\> 503; duplicate idempotency replay returns same receipt; conflict concurrent publish =\> 409/412.                      |
| Idempotencia                  | Idempotency-Key obligatorio y durable.                                                                                                                    |
| Concurrencia                  | If-Match + DB unique one-published + row/advisory lock según implementation.                                                                              |
| Auditoría / side effects      | Audit publish, policy snapshot, assurance, evidence pack.                                                                                                 |
| Postcondición                 | Una única PUBLISHED vigente y receipt durable.                                                                                                            |

### UC-EC01-029 — Comparar versiones

| **Aspecto**                   | **Detalle**                                                                                                                 |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Reviewer                                                                                                                    |
| Trigger                       | Solicitud de diff                                                                                                           |
| Precondiciones / autorización | Ambas versiones accesibles mismo tenant                                                                                     |
| Happy Path                    | Normaliza snapshots y produce diff por metadata, outcomes, modules, hours, requirements, credential blueprints y path refs. |
| Alternativas / errores        | Refs externas no resolubles se muestran UNAVAILABLE/STALE, no iguales.                                                      |
| Idempotencia                  | Read-only; cache por pair hashes.                                                                                           |
| Concurrencia                  | No mutation.                                                                                                                |
| Auditoría / side effects      | CorrelationId; export opcional CT-05.                                                                                       |
| Postcondición                 | Diff explicable.                                                                                                            |

### UC-EC01-030 — Simular impacto

| **Aspecto**                   | **Detalle**                                                                                                                                                       |
|-------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Portfolio Manager                                                                                                                                                 |
| Trigger                       | Antes de publicar cambio                                                                                                                                          |
| Precondiciones / autorización | Draft + previous version                                                                                                                                          |
| Happy Path                    | Consulta consumers conocidos mediante contracts/read models: active/future editions, blueprints/pathways, integrations; clasifica breaking/nonbreaking potencial. |
| Alternativas / errores        | Dependencia unavailable produce PARTIAL, nunca “sin impacto”.                                                                                                     |
| Idempotencia                  | Read-only; result includes asOf/provenance.                                                                                                                       |
| Concurrencia                  | Snapshot-aware.                                                                                                                                                   |
| Auditoría / side effects      | Evidence si se adjunta al workflow.                                                                                                                               |
| Postcondición                 | ImpactReport con unresolved dependencies.                                                                                                                         |

### UC-EC01-034 — Void versión

| **Aspecto**                   | **Detalle**                                                                                                                                            |
|-------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Academic Governance                                                                                                                                    |
| Trigger                       | Error grave/compliance                                                                                                                                 |
| Precondiciones / autorización | PUBLISHED/APPROVED según policy; step-up; reason/evidence                                                                                              |
| Happy Path                    | No borra; transiciona a VOID si permitido, publica event, downstream decide bloqueo de nuevas ediciones; historia de ediciones existentes se conserva. |
| Alternativas / errores        | Si downstream effect es UNKNOWN, no repetir ciegamente; reconcile.                                                                                     |
| Idempotencia                  | Idempotency-Key obligatorio.                                                                                                                           |
| Concurrencia                  | If-Match + state transition guard.                                                                                                                     |
| Auditoría / side effects      | Audit de alto assurance.                                                                                                                               |
| Postcondición                 | VOID durable + receipts.                                                                                                                               |

### UC-EC01-037 — Solicitar asistencia IA

| **Aspecto**                   | **Detalle**                                                                                                              |
|-------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Academic Designer                                                                                                        |
| Trigger                       | Necesita borrador/diagnóstico                                                                                            |
| Precondiciones / autorización | DRAFT; purpose permitido                                                                                                 |
| Happy Path                    | Construye grounding permitido → CT-12 run → retorna suggestion con provenance; no escribe directamente hechos oficiales. |
| Alternativas / errores        | CT-12 unavailable =\> UI muestra UNAVAILABLE y edición manual continúa.                                                  |
| Idempotencia                  | Run request puede ser idempotente por client request key.                                                                |
| Concurrencia                  | No locking hasta apply.                                                                                                  |
| Auditoría / side effects      | AI run refs + prompt/template/eval refs.                                                                                 |
| Postcondición                 | Suggestion pending human action.                                                                                         |

### UC-EC01-038 — Aceptar sugerencia IA

| **Aspecto**                   | **Detalle**                                                                                                |
|-------------------------------|------------------------------------------------------------------------------------------------------------|
| Actor                         | Academic Designer                                                                                          |
| Trigger                       | Usuario selecciona suggestion                                                                              |
| Precondiciones / autorización | DRAFT y ETag actual                                                                                        |
| Happy Path                    | Mapea suggestion a command normal, valida dominio, persiste como cambio humano con ai_run_ref attribution. |
| Alternativas / errores        | ETag mismatch =\> 412 y usuario debe rebase/review.                                                        |
| Idempotencia                  | Mutation idempotency según command.                                                                        |
| Concurrencia                  | If-Match obligatorio.                                                                                      |
| Auditoría / side effects      | Audit reviewer/outcome.                                                                                    |
| Postcondición                 | Cambio tratado igual que input humano, nunca bypass.                                                       |

### UC-EC01-039 — Importar portfolio legacy dry-run

| **Aspecto**                   | **Detalle**                                                                                                          |
|-------------------------------|----------------------------------------------------------------------------------------------------------------------|
| Actor                         | Data Steward                                                                                                         |
| Trigger                       | Migración                                                                                                            |
| Precondiciones / autorización | Batch CT-16 preparado                                                                                                |
| Happy Path                    | CT-16 entrega normalized candidates → EC-01 validation API simula IDs/mappings/conflicts sin persistir verdad final. |
| Alternativas / errores        | Duplicados/cross-tenant =\> FAIL por item; no INSERT directo.                                                        |
| Idempotencia                  | Batch idempotency.                                                                                                   |
| Concurrencia                  | No locks largos; snapshot refs.                                                                                      |
| Auditoría / side effects      | Lineage y validation receipt.                                                                                        |
| Postcondición                 | DryRunReport.                                                                                                        |

### UC-EC01-041 — Reconciliar publicación/eventos

| **Aspecto**                   | **Detalle**                                                                                                                                  |
|-------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Ops                                                                                                                                          |
| Trigger                       | Alerta/outbox pendiente                                                                                                                      |
| Precondiciones / autorización | Receipt/event known                                                                                                                          |
| Happy Path                    | Comprueba DB truth, outbox delivery e inbox downstream cuando contrato lo permita; reintenta solo operaciones demostrablemente no aplicadas. |
| Alternativas / errores        | UNKNOWN_EFFECT se conserva hasta query/status resuelva.                                                                                      |
| Idempotencia                  | Reconciliation itself idempotent.                                                                                                            |
| Concurrencia                  | No cambia academic content.                                                                                                                  |
| Auditoría / side effects      | Ops audit + metrics.                                                                                                                         |
| Postcondición                 | Estado de delivery consistente o escalado.                                                                                                   |

# 11. DER conceptual, lógico y físico

## 11.1 DER conceptual

El modelo conceptual parte de cuatro identidades estables: ProgramDefinition, LearningModuleDefinition, PathwayDefinition y sus versiones. ProgramVersion agrega outcomes, estructura, requirements y credential blueprints; LearningModuleVersion agrega outcomes propios; PathwayVersion agrega nodos/aristas. PublicationReceipt prueba qué snapshot fue publicado.

## 11.2 DER lógico

Las relaciones internas EC-01 son tenant-aware. ProgramVersion pertenece a ProgramDefinition; structure groups/items pertenecen a ProgramVersion; items pinnean LearningModuleVersion; dependencies unen items de la misma ProgramVersion. CredentialBlueprint pertenece a ProgramVersion y sus requirements solo pueden apuntar a targets del mismo version scope. PathwayVersion pertenece a PathwayDefinition y sus edges solo unen nodos de la misma versión.

## 11.3 DER físico resumido

<img src="media/image4.png" style="width:7.05in;height:5.34391in" />

Figura 4 — DER físico resumido EC-01

| **REGLA DE FK —** Todas las FKs físicas del esquema ec01 son internas y tenant-aware. CT-01…CT-18, IAM, Finanzas, RRHH y otros bounded contexts se consumen mediante EXT REF y contratos; una migración no debe introducir FKs cross-context “por comodidad”. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 12. Modelo físico PostgreSQL tabla por tabla

El esquema propuesto es ec01. Todas las tablas de negocio usan tenant_id como parte de PK o scope lógico. Las FKs físicas solo apuntan a tablas del mismo bounded context EC-01 y, para relaciones críticas, incluyen tenant_id y la clave de scope necesaria para impedir cruces de ProgramVersion/Definition. EXT REF hacia CT/IAM/cores no genera FK física.

| **PREGUNTA OBLIGATORIA —** Para cada tabla se responde: “¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug?”. Las invariantes expresables físicamente se protegen con PK, FK, UNIQUE, CHECK, índices parciales y triggers defensivos. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.1 ec01_program_definition

QUÉ REPRESENTA — Representa la identidad académica estable de cada producto de Educación Continua. Es el anchor que permite que una misma oferta conceptual sobreviva a múltiples versiones sin duplicar código, ownership ni lifecycle de portafolio. No contiene fechas de edición, precio, participantes ni sesiones.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea Portfolio Management y la modifica Academic Governance mientras su lifecycle lo permita. Es Aggregate Root; ProgramVersion depende de ella. EC-02 consume una ProgramVersion publicada y no necesita copiar la ProgramDefinition completa.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege la identidad, business key y ownership tenant-aware. No representa una ejecución, una venta ni una matrícula.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                 | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|---------------|---------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant derivado del contexto autorizado; participa en toda clave y aislamiento. | 8a6…              |
| program_id               | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable del programa.                                     | prg…              |
| program_code             | varchar(64)         | NO       | —                 | UQ            | Código institucional normalizado, estable dentro del tenant.                    | DATA-AI-EXEC      |
| program_family_code      | varchar(80)         | NO       | —                 | EXT REF CT-02 | Familia/tipo parametrizado; evita enum hardcodeado.                             | BOOTCAMP          |
| academic_owner_scope_ref | uuid                | NO       | —                 | EXT REF CT-01 | Unidad/scope institucional responsable de la definición.                        | scope…            |
| default_language_code    | varchar(16)         | NO       | 'es-BO'           | EXT REF CT-08 | Idioma canónico/fallback; traducciones viven en CT-08.                          | es-BO             |
| lifecycle_state          | varchar(24)         | NO       | 'DRAFT'           | CHECK         | Lifecycle de identidad: DRAFT/ACTIVE/SUSPENDED/RETIRED.                         | ACTIVE            |
| created_by_subject       | uuid                | NO       | —                 | EXT REF IAM   | Actor que creó la identidad.                                                    | usr…              |
| created_at               | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                       | 2026-09-08T14:00Z |
| updated_at               | timestamptz         | NO       | now()             | —             | Última modificación de metadata mutable.                                        | 2026-09-08T15:00Z |
| version                  | bigint              | NO       | 0                 | —             | Optimistic lock JPA @Version.                                                   | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado; participa en toda clave y aislamiento. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a6….

**program_id —** Identificador técnico estable del programa. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: prg….

**program_code —** Código institucional normalizado, estable dentro del tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: DATA-AI-EXEC.

**program_family_code —** Familia/tipo parametrizado; evita enum hardcodeado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: BOOTCAMP.

**academic_owner_scope_ref —** Unidad/scope institucional responsable de la definición. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: scope….

**default_language_code —** Idioma canónico/fallback; traducciones viven en CT-08. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'es-BO'; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: es-BO.

**lifecycle_state —** Lifecycle de identidad: DRAFT/ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'DRAFT'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: ACTIVE.

**created_by_subject —** Actor que creó la identidad. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: 2026-09-08T14:00Z.

**updated_at —** Última modificación de metadata mutable. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: 2026-09-08T15:00Z.

**version —** Optimistic lock JPA @Version. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Se mapea con @Version; una versión obsoleta debe producir 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo de valor: 3.

### Constraints físicos implementables

| **Nombre físico**                                         | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|-----------------------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_program_definition (tenant_id, program_id)        | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_definition_code (tenant_id, program_code) | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_program_definition_state                          | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_program_definition_owner_state                    | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir business keys duplicadas, estados fuera del lifecycle y cualquier cruce de tenant incluso si el Backend omite filtros. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec01_program_version

QUÉ REPRESENTA — Representa el snapshot académico versionado del programa. Congela nombre, propósito, audiencia, carga académica, vigencia, policy bindings y metadatos necesarios para que futuras ediciones sepan exactamente qué definición ejecutaron.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea un Academic Designer bajo ProgramDefinition. Agrega outcomes, modalidades, competencias, estructura, requisitos y CredentialBlueprint. Al publicar, se convierte en contrato downstream para EC-02/08/10 y queda inmutable con todos sus hijos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege lineage, unicidad de versión y una única PUBLISHED vigente por programa. No representa ProgramEdition ni pricing.

| **Campo**                    | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                                                                                            | **Ejemplo**                |
|------------------------------|---------------------|----------|-------------------|--------------------|--------------------------------------------------------------------------------------------------------------------------------------------|----------------------------|
| **tenant_id**                | uuid                | NO       | —                 | PK\*               | Tenant de la versión; heredado del ProgramDefinition.                                                                                      | 8a6…                       |
| **program_version_id**       | uuid                | NO       | gen_random_uuid() | PK                 | ID estable de snapshot.                                                                                                                    | pv…                        |
| **program_id**               | uuid                | NO       | —                 | FK                 | ProgramDefinition padre del mismo tenant.                                                                                                  | prg…                       |
| **version_no**               | integer             | NO       | —                 | UQ                 | Número de versión positivo y único por programa.                                                                                           | 2                          |
| **previous_version_id**      | uuid                | YES      | NULL              | FK                 | Versión anterior del mismo program_id; lineage, no enlace arbitrario.                                                                      | pv1…                       |
| **official_name**            | varchar(240)        | NO       | —                 | —                  | Nombre oficial canónico de esta versión.                                                                                                   | Bootcamp Ejecutivo de IA   |
| **short_name**               | varchar(120)        | YES      | NULL              | —                  | Nombre corto para UI; no sustituye el oficial.                                                                                             | Bootcamp IA                |
| **purpose_text**             | text                | NO       | —                 | —                  | Propósito formativo aprobado.                                                                                                              | Desarrollar capacidades…   |
| **target_audience_text**     | text                | YES      | NULL              | —                  | Descripción académica de audiencia; no segmento comercial.                                                                                 | Profesionales…             |
| **academic_hours**           | numeric(10,2)       | NO       | —                 | CHECK              | Carga total prevista; positiva y reconciliable con estructura.                                                                             | 48.00                      |
| **credit_scheme_code**       | varchar(40)         | YES      | NULL              | EXT REF CT-02      | Esquema de créditos si la institución lo utiliza.                                                                                          | ECTS_EQUIV                 |
| **credits**                  | numeric(10,2)       | YES      | NULL              | CHECK              | Créditos bajo el scheme; ambos presentes/ausentes.                                                                                         | 3.00                       |
| **completion_model_code**    | varchar(80)         | NO       | —                 | EXT REF CT-02      | Modelo normativo de completion referenciado.                                                                                               | ATTENDANCE_PLUS_ASSESSMENT |
| **attendance_policy_ref**    | uuid                | YES      | NULL              | EXT REF CT-02      | Política versionada de asistencia aplicable.                                                                                               | pol…                       |
| **assessment_policy_ref**    | uuid                | YES      | NULL              | EXT REF CT-02      | Política de evaluación; NULL si no aplica.                                                                                                 | pol…                       |
| **certification_policy_ref** | uuid                | YES      | NULL              | EXT REF CT-02      | Política macro de certificación/eligibility.                                                                                               | pol…                       |
| **compliance_profile_ref**   | uuid                | YES      | NULL              | EXT REF governance | Perfil normativo aplicable según EC-00.                                                                                                    | cmp…                       |
| **valid_from**               | date                | YES      | NULL              | CHECK              | Fecha desde la cual esta definición puede usarse para nuevas ediciones.                                                                    | 2026-10-01                 |
| **valid_to**                 | date                | YES      | NULL              | CHECK              | Fin opcional de vigencia; no borra historia.                                                                                               | 2027-12-31                 |
| **state**                    | varchar(24)         | NO       | 'DRAFT'           | CHECK              | DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID. Solo DRAFT permite editar contenido; SCHEDULED es snapshot futuro inmutable. | SCHEDULED                  |
| **workflow_ref**             | uuid                | YES      | NULL              | EXT REF CT-06      | Workflow/case que sustenta revisión/aprobación.                                                                                            | wf…                        |
| **review_snapshot_hash**     | varchar(128)        | YES      | NULL              | —                  | Hash del snapshot enviado a revisión para detectar cambios posteriores.                                                                    | sha256:…                   |
| **content_hash**             | varchar(128)        | YES      | NULL              | —                  | Hash canónico definitivo calculado en publish.                                                                                             | sha256:…                   |
| **published_at**             | timestamptz         | YES      | NULL              | —                  | Instante UTC de publicación; requerido si PUBLISHED/SUPERSEDED.                                                                            | 2026-10-01T12:00Z          |
| **published_by_subject**     | uuid                | YES      | NULL              | EXT REF IAM        | Actor publisher con assurance suficiente.                                                                                                  | usr…                       |
| **superseded_by_version_id** | uuid                | YES      | NULL              | FK                 | Versión posterior del mismo program_id que la reemplaza.                                                                                   | pv3…                       |
| **created_at**               | timestamptz         | NO       | now()             | —                  | Creación del draft.                                                                                                                        | …                          |
| **updated_at**               | timestamptz         | NO       | now()             | —                  | Última modificación mientras editable.                                                                                                     | …                          |
| **version**                  | bigint              | NO       | 0                 | —                  | Optimistic lock.                                                                                                                           | 5                          |

### Explicación individual de atributos

**tenant_id —** Tenant de la versión; heredado del ProgramDefinition. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a6….

**program_version_id —** ID estable de snapshot. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: pv….

**program_id —** ProgramDefinition padre del mismo tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: prg….

**version_no —** Número de versión positivo y único por programa. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 2.

**previous_version_id —** Versión anterior del mismo program_id; lineage, no enlace arbitrario. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv1….

**official_name —** Nombre oficial canónico de esta versión. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Bootcamp Ejecutivo de IA.

**short_name —** Nombre corto para UI; no sustituye el oficial. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: Bootcamp IA.

**purpose_text —** Propósito formativo aprobado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Desarrollar capacidades….

**target_audience_text —** Descripción académica de audiencia; no segmento comercial. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: Profesionales….

**academic_hours —** Carga total prevista; positiva y reconciliable con estructura. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 48.00.

**credit_scheme_code —** Esquema de créditos si la institución lo utiliza. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: ECTS_EQUIV.

**credits —** Créditos bajo el scheme; ambos presentes/ausentes. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 3.00.

**completion_model_code —** Modelo normativo de completion referenciado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: ATTENDANCE_PLUS_ASSESSMENT.

**attendance_policy_ref —** Política versionada de asistencia aplicable. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**assessment_policy_ref —** Política de evaluación; NULL si no aplica. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**certification_policy_ref —** Política macro de certificación/eligibility. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**compliance_profile_ref —** Perfil normativo aplicable según EC-00. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: cmp….

**valid_from —** Fecha desde la cual esta definición puede usarse para nuevas ediciones. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 2026-10-01.

**valid_to —** Fin opcional de vigencia; no borra historia. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 2027-12-31.

**state —** DRAFT/IN_REVIEW/APPROVED/PUBLISHED/SUPERSEDED/VOID. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'DRAFT'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: PUBLISHED.

**workflow_ref —** Workflow/case que sustenta revisión/aprobación. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: wf….

**review_snapshot_hash —** Hash del snapshot enviado a revisión para detectar cambios posteriores. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: sha256:….

**content_hash —** Hash canónico definitivo calculado en publish. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: sha256:….

**published_at —** Instante UTC de publicación; requerido si PUBLISHED/SUPERSEDED. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: 2026-10-01T12:00Z.

**published_by_subject —** Actor publisher con assurance suficiente. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: usr….

**superseded_by_version_id —** Versión posterior del mismo program_id que la reemplaza. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv3….

**created_at —** Creación del draft. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**updated_at —** Última modificación mientras editable. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**version —** Optimistic lock. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Se mapea con @Version; una versión obsoleta debe producir 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo de valor: 5.

### Constraints físicos implementables

| **Nombre físico**                               | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|-------------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_program_version                         | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_version_no                      | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_version_scope                   | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_single_published (partial)      | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_program_version_program                 | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_program_version_previous_same_program   | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_program_version_superseded_same_program | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_program_version_state                   | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_program_version_hours                   | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_program_version_credits_pair            | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_program_version_dates                   | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_program_version_publish_fields          | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_version_state_immutability     | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir dos PUBLISHED simultáneas, previous/superseded cruzado a otro programa, cargas inválidas y cualquier modificación destructiva de un snapshot publicado. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec01_program_delivery_mode_binding

QUÉ REPRESENTA — Declara modalidades que la ProgramVersion admite conceptualmente, por ejemplo presencial, síncrona virtual, asíncrona o híbrida. No agenda sesiones ni reserva recursos.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo de ProgramVersion. EC-02 lo consulta al crear ediciones y solo puede seleccionar modalidades compatibles. Los códigos se resuelven desde CT-02.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege que no se duplique la misma modalidad dentro de la versión. No representa configuración LMS, meeting URLs ni horarios.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                            | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant.                                    | 8a…         |
| delivery_mode_binding_id | uuid                | NO       | gen_random_uuid() | PK            | ID técnico.                                | dm…         |
| program_version_id       | uuid                | NO       | —                 | FK            | Version padre.                             | pv…         |
| delivery_mode_code       | varchar(80)         | NO       | —                 | EXT REF CT-02 | Código parametrizado de modalidad.         | HYBRID      |
| is_default               | boolean             | NO       | false             | —             | Indica modalidad sugerida, no obligatoria. | true        |
| policy_ref               | uuid                | YES      | NULL              | EXT REF CT-02 | Restricciones específicas de modalidad.    | pol…        |
| created_at               | timestamptz         | NO       | now()             | —             | Creación.                                  | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**delivery_mode_binding_id —** ID técnico. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: dm….

**program_version_id —** Version padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**delivery_mode_code —** Código parametrizado de modalidad. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: HYBRID.

**is_default —** Indica modalidad sugerida, no obligatoria. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es false; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: true.

**policy_ref —** Restricciones específicas de modalidad. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                     | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|---------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_program_delivery_mode_binding | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_delivery_mode_program_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_delivery_mode_per_version     | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_delivery_mode_code            | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_child_mutability     | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir duplicar modalidad y modificar bindings si la ProgramVersion ya está PUBLISHED/SUPERSEDED. |
|---------------------------------------------------------------------------------------------------------------------------------------------|

## 12.4 ec01_program_outcome

QUÉ REPRESENTA — Representa un resultado de aprendizaje esperado de la ProgramVersion. Es una declaración del diseño, no una calificación ni evidencia individual.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Pertenece a ProgramVersion y puede ser target de competency bindings y credential requirements. EC-07 podrá referenciar outcome_id al registrar resultados sin copiar el texto histórico.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege código/orden dentro de la versión e inmutabilidad post-publicación. No representa ParticipantOutcome.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                | **Ejemplo**        |
|---------------------|---------------------|----------|-------------------|---------------|------------------------------------------------|--------------------|
| tenant_id           | uuid                | NO       | —                 | PK\*          | Tenant.                                        | 8a…                |
| outcome_id          | uuid                | NO       | gen_random_uuid() | PK            | ID estable dentro del snapshot.                | out…               |
| program_version_id  | uuid                | NO       | —                 | FK            | ProgramVersion padre.                          | pv…                |
| outcome_code        | varchar(64)         | NO       | —                 | UQ            | Business code único en la versión.             | PO-01              |
| statement           | text                | NO       | —                 | —             | Enunciado observable/validable.                | Diseña soluciones… |
| taxonomy_level_code | varchar(64)         | YES      | NULL              | EXT REF CT-02 | Nivel taxonómico si la institución lo usa.     | APPLY              |
| sequence_no         | integer             | NO       | —                 | CHECK/UQ      | Orden de presentación positivo.                | 1                  |
| mandatory           | boolean             | NO       | true              | —             | Indica si es outcome obligatorio del programa. | true               |
| created_at          | timestamptz         | NO       | now()             | —             | Creación.                                      | …                  |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**outcome_id —** ID estable dentro del snapshot. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: out….

**program_version_id —** ProgramVersion padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**outcome_code —** Business code único en la versión. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: PO-01.

**statement —** Enunciado observable/validable. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Diseña soluciones….

**taxonomy_level_code —** Nivel taxonómico si la institución lo usa. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: APPLY.

**sequence_no —** Orden de presentación positivo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 1.

**mandatory —** Indica si es outcome obligatorio del programa. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es true; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: true.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|-----------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_program_outcome           | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_outcome_code      | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_outcome_order     | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_outcome_scope     | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_program_outcome_version   | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_program_outcome_sequence  | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_child_mutability | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir outcome duplicado/orden inválido y cualquier cambio bajo una ProgramVersion publicada. |
|-----------------------------------------------------------------------------------------------------------------------------------------|

## 12.5 ec01_program_competency_binding

QUÉ REPRESENTA — Vincula un ProgramOutcome o la ProgramVersion con una competencia institucional/external catalog sin replicar la definición completa de la competencia.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea el diseñador durante mapping curricular; validación cross-context comprueba competency_ref. Analytics/calidad puede explotar el binding sin convertirlo en catálogo maestro.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege duplicados y target semántico. No representa evaluación de competencia del participante.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**             | **Descripción**                                                       | **Ejemplo** |
|-----------------------|---------------------|----------|-------------------|-----------------------|-----------------------------------------------------------------------|-------------|
| tenant_id             | uuid                | NO       | —                 | PK\*                  | Tenant.                                                               | 8a…         |
| competency_binding_id | uuid                | NO       | gen_random_uuid() | PK                    | ID.                                                                   | cb…         |
| program_version_id    | uuid                | NO       | —                 | FK                    | Version padre y scope del binding.                                    | pv…         |
| outcome_id            | uuid                | YES      | NULL              | FK                    | Outcome local específico; NULL significa binding a nivel de programa. | out…        |
| competency_ref        | uuid                | NO       | —                 | EXT REF CT-02/catalog | Competencia canónica externa.                                         | cmp…        |
| level_code            | varchar(64)         | YES      | NULL              | EXT REF CT-02         | Nivel esperado.                                                       | LEVEL_2     |
| weight                | numeric(6,3)        | YES      | NULL              | CHECK                 | Peso opcional 0..1 si policy lo utiliza.                              | 0.500       |
| created_at            | timestamptz         | NO       | now()             | —                     | Creación.                                                             | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**competency_binding_id —** ID. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: cb….

**program_version_id —** Version padre y scope del binding. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**outcome_id —** Outcome local específico; NULL significa binding a nivel de programa. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: out….

**competency_ref —** Competencia canónica externa. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: cmp….

**level_code —** Nivel esperado. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: LEVEL_2.

**weight —** Peso opcional 0..1 si policy lo utiliza. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 0.500.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                         | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|-------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_program_competency_binding        | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_comp_binding_version              | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_comp_binding_outcome_same_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_comp_binding                      | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_comp_binding_weight               | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_child_mutability         | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir que un binding declare outcome de otra ProgramVersion y pesos fuera de rango. |
|--------------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec01_learning_module_definition

QUÉ REPRESENTA — Representa la identidad estable de una unidad académica reusable. Permite que distintos programas referencien versiones concretas del mismo módulo sin copiar contenido ni depender de un “latest” mutable.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es Aggregate Root independiente. Academic Designer crea definiciones y versiones. ProgramStructureItem referencia LearningModuleVersion; ningún programa publicado cambia cuando aparece una nueva versión del módulo.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege code uniqueness, ownership y lifecycle del módulo. No representa sesión, aula, instructor ni contenido LMS.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                           | **Ejemplo** |
|--------------------------|---------------------|----------|-------------------|---------------|-----------------------------------------------------------|-------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant.                                                   | 8a…         |
| learning_module_id       | uuid                | NO       | gen_random_uuid() | PK            | Identidad estable del módulo.                             | lm…         |
| module_code              | varchar(64)         | NO       | —                 | UQ            | Código institucional único por tenant.                    | AI-GOV-01   |
| module_type_code         | varchar(80)         | NO       | —                 | EXT REF CT-02 | Tipo parametrizado: módulo, workshop unit, capstone, etc. | MODULE      |
| academic_owner_scope_ref | uuid                | NO       | —                 | EXT REF CT-01 | Scope owner.                                              | scope…      |
| lifecycle_state          | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/ACTIVE/SUSPENDED/RETIRED.                           | ACTIVE      |
| created_by_subject       | uuid                | NO       | —                 | EXT REF IAM   | Creador.                                                  | usr…        |
| created_at               | timestamptz         | NO       | now()             | —             | Creación.                                                 | …           |
| updated_at               | timestamptz         | NO       | now()             | —             | Actualización metadata.                                   | …           |
| version                  | bigint              | NO       | 0                 | —             | Optimistic lock.                                          | 2           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**learning_module_id —** Identidad estable del módulo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: lm….

**module_code —** Código institucional único por tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: AI-GOV-01.

**module_type_code —** Tipo parametrizado: módulo, workshop unit, capstone, etc. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: MODULE.

**academic_owner_scope_ref —** Scope owner. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: scope….

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'DRAFT'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: ACTIVE.

**created_by_subject —** Creador. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: usr….

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**updated_at —** Actualización metadata. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**version —** Optimistic lock. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Se mapea con @Version; una versión obsoleta debe producir 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo de valor: 2.

### Constraints físicos implementables

| **Nombre físico**                  | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_learning_module_definition | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_learning_module_code       | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_learning_module_state      | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_learning_module_owner      | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir códigos duplicados, cruces de tenant y estados no permitidos. |
|----------------------------------------------------------------------------------------------------------------|

## 12.7 ec01_learning_module_version

QUÉ REPRESENTA — Representa un snapshot académico de un LearningModuleDefinition: nombre, horas, créditos opcionales, evaluación requerida y descripción normativa.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo versionado del módulo. ProgramStructureItem pinnea esta versión concreta. Cuando PUBLISHED queda inmutable y puede ser reutilizada por múltiples ProgramVersion.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege lineage same-module, unicidad de version_no y una única PUBLISHED vigente por módulo. No representa ejecución concreta.

| **Campo**                       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                            | **Ejemplo**    |
|---------------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------|----------------|
| tenant_id                       | uuid                | NO       | —                 | PK\*          | Tenant.                                    | 8a…            |
| learning_module_version_id      | uuid                | NO       | gen_random_uuid() | PK            | ID del snapshot.                           | lmv…           |
| learning_module_id              | uuid                | NO       | —                 | FK            | Definition padre.                          | lm…            |
| module_version_no               | integer             | NO       | —                 | UQ            | Número positivo de versión.                | 2              |
| previous_module_version_id      | uuid                | YES      | NULL              | FK            | Versión anterior del mismo módulo.         | lmv1…          |
| official_title                  | varchar(240)        | NO       | —                 | —             | Título canónico.                           | Gobierno de IA |
| description_text                | text                | YES      | NULL              | —             | Descripción académica.                     | Marco de…      |
| module_hours                    | numeric(10,2)       | NO       | —                 | CHECK         | Horas positivas.                           | 12.00          |
| credit_scheme_code              | varchar(40)         | YES      | NULL              | EXT REF CT-02 | Esquema opcional.                          | ECTS_EQUIV     |
| module_credits                  | numeric(10,2)       | YES      | NULL              | CHECK         | Créditos opcionales.                       | 0.75           |
| assessment_required             | boolean             | NO       | false             | —             | Indica intención evaluativa, no resultado. | true           |
| assessment_policy_ref           | uuid                | YES      | NULL              | EXT REF CT-02 | Política si assessment_required.           | pol…           |
| state                           | varchar(24)         | NO       | 'DRAFT'           | CHECK         | Lifecycle versionado.                      | PUBLISHED      |
| workflow_ref                    | uuid                | YES      | NULL              | EXT REF CT-06 | Review workflow.                           | wf…            |
| content_hash                    | varchar(128)        | YES      | NULL              | —             | Hash al publicar.                          | sha256:…       |
| published_at                    | timestamptz         | YES      | NULL              | —             | Fecha publish.                             | …              |
| published_by_subject            | uuid                | YES      | NULL              | EXT REF IAM   | Publisher.                                 | usr…           |
| superseded_by_module_version_id | uuid                | YES      | NULL              | FK            | Nueva versión del mismo módulo.            | lmv3…          |
| created_at                      | timestamptz         | NO       | now()             | —             | Creación.                                  | …              |
| updated_at                      | timestamptz         | NO       | now()             | —             | Última modificación editable.              | …              |
| version                         | bigint              | NO       | 0                 | —             | Optimistic lock.                           | 4              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**learning_module_version_id —** ID del snapshot. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: lmv….

**learning_module_id —** Definition padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: lm….

**module_version_no —** Número positivo de versión. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 2.

**previous_module_version_id —** Versión anterior del mismo módulo. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: lmv1….

**official_title —** Título canónico. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Gobierno de IA.

**description_text —** Descripción académica. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: Marco de….

**module_hours —** Horas positivas. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 12.00.

**credit_scheme_code —** Esquema opcional. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: ECTS_EQUIV.

**module_credits —** Créditos opcionales. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 0.75.

**assessment_required —** Indica intención evaluativa, no resultado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es false; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: true.

**assessment_policy_ref —** Política si assessment_required. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**state —** Lifecycle versionado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'DRAFT'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: PUBLISHED.

**workflow_ref —** Review workflow. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: wf….

**content_hash —** Hash al publicar. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: sha256:….

**published_at —** Fecha publish. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**published_by_subject —** Publisher. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: usr….

**superseded_by_module_version_id —** Nueva versión del mismo módulo. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: lmv3….

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**updated_at —** Última modificación editable. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**version —** Optimistic lock. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Se mapea con @Version; una versión obsoleta debe producir 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo de valor: 4.

### Constraints físicos implementables

| **Nombre físico**                          | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|--------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_learning_module_version            | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_module_version_no                  | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_module_version_scope               | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_module_single_published            | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_module_version_definition          | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_module_previous_same_definition    | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_module_superseded_same_definition  | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_module_version_hours               | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_module_version_credits             | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_module_version_state               | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_module_version_state_immutability | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir lineage cruzado, dos versiones PUBLISHED del mismo módulo, horas/créditos inválidos y mutación de snapshot publicado. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.8 ec01_learning_module_outcome

QUÉ REPRESENTA — Define outcomes esperados de una LearningModuleVersion. Permite que un mismo módulo reusable conserve resultados propios y que programas pinneen exactamente qué versión aplicó.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Hijo de LearningModuleVersion; se consulta al validar mappings de ProgramOutcome y al construir assessment downstream, pero EC-01 no almacena resultados individuales.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege code/order uniqueness e inmutabilidad si el módulo está publicado. No representa evaluación.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                            | **Ejemplo** |
|----------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------|-------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*          | Tenant.                                    | 8a…         |
| module_outcome_id          | uuid                | NO       | gen_random_uuid() | PK            | ID outcome.                                | mo…         |
| learning_module_version_id | uuid                | NO       | —                 | FK            | ModuleVersion padre.                       | lmv…        |
| outcome_code               | varchar(64)         | NO       | —                 | UQ            | Código único dentro del módulo versionado. | MO-01       |
| statement                  | text                | NO       | —                 | —             | Enunciado del outcome.                     | Explica…    |
| taxonomy_level_code        | varchar(64)         | YES      | NULL              | EXT REF CT-02 | Nivel taxonómico.                          | UNDERSTAND  |
| sequence_no                | integer             | NO       | —                 | CHECK/UQ      | Orden positivo.                            | 1           |
| created_at                 | timestamptz         | NO       | now()             | —             | Creación.                                  | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**module_outcome_id —** ID outcome. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: mo….

**learning_module_version_id —** ModuleVersion padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: lmv….

**outcome_code —** Código único dentro del módulo versionado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: MO-01.

**statement —** Enunciado del outcome. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Explica….

**taxonomy_level_code —** Nivel taxonómico. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: UNDERSTAND.

**sequence_no —** Orden positivo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 1.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|----------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_learning_module_outcome  | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_module_outcome_code      | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_module_outcome_order     | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_module_outcome_version   | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_module_outcome_sequence  | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_module_child_mutability | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir duplicados y cambios bajo una LearningModuleVersion publicada. |
|-----------------------------------------------------------------------------------------------------------------|

## 12.9 ec01_program_structure_group

QUÉ REPRESENTA — Agrupa structure items de una ProgramVersion en bloques semánticos: troncal, optativo, etapa, track o colección. Define cardinalidad mínima/máxima sin convertir la estructura en calendario.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo de ProgramVersion y puede formar jerarquía de grupos. StructureItem pertenece a un grupo. EC-02 usa la estructura publicada como referencia, pero no la modifica.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege cardinalidades, orden y parent dentro de la misma versión. No representa cohortes ni secciones de clase.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                         | **Ejemplo** |
|--------------------|---------------------|----------|-------------------|---------------|-----------------------------------------|-------------|
| tenant_id          | uuid                | NO       | —                 | PK\*          | Tenant.                                 | 8a…         |
| structure_group_id | uuid                | NO       | gen_random_uuid() | PK            | ID grupo.                               | sg…         |
| program_version_id | uuid                | NO       | —                 | FK            | Version padre.                          | pv…         |
| parent_group_id    | uuid                | YES      | NULL              | FK            | Grupo padre de la misma ProgramVersion. | sg0…        |
| group_code         | varchar(64)         | NO       | —                 | UQ            | Código único por version.               | CORE        |
| group_type_code    | varchar(64)         | NO       | —                 | EXT REF CT-02 | Tipo de agrupación.                     | MANDATORY   |
| title              | varchar(200)        | NO       | —                 | —             | Título canónico.                        | Núcleo      |
| min_items          | integer             | NO       | 0                 | CHECK         | Mínimo requerido.                       | 3           |
| max_items          | integer             | YES      | NULL              | CHECK         | Máximo opcional \>= min.                | 5           |
| sequence_no        | integer             | NO       | —                 | CHECK/UQ      | Orden positivo.                         | 1           |
| created_at         | timestamptz         | NO       | now()             | —             | Creación.                               | …           |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**structure_group_id —** ID grupo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: sg….

**program_version_id —** Version padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**parent_group_id —** Grupo padre de la misma ProgramVersion. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: sg0….

**group_code —** Código único por version. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: CORE.

**group_type_code —** Tipo de agrupación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: MANDATORY.

**title —** Título canónico. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Núcleo.

**min_items —** Mínimo requerido. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 3.

**max_items —** Máximo opcional \>= min. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 5.

**sequence_no —** Orden positivo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 1.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                                                            | **Tipo**           | **Definición/expresión**                                                                                                                                                                  | **Error que impide**                                                                   |
|------------------------------------------------------------------------------|--------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| **pk_ec01_program_structure_group**                                          | PK                 | Ver DDL Flyway de la sección 13.                                                                                                                                                          | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| **uq_ec01_structure_group_code**                                             | UQ/INDEX           | Ver DDL Flyway de la sección 13.                                                                                                                                                          | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| **uq_ec01_structure_group_root_order / uq_ec01_structure_group_child_order** | UQ partial indexes | Root: (tenant_id, program_version_id, sequence_no) WHERE parent_group_id IS NULL. Child: (tenant_id, program_version_id, parent_group_id, sequence_no) WHERE parent_group_id IS NOT NULL. | Impide orden duplicado entre hermanos sin prohibir sequence_no=1 en ramas diferentes.  |
| **uq_ec01_structure_group_scope**                                            | UQ/INDEX           | Ver DDL Flyway de la sección 13.                                                                                                                                                          | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| **fk_ec01_structure_group_version**                                          | FK                 | Ver DDL Flyway de la sección 13.                                                                                                                                                          | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| **fk_ec01_structure_group_parent_same_version**                              | FK                 | Ver DDL Flyway de la sección 13.                                                                                                                                                          | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| **ck_ec01_structure_group_cardinality**                                      | CHECK              | Ver DDL Flyway de la sección 13.                                                                                                                                                          | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| **ck_ec01_structure_group_no_self_parent**                                   | CHECK              | Ver DDL Flyway de la sección 13.                                                                                                                                                          | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| **trg_ec01_program_child_mutability**                                        | TRIGGER            | Ver DDL Flyway de la sección 13.                                                                                                                                                          | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| **trg_ec01_structure_group_no_cycle**                                        | TRIGGER            | Recorre parent_group_id y rechaza que el nodo aparezca entre sus ancestros.                                                                                                               | Impide ciclos indirectos A→B→C→A.                                                      |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir parent cross-version, self-parent, min/max incoherente, duplicidad de código/orden y edición post-publish. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec01_program_structure_item

QUÉ REPRESENTA — Inserta una LearningModuleVersion concreta dentro de una ProgramVersion y un grupo estructural. Es el slot que permite ordenar, marcar obligatoriedad y aplicar overrides permitidos sin duplicar la ModuleVersion.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Hijo de ProgramVersion/StructureGroup. Es target de prerequisites y credential requirements. Su module_version_id es pinneado; nunca se resuelve dinámicamente a latest.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege scope same-version del grupo, unicidad del slot y horas/credits override coherentes. No representa enrollment ni session.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                      | **Ejemplo**  |
|----------------------------|---------------------|----------|-------------------|-----------|------------------------------------------------------|--------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*      | Tenant.                                              | 8a…          |
| structure_item_id          | uuid                | NO       | gen_random_uuid() | PK        | ID slot.                                             | si…          |
| program_version_id         | uuid                | NO       | —                 | FK        | Version padre.                                       | pv…          |
| structure_group_id         | uuid                | NO       | —                 | FK        | Grupo del mismo version scope.                       | sg…          |
| learning_module_version_id | uuid                | NO       | —                 | FK        | ModuleVersion pinneada.                              | lmv…         |
| slot_code                  | varchar(64)         | NO       | —                 | UQ        | Código del slot dentro del programa.                 | M01          |
| sequence_no                | integer             | NO       | —                 | CHECK/UQ  | Orden dentro del grupo.                              | 1            |
| mandatory                  | boolean             | NO       | true              | —         | Obligatoriedad estructural.                          | true         |
| hours_override             | numeric(10,2)       | YES      | NULL              | CHECK     | Override explícito positivo si policy permite.       | 10.00        |
| credits_override           | numeric(10,2)       | YES      | NULL              | CHECK     | Override positivo; no cambia ModuleVersion original. | 0.50         |
| override_reason_code       | varchar(80)         | YES      | NULL              | CHECK     | Obligatorio si existe algún override.                | LOCALIZATION |
| created_at                 | timestamptz         | NO       | now()             | —         | Creación.                                            | …            |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**structure_item_id —** ID slot. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: si….

**program_version_id —** Version padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**structure_group_id —** Grupo del mismo version scope. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: sg….

**learning_module_version_id —** ModuleVersion pinneada. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: lmv….

**slot_code —** Código del slot dentro del programa. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: M01.

**sequence_no —** Orden dentro del grupo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 1.

**mandatory —** Obligatoriedad estructural. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es true; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: true.

**hours_override —** Override explícito positivo si policy permite. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 10.00.

**credits_override —** Override positivo; no cambia ModuleVersion original. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 0.50.

**override_reason_code —** Obligatorio si existe algún override. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: LOCALIZATION.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                         | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|-------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_program_structure_item            | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_structure_item_slot               | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_structure_item_group_order        | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_structure_item_scope              | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_structure_item_group_same_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_structure_item_module_version     | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_structure_item_sequence           | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_structure_item_overrides          | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_child_mutability         | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir slot/group cross-version, overrides no positivos o sin reason, y mutaciones post-publish. |
|--------------------------------------------------------------------------------------------------------------------------------------------|

## 12.11 ec01_structure_dependency

QUÉ REPRESENTA — Representa una arista entre dos StructureItem de la misma ProgramVersion: prerequisito, corequisito o secuencia. Permite validar grafos antes de publicación.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea Curriculum Designer; el Backend usa graph service y PostgreSQL aplica scope + anti-self + trigger de ciclo para relaciones que deben ser acíclicas. EC-04/07 pueden consumir dependencias publicadas por contrato.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege que ambos nodos sean de la misma versión, evita self dependency y ciclos de prerequisito/secuencia. No evalúa si un participante cumplió el requisito.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                            | **Ejemplo**   |
|-------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------|---------------|
| tenant_id               | uuid                | NO       | —                 | PK\*          | Tenant.                                    | 8a…           |
| structure_dependency_id | uuid                | NO       | gen_random_uuid() | PK            | ID arista.                                 | sd…           |
| program_version_id      | uuid                | NO       | —                 | FK            | Version scope.                             | pv…           |
| from_structure_item_id  | uuid                | NO       | —                 | FK            | Item que requiere/precede según edge_type. | si1…          |
| to_structure_item_id    | uuid                | NO       | —                 | FK            | Item destino.                              | si2…          |
| dependency_type         | varchar(32)         | NO       | —                 | CHECK         | PRE_REQUISITE/CO_REQUISITE/SEQUENCE.       | PRE_REQUISITE |
| policy_ref              | uuid                | YES      | NULL              | EXT REF CT-02 | Regla adicional.                           | pol…          |
| created_at              | timestamptz         | NO       | now()             | —             | Creación.                                  | …             |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**structure_dependency_id —** ID arista. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: sd….

**program_version_id —** Version scope. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**from_structure_item_id —** Item que requiere/precede según edge_type. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: si1….

**to_structure_item_id —** Item destino. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: si2….

**dependency_type —** PRE_REQUISITE/CO_REQUISITE/SEQUENCE. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: PRE_REQUISITE.

**policy_ref —** Regla adicional. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                              | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|------------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_structure_dependency                   | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_structure_dependency_from_same_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_structure_dependency_to_same_version   | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_structure_dependency                   | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_structure_dependency_type              | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_structure_dependency_no_self           | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_structure_dependency_no_cycle         | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_child_mutability              | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir cross-version, self edge, duplicidad y ciclos de prerequisite/sequence aun si el Backend omite validación. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec01_program_requirement_binding

QUÉ REPRESENTA — Declara un requisito del programa y lo vincula a una regla versionada de CT-15. Mantiene la semántica académica de “qué se exige”, pero no duplica el motor que decide si una persona cumple.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Hijo de ProgramVersion. EC-04/CT-15 usan el binding publicado para eligibility; publication validation comprueba que eligibility_rule_ref es resoluble.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege código único, requirement type y obligatoriedad. No guarda datos de participantes ni resultado de elegibilidad.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                          | **Ejemplo**           |
|------------------------|---------------------|----------|-------------------|---------------|------------------------------------------|-----------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*          | Tenant.                                  | 8a…                   |
| program_requirement_id | uuid                | NO       | gen_random_uuid() | PK            | ID requisito.                            | req…                  |
| program_version_id     | uuid                | NO       | —                 | FK            | Version padre.                           | pv…                   |
| requirement_code       | varchar(64)         | NO       | —                 | UQ            | Código único.                            | REQ-AGE               |
| requirement_type_code  | varchar(80)         | NO       | —                 | EXT REF CT-02 | Tipo parametrizado.                      | PRIOR_KNOWLEDGE       |
| title                  | varchar(200)        | NO       | —                 | —             | Descripción corta.                       | Conocimientos previos |
| eligibility_rule_ref   | uuid                | NO       | —                 | EXT REF CT-15 | Regla canónica que evaluará eligibility. | er…                   |
| mandatory              | boolean             | NO       | true              | —             | Si bloquea o solo recomienda.            | true                  |
| sequence_no            | integer             | NO       | —                 | CHECK         | Orden positivo.                          | 1                     |
| created_at             | timestamptz         | NO       | now()             | —             | Creación.                                | …                     |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**program_requirement_id —** ID requisito. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: req….

**program_version_id —** Version padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**requirement_code —** Código único. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: REQ-AGE.

**requirement_type_code —** Tipo parametrizado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: PRIOR_KNOWLEDGE.

**title —** Descripción corta. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Conocimientos previos.

**eligibility_rule_ref —** Regla canónica que evaluará eligibility. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: er….

**mandatory —** Si bloquea o solo recomienda. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es true; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: true.

**sequence_no —** Orden positivo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 1.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|--------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_program_requirement_binding  | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_requirement_code     | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_program_requirement_scope    | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_program_requirement_version  | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_program_requirement_sequence | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_child_mutability    | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir códigos duplicados y que requirements de una versión publicada sean modificados. |
|-----------------------------------------------------------------------------------------------------------------------------------|

## 12.13 ec01_credential_blueprint

QUÉ REPRESENTA — Define la credencial académica potencial asociada a una ProgramVersion: código, tipo, nombre, verification profile y políticas. Es un blueprint de award, no el award mismo.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Hijo de ProgramVersion. EC-08 consume únicamente blueprints de versiones publicadas para evaluar eligibility/award/issuance. CT-05 genera/conserva el artefacto verificable.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege unicidad de credential_code dentro de la versión e inmutabilidad con parent publicada. No representa certificado emitido ni PDF.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                              | **Ejemplo**                    |
|---------------------------|---------------------|----------|-------------------|---------------------|--------------------------------------------------------------|--------------------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*                | Tenant.                                                      | 8a…                            |
| credential_blueprint_id   | uuid                | NO       | gen_random_uuid() | PK                  | ID blueprint.                                                | cbp…                           |
| program_version_id        | uuid                | NO       | —                 | FK                  | ProgramVersion padre.                                        | pv…                            |
| credential_code           | varchar(64)         | NO       | —                 | UQ                  | Código único dentro de version.                              | MICRO-AI-GOV                   |
| credential_type_code      | varchar(80)         | NO       | —                 | EXT REF CT-02       | CERTIFICATE/BADGE/MICROCREDENTIAL u otro tipo parametrizado. | MICROCREDENTIAL                |
| display_name              | varchar(240)        | NO       | —                 | —                   | Nombre canónico de la credencial.                            | Microcredencial Gobierno de IA |
| description_text          | text                | YES      | NULL              | —                   | Descripción de alcance.                                      | Acredita…                      |
| verification_profile_code | varchar(80)         | YES      | NULL              | EXT REF CT-18/CT-05 | Perfil preferido de credencial verificable.                  | OPEN_BADGES_3                  |
| validity_policy_ref       | uuid                | YES      | NULL              | EXT REF CT-02       | Vigencia/expiración si aplica.                               | pol…                           |
| evidence_policy_ref       | uuid                | YES      | NULL              | EXT REF CT-02       | Evidencias requeridas para award.                            | pol…                           |
| status                    | varchar(24)         | NO       | 'DRAFT'           | CHECK               | DRAFT/ACTIVE/RETIRED.                                        | ACTIVE                         |
| created_at                | timestamptz         | NO       | now()             | —                   | Creación.                                                    | …                              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**credential_blueprint_id —** ID blueprint. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: cbp….

**program_version_id —** ProgramVersion padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**credential_code —** Código único dentro de version. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: MICRO-AI-GOV.

**credential_type_code —** CERTIFICATE/BADGE/MICROCREDENTIAL u otro tipo parametrizado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: MICROCREDENTIAL.

**display_name —** Nombre canónico de la credencial. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Microcredencial Gobierno de IA.

**description_text —** Descripción de alcance. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: Acredita….

**verification_profile_code —** Perfil preferido de credencial verificable. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: OPEN_BADGES_3.

**validity_policy_ref —** Vigencia/expiración si aplica. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**evidence_policy_ref —** Evidencias requeridas para award. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**status —** DRAFT/ACTIVE/RETIRED. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'DRAFT'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: ACTIVE.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|--------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_credential_blueprint         | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_credential_blueprint_code    | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_credential_blueprint_scope   | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_credential_blueprint_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_credential_blueprint_status  | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_child_mutability    | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir duplicados, cross-version y cambios cuando el parent está PUBLISHED/SUPERSEDED. |
|----------------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec01_credential_blueprint_requirement

QUÉ REPRESENTA — Compone condiciones del CredentialBlueprint contra targets del mismo ProgramVersion: completion del programa, ProgramRequirement, ProgramOutcome o StructureItem. La union tipada evita ambigüedad.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Hijo de CredentialBlueprint y ProgramVersion. EC-08 lee requirements de forma determinista para construir eligibility, pero la decisión individual ocurre allí.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege exactamente un target compatible con requirement_kind y mismo version scope. No almacena completion de participantes.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                        | **Ejemplo**     |
|---------------------------|---------------------|----------|-------------------|---------------|------------------------------------------------------------------------|-----------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*          | Tenant.                                                                | 8a…             |
| credential_requirement_id | uuid                | NO       | gen_random_uuid() | PK            | ID condition.                                                          | cr…             |
| credential_blueprint_id   | uuid                | NO       | —                 | FK            | Blueprint padre.                                                       | cbp…            |
| program_version_id        | uuid                | NO       | —                 | FK            | Version scope explícita para constraints defensivos.                   | pv…             |
| requirement_kind          | varchar(40)         | NO       | —                 | CHECK         | PROGRAM_COMPLETION/PROGRAM_REQUIREMENT/PROGRAM_OUTCOME/STRUCTURE_ITEM. | PROGRAM_OUTCOME |
| program_requirement_id    | uuid                | YES      | NULL              | FK            | Target cuando kind=PROGRAM_REQUIREMENT.                                | req…            |
| program_outcome_id        | uuid                | YES      | NULL              | FK            | Target cuando kind=PROGRAM_OUTCOME.                                    | out…            |
| structure_item_id         | uuid                | YES      | NULL              | FK            | Target cuando kind=STRUCTURE_ITEM.                                     | si…             |
| rule_policy_ref           | uuid                | YES      | NULL              | EXT REF CT-02 | Regla adicional/threshold.                                             | pol…            |
| mandatory                 | boolean             | NO       | true              | —             | Condición obligatoria.                                                 | true            |
| sequence_no               | integer             | NO       | —                 | CHECK         | Orden positivo.                                                        | 1               |
| created_at                | timestamptz         | NO       | now()             | —             | Creación.                                                              | …               |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**credential_requirement_id —** ID condition. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: cr….

**credential_blueprint_id —** Blueprint padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: cbp….

**program_version_id —** Version scope explícita para constraints defensivos. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**requirement_kind —** PROGRAM_COMPLETION/PROGRAM_REQUIREMENT/PROGRAM_OUTCOME/STRUCTURE_ITEM. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: PROGRAM_OUTCOME.

**program_requirement_id —** Target cuando kind=PROGRAM_REQUIREMENT. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: req….

**program_outcome_id —** Target cuando kind=PROGRAM_OUTCOME. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: out….

**structure_item_id —** Target cuando kind=STRUCTURE_ITEM. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: si….

**rule_policy_ref —** Regla adicional/threshold. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**mandatory —** Condición obligatoria. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es true; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: true.

**sequence_no —** Orden positivo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 1.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                                       | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|---------------------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_credential_blueprint_requirement                | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_credential_req_blueprint_same_version           | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_credential_req_program_requirement_same_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_credential_req_outcome_same_version             | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_credential_req_item_same_version                | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_credential_req_typed_target                     | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_credential_req_sequence                         | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_program_child_mutability                       | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir que un blueprint de V2 apunte a targets de V1 o que requirement_kind sea incompatible con las columnas target. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec01_pathway_definition

QUÉ REPRESENTA — Representa la identidad estable de una ruta de aprendizaje/microcredenciales acumulables. Puede sobrevivir a cambios de nodos y reglas mediante PathwayVersion.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es Aggregate Root independiente. Pathway Designer crea versiones; EC-10 consume una versión publicada y calcula progreso individual fuera de EC-01.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege pathway_code y lifecycle. No representa progreso, award ni equivalencia con grado.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                 | **Ejemplo**    |
|--------------------------|---------------------|----------|-------------------|---------------|---------------------------------|----------------|
| tenant_id                | uuid                | NO       | —                 | PK\*          | Tenant.                         | 8a…            |
| pathway_id               | uuid                | NO       | gen_random_uuid() | PK            | Identidad estable.              | pw…            |
| pathway_code             | varchar(64)         | NO       | —                 | UQ            | Código único por tenant.        | AI-LEADER-PATH |
| pathway_type_code        | varchar(80)         | NO       | —                 | EXT REF CT-02 | Tipo parametrizado de ruta.     | STACKABLE      |
| academic_owner_scope_ref | uuid                | NO       | —                 | EXT REF CT-01 | Owner institucional.            | scope…         |
| lifecycle_state          | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/ACTIVE/SUSPENDED/RETIRED. | ACTIVE         |
| created_by_subject       | uuid                | NO       | —                 | EXT REF IAM   | Creador.                        | usr…           |
| created_at               | timestamptz         | NO       | now()             | —             | Creación.                       | …              |
| updated_at               | timestamptz         | NO       | now()             | —             | Actualización metadata.         | …              |
| version                  | bigint              | NO       | 0                 | —             | Optimistic lock.                | 1              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**pathway_id —** Identidad estable. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: pw….

**pathway_code —** Código único por tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: AI-LEADER-PATH.

**pathway_type_code —** Tipo parametrizado de ruta. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: STACKABLE.

**academic_owner_scope_ref —** Owner institucional. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: scope….

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'DRAFT'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: ACTIVE.

**created_by_subject —** Creador. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: usr….

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**updated_at —** Actualización metadata. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**version —** Optimistic lock. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Se mapea con @Version; una versión obsoleta debe producir 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo de valor: 1.

### Constraints físicos implementables

| **Nombre físico**          | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|----------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_pathway_definition | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_pathway_code       | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_pathway_state      | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_pathway_owner      | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir códigos duplicados y estados inválidos por tenant. |
|-----------------------------------------------------------------------------------------------------|

## 12.16 ec01_pathway_version

QUÉ REPRESENTA — Representa un snapshot versionado de una ruta: nombre, descripción, stacking policy y grafo de nodos/edges.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo de PathwayDefinition. Al publicar queda inmutable y EC-10 pinnea pathway_version_id para evaluar progreso. Una nueva definición de stacking crea una versión posterior sin recalcular historia automáticamente.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege lineage same-pathway, una única PUBLISHED vigente y hash de integridad. No representa ParticipantLearningPath.

| **Campo**                        | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                  | **Ejemplo**       |
|----------------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------|-------------------|
| tenant_id                        | uuid                | NO       | —                 | PK\*          | Tenant.                                          | 8a…               |
| pathway_version_id               | uuid                | NO       | gen_random_uuid() | PK            | ID snapshot.                                     | pwv…              |
| pathway_id                       | uuid                | NO       | —                 | FK            | Definition padre.                                | pw…               |
| pathway_version_no               | integer             | NO       | —                 | UQ            | Número positivo de versión.                      | 2                 |
| previous_pathway_version_id      | uuid                | YES      | NULL              | FK            | Versión anterior del mismo pathway.              | pwv1…             |
| official_name                    | varchar(240)        | NO       | —                 | —             | Nombre canónico.                                 | Ruta Liderazgo IA |
| description_text                 | text                | YES      | NULL              | —             | Descripción.                                     | Ruta acumulable…  |
| stacking_policy_ref              | uuid                | NO       | —                 | EXT REF CT-02 | Política versionada que interpreta satisfacción. | pol…              |
| state                            | varchar(24)         | NO       | 'DRAFT'           | CHECK         | Lifecycle versionado.                            | PUBLISHED         |
| workflow_ref                     | uuid                | YES      | NULL              | EXT REF CT-06 | Review workflow.                                 | wf…               |
| content_hash                     | varchar(128)        | YES      | NULL              | —             | Hash al publish.                                 | sha256:…          |
| published_at                     | timestamptz         | YES      | NULL              | —             | Instante UTC.                                    | …                 |
| published_by_subject             | uuid                | YES      | NULL              | EXT REF IAM   | Publisher.                                       | usr…              |
| superseded_by_pathway_version_id | uuid                | YES      | NULL              | FK            | Nueva versión del mismo pathway.                 | pwv3…             |
| created_at                       | timestamptz         | NO       | now()             | —             | Creación.                                        | …                 |
| updated_at                       | timestamptz         | NO       | now()             | —             | Actualización editable.                          | …                 |
| version                          | bigint              | NO       | 0                 | —             | Optimistic lock.                                 | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**pathway_version_id —** ID snapshot. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: pwv….

**pathway_id —** Definition padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pw….

**pathway_version_no —** Número positivo de versión. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: 2.

**previous_pathway_version_id —** Versión anterior del mismo pathway. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pwv1….

**official_name —** Nombre canónico. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Ruta Liderazgo IA.

**description_text —** Descripción. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: Ruta acumulable….

**stacking_policy_ref —** Política versionada que interpreta satisfacción. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**state —** Lifecycle versionado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'DRAFT'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: PUBLISHED.

**workflow_ref —** Review workflow. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: wf….

**content_hash —** Hash al publish. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: sha256:….

**published_at —** Instante UTC. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**published_by_subject —** Publisher. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: usr….

**superseded_by_pathway_version_id —** Nueva versión del mismo pathway. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pwv3….

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**updated_at —** Actualización editable. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**version —** Optimistic lock. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Se mapea con @Version; una versión obsoleta debe producir 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo de valor: 4.

### Constraints físicos implementables

| **Nombre físico**                           | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|---------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_pathway_version                     | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_pathway_version_no                  | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_pathway_version_scope               | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_pathway_single_published            | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_pathway_version_definition          | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_pathway_previous_same_definition    | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_pathway_superseded_same_definition  | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_pathway_version_state               | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_pathway_version_state_immutability | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir lineage cruzado, dos PUBLISHED y mutación de snapshot publicado. |
|-------------------------------------------------------------------------------------------------------------------|

## 12.17 ec01_pathway_node

QUÉ REPRESENTA — Representa un nodo tipado dentro de una PathwayVersion. El nodo puede requerir un CredentialBlueprint local, una ProgramVersion local o una credencial externa gobernada por contrato.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo de PathwayVersion y extremo de PathwayEdge. La union de targets se valida físicamente para que node_type y target sean coherentes. EC-10 consume el nodo publicado sin reinterpretar su target.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege typed target y unicidad de node_code. No representa award/progress individual.

| **Campo**               | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                              | **Ejemplo**          |
|-------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------|----------------------|
| tenant_id               | uuid                | NO       | —                 | PK\*          | Tenant.                                                      | 8a…                  |
| pathway_node_id         | uuid                | NO       | gen_random_uuid() | PK            | ID nodo.                                                     | pn…                  |
| pathway_version_id      | uuid                | NO       | —                 | FK            | Version padre.                                               | pwv…                 |
| node_code               | varchar(64)         | NO       | —                 | UQ            | Código dentro de route version.                              | N1                   |
| node_type               | varchar(40)         | NO       | —                 | CHECK         | CREDENTIAL_BLUEPRINT/PROGRAM_VERSION/EXTERNAL_CREDENTIAL.    | CREDENTIAL_BLUEPRINT |
| credential_blueprint_id | uuid                | YES      | NULL              | FK            | Target local si node_type corresponde.                       | cbp…                 |
| program_version_id      | uuid                | YES      | NULL              | FK            | Target local de programa si corresponde.                     | pv…                  |
| external_credential_ref | uuid                | YES      | NULL              | EXT REF CT-18 | Target externo gobernado.                                    | ext…                 |
| title_override          | varchar(200)        | YES      | NULL              | —             | Label de presentación; no cambia target.                     | Fundamentos          |
| sequence_hint           | integer             | YES      | NULL              | CHECK         | Orden visual sugerido; edges siguen siendo autoridad lógica. | 1                    |
| created_at              | timestamptz         | NO       | now()             | —             | Creación.                                                    | …                    |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**pathway_node_id —** ID nodo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: pn….

**pathway_version_id —** Version padre. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pwv….

**node_code —** Código dentro de route version. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: N1.

**node_type —** CREDENTIAL_BLUEPRINT/PROGRAM_VERSION/EXTERNAL_CREDENTIAL. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: CREDENTIAL_BLUEPRINT.

**credential_blueprint_id —** Target local si node_type corresponde. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: cbp….

**program_version_id —** Target local de programa si corresponde. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**external_credential_ref —** Target externo gobernado. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: ext….

**title_override —** Label de presentación; no cambia target. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: Fundamentos.

**sequence_hint —** Orden visual sugerido; edges siguen siendo autoridad lógica. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 1.

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|--------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_pathway_node                 | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_pathway_node_code            | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_pathway_node_scope           | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_pathway_node_version         | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_pathway_node_blueprint       | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_pathway_node_program_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_pathway_node_typed_target    | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_pathway_node_sequence        | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_pathway_child_mutability    | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir node_type/target incoherente, duplicado y cambio post-publicación. |
|---------------------------------------------------------------------------------------------------------------------|

## 12.18 ec01_pathway_edge

QUÉ REPRESENTA — Representa relación dirigida entre nodos de una PathwayVersion para expresar secuencia, prerequisito o alternativa.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Es hijo de PathwayVersion. Graph validator y trigger defensivo comprueban same-version, no-self y acyclicity para tipos que deben ser acíclicos.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege integridad topológica. No representa que un participante haya recorrido la arista.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                     | **Ejemplo**   |
|--------------------|---------------------|----------|-------------------|---------------|-------------------------------------|---------------|
| tenant_id          | uuid                | NO       | —                 | PK\*          | Tenant.                             | 8a…           |
| pathway_edge_id    | uuid                | NO       | gen_random_uuid() | PK            | ID arista.                          | pe…           |
| pathway_version_id | uuid                | NO       | —                 | FK            | Version scope.                      | pwv…          |
| source_node_id     | uuid                | NO       | —                 | FK            | Nodo origen same version.           | pn1…          |
| target_node_id     | uuid                | NO       | —                 | FK            | Nodo destino same version.          | pn2…          |
| edge_type          | varchar(32)         | NO       | —                 | CHECK         | PRE_REQUISITE/SEQUENCE/ALTERNATIVE. | PRE_REQUISITE |
| rule_policy_ref    | uuid                | YES      | NULL              | EXT REF CT-02 | Regla adicional.                    | pol…          |
| created_at         | timestamptz         | NO       | now()             | —             | Creación.                           | …             |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**pathway_edge_id —** ID arista. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: pe….

**pathway_version_id —** Version scope. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pwv….

**source_node_id —** Nodo origen same version. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pn1….

**target_node_id —** Nodo destino same version. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pn2….

**edge_type —** PRE_REQUISITE/SEQUENCE/ALTERNATIVE. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: PRE_REQUISITE.

**rule_policy_ref —** Regla adicional. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: pol….

**created_at —** Creación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                        | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_pathway_edge                     | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_pathway_edge_source_same_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| fk_ec01_pathway_edge_target_same_version | FK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_pathway_edge                     | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_pathway_edge_type                | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_pathway_edge_no_self             | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_pathway_edge_no_cycle           | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| trg_ec01_pathway_child_mutability        | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir cross-version, self edge, duplicados y ciclos de prerequisite/sequence. |
|--------------------------------------------------------------------------------------------------------------------------|

## 12.19 ec01_design_change_request

QUÉ REPRESENTA — Representa una solicitud formal de cambio sobre ProgramVersion, LearningModuleVersion o PathwayVersion. Evita editar directamente diseños aprobados y deja lineage hacia workflow/evidencia.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — La crea un actor autorizado; CT-06 orquesta revisión. Cuando APPROVED, un application service crea/clona la nueva versión o ejecuta transition permitida. El request no modifica por sí solo el aggregate target.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege purpose, typed subject y lifecycle del cambio. No sustituye workflow CT-06 ni guarda documentos.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                    | **Ejemplo**         |
|----------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------|---------------------|
| tenant_id                  | uuid                | NO       | —                 | PK\*          | Tenant.                                                            | 8a…                 |
| change_request_id          | uuid                | NO       | gen_random_uuid() | PK            | ID.                                                                | dcr…                |
| subject_type               | varchar(40)         | NO       | —                 | CHECK         | PROGRAM_VERSION/MODULE_VERSION/PATHWAY_VERSION.                    | PROGRAM_VERSION     |
| program_version_id         | uuid                | YES      | NULL              | FK            | Target si program.                                                 | pv…                 |
| learning_module_version_id | uuid                | YES      | NULL              | FK            | Target si module.                                                  | lmv…                |
| pathway_version_id         | uuid                | YES      | NULL              | FK            | Target si pathway.                                                 | pwv…                |
| change_class_code          | varchar(80)         | NO       | —                 | EXT REF CT-02 | Clasificación material/non-material/compliance.                    | MATERIAL            |
| reason_code                | varchar(120)        | NO       | —                 | —             | Reason estable.                                                    | REGULATORY_UPDATE   |
| description_text           | text                | NO       | —                 | —             | Justificación.                                                     | Actualizar outcome… |
| evidence_ref               | uuid                | YES      | NULL              | EXT REF CT-05 | Evidencia adjunta.                                                 | ev…                 |
| workflow_ref               | uuid                | YES      | NULL              | EXT REF CT-06 | Caso de aprobación.                                                | wf…                 |
| status                     | varchar(32)         | NO       | 'DRAFT'           | CHECK         | DRAFT/SUBMITTED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/CANCELLED.  | UNDER_REVIEW        |
| requested_by_subject       | uuid                | NO       | —                 | EXT REF IAM   | Solicitante.                                                       | usr…                |
| requested_at               | timestamptz         | NO       | now()             | —             | Instante UTC.                                                      | …                   |
| applied_version_ref        | uuid                | YES      | NULL              | —             | ID de nueva versión creada/aplicada; semántica según subject_type. | pv3…                |
| version                    | bigint              | NO       | 0                 | —             | Optimistic lock.                                                   | 2                   |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**change_request_id —** ID. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: dcr….

**subject_type —** PROGRAM_VERSION/MODULE_VERSION/PATHWAY_VERSION. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: PROGRAM_VERSION.

**program_version_id —** Target si program. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**learning_module_version_id —** Target si module. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: lmv….

**pathway_version_id —** Target si pathway. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pwv….

**change_class_code —** Clasificación material/non-material/compliance. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: MATERIAL.

**reason_code —** Reason estable. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: REGULATORY_UPDATE.

**description_text —** Justificación. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: Actualizar outcome….

**evidence_ref —** Evidencia adjunta. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: ev….

**workflow_ref —** Caso de aprobación. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: wf….

**status —** DRAFT/SUBMITTED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/CANCELLED. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'DRAFT'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: UNDER_REVIEW.

**requested_by_subject —** Solicitante. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: usr….

**requested_at —** Instante UTC. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**applied_version_ref —** ID de nueva versión creada/aplicada; semántica según subject_type. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: pv3….

**version —** Optimistic lock. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Se mapea con @Version; una versión obsoleta debe producir 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo de valor: 2.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|--------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_design_change_request        | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_change_request_typed_subject | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_change_request_status        | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_change_request_queue         | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq_ec01_change_request_active_dedupe | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir requests sin target/target múltiple, estados imposibles y duplicación accidental de solicitud activa equivalente. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.20 ec01_publication_receipt

QUÉ REPRESENTA — Representa la evidencia durable de una publicación de ProgramVersion, LearningModuleVersion, PathwayVersion o CredentialBlueprint cuando se requiera. Conserva hash, actor, assurance, policy snapshot y referencias de evidencia.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se crea en la misma transacción local que el cambio a PUBLISHED/ACTIVE contractual y el outbox. Es append-only y se usa para auditoría, reconciliación y export del Engineering/Evidence Pack.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege exactly-one typed subject y unicidad por subject+content_hash. No es certificado de participante ni documento binario.

| **Campo**                      | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**         | **Descripción**                                                                                                                              | **Ejemplo**         |
|--------------------------------|---------------------|----------|-------------------|-------------------|----------------------------------------------------------------------------------------------------------------------------------------------|---------------------|
| **tenant_id**                  | uuid                | NO       | —                 | PK\*              | Tenant.                                                                                                                                      | 8a…                 |
| **publication_receipt_id**     | uuid                | NO       | gen_random_uuid() | PK                | ID receipt.                                                                                                                                  | rcpt…               |
| **subject_type**               | varchar(40)         | NO       | —                 | CHECK             | PROGRAM_VERSION/MODULE_VERSION/PATHWAY_VERSION. CredentialBlueprint se publica dentro del snapshot de ProgramVersion, no independientemente. | PROGRAM_VERSION     |
| **program_version_id**         | uuid                | YES      | NULL              | FK                | Subject local.                                                                                                                               | pv…                 |
| **learning_module_version_id** | uuid                | YES      | NULL              | FK                | Subject local.                                                                                                                               | lmv…                |
| **pathway_version_id**         | uuid                | YES      | NULL              | FK                | Subject local.                                                                                                                               | pwv…                |
| **content_hash**               | varchar(128)        | NO       | —                 | —                 | Hash del snapshot publicado.                                                                                                                 | sha256:…            |
| **policy_snapshot_json**       | jsonb               | NO       | '{}'::jsonb       | —                 | Versiones/refs de policy usadas; snapshot de reconstrucción, no catálogo nuevo.                                                              | {"attendance":"v3"} |
| **evidence_ref**               | uuid                | YES      | NULL              | EXT REF CT-05     | Evidence pack/firma/approval.                                                                                                                | ev…                 |
| **published_by_subject**       | uuid                | NO       | —                 | EXT REF IAM       | Actor.                                                                                                                                       | usr…                |
| **assurance_level_code**       | varchar(40)         | YES      | NULL              | EXT REF IAM/CT-10 | Assurance de la operación.                                                                                                                   | AAL2                |
| **correlation_id**             | uuid                | NO       | —                 | —                 | Correlación E2E.                                                                                                                             | corr…               |
| **published_at**               | timestamptz         | NO       | now()             | —                 | Instante UTC.                                                                                                                                | …                   |
| **hash_algorithm**             | varchar(24)         | NO       | 'SHA-256'         | CHECK             | Algoritmo explícito del content_hash; no inferir por longitud.                                                                               | SHA-256             |
| **canonical_schema_version**   | integer             | NO       | 1                 | CHECK             | Versión del canonical snapshot que alimenta el hash; reconstrucción determinista.                                                            | 1                   |
| **receipt_schema_version**     | integer             | NO       | 1                 | CHECK             | Versión semántica del receipt append-only.                                                                                                   | 1                   |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**publication_receipt_id —** ID receipt. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: rcpt….

**subject_type —** PROGRAM_VERSION/MODULE_VERSION/PATHWAY_VERSION/CREDENTIAL_BLUEPRINT. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: PROGRAM_VERSION.

**program_version_id —** Subject local. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pv….

**learning_module_version_id —** Subject local. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: lmv….

**pathway_version_id —** Subject local. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: pwv….

**credential_blueprint_id —** Subject local. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. La referencia es interna a EC-01 y la FK se define tenant-aware/scope-aware para impedir cruces lógicos. Ejemplo de valor: cbp….

**content_hash —** Hash del snapshot publicado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: sha256:….

**policy_snapshot_json —** Versiones/refs de policy usadas; snapshot de reconstrucción, no catálogo nuevo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es '{}'::jsonb; el Backend no debe depender de un default distinto al contrato Flyway. JSONB se usa para snapshot/envelope acotado y versionado, no para evadir modelado relacional de invariantes centrales. Ejemplo de valor: {"attendance":"v3"}.

**evidence_ref —** Evidence pack/firma/approval. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: ev….

**published_by_subject —** Actor. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: usr….

**assurance_level_code —** Assurance de la operación. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo de valor: AAL2.

**correlation_id —** Correlación E2E. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: corr….

**published_at —** Instante UTC. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                         | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|-------------------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_publication_receipt               | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_publication_receipt_typed_subject | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| uq partial por cada subject+content_hash  | TRIGGER  | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_publication_receipt_time          | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir receipts ambiguos y duplicados pese a NULL semantics de UNIQUE; los índices parciales se definen por subject concreto. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.21 ec01_command_idempotency

QUÉ REPRESENTA — Registro durable de comandos sensibles para garantizar replay seguro. No reemplaza business state; protege la frontera HTTP/event command.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — El application layer reserva key por tenant+operation+idempotency_key, persiste request_hash y response snapshot/ref. Si el mismo key llega de nuevo con mismo hash, retorna el resultado; con hash distinto, rechaza.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege duplicación por retry y race concurrente. No es un cache evictable de Redis.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**   | **PK/FK** | **Descripción**                                                       | **Ejemplo**             |
|------------------------|---------------------|----------|---------------|-----------|-----------------------------------------------------------------------|-------------------------|
| **tenant_id**          | uuid                | NO       | —             | PK\*      | Tenant.                                                               | 8a…                     |
| **operation_code**     | varchar(80)         | NO       | —             | PK\*      | Namespace del command.                                                | PUBLISH_PROGRAM_VERSION |
| **idempotency_key**    | varchar(160)        | NO       | —             | PK\*      | Key del cliente/consumer.                                             | idem-…                  |
| **request_hash**       | varchar(128)        | NO       | —             | —         | Hash canónico request.                                                | sha256:…                |
| **status**             | varchar(24)         | NO       | 'IN_PROGRESS' | CHECK     | IN_PROGRESS/SUCCEEDED/FAILED_RETRYABLE/FAILED_FINAL.                  | SUCCEEDED               |
| **resource_ref**       | uuid                | YES      | NULL          | —         | ID principal producido.                                               | pv…                     |
| **response_code**      | integer             | YES      | NULL          | CHECK     | HTTP/result code persistido.                                          | 200                     |
| **response_body_json** | jsonb               | YES      | NULL          | —         | Snapshot mínimo para replay; sin PII innecesaria.                     | {}                      |
| **created_at**         | timestamptz         | NO       | now()         | —         | Inicio.                                                               | …                       |
| **completed_at**       | timestamptz         | YES      | NULL          | —         | Finalización.                                                         | …                       |
| **expires_at**         | timestamptz         | YES      | NULL          | —         | Retención según policy; no borrar antes de ventana de retry.          | …                       |
| **lease_owner**        | varchar(160)        | YES      | NULL          | —         | Owner técnico temporal; requerido mientras IN_PROGRESS.               | pod-17:cmd-42           |
| **lease_until**        | timestamptz         | YES      | NULL          | CHECK     | Vencimiento UTC de ownership; habilita recovery tras crash.           | 2026-09-09T14:00Z       |
| **attempt_count**      | integer             | NO       | 1             | CHECK     | Número de adquisiciones/intentos, siempre \>0.                        | 2                       |
| **last_heartbeat_at**  | timestamptz         | YES      | NULL          | —         | Última señal opcional del owner para diagnóstico; no reemplaza lease. | …                       |
| **updated_at**         | timestamptz         | NO       | now()         | —         | Última transición durable del registro.                               | …                       |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**operation_code —** Namespace del command. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: PUBLISH_PROGRAM_VERSION.

**idempotency_key —** Key del cliente/consumer. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: idem-….

**request_hash —** Hash canónico request. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: sha256:….

**status —** IN_PROGRESS/SUCCEEDED/FAILED_RETRYABLE/FAILED_FINAL. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'IN_PROGRESS'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: SUCCEEDED.

**resource_ref —** ID principal producido. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: pv….

**response_code —** HTTP/result code persistido. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 200.

**response_body_json —** Snapshot mínimo para replay; sin PII innecesaria. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. JSONB se usa para snapshot/envelope acotado y versionado, no para evadir modelado relacional de invariantes centrales. Ejemplo de valor: {}.

**created_at —** Inicio. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**completed_at —** Finalización. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**expires_at —** Retención según policy; no borrar antes de ventana de retry. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**                 | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|-----------------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_command_idempotency       | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_idempotency_status        | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_idempotency_response_code | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_idempotency_expiry        | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir que dos requests con la misma clave creen dos publicaciones o clones; el Backend debe comparar request_hash. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.22 ec01_outbox_event

QUÉ REPRESENTA — Outbox transaccional de eventos de integración producidos por EC-01. Guarda envelope versionado y estado de entrega; es parte del patrón at-least-once.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — Se inserta en la misma transacción que el aggregate y receipt. Un dispatcher publica por CT-09/broker, actualiza delivery metadata y conserva event_id estable para dedup downstream.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege contra “guardar y publicar a mano”. No promete exactly-once ni sustituye el event broker.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                         | **Ejemplo**             |
|---------------------|---------------------|----------|-------------------|-----------|-------------------------------------------------------------------------|-------------------------|
| **tenant_id**       | uuid                | NO       | —                 | PK\*      | Tenant.                                                                 | 8a…                     |
| **event_id**        | uuid                | NO       | gen_random_uuid() | PK        | ID global estable.                                                      | evt…                    |
| **aggregate_type**  | varchar(80)         | NO       | —                 | —         | Tipo aggregate.                                                         | ProgramVersion          |
| **aggregate_id**    | uuid                | NO       | —                 | —         | ID aggregate.                                                           | pv…                     |
| **event_type**      | varchar(120)        | NO       | —                 | —         | Nombre contrato.                                                        | ProgramVersionPublished |
| **schema_version**  | integer             | NO       | 1                 | CHECK     | Versión de evento positiva.                                             | 1                       |
| **correlation_id**  | uuid                | NO       | —                 | —         | Correlation E2E.                                                        | corr…                   |
| **causation_id**    | uuid                | YES      | NULL              | —         | Mensaje/command causante.                                               | cmd…                    |
| **occurred_at**     | timestamptz         | NO       | now()             | —         | Hecho del dominio.                                                      | …                       |
| **payload_json**    | jsonb               | NO       | —                 | —         | Payload contractual minimizado.                                         | {}                      |
| **delivery_status** | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/DELIVERED/FAILED/UNKNOWN_EFFECT.                      | PENDING                 |
| **attempt_count**   | integer             | NO       | 0                 | CHECK     | Intentos \>=0.                                                          | 0                       |
| **next_attempt_at** | timestamptz         | YES      | NULL              | —         | Backoff.                                                                | …                       |
| **last_error_code** | varchar(120)        | YES      | NULL              | —         | Reason técnico estable.                                                 | BROKER_TIMEOUT          |
| **delivered_at**    | timestamptz         | YES      | NULL              | —         | Confirmación delivery.                                                  | …                       |
| **lease_owner**     | varchar(160)        | YES      | NULL              | —         | Owner del claim IN_FLIGHT.                                              | outbox-worker-2         |
| **lease_until**     | timestamptz         | YES      | NULL              | CHECK     | Vencimiento del claim; permite reclaim sin duplicar ownership primario. | …                       |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**event_id —** ID global estable. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es gen_random_uuid(); el Backend no debe depender de un default distinto al contrato Flyway. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: evt….

**aggregate_type —** Tipo aggregate. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: ProgramVersion.

**aggregate_id —** ID aggregate. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: pv….

**event_type —** Nombre contrato. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: ProgramVersionPublished.

**schema_version —** Versión de evento positiva. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 1; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 1.

**correlation_id —** Correlation E2E. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: corr….

**causation_id —** Mensaje/command causante. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: cmd….

**occurred_at —** Hecho del dominio. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**payload_json —** Payload contractual minimizado. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. JSONB se usa para snapshot/envelope acotado y versionado, no para evadir modelado relacional de invariantes centrales. Ejemplo de valor: {}.

**delivery_status —** PENDING/IN_FLIGHT/DELIVERED/FAILED/UNKNOWN_EFFECT. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'PENDING'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: PENDING.

**attempt_count —** Intentos \>=0. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 0; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 0.

**next_attempt_at —** Backoff. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**last_error_code —** Reason técnico estable. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: BROKER_TIMEOUT.

**delivered_at —** Confirmación delivery. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

### Constraints físicos implementables

| **Nombre físico**       | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|-------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_outbox_event    | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_outbox_schema   | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_outbox_status   | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_outbox_attempts | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_outbox_dispatch | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir estados/contadores inválidos y mantener event_id único/durable para reintentos. |
|----------------------------------------------------------------------------------------------------------------------------------|

## 12.23 ec01_inbox_message

QUÉ REPRESENTA — Registro durable de mensajes/comandos externos ya procesados por EC-01 para deduplicación.

CÓMO PARTICIPA ARQUITECTÓNICAMENTE — El adapter de consumo intenta insertar tenant_id+message_id antes de aplicar side effects; duplicate implica replay seguro. Puede conservar payload hash y resultado de procesamiento para auditoría/reconciliation.

QUÉ PROTEGE / QUÉ NO REPRESENTA — Protege duplicate delivery at-least-once. No es cola ni broker.

| **Campo**         | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**                           | **Ejemplo**               |
|-------------------|---------------------|----------|-------------|-----------|-------------------------------------------|---------------------------|
| tenant_id         | uuid                | NO       | —           | PK\*      | Tenant.                                   | 8a…                       |
| message_id        | uuid                | NO       | —           | PK        | ID mensaje externo.                       | msg…                      |
| consumer_code     | varchar(120)        | NO       | —           | PK\*      | Consumer lógico.                          | EC01_WORKFLOW_RESULT      |
| message_type      | varchar(120)        | NO       | —           | —         | Tipo de mensaje.                          | WorkflowDecisionCompleted |
| schema_version    | integer             | NO       | 1           | CHECK     | Versión positiva.                         | 1                         |
| payload_hash      | varchar(128)        | NO       | —           | —         | Detecta reuse anómalo de ID.              | sha256:…                  |
| processing_status | varchar(24)         | NO       | 'RECEIVED'  | CHECK     | RECEIVED/PROCESSED/FAILED.                | PROCESSED                 |
| received_at       | timestamptz         | NO       | now()       | —         | Recepción.                                | …                         |
| processed_at      | timestamptz         | YES      | NULL        | —         | Fin.                                      | …                         |
| result_ref        | uuid                | YES      | NULL        | —         | Aggregate/receipt afectado cuando aplica. | pv…                       |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Nunca se acepta desde un body libre; proviene del Security/Tenant Context autorizado y se aplica en toda query. Ejemplo de valor: 8a….

**message_id —** ID mensaje externo. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: msg….

**consumer_code —** Consumer lógico. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Participa en la identidad física de la fila y en el aislamiento tenant-aware. Ejemplo de valor: EC01_WORKFLOW_RESULT.

**message_type —** Tipo de mensaje. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: WorkflowDecisionCompleted.

**schema_version —** Versión positiva. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 1; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: 1.

**payload_hash —** Detecta reuse anómalo de ID. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. No posee default físico significativo; debe ser provisto o derivado explícitamente por la capa responsable. Ejemplo de valor: sha256:….

**processing_status —** RECEIVED/PROCESSED/FAILED. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es 'RECEIVED'; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: PROCESSED.

**received_at —** Recepción. Es obligatorio; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es now(); el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**processed_at —** Fin. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; la zona horaria se aplica solo al presentar. Ejemplo de valor: ….

**result_ref —** Aggregate/receipt afectado cuando aplica. Puede ser NULL únicamente cuando la ausencia tiene significado de negocio documentado; NULL no debe confundirse con cero, cadena vacía ni un estado favorable. El default físico es NULL; el Backend no debe depender de un default distinto al contrato Flyway. Ejemplo de valor: pv….

### Constraints físicos implementables

| **Nombre físico**      | **Tipo** | **Definición/expresión**         | **Error que impide**                                                                   |
|------------------------|----------|----------------------------------|----------------------------------------------------------------------------------------|
| pk_ec01_inbox_message  | PK       | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_inbox_schema   | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ck_ec01_inbox_status   | CHECK    | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |
| ix_ec01_inbox_received | UQ/INDEX | Ver DDL Flyway de la sección 13. | Impide violación de identidad/scope/estado o mutación prohibida asociada a esta tabla. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Debe impedir procesar dos veces el mismo message_id para el mismo consumer y detectar payload diferente con mismo ID a nivel de adapter. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.24 Hardening físico V1.1 — deltas normativos sobre tablas críticas

Las definiciones tabla por tabla anteriores continúan vigentes salvo los deltas de esta subsección. El DDL de la sección 13 ya incorpora estos cambios de forma canónica y ejecutable; no existe un “script alternativo”.

| **Tabla**               | **Delta V1.1**                                                                                                                                     | **Qué error debe impedir PostgreSQL**                                                                                    |
|-------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| program_version         | Añade SCHEDULED al state machine; publication fields también aplican a SCHEDULED; lineage monotónico; contenido solo editable en DRAFT.            | Editar snapshot revisado/aprobado/programado/publicado; lineage self/invertido; publicación sin hash/evidencia temporal. |
| program_structure_group | El orden es sibling-scoped con índices parciales root/child; trigger de jerarquía acíclica.                                                        | Que dos grupos hermanos tengan igual orden o que A sea ancestro de sí mismo indirectamente.                              |
| structure_dependency    | Cycle trigger excluye OLD edge en UPDATE.                                                                                                          | Falso positivo/negativo al editar aristas y ciclos reales PRE_REQUISITE/SEQUENCE.                                        |
| pathway_edge            | Misma corrección de UPDATE cycle-safe.                                                                                                             | Ciclos reales y validación incorrecta por edge antiguo.                                                                  |
| publication_receipt     | Elimina subject CREDENTIAL_BLUEPRINT independiente; agrega hash_algorithm, canonical_schema_version, receipt_schema_version y trigger append-only. | Alterar evidencia publicada o publicar blueprint fuera del snapshot del programa.                                        |
| command_idempotency     | Agrega lease_owner, lease_until, attempt_count, last_heartbeat_at, updated_at e índice de recovery.                                                | IN_PROGRESS huérfano tras crash o doble owner simultáneo sin recuperación controlada.                                    |
| outbox_event            | Agrega lease_owner/lease_until e índice de reclaim; claim usa SKIP LOCKED.                                                                         | Dos pods despachando el mismo event como owner primario o evento IN_FLIGHT huérfano.                                     |
| todas tenant-owned      | ENABLE + FORCE RLS; policy basada en current_tenant_id.                                                                                            | SELECT/UPDATE cross-tenant por olvido de filtro en repository.                                                           |

### 12.24.1 Nuevos atributos físicos V1.1

| **Campo**                | **Tabla**                          | **Tipo/Null**        | **Propósito y validación**                                                                                   |
|--------------------------|------------------------------------|----------------------|--------------------------------------------------------------------------------------------------------------|
| hash_algorithm           | publication_receipt                | varchar(24) NOT NULL | Identifica algoritmo usado para content_hash; solo lista permitida. No se infiere por longitud.              |
| canonical_schema_version | publication_receipt                | integer NOT NULL     | Versiona el algoritmo/esquema de canonicalización previo al hash para reconstrucción histórica determinista. |
| receipt_schema_version   | publication_receipt                | integer NOT NULL     | Versiona estructura semántica del receipt sin mutarlo retrospectivamente.                                    |
| lease_owner              | command_idempotency / outbox_event | varchar(160) NULL    | Identidad técnica del owner temporal; obligatorio mientras estado esté IN_PROGRESS/IN_FLIGHT.                |
| lease_until              | command_idempotency / outbox_event | timestamptz NULL     | Vencimiento UTC tras el cual el trabajo puede recuperarse de forma gobernada.                                |
| attempt_count            | command_idempotency                | integer NOT NULL     | Cantidad de adquisiciones/intentos; positivo y auditable.                                                    |
| last_heartbeat_at        | command_idempotency                | timestamptz NULL     | Última señal del owner para diagnosticar operaciones largas; no reemplaza lease_until.                       |
| updated_at               | command_idempotency                | timestamptz NOT NULL | Marca la última transición del registro durable de idempotencia.                                             |

# 13. DDL PostgreSQL completo — Flyway Ready

Baseline canónico V1.1 sugerido: V20260909_0101\_\_ec01_portfolio_design_v11.sql. Este DDL sustituye el DDL de V1.0 y es deliberadamente defensivo: PK/FK tenant-aware + RLS, state guards, Aggregate Revision Contract, lineage monotónico, grafos acíclicos, receipts append-only, idempotencia/outbox con leases y separación de roles. Los nombres físicos pueden ajustarse solo por convención AM-00; las invariantes no se degradan.

CREATE SCHEMA IF NOT EXISTS ec01;

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE EXTENSION IF NOT EXISTS btree_gist;

CREATE TABLE ec01.program_definition (

tenant_id uuid NOT NULL,

program_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_code varchar(64) NOT NULL,

program_family_code varchar(80) NOT NULL,

academic_owner_scope_ref uuid NOT NULL,

default_language_code varchar(16) NOT NULL DEFAULT 'es-BO',

lifecycle_state varchar(24) NOT NULL DEFAULT 'DRAFT',

created_by_subject uuid NOT NULL,

created_at timestamptz NOT NULL DEFAULT now(),

updated_at timestamptz NOT NULL DEFAULT now(),

version bigint NOT NULL DEFAULT 0,

CONSTRAINT pk_ec01_program_definition PRIMARY KEY (tenant_id, program_id),

CONSTRAINT uq_ec01_program_definition_code UNIQUE (tenant_id, program_code),

CONSTRAINT ck_ec01_program_definition_state CHECK (lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED')),

CONSTRAINT ck_ec01_program_definition_code CHECK (btrim(program_code) \<\> '')

);

CREATE INDEX ix_ec01_program_definition_owner_state ON ec01.program_definition(tenant_id, academic_owner_scope_ref, lifecycle_state);

CREATE TABLE ec01.program_version (

tenant_id uuid NOT NULL,

program_version_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_id uuid NOT NULL,

version_no integer NOT NULL,

previous_version_id uuid NULL,

official_name varchar(240) NOT NULL,

short_name varchar(120) NULL,

purpose_text text NOT NULL,

target_audience_text text NULL,

academic_hours numeric(10,2) NOT NULL,

credit_scheme_code varchar(40) NULL,

credits numeric(10,2) NULL,

completion_model_code varchar(80) NOT NULL,

attendance_policy_ref uuid NULL,

assessment_policy_ref uuid NULL,

certification_policy_ref uuid NULL,

compliance_profile_ref uuid NULL,

valid_from date NULL,

valid_to date NULL,

state varchar(24) NOT NULL DEFAULT 'DRAFT',

workflow_ref uuid NULL,

review_snapshot_hash varchar(128) NULL,

content_hash varchar(128) NULL,

published_at timestamptz NULL,

published_by_subject uuid NULL,

superseded_by_version_id uuid NULL,

created_at timestamptz NOT NULL DEFAULT now(),

updated_at timestamptz NOT NULL DEFAULT now(),

version bigint NOT NULL DEFAULT 0,

CONSTRAINT pk_ec01_program_version PRIMARY KEY (tenant_id, program_version_id),

CONSTRAINT uq_ec01_program_version_no UNIQUE (tenant_id, program_id, version_no),

CONSTRAINT uq_ec01_program_version_scope UNIQUE (tenant_id, program_version_id, program_id),

CONSTRAINT fk_ec01_program_version_program FOREIGN KEY (tenant_id, program_id)

REFERENCES ec01.program_definition(tenant_id, program_id),

CONSTRAINT fk_ec01_program_version_previous_same_program FOREIGN KEY (tenant_id, previous_version_id, program_id)

REFERENCES ec01.program_version(tenant_id, program_version_id, program_id),

CONSTRAINT fk_ec01_program_version_superseded_same_program FOREIGN KEY (tenant_id, superseded_by_version_id, program_id)

REFERENCES ec01.program_version(tenant_id, program_version_id, program_id),

CONSTRAINT ck_ec01_program_version_no CHECK (version_no \> 0),

CONSTRAINT ck_ec01_program_version_hours CHECK (academic_hours \> 0),

CONSTRAINT ck_ec01_program_version_credits_pair CHECK ((credits IS NULL AND credit_scheme_code IS NULL) OR (credits \> 0 AND credit_scheme_code IS NOT NULL)),

CONSTRAINT ck_ec01_program_version_dates CHECK (valid_to IS NULL OR valid_from IS NULL OR valid_to \>= valid_from),

CONSTRAINT ck_ec01_program_version_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID')),

CONSTRAINT ck_ec01_program_version_publish_fields CHECK (

state NOT IN ('SCHEDULED','PUBLISHED','SUPERSEDED') OR

(content_hash IS NOT NULL AND published_at IS NOT NULL AND published_by_subject IS NOT NULL AND valid_from IS NOT NULL)

)

);

CREATE UNIQUE INDEX uq_ec01_program_single_published ON ec01.program_version(tenant_id, program_id) WHERE state='PUBLISHED';

CREATE INDEX ix_ec01_program_version_queue ON ec01.program_version(tenant_id, state, updated_at DESC);

CREATE TABLE ec01.program_delivery_mode_binding (

tenant_id uuid NOT NULL,

delivery_mode_binding_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_version_id uuid NOT NULL,

delivery_mode_code varchar(80) NOT NULL,

is_default boolean NOT NULL DEFAULT false,

policy_ref uuid NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_program_delivery_mode_binding PRIMARY KEY (tenant_id, delivery_mode_binding_id),

CONSTRAINT fk_ec01_delivery_mode_program_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id) ON DELETE CASCADE,

CONSTRAINT uq_ec01_delivery_mode_per_version UNIQUE (tenant_id, program_version_id, delivery_mode_code)

);

CREATE INDEX ix_ec01_delivery_mode_code ON ec01.program_delivery_mode_binding(tenant_id, delivery_mode_code);

CREATE TABLE ec01.program_outcome (

tenant_id uuid NOT NULL,

outcome_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_version_id uuid NOT NULL,

outcome_code varchar(64) NOT NULL,

statement text NOT NULL,

taxonomy_level_code varchar(64) NULL,

sequence_no integer NOT NULL,

mandatory boolean NOT NULL DEFAULT true,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_program_outcome PRIMARY KEY (tenant_id, outcome_id),

CONSTRAINT uq_ec01_program_outcome_scope UNIQUE (tenant_id, program_version_id, outcome_id),

CONSTRAINT uq_ec01_program_outcome_code UNIQUE (tenant_id, program_version_id, outcome_code),

CONSTRAINT uq_ec01_program_outcome_order UNIQUE (tenant_id, program_version_id, sequence_no),

CONSTRAINT fk_ec01_program_outcome_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id) ON DELETE CASCADE,

CONSTRAINT ck_ec01_program_outcome_sequence CHECK (sequence_no \> 0),

CONSTRAINT ck_ec01_program_outcome_statement CHECK (btrim(statement) \<\> '')

);

CREATE TABLE ec01.program_competency_binding (

tenant_id uuid NOT NULL,

competency_binding_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_version_id uuid NOT NULL,

outcome_id uuid NULL,

competency_ref uuid NOT NULL,

level_code varchar(64) NULL,

weight numeric(6,3) NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_program_competency_binding PRIMARY KEY (tenant_id, competency_binding_id),

CONSTRAINT fk_ec01_comp_binding_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id) ON DELETE CASCADE,

CONSTRAINT fk_ec01_comp_binding_outcome_same_version FOREIGN KEY (tenant_id, program_version_id, outcome_id) REFERENCES ec01.program_outcome(tenant_id, program_version_id, outcome_id),

CONSTRAINT ck_ec01_comp_binding_weight CHECK (weight IS NULL OR (weight \>= 0 AND weight \<= 1))

);

CREATE TABLE ec01.learning_module_definition (

tenant_id uuid NOT NULL,

learning_module_id uuid NOT NULL DEFAULT gen_random_uuid(),

module_code varchar(64) NOT NULL,

module_type_code varchar(80) NOT NULL,

academic_owner_scope_ref uuid NOT NULL,

lifecycle_state varchar(24) NOT NULL DEFAULT 'DRAFT',

created_by_subject uuid NOT NULL,

created_at timestamptz NOT NULL DEFAULT now(),

updated_at timestamptz NOT NULL DEFAULT now(),

version bigint NOT NULL DEFAULT 0,

CONSTRAINT pk_ec01_learning_module_definition PRIMARY KEY (tenant_id, learning_module_id),

CONSTRAINT uq_ec01_learning_module_code UNIQUE (tenant_id, module_code),

CONSTRAINT ck_ec01_learning_module_state CHECK (lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED'))

);

CREATE INDEX ix_ec01_learning_module_owner ON ec01.learning_module_definition(tenant_id, academic_owner_scope_ref, lifecycle_state);

CREATE TABLE ec01.learning_module_version (

tenant_id uuid NOT NULL,

learning_module_version_id uuid NOT NULL DEFAULT gen_random_uuid(),

learning_module_id uuid NOT NULL,

module_version_no integer NOT NULL,

previous_module_version_id uuid NULL,

official_title varchar(240) NOT NULL,

description_text text NULL,

module_hours numeric(10,2) NOT NULL,

credit_scheme_code varchar(40) NULL,

module_credits numeric(10,2) NULL,

assessment_required boolean NOT NULL DEFAULT false,

assessment_policy_ref uuid NULL,

state varchar(24) NOT NULL DEFAULT 'DRAFT',

workflow_ref uuid NULL,

content_hash varchar(128) NULL,

published_at timestamptz NULL,

published_by_subject uuid NULL,

superseded_by_module_version_id uuid NULL,

created_at timestamptz NOT NULL DEFAULT now(),

updated_at timestamptz NOT NULL DEFAULT now(),

version bigint NOT NULL DEFAULT 0,

CONSTRAINT pk_ec01_learning_module_version PRIMARY KEY (tenant_id, learning_module_version_id),

CONSTRAINT uq_ec01_module_version_no UNIQUE (tenant_id, learning_module_id, module_version_no),

CONSTRAINT uq_ec01_module_version_scope UNIQUE (tenant_id, learning_module_version_id, learning_module_id),

CONSTRAINT fk_ec01_module_version_definition FOREIGN KEY (tenant_id, learning_module_id) REFERENCES ec01.learning_module_definition(tenant_id, learning_module_id),

CONSTRAINT fk_ec01_module_previous_same_definition FOREIGN KEY (tenant_id, previous_module_version_id, learning_module_id) REFERENCES ec01.learning_module_version(tenant_id, learning_module_version_id, learning_module_id),

CONSTRAINT fk_ec01_module_superseded_same_definition FOREIGN KEY (tenant_id, superseded_by_module_version_id, learning_module_id) REFERENCES ec01.learning_module_version(tenant_id, learning_module_version_id, learning_module_id),

CONSTRAINT ck_ec01_module_version_no CHECK (module_version_no \> 0),

CONSTRAINT ck_ec01_module_version_hours CHECK (module_hours \> 0),

CONSTRAINT ck_ec01_module_version_credits CHECK ((module_credits IS NULL AND credit_scheme_code IS NULL) OR (module_credits \> 0 AND credit_scheme_code IS NOT NULL)),

CONSTRAINT ck_ec01_module_version_assessment CHECK (NOT assessment_required OR assessment_policy_ref IS NOT NULL),

CONSTRAINT ck_ec01_module_version_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','PUBLISHED','SUPERSEDED','VOID')),

CONSTRAINT ck_ec01_module_version_publish_fields CHECK (state NOT IN ('PUBLISHED','SUPERSEDED') OR (content_hash IS NOT NULL AND published_at IS NOT NULL AND published_by_subject IS NOT NULL))

);

CREATE UNIQUE INDEX uq_ec01_module_single_published ON ec01.learning_module_version(tenant_id, learning_module_id) WHERE state='PUBLISHED';

CREATE TABLE ec01.learning_module_outcome (

tenant_id uuid NOT NULL,

module_outcome_id uuid NOT NULL DEFAULT gen_random_uuid(),

learning_module_version_id uuid NOT NULL,

outcome_code varchar(64) NOT NULL,

statement text NOT NULL,

taxonomy_level_code varchar(64) NULL,

sequence_no integer NOT NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_learning_module_outcome PRIMARY KEY (tenant_id, module_outcome_id),

CONSTRAINT uq_ec01_module_outcome_code UNIQUE (tenant_id, learning_module_version_id, outcome_code),

CONSTRAINT uq_ec01_module_outcome_order UNIQUE (tenant_id, learning_module_version_id, sequence_no),

CONSTRAINT fk_ec01_module_outcome_version FOREIGN KEY (tenant_id, learning_module_version_id) REFERENCES ec01.learning_module_version(tenant_id, learning_module_version_id) ON DELETE CASCADE,

CONSTRAINT ck_ec01_module_outcome_sequence CHECK (sequence_no \> 0),

CONSTRAINT ck_ec01_module_outcome_statement CHECK (btrim(statement) \<\> '')

);

CREATE TABLE ec01.program_structure_group (

tenant_id uuid NOT NULL,

structure_group_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_version_id uuid NOT NULL,

parent_group_id uuid NULL,

group_code varchar(64) NOT NULL,

group_type_code varchar(64) NOT NULL,

title varchar(200) NOT NULL,

min_items integer NOT NULL DEFAULT 0,

max_items integer NULL,

sequence_no integer NOT NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_program_structure_group PRIMARY KEY (tenant_id, structure_group_id),

CONSTRAINT uq_ec01_structure_group_scope UNIQUE (tenant_id, program_version_id, structure_group_id),

CONSTRAINT uq_ec01_structure_group_code UNIQUE (tenant_id, program_version_id, group_code),

CONSTRAINT fk_ec01_structure_group_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id) ON DELETE CASCADE,

CONSTRAINT fk_ec01_structure_group_parent_same_version FOREIGN KEY (tenant_id, program_version_id, parent_group_id) REFERENCES ec01.program_structure_group(tenant_id, program_version_id, structure_group_id),

CONSTRAINT ck_ec01_structure_group_cardinality CHECK (min_items \>= 0 AND (max_items IS NULL OR max_items \>= min_items)),

CONSTRAINT ck_ec01_structure_group_sequence CHECK (sequence_no \> 0),

CONSTRAINT ck_ec01_structure_group_no_self_parent CHECK (parent_group_id IS NULL OR parent_group_id \<\> structure_group_id)

);

CREATE UNIQUE INDEX uq_ec01_structure_group_root_order ON ec01.program_structure_group(tenant_id, program_version_id, sequence_no) WHERE parent_group_id IS NULL;

CREATE UNIQUE INDEX uq_ec01_structure_group_child_order ON ec01.program_structure_group(tenant_id, program_version_id, parent_group_id, sequence_no) WHERE parent_group_id IS NOT NULL;

CREATE TABLE ec01.program_structure_item (

tenant_id uuid NOT NULL,

structure_item_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_version_id uuid NOT NULL,

structure_group_id uuid NOT NULL,

learning_module_version_id uuid NOT NULL,

slot_code varchar(64) NOT NULL,

sequence_no integer NOT NULL,

mandatory boolean NOT NULL DEFAULT true,

hours_override numeric(10,2) NULL,

credits_override numeric(10,2) NULL,

override_reason_code varchar(80) NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_program_structure_item PRIMARY KEY (tenant_id, structure_item_id),

CONSTRAINT uq_ec01_structure_item_scope UNIQUE (tenant_id, program_version_id, structure_item_id),

CONSTRAINT uq_ec01_structure_item_slot UNIQUE (tenant_id, program_version_id, slot_code),

CONSTRAINT uq_ec01_structure_item_group_order UNIQUE (tenant_id, structure_group_id, sequence_no),

CONSTRAINT fk_ec01_structure_item_group_same_version FOREIGN KEY (tenant_id, program_version_id, structure_group_id) REFERENCES ec01.program_structure_group(tenant_id, program_version_id, structure_group_id),

CONSTRAINT fk_ec01_structure_item_module_version FOREIGN KEY (tenant_id, learning_module_version_id) REFERENCES ec01.learning_module_version(tenant_id, learning_module_version_id),

CONSTRAINT ck_ec01_structure_item_sequence CHECK (sequence_no \> 0),

CONSTRAINT ck_ec01_structure_item_overrides CHECK (

(hours_override IS NULL OR hours_override \> 0) AND

(credits_override IS NULL OR credits_override \> 0) AND

((hours_override IS NULL AND credits_override IS NULL) OR override_reason_code IS NOT NULL)

)

);

CREATE TABLE ec01.structure_dependency (

tenant_id uuid NOT NULL,

structure_dependency_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_version_id uuid NOT NULL,

from_structure_item_id uuid NOT NULL,

to_structure_item_id uuid NOT NULL,

dependency_type varchar(32) NOT NULL,

policy_ref uuid NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_structure_dependency PRIMARY KEY (tenant_id, structure_dependency_id),

CONSTRAINT fk_ec01_structure_dependency_from_same_version FOREIGN KEY (tenant_id, program_version_id, from_structure_item_id) REFERENCES ec01.program_structure_item(tenant_id, program_version_id, structure_item_id),

CONSTRAINT fk_ec01_structure_dependency_to_same_version FOREIGN KEY (tenant_id, program_version_id, to_structure_item_id) REFERENCES ec01.program_structure_item(tenant_id, program_version_id, structure_item_id),

CONSTRAINT uq_ec01_structure_dependency UNIQUE (tenant_id, program_version_id, from_structure_item_id, to_structure_item_id, dependency_type),

CONSTRAINT ck_ec01_structure_dependency_type CHECK (dependency_type IN ('PRE_REQUISITE','CO_REQUISITE','SEQUENCE')),

CONSTRAINT ck_ec01_structure_dependency_no_self CHECK (from_structure_item_id \<\> to_structure_item_id)

);

CREATE TABLE ec01.program_requirement_binding (

tenant_id uuid NOT NULL,

program_requirement_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_version_id uuid NOT NULL,

requirement_code varchar(64) NOT NULL,

requirement_type_code varchar(80) NOT NULL,

title varchar(200) NOT NULL,

eligibility_rule_ref uuid NOT NULL,

mandatory boolean NOT NULL DEFAULT true,

sequence_no integer NOT NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_program_requirement_binding PRIMARY KEY (tenant_id, program_requirement_id),

CONSTRAINT uq_ec01_program_requirement_scope UNIQUE (tenant_id, program_version_id, program_requirement_id),

CONSTRAINT uq_ec01_program_requirement_code UNIQUE (tenant_id, program_version_id, requirement_code),

CONSTRAINT fk_ec01_program_requirement_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id) ON DELETE CASCADE,

CONSTRAINT ck_ec01_program_requirement_sequence CHECK (sequence_no \> 0)

);

CREATE TABLE ec01.credential_blueprint (

tenant_id uuid NOT NULL,

credential_blueprint_id uuid NOT NULL DEFAULT gen_random_uuid(),

program_version_id uuid NOT NULL,

credential_code varchar(64) NOT NULL,

credential_type_code varchar(80) NOT NULL,

display_name varchar(240) NOT NULL,

description_text text NULL,

verification_profile_code varchar(80) NULL,

validity_policy_ref uuid NULL,

evidence_policy_ref uuid NULL,

status varchar(24) NOT NULL DEFAULT 'DRAFT',

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_credential_blueprint PRIMARY KEY (tenant_id, credential_blueprint_id),

CONSTRAINT uq_ec01_credential_blueprint_scope UNIQUE (tenant_id, program_version_id, credential_blueprint_id),

CONSTRAINT uq_ec01_credential_blueprint_code UNIQUE (tenant_id, program_version_id, credential_code),

CONSTRAINT fk_ec01_credential_blueprint_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id) ON DELETE CASCADE,

CONSTRAINT ck_ec01_credential_blueprint_status CHECK (status IN ('DRAFT','ACTIVE','RETIRED'))

);

CREATE TABLE ec01.credential_blueprint_requirement (

tenant_id uuid NOT NULL,

credential_requirement_id uuid NOT NULL DEFAULT gen_random_uuid(),

credential_blueprint_id uuid NOT NULL,

program_version_id uuid NOT NULL,

requirement_kind varchar(40) NOT NULL,

program_requirement_id uuid NULL,

program_outcome_id uuid NULL,

structure_item_id uuid NULL,

rule_policy_ref uuid NULL,

mandatory boolean NOT NULL DEFAULT true,

sequence_no integer NOT NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_credential_blueprint_requirement PRIMARY KEY (tenant_id, credential_requirement_id),

CONSTRAINT fk_ec01_credential_req_blueprint_same_version FOREIGN KEY (tenant_id, program_version_id, credential_blueprint_id) REFERENCES ec01.credential_blueprint(tenant_id, program_version_id, credential_blueprint_id) ON DELETE CASCADE,

CONSTRAINT fk_ec01_credential_req_program_requirement_same_version FOREIGN KEY (tenant_id, program_version_id, program_requirement_id) REFERENCES ec01.program_requirement_binding(tenant_id, program_version_id, program_requirement_id),

CONSTRAINT fk_ec01_credential_req_outcome_same_version FOREIGN KEY (tenant_id, program_version_id, program_outcome_id) REFERENCES ec01.program_outcome(tenant_id, program_version_id, outcome_id),

CONSTRAINT fk_ec01_credential_req_item_same_version FOREIGN KEY (tenant_id, program_version_id, structure_item_id) REFERENCES ec01.program_structure_item(tenant_id, program_version_id, structure_item_id),

CONSTRAINT ck_ec01_credential_req_typed_target CHECK (

(requirement_kind='PROGRAM_COMPLETION' AND num_nonnulls(program_requirement_id, program_outcome_id, structure_item_id)=0) OR

(requirement_kind='PROGRAM_REQUIREMENT' AND program_requirement_id IS NOT NULL AND program_outcome_id IS NULL AND structure_item_id IS NULL) OR

(requirement_kind='PROGRAM_OUTCOME' AND program_outcome_id IS NOT NULL AND program_requirement_id IS NULL AND structure_item_id IS NULL) OR

(requirement_kind='STRUCTURE_ITEM' AND structure_item_id IS NOT NULL AND program_requirement_id IS NULL AND program_outcome_id IS NULL)

),

CONSTRAINT ck_ec01_credential_req_sequence CHECK (sequence_no \> 0)

);

CREATE TABLE ec01.pathway_definition (

tenant_id uuid NOT NULL,

pathway_id uuid NOT NULL DEFAULT gen_random_uuid(),

pathway_code varchar(64) NOT NULL,

pathway_type_code varchar(80) NOT NULL,

academic_owner_scope_ref uuid NOT NULL,

lifecycle_state varchar(24) NOT NULL DEFAULT 'DRAFT',

created_by_subject uuid NOT NULL,

created_at timestamptz NOT NULL DEFAULT now(),

updated_at timestamptz NOT NULL DEFAULT now(),

version bigint NOT NULL DEFAULT 0,

CONSTRAINT pk_ec01_pathway_definition PRIMARY KEY (tenant_id, pathway_id),

CONSTRAINT uq_ec01_pathway_code UNIQUE (tenant_id, pathway_code),

CONSTRAINT ck_ec01_pathway_state CHECK (lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED'))

);

CREATE INDEX ix_ec01_pathway_owner ON ec01.pathway_definition(tenant_id, academic_owner_scope_ref, lifecycle_state);

CREATE TABLE ec01.pathway_version (

tenant_id uuid NOT NULL,

pathway_version_id uuid NOT NULL DEFAULT gen_random_uuid(),

pathway_id uuid NOT NULL,

pathway_version_no integer NOT NULL,

previous_pathway_version_id uuid NULL,

official_name varchar(240) NOT NULL,

description_text text NULL,

stacking_policy_ref uuid NOT NULL,

state varchar(24) NOT NULL DEFAULT 'DRAFT',

workflow_ref uuid NULL,

content_hash varchar(128) NULL,

published_at timestamptz NULL,

published_by_subject uuid NULL,

superseded_by_pathway_version_id uuid NULL,

created_at timestamptz NOT NULL DEFAULT now(),

updated_at timestamptz NOT NULL DEFAULT now(),

version bigint NOT NULL DEFAULT 0,

CONSTRAINT pk_ec01_pathway_version PRIMARY KEY (tenant_id, pathway_version_id),

CONSTRAINT uq_ec01_pathway_version_no UNIQUE (tenant_id, pathway_id, pathway_version_no),

CONSTRAINT uq_ec01_pathway_version_scope UNIQUE (tenant_id, pathway_version_id, pathway_id),

CONSTRAINT fk_ec01_pathway_version_definition FOREIGN KEY (tenant_id, pathway_id) REFERENCES ec01.pathway_definition(tenant_id, pathway_id),

CONSTRAINT fk_ec01_pathway_previous_same_definition FOREIGN KEY (tenant_id, previous_pathway_version_id, pathway_id) REFERENCES ec01.pathway_version(tenant_id, pathway_version_id, pathway_id),

CONSTRAINT fk_ec01_pathway_superseded_same_definition FOREIGN KEY (tenant_id, superseded_by_pathway_version_id, pathway_id) REFERENCES ec01.pathway_version(tenant_id, pathway_version_id, pathway_id),

CONSTRAINT ck_ec01_pathway_version_no CHECK (pathway_version_no \> 0),

CONSTRAINT ck_ec01_pathway_version_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','PUBLISHED','SUPERSEDED','VOID')),

CONSTRAINT ck_ec01_pathway_version_publish_fields CHECK (state NOT IN ('PUBLISHED','SUPERSEDED') OR (content_hash IS NOT NULL AND published_at IS NOT NULL AND published_by_subject IS NOT NULL))

);

CREATE UNIQUE INDEX uq_ec01_pathway_single_published ON ec01.pathway_version(tenant_id, pathway_id) WHERE state='PUBLISHED';

CREATE TABLE ec01.pathway_node (

tenant_id uuid NOT NULL,

pathway_node_id uuid NOT NULL DEFAULT gen_random_uuid(),

pathway_version_id uuid NOT NULL,

node_code varchar(64) NOT NULL,

node_type varchar(40) NOT NULL,

credential_blueprint_id uuid NULL,

program_version_id uuid NULL,

external_credential_ref uuid NULL,

title_override varchar(200) NULL,

sequence_hint integer NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_pathway_node PRIMARY KEY (tenant_id, pathway_node_id),

CONSTRAINT uq_ec01_pathway_node_scope UNIQUE (tenant_id, pathway_version_id, pathway_node_id),

CONSTRAINT uq_ec01_pathway_node_code UNIQUE (tenant_id, pathway_version_id, node_code),

CONSTRAINT fk_ec01_pathway_node_version FOREIGN KEY (tenant_id, pathway_version_id) REFERENCES ec01.pathway_version(tenant_id, pathway_version_id) ON DELETE CASCADE,

CONSTRAINT fk_ec01_pathway_node_blueprint FOREIGN KEY (tenant_id, credential_blueprint_id) REFERENCES ec01.credential_blueprint(tenant_id, credential_blueprint_id),

CONSTRAINT fk_ec01_pathway_node_program_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id),

CONSTRAINT ck_ec01_pathway_node_typed_target CHECK (

(node_type='CREDENTIAL_BLUEPRINT' AND credential_blueprint_id IS NOT NULL AND program_version_id IS NULL AND external_credential_ref IS NULL) OR

(node_type='PROGRAM_VERSION' AND program_version_id IS NOT NULL AND credential_blueprint_id IS NULL AND external_credential_ref IS NULL) OR

(node_type='EXTERNAL_CREDENTIAL' AND external_credential_ref IS NOT NULL AND credential_blueprint_id IS NULL AND program_version_id IS NULL)

),

CONSTRAINT ck_ec01_pathway_node_sequence CHECK (sequence_hint IS NULL OR sequence_hint \> 0)

);

CREATE TABLE ec01.pathway_edge (

tenant_id uuid NOT NULL,

pathway_edge_id uuid NOT NULL DEFAULT gen_random_uuid(),

pathway_version_id uuid NOT NULL,

source_node_id uuid NOT NULL,

target_node_id uuid NOT NULL,

edge_type varchar(32) NOT NULL,

rule_policy_ref uuid NULL,

created_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_pathway_edge PRIMARY KEY (tenant_id, pathway_edge_id),

CONSTRAINT fk_ec01_pathway_edge_source_same_version FOREIGN KEY (tenant_id, pathway_version_id, source_node_id) REFERENCES ec01.pathway_node(tenant_id, pathway_version_id, pathway_node_id),

CONSTRAINT fk_ec01_pathway_edge_target_same_version FOREIGN KEY (tenant_id, pathway_version_id, target_node_id) REFERENCES ec01.pathway_node(tenant_id, pathway_version_id, pathway_node_id),

CONSTRAINT uq_ec01_pathway_edge UNIQUE (tenant_id, pathway_version_id, source_node_id, target_node_id, edge_type),

CONSTRAINT ck_ec01_pathway_edge_type CHECK (edge_type IN ('PRE_REQUISITE','SEQUENCE','ALTERNATIVE')),

CONSTRAINT ck_ec01_pathway_edge_no_self CHECK (source_node_id \<\> target_node_id)

);

CREATE TABLE ec01.design_change_request (

tenant_id uuid NOT NULL,

change_request_id uuid NOT NULL DEFAULT gen_random_uuid(),

subject_type varchar(40) NOT NULL,

program_version_id uuid NULL,

learning_module_version_id uuid NULL,

pathway_version_id uuid NULL,

change_class_code varchar(80) NOT NULL,

reason_code varchar(120) NOT NULL,

description_text text NOT NULL,

evidence_ref uuid NULL,

workflow_ref uuid NULL,

status varchar(32) NOT NULL DEFAULT 'DRAFT',

requested_by_subject uuid NOT NULL,

requested_at timestamptz NOT NULL DEFAULT now(),

applied_version_ref uuid NULL,

version bigint NOT NULL DEFAULT 0,

CONSTRAINT pk_ec01_design_change_request PRIMARY KEY (tenant_id, change_request_id),

CONSTRAINT fk_ec01_change_program_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id),

CONSTRAINT fk_ec01_change_module_version FOREIGN KEY (tenant_id, learning_module_version_id) REFERENCES ec01.learning_module_version(tenant_id, learning_module_version_id),

CONSTRAINT fk_ec01_change_pathway_version FOREIGN KEY (tenant_id, pathway_version_id) REFERENCES ec01.pathway_version(tenant_id, pathway_version_id),

CONSTRAINT ck_ec01_change_request_typed_subject CHECK (

(subject_type='PROGRAM_VERSION' AND program_version_id IS NOT NULL AND learning_module_version_id IS NULL AND pathway_version_id IS NULL) OR

(subject_type='MODULE_VERSION' AND learning_module_version_id IS NOT NULL AND program_version_id IS NULL AND pathway_version_id IS NULL) OR

(subject_type='PATHWAY_VERSION' AND pathway_version_id IS NOT NULL AND program_version_id IS NULL AND learning_module_version_id IS NULL)

),

CONSTRAINT ck_ec01_change_request_status CHECK (status IN ('DRAFT','SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','CANCELLED')),

CONSTRAINT ck_ec01_change_request_description CHECK (btrim(description_text) \<\> '')

);

CREATE INDEX ix_ec01_change_request_queue ON ec01.design_change_request(tenant_id, status, requested_at);

CREATE TABLE ec01.publication_receipt (

tenant_id uuid NOT NULL,

publication_receipt_id uuid NOT NULL DEFAULT gen_random_uuid(),

subject_type varchar(40) NOT NULL,

program_version_id uuid NULL,

learning_module_version_id uuid NULL,

pathway_version_id uuid NULL,

content_hash varchar(128) NOT NULL,

hash_algorithm varchar(24) NOT NULL DEFAULT 'SHA-256',

canonical_schema_version integer NOT NULL DEFAULT 1,

receipt_schema_version integer NOT NULL DEFAULT 1,

policy_snapshot_json jsonb NOT NULL DEFAULT '{}'::jsonb,

evidence_ref uuid NULL,

published_by_subject uuid NOT NULL,

assurance_level_code varchar(40) NULL,

correlation_id uuid NOT NULL,

published_at timestamptz NOT NULL DEFAULT now(),

CONSTRAINT pk_ec01_publication_receipt PRIMARY KEY (tenant_id, publication_receipt_id),

CONSTRAINT fk_ec01_receipt_program_version FOREIGN KEY (tenant_id, program_version_id) REFERENCES ec01.program_version(tenant_id, program_version_id),

CONSTRAINT fk_ec01_receipt_module_version FOREIGN KEY (tenant_id, learning_module_version_id) REFERENCES ec01.learning_module_version(tenant_id, learning_module_version_id),

CONSTRAINT fk_ec01_receipt_pathway_version FOREIGN KEY (tenant_id, pathway_version_id) REFERENCES ec01.pathway_version(tenant_id, pathway_version_id),

CONSTRAINT ck_ec01_publication_receipt_typed_subject CHECK (

(subject_type='PROGRAM_VERSION' AND program_version_id IS NOT NULL AND num_nonnulls(learning_module_version_id,pathway_version_id)=0) OR

(subject_type='MODULE_VERSION' AND learning_module_version_id IS NOT NULL AND num_nonnulls(program_version_id,pathway_version_id)=0) OR

(subject_type='PATHWAY_VERSION' AND pathway_version_id IS NOT NULL AND num_nonnulls(program_version_id,learning_module_version_id)=0)

),

CONSTRAINT ck_ec01_receipt_hash_algorithm CHECK (hash_algorithm IN ('SHA-256','SHA-384','SHA-512')),

CONSTRAINT ck_ec01_receipt_schema_versions CHECK (canonical_schema_version \> 0 AND receipt_schema_version \> 0)

);

CREATE UNIQUE INDEX uq_ec01_receipt_program_hash ON ec01.publication_receipt(tenant_id, program_version_id, content_hash) WHERE program_version_id IS NOT NULL;

CREATE UNIQUE INDEX uq_ec01_receipt_module_hash ON ec01.publication_receipt(tenant_id, learning_module_version_id, content_hash) WHERE learning_module_version_id IS NOT NULL;

CREATE UNIQUE INDEX uq_ec01_receipt_pathway_hash ON ec01.publication_receipt(tenant_id, pathway_version_id, content_hash) WHERE pathway_version_id IS NOT NULL;

CREATE INDEX ix_ec01_publication_receipt_time ON ec01.publication_receipt(tenant_id, published_at DESC);

CREATE TABLE ec01.command_idempotency (

tenant_id uuid NOT NULL,

operation_code varchar(80) NOT NULL,

idempotency_key varchar(160) NOT NULL,

request_hash varchar(128) NOT NULL,

status varchar(24) NOT NULL DEFAULT 'IN_PROGRESS',

lease_owner varchar(160) NULL,

lease_until timestamptz NULL,

attempt_count integer NOT NULL DEFAULT 1,

last_heartbeat_at timestamptz NULL,

resource_ref uuid NULL,

response_code integer NULL,

response_body_json jsonb NULL,

created_at timestamptz NOT NULL DEFAULT now(),

updated_at timestamptz NOT NULL DEFAULT now(),

completed_at timestamptz NULL,

expires_at timestamptz NULL,

CONSTRAINT pk_ec01_command_idempotency PRIMARY KEY (tenant_id, operation_code, idempotency_key),

CONSTRAINT ck_ec01_idempotency_status CHECK (status IN ('IN_PROGRESS','SUCCEEDED','FAILED_RETRYABLE','FAILED_FINAL')),

CONSTRAINT ck_ec01_idempotency_response_code CHECK (response_code IS NULL OR (response_code BETWEEN 100 AND 599)),

CONSTRAINT ck_ec01_idempotency_attempts CHECK (attempt_count \> 0),

CONSTRAINT ck_ec01_idempotency_lease CHECK ((status='IN_PROGRESS' AND lease_owner IS NOT NULL AND lease_until IS NOT NULL) OR status\<\>'IN_PROGRESS')

);

CREATE INDEX ix_ec01_idempotency_expiry ON ec01.command_idempotency(expires_at) WHERE expires_at IS NOT NULL;

CREATE INDEX ix_ec01_idempotency_recovery ON ec01.command_idempotency(status, lease_until) WHERE status='IN_PROGRESS';

CREATE TABLE ec01.outbox_event (

tenant_id uuid NOT NULL,

event_id uuid NOT NULL DEFAULT gen_random_uuid(),

aggregate_type varchar(80) NOT NULL,

aggregate_id uuid NOT NULL,

event_type varchar(120) NOT NULL,

schema_version integer NOT NULL DEFAULT 1,

correlation_id uuid NOT NULL,

causation_id uuid NULL,

occurred_at timestamptz NOT NULL DEFAULT now(),

payload_json jsonb NOT NULL,

delivery_status varchar(24) NOT NULL DEFAULT 'PENDING',

attempt_count integer NOT NULL DEFAULT 0,

next_attempt_at timestamptz NULL,

lease_owner varchar(160) NULL,

lease_until timestamptz NULL,

last_error_code varchar(120) NULL,

delivered_at timestamptz NULL,

CONSTRAINT pk_ec01_outbox_event PRIMARY KEY (tenant_id, event_id),

CONSTRAINT ck_ec01_outbox_schema CHECK (schema_version \> 0),

CONSTRAINT ck_ec01_outbox_status CHECK (delivery_status IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED','UNKNOWN_EFFECT')),

CONSTRAINT ck_ec01_outbox_attempts CHECK (attempt_count \>= 0),

CONSTRAINT ck_ec01_outbox_lease CHECK ((delivery_status='IN_FLIGHT' AND lease_owner IS NOT NULL AND lease_until IS NOT NULL) OR delivery_status\<\>'IN_FLIGHT')

);

CREATE INDEX ix_ec01_outbox_dispatch ON ec01.outbox_event(delivery_status, next_attempt_at, occurred_at) WHERE delivery_status IN ('PENDING','FAILED','UNKNOWN_EFFECT');

CREATE INDEX ix_ec01_outbox_reclaim ON ec01.outbox_event(delivery_status, lease_until) WHERE delivery_status='IN_FLIGHT';

CREATE TABLE ec01.inbox_message (

tenant_id uuid NOT NULL,

message_id uuid NOT NULL,

consumer_code varchar(120) NOT NULL,

message_type varchar(120) NOT NULL,

schema_version integer NOT NULL DEFAULT 1,

payload_hash varchar(128) NOT NULL,

processing_status varchar(24) NOT NULL DEFAULT 'RECEIVED',

received_at timestamptz NOT NULL DEFAULT now(),

processed_at timestamptz NULL,

result_ref uuid NULL,

CONSTRAINT pk_ec01_inbox_message PRIMARY KEY (tenant_id, consumer_code, message_id),

CONSTRAINT ck_ec01_inbox_schema CHECK (schema_version \> 0),

CONSTRAINT ck_ec01_inbox_status CHECK (processing_status IN ('RECEIVED','PROCESSED','FAILED'))

);

CREATE INDEX ix_ec01_inbox_received ON ec01.inbox_message(tenant_id, received_at DESC);

-- V1.1 hardening: state transitions, immutable snapshots, lineage, aggregate revision, graph safety, append-only evidence and RLS.

CREATE OR REPLACE FUNCTION ec01.assert_program_version_transition(old_state varchar, new_state varchar) RETURNS void LANGUAGE plpgsql AS \$\$

BEGIN

IF old_state = new_state THEN RETURN; END IF;

IF NOT (

(old_state='DRAFT' AND new_state IN ('IN_REVIEW','VOID')) OR

(old_state='IN_REVIEW' AND new_state IN ('DRAFT','APPROVED','VOID')) OR

(old_state='APPROVED' AND new_state IN ('DRAFT','SCHEDULED','PUBLISHED','VOID')) OR

(old_state='SCHEDULED' AND new_state IN ('PUBLISHED','VOID')) OR

(old_state='PUBLISHED' AND new_state IN ('SUPERSEDED','VOID'))

) THEN

RAISE EXCEPTION 'EC01_INVALID_PROGRAM_VERSION_TRANSITION:%-\>%', old_state, new_state;

END IF;

END \$\$;

CREATE OR REPLACE FUNCTION ec01.guard_program_version_state_immutability() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF TG_OP='DELETE' AND OLD.state \<\> 'DRAFT' THEN

RAISE EXCEPTION 'EC01_NON_DRAFT_VERSION_DELETE_FORBIDDEN';

END IF;

IF TG_OP='UPDATE' THEN

PERFORM ec01.assert_program_version_transition(OLD.state, NEW.state);

IF OLD.state \<\> 'DRAFT' AND (

NEW.program_id IS DISTINCT FROM OLD.program_id OR NEW.version_no IS DISTINCT FROM OLD.version_no OR

NEW.previous_version_id IS DISTINCT FROM OLD.previous_version_id OR NEW.official_name IS DISTINCT FROM OLD.official_name OR

NEW.short_name IS DISTINCT FROM OLD.short_name OR NEW.purpose_text IS DISTINCT FROM OLD.purpose_text OR

NEW.target_audience_text IS DISTINCT FROM OLD.target_audience_text OR NEW.academic_hours IS DISTINCT FROM OLD.academic_hours OR

NEW.credit_scheme_code IS DISTINCT FROM OLD.credit_scheme_code OR NEW.credits IS DISTINCT FROM OLD.credits OR

NEW.completion_model_code IS DISTINCT FROM OLD.completion_model_code OR NEW.attendance_policy_ref IS DISTINCT FROM OLD.attendance_policy_ref OR

NEW.assessment_policy_ref IS DISTINCT FROM OLD.assessment_policy_ref OR NEW.certification_policy_ref IS DISTINCT FROM OLD.certification_policy_ref OR

NEW.compliance_profile_ref IS DISTINCT FROM OLD.compliance_profile_ref OR NEW.valid_from IS DISTINCT FROM OLD.valid_from OR

(NEW.valid_to IS DISTINCT FROM OLD.valid_to AND NOT (OLD.state='PUBLISHED' AND NEW.state='SUPERSEDED')) OR

NEW.content_hash IS DISTINCT FROM OLD.content_hash

) THEN

RAISE EXCEPTION 'EC01_PROGRAM_VERSION_CONTENT_IMMUTABLE_OUTSIDE_DRAFT';

END IF;

IF NEW.state IN ('SCHEDULED','PUBLISHED','SUPERSEDED') AND

(NEW.content_hash IS NULL OR NEW.published_at IS NULL OR NEW.published_by_subject IS NULL OR NEW.valid_from IS NULL) THEN

RAISE EXCEPTION 'EC01_PUBLICATION_FIELDS_REQUIRED';

END IF;

END IF;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

CREATE TRIGGER trg_ec01_program_version_state_immutability BEFORE UPDATE OR DELETE ON ec01.program_version FOR EACH ROW EXECUTE FUNCTION ec01.guard_program_version_state_immutability();

CREATE OR REPLACE FUNCTION ec01.guard_program_version_lineage() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE prev_no integer; next_no integer;

BEGIN

IF NEW.previous_version_id IS NOT NULL THEN

IF NEW.previous_version_id = NEW.program_version_id THEN RAISE EXCEPTION 'EC01_PROGRAM_LINEAGE_SELF_PREVIOUS'; END IF;

SELECT version_no INTO prev_no FROM ec01.program_version WHERE tenant_id=NEW.tenant_id AND program_version_id=NEW.previous_version_id;

IF prev_no IS NULL OR prev_no \>= NEW.version_no THEN RAISE EXCEPTION 'EC01_PROGRAM_LINEAGE_PREVIOUS_ORDER'; END IF;

END IF;

IF NEW.superseded_by_version_id IS NOT NULL THEN

IF NEW.superseded_by_version_id = NEW.program_version_id THEN RAISE EXCEPTION 'EC01_PROGRAM_LINEAGE_SELF_SUPERSEDE'; END IF;

SELECT version_no INTO next_no FROM ec01.program_version WHERE tenant_id=NEW.tenant_id AND program_version_id=NEW.superseded_by_version_id;

IF next_no IS NULL OR next_no \<= NEW.version_no THEN RAISE EXCEPTION 'EC01_PROGRAM_LINEAGE_SUPERSEDE_ORDER'; END IF;

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_program_version_lineage BEFORE INSERT OR UPDATE OF previous_version_id,superseded_by_version_id,version_no ON ec01.program_version FOR EACH ROW EXECUTE FUNCTION ec01.guard_program_version_lineage();

CREATE OR REPLACE FUNCTION ec01.guard_program_child_mutability() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE v_tenant uuid; v_version uuid; v_state varchar(24);

BEGIN

IF TG_OP='DELETE' THEN v_tenant:=OLD.tenant_id; v_version:=OLD.program_version_id; ELSE v_tenant:=NEW.tenant_id; v_version:=NEW.program_version_id; END IF;

IF TG_OP='UPDATE' AND NEW.program_version_id IS DISTINCT FROM OLD.program_version_id THEN RAISE EXCEPTION 'EC01_CHILD_REPARENT_FORBIDDEN'; END IF;

SELECT state INTO v_state FROM ec01.program_version WHERE tenant_id=v_tenant AND program_version_id=v_version FOR UPDATE;

IF v_state \<\> 'DRAFT' THEN RAISE EXCEPTION 'EC01_PROGRAM_VERSION_CHILD_IMMUTABLE_OUTSIDE_DRAFT'; END IF;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

CREATE OR REPLACE FUNCTION ec01.bump_program_aggregate_revision() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE v_tenant uuid; v_version uuid;

BEGIN

IF TG_OP='DELETE' THEN v_tenant:=OLD.tenant_id; v_version:=OLD.program_version_id; ELSE v_tenant:=NEW.tenant_id; v_version:=NEW.program_version_id; END IF;

UPDATE ec01.program_version SET version=version+1, updated_at=now() WHERE tenant_id=v_tenant AND program_version_id=v_version;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

DO \$\$ DECLARE t text; BEGIN

FOREACH t IN ARRAY ARRAY\['program_delivery_mode_binding','program_outcome','program_competency_binding','program_structure_group','program_structure_item','structure_dependency','program_requirement_binding','credential_blueprint','credential_blueprint_requirement'\] LOOP

EXECUTE format('CREATE TRIGGER trg_ec01\_%I_mutability BEFORE INSERT OR UPDATE OR DELETE ON ec01.%I FOR EACH ROW EXECUTE FUNCTION ec01.guard_program_child_mutability()', t, t);

EXECUTE format('CREATE TRIGGER trg_ec01\_%I_revision AFTER INSERT OR UPDATE OR DELETE ON ec01.%I FOR EACH ROW EXECUTE FUNCTION ec01.bump_program_aggregate_revision()', t, t);

END LOOP;

END \$\$;

CREATE OR REPLACE FUNCTION ec01.guard_module_version_state_immutability() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF TG_OP='DELETE' AND OLD.state \<\> 'DRAFT' THEN RAISE EXCEPTION 'EC01_NON_DRAFT_MODULE_DELETE_FORBIDDEN'; END IF;

IF TG_OP='UPDATE' THEN

IF OLD.state \<\> NEW.state AND NOT (

(OLD.state='DRAFT' AND NEW.state IN ('IN_REVIEW','VOID')) OR

(OLD.state='IN_REVIEW' AND NEW.state IN ('DRAFT','APPROVED','VOID')) OR

(OLD.state='APPROVED' AND NEW.state IN ('DRAFT','PUBLISHED','VOID')) OR

(OLD.state='PUBLISHED' AND NEW.state IN ('SUPERSEDED','VOID'))

) THEN RAISE EXCEPTION 'EC01_INVALID_MODULE_VERSION_TRANSITION'; END IF;

IF OLD.state \<\> 'DRAFT' AND (

NEW.learning_module_id IS DISTINCT FROM OLD.learning_module_id OR NEW.module_version_no IS DISTINCT FROM OLD.module_version_no OR

NEW.previous_module_version_id IS DISTINCT FROM OLD.previous_module_version_id OR NEW.official_title IS DISTINCT FROM OLD.official_title OR

NEW.description_text IS DISTINCT FROM OLD.description_text OR NEW.module_hours IS DISTINCT FROM OLD.module_hours OR

NEW.credit_scheme_code IS DISTINCT FROM OLD.credit_scheme_code OR NEW.module_credits IS DISTINCT FROM OLD.module_credits OR

NEW.assessment_required IS DISTINCT FROM OLD.assessment_required OR NEW.assessment_policy_ref IS DISTINCT FROM OLD.assessment_policy_ref OR

NEW.content_hash IS DISTINCT FROM OLD.content_hash

) THEN RAISE EXCEPTION 'EC01_MODULE_CONTENT_IMMUTABLE_OUTSIDE_DRAFT'; END IF;

END IF;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

CREATE TRIGGER trg_ec01_module_version_state_immutability BEFORE UPDATE OR DELETE ON ec01.learning_module_version FOR EACH ROW EXECUTE FUNCTION ec01.guard_module_version_state_immutability();

CREATE OR REPLACE FUNCTION ec01.guard_module_version_lineage() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE prev_no integer; next_no integer;

BEGIN

IF NEW.previous_module_version_id IS NOT NULL THEN

IF NEW.previous_module_version_id = NEW.learning_module_version_id THEN RAISE EXCEPTION 'EC01_MODULE_LINEAGE_SELF_PREVIOUS'; END IF;

SELECT module_version_no INTO prev_no FROM ec01.learning_module_version WHERE tenant_id=NEW.tenant_id AND learning_module_version_id=NEW.previous_module_version_id;

IF prev_no IS NULL OR prev_no \>= NEW.module_version_no THEN RAISE EXCEPTION 'EC01_MODULE_LINEAGE_PREVIOUS_ORDER'; END IF;

END IF;

IF NEW.superseded_by_module_version_id IS NOT NULL THEN

IF NEW.superseded_by_module_version_id = NEW.learning_module_version_id THEN RAISE EXCEPTION 'EC01_MODULE_LINEAGE_SELF_SUPERSEDE'; END IF;

SELECT module_version_no INTO next_no FROM ec01.learning_module_version WHERE tenant_id=NEW.tenant_id AND learning_module_version_id=NEW.superseded_by_module_version_id;

IF next_no IS NULL OR next_no \<= NEW.module_version_no THEN RAISE EXCEPTION 'EC01_MODULE_LINEAGE_SUPERSEDE_ORDER'; END IF;

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_module_version_lineage BEFORE INSERT OR UPDATE OF previous_module_version_id,superseded_by_module_version_id,module_version_no ON ec01.learning_module_version FOR EACH ROW EXECUTE FUNCTION ec01.guard_module_version_lineage();

CREATE OR REPLACE FUNCTION ec01.guard_module_child_mutability() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE v_state varchar(24); v_tenant uuid; v_version uuid;

BEGIN

IF TG_OP='DELETE' THEN v_tenant:=OLD.tenant_id; v_version:=OLD.learning_module_version_id; ELSE v_tenant:=NEW.tenant_id; v_version:=NEW.learning_module_version_id; END IF;

IF TG_OP='UPDATE' AND NEW.learning_module_version_id IS DISTINCT FROM OLD.learning_module_version_id THEN RAISE EXCEPTION 'EC01_MODULE_CHILD_REPARENT_FORBIDDEN'; END IF;

SELECT state INTO v_state FROM ec01.learning_module_version WHERE tenant_id=v_tenant AND learning_module_version_id=v_version FOR UPDATE;

IF v_state \<\> 'DRAFT' THEN RAISE EXCEPTION 'EC01_MODULE_VERSION_CHILD_IMMUTABLE_OUTSIDE_DRAFT'; END IF;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

CREATE TRIGGER trg_ec01_module_outcome_mutability BEFORE INSERT OR UPDATE OR DELETE ON ec01.learning_module_outcome FOR EACH ROW EXECUTE FUNCTION ec01.guard_module_child_mutability();

CREATE OR REPLACE FUNCTION ec01.bump_module_aggregate_revision() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE v_tenant uuid; v_version uuid;

BEGIN

IF TG_OP='DELETE' THEN v_tenant:=OLD.tenant_id; v_version:=OLD.learning_module_version_id; ELSE v_tenant:=NEW.tenant_id; v_version:=NEW.learning_module_version_id; END IF;

UPDATE ec01.learning_module_version SET version=version+1, updated_at=now() WHERE tenant_id=v_tenant AND learning_module_version_id=v_version;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

CREATE TRIGGER trg_ec01_module_outcome_revision AFTER INSERT OR UPDATE OR DELETE ON ec01.learning_module_outcome FOR EACH ROW EXECUTE FUNCTION ec01.bump_module_aggregate_revision();

CREATE OR REPLACE FUNCTION ec01.guard_pathway_version_state_immutability() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF TG_OP='DELETE' AND OLD.state \<\> 'DRAFT' THEN RAISE EXCEPTION 'EC01_NON_DRAFT_PATHWAY_DELETE_FORBIDDEN'; END IF;

IF TG_OP='UPDATE' THEN

IF OLD.state \<\> NEW.state AND NOT (

(OLD.state='DRAFT' AND NEW.state IN ('IN_REVIEW','VOID')) OR

(OLD.state='IN_REVIEW' AND NEW.state IN ('DRAFT','APPROVED','VOID')) OR

(OLD.state='APPROVED' AND NEW.state IN ('DRAFT','PUBLISHED','VOID')) OR

(OLD.state='PUBLISHED' AND NEW.state IN ('SUPERSEDED','VOID'))

) THEN RAISE EXCEPTION 'EC01_INVALID_PATHWAY_VERSION_TRANSITION'; END IF;

IF OLD.state \<\> 'DRAFT' AND (

NEW.pathway_id IS DISTINCT FROM OLD.pathway_id OR NEW.pathway_version_no IS DISTINCT FROM OLD.pathway_version_no OR

NEW.previous_pathway_version_id IS DISTINCT FROM OLD.previous_pathway_version_id OR NEW.official_name IS DISTINCT FROM OLD.official_name OR

NEW.description_text IS DISTINCT FROM OLD.description_text OR NEW.stacking_policy_ref IS DISTINCT FROM OLD.stacking_policy_ref OR

NEW.content_hash IS DISTINCT FROM OLD.content_hash

) THEN RAISE EXCEPTION 'EC01_PATHWAY_CONTENT_IMMUTABLE_OUTSIDE_DRAFT'; END IF;

END IF;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

CREATE TRIGGER trg_ec01_pathway_version_state_immutability BEFORE UPDATE OR DELETE ON ec01.pathway_version FOR EACH ROW EXECUTE FUNCTION ec01.guard_pathway_version_state_immutability();

CREATE OR REPLACE FUNCTION ec01.guard_pathway_version_lineage() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE prev_no integer; next_no integer;

BEGIN

IF NEW.previous_pathway_version_id IS NOT NULL THEN

IF NEW.previous_pathway_version_id = NEW.pathway_version_id THEN RAISE EXCEPTION 'EC01_PATHWAY_LINEAGE_SELF_PREVIOUS'; END IF;

SELECT pathway_version_no INTO prev_no FROM ec01.pathway_version WHERE tenant_id=NEW.tenant_id AND pathway_version_id=NEW.previous_pathway_version_id;

IF prev_no IS NULL OR prev_no \>= NEW.pathway_version_no THEN RAISE EXCEPTION 'EC01_PATHWAY_LINEAGE_PREVIOUS_ORDER'; END IF;

END IF;

IF NEW.superseded_by_pathway_version_id IS NOT NULL THEN

IF NEW.superseded_by_pathway_version_id = NEW.pathway_version_id THEN RAISE EXCEPTION 'EC01_PATHWAY_LINEAGE_SELF_SUPERSEDE'; END IF;

SELECT pathway_version_no INTO next_no FROM ec01.pathway_version WHERE tenant_id=NEW.tenant_id AND pathway_version_id=NEW.superseded_by_pathway_version_id;

IF next_no IS NULL OR next_no \<= NEW.pathway_version_no THEN RAISE EXCEPTION 'EC01_PATHWAY_LINEAGE_SUPERSEDE_ORDER'; END IF;

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_pathway_version_lineage BEFORE INSERT OR UPDATE OF previous_pathway_version_id,superseded_by_pathway_version_id,pathway_version_no ON ec01.pathway_version FOR EACH ROW EXECUTE FUNCTION ec01.guard_pathway_version_lineage();

CREATE OR REPLACE FUNCTION ec01.guard_pathway_child_mutability() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE v_state varchar(24); v_tenant uuid; v_version uuid;

BEGIN

IF TG_OP='DELETE' THEN v_tenant:=OLD.tenant_id; v_version:=OLD.pathway_version_id; ELSE v_tenant:=NEW.tenant_id; v_version:=NEW.pathway_version_id; END IF;

IF TG_OP='UPDATE' AND NEW.pathway_version_id IS DISTINCT FROM OLD.pathway_version_id THEN RAISE EXCEPTION 'EC01_PATHWAY_CHILD_REPARENT_FORBIDDEN'; END IF;

SELECT state INTO v_state FROM ec01.pathway_version WHERE tenant_id=v_tenant AND pathway_version_id=v_version FOR UPDATE;

IF v_state \<\> 'DRAFT' THEN RAISE EXCEPTION 'EC01_PATHWAY_VERSION_CHILD_IMMUTABLE_OUTSIDE_DRAFT'; END IF;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

CREATE TRIGGER trg_ec01_pathway_node_mutability BEFORE INSERT OR UPDATE OR DELETE ON ec01.pathway_node FOR EACH ROW EXECUTE FUNCTION ec01.guard_pathway_child_mutability();

CREATE TRIGGER trg_ec01_pathway_edge_mutability BEFORE INSERT OR UPDATE OR DELETE ON ec01.pathway_edge FOR EACH ROW EXECUTE FUNCTION ec01.guard_pathway_child_mutability();

CREATE OR REPLACE FUNCTION ec01.bump_pathway_aggregate_revision() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE v_tenant uuid; v_version uuid;

BEGIN

IF TG_OP='DELETE' THEN v_tenant:=OLD.tenant_id; v_version:=OLD.pathway_version_id; ELSE v_tenant:=NEW.tenant_id; v_version:=NEW.pathway_version_id; END IF;

UPDATE ec01.pathway_version SET version=version+1, updated_at=now() WHERE tenant_id=v_tenant AND pathway_version_id=v_version;

IF TG_OP='DELETE' THEN RETURN OLD; ELSE RETURN NEW; END IF;

END \$\$;

CREATE TRIGGER trg_ec01_pathway_node_revision AFTER INSERT OR UPDATE OR DELETE ON ec01.pathway_node FOR EACH ROW EXECUTE FUNCTION ec01.bump_pathway_aggregate_revision();

CREATE TRIGGER trg_ec01_pathway_edge_revision AFTER INSERT OR UPDATE OR DELETE ON ec01.pathway_edge FOR EACH ROW EXECUTE FUNCTION ec01.bump_pathway_aggregate_revision();

-- Business keys become immutable after published history exists.

CREATE OR REPLACE FUNCTION ec01.guard_program_business_key() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF NEW.program_code IS DISTINCT FROM OLD.program_code AND EXISTS (SELECT 1 FROM ec01.program_version v WHERE v.tenant_id=OLD.tenant_id AND v.program_id=OLD.program_id AND v.state IN ('SCHEDULED','PUBLISHED','SUPERSEDED')) THEN

RAISE EXCEPTION 'EC01_PROGRAM_CODE_IMMUTABLE_WITH_PUBLISHED_HISTORY';

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_program_business_key BEFORE UPDATE OF program_code ON ec01.program_definition FOR EACH ROW EXECUTE FUNCTION ec01.guard_program_business_key();

CREATE OR REPLACE FUNCTION ec01.guard_module_business_key() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF NEW.module_code IS DISTINCT FROM OLD.module_code AND EXISTS (SELECT 1 FROM ec01.learning_module_version v WHERE v.tenant_id=OLD.tenant_id AND v.learning_module_id=OLD.learning_module_id AND v.state IN ('PUBLISHED','SUPERSEDED')) THEN

RAISE EXCEPTION 'EC01_MODULE_CODE_IMMUTABLE_WITH_PUBLISHED_HISTORY';

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_module_business_key BEFORE UPDATE OF module_code ON ec01.learning_module_definition FOR EACH ROW EXECUTE FUNCTION ec01.guard_module_business_key();

CREATE OR REPLACE FUNCTION ec01.guard_pathway_business_key() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

IF NEW.pathway_code IS DISTINCT FROM OLD.pathway_code AND EXISTS (SELECT 1 FROM ec01.pathway_version v WHERE v.tenant_id=OLD.tenant_id AND v.pathway_id=OLD.pathway_id AND v.state IN ('PUBLISHED','SUPERSEDED')) THEN

RAISE EXCEPTION 'EC01_PATHWAY_CODE_IMMUTABLE_WITH_PUBLISHED_HISTORY';

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_pathway_business_key BEFORE UPDATE OF pathway_code ON ec01.pathway_definition FOR EACH ROW EXECUTE FUNCTION ec01.guard_pathway_business_key();

-- Group hierarchy must remain acyclic.

CREATE OR REPLACE FUNCTION ec01.guard_structure_group_cycle() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE has_cycle boolean;

BEGIN

IF NEW.parent_group_id IS NULL THEN RETURN NEW; END IF;

WITH RECURSIVE ancestors(group_id) AS (

SELECT NEW.parent_group_id

UNION ALL

SELECT g.parent_group_id FROM ec01.program_structure_group g JOIN ancestors a ON g.structure_group_id=a.group_id

WHERE g.tenant_id=NEW.tenant_id AND g.program_version_id=NEW.program_version_id AND g.parent_group_id IS NOT NULL

) SELECT EXISTS(SELECT 1 FROM ancestors WHERE group_id=NEW.structure_group_id) INTO has_cycle;

IF has_cycle THEN RAISE EXCEPTION 'EC01_STRUCTURE_GROUP_CYCLE'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_structure_group_no_cycle BEFORE INSERT OR UPDATE OF parent_group_id ON ec01.program_structure_group FOR EACH ROW EXECUTE FUNCTION ec01.guard_structure_group_cycle();

-- Cycle prevention for program dependencies. On UPDATE, the old edge is excluded from the graph traversal.

CREATE OR REPLACE FUNCTION ec01.guard_structure_dependency_cycle() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE has_cycle boolean; v_old_edge uuid;

BEGIN

v_old_edge := CASE WHEN TG_OP='UPDATE' THEN OLD.structure_dependency_id ELSE NULL END;

IF NEW.dependency_type NOT IN ('PRE_REQUISITE','SEQUENCE') THEN RETURN NEW; END IF;

WITH RECURSIVE reach(node_id) AS (

SELECT NEW.to_structure_item_id

UNION

SELECT d.to_structure_item_id FROM ec01.structure_dependency d JOIN reach r ON d.from_structure_item_id=r.node_id

WHERE d.tenant_id=NEW.tenant_id AND d.program_version_id=NEW.program_version_id AND d.dependency_type IN ('PRE_REQUISITE','SEQUENCE')

AND (v_old_edge IS NULL OR d.structure_dependency_id \<\> v_old_edge)

) SELECT EXISTS(SELECT 1 FROM reach WHERE node_id=NEW.from_structure_item_id) INTO has_cycle;

IF has_cycle THEN RAISE EXCEPTION 'EC01_STRUCTURE_DEPENDENCY_CYCLE'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_structure_dependency_no_cycle BEFORE INSERT OR UPDATE ON ec01.structure_dependency FOR EACH ROW EXECUTE FUNCTION ec01.guard_structure_dependency_cycle();

-- Cycle prevention for pathway edges. On UPDATE, the old edge is excluded.

CREATE OR REPLACE FUNCTION ec01.guard_pathway_edge_cycle() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE has_cycle boolean; v_old_edge uuid;

BEGIN

v_old_edge := CASE WHEN TG_OP='UPDATE' THEN OLD.pathway_edge_id ELSE NULL END;

IF NEW.edge_type NOT IN ('PRE_REQUISITE','SEQUENCE') THEN RETURN NEW; END IF;

WITH RECURSIVE reach(node_id) AS (

SELECT NEW.target_node_id

UNION

SELECT e.target_node_id FROM ec01.pathway_edge e JOIN reach r ON e.source_node_id=r.node_id

WHERE e.tenant_id=NEW.tenant_id AND e.pathway_version_id=NEW.pathway_version_id AND e.edge_type IN ('PRE_REQUISITE','SEQUENCE')

AND (v_old_edge IS NULL OR e.pathway_edge_id \<\> v_old_edge)

) SELECT EXISTS(SELECT 1 FROM reach WHERE node_id=NEW.source_node_id) INTO has_cycle;

IF has_cycle THEN RAISE EXCEPTION 'EC01_PATHWAY_CYCLE'; END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec01_pathway_edge_no_cycle BEFORE INSERT OR UPDATE ON ec01.pathway_edge FOR EACH ROW EXECUTE FUNCTION ec01.guard_pathway_edge_cycle();

-- Publication receipt is append-only evidence.

CREATE OR REPLACE FUNCTION ec01.guard_publication_receipt_append_only() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

RAISE EXCEPTION 'EC01_PUBLICATION_RECEIPT_APPEND_ONLY';

END \$\$;

CREATE TRIGGER trg_ec01_publication_receipt_append_only BEFORE UPDATE OR DELETE ON ec01.publication_receipt FOR EACH ROW EXECUTE FUNCTION ec01.guard_publication_receipt_append_only();

-- Row Level Security: composite keys protect integrity; RLS protects reads/writes even when a repository forgets tenant filters.

CREATE OR REPLACE FUNCTION ec01.current_tenant_id() RETURNS uuid LANGUAGE sql STABLE AS \$\$

SELECT NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid

\$\$;

DO \$\$

DECLARE t text;

BEGIN

FOREACH t IN ARRAY ARRAY\[

'program_definition','program_version','program_delivery_mode_binding','program_outcome','program_competency_binding',

'learning_module_definition','learning_module_version','learning_module_outcome','program_structure_group','program_structure_item',

'structure_dependency','program_requirement_binding','credential_blueprint','credential_blueprint_requirement','pathway_definition',

'pathway_version','pathway_node','pathway_edge','design_change_request','publication_receipt','command_idempotency','outbox_event','inbox_message'

\] LOOP

EXECUTE format('ALTER TABLE ec01.%I ENABLE ROW LEVEL SECURITY', t);

EXECUTE format('ALTER TABLE ec01.%I FORCE ROW LEVEL SECURITY', t);

EXECUTE format('CREATE POLICY p_ec01\_%I_tenant ON ec01.%I USING (tenant_id = ec01.current_tenant_id()) WITH CHECK (tenant_id = ec01.current_tenant_id())', t, t);

END LOOP;

END \$\$;

-- Runtime contract: the normal application role MUST NOT own EC-01 tables and MUST NOT have BYPASSRLS.

-- Migration owner and technical workers use distinct credentials. Cross-tenant workers must use narrowly scoped SECURITY DEFINER functions or a separately approved worker role; never the general HTTP runtime role.

-- Outbox claiming contract (worker role only): FOR UPDATE SKIP LOCKED + lease. The SECURITY DEFINER owner must be a dedicated technical DB role approved to bypass tenant RLS only for this function; EXECUTE is revoked from PUBLIC and granted solely to the outbox worker role. The HTTP runtime role never receives BYPASSRLS.

CREATE OR REPLACE FUNCTION ec01.claim_outbox(p_worker varchar, p_batch integer, p_lease_seconds integer DEFAULT 60)

RETURNS SETOF ec01.outbox_event LANGUAGE plpgsql SECURITY DEFINER AS \$\$

BEGIN

IF p_batch \< 1 OR p_batch \> 500 THEN RAISE EXCEPTION 'EC01_OUTBOX_BATCH_LIMIT'; END IF;

RETURN QUERY

WITH candidates AS (

SELECT tenant_id,event_id FROM ec01.outbox_event

WHERE delivery_status IN ('PENDING','FAILED','UNKNOWN_EFFECT')

AND (next_attempt_at IS NULL OR next_attempt_at \<= now())

ORDER BY occurred_at

FOR UPDATE SKIP LOCKED

LIMIT p_batch

)

UPDATE ec01.outbox_event o

SET delivery_status='IN_FLIGHT', lease_owner=p_worker,

lease_until=now()+make_interval(secs=\>p_lease_seconds), attempt_count=attempt_count+1

FROM candidates c

WHERE o.tenant_id=c.tenant_id AND o.event_id=c.event_id

RETURNING o.\*;

END \$\$;

-- RLS-negative tests are mandatory: query without peopleu.tenant_id =\> zero rows; wrong tenant =\> zero rows/denied writes; correct tenant =\> scoped rows only.

REVOKE ALL ON FUNCTION ec01.claim_outbox(varchar, integer, integer) FROM PUBLIC;

-- GRANT EXECUTE ON FUNCTION ec01.claim_outbox(varchar, integer, integer) TO \<approved_outbox_worker_role\>; -- security migration environment-specific

# 14. MongoDB y Redis

## 14.1 MongoDB — solo read models/derivados cuando exista valor

PostgreSQL es Source of Truth transaccional de EC-01. MongoDB no debe replicar aggregates para escribir por dos caminos. Su uso permitido es materializar vistas de lectura o snapshots de comparación que puedan reconstruirse desde eventos/queries, por ejemplo PortfolioSearchView, ProgramVersionDiffView o PublicationPackProjection. Cualquier documento Mongo debe incluir tenant_id, source_version/content_hash, projection_version y generated_at.

| **Read model**             | **Propósito**                                | **Reconstruible desde**               | **Regla**                             |
|----------------------------|----------------------------------------------|---------------------------------------|---------------------------------------|
| PortfolioSearchView        | Búsqueda facetada de programas/módulos/rutas | PostgreSQL + CT-08 overlays           | Nunca authoritative; stale explícito. |
| ProgramVersionDiffView     | Diff precomputado entre hashes               | ProgramVersion snapshots              | Invalidar por content hash.           |
| PublicationPackProjection  | Vista agregada para auditoría/export         | Receipt + local facts + external refs | No sustituye Evidence Pack CT-05.     |
| DependencyImpactProjection | Relaciones downstream conocidas              | Eventos EC-01/02/08/10                | PARTIAL si consumer no reporta.       |

## 14.2 Redis — acelerador no autoritativo

Redis puede cachear catálogos resueltos, validation reports por content_hash, query results y locks técnicos de corta duración cuando la implementación los necesite. La caída o flush de Redis nunca debe perder una ProgramVersion, publicación, idempotency key ni receipt. La idempotencia durable vive en PostgreSQL.

| **Key pattern**                        | **TTL orientativo**     | **Contenido**             | **Fail behavior**                                      |
|----------------------------------------|-------------------------|---------------------------|--------------------------------------------------------|
| ec01:policy:{tenant}:{policyRef}       | 5–30 min según contrato | Policy resolution/version | Fallback a CT-02; publish fail-closed si no resoluble. |
| ec01:validation:{tenant}:{contentHash} | 15–60 min               | ValidationReport derivado | Recalcular.                                            |
| ec01:portfolio-search:{tenant}:{hash}  | 1–10 min                | Query result              | Reconsultar PostgreSQL.                                |
| ec01:lock:publish:{tenant}:{programId} | segundos                | Lock técnico opcional     | DB unique/transaction sigue siendo última defensa.     |

# 15. Backend Java 21 / Spring Boot / Spring Modulith

EC-01 se implementa como módulo Spring Modulith con frontera pública explícita. El dominio no depende de JPA, HTTP, Redis, CT clients ni brokers. Application services orquestan transactions, ports y policies; adapters resuelven persistencia/integraciones. Los eventos de dominio se transforman en integration events mediante outbox sin publicar directamente desde entities.

## 15.1 Estructura recomendada

com.peopleu.ec.portfolio

├── domain

│ ├── program

│ │ ├── ProgramDefinition.java

│ │ ├── ProgramVersion.java

│ │ ├── ProgramPublicationPolicy.java

│ │ └── ProgramVersionRepository.java

│ ├── module

│ │ ├── LearningModuleDefinition.java

│ │ └── LearningModuleRepository.java

│ ├── pathway

│ │ ├── PathwayDefinition.java

│ │ └── PathwayGraphService.java

│ ├── credential

│ │ └── CredentialBlueprint.java

│ └── shared

│ ├── TenantId.java

│ ├── ContentHash.java

│ └── DomainReasonCode.java

├── application

│ ├── command

│ ├── query

│ ├── service

│ └── port

│ ├── Ct01ScopePort.java

│ ├── Ct02PolicyPort.java

│ ├── Ct06WorkflowPort.java

│ ├── Ct12AiAssistPort.java

│ └── Ct15EligibilityPort.java

├── infrastructure

│ ├── persistence/jpa

│ ├── integration

│ ├── outbox

│ ├── inbox

│ └── cache

└── api

├── rest

├── dto

└── problem

## 15.2 Reglas de implementación del aggregate

- No exponer setters genéricos en aggregate roots; usar métodos de intención: renameDraft, addOutcome, submitForReview, approve, publish, supersede.

- ProgramVersion debe conocer su estado e impedir cambios cuando no es editable; la DB repite la defensa mediante triggers.

- @Version se mapea en roots mutables; el ETag HTTP deriva de version, no de updated_at.

- Factories reciben TenantId desde TenantContext, jamás desde DTO del cliente.

- Policy refs se resuelven en application/domain policy layer; no usar if/else institucionales dentro de controllers.

- El content hash se calcula sobre un canonical snapshot ordenado estable; debe existir test de determinismo.

- Publish usa una única transacción local para aggregate state + prior supersede + receipt + idempotency + outbox.

- Las llamadas remotas de validación deben ejecutarse antes o mediante patrón cuidadosamente diseñado para no mantener locks DB durante timeouts externos. Revalidar invariantes locales dentro de la transacción de commit.

## 15.3 Puertos obligatorios

| **Port**                  | **Operaciones mínimas**                         | **Timeout/fallback**                                            |
|---------------------------|-------------------------------------------------|-----------------------------------------------------------------|
| InstitutionScopePort      | resolveScope, assertAuthorized                  | Corto; fail-closed en command crítico.                          |
| PolicyResolutionPort      | resolvePolicyVersion, snapshotPolicies          | Corto + cache; publish no usa fallback desconocido.             |
| WorkflowPort              | startReview, getDecision, reconcile             | Timeout + UNKNOWN_EFFECT si remote create puede haber ocurrido. |
| EvidencePort              | attachEvidenceRef, verifyRef                    | No blob; 503 si evidencia requerida no verificable.             |
| AuditPort                 | recordCriticalAction                            | Buffer/contract según CT-10; fallar según criticidad definida.  |
| AiAssistPort              | suggestOutcomes, summarizeDiff, mapCompetencies | Degradación a edición manual.                                   |
| EligibilityDefinitionPort | validateRuleRef                                 | Publish fail-closed si requirement obligatorio no resoluble.    |
| IntegrationEventPort      | outbox only                                     | No remote publish dentro de transaction.                        |

## 15.4 TenantContext + RLS transaction contract

Cada transacción HTTP/command establece el tenant autorizado como contexto de base de datos antes de ejecutar queries: SET LOCAL peopleu.tenant_id = :tenantId. La conexión no debe conservar el valor fuera de la transacción. Tests de integración deben probar missing tenant, wrong tenant y pool reuse. El runtime HTTP usa un rol sin ownership ni BYPASSRLS; migraciones y workers poseen credenciales diferentes.

## 15.5 Concurrencia de hijos y repository boundary

Repositories de hijos no se exponen a Application como API pública. El command handler carga/lockea el Aggregate Root, valida expectedRevision y persiste mediante el aggregate/application service. Los adapters JPA pueden usar tablas hijas, pero no deben permitir mutaciones que salten el root. El ETag de un endpoint hijo siempre deriva de la revisión del aggregate propietario.

## 15.6 Durable idempotency y recovery

Al adquirir Idempotency-Key se crea/lockea la fila con lease_owner y lease_until. Si existe SUCCEEDED se replaya exactamente la respuesta estable; si IN_PROGRESS con lease vigente se devuelve 409/202 según operación; si el lease expiró, un único proceso puede reclaim bajo lock y aumentar attempt_count. request_hash distinto para la misma key produce 409 IDEMPOTENCY_KEY_REUSED_WITH_DIFFERENT_REQUEST.

## 15.7 Outbox dispatcher multi-instancia

El relay usa claim por batch con FOR UPDATE SKIP LOCKED, marca IN_FLIGHT+lease, publica y luego confirma DELIVERED. Un timeout con efecto remoto incierto entra a UNKNOWN_EFFECT y se reconcilia antes de retry. Lease vencido permite reclaim. Poison events superando el máximo parametrizado pasan a FAILED con alerta/runbook; nunca se eliminan silenciosamente.

Nota de revisión: AggregateRoot.version es un token monotónico, no necesariamente gap-free. Una mutación que afecta múltiples filas hijas puede incrementarlo más de una vez por los triggers físicos; el contrato solo exige que cualquier cambio produzca un ETag distinto y que If-Match stale sea rechazado. Si el equipo decide exigir incremento exactamente +1 por comando, debe reemplazar el trigger row-level por un mecanismo transaction/statement-level equivalente y demostrar la misma defensa.

# 16. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

La API se versiona bajo /api/v1/ec/portfolio. tenant_id no aparece como parámetro editable si el gateway/security context ya lo resuelve. Las operaciones de lectura pueden aceptar scope filters autorizados. Todo PATCH/command mutante de aggregate editable exige If-Match salvo creación.

| **Método** | **Ruta**                                 | **Uso**                     | **Control**                          | **Resultado** |
|------------|------------------------------------------|-----------------------------|--------------------------------------|---------------|
| POST       | /programs                                | Crear ProgramDefinition     | Idempotency-Key                      | 201           |
| GET        | /programs                                | Buscar portfolio            | —                                    | 200           |
| GET        | /programs/{programId}                    | Detalle                     | —                                    | 200           |
| PATCH      | /programs/{programId}                    | Modificar metadata editable | If-Match                             | 200/412       |
| POST       | /programs/{programId}/versions           | Crear versión               | Idempotency-Key                      | 201           |
| POST       | /program-versions/{id}/clone             | Clonar versión              | Idempotency-Key                      | 201           |
| GET        | /program-versions/{id}                   | Snapshot detalle            | —                                    | 200           |
| PATCH      | /program-versions/{id}                   | Editar draft                | If-Match                             | 200/412       |
| POST       | /program-versions/{id}:validate          | Preflight                   | —                                    | 200           |
| POST       | /program-versions/{id}:submit-review     | Enviar a revisión           | Idempotency-Key + If-Match           | 202           |
| POST       | /program-versions/{id}:publish           | Publicar                    | Idempotency-Key + If-Match + step-up | 200           |
| POST       | /program-versions/{id}:void              | Void                        | Idempotency-Key + If-Match + step-up | 200           |
| GET        | /program-versions/{left}:diff/{right}    | Comparar versiones          | —                                    | 200           |
| POST       | /program-versions/{id}:impact-simulation | Impacto downstream          | —                                    | 200           |
| POST       | /learning-modules                        | Crear module definition     | Idempotency-Key                      | 201           |
| POST       | /learning-modules/{id}/versions          | Crear module version        | Idempotency-Key                      | 201           |
| PATCH      | /learning-module-versions/{id}           | Editar module draft         | If-Match                             | 200/412       |
| POST       | /learning-module-versions/{id}:publish   | Publicar module version     | Idempotency-Key + If-Match + step-up | 200           |
| POST       | /pathways                                | Crear pathway               | Idempotency-Key                      | 201           |
| POST       | /pathways/{id}/versions                  | Crear pathway version       | Idempotency-Key                      | 201           |
| PATCH      | /pathway-versions/{id}                   | Editar route graph          | If-Match                             | 200/412       |
| POST       | /pathway-versions/{id}:publish           | Publicar pathway            | Idempotency-Key + If-Match + step-up | 200           |
| POST       | /change-requests                         | Crear change request        | Idempotency-Key                      | 201           |
| GET        | /publication-receipts/{id}               | Consultar receipt           | —                                    | 200           |
| POST       | /ai-assists                              | Solicitar sugerencia CT-12  | Idempotency-Key opcional             | 202           |

## 16.1 DTO — CreateProgramVersionRequest

{

"programId": "prg-uuid",

"officialName": "Bootcamp Ejecutivo de IA",

"shortName": "Bootcamp IA",

"purpose": "Desarrollar capacidades aplicadas...",

"targetAudience": "Profesionales y líderes...",

"academicHours": 48.0,

"credit": {"schemeCode": null, "value": null},

"completionModelCode": "ATTENDANCE_PLUS_ASSESSMENT",

"policyRefs": {

"attendance": "uuid",

"assessment": "uuid",

"certification": "uuid"

},

"validity": {"from": "2026-10-01", "to": null}

}

## 16.2 DTO — ProgramVersionDetailResponse

{

"id": "pv-uuid",

"programId": "prg-uuid",

"versionNo": 2,

"state": "DRAFT",

"etag": ""5"",

"contentHash": null,

"summary": {"academicHours": 48.0, "moduleCount": 6, "outcomeCount": 5},

"dependencyStatus": {

"policies": "AVAILABLE",

"eligibilityRules": "STALE",

"asOf": "2026-09-08T15:00:00Z"

},

"links": {"validate": true, "submitReview": true, "publish": false}

}

## 16.3 Problem Details y reason codes

| **HTTP** | **Reason code**                                                          | **Semántica**                                                 |
|----------|--------------------------------------------------------------------------|---------------------------------------------------------------|
| 400      | INVALID_REQUEST                                                          | Schema/format inválido.                                       |
| 401      | AUTHENTICATION_REQUIRED                                                  | No autenticado.                                               |
| 403      | SCOPE_FORBIDDEN / STEP_UP_REQUIRED                                       | Permiso/scope/assurance insuficiente.                         |
| 404      | PROGRAM_VERSION_NOT_FOUND                                                | No existe o no visible dentro del tenant.                     |
| 409      | INVALID_STATE / ALREADY_PUBLISHED / IDEMPOTENCY_KEY_REUSED / GRAPH_CYCLE | Conflicto de negocio/estado.                                  |
| 412      | VERSION_MISMATCH                                                         | If-Match/ETag obsoleto.                                       |
| 422      | PUBLICATION_VALIDATION_FAILED / POLICY_BLOCK / STRUCTURE_INVALID         | Regla de dominio no satisfecha.                               |
| 429      | RATE_LIMITED                                                             | Protección API/IA.                                            |
| 503      | DEPENDENCY_UNAVAILABLE                                                   | CT crítico no disponible; no convertir a resultado favorable. |

| **CONCURRENCIA —** La API nunca debe aceptar last-write-wins. GET devuelve ETag; PATCH/commands mutantes envían If-Match. Una publicación concurrente se protege además con la unicidad parcial de PUBLISHED y transaction/lock. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 16.4 Convención de colecciones, paginación y búsqueda

Toda colección usa pageSize bounded (default 50, máximo definido por policy; baseline técnico 200), sort estable con tie-breaker por ID y filtros explícitos. Para workspaces de alto volumen se recomienda cursor opaco; offset se permite solo donde el volumen/UX lo justifique. La respuesta incluye items, pageInfo y appliedFilters. Un pageSize fuera del límite produce 400/422 con reason code estable; nunca se ejecuta un SELECT sin límite desde UI.

## 16.5 Catálogo REST implementable V1.1

| **Capability**         | **Método / ruta**                                                             | **Concurrencia / idempotencia**      | **Resultado principal**                     |
|------------------------|-------------------------------------------------------------------------------|--------------------------------------|---------------------------------------------|
| Program definitions    | POST /ec/programs                                                             | Idempotency-Key                      | 201 ProgramDefinition                       |
| Portfolio list         | GET /ec/programs?cursor=&pageSize=&sort=&state=&owner=                        | —                                    | 200 paginated                               |
| Program definition     | GET /ec/programs/{programId}                                                  | ETag definition                      | 200/404                                     |
| Rename/metadata draft  | PATCH /ec/programs/{programId}                                                | If-Match                             | 200 + ETag                                  |
| Create program version | POST /ec/programs/{programId}/versions                                        | Idempotency-Key                      | 201 ProgramVersion                          |
| Version detail         | GET /ec/program-versions/{versionId}                                          | ETag aggregate                       | 200                                         |
| Draft metadata         | PATCH /ec/program-versions/{versionId}                                        | If-Match                             | 200 + new ETag                              |
| Delivery modes         | PUT /ec/program-versions/{versionId}/delivery-modes                           | If-Match + Idempotency-Key           | 200 + ETag                                  |
| Outcome add            | POST /ec/program-versions/{versionId}/outcomes                                | If-Match + Idempotency-Key           | 201 + root ETag                             |
| Outcome update         | PUT /ec/program-versions/{versionId}/outcomes/{outcomeId}                     | If-Match                             | 200 + root ETag                             |
| Outcome delete         | DELETE /ec/program-versions/{versionId}/outcomes/{outcomeId}                  | If-Match                             | 204 + root ETag                             |
| Competency binding     | POST /ec/program-versions/{versionId}/competencies                            | If-Match + Idempotency-Key           | 201 + root ETag                             |
| Structure group        | POST /ec/program-versions/{versionId}/structure/groups                        | If-Match + Idempotency-Key           | 201 + root ETag                             |
| Reparent/reorder group | POST /ec/program-versions/{versionId}/structure/groups/{groupId}:move         | If-Match + Idempotency-Key           | 200 + root ETag                             |
| Structure item         | POST /ec/program-versions/{versionId}/structure/items                         | If-Match + Idempotency-Key           | 201 + root ETag                             |
| Dependency edge        | POST /ec/program-versions/{versionId}/structure/dependencies                  | If-Match + Idempotency-Key           | 201 + root ETag                             |
| Requirement            | POST /ec/program-versions/{versionId}/requirements                            | If-Match + Idempotency-Key           | 201 + root ETag                             |
| Credential blueprint   | POST /ec/program-versions/{versionId}/credential-blueprints                   | If-Match + Idempotency-Key           | 201 + root ETag                             |
| Blueprint requirement  | POST /ec/program-versions/{versionId}/credential-blueprints/{id}/requirements | If-Match + Idempotency-Key           | 201 + root ETag                             |
| Validate               | POST /ec/program-versions/{versionId}:validate                                | If-Match                             | 200 ValidationReport                        |
| Submit review          | POST /ec/program-versions/{versionId}:submit-review                           | If-Match + Idempotency-Key           | 202 operationId cuando CT-06 async          |
| Approve/reject         | POST /ec/program-versions/{versionId}:review-decision                         | If-Match + Idempotency-Key           | 200/202                                     |
| Schedule future        | POST /ec/program-versions/{versionId}:schedule                                | If-Match + Idempotency-Key           | 200 SCHEDULED                               |
| Publish now            | POST /ec/program-versions/{versionId}:publish                                 | If-Match + Idempotency-Key + step-up | 200 PUBLISHED                               |
| Void                   | POST /ec/program-versions/{versionId}:void                                    | If-Match + Idempotency-Key + reason  | 200 VOID                                    |
| Diff                   | GET /ec/program-versions/{a}:diff?against={b}                                 | —                                    | 200 deterministic diff                      |
| Impact                 | POST /ec/program-versions/{versionId}:impact                                  | Idempotency-Key optional             | 200/202 PARTIAL-aware                       |
| Module catalog         | GET/POST /ec/learning-modules                                                 | GET bounded / POST idempotent        | 200/201                                     |
| Module versions        | POST /ec/learning-modules/{id}/versions                                       | Idempotency-Key                      | 201                                         |
| Module outcomes        | POST/PUT/DELETE /ec/learning-module-versions/{id}/outcomes                    | If-Match root                        | 201/200/204                                 |
| Pathways               | GET/POST /ec/pathways                                                         | GET bounded / POST idempotent        | 200/201                                     |
| Pathway versions       | POST /ec/pathways/{id}/versions                                               | Idempotency-Key                      | 201                                         |
| Pathway nodes/edges    | POST/PUT/DELETE /ec/pathway-versions/{id}/nodes\|edges                        | If-Match root                        | root ETag                                   |
| Operation status       | GET /ec/operations/{operationId}                                              | —                                    | 200 PENDING/SUCCEEDED/FAILED/UNKNOWN_EFFECT |

## 16.6 OperationStatus para 202 y UNKNOWN_EFFECT

| **Campo**     | **Tipo**                                            | **Regla**                                                                |
|---------------|-----------------------------------------------------|--------------------------------------------------------------------------|
| operationId   | UUID                                                | Estable y correlacionable con audit/outbox/integration receipt.          |
| status        | PENDING\|RUNNING\|SUCCEEDED\|FAILED\|UNKNOWN_EFFECT | UNKNOWN_EFFECT nunca se convierte en FAILED por timeout sin reconciliar. |
| resourceRef   | UUID?                                               | Se llena si el efecto creó/reconoció un recurso.                         |
| reasonCode    | string?                                             | Código estable cuando FAILED/UNKNOWN_EFFECT.                             |
| retryAfter    | instant?                                            | Orientativo para polling/backoff; no garantiza finalización.             |
| correlationId | UUID                                                | Trazabilidad E2E.                                                        |
| updatedAt     | timestamptz                                         | UTC; permite detectar stale operation view.                              |

## 16.7 Contratos DTO de comandos críticos V1.1

Los siguientes DTOs son contratos mínimos; OpenAPI debe especificar formatos, maxLength, patterns, required, enums y ejemplos. tenantId, actor, state, version y campos de auditoría no son writable desde body salvo que el contrato lo declare explícitamente.

| **DTO**                                         | **Campos mínimos**                                                                                                                          | **Validaciones críticas**                                                      |
|-------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------|
| **CreateProgramOutcomeRequest**                 | outcomeCode, statement, taxonomyLevelCode?, sequenceNo, mandatory                                                                           | code no vacío/longitud; statement no vacío; sequenceNo\>0.                     |
| **UpsertDeliveryModesRequest**                  | items\[{deliveryModeCode,isDefault,policyRef?}\]                                                                                            | codes sin duplicar; como máximo un default; policyRef = PolicyVersionRef.      |
| **CreateStructureGroupRequest**                 | parentGroupId?, groupCode, groupTypeCode, title, minItems, maxItems?, sequenceNo                                                            | parent same version; min\>=0; max\>=min; sibling order.                        |
| **MoveStructureGroupRequest**                   | newParentGroupId?, sequenceNo, reasonCode?                                                                                                  | If-Match root; no ciclo; sibling order; no reparent cross-version.             |
| **CreateStructureItemRequest**                  | structureGroupId, learningModuleVersionId, slotCode, sequenceNo, mandatory, hoursOverride?, creditsOverride?, overrideReasonCode?           | ModuleVersion pinneada; overrides \>0 y reason obligatorio si existe override. |
| **CreateStructureDependencyRequest**            | fromStructureItemId, toStructureItemId, dependencyType, policyRef?                                                                          | no self; same ProgramVersion; cycle-safe para PRE_REQUISITE/SEQUENCE.          |
| **CreateProgramRequirementRequest**             | requirementCode, requirementTypeCode, title, eligibilityRuleRef, mandatory, sequenceNo                                                      | eligibilityRuleRef versionada CT-15/CT-02; sequenceNo\>0.                      |
| **CreateCredentialBlueprintRequest**            | credentialCode, credentialTypeCode, displayName, descriptionText?, verificationProfileCode?, validityPolicyRef?, evidencePolicyRef?, status | status de diseño; no existe publish independiente.                             |
| **CreateCredentialBlueprintRequirementRequest** | requirementKind, programRequirementId?, programOutcomeId?, structureItemId?, rulePolicyRef?, mandatory, sequenceNo                          | typed target exactamente según requirementKind.                                |
| **ReviewDecisionRequest**                       | decision, reasonCode, evidenceRef?                                                                                                          | decision APPROVE\|REJECT; actor autorizado; SoD.                               |
| **ScheduleProgramVersionRequest**               | validFrom, reasonCode, evidenceRef?                                                                                                         | validFrom futura/permitida por policy; state APPROVED; step-up según política. |
| **VoidProgramVersionRequest**                   | reasonCode, evidenceRef                                                                                                                     | reason obligatorio; privilegio/step-up; no delete.                             |
| **OperationStatusResponse**                     | operationId,status,resourceRef?,reasonCode?,retryAfter?,correlationId,updatedAt                                                             | status explícito; UNKNOWN_EFFECT conserva reconciliación.                      |

# 17. Eventos: domain events, integration events, outbox, inbox y AsyncAPI

| **ID**       | **Evento**                     | **Producer** | **Consumers**                 |
|--------------|--------------------------------|--------------|-------------------------------|
| EVT-EC01-001 | ProgramDefinitionActivated     | EC-01        | CT-11                         |
| EVT-EC01-002 | ProgramVersionReviewSubmitted  | EC-01        | CT-07/11                      |
| EVT-EC01-003 | ProgramVersionApproved         | EC-01        | CT-11                         |
| EVT-EC01-004 | ProgramVersionPublished        | EC-01        | EC-02, EC-08, EC-10, CT-11    |
| EVT-EC01-005 | ProgramVersionSuperseded       | EC-01        | EC-02, EC-08, EC-10, CT-11    |
| EVT-EC01-006 | ProgramVersionVoided           | EC-01        | EC-02, EC-08, EC-10, CT-11    |
| EVT-EC01-007 | LearningModuleVersionPublished | EC-01        | CT-11 / portfolio projections |
| EVT-EC01-008 | CredentialBlueprintPublished   | EC-01        | EC-08, CT-11                  |
| EVT-EC01-009 | PathwayVersionPublished        | EC-01        | EC-10, CT-11                  |
| EVT-EC01-010 | PathwayVersionSuperseded       | EC-01        | EC-10, CT-11                  |
| EVT-EC01-011 | DesignChangeRequestSubmitted   | EC-01        | CT-06/07                      |
| EVT-EC01-012 | DesignChangeApplied            | EC-01        | CT-11                         |

## 17.1 Envelope mínimo

{

"messageId": "uuid",

"tenantId": "uuid",

"eventType": "ProgramVersionPublished",

"schemaVersion": 1,

"occurredAt": "2026-09-08T16:00:00Z",

"correlationId": "uuid",

"causationId": "uuid",

"aggregateType": "ProgramVersion",

"aggregateId": "uuid",

"dataClassification": "INTERNAL",

"payload": {

"programId": "uuid",

"programVersionId": "uuid",

"versionNo": 2,

"contentHash": "sha256:...",

"publicationReceiptId": "uuid"

}

}

AsyncAPI debe versionar channels, schemas y compatibility policy. Los payloads no deben copiar textos extensos ni PII innecesaria: consumers resuelven el snapshot por API si tienen autorización. Renombrar un campo breaking exige nueva schemaVersion y contract tests.

| **OUTBOX / INBOX —** Aggregate + publication receipt + outbox se persisten en una transacción local. Consumers deduplican por messageId/inbox. El sistema garantiza at-least-once + idempotent consumer + reconciliation, no exactly-once distribuido. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 18. Integraciones: timeouts, retries, circuit breaker, degradación, reconciliation y UNKNOWN_EFFECT

| **Dependencia**               | **Operación**      | **Timeout**          | **Retry**                             | **Degradación**                                         | **Reconciliation**                         |
|-------------------------------|--------------------|----------------------|---------------------------------------|---------------------------------------------------------|--------------------------------------------|
| CT-01 Scope                   | read/assert        | 1–3 s según baseline | Retry corto solo idempotent           | Fail-closed command; UI STALE read                      | No efecto remoto normalmente.              |
| CT-02 Policy                  | read/snapshot      | 1–3 s                | Retry + cache versionada              | Publish fail-closed; editing puede seguir               | Resolver exact policy version.             |
| CT-05 Evidence                | read/create ref    | según baseline       | Create exige idempotency key          | Si required evidence no disponible, bloquear transición | Query receipt antes de retry create.       |
| CT-06 Workflow                | create/query       | 2–5 s                | No retry ciego tras timeout de create | DRAFT/IN_REVIEW con external effect status              | Reconcile por correlation/idempotency key. |
| CT-07 Notification            | command            | async                | Outbox/retry                          | No revierte hecho académico                             | Receipt eventual.                          |
| CT-12 AI                      | request            | 5–30 s               | Retry acotado según contract          | Edición manual disponible                               | Run id evita duplicado/costo.              |
| CT-15 Eligibility definitions | read/validate ref  | 1–3 s                | Retry/cache                           | Publish fail-closed si obligatorio                      | Re-resolve version exacta.                 |
| CT-09/Broker                  | publish via outbox | async                | Dispatcher backoff                    | Business commit se conserva                             | Delivery state + reconciliation.           |

## 18.1 UNKNOWN_EFFECT normativo

Ejemplo: EC-01 solicita a CT-06 crear workflow, CT-06 lo crea y la respuesta se pierde. El adapter no debe enviar un segundo create automáticamente si no existe una idempotency contract que lo haga seguro. Persiste correlation/request receipt, marca external_effect_state=UNKNOWN_EFFECT en la orquestación correspondiente, consulta status/reconcile y solo reintenta create cuando se demuestra que el efecto no ocurrió.

## 18.2 Estados de datos en UI

| **Estado**     | **Significado**                                     | **Prohibido mostrar como**        |
|----------------|-----------------------------------------------------|-----------------------------------|
| NO_DATA        | Consulta válida sin registros                       | ZERO cuando la métrica no aplica  |
| ZERO           | Métrica válida con valor 0                          | NO_DATA                           |
| STALE          | Dato conocido pero más antiguo que freshness budget | Actual sin advertencia            |
| PARTIAL        | Respuesta incompleta con provenance                 | Completa                          |
| UNAVAILABLE    | Dependencia no respondió/no es accesible            | Lista vacía                       |
| UNKNOWN_EFFECT | No se conoce si un command remoto fue aplicado      | Error simple que invita a repetir |

# 19. Frontend Web enterprise por workspaces

El Frontend no se reduce a “pantallas CRUD”. Debe organizar el trabajo académico por decisiones: descubrir portfolio, diseñar una versión, construir estructura, revisar calidad, comparar cambios, aprobar/publicar y auditar. React/TypeScript usa feature modules, API client tipado desde OpenAPI, query cache con keys tenant/scope-aware y mutations con ETag.

| **Workspace**                 | **Usuario**                           | **Ruta**                                       | **Layout/componentes**                                                                                                                                                                                             | **Acciones**                                                                                                              | **Estados/UX**                                                                                                               |
|-------------------------------|---------------------------------------|------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| EC Portfolio Studio           | Portfolio Manager / Academic Designer | /ec/portfolio                                  | Shell con navegación lateral; header scope + freshness; grid/list de programas y módulos; filtros por estado/familia/owner/idioma; KPIs published/draft/review; bulk actions solo no críticas.                     | Create program, open version, clone, suspend/retire según permiso.                                                        | Empty: first-program onboarding. Loading skeleton. Error con correlationId. STALE badge cuando catálogos/policies cacheados. |
| Program Design Workspace      | Academic Designer                     | /ec/portfolio/programs/:id/versions/:versionId | Header con breadcrumb, state chip, ETag status, actions; tabs Overview · Outcomes · Competencies · Structure · Requirements · Credentials · Validation · History. Right rail con validation issues y dependencies. | Autosave NO silencioso si puede ocultar conflictos; explicit/save mutations con If-Match; clone, validate, submit review. | 412 abre Conflict Drawer con server/current diff. UNAVAILABLE policy no se reemplaza por default.                            |
| Structure Builder             | Curriculum Designer                   | .../structure                                  | Canvas/ordered tree de groups/items; module picker drawer; dependency graph; hours summary y cardinality panel.                                                                                                    | Add/reorder groups/items, set prerequisite, detect cycles, compare total hours.                                           | Keyboard accessible reorder alternative; graph has tabular accessible representation; cycle reason code visible.             |
| Learning Module Library       | Academic Designer                     | /ec/portfolio/modules                          | Search library, module definition detail, version timeline, usage map.                                                                                                                                             | Create/clone module version; publish if authorized.                                                                       | Usage map puede ser PARTIAL si downstream index stale; mostrar asOf.                                                         |
| Credential Blueprint Desk     | Credential Designer                   | .../credentials                                | Cards por blueprint; builder de typed requirements; verification profile panel; preview metadata only.                                                                                                             | Create/retire blueprint draft; validate targets.                                                                          | Nunca mostrar “emitido” aquí; enlace a EC-08 cuando exista.                                                                  |
| Pathway Designer              | Pathway Designer                      | /ec/portfolio/pathways/:id/versions/:versionId | Graph editor + node catalog + edge inspector + stacking policy + accessible table view.                                                                                                                            | Add node/edge, validate cycle, publish.                                                                                   | Graph keyboard alternative mandatory; external refs show resolution status.                                                  |
| Review & Approval Center      | Reviewer/Approver                     | /ec/portfolio/reviews                          | Work queue por CT-06 refs; side-by-side diff; validation pack; evidence; SoD warnings.                                                                                                                             | Approve/reject/request changes; publish only role-separated permission.                                                   | IN_REVIEW hash mismatch blocks approval and explains cause.                                                                  |
| Publication & Lineage Console | Publisher/Auditor                     | /ec/portfolio/publications                     | Version timeline, content hashes, receipts, downstream consumers and delivery status.                                                                                                                              | Publish, supersede, void per permission; export evidence pack.                                                            | UNKNOWN_EFFECT/outbox pending uses dedicated status; no “retry” blind button.                                                |
| Reconciliation Center         | Ops/SRE                               | /ec/portfolio/reconciliation                   | Queues for outbox/inbox/workflow unknown effects; filters correlation/error/age.                                                                                                                                   | Reconcile, safe retry, escalate; no academic content edit.                                                                | Show operational vs business rejection separately.                                                                           |

## 19.1 Comportamiento responsive y accesibilidad

- Desktop ≥1280: paneles múltiples para diff/structure. Tablet: drawers reemplazan side panels; no perder context. Mobile web: lectura y review ligera; authoring de grafo/estructura se redirige a desktop cuando no sea usable.

- WCAG 2.2 AA baseline: focus visible, landmarks, labels, error summary, contrast, keyboard navigation y alternativa tabular para cualquier grafo.

- No depender solo de color para state/validation.

- Unsaved changes guard solo para DRAFT; no usar optimistic UI para publish/void.

- Cada dependency widget muestra asOf/provenance y diferencia STALE/PARTIAL/UNAVAILABLE.

## 19.2 Baseline Frontend normativo para EC-01…EC-12

| **Capa**     | **Baseline de implementación**                                | **Regla**                                                                           |
|--------------|---------------------------------------------------------------|-------------------------------------------------------------------------------------|
| Type system  | TypeScript strict                                             | noImplicitAny/strictNullChecks; DTOs generados, domain view models tipados.         |
| HTTP client  | Generado desde OpenAPI; fetch/adapter central                 | No axios/fetch ad-hoc por feature; correlation, ProblemDetail y ETag centralizados. |
| Server state | TanStack Query o baseline equivalente fijado por Frontend BOM | Query keys incluyen tenant/scope/filtros; cache no es Source of Truth.              |
| Forms        | React Hook Form + schema validation (Zod o baseline BOM)      | Validación cliente mejora UX, pero Backend/DB siguen siendo autoridad.              |
| Routing      | Next.js App Router o React Router/Vite según baseline PeopleU | La vertical no mezcla dos routers dentro del mismo deployable.                      |
| Errors       | ErrorBoundary + ProblemDetail mapper                          | 400/403/409/412/422/503 producen UX distinta; no toast genérico para todo.          |
| Testing      | Component + integration + E2E                                 | MSW/contract fixtures derivados de OpenAPI; accessibility tests obligatorios.       |
| Telemetry    | OpenTelemetry/browser telemetry aprobado                      | Nunca PII académica innecesaria en logs/analytics.                                  |

## 19.3 Mutation workflow no negociable

Las pantallas editables guardan el ETag recibido con el query result. Cada comando hijo envía If-Match del root; tras éxito reemplaza/invalida cache con el ETag nuevo. Un 412 abre conflict drawer con reload/diff/reapply; jamás reintenta automáticamente la mutación. NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT permanecen estados visuales distintos.

# 20. Mobile

EC-01 no justifica replicar el authoring enterprise completo en React Native. Diseñar currículos, grafos de requisitos y rutas con controles complejos en teléfono aumenta error operativo y superficie de seguridad. Por ello Mobile queda deliberadamente restringido a lectura/review asistida y deep links; las mutaciones académicas críticas se realizan en Web.

| **Journey móvil**                    | **Permitido**                       | **Offline**                               | **Seguridad/restricción**                            |
|--------------------------------------|-------------------------------------|-------------------------------------------|------------------------------------------------------|
| Consultar programa/version publicada | Sí, read-only                       | Cache de última versión con STALE visible | Tenant/scope; no editar.                             |
| Revisar validation summary           | Sí                                  | Último report cacheado; marcar asOf       | No aprobar desde cache offline.                      |
| Aprobar review                       | Opcional solo si policy lo habilita | NO                                        | Step-up/MFA + online + SoD; preferencia Web.         |
| Publicar/supersede/void              | NO por baseline EC-01               | NO                                        | Operación administrativa crítica reservada Web.      |
| Recibir push de tarea                | Sí vía CT-07                        | N/A                                       | Deep link autenticado; contenido mínimo.             |
| Consultar publication receipt        | Sí read-only                        | Metadata no sensible cacheable            | No expone policy snapshot completo si no autorizado. |

# 21. Matriz Frontend / Backend / Mobile

| **Capacidad**             | **Frontend Web**                        | **Backend**                       | **Mobile**             |
|---------------------------|-----------------------------------------|-----------------------------------|------------------------|
| Create ProgramDefinition  | Form + validation                       | Command + uniqueness + audit      | No                     |
| Edit Draft ProgramVersion | Tabbed workspace + ETag                 | Aggregate commands + @Version     | Read-only              |
| Structure graph           | Builder + accessible table              | Graph validation + DB trigger     | No                     |
| Validate                  | Issue panel                             | Validation orchestration          | Summary read           |
| Submit review             | Command button                          | CT-06 adapter + idempotency       | Deep link only         |
| Approve                   | Diff + evidence                         | Inbox/workflow decision + SoD     | Optional online policy |
| Publish                   | Confirmation + step-up + impact summary | Atomic publish + receipt + outbox | No                     |
| Version diff              | Side-by-side                            | Deterministic diff/read model     | Read summary           |
| Pathway graph             | Graph editor                            | Typed node/edge + cycle guard     | Read-only              |
| AI assist                 | Suggestion drawer                       | CT-12 port + provenance           | No authoring           |
| Reconciliation            | Ops queue                               | Outbox/inbox/reconcile service    | No                     |

# 22. Seguridad: RBAC, ABAC, SoD, step-up, privacy y purpose limitation

## 22.1 Roles funcionales sugeridos

| **Rol**                | **Responsabilidad**                          |
|------------------------|----------------------------------------------|
| EC_PORTFOLIO_VIEWER    | Lectura de portfolio publicado/autorizado.   |
| EC_PORTFOLIO_MANAGER   | ProgramDefinition lifecycle y portfolio.     |
| EC_ACADEMIC_DESIGNER   | Editar drafts de programas/módulos.          |
| EC_CURRICULUM_DESIGNER | Estructura/dependencies.                     |
| EC_CREDENTIAL_DESIGNER | Blueprints.                                  |
| EC_PATHWAY_DESIGNER    | Rutas.                                       |
| EC_ACADEMIC_REVIEWER   | Review técnico/académico.                    |
| EC_ACADEMIC_APPROVER   | Decisión de aprobación.                      |
| EC_ACADEMIC_PUBLISHER  | Publish/supersede con step-up.               |
| EC_COMPLIANCE_REVIEWER | Validación compliance profile.               |
| EC_AUDITOR             | Read audit/receipts.                         |
| EC_OPS_RECONCILER      | Reconciliation técnica sin editar contenido. |

## 22.2 ABAC y scope

Toda autorización combina permiso RBAC con atributos: tenant, academic_owner_scope_ref, campus/sede cuando aplique, estado del aggregate, assurance level, relación del actor con workflow y propósito. Tener el role EC_ACADEMIC_PUBLISHER no autoriza publicar cualquier programa de cualquier scope.

## 22.3 Separación de funciones

| **Operación**        | **Puede iniciar**    | **Puede aprobar/publicar** | **No debe aprobar**                                  |
|----------------------|----------------------|----------------------------|------------------------------------------------------|
| Nueva ProgramVersion | Designer             | Approver + Publisher       | Mismo actor como único aprobador si policy exige SoD |
| Change material      | Designer/Manager     | Approver/Publisher         | Solicitante si conflicto definido                    |
| Void                 | Governance/Publisher | Governance con step-up     | Actor sin scope o assurance                          |
| Migration promotion  | Data Steward         | Data Owner/Approver        | Mismo proceso automatizado sin evidence              |

## 22.4 Step-up y evidencia

- Publish ProgramVersion/ModuleVersion/PathwayVersion: step-up según policy, registrar assurance level.

- Void/supersede excepcional: step-up obligatorio + reason_code + evidence_ref cuando policy.

- Export de policy snapshot/evidence: ABAC purpose + auditor role.

- AI suggestion no eleva permisos: la aplicación del cambio usa los mismos permisos que edición manual.

## 22.5 Privacy

EC-01 debería contener prácticamente cero PII de participantes. Los subject IDs de actores administrativos son referencias técnicas para auditoría. Los comentarios/evidence deben evitar datos personales innecesarios; CT-05/10 gobiernan retención, clasificación, legal hold y acceso. Purpose limitation impide usar audit logs o AI prompts para finalidades no autorizadas.

## 22.6 Threat Model EC-01 — amenazas mínimas

| **Amenaza**            | **Vector**                                | **Control obligatorio**                                 | **Evidencia**              |
|------------------------|-------------------------------------------|---------------------------------------------------------|----------------------------|
| IDOR / cross-tenant    | IDs válidos de otro tenant                | RLS FORCE + ABAC/scope + 404/403 sin data leak          | Security integration tests |
| Mass assignment        | DTO intenta state/tenant/version internos | DTO allowlist + server-derived tenant/state transitions | API negative tests         |
| ETag bypass            | Mutación de child sin root revision       | Command boundary + DB bump + 412                        | Concurrency tests          |
| Replay                 | Publish/import/review repetido            | Durable Idempotency-Key + request_hash                  | Idempotency tests          |
| Graph DoS              | Miles de nodes/edges/ciclos               | Policy budgets + bounded validation + timeout/perf SLO  | Performance tests          |
| SQL injection          | Filtros/sort dinámicos                    | Parameterized queries + allowlisted sort/filter         | SAST/DAST/API tests        |
| Privilege escalation   | Designer intenta publish                  | RBAC+ABAC+SoD+step-up                                   | Security tests + audit     |
| Receipt tampering      | UPDATE/DELETE directo                     | Append-only trigger + restricted DB role                | DB negative test           |
| RLS bypass             | Runtime role owner/BYPASSRLS              | Role audit + FORCE RLS                                  | Deployment evidence        |
| Dependency confusion   | Malicious package/artifact                | SCA, lockfiles, repository allowlist, SBOM              | CI evidence                |
| Secret leakage         | Token en repo/log                         | Secret scanning + vault + log redaction                 | CI + runtime audit         |
| Async duplicate effect | Timeout + blind retry                     | OperationStatus/receipt/reconcile before retry          | Resilience tests           |

## 22.7 Secure SDLC gate

CI/CD debe ejecutar SAST, SCA, secret scanning, SBOM, container/image scanning y contract tests. Hallazgos Critical/High bloquean release salvo excepción formal con owner, expiración y compensating control. La imagen de runtime usa usuario no-root, filesystem y capabilities mínimos según baseline DevSecOps. Credenciales de migración no se distribuyen al pod HTTP normal.

# 23. Auditoría: Audit Trail, Evidence Pack, lineage y reason codes

| **Acción**            | **Recurso**       | **Evidencia mínima**                           | **Objetivo**                 |
|-----------------------|-------------------|------------------------------------------------|------------------------------|
| PROGRAM_CREATED       | ProgramDefinition | actor/scope/code                               | Creación identidad           |
| VERSION_CREATED       | ProgramVersion    | previous_version_id/version_no                 | Lineage                      |
| VERSION_CHANGED       | Draft             | field diff + reason when sensitive             | Trazabilidad de cambios      |
| REVIEW_SUBMITTED      | ProgramVersion    | hash/workflow_ref                              | Prueba del snapshot revisado |
| REVIEW_DECIDED        | ProgramVersion    | decision/evidence/actor                        | Aprobación                   |
| VERSION_PUBLISHED     | ProgramVersion    | content_hash/policy snapshot/assurance/receipt | Hecho crítico                |
| VERSION_SUPERSEDED    | ProgramVersion    | old/new refs                                   | Historia                     |
| VERSION_VOIDED        | Version           | reason/evidence/assurance                      | Corrección excepcional       |
| PATHWAY_GRAPH_CHANGED | PathwayVersion    | node/edge diff                                 | Diseño stackable             |
| AI_SUGGESTION_APPLIED | Draft             | run_ref/reviewer/outcome                       | IA explicable                |
| MIGRATION_PROMOTED    | Any               | lineage/batch/receipt                          | Data provenance              |
| RECONCILIATION_ACTION | Integration       | correlation/result/reason                      | Operaciones                  |

Evidence Pack de una publicación debe permitir responder: quién diseñó/revisó/aprobó/publicó, qué content hash se aprobó, qué policies/versiones estaban vigentes, qué validaciones se ejecutaron, qué dependencias estaban disponibles, qué versión fue superseded, qué eventos se emitieron y qué artefactos externos respaldan la decisión.

# 24. Observabilidad: logs, metrics, traces, SLI, SLO, performance, concurrencia y resiliencia

## 24.1 Logging/tracing

- Structured logs JSON: tenantId (no PII), correlationId, traceId, actor subject pseudonymous, operation, aggregateId, reasonCode, dependency, durationMs, outcome.

- OpenTelemetry spans para validation, policy resolution, workflow calls, publish transaction, outbox dispatch y AI assist.

- No loggear payloads académicos completos ni evidence content si no es necesario; usar IDs/hash.

## 24.2 Métricas técnicas y de negocio

| **Métrica**                    | **Tipo**  | **Uso**                               |
|--------------------------------|-----------|---------------------------------------|
| ec01_http_request_duration     | histogram | latencia por endpoint/status          |
| ec01_publish_duration          | histogram | tiempo de publish                     |
| ec01_publish_failures_total    | counter   | reason codes                          |
| ec01_validation_issues_total   | counter   | severity/type                         |
| ec01_etag_conflicts_total      | counter   | conflictos de concurrencia            |
| ec01_outbox_pending            | gauge     | backlog                               |
| ec01_outbox_age_seconds        | gauge     | evento más antiguo pendiente          |
| ec01_unknown_effect_total      | counter   | integraciones ambiguas                |
| ec01_program_versions_by_state | gauge     | portfolio lifecycle                   |
| ec01_ai_suggestion_acceptance  | counter   | accepted/rejected sin evaluar persona |

## 24.3 SLI/SLO baseline propuesto

| **SLI**                     | **Medición**                                  | **SLO/threshold**                                           |
|-----------------------------|-----------------------------------------------|-------------------------------------------------------------|
| Read availability portfolio | successful eligible reads / total             | ≥ 99.9% mensual excluyendo maintenance aprobado             |
| Command availability        | commands processed / eligible commands        | ≥ 99.5%                                                     |
| p95 read latency            | GET program/version/search                    | \< 500 ms sin dependencia remota pesada                     |
| p95 draft mutation          | PATCH/command local                           | \< 800 ms                                                   |
| Publish completion          | successful publish excluding business rejects | p95 \< 3 s si dependencies dentro SLA; documentar externos  |
| Outbox delivery             | events DELIVERED within 60 s                  | ≥ 99.9%                                                     |
| Reconciliation lag          | UNKNOWN_EFFECT age                            | alert \> 5 min crítico / \>30 min no crítico según contract |

Un business rejection 422 por regla incumplida no es “availability failure”. Los dashboards deben separar operational failure (5xx, timeout, DB issue) de business rejection (409/412/422 esperado).

## 24.4 Performance/concurrencia

- Portfolio search usa índices tenant+state/owner y read projections cuando el volumen lo justifique.

- N+1 prohibido al cargar ProgramVersion detail; diseñar repository queries/fetch plans por use case.

- Publish toma lock mínimo; las resoluciones CT deben ocurrir antes y luego revalidarse dentro de transaction.

- Graph validation debe limitar tamaño por policy y usar algoritmos O(V+E); el trigger DB es última defensa, no el único validador.

- Prueba de carga debe incluir concurrent draft edits, two publishers, bulk migration validation y outbox backlog recovery.

## 24.5 Capacity budgets y acceptance thresholds

| **Dimensión**            | **Baseline inicial**                                               | **Comportamiento al exceder**                                         |
|--------------------------|--------------------------------------------------------------------|-----------------------------------------------------------------------|
| pageSize REST            | 50 default; máximo 200 salvo policy aprobada                       | 400/422; nunca consulta ilimitada.                                    |
| Structure groups/items   | Límite parametrizado por tenant/program family                     | 422 CAPACITY_LIMIT con recomendación de partición.                    |
| Dependency/pathway graph | V/E máximos parametrizados                                         | 422 o procesamiento async 202; nunca bloquear thread indefinidamente. |
| Request payload          | Límite de plataforma + límite por endpoint                         | 413 PAYLOAD_TOO_LARGE.                                                |
| Validation sync budget   | p95 objetivo definido por SLO; excedido pasa a async cuando aplica | 202 + OperationStatus.                                                |
| Outbox batch             | 1..500 por claim                                                   | DB function rechaza batch inválido.                                   |

# 25. IA aplicada al módulo

Toda IA se consume mediante CT-12. EC-01 nunca instancia SDK directo de proveedor. La utilidad principal es reducir carga de diseño sin delegar autoridad académica: sugerir outcomes a partir de evidence, detectar redundancias, proponer mappings de competencias, resumir diferencias, advertir inconsistencias de horas o lenguaje y generar borradores de descripciones.

| **Caso**   | **Uso**                      | **Grounding**                              | **Output**                                    | **Límite**                            |
|------------|------------------------------|--------------------------------------------|-----------------------------------------------|---------------------------------------|
| AI-EC01-01 | Sugerir ProgramOutcomes      | Program purpose + evidence refs permitidos | Lista de suggestions con grounding/confidence | Human apply                           |
| AI-EC01-02 | Detectar outcomes duplicados | Outcomes de draft + published refs         | Similarity clusters                           | No borrar automáticamente             |
| AI-EC01-03 | Mapear competencias          | Outcome + competency catalog retrieval     | Ranked competency refs                        | Reviewer selecciona                   |
| AI-EC01-04 | Resumir diff                 | Canonical version diff                     | Narrative summary                             | Diff determinista sigue authoritative |
| AI-EC01-05 | Detectar gaps de estructura  | Outcomes vs module outcomes                | Risk/suggestion                               | No bloquear sin policy determinista   |
| AI-EC01-06 | Borrador de descripción      | Structured design facts                    | Text draft                                    | No inventar facts; grounding refs     |

## 25.1 Provenance obligatorio

{

"runRef": "ct12-run-uuid",

"modelRef": "model-policy-ref",

"templateRef": "ec01-outcome-suggest-v3",

"evalRef": "eval-suite-uuid",

"groundingRefs": \["doc-ref-1", "program-version-ref"\],

"confidence": 0.78,

"reviewerSubjectRef": "uuid",

"outcome": "ACCEPTED_WITH_EDITS"

}

| **LÍMITE IA —** IA no aprueba, no publica, no cambia un snapshot PUBLISHED, no crea equivalencia PG/PO y no convierte confidence en regla académica. AI recommendation ≠ academic decision. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 26. Analítica y KPI

| **KPI**                   | **Definición**                                      | **Fuente/uso**                    |
|---------------------------|-----------------------------------------------------|-----------------------------------|
| Portfolio size            | ProgramDefinition ACTIVE por familia/owner          | EC-01 facts → CT-11               |
| Published version age     | Edad de PUBLISHED vigente                           | Detectar refresh candidates       |
| Draft aging               | Días en DRAFT/IN_REVIEW                             | Operación de diseño               |
| Revision frequency        | Nuevas versiones por programa/año                   | Gobierno de cambio                |
| Validation defect density | Issues por versión/severity                         | Calidad de diseño                 |
| Structure reuse           | ModuleVersion reutilizadas en \>1 program           | Eficiencia/reuse                  |
| Outcome coverage          | Program outcomes con module outcome mapping/binding | Calidad curricular                |
| Credential coverage       | ProgramVersion con blueprints                       | Estrategia microcredencial        |
| Pathway connectivity      | Nodos/edges/orphans                                 | Calidad de rutas                  |
| Publish lead time         | Draft creation → published                          | Flujo operativo                   |
| AI assist adoption        | runs/acceptance por type                            | Eficiencia, no evaluación laboral |

CT-11 es owner de datasets/BI; EC-01 produce eventos y hechos. Los KPIs no deben crear shadow tables autoritativas ni usarse para evaluar desempeño individual de personal sin purpose/policy explícita.

# 27. Migración legacy y Data Quality con CT-16

La migración de catálogos/cursos legacy es riesgosa porque sistemas anteriores suelen mezclar definición, edición, docente, precio y participante en una sola tabla. El objetivo no es copiar filas: es separar semánticas y promover únicamente hechos EC-01 válidos mediante casos de uso de dominio.

1.  Extract — CT-16 extrae programas, módulos, versiones históricas y relaciones manteniendo source system/key.

2.  Profile — medir duplicados por code/title, fechas, estados, horas, módulos y referencias faltantes.

3.  Normalize — normalizar códigos, whitespace, fechas, decimal hours, locale y identifiers sin perder raw source.

4.  Map — clasificar cada registro en ProgramDefinition, ProgramVersion, LearningModuleDefinition/Version, structure y blueprint/pathway cuando exista evidencia.

5.  Validate — aplicar BR-EC01, cross-ref resolution y tenant scope; no rellenar datos críticos inventados.

6.  Dry-run — generar candidatos, conflicts y deterministic hashes sin persistir verdad final.

7.  Human review — resolver merges/splits/ambiguous history con Data Steward y owner académico.

8.  Promote — invocar APIs/application services EC-01 con migration context; nunca INSERT directo a tablas finales.

9.  Receipt — guardar por item source lineage, normalized payload hash, validation result, target IDs y promotion receipt.

10. Reconcile — comparar counts/hashes/relationships y event delivery.

11. Certify — UAT de muestras históricas, cross-tenant isolation y evidencia de rollback/compensation.

| **DQ rule**                                                   | **Severidad** | **Tratamiento**                                                     |
|---------------------------------------------------------------|---------------|---------------------------------------------------------------------|
| Duplicate program_code same tenant                            | BLOCKER       | Merge/split decision; no auto overwrite.                            |
| Published history without version evidence                    | HIGH          | Create migration-assessed version with explicit provenance/reason.  |
| Hours \<= 0                                                   | BLOCKER       | Reject/manual remediation.                                          |
| Module referenced by multiple programs with divergent content | HIGH          | Split definitions/versions based on evidence.                       |
| Unknown tenant/scope                                          | BLOCKER       | No promotion.                                                       |
| Missing policy refs for historical published version          | MEDIUM/HIGH   | Policy snapshot marked MIGRATED_LEGACY only if governance approves. |
| Cross-tenant reference                                        | BLOCKER       | Quarantine and investigate.                                         |

# 28. QA y estrategia de pruebas

| **Tipo**               | **Cobertura obligatoria**                                                  |
|------------------------|----------------------------------------------------------------------------|
| Unit Tests             | VOs, state transitions, policy decisions, hashes.                          |
| Domain Tests           | Aggregate invariants, publish preconditions, new-version semantics.        |
| Repository Tests       | Tenant-aware queries, unique partial indexes, @Version.                    |
| Flyway/DDL Tests       | Fresh install + upgrade + rollback strategy + constraints/triggers.        |
| Integration Tests      | PostgreSQL + adapters CT stubs/containers.                                 |
| Contract Tests         | OpenAPI + CT-01/02/05/06/12/15/18 contracts.                               |
| API Tests              | HTTP status, ProblemDetail, ETag, Idempotency-Key.                         |
| Event Contract Tests   | AsyncAPI schema compatibility, envelope, dedup.                            |
| Security Tests         | RBAC/ABAC/SoD/step-up, field access.                                       |
| Tenant Isolation Tests | Every repository/API/event projection; negative cross-tenant attempts.     |
| Concurrency Tests      | Two editors, two publishers, stale ETag, uniqueness race.                  |
| Idempotency Tests      | Same key same body, same key different body, crash after commit, replay.   |
| Resilience Tests       | Dependency timeouts, circuit open, broker outage, DB failover assumptions. |
| UNKNOWN_EFFECT Tests   | Remote create committed + timeout + reconcile.                             |
| Graph Tests            | Cycles, self edge, cross-version node/item, large graphs.                  |
| Performance Tests      | Portfolio search, version detail, validation, publish, bulk dry-run.       |
| Migration Tests        | Legacy dirty data, dry-run, deterministic promotion, receipts.             |
| E2E                    | Design→review→publish→EC-02 consume contract.                              |
| UAT                    | Institutional scenarios below.                                             |
| Accessibility Tests    | WCAG 2.2 AA, keyboard graph alternative, error focus.                      |
| AI Evals               | Grounding, hallucination containment, unsafe auto-action impossible.       |

## 28.1 Tests físicos que no pueden faltar

- INSERT ProgramVersion previous_version_id de otro ProgramDefinition → debe fallar FK.

- Dos ProgramVersion PUBLISHED simultáneas mismo program → unique partial debe fallar.

- UPDATE outcome hijo de PUBLISHED → trigger debe fallar.

- Credential requirement de V2 apuntando outcome V1 → FK scope debe fallar.

- Pathway edge entre nodos de distinta PathwayVersion → FK debe fallar.

- Prerequisite cycle A→B→C→A → trigger debe fallar.

- Published ProgramVersion content update directo SQL → trigger debe fallar.

- Same Idempotency-Key concurrente → una sola fila/efecto.

## 28.2 Matriz de pruebas obligatorias V1.1

| **Suite**          | **Pruebas adicionales no negociables**                                                                                     |
|--------------------|----------------------------------------------------------------------------------------------------------------------------|
| Tenant Isolation   | RLS sin tenant =\> 0 rows; tenant incorrecto =\> 0/denied; pool reuse no filtra contexto; cross-tenant FK sigue bloqueada. |
| Aggregate Revision | Mutar outcome/group/edge incrementa root version; concurrent child commands desde mismo ETag =\> uno 2xx y otro 412.       |
| State Machine      | Toda transición no listada falla en DB; non-DRAFT content update directo falla.                                            |
| Lineage            | Self previous/supersede, previous con versión mayor y supersede con versión menor son rechazados.                          |
| Graphs             | Group cycle; edge cycle; edge UPDATE válido no da falso positivo; update que crea ciclo falla.                             |
| Evidence           | PublicationReceipt UPDATE/DELETE falla; hash canonicalization determinista y versionada.                                   |
| Idempotency        | Crash con lease vigente, lease expirado reclaim, same key/different request_hash, concurrent acquisition.                  |
| Outbox             | 2 workers claim concurrentes sin duplicate ownership; lease expiry reclaim; UNKNOWN_EFFECT reconcile.                      |
| API                | Pagination bounds, sort allowlist, 202 OperationStatus, ProblemDetail reason codes, PATCH allowlist.                       |
| Security           | Threat Model negatives, SAST/SCA/secret/SBOM gates y runtime DB role sin BYPASSRLS.                                        |
| Deployment         | Expand/contract N/N-1 con app vieja y nueva durante rollout; rollback app sin rollback destructivo de DB.                  |

# 29. Golden Scenarios

| **GS**          | **Escenario**                        | **Precondición**                             | **Acción**                         | **Resultado esperado**                             | **Evidencia**           |
|-----------------|--------------------------------------|----------------------------------------------|------------------------------------|----------------------------------------------------|-------------------------|
| **GS-EC01-001** | Create first program                 | Authorized tenant/scope                      | Create ProgramDefinition           | 201 + unique code + audit                          | row + audit             |
| **GS-EC01-002** | Duplicate code                       | Existing same tenant code                    | Create duplicate                   | 409/DB UQ                                          | ProblemDetail           |
| **GS-EC01-003** | Same code other tenant               | Two tenants                                  | Create                             | Allowed isolated                                   | tenant tests            |
| **GS-EC01-004** | Create V1                            | Program exists                               | Create version                     | DRAFT V1                                           | row                     |
| **GS-EC01-005** | Clone published V1                   | V1 PUBLISHED                                 | Clone                              | DRAFT V2 linked                                    | lineage                 |
| **GS-EC01-006** | Previous from other program          | Two programs                                 | Force invalid FK                   | Rejected                                           | DB error test           |
| **GS-EC01-007** | Publish valid V1                     | APPROVED + policies available                | Publish                            | PUBLISHED + receipt + event                        | receipt/outbox          |
| **GS-EC01-008** | Concurrent publish                   | Two approved candidates                      | Publish simultaneously             | Only one wins                                      | unique/transaction logs |
| **GS-EC01-009** | Stale ETag                           | Draft changed by A                           | B patches old ETag                 | 412                                                | ProblemDetail           |
| **GS-EC01-010** | Edit published via API               | PUBLISHED                                    | PATCH                              | 409/422                                            | audit                   |
| **GS-EC01-011** | Edit published via SQL               | PUBLISHED                                    | UPDATE content                     | DB rejects                                         | trigger test            |
| **GS-EC01-012** | Add outcome                          | DRAFT                                        | POST outcome                       | Created                                            | row                     |
| **GS-EC01-013** | Duplicate outcome code               | DRAFT                                        | POST duplicate                     | Rejected                                           | UQ                      |
| **GS-EC01-014** | Module reuse                         | Published module version                     | Use in 2 programs                  | Both pin same id                                   | structure rows          |
| **GS-EC01-015** | New module version                   | LMV1 PUBLISHED                               | Clone/edit/publish LMV2            | LMV1 unchanged                                     | lineage                 |
| **GS-EC01-016** | Structure group cardinality invalid  | DRAFT                                        | max\<min                           | Rejected                                           | CHECK                   |
| **GS-EC01-017** | Cross-version group/item             | V1/V2                                        | Bind V2 item to V1 group           | Rejected                                           | FK                      |
| **GS-EC01-018** | Self prerequisite                    | Item A                                       | A→A                                | Rejected                                           | CHECK                   |
| **GS-EC01-019** | Prerequisite cycle                   | A→B→C                                        | Add C→A                            | Rejected                                           | trigger                 |
| **GS-EC01-020** | Valid DAG                            | A→B→C                                        | Validate                           | PASS                                               | validation report       |
| **GS-EC01-021** | Hours mismatch                       | Program 48, structure 36                     | Validate                           | WARN/FAIL per policy                               | reason code             |
| **GS-EC01-022** | Credit pair incomplete               | credits only                                 | Persist                            | Rejected                                           | CHECK                   |
| **GS-EC01-023** | Requirement external rule missing    | eligibility ref invalid                      | Publish                            | 422/503 fail-closed                                | validation evidence     |
| **GS-EC01-024** | Blueprint program completion         | Draft                                        | Add no target kind completion      | Valid                                              | row                     |
| **GS-EC01-025** | Blueprint typed target mismatch      | kind outcome but item target                 | Persist                            | Rejected                                           | CHECK                   |
| **GS-EC01-026** | Blueprint cross-version target       | Blueprint V2 outcome V1                      | Persist                            | Rejected                                           | FK                      |
| **GS-EC01-027** | Pathway valid                        | Nodes/edges acyclic                          | Publish                            | PUBLISHED                                          | receipt                 |
| **GS-EC01-028** | Pathway self edge                    | N1                                           | N1→N1                              | Rejected                                           | CHECK                   |
| **GS-EC01-029** | Pathway cycle                        | N1→N2→N3                                     | N3→N1                              | Rejected                                           | trigger                 |
| **GS-EC01-030** | Pathway external ref unavailable     | External node                                | Validate publish                   | Fail-closed/partial validation                     | report                  |
| **GS-EC01-031** | Workflow create timeout after commit | CT-06 committed                              | Submit review timeout              | UNKNOWN_EFFECT                                     | correlation/receipt     |
| **GS-EC01-032** | Reconcile workflow                   | Unknown effect                               | Query by idempotency/correlation   | Recovered existing case                            | reconcile log           |
| **GS-EC01-033** | CT-02 unavailable during editing     | Draft                                        | Open workspace                     | STALE/PARTIAL allowed                              | UI state                |
| **GS-EC01-034** | CT-02 unavailable during publish     | Approved                                     | Publish                            | 503; no state change                               | transaction evidence    |
| **GS-EC01-035** | Notification failure post publish    | Published                                    | CT-07 fails                        | Publish remains; retry notification                | outbox                  |
| **GS-EC01-036** | Broker outage                        | Publish                                      | Outbox dispatcher fails            | PUBLISHED + pending outbox                         | metrics                 |
| **GS-EC01-037** | Outbox recovery                      | Broker returns                               | Dispatch pending                   | Delivered once logically                           | inbox downstream        |
| **GS-EC01-038** | Duplicate event consumption          | Same msg twice                               | Consume workflow result            | One effect                                         | inbox                   |
| **GS-EC01-039** | Same idem same payload               | First publish success                        | Replay                             | Same receipt/result                                | idempotency row         |
| **GS-EC01-040** | Same idem diff payload               | Key reused                                   | Command                            | 409                                                | ProblemDetail           |
| **GS-EC01-041** | AI suggests outcomes                 | CT-12 available                              | Request                            | Suggestions only                                   | run_ref                 |
| **GS-EC01-042** | AI hallucinated fact                 | Ungrounded suggestion                        | Review                             | Rejected by human                                  | outcome audit           |
| **GS-EC01-043** | AI unavailable                       | Draft                                        | Request assist                     | UNAVAILABLE; manual editing works                  | UI test                 |
| **GS-EC01-044** | AI apply stale ETag                  | Suggestion from old draft                    | Apply                              | 412 + re-review                                    | conflict drawer         |
| **GS-EC01-045** | SoD violation                        | Designer is sole approver and policy forbids | Approve                            | 403/422                                            | audit                   |
| **GS-EC01-046** | Step-up missing                      | Publisher session low assurance              | Publish                            | 403 STEP_UP_REQUIRED                               | security log            |
| **GS-EC01-047** | Step-up satisfied                    | MFA elevated                                 | Publish                            | Allowed                                            | assurance audit         |
| **GS-EC01-048** | Cross-tenant GET                     | Tenant A id from B                           | GET                                | 404/403 no leak                                    | security test           |
| **GS-EC01-049** | Cross-tenant FK injection            | Direct SQL malformed                         | Insert                             | Rejected                                           | FK/PK                   |
| **GS-EC01-050** | Migration dry-run dirty              | Legacy duplicates                            | Dry-run                            | Conflicts, no final rows                           | CT-16 receipt           |
| **GS-EC01-051** | Migration promote valid              | Approved mappings                            | Promote                            | Domain-created facts                               | receipts                |
| **GS-EC01-052** | Migration retry                      | Same batch/item                              | Promote again                      | No duplicate                                       | idempotency             |
| **GS-EC01-053** | Version diff                         | V1/V2                                        | GET diff                           | Deterministic structured diff                      | hash pair               |
| **GS-EC01-054** | Impact partial                       | Downstream index unavailable                 | Simulate                           | PARTIAL not zero                                   | provenance              |
| **GS-EC01-055** | Retire ProgramDefinition             | Has published history                        | Retire                             | No deletion; history visible                       | audit                   |
| **GS-EC01-056** | Void published                       | Critical error + permission                  | Void                               | VOID event, no delete                              | receipt                 |
| **GS-EC01-057** | Void without reason                  | Published                                    | Void request                       | 422                                                | ProblemDetail           |
| **GS-EC01-058** | Receipt duplicate nullable semantics | Same program hash                            | Insert duplicate                   | Rejected by partial index                          | DB test                 |
| **GS-EC01-059** | Policy snapshot reconstruction       | Old publish                                  | Audit years later                  | Exact refs/hash resolvable                         | Evidence Pack           |
| **GS-EC01-060** | Localization overlay                 | Spanish canonical + English overlay          | View English                       | Same version id                                    | CT-08 contract          |
| **GS-EC01-061** | Mobile read stale                    | Offline cache                                | Open                               | STALE badge                                        | mobile test             |
| **GS-EC01-062** | Mobile publish attempt               | Mobile client                                | Call publish                       | Forbidden by client + server permission            | security test           |
| **GS-EC01-063** | Accessibility graph                  | Keyboard-only user                           | Edit pathway                       | Table alternative usable                           | a11y evidence           |
| **GS-EC01-064** | Operational vs business failure      | Validation 422                               | Dashboard                          | Not counted as availability outage                 | metrics                 |
| **GS-EC01-065** | Large graph                          | Max policy nodes                             | Validate                           | Within performance budget                          | perf report             |
| **GS-EC01-066** | Bulk concurrent edits                | Many designers                               | Patch different drafts             | No cross contamination                             | load test               |
| **GS-EC01-067** | Content hash deterministic           | Same snapshot ordering differs internally    | Hash                               | Same canonical hash                                | unit test               |
| **GS-EC01-068** | Published child delete SQL           | Published V1                                 | DELETE structure item              | DB rejects                                         | trigger                 |
| **GS-EC01-069** | Module published child edit SQL      | LMV PUBLISHED                                | UPDATE outcome                     | DB rejects                                         | trigger                 |
| **GS-EC01-070** | Pathway published edge edit SQL      | PWV PUBLISHED                                | UPDATE edge                        | DB rejects                                         | trigger                 |
| **GS-EC01-071** | No participant PII                   | Portfolio operations                         | Inspect DB/logs                    | No participant personal fields                     | privacy review          |
| **GS-EC01-072** | Finance fields absent                | Inspect schema                               | Search payment/price columns       | None authoritative                                 | architecture review     |
| **GS-EC01-073** | RLS missing tenant                   | Connection without tenant context            | SELECT program_definition          | 0 rows / fail-closed; no leak                      | DB integration test     |
| **GS-EC01-074** | RLS wrong tenant                     | Tenant B context with A IDs                  | SELECT/UPDATE                      | No A row visible; write blocked                    | security test           |
| **GS-EC01-075** | Child concurrent ETag                | A/B start ETag 7                             | A edits outcome; B edits structure | A success ETag 8; B 412                            | concurrency trace       |
| **GS-EC01-076** | Sibling group ordering               | Two parent groups                            | Each creates child sequence 1      | Allowed in different parents                       | DB test                 |
| **GS-EC01-077** | Group hierarchy cycle                | A parent B, B parent C                       | Set C parent A                     | Rejected EC01_STRUCTURE_GROUP_CYCLE                | trigger test            |
| **GS-EC01-078** | Dependency UPDATE valid              | Existing edge A→B                            | Move to A→C without cycle          | Accepted; old edge excluded                        | trigger test            |
| **GS-EC01-079** | Dependency UPDATE cycle              | Path C→A exists                              | Update edge to A→C                 | Rejected                                           | trigger test            |
| **GS-EC01-080** | Program lineage self                 | Draft V2                                     | previous_version_id=V2             | Rejected                                           | trigger test            |
| **GS-EC01-081** | Program lineage reverse              | V2 points previous V3                        | Save                               | Rejected                                           | trigger test            |
| **GS-EC01-082** | Future scheduled version             | V2 PUBLISHED, V3 APPROVED valid_from future  | Schedule V3                        | V3 SCHEDULED; V2 remains PUBLISHED                 | receipt + states        |
| **GS-EC01-083** | Scheduled content edit               | V3 SCHEDULED                                 | UPDATE title                       | DB rejects                                         | trigger test            |
| **GS-EC01-084** | Receipt tamper                       | Existing receipt                             | UPDATE hash                        | DB rejects append-only                             | DB test                 |
| **GS-EC01-085** | Idempotency crash recovery           | IN_PROGRESS lease expired                    | Second worker reclaim              | One owner; attempt_count++                         | DB trace                |
| **GS-EC01-086** | Outbox two workers                   | 100 PENDING events                           | Workers claim concurrently         | Disjoint claimed sets                              | worker test             |
| **GS-EC01-087** | Outbox abandoned lease               | IN_FLIGHT lease expired                      | Reclaim                            | Safe reclaim, no business-row mutation             | runbook evidence        |
| **GS-EC01-088** | Async workflow 202                   | CT-06 slow/async                             | Submit review                      | 202 operationId; poll to SUCCEEDED                 | contract test           |
| **GS-EC01-089** | Async unknown effect                 | Timeout after remote accept                  | Poll/reconcile                     | UNKNOWN_EFFECT then reconciled; no blind duplicate | receipt/audit           |
| **GS-EC01-090** | Business key after history           | Program with published V1                    | Change program_code                | DB rejects                                         | trigger test            |
| **GS-EC01-091** | N/N-1 rollout                        | Old+new pods during migration                | Deploy expand phase                | Both versions operate                              | release evidence        |
| **GS-EC01-092** | pageSize abuse                       | GET pageSize=100000                          | Request                            | Rejected bounded error; no huge query              | API/perf test           |

# 30. UAT institucional

| **UAT**    | **Escenario**                | **Criterio de aceptación**                                                                                            |
|------------|------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| **UAT-01** | Crear programa y V1 completa | Owner puede construir metadata/outcomes/estructura/requisitos sin campos de ejecución.                                |
| **UAT-02** | Reusar módulo                | Una ModuleVersion publicada se usa en dos programas sin duplicar ni mutar.                                            |
| **UAT-03** | Nueva versión                | V2 clona V1 y diff muestra exactamente cambios.                                                                       |
| **UAT-04** | Publish governance           | Review/approval/step-up/receipt/outbox visibles.                                                                      |
| **UAT-05** | Inmutabilidad                | Usuario y DBA test no pueden cambiar PUBLISHED content.                                                               |
| **UAT-06** | Estructura inválida          | Ciclos/cardinalidades/horas se detectan con reason codes accionables.                                                 |
| **UAT-07** | Credential blueprint         | Se define credencial sin emitir certificado.                                                                          |
| **UAT-08** | Pathway stackable            | Ruta se publica y queda consumible por EC-10 version-pinned.                                                          |
| **UAT-09** | Tenant isolation             | Mismo code en tenants distintos aislado; acceso cruzado denegado.                                                     |
| **UAT-10** | Concurrencia                 | ETag evita sobreescritura y publish race no crea dos vigentes.                                                        |
| **UAT-11** | Dependency unavailable       | UI diferencia STALE/PARTIAL/UNAVAILABLE y publish fail-closed.                                                        |
| **UAT-12** | Workflow timeout             | UNKNOWN_EFFECT se reconcilia sin duplicar workflow.                                                                   |
| **UAT-13** | Migration                    | Legacy se promueve por domain APIs con lineage y dry-run.                                                             |
| **UAT-14** | Auditoría                    | Auditor reconstruye versión publicada con policy snapshot/hash/evidence.                                              |
| **UAT-15** | IA asistiva                  | Suggestion muestra provenance y no puede publicar.                                                                    |
| **UAT-16** | Accesibilidad                | Structure/pathway completos operables con teclado y alternativa no gráfica.                                           |
| **UAT-17** | Mobile boundary              | Mobile permite lectura/review definida y bloquea authoring crítico.                                                   |
| **UAT-18** | EC-02 contract               | EC-02 solo puede crear Edition desde ProgramVersion PUBLISHED válida.                                                 |
| **UAT-19** | EC-08 contract               | EC-08 consume blueprint publicado sin duplicar definición.                                                            |
| **UAT-20** | Historia                     | Supersede/void conserva lineage completo y nada se hard-deletea.                                                      |
| **UAT-21** | RLS defense-in-depth         | Un usuario/bug de repository sin filtro tenant no puede ver ni modificar datos de otro tenant.                        |
| **UAT-22** | Aggregate revision           | Una edición de cualquier hijo cambia el ETag del root y bloquea un comando concurrente stale.                         |
| **UAT-23** | Future scheduled version     | Se programa V3 futura sin retirar V2 vigente y sin permitir editar V3 después de schedule.                            |
| **UAT-24** | Receipt integrity            | Auditor prueba que receipt no puede alterarse por SQL de runtime.                                                     |
| **UAT-25** | Idempotency recovery         | Crash simulado no deja IN_PROGRESS perpetuo ni genera duplicados.                                                     |
| **UAT-26** | Outbox multi-pod             | Dos dispatchers procesan un backlog sin ownership duplicado.                                                          |
| **UAT-27** | OperationStatus              | Una operación 202 puede seguirse y reconciliarse hasta terminal/UNKNOWN_EFFECT.                                       |
| **UAT-28** | Secure SDLC                  | Pipeline produce SBOM y bloquea un hallazgo Critical simulado.                                                        |
| **UAT-29** | Zero-downtime                | Rollout N/N-1 mantiene lectura/escritura compatible durante expand/contract.                                          |
| **UAT-30** | Developer bootstrap          | Un Senior nuevo levanta módulo, PostgreSQL Testcontainers y dataset mínimo siguiendo la guía sin conocimiento tribal. |

# 31. Gates G1-G10

| **Gate**                            | **Qué valida**                                              | **Evidencia**                         | **Criterio**                             |
|-------------------------------------|-------------------------------------------------------------|---------------------------------------|------------------------------------------|
| G1 — Arquitectura y bounded context | AM/CT/EC-00 traceability; DA/ADR; no ownership duplicado    | Architecture review + context diagram | PASS solo sin contradicción no resuelta. |
| G2 — Datos/constraints              | DER, 23 tablas, tenant-aware PK/FK, checks/triggers, Flyway | DDL tests + schema review             | PASS si DB impide invariantes críticas.  |
| G3 — Backend                        | Aggregates, ports, services, transactions, ETag/idempotency | Unit/domain/integration coverage      | PASS con critical paths verdes.          |
| G4 — API/Event contracts            | OpenAPI/AsyncAPI, ProblemDetail, compatibility              | Contract tests                        | PASS sin breaking drift.                 |
| G5 — Frontend/Mobile                | Workspaces, states, a11y, mobile boundary                   | E2E + a11y evidence                   | PASS sin empty/unavailable ambiguity.    |
| G6 — Seguridad/auditoría            | RBAC/ABAC/SoD/step-up/privacy/evidence                      | Threat model + security tests         | PASS sin high/critical open.             |
| G7 — Integraciones/resiliencia      | Timeout/retry/circuit/reconciliation/unknown effect         | Chaos/resilience tests                | PASS con safe recovery.                  |
| G8 — QA/UAT                         | GS/UAT coverage                                             | Test report + signed UAT              | PASS institutional acceptance.           |
| G9 — Migración/operaciones          | CT-16, runbooks, observability, backups assumptions         | Migration rehearsal + ops drill       | PASS recoverable/reconcilable.           |
| G10 — Release/certificación         | Engineering Pack completo, no drift, release checklist      | Evidence Pack                         | PASS para producción.                    |

# 32. Definition of Ready / Definition of Done

## 32.1 Definition of Ready

- User story/use case mapea a UC/BR/DA aplicables.

- Source of Truth y owner de datos están identificados.

- API/event contract draft y error semantics definidos.

- Campos/policies no hardcodeables tienen CT-02 ref.

- Threat/privacy classification y permisos preliminares.

- DB migration impact definido; si cambia schema, constraint design incluido.

- Golden Scenarios seleccionados para acceptance.

- Dependency behavior STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT definido.

## 32.2 Definition of Done

- Código backend/frontend/mobile aplicable merged con review.

- Flyway probado fresh + upgrade; schema drift check PASS.

- OpenAPI/AsyncAPI generado/validado y contract tests PASS.

- Unit/domain/repository/integration/security/tenant/concurrency/idempotency tests PASS.

- Frontend cubre loading/empty/error/stale/partial/unavailable y a11y.

- Observability dashboards/alerts/runbooks desplegados.

- ADRs cerrados/actualizados; Word y Git sin contradicción.

- Golden Scenarios/UAT aplicables con evidencia.

- No high/critical security findings abiertos.

- Evidence Pack G1-G10 completo y release checklist firmado.

# 33. Runbooks

| **Runbook**     | **Trigger**                          | **Procedimiento**                                                                                                                                                                      |
|-----------------|--------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **RB-EC01-001** | Outbox backlog                       | outbox_pending/age alert — Ver broker/CT-09 → no tocar business rows → replay dispatcher por event_id → confirmar downstream dedup → cerrar con evidence.                              |
| **RB-EC01-002** | UNKNOWN_EFFECT workflow              | external effect alert/correlation — Consultar CT-06 por correlation/idempotency → si existe, attach ref; si no, safe retry → nunca crear segundo case ciego.                           |
| **RB-EC01-003** | Concurrent publish conflict          | 409/unique violation — Recargar PUBLISHED actual → comparar candidate → decidir retry/new version; no deshabilitar unique index.                                                       |
| **RB-EC01-004** | Policy service unavailable           | 503 spike — Abrir circuit → mantener editing read/cached con STALE → bloquear publish → restablecer y revalidar.                                                                       |
| **RB-EC01-005** | Invalid published content discovered | Academic incident — No UPDATE → freeze new editions if needed → DesignChangeRequest → new version or VOID per policy → downstream notification/event.                                  |
| **RB-EC01-006** | Cross-tenant anomaly                 | Security alert — Bloquear path → preserve evidence → inspect query/context → tenant isolation tests → incident process CT-10.                                                          |
| **RB-EC01-007** | Migration mismatch                   | Reconciliation discrepancy — Stop promotion batch → compare lineage/receipt → compensate via domain commands, not deletes → rerun dry-run.                                             |
| **RB-EC01-008** | Graph performance degradation        | Validation latency alert — Inspect V/E size → query plan/index → policy limit → no bypass cycle checks.                                                                                |
| **RB-EC01-009** | Redis outage                         | Cache unavailable — Fallback to PostgreSQL/CT reads → rate protect → no data loss; do not relax publish validation.                                                                    |
| **RB-EC01-010** | AI provider/CT-12 outage             | AI request failures — Disable assist UI gracefully → manual editing continues → no cached suggestion represented as fresh.                                                             |
| **RB-EC01-011** | Receipt/hash mismatch                | Audit integrity alert — Quarantine publication operation → compare canonicalization/build version → no edit receipt → security/architecture review.                                    |
| **RB-EC01-012** | Rollback after deployment            | Release regression — Prefer forward Flyway fix; app rollback only if schema compatible → verify outbox/inbox and publish invariants before traffic restore.                            |
| **RB-EC01-013** | RLS/tenant context incident          | Disable affected path if leak suspected → preserve evidence → verify runtime role/SET LOCAL/pool → run tenant isolation suite → rotate credentials if needed → CT-10 incident closure. |
| **RB-EC01-014** | Idempotency stale lease              | Lock key → verify no confirmed effect/receipt → reclaim only after lease expiry → increment attempt → reconcile downstream before retry.                                               |
| **RB-EC01-015** | Outbox abandoned IN_FLIGHT           | Find expired leases → inspect broker by event/correlation → reconcile → reclaim or mark delivered; never re-create business event.                                                     |
| **RB-EC01-016** | Scheduled activation failure         | Do not partially supersede → inspect transaction/outbox → keep old PUBLISHED authoritative → retry atomic activation only after invariants pass.                                       |
| **RB-EC01-017** | RLS migration blocked                | Use approved migrator role/maintenance procedure; never grant BYPASSRLS to HTTP runtime as workaround.                                                                                 |
| **RB-EC01-018** | N/N-1 deployment regression          | Stop rollout → keep expand schema → rollback application only if compatibility proven → roll forward DB fix; no destructive down migration.                                            |

# 34. ADRs y decisiones abiertas

| **ADR**          | **Tema**                                  | **Estado**            | **Decisión/pendiente**                                                                                                            |
|------------------|-------------------------------------------|-----------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| **ADR-EC01-001** | ProgramDefinition/ProgramVersion split    | Adopted               | Identity stable + immutable snapshots.                                                                                            |
| **ADR-EC01-002** | LearningModule Definition/Version         | Adopted               | Reusable module with pinning.                                                                                                     |
| **ADR-EC01-003** | PUBLISHED actual + SCHEDULED futuro       | Adopted V1.1          | Una PUBLISHED vigente; futuras versiones comprometidas usan SCHEDULED immutable hasta activación atómica.                         |
| **ADR-EC01-004** | No cross-context FK                       | Adopted               | Ports/contracts/EXT REF.                                                                                                          |
| **ADR-EC01-005** | PostgreSQL authoritative                  | Adopted               | Mongo derived; Redis cache only.                                                                                                  |
| **ADR-EC01-006** | Credential blueprint owned EC-01          | Adopted               | Award/issuance owned EC-08.                                                                                                       |
| **ADR-EC01-007** | Pathway definition owned EC-01            | Adopted               | Progress owned EC-10.                                                                                                             |
| **ADR-EC01-008** | Eligibility rule ownership CT-15          | Adopted               | EC-01 binds refs only.                                                                                                            |
| **ADR-EC01-009** | Version immutability at DB                | Adopted               | Triggers protect roots and children.                                                                                              |
| **ADR-EC01-010** | Graph cycle defense                       | Adopted               | Domain validation + DB trigger.                                                                                                   |
| **ADR-EC01-011** | Publish atomic receipt/outbox             | Adopted               | One local transaction.                                                                                                            |
| **ADR-EC01-012** | Durable idempotency PostgreSQL            | Adopted               | Redis insufficient.                                                                                                               |
| **ADR-EC01-013** | Mobile limited authoring                  | Adopted               | Critical design reserved Web.                                                                                                     |
| **ADR-EC01-014** | AI via CT-12 only                         | Adopted               | No provider SDK local.                                                                                                            |
| **ADR-EC01-015** | Localized overlays via CT-08              | Adopted               | Language does not create academic version.                                                                                        |
| **ADR-EC01-016** | Unicidad null-safe portable               | Adopted               | Partial expression indexes prevent duplicates with or without outcome_id without depender de NULLS NOT DISTINCT.                  |
| **ADR-EC01-017** | ProgramVersion published validity overlap | Closed — Adopted V1.1 | SCHEDULED resuelve coexistencia futura; PUBLISHED sigue siendo la versión vigente. valid_from es obligatorio al schedule/publish. |
| **ADR-EC01-018** | External credential registry authority    | Open with CT-18/EC-08 | Define contract before enabling EXTERNAL_CREDENTIAL nodes in production.                                                          |
| **ADR-EC01-019** | PostgreSQL RLS defense-in-depth           | Adopted V1.1          | ENABLE+FORCE RLS + runtime role sin ownership/BYPASSRLS.                                                                          |
| **ADR-EC01-020** | Aggregate revision on child mutation      | Adopted V1.1          | Root version/ETag representa aggregate completo; child trigger bump.                                                              |
| **ADR-EC01-021** | CredentialBlueprint publication           | Adopted V1.1          | Blueprint forma parte del ProgramVersion snapshot; no publication receipt independiente.                                          |
| **ADR-EC01-022** | Idempotency/outbox leases                 | Adopted V1.1          | Lease/owner/recovery + SKIP LOCKED para multi-instancia.                                                                          |
| **ADR-EC01-023** | API async operation status                | Adopted V1.1          | 202 siempre devuelve operationId y contrato de reconciliación.                                                                    |
| **ADR-EC01-024** | Frontend contract generation              | Adopted V1.1          | OpenAPI genera client/DTO; no duplicación manual.                                                                                 |
| **ADR-EC01-025** | Zero-downtime DB evolution                | Adopted V1.1          | Expand/contract N/N-1; rollback DB destructivo prohibido como operación normal.                                                   |

# 35. Engineering Pack

| **Ruta Git mínima**                              | **Contenido**                             |
|--------------------------------------------------|-------------------------------------------|
| **/docs/ec01/EC-01.docx**                        | Especificación maestra publicada.         |
| **/architecture/ec01/context.puml**              | Context diagram.                          |
| **/architecture/ec01/domain.puml**               | Domain/aggregate diagram.                 |
| **/architecture/ec01/physical-erd.puml**         | DER físico.                               |
| **/adr/ec01/ADR-EC01-\*.md**                     | ADRs aceptados/abiertos.                  |
| **/db/migration/V\*\_ec01\_\*.sql**              | DDL Flyway + triggers/indexes.            |
| **/openapi/ec01-portfolio-v1.yaml**              | REST contract.                            |
| **/asyncapi/ec01-events-v1.yaml**                | Event contracts.                          |
| **/backend/ec01/\*\***                           | Domain/application/adapters.              |
| **/frontend/src/features/ec-portfolio/\*\***     | Workspaces/components.                    |
| **/mobile/src/features/ec-portfolio-read/\*\***  | Read/review subset si aplica.             |
| **/tests/ec01/unit/\*\***                        | Unit/domain.                              |
| **/tests/ec01/integration/\*\***                 | DB/integration.                           |
| **/tests/ec01/contract/\*\***                    | OpenAPI/AsyncAPI/CT contracts.            |
| **/tests/ec01/security/\*\***                    | Tenant/RBAC/ABAC/SoD.                     |
| **/tests/ec01/concurrency/\*\***                 | ETag/publish race.                        |
| **/tests/ec01/resilience/\*\***                  | Timeout/unknown effect.                   |
| **/performance/ec01/\*\***                       | Load/perf plans/results.                  |
| **/observability/ec01/\*\***                     | Dashboards/alerts/SLI.                    |
| **/runbooks/ec01/\*\***                          | RB-EC01-\*.                               |
| **/migration/ec01/\*\***                         | Mappings/dry-runs/reconciliation.         |
| **/evidence/ec01/gates/\*\***                    | Evidence Pack G1-G10.                     |
| **/security/ec01/threat-model.md**               | Threat model y mitigaciones V1.1.         |
| **/security/ec01/sbom/**                         | SBOM por release.                         |
| **/db/migration/ec01/README-expand-contract.md** | Reglas N/N-1 y secuencia expand/contract. |
| **/tests/ec01/tenant-rls/\*\***                  | RLS/pool/role isolation tests.            |
| **/tests/ec01/aggregate-revision/\*\***          | Child mutation + ETag tests.              |
| **/tests/ec01/idempotency-recovery/\*\***        | Lease/reclaim/crash tests.                |
| **/tests/ec01/outbox-worker/\*\***               | SKIP LOCKED/lease/reclaim tests.          |
| **/frontend/src/generated/ec01/\*\***            | Client/DTO generado desde OpenAPI.        |
| **/dev/ec01/README.md**                          | Bootstrap local y dataset mínimo.         |

## 35.1 Zero-downtime Flyway — expand/contract N/N-1

| **Fase**         | **Acción**                                                                                                                                           | **Prohibido**                                             |
|------------------|------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------|
| Expand           | Agregar tablas/columnas nullable/default compatible, índices CONCURRENTLY cuando aplique, backfill gobernado, dual-read/write temporal si necesario. | DROP/rename inmediato o NOT NULL sin backfill compatible. |
| Rollout N/N-1    | Desplegar nueva app mientras versión anterior sigue compatible; observar SLO/errores/contracts.                                                      | Asumir que todos los pods cambian instantáneamente.       |
| Migrate behavior | Activar feature flag/uso de nueva columna solo tras expand y backfill certificados.                                                                  | Cambiar semántica antes de datos/consumers listos.        |
| Contract         | En release posterior retirar compatibilidad antigua después de confirmar cero consumidores N-1.                                                      | Down migration destructiva como rollback rutinario.       |

## 35.2 Developer bootstrap reproducible

El repositorio debe incluir README ejecutable que permita a un Senior nuevo levantar EC-01 sin credenciales productivas ni conocimiento tribal: JDK 21, build tool definido por Core Platform, PostgreSQL mediante Testcontainers/Docker, migraciones Flyway, fixtures mínimos multi-tenant, mocks/contracts CT y Frontend apuntando a API local. Los comandos exactos se fijan en Git y CI debe ejecutar el mismo camino básico.

| **Dataset mínimo** | **Contenido**                                                                    |
|--------------------|----------------------------------------------------------------------------------|
| Tenant A           | 1 ProgramDefinition; V1 PUBLISHED; V2 DRAFT; módulos/outcomes/structure/pathway. |
| Tenant B           | Mismos business codes que A para probar aislamiento.                             |
| Concurrency        | Dos usuarios/ETag iguales para pruebas 412.                                      |
| Graphs             | Grafo válido + fixture de ciclo intencional en test setup.                       |
| Async              | Outbox pending, expired lease e idempotency stale lease.                         |

# 36. Guía secuencial Backend

| **Paso** | **Implementación**                                                                                                                 |
|----------|------------------------------------------------------------------------------------------------------------------------------------|
| Paso 1   | Crear módulo Spring Modulith ec.portfolio y definir API pública; verificar Modulith ApplicationModules sin ciclos.                 |
| Paso 2   | Implementar TenantId, IDs, VersionNumber, ContentHash y reason codes como VOs.                                                     |
| Paso 3   | Implementar ProgramDefinition y ProgramVersion aggregates sin dependencias JPA.                                                    |
| Paso 4   | Implementar LearningModuleDefinition/Version y PathwayDefinition/Version.                                                          |
| Paso 5   | Implementar entities hijas: outcomes, structure, requirements, credential blueprints, nodes/edges.                                 |
| Paso 6   | Implementar Domain Policies de publication, structure, material change y pathway.                                                  |
| Paso 7   | Implementar repositories ports; consultas siempre incluyen tenant.                                                                 |
| Paso 8   | Crear Flyway schema/DDL exactamente con constraints, scope FKs, indexes y triggers; tests con Testcontainers PostgreSQL.           |
| Paso 9   | Implementar JPA mappings con @Version en roots mutables y sin cascades que permitan borrar historia publicada.                     |
| Paso 10  | Implementar canonical snapshot serializer y content hash determinista.                                                             |
| Paso 11  | Implementar ValidationService y graph validators; mapear failures a reason codes.                                                  |
| Paso 12  | Implementar ports CT-01/02/05/06/08/10/12/15/18 según necesidad, con timeouts y resilience policies.                               |
| Paso 13  | Implementar create/edit/clone application commands con authorization context y idempotency.                                        |
| Paso 14  | Implementar submit review y workflow reconciliation; modelar UNKNOWN_EFFECT.                                                       |
| Paso 15  | Implementar approve decision consumer con inbox dedup y review_snapshot_hash verification.                                         |
| Paso 16  | Implementar publish transaction: lock/revalidate → supersede previous → publish candidate → receipt → outbox → idempotency result. |
| Paso 17  | Implementar outbox dispatcher y delivery metrics; no publicar directamente desde aggregate.                                        |
| Paso 18  | Implementar REST controllers delgados y DTO mapping; no exponer entities.                                                          |
| Paso 19  | Implementar RFC ProblemDetail centralizado con reason codes estables.                                                              |
| Paso 20  | Implementar ETag response/If-Match parsing y 412 semantics.                                                                        |
| Paso 21  | Implementar query projections/search/diff/impact; cache solo derivado.                                                             |
| Paso 22  | Implementar AI assist port CT-12 y provenance; apply suggestion pasa por command normal.                                           |
| Paso 23  | Implementar audit/evidence hooks y correlation propagation.                                                                        |
| Paso 24  | Completar contract/security/concurrency/idempotency/resilience/performance tests.                                                  |
| Paso 25  | Ejecutar Gates G1-G10 y congelar OpenAPI/AsyncAPI/Flyway hashes para release.                                                      |

## 36.1 Secuencia V1.1 adicional — puntos que no puede omitir Backend

| **Paso V1.1** | **Acción verificable**                                                                                                   |
|---------------|--------------------------------------------------------------------------------------------------------------------------|
| B26           | Implementar TenantDbContext que ejecute SET LOCAL peopleu.tenant_id por transacción y tests de pool reuse.               |
| B27           | Crear roles DB separados y test/assert de runtime sin ownership/BYPASSRLS.                                               |
| B28           | Aplicar Aggregate Revision Contract a cada child command y mapear 412 estable.                                           |
| B29           | Implementar state transition guards y lineage tests en Testcontainers PostgreSQL real.                                   |
| B30           | Implementar SCHEDULED activation transaction: current PUBLISHED→SUPERSEDED + candidate→PUBLISHED + receipt/outbox/audit. |
| B31           | Implementar idempotency lease/recovery y same-key/different-request_hash conflict.                                       |
| B32           | Implementar outbox claim/reclaim SKIP LOCKED con dos workers concurrentes en test.                                       |
| B33           | Generar OpenAPI/AsyncAPI y ejecutar breaking-change check en CI.                                                         |
| B34           | Añadir Threat Model controls, SAST/SCA/SBOM/secret/container gates.                                                      |
| B35           | Probar expand/contract N/N-1 en entorno de integración antes de release.                                                 |

# 37. Guía secuencial Frontend

| **Paso** | **Implementación**                                                                                                            |
|----------|-------------------------------------------------------------------------------------------------------------------------------|
| Paso 1   | Crear feature module ec-portfolio con route tree y permission guards.                                                         |
| Paso 2   | Generar API client/DTOs desde OpenAPI; prohibir tipos duplicados manuales.                                                    |
| Paso 3   | Definir query keys incluyendo tenant/scope implícito, program/version y freshness.                                            |
| Paso 4   | Construir PortfolioStudio shell con filtros persistibles en URL.                                                              |
| Paso 5   | Construir ProgramDesignWorkspace y tabs Overview/Outcomes/Competencies/Structure/Requirements/Credentials/Validation/History. |
| Paso 6   | Implementar forms con schema validation cliente alineada, sin reemplazar server domain validation.                            |
| Paso 7   | Capturar ETag en queries y enviarlo en mutations; tratar 412 con Conflict Drawer.                                             |
| Paso 8   | Implementar Structure Builder con keyboard-accessible table alternative y graph visualization.                                |
| Paso 9   | Implementar Learning Module Library con version timeline y usage status.                                                      |
| Paso 10  | Implementar Credential Blueprint Desk con typed requirement builder.                                                          |
| Paso 11  | Implementar Pathway Designer con graph + accessible table.                                                                    |
| Paso 12  | Implementar validation issue panel con severity/reason/path/fix suggestion.                                                   |
| Paso 13  | Implementar diff viewer semántico, no JSON raw.                                                                               |
| Paso 14  | Implementar Review Center consumiendo workflow state y review snapshot hash.                                                  |
| Paso 15  | Implementar Publish confirmation con impact summary, step-up handoff y idempotency key estable por intento lógico.            |
| Paso 16  | Implementar explicit states NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.                                            |
| Paso 17  | Integrar CT-08 localización sin duplicar ProgramVersion.                                                                      |
| Paso 18  | Integrar AI Assist drawer con grounding/provenance y explicit Apply/Reject.                                                   |
| Paso 19  | Implementar accessibility: focus management, error summary, landmarks, no-color-only, graph alternative.                      |
| Paso 20  | Implementar component/unit tests + MSW contract mocks + E2E critical journeys.                                                |
| Paso 21  | Instrumentar web-vitals/business telemetry sin PII y completar G5/G6/G8.                                                      |

## 37.1 Secuencia V1.1 adicional — puntos que no puede omitir Frontend

| **Paso V1.1** | **Acción verificable**                                                                                   |
|---------------|----------------------------------------------------------------------------------------------------------|
| F16           | Generar client/DTO desde OpenAPI y prohibir interfaces duplicadas en feature modules.                    |
| F17           | Persistir ETag por aggregate y enviarlo en todo child command.                                           |
| F18           | Implementar Conflict Drawer de 412 con reload/diff/reapply; sin auto-retry.                              |
| F19           | Implementar paginator/filter model bounded y sort allowlist.                                             |
| F20           | Implementar OperationStatus polling/backoff para 202 y UNKNOWN_EFFECT.                                   |
| F21           | Modelar explícitamente NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT en componentes compartidos. |
| F22           | Agregar accessibility tests keyboard/focus/graph table alternative.                                      |
| F23           | Agregar MSW/contract fixtures generadas desde OpenAPI y E2E de publish/step-up/concurrency.              |

# 38. Matriz de permisos

| **Operación**             | **Permission**            | **Viewer** | **Manager** | **Designer** | **Cred.Des.** | **Approver** | **Publisher** | **Auditor** | **Ops** |
|---------------------------|---------------------------|------------|-------------|--------------|---------------|--------------|---------------|-------------|---------|
| View portfolio            | VIEW                      | ✓          | ✓           | ✓            | ✓             | ✓            | ✓             | ✓           | ✓       |
| Create program            | CREATE_PROGRAM            | —          | ✓           | ✓            | —             | —            | —             | —           | —       |
| Edit program draft        | EDIT_PROGRAM              | —          | ✓           | ✓            | —             | —            | —             | —           | —       |
| Edit structure            | EDIT_STRUCTURE            | —          | —           | ✓            | —             | —            | —             | —           | —       |
| Edit credential blueprint | EDIT_CREDENTIAL_BLUEPRINT | —          | —           | ✓            | ✓             | —            | —             | —           | —       |
| Edit pathway              | EDIT_PATHWAY              | —          | —           | ✓            | —             | —            | —             | —           | —       |
| Submit review             | SUBMIT_REVIEW             | —          | ✓           | ✓            | ✓             | —            | —             | —           | —       |
| Approve                   | APPROVE                   | —          | —           | —            | —             | ✓            | —             | —           | —       |
| Publish                   | PUBLISH                   | —          | —           | —            | —             | —            | ✓\*           | —           | —       |
| Supersede/Void            | GOVERN_VERSION            | —          | —           | —            | —             | —            | ✓\*           | —           | —       |
| Read audit/receipts       | AUDIT_READ                | —          | ✓           | ✓            | ✓             | ✓            | ✓             | ✓           | ✓       |
| Reconcile integration     | OPS_RECONCILE             | —          | —           | —            | —             | —            | —             | —           | ✓       |

\* Publish/Supersede/Void exige además ABAC scope y step-up; SoD puede impedir que el mismo actor publique su propio cambio aunque tenga role.

# 39. Contratos DTO Frontend

## 39.1 Reglas generales

- IDs como string opaque UUID; Frontend no infiere ownership por formato.

- Money/payment no aparece en EC-01 DTOs.

- Toda response mutable incluye etag o header ETag consumible.

- Refs externas se representan con id + resolutionStatus/asOf/displaySnapshot opcional, nunca como objeto master editable.

- Estado de dependencia usa enum AVAILABLE/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT según aplique.

- ProblemDetail incluye type/title/status/detail/instance/reasonCode/correlationId/fieldErrors y remediationHint opcional.

## 39.2 TypeScript orientativo

export type DependencyState =

\| 'AVAILABLE' \| 'STALE' \| 'PARTIAL' \| 'UNAVAILABLE' \| 'UNKNOWN_EFFECT';

export interface ProgramVersionSummaryDto {

id: string;

programId: string;

versionNo: number;

officialName: string;

state: 'DRAFT'\|'IN_REVIEW'\|'APPROVED'\|'PUBLISHED'\|'SUPERSEDED'\|'VOID';

academicHours: number;

credits?: { schemeCode: string; value: number };

contentHash?: string;

etag: string;

validation?: { status: 'PASS'\|'WARN'\|'FAIL'; issueCount: number };

}

export interface ValidationIssueDto {

reasonCode: string;

severity: 'INFO'\|'WARN'\|'ERROR'\|'BLOCKER';

path: string;

messageKey: string;

evidenceRefs?: string\[\];

dependencyState?: DependencyState;

}

export interface ProblemDetailsDto {

type: string;

title: string;

status: number;

detail?: string;

reasonCode: string;

correlationId: string;

fieldErrors?: Array\<{ path: string; reasonCode: string; messageKey: string }\>;

}

## 39.3 Mutation workflow Frontend

12. Leer aggregate y conservar ETag.

13. Construir mutation DTO sin tenant_id libre.

14. Generar/reutilizar Idempotency-Key para un intento lógico sensible.

15. Enviar If-Match con ETag actual.

16. Si 2xx, invalidar query keys del aggregate y related summaries.

17. Si 412, no reintentar automáticamente: abrir diff/conflict UX.

18. Si 409/422, mostrar business reason y conservar inputs cuando sea seguro.

19. Si 503, distinguir UNAVAILABLE y ofrecer retry solo cuando command sea idempotente y no exista UNKNOWN_EFFECT.

20. Para publish, si response ambiguo/no llega, consultar operation status/receipt antes de repetir.

# 40. Checklist de release y certificación final

| **Área**       | **Checklist**                                                                                         |
|----------------|-------------------------------------------------------------------------------------------------------|
| Arquitectura   | Bounded Context/Source of Truth consistente con EC-00 V1.1 y CT-01…CT-18.                             |
| Arquitectura   | DA/ADR sin contradicciones silenciosas; abiertos tienen owner/decision date.                          |
| Datos          | Todas las tablas tenant-aware; no FK cross-context.                                                   |
| Datos          | Previous/superseded FKs same-definition probadas.                                                     |
| Datos          | Published roots/hijos inmutables por DB.                                                              |
| Datos          | Credential requirements typed + same ProgramVersion.                                                  |
| Datos          | Graph cycle constraints/triggers probados.                                                            |
| Datos          | Idempotency/outbox/inbox durables.                                                                    |
| Backend        | Java 21/Spring Boot/Spring Modulith/hexagonal boundaries verificadas.                                 |
| Backend        | ETag/@Version y 412 en todas mutaciones aplicables.                                                   |
| Backend        | Publish transaction + receipt + outbox atomic.                                                        |
| API            | OpenAPI con ProblemDetail/reason codes/idempotency documented.                                        |
| Events         | AsyncAPI versionado y consumers dedup.                                                                |
| Frontend       | Workspaces construidos, no CRUD flat.                                                                 |
| Frontend       | NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT implementados.                                  |
| Frontend       | WCAG 2.2 AA critical flows y graph alternative.                                                       |
| Mobile         | Boundary read/review documentada; publish/void no expuestos.                                          |
| Security       | RBAC+ABAC+SoD+step-up/least privilege testados.                                                       |
| Privacy        | No participant PII ni blobs en EC-01.                                                                 |
| IA             | Solo CT-12; provenance/evals; no auto-publish.                                                        |
| Resiliencia    | Timeout/retry/circuit/reconciliation/UNKNOWN_EFFECT testados.                                         |
| Observabilidad | Logs/metrics/traces/SLI/SLO/alerts desplegados.                                                       |
| Migración      | CT-16 dry-run/promotion/receipts/reconciliation certificados.                                         |
| QA             | Unit/domain/repository/integration/contract/security/tenant/concurrency/idempotency/performance PASS. |
| UAT            | UAT-01…20 aprobados o exceptions formalmente aceptadas.                                               |
| Gates          | G1…G10 con evidence pack y sign-off.                                                                  |
| Artefactos     | Word/Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs sincronizados.                                            |
| Release        | Backup/rollback-forward/runbooks/on-call readiness verificados.                                       |

| **CERTIFICACIÓN FINAL —** EC-01 está listo para producción únicamente cuando los diez Gates tienen evidencia, el DDL defensivo ha sido ejecutado contra PostgreSQL real, los contratos están versionados, los escenarios de tenant/concurrencia/idempotencia/UNKNOWN_EFFECT pasan y el Word permanece alineado con los artefactos ejecutables. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

FIN DEL DOCUMENTO — PeopleU IA · EC-01 · Documento Maestro Oficial V1.0

# 41. Contrato FullStack no negociable de implementación

Esta sección convierte EC-01 V1.1 en plantilla normativa para todos los módulos EC posteriores. Un módulo puede variar su dominio, pero no puede degradar estos contratos de plataforma sin ADR explícito de nivel superior.

| **Área**         | **Contrato mínimo**                                                                                | **Evidencia de cierre**                    |
|------------------|----------------------------------------------------------------------------------------------------|--------------------------------------------|
| **Tenant**       | PK/FK tenant-aware + FORCE RLS + TenantContext transaccional + roles DB separados.                 | Tenant isolation suite + role audit.       |
| **Concurrencia** | @Version/ETag representa aggregate completo; child mutation cambia root revision.                  | Concurrent stale ETag tests.               |
| **Historia**     | Snapshots no se reescriben; state machine física + lineage monotónico + supersede/void.            | DB negative tests + audit reconstruction.  |
| **Idempotencia** | Durable key/request hash/lease/recovery en comandos sensibles.                                     | Crash/replay/concurrent acquisition tests. |
| **Eventos**      | Outbox/inbox, claim lease, SKIP LOCKED, dedup y UNKNOWN_EFFECT reconcile.                          | Two-worker + timeout/reconcile tests.      |
| **API**          | OpenAPI ejecutable, ProblemDetail/reason codes, paginación bounded, If-Match, 202 OperationStatus. | Contract/breaking tests.                   |
| **Frontend**     | Client/DTO generado, state model explícito, conflict UX, accessibility y responsive behavior.      | Component/E2E/a11y evidence.               |
| **Seguridad**    | Threat Model, RBAC/ABAC/SoD/step-up, Secure SDLC, SBOM y secrets.                                  | Security Gate PASS.                        |
| **DB Release**   | Flyway expand/contract N/N-1; runtime/migrator separados.                                          | Deployment rehearsal evidence.             |
| **Operaciones**  | SLI/SLO, runbooks, observability, recovery y evidence pack.                                        | Gates G1-G10 PASS.                         |
| **DX**           | Bootstrap reproducible, Testcontainers, fixtures multi-tenant y comandos CI/local equivalentes.    | Fresh-clone bootstrap PASS.                |

CERTIFICACIÓN DE PLANTILLA — EC-01 V1.1 queda congelado como piso formal para EC-02…EC-12. Cualquier módulo posterior que omita una garantía de esta sección debe declarar “NO APLICA”, justificar la frontera y demostrar que la omisión no reintroduce el riesgo.
