package gdscript.documentation

object GodotBbCode {

    private val codeBlock = Regex("\\[codeblock](.*?)\\[/codeblock]", setOf(RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL))
    private val url = Regex("\\[url(?:=([^\\]]+))?](.*?)\\[/url]", setOf(RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL))
    private val reference = Regex("\\[(?:method|member|constant|enum|param) ([^\\]]+)]", RegexOption.IGNORE_CASE)

    fun toHtml(bbCode: String): String {
        var html = escapeHtml(bbCode)
        html = codeBlock.replace(html) { "<pre><code>${it.groupValues[1].trim()}</code></pre>" }
        html = Regex("\\[/?(?:codeblocks|gdscript|csharp)]", RegexOption.IGNORE_CASE).replace(html, "")
        html = Regex("\\[code(?: [^\\]]+)?](.*?)\\[/code]", setOf(RegexOption.IGNORE_CASE, RegexOption.DOT_MATCHES_ALL))
            .replace(html) { "<code>${it.groupValues[1]}</code>" }
        html = url.replace(html) { match ->
            val href = match.groupValues[1].ifBlank { match.groupValues[2] }.trim()
            val text = match.groupValues[2]
            if (href.startsWith("https://", true) || href.startsWith("http://", true))
                "<a href=\"$href\">$text</a>"
            else text
        }
        html = reference.replace(html) { "<code>${it.groupValues[1]}</code>" }
        html = Regex("\\[(/?)(b|i|kbd)]", RegexOption.IGNORE_CASE).replace(html) {
            val tag = it.groupValues[2].lowercase()
            if (it.groupValues[1].isEmpty()) "<$tag>" else "</$tag>"
        }
        html = Regex("\\[/color]|\\[color=[^\\]]+]", RegexOption.IGNORE_CASE).replace(html, "")
        html = Regex("\\[/?br/?]", RegexOption.IGNORE_CASE).replace(html, "<br/>")
        return Regex("\\[([A-Za-z_@][A-Za-z0-9_@.]*)]").replace(html) { "<code>${it.groupValues[1]}</code>" }
    }

    private fun escapeHtml(text: String) = text
        .replace("&", "&amp;")
        .replace("<", "&lt;")
        .replace(">", "&gt;")
        .replace("\"", "&quot;")
        .replace("'", "&#39;")
}
