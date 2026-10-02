**PEOPLEU IA**

**EC-00**

**DOCUMENTO MAESTRO DE EDUCACIÓN CONTINUA /  
FORMACIÓN CONTINUA**

Constitución funcional y arquitectónica · Backend · Frontend · Móvil · Datos · QA · Seguridad · IA · Operaciones

| **Control**          | **Valor**                                                                                                      |
|----------------------|----------------------------------------------------------------------------------------------------------------|
| Código               | EC-00                                                                                                          |
| Versión              | V1.1 — Revisión quirúrgica enterprise                                                                          |
| Estado               | VIGENTE — DOCUMENTO MAESTRO OFICIAL · BASELINE FORTALECIDO                                                     |
| Documento sustituido | N/A — primera versión maestra oficial de la vertical                                                           |
| Vertical             | Educación Continua / Formación Continua                                                                        |
| Arquitectura         | Monolito modular multimodelo · Hexagonal · DDD · Spring Modulith                                               |
| Stack objetivo       | Java 21 · Spring Boot · PostgreSQL · MongoDB derivado · Redis · React/TypeScript · Next.js/Vite · React Native |
| Contexto             | Universidades privadas de Bolivia · Multiuniversidad · Multisede · Multicampus · Multimodalidad · Multiidioma  |
| Fecha base           | Septiembre 2026                                                                                                |

> **GOBIERNO DE ARTEFACTOS**
>
> Word = Especificación Maestra Oficial. Git = código y artefactos ejecutables. Issue Tracker = ejecución. Chat/Work = análisis y diseño; no son Source of Truth oficial. Toda evolución que cambie contratos, estados, datos o fronteras debe reflejarse en este Word o en un ADR aprobado y posteriormente reconciliado con el maestro.

> **REGLA DE FRONTERA**
>
> EC-00 no es un módulo desplegable ni un bounded context con persistencia propia. Es la constitución de la vertical EC. Define lenguaje, límites, ownership, secuencia EC-01…EC-12, contratos, invariantes y criterios de certificación. Por tanto, no existen tablas ec00_* ni endpoints /ec00: las implementaciones viven en los módulos EC y consumen CT/Core mediante puertos y adaptadores.

# 0. Declaración de propósito, autoridad y baseline

Este documento formaliza la arquitectura funcional de Educación Continua / Formación Continua dentro de PeopleU IA. Su propósito es evitar que la vertical se convierta en una adaptación superficial de Pregrado o Postgrado, y establecer un modelo propio para cursos cortos, talleres, seminarios, webinars, bootcamps, programas ejecutivos, formación empresarial, certificaciones, microcredenciales, programas modulares y otras experiencias de aprendizaje permanente.

EC-00 adopta como autoridad superior AM-00, CT-00 y los módulos CT-01 a CT-18 vigentes. Las capacidades transversales no se duplican dentro de EC. La vertical posee exclusivamente hechos académicos, operativos y comerciales específicos de Educación Continua, manteniendo contratos explícitos con CORE-PLATFORM, IAM, Core RRHH, Core Financiero, AI-SERVICE y los bounded contexts transversales.

La calidad de esta constitución se medirá por su capacidad de evitar ambigüedad de ownership. Para cualquier dato, regla, estado, evento, pantalla o integración, un equipo Senior debe poder determinar quién es Source of Truth, qué módulo puede modificar el hecho, qué referencias se conservan, cómo se protege la historia y qué evidencia permite reconstruir una decisión años después.

> **BASELINE FORMAL**
>
> La estructura documental, la densidad explicativa, el uso de tablas, decisiones arquitectónicas, Source of Truth, estados, resiliencia, seguridad, QA, Golden Scenarios, Gates y Engineering Pack siguen el patrón consolidado en los documentos PeopleU IA de módulos transversales y Postgrado. Este EC-00 establece el baseline específico que deberán respetar EC-01 a EC-12.

## 0.1 Jerarquía documental aplicable

| **Prioridad** | **Documento/artefacto**                | **Rol**                                                                    |
|---------------|----------------------------------------|----------------------------------------------------------------------------|
| 1             | AM-00 vigente                          | Constitución arquitectónica superior de PeopleU IA.                        |
| 2             | CT-00 vigente                          | Contrato maestro de capacidades transversales.                             |
| 3             | CT-01…CT-18 vigentes                   | Implementaciones y contratos de capacidades compartidas.                   |
| 4             | EC-00 V1.1 (este documento)            | Constitución funcional de Educación Continua.                              |
| 5             | Contratos PG/PO compartidos            | Solo cuando una semántica es realmente transversal y no invade verticales. |
| 6             | EC-01…EC-12                            | Especificaciones implementables de cada bounded context EC.                |
| Ejecutable    | Git/Flyway/OpenAPI/AsyncAPI/tests/ADRs | Código y evidencia versionada, alineados al Word.                          |

## 0.2 Decisiones arquitectónicas maestras

| **ID**      | **Decisión normativa**                                                                                                                                                                                                                        |
|-------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| EC00-DA-001 | EDUCACIÓN CONTINUA ≠ PREGRADO ≠ POSTGRADO. La vertical EC tiene ciclo de vida, reglas y productos propios; reutiliza capacidades transversales pero no hereda automáticamente semántica de matrícula, periodo semestral, egreso o grado.      |
| EC00-DA-002 | PERSON ≠ PARTICIPANT ≠ IAM USER. CT-04 mantiene Person; EC crea roles/vínculos de participación; IAM gobierna autenticación y credenciales.                                                                                                   |
| EC00-DA-003 | PROGRAM DEFINITION ≠ PROGRAM VERSION ≠ PROGRAM EDITION ≠ OFFERING. La definición se versiona; la edición ejecuta una versión; el offering representa disponibilidad comercial/operativa publicada.                                            |
| EC00-DA-004 | PROGRAM ≠ MODULE ≠ SESSION. Un programa puede tener módulos; un módulo puede contener sesiones; una sesión es ocurrencia temporal y no define por sí sola el currículo.                                                                       |
| EC00-DA-005 | REGISTRATION ≠ PAYMENT ≠ ENROLLMENT. La inscripción académica no se infiere de un pago y el pago no se duplica en EC.                                                                                                                         |
| EC00-DA-006 | ATTENDANCE ≠ PARTICIPATION ≠ COMPLETION ≠ PASS. Son hechos distintos con políticas separadas.                                                                                                                                                 |
| EC00-DA-007 | CERTIFICATE ELIGIBILITY ≠ CERTIFICATE ISSUANCE ≠ VERIFIABLE CREDENTIAL. Una política determina elegibilidad; el acto de emisión es trazable; el artefacto documental vive en CT-05.                                                           |
| EC00-DA-008 | CORPORATE CLIENT ≠ PARTICIPANT. La empresa contrata o patrocina; las personas participan y reciben hechos académicos individuales.                                                                                                            |
| EC00-DA-009 | COMMERCIAL AGREEMENT ≠ ACADEMIC PROGRAM. El acuerdo define condiciones comerciales/operativas; no reescribe el programa académico.                                                                                                            |
| EC00-DA-010 | PRICE ≠ FINANCIAL TRANSACTION. EC puede calcular contexto de precio; Finanzas conserva deuda, pago, factura, saldo y comprobante.                                                                                                             |
| EC00-DA-011 | PROMOTION ≠ DISCOUNT APPLICATION. Una campaña/regla comercial no es evidencia de que un descuento haya sido aplicado financieramente.                                                                                                         |
| EC00-DA-012 | AI RECOMMENDATION ≠ ACADEMIC DECISION. Toda IA usa CT-12 y permanece asistiva en decisiones sensibles.                                                                                                                                        |
| EC00-DA-013 | EC-00 NO ES BOUNDED CONTEXT DESPLEGABLE. No tendrá tablas, controladores ni repositorios propios; gobierna los EC implementables.                                                                                                             |
| EC00-DA-014 | NO FK FÍSICA CROSS-CONTEXT. Las referencias a CT, PG, PO, IAM, RRHH o Finanzas son EXT REF y se validan por contratos/ports.                                                                                                                  |
| EC00-DA-015 | HISTORIA \> CONVENIENCIA CRUD. Publicaciones, decisiones, completion y credenciales oficiales se corrigen mediante versionado, supersede, void o compensación, nunca por overwrite destructivo.                                               |
| EC00-DA-016 | EDITION FLEXIBLE ≠ PERIODO SEMESTRAL. Una edición EC puede comenzar cualquier día, operar fines de semana, ser intensiva y tener duración expresada en horas, días, semanas, sesiones o módulos.                                              |
| EC00-DA-017 | MICROCREDENTIAL ≠ DEGREE. Una microcredencial puede acumularse, pero no se convierte implícitamente en grado, crédito de PG/PO ni equivalencia.                                                                                               |
| EC00-DA-018 | LMS/VENDOR ≠ DOMAIN. Moodle, Canvas, Teams, Zoom, Meet u otros son adaptadores vía CT-18; la semántica EC no se acopla a un proveedor.                                                                                                        |
| EC00-DA-019 | UNKNOWN_EFFECT ES ESTADO DE PRIMERA CLASE. Si un efecto remoto puede haberse aplicado y la respuesta se pierde, reconciliar antes de reintentar.                                                                                              |
| EC00-DA-020 | MOBILE ≠ WEB REDUCIDA. La app expone journeys de alto valor y bajo riesgo; operaciones administrativas críticas permanecen en Web.                                                                                                            |
| EC00-DA-021 | CANCELLATION/RESCHEDULE/TRANSFER/SUBSTITUTION SON LIFECYCLES DE PRIMERA CLASE. No se resuelven con UPDATE destructivo ni notas libres.                                                                                                        |
| EC00-DA-022 | ACCESSIBILITY ≠ SOLO FRONTEND. Accommodations pueden afectar delivery y assessment, con minimización de datos y evidencia.                                                                                                                    |
| EC00-DA-023 | CREDENTIAL PORTABILITY \> VENDOR LOCK-IN. EC-08 debe poder mapear a Open Badges 3.0 / CLR 2.0 / W3C VC 2.0 cuando la institución habilite credenciales digitales.                                                                             |
| EC00-DA-024 | LEARNING TELEMETRY ≠ ACADEMIC FACT. LMS/xAPI/Caliper/cmi5 son evidencia/telemetría; EC aplica policy antes de producir attendance, pass o completion.                                                                                         |
| EC00-DA-025 | IDENTITY ASSURANCE ES PROPORCIONAL AL RIESGO. Webinar abierto y certificación profesional no exigen el mismo assurance.                                                                                                                       |
| EC00-DA-026 | CONTENT IN LMS ≠ RIGHT TO REUSE. Licencia, alcance, grabación y consentimiento deben ser explícitos.                                                                                                                                          |
| EC00-DA-027 | HISTORY ≠ RETAIN EVERYTHING FOREVER. Cada record class tiene retention policy; legal hold suspende purge selectivamente.                                                                                                                      |
| EC00-DA-028 | APPEAL ≠ DIRECT UPDATE. La apelación produce decisión; toda corrección oficial crea nuevo outcome/version/supersede.                                                                                                                          |
| EC00-DA-029 | CORPORATE TNA ≠ ACADEMIC CURRICULUM. Necesidad del sponsor informa diseño, pero EC-01 formaliza la ProgramVersion.                                                                                                                            |
| EC00-DA-030 | PORTFOLIO RETIREMENT ≠ DELETE. RETIRED bloquea nuevas ediciones y preserva historia, credentials y lineage.                                                                                                                                   |
| EC00-DA-031 | NORMATIVA BOLIVIANA ≠ CONSTANTE DE CÓDIGO. PeopleU IA debe resolver aplicabilidad mediante Compliance Profile versionado por tenant/program_type/modalidad/periodo, con referencias a instrumentos oficiales y decisión trazable de vigencia. |

# 1. Índice operativo del documento

- 2\. Resumen ejecutivo, propósito, alcance y fuera de alcance

- 3\. Lenguaje ubicuo y semántica normativa

- 4\. Diferencias estructurales con Pregrado y Postgrado

- 5\. Tipología de ofertas y modalidades de Educación Continua

- 6\. Participantes, actores y perfiles

- 7\. Tipos de certificación y credenciales

- 8\. Modelo normativo de programas, versiones, módulos, ediciones y ofertas

- 9\. Formación abierta, individual y corporativa/in-company

- 10\. Clientes corporativos, convenios y facturación referenciada

- 11\. Temporalidad, duración, horas y créditos opcionales

- 12\. Políticas de asistencia, evaluación, completion y certificación

- 13\. Bounded Context global y matriz Source of Truth

- 14\. Dependencias CT-01 a CT-18 y cores

- 15\. Arquitectura funcional de la vertical

- 16\. Secuencia oficial EC-01 a EC-12

- 17\. Orden técnico de implementación y dependencias

- 18\. Journeys E2E maestros

- 19\. Modelo de dominio global y ownership de aggregates

- 20\. Máquinas de estado maestras

- 21\. Contratos e integraciones transversales

- 22\. Integración financiera y pricing

- 23\. LMS, videoconferencia y ecosistema externo

- 24\. Docentes, expertos, instructores y speakers

- 25\. Seguridad, privacidad, RBAC/ABAC, SoD y step-up

- 26\. Estándares de datos, multitenancy y diseño físico para EC

- 27\. Eventos, outbox/inbox y envelope canónico

- 28\. Resiliencia, degradación, reconciliación y UNKNOWN_EFFECT

- 29\. Frontend Web: workspaces y estados normativos

- 30\. Mobile: principios, journeys y restricciones

- 31\. IA aplicada responsablemente

- 32\. Analítica, KPI y reporting

- 33\. Migración legacy y Data Quality con CT-16

- 34\. QA enterprise y estrategia de pruebas

- 35\. Catálogo BR-EC00 de reglas maestras

- 36\. Golden Scenarios maestros

- 37\. UAT institucional maestro

- 38\. Gates G1-G10

- 39\. Definition of Ready / Definition of Done

- 40\. Observabilidad, SLI/SLO y operación

- 41\. Engineering Pack maestro

- 42\. ADRs y decisiones abiertas

- 43\. Runbooks maestros

- 44\. Guía de desarrollo de EC-01…EC-12

- 45\. Checklist de certificación de la vertical

46\. Benchmark de excelencia y marco de cumplimiento adaptable

47\. Lifecycle de cancelación, reprogramación, transferencia, sustitución y devolución referenciada

48\. Accesibilidad, accommodations e inclusión

49\. Interoperabilidad educativa y credenciales digitales

50\. Identity assurance, anti-fraude, proctoring y trust

51\. Propiedad intelectual, licencias, grabaciones y consentimiento

52\. Retención, archivo, legal hold y ciclo de vida de datos

53\. Appeals, complaints, excepciones y service recovery

54\. Corporate TNA, sponsor governance y outcome reporting

55\. Portfolio lifecycle, experimentación controlada y retiro de oferta

56\. Fuentes internas, estándares externos y baseline de continuidad

# 2. Resumen ejecutivo, propósito, alcance y fuera de alcance

Educación Continua en PeopleU IA debe operar como una vertical académica de alta frecuencia, alta flexibilidad temporal y fuerte interacción comercial. A diferencia de una carrera o un programa de postgrado conducente a grado, una oferta EC puede existir por pocos días, repetirse varias veces al año, abrirse al público general, ejecutarse para una empresa específica, funcionar de forma híbrida o asíncrona y culminar con participación, completion, aprobación, microcredencial o certificación verificable según política.

El objetivo de EC-00 es establecer una constitución común para que todos los módulos implementables trabajen sobre el mismo lenguaje, ciclo de vida y ownership. La plataforma debe soportar tanto un webinar de dos horas con miles de participantes como un programa ejecutivo de varios meses compuesto por módulos acumulables, sin convertir uno u otro en una pseudo-carrera semestral.

La vertical debe ser comercialmente ágil sin degradar el rigor académico. Debe permitir precios, early bird, descuentos, becas, códigos promocionales y acuerdos corporativos, pero siempre manteniendo el Core Financiero como libro oficial del hecho económico. Del mismo modo, debe permitir certificación flexible, pero sin emitir un certificado únicamente porque un registro cambió a COMPLETED: las condiciones de elegibilidad deben estar parametrizadas, versionadas, auditadas y reconstruibles.

## 2.1 Incluido

- Catálogo y diseño de programas de Educación Continua: cursos, talleres, seminarios, webinars, bootcamps, certificaciones, programas ejecutivos, programas modulares, microcredenciales y otras formas parametrizables.

- Versionado de definiciones académicas y múltiples ediciones históricas sin sobrescritura.

- Ofertas públicas, privadas, cerradas, patrocinadas o corporativas; inscripción individual y por lote.

- Modalidad presencial, virtual síncrona, virtual asíncrona e híbrida.

- Duración flexible por horas, sesiones, días, semanas o módulos; créditos opcionales solo cuando la institución los utilice.

- Asistencia y participación con políticas versionadas; evaluación opcional u obligatoria.

- Completion, pass, certificate eligibility, issuance, microcredenciales y stacking.

- Gestión de instructores internos, expertos externos, facilitadores y speakers, sin duplicar RRHH.

- Integración con LMS, videoconferencia, pagos, notificaciones, documentos, analítica, IA y ecosistema externo mediante CT/Core.

- Programas corporativos/in-company, cupos contratados, nominación de participantes y reporting empresarial con privacidad.

- Encuestas, NPS, evaluación docente, impacto y seguimiento posterior.

- Migración legacy con lineage y promoción gobernada por CT-16.

## 2.2 Fuera de alcance

- Autenticación, credenciales, sesiones, MFA o roles base: IAM.

- Persona canónica y deduplicación de identidad: CT-04.

- Archivos, PDFs, certificados binarios, firmas o adjuntos: CT-05.

- Workflow genérico, bandejas, SLA y aprobaciones corporativas: CT-06.

- Notificaciones multicanal: CT-07.

- Motor transversal de traducción/localización: CT-08.

- Bus de integración, contract registry, retry/DLQ genéricos: CT-09.

- Auditoría y privacy framework transversal: CT-10.

- BI institucional y gobierno analítico: CT-11.

- Orquestación de IA y proveedores LLM: CT-12 / AI-SERVICE.

- Solver de horarios: CT-13; inventario/reservas de espacios: CT-14.

- Motor transversal de elegibilidad: CT-15.

- Migración y Data Quality corporativa: CT-16.

- Continuidad y contingencia transversal: CT-17.

- LMS, videoconferencia y vendors educativos como integración: CT-18.

- Libro financiero, deuda, pago, factura, saldo y contabilidad: Core Financiero.

- Relación laboral, contrato, remuneración o disponibilidad contractual del personal: Core RRHH.

- Grados académicos, titulación o equivalencias automáticas hacia Pregrado/Postgrado.

# 3. Lenguaje ubicuo y semántica normativa

| **Término**                | **Definición normativa**                                                                                              |
|----------------------------|-----------------------------------------------------------------------------------------------------------------------|
| ContinuingEducationProgram | Definición académica reusable de una experiencia de formación continua; no representa una ejecución concreta.         |
| ProgramDefinition          | Identidad conceptual estable del programa, independiente de sus versiones y ediciones.                                |
| ProgramVersion             | Snapshot académico versionado y publicable: objetivos, estructura, horas, outcomes, requisitos y reglas aplicables.   |
| LearningModule             | Unidad modular dentro de una ProgramVersion; puede ser acumulable o independiente según diseño.                       |
| ProgramEdition             | Instancia operativa de una ProgramVersion ejecutada en fechas, modalidad y contexto institucional concretos.          |
| Offering                   | Representación publicable/comercializable de una edición o cupo de acceso, con canal, ventanas y contexto de pricing. |
| Session                    | Ocurrencia temporal de aprendizaje; su calendario proviene/coordina con CT-03 y su scheduling con CT-13.              |
| Participant                | Rol EC de una Person vinculada a una edición; no es una persona canónica ni necesariamente usuario IAM.               |
| Registration               | Intención/solicitud de incorporarse a una oferta; puede preceder payment o enrollment.                                |
| Enrollment                 | Vínculo académico confirmado entre Participant y ProgramEdition según reglas de EC-04.                                |
| WaitlistEntry              | Posición controlada cuando no existe cupo disponible; no equivale a enrollment.                                       |
| CorporateTrainingAccount   | Relación de cliente empresarial dentro de EC-09; no convierte a la empresa en participante académico.                 |
| CommercialAgreement        | Acuerdo comercial/operativo referenciado que gobierna condiciones corporativas; no altera contenido académico.        |
| CorporateEnrollmentBatch   | Lote de nominaciones/inscripciones asociado a cliente, acuerdo y edición.                                             |
| AttendanceRecord           | Evidencia de presencia/ausencia/participación en una sesión o actividad.                                              |
| Participation              | Hecho agregado de involucramiento; puede incluir asistencia, actividad asíncrona o evidencia equivalente.             |
| Assessment                 | Actividad evaluativa opcional u obligatoria según política.                                                           |
| PassOutcome                | Resultado de aprobación académica cuando aplica; no es sinónimo de completion.                                        |
| Completion                 | Hecho oficial de cumplimiento de una experiencia conforme a reglas aplicables.                                        |
| CertificateEligibility     | Resultado de evaluación de condiciones para poder emitir una credencial/certificado.                                  |
| CredentialAward            | Acto académico de otorgamiento de certificado, badge o microcredencial; su documento binario vive en CT-05.           |
| VerifiableCredential       | Credencial con mecanismo de verificación/QR/token/hash cuando la institución lo habilita.                             |
| Microcredential            | Credencial de alcance acotado asociada a outcomes verificables; no es un grado.                                       |
| CredentialStack            | Conjunto de credenciales acumuladas por una persona bajo reglas de una ruta.                                          |
| LearningPathway            | Ruta versionada que define cómo módulos/credenciales pueden acumularse hacia un resultado mayor.                      |
| PricingContext             | Conjunto de hechos y reglas que permiten calcular un precio aplicable sin convertirse en ledger financiero.           |
| Promotion                  | Campaña o condición comercial reusable; no prueba aplicación efectiva de un descuento.                                |
| Scholarship                | Beneficio gobernado por política y aprobación; su efecto financiero se confirma desde el Core Financiero.             |
| EvidenceRef                | Referencia a evidencia/documento de CT-05; EC no guarda blobs.                                                        |
| PolicySnapshot             | Versiones y valores de políticas que fundamentaron una decisión histórica.                                            |
| Receipt                    | Evidencia durable de que un efecto remoto o cross-context fue aplicado.                                               |
| UnknownEffect              | Estado donde no puede saberse si un efecto remoto ocurrió; exige reconciliación.                                      |
| ReasonCode                 | Código estable, auditable y traducible que explica una decisión o rechazo.                                            |
| RunRef                     | Referencia a ejecución de IA en CT-12; incluye modelo, template, grounding, evals y resultado revisado.               |

