**PEOPLEU IA**

**EC-03**

**COMERCIALIZACIÓN ACADÉMICA, PRICING,  
PROMOCIONES, BECAS, CONVENIOS Y  
CONDICIONES DE OFERTA**

Guía de Ingeniería Implementable — Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Control**        | **Valor**                                                                                                      |
|--------------------|----------------------------------------------------------------------------------------------------------------|
| **Código**         | EC-03                                                                                                          |
| **Versión**        | V1.0                                                                                                           |
| **Estado**         | VIGENTE — ESPECIFICACIÓN IMPLEMENTABLE FULLSTACK ENTERPRISE                                                    |
| **Baseline**       | EC-00 V1.1 · EC-01 V1.1 — Plantilla Oficial FullStack Enterprise · EC-02 V1.0                                  |
| **Vertical**       | Educación Continua / Formación Continua                                                                        |
| **Arquitectura**   | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| **Stack objetivo** | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| **Contexto**       | Universidades privadas · Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma   |
| **Fecha base**     | Septiembre 2026                                                                                                |

| **GOBIERNO DE ARTEFACTOS —** Word = Especificación Maestra Oficial. Git = código, Flyway, OpenAPI, AsyncAPI, ADRs y tests ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

| **REGLA DE FRONTERA —** EC-03 es Source of Truth de la decisión comercial académica previa al hecho financiero: price books versionados, promociones, becas/beneficios comerciales, quotes y ChargeIntent. No es ledger: deuda, pago, factura, comprobante y saldo pertenecen al Core Financiero. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 0. Declaración de propósito, autoridad y baseline

| **V1.0 — MÓDULO FULLSTACK ENTERPRISE —** EC-03 adopta literalmente el estándar visual y de ingeniería de EC-01 V1.1: Source of Truth explícito, RLS defense-in-depth, Aggregate Revision Contract, state machines físicas, idempotencia durable, outbox/inbox con lease, OperationStatus, UNKNOWN_EFFECT, OpenAPI/AsyncAPI ejecutables, Threat Model, Secure SDLC, zero-downtime y Developer Experience reproducible. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

EC-03 gobierna cómo PeopleU IA determina, explica y congela una condición comercial aplicable a una oferta de Educación Continua sin convertirse en sistema contable. El módulo permite publicar price books, modelar componentes de precio, activar promociones, operar códigos promocionales, administrar programas de becas o beneficios, referenciar convenios corporativos, producir cotizaciones inmutables y solicitar al Core Financiero la creación de efectos financieros mediante ChargeIntent.

La separación fundamental es PUBLIC PRICE ≠ NEGOTIATED PRICE ≠ QUOTED PRICE ≠ FINANCIAL POSTING. EC-03 calcula y evidencia la decisión comercial; Finanzas registra el hecho económico oficial. Esta frontera evita duplicar deuda, pago, factura, impuestos o saldo en la vertical académica.

| **CRITERIO DE ÉXITO —** Dos equipos Senior independientes deben obtener el mismo precio y las mismas razones para un mismo contexto, y poder reconstruir años después qué PriceBookVersion, PromotionVersion, ScholarshipAward, convenio, FX/policy snapshot y algoritmo de redondeo originaron una quote; ningún bug Backend debe cruzar tenants ni modificar una quote aceptada o receipt financiero. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 0.1 Jerarquía documental aplicable

| **Prioridad** | **Documento / artefacto**              | **Rol**                                                            |
|---------------|----------------------------------------|--------------------------------------------------------------------|
| 1             | AM-00 vigente                          | Constitución arquitectónica superior.                              |
| 2             | CT-00 vigente                          | Contrato maestro transversal.                                      |
| 3             | CT-01…CT-18 vigentes                   | Capacidades compartidas y fronteras.                               |
| 4             | EC-00 V1.1                             | Constitución funcional/arquitectónica de Educación Continua.       |
| 5             | EC-01 V1.1                             | Plantilla FullStack oficial y Source of Truth de diseño académico. |
| 6             | EC-02 V1.0                             | Source of Truth de Edition/Offering y ejecución operativa.         |
| 7             | EC-03 V1.0 (este documento)            | Especificación implementable de comercialización académica.        |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Implementación y evidencia alineadas al Word.                      |

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

## 0.3 Decisiones arquitectónicas EC03-DA

| **ID**      | **Decisión normativa**                                                                                                                                   |
|-------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|
| EC03-DA-001 | PRICE BOOK ≠ OFFERING ≠ QUOTE ≠ CHARGE ≠ PAYMENT. EC-03 posee price book/quote/charge intent; EC-02 posee Offering; Finanzas posee el hecho financiero.  |
| EC03-DA-002 | PUBLIC PRICE ≠ NEGOTIATED PRICE ≠ QUOTED PRICE ≠ FINANCIAL POSTING. Cada etapa conserva provenance y no se deriva retrospectivamente de “precio actual”. |
| EC03-DA-003 | PRICE BOOK DEFINITION ≠ PRICE BOOK VERSION. El business identity sobrevive; cada snapshot publicable es inmutable.                                       |
| EC03-DA-004 | OFFERING PRICE BINDING = VERSION PINNING. Una oferta fija una PriceBookVersion o regla contractual explícita; nunca “latest” para historia.              |
| EC03-DA-005 | PROMOTION CAMPAIGN ≠ PROMOTION VERSION ≠ PROMO CODE. Campaña, regla publicada y token tienen lifecycle distintos.                                        |
| EC03-DA-006 | PROMOTION ELIGIBILITY ≠ BENEFIT APPLICATION. Primero se determina elegibilidad; luego stacking/policy decide aplicación.                                 |
| EC03-DA-007 | STACKING ≠ SUMAR TODOS LOS DESCUENTOS. Orden, exclusiones, topes y prioridad provienen de policy versionada.                                             |
| EC03-DA-008 | SCHOLARSHIP PROGRAM ≠ SCHOLARSHIP VERSION ≠ SCHOLARSHIP AWARD ≠ PAYMENT WAIVER. Award es entitlement comercial; Finanzas registra efecto monetario.      |
| EC03-DA-009 | AGREEMENT BENEFIT ≠ CORPORATE AGREEMENT. EC-03 guarda binding comercial; EC-09/gestión contractual conserva el acuerdo.                                  |
| EC03-DA-010 | QUOTE = IMMUTABLE COMMERCIAL SNAPSHOT. Recalcular condiciones materiales produce REQUOTE/nueva quote; nunca reescribe la aceptada.                       |
| EC03-DA-011 | QUOTE LINE ≠ INVOICE LINE. Una línea comercial explica cálculo; la factura pertenece a Finanzas.                                                         |
| EC03-DA-012 | CHARGE INTENT ≠ DEBT. EC-03 solicita intención; solo un receipt financiero confirmado permite referenciar el efecto oficial.                             |
| EC03-DA-013 | FINANCIAL EFFECT RECEIPT ≠ PAYMENT RECEIPT. Prueba integración/efecto remoto, no acredita pago del cliente.                                              |
| EC03-DA-014 | EARLY BIRD ≠ IF FECHA \< X hardcodeado. Ventanas y thresholds son policies/PromotionVersion.                                                             |
| EC03-DA-015 | PROMO TOKEN ≠ PLAINTEXT SECRET. Tokens privados se almacenan por hash/HMAC y se muestran una sola vez cuando policy lo permita.                          |
| EC03-DA-016 | PROMO RESERVATION ≠ CONSUMPTION. Una reserva temporal protege cupo/beneficio; consumo ocurre con hecho confirmado según policy.                          |
| EC03-DA-017 | CORPORATE CLIENT ≠ PARTICIPANT. Beneficios corporativos referencian organización/acuerdo sin convertir empresa en estudiante.                            |
| EC03-DA-018 | PERSON ≠ COMMERCIAL SUBJECT. CT-04 conserva persona; EC-03 conserva referencias/purpose mínimo para pricing.                                             |
| EC03-DA-019 | POLICY REF = IMMUTABLE POLICY VERSION REF. Todo \*\_policy_ref debe reconstruirse históricamente.                                                        |
| EC03-DA-020 | MONEY = AMOUNT + CURRENCY. BigDecimal/numeric; prohibidos float/double para importes oficiales.                                                          |
| EC03-DA-021 | FX ≠ SILENT RECOMPUTE. Si se permite conversión, la quote pinnea fuente, tasa, asOf, rounding y receipt.                                                 |
| EC03-DA-022 | TENANT-AWARE FK ≠ TENANT ISOLATION. Toda tabla tenant-owned usa ENABLE + FORCE RLS; runtime no tiene BYPASSRLS.                                          |
| EC03-DA-023 | AGGREGATE REVISION ≠ ROOT ROW ONLY. Toda mutación de hijos de PriceBookVersion/PromotionVersion/ScholarshipVersion/Quote incrementa revisión del root.   |
| EC03-DA-024 | 202 ACCEPTED ≠ EFFECT CONFIRMED. Operaciones asíncronas devuelven operationId y OperationStatus.                                                         |
| EC03-DA-025 | UNKNOWN_EFFECT ≠ FAILED. Timeout tras comando financiero obliga reconciliation antes de retry.                                                           |
| EC03-DA-026 | OUTBOX PENDING ≠ CLAIMED. Dispatch multi-instancia usa ownership/lease/SKIP LOCKED.                                                                      |
| EC03-DA-027 | IDEMPOTENCY IN_PROGRESS ≠ FOREVER. Lease vencido se recupera gobernadamente.                                                                             |
| EC03-DA-028 | AI RECOMMENDATION ≠ PRICE DECISION. CT-12 puede sugerir campañas/precios; un actor/policy decide y se conserva provenance.                               |
| EC03-DA-029 | HTTP RUNTIME ROLE ≠ MIGRATOR ROLE ≠ TECHNICAL WORKER ROLE. Privilegios y credenciales separados.                                                         |
| EC03-DA-030 | BUSINESS KEY ≠ EDITABLE LABEL. Códigos de price book/campaña/beca se vuelven inmutables tras historia publicada.                                         |
| EC03-DA-031 | SCHEMA RELEASE ≠ APP RELEASE. Migraciones productivas siguen expand/contract y compatibilidad N/N-1.                                                     |
| EC03-DA-032 | OPENAPI/ASYNCAPI ≠ DOCUMENTATION ONLY. Generan clientes, contract tests y compatibility gates.                                                           |

## 0.4 Criterio de suficiencia FullStack y regla de plantilla

EC-03 se considera suficiente cuando Backend, Frontend, QA, DBA, Seguridad y Operaciones pueden implementar el mismo comportamiento observable sin inventar reglas de stacking, rounding, expiry, quote immutability, tenant isolation o reconciliation. Lo variable institucionalmente debe ser policy/version/ref; lo no variable debe quedar fijado por este contrato.

| **REGLA DE PLANTILLA —** EC-04…EC-12 deben conservar como mínimo: Source of Truth explícito, RLS defense-in-depth, Aggregate Revision Contract, state transition guards, durable idempotency, leased outbox, OperationStatus para 202/UNKNOWN_EFFECT, API paginada, Threat Model, Secure SDLC, expand/contract y bootstrap reproducible. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 1. Índice operativo del documento

- 2\. Resumen ejecutivo, problema, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Bounded Context y matriz Source of Truth

- 5\. Dependencias CT-01 a CT-18, cores y otros módulos

- 6\. Arquitectura funcional E2E y journeys

- 7\. Modelo de dominio: aggregates, entities, value objects y policies

- 8\. Máquinas de estado normativas

- 9\. Catálogo formal de reglas BR-EC03

- 10\. Casos de uso UC-EC03

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

EC-03 resuelve la variabilidad comercial propia de Educación Continua: múltiples ediciones al año, precios diferenciados por público/canal, early bird, promociones temporales, cupones, becas, beneficios corporativos y condiciones negociadas. Sin un bounded context específico, estas reglas terminan dispersas entre Frontend, planillas y Finanzas, produciendo precios no reproducibles, descuentos ad-hoc y auditoría débil.

El módulo crea un motor de decisión comercial gobernado y explicable. Una quote debe poder mostrar base price, componentes, ajustes, promociones evaluadas, beneficios aplicados/rechazados, moneda, impuestos informativos si el contrato los provee, FX si corresponde, policy versions y motivo de cada resultado. Aceptar una quote puede producir un ChargeIntent, pero EC-03 no registra deuda ni pago.

## 2.1 Incluido

- CommercialProfile institucional y parámetros de comercialización referenciados a CT-02.

- PriceBookDefinition y PriceBookVersion con publicación/versionado/inmutabilidad.

- PriceComponent: matrícula, tuition/course fee, materiales, certificación u otros componentes parametrizados.

- PriceRuleBinding para segmentación/contexto sin hardcodear reglas.

- OfferingPriceBinding para pinnear precio a Offering de EC-02.

- PromotionCampaign/PromotionVersion, condiciones, beneficios, ventanas, prioridades y stacking policy.

- PromoCodePool, tokens hash/HMAC, reserva, consumo, liberación, rate limits y antifraude.

- ScholarshipProgram/Version, criterios, awards, vigencia, cupo/presupuesto referencial y workflow.

- AgreementBenefitBinding para beneficios de convenios/corporativos sin duplicar contrato EC-09.

- Pricing preview y trace explicable.

- CommercialQuote inmutable, quote lines y adjustments.

- Requote/supersede sin reescribir historia.

- ChargeIntent y FinancialEffectReceipt con UNKNOWN_EFFECT/reconciliation.

- APIs, eventos, RLS, auditoría, observabilidad, QA, migración, IA asistiva y operación.

## 2.2 Fuera de alcance

- Crear ProgramVersion — EC-01.

- Crear ProgramEdition/Offering/cohorte — EC-02.

- Registrar prospecto/participante/inscripción — EC-04.

- Definir contrato corporativo completo — EC-09/gestión contractual; EC-03 solo referencia beneficio comercial aplicable.

- Crear deuda, cuenta por cobrar, pago, factura, nota de crédito, comprobante o saldo — Core Financiero.

- Mantener personas/usuarios — CT-04/IAM.

- Guardar PDFs o contratos firmados — CT-05.

- Implementar workflow/aprobaciones como motor local — CT-06.

- Implementar elegibilidad institucional genérica — CT-15; EC-03 aporta contexto comercial y consume evaluación cuando corresponda.

| **ANTI-SCOPE —** EC-03 no debe convertirse en “mini ERP financiero”. No existe tabla payment, invoice, receivable, ledger_entry o balance dentro del esquema ec03. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 3. Lenguaje ubicuo y semántica normativa

| **Término**             | **Definición normativa**                                                                                                     |
|-------------------------|------------------------------------------------------------------------------------------------------------------------------|
| CommercialProfile       | Configuración comercial institucional estable; referencia policies, moneda base y reglas de governance.                      |
| PriceBookDefinition     | Identidad estable de una lista/esquema de precios.                                                                           |
| PriceBookVersion        | Snapshot publicable e inmutable de precios/componentes/reglas para una vigencia.                                             |
| PriceComponent          | Componente monetario explicable que contribuye al precio base o condición económica.                                         |
| PriceRuleBinding        | Binding versionado a policy/segment/contexto que determina aplicabilidad de un componente.                                   |
| OfferingPriceBinding    | Pin de Offering EC-02 a PriceBookVersion y contexto comercial.                                                               |
| PromotionCampaign       | Identidad de una campaña promocional.                                                                                        |
| PromotionVersion        | Snapshot publicable de ventana, prioridad, stacking y reglas de una campaña.                                                 |
| PromotionCondition      | Condición tipada evaluable para considerar una promoción.                                                                    |
| PromotionBenefit        | Beneficio tipado: porcentaje, monto, fee waiver u otro contrato soportado.                                                   |
| PromoCodePool           | Conjunto gobernado de códigos/tokens de una promoción.                                                                       |
| PromoCode               | Token comercial; si es secreto se conserva hash/HMAC, no plaintext reutilizable.                                             |
| PromoCodeReservation    | Reserva temporal del derecho a consumir un código/beneficio.                                                                 |
| ScholarshipProgram      | Identidad estable de programa de beca/beneficio.                                                                             |
| ScholarshipVersion      | Snapshot versionado de criterios, cobertura, vigencia y límites.                                                             |
| ScholarshipAward        | Derecho comercial adjudicado a un subject/registration/org ref; no pago ni deuda.                                            |
| AgreementBenefitBinding | Beneficio comercial derivado de un convenio externo pinneado por ref/version.                                                |
| PricingContext          | Conjunto de facts permitidos usados para calcular precio: offering, fecha, canal, subject/org refs, currency, quantity, etc. |
| PricingTrace            | Explicación determinista de reglas evaluadas/aplicadas/rechazadas.                                                           |
| CommercialQuote         | Snapshot monetario inmutable ofrecido a un sujeto/contexto por un periodo.                                                   |
| QuoteLine               | Línea explicativa de precio antes/después de ajustes; no invoice line.                                                       |
| QuoteAdjustment         | Promoción/beca/convenio/override aplicado o rechazado con reason y provenance.                                               |
| ChargeIntent            | Comando idempotente hacia Finanzas para crear/actualizar efecto financiero según contrato.                                   |
| FinancialEffectReceipt  | Evidencia durable del resultado de integración financiera; no payment receipt.                                               |
| UNKNOWN_EFFECT          | No se sabe si el sistema remoto aplicó el efecto; exige reconcile antes de retry.                                            |
| Requote                 | Nueva quote derivada por expiración/cambio de contexto; no update de la quote anterior.                                      |
| Money                   | Amount decimal + currency code + rounding semantics; nunca float/double.                                                     |
| PolicyRef               | Referencia a una versión inmutable de policy de CT-02.                                                                       |
| EXT REF                 | Referencia cross-context sin FK física, validada por port/contract y evidencia.                                              |

# 4. Bounded Context y matriz Source of Truth

EC-03 posee la semántica de decisión comercial previa al ledger. Consume hechos externos por contrato y solo persiste referencias/snapshots mínimos necesarios para reproducir una quote. Un snapshot de contexto no transfiere ownership del dato externo.

| **Información**                       | **Source of Truth**  | **EC-03 almacena/referencia**    | **Regla**                                     |
|---------------------------------------|----------------------|----------------------------------|-----------------------------------------------|
| Tenant/sede/campus/scope              | CT-01                | tenant_id + scope refs           | tenant del auth context; RLS.                 |
| Catálogos/policies                    | CT-02                | policy refs/snapshots mínimos    | No hardcode de porcentajes, topes, vigencias. |
| Temporalidad institucional            | CT-03                | window refs/asOf cuando aplica   | Instantes UTC; calendarios globales fuera.    |
| Persona canónica                      | CT-04                | subject_ref mínimo               | No Person local.                              |
| Documentos/evidencias                 | CT-05                | document/evidence refs           | No blobs.                                     |
| Workflow/aprobaciones                 | CT-06                | workflow/task refs               | EC-03 valida dominio; CT-06 orquesta.         |
| Notificaciones                        | CT-07                | request/receipt refs             | Fallo post-commit no revierte quote.          |
| Localización                          | CT-08                | translation keys/locale          | Moneda ≠ locale.                              |
| Integración/eventos                   | CT-09                | outbox/inbox local               | At-least-once + dedup.                        |
| Auditoría/privacy                     | CT-10                | business audit metadata          | Purpose limitation/PII mínima.                |
| Analítica/BI                          | CT-11                | produce hechos/dataset refs      | Sin shadow BI.                                |
| IA                                    | CT-12                | run/eval refs                    | Recommendation ≠ decision.                    |
| Scheduling/recursos                   | CT-13/14             | No                               | No pertenecen EC-03.                          |
| Elegibilidad transversal              | CT-15                | eligibility refs/result receipts | No motor genérico local.                      |
| Migración/DQ                          | CT-16                | lineage/promotion receipts       | No INSERT directo.                            |
| Continuidad                           | CT-17                | runbook refs                     | Degraded/fail-safe.                           |
| Ecosistema externo                    | CT-18                | gateway refs cuando aplica       | No vendor coupling directo.                   |
| Programa/versiones                    | EC-01                | program_version_ref              | Diseño académico, no precio.                  |
| Edition/Offering                      | EC-02                | edition_ref/offering_ref         | Offering es EXT REF.                          |
| Registro/participante                 | EC-04                | registration_ref/participant ref | No enrollment local.                          |
| Convenio corporativo                  | EC-09/contract owner | agreement_ref/version            | EC-03 solo binding comercial.                 |
| PriceBook/Promotion/Scholarship/Quote | EC-03                | Sí                               | Source of Truth local.                        |
| Deuda/pago/factura/saldo              | Core Financiero      | No; financial refs/receipts      | ACADEMIC SYSTEM ≠ FINANCIAL LEDGER.           |

# 5. Dependencias CT-01 a CT-18, cores y otros módulos

| **Dependencia** | **Responsabilidad**    | **Contrato EC-03**                            | **Frontera/fallo**                |
|-----------------|------------------------|-----------------------------------------------|-----------------------------------|
| CT-01           | Scope institucional    | scope refs; tenant validation                 | Fail-closed en publish/override.  |
| CT-02           | Policies/catálogos     | rounding, stacking, limits, currencies        | Cache versionado.                 |
| CT-03           | Tiempo transversal     | windows/asOf                                  | No calendar local.                |
| CT-04           | Persona                | subject refs                                  | PII mínima.                       |
| CT-05           | Evidence/documents     | approval/quote export refs                    | No blobs.                         |
| CT-06           | Workflow               | review/approve/override/scholarship           | No motor local.                   |
| CT-07           | Notifications          | quote/promo notifications                     | Post-commit.                      |
| CT-08           | i18n                   | localized labels                              | Canonical + overlays.             |
| CT-09           | Integration governance | events/contracts                              | Outbox/inbox.                     |
| CT-10           | Security/audit/privacy | reason/assurance/evidence                     | Critical audit.                   |
| CT-11           | Analytics              | commercial facts                              | Event-fed datasets.               |
| CT-12           | IA                     | recommendation/run refs                       | Human decision.                   |
| CT-13           | Scheduling             | N/A                                           | No dependency.                    |
| CT-14           | Resources              | N/A                                           | No dependency.                    |
| CT-15           | Eligibility            | rule eval where needed                        | Decision receipt, no duplication. |
| CT-16           | Migration/DQ           | staging/dry-run/promotion                     | No direct INSERT.                 |
| CT-17           | Continuity             | RTO/RPO/runbooks                              | Quote/reconcile policies.         |
| CT-18           | External ecosystem     | PSP/catalog bridges only via governed adapter | No direct vendor coupling.        |
| IAM             | Auth/MFA/roles         | actor + assurance                             | Step-up for publish/override.     |
| EC-01           | Academic design        | program_version_ref                           | Read only.                        |
| EC-02           | Offering               | offering_ref/edition_ref                      | Read only; price binding local.   |
| EC-04           | Registration           | registration_ref for quote/award              | No enrollment ownership.          |
| EC-09           | Corporate agreement    | agreement_ref/version                         | No contract shadow.               |
| Finanzas        | Ledger/economic facts  | ChargeIntent + receipt/ref                    | UNKNOWN_EFFECT reconciliation.    |

# 6. Arquitectura funcional E2E y journeys

<img src="media/image1.png" style="width:6.6in;height:4.01065in" />

Figura 1 — EC-03 dentro de la vertical y contratos

| **Journey**                 | **Flujo E2E**                                                                                                                                                       |
|-----------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| J-EC03-01 Price Book        | Crear PriceBookDefinition → PriceBookVersion DRAFT → componentes/reglas → validate → CT-06 review → APPROVED → SCHEDULED/PUBLISHED → receipt + outbox.              |
| J-EC03-02 Offering bind     | EC-02 Offering válido → seleccionar PriceBookVersion publicada/aplicable → crear binding con contexto → downstream pricing pinneado.                                |
| J-EC03-03 Quote individual  | Recibir PricingContext → resolver base price → evaluar promos/becas/convenios → stacking/rounding → trace → persistir CommercialQuote + lines/adjustments → expiry. |
| J-EC03-04 Promo code        | Usuario entrega token → hash/HMAC lookup → eligibility + rate/usage → reservar con lease → quote → consumir al evento definido o liberar por expiración.            |
| J-EC03-05 Scholarship       | Programa/version publicada → solicitud/eligibility externa → CT-06 decisión → ScholarshipAward → quote lo consume con policy versionada.                            |
| J-EC03-06 Convenio          | agreement_ref/version EC-09 → validar vigencia/scope → AgreementBenefitBinding → quote conserva provenance del beneficio.                                           |
| J-EC03-07 Charge            | Quote ACCEPTED → ChargeIntent idempotente → Finanzas → SUCCESS receipt o UNKNOWN_EFFECT → reconcile → solo luego retry/estado terminal.                             |
| J-EC03-08 Requote           | Quote expira/cambia contexto → no editar → crear nueva quote con supersedes_quote_id y nuevo trace.                                                                 |
| J-EC03-09 Dependencia caída | CT-02/15/Finanzas unavailable → distinguir STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT → fail-closed para decisiones críticas.                                         |
| J-EC03-10 IA asistiva       | Analista pide recomendación CT-12 → suggestion con provenance → humano acepta/edita → command normal; IA nunca publica/otorga beca/aplica override autónomo.        |

# 7. Modelo de dominio: Aggregates, Entities, Value Objects, Policies y Domain Services

<img src="media/image2.png" style="width:6.65in;height:3.95789in" />

Figura 2 — Modelo de dominio lógico EC-03

## 7.1 Aggregate Root — CommercialProfile

Identidad de gobierno comercial por tenant/scope. Conserva moneda base, referencias de rounding/stacking/approval y defaults autorizados. No guarda cada precio ni reemplaza CT-02.

## 7.2 Aggregate — PriceBookDefinition / PriceBookVersion

PriceBookDefinition es identidad estable. PriceBookVersion agrega PriceComponent, PriceRuleBinding y ventanas de aplicabilidad. El snapshot SCHEDULED/PUBLISHED es inmutable y las ofertas pinnean una versión concreta.

## 7.3 Aggregate — PromotionCampaign / PromotionVersion

Campaign conserva identidad/lifecycle; PromotionVersion congela ventana, prioridad, stacking group, conditions y benefits. PromoCodePool y PromoCode quedan subordinados a una versión gobernada.

## 7.4 Aggregate — ScholarshipProgram / ScholarshipVersion

Modela programa de beca/beneficio sin convertirse en fondo contable. La versión define criterios/cobertura/límites; ScholarshipAward representa adjudicación comercial a un target tipado.

## 7.5 Aggregate Root — CommercialQuote

Snapshot comercial inmutable. Agrega lines y adjustments, content/context hash, expiry, trace refs, FX/policy snapshots y totales. ACCEPTED/EXPIRED/SUPERSEDED nunca se editan; requote crea otra identidad.

## 7.6 Aggregate — ChargeIntent

Representa la intención idempotente de producir un efecto en Finanzas a partir de una quote aceptada. Su lifecycle distingue PENDING/IN_PROGRESS/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED y conserva financial receipt.

## 7.7 Value Objects

| **Value Object** | **Semántica**                                                             |
|------------------|---------------------------------------------------------------------------|
| Money            | amount numeric + currency_code ISO-like + rounding policy/version.        |
| PriceContextHash | Hash canónico del contexto comercial utilizado para reproducir una quote. |
| Percentage       | Decimal acotado por policy; no float.                                     |
| ValidityWindow   | start/end con timezone/UTC semantics explícita.                           |
| PromoTokenDigest | hash/HMAC + key version; no plaintext durable.                            |
| BenefitTarget    | Union tipada para subject/registration/org/agreement según contrato.      |
| PolicyRef        | policy_id + immutable version/effective context.                          |
| ExternalRef      | opaque UUID/ref + authority; sin FK cross-context.                        |
| IdempotencyKey   | Key + request_hash + operation scope; replay seguro.                      |
| OperationId      | Identificador durable de comando asíncrono/reconciliation.                |

## 7.8 Domain Policies

- PricePublicationPolicy — precondiciones para publicar una versión de precio.

- PromotionStackingPolicy — prioridad, exclusiones, cap y orden de cálculo.

- RoundingPolicy — escala, modo y punto del pipeline donde redondear.

- QuoteValidityPolicy — duración y expiración.

- PromoCodeUsagePolicy — límite por token/subject/offering/campaign y reserva.

- ScholarshipAwardPolicy — aprobación/SoD/coverage/capacity.

- AgreementBenefitPolicy — valida convenio/version/scope y precedence.

- OverridePolicy — quién puede aplicar ajuste manual, topes, step-up y evidencia.

- ChargeIntentPolicy — cuándo una quote aceptada puede convertirse en intención financiera.

- FXPolicy — fuentes permitidas, freshness, rounding y pinning.

## 7.9 Domain Services

- PricingEngine — calcula determinísticamente PriceResult + PricingTrace.

- PromotionEvaluationService — evalúa conditions y stacking sin side effects.

- QuoteFactory — materializa snapshot inmutable de resultado y provenance.

- RequoteService — deriva nueva quote preservando lineage.

- CommercialImpactService — simula impacto de nueva PriceBook/PromotionVersion sobre offerings futuras.

- FinancialReconciliationService — consulta Finance para resolver UNKNOWN_EFFECT antes de retry.

- PromoReservationService — reserva/consume/libera tokens bajo locking/lease.

## 7.10 Aggregate Revision Contract — patrón obligatorio

PriceBookVersion, PromotionVersion, ScholarshipVersion y CommercialQuote exponen una revisión observable del aggregate completo. Toda mutación de hijo editable bloquea/revalida root, compara If-Match, ejecuta el método de intención y bumpa root.version en la misma transacción. Para quotes solo estados editables permiten mutación; después de ISSUED/ACCEPTED el contenido se congela.

| **Paso** | **Contrato**                                                    |
|----------|-----------------------------------------------------------------|
| 1        | Resolver tenant desde Security/TenantContext; nunca desde body. |
| 2        | Abrir transacción y SET LOCAL peopleu.tenant_id.                |
| 3        | Cargar/lock root y comparar If-Match.                           |
| 4        | Ejecutar command de intención; no repository child directo.     |
| 5        | Persistir hijos y bump root.version atómicamente.               |
| 6        | Audit/outbox/idempotency según aplique; commit.                 |
| 7        | Responder ETag nuevo o 412 sin side effects.                    |

| **PRUEBA NO NEGOCIABLE —** Dos usuarios parten de ETag 7. A cambia un PriceComponent y root pasa a 8. B intenta agregar PriceRuleBinding con If-Match 7: debe recibir 412 aunque toque otra tabla hija. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 8. Máquinas de estado normativas

<img src="media/image3.png" style="width:6.6in;height:2.84396in" />

Figura 3 — Estado versionado normativo

| **Aggregate**       | **Estados / transiciones**                                                        | **Invariante**                                   |
|---------------------|-----------------------------------------------------------------------------------|--------------------------------------------------|
| PriceBookDefinition | DRAFT → ACTIVE → SUSPENDED → RETIRED                                              | No borra versiones históricas.                   |
| PriceBookVersion    | DRAFT → IN_REVIEW → APPROVED → SCHEDULED/PUBLISHED → SUPERSEDED; VOID excepcional | SCHEDULED/PUBLISHED immutable.                   |
| PromotionCampaign   | DRAFT → ACTIVE → SUSPENDED → RETIRED                                              | Identidad estable.                               |
| PromotionVersion    | DRAFT → IN_REVIEW → APPROVED → SCHEDULED/PUBLISHED → SUPERSEDED; VOID             | Ventana/beneficios congelados.                   |
| PromoCode           | AVAILABLE → RESERVED → CONSUMED; BLOCKED/EXPIRED                                  | Reserva no equivale consumo.                     |
| ScholarshipProgram  | DRAFT → ACTIVE → SUSPENDED → RETIRED                                              | No elimina awards.                               |
| ScholarshipVersion  | DRAFT → IN_REVIEW → APPROVED → SCHEDULED/PUBLISHED → SUPERSEDED; VOID             | Snapshot inmutable.                              |
| ScholarshipAward    | PENDING → APPROVED/REJECTED → ACTIVE → CONSUMED/EXPIRED/REVOKED                   | Revocación con reason/evidence; no hard-delete.  |
| CommercialQuote     | DRAFT → ISSUED → ACCEPTED/REJECTED/EXPIRED/SUPERSEDED/VOID                        | ISSUED+ contenido inmutable; requote crea nueva. |
| ChargeIntent        | PENDING → IN_PROGRESS → SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED                 | UNKNOWN_EFFECT requiere reconcile.               |

| **REGLA DE ESTADO —** Nunca implementar publish, accept quote, consume promo, revoke award o confirm financial effect como PATCH de status. Son casos de uso transaccionales con autorización, idempotencia/concurrencia, evidencia y eventos. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 9. Catálogo formal de reglas BR-EC03

| **ID**      | **Nombre**                   | **Regla implementable/verificable**                                                                  |
|-------------|------------------------------|------------------------------------------------------------------------------------------------------|
| BR-EC03-001 | Tenant obligatorio           | Toda tabla tenant-owned usa tenant_id derivado de auth context; body no elige tenant.                |
| BR-EC03-002 | RLS obligatorio              | ENABLE+FORCE RLS en tablas tenant-owned; runtime sin BYPASSRLS.                                      |
| BR-EC03-003 | No FK cross-context          | Refs CT/EC/Finanzas son EXT REF; solo FK internas ec03.                                              |
| BR-EC03-004 | Money decimal                | Importes usan numeric/BigDecimal; float/double prohibidos.                                           |
| BR-EC03-005 | Currency explícita           | Todo amount oficial tiene currency_code coherente con el aggregate.                                  |
| BR-EC03-006 | Policy versionada            | Todo \*\_policy_ref resuelve versión inmutable reconstruible.                                        |
| BR-EC03-007 | Business keys estables       | Códigos de PriceBook/Campaign/Scholarship no cambian tras historia publicada.                        |
| BR-EC03-008 | Version positiva             | version_no \>=1 y único dentro de Definition.                                                        |
| BR-EC03-009 | Lineage same-definition      | previous/superseded ref pertenece a misma Definition y tenant.                                       |
| BR-EC03-010 | Lineage monotónico           | previous.version_no \< current \< superseding; self ref prohibida.                                   |
| BR-EC03-011 | Snapshot publicado inmutable | SCHEDULED/PUBLISHED/SUPERSEDED no modifica contenido comercial.                                      |
| BR-EC03-012 | Una publicada vigente        | Solo una PUBLISHED por Definition; activación supersede atómicamente cuando el modelo lo requiera.   |
| BR-EC03-013 | Vigencia coherente           | valid_to \> valid_from cuando ambos existan.                                                         |
| BR-EC03-014 | Offering pinneado            | OfferingPriceBinding referencia PriceBookVersion concreta, no latest.                                |
| BR-EC03-015 | Offering tenant/scope        | Binding solo si offering_ref está autorizado para tenant/scope.                                      |
| BR-EC03-016 | Componente positivo base     | PriceComponent base amount \>=0; descuentos no se modelan como montos negativos opacos.              |
| BR-EC03-017 | Componente code único        | component_code único por PriceBookVersion.                                                           |
| BR-EC03-018 | Component sequence           | sequence_no positivo y estable por snapshot.                                                         |
| BR-EC03-019 | Rule binding resoluble       | eligibility/pricing rule refs deben resolverse fail-closed al publish.                               |
| BR-EC03-020 | Promotion window             | end_at \> start_at y se evalúa en UTC con timezone de presentación separada.                         |
| BR-EC03-021 | Promotion priority           | priority es entero acotado; empate se resuelve determinísticamente por policy.                       |
| BR-EC03-022 | Stacking policy              | Combinabilidad no se infiere por UI; usa stacking_policy_ref/version.                                |
| BR-EC03-023 | Benefit tipado               | Cada PromotionBenefit cumple campos requeridos por benefit_type.                                     |
| BR-EC03-024 | Percent acotado              | Porcentaje 0..100 o límite policy más estricto.                                                      |
| BR-EC03-025 | Amount benefit currency      | Beneficio monto debe tener currency compatible o regla FX explícita.                                 |
| BR-EC03-026 | Cap por quote                | Descuento no hace total final negativo salvo política/credit mechanism externo explícito.            |
| BR-EC03-027 | Early bird versionado        | Ventana early bird vive en PromotionVersion/condition, no hardcode.                                  |
| BR-EC03-028 | Promo token secreto          | Token privado se conserva digest, nunca plaintext durable.                                           |
| BR-EC03-029 | Promo digest único           | Digest único por pool/tenant; no revela token en logs.                                               |
| BR-EC03-030 | Promo reservation lease      | RESERVED tiene expires_at; lease vencido es liberable/recoverable.                                   |
| BR-EC03-031 | Promo consume idempotente    | Consumir misma reserva con misma key devuelve mismo resultado; no duplica usage.                     |
| BR-EC03-032 | Promo usage limit            | Límites por code/subject/offering/campaign aplican atomic counters/locking.                          |
| BR-EC03-033 | Promo brute-force            | Rate limit y detección de abuso; reason codes no filtran existencia innecesaria.                     |
| BR-EC03-034 | Scholarship target tipado    | Award exige target_type y exactamente refs compatibles.                                              |
| BR-EC03-035 | Scholarship workflow         | Award que supera threshold requiere CT-06/SoD/step-up según policy.                                  |
| BR-EC03-036 | Scholarship coverage         | Cobertura \<= policy cap y nunca se interpreta como pago.                                            |
| BR-EC03-037 | Scholarship history          | Revoke/expire no borra award ni quotes previas.                                                      |
| BR-EC03-038 | Agreement pinned             | Benefit binding guarda agreement_ref + version/receipt; no latest.                                   |
| BR-EC03-039 | Agreement scope              | No aplicar beneficio de otra organización/scope sin autorización.                                    |
| BR-EC03-040 | Quote context hash           | Quote persiste context_hash canónico para reproducibilidad.                                          |
| BR-EC03-041 | Quote immutable              | ISSUED/ACCEPTED/EXPIRED/SUPERSEDED/VOID no modifica lines/adjustments.                               |
| BR-EC03-042 | Quote totals                 | base + adjustments = total con rounding policy; DB/domain impiden incoherencia.                      |
| BR-EC03-043 | Quote expiry                 | expires_at \> issued_at; accept después de expiry produce 422.                                       |
| BR-EC03-044 | Quote currency               | Todas quote lines compatibles con currency o incluyen FX evidence.                                   |
| BR-EC03-045 | Adjustment provenance        | Cada ajuste identifica source_type/ref/version, applied flag, reason y amount.                       |
| BR-EC03-046 | Rejected adjustment visible  | Promoción evaluada y rechazada puede conservarse en trace sin fingir descuento cero aplicado.        |
| BR-EC03-047 | Requote lineage              | Nueva quote conserva supersedes_quote_id y no modifica anterior.                                     |
| BR-EC03-048 | Accept idempotente           | Quote accept usa Idempotency-Key; same key/same payload devuelve mismo ChargeIntent.                 |
| BR-EC03-049 | Charge from accepted quote   | Solo ACCEPTED puede originar ChargeIntent salvo contrato explícito.                                  |
| BR-EC03-050 | Charge no ledger             | EC-03 no crea deuda/factura/saldo local.                                                             |
| BR-EC03-051 | Finance receipt              | SUCCEEDED requiere financial_effect_ref/receipt confirmado.                                          |
| BR-EC03-052 | UNKNOWN_EFFECT               | Timeout tras posible efecto remoto pasa a UNKNOWN_EFFECT; no retry ciego.                            |
| BR-EC03-053 | Reconcile first              | UNKNOWN_EFFECT consulta status/receipt remoto antes de reenviar comando.                             |
| BR-EC03-054 | Idempotency conflict         | Same key con payload distinto → 409 IDEMPOTENCY_KEY_REUSED.                                          |
| BR-EC03-055 | Idempotency lease            | IN_PROGRESS tiene owner/lease/recovery.                                                              |
| BR-EC03-056 | Outbox atomic                | Eventos críticos se guardan en misma transacción que estado local.                                   |
| BR-EC03-057 | Outbox claiming              | FOR UPDATE SKIP LOCKED o lease probado para multi-instancia.                                         |
| BR-EC03-058 | Inbox dedup                  | message_id/event_id único por consumidor/tenant.                                                     |
| BR-EC03-059 | At-least-once                | No prometer exactly-once distribuido; usar idempotency + reconcile.                                  |
| BR-EC03-060 | ETag obligatorio             | Mutaciones de aggregates editables exigen If-Match; mismatch → 412.                                  |
| BR-EC03-061 | Child bumps root             | Mutar componente/condition/benefit/criterion/quote line editable incrementa root.version.            |
| BR-EC03-062 | No last write wins           | Conflictos no se sobreescriben silenciosamente.                                                      |
| BR-EC03-063 | 202 OperationStatus          | Toda respuesta 202 incluye operationId hasta terminal/reconcile.                                     |
| BR-EC03-064 | UI state explícito           | NO_DATA ≠ ZERO ≠ STALE ≠ PARTIAL ≠ UNAVAILABLE ≠ UNKNOWN_EFFECT.                                     |
| BR-EC03-065 | Fail closed critical         | Policy/eligibility/financial dependency crítica UNKNOWN/UNAVAILABLE no se interpreta favorable.      |
| BR-EC03-066 | Audit crítico                | Publish/override/award/accept/charge/revoke registra actor/scope/reason/policy/evidence/correlation. |
| BR-EC03-067 | PII minimization             | EC-03 persiste refs, no perfil personal innecesario.                                                 |
| BR-EC03-068 | No blobs                     | PDF/contratos/evidencia binaria en CT-05.                                                            |
| BR-EC03-069 | IA provenance                | Sugerencia IA guarda run/model/template/eval/grounding/confidence/reviewer outcome.                  |
| BR-EC03-070 | IA no decide                 | IA no publica precios, concede becas, aplica override ni confirma charge.                            |
| BR-EC03-071 | UTC                          | Instantes oficiales timestamptz UTC; presentation timezone separada.                                 |
| BR-EC03-072 | No hard delete histórico     | Versiones publicadas, quotes, awards y receipts no se hard-delete por API ordinaria.                 |
| BR-EC03-073 | Receipt append-only          | Publication/Financial receipts prohíben UPDATE/DELETE.                                               |
| BR-EC03-074 | Canonical hash               | Hash declara algoritmo y canonical schema version.                                                   |
| BR-EC03-075 | FX pinned                    | Quote con FX guarda source_ref, rate, as_of, pair y rounding; no recalc silencioso.                  |
| BR-EC03-076 | FX freshness                 | Rate debe cumplir max age policy al emitir quote.                                                    |
| BR-EC03-077 | Override controlado          | Manual override exige role/ABAC, reason, threshold, evidence y step-up según policy.                 |
| BR-EC03-078 | Override no borra base       | Quote conserva base y adjustment; nunca reemplaza precio base sin provenance.                        |
| BR-EC03-079 | Price preview read-only      | Preview no crea quote ni reserva beneficio salvo comando explícito.                                  |
| BR-EC03-080 | Quote issuance side effect   | Emitir quote persiste snapshot/trace y puede reservar promo según policy.                            |
| BR-EC03-081 | Reservation release          | Expire/reject/cancel libera reservations según política e idempotencia.                              |
| BR-EC03-082 | Budget reference not ledger  | Cap de scholarship/promo puede ser control comercial, no saldo contable oficial.                     |
| BR-EC03-083 | Commercial profile scope     | Un tenant/scope no puede heredar profile de otro tenant.                                             |
| BR-EC03-084 | Localization                 | Labels localizados no cambian identidad/version comercial.                                           |
| BR-EC03-085 | Pagination bounded           | Colecciones API tienen pageSize máximo, sort estable y filtros.                                      |
| BR-EC03-086 | PATCH limitado               | PATCH solo metadata escalar editable; transiciones/comandos críticos usan endpoints de intención.    |
| BR-EC03-087 | OpenAPI único                | Frontend consume client/DTO generado; no contratos manuales divergentes.                             |
| BR-EC03-088 | ProblemDetail                | Errores usan RFC Problem Details + reason codes estables.                                            |
| BR-EC03-089 | Secure SDLC                  | High/Critical SAST/SCA/secret/container findings bloquean release salvo excepción formal.            |
| BR-EC03-090 | Capacity budgets             | Máximos de components/conditions/codes/batch/payload parametrizados.                                 |
| BR-EC03-091 | Expand/contract              | Flyway productivo mantiene compatibilidad N/N-1.                                                     |
| BR-EC03-092 | Runtime DB role              | Runtime no posee tablas ni usa superuser/BYPASSRLS.                                                  |
| BR-EC03-093 | Migration governed           | Legacy entra por CT-16 Extract→Normalize→Map→Validate→Dry-run→Promote→Receipt→Reconcile.             |
| BR-EC03-094 | Contract compatibility       | OpenAPI/AsyncAPI breaking changes requieren version/compatibility gate.                              |
| BR-EC03-095 | Financial replay safety      | ChargeIntent incluye stable external id/idempotency contract aceptado por Finanzas.                  |
| BR-EC03-096 | Payment not inferred         | Estado financial effect no se interpreta como pago del participante.                                 |
| BR-EC03-097 | Tax not invented             | EC-03 no calcula impuesto oficial salvo servicio/contract del Core; lo muestra como external fact.   |
| BR-EC03-098 | Promo code export            | Export masivo exige purpose, encryption, audit y policy; nunca logs/analytics plaintext.             |
| BR-EC03-099 | Scholarship privacy          | Motivos sensibles se minimizan; analytics usa categorías/pseudonymization cuando corresponda.        |
| BR-EC03-100 | Commercial explainability    | Toda quote puede producir PricingTrace legible por operador y machine-readable.                      |
| BR-EC03-101 | Deterministic ordering       | Rules/adjustments se aplican con orden totalmente definido para igual input/version.                 |
| BR-EC03-102 | Rounding once per policy     | No redondeos dispersos Frontend/Backend; punto/escala/modo definidos y auditables.                   |
| BR-EC03-103 | Frontend not calculator      | UI puede preview visual, pero precio autoritativo siempre proviene Backend.                          |
| BR-EC03-104 | Mobile not admin             | Mobile no publica price books, aprueba becas ni aplica overrides críticos.                           |
| BR-EC03-105 | Evidence reconstructible     | Toda decisión material reconstruible con version refs, hashes, trace, actor y receipts.              |

# 10. Casos de uso UC-EC03

| **ID**      | **Caso de uso**                          | **Actor primario**            |
|-------------|------------------------------------------|-------------------------------|
| UC-EC03-001 | Crear CommercialProfile                  | Commercial Governance         |
| UC-EC03-002 | Modificar CommercialProfile              | Commercial Governance         |
| UC-EC03-003 | Crear PriceBookDefinition                | Pricing Manager               |
| UC-EC03-004 | Crear PriceBookVersion                   | Pricing Manager               |
| UC-EC03-005 | Clonar PriceBookVersion                  | Pricing Manager               |
| UC-EC03-006 | Gestionar PriceComponents                | Pricing Analyst               |
| UC-EC03-007 | Gestionar PriceRuleBindings              | Pricing Analyst               |
| UC-EC03-008 | Validar PriceBookVersion                 | Pricing Analyst               |
| UC-EC03-009 | Solicitar revisión PriceBook             | Pricing Manager               |
| UC-EC03-010 | Aprobar/rechazar PriceBook               | Commercial Approver           |
| UC-EC03-011 | Programar PriceBookVersion               | Commercial Publisher          |
| UC-EC03-012 | Publicar PriceBookVersion                | Commercial Publisher          |
| UC-EC03-013 | Superseder/void PriceBookVersion         | Commercial Governance         |
| UC-EC03-014 | Vincular PriceBookVersion a Offering     | Commercial Operator           |
| UC-EC03-015 | Consultar precio base offering           | EC-04/Staff                   |
| UC-EC03-016 | Crear PromotionCampaign                  | Campaign Manager              |
| UC-EC03-017 | Crear PromotionVersion                   | Campaign Manager              |
| UC-EC03-018 | Gestionar PromotionConditions            | Campaign Analyst              |
| UC-EC03-019 | Gestionar PromotionBenefits              | Campaign Analyst              |
| UC-EC03-020 | Validar PromotionVersion                 | Campaign Analyst              |
| UC-EC03-021 | Publicar PromotionVersion                | Campaign Publisher            |
| UC-EC03-022 | Crear PromoCodePool                      | Campaign Operator             |
| UC-EC03-023 | Generar/importar promo codes             | Campaign Operator             |
| UC-EC03-024 | Validar promo code                       | Participant/Staff             |
| UC-EC03-025 | Reservar promo code                      | EC-04/Participant             |
| UC-EC03-026 | Consumir promo code                      | System                        |
| UC-EC03-027 | Liberar reserva promo                    | System/Ops                    |
| UC-EC03-028 | Bloquear/expirar promo code              | Campaign Operator             |
| UC-EC03-029 | Crear ScholarshipProgram                 | Scholarship Manager           |
| UC-EC03-030 | Crear ScholarshipVersion                 | Scholarship Manager           |
| UC-EC03-031 | Gestionar criterios de beca              | Scholarship Analyst           |
| UC-EC03-032 | Publicar ScholarshipVersion              | Scholarship Publisher         |
| UC-EC03-033 | Crear solicitud/award pendiente          | Scholarship Desk              |
| UC-EC03-034 | Aprobar/rechazar ScholarshipAward        | Scholarship Approver          |
| UC-EC03-035 | Activar/revocar/expirar ScholarshipAward | Scholarship Governance        |
| UC-EC03-036 | Vincular beneficio de convenio           | Corporate Commercial Operator |
| UC-EC03-037 | Validar agreement benefit                | System                        |
| UC-EC03-038 | Calcular pricing preview                 | Staff/Participant             |
| UC-EC03-039 | Emitir CommercialQuote                   | EC-04/Staff                   |
| UC-EC03-040 | Consultar PricingTrace                   | Staff/Auditor                 |
| UC-EC03-041 | Aplicar promotion a quote                | Pricing Engine                |
| UC-EC03-042 | Aplicar scholarship a quote              | Pricing Engine                |
| UC-EC03-043 | Aplicar agreement benefit a quote        | Pricing Engine                |
| UC-EC03-044 | Aplicar override autorizado              | Commercial Supervisor         |
| UC-EC03-045 | Emitir requote                           | Staff/System                  |
| UC-EC03-046 | Aceptar quote                            | Participant/Staff             |
| UC-EC03-047 | Rechazar quote                           | Participant/Staff             |
| UC-EC03-048 | Expirar quote                            | System                        |
| UC-EC03-049 | Crear ChargeIntent                       | Application Service           |
| UC-EC03-050 | Enviar ChargeIntent a Finanzas           | Finance Adapter               |
| UC-EC03-051 | Consultar FinancialEffect                | System/Ops                    |
| UC-EC03-052 | Reconciliar UNKNOWN_EFFECT               | Ops/System                    |
| UC-EC03-053 | Reintentar efecto confirmado no aplicado | Ops/System                    |
| UC-EC03-054 | Consultar OperationStatus                | Frontend/Ops                  |
| UC-EC03-055 | Solicitar asistencia IA                  | Pricing Analyst               |
| UC-EC03-056 | Aceptar/rechazar sugerencia IA           | Pricing Analyst               |
| UC-EC03-057 | Simular impacto nueva versión            | Pricing Manager               |
| UC-EC03-058 | Importar price books legacy dry-run      | Data Steward                  |
| UC-EC03-059 | Promover lote migrado                    | Data Steward                  |
| UC-EC03-060 | Exportar commercial evidence pack        | Auditor                       |
| UC-EC03-061 | Consultar audit/lineage                  | Auditor                       |
| UC-EC03-062 | Rotar clave HMAC promo codes             | Security/Ops                  |
| UC-EC03-063 | Validar aislamiento RLS                  | Security/QA                   |
| UC-EC03-064 | Reprocesar outbox/inbox                  | Ops                           |

## 10.1 Casos críticos desarrollados

### UC-EC03-012 — Publicar PriceBookVersion

| **Aspecto**                   | **Detalle**                                                                                               |
|-------------------------------|-----------------------------------------------------------------------------------------------------------|
| Actor                         | Commercial Publisher                                                                                      |
| Trigger                       | Versión aprobada y lista                                                                                  |
| Precondiciones / autorización | APPROVED/SCHEDULED; step-up; validations PASS; CT refs resolubles                                         |
| Happy Path                    | Lock aggregate → revalidar hash/context → transición → publication receipt append-only → outbox → commit. |
| Alternativas / errores        | Dependencia crítica unavailable=503; conflicto de versión=412; publication conflict=409.                  |
| Idempotencia                  | Idempotency-Key durable.                                                                                  |
| Concurrencia                  | If-Match + lock/unique publication invariant.                                                             |
| Auditoría / side effects      | Audit + policy snapshot + evidence pack.                                                                  |
| Postcondición                 | Snapshot publicado e inmutable.                                                                           |

### UC-EC03-025 — Reservar promo code

| **Aspecto**                   | **Detalle**                                                                                                  |
|-------------------------------|--------------------------------------------------------------------------------------------------------------|
| Actor                         | Participant/EC-04                                                                                            |
| Trigger                       | Token ingresado al cotizar                                                                                   |
| Precondiciones / autorización | Promo activa, code válido, rate/usage bajo límite                                                            |
| Happy Path                    | Digest lookup → eligibility → lock code/counter → crear reservation con expires_at → retorno reservationRef. |
| Alternativas / errores        | Código inválido/blocked/expired=422 genérico; contention=409; abuse=429.                                     |
| Idempotencia                  | Idempotency-Key por quote/session.                                                                           |
| Concurrencia                  | Row lock/advisory + unique active reservation según policy.                                                  |
| Auditoría / side effects      | Audit minimizado + security metrics.                                                                         |
| Postcondición                 | Reserva durable; todavía no consumida.                                                                       |

### UC-EC03-034 — Aprobar ScholarshipAward

| **Aspecto**                   | **Detalle**                                                       |
|-------------------------------|-------------------------------------------------------------------|
| Actor                         | Scholarship Approver                                              |
| Trigger                       | Workflow CT-06 resuelto                                           |
| Precondiciones / autorización | PENDING; SoD; target resoluble; budget/cap policy válido          |
| Happy Path                    | Validar snapshot → APPROVED/ACTIVE según policy → receipt/outbox. |
| Alternativas / errores        | Hash cambió=409; dependency unavailable=503; SoD=403.             |
| Idempotencia                  | Inbox dedup/workflow messageId.                                   |
| Concurrencia                  | Root version + state guard.                                       |
| Auditoría / side effects      | High-assurance audit/evidence.                                    |
| Postcondición                 | Award aplicable a quotes dentro de vigencia.                      |

### UC-EC03-039 — Emitir CommercialQuote

| **Aspecto**                   | **Detalle**                                                                                                                        |
|-------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | EC-04/Staff                                                                                                                        |
| Trigger                       | Se requiere condición comercial formal                                                                                             |
| Precondiciones / autorización | Offering válido; pricing context autorizado; policies resolubles                                                                   |
| Happy Path                    | Resolver pinned price → evaluar benefits → stacking → rounding/FX → trace → persist quote/lines/adjustments/context hash → ISSUED. |
| Alternativas / errores        | Critical dependency unavailable=503; no eligible price=422; partial preview nunca se emite como quote.                             |
| Idempotencia                  | Idempotency-Key obligatorio.                                                                                                       |
| Concurrencia                  | Snapshot/locks de reservations; quote root version.                                                                                |
| Auditoría / side effects      | Audit + trace refs + source versions.                                                                                              |
| Postcondición                 | Quote inmutable con expires_at y ETag.                                                                                             |

### UC-EC03-044 — Aplicar override autorizado

| **Aspecto**                   | **Detalle**                                                                                          |
|-------------------------------|------------------------------------------------------------------------------------------------------|
| Actor                         | Commercial Supervisor                                                                                |
| Trigger                       | Excepción comercial documentada                                                                      |
| Precondiciones / autorización | Quote DRAFT o requote flow; role/ABAC; threshold; reason; step-up si aplica                          |
| Happy Path                    | Crear Adjustment OVERRIDE separado → recompute → approval si threshold lo exige → nueva quote/issue. |
| Alternativas / errores        | No permission=403; sobre límite=422; quote immutable=409.                                            |
| Idempotencia                  | Idempotency-Key.                                                                                     |
| Concurrencia                  | If-Match.                                                                                            |
| Auditoría / side effects      | Reason/evidence/assurance obligatorio.                                                               |
| Postcondición                 | Override explicable; base preservada.                                                                |

### UC-EC03-046 — Aceptar quote

| **Aspecto**                   | **Detalle**                                                                                   |
|-------------------------------|-----------------------------------------------------------------------------------------------|
| Actor                         | Participant/Staff                                                                             |
| Trigger                       | Cliente acepta condición                                                                      |
| Precondiciones / autorización | Quote ISSUED no expirada; context aún válido según policy                                     |
| Happy Path                    | Lock quote → revalidate expiry/reservation → ACCEPTED → crear ChargeIntent → outbox → commit. |
| Alternativas / errores        | Expired=422; ETag=412; duplicate returns same result.                                         |
| Idempotencia                  | Idempotency-Key obligatorio.                                                                  |
| Concurrencia                  | If-Match + state guard.                                                                       |
| Auditoría / side effects      | Audit acceptance/actor/channel.                                                               |
| Postcondición                 | Quote ACCEPTED y ChargeIntent durable.                                                        |

### UC-EC03-050 — Enviar ChargeIntent

| **Aspecto**                   | **Detalle**                                                                                                       |
|-------------------------------|-------------------------------------------------------------------------------------------------------------------|
| Actor                         | Finance Adapter                                                                                                   |
| Trigger                       | Outbox/command listo                                                                                              |
| Precondiciones / autorización | ChargeIntent PENDING; external id stable                                                                          |
| Happy Path                    | Mark IN_PROGRESS/lease → command Finanzas con idempotency contract → parse receipt → SUCCEEDED o state apropiado. |
| Alternativas / errores        | Timeout tras posible remote effect = UNKNOWN_EFFECT, no FAILED automático.                                        |
| Idempotencia                  | Stable external key + local idempotency.                                                                          |
| Concurrencia                  | Worker lease.                                                                                                     |
| Auditoría / side effects      | Integration receipt/correlation.                                                                                  |
| Postcondición                 | Estado terminal o UNKNOWN_EFFECT.                                                                                 |

### UC-EC03-052 — Reconciliar UNKNOWN_EFFECT

| **Aspecto**                   | **Detalle**                                                                                                                                                                     |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Actor                         | Ops/System                                                                                                                                                                      |
| Trigger                       | Timeout/alert                                                                                                                                                                   |
| Precondiciones / autorización | Intent UNKNOWN_EFFECT; receipt/correlation disponible                                                                                                                           |
| Happy Path                    | Consultar endpoint/status Finance → si aplicado guardar confirmed receipt/SUCCEEDED; si no aplicado probado, habilitar retry; si indeterminado mantener UNKNOWN_EFFECT/escalar. |
| Alternativas / errores        | Dependency unavailable mantiene estado; jamás adivina.                                                                                                                          |
| Idempotencia                  | Reconcile idempotente.                                                                                                                                                          |
| Concurrencia                  | Lease operacional.                                                                                                                                                              |
| Auditoría / side effects      | Ops audit + metrics.                                                                                                                                                            |
| Postcondición                 | Efecto reconciliado o escalado con evidencia.                                                                                                                                   |

# 11. DER conceptual, lógico y físico

## 11.1 DER conceptual

El modelo conceptual se organiza alrededor de cuatro líneas versionadas —PriceBook, Promotion, Scholarship y Quote/Charge— conectadas por referencias de Offering, ProgramVersion, Registration, Organization/Agreement y Finanzas. Las definiciones comerciales se versionan; los hechos emitidos (quote, award consumido, receipt) preservan historia.

## 11.2 DER lógico

PriceBookVersion agrega PriceComponent y PriceRuleBinding; OfferingPriceBinding pinnea una versión. PromotionVersion agrega conditions/benefits y puede gobernar pools/codes/reservations. ScholarshipVersion agrega criteria y produce ScholarshipAward. CommercialQuote agrega lines/adjustments y puede producir ChargeIntent; los receipts financieros y de publicación son append-only. Todas las relaciones internas son tenant-aware; refs externas no tienen FK físicas.

## 11.3 DER físico resumido

<img src="media/image4.png" style="width:6.7in;height:3.74804in" />

Figura 4 — DER físico resumido EC-03

| **REGLA DE FK —** Todas las FKs físicas de ec03 son internas y tenant-aware. CT-01…CT-18, IAM, EC-01/02/04/09 y Finanzas se consumen mediante EXT REF/contracts; una migración no debe introducir FKs cross-context “por comodidad”. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 12. Modelo físico PostgreSQL tabla por tabla

El esquema propuesto es ec03. PostgreSQL es Source of Truth transaccional de las decisiones comerciales propias de EC-03. Toda tabla tenant-owned usa tenant_id, RLS ENABLE + FORCE y PK/FK internas tenant-aware. Las referencias a CT, EC-02, EC-09, IAM y Finanzas son EXT REF sin FK física. Los montos usan numeric + BigDecimal; jamás float/double.

| **PREGUNTA OBLIGATORIA —** Para cada tabla se documenta qué error debe impedir PostgreSQL aunque Backend tenga un bug. La base no sustituye al dominio, pero sí bloquea estados físicamente imposibles, cruces tenant, snapshots históricos mutados, oversubscription de promo codes y aritmética monetaria incoherente. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.1 ec03_price_book_definition

**QUÉ REPRESENTA —** Identidad comercial estable de una lista de precios reutilizable. Separa el concepto institucional de precio de sus versiones efectivas y evita que una nueva tarifa reescriba cotizaciones o ediciones históricas.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root creado por Pricing Manager. Sus PriceBookVersion son snapshots versionados; EC-02/QuoteEngine consumen versiones explícitas. Los hechos contables permanecen en Finanzas.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege business key, ownership, moneda base y lifecycle. No representa una deuda, pago, factura ni precio finalmente cobrado.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**                          |
|-----------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|--------------------------------------|
| tenant_id             | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                                 |
| price_book_id         | uuid                | NO       | gen_random_uuid() | PK            | ID técnico estable del price book.                                               | pb…                                  |
| price_book_code       | varchar(64)         | NO       | —                 | UQ            | Código institucional estable por tenant.                                         | EC-OPEN-STD                          |
| official_name         | varchar(200)        | NO       | —                 | —             | Nombre oficial canónico.                                                         | Tarifario Educación Continua Abierta |
| owner_scope_ref       | uuid                | NO       | —                 | EXT REF CT-01 | Scope institucional responsable.                                                 | scope…                               |
| default_currency_code | char(3)             | NO       | —                 | EXT REF CT-02 | Moneda ISO/default de diseño; no constituye hecho financiero.                    | BOB                                  |
| lifecycle_state       | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/ACTIVE/SUSPENDED/RETIRED.                                                  | ACTIVE                               |
| created_by_subject    | uuid                | NO       | —                 | EXT REF IAM   | Actor creador.                                                                   | usr…                                 |
| created_at            | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z                    |
| updated_at            | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T15:30Z                    |
| version               | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                                    |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**price_book_id —** ID técnico estable del price book. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pb….

**price_book_code —** Código institucional estable por tenant. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EC-OPEN-STD.

**official_name —** Nombre oficial canónico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Tarifario Educación Continua Abierta.

**owner_scope_ref —** Scope institucional responsable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: scope….

**default_currency_code —** Moneda ISO/default de diseño; no constituye hecho financiero. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: BOB.

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**created_by_subject —** Actor creador. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                    | **Error que impide**                    |
|-----------------------------------------|----------|-------------------------------------------------------------|-----------------------------------------|
| **pk_ec03_price_book_definition**       | PK       | (tenant_id, price_book_id)                                  | Identidad duplicada o cruce tenant.     |
| **uq_ec03_price_book_definition_code**  | UQ       | (tenant_id, price_book_code)                                | Reutilización de business key.          |
| **ck_ec03_price_book_definition_state** | CHECK    | lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED') | Estado inválido.                        |
| **ix_ec03_price_book_owner_state**      | INDEX    | (tenant_id, owner_scope_ref, lifecycle_state)               | Consultas no indexadas por owner/state. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad duplicada o cruce tenant.; Reutilización de business key.; Estado inválido.; Consultas no indexadas por owner/state. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.2 ec03_price_book_version

**QUÉ REPRESENTA —** Snapshot versionado y publicable de una política de precios. Congela vigencia, políticas de redondeo/impuestos, moneda, componentes y reglas que sustentan una cotización.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate versionado hijo de PriceBookDefinition. DRAFT es editable; SCHEDULED/PUBLISHED/SUPERSEDED/VOID son snapshots gobernados. Publish genera hash, receipt y outbox.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lineage, vigencia, una única PUBLISHED vigente y una única SCHEDULED futura cuando la policy lo requiera. No registra cuentas por cobrar.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**             | **Descripción**                                                                  | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|-----------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*                  | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| price_book_version_id    | uuid                | NO       | gen_random_uuid() | PK                    | ID del snapshot comercial.                                                       | pbv…              |
| price_book_id            | uuid                | NO       | —                 | FK                    | PriceBookDefinition padre del mismo tenant.                                      | pb…               |
| version_no               | integer             | NO       | —                 | UQ                    | Número monotónico positivo dentro del price book.                                | 3                 |
| previous_version_id      | uuid                | YES      | NULL              | FK                    | Snapshot previo del mismo price book.                                            | pbv2…             |
| valid_from               | timestamptz         | YES      | NULL              | CHECK                 | Inicio de efectividad UTC.                                                       | 2026-10-01T04:00Z |
| valid_to                 | timestamptz         | YES      | NULL              | CHECK                 | Fin de efectividad UTC opcional.                                                 | 2027-01-01T04:00Z |
| rounding_policy_ref      | uuid                | NO       | —                 | EXT REF CT-02         | PolicyVersion inmutable para redondeo.                                           | pol…              |
| tax_policy_ref           | uuid                | YES      | NULL              | EXT REF CT-02/Finance | PolicyVersion de tratamiento impositivo/comercial; no contabiliza.               | pol…              |
| calculation_policy_ref   | uuid                | NO       | —                 | EXT REF CT-02         | PolicyVersion del algoritmo/reglas de pricing.                                   | pol…              |
| state                    | varchar(24)         | NO       | 'DRAFT'           | CHECK                 | DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID.                    | PUBLISHED         |
| workflow_ref             | uuid                | YES      | NULL              | EXT REF CT-06         | Workflow/case de aprobación.                                                     | wf…               |
| review_snapshot_hash     | varchar(128)        | YES      | NULL              | —                     | Hash del snapshot enviado a revisión.                                            | sha256:…          |
| content_hash             | varchar(128)        | YES      | NULL              | —                     | Hash canónico de publicación.                                                    | sha256:…          |
| published_at             | timestamptz         | YES      | NULL              | —                     | Instante de publicación/commit.                                                  | 2026-09-30T12:00Z |
| published_by_subject     | uuid                | YES      | NULL              | EXT REF IAM           | Publisher con assurance suficiente.                                              | usr…              |
| superseded_by_version_id | uuid                | YES      | NULL              | FK                    | Versión posterior que la reemplaza.                                              | pbv4…             |
| created_at               | timestamptz         | NO       | now()             | —                     | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at               | timestamptz         | NO       | now()             | —                     | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T15:30Z |
| version                  | bigint              | NO       | 0                 | —                     | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**price_book_version_id —** ID del snapshot comercial. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pbv….

**price_book_id —** PriceBookDefinition padre del mismo tenant. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pb….

**version_no —** Número monotónico positivo dentro del price book. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 3.

**previous_version_id —** Snapshot previo del mismo price book. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pbv2….

**valid_from —** Inicio de efectividad UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-10-01T04:00Z.

**valid_to —** Fin de efectividad UTC opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2027-01-01T04:00Z.

**rounding_policy_ref —** PolicyVersion inmutable para redondeo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**tax_policy_ref —** PolicyVersion de tratamiento impositivo/comercial; no contabiliza. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**calculation_policy_ref —** PolicyVersion del algoritmo/reglas de pricing. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**state —** DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PUBLISHED.

**workflow_ref —** Workflow/case de aprobación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**review_snapshot_hash —** Hash del snapshot enviado a revisión. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**content_hash —** Hash canónico de publicación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**published_at —** Instante de publicación/commit. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-30T12:00Z.

**published_by_subject —** Publisher con assurance suficiente. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**superseded_by_version_id —** Versión posterior que la reemplaza. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pbv4….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                                                                                                 | **Error que impide**            |
|-----------------------------------------|----------|------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------|
| **pk_ec03_price_book_version**          | PK       | (tenant_id, price_book_version_id)                                                                                                       | Identidad/cruce tenant.         |
| **uq_ec03_price_book_version_no**       | UQ       | (tenant_id, price_book_id, version_no)                                                                                                   | Dos números de versión iguales. |
| **uq_ec03_price_book_version_scope**    | UQ       | (tenant_id, price_book_id, price_book_version_id)                                                                                        | FKs scope-aware.                |
| **uq_ec03_price_book_single_published** | UQ_INDEX | (tenant_id, price_book_id) WHERE state='PUBLISHED'                                                                                       | Más de una versión vigente.     |
| **fk_ec03_pbv_definition**              | FK       | (tenant_id, price_book_id) REFERENCES ec03.ec03_price_book_definition(tenant_id, price_book_id)                                          | Versión huérfana/cross-tenant.  |
| **fk_ec03_pbv_previous**                | FK       | (tenant_id, price_book_id, previous_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_id, price_book_version_id) | Lineage hacia otro price book.  |
| **ck_ec03_pbv_version_positive**        | CHECK    | version_no \> 0                                                                                                                          | Version \<= 0.                  |
| **ck_ec03_pbv_dates**                   | CHECK    | valid_to IS NULL OR valid_from IS NULL OR valid_to \> valid_from                                                                         | Vigencia invertida.             |
| **ck_ec03_pbv_state**                   | CHECK    | state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID')                                                    | Estado no normativo.            |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Dos números de versión iguales.; FKs scope-aware.; Más de una versión vigente.; Versión huérfana/cross-tenant.; Lineage hacia otro price book.; Version \<= 0.; Vigencia invertida.; Estado no normativo. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.3 ec03_price_component

**QUÉ REPRESENTA —** Componente monetario de una PriceBookVersion: matrícula, tuition, material, fee u otro concepto comercial. Permite descomponer un precio sin inventar movimientos contables.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity del aggregate PriceBookVersion. El PricingEngine combina componentes y tiers; QuoteLine materializa el resultado. Finance recibe un ChargeIntent posterior, nunca lee esta tabla como ledger.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege montos base, moneda, orden y códigos únicos. No representa una factura ni un pago.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**             | **Descripción**                                                                   | **Ejemplo**              |
|-----------------------|---------------------|----------|-------------------|-----------------------|-----------------------------------------------------------------------------------|--------------------------|
| tenant_id             | uuid                | NO       | —                 | PK\*                  | Tenant derivado del Security/TenantContext; participa en identidad física y RLS.  | 8a6…                     |
| price_component_id    | uuid                | NO       | gen_random_uuid() | PK                    | ID técnico del componente.                                                        | pc…                      |
| price_book_version_id | uuid                | NO       | —                 | FK                    | PriceBookVersion padre.                                                           | pbv…                     |
| component_code        | varchar(64)         | NO       | —                 | UQ                    | Código de componente dentro de la versión.                                        | TUITION                  |
| component_type_code   | varchar(64)         | NO       | —                 | EXT REF CT-02         | Tipo parametrizado de componente.                                                 | TUITION                  |
| display_name          | varchar(160)        | NO       | —                 | —                     | Nombre canónico para cotización.                                                  | Derecho de participación |
| base_amount           | numeric(19,4)       | NO       | —                 | CHECK                 | Monto base decimal exacto \>= 0.                                                  | 1200.0000                |
| currency_code         | char(3)             | NO       | —                 | CHECK                 | Moneda ISO del componente.                                                        | BOB                      |
| mandatory             | boolean             | NO       | true              | —                     | Si siempre participa en pricing cuando aplica la versión.                         | true                     |
| sequence_no           | integer             | NO       | —                 | CHECK/UQ              | Orden estable dentro de la versión.                                               | 1                        |
| refund_policy_ref     | uuid                | YES      | NULL              | EXT REF CT-02/Finance | PolicyVersion para comportamiento comercial de devolución; no ejecuta devolución. | pol…                     |
| created_at            | timestamptz         | NO       | now()             | —                     | Instante UTC de creación.                                                         | 2026-09-09T15:00Z        |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**price_component_id —** ID técnico del componente. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pc….

**price_book_version_id —** PriceBookVersion padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pbv….

**component_code —** Código de componente dentro de la versión. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: TUITION.

**component_type_code —** Tipo parametrizado de componente. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: TUITION.

**display_name —** Nombre canónico para cotización. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Derecho de participación.

**base_amount —** Monto base decimal exacto \>= 0. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1200.0000.

**currency_code —** Moneda ISO del componente. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: BOB.

**mandatory —** Si siempre participa en pricing cuando aplica la versión. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es true; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: true.

**sequence_no —** Orden estable dentro de la versión. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**refund_policy_ref —** PolicyVersion para comportamiento comercial de devolución; no ejecuta devolución. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                                                                                     | **Error que impide**              |
|------------------------------------|----------|--------------------------------------------------------------------------------------------------------------|-----------------------------------|
| **pk_ec03_price_component**        | PK       | (tenant_id, price_component_id)                                                                              | Identidad/cruce tenant.           |
| **uq_ec03_price_component_code**   | UQ       | (tenant_id, price_book_version_id, component_code)                                                           | Código duplicado.                 |
| **uq_ec03_price_component_order**  | UQ       | (tenant_id, price_book_version_id, sequence_no)                                                              | Orden duplicado.                  |
| **fk_ec03_price_component_pbv**    | FK       | (tenant_id, price_book_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_version_id) | Componente huérfano/cross-tenant. |
| **ck_ec03_price_component_amount** | CHECK    | base_amount \>= 0                                                                                            | Monto negativo.                   |
| **ck_ec03_price_component_order**  | CHECK    | sequence_no \> 0                                                                                             | Orden no positivo.                |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Código duplicado.; Orden duplicado.; Componente huérfano/cross-tenant.; Monto negativo.; Orden no positivo. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.4 ec03_price_tier

**QUÉ REPRESENTA —** Escalón cuantitativo de precio aplicable a un componente, por ejemplo grupos corporativos de 1-10, 11-25 o 26+ participantes.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija de PriceComponent. El PricingEngine selecciona tiers bajo una policy determinista; los thresholds no se interpretan como cupos académicos.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege rangos, precio unitario y prioridad. No controla enrollment/cupos.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|----------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id            | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| price_tier_id        | uuid                | NO       | gen_random_uuid() | PK            | ID de tier.                                                                      | tier…             |
| price_component_id   | uuid                | NO       | —                 | FK            | Componente padre.                                                                | pc…               |
| min_quantity         | integer             | NO       | 1                 | CHECK         | Mínimo inclusivo.                                                                | 11                |
| max_quantity         | integer             | YES      | NULL              | CHECK         | Máximo inclusivo; NULL=open ended.                                               | 25                |
| unit_amount          | numeric(19,4)       | NO       | —                 | CHECK         | Monto unitario exacto.                                                           | 950.0000          |
| eligibility_rule_ref | uuid                | YES      | NULL              | EXT REF CT-15 | Regla adicional de elegibilidad si aplica.                                       | rule…             |
| priority             | integer             | NO       | 100               | CHECK         | Desempate gobernado; menor valor = mayor prioridad.                              | 10                |
| created_at           | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**price_tier_id —** ID de tier. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: tier….

**price_component_id —** Componente padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pc….

**min_quantity —** Mínimo inclusivo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 11.

**max_quantity —** Máximo inclusivo; NULL=open ended. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 25.

**unit_amount —** Monto unitario exacto. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 950.0000.

**eligibility_rule_ref —** Regla adicional de elegibilidad si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: rule….

**priority —** Desempate gobernado; menor valor = mayor prioridad. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 100; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 10.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                                                            | **Error que impide**          |
|----------------------------------|----------|-----------------------------------------------------------------------------------------------------|-------------------------------|
| **pk_ec03_price_tier**           | PK       | (tenant_id, price_tier_id)                                                                          | Identidad/cruce tenant.       |
| **fk_ec03_price_tier_component** | FK       | (tenant_id, price_component_id) REFERENCES ec03.ec03_price_component(tenant_id, price_component_id) | Tier huérfano/cross-tenant.   |
| **ck_ec03_price_tier_qty**       | CHECK    | min_quantity \> 0 AND (max_quantity IS NULL OR max_quantity \>= min_quantity)                       | Rango inválido.               |
| **ck_ec03_price_tier_amount**    | CHECK    | unit_amount \>= 0                                                                                   | Precio negativo.              |
| **ck_ec03_price_tier_priority**  | CHECK    | priority \>= 0                                                                                      | Prioridad negativa.           |
| **ix_ec03_price_tier_range**     | INDEX    | (tenant_id, price_component_id, min_quantity, max_quantity)                                         | Búsqueda ineficiente de tier. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Tier huérfano/cross-tenant.; Rango inválido.; Precio negativo.; Prioridad negativa.; Búsqueda ineficiente de tier. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.5 ec03_price_scope_binding

**QUÉ REPRESENTA —** Binding de aplicabilidad de una PriceBookVersion a site, campus, modalidad, canal, segmento, convenio u otro scope autorizado.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija de PriceBookVersion. Resuelve elegibilidad de price book junto con CT-01/02/15 y EC-02; no copia catálogos externos.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege target tipado, include/exclude y prioridad. No representa una Offering.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| price_scope_binding_id | uuid                | NO       | gen_random_uuid() | PK        | ID del binding.                                                                  | psb…              |
| price_book_version_id  | uuid                | NO       | —                 | FK        | Versión padre.                                                                   | pbv…              |
| scope_type             | varchar(32)         | NO       | —                 | CHECK     | SITE/CAMPUS/DELIVERY_MODE/CHANNEL/SEGMENT/AGREEMENT/OTHER.                       | CHANNEL           |
| scope_ref              | uuid                | YES      | NULL              | EXT REF   | Target externo cuando usa ID opaco.                                              | scope…            |
| scope_code             | varchar(100)        | YES      | NULL              | EXT REF   | Target por código gobernado cuando el contrato lo define.                        | WEB_PUBLIC        |
| effect                 | varchar(16)         | NO       | 'INCLUDE'         | CHECK     | INCLUDE/EXCLUDE.                                                                 | INCLUDE           |
| priority               | integer             | NO       | 100               | CHECK     | Prioridad determinista.                                                          | 20                |
| created_at             | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**price_scope_binding_id —** ID del binding. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: psb….

**price_book_version_id —** Versión padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pbv….

**scope_type —** SITE/CAMPUS/DELIVERY_MODE/CHANNEL/SEGMENT/AGREEMENT/OTHER. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CHANNEL.

**scope_ref —** Target externo cuando usa ID opaco. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: scope….

**scope_code —** Target por código gobernado cuando el contrato lo define. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: WEB_PUBLIC.

**effect —** INCLUDE/EXCLUDE. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'INCLUDE'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: INCLUDE.

**priority —** Prioridad determinista. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 100; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 20.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                                                                     | **Error que impide**              |
|----------------------------------|----------|--------------------------------------------------------------------------------------------------------------|-----------------------------------|
| **pk_ec03_price_scope_binding**  | PK       | (tenant_id, price_scope_binding_id)                                                                          | Identidad/cruce tenant.           |
| **fk_ec03_price_scope_pbv**      | FK       | (tenant_id, price_book_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_version_id) | Binding huérfano.                 |
| **ck_ec03_price_scope_type**     | CHECK    | scope_type IN ('SITE','CAMPUS','DELIVERY_MODE','CHANNEL','SEGMENT','AGREEMENT','OTHER')                      | Tipo inválido.                    |
| **ck_ec03_price_scope_target**   | CHECK    | (scope_ref IS NOT NULL)::int + (scope_code IS NOT NULL)::int = 1                                             | Target ambiguo/ausente.           |
| **ck_ec03_price_scope_effect**   | CHECK    | effect IN ('INCLUDE','EXCLUDE')                                                                              | Efecto inválido.                  |
| **ck_ec03_price_scope_priority** | CHECK    | priority \>= 0                                                                                               | Prioridad inválida.               |
| **ix_ec03_price_scope_lookup**   | INDEX    | (tenant_id, price_book_version_id, scope_type, priority)                                                     | Evaluación ineficiente de scopes. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Binding huérfano.; Tipo inválido.; Target ambiguo/ausente.; Efecto inválido.; Prioridad inválida.; Evaluación ineficiente de scopes. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.6 ec03_offering_price_binding

**QUÉ REPRESENTA —** Vínculo explícito que pinnea una Offering EC-02 a una PriceBookVersion concreta. Evita resolver “latest” y preserva la explicación histórica del precio aplicable.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Lo crea Pricing/Offering Desk tras validar Offering y versión. QuoteFactory lo usa como base; cambios futuros de price book no alteran el binding histórico sin comando/versionado.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege pinning y vigencia comercial. No crea ni modifica Offering.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| offering_price_binding_id | uuid                | NO       | gen_random_uuid() | PK            | ID del binding.                                                                  | opb…              |
| offering_ref              | uuid                | NO       | —                 | EXT REF EC-02 | Offering propietaria del contexto de venta.                                      | off…              |
| price_book_version_id     | uuid                | NO       | —                 | FK            | PriceBookVersion pinneada.                                                       | pbv…              |
| channel_code              | varchar(80)         | YES      | NULL              | EXT REF CT-02 | Canal específico si aplica.                                                      | WEB               |
| valid_from                | timestamptz         | NO       | —                 | CHECK         | Inicio de aplicabilidad.                                                         | 2026-10-01T04:00Z |
| valid_to                  | timestamptz         | YES      | NULL              | CHECK         | Fin opcional.                                                                    | 2026-12-31T23:59Z |
| binding_state             | varchar(20)         | NO       | 'ACTIVE'          | CHECK         | ACTIVE/SUSPENDED/RETIRED.                                                        | ACTIVE            |
| created_by_subject        | uuid                | NO       | —                 | EXT REF IAM   | Actor responsable.                                                               | usr…              |
| created_at                | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| version                   | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**offering_price_binding_id —** ID del binding. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: opb….

**offering_ref —** Offering propietaria del contexto de venta. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**price_book_version_id —** PriceBookVersion pinneada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pbv….

**channel_code —** Canal específico si aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: WEB.

**valid_from —** Inicio de aplicabilidad. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-10-01T04:00Z.

**valid_to —** Fin opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-12-31T23:59Z.

**binding_state —** ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'ACTIVE'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**created_by_subject —** Actor responsable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                  | **Tipo** | **Definición/expresión**                                                                                     | **Error que impide**                        |
|------------------------------------|----------|--------------------------------------------------------------------------------------------------------------|---------------------------------------------|
| **pk_ec03_offering_price_binding** | PK       | (tenant_id, offering_price_binding_id)                                                                       | Identidad/cruce tenant.                     |
| **fk_ec03_offering_price_pbv**     | FK       | (tenant_id, price_book_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_version_id) | Binding a versión inexistente/cross-tenant. |
| **ck_ec03_offering_price_dates**   | CHECK    | valid_to IS NULL OR valid_to \> valid_from                                                                   | Vigencia inválida.                          |
| **ck_ec03_offering_price_state**   | CHECK    | binding_state IN ('ACTIVE','SUSPENDED','RETIRED')                                                            | Estado inválido.                            |
| **ix_ec03_offering_price_lookup**  | INDEX    | (tenant_id, offering_ref, channel_code, valid_from DESC)                                                     | Lookup ineficiente.                         |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Binding a versión inexistente/cross-tenant.; Vigencia inválida.; Estado inválido.; Lookup ineficiente. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.7 ec03_promotion_campaign

**QUÉ REPRESENTA —** Identidad estable de una campaña promocional. Separa la campaña de sus versiones para que cambios de condiciones o beneficios no reescriban quotes previas.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root de promoción. PromotionVersion contiene la lógica versionada; pools/codes pueden referenciar una versión concreta.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege código, owner y lifecycle. No representa descuento aplicado ni transacción financiera.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**          |
|-----------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|----------------------|
| tenant_id             | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                 |
| promotion_campaign_id | uuid                | NO       | gen_random_uuid() | PK            | ID de campaña.                                                                   | promo…               |
| campaign_code         | varchar(64)         | NO       | —                 | UQ            | Business key estable.                                                            | EARLY-BIRD-2026      |
| official_name         | varchar(200)        | NO       | —                 | —             | Nombre oficial.                                                                  | Early Bird Primavera |
| owner_scope_ref       | uuid                | NO       | —                 | EXT REF CT-01 | Scope responsable.                                                               | scope…               |
| lifecycle_state       | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/ACTIVE/SUSPENDED/RETIRED.                                                  | ACTIVE               |
| created_by_subject    | uuid                | NO       | —                 | EXT REF IAM   | Actor creador.                                                                   | usr…                 |
| created_at            | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z    |
| updated_at            | timestamptz         | NO       | now()             | —             | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T15:30Z    |
| version               | bigint              | NO       | 0                 | —             | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                    |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**promotion_campaign_id —** ID de campaña. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: promo….

**campaign_code —** Business key estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EARLY-BIRD-2026.

**official_name —** Nombre oficial. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Early Bird Primavera.

**owner_scope_ref —** Scope responsable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: scope….

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**created_by_subject —** Actor creador. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                    | **Error que impide**    |
|--------------------------------------|----------|-------------------------------------------------------------|-------------------------|
| **pk_ec03_promotion_campaign**       | PK       | (tenant_id, promotion_campaign_id)                          | Identidad/cruce tenant. |
| **uq_ec03_promotion_campaign_code**  | UQ       | (tenant_id, campaign_code)                                  | Código duplicado.       |
| **ck_ec03_promotion_campaign_state** | CHECK    | lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED') | Estado inválido.        |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Código duplicado.; Estado inválido. |
|--------------------------------------------------------------------------------------------------|

## 12.8 ec03_promotion_version

**QUÉ REPRESENTA —** Snapshot versionado de condiciones, stacking, vigencia y beneficio de una promoción.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate versionado. Publication sigue el mismo patrón DRAFT→review→approved→scheduled/published; QuoteEngine evalúa una versión pinneada.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lineage, vigencia y publicación única. No materializa el descuento final; eso queda en PromotionApplication/QuoteAdjustment.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**             | **Descripción**                                                                  | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|-----------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*                  | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| promotion_version_id     | uuid                | NO       | gen_random_uuid() | PK                    | ID snapshot.                                                                     | pv…               |
| promotion_campaign_id    | uuid                | NO       | —                 | FK                    | Campaña padre.                                                                   | promo…            |
| version_no               | integer             | NO       | —                 | UQ                    | Versión monotónica.                                                              | 2                 |
| previous_version_id      | uuid                | YES      | NULL              | FK                    | Versión previa same campaign.                                                    | pv1…              |
| valid_from               | timestamptz         | NO       | —                 | CHECK                 | Inicio de vigencia.                                                              | 2026-09-15T04:00Z |
| valid_to                 | timestamptz         | YES      | NULL              | CHECK                 | Fin opcional.                                                                    | 2026-10-01T03:59Z |
| eligibility_rule_ref     | uuid                | YES      | NULL              | EXT REF CT-15         | EligibilityRule versionada.                                                      | rule…             |
| stacking_policy_ref      | uuid                | NO       | —                 | EXT REF CT-02         | PolicyVersion de stacking.                                                       | pol…              |
| budget_policy_ref        | uuid                | YES      | NULL              | EXT REF CT-02/Finance | PolicyVersion de límites comerciales; no ledger.                                 | pol…              |
| priority                 | integer             | NO       | 100               | CHECK                 | Prioridad de evaluación.                                                         | 10                |
| state                    | varchar(24)         | NO       | 'DRAFT'           | CHECK                 | DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID/SUSPENDED.          | PUBLISHED         |
| workflow_ref             | uuid                | YES      | NULL              | EXT REF CT-06         | Workflow de aprobación.                                                          | wf…               |
| content_hash             | varchar(128)        | YES      | NULL              | —                     | Hash canónico publicado.                                                         | sha256:…          |
| published_at             | timestamptz         | YES      | NULL              | —                     | Publish UTC.                                                                     | 2026-09-10T14:00Z |
| published_by_subject     | uuid                | YES      | NULL              | EXT REF IAM           | Publisher.                                                                       | usr…              |
| superseded_by_version_id | uuid                | YES      | NULL              | FK                    | Nueva versión que reemplaza.                                                     | pv3…              |
| created_at               | timestamptz         | NO       | now()             | —                     | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at               | timestamptz         | NO       | now()             | —                     | Última modificación autorizada del aggregate o metadata.                         | 2026-09-09T15:30Z |
| version                  | bigint              | NO       | 0                 | —                     | Revisión optimista observable del aggregate completo; se expone como ETag.       | 7                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**promotion_version_id —** ID snapshot. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pv….

**promotion_campaign_id —** Campaña padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: promo….

**version_no —** Versión monotónica. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 2.

**previous_version_id —** Versión previa same campaign. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pv1….

**valid_from —** Inicio de vigencia. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-15T04:00Z.

**valid_to —** Fin opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-10-01T03:59Z.

**eligibility_rule_ref —** EligibilityRule versionada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: rule….

**stacking_policy_ref —** PolicyVersion de stacking. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**budget_policy_ref —** PolicyVersion de límites comerciales; no ledger. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**priority —** Prioridad de evaluación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 100; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 10.

**state —** DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID/SUSPENDED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PUBLISHED.

**workflow_ref —** Workflow de aprobación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**content_hash —** Hash canónico publicado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**published_at —** Publish UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-10T14:00Z.

**published_by_subject —** Publisher. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**superseded_by_version_id —** Nueva versión que reemplaza. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pv3….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada del aggregate o metadata. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable del aggregate completo; se expone como ETag. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 7.

### Constraints físicos implementables

| **Nombre físico**                      | **Tipo** | **Definición/expresión**                                                                                     | **Error que impide**                      |
|----------------------------------------|----------|--------------------------------------------------------------------------------------------------------------|-------------------------------------------|
| **pk_ec03_promotion_version**          | PK       | (tenant_id, promotion_version_id)                                                                            | Identidad/cruce tenant.                   |
| **uq_ec03_promotion_version_no**       | UQ       | (tenant_id, promotion_campaign_id, version_no)                                                               | Versión duplicada.                        |
| **uq_ec03_promotion_single_published** | UQ_INDEX | (tenant_id, promotion_campaign_id) WHERE state='PUBLISHED'                                                   | Más de una promoción vigente por campaña. |
| **fk_ec03_promotion_version_campaign** | FK       | (tenant_id, promotion_campaign_id) REFERENCES ec03.ec03_promotion_campaign(tenant_id, promotion_campaign_id) | Versión huérfana.                         |
| **ck_ec03_promotion_version_dates**    | CHECK    | valid_to IS NULL OR valid_to \> valid_from                                                                   | Vigencia inválida.                        |
| **ck_ec03_promotion_version_state**    | CHECK    | state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID','SUSPENDED')            | Estado inválido.                          |
| **ck_ec03_promotion_version_priority** | CHECK    | priority \>= 0                                                                                               | Prioridad inválida.                       |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Versión duplicada.; Más de una promoción vigente por campaña.; Versión huérfana.; Vigencia inválida.; Estado inválido.; Prioridad inválida. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.9 ec03_promotion_condition

**QUÉ REPRESENTA —** Condición declarativa de una PromotionVersion, por ejemplo canal, ventana temporal, segmento, volumen, offering o eligibility externa.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija de PromotionVersion. Se interpreta por un evaluador tipado; los valores configurables se referencian a CT-02/15 en vez de hardcodearse en Java.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege kind/operator/value y orden lógico. No ejecuta por sí sola un descuento.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| promotion_condition_id | uuid                | NO       | gen_random_uuid() | PK            | ID condición.                                                                    | cond…             |
| promotion_version_id   | uuid                | NO       | —                 | FK            | Versión padre.                                                                   | pv…               |
| condition_code         | varchar(64)         | NO       | —                 | UQ            | Código local.                                                                    | EARLY_WINDOW      |
| condition_type         | varchar(40)         | NO       | —                 | CHECK         | TIME_WINDOW/CHANNEL/SEGMENT/OFFERING/QUANTITY/ELIGIBILITY/OTHER.                 | TIME_WINDOW       |
| operator_code          | varchar(32)         | NO       | —                 | EXT REF CT-02 | Operador permitido para el tipo.                                                 | BETWEEN           |
| operand_json           | jsonb               | NO       | '{}'::jsonb       | CHECK         | Operand tipado/versionado; sin PII libre.                                        | {"from":"…"}      |
| eligibility_rule_ref   | uuid                | YES      | NULL              | EXT REF CT-15 | Regla CT-15 si condition_type=ELIGIBILITY.                                       | rule…             |
| sequence_no            | integer             | NO       | —                 | CHECK/UQ      | Orden de evaluación/explicación.                                                 | 1                 |
| created_at             | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**promotion_condition_id —** ID condición. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cond….

**promotion_version_id —** Versión padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pv….

**condition_code —** Código local. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EARLY_WINDOW.

**condition_type —** TIME_WINDOW/CHANNEL/SEGMENT/OFFERING/QUANTITY/ELIGIBILITY/OTHER. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: TIME_WINDOW.

**operator_code —** Operador permitido para el tipo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: BETWEEN.

**operand_json —** Operand tipado/versionado; sin PII libre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"from":"…"}.

**eligibility_rule_ref —** Regla CT-15 si condition_type=ELIGIBILITY. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: rule….

**sequence_no —** Orden de evaluación/explicación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                                                                  | **Error que impide**    |
|-----------------------------------------|----------|-----------------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec03_promotion_condition**         | PK       | (tenant_id, promotion_condition_id)                                                                       | Identidad/cruce tenant. |
| **fk_ec03_promotion_condition_version** | FK       | (tenant_id, promotion_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id) | Condición huérfana.     |
| **uq_ec03_promotion_condition_code**    | UQ       | (tenant_id, promotion_version_id, condition_code)                                                         | Código duplicado.       |
| **ck_ec03_promotion_condition_type**    | CHECK    | condition_type IN ('TIME_WINDOW','CHANNEL','SEGMENT','OFFERING','QUANTITY','ELIGIBILITY','OTHER')         | Tipo inválido.          |
| **ck_ec03_promotion_condition_order**   | CHECK    | sequence_no \> 0                                                                                          | Orden inválido.         |
| **ck_ec03_promotion_condition_operand** | CHECK    | jsonb_typeof(operand_json)='object'                                                                       | Operand mal formado.    |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Condición huérfana.; Código duplicado.; Tipo inválido.; Orden inválido.; Operand mal formado. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.10 ec03_promotion_benefit

**QUÉ REPRESENTA —** Beneficio cuantificable de una PromotionVersion: porcentaje, monto fijo, precio override o componente gratuito.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija evaluada por PricingEngine después de conditions/stacking. El resultado se materializa en PromotionApplication y QuoteAdjustment con provenance.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege tipos, moneda/porcentaje y cap. No representa dinero desembolsado.

| **Campo**             | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**       |
|-----------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|-------------------|
| tenant_id             | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| promotion_benefit_id  | uuid                | NO       | gen_random_uuid() | PK        | ID beneficio.                                                                    | ben…              |
| promotion_version_id  | uuid                | NO       | —                 | FK        | Versión padre.                                                                   | pv…               |
| benefit_code          | varchar(64)         | NO       | —                 | UQ        | Código local.                                                                    | DISC10            |
| benefit_type          | varchar(32)         | NO       | —                 | CHECK     | PERCENT/FIXED/PRICE_OVERRIDE/FREE_COMPONENT.                                     | PERCENT           |
| percent_value         | numeric(9,4)        | YES      | NULL              | CHECK     | Porcentaje \>0 \<=100 cuando aplica.                                             | 10.0000           |
| amount_value          | numeric(19,4)       | YES      | NULL              | CHECK     | Monto exacto cuando aplica.                                                      | 100.0000          |
| currency_code         | char(3)             | YES      | NULL              | CHECK     | Moneda requerida para montos.                                                    | BOB               |
| max_discount_amount   | numeric(19,4)       | YES      | NULL              | CHECK     | Cap opcional.                                                                    | 300.0000          |
| target_component_code | varchar(64)         | YES      | NULL              | —         | Componente objetivo opcional.                                                    | TUITION           |
| sequence_no           | integer             | NO       | —                 | CHECK/UQ  | Orden de aplicación.                                                             | 1                 |
| created_at            | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**promotion_benefit_id —** ID beneficio. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ben….

**promotion_version_id —** Versión padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pv….

**benefit_code —** Código local. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: DISC10.

**benefit_type —** PERCENT/FIXED/PRICE_OVERRIDE/FREE_COMPONENT. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PERCENT.

**percent_value —** Porcentaje \>0 \<=100 cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 10.0000.

**amount_value —** Monto exacto cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 100.0000.

**currency_code —** Moneda requerida para montos. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: BOB.

**max_discount_amount —** Cap opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 300.0000.

**target_component_code —** Componente objetivo opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: TUITION.

**sequence_no —** Orden de aplicación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                     | **Tipo** | **Definición/expresión**                                                                                                                                                                                                                                                                                                                                | **Error que impide**             |
|---------------------------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------|
| **pk_ec03_promotion_benefit**         | PK       | (tenant_id, promotion_benefit_id)                                                                                                                                                                                                                                                                                                                       | Identidad/cruce tenant.          |
| **fk_ec03_promotion_benefit_version** | FK       | (tenant_id, promotion_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id)                                                                                                                                                                                                                                               | Beneficio huérfano.              |
| **uq_ec03_promotion_benefit_code**    | UQ       | (tenant_id, promotion_version_id, benefit_code)                                                                                                                                                                                                                                                                                                         | Código duplicado.                |
| **ck_ec03_promotion_benefit_type**    | CHECK    | benefit_type IN ('PERCENT','FIXED','PRICE_OVERRIDE','FREE_COMPONENT')                                                                                                                                                                                                                                                                                   | Tipo inválido.                   |
| **ck_ec03_promotion_benefit_values**  | CHECK    | (benefit_type='PERCENT' AND percent_value\>0 AND percent_value\<=100 AND amount_value IS NULL) OR (benefit_type IN ('FIXED','PRICE_OVERRIDE') AND amount_value\>=0 AND currency_code IS NOT NULL AND percent_value IS NULL) OR (benefit_type='FREE_COMPONENT' AND target_component_code IS NOT NULL AND percent_value IS NULL AND amount_value IS NULL) | Combinación de valores inválida. |
| **ck_ec03_promotion_benefit_cap**     | CHECK    | max_discount_amount IS NULL OR max_discount_amount \>= 0                                                                                                                                                                                                                                                                                                | Cap negativo.                    |
| **ck_ec03_promotion_benefit_order**   | CHECK    | sequence_no \> 0                                                                                                                                                                                                                                                                                                                                        | Orden inválido.                  |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Beneficio huérfano.; Código duplicado.; Tipo inválido.; Combinación de valores inválida.; Cap negativo.; Orden inválido. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.11 ec03_promo_code_pool

**QUÉ REPRESENTA —** Configuración gobernada para emisión de códigos promocionales asociados a una PromotionVersion. Define formato, límites y estrategia de generación sin guardar secretos en texto claro.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate operativo ligado a PromotionVersion publicada. Puede generar lotes de PromoCode por comando idempotente; bulk generation produce OperationStatus.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege tamaño de lote, longitud/formato, expiración y contadores. No representa un descuento consumido.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**       |
|----------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|-------------------|
| tenant_id            | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| promo_code_pool_id   | uuid                | NO       | gen_random_uuid() | PK        | ID del pool.                                                                     | pool…             |
| promotion_version_id | uuid                | NO       | —                 | FK        | PromotionVersion propietaria.                                                    | pv…               |
| pool_code            | varchar(64)         | NO       | —                 | UQ        | Business code del pool.                                                          | EARLY-CODES       |
| prefix               | varchar(24)         | YES      | NULL              | —         | Prefijo visible opcional; no secreto.                                            | EB26              |
| token_length         | integer             | NO       | 12                | CHECK     | Longitud de token aleatorio sin prefijo.                                         | 12                |
| max_codes            | integer             | NO       | —                 | CHECK     | Máximo autorizado por policy.                                                    | 5000              |
| generated_count      | integer             | NO       | 0                 | CHECK     | Contador denormalizado de códigos generados.                                     | 1200              |
| default_max_uses     | integer             | NO       | 1                 | CHECK     | Usos máximos por código si no se overridea.                                      | 1                 |
| expires_at           | timestamptz         | YES      | NULL              | CHECK     | Expiración del pool.                                                             | 2026-10-01T03:59Z |
| state                | varchar(20)         | NO       | 'DRAFT'           | CHECK     | DRAFT/ACTIVE/SUSPENDED/EXHAUSTED/RETIRED.                                        | ACTIVE            |
| created_at           | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at           | timestamptz         | NO       | now()             | —         | Última modificación autorizada.                                                  | 2026-09-09T15:30Z |
| version              | bigint              | NO       | 0                 | —         | Revisión optimista observable mediante ETag/If-Match.                            | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**promo_code_pool_id —** ID del pool. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pool….

**promotion_version_id —** PromotionVersion propietaria. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pv….

**pool_code —** Business code del pool. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EARLY-CODES.

**prefix —** Prefijo visible opcional; no secreto. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: EB26.

**token_length —** Longitud de token aleatorio sin prefijo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 12; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 12.

**max_codes —** Máximo autorizado por policy. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 5000.

**generated_count —** Contador denormalizado de códigos generados. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1200.

**default_max_uses —** Usos máximos por código si no se overridea. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1.

**expires_at —** Expiración del pool. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-10-01T03:59Z.

**state —** DRAFT/ACTIVE/SUSPENDED/EXHAUSTED/RETIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                                                                  | **Error que impide**             |
|----------------------------------|----------|-----------------------------------------------------------------------------------------------------------|----------------------------------|
| **pk_ec03_promo_code_pool**      | PK       | (tenant_id, promo_code_pool_id)                                                                           | Identidad/cruce tenant.          |
| **fk_ec03_promo_pool_promotion** | FK       | (tenant_id, promotion_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id) | Pool huérfano.                   |
| **uq_ec03_promo_pool_code**      | UQ       | (tenant_id, pool_code)                                                                                    | Código pool duplicado.           |
| **ck_ec03_promo_pool_length**    | CHECK    | token_length BETWEEN 8 AND 64                                                                             | Token inseguro/excesivo.         |
| **ck_ec03_promo_pool_counts**    | CHECK    | max_codes \> 0 AND generated_count \>= 0 AND generated_count \<= max_codes AND default_max_uses \> 0      | Contadores/límites incoherentes. |
| **ck_ec03_promo_pool_state**     | CHECK    | state IN ('DRAFT','ACTIVE','SUSPENDED','EXHAUSTED','RETIRED')                                             | Estado inválido.                 |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Pool huérfano.; Código pool duplicado.; Token inseguro/excesivo.; Contadores/límites incoherentes.; Estado inválido. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.12 ec03_promo_code

**QUÉ REPRESENTA —** Token promocional individual almacenado como hash + last4. El valor completo solo se muestra en el momento seguro de emisión o se entrega por CT-05/07 según política.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate operativo con locking de fila. PromoReservationService reserva y consume usos de forma transaccional; nunca se valida por SELECT sin lock seguido de UPDATE tardío.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege secreto, límites de uso y estado. No guarda el código plaintext ni concede descuento por sí solo.

| **Campo**          | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**           | **Descripción**                                                                  | **Ejemplo**       |
|--------------------|---------------------|----------|-------------------|---------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id          | uuid                | NO       | —                 | PK\*                | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| promo_code_id      | uuid                | NO       | gen_random_uuid() | PK                  | ID del código.                                                                   | code…             |
| promo_code_pool_id | uuid                | NO       | —                 | FK                  | Pool padre.                                                                      | pool…             |
| token_hash         | varchar(128)        | NO       | —                 | UQ                  | Hash criptográfico normalizado del token.                                        | sha256:…          |
| token_last4        | char(4)             | NO       | —                 | —                   | Últimos 4 para soporte/identificación.                                           | A7X2              |
| issued_to_ref      | uuid                | YES      | NULL              | EXT REF CT-04/EC-09 | Destinatario opcional sin PII local.                                             | person…           |
| max_uses           | integer             | NO       | 1                 | CHECK               | Usos totales autorizados.                                                        | 1                 |
| reserved_uses      | integer             | NO       | 0                 | CHECK               | Reservas activas no consumidas.                                                  | 0                 |
| redeemed_uses      | integer             | NO       | 0                 | CHECK               | Usos consumidos.                                                                 | 0                 |
| expires_at         | timestamptz         | YES      | NULL              | CHECK               | Expiración individual.                                                           | 2026-10-01T03:59Z |
| state              | varchar(20)         | NO       | 'AVAILABLE'       | CHECK               | AVAILABLE/SUSPENDED/EXHAUSTED/REVOKED/EXPIRED.                                   | AVAILABLE         |
| created_at         | timestamptz         | NO       | now()             | —                   | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at         | timestamptz         | NO       | now()             | —                   | Última modificación autorizada.                                                  | 2026-09-09T15:30Z |
| version            | bigint              | NO       | 0                 | —                   | Revisión optimista observable mediante ETag/If-Match.                            | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**promo_code_id —** ID del código. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: code….

**promo_code_pool_id —** Pool padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pool….

**token_hash —** Hash criptográfico normalizado del token. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**token_last4 —** Últimos 4 para soporte/identificación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: A7X2.

**issued_to_ref —** Destinatario opcional sin PII local. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**max_uses —** Usos totales autorizados. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1.

**reserved_uses —** Reservas activas no consumidas. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 0.

**redeemed_uses —** Usos consumidos. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 0.

**expires_at —** Expiración individual. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-10-01T03:59Z.

**state —** AVAILABLE/SUSPENDED/EXHAUSTED/REVOKED/EXPIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'AVAILABLE'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: AVAILABLE.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**             | **Tipo** | **Definición/expresión**                                                                                     | **Error que impide**         |
|-------------------------------|----------|--------------------------------------------------------------------------------------------------------------|------------------------------|
| **pk_ec03_promo_code**        | PK       | (tenant_id, promo_code_id)                                                                                   | Identidad/cruce tenant.      |
| **fk_ec03_promo_code_pool**   | FK       | (tenant_id, promo_code_pool_id) REFERENCES ec03.ec03_promo_code_pool(tenant_id, promo_code_pool_id)          | Código huérfano.             |
| **uq_ec03_promo_code_hash**   | UQ       | (tenant_id, token_hash)                                                                                      | Mismo token duplicado.       |
| **ck_ec03_promo_code_counts** | CHECK    | max_uses \> 0 AND reserved_uses \>= 0 AND redeemed_uses \>= 0 AND reserved_uses + redeemed_uses \<= max_uses | Oversubscription del código. |
| **ck_ec03_promo_code_state**  | CHECK    | state IN ('AVAILABLE','SUSPENDED','EXHAUSTED','REVOKED','EXPIRED')                                           | Estado inválido.             |
| **ix_ec03_promo_code_last4**  | INDEX    | (tenant_id, token_last4)                                                                                     | Soporte no indexado.         |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Código huérfano.; Mismo token duplicado.; Oversubscription del código.; Estado inválido.; Soporte no indexado. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.13 ec03_promo_code_reservation

**QUÉ REPRESENTA —** Reserva temporal de un uso de promo code para una cotización/subject. Resuelve carreras entre usuarios y evita consumir definitivamente antes de aceptar/emitir el quote.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity transaccional creada bajo SELECT FOR UPDATE del PromoCode. Posee lease; expiration job libera de forma idempotente y decrementa reserved_uses en la misma transacción.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege una reserva activa por idempotency key y lifecycle. No es redención financiera.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| promo_code_reservation_id | uuid                | NO       | gen_random_uuid() | PK            | ID reserva.                                                                      | res…              |
| promo_code_id             | uuid                | NO       | —                 | FK            | Código reservado.                                                                | code…             |
| quote_id                  | uuid                | YES      | NULL              | FK            | Quote local asociada cuando existe.                                              | q…                |
| subject_ref               | uuid                | YES      | NULL              | EXT REF CT-04 | Subject beneficiario, sin PII.                                                   | person…           |
| idempotency_key           | varchar(160)        | NO       | —                 | UQ            | Clave durable del comando.                                                       | idem…             |
| reserved_at               | timestamptz         | NO       | now()             | —             | Inicio reserva.                                                                  | …                 |
| lease_until               | timestamptz         | NO       | —                 | CHECK         | Fin del lease.                                                                   | …                 |
| state                     | varchar(20)         | NO       | 'RESERVED'        | CHECK         | RESERVED/CONSUMED/RELEASED/EXPIRED.                                              | RESERVED          |
| consumed_at               | timestamptz         | YES      | NULL              | —             | Momento de consumo final.                                                        | …                 |
| released_at               | timestamptz         | YES      | NULL              | —             | Momento de liberación/expiración.                                                | …                 |
| created_at                | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**promo_code_reservation_id —** ID reserva. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: res….

**promo_code_id —** Código reservado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: code….

**quote_id —** Quote local asociada cuando existe. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: q….

**subject_ref —** Subject beneficiario, sin PII. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**idempotency_key —** Clave durable del comando. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: idem….

**reserved_at —** Inicio reserva. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**lease_until —** Fin del lease. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**state —** RESERVED/CONSUMED/RELEASED/EXPIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'RESERVED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: RESERVED.

**consumed_at —** Momento de consumo final. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**released_at —** Momento de liberación/expiración. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                                             | **Error que impide**                        |
|--------------------------------------|----------|--------------------------------------------------------------------------------------|---------------------------------------------|
| **pk_ec03_promo_reservation**        | PK       | (tenant_id, promo_code_reservation_id)                                               | Identidad/cruce tenant.                     |
| **fk_ec03_promo_reservation_code**   | FK       | (tenant_id, promo_code_id) REFERENCES ec03.ec03_promo_code(tenant_id, promo_code_id) | Reserva huérfana.                           |
| **uq_ec03_promo_reservation_idem**   | UQ       | (tenant_id, idempotency_key)                                                         | Reserva duplicada por retry.                |
| **ck_ec03_promo_reservation_lease**  | CHECK    | lease_until \> reserved_at                                                           | Lease inválido.                             |
| **ck_ec03_promo_reservation_state**  | CHECK    | state IN ('RESERVED','CONSUMED','RELEASED','EXPIRED')                                | Estado inválido.                            |
| **ix_ec03_promo_reservation_expiry** | INDEX    | (tenant_id, lease_until) WHERE state='RESERVED'                                      | Expiraciones no reclamables eficientemente. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Reserva huérfana.; Reserva duplicada por retry.; Lease inválido.; Estado inválido.; Expiraciones no reclamables eficientemente. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.14 ec03_promotion_application

**QUÉ REPRESENTA —** Hecho inmutable que registra qué PromotionVersion fue evaluada/aplicada a un quote y qué beneficio monetario resultó.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se crea durante cálculo/issue de quote a partir de PromotionVersion pinneada. Alimenta PricingTrace y auditoría; si se recalcula se crea nueva quote o se reemplaza mientras quote sea DRAFT/CALCULATED según política.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege provenance y monto resultante. No modifica la PromotionVersion ni crea pago.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**         |
|---------------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|---------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                |
| promotion_application_id  | uuid                | NO       | gen_random_uuid() | PK        | ID aplicación.                                                                   | pa…                 |
| quote_id                  | uuid                | NO       | —                 | FK        | Quote destinataria.                                                              | q…                  |
| promotion_version_id      | uuid                | NO       | —                 | FK        | Versión exacta aplicada.                                                         | pv…                 |
| promo_code_reservation_id | uuid                | YES      | NULL              | FK        | Reserva de código cuando aplica.                                                 | res…                |
| benefit_snapshot_json     | jsonb               | NO       | '{}'::jsonb       | CHECK     | Snapshot del beneficio/regla efectiva.                                           | {"type":"PERCENT"}  |
| discount_amount           | numeric(19,4)       | NO       | 0                 | CHECK     | Descuento exacto aplicado.                                                       | 120.0000            |
| currency_code             | char(3)             | NO       | —                 | CHECK     | Moneda del resultado.                                                            | BOB                 |
| application_order         | integer             | NO       | —                 | CHECK/UQ  | Orden de stacking.                                                               | 1                   |
| explanation_code          | varchar(80)         | NO       | —                 | —         | Reason code estable para UI/audit.                                               | PROMO_EARLY_APPLIED |
| created_at                | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T15:00Z   |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**promotion_application_id —** ID aplicación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pa….

**quote_id —** Quote destinataria. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: q….

**promotion_version_id —** Versión exacta aplicada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pv….

**promo_code_reservation_id —** Reserva de código cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: res….

**benefit_snapshot_json —** Snapshot del beneficio/regla efectiva. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"type":"PERCENT"}.

**discount_amount —** Descuento exacto aplicado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 120.0000.

**currency_code —** Moneda del resultado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: BOB.

**application_order —** Orden de stacking. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**explanation_code —** Reason code estable para UI/audit. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PROMO_EARLY_APPLIED.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                      | **Tipo** | **Definición/expresión**                                                                                  | **Error que impide**      |
|----------------------------------------|----------|-----------------------------------------------------------------------------------------------------------|---------------------------|
| **pk_ec03_promotion_application**      | PK       | (tenant_id, promotion_application_id)                                                                     | Identidad/cruce tenant.   |
| **fk_ec03_promo_application_version**  | FK       | (tenant_id, promotion_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id) | Versión inexistente.      |
| **uq_ec03_promo_application_order**    | UQ       | (tenant_id, quote_id, application_order)                                                                  | Orden stacking duplicado. |
| **ck_ec03_promo_application_amount**   | CHECK    | discount_amount \>= 0                                                                                     | Descuento negativo.       |
| **ck_ec03_promo_application_snapshot** | CHECK    | jsonb_typeof(benefit_snapshot_json)='object'                                                              | Snapshot mal formado.     |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Versión inexistente.; Orden stacking duplicado.; Descuento negativo.; Snapshot mal formado. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.15 ec03_scholarship_program

**QUÉ REPRESENTA —** Identidad estable de un programa de becas/descuentos institucionales de Educación Continua. Separa programa, reglas versionadas y adjudicación individual.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root administrado por Scholarship Governance. ScholarshipVersion define la regla comercial; ScholarshipAward registra decisión individual tras CT-15/CT-06.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege código, owner y lifecycle. No representa una beca aplicada a deuda ni pago.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| scholarship_program_id | uuid                | NO       | gen_random_uuid() | PK            | ID programa beca.                                                                | sp…               |
| scholarship_code       | varchar(64)         | NO       | —                 | UQ            | Código institucional.                                                            | MERITO-EC         |
| official_name          | varchar(200)        | NO       | —                 | —             | Nombre oficial.                                                                  | Beca de mérito EC |
| owner_scope_ref        | uuid                | NO       | —                 | EXT REF CT-01 | Scope responsable.                                                               | scope…            |
| lifecycle_state        | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/ACTIVE/SUSPENDED/RETIRED.                                                  | ACTIVE            |
| created_by_subject     | uuid                | NO       | —                 | EXT REF IAM   | Actor creador.                                                                   | usr…              |
| created_at             | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at             | timestamptz         | NO       | now()             | —             | Última modificación autorizada.                                                  | 2026-09-09T15:30Z |
| version                | bigint              | NO       | 0                 | —             | Revisión optimista observable mediante ETag/If-Match.                            | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**scholarship_program_id —** ID programa beca. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sp….

**scholarship_code —** Código institucional. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: MERITO-EC.

**official_name —** Nombre oficial. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Beca de mérito EC.

**owner_scope_ref —** Scope responsable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: scope….

**lifecycle_state —** DRAFT/ACTIVE/SUSPENDED/RETIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**created_by_subject —** Actor creador. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                     | **Tipo** | **Definición/expresión**                                    | **Error que impide**    |
|---------------------------------------|----------|-------------------------------------------------------------|-------------------------|
| **pk_ec03_scholarship_program**       | PK       | (tenant_id, scholarship_program_id)                         | Identidad/cruce tenant. |
| **uq_ec03_scholarship_program_code**  | UQ       | (tenant_id, scholarship_code)                               | Código duplicado.       |
| **ck_ec03_scholarship_program_state** | CHECK    | lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED') | Estado inválido.        |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Código duplicado.; Estado inválido. |
|--------------------------------------------------------------------------------------------------|

## 12.16 ec03_scholarship_version

**QUÉ REPRESENTA —** Snapshot versionado de elegibilidad, vigencia, budget/approval policy y beneficio de una beca.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate versionado consumido por Scholarship Desk. CT-15 decide elegibilidad; CT-06 orquesta aprobación; EC-03 guarda la semántica comercial y la adjudicación.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lineage, efectividad y publicación. No contiene PII del solicitante.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**             | **Descripción**                                                                  | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|-----------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*                  | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| scholarship_version_id | uuid                | NO       | gen_random_uuid() | PK                    | ID snapshot.                                                                     | sv…               |
| scholarship_program_id | uuid                | NO       | —                 | FK                    | Programa padre.                                                                  | sp…               |
| version_no             | integer             | NO       | —                 | UQ                    | Número monotónico.                                                               | 1                 |
| previous_version_id    | uuid                | YES      | NULL              | FK                    | Versión anterior.                                                                | sv0…              |
| valid_from             | timestamptz         | NO       | —                 | CHECK                 | Inicio vigencia.                                                                 | 2026-09-01T04:00Z |
| valid_to               | timestamptz         | YES      | NULL              | CHECK                 | Fin opcional.                                                                    | 2026-12-31T23:59Z |
| eligibility_rule_ref   | uuid                | NO       | —                 | EXT REF CT-15         | Regla de elegibilidad versionada.                                                | rule…             |
| approval_policy_ref    | uuid                | NO       | —                 | EXT REF CT-02/06      | PolicyVersion de aprobación/SoD.                                                 | pol…              |
| budget_policy_ref      | uuid                | YES      | NULL              | EXT REF CT-02/Finance | PolicyVersion de control presupuestario comercial.                               | pol…              |
| state                  | varchar(24)         | NO       | 'DRAFT'           | CHECK                 | DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID/SUSPENDED.          | PUBLISHED         |
| workflow_ref           | uuid                | YES      | NULL              | EXT REF CT-06         | Workflow de publicación.                                                         | wf…               |
| content_hash           | varchar(128)        | YES      | NULL              | —                     | Hash canónico.                                                                   | sha256:…          |
| published_at           | timestamptz         | YES      | NULL              | —                     | Publish UTC.                                                                     | …                 |
| published_by_subject   | uuid                | YES      | NULL              | EXT REF IAM           | Publisher.                                                                       | usr…              |
| created_at             | timestamptz         | NO       | now()             | —                     | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at             | timestamptz         | NO       | now()             | —                     | Última modificación autorizada.                                                  | 2026-09-09T15:30Z |
| version                | bigint              | NO       | 0                 | —                     | Revisión optimista observable mediante ETag/If-Match.                            | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**scholarship_version_id —** ID snapshot. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sv….

**scholarship_program_id —** Programa padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: sp….

**version_no —** Número monotónico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**previous_version_id —** Versión anterior. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: sv0….

**valid_from —** Inicio vigencia. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-01T04:00Z.

**valid_to —** Fin opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-12-31T23:59Z.

**eligibility_rule_ref —** Regla de elegibilidad versionada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: rule….

**approval_policy_ref —** PolicyVersion de aprobación/SoD. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**budget_policy_ref —** PolicyVersion de control presupuestario comercial. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: pol….

**state —** DRAFT/IN_REVIEW/APPROVED/SCHEDULED/PUBLISHED/SUPERSEDED/VOID/SUSPENDED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PUBLISHED.

**workflow_ref —** Workflow de publicación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**content_hash —** Hash canónico. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**published_at —** Publish UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**published_by_subject —** Publisher. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                        | **Tipo** | **Definición/expresión**                                                                                        | **Error que impide**    |
|------------------------------------------|----------|-----------------------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec03_scholarship_version**          | PK       | (tenant_id, scholarship_version_id)                                                                             | Identidad/cruce tenant. |
| **uq_ec03_scholarship_version_no**       | UQ       | (tenant_id, scholarship_program_id, version_no)                                                                 | Versión duplicada.      |
| **uq_ec03_scholarship_single_published** | UQ_INDEX | (tenant_id, scholarship_program_id) WHERE state='PUBLISHED'                                                     | Más de una vigente.     |
| **fk_ec03_scholarship_version_program**  | FK       | (tenant_id, scholarship_program_id) REFERENCES ec03.ec03_scholarship_program(tenant_id, scholarship_program_id) | Versión huérfana.       |
| **ck_ec03_scholarship_version_dates**    | CHECK    | valid_to IS NULL OR valid_to \> valid_from                                                                      | Vigencia inválida.      |
| **ck_ec03_scholarship_version_state**    | CHECK    | state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID','SUSPENDED')               | Estado inválido.        |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Versión duplicada.; Más de una vigente.; Versión huérfana.; Vigencia inválida.; Estado inválido. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.17 ec03_scholarship_benefit

**QUÉ REPRESENTA —** Beneficio económico definido por ScholarshipVersion: porcentaje, monto fijo, precio especial o componente bonificado.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija evaluada cuando ScholarshipAward se aplica a una quote. El beneficio real aplicado se materializa como QuoteAdjustment con source SCHOLARSHIP.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege coherencia de percent/monto/moneda y caps. No decide elegibilidad.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| scholarship_benefit_id | uuid                | NO       | gen_random_uuid() | PK        | ID beneficio.                                                                    | sb…               |
| scholarship_version_id | uuid                | NO       | —                 | FK        | Versión padre.                                                                   | sv…               |
| benefit_type           | varchar(32)         | NO       | —                 | CHECK     | PERCENT/FIXED/PRICE_OVERRIDE/FREE_COMPONENT.                                     | PERCENT           |
| percent_value          | numeric(9,4)        | YES      | NULL              | CHECK     | Porcentaje cuando aplica.                                                        | 50.0000           |
| amount_value           | numeric(19,4)       | YES      | NULL              | CHECK     | Monto cuando aplica.                                                             | 600.0000          |
| currency_code          | char(3)             | YES      | NULL              | CHECK     | Moneda para montos.                                                              | BOB               |
| max_benefit_amount     | numeric(19,4)       | YES      | NULL              | CHECK     | Cap opcional.                                                                    | 1000.0000         |
| target_component_code  | varchar(64)         | YES      | NULL              | —         | Componente específico opcional.                                                  | TUITION           |
| created_at             | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**scholarship_benefit_id —** ID beneficio. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sb….

**scholarship_version_id —** Versión padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: sv….

**benefit_type —** PERCENT/FIXED/PRICE_OVERRIDE/FREE_COMPONENT. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PERCENT.

**percent_value —** Porcentaje cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 50.0000.

**amount_value —** Monto cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 600.0000.

**currency_code —** Moneda para montos. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: BOB.

**max_benefit_amount —** Cap opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1000.0000.

**target_component_code —** Componente específico opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: TUITION.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                       | **Tipo** | **Definición/expresión**                                                                                                                                                                                                                                                                                                                                | **Error que impide**    |
|-----------------------------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec03_scholarship_benefit**         | PK       | (tenant_id, scholarship_benefit_id)                                                                                                                                                                                                                                                                                                                     | Identidad/cruce tenant. |
| **fk_ec03_scholarship_benefit_version** | FK       | (tenant_id, scholarship_version_id) REFERENCES ec03.ec03_scholarship_version(tenant_id, scholarship_version_id)                                                                                                                                                                                                                                         | Beneficio huérfano.     |
| **ck_ec03_scholarship_benefit_type**    | CHECK    | benefit_type IN ('PERCENT','FIXED','PRICE_OVERRIDE','FREE_COMPONENT')                                                                                                                                                                                                                                                                                   | Tipo inválido.          |
| **ck_ec03_scholarship_benefit_values**  | CHECK    | (benefit_type='PERCENT' AND percent_value\>0 AND percent_value\<=100 AND amount_value IS NULL) OR (benefit_type IN ('FIXED','PRICE_OVERRIDE') AND amount_value\>=0 AND currency_code IS NOT NULL AND percent_value IS NULL) OR (benefit_type='FREE_COMPONENT' AND target_component_code IS NOT NULL AND percent_value IS NULL AND amount_value IS NULL) | Valores incompatibles.  |
| **ck_ec03_scholarship_benefit_cap**     | CHECK    | max_benefit_amount IS NULL OR max_benefit_amount \>= 0                                                                                                                                                                                                                                                                                                  | Cap negativo.           |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Beneficio huérfano.; Tipo inválido.; Valores incompatibles.; Cap negativo. |
|-----------------------------------------------------------------------------------------------------------------------------------------|

## 12.18 ec03_scholarship_award

**QUÉ REPRESENTA —** Decisión individual/comercial que adjudica una ScholarshipVersion a un subject y Offering, con evidencia de eligibility y workflow.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate operativo. CT-15 produce eligibility_decision_ref; CT-06 produce approval evidence; EC-03 registra award. EC-04/Quote Desk lo referencia al cotizar; Finance no se modifica hasta ChargeIntent.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege SoD, expiración, estado y referencias de evidencia. No duplica Person ni crea waiver contable.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**       |
|--------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| scholarship_award_id     | uuid                | NO       | gen_random_uuid() | PK               | ID adjudicación.                                                                 | award…            |
| scholarship_version_id   | uuid                | NO       | —                 | FK               | Versión adjudicada.                                                              | sv…               |
| subject_ref              | uuid                | NO       | —                 | EXT REF CT-04    | Persona canónica beneficiaria.                                                   | person…           |
| offering_ref             | uuid                | NO       | —                 | EXT REF EC-02    | Offering para la que aplica.                                                     | off…              |
| eligibility_decision_ref | uuid                | NO       | —                 | EXT REF CT-15    | Decisión trazable de elegibilidad.                                               | ed…               |
| workflow_ref             | uuid                | YES      | NULL              | EXT REF CT-06    | Approval case.                                                                   | wf…               |
| evidence_pack_ref        | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidence pack.                                                                   | ev…               |
| state                    | varchar(24)         | NO       | 'PROPOSED'        | CHECK            | PROPOSED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/REVOKED/EXPIRED.                 | APPROVED          |
| approved_at              | timestamptz         | YES      | NULL              | —                | Aprobación UTC.                                                                  | …                 |
| approved_by_subject      | uuid                | YES      | NULL              | EXT REF IAM      | Aprobador.                                                                       | usr…              |
| expires_at               | timestamptz         | YES      | NULL              | CHECK            | Vencimiento del award antes de aplicación.                                       | …                 |
| reason_code              | varchar(80)         | NO       | —                 | —                | Motivo estable.                                                                  | MERIT_APPROVED    |
| created_by_subject       | uuid                | NO       | —                 | EXT REF IAM      | Actor que propone.                                                               | usr…              |
| created_at               | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at               | timestamptz         | NO       | now()             | —                | Última modificación autorizada.                                                  | 2026-09-09T15:30Z |
| version                  | bigint              | NO       | 0                 | —                | Revisión optimista observable mediante ETag/If-Match.                            | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**scholarship_award_id —** ID adjudicación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: award….

**scholarship_version_id —** Versión adjudicada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: sv….

**subject_ref —** Persona canónica beneficiaria. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**offering_ref —** Offering para la que aplica. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**eligibility_decision_ref —** Decisión trazable de elegibilidad. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ed….

**workflow_ref —** Approval case. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**evidence_pack_ref —** Evidence pack. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**state —** PROPOSED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/REVOKED/EXPIRED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PROPOSED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: APPROVED.

**approved_at —** Aprobación UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**approved_by_subject —** Aprobador. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**expires_at —** Vencimiento del award antes de aplicación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**reason_code —** Motivo estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: MERIT_APPROVED.

**created_by_subject —** Actor que propone. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                     | **Tipo** | **Definición/expresión**                                                                                        | **Error que impide**                 |
|---------------------------------------|----------|-----------------------------------------------------------------------------------------------------------------|--------------------------------------|
| **pk_ec03_scholarship_award**         | PK       | (tenant_id, scholarship_award_id)                                                                               | Identidad/cruce tenant.              |
| **fk_ec03_scholarship_award_version** | FK       | (tenant_id, scholarship_version_id) REFERENCES ec03.ec03_scholarship_version(tenant_id, scholarship_version_id) | Award a versión inexistente.         |
| **ck_ec03_scholarship_award_state**   | CHECK    | state IN ('PROPOSED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','REVOKED','EXPIRED')                        | Estado inválido.                     |
| **ix_ec03_scholarship_award_subject** | INDEX    | (tenant_id, subject_ref, offering_ref, state)                                                                   | Lookup ineficiente por beneficiario. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Award a versión inexistente.; Estado inválido.; Lookup ineficiente por beneficiario. |
|---------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.19 ec03_agreement_benefit_profile

**QUÉ REPRESENTA —** Proyección comercial versionada de beneficios derivados de un convenio/contrato cuyo Source of Truth permanece en EC-09/CT-05.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate local de lectura/uso comercial. Se activa solo con agreement_ref válido y evidence/document refs; QuoteEngine aplica sus rules. Cambios del convenio crean nueva profile_version.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege pinning y temporalidad del beneficio sin copiar el contrato completo. No es dueño de la relación corporativa.

| **Campo**                    | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|------------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                    | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| agreement_benefit_profile_id | uuid                | NO       | gen_random_uuid() | PK            | ID perfil.                                                                       | abp…              |
| agreement_ref                | uuid                | NO       | —                 | EXT REF EC-09 | Convenio/Commercial Agreement externo.                                           | agr…              |
| profile_version              | integer             | NO       | 1                 | UQ/CHECK      | Versión local monotónica por agreement.                                          | 2                 |
| source_document_ref          | uuid                | YES      | NULL              | EXT REF CT-05 | Documento/evidencia fuente.                                                      | doc…              |
| valid_from                   | timestamptz         | NO       | —                 | CHECK         | Inicio vigencia.                                                                 | …                 |
| valid_to                     | timestamptz         | YES      | NULL              | CHECK         | Fin opcional.                                                                    | …                 |
| state                        | varchar(20)         | NO       | 'DRAFT'           | CHECK         | DRAFT/ACTIVE/SUSPENDED/RETIRED/VOID.                                             | ACTIVE            |
| content_hash                 | varchar(128)        | NO       | —                 | —             | Hash canónico de rules/provenance.                                               | sha256:…          |
| activated_at                 | timestamptz         | YES      | NULL              | —             | Activación.                                                                      | …                 |
| activated_by_subject         | uuid                | YES      | NULL              | EXT REF IAM   | Actor autorizado.                                                                | usr…              |
| created_at                   | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at                   | timestamptz         | NO       | now()             | —             | Última modificación autorizada.                                                  | 2026-09-09T15:30Z |
| version                      | bigint              | NO       | 0                 | —             | Revisión optimista observable mediante ETag/If-Match.                            | 4                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**agreement_benefit_profile_id —** ID perfil. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: abp….

**agreement_ref —** Convenio/Commercial Agreement externo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: agr….

**profile_version —** Versión local monotónica por agreement. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 2.

**source_document_ref —** Documento/evidencia fuente. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: doc….

**valid_from —** Inicio vigencia. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**valid_to —** Fin opcional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**state —** DRAFT/ACTIVE/SUSPENDED/RETIRED/VOID. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ACTIVE.

**content_hash —** Hash canónico de rules/provenance. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**activated_at —** Activación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**activated_by_subject —** Actor autorizado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 4.

### Constraints físicos implementables

| **Nombre físico**                             | **Tipo** | **Definición/expresión**                                 | **Error que impide**    |
|-----------------------------------------------|----------|----------------------------------------------------------|-------------------------|
| **pk_ec03_agreement_benefit_profile**         | PK       | (tenant_id, agreement_benefit_profile_id)                | Identidad/cruce tenant. |
| **uq_ec03_agreement_benefit_profile_version** | UQ       | (tenant_id, agreement_ref, profile_version)              | Versión duplicada.      |
| **ck_ec03_agreement_profile_version**         | CHECK    | profile_version \> 0                                     | Versión inválida.       |
| **ck_ec03_agreement_profile_dates**           | CHECK    | valid_to IS NULL OR valid_to \> valid_from               | Vigencia inválida.      |
| **ck_ec03_agreement_profile_state**           | CHECK    | state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED','VOID') | Estado inválido.        |
| **ix_ec03_agreement_profile_active**          | INDEX    | (tenant_id, agreement_ref, state, valid_from DESC)       | Lookup ineficiente.     |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Versión duplicada.; Versión inválida.; Vigencia inválida.; Estado inválido.; Lookup ineficiente. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.20 ec03_agreement_benefit_rule

**QUÉ REPRESENTA —** Regla cuantificable del perfil de beneficios de convenio: descuento, precio especial, componente gratuito o condición por volumen/segmento.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija de AgreementBenefitProfile. Se evalúa con QuoteContext y puede requerir CT-15; su resultado se registra como QuoteAdjustment source AGREEMENT.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege tipo, valores y prioridad; no modifica el contrato externo.

| **Campo**                    | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                  | **Ejemplo**       |
|------------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id                    | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| agreement_benefit_rule_id    | uuid                | NO       | gen_random_uuid() | PK            | ID regla.                                                                        | abr…              |
| agreement_benefit_profile_id | uuid                | NO       | —                 | FK            | Perfil padre.                                                                    | abp…              |
| rule_code                    | varchar(64)         | NO       | —                 | UQ            | Código local estable.                                                            | CORP15            |
| benefit_type                 | varchar(32)         | NO       | —                 | CHECK         | PERCENT/FIXED/PRICE_OVERRIDE/FREE_COMPONENT.                                     | PERCENT           |
| percent_value                | numeric(9,4)        | YES      | NULL              | CHECK         | Porcentaje.                                                                      | 15.0000           |
| amount_value                 | numeric(19,4)       | YES      | NULL              | CHECK         | Monto.                                                                           | 0.0000            |
| currency_code                | char(3)             | YES      | NULL              | CHECK         | Moneda cuando aplica.                                                            | BOB               |
| eligibility_rule_ref         | uuid                | YES      | NULL              | EXT REF CT-15 | Regla adicional.                                                                 | rule…             |
| target_component_code        | varchar(64)         | YES      | NULL              | —             | Componente target.                                                               | TUITION           |
| priority                     | integer             | NO       | 100               | CHECK         | Orden de aplicación.                                                             | 20                |
| created_at                   | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**agreement_benefit_rule_id —** ID regla. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: abr….

**agreement_benefit_profile_id —** Perfil padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: abp….

**rule_code —** Código local estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CORP15.

**benefit_type —** PERCENT/FIXED/PRICE_OVERRIDE/FREE_COMPONENT. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PERCENT.

**percent_value —** Porcentaje. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 15.0000.

**amount_value —** Monto. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 0.0000.

**currency_code —** Moneda cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: BOB.

**eligibility_rule_ref —** Regla adicional. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: rule….

**target_component_code —** Componente target. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: TUITION.

**priority —** Orden de aplicación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 100; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 20.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                                                                                                                                                                                                                                                                                                                | **Error que impide**    |
|-------------------------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec03_agreement_benefit_rule**  | PK       | (tenant_id, agreement_benefit_rule_id)                                                                                                                                                                                                                                                                                                                  | Identidad/cruce tenant. |
| **fk_ec03_agreement_rule_profile**  | FK       | (tenant_id, agreement_benefit_profile_id) REFERENCES ec03.ec03_agreement_benefit_profile(tenant_id, agreement_benefit_profile_id)                                                                                                                                                                                                                       | Regla huérfana.         |
| **uq_ec03_agreement_rule_code**     | UQ       | (tenant_id, agreement_benefit_profile_id, rule_code)                                                                                                                                                                                                                                                                                                    | Código duplicado.       |
| **ck_ec03_agreement_rule_type**     | CHECK    | benefit_type IN ('PERCENT','FIXED','PRICE_OVERRIDE','FREE_COMPONENT')                                                                                                                                                                                                                                                                                   | Tipo inválido.          |
| **ck_ec03_agreement_rule_values**   | CHECK    | (benefit_type='PERCENT' AND percent_value\>0 AND percent_value\<=100 AND amount_value IS NULL) OR (benefit_type IN ('FIXED','PRICE_OVERRIDE') AND amount_value\>=0 AND currency_code IS NOT NULL AND percent_value IS NULL) OR (benefit_type='FREE_COMPONENT' AND target_component_code IS NOT NULL AND percent_value IS NULL AND amount_value IS NULL) | Valores inválidos.      |
| **ck_ec03_agreement_rule_priority** | CHECK    | priority \>= 0                                                                                                                                                                                                                                                                                                                                          | Prioridad inválida.     |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Regla huérfana.; Código duplicado.; Tipo inválido.; Valores inválidos.; Prioridad inválida. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.21 ec03_commercial_quote

**QUÉ REPRESENTA —** Snapshot comercial explicable que fija para un contexto concreto qué precio, descuentos, becas, convenios, impuestos comerciales y políticas se evaluaron. ISSUE vuelve inmutable el snapshot.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate Root central del Quote Desk. Se calcula desde Offering/PriceBookVersion y ajustes aplicables; ISSUED puede aceptarse y originar ChargeIntent. Recalcular una quote emitida crea una nueva quote/lineage, no la sobrescribe.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege totales, moneda, customer ref, policy snapshots, expiración y content hash. No es factura, deuda, pago ni enrollment.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**     | **Descripción**                                                                        | **Ejemplo**       |
|---------------------------|---------------------|----------|-------------------|---------------|----------------------------------------------------------------------------------------|-------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*          | Tenant derivado del Security/TenantContext; participa en identidad física y RLS.       | 8a6…              |
| quote_id                  | uuid                | NO       | gen_random_uuid() | PK            | ID técnico de quote.                                                                   | q…                |
| quote_number              | varchar(64)         | NO       | —                 | UQ            | Número legible tenant-aware.                                                           | Q-2026-000123     |
| parent_quote_id           | uuid                | YES      | NULL              | FK            | Quote origen cuando es requote/supersede.                                              | q-prev…           |
| offering_ref              | uuid                | NO       | —                 | EXT REF EC-02 | Offering cotizada.                                                                     | off…              |
| customer_kind             | varchar(24)         | NO       | —                 | CHECK         | PERSON/CORPORATE/THIRD_PARTY/AGREEMENT.                                                | PERSON            |
| customer_ref              | uuid                | NO       | —                 | EXT REF       | Referencia al cliente/subject según kind.                                              | person…           |
| price_book_version_id     | uuid                | NO       | —                 | FK            | PriceBookVersion pinneada.                                                             | pbv…              |
| quote_context_hash        | varchar(128)        | NO       | —                 | —             | Hash del contexto comercial normalizado.                                               | sha256:…          |
| currency_code             | char(3)             | NO       | —                 | CHECK         | Moneda única de quote.                                                                 | BOB               |
| subtotal_amount           | numeric(19,4)       | NO       | 0                 | CHECK         | Suma bruta de líneas.                                                                  | 1200.0000         |
| discount_amount           | numeric(19,4)       | NO       | 0                 | CHECK         | Descuentos totales.                                                                    | 180.0000          |
| surcharge_amount          | numeric(19,4)       | NO       | 0                 | CHECK         | Recargos totales.                                                                      | 0.0000            |
| tax_amount                | numeric(19,4)       | NO       | 0                 | CHECK         | Componente impositivo comercial calculado según policy; Finance confirma hecho fiscal. | 0.0000            |
| total_due_amount          | numeric(19,4)       | NO       | 0                 | CHECK         | Total cotizado exacto.                                                                 | 1020.0000         |
| calculation_snapshot_json | jsonb               | NO       | '{}'::jsonb       | CHECK         | PricingTrace/snapshot determinista.                                                    | {"engine":"v1"}   |
| policy_snapshot_json      | jsonb               | NO       | '{}'::jsonb       | CHECK         | Policy refs/versiones usadas.                                                          | {"rounding":"…"}  |
| state                     | varchar(24)         | NO       | 'DRAFT'           | CHECK         | DRAFT/CALCULATED/ISSUED/ACCEPTED/EXPIRED/VOID/SUPERSEDED.                              | ISSUED            |
| issued_at                 | timestamptz         | YES      | NULL              | —             | Issue UTC.                                                                             | …                 |
| expires_at                | timestamptz         | YES      | NULL              | CHECK         | Expiración del precio ofrecido.                                                        | …                 |
| accepted_at               | timestamptz         | YES      | NULL              | —             | Aceptación UTC.                                                                        | …                 |
| content_hash              | varchar(128)        | YES      | NULL              | —             | Hash inmutable al ISSUE.                                                               | sha256:…          |
| created_by_subject        | uuid                | NO       | —                 | EXT REF IAM   | Actor/subject que crea.                                                                | usr…              |
| created_at                | timestamptz         | NO       | now()             | —             | Instante UTC de creación.                                                              | 2026-09-09T15:00Z |
| updated_at                | timestamptz         | NO       | now()             | —             | Última modificación autorizada.                                                        | 2026-09-09T15:30Z |
| version                   | bigint              | NO       | 0                 | —             | Revisión optimista observable mediante ETag/If-Match.                                  | 6                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**quote_id —** ID técnico de quote. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: q….

**quote_number —** Número legible tenant-aware. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Q-2026-000123.

**parent_quote_id —** Quote origen cuando es requote/supersede. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: q-prev….

**offering_ref —** Offering cotizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: off….

**customer_kind —** PERSON/CORPORATE/THIRD_PARTY/AGREEMENT. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PERSON.

**customer_ref —** Referencia al cliente/subject según kind. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: person….

**price_book_version_id —** PriceBookVersion pinneada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pbv….

**quote_context_hash —** Hash del contexto comercial normalizado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**currency_code —** Moneda única de quote. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: BOB.

**subtotal_amount —** Suma bruta de líneas. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1200.0000.

**discount_amount —** Descuentos totales. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 180.0000.

**surcharge_amount —** Recargos totales. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 0.0000.

**tax_amount —** Componente impositivo comercial calculado según policy; Finance confirma hecho fiscal. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 0.0000.

**total_due_amount —** Total cotizado exacto. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1020.0000.

**calculation_snapshot_json —** PricingTrace/snapshot determinista. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"engine":"v1"}.

**policy_snapshot_json —** Policy refs/versiones usadas. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"rounding":"…"}.

**state —** DRAFT/CALCULATED/ISSUED/ACCEPTED/EXPIRED/VOID/SUPERSEDED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ISSUED.

**issued_at —** Issue UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**expires_at —** Expiración del precio ofrecido. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**accepted_at —** Aceptación UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**content_hash —** Hash inmutable al ISSUE. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**created_by_subject —** Actor/subject que crea. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 6.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                                                                         | **Error que impide**                        |
|-------------------------------------|----------|------------------------------------------------------------------------------------------------------------------|---------------------------------------------|
| **pk_ec03_commercial_quote**        | PK       | (tenant_id, quote_id)                                                                                            | Identidad/cruce tenant.                     |
| **uq_ec03_commercial_quote_number** | UQ       | (tenant_id, quote_number)                                                                                        | Número duplicado.                           |
| **fk_ec03_quote_pricebook**         | FK       | (tenant_id, price_book_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_version_id)     | Quote sin price book válido.                |
| **fk_ec03_quote_parent**            | FK       | (tenant_id, parent_quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id)                          | Lineage cross-tenant.                       |
| **ck_ec03_quote_customer_kind**     | CHECK    | customer_kind IN ('PERSON','CORPORATE','THIRD_PARTY','AGREEMENT')                                                | Customer kind inválido.                     |
| **ck_ec03_quote_amounts**           | CHECK    | subtotal_amount\>=0 AND discount_amount\>=0 AND surcharge_amount\>=0 AND tax_amount\>=0 AND total_due_amount\>=0 | Monto negativo.                             |
| **ck_ec03_quote_total**             | CHECK    | total_due_amount = subtotal_amount - discount_amount + surcharge_amount + tax_amount                             | Total inconsistente.                        |
| **ck_ec03_quote_state**             | CHECK    | state IN ('DRAFT','CALCULATED','ISSUED','ACCEPTED','EXPIRED','VOID','SUPERSEDED')                                | Estado inválido.                            |
| **ck_ec03_quote_expiry**            | CHECK    | expires_at IS NULL OR issued_at IS NULL OR expires_at \> issued_at                                               | Expiración inválida.                        |
| **ck_ec03_quote_snapshots**         | CHECK    | jsonb_typeof(calculation_snapshot_json)='object' AND jsonb_typeof(policy_snapshot_json)='object'                 | Snapshots mal formados.                     |
| **ix_ec03_quote_customer**          | INDEX    | (tenant_id, customer_ref, created_at DESC)                                                                       | Búsqueda lenta por cliente.                 |
| **ix_ec03_quote_expiry**            | INDEX    | (tenant_id, expires_at) WHERE state='ISSUED'                                                                     | Expiraciones no procesables eficientemente. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Número duplicado.; Quote sin price book válido.; Lineage cross-tenant.; Customer kind inválido.; Monto negativo.; Total inconsistente.; Estado inválido.; Expiración inválida.; Snapshots mal formados.; Búsqueda lenta por cliente.; Expiraciones no procesables eficientemente. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.22 ec03_quote_line

**QUÉ REPRESENTA —** Línea monetaria que materializa un componente de la CommercialQuote, con cantidad, precio unitario, descuentos, impuestos y neto.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija del aggregate Quote. Se deriva de PriceComponent/PriceTier o línea adicional autorizada. Tras ISSUE es inmutable y forma parte del content hash.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege aritmética decimal y orden. No es línea de factura.

| **Campo**                 | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**              |
|---------------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|--------------------------|
| tenant_id                 | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                     |
| quote_line_id             | uuid                | NO       | gen_random_uuid() | PK        | ID línea.                                                                        | ql…                      |
| quote_id                  | uuid                | NO       | —                 | FK        | Quote padre.                                                                     | q…                       |
| source_price_component_id | uuid                | YES      | NULL              | FK        | Componente origen cuando existe.                                                 | pc…                      |
| line_code                 | varchar(64)         | NO       | —                 | UQ        | Código dentro de quote.                                                          | TUITION                  |
| line_type                 | varchar(24)         | NO       | —                 | CHECK     | BASE/OPTIONAL/FEE/MATERIAL/OTHER.                                                | BASE                     |
| description               | varchar(240)        | NO       | —                 | —         | Descripción congelada.                                                           | Derecho de participación |
| quantity                  | numeric(19,4)       | NO       | 1                 | CHECK     | Cantidad exacta \>0.                                                             | 1.0000                   |
| unit_amount               | numeric(19,4)       | NO       | 0                 | CHECK     | Precio unitario \>=0.                                                            | 1200.0000                |
| gross_amount              | numeric(19,4)       | NO       | 0                 | CHECK     | quantity\*unit_amount con rounding policy.                                       | 1200.0000                |
| discount_amount           | numeric(19,4)       | NO       | 0                 | CHECK     | Descuento en línea.                                                              | 180.0000                 |
| surcharge_amount          | numeric(19,4)       | NO       | 0                 | CHECK     | Recargo en línea.                                                                | 0.0000                   |
| tax_amount                | numeric(19,4)       | NO       | 0                 | CHECK     | Impuesto comercial calculado.                                                    | 0.0000                   |
| net_amount                | numeric(19,4)       | NO       | 0                 | CHECK     | Neto de línea.                                                                   | 1020.0000                |
| sequence_no               | integer             | NO       | —                 | CHECK/UQ  | Orden presentación.                                                              | 1                        |
| created_at                | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T15:00Z        |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**quote_line_id —** ID línea. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ql….

**quote_id —** Quote padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: q….

**source_price_component_id —** Componente origen cuando existe. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: pc….

**line_code —** Código dentro de quote. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: TUITION.

**line_type —** BASE/OPTIONAL/FEE/MATERIAL/OTHER. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: BASE.

**description —** Descripción congelada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: Derecho de participación.

**quantity —** Cantidad exacta \>0. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1.0000.

**unit_amount —** Precio unitario \>=0. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1200.0000.

**gross_amount —** quantity\*unit_amount con rounding policy. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1200.0000.

**discount_amount —** Descuento en línea. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 180.0000.

**surcharge_amount —** Recargo en línea. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 0.0000.

**tax_amount —** Impuesto comercial calculado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 0.0000.

**net_amount —** Neto de línea. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1020.0000.

**sequence_no —** Orden presentación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                | **Tipo** | **Definición/expresión**                                                                                                                    | **Error que impide**                 |
|----------------------------------|----------|---------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------|
| **pk_ec03_quote_line**           | PK       | (tenant_id, quote_line_id)                                                                                                                  | Identidad/cruce tenant.              |
| **fk_ec03_quote_line_quote**     | FK       | (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id)                                                            | Línea huérfana.                      |
| **fk_ec03_quote_line_component** | FK       | (tenant_id, source_price_component_id) REFERENCES ec03.ec03_price_component(tenant_id, price_component_id)                                  | Componente origen cross-tenant.      |
| **uq_ec03_quote_line_code**      | UQ       | (tenant_id, quote_id, line_code)                                                                                                            | Código línea duplicado.              |
| **uq_ec03_quote_line_order**     | UQ       | (tenant_id, quote_id, sequence_no)                                                                                                          | Orden duplicado.                     |
| **ck_ec03_quote_line_amounts**   | CHECK    | quantity\>0 AND unit_amount\>=0 AND gross_amount\>=0 AND discount_amount\>=0 AND surcharge_amount\>=0 AND tax_amount\>=0 AND net_amount\>=0 | Valores negativos/quantity inválida. |
| **ck_ec03_quote_line_total**     | CHECK    | net_amount = gross_amount - discount_amount + surcharge_amount + tax_amount                                                                 | Neto inconsistente.                  |
| **ck_ec03_quote_line_type**      | CHECK    | line_type IN ('BASE','OPTIONAL','FEE','MATERIAL','OTHER')                                                                                   | Tipo inválido.                       |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Línea huérfana.; Componente origen cross-tenant.; Código línea duplicado.; Orden duplicado.; Valores negativos/quantity inválida.; Neto inconsistente.; Tipo inválido. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.23 ec03_quote_adjustment

**QUÉ REPRESENTA —** Ajuste explicable aplicado a una quote por promoción, beca, convenio, override o policy. Preserva source, reason, orden y monto.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Entity hija de Quote. Cada source_ref se valida por contrato o FK local cuando corresponde; PricingTrace conserva el orden de stacking.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege provenance y aritmética. No es nota de crédito/débito financiera.

| **Campo**           | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**       |
|---------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id           | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| quote_adjustment_id | uuid                | NO       | gen_random_uuid() | PK               | ID ajuste.                                                                       | qa…               |
| quote_id            | uuid                | NO       | —                 | FK               | Quote padre.                                                                     | q…                |
| adjustment_type     | varchar(24)         | NO       | —                 | CHECK            | DISCOUNT/SURCHARGE/PRICE_OVERRIDE/WAIVER.                                        | DISCOUNT          |
| source_type         | varchar(24)         | NO       | —                 | CHECK            | PROMOTION/SCHOLARSHIP/AGREEMENT/OVERRIDE/POLICY.                                 | PROMOTION         |
| source_ref          | uuid                | NO       | —                 | EXT/LOCAL REF    | Referencia al hecho/regla que fundamenta.                                        | pa…               |
| reason_code         | varchar(80)         | NO       | —                 | —                | Reason code estable.                                                             | PROMO_EARLY       |
| amount_value        | numeric(19,4)       | NO       | 0                 | CHECK            | Impacto monetario absoluto \>=0.                                                 | 180.0000          |
| percent_value       | numeric(9,4)        | YES      | NULL              | CHECK            | Porcentaje informativo cuando aplica.                                            | 15.0000           |
| currency_code       | char(3)             | NO       | —                 | CHECK            | Moneda quote.                                                                    | BOB               |
| application_order   | integer             | NO       | —                 | CHECK/UQ         | Orden de stacking.                                                               | 1                 |
| evidence_ref        | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidencia si override/beca requiere.                                             | ev…               |
| created_at          | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**quote_adjustment_id —** ID ajuste. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: qa….

**quote_id —** Quote padre. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: q….

**adjustment_type —** DISCOUNT/SURCHARGE/PRICE_OVERRIDE/WAIVER. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: DISCOUNT.

**source_type —** PROMOTION/SCHOLARSHIP/AGREEMENT/OVERRIDE/POLICY. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PROMOTION.

**source_ref —** Referencia al hecho/regla que fundamenta. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: pa….

**reason_code —** Reason code estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PROMO_EARLY.

**amount_value —** Impacto monetario absoluto \>=0. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 180.0000.

**percent_value —** Porcentaje informativo cuando aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 15.0000.

**currency_code —** Moneda quote. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: BOB.

**application_order —** Orden de stacking. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: 1.

**evidence_ref —** Evidencia si override/beca requiere. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                                                    | **Error que impide**    |
|-------------------------------------|----------|---------------------------------------------------------------------------------------------|-------------------------|
| **pk_ec03_quote_adjustment**        | PK       | (tenant_id, quote_adjustment_id)                                                            | Identidad/cruce tenant. |
| **fk_ec03_quote_adjustment_quote**  | FK       | (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id)            | Ajuste huérfano.        |
| **ck_ec03_quote_adjustment_type**   | CHECK    | adjustment_type IN ('DISCOUNT','SURCHARGE','PRICE_OVERRIDE','WAIVER')                       | Tipo inválido.          |
| **ck_ec03_quote_adjustment_source** | CHECK    | source_type IN ('PROMOTION','SCHOLARSHIP','AGREEMENT','OVERRIDE','POLICY')                  | Source inválido.        |
| **ck_ec03_quote_adjustment_values** | CHECK    | amount_value\>=0 AND (percent_value IS NULL OR (percent_value\>=0 AND percent_value\<=100)) | Valor inválido.         |
| **uq_ec03_quote_adjustment_order**  | UQ       | (tenant_id, quote_id, application_order)                                                    | Orden duplicado.        |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Ajuste huérfano.; Tipo inválido.; Source inválido.; Valor inválido.; Orden duplicado. |
|----------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.24 ec03_override_request

**QUÉ REPRESENTA —** Solicitud gobernada para excepcionar pricing normal: descuento manual, precio final, precio de componente u otro ajuste. Nunca es un setter directo sobre quote.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate workflow-driven integrado con CT-06. Requiere reason, SoD/step-up según threshold y evidence. APPLIED genera QuoteAdjustment y nueva revisión/requote; no muta una quote ISSUED.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege approval trail, requested value y lifecycle. No autoriza al solicitante a autoaprobar.

| **Campo**            | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**          |
|----------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|----------------------|
| tenant_id            | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                 |
| override_request_id  | uuid                | NO       | gen_random_uuid() | PK               | ID solicitud.                                                                    | or…                  |
| quote_id             | uuid                | NO       | —                 | FK               | Quote afectada.                                                                  | q…                   |
| override_kind        | varchar(32)         | NO       | —                 | CHECK            | DISCOUNT/PERCENT/FINAL_PRICE/COMPONENT_PRICE/OTHER.                              | PERCENT              |
| requested_value_json | jsonb               | NO       | '{}'::jsonb       | CHECK            | Valor solicitado tipado.                                                         | {"percent":5}        |
| reason_code          | varchar(80)         | NO       | —                 | —                | Motivo institucional.                                                            | COMMERCIAL_EXCEPTION |
| reason_text          | text                | YES      | NULL              | —                | Justificación adicional, minimizada.                                             | Cliente estratégico… |
| workflow_ref         | uuid                | YES      | NULL              | EXT REF CT-06    | Workflow de autorización.                                                        | wf…                  |
| state                | varchar(24)         | NO       | 'DRAFT'           | CHECK            | DRAFT/SUBMITTED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/CANCELLED.                | APPROVED             |
| requested_by_subject | uuid                | NO       | —                 | EXT REF IAM      | Solicitante.                                                                     | usr…                 |
| approved_by_subject  | uuid                | YES      | NULL              | EXT REF IAM      | Aprobador diferente cuando SoD aplica.                                           | usr2…                |
| approved_at          | timestamptz         | YES      | NULL              | —                | Aprobación UTC.                                                                  | …                    |
| applied_at           | timestamptz         | YES      | NULL              | —                | Aplicación UTC.                                                                  | …                    |
| evidence_pack_ref    | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidence Pack.                                                                   | ev…                  |
| created_at           | timestamptz         | NO       | now()             | —                | Instante UTC de creación.                                                        | 2026-09-09T15:00Z    |
| updated_at           | timestamptz         | NO       | now()             | —                | Última modificación autorizada.                                                  | 2026-09-09T15:30Z    |
| version              | bigint              | NO       | 0                 | —                | Revisión optimista observable mediante ETag/If-Match.                            | 6                    |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**override_request_id —** ID solicitud. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: or….

**quote_id —** Quote afectada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: q….

**override_kind —** DISCOUNT/PERCENT/FINAL_PRICE/COMPONENT_PRICE/OTHER. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PERCENT.

**requested_value_json —** Valor solicitado tipado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"percent":5}.

**reason_code —** Motivo institucional. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: COMMERCIAL_EXCEPTION.

**reason_text —** Justificación adicional, minimizada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: Cliente estratégico….

**workflow_ref —** Workflow de autorización. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**state —** DRAFT/SUBMITTED/UNDER_REVIEW/APPROVED/REJECTED/APPLIED/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'DRAFT'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: APPROVED.

**requested_by_subject —** Solicitante. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**approved_by_subject —** Aprobador diferente cuando SoD aplica. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr2….

**approved_at —** Aprobación UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**applied_at —** Aplicación UTC. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**evidence_pack_ref —** Evidence Pack. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 6.

### Constraints físicos implementables

| **Nombre físico**            | **Tipo** | **Definición/expresión**                                                                  | **Error que impide**                                  |
|------------------------------|----------|-------------------------------------------------------------------------------------------|-------------------------------------------------------|
| **pk_ec03_override_request** | PK       | (tenant_id, override_request_id)                                                          | Identidad/cruce tenant.                               |
| **fk_ec03_override_quote**   | FK       | (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id)          | Override huérfano.                                    |
| **ck_ec03_override_kind**    | CHECK    | override_kind IN ('DISCOUNT','PERCENT','FINAL_PRICE','COMPONENT_PRICE','OTHER')           | Kind inválido.                                        |
| **ck_ec03_override_state**   | CHECK    | state IN ('DRAFT','SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','CANCELLED') | Estado inválido.                                      |
| **ck_ec03_override_payload** | CHECK    | jsonb_typeof(requested_value_json)='object'                                               | Payload mal formado.                                  |
| **ck_ec03_override_sod**     | CHECK    | approved_by_subject IS NULL OR approved_by_subject \<\> requested_by_subject              | Autoaprobación física básica cuando existe aprobador. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Override huérfano.; Kind inválido.; Estado inválido.; Payload mal formado.; Autoaprobación física básica cuando existe aprobador. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.25 ec03_charge_intent

**QUÉ REPRESENTA —** Comando comercial durable que solicita al Core Financiero materializar el efecto financiero derivado de una quote ACCEPTED. Es una intención, no el hecho contable.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate de integración. Se envía con idempotency key y correlation/causation. Si hay timeout después de envío, pasa UNKNOWN_EFFECT y solo reconciliation puede decidir retry.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege amount/currency/quote pinning, state y operation ref. No almacena deuda, invoice ni payment.

| **Campo**              | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**             | **Descripción**                                                                  | **Ejemplo**       |
|------------------------|---------------------|----------|-------------------|-----------------------|----------------------------------------------------------------------------------|-------------------|
| tenant_id              | uuid                | NO       | —                 | PK\*                  | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…              |
| charge_intent_id       | uuid                | NO       | gen_random_uuid() | PK                    | ID intención.                                                                    | ci…               |
| quote_id               | uuid                | NO       | —                 | FK                    | Quote ACCEPTED fuente.                                                           | q…                |
| financial_customer_ref | uuid                | NO       | —                 | EXT REF Finance       | Customer/account reconocido por Finance.                                         | fc…               |
| amount                 | numeric(19,4)       | NO       | —                 | CHECK                 | Monto exacto a materializar.                                                     | 1020.0000         |
| currency_code          | char(3)             | NO       | —                 | CHECK                 | Moneda.                                                                          | BOB               |
| due_date               | date                | YES      | NULL              | —                     | Fecha sugerida según policy/contrato.                                            | 2026-10-05        |
| concept_code           | varchar(80)         | NO       | —                 | EXT REF Finance/CT-02 | Concepto financiero acordado.                                                    | EC_ENROLLMENT     |
| state                  | varchar(24)         | NO       | 'CREATED'         | CHECK                 | CREATED/SENT/CONFIRMED/REJECTED/UNKNOWN_EFFECT/CANCELLED.                        | UNKNOWN_EFFECT    |
| idempotency_key        | varchar(160)        | NO       | —                 | UQ                    | Clave estable enviada a Finance.                                                 | idem…             |
| external_operation_ref | varchar(160)        | YES      | NULL              | EXT REF Finance       | ID/receipt remoto si conocido.                                                   | finop…            |
| sent_at                | timestamptz         | YES      | NULL              | —                     | Envío.                                                                           | …                 |
| confirmed_at           | timestamptz         | YES      | NULL              | —                     | Confirmación.                                                                    | …                 |
| last_reconciled_at     | timestamptz         | YES      | NULL              | —                     | Última reconciliación.                                                           | …                 |
| correlation_id         | uuid                | NO       | —                 | —                     | Correlation end-to-end.                                                          | corr…             |
| causation_id           | uuid                | YES      | NULL              | —                     | Comando/evento causal.                                                           | cause…            |
| created_at             | timestamptz         | NO       | now()             | —                     | Instante UTC de creación.                                                        | 2026-09-09T15:00Z |
| updated_at             | timestamptz         | NO       | now()             | —                     | Última modificación autorizada.                                                  | 2026-09-09T15:30Z |
| version                | bigint              | NO       | 0                 | —                     | Revisión optimista observable mediante ETag/If-Match.                            | 6                 |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**charge_intent_id —** ID intención. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ci….

**quote_id —** Quote ACCEPTED fuente. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: q….

**financial_customer_ref —** Customer/account reconocido por Finance. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: fc….

**amount —** Monto exacto a materializar. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Java utiliza BigDecimal y el cálculo prohíbe float/double. Ejemplo: 1020.0000.

**currency_code —** Moneda. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: BOB.

**due_date —** Fecha sugerida según policy/contrato. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 2026-10-05.

**concept_code —** Concepto financiero acordado. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: EC_ENROLLMENT.

**state —** CREATED/SENT/CONFIRMED/REJECTED/UNKNOWN_EFFECT/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'CREATED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: UNKNOWN_EFFECT.

**idempotency_key —** Clave estable enviada a Finance. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: idem….

**external_operation_ref —** ID/receipt remoto si conocido. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: finop….

**sent_at —** Envío. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**confirmed_at —** Confirmación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**last_reconciled_at —** Última reconciliación. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**correlation_id —** Correlation end-to-end. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**causation_id —** Comando/evento causal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cause….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 6.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                                         | **Error que impide**        |
|-------------------------------------|----------|----------------------------------------------------------------------------------|-----------------------------|
| **pk_ec03_charge_intent**           | PK       | (tenant_id, charge_intent_id)                                                    | Identidad/cruce tenant.     |
| **fk_ec03_charge_intent_quote**     | FK       | (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id) | Intent huérfano.            |
| **uq_ec03_charge_intent_idem**      | UQ       | (tenant_id, idempotency_key)                                                     | Doble efecto por retry.     |
| **ck_ec03_charge_intent_amount**    | CHECK    | amount \>= 0                                                                     | Monto negativo.             |
| **ck_ec03_charge_intent_state**     | CHECK    | state IN ('CREATED','SENT','CONFIRMED','REJECTED','UNKNOWN_EFFECT','CANCELLED')  | Estado inválido.            |
| **ix_ec03_charge_intent_reconcile** | INDEX    | (tenant_id, last_reconciled_at) WHERE state='UNKNOWN_EFFECT'                     | Reconciliación ineficiente. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Intent huérfano.; Doble efecto por retry.; Monto negativo.; Estado inválido.; Reconciliación ineficiente. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.26 ec03_financial_effect_receipt

**QUÉ REPRESENTA —** Receipt append-only de la respuesta/reconciliación del Core Financiero para un ChargeIntent. Conserva outcome, remote ref y hash mínimo de evidencia.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se crea al confirmar/rechazar/reconciliar un efecto. Nunca se actualiza ni elimina; múltiples receipts pueden documentar sucesivos checks sin alterar los anteriores.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege evidencia de integración. No copia el ledger ni la factura.

| **Campo**                   | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**     |
|-----------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|-----------------|
| tenant_id                   | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…            |
| financial_effect_receipt_id | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                      | fer…            |
| charge_intent_id            | uuid                | NO       | —                 | FK               | Intent fuente.                                                                   | ci…             |
| receipt_type                | varchar(32)         | NO       | —                 | CHECK            | ACK/CONFIRMED/REJECTED/RECONCILIATION.                                           | RECONCILIATION  |
| remote_operation_ref        | varchar(160)        | YES      | NULL              | EXT REF Finance  | ID remoto.                                                                       | finop…          |
| outcome_code                | varchar(80)         | NO       | —                 | —                | Outcome estable.                                                                 | FOUND_CONFIRMED |
| response_hash               | varchar(128)        | YES      | NULL              | —                | Hash de respuesta canónica/evidence.                                             | sha256:…        |
| evidence_ref                | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidence Pack.                                                                   | ev…             |
| occurred_at                 | timestamptz         | NO       | —                 | —                | Momento remoto conocido.                                                         | …               |
| recorded_at                 | timestamptz         | NO       | now()             | —                | Momento local de registro.                                                       | …               |
| correlation_id              | uuid                | NO       | —                 | —                | Correlation.                                                                     | corr…           |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**financial_effect_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: fer….

**charge_intent_id —** Intent fuente. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. La FK es interna al bounded context, tenant-aware y debe impedir cruces de scope. Ejemplo: ci….

**receipt_type —** ACK/CONFIRMED/REJECTED/RECONCILIATION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: RECONCILIATION.

**remote_operation_ref —** ID remoto. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: finop….

**outcome_code —** Outcome estable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: FOUND_CONFIRMED.

**response_hash —** Hash de respuesta canónica/evidence. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: sha256:….

**evidence_ref —** Evidence Pack. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**occurred_at —** Momento remoto conocido. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**recorded_at —** Momento local de registro. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

### Constraints físicos implementables

| **Nombre físico**                    | **Tipo** | **Definición/expresión**                                                                      | **Error que impide**         |
|--------------------------------------|----------|-----------------------------------------------------------------------------------------------|------------------------------|
| **pk_ec03_financial_effect_receipt** | PK       | (tenant_id, financial_effect_receipt_id)                                                      | Identidad/cruce tenant.      |
| **fk_ec03_financial_receipt_intent** | FK       | (tenant_id, charge_intent_id) REFERENCES ec03.ec03_charge_intent(tenant_id, charge_intent_id) | Receipt huérfano.            |
| **ck_ec03_financial_receipt_type**   | CHECK    | receipt_type IN ('ACK','CONFIRMED','REJECTED','RECONCILIATION')                               | Tipo inválido.               |
| **ix_ec03_financial_receipt_intent** | INDEX    | (tenant_id, charge_intent_id, recorded_at)                                                    | Consulta de historial lenta. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Receipt huérfano.; Tipo inválido.; Consulta de historial lenta. |
|------------------------------------------------------------------------------------------------------------------------------|

## 12.27 ec03_publication_receipt

**QUÉ REPRESENTA —** Evidencia append-only de publicación/activación de PriceBookVersion, PromotionVersion o ScholarshipVersion.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Se escribe en la misma transacción que la transición local y outbox. Incluye target tipado, content hash, policy snapshot, actor y canonical schema version.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege reconstructibilidad histórica. No sustituye auditoría CT-10 ni documentos CT-05.

| **Campo**                | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK**        | **Descripción**                                                                  | **Ejemplo**        |
|--------------------------|---------------------|----------|-------------------|------------------|----------------------------------------------------------------------------------|--------------------|
| tenant_id                | uuid                | NO       | —                 | PK\*             | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…               |
| publication_receipt_id   | uuid                | NO       | gen_random_uuid() | PK               | ID receipt.                                                                      | pr…                |
| target_type              | varchar(32)         | NO       | —                 | CHECK            | PRICE_BOOK_VERSION/PROMOTION_VERSION/SCHOLARSHIP_VERSION.                        | PRICE_BOOK_VERSION |
| target_id                | uuid                | NO       | —                 | —                | ID local target.                                                                 | pbv…               |
| content_hash             | varchar(128)        | NO       | —                 | —                | Hash canónico.                                                                   | sha256:…           |
| hash_algorithm           | varchar(24)         | NO       | 'SHA-256'         | —                | Algoritmo.                                                                       | SHA-256            |
| canonical_schema_version | varchar(40)         | NO       | —                 | —                | Versión del canonicalizer.                                                       | ec03-pricebook-v1  |
| policy_snapshot_json     | jsonb               | NO       | '{}'::jsonb       | CHECK            | Policies/versiones aplicadas.                                                    | {"policy":"v3"}    |
| published_by_subject     | uuid                | NO       | —                 | EXT REF IAM      | Actor publisher.                                                                 | usr…               |
| assurance_level_code     | varchar(40)         | YES      | NULL              | EXT REF IAM      | Nivel de assurance/step-up.                                                      | AAL2               |
| workflow_ref             | uuid                | YES      | NULL              | EXT REF CT-06    | Workflow que sustenta.                                                           | wf…                |
| evidence_ref             | uuid                | YES      | NULL              | EXT REF CT-05/10 | Evidence Pack.                                                                   | ev…                |
| recorded_at              | timestamptz         | NO       | now()             | —                | Registro UTC.                                                                    | …                  |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**publication_receipt_id —** ID receipt. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pr….

**target_type —** PRICE_BOOK_VERSION/PROMOTION_VERSION/SCHOLARSHIP_VERSION. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: PRICE_BOOK_VERSION.

**target_id —** ID local target. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: pbv….

**content_hash —** Hash canónico. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**hash_algorithm —** Algoritmo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'SHA-256'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: SHA-256.

**canonical_schema_version —** Versión del canonicalizer. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: ec03-pricebook-v1.

**policy_snapshot_json —** Policies/versiones aplicadas. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es '{}'::jsonb; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"policy":"v3"}.

**published_by_subject —** Actor publisher. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: usr….

**assurance_level_code —** Nivel de assurance/step-up. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: AAL2.

**workflow_ref —** Workflow que sustenta. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: wf….

**evidence_ref —** Evidence Pack. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Es referencia cross-context, validada por port/contract y sin FK física hacia otro bounded context. Ejemplo: ev….

**recorded_at —** Registro UTC. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

### Constraints físicos implementables

| **Nombre físico**                           | **Tipo** | **Definición/expresión**                                                        | **Error que impide**          |
|---------------------------------------------|----------|---------------------------------------------------------------------------------|-------------------------------|
| **pk_ec03_publication_receipt**             | PK       | (tenant_id, publication_receipt_id)                                             | Identidad/cruce tenant.       |
| **ck_ec03_publication_receipt_target**      | CHECK    | target_type IN ('PRICE_BOOK_VERSION','PROMOTION_VERSION','SCHOLARSHIP_VERSION') | Target inválido.              |
| **ck_ec03_publication_receipt_policy**      | CHECK    | jsonb_typeof(policy_snapshot_json)='object'                                     | Snapshot mal formado.         |
| **uq_ec03_publication_receipt_target_hash** | UQ       | (tenant_id, target_type, target_id, content_hash)                               | Receipt duplicado accidental. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Target inválido.; Snapshot mal formado.; Receipt duplicado accidental. |
|-------------------------------------------------------------------------------------------------------------------------------------|

## 12.28 ec03_command_idempotency

**QUÉ REPRESENTA —** Registro durable de idempotencia para comandos sensibles: publish, promo reservation, quote issue/accept, award approval, override apply y ChargeIntent.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Infraestructura local del bounded context. La adquisición crea IN_PROGRESS con owner/lease; replays same-key/same-payload devuelven el mismo resultado; payload diferente devuelve 409.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege contra duplicación por retry/crash. No es cache Redis y no puede depender de TTL volátil.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**          |
|-----------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|----------------------|
| tenant_id       | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                 |
| idempotency_id  | uuid                | NO       | gen_random_uuid() | PK        | ID registro.                                                                     | idemrec…             |
| idempotency_key | varchar(160)        | NO       | —                 | UQ        | Clave cliente/comando.                                                           | idem…                |
| command_name    | varchar(120)        | NO       | —                 | —         | Nombre estable de comando.                                                       | IssueCommercialQuote |
| request_hash    | varchar(128)        | NO       | —                 | —         | Hash canonical request.                                                          | sha256:…             |
| state           | varchar(24)         | NO       | 'IN_PROGRESS'     | CHECK     | IN_PROGRESS/SUCCEEDED/FAILED_RECOVERABLE/FAILED_FINAL.                           | SUCCEEDED            |
| owner_id        | varchar(120)        | YES      | NULL              | —         | Worker/instance owner actual.                                                    | pod-7                |
| lease_until     | timestamptz         | YES      | NULL              | CHECK     | Lease de IN_PROGRESS.                                                            | …                    |
| response_status | integer             | YES      | NULL              | CHECK     | HTTP/status semántico cacheado.                                                  | 201                  |
| response_json   | jsonb               | YES      | NULL              | CHECK     | Respuesta durable acotada.                                                       | {"quoteId":"…"}      |
| resource_ref    | varchar(200)        | YES      | NULL              | —         | Recurso creado/afectado.                                                         | quote:q…             |
| last_error_code | varchar(100)        | YES      | NULL              | —         | Último reason code.                                                              | FINANCE_TIMEOUT      |
| created_at      | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T15:00Z    |
| updated_at      | timestamptz         | NO       | now()             | —         | Última modificación autorizada.                                                  | 2026-09-09T15:30Z    |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**idempotency_id —** ID registro. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: idemrec….

**idempotency_key —** Clave cliente/comando. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: idem….

**command_name —** Nombre estable de comando. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: IssueCommercialQuote.

**request_hash —** Hash canonical request. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**state —** IN_PROGRESS/SUCCEEDED/FAILED_RECOVERABLE/FAILED_FINAL. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'IN_PROGRESS'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: SUCCEEDED.

**owner_id —** Worker/instance owner actual. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pod-7.

**lease_until —** Lease de IN_PROGRESS. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**response_status —** HTTP/status semántico cacheado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 201.

**response_json —** Respuesta durable acotada. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"quoteId":"…"}.

**resource_ref —** Recurso creado/afectado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: quote:q….

**last_error_code —** Último reason code. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: FINANCE_TIMEOUT.

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

### Constraints físicos implementables

| **Nombre físico**                   | **Tipo** | **Definición/expresión**                                                   | **Error que impide**                            |
|-------------------------------------|----------|----------------------------------------------------------------------------|-------------------------------------------------|
| **pk_ec03_command_idempotency**     | PK       | (tenant_id, idempotency_id)                                                | Identidad/cruce tenant.                         |
| **uq_ec03_command_idempotency_key** | UQ       | (tenant_id, idempotency_key)                                               | Key duplicada.                                  |
| **ck_ec03_idempotency_state**       | CHECK    | state IN ('IN_PROGRESS','SUCCEEDED','FAILED_RECOVERABLE','FAILED_FINAL')   | Estado inválido.                                |
| **ck_ec03_idempotency_response**    | CHECK    | response_status IS NULL OR (response_status BETWEEN 100 AND 599)           | Status inválido.                                |
| **ck_ec03_idempotency_payload**     | CHECK    | response_json IS NULL OR jsonb_typeof(response_json) IN ('object','array') | Response mal formada.                           |
| **ix_ec03_idempotency_recovery**    | INDEX    | (tenant_id, lease_until) WHERE state='IN_PROGRESS'                         | Leases vencidos no recuperables eficientemente. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Key duplicada.; Estado inválido.; Status inválido.; Response mal formada.; Leases vencidos no recuperables eficientemente. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.29 ec03_outbox_event

**QUÉ REPRESENTA —** Evento de integración persistido en la misma transacción que el hecho de negocio. Implementa at-least-once con claim/lease y delivery observable.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Infrastructure entity. Dispatcher multi-instancia usa FOR UPDATE SKIP LOCKED, owner/lease, backoff y dead-letter/replay gobernado.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege que commit de negocio no dependa de publish remoto en línea. No promete exactly-once distribuido.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**              |
|-----------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|--------------------------|
| tenant_id       | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                     |
| event_id        | uuid                | NO       | gen_random_uuid() | PK        | ID evento/message id.                                                            | evt…                     |
| aggregate_type  | varchar(100)        | NO       | —                 | —         | Tipo aggregate.                                                                  | CommercialQuote          |
| aggregate_id    | uuid                | NO       | —                 | —         | ID aggregate.                                                                    | q…                       |
| event_type      | varchar(160)        | NO       | —                 | —         | Nombre evento versionable.                                                       | CommercialQuoteIssued.v1 |
| schema_version  | integer             | NO       | 1                 | CHECK     | Versión payload.                                                                 | 1                        |
| payload_json    | jsonb               | NO       | —                 | CHECK     | Payload contractual.                                                             | {"quoteId":"…"}          |
| correlation_id  | uuid                | NO       | —                 | —         | Correlation.                                                                     | corr…                    |
| causation_id    | uuid                | YES      | NULL              | —         | Causation.                                                                       | cause…                   |
| occurred_at     | timestamptz         | NO       | now()             | —         | Momento del hecho.                                                               | …                        |
| state           | varchar(20)         | NO       | 'PENDING'         | CHECK     | PENDING/IN_FLIGHT/DELIVERED/FAILED.                                              | PENDING                  |
| owner_id        | varchar(120)        | YES      | NULL              | —         | Dispatcher owner.                                                                | pod-1                    |
| lease_until     | timestamptz         | YES      | NULL              | —         | Lease de claim.                                                                  | …                        |
| attempt_count   | integer             | NO       | 0                 | CHECK     | Intentos.                                                                        | 2                        |
| next_attempt_at | timestamptz         | NO       | now()             | —         | Backoff.                                                                         | …                        |
| delivered_at    | timestamptz         | YES      | NULL              | —         | Delivery terminal.                                                               | …                        |
| last_error_code | varchar(100)        | YES      | NULL              | —         | Error estable.                                                                   | BROKER_TIMEOUT           |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**event_id —** ID evento/message id. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: evt….

**aggregate_type —** Tipo aggregate. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CommercialQuote.

**aggregate_id —** ID aggregate. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: q….

**event_type —** Nombre evento versionable. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: CommercialQuoteIssued.v1.

**schema_version —** Versión payload. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 1; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1.

**payload_json —** Payload contractual. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: {"quoteId":"…"}.

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**causation_id —** Causation. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: cause….

**occurred_at —** Momento del hecho. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**state —** PENDING/IN_FLIGHT/DELIVERED/FAILED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PENDING.

**owner_id —** Dispatcher owner. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pod-1.

**lease_until —** Lease de claim. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**attempt_count —** Intentos. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 2.

**next_attempt_at —** Backoff. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**delivered_at —** Delivery terminal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**last_error_code —** Error estable. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: BROKER_TIMEOUT.

### Constraints físicos implementables

| **Nombre físico**           | **Tipo** | **Definición/expresión**                                                      | **Error que impide**          |
|-----------------------------|----------|-------------------------------------------------------------------------------|-------------------------------|
| **pk_ec03_outbox_event**    | PK       | (tenant_id, event_id)                                                         | Identidad/cruce tenant.       |
| **ck_ec03_outbox_schema**   | CHECK    | schema_version \> 0                                                           | Schema version inválida.      |
| **ck_ec03_outbox_payload**  | CHECK    | jsonb_typeof(payload_json)='object'                                           | Payload inválido.             |
| **ck_ec03_outbox_state**    | CHECK    | state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED')                         | Estado inválido.              |
| **ck_ec03_outbox_attempts** | CHECK    | attempt_count \>= 0                                                           | Intentos negativos.           |
| **ix_ec03_outbox_claim**    | INDEX    | (tenant_id, next_attempt_at, occurred_at) WHERE state IN ('PENDING','FAILED') | Claim ineficiente.            |
| **ix_ec03_outbox_reclaim**  | INDEX    | (tenant_id, lease_until) WHERE state='IN_FLIGHT'                              | Lease perdido no recuperable. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Schema version inválida.; Payload inválido.; Estado inválido.; Intentos negativos.; Claim ineficiente.; Lease perdido no recuperable. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 12.30 ec03_inbox_message

**QUÉ REPRESENTA —** Registro durable de deduplicación y procesamiento de integration messages/comandos entrantes.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Infrastructure entity. Se inserta por message_id antes de aplicar handler; duplicates obtienen el resultado existente. PROCESSING puede recuperarse según policy.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege side effects duplicados. No reemplaza el event store de otro bounded context.

| **Campo**       | **Tipo PostgreSQL** | **Null** | **Default** | **PK/FK** | **Descripción**                                                                  | **Ejemplo**          |
|-----------------|---------------------|----------|-------------|-----------|----------------------------------------------------------------------------------|----------------------|
| tenant_id       | uuid                | NO       | —           | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                 |
| message_id      | uuid                | NO       | —           | PK        | ID global del mensaje.                                                           | msg…                 |
| source_context  | varchar(80)         | NO       | —           | —         | Context emisor.                                                                  | EC02                 |
| message_type    | varchar(160)        | NO       | —           | —         | Tipo/version.                                                                    | OfferingPublished.v1 |
| payload_hash    | varchar(128)        | NO       | —           | —         | Hash para detectar same-id/different-payload.                                    | sha256:…             |
| state           | varchar(20)         | NO       | 'RECEIVED'  | CHECK     | RECEIVED/PROCESSING/PROCESSED/FAILED.                                            | PROCESSED            |
| received_at     | timestamptz         | NO       | now()       | —         | Recepción.                                                                       | …                    |
| processed_at    | timestamptz         | YES      | NULL        | —         | Fin proceso.                                                                     | …                    |
| last_error_code | varchar(100)        | YES      | NULL        | —         | Error.                                                                           | CONTRACT_INVALID     |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**message_id —** ID global del mensaje. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: msg….

**source_context —** Context emisor. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: EC02.

**message_type —** Tipo/version. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: OfferingPublished.v1.

**payload_hash —** Hash para detectar same-id/different-payload. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: sha256:….

**state —** RECEIVED/PROCESSING/PROCESSED/FAILED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'RECEIVED'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: PROCESSED.

**received_at —** Recepción. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**processed_at —** Fin proceso. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**last_error_code —** Error. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: CONTRACT_INVALID.

### Constraints físicos implementables

| **Nombre físico**         | **Tipo** | **Definición/expresión**                                | **Error que impide**         |
|---------------------------|----------|---------------------------------------------------------|------------------------------|
| **pk_ec03_inbox_message** | PK       | (tenant_id, message_id)                                 | Dedup tenant-aware.          |
| **ck_ec03_inbox_state**   | CHECK    | state IN ('RECEIVED','PROCESSING','PROCESSED','FAILED') | Estado inválido.             |
| **ix_ec03_inbox_state**   | INDEX    | (tenant_id, state, received_at)                         | Reprocesamiento ineficiente. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Dedup tenant-aware.; Estado inválido.; Reprocesamiento ineficiente. |
|---------------------------------------------------------------------------------------------------------|

## 12.31 ec03_operation_status

**QUÉ REPRESENTA —** Estado consultable de operaciones asíncronas 202 como generación masiva de códigos, imports, recálculos masivos o reconciliaciones.

**CÓMO PARTICIPA ARQUITECTÓNICAMENTE —** Aggregate técnico expuesto por GET /operations/{id}. El frontend nunca interpreta 202 como efecto confirmado; hace polling/backoff o recibe notificación.

**QUÉ PROTEGE / QUÉ NO REPRESENTA —** Protege lifecycle asíncrono y UNKNOWN_EFFECT. No reemplaza idempotency ni outbox.

| **Campo**        | **Tipo PostgreSQL** | **Null** | **Default**       | **PK/FK** | **Descripción**                                                                  | **Ejemplo**          |
|------------------|---------------------|----------|-------------------|-----------|----------------------------------------------------------------------------------|----------------------|
| tenant_id        | uuid                | NO       | —                 | PK\*      | Tenant derivado del Security/TenantContext; participa en identidad física y RLS. | 8a6…                 |
| operation_id     | uuid                | NO       | gen_random_uuid() | PK        | ID operación.                                                                    | op…                  |
| operation_type   | varchar(100)        | NO       | —                 | —         | Tipo.                                                                            | GENERATE_PROMO_CODES |
| resource_ref     | varchar(200)        | YES      | NULL              | —         | Recurso asociado.                                                                | pool:…               |
| state            | varchar(24)         | NO       | 'PENDING'         | CHECK     | PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED.                       | RUNNING              |
| progress_current | bigint              | YES      | NULL              | CHECK     | Avance actual.                                                                   | 500                  |
| progress_total   | bigint              | YES      | NULL              | CHECK     | Total esperado.                                                                  | 1000                 |
| result_json      | jsonb               | YES      | NULL              | CHECK     | Resultado terminal acotado.                                                      | {"generated":1000}   |
| error_code       | varchar(100)        | YES      | NULL              | —         | Reason code terminal.                                                            | …                    |
| correlation_id   | uuid                | NO       | —                 | —         | Correlation.                                                                     | corr…                |
| started_at       | timestamptz         | YES      | NULL              | —         | Inicio.                                                                          | …                    |
| completed_at     | timestamptz         | YES      | NULL              | —         | Fin.                                                                             | …                    |
| created_at       | timestamptz         | NO       | now()             | —         | Instante UTC de creación.                                                        | 2026-09-09T15:00Z    |
| updated_at       | timestamptz         | NO       | now()             | —         | Última modificación autorizada.                                                  | 2026-09-09T15:30Z    |
| version          | bigint              | NO       | 0                 | —         | Revisión optimista observable mediante ETag/If-Match.                            | 6                    |

### Explicación individual de atributos

**tenant_id —** Tenant derivado del Security/TenantContext; participa en identidad física y RLS. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Nunca se acepta desde body libre; proviene del contexto autorizado y RLS aplica en cada query. Ejemplo: 8a6….

**operation_id —** ID operación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es gen_random_uuid(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: op….

**operation_type —** Tipo. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: GENERATE_PROMO_CODES.

**resource_ref —** Recurso asociado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: pool:….

**state —** PENDING/RUNNING/SUCCEEDED/FAILED/UNKNOWN_EFFECT/CANCELLED. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 'PENDING'; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: RUNNING.

**progress_current —** Avance actual. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 500.

**progress_total —** Total esperado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: 1000.

**result_json —** Resultado terminal acotado. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: {"generated":1000}.

**error_code —** Reason code terminal. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Ejemplo: ….

**correlation_id —** Correlation. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. Ejemplo: corr….

**started_at —** Inicio. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**completed_at —** Fin. Puede ser NULL únicamente cuando la ausencia tenga significado de negocio documentado; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es NULL; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: ….

**created_at —** Instante UTC de creación. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:00Z.

**updated_at —** Última modificación autorizada. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es now(); Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se persiste en UTC y la zona horaria se aplica solo en presentación. Ejemplo: 2026-09-09T15:30Z.

**version —** Revisión optimista observable mediante ETag/If-Match. Es obligatorio; NULL nunca debe interpretarse como cero, cadena vacía ni resultado favorable. El default físico es 0; Backend y Frontend deben respetar el contrato Flyway/OpenAPI. Se mapea con @Version; un ETag obsoleto debe devolver 412 PRECONDITION_FAILED. Ejemplo: 6.

### Constraints físicos implementables

| **Nombre físico**              | **Tipo** | **Definición/expresión**                                                                                                                     | **Error que impide**                               |
|--------------------------------|----------|----------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------|
| **pk_ec03_operation_status**   | PK       | (tenant_id, operation_id)                                                                                                                    | Identidad/cruce tenant.                            |
| **ck_ec03_operation_state**    | CHECK    | state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED')                                                             | Estado inválido.                                   |
| **ck_ec03_operation_progress** | CHECK    | (progress_current IS NULL AND progress_total IS NULL) OR (progress_current\>=0 AND progress_total\>=0 AND progress_current\<=progress_total) | Progreso incoherente.                              |
| **ck_ec03_operation_result**   | CHECK    | result_json IS NULL OR jsonb_typeof(result_json) IN ('object','array')                                                                       | Resultado inválido.                                |
| **ix_ec03_operation_active**   | INDEX    | (tenant_id, updated_at) WHERE state IN ('PENDING','RUNNING','UNKNOWN_EFFECT')                                                                | Operaciones activas no observables eficientemente. |

| **¿QUÉ DEBE IMPEDIR POSTGRESQL? —** Identidad/cruce tenant.; Estado inválido.; Progreso incoherente.; Resultado inválido.; Operaciones activas no observables eficientemente. |
|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 13. DDL PostgreSQL completo — Flyway Ready

El siguiente baseline es ejecutable como migración inicial del bounded context EC-03. Se organiza en schema, tablas, constraints, FKs internas tenant-aware, triggers defensivos, RLS y operational indexes. Los grants concretos se parametrizan por ambiente, pero la separación migrator/runtime/worker y NO BYPASSRLS es obligatoria.

| **CRITERIO FLYWAY —** Las migraciones productivas siguen expand/contract y compatibilidad N/N-1. Nunca se corrige historia editando una migration aplicada; toda evolución crea un nuevo archivo V2\_\_, V3\_\_ o repeatable controlado. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

-- V1\_\_ec03_commercial_foundation.sql

-- PeopleU IA \| EC-03 \| PostgreSQL 16+ \| Flyway Ready

CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE SCHEMA IF NOT EXISTS ec03;

CREATE OR REPLACE FUNCTION ec03.current_tenant_uuid() RETURNS uuid LANGUAGE sql STABLE AS \$\$ SELECT NULLIF(current_setting('peopleu.tenant_id', true), '')::uuid \$\$;

CREATE TABLE ec03.ec03_price_book_definition (

tenant_id uuid NOT NULL,

price_book_id uuid DEFAULT gen_random_uuid() NOT NULL,

price_book_code varchar(64) NOT NULL,

official_name varchar(200) NOT NULL,

owner_scope_ref uuid NOT NULL,

default_currency_code char(3) NOT NULL,

lifecycle_state varchar(24) DEFAULT 'DRAFT' NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_price_book_version (

tenant_id uuid NOT NULL,

price_book_version_id uuid DEFAULT gen_random_uuid() NOT NULL,

price_book_id uuid NOT NULL,

version_no integer NOT NULL,

previous_version_id uuid DEFAULT NULL,

valid_from timestamptz DEFAULT NULL,

valid_to timestamptz DEFAULT NULL,

rounding_policy_ref uuid NOT NULL,

tax_policy_ref uuid DEFAULT NULL,

calculation_policy_ref uuid NOT NULL,

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

CREATE TABLE ec03.ec03_price_component (

tenant_id uuid NOT NULL,

price_component_id uuid DEFAULT gen_random_uuid() NOT NULL,

price_book_version_id uuid NOT NULL,

component_code varchar(64) NOT NULL,

component_type_code varchar(64) NOT NULL,

display_name varchar(160) NOT NULL,

base_amount numeric(19,4) NOT NULL,

currency_code char(3) NOT NULL,

mandatory boolean DEFAULT true NOT NULL,

sequence_no integer NOT NULL,

refund_policy_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_price_tier (

tenant_id uuid NOT NULL,

price_tier_id uuid DEFAULT gen_random_uuid() NOT NULL,

price_component_id uuid NOT NULL,

min_quantity integer DEFAULT 1 NOT NULL,

max_quantity integer DEFAULT NULL,

unit_amount numeric(19,4) NOT NULL,

eligibility_rule_ref uuid DEFAULT NULL,

priority integer DEFAULT 100 NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_price_scope_binding (

tenant_id uuid NOT NULL,

price_scope_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,

price_book_version_id uuid NOT NULL,

scope_type varchar(32) NOT NULL,

scope_ref uuid DEFAULT NULL,

scope_code varchar(100) DEFAULT NULL,

effect varchar(16) DEFAULT 'INCLUDE' NOT NULL,

priority integer DEFAULT 100 NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_offering_price_binding (

tenant_id uuid NOT NULL,

offering_price_binding_id uuid DEFAULT gen_random_uuid() NOT NULL,

offering_ref uuid NOT NULL,

price_book_version_id uuid NOT NULL,

channel_code varchar(80) DEFAULT NULL,

valid_from timestamptz NOT NULL,

valid_to timestamptz DEFAULT NULL,

binding_state varchar(20) DEFAULT 'ACTIVE' NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_promotion_campaign (

tenant_id uuid NOT NULL,

promotion_campaign_id uuid DEFAULT gen_random_uuid() NOT NULL,

campaign_code varchar(64) NOT NULL,

official_name varchar(200) NOT NULL,

owner_scope_ref uuid NOT NULL,

lifecycle_state varchar(24) DEFAULT 'DRAFT' NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_promotion_version (

tenant_id uuid NOT NULL,

promotion_version_id uuid DEFAULT gen_random_uuid() NOT NULL,

promotion_campaign_id uuid NOT NULL,

version_no integer NOT NULL,

previous_version_id uuid DEFAULT NULL,

valid_from timestamptz NOT NULL,

valid_to timestamptz DEFAULT NULL,

eligibility_rule_ref uuid DEFAULT NULL,

stacking_policy_ref uuid NOT NULL,

budget_policy_ref uuid DEFAULT NULL,

priority integer DEFAULT 100 NOT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

workflow_ref uuid DEFAULT NULL,

content_hash varchar(128) DEFAULT NULL,

published_at timestamptz DEFAULT NULL,

published_by_subject uuid DEFAULT NULL,

superseded_by_version_id uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_promotion_condition (

tenant_id uuid NOT NULL,

promotion_condition_id uuid DEFAULT gen_random_uuid() NOT NULL,

promotion_version_id uuid NOT NULL,

condition_code varchar(64) NOT NULL,

condition_type varchar(40) NOT NULL,

operator_code varchar(32) NOT NULL,

operand_json jsonb DEFAULT '{}'::jsonb NOT NULL,

eligibility_rule_ref uuid DEFAULT NULL,

sequence_no integer NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_promotion_benefit (

tenant_id uuid NOT NULL,

promotion_benefit_id uuid DEFAULT gen_random_uuid() NOT NULL,

promotion_version_id uuid NOT NULL,

benefit_code varchar(64) NOT NULL,

benefit_type varchar(32) NOT NULL,

percent_value numeric(9,4) DEFAULT NULL,

amount_value numeric(19,4) DEFAULT NULL,

currency_code char(3) DEFAULT NULL,

max_discount_amount numeric(19,4) DEFAULT NULL,

target_component_code varchar(64) DEFAULT NULL,

sequence_no integer NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_promo_code_pool (

tenant_id uuid NOT NULL,

promo_code_pool_id uuid DEFAULT gen_random_uuid() NOT NULL,

promotion_version_id uuid NOT NULL,

pool_code varchar(64) NOT NULL,

prefix varchar(24) DEFAULT NULL,

token_length integer DEFAULT 12 NOT NULL,

max_codes integer NOT NULL,

generated_count integer DEFAULT 0 NOT NULL,

default_max_uses integer DEFAULT 1 NOT NULL,

expires_at timestamptz DEFAULT NULL,

state varchar(20) DEFAULT 'DRAFT' NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_promo_code (

tenant_id uuid NOT NULL,

promo_code_id uuid DEFAULT gen_random_uuid() NOT NULL,

promo_code_pool_id uuid NOT NULL,

token_hash varchar(128) NOT NULL,

token_last4 char(4) NOT NULL,

issued_to_ref uuid DEFAULT NULL,

max_uses integer DEFAULT 1 NOT NULL,

reserved_uses integer DEFAULT 0 NOT NULL,

redeemed_uses integer DEFAULT 0 NOT NULL,

expires_at timestamptz DEFAULT NULL,

state varchar(20) DEFAULT 'AVAILABLE' NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_promo_code_reservation (

tenant_id uuid NOT NULL,

promo_code_reservation_id uuid DEFAULT gen_random_uuid() NOT NULL,

promo_code_id uuid NOT NULL,

quote_id uuid DEFAULT NULL,

subject_ref uuid DEFAULT NULL,

idempotency_key varchar(160) NOT NULL,

reserved_at timestamptz DEFAULT now() NOT NULL,

lease_until timestamptz NOT NULL,

state varchar(20) DEFAULT 'RESERVED' NOT NULL,

consumed_at timestamptz DEFAULT NULL,

released_at timestamptz DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_promotion_application (

tenant_id uuid NOT NULL,

promotion_application_id uuid DEFAULT gen_random_uuid() NOT NULL,

quote_id uuid NOT NULL,

promotion_version_id uuid NOT NULL,

promo_code_reservation_id uuid DEFAULT NULL,

benefit_snapshot_json jsonb DEFAULT '{}'::jsonb NOT NULL,

discount_amount numeric(19,4) DEFAULT 0 NOT NULL,

currency_code char(3) NOT NULL,

application_order integer NOT NULL,

explanation_code varchar(80) NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_scholarship_program (

tenant_id uuid NOT NULL,

scholarship_program_id uuid DEFAULT gen_random_uuid() NOT NULL,

scholarship_code varchar(64) NOT NULL,

official_name varchar(200) NOT NULL,

owner_scope_ref uuid NOT NULL,

lifecycle_state varchar(24) DEFAULT 'DRAFT' NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_scholarship_version (

tenant_id uuid NOT NULL,

scholarship_version_id uuid DEFAULT gen_random_uuid() NOT NULL,

scholarship_program_id uuid NOT NULL,

version_no integer NOT NULL,

previous_version_id uuid DEFAULT NULL,

valid_from timestamptz NOT NULL,

valid_to timestamptz DEFAULT NULL,

eligibility_rule_ref uuid NOT NULL,

approval_policy_ref uuid NOT NULL,

budget_policy_ref uuid DEFAULT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

workflow_ref uuid DEFAULT NULL,

content_hash varchar(128) DEFAULT NULL,

published_at timestamptz DEFAULT NULL,

published_by_subject uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_scholarship_benefit (

tenant_id uuid NOT NULL,

scholarship_benefit_id uuid DEFAULT gen_random_uuid() NOT NULL,

scholarship_version_id uuid NOT NULL,

benefit_type varchar(32) NOT NULL,

percent_value numeric(9,4) DEFAULT NULL,

amount_value numeric(19,4) DEFAULT NULL,

currency_code char(3) DEFAULT NULL,

max_benefit_amount numeric(19,4) DEFAULT NULL,

target_component_code varchar(64) DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_scholarship_award (

tenant_id uuid NOT NULL,

scholarship_award_id uuid DEFAULT gen_random_uuid() NOT NULL,

scholarship_version_id uuid NOT NULL,

subject_ref uuid NOT NULL,

offering_ref uuid NOT NULL,

eligibility_decision_ref uuid NOT NULL,

workflow_ref uuid DEFAULT NULL,

evidence_pack_ref uuid DEFAULT NULL,

state varchar(24) DEFAULT 'PROPOSED' NOT NULL,

approved_at timestamptz DEFAULT NULL,

approved_by_subject uuid DEFAULT NULL,

expires_at timestamptz DEFAULT NULL,

reason_code varchar(80) NOT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_agreement_benefit_profile (

tenant_id uuid NOT NULL,

agreement_benefit_profile_id uuid DEFAULT gen_random_uuid() NOT NULL,

agreement_ref uuid NOT NULL,

profile_version integer DEFAULT 1 NOT NULL,

source_document_ref uuid DEFAULT NULL,

valid_from timestamptz NOT NULL,

valid_to timestamptz DEFAULT NULL,

state varchar(20) DEFAULT 'DRAFT' NOT NULL,

content_hash varchar(128) NOT NULL,

activated_at timestamptz DEFAULT NULL,

activated_by_subject uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_agreement_benefit_rule (

tenant_id uuid NOT NULL,

agreement_benefit_rule_id uuid DEFAULT gen_random_uuid() NOT NULL,

agreement_benefit_profile_id uuid NOT NULL,

rule_code varchar(64) NOT NULL,

benefit_type varchar(32) NOT NULL,

percent_value numeric(9,4) DEFAULT NULL,

amount_value numeric(19,4) DEFAULT NULL,

currency_code char(3) DEFAULT NULL,

eligibility_rule_ref uuid DEFAULT NULL,

target_component_code varchar(64) DEFAULT NULL,

priority integer DEFAULT 100 NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_commercial_quote (

tenant_id uuid NOT NULL,

quote_id uuid DEFAULT gen_random_uuid() NOT NULL,

quote_number varchar(64) NOT NULL,

parent_quote_id uuid DEFAULT NULL,

offering_ref uuid NOT NULL,

customer_kind varchar(24) NOT NULL,

customer_ref uuid NOT NULL,

price_book_version_id uuid NOT NULL,

quote_context_hash varchar(128) NOT NULL,

currency_code char(3) NOT NULL,

subtotal_amount numeric(19,4) DEFAULT 0 NOT NULL,

discount_amount numeric(19,4) DEFAULT 0 NOT NULL,

surcharge_amount numeric(19,4) DEFAULT 0 NOT NULL,

tax_amount numeric(19,4) DEFAULT 0 NOT NULL,

total_due_amount numeric(19,4) DEFAULT 0 NOT NULL,

calculation_snapshot_json jsonb DEFAULT '{}'::jsonb NOT NULL,

policy_snapshot_json jsonb DEFAULT '{}'::jsonb NOT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

issued_at timestamptz DEFAULT NULL,

expires_at timestamptz DEFAULT NULL,

accepted_at timestamptz DEFAULT NULL,

content_hash varchar(128) DEFAULT NULL,

created_by_subject uuid NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_quote_line (

tenant_id uuid NOT NULL,

quote_line_id uuid DEFAULT gen_random_uuid() NOT NULL,

quote_id uuid NOT NULL,

source_price_component_id uuid DEFAULT NULL,

line_code varchar(64) NOT NULL,

line_type varchar(24) NOT NULL,

description varchar(240) NOT NULL,

quantity numeric(19,4) DEFAULT 1 NOT NULL,

unit_amount numeric(19,4) DEFAULT 0 NOT NULL,

gross_amount numeric(19,4) DEFAULT 0 NOT NULL,

discount_amount numeric(19,4) DEFAULT 0 NOT NULL,

surcharge_amount numeric(19,4) DEFAULT 0 NOT NULL,

tax_amount numeric(19,4) DEFAULT 0 NOT NULL,

net_amount numeric(19,4) DEFAULT 0 NOT NULL,

sequence_no integer NOT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_quote_adjustment (

tenant_id uuid NOT NULL,

quote_adjustment_id uuid DEFAULT gen_random_uuid() NOT NULL,

quote_id uuid NOT NULL,

adjustment_type varchar(24) NOT NULL,

source_type varchar(24) NOT NULL,

source_ref uuid NOT NULL,

reason_code varchar(80) NOT NULL,

amount_value numeric(19,4) DEFAULT 0 NOT NULL,

percent_value numeric(9,4) DEFAULT NULL,

currency_code char(3) NOT NULL,

application_order integer NOT NULL,

evidence_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_override_request (

tenant_id uuid NOT NULL,

override_request_id uuid DEFAULT gen_random_uuid() NOT NULL,

quote_id uuid NOT NULL,

override_kind varchar(32) NOT NULL,

requested_value_json jsonb DEFAULT '{}'::jsonb NOT NULL,

reason_code varchar(80) NOT NULL,

reason_text text DEFAULT NULL,

workflow_ref uuid DEFAULT NULL,

state varchar(24) DEFAULT 'DRAFT' NOT NULL,

requested_by_subject uuid NOT NULL,

approved_by_subject uuid DEFAULT NULL,

approved_at timestamptz DEFAULT NULL,

applied_at timestamptz DEFAULT NULL,

evidence_pack_ref uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_charge_intent (

tenant_id uuid NOT NULL,

charge_intent_id uuid DEFAULT gen_random_uuid() NOT NULL,

quote_id uuid NOT NULL,

financial_customer_ref uuid NOT NULL,

amount numeric(19,4) NOT NULL,

currency_code char(3) NOT NULL,

due_date date DEFAULT NULL,

concept_code varchar(80) NOT NULL,

state varchar(24) DEFAULT 'CREATED' NOT NULL,

idempotency_key varchar(160) NOT NULL,

external_operation_ref varchar(160) DEFAULT NULL,

sent_at timestamptz DEFAULT NULL,

confirmed_at timestamptz DEFAULT NULL,

last_reconciled_at timestamptz DEFAULT NULL,

correlation_id uuid NOT NULL,

causation_id uuid DEFAULT NULL,

created_at timestamptz DEFAULT now() NOT NULL,

updated_at timestamptz DEFAULT now() NOT NULL,

version bigint DEFAULT 0 NOT NULL

);

CREATE TABLE ec03.ec03_financial_effect_receipt (

tenant_id uuid NOT NULL,

financial_effect_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,

charge_intent_id uuid NOT NULL,

receipt_type varchar(32) NOT NULL,

remote_operation_ref varchar(160) DEFAULT NULL,

outcome_code varchar(80) NOT NULL,

response_hash varchar(128) DEFAULT NULL,

evidence_ref uuid DEFAULT NULL,

occurred_at timestamptz NOT NULL,

recorded_at timestamptz DEFAULT now() NOT NULL,

correlation_id uuid NOT NULL

);

CREATE TABLE ec03.ec03_publication_receipt (

tenant_id uuid NOT NULL,

publication_receipt_id uuid DEFAULT gen_random_uuid() NOT NULL,

target_type varchar(32) NOT NULL,

target_id uuid NOT NULL,

content_hash varchar(128) NOT NULL,

hash_algorithm varchar(24) DEFAULT 'SHA-256' NOT NULL,

canonical_schema_version varchar(40) NOT NULL,

policy_snapshot_json jsonb DEFAULT '{}'::jsonb NOT NULL,

published_by_subject uuid NOT NULL,

assurance_level_code varchar(40) DEFAULT NULL,

workflow_ref uuid DEFAULT NULL,

evidence_ref uuid DEFAULT NULL,

recorded_at timestamptz DEFAULT now() NOT NULL

);

CREATE TABLE ec03.ec03_command_idempotency (

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

CREATE TABLE ec03.ec03_outbox_event (

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

CREATE TABLE ec03.ec03_inbox_message (

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

CREATE TABLE ec03.ec03_operation_status (

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

ALTER TABLE ec03.ec03_price_book_definition ADD CONSTRAINT pk_ec03_price_book_definition PRIMARY KEY (tenant_id, price_book_id);

ALTER TABLE ec03.ec03_price_book_definition ADD CONSTRAINT uq_ec03_price_book_definition_code UNIQUE (tenant_id, price_book_code);

ALTER TABLE ec03.ec03_price_book_definition ADD CONSTRAINT ck_ec03_price_book_definition_state CHECK (lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED'));

CREATE INDEX ix_ec03_price_book_owner_state ON ec03.ec03_price_book_definition (tenant_id, owner_scope_ref, lifecycle_state);

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT pk_ec03_price_book_version PRIMARY KEY (tenant_id, price_book_version_id);

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT uq_ec03_price_book_version_no UNIQUE (tenant_id, price_book_id, version_no);

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT uq_ec03_price_book_version_scope UNIQUE (tenant_id, price_book_id, price_book_version_id);

CREATE UNIQUE INDEX uq_ec03_price_book_single_published ON ec03.ec03_price_book_version (tenant_id, price_book_id) WHERE state='PUBLISHED';

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT fk_ec03_pbv_definition FOREIGN KEY (tenant_id, price_book_id) REFERENCES ec03.ec03_price_book_definition(tenant_id, price_book_id);

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT fk_ec03_pbv_previous FOREIGN KEY (tenant_id, price_book_id, previous_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_id, price_book_version_id);

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT ck_ec03_pbv_version_positive CHECK (version_no \> 0);

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT ck_ec03_pbv_dates CHECK (valid_to IS NULL OR valid_from IS NULL OR valid_to \> valid_from);

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT ck_ec03_pbv_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID'));

ALTER TABLE ec03.ec03_price_component ADD CONSTRAINT pk_ec03_price_component PRIMARY KEY (tenant_id, price_component_id);

ALTER TABLE ec03.ec03_price_component ADD CONSTRAINT uq_ec03_price_component_code UNIQUE (tenant_id, price_book_version_id, component_code);

ALTER TABLE ec03.ec03_price_component ADD CONSTRAINT uq_ec03_price_component_order UNIQUE (tenant_id, price_book_version_id, sequence_no);

ALTER TABLE ec03.ec03_price_component ADD CONSTRAINT fk_ec03_price_component_pbv FOREIGN KEY (tenant_id, price_book_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_version_id);

ALTER TABLE ec03.ec03_price_component ADD CONSTRAINT ck_ec03_price_component_amount CHECK (base_amount \>= 0);

ALTER TABLE ec03.ec03_price_component ADD CONSTRAINT ck_ec03_price_component_order CHECK (sequence_no \> 0);

ALTER TABLE ec03.ec03_price_tier ADD CONSTRAINT pk_ec03_price_tier PRIMARY KEY (tenant_id, price_tier_id);

ALTER TABLE ec03.ec03_price_tier ADD CONSTRAINT fk_ec03_price_tier_component FOREIGN KEY (tenant_id, price_component_id) REFERENCES ec03.ec03_price_component(tenant_id, price_component_id);

ALTER TABLE ec03.ec03_price_tier ADD CONSTRAINT ck_ec03_price_tier_qty CHECK (min_quantity \> 0 AND (max_quantity IS NULL OR max_quantity \>= min_quantity));

ALTER TABLE ec03.ec03_price_tier ADD CONSTRAINT ck_ec03_price_tier_amount CHECK (unit_amount \>= 0);

ALTER TABLE ec03.ec03_price_tier ADD CONSTRAINT ck_ec03_price_tier_priority CHECK (priority \>= 0);

CREATE INDEX ix_ec03_price_tier_range ON ec03.ec03_price_tier (tenant_id, price_component_id, min_quantity, max_quantity);

ALTER TABLE ec03.ec03_price_scope_binding ADD CONSTRAINT pk_ec03_price_scope_binding PRIMARY KEY (tenant_id, price_scope_binding_id);

ALTER TABLE ec03.ec03_price_scope_binding ADD CONSTRAINT fk_ec03_price_scope_pbv FOREIGN KEY (tenant_id, price_book_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_version_id);

ALTER TABLE ec03.ec03_price_scope_binding ADD CONSTRAINT ck_ec03_price_scope_type CHECK (scope_type IN ('SITE','CAMPUS','DELIVERY_MODE','CHANNEL','SEGMENT','AGREEMENT','OTHER'));

ALTER TABLE ec03.ec03_price_scope_binding ADD CONSTRAINT ck_ec03_price_scope_target CHECK ((scope_ref IS NOT NULL)::int + (scope_code IS NOT NULL)::int = 1);

ALTER TABLE ec03.ec03_price_scope_binding ADD CONSTRAINT ck_ec03_price_scope_effect CHECK (effect IN ('INCLUDE','EXCLUDE'));

ALTER TABLE ec03.ec03_price_scope_binding ADD CONSTRAINT ck_ec03_price_scope_priority CHECK (priority \>= 0);

CREATE INDEX ix_ec03_price_scope_lookup ON ec03.ec03_price_scope_binding (tenant_id, price_book_version_id, scope_type, priority);

ALTER TABLE ec03.ec03_offering_price_binding ADD CONSTRAINT pk_ec03_offering_price_binding PRIMARY KEY (tenant_id, offering_price_binding_id);

ALTER TABLE ec03.ec03_offering_price_binding ADD CONSTRAINT fk_ec03_offering_price_pbv FOREIGN KEY (tenant_id, price_book_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_version_id);

ALTER TABLE ec03.ec03_offering_price_binding ADD CONSTRAINT ck_ec03_offering_price_dates CHECK (valid_to IS NULL OR valid_to \> valid_from);

ALTER TABLE ec03.ec03_offering_price_binding ADD CONSTRAINT ck_ec03_offering_price_state CHECK (binding_state IN ('ACTIVE','SUSPENDED','RETIRED'));

CREATE INDEX ix_ec03_offering_price_lookup ON ec03.ec03_offering_price_binding (tenant_id, offering_ref, channel_code, valid_from DESC);

ALTER TABLE ec03.ec03_promotion_campaign ADD CONSTRAINT pk_ec03_promotion_campaign PRIMARY KEY (tenant_id, promotion_campaign_id);

ALTER TABLE ec03.ec03_promotion_campaign ADD CONSTRAINT uq_ec03_promotion_campaign_code UNIQUE (tenant_id, campaign_code);

ALTER TABLE ec03.ec03_promotion_campaign ADD CONSTRAINT ck_ec03_promotion_campaign_state CHECK (lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED'));

ALTER TABLE ec03.ec03_promotion_version ADD CONSTRAINT pk_ec03_promotion_version PRIMARY KEY (tenant_id, promotion_version_id);

ALTER TABLE ec03.ec03_promotion_version ADD CONSTRAINT uq_ec03_promotion_version_no UNIQUE (tenant_id, promotion_campaign_id, version_no);

CREATE UNIQUE INDEX uq_ec03_promotion_single_published ON ec03.ec03_promotion_version (tenant_id, promotion_campaign_id) WHERE state='PUBLISHED';

ALTER TABLE ec03.ec03_promotion_version ADD CONSTRAINT fk_ec03_promotion_version_campaign FOREIGN KEY (tenant_id, promotion_campaign_id) REFERENCES ec03.ec03_promotion_campaign(tenant_id, promotion_campaign_id);

ALTER TABLE ec03.ec03_promotion_version ADD CONSTRAINT ck_ec03_promotion_version_dates CHECK (valid_to IS NULL OR valid_to \> valid_from);

ALTER TABLE ec03.ec03_promotion_version ADD CONSTRAINT ck_ec03_promotion_version_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID','SUSPENDED'));

ALTER TABLE ec03.ec03_promotion_version ADD CONSTRAINT ck_ec03_promotion_version_priority CHECK (priority \>= 0);

ALTER TABLE ec03.ec03_promotion_condition ADD CONSTRAINT pk_ec03_promotion_condition PRIMARY KEY (tenant_id, promotion_condition_id);

ALTER TABLE ec03.ec03_promotion_condition ADD CONSTRAINT fk_ec03_promotion_condition_version FOREIGN KEY (tenant_id, promotion_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id);

ALTER TABLE ec03.ec03_promotion_condition ADD CONSTRAINT uq_ec03_promotion_condition_code UNIQUE (tenant_id, promotion_version_id, condition_code);

ALTER TABLE ec03.ec03_promotion_condition ADD CONSTRAINT ck_ec03_promotion_condition_type CHECK (condition_type IN ('TIME_WINDOW','CHANNEL','SEGMENT','OFFERING','QUANTITY','ELIGIBILITY','OTHER'));

ALTER TABLE ec03.ec03_promotion_condition ADD CONSTRAINT ck_ec03_promotion_condition_order CHECK (sequence_no \> 0);

ALTER TABLE ec03.ec03_promotion_condition ADD CONSTRAINT ck_ec03_promotion_condition_operand CHECK (jsonb_typeof(operand_json)='object');

ALTER TABLE ec03.ec03_promotion_benefit ADD CONSTRAINT pk_ec03_promotion_benefit PRIMARY KEY (tenant_id, promotion_benefit_id);

ALTER TABLE ec03.ec03_promotion_benefit ADD CONSTRAINT fk_ec03_promotion_benefit_version FOREIGN KEY (tenant_id, promotion_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id);

ALTER TABLE ec03.ec03_promotion_benefit ADD CONSTRAINT uq_ec03_promotion_benefit_code UNIQUE (tenant_id, promotion_version_id, benefit_code);

ALTER TABLE ec03.ec03_promotion_benefit ADD CONSTRAINT ck_ec03_promotion_benefit_type CHECK (benefit_type IN ('PERCENT','FIXED','PRICE_OVERRIDE','FREE_COMPONENT'));

ALTER TABLE ec03.ec03_promotion_benefit ADD CONSTRAINT ck_ec03_promotion_benefit_values CHECK ((benefit_type='PERCENT' AND percent_value\>0 AND percent_value\<=100 AND amount_value IS NULL) OR (benefit_type IN ('FIXED','PRICE_OVERRIDE') AND amount_value\>=0 AND currency_code IS NOT NULL AND percent_value IS NULL) OR (benefit_type='FREE_COMPONENT' AND target_component_code IS NOT NULL AND percent_value IS NULL AND amount_value IS NULL));

ALTER TABLE ec03.ec03_promotion_benefit ADD CONSTRAINT ck_ec03_promotion_benefit_cap CHECK (max_discount_amount IS NULL OR max_discount_amount \>= 0);

ALTER TABLE ec03.ec03_promotion_benefit ADD CONSTRAINT ck_ec03_promotion_benefit_order CHECK (sequence_no \> 0);

ALTER TABLE ec03.ec03_promo_code_pool ADD CONSTRAINT pk_ec03_promo_code_pool PRIMARY KEY (tenant_id, promo_code_pool_id);

ALTER TABLE ec03.ec03_promo_code_pool ADD CONSTRAINT fk_ec03_promo_pool_promotion FOREIGN KEY (tenant_id, promotion_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id);

ALTER TABLE ec03.ec03_promo_code_pool ADD CONSTRAINT uq_ec03_promo_pool_code UNIQUE (tenant_id, pool_code);

ALTER TABLE ec03.ec03_promo_code_pool ADD CONSTRAINT ck_ec03_promo_pool_length CHECK (token_length BETWEEN 8 AND 64);

ALTER TABLE ec03.ec03_promo_code_pool ADD CONSTRAINT ck_ec03_promo_pool_counts CHECK (max_codes \> 0 AND generated_count \>= 0 AND generated_count \<= max_codes AND default_max_uses \> 0);

ALTER TABLE ec03.ec03_promo_code_pool ADD CONSTRAINT ck_ec03_promo_pool_state CHECK (state IN ('DRAFT','ACTIVE','SUSPENDED','EXHAUSTED','RETIRED'));

ALTER TABLE ec03.ec03_promo_code ADD CONSTRAINT pk_ec03_promo_code PRIMARY KEY (tenant_id, promo_code_id);

ALTER TABLE ec03.ec03_promo_code ADD CONSTRAINT fk_ec03_promo_code_pool FOREIGN KEY (tenant_id, promo_code_pool_id) REFERENCES ec03.ec03_promo_code_pool(tenant_id, promo_code_pool_id);

ALTER TABLE ec03.ec03_promo_code ADD CONSTRAINT uq_ec03_promo_code_hash UNIQUE (tenant_id, token_hash);

ALTER TABLE ec03.ec03_promo_code ADD CONSTRAINT ck_ec03_promo_code_counts CHECK (max_uses \> 0 AND reserved_uses \>= 0 AND redeemed_uses \>= 0 AND reserved_uses + redeemed_uses \<= max_uses);

ALTER TABLE ec03.ec03_promo_code ADD CONSTRAINT ck_ec03_promo_code_state CHECK (state IN ('AVAILABLE','SUSPENDED','EXHAUSTED','REVOKED','EXPIRED'));

CREATE INDEX ix_ec03_promo_code_last4 ON ec03.ec03_promo_code (tenant_id, token_last4);

ALTER TABLE ec03.ec03_promo_code_reservation ADD CONSTRAINT pk_ec03_promo_reservation PRIMARY KEY (tenant_id, promo_code_reservation_id);

ALTER TABLE ec03.ec03_promo_code_reservation ADD CONSTRAINT fk_ec03_promo_reservation_code FOREIGN KEY (tenant_id, promo_code_id) REFERENCES ec03.ec03_promo_code(tenant_id, promo_code_id);

ALTER TABLE ec03.ec03_promo_code_reservation ADD CONSTRAINT uq_ec03_promo_reservation_idem UNIQUE (tenant_id, idempotency_key);

ALTER TABLE ec03.ec03_promo_code_reservation ADD CONSTRAINT ck_ec03_promo_reservation_lease CHECK (lease_until \> reserved_at);

ALTER TABLE ec03.ec03_promo_code_reservation ADD CONSTRAINT ck_ec03_promo_reservation_state CHECK (state IN ('RESERVED','CONSUMED','RELEASED','EXPIRED'));

CREATE INDEX ix_ec03_promo_reservation_expiry ON ec03.ec03_promo_code_reservation (tenant_id, lease_until) WHERE state='RESERVED';

ALTER TABLE ec03.ec03_promotion_application ADD CONSTRAINT pk_ec03_promotion_application PRIMARY KEY (tenant_id, promotion_application_id);

ALTER TABLE ec03.ec03_promotion_application ADD CONSTRAINT fk_ec03_promo_application_version FOREIGN KEY (tenant_id, promotion_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id);

ALTER TABLE ec03.ec03_promotion_application ADD CONSTRAINT uq_ec03_promo_application_order UNIQUE (tenant_id, quote_id, application_order);

ALTER TABLE ec03.ec03_promotion_application ADD CONSTRAINT ck_ec03_promo_application_amount CHECK (discount_amount \>= 0);

ALTER TABLE ec03.ec03_promotion_application ADD CONSTRAINT ck_ec03_promo_application_snapshot CHECK (jsonb_typeof(benefit_snapshot_json)='object');

ALTER TABLE ec03.ec03_scholarship_program ADD CONSTRAINT pk_ec03_scholarship_program PRIMARY KEY (tenant_id, scholarship_program_id);

ALTER TABLE ec03.ec03_scholarship_program ADD CONSTRAINT uq_ec03_scholarship_program_code UNIQUE (tenant_id, scholarship_code);

ALTER TABLE ec03.ec03_scholarship_program ADD CONSTRAINT ck_ec03_scholarship_program_state CHECK (lifecycle_state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED'));

ALTER TABLE ec03.ec03_scholarship_version ADD CONSTRAINT pk_ec03_scholarship_version PRIMARY KEY (tenant_id, scholarship_version_id);

ALTER TABLE ec03.ec03_scholarship_version ADD CONSTRAINT uq_ec03_scholarship_version_no UNIQUE (tenant_id, scholarship_program_id, version_no);

CREATE UNIQUE INDEX uq_ec03_scholarship_single_published ON ec03.ec03_scholarship_version (tenant_id, scholarship_program_id) WHERE state='PUBLISHED';

ALTER TABLE ec03.ec03_scholarship_version ADD CONSTRAINT fk_ec03_scholarship_version_program FOREIGN KEY (tenant_id, scholarship_program_id) REFERENCES ec03.ec03_scholarship_program(tenant_id, scholarship_program_id);

ALTER TABLE ec03.ec03_scholarship_version ADD CONSTRAINT ck_ec03_scholarship_version_dates CHECK (valid_to IS NULL OR valid_to \> valid_from);

ALTER TABLE ec03.ec03_scholarship_version ADD CONSTRAINT ck_ec03_scholarship_version_state CHECK (state IN ('DRAFT','IN_REVIEW','APPROVED','SCHEDULED','PUBLISHED','SUPERSEDED','VOID','SUSPENDED'));

ALTER TABLE ec03.ec03_scholarship_benefit ADD CONSTRAINT pk_ec03_scholarship_benefit PRIMARY KEY (tenant_id, scholarship_benefit_id);

ALTER TABLE ec03.ec03_scholarship_benefit ADD CONSTRAINT fk_ec03_scholarship_benefit_version FOREIGN KEY (tenant_id, scholarship_version_id) REFERENCES ec03.ec03_scholarship_version(tenant_id, scholarship_version_id);

ALTER TABLE ec03.ec03_scholarship_benefit ADD CONSTRAINT ck_ec03_scholarship_benefit_type CHECK (benefit_type IN ('PERCENT','FIXED','PRICE_OVERRIDE','FREE_COMPONENT'));

ALTER TABLE ec03.ec03_scholarship_benefit ADD CONSTRAINT ck_ec03_scholarship_benefit_values CHECK ((benefit_type='PERCENT' AND percent_value\>0 AND percent_value\<=100 AND amount_value IS NULL) OR (benefit_type IN ('FIXED','PRICE_OVERRIDE') AND amount_value\>=0 AND currency_code IS NOT NULL AND percent_value IS NULL) OR (benefit_type='FREE_COMPONENT' AND target_component_code IS NOT NULL AND percent_value IS NULL AND amount_value IS NULL));

ALTER TABLE ec03.ec03_scholarship_benefit ADD CONSTRAINT ck_ec03_scholarship_benefit_cap CHECK (max_benefit_amount IS NULL OR max_benefit_amount \>= 0);

ALTER TABLE ec03.ec03_scholarship_award ADD CONSTRAINT pk_ec03_scholarship_award PRIMARY KEY (tenant_id, scholarship_award_id);

ALTER TABLE ec03.ec03_scholarship_award ADD CONSTRAINT fk_ec03_scholarship_award_version FOREIGN KEY (tenant_id, scholarship_version_id) REFERENCES ec03.ec03_scholarship_version(tenant_id, scholarship_version_id);

ALTER TABLE ec03.ec03_scholarship_award ADD CONSTRAINT ck_ec03_scholarship_award_state CHECK (state IN ('PROPOSED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','REVOKED','EXPIRED'));

CREATE INDEX ix_ec03_scholarship_award_subject ON ec03.ec03_scholarship_award (tenant_id, subject_ref, offering_ref, state);

ALTER TABLE ec03.ec03_agreement_benefit_profile ADD CONSTRAINT pk_ec03_agreement_benefit_profile PRIMARY KEY (tenant_id, agreement_benefit_profile_id);

ALTER TABLE ec03.ec03_agreement_benefit_profile ADD CONSTRAINT uq_ec03_agreement_benefit_profile_version UNIQUE (tenant_id, agreement_ref, profile_version);

ALTER TABLE ec03.ec03_agreement_benefit_profile ADD CONSTRAINT ck_ec03_agreement_profile_version CHECK (profile_version \> 0);

ALTER TABLE ec03.ec03_agreement_benefit_profile ADD CONSTRAINT ck_ec03_agreement_profile_dates CHECK (valid_to IS NULL OR valid_to \> valid_from);

ALTER TABLE ec03.ec03_agreement_benefit_profile ADD CONSTRAINT ck_ec03_agreement_profile_state CHECK (state IN ('DRAFT','ACTIVE','SUSPENDED','RETIRED','VOID'));

CREATE INDEX ix_ec03_agreement_profile_active ON ec03.ec03_agreement_benefit_profile (tenant_id, agreement_ref, state, valid_from DESC);

ALTER TABLE ec03.ec03_agreement_benefit_rule ADD CONSTRAINT pk_ec03_agreement_benefit_rule PRIMARY KEY (tenant_id, agreement_benefit_rule_id);

ALTER TABLE ec03.ec03_agreement_benefit_rule ADD CONSTRAINT fk_ec03_agreement_rule_profile FOREIGN KEY (tenant_id, agreement_benefit_profile_id) REFERENCES ec03.ec03_agreement_benefit_profile(tenant_id, agreement_benefit_profile_id);

ALTER TABLE ec03.ec03_agreement_benefit_rule ADD CONSTRAINT uq_ec03_agreement_rule_code UNIQUE (tenant_id, agreement_benefit_profile_id, rule_code);

ALTER TABLE ec03.ec03_agreement_benefit_rule ADD CONSTRAINT ck_ec03_agreement_rule_type CHECK (benefit_type IN ('PERCENT','FIXED','PRICE_OVERRIDE','FREE_COMPONENT'));

ALTER TABLE ec03.ec03_agreement_benefit_rule ADD CONSTRAINT ck_ec03_agreement_rule_values CHECK ((benefit_type='PERCENT' AND percent_value\>0 AND percent_value\<=100 AND amount_value IS NULL) OR (benefit_type IN ('FIXED','PRICE_OVERRIDE') AND amount_value\>=0 AND currency_code IS NOT NULL AND percent_value IS NULL) OR (benefit_type='FREE_COMPONENT' AND target_component_code IS NOT NULL AND percent_value IS NULL AND amount_value IS NULL));

ALTER TABLE ec03.ec03_agreement_benefit_rule ADD CONSTRAINT ck_ec03_agreement_rule_priority CHECK (priority \>= 0);

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT pk_ec03_commercial_quote PRIMARY KEY (tenant_id, quote_id);

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT uq_ec03_commercial_quote_number UNIQUE (tenant_id, quote_number);

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT fk_ec03_quote_pricebook FOREIGN KEY (tenant_id, price_book_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_version_id);

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT fk_ec03_quote_parent FOREIGN KEY (tenant_id, parent_quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id);

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT ck_ec03_quote_customer_kind CHECK (customer_kind IN ('PERSON','CORPORATE','THIRD_PARTY','AGREEMENT'));

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT ck_ec03_quote_amounts CHECK (subtotal_amount\>=0 AND discount_amount\>=0 AND surcharge_amount\>=0 AND tax_amount\>=0 AND total_due_amount\>=0);

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT ck_ec03_quote_total CHECK (total_due_amount = subtotal_amount - discount_amount + surcharge_amount + tax_amount);

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT ck_ec03_quote_state CHECK (state IN ('DRAFT','CALCULATED','ISSUED','ACCEPTED','EXPIRED','VOID','SUPERSEDED'));

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT ck_ec03_quote_expiry CHECK (expires_at IS NULL OR issued_at IS NULL OR expires_at \> issued_at);

ALTER TABLE ec03.ec03_commercial_quote ADD CONSTRAINT ck_ec03_quote_snapshots CHECK (jsonb_typeof(calculation_snapshot_json)='object' AND jsonb_typeof(policy_snapshot_json)='object');

CREATE INDEX ix_ec03_quote_customer ON ec03.ec03_commercial_quote (tenant_id, customer_ref, created_at DESC);

CREATE INDEX ix_ec03_quote_expiry ON ec03.ec03_commercial_quote (tenant_id, expires_at) WHERE state='ISSUED';

ALTER TABLE ec03.ec03_quote_line ADD CONSTRAINT pk_ec03_quote_line PRIMARY KEY (tenant_id, quote_line_id);

ALTER TABLE ec03.ec03_quote_line ADD CONSTRAINT fk_ec03_quote_line_quote FOREIGN KEY (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id);

ALTER TABLE ec03.ec03_quote_line ADD CONSTRAINT fk_ec03_quote_line_component FOREIGN KEY (tenant_id, source_price_component_id) REFERENCES ec03.ec03_price_component(tenant_id, price_component_id);

ALTER TABLE ec03.ec03_quote_line ADD CONSTRAINT uq_ec03_quote_line_code UNIQUE (tenant_id, quote_id, line_code);

ALTER TABLE ec03.ec03_quote_line ADD CONSTRAINT uq_ec03_quote_line_order UNIQUE (tenant_id, quote_id, sequence_no);

ALTER TABLE ec03.ec03_quote_line ADD CONSTRAINT ck_ec03_quote_line_amounts CHECK (quantity\>0 AND unit_amount\>=0 AND gross_amount\>=0 AND discount_amount\>=0 AND surcharge_amount\>=0 AND tax_amount\>=0 AND net_amount\>=0);

ALTER TABLE ec03.ec03_quote_line ADD CONSTRAINT ck_ec03_quote_line_total CHECK (net_amount = gross_amount - discount_amount + surcharge_amount + tax_amount);

ALTER TABLE ec03.ec03_quote_line ADD CONSTRAINT ck_ec03_quote_line_type CHECK (line_type IN ('BASE','OPTIONAL','FEE','MATERIAL','OTHER'));

ALTER TABLE ec03.ec03_quote_adjustment ADD CONSTRAINT pk_ec03_quote_adjustment PRIMARY KEY (tenant_id, quote_adjustment_id);

ALTER TABLE ec03.ec03_quote_adjustment ADD CONSTRAINT fk_ec03_quote_adjustment_quote FOREIGN KEY (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id);

ALTER TABLE ec03.ec03_quote_adjustment ADD CONSTRAINT ck_ec03_quote_adjustment_type CHECK (adjustment_type IN ('DISCOUNT','SURCHARGE','PRICE_OVERRIDE','WAIVER'));

ALTER TABLE ec03.ec03_quote_adjustment ADD CONSTRAINT ck_ec03_quote_adjustment_source CHECK (source_type IN ('PROMOTION','SCHOLARSHIP','AGREEMENT','OVERRIDE','POLICY'));

ALTER TABLE ec03.ec03_quote_adjustment ADD CONSTRAINT ck_ec03_quote_adjustment_values CHECK (amount_value\>=0 AND (percent_value IS NULL OR (percent_value\>=0 AND percent_value\<=100)));

ALTER TABLE ec03.ec03_quote_adjustment ADD CONSTRAINT uq_ec03_quote_adjustment_order UNIQUE (tenant_id, quote_id, application_order);

ALTER TABLE ec03.ec03_override_request ADD CONSTRAINT pk_ec03_override_request PRIMARY KEY (tenant_id, override_request_id);

ALTER TABLE ec03.ec03_override_request ADD CONSTRAINT fk_ec03_override_quote FOREIGN KEY (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id);

ALTER TABLE ec03.ec03_override_request ADD CONSTRAINT ck_ec03_override_kind CHECK (override_kind IN ('DISCOUNT','PERCENT','FINAL_PRICE','COMPONENT_PRICE','OTHER'));

ALTER TABLE ec03.ec03_override_request ADD CONSTRAINT ck_ec03_override_state CHECK (state IN ('DRAFT','SUBMITTED','UNDER_REVIEW','APPROVED','REJECTED','APPLIED','CANCELLED'));

ALTER TABLE ec03.ec03_override_request ADD CONSTRAINT ck_ec03_override_payload CHECK (jsonb_typeof(requested_value_json)='object');

ALTER TABLE ec03.ec03_override_request ADD CONSTRAINT ck_ec03_override_sod CHECK (approved_by_subject IS NULL OR approved_by_subject \<\> requested_by_subject);

ALTER TABLE ec03.ec03_charge_intent ADD CONSTRAINT pk_ec03_charge_intent PRIMARY KEY (tenant_id, charge_intent_id);

ALTER TABLE ec03.ec03_charge_intent ADD CONSTRAINT fk_ec03_charge_intent_quote FOREIGN KEY (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id);

ALTER TABLE ec03.ec03_charge_intent ADD CONSTRAINT uq_ec03_charge_intent_idem UNIQUE (tenant_id, idempotency_key);

ALTER TABLE ec03.ec03_charge_intent ADD CONSTRAINT ck_ec03_charge_intent_amount CHECK (amount \>= 0);

ALTER TABLE ec03.ec03_charge_intent ADD CONSTRAINT ck_ec03_charge_intent_state CHECK (state IN ('CREATED','SENT','CONFIRMED','REJECTED','UNKNOWN_EFFECT','CANCELLED'));

CREATE INDEX ix_ec03_charge_intent_reconcile ON ec03.ec03_charge_intent (tenant_id, last_reconciled_at) WHERE state='UNKNOWN_EFFECT';

ALTER TABLE ec03.ec03_financial_effect_receipt ADD CONSTRAINT pk_ec03_financial_effect_receipt PRIMARY KEY (tenant_id, financial_effect_receipt_id);

ALTER TABLE ec03.ec03_financial_effect_receipt ADD CONSTRAINT fk_ec03_financial_receipt_intent FOREIGN KEY (tenant_id, charge_intent_id) REFERENCES ec03.ec03_charge_intent(tenant_id, charge_intent_id);

ALTER TABLE ec03.ec03_financial_effect_receipt ADD CONSTRAINT ck_ec03_financial_receipt_type CHECK (receipt_type IN ('ACK','CONFIRMED','REJECTED','RECONCILIATION'));

CREATE INDEX ix_ec03_financial_receipt_intent ON ec03.ec03_financial_effect_receipt (tenant_id, charge_intent_id, recorded_at);

ALTER TABLE ec03.ec03_publication_receipt ADD CONSTRAINT pk_ec03_publication_receipt PRIMARY KEY (tenant_id, publication_receipt_id);

ALTER TABLE ec03.ec03_publication_receipt ADD CONSTRAINT ck_ec03_publication_receipt_target CHECK (target_type IN ('PRICE_BOOK_VERSION','PROMOTION_VERSION','SCHOLARSHIP_VERSION'));

ALTER TABLE ec03.ec03_publication_receipt ADD CONSTRAINT ck_ec03_publication_receipt_policy CHECK (jsonb_typeof(policy_snapshot_json)='object');

ALTER TABLE ec03.ec03_publication_receipt ADD CONSTRAINT uq_ec03_publication_receipt_target_hash UNIQUE (tenant_id, target_type, target_id, content_hash);

ALTER TABLE ec03.ec03_command_idempotency ADD CONSTRAINT pk_ec03_command_idempotency PRIMARY KEY (tenant_id, idempotency_id);

ALTER TABLE ec03.ec03_command_idempotency ADD CONSTRAINT uq_ec03_command_idempotency_key UNIQUE (tenant_id, idempotency_key);

ALTER TABLE ec03.ec03_command_idempotency ADD CONSTRAINT ck_ec03_idempotency_state CHECK (state IN ('IN_PROGRESS','SUCCEEDED','FAILED_RECOVERABLE','FAILED_FINAL'));

ALTER TABLE ec03.ec03_command_idempotency ADD CONSTRAINT ck_ec03_idempotency_response CHECK (response_status IS NULL OR (response_status BETWEEN 100 AND 599));

ALTER TABLE ec03.ec03_command_idempotency ADD CONSTRAINT ck_ec03_idempotency_payload CHECK (response_json IS NULL OR jsonb_typeof(response_json) IN ('object','array'));

CREATE INDEX ix_ec03_idempotency_recovery ON ec03.ec03_command_idempotency (tenant_id, lease_until) WHERE state='IN_PROGRESS';

ALTER TABLE ec03.ec03_outbox_event ADD CONSTRAINT pk_ec03_outbox_event PRIMARY KEY (tenant_id, event_id);

ALTER TABLE ec03.ec03_outbox_event ADD CONSTRAINT ck_ec03_outbox_schema CHECK (schema_version \> 0);

ALTER TABLE ec03.ec03_outbox_event ADD CONSTRAINT ck_ec03_outbox_payload CHECK (jsonb_typeof(payload_json)='object');

ALTER TABLE ec03.ec03_outbox_event ADD CONSTRAINT ck_ec03_outbox_state CHECK (state IN ('PENDING','IN_FLIGHT','DELIVERED','FAILED'));

ALTER TABLE ec03.ec03_outbox_event ADD CONSTRAINT ck_ec03_outbox_attempts CHECK (attempt_count \>= 0);

CREATE INDEX ix_ec03_outbox_claim ON ec03.ec03_outbox_event (tenant_id, next_attempt_at, occurred_at) WHERE state IN ('PENDING','FAILED');

CREATE INDEX ix_ec03_outbox_reclaim ON ec03.ec03_outbox_event (tenant_id, lease_until) WHERE state='IN_FLIGHT';

ALTER TABLE ec03.ec03_inbox_message ADD CONSTRAINT pk_ec03_inbox_message PRIMARY KEY (tenant_id, message_id);

ALTER TABLE ec03.ec03_inbox_message ADD CONSTRAINT ck_ec03_inbox_state CHECK (state IN ('RECEIVED','PROCESSING','PROCESSED','FAILED'));

CREATE INDEX ix_ec03_inbox_state ON ec03.ec03_inbox_message (tenant_id, state, received_at);

ALTER TABLE ec03.ec03_operation_status ADD CONSTRAINT pk_ec03_operation_status PRIMARY KEY (tenant_id, operation_id);

ALTER TABLE ec03.ec03_operation_status ADD CONSTRAINT ck_ec03_operation_state CHECK (state IN ('PENDING','RUNNING','SUCCEEDED','FAILED','UNKNOWN_EFFECT','CANCELLED'));

ALTER TABLE ec03.ec03_operation_status ADD CONSTRAINT ck_ec03_operation_progress CHECK ((progress_current IS NULL AND progress_total IS NULL) OR (progress_current\>=0 AND progress_total\>=0 AND progress_current\<=progress_total));

ALTER TABLE ec03.ec03_operation_status ADD CONSTRAINT ck_ec03_operation_result CHECK (result_json IS NULL OR jsonb_typeof(result_json) IN ('object','array'));

CREATE INDEX ix_ec03_operation_active ON ec03.ec03_operation_status (tenant_id, updated_at) WHERE state IN ('PENDING','RUNNING','UNKNOWN_EFFECT');

-- Supplemental tenant-aware internal references

ALTER TABLE ec03.ec03_price_book_version ADD CONSTRAINT fk_ec03_pbv_superseded FOREIGN KEY (tenant_id, price_book_id, superseded_by_version_id) REFERENCES ec03.ec03_price_book_version(tenant_id, price_book_id, price_book_version_id);

ALTER TABLE ec03.ec03_promotion_version ADD CONSTRAINT fk_ec03_promotion_previous FOREIGN KEY (tenant_id, previous_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id);

ALTER TABLE ec03.ec03_promotion_version ADD CONSTRAINT fk_ec03_promotion_superseded FOREIGN KEY (tenant_id, superseded_by_version_id) REFERENCES ec03.ec03_promotion_version(tenant_id, promotion_version_id);

ALTER TABLE ec03.ec03_scholarship_version ADD CONSTRAINT fk_ec03_scholarship_previous FOREIGN KEY (tenant_id, previous_version_id) REFERENCES ec03.ec03_scholarship_version(tenant_id, scholarship_version_id);

ALTER TABLE ec03.ec03_promo_code_reservation ADD CONSTRAINT fk_ec03_promo_reservation_quote FOREIGN KEY (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id);

ALTER TABLE ec03.ec03_promotion_application ADD CONSTRAINT fk_ec03_promo_application_quote FOREIGN KEY (tenant_id, quote_id) REFERENCES ec03.ec03_commercial_quote(tenant_id, quote_id);

ALTER TABLE ec03.ec03_promotion_application ADD CONSTRAINT fk_ec03_promo_application_reservation FOREIGN KEY (tenant_id, promo_code_reservation_id) REFERENCES ec03.ec03_promo_code_reservation(tenant_id, promo_code_reservation_id);

CREATE OR REPLACE FUNCTION ec03.forbid_append_only_mutation() RETURNS trigger LANGUAGE plpgsql AS \$\$

BEGIN

RAISE EXCEPTION 'EC03_APPEND_ONLY: % cannot be updated or deleted', TG_TABLE_NAME USING ERRCODE='23514';

END \$\$;

CREATE TRIGGER trg_ec03_publication_receipt_append_only BEFORE UPDATE OR DELETE ON ec03.ec03_publication_receipt FOR EACH ROW EXECUTE FUNCTION ec03.forbid_append_only_mutation();

CREATE TRIGGER trg_ec03_financial_effect_receipt_append_only BEFORE UPDATE OR DELETE ON ec03.ec03_financial_effect_receipt FOR EACH ROW EXECUTE FUNCTION ec03.forbid_append_only_mutation();

CREATE OR REPLACE FUNCTION ec03.guard_committed_version_update() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE oldj jsonb; newj jsonb;

BEGIN

IF OLD.state IN ('SCHEDULED','PUBLISHED','SUPERSEDED','VOID') THEN

oldj := to_jsonb(OLD) - ARRAY\['state','updated_at','version','published_at','published_by_subject','superseded_by_version_id'\];

newj := to_jsonb(NEW) - ARRAY\['state','updated_at','version','published_at','published_by_subject','superseded_by_version_id'\];

IF oldj IS DISTINCT FROM newj THEN

RAISE EXCEPTION 'EC03_IMMUTABLE_SNAPSHOT: committed version content cannot change' USING ERRCODE='23514';

END IF;

END IF;

RETURN NEW;

END \$\$;

CREATE TRIGGER trg_ec03_price_book_version_immutable BEFORE UPDATE ON ec03.ec03_price_book_version FOR EACH ROW EXECUTE FUNCTION ec03.guard_committed_version_update();

CREATE TRIGGER trg_ec03_promotion_version_immutable BEFORE UPDATE ON ec03.ec03_promotion_version FOR EACH ROW EXECUTE FUNCTION ec03.guard_committed_version_update();

CREATE TRIGGER trg_ec03_scholarship_version_immutable BEFORE UPDATE ON ec03.ec03_scholarship_version FOR EACH ROW EXECUTE FUNCTION ec03.guard_committed_version_update();

CREATE OR REPLACE FUNCTION ec03.guard_quote_child_mutation() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE qid uuid; tid uuid; st varchar;

BEGIN

qid := COALESCE(NEW.quote_id, OLD.quote_id); tid := COALESCE(NEW.tenant_id, OLD.tenant_id);

SELECT state INTO st FROM ec03.ec03_commercial_quote WHERE tenant_id=tid AND quote_id=qid FOR UPDATE;

IF st NOT IN ('DRAFT','CALCULATED') THEN RAISE EXCEPTION 'EC03_QUOTE_IMMUTABLE: quote % state %',qid,st USING ERRCODE='23514'; END IF;

RETURN COALESCE(NEW,OLD);

END \$\$;

CREATE OR REPLACE FUNCTION ec03.bump_quote_revision() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE qid uuid; tid uuid;

BEGIN

qid := COALESCE(NEW.quote_id, OLD.quote_id); tid := COALESCE(NEW.tenant_id, OLD.tenant_id);

UPDATE ec03.ec03_commercial_quote SET version=version+1, updated_at=now() WHERE tenant_id=tid AND quote_id=qid;

RETURN COALESCE(NEW,OLD);

END \$\$;

CREATE TRIGGER trg_ec03_quote_line_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_quote_line FOR EACH ROW EXECUTE FUNCTION ec03.guard_quote_child_mutation();

CREATE TRIGGER trg_ec03_quote_line_bump AFTER INSERT OR UPDATE OR DELETE ON ec03.ec03_quote_line FOR EACH ROW EXECUTE FUNCTION ec03.bump_quote_revision();

CREATE TRIGGER trg_ec03_quote_adjustment_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_quote_adjustment FOR EACH ROW EXECUTE FUNCTION ec03.guard_quote_child_mutation();

CREATE TRIGGER trg_ec03_quote_adjustment_bump AFTER INSERT OR UPDATE OR DELETE ON ec03.ec03_quote_adjustment FOR EACH ROW EXECUTE FUNCTION ec03.bump_quote_revision();

CREATE TRIGGER trg_ec03_promotion_application_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_promotion_application FOR EACH ROW EXECUTE FUNCTION ec03.guard_quote_child_mutation();

CREATE TRIGGER trg_ec03_promotion_application_bump AFTER INSERT OR UPDATE OR DELETE ON ec03.ec03_promotion_application FOR EACH ROW EXECUTE FUNCTION ec03.bump_quote_revision();

CREATE OR REPLACE FUNCTION ec03.guard_pricebook_child_mutation() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE tid uuid; pvid uuid; st varchar;

BEGIN

tid:=COALESCE(NEW.tenant_id,OLD.tenant_id);

IF TG_TABLE_NAME='ec03_price_tier' THEN

SELECT pc.price_book_version_id INTO pvid FROM ec03.ec03_price_component pc WHERE pc.tenant_id=tid AND pc.price_component_id=COALESCE(NEW.price_component_id,OLD.price_component_id);

ELSE pvid:=COALESCE(NEW.price_book_version_id,OLD.price_book_version_id); END IF;

SELECT state INTO st FROM ec03.ec03_price_book_version WHERE tenant_id=tid AND price_book_version_id=pvid FOR UPDATE;

IF st \<\> 'DRAFT' THEN RAISE EXCEPTION 'EC03_PRICEBOOK_IMMUTABLE: child mutation requires DRAFT' USING ERRCODE='23514'; END IF;

RETURN COALESCE(NEW,OLD);

END \$\$;

CREATE TRIGGER trg_ec03_price_component_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_price_component FOR EACH ROW EXECUTE FUNCTION ec03.guard_pricebook_child_mutation();

CREATE TRIGGER trg_ec03_price_tier_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_price_tier FOR EACH ROW EXECUTE FUNCTION ec03.guard_pricebook_child_mutation();

CREATE TRIGGER trg_ec03_price_scope_binding_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_price_scope_binding FOR EACH ROW EXECUTE FUNCTION ec03.guard_pricebook_child_mutation();

CREATE OR REPLACE FUNCTION ec03.guard_promotion_child_mutation() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE tid uuid; pvid uuid; st varchar;

BEGIN tid:=COALESCE(NEW.tenant_id,OLD.tenant_id); pvid:=COALESCE(NEW.promotion_version_id,OLD.promotion_version_id);

SELECT state INTO st FROM ec03.ec03_promotion_version WHERE tenant_id=tid AND promotion_version_id=pvid FOR UPDATE;

IF st \<\> 'DRAFT' THEN RAISE EXCEPTION 'EC03_PROMOTION_IMMUTABLE: child mutation requires DRAFT' USING ERRCODE='23514'; END IF;

RETURN COALESCE(NEW,OLD); END \$\$;

CREATE TRIGGER trg_ec03_promotion_condition_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_promotion_condition FOR EACH ROW EXECUTE FUNCTION ec03.guard_promotion_child_mutation();

CREATE TRIGGER trg_ec03_promotion_benefit_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_promotion_benefit FOR EACH ROW EXECUTE FUNCTION ec03.guard_promotion_child_mutation();

CREATE OR REPLACE FUNCTION ec03.guard_scholarship_child_mutation() RETURNS trigger LANGUAGE plpgsql AS \$\$

DECLARE tid uuid; svid uuid; st varchar;

BEGIN tid:=COALESCE(NEW.tenant_id,OLD.tenant_id); svid:=COALESCE(NEW.scholarship_version_id,OLD.scholarship_version_id);

SELECT state INTO st FROM ec03.ec03_scholarship_version WHERE tenant_id=tid AND scholarship_version_id=svid FOR UPDATE;

IF st \<\> 'DRAFT' THEN RAISE EXCEPTION 'EC03_SCHOLARSHIP_IMMUTABLE: child mutation requires DRAFT' USING ERRCODE='23514'; END IF;

RETURN COALESCE(NEW,OLD); END \$\$;

CREATE TRIGGER trg_ec03_scholarship_benefit_guard BEFORE INSERT OR UPDATE OR DELETE ON ec03.ec03_scholarship_benefit FOR EACH ROW EXECUTE FUNCTION ec03.guard_scholarship_child_mutation();

-- Defense-in-depth tenant isolation: runtime role must not own tables and must not have BYPASSRLS.

ALTER TABLE ec03.ec03_price_book_definition ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_price_book_definition FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_price_book_definition_tenant ON ec03.ec03_price_book_definition USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_price_book_version ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_price_book_version FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_price_book_version_tenant ON ec03.ec03_price_book_version USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_price_component ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_price_component FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_price_component_tenant ON ec03.ec03_price_component USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_price_tier ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_price_tier FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_price_tier_tenant ON ec03.ec03_price_tier USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_price_scope_binding ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_price_scope_binding FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_price_scope_binding_tenant ON ec03.ec03_price_scope_binding USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_offering_price_binding ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_offering_price_binding FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_offering_price_binding_tenant ON ec03.ec03_offering_price_binding USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_promotion_campaign ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_promotion_campaign FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_promotion_campaign_tenant ON ec03.ec03_promotion_campaign USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_promotion_version ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_promotion_version FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_promotion_version_tenant ON ec03.ec03_promotion_version USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_promotion_condition ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_promotion_condition FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_promotion_condition_tenant ON ec03.ec03_promotion_condition USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_promotion_benefit ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_promotion_benefit FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_promotion_benefit_tenant ON ec03.ec03_promotion_benefit USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_promo_code_pool ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_promo_code_pool FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_promo_code_pool_tenant ON ec03.ec03_promo_code_pool USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_promo_code ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_promo_code FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_promo_code_tenant ON ec03.ec03_promo_code USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_promo_code_reservation ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_promo_code_reservation FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_promo_code_reservation_tenant ON ec03.ec03_promo_code_reservation USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_promotion_application ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_promotion_application FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_promotion_application_tenant ON ec03.ec03_promotion_application USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_scholarship_program ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_scholarship_program FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_scholarship_program_tenant ON ec03.ec03_scholarship_program USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_scholarship_version ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_scholarship_version FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_scholarship_version_tenant ON ec03.ec03_scholarship_version USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_scholarship_benefit ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_scholarship_benefit FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_scholarship_benefit_tenant ON ec03.ec03_scholarship_benefit USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_scholarship_award ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_scholarship_award FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_scholarship_award_tenant ON ec03.ec03_scholarship_award USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_agreement_benefit_profile ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_agreement_benefit_profile FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_agreement_benefit_profile_tenant ON ec03.ec03_agreement_benefit_profile USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_agreement_benefit_rule ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_agreement_benefit_rule FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_agreement_benefit_rule_tenant ON ec03.ec03_agreement_benefit_rule USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_commercial_quote ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_commercial_quote FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_commercial_quote_tenant ON ec03.ec03_commercial_quote USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_quote_line ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_quote_line FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_quote_line_tenant ON ec03.ec03_quote_line USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_quote_adjustment ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_quote_adjustment FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_quote_adjustment_tenant ON ec03.ec03_quote_adjustment USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_override_request ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_override_request FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_override_request_tenant ON ec03.ec03_override_request USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_charge_intent ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_charge_intent FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_charge_intent_tenant ON ec03.ec03_charge_intent USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_financial_effect_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_financial_effect_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_financial_effect_receipt_tenant ON ec03.ec03_financial_effect_receipt USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_publication_receipt ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_publication_receipt FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_publication_receipt_tenant ON ec03.ec03_publication_receipt USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_command_idempotency ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_command_idempotency FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_command_idempotency_tenant ON ec03.ec03_command_idempotency USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_outbox_event ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_outbox_event FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_outbox_event_tenant ON ec03.ec03_outbox_event USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_inbox_message ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_inbox_message FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_inbox_message_tenant ON ec03.ec03_inbox_message USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

ALTER TABLE ec03.ec03_operation_status ENABLE ROW LEVEL SECURITY;

ALTER TABLE ec03.ec03_operation_status FORCE ROW LEVEL SECURITY;

CREATE POLICY pol_ec03_operation_status_tenant ON ec03.ec03_operation_status USING (tenant_id = ec03.current_tenant_uuid()) WITH CHECK (tenant_id = ec03.current_tenant_uuid());

-- Operational claim indexes are used with SELECT ... FOR UPDATE SKIP LOCKED.

CREATE INDEX IF NOT EXISTS ix_ec03_promo_code_available ON ec03.ec03_promo_code(tenant_id,promo_code_pool_id,state) WHERE state='AVAILABLE';

CREATE INDEX IF NOT EXISTS ix_ec03_quote_offering_state ON ec03.ec03_commercial_quote(tenant_id,offering_ref,state,created_at DESC);

CREATE INDEX IF NOT EXISTS ix_ec03_scholarship_award_expiry ON ec03.ec03_scholarship_award(tenant_id,expires_at) WHERE state='APPROVED';

-- Grants are environment-specific. Required invariant: migrator owns DDL; HTTP runtime has least privilege and NO BYPASSRLS; worker role is separate.

# 14. MongoDB y Redis

PostgreSQL es Source of Truth transaccional de EC-03. MongoDB y Redis son componentes derivados/aceleradores: su pérdida no puede destruir la verdad de pricing, quotes, awards, promo code usage ni ChargeIntent. Toda reconstrucción debe poder partir de PostgreSQL + eventos/contratos autorizados.

## 14.1 MongoDB — read models derivados

| **Read model**                      | **Uso**                                                      | **Fuente**                   | **Regla de consistencia**                                |
|-------------------------------------|--------------------------------------------------------------|------------------------------|----------------------------------------------------------|
| **ec03_price_catalog_rm**           | Exploración rápida por programa/offering/canal/moneda.       | Eventos PriceBook/EC-02      | Eventual; mostrar asOf/provenance.                       |
| **ec03_quote_explain_rm**           | Vista explainable de quote con trace, adjustments y lineage. | CommercialQuote + events     | Nunca habilita aceptar si PostgreSQL no confirma estado. |
| **ec03_promotion_effectiveness_rm** | Conversión/uso agregado de campañas.                         | PromotionApplication + CT-11 | Sin PII; analytics derivado.                             |
| **ec03_scholarship_desk_rm**        | Inbox/read model de awards y workflow refs.                  | ScholarshipAward + CT-06     | Revalidar command contra PostgreSQL.                     |
| **ec03_reconciliation_rm**          | Vista operacional de ChargeIntent/UNKNOWN_EFFECT.            | ChargeIntent + receipts      | No reemplaza receipt local.                              |
| **ec03_operation_dashboard_rm**     | Operaciones bulk y status resumido.                          | OperationStatus              | Polling puede ir a PostgreSQL si proyección está STALE.  |

| **REGLA MONGODB —** MongoDB no decide precio, descuento, beca, quote, estado financiero ni consumo de código. Si la proyección está STALE/PARTIAL/UNAVAILABLE, la UI lo declara y las mutaciones usan la verdad PostgreSQL. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 14.2 Redis — aceleración y coordinación técnica

| **Key/patrón**                         | **Propósito**                            | **TTL/estrategia**                      | **Nunca debe hacer**                  |
|----------------------------------------|------------------------------------------|-----------------------------------------|---------------------------------------|
| **ec03:pricebook:{tenant}:{version}**  | Cache de snapshot publicado serializado. | TTL corto + invalidación por event.     | Ser único lugar de la versión.        |
| **ec03:quote-preview:{tenant}:{hash}** | Preview idempotente/read acceleration.   | TTL minutos; no quote oficial.          | Sustituir CommercialQuote.            |
| **ec03:catalog:{tenant}:{scope}**      | Catálogo comercial derivado.             | TTL configurable.                       | Ocultar STALE.                        |
| **ec03:lock:bulk:{tenant}:{resource}** | Lock técnico para jobs no críticos.      | Lease con fencing token cuando aplique. | Resolver invariantes de dinero.       |
| **ec03:rate:{tenant}:{subject}**       | Rate limiting técnico.                   | Sliding window.                         | Bloquear durablemente un entitlement. |

Promo code reservation, idempotencia, outbox lease y OperationStatus son durables en PostgreSQL. Redis puede reducir contención, pero el correctness final se obtiene con transacciones y constraints en PostgreSQL.

# 15. Backend Java 21 / Spring Boot / Spring Modulith

EC-03 se implementa como módulo Spring Modulith dentro del monolito modular PeopleU IA. La arquitectura Hexagonal separa domain/application de adaptadores REST, JPA, CT, EC-02, EC-09 y Finanzas. No se permite repository cross-context ni acceso directo a tablas ajenas.

## 15.1 Estructura de paquetes normativa

com.peopleu.ec.commercial

├── domain

│ ├── pricebook

│ ├── promotion

│ ├── scholarship

│ ├── agreement

│ ├── quote

│ ├── charge

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

│ ├── out/ec02

│ ├── out/ec09

│ ├── out/finance

│ └── out/events

└── config

## 15.2 Aggregates y métodos de intención

| **Aggregate**                  | **Métodos de intención mínimos**                                                                           | **Invariante**                                              |
|--------------------------------|------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------|
| **PriceBookDefinition**        | createDraft(), createVersion(), activate(), suspend(), retire()                                            | Business key estable; versioning explícito.                 |
| **PriceBookVersion**           | addComponent(), addTier(), bindScope(), requestReview(), schedule(), publish(), supersede(), voidVersion() | Comandos de hijos bump aggregate revision.                  |
| **PromotionCampaign/Version**  | createVersion(), addCondition(), addBenefit(), publish(), suspend()                                        | Stacking/eligibility pinneados.                             |
| **PromoCodePool/PromoCode**    | generateBatch(), reserve(), consume(), release(), revoke()                                                 | Row lock + counters \<= max_uses.                           |
| **ScholarshipProgram/Version** | createVersion(), addBenefit(), publish()                                                                   | Eligibility pertenece a CT-15.                              |
| **ScholarshipAward**           | propose(), submit(), approve(), reject(), apply(), revoke()                                                | SoD + evidence.                                             |
| **CommercialQuote**            | calculate(), recalculateDraft(), issue(), accept(), expire(), voidQuote(), supersede()                     | ISSUED immutable; recalcular =\> nueva quote si ya emitida. |
| **OverrideRequest**            | submit(), approve(), reject(), apply(), cancel()                                                           | No autoaprobación cuando policy exige SoD.                  |
| **ChargeIntent**               | create(), markSent(), confirm(), reject(), markUnknownEffect(), reconcile(), cancel()                      | Retry solo tras reconciliation.                             |

## 15.3 Ports de salida obligatorios

| **Port**                    | **Bounded Context** | **Contrato**                                                 |
|-----------------------------|---------------------|--------------------------------------------------------------|
| **InstitutionScopePort**    | CT-01               | resolveScope / authorizeScope; fail-closed para publish.     |
| **PolicyCatalogPort**       | CT-02               | PolicyVersion inmutable + catalog codes.                     |
| **EvidencePort**            | CT-05               | evidence/document refs, no blobs.                            |
| **WorkflowPort**            | CT-06               | review/approval/override/scholarship workflows.              |
| **NotificationPort**        | CT-07               | post-commit notifications, sin rollback del hecho.           |
| **IntegrationContractPort** | CT-09               | schema/version governance.                                   |
| **AuditPort**               | CT-10               | critical audit/evidence pack references.                     |
| **AnalyticsPort**           | CT-11               | business facts derivados/eventos.                            |
| **AiAssistPort**            | CT-12               | suggestion only + provenance.                                |
| **EligibilityPort**         | CT-15               | evaluate rule version; decision ref.                         |
| **MigrationPort**           | CT-16               | dry-run/promotion receipts.                                  |
| **ExternalEcosystemPort**   | CT-18               | payment/catalog ecosystem solo si contrato aprobado.         |
| **OfferingPort**            | EC-02               | Offering snapshot/version/status y modality/channel context. |
| **CorporateAgreementPort**  | EC-09               | agreement status, beneficiary scope y evidence refs.         |
| **FinancePort**             | Core Financiero     | createCharge/reconcile/queryStatus con idempotency.          |

## 15.4 TenantContext + RLS

Cada caso de uso abre transacción, deriva tenant desde SecurityContext y ejecuta SET LOCAL peopleu.tenant_id = :tenantId antes de acceder a repository. El role HTTP no es owner de tablas y no posee BYPASSRLS. Tests de integración deben demostrar que omitir accidentalmente tenant predicate no expone filas de otro tenant.

@Transactional

public CommercialQuote issueQuote(IssueQuoteCommand cmd, AggregateRevision expected) {

tenantSql.setLocal(authenticatedTenant());

var quote = quoteRepository.lockById(cmd.quoteId()).orElseThrow(NotFound::new);

aggregateRevision.requireMatch(quote.version(), expected); // -\> 412

quote.issue(clock.instant(), pricingPolicies.currentSnapshot());

publicationAudit.record(...);

outbox.append(CommercialQuoteIssued.from(quote));

return quote;

}

## 15.5 PricingEngine determinista

1.  1\. Resolver OfferingSnapshot EC-02 + PriceBookVersion pinneada y verificar efectividad.

2.  2\. Normalizar QuoteContext: customerKind/ref, channel, quantity, currency, timestamp, agreement/scholarship/promo inputs.

3.  3\. Resolver componentes y tiers aplicables; calcular gross usando BigDecimal.

4.  4\. Evaluar agreement benefits y ScholarshipAward válidos con decisiones externas pinneadas.

5.  5\. Evaluar PromotionVersion candidates, conditions y promo-code reservation; ordenar según stacking policy.

6.  6\. Aplicar adjustments en orden determinista; usar rounding policy en puntos explícitos, nunca redondeo accidental.

7.  7\. Calcular taxes comerciales según policy referenciada; marcar qué parte requiere confirmación financiera/fiscal.

8.  8\. Producir PricingTrace, policy snapshot, source refs, warnings y unresolved dependencies.

9.  9\. Validar subtotal - discount + surcharge + tax = total y currency coherente.

10. 10\. Persistir quote solo por comando; preview read-only no debe producir hechos oficiales.

| **DETERMINISMO —** Mismo QuoteContext normalizado + mismas versiones pinneadas + mismo instante efectivo/policy snapshot debe producir exactamente el mismo resultado monetario. Si no, existe un defecto de ingeniería. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

## 15.6 Idempotencia, outbox e inbox

CommandIdempotency se adquiere antes del side effect sensible. Same key + same request hash retorna el mismo resource/response; same key + payload distinto retorna 409 IDEMPOTENCY_KEY_REUSED. IN_PROGRESS usa owner + lease_until y recovery gobernado. Outbox multi-instancia usa FOR UPDATE SKIP LOCKED; Inbox deduplica message_id y detecta same-id/different-payload.

# 16. APIs REST: endpoints, DTOs, errores, idempotencia y concurrencia

Base path recomendado: /api/ec/v1/commercial. Los paths expresan recursos y commands de intención. PATCH queda limitado a metadata escalar editable; publish, issue, accept, reserve, approve, apply y reconcile son actions explícitas.

## 16.1 Catálogo de endpoints

| **Método** | **Endpoint**                              | **Propósito**                 | **Control**                | **Respuesta** |
|------------|-------------------------------------------|-------------------------------|----------------------------|---------------|
| GET        | /price-books                              | Listar price books paginado   | —                          | 200           |
| POST       | /price-books                              | Crear definición              | Idempotency-Key            | 201           |
| GET        | /price-books/{id}                         | Detalle + ETag                | —                          | 200           |
| PATCH      | /price-books/{id}                         | Metadata editable             | If-Match                   | 200/412       |
| POST       | /price-books/{id}/versions                | Crear/clonar versión          | Idempotency-Key            | 201           |
| GET        | /price-book-versions/{id}                 | Snapshot + ETag               | —                          | 200           |
| POST       | /price-book-versions/{id}/components      | Agregar componente            | If-Match + Idempotency-Key | 201/412       |
| POST       | /price-book-versions/{id}:validate        | Preflight                     | If-Match                   | 200           |
| POST       | /price-book-versions/{id}:request-review  | Solicitar revisión            | If-Match + Idempotency-Key | 202           |
| POST       | /price-book-versions/{id}:schedule        | Programar futura              | If-Match + Idempotency-Key | 200           |
| POST       | /price-book-versions/{id}:publish         | Publicar                      | If-Match + Idempotency-Key | 200           |
| POST       | /offering-price-bindings                  | Pinnear offering              | Idempotency-Key            | 201           |
| GET        | /offering-price-bindings                  | Buscar binding aplicable      | —                          | 200           |
| POST       | /promotions                               | Crear campaña                 | Idempotency-Key            | 201           |
| POST       | /promotions/{id}/versions                 | Crear versión                 | Idempotency-Key            | 201           |
| POST       | /promotion-versions/{id}:publish          | Publicar promoción            | If-Match + Idempotency-Key | 200           |
| POST       | /promotion-versions/{id}:suspend          | Suspender promoción           | If-Match + Idempotency-Key | 200           |
| POST       | /promo-code-pools                         | Crear pool                    | Idempotency-Key            | 201           |
| POST       | /promo-code-pools/{id}:generate           | Generar códigos bulk          | Idempotency-Key            | 202           |
| POST       | /promo-codes:reserve                      | Reservar código               | Idempotency-Key            | 201           |
| POST       | /promo-code-reservations/{id}:consume     | Consumir reserva              | Idempotency-Key            | 200           |
| POST       | /promo-code-reservations/{id}:release     | Liberar                       | Idempotency-Key            | 200           |
| POST       | /scholarships                             | Crear programa                | Idempotency-Key            | 201           |
| POST       | /scholarships/{id}/versions               | Crear versión                 | Idempotency-Key            | 201           |
| POST       | /scholarship-versions/{id}:publish        | Publicar                      | If-Match + Idempotency-Key | 200           |
| POST       | /scholarship-awards                       | Proponer award                | Idempotency-Key            | 201           |
| POST       | /scholarship-awards/{id}:submit           | Enviar workflow               | If-Match + Idempotency-Key | 202           |
| POST       | /scholarship-awards/{id}:approve          | Aprobar                       | If-Match + Idempotency-Key | 200           |
| POST       | /scholarship-awards/{id}:apply            | Aplicar a contexto            | If-Match + Idempotency-Key | 200           |
| POST       | /agreement-benefit-profiles               | Crear proyección de convenio  | Idempotency-Key            | 201           |
| POST       | /agreement-benefit-profiles/{id}:activate | Activar                       | If-Match + Idempotency-Key | 200           |
| POST       | /quotes:preview                           | Calcular preview no oficial   | Idempotency-Key opcional   | 200           |
| POST       | /quotes                                   | Crear/calcular quote          | Idempotency-Key            | 201           |
| GET        | /quotes/{id}                              | Detalle + PricingTrace + ETag | —                          | 200           |
| POST       | /quotes/{id}:recalculate                  | Recalcular editable           | If-Match + Idempotency-Key | 200           |
| POST       | /quotes/{id}:issue                        | Emitir snapshot               | If-Match + Idempotency-Key | 200           |
| POST       | /quotes/{id}:accept                       | Aceptar                       | If-Match + Idempotency-Key | 200           |
| POST       | /quotes/{id}:void                         | Void                          | If-Match + Idempotency-Key | 200           |
| POST       | /quotes/{id}/overrides                    | Solicitar override            | If-Match + Idempotency-Key | 201           |
| POST       | /overrides/{id}:approve                   | Aprobar override              | If-Match + Idempotency-Key | 200           |
| POST       | /overrides/{id}:apply                     | Aplicar override/requote      | If-Match + Idempotency-Key | 200           |
| POST       | /quotes/{id}/charge-intents               | Crear/enviar intent           | Idempotency-Key            | 202/201       |
| GET        | /charge-intents/{id}                      | Consultar estado              | —                          | 200           |
| POST       | /charge-intents/{id}:reconcile            | Reconciliar UNKNOWN_EFFECT    | Idempotency-Key            | 200/202       |
| GET        | /operations/{id}                          | OperationStatus               | —                          | 200           |

## 16.2 Convención de colecciones

Toda colección admite pageSize con máximo parametrizado (baseline 100), cursor o page token cuando el dataset sea grande, sorting estable y filtros whitelist. El contrato devuelve items, nextCursor, asOf y provenance cuando consume proyecciones. Nunca se devuelve una colección sin límite.

## 16.3 DTOs Java contractuales

public record QuoteContextDto(

UUID offeringRef,

String customerKind,

UUID customerRef,

String channelCode,

BigDecimal quantity,

String currencyCode,

String promoCode,

UUID scholarshipAwardRef,

UUID agreementRef,

Instant asOf

) {}

public record CommercialQuoteDto(

UUID quoteId, String quoteNumber, UUID offeringRef,

String state, String currencyCode,

BigDecimal subtotalAmount, BigDecimal discountAmount,

BigDecimal surchargeAmount, BigDecimal taxAmount,

BigDecimal totalDueAmount, Instant issuedAt, Instant expiresAt,

String contentHash, long version,

List\<QuoteLineDto\> lines,

List\<QuoteAdjustmentDto\> adjustments,

PricingTraceDto pricingTrace

) {}

public record OperationStatusDto(

UUID operationId, String operationType, String state,

Long progressCurrent, Long progressTotal,

JsonNode result, ProblemDetail error,

Instant updatedAt

) {}

## 16.4 ProblemDetail y reason codes

| **HTTP** | **Cuándo**                               | **Reason codes ejemplo**                                                   |
|----------|------------------------------------------|----------------------------------------------------------------------------|
| **400**  | Schema/request inválido.                 | EC03_INVALID_REQUEST, EC03_INVALID_CURRENCY                                |
| **401**  | No autenticado.                          | AUTH_REQUIRED                                                              |
| **403**  | No autorizado/scope/SoD.                 | EC03_SCOPE_DENIED, EC03_SOD_VIOLATION                                      |
| **404**  | Recurso no visible/existe.               | EC03_QUOTE_NOT_FOUND                                                       |
| **409**  | Estado/idempotencia/consumo concurrente. | EC03_STATE_CONFLICT, IDEMPOTENCY_KEY_REUSED, PROMO_CODE_EXHAUSTED          |
| **412**  | ETag root/aggregate obsoleto.            | EC03_PRECONDITION_FAILED                                                   |
| **422**  | Regla de negocio.                        | EC03_PROMOTION_NOT_ELIGIBLE, EC03_QUOTE_EXPIRED, EC03_PRICE_NOT_RESOLVABLE |
| **429**  | Rate/capacity limit.                     | EC03_RATE_LIMITED                                                          |
| **503**  | Dependencia crítica unavailable.         | EC03_FINANCE_UNAVAILABLE, EC03_POLICY_UNAVAILABLE                          |

| **202 ACCEPTED —** Toda respuesta 202 incluye operationId y Location hacia /operations/{id}. 202 significa “trabajo aceptado”, no “efecto confirmado”. UNKNOWN_EFFECT jamás se transforma en SUCCEEDED por timeout/retry automático. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 17. Eventos, outbox/inbox y AsyncAPI

| **Evento**                        | **Aggregate**           | **Consumidor esperado** | **Semántica**                            |
|-----------------------------------|-------------------------|-------------------------|------------------------------------------|
| **PriceBookVersionScheduled.v1**  | PriceBookVersion        | EC-02/ops               | Versión futura comprometida.             |
| **PriceBookVersionPublished.v1**  | PriceBookVersion        | EC-02/Quote/CT-11       | Tarifa vigente publicada.                |
| **PriceBookVersionSuperseded.v1** | PriceBookVersion        | EC-02/ops               | Versión anterior cerrada.                |
| **PromotionVersionPublished.v1**  | PromotionVersion        | Quote/CT-11             | Promoción disponible.                    |
| **PromotionVersionSuspended.v1**  | PromotionVersion        | Quote/ops               | Debe dejar de aplicarse a nuevas quotes. |
| **PromoCodeReserved.v1**          | PromoCode               | Ops/analytics           | Reserva temporal creada.                 |
| **PromoCodeConsumed.v1**          | PromoCode               | Analytics/audit         | Uso consumido.                           |
| **ScholarshipAwardApproved.v1**   | ScholarshipAward        | EC-04/Quote             | Award utilizable.                        |
| **ScholarshipAwardRevoked.v1**    | ScholarshipAward        | Quote/ops               | Award no utilizable para nuevas quotes.  |
| **AgreementBenefitActivated.v1**  | AgreementBenefitProfile | Quote/EC-09             | Beneficio contractual activo.            |
| **CommercialQuoteIssued.v1**      | CommercialQuote         | EC-04/portal            | Snapshot comercial emitido.              |
| **CommercialQuoteAccepted.v1**    | CommercialQuote         | EC-04/Finance adapter   | Aceptación comercial.                    |
| **CommercialQuoteExpired.v1**     | CommercialQuote         | Portal/ops              | Quote vencida.                           |
| **CommercialQuoteVoided.v1**      | CommercialQuote         | Portal/ops              | Quote anulada con razón.                 |
| **OverrideApproved.v1**           | OverrideRequest         | Quote/CT-11             | Excepción aprobada.                      |
| **ChargeIntentRequested.v1**      | ChargeIntent            | Finance adapter         | Solicitud financiera creada.             |
| **ChargeIntentConfirmed.v1**      | ChargeIntent            | EC-04/ops               | Finance confirmó efecto.                 |
| **ChargeIntentUnknownEffect.v1**  | ChargeIntent            | Reconciliation Center   | Efecto remoto incierto.                  |

Envelope mínimo AsyncAPI: eventId, tenantId, aggregateType, aggregateId, eventType, schemaVersion, occurredAt, correlationId, causationId y payload. Payloads no incluyen PII innecesaria ni secrets de promo code.

eventId: uuid

aggregateId: uuid

tenantId: uuid

correlationId: uuid

causationId: uuid \| null

schemaVersion: 1

occurredAt: RFC3339 UTC

payload: object

| **OUTBOX/INBOX —** Hecho local + outbox se confirman en una sola transacción. El dispatcher reclama con SKIP LOCKED + lease. Consumers guardan inbox antes del side effect y soportan at-least-once. Exactly-once distribuido no se promete. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 18. Integraciones, resiliencia, reconciliación y UNKNOWN_EFFECT

| **Dependencia** | **Timeout/retry**                                         | **Circuit/degradación**                                  | **Reconciliación**                                                          |
|-----------------|-----------------------------------------------------------|----------------------------------------------------------|-----------------------------------------------------------------------------|
| **CT-01/02/15** | Timeout corto; retries limitados solo reads idempotentes. | Publish/issue fail-closed si dato crítico no resoluble.  | Requery con version/provenance.                                             |
| **CT-06**       | Command idempotente + receipt.                            | UNKNOWN_EFFECT si workflow remoto pudo crearse.          | Buscar por idempotency/correlation antes de retry.                          |
| **EC-02**       | Read versioned snapshot.                                  | Quote no se emite si Offering inconsistente/unavailable. | Refetch snapshot/version.                                                   |
| **EC-09**       | Read agreement + evidence refs.                           | Sin agreement confirmado no aplicar beneficio.           | Revalidar agreement/version.                                                |
| **Finance**     | Idempotency + client timeout; NO retry ciego tras write.  | ChargeIntent=UNKNOWN_EFFECT.                             | Query remote operation/idempotency key; luego confirm/retry si no aplicado. |
| **CT-07**       | Post-commit retry.                                        | Fallo de notificación no revierte quote/award.           | Outbox/retry.                                                               |
| **CT-12**       | Read/assist only.                                         | UI manual continúa si unavailable.                       | No impacta hecho oficial.                                                   |

## 18.1 Escenario canónico UNKNOWN_EFFECT financiero

- EC-03 persiste ChargeIntent CREATED + idempotency key.

- Adapter envía createCharge a Finanzas.

- Finanzas aplica el cargo y persiste su operación.

- La respuesta se pierde por timeout/red.

- EC-03 NO crea un segundo ChargeIntent ni reintenta ciegamente: marca UNKNOWN_EFFECT.

- Reconciliation consulta Finanzas por external operation ref o idempotency key.

- Si Finance confirma: guarda FinancialEffectReceipt append-only y pasa CONFIRMED.

- Si Finance demuestra NOT_FOUND/no-aplicado: policy permite retry con la misma idempotency key.

- Si continúa indeterminado: mantiene UNKNOWN_EFFECT, alerta y exige operador/runbook.

| **UI —** NO_DATA ≠ ZERO ≠ STALE ≠ PARTIAL ≠ UNAVAILABLE ≠ UNKNOWN_EFFECT. Por ejemplo, “Total Bs 0” nunca debe mostrarse si pricing no pudo resolverse; debe mostrarse UNAVAILABLE/PARTIAL con correlationId. |
|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 19. Frontend Web enterprise por workspaces

| **Workspace**                    | **Usuario**                | **Ruta**                      | **Objetivo/acciones**                                                                   | **KPIs/estado**                                                      |
|----------------------------------|----------------------------|-------------------------------|-----------------------------------------------------------------------------------------|----------------------------------------------------------------------|
| Pricing Studio                   | Pricing Manager/Governance | /ec/commercial/price-books    | Diseñar/versionar price books, components, tiers, scope bindings, diff y publish.       | Published/Scheduled/Draft, validation health, coverage por offering. |
| Offering Pricing Desk            | Commercial Operator        | /ec/commercial/offerings      | Pinnear PriceBookVersion por offering/canal, simular precio, detectar missing bindings. | Coverage, stale bindings, price anomalies.                           |
| Promotion Campaign Center        | Marketing/Commercial       | /ec/commercial/promotions     | Campaign/version, conditions, benefits, stacking, publish/suspend.                      | Conversion, redemptions, budget signals derivados.                   |
| Promo Code Console               | Marketing Ops              | /ec/commercial/promo-codes    | Pools, bulk generation, status, revoke, support by last4, reservations.                 | Available/reserved/redeemed/exhausted.                               |
| Scholarship Desk                 | Scholarship Committee      | /ec/commercial/scholarships   | Programs/versions, applicants by refs, eligibility decision, approve/reject/apply.      | Pending SLA, awards by state.                                        |
| Agreement Benefits Desk          | Corporate Ops              | /ec/commercial/agreements     | Ver convenio source, versionar profile/rules, activate/suspend.                         | Agreements active, upcoming expiry.                                  |
| Quote Desk                       | Admissions/Commercial      | /ec/commercial/quotes         | Construir context, preview, explicar precio, aplicar refs, issue, requote, accept.      | Quote conversion, expiry, unresolved dependency.                     |
| Override Inbox                   | Commercial Approver        | /ec/commercial/overrides      | Revisar excepciones, SoD, evidence, approve/reject/apply.                               | Amount at risk, aging, threshold.                                    |
| Commercial Reconciliation Center | Ops/SRE/Finance Liaison    | /ec/commercial/reconciliation | UNKNOWN_EFFECT, outbox/inbox, operation status, retry/reconcile governed.               | Unknown count, age, Finance availability.                            |

## 19.1 Quote Desk — guía detallada

Layout desktop: header con Offering, customer ref, state badge y ETag; columna izquierda QuoteContext; centro con líneas/adjustments; panel derecho Pricing Explanation. Tabs: Resumen, Líneas, Ajustes, Promociones, Beca/Convenio, Trace, Auditoría. Actions primarias dependen de state y permisos: Recalculate, Issue, Request Override, Accept, Void, Requote.

| **Estado UI**      | **Representación**                                    | **Acción permitida**                  |
|--------------------|-------------------------------------------------------|---------------------------------------|
| **LOADING**        | Skeleton de contexto/líneas; botones disabled.        | Cancelar navegación.                  |
| **NO_DATA**        | No existe quote para contexto.                        | Crear preview/quote.                  |
| **ZERO**           | Precio calculado válido = 0 con explanation/evidence. | Issue si policy permite.              |
| **STALE**          | Snapshot/proyección antigua; asOf visible.            | Refresh antes de mutar.               |
| **PARTIAL**        | Alguna dependencia no crítica no resolvió.            | Preview; issue bloqueado si critical. |
| **UNAVAILABLE**    | Pricing/Offering/Policy crítica no disponible.        | Retry manual; correlationId.          |
| **UNKNOWN_EFFECT** | Charge/workflow remoto incierto.                      | Reconcile; prohibir duplicar acción.  |
| **CONFLICT_412**   | ETag obsoleto.                                        | Reload + diff + reapply intención.    |

## 19.2 Baseline Frontend normativo

- Cliente API generado desde OpenAPI; prohibido duplicar DTOs manualmente.

- TanStack Query o baseline PeopleU equivalente para server state; query keys namespaced por tenant/scope/recurso.

- React Hook Form + schema validation alineada a OpenAPI para forms complejos.

- Feature folders por workspace; presentation components no conocen persistence.

- Toda mutación envía If-Match cuando el aggregate lo exige y un Idempotency-Key UUID estable por intento lógico.

- ProblemDetail se traduce por reasonCode a mensajes i18n; correlationId siempre visible/copiable en error crítico.

- No se infiere ZERO cuando response falta; state machine de query distingue estados explícitos.

- Accessibility WCAG 2.2 AA: focus, keyboard, contrast, labels, live regions y tablas navegables.

- Responsive: drawers/side panels colapsan; acciones administrativas críticas no se esconden sin alternativa.

## 19.3 Mutation workflow

load resource -\> capture ETag

user edits -\> validate locally

submit command + If-Match + Idempotency-Key

2xx -\> replace cache + new ETag

412 -\> freeze local draft -\> refetch -\> show diff -\> user rebase

409/422 -\> reason-code resolution

202 -\> show OperationStatus and poll with backoff

UNKNOWN_EFFECT -\> disable duplicate action; route to reconciliation

# 20. Mobile

EC-03 sí tiene valor móvil, pero no replica toda la administración Web. Mobile está orientado a participante/comercial en journeys de lectura y aceptación de bajo riesgo; publication, bulk promo management, scholarship approval, override approval y reconciliation permanecen en Web.

| **Journey móvil**                      | **Sí/No**       | **Detalle**                                                 |
|----------------------------------------|-----------------|-------------------------------------------------------------|
| **Consultar precio/quote emitida**     | SÍ              | Monto, líneas, descuentos, vigencia, explanation resumida.  |
| **Ingresar promo code**                | SÍ              | Online; nunca cachear token sensible; reserve server-side.  |
| **Aceptar quote**                      | SÍ              | Con autenticación/step-up según amount/policy; idempotency. |
| **Recibir push de quote por vencer**   | SÍ              | CT-07 + deep link seguro.                                   |
| **Ver estado de regularización/cargo** | SÍ              | Solo estado referenciado; Finance sigue SoT.                |
| **Crear/publicar PriceBookVersion**    | NO              | Operación administrativa compleja Web.                      |
| **Generar códigos masivos**            | NO              | Web/OperationStatus.                                        |
| **Aprobar beca/override crítico**      | NO por baseline | Requiere contexto/evidence/SoD; Web.                        |
| **Reconciliar UNKNOWN_EFFECT**         | NO              | Operación Ops controlada.                                   |

## 20.1 Offline, sync y seguridad

Quotes emitidas pueden cachearse cifradas para lectura offline con indicador STALE y expiresAt. Aplicar promo, aceptar quote, reservar código, emitir charge o cualquier command requiere conectividad y respuesta server-side. Deep links usan IDs opacos, autorización server-side y no incluyen promo token/PII en URL. Biometrics puede desbloquear sesión local, pero no sustituye step-up server-side.

# 21. Matriz Frontend / Backend / Mobile

| **Capacidad**        | **Frontend Web** | **Backend**                      | **Mobile**       | **Notas**                            |
|----------------------|------------------|----------------------------------|------------------|--------------------------------------|
| PriceBook authoring  | Completo         | Commands/queries/validation      | No               | Web administrativo.                  |
| Promotion authoring  | Completo         | Versioning/evaluator             | No               | Marketing Ops.                       |
| Promo code reserve   | Quote Desk       | Lock/counters/lease              | Sí               | Nunca client-side.                   |
| Scholarship workflow | Completo         | Award + CT-15/06                 | Lectura opcional | Approval Web.                        |
| Agreement benefits   | Completo         | Profile/rules + EC-09            | No               | B2B.                                 |
| Quote preview        | Completo         | PricingEngine read-only          | Sí               | No hecho oficial.                    |
| Quote issue          | Completo         | Snapshot/hash/outbox             | No baseline      | Puede habilitarse solo staff policy. |
| Quote accept         | Completo         | ETag/idempotency/audit           | Sí               | Participant journey.                 |
| Override             | Completo         | Workflow/SoD                     | No               | Critical admin.                      |
| ChargeIntent         | Indirecto        | Finance adapter + UNKNOWN_EFFECT | Indirecto        | Mobile no llama Finance.             |
| Reconciliation       | Completo Ops     | Receipts/status                  | No               | Web controlado.                      |
| AI assist            | Drafting only    | CT-12 port                       | No baseline      | Nunca decide precio.                 |

# 22. Seguridad: RBAC, ABAC, SoD, step-up y privacy

EC-03 manipula decisiones económicas, excepciones comerciales y referencias personales/corporativas. Por ello la autorización no se resuelve con “rol = admin”. Cada command combina RBAC + ABAC + tenant/scope + state + policy + assurance y registra reason/evidence cuando corresponde.

## 22.1 Roles funcionales

| **Rol**                      | **Responsabilidad**                                                                |
|------------------------------|------------------------------------------------------------------------------------|
| **EC_COMMERCIAL_VIEWER**     | Lectura de catálogo/quotes según scope.                                            |
| **EC_PRICING_MANAGER**       | Diseñar PriceBook y bindings; no aprobar su propia publicación cuando SoD aplique. |
| **EC_PRICING_APPROVER**      | Aprobar/publicar tarifas dentro de scope/threshold.                                |
| **EC_PROMOTION_MANAGER**     | Diseñar campañas/pools; no ver token plaintext después de emisión.                 |
| **EC_SCHOLARSHIP_OFFICER**   | Proponer awards y revisar eligibility.                                             |
| **EC_SCHOLARSHIP_APPROVER**  | Aprobar/rechazar awards bajo SoD.                                                  |
| **EC_QUOTE_OPERATOR**        | Crear/calcular/emitir quotes dentro de políticas.                                  |
| **EC_OVERRIDE_REQUESTER**    | Solicitar excepciones.                                                             |
| **EC_OVERRIDE_APPROVER**     | Aprobar excepciones dentro de threshold.                                           |
| **EC_COMMERCIAL_RECONCILER** | Reconciliar ChargeIntent/outbox; no alterar price design.                          |
| **EC_COMMERCIAL_AUDITOR**    | Read-only audit/evidence/export controlado.                                        |
| **EC_COMMERCIAL_ADMIN**      | Parametrización operacional limitada; no bypass de SoD.                            |

## 22.2 ABAC y scope institucional

- tenant_id del token/contexto debe coincidir con el tenant de la transacción y con RLS.

- academic/commercial owner scope se resuelve por CT-01; una sede no puede publicar price books de otra si no posee scope explícito.

- Monto/porcentaje de override activa thresholds de approval/step-up versionados.

- CustomerKind y customerRef no amplían permisos: poder cotizar no otorga acceso a PII del subject.

- Promotion/Scholarship puede restringirse por campus, canal, modalidad, customer segment o agreement autorizado.

- Support por token_last4 no permite enumerar token_hash ni reconstruir promo code.

## 22.3 Separation of Duties y step-up

| **Operación**             | **Quién inicia**          | **Quién aprueba**                             | **Quién NO puede aprobar**                      | **Step-up/evidencia**                  |
|---------------------------|---------------------------|-----------------------------------------------|-------------------------------------------------|----------------------------------------|
| Publicar PriceBookVersion | Pricing Manager           | Pricing Approver                              | Único diseñador material si policy exige SoD    | AAL2/step-up + workflow + receipt.     |
| Publicar PromotionVersion | Promotion Manager         | Commercial Approver                           | Actor incompatible por policy                   | Step-up si beneficio supera threshold. |
| Aprobar ScholarshipAward  | Scholarship Officer       | Scholarship Approver                          | Solicitante/beneficiario; proponente cuando SoD | Evidence + eligibility decision.       |
| Aprobar OverrideRequest   | Quote Operator/Requester  | Override Approver                             | Solicitante                                     | Step-up por monto/porcentaje.          |
| Void quote emitida        | Quote Operator autorizado | Según policy puede exigir supervisor          | Actor sin scope                                 | Reason + evidence.                     |
| Reconcile UNKNOWN_EFFECT  | Ops/Reconciler            | No approval para read; manual compensation sí | Usuario comercial ordinario                     | Assurance + audit.                     |

## 22.4 Privacy y minimización

EC-03 almacena IDs externos y metadata mínima. No copia nombres, teléfonos, documentos de identidad, datos de salud o información sensible para pricing salvo que exista una finalidad legítima explícita en otro context y un contract aprobado. Scholarship evidence vive en CT-05/10; EC-03 conserva refs y reason codes. Promo codes se persisten como hash + last4, nunca plaintext reusable.

## 22.5 Threat Model específico EC-03

| **ID/amenaza**                         | **Vector**                                  | **Mitigación obligatoria**                                                      |
|----------------------------------------|---------------------------------------------|---------------------------------------------------------------------------------|
| **T-01 IDOR/cross-tenant**             | Alterar quoteId/priceBookId de otro tenant. | RLS FORCE, tenant-aware PK/FK, ABAC, negative tests.                            |
| **T-02 Mass assignment**               | Enviar state/tenant/approvedBy en JSON.     | DTO whitelist, tenant server-side, command methods, ignore forbidden fields.    |
| **T-03 Promo code brute force**        | Enumerar tokens o validar millones.         | Token entropy, hash, rate limit, no distinction oracle excesiva, lock counters. |
| **T-04 Double redemption**             | Dos requests consumen último uso.           | SELECT FOR UPDATE + counters CHECK + durable idempotency.                       |
| **T-05 Price tampering**               | Cliente envía total/discount.               | Servidor recalcula; request solo context/intention.                             |
| **T-06 ETag bypass**                   | Mutation de child sin revisar root.         | Aggregate Revision Contract + If-Match + DB bump.                               |
| **T-07 Override privilege escalation** | Usuario se autoaprueba excepción.           | RBAC/ABAC/SoD, workflow CT-06, DB anti-self básico.                             |
| **T-08 Replay de ChargeIntent**        | Retry crea doble deuda/cargo.               | Idempotency key estable + Finance contract + reconciliation.                    |
| **T-09 UNKNOWN_EFFECT amplification**  | Timeout dispara retries ciegos.             | State UNKNOWN_EFFECT + disable action + runbook.                                |
| **T-10 Injection**                     | JSON/operator codes usados dinámicamente.   | Typed evaluator, parameterized SQL, no expression eval libre.                   |
| **T-11 Pricing DoS**                   | Context/grafos/reglas enormes.              | Capacity budgets, page limits, CPU/time budgets, circuit breakers.              |
| **T-12 Data exfiltration via exports** | Quote/scholarship export excesivo.          | Purpose/scope, CT-05 signed export, audit, field minimization.                  |
| **T-13 Secret leakage**                | Promo plaintext/logs/traces.                | Hash only, log redaction, secure one-time delivery.                             |
| **T-14 Supply-chain compromise**       | Dependencia introduce riesgo.               | SCA/SBOM/signing/scans, dependency policy.                                      |
| **T-15 RLS bypass role**               | Runtime owner/BYPASSRLS.                    | Separate DB roles; security test fails release.                                 |

## 22.6 Secure SDLC

- SAST sobre backend/frontend en PR y main.

- SCA de Maven/npm, licencias y vulnerabilities; Critical/High bloquean salvo excepción formal con expiry.

- Secret scanning y prohibición de credenciales en repositorio.

- SBOM por release y artifact signing/attestation cuando baseline DevSecOps lo soporte.

- Container/image scan y base images pinneadas.

- DAST/API security tests en ambiente staging.

- RLS/tenant isolation, IDOR, authorization y mass-assignment tests automatizados.

- OpenAPI/AsyncAPI diff gate para cambios breaking.

- Dependency updates gobernados; no “latest” no reproducible.

- Runtime/migrator/worker DB credentials separadas y rotables.

| **RELEASE BLOCKER —** Un hallazgo High/Critical abierto, una prueba de aislamiento tenant fallida o runtime con BYPASSRLS bloquea G6/G10 salvo excepción formal documentada, temporal y aprobada por Seguridad. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 23. Auditoría, Evidence Pack, lineage y reason codes

CT-10 gobierna auditoría transversal; EC-03 produce metadata de negocio y refs de evidencia suficientes para reconstruir por qué se publicó una tarifa, se otorgó una beca, se aplicó una promoción, se emitió una quote, se aprobó un override o se materializó un ChargeIntent.

## 23.1 Eventos auditables críticos

| **Audit action**                                                 | **Evidencia mínima**                                                                |
|------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| **PRICE_BOOK_CREATED/PUBLISHED/SCHEDULED/SUPERSEDED/VOID**       | actor, scope, before/after state, version/hash, policy snapshot, workflow/evidence. |
| **PROMOTION_PUBLISHED/SUSPENDED**                                | campaign/version, benefit/stacking snapshot, actor/reason.                          |
| **PROMO_CODE_BATCH_GENERATED**                                   | pool, count, algorithm/version, actor; nunca tokens completos en audit.             |
| **PROMO_CODE_RESERVED/CONSUMED/RELEASED**                        | code id/last4, quote/subject refs, lease/outcome.                                   |
| **SCHOLARSHIP_AWARD_PROPOSED/APPROVED/REJECTED/APPLIED/REVOKED** | subject ref, offering, eligibility decision, workflow, reason.                      |
| **AGREEMENT_BENEFIT_ACTIVATED**                                  | agreement ref, profile version, source document/evidence.                           |
| **QUOTE_CALCULATED/ISSUED/ACCEPTED/EXPIRED/VOID/SUPERSEDED**     | quote, totals, source versions, content hash, actor/subject.                        |
| **OVERRIDE_REQUESTED/APPROVED/APPLIED**                          | requested value, threshold policy, requester/approver, evidence.                    |
| **CHARGE_INTENT_SENT/CONFIRMED/UNKNOWN_EFFECT/RECONCILED**       | quote, amount/currency, idempotency, external ref, receipts.                        |
| **RLS_DENIAL/AUTHZ_DENIAL**                                      | tenant/scope, subject, action, correlation; sin filtrar existencia cross-tenant.    |

## 23.2 Envelope de auditoría

tenantId

actorSubjectRef

subjectRef? / customerRef?

scopeRef

action

resourceType/resourceId

timestampUtc

beforeHash/afterHash or controlled diff

reasonCode

correlationId/causationId

policyVersionRefs\[\]

workflowRef?

evidenceRefs\[\]

assuranceLevel / stepUpResult

aiRunRef?

## 23.3 Evidence Pack mínimo de publication/override

- Snapshot/hash del objeto decidido.

- PolicyVersion refs y compliance context aplicable.

- Workflow/approval receipt CT-06.

- Actor, scope y assurance/step-up.

- Reason code y justificación cuando sea excepción.

- Diff respecto a versión anterior cuando exista.

- Contract resolution receipts de dependencias críticas cuando publication/issue lo requiera.

- OpenAPI/AsyncAPI/Flyway version del release que ejecutó la operación.

# 24. Observabilidad: logs, metrics, traces, SLI/SLO y performance

EC-03 distingue business rejection de operational failure. Un promo code inválido o una beca no elegible no es un 5xx ni debe inflar la tasa de error operacional. Logs son estructurados, sin secretos ni PII innecesaria, y llevan tenantId pseudorreferenciado cuando la política lo permita, correlationId, operation, resource type y reason code.

## 24.1 Métricas técnicas y de negocio

| **Métrica**                               | **Tipo**        | **Semántica**                                    |
|-------------------------------------------|-----------------|--------------------------------------------------|
| **ec03_pricing_latency_ms**               | Histogram       | Latencia PricingEngine preview/quote.            |
| **ec03_quote_issue_total**                | Counter         | Quotes emitidas por outcome.                     |
| **ec03_quote_accept_total**               | Counter         | Aceptaciones/rechazos/expiry.                    |
| **ec03_promo_reservation_conflict_total** | Counter         | Contención/códigos agotados.                     |
| **ec03_promo_reservation_active**         | Gauge           | Reservas activas y leases.                       |
| **ec03_scholarship_workflow_age_seconds** | Gauge/Histogram | Aging de awards en review.                       |
| **ec03_override_amount_total**            | Counter/Sum     | Monto de excepciones por reason/policy; sin PII. |
| **ec03_charge_unknown_effect_total**      | Gauge/Counter   | UNKNOWN_EFFECT actuales/nuevos.                  |
| **ec03_charge_reconcile_latency_ms**      | Histogram       | Tiempo de resolución Finance.                    |
| **ec03_outbox_oldest_pending_seconds**    | Gauge           | Edad del evento pendiente más viejo.             |
| **ec03_outbox_delivery_attempts**         | Histogram       | Reintentos.                                      |
| **ec03_idempotency_replay_total**         | Counter         | Replays same-key.                                |
| **ec03_rls_denial_total**                 | Counter         | Denegaciones/violaciones tenant.                 |
| **ec03_dependency_availability**          | Gauge           | CT/EC02/EC09/Finance health lógico.              |

## 24.2 SLI/SLO baseline

| **SLI**                        | **SLO inicial**               | **Medición/exclusiones**                                             |
|--------------------------------|-------------------------------|----------------------------------------------------------------------|
| **Quote preview availability** | 99.9% mensual                 | Excluye business rejections 4xx; incluye dependency failure crítico. |
| **Quote issue p95**            | \< 750 ms sin workflow remoto | Medido server-side; external calls presupuestados.                   |
| **Quote read p95**             | \< 300 ms                     | PostgreSQL/read model sano.                                          |
| **Promo reserve p95**          | \< 400 ms                     | Incluye locking normal; conflicts 409 separados.                     |
| **Outbox delivery**            | 99.9% \< 2 min                | Desde occurredAt hasta delivered.                                    |
| **UNKNOWN_EFFECT resolution**  | 95% \< 15 min / 99% \< 4h     | Según capacidad de Finance query/status.                             |
| **Tenant isolation**           | 100%                          | Cualquier leak = Sev-1 y release blocker.                            |
| **Pricing determinism**        | 100% suite golden             | Mismo input/version snapshot =\> mismo resultado.                    |

## 24.3 Capacity budgets

| **Recurso**                               | **Baseline parametrizable**   | **Respuesta al exceso**                                 |
|-------------------------------------------|-------------------------------|---------------------------------------------------------|
| **pageSize**                              | 100 máximo                    | 400/422 o clamp solo si contrato lo documenta.          |
| **Price components/version**              | 500                           | 422 EC03_CAPACITY_LIMIT.                                |
| **Promotion conditions+benefits/version** | 200                           | 422\.                                                   |
| **Promo codes por bulk operation**        | 50.000 por operation baseline | 202 + chunking; policy puede menor.                     |
| **Quote lines**                           | 500                           | 422\.                                                   |
| **Adjustments/quote**                     | 100                           | 422\.                                                   |
| **Pricing engine CPU budget**             | p99 target \< 1.5 s           | Abort/circuit + 503 si operational; no total inventado. |
| **Payload JSON**                          | 1 MiB baseline                | 413 Payload Too Large.                                  |

# 25. IA aplicada al módulo

Toda IA se invoca mediante CT-12. EC-03 no contiene SDK directo de proveedor ni prompt hardcodeado. AI_RECOMMENDATION ≠ COMMERCIAL_DECISION: ninguna salida IA puede publicar precios/promociones, aprobar becas/overrides, consumir promo codes, emitir quotes oficiales ni crear efectos financieros.

| **Caso IA permitido**                 | **Input/grounding**                                     | **Output**                             | **Control humano**                          |
|---------------------------------------|---------------------------------------------------------|----------------------------------------|---------------------------------------------|
| **Sugerir estructura de price book**  | ProgramVersion/Offering + catálogo/policies autorizadas | Borrador de componentes/tier rationale | Pricing Manager acepta/edita.               |
| **Detectar anomalías de pricing**     | Versiones/totales históricos agregados                  | Señales/outliers                       | Analista verifica; no cambia precio.        |
| **Redactar campaña/promoción**        | Brief + policies                                        | Copy/conditions draft                  | Marketing revisa; reglas se validan normal. |
| **Explicar quote en lenguaje simple** | PricingTrace oficial                                    | Resumen comprensible                   | No cambia números; muestra provenance.      |
| **Clasificar razones de override**    | Reason text minimizado                                  | Categoría sugerida                     | Aprobador decide.                           |
| **Analizar efectividad**              | KPIs CT-11                                              | Insights                               | No adjudica beneficio ni modifica campaign. |

## 25.1 Provenance obligatorio

Cada sugerencia aceptada conserva ai_run_ref, model_ref, prompt/template_ref, eval_ref, grounding_refs, confidence cuando aplique, reviewer_subject_ref, reviewer_outcome y target command. La auditoría atribuye el cambio final al humano que lo confirmó.

| **LÍMITE —** La IA nunca puede generar o aceptar por sí misma un precio final contractual, una beca, un override o un ChargeIntent. Cualquier automatización que produzca una decisión crítica sin humano/policy explícita viola EC-00/CT-12. |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 26. Analítica y KPI

CT-11 es Source of Truth de datasets/BI; EC-03 publica hechos semánticos y medidas derivables. Los dashboards no leen tablas OLTP mediante joins ad-hoc cross-context en producción.

| **KPI**                           | **Definición**                                                                    |
|-----------------------------------|-----------------------------------------------------------------------------------|
| **Price coverage rate**           | Offerings publicables con binding de price book / total offerings objetivo.       |
| **Quote conversion**              | ACCEPTED / ISSUED por cohort/channel/program.                                     |
| **Quote expiry rate**             | EXPIRED / ISSUED.                                                                 |
| **Average discount rate**         | discount_amount / subtotal_amount; segmentado por source.                         |
| **Promotion redemption rate**     | consumed eligible promo uses / issued/reservable base.                            |
| **Promotion incremental lift**    | Métrica experimental; exige metodología, no causalidad inferida automáticamente.  |
| **Scholarship allocation**        | Awards approved/applied y monto estimado por programa/scope.                      |
| **Override rate**                 | Quotes con override / quotes issued.                                              |
| **Override amount at risk**       | Monto total de excepciones aprobadas, por threshold/reason.                       |
| **Agreement benefit utilization** | Quotes/participants que usan beneficio de convenio.                               |
| **Unknown effect age**            | Edad p50/p95/max de ChargeIntent UNKNOWN_EFFECT.                                  |
| **Pricing failure rate**          | Price not resolvable / attempts; separar business rejection de outage.            |
| **Time to quote**                 | Desde QuoteContext completo hasta ISSUE.                                          |
| **Discount stacking depth**       | Número de adjustments por quote; señal de complejidad/policy.                     |
| **Promo code fraud signals**      | Conflicts/rate-limit/revoked attempts agregados; sin perfilamiento no autorizado. |

# 27. Migración legacy y Data Quality con CT-16

Toda incorporación legacy sigue CT-16: Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → receipt → Reconcile → Certify. Se prohíbe INSERT directo a tablas finales, incluso si el CSV parece limpio, porque saltaría RLS context, invariantes, hashes, lineage, audit y eventos.

## 27.1 Objetos migrables

| **Objeto legacy**         | **Transformación mínima**                                          | **Validaciones de promoción**                                  |
|---------------------------|--------------------------------------------------------------------|----------------------------------------------------------------|
| **Tarifarios históricos** | Map a PriceBookDefinition/Version; moneda y vigencia normalizadas. | Business key, no overlap incompatible, policy refs resolubles. |
| **Descuentos/promos**     | Separar campaña/version/benefit; eliminar free-text ejecutable.    | Tipo/valor/stacking/vigencia.                                  |
| **Códigos promo**         | Hash tokens; importar counters/estado con evidence.                | No plaintext persistente; max/redeemed coherentes.             |
| **Becas**                 | Separar programa/version/award; subject via CT-04.                 | Eligibility/workflow/evidence o reason de legacy exception.    |
| **Convenios**             | Reference agreement EC-09/CT-05; crear BenefitProfile.             | Source document + effectivity.                                 |
| **Cotizaciones vigentes** | Crear quote snapshot certificado solo si se puede reconstruir.     | Totales, moneda, provenance; si no, marcar legacy provenance.  |

## 27.2 Receipt de migración

- sourceSystem/sourceBatch/sourceKey.

- rawHash + transformedPayloadHash.

- mappingVersion y policyVersionRefs.

- validationResult con reason codes.

- dryRun result.

- promotionCommand/idempotency key.

- createdResourceRef.

- reconciliationResult y certifiedBy.

# 28. QA y estrategia de pruebas

La calidad de EC-03 se demuestra en múltiples capas. No basta con controller tests ni happy paths: dinero, tenant isolation, concurrency y distributed effects requieren suites específicas ejecutables en CI.

| **Nivel**                | **Cobertura obligatoria**                                               | **Herramientas/evidencia**               |
|--------------------------|-------------------------------------------------------------------------|------------------------------------------|
| **Unit/Domain**          | Money, tiers, stacking, state transitions, policies, value objects.     | JUnit 5 + property-based donde aporte.   |
| **Repository**           | Constraints, indexes, tenant-aware FKs, append-only, state guards.      | Testcontainers PostgreSQL real.          |
| **RLS/Tenant Isolation** | Query sin tenant predicate, tenant mismatch, runtime role NO BYPASSRLS. | Integration negative tests.              |
| **Aggregate Revision**   | Child mutation bump root; stale If-Match =\> 412.                       | Concurrent integration tests.            |
| **Pricing determinism**  | Mismo snapshot/input =\> mismo total/trace; rounding edge cases.        | Golden datasets.                         |
| **Promo concurrency**    | N requests por último uso; solo capacidad permitida consume/reserva.    | Parallel tests/PostgreSQL locks.         |
| **Idempotency**          | Replay same payload; key reuse different payload; lease recovery.       | Integration + crash simulation.          |
| **Outbox/Inbox**         | Atomicity, SKIP LOCKED, duplicate delivery, reclaim lease.              | Integration + worker tests.              |
| **API Contract**         | OpenAPI request/response/ProblemDetail/ETag/202.                        | Contract tests/generated client.         |
| **Event Contract**       | Envelope/schema/backward compatibility.                                 | AsyncAPI/schema tests.                   |
| **Security**             | RBAC/ABAC/SoD/step-up/IDOR/mass assignment/rate limit.                  | Security test suite.                     |
| **Resilience**           | CT/Finance timeout, circuit breaker, UNKNOWN_EFFECT, reconciliation.    | Fault injection/WireMock/Testcontainers. |
| **Performance**          | Pricing engine, quote issue, promo locking, list APIs.                  | k6/JMeter/Gatling baseline.              |
| **Migration**            | Dry-run, duplicates, corrupted legacy, re-run idempotent.               | CT-16 fixtures.                          |
| **E2E Web**              | Pricing→quote→accept; scholarship/override; reconciliation.             | Playwright.                              |
| **Mobile**               | Quote read, promo apply, accept, offline stale.                         | RN test/E2E baseline.                    |
| **AI Evals**             | Grounding/provenance/no-decision boundaries.                            | CT-12 eval suite.                        |

## 28.1 Pruebas físicas no negociables

- Intentar SELECT cross-tenant con repository sin filtro: RLS devuelve 0 filas/deniega según operación.

- Intentar INSERT con tenant distinto al SET LOCAL: RLS WITH CHECK bloquea.

- Runtime role intenta SET row_security=off/BYPASSRLS: no debe tener privilegio.

- Crear dos PUBLISHED de mismo PriceBook: unique partial bloquea.

- Modificar PriceComponent de PriceBookVersion PUBLISHED: trigger bloquea.

- Modificar QuoteLine de quote ISSUED: trigger bloquea.

- UPDATE/DELETE PublicationReceipt/FinancialEffectReceipt: trigger bloquea.

- Dos reservas simultáneas sobre último uso: una gana; la otra 409 sin oversubscription.

- Quote total incoherente con line/adjustment result: application/domain test y CHECK de total root bloquean payload directo incoherente.

- Reusar Idempotency-Key con request_hash distinto: 409.

- Outbox dos workers claim: SKIP LOCKED evita doble ownership en el mismo claim window.

- Timeout Finance tras aplicar: ChargeIntent queda UNKNOWN_EFFECT y no se crea segundo intent.

| **GATE QA —** No se aprueba G2/G3/G7/G8 con SQL “demostrativo”. Flyway debe ejecutar desde cero en PostgreSQL limpio y sobre upgrade N-1, y las pruebas negativas deben adjuntarse al Evidence Pack. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 29. Golden Scenarios

Los Golden Scenarios son criterios ejecutables de aceptación end-to-end. Deben automatizarse cuando sea razonable y, cuando dependan de infraestructura externa, conservar evidencia reproducible de stub/fault injection/reconciliation. La evidencia se adjunta al gate correspondiente.

| **GS**      | **Escenario**                                | **Precondición**                              | **Acción**                              | **Resultado esperado**                                           | **Evidencia**                          |
|-------------|----------------------------------------------|-----------------------------------------------|-----------------------------------------|------------------------------------------------------------------|----------------------------------------|
| GS-EC03-001 | Crear PriceBookDefinition                    | Tenant/scope autorizado.                      | POST /price-books con idempotency key.  | 201, business key único, ETag 0.                                 | DB row + audit.                        |
| GS-EC03-002 | Duplicar código price book                   | Existe mismo code tenant.                     | Crear otro con mismo code.              | 409/422 estable; UQ protege.                                     | ProblemDetail + constraint test.       |
| GS-EC03-003 | Mismo código en otro tenant                  | Dos tenants aislados.                         | Crear code igual en B.                  | Permitido; A no visible desde B.                                 | RLS test.                              |
| GS-EC03-004 | Crear PriceBookVersion V1                    | Definition DRAFT/ACTIVE.                      | POST version.                           | DRAFT, version_no=1.                                             | Aggregate + ETag.                      |
| GS-EC03-005 | Clonar versión publicada                     | V1 PUBLISHED.                                 | Crear V2 desde V1.                      | Nueva DRAFT, lineage; V1 intacta.                                | Diff/DB.                               |
| GS-EC03-006 | Publicar tarifa válida                       | V DRAFT validada/aprobada.                    | Publish con If-Match/idempotency.       | PUBLISHED + receipt + outbox atómico.                            | Receipt/event.                         |
| GS-EC03-007 | Publicar con ETag obsoleto                   | Dos usuarios tienen ETag 4.                   | A muta child; B publica con 4.          | B recibe 412, sin efecto.                                        | Version + API trace.                   |
| GS-EC03-008 | Publicar con CT-02 unavailable               | Policy crítica no resoluble.                  | Publish.                                | 503/fail-closed; state no cambia.                                | ProblemDetail/audit.                   |
| GS-EC03-009 | Programar tarifa futura                      | APPROVED con valid_from futura.               | Schedule.                               | SCHEDULED inmutable.                                             | State/receipt preliminar según policy. |
| GS-EC03-010 | Activar programada                           | Llega valid_from, existe PUBLISHED previa.    | Scheduler command.                      | Nueva PUBLISHED y previa SUPERSEDED atómicamente.                | DB transaction + events.               |
| GS-EC03-011 | Mutar componente publicado                   | PriceBookVersion PUBLISHED.                   | UPDATE child vía API/SQL.               | API rechaza y trigger bloquea SQL.                               | Negative DB test.                      |
| GS-EC03-012 | Tier por cantidad                            | Component con tiers 1-10/11-25.               | Quote quantity 12.                      | Selecciona tier 11-25 exacto.                                    | PricingTrace.                          |
| GS-EC03-013 | Cantidad en borde tier                       | Tier 1-10 y 11-25.                            | Quantity=10 y 11.                       | Resultados de boundary correctos.                                | Golden pricing dataset.                |
| GS-EC03-014 | Monto decimal sensible                       | Precio 0.1/0.2 y rounding policy.             | Calcular quote.                         | BigDecimal exacto según policy; no float artifacts.              | Unit/golden test.                      |
| GS-EC03-015 | Binding por offering                         | Offering válida y PBV publicada.              | Crear binding.                          | Pin explícito; quote resuelve esa versión.                       | Binding ref + trace.                   |
| GS-EC03-016 | Offering inexistente                         | EC-02 responde 404.                           | Crear binding/quote.                    | 422/404 contractual; no shadow offering.                         | Contract test.                         |
| GS-EC03-017 | Promoción early bird válida                  | Promotion PUBLISHED en ventana.               | Quote dentro ventana.                   | Benefit aplicado una vez.                                        | Adjustment/provenance.                 |
| GS-EC03-018 | Promoción fuera de ventana                   | Misma promo vencida.                          | Quote después valid_to.                 | No aplica; explanation reason.                                   | PricingTrace.                          |
| GS-EC03-019 | Stacking permitido                           | Dos promos stackable por policy.              | Quote elegible a ambas.                 | Orden determinista y total esperado.                             | Adjustment order.                      |
| GS-EC03-020 | Stacking prohibido                           | Dos promos incompatibles.                     | Quote elegible a ambas.                 | Policy selecciona/rechaza según prioridad.                       | Reason codes.                          |
| GS-EC03-021 | Suspender promoción                          | Promo PUBLISHED.                              | Suspend command autorizado.             | Nuevas quotes no aplican; históricas intactas.                   | Event + old quote hash.                |
| GS-EC03-022 | Generar promo codes bulk                     | Pool ACTIVE, max \>= lote.                    | Generate 10k codes.                     | 202 OperationStatus, hash-only persistence.                      | Operation + DB sample.                 |
| GS-EC03-023 | Bulk excede capacidad                        | Request \> policy max.                        | Generate.                               | 422 capacity limit, nada parcial no declarado.                   | ProblemDetail.                         |
| GS-EC03-024 | Reservar código válido                       | Code AVAILABLE usos libres.                   | Reserve con key.                        | RESERVED, reserved_uses+1, lease.                                | DB lock/audit.                         |
| GS-EC03-025 | Reserva concurrente último uso               | max_uses=1, dos requests simultáneos.         | Reserve en paralelo.                    | Solo uno 201; otro 409.                                          | Concurrency test.                      |
| GS-EC03-026 | Replay de reserva                            | Reserva ya creada same key/payload.           | Retry.                                  | Mismo reservation/result, counters no duplican.                  | Idempotency record.                    |
| GS-EC03-027 | Key reutilizada payload distinto             | Key de reserva previa.                        | Enviar otro code/subject.               | 409 IDEMPOTENCY_KEY_REUSED.                                      | ProblemDetail.                         |
| GS-EC03-028 | Lease de reserva vence                       | RESERVED lease pasado.                        | Expiry job.                             | EXPIRED/RELEASED y counter decrementado una vez.                 | DB/audit.                              |
| GS-EC03-029 | Consumir reserva                             | Quote emitida/aceptada según policy.          | Consume reservation.                    | CONSUMED; redeemed+1, reserved-1.                                | Counters + audit.                      |
| GS-EC03-030 | Revoke promo code                            | Code AVAILABLE.                               | Revoke con reason.                      | REVOKED; futuras reservas rechazadas.                            | State/event.                           |
| GS-EC03-031 | Token no aparece en logs                     | Promo code plaintext en request.              | Ejecutar reserve y revisar logs/traces. | Token redactado; last4 permitido.                                | Log scan test.                         |
| GS-EC03-032 | Proponer beca                                | ScholarshipVersion PUBLISHED.                 | Create award ref subject/offering.      | PROPOSED sin PII local.                                          | DB/audit.                              |
| GS-EC03-033 | Elegibilidad negativa                        | CT-15 decision NOT_ELIGIBLE.                  | Submit/approve award.                   | 422/reject según workflow; no APPROVED.                          | Eligibility ref.                       |
| GS-EC03-034 | Aprobar beca con SoD                         | Officer propone; Approver distinto.           | Approve.                                | APPROVED con evidence/workflow.                                  | Audit/evidence.                        |
| GS-EC03-035 | Autoaprobación bloqueada                     | Policy exige SoD.                             | Proponente intenta approve.             | 403/422 SOD_VIOLATION.                                           | Authz test.                            |
| GS-EC03-036 | Beca vencida                                 | Award APPROVED expires_at pasado.             | Aplicar a quote.                        | No aplica; state EXPIRED/reason.                                 | Trace/state.                           |
| GS-EC03-037 | Revocar award no aplicado                    | Award APPROVED.                               | Revoke con reason.                      | REVOKED; nuevas quotes no lo usan.                               | Event/audit.                           |
| GS-EC03-038 | Convenio válido                              | EC-09 agreement ACTIVE + profile ACTIVE.      | Quote corporate.                        | Benefit rule aplicado con agreement ref.                         | Trace/source doc ref.                  |
| GS-EC03-039 | Convenio suspendido                          | Agreement/profile no válido.                  | Quote corporate.                        | No aplicar; fail-closed si se declaró obligatorio.               | Reason/provenance.                     |
| GS-EC03-040 | Crear quote normal                           | Offering + PBV resolubles.                    | POST /quotes.                           | CALCULATED con líneas/trace/totales.                             | Quote row.                             |
| GS-EC03-041 | Preview no persiste                          | Context válido.                               | POST /quotes:preview.                   | 200 resultado; no CommercialQuote oficial.                       | DB assertion.                          |
| GS-EC03-042 | Total quote determinista                     | Mismo context/version/asOf.                   | Calcular dos veces.                     | Mismos montos/trace hash.                                        | Golden hash.                           |
| GS-EC03-043 | Issue quote                                  | CALCULATED + ETag actual.                     | Issue.                                  | ISSUED, content_hash, expires_at, immutable.                     | Audit/event.                           |
| GS-EC03-044 | Modificar línea emitida                      | Quote ISSUED.                                 | PATCH/SQL child.                        | Bloqueado por API + trigger.                                     | DB negative test.                      |
| GS-EC03-045 | Requote de quote emitida                     | ISSUED necesita cambio.                       | Requote.                                | Nueva quote con parent_quote_id; original intacta.               | Lineage.                               |
| GS-EC03-046 | Aceptar quote vigente                        | ISSUED no expirada.                           | Accept idempotente.                     | ACCEPTED; event una vez.                                         | Audit/outbox.                          |
| GS-EC03-047 | Aceptar quote expirada                       | ISSUED expires_at pasado.                     | Accept.                                 | 422 QUOTE_EXPIRED; no ChargeIntent.                              | ProblemDetail.                         |
| GS-EC03-048 | Replay aceptar quote                         | Quote ya ACCEPTED same key.                   | Retry.                                  | Mismo resultado; no duplicar events/intents.                     | Idempotency/outbox.                    |
| GS-EC03-049 | Void quote emitida                           | ISSUED; actor autorizado.                     | Void con reason/step-up.                | VOID durable; no hard delete.                                    | Audit/event.                           |
| GS-EC03-050 | Quote con ZERO legítimo                      | Policy/beca 100% permitida.                   | Calcular/issue.                         | total=0 con explanation ZERO, no NO_DATA.                        | Trace/UI E2E.                          |
| GS-EC03-051 | Pricing unavailable                          | CT crítica caída.                             | Preview/quote.                          | UNAVAILABLE/503; nunca total 0.                                  | UI + ProblemDetail.                    |
| GS-EC03-052 | Pricing parcial                              | Dependencia no crítica stale.                 | Preview.                                | PARTIAL con asOf/provenance; issue bloqueado si policy lo exige. | UI state.                              |
| GS-EC03-053 | Solicitar override                           | Quote CALCULATED.                             | Create override 5%.                     | DRAFT/SUBMITTED, no cambia quote aún.                            | Override row.                          |
| GS-EC03-054 | Aprobar override bajo threshold              | Approver autorizado distinto.                 | Approve.                                | APPROVED + evidence.                                             | Workflow/audit.                        |
| GS-EC03-055 | Override excede threshold                    | Approval limit 10%, request 25%.              | Approver nivel bajo intenta approve.    | 403/422; escalamiento workflow.                                  | ABAC test.                             |
| GS-EC03-056 | Aplicar override                             | Override APPROVED.                            | Apply con quote ETag.                   | Quote recalculada/nueva según state; adjustment source OVERRIDE. | Trace/lineage.                         |
| GS-EC03-057 | Override sobre ISSUED                        | Quote ya ISSUED.                              | Apply.                                  | No muta original; requiere requote.                              | Lineage test.                          |
| GS-EC03-058 | Crear ChargeIntent                           | Quote ACCEPTED, Finance customer válido.      | POST charge-intents.                    | CREATED/SENT, amount=quote total, idempotency.                   | Intent/audit.                          |
| GS-EC03-059 | Finance confirma                             | Intent SENT.                                  | Respuesta confirmed.                    | CONFIRMED + FinancialEffectReceipt append-only.                  | Receipt.                               |
| GS-EC03-060 | Timeout tras efecto remoto                   | Finance aplicó y respuesta se pierde.         | Client timeout.                         | UNKNOWN_EFFECT, sin retry ciego.                                 | Fault injection.                       |
| GS-EC03-061 | Reconcile encuentra aplicado                 | Intent UNKNOWN_EFFECT.                        | Query Finance por key/ref.              | CONFIRMED + reconciliation receipt.                              | Receipt/status.                        |
| GS-EC03-062 | Reconcile demuestra no aplicado              | Finance NOT_FOUND contractual.                | Reconcile.                              | Eligible para retry misma idempotency key.                       | Audit.                                 |
| GS-EC03-063 | Reconcile sigue desconocido                  | Finance no puede confirmar.                   | Reconcile.                              | Permanece UNKNOWN_EFFECT + alerta.                               | Metric/runbook.                        |
| GS-EC03-064 | Receipt append-only                          | Existe receipt.                               | UPDATE/DELETE SQL.                      | DB rechaza.                                                      | Constraint trigger test.               |
| GS-EC03-065 | Outbox atomicidad                            | Issue quote y falla commit.                   | Rollback.                               | Ni quote issued ni event huérfano.                               | Integration transaction test.          |
| GS-EC03-066 | Outbox doble worker                          | Dos workers activos.                          | Claim batch concurrente.                | SKIP LOCKED entrega ownership único.                             | Worker test.                           |
| GS-EC03-067 | Outbox lease perdido                         | Worker muere IN_FLIGHT.                       | Lease expira/reclaimer.                 | Evento vuelve reclamable sin perder payload.                     | Recovery test.                         |
| GS-EC03-068 | Inbox duplicate                              | Mismo messageId dos veces.                    | Consume.                                | Side effect una vez; duplicate ack.                              | Inbox row.                             |
| GS-EC03-069 | Inbox same id different payload              | messageId conocido hash distinto.             | Consume.                                | Security/contract error; no procesar.                            | Audit.                                 |
| GS-EC03-070 | RLS lectura cross-tenant                     | Tenant B conoce UUID de A.                    | GET/repository by id.                   | 404/no row; no leak de existencia.                               | Security test.                         |
| GS-EC03-071 | RLS insert tenant falso                      | Tenant B intenta tenant_id A por SQL/runtime. | INSERT.                                 | WITH CHECK bloquea.                                              | DB test.                               |
| GS-EC03-072 | Mass assignment tenant/state                 | Body incluye tenantId/approvedBy/state.       | POST/PATCH.                             | Campos ignorados/rechazados; server controls.                    | API test.                              |
| GS-EC03-073 | OperationStatus bulk                         | Generate codes retorna 202.                   | Consultar Location.                     | PENDING/RUNNING→SUCCEEDED y progreso monotónico.                 | API/E2E.                               |
| GS-EC03-074 | OperationStatus falla                        | Job bulk falla por policy.                    | Consultar.                              | FAILED + stable error; no “success parcial” oculto.              | Operation result.                      |
| GS-EC03-075 | Mobile quote cache stale                     | Quote fue cacheada offline.                   | Abrir offline.                          | Muestra STALE y expiresAt; accept disabled.                      | Mobile E2E.                            |
| GS-EC03-076 | Mobile accept online                         | Quote ISSUED vigente.                         | Deep link + auth + accept.              | Idempotent ACCEPTED; step-up si policy.                          | Mobile/API trace.                      |
| GS-EC03-077 | IA explica quote                             | Quote oficial con trace.                      | Solicitar explanation CT-12.            | Resumen no altera montos, guarda run/provenance.                 | AI eval/audit.                         |
| GS-EC03-078 | IA sugiere precio                            | PriceBook DRAFT.                              | Solicitar suggestion.                   | Draft suggestion; no persist/publish automático.                 | AI boundary test.                      |
| GS-EC03-079 | Migración tariff dry-run                     | Batch CT-16 normalizado.                      | Dry-run.                                | Report PASS/WARN/FAIL, sin truth rows.                           | Migration receipt.                     |
| GS-EC03-080 | Migración re-run                             | Batch ya promovido same keys.                 | Reejecutar.                             | Idempotent/no duplicates.                                        | Idempotency/migration test.            |
| GS-EC03-081 | Upgrade N-1 compatible                       | App N y N-1 durante rollout.                  | Aplicar expand migration.               | Ambas versiones funcionan en ventana.                            | Deployment test.                       |
| GS-EC03-082 | Rollback app sin rollback schema destructivo | Release app falla.                            | Roll back binary N-1.                   | Schema expand sigue compatible.                                  | Runbook evidence.                      |
| GS-EC03-083 | Capacity quote lines                         | Request produciría \> budget.                 | Calculate.                              | 422 capacity limit; no OOM.                                      | Performance/security test.             |
| GS-EC03-084 | Rate limit promo brute force                 | Subject excede intentos.                      | Reserve invalid tokens repetidos.       | 429 sin revelar token validity oracle detallado.                 | Security test.                         |
| GS-EC03-085 | Multi-currency no implícita                  | PBV BOB, context USD sin FX contract.         | Quote.                                  | 422 PRICE_CURRENCY_MISMATCH; no conversión inventada.            | Pricing test.                          |
| GS-EC03-086 | FX explícito gobernado                       | FX policy/source contractual disponible.      | Quote cross-currency habilitada.        | Rate/version/asOf pinneados en trace; rounding correcto.         | Trace/evidence.                        |

| **COBERTURA —** Los 80 Golden Scenarios cubren happy path, edge cases, concurrencia, RLS, idempotencia, outbox/inbox, stale/partial/unavailable, UNKNOWN_EFFECT, seguridad, Mobile, IA, migración y zero-downtime. Ningún GS se aprueba sin evidencia. |
|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 30. UAT institucional

| **UAT**     | **Escenario**            | **Actor**                      | **Pasos**                                          | **Criterio de aceptación**                       | **Evidencia**              |
|-------------|--------------------------|--------------------------------|----------------------------------------------------|--------------------------------------------------|----------------------------|
| UAT-EC03-01 | Publicar tarifario       | Pricing Manager + Approver     | Crear V1, componentes, validar, revisar, publicar. | Una PUBLISHED, receipt y catálogo visible.       | Screens + audit + receipt. |
| UAT-EC03-02 | Programar tarifa futura  | Approver                       | Schedule V2 y llegar/forzar effective time.        | V2 vigente, V1 superseded sin historia alterada. | Timeline/events.           |
| UAT-EC03-03 | Cotizar curso abierto    | Quote Operator                 | Elegir offering/person/channel y calcular.         | Total/trace comprensible y reproducible.         | Quote export.              |
| UAT-EC03-04 | Early bird               | Marketing + Operator           | Publicar promo y cotizar dentro/fuera ventana.     | Solo dentro aplica.                              | Two quote traces.          |
| UAT-EC03-05 | Promo code único         | Participant/Operator           | Aplicar código y reintentar.                       | Un consumo, replay idempotente.                  | Counters/audit.            |
| UAT-EC03-06 | Promo code concurrente   | QA/UAT group                   | Dos usuarios usan último cupo.                     | Solo uno obtiene reserva.                        | Parallel evidence.         |
| UAT-EC03-07 | Beca aprobada            | Scholarship Officer/Approver   | Elegibilidad, workflow, approve, quote.            | Beneficio aparece con provenance.                | Decision/workflow/quote.   |
| UAT-EC03-08 | Beca rechazada           | Scholarship Approver           | Procesar no elegible.                              | No discount; reason explicable.                  | UAT log.                   |
| UAT-EC03-09 | Convenio corporativo     | Corporate Ops                  | Activar profile y cotizar participante.            | Beneficio conforme al acuerdo.                   | Agreement/evidence refs.   |
| UAT-EC03-10 | Override controlado      | Requester/Approver             | Solicitar 5%, aprobar, aplicar.                    | SoD y quote ajustada/requote.                    | Workflow/audit.            |
| UAT-EC03-11 | Override fuera de límite | Approver junior                | Intentar 30%.                                      | Bloqueado/escalado.                              | 403/422 + workflow.        |
| UAT-EC03-12 | Quote expirada           | Operator                       | Emitir con expiry y aceptar luego.                 | Rechazada, requiere requote.                     | ProblemDetail.             |
| UAT-EC03-13 | Quote cero               | Scholarship case               | Calcular 100% waiver permitido.                    | ZERO legítimo, no unavailable.                   | UI capture/trace.          |
| UAT-EC03-14 | Finance happy path       | Operator/Finance liaison       | Aceptar quote y crear charge.                      | CONFIRMED + receipt, Finance SoT.                | Both system refs.          |
| UAT-EC03-15 | Finance timeout          | Ops                            | Simular timeout tras apply.                        | UNKNOWN_EFFECT visible; no double charge.        | Fault evidence.            |
| UAT-EC03-16 | Reconciliation           | Reconciler                     | Resolver unknown por remote query.                 | Terminal consistente + receipt.                  | Runbook record.            |
| UAT-EC03-17 | RLS tenant               | Security/UAT                   | Intentar acceder UUID de otro tenant.              | No exposición.                                   | Security report.           |
| UAT-EC03-18 | ETag conflict            | Dos operadores                 | Editar misma quote/draft.                          | Segundo recibe 412 y rebase UI.                  | UI/API trace.              |
| UAT-EC03-19 | Policy unavailable       | Ops/UAT                        | Caer CT-02 en issue.                               | Fail-closed; mensaje UNAVAILABLE.                | Fault injection.           |
| UAT-EC03-20 | Partial read model       | Ops/UAT                        | Retrasar Mongo projection.                         | STALE/PARTIAL explícito, mutations correctas.    | UI state.                  |
| UAT-EC03-21 | Bulk promo generation    | Marketing Ops                  | Generar lote grande.                               | 202 + progress + secure delivery.                | Operation/status.          |
| UAT-EC03-22 | Revoke promo             | Marketing Ops                  | Revocar código/pool.                               | Nuevas reservas bloqueadas.                      | State/audit.               |
| UAT-EC03-23 | Mobile quote             | Participant                    | Abrir deep link y revisar.                         | Montos/expiry/discounts accesibles.              | Mobile capture.            |
| UAT-EC03-24 | Mobile accept            | Participant                    | Aceptar online con auth.                           | ACCEPTED idempotente.                            | Mobile/API evidence.       |
| UAT-EC03-25 | AI explanation           | Operator                       | Pedir explicación.                                 | Texto consistente con trace, no cambia datos.    | AI run/eval.               |
| UAT-EC03-26 | Migration dry-run        | Data Steward                   | Importar tarifario legacy.                         | Reporte y cero inserts finales.                  | CT-16 receipt.             |
| UAT-EC03-27 | Migration promote        | Data Steward                   | Promover batch aprobado.                           | Domain commands + lineage/audit.                 | Receipts.                  |
| UAT-EC03-28 | Outbox recovery          | Ops                            | Matar worker luego de claim.                       | Lease recovery entrega evento.                   | Worker metrics.            |
| UAT-EC03-29 | Accessibility            | Usuario keyboard/screen reader | Recorrer Quote Desk.                               | WCAG 2.2 AA baseline, focus/labels.              | A11y report.               |
| UAT-EC03-30 | Release N/N-1            | DevOps/UAT                     | Rolling deploy con expand migration.               | Sin downtime ni incompatibilidad.                | Deployment report.         |

# 31. Gates G1-G10

| **Gate** | **Tema**                       | **Evidencia mínima**                                                                         | **Aprueba**          |
|----------|--------------------------------|----------------------------------------------------------------------------------------------|----------------------|
| **G1**   | Arquitectura y bounded context | EC-03 scope/anti-scope, Source of Truth, DDD, DA/ADR cerrados.                               | Architect + Product  |
| **G2**   | Datos/constraints              | 31 tablas, Flyway desde cero, RLS, FKs tenant-aware, triggers, rollback/upgrade evidence.    | DBA + Backend        |
| **G3**   | Backend                        | Aggregates, commands, policies, pricing determinism, idempotency, unit/integration tests.    | Backend Lead         |
| **G4**   | API/Event contracts            | OpenAPI/AsyncAPI completos, ProblemDetail, ETag, pagination, compatibility tests.            | API Architect        |
| **G5**   | Frontend/Mobile                | Workspaces, explicit states, accessibility, generated client, Mobile boundaries.             | Frontend/Mobile Lead |
| **G6**   | Seguridad/auditoría            | RBAC/ABAC/SoD/step-up, RLS tests, Threat Model, Secure SDLC, Evidence Pack.                  | Security             |
| **G7**   | Integraciones/resiliencia      | CT/EC02/EC09/Finance contracts, outbox/inbox, UNKNOWN_EFFECT and reconciliation fault tests. | Integration/SRE      |
| **G8**   | QA/UAT                         | Golden Scenarios, E2E, performance, security, institutional UAT evidence.                    | QA + PO              |
| **G9**   | Migración/operaciones          | CT-16 migration, observability, runbooks, RTO/RPO, rehearsal.                                | Data/SRE             |
| **G10**  | Release/certificación          | DoD, SBOM/scans, N/N-1 rollout, release checklist, sign-off.                                 | Release Board        |

| **NO EVIDENCE = NO GATE —** Una reunión, una captura aislada o “funciona en mi máquina” no constituyen evidencia. Cada Gate enlaza artefactos versionados, tests, logs/reports y responsables. |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

# 32. Definition of Ready / Definition of Done

## 32.1 Definition of Ready (DoR)

- Scope/anti-scope y Source of Truth aceptados.

- DA/ADR que bloquean implementación cerrados o con decisión temporal explícita.

- UX journey/workspace y actores definidos.

- Reglas BR vinculadas a casos de uso/tests.

- Modelo físico/constraints revisados por DBA/Backend.

- OpenAPI/AsyncAPI draft disponible antes de Frontend paralelo.

- Dependencias CT/EC02/EC09/Finance con contratos y sandbox/stubs definidos.

- Threat Model y clasificación de datos completados.

- Capacity/SLO objetivos establecidos.

- Migración/legacy evaluada cuando aplica.

- Feature flags/rollout plan definidos si el cambio es evolutivo.

## 32.2 Definition of Done (DoD)

- Código backend/frontend/mobile aplicable merged con review Senior.

- Flyway ejecuta en DB limpia y upgrade N-1; schema compatible con rolling deploy.

- OpenAPI/AsyncAPI publicados y generated client actualizado.

- Unit/domain/repository/integration/contract/security/concurrency/idempotency/resilience tests verdes.

- Golden Scenarios automatizables ejecutados; UAT firmado.

- RLS negative tests y runtime-role audit aprobados.

- SAST/SCA/secret/container scans dentro de política; SBOM generado.

- Observability dashboards/alerts y business metrics operativos.

- Runbooks ensayados; UNKNOWN_EFFECT drill realizado.

- Evidence Pack de Gates completo.

- Docs/ADRs/runbooks alineados; no TODO crítico oculto.

- Release/rollback/roll-forward plan probado; feature flags documentadas.

- No known Sev-1/Sev-2 abiertos sin waiver formal temporal.

# 33. Runbooks

| **Runbook**     | **Incidente**                     | **Secuencia operacional**                                                                                                          |
|-----------------|-----------------------------------|------------------------------------------------------------------------------------------------------------------------------------|
| **RB-EC03-001** | Pricing UNAVAILABLE               | Confirmar dependency health → correlation → circuit state → fallback solo si policy lo permite → comunicar sin mostrar ZERO.       |
| **RB-EC03-002** | Quote total inconsistente         | Bloquear issue → capturar trace/hash → aislar engine/policy version → reproducir golden input → corregir sin editar quote emitida. |
| **RB-EC03-003** | Promo code oversubscription alert | Pausar pool si riesgo → verificar counters/reservations/locks → reconciliar leases → evidence → reactivar.                         |
| **RB-EC03-004** | Promo token leakage               | Revocar afectados → rotar/invalidar delivery channel → investigar logs → privacy/security incident process.                        |
| **RB-EC03-005** | Bulk generation stuck             | OperationStatus → worker lease → reclaim/retry chunks idempotentes → no regenerar tokens ya committed.                             |
| **RB-EC03-006** | Scholarship workflow stuck        | Consultar CT-06 por workflow/idempotency → reconcile → no duplicar case.                                                           |
| **RB-EC03-007** | Override anomalous spike          | Congelar approvals por policy/feature flag → revisar actors/reasons → Security/Commercial governance.                              |
| **RB-EC03-008** | Finance UNKNOWN_EFFECT            | No retry ciego → query by idempotency/external ref → record receipt → confirm/retry/escalate.                                      |
| **RB-EC03-009** | Finance outage                    | Open circuit → queue/create intent según policy → UI UNAVAILABLE/PENDING no confirmed → recover/reconcile.                         |
| **RB-EC03-010** | Outbox backlog                    | Oldest age → broker health → claim workers → poison messages → replay governed.                                                    |
| **RB-EC03-011** | Inbox poison message              | Quarantine by messageId/type → contract diff → fix adapter → replay once.                                                          |
| **RB-EC03-012** | RLS incident                      | Revoke runtime credentials if leak suspected → preserve evidence → security incident → tenant impact analysis.                     |
| **RB-EC03-013** | PriceBook bad publish             | Suspend new use/void or supersede by new version → never mutate snapshot → notify downstream.                                      |
| **RB-EC03-014** | Promotion bad publish             | Suspend version → assess issued quotes → policy-driven compensation, no historical rewrite.                                        |
| **RB-EC03-015** | Quote expiration job lag          | Measure backlog → safe catch-up → idempotent transitions → no accept after effective expiry.                                       |
| **RB-EC03-016** | Redis loss                        | Bypass/warm cache from PostgreSQL; correctness unchanged.                                                                          |
| **RB-EC03-017** | Mongo projection stale            | Mark STALE/PARTIAL → rebuild from events/DB → mutations continue on PostgreSQL.                                                    |
| **RB-EC03-018** | Migration rollback                | Stop promotion → use receipts to identify created resources → compensate/version/void via domain; no DELETE history.               |
| **RB-EC03-019** | Schema rollout failure            | Stop rollout → keep expand schema → rollback app N-1 → forward-fix migration.                                                      |
| **RB-EC03-020** | AI incident                       | Disable CT-12 feature flag → preserve run/eval refs → manual workflow remains available.                                           |

# 34. ADRs y decisiones abiertas

| **ADR**          | **Tema**                   | **Decisión**                                                                                         | **Estado**                      |
|------------------|----------------------------|------------------------------------------------------------------------------------------------------|---------------------------------|
| **ADR-EC03-001** | Money                      | numeric(19,4)+BigDecimal; no float/double.                                                           | CERRADO                         |
| **ADR-EC03-002** | PriceBook versioning       | Published/Scheduled snapshots inmutables.                                                            | CERRADO                         |
| **ADR-EC03-003** | Quote semantics            | ISSUED quote es snapshot inmutable; requote crea nueva identidad.                                    | CERRADO                         |
| **ADR-EC03-004** | Financial boundary         | ChargeIntent ≠ ledger; Finance SoT.                                                                  | CERRADO                         |
| **ADR-EC03-005** | Promo token storage        | Hash + last4; plaintext no persistente.                                                              | CERRADO                         |
| **ADR-EC03-006** | Promo concurrency          | PostgreSQL row locking + counters constraints.                                                       | CERRADO                         |
| **ADR-EC03-007** | Tenant isolation           | RLS ENABLE+FORCE + roles separados.                                                                  | CERRADO                         |
| **ADR-EC03-008** | Aggregate revision         | Child mutation bumps root ETag.                                                                      | CERRADO                         |
| **ADR-EC03-009** | Idempotency                | Durable PostgreSQL lease/recovery.                                                                   | CERRADO                         |
| **ADR-EC03-010** | Outbox                     | Transactional outbox + SKIP LOCKED lease.                                                            | CERRADO                         |
| **ADR-EC03-011** | Remote writes              | UNKNOWN_EFFECT + reconciliation-before-retry.                                                        | CERRADO                         |
| **ADR-EC03-012** | Agreement ownership        | EC-09 owns agreement; EC-03 owns benefit projection.                                                 | CERRADO                         |
| **ADR-EC03-013** | Scholarship eligibility    | CT-15 decision; EC-03 award.                                                                         | CERRADO                         |
| **ADR-EC03-014** | Tax semantics              | EC-03 calcula comercialmente por policy; Finance/fiscal core confirma hecho oficial.                 | CERRADO                         |
| **ADR-EC03-015** | FX                         | Solo mediante policy/source contractual pinneado; sin conversión implícita.                          | CERRADO                         |
| **ADR-EC03-016** | Frontend contract          | OpenAPI-generated client obligatorio.                                                                | CERRADO                         |
| **ADR-EC03-017** | Mobile                     | Participant quote/promo/accept; admin crítico Web.                                                   | CERRADO                         |
| **ADR-EC03-018** | Read models                | Mongo/Redis no autoritativos.                                                                        | CERRADO                         |
| **ADR-EC03-019** | Zero downtime              | Expand/contract N/N-1; no destructive one-shot migration.                                            | CERRADO                         |
| **ADR-EC03-020** | Advanced revenue/proration | Si aparecen revenue recognition/proration complejos, pertenecen Finance; EC-03 solo intents/context. | ABIERTO SOLO A CONTRATO FINANCE |

# 35. Engineering Pack

El Word es Especificación Maestra Oficial; Git contiene artefactos ejecutables. Como mínimo, el repositorio debe materializar los siguientes archivos/rutas para certificar EC-03:

| **Ruta**                                               | **Contenido mínimo**                               |
|--------------------------------------------------------|----------------------------------------------------|
| **/docs/ec03/README.md**                               | Resumen, scope, links al Word/baseline.            |
| **/docs/ec03/business-rules.md**                       | BR-EC03 trazables a tests.                         |
| **/openapi/ec03-commercial-v1.yaml**                   | Contrato REST completo.                            |
| **/asyncapi/ec03-events-v1.yaml**                      | Eventos/envelopes.                                 |
| **/db/migration/ec03/V1\_\_commercial_foundation.sql** | DDL inicial aquí especificado.                     |
| **/db/migration/ec03/V2\_\_\*.sql**                    | Evoluciones expand/contract.                       |
| **/architecture/ec03/context.mmd**                     | Context diagram source.                            |
| **/architecture/ec03/domain.mmd**                      | Domain diagram source.                             |
| **/architecture/ec03/physical.mmd**                    | DER source.                                        |
| **/adr/ec03/ADR-EC03-\*.md**                           | Decisiones.                                        |
| **/backend/ec03/...**                                  | Módulo Spring Modulith.                            |
| **/frontend/src/features/ec03/...**                    | Workspaces/features.                               |
| **/mobile/src/features/ec03/...**                      | Journey móvil aplicable.                           |
| **/tests/ec03/domain**                                 | Domain/unit.                                       |
| **/tests/ec03/integration**                            | PostgreSQL/RLS/concurrency/idempotency.            |
| **/tests/ec03/contract**                               | OpenAPI/AsyncAPI/CT/Finance contracts.             |
| **/tests/ec03/e2e**                                    | Playwright/mobile E2E.                             |
| **/performance/ec03/k6**                               | Load/performance scripts.                          |
| **/security/ec03/threat-model.md**                     | Threat Model y mitigaciones.                       |
| **/security/ec03/evidence**                            | SAST/SCA/SBOM/DAST/RLS reports.                    |
| **/runbooks/ec03/RB-EC03-\*.md**                       | Runbooks operativos.                               |
| **/observability/ec03**                                | Dashboards, alerts, SLO definitions.               |
| **/migration/ec03**                                    | CT-16 mappings, dry-run fixtures, receipts schema. |
| **/evidence/ec03/gates**                               | Evidence Pack G1-G10.                              |

# 36. Guía secuencial Backend

11. Paso 1 — Crear módulo Spring Modulith ec.commercial y package boundaries; agregar ArchitectureTests para prohibir imports cross-context no autorizados.

12. Paso 2 — Crear Value Objects Money, CurrencyCode, Percentage, AggregateRevision, PolicyVersionRef, IdempotencyKey, ExternalRef y QuoteContext.

13. Paso 3 — Implementar PriceBookDefinition/PriceBookVersion aggregates y state machines.

14. Paso 4 — Implementar PriceComponent/Tier/ScopeBinding como hijos con methods de intención.

15. Paso 5 — Implementar PromotionCampaign/Version, conditions y benefits tipados.

16. Paso 6 — Implementar PromoCodePool/PromoCode/Reservation con row locking y counters invariants.

17. Paso 7 — Implementar ScholarshipProgram/Version/Award y puertos CT-15/CT-06.

18. Paso 8 — Implementar AgreementBenefitProfile/Rule sin copiar contrato EC-09.

19. Paso 9 — Implementar CommercialQuote aggregate, QuoteLine, QuoteAdjustment y lineage.

20. Paso 10 — Implementar OverrideRequest + thresholds/SoD via policy/authorization.

21. Paso 11 — Implementar ChargeIntent + FinancialEffectReceipt + UNKNOWN_EFFECT state machine.

22. Paso 12 — Crear Flyway V1 y ejecutar en PostgreSQL limpio mediante Testcontainers.

23. Paso 13 — Configurar roles migrator/runtime/worker y RLS ENABLE+FORCE; test de bypass negativo.

24. Paso 14 — Implementar TenantTransactionInterceptor que ejecuta SET LOCAL peopleu.tenant_id antes de repository access.

25. Paso 15 — Configurar JPA @Version en roots y AggregateRevision contract para child commands.

26. Paso 16 — Implementar repositories hexagonales con locks explícitos where needed; prohibir generic repository child mutations.

27. Paso 17 — Implementar PricingEngine determinista con BigDecimal, explicit rounding points y PricingTrace.

28. Paso 18 — Implementar PolicyCatalogPort CT-02 y snapshot/version pinning.

29. Paso 19 — Implementar OfferingPort EC-02 y AgreementPort EC-09 con timeout/circuit/freshness.

30. Paso 20 — Implementar EligibilityPort CT-15 y WorkflowPort CT-06 con receipts/reconciliation contracts.

31. Paso 21 — Implementar FinancePort con idempotency key, external operation ref y queryStatus/reconcile.

32. Paso 22 — Implementar durable CommandIdempotency acquisition, lease, replay y recovery.

33. Paso 23 — Implementar outbox dispatcher multi-instancia con FOR UPDATE SKIP LOCKED, lease/backoff y replay gobernado.

34. Paso 24 — Implementar inbox dedup same-id/same-hash y poison-message handling.

35. Paso 25 — Implementar REST controllers/use cases y ProblemDetail reason codes; ningún controller contiene reglas de dominio.

36. Paso 26 — Publicar OpenAPI y generar contract tests; validar ETag/If-Match en roots y child commands.

37. Paso 27 — Publicar AsyncAPI/event schemas y compatibility tests.

38. Paso 28 — Implementar OperationStatus para bulk generation/import/reconciliation async.

39. Paso 29 — Instrumentar logs/metrics/traces y redaction de promo tokens/PII.

40. Paso 30 — Completar unit/domain/repository/integration/RLS/concurrency/idempotency/resilience tests.

41. Paso 31 — Ejecutar performance budgets y optimizar indexes con EXPLAIN evidence.

42. Paso 32 — Ensayar UNKNOWN_EFFECT, outbox recovery, schema N/N-1 y runbooks antes de G10.

# 37. Guía secuencial Frontend

43. Paso 1 — Crear feature root src/features/ec03 y route namespace /ec/commercial.

44. Paso 2 — Generar TypeScript client desde openapi/ec03-commercial-v1.yaml; prohibir DTO duplication.

45. Paso 3 — Definir query keys incluyendo tenant/scope/resource y invalidation rules por command/event.

46. Paso 4 — Crear ProblemDetail mapper reasonCode→i18n/action; mostrar correlationId en errores operacionales.

47. Paso 5 — Implementar state primitives NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT/CONFLICT.

48. Paso 6 — Construir workspace shell compartido con breadcrumbs, scope selector autorizado, command bar y audit drawer.

49. Paso 7 — Construir Pricing Studio: list/detail/version tabs, components, tiers, scopes, validation, diff, review/publish.

50. Paso 8 — Construir Offering Pricing Desk con coverage matrix y binding wizard.

51. Paso 9 — Construir Promotion Campaign Center con conditions/benefits/stacking simulator.

52. Paso 10 — Construir Promo Code Console con pool generation OperationStatus, last4 search, revoke/support.

53. Paso 11 — Nunca mostrar nuevamente token plaintext desde server; secure delivery only at generation result policy.

54. Paso 12 — Construir Scholarship Desk con eligibility/workflow/evidence refs y SoD-aware actions.

55. Paso 13 — Construir Agreement Benefits Desk con source agreement/evidence panel y rule versioning.

56. Paso 14 — Construir Quote Desk con QuoteContext form, preview, lines, adjustments y Pricing Explanation.

57. Paso 15 — Incorporar ETag capture por query response y If-Match automático en mutations.

58. Paso 16 — Ante 412 congelar draft local, refetch, mostrar diff/rebase; nunca silent retry.

59. Paso 17 — Construir Override Inbox con thresholds, reason/evidence, requester/approver separation.

60. Paso 18 — Construir Commercial Reconciliation Center para ChargeIntent/UNKNOWN_EFFECT/outbox operation status.

61. Paso 19 — Implementar 202 OperationStatus panel/polling con exponential backoff y cancel cuando contrato lo permita.

62. Paso 20 — Implementar filters/sort/pagination bounded y preserve state in URL para workspaces listables.

63. Paso 21 — Implementar accessibility keyboard/focus/live regions/table headers y contrast WCAG 2.2 AA.

64. Paso 22 — Implementar responsive layouts: side panels→drawers; no perder acciones críticas.

65. Paso 23 — Implementar permission guards solo como UX; server sigue siendo authority.

66. Paso 24 — Implementar stale/provenance badges con asOf y source.

67. Paso 25 — Implementar skeletons/empty states/errors sin confundir unavailable con empty.

68. Paso 26 — Agregar telemetry UX sin PII ni promo token; correlate frontend requestId/correlationId.

69. Paso 27 — Escribir unit/component tests de money rendering, state model y forms.

70. Paso 28 — Escribir MSW/contract tests usando generated schemas/fixtures.

71. Paso 29 — Escribir Playwright E2E para Golden Scenarios prioritarios.

72. Paso 30 — Integrar Mobile deep links/route contracts aplicables.

73. Paso 31 — Completar a11y/performance bundle checks y evidencia G5/G8 antes de release.

# 38. Matriz de permisos

| **Permission**                | **Roles típicos**                  | **ABAC/state**                      | **Step-up**    |
|-------------------------------|------------------------------------|-------------------------------------|----------------|
| **pricebook.read**            | Viewer, Pricing, Approver, Auditor | tenant + owner scope                | No             |
| **pricebook.edit**            | Pricing Manager                    | DRAFT + owner scope                 | No             |
| **pricebook.publish**         | Pricing Approver                   | APPROVED/SCHEDULED + SoD            | Sí             |
| **promotion.edit**            | Promotion Manager                  | DRAFT + scope                       | No             |
| **promotion.publish**         | Commercial Approver                | APPROVED + threshold                | Según benefit  |
| **promocode.generate**        | Promotion Manager                  | Pool ACTIVE + capacity              | Según volumen  |
| **promocode.revoke**          | Promotion Manager/Ops              | scope + reason                      | Opcional       |
| **scholarship.propose**       | Scholarship Officer                | Offering/scope                      | No             |
| **scholarship.approve**       | Scholarship Approver               | SoD + eligibility                   | Sí si policy   |
| **agreementbenefit.activate** | Corporate Ops/Approver             | agreement ACTIVE + evidence         | Sí si policy   |
| **quote.create**              | Quote Operator                     | Offering/customer scope             | No             |
| **quote.issue**               | Quote Operator/Approver            | CALCULATED + no critical unresolved | Según amount   |
| **quote.accept**              | Customer/Authorized Staff          | ISSUED + customer authorization     | Según policy   |
| **quote.void**                | Authorized Staff                   | ISSUED + reason                     | Sí             |
| **override.request**          | Quote Operator                     | Quote editable/requote              | No             |
| **override.approve**          | Override Approver                  | Threshold + SoD                     | Sí             |
| **override.apply**            | Quote Operator/System              | Approved override + ETag            | No adicional   |
| **charge.create**             | System/Authorized Staff            | Quote ACCEPTED                      | Sí/contract    |
| **charge.reconcile**          | Commercial Reconciler              | UNKNOWN_EFFECT                      | Sí             |
| **audit.read**                | Auditor                            | purpose + scope                     | Sí para export |

# 39. Contratos DTO Frontend

Los siguientes tipos son ilustración del contrato esperado y deben generarse desde OpenAPI. La fuente ejecutable es el YAML; no se mantienen dos definiciones divergentes a mano.

export type UiDataState =

\| 'READY' \| 'NO_DATA' \| 'ZERO' \| 'STALE'

\| 'PARTIAL' \| 'UNAVAILABLE' \| 'UNKNOWN_EFFECT';

export interface MoneyDto {

amount: string; // decimal string, never JS binary float contract

currencyCode: string;

}

export interface QuoteLineDto {

quoteLineId: string;

lineCode: string;

lineType: 'BASE'\|'OPTIONAL'\|'FEE'\|'MATERIAL'\|'OTHER';

description: string;

quantity: string;

unitAmount: string;

grossAmount: string;

discountAmount: string;

surchargeAmount: string;

taxAmount: string;

netAmount: string;

sequenceNo: number;

}

export interface QuoteAdjustmentDto {

quoteAdjustmentId: string;

type: 'DISCOUNT'\|'SURCHARGE'\|'PRICE_OVERRIDE'\|'WAIVER';

sourceType: 'PROMOTION'\|'SCHOLARSHIP'\|'AGREEMENT'\|'OVERRIDE'\|'POLICY';

sourceRef: string;

reasonCode: string;

amount: MoneyDto;

percentValue?: string;

applicationOrder: number;

}

export interface CommercialQuoteDto {

quoteId: string;

quoteNumber: string;

offeringRef: string;

customerKind: 'PERSON'\|'CORPORATE'\|'THIRD_PARTY'\|'AGREEMENT';

customerRef: string;

state: 'DRAFT'\|'CALCULATED'\|'ISSUED'\|'ACCEPTED'\|'EXPIRED'\|'VOID'\|'SUPERSEDED';

subtotal: MoneyDto;

discount: MoneyDto;

surcharge: MoneyDto;

tax: MoneyDto;

totalDue: MoneyDto;

issuedAt?: string;

expiresAt?: string;

contentHash?: string;

version: number;

lines: QuoteLineDto\[\];

adjustments: QuoteAdjustmentDto\[\];

pricingTrace: PricingTraceDto;

}

export interface ProblemDetailsDto {

type?: string; title: string; status: number; detail?: string;

reasonCode: string; correlationId: string;

fieldErrors?: Array\<{field:string; code:string; message:string}\>;

}

export interface OperationStatusDto {

operationId: string;

operationType: string;

state: 'PENDING'\|'RUNNING'\|'SUCCEEDED'\|'FAILED'\|'UNKNOWN_EFFECT'\|'CANCELLED';

progressCurrent?: number;

progressTotal?: number;

result?: unknown;

error?: ProblemDetailsDto;

updatedAt: string;

}

## 39.1 Headers contractuales

| **Header**           | **Request/Response**       | **Regla**                                              |
|----------------------|----------------------------|--------------------------------------------------------|
| **Authorization**    | Request                    | Bearer/session según IAM baseline.                     |
| **Idempotency-Key**  | Request mutation sensible  | UUID/opaque estable por intento lógico.                |
| **If-Match**         | Request aggregate mutation | ETag recibido previamente; obligatorio según endpoint. |
| **ETag**             | Response aggregate         | Representa aggregate revision completa.                |
| **X-Correlation-Id** | Ambos                      | Generado/propagado end-to-end.                         |
| **Location**         | Response 201/202           | URL recurso/operation status.                          |
| **Retry-After**      | Response 429/503 opcional  | Solo cuando existe recomendación real.                 |

# 40. Checklist de release y certificación final

| **\#** | **Control**                                                         | **Estado/Evidencia**            |
|--------|---------------------------------------------------------------------|---------------------------------|
| **1**  | EC-00 V1.1 y EC-01 V1.1 baseline referenciados sin contradicción.   | □ PASS □ N/A justificado □ FAIL |
| **2**  | Scope/anti-scope de EC-03 firmado por Arquitectura/Product.         | □ PASS □ N/A justificado □ FAIL |
| **3**  | 31 tablas y constraints revisados; DDL ejecutable desde cero.       | □ PASS □ N/A justificado □ FAIL |
| **4**  | RLS ENABLE+FORCE en todas las tablas tenant-owned.                  | □ PASS □ N/A justificado □ FAIL |
| **5**  | Runtime DB role sin ownership/BYPASSRLS verificado.                 | □ PASS □ N/A justificado □ FAIL |
| **6**  | Aggregate Revision Contract probado en child mutations.             | □ PASS □ N/A justificado □ FAIL |
| **7**  | Published/Scheduled/Issued snapshots físicamente protegidos.        | □ PASS □ N/A justificado □ FAIL |
| **8**  | Promo code hash-only y concurrency tests aprobados.                 | □ PASS □ N/A justificado □ FAIL |
| **9**  | Money usa BigDecimal/numeric; golden rounding suite verde.          | □ PASS □ N/A justificado □ FAIL |
| **10** | OpenAPI completo y generated TypeScript client actualizado.         | □ PASS □ N/A justificado □ FAIL |
| **11** | AsyncAPI/event schemas versionados y compatibility gate verde.      | □ PASS □ N/A justificado □ FAIL |
| **12** | Idempotency lease/recovery probado.                                 | □ PASS □ N/A justificado □ FAIL |
| **13** | Outbox/inbox claim/dedup/recovery probado.                          | □ PASS □ N/A justificado □ FAIL |
| **14** | UNKNOWN_EFFECT Finance drill y reconciliation probado.              | □ PASS □ N/A justificado □ FAIL |
| **15** | RBAC/ABAC/SoD/step-up tests verdes.                                 | □ PASS □ N/A justificado □ FAIL |
| **16** | Threat Model mitigations verificadas.                               | □ PASS □ N/A justificado □ FAIL |
| **17** | SAST/SCA/secret/container scans dentro de policy.                   | □ PASS □ N/A justificado □ FAIL |
| **18** | SBOM generado y archivado.                                          | □ PASS □ N/A justificado □ FAIL |
| **19** | Frontend explicit states y 412 rebase UX verificados.               | □ PASS □ N/A justificado □ FAIL |
| **20** | Accessibility WCAG 2.2 AA baseline report aprobado.                 | □ PASS □ N/A justificado □ FAIL |
| **21** | Mobile journeys permitidos y operaciones prohibidas comprobadas.    | □ PASS □ N/A justificado □ FAIL |
| **22** | Observability dashboards/alerts/SLOs instalados.                    | □ PASS □ N/A justificado □ FAIL |
| **23** | Performance/capacity budgets cumplidos.                             | □ PASS □ N/A justificado □ FAIL |
| **24** | CT-16 migration dry-run/promotion rehearsal aprobado si aplica.     | □ PASS □ N/A justificado □ FAIL |
| **25** | 80 Golden Scenarios con evidencia/estado.                           | □ PASS □ N/A justificado □ FAIL |
| **26** | 30 UAT institucional completados y firmados.                        | □ PASS □ N/A justificado □ FAIL |
| **27** | Runbooks publicados y ensayados.                                    | □ PASS □ N/A justificado □ FAIL |
| **28** | Expand/contract N/N-1 probado en staging.                           | □ PASS □ N/A justificado □ FAIL |
| **29** | Evidence Pack G1-G10 completo.                                      | □ PASS □ N/A justificado □ FAIL |
| **30** | Release board aprueba G10; versión/tag y Word/Git quedan alineados. | □ PASS □ N/A justificado □ FAIL |

# 41. Contrato FullStack no negociable de implementación

Esta sección es parte de la plantilla oficial heredada de EC-01 V1.1. No es una recomendación: define el piso que EC-03 y los módulos EC posteriores deben preservar, adaptando el dominio pero no debilitando las garantías.

| **ID**    | **Contrato**         | **Regla**                                                                            |
|-----------|----------------------|--------------------------------------------------------------------------------------|
| **FS-01** | Source of Truth      | Cada dato tiene owner explícito; no tablas espejo por conveniencia.                  |
| **FS-02** | Tenant               | tenant_id proviene de auth; RLS ENABLE+FORCE y runtime NO BYPASSRLS.                 |
| **FS-03** | Cross-context        | Sin FK físicas hacia CT/otros EC/Finance; usar ports/contracts/receipts.             |
| **FS-04** | Aggregate revision   | Child mutation bump root; ETag/If-Match; 412, nunca last-write-wins.                 |
| **FS-05** | History              | Published/Issued/official facts no se reescriben; version/supersede/void/compensate. |
| **FS-06** | Money                | numeric/BigDecimal, rounding policy versionada, no float/double.                     |
| **FS-07** | Policy               | Thresholds, porcentajes, vigencias y límites no se hardcodean.                       |
| **FS-08** | Idempotency          | Comandos sensibles usan registro durable con lease/recovery.                         |
| **FS-09** | Events               | DB transaction + outbox; consumers inbox dedup; at-least-once.                       |
| **FS-10** | Remote writes        | UNKNOWN_EFFECT modelado; reconcile-before-retry.                                     |
| **FS-11** | HTTP                 | ProblemDetail + reason codes; 400/401/403/404/409/412/422/429/503 con semántica.     |
| **FS-12** | Async                | 202 siempre devuelve OperationStatus; no equivale a success.                         |
| **FS-13** | Frontend contract    | Cliente generado OpenAPI; DTOs no duplicados manualmente.                            |
| **FS-14** | UI state             | NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT distintos.                     |
| **FS-15** | Security             | RBAC+ABAC+SoD+step-up+purpose limitation; frontend no es authority.                  |
| **FS-16** | Audit                | Actor/scope/reason/correlation/policy/evidence en operaciones críticas.              |
| **FS-17** | Docs/files           | CT-05 guarda blobs; EC-03 solo refs/hash/metadata necesaria.                         |
| **FS-18** | IA                   | Solo CT-12; recommendation ≠ decision; provenance obligatoria.                       |
| **FS-19** | Migration            | CT-16; no INSERT directo a truth final.                                              |
| **FS-20** | Observability        | Logs/metrics/traces + SLI/SLO; business rejection ≠ operational failure.             |
| **FS-21** | QA                   | Unit→UAT + tenant/concurrency/idempotency/resilience/security/performance.           |
| **FS-22** | Secure SDLC          | SAST/SCA/secrets/SBOM/container/DAST gates.                                          |
| **FS-23** | Deployment           | Expand/contract y N/N-1; rollback destructivo de schema no es estrategia.            |
| **FS-24** | Developer Experience | Bootstrap reproducible con Testcontainers/fixtures y comandos documentados.          |
| **FS-25** | Evidence             | No Gate ni release sin evidence pack verificable.                                    |

| **CERTIFICACIÓN EC-03 —** EC-03 solo se considera listo para producción cuando responde inequívocamente qué construye, quién posee cada verdad, qué impide PostgreSQL, qué contratos implementa, qué ve Web/Mobile, qué ocurre ante conflicto/timeout/outage, cómo se reconcilia, audita, migra, prueba y opera; y cuando G1-G10 poseen evidencia. |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|

FIN DEL DOCUMENTO — PeopleU IA · EC-03 · Comercialización académica, pricing, promociones, becas, convenios y condiciones de oferta · Guía de Ingeniería Implementable V1.0.
