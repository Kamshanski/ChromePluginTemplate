@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface WebAccessibleResource {

	var resources: JsReadonlyArray<String>
	var matches: JsReadonlyArray<String>
}