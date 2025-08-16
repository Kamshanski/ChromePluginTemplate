import optin.defaultOptInOption
import org.jetbrains.kotlin.gradle.dsl.JsSourceMapEmbedMode
import org.jetbrains.kotlin.gradle.dsl.JsSourceMapNamesPolicy
import org.jetbrains.kotlin.gradle.dsl.KotlinJsCompile
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

plugins {
	alias(libs.plugins.kotlinMultiplatform)
	alias(libs.plugins.kotlinxSerialization)
}

kotlin {
	js {
		generateTypeScriptDefinitions()
		useEsModules()
		binaries.executable()
		browser {
			webpackTask {
				mode = KotlinWebpackConfig.Mode.DEVELOPMENT
			}
			commonWebpackConfig {
				cssSupport {
					enabled.set(true)
				}
				devServer = (devServer ?: KotlinWebpackConfig.DevServer()).apply {
					static = (static ?: mutableListOf()).apply {
						// Serve sources to debug inside browser
						add(project.rootDir.path)
						add(project.projectDir.path)
					}
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
			implementation(project(":component-html-customelement"))

			implementation(project(":util-common"))
			implementation(project(":util-w3c-dom"))

			implementation(libs.kotlinxSerialization.core)
			implementation(libs.kotlinxSerialization.json)
			implementation(libs.kotlinxCoroutines.core)
			implementation(libs.kotlinWrappers.kotlinBrowser)
		}
		jsTest.dependencies {
			implementation(libs.kotlin.test)
		}
	}

	compilerOptions {
		optIn.defaultOptInOption()
	}
}

chromePlugin()

tasks.withType<KotlinJsCompile>().configureEach {
	compilerOptions {
		useEsClasses = true
	}
}

tasks.withType<Kotlin2JsCompile>().configureEach {
	compilerOptions.sourceMapNamesPolicy.set(JsSourceMapNamesPolicy.SOURCE_MAP_NAMES_POLICY_FQ_NAMES)
	compilerOptions.sourceMapEmbedSources.set(JsSourceMapEmbedMode.SOURCE_MAP_SOURCE_CONTENT_ALWAYS)
}