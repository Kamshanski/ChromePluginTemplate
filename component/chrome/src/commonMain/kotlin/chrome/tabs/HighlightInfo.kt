@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface HighlightInfo {

	/** One or more tab indices to highlight. */
	@Deprecated("Use extension with specified type", replaceWith = ReplaceWith("tabList"))
	var tabs: Any /* number | number[] */

	/** The window that contains the tabs. */
	var windowId: Int?
}