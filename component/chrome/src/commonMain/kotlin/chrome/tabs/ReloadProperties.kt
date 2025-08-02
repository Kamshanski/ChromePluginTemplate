@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface ReloadProperties {

	/** Whether to bypass local caching. Defaults to `false`. */
	var bypassCache: Boolean?
}