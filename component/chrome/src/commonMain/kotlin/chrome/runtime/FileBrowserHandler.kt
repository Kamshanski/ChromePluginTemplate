package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface FileBrowserHandler {

	var id: String?
	var default_title: String?
	var file_filters: JsReadonlyArray<String>?
}