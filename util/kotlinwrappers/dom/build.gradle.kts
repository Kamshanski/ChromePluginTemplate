import optin.defaultOptInOption

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    js {
        binaries.library()
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
            implementation(project(":util-common"))

            implementation(libs.kotlinWrappers.kotlinBrowser)
        }
    }

    compilerOptions {
        optIn.defaultOptInOption()
    }
}