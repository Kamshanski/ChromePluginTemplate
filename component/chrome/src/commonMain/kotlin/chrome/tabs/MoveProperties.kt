@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface MoveProperties {

	/** The position to move the window to. Use `-1` to place the tab at the end of the window. */
	var index: Int

	/** Defaults to the window the tab is currently in. */
	var windowId: Int?
}