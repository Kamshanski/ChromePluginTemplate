@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface BackgroundV2 {

	var scripts: JsReadonlyArray<String>?
	var page: String?
	var persistent: Boolean?
}