@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface LastError {

	/** Details about the error which occurred.  */
	var message: String?
}