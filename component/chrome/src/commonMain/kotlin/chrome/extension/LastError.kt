@file:JsQualifier("chrome.extension")

package chrome.extension

external interface LastError {

	/** Description of the error that has taken place. */
	var message: String
}