import org.gradle.api.Project

fun Project.chromePlugin(setup: ChromePluginSpec.() -> Unit) {
	val spec = ChromePluginSpec(this)
	spec.setup()
	spec.configureProject()
}