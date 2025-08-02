@file:JsQualifier("chrome.tabs")

package chrome.tabs

external interface CreateProperties {

	/** The position the tab should take in the window. The provided value is clamped to between zero and the number of tabs in the window. */
	var index: Int?

	/** The ID of the tab that opened this tab. If specified, the opener tab must be in the same window as the newly created tab. */
	var openerTabId: Int?

	/** The URL to initially navigate the tab to. Fully-qualified URLs must include a scheme (i.e., 'http://www.google.com', not 'www.google.com'). Relative URLs are relative to the current page within the extension. Defaults to the New Tab Page. */
	var url: String?

	/** Whether the tab should be pinned. Defaults to `false` */
	var pinned: Boolean?

	/** The window in which to create the new tab. Defaults to the current window. */
	var windowId: Int?

	/** Whether the tab should become the active tab in the window. Does not affect whether the window is focused (see {@link windows.update}). Defaults to `true`. */
	var active: Boolean?

	/**
	 * Whether the tab should become the selected tab in the window. Defaults to `true`
	 * @deprecated since Chrome 33. Please use {@link CreateProperties.active active}.
	 */
	var selected: Boolean?
}