# 4. Diferencias estructurales con Pregrado y Postgrado

| **Dimensión**    | **Educación Continua**                                                                                       | **Pregrado**                                             | **Postgrado**                                                                      |
|------------------|--------------------------------------------------------------------------------------------------------------|----------------------------------------------------------|------------------------------------------------------------------------------------|
| Propósito        | Formación permanente, actualización, especialización corta, reskilling/upskilling, capacitación empresarial. | Carrera conducente a grado.                              | Especialización avanzada, diplomado/maestría/doctorado según oferta institucional. |
| Calendario       | Flexible; puede comenzar cualquier día y repetirse frecuentemente.                                           | Generalmente periodos académicos estructurados.          | Cohortes/módulos intensivos, pero con mayor formalidad de programa.                |
| Duración         | Horas, días, semanas, sesiones, módulos; amplia variabilidad.                                                | Años/periodos.                                           | Meses/años según programa.                                                         |
| Participante     | Público general, profesionales, empresas, comunidad, internacionales.                                        | Estudiante de carrera.                                   | Participante/estudiante de postgrado con requisitos de admisión.                   |
| Ingreso          | Frecuentemente liviano; puede ser autoinscripción, invitación o nominación corporativa.                      | Admisión formal.                                         | Admisión formal con requisitos académicos/profesionales.                           |
| Resultado        | Participación, completion, pass, certificado, badge, microcredencial, stack.                                 | Créditos, historial, egreso y grado.                     | Créditos, historial, certificaciones intermedias, grado/título según programa.     |
| Comercialización | Alta: early bird, promos, códigos, B2B, paquetes, cohorts cerradas.                                          | Secundaria al proceso académico.                         | Moderada/alta, pero ligada a programas formales.                                   |
| Corporate        | Primera clase: empresa ≠ participante, lotes, reportes, acuerdos.                                            | No es núcleo.                                            | Puede existir, pero no domina el lifecycle.                                        |
| Stacking         | Frecuente en microcredenciales/programas modulares.                                                          | Regido por currículo formal.                             | Regido por plan/programa y reconocimiento.                                         |
| Certificado      | Puede ser de participación o aprobación; no implica grado.                                                   | Certificados/constancias complementan historial y grado. | Certificados/diplomas pueden tener efectos formales según programa.                |

> **REGLA DE MODELADO**
>
> No reutilizar nombres de estados solo porque “se parecen”. Si un estado en PG/PO implica efectos reglamentarios que no existen en EC, debe crearse semántica propia o un contrato explícito. Reusar infraestructura no significa reusar dominio.

# 5. Tipología de ofertas y modalidades de Educación Continua

EC debe ser parametrizable y no codificar tipos de oferta como tablas separadas ni condicionales rígidos. CT-02 gobierna catálogos y políticas; EC-01 define qué combinaciones son válidas para una ProgramVersion concreta. Los tipos siguientes constituyen el baseline semántico y pueden ampliarse por universidad mediante catálogos versionados.

| **Código baseline**     | **Tipo**                        | **Descripción**                                                                               |
|-------------------------|---------------------------------|-----------------------------------------------------------------------------------------------|
| SHORT_COURSE            | Curso corto                     | Actualización concentrada con objetivos y horas definidos.                                    |
| UPDATE_COURSE           | Curso de actualización          | Actualización profesional sobre un dominio o cambio tecnológico/normativo.                    |
| SPECIALIZED_COURSE      | Curso especializado             | Profundización temática con alcance acotado.                                                  |
| WORKSHOP                | Taller                          | Aprendizaje práctico, normalmente de corta duración y alta interacción.                       |
| SEMINAR                 | Seminario                       | Profundización/discusión temática con expertos.                                               |
| WEBINAR                 | Webinar                         | Evento virtual, normalmente breve, síncrono o grabado según política.                         |
| BOOTCAMP                | Bootcamp                        | Formación intensiva y práctica, potencialmente de jornadas extendidas.                        |
| EXECUTIVE_PROGRAM       | Programa ejecutivo              | Conjunto estructurado de módulos orientado a profesionales/directivos.                        |
| CORPORATE_TRAINING      | Capacitación corporativa        | Oferta cerrada/in-company bajo acuerdo con una organización.                                  |
| CERTIFICATION_PROGRAM   | Programa de certificación       | Preparación/evaluación orientada a una certificación institucional o externa.                 |
| MICROCREDENTIAL_PROGRAM | Microcredencial                 | Trayecto corto con outcomes verificables y credencial acumulable.                             |
| MODULAR_PROGRAM         | Programa modular                | Programa compuesto por módulos con reglas de acumulación.                                     |
| CONTINUING_DIPLOMA      | Diplomado de formación continua | Solo cuando la institución lo gestione en EC; no confundir con Postgrado formal.              |
| PUBLIC_EVENT            | Evento formativo abierto        | Actividad masiva de aprendizaje/divulgación con trazabilidad de participación cuando aplique. |

## 5.1 Modalidades

| **Código**    | **Modalidad**     | **Regla**                                                                     |
|---------------|-------------------|-------------------------------------------------------------------------------|
| PRESENTIAL    | Presencial        | Sesiones físicas; CT-14 gestiona espacios y CT-13 scheduling.                 |
| VIRTUAL_SYNC  | Virtual síncrona  | Sesiones en tiempo real; CT-18 integra videoconferencia.                      |
| VIRTUAL_ASYNC | Virtual asíncrona | Contenido/actividades en LMS; CT-18 integra plataforma educativa.             |
| HYBRID        | Híbrida           | Combina presencia y virtualidad; cada session/activity declara modo efectivo. |

# 6. Participantes, actores y perfiles

| **Actor/rol**           | **Definición y frontera**                                                                                                                                                                                                                               |
|-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Participant             | Persona que participa académicamente; referencia person_id CT-04.                                                                                                                                                                                       |
| ProspectInterest        | Contexto mínimo de interés previo a registration. EC-04 es Source of Truth del interés académico EC cuando no existe CRM; si existe CRM institucional, EC-04 conserva external_lead_ref, attribution snapshot y conversion receipt sin duplicar el CRM. |
| Individual Buyer        | Persona que asume condición comercial; puede coincidir o no con Participant.                                                                                                                                                                            |
| Sponsored Participant   | Participante cuyo costo es cubierto por empresa, convenio o tercero.                                                                                                                                                                                    |
| Corporate Coordinator   | Contacto autorizado de una empresa para nominar participantes y recibir reportes permitidos.                                                                                                                                                            |
| Program Director        | Responsable académico del programa/versión/edición según scope.                                                                                                                                                                                         |
| Instructor              | Responsable de impartir contenido y evidenciar actividades; vínculo laboral no vive en EC.                                                                                                                                                              |
| External Expert         | Especialista externo invitado o contratado; persona canónica en CT-04 y relación operativa EC-05.                                                                                                                                                       |
| Facilitator             | Apoya dinámica y operación de aprendizaje sin necesariamente evaluar.                                                                                                                                                                                   |
| Speaker                 | Intervención puntual, no necesariamente owner de módulo.                                                                                                                                                                                                |
| Registrar/EC Operations | Operador de inscripciones, cupos, casos y conciliaciones.                                                                                                                                                                                               |
| Commercial Officer      | Opera oferta comercial y acuerdos sin poder modificar resultados académicos.                                                                                                                                                                            |
| Certificate Officer     | Gestiona emisión bajo elegibilidad; separación de funciones cuando política lo exige.                                                                                                                                                                   |
| Corporate Viewer        | Usuario empresarial con acceso únicamente a reporting acordado y permitido.                                                                                                                                                                             |
| Auditor                 | Actor de lectura con acceso reforzado a evidencia y reconstrucción histórica.                                                                                                                                                                           |

# 7. Tipos de certificación y credenciales

| **Código**                | **Tipo**                     | **Regla**                                                                                 |
|---------------------------|------------------------------|-------------------------------------------------------------------------------------------|
| PARTICIPATION_CERTIFICATE | Certificado de participación | Acredita participación según política; no implica aprobación.                             |
| COMPLETION_CERTIFICATE    | Certificado de completion    | Acredita cumplimiento del programa cuando no existe pass académico separado.              |
| PASS_CERTIFICATE          | Certificado de aprobación    | Requiere outcome PASS y demás condiciones de elegibilidad.                                |
| MICROCREDENTIAL           | Microcredencial              | Credencial de alcance acotado con outcomes y evidence; puede ser stackable.               |
| DIGITAL_BADGE             | Badge                        | Representación digital de un achievement; puede vincularse a verificación.                |
| INTERMEDIATE_CREDENTIAL   | Credencial intermedia        | Se obtiene por completar parte gobernada de una ruta.                                     |
| CUMULATIVE_CREDENTIAL     | Credencial acumulativa       | Se adjudica cuando un conjunto de módulos/credenciales satisface una ruta.                |
| CORPORATE_ATTESTATION     | Constancia corporativa       | Documento/reporting para el cliente; no sustituye credencial individual del participante. |

> **INVARIANTE DE CERTIFICACIÓN**
>
> status = COMPLETED nunca es suficiente para emitir una credencial. EC-08 debe ejecutar una política de elegibilidad que evalúe asistencia, evaluación, identidad, documentos, condiciones financieras referenciadas y cualquier requisito institucional aplicable bajo una versión/snapshot concreto.

# 8. Modelo normativo de programas, versiones, módulos, ediciones y ofertas

<img src="media/image1.png" title="Diagrama EC-00 1" style="width:6.85in;height:0.24962in" alt="Lifecycle extremo a extremo de Educación Continua: diseñar, ofertar, comercializar, inscribir, ejecutar, evidenciar, evaluar, completar, certificar, acumular, medir y mejorar." />

*Figura 1 — Ciclo de vida maestro de Educación Continua*

## 8.1 ProgramDefinition

Representa la identidad académica estable del producto formativo: código institucional, familia/tipo, propósito y ownership académico. No contiene fechas de ejecución ni cupos de una edición. Su identificador permanece aunque existan múltiples ProgramVersion a lo largo de los años.

## 8.2 ProgramVersion

Congela el contenido normativo que puede publicarse o ejecutarse: nombre oficial, objetivos, outcomes, estructura modular, carga horaria, modalidad admitida, requisitos, políticas de asistencia/evaluación/certificación y metadatos de credencial. Una versión PUBLISHED es inmutable; cualquier cambio material genera una nueva versión o una corrección formal compatible con política.

## 8.3 LearningModule

Unidad académica reusable o estructural dentro de una ProgramVersion. Puede tener horas, outcomes y criterios propios. No debe confundirse con una sesión: el módulo es diseño; las sesiones pertenecen a la ejecución.

## 8.4 ProgramEdition

Instancia operativa de una ProgramVersion con fechas, modalidad efectiva, sede/campus, cupo, equipo docente y contexto de ejecución. Una edición debe preservar snapshot de la versión académica que ejecuta; no puede cambiar a otra ProgramVersion después de iniciar salvo procedimiento de reemplazo excepcional, impacto y consentimiento cuando corresponda.

## 8.5 Offering

Representación publicable y susceptible de inscripción/comercialización: canal, audiencia, ventana, cupos visibles, pricing context, requisitos visibles y condiciones. Puede existir una edición privada sin listing público o múltiples offerings sobre una misma edición cuando hay canales/segmentos distintos, siempre con reglas anti-overselling.

## 8.6 Invariantes

- Una ProgramVersion PUBLISHED nunca se sobrescribe destructivamente.

- Una ProgramEdition referencia una sola ProgramVersion efectiva por versión de edición.

- Una Offering no define contenido académico; solo referencia la versión/edición y su contexto comercial/operativo.

- Los módulos y sesiones mantienen orden/estructura según reglas versionadas; no se resuelven por nombres libres.

- Los cambios posteriores al inicio se registran como amendment/version/supersede con impacto y evidencia.

- Los hechos oficiales de completion y credential guardan snapshot de políticas y versiones relevantes.

# 9. Formación abierta, individual y corporativa/in-company

| **Tipo de acceso** | **Descripción**               | **Implicación**                                                              |
|--------------------|-------------------------------|------------------------------------------------------------------------------|
| OPEN_PUBLIC        | Oferta abierta al público     | Autoregistro o inscripción asistida; pricing individual; cupo público.       |
| PRIVATE_INVITED    | Oferta privada por invitación | Solo personas invitadas/código; no necesariamente empresa.                   |
| CORPORATE_CLOSED   | Cohorte corporativa cerrada   | Empresa/organización contrata y nomina participantes.                        |
| SPONSORED_OPEN     | Oferta abierta con patrocinio | Participantes individuales con tercero pagador o convenio.                   |
| PARTNER_COHORT     | Cohorte por convenio          | Acceso gobernado por acuerdo con aliado; reglas de elegibilidad específicas. |

La forma de acceso no cambia el contenido académico por sí sola. Si un cliente corporativo requiere una adaptación material del programa, EC-01 debe crear una nueva ProgramVersion o una variante formalmente gobernada. No se permite que condiciones comerciales modifiquen silenciosamente outcomes, horas, evaluación o credencial.

# 10. Clientes corporativos, convenios y facturación referenciada

EC-09 modelará la relación de capacitación con organizaciones sin transformar la empresa en participante académico. Un CorporateTrainingAccount representa el contexto B2B de Educación Continua y puede referenciar una identidad empresarial externa cuando exista un master corporativo. El contrato firmado y sus anexos se almacenan en CT-05; el acuerdo académico/comercial EC conserva referencias y snapshots mínimos para reconstruir alcance, cupos, fechas, reportes y políticas aplicables.

La facturación puede dirigirse al participante, a la empresa, a un convenio o a un tercero. EC debe producir una intención/componente comercial suficientemente explícito para que Finanzas cree la obligación correspondiente. El estado financiero oficial siempre se consulta por contrato; EC no crea tablas de pagos, saldos o facturas.

| **Información**          | **Source of Truth** | **EC almacena**                  | **EC referencia**                | **Regla**                              |
|--------------------------|---------------------|----------------------------------|----------------------------------|----------------------------------------|
| CorporateTrainingAccount | EC-09               | Sí, relación EC con organización | external_org_ref / evidence refs | No es Person ni ledger.                |
| CommercialAgreement      | EC-09               | Sí, términos EC/version          | CT-05 document_ref; Finance refs | No reescribe programa.                 |
| CorporateEnrollmentBatch | EC-09               | Sí, lote y nominaciones          | EC-04 participant refs           | Cada persona tiene vínculo individual. |
| Invoice                  | Core Financiero     | No                               | invoice_ref                      | UNAVAILABLE ≠ NOT_INVOICED.            |
| Payment                  | Core Financiero     | No                               | payment/status ref               | EC nunca registra pago manual.         |
| Corporate Report         | EC-09/CT-11         | Hechos EC + proyección           | dataset/report refs              | Privacy y minimización obligatorias.   |

# 11. Temporalidad, duración, horas y créditos opcionales

Educación Continua no debe depender de una estructura semestral. CT-03 mantiene el motor temporal transversal; EC-01/EC-02 expresan la semántica de duración y edición, y delegan ventanas/sesiones/calendarización al contrato temporal. Toda persistencia oficial de instantes usa timestamptz en UTC y la presentación utiliza la timezone institucional/usuario.

| **Unidad**     | **Uso**             | **Regla**                                                                                      |
|----------------|---------------------|------------------------------------------------------------------------------------------------|
| ACADEMIC_HOURS | Horas académicas    | Cantidad normativa de horas académicas, unidad/longitud definida por política institucional.   |
| CLOCK_HOURS    | Horas reloj         | Duración cronológica real cuando la universidad la usa como medida.                            |
| DAYS           | Días                | Duración expresada en jornadas; debe complementarse con sesiones si se requiere evidencia.     |
| WEEKS          | Semanas             | Descripción de planificación; no reemplaza fechas efectivas.                                   |
| SESSIONS       | Sesiones            | Número de ocurrencias; CT-03 conserva la semántica temporal efectiva.                          |
| MODULES        | Módulos             | Duración/estructura por unidades de aprendizaje.                                               |
| CREDITS        | Créditos opcionales | Solo si la universidad define equivalencia; nunca inferir un estándar externo automáticamente. |

> **CALENDARIO FLEXIBLE**
>
> Una edición puede operar noches, fines de semana, feriados institucionalmente habilitados o periodos intensivos. Los constraints de disponibilidad y recursos se resuelven mediante CT-13/CT-14, no por supuestos de “horario universitario tradicional”.

# 12. Políticas de asistencia, evaluación, completion y certificación

Todas las reglas variables se resuelven mediante CT-02 y deben conservar versión o snapshot cuando el resultado futuro dependa de ellas. Los módulos EC no deben hardcodear porcentajes, notas mínimas, ventanas ni excepciones. Las políticas pueden variar por tenant, programa, ProgramVersion, edition, tipo de credencial, segmento corporativo o modalidad, dentro de una jerarquía explícita de precedencia.

| **Política**                  | **Owner/engine** | **Contenido**                                                                              |
|-------------------------------|------------------|--------------------------------------------------------------------------------------------|
| Attendance Policy             | EC-06 + CT-02    | Cómo se calcula asistencia/participación, tolerancias, justificaciones y mínimo requerido. |
| Assessment Policy             | EC-07 + CT-02    | Si existe evaluación, escala, intentos, weighting, thresholds y excepciones.               |
| Completion Policy             | EC-07 + CT-02    | Cómo se determina completion independientemente de pass.                                   |
| Credential Eligibility Policy | EC-08 + CT-02    | Condiciones previas de identidad, attendance, pass, documentos, financial status y otras.  |
| Stacking Policy               | EC-10 + CT-02    | Qué módulos/credenciales acumulan, vigencias y equivalencias internas EC.                  |
| Corporate Reporting Policy    | EC-09 + CT-10/11 | Qué datos puede recibir el cliente y con qué base/consentimiento/propósito.                |

## 12.1 Separaciones normativas

- PRESENT en una sesión no implica PARTICIPATED en todo el programa.

- PARTICIPATED no implica COMPLETED.

- COMPLETED no implica PASS si existe evaluación separada.

- PASS no implica CERTIFICATE_ELIGIBLE si faltan identidad/evidencia/condición financiera u otro requisito.

- CERTIFICATE_ELIGIBLE no implica ISSUED: la emisión es un acto separado, idempotente y auditable.

- ISSUED no implica que el archivo sea Source of Truth EC: el artefacto permanece en CT-05.

# 13. Bounded Context global y matriz Source of Truth

