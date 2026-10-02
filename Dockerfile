FROM maven:3.9.9-eclipse-temurin-21 AS builder
WORKDIR /workspace

# El contexto de build es la carpeta que contiene a los servicios (PeopleUBackend): core-plataform
# tiene que estar clonado al lado de este servicio. Se instala en el repositorio Maven de la imagen y
# despues se empaqueta el servicio contra el.
COPY core-plataform core-plataform
COPY peopleu-continuing-education-service peopleu-continuing-education-service

RUN mvn -q -f core-plataform/pom.xml -DskipTests -Dspotless.check.skip=true install
RUN mvn -q -f peopleu-continuing-education-service/pom.xml -DskipTests -Dspotless.check.skip=true clean package

FROM eclipse-temurin:21-jre
WORKDIR /opt/peopleu-continuing-education-service

COPY --from=builder /workspace/peopleu-continuing-education-service/target/peopleu-continuing-education-service-*.jar app.jar

EXPOSE 8104

ENTRYPOINT ["java", "-jar", "/opt/peopleu-continuing-education-service/app.jar"]
