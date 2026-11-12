package version

import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import org.jsoup.Jsoup
import settings.ApplicationSettings
import version.data.Class
import version.data.ClassDocumentation
import version.data.Version
import java.io.ByteArrayInputStream
import java.util.concurrent.ConcurrentHashMap
import java.util.zip.ZipInputStream

@Service
class VersionService {

    private val versionResources = listOf(
        "3.2" to "version/3.2.zip",
        "3.3" to "version/3.3.zip",
        "3.4" to "version/3.4.zip",
        "3.5" to "version/3.5.zip",
        "4.0" to "version/4.0.zip",
        "4.1" to "version/4.1.zip",
        "4.2" to "version/4.2.zip",
        "4.3" to "version/4.3.zip",
        "4.4" to "version/4.4.zip",
        "4.5" to "version/4.5.zip",
        "4.6" to "version/4.6.zip",
        "4.7" to "version/4.7.zip"
    )
    private val versions: List<Version> = versionResources.map { (id, path) -> loadVersion(id, path) } +
        Version("Disabled", emptyList(), emptyList(), emptyList(), emptyList())
    private val documentationCache = ConcurrentHashMap<Pair<String, String>, ClassDocumentation>()

    private fun loadVersion(versionId: String, resourcePath: String): Version {
        val classes: List<Class> = readEntries(resourcePath)
        val (primitives, nonPrimitives) = classes.partition { it.name in listOf("float", "int", "bool", "void") }
        val (globals, nonGlobals) = nonPrimitives.partition { it.name.startsWith("@") }
        val singletonNames = globals.flatMap { it.fields }.map { it.name }
        val (singletons, instanced) = nonGlobals.partition { it.name in singletonNames }
        return Version(versionId, instanced, primitives, singletons, globals)
    }

    private fun readEntries(path: String): List<Class> {
        val zip = ZipInputStream(javaClass.classLoader.getResourceAsStream(path)!!)
        val classes = mutableListOf<Class>()
        var entry = zip.nextEntry
        while (entry != null) {
            if (entry.size > 0 && entry.name.endsWith(".xml")) {
                val byteStream = ByteArrayInputStream(zip.readBytes())
                val doc = Jsoup.parse(byteStream, "UTF-8", "")
                classes += parseClass(doc)
            }
            zip.closeEntry()
            entry = zip.nextEntry
        }
        return classes
    }

    private fun loadDocumentation(versionId: String, className: String): ClassDocumentation? {
        if (!className.matches(Regex("[A-Za-z0-9_@]+"))) return null
        val path = versionResources.find { it.first == versionId }?.second ?: return null
        val resource = javaClass.classLoader.getResourceAsStream(path) ?: return null
        ZipInputStream(resource).use { zip ->
            var entry = zip.nextEntry
            while (entry != null) {
                if (entry.name == "doc/classes/$className.xml") {
                    val doc = Jsoup.parse(ByteArrayInputStream(zip.readBytes()), "UTF-8", "")
                    return parseClassDocumentation(doc)
                }
                zip.closeEntry()
                entry = zip.nextEntry
            }
        }
        return null
    }

    private fun classDocumentation(versionId: String, className: String): ClassDocumentation? {
        val key = versionId to className
        return documentationCache[key] ?: loadDocumentation(versionId, className)?.also { documentationCache[key] = it }
    }

    companion object {

        const val DEFAULT_VERSION = "4.7"

        fun current(): Version {
            val versionService = service<VersionService>().versions
            val settingsVersionId = service<ApplicationSettings>().versionId
            return versionService.find { it.versionId == settingsVersionId }
                ?: versionService.find { it.versionId == DEFAULT_VERSION }!!
        }

        fun documentation(className: String): ClassDocumentation? {
            val service = service<VersionService>()
            return service.classDocumentation(current().versionId, className)
        }

        fun all(): List<Version> =
            service<VersionService>().versions

    }

}
