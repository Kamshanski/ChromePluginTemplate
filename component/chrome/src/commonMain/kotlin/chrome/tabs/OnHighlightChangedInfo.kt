package chrome.tabs

import kotlin.js.collections.JsReadonlyArray

external interface OnHighlightChangedInfo {

	/** All highlighted tabs in the window. */
	var tabIds: JsReadonlyArray<Double>

	/** The window whose tabs changed. */
	var windowId: Int
}