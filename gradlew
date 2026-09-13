#!/usr/bin/env sh
set -eu
GRADLE_VERSION=8.10.2
ROOT_DIR="$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)"
CACHE_DIR="${GRADLE_USER_HOME:-$HOME/.gradle}/dists/dil-terapi-gradle-${GRADLE_VERSION}"
GRADLE_BIN="$CACHE_DIR/gradle-${GRADLE_VERSION}/bin/gradle"
if [ ! -x "$GRADLE_BIN" ]; then
  mkdir -p "$CACHE_DIR"
  TMP="$CACHE_DIR/gradle.zip"
  echo "Downloading Gradle ${GRADLE_VERSION}..."
  curl -fsSL -o "$TMP" "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip"
  unzip -q -o "$TMP" -d "$CACHE_DIR"
  rm -f "$TMP"
fi
exec "$GRADLE_BIN" "$@"