| **Información**                          | **Source of Truth** | **EC almacena**      | **EC referencia**           | **Regla**                                     |
|------------------------------------------|---------------------|----------------------|-----------------------------|-----------------------------------------------|
| Tenant / universidad / sede / campus     | CT-01               | No                   | scope/site/campus refs      | Contexto autorizado; tenant del auth context. |
| Catálogos / políticas                    | CT-02               | No                   | policy/version refs         | Snapshots para reconstrucción.                |
| Tiempo / sesiones / ventanas             | CT-03               | No                   | calendar/session refs       | EC define intención; CT-03 tiempo canónico.   |
| Persona canónica                         | CT-04               | No                   | person_id                   | Sin FK cross-context.                         |
| Documentos / certificados PDF            | CT-05               | No                   | document_ref/hash           | No blobs PostgreSQL.                          |
| Workflow / aprobaciones                  | CT-06               | No                   | case/task refs              | EC decide dominio; CT-06 orquesta.            |
| Notificaciones                           | CT-07               | No                   | request/receipt refs        | Fallo mensaje no revierte hecho.              |
| i18n / nomenclatura                      | CT-08               | No                   | translation keys            | Reason codes estables.                        |
| Integración / contratos                  | CT-09               | No                   | message/contract refs       | Outbox/inbox y governance.                    |
| Auditoría / privacy                      | CT-10               | Refs locales mínimas | audit/evidence refs         | PII minimization.                             |
| Analítica / BI                           | CT-11               | Produce hechos       | dataset/kpi refs            | Sin shadow BI.                                |
| IA / RAG / agentes                       | CT-12               | No                   | run/eval refs               | Recommendation ≠ Decision.                    |
| Scheduling                               | CT-13               | No                   | schedule refs               | No solver local.                              |
| Recursos / reservas                      | CT-14               | No                   | resource/reservation refs   | No room tables EC.                            |
| Elegibilidad transversal                 | CT-15               | No                   | decision/explanation refs   | Reglas EC específicas permanecen en EC.       |
| Migración / DQ                           | CT-16               | No                   | migration/receipt refs      | Promoción por dominio/API.                    |
| Continuidad                              | CT-17               | No                   | incident/continuity refs    | EC declara impacto.                           |
| LMS / Zoom / Teams / etc.                | CT-18               | No                   | capability/external refs    | Sin vendor lock-in.                           |
| Autenticación / MFA / roles base         | IAM                 | No                   | subject/claims              | Scope adicional vía CT-01.                    |
| Relación laboral                         | Core RRHH           | No                   | employee/person refs        | EC-05 no duplica contrato.                    |
| Deuda / pago / factura / saldo           | Core Financiero     | No                   | financial refs              | UNAVAILABLE ≠ ZERO.                           |
| ProgramDefinition / ProgramVersion       | EC-01               | Sí                   | CT refs                     | Diseño académico EC.                          |
| ProgramEdition / Offering                | EC-02               | Sí                   | EC-01 + CT refs             | Ejecución/oferta.                             |
| PricingContext / Promotion binding       | EC-03               | Sí, semántica EC     | Finance/policy refs         | No ledger.                                    |
| Registration / Enrollment / Waitlist     | EC-04               | Sí                   | Person/Edition/Finance refs | Idempotencia y cupos.                         |
| InstructorAssignment / learning delivery | EC-05               | Sí                   | Person/RRHH/LMS refs        | No relación laboral.                          |
| Attendance / Participation               | EC-06               | Sí                   | Session/participant refs    | Evidencia de participación.                   |
| Assessment / Completion / Pass           | EC-07               | Sí                   | Policy/evidence refs        | Hechos académicos.                            |
| CredentialAward / eligibility            | EC-08               | Sí                   | CT-05 document refs         | Artefacto no vive EC.                         |
| Corporate training relationship          | EC-09               | Sí                   | Org/evidence/finance refs   | Empresa ≠ participante.                       |
| LearningPathway / CredentialStack        | EC-10               | Sí                   | EC-08 refs                  | No grado automático.                          |
| Feedback / NPS / impact facts            | EC-11               | Sí                   | CT-11 refs                  | Privacidad/consentimiento.                    |
| Portfolio quality decisions              | EC-12               | Sí, hechos EC        | CT-11 dataset refs          | No reemplaza BI.                              |

# 14. Dependencias CT-01 a CT-18 y cores

| **Dependencia** | **Responsabilidad**         | **Uso EC**                                             | **Degradación/regla**                                          |
|-----------------|-----------------------------|--------------------------------------------------------|----------------------------------------------------------------|
| CT-01           | Organización/scope          | Tenant, sede/campus/unidad y autorización contextual.  | Fail-closed para comandos sensibles.                           |
| CT-02           | Catálogos/políticas         | Tipos, thresholds, ventanas, reglas versionadas.       | No inventar defaults favorables si política no disponible.     |
| CT-03           | Temporal                    | Calendarios, ventanas, sesiones, time semantics.       | Lectura puede STALE; operaciones críticas requieren confianza. |
| CT-04           | Persona                     | Person canónica, deduplicación, identidad.             | Formalización que requiere identidad: fail-closed.             |
| CT-05           | Documentos                  | Evidencias, contratos, certificados, PDFs, hash.       | No blobs ni duplicación.                                       |
| CT-06           | Workflow                    | Aprobaciones, SLA, bandejas, excepción.                | EC mantiene semántica de decisión.                             |
| CT-07           | Notificaciones              | Email/SMS/WhatsApp/push y receipts.                    | Fallo de comunicación no revierte commit.                      |
| CT-08           | i18n                        | Labels, reason codes, locales.                         | Fallback gobernado.                                            |
| CT-09           | Integración                 | Outbox/inbox, contratos, retries, DLQ, reconciliation. | No punto a punto ad-hoc.                                       |
| CT-10           | Seguridad/auditoría/privacy | Audit envelope, privacy, field policy, assurance.      | Sin PII indebida en logs/cache.                                |
| CT-11           | Analítica/BI                | Datasets, KPIs, dashboards.                            | No SQL analítico privado como SoT.                             |
| CT-12           | IA                          | Runs, providers, RAG, evals, guardrails.               | Degradar sin IA cuando sea posible.                            |
| CT-13           | Scheduling                  | Horarios y solver.                                     | No crear motor local de horarios.                              |
| CT-14           | Recursos                    | Aulas, salas, equipos, reservas.                       | No room/resource tables en EC.                                 |
| CT-15           | Elegibilidad                | Reglas transversales de elegibilidad.                  | EC añade reglas específicas mediante contrato.                 |
| CT-16           | Migración/DQ                | Staging, mapping, dry-run, promotion, receipts.        | No INSERT directo final.                                       |
| CT-17           | Continuidad                 | Contingencia, RTO/RPO, modos degradados.               | EC expone prioridad/impacto.                                   |
| CT-18           | Ecosistema educativo        | LMS, videoconferencia, proctoring, vendors.            | Capabilities, no vendor-specific domain.                       |
| IAM             | Identidad técnica           | AuthN, MFA, roles/permisos base, subject.              | tenant/scope no viene de body libre.                           |
| Core RRHH       | Relación laboral            | Contratos, cargo, disponibilidad laboral.              | Assignments EC no reemplazan RRHH.                             |
| Core Financiero | Hecho financiero            | Obligaciones, pagos, factura, saldos, contabilidad.    | Reconcile ante UNKNOWN_EFFECT.                                 |
| AI-SERVICE      | Orquestación IA             | Model routing, telemetry, evals y governance.          | Acceso solo vía CT-12.                                         |

# 15. Arquitectura funcional de la vertical

<img src="media/image2.png" title="Diagrama EC-00 2" style="width:6.85in;height:2.41439in" alt="Arquitectura de la vertical Educación Continua EC-01 a EC-12 y sus dependencias con Core Platform, IAM, RRHH, Finanzas, AI Service y módulos transversales CT." />

*Figura 2 — EC como vertical que consume capacidades CT/Core sin duplicarlas*

Todos los EC se implementarán como módulos Spring Modulith dentro del monolito modular de PeopleU IA, respetando arquitectura hexagonal. Compartir deployment no autoriza acceso directo a repositorios o tablas de otro módulo. La colaboración interna debe usar application ports, eventos de dominio/integración y contratos versionados.

\[Inbound adapters\] REST / Event Consumer / Scheduled Jobs / Import Commands  
\|  
v  
\[Application\] Use Cases / Commands / Queries / Input Ports  
\|  
v  
\[Domain\] Aggregates / Entities / Value Objects / Policies  
^  
\|  
\[Outbound Ports\] Repository / CT / IAM / RRHH / Finance / LMS / Audit / Events  
^  
\|  
\[Adapters\] PostgreSQL / MongoDB(read) / Redis(cache) / HTTP / Broker

# 16. Secuencia oficial EC-01 a EC-12

| **Orden** | **Código** | **Módulo oficial**                                                                            | **Responsabilidad primaria** |
|-----------|------------|-----------------------------------------------------------------------------------------------|------------------------------|
| 1         | EC-01      | Portafolio, programas, versiones, módulos y rutas de microcredenciales                        | Diseño académico             |
| 2         | EC-02      | Ediciones, ofertas, cohortes, modalidades, calendarios y programación operativa               | Oferta / ejecución           |
| 3         | EC-03      | Comercialización académica, pricing, promociones, becas, convenios y condiciones de oferta    | Comercial                    |
| 4         | EC-04      | Prospectos, participantes, registro, preinscripción, inscripción, cupos y listas de espera    | Vinculación                  |
| 5         | EC-05      | Docentes, expertos, facilitadores, planificación, contenidos y entorno de aprendizaje         | Docencia                     |
| 6         | EC-06      | Asistencia, participación, engagement y evidencia de sesiones                                 | Participación                |
| 7         | EC-07      | Evaluaciones, resultados, aprobación, completion y cierre académico                           | Evaluación / cierre          |
| 8         | EC-08      | Certificados, badges, microcredenciales, credenciales verificables y acumulabilidad primaria  | Certificación                |
| 9         | EC-09      | Formación corporativa / in-company, clientes, acuerdos, lotes y reporting empresarial         | B2B / Corporate              |
| 10        | EC-10      | Trayectoria de aprendizaje, progresión, stackable credentials y reconocimiento acumulativo EC | Trayectoria                  |
| 11        | EC-11      | Encuestas, NPS, feedback, evaluación docente, impacto y seguimiento posterior                 | Experiencia / impacto        |
| 12        | EC-12      | Calidad, analítica de portafolio, indicadores, compliance y mejora continua                   | Calidad / gobierno           |

## EC-01 — Portafolio, programas, versiones, módulos, outcomes, competencias y rutas de microcredenciales

Source of Truth de la definición académica EC y su historia versionada.

Dependencias principales: CT-01, CT-02, CT-05, CT-08, CT-15; downstream EC-02/08/10.

Frontera: No crea ediciones, sesiones, inscripciones, pagos ni certificados.

## EC-02 — Ediciones, ofertas, cohortes, modalidades, calendarios, capacidad y programación

Source of Truth de la ejecución/oferta de una ProgramVersion.

Dependencias principales: EC-01, CT-03, CT-13, CT-14, CT-18; expone a EC-03/04/05.

Frontera: No implementa solver, motor temporal, recursos ni pricing ledger.

## EC-03 — Comercialización académica, pricing, promociones, atribución y condiciones comerciales

Source of Truth de reglas/bindings comerciales específicos de ofertas EC.

Dependencias principales: EC-02, CT-02, Core Financiero, CT-06/07/11.

Frontera: No es ledger ni factura/pago.

## EC-04 — Prospect context, registro, inscripción, cupos, waitlist, transferencias y retiros

Source of Truth del vínculo de inscripción/enrollment y capacidad consumida.

Dependencias principales: EC-02/03, CT-04/05/06/07/15, Finanzas.

Frontera: No crea Person ni registra pagos.

## EC-05 — Docentes, expertos, delivery plan, contenidos, accommodations y entorno de aprendizaje

Source of Truth de assignments docentes EC y planificación de delivery.

Dependencias principales: EC-02/04, CT-04, RRHH, CT-05/13/18.

Frontera: No crea empleados ni LMS propio.

## EC-06 — Asistencia, participación y engagement

Source of Truth de attendance/participation facts EC.

Dependencias principales: EC-02/04/05, CT-03/05/18.

Frontera: No determina pass ni emite certificados.

## EC-07 — Evaluación, integridad, appeals, resultados, completion y cierre

Source of Truth de assessment outcomes, pass y completion.

Dependencias principales: EC-04/06, CT-02/05/06/15.

Frontera: No emite credenciales ni altera pagos.

## EC-08 — Certificados, badges, microcredenciales y credenciales verificables interoperables

Source of Truth del award/issuance business state y elegibilidad específica EC.

Dependencias principales: EC-07, CT-02/04/05/06/07/10, Finanzas.

Frontera: No almacena PDFs; no crea grados.

## EC-09 — Formación corporativa / in-company, TNA, sponsor governance y reporting

Source of Truth de relación B2B EC, acuerdos operativos y batches.

Dependencias principales: EC-02/03/04/06/07, CT-05/06/10/11, Finanzas.

Frontera: No fusiona empresa con participantes ni expone PII sin base.

## EC-10 — Trayectoria y stacking

Source of Truth de rutas, stacking y progreso acumulativo dentro de EC.

Dependencias principales: EC-01/07/08, CT-02/11/15.

Frontera: No concede equivalencias PG/PO implícitas.

## EC-11 — Feedback, NPS e impacto

Source of Truth de feedback/impact facts propios de EC.

Dependencias principales: EC-04/05/07/09/10, CT-07/10/11/12.

Frontera: No es BI general ni motor de encuestas transversal.

## EC-12 — Calidad, portfolio lifecycle, mejora continua y decisiones de retiro/relaunch

Source of Truth de decisiones/acciones de calidad específicas del portafolio EC.

Dependencias principales: Todos EC + CT-11/12/16.

Frontera: No reemplaza BI, auditoría o acreditación institucional transversal.

# 17. Orden técnico de implementación y dependencias

<img src="media/image3.png" title="Diagrama EC-00 3" style="width:6.55in;height:0.7408in" alt="Dependencias semánticas entre los módulos EC-01 a EC-12, desde definición y edición hasta trayectoria, impacto y calidad." />

*Figura 3 — Dependencias semánticas principales entre módulos EC*

La secuencia documental EC-01…EC-12 es oficial. El orden de construcción puede paralelizarse, pero debe respetar contratos. El primer vertical slice de producción debería cerrar el ciclo académico básico: definición → edición → inscripción → docencia → asistencia → evaluación/completion → credencial. EC-03 y EC-09 pueden avanzar en paralelo después de estabilizar EC-02; EC-11 y EC-12 dependen de hechos producidos por módulos anteriores.

| **Wave**  | **Módulos**                   | **Objetivo**                          |
|-----------|-------------------------------|---------------------------------------|
| Wave EC-A | EC-01                         | Definición académica y versionado.    |
| Wave EC-B | EC-02 + contratos CT-03/13/14 | Ejecución y oferta.                   |
| Wave EC-C | EC-04                         | Registro/enrollment/cupos.            |
| Wave EC-D | EC-05 + EC-06                 | Delivery, asistencia, participación.  |
| Wave EC-E | EC-07 + EC-08                 | Completion y credencial end-to-end.   |
| Wave EC-F | EC-03 + EC-09                 | Comercial B2C/B2B e in-company.       |
| Wave EC-G | EC-10                         | Stacking y trayectoria.               |
| Wave EC-H | EC-11 + EC-12                 | Impacto, analítica y mejora continua. |

# 18. Journeys E2E maestros

| **Journey**                    | **Flujo E2E**                                                                                                                                                                                                |
|--------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| J-01 Oferta abierta individual | EC-01 define versión → EC-02 publica edición/offering → EC-03 calcula pricing context → EC-04 registra/inscribe → Finanzas confirma condición → EC-05/06 ejecutan → EC-07 completa → EC-08 emite credencial. |
| J-02 Waitlist                  | Offering llena cupo → EC-04 crea waitlist → liberación de cupo produce oferta temporal → usuario acepta idempotentemente → enrollment confirmado.                                                            |
| J-03 Programa corporate        | EC-09 crea relación/acuerdo → EC-02 edición cerrada → EC-09 batch de nominados → EC-04 enrolments individuales → EC-06/07 hechos académicos → EC-09 reporting permitido.                                     |
| J-04 Microcredencial stackable | EC-01 define ruta → participante obtiene awards EC-08 → EC-10 evalúa stacking → al satisfacer regla crea cumulative outcome → EC-08 puede emitir credencial mayor.                                           |
| J-05 Virtual asíncrono         | EC-02 activa offering → CT-18 provisiona espacio LMS → EC-04 enrollment → CT-18 sincroniza activity receipts → EC-06 participation → EC-07 completion → EC-08 certificate.                                   |
| J-06 Edición híbrida           | EC-02 combina sesiones presenciales/virtuales → CT-13/14/18 resuelven recursos → EC-06 consolida evidencia multi-canal sin duplicar presencia.                                                               |
| J-07 Financial timeout         | EC envía ChargeIntent → timeout después de posible commit remoto → estado UNKNOWN_EFFECT → reconcile con Finanzas → solo luego retry/compensación.                                                           |
| J-08 Certificate correction    | Credencial emitida contiene error de negocio → no se edita el registro original → se void/supersede según política → CT-05 conserva artefacto anterior y nuevo con lineage.                                  |
| J-09 Bulk import corporate     | CT-16 importa nominados → normaliza/dedup CT-04 → dry-run → promoción por API EC-09/04 → receipts por fila → reconciliation.                                                                                 |
| J-10 Impact follow-up          | EC-11 programa feedback posterior → CT-07 comunica → respuestas con purpose → CT-11 dataset → EC-12 decisión de mejora con evidencia.                                                                        |

# 19. Modelo de dominio global y ownership de aggregates

| **Módulo** | **Aggregate Root**           | **Entidades/objetos**                                       | **Invariantes nucleares**                  |
|------------|------------------------------|-------------------------------------------------------------|--------------------------------------------|
| EC-01      | ProgramDefinition            | ProgramVersion, LearningModule, CredentialPathwayDefinition | Versionado, publish, estructura académica. |
| EC-02      | ProgramEdition               | Offering, DeliveryConfiguration                             | Edición y publicación operativa.           |
| EC-03      | CommercialOfferPolicyBinding | PromotionCampaignBinding, PricingContextSnapshot            | Contexto comercial EC.                     |
| EC-04      | EnrollmentCase               | Registration, WaitlistEntry, Enrollment                     | Cupos y vínculo participante-edición.      |
| EC-05      | InstructorAssignment         | DeliveryPlan, LearningResourceBinding                       | Asignación y delivery.                     |
| EC-06      | ParticipationRecord          | AttendanceRecord, EngagementEvidence                        | Hechos de participación.                   |
| EC-07      | ParticipantOutcome           | AssessmentResult, CompletionDecision                        | Resultado y cierre.                        |
| EC-08      | CredentialAward              | EligibilityDecision, IssuanceRecord                         | Otorgamiento y emisión.                    |
| EC-09      | CorporateTrainingEngagement  | CommercialAgreementRef, CorporateEnrollmentBatch            | Relación B2B EC.                           |
| EC-10      | ParticipantLearningPath      | CredentialStack, PathwayProgress                            | Acumulabilidad.                            |
| EC-11      | ExperienceFeedbackCase       | SurveyResponseRef, ImpactObservation                        | Feedback/impacto.                          |
| EC-12      | PortfolioQualityReview       | ImprovementAction                                           | Gobierno de calidad EC.                    |

# 20. Máquinas de estado maestras

| **Objeto**         | **Estados**                                                                                                                                                     | **Regla**                                                                                                          |
|--------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| ProgramVersion     | DRAFT → REVIEW → APPROVED → PUBLISHED → RETIRED                                                                                                                 | PUBLISHED inmutable; nueva versión para cambio material.                                                           |
| ProgramEdition     | PLANNED → SCHEDULED → OPEN → IN_PROGRESS → COMPLETED \| CANCELLED; SCHEDULED/OPEN → POSTPONED → SCHEDULED; OPEN/IN_PROGRESS → SUSPENDED → IN_PROGRESS/CANCELLED | No OPEN sin versión publicable y dependencias críticas válidas. Postpone/suspend preservan schedule/state history. |
| Offering           | DRAFT → PUBLISHED → PAUSED → CLOSED/WITHDRAWN                                                                                                                   | No confundir CLOSED con edición COMPLETED.                                                                         |
| Registration       | DRAFT → SUBMITTED → PENDING → ACCEPTED/WAITLISTED/REJECTED/CANCELLED                                                                                            | SUBMITTED requiere identity según política.                                                                        |
| Enrollment         | PENDING_CONFIRMATION → ACTIVE → COMPLETED \| WITHDRAWN \| CANCELLED \| TRANSFER_PENDING → TRANSFERRED                                                           | Transfer no muta edition_id; crea enrollment destino idempotente.                                                  |
| Attendance         | UNRECORDED → RECORDED → VERIFIED → CORRECTED                                                                                                                    | Corrección conserva historia/evidencia.                                                                            |
| ParticipantOutcome | IN_PROGRESS → ELIGIBLE_FOR_REVIEW → COMPLETED/PASSED/NOT_COMPLETED/FAILED                                                                                       | Completion y pass separados.                                                                                       |
| CredentialAward    | PENDING_ELIGIBILITY → ELIGIBLE → ISSUANCE_PENDING → ISSUED → SUPERSEDED \| VOIDED \| EXPIRED                                                                    | Issued immutable; status verificable; corrección por supersede/void; expiry solo por policy.                       |
| CorporateBatch     | DRAFT → VALIDATED → SUBMITTED → PARTIALLY_APPLIED/APPLIED/REJECTED                                                                                              | Aplicación idempotente por participante.                                                                           |
| PathwayProgress    | IN_PROGRESS → SATISFIED → AWARDED/EXPIRED                                                                                                                       | Satisfaction no emite credencial por sí sola.                                                                      |
| ImpactFollowUp     | PLANNED → OPEN → CLOSED/EXPIRED                                                                                                                                 | Consent/purpose controlan contacto y uso.                                                                          |
| PortfolioEntry     | DISCOVERY → PILOT → ACTIVE/SCALE → WATCH → SUSPENDED/RETIRED → RELAUNCHED                                                                                       | EC-12 gobierna decisiones con evidence y exit criteria; RETIRED no borra historia.                                 |

