@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface UpdateCheckDetails {

	/** The version of the available update. */
	var version: String
}