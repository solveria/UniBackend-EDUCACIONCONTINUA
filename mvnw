#!/bin/sh

set -eu

MAVEN_PROJECTBASEDIR="$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)"
MAVEN_WRAPPER_JAR="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.jar"
MAVEN_WRAPPER_PROPERTIES="$MAVEN_PROJECTBASEDIR/.mvn/wrapper/maven-wrapper.properties"

if [ ! -f "$MAVEN_WRAPPER_JAR" ]; then
  WRAPPER_URL=$(sed -n 's/^wrapperUrl=//p' "$MAVEN_WRAPPER_PROPERTIES")
  if [ -z "$WRAPPER_URL" ]; then
    echo "Maven Wrapper URL is not configured in $MAVEN_WRAPPER_PROPERTIES" >&2
    exit 1
  fi

  mkdir -p "$(dirname "$MAVEN_WRAPPER_JAR")"
  if command -v curl >/dev/null 2>&1; then
    curl -fsSL "$WRAPPER_URL" -o "$MAVEN_WRAPPER_JAR"
  else
    wget -q "$WRAPPER_URL" -O "$MAVEN_WRAPPER_JAR"
  fi
fi

exec java -Dmaven.multiModuleProjectDirectory="$MAVEN_PROJECTBASEDIR" \
  -classpath "$MAVEN_WRAPPER_JAR" org.apache.maven.wrapper.MavenWrapperMain "$@"
