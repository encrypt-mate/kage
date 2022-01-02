import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
  kotlin("jvm")
  id("com.diffplug.spotless")
}

kotlin { explicitApi() }

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
  kotlinOptions { moduleName = "kage" }
}

configure<SpotlessExtension> {
  kotlin {
    ktfmt().googleStyle()
    target("**/*.kt")
    targetExclude("**/build/")
  }
  kotlinGradle {
    ktfmt().googleStyle()
    target("**/*.kts")
  }
}

sourceSets {
  named("main") { java.srcDirs("src/kotlin") }
  named("test") { java.srcDirs("test/kotlin") }
}

dependencies {
  implementation("at.favre.lib:hkdf:1.1.0")
  testImplementation(libs.kotlintest.junit)
}

tasks.withType<Test>().configureEach {
  maxParallelForks = Runtime.getRuntime().availableProcessors() * 2
  testLogging { events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED) }
  outputs.upToDateWhen { false }
}