# 21. Contratos e integraciones transversales

Los módulos EC deben publicar contratos estables y versionados. Ningún adapter puede depender de tablas de otro bounded context. Las integraciones con efecto remoto deben definir timeout, retry, circuit breaker, deduplication, reconciliation, receipt y semántica UNKNOWN_EFFECT. Las consultas de lectura deben expresar freshness y disponibilidad; no deben convertir ausencia de respuesta en un valor de negocio.

| **Port**                  | **Proveedor**   | **Contrato esperado**                                                   |
|---------------------------|-----------------|-------------------------------------------------------------------------|
| InstitutionScopePort      | CT-01           | Resolver tenant/sede/campus/unidad y scope autorizado.                  |
| PolicyResolutionPort      | CT-02           | Resolver política versionada por contexto y devolver policyRef/version. |
| TemporalPort              | CT-03           | Ventanas, calendarios, sessions y timezone semantics.                   |
| PersonPort                | CT-04           | Resolve/create/correlate Person según contrato.                         |
| EvidencePort              | CT-05           | Document/evidence refs, hash y verificabilidad.                         |
| WorkflowPort              | CT-06           | Casos/aprobaciones/SLA sin delegar semántica de dominio.                |
| NotificationIntentPort    | CT-07           | Enviar intención y recibir delivery receipt.                            |
| LocalizationPort          | CT-08           | Resolver labels/reason codes.                                           |
| IntegrationGovernancePort | CT-09           | Publicación/consumo de eventos y contratos.                             |
| AuditPrivacyPort          | CT-10           | Audit envelope, purpose, masking, consent refs.                         |
| AnalyticsFactPort         | CT-11           | Publicar hechos/datasets.                                               |
| AIRecommendationPort      | CT-12           | Solicitar run asistivo con grounding/evals.                             |
| SchedulingPort            | CT-13           | Generar/validar schedule.                                               |
| ResourceReservationPort   | CT-14           | Reservas de aulas/equipos.                                              |
| EligibilityPort           | CT-15           | Resolver elegibilidad transversal explicable.                           |
| MigrationPromotionPort    | CT-16           | Promoción gobernada de registros legacy.                                |
| ContinuityPort            | CT-17           | Registrar impacto y operar runbooks.                                    |
| LearningEcosystemPort     | CT-18           | LMS, virtual meeting, proctoring, vendor capability.                    |
| FinancePort               | Core Financiero | ChargeIntent, financial status, reconciliation, refunds/void refs.      |
| HRPort                    | Core RRHH       | Relación laboral/disponibilidad cuando corresponda.                     |
| IdentityAccessPort        | IAM             | Subject, assurance, MFA, permission claims.                             |

# 22. Integración financiera y pricing

EC-03 puede materializar PricingContext para explicar por qué una persona/empresa tiene un precio, beneficio o promoción aplicable. Ese contexto incluye offering, segmento, ventana, campaign/policy refs, cantidad, moneda y snapshot de variables. No crea ni modifica el ledger financiero.

PricingContext {  
tenantId, offeringId, payerType, payerRef, participantRef?,  
basePriceRef, promotionRefs\[\], scholarshipRef?, agreementRef?,  
currency, calculatedAt, policySnapshotRefs\[\], explanationCodes\[\]  
}  
  
ChargeIntent -\> Core Financiero  
FinancialStatus \<- Core Financiero  
Receipt / reconciliationRef \<- Core Financiero

## 22.1 Estados financieros visibles en Frontend

| **Estado UI**  | **Semántica**                                                             |
|----------------|---------------------------------------------------------------------------|
| NO_DATA        | No existe todavía un hecho/consulta aplicable.                            |
| ZERO           | El Core confirma saldo/cargo igual a cero.                                |
| CURRENT        | Dato disponible y vigente.                                                |
| STALE          | Última lectura existe pero superó freshness budget.                       |
| PARTIAL        | Solo parte de los componentes financieros está disponible.                |
| UNAVAILABLE    | Dependencia no respondió; no inferir cero ni pagado.                      |
| UNKNOWN_EFFECT | Se desconoce si un comando remoto fue aplicado; bloquear reintento ciego. |

# 23. LMS, videoconferencia y ecosistema externo

CT-18 es la única puerta de integración con LMS, videoconferencia, proctoring y plataformas educativas externas. EC-05/06/07 consumen capacidades semánticas como provision learning space, publish roster, fetch activity receipts o validate completion evidence; no llaman directamente a Moodle/Canvas/Teams/Zoom/Meet ni guardan IDs de vendor sin envolverlos en referencias de CT-18.

| **Capability**           | **Uso**                                                   |
|--------------------------|-----------------------------------------------------------|
| LEARNING_SPACE_PROVISION | Crear/configurar espacio de curso por edition/module.     |
| ROSTER_SYNC              | Sincronizar participantes/instructores.                   |
| CONTENT_LINK             | Vincular contenido/recursos externos.                     |
| LIVE_SESSION_PROVISION   | Crear sesión virtual y resolver join refs.                |
| ACTIVITY_RECEIPT         | Recibir evidencia de actividad asíncrona/síncrona.        |
| ASSESSMENT_RESULT_IMPORT | Importar resultado externo sujeto a validación EC-07.     |
| COMPLETION_SIGNAL        | Señal externa; nunca sustituye completion decision EC-07. |
| RECONCILIATION           | Comparar roster/session/results entre PeopleU y vendor.   |

# 24. Docentes, expertos, instructores y speakers

EC-05 debe modelar roles de delivery sin asumir que todo instructor es empleado. CT-04 conserva Person; Core RRHH conserva la relación laboral si existe. EC-05 crea un InstructorAssignment contextual a edition/module/session con rol, responsabilidades, vigencia, habilitación y evidence refs. La remuneración no pertenece a EC salvo referencias a acuerdos externos según arquitectura de RRHH/Finanzas.

| **Rol EC**       | **Regla**                                                           |
|------------------|---------------------------------------------------------------------|
| INSTRUCTOR       | Imparte y puede evaluar según permisos.                             |
| FACILITATOR      | Facilita aprendizaje/operación; evaluación limitada según política. |
| EXTERNAL_EXPERT  | Especialista externo con assignment EC; no implica empleo.          |
| SPEAKER          | Participación puntual; permisos mínimos.                            |
| MENTOR           | Acompañamiento cuando el programa lo define.                        |
| ASSESSOR         | Evalúa resultados; puede requerir SoD respecto a coordinación.      |
| PROGRAM_DIRECTOR | Responsable académico de edición/programa con scope institucional.  |

# 25. Seguridad, privacidad, RBAC/ABAC, SoD y step-up

La autorización efectiva combina permisos base de IAM con scope institucional de CT-01 y atributos contextuales del recurso. Ningún endpoint sensible debe confiar tenant_id, site_id o role desde body libre. Los listados y búsquedas deben aplicar tenant isolation server-side y contract tests negativos.

| **Operación**                | **Puede iniciar**                    | **Controles**                                                   | **No permitido**                                           |
|------------------------------|--------------------------------------|-----------------------------------------------------------------|------------------------------------------------------------|
| Publicar ProgramVersion      | Program Director / Academic Admin    | Aprobación institucional según policy; step-up si impacto alto. | Autor de contenido no puede autoaprobar cuando SoD aplica. |
| Abrir Offering               | EC Operations                        | Scope sede/programa; dependencias válidas.                      | No puede alterar ProgramVersion publicada.                 |
| Aplicar override comercial   | Commercial Officer + policy/approval | Reason code y evidencia.                                        | No puede modificar outcome académico.                      |
| Forzar enrollment sobre cupo | EC Operations + approval             | Step-up, reason, audit; policy excepcional.                     | No se permite a participante.                              |
| Corregir asistencia          | Instructor/Operations según scope    | Evidence + reason; historial.                                   | No borrar registro original.                               |
| Cerrar completion            | Instructor/Academic role             | Policy snapshot; SoD cuando aplica.                             | Commercial role no decide.                                 |
| Emitir certificado           | Certificate Officer                  | Elegibilidad CONFIRMED; idempotency; step-up para masivo.       | No emitir si UNKNOWN financial/evidence.                   |
| Ver reportes corporate       | Corporate Viewer                     | ABAC por agreement + purpose + minimization.                    | Sin datos fuera de la cohorte/acuerdo.                     |
| Void credential              | Rol reforzado                        | Step-up + aprobación + reason + evidence.                       | Nunca delete físico.                                       |
| Bulk import                  | Data/Operations                      | Dry-run, schema validation, approval si corresponde.            | No INSERT directo a producción.                            |

# 26. Estándares de datos, multitenancy y diseño físico para EC

> **EC-00 NO CREA TABLAS**
>
> Como documento constitucional, EC-00 no tendrá un esquema físico propio. Los módulos EC-01…EC-12 deberán aplicar las reglas siguientes tabla por tabla y responder explícitamente: “¿Qué error debe impedir PostgreSQL aunque Backend tenga un bug?”.

## 26.1 Convenciones físicas obligatorias

| **Campo patrón**    | **Tipo**                       | **Regla**                                                                                   |
|---------------------|--------------------------------|---------------------------------------------------------------------------------------------|
| tenant_id           | uuid NOT NULL                  | Resuelto desde contexto autorizado; parte de PK/FK interna cuando sea crítico.              |
| id                  | uuid NOT NULL                  | Identificador inmutable; preferencia por UUIDv7/ordenable si baseline plataforma lo adopta. |
| version             | bigint NOT NULL DEFAULT 0      | Optimistic locking; @Version; ETag/If-Match.                                                |
| created_at          | timestamptz NOT NULL           | UTC.                                                                                        |
| created_by          | uuid NOT NULL                  | subject IAM EXT REF.                                                                        |
| updated_at          | timestamptz NOT NULL           | UTC; no sustituye audit trail.                                                              |
| updated_by          | uuid NOT NULL                  | subject IAM EXT REF.                                                                        |
| status              | varchar/check o enum gobernado | Estados explícitos; no booleanos ambiguos para lifecycle complejo.                          |
| policy_snapshot_ref | uuid/varchar según contrato    | Referencia/snapshot para reconstrucción cuando una regla decide historia.                   |
| correlation_id      | uuid/varchar                   | Trazabilidad E2E en operaciones críticas.                                                   |

## 26.2 FK tenant-aware dentro del mismo bounded context

PRIMARY KEY (tenant_id, id)  
  
FOREIGN KEY (tenant_id, program_version_id)  
REFERENCES ec01_program_version (tenant_id, id)  
  
UNIQUE (tenant_id, business_code, version_no)  
  
CHECK (valid_to IS NULL OR valid_to \> valid_from)

## 26.3 Cross-context

No se crea FK física hacia tablas de CT/IAM/RRHH/Finanzas/otro bounded context. Se almacena el identificador externo con semántica explícita (por ejemplo person_id, document_ref, financial_obligation_ref), se valida por port/contract y se acompaña con contract tests, event reconciliation y snapshots cuando la historia lo requiere.

## 26.4 MongoDB y Redis

PostgreSQL es Source of Truth transaccional de los hechos EC. MongoDB se admite únicamente para documentos derivados, search/read models o proyecciones semiestructuradas no autoritativas con owner y rebuild strategy. Redis se usa para caché, rate limiting o locks técnicos; la caída de Redis no puede destruir integridad ni impedir reconstrucción desde PostgreSQL.

# 27. Eventos, outbox/inbox y envelope canónico

| **ID**       | **Evento**                   | **Producer** | **Consumers**      |
|--------------|------------------------------|--------------|--------------------|
| EVT-EC01-001 | ProgramVersionPublished      | EC-01        | EC-02, CT-11       |
| EVT-EC02-001 | ProgramEditionOpened         | EC-02        | EC-03/04/05, CT-11 |
| EVT-EC02-002 | OfferingPublished            | EC-02        | EC-03/04, CT-11    |
| EVT-EC03-001 | CommercialTermsPublished     | EC-03        | EC-04, CT-11       |
| EVT-EC04-001 | RegistrationSubmitted        | EC-04        | CT-07/11           |
| EVT-EC04-002 | EnrollmentConfirmed          | EC-04        | EC-05/06, CT-18/11 |
| EVT-EC04-003 | WaitlistPositionChanged      | EC-04        | CT-07              |
| EVT-EC05-001 | InstructorAssigned           | EC-05        | CT-18/11           |
| EVT-EC05-002 | LearningEnvironmentReady     | EC-05        | EC-04/06           |
| EVT-EC06-001 | AttendanceRecorded           | EC-06        | EC-07/11           |
| EVT-EC06-002 | ParticipationUpdated         | EC-06        | EC-07/11           |
| EVT-EC07-001 | ParticipantCompleted         | EC-07        | EC-08/10/11        |
| EVT-EC07-002 | ParticipantPassed            | EC-07        | EC-08/10/11        |
| EVT-EC08-001 | CredentialAwarded            | EC-08        | EC-10/11, CT-07    |
| EVT-EC08-002 | CredentialIssued             | EC-08        | EC-10, CT-11       |
| EVT-EC08-003 | CredentialSuperseded         | EC-08        | EC-10/11           |
| EVT-EC09-001 | CorporateBatchApplied        | EC-09        | EC-04/11           |
| EVT-EC09-002 | CorporateEngagementCompleted | EC-09        | EC-11/12           |
| EVT-EC10-001 | PathwaySatisfied             | EC-10        | EC-08/11           |
| EVT-EC11-001 | FeedbackWindowOpened         | EC-11        | CT-07              |
| EVT-EC11-002 | ImpactObservationRecorded    | EC-11        | EC-12/CT-11        |
| EVT-EC12-001 | PortfolioImprovementApproved | EC-12        | EC-01/02/11        |

{  
"messageId": "uuid",  
"tenantId": "uuid",  
"occurredAt": "2026-09-08T14:00:00Z",  
"correlationId": "uuid",  
"causationId": "uuid\|null",  
"schemaVersion": 1,  
"producer": "EC-XX",  
"aggregateType": "...",  
"aggregateId": "uuid",  
"dataClassification": "INTERNAL\|CONFIDENTIAL\|PII",  
"payload": { }  
}

Toda transición crítica que requiera evento persiste estado + outbox en la misma transacción PostgreSQL. Los consumidores registran inbox/deduplication por messageId. PeopleU IA no promete exactly-once; exige at-least-once + consumer idempotente + reconciliation.

# 28. Resiliencia, degradación, reconciliación y UNKNOWN_EFFECT

| **Situación**                            | **Comportamiento requerido**                                                                   |
|------------------------------------------|------------------------------------------------------------------------------------------------|
| Lectura CT/Core falla                    | Mostrar STALE/PARTIAL/UNAVAILABLE según evidencia disponible; nunca valor favorable inventado. |
| Comando remoto antes de commit conocido  | Retry con backoff solo si idempotency contract lo permite.                                     |
| Timeout después de posible commit remoto | Marcar UNKNOWN_EFFECT, persistir receipt intent, reconcile antes de retry.                     |
| Evento duplicado                         | Inbox dedup; no repetir side effects.                                                          |
| Redis caído                              | Fallback a PostgreSQL/servicio; degradación de performance, no de integridad.                  |
| Mongo projection caída                   | UI puede usar endpoint transaccional o mostrar PARTIAL; reconstruir proyección.                |
| CT-07 caído                              | Hecho académico permanece commit; notification intent se reintenta.                            |
| CT-18/LMS caído                          | No inferir falta de actividad; conservar UNAVAILABLE y reconciliar.                            |
| Finance unavailable                      | No asumir deuda cero/pago; bloquear acciones cuya política exige certeza.                      |
| CT-12 IA caída                           | Continuar flujo determinista/humano; IA es asistiva.                                           |

# 29. Frontend Web: workspaces y estados normativos

El Frontend se organiza por workspaces orientados a tareas, no por “pantallas CRUD”. Cada workspace debe declarar actor, objetivo, layout, rutas, componentes, filtros, KPIs, acciones, drawers/modals, permisos, estados de disponibilidad, accesibilidad y comportamiento responsive. El estado del servidor se gestiona con cliente de queries; ETag/If-Match debe proteger mutaciones concurrentes.

| **Workspace**                | **Usuario principal** | **Contenido**                                                                   |
|------------------------------|-----------------------|---------------------------------------------------------------------------------|
| EC Program Studio            | Diseñador académico   | Definiciones, versiones, módulos, outcomes, policy bindings, publish readiness. |
| Edition & Offering Console   | Operaciones EC        | Ediciones, fechas, modalidad, cupos, dependencies readiness, publication.       |
| Commercial Offer Desk        | Comercial             | Pricing contexts, promociones, becas, canales y simulación explicable.          |
| Registration Desk            | Operaciones/Registro  | Registrations, identity resolution, cupos, waitlist, financial/evidence states. |
| Corporate Training Workspace | B2B                   | Accounts, agreements, batches, cohort status, report permissions.               |
| Instructor Workspace         | Instructor/Expert     | Agenda, roster permitido, materiales, asistencia, evaluaciones.                 |
| Attendance Console           | Instructor/Operations | Check-in, QR, corrections, evidence, sync state.                                |
| Assessment Workspace         | Instructor/Academic   | Assessment plan, results, review, completion candidates.                        |
| Certificate Desk             | Secretaría/EC         | Eligibility, issuance, bulk runs, void/supersede, verification.                 |
| Participant Portal           | Participante          | Agenda, progreso, materiales, pagos referenciados, certificados, feedback.      |
| Reconciliation Center        | Operations/SRE        | UNKNOWN_EFFECT, mismatches, external receipts, retry/compensation.              |
| Quality & Impact Workspace   | Dirección EC          | KPIs, feedback, improvement actions, portfolio decisions.                       |

## 29.1 Estados obligatorios

| **Estado**     | VIGENTE — DOCUMENTO MAESTRO OFICIAL · BASELINE FORTALECIDO                              |
|----------------|-----------------------------------------------------------------------------------------|
| LOADING        | Consulta inicial en curso.                                                              |
| NO_DATA        | Consulta válida sin registros.                                                          |
| ZERO           | Valor numérico confirmado igual a cero.                                                 |
| STALE          | Dato conocido pero fuera del freshness budget.                                          |
| PARTIAL        | Subconjunto disponible; declarar qué falta.                                             |
| UNAVAILABLE    | Dependencia no disponible; no inferir estado de negocio.                                |
| UNKNOWN_EFFECT | Acción remota con resultado incierto; impedir reintento ciego y ofrecer reconciliación. |
| ERROR          | Error conocido con ProblemDetail/reason code y recovery path.                           |

# 30. Mobile: principios, journeys y restricciones

Mobile tiene alto valor en EC por la naturaleza corta, distribuida y móvil de las experiencias. Sin embargo, no debe replicar el backoffice administrativo. La app se orientará a participante e instructor para acciones inmediatas, seguras y contextuales.

| **Perfil**            | **Journeys Mobile**                                                                                 | **Restricciones**                                                                           |
|-----------------------|-----------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| Participante          | Agenda, join deep links, QR check-in, materiales, progreso, notificaciones, certificados, feedback. | No publicar programas, aplicar descuentos manuales, void certificados ni forzar enrollment. |
| Instructor            | Agenda, roster mínimo, asistencia, evidencia, evaluación rápida permitida, alertas de sync.         | No operaciones masivas sensibles ni cambios de política.                                    |
| Corporate coordinator | Opcional y limitado: nominaciones/estado agregado cuando contrato lo habilite.                      | No acceso a notas/datos personales fuera de purpose.                                        |
| Operations            | Preferentemente Web; móvil solo alertas/lecturas de emergencia.                                     | No reconciliaciones financieras críticas ni bulk imports.                                   |

## 30.1 Offline

Attendance/check-in puede soportar offline controlado con device timestamp, session ref, signer/device metadata y sync receipt. El backend sigue siendo autoritativo; conflictos, duplicados o evidencias fuera de ventana se marcan para revisión. No se permite generar una credencial oficial offline.

# 31. IA aplicada responsablemente

Toda IA pasa por CT-12 / AI-SERVICE. Los módulos EC solo expresan tareas, contexto y criterios. Cada recomendación debe ser trazable mediante run_ref, model_ref, prompt/template ref, eval ref, grounding refs, confidence, reviewer y outcome. La ausencia de IA no debe impedir operaciones deterministas esenciales salvo que una capability esté explícitamente declarada como no esencial y la UI muestre UNAVAILABLE.

