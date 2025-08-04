package chrome.scripting

/**
 * The JavaScript world for a script to execute within.
 * @since Chrome 95
 */
typealias ExecutionWorld = String

/**
 * @see ExecutionWorld
 */
enum class ExecutionWorldEnum {

	/** Specifies the isolated world, which is the execution environment unique to this extension. */
	ISOLATED,
	/** Specifies the main world of the DOM, which is the execution environment shared with the host page's JavaScript. */
	MAIN,
	;

	val value: ExecutionWorld = name.lowercase()

	companion object {

		fun enumValueOf(value: ExecutionWorld): ExecutionWorldEnum = valueOf(value)
	}
}