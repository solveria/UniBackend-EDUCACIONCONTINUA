**PEOPLEU IA**

**EC-08**

**CERTIFICADOS, BADGES, MICROCREDENCIALES,  
CREDENCIALES VERIFICABLES Y ACUMULABILIDAD**

**Guia de Ingenieria Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones**

| **Control**    | **Valor**                                                                                                      |
|----------------|----------------------------------------------------------------------------------------------------------------|
| Código         | EC-08                                                                                                          |
| Versión        | V1.0                                                                                                           |
| Estado         | VIGENTE — FULLSTACK ENTERPRISE                                                                                 |
| Baseline       | EC-00 V1.1 + EC-01 V1.1 + contratos EC-02...EC-07                                                              |
| Vertical       | Educación Continua / Formacion Continua                                                                        |
| Arquitectura   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| Stack objetivo | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| Contexto       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| Fecha base     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS — Word = Especificacion Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = analisis y diseño; no son Source of Truth oficial.** |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| REGLA DE FRONTERA — EC-08 es Source of Truth de eligibility de credencial, award, issuance, status, revocación/corrección y evidencia semántica de credenciales EC. CT-05 conserva documentos/binarios; EC-01 define blueprints; EC-07 define CompletionFact; EC-10 gobierna progreso individual de rutas. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaracion de propósito, autoridad y baseline

| **V1.0 — MODULO DE CREDENCIALES ENTERPRISE — EC-08 convierte hechos academicos ya cerrados en credenciales gobernadas, verificables, auditables e interoperables. La emisión nunca se deduce por un simple status; requiere eligibility versionada, award explicito, snapshot canonico, firma/evidencia, publication delivery y lifecycle no destructivo.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

EC-08 operacionaliza AM-00, CT-00, CT-01...CT-18, EC-00 V1.1 y los contratos publicados por EC-01...EC-07. Su responsabilidad es recibir blueprints publicados, CompletionFacts oficiales y otras condiciones versionadas; evaluar elegibilidad; registrar el award institucional; emitir una representacion durable de la credencial; exponer verificación publica controlada; gestionar suspension, revocación, corrección y supersession; y publicar hechos confiables para EC-10 y analitica.

El módulo debe soportar certificados de participacion, certificados por aprobación, badges, microcredenciales y credenciales acumulativas, sin convertir ninguno de esos conceptos en grado académico. La interoperabilidad con Open Badges, Verifiable Credentials, CLR, wallets u otros perfiles se implementa mediante CT-18 y adaptadores versionados; el modelo de dominio no depende de un proveedor.

La exigencia central es reconstructibilidad. Anos despues de una emisión debe poder demostrarse que blueprint, CompletionFact, policy versions, identidad, contenido presentado, documento, firma, status y reason codes sustentaron exactamente la credencial emitida. Una corrección material genera un nuevo issuance que supersede al anterior; no se reescribe el pasado.

| **CRITERIO DE EXITO — Un equipo Senior debe poder emitir, verificar, suspender, revocar, corregir, superseder y auditar credenciales sin conocimiento tribal; PostgreSQL debe impedir duplicados semanticos, cruces de tenant, receipts mutables y lineage imposible incluso si Backend tiene un bug.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquia documental aplicable

| **Prioridad** | **Documento/artefacto**                | **Rol**                                                                                    |
|---------------|----------------------------------------|--------------------------------------------------------------------------------------------|
| 1             | AM-00 vigente                          | Constitucion arquitectonica superior.                                                      |
| 2             | CT-00 vigente                          | Contrato maestro transversal.                                                              |
| 3             | CT-01...CT-18 vigentes                 | Capacidades compartidas y fronteras.                                                       |
| 4             | EC-00 V1.1                             | Constitucion funcional/arquitectonica de Educación Continua.                               |
| 5             | EC-01...EC-07 vigentes                 | Contratos upstream de blueprint, edition, participant, execution, attendance y completion. |
| 6             | EC-08 V1.0 (este documento)            | Especificacion implementable de credenciales.                                              |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación y evidencia alineadas al Word.                                              |

## 0.2 Secuencia oficial vigente de módulos EC

| **Orden** | **Código** | **Módulo oficial**                                                                  | **Responsabilidad primaria** |
|-----------|------------|-------------------------------------------------------------------------------------|------------------------------|
| 1         | EC-01      | Portafolio, programas, versiones, módulos y rutas de microcredenciales              | Diseño académico             |
| 2         | EC-02      | Ediciones, ofertas, cohortes, modalidades, calendarios y programación operativa     | Oferta / ejecución           |
| 3         | EC-03      | Comercializacion académica, pricing, promociones, becas, convenios y condiciones    | Comercial                    |
| 4         | EC-04      | Prospectos, participantes, registro, preinscripcion, inscripcion, cupos y waitlist  | Vinculacion                  |
| 5         | EC-05      | Docentes, expertos, facilitadores, planificacion, contenidos y entorno              | Docencia                     |
| 6         | EC-06      | Asistencia, participacion, engagement y evidencia de sesiones                       | Participacion                |
| 7         | EC-07      | Evaluaciones, resultados, aprobación, completion y cierre académico                 | Evaluación / cierre          |
| 8         | EC-08      | Certificados, badges, microcredenciales, credenciales verificables y acumulabilidad | Certificacion                |
| 9         | EC-09      | Formacion corporativa / in-company, clientes, acuerdos, lotes y reporting           | B2B / Corporate              |
| 10        | EC-10      | Trayectoria, progresion, stackable credentials y reconocimiento acumulativo         | Trayectoria                  |
| 11        | EC-11      | Encuestas, NPS, feedback, evaluación docente, impacto y seguimiento                 | Experiencia / impacto        |
| 12        | EC-12      | Calidad, analitica de portafolio, indicadores, compliance y mejora continua         | Calidad / gobierno           |

## 0.3 Decisiones arquitectonicas EC08-DA

| **ID**      | **Decisión normativa**                                                                                                                                  |
|-------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
| EC08-DA-001 | COMPLETION FACT ≠ CREDENTIAL ELIGIBILITY. EC-07 prueba completion; EC-08 evalua si ese hecho y otras condiciones satisfacen la policy de la credencial. |
| EC08-DA-002 | CREDENTIAL ELIGIBILITY ≠ CREDENTIAL AWARD. Ser elegible no crea por si solo un award institucional.                                                     |
| EC08-DA-003 | CREDENTIAL AWARD ≠ CREDENTIAL ISSUANCE. Award es el hecho de adjudicacion; issuance es una representacion oficial emitida de ese award.                 |
| EC08-DA-004 | CREDENTIAL ISSUANCE ≠ DOCUMENT. EC-08 posee el issuance; CT-05 posee PDF, firma documental y binarios.                                                  |
| EC08-DA-005 | QR/TOKEN ≠ CREDENTIAL. El QR es un locator/verifier handle revocable o reemplazable; no es la verdad académica.                                         |
| EC08-DA-006 | BADGE ASSERTION ≠ ACADEMIC FACT. Badges derivan de awards/issuances y no pueden crear completion.                                                       |
| EC08-DA-007 | MICROCREDENTIAL ≠ DEGREE. Una microcredencial EC no equivale automáticamente a credito o grado de PG/PO.                                                |
| EC08-DA-008 | STACKING PROGRESS ≠ CUMULATIVE AWARD. EC-10 calcula progreso; EC-08 adjudica una credencial acumulativa solo cuándo la policy y evidence lo permiten.   |
| EC08-DA-009 | BLUEPRINT ≠ AWARD. EC-01 define el tipo de credencial posible; EC-08 registra hechos individuales.                                                      |
| EC08-DA-010 | PERSON ≠ HOLDER SNAPSHOT. CT-04 posee Person; EC-08 conserva referencias y un snapshot mínimo de presentacion para reconstructibilidad.                 |
| EC08-DA-011 | ISSUED SNAPSHOT = IMMUTABLE. Payload, serial, hash, policy refs y holder display snapshot no se editan luego de emitir.                                 |
| EC08-DA-012 | MATERIAL CORRECTION = SUPERSEDING ISSUANCE. Errores materiales se corrigen con nuevo issuance + link, no UPDATE destructivo.                            |
| EC08-DA-013 | REVOCATION ≠ DELETE. Revocar crea status fact/decisión durable; el issuance sigue siendo verificable cómo revoked.                                      |
| EC08-DA-014 | SUSPENSION ≠ REVOCATION. Suspension es temporal/reversible; revocación es decisión terminal salvo procedimiento de restatement formal.                  |
| EC08-DA-015 | STATUS HISTORY = APPEND-ONLY. Estado publico se deriva de facts/restatements; nunca se borra evidencia pasada.                                          |
| EC08-DA-016 | VERIFICATION PUBLICA = DATA MINIMIZATION. Un verifier no necesita exponer PII, notas, deuda ni historial completo.                                      |
| EC08-DA-017 | VERIFICATION TOKEN STORED AS HASH. No se persiste el bearer token plano; se compara hash y se controla rate limiting/abuse.                             |
| EC08-DA-018 | PUBLIC VERIFIER ≠ GENERIC DB ACCESS. Usa gateway/restricted contract; nunca un usuario anonimo con SELECT sobre tablas EC-08.                           |
| EC08-DA-019 | SIGNING KEY ≠ DATABASE SECRET. EC-08 persiste key_ref/algorithm/receipt; material privado vive en KMS/HSM/adaptador gobernado.                          |
| EC08-DA-020 | CT-18 = INTEROPERABILITY MEDIATOR. Open Badges/VC/CLR/wallets se resuelven por adapter, schema versión y contract tests.                                |
| EC08-DA-021 | DELIVERY ≠ ISSUANCE. Fallo de email/wallet no revierte una credencial ya emitida; se reintenta/reconcilia delivery.                                     |
| EC08-DA-022 | WALLET UNKNOWN_EFFECT = RECONCILE BEFORE RETRY. Timeout tras posible efecto remoto no autoriza reenvio ciego.                                           |
| EC08-DA-023 | BATCH ≠ SINGLE TRANSACTION FOR ALL. Emisión masiva registra resultado por item y permite partial success sin perder trazabilidad.                       |
| EC08-DA-024 | FINANCIAL REGULARITY ≠ FINANCIAL LEDGER. EC-08 puede consumir un fact/decisión versionado; Finanzas sigue siendo Source of Truth.                       |
| EC08-DA-025 | AI RECOMMENDATION ≠ ELIGIBILITY/AWARD/REVOCATION DECISION. CT-12 puede explicar o detectar anomalías; nunca decide hechos oficiales.                    |
| EC08-DA-026 | CROSS-CONTEXT REF ≠ CROSS-CONTEXT FK. IDs EC-01/07/10/CT/Finanzas son EXT REF sin FK física.                                                            |
| EC08-DA-027 | TENANT CONTEXT ≠ REQUEST BODY. tenant_id proviene del contexto autorizado; PK/FK internas son tenant-aware.                                             |
| EC08-DA-028 | TENANT-AWARE FK ≠ TENANT ISOLATION. RLS ENABLE+FORCE es obligatoria para defensa ante bugs de repository.                                               |
| EC08-DA-029 | AGGREGATE REVISION CUBRE HIJOS MUTABLES. Corrección/revocación/batch usan root revisión y ETag cuándo hay aggregate mutable.                            |
| EC08-DA-030 | IDEMPOTENCY IN_PROGRESS ≠ FOREVER. Comandos sensibles usan lease/recovery; same-key/different-payload es conflicto.                                     |
| EC08-DA-031 | OUTBOX PENDING ≠ CLAIMED. Workers usan SKIP LOCKED + lease + recovery, no polling sin ownership.                                                        |
| EC08-DA-032 | 202 ACCEPTED ≠ EFFECT CONFIRMED. Operaciones asincronas entregan operationId y OperationStatus hasta terminal/reconcile.                                |
| EC08-DA-033 | POLICY REF = IMMUTABLE POLICY VERSION REF. Toda decisión reconstruible pinnea policy versión/snapshot.                                                  |
| EC08-DA-034 | PUBLIC CACHE ≠ SOURCE OF TRUTH. Redis acelera verificación pero nunca determina validez sin provenance/versión.                                         |
| EC08-DA-035 | NO BLOBS IN POSTGRESQL. CT-05 conserva documentos, firmas y evidence packs; EC-08 guarda refs, hashes y metadata.                                       |
| EC08-DA-036 | NO HARD DELETE OF OFFICIAL HISTORY. Award, issuance, status facts, decisions, receipts y supersession links son historicos.                             |
| EC08-DA-037 | SCHEMA RELEASE ≠ APP RELEASE. Flyway productivo sigue expand/contract y compatibilidad N/N-1.                                                           |
| EC08-DA-038 | OPENAPI/ASYNCAPI = EXECUTABLE CONTRACTS. Frontend/clientes se generan o validan contra contrato; no DTOs paralelos.                                     |
| EC08-DA-039 | VERIFIABLE CREDENTIAL PROFILE ≠ CORE DOMAIN. JSON-LD/JWT/OB3/CLR son representaciones externas; el dominio permanece provider-neutral.                  |
| EC08-DA-040 | CREDENTIAL STATUS MUST FAIL SAFE. Si la verdad de status no puede resolverse, el verifier muestra UNAVAILABLE/UNKNOWN, nunca VALID por defecto.         |

## 0.4 Criterio de suficiencia FullStack y regla de plantilla

EC-08 se considera suficiente cuándo dos equipos Senior independientes pueden producir el mismo comportamiento observable para eligibility, award, issuance, verification, correction, revocation, interoperability y batch; y cuándo las invariantes fisicas impiden representaciones oficiales imposibles aun con defectos de aplicación.

| **REGLA DE PLANTILLA — EC-09...EC-12 deben conservar RLS defense-in-depth, Aggregate Revisión, append-only history, ETag/If-Match, idempotency lease, outbox lease, OperationStatus, UNKNOWN_EFFECT, API paginada, Threat Model, Secure SDLC, expand/contract y bootstrap reproducible.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.5 Invariantes heredadas de EC-01...EC-07

| **ID** | **Invariante heredada**                                                               |
|--------|---------------------------------------------------------------------------------------|
| I-01   | ProgramVersion/Blueprint se consumen pinneados; nunca latest para historia.           |
| I-02   | Participant/Person son referencias gobernadas; EC-08 no crea un Person local.         |
| I-03   | CompletionFact oficial pertenece a EC-07 y es inmutable/restatable según su contrato. |
| I-04   | CT-05 conserva documentos y evidence packs; EC-08 no guarda blobs.                    |
| I-05   | Toda policy variable proviene de CT-02/versioned policy.                              |
| I-06   | RLS ENABLE+FORCE y runtime role sin BYPASSRLS.                                        |
| I-07   | No FK física cross-context.                                                           |
| I-08   | Idempotency + outbox/inbox para side effects y eventos.                               |
| I-09   | UNKNOWN_EFFECT exige reconciliation antes de retry.                                   |
| I-10   | UI distingue NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.                   |
| I-11   | Historia oficial se corrige por supersede/void/restatement, no por overwrite.         |
| I-12   | IA pasa por CT-12 y no toma decisiones academicas.                                    |

# 1. Indice operativo del documento

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Maquinas de estado normativas

- 9\. Catalogo formal de reglas BR-EC08

- 10\. Casos de uso UC-EC08

- 11\. DER conceptual, logico y físico

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

- 26\. Analitica y KPI

- 27\. Migración legacy y Data Quality con CT-16

- 28\. QA y estrategia de pruebas

- 29\. Golden Scenarios

- 30\. UAT institucional

- 31\. Gates G1-G10

- 32\. Definition of Ready / Definition of Done

- 33\. Runbooks

- 34\. ADRs y decisiones abiertas

- 35\. Engineering Pack

- 36\. Guia secuencial Backend

- 37\. Guia secuencial Frontend

- 38\. Matriz de permisos

- 39\. Contratos DTO Frontend

- 40\. Checklist de release y certificacion final

- 41\. Contrato FullStack no negociable de implementación

# 2. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

EC-08 resuelve el tramo institucional que transforma hechos academicos ya determinados en una credencial confiable. Una universidad que solo genera PDFs desde una plantilla carece de lineage, status verificable, corrección gobernada, protección contra duplicados, interoperabilidad y evidencia suficiente para auditoría. EC-08 separa eligibility, award, issuance, document y verification para evitar esa fragilidad.

El módulo permite emitir certificados de participacion o aprobación, badges y microcredenciales, mantener status publico, gestionar revocaciones/correcciones, entregar al holder y a wallets, operar lotes masivos y adjudicar credenciales acumulativas cuándo exista evidencia suficiente. Cada issuance conserva serial, snapshot, hash, policy refs, evidence refs y firma/receipt, por lo que el resultado puede reconstruirse sin depender de la versión actual del programa.

## 2.1 Incluido

- Evaluation de eligibility por CredentialBlueprint publicado y CompletionFact/otros facts oficiales.

- CredentialAward institucional y evidence bindings.

- Issuance individual y masivo con seriales unicos, snapshot canonico, documento CT-05 y signing receipt.

- Verificación publica mediante token/QR minimizado y status actual.

- Suspension, revocación, void, corrección, reemision y supersession no destructivos.

- BadgeAssertion y MicrocredentialRecord derivados de award/issuance.

- Entrega por portal, email, descarga, wallet o interoperabilidad CT-18.

- CumulativeEvaluation sobre awards/facts pinneados; emission de cumulative credential cuándo policy corresponde.

- Batch processing con partial success, replay seguro y reconciliation.

- OpenAPI/AsyncAPI, idempotencia, outbox/inbox, OperationStatus, observabilidad, seguridad, QA, UAT y migración.

## 2.2 Fuera de alcance

- Definir CredentialBlueprint o PathwayDefinition — EC-01.

- Crear ProgramEdition/Offering — EC-02.

- Precio, deuda, pago, factura o saldo — EC-03/Finanzas.

- Crear Person/Participant/Enrollment — CT-04/EC-04.

- Impartir contenido o provisionar LMS — EC-05/CT-18.

- Registrar attendance/participation — EC-06.

- Calcular CompletionFact/nota final — EC-07.

- Calcular trayectoria individual y progreso continuo de pathway — EC-10.

- Guardar blobs/PDFs/documentos firmados — CT-05.

- Llamar proveedores de IA directamente — CT-12.

| **ANTI-SCOPE — EC-08 no debe convertirse en un generador de PDF con lógica escondida. Tampoco debe recalcular notas, asistencia, pagos o identidad canonicamente. Consume facts oficiales y conserva evidence de la decisión de credencial.** |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Termino**                     | **Definicion normativa**                                                                                                          |
|---------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| CredentialEligibilityEvaluation | Evaluación versionada que determina ELIGIBLE/INELIGIBLE para un blueprint y subject/enrollment usando policies y facts pinneados. |
| EligibilityRuleFact             | Resultado atomico de una regla de eligibility con source fact/ref, outcome y evidence.                                            |
| CredentialAward                 | Hecho institucional de adjudicacion de una credencial a un holder; existe independientemente de formatos de entrega.              |
| CredentialIssuance              | Instancia oficial emitida de un award con serial, snapshot, status y lineage.                                                     |
| CredentialPayloadSnapshot       | Representacion canonica inmutable del contenido emitido; base para hash/firma/interoperabilidad.                                  |
| CredentialDocumentBinding       | Referencia entre issuance y documento/artefacto CT-05.                                                                            |
| SigningReceipt                  | Evidencia de operación de firma: key_ref, algoritmo, digest, provider receipt; no contiene clave privada.                         |
| VerificationHandle              | Handle publico no adivinable cuya forma presentada puede ser QR/URL/token; se persiste solo token_hash.                           |
| CredentialStatusFact            | Hecho append-only que determina status publico en un instante.                                                                    |
| StatusRestatement               | Corrección formal de un status fact sin borrar historia.                                                                          |
| RevocationCase                  | Caso gobernado que investiga o solicita revocación/suspension.                                                                    |
| CorrectionRequest               | Solicitud de corregir datos de presentacion o hechos materiales de una credencial.                                                |
| SupersessionLink                | Relacion inmutable entre issuance anterior y nuevo issuance correctivo.                                                           |
| DeliveryRequest                 | Intencion de entregar una credencial por un canal.                                                                                |
| DeliveryReceipt                 | Resultado durable de una entrega; no modifica el hecho de issuance.                                                               |
| BadgeAssertion                  | Representacion compatible de un award/issuance para ecosistemas de badges; derivada, no academic truth.                           |
| MicrocredentialRecord           | Clasificación/metadata institucional de un award cómo microcredencial bajo un perfil versionado.                                  |
| CumulativeEvaluation            | Evaluación puntual de si un conjunto de awards/facts satisface un blueprint acumulativo.                                          |
| CredentialBatch                 | Orquestacion de emisión masiva con resultado independiente por item.                                                              |
| Holder                          | Persona/subject a quién se adjudica la credencial; referencia a CT-04/EC-04, no Person duplicado.                                 |
| Issuer                          | Universidad/scope autorizado que emite; referencia CT-01 + policy.                                                                |
| Verifier                        | Actor publico o autenticado que consulta validez/minimal public projection.                                                       |
| EXT REF                         | Referencia cross-context sin FK física; se valida por contract/port y evidence.                                                   |
| UNKNOWN_EFFECT                  | Estado en el que una operación remota pudo ocurrir pero no existe confirmacion; exige reconcile antes de retry.                   |

# 4. Bounded Context y matriz Source of Truth

EC-08 posee la semántica de credential eligibility, award, issuance, status y lifecycle de credenciales de Educación Continua. Cuando un dato pertenece a otro contexto, EC-08 persiste solo external refs, snapshots explicitamente justificados y receipts para reconstructibilidad. El snapshot histórico de nombre del holder, titulo o issuer no convierte a EC-08 en owner de Person, ProgramDefinition o Organization.

Durante issuance, toda dependencia indispensable se resuelve fail-closed. Si CompletionFact, blueprint, identity assurance, financial regularity o signing service requerido no puede confirmarse, el sistema no debe interpretar silencio cómo cumplimiento. Una dependencia no crítica de delivery puede degradarse despues del commit sin invalidar el issuance.

| **Información**                 | **Source of Truth** | **EC-08 almacena**                    | **EC-08 referencia**             | **Regla**                                                           |
|---------------------------------|---------------------|---------------------------------------|----------------------------------|---------------------------------------------------------------------|
| Tenant/sede/campus/issuer scope | CT-01               | tenant_id + issuer_scope_ref          | scope/versión refs               | Tenant desde auth context; no FK cross-context.                     |
| Catalogos/policies              | CT-02               | policy refs/snapshots minimos         | immutable policy/versión refs    | No hardcode de umbrales, expiraciones o tipos.                      |
| Temporalidad                    | CT-03               | instantes de hechos                   | timezone/calendar refs si aplica | UTC para hechos; presentacion localizada.                           |
| Persona canonica                | CT-04               | holder_ref + display snapshot mínimo  | person/subject refs              | Snapshot no crea Person local.                                      |
| Documentos/evidencia            | CT-05               | document/evidence refs + hash         | document_ref                     | No blobs.                                                           |
| Workflow/aprobaciones           | CT-06               | decisión refs                         | workflow/task refs               | Revocation/corrections pueden requerir workflow.                    |
| Notificaciones                  | CT-07               | delivery request/receipt local        | notification refs                | Fallo de email no revierte issuance.                                |
| Localizacion                    | CT-08               | locale/snapshot labels                | translation refs                 | Traduccion no altera award.                                         |
| Integraciones/eventos           | CT-09               | outbox/inbox                          | contract/message refs            | At-least-once + dedup.                                              |
| Seguridad/auditoría/privacy     | CT-10               | business audit metadata               | audit/evidence refs              | Public verifier minimiza PII.                                       |
| Analitica/BI                    | CT-11               | produce facts                         | dataset refs                     | Sin shadow BI.                                                      |
| IA                              | CT-12               | run/eval refs                         | AI run refs                      | Recommendation != Decisión.                                         |
| Scheduling                      | CT-13               | No                                    | No                               | Fuera de EC-08.                                                     |
| Recursos/reservas               | CT-14               | No                                    | No                               | Fuera de EC-08.                                                     |
| Elegibilidad transversal        | CT-15               | rule outcomes/refs cuándo corresponda | eligibility_rule_ref             | EC-08 compone eligibility de credencial; no duplica motor generico. |
| Migración/DQ                    | CT-16               | promotion receipts refs               | batch/lineage refs               | No INSERT directo.                                                  |
| Continuidad                     | CT-17               | runbook/continuity refs               | RTO/RPO                          | Verifier tiene prioridad de continuidad.                            |
| Wallets/Open Badges/VC/CLR      | CT-18               | interop refs/receipts                 | provider/schema refs             | Adapters versionados; no lock-in.                                   |
| CredentialBlueprint             | EC-01               | blueprint_ref snapshot key            | published blueprint/versión      | EC-08 no edita blueprint.                                           |
| CompletionFact/result           | EC-07               | completion_fact_ref                   | official fact                    | No recalcula nota/completion.                                       |
| Participant/enrollment          | EC-04               | subject/enrollment refs               | participant/enrollment           | No registro local de participante.                                  |
| Trayectoria/progreso            | EC-10               | award events                          | path progress refs               | Progress es owner EC-10.                                            |
| Deuda/pago/factura              | Finanzas            | solo fact/ref requerido               | financial_regular_ref            | Academic system != ledger.                                          |
| Award/Issuance/Status           | EC-08               | Si                                    | --                               | Source of Truth local.                                              |

# 5. Dependencias CT-01 a CT-18, cores y otros módulos

| **Dependencia** | **Responsabilidad**        | **Contrato EC-08**                            | **Frontera/fallo**                                        |
|-----------------|----------------------------|-----------------------------------------------|-----------------------------------------------------------|
| CT-01           | Scope institucional/issuer | issuer_scope_ref + tenant validation          | Fail-closed en award/issue si issuer scope invalido.      |
| CT-02           | Policies/versioned config  | eligibility/status/expiry/signing policy refs | Immutable refs; cache con versión.                        |
| CT-04           | Identity                   | holder_ref + assurance context                | No PII duplicada salvo snapshot mínimo justificado.       |
| CT-05           | Document/evidence          | create document, bind hash, evidence pack     | UNKNOWN_EFFECT/reconcile si create remote effect ambiguo. |
| CT-06           | Workflow                   | revocation/correction/exception approval      | Workflow no sustituye invariantes EC-08.                  |
| CT-07           | Delivery notification      | email/push requests + receipt refs            | Post-issuance; no rollback.                               |
| CT-08           | i18n                       | locale + translation refs                     | Canonical snapshot + localized render.                    |
| CT-09           | Integration governance     | events/contracts                              | Outbox/inbox.                                             |
| CT-10           | Security/audit/privacy     | reason, assurance, evidence                   | High-assurance operations.                                |
| CT-11           | Analytics                  | award/issuance/status facts                   | Event-fed datasets.                                       |
| CT-12           | AI                         | explanations/anomaly detection                | Human decisión mandatory.                                 |
| CT-15           | Eligibility support        | generic rule evaluation refs                  | No duplicate universal eligibility engine.                |
| CT-16           | Migration                  | staging/dry-run/promotion                     | No direct INSERT.                                         |
| CT-17           | Continuity                 | public verifier RTO/RPO                       | Read verification prioritized.                            |
| CT-18           | Credential ecosystem       | wallet/Open Badges/VC/CLR adapters            | Reconcile unknown remote effects.                         |
| EC-01           | Blueprints/pathway design  | Consumes PUBLISHED blueprint                  | Pin exact blueprint/versión.                              |
| EC-04           | Participant/enrollment     | holder/enrollment refs                        | No shadow participant.                                    |
| EC-07           | CompletionFact             | Consumes official completion                  | No recalculation.                                         |
| EC-10           | Trajectory/progress        | Publishes award/status events                 | No local progress engine.                                 |
| Finanzas        | Financial facts            | Consumes regularity ref if policy demands     | No ledger.                                                |
| IAM             | Authentication/MFA         | actor + assurance                             | Step-up issue/revoke/batch where required.                |

# 6. Arquitectura funcional E2E y journeys

<img src="media/image1.png" style="width:6.6in;height:3.96in" />

Figura 1 — EC-08 dentro de la vertical y capacidades transversales

| **Journey**                         | **Flujo E2E**                                                                                                                                                                          |
|-------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| J-EC08-01 Emisión individual        | CompletionFact + blueprint publicados → evaluate eligibility → ELIGIBLE → award → issue → payload snapshot → CT-05 document/sign → verification handle → outbox/delivery.              |
| J-EC08-02 No elegible               | Rule facts incluyen FAIL/UNKNOWN → evaluation INELIGIBLE/ERROR → no award → UI explica reason codes sin inventar hechos.                                                               |
| J-EC08-03 Certificado participacion | Policy usa attendance/participation facts permitidos; no exige assessment cuándo blueprint no lo requiere.                                                                             |
| J-EC08-04 Corrección nombre visible | Solicitud → determina si cambio es render-only o material → render-only puede crear nuevo documento ligado al mismo issuance si policy lo permite; material crea superseding issuance. |
| J-EC08-05 Revocación                | Abrir RevocationCase → evidence + CT-06/SoD → decisión → append status REVOKED → public verifier refleja estado sin eliminar issuance.                                                 |
| J-EC08-06 Wallet                    | Issuance commitido → delivery request CT-18 → timeout after send → UNKNOWN_EFFECT → provider status/reconcile → retry solo si no aplicado.                                             |
| J-EC08-07 Batch                     | Seleccionar candidatos → preflight → batch sealed → items procesados idempotentemente → partial success visible → retry solo failed/recoverable.                                       |
| J-EC08-08 Cumulative credential     | EC-10 aporta progreso o awards fuente pinneados → cumulative evaluation → target blueprint eligibility → award/issuance; awards fuente quedan intactos.                                |
| J-EC08-09 Public verify             | QR/token → hash lookup por gateway restringido → status actual + public projection → no notas/deuda/PII extra → rate limit/audit abuse.                                                |
| J-EC08-10 Provider caido            | Signing/document provider requerido UNAVAILABLE → issuance permanece ISSUING/ERROR según atomic boundary; OperationStatus informa y runbook reconcilia.                                |

# 7. Modelo de dominio: Aggregates, Entities, Value Objects, Policies y Domain Services

<img src="media/image2.png" style="width:6.6in;height:3.96in" />

Figura 2 — Modelo de dominio logico EC-08

## 7.1 Aggregate Root — CredentialEligibilityEvaluation

CredentialEligibilityEvaluation captura la decisión reproducible sobre si un holder/enrollment satisface un CredentialBlueprint en un instante y bajo policies concretas. Agrega EligibilityRuleFact y conserva hash/snapshot de policy. No modifica CompletionFact ni resuelve hechos ajenos; compone respuestas oficiales mediante ports y registra UNKNOWN cuándo una fuente no puede determinarse.

## 7.2 Aggregate Root — CredentialAward

CredentialAward representa la adjudicacion institucional de la credencial. Su identidad es estable y puede tener una o más representaciones emitidas cuándo existe corrección/supersession. El award no depende de que un email haya llegado ni de que el PDF pueda abrirse; es un hecho de negocio sustentado por eligibility y evidence.

## 7.3 Aggregate Root — CredentialIssuance

CredentialIssuance representa una emisión oficial con serial, número dentro del award, issuer, canonical snapshot y lifecycle publico. Una emisión ISSUED queda inmutable; suspension/revocation se expresan cómo facts y una corrección material crea otro issuance relacionado por SupersessionLink.

## 7.4 Aggregate — RevocationCase / CorrectionRequest

Estos aggregates gobiernan excepciones de alto riesgo. Acumulan motivo, evidence refs, workflow y decisión. Nunca habilitan editar directamente CredentialIssuance. Las operaciones pueden exigir SoD y step-up según policy versionada.

## 7.5 Aggregate — CredentialBatch

CredentialBatch orquesta operaciones masivas sin convertirlas en una transacción distribuida gigante. Cada item posee estado y operation correlation propios; el batch puede terminar PARTIAL. Repetir una ejecución usa claves idempotentes y no duplica awards ni seriales.

## 7.6 Value Objects

| **Value Object**     | **Semántica**                                                                                 |
|----------------------|-----------------------------------------------------------------------------------------------|
| CredentialSerial     | Business identifier tenant-scoped, no reutilizable; formato según policy.                     |
| TokenHash            | Digest de verification token; token plano solo se muestra al crear/entregar y no se persiste. |
| CanonicalPayloadHash | Hash de snapshot canonico + schema versión.                                                   |
| PolicyRef            | policy_id/versión inmutable o contrato equivalente.                                           |
| ExternalRef          | Opaque ID + authority; sin FK cross-context.                                                  |
| AssuranceContext     | Nivel de autenticacion/step-up y evidence del actor.                                          |
| CredentialStatus     | ISSUED/SUSPENDED/REVOKED/SUPERSEDED/VOID según state machine.                                 |
| IssuanceLocale       | Locale de rendering/payload; no modifica academic truth.                                      |
| ProviderReceipt      | Identificador y datos minimos de resultado remoto para reconcile.                             |
| ReasonCode           | Código estable que permite auditoría, UI y analytics sin depender del texto libre.            |

## 7.7 Domain Policies

- CredentialEligibilityPolicy — condiciones para ELIGIBLE/INELIGIBLE/ERROR.

- AwardPolicy — evita adjudicacion duplicada y define evidence minima.

- IssuancePolicy — serial, issuer, assurance, document/signing requirements.

- CredentialStatusPolicy — transiciones suspend/reinstate/revoke/void.

- CorrectionClassificationPolicy — clasifica render-only vs material/superseding.

- PublicVerificationPolicy — proyeccion publica, retention, rate limit y privacidad.

- CredentialInteropPolicy — perfiles Open Badges/VC/CLR/wallet permitidos.

- CumulativeCredentialPolicy — evidencia y awards fuente requeridos.

- BatchPolicy — limites, chunking, retry y partial success.

- KeyRotationPolicy — algoritmo/key refs, vigencia y respuesta a compromise.

## 7.8 Domain Services

- EligibilityEvaluator — compone rule facts deterministas.

- CanonicalPayloadBuilder — produce snapshot canonico estable.

- CredentialHashService — calcula digest con algorithm/schema versión.

- SerialAllocator — reserva seriales sin colisiones bajo concurrencia.

- VerificationProjectionService — produce respuesta publica minimizada.

- CredentialCorrectionClassifier — determina impacto de una corrección.

- CumulativeEvidenceEvaluator — valida awards/facts fuente pinneados.

- InteropProjectionService — mapea dominio a perfiles externos sin contaminar core.

## 7.9 Aggregate Revisión Contract — patron obligatorio

Para aggregates mutables cómo RevocationCase, CorrectionRequest y CredentialBatch, el campo versión representa la revisión observable del aggregate completo. Cualquier mutacion de hijos que forme parte del aggregate requiere expected root revisión, lock/check transaccional y bump del root. Issuance una vez ISSUED no se edita; su lifecycle se expresa con facts append-only.

| **Paso** | **Contrato**                                                  |
|----------|---------------------------------------------------------------|
| 1        | Resolver tenant desde Security/TenantContext; nunca body.     |
| 2        | SET LOCAL peopleu.tenant_id dentro de la transacción.         |
| 3        | Cargar/lock root y comparar If-Match.                         |
| 4        | Ejecutar metodo de intencion; no setters de status.           |
| 5        | Persistir hijos y bump root revisión en la misma transacción. |
| 6        | Audit/outbox/idempotency + commit.                            |
| 7        | Responder nuevo ETag; mismatch = 412 sin efectos.             |

# 8. Maquinas de estado normativas

<img src="media/image3.png" style="width:6.7in;height:4.02in" />

Figura 3 — Estados normativos principales EC-08

| **Aggregate**                   | **Estados/transiciones**                                                                 | **Invariante**                                                         |
|---------------------------------|------------------------------------------------------------------------------------------|------------------------------------------------------------------------|
| CredentialEligibilityEvaluation | PENDING → EVALUATING → ELIGIBLE \| INELIGIBLE \| ERROR                                   | Terminal evaluable; nueva evidencia crea nueva evaluation, no rewrite. |
| CredentialAward                 | AWARDED → SUSPENDED → AWARDED; AWARDED/SUSPENDED → REVOKED; VOID excepcional             | No depende de delivery.                                                |
| CredentialIssuance              | ISSUING → ISSUED; ISSUED → SUSPENDED/REVOKED/SUPERSEDED/VOID; SUSPENDED → ISSUED/REVOKED | ISSUED payload inmutable.                                              |
| RevocationCase                  | DRAFT → SUBMITTED → UNDER_REVIEW → APPROVED \| REJECTED → APPLIED/CLOSED                 | APPLY agrega status fact.                                              |
| CorrectionRequest               | DRAFT → SUBMITTED → CLASSIFIED → APPROVED/REJECTED → APPLIED/CLOSED                      | Material =\> superseding issuance.                                     |
| DeliveryRequest                 | PENDING → IN_FLIGHT → DELIVERED \| FAILED \| UNKNOWN_EFFECT                              | UNKNOWN_EFFECT requiere reconcile.                                     |
| CredentialBatch                 | DRAFT → SEALED → RUNNING → COMPLETED \| PARTIAL \| FAILED \| CANCELLED                   | SEALED congela selection/input hash.                                   |
| OperationStatus                 | PENDING → RUNNING → SUCCEEDED \| FAILED \| UNKNOWN_EFFECT \| CANCELLED                   | 202 siempre consultable hasta terminal.                                |

| **REGLA DE ESTADO — Nunca implementar revoke, void, supersede o issue cómo PATCH status. Son casos de uso transaccionales con policy, If-Match cuándo aplica, evidence, reason code, assurance, audit y outbox.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 8.1 Public verification state derivation

El status publico se deriva del issuance y de su cadena append-only de CredentialStatusFact/StatusRestatement. El verifier no lee una columna editable cómo única verdad. Si una corrección material genera issuance nuevo, el anterior responde SUPERSEDED y puede exponer un enlace seguro al actual cuándo policy lo permite.

## 8.2 Expiry y validez temporal

Expiracion, cuándo existe, se gobierna por blueprint/policy y snapshot de issuance. EXPIRED puede ser una proyeccion temporal derivada de valid_until sin reescribir el award. Debe diferenciarse REVOKED de EXPIRED y SUSPENDED. Si la institucion no usa expiracion, NULL significa no configurado/no aplicable según contrato, no infinito por accidente.

# 9. Catalogo formal de reglas BR-EC08

| **ID**      | **Nombre**                                      | **Regla implementable/verificable**                                                                                            |
|-------------|-------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------|
| BR-EC08-001 | Tenant obligatorio                              | Toda fila tenant-owned usa tenant_id del contexto autorizado; request body no elige tenant.                                    |
| BR-EC08-002 | RLS obligatorio                                 | Todas las tablas tenant-owned habilitan ENABLE+FORCE RLS y runtime no posee BYPASSRLS.                                         |
| BR-EC08-003 | No FK cross-context                             | Refs a EC-01/04/07/10, CT y Finanzas son EXT REF sin FK física.                                                                |
| BR-EC08-004 | Blueprint pinneado                              | Eligibility/Award guardan blueprint_ref/versión exacta; nunca latest.                                                          |
| BR-EC08-005 | Completion pinneado                             | Eligibility consume CompletionFact oficial por ref/versión; no recalcula completion.                                           |
| BR-EC08-006 | Eligibility antes de award                      | No se crea award sin evaluation ELIGIBLE vigente salvo excepción formal versionada con evidence.                               |
| BR-EC08-007 | Eligibility reproducible                        | Evaluation conserva policy_ref/snapshot hash y rule facts suficientes para reconstruccion.                                     |
| BR-EC08-008 | Rule facts append-only                          | EligibilityRuleFact no se modifica/borrar; una reevaluacion crea otra evaluation.                                              |
| BR-EC08-009 | Unknown no equivale pass                        | Fuente UNKNOWN/UNAVAILABLE no se interpreta cómo cumplimiento.                                                                 |
| BR-EC08-010 | Financial fact externo                          | Regularidad financiera se consume por ref; EC-08 no calcula saldo.                                                             |
| BR-EC08-011 | Identity assurance                              | Policy puede exigir identidad verificada antes de award/issuance.                                                              |
| BR-EC08-012 | Award único semantico                           | No duplicar award para mismo holder/enrollment/blueprint bajo la misma semántica institucional.                                |
| BR-EC08-013 | Award code estable                              | award_code es único por tenant y no se reutiliza.                                                                              |
| BR-EC08-014 | Award no depende delivery                       | Fallo de email/wallet no revierte award.                                                                                       |
| BR-EC08-015 | Issuance requiere award                         | Todo CredentialIssuance referencia un award EC-08 del mismo tenant.                                                            |
| BR-EC08-016 | Serial único                                    | credential_serial es único por tenant y no se reutiliza despues de issuance/void.                                              |
| BR-EC08-017 | Issuance number monotonic                       | issuance_no es positivo y único dentro de award.                                                                               |
| BR-EC08-018 | Payload obligatorio                             | ISSUED exige payload snapshot canonico y content hash.                                                                         |
| BR-EC08-019 | Snapshot inmutable                              | CredentialPayloadSnapshot es append-only y 1:1 con issuance.                                                                   |
| BR-EC08-020 | Hash versionado                                 | Hash declara algoritmo y canonical_schema_version.                                                                             |
| BR-EC08-021 | No blobs                                        | Documentos/binarios viven en CT-05; EC-08 guarda refs/hashes.                                                                  |
| BR-EC08-022 | Signing key external                            | DB no persiste clave privada; solo key_ref/algorithm/provider receipt.                                                         |
| BR-EC08-023 | Signing receipt append-only                     | SigningReceipt no admite UPDATE/DELETE.                                                                                        |
| BR-EC08-024 | Document binding hash                           | Binding conserva document_ref + content/document hash cuándo policy lo exige.                                                  |
| BR-EC08-025 | Public token hash                               | Verification token plano no se persiste; solo token_hash.                                                                      |
| BR-EC08-026 | Token global no adivinable                      | Token debe tener entropia suficiente y hash único; no serial incremental cómo bearer secret.                                   |
| BR-EC08-027 | Verifier minimizado                             | Respuesta publica no expone notas, deuda, identificadores internos ni PII no necesaria.                                        |
| BR-EC08-028 | Verifier fail-safe                              | Si status no puede confirmarse, respuesta es UNAVAILABLE/UNKNOWN, nunca VALID por defecto.                                     |
| BR-EC08-029 | Rate limit verifier                             | Endpoint publico tiene rate limit, abuse detection y no permite enumeracion masiva.                                            |
| BR-EC08-030 | Status append-only                              | CredentialStatusFact es append-only; status actual se deriva de history valida.                                                |
| BR-EC08-031 | No hard delete                                  | Award, issuance, payload, status, decisions y receipts oficiales no se hard-deletean.                                          |
| BR-EC08-032 | Suspend != revoke                               | Suspension es reversible según policy; revocación es decisión de alto assurance.                                               |
| BR-EC08-033 | Revoke con reason                               | Revocación exige reason_code, actor, policy, evidence y step-up cuándo policy lo exige.                                        |
| BR-EC08-034 | SoD revocación                                  | Solicitante no puede ser único aprobador cuándo policy institucional exige separacion.                                         |
| BR-EC08-035 | Reinstate gobernado                             | Reinstatement solo desde SUSPENDED y con evidence/reason; no desde REVOKED salvo restatement excepcional.                      |
| BR-EC08-036 | Correction clasificada                          | Toda correction se clasifica render-only o material antes de aplicar.                                                          |
| BR-EC08-037 | Material correction supersede                   | Corrección material crea nuevo issuance y SupersessionLink; no UPDATE de snapshot emitido.                                     |
| BR-EC08-038 | Supersession aciclica                           | No self-link ni ciclos; issuance nuevo debe ser posterior al anterior.                                                         |
| BR-EC08-039 | Old issuance visible                            | Superseded issuance sigue verificable cómo SUPERSEDED según retention/public policy.                                           |
| BR-EC08-040 | Badge derivado                                  | BadgeAssertion solo deriva de award/issuance valido; no crea academic fact.                                                    |
| BR-EC08-041 | Badge status sigue issuance                     | Revocation/suspension se propaga al profile externo por event/reconcile.                                                       |
| BR-EC08-042 | Microcredential no grado                        | MicrocredentialRecord no produce degree/credit equivalence automáticamente.                                                    |
| BR-EC08-043 | Cumulative eval snapshot                        | CumulativeEvaluation pinnea source awards/facts y target blueprint/policy.                                                     |
| BR-EC08-044 | Cumulative no borra fuentes                     | Emitir credential acumulativa no invalida ni consume destructivamente awards fuente.                                           |
| BR-EC08-045 | EC-10 owns progress                             | EC-08 no mantiene progreso continuo de pathways; consume snapshot/facts de EC-10 cuándo corresponde.                           |
| BR-EC08-046 | Batch sealed                                    | Batch SEALED congela input selection/hash; cambios exigen nuevo batch o cancelacion gobernada.                                 |
| BR-EC08-047 | Batch partial success                           | Fallo de un item no revierte items ya emitidos; resultado PARTIAL es explicito.                                                |
| BR-EC08-048 | Batch item idempotent                           | Cada item posee clave/correlation estable; replay no duplica award/issuance.                                                   |
| BR-EC08-049 | Batch capacity                                  | Tamaño máximo y chunking se parametrizan; no batch ilimitado.                                                                  |
| BR-EC08-050 | Idempotency issue                               | Award/issue/revoke/correct/batch commands sensibles exigen Idempotency-Key durable.                                            |
| BR-EC08-051 | Idempotency conflict                            | Same key con payload distinto retorna 409 IDEMPOTENCY_KEY_REUSED.                                                              |
| BR-EC08-052 | Idempotency lease                               | IN_PROGRESS tiene owner/lease/recovery; no queda bloqueado para siempre tras crash.                                            |
| BR-EC08-053 | ETag mutable aggregate                          | Mutaciones de aggregates editables requieren If-Match; mismatch = 412.                                                         |
| BR-EC08-054 | No last write wins                              | Conflictos de revisión no se resuelven silenciosamente.                                                                        |
| BR-EC08-055 | Outbox atomica                                  | Award/issue/status/supersede persisten outbox en misma transacción que business fact.                                          |
| BR-EC08-056 | Inbox dedup                                     | Eventos/comandos externos consumidos se deduplican por message_id + consumer.                                                  |
| BR-EC08-057 | At-least-once                                   | No se promete exactly-once distribuido; idempotency + inbox + reconcile.                                                       |
| BR-EC08-058 | Outbox lease                                    | Dispatcher usa SKIP LOCKED + owner/lease/recovery.                                                                             |
| BR-EC08-059 | 202 operation status                            | Toda respuesta 202 incluye operationId consultable hasta terminal.                                                             |
| BR-EC08-060 | UNKNOWN_EFFECT                                  | Posible efecto remoto sin respuesta se reconcilia antes de retry.                                                              |
| BR-EC08-061 | Delivery no rollback                            | Delivery post-commit fallida no revierte issuance.                                                                             |
| BR-EC08-062 | Wallet unknown effect                           | Timeout wallet despues de envio se marca UNKNOWN_EFFECT y reconcilia.                                                          |
| BR-EC08-063 | CT-18 mediated                                  | Wallet/OpenBadges/VC/CLR solo por CT-18/adapters; no client vendor ad-hoc.                                                     |
| BR-EC08-064 | Interop schema pinned                           | Payload externo conserva schema/profile versión usada.                                                                         |
| BR-EC08-065 | Policy ref inmutable                            | Todo \*\_policy_ref apunta a PolicyVersion inmutable o equivalente.                                                            |
| BR-EC08-066 | UTC                                             | Instantes oficiales usan timestamptz UTC; presentacion aplica timezone del usuario/institucion.                                |
| BR-EC08-067 | Audit crítico                                   | Award, issue, revoke, correct, supersede, batch, key change registran actor/scope/reason/correlation/policy/evidence.          |
| BR-EC08-068 | PII minimization                                | Persistir solo PII estrictamente requerida para reconstructibilidad/publication; no copiar CT-04 completo.                     |
| BR-EC08-069 | Public display snapshot                         | Nombre/titulo visible emitido se conserva cómo snapshot histórico con purpose definido.                                        |
| BR-EC08-070 | Retention governed                              | Retention/purge/anonymization sigue policy; historia necesaria puede pseudonimizar datos no esenciales sin invalidar evidence. |
| BR-EC08-071 | Key compromise runbook                          | Key compromise activa runbook, status analysis, re-sign/supersede cuándo corresponda y evidence.                               |
| BR-EC08-072 | Template versión pinned                         | Documento emitido referencia template/versión CT-05; cambios futuros no alteran documento histórico.                           |
| BR-EC08-073 | Accessibility                                   | Documento/portal/verifier deben cumplir baseline accesible institucional; QR no es único medio de verificación.                |
| BR-EC08-074 | OpenAPI contract                                | Frontend consume client/DTO generado o validado contra OpenAPI oficial.                                                        |
| BR-EC08-075 | ProblemDetail                                   | Errores REST usan RFC Problem Details y reason codes estables.                                                                 |
| BR-EC08-076 | List bounded                                    | Colecciones definen pageSize máximo, sorting estable, filtros y cursor/offset oficial.                                         |
| BR-EC08-077 | PATCH limitado                                  | PATCH solo metadata mutable autorizada; transiciones usan commands de intencion.                                               |
| BR-EC08-078 | Secure SDLC                                     | High/Critical findings bloquean release salvo excepción formal.                                                                |
| BR-EC08-079 | Runtime role limited                            | HTTP runtime no posee tablas, no BYPASSRLS, no DDL; migrator/worker roles separados.                                           |
| BR-EC08-080 | Verifier DB access restricted                   | Anonimo no recibe SELECT generico; lookup usa gateway/function/service minimizado y revisado.                                  |
| BR-EC08-081 | Security definer hardened                       | Si se usa SECURITY DEFINER, owner dedicado, search_path fijo, input hash validation y EXECUTE mínimo.                          |
| BR-EC08-082 | Redis no authoritative                          | Cache de verifier puede acelerar, pero status truth permanece PostgreSQL/event lineage.                                        |
| BR-EC08-083 | Cache invalidation event                        | Status/revocation/supersede invalida cache publica via event/explicit versión.                                                 |
| BR-EC08-084 | Mongo derived only                              | MongoDB solo read model/document projection derivada, nunca SoT de award/issuance/status.                                      |
| BR-EC08-085 | Migration governed                              | Legacy entra por CT-16 Extract-Normalize-Map-Validate-DryRun-Promote-Receipt-Reconcile.                                        |
| BR-EC08-086 | No invented evidence                            | Migración no inventa hash, policy versión o evidence inexistente; marca provenance/limitations.                                |
| BR-EC08-087 | Legacy verification                             | Credencial legacy puede tener verification profile limitado sin fingir firma inexistente.                                      |
| BR-EC08-088 | AI provenance                                   | Toda sugerencia IA conserva run_ref/model/template/eval/grounding/confidence/reviewer outcome.                                 |
| BR-EC08-089 | AI no decide                                    | IA no marca eligible, no crea award, no emite, no revoca ni supersede por si sola.                                             |
| BR-EC08-090 | AI no inventa facts                             | Explicaciones IA se groundean en facts/refs; no completan ausencia con inferencia.                                             |
| BR-EC08-091 | Operational rejection distinction               | Metricas distinguen business rejection de operational failure.                                                                 |
| BR-EC08-092 | Observability correlation                       | Logs/traces usan correlationId/operationId sin exponer secrets/token plano.                                                    |
| BR-EC08-093 | Token redaction logs                            | Verification token y PII sensible se redactan de logs.                                                                         |
| BR-EC08-094 | SLO verifier                                    | Verifier publico tiene SLO superior a backoffice por impacto reputacional.                                                     |
| BR-EC08-095 | SLO issuance                                    | Issuance mide latency/end-to-end y failure reason sin mezclar ineligible con error.                                            |
| BR-EC08-096 | Reconcile receipts                              | Toda integración con efecto remoto conserva provider receipt/status para reconcile.                                            |
| BR-EC08-097 | Revoke propagation                              | Revocation publica event y genera delivery/status updates a canales externos sin depender de uno solo.                         |
| BR-EC08-098 | Supersede propagation                           | Nueva issuance correctiva actualiza public verifier y perfiles externos por evento idempotente.                                |
| BR-EC08-099 | Evidence pack export                            | Auditor puede exportar evidence pack con lineage sin acceso a secretos de firma.                                               |
| BR-EC08-100 | Verifier response provenance                    | Respuesta publica incluye asOf/statusUpdatedAt y, si policy lo permite, issuer/credential minimal metadata.                    |
| BR-EC08-101 | No enumeration by serial                        | Lookup por serial puede requerir additional token/context; serial solo no debe habilitar enumeracion sensible.                 |
| BR-EC08-102 | Holder authenticated access                     | Portal holder puede mostrar más datos que verifier publico solo tras auth/scope correcto.                                      |
| BR-EC08-103 | Mobile offline stale                            | Credencial cacheada offline se muestra STALE/OFFLINE y no afirma verificación online actual.                                   |
| BR-EC08-104 | QR rotation policy                              | Rotar verification handle no cambia award/issuance; handles previos se deshabilitan con history.                               |
| BR-EC08-105 | Duplicate scan tolerant                         | Verificaciones repetidas no crean side effect académico ni bloquean por defecto salvo abuse policy.                            |
| BR-EC08-106 | Consent not validity                            | Consent de comunicaciones no debe condicionar validez de la credencial salvo requisito legal especifico.                       |
| BR-EC08-107 | Corporate payer not holder                      | Empresa pagadora/cliente no sustituye al holder académico.                                                                     |
| BR-EC08-108 | Evidence source lineage                         | Cada rule fact identifica source_context/source_ref/as_of y outcome.                                                           |
| BR-EC08-109 | Evaluation immutability                         | Evaluation terminal no cambia; nueva policy/fact crea reevaluation vinculada.                                                  |
| BR-EC08-110 | Award revocation independent of source mutation | Cambio posterior de source no revoca award automáticamente; abre case/policy decisión.                                         |
| BR-EC08-111 | Completion restatement handling                 | Restatement upstream dispara impact event/evaluation, no UPDATE silencioso del award.                                          |
| BR-EC08-112 | Financial restatement handling                  | Cambio financiero posterior se trata según policy; no altera history sin case/decisión.                                        |
| BR-EC08-113 | Issuer scope historical                         | Issuance conserva issuer scope/label snapshot; reorganizacion CT-01 no reescribe history.                                      |
| BR-EC08-114 | Legal name correction                           | Cambio de nombre actual no reescribe credenciales pasadas; correction request decide si reissue.                               |
| BR-EC08-115 | Locale independent                              | Cambio de idioma de portal no cambia canonical issuance snapshot.                                                              |
| BR-EC08-116 | Canonicalization deterministic                  | Mismo payload semanticamente igual produce canonical bytes/hash estable bajo schema versión.                                   |
| BR-EC08-117 | Hash algorithm agility                          | Algoritmo de hash se versiona; no hardcode eterno de una sola opcion.                                                          |
| BR-EC08-118 | Signature algorithm agility                     | Signing algorithm/key profile es versionado y rotatable.                                                                       |
| BR-EC08-119 | Status reason privacy                           | Public verifier expone categoria de status, no necesariamente reason privado.                                                  |
| BR-EC08-120 | Revocation evidence privacy                     | Evidence de revocación es restringida; verifier solo muestra projection autorizada.                                            |
| BR-EC08-121 | Batch selection evidence                        | Batch conserva query/input snapshot/hash para saber quienes fueron incluidos.                                                  |
| BR-EC08-122 | Batch replay safe                               | Reejecutar batch tras crash recupera items terminales y continua pendientes sin duplicar.                                      |
| BR-EC08-123 | Provider rate limit                             | Workers respetan rate limit/provider retry-after y backoff; no tormenta de retries.                                            |
| BR-EC08-124 | Circuit breaker                                 | Dependencias remotas usan circuit breaker cuándo aplica y estados UI/ops explicitos.                                           |
| BR-EC08-125 | Timeout budget                                  | Cada adapter define connect/read/overall timeout y owner del retry.                                                            |
| BR-EC08-126 | Public token constant-time compare              | Comparacion de token_hash evita leaks triviales y usa indice apropiado.                                                        |
| BR-EC08-127 | Verification anti-abuse privacy                 | Abuse controls no almacenan IP/device más alla de retention/purpose permitido.                                                 |
| BR-EC08-128 | Release compatibility                           | Migraciones siguen expand/contract N/N-1; rollback destructivo no es estrategia.                                               |
| BR-EC08-129 | Contract tests external                         | CT-05/18/Finance/EC-07 contracts tienen consumer/provider tests.                                                               |
| BR-EC08-130 | SBOM                                            | Release incluye SBOM y scans de dependencias/container/secrets.                                                                |
| BR-EC08-131 | RLS negative tests                              | QA prueba lectura/escritura cross-tenant desde runtime role.                                                                   |
| BR-EC08-132 | Performance batch                               | Performance tests incluyen lotes, serial allocation, outbox backlog y verifier load.                                           |
| BR-EC08-133 | Chaos dependency                                | Resilience tests simulan CT-05/KMS/CT-18 unavailable/timeout/partial.                                                          |
| BR-EC08-134 | Backup restore evidence                         | Restore debe preservar award/issuance/status ordering y verifier correctness.                                                  |
| BR-EC08-135 | Clock monotonic business rules                  | Orden causal no depende solo de client timestamp; server occurred_at y sequence/versión gobiernan.                             |
| BR-EC08-136 | Reason codes stable                             | Reason codes son contractuales y versionables; no texto libre cómo única semántica.                                            |
| BR-EC08-137 | Evidence refs resolvable                        | Antes de issue, evidence refs requeridas deben ser resolubles o fail-closed.                                                   |
| BR-EC08-138 | No silent downgrade                             | Si signing/assurance requerido no esta disponible no se emite una credencial de menor assurance sin policy explicita.          |
| BR-EC08-139 | Public verifier accessibility                   | Verifier ofrece texto y status legible; no depende solo de color/QR.                                                           |
| BR-EC08-140 | Holder correction status                        | Holder ve OPEN/UNDER_REVIEW/APPLIED/REJECTED sin acceso a decisión privada no autorizada.                                      |
| BR-EC08-141 | Audit export immutable snapshot                 | Evidence export identifica asOf y hashes; export posterior no reescribe facts.                                                 |
| BR-EC08-142 | Cumulative source status                        | Award fuente revocado/suspendido se trata según policy versionada; no asumir valido.                                           |
| BR-EC08-143 | Cumulative same holder                          | Awards fuente deben corresponder al mismo holder identity resolution o bridge autorizado.                                      |
| BR-EC08-144 | No cross-tenant stacking                        | Cumulative evaluation no mezcla awards entre tenants salvo contrato federado externo explicito sin FK.                         |
| BR-EC08-145 | Interop revocation semantics                    | Provider externo que no soporte revocation requiere compensating projection/status strategy documentada.                       |
| BR-EC08-146 | Operation progress bounded                      | OperationStatus progress esta entre 0 y 100 y terminal state fija finished_at.                                                 |
| BR-EC08-147 | Outbox poison handling                          | Evento poison se mueve a failed/dead-letter gobernado sin bloquear toda particion.                                             |
| BR-EC08-148 | Idempotency retention                           | Retention de keys cubre ventana maxima de retry/replay definida por operación.                                                 |
| BR-EC08-149 | Issuance effective time                         | issued_at es server-side UTC; no se acepta del cliente cómo hecho oficial.                                                     |
| BR-EC08-150 | Award effective time                            | awarded_at es server-side UTC y evidencia quién/que policy adjudico.                                                           |
| BR-EC08-151 | Status ordering                                 | Status facts usan sequence_no monotonic por issuance para impedir reorder ambiguo.                                             |
| BR-EC08-152 | Public URL canonical                            | URL/QR publica se genera desde configuration segura; no host libre del request.                                                |
| BR-EC08-153 | Download authorization                          | Documento privado requiere auth/short-lived link CT-05; verifier publico no expone storage URL directa.                        |
| BR-EC08-154 | Document hash verify                            | Cuando documento se descarga/verifica, hash puede compararse con binding para integrity evidence.                              |
| BR-EC08-155 | Key reference historical                        | Key rotation no cambia signing_receipt histórico; receipt conserva key_ref utilizado.                                          |
| BR-EC08-156 | Provider receipt immutable                      | Receipts de provider terminales son append-only o restated, no overwritten.                                                    |
| BR-EC08-157 | Correlation chain                               | correlation_id y causation_id conectan eligibility-award-issuance-delivery-status.                                             |
| BR-EC08-158 | External status reconciliation                  | Reconcile de wallet/provider no modifica academic fact; actualiza delivery/external projection state.                          |
| BR-EC08-159 | Business continuity verifier                    | Modo degradado puede servir last-known signed status con STALE claro solo si CT-17/policy lo autoriza.                         |
| BR-EC08-160 | Data quality before migration                   | Legacy duplicate serial/holder ambiguity se resuelve o cuarentena; no se fuerza promotion.                                     |
| BR-EC08-161 | Dry run evidence                                | CT-16 dry-run produce report reproducible y no persiste truth final.                                                           |
| BR-EC08-162 | Promotion through domain                        | Migración promueve via domain/API/application service con mismas invariantes que operación normal.                             |
| BR-EC08-163 | Golden scenario gate                            | G8 no cierra sin golden scenarios criticos automatizados y evidence de UAT.                                                    |
| BR-EC08-164 | Release certificate                             | G10 exige evidence pack de data constraints, security, contracts, performance, restore y runbooks.                             |

# 10. Casos de uso UC-EC08

| **ID**      | **Caso de uso**                                | **Actor primario**    |
|-------------|------------------------------------------------|-----------------------|
| UC-EC08-001 | Evaluar elegibilidad individual                | Credential Operator   |
| UC-EC08-002 | Reevaluar elegibilidad por nuevo fact/policy   | Credential Operator   |
| UC-EC08-003 | Consultar rule facts y explicación             | Reviewer/Auditor      |
| UC-EC08-004 | Crear CredentialAward desde ELIGIBLE           | Credential Operator   |
| UC-EC08-005 | Consultar award y lineage                      | Staff/Holder          |
| UC-EC08-006 | Emitir credencial individual                   | Credential Operator   |
| UC-EC08-007 | Asignar serial de credencial                   | Application Service   |
| UC-EC08-008 | Construir payload canonico                     | Application Service   |
| UC-EC08-009 | Crear documento CT-05                          | Application Service   |
| UC-EC08-010 | Solicitar firma/sello                          | Application Service   |
| UC-EC08-011 | Crear VerificationHandle                       | Application Service   |
| UC-EC08-012 | Verificar credencial publicamente              | Public Verifier       |
| UC-EC08-013 | Verificar credencial autenticada               | Authorized Verifier   |
| UC-EC08-014 | Descargar credencial cómo holder               | Holder                |
| UC-EC08-015 | Regenerar render no material                   | Credential Operator   |
| UC-EC08-016 | Solicitar corrección                           | Holder/Support        |
| UC-EC08-017 | Clasificar corrección                          | Credential Reviewer   |
| UC-EC08-018 | Aprobar/rechazar corrección                    | Credential Governance |
| UC-EC08-019 | Aplicar corrección material                    | Credential Operator   |
| UC-EC08-020 | Crear superseding issuance                     | Credential Operator   |
| UC-EC08-021 | Abrir caso de revocación                       | Credential Governance |
| UC-EC08-022 | Investigar revocación                          | Credential Reviewer   |
| UC-EC08-023 | Aprobar/rechazar revocación                    | Credential Governance |
| UC-EC08-024 | Aplicar suspension                             | Credential Governance |
| UC-EC08-025 | Reinstalar desde suspension                    | Credential Governance |
| UC-EC08-026 | Aplicar revocación                             | Credential Governance |
| UC-EC08-027 | Void por error operacional excepcional         | Credential Governance |
| UC-EC08-028 | Consultar history de status                    | Auditor/Support       |
| UC-EC08-029 | Restatar status fact                           | Credential Governance |
| UC-EC08-030 | Emitir BadgeAssertion                          | Credential Operator   |
| UC-EC08-031 | Publicar badge por CT-18                       | Interop Worker        |
| UC-EC08-032 | Crear MicrocredentialRecord                    | Credential Operator   |
| UC-EC08-033 | Entregar por email                             | Delivery Worker       |
| UC-EC08-034 | Entregar por portal                            | Application Service   |
| UC-EC08-035 | Entregar a wallet                              | Interop Worker        |
| UC-EC08-036 | Reconciliar wallet UNKNOWN_EFFECT              | Ops/Interop Worker    |
| UC-EC08-037 | Rotar verification handle                      | Credential Governance |
| UC-EC08-038 | Deshabilitar handle comprometido               | Security/Ops          |
| UC-EC08-039 | Crear batch de credenciales                    | Credential Operator   |
| UC-EC08-040 | Preflight de batch                             | Credential Operator   |
| UC-EC08-041 | Sellar batch                                   | Credential Reviewer   |
| UC-EC08-042 | Ejecutar batch                                 | Batch Worker          |
| UC-EC08-043 | Reintentar items fallidos                      | Batch Worker          |
| UC-EC08-044 | Cancelar batch no iniciado                     | Credential Governance |
| UC-EC08-045 | Consultar resultado parcial de batch           | Credential Operator   |
| UC-EC08-046 | Evaluar credential acumulativa                 | Credential Operator   |
| UC-EC08-047 | Adjuntar awards fuente a cumulative evaluation | Application Service   |
| UC-EC08-048 | Crear cumulative award                         | Credential Operator   |
| UC-EC08-049 | Emitir cumulative credential                   | Credential Operator   |
| UC-EC08-050 | Consumir CompletionFact EC-07                  | Integration Adapter   |
| UC-EC08-051 | Consumir restatement de CompletionFact         | Integration Adapter   |
| UC-EC08-052 | Consumir financial regularity fact             | Finance Adapter       |
| UC-EC08-053 | Consumir identity assurance                    | Identity Adapter      |
| UC-EC08-054 | Consumir blueprint publicado EC-01             | EC-01 Adapter         |
| UC-EC08-055 | Publicar award event para EC-10                | Outbox Worker         |
| UC-EC08-056 | Publicar status change event                   | Outbox Worker         |
| UC-EC08-057 | Publicar supersession event                    | Outbox Worker         |
| UC-EC08-058 | Exportar evidence pack                         | Auditor               |
| UC-EC08-059 | Consultar OperationStatus                      | Frontend/Ops          |
| UC-EC08-060 | Reconciliar operation UNKNOWN_EFFECT           | Ops                   |
| UC-EC08-061 | Claim/reclaim outbox                           | Outbox Worker         |
| UC-EC08-062 | Recuperar idempotency lease vencido            | Application Service   |
| UC-EC08-063 | Importar credenciales legacy dry-run           | Data Steward          |
| UC-EC08-064 | Promover batch legacy                          | Data Steward          |
| UC-EC08-065 | Reconciliar legacy document refs               | Data Steward          |
| UC-EC08-066 | Solicitar explicación IA de ineligibility      | Credential Operator   |
| UC-EC08-067 | Detectar anomalías de batch con IA             | Credential Reviewer   |
| UC-EC08-068 | Aceptar/rechazar sugerencia IA                 | Credential Reviewer   |
| UC-EC08-069 | Consultar metricas de issuance                 | Governance/Ops        |
| UC-EC08-070 | Invalidar cache de verifier                    | Application Service   |
| UC-EC08-071 | Probar tenant isolation RLS                    | Security/QA           |
| UC-EC08-072 | Ejecutar load test verifier                    | Performance QA        |
| UC-EC08-073 | Rotar signing key reference                    | Security/Ops          |
| UC-EC08-074 | Responder incidente key compromise             | Security/Ops          |
| UC-EC08-075 | Auditar provider receipts                      | Auditor               |
| UC-EC08-076 | Consultar credencial en mobile                 | Holder                |
| UC-EC08-077 | Mostrar QR en mobile                           | Holder                |
| UC-EC08-078 | Escanear/verificar QR en mobile                | Holder/Public         |
| UC-EC08-079 | Reportar problema desde mobile                 | Holder                |
| UC-EC08-080 | Reprocesar provider delivery                   | Ops                   |
| UC-EC08-081 | Cerrar revocation/correction case              | Credential Governance |

## 10.1 Casos criticos desarrollados

### UC-EC08-001 — Evaluar elegibilidad individual

| **Aspecto**                   | **Detalle**                                                                                                              |
|-------------------------------|--------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Credential Operator                                                                                                      |
| Trigger                       | Solicitud de certificacion                                                                                               |
| Precondiciones / autorización | Blueprint publicado, holder/enrollment y CompletionFact resolubles; scope valido                                         |
| Happy Path                    | Crea evaluation PENDING, resuelve policies/facts, genera rule facts, calcula ELIGIBLE/INELIGIBLE y policy_snapshot_hash. |
| Alternativas / errores        | Dependencia crítica unavailable =\> ERROR/503 o async operation; nunca asumir PASS.                                      |
| Idempotencia                  | Idempotency-Key recomendado si comando persiste evaluation.                                                              |
| Concurrencia                  | Source refs pinneados; nueva evidencia crea reevaluation.                                                                |
| Auditoría / side effects      | Audit + optional outbox EligibilityEvaluated.                                                                            |
| Postcondicion                 | Evaluation terminal reconstruible.                                                                                       |

### UC-EC08-004 — Crear CredentialAward

| **Aspecto**                   | **Detalle**                                                                                      |
|-------------------------------|--------------------------------------------------------------------------------------------------|
| Actor                         | Credential Operator                                                                              |
| Trigger                       | Evaluation ELIGIBLE                                                                              |
| Precondiciones / autorización | ELIGIBLE terminal, actor autorizado, no award semantico existente                                |
| Happy Path                    | Lock semantic key, revalidate eligibility/policy, crea award AWARDED, evidence bindings, outbox. |
| Alternativas / errores        | Duplicate =\> replay existing o 409 según idempotency; policy changed =\> 422 reevaluate.        |
| Idempotencia                  | Idempotency-Key obligatorio.                                                                     |
| Concurrencia                  | Unique semantic constraint + transaction lock.                                                   |
| Auditoría / side effects      | Audit award + correlation lineage.                                                               |
| Postcondicion                 | Award único durable.                                                                             |

### UC-EC08-006 — Emitir credencial individual

| **Aspecto**                   | **Detalle**                                                                                                                                                     |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Credential Operator                                                                                                                                             |
| Trigger                       | Award listo para issuance                                                                                                                                       |
| Precondiciones / autorización | Award AWARDED, blueprint/policies, issuer scope, identity assurance y evidence resolubles                                                                       |
| Happy Path                    | Reserva issuance_no/serial; construye canonical payload; document/sign; persiste snapshot/receipts; activa verification handle; status ISSUED; outbox/delivery. |
| Alternativas / errores        | CT-05/KMS timeout con posible efecto =\> OperationStatus/UNKNOWN_EFFECT y reconcile; no duplicar serial/document.                                               |
| Idempotencia                  | Idempotency-Key obligatorio.                                                                                                                                    |
| Concurrencia                  | Lock award + unique serial + If-Match cuándo root mutable.                                                                                                      |
| Auditoría / side effects      | Audit high-assurance + evidence pack refs.                                                                                                                      |
| Postcondicion                 | Issuance inmutable y verificable.                                                                                                                               |

### UC-EC08-012 — Verificar credencial publicamente

| **Aspecto**                   | **Detalle**                                                                                                         |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------|
| Actor                         | Public Verifier                                                                                                     |
| Trigger                       | Escaneo QR/token                                                                                                    |
| Precondiciones / autorización | Token presentado; endpoint publico habilitado                                                                       |
| Happy Path                    | Hash token, lookup restringido, deriva status actual, devuelve projection minima con asOf/statusUpdatedAt.          |
| Alternativas / errores        | No match =\> 404 generico; backend unavailable =\> 503/UNAVAILABLE; no revelar diferencia que facilite enumeration. |
| Idempotencia                  | Read-only; request puede cachearse por token hash/status versión.                                                   |
| Concurrencia                  | No academic mutation.                                                                                               |
| Auditoría / side effects      | Security telemetry minimizada; no token plano en logs.                                                              |
| Postcondicion                 | Respuesta VALID/SUSPENDED/REVOKED/SUPERSEDED/EXPIRED/UNAVAILABLE según contract.                                    |

### UC-EC08-016 — Solicitar corrección

| **Aspecto**                   | **Detalle**                                                                                                    |
|-------------------------------|----------------------------------------------------------------------------------------------------------------|
| Actor                         | Holder/Support                                                                                                 |
| Trigger                       | Datos visibles incorrectos                                                                                     |
| Precondiciones / autorización | Holder auth o support scope; issuance existente                                                                |
| Happy Path                    | Crea CorrectionRequest con claimed issue y evidence refs; clasificación posterior decide render-only/material. |
| Alternativas / errores        | Solicitud duplicada se deduplica o devuelve case abierto.                                                      |
| Idempotencia                  | Idempotency-Key.                                                                                               |
| Concurrencia                  | If-Match en case, no en issuance emitido.                                                                      |
| Auditoría / side effects      | Audit purpose/reason.                                                                                          |
| Postcondicion                 | Case rastreable.                                                                                               |

### UC-EC08-019 — Aplicar corrección material

| **Aspecto**                   | **Detalle**                                                                                                                  |
|-------------------------------|------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Credential Operator                                                                                                          |
| Trigger                       | Correction approved MATERIAL                                                                                                 |
| Precondiciones / autorización | Decisión aprobada, step-up/SoD cuándo policy                                                                                 |
| Happy Path                    | Crea nuevo issuance desde award con corrected snapshot, link supersession; old status SUPERSEDED; actualiza verifier/outbox. |
| Alternativas / errores        | Fallo remoto =\> operation/reconcile; no mutar old payload.                                                                  |
| Idempotencia                  | Idempotency-Key obligatorio.                                                                                                 |
| Concurrencia                  | Unique supersession + transaction; old/new ordering validada.                                                                |
| Auditoría / side effects      | Audit + evidence decisión.                                                                                                   |
| Postcondicion                 | Old SUPERSEDED, new ISSUED.                                                                                                  |

### UC-EC08-026 — Aplicar revocación

| **Aspecto**                   | **Detalle**                                                                                                 |
|-------------------------------|-------------------------------------------------------------------------------------------------------------|
| Actor                         | Credential Governance                                                                                       |
| Trigger                       | Revocation decisión approved                                                                                |
| Precondiciones / autorización | Case approved; evidence; step-up; actor autorizado/SoD                                                      |
| Happy Path                    | Append status REVOKED, decisión applied, invalidate cache, publish events, trigger provider status updates. |
| Alternativas / errores        | Provider unavailable no revierte local status; delivery projection retries/reconciles.                      |
| Idempotencia                  | Idempotency-Key.                                                                                            |
| Concurrencia                  | Case If-Match + status sequence.                                                                            |
| Auditoría / side effects      | High assurance audit.                                                                                       |
| Postcondicion                 | Verifier refleja REVOKED.                                                                                   |

### UC-EC08-035 — Entregar a wallet

| **Aspecto**                   | **Detalle**                                                                                              |
|-------------------------------|----------------------------------------------------------------------------------------------------------|
| Actor                         | Interop Worker                                                                                           |
| Trigger                       | Delivery request                                                                                         |
| Precondiciones / autorización | ISSUED, profile CT-18 permitido                                                                          |
| Happy Path                    | Mapea canonical payload a profile, envia con provider idempotency/correlation, guarda receipt DELIVERED. |
| Alternativas / errores        | Timeout despues de send =\> UNKNOWN_EFFECT, consulta provider status; retry solo si no aplicado.         |
| Idempotencia                  | Provider/local key durable.                                                                              |
| Concurrencia                  | Lease worker + request state.                                                                            |
| Auditoría / side effects      | Provider receipt + trace.                                                                                |
| Postcondicion                 | Delivery terminal/reconciled.                                                                            |

### UC-EC08-042 — Ejecutar batch

| **Aspecto**                   | **Detalle**                                                                                                                             |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Batch Worker                                                                                                                            |
| Trigger                       | Batch SEALED                                                                                                                            |
| Precondiciones / autorización | Input hash, limits, actor/policy, items preparados                                                                                      |
| Happy Path                    | Claim items por chunks; por item ejecuta same single issuance command; terminales se preservan; batch calcula COMPLETED/PARTIAL/FAILED. |
| Alternativas / errores        | Un item falla sin rollback global; provider outage pausa/retry según policy.                                                            |
| Idempotencia                  | Batch + item idempotency.                                                                                                               |
| Concurrencia                  | SKIP LOCKED/lease para workers; unique semantic award/serial.                                                                           |
| Auditoría / side effects      | Metrics + per-item evidence.                                                                                                            |
| Postcondicion                 | Todos los items terminales o recoverable explicitamente.                                                                                |

### UC-EC08-046 — Evaluar credential acumulativa

| **Aspecto**                   | **Detalle**                                                                                                                     |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Credential Operator                                                                                                             |
| Trigger                       | Holder solicita cumulative credential                                                                                           |
| Precondiciones / autorización | Target blueprint/pathway y source awards resolubles                                                                             |
| Happy Path                    | Crea CumulativeEvaluation, pinnea source awards/status, aplica policy, produce ELIGIBLE/INELIGIBLE; si eligible continua award. |
| Alternativas / errores        | Source revoked/identity mismatch =\> fail/needs review según policy.                                                            |
| Idempotencia                  | Idempotent by target/holder/source-set hash.                                                                                    |
| Concurrencia                  | Snapshot de sources; no mutation en EC-10.                                                                                      |
| Auditoría / side effects      | Audit lineage.                                                                                                                  |
| Postcondicion                 | Decisión reproducible.                                                                                                          |

### UC-EC08-050 — Consumir CompletionFact EC-07

| **Aspecto**                   | **Detalle**                                                                                                     |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------|
| Actor                         | Integration Adapter                                                                                             |
| Trigger                       | Event CompletionFactPublished/Restated                                                                          |
| Precondiciones / autorización | Contract versión soportado                                                                                      |
| Happy Path                    | Inbox dedup, valida tenant/ref, actualiza read reference/impact queue, dispara eligibility candidate si policy. |
| Alternativas / errores        | Duplicate ignored; unsupported schema =\> quarantine/dead-letter.                                               |
| Idempotencia                  | Inbox message_id.                                                                                               |
| Concurrencia                  | No direct cross-context FK.                                                                                     |
| Auditoría / side effects      | Trace causation/correlation.                                                                                    |
| Postcondicion                 | Hecho disponible para evaluate sin copiar nota completa.                                                        |

### UC-EC08-060 — Reconciliar operation UNKNOWN_EFFECT

| **Aspecto**                   | **Detalle**                                                                                                                          |
|-------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Ops                                                                                                                                  |
| Trigger                       | Operation stuck/timeout                                                                                                              |
| Precondiciones / autorización | operationId + adapter receipt/correlation                                                                                            |
| Happy Path                    | Consulta remote status, correlaciona provider receipt, determina SUCCEEDED/FAILED/UNKNOWN; aplica solo completion local idempotente. |
| Alternativas / errores        | Sin evidencia suficiente permanece UNKNOWN y escala; no retry ciego.                                                                 |
| Idempotencia                  | Reconcile idempotente.                                                                                                               |
| Concurrencia                  | Lease operation.                                                                                                                     |
| Auditoría / side effects      | Ops audit.                                                                                                                           |
| Postcondicion                 | Estado explicable.                                                                                                                   |

### UC-EC08-063 — Importar credenciales legacy dry-run

| **Aspecto**                   | **Detalle**                                                                                                               |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Data Steward                                                                                                              |
| Trigger                       | Migración                                                                                                                 |
| Precondiciones / autorización | Batch CT-16 preparado                                                                                                     |
| Happy Path                    | Mapea holder/program/serial/document; detecta duplicados, missing evidence/hash, genera report sin persistir truth final. |
| Alternativas / errores        | Ambiguedad =\> quarantine; no inventar signature/policy history.                                                          |
| Idempotencia                  | Batch idempotency.                                                                                                        |
| Concurrencia                  | No locks prolongados.                                                                                                     |
| Auditoría / side effects      | Lineage/source key.                                                                                                       |
| Postcondicion                 | DryRunReport certificable.                                                                                                |

### UC-EC08-066 — Solicitar explicación IA de ineligibility

| **Aspecto**                   | **Detalle**                                                                                       |
|-------------------------------|---------------------------------------------------------------------------------------------------|
| Actor                         | Credential Operator                                                                               |
| Trigger                       | Necesita explicar decisión                                                                        |
| Precondiciones / autorización | Evaluation existente; purpose permitido                                                           |
| Happy Path                    | CT-12 recibe rule facts permitidos y genera borrador grounded; usuario revisa; no cambia outcome. |
| Alternativas / errores        | CT-12 unavailable =\> explicación determinista no-IA sigue disponible.                            |
| Idempotencia                  | AI run request idempotent opcional.                                                               |
| Concurrencia                  | Read-only facts.                                                                                  |
| Auditoría / side effects      | run/model/template/eval/grounding refs.                                                           |
| Postcondicion                 | Draft explicativo, no decisión.                                                                   |

### UC-EC08-072 — Probar tenant isolation RLS

| **Aspecto**                   | **Detalle**                                                                                                     |
|-------------------------------|-----------------------------------------------------------------------------------------------------------------|
| Actor                         | Security/QA                                                                                                     |
| Trigger                       | Gate seguridad                                                                                                  |
| Precondiciones / autorización | Runtime role realista                                                                                           |
| Happy Path                    | SET tenant A, intenta leer/escribir IDs tenant B y operaciones sin context; todo debe fallar/no retornar filas. |
| Alternativas / errores        | BYPASSRLS/owner usage =\> gate failure.                                                                         |
| Idempotencia                  | N/A.                                                                                                            |
| Concurrencia                  | DB policy enforcement.                                                                                          |
| Auditoría / side effects      | Test evidence.                                                                                                  |
| Postcondicion                 | G6 no cierra sin prueba.                                                                                        |

### UC-EC08-074 — Rotar signing key reference

| **Aspecto**                   | **Detalle**                                                                                                            |
|-------------------------------|------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Security/Ops                                                                                                           |
| Trigger                       | Key lifecycle                                                                                                          |
| Precondiciones / autorización | Nueva key KMS valida + policy                                                                                          |
| Happy Path                    | Nuevas issuances usan nuevo key_ref; receipts historicos conservan key anterior; verifier no reescribe firmas pasadas. |
| Alternativas / errores        | Key unavailable =\> no silent downgrade.                                                                               |
| Idempotencia                  | Change request idempotent.                                                                                             |
| Concurrencia                  | Config/policy revisión.                                                                                                |
| Auditoría / side effects      | High assurance audit.                                                                                                  |
| Postcondicion                 | Agility sin romper history.                                                                                            |

# 11. DER conceptual, logico y físico

## 11.1 DER conceptual

El modelo conceptual se organiza alrededor de tres hechos sucesivos: CredentialEligibilityEvaluation determina si se satisfacen las condiciones; CredentialAward registra la adjudicacion institucional; CredentialIssuance registra cada representacion oficial emitida. Status facts y decisions gobiernan lifecycle sin editar history. Delivery, BadgeAssertion, WalletDelivery y documentos son proyecciones/efectos derivados.

## 11.2 DER logico

Todas las relaciones internas EC-08 son tenant-aware. Award referencia una evaluation local; Issuance pertenece a Award y a IssuanceRequest; payload/document/signing/status/verification pertenecen a Issuance. RevocationCase y CorrectionRequest apuntan a Issuance; sus decisions son append-only. CumulativeEvaluation agrega items y puede producir un target award. Batch agrega items. Idempotency, outbox, inbox y operation status soportan confiabilidad operacional.

## 11.3 DER físico resumido

<img src="media/image4.png" style="width:6.7in;height:4.02in" />

Figura 4 — DER físico resumido EC-08

| **REGLA DE FK — Todas las FKs fisicas del esquema ec08 son internas y tenant-aware. EC-01, EC-04, EC-07, EC-10, CT-01...CT-18, IAM, Finanzas y proveedores se referencian cómo EXT REF por contratos; una migration no debe introducir FK cross-context por comodidad.** |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 12. Modelo físico PostgreSQL tabla por tabla

El esquema propuesto es ec08. PostgreSQL es Source of Truth de award, issuance, status y receipts. Las tablas tenant-owned utilizan tenant_id, RLS ENABLE+FORCE y roles separados. Las invariantes que pueden expresarse fisicamente se protegen con PK, FK tenant-aware, UNIQUE, CHECK, indices parciales y triggers defensivos.

| **PREGUNTA OBLIGATORIA — Para cada tabla se responde: Que error debe impedir PostgreSQL aunque Backend tenga un bug? La respuesta debe existir en constraints ejecutables, no solo en una recomendacion narrativa.** |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.1 ec08_credential_eligibility_evaluation

QUE REPRESENTA — Representa una decisión puntual y reconstruible de elegibilidad para una credencial. No es el CompletionFact ni el award; captura que facts y policy versión fueron evaluados y cual fue el outcome.

COMO PARTICIPA ARQUITECTONICAMENTE — La crea Credential Application Service a partir de holder/enrollment, CredentialBlueprint EC-01 y facts oficiales cómo CompletionFact EC-07. Agrega rule facts. Una evaluation terminal nunca se reescribe; un cambio de policy o fact crea otra evaluation relacionada.

QUE PROTEGE / QUE NO REPRESENTA — Protege que ELIGIBLE no pueda existir sin blueprint/subject/policy context y evita reinterpretar silenciosamente una decisión historica. No representa emisión, documento ni progreso de pathway.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                               | **Ejemplo**        |
|---------------------------|---------------------|----------|-------------------|---------------------|-----------------------------------------------|--------------------|
| tenant_id                 | uuid                | NO       | --                | PK\*                | Tenant derivado del contexto autorizado.      | 8a6...             |
| eligibility_evaluation_id | uuid                | NO       | gen_random_uuid() | PK                  | Identificador técnico estable.                | id...              |
| subject_ref               | uuid                | NO       | --                | EXT REF CT-04/EC-04 | Holder/subject evaluado.                      | sub...             |
| enrollment_ref            | uuid                | YES      | NULL              | EXT REF EC-04       | Enrollment concreto cuándo aplica.            | enr...             |
| credential_blueprint_ref  | uuid                | NO       | --                | EXT REF EC-01       | Blueprint publicado pinneado.                 | cbp...             |
| completion_fact_ref       | uuid                | YES      | NULL              | EXT REF EC-07       | CompletionFact oficial cuándo policy lo usa.  | cmp...             |
| eligibility_policy_ref    | uuid                | NO       | --                | EXT REF CT-02       | PolicyVersion inmutable de eligibility.       | pol...             |
| state                     | varchar(24)         | NO       | 'PENDING'         | CHECK               | PENDING/EVALUATING/ELIGIBLE/INELIGIBLE/ERROR. | ELIGIBLE           |
| policy_snapshot_hash      | varchar(128)        | YES      | NULL              | --                  | Hash del contexto/policies evaluado.          | sha256:...         |
| evaluated_at              | timestamptz         | YES      | NULL              | --                  | Instante UTC terminal de evaluación.          | 2026-09-11T13:05Z  |
| reason_code               | varchar(80)         | YES      | NULL              | --                  | Reason code terminal principal.               | ELIGIBLE_ALL_RULES |
| created_at                | timestamptz         | NO       | now()             | --                  | Instante UTC de creacion.                     | 2026-09-11T13:00Z  |
| updated_at                | timestamptz         | NO       | now()             | --                  | Última mutacion permitida.                    | 2026-09-11T13:10Z  |
| versión                   | bigint              | NO       | 0                 | --                  | Optimistic lock / aggregate revisión.         | 3                  |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**eligibility_evaluation_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**subject_ref —** Holder/subject evaluado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: sub....

**enrollment_ref —** Enrollment concreto cuándo aplica. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: enr....

**credential_blueprint_ref —** Blueprint publicado pinneado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: cbp....

**completion_fact_ref —** CompletionFact oficial cuándo policy lo usa. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: cmp....

**eligibility_policy_ref —** PolicyVersion inmutable de eligibility. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol....

**state —** PENDING/EVALUATING/ELIGIBLE/INELIGIBLE/ERROR. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: ELIGIBLE.

**policy_snapshot_hash —** Hash del contexto/policies evaluado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**evaluated_at —** Instante UTC terminal de evaluación. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:05Z.

**reason_code —** Reason code terminal principal. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: ELIGIBLE_ALL_RULES.

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**                            | **Tipo** | **Definicion/expresion**                                                          | **Error que impide**                                                                   |
|----------------------------------------------|----------|-----------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_eligibility_evaluation    | PK       | PRIMARY KEY (tenant_id, eligibility_evaluation_id)                                | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_credential_eligibility_evaluation_01 | CHECK    | CHECK (state IN ('PENDING','EVALUATING','ELIGIBLE','INELIGIBLE','ERROR'))         | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_credential_eligibility_evaluation_02 | CHECK    | CHECK ((state IN ('ELIGIBLE','INELIGIBLE','ERROR')) = (evaluated_at IS NOT NULL)) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_eligibility_evaluation   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                  | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec08_credential_eligibility_rule_fact

QUE REPRESENTA — Representa el resultado atomico de una regla de eligibility. Cada fila declara la regla, la fuente oficial consultada, el instante de observacion, el outcome y evidence minima.

COMO PARTICIPA ARQUITECTONICAMENTE — Es hijo append-only de CredentialEligibilityEvaluation. Se genera durante evaluate y puede referenciar EC-07, Finanzas, CT-15 u otra fuente mediante EXT REF. El evaluator terminaliza la evaluation solo despues de registrar todos los rule facts requeridos.

QUE PROTEGE / QUE NO REPRESENTA — Protege provenance y explicabilidad. No guarda la nota completa ni copia el ledger financiero. Un fact UNKNOWN no se transforma en PASS por default.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                               | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------|-----------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.      | 8a6...            |
| rule_fact_id              | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                | id...             |
| eligibility_evaluation_id | uuid                | NO       | --                | FK            | Evaluation padre del mismo tenant.            | ee...             |
| rule_code                 | varchar(80)         | NO       | --                | UQ\*          | Código estable de regla dentro de evaluation. | COMPLETION_PASS   |
| source_context            | varchar(48)         | NO       | --                | CHECK         | Contexto propietario del fact.                | EC-07             |
| source_ref                | uuid                | YES      | NULL              | EXT REF       | Referencia al fact fuente.                    | fact...           |
| source_as_of              | timestamptz         | YES      | NULL              | --            | Instante/provenance del fact.                 | 2026-09-11T12:00Z |
| outcome                   | varchar(24)         | NO       | --                | CHECK         | PASS/FAIL/UNKNOWN/NOT_APPLICABLE.             | PASS              |
| reason_code               | varchar(80)         | NO       | --                | --            | Reason code verificable.                      | COMPLETION_PASSED |
| evidence_ref              | uuid                | YES      | NULL              | EXT REF CT-05 | Evidence opcional.                            | ev...             |
| created_at                | timestamptz         | NO       | now()             | --            | Instante UTC append-only.                     | ...               |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**rule_fact_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**eligibility_evaluation_id —** Evaluation padre del mismo tenant. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: ee....

**rule_code —** Código estable de regla dentro de evaluation. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: COMPLETION_PASS.

**source_context —** Contexto propietario del fact. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: EC-07.

**source_ref —** Referencia al fact fuente. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: fact....

**source_as_of —** Instante/provenance del fact. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T12:00Z.

**outcome —** PASS/FAIL/UNKNOWN/NOT_APPLICABLE. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: PASS.

**reason_code —** Reason code verificable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: COMPLETION_PASSED.

**evidence_ref —** Evidence opcional. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ev....

**created_at —** Instante UTC append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                                     | **Tipo** | **Definicion/expresion**                                      | **Error que impide**                                                                   |
|-------------------------------------------------------|----------|---------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_eligibility_rule_fact              | PK       | PRIMARY KEY (tenant_id, rule_fact_id)                         | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_credential_eligibility_rule_fact_01           | CHECK    | CHECK (outcome IN ('PASS','FAIL','UNKNOWN','NOT_APPLICABLE')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_credential_eligibility_rule_fact_02           | UQ/INDEX | UNIQUE (tenant_id, eligibility_evaluation_id, rule_code)      | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_eligibility_rule_fact             | RLS      | tenant_id = current_setting('peopleu.tenant_id')              | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_credential_eligibility_rule_fact_append_only | TRIGGER  | FORBID UPDATE/DELETE                                          | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec08_credential_award

QUE REPRESENTA — Representa el hecho institucional de que un holder obtuvo una credencial definida por un blueprint. Es independiente del PDF, QR, email o wallet usados para representarla.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea solo desde una evaluation ELIGIBLE o una excepción formal policy-governed. Es Aggregate Root para evidence bindings e issuances. EC-10 consume award/status facts, mientras EC-08 conserva ownership del award.

QUE PROTEGE / QUE NO REPRESENTA — Protege contra awards duplicados y separa academic adjudication de technical issuance. No representa payment, delivery ni documento.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                          | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------------|------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | --                | PK\*                | Tenant derivado del contexto autorizado. | 8a6...            |
| credential_award_id       | uuid                | NO       | gen_random_uuid() | PK                  | Identificador técnico estable.           | id...             |
| award_code                | varchar(96)         | NO       | --                | UQ                  | Código institucional estable.            | AWD-2026-000123   |
| subject_ref               | uuid                | NO       | --                | EXT REF CT-04/EC-04 | Holder beneficiario.                     | sub...            |
| enrollment_ref            | uuid                | YES      | NULL              | EXT REF EC-04       | Enrollment que sustenta el award.        | enr...            |
| credential_blueprint_ref  | uuid                | NO       | --                | EXT REF EC-01       | Blueprint pinneado.                      | cbp...            |
| eligibility_evaluation_id | uuid                | NO       | --                | FK                  | Evaluation ELIGIBLE que sustenta award.  | ee...             |
| award_policy_ref          | uuid                | NO       | --                | EXT REF CT-02       | PolicyVersion de adjudicacion.           | pol...            |
| state                     | varchar(24)         | NO       | 'AWARDED'         | CHECK               | AWARDED/SUSPENDED/REVOKED/VOID.          | AWARDED           |
| awarded_at                | timestamptz         | NO       | now()             | --                  | Instante oficial server-side.            | 2026-09-11T13:20Z |
| awarded_by_subject        | uuid                | NO       | --                | EXT REF IAM         | Actor responsable.                       | usr...            |
| reason_code               | varchar(80)         | NO       | 'ELIGIBLE'        | --                  | Reason code de award.                    | ELIGIBLE          |
| created_at                | timestamptz         | NO       | now()             | --                  | Instante UTC de creacion.                | 2026-09-11T13:00Z |
| updated_at                | timestamptz         | NO       | now()             | --                  | Última mutacion permitida.               | 2026-09-11T13:10Z |
| versión                   | bigint              | NO       | 0                 | --                  | Optimistic lock / aggregate revisión.    | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**credential_award_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**award_code —** Código institucional estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: AWD-2026-000123.

**subject_ref —** Holder beneficiario. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: sub....

**enrollment_ref —** Enrollment que sustenta el award. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: enr....

**credential_blueprint_ref —** Blueprint pinneado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: cbp....

**eligibility_evaluation_id —** Evaluation ELIGIBLE que sustenta award. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: ee....

**award_policy_ref —** PolicyVersion de adjudicacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol....

**state —** AWARDED/SUSPENDED/REVOKED/VOID. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'AWARDED'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: AWARDED.

**awarded_at —** Instante oficial server-side. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:20Z.

**awarded_by_subject —** Actor responsable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**reason_code —** Reason code de award. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'ELIGIBLE'; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: ELIGIBLE.

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**           | **Tipo** | **Definicion/expresion**                                  | **Error que impide**                                                                   |
|-----------------------------|----------|-----------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_award    | PK       | PRIMARY KEY (tenant_id, credential_award_id)              | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_credential_award_01 | CHECK    | CHECK (state IN ('AWARDED','SUSPENDED','REVOKED','VOID')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_credential_award_02 | UQ/INDEX | UNIQUE (tenant_id, award_code)                            | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_award   | RLS      | tenant_id = current_setting('peopleu.tenant_id')          | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.4 ec08_award_evidence_ref

QUE REPRESENTA — Vincula un CredentialAward con evidence institucional o facts externos relevantes sin copiar blobs ni datos ajenos completos.

COMO PARTICIPA ARQUITECTONICAMENTE — Es hijo append-only del award. Puede referenciar CT-05, EC-07, CT-15, Finanzas o receipts internos. La coleccion forma parte del Evidence Pack de award.

QUE PROTEGE / QUE NO REPRESENTA — Protege que una adjudicacion pueda demostrar sus fundamentos. No se usa para crear FKs cross-context ni para almacenar documentos.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                          | **Ejemplo**     |
|-----------------------|---------------------|----------|-------------------|-----------|------------------------------------------|-----------------|
| tenant_id             | uuid                | NO       | --                | PK\*      | Tenant derivado del contexto autorizado. | 8a6...          |
| award_evidence_ref_id | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico estable.           | id...           |
| credential_award_id   | uuid                | NO       | --                | FK        | Award padre.                             | awd...          |
| evidence_kind         | varchar(64)         | NO       | --                | --        | Tipo de evidence.                        | COMPLETION_FACT |
| source_context        | varchar(48)         | NO       | --                | --        | Authority del evidence.                  | EC-07           |
| source_ref            | uuid                | NO       | --                | EXT REF   | Referencia externa/interna.              | fact...         |
| content_hash          | varchar(128)        | YES      | NULL              | --        | Hash cuándo existe artefacto canonico.   | sha256:...      |
| captured_at           | timestamptz         | NO       | now()             | --        | Instante de binding.                     | ...             |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**award_evidence_ref_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_award_id —** Award padre. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: awd....

**evidence_kind —** Tipo de evidence. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: COMPLETION_FACT.

**source_context —** Authority del evidence. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: EC-07.

**source_ref —** Referencia externa/interna. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: fact....

**content_hash —** Hash cuándo existe artefacto canonico. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**captured_at —** Instante de binding. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                       | **Tipo** | **Definicion/expresion**                                                           | **Error que impide**                                                                   |
|-----------------------------------------|----------|------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_award_evidence_ref              | PK       | PRIMARY KEY (tenant_id, award_evidence_ref_id)                                     | Impide identidad duplicada dentro del tenant.                                          |
| uq_ec08_award_evidence_ref_01           | UQ/INDEX | UNIQUE (tenant_id, credential_award_id, evidence_kind, source_context, source_ref) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_award_evidence_ref             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                   | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_award_evidence_ref_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                               | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.5 ec08_issuance_request

QUE REPRESENTA — Representa la intencion durable de emitir una representacion oficial para un award, incluyendo canal/perfil y parámetros que afectan rendering o interoperabilidad.

COMO PARTICIPA ARQUITECTONICAMENTE — La crea backoffice, holder workflow, batch o proceso automático autorizado. Permite idempotencia y OperationStatus sin sobrecargar CredentialIssuance con estados transitorios de solicitud.

QUE PROTEGE / QUE NO REPRESENTA — Protege replay y trazabilidad de quién pidio emitir. No es el issuance mismo ni un provider request remoto.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                               | **Ejemplo**       |
|----------------------|---------------------|----------|-------------------|---------------|---------------------------------------------------------------|-------------------|
| tenant_id            | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.                      | 8a6...            |
| issuance_request_id  | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                                | id...             |
| credential_award_id  | uuid                | NO       | --                | FK            | Award objetivo.                                               | awd...            |
| request_kind         | varchar(40)         | NO       | 'INITIAL'         | CHECK         | INITIAL/CORRECTION/REISSUE/CUMULATIVE.                        | INITIAL           |
| requested_locale     | varchar(16)         | YES      | NULL              | EXT REF CT-08 | Locale solicitado.                                            | es-BO             |
| interop_profile_code | varchar(80)         | YES      | NULL              | EXT REF CT-18 | Profile externo opcional.                                     | OPEN_BADGES_3     |
| requested_by_subject | uuid                | NO       | --                | EXT REF IAM   | Actor solicitante.                                            | usr...            |
| state                | varchar(24)         | NO       | 'PENDING'         | CHECK         | PENDING/PROCESSING/SUCCEEDED/FAILED/CANCELLED/UNKNOWN_EFFECT. | PENDING           |
| reason_code          | varchar(80)         | YES      | NULL              | --            | Motivo/resultado.                                             | INITIAL_ISSUE     |
| created_at           | timestamptz         | NO       | now()             | --            | Instante UTC de creacion.                                     | 2026-09-11T13:00Z |
| updated_at           | timestamptz         | NO       | now()             | --            | Última mutacion permitida.                                    | 2026-09-11T13:10Z |
| versión              | bigint              | NO       | 0                 | --            | Optimistic lock / aggregate revisión.                         | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**issuance_request_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_award_id —** Award objetivo. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: awd....

**request_kind —** INITIAL/CORRECTION/REISSUE/CUMULATIVE. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'INITIAL'; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: INITIAL.

**requested_locale —** Locale solicitado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: es-BO.

**interop_profile_code —** Profile externo opcional. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: OPEN_BADGES_3.

**requested_by_subject —** Actor solicitante. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**state —** PENDING/PROCESSING/SUCCEEDED/FAILED/CANCELLED/UNKNOWN_EFFECT. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: PENDING.

**reason_code —** Motivo/resultado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: INITIAL_ISSUE.

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**           | **Tipo** | **Definicion/expresion**                                                                    | **Error que impide**                                                                   |
|-----------------------------|----------|---------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_issuance_request    | PK       | PRIMARY KEY (tenant_id, issuance_request_id)                                                | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_issuance_request_01 | CHECK    | CHECK (request_kind IN ('INITIAL','CORRECTION','REISSUE','CUMULATIVE'))                     | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_issuance_request_02 | CHECK    | CHECK (state IN ('PENDING','PROCESSING','SUCCEEDED','FAILED','CANCELLED','UNKNOWN_EFFECT')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_issuance_request   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                            | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec08_credential_issuance

QUE REPRESENTA — Representa una instancia oficial emitida de un CredentialAward. Contiene identidad/serial, issuer, lifecycle, hashes y lineage de supersession; el contenido completo reside en snapshot canonico hijo.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea por Issuance Application Service despues de validar award/policy/assurance. EC-08 publica IssuanceIssued y status events; CT-05 crea documentos; CT-18 publica perfiles externos.

QUE PROTEGE / QUE NO REPRESENTA — Protege seriales, orden de reemision e inmutabilidad post-ISSUED. No es el PDF, ni el QR, ni el badge externo.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                          | **Ejemplo**        |
|--------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------|--------------------|
| tenant_id                | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.                 | 8a6...             |
| credential_issuance_id   | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                           | id...              |
| credential_award_id      | uuid                | NO       | --                | FK            | Award padre del mismo tenant.                            | awd...             |
| issuance_request_id      | uuid                | NO       | --                | FK            | Request que origino la emisión.                          | ir...              |
| credential_serial        | varchar(128)        | NO       | --                | UQ            | Serial institucional no reutilizable.                    | PEU-EC-2026-000123 |
| issuance_no              | integer             | NO       | 1                 | UQ\*          | Número positivo dentro del award.                        | 1                  |
| issuer_scope_ref         | uuid                | NO       | --                | EXT REF CT-01 | Scope institucional emisor.                              | scope...           |
| issuance_policy_ref      | uuid                | NO       | --                | EXT REF CT-02 | PolicyVersion de emisión.                                | pol...             |
| state                    | varchar(24)         | NO       | 'ISSUING'         | CHECK         | ISSUING/ISSUED/SUSPENDED/REVOKED/SUPERSEDED/VOID/FAILED. | ISSUED             |
| content_hash             | varchar(128)        | YES      | NULL              | --            | Hash del canonical payload emitido.                      | sha256:...         |
| hash_algorithm           | varchar(32)         | YES      | NULL              | --            | Algoritmo de hash versionable.                           | SHA-256            |
| canonical_schema_version | varchar(32)         | YES      | NULL              | --            | Versión del esquema canonico.                            | 1.0                |
| issued_at                | timestamptz         | YES      | NULL              | --            | Instante oficial de issuance.                            | 2026-09-11T13:30Z  |
| issued_by_subject        | uuid                | YES      | NULL              | EXT REF IAM   | Actor/system identity.                                   | usr...             |
| supersedes_issuance_id   | uuid                | YES      | NULL              | FK            | Issuance previo corregido/reemplazado.                   | iss-old...         |
| reason_code              | varchar(80)         | YES      | NULL              | --            | Reason code lifecycle.                                   | INITIAL_ISSUE      |
| created_at               | timestamptz         | NO       | now()             | --            | Instante UTC de creacion.                                | 2026-09-11T13:00Z  |
| updated_at               | timestamptz         | NO       | now()             | --            | Última mutacion permitida.                               | 2026-09-11T13:10Z  |
| versión                  | bigint              | NO       | 0                 | --            | Optimistic lock / aggregate revisión.                    | 3                  |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**credential_issuance_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_award_id —** Award padre del mismo tenant. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: awd....

**issuance_request_id —** Request que origino la emisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: ir....

**credential_serial —** Serial institucional no reutilizable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: PEU-EC-2026-000123.

**issuance_no —** Número positivo dentro del award. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 1; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 1.

**issuer_scope_ref —** Scope institucional emisor. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: scope....

**issuance_policy_ref —** PolicyVersion de emisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol....

**state —** ISSUING/ISSUED/SUSPENDED/REVOKED/SUPERSEDED/VOID/FAILED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'ISSUING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: ISSUED.

**content_hash —** Hash del canonical payload emitido. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**hash_algorithm —** Algoritmo de hash versionable. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: SHA-256.

**canonical_schema_version —** Versión del esquema canonico. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: 1.0.

**issued_at —** Instante oficial de issuance. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:30Z.

**issued_by_subject —** Actor/system identity. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**supersedes_issuance_id —** Issuance previo corregido/reemplazado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss-old....

**reason_code —** Reason code lifecycle. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: INITIAL_ISSUE.

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**              | **Tipo** | **Definicion/expresion**                                                                     | **Error que impide**                                                                   |
|--------------------------------|----------|----------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_issuance    | PK       | PRIMARY KEY (tenant_id, credential_issuance_id)                                              | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_credential_issuance_01 | CHECK    | CHECK (issuance_no \> 0)                                                                     | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_credential_issuance_02 | CHECK    | CHECK (state IN ('ISSUING','ISSUED','SUSPENDED','REVOKED','SUPERSEDED','VOID','FAILED'))     | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_credential_issuance_03 | UQ/INDEX | UNIQUE (tenant_id, credential_serial)                                                        | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_credential_issuance_04 | UQ/INDEX | UNIQUE (tenant_id, credential_award_id, issuance_no)                                         | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_credential_issuance_05 | CHECK    | CHECK (supersedes_issuance_id IS NULL OR supersedes_issuance_id \<\> credential_issuance_id) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_issuance   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                             | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.7 ec08_credential_payload_snapshot

QUE REPRESENTA — Representa los bytes/estructura lógica canonica que describen la credencial emitida: holder display, credential title, issuer display, dates, claims y metadata permitida.

COMO PARTICIPA ARQUITECTONICAMENTE — Es hijo 1:1 append-only de CredentialIssuance. Se construye antes de firma/rendering y su hash debe coincidir con issuance.content_hash. Proyecciones Open Badges/VC/CLR se derivan de este snapshot y facts asociados.

QUE PROTEGE / QUE NO REPRESENTA — Protege reconstructibilidad. No contiene blobs de documentos ni secretos. Cambiar contenido material exige nuevo issuance.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                          | **Ejemplo**                 |
|--------------------------|---------------------|----------|-------------------|---------------|------------------------------------------|-----------------------------|
| tenant_id                | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado. | 8a6...                      |
| payload_snapshot_id      | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.           | id...                       |
| credential_issuance_id   | uuid                | NO       | --                | FK/UQ         | Issuance propietario 1:1.                | iss...                      |
| payload_json             | jsonb               | NO       | --                | --            | Canonical payload estructurado.          | {"schema":"1.0"}            |
| canonical_schema_version | varchar(32)         | NO       | --                | --            | Versión de canonicalization.             | 1.0                         |
| content_hash             | varchar(128)        | NO       | --                | --            | Hash del canonical payload.              | sha256:...                  |
| hash_algorithm           | varchar(32)         | NO       | 'SHA-256'         | --            | Algoritmo.                               | SHA-256                     |
| holder_display_name      | varchar(240)        | NO       | --                | SNAPSHOT      | Nombre visible histórico minimizado.     | Ana Perez                   |
| credential_title         | varchar(240)        | NO       | --                | SNAPSHOT      | Titulo visible de credencial.            | Microcredencial IA Aplicada |
| issuer_display_name      | varchar(240)        | NO       | --                | SNAPSHOT      | Nombre visible emisor.                   | Universidad X               |
| locale_code              | varchar(16)         | NO       | 'es-BO'           | EXT REF CT-08 | Locale canonico de snapshot.             | es-BO                       |
| created_at               | timestamptz         | NO       | now()             | --            | Instante de snapshot.                    | ...                         |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**payload_snapshot_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance propietario 1:1. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**payload_json —** Canonical payload estructurado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: {"schema":"1.0"}.

**canonical_schema_version —** Versión de canonicalization. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: 1.0.

**content_hash —** Hash del canonical payload. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**hash_algorithm —** Algoritmo. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'SHA-256'; la aplicación no debe depender de un default distinto al contrato Flyway. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: SHA-256.

**holder_display_name —** Nombre visible histórico minimizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: Ana Perez.

**credential_title —** Titulo visible de credencial. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: Microcredencial IA Aplicada.

**issuer_display_name —** Nombre visible emisor. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: Universidad X.

**locale_code —** Locale canonico de snapshot. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'es-BO'; la aplicación no debe depender de un default distinto al contrato Flyway. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: es-BO.

**created_at —** Instante de snapshot. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                                | **Tipo** | **Definicion/expresion**                         | **Error que impide**                                                                   |
|--------------------------------------------------|----------|--------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_payload_snapshot              | PK       | PRIMARY KEY (tenant_id, payload_snapshot_id)     | Impide identidad duplicada dentro del tenant.                                          |
| uq_ec08_credential_payload_snapshot_01           | UQ/INDEX | UNIQUE (tenant_id, credential_issuance_id)       | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_payload_snapshot             | RLS      | tenant_id = current_setting('peopleu.tenant_id') | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_credential_payload_snapshot_append_only | TRIGGER  | FORBID UPDATE/DELETE                             | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.8 ec08_credential_document_binding

QUE REPRESENTA — Vincula un issuance con el documento o artefacto generado bajo CT-05. Puede existir más de un formato/render no material bajo policy, pero ninguno es Source of Truth del award.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea despues de que CT-05 confirme document_ref. Conserva template/versión, hash y role del documento. Un nuevo render puede coexistir sin alterar canonical payload cuándo la correction policy lo permite.

QUE PROTEGE / QUE NO REPRESENTA — Protege integridad entre issuance y documento sin guardar el blob. No asume que una URL de storage sea publica ni permanente.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                             | **Ejemplo**     |
|------------------------|---------------------|----------|-------------------|---------------|---------------------------------------------|-----------------|
| tenant_id              | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.    | 8a6...          |
| document_binding_id    | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.              | id...           |
| credential_issuance_id | uuid                | NO       | --                | FK            | Issuance padre.                             | iss...          |
| document_ref           | uuid                | NO       | --                | EXT REF CT-05 | Documento gestionado externamente.          | doc...          |
| document_role          | varchar(40)         | NO       | 'PRIMARY'         | CHECK         | PRIMARY/ALTERNATE/ACCESSIBLE_COPY/ARCHIVAL. | PRIMARY         |
| template_ref           | uuid                | YES      | NULL              | EXT REF CT-05 | Template/versión utilizado.                 | tpl...          |
| document_hash          | varchar(128)        | YES      | NULL              | --            | Hash del artefacto final cuándo disponible. | sha256:...      |
| mime_type              | varchar(80)         | YES      | NULL              | --            | MIME informativo.                           | application/pdf |
| created_at             | timestamptz         | NO       | now()             | --            | Binding time.                               | ...             |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**document_binding_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance padre. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**document_ref —** Documento gestionado externamente. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: doc....

**document_role —** PRIMARY/ALTERNATE/ACCESSIBLE_COPY/ARCHIVAL. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PRIMARY'; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: PRIMARY.

**template_ref —** Template/versión utilizado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: tpl....

**document_hash —** Hash del artefacto final cuándo disponible. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**mime_type —** MIME informativo. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: application/pdf.

**created_at —** Binding time. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                                | **Tipo** | **Definicion/expresion**                                                      | **Error que impide**                                                                   |
|--------------------------------------------------|----------|-------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_document_binding              | PK       | PRIMARY KEY (tenant_id, document_binding_id)                                  | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_credential_document_binding_01           | CHECK    | CHECK (document_role IN ('PRIMARY','ALTERNATE','ACCESSIBLE_COPY','ARCHIVAL')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_credential_document_binding_02           | UQ/INDEX | UNIQUE (tenant_id, credential_issuance_id, document_ref)                      | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_document_binding             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                              | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_credential_document_binding_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                          | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.9 ec08_signing_receipt

QUE REPRESENTA — Representa evidence de una operación de firma/sello/attestation realizada sobre canonical payload o documento. Guarda referencias criptograficas, nunca el secreto de firma.

COMO PARTICIPA ARQUITECTONICAMENTE — Lo crea el signing adapter una vez que el provider/KMS devuelve un resultado confirmado. Si existe UNKNOWN_EFFECT se registra operation/provider receipt separado hasta reconciliar; solo un receipt confirmado acredita firma.

QUE PROTEGE / QUE NO REPRESENTA — Protege auditabilidad de algoritmo/key y digest. No habilita reconstruir la clave privada ni re-firmar automáticamente historia.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**   | **Descripción**                          | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|-------------|------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | --                | PK\*        | Tenant derivado del contexto autorizado. | 8a6...            |
| signing_receipt_id     | uuid                | NO       | gen_random_uuid() | PK          | Identificador técnico estable.           | id...             |
| credential_issuance_id | uuid                | NO       | --                | FK          | Issuance firmado.                        | iss...            |
| signed_object_kind     | varchar(32)         | NO       | --                | CHECK       | PAYLOAD/DOCUMENT/BOTH.                   | PAYLOAD           |
| key_ref                | varchar(200)        | NO       | --                | EXT REF KMS | Referencia a key/versión, no secreto.    | kms:key/42        |
| algorithm_code         | varchar(48)         | NO       | --                | --          | Algoritmo de firma.                      | ES256             |
| digest                 | varchar(256)        | NO       | --                | --          | Digest firmado.                          | abc...            |
| provider_ref           | varchar(160)        | YES      | NULL              | EXT REF     | Receipt/provider id.                     | sig-123           |
| signed_at              | timestamptz         | NO       | --                | --          | Instante UTC de firma confirmada.        | 2026-09-11T13:31Z |
| created_at             | timestamptz         | NO       | now()             | --          | Registro append-only.                    | ...               |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**signing_receipt_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance firmado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**signed_object_kind —** PAYLOAD/DOCUMENT/BOTH. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: PAYLOAD.

**key_ref —** Referencia a key/versión, no secreto. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: kms:key/42.

**algorithm_code —** Algoritmo de firma. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: ES256.

**digest —** Digest firmado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: abc....

**provider_ref —** Receipt/provider id. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: sig-123.

**signed_at —** Instante UTC de firma confirmada. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:31Z.

**created_at —** Registro append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                    | **Tipo** | **Definicion/expresion**                                    | **Error que impide**                                                                   |
|--------------------------------------|----------|-------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_signing_receipt              | PK       | PRIMARY KEY (tenant_id, signing_receipt_id)                 | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_signing_receipt_01           | CHECK    | CHECK (signed_object_kind IN ('PAYLOAD','DOCUMENT','BOTH')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_signing_receipt             | RLS      | tenant_id = current_setting('peopleu.tenant_id')            | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_signing_receipt_append_only | TRIGGER  | FORBID UPDATE/DELETE                                        | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec08_verification_handle

QUE REPRESENTA — Representa el mecanismo publico resoluble que permite verificar una credencial sin exponer claves internas. El token plano solo existe al generarse/entregarse; la base conserva su hash.

COMO PARTICIPA ARQUITECTONICAMENTE — Es hijo de issuance. El public verification gateway recibe token, calcula hash, resuelve handle bajo contrato restringido y obtiene la public projection. La rotacion crea/deshabilita handles sin cambiar award/issuance.

QUE PROTEGE / QUE NO REPRESENTA — Protege contra enumeration y leakage de tokens. No demuestra identidad del holder por si mismo y no reemplaza firma/status.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                          | **Ejemplo** |
|------------------------|---------------------|----------|-------------------|-----------|------------------------------------------|-------------|
| tenant_id              | uuid                | NO       | --                | PK\*      | Tenant derivado del contexto autorizado. | 8a6...      |
| verification_handle_id | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico estable.           | id...       |
| credential_issuance_id | uuid                | NO       | --                | FK        | Issuance objetivo.                       | iss...      |
| token_hash             | varchar(128)        | NO       | --                | UQ GLOBAL | Hash de token de alta entropia.          | sha256:...  |
| token_hash_algorithm   | varchar(32)         | NO       | 'SHA-256'         | --        | Algoritmo de hash.                       | SHA-256     |
| state                  | varchar(24)         | NO       | 'ACTIVE'          | CHECK     | ACTIVE/DISABLED/ROTATED.                 | ACTIVE      |
| created_at             | timestamptz         | NO       | now()             | --        | Creacion.                                | ...         |
| disabled_at            | timestamptz         | YES      | NULL              | --        | Deshabilitacion.                         | ...         |
| disable_reason_code    | varchar(80)         | YES      | NULL              | --        | Motivo de deshabilitacion.               | ROTATED     |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**verification_handle_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance objetivo. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**token_hash —** Hash de token de alta entropia. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**token_hash_algorithm —** Algoritmo de hash. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'SHA-256'; la aplicación no debe depender de un default distinto al contrato Flyway. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: SHA-256.

**state —** ACTIVE/DISABLED/ROTATED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'ACTIVE'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: ACTIVE.

**created_at —** Creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**disabled_at —** Deshabilitacion. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**disable_reason_code —** Motivo de deshabilitacion. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: ROTATED.

### Constraints fisicos implementables

| **Nombre físico**              | **Tipo** | **Definicion/expresion**                         | **Error que impide**                                                                   |
|--------------------------------|----------|--------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_verification_handle    | PK       | PRIMARY KEY (tenant_id, verification_handle_id)  | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_verification_handle_01 | CHECK    | CHECK (state IN ('ACTIVE','DISABLED','ROTATED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_verification_handle_02 | UQ/INDEX | UNIQUE (token_hash)                              | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_verification_handle_03 | UQ/INDEX | UNIQUE (tenant_id, credential_issuance_id)       | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_verification_handle   | RLS      | tenant_id = current_setting('peopleu.tenant_id') | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.11 ec08_credential_status_fact

QUE REPRESENTA — Representa un cambio oficial de estado de un CredentialIssuance en una secuencia append-only. Permite demostrar que status estuvo vigente en cada instante.

COMO PARTICIPA ARQUITECTONICAMENTE — Se agrega por commands cómo ISSUE, SUSPEND, REINSTATE, REVOKE, SUPERSEDE o VOID. El public verifier deriva status actual desde la secuencia valida y puede usar una proyeccion/cache invalidable.

QUE PROTEGE / QUE NO REPRESENTA — Protege contra overwrite de history y reorder ambiguo. No guarda textos extensos de evidence ni modifica canonical payload.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                           | **Ejemplo**     |
|------------------------|---------------------|----------|-------------------|---------------|-------------------------------------------|-----------------|
| tenant_id              | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.  | 8a6...          |
| status_fact_id         | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.            | id...           |
| credential_issuance_id | uuid                | NO       | --                | FK            | Issuance propietario.                     | iss...          |
| sequence_no            | bigint              | NO       | --                | UQ\*          | Secuencia monotonic por issuance.         | 3               |
| status_code            | varchar(24)         | NO       | --                | CHECK         | ISSUED/SUSPENDED/REVOKED/SUPERSEDED/VOID. | REVOKED         |
| effective_at           | timestamptz         | NO       | now()             | --            | Instante efectivo UTC.                    | ...             |
| reason_code            | varchar(80)         | NO       | --                | --            | Reason code estable.                      | FRAUD_CONFIRMED |
| decision_ref           | uuid                | YES      | NULL              | FK/EXT REF    | Decisión/case que sustenta status.        | dec...          |
| actor_subject          | uuid                | NO       | --                | EXT REF IAM   | Actor/system autorizado.                  | usr...          |
| policy_ref             | uuid                | NO       | --                | EXT REF CT-02 | PolicyVersion aplicada.                   | pol...          |
| created_at             | timestamptz         | NO       | now()             | --            | Registro append-only.                     | ...             |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**status_fact_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance propietario. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**sequence_no —** Secuencia monotonic por issuance. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: 3.

**status_code —** ISSUED/SUSPENDED/REVOKED/SUPERSEDED/VOID. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: REVOKED.

**effective_at —** Instante efectivo UTC. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**reason_code —** Reason code estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: FRAUD_CONFIRMED.

**decision_ref —** Decisión/case que sustenta status. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: dec....

**actor_subject —** Actor/system autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**policy_ref —** PolicyVersion aplicada. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol....

**created_at —** Registro append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                           | **Tipo** | **Definicion/expresion**                                                    | **Error que impide**                                                                   |
|---------------------------------------------|----------|-----------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_status_fact              | PK       | PRIMARY KEY (tenant_id, status_fact_id)                                     | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_credential_status_fact_01           | CHECK    | CHECK (sequence_no \> 0)                                                    | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_credential_status_fact_02           | CHECK    | CHECK (status_code IN ('ISSUED','SUSPENDED','REVOKED','SUPERSEDED','VOID')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_credential_status_fact_03           | UQ/INDEX | UNIQUE (tenant_id, credential_issuance_id, sequence_no)                     | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_status_fact             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                            | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_credential_status_fact_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                        | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec08_status_restatement

QUE REPRESENTA — Representa una corrección formal sobre la interpretacion de un CredentialStatusFact sin eliminar el fact original. Se usa solo cuándo governance determina que un status previo fue registrado erroneamente o requiere supersession semántica.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea bajo workflow/SoD y referencia el status fact afectado. El projector de status aplica restatements según sequence/effective policy. Todo restatement es append-only.

QUE PROTEGE / QUE NO REPRESENTA — Protege historia y transparencia de correcciones. No permite que un operador edite reason/status original.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**              | **Descripción**                          | **Ejemplo**              |
|-----------------------|---------------------|----------|-------------------|------------------------|------------------------------------------|--------------------------|
| tenant_id             | uuid                | NO       | --                | PK\*                   | Tenant derivado del contexto autorizado. | 8a6...                   |
| status_restatement_id | uuid                | NO       | gen_random_uuid() | PK                     | Identificador técnico estable.           | id...                    |
| status_fact_id        | uuid                | NO       | --                | FK                     | Fact restatado.                          | sf...                    |
| restated_status_code  | varchar(24)         | NO       | --                | CHECK                  | Status correcto según decisión.          | ISSUED                   |
| reason_code           | varchar(80)         | NO       | --                | --                     | Motivo formal.                           | STATUS_RECORDED_IN_ERROR |
| decision_ref          | uuid                | NO       | --                | EXT REF CT-06/internal | Decisión que autoriza.                   | dec...                   |
| effective_at          | timestamptz         | NO       | now()             | --                     | Efectividad del restatement.             | ...                      |
| actor_subject         | uuid                | NO       | --                | EXT REF IAM            | Actor responsable.                       | usr...                   |
| created_at            | timestamptz         | NO       | now()             | --                     | Append-only.                             | ...                      |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**status_restatement_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: id....

**status_fact_id —** Fact restatado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: sf....

**restated_status_code —** Status correcto según decisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: ISSUED.

**reason_code —** Motivo formal. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: STATUS_RECORDED_IN_ERROR.

**decision_ref —** Decisión que autoriza. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: dec....

**effective_at —** Efectividad del restatement. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**actor_subject —** Actor responsable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**created_at —** Append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                       | **Tipo** | **Definicion/expresion**                                                             | **Error que impide**                                                                   |
|-----------------------------------------|----------|--------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_status_restatement              | PK       | PRIMARY KEY (tenant_id, status_restatement_id)                                       | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_status_restatement_01           | CHECK    | CHECK (restated_status_code IN ('ISSUED','SUSPENDED','REVOKED','SUPERSEDED','VOID')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_status_restatement             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                     | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_status_restatement_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                                 | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.13 ec08_revocation_case

QUE REPRESENTA — Representa el expediente operativo para evaluar suspension o revocación de una credencial emitida. Reune motivo, severity, evidence refs, workflow y estado de investigacion.

COMO PARTICIPA ARQUITECTONICAMENTE — Lo crea Governance/Support autorizado. Puede integrarse con CT-06. No cambia el issuance al abrirse; solo una RevocationDecision aprobada y aplicada agrega el CredentialStatusFact correspondiente.

QUE PROTEGE / QUE NO REPRESENTA — Protege SoD, trazabilidad y due process institucional. No es una bandera booleana de revoked.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                          | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.                                 | 8a6...            |
| revocation_case_id     | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                                           | id...             |
| credential_issuance_id | uuid                | NO       | --                | FK            | Issuance investigado.                                                    | iss...            |
| case_kind              | varchar(32)         | NO       | --                | CHECK         | SUSPENSION/REVOCATION.                                                   | REVOCATION        |
| state                  | varchar(32)         | NO       | 'DRAFT'           | CHECK         | DRAFT/SUBMITTED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/CLOSED/CANCELLED. | UNDER_REVIEW      |
| reason_code            | varchar(80)         | NO       | --                | --            | Motivo de apertura.                                                      | FRAUD_SUSPECTED   |
| details_text           | text                | YES      | NULL              | --            | Detalle restringido, sin secrets.                                        | ...               |
| workflow_ref           | uuid                | YES      | NULL              | EXT REF CT-06 | Workflow asociado.                                                       | wf...             |
| opened_by_subject      | uuid                | NO       | --                | EXT REF IAM   | Actor que abre.                                                          | usr...            |
| assurance_level        | varchar(40)         | YES      | NULL              | --            | Assurance de operación.                                                  | MFA               |
| closed_at              | timestamptz         | YES      | NULL              | --            | Cierre.                                                                  | ...               |
| created_at             | timestamptz         | NO       | now()             | --            | Instante UTC de creacion.                                                | 2026-09-11T13:00Z |
| updated_at             | timestamptz         | NO       | now()             | --            | Última mutacion permitida.                                               | 2026-09-11T13:10Z |
| versión                | bigint              | NO       | 0                 | --            | Optimistic lock / aggregate revisión.                                    | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**revocation_case_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance investigado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**case_kind —** SUSPENSION/REVOCATION. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: REVOCATION.

**state —** DRAFT/SUBMITTED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/CLOSED/CANCELLED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'DRAFT'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: UNDER_REVIEW.

**reason_code —** Motivo de apertura. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: FRAUD_SUSPECTED.

**details_text —** Detalle restringido, sin secrets. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: ....

**workflow_ref —** Workflow asociado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: wf....

**opened_by_subject —** Actor que abre. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**assurance_level —** Assurance de operación. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: MFA.

**closed_at —** Cierre. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**          | **Tipo** | **Definicion/expresion**                                                                                   | **Error que impide**                                                                   |
|----------------------------|----------|------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_revocation_case    | PK       | PRIMARY KEY (tenant_id, revocation_case_id)                                                                | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_revocation_case_01 | CHECK    | CHECK (case_kind IN ('SUSPENSION','REVOCATION'))                                                           | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_revocation_case_02 | CHECK    | CHECK (state IN ('DRAFT','SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','CLOSED','CANCELLED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_revocation_case   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                                           | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec08_revocation_decision

QUE REPRESENTA — Representa la decisión formal y durable tomada sobre un RevocationCase: approve/reject y action resultante.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea una vez por case bajo actor autorizado. Si APPROVE, Application Service aplica status fact en la misma transacción local o mediante command idempotente correlacionado. La decisión permanece append-only.

QUE PROTEGE / QUE NO REPRESENTA — Protege separacion entre investigar y aplicar. No borra issuance ni evidence.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                          | **Ejemplo**     |
|------------------------|---------------------|----------|-------------------|---------------|------------------------------------------|-----------------|
| tenant_id              | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado. | 8a6...          |
| revocation_decision_id | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.           | id...           |
| revocation_case_id     | uuid                | NO       | --                | FK/UQ         | Case decidido.                           | rc...           |
| decision_code          | varchar(24)         | NO       | --                | CHECK         | APPROVE/REJECT.                          | APPROVE         |
| action_code            | varchar(24)         | YES      | NULL              | CHECK         | SUSPEND/REVOKE/NO_ACTION.                | REVOKE          |
| reason_code            | varchar(80)         | NO       | --                | --            | Fundamento codificado.                   | FRAUD_CONFIRMED |
| decided_by_subject     | uuid                | NO       | --                | EXT REF IAM   | Actor aprobador.                         | usr...          |
| decided_at             | timestamptz         | NO       | now()             | --            | Instante UTC.                            | ...             |
| evidence_pack_ref      | uuid                | YES      | NULL              | EXT REF CT-05 | Evidence pack.                           | ev...           |
| created_at             | timestamptz         | NO       | now()             | --            | Append-only.                             | ...             |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**revocation_decision_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**revocation_case_id —** Case decidido. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: rc....

**decision_code —** APPROVE/REJECT. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: APPROVE.

**action_code —** SUSPEND/REVOKE/NO_ACTION. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: REVOKE.

**reason_code —** Fundamento codificado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: FRAUD_CONFIRMED.

**decided_by_subject —** Actor aprobador. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**decided_at —** Instante UTC. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**evidence_pack_ref —** Evidence pack. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ev....

**created_at —** Append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                        | **Tipo** | **Definicion/expresion**                                                       | **Error que impide**                                                                   |
|------------------------------------------|----------|--------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_revocation_decision              | PK       | PRIMARY KEY (tenant_id, revocation_decision_id)                                | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_revocation_decision_01           | CHECK    | CHECK (decision_code IN ('APPROVE','REJECT'))                                  | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_revocation_decision_02           | CHECK    | CHECK (action_code IS NULL OR action_code IN ('SUSPEND','REVOKE','NO_ACTION')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_revocation_decision_03           | UQ/INDEX | UNIQUE (tenant_id, revocation_case_id)                                         | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_revocation_decision             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                               | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_revocation_decision_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                           | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec08_correction_request

QUE REPRESENTA — Representa una solicitud para corregir datos visibles, metadata o un hecho material relacionado con una credencial ya emitida.

COMO PARTICIPA ARQUITECTONICAMENTE — La puede iniciar holder, support o governance. CorrectionClassificationPolicy determina si es RENDER_ONLY, MATERIAL_REISSUE o REJECT. El request conserva before/claimed change refs y workflow.

QUE PROTEGE / QUE NO REPRESENTA — Protege que ningun cambio llegue al issuance por edit directo. No contiene el nuevo official payload hasta que exista decisión/aplicación.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**          | **Descripción**                                                        | **Ejemplo**           |
|------------------------|---------------------|----------|-------------------|--------------------|------------------------------------------------------------------------|-----------------------|
| tenant_id              | uuid                | NO       | --                | PK\*               | Tenant derivado del contexto autorizado.                               | 8a6...                |
| correction_request_id  | uuid                | NO       | gen_random_uuid() | PK                 | Identificador técnico estable.                                         | id...                 |
| credential_issuance_id | uuid                | NO       | --                | FK                 | Issuance afectado.                                                     | iss...                |
| requested_by_subject   | uuid                | NO       | --                | EXT REF IAM/holder | Solicitante.                                                           | sub...                |
| claimed_field_code     | varchar(80)         | YES      | NULL              | --                 | Campo o categoria reclamada.                                           | HOLDER_DISPLAY_NAME   |
| claimed_value_text     | text                | YES      | NULL              | --                 | Valor propuesto minimizado.                                            | Ana Maria Perez       |
| classification_code    | varchar(32)         | YES      | NULL              | CHECK              | RENDER_ONLY/MATERIAL_REISSUE/REJECT.                                   | MATERIAL_REISSUE      |
| state                  | varchar(32)         | NO       | 'DRAFT'           | CHECK              | DRAFT/SUBMITTED/CLASSIFIED/APPROVED/REJECTED/APPLIED/CLOSED/CANCELLED. | SUBMITTED             |
| reason_code            | varchar(80)         | NO       | --                | --                 | Motivo.                                                                | LEGAL_NAME_CORRECTION |
| workflow_ref           | uuid                | YES      | NULL              | EXT REF CT-06      | Workflow.                                                              | wf...                 |
| created_at             | timestamptz         | NO       | now()             | --                 | Instante UTC de creacion.                                              | 2026-09-11T13:00Z     |
| updated_at             | timestamptz         | NO       | now()             | --                 | Última mutacion permitida.                                             | 2026-09-11T13:10Z     |
| versión                | bigint              | NO       | 0                 | --                 | Optimistic lock / aggregate revisión.                                  | 3                     |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**correction_request_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance afectado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**requested_by_subject —** Solicitante. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: sub....

**claimed_field_code —** Campo o categoria reclamada. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: HOLDER_DISPLAY_NAME.

**claimed_value_text —** Valor propuesto minimizado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: Ana Maria Perez.

**classification_code —** RENDER_ONLY/MATERIAL_REISSUE/REJECT. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: MATERIAL_REISSUE.

**state —** DRAFT/SUBMITTED/CLASSIFIED/APPROVED/REJECTED/APPLIED/CLOSED/CANCELLED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'DRAFT'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: SUBMITTED.

**reason_code —** Motivo. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: LEGAL_NAME_CORRECTION.

**workflow_ref —** Workflow. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: wf....

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**             | **Tipo** | **Definicion/expresion**                                                                                  | **Error que impide**                                                                   |
|-------------------------------|----------|-----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_correction_request    | PK       | PRIMARY KEY (tenant_id, correction_request_id)                                                            | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_correction_request_01 | CHECK    | CHECK (classification_code IS NULL OR classification_code IN ('RENDER_ONLY','MATERIAL_REISSUE','REJECT')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_correction_request_02 | CHECK    | CHECK (state IN ('DRAFT','SUBMITTED','CLASSIFIED','APPROVED','REJECTED','APPLIED','CLOSED','CANCELLED'))  | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_correction_request   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                                          | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.16 ec08_correction_decision

QUE REPRESENTA — Representa la decisión formal sobre un CorrectionRequest, incluyendo la clasificación definitiva y acción autorizada.

COMO PARTICIPA ARQUITECTONICAMENTE — Es append-only y única por request. Para MATERIAL_REISSUE autoriza crear un nuevo issuance; para RENDER_ONLY autoriza otro document binding bajo el mismo snapshot cuándo policy lo permite.

QUE PROTEGE / QUE NO REPRESENTA — Protege que soporte no cambie documentos/claims sin governance. No ejecuta por si misma efectos remotos.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                          | **Ejemplo**                |
|------------------------|---------------------|----------|-------------------|---------------|------------------------------------------|----------------------------|
| tenant_id              | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado. | 8a6...                     |
| correction_decision_id | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.           | id...                      |
| correction_request_id  | uuid                | NO       | --                | FK/UQ         | Request decidido.                        | cr...                      |
| decision_code          | varchar(24)         | NO       | --                | CHECK         | APPROVE/REJECT.                          | APPROVE                    |
| classification_code    | varchar(32)         | NO       | --                | CHECK         | RENDER_ONLY/MATERIAL_REISSUE/REJECT.     | MATERIAL_REISSUE           |
| reason_code            | varchar(80)         | NO       | --                | --            | Fundamento.                              | IDENTITY_EVIDENCE_ACCEPTED |
| decided_by_subject     | uuid                | NO       | --                | EXT REF IAM   | Aprobador.                               | usr...                     |
| decided_at             | timestamptz         | NO       | now()             | --            | Instante UTC.                            | ...                        |
| evidence_pack_ref      | uuid                | YES      | NULL              | EXT REF CT-05 | Evidence.                                | ev...                      |
| created_at             | timestamptz         | NO       | now()             | --            | Append-only.                             | ...                        |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**correction_decision_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**correction_request_id —** Request decidido. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: cr....

**decision_code —** APPROVE/REJECT. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: APPROVE.

**classification_code —** RENDER_ONLY/MATERIAL_REISSUE/REJECT. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: MATERIAL_REISSUE.

**reason_code —** Fundamento. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: IDENTITY_EVIDENCE_ACCEPTED.

**decided_by_subject —** Aprobador. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**decided_at —** Instante UTC. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**evidence_pack_ref —** Evidence. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ev....

**created_at —** Append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                        | **Tipo** | **Definicion/expresion**                                                   | **Error que impide**                                                                   |
|------------------------------------------|----------|----------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_correction_decision              | PK       | PRIMARY KEY (tenant_id, correction_decision_id)                            | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_correction_decision_01           | CHECK    | CHECK (decision_code IN ('APPROVE','REJECT'))                              | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_correction_decision_02           | CHECK    | CHECK (classification_code IN ('RENDER_ONLY','MATERIAL_REISSUE','REJECT')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_correction_decision_03           | UQ/INDEX | UNIQUE (tenant_id, correction_request_id)                                  | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_correction_decision             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                           | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_correction_decision_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                       | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.17 ec08_supersession_link

QUE REPRESENTA — Representa la relacion historica entre un issuance anterior y el issuance que lo reemplaza por corrección material o reemision gobernada.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea junto con el nuevo issuance y el status SUPERSEDED del anterior. Public verifier y holder portal usan el link para orientar a la representacion vigente sin ocultar history.

QUE PROTEGE / QUE NO REPRESENTA — Protege lineage aciclico y 1:1 de supersession. No implica borrar el documento anterior ni reasignar su serial.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                          | **Ejemplo**         |
|------------------------|---------------------|----------|-------------------|-----------|------------------------------------------|---------------------|
| tenant_id              | uuid                | NO       | --                | PK\*      | Tenant derivado del contexto autorizado. | 8a6...              |
| supersession_link_id   | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico estable.           | id...               |
| prior_issuance_id      | uuid                | NO       | --                | FK/UQ     | Issuance anterior.                       | iss-old...          |
| next_issuance_id       | uuid                | NO       | --                | FK/UQ     | Issuance nuevo.                          | iss-new...          |
| correction_decision_id | uuid                | YES      | NULL              | FK        | Decisión que sustenta.                   | cd...               |
| reason_code            | varchar(80)         | NO       | --                | --        | Motivo de supersession.                  | MATERIAL_CORRECTION |
| created_at             | timestamptz         | NO       | now()             | --        | Append-only.                             | ...                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**supersession_link_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**prior_issuance_id —** Issuance anterior. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss-old....

**next_issuance_id —** Issuance nuevo. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss-new....

**correction_decision_id —** Decisión que sustenta. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: cd....

**reason_code —** Motivo de supersession. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: MATERIAL_CORRECTION.

**created_at —** Append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                      | **Tipo** | **Definicion/expresion**                         | **Error que impide**                                                                   |
|----------------------------------------|----------|--------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_supersession_link              | PK       | PRIMARY KEY (tenant_id, supersession_link_id)    | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_supersession_link_01           | CHECK    | CHECK (prior_issuance_id \<\> next_issuance_id)  | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_supersession_link_02           | UQ/INDEX | UNIQUE (tenant_id, prior_issuance_id)            | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_supersession_link_03           | UQ/INDEX | UNIQUE (tenant_id, next_issuance_id)             | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_supersession_link             | RLS      | tenant_id = current_setting('peopleu.tenant_id') | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_supersession_link_append_only | TRIGGER  | FORBID UPDATE/DELETE                             | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.18 ec08_delivery_request

QUE REPRESENTA — Representa la intencion durable de entregar un issuance por un canal especifico cómo portal, email, push, wallet o export interoperable.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea post-issuance y es procesada por adapter/worker. Puede llegar a UNKNOWN_EFFECT cuándo el proveedor remoto pudo aplicar la entrega pero la respuesta se perdio. El request tiene lease/retry semantics propias.

QUE PROTEGE / QUE NO REPRESENTA — Protege retries sin duplicar semántica académica. No convierte delivery en condicion de validez del award.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**      | **Descripción**                                              | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|----------------|--------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | --                | PK\*           | Tenant derivado del contexto autorizado.                     | 8a6...            |
| delivery_request_id    | uuid                | NO       | gen_random_uuid() | PK             | Identificador técnico estable.                               | id...             |
| credential_issuance_id | uuid                | NO       | --                | FK             | Issuance a entregar.                                         | iss...            |
| channel_code           | varchar(40)         | NO       | --                | CHECK          | PORTAL/EMAIL/PUSH/WALLET/EXPORT.                             | WALLET            |
| target_ref             | varchar(240)        | YES      | NULL              | EXT REF/opaque | Destino minimizado/opaque.                                   | wallet:...        |
| interop_profile_code   | varchar(80)         | YES      | NULL              | EXT REF CT-18  | Perfil de interoperabilidad.                                 | OPEN_BADGES_3     |
| state                  | varchar(32)         | NO       | 'PENDING'         | CHECK          | PENDING/IN_FLIGHT/DELIVERED/FAILED/UNKNOWN_EFFECT/CANCELLED. | PENDING           |
| attempt_count          | integer             | NO       | 0                 | CHECK          | Cantidad de intentos.                                        | 1                 |
| next_attempt_at        | timestamptz         | YES      | NULL              | --             | Backoff scheduling.                                          | ...               |
| lease_owner            | varchar(120)        | YES      | NULL              | --             | Worker owner.                                                | worker-1          |
| lease_until            | timestamptz         | YES      | NULL              | --             | Fin lease.                                                   | ...               |
| created_at             | timestamptz         | NO       | now()             | --             | Instante UTC de creacion.                                    | 2026-09-11T13:00Z |
| updated_at             | timestamptz         | NO       | now()             | --             | Última mutacion permitida.                                   | 2026-09-11T13:10Z |
| versión                | bigint              | NO       | 0                 | --             | Optimistic lock / aggregate revisión.                        | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**delivery_request_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance a entregar. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**channel_code —** PORTAL/EMAIL/PUSH/WALLET/EXPORT. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: WALLET.

**target_ref —** Destino minimizado/opaque. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: wallet:....

**interop_profile_code —** Perfil de interoperabilidad. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: OPEN_BADGES_3.

**state —** PENDING/IN_FLIGHT/DELIVERED/FAILED/UNKNOWN_EFFECT/CANCELLED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: PENDING.

**attempt_count —** Cantidad de intentos. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 1.

**next_attempt_at —** Backoff scheduling. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**lease_owner —** Worker owner. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: worker-1.

**lease_until —** Fin lease. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**           | **Tipo** | **Definicion/expresion**                                                                   | **Error que impide**                                                                   |
|-----------------------------|----------|--------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_delivery_request    | PK       | PRIMARY KEY (tenant_id, delivery_request_id)                                               | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_delivery_request_01 | CHECK    | CHECK (channel_code IN ('PORTAL','EMAIL','PUSH','WALLET','EXPORT'))                        | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_delivery_request_02 | CHECK    | CHECK (state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED','UNKNOWN_EFFECT','CANCELLED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_delivery_request_03 | CHECK    | CHECK (attempt_count \>= 0)                                                                | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_delivery_request   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                           | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.19 ec08_delivery_receipt

QUE REPRESENTA — Representa un resultado terminal o una evidencia de proveedor para un DeliveryRequest. Permite demostrar que se entrego, fallo o fue confirmado luego de reconciliation.

COMO PARTICIPA ARQUITECTONICAMENTE — Es append-only y puede incluir provider_ref/status/http class minimizado. Para delivery wallet/interop es la base de reconcile y soporte.

QUE PROTEGE / QUE NO REPRESENTA — Protege contra overwrite de respuesta remota. No almacena payload sensible completo ni bearer credentials.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                           | **Ejemplo** |
|----------------------|---------------------|----------|-------------------|-----------|-----------------------------------------------------------|-------------|
| tenant_id            | uuid                | NO       | --                | PK\*      | Tenant derivado del contexto autorizado.                  | 8a6...      |
| delivery_receipt_id  | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico estable.                            | id...       |
| delivery_request_id  | uuid                | NO       | --                | FK        | Request padre.                                            | dr...       |
| outcome              | varchar(32)         | NO       | --                | CHECK     | DELIVERED/FAILED/CONFIRMED_NOT_APPLIED/CONFIRMED_APPLIED. | DELIVERED   |
| provider_ref         | varchar(200)        | YES      | NULL              | EXT REF   | Identificador remoto.                                     | prov-123    |
| provider_status_code | varchar(80)         | YES      | NULL              | --        | Código remoto sanitizado.                                 | 200         |
| received_at          | timestamptz         | NO       | now()             | --        | Instante UTC.                                             | ...         |
| content_hash         | varchar(128)        | YES      | NULL              | --        | Hash de request/projection si aplica.                     | sha256:...  |
| created_at           | timestamptz         | NO       | now()             | --        | Append-only.                                              | ...         |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**delivery_receipt_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**delivery_request_id —** Request padre. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: dr....

**outcome —** DELIVERED/FAILED/CONFIRMED_NOT_APPLIED/CONFIRMED_APPLIED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: DELIVERED.

**provider_ref —** Identificador remoto. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: prov-123.

**provider_status_code —** Código remoto sanitizado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: 200.

**received_at —** Instante UTC. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**content_hash —** Hash de request/projection si aplica. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**created_at —** Append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                     | **Tipo** | **Definicion/expresion**                                                              | **Error que impide**                                                                   |
|---------------------------------------|----------|---------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_delivery_receipt              | PK       | PRIMARY KEY (tenant_id, delivery_receipt_id)                                          | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_delivery_receipt_01           | CHECK    | CHECK (outcome IN ('DELIVERED','FAILED','CONFIRMED_NOT_APPLIED','CONFIRMED_APPLIED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_delivery_receipt             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                      | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_delivery_receipt_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                                  | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.20 ec08_badge_assertion

QUE REPRESENTA — Representa una proyeccion de credencial orientada a ecosistemas de badges. Mantiene mapping desde issuance a profile/versión y los refs externos necesarios para status/revocation.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea solo desde un award/issuance valido. CT-18 publica/actualiza el recurso externo. El assertion local conserva mapping y provider receipt, no reimplementa un servicio de Open Badges.

QUE PROTEGE / QUE NO REPRESENTA — Protege que un badge no nazca sin academic source. No es el CredentialBlueprint ni CompletionFact.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                            | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.                   | 8a6...            |
| badge_assertion_id     | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                             | id...             |
| credential_issuance_id | uuid                | NO       | --                | FK/UQ         | Issuance fuente.                                           | iss...            |
| profile_code           | varchar(80)         | NO       | --                | EXT REF CT-18 | Perfil interoperable.                                      | OPEN_BADGES_3     |
| profile_version        | varchar(32)         | NO       | --                | --            | Versión perfil.                                            | 3.0               |
| external_assertion_ref | varchar(240)        | YES      | NULL              | EXT REF       | ID/URL provider opaque.                                    | ob3:...           |
| state                  | varchar(32)         | NO       | 'PENDING'         | CHECK         | PENDING/PUBLISHED/SUSPENDED/REVOKED/FAILED/UNKNOWN_EFFECT. | PUBLISHED         |
| last_reconciled_at     | timestamptz         | YES      | NULL              | --            | Última reconcile.                                          | ...               |
| created_at             | timestamptz         | NO       | now()             | --            | Instante UTC de creacion.                                  | 2026-09-11T13:00Z |
| updated_at             | timestamptz         | NO       | now()             | --            | Última mutacion permitida.                                 | 2026-09-11T13:10Z |
| versión                | bigint              | NO       | 0                 | --            | Optimistic lock / aggregate revisión.                      | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**badge_assertion_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance fuente. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**profile_code —** Perfil interoperable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: OPEN_BADGES_3.

**profile_version —** Versión perfil. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: 3.0.

**external_assertion_ref —** ID/URL provider opaque. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ob3:....

**state —** PENDING/PUBLISHED/SUSPENDED/REVOKED/FAILED/UNKNOWN_EFFECT. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: PUBLISHED.

**last_reconciled_at —** Última reconcile. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**          | **Tipo** | **Definicion/expresion**                                                                 | **Error que impide**                                                                   |
|----------------------------|----------|------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_badge_assertion    | PK       | PRIMARY KEY (tenant_id, badge_assertion_id)                                              | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_badge_assertion_01 | CHECK    | CHECK (state IN ('PENDING','PUBLISHED','SUSPENDED','REVOKED','FAILED','UNKNOWN_EFFECT')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_badge_assertion_02 | UQ/INDEX | UNIQUE (tenant_id, credential_issuance_id)                                               | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_badge_assertion   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                         | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.21 ec08_badge_evidence_binding

QUE REPRESENTA — Vincula BadgeAssertion con evidence refs que el profile externo permite publicar o referenciar, bajo privacy/purpose limitation.

COMO PARTICIPA ARQUITECTONICAMENTE — Lo genera InteropProjectionService desde award/issuance evidence autorizado. La URL/document ref puede ser indirecta y access-controlled; no se expone evidence privada por default.

QUE PROTEGE / QUE NO REPRESENTA — Protege provenance del badge y evita copiar documentos sensibles dentro del assertion.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                          | **Ejemplo** |
|---------------------------|---------------------|----------|-------------------|---------------|------------------------------------------|-------------|
| tenant_id                 | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado. | 8a6...      |
| badge_evidence_binding_id | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.           | id...       |
| badge_assertion_id        | uuid                | NO       | --                | FK            | Badge padre.                             | ba...       |
| evidence_kind             | varchar(64)         | NO       | --                | --            | Tipo de evidence.                        | PROJECT     |
| evidence_ref              | uuid                | NO       | --                | EXT REF CT-05 | Evidence/document ref.                   | ev...       |
| public_visibility         | boolean             | NO       | false             | --            | Si profile puede exponerlo publicamente. | false       |
| created_at                | timestamptz         | NO       | now()             | --            | Binding time.                            | ...         |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**badge_evidence_binding_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**badge_assertion_id —** Badge padre. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: ba....

**evidence_kind —** Tipo de evidence. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: PROJECT.

**evidence_ref —** Evidence/document ref. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ev....

**public_visibility —** Si profile puede exponerlo publicamente. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es false; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: false.

**created_at —** Binding time. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                           | **Tipo** | **Definicion/expresion**                             | **Error que impide**                                                                   |
|---------------------------------------------|----------|------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_badge_evidence_binding              | PK       | PRIMARY KEY (tenant_id, badge_evidence_binding_id)   | Impide identidad duplicada dentro del tenant.                                          |
| uq_ec08_badge_evidence_binding_01           | UQ/INDEX | UNIQUE (tenant_id, badge_assertion_id, evidence_ref) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_badge_evidence_binding             | RLS      | tenant_id = current_setting('peopleu.tenant_id')     | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_badge_evidence_binding_append_only | TRIGGER  | FORBID UPDATE/DELETE                                 | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.22 ec08_microcredential_record

QUE REPRESENTA — Clasifica un CredentialAward/Issuance cómo microcredencial bajo un profile institucional y conserva metadata de nivel, workload/credit reference y portability, sin crear equivalencia a grado.

COMO PARTICIPA ARQUITECTONICAMENTE — Se deriva de CredentialBlueprint y award. EC-10 puede consumirlo para pathway progress. Cualquier referencia a credits o level se pinnea a schemes/policies externos y no se traduce automáticamente a PG/PO.

QUE PROTEGE / QUE NO REPRESENTA — Protege semántica de microcredential y profile versión. No es un programa ni un degree award.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                  | **Ejemplo**        |
|---------------------------|---------------------|----------|-------------------|------------------|--------------------------------------------------|--------------------|
| tenant_id                 | uuid                | NO       | --                | PK\*             | Tenant derivado del contexto autorizado.         | 8a6...             |
| microcredential_record_id | uuid                | NO       | gen_random_uuid() | PK               | Identificador técnico estable.                   | id...              |
| credential_award_id       | uuid                | NO       | --                | FK/UQ            | Award fuente.                                    | awd...             |
| credential_issuance_id    | uuid                | YES      | NULL              | FK               | Issuance representativo.                         | iss...             |
| profile_code              | varchar(80)         | NO       | --                | EXT REF CT-02/18 | Perfil institucional/interoperable.              | MICROCREDENTIAL_V1 |
| profile_version           | varchar(32)         | NO       | --                | --               | Versión del profile.                             | 1.0                |
| level_scheme_code         | varchar(80)         | YES      | NULL              | EXT REF          | Scheme de nivel.                                 | INST_LEVEL         |
| level_code                | varchar(80)         | YES      | NULL              | EXT REF          | Nivel.                                           | L2                 |
| credit_scheme_code        | varchar(80)         | YES      | NULL              | EXT REF          | Scheme de credits si aplica.                     | INST_CREDIT        |
| credit_value              | numeric(10,2)       | YES      | NULL              | CHECK            | Valor crediticio declarado por blueprint/policy. | 2.00               |
| created_at                | timestamptz         | NO       | now()             | --               | Creacion.                                        | ...                |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**microcredential_record_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_award_id —** Award fuente. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: awd....

**credential_issuance_id —** Issuance representativo. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**profile_code —** Perfil institucional/interoperable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: MICROCREDENTIAL_V1.

**profile_version —** Versión del profile. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: 1.0.

**level_scheme_code —** Scheme de nivel. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: INST_LEVEL.

**level_code —** Nivel. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: L2.

**credit_scheme_code —** Scheme de credits si aplica. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: INST_CREDIT.

**credit_value —** Valor crediticio declarado por blueprint/policy. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: 2.00.

**created_at —** Creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                 | **Tipo** | **Definicion/expresion**                           | **Error que impide**                                                                   |
|-----------------------------------|----------|----------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_microcredential_record    | PK       | PRIMARY KEY (tenant_id, microcredential_record_id) | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_microcredential_record_01 | CHECK    | CHECK (credit_value IS NULL OR credit_value \> 0)  | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_microcredential_record_02 | UQ/INDEX | UNIQUE (tenant_id, credential_award_id)            | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_microcredential_record   | RLS      | tenant_id = current_setting('peopleu.tenant_id')   | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.23 ec08_cumulative_evaluation

QUE REPRESENTA — Representa una decisión puntual sobre si un holder satisface una credencial acumulativa usando awards, statuses y/o progress facts pinneados.

COMO PARTICIPA ARQUITECTONICAMENTE — La crea EC-08 a solicitud o event trigger, consumiendo target blueprint/pathway y source awards/EC-10 facts. Agrega CumulativeEvaluationItem y terminaliza ELIGIBLE/INELIGIBLE/ERROR.

QUE PROTEGE / QUE NO REPRESENTA — Protege que stacking no sea una suma informal de certificados. No mantiene progress continuo ni borra awards fuente.

| **Campo**                       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                               | **Ejemplo**         |
|---------------------------------|---------------------|----------|-------------------|---------------------|-----------------------------------------------|---------------------|
| tenant_id                       | uuid                | NO       | --                | PK\*                | Tenant derivado del contexto autorizado.      | 8a6...              |
| cumulative_evaluation_id        | uuid                | NO       | gen_random_uuid() | PK                  | Identificador técnico estable.                | id...               |
| subject_ref                     | uuid                | NO       | --                | EXT REF CT-04       | Holder.                                       | sub...              |
| target_credential_blueprint_ref | uuid                | NO       | --                | EXT REF EC-01       | Blueprint acumulativo.                        | cbp...              |
| pathway_version_ref             | uuid                | YES      | NULL              | EXT REF EC-01/EC-10 | Pathway versión usado.                        | pathv...            |
| policy_ref                      | uuid                | NO       | --                | EXT REF CT-02       | Policy de stacking.                           | pol...              |
| source_set_hash                 | varchar(128)        | NO       | --                | UQ\*                | Hash de conjunto fuente pinneado.             | sha256:...          |
| state                           | varchar(24)         | NO       | 'PENDING'         | CHECK               | PENDING/EVALUATING/ELIGIBLE/INELIGIBLE/ERROR. | ELIGIBLE            |
| evaluated_at                    | timestamptz         | YES      | NULL              | --                  | Terminal time.                                | ...                 |
| reason_code                     | varchar(80)         | YES      | NULL              | --                  | Reason principal.                             | ALL_NODES_SATISFIED |
| created_at                      | timestamptz         | NO       | now()             | --                  | Instante UTC de creacion.                     | 2026-09-11T13:00Z   |
| updated_at                      | timestamptz         | NO       | now()             | --                  | Última mutacion permitida.                    | 2026-09-11T13:10Z   |
| versión                         | bigint              | NO       | 0                 | --                  | Optimistic lock / aggregate revisión.         | 3                   |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**cumulative_evaluation_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**subject_ref —** Holder. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: sub....

**target_credential_blueprint_ref —** Blueprint acumulativo. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: cbp....

**pathway_version_ref —** Pathway versión usado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pathv....

**policy_ref —** Policy de stacking. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol....

**source_set_hash —** Hash de conjunto fuente pinneado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**state —** PENDING/EVALUATING/ELIGIBLE/INELIGIBLE/ERROR. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: ELIGIBLE.

**evaluated_at —** Terminal time. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**reason_code —** Reason principal. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: ALL_NODES_SATISFIED.

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**                | **Tipo** | **Definicion/expresion**                                                          | **Error que impide**                                                                   |
|----------------------------------|----------|-----------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_cumulative_evaluation    | PK       | PRIMARY KEY (tenant_id, cumulative_evaluation_id)                                 | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_cumulative_evaluation_01 | CHECK    | CHECK (state IN ('PENDING','EVALUATING','ELIGIBLE','INELIGIBLE','ERROR'))         | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_cumulative_evaluation_02 | UQ/INDEX | UNIQUE (tenant_id, subject_ref, target_credential_blueprint_ref, source_set_hash) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_cumulative_evaluation   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                  | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.24 ec08_cumulative_evaluation_item

QUE REPRESENTA — Representa cada source award/fact/nodo considerado por una CumulativeEvaluation y su resultado puntual.

COMO PARTICIPA ARQUITECTONICAMENTE — Es hijo append-only. Puede referenciar CredentialAward EC-08, EC-10 progress fact o credencial externa gobernada; source_type determina que columna/ref aplica.

QUE PROTEGE / QUE NO REPRESENTA — Protege provenance y same-holder checks. No consume/destruye la credencial fuente.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                          | **Ejemplo**  |
|--------------------------|---------------------|----------|-------------------|-----------|------------------------------------------|--------------|
| tenant_id                | uuid                | NO       | --                | PK\*      | Tenant derivado del contexto autorizado. | 8a6...       |
| cumulative_item_id       | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico estable.           | id...        |
| cumulative_evaluation_id | uuid                | NO       | --                | FK        | Evaluation padre.                        | ce...        |
| source_type              | varchar(32)         | NO       | --                | CHECK     | AWARD/PATH_PROGRESS/EXTERNAL_CREDENTIAL. | AWARD        |
| source_award_id          | uuid                | YES      | NULL              | FK        | Award local si source_type=AWARD.        | awd...       |
| external_source_ref      | uuid                | YES      | NULL              | EXT REF   | Fact/progress/credential externa.        | ext...       |
| requirement_code         | varchar(80)         | NO       | --                | --        | Nodo/regla evaluada.                     | STACK_NODE_1 |
| outcome                  | varchar(24)         | NO       | --                | CHECK     | PASS/FAIL/UNKNOWN.                       | PASS         |
| source_status_code       | varchar(24)         | YES      | NULL              | --        | Status pinneado de source.               | AWARDED      |
| source_as_of             | timestamptz         | YES      | NULL              | --        | As-of del source.                        | ...          |
| created_at               | timestamptz         | NO       | now()             | --        | Append-only.                             | ...          |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**cumulative_item_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**cumulative_evaluation_id —** Evaluation padre. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: ce....

**source_type —** AWARD/PATH_PROGRESS/EXTERNAL_CREDENTIAL. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: AWARD.

**source_award_id —** Award local si source_type=AWARD. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: awd....

**external_source_ref —** Fact/progress/credential externa. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: ext....

**requirement_code —** Nodo/regla evaluada. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: STACK_NODE_1.

**outcome —** PASS/FAIL/UNKNOWN. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: PASS.

**source_status_code —** Status pinneado de source. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: AWARDED.

**source_as_of —** As-of del source. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                               | **Tipo** | **Definicion/expresion**                                                                                                                                                                  | **Error que impide**                                                                   |
|-------------------------------------------------|----------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_cumulative_evaluation_item              | PK       | PRIMARY KEY (tenant_id, cumulative_item_id)                                                                                                                                               | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_cumulative_evaluation_item_01           | CHECK    | CHECK (source_type IN ('AWARD','PATH_PROGRESS','EXTERNAL_CREDENTIAL'))                                                                                                                    | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_cumulative_evaluation_item_02           | CHECK    | CHECK (outcome IN ('PASS','FAIL','UNKNOWN'))                                                                                                                                              | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_cumulative_evaluation_item_03           | CHECK    | CHECK ((source_type='AWARD' AND source_award_id IS NOT NULL AND external_source_ref IS NULL) OR (source_type\<\>'AWARD' AND source_award_id IS NULL AND external_source_ref IS NOT NULL)) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_cumulative_evaluation_item_04           | UQ/INDEX | UNIQUE (tenant_id, cumulative_evaluation_id, requirement_code, source_type, source_award_id, external_source_ref)                                                                         | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_cumulative_evaluation_item             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                                                                                                                          | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_cumulative_evaluation_item_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                                                                                                                                      | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.25 ec08_cumulative_award_link

QUE REPRESENTA — Vincula una CumulativeEvaluation ELIGIBLE con el CredentialAward target creado a partir de ella.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea atomically con el target award para evitar awards acumulativos sin evidence. Permite navegar lineage desde target hacia evaluation/source items.

QUE PROTEGE / QUE NO REPRESENTA — Protege unicidad 1:1 evaluation-target award. No es progress engine.

| **Campo**                  | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                          | **Ejemplo**   |
|----------------------------|---------------------|----------|-------------------|-----------|------------------------------------------|---------------|
| tenant_id                  | uuid                | NO       | --                | PK\*      | Tenant derivado del contexto autorizado. | 8a6...        |
| cumulative_award_link_id   | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico estable.           | id...         |
| cumulative_evaluation_id   | uuid                | NO       | --                | FK/UQ     | Evaluation eligible.                     | ce...         |
| target_credential_award_id | uuid                | NO       | --                | FK/UQ     | Award acumulativo resultante.            | awd-target... |
| created_at                 | timestamptz         | NO       | now()             | --        | Append-only.                             | ...           |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**cumulative_award_link_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**cumulative_evaluation_id —** Evaluation eligible. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: ce....

**target_credential_award_id —** Award acumulativo resultante. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: awd-target....

**created_at —** Append-only. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**                          | **Tipo** | **Definicion/expresion**                          | **Error que impide**                                                                   |
|--------------------------------------------|----------|---------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_cumulative_award_link              | PK       | PRIMARY KEY (tenant_id, cumulative_award_link_id) | Impide identidad duplicada dentro del tenant.                                          |
| uq_ec08_cumulative_award_link_01           | UQ/INDEX | UNIQUE (tenant_id, cumulative_evaluation_id)      | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_cumulative_award_link_02           | UQ/INDEX | UNIQUE (tenant_id, target_credential_award_id)    | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_cumulative_award_link             | RLS      | tenant_id = current_setting('peopleu.tenant_id')  | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_cumulative_award_link_append_only | TRIGGER  | FORBID UPDATE/DELETE                              | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.26 ec08_credential_batch

QUE REPRESENTA — Representa una operación masiva gobernada para evaluar/adjudicar/emitir credenciales a un conjunto fijo de candidatos. El batch conserva input hash, policy refs, limits y estado global.

COMO PARTICIPA ARQUITECTONICAMENTE — Lo crea Credential Operator y se sella luego de preflight. Workers procesan items independientemente. El batch agrega CredentialBatchItem y calcula COMPLETED/PARTIAL/FAILED sin transacción distribuida gigante.

QUE PROTEGE / QUE NO REPRESENTA — Protege selection reproducible y partial success. No autoriza bypass de reglas individuales ni emisión directa por SQL.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                          | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.                 | 8a6...            |
| credential_batch_id      | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                           | id...             |
| batch_code               | varchar(96)         | NO       | --                | UQ            | Código institucional.                                    | CB-2026-009       |
| batch_kind               | varchar(32)         | NO       | --                | CHECK         | ELIGIBILITY/AWARD/ISSUE/DELIVER.                         | ISSUE             |
| credential_blueprint_ref | uuid                | YES      | NULL              | EXT REF EC-01 | Blueprint comun cuándo aplica.                           | cbp...            |
| input_snapshot_hash      | varchar(128)        | YES      | NULL              | --            | Hash de selection/input sellado.                         | sha256:...        |
| policy_ref               | uuid                | NO       | --                | EXT REF CT-02 | Policy batch.                                            | pol...            |
| state                    | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/SEALED/RUNNING/COMPLETED/PARTIAL/FAILED/CANCELLED. | RUNNING           |
| total_items              | integer             | NO       | 0                 | CHECK         | Cantidad total.                                          | 500               |
| succeeded_items          | integer             | NO       | 0                 | CHECK         | Items exitosos.                                          | 480               |
| failed_items             | integer             | NO       | 0                 | CHECK         | Items fallidos.                                          | 20                |
| created_by_subject       | uuid                | NO       | --                | EXT REF IAM   | Creador.                                                 | usr...            |
| sealed_at                | timestamptz         | YES      | NULL              | --            | Instante de sellado.                                     | ...               |
| created_at               | timestamptz         | NO       | now()             | --            | Instante UTC de creacion.                                | 2026-09-11T13:00Z |
| updated_at               | timestamptz         | NO       | now()             | --            | Última mutacion permitida.                               | 2026-09-11T13:10Z |
| versión                  | bigint              | NO       | 0                 | --            | Optimistic lock / aggregate revisión.                    | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**credential_batch_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**batch_code —** Código institucional. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: CB-2026-009.

**batch_kind —** ELIGIBILITY/AWARD/ISSUE/DELIVER. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: ISSUE.

**credential_blueprint_ref —** Blueprint comun cuándo aplica. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: cbp....

**input_snapshot_hash —** Hash de selection/input sellado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**policy_ref —** Policy batch. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: pol....

**state —** DRAFT/SEALED/RUNNING/COMPLETED/PARTIAL/FAILED/CANCELLED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'DRAFT'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: RUNNING.

**total_items —** Cantidad total. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 500.

**succeeded_items —** Items exitosos. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 480.

**failed_items —** Items fallidos. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 20.

**created_by_subject —** Creador. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: usr....

**sealed_at —** Instante de sellado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**           | **Tipo** | **Definicion/expresion**                                                                                                      | **Error que impide**                                                                   |
|-----------------------------|----------|-------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_batch    | PK       | PRIMARY KEY (tenant_id, credential_batch_id)                                                                                  | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_credential_batch_01 | CHECK    | CHECK (batch_kind IN ('ELIGIBILITY','AWARD','ISSUE','DELIVER'))                                                               | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_credential_batch_02 | CHECK    | CHECK (state IN ('DRAFT','SEALED','RUNNING','COMPLETED','PARTIAL','FAILED','CANCELLED'))                                      | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_credential_batch_03 | CHECK    | CHECK (total_items \>= 0 AND succeeded_items \>= 0 AND failed_items \>= 0 AND succeeded_items + failed_items \<= total_items) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_credential_batch_04 | UQ/INDEX | UNIQUE (tenant_id, batch_code)                                                                                                | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_batch   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                                                              | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.27 ec08_credential_batch_item

QUE REPRESENTA — Representa un candidato y resultado independiente dentro de CredentialBatch. Conserva subject/enrollment/award/request refs y estado para retry/reconcile.

COMO PARTICIPA ARQUITECTONICAMENTE — Workers claim items por lease y ejecutan el mismo Application Service que la operación individual. Un item terminal no se reprocesa salvo comando explicito de recovery permitido.

QUE PROTEGE / QUE NO REPRESENTA — Protege replay y partial success. No almacena PII completa ni permite que un fallo borre resultados de otros items.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                          | **Ejemplo**       |
|---------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------|-------------------|
| tenant_id           | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.                 | 8a6...            |
| batch_item_id       | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                           | id...             |
| credential_batch_id | uuid                | NO       | --                | FK            | Batch padre.                                             | cb...             |
| item_no             | integer             | NO       | --                | UQ\*          | Secuencia estable dentro de batch.                       | 1                 |
| subject_ref         | uuid                | NO       | --                | EXT REF       | Holder.                                                  | sub...            |
| enrollment_ref      | uuid                | YES      | NULL              | EXT REF EC-04 | Enrollment.                                              | enr...            |
| credential_award_id | uuid                | YES      | NULL              | FK            | Award creado/resuelto.                                   | awd...            |
| issuance_request_id | uuid                | YES      | NULL              | FK            | Issuance request creado.                                 | ir...             |
| state               | varchar(32)         | NO       | 'PENDING'         | CHECK         | PENDING/CLAIMED/SUCCEEDED/FAILED/UNKNOWN_EFFECT/SKIPPED. | SUCCEEDED         |
| reason_code         | varchar(80)         | YES      | NULL              | --            | Resultado.                                               | ISSUED            |
| attempt_count       | integer             | NO       | 0                 | CHECK         | Intentos.                                                | 1                 |
| lease_owner         | varchar(120)        | YES      | NULL              | --            | Worker owner.                                            | worker-2          |
| lease_until         | timestamptz         | YES      | NULL              | --            | Fin lease.                                               | ...               |
| created_at          | timestamptz         | NO       | now()             | --            | Instante UTC de creacion.                                | 2026-09-11T13:00Z |
| updated_at          | timestamptz         | NO       | now()             | --            | Última mutacion permitida.                               | 2026-09-11T13:10Z |
| versión             | bigint              | NO       | 0                 | --            | Optimistic lock / aggregate revisión.                    | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**batch_item_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_batch_id —** Batch padre. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: cb....

**item_no —** Secuencia estable dentro de batch. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: 1.

**subject_ref —** Holder. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: sub....

**enrollment_ref —** Enrollment. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: enr....

**credential_award_id —** Award creado/resuelto. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: awd....

**issuance_request_id —** Issuance request creado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: ir....

**state —** PENDING/CLAIMED/SUCCEEDED/FAILED/UNKNOWN_EFFECT/SKIPPED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: SUCCEEDED.

**reason_code —** Resultado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: ISSUED.

**attempt_count —** Intentos. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 1.

**lease_owner —** Worker owner. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: worker-2.

**lease_until —** Fin lease. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**                | **Tipo** | **Definicion/expresion**                                                               | **Error que impide**                                                                   |
|----------------------------------|----------|----------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_credential_batch_item    | PK       | PRIMARY KEY (tenant_id, batch_item_id)                                                 | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_credential_batch_item_01 | CHECK    | CHECK (item_no \> 0)                                                                   | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_credential_batch_item_02 | CHECK    | CHECK (state IN ('PENDING','CLAIMED','SUCCEEDED','FAILED','UNKNOWN_EFFECT','SKIPPED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_credential_batch_item_03 | CHECK    | CHECK (attempt_count \>= 0)                                                            | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_credential_batch_item_04 | UQ/INDEX | UNIQUE (tenant_id, credential_batch_id, item_no)                                       | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_credential_batch_item   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                       | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.28 ec08_verification_query_receipt

QUE REPRESENTA — Representa telemetria minimizada y auditable de consultas al verifier publico o autenticado cuándo la policy exige conservar evidence operativa/abuse sin registrar el token plano.

COMO PARTICIPA ARQUITECTONICAMENTE — Se escribe fuera del path crítico cuándo sea posible y con retention corto/purpose limitation. Conserva token hash prefix/digest ref, result class, latency y rate-limit outcome.

QUE PROTEGE / QUE NO REPRESENTA — Protege seguridad/operaciones sin crear un historial invasivo de comportamiento. No almacena IP completa ni PII salvo policy legal explicita.

| **Campo**                     | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                | **Ejemplo**             |
|-------------------------------|---------------------|----------|-------------------|---------------|--------------------------------------------------------------------------------|-------------------------|
| tenant_id                     | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.                                       | 8a6...                  |
| verification_query_receipt_id | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                                                 | id...                   |
| verification_handle_id        | uuid                | YES      | NULL              | FK            | Handle si fue resuelto.                                                        | vh...                   |
| query_hash_prefix             | varchar(32)         | YES      | NULL              | --            | Identificador técnico no reversible para correlacion limitada.                 | abc123                  |
| result_code                   | varchar(32)         | NO       | --                | CHECK         | VALID/REVOKED/SUSPENDED/SUPERSEDED/EXPIRED/NOT_FOUND/UNAVAILABLE/RATE_LIMITED. | VALID                   |
| authenticated                 | boolean             | NO       | false             | --            | Verifier autenticado o publico.                                                | false                   |
| latency_ms                    | integer             | NO       | 0                 | CHECK         | Latencia observada.                                                            | 120                     |
| queried_at                    | timestamptz         | NO       | now()             | --            | Instante UTC.                                                                  | ...                     |
| retention_class_code          | varchar(64)         | NO       | --                | EXT REF CT-10 | Clase de retention.                                                            | PUBLIC_VERIFY_TELEMETRY |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**verification_query_receipt_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**verification_handle_id —** Handle si fue resuelto. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: vh....

**query_hash_prefix —** Identificador técnico no reversible para correlacion limitada. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: abc123.

**result_code —** VALID/REVOKED/SUSPENDED/SUPERSEDED/EXPIRED/NOT_FOUND/UNAVAILABLE/RATE_LIMITED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: VALID.

**authenticated —** Verifier autenticado o publico. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es false; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: false.

**latency_ms —** Latencia observada. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 120.

**queried_at —** Instante UTC. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**retention_class_code —** Clase de retention. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: PUBLIC_VERIFY_TELEMETRY.

### Constraints fisicos implementables

| **Nombre físico**                               | **Tipo** | **Definicion/expresion**                                                                                               | **Error que impide**                                                                   |
|-------------------------------------------------|----------|------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_verification_query_receipt              | PK       | PRIMARY KEY (tenant_id, verification_query_receipt_id)                                                                 | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_verification_query_receipt_01           | CHECK    | CHECK (result_code IN ('VALID','REVOKED','SUSPENDED','SUPERSEDED','EXPIRED','NOT_FOUND','UNAVAILABLE','RATE_LIMITED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_verification_query_receipt_02           | CHECK    | CHECK (latency_ms \>= 0)                                                                                               | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_verification_query_receipt             | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                                                       | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |
| trg_ec08_verification_query_receipt_append_only | TRIGGER  | FORBID UPDATE/DELETE                                                                                                   | Impide reescribir o borrar evidence/history oficial.                                   |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. En particular UPDATE/DELETE debe ser rechazado fisicamente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.29 ec08_external_wallet_delivery

QUE REPRESENTA — Representa el estado de una projection/credential delivery hacia una wallet o ecosystem externo gestionado mediante CT-18.

COMO PARTICIPA ARQUITECTONICAMENTE — Se crea por Delivery/Interop worker y conserva provider/profile refs, external credential id, state y reconciliation metadata. La academic truth sigue en award/issuance.

QUE PROTEGE / QUE NO REPRESENTA — Protege UNKNOWN_EFFECT y provider lineage. No guarda access token/secret del wallet.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                       | **Ejemplo**       |
|-----------------------------|---------------------|----------|-------------------|---------------|-----------------------------------------------------------------------|-------------------|
| tenant_id                   | uuid                | NO       | --                | PK\*          | Tenant derivado del contexto autorizado.                              | 8a6...            |
| external_wallet_delivery_id | uuid                | NO       | gen_random_uuid() | PK            | Identificador técnico estable.                                        | id...             |
| credential_issuance_id      | uuid                | NO       | --                | FK            | Issuance fuente.                                                      | iss...            |
| provider_code               | varchar(80)         | NO       | --                | EXT REF CT-18 | Proveedor/adaptador.                                                  | WALLET_X          |
| profile_code                | varchar(80)         | NO       | --                | EXT REF CT-18 | Profile.                                                              | VC_2_0            |
| external_credential_ref     | varchar(240)        | YES      | NULL              | EXT REF       | ID remoto.                                                            | urn:...           |
| state                       | varchar(32)         | NO       | 'PENDING'         | CHECK         | PENDING/IN_FLIGHT/DELIVERED/FAILED/UNKNOWN_EFFECT/REVOKED/SUPERSEDED. | DELIVERED         |
| provider_receipt_ref        | varchar(240)        | YES      | NULL              | EXT REF       | Receipt.                                                              | prov...           |
| last_reconciled_at          | timestamptz         | YES      | NULL              | --            | Última reconciliación.                                                | ...               |
| created_at                  | timestamptz         | NO       | now()             | --            | Instante UTC de creacion.                                             | 2026-09-11T13:00Z |
| updated_at                  | timestamptz         | NO       | now()             | --            | Última mutacion permitida.                                            | 2026-09-11T13:10Z |
| versión                     | bigint              | NO       | 0                 | --            | Optimistic lock / aggregate revisión.                                 | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**external_wallet_delivery_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**credential_issuance_id —** Issuance fuente. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. La referencia es interna a EC-08 y su FK se define tenant-aware para impedir cruces de tenant. Ejemplo: iss....

**provider_code —** Proveedor/adaptador. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: WALLET_X.

**profile_code —** Profile. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: VC_2_0.

**external_credential_ref —** ID remoto. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: urn:....

**state —** PENDING/IN_FLIGHT/DELIVERED/FAILED/UNKNOWN_EFFECT/REVOKED/SUPERSEDED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: DELIVERED.

**provider_receipt_ref —** Receipt. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Es una referencia cross-context: se valida por port/contract y deliberadamente no tiene FK física hacia otro bounded context. Ejemplo: prov....

**last_reconciled_at —** Última reconciliación. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**                   | **Tipo** | **Definicion/expresion**                                                                              | **Error que impide**                                                                   |
|-------------------------------------|----------|-------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_external_wallet_delivery    | PK       | PRIMARY KEY (tenant_id, external_wallet_delivery_id)                                                  | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_external_wallet_delivery_01 | CHECK    | CHECK (state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED','UNKNOWN_EFFECT','REVOKED','SUPERSEDED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| uq_ec08_external_wallet_delivery_02 | UQ/INDEX | UNIQUE (tenant_id, credential_issuance_id, provider_code, profile_code)                               | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_external_wallet_delivery   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                                      | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.30 ec08_idempotency_key

QUE REPRESENTA — Registra adquisicion, payload hash, resultado y lease de comandos sensibles para que un retry de cliente o worker no duplique awards, issuances, revocations, corrections o batches.

COMO PARTICIPA ARQUITECTONICAMENTE — Application layer adquiere la key dentro de frontera transaccional. Same-key/same-payload retorna mismo resultado; same-key/different-payload es 409. IN_PROGRESS con lease vencido se recupera bajo reglas estrictas.

QUE PROTEGE / QUE NO REPRESENTA — Protege efectos duplicados y crash recovery. No es un cache volatil; PostgreSQL es Source of Truth.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**   | **PK/FK** | **Descripción**                         | **Ejemplo**      |
|-----------------|---------------------|----------|---------------|-----------|-----------------------------------------|------------------|
| tenant_id       | uuid                | NO       | --            | PK        | Tenant.                                 | 8a6...           |
| idempotency_key | varchar(160)        | NO       | --            | PK        | Key del caller.                         | idem-...         |
| operation_code  | varchar(80)         | NO       | --            | PK        | Operación.                              | ISSUE_CREDENTIAL |
| payload_hash    | varchar(128)        | NO       | --            | --        | Hash canonico del request relevante.    | sha256:...       |
| state           | varchar(24)         | NO       | 'IN_PROGRESS' | CHECK     | IN_PROGRESS/SUCCEEDED/FAILED.           | SUCCEEDED        |
| resource_ref    | uuid                | YES      | NULL          | --        | Resource creado/resuelto.               | iss...           |
| response_code   | integer             | YES      | NULL          | --        | HTTP/business response cached metadata. | 201              |
| response_hash   | varchar(128)        | YES      | NULL          | --        | Hash response/result.                   | sha256:...       |
| owner_id        | varchar(120)        | YES      | NULL          | --        | Owner lease.                            | api-1            |
| lease_until     | timestamptz         | YES      | NULL          | --        | Fin lease.                              | ...              |
| created_at      | timestamptz         | NO       | now()         | --        | Creacion.                               | ...              |
| updated_at      | timestamptz         | NO       | now()         | --        | Heartbeat/terminal update.              | ...              |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**idempotency_key —** Key del caller. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: idem-....

**operation_code —** Operación. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: ISSUE_CREDENTIAL.

**payload_hash —** Hash canonico del request relevante. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**state —** IN_PROGRESS/SUCCEEDED/FAILED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'IN_PROGRESS'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: SUCCEEDED.

**resource_ref —** Resource creado/resuelto. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: iss....

**response_code —** HTTP/business response cached metadata. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: 201.

**response_hash —** Hash response/result. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**owner_id —** Owner lease. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: api-1.

**lease_until —** Fin lease. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**updated_at —** Heartbeat/terminal update. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**          | **Tipo** | **Definicion/expresion**                              | **Error que impide**                                                                   |
|----------------------------|----------|-------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_idempotency_key    | PK       | PRIMARY KEY (tenant_id, idempotency_key)              | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_idempotency_key_01 | CHECK    | CHECK (state IN ('IN_PROGRESS','SUCCEEDED','FAILED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_idempotency_key   | RLS      | tenant_id = current_setting('peopleu.tenant_id')      | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.31 ec08_outbox_event

QUE REPRESENTA — Representa un integration event pendiente/entregado producido por EC-08 en la misma transacción que el hecho local.

COMO PARTICIPA ARQUITECTONICAMENTE — El dispatcher multi-instancia claim rows con FOR UPDATE SKIP LOCKED y lease. Publica por CT-09/broker, registra attempts y marca SENT solo con confirmacion. Poison events se aislan sin bloquear todo el stream.

QUE PROTEGE / QUE NO REPRESENTA — Protege atomicidad DB+event y recovery. No promete exactly-once distribuido.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                          | **Ejemplo**        |
|-----------------|---------------------|----------|-------------------|-----------|------------------------------------------|--------------------|
| tenant_id       | uuid                | NO       | --                | PK\*      | Tenant derivado del contexto autorizado. | 8a6...             |
| event_id        | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico estable.           | id...              |
| aggregate_type  | varchar(80)         | NO       | --                | --        | Tipo aggregate.                          | CredentialIssuance |
| aggregate_id    | uuid                | NO       | --                | --        | Aggregate id.                            | iss...             |
| event_type      | varchar(120)        | NO       | --                | --        | Nombre contract event.                   | CredentialIssued   |
| schema_version  | varchar(24)         | NO       | --                | --        | Versión AsyncAPI payload.                | 1.0                |
| correlation_id  | uuid                | NO       | --                | --        | Correlation.                             | corr...            |
| causation_id    | uuid                | YES      | NULL              | --        | Causation.                               | cmd...             |
| payload         | jsonb               | NO       | --                | --        | Payload de integración sin secrets.      | {}                 |
| state           | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/SENT/FAILED.           | PENDING            |
| attempt_count   | integer             | NO       | 0                 | CHECK     | Intentos.                                | 0                  |
| lease_owner     | varchar(120)        | YES      | NULL              | --        | Worker.                                  | outbox-1           |
| lease_until     | timestamptz         | YES      | NULL              | --        | Lease.                                   | ...                |
| next_attempt_at | timestamptz         | YES      | NULL              | --        | Backoff.                                 | ...                |
| occurred_at     | timestamptz         | NO       | now()             | --        | Business occurrence.                     | ...                |
| sent_at         | timestamptz         | YES      | NULL              | --        | Confirmacion publish.                    | ...                |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**event_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**aggregate_type —** Tipo aggregate. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: CredentialIssuance.

**aggregate_id —** Aggregate id. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: iss....

**event_type —** Nombre contract event. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: CredentialIssued.

**schema_version —** Versión AsyncAPI payload. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: 1.0.

**correlation_id —** Correlation. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: corr....

**causation_id —** Causation. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: cmd....

**payload —** Payload de integración sin secrets. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: {}.

**state —** PENDING/IN_FLIGHT/SENT/FAILED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: PENDING.

**attempt_count —** Intentos. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 0.

**lease_owner —** Worker. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: outbox-1.

**lease_until —** Lease. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**next_attempt_at —** Backoff. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**occurred_at —** Business occurrence. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**sent_at —** Confirmacion publish. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

### Constraints fisicos implementables

| **Nombre físico**       | **Tipo** | **Definicion/expresion**                                 | **Error que impide**                                                                   |
|-------------------------|----------|----------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_outbox_event    | PK       | PRIMARY KEY (tenant_id, event_id)                        | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_outbox_event_01 | CHECK    | CHECK (state IN ('PENDING','IN_FLIGHT','SENT','FAILED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_outbox_event_02 | CHECK    | CHECK (attempt_count \>= 0)                              | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_outbox_event   | RLS      | tenant_id = current_setting('peopleu.tenant_id')         | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.32 ec08_inbox_message

QUE REPRESENTA — Representa la recepcion durable de un mensaje externo para deduplicar consumers EC-08 bajo entrega at-least-once.

COMO PARTICIPA ARQUITECTONICAMENTE — Cada consumer registra message_id + consumer_code antes/aplicando el efecto en frontera transaccional. Duplicados retornan resultado previo o se ignoran según contract.

QUE PROTEGE / QUE NO REPRESENTA — Protege duplicate delivery de EC-07/CT/Finance/events. No es un event store de toda la empresa.

| **Campo**      | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**                 | **Ejemplo**              |
|----------------|---------------------|----------|-------------|-----------|---------------------------------|--------------------------|
| tenant_id      | uuid                | NO       | --          | PK        | Tenant.                         | 8a6...                   |
| message_id     | uuid                | NO       | --          | PK        | Message id externo.             | msg...                   |
| consumer_code  | varchar(100)        | NO       | --          | PK        | Consumer logico.                | EC08_COMPLETION_CONSUMER |
| event_type     | varchar(120)        | NO       | --          | --        | Tipo recibido.                  | CompletionFactPublished  |
| schema_version | varchar(24)         | NO       | --          | --        | Versión contract.               | 1.0                      |
| payload_hash   | varchar(128)        | NO       | --          | --        | Hash payload.                   | sha256:...               |
| state          | varchar(24)         | NO       | 'PROCESSED' | CHECK     | PROCESSED/REJECTED/QUARANTINED. | PROCESSED                |
| received_at    | timestamptz         | NO       | now()       | --        | Recepcion.                      | ...                      |
| processed_at   | timestamptz         | YES      | NULL        | --        | Finalizacion.                   | ...                      |
| reason_code    | varchar(80)         | YES      | NULL        | --        | Motivo reject/quarantine.       | UNSUPPORTED_SCHEMA       |

### Explicación individual de atributos

**tenant_id —** Tenant. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**message_id —** Message id externo. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: msg....

**consumer_code —** Consumer logico. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: EC08_COMPLETION_CONSUMER.

**event_type —** Tipo recibido. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: CompletionFactPublished.

**schema_version —** Versión contract. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: 1.0.

**payload_hash —** Hash payload. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El algoritmo/esquema asociado debe quedar versionado cuándo el hash se use cómo evidencia historica. Ejemplo: sha256:....

**state —** PROCESSED/REJECTED/QUARANTINED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PROCESSED'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: PROCESSED.

**received_at —** Recepcion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**processed_at —** Finalizacion. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**reason_code —** Motivo reject/quarantine. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: UNSUPPORTED_SCHEMA.

### Constraints fisicos implementables

| **Nombre físico**        | **Tipo** | **Definicion/expresion**                                | **Error que impide**                                                                   |
|--------------------------|----------|---------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_inbox_message    | PK       | PRIMARY KEY (tenant_id, message_id)                     | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_inbox_message_01 | CHECK    | CHECK (state IN ('PROCESSED','REJECTED','QUARANTINED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_inbox_message   | RLS      | tenant_id = current_setting('peopleu.tenant_id')        | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.33 ec08_operation_status

QUE REPRESENTA — Representa el estado consultable de una operación asincrona iniciada con HTTP 202 o que requiere reconcile, por ejemplo document/signing, wallet delivery o batch.

COMO PARTICIPA ARQUITECTONICAMENTE — La crea Application Service y la actualizan workers con versión/lease. Frontend consulta por operationId. UNKNOWN_EFFECT es estado de primera clase y no se oculta bajo FAILED.

QUE PROTEGE / QUE NO REPRESENTA — Protege experiencia y resiliencia E2E. No reemplaza el state del aggregate de negocio; referencia resource_ref cuándo ya existe.

| **Campo**        | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                            | **Ejemplo**       |
|------------------|---------------------|----------|-------------------|-----------|------------------------------------------------------------|-------------------|
| tenant_id        | uuid                | NO       | --                | PK\*      | Tenant derivado del contexto autorizado.                   | 8a6...            |
| operation_id     | uuid                | NO       | gen_random_uuid() | PK        | Identificador técnico estable.                             | id...             |
| operation_code   | varchar(80)         | NO       | --                | --        | Tipo de operación.                                         | ISSUE_CREDENTIAL  |
| resource_ref     | uuid                | YES      | NULL              | --        | Resource asociado.                                         | iss...            |
| state            | varchar(32)         | NO       | 'PENDING'         | CHECK     | PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. | RUNNING           |
| progress_percent | numeric(5,2)        | NO       | 0                 | CHECK     | Progreso 0..100.                                           | 50.00             |
| reason_code      | varchar(80)         | YES      | NULL              | --        | Reason terminal/diagnostico.                               | CT05_TIMEOUT      |
| correlation_id   | uuid                | NO       | --                | --        | Correlation.                                               | corr...           |
| started_at       | timestamptz         | YES      | NULL              | --        | Inicio.                                                    | ...               |
| finished_at      | timestamptz         | YES      | NULL              | --        | Fin terminal.                                              | ...               |
| lease_owner      | varchar(120)        | YES      | NULL              | --        | Worker.                                                    | op-1              |
| lease_until      | timestamptz         | YES      | NULL              | --        | Lease.                                                     | ...               |
| created_at       | timestamptz         | NO       | now()             | --        | Instante UTC de creacion.                                  | 2026-09-11T13:00Z |
| updated_at       | timestamptz         | NO       | now()             | --        | Última mutacion permitida.                                 | 2026-09-11T13:10Z |
| versión          | bigint              | NO       | 0                 | --        | Optimistic lock / aggregate revisión.                      | 3                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del contexto autorizado. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Nunca se acepta desde un body libre; proviene del Security/TenantContext y participa en RLS y en claves internas. Ejemplo: 8a6....

**operation_id —** Identificador técnico estable. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es gen_random_uuid(); la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: id....

**operation_code —** Tipo de operación. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: ISSUE_CREDENTIAL.

**resource_ref —** Resource asociado. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: iss....

**state —** PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 'PENDING'; la aplicación no debe depender de un default distinto al contrato Flyway. Las transiciones no se implementan cómo setter generico; pasan por command/policy y guards fisicos cuándo corresponda. Ejemplo: RUNNING.

**progress_percent —** Progreso 0..100. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Ejemplo: 50.00.

**reason_code —** Reason terminal/diagnostico. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: CT05_TIMEOUT.

**correlation_id —** Correlation. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. Ejemplo: corr....

**started_at —** Inicio. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**finished_at —** Fin terminal. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**lease_owner —** Worker. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Ejemplo: op-1.

**lease_until —** Lease. Puede ser NULL solo cuándo la ausencia tiene significado de negocio documentado; el Backend no debe convertir NULL en un valor favorable por defecto. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: ....

**created_at —** Instante UTC de creacion. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:00Z.

**updated_at —** Última mutacion permitida. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es now(); la aplicación no debe depender de un default distinto al contrato Flyway. Se persiste en UTC; timezone se aplica solo al presentar. Ejemplo: 2026-09-11T13:10Z.

**versión —** Optimistic lock / aggregate revisión. Es obligatorio; NULL no debe confundirse con ausencia valida, cero, cadena vacia ni un estado favorable. El default físico es 0; la aplicación no debe depender de un default distinto al contrato Flyway. Se mapea con @Versión; una revisión obsoleta produce 412 PRECONDITION_FAILED mediante ETag/If-Match, no last-write-wins. Ejemplo: 3.

### Constraints fisicos implementables

| **Nombre físico**           | **Tipo** | **Definicion/expresion**                                                                 | **Error que impide**                                                                   |
|-----------------------------|----------|------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| pk_ec08_operation_status    | PK       | PRIMARY KEY (tenant_id, operation_id)                                                    | Impide identidad duplicada dentro del tenant.                                          |
| ck_ec08_operation_status_01 | CHECK    | CHECK (state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED')) | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| ck_ec08_operation_status_02 | CHECK    | CHECK (progress_percent \>= 0 AND progress_percent \<= 100)                              | Impide estados, cardinalidad o duplicados incompatibles con la semántica de la tabla.  |
| rls_ec08_operation_status   | RLS      | tenant_id = current_setting('peopleu.tenant_id')                                         | Impide lectura/escritura cross-tenant desde runtime incluso ante un bug de repository. |

| QUE DEBE IMPEDIR POSTGRESQL? — Debe impedir duplicados incompatibles con el dominio, referencias internas cross-tenant, estados fuera de lifecycle y cualquier mutacion de history/evidence que esta tabla declare inmutable. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 13. DDL PostgreSQL completo — Flyway Ready

| **DDL NORMATIVO — Los nombres de migrations pueden adaptarse al repositorio, pero constraints, tenant isolation, append-only history, FK internas y estados deben conservar la semántica definida. Ejecutar en CI contra PostgreSQL real/Testcontainers; no validar solo con H2.** |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 13.1 Bootstrap de esquema y extensiones

```
CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE SCHEMA IF NOT EXISTS ec08;
```

## 13.2 Tablas y constraints base

### ec08_credential_eligibility_evaluation

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_eligibility_evaluation (
tenant_id uuid NOT NULL,
eligibility_evaluation_id uuid DEFAULT gen_random_uuid() NOT NULL,
subject_ref uuid NOT NULL,
enrollment_ref uuid DEFAULT NULL,
credential_blueprint_ref uuid NOT NULL,
completion_fact_ref uuid DEFAULT NULL,
eligibility_policy_ref uuid NOT NULL,
state varchar(24) DEFAULT 'PENDING' NOT NULL,
policy_snapshot_hash varchar(128) DEFAULT NULL,
evaluated_at timestamptz DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_credential_eligibility_evaluation PRIMARY KEY (tenant_id, eligibility_evaluation_id),
CONSTRAINT ck_ec08_credential_eligibility_evaluation_01 CHECK (state IN ('PENDING','EVALUATING','ELIGIBLE','INELIGIBLE','ERROR')),
CONSTRAINT ck_ec08_credential_eligibility_evaluation_02 CHECK ((state IN ('ELIGIBLE','INELIGIBLE','ERROR')) = (evaluated_at IS NOT NULL))
);
```

### ec08_credential_eligibility_rule_fact

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_eligibility_rule_fact (
tenant_id uuid NOT NULL,
rule_fact_id uuid DEFAULT gen_random_uuid() NOT NULL,
eligibility_evaluation_id uuid NOT NULL,
rule_code varchar(80) NOT NULL,
source_context varchar(48) NOT NULL,
source_ref uuid DEFAULT NULL,
source_as_of timestamptz DEFAULT NULL,
outcome varchar(24) NOT NULL,
reason_code varchar(80) NOT NULL,
evidence_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_credential_eligibility_rule_fact PRIMARY KEY (tenant_id, rule_fact_id),
CONSTRAINT ck_ec08_credential_eligibility_rule_fact_01 CHECK (outcome IN ('PASS','FAIL','UNKNOWN','NOT_APPLICABLE')),
CONSTRAINT uq_ec08_credential_eligibility_rule_fact_02 UNIQUE (tenant_id, eligibility_evaluation_id, rule_code)
);
```

### ec08_credential_award

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_award (
tenant_id uuid NOT NULL,
credential_award_id uuid DEFAULT gen_random_uuid() NOT NULL,
award_code varchar(96) NOT NULL,
subject_ref uuid NOT NULL,
enrollment_ref uuid DEFAULT NULL,
credential_blueprint_ref uuid NOT NULL,
eligibility_evaluation_id uuid NOT NULL,
award_policy_ref uuid NOT NULL,
state varchar(24) DEFAULT 'AWARDED' NOT NULL,
awarded_at timestamptz DEFAULT now() NOT NULL,
awarded_by_subject uuid NOT NULL,
reason_code varchar(80) DEFAULT 'ELIGIBLE' NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_credential_award PRIMARY KEY (tenant_id, credential_award_id),
CONSTRAINT ck_ec08_credential_award_01 CHECK (state IN ('AWARDED','SUSPENDED','REVOKED','VOID')),
CONSTRAINT uq_ec08_credential_award_02 UNIQUE (tenant_id, award_code)
);
```

### ec08_award_evidence_ref

```
CREATE TABLE IF NOT EXISTS ec08.ec08_award_evidence_ref (
tenant_id uuid NOT NULL,
award_evidence_ref_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_award_id uuid NOT NULL,
evidence_kind varchar(64) NOT NULL,
source_context varchar(48) NOT NULL,
source_ref uuid NOT NULL,
content_hash varchar(128) DEFAULT NULL,
captured_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_award_evidence_ref PRIMARY KEY (tenant_id, award_evidence_ref_id),
CONSTRAINT uq_ec08_award_evidence_ref_01 UNIQUE (tenant_id, credential_award_id, evidence_kind, source_context, source_ref)
);
```

### ec08_issuance_request

```
CREATE TABLE IF NOT EXISTS ec08.ec08_issuance_request (
tenant_id uuid NOT NULL,
issuance_request_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_award_id uuid NOT NULL,
request_kind varchar(40) DEFAULT 'INITIAL' NOT NULL,
requested_locale varchar(16) DEFAULT NULL,
interop_profile_code varchar(80) DEFAULT NULL,
requested_by_subject uuid NOT NULL,
state varchar(24) DEFAULT 'PENDING' NOT NULL,
reason_code varchar(80) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_issuance_request PRIMARY KEY (tenant_id, issuance_request_id),
CONSTRAINT ck_ec08_issuance_request_01 CHECK (request_kind IN ('INITIAL','CORRECTION','REISSUE','CUMULATIVE')),
CONSTRAINT ck_ec08_issuance_request_02 CHECK (state IN ('PENDING','PROCESSING','SUCCEEDED','FAILED','CANCELLED','UNKNOWN_EFFECT'))
);
```

### ec08_credential_issuance

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_issuance (
tenant_id uuid NOT NULL,
credential_issuance_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_award_id uuid NOT NULL,
issuance_request_id uuid NOT NULL,
credential_serial varchar(128) NOT NULL,
issuance_no integer DEFAULT 1 NOT NULL,
issuer_scope_ref uuid NOT NULL,
issuance_policy_ref uuid NOT NULL,
state varchar(24) DEFAULT 'ISSUING' NOT NULL,
content_hash varchar(128) DEFAULT NULL,
hash_algorithm varchar(32) DEFAULT NULL,
canonical_schema_version varchar(32) DEFAULT NULL,
issued_at timestamptz DEFAULT NULL,
issued_by_subject uuid DEFAULT NULL,
supersedes_issuance_id uuid DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_credential_issuance PRIMARY KEY (tenant_id, credential_issuance_id),
CONSTRAINT ck_ec08_credential_issuance_01 CHECK (issuance_no > 0),
CONSTRAINT ck_ec08_credential_issuance_02 CHECK (state IN ('ISSUING','ISSUED','SUSPENDED','REVOKED','SUPERSEDED','VOID','FAILED')),
CONSTRAINT uq_ec08_credential_issuance_03 UNIQUE (tenant_id, credential_serial),
CONSTRAINT uq_ec08_credential_issuance_04 UNIQUE (tenant_id, credential_award_id, issuance_no),
CONSTRAINT ck_ec08_credential_issuance_05 CHECK (supersedes_issuance_id IS NULL OR supersedes_issuance_id <> credential_issuance_id)
);
```

### ec08_credential_payload_snapshot

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_payload_snapshot (
tenant_id uuid NOT NULL,
payload_snapshot_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
payload_json jsonb NOT NULL,
canonical_schema_version varchar(32) NOT NULL,
content_hash varchar(128) NOT NULL,
hash_algorithm varchar(32) DEFAULT 'SHA-256' NOT NULL,
holder_display_name varchar(240) NOT NULL,
credential_title varchar(240) NOT NULL,
issuer_display_name varchar(240) NOT NULL,
locale_code varchar(16) DEFAULT 'es-BO' NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_credential_payload_snapshot PRIMARY KEY (tenant_id, payload_snapshot_id),
CONSTRAINT uq_ec08_credential_payload_snapshot_01 UNIQUE (tenant_id, credential_issuance_id)
);
```

### ec08_credential_document_binding

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_document_binding (
tenant_id uuid NOT NULL,
document_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
document_ref uuid NOT NULL,
document_role varchar(40) DEFAULT 'PRIMARY' NOT NULL,
template_ref uuid DEFAULT NULL,
document_hash varchar(128) DEFAULT NULL,
mime_type varchar(80) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_credential_document_binding PRIMARY KEY (tenant_id, document_binding_id),
CONSTRAINT ck_ec08_credential_document_binding_01 CHECK (document_role IN ('PRIMARY','ALTERNATE','ACCESSIBLE_COPY','ARCHIVAL')),
CONSTRAINT uq_ec08_credential_document_binding_02 UNIQUE (tenant_id, credential_issuance_id, document_ref)
);
```

### ec08_signing_receipt

```
CREATE TABLE IF NOT EXISTS ec08.ec08_signing_receipt (
tenant_id uuid NOT NULL,
signing_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
signed_object_kind varchar(32) NOT NULL,
key_ref varchar(200) NOT NULL,
algorithm_code varchar(48) NOT NULL,
digest varchar(256) NOT NULL,
provider_ref varchar(160) DEFAULT NULL,
signed_at timestamptz NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_signing_receipt PRIMARY KEY (tenant_id, signing_receipt_id),
CONSTRAINT ck_ec08_signing_receipt_01 CHECK (signed_object_kind IN ('PAYLOAD','DOCUMENT','BOTH'))
);
```

### ec08_verification_handle

```
CREATE TABLE IF NOT EXISTS ec08.ec08_verification_handle (
tenant_id uuid NOT NULL,
verification_handle_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
token_hash varchar(128) NOT NULL,
token_hash_algorithm varchar(32) DEFAULT 'SHA-256' NOT NULL,
state varchar(24) DEFAULT 'ACTIVE' NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
disabled_at timestamptz DEFAULT NULL,
disable_reason_code varchar(80) DEFAULT NULL,
CONSTRAINT pk_ec08_verification_handle PRIMARY KEY (tenant_id, verification_handle_id),
CONSTRAINT ck_ec08_verification_handle_01 CHECK (state IN ('ACTIVE','DISABLED','ROTATED')),
CONSTRAINT uq_ec08_verification_handle_02 UNIQUE (token_hash),
CONSTRAINT uq_ec08_verification_handle_03 UNIQUE (tenant_id, credential_issuance_id)
);
```

### ec08_credential_status_fact

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_status_fact (
tenant_id uuid NOT NULL,
status_fact_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
sequence_no bigint NOT NULL,
status_code varchar(24) NOT NULL,
effective_at timestamptz DEFAULT now() NOT NULL,
reason_code varchar(80) NOT NULL,
decision_ref uuid DEFAULT NULL,
actor_subject uuid NOT NULL,
policy_ref uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_credential_status_fact PRIMARY KEY (tenant_id, status_fact_id),
CONSTRAINT ck_ec08_credential_status_fact_01 CHECK (sequence_no > 0),
CONSTRAINT ck_ec08_credential_status_fact_02 CHECK (status_code IN ('ISSUED','SUSPENDED','REVOKED','SUPERSEDED','VOID')),
CONSTRAINT uq_ec08_credential_status_fact_03 UNIQUE (tenant_id, credential_issuance_id, sequence_no)
);
```

### ec08_status_restatement

```
CREATE TABLE IF NOT EXISTS ec08.ec08_status_restatement (
tenant_id uuid NOT NULL,
status_restatement_id uuid DEFAULT gen_random_uuid() NOT NULL,
status_fact_id uuid NOT NULL,
restated_status_code varchar(24) NOT NULL,
reason_code varchar(80) NOT NULL,
decision_ref uuid NOT NULL,
effective_at timestamptz DEFAULT now() NOT NULL,
actor_subject uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_status_restatement PRIMARY KEY (tenant_id, status_restatement_id),
CONSTRAINT ck_ec08_status_restatement_01 CHECK (restated_status_code IN ('ISSUED','SUSPENDED','REVOKED','SUPERSEDED','VOID'))
);
```

### ec08_revocation_case

```
CREATE TABLE IF NOT EXISTS ec08.ec08_revocation_case (
tenant_id uuid NOT NULL,
revocation_case_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
case_kind varchar(32) NOT NULL,
state varchar(32) DEFAULT 'DRAFT' NOT NULL,
reason_code varchar(80) NOT NULL,
details_text text DEFAULT NULL,
workflow_ref uuid DEFAULT NULL,
opened_by_subject uuid NOT NULL,
assurance_level varchar(40) DEFAULT NULL,
closed_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_revocation_case PRIMARY KEY (tenant_id, revocation_case_id),
CONSTRAINT ck_ec08_revocation_case_01 CHECK (case_kind IN ('SUSPENSION','REVOCATION')),
CONSTRAINT ck_ec08_revocation_case_02 CHECK (state IN ('DRAFT','SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','CLOSED','CANCELLED'))
);
```

### ec08_revocation_decision

```
CREATE TABLE IF NOT EXISTS ec08.ec08_revocation_decision (
tenant_id uuid NOT NULL,
revocation_decision_id uuid DEFAULT gen_random_uuid() NOT NULL,
revocation_case_id uuid NOT NULL,
decision_code varchar(24) NOT NULL,
action_code varchar(24) DEFAULT NULL,
reason_code varchar(80) NOT NULL,
decided_by_subject uuid NOT NULL,
decided_at timestamptz DEFAULT now() NOT NULL,
evidence_pack_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_revocation_decision PRIMARY KEY (tenant_id, revocation_decision_id),
CONSTRAINT ck_ec08_revocation_decision_01 CHECK (decision_code IN ('APPROVE','REJECT')),
CONSTRAINT ck_ec08_revocation_decision_02 CHECK (action_code IS NULL OR action_code IN ('SUSPEND','REVOKE','NO_ACTION')),
CONSTRAINT uq_ec08_revocation_decision_03 UNIQUE (tenant_id, revocation_case_id)
);
```

### ec08_correction_request

```
CREATE TABLE IF NOT EXISTS ec08.ec08_correction_request (
tenant_id uuid NOT NULL,
correction_request_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
requested_by_subject uuid NOT NULL,
claimed_field_code varchar(80) DEFAULT NULL,
claimed_value_text text DEFAULT NULL,
classification_code varchar(32) DEFAULT NULL,
state varchar(32) DEFAULT 'DRAFT' NOT NULL,
reason_code varchar(80) NOT NULL,
workflow_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_correction_request PRIMARY KEY (tenant_id, correction_request_id),
CONSTRAINT ck_ec08_correction_request_01 CHECK (classification_code IS NULL OR classification_code IN ('RENDER_ONLY','MATERIAL_REISSUE','REJECT')),
CONSTRAINT ck_ec08_correction_request_02 CHECK (state IN ('DRAFT','SUBMITTED','CLASSIFIED','APPROVED','REJECTED','APPLIED','CLOSED','CANCELLED'))
);
```

### ec08_correction_decision

```
CREATE TABLE IF NOT EXISTS ec08.ec08_correction_decision (
tenant_id uuid NOT NULL,
correction_decision_id uuid DEFAULT gen_random_uuid() NOT NULL,
correction_request_id uuid NOT NULL,
decision_code varchar(24) NOT NULL,
classification_code varchar(32) NOT NULL,
reason_code varchar(80) NOT NULL,
decided_by_subject uuid NOT NULL,
decided_at timestamptz DEFAULT now() NOT NULL,
evidence_pack_ref uuid DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_correction_decision PRIMARY KEY (tenant_id, correction_decision_id),
CONSTRAINT ck_ec08_correction_decision_01 CHECK (decision_code IN ('APPROVE','REJECT')),
CONSTRAINT ck_ec08_correction_decision_02 CHECK (classification_code IN ('RENDER_ONLY','MATERIAL_REISSUE','REJECT')),
CONSTRAINT uq_ec08_correction_decision_03 UNIQUE (tenant_id, correction_request_id)
);
```

### ec08_supersession_link

```
CREATE TABLE IF NOT EXISTS ec08.ec08_supersession_link (
tenant_id uuid NOT NULL,
supersession_link_id uuid DEFAULT gen_random_uuid() NOT NULL,
prior_issuance_id uuid NOT NULL,
next_issuance_id uuid NOT NULL,
correction_decision_id uuid DEFAULT NULL,
reason_code varchar(80) NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_supersession_link PRIMARY KEY (tenant_id, supersession_link_id),
CONSTRAINT ck_ec08_supersession_link_01 CHECK (prior_issuance_id <> next_issuance_id),
CONSTRAINT uq_ec08_supersession_link_02 UNIQUE (tenant_id, prior_issuance_id),
CONSTRAINT uq_ec08_supersession_link_03 UNIQUE (tenant_id, next_issuance_id)
);
```

### ec08_delivery_request

```
CREATE TABLE IF NOT EXISTS ec08.ec08_delivery_request (
tenant_id uuid NOT NULL,
delivery_request_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
channel_code varchar(40) NOT NULL,
target_ref varchar(240) DEFAULT NULL,
interop_profile_code varchar(80) DEFAULT NULL,
state varchar(32) DEFAULT 'PENDING' NOT NULL,
attempt_count integer DEFAULT 0 NOT NULL,
next_attempt_at timestamptz DEFAULT NULL,
lease_owner varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_delivery_request PRIMARY KEY (tenant_id, delivery_request_id),
CONSTRAINT ck_ec08_delivery_request_01 CHECK (channel_code IN ('PORTAL','EMAIL','PUSH','WALLET','EXPORT')),
CONSTRAINT ck_ec08_delivery_request_02 CHECK (state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED','UNKNOWN_EFFECT','CANCELLED')),
CONSTRAINT ck_ec08_delivery_request_03 CHECK (attempt_count >= 0)
);
```

### ec08_delivery_receipt

```
CREATE TABLE IF NOT EXISTS ec08.ec08_delivery_receipt (
tenant_id uuid NOT NULL,
delivery_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,
delivery_request_id uuid NOT NULL,
outcome varchar(32) NOT NULL,
provider_ref varchar(200) DEFAULT NULL,
provider_status_code varchar(80) DEFAULT NULL,
received_at timestamptz DEFAULT now() NOT NULL,
content_hash varchar(128) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_delivery_receipt PRIMARY KEY (tenant_id, delivery_receipt_id),
CONSTRAINT ck_ec08_delivery_receipt_01 CHECK (outcome IN ('DELIVERED','FAILED','CONFIRMED_NOT_APPLIED','CONFIRMED_APPLIED'))
);
```

### ec08_badge_assertion

```
CREATE TABLE IF NOT EXISTS ec08.ec08_badge_assertion (
tenant_id uuid NOT NULL,
badge_assertion_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
profile_code varchar(80) NOT NULL,
profile_version varchar(32) NOT NULL,
external_assertion_ref varchar(240) DEFAULT NULL,
state varchar(32) DEFAULT 'PENDING' NOT NULL,
last_reconciled_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_badge_assertion PRIMARY KEY (tenant_id, badge_assertion_id),
CONSTRAINT ck_ec08_badge_assertion_01 CHECK (state IN ('PENDING','PUBLISHED','SUSPENDED','REVOKED','FAILED','UNKNOWN_EFFECT')),
CONSTRAINT uq_ec08_badge_assertion_02 UNIQUE (tenant_id, credential_issuance_id)
);
```

### ec08_badge_evidence_binding

```
CREATE TABLE IF NOT EXISTS ec08.ec08_badge_evidence_binding (
tenant_id uuid NOT NULL,
badge_evidence_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,
badge_assertion_id uuid NOT NULL,
evidence_kind varchar(64) NOT NULL,
evidence_ref uuid NOT NULL,
public_visibility boolean DEFAULT false NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_badge_evidence_binding PRIMARY KEY (tenant_id, badge_evidence_binding_id),
CONSTRAINT uq_ec08_badge_evidence_binding_01 UNIQUE (tenant_id, badge_assertion_id, evidence_ref)
);
```

### ec08_microcredential_record

```
CREATE TABLE IF NOT EXISTS ec08.ec08_microcredential_record (
tenant_id uuid NOT NULL,
microcredential_record_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_award_id uuid NOT NULL,
credential_issuance_id uuid DEFAULT NULL,
profile_code varchar(80) NOT NULL,
profile_version varchar(32) NOT NULL,
level_scheme_code varchar(80) DEFAULT NULL,
level_code varchar(80) DEFAULT NULL,
credit_scheme_code varchar(80) DEFAULT NULL,
credit_value numeric(10,2) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_microcredential_record PRIMARY KEY (tenant_id, microcredential_record_id),
CONSTRAINT ck_ec08_microcredential_record_01 CHECK (credit_value IS NULL OR credit_value > 0),
CONSTRAINT uq_ec08_microcredential_record_02 UNIQUE (tenant_id, credential_award_id)
);
```

### ec08_cumulative_evaluation

```
CREATE TABLE IF NOT EXISTS ec08.ec08_cumulative_evaluation (
tenant_id uuid NOT NULL,
cumulative_evaluation_id uuid DEFAULT gen_random_uuid() NOT NULL,
subject_ref uuid NOT NULL,
target_credential_blueprint_ref uuid NOT NULL,
pathway_version_ref uuid DEFAULT NULL,
policy_ref uuid NOT NULL,
source_set_hash varchar(128) NOT NULL,
state varchar(24) DEFAULT 'PENDING' NOT NULL,
evaluated_at timestamptz DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_cumulative_evaluation PRIMARY KEY (tenant_id, cumulative_evaluation_id),
CONSTRAINT ck_ec08_cumulative_evaluation_01 CHECK (state IN ('PENDING','EVALUATING','ELIGIBLE','INELIGIBLE','ERROR')),
CONSTRAINT uq_ec08_cumulative_evaluation_02 UNIQUE (tenant_id, subject_ref, target_credential_blueprint_ref, source_set_hash)
);
```

### ec08_cumulative_evaluation_item

```
CREATE TABLE IF NOT EXISTS ec08.ec08_cumulative_evaluation_item (
tenant_id uuid NOT NULL,
cumulative_item_id uuid DEFAULT gen_random_uuid() NOT NULL,
cumulative_evaluation_id uuid NOT NULL,
source_type varchar(32) NOT NULL,
source_award_id uuid DEFAULT NULL,
external_source_ref uuid DEFAULT NULL,
requirement_code varchar(80) NOT NULL,
outcome varchar(24) NOT NULL,
source_status_code varchar(24) DEFAULT NULL,
source_as_of timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_cumulative_evaluation_item PRIMARY KEY (tenant_id, cumulative_item_id),
CONSTRAINT ck_ec08_cumulative_evaluation_item_01 CHECK (source_type IN ('AWARD','PATH_PROGRESS','EXTERNAL_CREDENTIAL')),
CONSTRAINT ck_ec08_cumulative_evaluation_item_02 CHECK (outcome IN ('PASS','FAIL','UNKNOWN')),
CONSTRAINT ck_ec08_cumulative_evaluation_item_03 CHECK ((source_type='AWARD' AND source_award_id IS NOT NULL AND external_source_ref IS NULL) OR (source_type<>'AWARD' AND source_award_id IS NULL AND external_source_ref IS NOT NULL)),
CONSTRAINT uq_ec08_cumulative_evaluation_item_04 UNIQUE (tenant_id, cumulative_evaluation_id, requirement_code, source_type, source_award_id, external_source_ref)
);
```

### ec08_cumulative_award_link

```
CREATE TABLE IF NOT EXISTS ec08.ec08_cumulative_award_link (
tenant_id uuid NOT NULL,
cumulative_award_link_id uuid DEFAULT gen_random_uuid() NOT NULL,
cumulative_evaluation_id uuid NOT NULL,
target_credential_award_id uuid NOT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_cumulative_award_link PRIMARY KEY (tenant_id, cumulative_award_link_id),
CONSTRAINT uq_ec08_cumulative_award_link_01 UNIQUE (tenant_id, cumulative_evaluation_id),
CONSTRAINT uq_ec08_cumulative_award_link_02 UNIQUE (tenant_id, target_credential_award_id)
);
```

### ec08_credential_batch

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_batch (
tenant_id uuid NOT NULL,
credential_batch_id uuid DEFAULT gen_random_uuid() NOT NULL,
batch_code varchar(96) NOT NULL,
batch_kind varchar(32) NOT NULL,
credential_blueprint_ref uuid DEFAULT NULL,
input_snapshot_hash varchar(128) DEFAULT NULL,
policy_ref uuid NOT NULL,
state varchar(24) DEFAULT 'DRAFT' NOT NULL,
total_items integer DEFAULT 0 NOT NULL,
succeeded_items integer DEFAULT 0 NOT NULL,
failed_items integer DEFAULT 0 NOT NULL,
created_by_subject uuid NOT NULL,
sealed_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_credential_batch PRIMARY KEY (tenant_id, credential_batch_id),
CONSTRAINT ck_ec08_credential_batch_01 CHECK (batch_kind IN ('ELIGIBILITY','AWARD','ISSUE','DELIVER')),
CONSTRAINT ck_ec08_credential_batch_02 CHECK (state IN ('DRAFT','SEALED','RUNNING','COMPLETED','PARTIAL','FAILED','CANCELLED')),
CONSTRAINT ck_ec08_credential_batch_03 CHECK (total_items >= 0 AND succeeded_items >= 0 AND failed_items >= 0 AND succeeded_items + failed_items <= total_items),
CONSTRAINT uq_ec08_credential_batch_04 UNIQUE (tenant_id, batch_code)
);
```

### ec08_credential_batch_item

```
CREATE TABLE IF NOT EXISTS ec08.ec08_credential_batch_item (
tenant_id uuid NOT NULL,
batch_item_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_batch_id uuid NOT NULL,
item_no integer NOT NULL,
subject_ref uuid NOT NULL,
enrollment_ref uuid DEFAULT NULL,
credential_award_id uuid DEFAULT NULL,
issuance_request_id uuid DEFAULT NULL,
state varchar(32) DEFAULT 'PENDING' NOT NULL,
reason_code varchar(80) DEFAULT NULL,
attempt_count integer DEFAULT 0 NOT NULL,
lease_owner varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_credential_batch_item PRIMARY KEY (tenant_id, batch_item_id),
CONSTRAINT ck_ec08_credential_batch_item_01 CHECK (item_no > 0),
CONSTRAINT ck_ec08_credential_batch_item_02 CHECK (state IN ('PENDING','CLAIMED','SUCCEEDED','FAILED','UNKNOWN_EFFECT','SKIPPED')),
CONSTRAINT ck_ec08_credential_batch_item_03 CHECK (attempt_count >= 0),
CONSTRAINT uq_ec08_credential_batch_item_04 UNIQUE (tenant_id, credential_batch_id, item_no)
);
```

### ec08_verification_query_receipt

```
CREATE TABLE IF NOT EXISTS ec08.ec08_verification_query_receipt (
tenant_id uuid NOT NULL,
verification_query_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,
verification_handle_id uuid DEFAULT NULL,
query_hash_prefix varchar(32) DEFAULT NULL,
result_code varchar(32) NOT NULL,
authenticated boolean DEFAULT false NOT NULL,
latency_ms integer DEFAULT 0 NOT NULL,
queried_at timestamptz DEFAULT now() NOT NULL,
retention_class_code varchar(64) NOT NULL,
CONSTRAINT pk_ec08_verification_query_receipt PRIMARY KEY (tenant_id, verification_query_receipt_id),
CONSTRAINT ck_ec08_verification_query_receipt_01 CHECK (result_code IN ('VALID','REVOKED','SUSPENDED','SUPERSEDED','EXPIRED','NOT_FOUND','UNAVAILABLE','RATE_LIMITED')),
CONSTRAINT ck_ec08_verification_query_receipt_02 CHECK (latency_ms >= 0)
);
```

### ec08_external_wallet_delivery

```
CREATE TABLE IF NOT EXISTS ec08.ec08_external_wallet_delivery (
tenant_id uuid NOT NULL,
external_wallet_delivery_id uuid DEFAULT gen_random_uuid() NOT NULL,
credential_issuance_id uuid NOT NULL,
provider_code varchar(80) NOT NULL,
profile_code varchar(80) NOT NULL,
external_credential_ref varchar(240) DEFAULT NULL,
state varchar(32) DEFAULT 'PENDING' NOT NULL,
provider_receipt_ref varchar(240) DEFAULT NULL,
last_reconciled_at timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_external_wallet_delivery PRIMARY KEY (tenant_id, external_wallet_delivery_id),
CONSTRAINT ck_ec08_external_wallet_delivery_01 CHECK (state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED','UNKNOWN_EFFECT','REVOKED','SUPERSEDED')),
CONSTRAINT uq_ec08_external_wallet_delivery_02 UNIQUE (tenant_id, credential_issuance_id, provider_code, profile_code)
);
```

### ec08_idempotency_key

```
CREATE TABLE IF NOT EXISTS ec08.ec08_idempotency_key (
tenant_id uuid NOT NULL,
idempotency_key varchar(160) NOT NULL,
operation_code varchar(80) NOT NULL,
payload_hash varchar(128) NOT NULL,
state varchar(24) DEFAULT 'IN_PROGRESS' NOT NULL,
resource_ref uuid DEFAULT NULL,
response_code integer DEFAULT NULL,
response_hash varchar(128) DEFAULT NULL,
owner_id varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
CONSTRAINT pk_ec08_idempotency_key PRIMARY KEY (tenant_id, idempotency_key),
CONSTRAINT ck_ec08_idempotency_key_01 CHECK (state IN ('IN_PROGRESS','SUCCEEDED','FAILED'))
);
```

### ec08_outbox_event

```
CREATE TABLE IF NOT EXISTS ec08.ec08_outbox_event (
tenant_id uuid NOT NULL,
event_id uuid DEFAULT gen_random_uuid() NOT NULL,
aggregate_type varchar(80) NOT NULL,
aggregate_id uuid NOT NULL,
event_type varchar(120) NOT NULL,
schema_version varchar(24) NOT NULL,
correlation_id uuid NOT NULL,
causation_id uuid DEFAULT NULL,
payload jsonb NOT NULL,
state varchar(24) DEFAULT 'PENDING' NOT NULL,
attempt_count integer DEFAULT 0 NOT NULL,
lease_owner varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
next_attempt_at timestamptz DEFAULT NULL,
occurred_at timestamptz DEFAULT now() NOT NULL,
sent_at timestamptz DEFAULT NULL,
CONSTRAINT pk_ec08_outbox_event PRIMARY KEY (tenant_id, event_id),
CONSTRAINT ck_ec08_outbox_event_01 CHECK (state IN ('PENDING','IN_FLIGHT','SENT','FAILED')),
CONSTRAINT ck_ec08_outbox_event_02 CHECK (attempt_count >= 0)
);
```

### ec08_inbox_message

```
CREATE TABLE IF NOT EXISTS ec08.ec08_inbox_message (
tenant_id uuid NOT NULL,
message_id uuid NOT NULL,
consumer_code varchar(100) NOT NULL,
event_type varchar(120) NOT NULL,
schema_version varchar(24) NOT NULL,
payload_hash varchar(128) NOT NULL,
state varchar(24) DEFAULT 'PROCESSED' NOT NULL,
received_at timestamptz DEFAULT now() NOT NULL,
processed_at timestamptz DEFAULT NULL,
reason_code varchar(80) DEFAULT NULL,
CONSTRAINT pk_ec08_inbox_message PRIMARY KEY (tenant_id, message_id),
CONSTRAINT ck_ec08_inbox_message_01 CHECK (state IN ('PROCESSED','REJECTED','QUARANTINED'))
);
```

### ec08_operation_status

```
CREATE TABLE IF NOT EXISTS ec08.ec08_operation_status (
tenant_id uuid NOT NULL,
operation_id uuid DEFAULT gen_random_uuid() NOT NULL,
operation_code varchar(80) NOT NULL,
resource_ref uuid DEFAULT NULL,
state varchar(32) DEFAULT 'PENDING' NOT NULL,
progress_percent numeric(5,2) DEFAULT 0 NOT NULL,
reason_code varchar(80) DEFAULT NULL,
correlation_id uuid NOT NULL,
started_at timestamptz DEFAULT NULL,
finished_at timestamptz DEFAULT NULL,
lease_owner varchar(120) DEFAULT NULL,
lease_until timestamptz DEFAULT NULL,
created_at timestamptz DEFAULT now() NOT NULL,
updated_at timestamptz DEFAULT now() NOT NULL,
version bigint DEFAULT 0 NOT NULL,
CONSTRAINT pk_ec08_operation_status PRIMARY KEY (tenant_id, operation_id),
CONSTRAINT ck_ec08_operation_status_01 CHECK (state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED')),
CONSTRAINT ck_ec08_operation_status_02 CHECK (progress_percent >= 0 AND progress_percent <= 100)
);
```

## 13.3 Foreign keys internas tenant-aware

```
ALTER TABLE ec08.ec08_credential_eligibility_rule_fact ADD CONSTRAINT fk_ec08_credential_eligibility_rule_fact_eligibility_evaluation_id
FOREIGN KEY (tenant_id, eligibility_evaluation_id) REFERENCES ec08.ec08_credential_eligibility_evaluation(tenant_id, eligibility_evaluation_id);

ALTER TABLE ec08.ec08_credential_award ADD CONSTRAINT fk_ec08_credential_award_eligibility_evaluation_id
FOREIGN KEY (tenant_id, eligibility_evaluation_id) REFERENCES ec08.ec08_credential_eligibility_evaluation(tenant_id, eligibility_evaluation_id);

ALTER TABLE ec08.ec08_award_evidence_ref ADD CONSTRAINT fk_ec08_award_evidence_ref_credential_award_id
FOREIGN KEY (tenant_id, credential_award_id) REFERENCES ec08.ec08_credential_award(tenant_id, credential_award_id);

ALTER TABLE ec08.ec08_issuance_request ADD CONSTRAINT fk_ec08_issuance_request_credential_award_id
FOREIGN KEY (tenant_id, credential_award_id) REFERENCES ec08.ec08_credential_award(tenant_id, credential_award_id);

ALTER TABLE ec08.ec08_credential_issuance ADD CONSTRAINT fk_ec08_credential_issuance_credential_award_id
FOREIGN KEY (tenant_id, credential_award_id) REFERENCES ec08.ec08_credential_award(tenant_id, credential_award_id);

ALTER TABLE ec08.ec08_credential_issuance ADD CONSTRAINT fk_ec08_credential_issuance_issuance_request_id
FOREIGN KEY (tenant_id, issuance_request_id) REFERENCES ec08.ec08_issuance_request(tenant_id, issuance_request_id);

ALTER TABLE ec08.ec08_credential_issuance ADD CONSTRAINT fk_ec08_issuance_supersedes
FOREIGN KEY (tenant_id, supersedes_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_credential_payload_snapshot ADD CONSTRAINT fk_ec08_credential_payload_snapshot_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);
```

```
ALTER TABLE ec08.ec08_credential_document_binding ADD CONSTRAINT fk_ec08_credential_document_binding_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_signing_receipt ADD CONSTRAINT fk_ec08_signing_receipt_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_verification_handle ADD CONSTRAINT fk_ec08_verification_handle_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_credential_status_fact ADD CONSTRAINT fk_ec08_credential_status_fact_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_status_restatement ADD CONSTRAINT fk_ec08_status_restatement_status_fact_id
FOREIGN KEY (tenant_id, status_fact_id) REFERENCES ec08.ec08_credential_status_fact(tenant_id, status_fact_id);

ALTER TABLE ec08.ec08_revocation_case ADD CONSTRAINT fk_ec08_revocation_case_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_revocation_decision ADD CONSTRAINT fk_ec08_revocation_decision_revocation_case_id
FOREIGN KEY (tenant_id, revocation_case_id) REFERENCES ec08.ec08_revocation_case(tenant_id, revocation_case_id);

ALTER TABLE ec08.ec08_correction_request ADD CONSTRAINT fk_ec08_correction_request_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);
```

```
ALTER TABLE ec08.ec08_correction_decision ADD CONSTRAINT fk_ec08_correction_decision_correction_request_id
FOREIGN KEY (tenant_id, correction_request_id) REFERENCES ec08.ec08_correction_request(tenant_id, correction_request_id);

ALTER TABLE ec08.ec08_supersession_link ADD CONSTRAINT fk_ec08_supersession_link_prior_issuance_id
FOREIGN KEY (tenant_id, prior_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_supersession_link ADD CONSTRAINT fk_ec08_supersession_link_next_issuance_id
FOREIGN KEY (tenant_id, next_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_supersession_link ADD CONSTRAINT fk_ec08_supersession_link_correction_decision_id
FOREIGN KEY (tenant_id, correction_decision_id) REFERENCES ec08.ec08_correction_decision(tenant_id, correction_decision_id);

ALTER TABLE ec08.ec08_delivery_request ADD CONSTRAINT fk_ec08_delivery_request_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_delivery_receipt ADD CONSTRAINT fk_ec08_delivery_receipt_delivery_request_id
FOREIGN KEY (tenant_id, delivery_request_id) REFERENCES ec08.ec08_delivery_request(tenant_id, delivery_request_id);

ALTER TABLE ec08.ec08_badge_assertion ADD CONSTRAINT fk_ec08_badge_assertion_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_badge_evidence_binding ADD CONSTRAINT fk_ec08_badge_evidence_binding_badge_assertion_id
FOREIGN KEY (tenant_id, badge_assertion_id) REFERENCES ec08.ec08_badge_assertion(tenant_id, badge_assertion_id);
```

```
ALTER TABLE ec08.ec08_microcredential_record ADD CONSTRAINT fk_ec08_microcredential_record_credential_award_id
FOREIGN KEY (tenant_id, credential_award_id) REFERENCES ec08.ec08_credential_award(tenant_id, credential_award_id);

ALTER TABLE ec08.ec08_microcredential_record ADD CONSTRAINT fk_ec08_microcredential_record_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);

ALTER TABLE ec08.ec08_cumulative_evaluation_item ADD CONSTRAINT fk_ec08_cumulative_evaluation_item_cumulative_evaluation_id
FOREIGN KEY (tenant_id, cumulative_evaluation_id) REFERENCES ec08.ec08_cumulative_evaluation(tenant_id, cumulative_evaluation_id);

ALTER TABLE ec08.ec08_cumulative_evaluation_item ADD CONSTRAINT fk_ec08_cumulative_evaluation_item_source_award_id
FOREIGN KEY (tenant_id, source_award_id) REFERENCES ec08.ec08_credential_award(tenant_id, credential_award_id);

ALTER TABLE ec08.ec08_cumulative_award_link ADD CONSTRAINT fk_ec08_cumulative_award_link_cumulative_evaluation_id
FOREIGN KEY (tenant_id, cumulative_evaluation_id) REFERENCES ec08.ec08_cumulative_evaluation(tenant_id, cumulative_evaluation_id);

ALTER TABLE ec08.ec08_cumulative_award_link ADD CONSTRAINT fk_ec08_cumulative_award_link_target_credential_award_id
FOREIGN KEY (tenant_id, target_credential_award_id) REFERENCES ec08.ec08_credential_award(tenant_id, credential_award_id);

ALTER TABLE ec08.ec08_credential_batch_item ADD CONSTRAINT fk_ec08_credential_batch_item_credential_batch_id
FOREIGN KEY (tenant_id, credential_batch_id) REFERENCES ec08.ec08_credential_batch(tenant_id, credential_batch_id);

ALTER TABLE ec08.ec08_credential_batch_item ADD CONSTRAINT fk_ec08_credential_batch_item_credential_award_id
FOREIGN KEY (tenant_id, credential_award_id) REFERENCES ec08.ec08_credential_award(tenant_id, credential_award_id);
```

```
ALTER TABLE ec08.ec08_credential_batch_item ADD CONSTRAINT fk_ec08_credential_batch_item_issuance_request_id
FOREIGN KEY (tenant_id, issuance_request_id) REFERENCES ec08.ec08_issuance_request(tenant_id, issuance_request_id);

ALTER TABLE ec08.ec08_verification_query_receipt ADD CONSTRAINT fk_ec08_verification_query_receipt_verification_handle_id
FOREIGN KEY (tenant_id, verification_handle_id) REFERENCES ec08.ec08_verification_handle(tenant_id, verification_handle_id);

ALTER TABLE ec08.ec08_external_wallet_delivery ADD CONSTRAINT fk_ec08_external_wallet_delivery_credential_issuance_id
FOREIGN KEY (tenant_id, credential_issuance_id) REFERENCES ec08.ec08_credential_issuance(tenant_id, credential_issuance_id);
```

## 13.4 RLS defense-in-depth — ENABLE + FORCE

```
ALTER TABLE ec08.ec08_credential_eligibility_evaluation ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_eligibility_evaluation FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_eligibility_evaluation ON ec08.ec08_credential_eligibility_evaluation
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_credential_eligibility_rule_fact ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_eligibility_rule_fact FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_eligibility_rule_fact ON ec08.ec08_credential_eligibility_rule_fact
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_credential_award ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_award FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_award ON ec08.ec08_credential_award
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_award_evidence_ref ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_award_evidence_ref FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_award_evidence_ref ON ec08.ec08_award_evidence_ref
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

```
ALTER TABLE ec08.ec08_issuance_request ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_issuance_request FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_issuance_request ON ec08.ec08_issuance_request
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_credential_issuance ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_issuance FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_issuance ON ec08.ec08_credential_issuance
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_credential_payload_snapshot ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_payload_snapshot FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_payload_snapshot ON ec08.ec08_credential_payload_snapshot
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_credential_document_binding ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_document_binding FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_document_binding ON ec08.ec08_credential_document_binding
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

```
ALTER TABLE ec08.ec08_signing_receipt ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_signing_receipt FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_signing_receipt ON ec08.ec08_signing_receipt
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_verification_handle ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_verification_handle FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_verification_handle ON ec08.ec08_verification_handle
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_credential_status_fact ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_status_fact FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_status_fact ON ec08.ec08_credential_status_fact
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_status_restatement ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_status_restatement FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_status_restatement ON ec08.ec08_status_restatement
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

```
ALTER TABLE ec08.ec08_revocation_case ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_revocation_case FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_revocation_case ON ec08.ec08_revocation_case
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_revocation_decision ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_revocation_decision FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_revocation_decision ON ec08.ec08_revocation_decision
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_correction_request ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_correction_request FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_correction_request ON ec08.ec08_correction_request
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_correction_decision ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_correction_decision FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_correction_decision ON ec08.ec08_correction_decision
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

```
ALTER TABLE ec08.ec08_supersession_link ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_supersession_link FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_supersession_link ON ec08.ec08_supersession_link
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_delivery_request ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_delivery_request FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_delivery_request ON ec08.ec08_delivery_request
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_delivery_receipt ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_delivery_receipt FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_delivery_receipt ON ec08.ec08_delivery_receipt
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_badge_assertion ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_badge_assertion FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_badge_assertion ON ec08.ec08_badge_assertion
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

```
ALTER TABLE ec08.ec08_badge_evidence_binding ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_badge_evidence_binding FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_badge_evidence_binding ON ec08.ec08_badge_evidence_binding
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_microcredential_record ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_microcredential_record FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_microcredential_record ON ec08.ec08_microcredential_record
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_cumulative_evaluation ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_cumulative_evaluation FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_cumulative_evaluation ON ec08.ec08_cumulative_evaluation
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_cumulative_evaluation_item ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_cumulative_evaluation_item FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_cumulative_evaluation_item ON ec08.ec08_cumulative_evaluation_item
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

```
ALTER TABLE ec08.ec08_cumulative_award_link ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_cumulative_award_link FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_cumulative_award_link ON ec08.ec08_cumulative_award_link
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_credential_batch ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_batch FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_batch ON ec08.ec08_credential_batch
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_credential_batch_item ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_credential_batch_item FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_credential_batch_item ON ec08.ec08_credential_batch_item
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_verification_query_receipt ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_verification_query_receipt FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_verification_query_receipt ON ec08.ec08_verification_query_receipt
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

```
ALTER TABLE ec08.ec08_external_wallet_delivery ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_external_wallet_delivery FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_external_wallet_delivery ON ec08.ec08_external_wallet_delivery
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_idempotency_key ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_idempotency_key FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_idempotency_key ON ec08.ec08_idempotency_key
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_outbox_event ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_outbox_event FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_outbox_event ON ec08.ec08_outbox_event
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);

ALTER TABLE ec08.ec08_inbox_message ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_inbox_message FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_inbox_message ON ec08.ec08_inbox_message
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

```
ALTER TABLE ec08.ec08_operation_status ENABLE ROW LEVEL SECURITY;
ALTER TABLE ec08.ec08_operation_status FORCE ROW LEVEL SECURITY;
CREATE POLICY p_tenant_ec08_operation_status ON ec08.ec08_operation_status
USING (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid)
WITH CHECK (tenant_id = NULLIF(current_setting('peopleu.tenant_id', true),'')::uuid);
```

## 13.5 Triggers append-only e inmutabilidad de issuance

```
CREATE OR REPLACE FUNCTION ec08.forbid_update_delete() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
RAISE EXCEPTION 'APPEND_ONLY_RECORD';
END $$;

CREATE OR REPLACE FUNCTION ec08.guard_issued_issuance() RETURNS trigger LANGUAGE plpgsql AS $$
BEGIN
IF OLD.state IN ('ISSUED','SUSPENDED','REVOKED','SUPERSEDED','VOID') THEN
IF NEW.credential_serial IS DISTINCT FROM OLD.credential_serial
OR NEW.credential_award_id IS DISTINCT FROM OLD.credential_award_id
OR NEW.content_hash IS DISTINCT FROM OLD.content_hash
OR NEW.canonical_schema_version IS DISTINCT FROM OLD.canonical_schema_version
OR NEW.issuer_scope_ref IS DISTINCT FROM OLD.issuer_scope_ref THEN
RAISE EXCEPTION 'ISSUED_SNAPSHOT_IMMUTABLE';
END IF;
END IF;
RETURN NEW;
END $$;

CREATE TRIGGER trg_ec08_issuance_immutable BEFORE UPDATE ON ec08.ec08_credential_issuance
FOR EACH ROW EXECUTE FUNCTION ec08.guard_issued_issuance();
```

```
CREATE TRIGGER trg_ec08_credential_eligibility_rule_fact_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_credential_eligibility_rule_fact
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_award_evidence_ref_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_award_evidence_ref
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_credential_payload_snapshot_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_credential_payload_snapshot
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_credential_document_binding_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_credential_document_binding
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_signing_receipt_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_signing_receipt
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_credential_status_fact_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_credential_status_fact
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();
```

```
CREATE TRIGGER trg_ec08_status_restatement_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_status_restatement
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_revocation_decision_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_revocation_decision
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_correction_decision_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_correction_decision
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_supersession_link_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_supersession_link
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_delivery_receipt_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_delivery_receipt
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_badge_evidence_binding_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_badge_evidence_binding
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();
```

```
CREATE TRIGGER trg_ec08_cumulative_evaluation_item_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_cumulative_evaluation_item
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_cumulative_award_link_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_cumulative_award_link
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();

CREATE TRIGGER trg_ec08_verification_query_receipt_append_only BEFORE UPDATE OR DELETE ON ec08.ec08_verification_query_receipt
FOR EACH ROW EXECUTE FUNCTION ec08.forbid_update_delete();
```

## 13.6 Indices operacionales

```
CREATE INDEX ix_ec08_eligibility_subject_blueprint ON ec08.ec08_credential_eligibility_evaluation(tenant_id, subject_ref, credential_blueprint_ref, created_at DESC);
CREATE INDEX ix_ec08_award_subject ON ec08.ec08_credential_award(tenant_id, subject_ref, awarded_at DESC);
CREATE INDEX ix_ec08_issuance_award ON ec08.ec08_credential_issuance(tenant_id, credential_award_id, issuance_no DESC);
CREATE INDEX ix_ec08_status_current ON ec08.ec08_credential_status_fact(tenant_id, credential_issuance_id, sequence_no DESC);
CREATE INDEX ix_ec08_delivery_claim ON ec08.ec08_delivery_request(tenant_id, state, next_attempt_at, lease_until) WHERE state IN ('PENDING','IN_FLIGHT','UNKNOWN_EFFECT');
CREATE INDEX ix_ec08_batch_item_claim ON ec08.ec08_credential_batch_item(tenant_id, credential_batch_id, state, lease_until) WHERE state IN ('PENDING','CLAIMED','UNKNOWN_EFFECT');
CREATE INDEX ix_ec08_outbox_claim ON ec08.ec08_outbox_event(tenant_id, state, next_attempt_at, lease_until) WHERE state IN ('PENDING','IN_FLIGHT');
CREATE INDEX ix_ec08_operation_state ON ec08.ec08_operation_status(tenant_id, state, updated_at) WHERE state IN ('PENDING','RUNNING','UNKNOWN_EFFECT');
CREATE INDEX ix_ec08_idempotency_lease ON ec08.ec08_idempotency_key(tenant_id, state, lease_until) WHERE state='IN_PROGRESS';
```

## 13.7 Claim de outbox/batch con lease

```
WITH c AS (
SELECT tenant_id, event_id
FROM ec08.ec08_outbox_event
WHERE state='PENDING' AND (next_attempt_at IS NULL OR next_attempt_at <= now())
ORDER BY occurred_at
FOR UPDATE SKIP LOCKED
LIMIT :batch_size
)
UPDATE ec08.ec08_outbox_event o
SET state='IN_FLIGHT', lease_owner=:worker, lease_until=now()+interval '60 seconds', attempt_count=attempt_count+1
FROM c WHERE o.tenant_id=c.tenant_id AND o.event_id=c.event_id
RETURNING o.*;
```

## 13.8 Public verifier lookup — frontera restringida

```
-- Preferir un VerificationGateway con DB role dedicado. Si se usa SECURITY DEFINER:
CREATE OR REPLACE FUNCTION ec08.resolve_public_verification(p_token_hash varchar)
RETURNS TABLE(tenant_id uuid, credential_issuance_id uuid)
LANGUAGE sql SECURITY DEFINER SET search_path = pg_catalog, ec08 AS $$
SELECT v.tenant_id, v.credential_issuance_id
FROM ec08.ec08_verification_handle v
WHERE v.token_hash = p_token_hash AND v.state='ACTIVE'
LIMIT 1;
$$;
REVOKE ALL ON FUNCTION ec08.resolve_public_verification(varchar) FROM PUBLIC;
-- GRANT EXECUTE solo a peopleu_ec08_verifier_gateway tras security review.
```

## 13.9 Roles de base de datos

```
-- peopleu_migrator: owner/DDL, no usado por HTTP.
-- peopleu_ec08_runtime: SELECT/INSERT/UPDATE necesarios, sin BYPASSRLS, sin DDL.
-- peopleu_ec08_worker: privilegios minimos para outbox/delivery/batch, sin BYPASSRLS.
-- peopleu_ec08_verifier_gateway: EXECUTE sobre lookup publico restringido; sin SELECT generico.
-- Passwords/secrets fuera de Flyway; IAM/secret manager los entrega por ambiente.
```

# 14. MongoDB y Redis

## 14.1 PostgreSQL sigue siendo Source of Truth

Award, issuance, canonical payload, status, decisions, idempotency, outbox e inbox permanecen en PostgreSQL. Ni MongoDB ni Redis pueden crear, revocar, corregir o declarar valida una credencial. Una perdida total de caches/read models debe ser recuperable desde PostgreSQL + event history.

## 14.2 MongoDB — solo proyecciones derivadas cuándo aporten valor

| **Read model**               | **Uso**                                                                                                                      | **Regla**                                                                  |
|------------------------------|------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------|
| credential_public_projection | Documento derivado para busqueda/reporting autorizado; incluye issuanceRef, public title, issuer y currentStatus projection. | Se reconstruye por event/replay; nunca se usa para decidir status oficial. |
| holder_credential_feed       | Read model denormalizado para portal/mobile de holder.                                                                       | PII minimizada; auth obligatoria; reconstruible.                           |
| interop_projection_debug     | Snapshot temporal sanitizado de mapping a profile externo para soporte.                                                      | Retention corto; no secrets; no sustituye signing receipt.                 |

## 14.3 Redis — acelerador no autoritativo

| **Key pattern**              | **Propósito**                                  | **Invariante**                                                                       |
|------------------------------|------------------------------------------------|--------------------------------------------------------------------------------------|
| verify:{tokenHash}           | Public verification projection + statusVersion | TTL corto; invalidar en status/supersede/rotation; STALE explicito en degraded mode. |
| award:{id}:currentIssuance   | Resolucion rapida holder/backoffice            | Cache-aside; PostgreSQL truth.                                                       |
| rate:verify:{bucket}         | Rate limit/token bucket                        | No academic truth; retention corta.                                                  |
| lock:serial:{tenant}:{scope} | Lock técnico opcional complementario           | No reemplaza UNIQUE/transaction.                                                     |
| operation:{id}:projection    | Polling acceleration                           | DB OperationStatus manda.                                                            |

| **REGLA — Si Redis cae, el sistema puede degradar performance pero no puede empezar a emitir duplicados ni responder VALID sin consultar una fuente autoritativa.** |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 15. Backend Java 21 / Spring Boot / Spring Modulith

## 15.1 Estructura de módulo

```
com.peopleu.ec08credential
domain/
eligibility/ award/ issuance/ lifecycle/ batch/ cumulative/
application/
command/ query/ service/ port/in/ port/out/
adapter/in/rest/
adapter/in/event/
adapter/out/persistence/jpa/
adapter/out/ct05/ adapter/out/ct18/ adapter/out/ec01/ adapter/out/ec07/
adapter/out/security/ adapter/out/observability/
config/
package-info.java
```

## 15.2 Aggregate roots y repositorios

| **Aggregate Root**              | **Responsabilidad**                | **Repositorio**                 |
|---------------------------------|------------------------------------|---------------------------------|
| CredentialEligibilityEvaluation | Decisión + rule facts              | CredentialEligibilityRepository |
| CredentialAward                 | Adjudicacion + evidence refs       | CredentialAwardRepository       |
| CredentialIssuance              | Identity/serial/immutable issuance | CredentialIssuanceRepository    |
| RevocationCase                  | Workflow de revoke/suspend         | RevocationCaseRepository        |
| CorrectionRequest               | Workflow de correction             | CorrectionRequestRepository     |
| CredentialBatch                 | Batch + items/revisión             | CredentialBatchRepository       |
| CumulativeEvaluation            | Evaluation + items                 | CumulativeEvaluationRepository  |

## 15.3 Application services

| **Servicio**                         | **Responsabilidad**                                                                                 |
|--------------------------------------|-----------------------------------------------------------------------------------------------------|
| EvaluateCredentialEligibilityService | Resolve blueprint/facts/policies; produce rule facts + terminal evaluation.                         |
| AwardCredentialService               | Lock semantic uniqueness; revalidate; create award/evidence/outbox.                                 |
| IssueCredentialService               | Serial allocation, canonical snapshot, document/sign orchestration, verification handle and events. |
| CredentialStatusService              | Suspend/reinstate/revoke/void via append-only facts.                                                |
| CorrectCredentialService             | Classify/apply render-only or superseding issuance.                                                 |
| PublicVerificationService            | Resolve token through restricted gateway; derive minimized projection.                              |
| CredentialBatchService               | Preflight/seal/chunk/process/recover items.                                                         |
| CumulativeCredentialService          | Pin source awards/facts and evaluate cumulative credential.                                         |
| DeliveryService                      | Queue delivery; reconcile provider effects.                                                         |
| InteropService                       | Map to CT-18 profiles and persist provider receipts.                                                |

## 15.4 Ports de salida obligatorios

| **Port**                | **Owner externo**            | **Contrato mínimo**                                         |
|-------------------------|------------------------------|-------------------------------------------------------------|
| CredentialBlueprintPort | EC-01                        | getPublishedBlueprint(ref), validateVersion(ref)            |
| CompletionFactPort      | EC-07                        | getOfficialCompletion(ref), resolveRestatementImpact(ref)   |
| ParticipantIdentityPort | CT-04/EC-04                  | resolveHolder(ref), assuranceSnapshot(ref)                  |
| FinancialRegularityPort | Finanzas                     | getRegularityFact(ref/context)                              |
| PolicyPort              | CT-02                        | resolveImmutablePolicy(ref), snapshot(policySet)            |
| EvidenceDocumentPort    | CT-05                        | createCredentialDocument(), getHash(), createEvidencePack() |
| SigningPort             | KMS/HSM via governed adapter | signDigest(), getKeyMetadata()                              |
| WorkflowPort            | CT-06                        | openCase(), getDecision()                                   |
| NotificationPort        | CT-07                        | requestDeliveryNotification()                               |
| CredentialInteropPort   | CT-18                        | publishCredential(), getRemoteStatus(), revokeProjection()  |
| AuditPort               | CT-10                        | appendAuditEvidence()                                       |
| AiAssistPort            | CT-12                        | explainDecision(), detectBatchAnomaly()                     |

## 15.5 Manejo transaccional

El caso issue debe definir explicitamente su atomic boundary. La transacción local puede crear IssuanceRequest/Issuance en ISSUING y outbox/OperationStatus; document/signing remotos no deben mantenerse bajo una transacción DB larga. La terminalizacion a ISSUED solo ocurre cuándo los efectos requeridos se confirman/reconcilian y snapshot/receipts son consistentes. Si el proveedor puede haber aplicado el efecto pero no responde, OperationStatus/DeliveryRequest conserva UNKNOWN_EFFECT.

## 15.6 Serial allocation

El serial es un business identifier y no debe asignarse con SELECT max()+1. Puede utilizar sequence por tenant/scope, allocator central con advisory/row lock o esquema UUID-derived según policy. En todos los casos PostgreSQL UNIQUE es la última defensa. Si se reserva un serial y el issuance falla, la policy define si queda consumido; nunca se reutiliza silenciosamente si pudo haber sido expuesto externamente.

## 15.7 Aggregate revisión y optimistic locking

RevocationCase, CorrectionRequest, Batch y otros roots mutables usan @Versión. Controllers traducen If-Match a expected revisión. Child commands bloquean/revisan el root y hacen bump dentro de la misma transacción. Issuance ISSUED es inmutable; no se actualiza su canonical content para resolver conflictos.

# 16. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

## 16.1 Convenciones generales

- Base path: /api/ec/v1/credentials o contrato versionado equivalente.

- Tenant se resuelve de auth context; tenantId no se acepta cómo authority desde request body.

- GET devuelve ETag para resources mutables. Mutations relevantes exigen If-Match.

- Commands sensibles exigen Idempotency-Key.

- 202 incluye Location/operationId y GET /operations/{id}.

- Errores usan application/problem+json / Spring ProblemDetail con reasonCode estable.

- Lists definen pageSize máximo, sorting estable, filtros y metadata/cursor.

- Nunca exponer verification token en logs, traces o ProblemDetail.

## 16.2 Catalogo de endpoints

| **Metodo** | **Ruta**                                 | **Propósito**                         | **Headers especiales**          | **Respuesta** |
|------------|------------------------------------------|---------------------------------------|---------------------------------|---------------|
| POST       | /eligibility-evaluations                 | Evaluate credential eligibility       | Idempotency-Key                 | 201/202       |
| GET        | /eligibility-evaluations/{id}            | Get evaluation/rule facts             | --                              | 200           |
| POST       | /eligibility-evaluations/{id}:reevaluate | Reevaluate with new facts/policy      | Idempotency-Key                 | 201/202       |
| POST       | /awards                                  | Create award from eligible evaluation | Idempotency-Key                 | 201           |
| GET        | /awards                                  | List/filter awards                    | --                              | 200           |
| GET        | /awards/{id}                             | Award detail                          | --                              | 200           |
| GET        | /awards/{id}/issuances                   | Issuance history                      | --                              | 200           |
| POST       | /awards/{id}/issuance-requests           | Request issuance                      | Idempotency-Key                 | 201/202       |
| GET        | /issuance-requests/{id}                  | Request state                         | --                              | 200           |
| GET        | /issuances/{id}                          | Issuance detail authorized            | --                              | 200           |
| GET        | /issuances/{id}/documents                | Document bindings                     | --                              | 200           |
| GET        | /issuances/{id}/status-history           | Status facts/restatements             | --                              | 200           |
| POST       | /issuances/{id}:suspend                  | Suspend                               | Idempotency-Key + If-Match case | 200/202       |
| POST       | /issuances/{id}:reinstate                | Reinstate                             | Idempotency-Key                 | 200/202       |
| POST       | /issuances/{id}:void                     | Void exceptional                      | Idempotency-Key                 | 200/202       |
| POST       | /issuances/{id}/correction-requests      | Open correction                       | Idempotency-Key                 | 201           |
| GET        | /correction-requests/{id}                | Get correction case                   | --                              | 200           |
| POST       | /correction-requests/{id}:classify       | Classify correction                   | If-Match                        | 200           |
| POST       | /correction-requests/{id}:decide         | Approve/reject                        | If-Match + Idempotency-Key      | 200           |
| POST       | /correction-requests/{id}:apply          | Apply correction                      | Idempotency-Key                 | 200/202       |
| POST       | /issuances/{id}/revocation-cases         | Open revoke/suspend case              | Idempotency-Key                 | 201           |
| GET        | /revocation-cases/{id}                   | Get case                              | --                              | 200           |
| POST       | /revocation-cases/{id}:submit            | Submit case                           | If-Match                        | 200/202       |
| POST       | /revocation-cases/{id}:decide            | Approve/reject                        | If-Match + Idempotency-Key      | 200           |
| POST       | /revocation-cases/{id}:apply             | Apply decisión                        | Idempotency-Key                 | 200/202       |
| POST       | /issuances/{id}/delivery-requests        | Request channel delivery              | Idempotency-Key                 | 201/202       |
| GET        | /delivery-requests/{id}                  | Delivery status                       | --                              | 200           |
| POST       | /delivery-requests/{id}:reconcile        | Reconcile UNKNOWN_EFFECT              | Idempotency-Key                 | 200/202       |
| POST       | /batches                                 | Create batch                          | Idempotency-Key                 | 201           |
| POST       | /batches/{id}:preflight                  | Validate batch                        | If-Match                        | 200/202       |
| POST       | /batches/{id}:seal                       | Seal input                            | If-Match + Idempotency-Key      | 200           |
| POST       | /batches/{id}:run                        | Run batch                             | Idempotency-Key                 | 202           |
| GET        | /batches/{id}                            | Batch progress                        | --                              | 200           |
| GET        | /batches/{id}/items                      | Paginated items                       | --                              | 200           |
| POST       | /batches/{id}:retry-failed               | Retry recoverable items               | Idempotency-Key                 | 202           |
| POST       | /cumulative-evaluations                  | Evaluate cumulative credential        | Idempotency-Key                 | 201/202       |
| GET        | /cumulative-evaluations/{id}             | Get cumulative evidence               | --                              | 200           |
| POST       | /cumulative-evaluations/{id}:award       | Create cumulative award               | Idempotency-Key                 | 201           |
| GET        | /operations/{operationId}                | Async operation status                | --                              | 200           |
| POST       | /operations/{operationId}:reconcile      | Reconcile unknown effect              | Idempotency-Key                 | 200/202       |
| GET        | /me/credentials                          | Holder credential feed                | --                              | 200           |
| GET        | /me/credentials/{id}                     | Holder detail                         | --                              | 200           |

## 16.3 Public verification API

| **Metodo** | **Ruta**                              | **Regla**                                                                                                                                           |
|------------|---------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| GET        | /public/credentials/verify/{token}    | Token via path solo si gateway/logging redaction esta garantizada; preferible POST body o fragment/client transform cuándo architecture lo permita. |
| POST       | /public/credentials/verify            | Body {token}; server hashea y responde public projection; rate limit.                                                                               |
| GET        | /public/credentials/status/{publicId} | Solo si publicId no permite enumeration y profile lo exige.                                                                                         |

## 16.4 DTOs nucleares

| **DTO**                              | **Campos principales**                                                                                                                        | **Regla**                                                |
|--------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------|
| EvaluateEligibilityRequest           | subjectRef, enrollmentRef?, credentialBlueprintRef, completionFactRef?, policyContext?                                                        | No tenantId; refs external authority.                    |
| CredentialEligibilityResponse        | id, state, ruleFacts\[\], policyRef, evaluatedAt, reasonCode, asOf                                                                            | Nunca incluye datos financieros sensibles.               |
| CreateAwardRequest                   | eligibilityEvaluationId, reasonCode?                                                                                                          | Evaluation must be ELIGIBLE.                             |
| CredentialAwardResponse              | awardId, awardCode, holder projection, blueprint projection, state, awardedAt, currentIssuanceRef?                                            | ETag if mutable view.                                    |
| CreateIssuanceRequest                | locale?, deliveryChannels?, interopProfiles?                                                                                                  | No serial from client unless controlled import endpoint. |
| CredentialIssuanceResponse           | issuanceId, serial, state, issuedAt, publicVerificationRef?, documentBindings\[\], statusUpdatedAt                                            | Authorized projection.                                   |
| PublicCredentialVerificationResponse | verificationStatus, credentialTitle, holderDisplayName policy-limited, issuerDisplayName, issuedAt, validUntil?, supersededByPublicRef?, asOf | No internal IDs/grades/debt.                             |
| CorrectionRequestDto                 | claimedFieldCode, claimedValue?, evidenceRefs\[\], reasonCode                                                                                 | PII minimized.                                           |
| RevocationCaseDto                    | caseKind, reasonCode, evidenceRefs\[\]                                                                                                        | Step-up/role enforced server-side.                       |
| CredentialBatchCreateRequest         | batchKind, blueprintRef?, candidateSourceRef/filterSnapshot                                                                                   | Selection sealed later.                                  |
| OperationStatusResponse              | operationId, operationCode, state, progressPercent, reasonCode?, resourceRef?, updatedAt                                                      | UNKNOWN_EFFECT explicit.                                 |

## 16.5 Errores HTTP y reason codes

| **HTTP** | **reasonCode**                                                   | **Semántica**                                                 |
|----------|------------------------------------------------------------------|---------------------------------------------------------------|
| 400      | INVALID_REQUEST                                                  | Schema/format invalido.                                       |
| 401      | UNAUTHENTICATED                                                  | No autenticado.                                               |
| 403      | INSUFFICIENT_SCOPE / STEP_UP_REQUIRED                            | RBAC/ABAC/assurance.                                          |
| 404      | CREDENTIAL_NOT_FOUND                                             | No existe o no visible; public verifier usa mensaje generico. |
| 409      | AWARD_ALREADY_EXISTS / SERIAL_CONFLICT / IDEMPOTENCY_KEY_REUSED  | Conflicto semantico o idempotency.                            |
| 412      | PRECONDITION_FAILED                                              | ETag/If-Match stale.                                          |
| 422      | NOT_ELIGIBLE / INVALID_STATUS_TRANSITION / EVIDENCE_INSUFFICIENT | Regla de negocio.                                             |
| 429      | RATE_LIMITED                                                     | Verifier/API abuse/capacity.                                  |
| 503      | DEPENDENCY_UNAVAILABLE                                           | Dependencia crítica no resoluble.                             |

# 17. Eventos, outbox/inbox y AsyncAPI

| **Evento**                              | **Publisher** | **Consumer**                | **Payload mínimo**                                                       |
|-----------------------------------------|---------------|-----------------------------|--------------------------------------------------------------------------|
| CredentialEligibilityEvaluated          | EC-08         | EC-04/UI/analytics          | evaluationId, subjectRef, blueprintRef, outcome, evaluatedAt, reasonCode |
| CredentialAwarded                       | EC-08         | EC-10/analytics             | awardId, subjectRef, blueprintRef, awardedAt                             |
| CredentialIssuanceStarted               | EC-08         | Ops                         | issuanceId, awardId, operationId                                         |
| CredentialIssued                        | EC-08         | EC-10/CT-18/CT-07/analytics | issuanceId, awardId, serial public-safe ref, issuedAt, statusVersion     |
| CredentialSuspended                     | EC-08         | EC-10/CT-18                 | issuanceId, awardId, effectiveAt, reasonClass                            |
| CredentialReinstated                    | EC-08         | EC-10/CT-18                 | issuanceId, effectiveAt                                                  |
| CredentialRevoked                       | EC-08         | EC-10/CT-18                 | issuanceId, awardId, effectiveAt, reasonClass                            |
| CredentialSuperseded                    | EC-08         | EC-10/CT-18                 | priorIssuanceId, nextIssuanceId, effectiveAt                             |
| CredentialDeliveryChanged               | EC-08         | Ops/analytics               | deliveryRequestId, channel, state                                        |
| CredentialBatchCompleted                | EC-08         | Ops/analytics               | batchId, state, totals                                                   |
| CumulativeCredentialEvaluated           | EC-08         | EC-10/analytics             | evaluationId, targetBlueprintRef, outcome                                |
| CompletionFactPublished/Restated        | EC-07         | EC-08                       | completionFactRef, subject/enrollment refs, state/versión                |
| FinancialRegularityChanged              | Finanzas      | EC-08                       | financialFactRef, subject/enrollment scope, state/versión                |
| CredentialBlueprintPublished/Superseded | EC-01         | EC-08                       | blueprintRef/versión, policy refs                                        |

## 17.1 Envelope obligatorio

```
event_id UUID
aggregate_id UUID
tenant_id UUID
correlation_id UUID
causation_id UUID?
schema_version string
occurred_at timestamptz UTC
event_type string
payload object
```

## 17.2 Outbox/inbox

La escritura de business fact y outbox ocurre en la misma transacción PostgreSQL. Consumers deduplican por inbox. Dispatcher usa SKIP LOCKED + lease y no sostiene locks mientras llama al broker. Schema compatibility se valida en CI; un consumer que recibe versión no soportada cuarentena el mensaje sin aplicar efectos parciales.

# 18. Integraciones, resiliencia, reconciliación y UNKNOWN_EFFECT

| **Dependencia**    | **Efecto**                | **Timeout baseline**              | **Retry**                                                      | **Reconcile/degradacion**                                                                     |
|--------------------|---------------------------|-----------------------------------|----------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| CT-05 Document     | Crear PDF/evidence pack   | 5s connect / 30s overall baseline | Retry solo antes de confirmar effect; provider idempotency key | Si pudo crear document y timeout =\> query/reconcile por correlation; no crear otro a ciegas. |
| Signing/KMS        | Firmar digest/document    | 2s/10s baseline                   | Retry según provider idempotency/receipt                       | Key/sign operation UNKNOWN_EFFECT se reconcilia por request/provider ref.                     |
| CT-18 Wallet       | Publicar credential       | 3s/20s baseline                   | Backoff + Retry-After                                          | UNKNOWN_EFFECT first-class; query remote status.                                              |
| CT-18 Badge/VC     | Publish/status projection | 3s/20s baseline                   | Idempotent provider key                                        | Revoke/supersede propagation con receipts.                                                    |
| CT-07 Notification | Email/push                | 2s/10s baseline                   | Post-commit, retry bounded                                     | Fallo no revierte issuance.                                                                   |
| EC-07 Completion   | Read/event fact           | 2s/5s                             | Read retry bounded                                             | Unavailable =\> eligibility fail-closed/error.                                                |
| Finanzas           | Regularity fact           | 2s/5s                             | Read retry bounded                                             | Unknown regularity no se interpreta regular.                                                  |
| CT-02 Policy       | Immutable policy          | 2s/5s                             | Cache by versión                                               | Missing required policy =\> fail-closed.                                                      |

## 18.1 Patron UNKNOWN_EFFECT

| **Paso** | **Comportamiento**                                                              |
|----------|---------------------------------------------------------------------------------|
| 1        | EC-08 envia request con correlation/idempotency key.                            |
| 2        | Proveedor puede aplicar el efecto.                                              |
| 3        | Respuesta se pierde o timeout ocurre.                                           |
| 4        | Local marca UNKNOWN_EFFECT y persiste receipt/correlation.                      |
| 5        | Worker/Operator consulta provider status o evidencia secundaria.                |
| 6        | Si aplicado, terminaliza local sin re-ejecutar.                                 |
| 7        | Si confirmado no aplicado, retry puede ejecutarse.                              |
| 8        | Si sigue ambiguo, permanece UNKNOWN y escala; nunca se inventa success/failure. |

# 19. Frontend Web enterprise por workspaces

| **Workspace**                  | **Usuario**         | **Layout/componentes**                                                                                                  | **Acciones**                                                      |
|--------------------------------|---------------------|-------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------|
| Certificate Desk               | Credential Operator | Cola eligibility/award/issuance, filtros por programa/edicion/status, KPI pendientes/fallidos, bulk actions gobernadas. | Evaluate, award, issue, deliver, inspect evidence.                |
| Eligibility Inspector          | Operator/Reviewer   | Header holder/blueprint, rule fact matrix PASS/FAIL/UNKNOWN, provenance drawer, policy snapshot, dependency states.     | Reevaluate, export evidence, explain reasons.                     |
| Issuance Detail                | Operator/Auditor    | Serial/status hero, timeline append-only, snapshot/document/signing tabs, public verification preview, lineage.         | Deliver, open correction/revocation, download authorized.         |
| Revocation & Correction Center | Governance          | Cases queue, risk/reason filters, evidence panel, SoD/step-up prompts, diff old/new.                                    | Classify, decide, apply, close.                                   |
| Batch Issuance Center          | Operator            | Wizard select-preflight-seal-run, immutable selection summary, progress, per-item failures, retry recoverable.          | Create/seal/run/retry/export.                                     |
| Credential Interop             | Ops/Integrator      | Provider/profile status, wallet deliveries, UNKNOWN_EFFECT queue, reconciliation receipts.                              | Reconcile, retry confirmed-not-applied, inspect contract versión. |
| Verification Console           | Support/Security    | Lookup authorized credential, public projection preview, token handle state, abuse metrics.                             | Rotate/disable handle with permissions.                           |
| Holder Portal                  | Holder              | My credentials cards, status, issued date, program, download, share/QR, correction status.                              | Download, share, request correction, wallet delivery.             |
| Audit & Evidence               | Auditor             | Search award/issuance, lineage graph, policy refs, hashes, receipts, events.                                            | Export evidence pack read-only.                                   |

## 19.1 Estados obligatorios de UI

| **Estado**     | **Significado**                                         | **Tratamiento UX**                                            |
|----------------|---------------------------------------------------------|---------------------------------------------------------------|
| NO_DATA        | Consulta exitosa y no existen elementos.                | Mostrar empty state accionable; no error.                     |
| ZERO           | Metrica numerica confirmada en cero.                    | Mostrar 0 con asOf.                                           |
| STALE          | Existe última proyeccion, pero supera freshness policy. | Badge STALE + timestamp; acciones criticas pueden bloquearse. |
| PARTIAL        | Algunas fuentes/partes resolvieron y otras no.          | Mostrar que falta y provenance; no presentar cómo completo.   |
| UNAVAILABLE    | Dependencia/servicio no puede responder.                | Error no destructivo + retry/correlationId.                   |
| UNKNOWN_EFFECT | Comando remoto pudo ejecutarse.                         | Bloquear retry ciego; mostrar reconcile/status polling.       |

## 19.2 Componentes y patrones

- CredentialStatusBadge con icono + texto, no solo color.

- EvidenceDrawer con refs/provenance y controles de privacy.

- RuleFactMatrix con filtros por PASS/FAIL/UNKNOWN y tooltips de reasonCode.

- IssuanceTimeline append-only con supersession links.

- AsyncOperationBanner que distingue RUNNING/FAILED/UNKNOWN_EFFECT.

- ProviderReceiptPanel sanitizado sin secrets.

- ETag conflict modal con refresh/rebase para cases/batches mutables.

- BatchProgressTable virtualizada/paginada para miles de items.

- PublicVerificationPreview que usa exactamente la projection publica, no datos del backoffice.

## 19.3 Accesibilidad y responsive

Tablas criticas deben tener headers accesibles, focus visible, keyboard navigation y contraste institucional. Status nunca se comunica solo por color. QR siempre tiene alternativa textual/código o enlace de verificación. En anchos reducidos, tablas complejas se convierten en cards/drawers preservando reason codes y asOf. Ninguna acción crítica depende de hover.

# 20. Mobile

## 20.1 Necesidad Mobile

EC-08 si justifica Mobile para holder y verificación rapida. No se replica el backoffice completo. Revocación, correction approval, batch issuance, key rotation y operaciones administrativas de alto impacto permanecen en Web/desktop salvo ADR especifico con threat model y step-up.

| **Journey**          | **Actor**     | **Pantallas**                                                   | **Reglas**                                                    |
|----------------------|---------------|-----------------------------------------------------------------|---------------------------------------------------------------|
| Mis credenciales     | Holder        | Cards por status, programa, fecha; filtros y detalle.           | Offline cache permitido cómo STALE; no afirmar status online. |
| Detalle              | Holder        | Titulo, issuer, serial publico, status, dates, download/share.  | Auth + scoped projection.                                     |
| Mostrar QR           | Holder        | QR/token presentation con warning si offline.                   | Token no logueado; screen privacy consideration.              |
| Escanear/verificar   | Public/Holder | Camera/deep link -\> verifier.                                  | Online verification; offline muestra no verificado/STALE.     |
| Solicitar corrección | Holder        | Reason, claimed field, evidence upload via CT-05.               | No direct edit issuance.                                      |
| Entregar a wallet    | Holder        | Seleccion profile permitido, consent/purpose y OperationStatus. | UNKNOWN_EFFECT visible; no retry ciego.                       |

## 20.2 Deep links, push y biometria

Deep links de verifier deben validar scheme/host y nunca ejecutar una mutation. Push comunica cambios de status sin incluir PII excesiva. Biometria puede proteger acceso local al wallet/credential screen cómo convenience/step-up según mobile baseline, pero no reemplaza IAM server assurance para operaciones de negocio.

# 21. Matriz Frontend / Backend / Mobile

| **Capacidad**        | **Web**               | **Backend**                     | **Mobile**                    |
|----------------------|-----------------------|---------------------------------|-------------------------------|
| Evaluate eligibility | Eligibility Inspector | POST evaluation + ports/policy  | No                            |
| Issue individual     | Certificate Desk      | Issue service + OperationStatus | Holder solo solicita/consulta |
| Verify public        | Public Verifier       | Restricted verification service | Scanner/deep link             |
| Correction           | Correction Center     | Case/decisión/apply services    | Holder solicita               |
| Revocation           | Revocation Center     | Case/decisión/status facts      | No admin                      |
| Batch                | Batch Center          | Batch workers                   | No                            |
| Wallet               | Interop/Holder        | CT-18 adapter + delivery        | Holder inicia/consulta        |
| Evidence audit       | Audit workspace       | Evidence export                 | No                            |
| My credentials       | Holder portal         | Authorized projection           | Si                            |
| AI explanation       | Eligibility Inspector | CT-12 port                      | No decisión                   |

# 22. Seguridad: RBAC, ABAC, SoD, step-up y privacy

## 22.1 Roles base

| **Rol**              | **Alcance**                                                                     |
|----------------------|---------------------------------------------------------------------------------|
| CredentialOperator   | Evaluate, award, issue, delivery; no self-approve revocation when SoD required. |
| CredentialReviewer   | Review eligibility/correction/batch evidence.                                   |
| CredentialGovernance | Decide revoke/correction/void; high assurance.                                  |
| Auditor              | Read-only evidence/history/export.                                              |
| Support              | Open cases, inspect limited holder projection; no award/issue/revoke.           |
| SRE/Ops              | Operate queues/reconcile without academic decisión privilege.                   |
| SecurityAdmin        | Key/token incident operations; no award authority by default.                   |
| Holder               | Own credential view/share/correction request/wallet delivery.                   |
| PublicVerifier       | Anonymous minimal public projection only.                                       |

## 22.2 ABAC y scope

- tenant_id = authenticated tenant context; no cross-tenant access.

- issuer_scope_ref / organizational scope limita backoffice.

- Holder subjectRef debe coincidir con authenticated subject o delegated authority explicita.

- Credential type/profile puede requerir mayor assurance.

- Correction/revocation reason y classification pueden requerir data access purpose especifico.

- Public verifier solo usa PUBLIC_VERIFY purpose y projection minima.

## 22.3 SoD y step-up

| **Operación**              | **Puede iniciar**       | **Puede aprobar**                 | **No puede aprobar**              | **Step-up**          |
|----------------------------|-------------------------|-----------------------------------|-----------------------------------|----------------------|
| Award exceptional          | Operator                | Governance/Approver               | Solicitante si SoD policy         | Segun policy         |
| Material correction        | Holder/Support/Operator | Governance                        | Solicitante cómo único aprobador  | Si para apply        |
| Revocation                 | Governance/Support      | Governance Approver               | Solicitante si SoD                | Obligatorio baseline |
| Void issuance              | Governance              | Governance senior                 | Operator comun                    | Obligatorio          |
| Batch seal/run             | Operator                | Reviewer/Governance según volumen | Creador solo si policy lo prohibe | Volumen/risk based   |
| Rotate verification handle | Support/Security        | Security/Governance según motivo  | Public actor                      | Segun risk           |
| Key rotation               | Security                | Security change control           | CredentialOperator                | Obligatorio          |

## 22.4 Threat Model EC-08

| **Amenaza**                 | **Vector**                         | **Mitigacion**                                                                      |
|-----------------------------|------------------------------------|-------------------------------------------------------------------------------------|
| IDOR cross-tenant           | Manipular IDs de award/issuance    | RLS FORCE + ABAC + tenant-aware FK + negative tests.                                |
| Token guessing/enumeration  | Adivinar verifier tokens           | High entropy, token hash, global unique, rate limit, generic 404.                   |
| QR copy/replay              | Copiar imagen QR                   | QR es locator; verifier muestra current status, no prueba posesion/identity.        |
| Mass issuance abuse         | Actor emite lote indebido          | RBAC/ABAC, batch seal, SoD, capacity, audit, anomaly detection.                     |
| Revocation abuse            | Revocar credential valida          | Step-up, SoD, evidence, workflow, append-only decisión.                             |
| Payload tampering           | Cambiar title/holder after issue   | Canonical hash + immutable snapshot + signing receipt.                              |
| Key compromise              | Firmas fraudulentas                | KMS/HSM, key refs, rotation, incident runbook, issuer status strategy.              |
| Provider duplicate          | Retry crea doble wallet assertion  | Idempotency + provider receipt + UNKNOWN_EFFECT reconcile.                          |
| PII leakage                 | Verifier expone nota/deuda         | Public DTO allowlist, privacy tests, no generic entity serialization.               |
| Stale cache                 | Verifier muestra VALID tras revoke | Status event invalidation + versioned TTL + fail-safe.                              |
| RLS bypass                  | Runtime role owner/BYPASSRLS       | Separated DB roles + grants audit + CI tests.                                       |
| SECURITY DEFINER escalation | Function lookup manipulable        | Fixed search_path, dedicated owner, execute-only, input validation/security review. |

## 22.5 Secure SDLC

- SAST y SCA en PR/build; High/Critical bloquean release salvo excepción formal.

- Secret scanning; claves KMS/provider nunca en repositorio, logs o DB payloads.

- SBOM por release y container/image scan.

- DAST/API abuse tests para public verifier.

- Dependency pinning/renovation policy.

- Database grants/RLS review automatizado.

- Threat model actualizado ante nuevo provider/profile.

- Pen test enfocado en verifier publico, IDOR, enumeration, token leakage y batch abuse antes de go-live.

# 23. Auditoría, Evidence Pack, lineage y reason codes

Toda operación crítica registra tenant, actor, subject, scope, timestamp, action, resource, before/after cuándo aplique, reason code, correlationId, policy versión, assurance/step-up y evidence refs. Audit técnico no sustituye business history append-only; ambos se complementan.

| **Pack**             | **Contenido mínimo**                                                                        |
|----------------------|---------------------------------------------------------------------------------------------|
| Eligibility evidence | evaluation + rule facts + source refs/asOf + policy snapshot hash.                          |
| Award evidence       | award + evaluationRef + evidence bindings + actor/assurance.                                |
| Issuance evidence    | serial + canonical payload hash + document refs/hashes + signing receipt + issuer snapshot. |
| Lifecycle evidence   | status facts + decisions + restatements + supersession links.                               |
| Interop evidence     | delivery requests/receipts + provider/profile versions + reconciliation outcome.            |
| Batch evidence       | sealed input hash + items + terminal counts + retry/recovery history.                       |

## 23.1 Reason codes baseline

| **reasonCode**                  | **Uso**                                                                             |
|---------------------------------|-------------------------------------------------------------------------------------|
| ELIGIBLE_ALL_RULES              | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| NOT_ELIGIBLE_COMPLETION         | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| FINANCIAL_REGULARITY_UNKNOWN    | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| IDENTITY_ASSURANCE_INSUFFICIENT | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| AWARD_ALREADY_EXISTS            | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| ISSUED                          | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| DOCUMENT_PROVIDER_UNAVAILABLE   | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| SIGNING_UNKNOWN_EFFECT          | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| MATERIAL_CORRECTION             | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| RENDER_ONLY_CORRECTION          | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| FRAUD_SUSPECTED                 | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| FRAUD_CONFIRMED                 | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| REVOCATION_REJECTED             | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| TOKEN_ROTATED                   | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| PROVIDER_APPLIED                | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| PROVIDER_NOT_APPLIED            | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| BATCH_PARTIAL                   | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| SOURCE_AWARD_REVOKED            | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| CUMULATIVE_REQUIREMENT_MISSING  | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |
| LEGACY_EVIDENCE_LIMITED         | Código estable para API/audit/test; texto localizado se resuelve fuera del dominio. |

# 24. Observabilidad: logs, metrics, traces, SLI/SLO y performance

## 24.1 Logs y tracing

- Structured logs: tenantRef pseudonimizado, correlationId, operationId, resource type/id, reasonCode, dependency, latency.

- Nunca loguear verification token plano, canonical payload completo, provider secrets ni evidence PII.

- Traces propagan W3C trace context/correlation a CT-05/18 cuándo contrato lo soporte.

- Business rejection y operational failure llevan dimensiones diferentes.

## 24.2 SLI/SLO

| **SLI**                      | **Definicion**                                                                       | **SLO/objetivo**                            |
|------------------------------|--------------------------------------------------------------------------------------|---------------------------------------------|
| Public verifier availability | successful eligible HTTP responses / valid requests                                  | \>= 99.95% mensual                          |
| Public verifier latency      | p95 end-to-end                                                                       | \< 500 ms cached; \< 1000 ms DB path target |
| Issuance operational success | issuances terminales sin technical failure / attempts, excluyendo business rejection | \>= 99.9%                                   |
| Issuance latency             | p95 desde request a ISSUED cuándo providers healthy                                  | \< 30 s baseline                            |
| Outbox freshness             | eventos SENT en \<60s                                                                | \>= 99.9%                                   |
| Wallet reconciliation        | UNKNOWN_EFFECT resueltos \<30 min                                                    | \>= 95%                                     |
| Revocation visibility        | status local a verifier public projection                                            | p95 \< 10 s                                 |
| Batch throughput             | items terminales/hora según environment baseline                                     | Capacity test por tenant/worker             |

## 24.3 Metric catalog

| **Metrica**                                | **Regla**                                                           |
|--------------------------------------------|---------------------------------------------------------------------|
| ec08_eligibility_total{outcome,reason}     | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_award_total{type}                     | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_issuance_total{state,profile}         | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_issuance_latency_seconds              | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_verification_total{result}            | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_verification_latency_seconds          | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_verification_rate_limited_total       | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_status_change_total{status}           | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_delivery_total{channel,state}         | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_unknown_effect_current{dependency}    | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_outbox_lag_seconds                    | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_idempotency_replay_total              | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_batch_items_total{state}              | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_rls_violation_test_pass               | Low-cardinality labels; no token, serial completo o PII cómo label. |
| ec08_provider_error_total{dependency,code} | Low-cardinality labels; no token, serial completo o PII cómo label. |

## 24.4 Capacity budgets

| **Budget**              | **Limite conceptual**         | **Tratamiento**                                       |
|-------------------------|-------------------------------|-------------------------------------------------------|
| Verifier                | RPS publico por tenant/global | Rate limit + autoscaling; load test 2x expected peak. |
| Batch size              | Max items por batch           | Policy param; chunking; no request JSON gigante.      |
| Evidence refs           | Max refs por award/case       | Policy param + pagination.                            |
| Payload                 | Max canonical payload bytes   | Reject 422 beyond policy; no arbitrary attachments.   |
| Outbox backlog          | Max age/count alert           | Alert by lag SLO, not only queue size.                |
| Correction/revoke cases | Concurrent open cases         | Paginated; indices by state/scope.                    |

# 25. IA aplicada al módulo

| **AI RECOMMENDATION ≠ ACADEMIC DECISION — Toda IA de EC-08 pasa por CT-12. Ningun modelo puede marcar ELIGIBLE, crear Award, emitir, revocar, void o superseder una credencial por si solo.** |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **Caso**               | **Valor IA**                                      | **Guardrail**                                   |
|------------------------|---------------------------------------------------|-------------------------------------------------|
| Explicar ineligibility | Resume rule facts/policies en lenguaje claro      | Grounding obligatorio; no cambiar outcome.      |
| Anomalia de batch      | Detecta patrones inusuales de duplicates/failures | Solo flag/risk; reviewer decide.                |
| Triage de correction   | Sugiere RENDER_ONLY vs MATERIAL                   | Decisión formal humana/policy.                  |
| Evidence summarization | Resume expediente para reviewer                   | Con citations/refs; no omite evidence negativa. |
| Accessibility drafting | Sugiere alt text/explicación del credential       | No altera claims oficiales.                     |
| Interop diagnostics    | Resume provider errors y contratos                | No ejecuta retries por si sola.                 |

## 25.1 Provenance minima AI

| **Campo**              | **Obligatorio**               |
|------------------------|-------------------------------|
| run_ref                | Si                            |
| model_ref              | Si                            |
| prompt_template_ref    | Si                            |
| eval_ref               | Si cuándo exista              |
| grounding_refs         | Si                            |
| confidence/uncertainty | Si cuándo profile lo produzca |
| reviewer_subject       | Para contenido aplicado       |
| reviewer_outcome       | ACCEPTED/EDITED/REJECTED      |
| correlation_id         | Si                            |

# 26. Analitica y KPI

| **KPI**                    | **Formula**                                         | **Nota**                                      |
|----------------------------|-----------------------------------------------------|-----------------------------------------------|
| Eligibility rate           | ELIGIBLE / evaluations terminales                   | Por blueprint/program/edition; excluir ERROR. |
| Issuance conversion        | ISSUED / ELIGIBLE                                   | Detecta backlog operacional.                  |
| Time to issue              | issued_at - request.created_at                      | p50/p95 por provider/profile.                 |
| Revocation rate            | revoked awards/issuances / issued                   | Interpretar con reason/privacy.               |
| Correction rate            | corrections / issued                                | Separa render-only vs material.               |
| Verification volume        | queries valid/rate limited/not found                | Abuse y adoption; privacy minimizada.         |
| Wallet delivery success    | DELIVERED / attempts terminales                     | Separar UNKNOWN_EFFECT.                       |
| Batch partial rate         | PARTIAL / completed batches                         | Quality/operations.                           |
| Cumulative credential rate | target awards / cumulative evaluations              | No confundir con pathway progress.            |
| Legacy limitation rate     | legacy credentials with limited evidence / migrated | Data quality indicator.                       |

# 27. Migración legacy y Data Quality con CT-16

Muchas universidades poseen certificados historicos cómo PDF, planillas o numeros impresos sin blueprint versionado, hash, firma o status history. La migración debe preservar esa realidad y su provenance; no mejorar retrospectivamente la evidencia inventando datos que nunca existieron.

## 27.1 Pipeline obligatorio

| **Paso**  | **Salida**                                                                         |
|-----------|------------------------------------------------------------------------------------|
| Extract   | Legacy records + source key + original document refs.                              |
| Normalize | Names/codes/dates normalized sin perder original.                                  |
| Map       | Program/person/credential type mappings con confidence.                            |
| Validate  | Duplicate serial, ambiguous holder, date inconsistency, missing document/evidence. |
| Dry-run   | Report PASS/WARN/FAIL/QUARANTINE sin truth final.                                  |
| Promote   | Application/domain service crea legacy profile award/issuance con provenance.      |
| Receipt   | source lineage + transformed payload + promotion result.                           |
| Reconcile | Document refs, public verifier handle, duplicate detection.                        |
| Certify   | Data Steward/Governance firma evidence pack de lote.                               |

## 27.2 Reglas legacy

- No inventar CredentialBlueprint histórico si no puede mapearse con confidence suficiente; usar legacy_profile_code gobernado.

- No inventar signing receipt/hash de un PDF si no existe original verificable.

- Serial duplicado entra en quarantine hasta resolucion; no agregar sufijo silencioso.

- Nombre ambiguo de holder no se resuelve por fuzzy match automático sin review/threshold/evidence.

- Una credencial legacy puede ser verificable con nivel de assurance LIMITADO claramente indicado.

- Promotion usa mismos services/invariantes; prohibido INSERT directo a tablas finales.

# 28. QA y estrategia de pruebas

| **Capa QA**            | **Cobertura minima**                                                                                              |
|------------------------|-------------------------------------------------------------------------------------------------------------------|
| Unit Tests             | Value Objects, canonicalization, policy decisions, reason codes, state transition validators.                     |
| Domain Tests           | Eligibility, award uniqueness, issuance immutability, correction classification, revocation, cumulative policies. |
| Repository Tests       | PostgreSQL real/Testcontainers; composite keys, constraints, RLS, indices.                                        |
| Integration Tests      | Application service + DB + fake/contract adapters CT-05/18/EC-07.                                                 |
| Contract Tests         | OpenAPI, AsyncAPI y consumers/providers de CT/EC/Finance.                                                         |
| API Tests              | Auth, ProblemDetail, Idempotency-Key, If-Match, pagination, public verifier.                                      |
| Event Contract Tests   | Schema compatibility, duplicate delivery, out-of-order/unsupported versions.                                      |
| Security Tests         | IDOR, RLS, token enumeration, rate limiting, log redaction, SECURITY DEFINER.                                     |
| Tenant Isolation Tests | Read/write/query/batch/verifier admin paths cross-tenant con runtime role real.                                   |
| Concurrency Tests      | Duplicate award, serial allocation, status sequence, batch claims, outbox claims.                                 |
| Idempotency Tests      | Same key/same payload, same key/different payload, crash after effect, lease recovery.                            |
| Resilience Tests       | CT-05/KMS/CT-18 timeout/unavailable/partial/unknown effect.                                                       |
| Performance Tests      | Verifier RPS, issuance throughput, batch 1k/10k policy-bounded, outbox backlog.                                   |
| Migration Tests        | Legacy duplicates, missing evidence, ambiguous holder, dry-run/promotion/reconcile.                               |
| E2E                    | Complete -\> eligible -\> award -\> issue -\> verify -\> revoke/correct -\> verify.                               |
| UAT                    | Institutional scenarios with credential governance, registry, support, holder.                                    |
| Mobile Tests           | Offline STALE, QR deep link, holder auth, correction request, wallet operation status.                            |
| AI Evals               | Grounded explanation, no invented facts, no decisión authority, privacy redaction.                                |
| Accessibility          | Keyboard, screen reader labels, contrast, status not color-only, QR alternative.                                  |
| Backup/Restore         | Restore ordering of status facts, serial uniqueness, verifier correctness, outbox recovery.                       |

## 28.1 Matriz de trazabilidad

Cada BR-EC08 crítica debe mapear al menos a un Domain/Integration test; cada UC crítica a API/E2E; cada event a contract test; cada DB invariant a repository/constraint test; cada Threat a security test; cada SLO a performance/observability evidence. El Engineering Pack conserva una matriz BR -\> UC -\> API/Event -\> Test -\> Gate.

## 28.2 Pruebas fisicas no negociables

- Intentar insertar FK interna con tenant B desde row tenant A.

- Intentar UPDATE/DELETE de payload snapshot, signing receipt, status fact y decisions append-only.

- Intentar serial duplicado bajo concurrencia.

- Intentar dos awards semanticos iguales desde threads distintos.

- Intentar supersession self-link/ciclo.

- Ejecutar query sin SET LOCAL tenant con runtime role y comprobar cero filas/rechazo según policy.

- Intentar usar role owner/BYPASSRLS en app test y hacer fallar el gate.

- Simular two workers claim mismo outbox/batch item y comprobar single owner lease.

# 29. Golden Scenarios

| **GS**      | **Escenario**                        | **Precondicion**                              | **Acción**            | **Resultado esperado**                                 | **Evidencia**                  |
|-------------|--------------------------------------|-----------------------------------------------|-----------------------|--------------------------------------------------------|--------------------------------|
| GS-EC08-001 | Eligibility feliz                    | Blueprint y CompletionFact validos            | Evaluate              | ELIGIBLE con rule facts                                | DB evaluation + facts + audit  |
| GS-EC08-002 | Eligibility por participacion        | Policy no exige assessment                    | Evaluate              | ELIGIBLE por attendance/participation facts            | Policy snapshot + facts        |
| GS-EC08-003 | No elegible por completion           | CompletionFact FAIL/NOT_COMPLETED             | Evaluate              | INELIGIBLE                                             | Reason NOT_ELIGIBLE_COMPLETION |
| GS-EC08-004 | Financial unknown                    | Policy exige regularidad; Finance unavailable | Evaluate              | ERROR/UNAVAILABLE, no ELIGIBLE                         | Trace + reason                 |
| GS-EC08-005 | Identity assurance insuficiente      | Policy exige verified identity                | Evaluate              | INELIGIBLE/needs action según policy                   | Rule fact                      |
| GS-EC08-006 | Reevaluation policy nueva            | Evaluation vieja terminal                     | Reevaluate            | Nueva evaluation, vieja intacta                        | Lineage + two rows             |
| GS-EC08-007 | Award feliz                          | Evaluation ELIGIBLE                           | Create award          | AWARDED único                                          | Award + outbox                 |
| GS-EC08-008 | Award duplicate replay               | Same idem key                                 | Retry                 | Same award response                                    | Idempotency record             |
| GS-EC08-009 | Award duplicate concurrent           | Dos requests distintas same semantics         | Concurrent create     | Uno gana; otro 409/existing                            | Unique constraint              |
| GS-EC08-010 | Award cross-tenant                   | Eval tenant A, request tenant B               | Create award          | Denied/no row                                          | RLS test                       |
| GS-EC08-011 | Issue feliz                          | Award AWARDED/providers healthy               | Issue                 | ISSUED + serial + payload + doc + sign + verify        | Evidence pack                  |
| GS-EC08-012 | Serial duplicate                     | Allocator collision                           | Issue                 | Constraint/retry allocator; no duplicate               | DB unique                      |
| GS-EC08-013 | Document unavailable before effect   | CT-05 down                                    | Issue                 | FAILED/retryable; no false ISSUED                      | Operation status               |
| GS-EC08-014 | Document timeout unknown             | CT-05 may have created                        | Issue                 | UNKNOWN_EFFECT then reconcile                          | Provider correlation receipt   |
| GS-EC08-015 | Signing timeout unknown              | KMS may have signed                           | Issue                 | UNKNOWN_EFFECT; no second blind sign                   | Operation + receipt            |
| GS-EC08-016 | Signing confirmed                    | Digest signed                                 | Finalize              | ISSUED                                                 | SigningReceipt                 |
| GS-EC08-017 | No silent signing downgrade          | Required signing unavailable                  | Issue                 | No unsigned official issuance                          | 422/503 reason                 |
| GS-EC08-018 | Payload tamper after issue           | Direct SQL update snapshot                    | UPDATE                | Rejected by append-only trigger                        | DB error                       |
| GS-EC08-019 | Issuance field tamper                | Update serial/content_hash                    | UPDATE                | Rejected immutability guard                            | DB error                       |
| GS-EC08-020 | Public verify valid                  | Active token                                  | Verify                | VALID minimal projection                               | HTTP 200 + asOf                |
| GS-EC08-021 | Public verify revoked                | Revoked issuance                              | Verify                | REVOKED                                                | Status projection              |
| GS-EC08-022 | Public verify suspended              | Suspended                                     | Verify                | SUSPENDED                                              | Status projection              |
| GS-EC08-023 | Public verify superseded             | Old issuance                                  | Verify                | SUPERSEDED + optional current link                     | Supersession evidence          |
| GS-EC08-024 | Public verify unavailable            | DB/status path unavailable                    | Verify                | UNAVAILABLE/503, never VALID                           | Error + trace                  |
| GS-EC08-025 | Token not found                      | Random token                                  | Verify                | Generic not found                                      | No data leak                   |
| GS-EC08-026 | Token enumeration burst              | Many random tokens                            | Verify                | 429/rate limit                                         | Security metric                |
| GS-EC08-027 | Token absent in logs                 | Valid request                                 | Inspect logs          | No token plaintext                                     | Log audit                      |
| GS-EC08-028 | Rotate token                         | Compromise suspected                          | Rotate handle         | Old DISABLED; new ACTIVE                               | Handle history                 |
| GS-EC08-029 | Stale cache after revoke             | Cached VALID then revoke                      | Verify                | Cache invalidated/current REVOKED                      | Event/cache metric             |
| GS-EC08-030 | Suspend feliz                        | Approved case                                 | Apply suspend         | Status fact SUSPENDED                                  | Status sequence + audit        |
| GS-EC08-031 | Reinstate feliz                      | SUSPENDED with approval                       | Apply reinstate       | ISSUED current status                                  | Status fact                    |
| GS-EC08-032 | Revoke feliz                         | Approved revocation                           | Apply revoke          | REVOKED public                                         | Decisión + status + event      |
| GS-EC08-033 | Revoke without step-up               | No MFA                                        | Apply revoke          | 403 STEP_UP_REQUIRED                                   | Security audit                 |
| GS-EC08-034 | SoD violation revoke                 | Same initiator sole approver                  | Decide                | Rejected                                               | Policy/audit                   |
| GS-EC08-035 | Revoke provider down                 | Local revoke, CT-18 down                      | Apply                 | Local REVOKED; external delivery pending               | Outbox/delivery state          |
| GS-EC08-036 | Restate erroneous status             | Governance decisión                           | Restate               | Current projection corrected, original remains         | Restatement row                |
| GS-EC08-037 | Render-only correction               | Typography/document layout only               | Apply correction      | New document binding; same issuance payload            | Decisión + doc binding         |
| GS-EC08-038 | Material name correction             | Legal name evidence accepted                  | Apply                 | New issuance supersedes old                            | Supersession link              |
| GS-EC08-039 | Old issuance immutable               | After correction                              | Inspect old           | Unchanged payload/hash                                 | Hashes                         |
| GS-EC08-040 | Correction rejected                  | Insufficient evidence                         | Decide                | REJECTED; issuance unchanged                           | Decisión                       |
| GS-EC08-041 | Concurrent correction decisions      | Same case ETag                                | Two decides           | Second 412                                             | ETag test                      |
| GS-EC08-042 | Badge publish                        | ISSUED + profile allowed                      | Publish badge         | PUBLISHED external assertion                           | CT-18 receipt                  |
| GS-EC08-043 | Badge timeout unknown                | Provider may apply                            | Publish               | UNKNOWN_EFFECT then reconcile                          | External wallet/badge state    |
| GS-EC08-044 | Badge revoke propagation             | Issuance revoked                              | Event                 | External projection revoked/pending reconcile          | Provider receipt               |
| GS-EC08-045 | Microcredential record               | Blueprint classified microcredential          | Create                | Record with profile versión                            | DB row                         |
| GS-EC08-046 | Microcredential no degree            | Record exists                                 | Inspect PG/PO         | No automatic degree/credit award                       | Contract test                  |
| GS-EC08-047 | Wallet happy                         | ISSUED                                        | Deliver wallet        | DELIVERED                                              | Receipt                        |
| GS-EC08-048 | Wallet timeout                       | Provider applied but timeout                  | Deliver               | UNKNOWN_EFFECT                                         | Operation                      |
| GS-EC08-049 | Wallet reconcile applied             | Unknown effect                                | Query provider        | DELIVERED without retry                                | Receipt                        |
| GS-EC08-050 | Wallet reconcile not applied         | Unknown effect                                | Query provider        | Retry allowed once                                     | Receipt + idem                 |
| GS-EC08-051 | Email fails                          | Issuance already ISSUED                       | Send email            | Delivery FAILED; issuance remains ISSUED               | DB states                      |
| GS-EC08-052 | Batch 500 happy                      | 500 eligible                                  | Run batch             | COMPLETED all success                                  | Counts/items                   |
| GS-EC08-053 | Batch partial                        | 480 success 20 invalid                        | Run                   | PARTIAL; 480 preserved                                 | Per-item evidence              |
| GS-EC08-054 | Batch crash                          | Worker dies after 200                         | Recover               | Lease expires; remaining continue; no duplicates       | Lease/idempotency              |
| GS-EC08-055 | Batch duplicate run                  | Same Idempotency-Key                          | Retry run             | Same operation/batch                                   | Idempotency                    |
| GS-EC08-056 | Batch max exceeded                   | Input \> policy max                           | Seal/run              | 422/429 per contract                                   | Reason code                    |
| GS-EC08-057 | Two batch workers                    | Pending items                                 | Concurrent claim      | No same item claimed twice                             | SKIP LOCKED evidence           |
| GS-EC08-058 | Cumulative happy                     | All required awards valid same holder         | Evaluate              | ELIGIBLE -\> target award                              | Items + source set hash        |
| GS-EC08-059 | Cumulative missing award             | Requirement absent                            | Evaluate              | INELIGIBLE                                             | Rule/item fail                 |
| GS-EC08-060 | Cumulative source revoked            | One source revoked                            | Evaluate              | Policy-defined fail/review                             | Pinned source status           |
| GS-EC08-061 | Cumulative different holder          | Mixed holder refs                             | Evaluate              | Rejected                                               | Identity rule                  |
| GS-EC08-062 | Cumulative cross-tenant              | Sources from tenant B                         | Evaluate tenant A     | Denied/unresolvable                                    | RLS/contracts                  |
| GS-EC08-063 | Cumulative target emitted            | ELIGIBLE                                      | Award+issue           | Target credential issued, sources intact               | Link + source rows             |
| GS-EC08-064 | Completion restatement               | EC-07 changes completion via restatement      | Consume event         | Impact case/reevaluation; no silent award rewrite      | Inbox + audit                  |
| GS-EC08-065 | Duplicate Completion event           | Same message twice                            | Consume               | One effect                                             | Inbox PK                       |
| GS-EC08-066 | Unsupported event schema             | Future schema                                 | Consume               | QUARANTINED                                            | Inbox reason                   |
| GS-EC08-067 | Outbox duplicate delivery            | Broker redelivers event                       | Consumer              | Downstream dedup expected contract                     | Contract test                  |
| GS-EC08-068 | Outbox worker crash                  | Claimed event lease expires                   | Recover               | Reclaimed safely                                       | Lease metrics                  |
| GS-EC08-069 | Poison event                         | Repeated publish failure                      | Dispatch              | FAILED/dead-letter policy; queue continues             | Runbook                        |
| GS-EC08-070 | RLS read isolation                   | Runtime tenant A                              | Query tenant B id     | No row                                                 | DB integration test            |
| GS-EC08-071 | RLS write isolation                  | Tenant A context                              | Insert tenant B       | Rejected                                               | DB error                       |
| GS-EC08-072 | Missing tenant context               | Runtime role                                  | List awards           | No rows/reject per policy                              | Security test                  |
| GS-EC08-073 | Migrator not runtime                 | App starts with migrator creds                | Startup/gate          | Fail policy/check                                      | Deployment evidence            |
| GS-EC08-074 | Verifier function escalation attempt | Crafted input/search path                     | Call                  | No arbitrary SQL/data exposure                         | Security test                  |
| GS-EC08-075 | Legacy exact mapping                 | Serial/document/holder clear                  | Dry-run/promotion     | Legacy issuance with provenance                        | Migration receipt              |
| GS-EC08-076 | Legacy duplicate serial              | Two records same serial                       | Dry-run               | Quarantine                                             | DQ report                      |
| GS-EC08-077 | Legacy missing signature             | Old PDF unsigned                              | Promote               | No fake SigningReceipt                                 | Evidence limitation            |
| GS-EC08-078 | Legacy ambiguous holder              | Same name multiple persons                    | Dry-run               | Quarantine/manual mapping                              | DQ report                      |
| GS-EC08-079 | Legacy verifier limited              | Migrated legacy profile                       | Verify                | VALID_LEGACY/LIMITED assurance per contract            | Public projection              |
| GS-EC08-080 | AI explanation grounded              | INELIGIBLE rule facts                         | Ask AI                | Draft cites known reasons only                         | AI eval/run refs               |
| GS-EC08-081 | AI provider unavailable              | CT-12 down                                    | Ask explanation       | Deterministic non-AI facts remain usable               | UI UNAVAILABLE only for AI     |
| GS-EC08-082 | AI tries to change decisión          | Model returns eligible                        | Apply                 | Rejected; outcome unchanged                            | Guardrail test                 |
| GS-EC08-083 | AI batch anomaly                     | Suspicious duplicate pattern                  | Analyze               | Flag for reviewer only                                 | run_ref + reviewer outcome     |
| GS-EC08-084 | Mobile online QR                     | Holder online                                 | Show/scan             | Verifier current status                                | E2E mobile                     |
| GS-EC08-085 | Mobile offline QR display            | No network                                    | Open credential       | Cached STALE, no online validity assertion             | UI test                        |
| GS-EC08-086 | Mobile correction request            | Holder auth                                   | Submit                | Case created                                           | API/mobile E2E                 |
| GS-EC08-087 | Mobile wallet unknown                | Timeout                                       | Deliver               | UNKNOWN_EFFECT shown; no rapid retry                   | UI state                       |
| GS-EC08-088 | Verifier accessibility               | Keyboard/screen reader                        | Verify                | Status/text/alternative QR accessible                  | A11y evidence                  |
| GS-EC08-089 | Status not color-only                | REVOKED                                       | Render UI             | Icon + text + semantics                                | A11y test                      |
| GS-EC08-090 | Large holder feed                    | 1000 credentials                              | List                  | Paginated/virtualized                                  | Performance UX                 |
| GS-EC08-091 | Large batch UI                       | 10000 items policy allows                     | Open batch            | Pagination/virtualization no freeze                    | Frontend performance           |
| GS-EC08-092 | Key rotation                         | New KMS key                                   | Rotate config         | New issuances new key; old receipts unchanged          | Signing receipts               |
| GS-EC08-093 | Key compromise                       | Incident                                      | Run runbook           | Affected scope identified, status/reissue governed     | Incident evidence              |
| GS-EC08-094 | Document template update             | New CT-05 template                            | Issue after update    | New issuance uses new versión; old unchanged           | Template refs                  |
| GS-EC08-095 | Hash algorithm migration             | New algorithm policy                          | New issue             | New hash algorithm stored; old verifiable              | Hash fields                    |
| GS-EC08-096 | Backup restore                       | Restore DB/outbox                             | Verify credential     | Same serial/status/history and no duplicate replay     | Restore test                   |
| GS-EC08-097 | DB failover during issue             | Failover mid-operation                        | Recover               | Idempotency/OperationStatus resolves without duplicate | Chaos evidence                 |
| GS-EC08-098 | CT-18 circuit open                   | Provider failing                              | Deliver               | Fast fail/deferred; issuance unaffected                | Circuit metric                 |
| GS-EC08-099 | Rate limit provider                  | Retry-After                                   | Worker                | Respects backoff                                       | Trace                          |
| GS-EC08-100 | Timeout budget                       | Provider slow                                 | Issue/deliver         | Deadline enforced and state explicit                   | Metrics                        |
| GS-EC08-101 | Public reason privacy                | Revoked for sensitive reason                  | Verify                | REVOKED without private reason text                    | Privacy test                   |
| GS-EC08-102 | Auditor full evidence                | Authorized auditor                            | Open evidence         | Reason/evidence visible per scope                      | ABAC test                      |
| GS-EC08-103 | Support limited evidence             | Support user                                  | Open revoke case      | Only allowed fields                                    | Field-level privacy            |
| GS-EC08-104 | Holder own access                    | Holder A                                      | GET holder B issuance | 403/404 per privacy contract                           | IDOR test                      |
| GS-EC08-105 | Corporate payer                      | Company paid                                  | Verify award          | Holder remains person; company not holder              | Domain test                    |
| GS-EC08-106 | Operation 202 success                | Async issue                                   | Poll                  | RUNNING -\> SUCCEEDED resourceRef                      | API test                       |
| GS-EC08-107 | Operation unknown                    | Remote ambiguous                              | Poll                  | UNKNOWN_EFFECT visible                                 | API test                       |
| GS-EC08-108 | Operation reconcile                  | Unknown operation                             | Reconcile             | Terminal according provider proof                      | Receipt                        |
| GS-EC08-109 | Operation progress invalid           | Direct DB \>100                               | Insert/update         | CHECK rejects                                          | DB test                        |
| GS-EC08-110 | SLO verifier load                    | Peak x2                                       | Load test             | p95 within target/error budget measured                | Perf report                    |
| GS-EC08-111 | Outbox lag alert                     | Pause dispatcher                              | Observe               | Alert before SLO breach threshold                      | Observability evidence         |
| GS-EC08-112 | Revocation freshness                 | Revoke                                        | Verify within target  | Projection updates \<10s p95 target                    | Metric                         |
| GS-EC08-113 | Business rejection metrics           | Ineligible evaluations                        | Dashboard             | Not counted as operational errors                      | Metric dimensions              |
| GS-EC08-114 | No PII metric labels                 | Traffic                                       | Inspect metrics       | No token/name/serial full labels                       | Telemetry audit                |
| GS-EC08-115 | Schema N/N-1                         | Deploy expanded schema first                  | Run old+new apps      | Both work                                              | Compatibility test             |
| GS-EC08-116 | Rollback app                         | New app issue discovered                      | Rollback code         | Old code works with expanded schema                    | Release evidence               |
| GS-EC08-117 | Contract breaking change             | AsyncAPI/OpenAPI incompatible                 | CI                    | Gate fails                                             | Contract diff                  |
| GS-EC08-118 | High SCA finding                     | Critical dependency CVE                       | Build                 | Release blocked or formal exception                    | Security gate                  |
| GS-EC08-119 | Secret in repo                       | Scanner detects key                           | CI                    | Build blocked                                          | Secret scan                    |
| GS-EC08-120 | Golden end-to-end                    | Participant completes course                  | Full chain            | Issued credential verifies VALID                       | E2E evidence                   |
| GS-EC08-121 | Golden correction end-to-end         | Valid credential has material error           | Correct chain         | Old SUPERSEDED, new VALID                              | E2E evidence                   |
| GS-EC08-122 | Golden revocation end-to-end         | Valid credential later revoked                | Revoke chain          | Verifier REVOKED + provider updates                    | E2E evidence                   |
| GS-EC08-123 | Golden cumulative end-to-end         | Holder earns stack                            | Cumulative chain      | Target microcredential issued                          | E2E evidence                   |

# 30. UAT institucional

| **UAT** | **Escenario institucional**                                                               | **Criterio de aceptacion**         |
|---------|-------------------------------------------------------------------------------------------|------------------------------------|
| UAT-01  | Registro certifica un participante eligible y verifica el resultado por QR.               | Award/issuance/verifier completos. |
| UAT-02  | Participante no eligible recibe reason comprensible sin que se emita.                     | No award + rule facts.             |
| UAT-03  | Certificado por participacion sin evaluation académica se emite cuándo policy lo permite. | Policy respetada.                  |
| UAT-04  | Certificado por aprobación exige CompletionFact PASS.                                     | Fail-closed.                       |
| UAT-05  | Corrección material genera nueva credencial y conserva anterior cómo SUPERSEDED.          | Lineage visible.                   |
| UAT-06  | Corrección solo de render no altera canonical claims.                                     | Same issuance/hash semantics.      |
| UAT-07  | Revocación con SoD y step-up aparece en verifier.                                         | REVOKED end-to-end.                |
| UAT-08  | Suspension y reinstatement conservan history.                                             | Timeline completa.                 |
| UAT-09  | Wallet timeout se muestra UNKNOWN_EFFECT y se reconcilia sin duplicar.                    | Provider receipt.                  |
| UAT-10  | Email falla pero issuance permanece valida.                                               | Delivery separated.                |
| UAT-11  | Batch 500 termina partial y permite retry solo de fallidos.                               | Partial success.                   |
| UAT-12  | Batch reanudado tras crash no duplica seriales.                                           | Idempotency/lease.                 |
| UAT-13  | Microcredencial se muestra cómo tal sin afirmar degree equivalence.                       | Semantic boundary.                 |
| UAT-14  | Credential acumulativa usa awards fuente del mismo holder.                                | Cumulative evidence.               |
| UAT-15  | Source award revocado afecta cumulative según policy.                                     | Pinned status + decisión.          |
| UAT-16  | Public verifier no expone nota, deuda ni IDs internos.                                    | Privacy review.                    |
| UAT-17  | Holder portal muestra más detalle solo autenticado.                                       | ABAC.                              |
| UAT-18  | Usuario de tenant A no accede a credential de tenant B.                                   | RLS/IDOR.                          |
| UAT-19  | Auditor exporta evidence pack completo.                                                   | Evidence refs/hashes.              |
| UAT-20  | Legacy credential sin firma se marca con assurance limitada; no se inventa receipt.       | Migration honesty.                 |
| UAT-21  | QR rotado invalida handle anterior sin cambiar award.                                     | Handle lifecycle.                  |
| UAT-22  | Key rotation aplica solo a nuevas firmas y conserva history.                              | Signing refs.                      |
| UAT-23  | Revocation reason sensible no se publica.                                                 | Field-level privacy.               |
| UAT-24  | Mobile offline muestra STALE y no afirma validación actual.                               | Offline behavior.                  |
| UAT-25  | Screen reader puede interpretar status y acciones del verifier.                           | Accessibility.                     |
| UAT-26  | AI explica ineligibility grounded y no cambia decisión.                                   | AI guardrails.                     |
| UAT-27  | CT-05 unavailable bloquea issuance requerido sin downgrade silencioso.                    | Resilience.                        |
| UAT-28  | CT-18 unavailable no invalida credencial ya emitida.                                      | Interop boundary.                  |
| UAT-29  | Deployment N/N-1 mantiene servicio durante migration.                                     | Zero-downtime.                     |
| UAT-30  | Restore de backup conserva serial/status/verifier correcto.                               | DR evidence.                       |

# 31. Gates G1-G10

| **Gate** | **Nombre**                     | **Evidencia minima para aprobar**                                                              |
|----------|--------------------------------|------------------------------------------------------------------------------------------------|
| G1       | Arquitectura y bounded context | DA/ADR cerrados; SoT boundaries; threat model inicial; no duplicacion CT/EC upstream.          |
| G2       | Datos/constraints              | DDL real probado; tenant-aware FK; RLS; append-only; serial/award uniqueness; restore schema.  |
| G3       | Backend                        | Domain/application services, @Versión, idempotency, state commands, tests.                     |
| G4       | API/Event contracts            | OpenAPI/AsyncAPI, ProblemDetail, pagination, contract tests, N/N-1 compatibility.              |
| G5       | Frontend/Mobile                | Workspaces, states, accessibility, ETag/OperationStatus, offline STALE.                        |
| G6       | Seguridad/auditoría            | RBAC/ABAC/SoD/step-up, public verifier threat tests, RLS negative, secret/SAST/SCA/SBOM.       |
| G7       | Integraciones/resiliencia      | CT-05/KMS/CT-18 timeouts, circuit, receipts, UNKNOWN_EFFECT/reconcile, chaos tests.            |
| G8       | QA/UAT                         | Golden scenarios criticos automatizados + 30 UAT con evidence.                                 |
| G9       | Migración/operaciones          | CT-16 dry-run, DQ, runbooks, observability, backup/restore, capacity.                          |
| G10      | Release/certificacion          | Evidence pack final, no P0/P1 abiertos, SLO dashboard, rollback/roll-forward tested, sign-off. |

| **NO APROBAR UN GATE SIN EVIDENCIA — Una reunion, captura aislada o declaracion verbal no sustituye tests, reports, hashes, contract artifacts y sign-off trazable.** |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 32. Definition of Ready / Definition of Done

## 32.1 Definition of Ready

- Blueprint/policies/contracts upstream identificados y versionados.

- Bounded Context y Source of Truth confirmados.

- DA/ADR de public verifier, signing y correction classification resueltos.

- Threat Model actualizado.

- OpenAPI/AsyncAPI draft revisados por consumers.

- DDL/constraint design revisado por DBA/Security.

- Golden scenarios y UAT criticos identificados.

- Provider sandbox/contract fixtures disponibles o simulacion aprobada.

- Feature flags/migration plan definido si cambia schema existente.

## 32.2 Definition of Done

- Flyway probado en PostgreSQL real, upgrade N/N-1 y restore.

- RLS/grants/append-only/uniqueness tests verdes.

- Backend unit/domain/repository/integration/contract/security/performance tests verdes.

- OpenAPI/AsyncAPI publicados y client generado compatible.

- Frontend/Mobile cubren NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.

- Verifier public accessibility/security/load tests aprobados.

- Unknown effects y runbooks ejercitados.

- Dashboards/alerts activos.

- Engineering Pack completo en Git.

- G1-G10 con evidence y sign-off.

# 33. Runbooks

| **Runbook** | **Incidente**                               | **Acción resumida**                                                                                  |
|-------------|---------------------------------------------|------------------------------------------------------------------------------------------------------|
| RB-EC08-001 | CT-05 document service unavailable          | Pause terminalization; inspect operations; reconcile; never mark ISSUED without required evidence.   |
| RB-EC08-002 | Signing/KMS unavailable                     | Fail closed; no unsigned downgrade; queue/retry policy.                                              |
| RB-EC08-003 | Signing UNKNOWN_EFFECT                      | Query provider/KMS receipt; correlate digest; do not blind sign again.                               |
| RB-EC08-004 | Wallet UNKNOWN_EFFECT backlog               | Query remote statuses in controlled batch; mark applied/not-applied; retry only proven not applied.  |
| RB-EC08-005 | Public verifier outage                      | Prioritize read path, fail safe UNAVAILABLE, CT-17 continuity and cache policy.                      |
| RB-EC08-006 | Verification abuse spike                    | Rate limit, WAF/rules, investigate without excessive PII retention.                                  |
| RB-EC08-007 | Signing key compromise                      | Identify affected key_ref/issuances, disable key, activate incident governance, status/reissue plan. |
| RB-EC08-008 | Duplicate serial alert                      | Stop allocator path, inspect concurrent transactions/migration, never renumber issued history.       |
| RB-EC08-009 | Batch partial failure                       | Freeze/review failed categories, retry recoverable only, export item evidence.                       |
| RB-EC08-010 | Outbox lag                                  | Inspect leases/broker, reclaim expired, poison-event isolation, preserve order semantics.            |
| RB-EC08-011 | Idempotency stuck IN_PROGRESS               | Check lease/operation/resource truth; recover ownership without duplicating effect.                  |
| RB-EC08-012 | Incorrect holder display                    | Open correction; classify render-only/material; no direct SQL fix.                                   |
| RB-EC08-013 | Fraud revocation emergency                  | Open high-priority case, step-up/SoD, apply local status first, propagate downstream.                |
| RB-EC08-014 | RLS anomaly                                 | Contain runtime credentials, verify role ownership/BYPASSRLS, audit tenant access, rotate secrets.   |
| RB-EC08-015 | Stale verifier cache                        | Invalidate affected keys/status versión, verify event pipeline, no TTL-only assumptions.             |
| RB-EC08-016 | Migration mismatch                          | Quarantine batch, compare source lineage/mappings, rollback promotion by governed status not delete. |
| RB-EC08-017 | Provider schema breaking change             | Trip circuit/disable profile flag, contract diff, adapter update, do not corrupt core.               |
| RB-EC08-018 | Verification token leak                     | Disable/rotate handle, preserve issuance, notify holder if policy requires.                          |
| RB-EC08-019 | Critical vulnerability                      | Feature isolate/public endpoint controls, patch/scan, evidence exception if emergency.               |
| RB-EC08-020 | Database failover                           | Validate idempotency leases, outbox claims, status sequence, verifier consistency.                   |
| RB-EC08-021 | Audit evidence export                       | Use scoped service, hash export, exclude secrets, record purpose.                                    |
| RB-EC08-022 | Source award revoked after cumulative award | Impact analysis + policy; open case if target may be affected; no automatic destructive revoke.      |
| RB-EC08-023 | Credential template defect                  | Assess render-only vs material claim impact; controlled regenerate/reissue.                          |
| RB-EC08-024 | Expiry dispute                              | Resolve blueprint/policy snapshot and dates; do not modify historical issued_at.                     |
| RB-EC08-025 | Prolonged UNKNOWN operation                 | Escalate provider/manual evidence; keep state explicit; never guess.                                 |
| RB-EC08-026 | Restore verifier from backup                | Restore DB/read models, replay status events, invalidate cache, run known-token verification suite.  |

# 34. ADRs y decisiones abiertas

| **ADR**      | **Decisión**                        | **Estado**            | **Resolucion / condicion**                                                                          |
|--------------|-------------------------------------|-----------------------|-----------------------------------------------------------------------------------------------------|
| ADR-EC08-001 | Award separado de Issuance          | CERRADO               | Mantener hechos separados para correction/re-render/delivery.                                       |
| ADR-EC08-002 | Canonical payload format            | CERRADO               | Provider-neutral JSON canonico versionado.                                                          |
| ADR-EC08-003 | Public token hash                   | CERRADO               | Persistir solo hash de token de alta entropia.                                                      |
| ADR-EC08-004 | Public verifier DB access           | CERRADO CON GUARDRAIL | Gateway/role restringido; SECURITY DEFINER solo hardened/reviewed.                                  |
| ADR-EC08-005 | Signing key storage                 | CERRADO               | KMS/HSM/adapter; nunca private key en DB.                                                           |
| ADR-EC08-006 | Status as append-only facts         | CERRADO               | Current state derived/projection.                                                                   |
| ADR-EC08-007 | Material correction strategy        | CERRADO               | Superseding issuance.                                                                               |
| ADR-EC08-008 | Render-only correction              | CERRADO               | Nuevo document binding solo si canonical claims unchanged y policy lo permite.                      |
| ADR-EC08-009 | Credential interoperability         | CERRADO               | CT-18 adapters; core provider-neutral.                                                              |
| ADR-EC08-010 | Batch atomicity                     | CERRADO               | Per-item terminal semantics; PARTIAL allowed.                                                       |
| ADR-EC08-011 | Cumulative progress ownership       | CERRADO               | EC-10 owns continuous progress; EC-08 evaluates/awards target.                                      |
| ADR-EC08-012 | Redis verifier cache                | CERRADO               | Non-authoritative, invalidation by status event/versión.                                            |
| ADR-EC08-013 | Legacy assurance representation     | CERRADO               | Explicit limited profile; never invent signing/evidence.                                            |
| ADR-EC08-014 | Serial allocation mechanism         | ABIERTO CONTROLADO    | Choose sequence/allocator design per tenant/issuer volume before G2.                                |
| ADR-EC08-015 | Public verifier URL/token transport | ABIERTO CONTROLADO    | GET path vs POST body/deep-link strategy subject to gateway/log threat review before G4.            |
| ADR-EC08-016 | Credential expiry projection        | ABIERTO CONTROLADO    | Derived EXPIRED vs explicit status fact depends institutional policy; freeze before implementation. |

# 35. Engineering Pack

| **Ruta Git**   | **Artefactos minimos**                                                                |
|----------------|---------------------------------------------------------------------------------------|
| /docs          | EC-08 spec export, glossary, BR/UC/GS traceability, UAT evidence index.               |
| /openapi       | ec08-credentials-v1.yaml + generated client artifacts/checks.                         |
| /asyncapi      | ec08-credential-events-v1.yaml + schema examples/compatibility.                       |
| /db/migration  | Vxxx\_\_ec08_schema.sql, RLS, roles/grants, indices, triggers, expand/contract steps. |
| /architecture  | context/domain/sequence/deployment diagrams; public verifier data flow.               |
| /adr           | ADR-EC08-001...016 plus future decisions.                                             |
| /backend       | Java module, domain/application/adapters/config.                                      |
| /frontend      | Credential workspaces, public verifier, holder portal feature modules.                |
| /mobile        | Holder credential/QR/correction/wallet features.                                      |
| /tests         | Unit/domain/repository/integration/contract/E2E/security/tenant/idempotency.          |
| /performance   | Verifier load, batch, issuance, outbox reports and baselines.                         |
| /security      | Threat model, grants/RLS evidence, SAST/SCA/DAST/SBOM/pen-test artifacts.             |
| /runbooks      | RB-EC08-001...026 executable procedures.                                              |
| /observability | Dashboards, alerts, SLI/SLO definitions.                                              |
| /migration     | CT-16 mappings, dry-run reports, DQ, lineage.                                         |
| /evidence      | Gate sign-offs, hashes, UAT evidence, restore/chaos results.                          |

# 36. Guia secuencial Backend

**Paso 1 —** Crear Spring Modulith module ec08credential y package-info dependencies.

**Paso 2 —** Implementar Value Objects CredentialSerial, PolicyRef, ExternalRef, TokenHash, ReasonCode.

**Paso 3 —** Modelar CredentialEligibilityEvaluation + EligibilityRuleFact y policies.

**Paso 4 —** Modelar CredentialAward y award evidence.

**Paso 5 —** Modelar CredentialIssuance/IssuanceRequest y canonical snapshot.

**Paso 6 —** Modelar lifecycle append-only status/restatement/revocation/correction.

**Paso 7 —** Modelar delivery, badge, wallet, cumulative y batch aggregates.

**Paso 8 —** Crear ports EC-01, EC-07, CT-02/04/05/06/07/10/12/18, Finance/KMS.

**Paso 9 —** Implementar persistence mappings con composite tenant keys.

**Paso 10 —** Crear Flyway schema/constraints/internal FK.

**Paso 11 —** Agregar RLS ENABLE+FORCE, grants y DB roles separados.

**Paso 12 —** Implementar append-only/issuance immutability triggers y repository tests.

**Paso 13 —** Implementar TenantContext transaccional SET LOCAL.

**Paso 14 —** Implementar Aggregate Revisión + @Versión + child bump dónde aplica.

**Paso 15 —** Implementar durable idempotency lease/recovery.

**Paso 16 —** Implementar outbox/inbox con SKIP LOCKED + lease/backoff/poison handling.

**Paso 17 —** Implementar serial allocator elegido por ADR, con UNIQUE cómo última defensa.

**Paso 18 —** Implementar EligibilityEvaluator y rule provenance.

**Paso 19 —** Implementar AwardCredentialService con semantic duplicate protection.

**Paso 20 —** Implementar IssueCredentialService asynchrony/OperationStatus y remote effect boundaries.

**Paso 21 —** Implementar canonicalization/hash/signing/document workflow.

**Paso 22 —** Implementar PublicVerificationService/gateway restricted + token hashing + privacy allowlist.

**Paso 23 —** Implementar correction/revocation commands con SoD/step-up hooks.

**Paso 24 —** Implementar CT-18 delivery/wallet/badge adapters con UNKNOWN_EFFECT reconcile.

**Paso 25 —** Implementar batch claim/process/recovery.

**Paso 26 —** Implementar cumulative evaluation con source pinning.

**Paso 27 —** Exponer REST controllers/ProblemDetail/ETag/Idempotency/202.

**Paso 28 —** Publicar OpenAPI/AsyncAPI y generar contract tests.

**Paso 29 —** Agregar structured logs, metrics, tracing, dashboards.

**Paso 30 —** Agregar security tests RLS/IDOR/enumeration/token redaction.

**Paso 31 —** Agregar performance/chaos/backup-restore tests.

**Paso 32 —** Cerrar G1-G10 y evidence pack.

## 36.1 Skeleton de comando IssueCredential

```
@Transactional
public IssueAccepted handle(IssueCredentialCommand cmd) {
tenantContext.setLocal();
var idem = idempotency.acquire(cmd.key(), cmd.payloadHash());
if (idem.replayable()) return idem.previousResult();
var award = awardRepo.lock(cmd.awardId());
issuancePolicy.assertIssuable(award, cmd.actor());
var request = issuanceRequestRepo.create(...);
var operation = operationRepo.create(...);
outbox.append(IssuanceRequested.of(request, operation));
idem.bindResource(request.id());
return IssueAccepted.of(request.id(), operation.id());
}
// Remote document/signing occurs after commit in worker with receipts + reconcile.
```

# 37. Guia secuencial Frontend

**Paso 1 —** Crear feature modules credentials, eligibility, issuance, lifecycle, batch, verifier y holder.

**Paso 2 —** Generar/actualizar API client desde OpenAPI; prohibido duplicar DTO manual.

**Paso 3 —** Definir query keys tenant/scope aware sin incluir PII innecesaria.

**Paso 4 —** Construir workspace shell con role/scope guards server-derived.

**Paso 5 —** Implementar Certificate Desk list/filter/pagination.

**Paso 6 —** Implementar Eligibility Inspector y RuleFactMatrix.

**Paso 7 —** Implementar Issuance Detail con timeline, documents, hashes y provider tabs.

**Paso 8 —** Implementar Correction/Revocation Center con ETag y evidence workflow.

**Paso 9 —** Implementar Batch wizard create-preflight-seal-run y virtualized item table.

**Paso 10 —** Implementar Credential Interop/UNKNOWN_EFFECT reconciliation center.

**Paso 11 —** Implementar Public Verifier separado del backoffice con DTO allowlist.

**Paso 12 —** Implementar Holder Portal /me projection.

**Paso 13 —** Implementar mutation layer con Idempotency-Key y If-Match.

**Paso 14 —** Implementar OperationStatus polling/backoff y terminal handling.

**Paso 15 —** Implementar explicit NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT components.

**Paso 16 —** Implementar accessibility: focus, keyboard, aria/status, non-color semantics, QR alternative.

**Paso 17 —** Implementar responsive/mobile handoff/deep links.

**Paso 18 —** Implementar tests unit/component/contract/E2E/a11y/security regression.

**Paso 19 —** Instrumentar web vitals/business telemetry sin PII.

**Paso 20 —** Cerrar G5/G8 evidence con screenshots/tests, no solo review manual.

# 38. Matriz de permisos

| **Capacidad**          | **CredentialOperator** | **Reviewer** | **Governance**     | **Auditor** | **Support**    | **SRE/Ops**                | **Holder**       |
|------------------------|------------------------|--------------|--------------------|-------------|----------------|----------------------------|------------------|
| Evaluate eligibility   | R/W                    | R            | R                  | R           | R limited      | --                         | Own only         |
| Create award           | R/W                    | R            | Approve exception  | R           | --             | --                         | --               |
| Issue credential       | R/W                    | R            | Approve high-risk  | R           | --             | Operate only               | Request/view own |
| View canonical payload | R                      | R            | R                  | R           | Limited        | Operational metadata       | Own projection   |
| Suspend/revoke         | Initiate limited       | Review       | R/W                | R           | Open case only | Apply technical event only | --               |
| Correction             | Initiate/apply         | Classify     | Decide             | R           | Open           | Operate workflow           | Open own         |
| Batch                  | R/W                    | Review/seal  | Approve per policy | R           | --             | Operate workers            | --               |
| Wallet delivery        | R/W                    | R            | R                  | R           | Support        | Reconcile                  | Own              |
| Rotate verifier token  | Limited                | --           | Approve            | R           | Request        | Operate                    | Own request      |
| Key rotation           | --                     | --           | --                 | R evidence  | --             | Security-only role         | --               |
| Evidence export        | R limited              | R            | R                  | R/W export  | Limited        | Operational                | Own limited      |
| Public verify          | Public DTO             | Public DTO   | Public DTO         | Public DTO  | Public DTO     | Public DTO                 | Public DTO       |

# 39. Contratos DTO Frontend

| **DTO**            | **Campos**                                                                                                                        | **Uso/regla**                   |
|--------------------|-----------------------------------------------------------------------------------------------------------------------------------|---------------------------------|
| CredentialListItem | awardId/issuanceId opaque, title, program, state, issuedAt, holderDisplay policy, currentDocumentAvailable, verificationAvailable | List/holder; no heavy evidence. |
| EligibilityDetail  | evaluationId,state,reasonCode,ruleFacts\[\],policyRef,asOf,dependencies\[\]                                                       | Inspector.                      |
| RuleFact           | ruleCode,outcome,reasonCode,sourceContext,sourceRef masked/display,sourceAsOf,evidenceAvailable                                   | No source payload copy.         |
| AwardDetail        | awardId,awardCode,state,blueprintProjection,holderProjection,awardedAt,currentIssuanceRef,evidenceSummary                         | Authorized only.                |
| IssuanceDetail     | issuanceId,serial,state,issuedAt,contentHash display-safe,documentBindings,statusTimeline,supersession,deliverySummary            | Backoffice.                     |
| PublicVerification | status,credentialTitle,holderDisplayName policy,issuerDisplayName,issuedAt,validUntil?,statusUpdatedAt,asOf,supersededBy?         | Allowlist only.                 |
| CorrectionCase     | id,state,classification,reasonCode,evidenceSummary,workflowRef,versión                                                            | ETag mapped.                    |
| RevocationCase     | id,caseKind,state,reasonCode private-permissions,workflowRef,decisionSummary,versión                                              | Field-level privacy.            |
| BatchDetail        | id,code,kind,state,total,succeeded,failed,inputHash,progress,versión                                                              | No entire item list inline.     |
| BatchItem          | itemNo,subjectProjection,state,reasonCode,resourceRefs,attemptCount,lastUpdated                                                   | Paginated.                      |
| OperationStatus    | operationId,operationCode,state,progressPercent,reasonCode,resourceRef,updatedAt                                                  | UNKNOWN_EFFECT explicit.        |
| DeliveryStatus     | channel,state,providerProjection,lastReconciledAt,reasonCode                                                                      | No provider secrets.            |

## 39.1 Convenciones client

- Dates/times se reciben ISO-8601 UTC; UI presenta timezone autorizado.

- Enums/states desconocidos no se traducen a success; usar fallback UNKNOWN_UNSUPPORTED.

- ETag se conserva fuera del body y se envia en If-Match.

- Idempotency-Key se genera por mutation intent y se reutiliza en retry del mismo payload.

- ProblemDetail.reasonCode gobierna UX; detail text no se parsea.

- Public DTO no reutiliza IssuanceDetail interno.

# 40. Checklist de release y certificacion final

| **Check** | **Control**                                                              |
|-----------|--------------------------------------------------------------------------|
| C01       | EC-00/01/07/CT contracts pinneados y ADRs resueltos.                     |
| C02       | 33 tablas EC-08 documentadas y DDL coincide con Word/Git.                |
| C03       | Todas las FK internas tenant-aware; cero FK cross-context.               |
| C04       | RLS ENABLE+FORCE y runtime/worker/verifier roles sin BYPASSRLS.          |
| C05       | Append-only triggers y issuance immutability tests verdes.               |
| C06       | Serial/award uniqueness bajo concurrency probada.                        |
| C07       | Idempotency lease/recovery probado con crash injection.                  |
| C08       | Outbox/inbox SKIP LOCKED, duplicate delivery y poison handling probados. |
| C09       | UNKNOWN_EFFECT/reconcile probado CT-05/signing/CT-18.                    |
| C10       | Public verifier minimizado, rate-limited, log-redacted y load-tested.    |
| C11       | Correction material supersession E2E verde.                              |
| C12       | Revocation SoD/step-up + verifier freshness verde.                       |
| C13       | Batch partial/restart/no duplicate verde.                                |
| C14       | Cumulative same-holder/source-status rules verdes.                       |
| C15       | OpenAPI/AsyncAPI compatibility y generated client verdes.                |
| C16       | Frontend estados y accessibility verificados.                            |
| C17       | Mobile offline STALE/deep link/QR/correction/wallet tests verdes.        |
| C18       | SAST/SCA/secret/container/DAST/SBOM sin blockers.                        |
| C19       | CT-16 legacy dry-run/promotion/reconcile certificado.                    |
| C20       | Dashboards/alerts SLI/SLO activos.                                       |
| C21       | Backup/restore/failover test conserva verifier truth.                    |
| C22       | Runbooks ejercitados y owners/on-call definidos.                         |
| C23       | Golden scenarios criticos automatizados.                                 |
| C24       | 30 UAT con evidence y sign-off institucional.                            |
| C25       | G1-G10 aprobados con evidence pack.                                      |

# 41. Contrato FullStack no negociable de implementación

**FULLSTACK-01 —** EC-08 no recalcula CompletionFact ni datos financieros; consume facts oficiales por contrato.

**FULLSTACK-02 —** CredentialEligibility, Award, Issuance y Document son conceptos separados en dominio, DB y API.

**FULLSTACK-03 —** Todo tenant-owned table tiene RLS ENABLE+FORCE y runtime sin BYPASSRLS.

**FULLSTACK-04 —** tenant_id nunca se confia desde body libre.

**FULLSTACK-05 —** No existen FK fisicas cross-context.

**FULLSTACK-06 —** Award semantic duplicate y serial duplicate tienen defensa PostgreSQL.

**FULLSTACK-07 —** Issuance ISSUED y canonical payload son inmutables.

**FULLSTACK-08 —** Status, decisions, receipts y evidence history son append-only o restated, nunca overwritten.

**FULLSTACK-09 —** Corrección material crea superseding issuance.

**FULLSTACK-10 —** Revocation/void/suspend son commands gobernados, no PATCH status.

**FULLSTACK-11 —** Public verifier usa DTO allowlist y fail-safe state.

**FULLSTACK-12 —** Verification token se persiste hasheado y se redacta de logs.

**FULLSTACK-13 —** QR es locator, no identity proof ni credential truth.

**FULLSTACK-14 —** Private signing keys nunca viven en PostgreSQL ni código.

**FULLSTACK-15 —** Signing/document/provider receipts permiten reconstructibilidad/reconcile.

**FULLSTACK-16 —** Toda policy relevante esta versionada/pinneada; no hardcode de thresholds/expiry.

**FULLSTACK-17 —** Idempotency-Key durable protege commands sensibles y soporta lease recovery.

**FULLSTACK-18 —** Outbox/inbox implementa at-least-once + dedup y SKIP LOCKED lease.

**FULLSTACK-19 —** UNKNOWN_EFFECT es estado real y retry ciego esta prohibido.

**FULLSTACK-20 —** Toda respuesta 202 ofrece OperationStatus consultable.

**FULLSTACK-21 —** Redis/Mongo son derivados/no-authoritative.

**FULLSTACK-22 —** CT-18 media wallet/Open Badges/VC/CLR; no SDK vendor dentro del dominio.

**FULLSTACK-23 —** Delivery failure no revierte award/issuance ya confirmados.

**FULLSTACK-24 —** EC-10 gobierna progreso continuo; EC-08 solo consume/evalua para cumulative award.

**FULLSTACK-25 —** Microcredential no implica degree/credit equivalence automatica.

**FULLSTACK-26 —** Frontend distingue NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT.

**FULLSTACK-27 —** Frontend usa OpenAPI-generated/validated contracts y ProblemDetail reason codes.

**FULLSTACK-28 —** Mutaciones de aggregate mutable usan ETag/If-Match; no last-write-wins.

**FULLSTACK-29 —** Mobile no expone operaciones administrativas criticas por conveniencia.

**FULLSTACK-30 —** Mobile offline muestra STALE y nunca afirma validación actual.

**FULLSTACK-31 —** RBAC/ABAC/SoD/step-up y purpose limitation se aplican server-side.

**FULLSTACK-32 —** Public verifier pasa threat model, abuse, privacy, DAST y load tests.

**FULLSTACK-33 —** Secure SDLC incluye SAST/SCA/secret/container scan/SBOM y blockers.

**FULLSTACK-34 —** Migrations productivas siguen expand/contract N/N-1.

**FULLSTACK-35 —** CT-16 promueve legacy por domain/API, nunca INSERT directo final.

**FULLSTACK-36 —** Migración no inventa firmas, hashes, policies ni evidence historica.

**FULLSTACK-37 —** Logs/metrics/traces no incluyen token plano ni PII cómo labels.

**FULLSTACK-38 —** SLI/SLO distinguen business rejection de operational failure.

**FULLSTACK-39 —** Backup/restore preserva serial, status ordering, idempotency y verifier correctness.

**FULLSTACK-40 —** G1-G10 no se aprueban sin evidence ejecutable y UAT.

**FULLSTACK-41 —** Word es Especificacion Maestra; Git/Flyway/OpenAPI/AsyncAPI/tests son implementación verificable alineada.

**FULLSTACK-42 —** Toda desviacion de este contrato requiere ADR explicito, revisado y aprobado antes del merge/release.

| **CERTIFICACION DEL MODULO — EC-08 esta listo para produccion solo cuándo arquitectura, datos, backend, contratos, frontend/mobile, seguridad, integraciones, QA, migración, observabilidad, continuidad y evidence han superado G1-G10. Un build verde sin estas evidencias no equivale a release certificado.** |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
