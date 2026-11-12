# Feature request roadmap

Prioritized review of open feature requests in [exigow/intellij-gdscript issues](https://github.com/exigow/intellij-gdscript/issues), checked on 2026-11-12. Bugs and questions are excluded. Ranking reflects expected user impact and breadth, not implementation effort; the order is a backlog, not a commitment.

## Prioritized backlog

1. [Godot Language Server Protocol integration (#43)](https://github.com/exigow/intellij-gdscript/issues/43) **— XL (>4 weeks).** Use the running Godot editor's language server for engine-aware completion, navigation, and documentation. Broad integration: protocol client/lifecycle, capability mapping, and coexistence with the plugin's current catalogs.
2. [GDScript code formatting (#80)](https://github.com/exigow/intellij-gdscript/issues/80) **— L (2–4 weeks).** Add IntelliJ formatting support for Reformat Code and, if desired, typing-time formatting. Needs a formatter model, GDScript indentation rules, and tests for nested syntax.
3. [Static methods on API classes (#146)](https://github.com/exigow/intellij-gdscript/issues/146) **— M (4–8 days); done.** API method qualifiers now retain `static`, and completion offers those methods on non-singleton classes while preserving singleton completion; `DirAccess.open()` is covered by a regression test.
4. [Lambda expressions with `return` (#149)](https://github.com/exigow/intellij-gdscript/issues/149) **— S (1–3 days); done.** Lambda bodies now accept `return` with or without an expression; regression test added and `ScriptErrorHighlightingTest` passes.
5. [Embedded GDScript in scenes (#40)](https://github.com/exigow/intellij-gdscript/issues/40) **— L (2–4 weeks).** Inject GDScript editing support into `script/source` text embedded in `.tscn` files. Escaping, edits back into the scene string, and correct PSI ranges make this more involved than highlighting alone.
6. [`.gdshader` support (#91)](https://github.com/exigow/intellij-gdscript/issues/91) **— M (4–8 days) for initial highlighting/parsing.** Register shader files and add a shader lexer/parser and tests. Completion and deeper shader-language tooling would be additional scope.
7. [Improve Godot API quick documentation (#92)](https://github.com/exigow/intellij-gdscript/issues/92) **— M (4–8 days).** Render the Godot API's BBCode descriptions as readable HTML in IntelliJ quick documentation; requires handling Godot markup and safe links.
8. [Attach debugger (#77)](https://github.com/exigow/intellij-gdscript/issues/77) **— XL (>4 weeks).** Enable a usable debugger workflow for Godot projects; clarify whether this means launching under the debugger, attaching to a running process, or both. Requires protocol/process integration and IDE debugger support.
9. [Runtime scene tree and debugging (#132)](https://github.com/exigow/intellij-gdscript/issues/132) **— XL (>4 weeks).** Show the running game's scene tree and connect it to runtime debugging. This is valuable, but broad and likely depends on debugger integration (#77).

### Estimate scale

Rough engineering effort, including focused tests: **S** = 1–3 days, **M** = 4–8 days, **L** = 2–4 weeks, **XL** = more than 4 weeks. Estimates assume one developer familiar with the project; discovery, Godot-version differences, and external protocol/tooling issues may increase them. XL means the work needs a design spike and should be split before implementation.

## Scope notes

- The ranking is based on user impact: broad language-service improvements first, then common editing/completion gaps, followed by specialized project and runtime workflows.
- Issues #77 and #132 overlap but are not identical: debugger connectivity is a prerequisite for, or companion to, runtime scene-tree inspection.
- This is an upstream-derived backlog, not a claim that each request has been revalidated against every recent Godot release. Recheck issue status and current Godot/IntelliJ APIs before implementation.
- Estimates are preliminary: current code has no LSP/debugger/formatter infrastructure; API method metadata currently does not retain static qualifiers, and scene strings need special care for language injection.
