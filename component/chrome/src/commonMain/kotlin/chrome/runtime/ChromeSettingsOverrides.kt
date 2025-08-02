@file:JsQualifier("chrome.runtime")

package chrome.runtime

import kotlin.js.collections.JsReadonlyArray

external interface ChromeSettingsOverrides {

	var homepage: String?
	var search_provider: SearchProvider?
	var startup_pages: JsReadonlyArray<String>?
}