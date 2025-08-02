@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface Sandbox {

	var pages: JsReadonlyArray<String>
	var content_security_policy: String?
}