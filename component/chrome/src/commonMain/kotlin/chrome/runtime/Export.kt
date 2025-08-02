@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface Export {

	var whitelist: JsReadonlyArray<String>?
}