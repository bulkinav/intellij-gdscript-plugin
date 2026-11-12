# Agent notes

- This is one Gradle IntelliJ plugin project; use the checked-in wrapper (`./gradlew`, Gradle 9.1) and Java 25 toolchain.
- Main implementation is `src/main/kotlin`; plugin registrations and metadata are in `src/main/resources/META-INF/plugin.xml`.
- Lexer/parser definitions are in `grammar/`; generated sources are in `gen/` and included in the main source set. Change the grammar and regenerate with Grammar-Kit’s **Generate Parser Code** (`.bnf`) or **Run JFlex Generator** (`.flex`) actions rather than editing generated files directly.
- The build targets WebStorm 2026.2; plugin compatibility starts at build 262 and is verified against WebStorm 2026.2 and 2026.3.
- jsoup is `compileOnly`: WebStorm supplies it, and packaging another jsoup version breaks the IDE's HTML renderer through classloader conflicts.
- Run all tests with `./gradlew test`; focus on one class with `./gradlew test --tests 'gdscript.parser.ScriptParserTest'`.
- `BaseTest` supplies an explicit name to `createLightFixtureBuilder`; the current fixture API has no no-argument overload.
- `./gradlew buildPlugin` creates the distribution under `build/distributions/`; `./gradlew runIde` launches the WebStorm sandbox.
- API completion data is packaged under `src/main/resources/version/`. `./update-api.sh <Godot-version>...` fetches matching Godot tags via SSH and rewrites the corresponding ZIPs; it first deletes the local `.versions/` checkout directory.
- Publishing uses `./gradlew publishPlugin` and requires `publishPluginToken` in the local `gradle.properties` (that file is git-ignored; never commit the token).
