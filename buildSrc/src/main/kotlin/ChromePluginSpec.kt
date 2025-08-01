import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.file.DuplicatesStrategy.FAIL

private const val PluginOutputFolderCleanTask = "pluginOutputFolderClean"
private const val JsBrowserDistributionTask = "jsBrowserDistribution"
private const val AssembleChromePluginTask = "assembleChromePlugin"

class ChromePluginSpec(private val project: Project) {

	/**
	 * Folder in which kotlin multiplatform plugin places final build script, source map and resources
	 */
	var distributionCompilationOutputDir: String = "build/dist"

	/**
	 * Final chrome plugin will be placed in [outputPluginDir] after assembling
	 */
	var outputPluginDir: String = "build/pluginBuildOutput"

	private val modulesOfInjectableScripts = mutableListOf<InjectableScriptModule>()

	fun injectableScriptModule(moduleName: String, distributionOutputFolder: String) {
		modulesOfInjectableScripts.add(
			InjectableScriptModule(moduleName = moduleName, distributionOutputFolder = distributionOutputFolder)
		)
		// TODO Add support for injectable scripts
	}

	internal fun configureProject() {
		registerPluginOutputFolderClearTask()
		registerAssembleTask()
	}

	private fun registerPluginOutputFolderClearTask(): Task =
		with(project) {
			tasks.create(PluginOutputFolderCleanTask) {
				val outputPluginFolder = outputPluginDir
				doFirst {
					delete {
						delete(outputPluginFolder)
					}
				}
			}
		}

	private fun registerAssembleTask() {
		with(project) {
			// This task copies the compilation result (script, resources, html, css) of the plugin into the final folder.
			tasks.create(AssembleChromePluginTask) {
				dependsOn(PluginOutputFolderCleanTask)
				dependsOn(JsBrowserDistributionTask)

				val kotlinJsOutputFolder = distributionCompilationOutputDir
				val outputPluginFolder = outputPluginDir
				doLast {
					copy {
						duplicatesStrategy = FAIL
						from(kotlinJsOutputFolder)
						into(outputPluginFolder)
					}
				}
			}
		}
	}
}