package gdscript.documentation

import com.intellij.lang.documentation.AbstractDocumentationProvider
import com.intellij.lang.documentation.DocumentationMarkup.*
import com.intellij.psi.PsiElement
import version.VersionService
import version.data.Argument
import version.data.Class

class ScriptDocumentationProvider : AbstractDocumentationProvider() {

    override fun generateDoc(element: PsiElement?, originalElement: PsiElement?): String? {
        val clazz = findClass(originalElement)
            ?: return null
        val documentation = VersionService.documentation(clazz.name)
        return listOf(
            DEFINITION_START,
            clazz.name,
            DEFINITION_END,
            CONTENT_START,
            "<div>${GodotBbCode.toHtml(documentation?.description?.ifBlank { clazz.briefDescription } ?: clazz.briefDescription)}</div>",
            "<br/>",
            generateDocList("Properties", clazz.fields.map {
                (it.name + if (it.default != null) " = ${it.default}" else "") to documentation?.fields?.get(it.name).orEmpty()
            }),
            generateDocList("Methods", clazz.methods.map {
                (it.name + "(" + joinArguments(it.arguments) + ")" + if (it.type != "void") " -> ${it.type}" else "") to
                    documentation?.methods?.get(it.name).orEmpty()
            }),
            generateDocList("Constants", clazz.constants.map { (it.name + " = " + it.value) to "" }),
            generateDocList("Signals", clazz.signals.map {
                (it.name + if (it.arguments.isNotEmpty()) "(" + joinArguments(it.arguments) + ")" else "") to ""
            }),
            CONTENT_END
        ).joinToString("")
    }

    override fun getQuickNavigateInfo(element: PsiElement?, originalElement: PsiElement?): String? {
        val clazz = findClass(originalElement)
            ?: return null
        val extends = if (clazz.extends?.isNotEmpty() == true) " extends ${clazz.extends}" else ""
        return "class ${clazz.name}" + extends
    }

    private fun findClass(element: PsiElement?): Class? {
        val current = VersionService.current()
        return (current.classes + current.singletons + current.primitives)
            .find { it.name == element?.text }
    }

    private fun joinArguments(arguments: List<Argument>) =
        arguments.joinToString(", ") { arg -> arg.name + ": " + arg.type }

    private fun generateDocList(title: String, list: List<Pair<String, String>>): String =
        if (list.isEmpty())
            ""
        else
            "<h3>$title</h3><ul>${list.joinToString("") { (signature, description) ->
                "<li><code>${escapeHtml(signature)}</code>" +
                    if (description.isBlank()) "</li>" else "<div>${GodotBbCode.toHtml(description)}</div></li>"
            }}</ul>"

    private fun escapeHtml(text: String) = text
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;")
        .replace("'", "&#39;")

}
