@file:JsQualifier("chrome.scripting")

package chrome.scripting

external interface InjectionResult<T /* default is null - Nothing?*/> {

	/**
	 * The document associated with the injection.
	 * @since Chrome 106
	 */
	var documentId: String

	/**
	 * The frame associated with the injection.
	 * @since Chrome 90
	 */
	var frameId: Int

	/** The result of the script execution. */
	var result: T
}