package settings

import BaseTest
import com.intellij.openapi.components.service

class ApplicationSettingsConfigurableTest : BaseTest() {

    fun `test GUI modifies settings`() {
        val gui = ApplicationSettingsConfigurable()
        assertFalse(gui.isModified)
        service<ApplicationSettings>().versionId = "1.2.3"
        assertTrue(gui.isModified)
    }

}
