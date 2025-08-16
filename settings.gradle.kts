enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
	repositories {
		google()
		gradlePluginPortal()
		mavenCentral()
	}
}

dependencyResolutionManagement {
	repositories {
		google()
		mavenCentral()
	}
}

fun includeDashedProject(dashedName: String) {
	val path = dashedName.trimStart(':').replace("-", "/")

	include(dashedName)
	project(dashedName).projectDir = file("$rootDir/$path")
}

rootProject.name = "ChromePluginTemplate"
includeDashedProject(":app")
includeDashedProject(":component-log")
includeDashedProject(":component-html-customelement")
includeDashedProject(":component-chrome")

includeDashedProject(":util-dom")
includeDashedProject(":util-common")