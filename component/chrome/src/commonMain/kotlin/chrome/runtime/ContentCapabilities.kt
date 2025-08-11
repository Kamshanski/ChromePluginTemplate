package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface ContentCapabilities {

	var matches: JsReadonlyArray<String>?
	var permissions: JsReadonlyArray<String>?
}