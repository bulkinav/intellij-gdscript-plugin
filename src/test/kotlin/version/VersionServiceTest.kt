package version

import BaseTest
import version.data.Class

class VersionServiceTest : BaseTest() {

    fun `test v3_2`() {
        assertVersion("3.2")
    }

    fun `test v3_3`() {
        assertVersion("3.3")
    }

    fun `test v3_4`() {
        assertVersion("3.4")
    }

    fun `test v3_5`() {
        assertVersion("3.5")
    }

    fun `test v4_0`() {
        assertVersion("4.0")
    }

    fun `test v4_1`() {
        assertVersion("4.1")
    }

    fun `test v4_2`() {
        assertVersion("4.2")
    }

    fun `test v4_3`() {
        assertVersion("4.3")
    }

    fun `test v4_4`() {
        assertVersion("4.4")
    }

    fun `test v4_5`() {
        assertVersion("4.5")
    }

    fun `test v4_6`() {
        assertVersion("4.6")
    }

    fun `test v4_7`() {
        assertVersion("4.7")
    }

    fun `test disabled`() {
        val disabled = VersionService.all().find { it.versionId == "Disabled" }!!
        assertEmpty(disabled.classes)
        assertEmpty(disabled.primitives)
        assertEmpty(disabled.singletons)
        assertEmpty(disabled.globals)
    }

    fun `test v4_7 is default`() {
        assertEquals("4.7", VersionService.current().versionId)
    }

    fun `test v4_7 includes new engine API classes`() {
        val names = VersionService.all().find { it.versionId == "4.7" }!!.classes.map { it.name }
        assertTrue("AreaLight3D" in names)
        assertTrue("DrawableTexture2D" in names)
        assertTrue("VirtualJoystick" in names)
    }

    private companion object {

        private fun assertVersion(id: String) {
            val version = VersionService.all().find { it.versionId == id }!!
            assertNotEmpty(version.classes)
            assertNotEmpty(version.primitives)
            assertNotEmpty(version.singletons)
            assertNotEmpty(version.globals)
            assertNotDuplicatedClasses(version.classes)
            assertNotDuplicatedClasses(version.primitives)
            assertNotDuplicatedClasses(version.singletons)
            assertNotDuplicatedClasses(version.globals)
            assertHasMethodArguments(version.classes)
            assertHasMethodArguments(version.primitives)
            assertHasMethodArguments(version.singletons)
            assertHasMethodArguments(version.globals)
            assertHasSignalArguments(version.classes)
            assertHasSignalArguments(version.singletons)
        }

        private fun assertNotDuplicatedClasses(classes: List<Class>) {
            val areUnique = classes.map { it.name }
                .groupingBy { it }
                .eachCount()
                .filter { it.value > 1 }
                .none()
            assertTrue(areUnique)
        }

        private fun assertHasMethodArguments(classes: List<Class>) {
            val hasArgs = classes.flatMap { it.methods }
                .flatMap { it.arguments }
                .isNotEmpty()
            assertTrue(hasArgs)
        }

        private fun assertHasSignalArguments(classes: List<Class>) {
            val hasArgs = classes.flatMap { it.signals }
                .flatMap { it.arguments }
                .isNotEmpty()
            assertTrue(hasArgs)
        }

    }

}
