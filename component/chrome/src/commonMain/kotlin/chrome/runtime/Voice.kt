@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface Voice {

	var voice_name: String
	var lang: String?
	var gender: String?
	var event_types: JsReadonlyArray<String>?
}