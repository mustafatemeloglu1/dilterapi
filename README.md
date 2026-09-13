# DilTerapi Android

Görsel dil ve konuşma terapisi uygulaması için Android prototipi.

## GitHub Actions

1. Bu klasörün tamamını GitHub repository'sinin köküne yükleyin.
2. `.github/workflows/build-apk.yml` otomatik olarak çalışır.
3. GitHub > Actions > **Build DilTerapi APK** > ilgili çalıştırma > **Artifacts** > `DilTerapi-APK`.

Workflow JDK 17 ve Gradle 8.10.2 kullanır. `gradlew` scripti, GitHub runner üzerinde Gradle'ı gerektiğinde indirip çalıştırır.
