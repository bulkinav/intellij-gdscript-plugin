package gdscript.documentation

import BaseTest
import com.intellij.openapi.components.service
import settings.ApplicationSettings
import utils.assertContains

class ScriptGeneratedSourceFileServiceTest : BaseTest() {

    fun `test GDScript file type with correct extension`() {
        val file = getService().getSourceFile("Vector2")!!
        assertEquals("Vector2.gd", file.name)
        assertEquals("GDScript", file.fileType.name)
    }

    fun `test Node3D code`() {
        val text = getService().getSourceFile("Node3D")!!.text
        assertContains("class_name Node3D", text)
        assertContains("extends Node", text)
        assertContains("# Base object in 3D space, inherited by all 3D nodes.", text)
        assertContains("signal visibility_changed()", text)
        assertContains("const NOTIFICATION_VISIBILITY_CHANGED = 43", text)
        assertContains("var position: Vector3 = Vector3(0, 0, 0)", text)
        assertContains("func get_parent_node_3d() -> Node3D:", text)
    }

    fun `test void methods has no explicit type`() {
        val text = getService().getSourceFile("Node3D")!!.text
        assertContains("func show():", text)
    }

    fun `test generated source changes with selected API version`() {
        val settings = service<ApplicationSettings>()
        val previousVersion = settings.versionId
        try {
            settings.versionId = "4.1"
            assertNotNull(getService().getSourceFile("Node3D"))
            settings.versionId = "3.5"
            assertNull(getService().getSourceFile("Node3D"))
        } finally {
            settings.versionId = previousVersion
        }
    }

    private fun getService() =
        environment.project.getService(ScriptGeneratedSourceFileService::class.java)

}
