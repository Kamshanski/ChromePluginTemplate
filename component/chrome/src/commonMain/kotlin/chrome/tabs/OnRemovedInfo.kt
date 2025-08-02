@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface OnRemovedInfo {

	/** True when the tab was closed because its parent window was closed. */
	var isWindowClosing: Boolean

	/** The window whose tab is closed */
	var windowId: Int
}