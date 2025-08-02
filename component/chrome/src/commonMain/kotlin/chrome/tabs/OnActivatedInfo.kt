@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface OnActivatedInfo {

	/** The ID of the tab that has become active. */
	var tabId: Int

	/** The ID of the window the active tab changed inside of. */
	var windowId: Int
}