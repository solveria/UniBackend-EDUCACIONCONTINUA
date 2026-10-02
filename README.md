# PeopleU Continuing Education Service

La vertical de educacion continua: ediciones sin periodo semestral, canal comercial con precios y becas, B2B in-company, credenciales verificables y rutas apilables.

Servicio backend de PeopleU IA (universidades). Educacion Continua de PeopleU (EC-01..EC-12): portafolio y microcredenciales, ediciones y cohortes, precios y becas, inscripcion con lista de espera, docentes, asistencia, evaluacion y completion, credenciales verificables, formacion corporativa, trayectoria apilable, feedback e impacto, calidad del portafolio.

Documentacion principal:

- [Documentacion del servicio](docs/README.md)
- [Arquitectura](docs/arquitectura/arquitectura-peopleu-continuing-education-service.md)
- [Estructura](docs/estructura/estructura-peopleu-continuing-education-service.md)
- [Ejecucion](docs/ejecucion/guia-ejecucion-peopleu-continuing-education-service.md)

Ejecucion rapida:

```powershell
docker compose up -d peopleu-continuing-education-postgres
.\mvnw.cmd spring-boot:run
```

URLs:

- Servicio: `http://localhost:8104`
- Swagger: `http://localhost:8104/swagger-ui/index.html` (con `SPRINGDOC_ENABLED=true`)
- Health: `http://localhost:8104/actuator/health`
