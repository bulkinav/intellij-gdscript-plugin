import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType
import org.jetbrains.intellij.platform.gradle.TestFrameworkType

plugins {
    java
    id("org.jetbrains.kotlin.jvm") version "2.3.0"
    id("org.jetbrains.intellij.platform") version "2.20.1"
    id("org.jetbrains.intellij.platform.grammarkit") version "2.20.1"
}

repositories {
    mavenCentral()
    intellijPlatform { defaultRepositories() }
}

dependencies {
    implementation(kotlin("stdlib"))
    // WebStorm supplies jsoup; packaging an older copy breaks its own HTML renderer.
    compileOnly("org.jsoup:jsoup:1.16.1")
    implementation("net.pearx.kasechange:kasechange-jvm:1.4.1")

    testImplementation("io.mockk:mockk:1.13.5")
    testImplementation("junit:junit:4.13.2")
    intellijPlatform {
        webstorm("2026.2")
        testFramework(TestFrameworkType.Platform)
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

kotlin {
    jvmToolchain(25)
}

sourceSets {
    main { java.srcDir("gen") }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "262"
            untilBuild = provider { null }
        }
    }
    publishing {
        token = providers.gradleProperty("publishPluginToken")
        channels = listOf("stable")
    }
    pluginVerification {
        ides {
            create(IntelliJPlatformType.WebStorm, "2026.2")
            create(IntelliJPlatformType.WebStorm, "2026.3")
        }
    }
}

tasks.test {
    useJUnit()
}

tasks {
    generateParser {
        sourceFile.set(file("grammar/ScriptParser.bnf"))
        targetRootOutputDir.set(file("gen"))
        pathToParser.set("gdscript/parser/ScriptParser.java")
        pathToPsiRoot.set("gdscript/psi")
    }
    generateLexer {
        sourceFile.set(file("grammar/_ScriptLexer.flex"))
        targetRootOutputDir.set(file("gen"))
        pathToClass.set("gdscript/parser/_ScriptLexer.java")
    }
}
