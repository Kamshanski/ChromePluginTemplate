package chrome.action

/** @since Chrome 99 */
external interface OpenPopupOptions {

	/** The id of the window to open the action popup in. Defaults to the currently-active window if unspecified.  */
	var windowId: Int?
}

fun OpenPopupOptions(
	/** The id of the window to open the action popup in. Defaults to the currently-active window if unspecified.  */
	windowId: Int? = null,
): OpenPopupOptions =
	js("{}").unsafeCast<OpenPopupOptions>().apply {
		this.windowId = windowId
	}