| **Módulo** | **Uso IA permitido**                                                           | **Límite**                                            |
|------------|--------------------------------------------------------------------------------|-------------------------------------------------------|
| EC-01      | Asistir diseño de outcomes, estructura, contenidos y comparación de versiones. | No aprobar ni publicar programa.                      |
| EC-02      | Sugerir calendario/ocupación a través de CT-12 + CT-13.                        | No reservar recursos unilateralmente.                 |
| EC-03      | Explicar segmentación o detectar anomalías de promoción.                       | No fijar precio final fuera de política.              |
| EC-04      | Clasificar consultas/documentos y predecir riesgo de abandono.                 | No admitir/inscribir unilateralmente.                 |
| EC-05      | Generar borradores de planificación/materiales y resumir feedback docente.     | No evaluar desempeño laboral.                         |
| EC-06      | Detectar inconsistencias de asistencia/engagement.                             | No marcar presencia sin evidencia.                    |
| EC-07      | Asistir feedback/rúbricas y detectar outliers.                                 | No cambiar nota, pass o completion.                   |
| EC-08      | Verificar consistencia de datos antes de emisión.                              | No emitir/void credencial.                            |
| EC-09      | Resumir avance corporativo y riesgos agregados.                                | No revelar PII ni decidir condiciones contractuales.  |
| EC-10      | Recomendar rutas de aprendizaje.                                               | No adjudicar equivalencias/grados.                    |
| EC-11      | Clasificar feedback, temas y sentimiento con grounding.                        | No sustituir análisis humano en decisiones sensibles. |
| EC-12      | Detectar patrones de portfolio y proponer mejoras.                             | No cerrar programas automáticamente.                  |

# 32. Analítica, KPI y reporting

Los módulos EC producen hechos; CT-11 gobierna datasets, métricas institucionales y dashboards. Una métrica no debe calcularse con semántica implícita. Cada KPI requiere definición, grain, numerator/denominator, time basis, exclusions, freshness y owner.

| **KPI**               | **Definición conceptual**                                                                          |
|-----------------------|----------------------------------------------------------------------------------------------------|
| Demand                | Prospects/registrations por offering y canal.                                                      |
| Conversion            | Registration submitted → enrollment confirmed.                                                     |
| Occupancy             | Cupos ocupados / capacidad efectiva.                                                               |
| Waitlist pressure     | Waitlist / capacidad.                                                                              |
| No-show               | Enrolled sin participación válida.                                                                 |
| Attendance rate       | Asistencia según policy snapshot, no simple promedio si existen equivalencias.                     |
| Completion rate       | Completion decisions / cohort elegible.                                                            |
| Pass rate             | PASS / evaluated participants cuando evaluación aplica.                                            |
| Credential issuance   | Awards issued / eligible; medir backlog.                                                           |
| Time-to-certificate   | Completion/eligibility → issuance.                                                                 |
| Corporate utilization | Cupos contratados vs activados/completados.                                                        |
| NPS / satisfaction    | Resultado de instrumento versionado con población base.                                            |
| Repeat participation  | Personas que vuelven a otra offering/edition.                                                      |
| Stacking progression  | Participantes con progreso en pathways.                                                            |
| Portfolio health      | Demanda, margen referenciado, completion, satisfacción e impacto; sin mezclar ledger con datos EC. |

# 33. Migración legacy y Data Quality con CT-16

Toda migración sigue Extract → Normalize → Map → Validate → Dry-run → Promote through domain/API → Receipt → Reconcile → Certify. Está prohibido cargar directamente tablas finales porque evita invariantes, outbox, audit y side effects. La migración debe conservar lineage a fuente, source key, transformed payload, validation result, promotion result y receipt.

| **Objeto legacy**    | **Regla de migración**                                                                  |
|----------------------|-----------------------------------------------------------------------------------------|
| Programas históricos | Reconstruir ProgramDefinition/Version sin inventar versión; agrupar solo con evidencia. |
| Ediciones pasadas    | Preservar fechas/modalidad/sede y version snapshot; marcar calidad de dato.             |
| Participantes        | Deduplicar/correlacionar con CT-04 antes de crear vínculos.                             |
| Asistencia           | Importar evidencia disponible; no convertir ausencia de dato en ABSENT.                 |
| Notas/resultados     | Mapear escala y semántica; no inventar PASS si falta regla.                             |
| Certificados         | Vincular artifact/document ref si se digitaliza; preservar número/fecha/fuente.         |
| Corporate            | Separar empresa, batch y participantes; no usar una “persona empresa”.                  |
| Pagos históricos     | Referenciar/migrar en Core Financiero, no en EC.                                        |
| LMS activity         | Importar como evidence/receipts con fuente y confidence; no como verdad sin validación. |

# 34. QA enterprise y estrategia de pruebas

| **Suite**                  | **Cobertura mínima**                                                                                         |
|----------------------------|--------------------------------------------------------------------------------------------------------------|
| Unit / Domain Tests        | Invariantes de aggregates, state machines, policies y Value Objects.                                         |
| Repository Tests           | Constraints, tenant-aware keys, indexes, optimistic locking.                                                 |
| Integration Tests          | PostgreSQL real/Testcontainers; CT adapters mock/contract.                                                   |
| Contract Tests             | OpenAPI/AsyncAPI y ports cross-context.                                                                      |
| API Tests                  | ProblemDetail, idempotency, ETag, pagination/filtering.                                                      |
| Event Contract Tests       | Schema versioning, outbox/inbox, duplicates.                                                                 |
| Security Tests             | RBAC/ABAC, IDOR, tenant isolation, field masking, step-up, SoD.                                              |
| Concurrency Tests          | Cupos, waitlist, attendance correction, issuance masiva.                                                     |
| Idempotency Tests          | Registration, enrollment, charge intent, certificate, import, batch.                                         |
| Resilience Tests           | Timeout, circuit breaker, stale data, unknown effect, CT outages.                                            |
| Performance Tests          | Programas masivos, burst de inscripción, check-in simultáneo, bulk issuance.                                 |
| Migration Tests            | Dry-run, lineage, duplicates, partial failure, reconciliation.                                               |
| E2E                        | Journeys completos individuales/corporate/hybrid/LMS.                                                        |
| Mobile Tests               | Offline attendance, sync, deep links, push, access control.                                                  |
| AI Evals                   | Grounding, hallucination, policy compliance, bias/quality, human review path.                                |
| UAT                        | Escenarios reales con roles institucionales y evidencia.                                                     |
| Accessibility Tests        | WCAG 2.2 AA automatizado + manual; keyboard, focus, accessible authentication, screen reader critical paths. |
| Credential Interop Tests   | Open Badges/CLR/VC schema/proof/status validation cuando la capability esté habilitada.                      |
| Fraud/Assurance Tests      | QR replay, nonce expiry, device trust, identity assurance downgrade, proctoring outage.                      |
| Retention/Legal Hold Tests | TTL/purge, anonymization, legal hold selective, backup retention alignment.                                  |
| Appeal/Correction Tests    | History preservation, downstream reconciliation, no overwrite destructivo.                                   |

# 35. Catálogo BR-EC00 de reglas maestras

| **ID**      | **Nombre breve**                                                                                           | **Regla**                                                                                                                            |
|-------------|------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| BR-EC00-001 | Cada hecho transaccional EC pertenece exactamente a un tenant autorizado                                   | Cada hecho transaccional EC pertenece exactamente a un tenant autorizado.                                                            |
| BR-EC00-002 | El tenant se resuelve desde contexto autenticado; nunca se acepta como autoridad desde body libre          | El tenant se resuelve desde contexto autenticado; nunca se acepta como autoridad desde body libre.                                   |
| BR-EC00-003 | EC-00 no crea tablas, endpoints ni repositorios de runtime                                                 | EC-00 no crea tablas, endpoints ni repositorios de runtime.                                                                          |
| BR-EC00-004 | Una ProgramVersion PUBLISHED no se modifica destructivamente                                               | Una ProgramVersion PUBLISHED no se modifica destructivamente.                                                                        |
| BR-EC00-005 | Una ProgramEdition ejecuta una ProgramVersion explícita y versionada                                       | Una ProgramEdition ejecuta una ProgramVersion explícita y versionada.                                                                |
| BR-EC00-006 | Una Offering no puede modificar outcomes académicos de la ProgramVersion                                   | Una Offering no puede modificar outcomes académicos de la ProgramVersion.                                                            |
| BR-EC00-007 | Una sesión no puede redefinir por sí sola la estructura de un módulo                                       | Una sesión no puede redefinir por sí sola la estructura de un módulo.                                                                |
| BR-EC00-008 | Person canónica pertenece a CT-04; Participant referencia person_id                                        | Person canónica pertenece a CT-04; Participant referencia person_id.                                                                 |
| BR-EC00-009 | Corporate Client no puede modelarse como Participant ni Person ficticia                                    | Corporate Client no puede modelarse como Participant ni Person ficticia.                                                             |
| BR-EC00-010 | Registration no equivale a Enrollment                                                                      | Registration no equivale a Enrollment.                                                                                               |
| BR-EC00-011 | Payment no equivale a Enrollment                                                                           | Payment no equivale a Enrollment.                                                                                                    |
| BR-EC00-012 | Enrollment no puede duplicarse por reintento; requiere idempotencia durable                                | Enrollment no puede duplicarse por reintento; requiere idempotencia durable.                                                         |
| BR-EC00-013 | La ocupación de cupos debe ser concurrency-safe y tenant-aware                                             | La ocupación de cupos debe ser concurrency-safe y tenant-aware.                                                                      |
| BR-EC00-014 | Waitlist debe preservar orden/criterio configurable y evidencia de promociones                             | Waitlist debe preservar orden/criterio configurable y evidencia de promociones.                                                      |
| BR-EC00-015 | PricingContext debe ser explicable mediante policy/promotion refs                                          | PricingContext debe ser explicable mediante policy/promotion refs.                                                                   |
| BR-EC00-016 | EC nunca persiste deuda, pago, factura o saldo como verdad primaria                                        | EC nunca persiste deuda, pago, factura o saldo como verdad primaria.                                                                 |
| BR-EC00-017 | UNAVAILABLE financiero no se interpreta como ZERO o PAID                                                   | UNAVAILABLE financiero no se interpreta como ZERO o PAID.                                                                            |
| BR-EC00-018 | Una promoción no prueba que un descuento financiero fue aplicado                                           | Una promoción no prueba que un descuento financiero fue aplicado.                                                                    |
| BR-EC00-019 | Los beneficios comerciales variables usan CT-02 y snapshots cuando afectan historia                        | Los beneficios comerciales variables usan CT-02 y snapshots cuando afectan historia.                                                 |
| BR-EC00-020 | Las fechas oficiales se almacenan en UTC usando timestamptz                                                | Las fechas oficiales se almacenan en UTC usando timestamptz.                                                                         |
| BR-EC00-021 | Los horarios/sesiones consumen CT-03/13; recursos CT-14                                                    | Los horarios/sesiones consumen CT-03/13; recursos CT-14.                                                                             |
| BR-EC00-022 | Una edición EC no requiere calendario semestral                                                            | Una edición EC no requiere calendario semestral.                                                                                     |
| BR-EC00-023 | Attendance, Participation, Completion y Pass son hechos distintos                                          | Attendance, Participation, Completion y Pass son hechos distintos.                                                                   |
| BR-EC00-024 | La ausencia de evidencia de asistencia no equivale automáticamente a ABSENT                                | La ausencia de evidencia de asistencia no equivale automáticamente a ABSENT.                                                         |
| BR-EC00-025 | Las correcciones de asistencia conservan historia y reason code                                            | Las correcciones de asistencia conservan historia y reason code.                                                                     |
| BR-EC00-026 | Las evaluaciones pueden ser opcionales por ProgramVersion/policy                                           | Las evaluaciones pueden ser opcionales por ProgramVersion/policy.                                                                    |
| BR-EC00-027 | Completion debe reconstruirse con policy snapshot y evidence refs                                          | Completion debe reconstruirse con policy snapshot y evidence refs.                                                                   |
| BR-EC00-028 | Pass debe reconstruirse con assessment policy/version                                                      | Pass debe reconstruirse con assessment policy/version.                                                                               |
| BR-EC00-029 | CertificateEligibility es una decisión separada de Completion                                              | CertificateEligibility es una decisión separada de Completion.                                                                       |
| BR-EC00-030 | Credential issuance exige idempotency key y optimistic concurrency cuando aplique                          | Credential issuance exige idempotency key y optimistic concurrency cuando aplique.                                                   |
| BR-EC00-031 | Issued credential no se edita; se void/supersede según política                                            | Issued credential no se edita; se void/supersede según política.                                                                     |
| BR-EC00-032 | Los PDFs/archivos de certificados pertenecen a CT-05                                                       | Los PDFs/archivos de certificados pertenecen a CT-05.                                                                                |
| BR-EC00-033 | Microcredential no implica grado académico                                                                 | Microcredential no implica grado académico.                                                                                          |
| BR-EC00-034 | Stacking dentro de EC no genera equivalencia PG/PO sin contrato explícito                                  | Stacking dentro de EC no genera equivalencia PG/PO sin contrato explícito.                                                           |
| BR-EC00-035 | Los instructores EC pueden ser internos o externos; la relación laboral pertenece a RRHH                   | Los instructores EC pueden ser internos o externos; la relación laboral pertenece a RRHH.                                            |
| BR-EC00-036 | Un speaker no recibe automáticamente permisos de instructor/evaluador                                      | Un speaker no recibe automáticamente permisos de instructor/evaluador.                                                               |
| BR-EC00-037 | Los roles comerciales no pueden modificar resultados académicos                                            | Los roles comerciales no pueden modificar resultados académicos.                                                                     |
| BR-EC00-038 | Los reportes corporate aplican purpose limitation y minimización de PII                                    | Los reportes corporate aplican purpose limitation y minimización de PII.                                                             |
| BR-EC00-039 | Cada integración con efecto remoto define UNKNOWN_EFFECT y reconciliación                                  | Cada integración con efecto remoto define UNKNOWN_EFFECT y reconciliación.                                                           |
| BR-EC00-040 | No se hace retry ciego después de timeout con efecto remoto ambiguo                                        | No se hace retry ciego después de timeout con efecto remoto ambiguo.                                                                 |
| BR-EC00-041 | Toda transición crítica que publique evento usa outbox transaccional                                       | Toda transición crítica que publique evento usa outbox transaccional.                                                                |
| BR-EC00-042 | Todo consumidor con side effects usa inbox/deduplication                                                   | Todo consumidor con side effects usa inbox/deduplication.                                                                            |
| BR-EC00-043 | Los contratos cross-context no usan FK físicas                                                             | Los contratos cross-context no usan FK físicas.                                                                                      |
| BR-EC00-044 | Redis no es Source of Truth y su caída no rompe integridad                                                 | Redis no es Source of Truth y su caída no rompe integridad.                                                                          |
| BR-EC00-045 | MongoDB solo alberga proyecciones/documentos derivados rebuildables                                        | MongoDB solo alberga proyecciones/documentos derivados rebuildables.                                                                 |
| BR-EC00-046 | IA solo se invoca mediante CT-12 / AI-SERVICE                                                              | IA solo se invoca mediante CT-12 / AI-SERVICE.                                                                                       |
| BR-EC00-047 | AI Recommendation nunca cambia estado académico crítico sin decisión autorizada                            | AI Recommendation nunca cambia estado académico crítico sin decisión autorizada.                                                     |
| BR-EC00-048 | Las recomendaciones IA conservan run_ref, grounding, eval y reviewer cuando se usan                        | Las recomendaciones IA conservan run_ref, grounding, eval y reviewer cuando se usan.                                                 |
| BR-EC00-049 | Los módulos EC deben mostrar NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT de forma distinta | Los módulos EC deben mostrar NO_DATA, ZERO, STALE, PARTIAL, UNAVAILABLE y UNKNOWN_EFFECT de forma distinta.                          |
| BR-EC00-050 | Mobile no habilita operaciones administrativas críticas por simple paridad funcional                       | Mobile no habilita operaciones administrativas críticas por simple paridad funcional.                                                |
| BR-EC00-051 | Toda migración legacy pasa por CT-16 y promoción de dominio/API                                            | Toda migración legacy pasa por CT-16 y promoción de dominio/API.                                                                     |
| BR-EC00-052 | No se ejecutan INSERT directos a tablas finales durante migración                                          | No se ejecutan INSERT directos a tablas finales durante migración.                                                                   |
| BR-EC00-053 | Los state machines críticos no permiten last-write-wins silencioso                                         | Los state machines críticos no permiten last-write-wins silencioso.                                                                  |
| BR-EC00-054 | Aggregates mutables usan version/@Version y ETag/If-Match donde corresponda                                | Aggregates mutables usan version/@Version y ETag/If-Match donde corresponda.                                                         |
| BR-EC00-055 | Conflictos de versión retornan 412 o semántica equivalente definida                                        | Conflictos de versión retornan 412 o semántica equivalente definida.                                                                 |
| BR-EC00-056 | Validaciones de negocio retornan 422 con reason codes estables cuando corresponda                          | Validaciones de negocio retornan 422 con reason codes estables cuando corresponda.                                                   |
| BR-EC00-057 | Dependencia crítica caída puede retornar 503; no todo error se transforma en 500                           | Dependencia crítica caída puede retornar 503; no todo error se transforma en 500.                                                    |
| BR-EC00-058 | Cada EC debe mantener matriz Frontend/Backend/Mobile y permisos                                            | Cada EC debe mantener matriz Frontend/Backend/Mobile y permisos.                                                                     |
| BR-EC00-059 | Cada EC debe definir SLI/SLO y business metrics diferenciando rechazo de negocio de falla operacional      | Cada EC debe definir SLI/SLO y business metrics diferenciando rechazo de negocio de falla operacional.                               |
| BR-EC00-060 | Ningún módulo se certifica sin evidencia G1-G10 y Golden Scenarios ejecutables                             | Ningún módulo se certifica sin evidencia G1-G10 y Golden Scenarios ejecutables.                                                      |
| BR-EC00-061 | Cancelación no borra historia                                                                              | Una ProgramEdition CANCELLED preserva offering, enrollment, schedule snapshots, reasons y evidence refs.                             |
| BR-EC00-062 | Reprogramación versionada                                                                                  | Toda reprogramación preserva agenda anterior y produce versión/supersede; no overwrite silencioso.                                   |
| BR-EC00-063 | Transferencia crea nuevo vínculo                                                                           | Enrollment transfer no cambia edition_id del enrollment original; crea vínculo destino idempotente y cierra fuente como TRANSFERRED. |
| BR-EC00-064 | Sustitución corporativa no muta identidad                                                                  | Una sustitución nunca reemplaza person_id de un enrollment; crea nuevo participante/enrollment.                                      |
| BR-EC00-065 | Refund no pertenece a EC                                                                                   | Withdrawal/cancellation puede producir FinanceImpactIntent, pero Finance determina refund/credit/void.                               |
| BR-EC00-066 | Minimum viable cohort es policy                                                                            | El GO/NO-GO por mínimo de participantes es versionado y auditable.                                                                   |
| BR-EC00-067 | Accesibilidad es funcional                                                                                 | Accommodations que afectan delivery/assessment deben modelarse y auditarse con minimización de datos.                                |
| BR-EC00-068 | WCAG objetivo AA                                                                                           | Workspaces/portales EC deben cumplir WCAG 2.2 AA salvo excepción documentada.                                                        |
| BR-EC00-069 | Credencial portable                                                                                        | Cuando se habiliten credenciales digitales, preferir modelos interoperables Open Badges 3.0/CLR 2.0/W3C VC 2.0 vía CT-18/05.         |
| BR-EC00-070 | Telemetry no es decisión académica                                                                         | xAPI/Caliper/LMS activity es evidence input; no equivale automáticamente a attendance/pass/completion.                               |
| BR-EC00-071 | Assurance proporcional                                                                                     | Identity/proctoring assurance debe ser proporcional al riesgo de la credencial y definido por policy.                                |
| BR-EC00-072 | QR anti-replay                                                                                             | Check-in QR debe aplicar ventana/nonce/dedup y evidencia suficiente según threat model.                                              |
| BR-EC00-073 | Grabación no es default                                                                                    | Session recording requiere policy, purpose y base/consent refs cuando corresponda.                                                   |
| BR-EC00-074 | Licencias de contenido explícitas                                                                          | Todo recurso con restricciones de uso debe conservar license/right refs; presencia en LMS no implica derecho ilimitado.              |
| BR-EC00-075 | Retención gobernada                                                                                        | Cada clase de record EC declara retention class; historia oficial y privacy se reconcilian mediante policy.                          |
| BR-EC00-076 | Legal hold suspende purge selectivo                                                                        | Legal hold debe ser explícito, scoped y auditable.                                                                                   |
| BR-EC00-077 | Appeal no muta resultado                                                                                   | Un appeal produce una decisión; la corrección genera nuevo outcome/version/supersede.                                                |
| BR-EC00-078 | Corporate TNA no es currículo                                                                              | Necesidad del sponsor informa diseño; solo EC-01 puede formalizar ProgramVersion académica.                                          |
| BR-EC00-079 | Corporate reporting minimizado                                                                             | Outcome report B2B respeta purpose, aggregation y privacy; no expone detalle individual por conveniencia.                            |
| BR-EC00-080 | Retiro de programa preserva historia                                                                       | RETIRED impide nuevas editions pero no elimina ProgramVersion, credentials ni records históricos.                                    |

# 36. Golden Scenarios maestros

