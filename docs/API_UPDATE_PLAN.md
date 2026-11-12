# Godot / GDScript data modernization

Status: implementation complete. Research checked against official Godot release notes and documentation on 2026-11-12.

## Findings

- At the start of this work, the bundled API catalogs covered Godot 3.2–3.5 and 4.0–4.1 only. The list and default API version are hard-coded in `VersionService`; the Settings dropdown uses that list.
- At the start of this work, `update-api.sh` cloned Godot over SSH and deleted `.versions/` before doing any work. It packages class-reference XML and `@GDScript.xml` into versioned ZIPs.
- Godot 4.7.2 is the latest stable release. Godot 4.8 beta 3 is pre-release and must not become the default stable catalog.
- Godot 4.6/4.7 add and change API symbols consumed by completion and documentation. Examples include `AreaLight3D`, `DrawableTexture2D`, `VirtualJoystick`, and changes to `AnimationPlayer` and `Object.is_class`.
- At the start of this work, the grammar lacked `when` and several current annotations, including `@abstract`, `@static_unload`, `@export_category`, `@export_group`, `@export_subgroup`, `@export_tool_button`, and `@warning_ignore*`; API XML updates alone do not cover syntax.

## Plan and progress

- [x] Research latest stable/pre-release Godot versions, review release notes, and inspect the current catalog/update pipeline and grammar.
- [x] Safely refresh bundled stable API catalogs through Godot 4.7: retained existing 3.x/4.0/4.1 archives and added 4.2–4.7 from 4.2.2, 4.3, 4.4.1, 4.5.2, 4.6.3, and 4.7.2 stable tags.
- [x] Make `update-api.sh` non-destructive and independent of private SSH access; validate tag shape and ZIP integrity before replacing a catalog. It leaves `.versions/` untouched and writes the archive to a sibling temporary file before rename.
- [x] Register new catalogs in `VersionService`, default new installations to 4.7 while preserving existing saved selections, and add regression checks for the newly supported API. Focused `VersionServiceTest` passed.
- [x] Extend GDScript grammar/highlighting for `when` guards and current annotations; add lexer/parser regression tests and regenerate sources with the Gradle Grammar-Kit/JFlex tasks.
- [x] Update README and developer instructions for HTTPS-based catalog refresh.
- [x] Run the full test suite after the grammar update; all tests passed.
- [x] Complete plugin package/structure verification (`buildPlugin verifyPluginStructure` passed; distribution created at `build/distributions/intellij-gdscript.zip`). Keep Godot 4.8 beta data out of stable defaults until 4.8 is released.

## Acceptance criteria

- Every advertised stable API version has a non-empty, parseable archive with unique class names and methods/signals/arguments.
- Godot 4.7 API completion/documentation works, and existing version catalogs and saved user selections continue to work.
- An update failure leaves the previous ZIP intact and does not delete a user's `.versions/` directory.
- Grammar changes have focused regression tests and generated files are not edited by hand.

## Sources

- [Godot 4.7.2 maintenance release](https://godotengine.org/article/maintenance-release-godot-4-7-2/)
- [Godot 4.7 release](https://godotengine.org/releases/4.7/)
- [Godot 4.8 beta 3](https://godotengine.org/article/dev-snapshot-godot-4-8-beta-3/)
- [Upgrade guide: Godot 4.5 to 4.6](https://docs.godotengine.org/en/stable/tutorials/migrating/upgrading_to_godot_4.6.html)
- [Upgrade guide: Godot 4.6 to 4.7](https://docs.godotengine.org/en/stable/tutorials/migrating/upgrading_to_godot_4.7.html)
- [GDScript reference](https://docs.godotengine.org/en/stable/tutorials/scripting/gdscript/gdscript_basics.html)
