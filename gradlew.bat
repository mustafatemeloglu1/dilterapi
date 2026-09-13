@echo off
setlocal
set GRADLE_VERSION=8.10.2
set CACHE_DIR=%USERPROFILE%\.gradle\dists\dil-terapi-gradle-%GRADLE_VERSION%
set GRADLE_BIN=%CACHE_DIR%\gradle-%GRADLE_VERSION%\bin\gradle.bat
if not exist "%GRADLE_BIN%" (
  echo Downloading Gradle %GRADLE_VERSION%...
  if not exist "%CACHE_DIR%" mkdir "%CACHE_DIR%"
  powershell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest -Uri 'https://services.gradle.org/distributions/gradle-%GRADLE_VERSION%-bin.zip' -OutFile '%CACHE_DIR%\gradle.zip'; Expand-Archive -Force '%CACHE_DIR%\gradle.zip' '%CACHE_DIR%'; Remove-Item '%CACHE_DIR%\gradle.zip'"
)
call "%GRADLE_BIN%" %*
endlocal