| **GS**      | **Escenario**                            | **Precondición**                              | **Acción**                               | **Resultado esperado**                                                                                 | **Evidencia**                          |
|-------------|------------------------------------------|-----------------------------------------------|------------------------------------------|--------------------------------------------------------------------------------------------------------|----------------------------------------|
| GS-EC00-001 | Publicación de programa                  | ProgramVersion APPROVED                       | Publicar                                 | PUBLISHED + evento + snapshot inmutable                                                                | audit + outbox                         |
| GS-EC00-002 | Intento de editar versión publicada      | ProgramVersion PUBLISHED                      | Modificar outcome                        | Rechazo; crear nueva versión                                                                           | ProblemDetail + audit                  |
| GS-EC00-003 | Apertura de edición                      | Version publicada + scope válido              | OPEN                                     | Edición abierta y consumible                                                                           | state + event                          |
| GS-EC00-004 | Edición fuera de semestralidad           | Fechas no ligadas a semestre                  | Programar                                | Permitido si CT-03/13 validan                                                                          | schedule receipt                       |
| GS-EC00-005 | Overselling concurrente                  | 1 cupo, 2 comandos simultáneos                | Confirmar enrollments                    | Solo uno obtiene cupo; otro waitlist/conflict                                                          | DB constraint/lock evidence            |
| GS-EC00-006 | Retry registration                       | Misma Idempotency-Key                         | Repetir submit                           | Mismo resultado, sin duplicado                                                                         | idempotency receipt                    |
| GS-EC00-007 | Payment unavailable                      | Finance 503                                   | Consultar inscripción                    | UI UNAVAILABLE, no “sin deuda”                                                                         | dependency trace                       |
| GS-EC00-008 | Financial timeout after commit           | Charge posiblemente creado                    | Timeout                                  | UNKNOWN_EFFECT + reconcile                                                                             | reconciliation receipt                 |
| GS-EC00-009 | Waitlist promotion                       | Se libera cupo                                | Promover siguiente                       | Oferta temporal según policy                                                                           | event + audit                          |
| GS-EC00-010 | Corporate batch duplicate                | Batch enviado dos veces                       | Aplicar                                  | Dedup por batch/items                                                                                  | receipts                               |
| GS-EC00-011 | Cross-tenant program access              | Usuario tenant A                              | Leer tenant B                            | 403/404 sin leakage                                                                                    | security test                          |
| GS-EC00-012 | Person duplicate candidate               | CT-04 devuelve posibles matches               | Formalizar                               | Resolution workflow; no crear copia automática                                                         | identity receipt                       |
| GS-EC00-013 | LMS unavailable                          | CT-18 caído                                   | Abrir instructor workspace               | PARTIAL/UNAVAILABLE; hechos locales visibles                                                           | UI evidence                            |
| GS-EC00-014 | LMS duplicate activity                   | Mismo external receipt                        | Consumir                                 | Una sola evidencia efectiva                                                                            | inbox dedup                            |
| GS-EC00-015 | Offline mobile attendance                | Sin conectividad                              | Registrar check-in                       | Queue local segura; sync posterior                                                                     | device + sync receipt                  |
| GS-EC00-016 | Offline duplicate sync                   | Mismo check-in reintentado                    | Sincronizar                              | Idempotente                                                                                            | receipt                                |
| GS-EC00-017 | Attendance correction                    | Registro VERIFIED                             | Corregir con razón                       | Nuevo historial/supersede                                                                              | before/after + reason                  |
| GS-EC00-018 | No attendance data                       | No existe evidencia                           | Calcular                                 | NO_DATA, no ABSENT salvo policy explícita                                                              | decision explanation                   |
| GS-EC00-019 | Completion without exam                  | Program policy participation-only             | Cerrar                                   | COMPLETED si cumple reglas                                                                             | policy snapshot                        |
| GS-EC00-020 | Completion with failed exam              | Assessment required                           | Cerrar                                   | NOT_COMPLETED/FAILED según policy                                                                      | outcome evidence                       |
| GS-EC00-021 | Pass but financial unknown               | PASS + Finance unavailable                    | Emitir credencial                        | No emitir si policy exige regularización                                                               | eligibility reason                     |
| GS-EC00-022 | Certificate idempotent issue             | Misma request                                 | Issue dos veces                          | Una emisión efectiva                                                                                   | idempotency record                     |
| GS-EC00-023 | Certificate supersede                    | Error detectado post-issue                    | Corregir                                 | Original preservado + nuevo award/artefacto                                                            | lineage                                |
| GS-EC00-024 | QR verification                          | Credential issued                             | Escanear QR                              | Validación sin exponer PII innecesaria                                                                 | verification response                  |
| GS-EC00-025 | Stacking satisfied                       | Tres microcredenciales válidas                | Evaluar pathway                          | SATISFIED; no degree automático                                                                        | pathway evidence                       |
| GS-EC00-026 | Expired credential in stack              | Una credencial vencida                        | Evaluar pathway                          | Aplicar policy version; posible NOT_SATISFIED                                                          | explanation                            |
| GS-EC00-027 | Corporate report privacy                 | Corporate viewer                              | Solicitar notas individuales sin permiso | Denied/masked                                                                                          | audit + purpose                        |
| GS-EC00-028 | Corporate aggregate report               | Agreement permite agregados                   | Ver completion                           | Datos agregados correctos                                                                              | report evidence                        |
| GS-EC00-029 | Promotion expired                        | Early bird vencido                            | Calcular price                           | No aplica; reason code                                                                                 | pricing snapshot                       |
| GS-EC00-030 | Promo code race                          | Código limitado                               | Dos consumos simultáneos                 | Constraint/policy evita excedente                                                                      | DB + audit                             |
| GS-EC00-031 | Refund/withdraw                          | Enrollment activo + financial effect          | Retirar                                  | EC registra academic withdrawal; Finance procesa efecto por contrato                                   | receipts                               |
| GS-EC00-032 | Instructor external                      | Person sin employment                         | Asignar como expert                      | Permitido según policy sin crear empleado                                                              | assignment evidence                    |
| GS-EC00-033 | Speaker tries grading                    | Speaker role                                  | Guardar evaluación                       | 403/422 por permisos/semántica                                                                         | security audit                         |
| GS-EC00-034 | AI unavailable                           | CT-12 503                                     | Crear programa                           | Workflow manual sigue disponible                                                                       | degraded evidence                      |
| GS-EC00-035 | AI hallucinated fact                     | Suggestion sin grounding suficiente           | Revisar                                  | No se aplica; reviewer rejects                                                                         | run/eval outcome                       |
| GS-EC00-036 | AI recommendation accepted               | Grounded suggestion                           | Reviewer acepta                          | Decision humana con run_ref                                                                            | audit + run ref                        |
| GS-EC00-037 | Concurrent program edit                  | Version 4 abierta en 2 browsers               | Guardar segundo                          | 412 VERSION_MISMATCH                                                                                   | ETag evidence                          |
| GS-EC00-038 | Stale offering data                      | Cache vieja                                   | Mostrar cupos                            | STALE visible; confirmación consulta SoT                                                               | UI + trace                             |
| GS-EC00-039 | Redis outage                             | Redis down                                    | Enrollment                               | Funciona con degradation; integridad intacta                                                           | resilience test                        |
| GS-EC00-040 | Mongo projection outage                  | Search view down                              | Abrir detalle                            | Fallback o PARTIAL                                                                                     | ops evidence                           |
| GS-EC00-041 | Outbox failure before commit             | DB transaction rollback                       | Publicar                                 | Ni estado ni evento confirmados                                                                        | transaction test                       |
| GS-EC00-042 | Message duplicate                        | Broker redelivery                             | Consumir                                 | Inbox evita side effect doble                                                                          | inbox record                           |
| GS-EC00-043 | Event schema old consumer                | Nueva versión compatible                      | Consumir                                 | Backward compatible o routed version                                                                   | contract test                          |
| GS-EC00-044 | Legacy program migration                 | Fuente histórica incompleta                   | Dry-run                                  | Quarantine/quality flags; no inventar facts                                                            | migration report                       |
| GS-EC00-045 | Legacy direct insert blocked             | Script intenta tabla final                    | Ejecutar                                 | Proceso rechazado por gobernanza/pipeline                                                              | migration gate                         |
| GS-EC00-046 | Mass certificate run                     | 10000 elegibles                               | Emitir                                   | Batch idempotente, rate-limited y observable                                                           | performance + receipts                 |
| GS-EC00-047 | Mass webinar check-in                    | Pico concurrente                              | Check-in                                 | SLO cumplido sin oversubscription                                                                      | load evidence                          |
| GS-EC00-048 | CT-07 outage                             | Notification service down                     | Complete course                          | Completion persiste; intent pendiente                                                                  | outbox/notification receipt            |
| GS-EC00-049 | Timezone edge                            | Usuario otro país                             | Mostrar sesión                           | UTC persistido, local correcto                                                                         | test evidence                          |
| GS-EC00-050 | DST external participant                 | Timezone con DST                              | Agenda                                   | Conversión correcta sin alterar UTC                                                                    | temporal test                          |
| GS-EC00-051 | UAT audit reconstruction                 | Decisión antigua                              | Auditor reconstruye                      | Versiones/policies/evidence/actors completos                                                           | Evidence Pack                          |
| GS-EC00-052 | Edition cancel por mínimo no alcanzado   | Edition OPEN, debajo de minimum viable cohort | Cancelar edición                         | History preserved; enrollments afectados; FinanceImpactIntent sin asumir refund                        | audit + receipts + notifications       |
| GS-EC00-053 | Reprogramación con participantes activos | Edition OPEN, schedule publicado              | Mover fechas                             | Nueva schedule version; old snapshot; consent/notification según policy                                | version diff + audit                   |
| GS-EC00-054 | Transferencia entre ediciones            | Enrollment ACTIVE, edición destino disponible | Transferir                               | Fuente TRANSFERRED; nuevo enrollment destino; no mutate edition_id                                     | 2 enrollments + idempotency receipt    |
| GS-EC00-055 | Sustitución corporate                    | Nominee original no asistirá                  | Sustituir participante                   | Original retirado; nueva nomination/enrollment; identity intact                                        | batch audit                            |
| GS-EC00-056 | Refund dependency timeout                | Withdrawal con efecto financiero              | Solicitar efecto                         | UNKNOWN_EFFECT; reconcile antes de retry                                                               | Finance receipt/reconcile              |
| GS-EC00-057 | Accommodation evaluación                 | Participante con accommodation autorizado     | Rendir evaluación                        | Ventana/tiempo ajustado sin revelar dato sensible al rol no autorizado                                 | policy + access audit                  |
| GS-EC00-058 | Credential Open Badge export             | Credential ISSUED                             | Exportar                                 | Metadata portable y verificable; artifact/ref separado                                                 | OB/VC validation evidence              |
| GS-EC00-059 | Credential revocation/void verification  | Credential vigente luego invalidada           | Verificar QR                             | Verifier obtiene current status sin exponer PII excesiva                                               | status proof + audit                   |
| GS-EC00-060 | LMS telemetry incompleta                 | LMS PARTIAL                                   | Calcular participation                   | No inferir completion; PARTIAL visible; reconcile                                                      | freshness + evidence quality           |
| GS-EC00-061 | QR replay                                | Mismo token presentado dos veces              | Check-in                                 | Segundo intento rechazado/dedup; evidencia preservada                                                  | anti-replay logs                       |
| GS-EC00-062 | Proctoring unavailable                   | Evaluación de assurance alto                  | Iniciar                                  | Aplicar contingency/policy; no marcar fail por outage                                                  | dependency incident + decision         |
| GS-EC00-063 | Recording without permission             | Session policy forbids recording              | Intentar grabar/publicar                 | Bloqueado; reason code; no artifact                                                                    | security/audit evidence                |
| GS-EC00-064 | Licensed content expired                 | Resource license vencida                      | Abrir curso                              | No publicar/reutilizar recurso; alert remediation                                                      | license validation evidence            |
| GS-EC00-065 | Retention purge                          | Operational record supera TTL                 | Purge job                                | Se elimina/anonymiza según class; official facts intact                                                | purge receipt                          |
| GS-EC00-066 | Legal hold                               | Case bajo investigación                       | Ejecutar purge                           | Records scoped retenidos; resto sigue política                                                         | hold audit                             |
| GS-EC00-067 | Assessment appeal accepted               | Outcome oficial disputado                     | Resolver appeal                          | Nuevo/corrected outcome; original preservado; downstream reconcile                                     | appeal decision + event                |
| GS-EC00-068 | Corporate TNA to proposal                | Sponsor define skill gap                      | Crear propuesta                          | TNA separado de ProgramVersion; refs trazables                                                         | TNA/proposal snapshots                 |
| GS-EC00-069 | Portfolio WATCH                          | Satisfacción y completion degradan            | Revisar programa                         | Corrective action; no auto-retire; owner/decision                                                      | quality evidence                       |
| GS-EC00-070 | Retire and relaunch                      | Programa RETIRED                              | Crear nueva propuesta                    | Nueva version/program successor; history/credentials siguen verificables                               | lineage + ADR                          |
| GS-EC00-071 | Normativa cambia durante el año          | Compliance Profile Vn vigente                 | Aprobar Vn+1 con effective_from          | Nuevas operaciones usan Vn+1; hechos previos reconstruyen Vn; no code deployment para threshold/policy | policy diff + approval + evidence refs |

# 37. UAT institucional maestro

| **UAT** | **Escenario**                             | **Criterio de aceptación**                                                                                                                                                      |
|---------|-------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| UAT-01  | Diseño y publicación de un curso corto    | ProgramVersion publicada sin alterar historia.                                                                                                                                  |
| UAT-02  | Edición intensiva de fin de semana        | Calendario y recursos válidos sin depender de semestre.                                                                                                                         |
| UAT-03  | Inscripción individual con cupo limitado  | Concurrency e idempotencia correctas.                                                                                                                                           |
| UAT-04  | Waitlist y promoción                      | Orden/policy/audit correctos.                                                                                                                                                   |
| UAT-05  | Programa virtual con LMS                  | Provision, roster, activity y degradación verificables.                                                                                                                         |
| UAT-06  | Programa híbrido                          | Evidencia unificada sin duplicación.                                                                                                                                            |
| UAT-07  | Programa corporativo                      | Empresa/batch/participantes separados y reporting protegido.                                                                                                                    |
| UAT-08  | Asistencia + evaluación + completion      | Separaciones semánticas correctas.                                                                                                                                              |
| UAT-09  | Certificado por participación             | Elegibilidad distinta de pass.                                                                                                                                                  |
| UAT-10  | Certificado por aprobación                | Policy snapshot y financial/evidence checks.                                                                                                                                    |
| UAT-11  | Microcredenciales acumulables             | Pathway satisfecho sin crear grado.                                                                                                                                             |
| UAT-12  | Timeout financiero                        | UNKNOWN_EFFECT y reconciliation.                                                                                                                                                |
| UAT-13  | Cross-tenant                              | Sin leakage de datos.                                                                                                                                                           |
| UAT-14  | Mobile offline attendance                 | Sync idempotente y auditable.                                                                                                                                                   |
| UAT-15  | IA asistiva                               | Recomendación trazable y decisión humana.                                                                                                                                       |
| UAT-16  | Migración legacy                          | Dry-run, receipts y reconciliación.                                                                                                                                             |
| UAT-17  | Auditoría histórica                       | Reconstrucción de programa→edición→participant→outcome→credential.                                                                                                              |
| UAT-18  | Programa masivo                           | Performance/SLO aceptables.                                                                                                                                                     |
| UAT-19  | Dependencia externa caída                 | UI muestra UNAVAILABLE/PARTIAL; no dato favorable falso.                                                                                                                        |
| UAT-20  | Void/supersede credential                 | Historia preservada y verificación correcta.                                                                                                                                    |
| UAT-21  | Cancelación/reprogramación de edición     | Historia preservada, notifications correctas, efectos financieros solo por contrato/receipt.                                                                                    |
| UAT-22  | Transferencia y sustitución corporate     | No se muta identidad ni enrollment fuente; destino idempotente y auditable.                                                                                                     |
| UAT-23  | Accessibility/accommodation               | WCAG 2.2 AA en journeys críticos y accommodation aplicado sin exposición indebida.                                                                                              |
| UAT-24  | Credencial interoperable                  | Export/verify OB3/CLR/VC cuando habilitado; status/void/supersede verificables.                                                                                                 |
| UAT-25  | QR anti-replay / assurance                | Duplicados/replay bloqueados; evidence y fallback correctos.                                                                                                                    |
| UAT-26  | Rights/recording                          | Recurso/licencia expirada o grabación no permitida se bloquea con reason/evidence.                                                                                              |
| UAT-27  | Retention/legal hold                      | Purge por policy y hold selectivo sin eliminar hechos oficiales.                                                                                                                |
| UAT-28  | Appeal + correction                       | Caso resuelto con nueva decisión y downstream reconciliation, sin overwrite.                                                                                                    |
| UAT-29  | Corporate TNA/reporting                   | TNA, sponsor outcome y report minimizado separados de currículo/ledger.                                                                                                         |
| UAT-30  | Portfolio retire/relaunch                 | RETIRED bloquea nuevas ediciones; relaunch crea lineage nuevo y mantiene credentials históricas.                                                                                |
| UAT-31  | Cambio de normativa/aplicabilidad Bolivia | Nueva policy entra por vigencia y scope sin reescribir decisiones históricas; PENDING_REVIEW bloquea solo operaciones configuradas como regulatorias sensibles y deja evidence. |

# 38. Gates G1-G10

| **Gate** | **Dimensión**                   | **Evidencia mínima**                                                                                                                                        |
|----------|---------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------|
| G1       | Arquitectura y bounded contexts | Source of Truth, boundaries EC/CT/Core, ADRs y Modulith verification. Compliance Profile y lifecycle de contingencias aprobados.                            |
| G2       | Datos / constraints             | DDL/Flyway por EC, tenant isolation, constraints, indexes, concurrency.                                                                                     |
| G3       | Backend                         | Use cases, domain tests, ports/adapters, ProblemDetail, idempotency.                                                                                        |
| G4       | API / Event contracts           | OpenAPI/AsyncAPI, schema compatibility, outbox/inbox, contract tests. Interoperability profiles (OB/CLR/VC/LTI) cuando aplique.                             |
| G5       | Frontend / Mobile               | Workspaces, states, accessibility, ETag UX, mobile boundaries/offline. Evidencia WCAG 2.2 AA y accommodations journey.                                      |
| G6       | Seguridad / auditoría           | RBAC/ABAC/SoD/step-up/privacy, Evidence Packs, tenant tests. Retention/legal-hold, identity assurance, recording/IP/privacy.                                |
| G7       | Integraciones / resiliencia     | Timeout, retry, circuit breaker, UNKNOWN_EFFECT, reconciliation.                                                                                            |
| G8       | QA / UAT                        | Golden Scenarios, E2E, performance, mobile, AI evals, UAT firmado. Appeals, cancellation/transfer/substitution y credential verification incluidos.         |
| G9       | Migración / operaciones         | CT-16 promotion, runbooks, SLO dashboards, rollback/continuity.                                                                                             |
| G10      | Release / certificación         | Artefactos Git alineados al Word, evidencias completas, GO institucional. External standards conformance decision registrada (adopt/not-adopt + rationale). |

> **REGLA DE CERTIFICACIÓN**
>
> Un NO-GO en G2, G4, G6 o G7, o una violación de integridad/tenant isolation, bloquea producción aunque el resto de Gates sea favorable.

# 39. Definition of Ready / Definition of Done

## 39.1 Definition of Ready para un EC-XX

- EC-00 V1.1 y CT contracts relevantes confirmados.

- Source of Truth y bounded context del módulo aprobados.

- Dependencias anteriores de EC con contratos mínimos disponibles.

- Lenguaje ubicuo, state machines y políticas críticas identificadas.

- Matriz de datos ownership y cross-context refs aprobada.

- Threat model inicial y matriz RBAC/ABAC/SoD preparada.

- OpenAPI/AsyncAPI skeleton definido.

- Golden datasets y escenarios de UAT representativos preparados.

- ADRs abiertas identificadas con owner y fecha de decisión.

## 39.2 Definition of Done para un EC-XX

- Código compila y suites pasan, pero además el módulo es reconstructible, auditable, observable, operable, secure, migratable, resilient y evolvable.

- Flyway reproducible desde cero y upgrade probado.

- Constraints impiden errores críticos aunque backend falle.

- OpenAPI/AsyncAPI compatibles y contract tests verdes.

- No PII indebida en logs, cache, traces ni proyecciones.

- ETag/idempotency/outbox/inbox/reconciliation probados donde aplican.

- Frontend distingue NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT.

- Mobile respeta límites de riesgo y offline/sync cuando aplique.

- G1-G10 con evidencia reproducible y UAT institucional aprobado.

- Engineering Pack completo en Git y Word actualizado.

# 40. Observabilidad, SLI/SLO y operación

Cada EC debe separar fallas técnicas de rechazos de negocio. Un 422 por policy no es incidente operacional; un timeout a Finance sí puede serlo. Logs estructurados, métricas y traces comparten correlationId y tenant context minimizado. Los dashboards deben permitir seguir un journey sin buscar manualmente entre servicios.

