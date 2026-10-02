@echo off
setlocal

set "MAVEN_PROJECTBASEDIR=%~dp0"

@REM Una copia SIN la barra final. `%~dp0` termina en \, y una ruta que termina en \ justo antes
@REM de la comilla de cierre la escapa: el argumento no cierra nunca y java termina tomando una
@REM palabra suelta del path como clase principal. Con "Proyecto Colegio Aleman" eso da
@REM "Could not find or load main class Colegio". Las otras rutas de abajo si necesitan la barra.
set "MAVEN_BASEDIR_ARG=%MAVEN_PROJECTBASEDIR%"
if "%MAVEN_BASEDIR_ARG:~-1%"=="\" set "MAVEN_BASEDIR_ARG=%MAVEN_BASEDIR_ARG:~0,-1%"
set "MAVEN_WRAPPER_JAR=%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.jar"
set "MAVEN_WRAPPER_PROPERTIES=%MAVEN_PROJECTBASEDIR%.mvn\wrapper\maven-wrapper.properties"

if exist "%MAVEN_WRAPPER_JAR%" goto run

for /f "tokens=1,* delims==" %%A in ('findstr /b "wrapperUrl=" "%MAVEN_WRAPPER_PROPERTIES%"') do set "WRAPPER_URL=%%B"
if "%WRAPPER_URL%"=="" (
  echo Maven Wrapper URL is not configured in %MAVEN_WRAPPER_PROPERTIES%
  exit /b 1
)

echo Downloading Maven Wrapper...
powershell -NoProfile -ExecutionPolicy Bypass -Command "[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; New-Item -ItemType Directory -Force -Path '%MAVEN_PROJECTBASEDIR%.mvn\wrapper' | Out-Null; Invoke-WebRequest -UseBasicParsing -Uri '%WRAPPER_URL%' -OutFile '%MAVEN_WRAPPER_JAR%'"
if errorlevel 1 (
  echo Could not download Maven Wrapper from %WRAPPER_URL%
  exit /b 1
)

:run
if not exist "%JAVA_HOME%\bin\java.exe" (
  echo Error: JAVA_HOME must point to a valid JDK 21 installation.
  exit /b 1
)
"%JAVA_HOME%\bin\java.exe" "-Dmaven.multiModuleProjectDirectory=%MAVEN_BASEDIR_ARG%" -classpath "%MAVEN_WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*
exit /b %ERRORLEVEL%
