# Agent notes

- This is one Gradle IntelliJ plugin project; use the checked-in wrapper (`./gradlew`, Gradle 9.1) and Java 25 toolchain.
- Main implementation is `src/main/kotlin`; plugin registrations and metadata are in `src/main/resources/META-INF/plugin.xml`.
- GDScript lexer/parser definitions are in `grammar/ScriptParser.bnf` and `grammar/_ScriptLexer.flex`; generated sources are in `gen/` and included in the main source set. Regenerate them with `./gradlew generateParser generateLexer` rather than editing generated files directly.
- The build targets WebStorm 2026.2; plugin compatibility starts at build 262 and is verified against WebStorm 2026.2 and 2026.3.
- jsoup is `compileOnly`: WebStorm supplies it, and packaging another jsoup version breaks the IDE's HTML renderer through classloader conflicts.
- Run all tests with `./gradlew test`; focus on one class with `./gradlew test --tests 'gdscript.parser.ScriptParserTest'`.
- `BaseTest` supplies an explicit name to `createLightFixtureBuilder`; the current fixture API has no no-argument overload.
- `./gradlew buildPlugin` creates the distribution under `build/distributions/`; `./gradlew runIde` launches the WebStorm sandbox.
- API completion data is packaged under `src/main/resources/version/`. `./update-api.sh <Godot-tag-or-version>...` fetches XML from Godot over HTTPS and atomically replaces only the requested catalog ZIPs; it leaves `.versions/` untouched.
- Publishing uses `./gradlew publishPlugin` and requires `publishPluginToken` in the local `gradle.properties` (that file is git-ignored; never commit the token).
