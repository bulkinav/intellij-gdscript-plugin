# GDScript plugin for IntelliJ IDEA [![Build Plugin](https://github.com/exigow/intellij-gdscript/workflows/Build%20Plugin/badge.svg)](https://github.com/exigow/intellij-gdscript/actions?query=workflow%3A%22Build+Plugin%22) [![Download](https://img.shields.io/jetbrains/plugin/d/13107-gdscript.svg)](https://plugins.jetbrains.com/plugin/13107-gdscript)

![Screenshot](https://i.imgur.com/WLLXkf4.png)

Works with all IntelliJ-based IDEs. List of available features is [here](src/main/resources/META-INF/plugin.xml).

This fork is based on [Jakub Błach's original project](https://github.com/exigow/intellij-gdscript). The original MIT license and copyright notice are preserved in [`license`](license).

Requires IntelliJ Platform 2026.2 or newer; WebStorm 2026.2 and 2026.3 are covered by Plugin Verifier.

## Usage & Development

* `./gradlew runIde` - run WebStorm 2026.2 sandbox with installed plugin
* `./gradlew test` - run plugin tests
* `./gradlew verifyPlugin` - check compatibility with WebStorm 2026.2 and 2026.3
* `./gradlew buildPlugin` - build plugin distribution under `build/distributions/`
* `./gradlew publishPlugin` - publish plugin to official JetBrains repository
* `./update-api.sh 3.2 3.3 3.4 3.5 4.0 4.1 4.2.2-stable 4.3-stable 4.4.1-stable 4.5.2-stable 4.6.3-stable 4.7.2-stable` - refresh API catalogs from Godot tags over HTTPS

The build uses Gradle 9.1 and Java 25 toolchains; Java 25 is downloaded automatically when no local toolchain is installed.

### How to update grammars

* For GDScript, edit `grammar/ScriptParser.bnf` or `grammar/_ScriptLexer.flex`, then run `./gradlew generateParser generateLexer`
* Generated sources are written to `gen/`; do not edit them directly

### How to install plugin manually

1. Build plugin from sources, download [latest stable version](https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions) or any [GitHub Actions artifact](https://github.com/exigow/intellij-gdscript/actions)
2. Navigate to: *Settings* | *Plugins* | :gear: | *Install plugin from disk...*

### How to fix `Mixed tabs and spaces in indentation` error

To prevent mixing tabs (Godot defaults) with 4-space indents (IDE defaults), add `.editorconfig` file to your project directory:

```editorconfig
[*.gd]
indent_style = tab
```
