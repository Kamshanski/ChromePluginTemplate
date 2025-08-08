import optin.defaultOptInOption
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig.Mode.DEVELOPMENT

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    js {
        binaries.library()
        browser {
            webpackTask {
                // TODO Remove this line in production
                mode = DEVELOPMENT
            }
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
            implementation(project(":util-common"))
            implementation(libs.kotlinxCoroutines.core)
        }
    }

    compilerOptions {
        optIn.defaultOptInOption()
    }
}