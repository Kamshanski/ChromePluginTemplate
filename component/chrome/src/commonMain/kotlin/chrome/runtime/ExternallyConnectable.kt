@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface ExternallyConnectable {

	var ids: JsReadonlyArray<String>?
	var matches: JsReadonlyArray<String>?
	var accepts_tls_channel_id: Boolean?
}