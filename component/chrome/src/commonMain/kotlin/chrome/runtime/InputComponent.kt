package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface InputComponent {

	var name: String?
	var type: String?
	var id: String?
	var description: String?
	@Deprecated("Use extension with specified type", replaceWith = ReplaceWith("tabIdList"))
	var language: Any? /* string[] | string | undefined */
	var layouts: JsReadonlyArray<String>?
	var indicator: String?
}