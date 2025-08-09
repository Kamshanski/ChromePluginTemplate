@file:JsQualifier("chrome.action")

package chrome.action

/** @since Chrome 99 */
external interface OpenPopupOptions {

	/** The id of the window to open the action popup in. Defaults to the currently-active window if unspecified.  */
	var windowId: Int?
}