| **SLI/SLO**                    | **Baseline**                                                                            |
|--------------------------------|-----------------------------------------------------------------------------------------|
| Availability comandos críticos | ≥ 99.9% mensual objetivo inicial, sujeto al SLO global PeopleU y dependencias.          |
| p95 lectura operacional        | ≤ 500 ms para consultas transaccionales habituales sin dependencia externa lenta.       |
| p95 mutación simple            | ≤ 800 ms excluyendo procesos asíncronos o vendor latency.                               |
| Burst enrollment               | Dimensionar pruebas para pico institucional; no definir cifra fija sin capacity plan.   |
| Event delivery                 | 99.9% entregados dentro del budget acordado; backlog y DLQ alertables.                  |
| UnknownEffect age              | Alertar casos que excedan ventana de reconciliation por tipo de integración.            |
| Credential backlog             | Alertar eligible-not-issued por encima de threshold institucional.                      |
| LMS sync lag                   | Métrica por provider/capability; STALE visible cuando excede budget.                    |
| Error budget                   | Separado por endpoint/capability; business rejections no consumen error budget técnico. |

# 41. Engineering Pack maestro

ecXX/  
├── docs/  
├── architecture/  
├── adr/  
├── diagrams/  
├── contracts/  
│ ├── openapi/  
│ └── asyncapi/  
├── database/  
│ └── flyway/  
├── backend/  
├── frontend/  
├── mobile/  
├── tests/  
│ ├── unit/  
│ ├── integration/  
│ ├── contract/  
│ ├── security/  
│ ├── performance/  
│ └── e2e/  
├── golden/  
├── migration/  
├── observability/  
├── security/  
├── runbooks/  
├── evidence/  
├── certification/  
└── releases/

| **Ruta**            | **Contenido mínimo**                                           |
|---------------------|----------------------------------------------------------------|
| /docs               | README de módulo, glosario, decisiones, links al Word vigente. |
| /architecture       | DER, C4/context/module diagrams, dependency rules.             |
| /adr                | ADRs aprobadas/abiertas con status.                            |
| /contracts/openapi  | OpenAPI 3.1, examples, error schemas.                          |
| /contracts/asyncapi | Eventos versionados, examples, compatibility notes.            |
| /database/flyway    | DDL, indexes, constraints, migration tests.                    |
| /backend            | Módulo Spring Modulith con boundaries verificables.            |
| /frontend           | Feature/workspaces, clients, DTOs, tests.                      |
| /mobile             | Solo si aplica; journeys, sync/offline contracts.              |
| /tests              | Suites completas y data builders.                              |
| /golden             | Golden Scenarios automatizados o evidencia ejecutable.         |
| /migration          | Mappings, dry-run specs, reconciliation.                       |
| /observability      | Dashboards, alerts, SLI/SLO definitions.                       |
| /security           | Threat model, permission matrix, security test evidence.       |
| /runbooks           | Incidentes, reconciliation, rollback, dependency outage.       |
| /evidence           | Gate evidence y UAT artifacts.                                 |
| /certification      | G1-G10 checklist y sign-off.                                   |
| /releases           | Release notes, compatibility y rollback plan.                  |

# 42. ADRs y decisiones abiertas

| **ADR**    | **Tema**                                              | **Decisión / propuesta**                                                                                                                                              | **Estado**               |
|------------|-------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------|
| ADR-EC-001 | Source of Truth para organización empresarial externa | Propuesta: EC-09 posee la relación CorporateTrainingAccount, no un master universal de empresas. Si existe CRM/master externo, usar external_org_ref.                 | APROBADA BASELINE        |
| ADR-EC-002 | Semántica exacta Edition vs CT-03 cohort/session      | EC-02 posee ProgramEdition; CT-03 posee temporalidad/sessions. Contract refs y snapshots.                                                                             | APROBADA BASELINE        |
| ADR-EC-003 | Certificate business state vs artifact                | EC-08 posee eligibility/award/issuance; CT-05 posee artifact/document/hash.                                                                                           | APROBADA BASELINE        |
| ADR-EC-004 | Pricing vs Finance                                    | EC-03 posee PricingContext y commercial policy bindings; Finance posee ledger.                                                                                        | APROBADA BASELINE        |
| ADR-EC-005 | Credits in EC                                         | Soporte opcional por política; no asumir ECTS ni equivalencia PG/PO.                                                                                                  | APROBADA BASELINE        |
| ADR-EC-006 | Offering cardinality                                  | Permitir múltiples offerings por edition cuando canales/segmentos requieran; evitar overselling con capacidad central de EC-04/02.                                    | A VALIDAR EN EC-02       |
| ADR-EC-007 | Corporate reporting privacy                           | Dataset por acuerdo/purpose con minimización; detalle individual solo con base explícita.                                                                             | A VALIDAR EC-09          |
| ADR-EC-008 | Credential verification mechanism                     | QR/token/hash vía CT-05; implementación vendor-neutral.                                                                                                               | A VALIDAR EC-08          |
| ADR-EC-009 | Offline attendance cryptographic evidence             | Definir device trust/nonce/signing según threat model.                                                                                                                | A VALIDAR EC-06          |
| ADR-EC-010 | Cross-vertical recognition                            | No automático; eventual bridge PG/PO requiere contrato/ADR separado.                                                                                                  | DIFERIDO                 |
| ADR-EC-011 | Contingency lifecycle                                 | Cancel/reschedule/transfer/substitution se modelan como transiciones/commands con history, idempotency y FinanceImpactIntent.                                         | APROBADA V1.1            |
| ADR-EC-012 | Accessibility baseline                                | WCAG 2.2 AA para superficies digitales; accommodations de learning/assessment con privacy-by-design.                                                                  | APROBADA V1.1            |
| ADR-EC-013 | Credential interoperability                           | Open Badges 3.0 + CLR 2.0 + W3C VC 2.0 como perfiles preferentes vía CT-18/CT-05 cuando se habiliten.                                                                 | APROBADA V1.1            |
| ADR-EC-014 | Learning tool interoperability                        | Preferir LTI 1.3/Advantage; Caliper/xAPI/cmi5 como telemetry/evidence opcional, no como hecho académico.                                                              | APROBADA V1.1            |
| ADR-EC-015 | Identity assurance                                    | Assurance level por risk/policy; QR anti-replay y proctoring proporcional.                                                                                            | A VALIDAR EC-06/07/08    |
| ADR-EC-016 | Content rights and recordings                         | EC-05 conserva rights/license/recording bindings; CT-05 artifact, CT-10 privacy/consent.                                                                              | A VALIDAR EC-05          |
| ADR-EC-017 | Retention and legal hold                              | Record-class retention; selective legal hold; no indefinite-by-default.                                                                                               | A VALIDAR CT-10/EC-XX    |
| ADR-EC-018 | Appeals and corrections                               | Case workflow CT-06; EC produce decision semantics and corrected/superseding facts.                                                                                   | A VALIDAR EC-06/07/08/12 |
| ADR-EC-019 | Corporate TNA                                         | EC-09 owns TNA/sponsor outcome plan; EC-01 owns resulting academic ProgramVersion.                                                                                    | A VALIDAR EC-09          |
| ADR-EC-020 | Portfolio lifecycle                                   | EC-12 owns pilot/watch/suspend/retire/relaunch governance; no delete of program history.                                                                              | A VALIDAR EC-12          |
| ADR-EC-021 | Bolivia regulatory overlay                            | Compliance Profile referencia normativa oficial vigente; CT-02 gobierna policies, CT-05 evidencia/documentos y CT-10 auditoría. EC no hardcodea interpretación legal. | APROBADA V1.1            |

# 43. Runbooks maestros

| **Runbook** | **Incidente**                                     | **Pasos mínimos**                                                                                                                                                                                            |
|-------------|---------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| RB-EC-001   | Enrollment capacity contention                    | Detectar lock/conflicts, validar capacity, revisar idempotency, reconcile waitlist.                                                                                                                          |
| RB-EC-002   | Finance UNKNOWN_EFFECT                            | Congelar retry, query by idempotency/correlation, reconcile receipt, aplicar compensación si corresponde.                                                                                                    |
| RB-EC-003   | LMS roster mismatch                               | Comparar roster EC vs CT-18, clasificar missing/extra, corregir por adapter, registrar receipt.                                                                                                              |
| RB-EC-004   | Credential issuance backlog                       | Verificar eligibility queue, CT-05 availability, batch idempotency, rate limit y retries.                                                                                                                    |
| RB-EC-005   | Incorrect credential issued                       | Bloquear modificación, iniciar void/supersede, emitir reemplazo, actualizar verification endpoint.                                                                                                           |
| RB-EC-006   | Mass event traffic spike                          | Aplicar autoscaling/capacity controls, queue, rate limiting, dashboards y fallback de reads.                                                                                                                 |
| RB-EC-007   | Redis outage                                      | Activar fallback y reducir caché-dependencia; monitor DB load.                                                                                                                                               |
| RB-EC-008   | Mongo/read model outage                           | Servir transactional fallback o PARTIAL; reconstruir projection.                                                                                                                                             |
| RB-EC-009   | Cross-tenant incident                             | Bloquear acceso, preservar evidence, security incident process, audit scope, regression tests.                                                                                                               |
| RB-EC-010   | Migration partial failure                         | Detener promotion batch, usar per-item receipts, reconcile y reanudar idempotentemente.                                                                                                                      |
| RB-EC-011   | CT-07 outage                                      | Mantener notification intents en outbox; comunicar operational status sin revertir hechos.                                                                                                                   |
| RB-EC-012   | AI provider degradation                           | Desactivar capability/route alterno CT-12; continuar determinista; revisar eval drift.                                                                                                                       |
| RB-EC-013   | Edition cancellation / postponement               | Freeze new enrollments, snapshot state/schedule, classify impacted participants, emit intents/events, reconcile Finance, notify via CT-07, certify evidence pack.                                            |
| RB-EC-014   | Enrollment transfer/substitution mismatch         | Stop duplicate mutations, reconcile source/destination enrollment/batch, verify identity refs, replay idempotently, notify affected users.                                                                   |
| RB-EC-015   | Credential verification/status failure            | Check CT-05/18, issuer/status refs, proof adapter, stale cache; serve safe UNAVAILABLE rather than false VALID.                                                                                              |
| RB-EC-016   | Unauthorized recording/content use                | Disable access/publication, preserve evidence, validate rights/consent, initiate privacy/IP workflow and corrective action.                                                                                  |
| RB-EC-017   | Retention purge failure / legal hold conflict     | Stop purge batch, classify held records, verify retention policy, replay scoped purge, preserve receipts.                                                                                                    |
| RB-EC-018   | Appeal backlog or correction propagation          | Prioritize SLA, freeze destructive edits, process CT-06 cases, issue corrected/superseding facts, reconcile downstream credentials/analytics.                                                                |
| RB-EC-019   | Regulatory profile stale / applicability conflict | Freeze only affected regulated operation, verify official instrument and effective date, obtain owner/legal decision, publish new profile/policy version, reconcile impacted cases, preserve audit/evidence. |

# 44. Guía de desarrollo de EC-01…EC-12

## 44.1 Secuencia Backend obligatoria por módulo

1.  Declarar module-info / package boundary de Spring Modulith y tests de arquitectura.

2.  Congelar bounded context, Source of Truth, upstream/downstream y ADRs.

3.  Definir lenguaje ubicuo, Aggregate Roots, Entities, Value Objects y invariantes.

4.  Definir state machines y catálogo BR-ECXX.

5.  Definir input ports/use cases y command/query models.

6.  Definir outbound ports hacia CT/Core y contracts de degradación.

7.  Diseñar PostgreSQL tabla por tabla con tenant-aware PK/FK, constraints e índices.

8.  Crear Flyway reproducible y migration tests.

9.  Implementar repositories/adapters sin filtrar entidades JPA al dominio.

10. Implementar application services, optimistic locking y idempotency durable.

11. Implementar REST controllers + ProblemDetail + reason codes + ETag/If-Match.

12. Implementar outbox/inbox y schemas AsyncAPI.

13. Implementar reconciliation/UNKNOWN_EFFECT en integraciones con side effects.

14. Instrumentar audit, logs, metrics, traces y SLO.

15. Crear unit/domain/repository/integration/contract/security/concurrency/resilience tests.

16. Ejecutar Golden Scenarios y Gate evidence antes de liberar.

## 44.2 Secuencia Frontend obligatoria por módulo

17. Definir route structure y feature boundary por workspace.

18. Definir DTOs desde OpenAPI; no copiar tipos manualmente sin contrato.

19. Implementar API client con ProblemDetail, ETag y Idempotency-Key.

20. Definir query keys, freshness budgets e invalidation strategy.

21. Construir workspace shell con scope institucional y permisos.

22. Construir list/detail/forms orientados a tareas, no CRUD genérico.

23. Implementar mutation workflows con optimistic concurrency y conflict UX.

24. Distinguir loading/no-data/zero/stale/partial/unavailable/unknown-effect/error.

25. Implementar drawers/modals solo cuando reduzcan cambio de contexto y mantengan accesibilidad.

26. Aplicar field masking/purpose limitation desde contracts; no ocultar solo por CSS.

27. Implementar responsive behavior y keyboard/a11y WCAG según baseline institucional.

28. Añadir tests de componentes, integration mocks y E2E de Golden Scenarios.

29. Revisar observability del cliente y correlationId en errores operacionales.

## 44.3 Secuencia Mobile cuando aplique

30. Definir journey de valor y justificar por qué Mobile es superior a Web para ese caso.

31. Definir permisos mínimos y operaciones explícitamente prohibidas.

32. Definir cache/offline model y qué datos pueden persistirse localmente.

33. Definir sync protocol, idempotency, conflict resolution y device evidence.

34. Definir deep links/push y navegación segura.

35. Definir biometría/step-up solo donde aporte al assurance model.

36. Probar pérdida de red, duplicados, clock skew, stale data y logout remoto.

# 45. Checklist de certificación de la vertical

| **Dimensión**     | **Criterio de certificación**                                                                                |
|-------------------|--------------------------------------------------------------------------------------------------------------|
| Arquitectura      | EC-01…EC-12 respetan límites y no duplican CT/Core.                                                          |
| Semántica         | Program/Version/Edition/Offering y Participant/Person están separados.                                       |
| Corporate         | Empresa, acuerdo, batch y participantes permanecen separados.                                                |
| Finanzas          | No existen ledger/pagos/facturas autoritativos en EC.                                                        |
| Certificación     | Completion, pass, eligibility, issuance y artifact son distintos.                                            |
| Datos             | Todas las tablas EC tienen constraints defensivos y tenant isolation.                                        |
| Cross-context     | No existen FK físicas entre bounded contexts.                                                                |
| Concurrency       | Aggregates mutables críticos usan @Version/ETag o estrategia equivalente.                                    |
| Idempotency       | Comandos sensibles tienen key/receipt durable.                                                               |
| Events            | Outbox/inbox y schema versioning probados.                                                                   |
| Resilience        | UNKNOWN_EFFECT/reconciliation definidos para side effects remotos.                                           |
| Frontend          | Estados NO_DATA/ZERO/STALE/PARTIAL/UNAVAILABLE/UNKNOWN_EFFECT visibles.                                      |
| Mobile            | Solo journeys de valor y límites de riesgo.                                                                  |
| Security          | RBAC/ABAC/SoD/step-up/privacy/tenant tests con evidencia.                                                    |
| AI                | Toda IA via CT-12 y Recommendation ≠ Decision.                                                               |
| Migration         | CT-16, dry-run, lineage, receipts y no inserts directos.                                                     |
| QA                | Golden Scenarios, performance, security, resilience, mobile y AI evals según módulo.                         |
| Operations        | SLO, dashboards, alerts y runbooks implementados.                                                            |
| Artifacts         | Word, Git, OpenAPI, AsyncAPI, Flyway, ADRs y tests alineados.                                                |
| Gates             | G1-G10 aprobados con evidencia reproducible.                                                                 |
| Contingencias     | Cancellation/reschedule/transfer/substitution/withdrawal/refund-reference preservan historia e idempotencia. |
| Accessibility     | WCAG 2.2 AA + learning accommodations con privacy y evidence.                                                |
| Interoperabilidad | OB3/CLR2/VC2/LTI/learning telemetry decision explícita y adapters via CT-18.                                 |
| Trust             | Identity assurance, anti-replay/proctoring y credential status proporcionales al riesgo.                     |
| IP/Consent        | Content rights, recording policy y participant-generated content gobernados.                                 |
| Data Lifecycle    | Retention, anonymization/purge y legal hold definidos.                                                       |
| Appeals           | Correcciones por nueva decisión/version/supersede; no overwrite.                                             |
| Corporate TNA     | Need/sponsor outcomes separados de curriculum, contract y participant.                                       |
| Portfolio         | Pilot/watch/suspend/retire/relaunch gobernados con evidence y exit criteria.                                 |

> **CRITERIO FINAL**
>
> EC-00 V1.1 se considera listo para gobernar EC-01 cuando la secuencia EC-01…EC-12, sus fronteras, lifecycle de contingencias, estándares de trust/interoperabilidad, accesibilidad y decisiones maestras sean aceptadas como baseline oficial. A partir de ese momento, ningún módulo posterior puede redefinir silenciosamente estas responsabilidades; cualquier evolución debe documentarse mediante ADR y actualización controlada de EC-00.

# 46. Benchmark de excelencia y marco de cumplimiento adaptable

EC-00 V1.1 eleva la vertical desde una arquitectura robusta hacia un baseline comparable con prácticas internacionales de lifelong learning, learning services, digital credentials y accesibilidad. Estos estándares son referencias de diseño y calidad: no sustituyen normativa boliviana, resoluciones institucionales ni asesoría legal. Cada universidad deberá mantener un Compliance Profile versionado por tenant que indique qué requisitos son obligatorios, contractuales, internos o de benchmarking.

> **PRINCIPIO MAESTRO V1.1**
>
> La plataforma no hardcodea una universidad ni una norma. Modela obligaciones, políticas y evidencias de cumplimiento como contratos versionados. El hecho regulatorio aplicable debe poder cambiar por tenant, sede, tipo de programa, modalidad y periodo sin alterar la historia.

| **Referencia**                                           | **Uso en PeopleU IA EC**                                                                                                                                                                                                  | **Naturaleza**                                                   |
|----------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| ISO 21001:2025                                           | Gobierno educativo, learner-centered service, stakeholders, inclusión, mejora continua y evidencia de calidad.                                                                                                            | Benchmark de gestión educativa.                                  |
| ISO 29993:2017                                           | Diseño y prestación de learning services fuera de educación formal; learner + sponsor; información previa; evaluación del servicio.                                                                                       | Benchmark especialmente relevante a EC/in-company.               |
| ISO 29994:2021                                           | Requisitos de distance learning complementarios a 29993.                                                                                                                                                                  | Benchmark para virtual/asíncrono.                                |
| WCAG 2.2 AA                                              | Accesibilidad Web/Mobile/portales, autenticación accesible, foco, tamaño de targets y ayudas consistentes.                                                                                                                | Baseline técnico de UX.                                          |
| Open Badges 3.0 + CLR 2.0 + W3C VC 2.0                   | Portabilidad, interoperabilidad y verificación de credenciales/microcredenciales.                                                                                                                                         | Baseline de credenciales digitales.                              |
| LTI 1.3/Advantage + Caliper/xAPI/cmi5 cuando corresponda | Integración segura de tools y captura de evidencia/telemetría de aprendizaje.                                                                                                                                             | Baseline de interoperabilidad EdTech vía CT-18.                  |
| ISO/PAS 25171:2026                                       | Guía de auditoría de ISO 21001:2025; útil para convertir el Compliance Profile y los Gates en evidencia auditable cuando la institución adopte ese benchmark.                                                             | Benchmark de assurance/auditoría, no obligación automática.      |
| Bolivia — overlay regulatorio universitario              | El Compliance Profile debe referenciar los reglamentos y resoluciones vigentes aplicables a Universidades Privadas, tipo de oferta y certificación; la vigencia se valida institucionalmente antes de activar una policy. | Obligación jurisdiccional cuando corresponda; nunca hardcodeada. |

## 46.1 Compliance Profile por tenant

| **Campo conceptual**           | **Propósito**                                                                                                                                                            |
|--------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| compliance_profile_ref         | Identifica el conjunto versionado de obligaciones aplicables a la universidad/vertical.                                                                                  |
| jurisdiction_refs\[\]          | Normativa/autoridad aplicable; referencias externas, no lógica hardcodeada.                                                                                              |
| institutional_policy_refs\[\]  | Resoluciones, reglamentos y políticas internas aprobadas.                                                                                                                |
| program_type_scope             | Define a qué tipos de oferta EC aplica.                                                                                                                                  |
| evidence_requirements\[\]      | Qué evidencia debe conservarse y por cuánto tiempo.                                                                                                                      |
| effective_from / effective_to  | Vigencia temporal reconstruible.                                                                                                                                         |
| owner / approver               | Responsable funcional y autoridad aprobadora.                                                                                                                            |
| regulatory_instrument_refs\[\] | Identificadores/versiones de leyes, decretos, reglamentos, resoluciones y normas internas aplicables; documentos/evidencias se referencian por CT-05 cuando corresponda. |
| article_clause_refs\[\]        | Cláusulas o artículos concretos que justifican cada obligación/policy; evita interpretar un instrumento completo de forma opaca.                                         |
| applicability_decision         | APPLIES / DOES_NOT_APPLY / PENDING_REVIEW con owner, rationale y evidence_ref; PENDING_REVIEW bloquea operaciones regulatoriamente sensibles definidas por policy.       |
| verified_at / verified_by      | Fecha y responsable de la última verificación de vigencia/aplicabilidad; soporta auditoría y detección de normativa obsoleta.                                            |
| supersedes_ref                 | Lineage de la referencia normativa o policy reemplazada; nunca se reescribe la historia de decisiones pasadas.                                                           |

