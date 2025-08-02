@file:JsQualifier("chrome.runtime")

package chrome.runtime

external interface Command {

	var suggested_key: SuggestedKey?
	var description: String?
	var global: Boolean?
}