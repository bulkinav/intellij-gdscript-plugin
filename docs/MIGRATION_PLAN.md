# IntelliJ Platform modernization

Goal: build and verify the plugin for WebStorm 2026.3 while keeping the build reproducible and limiting code changes to real compatibility or architecture problems.

- [x] Read the official [Plugin Quick Start](https://plugins.jetbrains.com/docs/intellij/plugins-quick-start.html), Gradle migration guide, and current platform compatibility requirements.
- [x] Move the legacy Gradle IntelliJ Plugin 1.x build to IntelliJ Platform Gradle Plugin 2.x; target WebStorm 2026.2 (minimum supported branch for compatibility with 2026.3), update Java/Gradle/Kotlin, and keep publishing credentials optional until publish is requested. Gradle configuration, compilation, and the full test suite pass.
- [x] Modernize CI to build, run tests, and verify the packaged plugin against WebStorm 2026.2 and 2026.3. The workflow is updated; the equivalent local build, tests, structure check, and Plugin Verifier all succeeded.
- [x] Fix compile, test, descriptor, and Plugin Verifier issues found during migration; preserve existing user features and serialized settings. The final combined build/test/structure/Plugin Verifier run passed with no deprecated API usages. The source descriptor now also states the actual minimum build (262).
- [x] Review the service/data flow for concrete architectural defects and make only focused improvements; document the resulting developer commands and support range. Generated API PSI is now cached per engine version, with class/constant name sets computed once per version.