# 47. Lifecycle de cancelación, reprogramación, transferencia, sustitución y devolución referenciada

El mayor vacío operativo detectado en V1.0 era el tratamiento insuficiente de contingencias reales. Educación Continua es una operación de alta frecuencia: una edición puede no alcanzar el mínimo viable, un instructor puede quedar indisponible, una empresa puede sustituir participantes, un participante puede transferirse a otra edición y una reprogramación puede generar consecuencias financieras. Estos casos deben ser de primera clase y no resolverse con comentarios libres o UPDATE manual.

<img src="media/image4.png" title="Diagrama EC-00 4" style="width:7in;height:0.4777in" alt="Lifecycle operativo ampliado de Educación Continua con rutas de cancelación, reprogramación, transferencia y continuidad de aprendizaje." />

*Figura V1.1-A — Service lifecycle EC incluyendo rutas no felices.*

| **Evento/operación**            | **Owner semántico** | **Regla maestra**                                                                                         | **Efecto financiero**                                                |
|---------------------------------|---------------------|-----------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------|
| Edition cancellation            | EC-02               | CANCELLED es terminal para esa edición; conservar reason/evidence; no borrar offering/enrollments.        | EC solicita FinanceImpactIntent; Finanzas decide refund/credit/void. |
| Edition postponement/reschedule | EC-02 + CT-03/13    | Nueva agenda versionada; notificar impacto; preservar old schedule snapshot.                              | Puede originar ajuste/refund por contrato, nunca ledger EC.          |
| Participant withdrawal          | EC-04               | ACTIVE -\> WITHDRAWN con fecha/reason; no elimina attendance/outcomes previos.                            | Reference a Finance; no asume monto a devolver.                      |
| Enrollment transfer             | EC-04 + EC-02       | Cierra vínculo fuente como TRANSFERRED y crea nuevo vínculo destino idempotente; eligibility se reevalúa. | Puede implicar delta de precio en Finance.                           |
| Corporate substitution          | EC-09 + EC-04       | No mutar person_id del enrollment. Retirar/nominación original y crear nuevo participant/enrollment.      | Contrato corporativo determina efecto comercial.                     |
| Minimum viable cohort not met   | EC-02/03            | Gate GO/NO-GO previo a IN_PROGRESS; policy versionada.                                                    | Finance effect solo por contrato.                                    |

## 47.1 Reglas de no destrucción

- Una reprogramación nunca sobrescribe la agenda original sin dejar version/supersede y evidence refs.

- Una sustitución corporativa nunca cambia person_id en un enrollment existente.

- Un retiro nunca borra evidencias ya generadas; limita qué outcomes futuros pueden producirse.

- Una cancelación de edición no implica automáticamente refund total; el efecto financiero depende del contrato/policy del Core Financiero.

- Los reintentos de transfer/substitution/cancel deben ser idempotentes y producir receipts durables.

# 48. Accesibilidad, accommodations e inclusión

La accesibilidad no puede quedar reducida a una nota de frontend. En Educación Continua, la institución debe poder declarar necesidades de accesibilidad y accommodations razonables para la experiencia de aprendizaje, proteger su privacidad y demostrar qué ajustes fueron ofrecidos sin convertir información sensible en datos de libre circulación.

| **Dimensión**      | **Requisito EC-00 V1.1**                                                                                                              |
|--------------------|---------------------------------------------------------------------------------------------------------------------------------------|
| UX digital         | Objetivo WCAG 2.2 AA en Web y Mobile; excepciones documentadas con plan de remediación.                                               |
| Learning delivery  | EC-05 modela DeliveryAccommodationBinding/refs sin copiar diagnósticos; solo necesidad funcional mínima y purpose.                    |
| Materiales         | CT-05/18 deben exponer metadata de accesibilidad: captions, transcript, alt text, language, downloadable alternatives cuando aplique. |
| Sesiones síncronas | Posibilidad de intérprete, captions, recordings autorizadas y ajustes de interacción según policy.                                    |
| Evaluación         | EC-07 admite accommodations versionados: tiempo extra, formato alterno, attempt window; audit sin revelar más PII de la necesaria.    |
| Privacidad         | Información sensible se minimiza, enmascara y retiene según CT-10/compliance profile.                                                 |
| Corporate          | Sponsor recibe solo información necesaria para coordinar accommodation, no detalles sensibles del participante sin base autorizada.   |

> **REGLA DE DISEÑO**
>
> Accessibility ≠ special-case UI. Debe existir como requisito funcional, dato mínimo protegido, workflow y evidencia de cumplimiento en los módulos donde afecte delivery, assessment o credential eligibility.

# 49. Interoperabilidad educativa y credenciales digitales

Para que PeopleU IA no quede atado a un LMS, proveedor de badges o ecosistema cerrado, EC-00 V1.1 establece interoperability-first. CT-18 actúa como Anti-Corruption Layer hacia estándares/vendors; EC conserva semántica propia y referencias portables.

<img src="media/image5.png" title="Diagrama EC-00 5" style="width:5.9in;height:4.35678in" alt="Interoperabilidad de credenciales: EC-08, CT-05 y CT-18 con Open Badges 3.0, CLR 2.0 y W3C Verifiable Credentials 2.0 hacia wallets y verificadores." />

*Figura V1.1-B — Separación entre business state EC-08, artifact CT-05 e interoperabilidad CT-18.*

| **Estándar/capacidad** | **Adopción**                                                                   | **Regla**                                                                                        |
|------------------------|--------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| Open Badges 3.0        | Preferente para badges/microcredenciales portables.                            | EC-08 mapea Achievement, criteria, evidence, result/alignment; emisión técnica vía CT-18/CT-05.  |
| CLR 2.0                | Preferente para learner record longitudinal cuando la institución lo habilite. | EC-10 compone achievement refs; no crea un transcript de grado PG/PO.                            |
| W3C VC 2.0             | Base compatible para credenciales machine-verifiable.                          | Privacy-by-design, issuer identity, proof/status/revocation según adapter.                       |
| LTI 1.3 / Advantage    | Preferente para integración de learning tools.                                 | No tokens vendor-specific en dominio EC; seguridad/OAuth/OIDC resuelta por CT-18.                |
| Caliper / xAPI / cmi5  | Opcional para evidence/learning telemetry.                                     | La telemetría no se convierte automáticamente en attendance/pass; EC aplica policy y confidence. |

## 49.1 Credential Trust Envelope

| **Atributo**                          | **Regla mínima**                                                           |
|---------------------------------------|----------------------------------------------------------------------------|
| issuer_ref                            | Organización emisora verificada; tenant/institution scope.                 |
| achievement_ref/version               | Qué logro exacto fue alcanzado y bajo qué versión.                         |
| criteria/evidence refs                | Criterios y evidencia suficiente para explicar el award.                   |
| issued_at / valid_from / valid_until? | Fechas UTC; expiración solo cuando la política lo defina.                  |
| status/revocation_ref                 | Mecanismo verificable de current status; void/supersede no borra historia. |
| proof/verification_method_ref         | No hardcodear cryptosuite en EC; adapter CT-18/CT-05.                      |
| privacy disclosure                    | Datos mínimos del holder; evitar exponer PII innecesaria en QR público.    |

# 50. Identity assurance, anti-fraude, proctoring y trust

La confianza de una credencial depende de la confianza de identidad y de las evidencias que soportan attendance/assessment. EC-00 V1.1 introduce assurance levels contextuales: no todos los webinars necesitan la misma verificación que una certificación profesional de alto impacto.

| **Capability**         | **Baseline**                                                                                                               |
|------------------------|----------------------------------------------------------------------------------------------------------------------------|
| Identity assurance     | CT-04/IAM resuelven identidad/autenticación; EC guarda assurance_ref y policy snapshot cuando la decisión depende de ello. |
| QR/check-in anti-fraud | Nonce/window/session/device evidence; anti-replay; detección de duplicados; offline signing opcional según threat model.   |
| Remote assessment      | Proctoring solo vía CT-18 y bajo policy, proporcionalidad, consentimiento/base y privacy impact assessment.                |
| Credential issuance    | Step-up para bulk/void/supersede y para credenciales de assurance alto.                                                    |
| Anomaly detection      | CT-12 puede sugerir riesgo/fraude; no acusa ni invalida automáticamente. Human review + evidence.                          |
| Security incident      | CT-10/17 gobiernan respuesta; EC preserva evidence pack, affected refs y corrective action.                                |

# 51. Propiedad intelectual, licencias, grabaciones y consentimiento

Los contenidos de Educación Continua suelen involucrar expertos externos, materiales licenciados, grabaciones de sesiones y reutilización posterior. V1.0 no gobernaba de forma suficiente estos riesgos. EC-05 debe conservar bindings de derechos y restricciones, mientras CT-05 mantiene los archivos y CT-10 el marco de consentimiento/privacy.

| **Objeto**                    | **Debe registrar**                                                                                         | **No debe hacer**                                                  |
|-------------------------------|------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| LearningResourceBinding       | owner/licensor_ref, license_type/ref, permitted_uses, territory?, valid_from/to, attribution requirements. | No asumir que por estar en LMS puede reutilizarse indefinidamente. |
| SessionRecordingPolicy        | recording allowed?, audience, retention, download/share flags, consent/base refs.                          | No grabar/publicar por defecto.                                    |
| InstructorContentGrant        | rights scope, reuse, adaptation, branding, expiration, evidence_ref.                                       | No convertir contrato laboral/servicios en dominio EC.             |
| Participant-generated content | usage consent/base, moderation/evidence refs.                                                              | No reutilizar testimonios/trabajos fuera del propósito autorizado. |

# 52. Retención, archivo, legal hold y ciclo de vida de datos

Historia institucional no significa retener todo para siempre. PeopleU IA debe combinar record integrity con minimización y políticas de retención. CT-10/CT-05 gobiernan privacy/document retention; cada EC-XX debe clasificar sus records y declarar retención, anonimización/pseudonimización y legal hold cuando aplique.

| **Clase de record**    | **Ejemplos**                                   | **Tratamiento**                                                                           |
|------------------------|------------------------------------------------|-------------------------------------------------------------------------------------------|
| Official academic fact | completion, pass, credential award             | Retención según policy/institución; no delete destructivo; corrección por supersede/void. |
| Operational transient  | reservation, abandoned draft, cache            | TTL/cleanup gobernado; no conservar PII sin propósito.                                    |
| Evidence               | attendance proof, assessment evidence, consent | CT-05 + retention class + access/purpose.                                                 |
| Commercial snapshot    | pricing explanation, agreement refs            | Retener lo necesario para reconstrucción/audit sin duplicar ledger.                       |
| Telemetry/read model   | analytics events/projections                   | Rebuildable; aplicar minimización y periodos definidos.                                   |

- Legal hold suspende purge de records específicos sin convertir todos los datos del tenant en retención indefinida.

- Anonymization/pseudonymization debe preservar utilidad analítica cuando sea posible sin romper hechos oficiales que legalmente deban conservar identidad.

- Backups y replicas deben seguir la misma política de protección y expiry operativo de CT-17/infraestructura.

# 53. Appeals, complaints, excepciones y service recovery

Un sistema enterprise necesita rutas formales para cuestionar decisiones y reparar fallos. EC-07/08/12 deben modelar la semántica del caso y CT-06 ejecutar workflow/SLA/aprobaciones. Un appeal no modifica directamente la nota/completion/credential: produce una decisión que, si corresponde, activa una corrección versionada.

| **Caso**                      | **Owner de semántica** | **Workflow** | **Resultado permitido**                                                     |
|-------------------------------|------------------------|--------------|-----------------------------------------------------------------------------|
| Attendance correction request | EC-06                  | CT-06        | Confirm/reject/correct con evidence + reason.                               |
| Assessment appeal             | EC-07                  | CT-06        | Uphold/reassess/correct mediante nuevo outcome; nunca overwrite silencioso. |
| Credential dispute            | EC-08                  | CT-06        | Verify/void/supersede/reissue según policy.                                 |
| Service complaint             | EC-12                  | CT-06        | Corrective action, compensation reference, quality finding.                 |
| Corporate escalation          | EC-09                  | CT-06        | Resolution + sponsor communication + protected evidence.                    |

# 54. Corporate TNA, sponsor governance y outcome reporting

La formación in-company de alto nivel comienza antes de la inscripción. EC-09 debe poder capturar una Training Needs Assessment (TNA), objetivos del sponsor, población objetivo, baseline, restricciones operativas y outcomes esperados, sin confundir estos elementos con el currículo definitivo de EC-01 ni con el contrato financiero.

| **Aggregate/objeto conceptual** | **Contenido**                                                                                        | **Frontera**                                            |
|---------------------------------|------------------------------------------------------------------------------------------------------|---------------------------------------------------------|
| CorporateTrainingNeed           | problem statement, target population, capability gaps, sponsor outcomes, constraints, evidence refs. | No es diagnóstico de desempeño individual de empleados. |
| TrainingProposalSnapshot        | program/version refs, delivery assumptions, cohort size, schedule assumptions, reporting level.      | No sustituye contrato/quote financiero.                 |
| SponsorOutcomePlan              | KPIs agreed, measurement windows, privacy level, aggregation rules.                                  | No garantiza causalidad; reporta método y limitaciones. |
| CorporateParticipantNomination  | person/contact refs mínimos, eligibility status, nomination source.                                  | Empresa propone; EC/CT-15 valida reglas académicas.     |
| CorporateOutcomeReport          | aggregate progress, attendance/completion, agreed metrics, freshness/data-quality.                   | Individual detail solo si purpose/base lo permite.      |

# 55. Portfolio lifecycle, experimentación controlada y retiro de oferta

Educación Continua necesita innovación rápida, pero no experimentación sin control. EC-12 debe gobernar launch, pilot, scale, suspend, retire y relaunch de programas/ofertas usando evidencia de demanda, calidad, outcomes, capacidad operativa, riesgo y feedback. Un experimento no puede relajar reglas de seguridad, integridad académica o privacidad.

| **Estado portfolio** | **Criterio conceptual**                                               | **Acciones**                                                       |
|----------------------|-----------------------------------------------------------------------|--------------------------------------------------------------------|
| DRAFT / DISCOVERY    | Hipótesis de demanda y outcomes aún no aprobada.                      | Research, TNA, design; no public offering.                         |
| PILOT                | Oferta controlada con población/volumen acotado y criterios de éxito. | Medir; informar condición piloto cuando corresponda.               |
| ACTIVE / SCALE       | Evidencia suficiente, operaciones estables, quality gates verdes.     | Abrir múltiples editions/channels.                                 |
| WATCH                | KPIs o risk indicators degradados.                                    | Corrective action, tighter monitoring, no expansión automática.    |
| SUSPENDED            | Riesgo/quality/compliance significativo.                              | Bloquear nuevas ofertas; preservar participantes activos con plan. |
| RETIRED              | No se crean nuevas editions; historia permanece consultable.          | Migrar pathways/alternatives; no delete de ProgramVersion.         |
| RELAUNCHED           | Nueva versión o programa sucesor tras revisión.                       | Nueva baseline, no reactivar silenciosamente historia anterior.    |

## 55.1 Experimentation Guardrails

- A/B tests comerciales no cambian criterios académicos de elegibilidad, pass o credential.

- Experimentos con IA requieren eval plan, cohort isolation, human oversight y rollback.

- La métrica de éxito debe declararse antes del piloto y no redefinirse post hoc para justificar rollout.

- Todo pilot debe tener exit criteria: SCALE, ITERATE, STOP o SUSPEND.

# 56. Fuentes internas, estándares externos y baseline de continuidad

La elaboración de EC-00 se alinea con los documentos maestros y plantillas de PeopleU IA disponibles en el proyecto, particularmente el patrón de gobierno de artefactos, Source of Truth, arquitectura hexagonal, multitenancy, diseño físico defensivo, frontends por workspaces, resiliencia, QA y certificación ya consolidado en CT y Postgrado.

| **Fuente**                                                                                                  | **Uso**                                                                                                                                                                      |
|-------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| AM-00                                                                                                       | Arquitectura Maestra vigente de PeopleU IA.                                                                                                                                  |
| CT-00                                                                                                       | Documento Maestro de Módulos Transversales.                                                                                                                                  |
| CT-01…CT-18                                                                                                 | Contratos implementables transversales vigentes.                                                                                                                             |
| PG-00 / módulos PG                                                                                          | Referencia de contratos compartidos y fronteras; no plantilla funcional EC.                                                                                                  |
| PO-00 / PO-01…PO-12                                                                                         | Referencia de continuidad arquitectónica y plantilla formal documental.                                                                                                      |
| PO-05 corregido                                                                                             | Referencia visual/documental de profundidad y gobierno de artefactos.                                                                                                        |
| PO-06 V1.1                                                                                                  | Plantilla formal principal indicada por arquitectura para módulos EC implementables.                                                                                         |
| ISO 21001:2025                                                                                              | Benchmark de sistema de gestión para organizaciones educativas: enfoque learner-centered, inclusión, calidad y mejora continua.                                              |
| ISO 29993:2017                                                                                              | Benchmark específico para servicios de aprendizaje fuera de educación formal, incluyendo formación in-company y sponsors.                                                    |
| ISO 29994:2021                                                                                              | Benchmark complementario para servicios de aprendizaje a distancia.                                                                                                          |
| 1EdTech Open Badges 3.0                                                                                     | Interoperabilidad para badges/microcredenciales con metadatos verificables y portabilidad.                                                                                   |
| 1EdTech CLR 2.0                                                                                             | Registro longitudinal interoperable de logros y credenciales del learner.                                                                                                    |
| W3C Verifiable Credentials Data Model 2.0                                                                   | Modelo estándar para credenciales criptográficamente verificables y respetuosas de privacidad.                                                                               |
| 1EdTech LTI 1.3 / LTI Advantage                                                                             | Integración segura y vendor-neutral de herramientas educativas con LMS/plataformas.                                                                                          |
| 1EdTech Caliper Analytics 1.2 / xAPI-cmi5 cuando aplique                                                    | Telemetría semántica de experiencias de aprendizaje; siempre mediada por CT-18/CT-11.                                                                                        |
| W3C WCAG 2.2                                                                                                | Baseline de accesibilidad digital; objetivo PeopleU EC: nivel AA salvo excepción institucional documentada.                                                                  |
| ISO/PAS 25171:2026                                                                                          | Guía de auditoría de ISO 21001:2025; referencia para evidence-based assurance cuando la universidad adopte ese benchmark.                                                    |
| Ministerio de Educación de Bolivia — Reglamento General y Reglamentos Específicos de Universidades Privadas | Referencia oficial para construir el overlay regulatorio; la institución debe verificar versión, vigencia, modificaciones y aplicabilidad al momento de cada release/policy. |
| Ministerio de Educación de Bolivia — registro de documentos normativos vigentes                             | Fuente operativa para detectar resoluciones/reglamentos nuevos o sustituidos; no se interpreta automáticamente como policy sin revisión institucional.                       |

## 56.1 Control de cambios

| **Versión** | **Fecha**  | **Cambio**                                                                                                                                                                                                       | **Estado**     |
|-------------|------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------|
| V1.0        | 2026-09-08 | Creación del Documento Maestro EC-00, formalización de la secuencia EC-01…EC-12, fronteras, reglas maestras, contratos, Golden Scenarios y Gates.                                                                | **SUPERSEDED** |
| V1.1        | 2026-09-08 | Revisión quirúrgica enterprise: contingencias, accesibilidad, credenciales/EdTech, trust, IP/consent, retención, appeals, TNA, portfolio y overlay regulatorio Bolivia; BR/GS/UAT/Gates/ADR/runbooks reforzados. | **VIGENTE**    |

## 56.2 Decisión de congelamiento y gobierno de evolución

**EC-00 V1.1 queda establecido como baseline oficial de la vertical de Educación Continua / Formación Continua.** Su función es gobernar EC-01…EC-12, no convertirse en un módulo ejecutable independiente.

| **Regla de congelamiento**     | **Criterio**                                                                                                                                                                               |
|--------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Baseline                       | V1.1 sustituye V1.0. EC-01 y posteriores deben citar esta versión o una posterior aprobada.                                                                                                |
| No reinterpretación silenciosa | Un EC-XX no puede redefinir ownership, estados maestros, semántica, policy boundaries o contratos transversales sin ADR e impacto documentado.                                             |
| Regulación                     | La inclusión de una referencia oficial no equivale por sí sola a decisión legal: owner/compliance debe validar vigencia, aplicabilidad, scope y effective date antes de activar la policy. |
| Evolución                      | Todo cambio material de EC-00 exige ADR, matriz de impacto EC/CT/Core, compatibilidad/migración cuando aplique y re-evidencia de Gates afectados.                                          |
