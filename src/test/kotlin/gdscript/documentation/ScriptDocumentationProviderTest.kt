package gdscript.documentation

import BaseTest
import com.intellij.psi.PsiElement
import io.mockk.every
import io.mockk.mockk
import utils.assertContains

class ScriptDocumentationProviderTest : BaseTest() {

    fun `test float primitive`() {
        val docs = getDocumentation("float")
        assertContains("<div class='definition'><pre>float</pre></div>", docs)
        assertContains("<div class='content'>", docs)
        assertContains("<h3>Methods</h3>", docs)
        assertContains("<ul>", docs)
        assertContains("<li><code>float(from: bool) -&gt; float</code>", docs)
        assertContains("</ul>", docs)
        assertContains("</div>", docs)
    }

    fun `test RigidBody2D class`() {
        val docs = getDocumentation("RigidBody2D")
        assertContains("<h3>Properties</h3>", docs)
        assertContains("<li><code>angular_velocity = 0.0</code>", docs)
        assertContains("<h3>Methods</h3>", docs)
        assertContains("<li><code>get_colliding_bodies() -&gt; Node2D[]</code>", docs)
        assertContains("<h3>Constants</h3>", docs)
        assertContains("<li><code>FREEZE_MODE_KINEMATIC = 1</code></li>", docs)
        assertContains("<h3>Signals</h3", docs)
        assertContains("<li><code>body_entered(body: Node)</code></li>", docs)
    }

    fun `test RenderingServer singleton`() {
        val docs = getDocumentation("RenderingServer")
        assertContains("<h3>Methods</h3>", docs)
        assertContains("<li><code>canvas_item_set_material(item: RID, material: RID)</code>", docs)
    }

    fun `test class method and field descriptions`() {
        val dirAccess = getDocumentation("DirAccess")
        assertContains("This class is used to manage directories", dirAccess)
        assertContains("Creates a new <code>DirAccess</code> object", dirAccess)

        val node = getDocumentation("Node")
        assertContains("An optional description to the node", node)
    }

    fun `test Godot BBCode is rendered safely`() {
        assertEquals(
            "<b>Bold</b> <code>Node</code> <code>float</code> <a href=\"https://godotengine.org\">Godot</a> &lt;script&gt;",
            GodotBbCode.toHtml("[b]Bold[/b] [Node] [float] [url=https://godotengine.org]Godot[/url] <script>")
        )
        assertEquals("x", GodotBbCode.toHtml("[url=javascript:alert(1)]x[/url]"))
    }

    private fun getDocumentation(psiElementText: String): String {
        val element = mockk<PsiElement>(relaxed = true)
        every { element.text } returns psiElementText
        return ScriptDocumentationProvider().generateDoc(element, element)!!
    }

}
