import optin.defaultOptInOption
import org.gradle.api.file.DuplicatesStrategy.FAIL
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
			implementation(project(":component-chrome"))

			implementation(project(":util-common"))
			implementation(project(":util-dom"))

			implementation(libs.kotlinxSerialization.core)
			implementation(libs.kotlinxSerialization.json)
			implementation(libs.kotlinxCoroutines.core)
		}
		jsTest.dependencies {
			implementation(libs.kotlin.test)
			implementation(libs.kotlin.test.js)
			implementation(libs.kotlinxCoroutines.test)
		}
	}

	compilerOptions {
		optIn.defaultOptInOption()
	}
}

chromePlugin {

}

tasks.withType<Kotlin2JsCompile>().configureEach {
	compilerOptions.sourceMapNamesPolicy.set(JsSourceMapNamesPolicy.SOURCE_MAP_NAMES_POLICY_FQ_NAMES)
	compilerOptions.sourceMapEmbedSources.set(JsSourceMapEmbedMode.SOURCE_MAP_SOURCE_CONTENT_ALWAYS)
}