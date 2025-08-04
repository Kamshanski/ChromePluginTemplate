package chrome.scripting

import chrome.scripting.constant.ExecutionWorldJsEnum

/**
 * The JavaScript world for a script to execute within.
 * @since Chrome 95
 */
typealias ExecutionWorld = String

/**
 * @see ExecutionWorld
 */
enum class ExecutionWorldEnum(private val valueProvider: ExecutionWorldJsEnum.() -> ExecutionWorld) {

	/** Specifies the isolated world, which is the execution environment unique to this extension. */
	ISOLATED({ ISOLATED }),
	/** Specifies the main world of the DOM, which is the execution environment shared with the host page's JavaScript. */
	MAIN({ MAIN });

	val value: ExecutionWorld get() = valueProvider(ExecutionWorldJsEnum)

	companion object {

		fun enumValueOf(value: ExecutionWorld): ExecutionWorldEnum = valueOf(value)
	}
}