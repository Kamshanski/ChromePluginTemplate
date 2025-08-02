@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface GroupCreateProperties {

	/** The window of the new group. Defaults to the current window. */
	var windowId: Int?
}