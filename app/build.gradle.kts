import org.jetbrains.kotlin.gradle.dsl.JsSourceMapEmbedMode
import org.jetbrains.kotlin.gradle.dsl.JsSourceMapNamesPolicy
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
	alias(libs.plugins.kotlinMultiplatform)
	alias(libs.plugins.kotlinxSerialization)
}

kotlin {
	js {
		binaries.executable()
		browser {
			commonWebpackConfig {
				cssSupport {
					enabled.set(true)
				}
			}
			testTask {
				testLogging.showStandardStreams = true
				useKarma {
					useChromeHeadless()
				}
			}
		}
	}

	sourceSets {
		jsMain.dependencies {
			implementation(project(":component-log"))
			implementation(project(":component-browserdocument"))

			implementation(libs.kotlinxSerialization.core)
			implementation(libs.kotlinxSerialization.json)
		}
		jsTest.dependencies {
			implementation(libs.kotlin.test)
		}
	}
}

chromePlugin {

}

tasks.withType<Kotlin2JsCompile>().configureEach {
	compilerOptions.sourceMapNamesPolicy.set(JsSourceMapNamesPolicy.SOURCE_MAP_NAMES_POLICY_FQ_NAMES)
	compilerOptions.sourceMapEmbedSources.set(JsSourceMapEmbedMode.SOURCE_MAP_SOURCE_CONTENT_ALWAYS)
}