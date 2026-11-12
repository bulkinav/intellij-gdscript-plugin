#!/bin/sh

set -eu
root=$(CDPATH= cd "$(dirname "$0")" && pwd)

if [ "$#" -eq 0 ]; then
  echo "Usage: $0 <Godot-tag-or-version>... (e.g. 3.5 4.1 4.7.2-stable)" >&2
  exit 2
fi

tmp=$(mktemp -d "${TMPDIR:-/tmp}/godot-api.XXXXXX")
archive_tmp=
cleanup() {
  rm -rf "$tmp"
  if [ -n "$archive_tmp" ]; then rm -f "$archive_tmp"; fi
}
trap cleanup EXIT
trap 'exit 1' HUP INT TERM

for ref in "$@"; do
  if ! printf '%s\n' "$ref" | grep -Eq '^[0-9]+(\.[0-9]+){1,2}(-stable)?$'; then
    echo "Invalid Godot version/tag: $ref" >&2
    exit 2
  fi

  version=$(printf '%s' "${ref%-stable}" | cut -d. -f1-2)
  checkout="$tmp/$version"
  archive="$root/src/main/resources/version/$version.zip"

  echo "Updating API catalog $version from Godot ref $ref"
  git clone --quiet --depth 1 --filter=blob:none --sparse \
    --branch "$ref" https://github.com/godotengine/godot.git "$checkout"
  git -C "$checkout" sparse-checkout set doc/classes modules/gdscript/doc_classes

  test -d "$checkout/doc/classes"
  test -s "$checkout/modules/gdscript/doc_classes/@GDScript.xml"
  archive_tmp=$(mktemp "$archive.tmp.XXXXXX")
  rm "$archive_tmp"
  (
    cd "$checkout"
    zip -q -r "$archive_tmp" doc/classes modules/gdscript/doc_classes/@GDScript.xml
  )
  unzip -tq "$archive_tmp"
  unzip -Z1 "$archive_tmp" | grep -q 'modules/gdscript/doc_classes/@GDScript.xml$'
  mv "$archive_tmp" "$archive"
  archive_tmp=
done
