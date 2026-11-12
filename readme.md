# GDScript plugin for IntelliJ IDEA [![Build Plugin](https://github.com/exigow/intellij-gdscript/workflows/Build%20Plugin/badge.svg)](https://github.com/exigow/intellij-gdscript/actions?query=workflow%3A%22Build+Plugin%22) [![Download](https://img.shields.io/jetbrains/plugin/d/13107-gdscript.svg)](https://plugins.jetbrains.com/plugin/13107-gdscript)

![Screenshot](https://i.imgur.com/WLLXkf4.png)

Works with all IntelliJ-based IDEs. List of available features is [here](src/main/resources/META-INF/plugin.xml).

Requires IntelliJ Platform 2026.2 or newer; WebStorm 2026.2 and 2026.3 are covered by Plugin Verifier.

## Usage & Development

* `./gradlew runIde` - run WebStorm 2026.2 sandbox with installed plugin
* `./gradlew test` - run plugin tests
* `./gradlew verifyPlugin` - check compatibility with WebStorm 2026.2 and 2026.3
* `./gradlew buildPlugin` - build plugin distribution under `build/distributions/`
* `./gradlew publishPlugin` - publish plugin to official JetBrains repository
* `./update-api.sh 3.2 3.3 3.4 3.5 4.0 4.1` - update completion data for listed versions (requires GitHub SSH access)

The build uses Gradle 9.1 and Java 25 toolchains; Java 25 is downloaded automatically when no local toolchain is installed.

### How to update grammars with Grammar-Kit plugin

* To update parser use *Generate Parser Code* option on `.bnf` file
* To update lexer use *Run JFlex Generator* option on `.flex` file

### How to install plugin manually

1. Build plugin from sources, download [latest stable version](https://plugins.jetbrains.com/plugin/13107-godot-gdscript/versions) or any [GitHub Actions artifact](https://github.com/exigow/intellij-gdscript/actions)
2. Navigate to: *Settings* | *Plugins* | :gear: | *Install plugin from disk...*

### How to fix `Mixed tabs and spaces in indentation` error

To prevent mixing tabs (Godot defaults) with 4-space indents (IDE defaults), add `.editorconfig` file to your project directory:

```editorconfig
[*.gd]
indent_style = tab
```
